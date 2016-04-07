package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_BPS_INTER")
@NamedQueries({
@NamedQuery(name="BPSInterfaceMAVLocal.FindByUK",query="select Object(b) from BPSInterfaceMAVLocal b "+
" where b.oidPeriodo = ?1 "+
" and b.oidProducto = ?2 "+
" and b.oidCicloVida = ?3 "+
" and b.oidTipoCliente = ?4 "+
" and b.oidTipoOferta = ?5")
})
public class BPSInterfaceMAVLocal implements Serializable {

	public BPSInterfaceMAVLocal() {}

	public BPSInterfaceMAVLocal(Long oid, Double precioStandar, Long oidTipoOferta, Long oidProducto, Long oidTipoCliente, Long oidPeriodo, Long oidCicloVida)	{
	
		this.oid=oid;
                this.precioStandar=precioStandar;
                this.oidTipoOferta=oidTipoOferta;
                this.oidProducto=oidProducto;
                this.oidTipoCliente=oidTipoCliente;
                this.oidPeriodo=oidPeriodo;
                this.oidCicloVida=oidCicloVida;                
	
	}

	@Id
	@Column(name="OID_BPS_INTE_MAV")
	private Long oid;
	@Column(name="VAL_CRIT")
	private String criterio;
	@Column(name="VAL_BASE_DEST")
	private Long baseDestinatarios;
	@Column(name="VAL_FACT_CORR")
	private Double factorCorreccion;
	@Column(name="VAL_PROM")
	private Double promedio;
	@Column(name="NUM_UNID")
	private Long unidades;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="VAL_PREC_STND")
	private Double precioStandar;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long oidTipoOferta;
	@Column(name="PROD_OID_PROD")
	private Long oidProducto;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long oidTipoCliente;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSubacceso;
	@Column(name="IND_CARG")
	private Boolean cargado;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long oidCicloVida;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCriterio() {return criterio;}
      
	public void setCriterio(String criterio){this.criterio=criterio;}
		
	public Long getBaseDestinatarios() {return baseDestinatarios;}
      
	public void setBaseDestinatarios(Long baseDestinatarios){this.baseDestinatarios=baseDestinatarios;}
		
	public Double getFactorCorreccion() {return factorCorreccion;}
      
	public void setFactorCorreccion(Double factorCorreccion){this.factorCorreccion=factorCorreccion;}
		
	public Double getPromedio() {return promedio;}
      
	public void setPromedio(Double promedio){this.promedio=promedio;}
		
	public Long getUnidades() {return unidades;}
      
	public void setUnidades(Long unidades){this.unidades=unidades;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Double getPrecioStandar() {return precioStandar;}
      
	public void setPrecioStandar(Double precioStandar){this.precioStandar=precioStandar;}
		
	public Long getOidTipoOferta() {return oidTipoOferta;}
      
	public void setOidTipoOferta(Long oidTipoOferta){this.oidTipoOferta=oidTipoOferta;}
		
	public Long getOidProducto() {return oidProducto;}
      
	public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
		
	public Long getOidTipoCliente() {return oidTipoCliente;}
      
	public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOidSubacceso() {return oidSubacceso;}
      
	public void setOidSubacceso(Long oidSubacceso){this.oidSubacceso=oidSubacceso;}
		
	public Boolean getCargado() {return cargado;}
      
	public void setCargado(Boolean cargado){this.cargado=cargado;}
		
	public Long getOidCicloVida() {return oidCicloVida;}
      
	public void setOidCicloVida(Long oidCicloVida){this.oidCicloVida=oidCicloVida;}
			
	
}
