package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_TIPO_DOCUM")
@NamedQueries({
@NamedQuery(name="TipoDocumentoLegalLocal.FindByUK",query="SELECT OBJECT(o) FROM TipoDocumentoLegalLocal AS o WHERE o.tipoDocumento = ?1")
})
public class TipoDocumentoLegalLocal implements Serializable {

	public TipoDocumentoLegalLocal() {}

	public TipoDocumentoLegalLocal(Long oid, String tipoDocumento, String descripcionDocumento, Long tipoDocLegalContra)	{
            this.oid=oid;
	    this.tipoDocumento = tipoDocumento;
	    this.descripcionDocumento = descripcionDocumento;
	    this.tipoDocLegalContra = tipoDocLegalContra;
        }

	@Id
	@Column(name="OID_TIPO_DOCU")
	private Long oid;
	@Column(name="COD_TIPO_DOCU")
	private String tipoDocumento;
	@Column(name="DES_TIPO_DOCU")
	private String descripcionDocumento;
	@Column(name="TIDO_OID_TIPO_DOCU_CONT")
	private Long tipoDocLegalContra;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(String tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public String getDescripcionDocumento() {return descripcionDocumento;}
      
	public void setDescripcionDocumento(String descripcionDocumento){this.descripcionDocumento=descripcionDocumento;}
		
	public Long getTipoDocLegalContra() {return tipoDocLegalContra;}
      
	public void setTipoDocLegalContra(Long tipoDocLegalContra){this.tipoDocLegalContra=tipoDocLegalContra;}
			
	
}
