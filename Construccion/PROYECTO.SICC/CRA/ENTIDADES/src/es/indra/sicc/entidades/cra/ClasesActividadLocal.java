package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_CLASE_ACTIV")
public class ClasesActividadLocal implements Serializable {

	public ClasesActividadLocal() {}

	public ClasesActividadLocal(Long oid, String cod_clas_acti, String des_clas_acti)	{
	
		this.oid=oid;
                this.codigo = cod_clas_acti;
                this.descripcion = des_clas_acti;
	}

	@Id
	@Column(name="OID_CLAS_ACTI")
	private Long oid;
	@Column(name="COD_CLAS_ACTI")
	private String codigo;
	@Column(name="DES_CLAS_ACTI")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
