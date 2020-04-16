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
@TableName("house")
@ApiModel(value="house对象",description="用户对象house")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class House implements Serializable{
      /**
       * 
       */
        @TableId(value = "houseid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="houseid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer houseid;
      /**
       * 
       */
        @TableField(value = "danyuan")
        @ApiModelProperty(value="",name="danyuan")
        private String danyuan;
      /**
       * 
       */
        @TableField(value = "louceng")
        @ApiModelProperty(value="",name="louceng")
        private String louceng;
      /**
       * 
       */
        @TableField(value = "fangjian")
        @ApiModelProperty(value="",name="fangjian")
        private String fangjian;
      /**
       * 土地证号
       */
        @TableField(value = "landnum")
        @ApiModelProperty(value="土地证号",name="landnum")
        private String landnum;
      /**
       * 根据用户名查询，或根据uname绑定房子
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="根据用户名查询，或根据uname绑定房子",name="uname")
        private String uname;

}