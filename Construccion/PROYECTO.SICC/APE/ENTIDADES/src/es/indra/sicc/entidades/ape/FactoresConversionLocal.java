package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="APE_FACTO_CONVE")
@NamedQueries({
@NamedQuery(name="FactoresConversionLocal.FindAll",query="select object(o) from FactoresConversionLocal o")
})
public class FactoresConversionLocal implements Serializable {

    public FactoresConversionLocal() {}

    public FactoresConversionLocal(Long oid, BigDecimal factorConversion,
            Long magnitud, Long origen, Long destino)	{
            
        this.oid = oid;
        setFactorConversion(factorConversion);
        setMagnitud(magnitud);
        setOrigen(origen);
        setDestino(destino);
    }

    @Id
    @Column(name="OID_FACT_CONV")
    private Long oid;
    @Column(name="NUM_FACT_CONV")
    private java.math.BigDecimal factorConversion;
    @Column(name="MAGN_OID_MAGN")
    private Long magnitud;
    @Column(name="UNMD_OID_UNID_MEDI_ORIG")
    private Long origen;
    @Column(name="UNMD_OID_UNID_MEDI_DEST")
    private Long destino;

    
    public Long getOid() {return oid;}
    
    public java.math.BigDecimal getFactorConversion() {return factorConversion;}
  
    public void setFactorConversion(java.math.BigDecimal factorConversion){this.factorConversion=factorConversion;}
            
    public Long getMagnitud() {return magnitud;}
  
    public void setMagnitud(Long magnitud){this.magnitud=magnitud;}
            
    public Long getOrigen() {return origen;}
  
    public void setOrigen(Long origen){this.origen=origen;}
            
    public Long getDestino() {return destino;}
  
    public void setDestino(Long destino){this.destino=destino;}
                    
	
}
