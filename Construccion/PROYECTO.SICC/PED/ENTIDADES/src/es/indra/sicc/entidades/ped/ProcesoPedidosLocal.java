package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_PROCE")
@NamedQueries({
@NamedQuery(name="ProcesoPedidosLocal.FindByUK",query="select Object(p) from ProcesoPedidosLocal p where p.codigo = ?1"),
@NamedQuery(name="ProcesoPedidosLocal.FindAll",query="select Object(p) from ProcesoPedidosLocal p")
})
public class ProcesoPedidosLocal implements Serializable {

    public ProcesoPedidosLocal() {}

    public ProcesoPedidosLocal(Long oid, String cod_proc, Long grpr_oid_grup_proc) {
        this.oid=oid;
        this.codigo = cod_proc;
        this.oidGrupoProcesos = grpr_oid_grup_proc;
    }

    @Id
    @Column(name="OID_PROC")
    private Long oid;
    @Column(name="COD_PROC")
    private String codigo;
    @Column(name="GRPR_OID_GRUP_PROC")
    private Long oidGrupoProcesos;
    @Column(name="PROG_OID_PROG")
    private Long oidProgramas;
    @Column(name="TPOS_OID_TIPO_POSI")
    private Long oidTiposPosicion;
    @Column(name="PROC_OID_PROC")
    private Long oidProcesoPedidos;
    @Column(name="STPO_OID_SUBT_POSI")
    private Long oidSubtiposPosicion;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
            
    public Long getOidGrupoProcesos() {return oidGrupoProcesos;}
  
    public void setOidGrupoProcesos(Long oidGrupoProcesos){this.oidGrupoProcesos=oidGrupoProcesos;}
            
    public Long getOidProgramas() {return oidProgramas;}
  
    public void setOidProgramas(Long oidProgramas){this.oidProgramas=oidProgramas;}
            
    public Long getOidTiposPosicion() {return oidTiposPosicion;}
  
    public void setOidTiposPosicion(Long oidTiposPosicion){this.oidTiposPosicion=oidTiposPosicion;}
            
    public Long getOidProcesoPedidos() {return oidProcesoPedidos;}
  
    public void setOidProcesoPedidos(Long oidProcesoPedidos){this.oidProcesoPedidos=oidProcesoPedidos;}
            
    public Long getOidSubtiposPosicion() {return oidSubtiposPosicion;}
  
    public void setOidSubtiposPosicion(Long oidSubtiposPosicion){this.oidSubtiposPosicion=oidSubtiposPosicion;}
	
}
