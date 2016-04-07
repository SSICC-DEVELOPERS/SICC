package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_HISTO_ASIGN_COBRA")
@NamedQueries({
@NamedQuery(name="HistoricoAsignacionCobranzaLocal.FindAll",query="select object(o) from HistoricoAsignacionCobranzaLocal o")
})
public class HistoricoAsignacionCobranzaLocal implements Serializable {

	public HistoricoAsignacionCobranzaLocal() {}

	public HistoricoAsignacionCobranzaLocal(Long oid, Long ordenHistorico, Long cliente, Long periodo, Long pais, Long sociedad, Long tipoCargo, Long unidadAdministrativaCliente, Long usuario, Long idCartera, Long etapaDeuda)	{
	
		this.oid=oid;
                this.setOrdenHistorico(ordenHistorico);
	        this.setCliente(cliente);
	        this.setPeriodo(periodo);
	        this.setPais(pais);
	        this.setSociedad(sociedad);
	        this.setTipoCargo(tipoCargo);
	        this.setUnidadAdministrativaCliente(unidadAdministrativaCliente);
	        this.setUsuario(usuario);
	        this.setIdCartera(idCartera);
	        this.setEtapaDeuda(etapaDeuda);
	
	}

	@Id
	@Column(name="OID_HIST_ASIG_COBR")
	private Long oid;
	@Column(name="VAL_ORDE_HIST")
	private Long ordenHistorico;
	@Column(name="IMP_DEUD_ASIG")
	private java.math.BigDecimal importeDeudaAsignada;
	@Column(name="IMP_DEUD_CANC")
	private java.math.BigDecimal importeDeudaCancelada;
	@Column(name="FEC_ASIG")
	private java.sql.Date fechaAsignacion;
	@Column(name="FEC_DESA")
	private java.sql.Date fechaDesasignacion;
	@Column(name="VAL_OBSE")
	private Long observaciones;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoCargo;
	@Column(name="ZTAD_OID_TERR_ADMI")
	private Long unidadAdministrativaCliente;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuario;
	@Column(name="ASCO_OID_ASIG_COBR")
	private Long idCartera;
	@Column(name="ESAS_OID_ESTA_ASIG")
	private Long estado;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapaDeuda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOrdenHistorico() {return ordenHistorico;}
      
	public void setOrdenHistorico(Long ordenHistorico){this.ordenHistorico=ordenHistorico;}
		
	public java.math.BigDecimal getImporteDeudaAsignada() {return importeDeudaAsignada;}
      
	public void setImporteDeudaAsignada(java.math.BigDecimal importeDeudaAsignada){this.importeDeudaAsignada=importeDeudaAsignada;}
		
	public java.math.BigDecimal getImporteDeudaCancelada() {return importeDeudaCancelada;}
      
	public void setImporteDeudaCancelada(java.math.BigDecimal importeDeudaCancelada){this.importeDeudaCancelada=importeDeudaCancelada;}
		
	public java.sql.Date getFechaAsignacion() {return fechaAsignacion;}
      
	public void setFechaAsignacion(java.sql.Date fechaAsignacion){this.fechaAsignacion=fechaAsignacion;}
		
	public java.sql.Date getFechaDesasignacion() {return fechaDesasignacion;}
      
	public void setFechaDesasignacion(java.sql.Date fechaDesasignacion){this.fechaDesasignacion=fechaDesasignacion;}
		
	public Long getObservaciones() {return observaciones;}
      
	public void setObservaciones(Long observaciones){this.observaciones=observaciones;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getTipoCargo() {return tipoCargo;}
      
	public void setTipoCargo(Long tipoCargo){this.tipoCargo=tipoCargo;}
		
	public Long getUnidadAdministrativaCliente() {return unidadAdministrativaCliente;}
      
	public void setUnidadAdministrativaCliente(Long unidadAdministrativaCliente){this.unidadAdministrativaCliente=unidadAdministrativaCliente;}
		
	public Long getUsuario() {return usuario;}
      
	public void setUsuario(Long usuario){this.usuario=usuario;}
		
	public Long getIdCartera() {return idCartera;}
      
	public void setIdCartera(Long idCartera){this.idCartera=idCartera;}
		
	public Long getEstado() {return estado;}
      
	public void setEstado(Long estado){this.estado=estado;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
			
	
}
