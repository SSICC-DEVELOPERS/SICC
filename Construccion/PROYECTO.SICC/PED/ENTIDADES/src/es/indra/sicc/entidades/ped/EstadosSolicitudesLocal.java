package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_ESTAD_SOLIC")
@NamedQueries({
@NamedQuery(name="EstadosSolicitudesLocal.FindAll", query="SELECT OBJECT(o) FROM EstadosSolicitudesLocal AS o")
})
public class EstadosSolicitudesLocal implements Serializable {

    public EstadosSolicitudesLocal() {}

    public EstadosSolicitudesLocal(Long oid, String cod_esta_soli) {
        this.oid=oid;
        this.codigo = cod_esta_soli;
    }

    @Id
    @Column(name="OID_ESTA_SOLI")
    private Long oid;
    @Column(name="COD_ESTA_SOLI")
    private String codigo;

    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
}
