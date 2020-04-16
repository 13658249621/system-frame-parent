package com.system.frame.api;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.House;
import com.system.frame.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/house")
@Api(description = "楼栋房屋模块相关接口",tags = {"楼栋房屋模块接口"})
public class HouseController  extends BaseController {

    @Autowired
    private HouseService houseService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "保存", notes = "保存")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)House house) {
        try {
            this.houseService.save(house);
        }catch (Exception e){
            return ResponseData.error("提交失败");
        }
        return ResponseData.success("提交成功",house);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "管理楼栋房屋信息", notes = "管理楼栋房屋信息")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)House house) {
        try {
            this.houseService.updateById(house);
        }catch (Exception e){
            return ResponseData.error("修改失败");
        }
      return ResponseData.success("修改成功",house);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)House house) {
      this.houseService.removeById(house.getHouseid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)House house) {
       House detail = this.houseService.getById(house.getHouseid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "根据单元楼层房间号查询房屋信息", notes = "根据单元楼层房间号查询房屋信息")
    public PageInfo list(@ApiParam(value = "对象", required = true)House house) {
       return this.houseService.getPageList(house);
    }
}


