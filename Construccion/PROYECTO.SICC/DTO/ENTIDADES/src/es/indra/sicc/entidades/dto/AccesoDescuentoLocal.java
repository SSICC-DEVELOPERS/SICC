package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_DESCU_ACCES")
public class AccesoDescuentoLocal implements Serializable {

	public AccesoDescuentoLocal() {}

	public AccesoDescuentoLocal(Long oid, Long dcto_oid_desc, Long acce_oid_acce)	{
	
		this.oid = oid;
                this.dcto_oid_desc = dcto_oid_desc;
                this.acce_oid_acce = acce_oid_acce;
	}

	@Id
	@Column(name="OID_DESC_ACCE")
	private Long oid;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;
	@Column(name="ACCE_OID_ACCE")
	private Long acce_oid_acce;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
		
	public Long getAcce_oid_acce() {return acce_oid_acce;}
      
	public void setAcce_oid_acce(Long acce_oid_acce){this.acce_oid_acce=acce_oid_acce;}
			
	
}
