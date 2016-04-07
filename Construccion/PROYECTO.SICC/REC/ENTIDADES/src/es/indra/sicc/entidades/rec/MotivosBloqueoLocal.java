package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_MOTIV_BLOQU")
@NamedQueries({
@NamedQuery(name="MotivosBloqueoLocal.FindAll",query="select object(o) from MotivosBloqueoLocal o")
})
public class MotivosBloqueoLocal implements Serializable {

	public MotivosBloqueoLocal() {}

	public MotivosBloqueoLocal(Long oid, String motivoBloqueo, Long pais)	{
	
		this.oid=oid;
                this.motivoBloqueo=motivoBloqueo;
                this.pais=pais;
	}

	@Id
	@Column(name="OID_MOTI_BLOQ")
	private Long oid;
	@Column(name="VAL_MOTI_BLOQ")
	private String motivoBloqueo;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getMotivoBloqueo() {return motivoBloqueo;}
      
	public void setMotivoBloqueo(String motivoBloqueo){this.motivoBloqueo=motivoBloqueo;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
