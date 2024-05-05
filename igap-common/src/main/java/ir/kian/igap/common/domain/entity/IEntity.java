package ir.kian.igap.common.domain.entity;


import java.io.Serializable;

public interface IEntity<ID> extends Serializable {

    ID getId();

    void setId(ID id);
}