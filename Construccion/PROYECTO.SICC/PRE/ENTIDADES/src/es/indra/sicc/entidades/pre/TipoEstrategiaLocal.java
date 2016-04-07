package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_TIPO_ESTRA")
@NamedQueries({
@NamedQuery(name="TipoEstrategiaLocal.FindByUK",query="SELECT OBJECT(t) "
+"FROM TipoEstrategiaLocal AS t WHERE t.codigoTipoEstrategia = ?1")
})
public class TipoEstrategiaLocal implements Serializable {

	public TipoEstrategiaLocal() {}

	public TipoEstrategiaLocal(Long oid, String cod_tipo_estr, String des_tipo_estr){
	
		this.oid=oid;
                this.codigoTipoEstrategia=cod_tipo_estr;
                this.descripcion=des_tipo_estr;
	
	}

	@Id
	@Column(name="OID_TIPO_ESTR")
	private Long oid;
	@Column(name="COD_TIPO_ESTR")
	private String codigoTipoEstrategia;
	@Column(name="DES_TIPO_ESTR")
	private String descripcion;
	@Column(name="IND_ESTR_GRUP")
	private Boolean estrategiaGrupo;
	@Column(name="IND_ESTR_COND")
	private Boolean estrategiaCondicionada;
	@Column(name="IND_ESTR_VS")
	private Boolean estrategiaVS;
	@Column(name="IND_ESTR_PAQU")
	private Boolean estrategiaPaquetes;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoEstrategia() {return codigoTipoEstrategia;}
      
	public void setCodigoTipoEstrategia(String codigoTipoEstrategia){this.codigoTipoEstrategia=codigoTipoEstrategia;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getEstrategiaGrupo() {return estrategiaGrupo;}
      
	public void setEstrategiaGrupo(Boolean estrategiaGrupo){this.estrategiaGrupo=estrategiaGrupo;}
		
	public Boolean getEstrategiaCondicionada() {return estrategiaCondicionada;}
      
	public void setEstrategiaCondicionada(Boolean estrategiaCondicionada){this.estrategiaCondicionada=estrategiaCondicionada;}
		
	public Boolean getEstrategiaVS() {return estrategiaVS;}
      
	public void setEstrategiaVS(Boolean estrategiaVS){this.estrategiaVS=estrategiaVS;}
		
	public Boolean getEstrategiaPaquetes() {return estrategiaPaquetes;}
      
	public void setEstrategiaPaquetes(Boolean estrategiaPaquetes){this.estrategiaPaquetes=estrategiaPaquetes;}
			
	
}
