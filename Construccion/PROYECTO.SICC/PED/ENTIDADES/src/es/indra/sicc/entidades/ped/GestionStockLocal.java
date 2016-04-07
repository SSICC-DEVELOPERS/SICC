package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_GESTI_STOCK")
@NamedQueries({
@NamedQuery(name="GestionStockLocal.FindAll", query="SELECT OBJECT(o) FROM GestionStockLocal AS o")
})
public class GestionStockLocal implements Serializable {

    public GestionStockLocal() {}

    public GestionStockLocal(Long oid, Long perd_oid_peri, Integer cod_gest_stoc, Long ofde_oid_deta_ofer) {
        // Parametro cod_gest_stoc no se usa
        this.oid=oid;
        this.periodo = perd_oid_peri;
        this.id = new Integer(oid.intValue());
        this.codigoVenta = ofde_oid_deta_ofer;
    }

    @Id
    @Column(name="OID_GEST_STOC")
    private Long oid;
    @Column(name="VAL_LIMI_CTRL_VENT")
    private Long limiteVenta;
    @Column(name="CLAS_OID_CLAS")
    private Long clasificacion;
    @Column(name="ZZON_OID_ZONA")
    private Long zona;
    @Column(name="PERD_OID_PERI")
    private Long periodo;
    @Column(name="IND_CTRL_LIQU")
    private Boolean controlLiquidacion;
    @Column(name="IND_ULTI_NOTI")
    private Boolean indUltNoticias;
    @Column(name="COD_GEST_STOC")
    private Integer id;
    @Column(name="VAL_PORC")
    private Double valorPorcentual;
    @Column(name="VAL_UNID")
    private Long valorUnidades;
    @Column(name="OFDE_OID_DETA_OFER")
    private Long codigoVenta;
    @Column(name="ZORG_OID_REGI")
    private Long region;
    @Column(name="SBTI_OID_SUBT_CLIE")
    private Long subtipoCliente;
    @Column(name="TCCL_OID_TIPO_CLAS")
    private Long tipoClasificacion;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long tipoCliente;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getLimiteVenta() {return limiteVenta;}
  
    public void setLimiteVenta(Long limiteVenta){this.limiteVenta=limiteVenta;}
            
    public Long getClasificacion() {return clasificacion;}
  
    public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
            
    public Long getPeriodo() {return periodo;}
  
    public void setPeriodo(Long periodo){this.periodo=periodo;}
            
    public Boolean getControlLiquidacion() {return controlLiquidacion;}
  
    public void setControlLiquidacion(Boolean controlLiquidacion){this.controlLiquidacion=controlLiquidacion;}
            
    public Boolean getIndUltNoticias() {return indUltNoticias;}
  
    public void setIndUltNoticias(Boolean indUltNoticias){this.indUltNoticias=indUltNoticias;}
            
    public Integer getId() {return id;}
  
    public void setId(Integer id){this.id=id;}
            
    public Double getValorPorcentual() {return valorPorcentual;}
  
    public void setValorPorcentual(Double valorPorcentual){this.valorPorcentual=valorPorcentual;}
            
    public Long getValorUnidades() {return valorUnidades;}
  
    public void setValorUnidades(Long valorUnidades){this.valorUnidades=valorUnidades;}
            
    public Long getCodigoVenta() {return codigoVenta;}
  
    public void setCodigoVenta(Long codigoVenta){this.codigoVenta=codigoVenta;}
            
    public Long getRegion() {return region;}
  
    public void setRegion(Long region){this.region=region;}
            
    public Long getSubtipoCliente() {return subtipoCliente;}
  
    public void setSubtipoCliente(Long subtipoCliente){this.subtipoCliente=subtipoCliente;}
            
    public Long getTipoClasificacion() {return tipoClasificacion;}
  
    public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
            
    public Long getTipoCliente() {return tipoCliente;}
  
    public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
                    
	
}
