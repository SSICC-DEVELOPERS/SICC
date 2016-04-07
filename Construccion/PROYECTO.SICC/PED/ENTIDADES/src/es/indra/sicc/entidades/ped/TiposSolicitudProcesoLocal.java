package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TIPO_SOLIC_PROCE")
@NamedQueries({
@NamedQuery(name="TiposSolicitudProcesoLocal.FindByUKProceso",query="SELECT OBJECT(a) "
+ " FROM TiposSolicitudProcesoLocal AS a "
+ " WHERE a.oidOperacion = ?1 AND "
+ " a.oidTipoSolicitud = ?2"),
@NamedQuery(name="TiposSolicitudProcesoLocal.FindAll",query="SELECT OBJECT(p) from TiposSolicitudProcesoLocal p")
})
public class TiposSolicitudProcesoLocal implements Serializable {

    public TiposSolicitudProcesoLocal() {}

    public TiposSolicitudProcesoLocal(Long oid, Long tspa_oid_tipo_soli_pais, Boolean ind_prod, Long oper_oid_oper)	{
        this.oid=oid;
        setOidOperacion(oper_oid_oper);
        setIndProducto(ind_prod);
        setOidTipoSolicitud(tspa_oid_tipo_soli_pais);
    }

    @Id
    @Column(name="OID_TIPO_SOLI_PROC")
    private Long oid;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long oidTipoSolicitud;
    @Column(name="STPO_OID_SUBT_POSI")
    private Long oidSubTipoPosicion;
    @Column(name="PROD_OID_PROD")
    private Long oidProducto;
    @Column(name="TPOS_OID_TIPO_POSI")
    private Long oidTipoPosicion;
    @Column(name="IND_PROD")
    private Boolean indProducto;
    @Column(name="OPER_OID_OPER")
    private Long oidOperacion;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getOidTipoSolicitud() {return oidTipoSolicitud;}
  
    public void setOidTipoSolicitud(Long oidTipoSolicitud){this.oidTipoSolicitud=oidTipoSolicitud;}
            
    public Long getOidSubTipoPosicion() {return oidSubTipoPosicion;}
  
    public void setOidSubTipoPosicion(Long oidSubTipoPosicion){this.oidSubTipoPosicion=oidSubTipoPosicion;}
            
    public Long getOidProducto() {return oidProducto;}
  
    public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
            
    public Long getOidTipoPosicion() {return oidTipoPosicion;}
  
    public void setOidTipoPosicion(Long oidTipoPosicion){this.oidTipoPosicion=oidTipoPosicion;}
            
    public Boolean getIndProducto() {return indProducto;}
  
    public void setIndProducto(Boolean indProducto){this.indProducto=indProducto;}
            
    public Long getOidOperacion() {return oidOperacion;}
  
    public void setOidOperacion(Long oidOperacion){this.oidOperacion=oidOperacion;}
	
}
