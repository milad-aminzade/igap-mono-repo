package ir.kian.igap.IgapUserProfileChallenge.domain.entity;


import java.io.Serializable;

public interface IEntity<ID> extends Serializable {

    ID getId();

    void setId(ID id);
}