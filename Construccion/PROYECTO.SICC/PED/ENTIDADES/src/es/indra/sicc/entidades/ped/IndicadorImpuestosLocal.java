package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TASA_IMPUE")
@NamedQueries({
@NamedQuery(name="IndicadorImpuestosLocal.FindAll",query="select object(o) from IndicadorImpuestosLocal o"),
@NamedQuery(name="IndicadorImpuestosLocal.FindByUK",query="select Object(o) from IndicadorImpuestosLocal o "
+ " where o.oidPais = ?1 and "
+ " o.indiImpu = ?2")
})
public class IndicadorImpuestosLocal implements Serializable {

    public IndicadorImpuestosLocal() {}

    public IndicadorImpuestosLocal(Long oidTasaImpu, String valIndiImpu, Long paisOidPais, Double valTasaImpu)	{
        this.oidTasaImpu=oidTasaImpu;
        this.indiImpu = valIndiImpu;
        this.oidPais = paisOidPais;
        this.tasaImpu = valTasaImpu;
    }

    @Id
    @Column(name="OID_TASA_IMPU")
    private Long oidTasaImpu;
    @Column(name="VAL_INDI_IMPU")
    private String indiImpu;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="VAL_TASA_IMPU")
    private Double tasaImpu;

    
    public Long getOidTasaImpu() {return oidTasaImpu;}
  
    public String getIndiImpu() {return indiImpu;}
  
    public void setIndiImpu(String indiImpu){this.indiImpu=indiImpu;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public Double getTasaImpu() {return tasaImpu;}
  
    public void setTasaImpu(Double tasaImpu){this.tasaImpu=tasaImpu;}
                    
	
}
