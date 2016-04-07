package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_VARIA")
@NamedQueries({
@NamedQuery(name="VariantesLocal.FindAll",query="select object(o) from VariantesLocal o"),
@NamedQuery(name="VariantesLocal.FindByUK",query="SELECT OBJECT(o) "
+"FROM VariantesLocal AS o WHERE o.codigoVariante = ?1")
})
public class VariantesLocal implements Serializable {

	public VariantesLocal() {}

	public VariantesLocal(Long oid, String newCodigoVariante, 
                String newDescripcionVariante, Long newPais, Long newProgramaFidelizacion) {
	
		this.oid=oid;
                this.codigoVariante=newCodigoVariante;
                this.descripcionVariante=newDescripcionVariante;
                this.pais=newPais;
                this.programaFidelizacion=newProgramaFidelizacion;
	
	}

	@Id
	@Column(name="OID_VARI")
	private Long oid;
	@Column(name="COD_VARI")
	private String codigoVariante;
	@Column(name="DES_VARI")
	private String descripcionVariante;
	@Column(name="IND_PUNT")
	private String indicadorPuntaje;
	@Column(name="PRFI_OID_PROG_FIDE")
	private Long programaFidelizacion;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoVariante() {return codigoVariante;}
      
	public void setCodigoVariante(String codigoVariante){this.codigoVariante=codigoVariante;}
		
	public String getDescripcionVariante() {return descripcionVariante;}
      
	public void setDescripcionVariante(String descripcionVariante){this.descripcionVariante=descripcionVariante;}
		
	public String getIndicadorPuntaje() {return indicadorPuntaje;}
      
	public void setIndicadorPuntaje(String indicadorPuntaje){this.indicadorPuntaje=indicadorPuntaje;}
		
	public Long getProgramaFidelizacion() {return programaFidelizacion;}
      
	public void setProgramaFidelizacion(Long programaFidelizacion){this.programaFidelizacion=programaFidelizacion;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
