package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_JERAR")
public class JerarquiasLocal implements Serializable {

	public JerarquiasLocal() {}

	public JerarquiasLocal(Long oid, String cod_jera, Long num_dias, Float val_porc_mont_maxi, Float val_porc_line_cred)	{
	
		this.oid=oid;
	        this.setCodigoJeraquia(cod_jera);
	        this.setNumeroDias(num_dias);
	        this.setPorcentajeMontoMaximo(val_porc_mont_maxi);
	        this.setPorcentajeLineCredito(val_porc_line_cred);
	
	}

	@Id
	@Column(name="OID_JERA")
	private Long oid;
	@Column(name="COD_JERA")
	private String codigoJeraquia;
	@Column(name="NUM_DIAS")
	private Long numeroDias;
	@Column(name="VAL_PORC_MONT_MAXI")
	private Float porcentajeMontoMaximo;
	@Column(name="VAL_PORC_LINE_CRED")
	private Float porcentajeLineCredito;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoJeraquia() {return codigoJeraquia;}
      
	public void setCodigoJeraquia(String codigoJeraquia){this.codigoJeraquia=codigoJeraquia;}
		
	public Long getNumeroDias() {return numeroDias;}
      
	public void setNumeroDias(Long numeroDias){this.numeroDias=numeroDias;}
		
	public Float getPorcentajeMontoMaximo() {return porcentajeMontoMaximo;}
      
	public void setPorcentajeMontoMaximo(Float porcentajeMontoMaximo){this.porcentajeMontoMaximo=porcentajeMontoMaximo;}
		
	public Float getPorcentajeLineCredito() {return porcentajeLineCredito;}
      
	public void setPorcentajeLineCredito(Float porcentajeLineCredito){this.porcentajeLineCredito=porcentajeLineCredito;}
			
	
}
