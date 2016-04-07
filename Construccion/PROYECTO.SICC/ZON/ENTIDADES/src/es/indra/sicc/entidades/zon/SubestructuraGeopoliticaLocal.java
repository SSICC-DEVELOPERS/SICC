package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="ZON_SUBES_GEOPO")
@NamedQueries({
@NamedQuery(name="SubestructuraGeopoliticaLocal.FindByEGCod",query="SELECT OBJECT(a) "
+ " FROM SubestructuraGeopoliticaLocal AS a "
+ " WHERE a.codigo = ?1 "
+ " AND a.oidEstructuraGeopoli = ?2"),
@NamedQuery(name="SubestructuraGeopoliticaLocal.FindAll",query="SELECT OBJECT(a) FROM SubestructuraGeopoliticaLocal AS a ")
})
public class SubestructuraGeopoliticaLocal implements Serializable {

    public SubestructuraGeopoliticaLocal() {}

    public SubestructuraGeopoliticaLocal(Long oid, Integer cod_sube, Long egeo_oid_estr_geop) {
        this.oid = oid;
        this.codigo = cod_sube;
        this.oidEstructuraGeopoli = egeo_oid_estr_geop;
    }

    @Id
    @Column(name="OID_SUBE_GEOP")
    private Long oid;
    @Column(name="COD_SUBE")
    private Integer codigo;
    @Column(name="EGEO_OID_ESTR_GEOP")
    private Long oidEstructuraGeopoli;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Integer getCodigo() {return codigo;}
  
    public void setCodigo(Integer codigo){this.codigo=codigo;}
            
    public Long getOidEstructuraGeopoli() {return oidEstructuraGeopoli;}
  
    public void setOidEstructuraGeopoli(Long oidEstructuraGeopoli){this.oidEstructuraGeopoli=oidEstructuraGeopoli;}
}
