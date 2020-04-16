package com.system.frame.api;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.Pay;
import com.system.frame.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/pay")
@Api(description = "缴费模块相关接口",tags = {"缴费模块接口"})
public class PayController  extends BaseController {

    @Autowired
    private PayService payService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "发布缴费项目", notes = "发布缴费项目")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)Pay pay) {
        try {
            this.payService.save(pay);
        }catch (Exception e){
            return ResponseData.error("发布缴费项失败");
        }
        return ResponseData.success("发布缴费项成功",pay);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "管理缴费", notes = "管理缴费")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)Pay pay) {
        try {
            this.payService.updateById(pay);
        }catch (Exception e){
            return ResponseData.error("修改失败");
        }
        return ResponseData.success("修改成功",pay);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)Pay pay) {
      this.payService.removeById(pay.getPayid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)Pay pay) {
       Pay detail = this.payService.getById(pay.getPayid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "不传入参数查询所有缴费信息(根据传入参数，可进行业主用户名缴费信息、缴费状态查询、缴费项目名称查询)", notes = "不传入参数查询所有缴费信息(根据传入参数，可进行业主用户名缴费信息、缴费状态查询、缴费项目名称查询)")
    public PageInfo list(@ApiParam(value = "对象", required = true)Pay pay) {
       return this.payService.getPageList(pay);
    }
}


