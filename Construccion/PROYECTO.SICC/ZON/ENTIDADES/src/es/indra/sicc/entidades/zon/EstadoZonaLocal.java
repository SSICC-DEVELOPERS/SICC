package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ZON_ESTAD_ZONA")
@NamedQueries({
@NamedQuery(name="EstadoZonaLocal.FindByUK",query="SELECT OBJECT(a) FROM EstadoZonaLocal AS a WHERE a.pais = ?1 AND a.marca = ?2 AND a.estadoZona = ?3"),
@NamedQuery(name="EstadoZonaLocal.FindAll",query="SELECT OBJECT(a) FROM EstadoZonaLocal AS a")
})
public class EstadoZonaLocal implements Serializable {

	public EstadoZonaLocal() {}

	public EstadoZonaLocal(Long oid, String cod_esta_zona, Long pais_oid_pais, Long marc_oid_marc)	{
            this.oid = oid;
            this.estadoZona = cod_esta_zona;
            this.pais = pais_oid_pais;
            this.marca = marc_oid_marc;            
	}

	@Id
	@Column(name="OID_ESTA_ZONA")
	private Long oid;
	@Column(name="COD_ESTA_ZONA")
	private String estadoZona;
	@Column(name="IMPO_VENT_MINI")
	private Long importeVentaMinimo;
	@Column(name="VALO_TIEM_MINI")
	private Long tiempoMinimo;
	@Column(name="NUM_CONS_MIN")
	private Long numConsultMin;
	@Column(name="NUM_PEDI_ZONA")
	private Long numPedidoZona;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="IND_INIC")
	private Boolean indicadorInicio;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getEstadoZona() {return estadoZona;}
      
	public void setEstadoZona(String estadoZona){this.estadoZona=estadoZona;}
		
	public Long getImporteVentaMinimo() {return importeVentaMinimo;}
      
	public void setImporteVentaMinimo(Long importeVentaMinimo){this.importeVentaMinimo=importeVentaMinimo;}
		
	public Long getTiempoMinimo() {return tiempoMinimo;}
      
	public void setTiempoMinimo(Long tiempoMinimo){this.tiempoMinimo=tiempoMinimo;}
		
	public Long getNumConsultMin() {return numConsultMin;}
      
	public void setNumConsultMin(Long numConsultMin){this.numConsultMin=numConsultMin;}
		
	public Long getNumPedidoZona() {return numPedidoZona;}
      
	public void setNumPedidoZona(Long numPedidoZona){this.numPedidoZona=numPedidoZona;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Boolean getIndicadorInicio() {return indicadorInicio;}
      
	public void setIndicadorInicio(Boolean indicadorInicio){this.indicadorInicio=indicadorInicio;}
			
	
}
