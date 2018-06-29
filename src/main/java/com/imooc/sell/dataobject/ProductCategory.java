package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 类目表实体
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    //类目id
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;
    //更新时间
    private Timestamp updateTime;
    //创建时间
    private Timestamp createTime;
}
