package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_CLASI")
public class ParametroClasificacionLocal implements Serializable {

	public ParametroClasificacionLocal() {}

	public ParametroClasificacionLocal(Long oid, Long clas_oid_clas, Long ind_valo_defe, Long ptdt_para_tipo_desc)	{
	
		this.oid=oid;
                setClas_oid_clas(clas_oid_clas);
                setInd_valo_defe(ind_valo_defe);
                setPtdt_para_tipo_desc(ptdt_para_tipo_desc);
	
	}

	@Id
	@Column(name="OID_VALO_PARA_CLAS")
	private Long oid;
	@Column(name="CLAS_OID_CLAS")
	private Long clas_oid_clas;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClas_oid_clas() {return clas_oid_clas;}
      
	public void setClas_oid_clas(Long clas_oid_clas){this.clas_oid_clas=clas_oid_clas;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
