package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ZON_SECCI")
@NamedQueries({
@NamedQuery(name="SeccionLocal.FindByCodigo",query="SELECT OBJECT(a)"
+ " FROM SeccionLocal AS a , ZonaLocal AS z"
+ " WHERE a.oidZona = z.oid"
+ " AND z.oidPais = ?1"
+ " AND z.oidMarca = ?2"
+ " AND z.oidCanal = ?3"
+ " AND a.oidZona = ?4"
+ " AND a.codSecc = ?5"
+ " AND a.borrado = 0"),
@NamedQuery(name="SeccionLocal.FindAll",query="SELECT OBJECT(a) FROM SeccionLocal AS a")
})
public class SeccionLocal implements Serializable {

	public SeccionLocal() {}

	public SeccionLocal(Long oid, String cod_secc, Long zzon_oid_zona, Long oidPeriodoInicio) {
            this.oid=oid;
            this.codSecc = cod_secc;
            this.oidZona = zzon_oid_zona;
            this.periodoInic = oidPeriodoInicio;
	}

	@Id
	@Column(name="OID_SECC")
	private Long oid;
	@Column(name="COD_SECC")
	private String codSecc;
	@Column(name="IND_ACTI")
	private Long activo;
	@Column(name="IND_BORR")
	private Long borrado;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Column(name="CLIE_OID_CLIE")
	private Long clienteOid;
	@Column(name="COD_NSE1")
	private String codNse1;
	@Column(name="COD_NSE2")
	private String codNse2;
	@Column(name="COD_NSE3")
	private String codNse3;
	@Column(name="DES_SECCI")
	private String desripcion;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFin;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInic;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodSecc() {return codSecc;}
      
	public void setCodSecc(String codSecc){this.codSecc=codSecc;}
		
	public Long getActivo() {return activo;}
      
	public void setActivo(Long activo){this.activo=activo;}
		
	public Long getBorrado() {return borrado;}
      
	public void setBorrado(Long borrado){this.borrado=borrado;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getClienteOid() {return clienteOid;}
      
	public void setClienteOid(Long clienteOid){this.clienteOid=clienteOid;}
		
	public String getCodNse1() {return codNse1;}
      
	public void setCodNse1(String codNse1){this.codNse1=codNse1;}
		
	public String getCodNse2() {return codNse2;}
      
	public void setCodNse2(String codNse2){this.codNse2=codNse2;}
		
	public String getCodNse3() {return codNse3;}
      
	public void setCodNse3(String codNse3){this.codNse3=codNse3;}
		
	public String getDesripcion() {return desripcion;}
      
	public void setDesripcion(String desripcion){this.desripcion=desripcion;}
		
	public Long getPeriodoFin() {return periodoFin;}
      
	public void setPeriodoFin(Long periodoFin){this.periodoFin=periodoFin;}
		
	public Long getPeriodoInic() {return periodoInic;}
      
	public void setPeriodoInic(Long periodoInic){this.periodoInic=periodoInic;}
			
	
}
