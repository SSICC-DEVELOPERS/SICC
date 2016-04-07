package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_ALCAN_DTO_CLASI_CLIEN")
public class AlcanceDescuentoClasificacionLocal implements Serializable {

	public AlcanceDescuentoClasificacionLocal() {}

	public AlcanceDescuentoClasificacionLocal(Long oid, Long dcto_oid_desc, Long clas_oid_clas) {
	
		this.oid=oid;
                this.dcto_oid_desc = dcto_oid_desc;
                this.clas_oid_clas = clas_oid_clas;
	
	}

	@Id
	@Column(name="OID_ALCA_DTO_CLAS_CLTE")
	private Long oid;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;
	@Column(name="CLAS_OID_CLAS")
	private Long clas_oid_clas;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tccl_oid_tipo_clas;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
		
	public Long getClas_oid_clas() {return clas_oid_clas;}
      
	public void setClas_oid_clas(Long clas_oid_clas){this.clas_oid_clas=clas_oid_clas;}
		
	public Long getTccl_oid_tipo_clas() {return tccl_oid_tipo_clas;}
      
	public void setTccl_oid_tipo_clas(Long tccl_oid_tipo_clas){this.tccl_oid_tipo_clas=tccl_oid_tipo_clas;}
			
	
}
