package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_RELAC_OPERA_RECLA")
@NamedQueries({
@NamedQuery(name="RelacionOperacionRECLocal.FindAll",query="select object(o) from RelacionOperacionRECLocal o")
})
public class RelacionOperacionRECLocal implements Serializable {

	public RelacionOperacionRECLocal() {}

	public RelacionOperacionRECLocal(Long oid, Long codigoOperacion, Long codigoIVR) {
            this.oid=oid;
	    this.codigoOperacion=codigoOperacion;
	    this.codigoIVR=codigoIVR;
	}

	@Id
	@Column(name="OID_RELA_OPER_RECL")
	private Long oid;
	@Column(name="ROPE_OID_OPER")
	private Long codigoOperacion;
	@Column(name="OIVR_OID_OPER_POST_VENT_IVR")
	private Long codigoIVR;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoOperacion() {return codigoOperacion;}
      
	public void setCodigoOperacion(Long codigoOperacion){this.codigoOperacion=codigoOperacion;}
		
	public Long getCodigoIVR() {return codigoIVR;}
      
	public void setCodigoIVR(Long codigoIVR){this.codigoIVR=codigoIVR;}
			
	
}
