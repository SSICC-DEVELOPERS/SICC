package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ESTAD_PEDID")
@NamedQueries({
@NamedQuery(name="EstadoPedidoLocal.FindAll",query="select object(o) from EstadoPedidoLocal o")
})
public class EstadoPedidoLocal implements Serializable {

    public EstadoPedidoLocal() {}

    public EstadoPedidoLocal(Long oid, Long numOrde, String valEstaCaja)	{
        this.oid=oid;
        setNumOrde(numOrde);
        setValEstaCaja(valEstaCaja);
    }

    @Id
    @Column(name="OID_ESTA_PEDI")
    private Long oid;
    @Column(name="NUM_ORDE")
    private Long numOrde;
    @Column(name="VAL_ESTA_CAJA")
    private String valEstaCaja;

    
    public Long getOid() {return oid;}
    
    public Long getNumOrde() {return numOrde;}
  
    public void setNumOrde(Long numOrde){this.numOrde=numOrde;}
            
    public String getValEstaCaja() {return valEstaCaja;}
  
    public void setValEstaCaja(String valEstaCaja){this.valEstaCaja=valEstaCaja;}
                    
}
