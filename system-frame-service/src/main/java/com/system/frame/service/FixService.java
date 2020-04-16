package com.system.frame.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import com.system.frame.entity.Fix;
import com.system.frame.mapper.FixMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*   service业务处理层
*/
@Service
public class FixService extends ServiceImpl<FixMapper, Fix>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(Fix fix){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, fix);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<Fix> getList(Fix fix){
        return this.baseMapper.getList( fix);
    }
    /**
    * 条件查询数量
    */
    public int getCount(Fix fix){
        return this.baseMapper.getCount(fix);
    }

}