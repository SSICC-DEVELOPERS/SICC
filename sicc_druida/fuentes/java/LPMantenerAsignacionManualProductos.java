/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import es.indra.sicc.dtos.ape.DTOValidacionProductoAnaquel;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


public class LPMantenerAsignacionManualProductos extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPMantenerAsignacionManualProductos() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - ejecucion ***");
      
        try {
            setTrazaFichero();

            accion = conectorParametroLimpia("accion", "", true);
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
            traza("  accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + 
                  " / idioma: " + oidIdioma);
            
            if (accion.equals("") && opcionMenu.equals("asignar")) {
                cargarPGAsignarProductosAnaquelesManual();
                Long oidCDPorDefecto = obtenerCDPorDefecto();
                cargarCombos(oidCDPorDefecto);
                
            } else if (accion.equals("guardar")) {
                guardar();
                
            } else if (accion.equals("desasignar")) {
                mostarDatosDesasignar();
            
            } else if (accion.equals("eliminarAsignaciones")) {
                eliminarAsignacionesProductoAnaquel();
                
            } else if (accion.equals("validarProductoAnaquel")) {
                 validarProductoAnaquel();
                 
            } else if (accion.equals("nuevaVersion")) {
                 // Tomamos los valores de la cabecera desde contenido_manual_productos_anaqueles_asignar
                 String strOidMapaCD = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
                 String strOidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
                 
                 cargarPGAsignarVersionProductosAnaqueles();
                 
                 asignarAtributo("VAR", "hOidMapaCentroDistribucion", "valor", strOidMapaCD);
                 asignarAtributo("VAR", "hOidPeriodo",                "valor", strOidPeriodo);
            
            } else if (accion.equals("validarNuevaVersion")) {
                 validarNuevaVersion();
            }
            
        } catch (Exception e) {
            traza(" --- Excepcion - LPMantenerAsignacionManualProductos");
            logStackTrace(e);
            traza(" --- accion: " + accion + " / opcionMenu: " + opcionMenu + 
                  " / pais: " + oidPais + " / idioma: " + oidIdioma);
            
            if (accion.equals("guardar") && opcionMenu.equals("asignar")) {
                cargarPGAsignarProductosAnaquelesManual();
                
                asignarAtributo("VAR", "defaultOidComboCD", "valor", conectorParametro("defaultOidComboCD"));
                asignarAtributo("VAR", "hListado1", "valor", conectorParametro("hListado1"));

                String oidCD = conectorParametro("cbCentroDistribucion");
                String oidMapaCD = conectorParametro("cbMapaCentro");
                String oidMarca = conectorParametro("cbMarca");
                String oidCanal = conectorParametro("cbCanal");
                String oidPeriodo = conectorParametro("cbPeriodo");
                String oidVersion = conectorParametro("cbVersion");
                
                cargarCombosLuegoError(new Long(oidCD), new Long(oidMapaCD), 
                                       new Long(oidMarca), new Long(oidCanal), new Long(oidPeriodo));
                
                asignarAtributo("VAR", "restauraOidCD",        "valor", oidCD);
                asignarAtributo("VAR", "restauraOidMapaCD",    "valor", oidMapaCD);
                asignarAtributo("VAR", "restauraOidMarca",     "valor", oidMarca);
                asignarAtributo("VAR", "restauraOidCanal",     "valor", oidCanal);
                asignarAtributo("VAR", "restauraOidPeriodo",   "valor", oidPeriodo);
                asignarAtributo("VAR", "restauraOidVersion",   "valor", oidVersion);
                
                
                RecordSet rListaAsignacion = this.parseaLista(conectorParametro("hListado1"));
                traza("... RecordSet para la recarga del listado_" + rListaAsignacion);
                DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                        rListaAsignacion,
                                                                        rListaAsignacion.getColumnIdentifiers());
                asignar("LISTADOA", "listado1", con, "rowset");
            }
            
            lanzarPaginaError(e);
        }
           
        traza("*** Salida  - LPMantenerAsignacionManualProductos - ejecucion ***");
    }


    public void guardar() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - guardar ***");
       
        String strCDPorDefecto = conectorParametroLimpia("defaultOidComboCD", "", true);
        Long oidCDPorDefecto = (strCDPorDefecto.equals(""))? null : new Long(strCDPorDefecto);

        DTOMantenerAsignacionProductosAnaqueles dto = new DTOMantenerAsignacionProductosAnaqueles();

        String sOidAsignacion = conectorParametroLimpia("cbVersion", "", true);
        Long oidAsignacion = new Long(sOidAsignacion);
        dto.setOidAsignacionProductoAnaquel(oidAsignacion);

        String strListadoDetalle = conectorParametroLimpia("hListado1", "", true);
        traza(" --> ENTRADA hListado1 (String XML)_" + strListadoDetalle);         
        RecordSet rsListado = parseaLista(strListadoDetalle);
        traza(" --> SALIDA  hListado1 (RecordSet)_" + rsListado);
        ArrayList listaAsignacion = crearEstructuraConDtos(rsListado);
        dto.setLstValidacionProductoAnaquel(listaAsignacion);
        traza("... el DTOMantenerAsignacionProductosAnaqueles a enviar para Guardar es: " + dto);
        
        MareBusinessID businessID = new MareBusinessID("APEGuardarAsignacionProductosAnaqueles");
        
        Vector parametros = new Vector();
        parametros.add(dto);  
        parametros.add(businessID);
        
        conectar("ConectorGuardarAsignacionProductosAnaqueles", parametros);
        
        cargarPGAsignarProductosAnaquelesManual();
        asignarAtributo("VAR", "defaultOidComboCD", "valor", (oidCDPorDefecto != null)? oidCDPorDefecto.toString() : "");
        cargarCombos(oidCDPorDefecto);
        
        traza("*** Salida  - LPMantenerAsignacionManualProductos - guardar ***");        
    }


    public void validarProductoAnaquel() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - validarProductoAnaquel ***");
        
        // Preparo la pagina generica, necesaria para mostrar las Excepciones del método servidor 
        pagina("salidaGenerica");
        
        String codFilaAValidar = conectorParametroLimpia("hCodFilaAValidar", "", true);
        
        try { 
            String strOidAsignacion = conectorParametroLimpia("cbVersion", "", true);
            String strOidMapaCD = conectorParametroLimpia("cbMapaCentro", "", true);
            String strOidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
            String codAnaquel = conectorParametroLimpia("hCodAnaquelAValidar", "", true);
            String codProducto = conectorParametroLimpia("hCodProductoAValidar", "", true);
            String botonPresionado = conectorParametroLimpia("hBotonPresionado", "", true);
    
            DTOMantenerAsignacionProductosAnaqueles dtoAValidar = new DTOMantenerAsignacionProductosAnaqueles();
            dtoAValidar.setOidPais(oidPais);
            dtoAValidar.setOidAsignacionProductoAnaquel(new Long(strOidAsignacion));  // Este dato no se esta utilizando en parte Server (oidMapaCD alcanza)
            dtoAValidar.setOidMapaCentroDistribucion(new Long(strOidMapaCD));
            dtoAValidar.setOidPeriodo(new Long(strOidPeriodo));
            dtoAValidar.setCodigoAnaquel(codAnaquel);
            dtoAValidar.setCodigoProducto(codProducto);
    
            // Envio la lista detalle solamente con un elemento (la linea a validar).
            DTOValidacionProductoAnaquel dtoFilaDetalle = new DTOValidacionProductoAnaquel();
            dtoFilaDetalle.setCodigoValidacion(codFilaAValidar); // identificador de la fila en proceso de validacion perteneciente al listado1 de la pagina
            dtoFilaDetalle.setCodigoAnaquel(codAnaquel);
            dtoFilaDetalle.setCodigoProducto(codProducto);
            ArrayList detalleAsignaciones = new ArrayList(1);
            detalleAsignaciones.add(dtoFilaDetalle);
            dtoAValidar.setLstValidacionProductoAnaquel(detalleAsignaciones);
            
            MareBusinessID businessID = new MareBusinessID("APEValidarAsignacionProductosAnaqueles");
            
            Vector parametros = new Vector();
            parametros.add(dtoAValidar);  
            parametros.add(businessID);
           
            DruidaConector druidaconector = conectar("ConectorValidarAsignacionProductosAnaqueles", parametros);
            
            DTOMantenerAsignacionProductosAnaqueles  dtoValidado = (DTOMantenerAsignacionProductosAnaqueles)druidaconector.objeto("DTOMantenerAsignacionProductosAnaqueles");
            traza("... la validacion de la linea de Detalle resulto: " + dtoValidado);
            DTOValidacionProductoAnaquel dtoFilaDetalleValidada = (DTOValidacionProductoAnaquel)dtoValidado.getLstValidacionProductoAnaquel().get(0);
            
            Long oidAnaquel = dtoFilaDetalleValidada.getOidAnaquel();
            Long oidProducto = dtoFilaDetalleValidada.getOidProducto();
            codAnaquel = dtoFilaDetalleValidada.getCodigoAnaquel();         // No debería pisarlo, pero por seguridad lo voy a hacer.
            codProducto = dtoFilaDetalleValidada.getCodigoProducto();       // Idem.
            codFilaAValidar = dtoFilaDetalleValidada.getCodigoValidacion(); // Idem.
            Long unidEstimadas = dtoFilaDetalleValidada.getUnidadesEstimadas(); // Idem.
            
            asignarAtributo("VAR", "ejecutar", "valor", "filaDetalleValidadaOk('"+ codFilaAValidar +"', '"+ codAnaquel +"', '"+ codProducto 
                                                                                +"', "+ oidAnaquel +", "+ oidProducto +", "+ unidEstimadas +", '"+ botonPresionado +"')");
            
            traza("*** Salida  - LPMantenerAsignacionManualProductos - validarProductoAnaquel ***");
            
        } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "focalizaLineaValidar('" + codFilaAValidar + "');");
           throw e;
        }
    }


    public void validarNuevaVersion() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - validarNuevaVersion ***");
        
        pagina("salidaGenerica");

        try {
            String strDescVersion = conectorParametroLimpia("txtVersion", "", true);
            String strOidMapaCentro = conectorParametroLimpia("hOidMapaCentroDistribucion", "", true);
            String strOidMapaZona = conectorParametroLimpia("cbMapaZonas", "", true);
            String strOidPeriodo = conectorParametroLimpia("hOidPeriodo", "", true);
            
            DTOMantenerAsignacionProductosAnaqueles dto = new DTOMantenerAsignacionProductosAnaqueles();
            dto.setVersion(strDescVersion);
            dto.setOidMapaCentroDistribucion(new Long(strOidMapaCentro));
            dto.setOidMapaZona(new Long(strOidMapaZona));
            dto.setOidPeriodo(new Long(strOidPeriodo));
            
            MareBusinessID businessID = new MareBusinessID("APEValidarNuevaVersionAsignacion");
            
            Vector parametros = new Vector();
            parametros.add(dto);  
            parametros.add(businessID);
            
            DruidaConector druidaconector = conectar("ConectorValidarNuevaVersionAsignacion", parametros);
            
            DTOOID dtoOidNuevaVersion = (DTOOID)druidaconector.objeto("DTOOID");
            traza(" el DTOOID luego de validar la version: " + dtoOidNuevaVersion);
            
            asignarAtributo("VAR", "ejecutar", "valor", "ejecutarOK('" + dtoOidNuevaVersion.getOid() + "','"+ strDescVersion +"');");
            
        } catch(Exception e) {
            traza(" Error al validar Nueva Version: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", "fLimpiar();");
            throw e;
        }
        traza("*** Salida  - LPMantenerAsignacionManualProductos - validarNuevaVersion ***");
    }

    public void eliminarAsignacionesProductoAnaquel() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - eliminarAsignacionesProductoAnaquel ***");
        
        pagina("salidaGenerica");
        
        try {
            String strOidsAEliminar = conectorParametroLimpia("hOidsDetallesAEliminar", "", true);
            traza(" los oid a eliminar son: " + strOidsAEliminar);

            // Armamos el DTOOIDs con todos los oids seleccionados en el cbRegion
            StringTokenizer stk = new StringTokenizer(strOidsAEliminar, ",");
            int cantDetalles = stk.countTokens();
            Long oidsDetalles[] = new Long[cantDetalles];
            DTOOIDs dtoOids = new DTOOIDs();
            String strOidAsignacionDetalle;
            traza("                - cantidad AsignacionesProdAnaqDetalle a eliminar: " + cantDetalles);
            
            for (int i = 0; i < cantDetalles; i++) {
                strOidAsignacionDetalle = stk.nextToken();
                traza("                  " + strOidAsignacionDetalle);
                oidsDetalles[i] = new Long(strOidAsignacionDetalle);
            }
            
            dtoOids.setOids(oidsDetalles);
            
            MareBusinessID businessID = new MareBusinessID("APEEliminarAsignacionProductosAnaqueles");
            
            Vector parametros = new Vector();
            parametros.add(dtoOids);  
            parametros.add(businessID);
            
            conectar("ConectorEliminarAsignacionProductosAnaqueles", parametros);
            
            traza("... las asignaciones seleccionadas fueron eliminadas");
            asignarAtributo("VAR", "ejecutar", "valor", "mensajeEliminacionExitosa();");
            
        } catch(Exception e) {
            traza("*** Error al eliminar asignaciones de producto/anaquel (detalle): " + e);
            throw e;
        }
        traza("*** Salida  - LPMantenerAsignacionManualProductos - eliminarAsignacionesProductoAnaquel ***");
    }


    public void mostarDatosDesasignar() throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - mostarDatosDesasignar ***");
        
        // Objeto pasado a ventana modal
        String strOidVersion = conectorParametroLimpia("oidVersion", "", true);
        traza(" *** el oid de la Cabecera de Asignacion cuyos detalles eliminaremos es_" + strOidVersion);
        String descCentroDistribucion = conectorParametroLimpia("descCentroDistribucion", "", true);
        String descMapaCentroDistribucion = conectorParametroLimpia("descMapaCentroDistribucion", "", true);
        String descMapaZona = conectorParametroLimpia("descMapaZona", "", true);
        String descMarca = conectorParametroLimpia("descMarca", "", true);
        String descCanal = conectorParametroLimpia("descCanal", "", true);
        String descPeriodo = conectorParametroLimpia("descPeriodo", "", true);
        String descVersion = conectorParametroLimpia("descVersion", "", true);
        
        cargarPGDesasignarProductosAnaqueles();
        
        asignarAtributo("VAR", "oidAsignacionProductoAnaquel", "valor", strOidVersion); // Es el oid de cabecera de asignacion prod/anaq
        // Mapeo las descripciones obtenidas desde el objeto pasado a ventana modal
        asignarAtributo("LABELC", "lblCentroDistribucionDat", "valor", descCentroDistribucion);
        asignarAtributo("LABELC", "lblMapaCentroDistribucionDat", "valor", descMapaCentroDistribucion);
        asignarAtributo("LABELC", "lblMapaZonaDat", "valor", descMapaZona);
        asignarAtributo("LABELC", "lblMarcaDat", "valor", descMarca);
        asignarAtributo("LABELC", "lblCanalDat", "valor", descCanal);
        asignarAtributo("LABELC", "lblPeriodoDat", "valor", descPeriodo);
        asignarAtributo("LABELC", "lblVersionDat", "valor", descVersion);
        
        traza("*** Salida  - LPMantenerAsignacionManualProductos - mostarDatosDesasignar ***");
    }


    private void cargarPGAsignarProductosAnaquelesManual() throws Exception {
        pagina("contenido_manual_productos_anaqueles_asignar");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPMantenerAsignacionManualProductos", "asignar");
               
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
    }


    private void cargarPGDesasignarProductosAnaqueles() throws Exception {
        pagina("contenido_productos_desasignar");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPMantenerAsignacionManualProductos", "desasignar");
        //asignarAtributoPagina("cod","0967");
               
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());

        // eiraola - 11/Jun/2007 - Por Inc. 490 ya no se permite cambiar de orden (default es cod producto sap ascendente)
        //asignarAtributo("VAR", "SIN_ORDEN",  "valor", ConstantesAPE.SIN_ORDEN.toString());
        //asignarAtributo("VAR", "ORDEN_POR_ANAQUEL",  "valor", ConstantesAPE.ORDEN_POR_ANAQUEL.toString());
        //asignarAtributo("VAR", "ORDEN_POR_PRODUCTO",  "valor", ConstantesAPE.ORDEN_POR_PRODUCTO.toString());
    }


    private void cargarPGAsignarVersionProductosAnaqueles() throws Exception {
        pagina("contenido_version_asignar");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPMantenerAsignacionManualProductos", "version");
        
        asignarAtributo("VAR", "casoDeUso",  "valor", "AsignacionManualProductos");
        
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
        
        traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("despues del conector");
        DruidaConector resultados = conector.getConector();
        
        asignar("COMBO","cbMapaZonas",resultados,"APEObtenerMapaZonaPorMapaCD");  
    }
    
    private ComposerViewElementList crearParametrosEntrada() throws Exception{
    
      String oidMapaCentroDistribucion = conectorParametroLimpia("oidMapaCentroDistribucion", "", true);
      
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
      //combo codigo configuracion
      ComposerViewElement descripcionesMapasZonas = new ComposerViewElement();
  
      DTOOID dtoOid = new DTOOID();
      traza("antes de asignar al dtobelcorp");
      dtoOid.setOidPais(oidPais);
      dtoOid.setOidIdioma(oidIdioma);
      dtoOid.setOid(Long.valueOf(oidMapaCentroDistribucion));
           
      descripcionesMapasZonas.setIDBusiness("APEObtenerMapaZonaPorMapaCD");
      descripcionesMapasZonas.setDTOE(dtoOid);
           
      lista.addViewElement(descripcionesMapasZonas);
      
      return lista;
    }


    private Long obtenerCDPorDefecto() throws Exception {
        // Seteamos los valores por defecto en la pagina 'contenido_manual_productos_anaqueles_asignar'
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        Vector parametros = new Vector();
        parametros.add(dtoe);
        parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));
        
        DruidaConector conector = conectar("ConectorObtenerValoresDefecto", parametros);
        
        DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
        
        // Solo no interesa el valor default para CD (Centro de Distribucion)
        String oidCDDefault = "";
        RecordSet valoresDef = dtoSalida.getResultado();
        traza(" - - - El RecordSet de valores por Defecto contiene_" + valoresDef);
        
        int cant = valoresDef.getRowCount();
        
        for (int i = 0; i < cant; i++) {
            if(((String)(valoresDef.getValueAt(i, "COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
                traza(" *** oidCDDefault:" + valoresDef.getValueAt(i, "OID"));
                oidCDDefault = ((BigDecimal)valoresDef.getValueAt(i, "OID")).toString();
                break;
            }
        }
        asignarAtributo("VAR", "defaultOidComboCD", "valor", oidCDDefault);

        if (!oidCDDefault.equals("")) {
            return new Long(oidCDDefault);
        } else {
            traza(" *** No hay CD por defecto");
            return null;
        }
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private RecordSet parseaLista(String sXml) throws Exception {
        sXml = sXml.replaceAll("&", "&amp;");
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;         
        Node nodoRow = null;
        Node nodoCampo = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
        RecordSet rRetorno = null;
        Vector vFila = null;
        
        ArrayList posicionesOperacion = new ArrayList();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        //nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);
        // Recorro tags <ROW>
        for (int i=0; i<cantElems; i++) {
            hshAtributos = new HashMap();
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();
            
            // Si es la primer iteracion, armo la estrucutra del RecordSet 
            // con el numero de campos
            if (i == 0) {
                rRetorno = this.armarEstructuraRecordSet(cantCampos);
            }
            
            // Recorro tags <CAMPO>
            vFila = new Vector();
            for (int j=0; j<cantCampos; j++) {
                nodoCampo = nodeListCampos.item(j);
                /* sPropiedad = this.obtenerPropiedadCampo(nodoCampo);*/
                sValorCampo = this.obtenerValorCampo(nodoCampo);
                vFila.add(sValorCampo);
            }
            rRetorno.addRow(vFila);
        }
        return rRetorno;
    }


    private RecordSet armarEstructuraRecordSet(long cantCampos) throws Exception {
        RecordSet r = new RecordSet();
        Vector vCampos = new Vector();
        String sCampo = "campo_";
        
        for (int i=0; i < cantCampos; i++ ) {
            vCampos.add(sCampo + i);
        }
        //traza(" --- los nombres de columnas de la lista son: " + vCampos);
        r.setColumnIdentifiers(vCampos);
        return r;
    }


    private String obtenerValorCampo(Node nodo) throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        if (textNode != null) {
            sValorCampo = textNode.getNodeValue();
        } else {
            sValorCampo = "";
        }
        return sValorCampo;
    }


    /*private String obtenerPropiedadCampo(Node nodo) throws Exception {
        NamedNodeMap nodeMap = nodo.getAttributes();
        Node nAtributo = nodeMap.getNamedItem("nombre");
        String sValorAtributo = nAtributo.getNodeValue();
        
        return sValorAtributo;
    }*/
    // -------------------------------------------------------------------------------------------------------------------------

    private ArrayList crearEstructuraConDtos(RecordSet listadoRS) throws Exception {
        int cantFilas = listadoRS.getRowCount();
        ArrayList detallesAsignacion = new ArrayList(cantFilas);
        DTOValidacionProductoAnaquel dtoFilaDetalle;
        
        for (int i = 0; i < cantFilas; i++) {
            if (((String)listadoRS.getValueAt(i, 3)).equals("") 
                    || ((String)listadoRS.getValueAt(i, 4)).equals("")) { // No creamos el DTO si la fila no tenia los Oid
                continue;
            }
            dtoFilaDetalle = new DTOValidacionProductoAnaquel();
            
            traza("    campo idFila_" + (String)listadoRS.getValueAt(i, 0));
            dtoFilaDetalle.setCodigoValidacion((String)listadoRS.getValueAt(i, 0));
            traza("    campo CodAnaquel_" + (String)listadoRS.getValueAt(i, 1));
            dtoFilaDetalle.setCodigoAnaquel((String)listadoRS.getValueAt(i, 1));
            traza("    campo CodProducto_" + (String)listadoRS.getValueAt(i, 2));
            dtoFilaDetalle.setCodigoProducto((String)listadoRS.getValueAt(i, 2));
            traza("    campo oidAnaquel_" + (String)listadoRS.getValueAt(i, 3));
            dtoFilaDetalle.setOidAnaquel(new Long((String)listadoRS.getValueAt(i, 3)));
            traza("    campo oidProducto_" + (String)listadoRS.getValueAt(i, 4));
            dtoFilaDetalle.setOidProducto(new Long((String)listadoRS.getValueAt(i, 4)));
            // vbongiov -- BELC400000594 -- 26/07/2007
            traza("    campo unidEstimas_" + (String)listadoRS.getValueAt(i, 5));
            dtoFilaDetalle.setUnidadesEstimadas(new Long((String)listadoRS.getValueAt(i, 5)));
            
            detallesAsignacion.add(dtoFilaDetalle);
        }
        return detallesAsignacion;
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private void cargarCombosLuegoError(Long oidCD, Long oidMapaCD, Long oidMarca, 
            Long oidCanal, Long oidPeriodo) throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - cargarCombosLuegoError ***");
        
        ArrayList composerViewElements = new ArrayList();
        composerViewElements.add(this.prepararCargaCBCentroDistribucion());
        composerViewElements.add(this.prepararCargaCBMapaCentroDistribucion(oidCD));
        composerViewElements.add(this.prepararCargaCBMarca());
        composerViewElements.add(this.prepararCargaCBCanal());
        composerViewElements.add(this.prepararCargaCBPeriodo(oidMarca, oidCanal));
        composerViewElements.add(this.prepararCargaCBVersion(oidCD, oidMapaCD, oidPeriodo));
        
        DruidaConector resultados = obtenerDatosParaCombos(composerViewElements);
        
        asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cbMapaCentro",         resultados, "APEObtenerMapasCDPorCD");
        asignar("COMBO", "cbMarca",              resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cbCanal",              resultados, "SEGObtenerCanalesSinFiltro");
        asignar("COMBO", "cbPeriodo",            resultados, "CRAObtienePeriodos");
        asignar("COMBO", "cbVersion",            resultados, "APEObtenerVersionesAsignacion");
        
        traza("*** Salida  - LPMantenerAsignacionManualProductos - cargarCombosLuegoError ***");
    }


    // -------------------------------------------------------------------------------------------------------------------------
    public void cargarCombos(Long oidCDPorDefecto) throws Exception {
        traza("*** Entrada - LPMantenerAsignacionManualProductos - cargarCombos ***");
        ArrayList composerViewElements = new ArrayList();
        composerViewElements.add(this.prepararCargaCBCentroDistribucion());
        composerViewElements.add(this.prepararCargaCBMarca());
        composerViewElements.add(this.prepararCargaCBCanal());
        if (oidCDPorDefecto != null) {
            composerViewElements.add(this.prepararCargaCBMapaCentroDistribucion(oidCDPorDefecto));
        }
        
        DruidaConector resultados = obtenerDatosParaCombos(composerViewElements);
        
        asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
        if (oidCDPorDefecto != null) {
            asignar("COMBO", "cbMapaCentro", resultados, "APEObtenerMapasCDPorCD");
        }
        
        traza("*** Salida  - LPMantenerAsignacionManualProductos - cargarCombos ***");
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private DruidaConector obtenerDatosParaCombos(Collection composerViewElements) throws Exception {
        ComposerViewElementList lista = new ComposerViewElementList();
        ComposerViewElement elem;
        
        Iterator it = composerViewElements.iterator();
        
        while (it.hasNext()) {
           elem = (ComposerViewElement)it.next();
           lista.addViewElement(elem);
        }

        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        return resultados;
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private ComposerViewElement prepararCargaCBCentroDistribucion() throws Exception {
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("APEObtenerDescripcionesCD");
        elem.setDTOE(dtoe);
        return elem;
    }


    private ComposerViewElement prepararCargaCBMapaCentroDistribucion(Long oidCentroDistribucion) 
            throws Exception {
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(oidPais);
        dtoOid.setOidIdioma(oidIdioma);
        dtoOid.setOid(oidCentroDistribucion);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("APEObtenerMapasCDPorCD");
        elem.setDTOE(dtoOid);
        return elem;
    }


    private ComposerViewElement prepararCargaCBMapaZona(Long oidMapaCD) throws Exception {
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(oidPais);
        dtoOid.setOidIdioma(oidIdioma);
        dtoOid.setOid(oidMapaCD);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("APEObtenerMapaZonaPorMapaCD");
        elem.setDTOE(dtoOid);
        return elem;
    }


    private ComposerViewElement prepararCargaCBMarca() throws Exception {
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("SEGObtenerMarcasSinFiltro");
        elem.setDTOE(dtoe);
        return elem;
    }


    private ComposerViewElement prepararCargaCBCanal() throws Exception {
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("SEGObtenerCanalesSinFiltro");
        elem.setDTOE(dtoe);
        return elem;
    }


    private ComposerViewElement prepararCargaCBPeriodo(Long oidMarca, Long oidCanal) 
            throws Exception {
        DTOPeriodo dtoe = new DTOPeriodo();
        // Estos son atributos que DTOPeriodo tiene por herencia
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        // Estos son atributos propios de DTOPeriodo
        dtoe.setPais(oidPais);
        dtoe.setMarca(oidMarca);
        dtoe.setCanal(oidCanal);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("CRAObtienePeriodos");
        elem.setDTOE(dtoe);
        return elem;
    }


    private ComposerViewElement prepararCargaCBVersion(Long oidCD, Long oidMapaCD, 
            Long oidPeriodo) throws Exception {
        DTOMantenerAsignacionProductosAnaqueles dto = new DTOMantenerAsignacionProductosAnaqueles();
        dto.setOidPais(oidPais);
        dto.setOidIdioma(oidIdioma);
        dto.setOidCentroDistribucion(oidCD);
        dto.setOidMapaCentroDistribucion(oidMapaCD);
        dto.setOidPeriodo(oidPeriodo);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("APEObtenerVersionesAsignacion");
        elem.setDTOE(dto);
        return elem;
    }

    
    // -------------------------------------------------------------------------------------------------------------------------
    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }
    

}
