import es.indra.sicc.util.*;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;


public class LPTratarSolicitudBloqueo extends LPSICCBase {

  private String accion = null;  
  private String pais = null;
  private String idioma = null;
  private String formatoFechaPais = null;
  private Boolean anular = null;  
  
  
  public LPTratarSolicitudBloqueo() {   
      super();  
  }


  public void inicio() throws Exception {        
   
  } 
  
  
  
  public void ejecucion() throws Exception {
  setTrazaFichero();

         accion     	= conectorParametroLimpia("accion", "", true);
         traza("accion>>>> " + accion);
         
         pais 	  	= UtilidadesSession.getPais(this).toString();
         traza("pais >>>>  "  +pais );
         
  idioma         = UtilidadesSession.getIdioma(this).toString();
         traza("idioma >>>> " + idioma);	
  
  formatoFechaPais          = UtilidadesSession.getFormatoFecha(this);

         try {
                           
      traza("antes de cargar>>>>");     
      rastreo();      
      mostrarPaginas();      
                           asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
      asignarAtributo("VAR","hPais","valor",pais);
                    asignarAtributo("VAR","hIdioma","valor",idioma);	     
                           traza("FECHA>>>> " + formatoFechaPais);
      
   
      traza("accion>>>> " + accion);

          asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString() );
          traza("this.obtenerLongitudCodigoCliente().toString(): "+ this.obtenerLongitudCodigoCliente().toString() );      
      
      if (accion.equals("")) 
                           { 
                                    cargarPagina();
      }else if (accion.equals("bloqueoDesbloqueo")){
                  bloqueoDesbloqueo();    

           }else if(accion.equals("grabar")){
          grabar();      
      }else if(accion.equals("anular")){
          anular = Boolean.TRUE;
                   grabar();      
      }          
  }
    catch ( Exception e )  {
      traza("Exception en LPTratarSolicitudBloqueo");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
 
 
 
 
 private void cargarPagina() throws Exception
 {      
    traza("en cargarCombo >>>");
         
    /**
     * -> Crear un DTOBelcorp con pais e idioma de la sesión 
      -> Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
      - idBusiness = "CCCObtenerTiposCargo" y DTOBelcorp => llena el combo "tipoCargo" 
      - idBusiness = "COBObtenerUsuariosCobCombo" y DTOBelcorp => llena el combo "usuarioCobranzas" 
      - idBusiness = "SEGConsultaMarcas" => llena el combo "marca" 
      - idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena el combo "canal" 
      -> Mostrar página 
     * 
     * 
     * */
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidIdioma(new Long(idioma));
    dtoe.setOidPais(new Long(pais));
    traza("PASO 1");
    ComposerViewElementList lista = new ComposerViewElementList();  
    traza("PASO 2");   
    
    
    /** Obtenemos los tipoCargo */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("CCCObtenerTiposCargo");
    cmb1.setDTOE(dtoe);  
    
    
    /** Obtenemos los usuarioCobranzas */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("COBObtenerUsuariosCobCombo");
    cmb2.setDTOE(dtoe); 
     
    
    /** Obtenemos las marcas */
   ComposerViewElement cmb3 = new ComposerViewElement();
   cmb3.setIDBusiness("SEGConsultaMarcas"); 
   cmb3.setDTOE(dtoe);
  
    
    /** Obtenemos los canales */
   ComposerViewElement cmb4 = new ComposerViewElement();
    cmb4.setIDBusiness("SEGConsultaCanales"); 
    cmb4.setDTOE(dtoe);
    traza("cmb4***** " + cmb4);
  
    lista.addViewElement(cmb1);   
    lista.addViewElement(cmb2);
    lista.addViewElement(cmb3);
    lista.addViewElement(cmb4);  
    
    traza("PASO 3");
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    traza("a");
    conector.ejecucion();
    traza("PASO 4");
    DruidaConector resultados = conector.getConector();   
    traza("resultados>>>>> " + resultados);
    
    
    asignar("COMBO","cbTipoCargo", resultados,"CCCObtenerTiposCargo");                                      
    asignar("COMBO","cbUsuarioCobranza", resultados,"COBObtenerUsuariosCobCombo");      
    asignar("COMBO","cbCanal", resultados,"SEGConsultaCanales");                                             
    asignar("COMBO","cbMarca", resultados,"SEGConsultaMarcas"); 
  }
         

 
 
 private void bloqueoDesbloqueo() throws Exception
 {      
   /*
    * 1. Recuperar el oid del registro seleccionado en la lista editable de la 
    *   ventana llamante 
    * 2. Asignar la pantalla de la ventana "contenido_solicitudes_bloqueo_tratar_2" 
    * 3. Asignar el oid a la variable oculta oidGestionDeCobranza
    **/
     
     String oidRegistro = conectorParametro("oidRegis");     
     String codigoC = conectorParametro("uno");  
     String indBloqueo = conectorParametro("indBloqueo");     
     String indDesbloqueo = conectorParametro("indDesbloqueo");  
     String oidCliente = conectorParametro("hOidCliente");  
     String oid = conectorParametro("oidTipoBloqueo");  

     traza("oidRegistro>>>>>>>>>>>>> " + oidRegistro);     
     traza("codigoC*** " + codigoC);
     traza("indBloqueo "+indBloqueo);     
     traza("indDesbloqueo "+indDesbloqueo);  
     traza("oidCliente "+oidCliente);  
     traza("oidTipoBloqueo "+oid);  
     
     asignarAtributo("VAR","oidGestionDeCobranzaH","valor",oidRegistro);   
     asignarAtributo("VAR","codigoCliente","valor",codigoC);  
          asignarAtributo("VAR","hIndBloqueo","valor",indBloqueo);  
          asignarAtributo("VAR","hIndDesBloqueo","valor",indDesbloqueo);  
          asignarAtributo("VAR","hOidCliente","valor",oidCliente);

         try	{
                           

                  MareBusinessID idBusiness = new MareBusinessID("COBObtenerBloqueoClientes");

                  DTOGestionDeCobranza dto = new DTOGestionDeCobranza();
                  dto.setOidPais(new Long(pais));
                  dto.setOidIdioma(new Long(idioma));
                  dto.setOid(new Long(oidRegistro));
                  dto.setOidCliente(new Long(oidCliente));
                  
                  if(indBloqueo.toString().equals("1")){
                           dto.setPeticionBloqueoAdmin(Boolean.TRUE);
                  }else{
                           dto.setPeticionBloqueoAdmin(Boolean.FALSE);
                  }
                  
                  if(indDesbloqueo.toString().equals("1")){
                           dto.setPeticionDesbloqueoAdmin(Boolean.TRUE);
                  }else{
                           dto.setPeticionDesbloqueoAdmin(Boolean.FALSE);
                  }


                  Vector parametros = new Vector();
                  parametros.add(dto);
                  parametros.add(idBusiness);
                  DruidaConector conector = conectar("ConectorObjeto", parametros);
                  DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
                  RecordSet retorno = dtoRetornado.getResultado();

         // vbongiov -- 27/05/2008
                  if(dto.getPeticionBloqueoAdmin().booleanValue() && !retorno.esVacio()){
 
                 throw new MareException(new MareException(), UtilidadesError.armarCodigoError(
                                           ConstantesSEG.MODULO_COB, "", "010020") );
         }
         
         if(dto.getPeticionDesbloqueoAdmin().booleanValue()&& retorno.esVacio()){
            
              throw new MareException(new MareException(), UtilidadesError.armarCodigoError(
                                           ConstantesSEG.MODULO_COB, "", "010021") );
         }

                  if(dto.getPeticionDesbloqueoAdmin().booleanValue()&& !retorno.esVacio()){
                           oid = (retorno.getValueAt(0, "OID")).toString();
                           String descripcion = (retorno.getValueAt(0, "DES")).toString();
                           String motivo = (retorno.getValueAt(0, "VAL_MOTI_BLOQ")).toString();
                           String obserBloqueo = (retorno.getValueAt(0, "OBS_BLOQ")).toString();

                            asignarAtributo("VAR","hObsBloqueo","valor",obserBloqueo);  
                            asignarAtributo("VAR","hMotivo","valor",motivo);


                            asignarAtributo("VAR","desTipoBloqueo","valor",descripcion);

                           /*String funcion = new String("asignarDatosTipoBloqueo('" + oid +";"+descripcion+"|"+motivo+"|"+obserBloqueo+"')");
              traza("funcion "+funcion);  
                           asignarAtributo("VAR", "ejecutar", "valor", funcion);*/
                  }
                   asignarAtributo("VAR","oidTipoBloqueo","valor",oid);  

         }catch (Exception e){   
        asignarAtributo("VAR","hCierraVentana","valor","1");
//          asignarAtributo("VAR", "ejecutarError", "valor", "errorTipoBloqueo()");
            throw e;
         }

    
 } 
 
         
  
  private void grabar() throws Exception{
  /*
   * ->Crear un DTOGestionDeCobranza con: 
      => oid , get(oid) 
      => observaciones, get(observaciones) 
      => Se crea el IDBusiness = COBGuardarBloqueoDesbloqueo 
      => Asignar el conector ConectorGuardarBloqueoDesbloqueo con IDBusiness y
      DTOGestionDeCobranza   
   *
   * */

 //  String oid = conectorParametro("oidRegis");
   pagina("salidaGenerica");
   //String oid = conectorParametro("oidGestionDeCobranzaH"); 

   String oidTipoBloqueo = conectorParametro("oidTipoBloqueo");
   String obsBloqueo = conectorParametro("hObsBloqueo");
   String obsDesBloq = conectorParametro("hObsDesBloq");
   
   String indBloqueo = conectorParametro("hIndBloqueo");
   String indDesBloq = conectorParametro("hIndDesBloqueo");

   String obser = conectorParametro("hMotivo");
   String oid = conectorParametro("oidGestionDeCobranzaH");
   
   String codigoC = conectorParametro("codigoCliente");
   
   traza("oid>>><" + oid);
   traza("obser>>>>" + obser);
   
   traza("codigo>>> " + codigoC);
  
   
  DTOGestionDeCobranza dto = new DTOGestionDeCobranza();
  
  try{
           dto.setOid(new Long(oid));
           dto.setObservaciones(obser);
           dto.setOidIdioma(new Long(idioma));
           dto.setOidPais(new Long(pais));
           dto.setCodigoCliente(codigoC);

                    dto.setOidTipoBloqueo(new Long(oidTipoBloqueo));
                    dto.setMotivoBloqueo(obser);
           dto.setObservacionesBloqueo(obsBloqueo);
                    dto.setObservacionesDesbloqueo(obsDesBloq);   
                    if(indBloqueo.toString().equals("1")){
                           dto.setPeticionBloqueoAdmin(Boolean.TRUE);
                    }else{
                           dto.setPeticionBloqueoAdmin(Boolean.FALSE);
                    }
                           
                    if(indDesBloq.toString().equals("1")){
                           dto.setPeticionDesbloqueoAdmin(Boolean.TRUE);
                    }else{
                           dto.setPeticionDesbloqueoAdmin(Boolean.FALSE);
                    }
                           dto.setIndAnular(anular);
           
           MareBusinessID id = new MareBusinessID("COBGuardarBloqueoDesbloqueo");
           Vector paramEntrada = new Vector();
           paramEntrada.add(dto);
           paramEntrada.add(id);
           
           
           traza("contenido del vector:::::: ++ " + paramEntrada);
         
           traza("antes del conector");
           DruidaConector conectorObjeto = conectar("ConectorGuardarBloqueoDesbloqueo", paramEntrada);
           traza("despues del conector");
           
           asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");  
           asignarAtributo("VAR", "accion", "valor", " ");  
   
         }catch(Exception e){         
                              asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");             
                              throw e;
         }
  
 
  
 }
 
 
 
 private void mostrarPaginas() throws Exception
 {
         traza("nombreLP>>>>x**** " + accion); 

         if (accion.equals("")){
                   pagina("contenido_solicitudes_bloqueo_tratar");
     getConfiguracionMenu("LPTratarSolicitudBloqueo","");        
                  //asignarAtributoPagina("cod", "0331");

         }
  if (accion.equals("bloqueoDesbloqueo")){
         pagina("contenido_solicitudes_bloqueo_tratar_2");   
         getConfiguracionMenu("LPTratarSolicitudBloqueo","grabar");
        // asignarAtributoPagina("cod", "0331");
   }else{
 
          pagina("contenido_solicitudes_bloqueo_tratar");
           getConfiguracionMenu("LPTratarSolicitudBloqueo","");
          
   }
   this.getFormatosValidaciones();

 }


}//Fin de la LP

