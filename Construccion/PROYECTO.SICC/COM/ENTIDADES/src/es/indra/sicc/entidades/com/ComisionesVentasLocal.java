package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_VENTA")
@NamedQueries({
@NamedQuery(name="ComisionesVentasLocal.FindAll",query="select object(o) from ComisionesVentasLocal o"),
@NamedQuery(name="ComisionesVentasLocal.FindByUK",query="select object(c) from ComisionesVentasLocal c where c.comision = ?1")
})
public class ComisionesVentasLocal implements Serializable {

	public ComisionesVentasLocal() {}

	public ComisionesVentasLocal(Long oid, Long comision, Long formula)	{
	
		this.oid=oid;
                this.setComision(comision);
	        this.setFormula(formula);
	
	}

	@Id
	@Column(name="OID_COMI_VENT")
	private Long oid;
	@Column(name="IND_CALC_INCO")
	private Boolean calculoIncobrables;
	@Column(name="VAL_CALC_INCO_FECH_EMIS")
	private Boolean calculoIncobrablesFechaEmision;
	@Column(name="VAL_CALC_INCO_FECH_VENC")
	private Boolean calculoIncobrablesFechaVencimiento;
	@Column(name="NUM_DIAS_INCO")
	private Integer diasIncobrables;
	@Column(name="IND_DEVO")
	private Boolean devoluciones;
	@Column(name="VAL_ANUL")
	private Boolean anulaciones;
	@Column(name="IND_FALT_NANU")
	private Boolean faltantesNoAnunciados;
	@Column(name="VAL_PORC_COMI")
	private java.math.BigDecimal porcentajeComision;
	@Column(name="IMP_FIJO_COMI")
	private java.math.BigDecimal importeFijoComision;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="FORM_OID_FORM")
	private Long formula;
	@Column(name="TCVI_OID_TIPO_COMI_VENT_INCR")
	private Long tipoComisionVtaIncremental;
	@Column(name="TICV_OID_TIPO_COMI_VENT")
	private Long tipoComisionVta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getCalculoIncobrables() {return calculoIncobrables;}
      
	public void setCalculoIncobrables(Boolean calculoIncobrables){this.calculoIncobrables=calculoIncobrables;}
		
	public Boolean getCalculoIncobrablesFechaEmision() {return calculoIncobrablesFechaEmision;}
      
	public void setCalculoIncobrablesFechaEmision(Boolean calculoIncobrablesFechaEmision){this.calculoIncobrablesFechaEmision=calculoIncobrablesFechaEmision;}
		
	public Boolean getCalculoIncobrablesFechaVencimiento() {return calculoIncobrablesFechaVencimiento;}
      
	public void setCalculoIncobrablesFechaVencimiento(Boolean calculoIncobrablesFechaVencimiento){this.calculoIncobrablesFechaVencimiento=calculoIncobrablesFechaVencimiento;}
		
	public Integer getDiasIncobrables() {return diasIncobrables;}
      
	public void setDiasIncobrables(Integer diasIncobrables){this.diasIncobrables=diasIncobrables;}
		
	public Boolean getDevoluciones() {return devoluciones;}
      
	public void setDevoluciones(Boolean devoluciones){this.devoluciones=devoluciones;}
		
	public Boolean getAnulaciones() {return anulaciones;}
      
	public void setAnulaciones(Boolean anulaciones){this.anulaciones=anulaciones;}
		
	public Boolean getFaltantesNoAnunciados() {return faltantesNoAnunciados;}
      
	public void setFaltantesNoAnunciados(Boolean faltantesNoAnunciados){this.faltantesNoAnunciados=faltantesNoAnunciados;}
		
	public java.math.BigDecimal getPorcentajeComision() {return porcentajeComision;}
      
	public void setPorcentajeComision(java.math.BigDecimal porcentajeComision){this.porcentajeComision=porcentajeComision;}
		
	public java.math.BigDecimal getImporteFijoComision() {return importeFijoComision;}
      
	public void setImporteFijoComision(java.math.BigDecimal importeFijoComision){this.importeFijoComision=importeFijoComision;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getFormula() {return formula;}
      
	public void setFormula(Long formula){this.formula=formula;}
		
	public Long getTipoComisionVtaIncremental() {return tipoComisionVtaIncremental;}
      
	public void setTipoComisionVtaIncremental(Long tipoComisionVtaIncremental){this.tipoComisionVtaIncremental=tipoComisionVtaIncremental;}
		
	public Long getTipoComisionVta() {return tipoComisionVta;}
      
	public void setTipoComisionVta(Long tipoComisionVta){this.tipoComisionVta=tipoComisionVta;}
			
	
}
