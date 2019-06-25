package com.cesarbassani.algamoneyapi.model;


import javax.persistence.*;

@MappedSuperclass
public class EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Long codigo;

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getCodigo() != null ? this.getCodigo().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object){
            return true;
        }
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }

        EntidadeBase other = (EntidadeBase) object;
        if(this.getCodigo() != null && this.codigo.equals(other.codigo)){
            return true;
        }
        return false;
    }
}
