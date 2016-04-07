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
@Table(name="ZON_ZONA")
@NamedQueries({
@NamedQuery(name="ZonaLocal.FindByCodigo",query="SELECT OBJECT(o) "
+ " FROM ZonaLocal As o "
+ " WHERE o.oidRegion = ?1 "
+ " AND o.codZona = ?2 "
+ " AND o.borrado = 0"),
@NamedQuery(name="ZonaLocal.FindByCodigo2",query="SELECT OBJECT(o) "
+ " FROM ZonaLocal As o "
+ " WHERE o.oidPais = ?1 "
+ " AND o.oidMarca = ?2 "
+ " AND o.oidCanal = ?3 "
+ " AND o.codZona = ?4 "
+ " AND o.activa = 1"
+ " AND o.borrado = 0"),
@NamedQuery(name="ZonaLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM ZonaLocal As o "
+ " WHERE o.oidPais = ?1 "
+ " AND o.oidMarca = ?2 "
+ " AND o.oidCanal = ?3 "
+ " AND o.codZona = ?4"),
@NamedQuery(name="ZonaLocal.FindAll",query="SELECT OBJECT(o) FROM ZonaLocal As o ")
})
public class ZonaLocal implements Serializable {

	public ZonaLocal() {}

	public ZonaLocal(Long oid, String codZona, Long oidPais, Long oidMarca,
                Long oidCanal, Long zorg_oid_regi, Timestamp fz, Long oidPeriodoInicio) {
            
            this.oid=oid;
            this.codZona = codZona;
            this.oidPais = oidPais;
            this.oidMarca = oidMarca;
            this.oidCanal = oidCanal;
            this.oidRegion = zorg_oid_regi;
            this.fechaRezonificacion = fz;
            this.periodoInic = oidPeriodoInicio;
	}

	@Id
	@Column(name="OID_ZONA")
	private Long oid;
	@Column(name="COD_ZONA")
	private String codZona;
	@Column(name="COD_NSE1")
	private String nse1;
	@Column(name="COD_NSE2")
	private String nse2;
	@Column(name="COD_NSE3")
	private String nse3;
	@Column(name="IND_ACTI")
	private Long activa;
	@Column(name="IND_REZO")
	private Long rezonificacion;
	@Column(name="IND_BORR")
	private Long borrado;
	@Column(name="ESZO_OID_ESTA_ZONA")
	private Long oidEstadoZona;
	@Column(name="ZORG_OID_REGI")
	private Long oidRegion;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="DES_ZONA")
	private String descripcion;
	@Column(name="FEC_CAMB_ESTA")
	private java.sql.Timestamp fechaCambioEstado;
	@Column(name="FEC_REZO")
	private java.sql.Timestamp fechaRezonificacion;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFin;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInic;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodZona() {return codZona;}
      
	public void setCodZona(String codZona){this.codZona=codZona;}
		
	public String getNse1() {return nse1;}
      
	public void setNse1(String nse1){this.nse1=nse1;}
		
	public String getNse2() {return nse2;}
      
	public void setNse2(String nse2){this.nse2=nse2;}
		
	public String getNse3() {return nse3;}
      
	public void setNse3(String nse3){this.nse3=nse3;}
		
	public Long getActiva() {return activa;}
      
	public void setActiva(Long activa){this.activa=activa;}
		
	public Long getRezonificacion() {return rezonificacion;}
      
	public void setRezonificacion(Long rezonificacion){this.rezonificacion=rezonificacion;}
		
	public Long getBorrado() {return borrado;}
      
	public void setBorrado(Long borrado){this.borrado=borrado;}
		
	public Long getOidEstadoZona() {return oidEstadoZona;}
      
	public void setOidEstadoZona(Long oidEstadoZona){this.oidEstadoZona=oidEstadoZona;}
		
	public Long getOidRegion() {return oidRegion;}
      
	public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public java.sql.Timestamp getFechaCambioEstado() {return fechaCambioEstado;}
      
	public void setFechaCambioEstado(java.sql.Timestamp fechaCambioEstado){this.fechaCambioEstado=fechaCambioEstado;}
		
	public java.sql.Timestamp getFechaRezonificacion() {return fechaRezonificacion;}
      
	public void setFechaRezonificacion(java.sql.Timestamp fechaRezonificacion){this.fechaRezonificacion=fechaRezonificacion;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getPeriodoFin() {return periodoFin;}
      
	public void setPeriodoFin(Long periodoFin){this.periodoFin=periodoFin;}
		
	public Long getPeriodoInic() {return periodoInic;}
      
	public void setPeriodoInic(Long periodoInic){this.periodoInic=periodoInic;}
			
	
}
