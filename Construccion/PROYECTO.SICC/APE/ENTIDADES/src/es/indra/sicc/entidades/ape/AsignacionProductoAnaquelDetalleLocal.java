package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ASIGN_PRODU_ANAQU_DETAL")
@NamedQueries({
@NamedQuery(name="AsignacionProductoAnaquelDetalleLocal.FindAll",query="select object(o) from AsignacionProductoAnaquelDetalleLocal o"),
@NamedQuery(name="AsignacionProductoAnaquelDetalleLocal.FindByUK",query="select object(o) from AsignacionProductoAnaquelDetalleLocal o "
+ " where o.asignacionProductoAnaquelCabecera = ?1 and o.mapaCentroDistribucionDetalle = ?2 "
+ " and o.producto = ?3"),
@NamedQuery(name="AsignacionProductoAnaquelDetalleLocal.FindByCabeceraBalanceo",query="SELECT OBJECT(o)  "
+ " FROM AsignacionProductoAnaquelDetalleLocal o  "
+ " WHERE o.asignacionProductoAnaquelCabecera = ?1 "
+ " AND o.procedencia = ?2")
})
public class AsignacionProductoAnaquelDetalleLocal implements Serializable {

    public AsignacionProductoAnaquelDetalleLocal() {}

    public AsignacionProductoAnaquelDetalleLocal(Long oid, Long oidAsigProdAnaqCabe, Long oidProducto, Long procedencia) {
        this.oid=oid;
        this.setAsignacionProductoAnaquelCabecera(oidAsigProdAnaqCabe);
        this.setProducto(oidProducto);
        this.setProcedencia(procedencia);
    }

    @Id
    @Column(name="OID_ASIG_PROD_ANAQ")
    private Long oid;
    @Column(name="NUM_UNIDA")
    private Long unidades;
    @Column(name="IND_SIGU_ASIG")
    private String siguienteAsignacion;
    @Column(name="IND_ASIG_PETL")
    private Boolean asignacionPTL;
    @Column(name="APAC_OID_ASIG_PROD_ANAQ_CABE")
    private Long asignacionProductoAnaquelCabecera;
    @Column(name="PROD_OID_PROD")
    private Long producto;
    @Column(name="MCDD_OID_MAPA_CENT_DIST_DETA")
    private Long mapaCentroDistribucionDetalle;
    @Column(name="PRCE_OID_PROC")
    private Long procedencia;

    
    public Long getOid() {return oid;}
    
    public Long getUnidades() {return unidades;}
  
    public void setUnidades(Long unidades){this.unidades=unidades;}
            
    public String getSiguienteAsignacion() {return siguienteAsignacion;}
  
    public void setSiguienteAsignacion(String siguienteAsignacion){this.siguienteAsignacion=siguienteAsignacion;}
            
    public Boolean getAsignacionPTL() {return asignacionPTL;}
  
    public void setAsignacionPTL(Boolean asignacionPTL){this.asignacionPTL=asignacionPTL;}
            
    public Long getAsignacionProductoAnaquelCabecera() {return asignacionProductoAnaquelCabecera;}
  
    public void setAsignacionProductoAnaquelCabecera(Long asignacionProductoAnaquelCabecera){this.asignacionProductoAnaquelCabecera=asignacionProductoAnaquelCabecera;}
            
    public Long getProducto() {return producto;}
  
    public void setProducto(Long producto){this.producto=producto;}
            
    public Long getMapaCentroDistribucionDetalle() {return mapaCentroDistribucionDetalle;}
  
    public void setMapaCentroDistribucionDetalle(Long mapaCentroDistribucionDetalle){this.mapaCentroDistribucionDetalle=mapaCentroDistribucionDetalle;}
            
    public Long getProcedencia() {return procedencia;}
  
    public void setProcedencia(Long procedencia){this.procedencia=procedencia;}
			
	
}
