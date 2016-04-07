package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_TIPO_GESTI_CLIEN")
@NamedQueries({
 @NamedQuery(name="TipoGestionDelClienteLocal.FindAll",query="SELECT OBJECT(a) FROM TipoGestionDelClienteLocal AS a")
})
public class TipoGestionDelClienteLocal implements Serializable {

	public TipoGestionDelClienteLocal() {}

	public TipoGestionDelClienteLocal(Long oid, String cod_gest, String val_desc)	{
	
		this.oid=oid;
	        setCodGestion(cod_gest);
	        setDescripcion(val_desc);
	
	}

	@Id
	@Column(name="OID_TIPO_GEST_CLIE")
	private Long oid;
	@Column(name="COD_GEST")
	private String codGestion;
	@Column(name="VAL_DESC")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodGestion() {return codGestion;}
      
	public void setCodGestion(String codGestion){this.codGestion=codGestion;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
