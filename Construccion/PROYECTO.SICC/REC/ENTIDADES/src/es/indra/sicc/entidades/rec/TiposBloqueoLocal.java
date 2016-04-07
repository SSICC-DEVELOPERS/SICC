package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_TIPOS_BLOQU")
@NamedQueries({
@NamedQuery(name="TiposBloqueoLocal.FindAll",query="select object(o) from TiposBloqueoLocal o"),
@NamedQuery(name="TiposBloqueoLocal.FindByUK",query="SELECT OBJECT(s) FROM TiposBloqueoLocal s WHERE s.pais = ?1 AND s.codTipoBloqueo =?2")
})
public class TiposBloqueoLocal implements Serializable {

	public TiposBloqueoLocal() {}

	public TiposBloqueoLocal(Long oid, String codTipoBloqueo, Long pais)	{
	
		this.oid=oid;
                this.codTipoBloqueo=codTipoBloqueo;
                this.pais=pais;
	
	}

	@Id
	@Column(name="OID_TIPO_BLOQ")
	private Long oid;
	@Column(name="COD_TIPO_BLOQ")
	private String codTipoBloqueo;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodTipoBloqueo() {return codTipoBloqueo;}
      
	public void setCodTipoBloqueo(String codTipoBloqueo){this.codTipoBloqueo=codTipoBloqueo;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
