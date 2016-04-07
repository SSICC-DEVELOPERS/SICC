package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="DTO_PARAM_TIPO_DESCU")
@NamedQueries({
@NamedQuery(name="DetalleMatrizDescuentoLocal.FindByOidMatriz",query="SELECT OBJECT(d) "
+ " FROM DetalleMatrizDescuentoLocal AS d "
+ " WHERE d.mdes_oid_tipo_desc = ?1"),
@NamedQuery(name="DetalleMatrizDescuentoLocal.FindByClaveUnica",query="SELECT OBJECT(d) "
+ " FROM DetalleMatrizDescuentoLocal AS d "
+ " WHERE d.padt_oid_para =?1 and d.mdes_oid_tipo_desc = ?2")
})

public class DetalleMatrizDescuentoLocal implements Serializable {

	public DetalleMatrizDescuentoLocal() {}

	public DetalleMatrizDescuentoLocal(Long oid, Long padt_oid_para, Long mdes_oid_tipo_desc, Long ind_visu, Long ind_obli, Long ind_modi)	{

	    this.oid=oid;
	    setPadt_oid_para(padt_oid_para);
	    setMdes_oid_tipo_desc(mdes_oid_tipo_desc);
	    setInd_visu(ind_visu);
	    setInd_obli(ind_obli);
	    setInd_modi(ind_modi);

	}

	@Id
	@Column(name="OID_PARA_TIPO_DESC")
	private Long oid;
	@Column(name="PADT_OID_PARA")
	private Long padt_oid_para;
	@Column(name="MDES_OID_TIPO_DESC")
	private Long mdes_oid_tipo_desc;
	@Column(name="NUM_MAXI_VALO")
	private Long num_maxi_valo;
	@Column(name="IND_VISU")
	private Long ind_visu;
	@Column(name="IND_OBLI")
	private Long ind_obli;
	@Column(name="IND_MODI")
	private Long ind_modi;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPadt_oid_para() {return padt_oid_para;}
      
	public void setPadt_oid_para(Long padt_oid_para){this.padt_oid_para=padt_oid_para;}
		
	public Long getMdes_oid_tipo_desc() {return mdes_oid_tipo_desc;}
      
	public void setMdes_oid_tipo_desc(Long mdes_oid_tipo_desc){this.mdes_oid_tipo_desc=mdes_oid_tipo_desc;}
		
	public Long getNum_maxi_valo() {return num_maxi_valo;}
      
	public void setNum_maxi_valo(Long num_maxi_valo){this.num_maxi_valo=num_maxi_valo;}
		
	public Long getInd_visu() {return ind_visu;}
      
	public void setInd_visu(Long ind_visu){this.ind_visu=ind_visu;}
		
	public Long getInd_obli() {return ind_obli;}
      
	public void setInd_obli(Long ind_obli){this.ind_obli=ind_obli;}
		
	public Long getInd_modi() {return ind_modi;}
      
	public void setInd_modi(Long ind_modi){this.ind_modi=ind_modi;}
			
	
}
