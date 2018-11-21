package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexzhu on 2018/11/21 22:47 .
 * No bug No pain
 */

@MappedSuperclass
public class Entity<T> {

//    private Logger Log;
//
//    @SuppressWarnings("rawtypes")
//    private Entity() {
//        Class<T> entityClass =
//                (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        Log = LoggerFactory.getLogger(entityClass.getClass());
//    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "gmt_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreated;

    @Column(name = "gmt_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @PostPersist
    void afterPersist() {
        gmtCreated = new Date(System.currentTimeMillis());
        gmtModified = new Date(System.currentTimeMillis());
        System.out.println(" ==== persist entity ===" + getClass());
    }

    @PostUpdate
    void afterUpdate() {
        gmtModified = new Date(System.currentTimeMillis());
        System.out.println(" ==== eneity is be update:" + getClass());
    }

//    public Long getId() {
//        return id;
//    }
//
//    public Entity setId(Long id) {
//        this.id = id;
//        return this;
//    }

    public Integer getVersion() {
        return version;
    }

    public Entity setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public Entity setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
        return this;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Entity setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
        return this;
    }
}
