package com.lambdaschool.zoos.models;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
 abstract class Auditable {

  @CreatedBy
  protected String createdby;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date createddate;

  @LastModifiedBy
  protected String lastmodifiedby;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  protected Date lastmodifieddate;

  public String getCreatedby() {
    return createdby;
  }

  public Date getCreateddate() {
    return createddate;
  }

  public String getLastmodifiedby() {
    return lastmodifiedby;
  }

  public Date getLastmodifieddate() {
    return lastmodifieddate;
  }
}
