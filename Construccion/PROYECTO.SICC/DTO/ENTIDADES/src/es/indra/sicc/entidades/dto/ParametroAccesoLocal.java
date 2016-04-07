package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_ACCES")
public class ParametroAccesoLocal implements Serializable {

	public ParametroAccesoLocal() {}

	public ParametroAccesoLocal(Long oid, Long acce_oid_acce, Long ind_valo_defe, Long ptdt_para_tipo_desc)	{
	
            this.oid=oid;
	    setAcce_oid_acce(acce_oid_acce);
	    setInd_valo_defe(ind_valo_defe);
	    setPtdt_para_tipo_desc(ptdt_para_tipo_desc);
	
	}

	@Id
	@Column(name="OID_VALO_PARA_ACCE")
	private Long oid;
	@Column(name="ACCE_OID_ACCE")
	private Long acce_oid_acce;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getAcce_oid_acce() {return acce_oid_acce;}
      
	public void setAcce_oid_acce(Long acce_oid_acce){this.acce_oid_acce=acce_oid_acce;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
