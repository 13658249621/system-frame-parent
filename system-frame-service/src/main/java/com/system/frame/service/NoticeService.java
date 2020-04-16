package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.Notice;
import com.system.frame.mapper.NoticeMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(Notice notice){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, notice);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<Notice> getList(Notice notice){
        return this.baseMapper.getList( notice);
    }
    /**
    * 条件查询数量
    */
    public int getCount(Notice notice){
        return this.baseMapper.getCount(notice);
    }

}