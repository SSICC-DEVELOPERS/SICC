package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_CABEC_GRUPO_ZONA")
@NamedQueries({
@NamedQuery(name="CabeceraGruposZonasLocal.FindByOldPK",query="SELECT OBJECT(i) "
+ " FROM CabeceraGruposZonasLocal AS i "
+ " WHERE i.oidMarca = ?1 AND i.oidPais = ?2 "
+ " AND i.oidCanal = ?3 AND i.codigo = ?4 ")
})
public class CabeceraGruposZonasLocal implements Serializable {

	public CabeceraGruposZonasLocal() {}

	public CabeceraGruposZonasLocal(Long oid, Long pais_oid_pais, 
                                    Long marc_oid_marc, Long cana_oid_cana, 
                                    Integer cod_grup,
                                    Long cod_tipo_fact, Boolean ind_esta)	{
	
		this.oid=oid;
                this.oidPais = pais_oid_pais;
                this.oidMarca = marc_oid_marc;
                this.oidCanal = cana_oid_cana;
                this.codigo = cod_grup;
                this.tipoFacturacion = cod_tipo_fact;
                this.inStatus = ind_esta;
	}

	@Id
	@Column(name="OID_CABE_GRUP_ZONA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="COD_GRUP")
	private Integer codigo;
	@Column(name="TIFA_OID_TIPO_FACT")
	private Long tipoFacturacion;
	@Column(name="IND_ESTA")
	private Boolean inStatus;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public Long getTipoFacturacion() {return tipoFacturacion;}
      
	public void setTipoFacturacion(Long tipoFacturacion){this.tipoFacturacion=tipoFacturacion;}
		
	public Boolean getInStatus() {return inStatus;}
      
	public void setInStatus(Boolean inStatus){this.inStatus=inStatus;}
			
	
}
