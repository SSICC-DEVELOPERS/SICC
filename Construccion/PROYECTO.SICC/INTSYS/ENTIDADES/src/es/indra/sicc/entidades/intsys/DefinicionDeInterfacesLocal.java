package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_DEFIN_INTER")
@NamedQueries({
@NamedQuery(name="DefinicionDeInterfacesLocal.FindAll",query="select object(o) from DefinicionDeInterfacesLocal o")
})
public class DefinicionDeInterfacesLocal implements Serializable {

	public DefinicionDeInterfacesLocal() {}

	public DefinicionDeInterfacesLocal(Long oid, String codigo, String sistema, String modo, String tipoInterfaz)	{
            this.oid=oid;
	    this.codigo=codigo;
	    this.sistema=sistema;
	    this.modoEnvio=modo;
	    this.tipoInterfaz=tipoInterfaz;
	}

	@Id
	@Column(name="OID_DEFI_INTE")
	private Long oid;
	@Column(name="COD_DEFI_INTE")
	private String codigo;
	@Column(name="VAL_SIST")
	private String sistema;
	@Column(name="VAL_MODO_ENVI")
	private String modoEnvio;
	@Column(name="VAL_TIPO_INTE")
	private String tipoInterfaz;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getSistema() {return sistema;}
      
	public void setSistema(String sistema){this.sistema=sistema;}
		
	public String getModoEnvio() {return modoEnvio;}
      
	public void setModoEnvio(String modoEnvio){this.modoEnvio=modoEnvio;}
		
	public String getTipoInterfaz() {return tipoInterfaz;}
      
	public void setTipoInterfaz(String tipoInterfaz){this.tipoInterfaz=tipoInterfaz;}
			
	
}
