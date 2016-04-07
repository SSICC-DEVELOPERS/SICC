package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ZON_SUB_GEREN_VENTA")
@NamedQueries({
@NamedQuery(name="SubGerenciaVentaLocal.FindByCodigo", query="SELECT OBJECT(o) FROM SubGerenciaVentaLocal AS o "
+ " WHERE o.oidMarca = ?1 and o.oidPais = ?2 and o.oidCanal = ?3 and o.codigoSubgVenta = ?4 and o.borrado = 0"),
@NamedQuery(name="SubGerenciaVentaLocal.FindAll", query="SELECT OBJECT(o) FROM SubGerenciaVentaLocal AS o")
})
public class SubGerenciaVentaLocal implements Serializable {

    public SubGerenciaVentaLocal() {}

    public SubGerenciaVentaLocal(Long oidSubgVenta, String cod_subg_vent, Long cana_oid_cana,
            Long marc_oid_marc, Long pais_oid_pais, Long oidPeriodoInicio) {
        
        this.oidSubgVenta=oidSubgVenta;
        this.codigoSubgVenta = cod_subg_vent;
        this.oidCanal = cana_oid_cana;
        this.oidMarca = marc_oid_marc;
        this.oidPais = pais_oid_pais;
        this.periodoInic = oidPeriodoInicio;
    }

    @Id
    @Column(name="OID_SUBG_VENT")
    private Long oidSubgVenta;
    @Column(name="COD_SUBG_VENT")
    private String codigoSubgVenta;
    @Column(name="IND_BORR")
    private Long borrado;
    @Column(name="IND_ACTI")
    private Long activo;
    @Column(name="CANA_OID_CANA")
    private Long oidCanal;
    @Column(name="MARC_OID_MARC")
    private Long oidMarca;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="COD_NSE1")
    private String codNse1;
    @Column(name="COD_NSE2")
    private String codNse2;
    @Column(name="COD_NSE3")
    private String codNse3;
    @Column(name="DES_SUBG_VENT")
    private String descripcionSubgVenta;
    @Column(name="CLIE_OID_CLIE")
    private Long oidCliente;
    @Column(name="PERD_OID_PERI_FINA")
    private Long periodoFin;
    @Column(name="PERD_OID_PERI_INIC")
    private Long periodoInic;

    
    public Long getOidSubgVenta() {return oidSubgVenta;}
    
    public Long getPrimaryKey() {return oidSubgVenta;}		
            
    public String getCodigoSubgVenta() {return codigoSubgVenta;}
  
    public void setCodigoSubgVenta(String codigoSubgVenta){this.codigoSubgVenta=codigoSubgVenta;}
            
    public Long getBorrado() {return borrado;}
  
    public void setBorrado(Long borrado){this.borrado=borrado;}
            
    public Long getActivo() {return activo;}
  
    public void setActivo(Long activo){this.activo=activo;}
            
    public Long getOidCanal() {return oidCanal;}
  
    public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
            
    public Long getOidMarca() {return oidMarca;}
  
    public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public String getCodNse1() {return codNse1;}
  
    public void setCodNse1(String codNse1){this.codNse1=codNse1;}
            
    public String getCodNse2() {return codNse2;}
  
    public void setCodNse2(String codNse2){this.codNse2=codNse2;}
            
    public String getCodNse3() {return codNse3;}
  
    public void setCodNse3(String codNse3){this.codNse3=codNse3;}
            
    public String getDescripcionSubgVenta() {return descripcionSubgVenta;}
  
    public void setDescripcionSubgVenta(String descripcionSubgVenta){this.descripcionSubgVenta=descripcionSubgVenta;}
            
    public Long getOidCliente() {return oidCliente;}
  
    public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
            
    public Long getPeriodoFin() {return periodoFin;}
  
    public void setPeriodoFin(Long periodoFin){this.periodoFin=periodoFin;}
            
    public Long getPeriodoInic() {return periodoInic;}
  
    public void setPeriodoInic(Long periodoInic){this.periodoInic=periodoInic;}
                    
}
