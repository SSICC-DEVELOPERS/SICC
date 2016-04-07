package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_VINCU_JERAR")
@NamedQueries({
@NamedQuery(name="VinculoJerarquiaLocal.FindAll", query="SELECT OBJECT(o) FROM VinculoJerarquiaLocal AS o")
})
public class VinculoJerarquiaLocal implements Serializable {

	public VinculoJerarquiaLocal() {}

	public VinculoJerarquiaLocal(Long oid, Long pais, Long marca, Long canal, Long acceso, Long subacceso, Long empresa)	{
		this.oid = oid;
		this.pais = pais;
		this.marca = marca;
		this.canal = canal;
		this.acceso = acceso;
		this.subacceso = subacceso;
		this.empresa = empresa;
	}

	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ACCE_OID_ACCE")
	private Long acceso;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Id
	@Column(name="OID_VINC_JERA")
	private Long oid;

	
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
			
	
}
