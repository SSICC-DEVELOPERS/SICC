package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INT_DESCU_PERSO_DETAL")
@NamedQueries({
@NamedQuery(name="DescuentosPersonalDetalleLocal.FindAll",query="select object(o) from DescuentosPersonalDetalleLocal o"),
@NamedQuery(name="DescuentosPersonalDetalleLocal.FindByCabecera",query="SELECT OBJECT(b) FROM DescuentosPersonalDetalleLocal b WHERE b.numeroDocumento = ?1")
})
public class DescuentosPersonalDetalleLocal implements Serializable {

	public DescuentosPersonalDetalleLocal() {}

	public DescuentosPersonalDetalleLocal(Long oid, BigDecimal impDeudaCalculado, Long cliente, Long subtipo, Long numeroDocumento)	{
            this.oid=oid;
	    this.impDeudaCalculado=impDeudaCalculado;
	    this.cliente=cliente;
	    this.subtipo=subtipo;
	    this.numeroDocumento=numeroDocumento;
	}

	@Id
	@Column(name="OID_DESC_PERS_DETA")
	private Long oid;
	@Column(name="IMP_DEUD_CALC")
	private BigDecimal impDeudaCalculado;
	@Column(name="IMP_DEUD_ENVI_ADAM")
	private BigDecimal impDeudaEnviarAdam;
	@Column(name="IMP_DEUD_DESC")
	private BigDecimal impDeudaDescontar;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="CTSU_OID_CLIE_TIPO_SUBT")
	private Long subtipo;
	@Column(name="DPEC_OID_DESC_PERS_CABE")
	private Long numeroDocumento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public BigDecimal getImpDeudaCalculado() {return impDeudaCalculado;}
      
	public void setImpDeudaCalculado(BigDecimal impDeudaCalculado){this.impDeudaCalculado=impDeudaCalculado;}
		
	public BigDecimal getImpDeudaEnviarAdam() {return impDeudaEnviarAdam;}
      
	public void setImpDeudaEnviarAdam(BigDecimal impDeudaEnviarAdam){this.impDeudaEnviarAdam=impDeudaEnviarAdam;}
		
	public BigDecimal getImpDeudaDescontar() {return impDeudaDescontar;}
      
	public void setImpDeudaDescontar(BigDecimal impDeudaDescontar){this.impDeudaDescontar=impDeudaDescontar;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getSubtipo() {return subtipo;}
      
	public void setSubtipo(Long subtipo){this.subtipo=subtipo;}
		
	public Long getNumeroDocumento() {return numeroDocumento;}
      
	public void setNumeroDocumento(Long numeroDocumento){this.numeroDocumento=numeroDocumento;}
			
	
}
