package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PRODU_NO_RECOG")
@NamedQueries({
@NamedQuery(name="ProductoNoRecogibleLocal.FindAll",query="select object(o) from ProductoNoRecogibleLocal o")
})
public class ProductoNoRecogibleLocal implements Serializable {

	public ProductoNoRecogibleLocal() {}

	public ProductoNoRecogibleLocal(Long oid, Long paisOidPais, Long canaOidCana, Long perdOidPeri, Long marcOidMarc, Long oidArticuloLote, Long oidDetalleOferta)	{
	
		this.oid=oid;
                this.oidPais=paisOidPais;
                this.oidCanal=canaOidCana;
                this.oidPeriodo=perdOidPeri;
                this.oidMarca=marcOidMarc;
                this.oidArticuloLote=oidArticuloLote;
                this.oidDetalleOferta=oidDetalleOferta;
	
	}

	@Id
	@Column(name="OID_PROD_NO_RECO")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="OFDE_OID_DETA_OFER")
	private Long oidDetalleOferta;
	@Column(name="ARLO_OID_ARTI_LOTE")
	private Long oidArticuloLote;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidDetalleOferta() {return oidDetalleOferta;}
      
	public void setOidDetalleOferta(Long oidDetalleOferta){this.oidDetalleOferta=oidDetalleOferta;}
		
	public Long getOidArticuloLote() {return oidArticuloLote;}
      
	public void setOidArticuloLote(Long oidArticuloLote){this.oidArticuloLote=oidArticuloLote;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
			
	
}
