package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="PED_FLETE")
@NamedQueries({
@NamedQuery(name="FleteLocal.FindAll", query="SELECT OBJECT(o) FROM FleteLocal AS o")
})
public class FleteLocal implements Serializable {

    public FleteLocal() {}

    public FleteLocal(Long oid, Long cana_oid_cana, Long tids_oid_tipo_desp, Long marc_oid_marc, Long tipoCliente)	{
        this.oid=oid;
        this.canal = cana_oid_cana;
        this.tipoDespacho = tids_oid_tipo_desp;
        this.marca = marc_oid_marc;
        this.tipoCliente = tipoCliente;
    }

    @Id
    @Column(name="OID_FLETE")
    private Long oid;
    @Column(name="VAL_MONT_FIJO")
    private BigDecimal montoFijo;
    @Column(name="VAL_TASA")
    private BigDecimal tasa;
    @Column(name="VAL_FLET_MINI")
    private BigDecimal fleteMin;
    @Column(name="VAL_FLET_MAXI")
    private BigDecimal fleteMax;
    @Column(name="VAL_CONT_ENTR")
    private BigDecimal contraEntrega;
    @Column(name="CANA_OID_CANA")
    private Long canal;
    @Column(name="TIDS_OID_TIPO_DESP")
    private Long tipoDespacho;
    @Column(name="MARC_OID_MARC")
    private Long marca;
    @Column(name="CLAS_OID_CLAS")
    private Long clasificacion;
    @Column(name="SBTI_OID_SUBT_CLIE")
    private Long subtipoCliente;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long tipoCliente;
    @Column(name="TCCL_OID_TIPO_CLAS")
    private Long tipoClasificacion;
    @Column(name="ZZON_ZONA")
    private Long zona;
    @Column(name="VEPO_UBIG")
    private Long ubigeo;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public BigDecimal getMontoFijo() {return montoFijo;}
  
    public void setMontoFijo(BigDecimal montoFijo){this.montoFijo=montoFijo;}
            
    public BigDecimal getTasa() {return tasa;}
  
    public void setTasa(BigDecimal tasa){this.tasa=tasa;}
            
    public BigDecimal getFleteMin() {return fleteMin;}
  
    public void setFleteMin(BigDecimal fleteMin){this.fleteMin=fleteMin;}
            
    public BigDecimal getFleteMax() {return fleteMax;}
  
    public void setFleteMax(BigDecimal fleteMax){this.fleteMax=fleteMax;}
            
    public BigDecimal getContraEntrega() {return contraEntrega;}
  
    public void setContraEntrega(BigDecimal contraEntrega){this.contraEntrega=contraEntrega;}
            
    public Long getCanal() {return canal;}
  
    public void setCanal(Long canal){this.canal=canal;}
            
    public Long getTipoDespacho() {return tipoDespacho;}
  
    public void setTipoDespacho(Long tipoDespacho){this.tipoDespacho=tipoDespacho;}
            
    public Long getMarca() {return marca;}
  
    public void setMarca(Long marca){this.marca=marca;}
            
    public Long getClasificacion() {return clasificacion;}
  
    public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
            
    public Long getSubtipoCliente() {return subtipoCliente;}
  
    public void setSubtipoCliente(Long subtipoCliente){this.subtipoCliente=subtipoCliente;}
            
    public Long getTipoCliente() {return tipoCliente;}
  
    public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
            
    public Long getTipoClasificacion() {return tipoClasificacion;}
  
    public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
            
    public Long getUbigeo() {return ubigeo;}
  
    public void setUbigeo(Long ubigeo){this.ubigeo=ubigeo;}
                    
	
}
