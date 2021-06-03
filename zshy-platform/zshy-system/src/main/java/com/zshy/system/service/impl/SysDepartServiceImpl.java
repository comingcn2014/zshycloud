package com.zshy.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zshy.system.dto.DepartDTO;
import com.zshy.system.entity.SysDepart;
import com.zshy.system.mapper.SysDepartMapper;
import com.zshy.system.poi.SysDepartPOI;
import com.zshy.system.vo.SysDepartVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.zshy.core.web.tree.ForestNodeMerger;
import com.zshy.system.service.ISysDepartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-06-28
 */
@Service
public class SysDepartServiceImpl extends ServiceImpl<SysDepartMapper, SysDepart> implements ISysDepartService {

	@Override
	public List<SysDepartVO> tree() {
		return baseMapper.tree();
	}

	@Override
	public List<SysDepartVO> searchList(Map<String, Object> search) {
		String keyword = String.valueOf(search.get("keyword"));
		String startDate = String.valueOf(search.get("startDate"));
		String endDate = String.valueOf(search.get("endDate"));
		LambdaQueryWrapper<SysDepart> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		if (StrUtil.isNotBlank(startDate) && !startDate.equals("null")) {
			lambdaQueryWrapper.between(SysDepart::getCreateTime, startDate, endDate);
		}
		if (StrUtil.isNotBlank(keyword) && !keyword.equals("null")) {
			lambdaQueryWrapper.like(SysDepart::getName, keyword);
			lambdaQueryWrapper.or();
			lambdaQueryWrapper.like(SysDepart::getId, keyword);
		}
		List<SysDepart> sysDeparts = this.baseMapper.selectList(lambdaQueryWrapper);
		List<SysDepartVO> sysDepartVOS = sysDeparts.stream().map(sysDepart -> {
			SysDepartVO sysDepartVO = new SysDepartVO();
			BeanUtils.copyProperties(sysDepart, sysDepartVO);
			return sysDepartVO;
		}).collect(Collectors.toList());
		return ForestNodeMerger.merge(sysDepartVOS);
	}

	@Override
	public List<SysDepartPOI> export() {
		LambdaQueryWrapper<SysDepart> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(SysDepart::getIsDeleted, 0);
		List<SysDepart> sysDeparts = this.baseMapper.selectList(queryWrapper);
		return sysDeparts.stream().map(sysDepart -> {
			SysDepartPOI sysDepartPOI = new SysDepartPOI();
			BeanUtils.copyProperties(sysDepart, sysDepartPOI);
			return sysDepartPOI;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Long> selectDeptIds(Long deptId) {
		DepartDTO depart = this.getDepart(deptId);
		List<Long> departIdList = new ArrayList<>();
		if (depart != null) {
			departIdList.add(depart.getId());
			addDeptIdList(departIdList, depart);
		}
		return departIdList;
	}

	private DepartDTO getDepart(Long id) {
		List<SysDepart> departs = this.list(Wrappers.<SysDepart>query().lambda()
				.select(SysDepart::getId, SysDepart::getName, SysDepart::getParentId,
						SysDepart::getSort, SysDepart::getCreateTime));

		List<DepartDTO> sysDeparts = departs.stream().map(sysDepart -> {
			DepartDTO departDTO = new DepartDTO();
			BeanUtils.copyProperties(sysDepart, departDTO);
			return departDTO;
		}).collect(Collectors.toList());

		Map<Long, DepartDTO> map = sysDeparts.stream().collect(
				Collectors.toMap(SysDepart::getId, department -> department));
		for (DepartDTO dept : map.values()) {
			DepartDTO parent = map.get(dept.getParentId());
			if (parent != null) {
				List<DepartDTO> children = parent.getChildren() == null ? new ArrayList<>() : parent.getChildren();
				children.add(dept);
				parent.setChildren(children);
			}
		}
		return map.get(id);
	}

	private void addDeptIdList(List<Long> deptIdList, DepartDTO department) {
		List<DepartDTO> children = department.getChildren();
		if (children != null) {
			for (DepartDTO d : children) {
				deptIdList.add(d.getId());
				addDeptIdList(deptIdList, d);
			}
		}
	}
}
