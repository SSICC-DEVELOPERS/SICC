package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_SOLIC_ENVIO")
public class SolicitudEnvioMAVLocal implements Serializable {

	public SolicitudEnvioMAVLocal() {}

	public SolicitudEnvioMAVLocal(Long oid, Long oidEnvioMav, Long oidSolicitud)	{
	
		this.oid=oid;
                this.oidEnvio=oidEnvioMav;
                this.oidSolicitudCabecera=oidSolicitud;                
	
	}

	@Id
	@Column(name="OID_SOLI_ENVI")
	private Long oid;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidSolicitudCabecera;
	@Column(name="IND_GENE")
	private Boolean generada;
	@Column(name="IND_GENE_DORA")
	private Boolean generadora;
	@Column(name="MENV_OID_ENVI")
	private Long oidEnvio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidSolicitudCabecera() {return oidSolicitudCabecera;}
      
	public void setOidSolicitudCabecera(Long oidSolicitudCabecera){this.oidSolicitudCabecera=oidSolicitudCabecera;}
		
	public Boolean getGenerada() {return generada;}
      
	public void setGenerada(Boolean generada){this.generada=generada;}
		
	public Boolean getGeneradora() {return generadora;}
      
	public void setGeneradora(Boolean generadora){this.generadora=generadora;}
		
	public Long getOidEnvio() {return oidEnvio;}
      
	public void setOidEnvio(Long oidEnvio){this.oidEnvio=oidEnvio;}
			
	
}
