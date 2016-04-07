/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipante;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOIncrementoPorRango;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta;
import es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOMetasTipoVenta;
import es.indra.sicc.dtos.inc.DTOMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOParametrosCalificacion;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOVariablesVentaProyectada;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
 
/**
 * Sistema:     Belcorp
 * Modulo:      INC
 * Fecha:        04/05/2005
 * @version     
 * @autor        Marcelo J. Maidana
 */
public class LPMantenerParametrosCalificacion extends LPIncentivos{ 
    private static final String CHAR_SEPARADOR_LISTAS = "~";
    private static final String CHAR_SEPARADOR_LINEAS = "|";
    private static final String CHAR_SEPARADOR_CAMPOS = ",";
    private static final int INDICE_LISTA_CALIFICACION_PARTICIPANTES = 0;
    private static final int INDICE_LISTA_PARTICIPANTES = 1;
    private static final int INDICE_LISTA_ESTATUS_VENTA = 2;
    private static final int FLAG_CLIENTES = 0;
    private static final int FLAG_PERIODOS = 1;
    private static final int FLAG_PROYECTADA = 1;
    private static final int FLAG_TIPO_VENTA = 0;
    private String oidParamCalificacion;
    private String oidTipoVentaCalificacion;
    private String datosObligatorios;
    private DTOPais paisInstancia;
    private String periodoEvaluacionDesde;
    private String periodoEvaluacionHasta;
    private String oidDirigidoA;
    private String metasModificables;
    private String bloquearMetas;
    private String comunicaciones;
    private String mensaje;
    private String tipoVentaHistorica;
    private String tipoVentaIncremental;
    private String tipoDeterminacionMetas;
    private String devoluciones;
    private String anulaciones;
    private String faltantesNoAnunciados;
    private String formaCalculo;
    private String tipoIncremento;
    private String valorIncremento;
    private BigDecimal bdValorIncremento;    
    private String sListaMetasTipoVenta;
    private ArrayList listaMetasTipoVenta;  
    private ArrayList listasCalificacion;
    private ArrayList lstEstatusVenta;
    private ArrayList lstIncrementosPorRango;
    private Collection cIdiomas;
    private String sLstIncrementosPorRango;  
    //Corresponde al ArrayList listasCalificacion
    private String sListasCalificacion;  
    //Flag para configurar menu de Variables Venta proyectada.
    private String menuVariablesVentaProyectada;
    //true == modo debug valores hardcodeados
    boolean $DEBUG = false;
    //Variables usadas por modal "Mantener metas"
    private String sOid;
    private String sCliente;
    private String sActivas;
    private String sIngresos;
    private String sReingresos;
    private String sEgresos;
    private String sEntregadas;
    private String sRecibidas;
    private String sCapitalizacion;
    private String sActFinales;
    private String sActividad;
    private String sPedidos;
    private String sPrecioPromUnitario;
    private String sPromedioVtaPedido;
    private String sPromUnidadesPedido;
    private String sPromOrdenesPedido;
    private String sRetencion;
    private String sVentasEstadisticab;
    //Cleal - 21857
    private DTOListaEstatusVenta dtoListaEstatusVtaCalifAuxiliar = new DTOListaEstatusVenta();	
	//Agregado por Cristian Valenzuela - 24/2/2006
	private DTOListaMetasVentaProyectada dtoListaMetasAuxiliarSubgerencia;
	private DTOListaMetasVentaProyectada dtoListaMetasAuxiliarRegion;
	private DTOListaMetasVentaProyectada dtoListaMetasAuxiliarZona;
	//FIN - Agregado por Cristian Valenzuela - 24/2/2006
	//Agregado por Cristian Valenzuela - 6/4/2006
	private DTOListaMetasTipoVenta dtoListaMetasTipoVentaSesion;
	//FIN - Agregado por Cristian Valenzuela - 6/4/2006

    public LPMantenerParametrosCalificacion(){super();}

    public void inicio() throws Exception {
         this.pagina("contenido_parametros_calificacion_mantener");
         getFormatosValidaciones();
		 asignarAtributo("VAR", "hFormatoDef", "valor", 
		 (new Integer(this.FORMATO_DEFAULT)).toString());
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void ejecucion() throws Exception {  
         this.setTrazaFichero();  
         traza("LPMantenerParametrosCalificacion.ejecucion() - Entrada");
  
         try {
             this.obtenerFlagsPestanyas();    
             this.accion = this.conectorParametro("accion");
             this.opcionMenu = this.conectorParametro("opcionMenu");
             traza("opcionMenu: " + opcionMenu);
             this.datosObligatorios = this.conectorParametro("datosObligatorios");  
             this.idPestanyaDest = this.conectorParametro("idPestanyaDest");
  
             //Inicializacion de flags para configuracion de menu secundario en modales.
             menuVariablesVentaProyectada = "";
  
             oidParamCalificacion = this.conectorParametro("oidParamCalificacion");
             oidTipoVentaCalificacion = this.conectorParametro("oidTipoVentaCalificacion");
             periodoEvaluacionDesde = this.conectorParametro("hPeriodoEvaluacionDesde");
             periodoEvaluacionHasta = this.conectorParametro("hPeriodoEvaluacionHasta");
             oidDirigidoA = this.conectorParametro("oidDirigidoA");
             metasModificables = this.conectorParametro("hMetasModificables");
             bloquearMetas = this.conectorParametro("hBloquearMetas");
             comunicaciones = this.conectorParametro("hComunicaciones");
             mensaje = this.conectorParametro("txtMensaje");
             tipoVentaHistorica = this.conectorParametro("hTipoVentaHistorica");
             tipoVentaIncremental = this.conectorParametro("hTipoVentaIncremental");
             tipoDeterminacionMetas = this.conectorParametro("hTipoDeterminacionMetas");
             devoluciones = this.conectorParametro("hDevoluciones");
             anulaciones = this.conectorParametro("hAnulaciones");
             faltantesNoAnunciados = this.conectorParametro("hFaltantesNoAnunciados");
             formaCalculo = this.conectorParametro("hFormaCalculo");
             tipoIncremento = this.conectorParametro("hTipoIncremento");
             valorIncremento = conectorParametroNumero("txtValorIncremento", FORMATO_DEFAULT);

             traza("oidParamCalificacion: " + oidParamCalificacion);
             traza("oidTipoVentaCalificacion: " + oidTipoVentaCalificacion);
             traza("periodoEvaluacionDesde: " + periodoEvaluacionDesde);
             traza("periodoEvaluacionHasta: " + periodoEvaluacionHasta);
             traza("oidDirigidoA: " + oidDirigidoA);
             traza("metasModificables: " + metasModificables);
             traza("bloquearMetas: " + bloquearMetas);
             traza("comunicaciones: " + comunicaciones);
             traza("mensaje: " + mensaje);
             traza("tipoVentaHistorica: " + tipoVentaHistorica);
             traza("tipoVentaIncremental: " + tipoVentaIncremental);
             traza("tipoDeterminacionMetas: " + tipoDeterminacionMetas);
             traza("devoluciones: " + devoluciones);
             traza("anulaciones: " + anulaciones);
             traza("faltantesNoAnunciados: " + faltantesNoAnunciados);
             traza("formaCalculo: " + formaCalculo);
             traza("tipoIncremento: " + tipoIncremento);
             traza("valorIncremento: " + valorIncremento);

             sLstIncrementosPorRango = this.conectorParametro("listaIncrementosPorRango");

             //Variables usadas por modal "Mantener metas"
             sOid = this.conectorParametroLimpia("oid", "", true);
             sCliente = this.conectorParametroLimpia("cliente", "", true);
             sActivas = this.conectorParametroLimpia("activas", "", true);
             sIngresos = this.conectorParametroLimpia("ingresos", "", true);
             sReingresos = this.conectorParametroLimpia("reingresos", "", true);
             sEgresos = this.conectorParametroLimpia("egresos", "", true);
             sEntregadas = this.conectorParametroLimpia("entregadas", "", true);
             sRecibidas = this.conectorParametroLimpia("recibidas", "", true);
             sCapitalizacion = this.conectorParametroLimpia("capitalizacion", "", true);
             sActFinales = this.conectorParametroLimpia("actFinales", "", true);
             sActividad = this.conectorParametroLimpia("actividad", "", true);
             sPedidos = this.conectorParametroLimpia("pedidos", "", true);
             sPrecioPromUnitario = this.conectorParametroLimpia("precioPromUnitario", "", true);
             sPromedioVtaPedido = this.conectorParametroLimpia("promedioVtaPedido", "", true);
             sPromUnidadesPedido = this.conectorParametroLimpia("promUnidadesPedido", "", true);
             sPromOrdenesPedido = this.conectorParametroLimpia("promOrdenesPedido", "", true);
             sRetencion = this.conectorParametroLimpia("retencion", "", true);
             sVentasEstadisticab = this.conectorParametroLimpia("ventasEstadisticab", "", true);

             traza("************ sOid " + sOid);
             traza("************ sCliente " + sCliente);
             traza("************ sActivas " + sActivas);
             traza("************ sIngresos " + sIngresos);
             traza("************ sReingresos " + sReingresos);
             traza("************ sEgresos " + sEgresos);
             traza("************ sEntregadas " + sEntregadas);
             traza("************ sRecibidas " + sRecibidas);
             traza("************ sCapitalizacion " + sCapitalizacion);
             traza("************ sActFinales " + sActFinales);
             traza("************ sActividad " + sActividad);
             traza("************ sPedidos " + sPedidos);
             traza("************ sPrecioPromUnitario " + sPrecioPromUnitario);
             traza("************ sPromedioVtaPedido " + sPromedioVtaPedido);
             traza("************ sPromUnidadesPedido " + sPromUnidadesPedido);
             traza("************ sPromOrdenesPedido " + sPromOrdenesPedido);
             traza("************ sRetencion " + sRetencion);
             traza("************ sVentasEstadisticab " + sVentasEstadisticab);
             traza("LPMantenerParametrosCalificacion - 2");           

             //Se obtiene listasCalificacion, que contiene
             //listaCalificacionParticipantes, listaParticipantes, lstEstatusVenta.
             //Los datos se obtienen de la modal Participantes.
             //Formato: xx,xx|xx,xx|..~xx,xx|xx,xx|..~xx,xx|xx,xx|..
             sListasCalificacion = this.conectorParametro("listasCalificacion");
      
             //Cleal
             listasCalificacion = this.obtenerListaCalificacion(sListasCalificacion);
             traza("Listas parseadas: "+listasCalificacion);
             traza("sListasCalificacion: " + sListasCalificacion);

             //Obtencion de listas de modales
             sListaMetasTipoVenta = this.conectorParametro("listaMetasTipoVenta");

             try {
                  bdValorIncremento = valorIncremento != null ? new BigDecimal(valorIncremento) : null;
             }
			 catch (NumberFormatException nfe){
                  traza("Exception: NumberFormatException");
             }
			 catch (Exception e){
                  traza("Exception: " + e.toString());
             }

             traza("accion: " + accion);
             traza("opcionMenu: " + opcionMenu);
             traza("---------------------------------------------");
             traza("mensaje: " + mensaje);
             traza("sLstIncrementosPorRango: " + sLstIncrementosPorRango);
             traza("---------------------------------------------");
    
             if (accion.equals("")){
                  this.cargarPantalla();
             }
			 else if (accion.equals("almacenar")) {
                  traza("LPMantenerParametrosCalificacion.ejecucion() - entro a accion almacenar");
                  this.almacenar();
                  traza("LPMantenerParametrosCalificacion.ejecucion() - ejecuto almacenar()");
                  this.redirigir();
                  traza("LPMantenerParametrosCalificacion.ejecucion() - ejecuto redirigir()");
             }
			 else if (accion.equals("guardar")){
                  this.almacenar();
                  this.guardar();
             }
			 else if (accion.equals("redirigir")){
                  this.redirigir();
             }
			 else if (accion.equals("participantes")){
                  this.cargarPantallaParticipantes();
             }
			 else if (accion.equals("cargar variables venta proyectada")){
                  this.cargarPantallaVariablesVentaProyectada();
             }
			 else if (accion.equals("calcular metas venta historica")){
                  this.calcularMetasTipoVenta();
             }
			 else if (accion.equals("calcular metas venta proyectada")){
                  this.calcularMetasVentaProyectada();
             }
			 else if (accion.equals("cargar metas venta proyectada")){
                  this.cargarPantallaMetasVentaProyectada();
             }
			 else if (accion.equals("cargar modificar metas venta proyectada")){
                  this.cargarPantallaModificarMetasVentaProyectada();
             }
			 else if (accion.equals("cargar metas tipo venta")){
                  traza("ANTES DE CARGAR PANTALLA **");
                  this.cargarPantallaMetasTipoVenta();
                  traza("SALE DE CARGAR PANTALLA **");
             }
			 else if (accion.equals("guardar variables venta proyectada")){
                  this.guardarEnSesionVariablesVentaProyectada();
             }
			 else if (accion.equals("recargarCombosMetasVentaProyectada")){
                                    traza("accion: recargarCombosMetasVentaProyectada ");
                                    this.recargarCombosMetasVentaProyectada();
             }
	         // Agregado por ssantana, 30/6/2005
		     else if (accion.equals("almacenarModalParticipantes")) {
				this.almacenarModalParticipantes();
			 }
			 else if (accion.equals("almacenarModalEstatusVenta")) {
				 // Nota: La modal "Estatus Venta" de Consultoras, espera que se guarde lo que 
	             //  retorna, a través de una llamada a la LP de la pantalla que la llama. 
		         //  Esto se intenta implementar aquí. 
			     this.almacenarModalEstatusVenta();
             }
			 else if (accion.equals("cargar metas venta historica")) { 
                           this.cargarPantallaMetasTipoVenta(); 
             }
             //Agregado por dmaneiro, 24/01/2005
             else if (accion.equals("validar metas venta proyectada")) {
	             this.validarMetasVentaProyectada();
             }      
             //Agregado por cvalenzu, 27/02/2006
			 //Incidencia 22393
 			 else if(accion.equals("actualizarSesionDtos")) {
				actualizarSesionDtos();
			 }
			 else if(accion.equals("actualizarSesionDtosVentaHistorica")) {
				actualizarSesionDtosVentaHistorica();
			 }			 

			 //******************************* MENU SECUNDARIO *******************************
	         traza("LPMantenerParametrosCalificacion.ejecucion - antes de asignar menu secundario");
		     traza("LPMantenerParametrosCalificacion.ejecucion - opcionMenu: " + this.opcionMenu);
        
			 if (accion.equalsIgnoreCase("cargar metas venta proyectada")){
				this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "cargarMetasVentaProyectada");
			 }
			 else if (accion.equalsIgnoreCase("cargar modificar metas venta proyectada")){
				this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "cargarMetasVentaProyectadaModificar");
			 }
			 else {
				if (this.opcionMenu != null && this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){
                  if (menuVariablesVentaProyectada.equalsIgnoreCase("S")){
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "ventaproy");
                      this.asignarAtributoPagina("cod", "0536");
                  }
				  else {
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "consultar");
                      this.asignarAtributoPagina("cod", "0493");
                  }
				}
				else if (this.opcionMenu != null && this.opcionMenu.equalsIgnoreCase("crear concurso")){                
                  if (menuVariablesVentaProyectada.equalsIgnoreCase("S")){
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "ventaproy");
                      this.asignarAtributoPagina("cod", "0536");
                  }
				  else {               
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "insertar");
                      this.asignarAtributoPagina("cod", "0491");
                  }
				}
				else if (this.opcionMenu != null && this.opcionMenu.equalsIgnoreCase("modificar concurso")){
                  if (menuVariablesVentaProyectada.equalsIgnoreCase("S")){
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "ventaproy");
                      this.asignarAtributoPagina("cod", "0536");
                  }
				  else {
                      this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "insertar");
                      this.asignarAtributoPagina("cod", "0486");
                  }
				}
            }

            asignarAtributo("VAR", "cteOidTipoVtaCalifProyectada", "valor", 
			ConstantesINC.OID_TIPO_VTA_CALIF_PROYECTADA.toString());
            asignarAtributo("VAR", "cteOidTipoVtaCalifHistorica", "valor", 
			ConstantesINC.OID_TIPO_VTA_CALIF_HISTORICA.toString());
			//******************************* FIN - MENU SECUNDARIO *******************************      
		}
		catch (Exception e){
			traza("Excepcion en LPMantenerParametrosCalificacion: " + e.toString());
			traza(e);
			this.lanzarPaginaError(e);
		}
    
        traza("LPMantenerParametrosCalificacion.ejecucion() - Salida");
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList obtenerListaIncrementosPorRango(String lista) throws Exception{
                  traza("*********** obtenerListaIncrementosPorRango");
         DTOIncrementoPorRango dto = null;
         StringTokenizer strToken = null;
         StringTokenizer strTokenField = null;
         String token = null;
         String oid = null;
         String desde = null;
         String hasta = null;
         String incremento = null;

         String tmpOid = null;
         String tmpDesde = null;
         String tmpHasta = null;
         String tmpIncremento = null;

         ArrayList alRetorno = new ArrayList();

         if (lista == null){
             return alRetorno;
         }

         strToken = new StringTokenizer(lista, "|");

         while (strToken.hasMoreTokens()){
             token = strToken.nextToken();
             strTokenField = new StringTokenizer(token, "$");
      
             oid = strTokenField.nextToken();
             desde = strTokenField.nextToken();
             hasta = strTokenField.nextToken();
             incremento = strTokenField.nextToken();

			 traza("*********** oid " + oid);
			 traza("*********** desde " + desde);
             traza("*********** hasta " + hasta);
             traza("*********** incremento " + incremento);

			 tmpOid = desFormatearNumero(oid, this.FORMATO_DEFAULT);
			 tmpDesde = desFormatearNumero(desde, this.FORMATO_DEFAULT);
             tmpHasta = desFormatearNumero(hasta, this.FORMATO_DEFAULT);
             tmpIncremento = desFormatearNumero(incremento, this.FORMATO_DEFAULT);

             traza("*********** tmpOid " + tmpOid);
             traza("*********** tmpDesde " + tmpDesde);
             traza("*********** tmpHasta " + tmpHasta);
             traza("*********** tmpIncremento " + tmpIncremento);
      
             dto = new DTOIncrementoPorRango();
             dto.setOidRango(new Long(tmpOid));
             dto.setDesde(new BigDecimal(tmpDesde));
             dto.setHasta(new BigDecimal(tmpHasta));
             dto.setIncremento(new BigDecimal(tmpIncremento));

             traza("*********** DTOIncrementoPorRango " + dto);    
             alRetorno.add(dto);
         }
    
         return alRetorno;
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        05/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void cargarPantalla() throws Exception {  
         traza("LPMantenerParametrosCalificacion.cargarPantalla() - Entrada");
         this.asignarAtributo("VAR", "incrementoPorcentaje", "valor", 
         ConstantesINC.OID_TIPO_INCREMENTO_PORCENTAJE.toString());

         this.asignarAtributo("VAR", "incrementoCantidad", "valor", 
         ConstantesINC.OID_TIPO_INCREMENTO_CANTIDAD.toString());
  
         concurso = this.getConcurso();
         
         //Se setea el oid de agrupacion a una variable oculta, que sera
         //utilizada cuando el usuario presione el boton Calcular Metas
         if (concurso.getParamCalificacion()!=null) {
             if (concurso.getParamCalificacion().getOidAgrupacion()!=null) {
                this.asignarAtributo("VAR", "sOidAgrupacion", "valor", 
                concurso.getParamCalificacion().getOidAgrupacion().toString());
                conectorParametroSesion("OidAgrupacion",concurso.getParamCalificacion().getOidAgrupacion());
             }

             if (concurso.getParamCalificacion().getOidTipoIncremento() != null){
                  this.asignarAtributo("VAR", "hTipoIncremento", "valor", 
                  concurso.getParamCalificacion().getOidTipoIncremento().toString());
             }

			 //Si es incremental el tipo de venta, el valor de incremento
			 //se obtiene del ArrayList, que tendra un solo DTOIncrementoPorRango
			 if(concurso.getParamCalificacion().getOidTipoVentaIncremental()!=null) {
                    if(concurso.getParamCalificacion().getOidTipoVentaIncremental().longValue()==
						ConstantesINC.OID_TIPO_VTA_INC_INCREMENTAL.longValue()) {

						ArrayList tempArrayList = concurso.getParamCalificacion().getLstIncrementosPorRango();
                        if(tempArrayList!=null && tempArrayList.size()>0) {
						
                            DTOIncrementoPorRango dtoTemp = (DTOIncrementoPorRango)tempArrayList.get(0);
                            if(dtoTemp.getIncremento()!=null) {
								String valIncremento = 
								UtilidadesBelcorp.formateaNumeroSICC(dtoTemp.getIncremento().toString(), 
                                this.FORMATO_DEFAULT, this);
                                this.asignarAtributo("CTEXTO", "txtValorIncremento", "valor", valIncremento);
                            }
                       }
                   }
             }			
         }
  
         //Asignacion de constantes a la pagina
         this.asignarAtributo( "VAR", "OID_TIPO_VTA_INC_INCREMENTAL_NIVELES", "valor", 
		 ConstantesINC.OID_TIPO_VTA_INC_INCREMENTAL_NIVELES.toString());

         this.asignarAtributo( "VAR", "OID_TIPO_VTA_INC_INCREMENTAL", "valor", 
		 ConstantesINC.OID_TIPO_VTA_INC_INCREMENTAL.toString());                 
  
         this.cargarFlagsPestanyas();
    
         ComposerViewElementList cv = this.crearParametrosEntrada();
         ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
         traza("LPMantenerParametrosCalificacion.cargarPantalla() - va a cargar combos");
         asignar("COMBO", "cbTipoVentaHistorica", resultados, "INCConsultaTiposVenta");
         asignar("COMBO", "cbTipoVentaIncremental", resultados, "INCObtenerTiposVentaIncremental");
         asignar("COMBO", "cbTipoDeterminacionMetas", resultados, "INCObtenerTiposDeterminacionMetas");
         asignar("COMBO", "cbFormaCalculo", resultados, "INCObtenerFormaCalculoMetas");
         asignar("COMBO", "cbTipoIncremento", resultados, "INCObtenerTiposIncremento");           
		 asignar("COMBO", "cbPeriodoEvaluacionDesde", resultados, "CRAObtienePeriodos");		
         asignar("COMBO", "cbPeriodoEvaluacionHasta", resultados, "CRAObtienePeriodos");

         //Cleal - 21857
         if (concurso.getEstatusVenta() != null){
			dtoListaEstatusVtaCalifAuxiliar = concurso.getEstatusVenta();
            this.getSessionCache().put("dtoLstEVtaCal", dtoListaEstatusVtaCalifAuxiliar);
         }

         this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         this.asignarAtributo("VAR", "oidDirigidoA", "valor", concurso.getPlantilla()!=null?
         concurso.getPlantilla().getOidDirigidoA().toString():"");
         this.asignarAtributo("VAR", "hDescDirigidoA", "valor", concurso.getPlantilla()!=null &&
         concurso.getPlantilla().getDesDirigidoA()!=null?concurso.getPlantilla().getDesDirigidoA():"");

         if (concurso.getPlantilla()!=null && concurso.getPlantilla().getOidTipoCalificacion()!=null && 
                  concurso.getPlantilla().getOidTipoCalificacion().equals(
                  ConstantesINC.OID_TIPO_CALIF_PROYECTADA)){

             traza("*************PROYECTADA***************");    
             this.asignarAtributo("VAR", "oidTipoVentaCalificacion", "valor", 
             ConstantesINC.OID_TIPO_VTA_CALIF_PROYECTADA.toString());

             this.asignarAtributo("VAR", "descTipoVentaCalificacion", "valor", 
             ConstantesINC.DES_TIPO_VTA_CALIF_VENTA_PROYECTADA);
      
             //deshabilitar cbTipoVentaHistorica, cbTipoVentaIncremental,
             //chkDevoluciones, chkAnulaciones, chkFaltantesNoAnunciados 
             //cbFormaCalculo, cbTipoIncremento 
             this.asignarAtributo("VAR", "hEstadoCbTipoVentaHistorica", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCbTipoVentaIncremental", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCkDevolucines", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCkAnulaciones", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCkFaltantesNoAnunciados", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCbFormaCalculo", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoCbTipoIncremento", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoValorIncremento", "valor", "N");
      
             //Deshabilitar el boton btProductosCalificar 
             this.asignarAtributo("VAR", "hEstadoBtnProductosCalificar", "valor", "N");
      
             //Deshabilitar capa Incrementos con los sgtes. campos: 
             //txtDesde, txtHasta, txtIncrementos 
             //lstIncrementosPorRangos 
             this.asignarAtributo("VAR", "hEstadoTxtDesde", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoTxtHasta", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoTxtIncremento", "valor", "N");
      
             //Deshabilitar
             //btAñadir, btEliminar 
             this.asignarAtributo("VAR", "hEstadoBtnAnadir", "valor", "N");
             this.asignarAtributo("VAR", "hEstadoBtnEliminar", "valor", "N");
             // incid 21501 - se habilita la consulta metas proyectada 
             this.asignarAtributo("VAR", "hEstadoBtnConsultarMetasVentaProyectada", "valor", "S"); 
         }
         else if (concurso.getPlantilla()!=null && concurso.getPlantilla().getOidTipoCalificacion()!=null && 
                  (concurso.getPlantilla().getOidTipoCalificacion().equals(
                  ConstantesINC.OID_TIPO_CALIF_HISTORICA_INC) 
                  || concurso.getPlantilla().getOidTipoCalificacion().equals(
                  ConstantesINC.OID_TIPO_CALIF_HISTORICA_INC_NIVELES))){

             traza("*************HISTORICA***************");    
             this.asignarAtributo("VAR", "oidTipoVentaCalificacion", "valor", 
             ConstantesINC.OID_TIPO_VTA_CALIF_HISTORICA.toString());
             this.asignarAtributo("VAR", "descTipoVentaCalificacion", "valor", 
             ConstantesINC.DES_TIPO_VTA_CALIF_VENTA_HISTORICA.toString());

             // INC 21057
             // Se deshabilita el botón Definir venta proyectada, que está habilitado por defecto
             this.asignarAtributo("VAR","hEstadoBtnDefinirVentaProyectada","valor","N");
             // incid 21501 - se habilita la consulta metas historica 
             this.asignarAtributo("VAR", "hEstadoBtnConsultarMetasTipoVenta", "valor", "S"); 
                           
             //se hace en el javascript
             //...
             //...
         }

         traza("concurso.getIndParamCalificacion(): " + concurso.getIndParamCalificacion());
         //Por defecto el campo txtValorIncremento estará deshabilitado 
         this.asignarAtributo("VAR", "hEstadoTxtIncremento", "valor", "N");
  
         if (concurso.getIndParamCalificacion()!=null 
                  && concurso.getIndParamCalificacion().booleanValue()){
             traza("entro a condicion");
      
             if (concurso.getParamCalificacion()!=null 
                      && concurso.getParamCalificacion().getOidParamCalificacion()!=null){
                  this.asignarAtributo("VAR", "oidParamCalificacion", "valor", 
                      concurso.getParamCalificacion().getOidParamCalificacion().toString());
             }
    
             if (concurso.getParamCalificacion()!=null && 
                      concurso.getParamCalificacion().getOidPeriodoDesde()!=null){
                  this.asignarAtributo("VAR", "hPeriodoEvaluacionDesde", "valor", 
                      concurso.getParamCalificacion().getOidPeriodoDesde().toString());
             }

             if (concurso.getParamCalificacion()!=null 
                      && concurso.getParamCalificacion().getOidPeriodoHasta()!=null){
                  this.asignarAtributo("VAR", "hPeriodoEvaluacionHasta", "valor", 
                      concurso.getParamCalificacion().getOidPeriodoHasta().toString());
             }
      
             //agregado INC 21052 dmorello             
             if (concurso.getParamCalificacion() != null
             && concurso.getParamCalificacion().getIndMetasModificables() != null) {
		            if (concurso.getParamCalificacion().getIndMetasModificables().booleanValue()) {
		                   this.asignarAtributo("VAR", "hMetasModificables", "valor", "S");
	                           if (concurso.getParamCalificacion().getIndMetasBloqueadas() != null
                               && concurso.getParamCalificacion().getIndMetasBloqueadas().booleanValue()) {
			                           this.asignarAtributo("VAR", "hEstadoBtnMantenerMetas", "valor", "N");
                               }
                    }
					else { // indMetasModificables Está inactivo
						this.asignarAtributo("VAR", "hMetasModificables", "valor", "N");
                        this.asignarAtributo("VAR", "hEstadoBtnMantenerMetas", "valor", "N");
                    }
              }

              if (concurso.getParamCalificacion() != null && concurso.getParamCalificacion().getIndMetasBloqueadas() != null) {
				boolean metasBloqueadas	= concurso.getParamCalificacion().getIndMetasBloqueadas().booleanValue();
                this.asignarAtributo("VAR", "hBloquearMetas", "valor", metasBloqueadas? "S" : "N");
              }
              // Fin agregado INC 21052 dmorello

             traza("comunicacion: " + concurso.getParamCalificacion().getIndComunicacion());

             if (concurso.getParamCalificacion()!=null 
                  && concurso.getParamCalificacion().getIndComunicacion()!=null){
                  traza("LPMantenerParametrosCalificacion.cargarPantalla - va a asignar comunicacion");
      
                  this.asignarAtributo("VAR", "hComunicaciones", "valor", 
                  concurso.getParamCalificacion() != null 
                  && concurso.getParamCalificacion().getIndComunicacion() != null 
                  && concurso.getParamCalificacion().getIndComunicacion().booleanValue() ? "S" : "N");
         
                  if (concurso.getParamCalificacion() != null 
                  && concurso.getParamCalificacion().getIndComunicacion() != null
                  && concurso.getParamCalificacion().getIndComunicacion().booleanValue()){
                      traza("LPMantenerParametrosCalificacion.cargarPantalla - va a asignar mensaje");
                      traza("LPMantenerParametrosCalificacion.cargarPantalla - mensaje: " + concurso.getParamCalificacion().getMensaje());
         
                      this.asignarAtributo("CTEXTO", "txtMensaje", "valor", 
                      concurso.getParamCalificacion().getMensaje() != null 
                      ? concurso.getParamCalificacion().getMensaje() : "");
                  }
             }
             else {      
                  this.asignarAtributo("VAR", "hEstadoTxtMensaje", "valor", "N");
             }

             if (concurso.getParamCalificacion()!=null){
                  this.asignarAtributo("VAR", "hTipoDeterminacionMetas", "valor", 
                  concurso.getParamCalificacion().getOidTipoDeterminacionMetas()!= null 
                  ? concurso.getParamCalificacion().getOidTipoDeterminacionMetas().toString() : "");
             }

             if (concurso.getParamCalificacion()!=null 
                      && concurso.getParamCalificacion().getOidTipoVentaCalificacion()!=null 
                      && concurso.getParamCalificacion().getOidTipoVentaCalificacion().equals(
                      ConstantesINC.OID_TIPO_VTA_CALIF_HISTORICA)){
      
                  if (concurso.getParamCalificacion().getOidTipoVentaHistorica()!=null){
                      this.asignarAtributo("VAR", "hTipoVentaHistorica", "valor", 
                           concurso.getParamCalificacion().getOidTipoVentaHistorica().toString());
                  }

                  if (concurso.getParamCalificacion().getOidTipoVentaIncremental()!=null){
                      this.asignarAtributo("VAR", "hTipoVentaIncremental", "valor", 
                           concurso.getParamCalificacion().getOidTipoVentaIncremental().toString());
                  }
          
                  if (concurso.getParamCalificacion().getOidTipoIncremento() != null){
	                  this.asignarAtributo("VAR", "hTipoIncremento", "valor", 
                      concurso.getParamCalificacion().getOidTipoIncremento().toString());
                  }                      
           
                  DruidaConector dc = this.generarConectorLista(this.generarRecordSetLista(
                  this.concurso.getParamCalificacion().getLstIncrementosPorRango()));
           
                  if (dc != null){
		              this.asignar("LISTADOA", "listado3", dc, "dtoSalida");
                  }
                   
                  if (concurso.getParamCalificacion()!=null){
                      this.asignarAtributo("VAR", "hTipoDeterminacionMetas", "valor", 
                           concurso.getParamCalificacion().getOidTipoDeterminacionMetas() != null 
                           ? concurso.getParamCalificacion().getOidTipoDeterminacionMetas().toString() : "");
                      this.asignarAtributo("VAR", "hDevoluciones", "valor", 
                           concurso.getParamCalificacion().getIndDevoluciones() != null 
                           && concurso.getParamCalificacion().getIndDevoluciones().booleanValue() ? "S" : "N");
                      this.asignarAtributo("VAR", "hAnulaciones", "valor", 
                           concurso.getParamCalificacion().getIndAnulaciones() != null 
                           && concurso.getParamCalificacion().getIndAnulaciones().booleanValue() ? "S" : "N");
                      this.asignarAtributo("VAR", "hFaltantesNoAnunciados", "valor", 
                           concurso.getParamCalificacion().getIndFaltantesNoAnunciados() != null 
                           && concurso.getParamCalificacion().getIndFaltantesNoAnunciados().booleanValue() ? "S" : "N");
                      this.asignarAtributo("VAR", "hFormaCalculo", "valor", 
                           concurso.getParamCalificacion().getOidFormaCalculo() != null 
                                ? concurso.getParamCalificacion().getOidFormaCalculo().toString() : "");
                  }
             }
         }
         else{
             this.asignarAtributo("VAR", "oidParamCalificacion", "valor", "");    
             this.asignarAtributo("VAR", "hEstadoTxtMensaje", "valor", "N");
         }

		 //Al ingresar a la pantalla, se limpian los dtos de sesion
		 conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia", null);
		 conectorParametroSesion("dtoListaMetasAuxiliarRegion", null);
		 conectorParametroSesion("dtoListaMetasAuxiliarZona", null);    
		 //para venta historica
		 conectorParametroSesion("dtoListaMetasTipoVentaSesion", null);    

		 //verifica si tiene estatus de venta - cvalenzu - 29/05/2006
         traza("************ cargar estatus de venta");
		 DTOListaEstatusVenta dtoEstatusVenta = this.concurso.getEstatusVenta();
         traza("************ dtoEstatusVenta " + dtoEstatusVenta);
         
		 traza("************ 1");
         if (dtoEstatusVenta != null){
	 		 traza("************ 2");
             this.asignarAtributo("VAR", "tieneEstatusDeVenta", "valor", "true"); 
         }

 		 traza("************ 6");
 		 //fin - verifica si tiene estatus de venta - cvalenzu - 29/05/2006
		
		 //se agrega el seteo de una constante
         this.asignarAtributo("VAR", "cteOidDirigidoAConsultora", "valor", 
         ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.toString());
 		 //fin - se agrega el seteo de una constante

		 //verifica si tiene calificacion participantes cristian valenzuela - 29/05/2006
		 if(this.concurso.getCalificacionParticipantes()!=null && 		
			 this.concurso.getCalificacionParticipantes().getLstCalificacionParticipantes()!=null) {	
		    traza("************ tieneCalificacionParticipantes = true");
			this.asignarAtributo("VAR", "tieneCalificacionParticipantes", "valor", "true"); 
		 }   
 		 //fin - verifica si tiene calificacion participantes cristian valenzuela - 29/05/2006
         traza("LPMantenerParametrosCalificacion.cargarPantalla() - Salida");
    }
     
	//Modificado por incidencia BELC300021050
    private ComposerViewElementList crearParametrosEntrada() throws Exception {
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidPais(concurso.getOidPais());
         dtoe.setOidIdioma(concurso.getOidIdioma());
    
         DTOPeriodo dtop = new DTOPeriodo();
         dtop.setOidPais(concurso.getOidPais());
         dtop.setMarca(concurso.getParamGenerales()!=null?concurso.getParamGenerales().getOidMarca():null);
         dtop.setCanal( concurso.getParamGenerales()!=null?concurso.getParamGenerales().getOidCanal():null);

		 DTOOID dtoOid = new DTOOID();
		 dtoOid.setOidPais(concurso.getOidPais());
		 dtoOid.setOidIdioma(concurso.getOidIdioma());
		 dtoOid.setOid(concurso.getPlantilla().getOidDirigidoA());

         ComposerViewElementList lista = new ComposerViewElementList(); 
         ComposerViewElement cve = null;
    
         // Tipo venta historica
         cve = new ComposerViewElement();
         cve.setIDBusiness("INCConsultaTiposVenta");
         cve.setDTOE(dtoe);
         lista.addViewElement(cve);

         // Tipo venta incremental
         cve = new ComposerViewElement();
         cve.setIDBusiness("INCObtenerTiposVentaIncremental");
         cve.setDTOE(dtoe);
         lista.addViewElement(cve);

         // Tipo determinacion metas
         cve = new ComposerViewElement();
         cve.setIDBusiness("INCObtenerTiposDeterminacionMetas");
         cve.setDTOE(dtoOid);
         lista.addViewElement(cve);

         // Formas calculo
         cve = new ComposerViewElement();
         cve.setIDBusiness("INCObtenerFormaCalculoMetas");
         cve.setDTOE(dtoe);
         lista.addViewElement(cve);
    
         // Tipo incremento
         cve = new ComposerViewElement();
         cve.setIDBusiness("INCObtenerTiposIncremento");
         cve.setDTOE(dtoe);
         lista.addViewElement(cve);
    
         // Periodo evaluacion desde
         cve = new ComposerViewElement();
         cve.setIDBusiness("CRAObtienePeriodos");
         cve.setDTOE(dtop);
         lista.addViewElement(cve);
    
         // Periodo evaluacion hasta
         cve = new ComposerViewElement();
         cve.setIDBusiness("CRAObtienePeriodos");
         cve.setDTOE(dtop);
         lista.addViewElement(cve);
    
         return lista;
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        06/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void almacenar() throws Exception {  
         traza("LPMantenerParametrosCalificacion.almacenar() - Entrada");
  
         //Se almacena variables venta proyectada 
         if (conectorParametroSesion("DTOModalVariablesVentaProyectada") != null){
		     traza("********* Llamando a almacenarVariablesVentaProyectada");
             this.almacenarVariablesVentaProyectada();
         }

         this.listaMetasTipoVenta = this.parsearListaMetasTipoVenta(this.sListaMetasTipoVenta);
         traza("************* listaMetasTipoVenta " + listaMetasTipoVenta);    
	  	 //dtoListaMetasTipoVentaSesion = (DTOListaMetasTipoVenta)conectorParametroSesion("dtoListaMetasTipoVentaSesion");
         // Se almacena metas tipo venta
         //if (this.listaMetasTipoVenta != null && !this.listaMetasTipoVenta.isEmpty()){
			 traza("********* Llamando a almacenarMetasTipoVenta");
             this.almacenarMetasTipoVenta();
         //}

		 //Agregado por Cristian Valenzuela - 27/2/2006
		 //Incidencia 22393
		 dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia");
		 dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarRegion");
		 dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarZona");
		 //FIN - Agregado por Cristian Valenzuela

         traza("*********** dtoListaMetasAuxiliarSubgerencia " + dtoListaMetasAuxiliarSubgerencia);
         traza("*********** dtoListaMetasAuxiliarRegion " + dtoListaMetasAuxiliarRegion);
         traza("*********** dtoListaMetasAuxiliarZona " + dtoListaMetasAuxiliarZona);

		 boolean llamada = false;

		 if(dtoListaMetasAuxiliarSubgerencia!=null) {
			if(dtoListaMetasAuxiliarSubgerencia.getListaMetas()!=null &&
			  !dtoListaMetasAuxiliarSubgerencia.getListaMetas().isEmpty() &&
			   llamada == false) {
				traza("********* Llamando a almacenarMetasVentaProyectada - subgerencia");
				llamada = true;
	            this.almacenarMetasVentaProyectada();			
			}		 
		 }

		 if(dtoListaMetasAuxiliarRegion!=null) {
			 if(dtoListaMetasAuxiliarRegion.getListaMetas()!=null &&
			   !dtoListaMetasAuxiliarRegion.getListaMetas().isEmpty() &&
				llamada == false) {
 				traza("********* Llamando a almacenarMetasVentaProyectada - region");
				llamada = true;
	            this.almacenarMetasVentaProyectada();			
			 }		 
		 }

		 if(dtoListaMetasAuxiliarZona!=null) {
			 if(dtoListaMetasAuxiliarZona.getListaMetas()!=null	 &&
			   !dtoListaMetasAuxiliarZona.getListaMetas().isEmpty() &&
				llamada == false) {
  				traza("********* Llamando a almacenarMetasVentaProyectada - zona");
				llamada = true;
	            this.almacenarMetasVentaProyectada();						 
			 }		 
		 }   
	 	 //FIN - Modificado por Cristian Valenzuela - 27/2/2006
    
         //Se guardan los datos de la página PGPMantenerParametrosCalificacion
         this.concurso = this.getConcurso();

         //Se almacenan los estatus de venta         
         Object sListaEstVta = (listasCalificacion!=null)?listasCalificacion.get(LPMantenerParametrosCalificacion.INDICE_LISTA_ESTATUS_VENTA):"";
         traza("Lista de estatus venta: "+sListaEstVta);
         if (!sListaEstVta.equals(null) && !sListaEstVta.equals("")) {
			traza("Entro por si ***");
            //Cleal - INC 06
            concurso.setEstatusVenta(null);
            concurso.setIndEstatusVenta(Boolean.TRUE);
            almacenarEstatusVenta();
            concurso.setEstatusVenta(dtoListaEstatusVtaCalifAuxiliar);
         }
         else {
	         traza("Entro por no ***");
             concurso.setIndEstatusVenta(new Boolean(false));
             dtoListaEstatusVtaCalifAuxiliar = null;                           
             this.getSessionCache().put("dtoLstEVtaCal", dtoListaEstatusVtaCalifAuxiliar);
         }
    
         traza("!!!!!!!!!!!!!!!!!!!! datosObligatorios " + datosObligatorios);
         this.concurso.setIndObligCalificacion(this.datosObligatorios!=null&&
         this.datosObligatorios.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

         // Rellena el dtoConcurso.paramCalificacion 
         DTOParametrosCalificacion dtoPC = null;
    
         if (this.concurso.getParamCalificacion()!=null){
             dtoPC = this.concurso.getParamCalificacion();
         }
		 else {
             dtoPC = new DTOParametrosCalificacion();
         }

         traza("*********** oidParamCalificacion: " + oidParamCalificacion);
         traza("*********** oidTipoVentaCalificacion: " + oidTipoVentaCalificacion);
         traza("*********** periodoEvaluacionDesde: " + periodoEvaluacionDesde);
         traza("*********** periodoEvaluacionHasta: " + periodoEvaluacionHasta);

         Long oidIdioma = UtilidadesSession.getIdioma(this);
         Long oidPais = UtilidadesSession.getPais(this);    
         dtoPC.setOidIdioma(oidIdioma);
         dtoPC.setOidPais(oidPais);    

         traza("********* setOidParamCalificacion");
         dtoPC.setOidParamCalificacion(oidParamCalificacion != null && oidParamCalificacion.length() > 0 ? new Long(oidParamCalificacion):null);
    
         traza("********* setOidTipoVentaCalificacion");
         dtoPC.setOidTipoVentaCalificacion(oidTipoVentaCalificacion != null && oidTipoVentaCalificacion.length() > 0 ? new Long(oidTipoVentaCalificacion):null);

         traza("********* setOidPeriodoDesde");
         dtoPC.setOidPeriodoDesde(periodoEvaluacionDesde != null && periodoEvaluacionDesde.length() > 0 ? new Long(periodoEvaluacionDesde):null);

         traza("********* setOidPeriodoHasta");
         dtoPC.setOidPeriodoHasta(periodoEvaluacionHasta != null && periodoEvaluacionHasta.length() > 0 ? new Long(periodoEvaluacionHasta):null);

         traza("********* setOidDirigidoA");
         dtoPC.setOidDirigidoA(oidDirigidoA != null && oidDirigidoA.length() > 0 ? new Long(oidDirigidoA):null);

         traza("********* setIndMetasModificables");
         dtoPC.setIndMetasModificables(metasModificables!=null&&metasModificables.equalsIgnoreCase("S")?
         Boolean.TRUE:Boolean.FALSE);

         traza("********* setIndMetasBloqueadas");
         dtoPC.setIndMetasBloqueadas(bloquearMetas!=null&&bloquearMetas.equalsIgnoreCase("S")?
         Boolean.TRUE:Boolean.FALSE);

         traza("********* setIndComunicacion");
         dtoPC.setIndComunicacion(comunicaciones!=null&&comunicaciones.equalsIgnoreCase("S")?
         Boolean.TRUE:Boolean.FALSE);

         traza("********* setMensaje");
         dtoPC.setMensaje(mensaje);

         traza("********* setOidTipoVentaHistorica");
         dtoPC.setOidTipoVentaHistorica(tipoVentaHistorica != null && tipoVentaHistorica.length() > 0 ? new Long(tipoVentaHistorica):null);

         traza("********* setOidTipoVentaIncremental");
         dtoPC.setOidTipoVentaIncremental(tipoVentaIncremental != null && tipoVentaIncremental.length() > 0 ? new Long(tipoVentaIncremental):null);

         traza("********* setOidTipoDeterminacionMetas");
         dtoPC.setOidTipoDeterminacionMetas(tipoDeterminacionMetas != null && tipoDeterminacionMetas.length() > 0 ? new Long(tipoDeterminacionMetas):null);
    
         traza("********* setIndDevoluciones");
         dtoPC.setIndDevoluciones(devoluciones!=null&&devoluciones.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

         traza("********* setIndAnulaciones");
         dtoPC.setIndAnulaciones(anulaciones!=null&&anulaciones.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);
        
         traza("********* setIndFaltantesNoAnunciados");	
		 dtoPC.setIndFaltantesNoAnunciados(faltantesNoAnunciados!=null&&faltantesNoAnunciados.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

         traza("********* setOidFormaCalculo");	
         dtoPC.setOidFormaCalculo(formaCalculo != null && formaCalculo.length() > 0 ? new Long(formaCalculo):null);

         traza("********* setOidTipoIncremento");	
         dtoPC.setOidTipoIncremento(tipoIncremento != null && tipoIncremento.length() > 0 ? new Long(tipoIncremento):null);

         traza("********* setValorIncremento");	
         dtoPC.setValorIncremento(valorIncremento != null && valorIncremento.length() > 0 ? new BigDecimal(valorIncremento) : null);

         if (this.concurso.getIndParamCalificacion()!=null && 
             this.concurso.getIndParamCalificacion().booleanValue()){
             dtoPC.setLstIncrementosPorRango(null);
         }

         lstIncrementosPorRango = obtenerListaIncrementosPorRango(sLstIncrementosPorRango);
         dtoPC.setLstIncrementosPorRango(this.lstIncrementosPorRango);

         traza("******** TERMINA ALMACENAR CON DTOParametrosCalificacion " + dtoPC);
    
         this.concurso.setIndParamCalificacion(Boolean.TRUE);
         this.concurso.setParamCalificacion(dtoPC);
         this.setConcurso(this.concurso);
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        09/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void almacenarEstatusVenta() throws Exception {
		traza("En almacenarEstatusVenta()");
        traza("listasCalificacion: "+listasCalificacion);
        
        dtoListaEstatusVtaCalifAuxiliar = new DTOListaEstatusVenta();
        dtoListaEstatusVtaCalifAuxiliar.setEstatusVenta(
        (ArrayList)listasCalificacion.get(
        LPMantenerParametrosCalificacion.INDICE_LISTA_ESTATUS_VENTA));
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        09/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void almacenarCalificacionParticipantes() throws Exception {
         this.concurso = this.getConcurso();
        
         traza("LPMantenerParametrosCalificacion.almacenarCalificacionParticipantes()");
      
         if ((this.concurso.getIndParamCalificacion()!=null 
                  && this.concurso.getIndParamCalificacion().booleanValue())) {
             traza("Entro");
             
             if (this.concurso.getCalificacionParticipantes()==null) {
                  this.concurso.setCalificacionParticipantes(new DTOCalificacionParticipantes());
             }
         }

         DTOCalificacionParticipantes dtoCalificParticipantes = this.concurso.getCalificacionParticipantes();
    
         if (dtoCalificParticipantes == null){
             dtoCalificParticipantes = new DTOCalificacionParticipantes();
         }
                                                  
         ArrayList aCalifParticipantes = (ArrayList) this.listasCalificacion.get(
             LPMantenerParametrosCalificacion.INDICE_LISTA_CALIFICACION_PARTICIPANTES);
           
         ArrayList aParticipantes = (ArrayList) this.listasCalificacion.get(
             LPMantenerParametrosCalificacion.INDICE_LISTA_PARTICIPANTES);

         traza("-- aCalifParticipantes.size(): " + aCalifParticipantes.size());
         traza("-- aParticipantes.size(): " + aParticipantes.size());    
         traza("AAAAAAAAAA");
         //TODO(LISTO): verificar que listasCalificacion.get(0) es un ArrayList
    
         dtoCalificParticipantes.setLstCalificacionParticipantes(aCalifParticipantes);
         dtoCalificParticipantes.setLstParticipantes(aParticipantes);
    
         this.concurso.setCalificacionParticipantes(dtoCalificParticipantes);         
      
         traza("BBBBBBB");
      
         this.concurso.setIndClasificacionParticipantesCalificacion(Boolean.TRUE);
         this.concurso.setIndClasificacionParticipantes(Boolean.TRUE);
    
         traza("DTOCOncurso a setear: " + this.concurso);
         this.setConcurso(this.concurso);
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        09/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */

    public void cargarPantallaParticipantes() throws Exception {
                  traza("************ Entro a cargarPantallaParticipantes");
         this.pagina("contenido_calificacion_participantes_seleccionar");
                  getFormatosValidaciones();
    
         this.getConfiguracionMenu("LPMantenerParametrosCalificacion", "participantes");
         this.concurso = this.getConcurso();
    
         DruidaConector dcParticipantes = null;
         DruidaConector dcCalificacionParticipantes = null;
          
         if (this.concurso.getCalificacionParticipantes() != null 
                  && this.concurso.getCalificacionParticipantes().getLstParticipantes() != null 
                  && !this.concurso.getCalificacionParticipantes().getLstParticipantes().isEmpty()){
                  
                  traza("************ Se asigna lo que esta en el DTOConcurso");
             
             dcParticipantes = this.generarConectorParticipantes(
                  this.concurso.getCalificacionParticipantes().getLstParticipantes());
                  this.asignar("LISTADOA", "listado2", dcParticipantes, "dtoSalida");
         }
         
         if (this.concurso.getIndClasificacionParticipantesCalificacion() != null 
                  && this.concurso.getIndClasificacionParticipantesCalificacion().booleanValue()) {
                  
                           traza("************ IndClasificacionParticipantesCalificacion es true");
            
             if(this.concurso.getCalificacionParticipantes() != null 
                      && this.concurso.getCalificacionParticipantes().getLstCalificacionParticipantes() != null 
                      && !this.concurso.getCalificacionParticipantes().getLstCalificacionParticipantes().isEmpty()){
                      
                  traza("************ Asigna a la lista de arriba");
                  
                  dcCalificacionParticipantes = this.generarConectorClasificacionParticipantes(
                  this.concurso.getCalificacionParticipantes().getLstCalificacionParticipantes());
                  this.asignar("LISTADOA", "listado1", dcCalificacionParticipantes, "dtoSalida");
             }
         }
    
         traza("************ this.concurso.getPlantilla() " + this.concurso.getPlantilla());
    
         if (this.concurso.getPlantilla() != null 
                  && this.concurso.getPlantilla().getOidDirigidoA() != null 
                  && this.concurso.getPlantilla().getOidDirigidoA().equals(                  
             ConstantesINC.OID_DIRIGIDO_A_GERENTE)){

             traza("************ Dirigido a gerentes");
             this.asignarAtributo("VAR", "hEstadoBtnEstatusVenta", "valor", "N" );
         }
     
         if (this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){     
             this.asignarAtributo("VAR", "hPantallaParticipantesControlesOcultos", "valor", "S" );
         }
    
         // Agregado por ssantana, 1/7/2005
         // Si existe Estatus Venta en Sesión en el DTOConcurso, se envía a la pantalla
         // para que lo tome como si ya se hubiera entrado a la Modal de Estatus Venta. 
         DTOListaEstatusVenta dtoEstatusVenta = this.concurso.getEstatusVenta();
                  traza("************ dtoEstatusVenta " + dtoEstatusVenta);
         
         if (dtoEstatusVenta != null){
             ArrayList aListEstatusVenta = dtoEstatusVenta.getEstatusVenta();
             
             if (aListEstatusVenta != null && !aListEstatusVenta.isEmpty()){
                  String sCadenaEstatusVenta = obtieneCadenaEstatusVenta(aListEstatusVenta);
                  this.asignarAtributo("VAR", "hidLstEstatusVta", "valor", sCadenaEstatusVenta); 
             }
         }

         this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
         this.asignarAtributo("VAR", "accion", "valor", this.accion);    
         this.asignarAtributo("VAR", "oidDirigidoA", "valor", this.concurso.getPlantilla()!=null && 
         this.concurso.getPlantilla().getOidDirigidoA() != null?
         this.concurso.getPlantilla().getOidDirigidoA().toString():"");    
         this.asignarAtributo("VAR", "cteOidDirigidoAConsultora", "valor", 
         ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.toString());
    }

    /**
     * @author: sssantana, 2/7/2005
     * @throws java.lang.Exception
     * @return String
     * @param ArrayList aListEstatusVenta
     */
    private String obtieneCadenaEstatusVenta(ArrayList aListEstatusVenta) throws Exception {
    
         /*  
         *  Crea una cadena exactamente igual a la que se obtendria desde la Modal 
         *  de Estatus Venta (si se entrara en esta, seleccionara datos y luego
         *  se diera "Aceptar"). Los campos se separan todos con ",", incluidas las filas. 
         */
     
         int longArray = aListEstatusVenta.size();
         StringBuffer stringBuffer = new StringBuffer("");
         String sDescEstatus = null;
         String sDescPeriodoDesde = null;
         String sDescPeriodoHasta = null;
         String sOidEstatusVenta = null;
         String cadenaRetorno = null;    
         Long oidEstatus = null;
         Long oidEstatusVentaMAE = null;
         Long oidPeriodoDesde = null;
         Long oidPeriodoHasta = null;
         DTOEstatusVenta dtoEstatusVenta = null;
    
         for (int i = 0; i < longArray; i++){ 
             dtoEstatusVenta = (DTOEstatusVenta) aListEstatusVenta.get(i);
             sDescEstatus = dtoEstatusVenta.getDesEstatus();
             sDescPeriodoDesde = dtoEstatusVenta.getDesPeriodoDesde();
             sDescPeriodoHasta = dtoEstatusVenta.getDesPeriodoHasta();
             oidEstatus = dtoEstatusVenta.getOidEstatus();
             oidEstatusVentaMAE = dtoEstatusVenta.getOidEstatusVentaMae();
             oidPeriodoDesde = dtoEstatusVenta.getOidPeriodoDesde();
             oidPeriodoHasta = dtoEstatusVenta.getOidPeriodoHasta();
        
             if (i != 0){
                  stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             }
          
             stringBuffer.append("" + i);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
        
             if (oidEstatus  == null){
                  sOidEstatusVenta = "null";
             } else {
                  sOidEstatusVenta = oidEstatus.toString();
             }
         
             stringBuffer.append(sOidEstatusVenta);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);        
             stringBuffer.append(oidEstatusVentaMAE);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             stringBuffer.append(oidPeriodoDesde);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             stringBuffer.append(oidPeriodoHasta);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             stringBuffer.append(sDescEstatus);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             stringBuffer.append(sDescPeriodoDesde);
             stringBuffer.append(CHAR_SEPARADOR_CAMPOS);
             stringBuffer.append(sDescPeriodoHasta);
         }
    
         cadenaRetorno = stringBuffer.toString();
         traza("Cadena EstatusVenta generada: " + cadenaRetorno);
         return cadenaRetorno;
    }

  //this.concurso.getCalificacionParticipantes().getLstParticipantes()
  //El parametro es un ArrayList de DTOParticipante
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        09/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private DruidaConector generarConectorParticipantes(ArrayList alParticipantes) throws Exception {
    
         if (alParticipantes == null || alParticipantes.isEmpty()){
             return null;
         }

         Iterator i = alParticipantes.iterator();
   
         DTOParticipante dtop = null;
  
         RecordSet rs = new RecordSet();
         Vector v = null;
    
         rs.addColumn("OID");
         rs.addColumn("DESC");
  
         for (int j = 0; i.hasNext(); j++){
             dtop = (DTOParticipante)i.next();
      
             traza("dtop " + dtop);
             v = new Vector();
             v.add(dtop.getOid());
             v.add(dtop.getDescripcion());
             rs.addRow(v);
         }
  
         traza("retorna..."); 
         return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
    }

    //this.concurso.getCalificacionParticipantes().getLstCalificacionParticipantes() 
    //El parametro es un ArrayList de DTOCalificacionParticipante.
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        09/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private DruidaConector generarConectorClasificacionParticipantes(ArrayList alClParticipantes) 
             throws Exception {
                  traza("********** Entro a generarConectorClasificacionParticipantes");
    
         if (alClParticipantes == null || alClParticipantes.isEmpty()){
             return null;
         }

         Iterator i = alClParticipantes.iterator();
         DTOCalificacionParticipante dtop = null;

         RecordSet rs = new RecordSet();
         Vector v = null;
    
         rs.addColumn("OID"); //hidden
         rs.addColumn("OID_PARTI"); //hidden
         rs.addColumn("OID_ESTATUS_VENTA"); //hidden
         rs.addColumn("DESC_PARTI");
         rs.addColumn("DES_ESTATUS_VENTA");
         rs.addColumn("MONTO_MIN");

         for (int j = 0; i.hasNext(); j++){
                           dtop = (DTOCalificacionParticipante)i.next();
                           traza("*********** DTOCalificacionParticipante " + i + " : " + dtop);
                           v = new Vector();
             //v.add(dtop.getOid());
                           v.add(new Integer(j + 1));
             v.add(dtop.getOidParticipante()!=null?dtop.getOidParticipante().toString():"");
                           v.add(dtop.getOidEstatusVenta()!=null?dtop.getOidEstatusVenta().toString():"");
             v.add(dtop.getDesParticipante());
             v.add(dtop.getDesEstatusVenta());
             v.add(dtop.getMontoMinimo()!=null?dtop.getMontoMinimo().toString():"");
             rs.addRow(v);
         }
                  traza("********** rs " + rs);    
         return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        12/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     * @modified    enozigli
     */
    public void cargarPantallaVariablesVentaProyectada() throws Exception {
         /*
         * Se coloca en sesion (DTOConcurso)conectorParametroSesion("DTOModalVariablesVentaProyectada");
         * y (Long)conectorParametroSesion("OidAgrupacion"); por separado ya que una va en el 
         * DTOConcurso.variablesVentaProyectada y la otra en DTOConcurso.paramCalificacion.oidAgrupacion
         * ya que en la parte servidora se utilizaran en distintos lugares.
         */

         traza("Entra a cargarPantallaVariablesVentaProyectada()");
         this.concurso = this.getConcurso();   
    
         traza("asigna el menu secundario");
    
         this.menuVariablesVentaProyectada = "S";
    
         DTOVariablesVentaProyectada dtoVariablesVentaProyectada = null;
         Long oidAgrupacion = null;
    
         if (conectorParametroSesion("DTOModalVariablesVentaProyectada")==null){
             if (this.concurso != null && this.concurso.getIndVariablesVentaProyectada() != null 
                      && this.concurso.getIndVariablesVentaProyectada().booleanValue()){
                  dtoVariablesVentaProyectada = this.concurso.getVariablesVentaProyectada();
                  traza("Toma del dtoConcurso:dtoVariablesVentaProyectada:"+dtoVariablesVentaProyectada);
             
                  if (this.concurso.getParamCalificacion() != null 
                           && this.concurso.getParamCalificacion().getOidAgrupacion() != null){
                      oidAgrupacion = this.concurso.getParamCalificacion().getOidAgrupacion();
                      traza("Toma del dtoConcurso:oidAgrupacion:"+oidAgrupacion);
                  }
             }
         } else {
             dtoVariablesVentaProyectada = (DTOVariablesVentaProyectada)conectorParametroSesion("DTOModalVariablesVentaProyectada");              
             oidAgrupacion = (Long)conectorParametroSesion("OidAgrupacion");
             traza("Encontro en sesion DTOModalVariablesVentaProyectada:"+dtoVariablesVentaProyectada);
         }

         //Comienza - Agregado por Cristian Valenzuela 7/7/2005
         //Si todavia no ingreso a la modal Definir venta proyectada
         //se pone en null el DTOVariablesVentaProyectada del DTOConcurso
         if (concurso.getIndVariablesVentaProyectada().booleanValue()==false) {
             concurso.setVariablesVentaProyectada(null);
             dtoVariablesVentaProyectada = null;
         }
         
         setConcurso(concurso);
         //Finaliza - Agregado por Cristian Valenzuela 7/7/2005
    
         this.pagina("contenido_variables_venta_proyectada_mantener");
         getConfiguracionMenu("LPMantenerParametrosCalificacion","cargar variables venta proyectada");
         asignarAtributoPagina("cod", "0536");
    
         this.asignarAtributo("VAR", "accion", "valor", this.accion);
         this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
    
         //Carga las combos necesarias para la página 
         DTOBelcorp dtob = new DTOBelcorp();
    
         if (this.concurso!=null){
             dtob.setOidPais(this.concurso.getOidPais());
             dtob.setOidIdioma(this.concurso.getOidIdioma());
         } else {
             dtob.setOidPais(es.indra.sicc.util.UtilidadesSession.getPais(this));
             dtob.setOidIdioma(es.indra.sicc.util.UtilidadesSession.getIdioma(this));
         }
    
                  ComposerViewElementList cv = new ComposerViewElementList(); 
         ComposerViewElement cve = null;
    
         cve = new ComposerViewElement();
                  cve.setIDBusiness("INCObtenerAgrupacionPorConcurso");
                  cve.setDTOE(dtob);
         cv.addViewElement(cve);
    
         ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
         DruidaConector resultados = null;
    
         conector.ejecucion();
         resultados = conector.getConector();
         asignar("COMBO", "cbAgrupacion", resultados, "INCObtenerAgrupacionPorConcurso");
    
         //Si es true el indicador de que ya se había rellenado la pestaña, 
         //se carga la página con esos datos.    
         if (dtoVariablesVentaProyectada!=null){
             if (dtoVariablesVentaProyectada.getOid() != null){
                  this.asignarAtributo("VAR", "oidVariablesVentaProyectada", "valor", 
                      dtoVariablesVentaProyectada.getOid().toString());
             }
           
             if (oidAgrupacion != null){
                  this.asignarAtributo("VAR", "hCbAgrupacion", "valor", oidAgrupacion.toString());
                                    conectorParametroSesion("OidAgrupacion",oidAgrupacion);
             }

             if (dtoVariablesVentaProyectada.getIndActivas() != null){
                  this.asignarAtributo("VAR", "hCkActivas", "valor", 
                      dtoVariablesVentaProyectada.getIndActivas().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndIngreso() != null){
                  this.asignarAtributo("VAR", "hCkIngreso", "valor", 
                      dtoVariablesVentaProyectada.getIndIngreso().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndReingreso() != null){
                  this.asignarAtributo("VAR", "hCkReingreso", "valor", 
                      dtoVariablesVentaProyectada.getIndReingreso().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndEgresos() != null){
                  this.asignarAtributo("VAR", "hCkEgresos", "valor", 
                      dtoVariablesVentaProyectada.getIndEgresos().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndEntregadas() != null){
                  this.asignarAtributo("VAR", "hCkEntregadas", "valor", 
                      dtoVariablesVentaProyectada.getIndEntregadas().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndRecibidas() != null){
                  this.asignarAtributo("VAR", "hCkRecibidas", "valor", 
                      dtoVariablesVentaProyectada.getIndRecibidas().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndCapitalizacion() != null){
                  this.asignarAtributo("VAR", "hCkCapitalizacion", "valor", 
                      dtoVariablesVentaProyectada.getIndCapitalizacion().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndActivasFinales() != null){
                  this.asignarAtributo("VAR", "hCkActivasFinales", "valor", 
                      dtoVariablesVentaProyectada.getIndActivasFinales().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndActividad() != null){
                  this.asignarAtributo("VAR", "hCkActividad", "valor", 
                      dtoVariablesVentaProyectada.getIndActividad().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndNumeroPedidos() != null){
                  this.asignarAtributo("VAR", "hCkNumpedidos", "valor", 
                      dtoVariablesVentaProyectada.getIndNumeroPedidos().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndPrecioPromedioUnitario() != null){
                  this.asignarAtributo("VAR", "hCkPrecioPromedioUnitario", "valor", 
                      dtoVariablesVentaProyectada.getIndPrecioPromedioUnitario().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndPromedioVentaPedido() != null){
                  this.asignarAtributo("VAR", "hCkPromedioVentaPedido", "valor", 
                      dtoVariablesVentaProyectada.getIndPromedioVentaPedido().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndPromedioUnidadesPedido() != null){
                  this.asignarAtributo("VAR", "hCkPromedioUnidadesPedido", "valor", 
                      dtoVariablesVentaProyectada.getIndPromedioUnidadesPedido().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndPromedioOrdenesPedido() != null){
                  this.asignarAtributo("VAR", "hCkPromedioOrdenesPedido", "valor", 
                      dtoVariablesVentaProyectada.getIndPromedioOrdenesPedido().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndRetencion() != null){
                  this.asignarAtributo("VAR", "hCkRetencion", "valor", 
                      dtoVariablesVentaProyectada.getIndRetencion().booleanValue()?"S":"N");
             }
             
             if (dtoVariablesVentaProyectada.getIndVentaEstadisticable() != null){
                  this.asignarAtributo("VAR", "hCkVentaEstadisticable", "valor", 
                      dtoVariablesVentaProyectada.getIndVentaEstadisticable().booleanValue()?"S":"N");
             }
         } else { //this.concurso.getIndVariablesVentaProyectada().booleanValue()
             //NO HAY INFORMACION
             this.asignarAtributo("VAR", "oidVariablesVentaProyectada", "valor", "");
             this.asignarAtributo("VAR", "hCkActivas", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkIngreso", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkReingreso", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkEgresos", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkEntregadas", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkRecibidas", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkCapitalizacion", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkActivasFinales", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkActividad", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkNumpedidos", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkPrecioPromedioUnitario", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkPromedioVentaPedido", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkPromedioUnidadesPedido", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkPromedioOrdenesPedido", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkRetencion", "valor", ConstantesINC.IND_INACTIVO.toString());
             this.asignarAtributo("VAR", "hCkVentaEstadisticable", "valor", ConstantesINC.IND_INACTIVO.toString());
         } //else
    
         //Si es una consulta se deshabilitan todos los checks
         if (this.opcionMenu.equalsIgnoreCase("Consultar concurso")){    
             this.asignarAtributo("VAR", "hHabilitarChks", "valor", "N");        
             //se  imagina que sera para el caso de consulta que se hace:
             //Se deshabilita el botón guardar del menú secundario 
         }

                    if( this.concurso.getVariablesVentaProyectada() != null){
                        this.asignarAtributo("VAR", "variablesVentaProyectada", "valor", this.concurso.getVariablesVentaProyectada().toString());
              }
         
         traza("Sale de cargarPantallaVariablesVentaProyectada()");
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        12/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     * @modified    enozigli
     */
    public void guardarEnSesionVariablesVentaProyectada() throws Exception {
         /*
         * Se dejan en sesion el dto y el long para que lo maneje la pestaña cuando lo quiera setear
         * en el dtoconcurso.
         */
         traza("Entra a guardarEnSesionVariablesVentaProyectada()");
         DTOVariablesVentaProyectada dtoVariablesVentaProyectada = new DTOVariablesVentaProyectada();
         Long oidAgrupacion = null;
    
         //this.concurso = this.getConcurso();
         //Rellena el dtoConcurso.variablesVentaProyectada 
         //this.concurso.setIndVariablesVentaProyectada(Boolean.TRUE);esta se debera setear en la pestaña

         String sOidAgrupacion = conectorParametroLimpia("cbAgrupacion","",true);
         String oidVariablesVentaProyectada = conectorParametroLimpia("oidVariablesVentaProyectada","",true);
         String valckActivas = conectorParametroLimpia("ckActivas","",true);
         String valckIngreso = conectorParametroLimpia("ckIngreso","",true); 
         String valckReingreso = conectorParametroLimpia("ckReingreso","",true);
         String valckEgresos = conectorParametroLimpia("ckEgresos","",true);
         String valckEntregadas = conectorParametroLimpia("ckEntregadas","",true);
         String valckRecibidas = conectorParametroLimpia("ckRecibidas","",true);
         String valckCapitalizacion = conectorParametroLimpia("ckCapitalizacion","",true);
         String valckActivasFinales = conectorParametroLimpia("ckActivasFinales","",true);
         String valckActividad = conectorParametroLimpia("ckActividad","",true);
         String valckNumpedidos = conectorParametroLimpia("ckNumpedidos","",true);
         String valckPrecioPromedioUnitario = conectorParametroLimpia("ckPrecioPromedioUnitario","",true);
         String valckPromedioVentaPedido = conectorParametroLimpia("ckPromedioVentaPedido","",true);
         String valckPromedioUnidadesPedido = conectorParametroLimpia("ckPromedioUnidadesPedido","",true);
         String valckPromedioOrdenesPedido = conectorParametroLimpia("ckPromedioOrdenesPedido","",true);
         String valckRetencion = conectorParametroLimpia("ckRetencion","",true);
         String valckVentaEstadisticable = conectorParametroLimpia("ckVentaEstadisticable","",true);

                    traza("ckActivas: " + valckActivas);
                    traza("ckIngreso: " + valckIngreso);
                    traza("ckReingreso: " + valckReingreso);
                    traza("ckRecibidas: " + valckRecibidas);
                    traza("ckCapitalizacion: " + valckCapitalizacion);
                    traza("ckActivasFinales: " + valckActivasFinales);
                    traza("ckActividad: " + valckActividad);
                    traza("valckNumpedidos: " + valckNumpedidos);
                    traza("valckPrecioPromedioUnitario: " + valckPrecioPromedioUnitario);
                    traza("valckPromedioVentaPedido: " + valckPromedioVentaPedido);
                    traza("valckPromedioUnidadesPedido: " + valckPromedioUnidadesPedido);
                    traza("valckPromedioOrdenesPedido: " + valckPromedioOrdenesPedido);
                    traza("valckRetencion: " + valckRetencion);
                    traza("valckVentaEstadisticable: " + valckVentaEstadisticable);


                    dtoVariablesVentaProyectada.setOid((!oidVariablesVentaProyectada.equals(""))?new Long(oidVariablesVentaProyectada):null);
         dtoVariablesVentaProyectada.setIndActivas((valckActivas.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndIngreso((valckIngreso.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndReingreso((valckReingreso.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndEgresos((valckEgresos.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndEntregadas((valckEntregadas.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndRecibidas((valckRecibidas.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndCapitalizacion((valckCapitalizacion.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndActivasFinales((valckActivasFinales.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndActividad((valckActividad.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndNumeroPedidos((valckNumpedidos.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndPrecioPromedioUnitario((valckPrecioPromedioUnitario.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndPromedioVentaPedido((valckPromedioVentaPedido.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndPromedioUnidadesPedido((valckPromedioUnidadesPedido.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndPromedioOrdenesPedido((valckPromedioOrdenesPedido.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndRetencion((valckRetencion.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
         dtoVariablesVentaProyectada.setIndVentaEstadisticable((valckVentaEstadisticable.equalsIgnoreCase("S"))?new Boolean(true):new Boolean(false));
    
         if (!sOidAgrupacion.equals("")){
             try {
                  oidAgrupacion = new Long(sOidAgrupacion);
             } catch (NumberFormatException ne){
                  //No es un nro. entonces paso null
                  traza("oidAgrupacion no es un nro:"+oidAgrupacion);
             }
         }
         
         traza("Pongo en sesion DTOModalVariablesVentaProyectada:"+dtoVariablesVentaProyectada);
         conectorParametroSesion("DTOModalVariablesVentaProyectada",dtoVariablesVentaProyectada);
         conectorParametroSesion("OidAgrupacion",oidAgrupacion);
         this.pagina("contenido_variables_venta_proyectada_mantener");

         this.asignarAtributo("VAR", "hCkActivas", "valor", valckActivas);
         this.asignarAtributo("VAR", "hCkIngreso", "valor", valckIngreso);
         this.asignarAtributo("VAR", "hCkReingreso", "valor", valckReingreso);
         this.asignarAtributo("VAR", "hCkEgresos", "valor", valckEgresos);
         this.asignarAtributo("VAR", "hCkEntregadas", "valor", valckEntregadas);
         this.asignarAtributo("VAR", "hCkRecibidas", "valor", valckRecibidas);
         this.asignarAtributo("VAR", "hCkCapitalizacion", "valor", valckCapitalizacion);
         this.asignarAtributo("VAR", "hCkActivasFinales", "valor", valckActivasFinales);
         this.asignarAtributo("VAR", "hCkActividad", "valor", valckActividad);
         this.asignarAtributo("VAR", "hCkNumpedidos", "valor", valckNumpedidos);
         this.asignarAtributo("VAR", "hCkPrecioPromedioUnitario", "valor", valckPrecioPromedioUnitario);
         this.asignarAtributo("VAR", "hCkPromedioVentaPedido", "valor", valckPromedioVentaPedido);
         this.asignarAtributo("VAR", "hCkPromedioUnidadesPedido", "valor", valckPromedioUnidadesPedido);
         this.asignarAtributo("VAR", "hCkPromedioOrdenesPedido", "valor", valckPromedioOrdenesPedido);
         this.asignarAtributo("VAR", "hCkRetencion", "valor", valckRetencion);
         this.asignarAtributo("VAR", "hCkVentaEstadisticable", "valor", valckVentaEstadisticable);

         this.asignarAtributo("VAR", "sOidAgrupacion", "valor", sOidAgrupacion);
         this.asignarAtributo("VAR", "hcerrar", "valor", "S");
         traza("Sale de guardarEnSesionVariablesVentaProyectada()");
         //this.setConcurso(this.concurso); el set lo hara la pestaña
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        12/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void almacenarVariablesVentaProyectada() throws Exception {
         traza("Entra a almacenarVariablesVentaProyectada()");
         this.concurso = this.getConcurso();

         //Rellena el dtoConcurso.variablesVentaProyectada 
         this.concurso.setIndVariablesVentaProyectada(Boolean.TRUE);

         if (this.concurso.getVariablesVentaProyectada()==null){
             this.concurso.setVariablesVentaProyectada(new DTOVariablesVentaProyectada());
         }

         if (this.concurso.getParamCalificacion()==null){
             this.concurso.setParamCalificacion(new DTOParametrosCalificacion());
         }

         DTOVariablesVentaProyectada dtoVariablesVentaProyectada = (DTOVariablesVentaProyectada)conectorParametroSesion("DTOModalVariablesVentaProyectada");     
         traza("Encontro en sesion:dtoVariablesVentaProyectada:"+dtoVariablesVentaProyectada);
         Long oidAgrupacion = null;
         
         if (conectorParametroSesion("OidAgrupacion")!=null){
             oidAgrupacion = (Long)conectorParametroSesion("OidAgrupacion");
         }

         this.concurso.getVariablesVentaProyectada().setOid(dtoVariablesVentaProyectada.getOid());
         this.concurso.getVariablesVentaProyectada().setIndActivas(dtoVariablesVentaProyectada.getIndActivas());
         this.concurso.getVariablesVentaProyectada().setIndIngreso(dtoVariablesVentaProyectada.getIndIngreso());
         this.concurso.getVariablesVentaProyectada().setIndReingreso(dtoVariablesVentaProyectada.getIndReingreso());
         this.concurso.getVariablesVentaProyectada().setIndEgresos(dtoVariablesVentaProyectada.getIndEgresos());
         this.concurso.getVariablesVentaProyectada().setIndEntregadas(dtoVariablesVentaProyectada.getIndEntregadas());
         this.concurso.getVariablesVentaProyectada().setIndRecibidas(dtoVariablesVentaProyectada.getIndRecibidas());
         this.concurso.getVariablesVentaProyectada().setIndCapitalizacion(dtoVariablesVentaProyectada.getIndCapitalizacion());
         this.concurso.getVariablesVentaProyectada().setIndActivasFinales(dtoVariablesVentaProyectada.getIndActivasFinales());
         this.concurso.getVariablesVentaProyectada().setIndActividad(dtoVariablesVentaProyectada.getIndActividad());
         this.concurso.getVariablesVentaProyectada().setIndNumeroPedidos(dtoVariablesVentaProyectada.getIndNumeroPedidos());
         this.concurso.getVariablesVentaProyectada().setIndPrecioPromedioUnitario(dtoVariablesVentaProyectada.getIndPrecioPromedioUnitario());
         this.concurso.getVariablesVentaProyectada().setIndPromedioVentaPedido(dtoVariablesVentaProyectada.getIndPromedioVentaPedido());
         this.concurso.getVariablesVentaProyectada().setIndPromedioUnidadesPedido(dtoVariablesVentaProyectada.getIndPromedioUnidadesPedido());
         this.concurso.getVariablesVentaProyectada().setIndPromedioOrdenesPedido(dtoVariablesVentaProyectada.getIndPromedioOrdenesPedido());
         this.concurso.getVariablesVentaProyectada().setIndRetencion(dtoVariablesVentaProyectada.getIndRetencion());
         this.concurso.getVariablesVentaProyectada().setIndVentaEstadisticable(dtoVariablesVentaProyectada.getIndVentaEstadisticable());
         this.concurso.getParamCalificacion().setOidAgrupacion(oidAgrupacion);
    
         this.setConcurso(this.concurso);
         traza("Sale de almacenarVariablesVentaProyectada()");
    }		
			
		 //Metodo modificado por la incidencia 22393
		 //Cristian Valenzuela - 24/2/2006
         public void recargarCombosMetasVentaProyectada() throws Exception {
	         traza("LPMantenerParametrosCalificacion.recargarCombosMetasVentaProyectada() - Entrada");
             pagina("salidaGenerica");
             this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
             this.concurso = this.getConcurso();
             DTOListaMetasVentaProyectada dtoListaMetasTipoVta = null;
             DTOListaMetasVentaProyectada dtoListaMetasAuxiliar = null;	
             DTOOID dtoOid = new DTOOID();
             MareBusinessID id = null;
		     Vector params = new Vector();
			 DruidaConector con = null;

             String hCbUniAdmin = this.conectorParametroLimpia("hCbUniAdmin", "", true);

			 if (this.concurso.getParamGenerales() != null){
				if (this.concurso.getParamGenerales().getOid() == null){
					traza("this.concurso.getParamGenerales().getOidFicticio(): " 
                    + this.concurso.getParamGenerales().getOidFicticio());
                    
					dtoOid.setOid(this.concurso.getParamGenerales().getOidFicticio());
                }
				else {
	                traza("this.concurso.getParamGenerales().getOid(): " 
                    + this.concurso.getParamGenerales().getOid());
    
					dtoOid.setOid(this.concurso.getParamGenerales().getOid());
                }
             }
             
			 if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){
					traza("INCObtenerMetasVentaProyectadaSubgerencia");
					id = new MareBusinessID("INCObtenerMetasVentaProyectadaSubgerencia");
			 }
			 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){
					traza("INCObtenerMetasVentaProyectadaRegion");
					id = new MareBusinessID("INCObtenerMetasVentaProyectadaRegion");
			 }
			 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
					traza("INCObtenerMetasVentaProyectadaZona");
					id = new MareBusinessID("INCObtenerMetasVentaProyectadaZona");
			 }

			 dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia");
			 dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarRegion");
			 dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarZona");			

			 traza("********* dtoListaMetasAuxiliarSubgerencia " + dtoListaMetasAuxiliarSubgerencia);
			 traza("********* dtoListaMetasAuxiliarRegion " + dtoListaMetasAuxiliarRegion);
			 traza("********* dtoListaMetasAuxiliarZona " + dtoListaMetasAuxiliarZona);

			 if (id != null && dtoOid != null){
					params.add(dtoOid);
					params.add(id);
					con = this.conectar("ConectorObtenerMetasVentaProyectada", params);
                                    
					if (con != null){
						traza("CONECTOR");
						traza(con.getXML().toString());
                        dtoListaMetasAuxiliar = (DTOListaMetasVentaProyectada)con.objeto("dtoSalida");
						//Agregado por inc. 22393
					    if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){
							traza("********* Entro por subgerencia");
							if(dtoListaMetasAuxiliarSubgerencia==null) {
								dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)con.objeto("dtoSalida");
								conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia",
								dtoListaMetasAuxiliarSubgerencia);
							}
						}
						else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){
							traza("********* Entro por region");
							if(dtoListaMetasAuxiliarRegion==null) {							
							    dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)con.objeto("dtoSalida");
								conectorParametroSesion("dtoListaMetasAuxiliarRegion",dtoListaMetasAuxiliarRegion);
							}
						}
						else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
							traza("********* Entro por zona");
							if(dtoListaMetasAuxiliarZona==null) {							
								dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)con.objeto("dtoSalida");
								conectorParametroSesion("dtoListaMetasAuxiliarZona",dtoListaMetasAuxiliarZona);
							}
						}	
						//FIN-Agregado por inc. 22393
					}
			 }			 
             
             String cbClie = "";
             String cbPer = "";
             String listMetas = "";

             if(dtoListaMetasAuxiliar!=null && dtoListaMetasAuxiliar.getListaMetas()!=null 
				&& dtoListaMetasAuxiliar.getListaMetas().size()>0){

				    //MODIFICADO - CVALENZU - 29/3/2006 - INC - DBLG500000528
					if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){
	                    traza("+++++ SUB +++++");
						this.concurso.getParamCalificacion().setListaMetasVentaProyectada(dtoListaMetasAuxiliarSubgerencia);											   
						traza("******** Llamando a generarCadenaComboCliente");
						cbClie = 
						generarCadenaComboCliente(this.concurso.getParamCalificacion().getListaMetasVentaProyectada().getListaMetas(), 
						LPMantenerParametrosCalificacion.FLAG_PROYECTADA);
						traza("******** cbClie: "+cbClie);							 
						//Cargamos la combo cbPeriodo [cbPeriodo]
						traza("******** Llamando a generarCadenaComboPeriodo");
						cbPer = 
						generarCadenaComboPeriodo(this.concurso.getParamCalificacion().getListaMetasVentaProyectada().getListaMetas());
						traza("******** cbPer: "+cbPer);
					}
					else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){
	                    traza("+++++ REG +++++");
						this.concurso.getParamCalificacion().setListaMetasVentaProyectadaRegion(dtoListaMetasAuxiliarRegion);					
						traza("******** Llamando a generarCadenaComboCliente");
						cbClie = 
						generarCadenaComboCliente(this.concurso.getParamCalificacion().getListaMetasVentaProyectadaRegion().getListaMetas(), 
						LPMantenerParametrosCalificacion.FLAG_PROYECTADA);
						traza("******** cbClie: "+cbClie);							 
						//Cargamos la combo cbPeriodo [cbPeriodo]
						traza("******** Llamando a generarCadenaComboPeriodo");
						cbPer = 
						generarCadenaComboPeriodo(this.concurso.getParamCalificacion().getListaMetasVentaProyectadaRegion().getListaMetas());
						traza("******** cbPer: "+cbPer);
					}
					else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
	                    traza("+++++ ZON +++++");
						this.concurso.getParamCalificacion().setListaMetasVentaProyectadaZona(dtoListaMetasAuxiliarZona);					
						traza("******** Llamando a generarCadenaComboCliente");
						cbClie = 
						generarCadenaComboCliente(this.concurso.getParamCalificacion().getListaMetasVentaProyectadaZona().getListaMetas(), 
						LPMantenerParametrosCalificacion.FLAG_PROYECTADA);
						traza("******** cbClie: "+cbClie);							 
						//Cargamos la combo cbPeriodo [cbPeriodo]
						traza("******** Llamando a generarCadenaComboPeriodo");
						cbPer = 
						generarCadenaComboPeriodo(this.concurso.getParamCalificacion().getListaMetasVentaProyectadaZona().getListaMetas());
						traza("******** cbPer: "+cbPer);
					}
					
				    //FIN - MODIFICADO - CVALENZU - 29/3/2006 - DBLG500000528

					//Agregado por CVALENZU
					if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){
						traza("**********recargando lista por subgerencia");
						listMetas = generarStrListaMetasVentaProyectadaSubgerencia(dtoListaMetasAuxiliarSubgerencia.getListaMetas());										
					}
					else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){
						traza("**********recargando lista por region");
						listMetas = generarStrListaMetasVentaProyectadaRegion(dtoListaMetasAuxiliarRegion.getListaMetas());					
					}
					else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
						traza("**********recargando lista por zona");
						listMetas = generarStrListaMetasVentaProyectadaZona(dtoListaMetasAuxiliarZona.getListaMetas());
					}
					//FIN - Agregado por CVALENZU
                    
             }

			 dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia");
			 dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarRegion");
			 dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarZona");			

			 traza("********* dtoListaMetasAuxiliarSubgerencia " + dtoListaMetasAuxiliarSubgerencia);
			 traza("********* dtoListaMetasAuxiliarRegion " + dtoListaMetasAuxiliarRegion);
			 traza("********* dtoListaMetasAuxiliarZona " + dtoListaMetasAuxiliarZona);

 			 traza("############### listMetas: " + listMetas);			 

			 asignarAtributo("VAR", "ejecutar", "valor", "vuelvoDeRecargaDeCombos('"+
				 cbPer+"','"+
				 cbClie+"','"+
				 listMetas+"')");
         }

         public String armarListaVarVta() throws Exception{
                  this.concurso = this.getConcurso();
                  String resultado = "";
                  DTOVariablesVentaProyectada dtov = concurso.getVariablesVentaProyectada();
                  if (dtov!=null){
                           resultado = 
                           dtov.getIndActivas().toString()+";"+
                           dtov.getIndIngreso().toString()+";"+
                           dtov.getIndReingreso().toString()+";"+
                           dtov.getIndEgresos().toString()+";"+
                           dtov.getIndEntregadas().toString()+";"+
                           dtov.getIndRecibidas().toString()+";"+
                           dtov.getIndCapitalizacion().toString()+";"+
                           dtov.getIndActivasFinales().toString()+";"+
                           dtov.getIndActividad().toString()+";"+
                           dtov.getIndNumeroPedidos().toString()+";"+
                           dtov.getIndPrecioPromedioUnitario().toString()+";"+
                           dtov.getIndPromedioVentaPedido().toString()+";"+
                           dtov.getIndPromedioUnidadesPedido().toString()+";"+
                           dtov.getIndPromedioOrdenesPedido().toString()+";"+
                           dtov.getIndRetencion().toString()+";"+
                           dtov.getIndVentaEstadisticable();
                  }
                  traza("resultado: "+resultado);
                  return resultado;		
         }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       23/2/2006
     * Autor:       Cristian Valenzuela
	 * Incidencia:  22393 (La ultima version figura en esta incidencia)
     */
    public void cargarPantallaMetasVentaProyectada() throws Exception {  
         traza("LPMantenerParametrosCalificacion.cargarPantallaMetasVentaProyectada() - Entrada");  
         this.concurso = this.getConcurso();

         if (this.concurso.getParamCalificacion() == null){
             this.almacenar();
         }

         traza("****** oidAgrupacion: " + this.concurso.getParamCalificacion().getOidAgrupacion());

         Long oidAgrup = (Long)conectorParametroSesion("OidAgrupacion");
         traza("********** oidAgrup " + oidAgrup);
         if(oidAgrup!=null){
	         concurso.getParamCalificacion().setOidAgrupacion(oidAgrup);
         }
                           
         String tempCkActivas = this.conectorParametroLimpia("tempCkActivas", "", true);
         //SE SETEAN LOS 16 CHECKBOX
         if (!tempCkActivas.equals("")){
	         String tempCkIngreso = this.conectorParametroLimpia("tempCkIngreso", "", true);
             String tempCkReingreso = this.conectorParametroLimpia("tempCkReingreso", "", true);
             String tempCkEgresos = this.conectorParametroLimpia("tempCkEgresos", "", true);
             String tempCkEntregadas = this.conectorParametroLimpia("tempCkEntregadas", "", true);
             String tempCkRecibidas = this.conectorParametroLimpia("tempCkRecibidas", "", true);
             String tempCkCapitalizacion = this.conectorParametroLimpia("tempCkCapitalizacion", "", true);
             String tempCkActivasFinales = this.conectorParametroLimpia("tempCkActivasFinales", "", true);
             String tempCkActividad = this.conectorParametroLimpia("tempCkActividad", "", true);
             String tempCkNumpedidos = this.conectorParametroLimpia("tempCkNumpedidos", "", true);
             String tempCkPrecioPromedioUnitario = 
			 this.conectorParametroLimpia("tempCkPrecioPromedioUnitario", "", true);
             
			 String tempCkPromedioVentaPedido = this.conectorParametroLimpia("tempCkPromedioVentaPedido", "", true);
             String tempCkPromedioUnidadesPedido = 
			 this.conectorParametroLimpia("tempCkPromedioUnidadesPedido", "", true);
             
			 String tempCkPromedioOrdenesPedido = 
			 this.conectorParametroLimpia("tempCkPromedioOrdenesPedido", "", true);
             
			 String tempCkRetencion = this.conectorParametroLimpia("tempCkRetencion", "", true);
             String tempCkVentaEstadisticable = this.conectorParametroLimpia("tempCkVentaEstadisticable", "", true);

             traza("********** tempCkActivas " + tempCkActivas);
             traza("********** tempCkIngreso " + tempCkIngreso);
             traza("********** tempCkReingreso " + tempCkReingreso);
             traza("********** tempCkEgresos " + tempCkEgresos);
             traza("********** tempCkEntregadas " + tempCkEntregadas);
             traza("********** tempCkRecibidas " + tempCkRecibidas);
             traza("********** tempCkCapitalizacion " + tempCkCapitalizacion);
             traza("********** tempCkActivasFinales " + tempCkActivasFinales);
             traza("********** tempCkActividad " + tempCkActividad);
             traza("********** tempCkNumpedidos " + tempCkNumpedidos);
             traza("********** tempCkPrecioPromedioUnitario " + tempCkPrecioPromedioUnitario);
             traza("********** tempCkPromedioVentaPedido " + tempCkPromedioVentaPedido);
             traza("********** tempCkPromedioUnidadesPedido " + tempCkPromedioUnidadesPedido);
             traza("********** tempCkPromedioOrdenesPedido " + tempCkPromedioOrdenesPedido);
             traza("********** tempCkRetencion " + tempCkRetencion);
             traza("********** tempCkVentaEstadisticable " + tempCkVentaEstadisticable);

             DTOVariablesVentaProyectada dtoVariables = new DTOVariablesVentaProyectada();
             //Linea 1
             //-------
             //Activas
             if(tempCkActivas.equals("S")) dtoVariables.setIndActivas(new Boolean(true));
             else dtoVariables.setIndActivas(new Boolean(false));
             //Ingreso
             if(tempCkIngreso.equals("S")) dtoVariables.setIndIngreso(new Boolean(true));
             else dtoVariables.setIndIngreso(new Boolean(false));
             //Reingreso
             if(tempCkReingreso.equals("S")) dtoVariables.setIndReingreso(new Boolean(true));
             else dtoVariables.setIndReingreso(new Boolean(false));
             //Egresos
             if(tempCkEgresos.equals("S")) dtoVariables.setIndEgresos(new Boolean(true));
             else dtoVariables.setIndEgresos(new Boolean(false));
             //Entregadas
			 if(tempCkEntregadas.equals("S")) dtoVariables.setIndEntregadas(new Boolean(true));
             else dtoVariables.setIndEntregadas(new Boolean(false));
             //Recibidas
             if(tempCkRecibidas.equals("S")) dtoVariables.setIndRecibidas(new Boolean(true));
             else dtoVariables.setIndRecibidas(new Boolean(false));
             //Capitalizacion
             if(tempCkCapitalizacion.equals("S")) dtoVariables.setIndCapitalizacion(new Boolean(true));
             else dtoVariables.setIndCapitalizacion(new Boolean(false));
             //Linea 2
             //-------
             //Activas finales
			 if(tempCkActivasFinales.equals("S")) dtoVariables.setIndActivasFinales(new Boolean(true));
			 else dtoVariables.setIndActivasFinales(new Boolean(false));
			 //Actividad
			 if(tempCkActividad.equals("S")) dtoVariables.setIndActividad(new Boolean(true));
			 else dtoVariables.setIndActividad(new Boolean(false));
			 //N° pedidos
			 if(tempCkNumpedidos.equals("S")) dtoVariables.setIndNumeroPedidos(new Boolean(true));
			 else dtoVariables.setIndNumeroPedidos(new Boolean(false));
			 //Precio promedio unitario
			 if(tempCkPrecioPromedioUnitario.equals("S")) dtoVariables.setIndPrecioPromedioUnitario(new Boolean(true));
			 else dtoVariables.setIndPrecioPromedioUnitario(new Boolean(false));
			 //Promedio venta pedido
			 if(tempCkPromedioVentaPedido.equals("S")) dtoVariables.setIndPromedioVentaPedido(new Boolean(true));
			 else dtoVariables.setIndPromedioVentaPedido(new Boolean(false));
			 //Linea 3
			 //-------
			 //Promedio unidades pedido
			 if(tempCkPromedioUnidadesPedido.equals("S")) dtoVariables.setIndPromedioUnidadesPedido(new  Boolean(true));
			 else dtoVariables.setIndPromedioUnidadesPedido(new Boolean(false));
			 //Promedio ordenes pedido
			 if(tempCkPromedioOrdenesPedido.equals("S")) dtoVariables.setIndPromedioOrdenesPedido(new Boolean(true));
			 else dtoVariables.setIndPromedioOrdenesPedido(new Boolean(false));
			 //Retencion
			 if(tempCkRetencion.equals("S")) dtoVariables.setIndRetencion(new Boolean(true));
			 else dtoVariables.setIndRetencion(new Boolean(false));
			 //Venta estadisticable
			 if(tempCkVentaEstadisticable.equals("S")) dtoVariables.setIndVentaEstadisticable(new Boolean(true));
			 else dtoVariables.setIndVentaEstadisticable(new Boolean(false));
			 //Se setea el DTOVariablesVentaProyectada al DTOConcurso de sesion
			 this.concurso.setVariablesVentaProyectada(dtoVariables);
			 this.setConcurso(this.concurso);
         }
                                    
         //yyy
         if ($DEBUG == true){
             traza("entro por DEBUG 1");
             this.concurso.getParamGenerales().setOidFicticio(new Long(1));
             this.concurso.getParamCalificacion().setOidAgrupacion(new Long(1));
             this.setConcurso(this.concurso);
         }

         this.pagina("contenido_metas_ventas_proyectadas_mantener");                  
		 //Agregado por Cristian Valenzuela - Incidencia 22114
		 //3/3/2006 
		 configurarColumnasOcultas();
 		 //FIN - Agregado por Cristian Valenzuela - Incidencia 22114

		 if (this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){
			//22399
            this.asignarAtributoPagina("cod", "01033");
            this.asignarAtributo("VAR", "hMostrarBtnModificar", "valor", "N");
         }
		 else{
			this.asignarAtributoPagina("cod", "0549");		
         }

         this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
         this.asignarAtributo("VAR", "accion", "valor", this.accion);
         
		 //Cleal - 22113
         this.asignarAtributo("VAR", "hconst_oid_reg", "valor", 
	     ConstantesINC.OID_AGRUPACION_REGION.toString());
         
		 this.asignarAtributo("VAR", "hconst_oid_sub", "valor", 
		 ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString());
         
		 this.asignarAtributo("VAR", "hconst_oid_zon", "valor", 
		 ConstantesINC.OID_AGRUPACION_ZONA.toString());
         //Cleal - 22114
         this.asignarAtributo("VAR", "hlistaVarVta", "valor", armarListaVarVta());

         //--NUEVO - INC.
         //DTOListaMetasTipoVenta dtoListaMetasTipoVta = null;
         DTOListaMetasVentaProyectada dtoListaMetasTipoVta = null;
         
         Long lIdioma = UtilidadesSession.getIdioma(this);
         Long lPais = UtilidadesSession.getPais(this);

		 DTOBelcorp dtob = new DTOBelcorp();
         dtob.setOidPais(lPais);
         dtob.setOidIdioma(lIdioma);
         ComposerViewElementList list = new ComposerViewElementList();
         ComposerViewElement cve = new ComposerViewElement();
         cve.setIDBusiness("INCObtenerAgrupacionPorConcurso");
         cve.setDTOE(dtob);
         list.addViewElement(cve);
         ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
         conector.ejecucion();
         DruidaConector con = conector.getConector();
         asignar("COMBO", "cbUnidadAdmin", con, "INCObtenerAgrupacionPorConcurso");
    }

	private void configurarColumnasOcultas() throws Exception{
		traza("LPMantenerParametrosCalificacion.configurarColumnasOcultas - Entrada");
		this.concurso = this.getConcurso();

		if(concurso!=null && concurso.getVariablesVentaProyectada()!=null){
			this.asignarAtributo("VAR", "hEstadoActivas", "valor", 
				concurso.getVariablesVentaProyectada().getIndActivas().toString());

			this.asignarAtributo("VAR", "hEstadoIngreso", "valor", 
				concurso.getVariablesVentaProyectada().getIndIngreso().toString());
			
			this.asignarAtributo("VAR", "hEstadoReingreso", "valor", 
				concurso.getVariablesVentaProyectada().getIndReingreso().toString());
			
			this.asignarAtributo("VAR", "hEstadoEgresos", "valor", 
				concurso.getVariablesVentaProyectada().getIndEgresos().toString());
			
			this.asignarAtributo("VAR", "hEstadoEntregadas", "valor", 
				concurso.getVariablesVentaProyectada().getIndEntregadas().toString());
			
			this.asignarAtributo("VAR", "hEstadoRecibidas", "valor", 
				concurso.getVariablesVentaProyectada().getIndRecibidas().toString());
			
			this.asignarAtributo("VAR", "hEstadoCapitalizacion", "valor", 
				concurso.getVariablesVentaProyectada().getIndCapitalizacion().toString());
			
			this.asignarAtributo("VAR", "hEstadoActivasFinales", "valor", 
				concurso.getVariablesVentaProyectada().getIndActivasFinales().toString());
			
			this.asignarAtributo("VAR", "hEstadoActividad", "valor", 
				concurso.getVariablesVentaProyectada().getIndActividad().toString());
			
			this.asignarAtributo("VAR", "hEstadoNumeroPedidos", "valor", 
				concurso.getVariablesVentaProyectada().getIndNumeroPedidos().toString());
			
			this.asignarAtributo("VAR", "hEstadoPrecioPromedioUnitario", "valor", 
				concurso.getVariablesVentaProyectada().getIndPrecioPromedioUnitario().toString());
			
			this.asignarAtributo("VAR", "hEstadoPromedioVentaPedido", "valor", 
				concurso.getVariablesVentaProyectada().getIndPromedioVentaPedido().toString());
			
			this.asignarAtributo("VAR", "hEstadoPromedioUnidadesPedido", "valor", 
				concurso.getVariablesVentaProyectada().getIndPromedioUnidadesPedido().toString());
			
			this.asignarAtributo("VAR", "hEstadoPromedioOrdenesPedido", "valor", 
				concurso.getVariablesVentaProyectada().getIndPromedioOrdenesPedido().toString());
			
			this.asignarAtributo("VAR", "hEstadoRetencion", "valor", 
				concurso.getVariablesVentaProyectada().getIndRetencion().toString());
			
			this.asignarAtributo("VAR", "hEstadoVentaEstadisticable", "valor", 
				concurso.getVariablesVentaProyectada().getIndVentaEstadisticable().toString());
		}

		traza("LPMantenerParametrosCalificacion.configurarColumnasOcultas - Entrada");
	}
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        12/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private String generarStrListaMetasVentaProyectada(ArrayList listaMetas){
         StringBuffer sb = new StringBuffer();
         StringBuffer sbLinea = null;
         DTOMetasVentaProyectada dto = null;
         Iterator i = listaMetas.iterator();
    
         while (i.hasNext()){
             dto = (DTOMetasVentaProyectada)i.next();
             sbLinea = new StringBuffer();
             sbLinea.append(dto.getActividad()!=null?dto.getActividad() + ",":","); //Long
             sbLinea.append(dto.getCapitalizacion()!=null?dto.getCapitalizacion() + ",":","); //Long
             sbLinea.append(dto.getCodigoCliente()!=null?dto.getCodigoCliente() + ",":","); //String
             sbLinea.append(dto.getImpCapitalizacion()!=null?dto.getImpCapitalizacion() + ",":","); //BigDecimal
             sbLinea.append(dto.getImpEgresos()!=null?dto.getImpEgresos() + ",":","); //BigDecimal
             sbLinea.append(dto.getImpIngreso()!=null?dto.getImpIngreso() + ",":","); //BigDecimal
             sbLinea.append(dto.getImpReingreso()!=null?dto.getImpReingreso() + ",":","); //BigDecimal
             sbLinea.append(dto.getImpRetencion()!=null?dto.getImpRetencion() + ",":","); //BigDecimal
             sbLinea.append(dto.getImpVentaEstadisticable()!=null?dto.getImpVentaEstadisticable() + ",":","); //BigDecimal
             sbLinea.append(dto.getNombrePeriodo()!=null?dto.getNombrePeriodo() + ",":","); //String
             sbLinea.append(dto.getNumActivasFinales()!=null?dto.getNumActivasFinales() + ",":","); //Long
             sbLinea.append(dto.getNumActivasIniciales()!=null?dto.getNumActivasIniciales() + ",":","); //Long
             sbLinea.append(dto.getNumClientes()!=null?dto.getNumClientes() + ",":","); //Long
             sbLinea.append(dto.getNumEntregadas()!=null?dto.getNumEntregadas() + ",":","); //Long
             sbLinea.append(dto.getNumOrdenes()!=null?dto.getNumOrdenes() + ",":","); //Long
             sbLinea.append(dto.getNumPedidos()!=null?dto.getNumPedidos() + ",":","); //Long
             sbLinea.append(dto.getNumRecibidas()!=null?dto.getNumRecibidas() + ",":","); //Long
             sbLinea.append(dto.getNumUnidadesVendidas()!=null?dto.getNumUnidadesVendidas() + ",":","); //Long
             sbLinea.append(dto.getOid()!=null?dto.getOid() + ",":","); //Long
             sbLinea.append(dto.getOidCliente()!=null?dto.getOidCliente() + ",":","); //Long
             sbLinea.append(dto.getOidPeriodo()!=null?dto.getOidPeriodo() + ",":","); //Long
             sbLinea.append(dto.getOidUA()!=null?dto.getOidUA() + ",":","); //Long
             sbLinea.append(dto.getPrecioPromedioUnitario()!=null?dto.getPrecioPromedioUnitario() + ",":","); //BigDecimal
             sbLinea.append(dto.getPromedioOrdenesPedido()!=null?dto.getPromedioOrdenesPedido() + ",":","); //BigDecimal
             sbLinea.append(dto.getPromedioUnidadesPedido()!=null?dto.getPromedioUnidadesPedido() + ",":","); //BigDecimal
             sbLinea.append(dto.getPromedioVentaPedido()!=null?dto.getPromedioVentaPedido() + ",":","); //BigDecimal
             sbLinea.append(dto.getRetencion()!=null?dto.getRetencion() + "|":"|"); //Long
             sb.append(sbLinea.toString());
         }
    
         return sb.toString();
    }

	    private String generarStrListaMetasVentaProyectadaRegion(ArrayList listaMetas) throws Exception{
		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaRegion() - Entrada");
         StringBuffer sb = new StringBuffer();
         StringBuffer sbLinea = null;
         DTOMetasVentaProyectada dto = null;
         Iterator i = listaMetas.iterator();
    
         while (i.hasNext()){
             dto = (DTOMetasVentaProyectada)i.next();
             sbLinea = new StringBuffer();
             sbLinea.append(dto.getActividad()!=null?dto.getActividad() + ",":","); //0Long
             sbLinea.append(dto.getCapitalizacion()!=null?dto.getCapitalizacion() + ",":","); //1Long
             sbLinea.append(dto.getCodigoCliente()!=null?dto.getCodigoCliente() + ",":","); //2String
             sbLinea.append(dto.getImpCapitalizacion()!=null?dto.getImpCapitalizacion() + ",":","); //3BigDecimal
             sbLinea.append(dto.getImpEgresos()!=null?dto.getImpEgresos() + ",":","); //4BigDecimal
             sbLinea.append(dto.getImpIngreso()!=null?dto.getImpIngreso() + ",":","); //5BigDecimal
             sbLinea.append(dto.getImpReingreso()!=null?dto.getImpReingreso() + ",":","); //6BigDecimal
             sbLinea.append(dto.getImpRetencion()!=null?dto.getImpRetencion() + ",":","); //7BigDecimal
             sbLinea.append(dto.getImpVentaEstadisticable()!=null?dto.getImpVentaEstadisticable() + ",":","); //8BigDecimal
             sbLinea.append(dto.getNombrePeriodo()!=null?dto.getNombrePeriodo() + ",":","); //9String
             sbLinea.append(dto.getNumActivasFinales()!=null?dto.getNumActivasFinales() + ",":","); //10Long
             sbLinea.append(dto.getNumActivasIniciales()!=null?dto.getNumActivasIniciales() + ",":","); //11Long
             sbLinea.append(dto.getNumClientes()!=null?dto.getNumClientes() + ",":","); //12Long
             sbLinea.append(dto.getNumEntregadas()!=null?dto.getNumEntregadas() + ",":","); //13Long
             sbLinea.append(dto.getNumOrdenes()!=null?dto.getNumOrdenes() + ",":","); //14Long
             sbLinea.append(dto.getNumPedidos()!=null?dto.getNumPedidos() + ",":","); //15Long
             sbLinea.append(dto.getNumRecibidas()!=null?dto.getNumRecibidas() + ",":","); //16Long
             sbLinea.append(dto.getNumUnidadesVendidas()!=null?dto.getNumUnidadesVendidas() + ",":","); //17Long
             sbLinea.append(dto.getOid()!=null?dto.getOid() + ",":","); //18Long
             sbLinea.append(dto.getOidCliente()!=null?dto.getOidCliente() + ",":","); //19Long
             sbLinea.append(dto.getOidPeriodo()!=null?dto.getOidPeriodo() + ",":","); //20Long
             sbLinea.append(dto.getOidUA()!=null?dto.getOidUA() + ",":","); //21Long
             sbLinea.append(dto.getPrecioPromedioUnitario()!=null?dto.getPrecioPromedioUnitario() + ",":","); //22BigDecimal
             sbLinea.append(dto.getPromedioOrdenesPedido()!=null?dto.getPromedioOrdenesPedido() + ",":","); //23BigDecimal
             sbLinea.append(dto.getPromedioUnidadesPedido()!=null?dto.getPromedioUnidadesPedido() + ",":","); //24BigDecimal
             sbLinea.append(dto.getPromedioVentaPedido()!=null?dto.getPromedioVentaPedido() + ",":","); //25BigDecimal
             sbLinea.append(dto.getRetencion()!=null?dto.getRetencion() + "|":"|"); //26Long
             sb.append(sbLinea.toString());
         }
		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaRegion() - Salida");
         return sb.toString();
    }

	private String generarStrListaMetasVentaProyectadaSubgerencia(ArrayList listaMetas) throws Exception{
		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaSubgerencia() - Entrada");
         StringBuffer sb = new StringBuffer();
         StringBuffer sbLinea = null;
         DTOMetasVentaProyectada dto = null;
         Iterator i = listaMetas.iterator();
    
         while (i.hasNext()){
             dto = (DTOMetasVentaProyectada)i.next();
             sbLinea = new StringBuffer();
             sbLinea.append(dto.getActividad()!=null?dto.getActividad() + ",":","); //0Long
             sbLinea.append(dto.getCapitalizacion()!=null?dto.getCapitalizacion() + ",":","); //1Long
             sbLinea.append(dto.getCodigoCliente()!=null?dto.getCodigoCliente() + ",":","); //2String
             sbLinea.append(dto.getImpCapitalizacion()!=null?dto.getImpCapitalizacion() + ",":","); //3BigDecimal
             sbLinea.append(dto.getImpEgresos()!=null?dto.getImpEgresos() + ",":","); //4BigDecimal
             sbLinea.append(dto.getImpIngreso()!=null?dto.getImpIngreso() + ",":","); //5BigDecimal
             sbLinea.append(dto.getImpReingreso()!=null?dto.getImpReingreso() + ",":","); //6BigDecimal
             sbLinea.append(dto.getImpRetencion()!=null?dto.getImpRetencion() + ",":","); //7BigDecimal
             sbLinea.append(dto.getImpVentaEstadisticable()!=null?dto.getImpVentaEstadisticable() + ",":","); //8BigDecimal
             sbLinea.append(dto.getNombrePeriodo()!=null?dto.getNombrePeriodo() + ",":","); //9String
             sbLinea.append(dto.getNumActivasFinales()!=null?dto.getNumActivasFinales() + ",":","); //10Long
             sbLinea.append(dto.getNumActivasIniciales()!=null?dto.getNumActivasIniciales() + ",":","); //11Long
             sbLinea.append(dto.getNumClientes()!=null?dto.getNumClientes() + ",":","); //12Long
             sbLinea.append(dto.getNumEntregadas()!=null?dto.getNumEntregadas() + ",":","); //13Long
             sbLinea.append(dto.getNumOrdenes()!=null?dto.getNumOrdenes() + ",":","); //14Long
             sbLinea.append(dto.getNumPedidos()!=null?dto.getNumPedidos() + ",":","); //15Long
             sbLinea.append(dto.getNumRecibidas()!=null?dto.getNumRecibidas() + ",":","); //16Long
             sbLinea.append(dto.getNumUnidadesVendidas()!=null?dto.getNumUnidadesVendidas() + ",":","); //17Long
             sbLinea.append(dto.getOid()!=null?dto.getOid() + ",":","); //18Long
             sbLinea.append(dto.getOidCliente()!=null?dto.getOidCliente() + ",":","); //19Long
             sbLinea.append(dto.getOidPeriodo()!=null?dto.getOidPeriodo() + ",":","); //20Long
             sbLinea.append(dto.getOidUA()!=null?dto.getOidUA() + ",":","); //21Long
             sbLinea.append(dto.getPrecioPromedioUnitario()!=null?dto.getPrecioPromedioUnitario() + ",":","); //22BigDecimal
             sbLinea.append(dto.getPromedioOrdenesPedido()!=null?dto.getPromedioOrdenesPedido() + ",":","); //23BigDecimal
             sbLinea.append(dto.getPromedioUnidadesPedido()!=null?dto.getPromedioUnidadesPedido() + ",":","); //24BigDecimal
             sbLinea.append(dto.getPromedioVentaPedido()!=null?dto.getPromedioVentaPedido() + ",":","); //25BigDecimal
             sbLinea.append(dto.getRetencion()!=null?dto.getRetencion() + "|":"|"); //26Long
             sb.append(sbLinea.toString());
         }

		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaSubgerencia() - Salida");    
         return sb.toString();
    }


	private String generarStrListaMetasVentaProyectadaZona(ArrayList listaMetas) throws Exception{
		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaZona() - Entrada");    
         StringBuffer sb = new StringBuffer();
         StringBuffer sbLinea = null;
         DTOMetasVentaProyectada dto = null;
         Iterator i = listaMetas.iterator();
    
         while (i.hasNext()){
             dto = (DTOMetasVentaProyectada)i.next();
             sbLinea = new StringBuffer();
             sbLinea.append(dto.getActividad()!=null?dto.getActividad() + ",":","); //00Long
             sbLinea.append(dto.getCapitalizacion()!=null?dto.getCapitalizacion() + ",":","); //01Long
             sbLinea.append(dto.getCodigoCliente()!=null?dto.getCodigoCliente() + ",":","); //02String
             sbLinea.append(dto.getImpCapitalizacion()!=null?dto.getImpCapitalizacion() + ",":","); //03BigDecimal
             sbLinea.append(dto.getImpEgresos()!=null?dto.getImpEgresos() + ",":","); //04BigDecimal
             sbLinea.append(dto.getImpIngreso()!=null?dto.getImpIngreso() + ",":","); //05BigDecimal
             sbLinea.append(dto.getImpReingreso()!=null?dto.getImpReingreso() + ",":","); //06BigDecimal
             sbLinea.append(dto.getImpRetencion()!=null?dto.getImpRetencion() + ",":","); //07BigDecimal
             sbLinea.append(dto.getImpVentaEstadisticable()!=null?dto.getImpVentaEstadisticable() + ",":","); //08BigDecimal
             sbLinea.append(dto.getNombrePeriodo()!=null?dto.getNombrePeriodo() + ",":","); //09String
             sbLinea.append(dto.getNumActivasFinales()!=null?dto.getNumActivasFinales() + ",":","); //10Long
             sbLinea.append(dto.getNumActivasIniciales()!=null?dto.getNumActivasIniciales() + ",":","); //11Long
             sbLinea.append(dto.getNumClientes()!=null?dto.getNumClientes() + ",":","); //12Long
             sbLinea.append(dto.getNumEntregadas()!=null?dto.getNumEntregadas() + ",":","); //13Long
             sbLinea.append(dto.getNumOrdenes()!=null?dto.getNumOrdenes() + ",":","); //14Long
             sbLinea.append(dto.getNumPedidos()!=null?dto.getNumPedidos() + ",":","); //15Long
             sbLinea.append(dto.getNumRecibidas()!=null?dto.getNumRecibidas() + ",":","); //16Long
             sbLinea.append(dto.getNumUnidadesVendidas()!=null?dto.getNumUnidadesVendidas() + ",":","); //17Long
             sbLinea.append(dto.getOid()!=null?dto.getOid() + ",":","); //18Long
             sbLinea.append(dto.getOidCliente()!=null?dto.getOidCliente() + ",":","); //19Long
             sbLinea.append(dto.getOidPeriodo()!=null?dto.getOidPeriodo() + ",":","); //20Long
             sbLinea.append(dto.getOidUA()!=null?dto.getOidUA() + ",":","); //21Long
             sbLinea.append(dto.getPrecioPromedioUnitario()!=null?dto.getPrecioPromedioUnitario() + ",":","); //22BigDecimal
             sbLinea.append(dto.getPromedioOrdenesPedido()!=null?dto.getPromedioOrdenesPedido() + ",":","); //23BigDecimal
             sbLinea.append(dto.getPromedioUnidadesPedido()!=null?dto.getPromedioUnidadesPedido() + ",":","); //24BigDecimal
             sbLinea.append(dto.getPromedioVentaPedido()!=null?dto.getPromedioVentaPedido() + ",":","); //25BigDecimal
             sbLinea.append(dto.getRetencion()!=null?dto.getRetencion() + "|":"|"); //26Long
             sb.append(sbLinea.toString());
         }

		 traza("LPMantenerParametrosCalificacion.generarStrListaMetasVentaProyectadaZona() - Salida");        
         return sb.toString();
    }

         private String generarCadenaComboCliente(ArrayList listaMetas, int flag) 
	        throws Exception {
	        Iterator i = listaMetas.iterator();
		    DTOMetasVentaProyectada dtoMVP = null;
            DTOMetasTipoVenta dtoMTV = null;
			RecordSet rs = new RecordSet();
			Vector v = null;
    
			rs.addColumn("OID");
			rs.addColumn("DESC");
    
			for (int j = 0; i.hasNext(); j++){      
				if(flag == LPMantenerParametrosCalificacion.FLAG_PROYECTADA) {
					dtoMVP = (DTOMetasVentaProyectada)i.next();
                    v = new Vector();
         
                    v.add(dtoMVP.getOidCliente());
                    v.add(dtoMVP.getCodigoCliente());
                 }
                 else {
					dtoMTV = (DTOMetasTipoVenta)i.next();
                    v = new Vector();
         
                    v.add(dtoMTV.getOidCliente());
                    v.add(dtoMTV.getCodigoCliente());                                    
				 }      

                 //Verificacion para no ingresar datos repetidos
                 if(rs.getRowCount()>0) {
					int contador = 0;

					for(int k=0; k<rs.getRowCount(); k++) {	
						Long oidCliente = (Long)rs.getValueAt(k,0);
                        Long oidClienteNuevo = (Long)v.get(0);
 
						if(oidCliente.longValue() == oidClienteNuevo.longValue()) contador++;
                    }

                    if(contador==0) rs.addRow(v);
                  }
                  else {
					rs.addRow(v);
                  }		
                 //Verificacion para no ingresar datos repetidos
		      }
              
			  traza("*************** rs " + rs);
              RecordSet rsFinal = ordenaDescripcionesCombo(rs);
              traza("*************** rsFinal " + rsFinal);
              return transformarRecordSetToString(rsFinal);
         }
  
         //CARGA COMBO CLIENTE
		 private DruidaConector generarConectorComboCliente(ArrayList listaMetas, int flag) 
			throws Exception {
        
			traza("******** Entro a generarConectorComboCliente");
	        Iterator i = listaMetas.iterator();
		    DTOMetasVentaProyectada dtoMVP = null;
            DTOMetasTipoVenta dtoMTV = null;
			RecordSet rs = new RecordSet();
			Vector v = null;
    
			rs.addColumn("OID");
			rs.addColumn("DESC");
    
			for (int j = 0; i.hasNext(); j++){      
				if(flag == LPMantenerParametrosCalificacion.FLAG_PROYECTADA) {
					dtoMVP = (DTOMetasVentaProyectada)i.next();
                    v = new Vector();
         
                    v.add(dtoMVP.getOidCliente());
                    v.add(dtoMVP.getCodigoCliente());
                 }
                 else {
					dtoMTV = (DTOMetasTipoVenta)i.next();
                    v = new Vector();
         
                    v.add(dtoMTV.getOidCliente());
                    v.add(dtoMTV.getCodigoCliente());                                    
				 }      

                 //Verificacion para no ingresar datos repetidos
                 if(rs.getRowCount()>0) {
					int contador = 0;

					for(int k=0; k<rs.getRowCount(); k++) {	
						Long oidCliente = (Long)rs.getValueAt(k,0);
                        Long oidClienteNuevo = (Long)v.get(0);
 
						if(oidCliente.longValue() == oidClienteNuevo.longValue()) contador++;
                    }

                    if(contador==0) rs.addRow(v);
                  }
                  else {
					rs.addRow(v);
                  }		
                 //Verificacion para no ingresar datos repetidos
		      }
              
			  traza("*************** rs " + rs);
              RecordSet rsFinal = ordenaDescripcionesCombo(rs);
              traza("*************** rsFinal " + rsFinal);
			  return UtilidadesBelcorp.generarConector("dtoSalida", rsFinal, rsFinal.getColumnIdentifiers());
    }

         private String generarCadenaComboPeriodo(ArrayList listaMetas) 
	        throws Exception {

			Iterator i = listaMetas.iterator();
			DTOMetasVentaProyectada dtoMVP = null;
			RecordSet rs = new RecordSet();
			Vector v = null;
    
			rs.addColumn("OID");
			rs.addColumn("DESC");
    
			for (int j = 0; i.hasNext(); j++){      
				dtoMVP = (DTOMetasVentaProyectada)i.next();
                v = new Vector();

				v.add(dtoMVP.getOidPeriodo());
				v.add(dtoMVP.getNombrePeriodo());

                //Verificacion para no ingresar datos repetidos
                if(rs.getRowCount()>0) {
					int contador = 0;
                    for(int k=0; k<rs.getRowCount(); k++) {	
	                    Long oidPeriodo = (Long)rs.getValueAt(k,0);
                        Long oidPeriodoNuevo = (Long)v.get(0);
 
						if(oidPeriodo.longValue() == oidPeriodoNuevo.longValue()) contador++;
                    }

                    if(contador==0) rs.addRow(v);
                 }
                 else {
					rs.addRow(v);
                 }		
                 //Verificacion para no ingresar datos repetidos
            }
            traza("*************** rs " + rs);
            RecordSet rsFinal = ordenaDescripcionesCombo(rs);
            traza("*************** rsFinal " + rsFinal);
            return transformarRecordSetToString(rsFinal);
         }

		 private String transformarRecordSetToString(RecordSet rs) throws Exception  {
			  String cadena = "";
			  for(int i=0; i<rs.getRowCount() ;i++){
 					String oidTemp = rs.getValueAt(i,"OID").toString();
				    String desTemp = rs.getValueAt(i,"DESC").toString();
					if(i==0) {
						cadena = cadena + oidTemp + "," + desTemp;
					}
					else {
						cadena = cadena + "|" +oidTemp + "," + desTemp;
					}					
			  }
			  traza("*************** cadena " + cadena);
			  return cadena;
		 }


         //CARGA COMBO PERIODO
	     private DruidaConector generarConectorComboPeriodo(ArrayList listaMetas) 
		    throws Exception {
            traza("******** Entro a generarConectorComboPeriodo");
			Iterator i = listaMetas.iterator();
			DTOMetasVentaProyectada dtoMVP = null;
			RecordSet rs = new RecordSet();
			Vector v = null;
    
			rs.addColumn("OID");
			rs.addColumn("DESC");
    
			for (int j = 0; i.hasNext(); j++){      
				dtoMVP = (DTOMetasVentaProyectada)i.next();
                v = new Vector();

				v.add(dtoMVP.getOidPeriodo());
				v.add(dtoMVP.getNombrePeriodo());

                //Verificacion para no ingresar datos repetidos
                if(rs.getRowCount()>0) {
					int contador = 0;
                    for(int k=0; k<rs.getRowCount(); k++) {	
	                    Long oidPeriodo = (Long)rs.getValueAt(k,0);
                        Long oidPeriodoNuevo = (Long)v.get(0);
 
						if(oidPeriodo.longValue() == oidPeriodoNuevo.longValue()) contador++;
                    }

                    if(contador==0) rs.addRow(v);
                 }
                 else {
					rs.addRow(v);
                 }		
                 //Verificacion para no ingresar datos repetidos
            }
            traza("*************** rs " + rs);
            RecordSet rsFinal = ordenaDescripcionesCombo(rs);
            traza("*************** rsFinal " + rsFinal);
            return UtilidadesBelcorp.generarConector("dtoSalida", rsFinal, rsFinal.getColumnIdentifiers());
    }

         //No se puede ordenar las descripciones de los combos Cliente y Periodo
         //desde la parte servidora, se hace "a mano" en este metodo
         private RecordSet ordenaDescripcionesCombo(RecordSet rs) throws Exception {
                  traza("******** Entro a ordenaDescripcionesCombo");
                  int cantFilas = rs.getRowCount();
                  traza("******** cantFilas " + cantFilas);

                  for(int i=cantFilas; --i>=0; ) {
                           for(int k=0; k < i; k++) {
                                    String desFilaActual = (String)rs.getValueAt(k,1);
                                    String desFilaSiguiente = (String)rs.getValueAt(k+1,1);

                                    traza("******** desFilaActual " + desFilaActual);
                                    traza("******** desFilaSiguiente " + desFilaSiguiente);
                                    
                                    //Si el actual es mayor al siguiente, los intercambia
                                    if(desFilaActual.compareToIgnoreCase(desFilaSiguiente) > 0) {
                                             traza("******** INTERCAMBIA");
                                             //Registro actual a temporal
                                             Long oidClienteTemp = (Long)rs.getValueAt(k,0);
                                             String codigoTemp = (String)rs.getValueAt(k,1);

                                             //Registro siguiente al actual
                                             Long oidCliente = (Long)rs.getValueAt(k+1,0);
                                             String Codigo = (String)rs.getValueAt(k+1,1);
                                             rs.setValueAt(oidCliente,k, 0); 
                                             rs.setValueAt(Codigo,k, 1); 

                                             //Registro temporal a siguiente
                                             rs.setValueAt(oidClienteTemp,k+1, 0); 
                                             rs.setValueAt(codigoTemp,k+1, 1); 
                                    }
                           }
                  }
                  return rs;
         }
     
    public void cargarPantallaMetasTipoVenta() throws Exception {     
        traza("LPMantenerParametrosCalificacion.cargarPantallaMetasTipoVenta() - Entrada");
	    this.concurso = this.getConcurso();      
        this.pagina("contenido_metas_tipo_venta_mantener"); 

        if (this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){
			this.asignarAtributoPagina("cod", "01032");
        }
		else {
			this.asignarAtributoPagina("cod", "0548");
            getConfiguracionMenu("LPMantenerParametrosCalificacion","cargar metas tipo venta");
        }
            
        this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
        this.asignarAtributo("VAR", "accion", "valor", this.accion);
        
        /*
         * Agregado por Rafael Romero (31-01-2007)
         * para traer la longitud del codigo de cliente por defecto segun el pais
         */
        Byte longCodClie = this.obtenerLongitudCodigoCliente();
        if(longCodClie==null){
        	this.asignarAtributo("VAR", "longCodClienteDefault", "valor", "0");
        }else{
        	this.asignarAtributo("VAR", "longCodClienteDefault", "valor", longCodClie.toString());
        }

        MareBusinessID id = new MareBusinessID("INCObtenerMetasTipoVenta");
        Vector paramEntrada = new Vector();

        DTOOID dtoO = new DTOOID();  
        DTOListaMetasTipoVenta dtoListaMetasTipoVenta = new DTOListaMetasTipoVenta();
         
				/* 
         * Comentado por Rafael Romero 25-01-2007 
         * La lista de metas tipo venta ya no se completa en el DTO de Parametros de calificacion 
         * Se coloca un solo elemento en la lista, como indicador de que hay Metas Tipo Venta 
         * 
        if (concurso.getParamCalificacion() == null 
			|| concurso.getParamCalificacion().getListaMetasTipoVenta() == null 
            || concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas() == null 
            || concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas().isEmpty()){

            traza("************** 1");
            if (concurso.getParamGenerales().getOid() == null){
				traza("************** 1 BIS");
                if(getConcurso().getParamGenerales().getOidFicticio()!=null) {
					traza("************** 2");
                    dtoListaMetasTipoVenta = null;
                                      
                    dtoO.setOid(getConcurso().getParamGenerales().getOidFicticio());              
                              
                    paramEntrada.add(dtoO);
                    paramEntrada.add(id);

                    traza("*********** Antes de conectar");
                    DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);
                    traza("*********** Despues de conectar");
                    
					dtoListaMetasTipoVenta = (DTOListaMetasTipoVenta)conectorObjeto.objeto("DTOSalida");
                    traza("******** DTOListaMetasTipoVenta " + dtoListaMetasTipoVenta);         
	            }
            }
            else {                    
                  traza("************** 3");
                  dtoO.setOid(getConcurso().getParamGenerales().getOid());                    
                    
                  paramEntrada.add(dtoO);
                  paramEntrada.add(id);
      
                  traza("************ Antes de conectar");
                  DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);
                  traza("************ Despues de conectar");
                    
                  dtoListaMetasTipoVenta = (DTOListaMetasTipoVenta)conectorObjeto.objeto("DTOSalida");
                  traza("*********** DTOListaMetasTipoVenta " + dtoListaMetasTipoVenta);         
            }
         
            traza("********** concurso.getParamCalificacion() " + concurso.getParamCalificacion());
            if(concurso.getParamCalificacion()==null) {
				DTOParametrosCalificacion dtoPar = new DTOParametrosCalificacion();
                concurso.setParamCalificacion(dtoPar);
            }
            
			concurso.getParamCalificacion().setListaMetasTipoVenta(dtoListaMetasTipoVenta); 
         }

					*/
					
					/* 
					 * Se ha colocado un solo elemento en la lista de Metas,  
					 * como indicador de que hay metas. La consulta se hace por el paginado 
					 */ 
         if (concurso.getParamCalificacion() != null 
                  && concurso.getParamCalificacion().getListaMetasTipoVenta() != null 
                  && concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas() != null 
                  && !concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas().isEmpty()){

			// Agregado por busqueda generica
			if (concurso.getParamGenerales().getOid() == null){
				this.asignarAtributo("VAR", "oidConcurso", "valor", getConcurso().getParamGenerales().getOidFicticio().toString() );
			}else{
				this.asignarAtributo("VAR", "oidConcurso", "valor", getConcurso().getParamGenerales().getOid().toString() );
			}

			 traza("************** 4");
             /* Reemplazado por busqueda generica
			 traza("************** Llamando a generarConectorComboCliente");
             this.asignar("COMBO", "cbCliente", generarConectorComboCliente(
             concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas(), 
             LPMantenerParametrosCalificacion.FLAG_TIPO_VENTA));
			 */
             if (this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){
                  asignarAtributo("VAR","consultar","valor","SI");
             }
        
             asignarAtributo("VAR","btnGuardar","valor","SI");
             
             /*
              * No es necesario traer la lista de Metas Tipo Venta
              *
              
			 dtoListaMetasTipoVentaSesion = (DTOListaMetasTipoVenta)conectorParametroSesion("dtoListaMetasTipoVentaSesion");
             traza("************** dtoListaMetasTipoVentaSesion " + dtoListaMetasTipoVentaSesion);

			 if(dtoListaMetasTipoVentaSesion==null) {
				 traza("************** esta en null, seteo lo que hay en el DTOConcurso");
				 this.asignarAtributo("VAR", "lstMetasTipoVenta", "valor", 
	             generarStrListaMetasTipoVenta(
		         concurso.getParamCalificacion().getListaMetasTipoVenta().getListaMetas()));
			 }
			 else {
 				 traza("************** no esta en null, seteo el dto de sesion");
 				 this.asignarAtributo("VAR", "lstMetasTipoVenta", "valor", 
	             generarStrListaMetasTipoVenta(dtoListaMetasTipoVentaSesion.getListaMetas()));
			 }    
			 			 */
         }
         else {
			traza("************** 5");
            //22399
            if (this.opcionMenu.equalsIgnoreCase("Consultar Concurso")){
				throw new MareException(new Exception(), 130346);			
            }
			else {
				//Debe calcular las metas para poder modificarlas 
                throw new MareException(new Exception(), 130019);
            }
         }
		 traza("LPMantenerParametrosCalificacion.cargarPantallaMetasTipoVenta() - Salida");
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        13/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private String generarStrListaMetasTipoVenta(ArrayList listaMetas){
         StringBuffer sb = new StringBuffer();
         StringBuffer sbLinea = null;
         DTOMetasTipoVenta dto = null;
         Iterator i = listaMetas.iterator();
    
         while (i.hasNext()){
             dto = (DTOMetasTipoVenta)i.next();
             sbLinea = new StringBuffer();
      
             sbLinea.append(dto.getOid()!=null?dto.getOid() + ",":","); //0Long
             sbLinea.append(dto.getImpMontoVenta()!=null?dto.getImpMontoVenta() + ",":","); //1Long
             sbLinea.append(dto.getNumUnidadesVendidas()!=null?dto.getNumUnidadesVendidas() + ",":","); //2Long
             sbLinea.append(dto.getValorIncremento()!=null?dto.getValorIncremento() + ",":","); //3Long
             sbLinea.append(dto.getValorMetas()!=null?dto.getValorMetas() + ",":","); //4Long
             sbLinea.append(dto.getOidCliente()!=null?dto.getOidCliente() + ",":","); //5Long
             sbLinea.append(dto.getCodigoCliente()!=null?dto.getCodigoCliente() + ",":","); //6Long
             sbLinea.append(dto.getOidConcurso()!=null?dto.getOidConcurso() + "|":"|"); //7Long
             sb.append(sbLinea.toString());
         }
      
         return sb.toString();
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       24/2/2006
	 * Modificado:  Cristian Valenzuela
	 * Incidencia:  22393 (La ultima version del diseño figura en esta incidencia)
     */
    public void almacenarMetasVentaProyectada() throws Exception {  
         traza("LPMantenerParametrosCalificacion.almacenarMetasVentaProyectada() - Entrada");  
         this.concurso = this.getConcurso();
		 traza("++++++1");  
		 //Agregado por Cristian Valenzuela
 		 traza("++++++2");  
		 dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia");
 		 traza("++++++3");  
		 dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarRegion");
 		 traza("++++++4");  
		 dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarZona");
 		 traza("++++++5");  
 		 //FIN-Agregado por Cristian Valenzuela
		 traza("++++++6");  
         // Rellena el dtoConcurso.paramClasificacion.listaMetasVentaProyectada     
         if (this.concurso.getParamCalificacion() == null){
             this.concurso.setParamCalificacion(new DTOParametrosCalificacion());
         }
   		 traza("++++++7");  
         if (this.concurso.getParamCalificacion().getListaMetasVentaProyectada() == null){
             this.concurso.getParamCalificacion().setListaMetasVentaProyectada(new DTOListaMetasVentaProyectada());
         }
   		 traza("++++++8");  

		 traza("++++++9");  
		 //Agregado por Cristian Valenzuela - 27/2/2006
		 //Incidencia 22393
		 if(dtoListaMetasAuxiliarSubgerencia!=null) {	 		 						
			 traza("**SUBGERENCIA**");
			 this.concurso.getParamCalificacion().getListaMetasVentaProyectada().setListaMetas(dtoListaMetasAuxiliarSubgerencia.getListaMetas());
		 }

		 if(dtoListaMetasAuxiliarRegion!=null) {
 			 traza("**REGION**");
			 this.concurso.getParamCalificacion().getListaMetasVentaProyectadaRegion().setListaMetas(dtoListaMetasAuxiliarRegion.getListaMetas());		 
		 }

		 if(dtoListaMetasAuxiliarZona!=null) {
 			 traza("**ZONA**");
			 this.concurso.getParamCalificacion().getListaMetasVentaProyectadaZona().setListaMetas(dtoListaMetasAuxiliarZona.getListaMetas());
		 }

		 this.setConcurso(this.concurso);
 		 //FIN-Agregado por Cristian Valenzuela - 27/2/2006
         traza("LPMantenerParametrosCalificacion.almacenarMetasVentaProyectada() - Salida");
  }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        13/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void almacenarMetasTipoVenta() throws Exception {
         this.concurso = this.getConcurso();

         //Rellena el dtoConcurso.paramClasificacion.listaMetasTipoVenta
         if (this.concurso.getParamCalificacion() == null){
             this.concurso.setParamCalificacion(new DTOParametrosCalificacion());
         }

         if (this.concurso.getParamCalificacion().getListaMetasTipoVenta() == null){
             this.concurso.getParamCalificacion().setListaMetasTipoVenta(new DTOListaMetasTipoVenta());
         }

		 dtoListaMetasTipoVentaSesion = (DTOListaMetasTipoVenta)conectorParametroSesion("dtoListaMetasTipoVentaSesion");
		 if(dtoListaMetasTipoVentaSesion!=null) {
	         this.concurso.getParamCalificacion().setListaMetasTipoVenta(dtoListaMetasTipoVentaSesion);
		 }

		 
         //this.concurso.getParamCalificacion().getListaMetasTipoVenta().setListaMetas(this.listaMetasTipoVenta);
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        18/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void calcularMetasVentaProyectada() throws Exception {
         traza("********** Entro a calcularMetasVentaProyectada");
         //Se calculan las metas venta proyectada 
         pagina("salidaGenerica");

		 //Agregado por cvalenzu - incidencia DBLG500000613
		 //Se limpian los dtos de sesion, para que luego, al presionar
		 //mantener metas que los utiliza, se actualizen los datos
		 //de pantalla correctamente.
	 	 conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia", null);
		 conectorParametroSesion("dtoListaMetasAuxiliarRegion", null);
		 conectorParametroSesion("dtoListaMetasAuxiliarZona", null);
 		 //FIN - Agregado por cvalenzu - incidencia DBLG500000613

         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
         this.concurso = this.getConcurso();
         traza("********** concurso " + concurso);

         //En la parte servidora se necesitan los siguientes valores
         //oid Periodo desde
         String oidPerDesde = this.conectorParametroLimpia("oidPerDesde", "", true);
         traza("********** oidPerDesde " + oidPerDesde);

         //oid Periodo hasta
         String oidPerHasta = this.conectorParametroLimpia("oidPerHasta", "", true);
         traza("********** oidPerHasta " + oidPerHasta);

         //oid agrupacion
         Long oidAgrup = (Long)conectorParametroSesion("OidAgrupacion");
         traza("********** oidAgrup " + oidAgrup);

         //Primero pregunto si el DTOParametrosCalificacion del DTOConcurso
         //es distinto de null
         if (concurso.getParamCalificacion()!=null) {
             //Si no tiene el oid de periodo desde en el DTOParametrosCalificacion
             //del DTOConcurso, se setea
             //if (concurso.getParamCalificacion().getOidPeriodoDesde()==null) {
                           concurso.getParamCalificacion().setOidPeriodoDesde(new Long(oidPerDesde));
             //}

             //Si no tiene el oid de periodo hasta en el DTOParametrosCalificacion
             //del DTOConcurso, se setea
             //if (concurso.getParamCalificacion().getOidPeriodoHasta()==null) {
                           concurso.getParamCalificacion().setOidPeriodoHasta(new Long(oidPerHasta));
             //}
                  
             //Si no tiene el oid de agrupacion en el DTOParametrosCalificacion,
             //del DTOConcurso, se setea
             //if (concurso.getParamCalificacion().getOidAgrupacion()==null) {
                           concurso.getParamCalificacion().setOidAgrupacion(oidAgrup);
             //}
         } else {
             //Si esta en null, lo creo y le seteo los valores que necesito
             //Luego lo seteo al DTOConcurso
             DTOParametrosCalificacion dtoParametros = new DTOParametrosCalificacion();
             dtoParametros.setOidPeriodoDesde(new Long(oidPerDesde));
             dtoParametros.setOidPeriodoHasta(new Long(oidPerHasta));
             dtoParametros.setOidAgrupacion(oidAgrup);

             traza("********** DTOParametrosCalificacion " + dtoParametros);

             concurso.setParamCalificacion(dtoParametros);
         }

         MareBusinessID id = new MareBusinessID("INCCalcularMetasVentaProyectadaBatch");
         Vector params = new Vector();
         params.add(concurso);           
         params.add(id);

         try {
             DruidaConector dc = this.conectar("ConectorCalcularMetasVentaProyectada", params);
             DTOOID dto = (DTOOID)dc.objeto("dtoSalida");

             //Actualizamos el oidConcurso, si no existía 
             if (this.concurso.getParamGenerales().getOid() == null){
                  this.concurso.getParamGenerales().setOidFicticio(dto.getOid());
             }
  
             this.setConcurso(this.concurso);

             asignarAtributo("VAR", "ejecutar", "valor", "calcularMetasVentaProyectadaOK()");           
         } catch (Exception e) {
             asignarAtributo("VAR", "ejecutarError", "valor", "calcularMetasVentaProyectadaERR()");           
             throw e;
         } 
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       18/05/2005
     * @version     
     * @autor       Marcelo J. Maidana
     */
    public void calcularMetasTipoVenta() throws Exception {
         traza("********** Entro a calcularMetasVentaProyectada");
         pagina("salidaGenerica");
         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

         //Deberá comprobarse que se han introducido productos a calificar, porque si no, 
         //no se pueden calcular metas tipo venta (o metas venta histórica)     
         this.concurso = this.getConcurso();
         traza("********** concurso " + concurso);
    
         //En la parte servidora se necesitan los siguientes valores
         //oid Periodo desde
         String oidPerDesde = this.conectorParametroLimpia("oidPerDesde", "", true);
         traza("********** oidPerDesde " + oidPerDesde);
    
         //oid Periodo hasta
         String oidPerHasta = this.conectorParametroLimpia("oidPerHasta", "", true);
         traza("********** oidPerHasta " + oidPerHasta);

         //oid de forma de calculo
         String oidFormaCal = conectorParametroLimpia("oidFormaCal", "", true);
         traza("********** oidFormaCal " + oidFormaCal);

         //oid de tipo incremento
         String oidTipoIncremento = conectorParametroLimpia("tipoIncremento", "", true);
         traza("********** oidTipoIncremento " + oidTipoIncremento);        

         //oid Tipo venta incremental
         String tempOidTipoVentaIncremental = conectorParametroLimpia("tempOidTipoVentaIncremental", "", true);
         traza("********** tempOidTipoVentaIncremental " + tempOidTipoVentaIncremental);

		 //ind comunicacion
         String hComunicaciones = conectorParametroLimpia("hComunicaciones", "", true);
         traza("********** hComunicaciones " + hComunicaciones);
                  
         //lista de incrementos por rango
         lstIncrementosPorRango = obtenerListaIncrementosPorRango(sLstIncrementosPorRango);

         if (this.concurso.getProductosACalificar() != null 
                  && this.concurso.getProductosACalificar().getLstProductos() != null 
                  && !this.concurso.getProductosACalificar().getLstProductos().isEmpty()){         

             //Primero pregunto si el DTOParametrosCalificacion del DTOConcurso
             //es distinto de null
             if (concurso.getParamCalificacion()!=null) {
				concurso.getParamCalificacion().setOidPeriodoDesde(new Long(oidPerDesde));
                concurso.getParamCalificacion().setOidPeriodoHasta(new Long(oidPerHasta));
                concurso.getParamCalificacion().setOidFormaCalculo(new Long(oidFormaCal));
                concurso.getParamCalificacion().setOidTipoIncremento(new Long(oidTipoIncremento));
                concurso.getParamCalificacion().setLstIncrementosPorRango(lstIncrementosPorRango);                    
				concurso.getParamCalificacion().setOidTipoVentaIncremental(new Long(tempOidTipoVentaIncremental));
				if(hComunicaciones.equalsIgnoreCase("S")) {
					concurso.getParamCalificacion().setIndComunicacion(new Boolean(true));
				}
				else {
					concurso.getParamCalificacion().setIndComunicacion(new Boolean(false));
				}
             }
             else {
                  //Si esta en null, lo creo y le seteo los valores que necesito
                  //Luego lo seteo al DTOConcurso
                  DTOParametrosCalificacion dtoParametros = new DTOParametrosCalificacion();
                  dtoParametros.setOidPeriodoDesde(new Long(oidPerDesde));
                  dtoParametros.setOidPeriodoHasta(new Long(oidPerHasta));              
                  dtoParametros.setOidFormaCalculo(new Long(oidFormaCal));
                  dtoParametros.setOidTipoIncremento(new Long(oidTipoIncremento));
                  dtoParametros.setLstIncrementosPorRango(lstIncrementosPorRango);
                  dtoParametros.setOidTipoVentaIncremental(new Long(tempOidTipoVentaIncremental));  
				  if(hComunicaciones.equalsIgnoreCase("S")) {
					dtoParametros.setIndComunicacion(new Boolean(true));
				  }
				  else {
					dtoParametros.setIndComunicacion(new Boolean(false));
				  }
				  
                  concurso.setParamCalificacion(dtoParametros);
             }

             traza("********** DTOParametrosCalificacion " + concurso.getParamCalificacion());

             try {
                  //Se calculan las metas venta tipo venta 
                  this.setConcurso(this.concurso);    
                  MareBusinessID id = new MareBusinessID("INCCalcularMetasTipoVentaBatch");
                  Vector params = new Vector();
                  params.add(this.getConcurso());      
                  params.add(id);
                  traza("********** antes de calcular metas");
                  DruidaConector dc = this.conectar("ConectorCalcularMetasTipoVenta", params);         
                  traza("********** despues de calcular metas");
                  DTOOID dto = (DTOOID)dc.objeto("dtoSalida");
                    
                  //Actualizamos el oidConcurso, si no existía 
                  if (this.concurso.getParamGenerales() == null 
                  || this.concurso.getParamGenerales().getOid() == null){

                      if (this.concurso.getParamGenerales() == null){
                           this.concurso.setParamGenerales(new DTOParametrosGeneralesConcurso());
                      }

                      this.concurso.getParamGenerales().setOidFicticio(dto.getOid());
                  }
                    
                  this.setConcurso(this.concurso);      
                  asignarAtributo("VAR", "ejecutar", "valor", "calcularMetasTipoVentaOK()");           
             }
			 catch (Exception e) {
                  asignarAtributo("VAR", "ejecutarError", "valor", "calcularMetasTipoVentaERR()");           
                  throw e;
             }            
         }
		 else {
			throw new MareException(new Exception(), 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + "0018"));      
         }
    }
  
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    public void cargarPantallaModificarMetasVentaProyectada() throws Exception {
                  traza("************ Entro a cargarPantallaModificarMetasVentaProyectada");
         this.concurso = this.getConcurso();
    
         this.pagina("contenido_metas_ventas_proyectadas_mantener_detalle");

         // se carga el elemento seleccionado en la lista de la pantalla llamante en la pantalla 
         //Deshabilitar todos los campos de esta página 
         //TODO: ver como deshabilitar los campos de la lista editable
    
         if (this.concurso.getVariablesVentaProyectada() != null){
             DTOVariablesVentaProyectada dto = this.concurso.getVariablesVentaProyectada();

                                    traza("*************** DTOVariablesVentaProyectada: " + dto);
      
             if (dto.getIndActivas() != null && dto.getIndActivas().booleanValue()){
                  this.asignarAtributo("VAR", "hEstadoTxtActivas", "valor", "S");
             }

             if (dto.getIndIngreso() != null && dto.getIndIngreso().booleanValue()){
                  this.asignarAtributo("VAR", "hEstadoTxtIngreso", "valor", "S");
             }

             if (dto.getIndReingreso() != null && dto.getIndReingreso().booleanValue()){
                  //habilitar txtReingreso 
                  this.asignarAtributo("VAR", "hEstadoTxtReingreso", "valor", "S");
             }

             if (dto.getIndEgresos() != null && dto.getIndEgresos().booleanValue()){
                  //habilitar txtEgresos 
                  this.asignarAtributo("VAR", "hEstadoTxtEgresos", "valor", "S");
             }

             if (dto.getIndEntregadas() != null && dto.getIndEntregadas().booleanValue()){
                  //habilitar txtEntregadas 
                  this.asignarAtributo("VAR", "hEstadoTxtEntregadas", "valor", "S");
             }

             if (dto.getIndRecibidas() != null && dto.getIndRecibidas().booleanValue()){
                  //habilitar txtRecibidas 
                  this.asignarAtributo("VAR", "hEstadoTxtRecibidas", "valor", "S");
             }
      
             if (dto.getIndCapitalizacion() != null && dto.getIndCapitalizacion().booleanValue()){
                  //habilitar txtCapitalizacion 
                  this.asignarAtributo("VAR", "hEstadoTxtCapitalizacion", "valor", "S");
             }

             if (dto.getIndActivasFinales() != null && dto.getIndActivasFinales().booleanValue()){
                  //habilitar txtActivasFinales 
                  this.asignarAtributo("VAR", "hEstadoTxtActivasFinales", "valor", "S");
             }

             if (dto.getIndActividad() != null && dto.getIndActividad().booleanValue()){
                  //habilitar txtActividad 
                  this.asignarAtributo("VAR", "hEstadoTxtActividad", "valor", "S");
             }

             if (dto.getIndNumeroPedidos() != null && dto.getIndNumeroPedidos().booleanValue()){
                  //habilitar txtNumeroPedidos 
                  this.asignarAtributo("VAR", "hEstadoTxtNumPedidos", "valor", "S");
             }

             if (dto.getIndPrecioPromedioUnitario() != null 
                      && dto.getIndPrecioPromedioUnitario().booleanValue()){
                  //habilitar txtPrecioPormedioUnitario 
                  this.asignarAtributo("VAR", "hEstadoTxtPrecioPromedioUnitario", "valor", "S");
             }

             if (dto.getIndPromedioVentaPedido() != null 
                      && dto.getIndPromedioVentaPedido().booleanValue()){
                  //habilitar txtPromedioVentaPedido 
                  this.asignarAtributo("VAR", "hEstadoTxtPromedioVentaPedido", "valor", "S");
             }

             if (dto.getIndPromedioUnidadesPedido() != null 
                      && dto.getIndPromedioUnidadesPedido().booleanValue()){
                  //habilitar txtPromedioUnidadesPedido 
                  this.asignarAtributo("VAR", "hEstadoTxtPromedioUnidadesPedido", "valor", "S");
             }

             if (dto.getIndPromedioOrdenesPedido() != null 
                      && dto.getIndPromedioOrdenesPedido().booleanValue()){
                  //habilitar txtPromedioOrdenesPedido 
                  this.asignarAtributo("VAR", "hEstadoTxtPromedioOrdenesPedido", "valor", "S");
             }

             if (dto.getIndRetencion() != null && dto.getIndRetencion().booleanValue()){
                  //habilitar txtRetencion 
                  this.asignarAtributo("VAR", "hEstadoTxtRetencion", "valor", "S");
             }

             if (dto.getIndVentaEstadisticable() != null 
                      && dto.getIndVentaEstadisticable().booleanValue()){
                  //habilitar txtVentaEstadisticable 
                  this.asignarAtributo("VAR", "hEstadoTxtVentaEstadisticable", "valor", "S");
             }
         }

         this.asignarAtributo("VAR", "oid", "valor", sOid);
         this.asignarAtributo("VAR", "cliente", "valor", sCliente);
         this.asignarAtributo("CTEXTO", "txtActivas", "valor", sActivas);
         this.asignarAtributo("CTEXTO", "txtIngreso", "valor", sIngresos);
         this.asignarAtributo("CTEXTO", "txtReingreso", "valor", sReingresos);
         this.asignarAtributo("CTEXTO", "txtEgresos", "valor", sEgresos);
         this.asignarAtributo("CTEXTO", "txtEntregadas", "valor", sEntregadas);
         this.asignarAtributo("CTEXTO", "txtRecibidas", "valor", sRecibidas);
         this.asignarAtributo("CTEXTO", "txtCapitalizacion", "valor", sCapitalizacion);
         this.asignarAtributo("CTEXTO", "txtActivasFinales", "valor", sActFinales);
         this.asignarAtributo("CTEXTO", "txtActividad", "valor", sActividad);
         this.asignarAtributo("CTEXTO", "txtNumPedidos", "valor", sPedidos);
         this.asignarAtributo("CTEXTO", "txtPrecioPromedioUnitario", "valor", sPrecioPromUnitario);
         this.asignarAtributo("CTEXTO", "txtPromedioVentaPedido", "valor", sPromedioVtaPedido);
         this.asignarAtributo("CTEXTO", "txtPromedioUnidadesPedido", "valor", sPromUnidadesPedido);
         this.asignarAtributo("CTEXTO", "txtPromedioOrdenesPedido", "valor", sPromOrdenesPedido);
         this.asignarAtributo("CTEXTO", "txtRetencion", "valor", sRetencion);
         this.asignarAtributo("CTEXTO", "txtVentaEstadisticable", "valor", sVentasEstadisticab);
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        24/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private RecordSet generarRecordSetLista(ArrayList lista) throws Exception{
                  traza("********** generarRecordSetLista");
         RecordSet rs = new RecordSet();
         DTOIncrementoPorRango dto = null;
         Iterator i = null;
         Vector linea = null;
    
         if (lista == null || lista.isEmpty()){
             return null;
         }
    
         String[] columns = {"OID", "DESDE", "HASTA", "INCREMENTO"};
         rs.setColumnIdentifiers(columns);
         i = lista.iterator();
    
         while (i.hasNext()){
             dto = (DTOIncrementoPorRango)i.next();
                           traza("********** DTOIncrementoPorRango " + dto);

                           String tempOidRango = UtilidadesBelcorp.formateaNumeroSICC(dto.getOidRango().toString(), 
                           this.FORMATO_DEFAULT, this);
                           
                           String tempDesde = UtilidadesBelcorp.formateaNumeroSICC(dto.getDesde().toString(), 
                           this.FORMATO_DEFAULT, this);
                           
                           String tempHasta = UtilidadesBelcorp.formateaNumeroSICC(dto.getHasta().toString(), 
                           this.FORMATO_DEFAULT, this);
                           
                           String tempIncremento = UtilidadesBelcorp.formateaNumeroSICC(dto.getIncremento().toString(), 
                           this.FORMATO_DEFAULT, this);
    
             if (dto != null){
                  linea = new Vector();
                  linea.add(tempOidRango);
                  linea.add(tempDesde);
                  linea.add(tempHasta);
                  linea.add(tempIncremento);
                  rs.addRow(linea);
             }
         }
      
                  traza("********** rs " + rs);
         return rs;
    }
     
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        24/05/2005
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private DruidaConector generarConectorLista(RecordSet rs)throws Exception{




    
         if (rs != null && !rs.esVacio()){
             return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());
         }
    
         return null;
    }
  
    //============================================================================
    //Los siguientes son metodos para obtener listaCalificacion.
    //que es devuelta por la modal Participantes.
    
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList obtenerListaCalificacion(String lista) throws Exception{
                  traza("Lista a parsear en obtenerListaCalificacion: "+lista);

         if (lista == null || lista.length() == 0){
             return null;
         }

         /*
         - listasCalificacion[0] = listaCalificacionParticipantes 
         - listasCalificacion[1] = listaParticipantes 
         - listasCalificacion[2] = lstEstatusVenta 
         */

         StringTokenizer strToken = new StringTokenizer(lista, LPMantenerParametrosCalificacion.CHAR_SEPARADOR_LISTAS);
         
         String sListaCalificacionParticipantes = strToken.nextToken();
         String sListaParticipantes = strToken.nextToken();
         String sListaEstatusVenta = strToken.hasMoreTokens()?strToken.nextToken():"";
    
         ArrayList listaCalificacionParticipantes = 
         this.obtenerListaCalificacionParticipantes(sListaCalificacionParticipantes);

		 ArrayList listaParticipantes = 
		 this.obtenerListaParticipantes(sListaParticipantes);
         
		 ArrayList listaEstatusVenta = 
			this.obtenerlistaEstatusVenta(sListaEstatusVenta);
         
         ArrayList listaCalificacion = new ArrayList();
         listaCalificacion.add(listaCalificacionParticipantes);
         listaCalificacion.add(listaParticipantes);
         listaCalificacion.add(listaEstatusVenta);
    
         return listaCalificacion;
    }
  
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList obtenerListaCalificacionParticipantes(String lista) throws Exception {    
         traza("************ Entro a obtenerListaCalificacionParticipantes");
         
         if (lista == null){
             return null;
         }
    
         DTOCalificacionParticipante dto = null;
         ArrayList al = new ArrayList();
         StringTokenizer strToken = new StringTokenizer(lista, LPMantenerParametrosCalificacion.CHAR_SEPARADOR_LINEAS);
         StringTokenizer strTokenLinea = null;
         String linea = null;         
         String sOid = null;
         String sOidParticipante = null;
         String sOidEstatusVenta = null;
         String desParticipante = "";
         String desEstatusVenta = "";
         String sMontoMinimo = null;         
         Long oid = null;
         Long oidParticipante = null;
         Long oidEstatusVenta = null;
         BigDecimal montoMinimo = null;
    
         while (strToken.hasMoreTokens()) {
             linea = strToken.nextToken();
             traza("**** Linea a procesar: " + linea);
             strTokenLinea = new StringTokenizer(linea, LPMantenerParametrosCalificacion.CHAR_SEPARADOR_CAMPOS);

             sOid = null;
             sOidParticipante = null;
             sOidEstatusVenta = null;
             desParticipante = "";
             desEstatusVenta = "";
             sMontoMinimo = null;    
             oid = null;
             oidParticipante = null;
             oidEstatusVenta = null;
             montoMinimo = null;      

             if (strTokenLinea.hasMoreTokens()){
                  sOid = strTokenLinea.nextToken();
                  traza("*** sOid: " + sOid);
                                    if(sOid.equals(" ")) {
                                             sOid = null;
                                    }
             }

             if (strTokenLinea.hasMoreTokens()){
                  sOidParticipante = strTokenLinea.nextToken();
                  traza("*** sOidParticipante: " + sOidParticipante);
                                    if(sOidParticipante.equals(" ")) {
                                             sOidParticipante = null;
                                    }
             }

             if (strTokenLinea.hasMoreTokens()){
                  sOidEstatusVenta = strTokenLinea.nextToken();
                  traza("*** sOidEstatusVenta: " + sOidEstatusVenta);
                                    if(sOidEstatusVenta.equals(" ")) {
                                             sOidEstatusVenta = null;
                                    }
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  desParticipante = strTokenLinea.nextToken();
                  traza("*** desParticipante: " + desParticipante);
                                    if(desParticipante.equals(" ")) {
                                             desParticipante = null;
                                    }
             }

             if (strTokenLinea.hasMoreTokens()){
                  desEstatusVenta = strTokenLinea.nextToken();
                  traza("*** desEstatusVenta: " + desEstatusVenta);
                                    if(desEstatusVenta.equals(" ")) {
                                             desEstatusVenta = null;
                                    }
             }

             if (strTokenLinea.hasMoreTokens()){
                  sMontoMinimo = strTokenLinea.nextToken();
                  traza("*** sMontoMinimo: " + sMontoMinimo);
                                    if(sMontoMinimo.equals(" ")) {
                                             sMontoMinimo = null;
                                    }
             }

             try {
                  oid = sOid != null ? new Long(sOid) : null;
             } catch (NumberFormatException nfe){}
      
             try {
                  oidParticipante = sOidParticipante != null ? new Long(sOidParticipante) : null;
             } catch (NumberFormatException nfe){}

             try {
                  oidEstatusVenta = sOidEstatusVenta != null ? new Long(sOidEstatusVenta) : null;
             } catch (NumberFormatException nfe){}

             try {
                  montoMinimo = sMontoMinimo != null ? new BigDecimal(sMontoMinimo) : null;
             } catch (NumberFormatException nfe){}

             dto = new DTOCalificacionParticipante();
             dto.setOid(null);
             dto.setOidParticipante(oidParticipante);
             dto.setOidEstatusVenta(oidEstatusVenta);
             dto.setDesParticipante(desParticipante);
             dto.setDesEstatusVenta(desEstatusVenta);
             dto.setMontoMinimo(montoMinimo);
             al.add(dto);

             sOid = null;
             sOidParticipante = null;
             sOidEstatusVenta = null;
             desParticipante = "";
             desEstatusVenta = "";
             sMontoMinimo = null;
             oid = null;
             oidParticipante = null;
             oidEstatusVenta = null;
             montoMinimo = null;
         }
  
         return al;
    }
  
    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList obtenerListaParticipantes(String lista) throws Exception{
                  traza("*********** Entro a obtenerListaParticipantes");
    
         if (lista == null){
             return null;
         }
    
         DTOParticipante dto = null;
         ArrayList al = new ArrayList();    
         StringTokenizer strToken = new StringTokenizer(lista,
                  LPMantenerParametrosCalificacion.CHAR_SEPARADOR_LINEAS);
         StringTokenizer strTokenLinea = null;
         String linea = null;
         String sOid = null;
         String desc = "";
         Long oid = null;

         while (strToken.hasMoreTokens()){
             linea = strToken.nextToken();
                           traza("********** linea " + linea);
             strTokenLinea = new StringTokenizer(linea, 
             LPMantenerParametrosCalificacion.CHAR_SEPARADOR_CAMPOS);

             if (strTokenLinea.hasMoreTokens()){
                  sOid = strTokenLinea.nextToken();
             }

             if (strTokenLinea.hasMoreTokens()){
                  desc = strTokenLinea.nextToken();
             }
      
             try {
                  oid = sOid != null ? new Long(sOid) : null;
             } catch (NumberFormatException nfe){}

             dto = new DTOParticipante();
             dto.setOid(oid);
             dto.setDescripcion(desc);
             al.add(dto);      
             sOid = null;
             desc = "";
             oid = null;
         }
    
         return al;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList obtenerlistaEstatusVenta(String lista) throws Exception{

         traza("Cadena a parsear en obtenerlistaEstatusVenta: " +lista);
         if (lista == null){
                           
             return null;
         }

         DTOEstatusVenta dto = null;
         ArrayList al = new ArrayList();
  
         /* Cleal
                  StringTokenizer strToken = new StringTokenizer(lista, 
         LPMantenerParametrosCalificacion.CHAR_SEPARADOR_LINEAS);*/
                  StringTokenizer strToken = new StringTokenizer(lista, 
         LPMantenerParametrosCalificacion.CHAR_SEPARADOR_CAMPOS);
         StringTokenizer strTokenLinea = null;
         String linea = null;
    
         String sOidEstatusVenta = null;
         String sOidEstatusVentaMAE = null;
         String sOidPeriodoDesde = null;
         String sOidPeriodoHasta = null;
         String desEstatusVentaMAE = "";
         String desPeriodoDesde = "";
         String desPeriodoHasta = "";
         Long oidEstatusVenta = null;
         Long oidEstatusVentaMAE = null;
         Long oidPeriodoDesde = null;
         Long oidPeriodoHasta = null;
    
         while (strToken.hasMoreTokens()){
                           /* Cleal
             linea = strToken.nextToken();
             strTokenLinea = new StringTokenizer(linea, 
             LPMantenerParametrosCalificacion.CHAR_SEPARADOR_CAMPOS);

             if (strTokenLinea.hasMoreTokens()){
                  sOidEstatusVenta = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  sOidEstatusVentaMAE = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  sOidPeriodoDesde = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  sOidPeriodoHasta = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  desEstatusVentaMAE = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  desPeriodoDesde = strTokenLinea.nextToken();
             }
      
             if (strTokenLinea.hasMoreTokens()){
                  desPeriodoHasta = strTokenLinea.nextToken();
             }*/
                           traza("Elm: "+strToken.nextToken());
                           //strToken.hasMoreTokens();
                           if (strToken.hasMoreTokens()){
                  sOidEstatusVenta = strToken.nextToken();
                                    traza("sOidEstatusVenta: "+sOidEstatusVenta);
             }
      
             if (strToken.hasMoreTokens()){
                  sOidEstatusVentaMAE = strToken.nextToken();
                                    traza("sOidEstatusVentaMAE: "+sOidEstatusVentaMAE);
             }
      
             if (strToken.hasMoreTokens()){
                  sOidPeriodoDesde = strToken.nextToken();
                                    traza("sOidPeriodoDesde: "+sOidPeriodoDesde);
             }
      
             if (strToken.hasMoreTokens()){
                  sOidPeriodoHasta = strToken.nextToken();
                                    traza("sOidPeriodoHasta: "+sOidPeriodoHasta);
             }
      
             if (strToken.hasMoreTokens()){
                  desEstatusVentaMAE = strToken.nextToken();
                                    traza("desEstatusVentaMAE: "+desEstatusVentaMAE);
             }
      
             if (strToken.hasMoreTokens()){
                  desPeriodoDesde = strToken.nextToken();
                                    traza("desPeriodoDesde: "+desPeriodoDesde);
             }
      
             if (strToken.hasMoreTokens()){
                  desPeriodoHasta = strToken.nextToken();
                                    traza("desPeriodoHasta: "+desPeriodoHasta);
             }
    
             try {
                  oidEstatusVenta = sOidEstatusVenta != null ? new Long(sOidEstatusVenta) : null;
             } catch (NumberFormatException nfe){}
      
             try {
                  oidEstatusVentaMAE = sOidEstatusVentaMAE != null ? new Long(sOidEstatusVentaMAE) : null;
             } catch (NumberFormatException nfe){}
      
             try {
                  oidPeriodoDesde = sOidPeriodoDesde != null ? new Long(sOidPeriodoDesde) : null;
             } catch (NumberFormatException nfe){}

             try {
                  oidPeriodoHasta = sOidPeriodoHasta != null ? new Long(sOidPeriodoHasta) : null;
             } catch (NumberFormatException nfe){}
      
             dto = new DTOEstatusVenta();
             dto.setOidEstatus(oidEstatusVenta);
             dto.setOidEstatusVentaMae(oidEstatusVentaMAE);
             dto.setOidPeriodoDesde(oidPeriodoDesde);
             dto.setOidPeriodoHasta(oidPeriodoHasta);
             dto.setDesEstatus(desEstatusVentaMAE);
             dto.setDesPeriodoDesde(desPeriodoDesde);
             dto.setDesPeriodoHasta(desPeriodoHasta);
                           traza("DTO para el array: "+dto);
             al.add(dto);
      
             sOidEstatusVenta = null;
             sOidEstatusVentaMAE = null;
             sOidPeriodoDesde = null;
             sOidPeriodoHasta = null;
             desEstatusVentaMAE = "";
             desPeriodoDesde = "";
             desPeriodoHasta = "";
             oidEstatusVenta = null;
             oidEstatusVentaMAE = null;
             oidPeriodoDesde = null;
             oidPeriodoHasta = null;
         }
                  traza("Resultado del parseo de estatusVenta: "+al);
         return al;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:        
     * @version     
     * @autor        Marcelo J. Maidana
     */
    private ArrayList parsearListaMetasTipoVenta(String sLista) throws Exception {    
         traza("LPMantenerParametrosCalificacion.parsearListaMetasTipoVenta() - Entrada");
         traza("sLista: " + sLista);  
         ArrayList al = new ArrayList();
         DTOMetasTipoVenta dto = null;
         String registro = null;
         StringTokenizer strListas = null;
         StringTokenizer strLinea = null;

		 //campos
         String oid = null;
		 String impMontoVenta = null;
		 String unidadesVendidas = null;
		 String valIncremento = null;
         String metasCalculadas = null;
         String oidCliente = null;
         String codigoCliente = null;
         
         if (sLista != null){         
             strListas = new StringTokenizer(sLista, "|");         
             while (strListas.hasMoreTokens()){
                  registro = strListas.nextToken();
                  strLinea = new StringTokenizer(registro, ",");

                  if (strLinea.hasMoreTokens()){
                      oid = strLinea.nextToken();
                  }

				  if (strLinea.hasMoreTokens()){
                      impMontoVenta = strLinea.nextToken();
                  }

				  if (strLinea.hasMoreTokens()){
                      unidadesVendidas = strLinea.nextToken();
                  }

				  if (strLinea.hasMoreTokens()){
                      valIncremento = strLinea.nextToken();
                  }

				  if (strLinea.hasMoreTokens()){
                      metasCalculadas = strLinea.nextToken();
                  }

                  if (strLinea.hasMoreTokens()){
                      oidCliente = strLinea.nextToken();
                  }

                  if (strLinea.hasMoreTokens()){
                      codigoCliente = strLinea.nextToken();
                  }

                  dto = new DTOMetasTipoVenta();
                  
                  try {
                      dto.setOid(oid != null ? new Long(oid) : null);
                  } catch (NumberFormatException nfe){}

				  try {
                      dto.setImpMontoVenta(impMontoVenta != null ? new BigDecimal(impMontoVenta) : null);
                  } catch (NumberFormatException nfe){}

				  try {
                      dto.setNumUnidadesVendidas(unidadesVendidas != null ? new Integer(unidadesVendidas) : null);
                  } catch (NumberFormatException nfe){}

				  try {
                      dto.setValorIncremento(valIncremento != null ? new BigDecimal(valIncremento) : null);
                  } catch (NumberFormatException nfe){}

				  try {
                      dto.setValorMetas(metasCalculadas != null ? new BigDecimal(metasCalculadas) : null);
                  } catch (NumberFormatException nfe){}

                  try {
                      dto.setOidCliente(oidCliente != null ? new Long(oidCliente) : null);
                  } catch (NumberFormatException nfe){}
                  
                  dto.setCodigoCliente(codigoCliente); 
				  
   	              traza("+++++++++++ dto: " + dto);
                  al.add(dto);
             }
         }

         traza("LPMantenerParametrosCalificacion.parsearListaMetasTipoVenta() - Salida");
         traza("retorno: " + al);
         return al;
    }
    
    /**
     * @author: ssantana, 29/6/2005
     * @throws java.lang.Exception
     */
    private void almacenarModalParticipantes() throws Exception {
         // Se llama para almacenar en el DTOConcurso, los datos corresp. a la modal 
         // Participantes y Estatus Venta, al cerrar la modal con el botón Aceptar.
		 traza("********** Entro a almacenarModalParticipantes");
         pagina("salidaGenerica");
  
         String listaCalificacionParticipantes = 
         this.conectorParametroLimpia("varListaCalificacionParticipantes", "", true);
         traza("********** listaCalificacionParticipantes: " + listaCalificacionParticipantes);

         String listaParticipantes = this.conectorParametroLimpia("varListaParticipantes", "", true);             
         traza("********** listaParticipantes: " + listaParticipantes);
		 
		 this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");        
         concurso = this.getConcurso();
      
         ArrayList aCalificacionParticipantes = 
         this.obtenerListaCalificacionParticipantes(listaCalificacionParticipantes);
         ArrayList aParticipantes = this.obtenerListaParticipantes(listaParticipantes);
      
         DTOCalificacionParticipantes dtoCalifParticipantes = this.concurso.getCalificacionParticipantes();
                                                  
         if (dtoCalifParticipantes == null){
             dtoCalifParticipantes = new DTOCalificacionParticipantes();
         }
      
         dtoCalifParticipantes.setLstCalificacionParticipantes(aCalificacionParticipantes);
         dtoCalifParticipantes.setLstParticipantes(aParticipantes);
      
         this.concurso.setCalificacionParticipantes(dtoCalifParticipantes);      
         this.concurso.setIndClasificacionParticipantesCalificacion(Boolean.TRUE);
         this.concurso.setIndClasificacionParticipantes(Boolean.TRUE);
         //Cleal
                  
         String listaEstatusVentaCalif = this.conectorParametroLimpia("varEstatusVenta", "", true);
         traza("listaEstatusVentaCalif: "+listaEstatusVentaCalif);
         //
         traza("*************** DTOCOncurso a setear: " + this.concurso);
         this.setConcurso(concurso);     
         this.asignarAtributo("VAR", "ejecutar", "valor", "cierraModalOK('" +sListasCalificacion + "');");
    }
  
  
    /**
     * @author: ssantana, 30/6/2005
     * @throws java.lang.Exception
     */
    private void almacenarModalEstatusVenta() throws Exception {
         String sListaEstatusVenta = this.conectorParametroLimpia("hidLstEstatusVta", "", true);
         this.pagina("salidaGenerica");
         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    
         traza("LPMantenerParametrosCalificacion.almacenarModalEstatusVenta()");
         traza("sListaEstatusVenta: " + sListaEstatusVenta);
    
         this.concurso = this.getConcurso();
    
         // Se maneja de esta manera para que esté en concordancia con la forma de 
         // levantar los datos de LPMantenerParametrosConsultoras (se llama a esta LP
         // para levantar los Datos de Estatus Venta desde este Caso de Uso).
         ArrayList aList = this.aplanarEstatusVenta(sListaEstatusVenta);
    
         DTOListaEstatusVenta dtoListaEstatusVtaAuxiliar = this.concurso.getEstatusVenta();
         
         if (dtoListaEstatusVtaAuxiliar == null){
             dtoListaEstatusVtaAuxiliar = new DTOListaEstatusVenta();
         }
      
         //DTOListaEstatusVenta dtoListaEstatusVtaAuxiliar = new DTOListaEstatusVenta();
         dtoListaEstatusVtaAuxiliar.setEstatusVenta(aList);

         //indica que ya se ha rellenado la pestaña  
         this.concurso.setIndEstatusVenta(Boolean.TRUE); 
    
         this.concurso.setEstatusVenta(dtoListaEstatusVtaAuxiliar);
         this.setConcurso(this.concurso);

         asignarAtributo("VAR","ejecutar","valor","despuesAlmacenarEstatusVenta()");
    }
  
    /**
    * @author: ssantana, 30/6/2005 - (Extraido de LPMantenerParametrosConsultoras)
    * @throws java.lang.Exception
    * @return ArrayList
    * @param String listado
    */
    private ArrayList aplanarEstatusVenta(String listado) throws Exception {
         traza("Entre a LPMantenerParametrosCalificacion.aplanarEstatusVenta()");
         traza(listado);
         
         Long lIdioma = UtilidadesSession.getIdioma(this);
         Long lPais = UtilidadesSession.getPais(this);

         StringTokenizer stRows = new StringTokenizer(listado, "$");
         int rowCount = stRows.countTokens();
         ArrayList lstClasPart = new ArrayList ();
         
         for (int cont =  0 ;stRows.hasMoreTokens(); cont++){
             DTOEstatusVenta dtoE=  new DTOEstatusVenta();
             dtoE.setOidIdioma(lIdioma);
             dtoE.setOidPais(lPais);
             StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
             
             for (int conta =  0 ;stColss.hasMoreTokens(); conta++){                                                                     
                  StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");
                  
                  for (int contad =  0 ;stCols.hasMoreTokens(); contad++){
                      String desc = stCols.nextToken().toString();
                      String valor = stCols.nextToken().toString();
                      traza("--> " + desc + " " + valor);
                      
                      if ( desc.equals("oEv") ){
                           if (valor!= null && !valor.equals("null"))
                                dtoE.setOidEstatus(new Long(valor));
                      }
                      
                      if ( desc.equals("oEM") ){
                           if (valor!= null && !valor.equals(""))
                                dtoE.setOidEstatusVentaMae(new Long(valor));
                      }
                      
                      if ( desc.equals("oPd") ){
                           if (valor!= null && !valor.equals(""))
                                dtoE.setOidPeriodoDesde(new Long(valor));
                      }
                      
                      if ( desc.equals("oPh") ){
                           if (valor!= null )
                                dtoE.setOidPeriodoHasta(new Long(valor));
                      }
                      
                      if ( desc.equals("dEv") ){
                           if (valor!= null)
                                dtoE.setDesEstatus(valor);
                      }
                      
                      if ( desc.equals("dPd") ){
                           if (valor!= null)
                                dtoE.setDesPeriodoDesde(valor);
                      }
                      
                      if ( desc.equals("dPh") ){
                           if (valor!= null)
                                dtoE.setDesPeriodoHasta(valor);
                      }  
                  }
             }
             
             traza("DTO CLAS     " + dtoE);
             lstClasPart.add(dtoE);
         }
         
         return  lstClasPart;
    }  

            /**
     * @author: dmaneiro, 25/01/2006
     * @throws java.lang.Exception
     */
           public void validarMetasVentaProyectada() throws Exception{
                   traza("*********Entro a validarMetasVentaProyectada()******");
                   pagina("salidaGenerica");
                  this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

                  this.concurso = this.getConcurso();

        if (this.concurso.getParamCalificacion() == null){
             this.almacenar();
        }
                  
                           String tempCkActivas = this.conectorParametroLimpia("tempCkActivas", "", true);
                  //SE SETEAN LOS 16 CHECKBOX
                  if (!tempCkActivas.equals("")){
                           
                           String tempCkIngreso = this.conectorParametroLimpia("tempCkIngreso", "", true);
                           String tempCkReingreso = this.conectorParametroLimpia("tempCkReingreso", "", true);
                           String tempCkEgresos = this.conectorParametroLimpia("tempCkEgresos", "", true);
                           String tempCkEntregadas = this.conectorParametroLimpia("tempCkEntregadas", "", true);
                           String tempCkRecibidas = this.conectorParametroLimpia("tempCkRecibidas", "", true);
                           String tempCkCapitalizacion = this.conectorParametroLimpia("tempCkCapitalizacion", "", true);
                           String tempCkActivasFinales = this.conectorParametroLimpia("tempCkActivasFinales", "", true);
                           String tempCkActividad = this.conectorParametroLimpia("tempCkActividad", "", true);
                           String tempCkNumpedidos = this.conectorParametroLimpia("tempCkNumpedidos", "", true);
                           String tempCkPrecioPromedioUnitario = this.conectorParametroLimpia("tempCkPrecioPromedioUnitario", "", true);
                           String tempCkPromedioVentaPedido = this.conectorParametroLimpia("tempCkPromedioVentaPedido", "", true);
                           String tempCkPromedioUnidadesPedido = this.conectorParametroLimpia("tempCkPromedioUnidadesPedido", "", true);
                           String tempCkPromedioOrdenesPedido = this.conectorParametroLimpia("tempCkPromedioOrdenesPedido", "", true);
                           String tempCkRetencion = this.conectorParametroLimpia("tempCkRetencion", "", true);
                           String tempCkVentaEstadisticable = this.conectorParametroLimpia("tempCkVentaEstadisticable", "", true);

                           traza("********** tempCkActivas " + tempCkActivas);
                           traza("********** tempCkIngreso " + tempCkIngreso);
                           traza("********** tempCkReingreso " + tempCkReingreso);
                           traza("********** tempCkEgresos " + tempCkEgresos);
                           traza("********** tempCkEntregadas " + tempCkEntregadas);
                           traza("********** tempCkRecibidas " + tempCkRecibidas);
                           traza("********** tempCkCapitalizacion " + tempCkCapitalizacion);
                           traza("********** tempCkActivasFinales " + tempCkActivasFinales);
                           traza("********** tempCkActividad " + tempCkActividad);
                           traza("********** tempCkNumpedidos " + tempCkNumpedidos);
                           traza("********** tempCkPrecioPromedioUnitario " + tempCkPrecioPromedioUnitario);
                           traza("********** tempCkPromedioVentaPedido " + tempCkPromedioVentaPedido);
                           traza("********** tempCkPromedioUnidadesPedido " + tempCkPromedioUnidadesPedido);
                           traza("********** tempCkPromedioOrdenesPedido " + tempCkPromedioOrdenesPedido);
                           traza("********** tempCkRetencion " + tempCkRetencion);
                           traza("********** tempCkVentaEstadisticable " + tempCkVentaEstadisticable);

                           DTOVariablesVentaProyectada dtoVariables = new DTOVariablesVentaProyectada();
                           //Linea 1
                           //-------

                           //Activas
                           if(tempCkActivas.equals("S")) dtoVariables.setIndActivas(new Boolean(true));
                           else dtoVariables.setIndActivas(new Boolean(false));

                           //Ingreso
                           if(tempCkIngreso.equals("S")) dtoVariables.setIndIngreso(new Boolean(true));
                           else dtoVariables.setIndIngreso(new Boolean(false));

                           //Reingreso
                           if(tempCkReingreso.equals("S")) dtoVariables.setIndReingreso(new Boolean(true));
                           else dtoVariables.setIndReingreso(new Boolean(false));

                           //Egresos
                           if(tempCkEgresos.equals("S")) dtoVariables.setIndEgresos(new Boolean(true));
                           else dtoVariables.setIndEgresos(new Boolean(false));

                           //Entregadas
                           if(tempCkEntregadas.equals("S")) dtoVariables.setIndEntregadas(new Boolean(true));
                           else dtoVariables.setIndEntregadas(new Boolean(false));

                           //Recibidas
                           if(tempCkRecibidas.equals("S")) dtoVariables.setIndRecibidas(new Boolean(true));
                           else dtoVariables.setIndRecibidas(new Boolean(false));

                           //Capitalizacion
                           if(tempCkCapitalizacion.equals("S")) dtoVariables.setIndCapitalizacion(new Boolean(true));
                           else dtoVariables.setIndCapitalizacion(new Boolean(false));

                           //Linea 2
                           //-------

                           //Activas finales
                           if(tempCkActivasFinales.equals("S")) dtoVariables.setIndActivasFinales(new Boolean(true));
                           else dtoVariables.setIndActivasFinales(new Boolean(false));

                           //Actividad
                           if(tempCkActividad.equals("S")) dtoVariables.setIndActividad(new Boolean(true));
                           else dtoVariables.setIndActividad(new Boolean(false));

                           //N° pedidos
                           if(tempCkNumpedidos.equals("S")) dtoVariables.setIndNumeroPedidos(new Boolean(true));
                           else dtoVariables.setIndNumeroPedidos(new Boolean(false));

                           //Precio promedio unitario
                           if(tempCkPrecioPromedioUnitario.equals("S")) dtoVariables.setIndPrecioPromedioUnitario(new Boolean(true));
                           else dtoVariables.setIndPrecioPromedioUnitario(new Boolean(false));

                           //Promedio venta pedido
                           if(tempCkPromedioVentaPedido.equals("S")) dtoVariables.setIndPromedioVentaPedido(new Boolean(true));
                           else dtoVariables.setIndPromedioVentaPedido(new Boolean(false));

                           //Linea 3
                           //-------

                           //Promedio unidades pedido
                           if(tempCkPromedioUnidadesPedido.equals("S")) dtoVariables.setIndPromedioUnidadesPedido(new Boolean(true));
                           else dtoVariables.setIndPromedioUnidadesPedido(new Boolean(false));

                           //Promedio ordenes pedido
                           if(tempCkPromedioOrdenesPedido.equals("S")) dtoVariables.setIndPromedioOrdenesPedido(new Boolean(true));
                           else dtoVariables.setIndPromedioOrdenesPedido(new Boolean(false));

                           //Retencion
                           if(tempCkRetencion.equals("S")) dtoVariables.setIndRetencion(new Boolean(true));
                           else dtoVariables.setIndRetencion(new Boolean(false));

                           //Venta estadisticable
                           if(tempCkVentaEstadisticable.equals("S")) dtoVariables.setIndVentaEstadisticable(new Boolean(true));
                           else dtoVariables.setIndVentaEstadisticable(new Boolean(false));

                           //Se setea el DTOVariablesVentaProyectada al DTOConcurso de sesion
                           this.concurso.setVariablesVentaProyectada(dtoVariables);
                           this.setConcurso(this.concurso);
                  }

                  if( this.concurso.getVariablesVentaProyectada() == null) { //ya ingreso por la pestaña Definir Metas Proyectadas - Agregado por incidencia 22116 - dmaneiro - 12/01/2006 
                           traza("***************Entro a if( this.concurso.getVariablesVentaProyectada() == null) ***********");	
                           asignarAtributo("VAR", "ejecutar", "valor", "mostrarError()");
                  
                  } else{
                  
                           asignarAtributo("VAR", "ejecutar", "valor", "cargarMantenerMetas()");
                  
                  }
                           traza("*********Sale a validarMetasVentaProyectada()******");
                            
          }

	private void actualizarSesionDtosVentaHistorica() throws Exception {
		 traza("LPMantenerParametrosCalificacion.actualizarSesionDtosVentaHistorica() - Entrada");
 		 pagina("salidaGenerica");	
         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

		 String listaMetasTipoVenta = this.conectorParametro("listaMetasTipoVenta");
 		 traza("****************** listaMetasTipoVenta " + listaMetasTipoVenta);

		 dtoListaMetasTipoVentaSesion = (DTOListaMetasTipoVenta)conectorParametroSesion("dtoListaMetasTipoVentaSesion");
  		 traza("****************** dtoListaMetasTipoVentaSesion " + dtoListaMetasTipoVentaSesion);

		 if(dtoListaMetasTipoVentaSesion==null) {
			dtoListaMetasTipoVentaSesion = new DTOListaMetasTipoVenta();
		 }

		 ArrayList lista = parsearListaMetasTipoVenta(listaMetasTipoVenta);
		 dtoListaMetasTipoVentaSesion.setListaMetas(lista);

		 conectorParametroSesion("dtoListaMetasTipoVentaSesion", dtoListaMetasTipoVentaSesion);    
		
		 asignarAtributo("VAR", "ejecutar", "valor", "despuesActualizarSesionDtosVentaHistorica()");
		 traza("LPMantenerParametrosCalificacion.actualizarSesionDtosVentaHistorica() - Salida");
	}
	
	private void actualizarSesionDtos() throws Exception {
		 traza("LPMantenerParametrosCalificacion.actualizarSesionDtos() - Entrada");
		 pagina("salidaGenerica");	
         this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
		 
		 String tempvalorActualizar = this.conectorParametro("valorActualizar");
		 String hCbUniAdmin = this.conectorParametroLimpia("hCbUniAdmin", "", true);
		 String oidFilaModificada = this.conectorParametroLimpia("oidFilaModificada", "", true);

		 traza("************ tempvalorActualizar " + tempvalorActualizar);
		 traza("************ hCbUniAdmin " + hCbUniAdmin);
		 traza("************ oidFilaModificada " + oidFilaModificada);

		 dtoListaMetasAuxiliarSubgerencia = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia");
		 dtoListaMetasAuxiliarRegion = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarRegion");
		 dtoListaMetasAuxiliarZona = (DTOListaMetasVentaProyectada)conectorParametroSesion("dtoListaMetasAuxiliarZona");

		 traza("************ dtoListaMetasAuxiliarSubgerencia " + dtoListaMetasAuxiliarSubgerencia);
		 traza("************ dtoListaMetasAuxiliarRegion " + dtoListaMetasAuxiliarRegion);
		 traza("************ dtoListaMetasAuxiliarZona " + dtoListaMetasAuxiliarZona);

		 if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){
			actualizarRegistroListaMetas(dtoListaMetasAuxiliarSubgerencia, oidFilaModificada,
				hCbUniAdmin, tempvalorActualizar);			
		 }
		 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){
			actualizarRegistroListaMetas(dtoListaMetasAuxiliarRegion, oidFilaModificada,
				hCbUniAdmin, tempvalorActualizar);			
		 }
		 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
 			actualizarRegistroListaMetas(dtoListaMetasAuxiliarZona, oidFilaModificada,
				hCbUniAdmin, tempvalorActualizar);			
		 }

		 asignarAtributo("VAR", "ejecutar", "valor", "despuesActualizarSesionDtos()");
         traza("LPMantenerParametrosCalificacion.actualizarSesionDtos() - Salida");
	}	 

	private void actualizarRegistroListaMetas(DTOListaMetasVentaProyectada dtoActual, 
		 String oidFilaModificada, String hCbUniAdmin, String sLista) throws Exception {
		 traza("LPMantenerParametrosCalificacion.actualizarRegistroListaMetas - Entrada");

		 traza("******** DTOListaMetasVentaProyectada " + dtoActual);
 		 traza("******** oidFilaModificada " + oidFilaModificada);
 		 traza("******** hCbUniAdmin " + hCbUniAdmin);
  		 traza("******** sLista " + sLista);

		 ArrayList listaMetasNueva = new ArrayList();

		 ArrayList listaMetas = dtoActual.getListaMetas();	
		 Iterator it = listaMetas.iterator();
		 DTOMetasVentaProyectada dtoMVP = null;

		 DTOMetasVentaProyectada dto = null;
  
         String registro = null;
         StringTokenizer strListas = null;
         StringTokenizer strLinea = null;
    
		 for (int j = 0; it.hasNext(); j++){      
			dtoMVP = (DTOMetasVentaProyectada)it.next();
			
			traza("******** dtoMVP.getOid() " + dtoMVP.getOid().toString());
  		    traza("******** oidFilaModificada " + oidFilaModificada);
			
			if(dtoMVP.getOid().toString().equals(oidFilaModificada)) {
	  		    traza("******** COINCIDE");
				if (sLista != null){
					 strListas = new StringTokenizer(sLista, "|");
				 
					 while (strListas.hasMoreTokens()){
						  registro = strListas.nextToken();
						  strLinea = new StringTokenizer(registro, ",");
						  int i = 0;

						  dto = new DTOMetasVentaProyectada();

						  while(strLinea.hasMoreTokens()) {
							String campo = strLinea.nextToken();

							if(i==0) {
								if(!campo.equals(" ")) 
									dto.setOid(new Long(campo));
							}

							if(i==1) {
								if(!campo.equals(" ")) 
									dto.setOidCliente(new Long(campo));		
							}

							if(i==2) {
								if(!campo.equals(" "))                   
									dto.setCodigoCliente(campo);						
							}

							if(i==3) {
								if(!campo.equals(" "))		
									dto.setNombrePeriodo(campo);											
							}

							if(i==4) {
								if(!campo.equals(" "))	
								   dto.setNumActivasIniciales(new Long(campo));   
							}

							if(i==5) {
								if(!campo.equals(" "))			
								  dto.setImpIngreso(new BigDecimal(campo));	
							}

							if(i==6) {
								if(!campo.equals(" "))		
								  dto.setImpReingreso(new BigDecimal(campo));
							}

							if(i==7) {
								if(!campo.equals(" "))	
								  dto.setImpEgresos(new BigDecimal(campo));
							}

							if(i==8) {
								if(!campo.equals(" "))					
								  dto.setNumEntregadas(new Long(campo));
							}

							if(i==9) {
								if(!campo.equals(" "))			
								  dto.setNumRecibidas(new Long(campo));		
							}

							if(i==10) {
								if(!campo.equals(" "))	
								  dto.setCapitalizacion(new Long(campo));	
							}

							if(i==11) {
								if(!campo.equals(" "))		
								  dto.setNumActivasFinales(new Long(campo));  
							}

							if(i==12) {
								if(!campo.equals(" "))				
								  dto.setActividad(new BigDecimal(campo));				  
							}

							if(i==13) {
								if(!campo.equals(" "))		
								  dto.setNumPedidos(new Long(campo));	
							}

							if(i==14) {
								if(!campo.equals(" "))			
								  dto.setPrecioPromedioUnitario(new BigDecimal(campo));	
							}

							if(i==15) {
								if(!campo.equals(" "))		
								  dto.setPromedioVentaPedido(new BigDecimal(campo));	
							}

							if(i==16) {
								if(!campo.equals(" "))		
								  dto.setPromedioUnidadesPedido(new BigDecimal(campo));
							}
							
							if(i==17) {
								if(!campo.equals(" "))		
								  dto.setPromedioOrdenesPedido(new BigDecimal(campo)); 
							}

							if(i==18) {
								if(!campo.equals(" ")) {					
								  dto.setImpRetencion(new BigDecimal(campo));	
								  dto.setRetencion(new Double(campo));	
								}
							}

							if(i==19) {
								if(!campo.equals(" "))		
								  dto.setImpVentaEstadisticable(new BigDecimal(campo));
							}

							if(i==20) {
								if(!campo.equals(" "))		
								  dto.setOidPeriodo(new Long(campo));    	
							}

							if(i==21) {
								if(!campo.equals(" "))		
									dto.setImpCapitalizacion(new BigDecimal(campo));										
							}

							if(i==22) {
								if(!campo.equals(" "))		
									dto.setNumClientes(new Long(campo));											
							}

							if(i==23) {
								if(!campo.equals(" "))		
									dto.setNumOrdenes(new Long(campo));											
							}

							if(i==24) {
								if(!campo.equals(" "))		
									dto.setNumUnidadesVendidas(new Long(campo));											
							}

							if(i==25) {
								if(!campo.equals(" "))		
									dto.setOidUA(new Long(campo));											
							}

							if(i==26) {
								//if(!campo.equals(" "))		
								//	dto.setRetencion(new Long(campo));											
							}

							i++;				  
						  }            

						  traza("++++++ DTOMetasVentaProyectada " + dto);
						  listaMetasNueva.add(dto);
					 }
				 }
			}
			else {
				listaMetasNueva.add(dtoMVP);
			}
         }		 

		 traza("********** listaMetasNueva: " + listaMetasNueva);
		 dtoActual.setListaMetas(listaMetasNueva);	

		 if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.toString())){		
		    traza("********** Actualizando subgerencia");
			conectorParametroSesion("dtoListaMetasAuxiliarSubgerencia",dtoActual);
		 }
		 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_REGION.toString())){ 
 		    traza("********** Actualizando region");
			conectorParametroSesion("dtoListaMetasAuxiliarRegion",dtoActual);
		 }
		 else if (hCbUniAdmin.equals(ConstantesINC.OID_AGRUPACION_ZONA.toString())){
  		    traza("********** Actualizando zona");
			conectorParametroSesion("dtoListaMetasAuxiliarZona",dtoActual);
		 }	 

		 traza("LPMantenerParametrosCalificacion.actualizarRegistroListaMetas - Salida");
	 }
}