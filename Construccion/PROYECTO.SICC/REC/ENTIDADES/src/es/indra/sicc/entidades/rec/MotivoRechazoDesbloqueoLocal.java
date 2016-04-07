package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_MOTIV_RECHA_DESBL")
@NamedQueries({
@NamedQuery(name="MotivoRechazoDesbloqueoLocal.FindAll",query="select object(o) from MotivoRechazoDesbloqueoLocal o")
})
public class MotivoRechazoDesbloqueoLocal implements Serializable {

	public MotivoRechazoDesbloqueoLocal() {}

	public MotivoRechazoDesbloqueoLocal(Long oid, Long pais, String codigo)	{
	
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
	
	}

	@Id
	@Column(name="OID_MOTI_RECH_DESB")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_RECH_DESB")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
