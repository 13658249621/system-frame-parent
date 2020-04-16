package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.Sugg;
import com.system.frame.mapper.SuggMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class SuggService extends ServiceImpl<SuggMapper, Sugg>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(Sugg sugg){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, sugg);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<Sugg> getList(Sugg sugg){
        return this.baseMapper.getList( sugg);
    }
    /**
    * 条件查询数量
    */
    public int getCount(Sugg sugg){
        return this.baseMapper.getCount(sugg);
    }

}