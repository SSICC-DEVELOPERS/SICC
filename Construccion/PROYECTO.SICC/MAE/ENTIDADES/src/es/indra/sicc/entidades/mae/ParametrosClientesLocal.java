package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_PARAM_CLIEN")
@NamedQueries({
@NamedQuery(name="ParametrosClientesLocal.FindAll", query="SELECT OBJECT(o) FROM ParametrosClientesLocal AS o"),
@NamedQuery(name="ParametrosClientesLocal.FindByPais", query="SELECT OBJECT(o) FROM ParametrosClientesLocal AS o "
+ " WHERE o.pais_oid_pais = ?1")
})
public class ParametrosClientesLocal implements Serializable {

    public ParametrosClientesLocal() {}

    public ParametrosClientesLocal(Long oid, Long pais_oid_pais, String cod_tipo_asig)	{
        this.oid=oid;
        this.pais_oid_pais = pais_oid_pais;
        this.cod_tipo_asig = cod_tipo_asig;
    }

    @Id
    @Column(name="OID_PARA_CLIE")
    private Long oid;
    @Column(name="PAIS_OID_PAIS")
    private Long pais_oid_pais;
    @Column(name="COD_TIPO_ASIG")
    private String cod_tipo_asig;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getPais_oid_pais() {return pais_oid_pais;}
  
    public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
            
    public String getCod_tipo_asig() {return cod_tipo_asig;}
  
    public void setCod_tipo_asig(String cod_tipo_asig){this.cod_tipo_asig=cod_tipo_asig;}
                    
    public boolean esAsignacionAutomatica() {
        return this.getCod_tipo_asig().equalsIgnoreCase("a");
    }
}
