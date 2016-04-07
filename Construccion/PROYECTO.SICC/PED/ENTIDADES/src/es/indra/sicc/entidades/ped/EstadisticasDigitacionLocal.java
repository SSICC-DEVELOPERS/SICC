package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PED_ESTAD_DIGIT")
@NamedQueries({
@NamedQuery(name="EstadisticasDigitacionLocal.FindAll", query="SELECT OBJECT(o) FROM EstadisticasDigitacionLocal AS o")
})
public class EstadisticasDigitacionLocal implements Serializable {

    public EstadisticasDigitacionLocal() {}

    public EstadisticasDigitacionLocal(Long oid, Long perd_oid_peri, Long tspa_oid_tipo_soli_pais, 
            Long proc_oid_proc, Timestamp fec_inic_sesi, String val_usua, Timestamp fec_fin_sesi) {
            
        this.oid=oid;
        this.periodo = perd_oid_peri;
        this.tipoSolicitudPais = tspa_oid_tipo_soli_pais;
        this.proceso = proc_oid_proc;
        this.inicioSesion = fec_inic_sesi;
        this.usuario = val_usua;
        this.finSesion = fec_fin_sesi;
    }

    @Id
    @Column(name="OID_ESTA_DIGI")
    private Long oid;
    @Column(name="PERD_OID_PERI")
    private Long periodo;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long tipoSolicitudPais;
    @Column(name="PROC_OID_PROC")
    private Long proceso;
    @Column(name="FEC_INIC_SESI")
    private Timestamp inicioSesion;
    @Column(name="VAL_USUA")
    private String usuario;
    @Column(name="FEC_FIN_SESI")
    private java.sql.Timestamp finSesion;
    @Column(name="NUM_OC")
    private Long numeroOC;
    @Column(name="NUM_ERRO_OC")
    private Long errorOC;
    @Column(name="NUM_CV")
    private Long numeroCV;
    @Column(name="NUM_ERRO_CV")
    private Long errorCV;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getPeriodo() {return periodo;}
  
    public void setPeriodo(Long periodo){this.periodo=periodo;}
            
    public Long getTipoSolicitudPais() {return tipoSolicitudPais;}
  
    public void setTipoSolicitudPais(Long tipoSolicitudPais){this.tipoSolicitudPais=tipoSolicitudPais;}
            
    public Long getProceso() {return proceso;}
  
    public void setProceso(Long proceso){this.proceso=proceso;}
            
    public java.sql.Timestamp getInicioSesion() {return inicioSesion;}
  
    public void setInicioSesion(java.sql.Timestamp inicioSesion){this.inicioSesion=inicioSesion;}
            
    public String getUsuario() {return usuario;}
  
    public void setUsuario(String usuario){this.usuario=usuario;}
            
    public java.sql.Timestamp getFinSesion() {return finSesion;}
  
    public void setFinSesion(java.sql.Timestamp finSesion){this.finSesion=finSesion;}
            
    public Long getNumeroOC() {return numeroOC;}
  
    public void setNumeroOC(Long numeroOC){this.numeroOC=numeroOC;}
            
    public Long getErrorOC() {return errorOC;}
  
    public void setErrorOC(Long errorOC){this.errorOC=errorOC;}
            
    public Long getNumeroCV() {return numeroCV;}
  
    public void setNumeroCV(Long numeroCV){this.numeroCV=numeroCV;}
            
    public Long getErrorCV() {return errorCV;}
  
    public void setErrorCV(Long errorCV){this.errorCV=errorCV;}
	
}
