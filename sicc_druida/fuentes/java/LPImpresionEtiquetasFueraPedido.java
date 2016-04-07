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
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;


public class  LPImpresionEtiquetasFueraPedido extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String accion = null;
    private String casoUso = null;
    
    
    public LPImpresionEtiquetasFueraPedido() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPImpresionEtiquetasFueraPedido - ejecucion ***");
        
        try {
        	setTrazaFichero();
            
            accion = conectorParametroLimpia("accion", "", true);
            casoUso = conectorParametroLimpia("casoUso", "", true);
            
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
            traza("  accion: " + accion + " / pais: " + oidPais + " / idioma: " + oidIdioma);
            
            if (accion.equals("")) {
                casoUso = "busqueda";
                cargarPantalla();

            } else if (accion.equals("imprimir")) {
                imprimirEtiquetasFP();
            }

        } catch (Exception e) {
            traza(" --- Excepcion - LPImpresionEtiquetasFueraPedido");
            logStackTrace(e);
            lanzarPaginaError(e);
        }
        traza("*** Salida  - LPImpresionEtiquetasFueraPedido - ejecucion ***");
    }


    public void cargarPantalla() throws Exception {
        traza("*** Entrada - LPImpresionEtiquetasFueraPedido - cargarPantalla ***");
        
        pagina("contenido_etiquetas_pallets_fuera_pedido_imprimir");
        this.getFormatosValidaciones();
        
        getConfiguracionMenu("LPImpresionEtiquetasFueraPedido", "pallet");
        
        asignarAtributo("VAR", "accion",     "valor", accion);
        asignarAtributo("VAR", "casoUso",    "valor", casoUso);
        asignarAtributo("VAR", "oidPais",    "valor", oidPais.toString());
        asignarAtributo("VAR", "oidIdioma",  "valor", oidIdioma.toString());
        
        
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
        
        
        asignar("COMBO", "cmbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
        asignar("COMBO", "cmbMarca", resultados, "SEGObtenerMarcasSinFiltro");
        asignar("COMBO", "cmbCanal", resultados, "SEGObtenerCanalesSinFiltro");
        
        // Fecha actual por defecto (de esta forma sera la fecha del Servidor Web)
        Date date = new Date(System.currentTimeMillis());
        String s2 = UtilidadesSession.getFormatoFecha(this);
        String s1 = new String();
        s2 = s2.replace('m', 'M');
        
        SimpleDateFormat simpledateformat = new SimpleDateFormat(s2);
        
        try {
            s1 = simpledateformat.format(date);
        } catch (Exception ex) {
            traza("*** ERROR al formatear la fecha actual ***");
        }
        asignarAtributo("CTEXTO", "txtFecha", "valor", s1);
                
        traza("*** Salida  - LPImpresionEtiquetasFueraPedido - cargarPantalla ***");
    }


    public void imprimirEtiquetasFP() throws Exception {
        traza("*** Entrada - LPImpresionEtiquetasFueraPedido - imprimirEtiquetasFP ***");
        
        pagina("salidaGenerica");
        
        try {
            String strOidsAImprimir = conectorParametroLimpia("hOidsListasPicadoAImprimir", "", true);
            traza(" (Listas de Picado) los oid a imprimir son: " + strOidsAImprimir);

            // Armamos el DTOOIDs con todos los oids de las filas seleccionadas en la lista (son oid de Listas de Picado)
            StringTokenizer stk = new StringTokenizer(strOidsAImprimir, ",");
            int cantElementos = stk.countTokens();
            Long oidsFilas[] = new Long[cantElementos];
            DTOOIDs dtoOids = new DTOOIDs();
			dtoOids.setOidPais(oidPais);
			dtoOids.setOidIdioma(oidIdioma);

            String strOidFila;
            traza("                - cantidad filas seleccionadas para imprimir: " + cantElementos);
            
            for (int i = 0; i < cantElementos; i++) {
                strOidFila = stk.nextToken();
                traza("                - oid: " + strOidFila);
                oidsFilas[i] = new Long(strOidFila);
            }
            
            dtoOids.setOids(oidsFilas);
            
            MareBusinessID businessID = new MareBusinessID("APEImprimirEtiquetasFP");
            
            Vector parametros = new Vector();
            parametros.add(dtoOids);  
            parametros.add(businessID);
            
            conectar("ConectorImprimirEtiquetasFP", parametros);
            
            traza("... la impresion de las etiquetas fue lanzada");
            asignarAtributo("VAR", "ejecutar", "valor", "impresionLanzadaExitosamente();");
            
        } catch(Exception e) {
            traza("*** ERROR al imprimir etiquetas pallets fuera de pedido: " + e);
            throw e;
        }
        traza("*** Salida  - LPImpresionEtiquetasFueraPedido - imprimirEtiquetasFP ***");
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