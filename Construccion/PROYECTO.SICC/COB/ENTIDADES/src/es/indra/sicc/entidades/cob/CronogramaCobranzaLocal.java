package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

import java.io.Serializable;

@Entity
@Table(name="COB_CRONO_COBRA")
@NamedQueries({
@NamedQuery(name="CronogramaCobranzaLocal.FindAll",query="select object(o) from CronogramaCobranzaLocal o")
})
public class CronogramaCobranzaLocal implements Serializable {

	public CronogramaCobranzaLocal() {}

	public CronogramaCobranzaLocal(Long oid, Long idCartera, Date fechaCierre, Long pais, Long periodo, Long subgerenciaVentas, Long tipoCargo, Long etapaDeuda, Long usuarioCobranzas)	{
	
		this.oid=oid;
                this.setIdCartera(idCartera);
	        this.setFechaCierre(fechaCierre);
	        this.setPais(pais);
	        this.setPeriodo(periodo);
	        this.setSubgerenciaVentas(subgerenciaVentas);	        
	        this.setTipoCargo(tipoCargo);
	        this.setEtapaDeuda(etapaDeuda);
	        this.setUsuarioCobranzas(usuarioCobranzas);
	
	}

	@Id
	@Column(name="OID_CRON_COBR")
	private Long oid;
	@Column(name="COD_CART")
	private Long idCartera;
	@Column(name="FEC_CIER")
	private java.sql.Date fechaCierre;
	@Column(name="FEC_EVAL")
	private java.sql.Date fechaEvaluacion;
	@Column(name="FEC_AUDI")
	private java.sql.Date fechaAuditoria;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="FEC_ASIG")
	private java.sql.Date fechaAsignacion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="TERR_OID_TERR")
	private Long territorio;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoCargo;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapaDeuda;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuarioCobranzas;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerenciaVentas;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdCartera() {return idCartera;}
      
	public void setIdCartera(Long idCartera){this.idCartera=idCartera;}
		
	public java.sql.Date getFechaCierre() {return fechaCierre;}
      
	public void setFechaCierre(java.sql.Date fechaCierre){this.fechaCierre=fechaCierre;}
		
	public java.sql.Date getFechaEvaluacion() {return fechaEvaluacion;}
      
	public void setFechaEvaluacion(java.sql.Date fechaEvaluacion){this.fechaEvaluacion=fechaEvaluacion;}
		
	public java.sql.Date getFechaAuditoria() {return fechaAuditoria;}
      
	public void setFechaAuditoria(java.sql.Date fechaAuditoria){this.fechaAuditoria=fechaAuditoria;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public java.sql.Date getFechaAsignacion() {return fechaAsignacion;}
      
	public void setFechaAsignacion(java.sql.Date fechaAsignacion){this.fechaAsignacion=fechaAsignacion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
		
	public Long getTipoCargo() {return tipoCargo;}
      
	public void setTipoCargo(Long tipoCargo){this.tipoCargo=tipoCargo;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
		
	public Long getUsuarioCobranzas() {return usuarioCobranzas;}
      
	public void setUsuarioCobranzas(Long usuarioCobranzas){this.usuarioCobranzas=usuarioCobranzas;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getSubgerenciaVentas() {return subgerenciaVentas;}
      
	public void setSubgerenciaVentas(Long subgerenciaVentas){this.subgerenciaVentas=subgerenciaVentas;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
			
	
}
