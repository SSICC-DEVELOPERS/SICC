package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_CALCU")
@NamedQueries({
@NamedQuery(name="ComisionesCalculadasLocal.FindAll",query="select object(o) from ComisionesCalculadasLocal o"), 
@NamedQuery(name="ComisionesCalculadasLocal.FindByComision",query="SELECT OBJECT(o) "
+ "  FROM ComisionesCalculadasLocal o "
+ "  WHERE o.comision =?1"), 
@NamedQuery(name="ComisionesCalculadasLocal.FindByComisionCalculada",query="SELECT OBJECT(o) "
+ "  FROM ComisionesCalculadasLocal o "
+ "  WHERE o.comision =?1 "
+ "  AND o.estado = ?2")
})
public class ComisionesCalculadasLocal implements Serializable {

	public ComisionesCalculadasLocal() {}

	public ComisionesCalculadasLocal(Long oid, java.sql.Date fecCalc, Long perdOidPeri, Long clieOidClie, Long escoOidEstaComiClie, Long forpOidFormaPago, Long tplaOidTipoPlan, Long comiOidComi)	{
	
		this.oid=oid;
                this.setFechaCalculo(fecCalc);
                this.setPeriodo(perdOidPeri);
                this.setCliente(clieOidClie);
                this.setEstado(escoOidEstaComiClie);
                this.setFormaPago(forpOidFormaPago);
                this.setTipoComision(tplaOidTipoPlan);
                this.setComision(comiOidComi);
	
	}

	@Id
	@Column(name="OID_COMI_CALC")
	private Long oid;
	@Column(name="FEC_CALC")
	private java.sql.Date fechaCalculo;
	@Column(name="IMP_SCON")
	private Double importeSinCongelacion;
	@Column(name="IMP_COMI")
	private Double importe;
	@Column(name="VAL_PORC_COMI")
	private Double porcentaje;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="ESCO_OID_ESTA_COMI_CLIE")
	private Long estado;
	@Column(name="FORP_OID_FORMA_PAGO")
	private Long formaPago;
	@Column(name="TPLA_OID_TIPO_PLAN")
	private Long tipoComision;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="IMP_VENT_CALC")
	private Double importeVentaCalculada;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFechaCalculo() {return fechaCalculo;}
      
	public void setFechaCalculo(java.sql.Date fechaCalculo){this.fechaCalculo=fechaCalculo;}
		
	public Double getImporteSinCongelacion() {return importeSinCongelacion;}
      
	public void setImporteSinCongelacion(Double importeSinCongelacion){this.importeSinCongelacion=importeSinCongelacion;}
		
	public Double getImporte() {return importe;}
      
	public void setImporte(Double importe){this.importe=importe;}
		
	public Double getPorcentaje() {return porcentaje;}
      
	public void setPorcentaje(Double porcentaje){this.porcentaje=porcentaje;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getEstado() {return estado;}
      
	public void setEstado(Long estado){this.estado=estado;}
		
	public Long getFormaPago() {return formaPago;}
      
	public void setFormaPago(Long formaPago){this.formaPago=formaPago;}
		
	public Long getTipoComision() {return tipoComision;}
      
	public void setTipoComision(Long tipoComision){this.tipoComision=tipoComision;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Double getImporteVentaCalculada() {return importeVentaCalculada;}
      
	public void setImporteVentaCalculada(Double importeVentaCalculada){this.importeVentaCalculada=importeVentaCalculada;}
			
	
}
