package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_LISTA_CLIEN")
public class ListaClientesLocal implements Serializable {

	public ListaClientesLocal() {}

	public ListaClientesLocal(Long oid, Long oidPais) {
		this.oid=oid;
                this.oidPais = oidPais;
	}

	@Id
	@Column(name="OID_LIST_CLIE")
	private Long oid;
	@Column(name="NUM_CLIE")
	private Long numeroClientes;
        @Column(name="PAIS_OID_PAIS")
        private Long oidPais;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroClientes() {return numeroClientes;}
      
	public void setNumeroClientes(Long numeroClientes){this.numeroClientes=numeroClientes;}
			
        public Long getOidPais() {return oidPais;}
        
        public void setOidPais(Long oidPais){this.oidPais=oidPais;}
                        
	
}
