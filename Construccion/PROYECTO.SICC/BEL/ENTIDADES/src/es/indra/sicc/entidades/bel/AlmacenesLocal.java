package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_ALMAC")
@NamedQueries({
@NamedQuery(name="AlmacenesLocal.FindByUK",query="SELECT OBJECT(o) FROM AlmacenesLocal o WHERE o.pais = ?1 AND o.codigoAlmacen = ?2")
})
public class AlmacenesLocal implements Serializable {

	public AlmacenesLocal() {}

	public AlmacenesLocal(Long oid, Long pais, String codigoAlmacen, Boolean informarSAP)	{
		this.oid=oid;
                this.pais = pais;
                this.codigoAlmacen = codigoAlmacen;
                this.informarSAP = informarSAP;
	}

	@Id
	@Column(name="OID_ALMA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_ALMA")
	private String codigoAlmacen;
	@Column(name="IND_INFO_SAP")
	private Boolean informarSAP;
	@Column(name="CCDI_OID_CONFI_CENTR_DISTR")
	private Long oidCentroDistribucion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoAlmacen() {return codigoAlmacen;}
      
	public void setCodigoAlmacen(String codigoAlmacen){this.codigoAlmacen=codigoAlmacen;}
		
	public Boolean getInformarSAP() {return informarSAP;}
      
	public void setInformarSAP(Boolean informarSAP){this.informarSAP=informarSAP;}
		
	public Long getOidCentroDistribucion() {return oidCentroDistribucion;}
      
	public void setOidCentroDistribucion(Long oidCentroDistribucion){this.oidCentroDistribucion=oidCentroDistribucion;}
			
	
}
