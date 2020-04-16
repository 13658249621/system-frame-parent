package com.system.frame.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.system.frame.common.PageFactory;
import com.system.frame.common.PageInfo;
import org.springframework.stereotype.Service;
import com.system.frame.entity.User;
import com.system.frame.mapper.UserMapper;
import java.util.List;

/**
*   service业务处理层
*/
@Service
public class UserService extends ServiceImpl<UserMapper, User>   {

    /**
    * 分页条件查询
    */
    public PageInfo getPageList(User user){
       Page pageContext = PageFactory.defaultPage();
       IPage page = this.baseMapper.getPageList(pageContext, user);
       return PageFactory.createPageInfo(page);
     }
    /**
    * 条件查询
    */
    public List<User> getList(User user){
        return this.baseMapper.getList( user);
    }
    /**
    * 条件查询数量
    */
    public int getCount(User user){
        return this.baseMapper.getCount(user);
    }




}