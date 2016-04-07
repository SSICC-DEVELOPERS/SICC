package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="REC_OPERA_RECLA_DIGIT")
@NamedQueries({
@NamedQuery(name="OperacionReclamoDigitadoLocal.FindAll",query="select object(o) from OperacionReclamoDigitadoLocal o"),
@NamedQuery(name="OperacionReclamoDigitadoLocal.FindByReclamo",query="SELECT OBJECT(d) FROM OperacionReclamoDigitadoLocal d WHERE d.cabeceraReclamo = ?1")
})
public class OperacionReclamoDigitadoLocal implements Serializable {

	public OperacionReclamoDigitadoLocal() {}

	public OperacionReclamoDigitadoLocal(Long oid, Integer numeroOperacion, Long cabeceraReclamo, Long estadoOperacion)	{
	
		this.oid=oid;
                this.numeroOperacion=numeroOperacion;
                this.cabeceraReclamo=cabeceraReclamo;
                this.estadoOperacion=estadoOperacion;
	}

	@Id
	@Column(name="OID_OPER_RECL_DIGI")
	private Long oid;
	@Column(name="NUM_OPER_RECL_DIGI")
	private Integer numeroOperacion;
	@Column(name="VAL_RESP_PERD")
	private String responsablePerdida;
	@Column(name="COD_ARTI")
	private String codigoArticulo;
	@Column(name="VAL_CLIE_SEGU")
	private String clienteSeguro;
	@Column(name="IMP_MONT_ARTI")
	private BigDecimal montoArticulo;
	@Column(name="RCDG_OID_CABE_RECL_DIGI")
	private Long cabeceraReclamo;
	@Column(name="ESOP_OID_ESTA_OPER")
	private Long estadoOperacion;
	@Column(name="ASPE_OID_ASUM_PERD")
	private Long asumePerdida;
	@Column(name="TIOP_OID_TIPO_OPER")
	private Long tipoOperacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroOperacion() {return numeroOperacion;}
      
	public void setNumeroOperacion(Integer numeroOperacion){this.numeroOperacion=numeroOperacion;}
		
	public String getResponsablePerdida() {return responsablePerdida;}
      
	public void setResponsablePerdida(String responsablePerdida){this.responsablePerdida=responsablePerdida;}
		
	public String getCodigoArticulo() {return codigoArticulo;}
      
	public void setCodigoArticulo(String codigoArticulo){this.codigoArticulo=codigoArticulo;}
		
	public String getClienteSeguro() {return clienteSeguro;}
      
	public void setClienteSeguro(String clienteSeguro){this.clienteSeguro=clienteSeguro;}
		
	public BigDecimal getMontoArticulo() {return montoArticulo;}
      
	public void setMontoArticulo(BigDecimal montoArticulo){this.montoArticulo=montoArticulo;}
		
	public Long getCabeceraReclamo() {return cabeceraReclamo;}
      
	public void setCabeceraReclamo(Long cabeceraReclamo){this.cabeceraReclamo=cabeceraReclamo;}
		
	public Long getEstadoOperacion() {return estadoOperacion;}
      
	public void setEstadoOperacion(Long estadoOperacion){this.estadoOperacion=estadoOperacion;}
		
	public Long getAsumePerdida() {return asumePerdida;}
      
	public void setAsumePerdida(Long asumePerdida){this.asumePerdida=asumePerdida;}
		
	public Long getTipoOperacion() {return tipoOperacion;}
      
	public void setTipoOperacion(Long tipoOperacion){this.tipoOperacion=tipoOperacion;}
			
	
}
