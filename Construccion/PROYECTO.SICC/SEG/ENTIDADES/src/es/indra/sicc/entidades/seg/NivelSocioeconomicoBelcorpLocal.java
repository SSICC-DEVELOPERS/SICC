package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_NIVEL_SOCIO_ECONO_BELCO")
@NamedQueries({
@NamedQuery(name="NivelSocioeconomicoBelcorpLocal.FindByUK", query="SELECT OBJECT(o) "
+ "  FROM NivelSocioeconomicoBelcorpLocal AS o"
+ " WHERE o.codigoNSEBelcorp = ?1"),
@NamedQuery(name="NivelSocioeconomicoBelcorpLocal.FindAll", query="SELECT OBJECT(o) "
+ " FROM NivelSocioeconomicoBelcorpLocal AS o")
})
public class NivelSocioeconomicoBelcorpLocal implements Serializable {

	public NivelSocioeconomicoBelcorpLocal() {}

	public NivelSocioeconomicoBelcorpLocal(Long oid, String cod_nive_soci_econ_belc, String des_nive_soci_econ_belc)	{
		this.oid=oid;
		this.codigoNSEBelcorp = cod_nive_soci_econ_belc;
		this.descripcion = des_nive_soci_econ_belc;
	}

	@Id
	@Column(name="OID_NIVE_SOEC_BELC")
	private Long oid;
	@Column(name="COD_NIVE_SOCI_ECON_BELC")
	private String codigoNSEBelcorp;
	@Column(name="DES_NIVE_SOCI_ECON_BELC")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoNSEBelcorp() {return codigoNSEBelcorp;}
      
	public void setCodigoNSEBelcorp(String codigoNSEBelcorp){this.codigoNSEBelcorp=codigoNSEBelcorp;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
