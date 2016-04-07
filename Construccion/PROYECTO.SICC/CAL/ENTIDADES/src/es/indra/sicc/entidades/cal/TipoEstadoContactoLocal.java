package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_TIPO_ESTAD_CONTA")
@NamedQueries({
 @NamedQuery(name="TipoEstadoContactoLocal.FindAll",query="SELECT OBJECT(a) FROM TipoEstadoContactoLocal AS a")
})
public class TipoEstadoContactoLocal implements Serializable {

	public TipoEstadoContactoLocal() {}

	public TipoEstadoContactoLocal(Long oid, String cod_esta)	{
	
		this.oid=oid;
	        setCodEstado(cod_esta);
	
	}

	@Id
	@Column(name="OID_TIPO_ESTA_CONT")
	private Long oid;
	@Column(name="COD_ESTA")
	private String codEstado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodEstado() {return codEstado;}
      
	public void setCodEstado(String codEstado){this.codEstado=codEstado;}
			
	
}
