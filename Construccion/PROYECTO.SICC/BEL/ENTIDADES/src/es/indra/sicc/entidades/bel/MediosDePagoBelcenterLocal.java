package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_MEDIO_PAGO_BELCE")
public class MediosDePagoBelcenterLocal implements Serializable {

	public MediosDePagoBelcenterLocal() {}

	public MediosDePagoBelcenterLocal(Long oid, Long mediosDePago, Long subacceso)	{
		this.oid=oid;
                this.mediosDePago = mediosDePago;
                this.subacceso = subacceso;
	}

	@Id
	@Column(name="OID_MEDI_PAGO_BELC")
	private Long oid;
	@Column(name="MPAB_OID_MEDI_PAGO")
	private Long mediosDePago;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMediosDePago() {return mediosDePago;}
      
	public void setMediosDePago(Long mediosDePago){this.mediosDePago=mediosDePago;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
			
	
}
