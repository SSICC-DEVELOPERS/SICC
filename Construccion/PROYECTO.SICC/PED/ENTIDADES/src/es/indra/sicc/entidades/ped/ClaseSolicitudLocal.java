package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_CLASE_SOLIC")
@NamedQueries({
@NamedQuery(name="ClaseSolicitudLocal.FindByUK",query="SELECT OBJECT(o) "
+ " FROM ClaseSolicitudLocal AS o "
+ " WHERE o.claseSolicitud = ?1"),
@NamedQuery(name="ClaseSolicitudLocal.FindByIndOrdenCompra",query="SELECT OBJECT(o) "
+ " FROM ClaseSolicitudLocal AS o "
+ " WHERE o.indOrdenCompra = ?1"),
@NamedQuery(name="ClaseSolicitudLocal.FindAll",query="SELECT OBJECT(o) "
+ " FROM ClaseSolicitudLocal AS o")
})
public class ClaseSolicitudLocal implements Serializable {

    public ClaseSolicitudLocal() {}

    public ClaseSolicitudLocal(Long oid, String cod_clas_soli, Boolean ind_orde_comp)	{
        this.oid=oid;
        this.claseSolicitud = cod_clas_soli;
        this.indOrdenCompra = ind_orde_comp;
    }

    @Id
    @Column(name="OID_CLAS_SOLI")
    private Long oid;
    @Column(name="COD_CLAS_SOLI")
    private String claseSolicitud;
    @Column(name="IND_ORDE_COMP")
    private Boolean indOrdenCompra;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getClaseSolicitud() {return claseSolicitud;}
  
    public void setClaseSolicitud(String claseSolicitud){this.claseSolicitud=claseSolicitud;}
            
    public Boolean getIndOrdenCompra() {return indOrdenCompra;}
  
    public void setIndOrdenCompra(Boolean indOrdenCompra){this.indOrdenCompra=indOrdenCompra;}
                    
}
