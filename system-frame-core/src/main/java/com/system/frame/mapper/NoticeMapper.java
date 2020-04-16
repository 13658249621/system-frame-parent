package com.system.frame.mapper;
import com.system.frame.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
    * 条件查询
    */
    List<Notice> getList(@Param("param") Notice notice);

    /**
    * 分页条件查询
    */
    Page<Notice> getPageList(@Param("page") Page page, @Param("param") Notice notice);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") Notice notice);

}