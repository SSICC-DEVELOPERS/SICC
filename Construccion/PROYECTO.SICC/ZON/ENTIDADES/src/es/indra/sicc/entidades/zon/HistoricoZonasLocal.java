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
@Table(name="ZON_HISTO_ZONAS")
@NamedQueries({
@NamedQuery(name="HistoricoZonasLocal.FindAll",query="select object(o) from HistoricoZonasLocal o")
})
public class HistoricoZonasLocal implements Serializable {

	public HistoricoZonasLocal() {}

	public HistoricoZonasLocal(Long oid, String valTipoModi, String valUnidAdm1,
                String valUnidAdm2, Timestamp fecCrea, Long perdOidPeriActi) {
                
            this.oid=oid;
            this.tipoModificacion = valTipoModi;
            this.ua1 = valUnidAdm1;
            this.ua2 = valUnidAdm2;
            this.fechaCreacion = fecCrea;
            this.periodoActivacion = perdOidPeriActi;
	}

	@Column(name="VAL_TIPO_MODI")
	private String tipoModificacion;
	@Id
	@Column(name="OID_HIST_ZONA")
	private Long oid;
	@Column(name="FEC_ACTI")
	private java.sql.Timestamp fechaActivacion;
	@Column(name="VAL_UNID_ADM1")
	private String ua1;
	@Column(name="VAL_UNID_ADM2")
	private String ua2;
	@Column(name="VAL_UNID_ADM3")
	private String ua3;
	@Column(name="FEC_CREA")
	private java.sql.Timestamp fechaCreacion;
	@Column(name="PERD_OID_PERI_ACTI")
	private Long periodoActivacion;

	
	public String getTipoModificacion() {return tipoModificacion;}
      
	public void setTipoModificacion(String tipoModificacion){this.tipoModificacion=tipoModificacion;}
		
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFechaActivacion() {return fechaActivacion;}
      
	public void setFechaActivacion(java.sql.Timestamp fechaActivacion){this.fechaActivacion=fechaActivacion;}
		
	public String getUa1() {return ua1;}
      
	public void setUa1(String ua1){this.ua1=ua1;}
		
	public String getUa2() {return ua2;}
      
	public void setUa2(String ua2){this.ua2=ua2;}
		
	public String getUa3() {return ua3;}
      
	public void setUa3(String ua3){this.ua3=ua3;}
		
	public java.sql.Timestamp getFechaCreacion() {return fechaCreacion;}
      
	public void setFechaCreacion(java.sql.Timestamp fechaCreacion){this.fechaCreacion=fechaCreacion;}
		
	public Long getPeriodoActivacion() {return periodoActivacion;}
      
	public void setPeriodoActivacion(Long periodoActivacion){this.periodoActivacion=periodoActivacion;}
			
	
}
