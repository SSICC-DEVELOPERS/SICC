/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Españaamo
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOClasificacion;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;

public class LPMantenerParametrosConsultoras extends LPIncentivos {    
    private Long lIdioma = null;
    private Long lPais = null;
    private DTOListaEstatusVenta dtoListaEstatusVtaAuxiliar = new DTOListaEstatusVenta();
    private DTOListaMontoVentaRecomendadas dtoListaMVRAuxiliar = new DTOListaMontoVentaRecomendadas();
    private DTOClasificacionParticipantes dtoListaClasParticipantesAux = new DTOClasificacionParticipantes();
         //Cleal - 21857
         private DTOListaEstatusVenta dtoListaEstatusVtaCalifAuxiliar = new DTOListaEstatusVenta();
    
    public LPMantenerParametrosConsultoras() { super(); }

    public void inicio() throws Exception {
         this.obtenerFlagsPestanyas();
         pagina("contenido_parametros_consultoras_mantener");
         this.cargarFlagsPestanyas();
                  this.getFormatosValidaciones();
    }

    public void ejecucion() throws Exception {
         setTrazaFichero();
         try{
             accion = conectorParametro("accion")==null?"":conectorParametro("accion");
             opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
             
             DTOConcurso dtoConcurso = this.getConcurso();
             lIdioma = dtoConcurso.getOidIdioma();
             lPais = dtoConcurso.getOidPais();
             
             Long lMarca = UtilidadesSession.getMarcaPorDefecto(this);
             Long lCanal = UtilidadesSession.getCanalPorDefecto(this);
             traza(">>>> Entro a LPMantenerParametrosConsultoras");         
             traza(">>>> Acción................" + accion);             
             traza(">>>> opcionMenu............" + opcionMenu);
             traza(">>>> Idioma................" + lIdioma);
             traza(">>>> Pais.................." + lPais);
             traza(">>>> Marca................." + lMarca);             
             traza(">>>> Canal................." + lCanal);

             cargaConstantesEnPantalla();
             if (accion.equals("")){
                  cargarPantalla();
             }
             else if (accion.equals("cargar estatus venta") || accion.equals("cargar estatus venta calificacion")) {
                  cargarPantallaEstatusVenta(); 
             }
             else if (accion.equals("almacenar")) {                    
                  almacenar();
                  this.redirigir();
             }
             else if (accion.equals("cargar monto venta recomendadas")){
                  cargarPantallaMontoVentaRecomendadas(); 
             }
             else if (accion.equals("cargar clasificacion participantes")){
                  cargarPantallaClasificacionParticipantes(); 
             }
             else if (accion.equals("guardar")){
                  almacenar(); 
                  guardar();
             }
             else if (accion.equals("redirigir")){
                  redirigir(); 
             }             
             else if (accion.equals("almacenar estatus venta")){
                  String sListaEstatusVta = this.conectorParametroLimpia("hidLstEstatusVta", "", true);                  
                  pagina("salidaGenerica");        
                                    this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
                  almacenarEstatusVenta(sListaEstatusVta);
                  traza("Almacenada Lista Estatus Venta");
                  asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                  //asignarAtributo("VAR","ejecutarError","valor","accionError()");
             }
             else if (accion.equals("almacenar monto venta recomendadas")){
                  pagina("salidaGenerica");        
                                    this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
                  almacenarMontoVentaRecomendadas();
                  traza("Almacenada Lista monto venta recomendadas");
                  asignarAtributo("VAR","ejecutar","valor","accionExitosa()");

                 // asignarAtributo("VAR","ejecutarError","valor","accionError()");
             }
             else if (accion.equals("almacenar Clasificacion Participantes")){
                  String sLstClasifConsul = this.conectorParametroLimpia("hidLstClasConsul", "", true);                                                                                 
                  String sListaClasif = this.conectorParametroLimpia("hidListaClasif", "", true);
                                                                            
                  traza("sLstClasifConsul: " + sLstClasifConsul);
                  traza("sListaClasif: " + sListaClasif);
                  
                  pagina("salidaGenerica");        
                                    this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
                  almacenarClasificacionParticipantes(sLstClasifConsul, sListaClasif);
                  traza("Almacenada Lista Clasificacion Participantes ");
                  asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                  asignarAtributo("VAR","ejecutarError","valor","accionError()");
             }

                           if(opcionMenu.equals("Crear Consurso")){
                                    asignarAtributoPagina("cod", "0491");
                           } 
                           else if(opcionMenu.equals("Consultar Concurso")){
                                    asignarAtributoPagina("cod", "0493");
                           }
                           else if(opcionMenu.equals("Modificar Concurso")){
                                    asignarAtributoPagina("cod", "0486");
                           }
             
          }catch(Exception ex) {
              logStackTrace(ex);
              this.lanzarPaginaError(ex);
         }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
    
         public void cargarPantalla() throws Exception {
                  traza("*********** Entro a cargarPantalla");

                  //Comienza Carga de combos
         DTOConcurso dtoConcurso = getConcurso();
                  
         DTOBelcorp dtoe = new DTOBelcorp();
         dtoe.setOidIdioma(lIdioma);
         dtoe.setOidPais(lPais);

         DTOPeriodo dtop = new DTOPeriodo();
         dtop.setOidPais(lPais);
         dtop.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
         dtop.setCanal(dtoConcurso.getParamGenerales().getOidCanal());

         ComposerViewElementList cvEL = new ComposerViewElementList();
    
         ComposerViewElement ci1 = new ComposerViewElement();
         ci1.setIDBusiness("INCConsultaBasesCalculo");
         ci1.setDTOE(dtoe);                
         cvEL.addViewElement(ci1);                 
    
         ComposerViewElement ci2 = new ComposerViewElement();
         ci2.setIDBusiness("INCRecuperarTiposExigencia");
         ci2.setDTOE(dtoe);                
         cvEL.addViewElement(ci2);
    
         ComposerViewElement ci3 = new ComposerViewElement();
         ci3.setIDBusiness("CRAObtienePeriodos");
         ci3.setDTOE(dtop);                
         cvEL.addViewElement(ci3);

         ComposerViewElement ci4 = new ComposerViewElement();
         ci4.setIDBusiness("INCConsultaTiposVenta");
         ci4.setDTOE(dtoe);                
         cvEL.addViewElement(ci4);

		 // vbongiov -- Cambio 20080580 -- 13/8/2008
		 DTOBuscarNumConcurso dtoBuscarNumConcurso = new DTOBuscarNumConcurso();
		 dtoBuscarNumConcurso.setOidPais(lPais);
		 dtoBuscarNumConcurso.setIndActivo(Integer.valueOf("1"));

		 ComposerViewElement ci5 = new ComposerViewElement();
         ci5.setIDBusiness("INCCargarNroConcursoVersion");
         ci5.setDTOE(dtoBuscarNumConcurso);                
         cvEL.addViewElement(ci5);

         ConectorComposerView conector = new ConectorComposerView(cvEL, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();

         asignar("COMBO", "cbBaseCalculo", resultados, "INCConsultaBasesCalculo");
         asignar("COMBO", "cbEfectividad", resultados, "INCRecuperarTiposExigencia");
         asignar("COMBO", "cbPeriodoInicialEvaluacion", resultados, "CRAObtienePeriodos");
         asignar("COMBO", "cbTipoVenta", resultados, "INCConsultaTiposVenta");
		 // vbongiov -- Cambio 20080580 -- 13/8/2008
		 asignar("COMBO", "cbConcursoPuntajeRecomendada", resultados, "INCCargarNroConcursoVersion");
                  //Finaliza Carga de combos

                  //Comienza Seleccion del valor elegido en el combo base de calculo
                  traza("*********** 1");
         DTOPlantilla dtoPla = dtoConcurso.getPlantilla();
         Long lPlantillaOidBaseCalculo = dtoPla.getOidBaseCalculo();         
         if (lPlantillaOidBaseCalculo!= null){
             asignarAtributo("VAR","oidPlantillaBaseCalculo","valor", lPlantillaOidBaseCalculo.toString());
         }
                  //Finaliza Seleccion del valor elegido en el combo base de calculo

                  //Comienza seleccion del valor elegido en el combo tipo de venta
                  traza("*********** 2");
                  Long oidTipoVen = dtoPla.getOidTipoVenta();
                  if(oidTipoVen!=null) {
                  asignarAtributo("VAR","oidTipoVenta","valor", oidTipoVen.toString());
                  }
                  //Finaliza seleccion del valor elegido en el combo tipo de venta

                  //Comienza el seteo para el valor elegido en el checkbox Reingresos pierden puntaje
                  traza("*********** 3");
                  DTOParametrosConsultoras dtoParConsultoras = dtoConcurso.getParamConsultoras();
                  traza("*********** dtoParConsultoras " + dtoParConsultoras);
                  if(dtoParConsultoras!=null) {
                           Boolean bReingresos = dtoParConsultoras.getIndReingresosPierdenPuntaje();
                  if(bReingresos!=null) {
                                    if(bReingresos.booleanValue()) {
                                             asignarAtributo("VAR","tempCKReingresos","valor", "S");
                                    }
                                    else {
                                             asignarAtributo("VAR","tempCKReingresos","valor", "N");
                                    }
                           }
                           else {
                                    asignarAtributo("VAR","tempCKReingresos","valor", "N");
                           }
                  }
                  else {
                           asignarAtributo("VAR","tempCKReingresos","valor", "N");
                  }

                  //Finaliza el seteo para el valor elegido en el checkbox Reingresos pierden puntaje
         
                  //Comienza seteo para poner visible o no el boton Participantes
                  traza("*********** 4");
         if (dtoPla.getIndPartParticipantesCompleto() != null){
             String IndPartParticipantesCompleto = obtenerValor( dtoPla.getIndPartParticipantesCompleto() );
                           traza("********* IndPartParticipantesCompleto " + IndPartParticipantesCompleto);
             if (IndPartParticipantesCompleto.equals("S")) { 
                  asignarAtributo("VAR","ocultaParticipante","valor", "1");
             }
         }
                  //Finaliza seteo para poner visible o no el boton Participantes
         
         //Si dtoConcurso.indConsultoras //Si es true el indicador de que ya se había 
                  //rellenado la pestaña, se carga la página con esos datos 
                  traza("*********** 5");
         if (dtoConcurso.getIndConsultoras()!=null && dtoConcurso.getIndConsultoras().booleanValue()){
         //{ 
             traza("Ya se habian cargado datos en la pestaña Consultora. IndConsultoras es TRUE");         
             asignarAtributo("VAR","hidIndConsultoras","valor", "1");
             
             DTOParametrosConsultoras dtoPC = dtoConcurso.getParamConsultoras();
             traza("dtoPC   " + dtoPC);      

             //oidParamConsultoras = dtoConcurso.paramConsultoras.oidParamConsultoras 
             if (dtoPC.getOidParamConsultoras() != null)
                  asignarAtributo("VAR","oidParamConsultoras","valor", 
                      dtoPC.getOidParamConsultoras().toString());
             //txtMontoMinimoPedido = dtoConcurso.paramConsultoras.montoMinimoPedido 
             if (dtoPC.getMontoMinimoPedido() != null)
                  asignarAtributo("CTEXTO","txtMontoMinimo","valor", 
                                         dtoPC.getMontoMinimoPedido().toString());
             //txtUnidadesMinimasPedido = dtoConcurso.paramConsultoras.unidadesMinimasPedido 
             if (dtoPC.getUnidadesMinimasPedido() != null)
                  asignarAtributo("CTEXTO","txtUnidadesMinimas","valor", 
                           dtoPC.getUnidadesMinimasPedido().toString());
             
             //chkReingresosPierdenPuntaje = dtoConcurso.paramConsultoras.IndReingresosPierdenPuntaje
             if (dtoPC.getIndReingresosPierdenPuntaje() != null)
                  asignarAtributo("CHECKBOX","ckReingresos","check", 
                      bool2check(dtoPC.getIndReingresosPierdenPuntaje()));
                           //cbTipoVenta = dtoConcurso.paramConsultoras.OidTipoVenta
                           if(dtoPC.getOidTipoVenta()!=null) {
                  asignarAtributo("VAR","oidTipoVenta","valor", dtoPC.getOidTipoVenta().toString());
                           }

             traza("lPlantillaOidBaseCalculo  " + lPlantillaOidBaseCalculo);    
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ (2) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
             //Si dtoConcurso.plantilla.oidBaseCalculo == null { 
             //lPlantillaOidBaseCalculo = null; // x ssantana, testeo, quitar.
             //if ( lPlantillaOidBaseCalculo == null) {
                  //Seleccionar en cbBaseCalculo el valor correspondiente a dtoConcurso.paramConsultoras.oidBaseCalculo 
                  if (dtoPC.getOidBaseCalculo() != null) {
                      Long lPConsultoraOidBC = dtoPC.getOidBaseCalculo();
                      //lPConsultoraOidBC = new Long(4);
                      //traza("
                      traza("paramConsultoras.oidBaseCalculo   " + lPConsultoraOidBC.toString());
                      asignarAtributo("VAR","oidBaseCalculo","valor", lPConsultoraOidBC.toString());
                           
                      //Si dtoConcurso.paramConsultoras.oidBaseCalculo == ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS { 
                      if (lPConsultoraOidBC.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS)){  
                           //Mostrar la capa Recomendadas con los campos: 
                           //- chkRecomendacionEfectiva = dtoConcurso.paramConsultoras.indRecomendacionEfectiva
                           if ( dtoPC.getIndRecomendacionEfectiva() != null ){
                                asignarAtributo("CHECKBOX","RecomendacionEfectiva","check", 
                                    bool2check(dtoPC.getIndRecomendacionEfectiva()));
                                    traza("Recomendacion efe    " + dtoPC.getIndRecomendacionEfectiva().toString());
                           }

                           //- cbEfectividad = dtoConcurso.paramConsultoras.oidEfectividad 
                           if ( dtoPC.getOidEfectividad()!= null){
                                traza("efectividad   " + dtoPC.getOidEfectividad().toString());
                                asignarAtributo("VAR","hidEfectividad","valor", 
                                    dtoPC.getOidEfectividad().toString());
                           }

                           //- cbPeriodoInicialEvaluacion = dtoConcurso.paramConsultoras.oidPeriodoInicialEvaluacion 
                           if ( dtoPC.getOidPeriodoInicialEvaluacion()!= null)
                                asignarAtributo("VAR","hidPeriodoInicialEval","valor", 
                                         dtoPC.getOidPeriodoInicialEvaluacion().toString());

                           //- txtNroPeriodosEvaluar= dtoConcurso.paramConsultoras.nroPeriodosEvaluar 
                           if ( dtoPC.getNroPeriodosEvaluar() != null )
                                asignarAtributo("CTEXTO","txtNumPeriodosEvaluar","valor", 
                                    dtoPC.getNroPeriodosEvaluar().toString());

                           //- txtNroMinimoPedidos= dtoConcurso.paramConsultoras.nroMinimoPedidos 
                           if ( dtoPC.getNroMinimoPedidos() != null )
                                asignarAtributo("CTEXTO","txtNumMinPedidos","valor", 
                                    dtoPC.getNroMinimoPedidos().toString());

                           //- txtNroMinPedidosRecomendada= dtoConcurso.paramConsultoras.nroMinimoPedidosRecomendada 
                           if ( dtoPC.getNroMinimoPedidosRecomendada() != null )
                                asignarAtributo("CTEXTO","txtNumMinPedidosRecomendadas","valor", 
                                    dtoPC.getNroMinimoPedidosRecomendada().toString()); 
                                    
                           // vbongiov -- 17/03/2008 -- Cambio RI 20080535         
                           if ( dtoPC.getIndPremioCampEfect() != null ){
                                asignarAtributo("CHECKBOX","indPremioCampEfect","check", 
                                    bool2check(dtoPC.getIndPremioCampEfect()));
                                    traza("IndPremioCampEfect:    " + dtoPC.getIndPremioCampEfect().toString());
                           }

						   // vbongiov -- Cambio 20080580 -- 13/8/2008
						   if ( dtoPC.getIndGenerarPuntajeARecomendadas() != null ){
                                asignarAtributo("CHECKBOX","indGenerarPuntajeARecomendadas","check", 
                                    bool2check(dtoPC.getIndGenerarPuntajeARecomendadas()));
                                    traza("IndGenerarPuntajeARecomendadas:    " + dtoPC.getIndGenerarPuntajeARecomendadas().toString());
                           }

						   if ( dtoPC.getOidConcursoPuntajeRecomendada()!= null)
                                asignarAtributo("VAR","hidOidConcursoPuntajeRecomendada","valor", 
                                         dtoPC.getOidConcursoPuntajeRecomendada().toString());

                                //- btMontoVentaRecomendada 
                                //} 
                      }                  
                      //en otro caso { 
                      else{ //Ocultar la capa Recomendadas con los campos: 
                      }//}
                  }
             //}//} // fin Si dtoConcurso.plantilla.oidBaseCalculo == null 
         }//} // fin dtoConcurso.indConsultoras
         //traza("Antes de cargarFlagsPestanyas");
         //cargarFlagsPestanyas();
         //---------------------------- Inc 17662 -------------------------------
                  traza("*********** 6");
         if (dtoConcurso.getEstatusVentaConsultoras() != null){
                           //Cleal - INC 06
             dtoListaEstatusVtaAuxiliar = dtoConcurso.getEstatusVentaConsultoras();
             this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);
         }
             
         if (dtoConcurso.getListaMontoVentaRecomendadas()!= null){
             dtoListaMVRAuxiliar = dtoConcurso.getListaMontoVentaRecomendadas();
             this.getSessionCache().put("dtoLstMVR", dtoListaMVRAuxiliar);
         }
         
         if (dtoConcurso.getClasificParticipantes()!= null){
             dtoListaClasParticipantesAux = dtoConcurso.getClasificParticipantes();
             this.getSessionCache().put("dtoLstClasPar", dtoListaClasParticipantesAux);
         }
         //---------------------------- Inc 17662 -------------------------------

                  traza("Asignando " + opcionMenu + " y " + accion);
                  asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);         
             asignarAtributo("VAR","accion","valor", this.accion);

                  getConfiguracionMenu("LPMantenerParametrosConsultoras","");
    }
    
    public void cargarPantallaEstatusVenta() throws Exception{
         traza("Entrando a cargarPantallaEstatusVenta");
         pagina("contenido_estatus_venta_mantener");
//dtoConcurso = getConcurso() //el dtoConcurso es una variable de la LPIncentivos que la hereda esta LPMantenerEsatusVenta 
         concurso = this.getConcurso();

         traza("Marca:   " + concurso.getParamGenerales().getOidMarca());
         traza("Canal:   " + concurso.getParamGenerales().getOidCanal());

//Crear un DTOBelcorp dtob con: 
//- pais = dtoConcurso.pais 
//- idioma = dtoConcurso.idioma 
         DTOBelcorp dtob = new DTOBelcorp();
         dtob.setOidIdioma(concurso.getOidIdioma());
         dtob.setOidPais(concurso.getOidPais());

//Crear un DTOPeriodo dtop con: 
//- pais = dtoConcurso.pais 
//- marca = dtoConcurso.paramGenerales.oidMarca 
//- canal = dtoConcurso.paramGenerales.oidCanal 
         DTOPeriodo dtop = new DTOPeriodo();
         dtop.setOidPais(concurso.getOidPais());
         dtop.setMarca(concurso.getParamGenerales().getOidMarca());
         dtop.setCanal(concurso.getParamGenerales().getOidCanal());

//Crear una lista ComposerViewElementList 
         ComposerViewElementList cvEL = new ComposerViewElementList();
//Obtenemos los estatus de clientes 
//Crear un elemento de tipo ComposerViewElement() 
//elem.IDBusiness="MAEObtenerEstatusCliente" 
//elem.DTOE=dtob; 
//Añadir el elemento a la lista 

         ComposerViewElement c1i = new ComposerViewElement();
         c1i.setIDBusiness("MAEObtenerEstatusCliente");
         c1i.setDTOE(dtob);                
         cvEL.addViewElement(c1i);

//Obtenemos los períodos Desde 
//Crear un elemento de tipo ComposerViewElement() 
//elem.IDBusiness="CRAObtienePeriodos"; 
//elem.DTOE=dtop; 
//Añadir el elemento a la lista 
         ComposerViewElement cvePD = new ComposerViewElement();
         cvePD.setIDBusiness("CRAObtienePeriodos");
         cvePD.setDTOE(dtop);
         cvEL.addViewElement(cvePD);
         
//Obtenemos los períodos Hasta 
//Crear un elemento de tipo ComposerViewElement() 
//elem.IDBusiness="CRAObtienePeriodos"; 
//elem.DTOE=dtop; 
//Añadir el elemento a la lista
         ComposerViewElement cvePH = new ComposerViewElement();
         cvePH.setIDBusiness("CRAObtienePeriodos");
         cvePH.setDTOE(dtop);
         cvEL.addViewElement(cvePH);

//Invocar al subsistema GestorCargaPantalla 

//Asigna los combos: 
//- cbEstatusVentaMae 
//- cbPeriodoDesde 
//- cbPeriodoHasta 
         ConectorComposerView conector = new ConectorComposerView(cvEL, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
         //Cargamos los combos con los resultados
         asignar("COMBO", "cbEstatusVentaMAE", resultados, "MAEObtenerEstatusCliente");
         asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodos");
         asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodos");         


/*========================   ORIGINAL  ======================================
//Si dtoConcurso.indEstatusVenta //Si es true el indicador de que ya se había rellenado la pestaña, se carga la página con esos datos 
//{ 
//Se muestran los datos dtoConcurso.listaEstatusVenta en la pantalla 
//lstEstatusVenta = dtoConcurso.listaEstatusVenta 
//}     
         if (concurso.getIndEstatusVenta() == Boolean.TRUE)
         {
             String sListaEstatusVenta = CargarListaEstatusVenta(concurso.getEstatusVenta());
             traza("ListaEstatusVenta " + sListaEstatusVenta);
             asignarAtributo("VAR","hidLstEstatusVta","valor", sListaEstatusVenta);
         }
========================   ORIGINAL  ======================================*/
         
         //---------------------------- Inc 17662 -------------------------------
         traza("CargarListaEstatusVenta ");
         // Modificado por ssantana, 30/6/2005
         DTOConcurso dtoConcurso = this.getConcurso();
         /*dtoListaEstatusVtaAuxiliar = dtoConcurso.getEstatusVentaConsultoras();//Cleal - INC 06
         //dtoListaEstatusVtaAuxiliar = (DTOListaEstatusVenta)this.getSessionCache().get("dtoLstEVta");
         // Fin Modificacion ssantana, 30/6/2005
         if (dtoListaEstatusVtaAuxiliar !=null){
             traza("CargarListaEstatusVenta dtoLstEVta no es null ");
             String sListaEstatusVenta = CargarListaEstatusVenta(dtoListaEstatusVtaAuxiliar);
             traza("ListaEstatusVenta " + sListaEstatusVenta);
             asignarAtributo("VAR","hidLstEstatusVta","valor", sListaEstatusVenta);
         }*/
         //---------------------------- Inc 17662 -------------------------------

                  //Cleal - 21857
                  if(accion.equals("cargar estatus venta")){
                                    dtoListaEstatusVtaAuxiliar = dtoConcurso.getEstatusVentaConsultoras();
                                    traza("Accion Cargar estatus venta - dtoListaEstatusVtaAuxiliar: "+dtoListaEstatusVtaAuxiliar);
                           if (dtoListaEstatusVtaAuxiliar !=null){
                                    traza("CargarListaEstatusVenta dtoLstEVta no es null ");
                                    String sListaEstatusVenta = CargarListaEstatusVenta(dtoListaEstatusVtaAuxiliar);
                                    traza("ListaEstatusVenta " + sListaEstatusVenta);
                                    asignarAtributo("VAR","hidLstEstatusVta","valor", sListaEstatusVenta);
                           }
                           
                  } else if (accion.equals("cargar estatus venta calificacion")){
                           dtoListaEstatusVtaCalifAuxiliar = dtoConcurso.getEstatusVenta();
                           traza("Accion Cargar estatus venta calificacion - dtoListaEstatusVtaCalifAuxiliar: "+dtoListaEstatusVtaCalifAuxiliar);
                           if (dtoListaEstatusVtaCalifAuxiliar !=null){
                                    traza("CargarListaEstatusVenta dtoLstEVta no es null ");
                                    String sListaEstatusVenta = CargarListaEstatusVenta(dtoListaEstatusVtaCalifAuxiliar);
                                    traza("ListaEstatusVenta " + sListaEstatusVenta);
                                    asignarAtributo("VAR","hidLstEstatusVta","valor", sListaEstatusVenta);
                           }

                  }
//Si opcionMenu == "Consultar Concurso" { 
    //ocultar botón btAñadir de la página 
//} 
         if (this.opcionMenu!= null){
             asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
         }         
//Mostrar la página PGMantenerEstatusVenta pasándole además: 
//- opcionMenu 
//- accion
         asignarAtributo("VAR","accion","valor", this.accion);
         getConfiguracionMenu("LPMantenerParametrosConsultoras","estatusVenta");
    }
    
         public void almacenar() throws Exception {
         Long lOidBaseCalcSel =  null;
         concurso = getConcurso(); 

                  //Se almacenan los estatus de venta
         String sListaEstVta = this.conectorParametroLimpia("hidLstEstatusVta", "", true);
         if (!sListaEstVta.equals("")) {
             //Cleal - INC 06
                           concurso.setEstatusVentaConsultoras(null);
                           concurso.setIndEstatusVentaConsultoras(Boolean.TRUE);
             almacenarEstatusVenta(sListaEstVta);
             concurso.setEstatusVentaConsultoras(dtoListaEstatusVtaAuxiliar);
         }
                  else {
                           concurso.setIndEstatusVentaConsultoras(new Boolean(false));
                  dtoListaEstatusVtaAuxiliar = null;                           
                  this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);
                  }

         String sOidBaseCalculo = conectorParametro("oidBaseCalculo")==null?"":conectorParametro("oidBaseCalculo");
         traza("sOidBaseCalcSel   " + sOidBaseCalculo);             
         if (!sOidBaseCalculo.equals("") ) {
             lOidBaseCalcSel =  new Long(sOidBaseCalculo);
             traza("lOidBaseCalcSel NO ES NULL " + lOidBaseCalcSel);

             if (lOidBaseCalcSel.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS ))  {
                  String sListaMontoVta = conectorParametro("hidLstMVR")==null?"":conectorParametro("hidLstMVR");
                  traza("Lista Monto Venta   " + sListaMontoVta);
                  if (!sListaMontoVta.equals("")){

                                             concurso.setIndMontoVentaRecomendadas(new Boolean(true));
                      concurso.setListaMontoVentaRecomendadas(null);
                      almacenarMontoVentaRecomendadas() ;
                      concurso.setListaMontoVentaRecomendadas(dtoListaMVRAuxiliar);
                  }
                  else{
                                             concurso.setIndMontoVentaRecomendadas(new Boolean(false));
                  }
             }
         }

             String sListaClas = this.conectorParametroLimpia("hidListaClasif", "", true);
             String sLstClasifConsul = this.conectorParametroLimpia("hidLstClasConsul", "", true);
             traza("Lista Clasif   " + sListaClas);             
                           traza("Lista Clasif Consul   " + sLstClasifConsul);

             if (!sListaClas.equals("") || !sLstClasifConsul.equals("")) {
                  concurso.setClasificParticipantes(null);
                  almacenarClasificacionParticipantes(sLstClasifConsul, sListaClas);
                  concurso.setClasificParticipantes(dtoListaClasParticipantesAux);
             }

             if (!sLstClasifConsul.equals("")){
                      concurso.setIndClasificacionParticipantes(Boolean.TRUE);
             }
         
             Boolean bValor = new Boolean(conectorParametro("datosObligatorios"));
             traza("******** datosObligatorios  " + bValor);             
             concurso.setIndObligConsultoras(bValor);

             String sOidCon = conectorParametro("oidParamConsultoras")==null?"":conectorParametro("oidParamConsultoras");
             String sMontoMinPed = conectorParametro("hidMontoMinimoPedido")==null?"":conectorParametro("hidMontoMinimoPedido");
             String sUnidMinPed = conectorParametro("hidUnidadesMinimasPedido")==null?"":conectorParametro("hidUnidadesMinimasPedido");
             String sIndReingPP = conectorParametro("hidReingresosPierdenPuntaje")==null?"":conectorParametro("hidReingresosPierdenPuntaje");
             String sOidTipoVta = conectorParametro("oidTipoVenta")==null?"":conectorParametro("oidTipoVenta");
             
                           traza("******** OidParamConsultoras " + sOidCon );
                           traza("******** hidMontoMinimoPedido " + sMontoMinPed );
                           traza("******** hidUnidadesMinimasPedido " + sUnidMinPed );
                           traza("******** sIndReingPP " + sIndReingPP);
                           traza("******** oidBaseCalculo " + sOidBaseCalculo );
                           traza("******** sOidTipoVta " + sOidTipoVta );
                           traza("******** lOidBaseCalcSel " + lOidBaseCalcSel);
         
                           DTOParametrosConsultoras dtoPC = concurso.getParamConsultoras();

                           if (dtoPC == null)
                                    dtoPC = new DTOParametrosConsultoras();
                           
                           if (!sOidCon.equals(""))
                                    dtoPC.setOidParamConsultoras(new Long(sOidCon));
                           else
                                    dtoPC.setOidParamConsultoras(null);
                           
                           if (!sMontoMinPed.equals(""))
                                    dtoPC.setMontoMinimoPedido(new BigDecimal(sMontoMinPed));
                           else
                                    dtoPC.setMontoMinimoPedido(null);
                           
                           if (!sUnidMinPed.equals(""))
                                    dtoPC.setUnidadesMinimasPedido(new Integer(sUnidMinPed));
                           else
                                    dtoPC.setUnidadesMinimasPedido(null);
                           
                           if (sIndReingPP.equals("S"))
                                    dtoPC.setIndReingresosPierdenPuntaje(Boolean.TRUE);
                           else
                                    dtoPC.setIndReingresosPierdenPuntaje(Boolean.FALSE);
                                             
                           if (!sOidBaseCalculo.equals(""))
                                    dtoPC.setOidBaseCalculo(new Long(sOidBaseCalculo));
                           else
                                    dtoPC.setOidBaseCalculo(null);
         
                           if (!sOidTipoVta.equals(""))    
                                    dtoPC.setOidTipoVenta(new Long(sOidTipoVta));
                           else
                                    dtoPC.setOidTipoVenta(null);
              
                  if (lOidBaseCalcSel.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS) ){
                      String sRecoEfectiva = conectorParametro("hidRecomendacionEfectiva")==null?"":conectorParametro("hidRecomendacionEfectiva");
                           String sEfectividad = conectorParametro("hidEfectividad")==null?"":conectorParametro("hidEfectividad");
                                String seriodoInicialEval = conectorParametro("hidPeriodoInicialEval")==null?"":conectorParametro("hidPeriodoInicialEval");
                                    String sNroPeriodosEvaluar = conectorParametro("hidNroPeriodosEvaluar")==null?"":conectorParametro("hidNroPeriodosEvaluar");
                      String sNroMinimoPedidos = conectorParametro("hidNroMinimoPedidos")==null?"":conectorParametro("hidNroMinimoPedidos");
                           String sNroMinPedidosReco = conectorParametro("hidNroMinPedidosReco")==null?"":conectorParametro("hidNroMinPedidosReco");
             // vbongiov -- 17/03/2008 -- Cambio RI 20080535
             String sIndPremioCampEfect = conectorParametro("hidIndPremioCampEfect")==null?"":conectorParametro("hidIndPremioCampEfect");

			 // vbongiov -- Cambio 20080580 -- 13/8/2008
			 String sIndGenerarPuntajeARecomendadas = conectorParametro("hidIndGenerarPuntajeARecomendadas")==null?"":conectorParametro("hidIndGenerarPuntajeARecomendadas");
			 String sOidConcursoPuntajeRecomendada = conectorParametro("hidOidConcursoPuntajeRecomendada")==null?"":conectorParametro("hidOidConcursoPuntajeRecomendada");

                                    traza("********* sRecoEfectiva " + sRecoEfectiva );
                                    traza("********* sEfectividad " + sEfectividad );
                                    traza("********* seriodoInicialEval " + seriodoInicialEval );
                                    traza("********* sNroPeriodosEvaluar " + sNroPeriodosEvaluar);
                                    traza("********* sNroMinimoPedidos " + sNroMinimoPedidos );
                                    traza("********* sNroMinPedidosReco " + sNroMinPedidosReco );
         traza("********* sIndPremioCampEfect: " + sIndPremioCampEfect );
		 traza("********* sIndGenerarPuntajeARecomendadas: " + sIndGenerarPuntajeARecomendadas );
		 traza("********* sOidConcursoPuntajeRecomendada: " + sOidConcursoPuntajeRecomendada );

                      if (sRecoEfectiva.equals("S"))
                      dtoPC.setIndRecomendacionEfectiva(Boolean.TRUE);
                  else
                      dtoPC.setIndRecomendacionEfectiva(Boolean.FALSE);            
             
                      if (!sEfectividad.equals(""))
                                dtoPC.setOidEfectividad(new Long(sEfectividad));
                                    else 
                                             dtoPC.setOidEfectividad(null);
                           
                                    if (!seriodoInicialEval.equals(""))
                                             dtoPC.setOidPeriodoInicialEvaluacion(new Long(seriodoInicialEval));
                                    else
                                             dtoPC.setOidPeriodoInicialEvaluacion(null);
                  
                                    if (!sNroPeriodosEvaluar.equals(""))
                                dtoPC.setNroPeriodosEvaluar(new Integer(sNroPeriodosEvaluar));
                                    else 
                                             dtoPC.setNroPeriodosEvaluar(null);
                                
                                    if (!sNroMinimoPedidos.equals(""))
                                             dtoPC.setNroMinimoPedidos(new Integer(sNroMinimoPedidos));
                                    else
                                             dtoPC.setNroMinimoPedidos(null);
             
                                    if (!sNroMinPedidosReco.equals(""))
                                dtoPC.setNroMinimoPedidosRecomendada(new Integer(sNroMinPedidosReco));
                                    else
                                             dtoPC.setNroMinimoPedidosRecomendada(null);
           
         // vbongiov -- 17/03/2008 -- Cambio RI 20080535  
         if (sIndPremioCampEfect.equals("S"))
             dtoPC.setIndPremioCampEfect(Boolean.TRUE);
         else
             dtoPC.setIndPremioCampEfect(Boolean.FALSE);    

		 // vbongiov -- Cambio 20080580 -- 13/8/2008
		 if (sIndGenerarPuntajeARecomendadas.equals("S"))
             dtoPC.setIndGenerarPuntajeARecomendadas(Boolean.TRUE);
         else
             dtoPC.setIndGenerarPuntajeARecomendadas(Boolean.FALSE);    

		 if (!sOidConcursoPuntajeRecomendada.equals(""))
			 dtoPC.setOidConcursoPuntajeRecomendada(new Long(sOidConcursoPuntajeRecomendada));
		 else
			 dtoPC.setOidConcursoPuntajeRecomendada(null);

                           }
                           else {
                      dtoPC.setIndRecomendacionEfectiva(new Boolean(ConstantesINC.IND_INACTIVO.toString()));
                           dtoPC.setOidEfectividad(null);
                                dtoPC.setOidPeriodoInicialEvaluacion(null);
                                    dtoPC.setNroPeriodosEvaluar(null);
                      dtoPC.setNroMinimoPedidos(null);
                           dtoPC.setNroMinimoPedidosRecomendada(null);
             // vbongiov -- 17/03/2008 -- Cambio RI 20080535  
             dtoPC.setIndPremioCampEfect(null);   

			 // vbongiov -- Cambio 20080580 -- 13/8/2008
			 dtoPC.setIndGenerarPuntajeARecomendadas(null);   
			 dtoPC.setOidConcursoPuntajeRecomendada(null);   
                           }
         
         concurso.setParamConsultoras(dtoPC);
         concurso.setIndConsultoras(Boolean.TRUE);
         setConcurso(concurso);
    }
    
         public void almacenarEstatusVenta(String sListaEstatusVta) throws Exception {
                  traza("##################### Entrando a almacenarEstatusVenta");
         traza("Contenido Lista Estatus Venta   " + sListaEstatusVta);

         ArrayList arrEV =  null;
         arrEV = aplanarEstatusVenta(sListaEstatusVta);
         dtoListaEstatusVtaAuxiliar.setEstatusVenta(arrEV);
         
         // Modificado por ssantana, 30/6/2005
         traza("IIIIIIIIIIIIIIIIIIIIIIIII");
         DTOConcurso dtoConcurso = this.getConcurso();
//         dtoConcurso.setEstatusVenta(dtoListaEstatusVtaAuxiliar);
                  dtoConcurso.setEstatusVentaConsultoras(dtoListaEstatusVtaAuxiliar);
         this.setConcurso(dtoConcurso);
         //this.getSessionCache().put("dtoLstEVta", dtoListaEstatusVtaAuxiliar);         
         // Fin Modificacion por ssantana, 30/6/2005         
    }
        
    public void cargarPantallaMontoVentaRecomendadas() throws Exception
    {
         pagina("contenido_monto_ventas_recomendadas_mantener");
                  this.getFormatosValidaciones();
//dtoConcurso = getConcurso() //el dtoConcurso es una variable de la LPIncentivos que la hereda esta LPMantenerParametrosConsultoras 
         concurso = getConcurso();
//---------------------------- Inc 17662 ---------------------------------------
//lstmontoVentaRecomendadas = dtoListaMVRAuxiliar;
//---------------------------- Inc 17662 ---------------------------------------
         dtoListaMVRAuxiliar = (DTOListaMontoVentaRecomendadas)this.getSessionCache().get("dtoLstMVR");
         if ( dtoListaMVRAuxiliar!= null){
             ArrayList arrMontoVtaRec =  dtoListaMVRAuxiliar.getMontosVenta();
             this.CargarListaMontoVentaRecomendadas(arrMontoVtaRec);
             /*traza("sMVRPlana " + sMVRPlana);
             asignarAtributo("VAR","hidLstMVR","valor", sMVRPlana);*/
         }

//Si opcionMenu == "Consultar Concurso" { 
    //deshabilitar los campos editables "descripcion" de la lista lstmontoVentaRecomendadas 
//} 

//Mostrar la página PGMantenerMontoVentaRecomendadas pasándole además: 
//- opcionMenu 
//- accion
         if (opcionMenu!= null){
             asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
         }
         asignarAtributo("VAR","accion","valor", this.accion);
         getConfiguracionMenu("LPMantenerParametrosConsultoras","montoVetaRecomendada");
    } 
    
         public void almacenarMontoVentaRecomendadas() throws Exception {
                  traza("#################### Entrando a almacenarMontoVentaRecomendadas");    
//---------------------------- Inc 17662 ---------------------------------------
//dtoListaMVRAuxiliar = null;
//If (lstMontoVentaRecomendadas ¡= null){

//Para cada elemento de la lista lstMontoVentaRecomendadas { //desde i = 0 hasta el final de la lista 

    //Si lstMontoVentaRecomendadas[i].cantidad != "" { 
         //dtoMontoVentaRecomendadasAuxiliar [i].oidMontoVenta = lstMontoVentaRecomendadas[i].oidMontoVenta 
         //dtoMontoVentaRecomendadasAuxiliar [i].oidTipoMontoVenta = lstMontoVentaRecomendadas[i].oidTipoMontoVenta 
         //dtoMontoVentaRecomendadasAuxiliar [i].descTipoMontoVenta = lstMontoVentaRecomendadas[i].descripcion 
         //dtoMontoVentaRecomendadasAuxiliar [i].cantidad = lstMontoVentaRecomendadas[i].cantidad } 
    //}
//}

//     dtoListaMVRAuxiliar =  dtoMontoVentaRecomendadasAuxiliar;
//---------------------------- Inc 17662 ---------------------------------------

         String sListaMontoVtaReco = conectorParametro("hidLstMVR")==null?"":conectorParametro("hidLstMVR");
         traza("Procesando ListaMontoVtaReco   " + sListaMontoVtaReco);
         dtoListaMVRAuxiliar.setMontosVenta(null);    
         if (sListaMontoVtaReco!= null){
             traza("Procesando Monto Venta Recomendada   "  + sListaMontoVtaReco);
                           
             ArrayList lstMVtaREc = aplanarMontoVentaRecomendada(sListaMontoVtaReco);
             dtoListaMVRAuxiliar.setMontosVenta(lstMVtaREc);
         }
                  
                  traza("Poniendo en sesion Monto Venta Recomendada");
         this.getSessionCache().put("dtoLstMVR", dtoListaMVRAuxiliar);
    } 
    
    public void cargarPantallaClasificacionParticipantes() throws Exception
    { 
//---------------------------- Inc 17662 ---------------------------------------
//lstClasificacionParticipantes = dtoListaClasParticipantesAux.lstParticipantes 
//lstClasificacionParticipantesConsultoras  = dtoListaClasParticipantesAux.lstClasificacionParticipantes 
//---------------------------- Inc 17662 ---------------------------------------
         pagina("contenido_participantes_seleccionar");
         this.asignarAtributoPagina("cod", "0491");
         dtoListaClasParticipantesAux = (DTOClasificacionParticipantes)this.getSessionCache().get("dtoLstClasPar");
         if (dtoListaClasParticipantesAux != null ) {
             if (dtoListaClasParticipantesAux.getLstClasificacionParticipantes()!= null) {
                  ArrayList arrClasPar;
                  arrClasPar = dtoListaClasParticipantesAux.getLstClasificacionParticipantes();
                  String sLstClasPlana = cargarClasificacionParticipantes(arrClasPar);
                  traza("sLstClasPlana " + sLstClasPlana);
                  asignarAtributo("VAR","lstClasificacionParticipantesConsultoras","valor", sLstClasPlana);
             }
    
             if (dtoListaClasParticipantesAux.getLstParticipantes()!= null){
                  ArrayList arrPartic = dtoListaClasParticipantesAux.getLstParticipantes();
                  String sLstPlana = cargarParticipantes(arrPartic);
                  traza("sLstPlana " + sLstPlana);
                  asignarAtributo("VAR","lstClasificacionParticipantes","valor", sLstPlana);
             }
         }

//Si opcionMenu == "Consultar Concurso" { 
    //ocultar lista lstParticipantes 
    //ocultar botón btExcluir 
    //ocultar botón btExcluirTodos 
    //ocultar botón btAñadir 
    //ocultar botón btAñadirTodos 
//} 
         
//Mostrar la página PGClasificacionParticipantes pasándole además: 
//- opcionMenu 
//- accion 
         if (opcionMenu!= null){
             asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
         }
         asignarAtributo("VAR","hConcuConsultora","valor", "S");
                  traza("aca");
         asignarAtributo("VAR","accion","valor", this.accion);
         getConfiguracionMenu("LPMantenerParametrosConsultoras","clasificacionParticipante");

    } 
    
    public void almacenarClasificacionParticipantes(String sLstClasifConsul, String sListaClasif) 
                  throws Exception  {
         traza("#################### almacenarClasificacionParticipantes");

         dtoListaClasParticipantesAux.setLstClasificacionParticipantes(null);
         dtoListaClasParticipantesAux.setLstParticipantes(null);
                  
         if (sLstClasifConsul!= null){
             ArrayList lstClasPart = new ArrayList();
             traza("Procesando Participantes Consultoras   "  + sLstClasifConsul);
             lstClasPart = aplanarClasificacionParticipantes(sLstClasifConsul);
             dtoListaClasParticipantesAux.setLstClasificacionParticipantes(lstClasPart);
         }

         
         if (sListaClasif != null){
             ArrayList lstClasif = new ArrayList();
             traza("Procesando Clasificacion Participantes   " + sListaClasif);
             lstClasif = aplanarParticipantes(sListaClasif);
             dtoListaClasParticipantesAux.setLstParticipantes(lstClasif);
         }

         
         this.getSessionCache().put("dtoLstClasPar", dtoListaClasParticipantesAux);
    }
    
    private void cargaConstantesEnPantalla() throws Exception
    {
         asignarAtributo("VAR","oidBC_Recomendada","valor", 
                      ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.toString());
         asignarAtributo("VAR","oidBC_Calculo_Monto","valor", 
                      ConstantesINC.OID_BASE_CALCULO_MONTO.toString());
         asignarAtributo("VAR","oidBC_Tipo_Vta_Catalogo","valor", 
                      ConstantesINC.OID_TIPOVTA_VTA_CATALOGO.toString());
         asignarAtributo("VAR","oidBC_Monto","valor", 
                      ConstantesINC.OID_BASE_CALCULO_MONTO.toString());

         String sConstantes = ConstantesINC.PESTANYA_PARAMETROS_GENERALES.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_PROGRAMA_NUEVAS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_AMBITO_GEOGRAFICO.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_OBTENCION_PUNTOS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_PRODUCTOS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_PREMIOS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_REQUISITOS_PREMIACION.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_DESPACHO_PREMIOS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_CALIFICACION.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_GERENTES.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_CONSULTORAS.toString() + "|";
         sConstantes = sConstantes + ConstantesINC.PESTANYA_MULTINIVEL.toString();
    
         asignarAtributo("VAR","hidConstantesPestINC","valor", sConstantes);
    }  
    
    /*==========================================================================
     *  FUNCIONES DE TRATAMIENTO DE LAS LISTAS QUE SE EXHIBEN EN LAS MAQUETAS *
     ==========================================================================*/
     
    /**    
        *@Author: cargain 
        *@Fecha: 01/05/2005
        *@paquete: INC2
        *@return: 
        *@param: 
        *@Observaciones: Da formato a un String de estatus Vta para enviar a la pantalla 
      */ 
    private String CargarListaEstatusVenta(DTOListaEstatusVenta dtoEstatusVenta)  
                                                                throws Exception {
         traza("Entrando a CargarListaEstatusVenta");    
         ArrayList arEsVta = dtoEstatusVenta.getEstatusVenta();
         int iIndice = 0;
         Iterator itEsVta = arEsVta.iterator();
         String sLstPlana = new String();
         while (itEsVta.hasNext()){
             DTOEstatusVenta dtoE =  (DTOEstatusVenta)itEsVta.next();
             
             //Dado que en la lista no pueden existir oids repetidos en la primer columna
             //envío un oid trucho, para permitirme poder tener OIDEstatus repetidos.
             //Esto lo hago porque no se si puedo tener OIDEstatus repetidos o no.
             String sEstVta = iIndice + "|";
             sEstVta = sEstVta +dtoE.getOidEstatus() + "|";
             sEstVta = sEstVta + dtoE.getOidEstatusVentaMae() + "|";
             sEstVta = sEstVta + dtoE.getOidPeriodoDesde() + "|";
             sEstVta = sEstVta + dtoE.getOidPeriodoHasta() + "|";
             
             sEstVta = sEstVta + dtoE.getDesEstatus() + "|";
             sEstVta = sEstVta + dtoE.getDesPeriodoDesde() + "|";
             sEstVta = sEstVta + dtoE.getDesPeriodoHasta() + "$";

             traza("OID Status        "  + dtoE.getOidEstatus() );
             traza("OID Vta MAE      "  + dtoE.getOidEstatusVentaMae());
             traza("OID PeriodoD     "  + dtoE.getOidPeriodoDesde() );
             traza("OID PeriodoH     "  + dtoE.getOidPeriodoHasta() );

traza("Desc Status      "  + dtoE.getDesEstatus() );
traza("Desc PeriodoD    "  + dtoE.getDesPeriodoDesde());
traza("Desc PeriodoH    "  + dtoE.getDesPeriodoHasta());
             
             sLstPlana = sLstPlana+ sEstVta;
             iIndice ++;
         }
traza("Mandando a sesion   " + sLstPlana);         
         return sLstPlana;
    }

     
    ArrayList aplanarEstatusVenta(String listado) throws Exception {
         traza("Entre a aplanarEstatusVenta");
         traza(listado);

         StringTokenizer stRows = new StringTokenizer(listado, "$");
         int rowCount = stRows.countTokens();
         ArrayList lstClasPart = new ArrayList ();
         
         for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
             DTOEstatusVenta dtoE=  new DTOEstatusVenta();
             dtoE.setOidIdioma(lIdioma);
             dtoE.setOidPais(lPais);
             StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
             for(int conta =  0 ;stColss.hasMoreTokens(); conta++){                                                                      
                  StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");
                for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                      String desc = stCols.nextToken().toString();
                      String valor = stCols.nextToken().toString();
                      traza("--> " + desc + " " + valor);
                      if ( desc.equals("oEv") ){
                           if (valor!= null && !valor.equals("null"))
                                dtoE.setOidEstatus(new Long(valor));
                      }
                      if ( desc.equals("oEM") ){
                           if (valor!= null && !valor.equals(""))
                                dtoE.setOidEstatusVentaMae(new Long(valor));
                      }
                      if ( desc.equals("oPd") ){
                           if (valor!= null && !valor.equals(""))
                                dtoE.setOidPeriodoDesde(new Long(valor));
                      }
                      if ( desc.equals("oPh") ){
                           if (valor!= null )
                                dtoE.setOidPeriodoHasta(new Long(valor));
                      }
                      if ( desc.equals("dEv") ){
                           if (valor!= null)
                                dtoE.setDesEstatus(valor);
                      }
                      if ( desc.equals("dPd") ){
                           if (valor!= null)
                                dtoE.setDesPeriodoDesde(valor);
                      }
                      if ( desc.equals("dPh") ){
                           if (valor!= null)
                                dtoE.setDesPeriodoHasta(valor);
                      }  
                  }
             }
             traza("DTO CLAS     " + dtoE);
             lstClasPart.add(dtoE);
         }
         return  lstClasPart;
    }
     
     public String cargarClasificacionParticipantes(ArrayList arrClasPar) 
                                                                throws Exception{
         traza("Cargando lstClasificacionParticipantesConsultoras" );
         //ArrayList arrClasPar;
         //arrClasPar = concurso.getClasificParticipantes().getLstClasificacionParticipantes();
         Iterator ClasificPart = arrClasPar.iterator();
         String sLstClasPlana = new String();
         int iIndice = 0;
         while (ClasificPart.hasNext()){
             DTOClasificacion dtoP =  (DTOClasificacion)ClasificPart.next();
             traza("OID Clasif. Participante " + dtoP.getOidClasificacionParticipante());
             traza("OID Participante          " + dtoP.getOidParticipante());
             traza("Descripcion                " + dtoP.getDescripcion());
                           
             String sClasificacion = iIndice + "|";
             sClasificacion = sClasificacion + dtoP.getOidClasificacionParticipante()  + "|";
             sClasificacion = sClasificacion + dtoP.getOidParticipante()  + "|";
             sClasificacion = sClasificacion + dtoP.getDescripcion() + "$";
             
             sLstClasPlana = sLstClasPlana + sClasificacion;
             iIndice++;
         }
         traza("Mandando a Sesion sLstClasPlana  " +  sLstClasPlana);
         return sLstClasPlana;
     }

    ArrayList aplanarClasificacionParticipantes(String listado) throws Exception{
         traza("************** Entre a aplanarClasificacionParticipantes");
         traza(listado);

         StringTokenizer stRows = new StringTokenizer(listado, "$");
         int rowCount = stRows.countTokens();
         ArrayList lstClasPart = new ArrayList();
         
         for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
             DTOClasificacion dtoC = new DTOClasificacion();
             dtoC.setOidIdioma(lIdioma);
             dtoC.setOidPais(lPais);
             StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
             for(int conta =  0 ;stColss.hasMoreTokens(); conta++){                                                                      
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");                                 

                for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                      String desc = stCols.nextToken().toString();
                      String valor = stCols.nextToken().toString();
                      
                      traza("desc  " + desc + "  valor   " + valor);                  
                      
                      if(desc.equals("oPc")){
                           if (valor!= null && !valor.equals("null")){
                                dtoC.setOidClasificacionParticipante(new Long(valor));
                           }
                      }
                      
                      if(desc.equals("oPar")){
                           if (valor != null)
                                dtoC.setOidParticipante(new Long(valor));
                      }
                      
                      if(desc.equals("desc"))
                           dtoC.setDescripcion(valor);
                  }
             }
             lstClasPart.add(dtoC);
         }
         return  lstClasPart;
    }
     
    public String cargarParticipantes(ArrayList arrParticipantes) 
                                                                    throws Exception {
         traza("Entrando a cargarParticipantes" );
         Iterator ClasificPart = arrParticipantes.iterator();
         String sLstParticipantesPlana = new String();
         int iIndice = 0;
         while (ClasificPart.hasNext()){
             DTOParticipante dtoP =  (DTOParticipante)ClasificPart.next();
             traza("OID           " + dtoP.getOid());
             traza("Descripcion  " + dtoP.getDescripcion());
             
             String sParticipantes = dtoP.getOid()  + "|";
             sParticipantes = sParticipantes + dtoP.getDescripcion() + "$";
             
             sLstParticipantesPlana = sLstParticipantesPlana + sParticipantes;
             iIndice++;
         }
         traza("Mandando a Sesion   " +  sLstParticipantesPlana);
         return sLstParticipantesPlana;
     }
     
     ArrayList aplanarParticipantes(String listado) throws Exception{
         traza("************** Entre a aplanarParticipantes");
         traza(listado);

         StringTokenizer stRows = new StringTokenizer(listado, "$");
         int rowCount = stRows.countTokens();
         ArrayList lstClasPart = new ArrayList ();
         
         for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
             DTOParticipante dto = new DTOParticipante();
             dto.setOidIdioma(lIdioma);
             dto.setOidPais(lPais);
             StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
             for(int conta =  0 ;stColss.hasMoreTokens(); conta++){                                                                      
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");                                 

                for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                  String desc = stCols.nextToken().toString();
                  String valor = stCols.nextToken().toString();
                  
                  traza("desc  " + desc + "  valor   " + valor);                  
                  
                  if(desc.equals("oPar"))
                      dto.setOid(new Long(valor));
                    
                  if(desc.equals("desc"))
                      dto.setDescripcion(valor);
                    
                  }
             }
             lstClasPart.add(dto);
         }
      return  lstClasPart;
     }
     
     public void CargarListaMontoVentaRecomendadas(ArrayList arrMontoVtaRec)
                                                                    throws Exception {
         //ArrayList arrMontoVtaRec;
         //arrMontoVtaRec = concurso.getListaMontoVentaRecomendadas().getMontosVenta();         
         //arrMontoVtaRec = dtoListaMVRAuxiliar.getMontosVenta();


         // Modificado por ssantana, 26/5/2005 - Directamente asigna los valores de la  lista
         // a la pantalla.
         
         Vector vFila = null;
         RecordSet r = new RecordSet();
         Vector vCols = new Vector();

         // Setea los col. identifiers al RecordSet.          
         vCols.add("OID");
         vCols.add("OID_MONTO_VENTA");
         vCols.add("OID_TIPO_MONTO_VENTA");
         vCols.add("DESC_TIPO_MONTO_VENTA");
         vCols.add("CANTIDAD");
         r.setColumnIdentifiers(vCols);
                  
         
         String sOidMontoVenta = null;
         String sOidTipoMontoVenta = null;
         String sCantidad = null;
         String sDescTipoMontoVenta = null;

         Iterator ClasificPart = arrMontoVtaRec.iterator();
         String sMVRPlana = new String();
         int iIndice = 0;
         
         while (ClasificPart.hasNext())
         {
             DTOMontoVentaRecomendadas dtoVMR =  (DTOMontoVentaRecomendadas)ClasificPart.next();
             vFila = new Vector();
             sOidMontoVenta = "";
             sOidTipoMontoVenta = "";
             sCantidad = "";
             sDescTipoMontoVenta = "";
             
             if ( dtoVMR.getOidMontoVenta() != null )
                sOidMontoVenta = dtoVMR.getOidMontoVenta().toString();
                
             if ( dtoVMR.getOidTipoMontoVenta() != null )
                sOidTipoMontoVenta = dtoVMR.getOidTipoMontoVenta().toString();
                
             if ( dtoVMR.getCantidad() != null)
                             sCantidad = UtilidadesBelcorp.formateaNumeroSICC(dtoVMR.getCantidad().toString(), this.FORMATO_DEFAULT, this);                

             if ( dtoVMR.getDescTipoMontoVenta() != null)  
                sDescTipoMontoVenta = dtoVMR.getDescTipoMontoVenta();
             
             vFila.add(new Integer(iIndice));
             vFila.add(sOidMontoVenta);
             vFila.add(sOidTipoMontoVenta);
             vFila.add(sDescTipoMontoVenta);
             vFila.add(sCantidad);
             
             r.addRow(vFila);
             
             iIndice++;
         }
         
         traza("RecordSet a setear en Lista: " + r);
         DruidaConector con = UtilidadesBelcorp.generarConector("ListaMonto", r, r.getColumnIdentifiers());
         
         this.asignar("LISTADOA", "listado1", con, "ListaMonto");
         
         traza("lista asignada!!");
         return;
    }
     
     ArrayList aplanarMontoVentaRecomendada(String listado) throws Exception{
         traza("************** Entre a aplanarMontoVentaRecomendada");

         ArrayList lstClasPart = new ArrayList();
         traza("************* listado " + listado);
         
         // Modificado por ssantana, 26/5/2005
         
         // Primero quita los "[" - "]" del principio y final.
         listado = listado.substring(1, listado.length()-1); // "["
         listado = listado.substring(0, listado.length());   // "]"
         traza("************* listado sin []: " + listado);
         
         DTOMontoVentaRecomendadas dtoMVR = null;
         StringTokenizer sTok = new StringTokenizer(listado, "|");
         StringTokenizer sTokCampos = null;
         String sFila = null;
         
         String sOid = null;
         String sOidMontoVenta = null;
         String sOidTipoMonto = null;
         String sDescTipoMontoVenta = null;
         String sCantidad = null;
         
         while ( sTok.hasMoreTokens() ) {
         
           sFila = sTok.nextToken();
           sTokCampos = new StringTokenizer(sFila, "&");
           
           sOid = sTokCampos.nextToken();
           sOidMontoVenta = sTokCampos.nextToken();
           sOidTipoMonto = sTokCampos.nextToken();
           sDescTipoMontoVenta = sTokCampos.nextToken();
           sCantidad = sTokCampos.nextToken();
                    traza("******* sCantidad " + sCantidad);

                    String tempCantidad = desFormatearNumero(sCantidad, this.FORMATO_DEFAULT);
                    traza("******* tempCantidad " + tempCantidad);

           dtoMVR = new DTOMontoVentaRecomendadas();           
           if ( !sOidMontoVenta.equals(" ") ) {
             dtoMVR.setOidMontoVenta( new Long(sOidMontoVenta) );
           }
             
           if ( !sOidTipoMonto.equals(" ") ) {
             dtoMVR.setOidTipoMontoVenta(new Long(sOidTipoMonto));
           }
           
           if ( !sDescTipoMontoVenta.equals(" ") ) {
             dtoMVR.setDescTipoMontoVenta( sDescTipoMontoVenta );
           }
             
           if ( !sCantidad.equals(" ") ) {
             dtoMVR.setCantidad(new BigDecimal(tempCantidad));
           }
             
           traza("DTO a Agregar: " + dtoMVR);
             
           lstClasPart.add(dtoMVR);
         }        
         
         return lstClasPart;
    }

          private String obtenerValor(Boolean bool) throws Exception{ 
                  traza("********** obtenerValor");
                  traza("********** bool " + bool);

                  if(bool==null || bool.booleanValue() == false) return new String("N");
                  else return new String("S");
         }
    
    public String nro2check(Long lValor)
    {
         if (lValor.equals("1"))
             return "S";
         else
             return "N";
    }
    
    public String bool2check(Boolean lValor)
    {
         if (lValor.booleanValue() == true)
             return "S";
         else
             return "N";
    }
}