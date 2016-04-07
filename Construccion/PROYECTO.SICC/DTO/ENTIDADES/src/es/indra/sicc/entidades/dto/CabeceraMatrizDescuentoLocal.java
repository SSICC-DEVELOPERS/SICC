package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_MATRI_DESCU")
public class CabeceraMatrizDescuentoLocal implements Serializable {

	public CabeceraMatrizDescuentoLocal() {}

	public CabeceraMatrizDescuentoLocal(Long oid, Long ind_matr_acti, Long pais_oid_pais)	{
	
		this.oid=oid;
                this.ind_matr_acti = ind_matr_acti;
                this.pais_oid_pais = pais_oid_pais;
	
	}

	@Id
	@Column(name="OID_TIPO_DESC")
	private Long oid;
	@Column(name="VAL_OBSE")
	private String val_obse;
	@Column(name="IND_MATR_ACTI")
	private Long ind_matr_acti;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getVal_obse() {return val_obse;}
      
	public void setVal_obse(String val_obse){this.val_obse=val_obse;}
		
	public Long getInd_matr_acti() {return ind_matr_acti;}
      
	public void setInd_matr_acti(Long ind_matr_acti){this.ind_matr_acti=ind_matr_acti;}
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
			
	
}
