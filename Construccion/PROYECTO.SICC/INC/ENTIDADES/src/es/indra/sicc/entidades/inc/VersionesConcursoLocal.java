package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_VERSI_CONCU")
@NamedQueries({
@NamedQuery(name="VersionesConcursoLocal.FindAll",query="select object(o) from VersionesConcursoLocal o"),
@NamedQuery(name="VersionesConcursoLocal.FindByConcurso",query="SELECT OBJECT(v) FROM VersionesConcursoLocal AS v WHERE v.concurso = ?1"),
@NamedQuery(name="VersionesConcursoLocal.FindByConcursoVersion",query="SELECT OBJECT(v) "
+ " FROM VersionesConcursoLocal AS v "
+ " WHERE v.concurso = ?1 "
+ " AND v.versionNueva = ?2")
})
public class VersionesConcursoLocal implements Serializable {

	public VersionesConcursoLocal() {}

	public VersionesConcursoLocal(Long oid, Integer valVersNuev, String numConc, Long perdOidPeri, Long copaOidParaGralOrig, Long esc2OidEstaConc, Long vigenciaConcurso)	{
	
		this.oid=oid;
                this.setVersionNueva(valVersNuev);
	        this.setNumeroConcurso(numConc);
	        this.setPeriodoEntradaVigor(perdOidPeri);
	        this.setConcursoOrigen(copaOidParaGralOrig);
	        this.setEstadoConcurso(esc2OidEstaConc);
	        this.setVigenciaConcurso(vigenciaConcurso);
	
	}

	@Id
	@Column(name="OID_VERS_CONC")
	private Long oid;
	@Column(name="VAL_VERS_NUEV")
	private Integer versionNueva;
	@Column(name="NUM_CONC")
	private String numeroConcurso;
	@Column(name="PERD_OID_PERI")
	private Long periodoEntradaVigor;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="COPA_OID_PARA_GRAL_ORIG")
	private Long concursoOrigen;
	@Column(name="ESC2_OID_ESTA_CONC")
	private Long estadoConcurso;
	@Column(name="VICO_OID_VIGE_CONC")
	private Long vigenciaConcurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getVersionNueva() {return versionNueva;}
      
	public void setVersionNueva(Integer versionNueva){this.versionNueva=versionNueva;}
		
	public String getNumeroConcurso() {return numeroConcurso;}
      
	public void setNumeroConcurso(String numeroConcurso){this.numeroConcurso=numeroConcurso;}
		
	public Long getPeriodoEntradaVigor() {return periodoEntradaVigor;}
      
	public void setPeriodoEntradaVigor(Long periodoEntradaVigor){this.periodoEntradaVigor=periodoEntradaVigor;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getConcursoOrigen() {return concursoOrigen;}
      
	public void setConcursoOrigen(Long concursoOrigen){this.concursoOrigen=concursoOrigen;}
		
	public Long getEstadoConcurso() {return estadoConcurso;}
      
	public void setEstadoConcurso(Long estadoConcurso){this.estadoConcurso=estadoConcurso;}
		
	public Long getVigenciaConcurso() {return vigenciaConcurso;}
      
	public void setVigenciaConcurso(Long vigenciaConcurso){this.vigenciaConcurso=vigenciaConcurso;}
			
	
}
