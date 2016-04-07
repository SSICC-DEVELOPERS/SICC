package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_GRUPO_PROCE")
@NamedQueries({
@NamedQuery(name="GrupoProcesosLocal.FindAll", query="SELECT OBJECT(o) FROM GrupoProcesosLocal AS o")
})
public class GrupoProcesosLocal implements Serializable {

    public GrupoProcesosLocal() {}

    public GrupoProcesosLocal(Long oid, String cod_grup_proc)	{
        this.oid=oid;
        this.cod_grup_proc = cod_grup_proc;
    }

    @Id
    @Column(name="OID_GRUP_PROC")
    private Long oid;
    @Column(name="COD_GRUP_PROC")
    private String cod_grup_proc;
    @Column(name="DES_GRUP_PROC")
    private String des_grup_proc;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCod_grup_proc() {return cod_grup_proc;}
  
    public void setCod_grup_proc(String cod_grup_proc){this.cod_grup_proc=cod_grup_proc;}
            
    public String getDes_grup_proc() {return des_grup_proc;}
  
    public void setDes_grup_proc(String des_grup_proc){this.des_grup_proc=des_grup_proc;}
	
}
