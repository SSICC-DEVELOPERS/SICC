package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_CUENT_CORRI_BANCA")
@NamedQueries({
@NamedQuery(name="CuentasCorrientesLocal.FindByUK",query="SELECT OBJECT(o) FROM CuentasCorrientesLocal AS o WHERE o.codigo = ?1 AND o.pais = ?2")
})
public class CuentasCorrientesLocal implements Serializable {

	public CuentasCorrientesLocal() {}

	public CuentasCorrientesLocal(Long oid, Long sociedad, Long sucursal, Long cuentaPuente,
                                        Long cuentaTesoreria, String codigo, String codigoCuenta, 
                                        String descripicion, Long pais)	{
	
		this.oid=oid;
                this.sociedad=sociedad;
                this.sucursal=sucursal;
                this.cuentaPuente=cuentaPuente;
                this.cuentaTesoreria=cuentaTesoreria;
                this.codigo=codigo;
                this.codigoCuenta=codigoCuenta;
                this.descripcion=descripicion;
                this.pais=pais;                
	
	}

        public CuentasCorrientesLocal(Long oid, Long sociedad, Long sucursal, Long cuentaPuente, 
                                    Long cuentaTesoreria, String codigo, String codigoCuenta,
                                    String descripcion, String numeroSwift, String direccion, 
                                    String contacto, String telefono, String observaciones, Long pais) {
        
                this.oid=oid;
                this.sociedad=sociedad;
                this.sucursal=sucursal;
                this.cuentaPuente=cuentaPuente;
                this.cuentaTesoreria=cuentaTesoreria;
                this.codigo=codigo;
                this.codigoCuenta=codigoCuenta;                
                this.pais=pais;   
                this.descripcion=descripcion;
                this.numeroSwift=numeroSwift;
                this.direccion=direccion;
                this.contacto=contacto;
                this.telefono=telefono;
                this.observaciones=observaciones;
            
        
        }
        
	@Id
	@Column(name="OID_CUEN_CORR_BANC")
	private Long oid;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;
	@Column(name="SUCU_OID_SUCU")
	private Long sucursal;
	@Column(name="CUCO_OID_CC_PNTE")
	private Long cuentaPuente;
	@Column(name="CUCO_OID_CC_TESO")
	private Long cuentaTesoreria;
	@Column(name="COD_CC")
	private String codigo;
	@Column(name="COD_CC_BANC")
	private String codigoCuenta;
	@Column(name="DES_CC")
	private String descripcion;
	@Column(name="VAL_NUME_SWIF")
	private String numeroSwift;
	@Column(name="VAL_DIRE")
	private String direccion;
	@Column(name="VAL_CONT")
	private String contacto;
	@Column(name="VAL_TELE")
	private String telefono;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
		
	public Long getSucursal() {return sucursal;}
      
	public void setSucursal(Long sucursal){this.sucursal=sucursal;}
		
	public Long getCuentaPuente() {return cuentaPuente;}
      
	public void setCuentaPuente(Long cuentaPuente){this.cuentaPuente=cuentaPuente;}
		
	public Long getCuentaTesoreria() {return cuentaTesoreria;}
      
	public void setCuentaTesoreria(Long cuentaTesoreria){this.cuentaTesoreria=cuentaTesoreria;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getCodigoCuenta() {return codigoCuenta;}
      
	public void setCodigoCuenta(String codigoCuenta){this.codigoCuenta=codigoCuenta;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getNumeroSwift() {return numeroSwift;}
      
	public void setNumeroSwift(String numeroSwift){this.numeroSwift=numeroSwift;}
		
	public String getDireccion() {return direccion;}
      
	public void setDireccion(String direccion){this.direccion=direccion;}
		
	public String getContacto() {return contacto;}
      
	public void setContacto(String contacto){this.contacto=contacto;}
		
	public String getTelefono() {return telefono;}
      
	public void setTelefono(String telefono){this.telefono=telefono;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
