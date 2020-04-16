package com.system.frame.mapper;
import com.system.frame.entity.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface HouseMapper extends BaseMapper<House> {

    /**
    * 条件查询
    */
    List<House> getList(@Param("param") House house);

    /**
    * 分页条件查询
    */
    Page<House> getPageList(@Param("page") Page page, @Param("param") House house);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") House house);

}