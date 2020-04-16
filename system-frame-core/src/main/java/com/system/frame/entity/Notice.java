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
@TableName("notice")
@ApiModel(value="notice对象",description="用户对象notice")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice implements Serializable{
      /**
       * 
       */
        @TableId(value = "noticeid",type= IdType.AUTO)
        @ApiModelProperty(value="",name="noticeid")
        @JsonSerialize(using = ToStringSerializer.class)
        private Integer noticeid;
      /**
       * 公告标题
       */
        @TableField(value = "title")
        @ApiModelProperty(value="公告标题",name="title")
        private String title;
      /**
       * 公告内容
       */
        @TableField(value = "info")
        @ApiModelProperty(value="公告内容",name="info")
        private String info;
      /**
       * 发布时间
       */
        @TableField(value = "date")
        @ApiModelProperty(value="发布时间",name="date")
        private String date;

}