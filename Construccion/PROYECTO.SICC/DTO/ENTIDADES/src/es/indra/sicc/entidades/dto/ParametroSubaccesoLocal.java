package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_SUBAC")
public class ParametroSubaccesoLocal implements Serializable {

	public ParametroSubaccesoLocal() {}

	public ParametroSubaccesoLocal(Long oid, Long sbac_oid_sbac, Long ind_valo_defe, Long ptdt_para_tipo_desc)	{
	
		this.oid=oid;
                setSbac_oid_sbac(sbac_oid_sbac);
                setInd_valo_defe(ind_valo_defe);
                setPtdt_para_tipo_desc(ptdt_para_tipo_desc);	
	}

	@Id
	@Column(name="OID_VALO_PARA_SBAC")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long sbac_oid_sbac;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSbac_oid_sbac() {return sbac_oid_sbac;}
      
	public void setSbac_oid_sbac(Long sbac_oid_sbac){this.sbac_oid_sbac=sbac_oid_sbac;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
