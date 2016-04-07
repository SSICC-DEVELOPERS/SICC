package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_DETAL_MAV_ACCES_SUBAC")
@NamedQueries({
@NamedQuery(name="AccesosSubaccesosPorDetalleMAVLocal.FindByOidDetaMav",query="SELECT OBJECT(a) "+
"FROM AccesosSubaccesosPorDetalleMAVLocal AS a "+
"WHERE a.oidDetalleMAV = ?1")
})
public class AccesosSubaccesosPorDetalleMAVLocal implements Serializable {

	public AccesosSubaccesosPorDetalleMAVLocal() {}

	public AccesosSubaccesosPorDetalleMAVLocal(Long oid, Long oidDetalleMAV, Long oidSubacceso) {
	
		this.oid=oid;
                this.oidSubacceso=oidSubacceso;
                this.oidDetalleMAV=oidDetalleMAV;                
	
	}

	@Id
	@Column(name="OID_DETA_MAV_ACCE_SUBA")
	private Long oid;
	@Column(name="DENV_OID_DETA_MAV")
	private Long oidDetalleMAV;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSubacceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidDetalleMAV() {return oidDetalleMAV;}
      
	public void setOidDetalleMAV(Long oidDetalleMAV){this.oidDetalleMAV=oidDetalleMAV;}
		
	public Long getOidSubacceso() {return oidSubacceso;}
      
	public void setOidSubacceso(Long oidSubacceso){this.oidSubacceso=oidSubacceso;}
			
	
}
