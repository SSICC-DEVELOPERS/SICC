package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_HISTO_COMIS_COBRA")
@NamedQueries({
@NamedQuery(name="HistoricoComisionesCobranzaLocal.FindAll",query="select object(o) from HistoricoComisionesCobranzaLocal o")
})
public class HistoricoComisionesCobranzaLocal implements Serializable {

	public HistoricoComisionesCobranzaLocal() {}

	public HistoricoComisionesCobranzaLocal(Long oid, Long idLiquidacion, Long periodo, Long usuario, Long metodoLiquidacion, Long etapaDeuda)	{
	
		this.oid=oid;
                this.setIdLiquidacion(idLiquidacion);
	        this.setPeriodo(periodo);
	        this.setUsuario(usuario);
	        this.setMetodoLiquidacion(metodoLiquidacion);
	        this.setEtapaDeuda(etapaDeuda);
	
	}

	@Id
	@Column(name="OID_HIST_COMI_COBR")
	private Long oid;
	@Column(name="COD_LIQU")
	private Long idLiquidacion;
	@Column(name="IMP_DEUD_ASIG")
	private java.math.BigDecimal importeDeudaAsignada;
	@Column(name="IMP_DEUD_RECU")
	private java.math.BigDecimal importeDeudaRecuperada;
	@Column(name="IMP_COMI_CALC")
	private java.math.BigDecimal importeComisionCalculada;
	@Column(name="FEC_CALC_COMI")
	private java.sql.Date fechaCalculoComision;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuario;
	@Column(name="MELC_OID_METO_LIQU_COBR")
	private Long metodoLiquidacion;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapaDeuda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdLiquidacion() {return idLiquidacion;}
      
	public void setIdLiquidacion(Long idLiquidacion){this.idLiquidacion=idLiquidacion;}
		
	public java.math.BigDecimal getImporteDeudaAsignada() {return importeDeudaAsignada;}
      
	public void setImporteDeudaAsignada(java.math.BigDecimal importeDeudaAsignada){this.importeDeudaAsignada=importeDeudaAsignada;}
		
	public java.math.BigDecimal getImporteDeudaRecuperada() {return importeDeudaRecuperada;}
      
	public void setImporteDeudaRecuperada(java.math.BigDecimal importeDeudaRecuperada){this.importeDeudaRecuperada=importeDeudaRecuperada;}
		
	public java.math.BigDecimal getImporteComisionCalculada() {return importeComisionCalculada;}
      
	public void setImporteComisionCalculada(java.math.BigDecimal importeComisionCalculada){this.importeComisionCalculada=importeComisionCalculada;}
		
	public java.sql.Date getFechaCalculoComision() {return fechaCalculoComision;}
      
	public void setFechaCalculoComision(java.sql.Date fechaCalculoComision){this.fechaCalculoComision=fechaCalculoComision;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getUsuario() {return usuario;}
      
	public void setUsuario(Long usuario){this.usuario=usuario;}
		
	public Long getMetodoLiquidacion() {return metodoLiquidacion;}
      
	public void setMetodoLiquidacion(Long metodoLiquidacion){this.metodoLiquidacion=metodoLiquidacion;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
			
	
}
