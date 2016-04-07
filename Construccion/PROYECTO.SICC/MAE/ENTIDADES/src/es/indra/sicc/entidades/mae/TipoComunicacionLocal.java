package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_COMUN")
@NamedQueries({
@NamedQuery(name="TipoComunicacionLocal.FindAll",query="select object(o) from TipoComunicacionLocal o"),
@NamedQuery(name="TipoComunicacionLocal.FindByUK",query="SELECT OBJECT(a) FROM TipoComunicacionLocal AS a "
+ " WHERE a.codTipoComu = ?1")
})
public class TipoComunicacionLocal implements Serializable {

	public TipoComunicacionLocal() {}

	public TipoComunicacionLocal(Long oid, String codTipoComu)	{
            this.oid=oid;
            this.codTipoComu = codTipoComu;
	}

	@Id
	@Column(name="OID_TIPO_COMU")
	private Long oid;
	@Column(name="COD_TIPO_COMU")
	private String codTipoComu;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodTipoComu() {return codTipoComu;}
      
	public void setCodTipoComu(String codTipoComu){this.codTipoComu=codTipoComu;}
			
	
}
