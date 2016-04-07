package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PAGO_MONET")
@NamedQueries({
@NamedQuery(name="PagoMonetariosLocal.FindAll",query="select object(o) from PagoMonetariosLocal o"),
@NamedQuery(name="PagoMonetariosLocal.FindByPremioMonetario",query="SELECT OBJECT(a) "
+ " FROM PagoMonetariosLocal AS a "
+ " WHERE a.oidPremioMonetario = ?1")
})
public class PagoMonetariosLocal implements Serializable {

	public PagoMonetariosLocal() {}

	public PagoMonetariosLocal(Long oid, Long numPago, Double valPorcPrem, Long perdOidPeri, Long prmoOidPremMone)	{
	
		this.oid=oid;
                this.setNumeroPago(numPago);
	        this.setPorcentajePremio(valPorcPrem);
	        this.setPeriodo(perdOidPeri);
	        this.setOidPremioMonetario(prmoOidPremMone);
	
	}

	@Id
	@Column(name="OID_PAGO_MONE")
	private Long oid;
	@Column(name="NUM_PAGO")
	private Long numeroPago;
	@Column(name="VAL_PORC_PREM")
	private Double porcentajePremio;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PRMO_OID_PREM_MONE")
	private Long oidPremioMonetario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroPago() {return numeroPago;}
      
	public void setNumeroPago(Long numeroPago){this.numeroPago=numeroPago;}
		
	public Double getPorcentajePremio() {return porcentajePremio;}
      
	public void setPorcentajePremio(Double porcentajePremio){this.porcentajePremio=porcentajePremio;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getOidPremioMonetario() {return oidPremioMonetario;}
      
	public void setOidPremioMonetario(Long oidPremioMonetario){this.oidPremioMonetario=oidPremioMonetario;}
			
	
}
