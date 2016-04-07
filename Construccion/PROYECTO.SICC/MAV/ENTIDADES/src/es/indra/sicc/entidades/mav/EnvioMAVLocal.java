package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MAV_ENVIO")
@NamedQueries({
@NamedQuery(name="EnvioMAVLocal.FindByClienteDetalle",query="SELECT OBJECT(a)  FROM EnvioMAVLocal AS a WHERE a.oidCliente = ?1 and a.oidDetalleMAV = ?2"),
@NamedQuery(name="EnvioMAVLocal.FindByClienteDetalleMatriz",query="SELECT OBJECT(a) FROM EnvioMAVLocal AS a WHERE a.oidCliente =?1 AND a.oidDetalleMAV = ?2 AND a.oidMatrizFacturacion = ?3")
})
public class EnvioMAVLocal implements Serializable {

	public EnvioMAVLocal() {}

	public EnvioMAVLocal(Long oid, Long numeroUnidades, Double precioEstandar, Double precio, Double precioContable, 
                                    Long oidDetalleMAV, Long oidMatrizFacturacion, Long oidCliente, Long oidActividad, 
                                    Long oidEstadoEnvio, Long oidFormaCobro, Long oidTipoDespacho, Character indicadorEnvio, 
                                    Timestamp fechaEntrega, Long oidPagoFraccionado, Long oidBuzonMensajes)	{
	
		this.oid=oid;
                this.numeroUnidades=numeroUnidades;
                this.precioEstandar=precioEstandar;
                this.precio=precio;
                this.precioContable=precioContable;
                this.oidDetalleMAV=oidDetalleMAV;
                this.oidMatrizFacturacion=oidMatrizFacturacion;
                this.oidCliente=oidCliente;
                this.oidActividad=oidActividad;
                this.oidEstadoEnvio=oidEstadoEnvio;
                this.oidFormaCobro=oidFormaCobro;
                this.oidTipoDespacho=oidTipoDespacho;
                this.indicadorEnvio=indicadorEnvio;
                this.fechaEntrega=fechaEntrega;
                this.oidPagoFraccionado=oidPagoFraccionado;
                this.oidBuzonMensajes=oidBuzonMensajes;                
	
	}
        
        public EnvioMAVLocal(Long oid,Long numeroUnidades, Double precioEstandar, Double precio, Double precioContable,
                                    Long oidDetalleMAV, Long oidMatrizFacturacion, Long oidCliente, Long oidActividad, 
                                    Long oidEstadoEnvio, Long oidFormaCobro, Long oidTipoDespacho, Character indicadorEnvio)     {
        
                this.oid=oid;
                this.numeroUnidades=numeroUnidades;
                this.precioEstandar=precioEstandar;
                this.precio=precio;
                this.precioContable=precioContable;
                this.oidDetalleMAV=oidDetalleMAV;
                this.oidMatrizFacturacion=oidMatrizFacturacion;
                this.oidCliente=oidCliente;
                this.oidActividad=oidActividad;
                this.oidEstadoEnvio=oidEstadoEnvio;
                this.oidFormaCobro=oidFormaCobro;
                this.oidTipoDespacho=oidTipoDespacho;
                this.indicadorEnvio=indicadorEnvio;      
        
        }        

	@Id
	@Column(name="OID_ENVI")
	private Long oid;
	@Column(name="FEC_ENTR")
        @Temporal(TemporalType.DATE)
	private java.util.Date fechaEntrega;
	@Column(name="NUM_UNID")
	private Long numeroUnidades;
	@Column(name="VAL_PREC_STND")
	private Double precioEstandar;
	@Column(name="VAL_PREC")
	private Double precio;
	@Column(name="VAL_PREC_CONT")
	private Double precioContable;
	@Column(name="DENV_OID_DETA_MAV")
	private Long oidDetalleMAV;
	@Column(name="MAFA_OID_MATR_FACT")
	private Long oidMatrizFacturacion;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="ESEN_OID_ESTA_ENVI")
	private Long oidEstadoEnvio;
	@Column(name="FCOB_OID_FORM_COBR")
	private Long oidFormaCobro;
	@Column(name="NUM_MENS")
	private Long oidBuzonMensajes;
	@Column(name="ATDE_OID_ACTI_TIPO_DESP")
	private Long oidTipoDespacho;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidPagoFraccionado;
	@Column(name="IND_ENVI")
	private Character indicadorEnvio;
	@Column(name="NUM_SECU")
	private Long numeroSecuencia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.util.Date getFechaEntrega() {return fechaEntrega;}
      
	public void setFechaEntrega(java.util.Date fechaEntrega){this.fechaEntrega=fechaEntrega;}
		
	public Long getNumeroUnidades() {return numeroUnidades;}
      
	public void setNumeroUnidades(Long numeroUnidades){this.numeroUnidades=numeroUnidades;}
		
	public Double getPrecioEstandar() {return precioEstandar;}
      
	public void setPrecioEstandar(Double precioEstandar){this.precioEstandar=precioEstandar;}
		
	public Double getPrecio() {return precio;}
      
	public void setPrecio(Double precio){this.precio=precio;}
		
	public Double getPrecioContable() {return precioContable;}
      
	public void setPrecioContable(Double precioContable){this.precioContable=precioContable;}
		
	public Long getOidDetalleMAV() {return oidDetalleMAV;}
      
	public void setOidDetalleMAV(Long oidDetalleMAV){this.oidDetalleMAV=oidDetalleMAV;}
		
	public Long getOidMatrizFacturacion() {return oidMatrizFacturacion;}
      
	public void setOidMatrizFacturacion(Long oidMatrizFacturacion){this.oidMatrizFacturacion=oidMatrizFacturacion;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidEstadoEnvio() {return oidEstadoEnvio;}
      
	public void setOidEstadoEnvio(Long oidEstadoEnvio){this.oidEstadoEnvio=oidEstadoEnvio;}
		
	public Long getOidFormaCobro() {return oidFormaCobro;}
      
	public void setOidFormaCobro(Long oidFormaCobro){this.oidFormaCobro=oidFormaCobro;}
		
	public Long getOidBuzonMensajes() {return oidBuzonMensajes;}
      
	public void setOidBuzonMensajes(Long oidBuzonMensajes){this.oidBuzonMensajes=oidBuzonMensajes;}
		
	public Long getOidTipoDespacho() {return oidTipoDespacho;}
      
	public void setOidTipoDespacho(Long oidTipoDespacho){this.oidTipoDespacho=oidTipoDespacho;}
		
	public Long getOidPagoFraccionado() {return oidPagoFraccionado;}
      
	public void setOidPagoFraccionado(Long oidPagoFraccionado){this.oidPagoFraccionado=oidPagoFraccionado;}
		
	public Character getIndicadorEnvio() {return indicadorEnvio;}
      
	public void setIndicadorEnvio(Character indicadorEnvio){this.indicadorEnvio=indicadorEnvio;}
		
	public Long getNumeroSecuencia() {return numeroSecuencia;}
      
	public void setNumeroSecuencia(Long numeroSecuencia){this.numeroSecuencia=numeroSecuencia;}
			
	
}
