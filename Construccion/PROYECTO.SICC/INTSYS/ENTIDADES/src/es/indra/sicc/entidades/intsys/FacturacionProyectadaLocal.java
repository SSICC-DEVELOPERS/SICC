package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INT_FACTU_PROYE")
@NamedQueries({
@NamedQuery(name="FacturacionProyectadaLocal.FindAll",query="select object(o) from FacturacionProyectadaLocal o"),
@NamedQuery(name="FacturacionProyectadaLocal.FindByUK",query="SELECT OBJECT(a)  FROM FacturacionProyectadaLocal AS a " +
            "WHERE a.prodOidProd = ?1 " +
            "AND a.perdOidPeri = ?2 " +
            "AND a.tofeOidTipoOfer = ?3 " +
            "AND a.civiOidCiclVida = ?4")
})
public class FacturacionProyectadaLocal implements Serializable {

	public FacturacionProyectadaLocal() {}

	public FacturacionProyectadaLocal(Long oid, Long civiOidCiclVida, Long tofeOidTipoOfer, Long prodOidProd, Long perdOidPeri, Long prfiOidProgFide, Long cndpOidCondProm, Long ocatOidCata, Long variOidVari, Long moneOidMone, Long argvOidArguVent)	{
            this.oid=oid;
	    this.civiOidCiclVida=civiOidCiclVida;
	    this.tofeOidTipoOfer=tofeOidTipoOfer;
	    this.prodOidProd=prodOidProd;
	    this.perdOidPeri=perdOidPeri;
	    this.prfiOidProgFide=prfiOidProgFide;
	    this.cndpOidCondProm=cndpOidCondProm;
	    this.ocatOidCata=ocatOidCata;
	    this.variOidVari=variOidVari;
	    this.moneOidMone=moneOidMone;
	    this.argvOidArguVent=argvOidArguVent;
	}

	@Id
	@Column(name="OID_FACT_PROY")
	private Long oid;
	@Column(name="NUM_UNID_PROY")
	private Integer numUnidProy;
	@Column(name="NUM_PAGI_CATA")
	private Integer numPagiCata;
	@Column(name="IMP_PREC_CATA")
	private BigDecimal impPrecCata;
	@Column(name="IMP_VENT_NETA_ESTI")
	private BigDecimal impVentNetaEsti;
	@Column(name="IMP_PREC_POSI")
	private BigDecimal impPrecPosi;
	@Column(name="VAL_POSI_PAGI")
	private Integer valPosiPagi;
	@Column(name="VAL_CENT")
	private String valCent;
	@Column(name="IND_OFER_GENE")
	private Long indOferGene;
	@Column(name="VAL_COST_ESTA")
	private BigDecimal valCostEsta;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long civiOidCiclVida;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tofeOidTipoOfer;
	@Column(name="PROD_OID_PROD")
	private Long prodOidProd;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;
	@Column(name="PRFI_OID_PROG_FIDE")
	private Long prfiOidProgFide;
	@Column(name="SBAC_OID_SBAC")
	private Long sbacOidSbac;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long fopaOidFormPago;
	@Column(name="CNDP_OID_COND_PROM")
	private Long cndpOidCondProm;
	@Column(name="COES_OID_ESTR")
	private Long coesOidEstr;
	@Column(name="OCAT_OID_CATA")
	private Long ocatOidCata;
	@Column(name="VARI_OID_VARI")
	private Long variOidVari;
	@Column(name="MONE_OID_MONE")
	private Long moneOidMone;
	@Column(name="ARGV_OID_ARGU_VENT")
	private Long argvOidArguVent;
	@Column(name="ACCE_OID_ACCE")
	private Long acceOidAcce;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumUnidProy() {return numUnidProy;}
      
	public void setNumUnidProy(Integer numUnidProy){this.numUnidProy=numUnidProy;}
		
	public Integer getNumPagiCata() {return numPagiCata;}
      
	public void setNumPagiCata(Integer numPagiCata){this.numPagiCata=numPagiCata;}
		
	public BigDecimal getImpPrecCata() {return impPrecCata;}
      
	public void setImpPrecCata(BigDecimal impPrecCata){this.impPrecCata=impPrecCata;}
		
	public BigDecimal getImpVentNetaEsti() {return impVentNetaEsti;}
      
	public void setImpVentNetaEsti(BigDecimal impVentNetaEsti){this.impVentNetaEsti=impVentNetaEsti;}
		
	public BigDecimal getImpPrecPosi() {return impPrecPosi;}
      
	public void setImpPrecPosi(BigDecimal impPrecPosi){this.impPrecPosi=impPrecPosi;}
		
	public Integer getValPosiPagi() {return valPosiPagi;}
      
	public void setValPosiPagi(Integer valPosiPagi){this.valPosiPagi=valPosiPagi;}
		
	public String getValCent() {return valCent;}
      
	public void setValCent(String valCent){this.valCent=valCent;}
		
	public Long getIndOferGene() {return indOferGene;}
      
	public void setIndOferGene(Long indOferGene){this.indOferGene=indOferGene;}
		
	public BigDecimal getValCostEsta() {return valCostEsta;}
      
	public void setValCostEsta(BigDecimal valCostEsta){this.valCostEsta=valCostEsta;}
		
	public Long getCiviOidCiclVida() {return civiOidCiclVida;}
      
	public void setCiviOidCiclVida(Long civiOidCiclVida){this.civiOidCiclVida=civiOidCiclVida;}
		
	public Long getTofeOidTipoOfer() {return tofeOidTipoOfer;}
      
	public void setTofeOidTipoOfer(Long tofeOidTipoOfer){this.tofeOidTipoOfer=tofeOidTipoOfer;}
		
	public Long getProdOidProd() {return prodOidProd;}
      
	public void setProdOidProd(Long prodOidProd){this.prodOidProd=prodOidProd;}
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
		
	public Long getPrfiOidProgFide() {return prfiOidProgFide;}
      
	public void setPrfiOidProgFide(Long prfiOidProgFide){this.prfiOidProgFide=prfiOidProgFide;}
		
	public Long getSbacOidSbac() {return sbacOidSbac;}
      
	public void setSbacOidSbac(Long sbacOidSbac){this.sbacOidSbac=sbacOidSbac;}
		
	public Long getFopaOidFormPago() {return fopaOidFormPago;}
      
	public void setFopaOidFormPago(Long fopaOidFormPago){this.fopaOidFormPago=fopaOidFormPago;}
		
	public Long getCndpOidCondProm() {return cndpOidCondProm;}
      
	public void setCndpOidCondProm(Long cndpOidCondProm){this.cndpOidCondProm=cndpOidCondProm;}
		
	public Long getCoesOidEstr() {return coesOidEstr;}
      
	public void setCoesOidEstr(Long coesOidEstr){this.coesOidEstr=coesOidEstr;}
		
	public Long getOcatOidCata() {return ocatOidCata;}
      
	public void setOcatOidCata(Long ocatOidCata){this.ocatOidCata=ocatOidCata;}
		
	public Long getVariOidVari() {return variOidVari;}
      
	public void setVariOidVari(Long variOidVari){this.variOidVari=variOidVari;}
		
	public Long getMoneOidMone() {return moneOidMone;}
      
	public void setMoneOidMone(Long moneOidMone){this.moneOidMone=moneOidMone;}
		
	public Long getArgvOidArguVent() {return argvOidArguVent;}
      
	public void setArgvOidArguVent(Long argvOidArguVent){this.argvOidArguVent=argvOidArguVent;}
		
	public Long getAcceOidAcce() {return acceOidAcce;}
      
	public void setAcceOidAcce(Long acceOidAcce){this.acceOidAcce=acceOidAcce;}
			
	
}
