package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_SUBTI_CLIEN")
public class ParametroSubtipoClienteLocal implements Serializable {

	public ParametroSubtipoClienteLocal() {}

	public ParametroSubtipoClienteLocal(Long oid, Long sbti_oid_subt_clie, Long ind_valo_defe, Long ptdt_para_tipo_desc)	{
	
		this.oid=oid;
                setSbti_oid_subt_clie(sbti_oid_subt_clie);
                setInd_valo_defe(ind_valo_defe);
                setPtdt_para_tipo_desc(ptdt_para_tipo_desc);	

	}

	@Id
	@Column(name="OID_VALO_PARA_SUBT_CLIE")
	private Long oid;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
