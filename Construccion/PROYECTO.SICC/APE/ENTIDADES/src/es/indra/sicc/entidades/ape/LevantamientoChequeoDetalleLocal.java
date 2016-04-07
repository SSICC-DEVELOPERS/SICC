package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="APE_LEVAN_CHEQU_DETAL")
@NamedQueries({
@NamedQuery(name="LevantamientoChequeoDetalleLocal.FindAll",query="select object(o) from LevantamientoChequeoDetalleLocal o")
})
public class LevantamientoChequeoDetalleLocal implements Serializable {

    public LevantamientoChequeoDetalleLocal() {}

    public LevantamientoChequeoDetalleLocal(Long oid, Date fechaHoraSistema,
            Long oidLevantaChequCabecera, Long oidListaPicadoCabecera)	{
    
        this.oid = oid;
        setFechaHoraSistema(fechaHoraSistema);
        setOidLevantaChequCabecera(oidLevantaChequCabecera);
        setOidListaPicadoCabecera(oidListaPicadoCabecera);
    }

    @Id
    @Column(name="OID_LEVA_CHEQ_DETA")
    private Long oid;
    @Column(name="VAL_FECH_HORA_SIST")
    private java.sql.Date fechaHoraSistema;
    @Column(name="LECC_OID_LEVA_CHEQ_CABE")
    private Long oidLevantaChequCabecera;
    @Column(name="LPCA_OID_LIST_PICA_CABE")
    private Long oidListaPicadoCabecera;

    
    public Long getOid() {return oid;}
    
    public java.sql.Date getFechaHoraSistema() {return fechaHoraSistema;}
  
    public void setFechaHoraSistema(java.sql.Date fechaHoraSistema){this.fechaHoraSistema=fechaHoraSistema;}
            
    public Long getOidLevantaChequCabecera() {return oidLevantaChequCabecera;}
  
    public void setOidLevantaChequCabecera(Long oidLevantaChequCabecera){this.oidLevantaChequCabecera=oidLevantaChequCabecera;}
            
    public Long getOidListaPicadoCabecera() {return oidListaPicadoCabecera;}
  
    public void setOidListaPicadoCabecera(Long oidListaPicadoCabecera){this.oidListaPicadoCabecera=oidListaPicadoCabecera;}
                    
	
}
