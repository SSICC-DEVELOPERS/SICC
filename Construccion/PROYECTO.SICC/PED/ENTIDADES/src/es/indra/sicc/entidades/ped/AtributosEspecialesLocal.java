package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_ATRIB_ESPEC")
@NamedQueries({
@NamedQuery(name="AtributosEspecialesLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM AtributosEspecialesLocal AS a "
+ " WHERE a.cod_atri = ?1"),
@NamedQuery(name="AtributosEspecialesLocal.FindAll",query="SELECT OBJECT(a) FROM AtributosEspecialesLocal AS a")
})
public class AtributosEspecialesLocal implements Serializable {

    public AtributosEspecialesLocal() {}

    public AtributosEspecialesLocal(Long oid, String cod_atri, String des_atri, Long modu_oid_modu)	{
        this.oid=oid;
        this.cod_atri = cod_atri;
        this.des_atri = des_atri;
        this.modu_oid_modu = modu_oid_modu;
    }

    @Id
    @Column(name="OID_ATRI_ESPE")
    private Long oid;
    @Column(name="COD_ATRI")
    private String cod_atri;
    @Column(name="DES_ATRI")
    private String des_atri;
    @Column(name="VAL_FORM")
    private String val_form;
    @Column(name="MODU_OID_MODU")
    private Long modu_oid_modu;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCod_atri() {return cod_atri;}
  
    public void setCod_atri(String cod_atri){this.cod_atri=cod_atri;}
            
    public String getDes_atri() {return des_atri;}
  
    public void setDes_atri(String des_atri){this.des_atri=des_atri;}
            
    public String getVal_form() {return val_form;}
  
    public void setVal_form(String val_form){this.val_form=val_form;}
            
    public Long getModu_oid_modu() {return modu_oid_modu;}
  
    public void setModu_oid_modu(Long modu_oid_modu){this.modu_oid_modu=modu_oid_modu;}
}
