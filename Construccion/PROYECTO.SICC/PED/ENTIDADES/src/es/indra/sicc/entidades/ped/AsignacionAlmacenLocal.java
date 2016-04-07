package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_ASIGN_ALMAC")
@NamedQueries({
@NamedQuery(name="AsignacionAlmacenLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM AsignacionAlmacenLocal AS a "
+ " WHERE a.pais = ?1 "
+ " AND a.marca = ?2 "
+ " AND a.subacceso = ?3"),
@NamedQuery(name="AsignacionAlmacenLocal.FindAll",query="SELECT OBJECT(a) FROM AsignacionAlmacenLocal AS a")
})
public class AsignacionAlmacenLocal implements Serializable {

	public AsignacionAlmacenLocal() {}

	public AsignacionAlmacenLocal(Long oid, Long sbac_oid_sbac, Long marc_oid_marc, Long almc_oid_alma, Long pais_oid_pais)	{
            this.oid=oid;
            this.subacceso = sbac_oid_sbac;
            this.marca = marc_oid_marc;
            this.almacen = almc_oid_alma;
            this.pais = pais_oid_pais;
	}

	@Id
	@Column(name="OID_ASIG_ALMA")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
