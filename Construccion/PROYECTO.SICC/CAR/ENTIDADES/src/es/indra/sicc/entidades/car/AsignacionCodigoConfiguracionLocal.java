package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_ASIGN_CODIG_CONFI")
@NamedQueries({
@NamedQuery(name="AsignacionCodigoConfiguracionLocal.FindByCodigoConfiguracion",query="SELECT OBJECT(a) "
+ "  FROM AsignacionCodigoConfiguracionLocal AS a "
+ "  WHERE a.oidParametroCartera = ?1")
})
public class AsignacionCodigoConfiguracionLocal implements Serializable {

	public AsignacionCodigoConfiguracionLocal() {}

	public AsignacionCodigoConfiguracionLocal(Long oid, Long zsgv_oid_subg_vent, Long zorg_oid_regi, Long zzon_oid_zona, Long grso_oid_grup_soli, Long niri_oid_nive_ries, Long niri_oid_nive_ries_inici, Long paca_oid_para_cart, Double val_line_cred_inic)	{
	
		this.oid=oid;
	        this.setOidSubgerencia(zsgv_oid_subg_vent);
                this.setOidRegion(zorg_oid_regi);
	        this.setOidZona(zzon_oid_zona);
	        this.setOidGrupoSolicitud(grso_oid_grup_soli);
	        this.setOidNivelRiesgo(niri_oid_nive_ries);
	        this.setOidNivelRiesgoInicial(niri_oid_nive_ries_inici);
	        this.setOidParametroCartera(paca_oid_para_cart);
	        this.setLineaCreditoInicial(val_line_cred_inic);
	
	}

	@Id
	@Column(name="OID_ASIG_CODI_CONF")
	private Long oid;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long oidSubgerencia;
	@Column(name="ZORG_OID_REGI")
	private Long oidRegion;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;
	@Column(name="GRSO_OID_GRUP_SOLI")
	private Long oidGrupoSolicitud;
	@Column(name="NIRI_OID_NIVE_RIES")
	private Long oidNivelRiesgo;
	@Column(name="NIRI_OID_NIVE_RIES_INICI")
	private Long oidNivelRiesgoInicial;
	@Column(name="PACA_OID_PARA_CART")
	private Long oidParametroCartera;
	@Column(name="VAL_LINE_CRED_INIC")
	private Double lineaCreditoInicial;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidSubgerencia() {return oidSubgerencia;}
      
	public void setOidSubgerencia(Long oidSubgerencia){this.oidSubgerencia=oidSubgerencia;}
		
	public Long getOidRegion() {return oidRegion;}
      
	public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
		
	public Long getOidGrupoSolicitud() {return oidGrupoSolicitud;}
      
	public void setOidGrupoSolicitud(Long oidGrupoSolicitud){this.oidGrupoSolicitud=oidGrupoSolicitud;}
		
	public Long getOidNivelRiesgo() {return oidNivelRiesgo;}
      
	public void setOidNivelRiesgo(Long oidNivelRiesgo){this.oidNivelRiesgo=oidNivelRiesgo;}
		
	public Long getOidNivelRiesgoInicial() {return oidNivelRiesgoInicial;}
      
	public void setOidNivelRiesgoInicial(Long oidNivelRiesgoInicial){this.oidNivelRiesgoInicial=oidNivelRiesgoInicial;}
		
	public Long getOidParametroCartera() {return oidParametroCartera;}
      
	public void setOidParametroCartera(Long oidParametroCartera){this.oidParametroCartera=oidParametroCartera;}
		
	public Double getLineaCreditoInicial() {return lineaCreditoInicial;}
      
	public void setLineaCreditoInicial(Double lineaCreditoInicial){this.lineaCreditoInicial=lineaCreditoInicial;}
			
	
}
