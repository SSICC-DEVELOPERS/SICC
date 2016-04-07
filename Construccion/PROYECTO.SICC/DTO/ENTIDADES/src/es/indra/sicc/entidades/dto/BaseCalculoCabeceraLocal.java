package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_BASE_CALCU_CABEC")
public class BaseCalculoCabeceraLocal implements Serializable {

	public BaseCalculoCabeceraLocal() {}

	public BaseCalculoCabeceraLocal(Long oid, Long dcto_oid_desc)	{
	
		this.oid=oid;
                this.dcto_oid_desc = dcto_oid_desc;
	
	}

	@Id
	@Column(name="OID_CABE")
	private Long oid;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
			
	
}
