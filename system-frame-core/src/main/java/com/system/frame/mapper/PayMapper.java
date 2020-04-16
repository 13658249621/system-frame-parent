package com.system.frame.mapper;
import com.system.frame.entity.Pay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
*   数据库mapper层
*/
public interface PayMapper extends BaseMapper<Pay> {

    /**
    * 条件查询
    */
    List<Pay> getList(@Param("param") Pay pay);

    /**
    * 分页条件查询
    */
    Page<Pay> getPageList(@Param("page") Page page, @Param("param") Pay pay);

    /**
    * 条件查询条数
    */
    int getCount(@Param("param") Pay pay);

}