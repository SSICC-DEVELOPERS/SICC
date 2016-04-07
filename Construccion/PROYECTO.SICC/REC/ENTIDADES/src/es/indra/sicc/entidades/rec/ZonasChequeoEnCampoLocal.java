package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_ZONAS_CAMPO")
@NamedQueries({
@NamedQuery(name="ZonasChequeoEnCampoLocal.FindByConfiguracionClientes",query="SELECT OBJECT(s) FROM ZonasChequeoEnCampoLocal s WHERE s.confCliCheqCampo =?1 "),
@NamedQuery(name="ZonasChequeoEnCampoLocal.FindAll",query="select object(o) from ZonasChequeoEnCampoLocal o")
})
public class ZonasChequeoEnCampoLocal implements Serializable {

	public ZonasChequeoEnCampoLocal() {}

	public ZonasChequeoEnCampoLocal(Long oid, Long codigoZonasChequeo, Long confCliCheqCampo,
        Long region, Long seccion, Long subgerenciaVentas, Long zona)	{
	
		this.oid=oid;
                this.codigoZonasChequeo=codigoZonasChequeo;
                this.confCliCheqCampo=confCliCheqCampo;
                this.region=region;
                this.seccion=seccion;
                this.subgerenciaVentas=subgerenciaVentas;
                this.zona=zona;
	
	}
    
        public ZonasChequeoEnCampoLocal(Long oid, Long codigoZonasChequeo, Long confCliCheqCampo, Long subgerenciaVentas)   {
        
                this.oid=oid;
                this.codigoZonasChequeo=codigoZonasChequeo;
                this.confCliCheqCampo=confCliCheqCampo;
                this.subgerenciaVentas=subgerenciaVentas;

        
        }
	@Id
	@Column(name="OID_ZONA_CAMP")
	private Long oid;
	@Column(name="COD_ZONA_CHEQ")
	private Long codigoZonasChequeo;
	@Column(name="CCCC_OID_CONF_CAMP")
	private Long confCliCheqCampo;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerenciaVentas;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoZonasChequeo() {return codigoZonasChequeo;}
      
	public void setCodigoZonasChequeo(Long codigoZonasChequeo){this.codigoZonasChequeo=codigoZonasChequeo;}
		
	public Long getConfCliCheqCampo() {return confCliCheqCampo;}
      
	public void setConfCliCheqCampo(Long confCliCheqCampo){this.confCliCheqCampo=confCliCheqCampo;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getSubgerenciaVentas() {return subgerenciaVentas;}
      
	public void setSubgerenciaVentas(Long subgerenciaVentas){this.subgerenciaVentas=subgerenciaVentas;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
			
	
}
