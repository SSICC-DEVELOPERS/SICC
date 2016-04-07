package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_UNIDA_MEDID")
@NamedQueries({
@NamedQuery(name="UnidadesMedidaLocal.FindAll",query="select object(o) from UnidadesMedidaLocal o"),
@NamedQuery(name="UnidadesMedidaLocal.FindByUk",query="SELECT OBJECT(u) "
+ " FROM UnidadesMedidaLocal AS u "
+ " WHERE u.oidPais=?1 "
+ "AND u.codigoUnidadMedida = ?2")
})
public class UnidadesMedidaLocal implements Serializable {

	public UnidadesMedidaLocal() {}

	public UnidadesMedidaLocal(Long oid, Long paisOidPais, String codUnidMedi, Long magnOidMagn, Boolean indUmStnd) {
            this.oid=oid;
            this.oidPais = paisOidPais;
            this.codigoUnidadMedida = codUnidMedi;
            this.oidMagnitud = magnOidMagn;
            this.esEstandar = indUmStnd;
	}

	@Id
	@Column(name="OID_UNID_MEDI")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_UNID_MEDI")
	private String codigoUnidadMedida;
	@Column(name="MAGN_OID_MAGN")
	private Long oidMagnitud;
	@Column(name="DES_ABRE")
	private String descAbreviada;
	@Column(name="IND_UM_STND")
	private Boolean esEstandar;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoUnidadMedida() {return codigoUnidadMedida;}
      
	public void setCodigoUnidadMedida(String codigoUnidadMedida){this.codigoUnidadMedida=codigoUnidadMedida;}
		
	public Long getOidMagnitud() {return oidMagnitud;}
      
	public void setOidMagnitud(Long oidMagnitud){this.oidMagnitud=oidMagnitud;}
		
	public String getDescAbreviada() {return descAbreviada;}
      
	public void setDescAbreviada(String descAbreviada){this.descAbreviada=descAbreviada;}
		
	public Boolean getEsEstandar() {return esEstandar;}
      
	public void setEsEstandar(Boolean esEstandar){this.esEstandar=esEstandar;}
}
