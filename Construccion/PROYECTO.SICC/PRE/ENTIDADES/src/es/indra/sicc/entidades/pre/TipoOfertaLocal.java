package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_TIPO_OFERT")
@NamedQueries({
@NamedQuery(name="TipoOfertaLocal.FindByOidCanal",query="SELECT OBJECT(i) "
+"FROM TipoOfertaLocal AS i WHERE i.oidCanal = ?1"),
@NamedQuery(name="TipoOfertaLocal.FindByUK",query="SELECT OBJECT(t) "
+" FROM TipoOfertaLocal AS t WHERE t.oidCanal = ?1 AND t.codigoTipoOferta = ?2")
})
public class TipoOfertaLocal implements Serializable {

	public TipoOfertaLocal() {}

	public TipoOfertaLocal(Long oid, Long cana_oid_cana, String cod_tipo_ofer) {
	
		this.oid=oid;
                this.oidCanal=cana_oid_cana;
                this.codigoTipoOferta=cod_tipo_ofer;
	
	}

	@Id
	@Column(name="OID_TIPO_OFER")
	private Long oid;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="COD_TIPO_OFER")
	private String codigoTipoOferta;
	@Column(name="IND_COMI")
	private Boolean comisionable;
	@Column(name="IND_PUNT")
	private Boolean puntaje;
	@Column(name="IND_ESTA")
	private Boolean estadisticable;
	@Column(name="IND_MONT_MINI")
	private Boolean montoMinimo;
	@Column(name="IND_APOR_MONT_ESCA")
	private Boolean aportaMontoEscala;
	@Column(name="IND_GRAT")
	private Boolean gratis;
	@Column(name="VAL_FORM_VENT")
	private Integer valorFormaVenta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public String getCodigoTipoOferta() {return codigoTipoOferta;}
      
	public void setCodigoTipoOferta(String codigoTipoOferta){this.codigoTipoOferta=codigoTipoOferta;}
		
	public Boolean getComisionable() {return comisionable;}
      
	public void setComisionable(Boolean comisionable){this.comisionable=comisionable;}
		
	public Boolean getPuntaje() {return puntaje;}
      
	public void setPuntaje(Boolean puntaje){this.puntaje=puntaje;}
		
	public Boolean getEstadisticable() {return estadisticable;}
      
	public void setEstadisticable(Boolean estadisticable){this.estadisticable=estadisticable;}
		
	public Boolean getMontoMinimo() {return montoMinimo;}
      
	public void setMontoMinimo(Boolean montoMinimo){this.montoMinimo=montoMinimo;}
		
	public Boolean getAportaMontoEscala() {return aportaMontoEscala;}
      
	public void setAportaMontoEscala(Boolean aportaMontoEscala){this.aportaMontoEscala=aportaMontoEscala;}
		
	public Boolean getGratis() {return gratis;}
      
	public void setGratis(Boolean gratis){this.gratis=gratis;}
		
	public Integer getValorFormaVenta() {return valorFormaVenta;}
      
	public void setValorFormaVenta(Integer valorFormaVenta){this.valorFormaVenta=valorFormaVenta;}
			
	
}
