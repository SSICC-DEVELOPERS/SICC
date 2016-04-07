package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_IDIOM")
@NamedQueries({
@NamedQuery(name="IdiomaLocal.FindAll",query="select object(o) from IdiomaLocal o"),
@NamedQuery(name="IdiomaLocal.FindByCodigo",query="SELECT OBJECT(i) "
+ " FROM IdiomaLocal AS i "
+ " WHERE i.codigo = ?1")
})
public class IdiomaLocal implements Serializable {

	public IdiomaLocal() {}

	public IdiomaLocal(Long oid, String codIdio, Boolean indIdioTrad, String codIsoIdio)	{
		this.oid=oid;
		this.codigo = codIdio;
		this.idiomaTraducible = indIdioTrad;
		this.codigoISO = codIsoIdio;	
	}

	@Id
	@Column(name="OID_IDIO")
	private Long oid;
	@Column(name="COD_IDIO")
	private String codigo;
	@Column(name="IND_IDIO_TRAD")
	private Boolean idiomaTraducible;
	@Column(name="COD_ISO_IDIO")
	private String codigoISO;

	
	public Long getOid() {return oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Boolean getIdiomaTraducible() {return idiomaTraducible;}
      
	public void setIdiomaTraducible(Boolean idiomaTraducible){this.idiomaTraducible=idiomaTraducible;}
		
	public String getCodigoISO() {return codigoISO;}
      
	public void setCodigoISO(String codigoISO){this.codigoISO=codigoISO;}
			
	
}
