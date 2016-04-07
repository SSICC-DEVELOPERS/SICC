package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_CANAL")
public class ParametroCanalLocal implements Serializable {

	public ParametroCanalLocal() {}

	public ParametroCanalLocal(Long oid, Long cana_oid_cana, Long ptdt_para_tipo_desc, Long ind_valo_defe)	{
	
		this.oid=oid;
                setCana_oid_cana(cana_oid_cana);
                setPtdt_para_tipo_desc(ptdt_para_tipo_desc);
                setInd_valo_defe(ind_valo_defe);	
	}

	@Id
	@Column(name="OID_VALO_PARA_CANA")
	private Long oid;
	@Column(name="CANA_OID_CANA")
	private Long cana_oid_cana;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCana_oid_cana() {return cana_oid_cana;}
      
	public void setCana_oid_cana(Long cana_oid_cana){this.cana_oid_cana=cana_oid_cana;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
			
	
}
