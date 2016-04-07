package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_KIT_PRODU")
@NamedQueries({
@NamedQuery(name="KitProductosLocal.FindByKitOid", query="SELECT OBJECT(o) FROM KitProductosLocal AS o"
+ " WHERE o.productoPrincipal = ?1"),
@NamedQuery(name="KitProductosLocal.FindAll", query="SELECT OBJECT(o) FROM KitProductosLocal AS o")
})
public class KitProductosLocal implements Serializable {

    public KitProductosLocal() {}

    public KitProductosLocal(Long oid, Long prod_oid_prod_kit, Long prod_oid_prod) {
        this.oid=oid;
        this.productoAdicional = prod_oid_prod_kit;
        this.productoPrincipal = prod_oid_prod;
    }

    @Id
    @Column(name="OID_KIT_PROD")
    private Long oid;
    @Column(name="PROD_OID_PROD_KIT")
    private Long productoAdicional;
    @Column(name="PROD_OID_PROD")
    private Long productoPrincipal;
    @Column(name="NUM_UNID")
    private Integer numeroUnidades;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getProductoAdicional() {return productoAdicional;}
  
    public void setProductoAdicional(Long productoAdicional){this.productoAdicional=productoAdicional;}
            
    public Long getProductoPrincipal() {return productoPrincipal;}
  
    public void setProductoPrincipal(Long productoPrincipal){this.productoPrincipal=productoPrincipal;}
            
    public Integer getNumeroUnidades() {return numeroUnidades;}
  
    public void setNumeroUnidades(Integer numeroUnidades){this.numeroUnidades=numeroUnidades;}
}
