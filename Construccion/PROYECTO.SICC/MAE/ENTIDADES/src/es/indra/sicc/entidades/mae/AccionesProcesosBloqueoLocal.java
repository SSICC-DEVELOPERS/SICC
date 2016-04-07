package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_ACCIO_PROCE_BLOQU")
@NamedQueries({
@NamedQuery(name="AccionesProcesosBloqueoLocal.FindAll",query="select object(o) from AccionesProcesosBloqueoLocal o")
})
public class AccionesProcesosBloqueoLocal implements Serializable {

	public AccionesProcesosBloqueoLocal() {}

	public AccionesProcesosBloqueoLocal(Long oid, Long oidTipoBloqueo, Long oidProcesoBloqueo, Long oidAccionBloqueo, Long oidPais)	{
		this.oid=oid;
                this.oidTipoBloqueo = oidTipoBloqueo;
                this.oidProcesoBloqueo = oidProcesoBloqueo;
                this.oidAccionBloqueo = oidAccionBloqueo;
                this.oidPais = oidPais;
	}

	@Id
	@Column(name="OID_ACCI_PROC_BLOQ")
	private Long oid;
	@Column(name="MAPB_OID_PROC_BLOQ")
	private Long oidProcesoBloqueo;
	@Column(name="TIBQ_OID_TIPO_BLOQ")
	private Long oidTipoBloqueo;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MABL_OID_ACCI_BLOQ")
	private Long oidAccionBloqueo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidProcesoBloqueo() {return oidProcesoBloqueo;}
      
	public void setOidProcesoBloqueo(Long oidProcesoBloqueo){this.oidProcesoBloqueo=oidProcesoBloqueo;}
		
	public Long getOidTipoBloqueo() {return oidTipoBloqueo;}
      
	public void setOidTipoBloqueo(Long oidTipoBloqueo){this.oidTipoBloqueo=oidTipoBloqueo;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidAccionBloqueo() {return oidAccionBloqueo;}
      
	public void setOidAccionBloqueo(Long oidAccionBloqueo){this.oidAccionBloqueo=oidAccionBloqueo;}
			
	
}
