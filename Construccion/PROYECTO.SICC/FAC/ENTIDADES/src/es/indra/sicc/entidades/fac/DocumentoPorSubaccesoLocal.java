package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_DOCUM_SUBAC")
@NamedQueries({
@NamedQuery(name="DocumentoPorSubaccesoLocal.FindByUK",query="SELECT OBJECT(t) FROM DocumentoPorSubaccesoLocal AS t WHERE t.subacceso=?1 AND t.empresa=?2 AND t.tipoDocumento=?3 AND t.pais=?4")
})
public class DocumentoPorSubaccesoLocal implements Serializable {

	public DocumentoPorSubaccesoLocal() {}

	public DocumentoPorSubaccesoLocal(Long oid, Long empresa, Long subacceso, Long tipoDocumento, Long ultimoNumDocLegal, Long limiteNumDocLegal, Long ultimoEjercicioDocInterno,
                            String serieDocLegal, Long ultimoNumDocInterno, Long pais)	{
            this.oid=oid;
	    this.empresa = empresa;
	    this.subacceso = subacceso;
	    this.tipoDocumento = tipoDocumento;
	    this.ultimoNumDocLegal = ultimoNumDocLegal;
	    this.limiteNumDocLegal = limiteNumDocLegal;
	    this.ultimoEjercicioDocInterno = ultimoEjercicioDocInterno;
	    this.serieDocLegal = serieDocLegal;
	    this.ultimoNumDocInterno = ultimoNumDocInterno;
	    this.pais = pais;
	}

	@Id
	@Column(name="OID_DOCU_SUBA")
	private Long oid;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumento;
	@Column(name="VAL_ULTI_NUME_DOCU_LEGA")
	private Long ultimoNumDocLegal;
	@Column(name="VAL_LIMI_NUME_DOCU_LEGA")
	private Long limiteNumDocLegal;
	@Column(name="VAL_ULTI_EJER_DOCU_INTE")
	private Long ultimoEjercicioDocInterno;
	@Column(name="VAL_SERI_DOCU_LEGA")
	private String serieDocLegal;
	@Column(name="VAL_ULTI_NUME_DOCU_INTE")
	private Long ultimoNumDocInterno;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public Long getUltimoNumDocLegal() {return ultimoNumDocLegal;}
      
	public void setUltimoNumDocLegal(Long ultimoNumDocLegal){this.ultimoNumDocLegal=ultimoNumDocLegal;}
		
	public Long getLimiteNumDocLegal() {return limiteNumDocLegal;}
      
	public void setLimiteNumDocLegal(Long limiteNumDocLegal){this.limiteNumDocLegal=limiteNumDocLegal;}
		
	public Long getUltimoEjercicioDocInterno() {return ultimoEjercicioDocInterno;}
      
	public void setUltimoEjercicioDocInterno(Long ultimoEjercicioDocInterno){this.ultimoEjercicioDocInterno=ultimoEjercicioDocInterno;}
		
	public String getSerieDocLegal() {return serieDocLegal;}
      
	public void setSerieDocLegal(String serieDocLegal){this.serieDocLegal=serieDocLegal;}
		
	public Long getUltimoNumDocInterno() {return ultimoNumDocInterno;}
      
	public void setUltimoNumDocInterno(Long ultimoNumDocInterno){this.ultimoNumDocInterno=ultimoNumDocInterno;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
