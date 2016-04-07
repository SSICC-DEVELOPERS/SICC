package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_TIPO_CLASI")
public class ParametroTipoClasificacionLocal implements Serializable {

	public ParametroTipoClasificacionLocal() {}

	public ParametroTipoClasificacionLocal(Long oid, Long ptdt_oid_para_tipo_desc, Long tccl_oid_tipo_clas, Long ind_valor_defecto)	{
	
		this.oid=oid;
                setPtdt_oid_para_tipo_desc(ptdt_oid_para_tipo_desc);
                setTccl_oid_tipo_clas(tccl_oid_tipo_clas);
                setInd_valor_defecto(ind_valor_defecto);	

	}

	@Id
	@Column(name="OID_VALO_PARM_TIPO_CLAS")
	private Long oid;
	@Column(name="PTDT_OID_PARA_TIPO_DESC")
	private Long ptdt_oid_para_tipo_desc;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tccl_oid_tipo_clas;
	@Column(name="IND_VALOR_DEFECTO")
	private Long ind_valor_defecto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPtdt_oid_para_tipo_desc() {return ptdt_oid_para_tipo_desc;}
      
	public void setPtdt_oid_para_tipo_desc(Long ptdt_oid_para_tipo_desc){this.ptdt_oid_para_tipo_desc=ptdt_oid_para_tipo_desc;}
		
	public Long getTccl_oid_tipo_clas() {return tccl_oid_tipo_clas;}
      
	public void setTccl_oid_tipo_clas(Long tccl_oid_tipo_clas){this.tccl_oid_tipo_clas=tccl_oid_tipo_clas;}
		
	public Long getInd_valor_defecto() {return ind_valor_defecto;}
      
	public void setInd_valor_defecto(Long ind_valor_defecto){this.ind_valor_defecto=ind_valor_defecto;}
			
	
}
