package com.system.frame.api;


import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.Fix;
import com.system.frame.service.FixService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/fix")
@Api(description = "报修模块相关接口",tags = {"报修模块接口"})
public class FixController  extends BaseController {

    @Autowired
    private FixService fixService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "提交报修", notes = "提交报修")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)Fix fix) {
        try {
            this.fixService.save(fix);
        }catch (Exception e){
            return ResponseData.error("报修提交失败");
        }
        return ResponseData.success("报修提交成功",fix);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "管理报修", notes = "管理报修")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)Fix fix) {
        try {
            this.fixService.updateById(fix);
        }catch (Exception e){
            return ResponseData.error("修改失败");
        }
        return ResponseData.success("修改成功",fix);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)Fix fix) {
      this.fixService.removeById(fix.getFixid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)Fix fix) {
       Fix detail = this.fixService.getById(fix.getFixid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "不传参查询所有报修(传入相关参数可根据用户名、状态查询报修)", notes = "不传参查询所有报修(传入相关参数可根据用户名、状态查询报修")
    public PageInfo list(@ApiParam(value = "对象", required = true)Fix fix) {
       return this.fixService.getPageList(fix);
    }
}


