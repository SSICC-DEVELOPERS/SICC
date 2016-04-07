package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_BASE_APLIC_CABEC")
public class BaseAplicacionCabeceraLocal implements Serializable {

	public BaseAplicacionCabeceraLocal() {}

	public BaseAplicacionCabeceraLocal(Long oid, Long dcto_oid_desc)	{
	
		this.oid=oid;
                this.dcto_oid_desc = dcto_oid_desc;
	
	}

	@Id
	@Column(name="OID_CABE")
	private Long oid;
	@Column(name="NUM_UNID_OBLI")
	private Long num_unid_obli;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNum_unid_obli() {return num_unid_obli;}
      
	public void setNum_unid_obli(Long num_unid_obli){this.num_unid_obli=num_unid_obli;}
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
			
	
}
