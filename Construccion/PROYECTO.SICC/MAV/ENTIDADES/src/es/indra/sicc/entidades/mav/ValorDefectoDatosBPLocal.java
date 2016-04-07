package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_PARAM_DEFEC_BPLAN")
@NamedQueries({
@NamedQuery(name="ValorDefectoDatosBPLocal.FindAll",query="select object(o) from ValorDefectoDatosBPLocal o"),
@NamedQuery(name="ValorDefectoDatosBPLocal.FindByUK",query="SELECT OBJECT(o) " +
" FROM ValorDefectoDatosBPLocal o "+
" WHERE o.oidActividad = ?1 "+
" AND o.codigo = ?2")
})
public class ValorDefectoDatosBPLocal implements Serializable {

	public ValorDefectoDatosBPLocal() {}

	public ValorDefectoDatosBPLocal(Long oidValorDefecto, Long oidActividad, String codigo, Long oidPais)	{
	
		this.oidValorDefecto=oidValorDefecto;
                this.oidActividad=oidActividad;
                this.oidPais=oidPais;
                this.codigo=codigo;                
	
	}

	@Id
	@Column(name="OID_PARA_DEFE")
	private Long oidValorDefecto;
	@Column(name="COD_PARA_DEFE")
	private String codigo;
	@Column(name="VAL_DEFE")
	private String valorDefecto;
	@Column(name="VAL_NOMB_ENTI")
	private String nomEnti;
	@Column(name="VAL_CAMP_CLAV_NOMB_ENTI")
	private String nomEntiOid;
	@Column(name="VAL_CAMP_NOMB_ENTI")
	private String nomEntiCamp;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;

	
	public Long getOidValorDefecto() {return oidValorDefecto;}
      
	//public void setOidValorDefecto(Long oidValorDefecto){this.oidValorDefecto=oidValorDefecto;}
	
	public Long getPrimaryKey() {return oidValorDefecto;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getValorDefecto() {return valorDefecto;}
      
	public void setValorDefecto(String valorDefecto){this.valorDefecto=valorDefecto;}
		
	public String getNomEnti() {return nomEnti;}
      
	public void setNomEnti(String nomEnti){this.nomEnti=nomEnti;}
		
	public String getNomEntiOid() {return nomEntiOid;}
      
	public void setNomEntiOid(String nomEntiOid){this.nomEntiOid=nomEntiOid;}
		
	public String getNomEntiCamp() {return nomEntiCamp;}
      
	public void setNomEntiCamp(String nomEntiCamp){this.nomEntiCamp=nomEntiCamp;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
			
	
}
