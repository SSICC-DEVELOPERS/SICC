package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="DTO_ALCAN_DTO_CLIEN")
@NamedQueries({
@NamedQuery(name="AlcanceDescuentoClienteLocal.FindByOidDescuento",query="SELECT OBJECT(o) "
+ " FROM AlcanceDescuentoClienteLocal AS o "
+ " WHERE o.dcto_oid_desc = ?1 ")
})

public class AlcanceDescuentoClienteLocal implements Serializable {

	public AlcanceDescuentoClienteLocal() {}

	public AlcanceDescuentoClienteLocal(Long oid, Long dcto_oid_desc, Long clie_oid_clie)	{
	
		this.oid=oid;
                this.dcto_oid_desc = dcto_oid_desc;
                this.clie_oid_clie = clie_oid_clie;
	
	}

	@Id
	@Column(name="OID_ALCA_DTO_CLIE")
	private Long oid;
	@Column(name="DCTO_OID_DESC")
	private Long dcto_oid_desc;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="VAL_PORC_DESC")
	private Double val_porc_desc;
	@Column(name="IMP_FIJO")
	private Double imp_fijo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getDcto_oid_desc() {return dcto_oid_desc;}
      
	public void setDcto_oid_desc(Long dcto_oid_desc){this.dcto_oid_desc=dcto_oid_desc;}
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Double getVal_porc_desc() {return val_porc_desc;}
      
	public void setVal_porc_desc(Double val_porc_desc){this.val_porc_desc=val_porc_desc;}
		
	public Double getImp_fijo() {return imp_fijo;}
      
	public void setImp_fijo(Double imp_fijo){this.imp_fijo=imp_fijo;}
			
	
}
