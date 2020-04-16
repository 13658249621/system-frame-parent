package com.system.frame.mapper;
import com.system.frame.entity.Fix;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface FixMapper extends BaseMapper<Fix> {

    /**
    * 条件查询
    */
    List<Fix> getList(@Param("param") Fix fix);

    /**
    * 分页条件查询
    */
    Page<Fix> getPageList(@Param("page") Page page, @Param("param") Fix fix);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") Fix fix);

}