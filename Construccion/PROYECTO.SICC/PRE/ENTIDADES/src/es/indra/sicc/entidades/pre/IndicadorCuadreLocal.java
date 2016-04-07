package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_INDIC_CUADR")
public class IndicadorCuadreLocal implements Serializable {

	public IndicadorCuadreLocal() {}

	public IndicadorCuadreLocal(Long oid, Integer cod_indi_cuad, String val_fact_cuad) {
	
		this.oid=oid;
                this.codigo=cod_indi_cuad;
                this.factorCuadre=val_fact_cuad;
	
	}

	@Id
	@Column(name="OID_IND_CUAD")
	private Long oid;
	@Column(name="COD_INDI_CUAD")
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
