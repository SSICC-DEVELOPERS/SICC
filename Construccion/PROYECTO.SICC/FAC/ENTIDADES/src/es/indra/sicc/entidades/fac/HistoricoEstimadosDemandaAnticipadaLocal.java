package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_HISTO_ESTIM_DEMAN_ANTIC")
public class HistoricoEstimadosDemandaAnticipadaLocal implements Serializable {

	public HistoricoEstimadosDemandaAnticipadaLocal() {}

	public HistoricoEstimadosDemandaAnticipadaLocal(Long oid, Long pais, Long periodo, Long producto, Integer unidEstimadasMarketing, BigDecimal pupMarketing, BigDecimal pupReal, BigDecimal pupDemanda, Character estadoDemanda, BigDecimal a1, BigDecimal b1, BigDecimal c1, BigDecimal s)	{
            this.oid=oid;
	    this.pais = pais;                  
	    this.periodo = periodo;               
	    this.producto = producto;         
	    this.unidEstimadasMarketing = unidEstimadasMarketing;
	    this.pupMarketing = pupMarketing; 
	    this.pupReal = pupReal;
	    this.pupDemanda = pupDemanda;        
	    this.estadoDemanda = estadoDemanda; 
	    this.a1 = a1;
	    this.b1 = b1;                 
	    this.c1 = c1;                 
	    this.s = s;                 
	
	}

	@Id
	@Column(name="OID_HIST")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="NUM_UNID_ESTI_MARK")
	private Integer unidEstimadasMarketing;
	@Column(name="VAL_PUP_MARK")
	private java.math.BigDecimal pupMarketing;
	@Column(name="VAL_PUP_REAL")
	private java.math.BigDecimal pupReal;
	@Column(name="VAL_PUP_DEMA")
	private java.math.BigDecimal pupDemanda;
	@Column(name="VAL_ESTA_DEMA")
	private Character estadoDemanda;
	@Column(name="VAL_A1")
	private java.math.BigDecimal a1;
	@Column(name="VAL_B1")
	private java.math.BigDecimal b1;
	@Column(name="VAL_C1")
	private java.math.BigDecimal c1;
	@Column(name="VAL_S")
	private java.math.BigDecimal s;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Integer getUnidEstimadasMarketing() {return unidEstimadasMarketing;}
      
	public void setUnidEstimadasMarketing(Integer unidEstimadasMarketing){this.unidEstimadasMarketing=unidEstimadasMarketing;}
		
	public java.math.BigDecimal getPupMarketing() {return pupMarketing;}
      
	public void setPupMarketing(java.math.BigDecimal pupMarketing){this.pupMarketing=pupMarketing;}
		
	public java.math.BigDecimal getPupReal() {return pupReal;}
      
	public void setPupReal(java.math.BigDecimal pupReal){this.pupReal=pupReal;}
		
	public java.math.BigDecimal getPupDemanda() {return pupDemanda;}
      
	public void setPupDemanda(java.math.BigDecimal pupDemanda){this.pupDemanda=pupDemanda;}
		
	public Character getEstadoDemanda() {return estadoDemanda;}
      
	public void setEstadoDemanda(Character estadoDemanda){this.estadoDemanda=estadoDemanda;}
		
	public java.math.BigDecimal getA1() {return a1;}
      
	public void setA1(java.math.BigDecimal a1){this.a1=a1;}
		
	public java.math.BigDecimal getB1() {return b1;}
      
	public void setB1(java.math.BigDecimal b1){this.b1=b1;}
		
	public java.math.BigDecimal getC1() {return c1;}
      
	public void setC1(java.math.BigDecimal c1){this.c1=c1;}
		
	public java.math.BigDecimal getS() {return s;}
      
	public void setS(java.math.BigDecimal s){this.s=s;}
			
	
}
