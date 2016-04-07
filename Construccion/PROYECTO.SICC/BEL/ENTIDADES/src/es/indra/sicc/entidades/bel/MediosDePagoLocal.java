package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_MEDIO_PAGO")
@NamedQueries({
@NamedQuery(name="MediosDePagoLocal.FindByUK",query="SELECT OBJECT(a) FROM MediosDePagoLocal AS a WHERE a.pais=?1 AND a.codigoMedioPago=?2")
})
public class MediosDePagoLocal implements Serializable {

	public MediosDePagoLocal() {}

	public MediosDePagoLocal(Long oid, Long pais, String codigoMedioPago, Long tipoMedioPago) {
		this.oid=oid;
                this.pais = pais;
                this.codigoMedioPago = codigoMedioPago;
                this.tipoMedioPago = tipoMedioPago;
	}

	@Id
	@Column(name="OID_MEDI_PAGO")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_MEDI_PAGO")
	private String codigoMedioPago;
	@Column(name="TMEP_OID_TIPO_MEDI_PAGO")
	private Long tipoMedioPago;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoMedioPago() {return codigoMedioPago;}
      
	public void setCodigoMedioPago(String codigoMedioPago){this.codigoMedioPago=codigoMedioPago;}
		
	public Long getTipoMedioPago() {return tipoMedioPago;}
      
	public void setTipoMedioPago(Long tipoMedioPago){this.tipoMedioPago=tipoMedioPago;}
			
	
}
