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
@Table(name="INC_MONTO_MINIM_RANGO_GEREN")
@NamedQueries({
@NamedQuery(name="MontoMinimoRangoGerentesLocal.FindAll",query="select object(o) from MontoMinimoRangoGerentesLocal o"),
@NamedQuery(name="MontoMinimoRangoGerentesLocal.FindByParticipanteCalificacion",query="SELECT OBJECT(a) "
+ " FROM MontoMinimoRangoGerentesLocal AS a "
+ " WHERE a.participanteCalificacion = ?1")
})
public class MontoMinimoRangoGerentesLocal implements Serializable {

	public MontoMinimoRangoGerentesLocal() {}

	public MontoMinimoRangoGerentesLocal(Long oid, BigDecimal impMontoMinim, Long clpcOidClasPartCali)	{
	
		this.oid=oid;
                this.setMontoMinimo(impMontoMinim);
	        this.setParticipanteCalificacion(clpcOidClasPartCali);
	
	}

	@Id
	@Column(name="OID_MONT_MINI_RANG_GERE")
	private Long oid;
	@Column(name="IMP_MONTO_MINIM")
	private java.math.BigDecimal montoMinimo;
	@Column(name="CLPC_OID_CLAS_PART_CALI")
	private Long participanteCalificacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoMinimo() {return montoMinimo;}
      
	public void setMontoMinimo(java.math.BigDecimal montoMinimo){this.montoMinimo=montoMinimo;}
		
	public Long getParticipanteCalificacion() {return participanteCalificacion;}
      
	public void setParticipanteCalificacion(Long participanteCalificacion){this.participanteCalificacion=participanteCalificacion;}
			
	
}
