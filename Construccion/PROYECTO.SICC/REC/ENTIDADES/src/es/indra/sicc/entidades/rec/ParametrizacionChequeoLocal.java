package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PARAM_CHEQU")
@NamedQueries({
@NamedQuery(name="ParametrizacionChequeoLocal.FindAll",query="select object(o) from ParametrizacionChequeoLocal o"),
@NamedQuery(name="ParametrizacionChequeoLocal.FindByUK",query="SELECT OBJECT(s) FROM ParametrizacionChequeoLocal s WHERE s.oidTipoChequeo = ?1 ")
})
public class ParametrizacionChequeoLocal implements Serializable {

	public ParametrizacionChequeoLocal() {}

	public ParametrizacionChequeoLocal(Long oid)	{
	
		this.oid=oid;
	
	}

	@Id
	@Column(name="OID_PARA_CHEQ")
	private Long oid;
        @Column(name="TIRV_OID_TIPO_INDI_REVI")
        private Long oidTipoChequeo;
	@Column(name="IND_CONS_REIN")
	private Boolean indConsReincidentes;
        @Column(name="NUM_CANT_PERI_EVAL_ATRA")
        private Integer cantidadPeriHaciaAtras;
        @Column(name="NUM_CANT_MINI_RECL")
        private Integer cantidadMinima;
        @Column(name="IND_CHEQ_NUEV")
        private Boolean indConsNuevas;
        
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}	
        
        public Long getOidTipoChequeo() {return oidTipoChequeo;}
        
        public void setOidTipoChequeo(Long oidTipoChequeo){this.oidTipoChequeo=oidTipoChequeo;}     
		
        public Boolean getIndConsReincidentes() {return indConsReincidentes;}
        
        public void setIndConsReincidentes(Boolean indConsReincidentes){this.indConsReincidentes=indConsReincidentes;}
                
        public Integer getCantidadPeriHaciaAtras() {return cantidadPeriHaciaAtras;}
        
        public void setCantidadPeriHaciaAtras(Integer cantidadPeriHaciaAtras){this.cantidadPeriHaciaAtras=cantidadPeriHaciaAtras;}
    
        public Integer getCantidadMinima() {return cantidadMinima;}
        
        public void setCantidadMinima(Integer cantidadMinima){this.cantidadMinima=cantidadMinima;}
        
        public Boolean getIndConsNuevas() {return indConsNuevas;}
        
        public void setIndConsNuevas(Boolean indConsNuevas){this.indConsNuevas=indConsNuevas;}
        
        
        
        
       
                         
	
}
