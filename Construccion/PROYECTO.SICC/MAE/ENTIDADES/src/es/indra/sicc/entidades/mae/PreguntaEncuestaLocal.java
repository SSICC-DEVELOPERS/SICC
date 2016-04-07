package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_PREGU_ENCUE")
@NamedQueries({
@NamedQuery(name="PreguntaEncuestaLocal.FindAll",query="select object(o) from PreguntaEncuestaLocal o")
})
public class PreguntaEncuestaLocal implements Serializable {

	public PreguntaEncuestaLocal() {}

	public PreguntaEncuestaLocal(Long oid, String codPreg, Long valPesoPreg, Long enseOidEncu)	{
            this.oid = oid;
            this.codigoPregunta = codPreg;
            this.peso = valPesoPreg;
            this.oidEncu = enseOidEncu;
	}

	@Id
	@Column(name="OID_PREG")
	private Long oid;
	@Column(name="COD_PREG")
	private String codigoPregunta;
	@Column(name="VAL_PESO_PREG")
	private Long peso;
	@Column(name="ENSE_OID_ENCU")
	private Long oidEncu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoPregunta() {return codigoPregunta;}
      
	public void setCodigoPregunta(String codigoPregunta){this.codigoPregunta=codigoPregunta;}
		
	public Long getPeso() {return peso;}
      
	public void setPeso(Long peso){this.peso=peso;}
		
	public Long getOidEncu() {return oidEncu;}
      
	public void setOidEncu(Long oidEncu){this.oidEncu=oidEncu;}
			
	
}
