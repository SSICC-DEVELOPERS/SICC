package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_CALEN")
@NamedQueries({
@NamedQuery(name="CalendarioLocal.FindByUK",query="SELECT OBJECT(cal) "
+ " FROM CalendarioLocal AS cal "
+ " WHERE cal.oidPais = ?1 "
+ " AND cal.oidMarca = ?2 "
+ " AND cal.oidCanal = ?3 "
+ " AND cal.anio = ?4 ")
})
public class CalendarioLocal implements Serializable {

	public CalendarioLocal() {}

	public CalendarioLocal(Long oid, Integer num_anio, Long marc_oid_marc, 
                                Long cana_oid_cana, Long pais_oid_pais)	{
	
		this.oid=oid;
                this.anio = num_anio;
                this.oidMarca = marc_oid_marc;
                this.oidCanal = cana_oid_cana;
                this.oidPais = pais_oid_pais;
	}

	@Id
	@Column(name="OID_CALE")
	private Long oid;
	@Column(name="NUM_ANIO")
	private Integer anio;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getAnio() {return anio;}
      
	public void setAnio(Integer anio){this.anio=anio;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
