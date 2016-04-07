package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_AMBIT_GEOGR")
@NamedQueries({
@NamedQuery(name="AmbitoGeograficoLocal.FindAll",query="select object(o) from AmbitoGeograficoLocal o"),
@NamedQuery(name="AmbitoGeograficoLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM AmbitoGeograficoLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class AmbitoGeograficoLocal implements Serializable {

	public AmbitoGeograficoLocal() {}

	public AmbitoGeograficoLocal(Long oid, Long zsgvOidSubgVent, Long copaOidParaGral)	{
	
		this.oid=oid;
	        this.setSubgerencia(zsgvOidSubgVent);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_AMBITO_GEOGRAFICO")
	private Long oid;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerencia;
	@Column(name="TERR_OID_TERR")
	private Long territorio;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getSubgerencia() {return subgerencia;}
      
	public void setSubgerencia(Long subgerencia){this.subgerencia=subgerencia;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
	
}
