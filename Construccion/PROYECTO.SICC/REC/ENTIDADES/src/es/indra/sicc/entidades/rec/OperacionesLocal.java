package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_OPERA")
@NamedQueries({
@NamedQuery(name="OperacionesLocal.FindAll",query="select object(o) from OperacionesLocal o")
})
public class OperacionesLocal implements Serializable {

	public OperacionesLocal() {}

	public OperacionesLocal(Long oid, String codOperacion, String descripcionLarga, Boolean anulacion, Long pais, Long precios, Boolean recojo)	{
	
		this.oid=oid;
                this.codOperacion=codOperacion;
                this.descripcionLarga=descripcionLarga;
                this.anulacion=anulacion;
                this.pais=pais;
                this.precios=precios;
                this.recojo=recojo;
	
	}

	@Id
	@Column(name="OID_OPER")
	private Long oid;
	@Column(name="COD_OPER")
	private String codOperacion;
	@Column(name="VAL_DESC_LARG")
	private String descripcionLarga;
	@Column(name="IND_ANUL")
	private Boolean anulacion;
	@Column(name="IND_INGR_ENVI")
	private Boolean ingresaEnvia;
	@Column(name="VAL_INGR_DEVU")
	private Boolean ingresaDevuelve;
	@Column(name="VAL_PERD")
	private Boolean perdida;
	@Column(name="IND_ESPE_MERC_FISI")
	private Boolean esperarMercaderiaFisica;
	@Column(name="IND_DEVU_FISI_FACT")
	private Boolean devueltoFisicoEnFactura;
	@Column(name="NUM_CAMP_HIST")
	private Integer numeroCampanias;
	@Column(name="IND_ENVI_GENE_DEVU")
	private Boolean enviaGeneraDevuelve;
	@Column(name="IND_DEVU_GENE_ENVI")
	private Boolean devuelveGeneraEnvia;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="PECI_OID_PECI")
	private Long precios;
	@Column(name="MENS_OID_MENS")
	private Long mensajeTs2;
	@Column(name="TSPA_OID_SOLI_CON_STOC")
	private Long tipoSolicitud1;
	@Column(name="TSPA_OID_SOLI_PAIS_PERD")
	private Long tipoSolicitudPerdida;
	@Column(name="TMAL_OID_TIPO_MOVI_ALMA")
	private Long movimientoAlmacen;
	@Column(name="MDEF_OID_MODO_ABON_DEFE")
	private Long modoAbonoDefecto;
	@Column(name="PENV_OID_PRECIO_ENVIA")
	private Long precioEnvia;
	@Column(name="TSPA_OID_SOLI_PAIS_GENE")
	private Long tipoSolicitudGenera;
	@Column(name="MOBL_OID_MOTI_BLOQ")
	private Long bloqueoChequeo;
	@Column(name="IND_FALT_MERC")
	private Boolean faltanteMercaderia;
	@Column(name="TSPA_OID_SOLI_SIN_STOC")
	private Long tipoSolicitud2;
	@Column(name="IND_RECO")
	private Boolean recojo;
	@Column(name="TSPA_OID_TIPO_SOLI_REC_INIC")
	private Long tipoSolicitudRecojoInicial;
	@Column(name="TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")
	private Long tipoSolicitudPrimerRecojoNoExitoso;
	@Column(name="TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")
	private Long tipoSolicitudSegundoRecojoNoExitoso;
	@Column(name="ALMC_OID_ALMA_POSV")
	private Long almacenPostVenta;
	@Column(name="TMAL_OID_TIPO_ALMA_REC_INIC")
	private Long movimientoAlmacenRecojoInicial;
	@Column(name="TMAL_OID_TIPO_ALMA_REC_EXIT")
	private Long movimientoAlmacenRecojoExitoso;
	@Column(name="TMAL_OID_TIPO_ALMA_REC_NO_EXIT")
	private Long movimientoAlmacenRecojoNoExitoso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodOperacion() {return codOperacion;}
      
	public void setCodOperacion(String codOperacion){this.codOperacion=codOperacion;}
		
	public String getDescripcionLarga() {return descripcionLarga;}
      
	public void setDescripcionLarga(String descripcionLarga){this.descripcionLarga=descripcionLarga;}
		
	public Boolean getAnulacion() {return anulacion;}
      
	public void setAnulacion(Boolean anulacion){this.anulacion=anulacion;}
		
	public Boolean getIngresaEnvia() {return ingresaEnvia;}
      
	public void setIngresaEnvia(Boolean ingresaEnvia){this.ingresaEnvia=ingresaEnvia;}
		
	public Boolean getIngresaDevuelve() {return ingresaDevuelve;}
      
	public void setIngresaDevuelve(Boolean ingresaDevuelve){this.ingresaDevuelve=ingresaDevuelve;}
		
	public Boolean getPerdida() {return perdida;}
      
	public void setPerdida(Boolean perdida){this.perdida=perdida;}
		
	public Boolean getEsperarMercaderiaFisica() {return esperarMercaderiaFisica;}
      
	public void setEsperarMercaderiaFisica(Boolean esperarMercaderiaFisica){this.esperarMercaderiaFisica=esperarMercaderiaFisica;}
		
	public Boolean getDevueltoFisicoEnFactura() {return devueltoFisicoEnFactura;}
      
	public void setDevueltoFisicoEnFactura(Boolean devueltoFisicoEnFactura){this.devueltoFisicoEnFactura=devueltoFisicoEnFactura;}
		
	public Integer getNumeroCampanias() {return numeroCampanias;}
      
	public void setNumeroCampanias(Integer numeroCampanias){this.numeroCampanias=numeroCampanias;}
		
	public Boolean getEnviaGeneraDevuelve() {return enviaGeneraDevuelve;}
      
	public void setEnviaGeneraDevuelve(Boolean enviaGeneraDevuelve){this.enviaGeneraDevuelve=enviaGeneraDevuelve;}
		
	public Boolean getDevuelveGeneraEnvia() {return devuelveGeneraEnvia;}
      
	public void setDevuelveGeneraEnvia(Boolean devuelveGeneraEnvia){this.devuelveGeneraEnvia=devuelveGeneraEnvia;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getPrecios() {return precios;}
      
	public void setPrecios(Long precios){this.precios=precios;}
		
	public Long getMensajeTs2() {return mensajeTs2;}
      
	public void setMensajeTs2(Long mensajeTs2){this.mensajeTs2=mensajeTs2;}
		
	public Long getTipoSolicitud1() {return tipoSolicitud1;}
      
	public void setTipoSolicitud1(Long tipoSolicitud1){this.tipoSolicitud1=tipoSolicitud1;}
		
	public Long getTipoSolicitudPerdida() {return tipoSolicitudPerdida;}
      
	public void setTipoSolicitudPerdida(Long tipoSolicitudPerdida){this.tipoSolicitudPerdida=tipoSolicitudPerdida;}
		
	public Long getMovimientoAlmacen() {return movimientoAlmacen;}
      
	public void setMovimientoAlmacen(Long movimientoAlmacen){this.movimientoAlmacen=movimientoAlmacen;}
		
	public Long getModoAbonoDefecto() {return modoAbonoDefecto;}
      
	public void setModoAbonoDefecto(Long modoAbonoDefecto){this.modoAbonoDefecto=modoAbonoDefecto;}
		
	public Long getPrecioEnvia() {return precioEnvia;}
      
	public void setPrecioEnvia(Long precioEnvia){this.precioEnvia=precioEnvia;}
		
	public Long getTipoSolicitudGenera() {return tipoSolicitudGenera;}
      
	public void setTipoSolicitudGenera(Long tipoSolicitudGenera){this.tipoSolicitudGenera=tipoSolicitudGenera;}
		
	public Long getBloqueoChequeo() {return bloqueoChequeo;}
      
	public void setBloqueoChequeo(Long bloqueoChequeo){this.bloqueoChequeo=bloqueoChequeo;}
		
	public Boolean getFaltanteMercaderia() {return faltanteMercaderia;}
      
	public void setFaltanteMercaderia(Boolean faltanteMercaderia){this.faltanteMercaderia=faltanteMercaderia;}
		
	public Long getTipoSolicitud2() {return tipoSolicitud2;}
      
	public void setTipoSolicitud2(Long tipoSolicitud2){this.tipoSolicitud2=tipoSolicitud2;}
		
	public Boolean getRecojo() {return recojo;}
      
	public void setRecojo(Boolean recojo){this.recojo=recojo;}
		
	public Long getTipoSolicitudRecojoInicial() {return tipoSolicitudRecojoInicial;}
      
	public void setTipoSolicitudRecojoInicial(Long tipoSolicitudRecojoInicial){this.tipoSolicitudRecojoInicial=tipoSolicitudRecojoInicial;}
		
	public Long getTipoSolicitudPrimerRecojoNoExitoso() {return tipoSolicitudPrimerRecojoNoExitoso;}
      
	public void setTipoSolicitudPrimerRecojoNoExitoso(Long tipoSolicitudPrimerRecojoNoExitoso){this.tipoSolicitudPrimerRecojoNoExitoso=tipoSolicitudPrimerRecojoNoExitoso;}
		
	public Long getTipoSolicitudSegundoRecojoNoExitoso() {return tipoSolicitudSegundoRecojoNoExitoso;}
      
	public void setTipoSolicitudSegundoRecojoNoExitoso(Long tipoSolicitudSegundoRecojoNoExitoso){this.tipoSolicitudSegundoRecojoNoExitoso=tipoSolicitudSegundoRecojoNoExitoso;}
		
	public Long getAlmacenPostVenta() {return almacenPostVenta;}
      
	public void setAlmacenPostVenta(Long almacenPostVenta){this.almacenPostVenta=almacenPostVenta;}
		
	public Long getMovimientoAlmacenRecojoInicial() {return movimientoAlmacenRecojoInicial;}
      
	public void setMovimientoAlmacenRecojoInicial(Long movimientoAlmacenRecojoInicial){this.movimientoAlmacenRecojoInicial=movimientoAlmacenRecojoInicial;}
		
	public Long getMovimientoAlmacenRecojoExitoso() {return movimientoAlmacenRecojoExitoso;}
      
	public void setMovimientoAlmacenRecojoExitoso(Long movimientoAlmacenRecojoExitoso){this.movimientoAlmacenRecojoExitoso=movimientoAlmacenRecojoExitoso;}
		
	public Long getMovimientoAlmacenRecojoNoExitoso() {return movimientoAlmacenRecojoNoExitoso;}
      
	public void setMovimientoAlmacenRecojoNoExitoso(Long movimientoAlmacenRecojoNoExitoso){this.movimientoAlmacenRecojoNoExitoso=movimientoAlmacenRecojoNoExitoso;}
			
	
}
