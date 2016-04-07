package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INC_GANAD")
@NamedQueries({
@NamedQuery(name="GanadorasLocal.FindAll",query="select object(o) from GanadorasLocal o"),
@NamedQuery(name="GanadorasLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM GanadorasLocal AS a "
+ " WHERE a.oidCliente = ?1 "
+ " AND a.periodoDespacho = ?2 "
+ " AND a.nivelPremiacion = ?3")
})
public class GanadorasLocal implements Serializable {

	public GanadorasLocal() {}

	public GanadorasLocal(Long oid, BigDecimal unidades, Boolean listarGanador, Boolean descontar, Boolean despachado, Long oidCliente, Long periodoDespacho, Long nivelPremiacion)	{
	
		this.oid=oid;
                this.setUnidades(unidades);
	        this.setListarGanador(listarGanador);
	        this.setDescontar(descontar);
	        this.setDespachado(despachado);
	        this.setOidCliente(oidCliente);
	        this.setPeriodoDespacho(periodoDespacho);
	        this.setNivelPremiacion(nivelPremiacion);
	
	}

	@Id
	@Column(name="OID_GANA")
	private Long oid;
	@Column(name="FEC_OBTE")
	private java.sql.Date fechaObtencion;
	@Column(name="NUM_UNID")
	private java.math.BigDecimal unidades;
	@Column(name="IND_LIST_GANA")
	private Boolean listarGanador;
	@Column(name="IND_DESC")
	private Boolean descontar;
	@Column(name="IND_DESP")
	private Boolean despachado;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="PERD_OID_PERI")
	private Long periodoDespacho;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long cabeceraSolicitud;
	@Column(name="IND_CLIE_BLOQ")
	private Boolean clienteBloqueado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFechaObtencion() {return fechaObtencion;}
      
	public void setFechaObtencion(java.sql.Date fechaObtencion){this.fechaObtencion=fechaObtencion;}
		
	public java.math.BigDecimal getUnidades() {return unidades;}
      
	public void setUnidades(java.math.BigDecimal unidades){this.unidades=unidades;}
		
	public Boolean getListarGanador() {return listarGanador;}
      
	public void setListarGanador(Boolean listarGanador){this.listarGanador=listarGanador;}
		
	public Boolean getDescontar() {return descontar;}
      
	public void setDescontar(Boolean descontar){this.descontar=descontar;}
		
	public Boolean getDespachado() {return despachado;}
      
	public void setDespachado(Boolean despachado){this.despachado=despachado;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getPeriodoDespacho() {return periodoDespacho;}
      
	public void setPeriodoDespacho(Long periodoDespacho){this.periodoDespacho=periodoDespacho;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	public Long getCabeceraSolicitud() {return cabeceraSolicitud;}
      
	public void setCabeceraSolicitud(Long cabeceraSolicitud){this.cabeceraSolicitud=cabeceraSolicitud;}
		
	public Boolean getClienteBloqueado() {return clienteBloqueado;}
      
	public void setClienteBloqueado(Boolean clienteBloqueado){this.clienteBloqueado=clienteBloqueado;}
			
	
}
