package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_TIPO_CLASI_CLIEN")
@NamedQueries({
@NamedQuery(name="TipoClasificacionLocal.FindByUK",query="select object(tc) from TipoClasificacionLocal tc "
+ " where tc.cod_tipo_clas = ?1 and tc.sbti_oid_subt_clie = ?2"),
@NamedQuery(name="TipoClasificacionLocal.FindAll",query="select object(tc) from TipoClasificacionLocal tc ")
})
public class TipoClasificacionLocal implements Serializable {

	public TipoClasificacionLocal() {}

	public TipoClasificacionLocal(Long oid, Long sbti_oid_subt_clie, String cod_tipo_clas)	{
            this.oid=oid;
            this.sbti_oid_subt_clie = sbti_oid_subt_clie;
            this.cod_tipo_clas = cod_tipo_clas;
	}

	@Id
	@Column(name="OID_TIPO_CLAS")
	private Long oid;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long sbti_oid_subt_clie;
	@Column(name="COD_TIPO_CLAS")
	private String cod_tipo_clas;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSbti_oid_subt_clie() {return sbti_oid_subt_clie;}
      
	public void setSbti_oid_subt_clie(Long sbti_oid_subt_clie){this.sbti_oid_subt_clie=sbti_oid_subt_clie;}
		
	public String getCod_tipo_clas() {return cod_tipo_clas;}
      
	public void setCod_tipo_clas(String cod_tipo_clas){this.cod_tipo_clas=cod_tipo_clas;}
			
	
}
