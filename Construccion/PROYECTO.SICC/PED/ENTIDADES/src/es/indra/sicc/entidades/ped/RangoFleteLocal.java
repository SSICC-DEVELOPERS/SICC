package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="PED_DETAL_FLETE")
@NamedQueries({@NamedQuery(name="RangoFleteLocal.FindByOidFlete",query="SELECT OBJECT(o) "
+ " FROM RangoFleteLocal AS o "
+ " WHERE o.oidFlete = ?1"),
@NamedQuery(name="RangoFleteLocal.FindAll", query="SELECT OBJECT(o) FROM RangoFleteLocal AS o")
})	

public class RangoFleteLocal implements Serializable {

    public RangoFleteLocal() {}

    public RangoFleteLocal(Long oid, Long oidFlete, BigDecimal rangoInf, BigDecimal rangoSup, BigDecimal montoFij)	{
        this.oid=oid;
        this.oidFlete = oidFlete;
        this.rangoInf = rangoInf;
        this.rangoSup = rangoSup;
        this.montoFij = montoFij;
    }

    @Id
    @Column(name="OID_DETA_FLET")
    private Long oid;
    @Column(name="FLET_OID_FLET")
    private Long oidFlete;
    @Column(name="RANGO_INFE")
    private BigDecimal rangoInf;
    @Column(name="RANG_SUPE")
    private BigDecimal rangoSup;
    @Column(name="VALO_MONT_FIJO")
    private BigDecimal montoFij;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}


    public void setOid(Long oid) {
        this.oid = oid;
    }

    public void setOidFlete(Long oidFlete) {
        this.oidFlete = oidFlete;
    }

    public Long getOidFlete() {
        return oidFlete;
    }

    public void setRangoInf(BigDecimal rangoInf) {
        this.rangoInf = rangoInf;
    }

    public BigDecimal getRangoInf() {
        return rangoInf;
    }

    public void setRangoSup(BigDecimal rangoSup) {
        this.rangoSup = rangoSup;
    }

    public BigDecimal getRangoSup() {
        return rangoSup;
    }

    public void setMontoFij(BigDecimal montoFij) {
        this.montoFij = montoFij;
    }

    public BigDecimal getMontoFij() {
        return montoFij;
    }
}
