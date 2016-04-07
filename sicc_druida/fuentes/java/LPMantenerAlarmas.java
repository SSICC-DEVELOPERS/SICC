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
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;


public class LPMantenerAlarmas extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String accion = null;
    private String opcionMenu = null;
    
    
    public LPMantenerAlarmas() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }


    // -------------------------------------------------------------------------------------------------------------------------
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPMantenerAlarmas - ejecucion ***");
        
        try {
        	setTrazaFichero();
            
            accion = conectorParametroLimpia("accion", "", true);
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
            traza("  accion: " + accion + " / opcionMenu: " + opcionMenu + " / pais: " + oidPais + " / idioma: " + oidIdioma);
            
            if (accion.equals("") && opcionMenu.equals("emitir")) {
                cargarPantallaEmitirAlarmas();
                cargarCombos();
                
            } else if (accion.equals("emitir")) {
                emitirAlarmas();
            }

        } catch (Exception e) {
            traza(" --- Excepcion - LPMantenerAlarmas");
            logStackTrace(e);
            lanzarPaginaError(e);
        }
        traza("*** Salida  - LPMantenerAlarmas - ejecucion ***");
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private void emitirAlarmas() throws Exception {
        traza("*** Entrada - LPMantenerAlarmas - emitirAlarmas ***");
        
        // Preparo la pagina generica, necesaria para mostrar las Excepciones del método servidor (hice envia oculto 'S')
        pagina("salidaGenerica");

        try {
            String strOidCD = conectorParametroLimpia("cbCentroDistribucion", "", true);
            String strOidMapaCD = conectorParametroLimpia("cbMapaCentroDistribucion", "", true);
            String strOidLinea = conectorParametroLimpia("cbLineaArmado", "", true);
            String strOidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);

            DTOMantenerAsignacionProductosAnaqueles dto = new DTOMantenerAsignacionProductosAnaqueles();
            dto.setOidPais(oidPais);
            dto.setOidIdioma(oidIdioma);
            dto.setOidCentroDistribucion(new Long(strOidCD));
            dto.setOidMapaCentroDistribucion(new Long(strOidMapaCD));
            dto.setOidLineaArmado(new Long(strOidLinea));
            dto.setOidPeriodo(new Long(strOidPeriodo));
            dto.setDescripcionCentroDistribucion(conectorParametroLimpia("descCD", "", true));
            dto.setDescripcionMapaCentroDistribucion(conectorParametroLimpia("descMapaCD", "", true));
            dto.setDescripcionLineaArmado(conectorParametroLimpia("descLinea", "", true));
            dto.setDescripcionMarca(conectorParametroLimpia("descMarca", "", true));
            dto.setDescripcionCanal(conectorParametroLimpia("descCanal", "", true));
            dto.setDescripcionPeriodo(conectorParametroLimpia("descPeriodo", "", true));
            
            traza("DTOMantenerAsignacionProductosAnaqueles: " + dto);
            
            MareBusinessID businessID = new MareBusinessID("APEEmitirAlarmas");
            
            Vector parametros = new Vector();
            parametros.add(dto);  
            parametros.add(businessID);
            
            traza("... antes de ejecutar APEEmitirAlarmas");
            DruidaConector druidaconector = conectar("ConectorEmitirAlarmas", parametros);
            traza("... luego de ejecutar APEEmitirAlarmas");
            
            asignarAtributo("VAR", "ejecutar", "valor", "emisionAlarmasExitosa()");
            
        } catch (Exception e) {
            traza("Excepcion: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
            throw e;
        }
        traza("*** Salida  - LPMantenerAlarmas - emitirAlarmas ***");
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private void cargarPantallaEmitirAlarmas() throws Exception {
        pagina("contenido_alarmas_emitir");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPMantenerAlarmas", "emitir");
        
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
    }


    // -------------------------------------------------------------------------------------------------------------------------
    private void cargarCombos() throws Exception {
        traza("*** Entrada - LPMantenerAlarmas - cargarCombos ***");
        // *** Obtenemos los valores de Centro de Distribucion y Linea de Armado por defecto
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);
        Vector parametros = new Vector();
        parametros.add(dtoe);
        parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));
        
        traza("antes del conector");
        DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", parametros);
        traza("despues del conector");
        
        DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
        
        asignarAtributo("VAR", "hCbCentroDistribucion", "valor", obtenerCDDef(dtoSalida));
        asignarAtributo("VAR", "hCbLineasCDDef", "valor", aplanarLineasCDDef(dtoSalida));            
       
        ArrayList composerViewElements = new ArrayList();
        composerViewElements.add(this.prepararCargaCBCentroDistribucion());
        composerViewElements.add(this.prepararCargaCBMarca());
        composerViewElements.add(this.prepararCargaCBCanal());      
        
        DruidaConector resultados = obtenerDatosParaCombos(composerViewElements);
        
        asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
                
        traza("*** Salida  - LPMantenerAlarmas - cargarCombos ***");
    }
    
    private String obtenerCDDef(DTOSalida dtoSalida) throws Exception{
    RecordSet valoresDef = dtoSalida.getResultado();
    String CDDef = "";
    int cant = valoresDef.getRowCount();
    
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.CONFIGURACION_CD)){
         traza("CDDef :" + valoresDef.getValueAt(i,"OID"));
         return ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    traza("No hay CD por defecto");
    return "";
  }
  
  private String aplanarLineasCDDef(DTOSalida dtoSalida) throws Exception{ 
    traza("entro a aplanarLineasCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String lineasCDDef = "";
    int cant = valoresDef.getRowCount();
        
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.LINEA_ARMADO)){
          lineasCDDef = lineasCDDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!lineasCDDef.equals("")){
        return lineasCDDef.substring(1);
    } else {
        traza("No hay linea por defecto");
        return "";
    }
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


    private ComposerViewElement prepararCargaCBLineaArmado(Long oidCentroDistribucion) 
            throws Exception {
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOidPais(oidPais);
        dtoOid.setOidIdioma(oidIdioma);
        dtoOid.setOid(oidCentroDistribucion);
        
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("APEObtenerLineasArmadoCD");
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


    // -------------------------------------------------------------------------------------------------------------------------
    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }

}
