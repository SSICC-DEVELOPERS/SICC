package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_ESTAD_POSIC")
@NamedQueries({
@NamedQuery(name="EstadoPosicionLocal.FindAll", query="SELECT OBJECT(o) FROM EstadoPosicionLocal AS o")
})
public class EstadoPosicionLocal implements Serializable {

    public EstadoPosicionLocal() {}

    public EstadoPosicionLocal(Long oid, String cod_esta_posi)	{
        this.oid=oid;
        this.codigo = cod_esta_posi;
    }

    @Id
    @Column(name="OID_ESTA_POSI")
    private Long oid;
    @Column(name="COD_ESTA_POSI")
    private String codigo;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
	
}
