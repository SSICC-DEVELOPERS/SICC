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

import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacionCab;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacion;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;

import es.indra.druida.Contexto;

public class LPEjecutarReterritorializacion extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
         
    public LPEjecutarReterritorializacion() {    
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
           String cbTerrPartir = conectorParametroLimpia("cbTerrPartir", "", true);     
           String cbTerrOrigTrasv = conectorParametroLimpia("cbTerrOrigTrasv", "", true);  
           String tipoOperacion = conectorParametroLimpia("cbTipoOperacion", "", true);      
           
           DTOOID dtoOid= new DTOOID();
           
           if(tipoOperacion.equals("P")){
                dtoOid.setOid(Long.valueOf(cbTerrPartir));
                
           } else if(tipoOperacion.equals("T")){
                dtoOid.setOid(Long.valueOf(cbTerrOrigTrasv));
           }           
           
           MareBusinessID id = new MareBusinessID("ZONBuscarUAPadre");             
           Vector paramEntrada = new Vector();
         
           paramEntrada.add(dtoOid);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorBuscarUAPadre", paramEntrada);
           traza("*************** Despues de conectar");
           
           DTOString dtoString = (DTOString)con.objeto("DTOString"); 
           
           asignarAtributo("VAR", "ejecutar", "valor", "guardarUAPadre('" + dtoString.getCadena() + "');");
           
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
           String cbTerrPartir = conectorParametroLimpia("codTerrPartir", "", true);     
           String cbTerrOrigTrasv = conectorParametroLimpia("codTerrOrigTrasv", "", true); 
           String uaPadre = conectorParametroLimpia("UAPadre", "", true);    
           
           String tipoOperacion = conectorParametroLimpia("cbTipoOperacion", "", true);     
           
           String listaDetalles = conectorParametroLimpia("listaDetalles", "", true);
           
           String codTerr1Fusionar = conectorParametroLimpia("codTerr1Fusionar", "", true);
           String codTerr2Fusionar = conectorParametroLimpia("codTerr2Fusionar", "", true);
           String txtTerrCrearFusion = conectorParametroLimpia("txtTerrCrearFusion", "", true);
           String cbNSE1Fusion = conectorParametroLimpia("cbNSE1Fusion", "", true);
           String cbNSE2Fusion = conectorParametroLimpia("cbNSE2Fusion", "", true);
      
           //traza("listaDetalles: " + listaDetalles);
           
           DTOEjecutarReterritorializacion dtoEjecutarReterritorializacion = new DTOEjecutarReterritorializacion();
           DTOEjecutarReterritorializacionCab dtoEjecutarReterritorializacionCab = new DTOEjecutarReterritorializacionCab();
           ArrayList detalles= new ArrayList();
           
           traza("Cabecera");
           
           // Arma la cabecera
           dtoEjecutarReterritorializacionCab.setOidPais(UtilidadesSession.getPais(this));
           dtoEjecutarReterritorializacionCab.setOidMarca(Long.valueOf(oidMarca));
           dtoEjecutarReterritorializacionCab.setOidCanal(Long.valueOf(oidCanal));
           dtoEjecutarReterritorializacionCab.setOidPeriodoInicio(Long.valueOf(oidPeriodo));
           
           traza("dtoEjecutarReterritorializacionCab: "+ dtoEjecutarReterritorializacionCab);
           
           traza("Detalle");
           DTORezonificacionRegistro dtoRezonificacionRegistro= null;
           // Arma el detalle para Particion y Trasvase
           if(!listaDetalles.equals("")) {
                
             StringTokenizer stkListaDetalles = new StringTokenizer(listaDetalles,"|");
             StringTokenizer stkRegDetalle = null;
                      
             while (stkListaDetalles.hasMoreTokens()) {
                stkRegDetalle = new StringTokenizer(stkListaDetalles.nextToken(),"#");
                dtoRezonificacionRegistro = new DTORezonificacionRegistro();
                
                if(tipoOperacion.equals("P")){
                
                    dtoRezonificacionRegistro.setTipoOp("P");
                    dtoRezonificacionRegistro.setDatoOrigen1(uaPadre + cbTerrPartir);                    
                    dtoRezonificacionRegistro.setDatoOrigen2(uaPadre + stkRegDetalle.nextToken());
                    dtoRezonificacionRegistro.setCodCliente(stkRegDetalle.nextToken());
                    dtoRezonificacionRegistro.setNse1(stkRegDetalle.nextToken());
                    dtoRezonificacionRegistro.setNse2(stkRegDetalle.nextToken());
                    
                } else if(tipoOperacion.equals("T")){
                
                    dtoRezonificacionRegistro.setTipoOp("T");
                    dtoRezonificacionRegistro.setDatoOrigen1(uaPadre + cbTerrOrigTrasv);                    
                    dtoRezonificacionRegistro.setDatoOrigen2(stkRegDetalle.nextToken());
                    dtoRezonificacionRegistro.setCodCliente(stkRegDetalle.nextToken());
                  
                } 
                             
                detalles.add(dtoRezonificacionRegistro);
             }
           }         
           
           // Arma el detalle para Fusion
           if(tipoOperacion.equals("F")){
                
                // Detalle
                dtoRezonificacionRegistro = new DTORezonificacionRegistro();
                dtoRezonificacionRegistro.setTipoOp("F");
                dtoRezonificacionRegistro.setDatoOrigen1(codTerr1Fusionar);                    
                dtoRezonificacionRegistro.setDatoOrigen2(codTerr2Fusionar);
                dtoRezonificacionRegistro.setDatoNuevo(txtTerrCrearFusion);
                dtoRezonificacionRegistro.setCodCliente(null);
                dtoRezonificacionRegistro.setNse1(cbNSE1Fusion);
                dtoRezonificacionRegistro.setNse2(cbNSE2Fusion);
                
                detalles.add(dtoRezonificacionRegistro);
           }
           
           traza("detalles: " + detalles);
           
           traza("TMP.UPLOAD2: " + Contexto.getPropiedad("TMP.UPLOAD2"));
           
           // Guardar
           dtoEjecutarReterritorializacion.setPathFichero(Contexto.getPropiedad("TMP.UPLOAD2"));
           dtoEjecutarReterritorializacion.setTipoOp(tipoOperacion);
           dtoEjecutarReterritorializacion.setCabecera(dtoEjecutarReterritorializacionCab);
           dtoEjecutarReterritorializacion.setRegistros(detalles);
           
           dtoEjecutarReterritorializacion.setOidPais(pais);
           dtoEjecutarReterritorializacion.setOidIdioma(idioma);
           
           MareBusinessID id = new MareBusinessID("ZONLanzarEjecutarReterritorializacion");             
           Vector paramEntrada = new Vector();
         
           paramEntrada.add(dtoEjecutarReterritorializacion);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorEjecutarReterritorializacion", paramEntrada);
           traza("*************** Despues de conectar");
           
           asignarAtributo("VAR", "ejecutar", "valor", "mensajeProcesando();");
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaBuscar();");
         throw e;
      }
  }
  
    
  private void cargarPantalla() throws Exception{
    
    pagina("contenido_ejecutar_reterritorializacion");
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