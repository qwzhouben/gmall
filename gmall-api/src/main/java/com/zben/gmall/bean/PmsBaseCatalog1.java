package com.zben.gmall.bean;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 一级分类
 */
@Data
public class PmsBaseCatalog1 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Transient
    private List<PmsBaseCatalog2> catalog2s;

}

