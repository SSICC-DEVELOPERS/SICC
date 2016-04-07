package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_ALCAN_DTO_ADMIN")
public class AlcanceDescuentoAdministrativoLocal implements Serializable {

	public AlcanceDescuentoAdministrativoLocal() {}

	public AlcanceDescuentoAdministrativoLocal(Long oid,Long dcto_oid_desc, Long zsgv_oid_subg_vent, Long zorg_oid_regi, 
                                                    Long zzon_oid_zona)	{
	
		this.oid=oid;
                this.dcto_oid_desc = dcto_oid_desc;
                this.zsgv_oid_subg_vent = zsgv_oid_subg_vent;
                this.zorg_oid_regi = zorg_oid_regi;
                this.zzon_oid_zona = zzon_oid_zona;
	
	}

	@Id
	@Column(name="OID_ALCA_ADMI")
	private Long oid;
	@Column(name="VAL_PORC_ADIC")
	private Double val_porc_adic;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long zsgv_oid_subg_vent;
	@Column(name="ZORG_OID_REGI")
	private Long zorg_oid_regi;
	@Column(name="ZZON_OID_ZONA")
	private Long zzon_oid_zona;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getVal_porc_adic() {return val_porc_adic;}
      
	public void setVal_porc_adic(Double val_porc_adic){this.val_porc_adic=val_porc_adic;}
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
		
	public Long getZsgv_oid_subg_vent() {return zsgv_oid_subg_vent;}
      
	public void setZsgv_oid_subg_vent(Long zsgv_oid_subg_vent){this.zsgv_oid_subg_vent=zsgv_oid_subg_vent;}
		
	public Long getZorg_oid_regi() {return zorg_oid_regi;}
      
	public void setZorg_oid_regi(Long zorg_oid_regi){this.zorg_oid_regi=zorg_oid_regi;}
		
	public Long getZzon_oid_zona() {return zzon_oid_zona;}
      
	public void setZzon_oid_zona(Long zzon_oid_zona){this.zzon_oid_zona=zzon_oid_zona;}
			
	
}
