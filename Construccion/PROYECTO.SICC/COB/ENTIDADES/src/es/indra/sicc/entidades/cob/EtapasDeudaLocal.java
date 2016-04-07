package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="COB_ETAPA_DEUDA")
@NamedQueries({
@NamedQuery(name="EtapasDeudaLocal.FindAll",query="select object(o) from EtapasDeudaLocal o")
})
public class EtapasDeudaLocal implements Serializable {

	public EtapasDeudaLocal() {}

	public EtapasDeudaLocal(Long oid, String codigoEtapaDeuda, String descripcion, Long edadInicial, Long edadFinal, Boolean indTelefono, Long ordenamientoGestion1, BigDecimal importeDesde, BigDecimal importeHasta, Long diasGraciaCompromisosPago, BigDecimal porcentajeIncumplidas, Long pais)	{
	
		this.oid=oid;
                this.setCodigoEtapaDeuda(codigoEtapaDeuda);
	        this.setDescripcion(descripcion);
	        this.setEdadInicial(edadInicial);
	        this.setEdadFinal(edadFinal);
	        this.setIndTelefono(indTelefono);
	        this.setOrdenamientoGestion1(ordenamientoGestion1);
	        this.setImporteDesde(importeDesde);
	        this.setImporteHasta(importeHasta);
	        this.setDiasGraciaCompromisosPago(diasGraciaCompromisosPago);
	        this.setPorcentajeIncumplidas(porcentajeIncumplidas);
	        this.setPais(pais);
	
	}

	@Id
	@Column(name="OID_ETAP_DEUD")
	private Long oid;
	@Column(name="COD_ETAP_DEUD")
	private String codigoEtapaDeuda;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="IND_EXCL")
	private Boolean indicadorExclusiva;
	@Column(name="VAL_EDAD_INIC")
	private Long edadInicial;
	@Column(name="VAL_EDAD_FINA")
	private Long edadFinal;
	@Column(name="IND_TELF")
	private Boolean indTelefono;
	@Column(name="ORED_OID_ETAP_DEU1")
	private Long ordenamientoGestion1;
	@Column(name="ORED_OID_ETAP_DEU2")
	private Long ordenamientoGestion2;
	@Column(name="ORED_OID_ETAP_DEU3")
	private Long ordenamientoGestion3;
	@Column(name="IMP_DESD")
	private java.math.BigDecimal importeDesde;
	@Column(name="IMP_HAST")
	private java.math.BigDecimal importeHasta;
	@Column(name="NUM_DIAS_GRAC_COMP_PAGO")
	private Long diasGraciaCompromisosPago;
	@Column(name="VAL_PORC_INCU")
	private java.math.BigDecimal porcentajeIncumplidas;
	@Column(name="MENS_OID_MENS")
	private Long mensaje;
	@Column(name="MELC_OID_METO_LIQU_COBR")
	private Long metodoLiquidacionDefecto;
	@Column(name="TBAL_OID_TIPO_BALA")
	private Long tipoBalanceo;
	@Column(name="GACA_OID_GUIO_ARGU_CABE")
	private Long guiaArgumentalDefecto;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoEtapaDeuda() {return codigoEtapaDeuda;}
      
	public void setCodigoEtapaDeuda(String codigoEtapaDeuda){this.codigoEtapaDeuda=codigoEtapaDeuda;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getIndicadorExclusiva() {return indicadorExclusiva;}
      
	public void setIndicadorExclusiva(Boolean indicadorExclusiva){this.indicadorExclusiva=indicadorExclusiva;}
		
	public Long getEdadInicial() {return edadInicial;}
      
	public void setEdadInicial(Long edadInicial){this.edadInicial=edadInicial;}
		
	public Long getEdadFinal() {return edadFinal;}
      
	public void setEdadFinal(Long edadFinal){this.edadFinal=edadFinal;}
		
	public Boolean getIndTelefono() {return indTelefono;}
      
	public void setIndTelefono(Boolean indTelefono){this.indTelefono=indTelefono;}
		
	public Long getOrdenamientoGestion1() {return ordenamientoGestion1;}
      
	public void setOrdenamientoGestion1(Long ordenamientoGestion1){this.ordenamientoGestion1=ordenamientoGestion1;}
		
	public Long getOrdenamientoGestion2() {return ordenamientoGestion2;}
      
	public void setOrdenamientoGestion2(Long ordenamientoGestion2){this.ordenamientoGestion2=ordenamientoGestion2;}
		
	public Long getOrdenamientoGestion3() {return ordenamientoGestion3;}
      
	public void setOrdenamientoGestion3(Long ordenamientoGestion3){this.ordenamientoGestion3=ordenamientoGestion3;}
		
	public java.math.BigDecimal getImporteDesde() {return importeDesde;}
      
	public void setImporteDesde(java.math.BigDecimal importeDesde){this.importeDesde=importeDesde;}
		
	public java.math.BigDecimal getImporteHasta() {return importeHasta;}
      
	public void setImporteHasta(java.math.BigDecimal importeHasta){this.importeHasta=importeHasta;}
		
	public Long getDiasGraciaCompromisosPago() {return diasGraciaCompromisosPago;}
      
	public void setDiasGraciaCompromisosPago(Long diasGraciaCompromisosPago){this.diasGraciaCompromisosPago=diasGraciaCompromisosPago;}
		
	public java.math.BigDecimal getPorcentajeIncumplidas() {return porcentajeIncumplidas;}
      
	public void setPorcentajeIncumplidas(java.math.BigDecimal porcentajeIncumplidas){this.porcentajeIncumplidas=porcentajeIncumplidas;}
		
	public Long getMensaje() {return mensaje;}
      
	public void setMensaje(Long mensaje){this.mensaje=mensaje;}
		
	public Long getMetodoLiquidacionDefecto() {return metodoLiquidacionDefecto;}
      
	public void setMetodoLiquidacionDefecto(Long metodoLiquidacionDefecto){this.metodoLiquidacionDefecto=metodoLiquidacionDefecto;}
		
	public Long getTipoBalanceo() {return tipoBalanceo;}
      
	public void setTipoBalanceo(Long tipoBalanceo){this.tipoBalanceo=tipoBalanceo;}
		
	public Long getGuiaArgumentalDefecto() {return guiaArgumentalDefecto;}
      
	public void setGuiaArgumentalDefecto(Long guiaArgumentalDefecto){this.guiaArgumentalDefecto=guiaArgumentalDefecto;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
