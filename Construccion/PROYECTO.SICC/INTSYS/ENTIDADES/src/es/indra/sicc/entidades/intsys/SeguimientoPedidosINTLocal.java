package es.indra.sicc.entidades.intsys;

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
@Table(name="INT_SEGUI_PEDID")
@NamedQueries({
@NamedQuery(name="SeguimientoPedidosINTLocal.FindAll",query="select object(o) from SeguimientoPedidosINTLocal o")
})
public class SeguimientoPedidosINTLocal implements Serializable {

	public SeguimientoPedidosINTLocal() {}

	public SeguimientoPedidosINTLocal(Long oid, String numeroDespacho, String chip, String docuIdenRepartidor, Date fechaInicioLineaSacado, String horaInicioLineaSacado, Date fechaFinLineaSacado, String horaFinLineaSacado, Integer cantidadBultos, Date fechaDespacho, String horaDespacho, Long pais, Long tipoSolicitud, Long sociedad, Long clienteRepartidor, Long cliente, Long numeroSolicitud, String CodRepartidorLarissa)	{
            this.oid=oid;
	    this.numeroDespacho=numeroDespacho;
	    this.chip=chip;
	    this.docuIdenRepartidor=docuIdenRepartidor;
	    this.fechaInicioLineaSacado=fechaInicioLineaSacado;
	    this.horaInicioLineaSacado=horaInicioLineaSacado;
	    this.fechaFinLineaSacado=fechaFinLineaSacado;
	    this.horaFinLineaSacado=horaFinLineaSacado;
	    this.cantidadBultos=cantidadBultos;
	    this.fechaDespacho=fechaDespacho;
	    this.horaDespacho=horaDespacho;
	    this.pais=pais;
	    this.tipoSolicitud=tipoSolicitud;
	    this.sociedad=sociedad;
	    this.clienteRepartidor=clienteRepartidor;
	    this.cliente=cliente;
	    this.numeroSolicitud=numeroSolicitud;
	    this.codRepartidorLarissa=CodRepartidorLarissa;
	}


	@Id
	@Column(name="OID_SEGU_PEDI")
	private Long oid;
	@Column(name="NUM_DESP")
	private String numeroDespacho;
	@Column(name="VAL_CHIP")
	private String chip;
	@Column(name="VAL_DOCU_IDEN_REPA")
	private String docuIdenRepartidor;
        //@Temporal(TemporalType.DATE)	
        @Column(name="FEC_INIC_LINE_SACA")
	private Date fechaInicioLineaSacado;
	@Column(name="VAL_HORA_INIC_LINE_SACA")
	private String horaInicioLineaSacado;
        //@Temporal(TemporalType.DATE)
        @Column(name="FEC_FIN_LINE_SACA")
	private Date fechaFinLineaSacado;
	@Column(name="VAL_HORA_FIN_LINE_SACA")
	private String horaFinLineaSacado;
	@Column(name="VAL_CANT_BULT")
        private Integer cantidadBultos;
        //@Temporal(TemporalType.DATE)
	@Column(name="FEC_DESP")
	private Date fechaDespacho;
	@Column(name="VAL_HORA_DESP")
	private String horaDespacho;
        //@Temporal(TemporalType.DATE)
	@Column(name="FEC_REPA")
	private Date fechaReparto;
	@Column(name="VAL_HORA_REPA")
	private String horaReparto;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="CLIE_OID_CLIE_REPA")
	private Long clienteRepartidor;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long numeroSolicitud;
	@Column(name="COD_REPA_LARI")
	private String codRepartidorLarissa;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getNumeroDespacho() {return numeroDespacho;}
      
	public void setNumeroDespacho(String numeroDespacho){this.numeroDespacho=numeroDespacho;}
		
	public String getChip() {return chip;}
      
	public void setChip(String chip){this.chip=chip;}
		
	public String getDocuIdenRepartidor() {return docuIdenRepartidor;}
      
	public void setDocuIdenRepartidor(String docuIdenRepartidor){this.docuIdenRepartidor=docuIdenRepartidor;}
		
	public Date getFechaInicioLineaSacado() {return fechaInicioLineaSacado;}
      
	public void setFechaInicioLineaSacado(Date fechaInicioLineaSacado){this.fechaInicioLineaSacado=fechaInicioLineaSacado;}
		
	public String getHoraInicioLineaSacado() {return horaInicioLineaSacado;}
      
	public void setHoraInicioLineaSacado(String horaInicioLineaSacado){this.horaInicioLineaSacado=horaInicioLineaSacado;}
		
	public Date getFechaFinLineaSacado() {return fechaFinLineaSacado;}
      
	public void setFechaFinLineaSacado(Date fechaFinLineaSacado){this.fechaFinLineaSacado=fechaFinLineaSacado;}
		
	public String getHoraFinLineaSacado() {return horaFinLineaSacado;}
      
	public void setHoraFinLineaSacado(String horaFinLineaSacado){this.horaFinLineaSacado=horaFinLineaSacado;}
		
	public Integer getCantidadBultos() {return cantidadBultos;}
      
	public void setCantidadBultos(Integer cantidadBultos){this.cantidadBultos=cantidadBultos;}
		
	public Date getFechaDespacho() {return fechaDespacho;}
      
	public void setFechaDespacho(Date fechaDespacho){this.fechaDespacho=fechaDespacho;}
		
	public String getHoraDespacho() {return horaDespacho;}
      
	public void setHoraDespacho(String horaDespacho){this.horaDespacho=horaDespacho;}
		
	public Date getFechaReparto() {return fechaReparto;}
      
	public void setFechaReparto(Date fechaReparto){this.fechaReparto=fechaReparto;}
		
	public String getHoraReparto() {return horaReparto;}
      
	public void setHoraReparto(String horaReparto){this.horaReparto=horaReparto;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getClienteRepartidor() {return clienteRepartidor;}
      
	public void setClienteRepartidor(Long clienteRepartidor){this.clienteRepartidor=clienteRepartidor;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getNumeroSolicitud() {return numeroSolicitud;}
      
	public void setNumeroSolicitud(Long numeroSolicitud){this.numeroSolicitud=numeroSolicitud;}
		
	public String getCodRepartidorLarissa() {return codRepartidorLarissa;}
      
	public void setCodRepartidorLarissa(String codRepartidorLarissa){this.codRepartidorLarissa=codRepartidorLarissa;}
			
	
}
