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
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mae.DTOAccionesProcesosBloqueo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class LPMantenimientoAccionesProcesosBloqueos extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPMantenimientoAccionesProcesosBloqueos() {
         super();
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void inicio() throws Exception {
          
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void ejecucion() throws Exception {
         traza("*** Entrada - LPMantenimientoAccionesProcesosBloqueos - ejecucion ***");
         
         try {
             opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
             accion = conectorParametroLimpia("accion", "", true);
             oidPais = UtilidadesSession.getPais(this);
             oidIdioma = UtilidadesSession.getIdioma(this);
             traza("  accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + " / idioma: " + oidIdioma);
             
             if (accion.equals("")) {
                  cargarPagina();
                                    cargarCombos(null);
                  
             } else if (accion.equals("guardar")) {
                  guardar();
                  
             } else if (accion.equals("detalle")) {
                  mostrarDetalle();
             }
              
          } catch (Exception e) {
             traza(" --- Excepcion - LPMantenimientoAccionesProcesosBloqueos");
             logStackTrace(e);
             traza(" --- accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + " / idioma: " + oidIdioma);             
             lanzarPaginaError(e);
          }
          
          traza("*** Salida  - LPMantenimientoAccionesProcesosBloqueos - ejecucion ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private void cargarPagina() throws Exception {
         traza("*** Entrada - LPMantenimientoAccionesProcesosBloqueos - cargarPagina ***");
         
         if (opcionMenu.equals("insertar")) {
             pagina("contenido_acciones_procesos_bloqueo_insertar");
             asignarAtributoPagina("cod", "01080");
             
         } else if (opcionMenu.equals("consultar")) {
             pagina("contenido_acciones_procesos_bloqueo_consultar");
             asignarAtributoPagina("cod", "01081");
             
         } else if (opcionMenu.equals("eliminar")) {
             pagina("contenido_acciones_procesos_bloqueo_consultar");
             asignarAtributoPagina("cod", "01082");
             
         }
         getConfiguracionMenu("LPMantenimientoAccionesProcesosBloqueos", opcionMenu);
         getFormatosValidaciones();
         
         asignarAtributo("VAR", "accion",     "valor", accion);
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
         asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
         
         traza("*** Salida  - LPMantenimientoAccionesProcesosBloqueos - cargarPagina ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void guardar() throws Exception {
         traza("*** Entrada - LPMantenimientoAccionesProcesosBloqueos - guardar ***");
         
         String strOidTipoBloqueo    = conectorParametroLimpia("cbTipoBloqueo",    "", true);
         String strOidProcesoBloqueo = conectorParametroLimpia("cbProcesoBloqueo", "", true);
         String strOidAccionBloqueo  = conectorParametroLimpia("cbAccionBloqueo",  "", true);

                  pagina("salidaGenerica");
         
         DTOAccionesProcesosBloqueo dtoAPB = new DTOAccionesProcesosBloqueo();
         dtoAPB.setOidPais(oidPais);
         dtoAPB.setOidTipoBloqueo(new Long(strOidTipoBloqueo));
         dtoAPB.setOidProcesoBloqueo(new Long(strOidProcesoBloqueo));
         dtoAPB.setOidAccionBloqueo(new Long(strOidAccionBloqueo));
         
         traza("... el DTOAccionesProcesosBloqueo a enviar para Guardar es: " + dtoAPB);
         
         MareBusinessID businessID = new MareBusinessID("MAEGuardarAccionesProcesosBloqueo");
         
         Vector parametros = new Vector();
         parametros.add(dtoAPB);
         parametros.add(businessID);
         
                  try {
             conectar("ConectorGuardarAccionesProcesosBloqueo", parametros);                        
                  } catch (Exception e) {
                           asignarAtributo("VAR", "ejecutarError", "valor", "guardarError();");
                           throw e;
                  }
         
                  asignarAtributo("VAR", "ejecutar", "valor", "guardarOk();");
         
         traza("*** Salida  - LPMantenimientoAccionesProcesosBloqueos - guardar ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private void mostrarDetalle() throws Exception {
         traza("*** Entrada - LPMantenimientoAccionesProcesosBloqueos - mostrarDetalle ***");
         String sOidAccionProcesoBloqueoSeleccionado = conectorParametroLimpia("oidAccionProcesoBloqueoSeleccionado", "", true);
         String sOidTipoBloqueoSeleccionado           = conectorParametroLimpia("oidTipoBloqueoSeleccionado",           "", true);
         String sOidProcesoBloqueoSeleccionado        = conectorParametroLimpia("oidProcesoBloqueoSeleccionado",        "", true);
         String sOidAccionBloqueoSeleccionado         = conectorParametroLimpia("oidAccionBloqueoSeleccionado",         "", true);
         
         traza("    Fila seleccionada: AccionProcesoBloqueo(oid)_" + sOidAccionProcesoBloqueoSeleccionado);
         traza("      TipoBloqueo(oid)_"  + sOidTipoBloqueoSeleccionado + " / ProcesoBloqueo(oid)_" + sOidProcesoBloqueoSeleccionado
                + " / AccionBloqueo(oid)_" + sOidAccionBloqueoSeleccionado);
         
         pagina("contenido_acciones_procesos_bloqueo_insertar");
         asignarAtributoPagina("cod", "01083");
         getConfiguracionMenu("LPMantenimientoAccionesProcesosBloqueos", accion);
         getFormatosValidaciones();
         
         asignarAtributo("VAR", "accion",     "valor", accion);
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
         asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
         
         asignarAtributo("LABELC", "lblDatosDeAlta", "cod", "00680"); // Cambio "00127" (Datos de alta) por "00680" (Datos acciones-procesos-bloqueo)
         
         Long oidProcesoBloqueo = (sOidProcesoBloqueoSeleccionado.equals(""))? null : new Long(sOidProcesoBloqueoSeleccionado);
         cargarCombos(oidProcesoBloqueo);
         
         // Se autoseleccionan los valores correspondientes al detalle (ver LPSiccBase)
         seleccionarValorCambo("cbTipoBloqueo", sOidTipoBloqueoSeleccionado);
         seleccionarValorCambo("cbProcesoBloqueo", sOidProcesoBloqueoSeleccionado);
         seleccionarValorCambo("cbAccionBloqueo", sOidAccionBloqueoSeleccionado);
         
         asignarAtributoElemento("cbTipoBloqueo",    "disabled", "S");
         asignarAtributoElemento("cbProcesoBloqueo", "disabled", "S");
         asignarAtributoElemento("cbAccionBloqueo",  "disabled", "S");
         
         traza("*** Salida  - LPMantenimientoAccionesProcesosBloqueos - mostrarDetalle ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void cargarCombos(Long oidProcesoBloqueo) throws Exception {
         traza("*** Entrada - LPMantenimientoAccionesProcesosBloqueos - cargarCombos ***");
         ArrayList composerViewElements = new ArrayList();
         composerViewElements.add(this.prepararCargaCBTipoBloqueo());
         composerViewElements.add(this.prepararCargaCBProcesoBloqueo());
         
         if (oidProcesoBloqueo != null) {
             composerViewElements.add(this.prepararCargaCBAccionBloqueo(oidProcesoBloqueo));
         }
         
         DruidaConector resultados = obtenerDatosParaCombos(composerViewElements);
         
         asignar("COMBO", "cbTipoBloqueo",    resultados, "MAEObtenerTiposBloqueo");
         asignar("COMBO", "cbProcesoBloqueo", resultados, "MAEObtenerProcesosBloqueo");
         
         if (oidProcesoBloqueo != null) {
             asignar("COMBO", "cbAccionBloqueo", resultados, "MAEObtenerAccionesBloqueo");
         }
         
         traza("*** Salida  - LPMantenimientoAccionesProcesosBloqueos - cargarCombos ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private ComposerViewElement prepararCargaCBTipoBloqueo() throws Exception {
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidPais(oidPais);
         dtoe.setOidIdioma(oidIdioma);
         
         ComposerViewElement elem = new ComposerViewElement();
         elem.setIDBusiness("MAEObtenerTiposBloqueo");
         elem.setDTOE(dtoe);
         return elem;
    }

    private ComposerViewElement prepararCargaCBProcesoBloqueo() throws Exception {
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidPais(oidPais);
         dtoe.setOidIdioma(oidIdioma);
         
         ComposerViewElement elem = new ComposerViewElement();
         elem.setIDBusiness("MAEObtenerProcesosBloqueo");
         elem.setDTOE(dtoe);
         return elem;
    }

    private ComposerViewElement prepararCargaCBAccionBloqueo(Long oidProcesoBloqueo) throws Exception {
         DTOOID dtoOid = new DTOOID();
         dtoOid.setOidPais(oidPais);
         dtoOid.setOidIdioma(oidIdioma);
         dtoOid.setOid(oidProcesoBloqueo);
         
         ComposerViewElement elem = new ComposerViewElement();
         elem.setIDBusiness("MAEObtenerAccionesBloqueo");
         elem.setDTOE(dtoOid);
         return elem;
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
    private void logStackTrace(Throwable e) throws Exception {
         traza(" --- Se produjo la excepcion: " + e.getMessage());
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);
         traza(" --- Stack Trace: " + baos.toString());
    }

}