package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_DOCUM")
@NamedQueries({
@NamedQuery(name="TipoDocumentoLocal.FindByUK",query="select Object(t) from TipoDocumentoLocal t "
+ " where t.pais_oid_pais = ?1 and t.cod_tipo_docu = ?2"),
@NamedQuery(name="TipoDocumentoLocal.FindAll",query="select Object(t) from TipoDocumentoLocal t ")
})
public class TipoDocumentoLocal implements Serializable {

	public TipoDocumentoLocal() {}

	public TipoDocumentoLocal(Long oid, Long pais_oid_pais, String cod_tipo_docu, Long ind_obli,
                Long ind_dni, Long ind_doc_iden_fisc, Long tipoDocumentoLegal)	{
    
            this.oid=oid;
            this.pais_oid_pais = pais_oid_pais;
            this.cod_tipo_docu = cod_tipo_docu;
            this.ind_obli = ind_obli;
            this.ind_dni = ind_dni;
            this.ind_doc_iden_fisc = ind_doc_iden_fisc;
            this.tipoDocumentoLegal = tipoDocumentoLegal;
	}

	@Id
	@Column(name="OID_TIPO_DOCU")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="COD_TIPO_DOCU")
	private String cod_tipo_docu;
	@Column(name="VAL_SIGL")
	private String val_sigl;
	@Column(name="VAL_LONG")
	private Long val_long;
	@Column(name="IND_OBLI")
	private Long ind_obli;
	@Column(name="IND_DNI")
	private Long ind_dni;
	@Column(name="IND_DOC_IDEN_FISC")
	private Long ind_doc_iden_fisc;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumentoLegal;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public String getCod_tipo_docu() {return cod_tipo_docu;}
      
	public void setCod_tipo_docu(String cod_tipo_docu){this.cod_tipo_docu=cod_tipo_docu;}
		
	public String getVal_sigl() {return val_sigl;}
      
	public void setVal_sigl(String val_sigl){this.val_sigl=val_sigl;}
		
	public Long getVal_long() {return val_long;}
      
	public void setVal_long(Long val_long){this.val_long=val_long;}
		
	public Long getInd_obli() {return ind_obli;}
      
	public void setInd_obli(Long ind_obli){this.ind_obli=ind_obli;}
		
	public Long getInd_dni() {return ind_dni;}
      
	public void setInd_dni(Long ind_dni){this.ind_dni=ind_dni;}
		
	public Long getInd_doc_iden_fisc() {return ind_doc_iden_fisc;}
      
	public void setInd_doc_iden_fisc(Long ind_doc_iden_fisc){this.ind_doc_iden_fisc=ind_doc_iden_fisc;}
		
	public Long getTipoDocumentoLegal() {return tipoDocumentoLegal;}
      
	public void setTipoDocumentoLegal(Long tipoDocumentoLegal){this.tipoDocumentoLegal=tipoDocumentoLegal;}
			
	
}
