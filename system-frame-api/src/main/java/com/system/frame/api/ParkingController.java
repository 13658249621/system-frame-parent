package com.system.frame.api;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.Parking;
import com.system.frame.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Objects;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/parking")
@Api(description = "车位模块相关接口",tags = {"车位模块接口"})
public class ParkingController  extends BaseController {

    @Autowired
    private ParkingService parkingService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "添加车位", notes = "添加车位")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)Parking parking) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parkingplace",parking.getParkingplace());
        Parking parking1 = parkingService.getOne(queryWrapper);
        if(Objects.nonNull(parking1)){
            return ResponseData.error("车位编号已存在，请仔细检查车位编号");
        }
        this.parkingService.save(parking);
        return ResponseData.success("车位添加成功",parking);
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "修改车位", notes = "修改车位")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)Parking parking) {
        try {
            this.parkingService.updateById(parking);
        }catch (Exception e){
            return ResponseData.error("车位修改失败");
        }
        return ResponseData.success("车位修改成功",parking);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)Parking parking) {
      this.parkingService.removeById(parking.getParkingid());
      return ResponseData.success("车位删除成功");
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)Parking parking) {
       Parking detail = this.parkingService.getById(parking.getParkingid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "不传参查询所有车位(传入相关参数可根据用户名查询车位、根据状态查询车位)", notes = "不传参查询所有车位(传入相关参数可根据用户名查询车位、根据状态查询车位)")
    public PageInfo list(@ApiParam(value = "对象", required = true)Parking parking) {
       return this.parkingService.getPageList(parking);
    }
}


