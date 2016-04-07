package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_PATRO")
@NamedQueries({
@NamedQuery(name="PatronCabeceraLocal.FindByFormulario",query="SELECT OBJECT(a) FROM PatronCabeceraLocal AS a WHERE a.oidFormulario = ?1 ORDER BY a.codigoPatron" )
})
public class PatronCabeceraLocal implements Serializable {

	public PatronCabeceraLocal() {}

	public PatronCabeceraLocal(Long oid, String cod_patr, String des_patr, Long pais_oid_pais) {
            this.oid=oid;
	    this.codigoPatron = cod_patr;
	    this.descripcion = des_patr;
	    this.oidPais = pais_oid_pais;
	}

	@Id
	@Column(name="OID_PATR")
	private Long oid;
	@Column(name="COD_PATR")
	private String codigoPatron;
	@Column(name="IND_ACTI")
	private Boolean indActivo;
	@Column(name="MEEP_OID_MEDI_ENVI_PAIS")
	private Long oidMedioEnvioPais;
	@Column(name="FORS_OID_FORM")
	private Long oidFormulario;
	@Column(name="DES_PATR")
	private String descripcion;
	@Column(name="IND_PATR_PERI")
	private Boolean indPatronPeriodo;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoPatron() {return codigoPatron;}
      
	public void setCodigoPatron(String codigoPatron){this.codigoPatron=codigoPatron;}
		
	public Boolean getIndActivo() {return indActivo;}
      
	public void setIndActivo(Boolean indActivo){this.indActivo=indActivo;}
		
	public Long getOidMedioEnvioPais() {return oidMedioEnvioPais;}
      
	public void setOidMedioEnvioPais(Long oidMedioEnvioPais){this.oidMedioEnvioPais=oidMedioEnvioPais;}
		
	public Long getOidFormulario() {return oidFormulario;}
      
	public void setOidFormulario(Long oidFormulario){this.oidFormulario=oidFormulario;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getIndPatronPeriodo() {return indPatronPeriodo;}
      
	public void setIndPatronPeriodo(Boolean indPatronPeriodo){this.indPatronPeriodo=indPatronPeriodo;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
