/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.dtos.cra.DTOPeriodo;


public class LPReasignarEstatusEnLotes extends LPSICCBase {
    private Long pais;
    private Long idioma;
    
    public LPReasignarEstatusEnLotes() {
         super();
    }
    
    public void inicio() throws Exception {
         UtilidadesSession session = new UtilidadesSession();
         pais   = session.getPais(this);
         idioma = session.getIdioma(this);
    }
    
    public void ejecucion() throws Exception {
         String accion;
         
         try {
             traza("*** Entrada   - LPReasignarEstatusEnLotes - ejecucion *** / Pais_" + pais + " / Idioma_" + idioma);
             accion = conectorParametroLimpia("accion", "", true);
             
             if (accion.equals("")) {
                  inicializar();
             } else if (accion.equals("reasignar")) {
                  reasignar();
             }
             
             traza("*** Salida    - LPReasignarEstatusEnLotes - ejecucion ***");
         } catch (Exception e) {
             traza("*** Excepcion - LPReasignarEstatusEnLotes - ejecucion ***");
             this.logStackTrace(e);
             lanzarPaginaError(e);
         }
    }
    
    
    private void inicializar() throws Exception {
         traza("*** Entrada   - LPReasignarEstatusEnLotes - inicializar ***");
         
         pagina("contenido_reasignar_estatus_lotes");
         this.getFormatosValidaciones();
         getConfiguracionMenu("LPReasignarEstatusEnLotes", "reasignar");
         
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidPais(pais);
         dtoe.setOidIdioma(idioma);
         
         ComposerViewElement elem1;
         ComposerViewElement elem2;
         ComposerViewElementList lista;
         ConectorComposerView conector;
         DruidaConector resultados;
         
         // Carga del combo de Marcas
         lista = new ComposerViewElementList();
         elem1 = new ComposerViewElement();
         
         elem1.setIDBusiness("SEGConsultaMarcas");
         elem1.setDTOE(dtoe);
         lista.addViewElement(elem1);         
         
         // Carga del combo de Canales
         elem2 = new ComposerViewElement();
         
         elem2.setIDBusiness("SEGConsultaCanales");
         elem2.setDTOE(dtoe);
         lista.addViewElement(elem2);
         
         conector = new ConectorComposerView(lista, this.getRequest());
         conector.ejecucion();
         resultados = conector.getConector();
    
         asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
         asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
         
         // Pais e Idioma del usuario
         asignar("VAR", "oidPais", pais.toString());
         asignar("VAR", "oidIdioma", idioma.toString());
         
         // vbongiov - Cambio 20070458 - 30/01/2008
         Long marcaDef = UtilidadesSession.getMarcaPorDefecto(this);
         Long canalDef = UtilidadesSession.getCanalPorDefecto(this);
         
         asignar("VAR", "oidMarcaDef", marcaDef.toString());
         asignar("VAR", "oidCanalDef", canalDef.toString());
         
         traza("*** Salida    - LPReasignarEstatusEnLotes - inicializar ***");
         
    }
    
    private void reasignar() throws Exception {
      pagina("salidaGenerica");
      
      try {     
         traza("*** Entrada   - LPReasignarEstatusEnLotes - reasignar ***");
         
         // vbongiov - Cambio 20070458 - 30/01/2008
         String marca;
         String canal;
         String periodo;
         String region;
         
         marca   = conectorParametroLimpia("cbMarca", "", true);
         canal   = conectorParametroLimpia("cbCanal", "", true);
         periodo = conectorParametroLimpia("cbPeriodoActual", "", true);
         
         traza("                - marca: "    + marca);
         traza("                - canal: "    + canal);
         traza("                - periodo: "  + periodo);
         
         // Seteamos los valores seleccionados por el usuario en el DTOFACCierreFacturacion
         DTOFACCierreFacturacion dtoCierreFac = new DTOFACCierreFacturacion();
         
         dtoCierreFac.setOidPais(this.pais);
         dtoCierreFac.setOidIdioma(this.idioma);
         dtoCierreFac.setMarca(new Long(marca));
         dtoCierreFac.setCanal(new Long(canal));
         dtoCierreFac.setPeriodo(new Long(periodo));
         traza("dtoCierreFac_" + dtoCierreFac);
         
         Vector paramsEntrada = new Vector();
         DruidaConector conector;

         paramsEntrada.add(dtoCierreFac);                                           
         paramsEntrada.add(new MareBusinessID("MAEReasignarEstatusEnLotes"));
         traza("antes de conectar");
         conector = conectar("ConectorReasignarEstatusEnLotes", paramsEntrada);
         traza("despues de conectar");
         
         asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar();");
         
         traza("*** Salida    - LPReasignarEstatusEnLotes - reasignar ***");
         
      } catch(Exception e) {
           traza("Excepcion: " + e);
           asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCbMarca();");
           throw e;
      }         
         
    }
    
    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
         
         if (e instanceof MareException) {
             MareException e2 = (MareException) e;
             traza("Es una mare Exception con codigo de error: " + e2.getCode());
         }
         
         e.printStackTrace(out);
         traza("stack Trace : " + pila.toString());
    }
   
}

