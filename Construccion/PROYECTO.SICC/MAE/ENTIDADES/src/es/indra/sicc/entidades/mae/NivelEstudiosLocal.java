package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_NIVEL_ESTUD")
@NamedQueries({
@NamedQuery(name="NivelEstudiosLocal.FindAll",query="select object(o) from NivelEstudiosLocal o"),
@NamedQuery(name="NivelEstudiosLocal.FindByUK",query="select object(n) from NivelEstudiosLocal n where n.pais = ?1 and n.codigo = ?2")
})
public class NivelEstudiosLocal implements Serializable {

	public NivelEstudiosLocal() {}

	public NivelEstudiosLocal(Long oid, Long pais, String codigo)	{
            this.oid=oid;
            this.pais = pais;
            this.codigo = codigo;
	}

	@Id
	@Column(name="OID_NIVE_ESTU")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_NIVE_ESTU")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
