package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_CONFI_LIAFP_DETAL")
@NamedQueries({
@NamedQuery(name="ConfiguracionListaAFPDetalleLocal.FindAll",query="select object(o) from ConfiguracionListaAFPDetalleLocal o")
})
public class ConfiguracionListaAFPDetalleLocal implements Serializable {

    public ConfiguracionListaAFPDetalleLocal() {}

    public ConfiguracionListaAFPDetalleLocal(Long oid, Long numLine, Long liacOidConfLafpCabe,
            Long zorgOidRegi, Long oidZona, Long oidSeccion)	{

        this.oid = oid;
        this.setLinea(numLine);
        this.setOidConfiguracionListaAFPCabecera(liacOidConfLafpCabe);
        this.setOidRegion(zorgOidRegi);
        this.setOidZona(oidZona);
        this.setOidSeccion(oidSeccion);
    }

    @Id
    @Column(name="OID_CONF_LAFP_DETA")
    private Long oid;
    @Column(name="NUM_LINE")
    private Long linea;
    @Column(name="LIAC_OID_CONF_LAFP_CABE")
    private Long oidConfiguracionListaAFPCabecera;
    @Column(name="ZZON_OID_ZONA")
    private Long oidZona;
    @Column(name="ZSCC_OID_SECC")
    private Long oidSeccion;
    @Column(name="ZORG_OID_REGI")
    private Long oidRegion;

    
    public Long getOid() {return oid;}
    
    public Long getLinea() {return linea;}
  
    public void setLinea(Long linea){this.linea=linea;}
            
    public Long getOidConfiguracionListaAFPCabecera() {return oidConfiguracionListaAFPCabecera;}
  
    public void setOidConfiguracionListaAFPCabecera(Long oidConfiguracionListaAFPCabecera){this.oidConfiguracionListaAFPCabecera=oidConfiguracionListaAFPCabecera;}
            
    public Long getOidZona() {return oidZona;}
  
    public void setOidZona(Long oidZona){this.oidZona=oidZona;}
            
    public Long getOidSeccion() {return oidSeccion;}
  
    public void setOidSeccion(Long oidSeccion){this.oidSeccion=oidSeccion;}
            
    public Long getOidRegion() {return oidRegion;}
  
    public void setOidRegion(Long oidRegion){this.oidRegion=oidRegion;}
                    
	
}
