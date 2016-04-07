package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PRODU")
@NamedQueries({
@NamedQuery(name="ProductosLocal.FindAll",query="select object(o) from ProductosLocal o"),
@NamedQuery(name="ProductosLocal.FindByUK",query="SELECT OBJECT (a) "
+ " FROM ProductosLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ProductosLocal implements Serializable {

	public ProductosLocal() {}

	public ProductosLocal(Long oid, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setComunicacionBonificados(Boolean.FALSE);
	        this.setComunicacionExcluidos(Boolean.FALSE);
	        this.setComunicacionExigidos(Boolean.FALSE);
	        this.setComunicacionValidos(Boolean.FALSE);   
	
	}

	@Id
	@Column(name="OID_PROD")
	private Long oid;
	@Column(name="VAL_COMU_VALI")
	private Boolean comunicacionValidos;
	@Column(name="VAL_MENS_VALI")
	private String mensajeValidos;
	@Column(name="VAL_COMU_EXIG")
	private Boolean comunicacionExigidos;
	@Column(name="VAL_MENS_EXIG")
	private String mensajeExigidos;
	@Column(name="VAL_COMU_EXCL")
	private Boolean comunicacionExcluidos;
	@Column(name="VAL_MENS_EXCL")
	private String mensajeExcluidos;
	@Column(name="VAL_COMU_BONI")
	private Boolean comunicacionBonificados;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="VAL_MENS_BONI")
	private String mensajeBonificados;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getComunicacionValidos() {return comunicacionValidos;}
      
	public void setComunicacionValidos(Boolean comunicacionValidos){this.comunicacionValidos=comunicacionValidos;}
		
	public String getMensajeValidos() {return mensajeValidos;}
      
	public void setMensajeValidos(String mensajeValidos){this.mensajeValidos=mensajeValidos;}
		
	public Boolean getComunicacionExigidos() {return comunicacionExigidos;}
      
	public void setComunicacionExigidos(Boolean comunicacionExigidos){this.comunicacionExigidos=comunicacionExigidos;}
		
	public String getMensajeExigidos() {return mensajeExigidos;}
      
	public void setMensajeExigidos(String mensajeExigidos){this.mensajeExigidos=mensajeExigidos;}
		
	public Boolean getComunicacionExcluidos() {return comunicacionExcluidos;}
      
	public void setComunicacionExcluidos(Boolean comunicacionExcluidos){this.comunicacionExcluidos=comunicacionExcluidos;}
		
	public String getMensajeExcluidos() {return mensajeExcluidos;}
      
	public void setMensajeExcluidos(String mensajeExcluidos){this.mensajeExcluidos=mensajeExcluidos;}
		
	public Boolean getComunicacionBonificados() {return comunicacionBonificados;}
      
	public void setComunicacionBonificados(Boolean comunicacionBonificados){this.comunicacionBonificados=comunicacionBonificados;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public String getMensajeBonificados() {return mensajeBonificados;}
      
	public void setMensajeBonificados(String mensajeBonificados){this.mensajeBonificados=mensajeBonificados;}
			
	
}
