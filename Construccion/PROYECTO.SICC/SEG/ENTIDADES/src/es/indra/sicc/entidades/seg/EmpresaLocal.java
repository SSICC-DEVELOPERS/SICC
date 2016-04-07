package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_SOCIE")
@NamedQueries({
@NamedQuery(name="EmpresaLocal.FindAll",query="select object(o) from EmpresaLocal o"),
@NamedQuery(name="EmpresaLocal.FindByUK",query="SELECT OBJECT(e) "
+ " FROM EmpresaLocal AS e"
+ " WHERE e.codigo=?1"),
@NamedQuery(name="EmpresaLocal.FindByPaisYCodigo",query="SELECT OBJECT(o) "
+ " FROM EmpresaLocal AS o"
+ " WHERE o.pais = ?1"
+ " AND o.codigo = ?2")
})
public class EmpresaLocal implements Serializable {

	public EmpresaLocal() {}

	public EmpresaLocal(Long oid, String codigo, String identificacionFiscal, Long pais, String denominacion)	{
		this.oid=oid;
		this.codigo = codigo;
		this.identificacionFiscal = identificacionFiscal;
		this.pais = pais;
		this.denominacion = denominacion;
	}

	@Id
	@Column(name="OID_SOCI")
	private Long oid;
	@Column(name="COD_SOCI")
	private String codigo;
	@Column(name="VAL_DIRE")
	private String direccion;
	@Column(name="VAL_TLFN")
	private String telefono;
	@Column(name="VAL_FAX")
	private String fax;
	@Column(name="VAL_IDEN_FISC")
	private String identificacionFiscal;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="VAL_DENO")
	private String denominacion;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDireccion() {return direccion;}
      
	public void setDireccion(String direccion){this.direccion=direccion;}
		
	public String getTelefono() {return telefono;}
      
	public void setTelefono(String telefono){this.telefono=telefono;}
		
	public String getFax() {return fax;}
      
	public void setFax(String fax){this.fax=fax;}
		
	public String getIdentificacionFiscal() {return identificacionFiscal;}
      
	public void setIdentificacionFiscal(String identificacionFiscal){this.identificacionFiscal=identificacionFiscal;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getDenominacion() {return denominacion;}
      
	public void setDenominacion(String denominacion){this.denominacion=denominacion;}
			
	
}
