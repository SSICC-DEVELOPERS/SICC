package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_RANGO_PROMO")
@NamedQueries({
@NamedQuery(name="RangosPromocionLocal.FindByOidPromo",query="SELECT OBJECT(a) "
+"FROM RangosPromocionLocal AS a WHERE a.oidProm = ?1")
})
public class RangosPromocionLocal implements Serializable {

	public RangosPromocionLocal() {}

	public RangosPromocionLocal(Long oid, Long ocat_oid_cata,
                        Long pomo_oid_prom, String cod_tipo_rang, Integer num_rang_inte, String val_desd) {
	
		this.oid=oid;
                this.oidCata=ocat_oid_cata;
                this.oidProm=pomo_oid_prom;
                this.tipoRango=cod_tipo_rang;
                this.numeroRangoInterno=num_rang_inte;
                this.valorDesde=val_desd;
                	
	}

	@Id
	@Column(name="OID_RANG_PROM")
	private Long oid;
	@Column(name="OCAT_OID_CATA")
	private Long oidCata;
	@Column(name="POMO_OID_PROM")
	private Long oidProm;
	@Column(name="COD_TIPO_RANG")
	private String tipoRango;
	@Column(name="NUM_RANG_INTE")
	private Integer numeroRangoInterno;
	@Column(name="VAL_DESD")
	private String valorDesde;
	@Column(name="VAL_HAST")
	private String valorHasta;
	@Column(name="IND_EXCL")
	private Boolean indicadorExclusion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCata() {return oidCata;}
      
	public void setOidCata(Long oidCata){this.oidCata=oidCata;}
		
	public Long getOidProm() {return oidProm;}
      
	public void setOidProm(Long oidProm){this.oidProm=oidProm;}
		
	public String getTipoRango() {return tipoRango;}
      
	public void setTipoRango(String tipoRango){this.tipoRango=tipoRango;}
		
	public Integer getNumeroRangoInterno() {return numeroRangoInterno;}
      
	public void setNumeroRangoInterno(Integer numeroRangoInterno){this.numeroRangoInterno=numeroRangoInterno;}
		
	public String getValorDesde() {return valorDesde;}
      
	public void setValorDesde(String valorDesde){this.valorDesde=valorDesde;}
		
	public String getValorHasta() {return valorHasta;}
      
	public void setValorHasta(String valorHasta){this.valorHasta=valorHasta;}
		
	public Boolean getIndicadorExclusion() {return indicadorExclusion;}
      
	public void setIndicadorExclusion(Boolean indicadorExclusion){this.indicadorExclusion=indicadorExclusion;}
			
	
}
