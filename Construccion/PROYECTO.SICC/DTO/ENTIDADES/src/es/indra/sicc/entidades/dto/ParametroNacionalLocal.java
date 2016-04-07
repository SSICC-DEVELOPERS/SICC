package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_NACIO")
public class ParametroNacionalLocal implements Serializable {

	public ParametroNacionalLocal() {}

	public ParametroNacionalLocal(Long oid, Long ind_valo_defe, String val_para, Long ptdt_para_tipo_desc)	{
	
		this.oid=oid;
                setInd_valo_defe(ind_valo_defe);
                setVal_para(val_para);
                setPtdt_para_tipo_desc(ptdt_para_tipo_desc);
	
	}

	@Id
	@Column(name="OID_VALO_PARA_NNAL")
	private Long oid;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="VAL_PARA")
	private String val_para;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public String getVal_para() {return val_para;}
      
	public void setVal_para(String val_para){this.val_para=val_para;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
