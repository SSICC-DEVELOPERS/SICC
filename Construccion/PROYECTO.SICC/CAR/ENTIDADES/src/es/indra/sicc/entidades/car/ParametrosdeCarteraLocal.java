package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CAR_PARAM_CARTE")
@NamedQueries({
@NamedQuery(name="ParametrosdeCarteraLocal.FindByUK",query="SELECT OBJECT(a) "
+ "  FROM ParametrosdeCarteraLocal AS a "
+ "  WHERE a.oidPais = ?1 "
+ "  AND a.oidGrupoSolicitud = ?2 "
+ "  AND a.oidNivelRiesgo = ?3 "
+ "  AND a.codigoConfiguracion = ?4"),
@NamedQuery(name="ParametrosdeCarteraLocal.FindByPaisYCodConf",query="SELECT OBJECT(a) "
+ "  FROM ParametrosdeCarteraLocal AS a "
+ "  WHERE a.oidPais = ?1 "
+ "  AND a.codigoConfiguracion = ?2")
})
public class ParametrosdeCarteraLocal implements Serializable {

	public ParametrosdeCarteraLocal() {}

	public ParametrosdeCarteraLocal(Long oid, Long pais_oid_pais, Long grso_oid_grup_soli, Long niri_oid_nive_ries, String cod_conf, Boolean ind_deud_venc, Boolean ind_line_cred, Boolean ind_mont_maxi, Boolean ind_porc_maxi)	{
	
		this.oid=oid;
	        this.setOidPais(pais_oid_pais);
	        this.setOidGrupoSolicitud(grso_oid_grup_soli);
	        this.setOidNivelRiesgo(niri_oid_nive_ries);
	        this.setCodigoConfiguracion(cod_conf);
	        this.setIndicadorDeudaVencida(ind_deud_venc);
	        this.setIndicadorLineaCredito(ind_line_cred);
	        this.setIndicadorMontoMaximo(ind_mont_maxi);
	        this.setIndicadorPorcentajeMaximo(ind_porc_maxi);
	
	}

	@Id
	@Column(name="OID_PARA_CART")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="GRSO_OID_GRUP_SOLI")
	private Long oidGrupoSolicitud;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long oidNivelRiesgo;
	@Column(name="COD_CONF")
	private String codigoConfiguracion;
	@Column(name="IND_DEUD_VENC")
	private Boolean indicadorDeudaVencida;
	@Column(name="NUM_DIAS_DEUD_VENC")
	private Long numeroDiasDeudaVencida;
	@Column(name="IND_LINE_CRED")
	private Boolean indicadorLineaCredito;
	@Column(name="FEC_VIGE_DESD")
	private Date fechaDesde;
	@Column(name="FEC_VIGE_HAST")
	private Date fechaHasta;        
	@Column(name="VAL_PORC_VALI")
	private Float porcentajeValidacion;
	@Column(name="IND_MONT_MAXI")
	private Boolean indicadorMontoMaximo;
	@Column(name="VAL_MONT_MAXI_PERM")
	private Double montoMaximoPermitido;
	@Column(name="IND_PORC_MAXI")
	private Boolean indicadorPorcentajeMaximo;
	@Column(name="VAL_PORC")
	private Float valorPorcentaje;
	@Column(name="NUM_DIAS_ADIC")
	private Integer numeroDiasAdicionales;
	@Column(name="INVA_OID_INDI_VALI")
	private Long oidIndicadorValidacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidGrupoSolicitud() {return oidGrupoSolicitud;}
      
	public void setOidGrupoSolicitud(Long oidGrupoSolicitud){this.oidGrupoSolicitud=oidGrupoSolicitud;}
		
	public Long getOidNivelRiesgo() {return oidNivelRiesgo;}
      
	public void setOidNivelRiesgo(Long oidNivelRiesgo){this.oidNivelRiesgo=oidNivelRiesgo;}
		
	public String getCodigoConfiguracion() {return codigoConfiguracion;}
      
	public void setCodigoConfiguracion(String codigoConfiguracion){this.codigoConfiguracion=codigoConfiguracion;}
		
	public Boolean getIndicadorDeudaVencida() {return indicadorDeudaVencida;}
      
	public void setIndicadorDeudaVencida(Boolean indicadorDeudaVencida){this.indicadorDeudaVencida=indicadorDeudaVencida;}
		
	public Long getNumeroDiasDeudaVencida() {return numeroDiasDeudaVencida;}
      
	public void setNumeroDiasDeudaVencida(Long numeroDiasDeudaVencida){this.numeroDiasDeudaVencida=numeroDiasDeudaVencida;}
		
	public Boolean getIndicadorLineaCredito() {return indicadorLineaCredito;}
      
	public void setIndicadorLineaCredito(Boolean indicadorLineaCredito){this.indicadorLineaCredito=indicadorLineaCredito;}
		
	public java.sql.Date getFechaDesde() {return fechaDesde;}
      
	public void setFechaDesde(java.sql.Date fechaDesde){this.fechaDesde=fechaDesde;}
		
	public java.sql.Date getFechaHasta() {return fechaHasta;}
      
	public void setFechaHasta(java.sql.Date fechaHasta){this.fechaHasta=fechaHasta;}
		
	public Float getPorcentajeValidacion() {return porcentajeValidacion;}
      
	public void setPorcentajeValidacion(Float porcentajeValidacion){this.porcentajeValidacion=porcentajeValidacion;}
		
	public Boolean getIndicadorMontoMaximo() {return indicadorMontoMaximo;}
      
	public void setIndicadorMontoMaximo(Boolean indicadorMontoMaximo){this.indicadorMontoMaximo=indicadorMontoMaximo;}
		
	public Double getMontoMaximoPermitido() {return montoMaximoPermitido;}
      
	public void setMontoMaximoPermitido(Double montoMaximoPermitido){this.montoMaximoPermitido=montoMaximoPermitido;}
		
	public Boolean getIndicadorPorcentajeMaximo() {return indicadorPorcentajeMaximo;}
      
	public void setIndicadorPorcentajeMaximo(Boolean indicadorPorcentajeMaximo){this.indicadorPorcentajeMaximo=indicadorPorcentajeMaximo;}
		
	public Float getValorPorcentaje() {return valorPorcentaje;}
      
	public void setValorPorcentaje(Float valorPorcentaje){this.valorPorcentaje=valorPorcentaje;}
		
	public Integer getNumeroDiasAdicionales() {return numeroDiasAdicionales;}
      
	public void setNumeroDiasAdicionales(Integer numeroDiasAdicionales){this.numeroDiasAdicionales=numeroDiasAdicionales;}
		
	public Long getOidIndicadorValidacion() {return oidIndicadorValidacion;}
      
	public void setOidIndicadorValidacion(Long oidIndicadorValidacion){this.oidIndicadorValidacion=oidIndicadorValidacion;}
			
	
}
