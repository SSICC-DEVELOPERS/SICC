package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_TIPOS_ABONO_DAT")
@NamedQueries({
@NamedQuery(name="TipoAbonoDATLocal.FindAll",query="select object(o) from TipoAbonoDATLocal o")
})
public class TipoAbonoDATLocal implements Serializable {

	public TipoAbonoDATLocal() {}

	public TipoAbonoDATLocal(Long oid, String indicador, Long tipoAbonoCargo) {
            this.oid=oid;
	    this.indicador=indicador;
	    this.tipoAbonoCargo=tipoAbonoCargo;
	}

	@Id
	@Column(name="OID_TIPO_ABON_DAT")
	private Long oid;
	@Column(name="IND_INDI")
	private String indicador;
	@Column(name="TCAB_OID_TIPO_CARG_ABON")
	private Long tipoAbonoCargo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getIndicador() {return indicador;}
      
	public void setIndicador(String indicador){this.indicador=indicador;}
		
	public Long getTipoAbonoCargo() {return tipoAbonoCargo;}
      
	public void setTipoAbonoCargo(Long tipoAbonoCargo){this.tipoAbonoCargo=tipoAbonoCargo;}
			
	
}
