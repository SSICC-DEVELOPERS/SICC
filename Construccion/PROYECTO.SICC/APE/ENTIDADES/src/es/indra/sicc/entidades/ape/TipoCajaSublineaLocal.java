package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_TIPO_CAJA_SUBLI")
@NamedQueries({
@NamedQuery(name="TipoCajaSublineaLocal.FindAll",query="select object(o) from TipoCajaSublineaLocal o")
})
public class TipoCajaSublineaLocal implements Serializable {

    public TipoCajaSublineaLocal() {}

    public TipoCajaSublineaLocal(Long oid, Long numCaja, Long oidSublineaArmado, Long oidTipoCajaProducto) {
        this.oid=oid;
        setNumCaja(numCaja);
        setOidSublineaArmado(oidSublineaArmado);
        setOidTipoCajaProducto(oidTipoCajaProducto);
    }

    @Id
    @Column(name="OID_TIPO_CAJA_SUBL")
    private Long oid;
    @Column(name="NUM_CAJA")
    private Long numCaja;
    @Column(name="SBAR_OID_SUBL_ARMA")
    private Long oidSublineaArmado;
    @Column(name="TICP_OID_TIPO_CAJA_PROD")
    private Long oidTipoCajaProducto;

    
    public Long getOid() {return oid;}
    
    public Long getNumCaja() {return numCaja;}
  
    public void setNumCaja(Long numCaja){this.numCaja=numCaja;}
            
    public Long getOidSublineaArmado() {return oidSublineaArmado;}
  
    public void setOidSublineaArmado(Long oidSublineaArmado){this.oidSublineaArmado=oidSublineaArmado;}
            
    public Long getOidTipoCajaProducto() {return oidTipoCajaProducto;}
  
    public void setOidTipoCajaProducto(Long oidTipoCajaProducto){this.oidTipoCajaProducto=oidTipoCajaProducto;}
                    
	
}
