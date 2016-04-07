package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="INC_DESCA")
@NamedQueries({
@NamedQuery(name="DescalificacionesLocal.FindAll",query="select object(o) from DescalificacionesLocal o"),
@NamedQuery(name="DescalificacionesLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM DescalificacionesLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class DescalificacionesLocal implements Serializable {

	public DescalificacionesLocal() {}

	public DescalificacionesLocal(Long oid, Date fecDesc, Long clieOidClie, Long copaOidParaGral, Long perdOidPeri, Long cadeOidCausDesc)	{
	
		this.oid=oid;
                this.setFechaDescalificacion(fecDesc);
	        this.setCliente(clieOidClie);
	        this.setConcurso(copaOidParaGral);
	        this.setPeriodoDescalificacion(perdOidPeri);
	        this.setCausa(cadeOidCausDesc);
	
	}

	@Id
	@Column(name="OID_DESC")
	private Long oid;
	@Column(name="FEC_DESC")
	private java.sql.Date fechaDescalificacion;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoDescalificacion;
	@Column(name="CADE_OID_CAUS_DESC")
	private Long causa;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFechaDescalificacion() {return fechaDescalificacion;}
      
	public void setFechaDescalificacion(java.sql.Date fechaDescalificacion){this.fechaDescalificacion=fechaDescalificacion;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getPeriodoDescalificacion() {return periodoDescalificacion;}
      
	public void setPeriodoDescalificacion(Long periodoDescalificacion){this.periodoDescalificacion=periodoDescalificacion;}
		
	public Long getCausa() {return causa;}
      
	public void setCausa(Long causa){this.causa=causa;}
			
	
}
