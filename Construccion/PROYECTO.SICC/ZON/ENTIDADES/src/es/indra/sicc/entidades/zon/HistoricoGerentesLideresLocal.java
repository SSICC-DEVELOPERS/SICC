package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_HISTO_GEREN")
@NamedQueries({
@NamedQuery(name="HistoricoGerentesLideresLocal.FindAll",query="select object(o) from HistoricoGerentesLideresLocal o"),
@NamedQuery(name="HistoricoGerentesLideresLocal.FindByNoFechaHasta",query="SELECT OBJECT(h) "
+ " FROM HistoricoGerentesLideresLocal AS h "
+ " WHERE h.ua = ?1 "
+ " AND h.pais = ?2"
+ " AND h.marca = ?3 "
+ " AND h.canal = ?4 "
+ " AND h.periodoHasta IS NULL")
})
public class HistoricoGerentesLideresLocal implements Serializable {

	public HistoricoGerentesLideresLocal() {}

	public HistoricoGerentesLideresLocal(Long oid, Long pais, Long marcOidMarc, Long canaOidCana,
                String ua, String gere, Timestamp fecDesd)	{
    
            this.oid = oid;
            this.pais = pais;
            this.marca = marcOidMarc;
            this.canal = canaOidCana;
            this.ua = ua;
            this.gerentes = gere;
            this.fechaDesde = fecDesd;
	}

	@Id
	@Column(name="OID_HIST_GERE")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="UA")
	private String ua;
	@Column(name="GERE")
	private String gerentes;
	@Column(name="FEC_DESD")
	private java.sql.Timestamp fechaDesde;
	@Column(name="FEC_HAST")
	private java.sql.Timestamp fechaHasta;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
        
        // sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
        @Column(name="PERD_OID_PERI_DESD")
        private Long periodoDesde;
        @Column(name="PERD_OID_PERI_HAST")
        private Long periodoHasta;
        @Column(name="IND_DESV_AUTO")
        private Long indDesvinculacion;
        @Column(name="USU_MODI")
        private String usuario;
        @Column(name="FEC_MODI")
        private java.sql.Timestamp fechaModificacion;
    
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public String getUa() {return ua;}
      
	public void setUa(String ua){this.ua=ua;}
		
	public String getGerentes() {return gerentes;}
      
	public void setGerentes(String gerentes){this.gerentes=gerentes;}
		
	public java.sql.Timestamp getFechaDesde() {return fechaDesde;}
      
	public void setFechaDesde(java.sql.Timestamp fechaDesde){this.fechaDesde=fechaDesde;}
		
	public java.sql.Timestamp getFechaHasta() {return fechaHasta;}
      
	public void setFechaHasta(java.sql.Timestamp fechaHasta){this.fechaHasta=fechaHasta;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
    
        public void setPeriodoDesde(Long periodoDesde) {
            this.periodoDesde = periodoDesde;
        }
    
        public Long getPeriodoDesde() {
            return periodoDesde;
        }
    
        public void setPeriodoHasta(Long periodoHasta) {
            this.periodoHasta = periodoHasta;
        }
    
        public Long getPeriodoHasta() {
            return periodoHasta;
        }
    
        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }
    
        public String getUsuario() {
            return usuario;
        }
    
        public void setFechaModificacion(Timestamp fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }
    
        public Timestamp getFechaModificacion() {
            return fechaModificacion;
        }

        public void setIndDesvinculacion(Long indDesvinculacion) {
            this.indDesvinculacion = indDesvinculacion;
        }

        public Long getIndDesvinculacion() {
            return indDesvinculacion;
        }
}
