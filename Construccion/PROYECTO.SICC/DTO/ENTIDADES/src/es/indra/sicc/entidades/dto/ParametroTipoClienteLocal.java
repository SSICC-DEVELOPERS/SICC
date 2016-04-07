package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_TIPO_CLIEN")
public class ParametroTipoClienteLocal implements Serializable {

	public ParametroTipoClienteLocal() {}

	public ParametroTipoClienteLocal(Long oid, Long ptdt_oid_para_tipo_desc, Long ticl_oid_tipo_clie, Long ind_valo_defe)	{
	
		this.oid=oid;
                setPtdt_oid_para_tipo_desc(ptdt_oid_para_tipo_desc);
                setTicl_oid_tipo_clie(ticl_oid_tipo_clie);
                setInd_valo_defe(ind_valo_defe);	
	}

	@Id
	@Column(name="OID_VALO_PARA_TIPO_CLIE")
	private Long oid;
	@Column(name="PTDT_OID_PARA_TIPO_DESC")
	private Long ptdt_oid_para_tipo_desc;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long ticl_oid_tipo_clie;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPtdt_oid_para_tipo_desc() {return ptdt_oid_para_tipo_desc;}
      
	public void setPtdt_oid_para_tipo_desc(Long ptdt_oid_para_tipo_desc){this.ptdt_oid_para_tipo_desc=ptdt_oid_para_tipo_desc;}
		
	public Long getTicl_oid_tipo_clie() {return ticl_oid_tipo_clie;}
      
	public void setTicl_oid_tipo_clie(Long ticl_oid_tipo_clie){this.ticl_oid_tipo_clie=ticl_oid_tipo_clie;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
			
	
}
