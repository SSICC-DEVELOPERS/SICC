package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CLIEN_RECDO")
@NamedQueries({
@NamedQuery(name="ClienteRecomendadoLocal.FindAll",query="select object(o) from ClienteRecomendadoLocal o"),
@NamedQuery(name="ClienteRecomendadoLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ClienteRecomendadoLocal AS a "
+ " WHERE a.recomendante = ?1 "
+ " AND a.recomendado = ?2")
})
public class ClienteRecomendadoLocal implements Serializable {

	public ClienteRecomendadoLocal() {}

	public ClienteRecomendadoLocal(Long oid, Long clieOidClie, Long perdOidPeri, Long recomendante)	{
	
		this.oid=oid;
                this.setRecomendado(clieOidClie);
	        this.setPeriodoInicioVinculo(perdOidPeri);
	        this.setRecomendante(recomendante);    
	
	}

	@Id
	@Column(name="OID_CLIE_REDO")
	private Long oid;
	@Column(name="IND_EFEC")
	private Boolean efectiva;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="CLIE_OID_CLIE")
	private Long recomendado;
	@Column(name="CLR3_OID_CLIE_RETE")
	private Long recomendante;
	@Column(name="PERD_OID_PERI")
	private Long periodoInicioVinculo;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivel;
	@Column(name="IND_EVAL")
	private Boolean eval;
        
        @Column(name="OID_MODU")
        private String oidModulo;
        @Column(name="FEC_CREA")
        private java.sql.Date fechaCreacion;        
        @Column(name="FEC_EFEC")
        private java.sql.Date fechaEfectividad;
        @Column(name="IND_ANUL")
        private Boolean anulado;
    
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getEfectiva() {return efectiva;}
      
	public void setEfectiva(Boolean efectiva){this.efectiva=efectiva;}
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public Long getRecomendado() {return recomendado;}
      
	public void setRecomendado(Long recomendado){this.recomendado=recomendado;}
		
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
		
	public Long getPeriodoInicioVinculo() {return periodoInicioVinculo;}
      
	public void setPeriodoInicioVinculo(Long periodoInicioVinculo){this.periodoInicioVinculo=periodoInicioVinculo;}
		
	public Long getNivel() {return nivel;}
      
	public void setNivel(Long nivel){this.nivel=nivel;}
		
	public Boolean getEval() {return eval;}
      
	public void setEval(Boolean eval){this.eval=eval;}

        public String getOidModulo() { return oidModulo; }
        
        public void setOidModulo(String oidModulo) { this.oidModulo = oidModulo; }

        public java.sql.Date getFechaCreacion() { return fechaCreacion; }
    
        public void setFechaCreacion(java.sql.Date fechaCreacion) { this.fechaCreacion = fechaCreacion;}

        public java.sql.Date getFechaEfectividad() { return fechaEfectividad; }
        
        public void setFechaEfectividad(java.sql.Date fechaEfectividad) { this.fechaEfectividad = fechaEfectividad; }

        public Boolean getAnulado() { return anulado; }
    
        public void setAnulado(Boolean anulado) { this.anulado = anulado; }
        
}
