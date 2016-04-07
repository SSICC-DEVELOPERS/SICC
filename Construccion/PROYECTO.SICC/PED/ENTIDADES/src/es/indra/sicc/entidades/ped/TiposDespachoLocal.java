package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TIPO_DESPA")
@NamedQueries({
@NamedQuery(name="TiposDespachoLocal.FindAll",query="SELECT OBJECT(p) from TiposDespachoLocal p")
})
public class TiposDespachoLocal implements Serializable {

    public TiposDespachoLocal() {}

    public TiposDespachoLocal(Long oid, Long pais_oid_pais, String cod_tipo_desp, Boolean ind_cron) {
        this.oid=oid;
        this.pais = pais_oid_pais;
        this.tipoDespacho = cod_tipo_desp;
        this.indCronograma = ind_cron;
    }

    @Id
    @Column(name="OID_TIPO_DESP")
    private Long oid;
    @Column(name="PAIS_OID_PAIS")
    private Long pais;
    @Column(name="COD_TIPO_DESP")
    private String tipoDespacho;
    @Column(name="IND_CRON")
    private Boolean indCronograma;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getPais() {return pais;}
  
    public void setPais(Long pais){this.pais=pais;}
            
    public String getTipoDespacho() {return tipoDespacho;}
  
    public void setTipoDespacho(String tipoDespacho){this.tipoDespacho=tipoDespacho;}
            
    public Boolean getIndCronograma() {return indCronograma;}
  
    public void setIndCronograma(Boolean indCronograma){this.indCronograma=indCronograma;}
	
}
