package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MENSA_CODIG_VENTA")
@NamedQueries({
@NamedQuery(name="MensajeCodigoVentaLocal.FindByMensaje",query="Select Object(i) from MensajeCodigoVentaLocal as i where i.mens_oid_mens = ?1")
})
public class MensajeCodigoVentaLocal implements Serializable {

	public MensajeCodigoVentaLocal() {}

	public MensajeCodigoVentaLocal(Long oid, Long mens_oid_mens, String val_codi_vent)	{
	
		this.oid=oid;
                this.mens_oid_mens=mens_oid_mens;
	        this.val_codi_vent=val_codi_vent;
	}

	@Id
	@Column(name="OID_MENS_CODI_VENT")
	private Long oid;
	@Column(name="MENS_OID_MENS")
	private Long mens_oid_mens;
	@Column(name="VAL_CODI_VENT")
	private String val_codi_vent;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMens_oid_mens() {return mens_oid_mens;}
      
	public void setMens_oid_mens(Long mens_oid_mens){this.mens_oid_mens=mens_oid_mens;}
		
	public String getVal_codi_vent() {return val_codi_vent;}
      
	public void setVal_codi_vent(String val_codi_vent){this.val_codi_vent=val_codi_vent;}
			
	
}
