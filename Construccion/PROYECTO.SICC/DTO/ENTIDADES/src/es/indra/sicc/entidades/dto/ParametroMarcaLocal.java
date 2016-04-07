package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_VALOR_PARAM_MARCA")
public class ParametroMarcaLocal implements Serializable {

	public ParametroMarcaLocal() {}

	public ParametroMarcaLocal(Long oid, Long marc_oid_marc, Long ind_valo_defe, Long ptdt_para_tipo_desc)	{
	
            this.oid=oid;
	    setMarc_oid_marc(marc_oid_marc);
	    setInd_valo_defe(ind_valo_defe);
	    setPtdt_para_tipo_desc(ptdt_para_tipo_desc);
	
	}

	@Id
	@Column(name="OID_VALO_PARA_MARC")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long marc_oid_marc;
	@Column(name="IND_VALO_DEFE")
	private Long ind_valo_defe;
	@Column(name="PTDT_PARA_TIPO_DESC")
	private Long ptdt_para_tipo_desc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarc_oid_marc() {return marc_oid_marc;}
      
	public void setMarc_oid_marc(Long marc_oid_marc){this.marc_oid_marc=marc_oid_marc;}
		
	public Long getInd_valo_defe() {return ind_valo_defe;}
      
	public void setInd_valo_defe(Long ind_valo_defe){this.ind_valo_defe=ind_valo_defe;}
		
	public Long getPtdt_para_tipo_desc() {return ptdt_para_tipo_desc;}
      
	public void setPtdt_para_tipo_desc(Long ptdt_para_tipo_desc){this.ptdt_para_tipo_desc=ptdt_para_tipo_desc;}
			
	
}
