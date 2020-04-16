package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.Pay;
import com.system.frame.mapper.PayMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class PayService extends ServiceImpl<PayMapper, Pay>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(Pay pay){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, pay);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<Pay> getList(Pay pay){
        return this.baseMapper.getList( pay);
    }
    /**
    * 条件查询数量
    */
    public int getCount(Pay pay){
        return this.baseMapper.getCount(pay);
    }

}