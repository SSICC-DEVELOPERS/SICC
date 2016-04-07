package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_TIPO_MOVIM_ALMAC")
public class TipoMovimientosAlmacenLocal implements Serializable {

	public TipoMovimientosAlmacenLocal() {}

        public TipoMovimientosAlmacenLocal(Long oid, Long pais, String codigoMovimiento, String codigoMovimientoSAP, 
                        Boolean movimientoEntreAlmacenes, Boolean mantieneMovimientos, Boolean indicadorSAP)      {
                this.oid=oid;
                this.pais = pais;
                this.codigoMovimiento = codigoMovimiento;
                this.codigoMovimientoSAP = codigoMovimientoSAP;
                this.movimientoEntreAlmacenes = movimientoEntreAlmacenes;
                this.mantieneMovimientos = mantieneMovimientos;
                this.indicadorSAP = indicadorSAP;
        }

	public TipoMovimientosAlmacenLocal(Long oid, Long pais, String codigoMovimiento, String codigoMovimientoSAP, 
                        Boolean movimientoEntreAlmacenes, Boolean mantieneMovimientos, Boolean indicadorSAP, Long estadoMercancia1, 
                        Long estadoMercancia2, Character operacion1, Character operacion2)	{
		this.oid=oid;
                this.pais = pais;
                this.codigoMovimiento = codigoMovimiento;
                this.codigoMovimientoSAP = codigoMovimientoSAP;
                this.movimientoEntreAlmacenes = movimientoEntreAlmacenes;
                this.mantieneMovimientos = mantieneMovimientos;
                this.indicadorSAP = indicadorSAP;
                this.estadoMercancia1 = estadoMercancia1;
                this.estadoMercancia2 = estadoMercancia2;
                this.operacion1 = operacion1;
                this.operacion2 = operacion2;
	}

	@Id
	@Column(name="OID_TIPO_MOVI_ALMA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_TIPO_MOVI")
	private String codigoMovimiento;
	@Column(name="COD_MOVI_SAP")
	private String codigoMovimientoSAP;
	@Column(name="IND_MOVI_ENTR_ALMA")
	private Boolean movimientoEntreAlmacenes;
	@Column(name="IND_MANT_MOVI")
	private Boolean mantieneMovimientos;
	@Column(name="IND_SAP")
	private Boolean indicadorSAP;
	@Column(name="ESME_OID_ESTA_MERC_1")
	private Long estadoMercancia1;
	@Column(name="ESME_OID_ESTA_MERC_2")
	private Long estadoMercancia2;
	@Column(name="COD_OPER_1")
	private Character operacion1;
	@Column(name="COD_OPER_2")
	private Character operacion2;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoMovimiento() {return codigoMovimiento;}
      
	public void setCodigoMovimiento(String codigoMovimiento){this.codigoMovimiento=codigoMovimiento;}
		
	public String getCodigoMovimientoSAP() {return codigoMovimientoSAP;}
      
	public void setCodigoMovimientoSAP(String codigoMovimientoSAP){this.codigoMovimientoSAP=codigoMovimientoSAP;}
		
	public Boolean getMovimientoEntreAlmacenes() {return movimientoEntreAlmacenes;}
      
	public void setMovimientoEntreAlmacenes(Boolean movimientoEntreAlmacenes){this.movimientoEntreAlmacenes=movimientoEntreAlmacenes;}
		
	public Boolean getMantieneMovimientos() {return mantieneMovimientos;}
      
	public void setMantieneMovimientos(Boolean mantieneMovimientos){this.mantieneMovimientos=mantieneMovimientos;}
		
	public Boolean getIndicadorSAP() {return indicadorSAP;}
      
	public void setIndicadorSAP(Boolean indicadorSAP){this.indicadorSAP=indicadorSAP;}
		
	public Long getEstadoMercancia1() {return estadoMercancia1;}
      
	public void setEstadoMercancia1(Long estadoMercancia1){this.estadoMercancia1=estadoMercancia1;}
		
	public Long getEstadoMercancia2() {return estadoMercancia2;}
      
	public void setEstadoMercancia2(Long estadoMercancia2){this.estadoMercancia2=estadoMercancia2;}
		
	public Character getOperacion1() {return operacion1;}
      
	public void setOperacion1(Character operacion1){this.operacion1=operacion1;}
		
	public Character getOperacion2() {return operacion2;}
      
	public void setOperacion2(Character operacion2){this.operacion2=operacion2;}
			
	
}
