package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ZON_REGIO")
@NamedQueries({
@NamedQuery(name="RegionLocal.FindByPaisMarcaCanalYCodigo",query="SELECT OBJECT(a) "
+ " FROM RegionLocal AS a "
+ " WHERE a.oidPais = ?1 "
+ " AND a.oidMarca = ?2 "
+ " AND a.oidCanal = ?3 "
+ " AND a.codigoRegion = ?4 "
+ " AND a.activo = 1 "
+ " AND a.borrado = 0"),
@NamedQuery(name="RegionLocal.FindByCodigo",query="SELECT OBJECT(o) "
+ " FROM RegionLocal As o "
+ " WHERE o.sgvOidSubgVenta = ?1 "
+ " AND o.codigoRegion = ?2 "
+ " AND o.borrado = 0"),
@NamedQuery(name="RegionLocal.FindAll",query="SELECT OBJECT(a) FROM RegionLocal AS a ")
})
public class RegionLocal implements Serializable {

	public RegionLocal() {}

	public RegionLocal(Long oid, String cod_regi, Long oidPais, Long oidMarca, Long oidCanal,
                Long zsgv_oid_subg_vent, Long oidPeriodoInicio, Long indActivo, Long indBorrado) {
            
            this.oid=oid;
            this.codigoRegion = cod_regi;
            this.oidPais = oidPais;
            this.oidMarca = oidMarca;
            this.oidCanal = oidCanal;
            this.sgvOidSubgVenta = zsgv_oid_subg_vent;
            this.periodoInic = oidPeriodoInicio;
            this.activo = indActivo;
            this.borrado = indBorrado;
	}

	@Id
	@Column(name="OID_REGI")
	private Long oid;
	@Column(name="COD_REGI")
	private String codigoRegion;
	@Column(name="COD_NSE1")
	private String codNse1;
	@Column(name="COD_NSE2")
	private String codNse2;
	@Column(name="COD_NSE3")
	private String codNse3;
	@Column(name="IND_ACTI")
	private Long activo;
	@Column(name="IND_BORR")
	private Long borrado;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long sgvOidSubgVenta;
	@Column(name="DES_REGI")
	private String descripcionRegion;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFin;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInic;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Timestamp fechaUltAct;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoRegion() {return codigoRegion;}
      
	public void setCodigoRegion(String codigoRegion){this.codigoRegion=codigoRegion;}
		
	public String getCodNse1() {return codNse1;}
      
	public void setCodNse1(String codNse1){this.codNse1=codNse1;}
		
	public String getCodNse2() {return codNse2;}
      
	public void setCodNse2(String codNse2){this.codNse2=codNse2;}
		
	public String getCodNse3() {return codNse3;}
      
	public void setCodNse3(String codNse3){this.codNse3=codNse3;}
		
	public Long getActivo() {return activo;}
      
	public void setActivo(Long activo){this.activo=activo;}
		
	public Long getBorrado() {return borrado;}
      
	public void setBorrado(Long borrado){this.borrado=borrado;}
		
	public Long getSgvOidSubgVenta() {return sgvOidSubgVenta;}
      
	public void setSgvOidSubgVenta(Long sgvOidSubgVenta){this.sgvOidSubgVenta=sgvOidSubgVenta;}
		
	public String getDescripcionRegion() {return descripcionRegion;}
      
	public void setDescripcionRegion(String descripcionRegion){this.descripcionRegion=descripcionRegion;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getPeriodoFin() {return periodoFin;}
      
	public void setPeriodoFin(Long periodoFin){this.periodoFin=periodoFin;}
		
	public Long getPeriodoInic() {return periodoInic;}
      
	public void setPeriodoInic(Long periodoInic){this.periodoInic=periodoInic;}
		
	public java.sql.Timestamp getFechaUltAct() {return fechaUltAct;}
      
	public void setFechaUltAct(java.sql.Timestamp fechaUltAct){this.fechaUltAct=fechaUltAct;}
			
	
}
