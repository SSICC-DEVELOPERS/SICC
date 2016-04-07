package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_TIPO_VIA")
@NamedQueries({
@NamedQuery(name="TipoViaLocal.FindByUK",query="select object(t) from TipoViaLocal t"
+ " where t.codigoTipoVia = ?1"),
@NamedQuery(name="TipoViaLocal.FindAll",query="select object(t) from TipoViaLocal t")
})
public class TipoViaLocal implements Serializable {

	public TipoViaLocal() {}

	public TipoViaLocal(Long oid, String codigoTipoVia, String descAbreTipoVia)	{
		this.oid = oid;
		this.codigoTipoVia = codigoTipoVia;
		this.descAbreTipoVia = descAbreTipoVia;
	}

	@Id
	@Column(name="OID_TIPO_VIA")
	private Long oid;
	@Column(name="COD_TIPO_VIA")
	private String codigoTipoVia;
	@Column(name="DES_ABRV_TIPO_VIA")
	private String descAbreTipoVia;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoTipoVia() {return codigoTipoVia;}
      
	public void setCodigoTipoVia(String codigoTipoVia){this.codigoTipoVia=codigoTipoVia;}
		
	public String getDescAbreTipoVia() {return descAbreTipoVia;}
      
	public void setDescAbreTipoVia(String descAbreTipoVia){this.descAbreTipoVia=descAbreTipoVia;}
			
	
}
