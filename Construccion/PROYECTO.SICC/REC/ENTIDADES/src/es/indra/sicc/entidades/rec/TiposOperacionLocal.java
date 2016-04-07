package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_TIPOS_OPERA")
@NamedQueries({
@NamedQuery(name="TiposOperacionLocal.FindAll",query="select object(o) from TiposOperacionLocal o"),
@NamedQuery(name="TiposOperacionLocal.FindByOperacion",query="SELECT OBJECT(d) FROM TiposOperacionLocal d WHERE d.operacion = ?1")
})
public class TiposOperacionLocal implements Serializable {

	public TiposOperacionLocal() {}

	public TiposOperacionLocal(Long oid, String tipoOperacion, Boolean campanaReferenciaUnica, Long operacion, Long bloqueoPorValidacion)	{
	
		this.oid=oid;
                this.tipoOperacion=tipoOperacion;
                this.campanaReferenciaUnica=campanaReferenciaUnica;
                this.operacion=operacion;
                this.bloqueoPorValidacion=bloqueoPorValidacion;
	}

	@Id
	@Column(name="OID_TIPO_OPER")
	private Long oid;
	@Column(name="VAL_TIPO_OPER")
	private String tipoOperacion;
	@Column(name="IND_CAMP_REFE_UNIC")
	private Boolean campanaReferenciaUnica;
	@Column(name="NUM_DIAS_HACI_ATRA")
	private Integer cantidadDiasHaciaAtras;
	@Column(name="VAL_INFO_EBEL_NOTI")
	private Boolean informacionEbelNoticias;
	@Column(name="IND_DEVU_ESTA_FACT")
	private Boolean devuelveEstaEnFactura;
	@Column(name="IND_ENVI_ESTA_FACT")
	private Boolean enviaEstaEnFactura;
	@Column(name="ROPE_OID_OPER")
	private Long operacion;
	@Column(name="MRDB_OID_MOTI_RECH_DESB")
	private Long bloqueoPorValidacion;
	@Column(name="MOBL_OID_BLOQ_DIFE")
	private Long bloqueoPorDiferencia;
	@Column(name="MOBL_OID_RECL_ANTE")
	private Long bloqueoReclamoAnterior;
	@Column(name="MOBL_OID_BLOQ_IMPO")
	private Long bloqueoPorImporte;
	@Column(name="MOBL_OID_BLOQ_UNID")
	private Long bloqueoUnidades;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getTipoOperacion() {return tipoOperacion;}
      
	public void setTipoOperacion(String tipoOperacion){this.tipoOperacion=tipoOperacion;}
		
	public Boolean getCampanaReferenciaUnica() {return campanaReferenciaUnica;}
      
	public void setCampanaReferenciaUnica(Boolean campanaReferenciaUnica){this.campanaReferenciaUnica=campanaReferenciaUnica;}
		
	public Integer getCantidadDiasHaciaAtras() {return cantidadDiasHaciaAtras;}
      
	public void setCantidadDiasHaciaAtras(Integer cantidadDiasHaciaAtras){this.cantidadDiasHaciaAtras=cantidadDiasHaciaAtras;}
		
	public Boolean getInformacionEbelNoticias() {return informacionEbelNoticias;}
      
	public void setInformacionEbelNoticias(Boolean informacionEbelNoticias){this.informacionEbelNoticias=informacionEbelNoticias;}
		
	public Boolean getDevuelveEstaEnFactura() {return devuelveEstaEnFactura;}
      
	public void setDevuelveEstaEnFactura(Boolean devuelveEstaEnFactura){this.devuelveEstaEnFactura=devuelveEstaEnFactura;}
		
	public Boolean getEnviaEstaEnFactura() {return enviaEstaEnFactura;}
      
	public void setEnviaEstaEnFactura(Boolean enviaEstaEnFactura){this.enviaEstaEnFactura=enviaEstaEnFactura;}
		
	public Long getOperacion() {return operacion;}
      
	public void setOperacion(Long operacion){this.operacion=operacion;}
		
	public Long getBloqueoPorValidacion() {return bloqueoPorValidacion;}
      
	public void setBloqueoPorValidacion(Long bloqueoPorValidacion){this.bloqueoPorValidacion=bloqueoPorValidacion;}
		
	public Long getBloqueoPorDiferencia() {return bloqueoPorDiferencia;}
      
	public void setBloqueoPorDiferencia(Long bloqueoPorDiferencia){this.bloqueoPorDiferencia=bloqueoPorDiferencia;}
		
	public Long getBloqueoReclamoAnterior() {return bloqueoReclamoAnterior;}
      
	public void setBloqueoReclamoAnterior(Long bloqueoReclamoAnterior){this.bloqueoReclamoAnterior=bloqueoReclamoAnterior;}
		
	public Long getBloqueoPorImporte() {return bloqueoPorImporte;}
      
	public void setBloqueoPorImporte(Long bloqueoPorImporte){this.bloqueoPorImporte=bloqueoPorImporte;}
		
	public Long getBloqueoUnidades() {return bloqueoUnidades;}
      
	public void setBloqueoUnidades(Long bloqueoUnidades){this.bloqueoUnidades=bloqueoUnidades;}
			
	
}
