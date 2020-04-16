package com.system.frame.api;
import com.system.frame.common.PageInfo;
import com.system.frame.common.ResponseData;
import com.system.frame.entity.User;
import com.system.frame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
*  前端控制层
*/
@RestController
@RequestMapping("/user")
@Api(description = "用户管理模块相关接口",tags = {"用户管理模块接口"})
public class UserController  extends BaseController {

    @Autowired
    private UserService userService;

    /**
    * 新增接口
    *
    */
    @PostMapping("/addItem")
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    public ResponseData addItem(@ApiParam(value = "对象", required = true)User user) {
        this.userService.save(user);
        return ResponseData.success();
    }

    /**
    * 编辑接口
    *
    */
    @PostMapping("/editItem")
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public ResponseData editItem(@ApiParam(value = "对象", required = true)User user) {
        try {
            this.userService.updateById(user);
        }catch (Exception e){
            return ResponseData.error("修改失败");
        }
        return ResponseData.success("修改成功",user);
    }

    /**
    *  删除接口
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除,需要传对象的id", notes = "删除,需要传对象的id")
    public ResponseData delete(@ApiParam(value = "对象", required = true)User user) {
      this.userService.removeById(user.getUid());
      return ResponseData.success();
    }

    /**
    *  查看详情接口
    */
    @GetMapping("/detail")
    @ApiOperation(value = "根据对象id查询对象信息()", notes = "根据对象id查询对象信息()")
    public ResponseData detail(@ApiParam(value = "对象", required = true)User user) {
       User detail = this.userService.getById(user.getUid());
       return ResponseData.success(detail);
    }

    /**
    * 分页查询接口
    */
    @GetMapping("/list")
    @ApiOperation(value = "根据用户名查询用户（不填写查询所有用户）", notes = "根据用户名查询用户（不填写查询所有用户")
    public PageInfo list(@ApiParam(value = "对象", required = true)User user) {
       return this.userService.getPageList(user);
    }
}


