package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_CONFI_TEXTO_VARIA")
@NamedQueries({
@NamedQuery(name="ConfiguracionTextoVariableLocal.FindAll",query="select object(o) from ConfiguracionTextoVariableLocal o")
})
public class ConfiguracionTextoVariableLocal implements Serializable {

    public ConfiguracionTextoVariableLocal() {}

    /**
     * CHANGELOG
     * ---------
     * dmorello, 08/01/2009 - Incidencia migracion APE-015
     *     Se reciben y setean los datos subtipo, tipo clasif. y clasif.
     */
    public ConfiguracionTextoVariableLocal(Long oid, String valTextVari,
            Long paisOidPais, Long ticlOidTipoClie, Long sbtiOidSubtClie, 
            Long tcclOidTipoClas, Long clasOidClas) {

        this.oid = oid;
        setTextoVariable(valTextVari);
        setOidPais(paisOidPais);
        setOidTipoCliente(ticlOidTipoClie);
        setOidSubtipoCliente(sbtiOidSubtClie);
        setOidTipoClasificacion(tcclOidTipoClas);
        setOidClasificacion(clasOidClas);
    }

    @Id
    @Column(name="OID_CONF_TEXT_VARI")
    private Long oid;
    @Column(name="VAL_TEXT_VARI")
    private String textoVariable;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="TCCL_OID_TIPO_CLAS")
    private Long oidTipoClasificacion;
    @Column(name="SBTI_OID_SUBT_CLIE")
    private Long oidSubtipoCliente;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long oidTipoCliente;
    @Column(name="CLAS_OID_CLAS")
    private Long oidClasificacion;

    
    public Long getOid() {return oid;}
    
    public String getTextoVariable() {return textoVariable;}
  
    public void setTextoVariable(String textoVariable){this.textoVariable=textoVariable;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public Long getOidTipoClasificacion() {return oidTipoClasificacion;}
  
    public void setOidTipoClasificacion(Long oidTipoClasificacion){this.oidTipoClasificacion=oidTipoClasificacion;}
            
    public Long getOidSubtipoCliente() {return oidSubtipoCliente;}
  
    public void setOidSubtipoCliente(Long oidSubtipoCliente){this.oidSubtipoCliente=oidSubtipoCliente;}
            
    public Long getOidTipoCliente() {return oidTipoCliente;}
  
    public void setOidTipoCliente(Long oidTipoCliente){this.oidTipoCliente=oidTipoCliente;}
            
    public Long getOidClasificacion() {return oidClasificacion;}
  
    public void setOidClasificacion(Long oidClasificacion){this.oidClasificacion=oidClasificacion;}
                    
	
}
