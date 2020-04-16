package com.system.frame.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
/**
 *   实体对象
 */
@TableName("user")
@ApiModel(value="user对象",description="用户对象user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
      /**
       * 
       */
        @TableId(value = "uid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="uid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer uid;
      /**
       * 用户名称，唯一
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="用户名称，唯一",name="uname")
        private String uname;
      /**
       * 密码
       */
        @TableField(value = "password")
        @ApiModelProperty(value="密码",name="password")
        private String password;
      /**
       * 权限等级
       */
        @TableField(value = "power")
        @ApiModelProperty(value="权限等级",name="power")
        private String power;
      /**
       * 
       */
        @TableField(value = "danyuan")
        @ApiModelProperty(value="",name="danyuan")
        private String danyuan;
      /**
       * 
       */
        @TableField(value = "loucneg")
        @ApiModelProperty(value="",name="loucneg")
        private String loucneg;
      /**
       * 
       */
        @TableField(value = "fangjian")
        @ApiModelProperty(value="",name="fangjian")
        private String fangjian;
      /**
       * 
       */
        @TableField(value = "phone")
        @ApiModelProperty(value="",name="phone")
        private String phone;

}