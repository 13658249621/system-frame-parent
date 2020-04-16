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
@TableName("fix")
@ApiModel(value="fix对象",description="用户对象fix")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fix implements Serializable{
      /**
       * 
       */
        @TableId(value = "fixid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="fixid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer fixid;
      /**
       * 
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="",name="uname")
        private String uname;
      /**
       * 单元号
       */
        @TableField(value = "danyuan")
        @ApiModelProperty(value="单元号",name="danyuan")
        private String danyuan;
      /**
       * 楼层号
       */
        @TableField(value = "louceng")
        @ApiModelProperty(value="楼层号",name="louceng")
        private String louceng;
      /**
       * 房间号
       */
        @TableField(value = "fangjian")
        @ApiModelProperty(value="房间号",name="fangjian")
        private String fangjian;
      /**
       * 联系电话
       */
        @TableField(value = "phone")
        @ApiModelProperty(value="联系电话",name="phone")
        private String phone;
      /**
       * 备注信息
       */
        @TableField(value = "info")
        @ApiModelProperty(value="备注信息",name="info")
        private String info;
      /**
       * 报修日期
       */
        @TableField(value = "date")
        @ApiModelProperty(value="报修日期",name="date")
        private String date;
      /**
       * 报修状态：等待修理或已修理
       */
        @TableField(value = "state")
        @ApiModelProperty(value="报修状态：等待修理或已修理",name="state")
        private String state;

}