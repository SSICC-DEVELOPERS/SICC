/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la dalistribución de este código sin permiso expreso.
 * 
 * 
 * @Autor: Paola Cabrera
 */
 
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;

import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOParametrosGerentes;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import java.math.BigDecimal;

import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOClasificacion;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOVariablesVenta;

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


public class LPMantenerParametrosGerentesRanking extends LPIncentivosRanking{ 

    private Long idioma 	= null;
    private Long pais 		= null;
    
    private DTOListaMontoVentaRecomendadas dtoListaMVRAuxiliar = new DTOListaMontoVentaRecomendadas();
    private DTOClasificacionParticipantes dtoListaClasParticipantesAux = new DTOClasificacionParticipantes();
    private DTOVariablesVenta dtoVVtaAux = new DTOVariablesVenta();
    
    
    
    public LPMantenerParametrosGerentesRanking() {
    }

    public void inicio() throws Exception {
        pagina("contenido_parametros_gerente_mantener_ranking");        
    }

    public void ejecucion() throws Exception {
      setTrazaFichero();
      try{
      
            obtenerFlagsPestanyas();
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
            
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
                       
            
            Long marca = UtilidadesSession.getMarcaPorDefecto(this);
            Long canal = UtilidadesSession.getCanalPorDefecto(this);
            
            
            traza(">>>> Acción................" + accion);            
            traza(">>>> opcionMenu............" + opcionMenu);
            traza(">>>> Idioma................" + idioma);
            traza(">>>> Pais.................." + pais);
            traza(">>>> Marca................." + marca);            
            traza(">>>> Canal................." + canal);
                      
            
           // obtenerFlagsPestanyas();                 
            
           //--Con este metodo cargo las constantes en la maqueta         
            cargaConstantesEnPantalla();
            
            if (accion.equals("")){
                 getConfiguracionMenu("LPMantenerParametrosGerentesRanking", "");
                 this.cargarPantalla(); 
            }else if (accion.equals("cargar clasificacion participantes ranking")){
                getConfiguracionMenu("LPMantenerParametrosGerentesRanking", "cargar clasificacion participantes ranking");  
                cargarPantallaClasificacionParticipantesRanking();
            } else if (accion.equals("Inicializar Variable Venta")){    
                this.inicializarVariableVenta();
            }else if (accion.equals("almacenar Clasificacion Participantes Ranking")){
                pagina("salidaGenerica");
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");

                almacenarClasificacionParticipantesRanking();
                traza("Almacenada Lista Clasificacion Participantes  ");
                asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                //asignarAtributo("VAR","ejecutarError","valor","accionError()");

            }else if (accion.equals("almacenar")){
                  traza("***esta en almacenar ****");
                 this.almacenar(); 
                  super.redirigir();
            }else if(accion.equals("redirigir")){
             traza("***esta en redirigir ****");
                 this.redirigir();
            }else if(accion.equals("guardar")){
                 almacenar();
                 guardar();                
            }
              
   
            if (opcionMenu.equals("Crear Concurso Ranking")){
				asignarAtributoPagina("cod", "0508");  
            }else if (opcionMenu.equals("Consultar Concurso Ranking")){
		//	 getConfiguracionMenu("LPMantenerParametrosGerentesRanking","Consultar Concurso Ranking");
             asignarAtributoPagina("cod", "0525");
            }else if (opcionMenu.equals("Modificar Concurso Ranking")){
		//	 getConfiguracionMenu("LPMantenerParametrosGerentesRanking","Modificar Concurso Ranking");
              asignarAtributoPagina("cod", "0524");
            }
            
        }catch(Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
        }
  }//--fin de ejecucion


  private void logStackTrace(Throwable e) throws Exception {
       traza("Se produjo la excepcion, en LPMantenerParametrosGerentesRanking: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       
       if (e instanceof MareException){
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
  }
    

 public void cargarPantalla() throws Exception{
        traza("Entrando a cargarPantalla...");

        cargarFlagsPestanyas();
        DTOConcurso dtoConcurso = getConcurso();
       
      
        DTOBelcorp dtob = new DTOBelcorp();
        dtob.setOidIdioma(idioma);
        dtob.setOidPais(pais);


        traza("Marca:   " + dtoConcurso.getParamGenerales().getOidMarca());
        traza("Canal:   " + dtoConcurso.getParamGenerales().getOidCanal());
        DTOPeriodo dtop = new DTOPeriodo();
        dtop.setOidPais(pais);
        dtop.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
        dtop.setCanal(dtoConcurso.getParamGenerales().getOidCanal());

        ComposerViewElementList cvEL = new ComposerViewElementList();

        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("INCObtenerFormaCalculo");
        ci1.setDTOE(dtob);
        cvEL.addViewElement(ci1);

        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness("INCConsultaBasesCalculo");
        ci2.setDTOE(dtob);
        cvEL.addViewElement(ci2);

        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("INCConsultaTiposVenta");
        ci3.setDTOE(dtob);
        cvEL.addViewElement(ci3);

        ConectorComposerView conector = new ConectorComposerView(cvEL,this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        asignar("COMBO", "cbFormaCalculo", resultados, "INCObtenerFormaCalculo");
        asignar("COMBO", "cbBaseCalculo", resultados, "INCConsultaBasesCalculo");
        asignar("COMBO", "cbTipoVenta", resultados, "INCConsultaTiposVenta");
     
     
        //--Deshabilitar los combos
        // cbBaseCalculo 
        // cbTipoVenta 

       asignarAtributo("VAR", "cbBaseTipoVenta", "valor", "S");
        
       traza("Indicador de haber pasado por pestanya Gerente " + dtoConcurso.getIndGerentes().toString());
       
       //--Se lleno la pestañia, caso de modificar ----------------------------
       if (dtoConcurso.getIndGerentes().booleanValue()){
       
          traza("IndGerentes = TRUE");
          asignarAtributo("VAR","hidIndGerentes","valor", "1");
          
          DTOParametrosGerentes dtoPG = dtoConcurso.getParamGerentes();        
          
          if (dtoPG != null){
			   traza("1");          
              Long lOidParamGerentes = dtoPG.getOidParamGerentes();
              

              if (lOidParamGerentes != null){
  			     traza("2");
                 asignarAtributo("VAR","oidParamGerentes","valor",lOidParamGerentes.toString());
                 traza("oidParamGerentes   " + lOidParamGerentes.toString());
              }
                  
              //--para seleccionar el valor en el combo
			  if(dtoPG.getOidFormaCalculo()!=null) {
				  traza("3");
		          asignarAtributo("VAR","oidFormaCalculo","valor",dtoPG.getOidFormaCalculo().toString());
			      asignarAtributo("VAR","hidOidFormaCalculo","valor",dtoPG.getOidFormaCalculo().toString());
			  }
            
              if (dtoPG.getOidFormaCalculo()!= null && dtoPG.getOidFormaCalculo().equals(ConstantesINC.OID_FORMA_CALC_BASE_CALC)){ // (A)                 
                  traza("OID_FORMA_CALC_BASE_CALC--> (A) " );                  
                  //habilitar cbBaseCalculo 
                  asignarAtributo("VAR", "cbBaseC", "valor", "N");
                  
                  Long lPlantillaOidBaseCalculo =  dtoPG.getOidBaseCalculo();
                  traza("Plantilla Oid BaseCalculo  "  + lPlantillaOidBaseCalculo);
                 
                  if (lPlantillaOidBaseCalculo!= null){ //(B)
                  //--para seleccionar el valor en el combo
					  traza("4");
                      asignarAtributo("VAR","oidPlantillaBaseCalculo","valor",lPlantillaOidBaseCalculo.toString());
                      Long lOidTipoVta = dtoPG.getOidTipoVenta();
                      
                      traza("lOidTipoVta + " + lOidTipoVta);
                      
                      if (lOidTipoVta != null){
						  traza("5");
                          asignarAtributo("VAR","oidTipoVta","valor", lOidTipoVta.toString());
                           
                          if (lPlantillaOidBaseCalculo.equals(ConstantesINC.OID_BASE_CALCULO_MONTO)){ 
							 traza("6");
                             asignarAtributo("VAR", "cbTipo", "valor", "N");
                          }
                      }                            
                     
                  }//(B)
                
                  }//(A)
          } //--dtoPG == null

       } //-- dtoConcurso.getIndGerentes()!= Boolean.TRUE
       traza("7");
        if (dtoConcurso.getClasificParticipantes()!= null) {
             traza("Procesa recarga Clasific. Participantes");
             dtoListaClasParticipantesAux = dtoConcurso.getClasificParticipantes();
             this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
         }
		traza("8");
       if (!this.opcionMenu.equals("") && this.opcionMenu!= null){
             asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
       }  
       asignarAtributo("VAR","accion","valor", this.accion);
     
 } //-fin metodo cargaPantalla()

    
 public void cargarPantallaClasificacionParticipantesRanking() throws Exception{         
    traza("Entrando a cargarPantallaClasificacionParticipantes");     

    pagina("contenido_participantes_seleccionar_ranking");  
    getConfiguracionMenu("LPMantenerParametrosGerentesRanking", "cargar clasificacion participantes ranking");
        
    dtoListaClasParticipantesAux = (DTOClasificacionParticipantes)this.getSessionCache().get("dtoLstClasParG");
     
    traza("dtoListaClasParticipantesAux --" + dtoListaClasParticipantesAux);
   
    if (dtoListaClasParticipantesAux != null ){
        if (dtoListaClasParticipantesAux.getLstClasificacionParticipantes()!= null){
            ArrayList arrClasPar;
            arrClasPar = dtoListaClasParticipantesAux.getLstClasificacionParticipantes();
            String sLstClasPlana = cargarClasificacionParticipantesRanking(arrClasPar);
            traza("sLstClasPlana " + sLstClasPlana);
            asignarAtributo("VAR","lstClasificacionParticipantesConsultoras","valor", sLstClasPlana);
        }
    
        if (dtoListaClasParticipantesAux.getLstParticipantes()!= null){
            ArrayList arrPartic = dtoListaClasParticipantesAux.getLstParticipantes();
            String sLstPlana = cargarParticipantesRanking(arrPartic);
            traza("sLstPlana " + sLstPlana);
            asignarAtributo("VAR","lstClasificacionParticipantes","valor", sLstPlana);
        }
   }
        
   if (opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
   }
   
   asignarAtributo("VAR","accion","valor", this.accion);
   getConfiguracionMenu("LPMantenerParametrosGerentesRanking","cargar clasificacion participantes ranking");
        
}
 
 
 public void almacenarClasificacionParticipantesRanking() throws Exception{
     dtoListaClasParticipantesAux.setLstClasificacionParticipantes(null);
     dtoListaClasParticipantesAux.setLstParticipantes(null);
    
     String sLstClasifConsul = conectorParametro("hidLstClasConsul")==null?"":conectorParametro("hidLstClasConsul");       
     if (sLstClasifConsul!= null){
         ArrayList lstClasPart = new ArrayList();
         traza("Procesando Participantes Consultoras   "  + sLstClasifConsul);
         lstClasPart = aplanarClasificacionParticipantesRanking(sLstClasifConsul);
         dtoListaClasParticipantesAux.setLstClasificacionParticipantes(lstClasPart);
     }               
  
     String sListaClasif = conectorParametro("hidListaClasif")==null?"":conectorParametro("hidListaClasif");
     if (sListaClasif != null){
         ArrayList lstClasif = new ArrayList();
         traza("Procesando Clasificacion Participantes   " + sListaClasif);
         lstClasif = aplanarParticipantes(sListaClasif);
            
         dtoListaClasParticipantesAux.setLstParticipantes(lstClasif);
     }
     
    traza("dtoListaClasParticipantesAux 1: " + dtoListaClasParticipantesAux);       
    this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
 }
    
    
  public void almacenar() throws Exception{   
   
      traza("= Entrando a almacenar...");

      String sOidVariablesVenta = conectorParametro("oidVariablesVenta")==null?"":conectorParametro("oidVariablesVenta");
      String sVariablesVta = conectorParametro("hidVariablesVenta")==null?"":conectorParametro("hidVariablesVenta");
      traza("sOidVariablesVenta   " + sOidVariablesVenta);
      traza("Contenido Variables de Venta   " + sVariablesVta);
        
      DTOConcurso  concurso = getConcurso();
        
      traza("Almancenando Variables de Venta");
      String sOidFormaCalculo = this.conectorParametroLimpia("cbFormaCalculo", "", true);
      traza("sOidFormaCalculo " + sOidFormaCalculo);
      
      String sOidBaseCalculo = this.conectorParametroLimpia("cbBaseCalculo", "", true);
      traza("sOidBaseCalculo " + sOidBaseCalculo);
      
      String sOidTipoVenta = this.conectorParametroLimpia("cbTipoVenta", "", true);
      traza("sOidTipoVenta " + sOidTipoVenta);
       
      //--Variables de la pag
      String datosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true); 
      traza("datosObligatorios + " + datosObligatorios);
      
      String oidParamGere = this.conectorParametroLimpia("oidParamGerentes", "", true);    
      traza("oidParamGere " + oidParamGere);
      
      concurso.setIndObligGerentes(datosObligatorios.equals("true")?Boolean.TRUE:Boolean.FALSE);
      
      // Verifica si hay que registros en la base de datos
      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      
      if(opcionMenu.equals("Modificar Concurso Ranking") && !concurso.getIndObligGerentes().booleanValue()) {
          concurso.setIndBorradoGerentes(Boolean.TRUE);
      }
        
      String sListaClas = conectorParametro("hidListaClasif")==null?"":conectorParametro("hidListaClasif");            
      String sLstClasifConsul = conectorParametro("hidLstClasConsul")==null?"":conectorParametro("hidLstClasConsul");
      traza("Lista Clasif   " + sListaClas);
      traza("Lista Clasif Consul   " + sLstClasifConsul);

	  if (sListaClas.length()>0 || sLstClasifConsul.length()>0){
		  concurso.setClasificParticipantes(null);
          almacenarClasificacionParticipantesRanking();
          traza("dtoListaClasParticipantesAux 2: " + dtoListaClasParticipantesAux);
          concurso.setClasificParticipantes(dtoListaClasParticipantesAux);
	  }
        
      if (sLstClasifConsul.length()>0){
          concurso.setIndClasificacionParticipantes(Boolean.TRUE);          
      }      
           
      DTOParametrosGerentes dtoPG = concurso.getParamGerentes();
      if (dtoPG == null)
           dtoPG = new DTOParametrosGerentes();    
           
      
      Boolean bValor = new Boolean(conectorParametro("datosObligatorios"));
      traza("datosObligatorios  " + bValor);
      if (bValor != null)
            concurso.setIndObligGerentes(bValor);
       
      String soidParamGerentes = conectorParametro("oidParamGerentes")==null?"":conectorParametro("oidParamGerentes");
      traza("sOidParamGerentes: " + soidParamGerentes);
      
      if (!soidParamGerentes.equals(""))
          dtoPG.setOidParamGerentes(new Long(soidParamGerentes));
        
      if ( !sOidFormaCalculo.equals("") )
          dtoPG.setOidFormaCalculo(new Long(sOidFormaCalculo));
      
      asignarAtributo("VAR","oidFormaCalculo","valor",sOidFormaCalculo);
      
       
      if (sOidFormaCalculo.equals(ConstantesINC.OID_FORMA_CALC_BASE_CALC.toString())) {
          if ( !sOidBaseCalculo.equals("") ) {
              dtoPG.setOidBaseCalculo(new Long(sOidBaseCalculo));
              
              if (sOidBaseCalculo.equals(ConstantesINC.OID_BASE_CALCULO_MONTO.toString())) {
                  traza("sOidTipoVenta: " + sOidTipoVenta);
                  if ( !sOidTipoVenta.equals("") )
                      dtoPG.setOidTipoVenta(new Long(sOidTipoVenta));
                  } else {
                      dtoPG.setOidTipoVenta(null);
                  }
        }
      }else {
            dtoPG.setIndRecomendacionEfectiva(new Boolean(ConstantesINC.IND_INACTIVO.toString()));
            dtoPG.setNumeroPeriodosEvaluar(null);
            dtoPG.setNumeroMinimoPedidos(null);
            dtoPG.setNumeroMinimoPedidosRecomendada(null);
            dtoPG.setOidPeriodoInicialEvaluacion(null);
            dtoPG.setOidTipoVenta(null);
            dtoPG.setOidBaseCalculo(null);
        }
        
      concurso.setParamGerentes(dtoPG);
      concurso.setIndGerentes(Boolean.TRUE);
      setConcurso(concurso);
      traza("Termino Almacenar");            
      traza("== concurso ==" + concurso);            
      asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
      asignarAtributo("VAR","ejecutarError","valor","accionError()");

 }    

 private void cargaConstantesEnPantalla() throws Exception{ 
 
       
     asignarAtributo("VAR","oidBC_Calculo_Monto","valor", ConstantesINC.OID_BASE_CALCULO_MONTO.toString());
     asignarAtributo("VAR","oid_Forma_Calc_Base_Calc","valor", ConstantesINC.OID_FORMA_CALC_BASE_CALC.toString());
     asignarAtributo("VAR","oid_Forma_Calc_Vbles_Vta","valor", ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.toString()); 
         
         
     String sConstantes = ConstantesINC.PESTANYA_PARAMETROS_GENERALES.toString() + "|";   
     sConstantes = sConstantes + ConstantesINC.PESTANYA_AMBITO_GEOGRAFICO.toString() + "|";
     sConstantes = sConstantes + ConstantesINC.PESTANYA_PRODUCTOS.toString() + "|";
     sConstantes = sConstantes + ConstantesINC.PESTANYA_PREMIOS.toString() + "|"; 
     sConstantes = sConstantes + ConstantesINC.PESTANYA_GERENTES.toString() + "|";
      
     asignarAtributo("VAR","hidConstantesPestINC","valor", sConstantes);
} 
    
   
 public String cargarClasificacionParticipantesRanking(ArrayList arrClasPar) throws Exception{
     
     traza("Cargando lstClasificacionParticipantesConsultoras" );       
     Iterator ClasificPart = arrClasPar.iterator();
     
     traza("ClasificPart " + ClasificPart);
     
     String sLstClasPlana = new String();
     int iIndice = 0;
        
     while (ClasificPart.hasNext()){
        DTOClasificacion dtoP =  (DTOClasificacion)ClasificPart.next();
        traza("OID Clasif. Participante " + dtoP.getOidClasificacionParticipante());
        traza("OID Participante         " + dtoP.getOidParticipante());
        traza("Descripcion              " + dtoP.getDescripcion());
                        
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
     


 ArrayList aplanarClasificacionParticipantesRanking(String listado) throws Exception{
      
     traza("* Entre a aplanarClasificacionParticipantesRanking " + listado);
     
     StringTokenizer stRows = new StringTokenizer(listado, "$");
     int rowCount = stRows.countTokens();
     ArrayList lstClasPart = new ArrayList ();
       
     for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
      
         DTOClasificacion dtoC = new DTOClasificacion();
         dtoC.setOidIdioma(idioma);
         dtoC.setOidPais(pais);
      
         StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
         for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

             for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                 String desc = stCols.nextToken().toString();
                 String valor = stCols.nextToken().toString();
                   
                 traza("desc  " + desc + "  valor   " + valor);                
                   
                 if(desc.equals("oPc")){
                     if (valor!= null && !valor.equals("null")){
                         dtoC.setOidClasificacionParticipante(Long.valueOf(valor));
                     }
                 }
                   
                 if(desc.equals("oPar")){
                     if (valor != null){
                         dtoC.setOidParticipante(Long.valueOf(valor));
                     }    
                 }
                    
                 if(desc.equals("desc")){
                     dtoC.setDescripcion(valor);
                 }      
             }
         }
         
         lstClasPart.add(dtoC);
    }
    return  lstClasPart;

 }
     
  
 public String cargarParticipantesRanking(ArrayList arrParticipantes) throws Exception{
    
     traza("Entrando a cargarParticipantesRanking" );
     Iterator ClasificPart = arrParticipantes.iterator();
     String sLstParticipantesPlana = new String();
    
     int iIndice = 0;
     while (ClasificPart.hasNext()){
         DTOParticipante dtoP =  (DTOParticipante)ClasificPart.next();
         traza("OID          " + dtoP.getOid());
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
       
     traza("**** Entre a aplanarParticipantes " + listado);
    
     StringTokenizer stRows = new StringTokenizer(listado, "$");
     int rowCount = stRows.countTokens();
     ArrayList lstClasPart = new ArrayList ();
        
     for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
         DTOParticipante dto = new DTOParticipante();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
         
         for(int conta =  0 ;stColss.hasMoreTokens(); conta++) {								
             StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				

             for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                 String desc = stCols.nextToken().toString();
                 String valor = stCols.nextToken().toString();
                
                 traza("desc  " + desc + "  valor   " + valor);                
                
                 if(desc.equals("oPar")){
                     dto.setOid(Long.valueOf(valor));
                  }  
                  
                 if(desc.equals("desc")){
                    dto.setDescripcion(valor);
                 }  
                  
             }
          }
          lstClasPart.add(dto);
     }
        
      traza("sale de aplanarParticipantes");
      return  lstClasPart;
  }
  
  
  /**
	 * Sistema:     Belcorp
	 * Fecha:       1/07/2005
	 * @autor       Viviana Bongiovanni
	 */ 
  private void inicializarVariableVenta() throws Exception {
  
      pagina("salidaGenerica");
      asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    
      try{
        dtoConcurso = super.getConcurso();
        
        dtoConcurso.setVariablesVentaRanking(null);
        dtoConcurso.setIndVariablesVentaRanking(Boolean.FALSE);
        dtoConcurso.setIndObligVariablesVentaRanking(Boolean.FALSE);
        dtoConcurso.setIndBorradoVariablesVentaRanking(Boolean.TRUE);
        
        super.setConcurso(dtoConcurso);
        
        asignarAtributo("VAR", "ejecutar", "valor", "inicializoVariableVenta()");
  
      } catch(Exception e){
              asignarAtributo("VAR", "ejecutarError", "valor", "inicializoVariableVenta()");
        throw e;
      }	
  }
  
}
