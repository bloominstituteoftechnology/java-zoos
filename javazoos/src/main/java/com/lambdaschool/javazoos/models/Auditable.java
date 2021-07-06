package com.lambdaschool.javazoos.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @CreatedBy
    protected String created_by;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date created_date;

    @LastModifiedBy
    protected String last_modified_by;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date last_modified_date;
}