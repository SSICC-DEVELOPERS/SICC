package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_DESCU_TIPO_CLIEN")
public class TipoClienteDescuentoLocal implements Serializable {

	public TipoClienteDescuentoLocal() {}

	public TipoClienteDescuentoLocal(Long oid, Long ticl_oid_tipo_clie, Long dcto_oid_desc)	{
	
		this.oid=oid;
                setTicl_oid_tipo_clie(ticl_oid_tipo_clie);
                setDcto_oid_desc(dcto_oid_desc);	

	}

	@Id
	@Column(name="OID_DESC_TIPO_CLIE")
	private Long oid;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long ticl_oid_tipo_clie;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTicl_oid_tipo_clie() {return ticl_oid_tipo_clie;}
      
	public void setTicl_oid_tipo_clie(Long ticl_oid_tipo_clie){this.ticl_oid_tipo_clie=ticl_oid_tipo_clie;}
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
			
	
}
