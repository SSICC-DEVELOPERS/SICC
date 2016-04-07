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
@Table(name="PED_MONTO_MINIM")
@NamedQueries({
@NamedQuery(name="MontoMinimoLocal.FindAll", query="SELECT OBJECT(o) FROM MontoMinimoLocal AS o")
})
public class MontoMinimoLocal implements Serializable {

    public MontoMinimoLocal() {}

    public MontoMinimoLocal(Long oid, BigDecimal val_niv1, BigDecimal val_niv2,
            BigDecimal val_niv3, Long ticl_oid_tipo_clie, Long tspa_oid_tipo_soli_pais) {
    
        this.oid=oid;
        this.nivel1 = val_niv1;
        this.nivel2 = val_niv2;
        this.nivel3 = val_niv3;
        this.oidTipoCliente = ticl_oid_tipo_clie;
        this.tipoSolicitudPais = tspa_oid_tipo_soli_pais;
    }

    @Id
    @Column(name="OID_MONT_MINI")
    private Long oid;
    @Column(name="VAL_NIV1")
    private BigDecimal nivel1;
    @Column(name="VAL_NIV2")
    private BigDecimal nivel2;
    @Column(name="VAL_NIV3")
    private BigDecimal nivel3;
    @Column(name="VAL_RECA")
    private BigDecimal recargo;
    @Column(name="VAL_MONT_MINI_NOMI")
    private BigDecimal montoMinimo;
    @Column(name="CLAS_OID_CLAS")
    private Long clasificacion;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long tipoSolicitudPais;
    @Column(name="SBTI_OID_SUBT_CLIE")
    private Long subtipoCliente;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long oidTipoCliente;
    @Column(name="TCCL_OID_TIPO_CLAS")
    private Long tipoClasificacion;
    @Column(name="ZORG_OID_REGI")
    private Long region;
    @Column(name="ZZON_OID_ZONA")
    private Long zona;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public BigDecimal getNivel1() {return nivel1;}
  
    public void setNivel1(BigDecimal nivel1){this.nivel1=nivel1;}
            
    public BigDecimal getNivel2() {return nivel2;}
  
    public void setNivel2(BigDecimal nivel2){this.nivel2=nivel2;}
            
    public BigDecimal getNivel3() {return nivel3;}
  
    public void setNivel3(BigDecimal nivel3){this.nivel3=nivel3;}
            
    public BigDecimal getRecargo() {return recargo;}
  
    public void setRecargo(BigDecimal recargo){this.recargo=recargo;}
            
    public BigDecimal getMontoMinimo() {return montoMinimo;}
  
    public void setMontoMinimo(BigDecimal montoMinimo){this.montoMinimo=montoMinimo;}
            
    public Long getClasificacion() {return clasificacion;}
  
    public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
            
    public Long getTipoSolicitudPais() {return tipoSolicitudPais;}
  
    public void setTipoSolicitudPais(Long tipoSolicitudPais){this.tipoSolicitudPais=tipoSolicitudPais;}
            
    public Long getSubtipoCliente() {return subtipoCliente;}
  
    public void setSubtipoCliente(Long subtipoCliente){this.subtipoCliente=subtipoCliente;}
            
    public Long getOidTipoCliente() {return oidTipoCliente;}
  
    public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
            
    public Long getTipoClasificacion() {return tipoClasificacion;}
  
    public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
                    
    public Long getRegion() {return region;}
    
    public void setRegion(Long region){this.region=region;}                    

    public Long getZona() {return zona;}
    
    public void setZona(Long zona){this.zona=zona;}
	
}
