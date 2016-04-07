package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_MODO_ABONO_DEFEC")
@NamedQueries({
@NamedQuery(name="ModoAbonoDefectoLocal.FindAll",query="select object(o) from ModoAbonoDefectoLocal o")
})
public class ModoAbonoDefectoLocal implements Serializable {

	public ModoAbonoDefectoLocal() {}

	public ModoAbonoDefectoLocal(Long oid, String codModoAbono )	{
	
		this.oid=oid;
                this.codModoAbono=codModoAbono;
	}

	@Id
	@Column(name="OID_MODO_ABON_DEFE")
	private Long oid;
	@Column(name="COD_MODO_ABON")
	private String codModoAbono;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodModoAbono() {return codModoAbono;}
      
	public void setCodModoAbono(String codModoAbono){this.codModoAbono=codModoAbono;}
			
	
}
