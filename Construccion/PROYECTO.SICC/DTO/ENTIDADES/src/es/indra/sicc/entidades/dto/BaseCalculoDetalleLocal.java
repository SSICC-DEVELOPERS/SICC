package es.indra.sicc.entidades.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTO_BASE_CALCU_DETAL")
public class BaseCalculoDetalleLocal implements Serializable {

	public BaseCalculoDetalleLocal() {}

	public BaseCalculoDetalleLocal(Long oid, Long cicloVida, Long oidCabecera, Long oidSuperGenerico, Long oidProducto, 
                                        Long oidGenerico, Long oidMarcaProducto, Long oidUnidadNegocio, Long oidNegocio, 
                                        Long oidTipoOferta)	{
	
		this.oid=oid;
                this.civi_oid_cicl_vida = cicloVida;
                this.bcca_oid_cabe = oidCabecera;
                this.sgen_oid_supe_gene = oidSuperGenerico;
                this.prod_oid_prod = oidProducto;
                this.gene_oid_gene = oidGenerico;
                this.mapr_oid_marc_prod = oidMarcaProducto;
                this.uneg_oid_unid_nego = oidUnidadNegocio;
                this.nego_oid_nego = oidNegocio;
                this.tofe_oid_tipo_ofer = oidTipoOferta;
	
	}

	@Id
	@Column(name="OID_DETA")
	private Long oid;
	@Column(name="IND_EXCL_TIPO_OFER")
	private Long ind_excl_tipo_ofer;
	@Column(name="PROD_OID_PROD")
	private Long prod_oid_prod;
	@Column(name="BCCA_OID_CABE")
	private Long bcca_oid_cabe;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tofe_oid_tipo_ofer;
	@Column(name="SGEN_OID_SUPE_GENE")
	private Long sgen_oid_supe_gene;
	@Column(name="NEGO_OID_NEGO")
	private Long nego_oid_nego;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long civi_oid_cicl_vida;
	@Column(name="GENE_OID_GENE")
	private Long gene_oid_gene;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long mapr_oid_marc_prod;
	@Column(name="UNEG_OID_UNID_NEGO")
	private Long uneg_oid_unid_nego;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getInd_excl_tipo_ofer() {return ind_excl_tipo_ofer;}
      
	public void setInd_excl_tipo_ofer(Long ind_excl_tipo_ofer){this.ind_excl_tipo_ofer=ind_excl_tipo_ofer;}
		
	public Long getProd_oid_prod() {return prod_oid_prod;}
      
	public void setProd_oid_prod(Long prod_oid_prod){this.prod_oid_prod=prod_oid_prod;}
		
	public Long getBcca_oid_cabe() {return bcca_oid_cabe;}
      
	public void setBcca_oid_cabe(Long bcca_oid_cabe){this.bcca_oid_cabe=bcca_oid_cabe;}
		
	public Long getTofe_oid_tipo_ofer() {return tofe_oid_tipo_ofer;}
      
	public void setTofe_oid_tipo_ofer(Long tofe_oid_tipo_ofer){this.tofe_oid_tipo_ofer=tofe_oid_tipo_ofer;}
		
	public Long getSgen_oid_supe_gene() {return sgen_oid_supe_gene;}
      
	public void setSgen_oid_supe_gene(Long sgen_oid_supe_gene){this.sgen_oid_supe_gene=sgen_oid_supe_gene;}
		
	public Long getNego_oid_nego() {return nego_oid_nego;}
      
	public void setNego_oid_nego(Long nego_oid_nego){this.nego_oid_nego=nego_oid_nego;}
		
	public Long getCivi_oid_cicl_vida() {return civi_oid_cicl_vida;}
      
	public void setCivi_oid_cicl_vida(Long civi_oid_cicl_vida){this.civi_oid_cicl_vida=civi_oid_cicl_vida;}
		
	public Long getGene_oid_gene() {return gene_oid_gene;}
      
	public void setGene_oid_gene(Long gene_oid_gene){this.gene_oid_gene=gene_oid_gene;}
		
	public Long getMapr_oid_marc_prod() {return mapr_oid_marc_prod;}
      
	public void setMapr_oid_marc_prod(Long mapr_oid_marc_prod){this.mapr_oid_marc_prod=mapr_oid_marc_prod;}
		
	public Long getUneg_oid_unid_nego() {return uneg_oid_unid_nego;}
      
	public void setUneg_oid_unid_nego(Long uneg_oid_unid_nego){this.uneg_oid_unid_nego=uneg_oid_unid_nego;}
			
	
}
