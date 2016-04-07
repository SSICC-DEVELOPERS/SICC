package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_CONFI_LIAFP_CABEC")
@NamedQueries({
@NamedQuery(name="ConfiguracionListaAFPCabeceraLocal.FindAll",query="select object(o) from ConfiguracionListaAFPCabeceraLocal o")
})
public class ConfiguracionListaAFPCabeceraLocal implements Serializable {

    public ConfiguracionListaAFPCabeceraLocal() {}

    public ConfiguracionListaAFPCabeceraLocal(Long oid, Long numAgru, Long ccdiOidConfCentDist,
            Long canaOidCana, Long marcOidMarc)	{

        this.oid = oid;
        this.setAgrupacion(numAgru);
        this.setOidConfiguracionCentroDistribucion(ccdiOidConfCentDist);
        this.setOidCana(canaOidCana);
        this.setOidMarc(marcOidMarc);
    }

    @Id
    @Column(name="OID_CONF_LAFP_CABE")
    private Long oid;
    @Column(name="NUM_AGRU")
    private Long agrupacion;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long oidConfiguracionCentroDistribucion;
    @Column(name="CANA_OID_CANA")
    private Long oidCana;
    @Column(name="MARC_OID_MARC")
    private Long oidMarc;

    
    public Long getOid() {return oid;}
    
    public Long getAgrupacion() {return agrupacion;}
  
    public void setAgrupacion(Long agrupacion){this.agrupacion=agrupacion;}
            
    public Long getOidConfiguracionCentroDistribucion() {return oidConfiguracionCentroDistribucion;}
  
    public void setOidConfiguracionCentroDistribucion(Long oidConfiguracionCentroDistribucion){this.oidConfiguracionCentroDistribucion=oidConfiguracionCentroDistribucion;}
            
    public Long getOidCana() {return oidCana;}
  
    public void setOidCana(Long oidCana){this.oidCana=oidCana;}
            
    public Long getOidMarc() {return oidMarc;}
  
    public void setOidMarc(Long oidMarc){this.oidMarc=oidMarc;}
                    
	
}
