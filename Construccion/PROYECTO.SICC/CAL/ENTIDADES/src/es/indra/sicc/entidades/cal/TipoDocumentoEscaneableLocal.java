package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_TIPO_DOCUM_ESCAN")
@NamedQueries({
@NamedQuery(name="TipoDocumentoEscaneableLocal.FindAll",query="select object(o) from TipoDocumentoEscaneableLocal o")
})
public class TipoDocumentoEscaneableLocal implements Serializable {

	public TipoDocumentoEscaneableLocal() {}

	public TipoDocumentoEscaneableLocal(Long oid, String tipoDocumento)	{
	
		this.oid=oid;
	        setTipoDocumento(tipoDocumento);
	
	}

	@Id
	@Column(name="OID_TIPO_DOCU_ESCA")
	private Long oid;
	@Column(name="VAL_TIPO_DOCU")
	private String tipoDocumento;
	@Column(name="VAL_DESC")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(String tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
