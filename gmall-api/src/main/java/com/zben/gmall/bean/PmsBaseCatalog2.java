package com.zben.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 耳机分类
 */
@Data
public class PmsBaseCatalog2 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String catalog1Id;

    @Transient
    private List<PmsBaseCatalog3> catalog3List;

}
