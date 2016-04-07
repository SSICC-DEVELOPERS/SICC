package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_ESCLN")
public class EscalonLocal implements Serializable {

	public EscalonLocal() {}

	public EscalonLocal(Long oid, BigDecimal val_desd, Double val_porc_desc, Long baca_oid_cabe)	{
	
		this.oid=oid;
                this.val_desd = val_desd;
                this.val_porc_desc = val_porc_desc;
                this.baca_oid_cabe = baca_oid_cabe;
	
	}

	@Id
	@Column(name="OID_ESLN")
	private Long oid;
	@Column(name="VAL_DESD")
	private java.math.BigDecimal val_desd;
	@Column(name="VAL_HAST")
	private java.math.BigDecimal val_hast;
	@Column(name="VAL_PORC_DESC")
	private Double val_porc_desc;
	@Column(name="BACA_OID_CABE")
	private Long baca_oid_cabe;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getVal_desd() {return val_desd;}
      
	public void setVal_desd(java.math.BigDecimal val_desd){this.val_desd=val_desd;}
		
	public java.math.BigDecimal getVal_hast() {return val_hast;}
      
	public void setVal_hast(java.math.BigDecimal val_hast){this.val_hast=val_hast;}
		
	public Double getVal_porc_desc() {return val_porc_desc;}
      
	public void setVal_porc_desc(Double val_porc_desc){this.val_porc_desc=val_porc_desc;}
		
	public Long getBaca_oid_cabe() {return baca_oid_cabe;}
      
	public void setBaca_oid_cabe(Long baca_oid_cabe){this.baca_oid_cabe=baca_oid_cabe;}
			
	
}
