package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_MENSA_CALLC")
@NamedQueries({
@NamedQuery(name="MensajeCallCenterLocal.FindByUK",query="SELECT OBJECT(a) "
 + "FROM MensajeCallCenterLocal AS a "
 + "WHERE a.pais = ?1"),
 @NamedQuery(name="MensajeCallCenterLocal.FindAll",query="SELECT OBJECT(a) FROM MensajeCallCenterLocal AS a")
})
public class MensajeCallCenterLocal implements Serializable {

	public MensajeCallCenterLocal() {}

	public MensajeCallCenterLocal(Long oid, String val_text_mens, Long pais_oid_pais)	{
	
		this.oid=oid;
	        setTextoMensaje(val_text_mens);
	        setPais(pais_oid_pais);
	
	}

	@Id
	@Column(name="OID_MENS_CALL")
	private Long oid;
	@Column(name="VAL_TEXT_MENS")
	private String textoMensaje;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getTextoMensaje() {return textoMensaje;}
      
	public void setTextoMensaje(String textoMensaje){this.textoMensaje=textoMensaje;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
