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
@TableName("sugg")
@ApiModel(value="sugg对象",description="用户对象sugg")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sugg implements Serializable{
      /**
       * 
       */
        @TableId(value = "suggid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="suggid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer suggid;
      /**
       * 用户名
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="用户名",name="uname")
        private String uname;
      /**
       * 联系方式
       */
        @TableField(value = "phone")
        @ApiModelProperty(value="联系方式",name="phone")
        private String phone;
      /**
       * 反馈内容
       */
        @TableField(value = "info")
        @ApiModelProperty(value="反馈内容",name="info")
        private String info;
      /**
       * 类型是投诉还是建议
       */
        @TableField(value = "type")
        @ApiModelProperty(value="类型是投诉还是建议",name="type")
        private String type;
      /**
       * 状态：待处理或已处理
       */
        @TableField(value = "state")
        @ApiModelProperty(value="状态：待处理或已处理",name="state")
        private String state;

}