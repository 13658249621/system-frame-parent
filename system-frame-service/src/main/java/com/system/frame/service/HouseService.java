package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.House;
import com.system.frame.mapper.HouseMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class HouseService extends ServiceImpl<HouseMapper, House>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(House house){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, house);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<House> getList(House house){
        return this.baseMapper.getList( house);
    }
    /**
    * 条件查询数量
    */
    public int getCount(House house){
        return this.baseMapper.getCount(house);
    }

}