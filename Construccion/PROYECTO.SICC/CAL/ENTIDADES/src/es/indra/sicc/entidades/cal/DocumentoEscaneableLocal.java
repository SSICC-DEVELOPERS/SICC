package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_DOCUM_ESCAN")
@NamedQueries({
@NamedQuery(name="DocumentoEscaneableLocal.FindAll",query="select object(o) from DocumentoEscaneableLocal o")
})
public class DocumentoEscaneableLocal implements Serializable {

	public DocumentoEscaneableLocal() {}

	public DocumentoEscaneableLocal(Long oid, String numeroDocumentoEscaneable, Long tipoDocumento, Long cliente)	{
	
		this.oid=oid;
	        setNumeroDocumentoEscaneable(numeroDocumentoEscaneable);
	        setTipoDocumento(tipoDocumento);
	        setCliente(cliente);
	
	}

	@Id
	@Column(name="OID_DOCU_ESCA")
	private Long oid;
	@Column(name="NUM_DOCU_ESCA")
	private String numeroDocumentoEscaneable;
	@Column(name="TOID_OID_TIPO_DOCU_ESCA")
	private Long tipoDocumento;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getNumeroDocumentoEscaneable() {return numeroDocumentoEscaneable;}
      
	public void setNumeroDocumentoEscaneable(String numeroDocumentoEscaneable){this.numeroDocumentoEscaneable=numeroDocumentoEscaneable;}
		
	public Long getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
			
	
}
