package com.system.frame.mapper;
import com.system.frame.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface UserMapper extends BaseMapper<User> {

    /**
    * 条件查询
    */
    List<User> getList(@Param("param") User user);

    /**
    * 分页条件查询
    */
    Page<User> getPageList(@Param("page") Page page, @Param("param") User user);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") User user);

}