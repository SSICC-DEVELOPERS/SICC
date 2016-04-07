package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_FORMA_PAGO_DETAL")
@NamedQueries({
@NamedQuery(name="FormaPagoDetalleLocal.FindByFormaPagoCabecera",query="SELECT OBJECT(a) FROM FormaPagoDetalleLocal AS a WHERE a.formaPagoCabecera=?1")
})
public class FormaPagoDetalleLocal implements Serializable {

	public FormaPagoDetalleLocal() {}

	public FormaPagoDetalleLocal(Long oid, Long formaPagoCabecera, Integer porcentaje, Character indicadorDeDias, Integer posicionDetalle, Long medioDePago)	{
                this.oid = oid;
                this.formaPagoCabecera = formaPagoCabecera;
                this.porcentaje = porcentaje;
                this.indicadorDeDias = indicadorDeDias;
                this.posicionDetalle = posicionDetalle;
                this.medioDePago = medioDePago;
        }
        
        public FormaPagoDetalleLocal(Long oid, Long formaPagoCabecera, Integer porcentaje, Character indicadorDeDias, Integer posicionDetalle, Long medioDePago, Long actividad,Integer numeroDeDias) {
                this.oid = oid;
                this.formaPagoCabecera = formaPagoCabecera;
                this.porcentaje = porcentaje;
                this.indicadorDeDias = indicadorDeDias;
                this.posicionDetalle = posicionDetalle;
                this.medioDePago = medioDePago;
                this.actividad = actividad;
                this.numeroDeDias = numeroDeDias;
        }

	@Id
	@Column(name="OID_FORM_PAGO_DETA")
	private Long oid;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long formaPagoCabecera;
	@Column(name="VAL_PORC_PAGO")
	private Integer porcentaje;
	@Column(name="COD_INDI_DIAS")
	private Character indicadorDeDias;
	@Column(name="NUM_DIAS")
	private Integer numeroDeDias;
	@Column(name="NUM_POSI_DETA")
	private Integer posicionDetalle;
	@Column(name="CACT_OID_ACTI")
	private Long actividad;
	@Column(name="MPAB_OID_MEDI_PAGO")
	private Long medioDePago;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getFormaPagoCabecera() {return formaPagoCabecera;}
      
	public void setFormaPagoCabecera(Long formaPagoCabecera){this.formaPagoCabecera=formaPagoCabecera;}
		
	public Integer getPorcentaje() {return porcentaje;}
      
	public void setPorcentaje(Integer porcentaje){this.porcentaje=porcentaje;}
		
	public Character getIndicadorDeDias() {return indicadorDeDias;}
      
	public void setIndicadorDeDias(Character indicadorDeDias){this.indicadorDeDias=indicadorDeDias;}
		
	public Integer getNumeroDeDias() {return numeroDeDias;}
      
	public void setNumeroDeDias(Integer numeroDeDias){this.numeroDeDias=numeroDeDias;}
		
	public Integer getPosicionDetalle() {return posicionDetalle;}
      
	public void setPosicionDetalle(Integer posicionDetalle){this.posicionDetalle=posicionDetalle;}
		
	public Long getActividad() {return actividad;}
      
	public void setActividad(Long actividad){this.actividad=actividad;}
		
	public Long getMedioDePago() {return medioDePago;}
      
	public void setMedioDePago(Long medioDePago){this.medioDePago=medioDePago;}
			
	
}
