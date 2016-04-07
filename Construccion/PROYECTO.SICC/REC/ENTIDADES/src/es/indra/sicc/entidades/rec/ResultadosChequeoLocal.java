package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_RESUL_CHEQU")
@NamedQueries({
@NamedQuery(name="ResultadosChequeoLocal.FindAll",query="select object(o) from ResultadosChequeoLocal o")
})
public class ResultadosChequeoLocal implements Serializable {

	public ResultadosChequeoLocal() {}

	public ResultadosChequeoLocal(Long oid, Long pais, String codigo, Boolean indicativoResultado)	{
	
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
                this.indicativoResultado=indicativoResultado;
	
	}

	@Id
	@Column(name="OID_RESU_CHEQ")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_RESU_CHEQ")
	private String codigo;
	@Column(name="IND_RESU")
	private Boolean indicativoResultado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Boolean getIndicativoResultado() {return indicativoResultado;}
      
	public void setIndicativoResultado(Boolean indicativoResultado){this.indicativoResultado=indicativoResultado;}
			
	
}
