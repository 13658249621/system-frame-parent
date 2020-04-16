package com.system.frame.mapper;
import com.system.frame.entity.Sugg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface SuggMapper extends BaseMapper<Sugg> {

    /**
    * 条件查询
    */
    List<Sugg> getList(@Param("param") Sugg sugg);

    /**
    * 分页条件查询
    */
    Page<Sugg> getPageList(@Param("page") Page page, @Param("param") Sugg sugg);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") Sugg sugg);

}