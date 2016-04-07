package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_PARAM")
public class ParametrosLocal implements Serializable {

	public ParametrosLocal() {}

	public ParametrosLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_PARA")
	private Long oid;
	@Column(name="VAL_NOMB_PARA")
	private String nombre;
	@Column(name="VAL_TIPO_PARA")
	private Long tipo;
	@Column(name="VAL_NOMB_TABL")
	private String nombreTabla;
	@Column(name="VAL_TIPO_DATO")
	private String tipoDato;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getNombre() {return nombre;}
      
	public void setNombre(String nombre){this.nombre=nombre;}
		
	public Long getTipo() {return tipo;}
      
	public void setTipo(Long tipo){this.tipo=tipo;}
		
	public String getNombreTabla() {return nombreTabla;}
      
	public void setNombreTabla(String nombreTabla){this.nombreTabla=nombreTabla;}
		
	public String getTipoDato() {return tipoDato;}
      
	public void setTipoDato(String tipoDato){this.tipoDato=tipoDato;}
			
	
}
