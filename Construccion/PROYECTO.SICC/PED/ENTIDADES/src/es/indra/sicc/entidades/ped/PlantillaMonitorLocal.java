package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_PLANT_MONIT")
@NamedQueries({
@NamedQuery(name="PlantillaMonitorLocal.FindAll", query="SELECT OBJECT(o) FROM PlantillaMonitorLocal AS o")
})
public class PlantillaMonitorLocal implements Serializable {

    public PlantillaMonitorLocal() {}

    public PlantillaMonitorLocal(Long oid, String cod_plan_moni, String des_plan_moni, Long pais_oid_pais) {
        this.oid=oid;
        this.codigo = cod_plan_moni;
        this.desc = des_plan_moni;
        this.pais = pais_oid_pais;
    }

    @Id
    @Column(name="OID_PLAN_MONI")
    private Long oid;
    @Column(name="COD_PLAN_MONI")
    private String codigo;
    @Column(name="DES_PLAN_MONI")
    private String desc;
    @Column(name="PAIS_OID_PAIS")
    private Long pais;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
            
    public String getDesc() {return desc;}
  
    public void setDesc(String desc){this.desc=desc;}
            
    public Long getPais() {return pais;}
  
    public void setPais(Long pais){this.pais=pais;}
                    
}
