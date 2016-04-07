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
 *
 * Autor: SPLATAS
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOLineaArmado;

import es.indra.sicc.dtos.ape.DTOMantenerAsignacionProductosAnaqueles;

public class LPMantenerVerAsigProdAnaqueles extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
         
    public LPMantenerVerAsigProdAnaqueles() {    
         super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
         traza("     LPMantenerVerAsigProdAnaqueles.ejecucion(): Entrada ");    
         
         try {      
             setTrazaFichero();
                      
             pagina("contenido_versiones_asignacion_anaqueles_gestionar");
                  
             traza("     - this.getFormatosValidaciones()...");
             this.getFormatosValidaciones();

             getConfiguracionMenu("LPMantenerVerAsigProdAnaqueles", "gestionarVersiones");
             asignarAtributoPagina("cod","ApeGestVAsigProdAnaqueles.query.label");

             
             String accion = conectorParametroLimpia("accion", "", true);
             traza("     -SAP601: accion: " + accion);
             String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
             traza("     -SAP601: opcionMenu: " + opcionMenu);
             
             pais = UtilidadesSession.getPais(this);
             traza("     -SAP601: pais =" + pais);
             asignarAtributo("VAR", "hPais", "valor", pais.toString());
             
             idioma = UtilidadesSession.getIdioma(this);
             traza("     -SAP601: idioma =" + idioma);
             asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());
             
             
             if(accion.equals("") && opcionMenu.equals("gestionarVersiones")) { 
                  
                  this.cargarCombos();
      
             } else if(accion.equals("activarVersion")) { 
                  
                  this.activarVersion();      
                  
             } else if(accion.equals("desactivarVersion")) { 
                  
                  this.desactivarVersion();           
             }
         
         } catch (Exception e){   
           traza("        - SAP601: Pinchó..." + e);      
           this.lanzarPaginaError(e);
      
         }
      
         traza("     LPMantenerVerAsigProdAnaqueles.ejecucion(): Salida ");    
    }
    
    
    private void cargarCombos() throws Exception{
         traza("     LPMantenerVerAsigProdAnaqueles.cargarCombos(): Entrada ");   
      
         ComposerViewElementList lista = new ComposerViewElementList();
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidIdioma(idioma);
         dtoe.setOidPais(pais);

         byte posOid = 0;
         byte posDesc = 1;
                
         // Carga los Centros de Distribución
         ComposerViewElement elemCD = new ComposerViewElement();
         elemCD.setIDBusiness("APEObtenerDescripcionesCD");
         elemCD.setDTOE(dtoe);
         elemCD.setPosOID(posOid);
         elemCD.setPosDesc(posDesc);
         lista.addViewElement(elemCD);  
         traza("     Centro Distribución....");
     
         // Carga las Marcas
         ComposerViewElement elemMarca = new ComposerViewElement();
         elemMarca.setIDBusiness("SEGObtenerMarcasSinFiltro");
         elemMarca.setDTOE(dtoe);
         elemMarca.setPosOID(posOid);
         elemMarca.setPosDesc(posDesc);
         lista.addViewElement(elemMarca);
         traza("     Marca....");
         
         // Carga los Canales
         ComposerViewElement elemCh = new ComposerViewElement();
         elemCh.setIDBusiness("SEGObtenerCanalesSinFiltro");
         elemCh.setDTOE(dtoe);
         elemCh.setPosOID(posOid);
         elemCh.setPosDesc(posDesc);
         lista.addViewElement(elemCh);
         traza("     Canales....");
         
         // Recupera los oids de los valores por defecto para cada combo 
         ComposerViewElement elemDef = new ComposerViewElement();
         elemDef.setIDBusiness("APEObtenerValoresDefecto");
         elemDef.setDTOE(dtoe);
         lista.addViewElement(elemDef);
         traza("     Valores Defecto....");
     
         ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
         conector.ejecucion();
         traza("     -SAP601: Antes de conector 1....");
         DruidaConector resultados = conector.getConector();
         traza("     -SAP601: Despues de conector 1...");
         
         asignar("COMBO", "cbCentroDistribucion", resultados, "APEObtenerDescripcionesCD");
         asignar("COMBO", "cbMarca", resultados, "SEGObtenerMarcasSinFiltro");
         asignar("COMBO", "cbCanal", resultados, "SEGObtenerCanalesSinFiltro");
     
         traza("     resultados = " + resultados.toString());
          
          
         // Valores de defecto
         DTOBelcorp dtoBel = new DTOBelcorp();      
         dtoBel.setOidPais(pais);
         dtoBel.setOidIdioma(idioma);
         
         MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
         Vector params = new Vector();            
         params.addElement(dtoBel);
         params.addElement(mareBusinessID);
         
         traza(" -SAP601:    antes del conector 'ConectorObtenerValoresDefecto'...");
         DruidaConector dc  =    conectar("ConectorObtenerValoresDefecto", params);
         traza(" -SAP601:    despues del conector ....");
         
         DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida"); 
         
         asignarAtributo("VAR", "hCentDist", "valor", obtenerCDDef(dtoSalida));
      
     
         traza("     LPMantenerVerAsigProdAnaqueles.cargarCombos(): Salida ");    
   }
   
    private String obtenerCDDef(DTOSalida dtoSalida) throws Exception {
    
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

    private void activarVersion() throws Exception{
         traza("     LPMantenerVerAsigProdAnaqueles.activarVersion(): Entrada");
         
         pagina("salidaGenerica"); 
         
         try {
             DTOMantenerAsignacionProductosAnaqueles dtoAnaq = new DTOMantenerAsignacionProductosAnaqueles();
             
             String oidCD = conectorParametroLimpia("cbCentroDistribucion", "", true); 
             traza("     Cent.Dist. = " + oidCD);
    
             String oidPeri = conectorParametroLimpia("cbPeriodo", "", true); 
             traza("     Período = " + oidPeri);
             
             String oidProdAnaq = conectorParametroLimpia("hOidProdAnaq", "", true); 
             traza("     ProdAnaqLista = " + oidProdAnaq);
             
             // vbongiov -- Cambio APE-02 -- 19/11/2007
             String oidLinea = conectorParametroLimpia("hOidLinea", "", true); 
             traza("     oidLinea = " + oidLinea);
             
             dtoAnaq.setOidCentroDistribucion(Long.valueOf(oidCD));
             dtoAnaq.setOidPeriodo(Long.valueOf(oidPeri));
             dtoAnaq.setOidAsignacionProductoAnaquel(Long.valueOf(oidProdAnaq));
             dtoAnaq.setOidLineaArmado(Long.valueOf(oidLinea));
             
             Vector param = new Vector();
             MareBusinessID businessID = new MareBusinessID("APEActivarVersionAsignacionProductosAnaqueles");
             
             param.add(dtoAnaq);
             param.add(businessID);
             
             traza("Antes de conectar...");
             DruidaConector con = conectar("ConectorActivarVersion", param);
             traza("Después de conectar...");
             
             // Recargamos la lista.
             asignarAtributo("VAR", "ejecutar", "valor", "onClickBuscar()");
             
         
         } catch (Exception e)  {
             
             traza("Error: " + e);
             throw e;
         }
    
         traza("     LPMantenerVerAsigProdAnaqueles.activarVersion(): Salida");    
    }
    
    // vbongiov -- Cambio APE-02 -- 19/11/2007
    private void desactivarVersion() throws Exception{
         traza("LPMantenerVerAsigProdAnaqueles.desactivarVersion(): Entrada");
         
         pagina("salidaGenerica"); 
         
         try {
             DTOMantenerAsignacionProductosAnaqueles dtoAnaq = new DTOMantenerAsignacionProductosAnaqueles();
             
             String oidProdAnaq = conectorParametroLimpia("hOidProdAnaq", "", true); 
             traza("     ProdAnaqLista = " + oidProdAnaq);
          
             dtoAnaq.setOidAsignacionProductoAnaquel(Long.valueOf(oidProdAnaq));
             
             Vector param = new Vector();
             MareBusinessID businessID = new MareBusinessID("APEDesactivarVersionAsignacionProductosAnaqueles");
             
             param.add(dtoAnaq);
             param.add(businessID);
             
             traza("Antes de conectar...");
             DruidaConector con = conectar("ConectorDesactivarVersion", param);
             traza("Después de conectar...");
             
             // Recargamos la lista.
             asignarAtributo("VAR", "ejecutar", "valor", "onClickBuscar()");
             
         
         } catch (Exception e)  {
             
             traza("Error: " + e);
             throw e;
         }
    
         traza("     LPMantenerVerAsigProdAnaqueles.desactivarVersion(): Salida");    
    }



}