package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PED_LOTE")
@NamedQueries({
@NamedQuery(name="LotesLocal.FindAll",query="select object(o) from LotesLocal o")
})
public class LotesLocal implements Serializable {

    public LotesLocal() {}

    public LotesLocal(Long oid, Long numLote, Date fecRegi, Long perdOidPeri, Long tspaOidTipoSoliPais)	{
        this.oid=oid;
        this.lote = numLote;
        this.fechaRegistro = fecRegi;
        this.oidPeriodo = perdOidPeri;
        this.oidTipoSolicitudPais = tspaOidTipoSoliPais;
    }

    @Id
    @Column(name="OID_LOTE")
    private Long oid;
    @Column(name="NUM_LOTE")
    private Long lote;
    @Column(name="FEC_REGI")
    private Date fechaRegistro;
    @Column(name="PERD_OID_PERI")
    private Long oidPeriodo;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long oidTipoSolicitudPais;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getLote() {return lote;}
  
    public void setLote(Long lote){this.lote=lote;}
            
    public Date getFechaRegistro() {return fechaRegistro;}
  
    public void setFechaRegistro(Date fechaRegistro){this.fechaRegistro=fechaRegistro;}
            
    public Long getOidPeriodo() {return oidPeriodo;}
  
    public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
            
    public Long getOidTipoSolicitudPais() {return oidTipoSolicitudPais;}
  
    public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais){this.oidTipoSolicitudPais=oidTipoSolicitudPais;}
                    
	
}
