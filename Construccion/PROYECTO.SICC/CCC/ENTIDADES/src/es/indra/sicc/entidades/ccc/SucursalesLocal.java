package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_SUCUR")
public class SucursalesLocal implements Serializable {

	public SucursalesLocal() {}

	public SucursalesLocal(Long oid, Long banco, String codigo, String direccion) {
	
		this.oid=oid;
                this.banco=banco;
                this.codigo=codigo;
                this.direccion=direccion;
	
	}

        public SucursalesLocal(Long oid, Long banco, String codigo, String direccion, 
                                    String contacto, String telefono, String observaciones, 
                                    String ciudad, String departamento, String distrito) {
        
                this.oid=oid;
                this.banco=banco;
                this.codigo=codigo;
                this.direccion=direccion;                
                this.contacto=contacto;
                this.telefono=telefono;
                this.observaciones=observaciones;
                this.ciudad=ciudad;
                this.departamento=departamento;
                this.distrito=distrito;
        
        }        

	@Id
	@Column(name="OID_SUCU")
	private Long oid;
	@Column(name="CBAN_OID_BANC")
	private Long banco;
	@Column(name="COD_SUCU")
	private String codigo;
	@Column(name="VAL_DIRE")
	private String direccion;
	@Column(name="VAL_CONT")
	private String contacto;
	@Column(name="VAL_TFNO")
	private String telefono;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="VAL_CIUD")
	private String ciudad;
	@Column(name="VAL_DEPA")
	private String departamento;
	@Column(name="VAL_DIST")
	private String distrito;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getBanco() {return banco;}
      
	public void setBanco(Long banco){this.banco=banco;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDireccion() {return direccion;}
      
	public void setDireccion(String direccion){this.direccion=direccion;}
		
	public String getContacto() {return contacto;}
      
	public void setContacto(String contacto){this.contacto=contacto;}
		
	public String getTelefono() {return telefono;}
      
	public void setTelefono(String telefono){this.telefono=telefono;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getCiudad() {return ciudad;}
      
	public void setCiudad(String ciudad){this.ciudad=ciudad;}
		
	public String getDepartamento() {return departamento;}
      
	public void setDepartamento(String departamento){this.departamento=departamento;}
		
	public String getDistrito() {return distrito;}
      
	public void setDistrito(String distrito){this.distrito=distrito;}
			
	
}
