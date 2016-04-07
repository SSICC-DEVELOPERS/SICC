package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

import java.io.Serializable;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="COM_COMIS_COBRA_ACUMU_CLIEN")
@NamedQueries({
@NamedQuery(name="ComisionesCobranzasAcumuladasClienteLocal.FindAll",query="select object(o) from ComisionesCobranzasAcumuladasClienteLocal o")
})
public class ComisionesCobranzasAcumuladasClienteLocal implements Serializable {

	public ComisionesCobranzasAcumuladasClienteLocal() {}

	public ComisionesCobranzasAcumuladasClienteLocal(Long oid, Integer valNiveTram, Date fecCalc, Integer numDias, Double valPorcComi, Double valPorcObje, Long coc2OidComiCobrAcum)	{
	
		this.oid=oid;
                this.setNivelDelTramo(valNiveTram);
	        this.setFechaCalculo(fecCalc);
	        this.setDias(numDias);
	        this.setPorcentajeObjetivo(valPorcObje);
	        this.setPorcentajeComision(valPorcComi);
	        this.setOidComiCobrAcum(coc2OidComiCobrAcum);
	
	}

	@Id
	@Column(name="OID_COMI_COBR_ACUM")
	private Long oid;
	@Column(name="VAL_NIVE_TRAM")
	private Integer nivelDelTramo;
	@Column(name="FEC_CALC")
        @Temporal(TemporalType.TIMESTAMP)
        private java.util.Date fechaCalculo;
	@Column(name="NUM_DIAS")
	private Integer dias;
	@Column(name="VAL_PORC_RECU")
	private Double porcentajeRecuperado;
	@Column(name="VAL_PORC_OBJE")
	private Double porcentajeObjetivo;
	@Column(name="VAL_PORC_COMI")
	private Double porcentajeComision;
	@Column(name="IMP_MONT_PAGA")
	private java.math.BigDecimal montoPagar;
	@Column(name="IMP_MONT_RECU")
	private java.math.BigDecimal montoRecuperado;
	@Column(name="IND_CALC")
	private Boolean calculado;
	@Column(name="COC2_OID_COMI_COBR_ACUM")
	private Long oidComiCobrAcum;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNivelDelTramo() {return nivelDelTramo;}
      
	public void setNivelDelTramo(Integer nivelDelTramo){this.nivelDelTramo=nivelDelTramo;}
		
	public java.util.Date getFechaCalculo() {return fechaCalculo;}
      
	public void setFechaCalculo(java.util.Date fechaCalculo){this.fechaCalculo=fechaCalculo;}
		
	public Integer getDias() {return dias;}
      
	public void setDias(Integer dias){this.dias=dias;}
		
	public Double getPorcentajeRecuperado() {return porcentajeRecuperado;}
      
	public void setPorcentajeRecuperado(Double porcentajeRecuperado){this.porcentajeRecuperado=porcentajeRecuperado;}
		
	public Double getPorcentajeObjetivo() {return porcentajeObjetivo;}
      
	public void setPorcentajeObjetivo(Double porcentajeObjetivo){this.porcentajeObjetivo=porcentajeObjetivo;}
		
	public Double getPorcentajeComision() {return porcentajeComision;}
      
	public void setPorcentajeComision(Double porcentajeComision){this.porcentajeComision=porcentajeComision;}
		
	public java.math.BigDecimal getMontoPagar() {return montoPagar;}
      
	public void setMontoPagar(java.math.BigDecimal montoPagar){this.montoPagar=montoPagar;}
		
	public java.math.BigDecimal getMontoRecuperado() {return montoRecuperado;}
      
	public void setMontoRecuperado(java.math.BigDecimal montoRecuperado){this.montoRecuperado=montoRecuperado;}
		
	public Boolean getCalculado() {return calculado;}
      
	public void setCalculado(Boolean calculado){this.calculado=calculado;}
		
	public Long getOidComiCobrAcum() {return oidComiCobrAcum;}
      
	public void setOidComiCobrAcum(Long oidComiCobrAcum){this.oidComiCobrAcum=oidComiCobrAcum;}
			
	
}
