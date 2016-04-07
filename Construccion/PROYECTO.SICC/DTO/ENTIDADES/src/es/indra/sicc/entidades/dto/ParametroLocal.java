package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_PARAM")
public class ParametroLocal implements Serializable {

	public ParametroLocal() {}

	public ParametroLocal(Long oid, String cod_para, String val_nomb, Long ind_obli) {

		this.oid=oid;
                setCod_para(cod_para);
                setVal_nomb(val_nomb);
                setInd_obli(ind_obli);  
	
	}

	@Id
	@Column(name="OID_PARA")
	private Long oid;
	@Column(name="COD_PARA")
	private String cod_para;
	@Column(name="VAL_NOMB")
	private String val_nomb;
	@Column(name="IND_OBLI")
	private Long ind_obli;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_para() {return cod_para;}
      
	public void setCod_para(String cod_para){this.cod_para=cod_para;}
		
	public String getVal_nomb() {return val_nomb;}
      
	public void setVal_nomb(String val_nomb){this.val_nomb=val_nomb;}
		
	public Long getInd_obli() {return ind_obli;}
      
	public void setInd_obli(Long ind_obli){this.ind_obli=ind_obli;}
			
	
}
