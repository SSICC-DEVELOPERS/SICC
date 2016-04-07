package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_CODIG_FABPS")
@NamedQueries({
@NamedQuery(name="CodigoFaltanteBPSLocal.FindAll",query="select object(o) from CodigoFaltanteBPSLocal o")
})
public class CodigoFaltanteBPSLocal implements Serializable {

	public CodigoFaltanteBPSLocal() {}

	public CodigoFaltanteBPSLocal(Long oid, String codigoFaltante, Long tipoPosicion, Long tipoSolicitudPais) {
            this.oid = oid;
	    this.codigoFaltante = codigoFaltante;
	    this.tipoPosicion = tipoPosicion;
	    this.tipoSolicitudPais = tipoSolicitudPais;
	}

	@Id
	@Column(name="OID_CODI_FBPS")
	private Long oid;
	@Column(name="COD_FALT")
	private String codigoFaltante;
	@Column(name="TSOL_OID_TIPO_SOLI")
	private Long tipoPosicion;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitudPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoFaltante() {return codigoFaltante;}
      
	public void setCodigoFaltante(String codigoFaltante){this.codigoFaltante=codigoFaltante;}
		
	public Long getTipoPosicion() {return tipoPosicion;}
      
	public void setTipoPosicion(Long tipoPosicion){this.tipoPosicion=tipoPosicion;}
		
	public Long getTipoSolicitudPais() {return tipoSolicitudPais;}
      
	public void setTipoSolicitudPais(Long tipoSolicitudPais){this.tipoSolicitudPais=tipoSolicitudPais;}
			
	
}
