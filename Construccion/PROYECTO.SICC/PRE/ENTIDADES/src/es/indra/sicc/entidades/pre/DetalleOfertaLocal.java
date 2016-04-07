package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_OFERT_DETAL")
@NamedQueries({
@NamedQuery(name="DetalleOfertaLocal.FindByOidOfer",query="SELECT OBJECT(a) "
+"FROM DetalleOfertaLocal AS a WHERE a.oidOfer = ?1"),
@NamedQuery(name="DetalleOfertaLocal.FindByOidOferOrde",query="SELECT OBJECT(a) "
+"FROM DetalleOfertaLocal AS a WHERE a.oidOfer = ?1 order by a.oid"),
@NamedQuery(name="DetalleOfertaLocal.FindByOfertaCV",query="SELECT OBJECT(a) "
+"FROM DetalleOfertaLocal AS a WHERE a.oidOfer = ?1 AND a.codigoVenta = ?2"),
@NamedQuery(name="DetalleOfertaLocal.FindByGrupo",query="SELECT OBJECT(a) "
+"FROM DetalleOfertaLocal AS a WHERE a.oidGrupOfer = ?1"),
@NamedQuery(name="DetalleOfertaLocal.FindByProducto",query="SELECT OBJECT(a) "
+" FROM DetalleOfertaLocal AS a WHERE a.oidProd = ?1"),
@NamedQuery(name="DetalleOfertaLocal.FindByCodigoVentaMFNoGenerada",query="SELECT OBJECT(a) "
+" FROM DetalleOfertaLocal AS a WHERE a.oidOfer = ?1 and a.codigoVenta is not null and "
+" (a.matrizGenerada = 0 or a.matrizGenerada is null)")
})
public class DetalleOfertaLocal implements Serializable {

	public DetalleOfertaLocal() {}

	public DetalleOfertaLocal(Long oid, Long ofer_oid_ofer, Long prod_oid_prod, 
                    Integer num_line_ofer, Integer val_fact_repe, Long tofe_oid_tipo_ofer,
                    Long civi_oid_ciclo_vida, Long oid_grup_ofert) {
	
		this.oid=oid;
                this.oidOfer=ofer_oid_ofer;
                this.oidProd=prod_oid_prod;
                this.lineaOferta=num_line_ofer;
                this.factorRepeticion=val_fact_repe;
                this.oidTipoOfer=tofe_oid_tipo_ofer;
                this.oidCicloVida=civi_oid_ciclo_vida;
                this.oidGrupOfer=oid_grup_ofert;
	
	}

	@Id
	@Column(name="OID_DETA_OFER")
	private Long oid;
	@Column(name="OFER_OID_OFER")
	private Long oidOfer;
	@Column(name="PROD_OID_PROD")
	private Long oidProd;
	@Column(name="NUM_LINE_OFER")
	private Integer lineaOferta;
	@Column(name="VAL_TEXT_BREV")
	private String textoBreve;
	@Column(name="NUM_UNID_ESTI")
	private Integer unidadesEstimadas;
	@Column(name="COD_ORIG")
	private String origen;
	@Column(name="VAL_FACT_REPE")
	private Integer factorRepeticion;
	@Column(name="NUM_POSI_RANK")
	private Integer posicionRanking;
	@Column(name="IND_PROD_PRIN")
	private Boolean productoPrincipal;
	@Column(name="IMP_PREC_CATA")
	private java.math.BigDecimal precioCatalogo;
	@Column(name="IMP_PREC_POSI")
	private java.math.BigDecimal precioPosicionamiento;
	@Column(name="IMP_COST_ESTA")
	private java.math.BigDecimal costeEstandar;
	@Column(name="IMP_VENT_NETA_ESTI")
	private java.math.BigDecimal ventaNetaEstimada;
	@Column(name="NUM_PAGI_CATA")
	private Integer numeroPaginaCatalogo;
	@Column(name="OCAT_OID_CATAL")
	private Long oidCatal;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long oidTipoOfer;
	@Column(name="CIVI_OID_CICLO_VIDA")
	private Long oidCicloVida;
	@Column(name="CNDP_OID_COND_PROM")
	private Long oidCondProm;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidFormPago;
	@Column(name="GOFE_OID_GRUP_OFER")
	private Long oidGrupOfer;
	@Column(name="IND_DIGI")
	private Boolean digitable;
	@Column(name="IND_IMPR_GP")
	private Boolean impresionGP;
	@Column(name="IND_CODI_VENT_GENE")
	private Boolean codigoVentaGenerado;
	@Column(name="IND_MATR_FACT_GENE")
	private Boolean matrizGenerada;
	@Column(name="VAL_POSI_PAGI")
	private Integer posicionPagina;
	@Column(name="VAL_CODI_VENT")
	private String codigoVenta;
	@Column(name="VAL_CENT")
	private String centro;
	@Column(name="NUM_PUNT_FIJO")
	private Integer puntajeFijo;
	@Column(name="VARI_OID_VARI")
	private Long variante;
	@Column(name="PRFI_OID_PROG_FIDE")
	private Long programaFidelizacion;
	@Column(name="PRECIO_UNITARIO")
	private java.math.BigDecimal precioUnitario;
	@Column(name="NUM_ORDE_DETA")
	private Integer numeroOrden;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidOfer() {return oidOfer;}
      
	public void setOidOfer(Long oidOfer){this.oidOfer=oidOfer;}
		
	public Long getOidProd() {return oidProd;}
      
	public void setOidProd(Long oidProd){this.oidProd=oidProd;}
		
	public Integer getLineaOferta() {return lineaOferta;}
      
	public void setLineaOferta(Integer lineaOferta){this.lineaOferta=lineaOferta;}
		
	public String getTextoBreve() {return textoBreve;}
      
	public void setTextoBreve(String textoBreve){this.textoBreve=textoBreve;}
		
	public Integer getUnidadesEstimadas() {return unidadesEstimadas;}
      
	public void setUnidadesEstimadas(Integer unidadesEstimadas){this.unidadesEstimadas=unidadesEstimadas;}
		
	public String getOrigen() {return origen;}
      
	public void setOrigen(String origen){this.origen=origen;}
		
	public Integer getFactorRepeticion() {return factorRepeticion;}
      
	public void setFactorRepeticion(Integer factorRepeticion){this.factorRepeticion=factorRepeticion;}
		
	public Integer getPosicionRanking() {return posicionRanking;}
      
	public void setPosicionRanking(Integer posicionRanking){this.posicionRanking=posicionRanking;}
		
	public Boolean getProductoPrincipal() {return productoPrincipal;}
      
	public void setProductoPrincipal(Boolean productoPrincipal){this.productoPrincipal=productoPrincipal;}
		
	public java.math.BigDecimal getPrecioCatalogo() {return precioCatalogo;}
      
	public void setPrecioCatalogo(java.math.BigDecimal precioCatalogo){this.precioCatalogo=precioCatalogo;}
		
	public java.math.BigDecimal getPrecioPosicionamiento() {return precioPosicionamiento;}
      
	public void setPrecioPosicionamiento(java.math.BigDecimal precioPosicionamiento){this.precioPosicionamiento=precioPosicionamiento;}
		
	public java.math.BigDecimal getCosteEstandar() {return costeEstandar;}
      
	public void setCosteEstandar(java.math.BigDecimal costeEstandar){this.costeEstandar=costeEstandar;}
		
	public java.math.BigDecimal getVentaNetaEstimada() {return ventaNetaEstimada;}
      
	public void setVentaNetaEstimada(java.math.BigDecimal ventaNetaEstimada){this.ventaNetaEstimada=ventaNetaEstimada;}
		
	public Integer getNumeroPaginaCatalogo() {return numeroPaginaCatalogo;}
      
	public void setNumeroPaginaCatalogo(Integer numeroPaginaCatalogo){this.numeroPaginaCatalogo=numeroPaginaCatalogo;}
		
	public Long getOidCatal() {return oidCatal;}
      
	public void setOidCatal(Long oidCatal){this.oidCatal=oidCatal;}
		
	public Long getOidTipoOfer() {return oidTipoOfer;}
      
	public void setOidTipoOfer(Long oidTipoOfer){this.oidTipoOfer=oidTipoOfer;}
		
	public Long getOidCicloVida() {return oidCicloVida;}
      
	public void setOidCicloVida(Long oidCicloVida){this.oidCicloVida=oidCicloVida;}
		
	public Long getOidCondProm() {return oidCondProm;}
      
	public void setOidCondProm(Long oidCondProm){this.oidCondProm=oidCondProm;}
		
	public Long getOidFormPago() {return oidFormPago;}
      
	public void setOidFormPago(Long oidFormPago){this.oidFormPago=oidFormPago;}
		
	public Long getOidGrupOfer() {return oidGrupOfer;}
      
	public void setOidGrupOfer(Long oidGrupOfer){this.oidGrupOfer=oidGrupOfer;}
		
	public Boolean getDigitable() {return digitable;}
      
	public void setDigitable(Boolean digitable){this.digitable=digitable;}
		
	public Boolean getImpresionGP() {return impresionGP;}
      
	public void setImpresionGP(Boolean impresionGP){this.impresionGP=impresionGP;}
		
	public Boolean getCodigoVentaGenerado() {return codigoVentaGenerado;}
      
	public void setCodigoVentaGenerado(Boolean codigoVentaGenerado){this.codigoVentaGenerado=codigoVentaGenerado;}
		
	public Boolean getMatrizGenerada() {return matrizGenerada;}
      
	public void setMatrizGenerada(Boolean matrizGenerada){this.matrizGenerada=matrizGenerada;}
		
	public Integer getPosicionPagina() {return posicionPagina;}
      
	public void setPosicionPagina(Integer posicionPagina){this.posicionPagina=posicionPagina;}
		
	public String getCodigoVenta() {return codigoVenta;}
      
	public void setCodigoVenta(String codigoVenta){this.codigoVenta=codigoVenta;}
		
	public String getCentro() {return centro;}
      
	public void setCentro(String centro){this.centro=centro;}
		
	public Integer getPuntajeFijo() {return puntajeFijo;}
      
	public void setPuntajeFijo(Integer puntajeFijo){this.puntajeFijo=puntajeFijo;}
		
	public Long getVariante() {return variante;}
      
	public void setVariante(Long variante){this.variante=variante;}
		
	public Long getProgramaFidelizacion() {return programaFidelizacion;}
      
	public void setProgramaFidelizacion(Long programaFidelizacion){this.programaFidelizacion=programaFidelizacion;}
		
	public java.math.BigDecimal getPrecioUnitario() {return precioUnitario;}
      
	public void setPrecioUnitario(java.math.BigDecimal precioUnitario){this.precioUnitario=precioUnitario;}
		
	public Integer getNumeroOrden() {return numeroOrden;}
      
	public void setNumeroOrden(Integer numeroOrden){this.numeroOrden=numeroOrden;}
			
	
}
