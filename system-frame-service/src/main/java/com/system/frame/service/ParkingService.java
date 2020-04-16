package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.Parking;
import com.system.frame.mapper.ParkingMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class ParkingService extends ServiceImpl<ParkingMapper, Parking>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(Parking parking){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, parking);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<Parking> getList(Parking parking){
        return this.baseMapper.getList( parking);
    }
    /**
    * 条件查询数量
    */
    public int getCount(Parking parking){
        return this.baseMapper.getCount(parking);
    }

}