package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_VALOR_DEFEC_TIPO_SOLIC")
@NamedQueries({
@NamedQuery(name="ValoresPorDefectoLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ValoresPorDefectoLocal AS a "
+ " WHERE a.oidAtriEspe = ?1 "
+ " AND a.oidTipoSoliPais = ?2"),
@NamedQuery(name="ValoresPorDefectoLocal.FindAll",query="SELECT OBJECT(p) from ValoresPorDefectoLocal p")
})
public class ValoresPorDefectoLocal implements Serializable {

    public ValoresPorDefectoLocal() {}

    public ValoresPorDefectoLocal(Long oid, Long tspa_oid_tipo_soli_pais, Long atre_oid_atri_espe, Long ind_obli, Long ind_modi)	{
        this.oid=oid;
        this.oidTipoSoliPais = tspa_oid_tipo_soli_pais;
        this.oidAtriEspe = atre_oid_atri_espe;
        this.indObli = ind_obli;
        this.indModi = ind_modi;
    }

    @Id
    @Column(name="OID_VALO_DEFE_TIPO_SOLI")
    private Long oid;
    @Column(name="VAL_VALO_DEFE")
    private String valDefe;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long oidTipoSoliPais;
    @Column(name="ATRE_OID_ATRI_ESPE")
    private Long oidAtriEspe;
    @Column(name="IND_OBLI")
    private Long indObli;
    @Column(name="IND_MODI")
    private Long indModi;
    @Column(name="VAL_DEFE_OID")
    private Long valDefeOid;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getValDefe() {return valDefe;}
  
    public void setValDefe(String valDefe){this.valDefe=valDefe;}
            
    public Long getOidTipoSoliPais() {return oidTipoSoliPais;}
  
    public void setOidTipoSoliPais(Long oidTipoSoliPais){this.oidTipoSoliPais=oidTipoSoliPais;}
            
    public Long getOidAtriEspe() {return oidAtriEspe;}
  
    public void setOidAtriEspe(Long oidAtriEspe){this.oidAtriEspe=oidAtriEspe;}
            
    public Long getIndObli() {return indObli;}
  
    public void setIndObli(Long indObli){this.indObli=indObli;}
            
    public Long getIndModi() {return indModi;}
  
    public void setIndModi(Long indModi){this.indModi=indModi;}
            
    public Long getValDefeOid() {return valDefeOid;}
  
    public void setValDefeOid(Long valDefeOid){this.valDefeOid=valDefeOid;}
	
}
