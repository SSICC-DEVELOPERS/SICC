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
@Table(name="INC_OBTEN_PUNTO")
@NamedQueries({
@NamedQuery(name="ObtencionPuntosLocal.FindAll",query="select object(o) from ObtencionPuntosLocal o"),
@NamedQuery(name="ObtencionPuntosLocal.FindByUK",query="select object(o) from ObtencionPuntosLocal o where o.copaOidParaGral = ?1")
})
public class ObtencionPuntosLocal implements Serializable {

	public ObtencionPuntosLocal() {}

	public ObtencionPuntosLocal(Long oid, BigDecimal valFactConv, Integer numPuntAsig, Boolean indComuObte, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setFactorConversion(valFactConv);
	        this.setCopaOidParaGral(copaOidParaGral);
	        this.setNumPuntosAsignados(numPuntAsig);
	        this.setIndComuObte(indComuObte);
	
	}

	@Id
	@Column(name="OID_OBTE_PUNT")
	private Long oid;
	@Column(name="VAL_FACT_CONV")
	private java.math.BigDecimal factorConversion;
	@Column(name="NUM_PUNT_ASIG")
	private Integer numPuntosAsignados;
	@Column(name="IND_COMU_OBTE")
	private Boolean indComuObte;
	@Column(name="VAL_PUNT_ACUM")
	private Boolean puntoAcumulado;
	@Column(name="IND_ACTI")
	private Boolean indActi;
	@Column(name="IND_CONS")
	private Boolean indConsolidado;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long copaOidParaGral;
	@Column(name="MENS_OID_MENS")
	private Long mensaje;

        // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
        @Column(name="NUM_CAMP_SINP_PERM")
        private Integer numPeriodosSinPedido;
        	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getFactorConversion() {return factorConversion;}
      
	public void setFactorConversion(java.math.BigDecimal factorConversion){this.factorConversion=factorConversion;}
		
	public Integer getNumPuntosAsignados() {return numPuntosAsignados;}
      
	public void setNumPuntosAsignados(Integer numPuntosAsignados){this.numPuntosAsignados=numPuntosAsignados;}
		
	public Boolean getIndComuObte() {return indComuObte;}
      
	public void setIndComuObte(Boolean indComuObte){this.indComuObte=indComuObte;}
		
	public Boolean getPuntoAcumulado() {return puntoAcumulado;}
      
	public void setPuntoAcumulado(Boolean puntoAcumulado){this.puntoAcumulado=puntoAcumulado;}
		
	public Boolean getIndActi() {return indActi;}
      
	public void setIndActi(Boolean indActi){this.indActi=indActi;}
		
	public Boolean getIndConsolidado() {return indConsolidado;}
      
	public void setIndConsolidado(Boolean indConsolidado){this.indConsolidado=indConsolidado;}
		
	public Long getCopaOidParaGral() {return copaOidParaGral;}
      
	public void setCopaOidParaGral(Long copaOidParaGral){this.copaOidParaGral=copaOidParaGral;}
		
	public Long getMensaje() {return mensaje;}
      
	public void setMensaje(Long mensaje){this.mensaje=mensaje;}

        public void setNumPeriodosSinPedido(Integer numPeriodosSinPedido) {this.numPeriodosSinPedido = numPeriodosSinPedido;}

        public Integer getNumPeriodosSinPedido() {return numPeriodosSinPedido;}
        
}
