package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_INDIC_CUADR_PROMO")
public class IndicadorCuadrePromocionLocal implements Serializable {

	public IndicadorCuadrePromocionLocal() {}

	public IndicadorCuadrePromocionLocal(Long oid,  Integer cod_indi_cuad_prom, String val_fact_cuad) {
	
		this.oid=oid;
                this.codigo=cod_indi_cuad_prom;
                this.factorCuadre=val_fact_cuad;
	
	}

	@Id
	@Column(name="OID_INDI_CUAD_PROM")
	private Long oid;
	@Column(name="COD_INDI_CUAD_PROM")
	private Integer codigo;
	@Column(name="VAL_FACT_CUAD")
	private String factorCuadre;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public String getFactorCuadre() {return factorCuadre;}
      
	public void setFactorCuadre(String factorCuadre){this.factorCuadre=factorCuadre;}
			
	
}
