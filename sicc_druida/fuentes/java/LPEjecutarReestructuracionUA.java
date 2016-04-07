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
 * Autor: Viviana Bongiovanni
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
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

import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUACab;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUA;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUAReg;
import es.indra.sicc.dtos.zon.DTOCodUA;
import es.indra.sicc.util.DTOString;

import es.indra.druida.Contexto;

public class LPEjecutarReestructuracionUA extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
          
    public LPEjecutarReestructuracionUA() {    
          super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
      try {      
          setTrazaFichero();
          String accion = conectorParametroLimpia("accion", "", true);
          traza("accion: " + accion);
          
          pais = UtilidadesSession.getPais(this);
          idioma = UtilidadesSession.getIdioma(this);
          
          if(accion.equals("")) { 
            this.cargarPantalla();
            
          } else if(accion.equals("buscar")){ 
            this.buscar();  
            
          } else if(accion.equals("guardar")){ 
            this.guardar();             
          } 
          
      } catch (Exception e){   
            traza(e);      
            this.lanzarPaginaError(e);
      }
      getConfiguracionMenu();
  }
  
  private void buscar() throws Exception{
      pagina("salidaGenerica");
      
      try {      
            String UAProcesar = conectorParametroLimpia("UAProcesar", "", true);     
            String oidUAProcesar = conectorParametroLimpia("oidUAProcesar", "", true);     
      
            
            DTOCodUA dtoCodUA= new DTOCodUA();
            
            dtoCodUA.setOidUA(Long.valueOf(oidUAProcesar));
            dtoCodUA.setJerarquia(UAProcesar);
            
            MareBusinessID id = new MareBusinessID("ZONBuscarCodUA");              
            Vector paramEntrada = new Vector();
          
            paramEntrada.add(dtoCodUA);
            paramEntrada.add(id);
            traza("*************** Antes de conectar");
            DruidaConector con = conectar("ConectorBuscarCodUA", paramEntrada);
            traza("*************** Despues de conectar");
            
            DTOCodUA dtoCodUAOrigen = (DTOCodUA)con.objeto("DTOCodUA"); 
            
            traza("dtoCodUAOrigen: " + dtoCodUAOrigen);
            
            asignarAtributo("VAR", "ejecutar", "valor", 
                                "guardarCodUAs('" + dtoCodUAOrigen.getCodUAPadre() + "','" + dtoCodUAOrigen.getCodUA() + "');");
            
      } catch(Exception e) {
          traza("Excepcion: " + e);
          asignarAtributo("VAR", "ejecutarError", "valor", "focalizaBuscar();");
          throw e;
      }
  }

  private void guardar() throws Exception{
      pagina("salidaGenerica");
      
      try {            
            String oidMarca = conectorParametroLimpia("cbMarca", "", true); 
            String oidCanal = conectorParametroLimpia("cbCanal", "", true);    
            String oidPeriodo = conectorParametroLimpia("cbPeriodo", "", true);     
            String codUAPadreOrigen = conectorParametroLimpia("codUAPadreOrigen", "", true);    
            String codUAOrigen = conectorParametroLimpia("codUAOrigen", "", true);    
            String UAProcesar = conectorParametroLimpia("UAProcesar", "", true);  
            
            String tipoOperacion = conectorParametroLimpia("cbTipoOperacion", "", true);     
            
            String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);
            
            String cbUA2Fusionar = conectorParametroLimpia("cbUA2Fusionar", "", true);
            String txtUACrearFusion = conectorParametroLimpia("txtUACrearFusion", "", true);
            String cbNSE1Fusion = conectorParametroLimpia("cbNSE1Fusion", "", true);
            String cbNSE2Fusion = conectorParametroLimpia("cbNSE2Fusion", "", true);
      
            //traza("listaDetalles: " + listaDetalles);
            
            DTOEjecutarReestructuracionUA dtoEjecutarReestructuracionUA = new DTOEjecutarReestructuracionUA();
            DTOEjecutarReestructuracionUACab dtoEjecutarReestructuracionUACab = new DTOEjecutarReestructuracionUACab();
            ArrayList detalles= new ArrayList();
            
            traza("Cabecera");
            
            // Arma la cabecera
            dtoEjecutarReestructuracionUACab.setOidPais(UtilidadesSession.getPais(this));
            dtoEjecutarReestructuracionUACab.setOidMarca(Long.valueOf(oidMarca));
            dtoEjecutarReestructuracionUACab.setOidCanal(Long.valueOf(oidCanal));
            dtoEjecutarReestructuracionUACab.setOidPeriodoInicio(Long.valueOf(oidPeriodo));
            
            traza("dtoEjecutarReestructuracionUACab: "+ dtoEjecutarReestructuracionUACab);
            
            traza("Detalle");
            DTOEjecutarReestructuracionUAReg dtoEjecutarReestructuracionUAReg= null;
            // Arma el detalle para Particion y Trasvase
            if(!listaDetalles.equals("")) {
                  
              StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
              StringTokenizer stkRegDetalle = null;
                         
              while (stkListaDetalles.hasMoreTokens()) {
                  stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"#");
                  dtoEjecutarReestructuracionUAReg = new DTOEjecutarReestructuracionUAReg();
                  
                  if(tipoOperacion.equals("P")){
                  
                      dtoEjecutarReestructuracionUAReg.setTipoOp("P");
                      dtoEjecutarReestructuracionUAReg.setDatoOrigen1(codUAOrigen);                      
                      dtoEjecutarReestructuracionUAReg.setDatoOrigen2(codUAPadreOrigen + stkRegDetalle.nextToken());
                      dtoEjecutarReestructuracionUAReg.setOidUA(Long.valueOf(stkRegDetalle.nextToken()));
                      dtoEjecutarReestructuracionUAReg.setJerarquia(UAProcesar);
                      dtoEjecutarReestructuracionUAReg.setNse1(stkRegDetalle.nextToken());
                      dtoEjecutarReestructuracionUAReg.setNse2(stkRegDetalle.nextToken());
                      
                  } else if(tipoOperacion.equals("T")){
                  
                      dtoEjecutarReestructuracionUAReg.setTipoOp("T");
                      dtoEjecutarReestructuracionUAReg.setDatoOrigen1(codUAOrigen);         
                      dtoEjecutarReestructuracionUAReg.setOidUADestTrasv(Long.valueOf(stkRegDetalle.nextToken()));
                      dtoEjecutarReestructuracionUAReg.setCodUA(stkRegDetalle.nextToken());
                      dtoEjecutarReestructuracionUAReg.setJerarquia(UAProcesar);
                  } 
                                 
                  detalles.add(dtoEjecutarReestructuracionUAReg);
              }
            }          
            
            // Arma el detalle para Fusion
            if(tipoOperacion.equals("F")){
                  
                  // Detalle
                  dtoEjecutarReestructuracionUAReg = new DTOEjecutarReestructuracionUAReg();
                  dtoEjecutarReestructuracionUAReg.setTipoOp("F");
                  dtoEjecutarReestructuracionUAReg.setDatoOrigen1(codUAOrigen);  
                  dtoEjecutarReestructuracionUAReg.setOidUA(Long.valueOf(cbUA2Fusionar));
                  dtoEjecutarReestructuracionUAReg.setJerarquia(UAProcesar);
                  dtoEjecutarReestructuracionUAReg.setDatoNuevo(codUAPadreOrigen + txtUACrearFusion);
                  dtoEjecutarReestructuracionUAReg.setNse1(cbNSE1Fusion);
                  dtoEjecutarReestructuracionUAReg.setNse2(cbNSE2Fusion);
                  
                  detalles.add(dtoEjecutarReestructuracionUAReg);
            }
            
            traza("detalles: " + detalles);
            
            traza("TMP.UPLOAD2: " + Contexto.getPropiedad("TMP.UPLOAD2"));
            
            // Guardar
            dtoEjecutarReestructuracionUA.setPathFichero(Contexto.getPropiedad("TMP.UPLOAD2"));
            dtoEjecutarReestructuracionUA.setTipoOp(tipoOperacion);
            dtoEjecutarReestructuracionUA.setCabecera(dtoEjecutarReestructuracionUACab);
            dtoEjecutarReestructuracionUA.setRegistros(detalles);
            
            dtoEjecutarReestructuracionUA.setOidPais(pais);
            dtoEjecutarReestructuracionUA.setOidIdioma(idioma);
            
            MareBusinessID id = new MareBusinessID("ZONLanzarEjecutarReestructuracionUA");              
            Vector paramEntrada = new Vector();
          
            paramEntrada.add(dtoEjecutarReestructuracionUA);
            paramEntrada.add(id);
            traza("*************** Antes de conectar");
            DruidaConector con = conectar("ConectorEjecutarReestructuracionUA", paramEntrada);
            traza("*************** Despues de conectar");
            
            DTOString dtoNombreFichero = (DTOString)con.objeto("DTOString"); 
            
            traza("dtoNombreFichero: " + dtoNombreFichero);
            
            asignarAtributo("VAR", "ejecutar", "valor", "continuarConRezonificacion('"+ dtoNombreFichero.getCadena() +"');");
            
      } catch(Exception e) {
          traza("Excepcion: " + e);
          asignarAtributo("VAR", "ejecutarError", "valor", "focalizaBuscar();");
          throw e;
      }
  }
  
    
  private void cargarPantalla() throws Exception{
    
    pagina("contenido_ejecutar_reestructuracionUA");
    // Validaciones
    getFormatosValidaciones();
    
    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()));
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()));
    
    this.cargarCombos();
  }

    
  private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
          
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");   
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");   
    asignar("COMBO","cbNSE1",resultados,"ZONObtenerNivelSocioEconomico");   
    asignar("COMBO","cbNSE2",resultados,"ZONObtenerNivelSocioEconomico");   
    asignar("COMBO","cbNSE1Fusion",resultados,"ZONObtenerNivelSocioEconomico");   
    asignar("COMBO","cbNSE2Fusion",resultados,"ZONObtenerNivelSocioEconomico");   
  }
  
 
    
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(pais);
      dtoBel.setOidIdioma(idioma);
      
      ComposerViewElement marca = new ComposerViewElement();
            
      marca.setIDBusiness("SEGConsultaMarcas");
      marca.setDTOE(dtoBel);
            
      lista.addViewElement(marca);
      
      ComposerViewElement canal = new ComposerViewElement();
            
      canal.setIDBusiness("SEGConsultaCanales");
      canal.setDTOE(dtoBel);
            
      lista.addViewElement(canal);
      
      ComposerViewElement nivelSociEcon = new ComposerViewElement();
            
      nivelSociEcon.setIDBusiness("ZONObtenerNivelSocioEconomico");
            
      lista.addViewElement(nivelSociEcon);
      
      return lista;
    }
    
}