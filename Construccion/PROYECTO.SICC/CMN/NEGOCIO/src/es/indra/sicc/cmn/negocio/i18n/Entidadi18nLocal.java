package es.indra.sicc.cmn.negocio.i18n;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="GEN_I18N_SICC")
@NamedQueries({
@NamedQuery(name="Entidadi18nLocal.FindByEntAtrIdioValor",query="SELECT OBJECT(o)"
+ "  FROM Entidadi18nLocal o"
+ " WHERE o.entidad = ?1"
+ "   AND o.atributo = ?2"
+ "   AND o.idioma = ?3"
+ "   AND o.detalle = ?4"),
@NamedQuery(name="Entidadi18nLocal.FindAll", query="SELECT OBJECT(o)"
+ " FROM Entidadi18nLocal o"),
@NamedQuery(name="Entidadi18nLocal.FindByEntAtrIdioPK", query="SELECT OBJECT(o)"
+ "  FROM Entidadi18nLocal o"
+ " WHERE o.entidad = ?1"
+ "   AND o.atributo = ?2"
+ "   AND o.idioma = ?3"
+ "   AND o.entidad_pk = ?4"),
@NamedQuery(name="Entidadi18nLocal.FindByEntAtrPK", query="SELECT OBJECT(o)"
+ "  FROM Entidadi18nLocal o"
+ " WHERE o.entidad = ?1"
+ "   AND o.atributo = ?2"
+ "   AND o.entidad_pk = ?3"),
@NamedQuery(name="Entidadi18nLocal.FindByEntPK", query="SELECT OBJECT(o)"
+ "  FROM Entidadi18nLocal o"
+ " WHERE o.entidad = ?1"
+ "   AND o.entidad_pk = ?2")
})
public class Entidadi18nLocal implements Serializable {

        public Entidadi18nLocal() { }

	public Entidadi18nLocal(Long oid, String entidad, Long atributo, Long idioma, String detalle, Long entidad_pk)	{
		this.oid = oid;
		this.entidad = entidad;
		this.atributo = atributo;
		this.idioma = idioma;
		this.detalle = detalle;
		this.entidad_pk = entidad_pk;
	}

	@Id
	@Column(name="OID_I18N")
	private Long oid;
	@Column(name="ATTR_ENTI")
	private String entidad;
	@Column(name="ATTR_NUM_ATRI")
	private Long atributo;
	@Column(name="IDIO_OID_IDIO")
	private Long idioma;
	@Column(name="VAL_I18N")
	private String detalle;
	@Column(name="VAL_OID")
	private Long entidad_pk;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getEntidad() {return entidad;}
      
	public void setEntidad(String entidad){this.entidad=entidad;}
		
	public Long getAtributo() {return atributo;}
      
	public void setAtributo(Long atributo){this.atributo=atributo;}
		
	public Long getIdioma() {return idioma;}
      
	public void setIdioma(Long idioma){this.idioma=idioma;}
		
	public String getDetalle() {return detalle;}
      
	public void setDetalle(String detalle){this.detalle=detalle;}
		
	public Long getEntidad_pk() {return entidad_pk;}
      
	public void setEntidad_pk(Long entidad_pk){this.entidad_pk=entidad_pk;}
			
	
}
