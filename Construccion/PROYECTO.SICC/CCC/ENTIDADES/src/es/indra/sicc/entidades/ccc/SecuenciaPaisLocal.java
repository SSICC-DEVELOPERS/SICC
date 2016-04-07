package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_SECUE_PAIS")
public class SecuenciaPaisLocal implements Serializable {

	public SecuenciaPaisLocal() {}

	public SecuenciaPaisLocal(Long oid, Long pais, Long secuencia)	{
	
		this.oid=oid;
                this.pais=pais;
                this.secuencia=secuencia;
	
	}

	@Id
	@Column(name="OID_SECU_PAIS")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="NUM_ANIO")
	private Long anio;
	@Column(name="NUM_MES")
	private Long mes;
	@Column(name="NUM_SECU")
	private Long secuencia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getAnio() {return anio;}
      
	public void setAnio(Long anio){this.anio=anio;}
		
	public Long getMes() {return mes;}
      
	public void setMes(Long mes){this.mes=mes;}
		
	public Long getSecuencia() {return secuencia;}
      
	public void setSecuencia(Long secuencia){this.secuencia=secuencia;}
			
	
}
