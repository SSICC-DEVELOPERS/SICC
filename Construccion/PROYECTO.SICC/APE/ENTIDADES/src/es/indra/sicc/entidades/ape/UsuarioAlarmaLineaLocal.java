package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_USUAR_ALARM_LINEA")
@NamedQueries({
@NamedQuery(name="UsuarioAlarmaLineaLocal.FindAll",query="select object(o) from UsuarioAlarmaLineaLocal o"),
@NamedQuery(name="UsuarioAlarmaLineaLocal.FindByLineaArmado",query="SELECT OBJECT(o) "
+ " FROM UsuarioAlarmaLineaLocal o "
+ " WHERE o.liarOidLineArma = ?1")
})
public class UsuarioAlarmaLineaLocal implements Serializable {

    public UsuarioAlarmaLineaLocal() {}
    
    public UsuarioAlarmaLineaLocal(Long oid, String valMail, Long liarOidLineArma)	{
        this.oid=oid;
        setValMail(valMail);
        setLiarOidLineArma(liarOidLineArma);
    }
    
    @Id
    @Column(name="OID_USUA_ALAR_LINE")
    private Long oid;
    @Column(name="VAL_MAIL")
    private String valMail;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long liarOidLineArma;
    
    
    public Long getOid() {return oid;}
    
    public String getValMail() {return valMail;}
    
    public void setValMail(String valMail){this.valMail=valMail;}
        
    public Long getLiarOidLineArma() {return liarOidLineArma;}
    
    public void setLiarOidLineArma(Long liarOidLineArma){this.liarOidLineArma=liarOidLineArma;}
                
	
}
