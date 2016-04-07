package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_HISTO_MENSA")
@NamedQueries({
@NamedQuery(name="HistoricoMensajesLocal.FindAll",query="select object(o) from HistoricoMensajesLocal o")
})
public class HistoricoMensajesLocal implements Serializable {

	public HistoricoMensajesLocal() {}

	public HistoricoMensajesLocal(Long oid, Long idLote, Long sociedad, Long periodo, Long buzonMensajes, Long etapaDeuda, Long usuarioCobranza)	{
	
		this.oid=oid;
                this.setIdLote(idLote);
	        this.setSociedad(sociedad);
	        this.setPeriodo(periodo);
	        this.setBuzonMensajes(buzonMensajes);
	        this.setEtapaDeuda(etapaDeuda);
	        this.setUsuarioCobranza(usuarioCobranza);
	        
	
	}

	@Id
	@Column(name="OID_HIST_MENS")
	private Long oid;
	@Column(name="COD_LOTE")
	private Long idLote;
	@Column(name="FEC_EMIS_MENS")
	private java.sql.Date fechaEmisionMensaje;
	@Column(name="FEC_ENTR_MENS")
	private java.sql.Date fechaEntregaMensaje;
	@Column(name="IMP_DEUD")
	private java.math.BigDecimal importe;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="BUME_OID_BUZO_MENS")
	private Long buzonMensajes;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapaDeuda;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuarioCobranza;
	@Column(name="VAL_OBSE")
	private String observacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdLote() {return idLote;}
      
	public void setIdLote(Long idLote){this.idLote=idLote;}
		
	public java.sql.Date getFechaEmisionMensaje() {return fechaEmisionMensaje;}
      
	public void setFechaEmisionMensaje(java.sql.Date fechaEmisionMensaje){this.fechaEmisionMensaje=fechaEmisionMensaje;}
		
	public java.sql.Date getFechaEntregaMensaje() {return fechaEntregaMensaje;}
      
	public void setFechaEntregaMensaje(java.sql.Date fechaEntregaMensaje){this.fechaEntregaMensaje=fechaEntregaMensaje;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getBuzonMensajes() {return buzonMensajes;}
      
	public void setBuzonMensajes(Long buzonMensajes){this.buzonMensajes=buzonMensajes;}
		
	public Long getEtapaDeuda() {return etapaDeuda;}
      
	public void setEtapaDeuda(Long etapaDeuda){this.etapaDeuda=etapaDeuda;}
		
	public Long getUsuarioCobranza() {return usuarioCobranza;}
      
	public void setUsuarioCobranza(Long usuarioCobranza){this.usuarioCobranza=usuarioCobranza;}
		
	public String getObservacion() {return observacion;}
      
	public void setObservacion(String observacion){this.observacion=observacion;}
			
	
}
