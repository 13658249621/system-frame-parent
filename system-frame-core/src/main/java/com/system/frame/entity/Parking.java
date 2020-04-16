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
@TableName("parking")
@ApiModel(value="parking对象",description="用户对象parking")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parking implements Serializable{
      /**
       * 
       */
        @TableId(value = "parkingid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="parkingid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer parkingid;
      /**
       * 用户名，根据用户名查询管理车位
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="用户名，根据用户名查询管理车位",name="uname")
        private String uname;
      /**
       * 车位所在位置编号：唯一
       */
        @TableField(value = "parkingplace")
        @ApiModelProperty(value="车位所在位置编号：唯一",name="parkingplace")
        private String parkingplace;
      /**
       * 车位状态：已售或待售
       */
        @TableField(value = "state")
        @ApiModelProperty(value="车位状态：已售或待售",name="state")
        private String state;
      /**
       * 车位收费价格
       */
        @TableField(value = "price")
        @ApiModelProperty(value="车位收费价格",name="price")
        private String price;

}