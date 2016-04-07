package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_MARCA_SITUA")
public class MarcaSituacionLocal implements Serializable {

	public MarcaSituacionLocal() {}

	public MarcaSituacionLocal(Long oid, Long pais_oid_pais, String cod_marc_situ, Long ind_cuen_cast) {
	
                this.oid=oid;
                this.oidPais=pais_oid_pais;
                this.codigo=cod_marc_situ;
                this.cuentaCastigo=ind_cuen_cast;                
	
	}

	@Id
	@Column(name="OID_MARC_SITU")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_MARC_SITU")
	private String codigo;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_CUEN_CAST")
	private Long cuentaCastigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getCuentaCastigo() {return cuentaCastigo;}
      
	public void setCuentaCastigo(Long cuentaCastigo){this.cuentaCastigo=cuentaCastigo;}
			
	
}
