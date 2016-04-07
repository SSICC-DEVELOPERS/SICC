package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_REGIS_SOLIC")
@NamedQueries({
@NamedQuery(name="RegistroSolicitudLocal.FindAll",query="SELECT OBJECT(p) from RegistroSolicitudLocal p")
})
public class RegistroSolicitudLocal implements Serializable {

    public RegistroSolicitudLocal() {}

    public RegistroSolicitudLocal(Long oid, Long clie_oid_clie, Long lote_oid_lote, Long zzon_oid_zona) {
        this.oid=oid;
        this.cliente = clie_oid_clie;
        this.lote = lote_oid_lote;
        this.zona = zzon_oid_zona;
    }

    @Id
    @Column(name="OID_REGI_SOLI")
    private Long oid;
    @Column(name="NUM_REGI")
    private Long numRegistradas;
    @Column(name="NUM_DIGI")
    private Long numDigitadas;
    @Column(name="CLIE_OID_CLIE")
    private Long cliente;
    @Column(name="LOTE_OID_LOTE")
    private Long lote;
    @Column(name="ZZON_OID_ZONA")
    private Long zona;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getNumRegistradas() {return numRegistradas;}
  
    public void setNumRegistradas(Long numRegistradas){this.numRegistradas=numRegistradas;}
            
    public Long getNumDigitadas() {return numDigitadas;}
  
    public void setNumDigitadas(Long numDigitadas){this.numDigitadas=numDigitadas;}
            
    public Long getCliente() {return cliente;}
  
    public void setCliente(Long cliente){this.cliente=cliente;}
            
    public Long getLote() {return lote;}
  
    public void setLote(Long lote){this.lote=lote;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
	
}
