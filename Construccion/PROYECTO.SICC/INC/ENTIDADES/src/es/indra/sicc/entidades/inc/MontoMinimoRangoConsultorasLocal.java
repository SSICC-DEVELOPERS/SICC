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
@Table(name="INC_MONTO_MINIM_RANGO_CONSU")
@NamedQueries({
@NamedQuery(name="MontoMinimoRangoConsultorasLocal.FindAll",query="select object(o) from MontoMinimoRangoConsultorasLocal o"),
@NamedQuery(name="MontoMinimoRangoConsultorasLocal.FindByParticipanteCalificacion",query="SELECT OBJECT(a) "
+ " FROM MontoMinimoRangoConsultorasLocal AS a "
+ " WHERE a.participanteCalificacion = ?1")
})
public class MontoMinimoRangoConsultorasLocal implements Serializable {

	public MontoMinimoRangoConsultorasLocal() {}

	public MontoMinimoRangoConsultorasLocal(Long oid, BigDecimal impMontMini, Long esveOidEstaVent, Long clpcOidClasPartCali)	{
	
		this.oid=oid;
                this.setMontoMinimo(impMontMini);
	        this.setEstatusVenta(esveOidEstaVent);
	        this.setParticipanteCalificacion(clpcOidClasPartCali);
	
	}

	@Id
	@Column(name="OID_MONT_MINI_RANG_CONS")
	private Long oid;
	@Column(name="IMP_MONT_MINI")
	private java.math.BigDecimal montoMinimo;
	@Column(name="ESTV_OID_ESTA_VENT")
	private Long estatusVenta;
	@Column(name="CLPC_OID_CLAS_PART_CALI")
	private Long participanteCalificacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoMinimo() {return montoMinimo;}
      
	public void setMontoMinimo(java.math.BigDecimal montoMinimo){this.montoMinimo=montoMinimo;}
		
	public Long getEstatusVenta() {return estatusVenta;}
      
	public void setEstatusVenta(Long estatusVenta){this.estatusVenta=estatusVenta;}
		
	public Long getParticipanteCalificacion() {return participanteCalificacion;}
      
	public void setParticipanteCalificacion(Long participanteCalificacion){this.participanteCalificacion=participanteCalificacion;}
			
	
}
