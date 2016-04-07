package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_MOTIV_DEVOL")
@NamedQueries({
@NamedQuery(name="MotivosDevolucionLocal.FindAll",query="select object(o) from MotivosDevolucionLocal o")
})
public class MotivosDevolucionLocal implements Serializable {

	public MotivosDevolucionLocal() {}

	public MotivosDevolucionLocal(Long oid, String codMotivoDevolucion, Long pais)	{
	
		this.oid=oid;
                this.codigoMotivoDevolucion=codMotivoDevolucion;
                this.pais=pais;
	
	}

	@Id
	@Column(name="OID_MOTI_DEVO")
	private Long oid;
	@Column(name="COD_MOTI_DEVO")
	private String codigoMotivoDevolucion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoMotivoDevolucion() {return codigoMotivoDevolucion;}
      
	public void setCodigoMotivoDevolucion(String codigoMotivoDevolucion){this.codigoMotivoDevolucion=codigoMotivoDevolucion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
