package com.zshy.component.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zshy.component.entity.SysAttachment;
import org.springframework.web.multipart.MultipartFile;
import com.zshy.core.common.api.Result;
import com.zshy.core.database.entity.Search;

/**
 * <p>
 * 附件表 服务类
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-08-09
 */
public interface ISysAttachmentService extends IService<SysAttachment> {

	/**
	 * 附件分页列表
	 *
	 * @param search 查询参数
	 * @return 分页列表
	 */
	IPage<SysAttachment> listPage(Search search);

	/**
	 * 附件上传
	 *
	 * @param file 上传文件
	 * @return 上传结果
	 */
	Result<?> upload(MultipartFile file);

	/**
	 * 附件删除
	 *
	 * @param id 附件ID
	 * @return boolean
	 */
	boolean delete(Long id);

}
