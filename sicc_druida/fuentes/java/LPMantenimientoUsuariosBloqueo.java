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
import es.indra.sicc.dtos.mae.DTOUsuariosBloqueo;
import es.indra.sicc.dtos.men.DTOIdentUsuario;   // MEN

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class LPMantenimientoUsuariosBloqueo extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPMantenimientoUsuariosBloqueo() {
         super();
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void inicio() throws Exception {
          
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void ejecucion() throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - ejecucion ***");
         
         try {
             opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
             accion = conectorParametroLimpia("accion", "", true);
             oidPais = UtilidadesSession.getPais(this);
             oidIdioma = UtilidadesSession.getIdioma(this);
             traza("  accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + " / idioma: " + oidIdioma);
             
             if (accion.equals("")) {
                  cargarPagina();
                  cargarCombos();
                  
             } else if (accion.equals("guardar")) {
                  guardar();
                  
             } else if (accion.equals("detalle") || accion.equals("modificarDetalle")) {
                  mostrarDetalle(accion);
                  
             } else if (accion.equals("validarCodigoUsuario")) {
                                    String strCodigoUsuario = conectorParametroLimpia("txtCodigoUsuario",  "", true);
                  validarCodigoUsuario(strCodigoUsuario);
                  
             }
             
          } catch (Exception e) {
             traza(" --- Excepcion - LPMantenimientoUsuariosBloqueo");
             logStackTrace(e);
             traza(" --- accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + " / idioma: " + oidIdioma);
             lanzarPaginaError(e);
          }
          
          traza("*** Salida  - LPMantenimientoUsuariosBloqueo - ejecucion ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private void cargarPagina() throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - cargarPagina ***");
         
         if (opcionMenu.equals("insertar")) {
             pagina("contenido_usuarios_bloqueo_insertar");
             asignarAtributoPagina("cod", "01084");
             
         } else if (opcionMenu.equals("consultar")) {
             pagina("contenido_usuarios_bloqueo_consultar");
             asignarAtributoPagina("cod", "01086");
             
         } else if (opcionMenu.equals("eliminar")) {
             pagina("contenido_usuarios_bloqueo_consultar");
             asignarAtributoPagina("cod", "01087");
             
         } else if (opcionMenu.equals("modificar")) {
             pagina("contenido_usuarios_bloqueo_consultar");
             asignarAtributoPagina("cod", "01085");
             
         }
         getConfiguracionMenu("LPMantenimientoUsuariosBloqueo", opcionMenu);
         getFormatosValidaciones();
         
         asignarAtributo("VAR", "accion",     "valor", accion);
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
         asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
         
         traza("*** Salida  - LPMantenimientoUsuariosBloqueo - cargarPagina ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void guardar() throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - guardar ***");
         
         String strOidUsuarioBloqueo  = conectorParametroLimpia("oidUsuarioBloqueo", "", true);
         Long oidUsuarioBloqueo        = (strOidUsuarioBloqueo.equals(""))? null : new Long(strOidUsuarioBloqueo);
         String strIdUser              = conectorParametroLimpia("idUser",             "", true);
         Long idUser                        = (strIdUser.equals(""))? null : new Long(strIdUser);
         String strCodigoUsuario      = conectorParametroLimpia("txtCodigoUsuario",  "", true);
         String strOidTipoBloqueo     = conectorParametroLimpia("cbTipoBloqueo",     "", true);
         String strOidAccionPermitida = conectorParametroLimpia("cbAccionPermitida", "", true);
         
         pagina("salidaGenerica");

         // Si faltaba validar el codigo de usuario entonces lo hacemos ahora antes de Guardar
         if (idUser == null && opcionMenu.equals("insertar")) {
             idUser = this.validarCodigoUsuario(strCodigoUsuario);
         }

                  // dmorello, 13/11/2007
                  // Si idUser es nulo, no debo intentar guardar
                  if (idUser != null) {
                           DTOUsuariosBloqueo dtoUB = new DTOUsuariosBloqueo();
                           dtoUB.setOid(oidUsuarioBloqueo);
                           dtoUB.setOidPais(oidPais);
                           dtoUB.setOidIdioma(oidIdioma);
                           dtoUB.setIdUser(idUser);
                           dtoUB.setOidTipoBloqueo(new Long(strOidTipoBloqueo));
                           dtoUB.setOidAccionPermitida(new Long(strOidAccionPermitida));
                           
                           traza("... el DTOUsuariosBloqueo a enviar para Guardar es: " + dtoUB);
                           
                           MareBusinessID businessID = new MareBusinessID("MAEGuardarUsuariosBloqueo");
                           
                           Vector parametros = new Vector();
                           parametros.add(dtoUB);
                           parametros.add(businessID);
                           
                           try {
                                    conectar("ConectorGuardarUsuariosBloqueo", parametros);             
                           } catch (Exception e) {
                                    asignarAtributo("VAR", "ejecutarError", "valor", "guardarError();");
                                    throw e;
                           }
         
                  asignarAtributo("VAR", "ejecutar", "valor", "guardarOk();");
         }
                  // Fin dmorello 13/11/2007
         
         traza("*** Salida  - LPMantenimientoUsuariosBloqueo - guardar ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public Long validarCodigoUsuario(String codigoUsuario) throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - validarCodigoUsuario ***");
         
         pagina("salidaGenerica");
         
         Long idUser = null;
         
         try {
             DTOIdentUsuario dtoIU = new DTOIdentUsuario();
             dtoIU.setCodUsuario(codigoUsuario);
             
             MareBusinessID businessID = new MareBusinessID("MENObtenerUsuario");
             
             Vector parametros = new Vector();
             parametros.add(dtoIU);
             parametros.add(businessID);
             
             DruidaConector druidaconector = conectar("ConectorObtenerUsuario", parametros);
             
             DTOIdentUsuario dtoValidado = (DTOIdentUsuario)druidaconector.objeto("DTOIdentUsuario");
             traza("... la validacion del Codigo usuario resulto: " + dtoValidado);
             
             idUser = dtoValidado.getIdUsuario();
             String nombreCompleto = dtoValidado.getCadenaNombre();
             
             if (idUser != null) {
                  asignarAtributo("VAR", "ejecutar", "valor", "validacionUsuarioOk('"+idUser+"', '"+nombreCompleto+"');");
             } else {
                  asignarAtributo("VAR", "ejecutar", "valor", "validacionUsuarioError('"+codigoUsuario+"');");
             }
             traza("... idUser: " + idUser);
         } catch(Exception e) {
            traza("Excepcion (validarCodigoUsuario): " + e);
            throw e;
         }
         traza("*** Salida  - LPMantenimientoUsuariosBloqueo - validarCodigoUsuario ***");
         return idUser;
    }

    // -------------------------------------------------------------------------------------------------------------------------
    private void mostrarDetalle(String accion) throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - mostrarDetalle ***");
         String sOidUsuarioBloqueoSeleccionado  = conectorParametroLimpia("oidUsuarioBloqueoSeleccionado",  "", true); // OID de MAE_USUAR_BLOQU
         String sIDUser                            = conectorParametroLimpia("idUserSeleccionado",              "", true);
         String sCodigoUsuarioSeleccionado      = conectorParametroLimpia("codigoUsuarioSeleccionado",      "", true);
         String sNombreUsuarioSeleccionado      = conectorParametroLimpia("nombreUsuarioSeleccionado",      "", true);
         String sOidTipoBloqueoSeleccionado     = conectorParametroLimpia("oidTipoBloqueoSeleccionado",     "", true);
         String sOidAccionPermitidaSeleccionado = conectorParametroLimpia("oidAccionPermitidaSeleccionado", "", true);
         
         traza("    Fila seleccionada: MaeUsuariosBloqueo(oid)_" + sOidUsuarioBloqueoSeleccionado);
         traza("      Usuario(cod-Nombre)_"  + sCodigoUsuarioSeleccionado + "-" + sNombreUsuarioSeleccionado);
         traza("      TipoBloqueo(oid)_"     + sOidTipoBloqueoSeleccionado);
         traza("      AccionPermitida(oid)_" + sOidAccionPermitidaSeleccionado);
         
         pagina("contenido_usuarios_bloqueo_insertar");
         asignarAtributoPagina("cod", "01088");
         getConfiguracionMenu("LPMantenimientoUsuariosBloqueo", accion);
         getFormatosValidaciones();
         
         asignarAtributo("VAR", "accion",     "valor", accion);
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
         asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
         
         asignarAtributo("LABELC", "lblDatosDeAlta", "cod", "00681"); // Cambio "00127" (Datos de alta) por "00681" (Datos usuario-bloqueo)
         
         cargarCombos();
         
         Long oidUsuarioBloqueo = new Long(sOidUsuarioBloqueoSeleccionado);
         
         asignarAtributo("VAR",    "oidUsuarioBloqueo",  "valor", sOidUsuarioBloqueoSeleccionado);
         asignarAtributo("VAR",    "idUser",              "valor", sIDUser);
         asignarAtributo("VAR",    "oidAccionPermitida", "valor", sOidAccionPermitidaSeleccionado); // para fLimpiar del modificarDetalle
         asignarAtributo("CTEXTO", "txtCodigoUsuario",   "valor", sCodigoUsuarioSeleccionado);
         asignarAtributo("LABELC", "nombreUsuario",      "valor", sNombreUsuarioSeleccionado);
         
         // Se autoseleccionan los valores correspondientes al detalle (ver LPSiccBase)
         seleccionarValorCambo("cbTipoBloqueo",     sOidTipoBloqueoSeleccionado);
         seleccionarValorCambo("cbAccionPermitida", sOidAccionPermitidaSeleccionado);
         
         asignarAtributoElemento("txtCodigoUsuario", "disabled", "S");
         asignarAtributoElemento("cbTipoBloqueo",    "disabled", "S");
         
                  if (opcionMenu.equals("consultar")) {
             asignarAtributoElemento("cbAccionPermitida",    "disabled", "S");
                  }
         
         traza("*** Salida  - LPMantenimientoUsuariosBloqueo - mostrarDetalle ***");
    }

    // -------------------------------------------------------------------------------------------------------------------------
    public void cargarCombos() throws Exception {
         traza("*** Entrada - LPMantenimientoUsuariosBloqueo - cargarCombos ***");
         ArrayList composerViewElements = new ArrayList();
         composerViewElements.add(this.prepararCargaCBTipoBloqueo());
         composerViewElements.add(this.prepararCargaCBAccionPermitida());
         
         DruidaConector resultados = obtenerDatosParaCombos(composerViewElements);
         
         asignar("COMBO", "cbTipoBloqueo",     resultados, "MAEObtenerTiposBloqueo");
         asignar("COMBO", "cbAccionPermitida", resultados, "MAEObtenerValoresUsuarioBloqueo");
         
         traza("*** Salida  - LPMantenimientoUsuariosBloqueo - cargarCombos ***");
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

    private ComposerViewElement prepararCargaCBAccionPermitida() throws Exception {
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidPais(oidPais);
         dtoe.setOidIdioma(oidIdioma);
         
         ComposerViewElement elem = new ComposerViewElement();
         elem.setIDBusiness("MAEObtenerValoresUsuarioBloqueo");
         elem.setDTOE(dtoe);
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