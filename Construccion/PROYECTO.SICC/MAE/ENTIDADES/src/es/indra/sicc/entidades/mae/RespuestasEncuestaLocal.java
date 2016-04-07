package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_RESPU_ENCUE")
@NamedQueries({
@NamedQuery(name="RespuestasEncuestaLocal.FindAll",query="select object(o) from RespuestasEncuestaLocal o")
})
public class RespuestasEncuestaLocal implements Serializable {

	public RespuestasEncuestaLocal() {}

	public RespuestasEncuestaLocal(Long oid, Long prenOidPreg, String codResp, Long valPeso)	{
            this.oid=oid;
            this.oidPregunta = prenOidPreg;
            this.codigoRespuesta = codResp;
            this.peso = valPeso;
	}

	@Id
	@Column(name="OID_RESP")
	private Long oid;
	@Column(name="PREN_OID_PREG")
	private Long oidPregunta;
	@Column(name="COD_RESP")
	private String codigoRespuesta;
	@Column(name="VAL_PESO")
	private Long peso;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPregunta() {return oidPregunta;}
      
	public void setOidPregunta(Long oidPregunta){this.oidPregunta=oidPregunta;}
		
	public String getCodigoRespuesta() {return codigoRespuesta;}
      
	public void setCodigoRespuesta(String codigoRespuesta){this.codigoRespuesta=codigoRespuesta;}
		
	public Long getPeso() {return peso;}
      
	public void setPeso(Long peso){this.peso=peso;}
			
	
}
