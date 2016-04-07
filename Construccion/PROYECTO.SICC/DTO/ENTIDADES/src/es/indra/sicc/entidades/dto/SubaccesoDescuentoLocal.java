package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_DESCU_SUBAC")
public class SubaccesoDescuentoLocal implements Serializable {

	public SubaccesoDescuentoLocal() {}

	public SubaccesoDescuentoLocal(Long oid, Long sbac_oid_sbac, Long dcto_oid_des)	{
	
		this.oid=oid;
                setSbac_oid_sbac(sbac_oid_sbac);
                setDcto_oid_desc(dcto_oid_desc);	
	}

	@Id
	@Column(name="OID_DESC_SBAC")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long sbac_oid_sbac;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSbac_oid_sbac() {return sbac_oid_sbac;}
      
	public void setSbac_oid_sbac(Long sbac_oid_sbac){this.sbac_oid_sbac=sbac_oid_sbac;}
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
			
	
}
