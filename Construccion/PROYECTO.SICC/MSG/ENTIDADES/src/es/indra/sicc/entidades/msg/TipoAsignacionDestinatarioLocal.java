package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_TIPO_ASIGN_DESTI")
public class TipoAsignacionDestinatarioLocal implements Serializable {

	public TipoAsignacionDestinatarioLocal() {}

	public TipoAsignacionDestinatarioLocal(Long oid, Long ind_excl)	{
	
		this.oid=oid;
                this.ind_excl=ind_excl;
	
	}

	@Id
	@Column(name="OID_TIPO_DEST")
	private Long oid;
	@Column(name="IND_EXCL")
	private Long ind_excl;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getInd_excl() {return ind_excl;}
      
	public void setInd_excl(Long ind_excl){this.ind_excl=ind_excl;}
			
	
}
