package com.zshy.component.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.zshy.component.service.ISysAttachmentService;
import com.zshy.core.auth.annotation.PreAuth;
import com.zshy.core.common.api.Result;
import com.zshy.core.database.entity.Search;
import com.zshy.core.log.annotation.Log;
import com.zshy.core.web.controller.BaseController;
import com.zshy.core.web.util.CollectionUtil;

import java.util.Collection;
import java.util.Iterator;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 *
 * @author yanghaifeng
 * @since 2020-08-09
 */
@RestController
@AllArgsConstructor
@RequestMapping("/attachment")
@Api(tags = "附件管理")
public class SysAttachmentController extends BaseController {

    private final ISysAttachmentService sysAttachmentService;

    /**
     * 附件分页
     * @param search　关键词
     * @return Result
     */
    @PreAuth
    @Log(value = "附件分页", exception = "附件分页请求异常")
    @GetMapping("/page")
    @ApiOperation(value = "附件分页", notes = "附件分页，根据query查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", required = true, value = "当前页", paramType = "form"),
            @ApiImplicitParam(name = "size", required = true, value = "每页显示数据", paramType = "form"),
            @ApiImplicitParam(name = "keyword", required = true, value = "模糊查询关键词", paramType = "form"),
            @ApiImplicitParam(name = "startDate", required = true, value = "创建开始日期", paramType = "form"),
            @ApiImplicitParam(name = "endDate", required = true, value = "创建结束日期", paramType = "form"),
    })
    public Result<?> page(Search search) {
        return Result.data(sysAttachmentService.listPage(search));
    }

    /**
     * 附件上传
     * @param file　文件
     * @return Result
     */
    @Log(value = "附件上传", exception = "附件上传请求异常")
    @ApiOperation(value = "附件上传", notes = "附件上传")
    @PostMapping("/upload")
    public Result<?> upload(@RequestParam("file") MultipartFile file) {
        return sysAttachmentService.upload(file);
    }

    /**
     * 删除文件
     * @param ids id多个采用逗号分隔
     * @return
     */
    @PreAuth
    @Log(value = "删除文件", exception = "删除文件请求异常")
    @ApiOperation(value = "删除文件", notes = "删除文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    @PostMapping("/del")
    public Result<?> del(@RequestParam String ids) {
        Collection collection = CollectionUtil.stringToCollection(ids);
        for (Iterator<Long> it = collection.iterator(); it.hasNext(); ) {
            long id = it.next();
            sysAttachmentService.delete(id);
        }
        return Result.success("删除成功");
    }
}

