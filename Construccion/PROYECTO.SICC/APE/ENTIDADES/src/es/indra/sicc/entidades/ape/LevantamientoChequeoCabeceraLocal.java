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
@Table(name="APE_LEVAN_CHEQU_CABEC")
@NamedQueries({
@NamedQuery(name="LevantamientoChequeoCabeceraLocal.FindAll",query="select object(o) from LevantamientoChequeoCabeceraLocal o")
})
public class LevantamientoChequeoCabeceraLocal implements Serializable {

    public LevantamientoChequeoCabeceraLocal() {}

    public LevantamientoChequeoCabeceraLocal(Long oid, Date fechaHora, Long numeroConsolidado,
            Long indEvaluacionReclamo, Long indCapturaManual, Long indPrimerPedido, Long oidRegion,
            Long oidSeccion, Long oidZona, Long oidPais, String usuario) {
        
        this.oid = oid;
        setFechaHora(fechaHora);
        setNumeroConsolidado(numeroConsolidado);
        setIndEvaluacionReclamo(indEvaluacionReclamo);
        setIndCapturaManual(indCapturaManual);
        setIndPrimerPedido(indPrimerPedido);
        setOidRegion(oidRegion);
        setOidSeccion(oidSeccion);
        setOidZona(oidZona);
        setOidPais(oidPais);
        setUsuario(usuario);
    }

    @Column(name="VAL_FECH_HORA")
    private java.sql.Date fechaHora;
    @Column(name="NUM_CONS")
    private Long numeroConsolidado;
    @Column(name="IND_EVAL_RECL")
    private Long indEvaluacionReclamo;
    @Column(name="IND_CAPT_MANU")
    private Long indCapturaManual;
    @Column(name="IND_PRIM_PEDI")
    private Long indPrimerPedido;
    @Column(name="ZORG_OID_REGI")
    private Long oidRegion;
    @Column(name="ZSCC_OID_SECC")
    private Long oidSeccion;
    @Column(name="ZZON_OID_ZONA")
    private Long oidZona;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="VAL_NOMB_USER")
    private String usuario;
    @Id
    @Column(name="OID_LEVA_CHEQ_CABE")
    private Long oid;

    
    public java.sql.Date getFechaHora() {return fechaHora;}
  
    public void setFechaHora(java.sql.Date fechaHora){this.fechaHora=fechaHora;}
            
    public Long getNumeroConsolidado() {return numeroConsolidado;}
  
    public void setNumeroConsolidado(Long numeroConsolidado){this.numeroConsolidado=numeroConsolidado;}
            
    public Long getIndEvaluacionReclamo() {return indEvaluacionReclamo;}
  
    public void setIndEvaluacionReclamo(Long indEvaluacionReclamo){this.indEvaluacionReclamo=indEvaluacionReclamo;}
            
    public Long getIndCapturaManual() {return indCapturaManual;}
  
    public void setIndCapturaManual(Long indCapturaManual){this.indCapturaManual=indCapturaManual;}
            
    public Long getIndPrimerPedido() {return indPrimerPedido;}
  
    public void setIndPrimerPedido(Long indPrimerPedido){this.indPrimerPedido=indPrimerPedido;}
            
    public Long getOidRegion() {return oidRegion;}
  
    public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
            
    public Long getOidSeccion() {return oidSeccion;}
  
    public void setOidSeccion(Long oidSeccion){this.oidSeccion=oidSeccion;}
            
    public Long getOidZona() {return oidZona;}
  
    public void setOidZona(Long oidZona){this.oidZona=oidZona;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public String getUsuario() {return usuario;}
  
    public void setUsuario(String usuario){this.usuario=usuario;}
            
    public Long getOid() {return oid;}
            
	
}
