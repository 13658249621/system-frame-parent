package com.system.frame.api;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.Notice;
import com.system.frame.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/notice")
@Api(description = "社区公告模块相关接口",tags = {"社区公告模块接口"})
public class NoticeController  extends BaseController {

    @Autowired
    private NoticeService noticeService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "发布社区公告", notes = "发布社区公告")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)Notice notice) {
        try {
            this.noticeService.save(notice);
        }catch (Exception e){
            return ResponseData.error("发布社区公告失败");
        }
        return ResponseData.success("发布社区公告成功",notice);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)Notice notice) {
        try {
            this.noticeService.updateById(notice);
        }catch (Exception e){
            return ResponseData.error("修改失败");
        }
        return ResponseData.success("修改成功",notice);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)Notice notice) {
      this.noticeService.removeById(notice.getNoticeid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)Notice notice) {
       Notice detail = this.noticeService.getById(notice.getNoticeid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "根据发布时间查询(不传参查询所有社区公告)", notes = "根据发布时间查询(不传参查询所有社区公告)")
    public PageInfo list(@ApiParam(value = "对象", required = true)Notice notice) {
       return this.noticeService.getPageList(notice);
    }
}


