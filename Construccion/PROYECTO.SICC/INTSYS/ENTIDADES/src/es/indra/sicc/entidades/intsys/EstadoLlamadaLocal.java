package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_ESTAD_LLAMA")
@NamedQueries({
@NamedQuery(name="EstadoLlamadaLocal.FindAll",query="select object(o) from EstadoLlamadaLocal o"),
@NamedQuery(name="EstadoLlamadaLocal.FindByUK",query="SELECT OBJECT(o) FROM EstadoLlamadaLocal AS o WHERE o.identificador = ?1")
})
public class EstadoLlamadaLocal implements Serializable {

	public EstadoLlamadaLocal() {}

	public EstadoLlamadaLocal(Long oid, Long usuarioCobranzas, Long tipoCargo, Long subTipoCliente, Long etapasDeuda, Long cliente, Long periodo)	{
            this.oid=oid;
            this.identificador=oid;
	    this.usuarioCobranzas=usuarioCobranzas;
	    this.tipoCargo=tipoCargo;
	    this.subTipoCliente=subTipoCliente;
	    this.etapasDeuda=etapasDeuda;
	    this.cliente=cliente;
	    this.periodo=periodo;
	}

	@Id
	@Column(name="OID_ESTA_LLAM")
	private Long oid;
	@Column(name="COD_LLAM")
	private Long identificador;
	@Column(name="VAL_ESTA")
	private String estado;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuarioCobranzas;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoCargo;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subTipoCliente;
	@Column(name="ETDE_OID_ETAP_DEUD")
	private Long etapasDeuda;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ELLA_OID_EXIT_LLAM")
	private Long exitoLlamada;
	@Column(name="PRIO_OID_PRIO")
	private Long prioridad;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdentificador() {return identificador;}
      
	public void setIdentificador(Long identificador){this.identificador=identificador;}
		
	public String getEstado() {return estado;}
      
	public void setEstado(String estado){this.estado=estado;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getUsuarioCobranzas() {return usuarioCobranzas;}
      
	public void setUsuarioCobranzas(Long usuarioCobranzas){this.usuarioCobranzas=usuarioCobranzas;}
		
	public Long getTipoCargo() {return tipoCargo;}
      
	public void setTipoCargo(Long tipoCargo){this.tipoCargo=tipoCargo;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getSubTipoCliente() {return subTipoCliente;}
      
	public void setSubTipoCliente(Long subTipoCliente){this.subTipoCliente=subTipoCliente;}
		
	public Long getEtapasDeuda() {return etapasDeuda;}
      
	public void setEtapasDeuda(Long etapasDeuda){this.etapasDeuda=etapasDeuda;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getExitoLlamada() {return exitoLlamada;}
      
	public void setExitoLlamada(Long exitoLlamada){this.exitoLlamada=exitoLlamada;}
		
	public Long getPrioridad() {return prioridad;}
      
	public void setPrioridad(Long prioridad){this.prioridad=prioridad;}
			
	
}
