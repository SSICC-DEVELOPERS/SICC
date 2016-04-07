package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_DETAL_MAV_UNIDA_ADMIN")
@NamedQueries({
@NamedQuery(name="UnidadAdministrativaPorDetalleMAVLocal.FindByOidDetaMav",query="SELECT OBJECT(a) "+
" FROM UnidadAdministrativaPorDetalleMAVLocal AS a "+
" WHERE a.oidDetalleMAV = ?1")
})
public class UnidadAdministrativaPorDetalleMAVLocal implements Serializable {

	public UnidadAdministrativaPorDetalleMAVLocal() {}

	public UnidadAdministrativaPorDetalleMAVLocal(Long oid, Long oidDetalleMAV, Long oidZona, Long oidTerritorio, Long oidRegion, Long oidSubgerencia)	{
	
		this.oid=oid;
                this.oidDetalleMAV=oidDetalleMAV;
                this.oidZona=oidZona;
                this.oidTerritorio=oidTerritorio;
                this.oidRegion=oidRegion;
                this.oidSubgerencia=oidSubgerencia;                
	
	}

	@Id
	@Column(name="OID_DETA_MAV_UNID_ADMI")
	private Long oid;
	@Column(name="DENV_OID_DETA_MAV")
	private Long oidDetalleMAV;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Column(name="TERR_OID_TERR")
	private Long oidTerritorio;
	@Column(name="ZORG_OID_REGI")
	private Long oidRegion;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long oidSubgerencia;

        // sapaza -- PER-SiCC-2010-0699 -- 12/12/2010
        @Column(name="NUM_UNID")
        private Long unidades;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidDetalleMAV() {return oidDetalleMAV;}
      
	public void setOidDetalleMAV(Long oidDetalleMAV){this.oidDetalleMAV=oidDetalleMAV;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOidTerritorio() {return oidTerritorio;}
      
	public void setOidTerritorio(Long oidTerritorio){this.oidTerritorio=oidTerritorio;}
		
	public Long getOidRegion() {return oidRegion;}
      
	public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
		
	public Long getOidSubgerencia() {return oidSubgerencia;}
      
	public void setOidSubgerencia(Long oidSubgerencia){this.oidSubgerencia=oidSubgerencia;}

        public void setUnidades(Long unidades) {this.unidades = unidades;}

        public Long getUnidades() {return unidades;}
        
}
