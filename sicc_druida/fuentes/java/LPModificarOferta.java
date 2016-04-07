//$Id: LPModificarOferta.java,v 1.1 2009/12/03 18:40:34 pecbazalar Exp $

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
/**
 * Sistema:           Belcorp
 * Modulo:            PRE
 * Submódulo:         Precios
 * Componente:        LP
 * Fecha:             13/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author             Bosnjak Juan Pablo
 */

//import LPSICCBase;

import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOModificarOferta;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPModificarOferta extends LPSICCBase {
    private DruidaConector conCriteriosBusqueda;
    private Vector paramEntrada;
    private String accion;
    private String casoDeUso;
    private DTOOID dtooid;
    private DTOOferta dtoOferta;
    private DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta;
    private DTOOID dtoOID;
    private DTOPromocion dtoPromocion;
    private DTOGrupo dtoGrupo;
    private MareBusinessID id;
    private Long idioma = null;
    private Long pais = null;
    private Long oidTipoCliente = null;
    private Long oidSubtipoCliente = null;
    private Long oidTipoClasificacion = null;
    private Long oidClasificacion = null;
    private Long oidEstatus = null;
    private String desTipoCliente = null;
    private String desSubtipoCliente = null;
    private String desTipoClasificacion = null;
    private String desClasificacion = null;
    private String desEstatus = null;
    private String estatus2;
    private String elementosSeleccionadosVentaExclusiva = null;
    private Long oidCabeceraMF = null;
    private Integer nroGrupo = null;
    private Long oidPromocion = null;
    private String nombreLista = "";
    Vector vectorDtoPromo = new Vector();
    Vector vectorPromocion = new Vector();
    Vector v;
    char p = 'P';
    char r = 'R';
    char s = 'S';
    /*   definiciones para armar mi lista de Promocion*/
    Document doc = null;
    XMLDocument xml = null;

    private Element fieldset1 = null;
    private Element tr = null;
    private Element listaEditableObtenida = null;
    DTOPromocion elemPromocion = null;
    long indice = 0;
    //Integer yLista = new Integer(913);
    static int TAMANOPAGINASINDINAMICA = 757;
    Integer yLista;


    /*  ******GRUPOS********   */
    private Element table1 = null;
    private Element table2 = null;
    private Element table3 = null;
    private Element table5 = null;
    private Element table6 = null;
    private Element tablaAfueraG = null;
    private Element div = null;

    private Element tr1 = null;
    private Element tr2 = null;
    private Element tr3 = null;
    private Element tr5 = null;
    private Element tr6 = null;
    private Element fieldset2 = null;
    private Element fieldset3 = null;
    private Element fieldset4 = null;
    private Element legend1 = null;
    private Long oidArgumentoVenta=null;
    private Integer numeroOrden=null;
    private String despachoCompleto;
    private String despachoAutomatico;
    private String recuperacionObligatoria;
    private Long oidIndicadorCuadre=null;
    private Integer condicionCondicionantes;
    private Integer condicionCondicionados;
    private Long formaPago=null;
    private String rbCondicionantes;
    private String rbCondicionados;
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;

    private String region;
    private String zona;
	private boolean algunoExiste = false;
    
    public LPModificarOferta() {
      super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        TiempoDeCargaInicio=System.currentTimeMillis();
        setTrazaFichero();
        accion = conectorParametroLimpia("accion", "", true);
        casoDeUso = "modificar";
        try {
           traza("accion    *****   accion   " + accion);
           //asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
           //asignarAtributo("VAR", "hNombreListas", "valor", nombreLista);

           pais = UtilidadesSession.getPais(this);
           idioma = UtilidadesSession.getIdioma(this);

           if (conectorParametroSesion("DTOOferta") == null) {
              traza("es nulo");
           } else {
              traza("no es nulo");
           }


           if (accion.equals("")) {
              //rastreo();
              conectorParametroSesion("UltimaLP", "LPModificarOferta");
              conectorAction("LPSeleccionarMF");
              conectorActionParametro("accion", "");
              conectorActionParametro("nueva", "");

           } else if (accion.equals("Matriz seleccionada")) {
              cargarCriteriosBusqueda();

           } else if (accion.equals("ObtenerOfertaModificacion")) {
              configurarInicial();
              obtenerOfertaModificacion();
              configurarPantalla();
           } else if (accion.equals("EliminarOferta")) {
              eliminarOferta();
              conectorAction("LPModificarOferta");
              conectorActionParametro("accion", "");
           } else if (accion.equals("Guardar")) {
              obtenerDatosPantalla();
              guardarOferta();
              conectorAction("LPModificarOferta");
              conectorActionParametro("accion", "");
           } else if (accion.equals("BuscarProducto")) {
              obtenerDatosPantalla();
              buscarProducto("principal");
           } else if (accion.equals("BuscarProductoAsoc")) {
              obtenerDatosPantalla();
              buscarProducto("asociado");
           }else if (accion.equals("Producto seleccionado")) {
              configurarInicial();
              productoSeleccionado();
              actualizarOferta();
              cargarPantalla();
              configurarPantalla();
           }else if (accion.equals("Producto modificado")) {
              configurarInicial();
              productoModificado();
              //actualizarOferta();INC. SICC 20070032 
              cargarPantalla();
              configurarPantalla();
           }else if (accion.equals("eliminarProductos")) {
              configurarInicial();
              obtenerDatosPantalla();
              eliminarProductos();            
              cargarPantalla();
              configurarPantalla();
           }else if (accion.equals("AnadirGrupo")) {
              obtenerDatosPantalla();
              anadirGrupo();
           } else if (accion.equals("GrupoAnadido")) {
              configurarInicial();
              actualizarOferta();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("ModificarGrupo")) {
              obtenerDatosPantalla();
              modificarGrupo();
           // Agregado por SICC20070316 - Rafael Romero - 18/07/2007
           } else if (accion.equals("ConsultarGrupo")) {
              obtenerDatosPantalla();
              consultarGrupo();
           // fin agrgado SICC20070316
           } else if (accion.equals("EliminarGrupo")) {
              configurarInicial();
              obtenerDatosPantalla();
              eliminarGrupo();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("AnadirCondicion")) {
              obtenerDatosPantalla();
              anadirCondicion();
           } else if (accion.equals("ModificarCondicion")) {
              obtenerDatosPantalla();
              modificarCondicion();
           } else if (accion.equals("Condicion aniadida")) {
              configurarInicial();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("Condicion modificada")) {
              configurarInicial();
              condicionModificada();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("EliminarCondicion")) {
              configurarInicial();
              obtenerDatosPantalla();
              eliminarCondicion();       
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("aniadirVentaExclusiva")) {
              obtenerDatosPantalla();
              configurarInicial();
              anadirVentaExclusiva();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("eliminarVentaExclusiva")) {
              obtenerDatosPantalla();
              configurarInicial();
              eliminarVentaExclusiva();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("vuelveError")) {
              configurarInicial();
              cargarPantalla();
              configurarPantalla();
           } else if (accion.equals("Modificar producto") ) {
              // Agregado por ssantana, 6/10/2005, SICC-GCC-PRE-001
              this.modificarProducto();
            // Agregado por SICC20070316 - Rafael Romero - 19/07/2007
            } else if (accion.equals("Consultar producto") ) {
                this.consultarProducto();
            // Fin agregado SICC20070316
           }
           
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
           
        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPModificarOferta es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
			if (algunoExiste) {
			   throw new MareException(new Exception(), 50047);
			}
        } catch (Exception e) {           
           configurarInicial();
           asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
             if (e instanceof InvocationTargetException){ 
              if (((InvocationTargetException)e).getTargetException() instanceof OrionRemoteException) {
                OrionRemoteException ore = (OrionRemoteException)((InvocationTargetException)e).getTargetException();
                if (ore.detail instanceof SQLException) {
                   SQLException sqlException = (SQLException) (ore.detail); 
                   if ((sqlException.toString().indexOf("MTCA_MAFA_FK") != -1)||
                       (sqlException.toString().indexOf("MTCA_MAFA_FK2") != -1)||
                       (sqlException.toString().indexOf("MTRE_MAFA_FK") != -1)||
                       (sqlException.toString().indexOf("MTRE_MAFA_FK2") != -1)||
                       (sqlException.toString().indexOf("MTRZ_MAFA_FK") != -1)||
                       (sqlException.toString().indexOf("MTRZ_MAFA_FK2") != -1)){
                     this.lanzarPaginaError(new MareException(new Exception(), 50051));                     
                   } else {
                     this.lanzarPaginaError(new MareException(new Exception(), 50011));
                   }
                } else {
                  this.lanzarPaginaError(e);
                }                
              } else {
                this.lanzarPaginaError(e);
              }
             } else {           
                this.lanzarPaginaError(e);
             }
             logStackTrace(e);
          cargarPantalla();
          configurarPantalla();       
             
           //logStackTrace(e);
        }
    }

    /* ************** logStackTrace ******************* */
    private void logStackTrace(Throwable e) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        e.printStackTrace(ps);
        try {
           traza(os.toString());
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    private void obtenerDatosPantalla() throws Exception{
        //cargamos Datos de la oferta
        DTOOferta dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        
      

        oidClasificacion = ((conectorParametro("cbClasificacionCliente") == null) ||
                            conectorParametro("cbClasificacionCliente").equals("")) ? null
                           : Long.valueOf(conectorParametro("cbClasificacionCliente"));
        oidTipoClasificacion = ((conectorParametro("cbTipoClasificacionCliente") == null) ||
                                conectorParametro("cbTipoClasificacionCliente").equals("")) ? null
                               : Long.valueOf(conectorParametro("cbTipoClasificacionCliente"));
        oidTipoCliente = ((conectorParametro("cbTipoCliente") == null) ||
                          conectorParametro("cbTipoCliente").equals("")) ? null
                         : Long.valueOf(conectorParametro("cbTipoCliente"));
        oidSubtipoCliente = ((conectorParametro("cbSubTipoCliente") == null) ||
                             conectorParametro("cbSubTipoCliente").equals("")) ? null
                            : Long.valueOf(conectorParametro("cbSubTipoCliente"));
        oidEstatus = ((conectorParametro("cbEstatusCliente") == null) ||
                      conectorParametro("cbEstatusCliente").equals("")) ? null
                     : Long.valueOf(conectorParametro("cbEstatusCliente"));

        oidPromocion = ((conectorParametro("hOidPromocion") == null) ||
                        conectorParametro("hOidPromocion").equals("")) ? null
                       : Long.valueOf(conectorParametro("hOidPromocion"));

        estatus2 = conectorParametro("txtEstatus2");
        desClasificacion = conectorParametro("hDesClasificacion");
        desTipoClasificacion = conectorParametro("hDesTipoClasificacion");
        desTipoCliente = conectorParametro("hDesTipoCliente");
        desSubtipoCliente = conectorParametro("hDesSubtipoCliente");
        desEstatus = conectorParametro("hDesEstatusCliente");

        region = conectorParametroLimpia( "cbRegion", "", true );
        zona = conectorParametroLimpia( "cbZona", "", true );
        
        oidArgumentoVenta = (conectorParametro("cbArgumentoVenta")==null || 
                                  conectorParametro("cbArgumentoVenta").equals(""))?null:
                                  Long.valueOf(conectorParametro("cbArgumentoVenta"));
/*        numeroOrden = (conectorParametroNumero("txtNumeroOrden", this.FORMATO_DEFAULT)==null || 
                                  conectorParametroNumero("txtNumeroOrden", this.FORMATO_DEFAULT).equals(""))?null:
                                  Integer.valueOf(conectorParametroNumero("txtNumeroOrden", this.FORMATO_DEFAULT));
se elimina por pedido de cambio PRE-003
*/
        despachoCompleto = conectorParametro("ckDespachoCompleto")==null?"":conectorParametro("ckDespachoCompleto");
        traza("despachoCompleto: "+despachoCompleto);
        
        despachoAutomatico = conectorParametro("ckDespachoAutomatico")==null?"":conectorParametro("ckDespachoAutomatico");
        traza("despachoAutomatico: "+despachoAutomatico);
        
        recuperacionObligatoria = conectorParametro("ckRecObligPedido")==null?"":conectorParametro("ckRecObligPedido");
        traza("recuperacionObligatoria: "+recuperacionObligatoria);        
        oidIndicadorCuadre = (conectorParametro("cbIndicadorCuadre")==null || 
                                  conectorParametro("cbIndicadorCuadre").equals(""))?null:
                                  Long.valueOf(conectorParametro("cbIndicadorCuadre"));

        condicionCondicionantes = (conectorParametro("txtNumeroGruposCondicionantes")==null || 
                                  conectorParametro("txtNumeroGruposCondicionantes").equals(""))?null:
                                  Integer.valueOf(conectorParametro("txtNumeroGruposCondicionantes"));
        
        condicionCondicionados = (conectorParametro("txtNumeroGruposCondicionados")==null || 
                                  conectorParametro("txtNumeroGruposCondicionados").equals(""))?null:
                                  Integer.valueOf(conectorParametro("txtNumeroGruposCondicionados"));
        
        rbCondicionantes = ((conectorParametro("hidRDCondicionantes")==null)||(conectorParametro("hidRDCondicionantes").equals("")))?null:(conectorParametro("hidRDCondicionantes").equals("N")) ? "O" : "Y";;
        traza("rbCondicionantes: "+ rbCondicionantes);        
        rbCondicionados = ((conectorParametro("hidRDCondicionados")==null)||(conectorParametro("hidRDCondicionados").equals("")))?null:(conectorParametro("hidRDCondicionados").equals("N")) ? "O" : "Y";;
        traza("rbCondicionados: "+ rbCondicionados);
        
        formaPago = (conectorParametro("cbFormasPago")==null || 
                                  conectorParametro("cbFormasPago").equals(""))?null:
                                  Long.valueOf(conectorParametro("cbFormasPago"));

        dtoOferta.setCondicionCondicionados(rbCondicionados);
        dtoOferta.setCondicionCondicionantes(rbCondicionantes);
        dtoOferta.setOidArgumentoVenta(oidArgumentoVenta);
        dtoOferta.setNumeroOrden(numeroOrden);
        dtoOferta.setDespachoCompleto(despachoCompleto.equals("N") ? Boolean.FALSE : Boolean.TRUE);
        dtoOferta.setDespachoAutomatico(despachoAutomatico.equals("N") ? Boolean.FALSE : Boolean.TRUE);
        dtoOferta.setRecuperacionObligatoria(recuperacionObligatoria.equals("N") ? Boolean.FALSE : Boolean.TRUE);
        traza("oidIndicadorCuadre "+oidIndicadorCuadre);
        dtoOferta.setOidIndCuadre(oidIndicadorCuadre);
        dtoOferta.setNumeroGruposCondicionantes(condicionCondicionantes);
        dtoOferta.setNumeroGruposCondicionados(condicionCondicionados);
        dtoOferta.setOidFormaPago(formaPago);
        
        conectorParametroSesion("DTOOferta", dtoOferta);
    }
    

    private void configurarInicial() throws Exception {
        pagina("contenido_ofertas_modificar");
        traza("Se Cargo la Pagina contenido_ofertas_modificar");
        this.getFormatosValidaciones();
        asignarAtributoPagina("cod", "0154");
        getConfiguracionMenu();
    }

    private void cargarCriteriosBusqueda() throws Exception {
        pagina("contenido_oferta_seleccionar");
        this.getFormatosValidaciones();
        getConfiguracionMenu();
        oidCabeceraMF = (Long) conectorParametroSesion("oidCabeceraMF");
        asignarAtributo("VAR", "hidOidCabeceraMF", "valor",
                        (oidCabeceraMF == null ? "" : oidCabeceraMF.toString()));
        id = new MareBusinessID("PRECargarCriteriosBusquedaProductos");
        paramEntrada = new Vector();
        dtooid = new DTOOID();
        dtooid.setOidPais(pais);
        dtooid.setOidIdioma(idioma);
        dtooid.setOid(oidCabeceraMF);
        paramEntrada.add(dtooid);
        paramEntrada.add(id);
        conCriteriosBusqueda = conectar("ConectorCargarCriteriosBusquedaProductos", paramEntrada);

        DTOSCargarCriteriosBusquedaProductos dtoCargarCriteriosBusquedaProdu = (DTOSCargarCriteriosBusquedaProductos) conCriteriosBusqueda.objeto("dtoSalida");

        RecordSet catalogos = (RecordSet) dtoCargarCriteriosBusquedaProdu.getCatalogos();
        asignar("COMBO", "cbCatalogo",
                UtilidadesBelcorp.generarConector("DTOSalida.catalogos_ROWSET",
                                                  catalogos, catalogos.getColumnIdentifiers()),
                "DTOSalida.catalogos_ROWSET");

        RecordSet estrategias = (RecordSet)dtoCargarCriteriosBusquedaProdu.getEstrategias(); 
        asignar("COMBO", "cbEstrategia",
                UtilidadesBelcorp.generarConector("DTOSalida.estrategias_ROWSET",
                                                  estrategias, estrategias.getColumnIdentifiers()));

        RecordSet marcas = (RecordSet) dtoCargarCriteriosBusquedaProdu.getMarcas();
        asignar("COMBO", "cbMarca",
                UtilidadesBelcorp.generarConector("DTOSalida.marcas_ROWSET", marcas,
                                                  marcas.getColumnIdentifiers()), "DTOSalida.marcas_ROWSET");

        RecordSet lineaProducto = (RecordSet) dtoCargarCriteriosBusquedaProdu.getLineasProducto();
        asignar("COMBO", "cbLineaProducto",
                UtilidadesBelcorp.generarConector("DTOSalida.lineaproductos_ROWSET",
                                                  lineaProducto, lineaProducto.getColumnIdentifiers()),
                "DTOSalida.lineaproductos_ROWSET");

        RecordSet unidadNegocio = (RecordSet) dtoCargarCriteriosBusquedaProdu.getUnidadesNegocio();
        asignar("COMBO", "cbUnidadNegocio",
                UtilidadesBelcorp.generarConector("DTOSalida.unidadnegocio_ROWSET",
                                                  unidadNegocio, unidadNegocio.getColumnIdentifiers()),
                "DTOSalida.unidadnegocio_ROWSET");

        RecordSet negocio = (RecordSet) dtoCargarCriteriosBusquedaProdu.getNegocios();
        asignar("COMBO", "cbNegocio",
                UtilidadesBelcorp.generarConector("DTOSalida.negocio_ROWSET", negocio,
                                                  negocio.getColumnIdentifiers()), "DTOSalida.negocio_ROWSET");

        RecordSet generico = (RecordSet) dtoCargarCriteriosBusquedaProdu.getGenericos();
        asignar("COMBO", "cbGenerico",
                UtilidadesBelcorp.generarConector("DTOSalida.generico_ROWSET",
                                                  generico, generico.getColumnIdentifiers()),
                "DTOSalida.generico_ROWSET");

        RecordSet superGenerico = (RecordSet) dtoCargarCriteriosBusquedaProdu.getSupergenericos();
        asignar("COMBO", "cbSuperGenerico",
                UtilidadesBelcorp.generarConector("DTOSalida.supergenerico_ROWSET",
                                                  superGenerico, superGenerico.getColumnIdentifiers()),
                "DTOSalida.supergenerico_ROWSET");

        asignarAtributo("VAR", "tipoAccion", "valor", "LPModificarOferta");
        conectorParametroSesion("DTOSCargarCriteriosBusquedaProductos", dtoCargarCriteriosBusquedaProdu);
    }

    private void obtenerOfertaModificacion() throws Exception {
        String oidOferta=null;
        String matrizFacturada=null;
        if (conectorParametro("oidOferta")!=null&&(!conectorParametro("oidOferta").equals(""))){
            oidOferta = conectorParametro("oidOferta");
            matrizFacturada = conectorParametro("matrizFacturada");
        }else{
            matrizFacturada = conectorParametroLimpia("hidMatrizFacturada", "", true);
            oidOferta = conectorParametroLimpia("hidOidOferta", "", true);
        }
        traza("Se obtuvo la oferta oidOferta    " + oidOferta + "  matrizFacturada  " + matrizFacturada + " para su modificacion");
        id = new MareBusinessID("PREObtenerOfertaModificacion");
        dtoOID = new DTOOID();
        dtoOID.setOid((oidOferta == "" ? null : Long.valueOf(oidOferta)));
        dtoOID.setOidIdioma(this.idioma);
        dtoOID.setOidPais(this.pais);
        paramEntrada = new Vector();
        paramEntrada.add(dtoOID);
        paramEntrada.add(id);
        traza("antes del conector");
        DruidaConector conObtenerOfertaModif = conectar("ConectorObtenerOfertaModificacion",
                                                        paramEntrada);
        traza("despues del conector");
        DTOModificarOferta dtoModifOferta = (DTOModificarOferta) conObtenerOfertaModif.objeto("dtoSalida");
        oidCabeceraMF = dtoModifOferta.getDtoOferta().getOidCabeceraMF();

        conectorParametroSesion("DTOSCargarCriteriosDefinirOferta", dtoModifOferta.getDtoCargarCriterios());
        conectorParametroSesion("DTOOferta", dtoModifOferta.getDtoOferta());
        if (matrizFacturada.equals("1")) {
           traza("la matriz facturada es " + matrizFacturada);
           cargarPantalla();
           asignarAtributo("VAR", "hValorError", "valor", "PRE0011");
           asignarAtributo("VAR", "hDeshabilitaTodo", "valor", "S");      

        } else {        
           traza("entro por matriz igual a cero ");
           cargarPantalla();    
        }
    }

    private void guardarOferta() throws Exception {
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        traza("dtoOferta  antes de grabar   " + dtoOferta);
        id = new MareBusinessID("PREModificarOferta");
        
        Vector vecDet = dtoOferta.getDetalleOferta();
        Enumeration enDet = vecDet.elements();
        int lineaOferta = 1;
        while (enDet.hasMoreElements()){
            DTODetalleOferta dtoDet = (DTODetalleOferta)enDet.nextElement();
            if (!ConstantesPRE.OPERACION_BAJA.equals(dtoDet.getTipoOperacion())){
              dtoDet.setLineaOferta(new Integer(lineaOferta));
              lineaOferta++;
            }
        }

        paramEntrada = new Vector();
        paramEntrada.add(dtoOferta);
        paramEntrada.add(id);
        traza("antes del conector ConectorGuardarOferta");
        // Modificado por ssantana, 6/10/2005, GCC-PRE-001
        //conectar("ConectorGuardarOferta", paramEntrada);
        conectar("ConectorModificarOferta", paramEntrada);
        // Modificado por ssantana, 6/10/2005, GCC-PRE-001
        
        getRequest().getSession().removeAttribute("DTOOferta");
    }
    //Terminar de probar
    private void anadirGrupo() throws Exception {
        Integer nGrupos = null;
        Integer nPaquetes = null;
        String grupoCondicion = conectorParametro("cbTipoGrupo2");
        traza("grupoCondicion"+grupoCondicion);
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        dtoCargarCriterioDefOferta = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        /* comprobamos si la estrategia es condicionada */
        traza("anadir grupo dtoCargarCriterioDefOferta  " + dtoCargarCriterioDefOferta);
        if ((new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.CONDICIONADA) {

           //comprobar que se ha seleccionado algun valor o sino mostrar
           //mensaje PRE-0015
           //grupoCondicion contene el oid del combo si selecciono condicionante o condicionado
           if (grupoCondicion.equals("4")) {
              traza("grupo condicion 4");
              //condicionante
              //guarda en sesion grupo, paquete, condicionante, condicionado
              conectorParametroSesion("grupo", Boolean.FALSE);
              conectorParametroSesion("paquete", Boolean.FALSE);
              conectorParametroSesion("condicionante", Boolean.TRUE);
              conectorParametroSesion("condicionado", Boolean.FALSE);
              nGrupos = new Integer((dtoOferta.getNumeroGrupos() == null ? 1 : dtoOferta.getNumeroGrupos().intValue() + 1));
              dtoOferta.setNumeroGrupos(nGrupos);
              if (dtoOferta.getNumeroGruposCondicionantes()!=null){
                dtoOferta.setNumeroGruposCondicionantes(new Integer(dtoOferta.getNumeroGruposCondicionantes().intValue()+1));
              } else {
                dtoOferta.setNumeroGruposCondicionantes(new Integer(1));
              }
           } else if (grupoCondicion.equals("3")) {
              traza("grupo condicion 3");
              //condicionado
              //guarda en sesion grupo , paquete, condicionante, condicionado
              conectorParametroSesion("grupo", Boolean.FALSE);
              conectorParametroSesion("paquete", Boolean.FALSE);
              conectorParametroSesion("condicionante", Boolean.FALSE);
              conectorParametroSesion("condicionado", Boolean.TRUE);
              nGrupos = new Integer((dtoOferta.getNumeroGrupos() == null ? 1 : dtoOferta.getNumeroGrupos().intValue() + 1));
              dtoOferta.setNumeroGrupos(nGrupos);
              if (dtoOferta.getNumeroGruposCondicionados()!=null){
                dtoOferta.setNumeroGruposCondicionados(new Integer(dtoOferta.getNumeroGruposCondicionados().intValue()+1));
              } else {
                dtoOferta.setNumeroGruposCondicionados(new Integer(1));
              }             
              
           }
        } else 
        if ((new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO) {
           traza("si estrategia es de tipo Compuesta fija vs grupo habra que crear un paquete");
           //guardar en sesion grupo, paquete, condicionante, condicionado
           conectorParametroSesion("grupo", Boolean.FALSE);
           conectorParametroSesion("paquete", Boolean.TRUE);
           conectorParametroSesion("condicionante", Boolean.FALSE);
           conectorParametroSesion("condicionado", Boolean.FALSE);
           nPaquetes = new Integer((dtoOferta.getNumeroPaquetes() == null ? 1 : dtoOferta.getNumeroPaquetes().intValue() + 1));
           dtoOferta.setNumeroPaquetes(nPaquetes);
        } else {
           traza("la estrategia no es de tipo Compuesta fija vs grupo");
           conectorParametroSesion("grupo", Boolean.TRUE);
           conectorParametroSesion("paquete", Boolean.FALSE);
           conectorParametroSesion("condicionante", Boolean.FALSE);
           conectorParametroSesion("condicionado", Boolean.FALSE);
           nGrupos = new Integer((dtoOferta.getNumeroGrupos() == null ? 1 : dtoOferta.getNumeroGrupos().intValue() + 1));
           dtoOferta.setNumeroGrupos(nGrupos);

        }
        
        if ((new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO) {           
          traza("dtoOferta.getNumeroPaquetes()"+dtoOferta.getNumeroPaquetes());
          conectorParametroSesion("grupoActual", dtoOferta.getNumeroPaquetes());   
        } else {
          traza("dtoOferta.getNumeroGrupos()"+dtoOferta.getNumeroGrupos());
          conectorParametroSesion("grupoActual", dtoOferta.getNumeroGrupos());
        }
        traza("llendo a LPCrearGrupo");
        conectorParametroSesion("LPRegreso", "LPModificarOferta");
        conectorAction("LPCrearGrupo");
    }

    //Terminar de probar
    private void actualizarOferta() throws Exception {
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        dtoOferta.setMatrizFacturacionGenerada(Boolean.FALSE);
        dtoOferta.setCodigoVentaGenerado(Boolean.FALSE);
        if (dtoOferta.getGrupo()!=null){
          dtoOferta.setNumeroGrupos(new Integer(dtoOferta.getGrupo().size()));
        } else {
          dtoOferta.setModificacionGrupo(Boolean.FALSE);
        }
        conectorParametroSesion("DTOOferta",dtoOferta);
    }    
    
    //Terminar de probar
    private void cargarPantalla() throws Exception {
        traza("cargarPantalla------>");
        RecordSet rsFiltra = new RecordSet();
        DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        RecordSet argumentosVenta = (RecordSet) dtoCargarCriterioDefOferta.getArgumentosVenta();
        DruidaConector oCnn = new DruidaConector();
        oCnn = UtilidadesBelcorp.generarConector("DTOSalida.argumentosventa_ROWSET", argumentosVenta, argumentosVenta.getColumnIdentifiers());

        asignar("COMBO", "cbArgumentoVenta", oCnn,
                "DTOSalida.argumentosventa_ROWSET");


        RecordSet tipoCliente = (RecordSet) dtoCargarCriterioDefOferta.getTiposCliente();
        asignar("COMBO", "cbTipoCliente",
                UtilidadesBelcorp.generarConector("DTOSalida.tipocliente_ROWSET",
                                                  tipoCliente, tipoCliente.getColumnIdentifiers()),
                "DTOSalida.tipocliente_ROWSET");

        RecordSet estatus = (RecordSet) dtoCargarCriterioDefOferta.getEstatus();
        asignar("COMBO", "cbEstatusCliente",
                UtilidadesBelcorp.generarConector("DTOSalida.estatus_ROWSET", estatus,
                                                  estatus.getColumnIdentifiers()), "DTOSalida.estatus_ROWSET");

        //cargamos Datos de la oferta
        DTOOferta dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        asignarAtributo("VAR","oidOferta","valor",dtoOferta.getOidOferta().toString());
        if (dtoOferta.getMatrizFacturada()!=null && dtoOferta.getMatrizFacturada().booleanValue()==true)
            asignarAtributo("VAR","matrizFacturada","valor","1");
        else
            asignarAtributo("VAR","matrizFacturada","valor","0");

        RecordSet formaPago = (RecordSet) dtoCargarCriterioDefOferta.getFormasPago();
        asignar("COMBO", "cbFormasPago",
                UtilidadesBelcorp.generarConector("DTOSalida.formapago_ROWSET",
                                                  formaPago, formaPago.getColumnIdentifiers()),
                "DTOSalida.formapago_ROWSET");

        //BELC300020992
        conectorParametroSesion("oidCatalogo",dtoOferta.getOidCatalogo().toString());
        conectorParametroSesion("descripcionCatalogo",dtoOferta.getDescripcionCatalogo().toString());

        asignarAtributo("LABELC", "lblAccesoXX", "valor",
                        ((dtoOferta.getDescripcionAcceso() == null) ? ""
                         : dtoOferta.getDescripcionAcceso()));
        asignarAtributo("LABELC", "lblSubaccesoXX", "valor",
                        ((dtoOferta.getDescripcionSubacceso() == null) ? ""
                         : dtoOferta.getDescripcionSubacceso()));
        asignarAtributo("LABELC", "lbldtCatalogo", "valor",
                        ((dtoOferta.getDescripcionCatalogo() == null) ? ""
                         : dtoOferta.getDescripcionCatalogo()));
        asignarAtributo("LABELC", "lbldtEstrategia", "valor",
                        ((dtoOferta.getDescripcionEstrategia() == null) ? ""
                         : dtoOferta.getDescripcionEstrategia()));                         
        asignarAtributo("VAR", "hidOidArgVenta", "valor",
                        ((dtoOferta.getOidArgumentoVenta() == null) ? ""
                         : dtoOferta.getOidArgumentoVenta()
                           .toString()));

/*        asignarAtributo("CTEXTO", "txtNumeroOrden", "valor",
                        ((dtoOferta.getNumeroOrden() == null) ? ""
                         : UtilidadesBelcorp.formateaNumeroSICC(dtoOferta.getNumeroOrden()
                           .toString(),this.FORMATO_DEFAULT,this)));
se elimina por pedido de cambio PRE-003
*/
        //cargar cbIndicador de Cuadre
        RecordSet indicadorCuadre = (RecordSet) dtoCargarCriterioDefOferta.getIndicadoresCuadre();
        if (((dtoCargarCriterioDefOferta.getTipoEstrategia().getEstrategiaGrupo() != null) &&
                dtoCargarCriterioDefOferta.getTipoEstrategia().getEstrategiaGrupo().equals(new Boolean(true))) &&
                (((dtoCargarCriterioDefOferta.getEstrategia().getCuadreGrupos() != null) &&
                dtoCargarCriterioDefOferta.getEstrategia().getCuadreGrupos().equals(new Boolean(false)))||
                (dtoCargarCriterioDefOferta.getEstrategia().getCuadreGrupos()==null))) {
           traza("entro por indCuadre");
           asignarAtributo("VAR", "hidHabilitaIndicadorCuadre", "valor", "S");
         
          //inicio codigo copiado definir oferta
          //se recupera el valor del campo numero de grupos
           String snumGrupos = (conectorParametro("txtNumeroGrupos")!=null&&(!conectorParametro("txtNumeroGrupos").equals(""))) ?
                                  conectorParametro("txtNumeroGrupos") :
                                  ((dtoOferta.getNumeroGrupos() == null) ? "": dtoOferta.getNumeroGrupos().toString());
           int nroGrp = 0;
           traza("cambiaNumeroGrupos1___>" + snumGrupos);
           
            
           if ((snumGrupos != null) && (!snumGrupos.equals(""))) {
              nroGrp = (new Integer(snumGrupos)).intValue();

              if (nroGrp > 0) {
                 if (nroGrp == 1) {
                    
                    rsFiltra = RecordSet.clone(indicadorCuadre);
                    int cantRows = rsFiltra.getRowCount();
                    traza("cambiaNumeroGrupos1a");
                    for (int i = (cantRows - 1); i >= 0; i--) {
                       traza("clase:" +
                             rsFiltra.getValueAt(i, "IND_OFER_MONO_GRUP")
                             .getClass().getName());
                       if (((String) rsFiltra.getValueAt(i,
                                                         "IND_OFER_MONO_GRUP")).equals(new String("1"))) {
                       } else {
                          rsFiltra.removeRow(i);
                       }
                    }
                 } else {
                    traza("cambiaNumeroGrupos1b");

                    //RecordSet rsFiltra = new RecordSet();
                    rsFiltra = RecordSet.clone(indicadorCuadre);
                    int cantRows = rsFiltra.getRowCount();
                    for (int i = (cantRows - 1); i >= 0; i--) {
                       if (((String) rsFiltra.getValueAt(i,
                                                         "IND_OFER_MONO_GRUP")).equals(new String("0"))) {
                       } else {
                          rsFiltra.removeRow(i);
                       }
                    }
                    traza("cambiaNumeroGrupos1b1");
                 }
                 String oidcuad = null;
                 //se cambio nroGrp-1 por 0
                 if  ((dtoOferta!=null)&&
                      (dtoOferta.getGrupo()!=null)&&
                      (((DTOGrupo)dtoOferta.getGrupo().elementAt(0))!=null)&& 
                      (((DTOGrupo)dtoOferta.getGrupo().elementAt(0)).getOidIndicadorCuadre()!=null)){
                       traza("ind cuadre"+((DTOGrupo)dtoOferta.getGrupo().elementAt(0)).getOidIndicadorCuadre().toString());                     
                       oidcuad = ((DTOGrupo)dtoOferta.getGrupo().elementAt(0)).getOidIndicadorCuadre().toString();
                 }
                 if ((dtoOferta!=null)&&(dtoOferta.getOidIndCuadre() != null)){
                    oidcuad=dtoOferta.getOidIndCuadre().toString();
                 }
                 asignarAtributo("VAR", "hIndCuadre", "valor",(oidcuad!=null&&(!oidcuad.equals("")))? oidcuad : "");                 
              }
           } else {
              traza("el campo numero de grupos no tiene valor");
           }
        } else {
           //inhabilitar indicador de cuadre, hacerlo desde pantalla porque es un combo
           //si el valor del hidHabilitaIndicadorCuadre ="N"
           asignarAtributo("VAR", "hidHabilitaIndicadorCuadre", "valor", "N");
        }

        //esta linea es una prueba
        asignar("COMBO", "cbIndicadorCuadre", UtilidadesBelcorp.generarConector("DTOSalida.indicadorcuadre_ROWSET", rsFiltra, rsFiltra.getColumnIdentifiers()), "DTOSalida.indicadorcuadre_ROWSET");
        //la linea de arriba es un prueba

        traza("va a procesar promociones");
        //Promocion
        if ((dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 5) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 6) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 7)) {
           //if (dtoOferta.getPromocion() != null) {
              Vector vectorPromocion = (Vector) dtoOferta.getPromocion();
              //if (vectorPromocion.size() > 0) { BELC300014114
                  xml = new XMLDocument();
                  doc = xml.makeDocument("<DIV/>");
                  Element listado0 = armarLista(vectorPromocion);
                  DruidaConector con0 = new DruidaConector();
                  con0.setXML(listado0);                  
                  asignar("REJILLA", "rejlistado3", con0);                  
                  traza("asigno la rejilla3"); 
                  asignarAtributo("VAR", "hNombreListas", "valor", nombreLista);
                  asignarAtributo("VAR", "nroPromociones", "valor", vectorPromocion!=null?String.valueOf(vectorPromocion.size()):"0");
                  DTOPromocion elemPromocionSesion = null;
                  traza("asigna vectorPromocion"); 
                  if(vectorPromocion!=null&&vectorPromocion.size()>0) {
                    elemPromocionSesion = (DTOPromocion) vectorPromocion.get(vectorPromocion.size() - 1);
                  }
                  traza("ultima condicion   " + (elemPromocionSesion==null||elemPromocionSesion.getNumeroCondicion() == null ? "" : elemPromocionSesion.getNumeroCondicion().toString()));
                  conectorParametroSesion("numeroCondicion", ((elemPromocionSesion==null||elemPromocionSesion.getNumeroCondicion() == null) ? "" : elemPromocionSesion.getNumeroCondicion().toString()));
             // } BELC300014114
           //}
          dtoOferta.setModificacionPromocion(Boolean.TRUE);
          dtoOferta.setModificacionRangoPromocion(Boolean.TRUE);           
        }else {
          dtoOferta.setModificacionPromocion(Boolean.FALSE);
          dtoOferta.setModificacionRangoPromocion(Boolean.FALSE);
        }

        traza("va a procesar grupos");
        //Grupo
        if ((dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 3) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 4) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 6) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 7)) {

           //if (dtoOferta.getGrupo() != null) {BELC300014114
              xml = new XMLDocument();
              doc = xml.makeDocument("<table/>");

              Element listadoG = armarListaGrupos(dtoOferta.getGrupo(), dtoOferta.getDetalleOferta(), dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue());
              DruidaConector conG = new DruidaConector();
              conG.setXML(listadoG);
              asignar("REJILLA", "rejlistado4", conG);
              asignarAtributo("VAR", "hNombreListas", "valor", nombreLista);
           //}BELC300014114
          dtoOferta.setModificacionGrupo(Boolean.TRUE); 
        } else {
          //no es oferta con grupos
          dtoOferta.setModificacionGrupo(Boolean.FALSE);          
        }
        traza("termino de procesar grupos");
        
        asignarAtributo("VAR", "varNombresListasDinamicas","valor", this.nombreLista);
        
        if (yLista==null){
            yLista = new Integer(TAMANOPAGINASINDINAMICA);
        }
        asignarAtributo("CAPA", "capaVentaExclusiva", "y", (String.valueOf(yLista)));

        yLista = new Integer(yLista.intValue() + 320);
        asignarAtributo("LISTAEDITABLE", "listado5", "y", (String.valueOf(yLista)));

        yLista = new Integer(yLista.intValue() + 273);
        asignarAtributo("BOTON", "Eliminar5", "y", (String.valueOf(yLista)));
      
        traza("cargando pantalla 2");

		Long oidMarca = dtoCargarCriterioDefOferta.getOidMarca();
		Long oidCanal = dtoCargarCriterioDefOferta.getOidCanal();

		this.cargarZonas(oidMarca, oidCanal);
		this.cargarRegiones(oidMarca, oidCanal);

		traza("cargando pantalla 2a");

        if ((dtoOferta.getVentaExclusiva() != null) &&
            (dtoOferta.getVentaExclusiva().size() > 0)) {
            cambiaVentaExclusiva(dtoOferta.getVentaExclusiva());
            dtoOferta.setModificacionVentaExclusiva(Boolean.TRUE); 
        } else {
          dtoOferta.setModificacionVentaExclusiva(Boolean.FALSE);          
        }
      
        //Datos Generales lista Producto Principal
        if (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 1 ||
            dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 2 ||
            dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 5){
              cargaProductosInicial(dtoOferta.getDetalleOferta(),dtoCargarCriterioDefOferta.getTiposOferta(),dtoCargarCriterioDefOferta.getCiclosVida());
        }
        //Datos Generales
        traza("cargando pantalla 3");
        
        asignarAtributo("CTEXTO", "txtNumeroGrupos", "valor",
                        ((dtoOferta.getNumeroGrupos() == null) ? ""
                         : dtoOferta.getNumeroGrupos()
                           .toString()));
                         
        asignarAtributo("VAR", "hidNroGrupos", "valor",
                        ((dtoOferta.getNumeroGrupos() == null) ? "" : dtoOferta.getNumeroGrupos().toString()));

        asignarAtributo("CTEXTO", "txtNumeroPaquetes", "valor",
                        ((dtoOferta.getNumeroPaquetes() == null) ? ""
                         : dtoOferta.getNumeroPaquetes()
                           .toString()));

        asignarAtributo("VAR", "hidNroPaquetes", "valor",
                        ((dtoOferta.getNumeroPaquetes() == null) ? ""
                         : dtoOferta.getNumeroPaquetes()
                           .toString()));
                        
        asignarAtributo("CTEXTO", "txtNumeroGruposCondicionantes", "valor",
                        ((dtoOferta.getNumeroGruposCondicionantes() == null) ? ""
                         : dtoOferta.getNumeroGruposCondicionantes()
                           .toString()));

        asignarAtributo("VAR", "hidNroCondicionantes", "valor",
                        ((dtoOferta.getNumeroGruposCondicionantes() == null) ? ""
                         : dtoOferta.getNumeroGruposCondicionantes()
                           .toString()));

        //valor condicionantes /condicionados si me viene "Y" "N" no hay problema... si viene uno validar antes de asignar
        asignarAtributo("VAR", "hidRDCondicionantes", "valor",
                        (dtoOferta.getCondicionCondicionantes()==null?"":(dtoOferta.getCondicionCondicionantes().equals("O")) ? "N" : "S"));
        asignarAtributo("VAR", "hidRDCondicionados", "valor",
                        (dtoOferta.getCondicionCondicionados()==null?"":(dtoOferta.getCondicionCondicionados().equals("O")) ? "N" : "S"));

        asignarAtributo("CTEXTO", "txtNumeroGruposCondicionados", "valor",
                        ((dtoOferta.getNumeroGruposCondicionados() == null) ? ""
                         : dtoOferta.getNumeroGruposCondicionados().toString()));

        asignarAtributo("VAR", "hidNroCondicionados", "valor",
                        ((dtoOferta.getNumeroGruposCondicionados() == null) ? ""
                         : dtoOferta.getNumeroGruposCondicionados().toString()));

        //asigno a un hidden para despues focalizar en el combo
        asignarAtributo("VAR", "hFormaPago", "valor",((dtoOferta.getOidFormaPago() == null) ? ""
                         :dtoOferta.getOidFormaPago().toString()));

          if(dtoOferta.getDespachoCompleto() == null){
               asignarAtributo("VAR", "hidCKDespachoCompleto", "valor","");
           }else{
               asignarAtributo("VAR", "hidCKDespachoCompleto", "valor", (( (dtoOferta.getDespachoCompleto().booleanValue())) ? "S" : "N"));			 
           }

          traza("antes de setear hidCKDespachoAutomatico  " + dtoOferta.getDespachoAutomatico() );
          if(dtoOferta.getDespachoAutomatico() == null){
              asignarAtributo("VAR", "hidCKDespachoAutomatico", "valor", "");
          }else{
            asignarAtributo("VAR", "hidCKDespachoAutomatico", "valor", (((dtoOferta.getDespachoAutomatico().booleanValue())) ? "S" : "N"));
          }

          if(dtoOferta.getRecuperacionObligatoria() == null){
              asignarAtributo("VAR", "hidCKRecuperacionObligatoria", "valor", "");
          }else{
            asignarAtributo("VAR", "hidCKRecuperacionObligatoria", "valor", (((dtoOferta.getRecuperacionObligatoria().booleanValue())) ? "S" : "N"));
          }          

        asignarAtributo("VAR", "hidNroPromo", "valor",
                        ((dtoOferta.getPromocion() == null) ? ""
                         : (new Integer(dtoOferta.getPromocion().size())).toString() ));                      

        asignarAtributo("VAR", "maxGrupo", "valor", ((dtoCargarCriterioDefOferta.getEstrategia().getMaxGrupos() == null) ? "" : dtoCargarCriterioDefOferta.getEstrategia().getMaxGrupos().toString()));
        asignarAtributo("VAR", "maxGruposCondicionantes", "valor", ((dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionantes() == null) ? "" : dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionantes().toString()));
        asignarAtributo("VAR", "maxGruposCondicionados", "valor", ((dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionados() == null) ? "" : dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionados().toString()));
        asignarAtributo("VAR", "oidOferta", "valor", (dtoOferta.getOidOferta() == null) ? "" : dtoOferta.getOidOferta().toString());
        traza("cargando pantalla fin");
    }
    //Terminar de probar
    private void configurarPantalla() throws Exception {
        dtoCargarCriterioDefOferta = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");

        /* ******Grupos Condicionantes y Condicionados**************  */
        /* ******Para las esrtategias de tipo Condicionada**********  */
        //habilito si la estrategia es de tipo condicionada
        if ((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
            (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia()
                         .getCodigoTipoEstrategia()).intValue() == ConstantesPRE.CONDICIONADA)) {
           asignarAtributo("VAR", "hidECondicionada", "valor", "S");
        } else {
           asignarAtributo("VAR", "hidECondicionada", "valor", "N");
        }

        /* ******Para las esrtategias de tipo Vs**************  */
        if (((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
             (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue() == ConstantesPRE.INDIVIDUAL_VS_GRUPO)) ||
            ((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
             (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO)) ||
            ((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
             (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue() == ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO))) {
           asignarAtributo("VAR", "hidEstrategiaVS", "valor", "S");
        } else {
           asignarAtributo("VAR", "hidEstrategiaVS", "valor", "N");
        }

        /*  *********************Despacho Automatico*********************   */
        if ((dtoCargarCriterioDefOferta.getEstrategia()
                .getModificableDespachoAutomatico() != null) && (dtoCargarCriterioDefOferta.getEstrategia()
                .getModificableDespachoAutomatico()
                .booleanValue())) {
           //habilitar Despacho Automatico
           //por defecto tomara el valor definido por la estrategia
           asignarAtributo("VAR", "hidHabiDesAutomatico", "valor", "S");
           traza("entro por habilita despacho automatico");

        } else {
           traza("entro por deshabilita despacho automatico");
           asignarAtributo("VAR", "hidHabiDesAutomatico", "valor", "N");
        }
         if (dtoCargarCriterioDefOferta.getEstrategia().getCvDespachoAutomatico()
                 .booleanValue()) {
            asignarAtributo("CHECKBOX", "ckDespachoAutomatico", "check", "S");
            //asignarAtributo("CHECKBOX", "ckDespachoCompleto", "check", "S");
         } else {
            asignarAtributo("CHECKBOX", "ckDespachoAutomatico", "check", "N");
            //asignarAtributo("CHECKBOX", "ckDespachoCompleto", "check", "N");
         }
        /*  *********************Despacho Completo*********************   */
        if ((dtoCargarCriterioDefOferta.getEstrategia()
                .getModificableDespachoAutomatico() != null) && (dtoCargarCriterioDefOferta.getEstrategia()
                .getModificableDespachoAutomatico()
                .booleanValue())) {        
              if (((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
                   (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue() == ConstantesPRE.COMPUESTA_FIJA)) ||
                  ((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia() != null) &&
                   (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO))) {
                 //habilitar campo DespachoCompleto hidCKDespachoCompleto=="S"
                 traza("entro por habilita despacho completo");
                 asignarAtributo("VAR", "hidHabiDesCompleto", "valor", "S");
              } else {
                 //inhabilitar campo DespachoCompleto ckDespachoCompleto hidCKDespachoCompleto=="N"
                 traza("entro por deshabilita despacho completo");
                 asignarAtributo("VAR", "hidHabiDesCompleto", "valor", "N");
              }
        } else {
          //inhabilitar campo DespachoCompleto ckDespachoCompleto hidCKDespachoCompleto=="N"
           traza("entro por deshabilita despacho completo2");
           asignarAtributo("VAR", "hidHabiDesCompleto", "valor", "N");
        }

        /*   ****************Boton Buscar Producto Asociado****************  */
        /*   ********habilita si la estrategia es de tipo compuesta fija o individual vs grupo******** */
        traza("antes de validar el tipo de estrategia para inhabilitar los botones");

        if( ((dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()!=null)&&
              (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue()==ConstantesPRE.COMPUESTA_FIJA) ) 
              || (new Integer(dtoCargarCriterioDefOferta.getTipoEstrategia().getCodigoTipoEstrategia()).intValue()==ConstantesPRE.INDIVIDUAL_VS_GRUPO)){
             //habilitar boton  
             traza("habilita el boton");
             asignarAtributo("VAR","btnBPAsoc","valor", "true");
             
             // Agregado por ssantana, 6/10/2005, GCC-PRE-001
             asignarAtributo("VAR","btnMPAsoc","valor", "true"); 
             // Fin agregado por ssantana, 6/10/2005, GCC-PRE-001
        }else{
              //inhabilitar boton    
             traza("inhabilita el boton");
             asignarAtributo("VAR","btnBPAsoc","valor", "false");
             
             // Agregado por ssantana, 6/10/2005, GCC-PRE-001
             asignarAtributo("VAR","btnMPAsoc","valor", "false"); 
             // Fin agregado por ssantana, 6/10/2005, GCC-PRE-001
        }
    }
    //Terminar de probar
    private void eliminarOferta() throws Exception {
        traza("metodo eliminarOferta()");
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        dtoOID = new DTOOID();
        dtoOID.setOid(dtoOferta.getOidOferta());
        id = new MareBusinessID("PREEliminarOferta");
        paramEntrada = new Vector();
        paramEntrada.add(dtoOID);
        paramEntrada.add(id);
        conectar("ConectorEliminarOferta", paramEntrada);

        //Reinicio el caso de uso
        conectorAction("LPModificarOferta");
        conectorActionParametro("accion", "");
    }
    //Terminar de probar
    private void modificarGrupo() throws Exception {
        //Simplemente tiene que llamar a ModificarGrupo con el oid del grupo
        traza("metodo modificarGrupo()");
        nroGrupo = ((conectorParametro("hidNroGrupo") == null) || conectorParametro("hidNroGrupo").equals("")) ? null : Integer.valueOf(conectorParametro("hidNroGrupo"));
        conectorAction("LPModificarGrupo");
        conectorParametroSesion("UltimaLP", "LPModificarOferta");
        conectorParametroSesion("grupoActual", ((nroGrupo == null) ? null : nroGrupo));
        conectorActionParametro("accion", "");
        conectorActionParametro("hidNroGrupo", ((nroGrupo == null) ? "" : nroGrupo.toString()));
    }

    // Agregado por SICC20070316 - Rafael Romero - 18/07/2007
    private void consultarGrupo() throws Exception {
        //Simplemente tiene que llamar a ModificarGrupo con el oid del grupo
        traza("metodo consultarGrupo()");
        nroGrupo = ((conectorParametro("hidNroGrupo") == null) || conectorParametro("hidNroGrupo").equals("")) ? null : Integer.valueOf(conectorParametro("hidNroGrupo"));
        conectorAction("LPModificarGrupo");
        conectorParametroSesion("UltimaLP", "LPModificarOferta");
        conectorParametroSesion("grupoActual", ((nroGrupo == null) ? null : nroGrupo));
        conectorActionParametro("accion", "");
        conectorActionParametro("casoDeUso", "consultar");
        conectorActionParametro("hidNroGrupo", ((nroGrupo == null) ? "" : nroGrupo.toString()));
    }
    // fin agrgado SICC20070316

    
    //Terminar de probar
    private void eliminarGrupo() throws Exception {
        traza("metodo eliminarGrupo()");
        nroGrupo = ((conectorParametro("hidNroGrupo") == null) || conectorParametro("hidNroGrupo").equals("")) ? null : Integer.valueOf(conectorParametro("hidNroGrupo"));
        traza("mi grupo: " + nroGrupo);
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");

        Vector vectorGrupo = (Vector) dtoOferta.getGrupo();
        Enumeration eGrupo = vectorGrupo.elements();
        int i = 0;
        while (eGrupo.hasMoreElements()) {
           traza("entro al while ----------");
           dtoGrupo = (DTOGrupo) eGrupo.nextElement();
           traza(" dtoGrupo   " + (dtoGrupo.getNumeroGrupo() == null ? "" : dtoGrupo.getNumeroGrupo().toString()));

           if (dtoGrupo.getNumeroGrupo().equals(nroGrupo)) {
              //eliminar del vector el grupo
              if (dtoGrupo.getCondicionado()!=null&&dtoGrupo.getCondicionado().booleanValue()){
                dtoOferta.setNumeroGruposCondicionados(new Integer(dtoOferta.getNumeroGruposCondicionados().intValue()-1));
              } else if (dtoGrupo.getCondicionante()!=null&&dtoGrupo.getCondicionante().booleanValue()){
                dtoOferta.setNumeroGruposCondicionantes(new Integer(dtoOferta.getNumeroGruposCondicionantes().intValue()-1));              
              }
              // Agregado por ssantana, 6/10/2005, SICC-GCC-PRE-001
              dtoGrupo.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
              // Fin Agregado por ssantana, 6/10/2005, SICC-GCC-PRE-001
              
              traza("entro al IF --------");
              dtoOferta.setGrupo(vectorGrupo);
            
              break;
           }
           i++;
        }
        //Borrando detalles del grupo seleccionado
        Vector vecDetalleOferta = dtoOferta.getDetalleOferta();
        Enumeration detal = vecDetalleOferta.elements();
        while (detal.hasMoreElements()){
            DTODetalleOferta dtoDetalle = (DTODetalleOferta)detal.nextElement();
            if (dtoDetalle.getNumeroGrupo().intValue()== nroGrupo.intValue()){
                vecDetalleOferta.remove(dtoDetalle);
            }
        }
        dtoOferta.setDetalleOferta(vecDetalleOferta);
        dtoOferta.setNumeroGrupos(new Integer(dtoOferta.getGrupo().size()));
        // Agregado by ssantana,  6/10/2005, GCC-PRE-001
        dtoOferta.setModificacionGrupo(Boolean.TRUE);
        // Fin Agregado by ssantana,  6/10/2005, GCC-PRE-001
        
        conectorParametroSesion("DTOOferta", dtoOferta);
    }

    private void anadirCondicion() throws Exception {
        traza("metodo anadirCondicion()");
        conectorParametroSesion("UltimaLP", "LPModificarOferta");
        conectorAction("LPDefinirCondicionOferta");
        conectorActionParametro("accion", "");
    }

   private void modificarCondicion() throws Exception {
      traza("metodo modificarCondicion()");
      //Simplemente tiene que llamar a ModificarCondicionOferta con el oid de
      //la condicion
      String numeroCondicionStr = conectorParametro("hidNroCondicion");
      Integer numeroCondicion = (numeroCondicionStr == "" ? null : Integer.valueOf(numeroCondicionStr));
      traza("antes de bajar dtooferta");
      DTOOferta dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
      vectorPromocion = dtoOferta.getPromocion();
      Enumeration ePromocion2 = vectorPromocion.elements();
      while (ePromocion2.hasMoreElements()) {
         traza("dentro while");
         dtoPromocion = (DTOPromocion) ePromocion2.nextElement();
         //numeroCondicion deberia venir de pantalla
         if (dtoPromocion.getNumeroCondicion().equals(numeroCondicion)) {
            traza("dentro del if dtoPromocion.getNumeroCondicion().equals(  ");
            String sTipoOperacion = dtoPromocion.getTipoOperacion();
            if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(sTipoOperacion)) { 
                traza("Lo muestra - ssantana");
                traza("dtoPromocion" + dtoPromocion);
                conectorParametroSesion("dtoPromocion", dtoPromocion);
                break;                
            }
         }
      }
      conectorParametroSesion("UltimaLP", "LPModificarOferta");
      conectorAction("LPModificarCondicion");
   }

   private void eliminarCondicion() throws Exception {
      traza("metodo eliminarCondicion()");
      //Este metodo tiene que recibir el oid de la promocion a eliminar
      //y sacar del vector promocion de DTOOferta el dto que tenga ese oid,
      //y luego repintar la pantalla
      oidPromocion = ((conectorParametro("hOidCondicion") == null) ||
                      conectorParametro("hOidCondicion").equals("")) ? null
                     : Long.valueOf(conectorParametro("hOidCondicion"));
      traza("Se quiere eliminar la condicion " + oidPromocion);
      dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");

      vectorPromocion = (Vector) dtoOferta.getPromocion();
      Enumeration ePromocion = vectorPromocion.elements();

      int i = 0;

      while (ePromocion.hasMoreElements()) {
         dtoPromocion = (DTOPromocion) ePromocion.nextElement();
         
         traza("comparando con numero de condicion: " + dtoPromocion.getNumeroCondicion());
         if (dtoPromocion.getNumeroCondicion().intValue()==oidPromocion.intValue()) {
            //eliminar del vector el Promocion
            //vectorPromocion.remove(dtoPromocion);
            
            // Agregado por ssantana, 6/10/2005, GCC-PRE-001
            dtoPromocion.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
            
            Vector vLineasPromocion = dtoPromocion.getLineaPromocion();
            int cantElementosLineaPromocion = vLineasPromocion.size();
            for ( int j = 0; j < cantElementosLineaPromocion; j++) {
               DTOLineaPromocion dtoLineaPromo = (DTOLineaPromocion) 
                                                        vLineasPromocion.get(j);
               dtoLineaPromo.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
            }
            // Fin agregado por ssantana, 6/10/2005, GCC-PRE-001
            
            traza("Se elimino la Promocion "+dtoPromocion.getOidPromocion());
            break;
         }
         i++;
      }
      dtoOferta.setPromocion(vectorPromocion);
      // Agregado por ssantana, 6/10/2005, GCC-PRE-001
      dtoOferta.setModificacionPromocion(Boolean.TRUE);
      // Fin agregado por ssantana, 6/10/2005, GCC-PRE-001
      
      
      conectorParametroSesion("DTOOferta", dtoOferta);
   }

   private void condicionModificada() throws Exception {
      traza("LPModificarOferta.condicionModificada()");
      DTOPromocion dtoPromocionSesion = (DTOPromocion) conectorParametroSesion("dtoPromocion");
      Integer numeroCondicion2 = dtoPromocionSesion.getNumeroCondicion();

      dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");

      vectorPromocion = (Vector) dtoOferta.getPromocion();

      Enumeration ePromocion2 = vectorPromocion.elements();
      int i = 0;
      while (ePromocion2.hasMoreElements()) {
         dtoPromocion = (DTOPromocion) ePromocion2.nextElement();
         //numeroCondicion deberia venir de pantalla
         
         if (dtoPromocion.getNumeroCondicion().equals(numeroCondicion2)) {
            String sTipoOperacion = dtoPromocion.getTipoOperacion();
            traza("sTipoOperacion: " + sTipoOperacion);
            if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(sTipoOperacion)) {
              traza("Lo muestra");
              vectorPromocion.setElementAt(dtoPromocionSesion, i);
              break;
            }
         }
         i++;
      }
   }

	private ArrayList obtenerRegiones(String oidsRegiones) throws Exception {
		StringTokenizer oidsRegionesTk = new StringTokenizer(oidsRegiones,"|");
		ArrayList regiones = new ArrayList();
    
		while (oidsRegionesTk.hasMoreTokens()) {
			Long oidRegion = new Long(oidsRegionesTk.nextToken());
			regiones.add(oidRegion);
		}
		return regiones;
	}

	private ArrayList obtenerZonas(String oids, boolean Zona) throws Exception {
		StringTokenizer oidsZonasTk = new StringTokenizer(oids,"|");
		ArrayList zonas = new ArrayList();
		ArrayList regiones = new ArrayList();
		StringTokenizer oidsZonasSinRegionTk;
		while (oidsZonasTk.hasMoreTokens()) {
			oidsZonasSinRegionTk = new StringTokenizer(oidsZonasTk.nextToken(),"x");
			Long oidZona = new Long(oidsZonasSinRegionTk.nextToken());
			Long oidRegion = new Long(oidsZonasSinRegionTk.nextToken());
			zonas.add(oidZona);
			regiones.add(oidRegion);
		}
		if(Zona){
			return zonas;
		}else{
			return regiones;
		}
	}

	private HashMap obtenerDescZonas() throws Exception {

		HashMap res = new HashMap();
		String zonasS = conectorParametro("arrZonas");
		StringTokenizer zonasT = new StringTokenizer(zonasS,"|");

		while (zonasT.hasMoreTokens()) {
			StringTokenizer unaZona = new StringTokenizer(zonasT.nextToken(),"&");
			Long oidZona = new Long(unaZona.nextToken());//oidZona
			String desZona = new String(unaZona.nextToken());//desZona
			String oidRegion = new String(unaZona.nextToken());//oidRegion
			res.put(oidZona, desZona);
		}
		
		return res;

	}

	private HashMap obtenerDescRegiones() throws Exception {

		HashMap res = new HashMap();
		String regS = conectorParametro("arrRegiones");
		StringTokenizer regT = new StringTokenizer(regS,"|");

		while (regT.hasMoreTokens()) {
			traza("metodo obtenerDescRegiones():A");
			StringTokenizer unaReg = new StringTokenizer(regT.nextToken(),"&");
			traza("metodo obtenerDescRegiones():A"+unaReg.toString());
			Long oidRegion = new Long(unaReg.nextToken());//oidRegion
			String desRegion = new String(unaReg.nextToken());//desRegion
			res.put(oidRegion, desRegion);
		}
		
		return res;

	}

    private void anadirVentaExclusiva() throws Exception {
        traza("metodo anadirVentaExclusiva()");

		ArrayList arrVETemp = new ArrayList();
		ArrayList oidsReg = null;
		ArrayList oidsZon = null;

		if(zona.trim().equals("")&&region.trim().equals("")){

			oidsReg = new ArrayList();
			oidsReg.add("");
			traza("metodo anadirVentaExclusiva():caso anteior.");

		} else if(zona.trim().equals("")){

			 oidsReg = this.obtenerRegiones(region);
			 traza("metodo anadirVentaExclusiva():zonas vacio.:"+oidsReg);

		} else if(region.trim().equals("")){
			
			oidsReg = this.obtenerZonas(zona,false);
			oidsZon = this.obtenerZonas(zona,true);
			traza("metodo anadirVentaExclusiva():zonasR.:"+oidsReg);
			traza("metodo anadirVentaExclusiva():zonasZ.:"+oidsZon);

		} 

		HashMap desZonas = obtenerDescZonas();
		HashMap desRegs = obtenerDescRegiones();


		for (int i=0; i<oidsReg.size(); i++) {
			traza("metodo anadirVentaExclusiva():A");
			DTOVentaExclusiva dtoV = new DTOVentaExclusiva();
			dtoV.setOidClasificacion(oidClasificacion);
			dtoV.setDescripcionClasificacion(desClasificacion);
			dtoV.setOidTipoClasificacion(oidTipoClasificacion);
			dtoV.setDescripcionTipoClasificacion(desTipoClasificacion);
			dtoV.setOidTipoCliente(oidTipoCliente);
			dtoV.setDescripcionTipoCliente(desTipoCliente);
			dtoV.setOidSubtipoCliente(oidSubtipoCliente);
			dtoV.setDescripcionSubtipoCliente(desSubtipoCliente);
			dtoV.setOidEstatus(oidEstatus);
			dtoV.setDescripcionEstatus(desEstatus);
			dtoV.setEstatus2(estatus2);		
			traza("metodo anadirVentaExclusiva():B");
			if (oidsReg != null && !oidsReg.get(i).equals("")) {
			dtoV.setOidRegion((Long)oidsReg.get(i));
			traza("metodo anadirVentaExclusiva():C");
			String desReg = (String)desRegs.get(dtoV.getOidRegion());
			dtoV.setDescripcionRegion(desReg);
			}
			traza("metodo anadirVentaExclusiva():D");
			if (oidsZon != null) {
				dtoV.setOidZona((Long)oidsZon.get(i));
				String desZona = (String)desZonas.get(dtoV.getOidZona());
				dtoV.setDescripcionZona(desZona);
			}
		
			traza("FOR:REG:"+dtoV.getOidRegion());
			traza("FOR:DESREG:"+dtoV.getDescripcionRegion());
			traza("FOR:ZON:"+dtoV.getOidZona());
			traza("FOR:DESZON:"+dtoV.getDescripcionZona());
			traza("FOR:I:"+i);
			// Agregado por ssantana, 6/10/2005, cambio GCC-PRE-001
			dtoV.setTipoOperacion(ConstantesPRE.OPERACION_ALTA);
			// Fin agregado por ssantana, 6/10/2005, cambio GCC-PRE-001
			arrVETemp.add(dtoV);
		}




        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
		ArrayList noIncluir = new ArrayList();
		Long maxOid = new Long(0);

        if (dto.getVentaExclusiva() == null) {
           dto.setVentaExvlusiva(new Vector());  
		   maxOid = new Long(1);
        } else {
           Vector v = dto.getVentaExclusiva();

           Enumeration enVec = v.elements();           

           while (enVec.hasMoreElements()) {
                DTOVentaExclusiva dtoAux = (DTOVentaExclusiva) enVec.nextElement();
                traza("DTOVentaExclusiva a usar de comparacion: " + dtoAux);
                
                String sTipoOperacion = dtoAux.getTipoOperacion();
                traza("sTipoOperacion: " + sTipoOperacion);

				for (int i=0; i<arrVETemp.size(); i++) {
					DTOVentaExclusiva dtoV = (DTOVentaExclusiva)arrVETemp.get(i);

					if ((!ConstantesPRE.OPERACION_BAJA.equals(dtoAux.getTipoOperacion())) && 
						( (dtoAux.getOidClasificacion() != null && 
							 dtoAux.getOidClasificacion().equals(dtoV.getOidClasificacion())) ||
						  (dtoAux.getOidClasificacion() == null && dtoV.getOidClasificacion() == null))
						 &&
						( (dtoAux.getOidTipoClasificacion() != null &&
							 dtoAux.getOidTipoClasificacion().equals(dtoV.getOidTipoClasificacion())) ||
						  (dtoAux.getOidTipoClasificacion() == null && 
							 dtoV.getOidTipoClasificacion() == null))
						&&
						( (dtoAux.getOidClasificacion() != null && 
							 dtoAux.getOidClasificacion().equals(dtoV.getOidClasificacion())) || 
						  (dtoAux.getOidClasificacion() == null && dtoV.getOidClasificacion() == null)) 
						&&
						( (dtoAux.getOidTipoCliente() != null &&
							 dtoAux.getOidTipoCliente().equals(dtoV.getOidTipoCliente())) ||
						  (dtoAux.getOidTipoCliente() == null && dtoV.getOidTipoCliente() == null))
						&& 
						( (dtoAux.getOidSubtipoCliente() != null && 
							 dtoAux.getOidSubtipoCliente().equals(dtoV.getOidSubtipoCliente())) || 
						  (dtoAux.getOidSubtipoCliente() == null && dtoV.getOidSubtipoCliente() == null))
						&&
						( (dtoAux.getOidEstatus() != null && 
							 dtoAux.getOidEstatus().equals(dtoV.getOidEstatus())) || 
						  (dtoAux.getOidEstatus() == null && dtoV.getOidEstatus() == null))
						&&
						( (dtoAux.getOidRegion() != null && 
							 dtoAux.getOidRegion().equals(dtoV.getOidRegion())) || 
						  (dtoAux.getOidRegion() == null && dtoV.getOidRegion() == null))
						&&
						( (dtoAux.getOidZona() != null && 
							 dtoAux.getOidZona().equals(dtoV.getOidZona())) || 
						  (dtoAux.getOidZona() == null && dtoV.getOidZona() == null))) {
						algunoExiste = true;
						noIncluir.add(new Integer(i));
					}
				}

                if ((dtoAux.getOidVentaExclusiva() != null) &&
                    (maxOid.longValue() < dtoAux.getOidVentaExclusiva().longValue())) {
                   maxOid = dtoAux.getOidVentaExclusiva();
                }
           }
           maxOid = new Long(maxOid.longValue() + 1);           
        }



		for (int i=0; i<arrVETemp.size(); i++) {
			DTOVentaExclusiva dtoV = (DTOVentaExclusiva)arrVETemp.get(i);
			if (!noIncluir.contains(new Integer(i))) {
				dtoV.setOidVentaExclusiva(maxOid);
				dto.getVentaExclusiva().add(dtoV);
				maxOid = new Long(maxOid.longValue() + 1);    
			}
		}        
        // Agregado por ssantana, 6/10/2005, cambio GCC-PRE-001
        dto.setModificacionVentaExclusiva(Boolean.TRUE);
        // Fin agregado por ssantana, 6/10/2005, cambio GCC-PRE-001

        conectorParametroSesion("DTOOferta", dto);
    }

    private void eliminarVentaExclusiva() throws Exception {
        traza("metodo eliminarVentaExclusiva()");
        
        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
        elementosSeleccionadosVentaExclusiva = conectorParametro("elemSelecc");
        Vector elem = parsearElementosListaVE(elementosSeleccionadosVentaExclusiva);
        traza("elem: " + elem);
        Enumeration enumA = elem.elements();
        while (enumA.hasMoreElements()) {
           Long oid = Long.valueOf(enumA.nextElement().toString());
           Enumeration enumV = dto.getVentaExclusiva().elements();
           traza("oid A Buscar: " + oid );
           while (enumV.hasMoreElements()) {
              DTOVentaExclusiva dtoV = (DTOVentaExclusiva) enumV.nextElement();
              Long oidDTOVtaExclusiva = dtoV.getOidVentaExclusiva();
              String sTipoOperacionVtaExclusiva = dtoV.getTipoOperacion();
              traza("Oid Actual: " + oidDTOVtaExclusiva);
              
              if (oidDTOVtaExclusiva.equals(oid) && 
                    (sTipoOperacionVtaExclusiva == null || 
                     !sTipoOperacionVtaExclusiva.equals("baja")) ) {
                 traza("A punto de dar de baja... solo 1 condicion mas");    
                 if (dto.getVentaExclusiva().contains(dtoV)) {
                    // Modificacion por ssantana, 6/10/2005, GCC-PRE-001
                    traza("Da de baja del DTOVentaExclusiva");
                    dtoV.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
                    //dto.getVentaExclusiva().remove(dtoV);
                    // fin Modificacion por ssantana, 6/10/2005, GCC-PRE-001
                 } else {
                    //  "No puedo encontrar la venta Exclusiva en el DTOOferta");
                 }
              }
           }
        }
        
        // Agregado por ssantana, 6/10/2005, GCC-PRE-001
        dto.setModificacionVentaExclusiva(Boolean.TRUE);
        // Fin Agregado por ssantana, 6/10/2005, GCC-PRE-001
        conectorParametroSesion("DTOOferta", dto);
    }
    
    //Terminar de probar
    private void eliminarProductos() throws Exception {
        traza("metodo eliminarProductos()");
        DTOOferta dto = (DTOOferta) conectorParametroSesion("DTOOferta");
        String elemDetalleOferta = conectorParametro("elemSelecc");
        traza("Productos a borrar: "+elemDetalleOferta);
        
        Vector elem = parsearElementosLista(elemDetalleOferta);
        Enumeration enumA = elem.elements();
        boolean flag = false;
        while (enumA.hasMoreElements()) {
           String oid = enumA.nextElement().toString();
           Enumeration enumV = dto.getDetalleOferta().elements();
           while (enumV.hasMoreElements()) {
              DTODetalleOferta dtoD = (DTODetalleOferta) enumV.nextElement();
              String sOid = null;
              //  Modificado por HRCS - Fecha 28/03/2007 - Incidencia Sicc20070106
              if (tieneP(oid) || flag){
                if (!flag)   {  //  Obtiene el oid sin el 'p' adelante
                    oid = oid.substring(1);
                    flag = true;
                }
				/*if ((dtoD.getOidSAP()!=null)){
	                sOid = dtoD.getOidSAP().toString();
				}*/
                if (dtoD.getSecuencial()!=null) {
                    sOid = dtoD.getSecuencial().toString();
                }
                else {
					sOid = new String("");//en este caso ya existia en BD
				}
              } else {
			    if ((dtoD.getOidDetalleOferta()!=null)){
					sOid = dtoD.getOidDetalleOferta().toString();
				} else {
					sOid = new String("");//en este viene de MAE PRODU pero lo que quiero borra es uno de la BD
				}
              }
              if ((sOid.equals(oid)) &&
                  (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoD.getTipoOperacion()))
				 ) {
                  traza("le dio de baja a:"+oid);
                  // Modificado por ssantana, 6/10/2005, GCC-PRE-001
                  dtoD.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
                  // Fin Modificado por ssantana, 6/10/2005, GCC-PRE-001                 
              }              
           }
        }
        conectorParametroSesion("DTOOferta", dto);
    }

    private void llenarRecordSetVentaExclusiva(RecordSet r) {
        r.addColumn("OID");
        r.addColumn("DES_TIPO_CLIE");
        r.addColumn("DES_SUB_TIPO_CLIE");
        r.addColumn("DES_TIPO_CLAS");
        r.addColumn("DES_CLAS");
        r.addColumn("ESTATUS1");
        r.addColumn("ESTATUS2");
        r.addColumn("REGION");
        r.addColumn("ZONA");
    }

    private void cambiaVentaExclusiva(Vector vec) throws Exception { //Asigna a la pantalla las ventas exclusivas
        traza("metodo cambiaVentaExclusiva()");
        RecordSet recordSet = new RecordSet();
        llenarRecordSetVentaExclusiva(recordSet);

        Enumeration enumA = vec.elements();
        //  recordSet.setRowCount(vec.size() - 1);

        int i = 0;

        while (enumA.hasMoreElements()) {
           

           DTOVentaExclusiva dto = (DTOVentaExclusiva) enumA.nextElement();
           if ( dto.getTipoOperacion() == null || 
                                        !dto.getTipoOperacion().equals("baja") ) {
              recordSet.addRow(new Vector());
              recordSet.setValueAt(dto.getOidVentaExclusiva(), i, 0);
              recordSet.setValueAt(dto.getDescripcionTipoCliente(), i, 1);
              recordSet.setValueAt(dto.getDescripcionSubtipoCliente(), i, 2);
              recordSet.setValueAt(dto.getDescripcionTipoClasificacion(), i, 3);
              recordSet.setValueAt(dto.getDescripcionClasificacion(), i, 4);
              recordSet.setValueAt(dto.getDescripcionEstatus(), i, 5);
              recordSet.setValueAt(dto.getEstatus2(), i, 6);
              recordSet.setValueAt(dto.getDescripcionRegion(), i, 7);
              recordSet.setValueAt(dto.getDescripcionZona(), i, 8);
              i++;
           }
        }

        asignar("LISTADOA", "listado5",UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                 recordSet.getColumnIdentifiers()), "dtoSalida");
    }

    private Vector parsearElementosLista(String lista) throws Exception {
        Vector vec = new Vector();
        if (lista==null){
            traza("No se Pudo parsear para eliminar");
            return vec;
        }          
        StringTokenizer st = new StringTokenizer(lista, "|");

        while (st.hasMoreElements()) {
           vec.addElement(st.nextToken());
        }

        return vec;
    }

    private Vector parsearElementosListaVE(String lista) throws Exception {
        Vector vec = new Vector();
        if (lista==null){
            traza("No se Pudo parsear para eliminar");
            return vec;
        }          
        StringTokenizer st = new StringTokenizer(lista, ",");

        while (st.hasMoreElements()) {
           vec.addElement(st.nextToken());
        }

        return vec;
    }

    private void buscarProducto(String tipo) throws Exception {
        traza(" metodo buscarProducto ");
	    conectorAction("LPBuscarProducto");
        DTOOferta dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");
        if (dtoOf.getOidAcceso()!=null)
            conectorParametroSesion("oidAcceso", dtoOf.getOidAcceso());
        if (dtoOf.getOidSubacceso()!=null)
            conectorParametroSesion("oidSubacceso", dtoOf.getOidSubacceso());
        conectorParametroSesion("volverLPBuscarProducto", "LPModificarOferta");
        if (tipo.equalsIgnoreCase("principal")){
            conectorParametroSesion("productoprincipal", new Boolean(true));
            traza("Se va a buscar productos principal");
            conectorActionParametro("multiseleccion", "false");
        }else if(tipo.equalsIgnoreCase("asociado")){
            conectorParametroSesion("productoprincipal", new Boolean(false));
            traza("Se va a buscar productos aociado");
            conectorActionParametro("multiseleccion", "true");
        }        
        //conectorActionParametro("multiseleccion", "true");
        conectorActionParametro("mostrarValoresAdicionales", "true");
    }
    //Terminar de probar
    private void cargaProductosInicial(Vector vec, RecordSet rs1, RecordSet rs2) throws Exception {
        traza("metodo cargaProductosInicial");
        RecordSet recordSet1 = new RecordSet();
        RecordSet recordSet2 = new RecordSet();

        llenarRecordSetProductos(recordSet1);
        llenarRecordSetProductos(recordSet2);
        Enumeration enumA = vec.elements();
        int i = 0;
        int x = 0;
        traza("metodo cargaProductosInicial2");
       while (enumA.hasMoreElements()) {
           DTODetalleOferta dto = (DTODetalleOferta) enumA.nextElement();
           traza("codigoSAP:"+dto.getCodigoSAP());
           traza("tipoOperacion:"+dto.getTipoOperacion());
           if ((dto.getProductoPrincipal()!=null)&&(dto.getProductoPrincipal().booleanValue())){
              if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dto.getTipoOperacion())){
                recordSet1.addRow(new Vector());
                
                // Modificado por ssantana, 12/10/2005, GCC-PRE-001
                traza("Branch 1");
                String valorASetear = "";
                if ( dto.getOidDetalleOferta() == null ) {
                  //    Modificado por HRCS - Fecha 28/03/2007 - Incidencia Sicc20070106
                  //valorASetear = "p" + dto.getOidSAP();
                  valorASetear = "p" + dto.getSecuencial().intValue();
                } else {
                  valorASetear = dto.getOidDetalleOferta().toString();
                }
                recordSet1.setValueAt(valorASetear, i, 0);
                // Fin Modificado por ssantana, 12/10/2005, GCC-PRE-001
                
                traza("metodo cargaProductosInicial3");
                 if (dto.getCodigoSAP() != null) {
                     recordSet1.setValueAt(dto.getCodigoSAP(), i, 1);
                 }else{recordSet1.setValueAt("", i, 1);}
  
                 if (dto.getDescripcion() != null) {
                    recordSet1.setValueAt(dto.getDescripcion(), i, 2);
                 }else{recordSet1.setValueAt("", i, 2);}
                traza("metodo cargaProductosInicial4");
                 RecordSet rsTipoOferta = (RecordSet)rs1;                
                 if (dto.getOidTipoOferta() != null && !rsTipoOferta.esVacio() ) {            
                    /* tipo oferta: obtengo la descripcion  */            
                    for(int j=0; j<rsTipoOferta.getRowCount(); j++){  
                        Long tipoOfert = rsTipoOferta.getValueAt(j,0)==null ? null : new Long(rsTipoOferta.getValueAt(j,0).toString());
                        if(tipoOfert.equals(dto.getOidTipoOferta()) ){
                            recordSet1.setValueAt(rsTipoOferta.getValueAt(j,1), i, 3);
                            break;
                        }
                    }
                 }else{recordSet1.setValueAt("", i, 3);}
                traza("metodo cargaProductosInicial5");
                /* ciclo de vida: obtengo la descripcion  */
                RecordSet rsCicloVida = (RecordSet)rs2;
                if (dto.getOidCicloVida() != null && !rsCicloVida.esVacio()) {
                    for(int j=0; j<rsCicloVida.getRowCount(); j++){  
                        Long cicloVi = rsCicloVida.getValueAt(j,0)==null ? null : new Long(rsCicloVida.getValueAt(j,0).toString());
                        if(cicloVi.equals(dto.getOidCicloVida()) ){
                            recordSet1.setValueAt(rsCicloVida.getValueAt(j,1), i, 4);
                            break;
                        }
                    }
                }else{
                    recordSet1.setValueAt("", i, 4);
                }
                traza("metodo cargaProductosInicial6");
                 if (dto.getFactorRepeticion() != null) {
                    recordSet1.setValueAt(dto.getFactorRepeticion(), i, 5);            
                 }else{recordSet1.setValueAt("", i, 5);}
  
                 if (dto.getPrecioCatalogo() != null) {
                    recordSet1.setValueAt(UtilidadesBelcorp.formateaNumeroSICC(dto.getPrecioCatalogo().toString(),this.FORMATO_DEFAULT,this), i, 6);
                 }else{recordSet1.setValueAt("", i, 6);}         
  
                 if (dto.getAtributo1() != null) {
                    recordSet1.setValueAt(dto.getAtributo1(), i, 7);
                 }else{recordSet1.setValueAt("", i, 7);}
  
                 if (dto.getAtributo2() != null) {
                    recordSet1.setValueAt(dto.getAtributo2(), i, 8);
                 }else{recordSet1.setValueAt("", i, 8);}
  
                 if (dto.getAtributo3() != null) {
                    recordSet1.setValueAt(dto.getAtributo3(), i, 9);
                 }else{recordSet1.setValueAt("", i, 9);}
                 i++;
              }
          }else{
            if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dto.getTipoOperacion())){
                 recordSet2.addRow(new Vector());
                 // Modificado por ssantana, 12/10/2005, GCC-PRE-001
                 traza("Branch 2");
                 String valorASetear = "";
                 if ( dto.getOidDetalleOferta() == null ) {
                   //    Modificado por HRCS - Fecha 28/03/2007 - Incidencia Sicc20070106
                   // valorASetear = "p" + dto.getOidSAP();
                   valorASetear = "p" + dto.getSecuencial().intValue();                   
                 } else {
                   valorASetear = dto.getOidDetalleOferta().toString();
                 }
                 recordSet2.setValueAt(valorASetear, x, 0);
                 // Fin Modificado por ssantana, 12/10/2005, GCC-PRE-001
                  
                 //recordSet2.setValueAt(dto.getOidSAP(), x, 0);
    
                 if (dto.getCodigoSAP() != null) {
                    recordSet2.setValueAt(dto.getCodigoSAP(), x, 1);
                 }else{recordSet2.setValueAt("", x, 1);}
    
                 if (dto.getDescripcion() != null) {
                    recordSet2.setValueAt(dto.getDescripcion(), x, 2);
                 }else{recordSet2.setValueAt("", x, 2);}
                  traza("metodo cargaProductosInicial7");
                 RecordSet rsTipoOferta = (RecordSet)rs1;                
                 if (dto.getOidTipoOferta() != null && !rsTipoOferta.esVacio() ) {            
                    /* tipo oferta: obtengo la descripcion  */            
                    for(int j=0; j<rsTipoOferta.getRowCount(); j++){  
                        Long tipoOfert = rsTipoOferta.getValueAt(j,0)==null ? null : new Long(rsTipoOferta.getValueAt(j,0).toString());
                        if(tipoOfert.equals(dto.getOidTipoOferta()) ){
                            recordSet2.setValueAt(rsTipoOferta.getValueAt(j,1), x, 3);
                            break;
                        }
                    }
                traza("metodo cargaProductosInicial7");
                 }else{recordSet2.setValueAt("", x, 3);}
    
                  /* ciclo de vida: obtengo la descripcion  */
                  RecordSet rsCicloVida = (RecordSet)rs2;
                  if (dto.getOidCicloVida() != null && !rsCicloVida.esVacio()) {
                      for(int j=0; j<rsCicloVida.getRowCount(); j++){  
                          Long cicloVi = rsCicloVida.getValueAt(j,0)==null ? null : new Long(rsCicloVida.getValueAt(j,0).toString());
                          if(cicloVi.equals(dto.getOidCicloVida()) ){
                              recordSet2.setValueAt(rsCicloVida.getValueAt(j,1), x, 4);
                              break;
                          }
                      }
                  }else{recordSet2.setValueAt("", x, 4);}
                  traza("metodo cargaProductosInicial8");
                  if (dto.getFactorRepeticion() != null) {
                      recordSet2.setValueAt(dto.getFactorRepeticion(), x, 5);            
                  }else{recordSet2.setValueAt("", x, 5);}
    
                   if (dto.getPrecioCatalogo() != null) {
                      recordSet2.setValueAt(UtilidadesBelcorp.formateaNumeroSICC(dto.getPrecioCatalogo().toString(),this.FORMATO_DEFAULT,this), x, 6);
                   }else{recordSet2.setValueAt("", x, 6);}         
    
                   if (dto.getAtributo1() != null) {
                      recordSet2.setValueAt(dto.getAtributo1(), x, 7);
                   }else{recordSet2.setValueAt("", x, 7);}
    
                   if (dto.getAtributo2() != null) {
                      recordSet2.setValueAt(dto.getAtributo2(), x, 8);
                   }else{recordSet2.setValueAt("", x, 8);}
    
                   if (dto.getAtributo3() != null) {
                      recordSet2.setValueAt(dto.getAtributo3(), x, 9);
                   }else{recordSet2.setValueAt("", x, 9);}
                   x++;
             }
          }
       }
       traza("metodo cargaProductosInicial9");
       asignar("LISTADOA", "listado1",
           UtilidadesBelcorp.generarConector("dtoSalida", recordSet1,
              recordSet1.getColumnIdentifiers()), "dtoSalida");
       asignar("LISTADOA", "listado2",
           UtilidadesBelcorp.generarConector("dtoSalida", recordSet2,
              recordSet2.getColumnIdentifiers()), "dtoSalida");
    }

    private void llenarRecordSetProductos(RecordSet r) {
        r.addColumn("OID");
        r.addColumn("COD_SAP");
        r.addColumn("DES_SAP");
        r.addColumn("COD_TIPO_OFER");
        r.addColumn("COD_CICL_VIDA");
        r.addColumn("VAL_FACT_REPE");
        r.addColumn("IMP_PREC_CATA");      
        r.addColumn("VAL_ATRI_1");
        r.addColumn("VAL_ATRI_2");
        r.addColumn("VAL_ATRI_3");
    }

    private void productoSeleccionado() throws Exception { //Inc. 1895 rechazada
        traza("Volvi de Buscar Producto");
        DTOOferta dtoO = (DTOOferta) conectorParametroSesion("DTOOferta");
        DTOSCargarCriteriosDefinirOferta dtoCCriterioDefOfer = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
      
        Hashtable htpOf = null;
        htpOf = (Hashtable) conectorParametroSesion("Productos");
        Enumeration enProd = htpOf.elements();

        //Borra los productos principales que estan para reemplazarlo
        if (conectorParametroSesion("productoprincipal")!=null&&((Boolean)conectorParametroSesion("productoprincipal")).booleanValue()){
            Enumeration el = dtoO.getDetalleOferta().elements();
            while(el.hasMoreElements()) { 
                DTODetalleOferta dtoPOf = (DTODetalleOferta) el.nextElement();
                if (dtoPOf.getProductoPrincipal().booleanValue()) {
                
                    // Modificacion por ssantana, 11/10/2005, cambio GCC-PRE-001
                    Long oidDetalleOferta = dtoPOf.getOidDetalleOferta();
                    if (oidDetalleOferta != null ) {
                      dtoPOf.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
                    } else {
                      String sTipoOperacion = dtoPOf.getTipoOperacion();
                      if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(sTipoOperacion)){ 
                        dtoPOf.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
                      }
                    }
                    // Fin Modificacion por ssantana, 11/10/2005, cambio GCC-PRE-001
                }
            }
        }
        
        Vector vec = dtoO.getDetalleOferta();
        while (enProd.hasMoreElements()) {
           DTOProducto dtoP = (DTOProducto) enProd.nextElement();
           
           //   Agregado por HRCS - Fecha 21/03/2007 - Incidencia Sicc 20070106
           int ultimoSec = dtoO.getUltimaSecuencia().intValue();
           dtoP.setSecuencial( new Integer(ultimoSec) );
           dtoO.setUltimaSecuencia( new Integer(ultimoSec + 1) );
           
           vec.add(armarDetalleOferta(dtoP));           
        }

        cargaProductosInicial(vec, dtoCCriterioDefOfer.getTiposOferta(), dtoCCriterioDefOfer.getCiclosVida()/*, false, "listado2"*/);
        conectorParametroSesion("DTOOferta", dtoO);
    }

    private DTODetalleOferta armarDetalleOferta(DTOProducto dto) {
        DTODetalleOferta dtoD = new DTODetalleOferta();
        dtoD.setAtributo1(dto.getAtributo1());
        dtoD.setAtributo2(dto.getAtributo2());
        dtoD.setAtributo3(dto.getAtributo3());
        dtoD.setCentro(dto.getCentro());
        dtoD.setCodigoSAP(dto.getCodigoSAP());
        dtoD.setDescripcion(dto.getTextoBreve());
        dtoD.setCosteEstandar(dto.getCosteEstandar());
        dtoD.setFactorRepeticion(dto.getFactorRepeticion());
        dtoD.setImpresionGP(dto.getImprimible());
        dtoD.setDigitable(dto.getDigitable());
        dtoD.setOidSAP(dto.getOid());
        dtoD.setOidCicloVida(dto.getOidCicloVida());
        dtoD.setOidCondicionPromocion(dto.getOidCondicionPromocion());
        dtoD.setOidCatalogo(dto.getOidCatalogo());
        dtoD.setOidTipoOferta(dto.getOidTipoOferta());
        dtoD.setPaginaCatalogo(dto.getPaginaCatalogo());
        dtoD.setPrecioCatalogo(dto.getPrecioCatalogo());
        dtoD.setPrecioPosicionamiento(dto.getPrecioPosicionamiento());
        dtoD.setUnidadesEstimadas(dto.getUnidadesEstimadas());
        //enozigli 25/10/2005 club priviledges
        dtoD.setProgramaFidelizacion(dto.getProgramaFidelizacion());
        dtoD.setVariantes(dto.getVariantes());
        dtoD.setPuntajeFijo(dto.getPuntajeFijo());
        //fin enozigli 25/10/2005 club priviledges
        dtoD.setOrigen(ConstantesPRE.MF);
        dtoD.setCentro(dto.getCentro());        
        //el tipo de operacion aqui siempre sera alta ya que fui a buscar y agrego.
        //en el caso de producto ppal antes doy la baja porque es uno solo.
        dtoD.setTipoOperacion(ConstantesPRE.OPERACION_ALTA);

		/*inicio enozigli COL-PRE-002*/
        dtoD.setRangosPrecios(dto.getRangosPrecios());
		/*fin enozigli COL-PRE-002*/

        dtoD.setVentaNetaEstimada(dto.getVentaNetaEstimada());
        Boolean esPrincipal = (Boolean)conectorParametroSesion("productoprincipal");
        if (esPrincipal!=null&&esPrincipal.booleanValue())
            dtoD.setProductoPrincipal(Boolean.TRUE);
        else
            dtoD.setProductoPrincipal(Boolean.FALSE);
            
        //   Agregado por HRCS - Fecha 21/03/2007 - Incidencia Sicc 20070106
        dtoD.setSecuencial( dto.getSecuencial() );
        
        return dtoD;
    }
    //Terminar de probar
    private Element armarLista(Vector vectorDtoPromo) throws Exception {
        traza("metodo armarLista()");

        Enumeration listas = null;
        if(vectorDtoPromo!=null) listas = vectorDtoPromo.elements();

        /*    *********Inicio Marta   es la capa Promocion ***************        */
        //Element tablaEngloba = doc.getDocumentElement();
        //Element divPromo = doc.getDocumentElement();
        traza("metodo armarLista()1");
        Element divPromo = doc.createElement("DIV");
        divPromo.setAttribute("width", "800 px");
        yLista = new Integer(TAMANOPAGINASINDINAMICA);
        Element capaPrincipal = doc.createElement("CAPA");
        capaPrincipal.setAttribute("nombre", "capaPromocion" + String.valueOf(indice));
        capaPrincipal.setAttribute("alto", "100%");
        capaPrincipal.setAttribute("ancho", "100%");
        capaPrincipal.setAttribute("colorf", "");
        capaPrincipal.setAttribute("borde", "0");
        capaPrincipal.setAttribute("imagenf", "");
        capaPrincipal.setAttribute("repeat", "");
        capaPrincipal.setAttribute("padding", "");
        capaPrincipal.setAttribute("visibilidad", "visible");
        capaPrincipal.setAttribute("contravsb", "");
        capaPrincipal.setAttribute("x", "0");
        capaPrincipal.setAttribute("y", yLista.toString());
        capaPrincipal.setAttribute("zindex", "");
        Element table = null;
        Element fieldset1 = null;
        Element tablaDentro = null;
        Element tablaAfuera = null;
        Element trTablaAfuera = null;
        Element tr = null;

        tablaAfuera = doc.createElement("table");
        tablaAfuera.setAttribute("width", "100%");
        tablaAfuera.setAttribute("border", "0");
        tablaAfuera.setAttribute("cellspacing", "0");
        tablaAfuera.setAttribute("cellpadding", "0");
        traza("metodo armarLista()2");

        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
        tr.getChildNodes().item(1).appendChild(getIMG(1, 1));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");
        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        tablaAfuera.appendChild(tr);


        trTablaAfuera = getTR(3);
        trTablaAfuera.getChildNodes().item(0).appendChild(getIMG(12, 12));
        fieldset1 = getFIELDSET();
        Element legenda1 = getLegend();
        fieldset1.appendChild(legenda1);
        divPromo.appendChild(capaPrincipal);
        int numeroPromocion = 1;
        traza("metodo armarLista()3");
        if (listas!=null) {
            while (listas.hasMoreElements()) {
               traza("dento del while");
               DTOPromocion elemPromocion = (DTOPromocion) listas.nextElement();
               elemPromocion.setNumeroCondicion(new Integer(numeroPromocion));
               numeroPromocion++;
               table = doc.createElement("table");
               table.setAttribute("width", "100%");
               table.setAttribute("border", "0");
               table.setAttribute("align", "center");
               table.setAttribute("cellspacing", "0");
               table.setAttribute("cellpadding", "0");
    
               tr = getTR(1);
               tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
               ((Element) tr.getChildNodes().item(0)).setAttribute("colspan", "4");
    
               table.appendChild(tr);
    
               Element trTable = getTR(3);
               trTable.getChildNodes().item(0).appendChild(getIMG(8, 8));
               ((Element) trTable.getChildNodes().item(1)).setAttribute("width", "100%");
    
               tablaDentro = doc.createElement("table");
               tablaDentro.setAttribute("width", "100%");
               tablaDentro.setAttribute("border", "0");
               tablaDentro.setAttribute("cellspacing", "0");
               tablaDentro.setAttribute("cellpadding", "0");
    
               Element trTablaDentro = getTR(1);
    
               Element fieldset2 = getFIELDSET();
    
               Element tableDentroD = doc.createElement("table");
               tableDentroD.setAttribute("width", "100%");
               tableDentroD.setAttribute("border", "0");
               tableDentroD.setAttribute("align", "center");
               tableDentroD.setAttribute("cellspacing", "0");
               tableDentroD.setAttribute("cellpadding", "0");
    
               tr = getTR(1);
               tr.getChildNodes().item(0).appendChild(getIMG(8, 8));
               ((Element) tr.getChildNodes().item(0)).setAttribute("colspan", "3");
               tableDentroD.appendChild(tr);
    
               tr = getTR(8);
               tr.getChildNodes().item(0).appendChild(getIMG(8, 8));
               tr.getChildNodes().item(1).appendChild(getLABELC("lblNumeroCondicion12" + String.valueOf(indice).toString(), "110", "17", "1", "", "datosTitle", "004"));
               tr.getChildNodes().item(2).appendChild(getIMG(25, 8));
               tr.getChildNodes().item(3).appendChild(getLABELC("lblIndicadorCuadre12" + String.valueOf(indice).toString(), "110", "17", "1", "", "datosTitle", "005"));
               tr.getChildNodes().item(4).appendChild(getIMG(25, 8));
               tr.getChildNodes().item(5).appendChild(getLABELC("lblFactorCuadre12" + String.valueOf(indice).toString(), "130", "17", "1", "", "datosTitle", "006"));
               tr.getChildNodes().item(6).appendChild(getIMG(236, 8));
               ((Element) tr.getChildNodes().item(6)).setAttribute("width", "88");
               tr.getChildNodes().item(7).appendChild(getIMG(8, 8));
               ((Element) tr.getChildNodes().item(7)).setAttribute("width", "100%");
               tableDentroD.appendChild(tr);
    
               tr = getTR(8);
               tr.getChildNodes().item(0).appendChild(getIMG(8, 8));
               tr.getChildNodes().item(1).appendChild(getLABEL("lblNumeroCondicionXX2" + String.valueOf(indice).toString(), "60", "17", "1", "" + elemPromocion.getNumeroCondicion().toString(), "datosCampos"));
               tr.getChildNodes().item(2).appendChild(getIMG(25, 8));
               tr.getChildNodes().item(3).appendChild(getLABEL("lblIndicadorCuadreXX2" + String.valueOf(indice).toString(), "", "17", "1", "" + elemPromocion.getDescripcionIndicadorCuadre(), "datosCampos"));
               tr.getChildNodes().item(4).appendChild(getIMG(25, 8));
               tr.getChildNodes().item(5).appendChild(getLABEL("lblFactorCuadreXX2" + String.valueOf(indice).toString(), "130", "17", "1", "" + elemPromocion.getFactorCuadre().toString(), "datosCampos"));
			   //cambio el tipo de dato de Factor de Cuadre a Float y hay que recompilar por inc. 24193
               tr.getChildNodes().item(6).appendChild(getIMG(8, 8));
               ((Element) tr.getChildNodes().item(6)).setAttribute("width", "1");
               tr.getChildNodes().item(7).appendChild(getIMG(8, 8));
               ((Element) tr.getChildNodes().item(7)).setAttribute("width", "100%");
               tableDentroD.appendChild(tr);
    
               tr = getTR(1);
               tr.getChildNodes().item(0).appendChild(getIMG(8, 310));
               ((Element) tr.getChildNodes().item(0)).setAttribute("colspan", "4");
               tableDentroD.appendChild(tr);
    
               fieldset2.appendChild(tableDentroD);
               //tablaDentro tiene un solo tr, y dentro del tr esta el filedset
    
               trTablaDentro.getChildNodes().item(0).appendChild(fieldset2);
               tablaDentro.appendChild(trTablaDentro);
    
               trTable.getChildNodes().item(1).appendChild(tablaDentro);
               trTable.getChildNodes().item(2).appendChild(getIMG(12, 12));
    
               table.appendChild(trTable);
    
               //este td es el que le sigue al la linea del primer filedset
               //tr.getChildNodes().item(0).appendChild(getIMG(12,12));
               //tablaAfuera.appendChild(tr);
    
               Element trFiledset3 = getTR(3);
               trFiledset3.getChildNodes().item(0).appendChild(getIMG(0, 0));
    
               Element fieldset3 = getFIELDSET();
    
               Element tableBoton = doc.createElement("table");
               tableBoton.setAttribute("width", "100%");
               tableBoton.setAttribute("border", "0");
               tableBoton.setAttribute("align", "center");
               tableBoton.setAttribute("cellspacing", "0");
               tableBoton.setAttribute("cellpadding", "0");
    
               tr = getTR(1);
               tr.getChildNodes().item(0).appendChild(getBOTONEliminar("btnEliminar8" + String.valueOf(indice), "botonContenido", "html", "accionEliminarCondicion('btnEliminar8" + String.valueOf(indice) + "');", "false", "1254", (elemPromocion.getNumeroCondicion() == null ? "" : elemPromocion.getNumeroCondicion().toString())));
               ((Element) tr.getChildNodes().item(0)).setAttribute("class", "botonera");
               ((Element) tr.getChildNodes().item(0)).setAttribute("width", "100%");
               tableBoton.appendChild(tr);
               fieldset3.appendChild(tableBoton);
               trFiledset3.getChildNodes().item(1).appendChild(fieldset3);
    
               trFiledset3.getChildNodes().item(2).appendChild(getIMG(12, 12));
    
               table.appendChild(trFiledset3);
               tr = getTR(1);
               tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
               ((Element) tr.getChildNodes().item(0)).setAttribute("colspan", "3");
               table.appendChild(tr);
               fieldset1.appendChild(table);
               listaEditableObtenida = (Element) (doc.importNode((Node) armarListaEditable(elemPromocion.getLineaPromocion(), elemPromocion.getNumeroCondicion()), true));
               yLista = new Integer(yLista.intValue() + 395);
               divPromo.appendChild(listaEditableObtenida);
               listaEditableObtenida.setAttribute("ancho","620");
               Element botonModificar = this.getBOTON("Modificar8" + String.valueOf(indice -1),
                  "botonContenido", 
                  "html",
                  "javascript:accionModificarCondicion(" + String.valueOf(elemPromocion.getNumeroCondicion()) + ");",
                  "true", 
                  "2");
    
               botonModificar.setAttribute("x","33");
               botonModificar.setAttribute("y",String.valueOf(yLista.intValue() - 47));
               divPromo.appendChild(botonModificar);
            } //fin while
        }
        traza("metodo armarLista()4");
        yLista = new Integer(yLista.intValue() + 52);
        //genero mi lista
        trTablaAfuera.getChildNodes().item(1).appendChild(fieldset1);
        trTablaAfuera.getChildNodes().item(2).appendChild(getIMG(12, 12));
        tablaAfuera.appendChild(trTablaAfuera);

        capaPrincipal.appendChild(tablaAfuera);

        Element trFiledSet4 = getTR(3);
        trFiledSet4.getChildNodes().item(0).appendChild(getIMG(12, 12));
        Element fieldset4 = getFIELDSET();
        Element tableBotonAnadir = doc.createElement("table");
        tableBotonAnadir.setAttribute("width", "100%");
        tableBotonAnadir.setAttribute("border", "0");
        tableBotonAnadir.setAttribute("align", "center");
        tableBotonAnadir.setAttribute("cellspacing", "0");
        tableBotonAnadir.setAttribute("cellpadding", "0");
        tr = getTR(1);
        tr.getChildNodes().item(0).appendChild(getBOTON("btnAnadir", "botonContenido", "html", "accionAniadirCondicion();", "false", "404"));


        traza("metodo armarLista()5");
        tableBotonAnadir.appendChild(tr);
        fieldset4.appendChild(tableBotonAnadir);
        trFiledSet4.getChildNodes().item(1).appendChild(fieldset4);
        trFiledSet4.getChildNodes().item(2).appendChild(getIMG(12, 12));
        tablaAfuera.appendChild(trFiledSet4);

        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(0)).setAttribute("width", "12");
        tr.getChildNodes().item(1).appendChild(getIMG(0, 0));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");
        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(2)).setAttribute("width", "12");
        tablaAfuera.appendChild(tr);
        traza("metodo armarLista()6");

  /*    *********Fin Marta***************        */
        return divPromo;
    }

    private Element getLEGENDGrupos() {
        Element legend = doc.createElement("legend");
        legend.setAttribute("class", "legend");
        legend.appendChild(getLABELC("lblGrupos", "50", "13", "1", "", "legend", "545"));
        return legend;
    }

    private Element armarListaEditable(Vector v, Integer numeroCond) throws Exception {
        traza("metodo armarListaEditable()");
        ListaEditableDinamica listado = new ListaEditableDinamica(this, "listado3" + String.valueOf(indice), 5, 0, false, "mipgndo3" + String.valueOf(indice));

        if (nombreLista.equals("")) {
           traza("nombrelistavacia");
           nombreLista = "listado3" + String.valueOf(indice);
        } else {
           nombreLista = nombreLista + "|" + "listado3" + String.valueOf(indice);
        }


        listado.setCodigoColumna(0, "516");

        listado.setCodigoColumna(1, "593");
        listado.setCodigoColumna(2, "555");
        listado.setCodigoColumna(3, "145");
        listado.setCodigoColumna(4, "553");

        listado.setAnchoColumna(0, 100);
        listado.setAnchoColumna(1, 100);
        listado.setAnchoColumna(2, 100);
        listado.setAnchoColumna(3, 100);
        listado.setAnchoColumna(4, 100);

        Enumeration elementosLineaPromo = v.elements();
        
        String sTipoOperacionDTO = null;

        while (elementosLineaPromo.hasMoreElements()) {
           DTOLineaPromocion elemLineaPromo = (DTOLineaPromocion) elementosLineaPromo.nextElement();           
           // Clausula If agregada x ssantana, 28/10/2005 
           // Si el tipo de Operacion es Baja, no lo muestra en la lista. 
           sTipoOperacionDTO = elemLineaPromo.getTipoOperacion(); 
           traza("sTipoOperacionDTO: " + sTipoOperacionDTO); 
           if ( !ConstantesPRE.OPERACION_BAJA.equals(sTipoOperacionDTO) ) { 

               String oid = "" + (elemLineaPromo.getOidLineaPromocion() == null ? "" : elemLineaPromo.getOidLineaPromocion().toString());
               String descCata = "" + elemLineaPromo.getDescripcionCatalogo();
               String tipoR = "" + String.valueOf(elemLineaPromo.getTipoRango());
               String valorD = null;
               if (tipoR.equals("R")) {
                  valorD = (elemLineaPromo.getValorDesde() == null ? "" : elemLineaPromo.getValorDesde().toString());
               } else if (tipoR.equals("P")) {
                  valorD = (elemLineaPromo.getCodigoProducto() == null ? "" : elemLineaPromo.getCodigoProducto().toString());
               } else {
                  valorD = (elemLineaPromo.getCodigoLineaProducto() == null ? "" : elemLineaPromo.getCodigoLineaProducto().toString());           
               }
               String valorH = (elemLineaPromo.getValorHasta() == null ? "" : elemLineaPromo.getValorHasta().toString());
               String indE = (elemLineaPromo.getIndicadorExclusion() == null ? "N" : elemLineaPromo.getIndicadorExclusion().booleanValue() ? "S" : "N");
               Character lineaNegocio = new Character(ConstantesPRE.LINEAS_NEGOCIO);
               Character rangoPagina = new Character(ConstantesPRE.RANGO_PAGINAS);
               Character producto = new Character(ConstantesPRE.PRODUCTOS);
               if (tipoR.equals(lineaNegocio.toString())) {
                  tipoR = new String("Lineas de negocio");
               } else if (tipoR.equals(rangoPagina.toString())) {
                  tipoR = new String("Rango de páginas");
               } else if (tipoR.equals(producto.toString())) {
                  tipoR = new String("Producto");
               }
               listado.addFila(new String[]{oid, descCata, tipoR, valorD, valorH, indE});
            }
        }

        //deberiamos agregar al tag boton el atributo codigo y asignar al mismo el nombre de la lista

        // agregarBoton(String nombre,                           String id,  Boolean estado,     int codigo, String accion) {
        //listado.agregarBoton("Modificar3" + String.valueOf(indice), "botonContenido", new Boolean("True"), 2, "accionModificarCondicion(" + String.valueOf(numeroCond) + ");");


        indice = indice + 1;
        listado.setAlto(275);
        //listado.setAlto(290);
        listado.setX(32);
        listado.setY(yLista.intValue() + 95);
       // listado.setYBoton(yLista.intValue() + 332);
        return listado.getLista();
    }

    private Element getBOTON(String nombre, String id, String tipo, String accion, String estado, String cod) {
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre", nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);
        boton.setAttribute("ontab", "javascript:tabGenerico('"+nombre+"');");
        boton.setAttribute("onshtab", "javascript:tabGenerico('"+nombre+"','sh');");        
        return boton;
    }

    private Element getBOTONEliminar(String nombre, String id, String tipo, String accion, String estado, String cod, String codigo) {
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre", nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);
        boton.setAttribute("codigo", codigo);
        boton.setAttribute("ontab", "javascript:tabGenerico('"+nombre+"');");
        boton.setAttribute("onshtab", "javascript:tabGenerico('"+nombre+"','sh');");
        return boton;
    }

    private Element getIMG(int width, int height) {
        Element img = doc.createElement("IMG");
        img.setAttribute("src", "b.gif");
        img.setAttribute("width", "" + width);
        img.setAttribute("height", "" + height);
        return img;
    }

    private Element getTR(int tds) {
        Element tr = doc.createElement("tr");
        while (tds > 0) {
            tr.appendChild(doc.createElement("td"));
            tds--;
        }
        return tr;
    }

    private Element getFIELDSET() {
        Element fieldset = doc.createElement("fieldset");
        return fieldset;
    }

    private Element getLegend() {
        Element legend = doc.createElement("legend");
        legend.setAttribute("class", "legend");
        legend.appendChild(getLABELC("lblPromociones", "105", "13", "1", "", "legend", "00117"));
        return legend;
    }

    private Element getLABELC(String nombre, String ancho, String alto, String filas, String valor, String id, String cod) {
        Element labelC = doc.createElement("LABELC");
        labelC.setAttribute("nombre", nombre);
        labelC.setAttribute("ancho", ancho);
        labelC.setAttribute("alto", alto);
        labelC.setAttribute("filas", filas);
        labelC.setAttribute("valor", valor);
        labelC.setAttribute("id", id);
        labelC.setAttribute("cod", cod);
        return labelC;
    }

    private Element getLABEL(String nombre, String ancho, String alto,
                        String filas, String valor, String id) {
        Element label = doc.createElement("LABEL");
        label.setAttribute("nombre", nombre);
        label.setAttribute("ancho", ancho);
        label.setAttribute("alto", alto);
        label.setAttribute("filas", filas);
        label.setAttribute("valor", valor);
        label.setAttribute("id", id);
        //label.setAttribute("cod", cod);

        return label;
    }

   private Element getCOMBO(String nombre, String id, String size, String multiple, String req) {
      Element combo = doc.createElement("COMBO");
      combo.setAttribute("nombre", nombre);
      combo.setAttribute("id", id);
      combo.setAttribute("size", size);
      combo.setAttribute("multiple", multiple);
      combo.setAttribute("req", req);
      // combo.setAttribute("valorinicial",valorinicial);
      // combo.setAttribute("textoinicial",textoinicial);
      combo.appendChild(doc.createElement("ROWSET"));
      
      return combo;
   }

    /* *********GRUPOS********** */
    private Element armarListaGrupos(Vector vectorDtoGrupo, Vector vectorDtoDetalles, long tipoEstr) throws Exception {
        Iterator grupos = vectorDtoGrupo.iterator();
        traza("armarListaGrupos 0");
        //tablaEnglobaG = doc.createElement("table");
        div = doc.createElement("DIV");
        if (yLista==null)
            yLista = new Integer(TAMANOPAGINASINDINAMICA);
        Element listaEditableObtenida = null;
        traza("armarListaGrupos 1");
        Element capaPrincipalG = doc.createElement("CAPA");
        capaPrincipalG.setAttribute("nombre", "capaGrupos");
        capaPrincipalG.setAttribute("alto", "100%");
        capaPrincipalG.setAttribute("ancho", "100%");
        capaPrincipalG.setAttribute("colorf", "");
        capaPrincipalG.setAttribute("borde", "0");
        capaPrincipalG.setAttribute("imagenf", "");
        capaPrincipalG.setAttribute("repeat", "");
        capaPrincipalG.setAttribute("padding", "");
        capaPrincipalG.setAttribute("visibilidad", "visible");
        capaPrincipalG.setAttribute("contravsb", "");
        capaPrincipalG.setAttribute("x", "0");        
        capaPrincipalG.setAttribute("y", yLista.toString());
        capaPrincipalG.setAttribute("zindex", "");

        div.appendChild(capaPrincipalG);
        //T1 TABLA 1
        tablaAfueraG = doc.createElement("table");
        tablaAfueraG.setAttribute("width", "100%");
        tablaAfueraG.setAttribute("border", "0");
        tablaAfueraG.setAttribute("cellspacing", "0");
        tablaAfueraG.setAttribute("cellpadding", "0");
        traza("armarListaGrupos 4");
        //PRIMERA FILA DE LA TABLA AFUERA
        /*-----------------------------------------------------------------------------------------------------*/
        tr = getTR(3);

        //T1 F1 C1 Col 1
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));

        //T1 F1 C2 Col 2
        tr.getChildNodes().item(1).appendChild(getIMG(1, 1));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");

        //System.out.println("metodo armar lista1 ");
        //T1 F1 C3 Col 3
        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        //cierre de tr
        tablaAfueraG.appendChild(tr);

        //T1 F1 fin primera fila
        /*-----------------------------------------------------------------------------------------------------*/
        //SEGUNDA FILA DE LA TABLA AFUERA
        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
        fieldset1 = getFIELDSET();
        legend1 = getLEGENDGrupos();
        fieldset1.appendChild(legend1);
        DTOGrupo grupo = null;
        while (grupos.hasNext()) {
           grupo = (DTOGrupo) grupos.next();
           traza("****************************************************");
           traza("DTO GRUPO!!!!!   = " + grupo.getNumeroGrupo());
           traza("****************************************************");
           table1 = doc.createElement("table");
           table1.setAttribute("width", "100%");
           table1.setAttribute("border", "0");
           table1.setAttribute("align", "center");
           table1.setAttribute("cellspacing", "0");
           table1.setAttribute("cellpadding", "0");

           // Tabla 1 fila 1
           tr1 = getTR(1);
           tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
           ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
           table1.appendChild(tr1);

           //2
           tr1 = getTR(3);
           tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));
           ((Element) tr1.getChildNodes().item(1)).setAttribute("width", "100%");
           table2 = doc.createElement("table");
           table2.setAttribute("width", "100%");
           table2.setAttribute("border", "0");
           table2.setAttribute("cellspacing", "0");
           table2.setAttribute("cellpadding", "0");

           tr2 = getTR(1);

           fieldset2 = getFIELDSET();

           table3 = doc.createElement("table");
           table3.setAttribute("width", "100%");
           table3.setAttribute("border", "0");
           table3.setAttribute("cellspacing", "0");
           table3.setAttribute("align", "center");
           table3.setAttribute("cellpadding", "0");

           //1
           tr3 = getTR(1);
           tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
           ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
           table3.appendChild(tr3);

           //2
           tr3 = getTR(10);
           tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
           traza("indice---->"+indice);

           Element labelC2 = getLABELC("lblNumeroCondicion123" + indice, "110", "17", "1", "",
                                       "datosTitle", "533");
           tr3.getChildNodes().item(1).appendChild(labelC2);
           tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));
           labelC2 = getLABELC("lblIndicadorCuadre123" + indice, "150", "17", "1", "", "datosTitle", "005");
           tr3.getChildNodes().item(3).appendChild(labelC2);
           tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));
           labelC2 = getLABELC("lblFactorCuadre123" + indice, "120", "17", "1", "", "datosTitle", "006");
           tr3.getChildNodes().item(5).appendChild(labelC2);
           tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));
           labelC2 = getLABELC("lblTipoGrupo1" + indice, "130", "17", "1", "", "datosTitle", "479");
           tr3.getChildNodes().item(7).appendChild(labelC2);
           tr3.getChildNodes().item(8).appendChild(getIMG(81, 8));
           ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "88");
           tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
           ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");
           table3.appendChild(tr3);

           //3
           tr3 = getTR(10);

           tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
           labelC2 = getLABEL("lblNumeroCondicionXX23" + indice, "60", "17", "1", ((grupo.getNumeroGrupo() == null) ? "" : grupo.getNumeroGrupo().toString()),
                              "datosCampos");

           tr3.getChildNodes().item(1).appendChild(labelC2);

           tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));

           labelC2 = getLABEL("lblIndicadorCuadreXX23" + indice, "", "17", "1",
                              ((grupo.getOidIndicadorCuadre() == null) ? ""
                               : (grupo.getDescripcionIndicadorCuadre()!=null)?grupo.getDescripcionIndicadorCuadre():""
                              ), "datosCampos");
           tr3.getChildNodes().item(3).appendChild(labelC2);

           tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));

           labelC2 = getLABEL("lblFactorCuadreXX23" + indice, "130", "17", "1",
                              ((grupo.getFactorCuadre() == null) ? "" : UtilidadesBelcorp.formateaNumeroSICC(grupo.getFactorCuadre().toString(),this.FORMATO_DEFAULT,this)),
                              "datosCampos");
           tr3.getChildNodes().item(5).appendChild(labelC2);

           tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));

           String tipoGrupo = new String();

           /*+ Grupos: (Se muestran si se recogieron datos para los grupos, es decir DTOOferta.grupo != Null). Se muestra una cabecera por grupo (DTOGrupo) con los valores
              - Número grupo = DTOGrupo.numeroGrupo
              - Indicador cuadre = DTOGrupo.descripcionIndicadorCuadre
              - Factor cuadre = DTOGrupo.factorCuadre
              - Tipo grupo
                                            "Paquete" -> Si DTOGrupo.indicadorGrupo == False
                                            "Grupo" -> Si DTOGrupo.condicionante == False AND DTOGrupo.condicionado == False
                                            "Grupo condicionante" -> Si DTOGrupo.condicionante == True
                                            "Grupo condicionado" -> Si DTOGrupo.condicionado == True */
           if ((grupo.getIndicadorGrupo().booleanValue() == false)) {
              tipoGrupo = new String("Paquete");
              if (grupo.getCondicionado().booleanValue() == true) {
                tipoGrupo = "Grupo Condicionado";
              } else if (grupo.getCondicionante().booleanValue() == true) {
               tipoGrupo = "Grupo Condicionante";
              }
           } else if ((grupo.getCondicionado().booleanValue() == false) &&
                      (grupo.getCondicionante().booleanValue() == false)) {
              tipoGrupo = "Grupo";
           } 
           traza("tipoGrupo--->"+tipoGrupo);

           labelC2 = getLABEL("lblTipoGrupoXX1" + indice, "130", "17", "1", "" + tipoGrupo, "datosCampos");
           tr3.getChildNodes().item(7).appendChild(labelC2);

           tr3.getChildNodes().item(8).appendChild(getIMG(8, 8));
           ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "1");
           tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
           ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");

           table3.appendChild(tr3);

           //4
           tr3 = getTR(1);
           tr3.getChildNodes().item(0).appendChild(getIMG(8, 310));
           ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
           table3.appendChild(tr3);

           //fin filas tabla 3
           fieldset2.appendChild(table3);
           tr2.getChildNodes().item(0).appendChild(fieldset2);
           table2.appendChild(tr2);
           tr1.getChildNodes().item(1).appendChild(table2);

           //3
           tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));

           table1.appendChild(tr1);

           //FIN FILA 2
           //F3
           tr1 = getTR(3);

           tr1.getChildNodes().item(0).appendChild(getIMG(0, 0));
           fieldset3 = getFIELDSET();
           table5 = doc.createElement("table");
           table5.setAttribute("width", "100%");
           table5.setAttribute("border", "0");
           table5.setAttribute("align", "center");
           table5.setAttribute("cellspacing", "0");
           table5.setAttribute("cellpadding", "0");
           tr5 = getTR(1);
           tr5.getChildNodes().item(0).appendChild(getBOTONEliminar("btnEliminar" + String.valueOf(indice), "botonContenido", "html", "accionEliminarGrupo    ('btnEliminar" + String.valueOf(indice) + "');", "false", "1254", (grupo.getNumeroGrupo() == null ? "" : grupo.getNumeroGrupo().toString())));
           traza("Nro Grupo: " + grupo.getNumeroGrupo());

           ((Element) tr5.getChildNodes().item(0)).setAttribute("class", "botonera");
           ((Element) tr5.getChildNodes().item(0)).setAttribute("width", "100%");
           table5.appendChild(tr5);
           fieldset3.appendChild(table5);
           tr1.getChildNodes().item(1).appendChild(fieldset3);
           tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));
           table1.appendChild(tr1);

           //fin fila 3


           //F4
           tr1 = getTR(1);
           tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
           ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
           table1.appendChild(tr1);

           //fin fila 4


           fieldset1.appendChild(table1);
           listaEditableObtenida = (Element) (doc.importNode((Node) armarListaEditableGrupos(vectorDtoDetalles, grupo.getNumeroGrupo()), true));
           yLista = new Integer(yLista.intValue() + 395);           
           div.appendChild(listaEditableObtenida);
           listaEditableObtenida.setAttribute("ancho","620");
           Element botonModificar = this.getBOTON("Modificar4" + String.valueOf(indice -1),
              "botonContenido", 
              "html",
              "javascript:accionModificarGrupo(" + String.valueOf(grupo.getNumeroGrupo()) + ");",
              "true", 
              "2");

           botonModificar.setAttribute("x","33");           
           botonModificar.setAttribute("y",String.valueOf(yLista.intValue() - 48));           
           div.appendChild(botonModificar);
        }
        //F5
        tr1 = getTR(3);
        tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));

        tr1.getChildNodes().item(2).appendChild(getIMG(8, 8));
        ((Element) tr1.getChildNodes().item(2)).setAttribute("width", "100%");
        table1.appendChild(tr1);

        //fin fila 5
        //F6
        tr1 = getTR(3);
        tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));

        //Tomar el tipo de estrategia
        Element combo = getCOMBO("cbTipoGrupo2", "datosCampos", "1", "N", "N");        
        //contador = contador+1;
        Element rowset = getROWSET();

        if (tipoEstr == 3) {
           traza("estrategia 3");
           Element campos = getCAMPOS(2, "1");
           ((Element) campos.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
           ((Element) campos.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
           ((Element) campos.getChildNodes().item(0)).setAttribute("VALOR", "1");

           ((Element) campos.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
           ((Element) campos.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
           ((Element) campos.getChildNodes().item(1)).setAttribute("VALOR", "Grupo");

           rowset.appendChild(campos);
        } else if (tipoEstr == 4) {
           traza("estrategia 4");
           Element campos3 = getCAMPOS(2, "3");
           ((Element) campos3.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
           ((Element) campos3.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
           ((Element) campos3.getChildNodes().item(0)).setAttribute("VALOR", "4");
           ((Element) campos3.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
           ((Element) campos3.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
           ((Element) campos3.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionantes");
           rowset.appendChild(campos3);

           Element campos4 = getCAMPOS(2, "4");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "3");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
           rowset.appendChild(campos4);
        } else if (tipoEstr == 6) {
           traza("estrategia 6");
           Element campos2 = getCAMPOS(2, "2");
           ((Element) campos2.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
           ((Element) campos2.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
           ((Element) campos2.getChildNodes().item(0)).setAttribute("VALOR", "2");

           ((Element) campos2.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
           ((Element) campos2.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
           ((Element) campos2.getChildNodes().item(1)).setAttribute("VALOR", "Paquete");
           rowset.appendChild(campos2);
        } else if (tipoEstr == 7) {
           traza("estrategia 7");
           Element campos4 = getCAMPOS(2, "4");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
           ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "3");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
           ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
           rowset.appendChild(campos4);
        }

        combo.appendChild(rowset);
        tr1.getChildNodes().item(1).appendChild(combo);
        tr1.getChildNodes().item(2).appendChild(getIMG(8, 8));
        ((Element) tr1.getChildNodes().item(2)).setAttribute("width", "100%");
        table1.appendChild(tr1);

        //fin fila 6
        //F7
        tr1 = getTR(1);
        tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
        ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
        table1.appendChild(tr1);

        yLista = new Integer(yLista.intValue() + 100);
        tr.getChildNodes().item(1).appendChild(fieldset1);
        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        //((Element)tr.getChildNodes().item(0)).setAttribute("style","background-color:silver");
        tablaAfueraG.appendChild(tr);

        //FIN SEGUNDA FILA DE LA TABLA AFUERA

        /*-----------------------------------------------------------------------------------------------------*/
        /*-----------------------------------------------------------------------------------------------------*/

        //TERCERA FILA DE LA TABLA AFUERA
        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(0, 0));

        fieldset4 = getFIELDSET();
        table6 = doc.createElement("table");
        table6.setAttribute("width", "100%");
        table6.setAttribute("align", "center");
        table6.setAttribute("border", "0");
        table6.setAttribute("cellspacing", "0");
        table6.setAttribute("cellpadding", "0");
        tr6 = getTR(1);
        ((Element) tr6.getChildNodes().item(0)).setAttribute("class", "botonera");
        ((Element) tr6.getChildNodes().item(0)).setAttribute("width", "100%");

        Element boton = getBOTON("btnAnadir2", "botonContenido", "html", "accionAniadirGrupo();", "false", "404");

        tr6.getChildNodes().item(0).appendChild(boton);
        table6.appendChild(tr6);
        fieldset4.appendChild(table6);

        tr.getChildNodes().item(1).appendChild(fieldset4);

        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));

        tablaAfueraG.appendChild(tr);

        //FIN TERCERA FILA DE LA TABLA AFUERA

        /*------------------------------------------------------------------------------------------------------*/

        //CUARTA FILA DE LA TABLA AFUERA
        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(0)).setAttribute("width", "12");
        ((Element) tr.getChildNodes().item(0)).setAttribute("align", "center");

        tr.getChildNodes().item(1).appendChild(getIMG(0, 0));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");

        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(2)).setAttribute("width", "12");

        tablaAfueraG.appendChild(tr);

        //FIN CUARTA FILA DE LA TABLA AFUERA
        capaPrincipalG.appendChild(tablaAfueraG);

        /*-------------------------------------------------------------------------------------------------------*/
        return div;
    }
    //Terminar de probar
    /**
     * @throws java.lang.Exception
     * @return 
     * @param nroGrupo
     * @param v
     * @author Marcelo J. Maidana (modificado) - Se agregaron las columnas 'Tipo de oferta'
     * y 'Ciclo de vida' a la lista de Grupos.
     * @version 11/07/2005
     */
    private Element armarListaEditableGrupos(Vector v, Integer nroGrupo) throws Exception {
    
        traza("metodo armarListaEditable()");
        
        //Agregado mmaidana-----------------------------------------------------
        DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta = 
            (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        //----------------------------------------------------------------------
        
        //Modificado mmaidana - 3er param cambio de 7 a 9 ----------------------
        ListaEditableDinamica listado = new ListaEditableDinamica(this, "listado4" + String.valueOf(indice), 9, 0, false, "mipgndo4" + String.valueOf(indice));
        
        if (nombreLista.equals("")) {
            nombreLista = "listado4" + String.valueOf(indice);
        } else {
            nombreLista = nombreLista + "|" + "listado4" + String.valueOf(indice);
        }

        listado.setCodigoColumna(0, "8");
        listado.setCodigoColumna(1, "9");
        
        //Agregado mmaidana-----------------------------------------------------
        listado.setCodigoColumna(2,"608");
        listado.setCodigoColumna(3,"581");
        //----------------------------------------------------------------------
        
        listado.setCodigoColumna(4, "529");
        listado.setCodigoColumna(5, "530");
        listado.setCodigoColumna(6, "481");
        listado.setCodigoColumna(7, "482");
        listado.setCodigoColumna(8, "483");
        
        listado.setAnchoColumna(0, 100);
        listado.setAnchoColumna(1, 100);
        listado.setAnchoColumna(2, 100);
        listado.setAnchoColumna(3, 100);
        listado.setAnchoColumna(4, 100);
        listado.setAnchoColumna(5, 100);
        listado.setAnchoColumna(6, 100);
        
        //Agregado mmaidana-----------------------------------------------------
        listado.setAnchoColumna(7, 100);
        listado.setAnchoColumna(8, 100);
        //----------------------------------------------------------------------
        
        Iterator detalles = v.iterator();

        while (detalles.hasNext()) {

            DTODetalleOferta ofertaDetalle = (DTODetalleOferta) detalles.next();

            traza("Oid Grupo Oferta = " + ofertaDetalle.getNumeroGrupo());
            traza("Nro Grupo = " + nroGrupo);
            
            Integer nroGrupoDTO = ofertaDetalle.getNumeroGrupo();
            String sTipoOperacionDTO = ofertaDetalle.getTipoOperacion();
                   
            traza("DTODetalleOferta SSantana: " + ofertaDetalle);
            if ( nroGrupoDTO != null && nroGrupoDTO.equals(nroGrupo) && 
                 (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(sTipoOperacionDTO)) )  {
                traza("Muestro Grupo - ssantana");
                ofertaDetalle.setNumeroGrupo(nroGrupo);
                String oid = null;
                if (ofertaDetalle.getOidDetalleOferta() == null ) {
                  oid = "p" + (ofertaDetalle.getOidSAP() == null ? "" : ofertaDetalle.getOidSAP().toString());
                } else {
                  oid = ofertaDetalle.getOidDetalleOferta().toString();
                }
                String codSap = (ofertaDetalle.getCodigoSAP()!=null)?ofertaDetalle.getCodigoSAP().toString():"";
                String desc = (ofertaDetalle.getDescripcion()!=null)?ofertaDetalle.getDescripcion().toString():"";
                String factRep = "" + (ofertaDetalle.getFactorRepeticion() == null ? "" : ofertaDetalle.getFactorRepeticion().toString());
                String precCatalogo = "" + (ofertaDetalle.getPrecioCatalogo() == null ? "" : ofertaDetalle.getPrecioCatalogo().toString());
                String atr1 = (ofertaDetalle.getAtributo1()!=null)?ofertaDetalle.getAtributo1().toString():"";
                String atr2 = (ofertaDetalle.getAtributo2()!=null)?ofertaDetalle.getAtributo2().toString():"";
                String atr3 = (ofertaDetalle.getAtributo3()!=null)?ofertaDetalle.getAtributo3().toString():"";

                String tipoOferta = this.obtenerDescTipoOferta(dtoCargarCriterioDefOferta, ofertaDetalle.getOidTipoOferta());
                String cicloVida = this.obtenerDescCicloVida(dtoCargarCriterioDefOferta, ofertaDetalle.getOidCicloVida());

                String auxPrecCata = null;
                if ((precCatalogo!=null)&&(!precCatalogo.equals(""))){
                    auxPrecCata = UtilidadesBelcorp.formateaNumeroSICC(precCatalogo, this.FORMATO_DEFAULT, this);
                } else {
                    auxPrecCata = new String("");
                }
                listado.addFila(new String[]{oid, codSap, desc, tipoOferta, cicloVida, factRep, auxPrecCata, atr1, atr2, atr3});
            } else {
                traza("No muestra Grupo - ssantana");
            }
        }
        indice = indice + 1;
        traza("nroGrupo" + nroGrupo);
        //listado.agregarBoton("Modificar4" + String.valueOf(indice), "botonContenido", new Boolean("True"), 2, "accionModificarGrupo(" + String.valueOf(nroGrupo) + ");");
        listado.setAlto(275);
        listado.setX(32);
        listado.setY(yLista.intValue() + 95);
        //listado.setYBoton(yLista.intValue() + 342);
        return listado.getLista();
    }
    
    /**
     * 
     * @throws java.lang.Exception
     * @return 
     * @param oid el valor a buscar
     * @param dtoCargarCriterioDefOferta el dto que contiene el RecordSet de Tipos
     * de oferta donde se realizara la busqueda.
     * @author Marcelo J. Maidana
     * @version 11/07/2005
     */
    private String obtenerDescTipoOferta(
                DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta, Long oid) throws Exception {

        traza("entro a obtenerDescTipoOferta");

        traza("tipo de oferta buscado: " + oid);

        BigDecimal bdOid = null;
        Long lOid = null;
        RecordSet rs = dtoCargarCriterioDefOferta.getTiposOferta();

        traza("RecordSet tipos de oferta: " + rs);
        
        if (rs != null && !rs.esVacio() && oid != null){
        
            for (int i = 0; i < rs.getRowCount(); i++){
                bdOid = (BigDecimal)rs.getValueAt(i, 0);
                
                traza("obtuvo bigdecimal: " + bdOid);
                
                if (bdOid != null){
                    lOid = new Long(bdOid.toString());
                    
                    traza("obtuvo long: " + lOid);
                    traza("oid buscado: " + oid);
                    
                    if (lOid.equals(oid)){
                        if (rs.getValueAt(i, 1) != null){
                            return rs.getValueAt(i, 1).toString();
                        }
                    }
                }
            }
        }
        
        return "";
    }

    /**
     * 
     * @throws java.lang.Exception
     * @return 
     * @param oid el valor a buscar
     * @param dtoCargarCriterioDefOferta el dto que contiene el RecordSet de Ciclos
     * de vida donde se realizara la busqueda.
     * @author Marcelo J. Maidana
     * @version 11/07/2005
     */
    private String obtenerDescCicloVida(
            DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta, Long oid) throws Exception {
    
        traza("entro a obtenerDescCiclosVida");
        traza("ciclo de vida buscado: " + oid);

        BigDecimal bdOid = null;
        Long lOid = null;
        RecordSet rs = dtoCargarCriterioDefOferta.getCiclosVida();
    
        traza("RecordSet ciclos de vida: " + rs);

        if (rs != null && !rs.esVacio() && oid != null){
        
            for (int i = 0; i < rs.getRowCount(); i++){
                bdOid = (BigDecimal)rs.getValueAt(i, 0);
                
                if (bdOid != null){
                    lOid = new Long(bdOid.toString());
                    
                    if (lOid.equals(oid)){
                        if (rs.getValueAt(i, 1) != null){
                            return rs.getValueAt(i, 1).toString();
                        }
                    }
                }
            }
        }
        
        return "";
    }
    

    private Element getROWSET() {
        Element rowset = doc.createElement("ROWSET");

        return rowset;
    }

    private Element getCAMPOS(int cps, String id) {
        Element tr = doc.createElement("ROW");
        tr.setAttribute("ID", id);
        while (cps > 0) {
            tr.appendChild(doc.createElement("CAMPO"));
            cps--;
        }
        return tr;
    }
    
    
    
  /**
   * @author: ssantana, 6/10/2005, GCC-PRE-001
   * @throws java.lang.Exception
   */
    private void modificarProducto() throws Exception {
       traza("LPModificarOferta.modificarProducto()");
  
       // Modificado por SiCC20070316 - Rafael Romero - 19/07/2007
       // la obtencion de los datos del producto esta en un metodo independiente
       this.obtenerProductos();
       // fin modificacion SiCC20070316
       
       // Llamo a LPDatosProducto con tipoOperacion == "modificacion y accion = ""
       this.conectorAction("LPDatosProducto");
       if (conectorParametroSesion("productoprincipal")!=null&&((Boolean)conectorParametroSesion("productoprincipal")).booleanValue()){
          conectorActionParametro("multiseleccion", "false");
       } else {
          conectorActionParametro("multiseleccion", "true");
       }       
       this.conectorActionParametro("accion", "");
       this.conectorActionParametro("lpRetorno", "LPModificarOferta");       
       this.conectorActionParametro("tipoOperacion", ConstantesPRE.OPERACION_MODIFICACION);
    }
    
    
  /**
   * @author: ssantana, 11/10/2005, GCC-PRE-001
   * @return Vector
   * @param String sCadena
   */
    private Vector parseaListaEditableProductos(String sCadena) throws Exception {
      /*
       * Recibe una cadena con formato [campo1!campo2!...@campo3!campo4!...] 
       * donde "!" separa los campos de una misma fila, y "@" separa 
       * las distintas filas. Por ejemplo:
       * [60!200007726-N005!EBEL ETERNALIST ESM CABARET-N005!TipoOferta1!Ciclo1!1!123,131! ! ! ]
       */
      traza("LPModificarOferta.paseaListaEditableProductos()");
      
      Vector vRetorno = new Vector();
      
      // Quitamos los "[" y "]"
      traza("Quitamos [ y ]...");
      sCadena = sCadena.substring(0, sCadena.length()-1);
      traza("sCadena al momento: " + sCadena);
      sCadena = sCadena.substring(1, sCadena.length());
      traza("sCadena al momento: " + sCadena);
      
      traza("sCadena al momento: " + sCadena);
      
      // Parseamos por lineas
      traza("Parseamos la cadena");
      StringTokenizer sTokLineas = new StringTokenizer(sCadena, "@");
      
      while (sTokLineas.hasMoreTokens()) {
         String sLinea = sTokLineas.nextToken();
        
         // Parsea los campos, de una línea en particular.
         StringTokenizer sTokCampos = new StringTokenizer(sLinea, "!");
         DTOProducto dtoProdu = new DTOProducto();
         int i = 0; 
         while (sTokCampos.hasMoreTokens()) {
            String sCampo = sTokCampos.nextToken();
         
            switch (i) {
               case 0: // Oid 
                  break;
                
               case 1: // Codigo
                  String sCodigo = (String) this.manejaCampo(sCampo, "S");
                  dtoProdu.setCodigoSAP(sCampo);
                  break;
                  
               case 2: // Descripcion 
                  String sDesc = (String) this.manejaCampo(sCampo, "S");
                  dtoProdu.setDescripcionSAP(sDesc);
                  break;
                  
               case 3: // Tipo Oferta 
                  String sTipoOferta = (String) this.manejaCampo(sCampo, "S");
                  dtoProdu.setDescripcionTipoOferta(sTipoOferta);
                  break;
                
               case 4: // Ciclo Vida
                  String sCicloVida = (String) this.manejaCampo(sCampo, "S");
                  dtoProdu.setDescripcionCicloVida(sCicloVida);
                  break;
                
               case 5: // Factor Repeticion
                  Integer iFactorRepeticion = (Integer) this.manejaCampo(sCampo, "I");
                  dtoProdu.setFactorRepeticion(iFactorRepeticion);
                  break;
                
               case 6: // Precio Unitario.
                  // No se hace nada (no quito el "case 6" para clarificar el codigo)
                  break;
                
               case 7: // Atributo 1
                  dtoProdu.setAtributo1((String) this.manejaCampo(sCampo, "S"));
                  break; 
                
               case 8: // Atributo 2
                  dtoProdu.setAtributo2((String) this.manejaCampo(sCampo, "S"));
                  break;
                
               case 9: // Atributo 3
                  dtoProdu.setAtributo3((String) this.manejaCampo(sCampo, "S"));
                  break;
             }
            
             i++;
             if ( i == 10) {
                i = 0; 
                traza("dtoProducto : " + dtoProdu);
                vRetorno.add(dtoProdu);
                dtoProdu = new DTOProducto();
             }
        }
      }
      
      traza("vRetorno.size(): " + vRetorno.size());
      return vRetorno;
    }
    
    
  /**
   * @author: ssantana, 11/10/2005, GCC-PRE-001
   * @return Object
   * @param String sTipoCampo
   * @param String sCampo
   */
    private Object manejaCampo(String sCampo, String sTipoCampo) throws 
                                                                    Exception {
      traza("LPModificarOferta.manejaCampo(): "+sCampo);
      Object oRetorno = null; 
      
      // Long 
      if (sTipoCampo.equals("L")) {
          if (!sCampo.equals(" ")) {
            oRetorno = Long.valueOf(sCampo);
          }
      }
      
      // Integer
      if (sTipoCampo.equals("I")) { 
        if ( !sCampo.equals(" ")) {
          oRetorno = Integer.valueOf(sCampo);
        }
      }
      
      // String
      if (sTipoCampo.equals("S")) {
        if ( sCampo.equals(" ") )  {
          oRetorno = "";
        } else {
          oRetorno = sCampo;
        }
      }
      
      // Punto Salida.
      return oRetorno; 
      
    }
    
    
  /**
   * @author: ssantana, 11/10/2005, GCC-PRE-001
   * @throws java.lang.Exception
   * @return DTOProducto
   * @param DTOProducto dto
   */
    private DTOProducto obtieneRestoDatosProducto(DTOProducto dto, String sCodigo) 
                                                                    throws Exception {
       traza("LPModificarOferta.obtieneRestoDatosProducto()");
       DTOOferta dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
       Vector v = dtoOferta.getDetalleOferta();
       
       UtilidadesLog.debug(v);
       
       DTODetalleOferta dtoDetalleOferta = 
                                    this.obtieneDetalleOfertaAUsar(sCodigo, v);
       
       Long lOidSAP = dtoDetalleOferta.getOidSAP();
       Integer iPosicionPagina = dtoDetalleOferta.getPosicionPagina(); 
       Boolean bDigitable = dtoDetalleOferta.getDigitable();
       Boolean bImprimible = dtoDetalleOferta.getImpresionGP();
       Integer iUEstimadas = dtoDetalleOferta.getUnidadesEstimadas();
       Integer ipagCata = dtoDetalleOferta.getPaginaCatalogo();
       BigDecimal bigPrecioCata = dtoDetalleOferta.getPrecioCatalogo();
       BigDecimal bigVentaNEstimada = dtoDetalleOferta.getVentaNetaEstimada();
       BigDecimal bigPrecioPos = dtoDetalleOferta.getPrecioPosicionamiento();
       BigDecimal bigCosteEstandar = dtoDetalleOferta.getCosteEstandar();
       Long lOidCatalogo = dtoDetalleOferta.getOidCatalogo();
       Long lOidCondPromocion = dtoDetalleOferta.getOidCondicionPromocion();
       Long lOidTipoOferta = dtoDetalleOferta.getOidTipoOferta();
       Long lOidCicloVida = dtoDetalleOferta.getOidCicloVida();
       String sCentro = dtoDetalleOferta.getCentro();
       String sTextoBreve = dto.getDescripcionSAP();//obtenido de la lista editable
       Long lCodigoProgramaFid = dtoDetalleOferta.getProgramaFidelizacion();
       Long lVariante = dtoDetalleOferta.getVariantes();
       Integer iPuntajeFijo = dtoDetalleOferta.getPuntajeFijo();
	   /*inicio enozigli COL-PRE-002*/
       Vector rangosPrecios = dtoDetalleOferta.getRangosPrecios();
	   /*fin enozigli COL-PRE-002*/

       dto.setOid(lOidSAP);
       dto.setPosicionPagina(iPosicionPagina);
       dto.setDigitable(bDigitable);
       dto.setImprimible(bImprimible);
       dto.setUnidadesEstimadas(iUEstimadas);
       dto.setVentaNetaEstimada(bigVentaNEstimada);
       dto.setPrecioPosicionamiento(bigPrecioPos);
       dto.setCosteEstandar(bigCosteEstandar);
       dto.setOidCatalogo(lOidCatalogo);
       dto.setOidCondicionPromocion(lOidCondPromocion);
       dto.setOidTipoOferta(lOidTipoOferta);
       dto.setOidCicloVida(lOidCicloVida);
       dto.setCentro(sCentro);
       dto.setPrecioCatalogo(bigPrecioCata);  
       dto.setPaginaCatalogo(ipagCata);  
       dto.setTextoBreve(sTextoBreve);
       //enozigli 25/10/2005 club priviledges
       dto.setProgramaFidelizacion(lCodigoProgramaFid);
       dto.setVariantes(lVariante);
       dto.setPuntajeFijo(iPuntajeFijo);
       //fin enozigli 25/10/2005 club priviledges

		/*inicio enozigli COL-PRE-002*/
	   dto.setRangosPrecios(rangosPrecios);
	   /*fin enozigli COL-PRE-002*/
       
       //  Agregado por HRCS - Fecha 19/03/2007 - Incidencia SICC 20070106
       dto.setSecuencial( dtoDetalleOferta.getSecuencial() );
       
       Boolean ppal = dtoDetalleOferta.getProductoPrincipal();
       if (ppal!=null&&ppal.equals(Boolean.TRUE)){       
            conectorParametroSesion("productoprincipal", new Boolean(true));
            traza("Se va a buscar productos principal");            
       }else{
            conectorParametroSesion("productoprincipal", new Boolean(false));
            traza("Se va a buscar productos aociado");            
       }
       
       return dto;

    }
    
    
  /**
   * @author: ssantana, 12/10/2005, GCC-PRE-001
   * @return Vector
   * @param String sCadenaCodigo
   */
    private Vector parseaCodigosSeleccionados(String sCadenaCodigos) 
                                                              throws Exception{
      /*
       * Recibe una cadena del formato [codigo1,codigo2,codigo3,...]
       * que representa los campos ocultos seleccionados en la ListaEditable. 
       * Retorna un Vector donde cada elemento es un código, en String.
       */
      Vector vRetorno = new Vector(); 
      
      // Quito los corchetes.
      sCadenaCodigos = sCadenaCodigos.substring(0, sCadenaCodigos.length()-1);
      sCadenaCodigos = sCadenaCodigos.substring(1, sCadenaCodigos.length());
      traza("sCadenaCodigos al momento: " + sCadenaCodigos);
      
      // Pueblo el Vector.
      StringTokenizer sTokCodigos = new StringTokenizer(sCadenaCodigos, ",");
      while (sTokCodigos.hasMoreTokens()) {
         String sCodigo = sTokCodigos.nextToken();
         vRetorno.add(sCodigo);
      }
      
      return vRetorno;
    }
    
    
  /**
   * @author: ssantana, 12/10/2005
   * @throws java.lang.Exception
   * @return DTODetalleOFerta
   * @param String sCodigo
   */
    private DTODetalleOferta obtieneDetalleOfertaAUsar(String sCodigo, 
                                                       Vector vDetallesOferta) throws 
                                                                               Exception {
       /*
        * En base a "sCodigo" podemos determinar el DetalleOferta a utilizar. 
        * Si sCodigo comienza con "p" entonces es un oid de Producto. Hay que buscar
        * el DetalleOferta que coincida con ese producto. 
        * Si no, es el Oid de un Detalle Oferta. 
        */
       traza("LPModificarOferta.obtieneDetalleOfertaAUsar()");
       DTODetalleOferta dtoDetalleOferta = null;
       
       // Quitamos los "[" y "]".      
       /*sCodigo = sCodigo.substring(0, sCodigo.length()-1);
       sCodigo = sCodigo.substring(1, sCodigo.length());*/

       String primerCaracter = new String(sCodigo.substring(0,1));
       traza("sCodigo: " + sCodigo);
       if (primerCaracter.equals("p") ) {
          // --- Es un producto ---
          // Quitamos la "p" para quedarnos con el Oid del Producto. 
          String oidCodigo = sCodigo.substring(1);
          
          //    Modificado por HRCS - Fecha 28/03/2007 - Incidencia Sicc20070106
          //traza("oidCodigo"+oidCodigo);
          //dtoDetalleOferta = this.obtieneDetalleOfertaPorOidProducto(Long.valueOf(oidCodigo), vDetallesOferta);
          traza("Secuencial: "+oidCodigo);
          boolean match=false;
          DTODetalleOferta dtoDetallerOfertaBuffer = null;
          for(int i=0; i<vDetallesOferta.size() && !match; i++) {

            dtoDetallerOfertaBuffer = (DTODetalleOferta) vDetallesOferta.get(i);
            int secuencial = dtoDetallerOfertaBuffer.getSecuencial().intValue();
            if (Integer.parseInt(oidCodigo)==secuencial) {
                Long oidProducto = dtoDetallerOfertaBuffer.getOidSAP();
                traza("oidProducto: "+oidProducto.toString());
                dtoDetalleOferta = this.obtieneDetalleOfertaPorOidProducto(oidProducto, vDetallesOferta);
                match = true;
            }
          }
       } else {
          // --- Es el Oid del DetalleOferta ---
          dtoDetalleOferta = this.obtieneDetalleOfertaPorOid(Long.valueOf(sCodigo), 
                                                             vDetallesOferta);
       }
       return dtoDetalleOferta;
       
    }
    
    
  /**
   * @author: ssantana, 12/10/2005, PRE-GCC-001
   * @throws java.lang.Exception
   * @return DTODetalleOferta
   * @param Long oid
   * @param Vector vDetallesOferta
   */
    private DTODetalleOferta obtieneDetalleOfertaPorOid(Long oid, Vector vDetallesOferta) 
                                                                          throws Exception {
      /*
       * Recorre el Vector de DTODetallesOfertas y retorna aquél que posee el oid
       * que se indica en "oid". Si no encuentra coincidencia, retorna null (no 
       * debería pasar)
       */
       
      traza("LPModificarOferta.obtieneDetalleOfertaPorOid()");
      DTODetalleOferta dtoDetalleOfertaRetorno = null;
      DTODetalleOferta dtoDetalleOfertaBuffer = null;
      Long oidDetalleOfertaDTO = null;
      int longVector = vDetallesOferta.size();
      boolean bMatch = false;
      traza("ACA");
      for (int i = 0; (i < longVector) && (!bMatch); i++) {
        traza("Bucle " + i);
        dtoDetalleOfertaBuffer = (DTODetalleOferta) vDetallesOferta.get(i);
        oidDetalleOfertaDTO = dtoDetalleOfertaBuffer.getOidDetalleOferta();
        String tipoOperacion = dtoDetalleOfertaBuffer.getTipoOperacion();
        traza("Compara...");
        if ( oid.equals(oidDetalleOfertaDTO) && (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(tipoOperacion))) {
          traza("match");
          bMatch = true;
          dtoDetalleOfertaRetorno = dtoDetalleOfertaBuffer;          
        }
      }
      
      return dtoDetalleOfertaRetorno;
    }
    
    
  /**
   * @author: ssantana, 12/10/2005
   * @throws java.lang.Exception
   * @return DTODetalleOferta
   * @param Vector vDetallesOferta
   * @param Long oid
   */
    private DTODetalleOferta obtieneDetalleOfertaPorOidProducto(Long oid, 
                                                                Vector vDetallesOferta)
                                                              throws Exception {
       traza("LPModificarOferta.obtieneDetalleOfertaPorOidProducto()");
       DTODetalleOferta dtoDetalleOferta = null;
       DTODetalleOferta dtoDetallerOfertaBuffer = null;
       Long oidProducto = null;
       int longVector = vDetallesOferta.size();
       boolean bMatch = false;
       
       for (int i = 0; (i < longVector) && (!bMatch); i++) {
          dtoDetallerOfertaBuffer = (DTODetalleOferta) vDetallesOferta.get(i);
          oidProducto = dtoDetallerOfertaBuffer.getOidSAP();
          String tipoOperacion = dtoDetallerOfertaBuffer.getTipoOperacion();
          
          if ( oidProducto.equals(oid) && (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(tipoOperacion))) {
             bMatch = true;
             dtoDetalleOferta = dtoDetallerOfertaBuffer;
          }
       }
       return dtoDetalleOferta;
    }

  private void productoModificado() throws Exception {
        traza("Volvi de Insertar Datos Producto (modificacion)");
        DTOOferta dtoO = (DTOOferta) conectorParametroSesion("DTOOferta");
        DTOSCargarCriteriosDefinirOferta dtoCCriterioDefOfer = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
      
        Hashtable htpOf = null;
        htpOf = (Hashtable) conectorParametroSesion("Productos");
        Enumeration enProd = htpOf.elements();

        //Busca el producto principal activo para modificarlo.
        if (conectorParametroSesion("productoprincipal")!=null&&((Boolean)conectorParametroSesion("productoprincipal")).booleanValue()){
            Enumeration el = dtoO.getDetalleOferta().elements();
            traza("Se modifico el producto principal");
            while(el.hasMoreElements()) { 
                DTODetalleOferta dtoPOf = (DTODetalleOferta) el.nextElement();
                if ((dtoPOf.getProductoPrincipal().booleanValue())&&
                    (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoPOf.getTipoOperacion()))) {
                    DTOProducto dtoP = (DTOProducto) enProd.nextElement();
                    dtoPOf = modificarProductoActual(dtoPOf, dtoP);
                    traza("producto principal:"+dtoPOf.getOidSAP());
                    traza("tipo operacion:"+dtoPOf.getTipoOperacion());
                }
            }            
        } else {
            Enumeration el = dtoO.getDetalleOferta().elements();
            traza("Se modificaron el productos asociados");
            while (enProd.hasMoreElements()){
                DTOProducto dtoP = (DTOProducto) enProd.nextElement();
                while (el.hasMoreElements()) {
                    DTODetalleOferta dtoPOf = (DTODetalleOferta) el.nextElement();
                    if ( (dtoP.getOid().equals(dtoPOf.getOidSAP())) &&
                         (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoPOf.getTipoOperacion())) &&
                         (dtoPOf.getSecuencial().intValue()==dtoP.getSecuencial().intValue())   //  Agregado por HRCS - Fecha 21/03/2007 - Incidencia Sicc20070106
                       )    {
                        dtoPOf = modificarProductoActual(dtoPOf, dtoP);
                        traza("producto asociado:"+dtoPOf.getOidSAP());
                        traza("tipo operacion:"+dtoPOf.getTipoOperacion());
                    }
                }
            }
        }
        
        Vector vec = dtoO.getDetalleOferta();
        cargaProductosInicial(vec, dtoCCriterioDefOfer.getTiposOferta(), dtoCCriterioDefOfer.getCiclosVida()/*, false, "listado2"*/);
        conectorParametroSesion("DTOOferta", dtoO);
    }      
    
    private DTODetalleOferta modificarProductoActual(DTODetalleOferta dtoD, DTOProducto dtoE) throws Exception{
        Long oidDetalleOferta = dtoD.getOidDetalleOferta();
        if (oidDetalleOferta != null ) {
          dtoD.setTipoOperacion(ConstantesPRE.OPERACION_MODIFICACION);
        } else {
          //se setea alta porque se inserto en un ciclo anterior y aun no existe en BD                      
          String sTipoOperacion = dtoD.getTipoOperacion();
          if(ConstantesPRE.OPERACION_ALTA.equals(sTipoOperacion)){
            dtoD.setTipoOperacion(ConstantesPRE.OPERACION_ALTA);
          }
        }
        //copio el resto de los datos
        dtoD.setAtributo1(dtoE.getAtributo1());
        dtoD.setAtributo2(dtoE.getAtributo2());
        dtoD.setAtributo3(dtoE.getAtributo3());
        dtoD.setCentro(dtoE.getCentro());
        dtoD.setCodigoSAP(dtoE.getCodigoSAP());
        dtoD.setDescripcion(dtoE.getTextoBreve());
        dtoD.setCosteEstandar(dtoE.getCosteEstandar());
        dtoD.setFactorRepeticion(dtoE.getFactorRepeticion());
        dtoD.setImpresionGP(dtoE.getImprimible());
        dtoD.setDigitable(dtoE.getDigitable());
        dtoD.setOidSAP(dtoE.getOid());
        dtoD.setOidCicloVida(dtoE.getOidCicloVida());
        dtoD.setOidCondicionPromocion(dtoE.getOidCondicionPromocion());
        dtoD.setOidCatalogo(dtoE.getOidCatalogo());
        dtoD.setOidTipoOferta(dtoE.getOidTipoOferta());
        dtoD.setPaginaCatalogo(dtoE.getPaginaCatalogo());
        dtoD.setPrecioCatalogo(dtoE.getPrecioCatalogo());
        dtoD.setPrecioPosicionamiento(dtoE.getPrecioPosicionamiento());
        dtoD.setUnidadesEstimadas(dtoE.getUnidadesEstimadas());
        //enozigli 25/10/2005 club priviledges
        dtoD.setProgramaFidelizacion(dtoE.getProgramaFidelizacion());
        dtoD.setVariantes(dtoE.getVariantes());
        dtoD.setPuntajeFijo(dtoE.getPuntajeFijo());
        //fin enozigli 25/10/2005 club priviledges
        //cambio enozigli 06/03/2006 inc. 22718 
        dtoD.setMatrizFacturacionGenerada(Boolean.FALSE);
        //fin cambio enozigli 06/03/2006 inc. 22718 
        dtoD.setOrigen(ConstantesPRE.MF);
        dtoD.setCentro(dtoE.getCentro());

		/*inicio enozigli COL-PRE-002*/
        dtoD.setRangosPrecios(dtoE.getRangosPrecios());
		/*fin enozigli COL-PRE-002*/

        dtoD.setVentaNetaEstimada(dtoE.getVentaNetaEstimada());
        Boolean esPrincipal = (Boolean)conectorParametroSesion("productoprincipal");
        traza("tipo de producto:"+esPrincipal);
        if (esPrincipal!=null&&esPrincipal.booleanValue())
            dtoD.setProductoPrincipal(Boolean.TRUE);
        else
            dtoD.setProductoPrincipal(Boolean.FALSE);        
        return dtoD;
    }
    
    private boolean tieneP(String cadena){
      String s = cadena.substring(0,1);      
      return (s.equals("p"));
    }
    
    // Agregado por SICC20070316 - Rafael Romero - 19/07/2007
    private void obtenerProductos() throws Exception{

        Hashtable hshProductos = new Hashtable();
        DTOProducto dtoProdu = null;
        Long oidProdu = null;
        Vector vDTOs = null;
        Vector vOidProductos = null;
        Vector vCodigosSeleccionados = null;
        
        String hidListaEditable = this.conectorParametro("hidListaEditable");
        UtilidadesLog.debug("hidListaEditable: " + hidListaEditable);
        String sCadenaCodigos = this.conectorParametro("hidCodSeleccionadosLE");
        UtilidadesLog.debug("hidCodSeleccionadosLE: " + sCadenaCodigos);
        
        // Obtengo los DTOProductos con los datos mínimos segun lo que figura en 
        // la Lista Editable correspondiente. 
        vDTOs = this.parseaListaEditableProductos(hidListaEditable);
        
        // Obtengo el Vector con los Códigos ocultos del elemento seleccionado en la lista. 
        // Estos codigos nos permitirán determinar qué DetalleOferta usar para 
        // obtener los datos restantes del producto. 
        vCodigosSeleccionados = this.parseaCodigosSeleccionados(sCadenaCodigos);
        
        UtilidadesLog.debug("Pongo todos los DTOs en el Hashtable y armo Vector oidsProducto.");
        
        vOidProductos = new Vector(); 
        for (int i = 0; i < vDTOs.size(); i++) {
          dtoProdu = (DTOProducto) vDTOs.get(i);
          // Obtengo el Codigo que nos permitirá saber que DTODetalleOferta usar. 
          String sCodigoActual = (String) vCodigosSeleccionados.get(i);
          
          // Obtengo los datos restantes del Producto. 
          dtoProdu = this.obtieneRestoDatosProducto(dtoProdu, sCodigoActual);
          
          oidProdu = dtoProdu.getOid();
        
          hshProductos.put(oidProdu, dtoProdu);
          vOidProductos.add(oidProdu);
        }
        // Pongo el Hashtable y el Vector en sesión
        UtilidadesLog.debug("Hecho. Ahora todo a la sesión");
        this.conectorParametroSesion("Productos", hshProductos);
        this.conectorParametroSesion("oidProductos", vOidProductos);
    
    }
    
    private void consultarProducto() throws Exception {
       UtilidadesLog.debug("LPModificarOferta.consultarProducto(): Inicio");
       this.obtenerProductos();
       this.conectorAction("LPDatosProducto");
       if (conectorParametroSesion("productoprincipal")!=null&&((Boolean)conectorParametroSesion("productoprincipal")).booleanValue()){
          conectorActionParametro("multiseleccion", "false");
       } else {
          conectorActionParametro("multiseleccion", "true");
       }       
       this.conectorActionParametro("accion", "");
       this.conectorActionParametro("lpRetorno", "LPModificarOferta");       
       this.conectorActionParametro("tipoOperacion", "consulta");
       UtilidadesLog.debug("LPModificarOferta.consultarProducto(): Fin");
    }
    // fin agregado SICC20070316
    
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322

 private void cargarRegiones(Long oidMarca, Long oidCanal)
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

	DTOSalida dtosalida = new DTOSalida();
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dto);
        vector.add(new MareBusinessID("ZONObtenerRegionesPorPais"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConector(dtosalida.getResultado(), "dtoSalida", "OID", "DESCRIPCION", "MARCA", "CANAL", null, null);
        asignar("COMBO", "cbRegion", druidaconector, "dtoSalida");
    }

    private void cargarZonas(Long oidMarca, Long oidCanal)
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOUnidadAdministrativa dtounidadadministrativa = new DTOUnidadAdministrativa();
        dtounidadadministrativa.setOidIdioma(idioma);
        dtounidadadministrativa.setOidPais(pais);
        dtounidadadministrativa.setOidMarca(oidMarca);
        dtounidadadministrativa.setOidCanal(oidCanal);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dtounidadadministrativa);
        vector.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConectorZona(dtosalida.getResultado(), "dtoSalida", "OID_ZONA","DES_ZONA", "ZORG_OID_REGI", "MARCA", "CANAL", null);
        asignar("COMBO", "cbZona", druidaconector, "dtoSalida");
    }

    private DruidaConector generaConector(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
		StringBuffer arrRegiones = new StringBuffer();
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }

			arrRegiones.append(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
			arrRegiones.append("&");
			arrRegiones.append(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
			arrRegiones.append("|");
        }

		asignarAtributo("VAR", "arrRegiones", "valor", arrRegiones.toString());

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
  private DruidaConector generaConectorZona(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
		StringBuffer arrZonas = new StringBuffer();
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            ///// OJO  SUMA DE STRINGS
			org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString()+"x"+recordset.getValueAt(i, s3).toString()  : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
			arrZonas.append(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
			arrZonas.append("&");
			arrZonas.append(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
			arrZonas.append("&");
			arrZonas.append(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
			arrZonas.append("|");
        }

		asignarAtributo("VAR", "arrZonas", "valor", arrZonas.toString());
        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
}
