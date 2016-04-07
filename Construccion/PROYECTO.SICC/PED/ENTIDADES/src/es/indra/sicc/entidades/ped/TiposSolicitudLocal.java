package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TIPO_SOLIC")
@NamedQueries({
@NamedQuery(name="TiposSolicitudLocal.FindByGrupoSolicitud",query="SELECT OBJECT(a) "
+ " FROM TiposSolicitudLocal AS a "
+ " WHERE a.oidGrupoSolicitud = ?1"),
@NamedQuery(name="TiposSolicitudLocal.FindByUK",query="select Object(t) from TiposSolicitudLocal t where "
+ " t.codigo = ?1"),
@NamedQuery(name="TiposSolicitudLocal.FindAll",query="SELECT OBJECT(p) from TiposSolicitudLocal p")
})
public class TiposSolicitudLocal implements Serializable {

    public TiposSolicitudLocal() {}

    public TiposSolicitudLocal(Long oid, String codigo, Long oidTipoCliente, Long oidMarca,
            Long oidAcceso, Long oidClaseSolicitud, Boolean indConsolidado, Boolean indSolNegativa,
            Boolean indDevoluciones, Boolean indAnulacion) {
    
        this.oid=oid;
        setCodigo(codigo);              
        setOidTipoCliente(oidTipoCliente);
        setOidMarca(oidMarca);
        setOidAcceso(oidAcceso);
        setOidClaseSolicitud(oidClaseSolicitud);
        setIndConsolidado(indConsolidado);
        setIndSolNegativa(indSolNegativa);
        setIndDevoluciones(indDevoluciones);
        setIndAnulacion(indAnulacion);
    }

    @Id
    @Column(name="OID_TIPO_SOLI")
    private Long oid;
    @Column(name="COD_TIPO_SOLI")
    private String codigo;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long oidTipoCliente;
    @Column(name="MARC_OID_MARC")
    private Long oidMarca;
    @Column(name="ACCE_OID_ACCE")
    private Long oidAcceso;
    @Column(name="CLSO_OID_CLAS_SOLI")
    private Long oidClaseSolicitud;
    @Column(name="IND_CONS")
    private Boolean indConsolidado;
    @Column(name="IND_SOLI_NEGA")
    private Boolean indSolNegativa;
    @Column(name="GRSO_OID_GRUP_SOLI")
    private Long oidGrupoSolicitud;
    @Column(name="IND_DEVO")
    private Boolean indDevoluciones;
    @Column(name="IND_ANUL")
    private Boolean indAnulacion;
    @Column(name="SBAC_OID_SBAC")
    private Long oidSubacceso;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
            
    public Long getOidTipoCliente() {return oidTipoCliente;}
  
    public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
            
    public Long getOidMarca() {return oidMarca;}
  
    public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
            
    public Long getOidAcceso() {return oidAcceso;}
  
    public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
            
    public Long getOidClaseSolicitud() {return oidClaseSolicitud;}
  
    public void setOidClaseSolicitud(Long oidClaseSolicitud){this.oidClaseSolicitud=oidClaseSolicitud;}
            
    public Boolean getIndConsolidado() {return indConsolidado;}
  
    public void setIndConsolidado(Boolean indConsolidado){this.indConsolidado=indConsolidado;}
            
    public Boolean getIndSolNegativa() {return indSolNegativa;}
  
    public void setIndSolNegativa(Boolean indSolNegativa){this.indSolNegativa=indSolNegativa;}
            
    public Long getOidGrupoSolicitud() {return oidGrupoSolicitud;}
  
    public void setOidGrupoSolicitud(Long oidGrupoSolicitud){this.oidGrupoSolicitud=oidGrupoSolicitud;}
            
    public Boolean getIndDevoluciones() {return indDevoluciones;}
  
    public void setIndDevoluciones(Boolean indDevoluciones){this.indDevoluciones=indDevoluciones;}
            
    public Boolean getIndAnulacion() {return indAnulacion;}
  
    public void setIndAnulacion(Boolean indAnulacion){this.indAnulacion=indAnulacion;}
            
    public Long getOidSubacceso() {return oidSubacceso;}
  
    public void setOidSubacceso(Long oidSubacceso){this.oidSubacceso=oidSubacceso;}
	
}
