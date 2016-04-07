package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_ESTAD_MERCA")
@NamedQueries({
@NamedQuery(name="EstadosMercanciaLocal.FindByUK",query="SELECT OBJECT(a) FROM EstadosMercanciaLocal AS a WHERE a.pais=?1 AND a.codigoEstado=?2")
})
public class EstadosMercanciaLocal implements Serializable {

	public EstadosMercanciaLocal() {}

	public EstadosMercanciaLocal(Long oid, Long pais, String codigoEstado)	{
		this.oid=oid;
                this.pais = pais;
                this.codigoEstado = codigoEstado;
	}

	@Id
	@Column(name="OID_ESTA_MERC")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_ESTA")
	private String codigoEstado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoEstado() {return codigoEstado;}
      
	public void setCodigoEstado(String codigoEstado){this.codigoEstado=codigoEstado;}
			
	
}
