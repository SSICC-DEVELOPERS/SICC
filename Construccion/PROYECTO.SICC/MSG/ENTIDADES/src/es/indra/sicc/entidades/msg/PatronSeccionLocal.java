package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_PATRO_SECCI")
@NamedQueries({
@NamedQuery(name="PatronSeccionLocal.FindByPatron",query="SELECT OBJECT(i) FROM PatronSeccionLocal AS i WHERE i.oidPatronCabecera = ?1"),
@NamedQuery(name="PatronSeccionLocal.FindByOrdenSeccion",query="SELECT OBJECT(i) FROM PatronSeccionLocal AS i WHERE i.oidPatronCabecera = ?1 AND i.ordenSeccion = ?2")
})
public class PatronSeccionLocal implements Serializable {

	public PatronSeccionLocal() {}

	public PatronSeccionLocal(Long oid, String cod_secc, Long patr_oid_patr, Integer num_orde_secc)	{
	
            this.oid=oid;
	    this.codigoSeccion=cod_secc;
            this.oidPatronCabecera=patr_oid_patr;
            this.ordenSeccion=num_orde_secc;
            	
	}

	@Id
	@Column(name="OID_PATR_SECC")
	private Long oid;
	@Column(name="COD_SECC")
	private String codigoSeccion;
	@Column(name="PATR_OID_PATR")
	private Long oidPatronCabecera;
	@Column(name="NUM_ORDE_SECC")
	private Integer ordenSeccion;
	@Column(name="METC_OID_META")
	private Long oidMetacaracter;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoSeccion() {return codigoSeccion;}
      
	public void setCodigoSeccion(String codigoSeccion){this.codigoSeccion=codigoSeccion;}
		
	public Long getOidPatronCabecera() {return oidPatronCabecera;}
      
	public void setOidPatronCabecera(Long oidPatronCabecera){this.oidPatronCabecera=oidPatronCabecera;}
		
	public Integer getOrdenSeccion() {return ordenSeccion;}
      
	public void setOrdenSeccion(Integer ordenSeccion){this.ordenSeccion=ordenSeccion;}
		
	public Long getOidMetacaracter() {return oidMetacaracter;}
      
	public void setOidMetacaracter(Long oidMetacaracter){this.oidMetacaracter=oidMetacaracter;}
			
	
}
