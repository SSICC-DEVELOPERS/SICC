package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_SECUE_PROCE")
@NamedQueries({
@NamedQuery(name="SecuenciaProcesosLocal.FindByGrupo",query="SELECT OBJECT(o) "
+ " FROM SecuenciaProcesosLocal AS o "
+ " WHERE o.oidGrupoProcesos = ?1"),
@NamedQuery(name="SecuenciaProcesosLocal.FindByProceso",query="SELECT OBJECT(o) "
+ " FROM SecuenciaProcesosLocal AS o "
+ " WHERE o.oidProcesoPedidos = ?1"),
@NamedQuery(name="SecuenciaProcesosLocal.FindByGrupoTipoSolicitud",query="SELECT OBJECT(o) "
+ " FROM SecuenciaProcesosLocal AS o "
+ " WHERE o.oidGrupoProcesos = ?1 "
+ " and o.oidTiposSolicitudPais = ?2"),
@NamedQuery(name="SecuenciaProcesosLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM SecuenciaProcesosLocal AS o "
+ " WHERE o.oidGrupoProcesos = ?1 "
+ " and o.oidProcesoPedidos = ?2 "
+ " and o.oidTiposSolicitudPais = ?3 "
+ " and o.secuencia = ?4"),
@NamedQuery(name="SecuenciaProcesosLocal.FindAll",query="SELECT OBJECT(o) "
+ " FROM SecuenciaProcesosLocal AS o")
})
public class SecuenciaProcesosLocal implements Serializable {

    public SecuenciaProcesosLocal() {}

    public SecuenciaProcesosLocal(Long oid, Integer cod_secu, Long grpr_oid_grup_proc,
            Long proc_oid_proc, Long tspa_oid_tipo_soli_pais, Boolean ind_ejec_onli) {
        
        this.oid=oid;
        this.secuencia = cod_secu;
        this.oidGrupoProcesos = grpr_oid_grup_proc;
        this.oidProcesoPedidos = proc_oid_proc;
        this.oidTiposSolicitudPais = tspa_oid_tipo_soli_pais;
        this.indEjecucion = ind_ejec_onli;
    }

    @Id
    @Column(name="OID_SECU_PROC")
    private Long oid;
    @Column(name="COD_SECU")
    private Integer secuencia;
    @Column(name="GRPR_OID_GRUP_PROC")
    private Long oidGrupoProcesos;
    @Column(name="PROC_OID_PROC")
    private Long oidProcesoPedidos;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long oidTiposSolicitudPais;
    @Column(name="IND_EJEC_ONLI")
    private Boolean indEjecucion;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Integer getSecuencia() {return secuencia;}
  
    public void setSecuencia(Integer secuencia){this.secuencia=secuencia;}
            
    public Long getOidGrupoProcesos() {return oidGrupoProcesos;}
  
    public void setOidGrupoProcesos(Long oidGrupoProcesos){this.oidGrupoProcesos=oidGrupoProcesos;}
            
    public Long getOidProcesoPedidos() {return oidProcesoPedidos;}
  
    public void setOidProcesoPedidos(Long oidProcesoPedidos){this.oidProcesoPedidos=oidProcesoPedidos;}
            
    public Long getOidTiposSolicitudPais() {return oidTiposSolicitudPais;}
  
    public void setOidTiposSolicitudPais(Long oidTiposSolicitudPais){this.oidTiposSolicitudPais=oidTiposSolicitudPais;}
            
    public Boolean getIndEjecucion() {return indEjecucion;}
  
    public void setIndEjecucion(Boolean indEjecucion){this.indEjecucion=indEjecucion;}
	
}
