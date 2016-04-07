package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BEL_MOVIM_ALMAC_CABEC")
@NamedQueries({
@NamedQuery(name="MovimientosAlmacenCabeceraLocal.FindByUK",query="SELECT OBJECT(m) FROM MovimientosAlmacenCabeceraLocal AS m WHERE m.pais=?1 AND m.nMovimiento=?2 AND m.subacceso=?3")
})
public class MovimientosAlmacenCabeceraLocal implements Serializable {

	public MovimientosAlmacenCabeceraLocal() {}

	public MovimientosAlmacenCabeceraLocal(Long oid, Long pais, Long subacceso, Timestamp fecha, Long periodo, Long numeroMovimiento)	{
		this.oid=oid;
                this.pais = pais;
                this.subacceso = subacceso;
                this.fecha = fecha;
                this.periodo = periodo;
                this.nMovimiento = numeroMovimiento;
	}
        
        public MovimientosAlmacenCabeceraLocal(Long oid, Long pais, Long subacceso, Timestamp fecha, Long periodo, String numeroDocumento, 
        String observaciones, Long almacenEntrada, Long almacenSalida, Long tipoMovimientoAlmacen, Long numeroMovimiento) {
            this.oid=oid;
            this.pais = pais;
            this.subacceso = subacceso;
            this.fecha = fecha;
            this.periodo = periodo;
            this.numeroDocumento = numeroDocumento;
            this.observaciones = observaciones;
            this.almacenEntrada = almacenEntrada;
            this.almacenSalida = almacenSalida;
            this.tipoMovimientoAlmacen = tipoMovimientoAlmacen;
            this.nMovimiento = numeroMovimiento;
        }

	@Id
	@Column(name="OID_MOVI_ALMA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="NUM_DOCU")
	private String numeroDocumento;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="FEC_MOVI")
        //@Temporal(TemporalType.DATE)
	private java.sql.Timestamp fecha;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="ALMC_OID_ALMA_1")
	private Long almacenEntrada;
	@Column(name="ALMC_OID_ALMA_2")
	private Long almacenSalida;
	@Column(name="TMAL_OID_TIPO_MOVI_ALMA")
	private Long tipoMovimientoAlmacen;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="N_MOVIMIENTO")
	private Long nMovimiento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getNumeroDocumento() {return numeroDocumento;}
      
	public void setNumeroDocumento(String numeroDocumento){this.numeroDocumento=numeroDocumento;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getAlmacenEntrada() {return almacenEntrada;}
      
	public void setAlmacenEntrada(Long almacenEntrada){this.almacenEntrada=almacenEntrada;}
		
	public Long getAlmacenSalida() {return almacenSalida;}
      
	public void setAlmacenSalida(Long almacenSalida){this.almacenSalida=almacenSalida;}
		
	public Long getTipoMovimientoAlmacen() {return tipoMovimientoAlmacen;}
      
	public void setTipoMovimientoAlmacen(Long tipoMovimientoAlmacen){this.tipoMovimientoAlmacen=tipoMovimientoAlmacen;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getNMovimiento() {return nMovimiento;}
      
	public void setNMovimiento(Long nMovimiento){this.nMovimiento=nMovimiento;}
			
	
}
