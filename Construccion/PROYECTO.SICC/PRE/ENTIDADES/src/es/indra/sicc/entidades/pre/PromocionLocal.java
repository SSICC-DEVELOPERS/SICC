package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="PRE_PROMO")
@NamedQueries({
@NamedQuery(name="PromocionLocal.FindByOidOferta",query="SELECT OBJECT(a) "
+" FROM PromocionLocal AS a WHERE a.oidOferta = ?1")
})
public class PromocionLocal implements Serializable {

	public PromocionLocal() {}

	public PromocionLocal(Long oid, Long ofer_oid_ofer, 
                    Integer num_cond, BigDecimal val_fact_cuad, Long indCuadrePromocion){
	
		this.oid=oid;
                this.oidOferta=ofer_oid_ofer;
                this.numeroCondicion=num_cond;
                this.factorCuadre=val_fact_cuad;
                this.indicadorCuadrePromocion=indCuadrePromocion;
	
	}

	@Id
	@Column(name="OID_PROM")
	private Long oid;
	@Column(name="OFER_OID_OFER")
	private Long oidOferta;
	@Column(name="NUM_COND")
	private Integer numeroCondicion;
	@Column(name="ICPR_OID_INDI_CUAD_PROM")
	private Long indicadorCuadrePromocion;
	@Column(name="VAL_FACT_CUAD")
	private java.math.BigDecimal factorCuadre;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidOferta() {return oidOferta;}
      
	public void setOidOferta(Long oidOferta){this.oidOferta=oidOferta;}
		
	public Integer getNumeroCondicion() {return numeroCondicion;}
      
	public void setNumeroCondicion(Integer numeroCondicion){this.numeroCondicion=numeroCondicion;}
		
	public Long getIndicadorCuadrePromocion() {return indicadorCuadrePromocion;}
      
	public void setIndicadorCuadrePromocion(Long indicadorCuadrePromocion){this.indicadorCuadrePromocion=indicadorCuadrePromocion;}
		
	public java.math.BigDecimal getFactorCuadre() {return factorCuadre;}
      
	public void setFactorCuadre(java.math.BigDecimal factorCuadre){this.factorCuadre=factorCuadre;}
			
	
}
