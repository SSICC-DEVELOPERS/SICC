package es.indra.sicc.entidades.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APP_RUTAS_TERRI")
public class RutasTerritoriosLocal implements Serializable {

	public RutasTerritoriosLocal() {}

	public RutasTerritoriosLocal(Long oid, Long numeroSecuencia, Long ruta, Long territorio)	{
            this.oid = oid;
	    this.numeroSecuencia = numeroSecuencia;
	    this.ruta = ruta;
	    this.territorio = territorio;
        }

	@Id
	@Column(name="OID_RUTA_TERR")
	private Long oid;
	@Column(name="NUM_SECU")
	private Long numeroSecuencia;
	@Column(name="RUTR_OID_RUTA_TRAN")
	private Long ruta;
	@Column(name="TERR_OID_TERR")
	private Long territorio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroSecuencia() {return numeroSecuencia;}
      
	public void setNumeroSecuencia(Long numeroSecuencia){this.numeroSecuencia=numeroSecuencia;}
		
	public Long getRuta() {return ruta;}
      
	public void setRuta(Long ruta){this.ruta=ruta;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
			
	
}
