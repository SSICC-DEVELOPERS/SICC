package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_SORTE")
@NamedQueries({
@NamedQuery(name="PremioSorteoLocal.FindAll",query="select object(o) from PremioSorteoLocal o"),
@NamedQuery(name="PremioSorteoLocal.FindByParametroNivelPremiacion",query="SELECT OBJECT(a) "
+ " FROM PremioSorteoLocal AS a "
+ " WHERE a.nivelPremiacion = ?1"),
@NamedQuery(name="PremioSorteoLocal.FindByUK",query="SELECT OBJECT(o) FROM PremioSorteoLocal o WHERE o.nivelPremiacion = ?1")
})

// vbongiov -- Cambio 20080811 -- 26/08/2009
public class PremioSorteoLocal implements Serializable {

	public PremioSorteoLocal() {}

	public PremioSorteoLocal(Long oid, Long copaOidParaGral, Long panpOidParaNivePrem, Integer numerosAsignado, Long prodOidProducto)	{
	
		this.oid=oid;
                this.setNumAsignado(numerosAsignado);
	        this.setNivelPremiacion(panpOidParaNivePrem);
	        this.setOidProducto(prodOidProducto);
	        this.setOidConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_PREM_SORT")
	private Long oid;
        @Column(name="COPA_OID_PARA_GRAL")
        private Long oidConcurso;
        @Column(name="NUM_ASIG")
        private Integer numAsignado;
        @Column(name="PROD_OID_PROD")
        private Long oidProducto;
        @Column(name="PANP_OID_PARA_NIVE_PREM")
        private Long nivelPremiacion;
            
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}	
        
        public Long getOidConcurso() {return oidConcurso;}
        
        public void setOidConcurso(Long oidConcurso){this.oidConcurso=oidConcurso;}
		
	public Integer getNumAsignado() {return numAsignado;}
      
	public void setNumAsignado(Integer numAsignado){this.numAsignado=numAsignado;}
        
        public Long getOidProducto() {return oidProducto;}
        
        public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	
	
}
