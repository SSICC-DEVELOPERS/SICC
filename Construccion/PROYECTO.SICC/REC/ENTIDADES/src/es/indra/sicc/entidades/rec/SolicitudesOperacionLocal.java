package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_SOLIC_OPERA")
@NamedQueries({
@NamedQuery(name="SolicitudesOperacionLocal.FindAll",query="select object(o) from SolicitudesOperacionLocal o")
})
public class SolicitudesOperacionLocal implements Serializable {

	public SolicitudesOperacionLocal() {}

	public SolicitudesOperacionLocal(Long oid, Long operacion, Long numeroSolicitud, Long tipoSolicitud){
	
		this.oid=oid;
                this.operacion=operacion;
                this.numeroSolicitud=numeroSolicitud;
                this.tipoSolicitud=tipoSolicitud;
	
	}

	@Id
	@Column(name="OID_SOLI_OPER")
	private Long oid;
	@Column(name="IND_ATEN")
	private Long atendido;
	@Column(name="OPRE_OID_OPER_RECL")
	private Long operacion;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long numeroSolicitud;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getAtendido() {return atendido;}
      
	public void setAtendido(Long atendido){this.atendido=atendido;}
		
	public Long getOperacion() {return operacion;}
      
	public void setOperacion(Long operacion){this.operacion=operacion;}
		
	public Long getNumeroSolicitud() {return numeroSolicitud;}
      
	public void setNumeroSolicitud(Long numeroSolicitud){this.numeroSolicitud=numeroSolicitud;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
			
	
}
