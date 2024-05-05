package ir.kian.igap.common.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
public abstract class BaseEntity<IDTYPE> implements IEntity<IDTYPE> {
    private static final long serialVersionUID = 8664710824576476467L;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_date")
    protected Long createdDate = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "modified_date")
    protected Long modifiedDate = 0L;

    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected String modifiedBy;
}
