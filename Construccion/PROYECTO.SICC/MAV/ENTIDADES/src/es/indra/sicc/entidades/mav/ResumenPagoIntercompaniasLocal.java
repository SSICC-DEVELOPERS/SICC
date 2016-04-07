package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="MAV_RESUM_PAGO_INTER")
public class ResumenPagoIntercompaniasLocal implements Serializable {

	public ResumenPagoIntercompaniasLocal() {}

	public ResumenPagoIntercompaniasLocal(Long oid, Timestamp fec_resu_pago_inte, Timestamp fec_inic,
                                            Timestamp fec_fin, Long marc_oid_marc, Long acti_oid_acti, 
                                            Long cana_oid_cana, Long soca_oid_soli_cabe, Long sbac_oid_sbac)	{
	
		this.oid=oid;
                this.fecha=fec_resu_pago_inte;
                this.fechaInicio=fec_inic;
                this.fechaFin=fec_fin;
                this.oidMarca=marc_oid_marc;
                this.oidActividad=acti_oid_acti;
                this.oidCanal=cana_oid_cana;
                this.oidCabeceraSolicitud=soca_oid_soli_cabe;
                this.oidSubac=sbac_oid_sbac;                
	
	}

	@Id
	@Column(name="OID_RESU_PAGO_INTE")
	private Long oid;
	@Column(name="FEC_RESU_PAGO_INTE")
	private java.sql.Timestamp fecha;
	@Column(name="FEC_INIC")
	private java.sql.Timestamp fechaInicio;
	@Column(name="FEC_FIN")
	private java.sql.Timestamp fechaFin;
	@Column(name="NUM_ITEM")
	private Long items;
	@Column(name="NUM_UNID_TOTA")
	private Long unidadTotales;
	@Column(name="VAL_PORC_SOBR_COST")
	private Integer porcentajeSobreCoste;
	@Column(name="VAL_MONT_TOTA")
	private java.math.BigDecimal montotal;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidCabeceraSolicitud;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSubac;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public java.sql.Timestamp getFechaInicio() {return fechaInicio;}
      
	public void setFechaInicio(java.sql.Timestamp fechaInicio){this.fechaInicio=fechaInicio;}
		
	public java.sql.Timestamp getFechaFin() {return fechaFin;}
      
	public void setFechaFin(java.sql.Timestamp fechaFin){this.fechaFin=fechaFin;}
		
	public Long getItems() {return items;}
      
	public void setItems(Long items){this.items=items;}
		
	public Long getUnidadTotales() {return unidadTotales;}
      
	public void setUnidadTotales(Long unidadTotales){this.unidadTotales=unidadTotales;}
		
	public Integer getPorcentajeSobreCoste() {return porcentajeSobreCoste;}
      
	public void setPorcentajeSobreCoste(Integer porcentajeSobreCoste){this.porcentajeSobreCoste=porcentajeSobreCoste;}
		
	public java.math.BigDecimal getMontotal() {return montotal;}
      
	public void setMontotal(java.math.BigDecimal montotal){this.montotal=montotal;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidCabeceraSolicitud() {return oidCabeceraSolicitud;}
      
	public void setOidCabeceraSolicitud(Long oidCabeceraSolicitud){this.oidCabeceraSolicitud=oidCabeceraSolicitud;}
		
	public Long getOidSubac() {return oidSubac;}
      
	public void setOidSubac(Long oidSubac){this.oidSubac=oidSubac;}
			
	
}
