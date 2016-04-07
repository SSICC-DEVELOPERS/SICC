package es.indra.sicc.entidades.men;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MEN_FAVOR")
@NamedQueries({
@NamedQuery(name="FavoritosLocal.FindByUsuario",query="select object(f) from FavoritosLocal f"
+ " where f.val_usua = ?1"),
@NamedQuery(name="FavoritosLocal.FindAll",query="select object(f) from FavoritosLocal f")
})

public class FavoritosLocal implements Serializable {

	public FavoritosLocal() {}

        public FavoritosLocal(Long oid, Long func_oid_func, String val_usua)     {
                this.oid = oid;
                this.func_oid_func = func_oid_func;
                this.val_usua = val_usua;
        }
        

	@Id
	@Column(name="OID_FAVO")
	private Long oid;
	@Column(name="FUNC_OID_FUNC")
	private Long func_oid_func;
	@Column(name="VAL_USUA")
	private String val_usua;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getFunc_oid_func() {return func_oid_func;}
      
	public void setFunc_oid_func(Long func_oid_func){this.func_oid_func=func_oid_func;}
		
	public String getVal_usua() {return val_usua;}
      
	public void setVal_usua(String val_usua){this.val_usua=val_usua;}
			
	
}
