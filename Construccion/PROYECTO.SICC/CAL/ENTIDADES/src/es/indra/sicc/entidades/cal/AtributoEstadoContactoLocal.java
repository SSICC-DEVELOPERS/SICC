package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_ATRIB_ESTAD_CONTA")
@NamedQueries({
@NamedQuery(name="AtributoEstadoContactoLocal.FindByUK",query="SELECT OBJECT(a) "
 + "FROM AtributoEstadoContactoLocal AS a " +
 "WHERE a.tipoEstadoContacto =?1 " +
 "AND a.codAtributo =?2 "),
 @NamedQuery(name="AtributoEstadoContactoLocal.FindAll",query=" SELECT OBJECT(a) FROM AtributoEstadoContactoLocal AS a ")
})
public class AtributoEstadoContactoLocal implements Serializable {

	public AtributoEstadoContactoLocal() {}

	public AtributoEstadoContactoLocal(Long oid, String cod_atri, Long teco_oid)	{
	
		this.oid=oid;
                setCodAtributo(cod_atri);
	        setTipoEstadoContacto(teco_oid);
	
	}

	@Id
	@Column(name="OID_ATRI_ESTA_CONT")
	private Long oid;
	@Column(name="COD_ATRI")
	private String codAtributo;
	@Column(name="TECO_OID_TIPO_ESTA_CONT")
	private Long tipoEstadoContacto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodAtributo() {return codAtributo;}
      
	public void setCodAtributo(String codAtributo){this.codAtributo=codAtributo;}
		
	public Long getTipoEstadoContacto() {return tipoEstadoContacto;}
      
	public void setTipoEstadoContacto(Long tipoEstadoContacto){this.tipoEstadoContacto=tipoEstadoContacto;}
			
	
}
