package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_DETAL_GRUPO_ZONA")
@NamedQueries({
@NamedQuery(name="DetalleGruposZonasLocal.FindByCabeceraPK",query="SELECT OBJECT(i) "
+ " FROM DetalleGruposZonasLocal AS i "
+ " WHERE i.oidGrupoZona = ?1"),
@NamedQuery(name="DetalleGruposZonasLocal.FindByOidGrupoOidZona",query="SELECT OBJECT(i) "
+ " FROM DetalleGruposZonasLocal AS i "
+ " WHERE i.oidGrupoZona = ?1 AND i.oidZona = ?2")
})
public class DetalleGruposZonasLocal implements Serializable {

	public DetalleGruposZonasLocal() {}

	public DetalleGruposZonasLocal(Long oid, Long zzon_oid_zona,
                                  Long cgzo_oid_cabe_grup_zona)	{
	
		this.oid=oid;
                this.oidZona = zzon_oid_zona;
                this.oidGrupoZona = cgzo_oid_cabe_grup_zona;
	}

	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Id
	@Column(name="OID_DETA_GRUP_ZONA")
	private Long oid;
	@Column(name="CGZO_OID_CABE_GRUP_ZONA")
	private Long oidGrupoZona;

	
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidGrupoZona() {return oidGrupoZona;}
      
	public void setOidGrupoZona(Long oidGrupoZona){this.oidGrupoZona=oidGrupoZona;}
			
	
}
