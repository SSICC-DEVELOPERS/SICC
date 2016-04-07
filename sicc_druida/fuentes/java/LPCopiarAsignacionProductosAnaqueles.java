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
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import java.util.Vector;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class  LPCopiarAsignacionProductosAnaqueles extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String accion = null;
    
    
    public LPCopiarAsignacionProductosAnaqueles() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPCopiarAsignacionProductosAnaqueles - ejecucion ***");
      
        try {
            setTrazaFichero();

            accion = conectorParametroLimpia("accion", "", true);
            
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
            traza("  accion: " + accion + " / pais: " + oidPais + " / idioma: " + oidIdioma);
            
            if (accion.equals("")) {
                 cargarPaginaCopiarAsignacion();
                 cargarCombos();
            } else if (accion.equals("copiar")) {
                 copiar();
            }
            
        } catch (Exception e) {
            traza(" --- Excepcion - LPCopiarAsignacionProductosAnaqueles");
            logStackTrace(e);
            traza(" --- accion: " + accion + " / pais: " + oidPais + " / idioma: " + oidIdioma);
            lanzarPaginaError(e);
        }
        
        traza("*** Salida  - LPCopiarAsignacionProductosAnaqueles - ejecucion ***");
    }

    private void copiar() throws Exception {
        traza("*** Entrada - LPCopiarAsignacionProductosAnaqueles - copiar ***");

        pagina("salidaGenerica");

        try {
            String strOidCabecOrigen = conectorParametroLimpia("oidAPACOrigenSeleccionado", "", true);
            String strOidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);
            String strOidMapaCD = conectorParametroLimpia("oidMapaCDOrigenSeleccionado", "", true);
            String strOidMapaZona = conectorParametroLimpia("oidMapaZonaOrigenSeleccionado", "", true);
            String strCodVersionDestino = conectorParametroLimpia("txtVersionDestino", "", true);
            
            DTOAsignacionProductoAnaquelCabecera dtoAPAC = new DTOAsignacionProductoAnaquelCabecera();
            dtoAPAC.setOid(new Long(strOidCabecOrigen));
            dtoAPAC.setOidPeriodo(new Long(strOidPeriodo));
            dtoAPAC.setOidMapaCDCabecera(new Long(strOidMapaCD));
            dtoAPAC.setOidMapaZonaCabecera(new Long(strOidMapaZona));
            dtoAPAC.setVersion(strCodVersionDestino);
            traza("DTO para la copia: " + dtoAPAC);
            
            MareBusinessID businessID = new MareBusinessID("APECopiarAsignacionProductosAnaqueles");
            
            Vector parametros = new Vector();
            parametros.add(dtoAPAC);  
            parametros.add(businessID);
            
            conectar("ConectorCopiarAsignacionProductosAnaqueles", parametros);
            
            asignarAtributo("VAR", "ejecutar", "valor", "mostrarMensajeCopiaExitosa('" + strCodVersionDestino + "');");
            
        } catch (Exception e) {
            traza(" Error al Copiar asignacion prod/anaq: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", "mostrarMensajeCopiaErronea();");
            throw e;
        }

        
        traza("*** Salida  - LPCopiarAsignacionProductosAnaqueles - copiar ***");
    }


    private void cargarPaginaCopiarAsignacion() throws Exception {
        pagina("contenido_copiar_asignacion_productos_anaqueles");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPCopiarAsignacionProductosAnaqueles", "copiar");
               
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
    }


    private void cargarCombos() throws Exception {
        traza("*** Entrada - LPCopiarAsignacionProductosAnaqueles - cargarCombos ***");
        
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);

        ComposerViewElementList lista = new ComposerViewElementList();
        
        ComposerViewElement elem1 = new ComposerViewElement();
        elem1.setIDBusiness("APEObtenerDescripcionesCD");
        elem1.setDTOE(dtoe);
        lista.addViewElement(elem1);

        ComposerViewElement elem2 = new ComposerViewElement();
        elem2.setIDBusiness("SEGObtenerMarcasSinFiltro");
        elem2.setDTOE(dtoe);
        lista.addViewElement(elem2);

        ComposerViewElement elem3 = new ComposerViewElement();
        elem3.setIDBusiness("SEGObtenerCanalesSinFiltro");
        elem3.setDTOE(dtoe);
        lista.addViewElement(elem3);

        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        
        
        asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
        
        String oidCDDefault = obtenerCDPorDefecto();
        asignarAtributo("VAR", "defaultOidComboCD", "valor", oidCDDefault);
        
        traza("*** Salida  - LPCopiarAsignacionProductosAnaqueles - cargarCombos ***");
    }


    private String obtenerCDPorDefecto() throws Exception {
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
        
        return oidCDDefault;
    }


    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }

}