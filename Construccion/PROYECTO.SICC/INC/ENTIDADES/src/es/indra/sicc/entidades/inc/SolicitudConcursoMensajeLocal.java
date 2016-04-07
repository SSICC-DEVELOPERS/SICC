package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_SOLIC_CONCU_MENSA")
@NamedQueries({
@NamedQuery(name="SolicitudConcursoMensajeLocal.FindAll",query="select object(o) from SolicitudConcursoMensajeLocal o"),
@NamedQuery(name="SolicitudConcursoMensajeLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM SolicitudConcursoMensajeLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class SolicitudConcursoMensajeLocal implements Serializable {

	public SolicitudConcursoMensajeLocal() {}

	public SolicitudConcursoMensajeLocal(Long oid, Long valBuzoMens, Long socaOidSoliCabe, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setOidBuzonMensaje(valBuzoMens);
	        this.setSolicitud(socaOidSoliCabe);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_SOLI_CONC_MENS")
	private Long oid;
	@Column(name="VAL_BUZO_MENS")
	private Long oidBuzonMensaje;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long solicitud;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidBuzonMensaje() {return oidBuzonMensaje;}
      
	public void setOidBuzonMensaje(Long oidBuzonMensaje){this.oidBuzonMensaje=oidBuzonMensaje;}
		
	public Long getSolicitud() {return solicitud;}
      
	public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
	
}
