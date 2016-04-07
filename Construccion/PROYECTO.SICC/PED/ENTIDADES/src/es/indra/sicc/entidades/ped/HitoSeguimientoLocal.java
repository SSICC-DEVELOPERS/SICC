package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_HITO_SEGUI")
@NamedQueries({
@NamedQuery(name="HitoSeguimientoLocal.FindByUK",query="select Object(a) from HitoSeguimientoLocal a "
+ " where a.cod = ?1"),
@NamedQuery(name="HitoSeguimientoLocal.FindAll", query="SELECT OBJECT(o) FROM HitoSeguimientoLocal AS o")
})
public class HitoSeguimientoLocal implements Serializable {

    public HitoSeguimientoLocal() {}

    public HitoSeguimientoLocal(Long oid, String cod_hito) {
        this.oid=oid;
        this.cod = cod_hito;
    }

    @Id
    @Column(name="OID_HITO")
    private Long oid;
    @Column(name="COD_HITO")
    private String cod;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCod() {return cod;}
  
    public void setCod(String cod){this.cod=cod;}
	
}
