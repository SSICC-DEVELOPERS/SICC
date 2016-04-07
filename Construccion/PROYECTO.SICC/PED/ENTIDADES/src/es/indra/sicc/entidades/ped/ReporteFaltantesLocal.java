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
@Table(name="PED_REPOR_FALTA")
@NamedQueries({
@NamedQuery(name="ReporteFaltantesLocal.FindAll",query="SELECT OBJECT(p) from ReporteFaltantesLocal p")
})
public class ReporteFaltantesLocal implements Serializable {

    public ReporteFaltantesLocal() {}

    public ReporteFaltantesLocal(Long oid, Long pais_oid_pais, Long val_lote_repo_falt, Date fec_ejec) {
        this.oid=oid;
        this.oidPais = pais_oid_pais;
        this.loteReporteFaltantes = val_lote_repo_falt;
        this.fechaEjecucion = fec_ejec;
    }

    @Id
    @Column(name="OID_REPO_FALT")
    private Long oid;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="VAL_LOTE_REPO_FALT")
    private Long loteReporteFaltantes;
    @Column(name="FEC_EJEC")
    private Date fechaEjecucion;
    @Column(name="FEC_APRO")
    private Date fechaAprobacion;
    @Column(name="VAL_USUA_APRO")
    private String usuarioAprobacion;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public Long getLoteReporteFaltantes() {return loteReporteFaltantes;}
  
    public void setLoteReporteFaltantes(Long loteReporteFaltantes){this.loteReporteFaltantes=loteReporteFaltantes;}
            
    public java.sql.Date getFechaEjecucion() {return fechaEjecucion;}
  
    public void setFechaEjecucion(java.sql.Date fechaEjecucion){this.fechaEjecucion=fechaEjecucion;}
            
    public java.sql.Date getFechaAprobacion() {return fechaAprobacion;}
  
    public void setFechaAprobacion(java.sql.Date fechaAprobacion){this.fechaAprobacion=fechaAprobacion;}
            
    public String getUsuarioAprobacion() {return usuarioAprobacion;}
  
    public void setUsuarioAprobacion(String usuarioAprobacion){this.usuarioAprobacion=usuarioAprobacion;}
                    
}
