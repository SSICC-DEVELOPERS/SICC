package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CATAL_ORDEN")
public class OrdenCatalogoLocal implements Serializable {

	public OrdenCatalogoLocal() {}

	public OrdenCatalogoLocal(Long oid, Integer num_orde, 
                        Long ocat_oid_cata, Long marc_oid_marc, Long cana_oid_cana) {
	
		this.oid=oid;
                this.numeroOrden=num_orde;
                this.oidCatalogo=ocat_oid_cata;
                this.oidMarca=marc_oid_marc;
                this.oidCanal=cana_oid_cana;
	
	}

	@Id
	@Column(name="OID_CATA_ORDE")
	private Long oid;
	@Column(name="NUM_ORDE")
	private Integer numeroOrden;
	@Column(name="OCAT_OID_CATA")
	private Long oidCatalogo;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroOrden() {return numeroOrden;}
      
	public void setNumeroOrden(Integer numeroOrden){this.numeroOrden=numeroOrden;}
		
	public Long getOidCatalogo() {return oidCatalogo;}
      
	public void setOidCatalogo(Long oidCatalogo){this.oidCatalogo=oidCatalogo;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
			
	
}
