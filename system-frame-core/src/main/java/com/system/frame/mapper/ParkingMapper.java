package com.system.frame.mapper;
import com.system.frame.entity.Parking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface ParkingMapper extends BaseMapper<Parking> {

    /**
    * 条件查询
    */
    List<Parking> getList(@Param("param") Parking parking);

    /**
    * 分页条件查询
    */
    Page<Parking> getPageList(@Param("page") Page page, @Param("param") Parking parking);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") Parking parking);

}