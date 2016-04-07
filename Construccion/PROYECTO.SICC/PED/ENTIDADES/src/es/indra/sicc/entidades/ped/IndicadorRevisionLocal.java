package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_INDIC_REVIS")
@NamedQueries({
@NamedQuery(name="IndicadorRevisionLocal.FindAll", query="SELECT OBJECT(o) FROM IndicadorRevisionLocal AS o")
})
public class IndicadorRevisionLocal implements Serializable {

    public IndicadorRevisionLocal() {}

    public IndicadorRevisionLocal(Long oid, String cod_indi_reve)	{
        this.oid=oid;
        this.codigo = cod_indi_reve;
    }

    @Id
    @Column(name="OID_INDI_REVE")
    private Long oid;
    @Column(name="COD_INDI_REVE")
    private String codigo;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodigo() {return codigo;}
  
    public void setCodigo(String codigo){this.codigo=codigo;}
	
}
