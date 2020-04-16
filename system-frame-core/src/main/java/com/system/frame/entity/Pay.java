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
@TableName("pay")
@ApiModel(value="pay对象",description="用户对象pay")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pay implements Serializable{
      /**
       * 
       */
        @TableId(value = "payid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="payid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer payid;
      /**
       * 缴费项目名称
       */
        @TableField(value = "paynama")
        @ApiModelProperty(value="缴费项目名称",name="paynama")
        private String paynama;
      /**
       * 最迟缴费时间
       */
        @TableField(value = "paytime")
        @ApiModelProperty(value="最迟缴费时间",name="paytime")
        private String paytime;
      /**
       * 缴费金额
       */
        @TableField(value = "price")
        @ApiModelProperty(value="缴费金额",name="price")
        private String price;
      /**
       * 状态：已缴或待缴
       */
        @TableField(value = "state")
        @ApiModelProperty(value="状态：已缴或待缴",name="state")
        private String state;
      /**
       * 用户名
       */
        @TableField(value = "uname")
        @ApiModelProperty(value="用户名",name="uname")
        private String uname;

}