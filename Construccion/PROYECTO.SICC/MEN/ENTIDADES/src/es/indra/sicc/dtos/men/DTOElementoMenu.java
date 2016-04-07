package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DTOElementoMenu extends DTOAuditableSICC implements Comparable {
	private String nombre;
	private Long oid;
	private Set hijos;
	private Boolean funcionFinal;
        private String usuario;
        private String password;
        
        public String getUsuario() {
            return usuario;
        }
        
        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }
        
        public String getPassword() {
            return password;
        }
        
        public void setPassword(String password) {
            this.password = password;
        }

	public DTOElementoMenu(Long oid, String nombre, Boolean funcionFinal) {
		this.setOid(oid);
		this.setNombre(nombre);
		this.setFuncionFinal(funcionFinal);
		this.setHijos(new TreeSet());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String newNombre) {
		nombre = newNombre;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public DTOElementoMenu[] getHijos() {
		if (hijos.size() == 0) { 
			return new DTOElementoMenu[0]; 
		} else { 
			DTOElementoMenu[] salida = new DTOElementoMenu[hijos.size()];
			Iterator it = hijos.iterator();
			for (int i = 0 ; it.hasNext(); i++)	{
				salida[i] = (DTOElementoMenu)it.next();
			}
			return salida;
		}
	}

	public void setHijos(Set newHijos) {
		hijos = newHijos;
	}

	public Boolean getFuncionFinal() {
		return funcionFinal;
	}

	public void setFuncionFinal(Boolean newFuncionFinal) {
		funcionFinal = newFuncionFinal;
	}

	public int hashCode() {
		return oid.hashCode();
	}

	public boolean equals(Object obj) {
		if ((obj == null) || (obj instanceof DTOElementoMenu)) return false;

		DTOElementoMenu entrada = (DTOElementoMenu) obj; 
		return (this.oid.equals(entrada.oid));
	}

	public boolean addHijo(DTOElementoMenu hijo) {
		return hijos.add(hijo);		
	}

	public int compareTo(Object obj) {
	   //Comparamos dos elementos de menu en función del nombre  

	   if (nombre == null) return 1;
	   if (obj == null) return -1;
    
      // BELC300023375 - Se agrega el oid en el criterio de la comparacion
      //return (nombre.compareTo(((DTOElementoMenu)obj).getNombre()));
      String otroComparacion = ( (DTOElementoMenu)obj ).getNombre() + ( (DTOElementoMenu)obj ).getOid();
      String miComparacion =  this.getNombre() + this.getOid();
	   
      return miComparacion.compareTo( otroComparacion );
	}


}