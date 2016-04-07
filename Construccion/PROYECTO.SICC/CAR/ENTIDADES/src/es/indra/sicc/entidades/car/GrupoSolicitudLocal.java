package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_GRUPO_SOLIC")
public class GrupoSolicitudLocal implements Serializable {

	public GrupoSolicitudLocal() {}

	public GrupoSolicitudLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_GRUP_SOLI")
	private Long oid;
	@Column(name="COD_GRUP_SOLI")
	private String codigoGrupoSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoGrupoSolicitud() {return codigoGrupoSolicitud;}
      
	public void setCodigoGrupoSolicitud(String codigoGrupoSolicitud){this.codigoGrupoSolicitud=codigoGrupoSolicitud;}
			
	
}
