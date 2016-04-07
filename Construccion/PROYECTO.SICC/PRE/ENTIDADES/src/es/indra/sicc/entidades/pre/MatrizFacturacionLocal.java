package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_FACTU")
@NamedQueries({
@NamedQuery(name="MatrizFacturacionLocal.FindByOidCabecera",query="SELECT OBJECT(a) "
+"FROM MatrizFacturacionLocal AS a WHERE a.oidCabe = ?1"),
@NamedQuery(name="MatrizFacturacionLocal.FindByOidDetaOfer",query="SELECT OBJECT(a) "
+"FROM MatrizFacturacionLocal AS a WHERE a.oidDetaOfer = ?1"),
@NamedQuery(name="MatrizFacturacionLocal.FindByUK",query="SELECT OBJECT(a) "
+"FROM MatrizFacturacionLocal AS a WHERE a.oidCabe = ?1 AND a.oidDetaOfer = ?2")
})
public class MatrizFacturacionLocal implements Serializable {

	public MatrizFacturacionLocal() {}

	public MatrizFacturacionLocal(Long oid, Long mfca_oid_cabe, Long ofde_oid_deta_ofer)	{
	
		this.oid=oid;
                this.oidCabe=mfca_oid_cabe;
                this.oidDetaOfer=ofde_oid_deta_ofer;
	
	}

	@Id
	@Column(name="OID_MATR_FACT")
	private Long oid;
	@Column(name="COD_ESTA")
	private Boolean estado;
	@Column(name="MFCA_OID_CABE")
	private Long oidCabe;
	@Column(name="OFDE_OID_DETA_OFER")
	private Long oidDetaOfer;
	@Column(name="NUM_PUNT_FIJO")
	private Integer puntajeFijo;
	@Column(name="VARI_OID_VARI")
	private Long variante;
	@Column(name="PRFI_OID_PROG_FIDE")
	private Long programaFidelizacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getEstado() {return estado;}
      
	public void setEstado(Boolean estado){this.estado=estado;}
		
	public Long getOidCabe() {return oidCabe;}
      
	public void setOidCabe(Long oidCabe){this.oidCabe=oidCabe;}
		
	public Long getOidDetaOfer() {return oidDetaOfer;}
      
	public void setOidDetaOfer(Long oidDetaOfer){this.oidDetaOfer=oidDetaOfer;}
		
	public Integer getPuntajeFijo() {return puntajeFijo;}
      
	public void setPuntajeFijo(Integer puntajeFijo){this.puntajeFijo=puntajeFijo;}
		
	public Long getVariante() {return variante;}
      
	public void setVariante(Long variante){this.variante=variante;}
		
	public Long getProgramaFidelizacion() {return programaFidelizacion;}
      
	public void setProgramaFidelizacion(Long programaFidelizacion){this.programaFidelizacion=programaFidelizacion;}
			
	
}
