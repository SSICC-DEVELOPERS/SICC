package es.indra.sicc.cmn.negocio.interfaces;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="INT_HISTO_LOTES")
@NamedQueries({
@NamedQuery(name="HistoricoLotesLocal.FindAll",query="select object(o) from HistoricoLotesLocal o"),
@NamedQuery(name="HistoricoLotesLocal.FindByPrimaryKey",query="select object(o) from HistoricoLotesLocal o"
+ " WHERE o.pais = ?1"
+ "   AND o.codigoInterfaz = ?2"
+ "   AND o.numeroLote = ?3")
})
@IdClass(es.indra.sicc.cmn.negocio.interfaces.HistoricoLotesPK.class)
public class HistoricoLotesLocal implements Serializable {

        public HistoricoLotesLocal() { }

	public HistoricoLotesLocal(String codigo, String numeroLote, Long pais, String descripcion, 
			Date fechaInicio, Date fechaFin, int registroProcesados, int registrosErroneos, 
			String observaciones)	{
			
		this.pais = pais;
		this.codigoInterfaz = codigo;
		this.numeroLote = numeroLote;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.numeroRegistrosProcesados = registroProcesados;
		this.numeroRegistrosErroneos = registrosErroneos;
		this.observaciones = observaciones;
	}

        @Id
        @Column(name="NUM_LOTE")
        private String numeroLote;
        @Id
	@Column(name="COD_INTE")
	private String codigoInterfaz;
        @Id
        @Column(name="PAIS_OID_PAIS")
        private Long pais;
	@Column(name="VAL_DESC_LOTE")
	private String descripcion;
	@Column(name="FEC_INIC_PROC")
        @Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Column(name="FEC_FIN_PROC")
        @Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;
	@Column(name="NUM_REGI_PROC")
	private int numeroRegistrosProcesados;
	@Column(name="NUM_REGI_ERRO")
	private int numeroRegistrosErroneos;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="IND_LOG_ERRO")
	private boolean logErrores;
	@Column(name="VAL_CRIT_CONS")
	private String criteriosConsulta;
        @Column(name="PERI_OID_PERI")
        private Long periodo;

	
	public Long getPais() {return pais;}
        
        public void setPais(Long pais) {this.pais = pais;}
      	
	public String getCodigoInterfaz() {return codigoInterfaz;}
      	
        public void setCodigoInterfaz(String codigoInterfaz) {this.codigoInterfaz = codigoInterfaz;}

	public String getNumeroLote() {return numeroLote;}
        
        public void setNumeroLote(String numeroLote) {this.numeroLote = numeroLote;}
      	
	public String getDescripcion() {return descripcion;}
        
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
      	
	public Date getFechaInicio() {return fechaInicio;}
        
        public void setFechaInicio(Date fechaInicio) {this.fechaInicio = fechaInicio;}
      	
	public Date getFechaFin() {return fechaFin;}
        
        public void setFechaFin(Date fechaFin) {this.fechaFin = fechaFin;}
      	
	public int getNumeroRegistrosProcesados() {return numeroRegistrosProcesados;}
        
        public void setNumeroRegistrosProcesados(int numeroRegistrosProcesados) {this.numeroRegistrosProcesados = numeroRegistrosProcesados;}
      	
	public int getNumeroRegistrosErroneos() {return numeroRegistrosErroneos;}
        
        public void setNumeroRegistrosErroneos(int numeroRegistrosErroneos) {this.numeroRegistrosErroneos = numeroRegistrosErroneos;}
      	
	public String getObservaciones() {return observaciones;}
        
        public void setObservaciones(String observaciones) {this.observaciones = observaciones;}
      	
	public boolean getLogErrores() {return logErrores;}
        
        public void setLogErrores(boolean logErrores) {this.logErrores = logErrores;}
      	
	public String getCriteriosConsulta() {return criteriosConsulta;}
        
        public void setCriteriosConsulta(String criteriosConsulta) {this.criteriosConsulta = criteriosConsulta;}

        public Long getPeriodo() {return periodo;}
    
        public void setPeriodo(Long periodo) {this.periodo = periodo;}      		
	
}
