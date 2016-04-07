package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_PROGR_FIDEL")
@NamedQueries({
@NamedQuery(name="ProgramasFidelizacionLocal.FindAll",query="select object(o) from ProgramasFidelizacionLocal o")
})
public class ProgramasFidelizacionLocal implements Serializable {

	public ProgramasFidelizacionLocal() {}

	public ProgramasFidelizacionLocal(Long oid, String codigo, String descripcion, Long pais)	{
            this.oid=oid;
            this.codigo = codigo;
            this.descripcion = descripcion;
            this.pais = pais;
	}

	@Column(name="COD_PROG_FIDE")
	private String codigo;
	@Id
	@Column(name="OID_PROG_FIDE")
	private Long oid;
	@Column(name="DES_PROG_FIDE")
	private String descripcion;
	@Column(name="FACT_CONV")
	private java.math.BigDecimal factorConversion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public java.math.BigDecimal getFactorConversion() {return factorConversion;}
      
	public void setFactorConversion(java.math.BigDecimal factorConversion){this.factorConversion=factorConversion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
