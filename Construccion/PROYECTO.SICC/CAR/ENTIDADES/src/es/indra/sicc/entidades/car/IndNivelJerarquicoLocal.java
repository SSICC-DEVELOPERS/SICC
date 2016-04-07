package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_INDIC_NIVEL_JERAR")
public class IndNivelJerarquicoLocal implements Serializable {

	public IndNivelJerarquicoLocal() {}

	public IndNivelJerarquicoLocal(Long oid, String cod_indi_nive_jera)	{
	
		this.oid=oid;
                this.setCodigoIndicadorNivelJerarquico(cod_indi_nive_jera);
	
	}

	@Id
	@Column(name="OID_INDI_NIVE_JERA")
	private Long oid;
	@Column(name="COD_INDI_NIVE_JERA")
	private String codigoIndicadorNivelJerarquico;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoIndicadorNivelJerarquico() {return codigoIndicadorNivelJerarquico;}
      
	public void setCodigoIndicadorNivelJerarquico(String codigoIndicadorNivelJerarquico){this.codigoIndicadorNivelJerarquico=codigoIndicadorNivelJerarquico;}
			
	
}
