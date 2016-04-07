package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_ESTRU_GEOPO")
@NamedQueries({
@NamedQuery(name="EstructuraGeopoliticaLocal.FindByPaisNivelEGBorrado", query="SELECT OBJECT(o) FROM EstructuraGeopoliticaLocal AS o "
+ "WHERE ?1 = o.oidPais "
+ "  AND ?2 = o.nivelEG "
+ "  AND ?3 = o.borrado"),
@NamedQuery(name="EstructuraGeopoliticaLocal.FindByPais", query="SELECT OBJECT(o) FROM EstructuraGeopoliticaLocal AS o "
+ "WHERE ?1 = o.oidPais "),
@NamedQuery(name="EstructuraGeopoliticaLocal.FindAll", query="SELECT OBJECT(o) FROM EstructuraGeopoliticaLocal AS o")
})
public class EstructuraGeopoliticaLocal implements Serializable {

	public EstructuraGeopoliticaLocal() {}

	public EstructuraGeopoliticaLocal(Long oid, Integer cod_nive, Long pais_oid_pais,
                Long dipo_oid_divi_poli, Timestamp fecha) {
                
            this.oid=oid;
            this.borrado = Boolean.FALSE;
            this.nivelEG = cod_nive;
            this.oidPais = pais_oid_pais;
            this.oidDivisionPolitica = dipo_oid_divi_poli;
            this.fechaActualizacion = fecha;
	}

	@Id
	@Column(name="OID_ESTR_GEOP")
	private Long oid;
	@Column(name="COD_ORDE")
	private Integer nivelEG;
	@Column(name="IND_BORR")
	private Boolean borrado;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="DIPO_OID_DIVI_POLI")
	private Long oidDivisionPolitica;
	@Column(name="FEC_ACTU")
	private java.sql.Timestamp fechaActualizacion;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNivelEG() {return nivelEG;}
      
	public void setNivelEG(Integer nivelEG){this.nivelEG=nivelEG;}
		
	public Boolean getBorrado() {return borrado;}
      
	public void setBorrado(Boolean borrado){this.borrado=borrado;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidDivisionPolitica() {return oidDivisionPolitica;}
      
	public void setOidDivisionPolitica(Long oidDivisionPolitica){this.oidDivisionPolitica=oidDivisionPolitica;}
		
	public java.sql.Timestamp getFechaActualizacion() {return fechaActualizacion;}
      
	public void setFechaActualizacion(java.sql.Timestamp fechaActualizacion){this.fechaActualizacion=fechaActualizacion;}
			
	
}
