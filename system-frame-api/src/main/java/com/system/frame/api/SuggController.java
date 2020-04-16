package com.system.frame.api;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.Sugg;
import com.system.frame.service.SuggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/sugg")
@Api(description = "相关接口",tags = {"相关接口"})
public class SuggController  extends BaseController {

    @Autowired
    private SuggService suggService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "提交投诉和建议", notes = "提交投诉和建议")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)Sugg sugg) {
        try {
            this.suggService.save(sugg);
        }catch (Exception e){
            return ResponseData.error("提交失败");
        }
        return ResponseData.success("提交成功",sugg);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "管理投诉和建议", notes = "管理投诉和建议")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)Sugg sugg) {
        try {
            this.suggService.updateById(sugg);
        }catch (Exception e){
            return ResponseData.error("编号错误");
        }
        return ResponseData.success("修改成功",sugg);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)Sugg sugg) {
      this.suggService.removeById(sugg.getSuggid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)Sugg sugg) {
       Sugg detail = this.suggService.getById(sugg.getSuggid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "根据业主用户名查询投诉和建议(或根据状态查询投诉和建议)", notes = "根据业主用户名查询投诉和建议(或根据状态查询投诉和建议)")
    public PageInfo list(@ApiParam(value = "对象", required = true)Sugg sugg) {
       return this.suggService.getPageList(sugg);
    }
}


