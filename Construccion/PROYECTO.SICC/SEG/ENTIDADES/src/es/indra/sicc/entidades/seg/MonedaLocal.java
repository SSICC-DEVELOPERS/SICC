package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_MONED")
@NamedQueries({
@NamedQuery(name="MonedaLocal.FindByUK",query="Select Object(m) from MonedaLocal m"
+ " where m.codMoneda = ?1"),
@NamedQuery(name="MonedaLocal.FindAll", query="SELECT OBJECT(m) FROM MonedaLocal m")
})
public class MonedaLocal implements Serializable {

	public MonedaLocal() {}

	public MonedaLocal(Long oid, String cod_mone, Long num_deci)	{
		this.oid=oid;
		this.codMoneda = cod_mone;
		this.numDeci = num_deci;
	}

	@Id
	@Column(name="OID_MONE")
	private Long oid;
	@Column(name="COD_MONE")
	private String codMoneda;
	@Column(name="VAL_SIMB_MONE")
	private String simbolo;
	@Column(name="NUM_DECI")
	private Long numDeci;
	@Column(name="VAL_NOMB_CORT_MONE")
	private String nombreCorto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodMoneda() {return codMoneda;}
      
	public void setCodMoneda(String codMoneda){this.codMoneda=codMoneda;}
		
	public String getSimbolo() {return simbolo;}
      
	public void setSimbolo(String simbolo){this.simbolo=simbolo;}
		
	public Long getNumDeci() {return numDeci;}
      
	public void setNumDeci(Long numDeci){this.numDeci=numDeci;}
		
	public String getNombreCorto() {return nombreCorto;}
      
	public void setNombreCorto(String nombreCorto){this.nombreCorto=nombreCorto;}
			
	
}
