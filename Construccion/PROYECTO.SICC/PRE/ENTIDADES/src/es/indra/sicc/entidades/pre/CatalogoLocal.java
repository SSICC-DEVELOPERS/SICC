package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CATAL")
@NamedQueries({
@NamedQuery(name="CatalogoLocal.FindByUK",query="SELECT OBJECT(c) "
+ "FROM CatalogoLocal AS c WHERE c.oidPais = ?1 AND c.codigoCatalogo = ?2")
})
public class CatalogoLocal implements Serializable {

	public CatalogoLocal() {}

	public CatalogoLocal(Long oid, Integer cod_cata, String des_cata, Long oidPais)	{
	
		this.oid=oid;
                this.codigoCatalogo=cod_cata;
                this.descripcion=des_cata;
                this.oidPais=oidPais;
	
	}

	@Id
	@Column(name="OID_CATA")
	private Long oid;
	@Column(name="COD_CATA")
	private Integer codigoCatalogo;
	@Column(name="DES_CATA")
	private String descripcion;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigoCatalogo() {return codigoCatalogo;}
      
	public void setCodigoCatalogo(Integer codigoCatalogo){this.codigoCatalogo=codigoCatalogo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
