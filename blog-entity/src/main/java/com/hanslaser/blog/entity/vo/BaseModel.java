package com.hanslaser.blog.entity.vo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author LuoJu
 * @since 2018.10.25
 */
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected Timestamp createdDatetime;

    @Column
    protected Timestamp lastModifiedDatetime;

    @Column
    protected Integer dr;

    @Transient
    protected int entityState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public Timestamp getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Timestamp lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public int getEntityState() {
        return entityState;
    }

    public void setEntityState(int entityState) {
        this.entityState = entityState;
    }
}