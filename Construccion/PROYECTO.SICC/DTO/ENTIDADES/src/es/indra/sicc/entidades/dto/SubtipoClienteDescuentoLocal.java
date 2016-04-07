package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_DESCU_SUBTI_CLIEN")
public class SubtipoClienteDescuentoLocal implements Serializable {

	public SubtipoClienteDescuentoLocal() {}

	public SubtipoClienteDescuentoLocal(Long oid, Long dcto_oid_desc, Long sbti_oid_subt_clie)	{
	
		this.oid=oid;
                setDcto_oid_desc(dcto_oid_desc);
                setSbti_oid_subt_clie(sbti_oid_subt_clie);	
	}

	@Id
	@Column(name="OID_DESC_SUBT_CLIE")
	private Long oid;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
			
	
}
