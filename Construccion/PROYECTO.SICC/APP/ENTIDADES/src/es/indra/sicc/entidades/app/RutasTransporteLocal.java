package es.indra.sicc.entidades.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APP_RUTAS_TRANS")
public class RutasTransporteLocal implements Serializable {

	public RutasTransporteLocal() {}

	public RutasTransporteLocal(Long oid, Long pais, String codigoRuta, Long numeroSecuencia)	{
            this.oid=oid;
	    this.pais = pais;
	    this.codigoRuta = codigoRuta;
	    this.numeroSecuencia = numeroSecuencia;
        }

        public RutasTransporteLocal(Long oid, Long pais, String codigoRuta, Long numeroSecuencia, String observaciones)   {
            this.oid = oid;
            this.pais = pais;
            this.codigoRuta = codigoRuta;
            this.numeroSecuencia = numeroSecuencia;
            this.observaciones = observaciones;            
        }

	@Id
	@Column(name="OID_RUTA_TRAN")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_RUTA")
	private String codigoRuta;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="NUM_SECU")
	private Long numeroSecuencia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoRuta() {return codigoRuta;}
      
	public void setCodigoRuta(String codigoRuta){this.codigoRuta=codigoRuta;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getNumeroSecuencia() {return numeroSecuencia;}
      
	public void setNumeroSecuencia(Long numeroSecuencia){this.numeroSecuencia=numeroSecuencia;}
			
	
}
