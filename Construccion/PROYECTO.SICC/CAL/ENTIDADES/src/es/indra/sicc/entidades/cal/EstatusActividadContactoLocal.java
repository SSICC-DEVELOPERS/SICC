package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_ESTAT_ACTIV_CONTA")
@NamedQueries({
 @NamedQuery(name="EstatusActividadContactoLocal.FindAll",query="SELECT OBJECT(a) FROM EstatusActividadContactoLocal AS a")
})
public class EstatusActividadContactoLocal implements Serializable {

	public EstatusActividadContactoLocal() {}

	public EstatusActividadContactoLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_ESTA_ACTI_CONT")
	private Long oid;
	@Column(name="COD_ESTA")
	private String codEstatus;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodEstatus() {return codEstatus;}
      
	public void setCodEstatus(String codEstatus){this.codEstatus=codEstatus;}
			
	
}
