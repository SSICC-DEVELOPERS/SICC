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

public class LPMantenerParametrosGerentes extends LPIncentivos {    
    private Long lIdioma = null;
    private Long lPais = null;    
    private DTOListaMontoVentaRecomendadas dtoListaMVRAuxiliar = new DTOListaMontoVentaRecomendadas();
    private DTOClasificacionParticipantes dtoListaClasParticipantesAux = new DTOClasificacionParticipantes();
    private DTOVariablesVenta dtoVVtaAux = new DTOVariablesVenta();
    
    public LPMantenerParametrosGerentes() { super(); }

    public void inicio() throws Exception {
        this.obtenerFlagsPestanyas();
        pagina("contenido_parametros_gerente_mantener");
        this.cargarFlagsPestanyas();
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        try{
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            opcionMenu = conectorParametro("opcionMenu")==null?"":conectorParametro("opcionMenu");
            
            lIdioma = UtilidadesSession.getIdioma(this);
            lPais = UtilidadesSession.getPais(this);
            Long lMarca = UtilidadesSession.getMarcaPorDefecto(this);
            Long lCanal = UtilidadesSession.getCanalPorDefecto(this);
            traza(">>>> Acción................" + accion);            
            traza(">>>> opcionMenu............" + opcionMenu);
            traza(">>>> Idioma................" + lIdioma);
            traza(">>>> Pais.................." + lPais);
            traza(">>>> Marca................." + lMarca);            
            traza(">>>> Canal................." + lCanal);
            
            obtenerFlagsPestanyas();
            cargaConstantesEnPantalla();

            if (accion.equals("")){
                cargarPantalla();
            }
			else if (accion.equals("cargar clasificacion participantes")){
                cargarPantallaClasificacionParticipantes(); 
            }
			else if (accion.equals("cargar monto venta recomendadas")){
                cargarPantallaMontoVentaRecomendadas(); 
            }
			else if (accion.equals("cargar variables venta")){
                cargarPantallaVariablesVenta(); 
            }
			else if (accion.equals("almacenar")){
                traza("Almacenando y redirigiendo");
                this.almacenar();
                this.redirigir();
            }
			else if (accion.equals("guardar")){
                almacenar();
                guardar(); 
            }
            else if (accion.equals("redirigir")) {
                traza("Redirigiendo..... ");
                redirigir(); 
            }
            else if (accion.equals("almacenar monto venta recomendadas")){
                almacenarMontoVentaRecomendadas();
            }
            else if (accion.equals("almacenar Clasificacion Participantes")){
                pagina("salidaGenerica");	
				this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
                almacenarClasificacionParticipantes();
                traza("Almacenada Lista Clasificacion Participantes ");
                asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                asignarAtributo("VAR","ejecutarError","valor","accionError()");
            }
            else if(accion.equals("almacenar variables venta")){            
                String sOidVariablesVenta = conectorParametro("oidVariablesVenta")==null?"":conectorParametro("oidVariablesVenta");

				String sVariablesVta = conectorParametro("hidVariablesVenta")==null?"":conectorParametro("hidVariablesVenta");
                
				traza("sOidVariablesVenta   " + sOidVariablesVenta);
                traza("Contenido Variables de Venta   " + sVariablesVta);                
                
				pagina("salidaGenerica");	
                this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 
                almacenarVariablesVenta(sOidVariablesVenta, sVariablesVta);
                traza("Almacenada Variables Venta");
                asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
                asignarAtributo("VAR","ejecutarError","valor","accionError()");
            }
            
         if(opcionMenu.equals("Crear Concurso")){			 
                    if(accion.equals("")){
                        getConfiguracionMenu("LPMantenerParametrosGerentes","");
                        asignarAtributoPagina("cod", "0491");
                    }                       
                   
                    if(accion.equals("cargar clasificacion participantes")){                   
                        getConfiguracionMenu("LPMantenerParametrosGerentes","clasificacionParticipante");;
                        asignarAtributoPagina("cod", "0491");                    
                    }                   
                
                    if(accion.equals("cargar monto venta recomendadas")){
                        getConfiguracionMenu("LPMantenerParametrosGerentes","montoVetaRecomendada");
                        asignarAtributoPagina("cod", "0506");
                    }   
                   
                    if(accion.equals("cargar variables venta")){
                      getConfiguracionMenu("LPMantenerParametrosGerentes","variablesVenta");
                      asignarAtributoPagina("cod", "0506");
                    }  
       
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
         traza("************ Entro a cargarPantalla - LPMantenerParametrosGerentes");

 		 getFormatosValidaciones();
         DTOConcurso dtoConcurso = getConcurso();
		 traza("************ DTOConcurso " + dtoConcurso);

         DTOBelcorp dtob = new DTOBelcorp();
         dtob.setOidIdioma(lIdioma);
         dtob.setOidPais(lPais);

         DTOPeriodo dtop = new DTOPeriodo();
         dtop.setOidPais(lPais);
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

         ComposerViewElement ci4 = new ComposerViewElement();
         ci4.setIDBusiness("CRAObtienePeriodos");
         ci4.setDTOE(dtop);                
         cvEL.addViewElement(ci4);
 
         ConectorComposerView conector = new ConectorComposerView(cvEL, 
                                                      this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
	     //1° Se cargan los combos 
         asignar("COMBO", "cbFormaCalculo", resultados, "INCObtenerFormaCalculo");
         asignar("COMBO", "cbBaseCalculo", resultados, "INCConsultaBasesCalculo");
         asignar("COMBO", "cbTipoVenta", resultados, "INCConsultaTiposVenta");
         asignar("COMBO", "cbPeriodoInicialEvaluacion", resultados, "CRAObtienePeriodos");

         DTOPlantilla  dtoPla = dtoConcurso.getPlantilla();		 

		 //2° Si el parametro indPartParticipantesCompleto de la plantilla
		 //esta en true, se oculta el boton "Participantes"
         if ( dtoPla.getIndPartParticipantesCompleto()!= null){
             String IndPartPartCompleto = obtenerValor( dtoPla.getIndPartParticipantesCompleto() );       
             if (IndPartPartCompleto.equals("S")) { 
                  asignarAtributo("VAR","ocultaParticipante","valor", "1");
             }
         }

		//3° Se setea el oid de base de calculo de la plantilla a una
		//variable de la pagina
		Long oidBCPlantilla = dtoConcurso.getPlantilla().getOidBaseCalculo();
		if (oidBCPlantilla != null)
		  asignarAtributo("VAR","oidPlantillaBaseCalculo","valor", oidBCPlantilla.toString() );

		//4° Si ya habia ingresado a esta pestaña, se setean los valores
		if (dtoConcurso.getIndGerentes().booleanValue()) {
 			 traza("********* Ya se habia ingresado a la pestaña Gerentes");

             asignarAtributo("VAR","hidIndGerentes","valor", "1");
             DTOParametrosGerentes dtoPG = dtoConcurso.getParamGerentes();

             if (dtoPG != null) {
                  Long lOidParamGerentes = dtoPG.getOidParamGerentes();
                  if (lOidParamGerentes != null) {
                      asignarAtributo("VAR","oidParamGerentes","valor", lOidParamGerentes.toString());
                  }
                  
                  asignarAtributo("VAR","oidFormaCalculo","valor", dtoPG.getOidFormaCalculo().toString());

				  //Si en el combo forma de calculo se seteo, base de calculo...
                  if ( dtoPG.getOidFormaCalculo().equals(ConstantesINC.OID_FORMA_CALC_BASE_CALC)) {
                      Long lPlantillaOidBaseCalculo = dtoPla.getOidBaseCalculo();

                      if (lPlantillaOidBaseCalculo!= null) { 
                           asignarAtributo("VAR","oidPlantillaBaseCalculo","valor", 
                                                  lPlantillaOidBaseCalculo.toString());

                           Long lOidTipoVta = dtoPG.getOidTipoVenta();
						   //Se setea el oid e tipo de venta
                           if (lOidTipoVta != null)
                               asignarAtributo("VAR","oidTipoVta","valor", lOidTipoVta.toString());
                                                  
						   //Se setea el checkbox de recomendacion efectiva
                           if ( dtoPG.getIndRecomendacionEfectiva() != null )
                               asignarAtributo("CHECKBOX","RecomendacionEfectiva","check", 
                               bool2check(dtoPG.getIndRecomendacionEfectiva()));
   
						   //Se setea el oid de periodo
                           if ( dtoPG.getOidPeriodoInicialEvaluacion()!= null)
                               asignarAtributo("VAR","hidPeriodoInicialEval","valor", 
                               dtoPG.getOidPeriodoInicialEvaluacion().toString());
                          
 						   //Se setea el numero de periodos a evaluar
                           if ( dtoPG.getNumeroPeriodosEvaluar() != null )
                               asignarAtributo("CTEXTO","txtNumPeriodosEvaluar","valor", 
                               dtoPG.getNumeroPeriodosEvaluar().toString());

						   //Se setea el numero minimo pedidos
                           if ( dtoPG.getNumeroMinimoPedidos() != null )
                               asignarAtributo("CTEXTO","txtNumMinPedidos","valor", 
                               dtoPG.getNumeroMinimoPedidos().toString());
                          
  						   //Se setea el numero minimo minimo pedidos recomendada
                           if ( dtoPG.getNumeroMinimoPedidosRecomendada() != null )
                               asignarAtributo("CTEXTO","txtNumMinPedidosRecomendada","valor", 
                               dtoPG.getNumeroMinimoPedidosRecomendada().toString()); 
                                                  
                      }//fin if
					  else { 
                           Long lParamGteOidBC = dtoPG.getOidBaseCalculo();
                           if (lParamGteOidBC != null) {
							    //Se setea el oid de base de calculo    
                                asignarAtributo("VAR","oidParamBaseCalculo","valor", lParamGteOidBC.toString());
                                Long lOidTipoVta = dtoPG.getOidTipoVenta();
                                if (lOidTipoVta != null)
									//Se setea el oid de tipo de venta
                                    asignarAtributo("VAR","oidTipoVta","valor", lOidTipoVta.toString());

								//Si es recomendadas se setean los checkbox y las cajas de texto
								if(lParamGteOidBC.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS)) { 
									if ( dtoPG.getIndRecomendacionEfectiva() != null )
										 asignarAtributo("CHECKBOX","RecomendacionEfectiva","check", 
										 bool2check(dtoPG.getIndRecomendacionEfectiva()));
				 
									if ( dtoPG.getOidPeriodoInicialEvaluacion()!= null)
										 asignarAtributo("VAR","hidPeriodoInicialEval","valor", 
										 dtoPG.getOidPeriodoInicialEvaluacion().toString());
										
									if ( dtoPG.getNumeroPeriodosEvaluar() != null )
										 asignarAtributo("CTEXTO","txtNumPeriodosEvaluar","valor", 
										 dtoPG.getNumeroPeriodosEvaluar().toString());
										
									if ( dtoPG.getNumeroMinimoPedidos() != null )
										 asignarAtributo("CTEXTO","txtNumMinPedidos","valor", 
										 dtoPG.getNumeroMinimoPedidos().toString());
										
									if ( dtoPG.getNumeroMinimoPedidosRecomendada() != null )
										 asignarAtributo("CTEXTO","txtNumMinPedidosRecomendada","valor", 
										 dtoPG.getNumeroMinimoPedidosRecomendada().toString()); 
		                        }//fin if
	                       }//fin if
                      }//fin else
                  }//fin if
             }//fin if
						
						if(dtoConcurso.getPlantilla().getIndFaseCalificacion().booleanValue()==true) {
								 asignarAtributo("VAR","hIndFaseCalificacion","valor", "1");				
						}


		}//fin if
		else{
			//INICIO - CAMBIOS INCIDENCIA 20760
			traza("********* Se ingresa a la pestaña Gerentes por primera vez");
			if(dtoConcurso.getPlantilla().getIndFaseCalificacion().booleanValue()==true) {
				if(dtoConcurso.getPlantilla().getOidTipoCalificacion().longValue()==
					ConstantesINC.OID_TIPO_CALIF_PROYECTADA.longValue()) {
					 //Se seleccionara en el combo forma de calculo el valor
					 //correspondiente a variables de venta y se deshabilita el mismo
					 asignarAtributo("VAR","seleccFormaCalculo","valor", "variablesVenta");
				}

				if(dtoConcurso.getPlantilla().getOidTipoCalificacion().longValue()==
					ConstantesINC.OID_TIPO_CALIF_HISTORICA_INC.longValue() ||
				   dtoConcurso.getPlantilla().getOidTipoCalificacion().longValue()==
					ConstantesINC.OID_TIPO_CALIF_HISTORICA_INC_NIVELES.longValue()) {
					//Se seleccionara en el combo forma de calculo el valor
					//correspondiente a base de calculo y se deshabilita el mismo
					asignarAtributo("VAR","seleccFormaCalculo","valor", "baseCalculo");

					if(dtoConcurso.getPlantilla().getOidBaseCalculo()!=null) {
						//Se seleccionara el valor que haya en el combo base de calculo
						//y se deshabilitara el mismo
						asignarAtributo("VAR","oidBaseCalculoTemp","valor", dtoConcurso.getPlantilla().getOidBaseCalculo().toString());

						if(dtoConcurso.getPlantilla().getOidBaseCalculo().longValue()==
							ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.longValue()) {
							//Se mostrara la capa recomendadas, esto se hace en la pagina
							//al llamar al boton Aceptar del frame Forma de calculo
						}
						else {
							if(dtoConcurso.getPlantilla().getOidBaseCalculo().longValue()==
							ConstantesINC.OID_BASE_CALCULO_MONTO.longValue()) {
								//Se mostrara la capa monto, esto se hace en la pagina
								//al llamar al boton Aceptar del freame Forma de calculo
							}
							else {
								//Se oculta la capa monto, eso se hace en la pagina
								//al llamar al boton Aceptar del frame Forma de calculo
							}

							//Se oculta la capa recomendadas, esto se hace en la pagina
							//al llamar al boton Aceptar del frame Forma de calculo

						}//fin else

					}//fin if

				}//fin if

			}//fin if	
			
			//FIN    - CAMBIOS INCIDENCIA 20760
		}

		if(dtoConcurso!=null && dtoConcurso.getPlantilla()!=null && 
		   dtoConcurso.getPlantilla().getOidTipoVenta()!=null) {
			asignarAtributo("VAR","oidTipoVentaPlantilla","valor", 
			dtoConcurso.getPlantilla().getOidTipoVenta().toString());
		}

		//Se setea la lista de monto venta recomendada
        if (dtoConcurso.getListaMontoVentaRecomendadas()!= null){
			dtoListaMVRAuxiliar = dtoConcurso.getListaMontoVentaRecomendadas();
            this.getSessionCache().put("dtoLstMVRG", dtoListaMVRAuxiliar);
			asignarAtributo("VAR","tengoLstMVR","valor", "true");
        }
         
		//Se pone en sesion la lista de clasificacion participantes
        if (dtoConcurso.getClasificParticipantes()!= null) {
			dtoListaClasParticipantesAux = dtoConcurso.getClasificParticipantes();
            this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
        }

		//Se ponen en sesion las variables de venta
        if ( dtoConcurso.getVariablesVenta()!= null){
			dtoVVtaAux = dtoConcurso.getVariablesVenta();
            this.getSessionCache().put("dtoVVenta", dtoVVtaAux);
			asignarAtributo("VAR","tengoVariablesVenta","valor", "true");
            if ( dtoConcurso.getVariablesVenta().getOid() != null)
				asignarAtributo("VAR","oidVariablesVenta","valor", dtoConcurso.getVariablesVenta().getOid().toString());
        }

		//Se setean variables de formulario
        if (!this.opcionMenu.equals("") && this.opcionMenu!= null)
			asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
         
        asignarAtributo("VAR","accion","valor", this.accion);
		asignarAtributo("VAR","tengoLstMVR","valor", this.opcionMenu);
		asignarAtributo("VAR","tengoVariablesVenta","valor", this.opcionMenu);
    }

    
    public void cargarPantallaClasificacionParticipantes() throws Exception{         
        traza("Entrando a cargarPantallaClasificacionParticipantes");
        pagina("contenido_participantes_seleccionar");
        dtoListaClasParticipantesAux = (DTOClasificacionParticipantes)this.getSessionCache().get("dtoLstClasParG");
        if (dtoListaClasParticipantesAux != null ){
            if (dtoListaClasParticipantesAux.getLstClasificacionParticipantes()!= null){
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

        if (opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
        }
        asignarAtributo("VAR","accion","valor", this.accion);
        getConfiguracionMenu("LPMantenerParametrosGerentes","clasificacionParticipante");
        asignarAtributoPagina("cod", "0491");
        
    }
    

	public void almacenarClasificacionParticipantes() throws Exception{
        dtoListaClasParticipantesAux.setLstClasificacionParticipantes(null);
        dtoListaClasParticipantesAux.setLstParticipantes(null);
        
        String sLstClasifConsul = conectorParametro("hidLstClasConsul")==null?"":conectorParametro("hidLstClasConsul");
        if (sLstClasifConsul!= null){
            ArrayList lstClasPart = new ArrayList();
            traza("Procesando Participantes Consultoras   "  + sLstClasifConsul);
            lstClasPart = aplanarClasificacionParticipantes(sLstClasifConsul);
            dtoListaClasParticipantesAux.setLstClasificacionParticipantes(lstClasPart);
        }
       
        String sListaClasif = conectorParametro("hidListaClasif")==null?"":conectorParametro("hidListaClasif");
        if (sListaClasif != null){
            ArrayList lstClasif = new ArrayList();
            traza("Procesando Clasificacion Participantes   " + sListaClasif);
            lstClasif = aplanarParticipantes(sListaClasif);
            dtoListaClasParticipantesAux.setLstParticipantes(lstClasif);
        }
        
        this.getSessionCache().put("dtoLstClasParG", dtoListaClasParticipantesAux);
    }
    
    public void cargarPantallaMontoVentaRecomendadas() throws Exception{
        pagina("contenido_monto_ventas_recomendadas_mantener");
        traza("Entrando a cargarPantallaMontoVentaRecomendadas");  
        
        this.getFormatosValidaciones();
        
        
        dtoListaMVRAuxiliar = (DTOListaMontoVentaRecomendadas)this.getSessionCache().get("dtoLstMVRG");
        if ( dtoListaMVRAuxiliar!= null){
            ArrayList arrMontoVtaRec =  dtoListaMVRAuxiliar.getMontosVenta();    
            CargarListaMontoVentaRecomendadas(arrMontoVtaRec);    
        }

        if (opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
        }
        asignarAtributo("VAR","accion","valor", this.accion);
       getConfiguracionMenu("LPMantenerParametrosGerentes","montoVetaRecomendada");
           asignarAtributoPagina("cod", "0506");
    }
    
    public void almacenarMontoVentaRecomendadas() throws Exception{ 
		try {
			
			pagina("salidaGenerica");	
			asignarAtributo("VAR","cerrarVentana","valor","false");
			traza("Almacenada Lista monto venta recomendadas");

			traza("==================== Entrando a almacenarMontoVentaRecomendadas");        
			String sListaMontoVtaReco = conectorParametro("hidLstMVR")==null?"":conectorParametro("hidLstMVR");
			dtoListaMVRAuxiliar.setMontosVenta(null);    
			if (sListaMontoVtaReco!= null){
				traza("Procesando Monto Venta Recomendada   "  + sListaMontoVtaReco);
				ArrayList lstMVtaREc = aplanarMontoVentaRecomendada(sListaMontoVtaReco);
				dtoListaMVRAuxiliar.setMontosVenta(lstMVtaREc);
			}
			this.getSessionCache().put("dtoLstMVRG", dtoListaMVRAuxiliar);
			asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
		} catch (Exception e) {
			asignarAtributo("VAR","ejecutarError","valor","accionError()");
		}
    }
    
    public void cargarPantallaVariablesVenta() throws Exception{
        traza("LPMantenerParametrosGerentes.cargarPantallaVariablesVenta() - Entrada");
        pagina("contenido_variables_venta_mantener");
        
        String sOidVariablesVenta = conectorParametro("oidVariablesVenta")==null?"":conectorParametro("oidVariablesVenta");
		traza("*********** sOidVariablesVenta   " + sOidVariablesVenta);        

        dtoVVtaAux = (DTOVariablesVenta)this.getSessionCache().get("dtoVVenta");
        
		if ( dtoVVtaAux!= null){    
            String sIndicadores = obtenerValor(dtoVVtaAux.getIndActivas()) + "|"; 
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndIngreso()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndReingreso()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndEgresos()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndEntregadas()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndRecibidas()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndCapitalizacion()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndActivasFinales()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndActividad()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndNumeroPedidos()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndPrecioPromedioUnitario()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndPromedioVentaPedido()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndPromedioUnidadesPedido()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndPromedioOrdenesPedido()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndRetencion()) + "|";
            sIndicadores = sIndicadores + obtenerValor(dtoVVtaAux.getIndVentaEstadisticable()) + "|";            
            
            asignarAtributo("VAR","oidVariablesVenta","valor", sOidVariablesVenta);            
            asignarAtributo("VAR","hidIndicadoresVbles","valor", sIndicadores);
        }
        
        if (opcionMenu!= null){
            asignarAtributo("VAR","opcionMenu","valor", this.opcionMenu);
        }

        asignarAtributo("VAR","accion","valor", this.accion);
        getConfiguracionMenu("LPMantenerParametrosGerentes","variablesVenta");
        asignarAtributoPagina("cod", "0506");
        traza("LPMantenerParametrosGerentes.cargarPantallaVariablesVenta() - Salida");       
    }
    
    public void almacenarVariablesVenta(String sOidVariablesVenta, String sVariablesVta) throws Exception
    {
    
        traza("Entrando a almacenarVariablesVenta");    
        
        traza("sOidVariablesVenta   " + sOidVariablesVenta);
        traza("Contenido Variables de Venta   " + sVariablesVta);
        
        if (!sOidVariablesVenta.equals(""))
            dtoVVtaAux.setOid(new Long (sOidVariablesVenta));
    
        if (sVariablesVta != null){
            dtoVVtaAux.setIndActivas(char2Bool(sVariablesVta.substring(0,1)));
            dtoVVtaAux.setIndIngreso(char2Bool(sVariablesVta.substring(2,3)));
            dtoVVtaAux.setIndReingreso(char2Bool(sVariablesVta.substring(4,5)));
            dtoVVtaAux.setIndEgresos(char2Bool(sVariablesVta.substring(6,7)));
            dtoVVtaAux.setIndEntregadas(char2Bool(sVariablesVta.substring(8,9)));
            dtoVVtaAux.setIndRecibidas(char2Bool(sVariablesVta.substring(10,11)));
            dtoVVtaAux.setIndCapitalizacion(char2Bool(sVariablesVta.substring(12,13)));
            dtoVVtaAux.setIndActivasFinales(char2Bool(sVariablesVta.substring(14,15)));
            dtoVVtaAux.setIndActividad(char2Bool(sVariablesVta.substring(16,17)));
            dtoVVtaAux.setIndNumeroPedidos(char2Bool(sVariablesVta.substring(18,19)));
            dtoVVtaAux.setIndPrecioPromedioUnitario(char2Bool(sVariablesVta.substring(20,21)));
            dtoVVtaAux.setIndPromedioVentaPedido(char2Bool(sVariablesVta.substring(22,23)));
            dtoVVtaAux.setIndPromedioUnidadesPedido(char2Bool(sVariablesVta.substring(24,25)));
            dtoVVtaAux.setIndPromedioOrdenesPedido(char2Bool(sVariablesVta.substring(26,27)));
            dtoVVtaAux.setIndRetencion(char2Bool(sVariablesVta.substring(28,29)));
            dtoVVtaAux.setIndVentaEstadisticable(char2Bool(sVariablesVta.substring(30,31)));
        }
        
        traza("dtoVVtaAux   " + dtoVVtaAux);
        this.getSessionCache().put("dtoVVenta", dtoVVtaAux);
        conectorParametroSesion("oidVariablesVenta", sOidVariablesVenta);

        traza("Saliendo de a almacenarVariablesVenta");    
    }
    
    public void almacenar() throws Exception {    
        traza("*** Entrando a almacenar");

        String sOidVariablesVenta = conectorParametro("oidVariablesVenta")==null?"":conectorParametro("oidVariablesVenta");
        String sVariablesVta = conectorParametro("hidVariablesVenta")==null?"":conectorParametro("hidVariablesVenta");
        
		traza("*** sOidVariablesVenta " + sOidVariablesVenta);
        traza("*** sVariablesVta " + sVariablesVta);
        
        concurso = getConcurso();
        
        traza("*** Almancenando Variables de Venta");

        String sOidFormaCalculo = this.conectorParametroLimpia("cbFormaCalculo", "", true);
		traza("*** sOidFormaCalculo: " + sOidFormaCalculo);

		if (!sOidFormaCalculo.equals("") ) {            
            if (sOidFormaCalculo.equals(ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.toString())) {
				if(!sVariablesVta.equals("")) {
					concurso.setIndVariablesVenta(Boolean.TRUE);
	                concurso.setVariablesVenta(null);
		            almacenarVariablesVenta(sOidVariablesVenta, sVariablesVta);
			        concurso.setVariablesVenta(dtoVVtaAux);
				}
				else {
					concurso.setIndVariablesVenta(new Boolean(false));
	            }				
			}
        }

        String sOidBaseCalculo = this.conectorParametroLimpia("cbBaseCalculo", "", true);
        traza("*** sOidBaseCalculo  " + sOidBaseCalculo);        

        if ( !sOidBaseCalculo.equals("") ) {
            if (sOidBaseCalculo.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.toString())) {

                String sListaMontoVta = conectorParametro("hidLstMVR")==null?"":conectorParametro("hidLstMVR");
                traza("*** sListaMontoVta " + sListaMontoVta);
                if (!sListaMontoVta.equals("")) {
                    concurso.setListaMontoVentaRecomendadas(null);
                    almacenarMontoVentaRecomendadas();
                    concurso.setListaMontoVentaRecomendadas(dtoListaMVRAuxiliar);
					concurso.setIndMontoVentaRecomendadas(new Boolean(true));
                } 
				else { 
					concurso.setIndMontoVentaRecomendadas(new Boolean(false));					
                }
            }
        }

        String sListaClas = 
			conectorParametro("hidListaClasif")==null?"":conectorParametro("hidListaClasif");          

        String sLstClasifConsul = 
			conectorParametro("hidLstClasConsul")==null?"":conectorParametro("hidLstClasConsul");

        traza("*** Lista Clasif   " + sListaClas);
        traza("*** Lista Clasif Consul   " + sLstClasifConsul);

		if(!sListaClas.equals("") || !sLstClasifConsul.equals("")) {
			concurso.setClasificParticipantes(null);
            almacenarClasificacionParticipantes();
            concurso.setClasificParticipantes(dtoListaClasParticipantesAux);
		}

        if (!sLstClasifConsul.equals("")){
            concurso.setIndClasificacionParticipantes(Boolean.TRUE);            
        }
        
        DTOParametrosGerentes dtoPG = concurso.getParamGerentes();
        if (dtoPG == null)
            dtoPG = new DTOParametrosGerentes();

        Boolean bValor = new Boolean(conectorParametro("datosObligatorios"));
        traza("*** datosObligatorios  " + bValor);
        if (bValor != null)
            concurso.setIndObligGerentes(bValor);
        
        String soidParamGerentes = conectorParametro("oidParamGerentes")==null?"":conectorParametro("oidParamGerentes");
        traza("*** sOidParamGerentes: " + soidParamGerentes);

		if (!soidParamGerentes.equals(""))
            dtoPG.setOidParamGerentes(new Long(soidParamGerentes));
        
        if ( !sOidFormaCalculo.equals("") )
          dtoPG.setOidFormaCalculo(new Long(sOidFormaCalculo));

        if (sOidFormaCalculo.equals(ConstantesINC.OID_FORMA_CALC_BASE_CALC.toString())) {
            if ( !sOidBaseCalculo.equals("") ) {
                dtoPG.setOidBaseCalculo(new Long(sOidBaseCalculo));
                if (sOidBaseCalculo.equals(ConstantesINC.OID_BASE_CALCULO_MONTO.toString())) {
                    
                    String sOidTipoVenta = this.conectorParametroLimpia("cbTipoVenta", "", true);                    
                    if ( !sOidTipoVenta.equals("") )
                        dtoPG.setOidTipoVenta(new Long(sOidTipoVenta));
					else
						dtoPG.setOidTipoVenta(null);
                } else {
                   dtoPG.setOidTipoVenta(null);
                }
                if (sOidBaseCalculo.equals(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.toString())) {
                    
                    String sRecoEfectiva = this.conectorParametroLimpia("ckRecomendacionEfectiva", "", true);
                    String sPeriodoInicialEval = this.conectorParametroLimpia("cbPeriodoInicialEvaluacion", "", true);                                        
                    String sNroPeriodosEvaluar = this.conectorParametroLimpia("txtNumPeriodosEvaluar", "", true);                    
                    String sNroMinimoPedidos = this.conectorParametroLimpia("txtNumMinPedidos", "", true);                    
                    String sNroMinPedidosReco = this.conectorParametroLimpia("txtNumMinPedidosRecomendada", "", true);                    
                                    
                    traza("*** sRecoEfectiva       " + sRecoEfectiva );
                    traza("*** sNroPeriodosEvaluar " + sNroPeriodosEvaluar);
                    traza("*** sNroMinimoPedidos   " + sNroMinimoPedidos );
                    traza("*** sNroMinPedidosReco  " + sNroMinPedidosReco );
                    traza("*** seriodoInicialEval  " + sPeriodoInicialEval );
                    
                    if (!sRecoEfectiva.equals("")) {
                        if (sRecoEfectiva.equals("S"))
                            dtoPG.setIndRecomendacionEfectiva(Boolean.TRUE);
                        else
                            dtoPG.setIndRecomendacionEfectiva(Boolean.FALSE);
                    }   
                        
                    if (!sNroPeriodosEvaluar.equals(""))
                        dtoPG.setNumeroPeriodosEvaluar(new Integer(sNroPeriodosEvaluar));
                    else  
                        dtoPG.setNumeroPeriodosEvaluar(null);                         
                        
                    if (!sNroMinimoPedidos.equals(""))
                        dtoPG.setNumeroMinimoPedidos(new Integer(sNroMinimoPedidos));
                    else
                        dtoPG.setNumeroMinimoPedidos(null);
                        
                    if (!sNroMinPedidosReco.equals(""))
                        dtoPG.setNumeroMinimoPedidosRecomendada(new Integer(sNroMinPedidosReco));
                    else
                        dtoPG.setNumeroMinimoPedidosRecomendada(null);
                        
                    if (!sPeriodoInicialEval.equals(""))
                        dtoPG.setOidPeriodoInicialEvaluacion(new Long(sPeriodoInicialEval));            
                    else
                        dtoPG.setOidPeriodoInicialEvaluacion(null);
                }
                else{
                    dtoPG.setIndRecomendacionEfectiva(new Boolean(ConstantesINC.IND_INACTIVO.toString()));
                    dtoPG.setNumeroPeriodosEvaluar(null);
                    dtoPG.setNumeroMinimoPedidos(null);
                    dtoPG.setNumeroMinimoPedidosRecomendada(null);
                    dtoPG.setOidPeriodoInicialEvaluacion(null);
                }
            }
        }
		else {
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
		traza("******************** DTOConsurso que se manda a guardar");
		traza("******************** concurso " + concurso);
        setConcurso(concurso);
    }
    
    private String obtenerValor(Boolean bool) throws Exception{ 
		traza("********** obtenerValor");
		traza("********** bool " + bool);

		if(bool==null || bool.booleanValue() == false) return new String("N");
		else return new String("S");
	}
    
     private void cargaConstantesEnPantalla() throws Exception
    {
        asignarAtributo("VAR","oidBC_Recomendada","valor", 
                    ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.toString());
        asignarAtributo("VAR","oidBC_Calculo_Monto","valor", 
                    ConstantesINC.OID_BASE_CALCULO_MONTO.toString());
        asignarAtributo("VAR","oid_Forma_Calc_Base_Calc","valor", 
                    ConstantesINC.OID_FORMA_CALC_BASE_CALC.toString());
        asignarAtributo("VAR","oid_Forma_Calc_Vbles_Vta","valor", 
                    ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.toString()); 
                    
        //
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
    
    public void CargarListaMontoVentaRecomendadas(ArrayList arrMontoVtaRec) 
                                                            throws Exception{
        
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
              sCantidad = dtoVMR.getCantidad().toString();
              
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
    
    ArrayList aplanarMontoVentaRecomendada(String listado) throws Exception {
        traza("************** Entre a aplanarMontoVentaRecomendada");
        traza(listado);

        ArrayList lstClasPart = new ArrayList ();
        // Modificado por ssantana, 26/5/2005
        
        // Primero quita los "[" - "]" del principio y final.
        listado = listado.substring(1, listado.length()-1); // "["
        listado = listado.substring(0, listado.length());   // "]"
        traza("listado sin []: " + listado);
        
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
           //--Se cambia dtoMVR.setCantidad(new Integer(sCantidad))
            dtoMVR.setCantidad(new BigDecimal(sCantidad));
          }
            
          traza("DTO a Agregar: " + dtoMVR);
            
          lstClasPart.add(dtoMVR);
        }       
        
        return lstClasPart;
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
     
      ArrayList aplanarClasificacionParticipantes(String listado) 
                                                            throws Exception{
        traza("************** Entre a aplanarClasificacionParticipantes");
        traza(listado);

        StringTokenizer stRows = new StringTokenizer(listado, "$");
        int rowCount = stRows.countTokens();
        ArrayList lstClasPart = new ArrayList ();
        
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
                                                    throws Exception{
        traza("Entrando a cargarParticipantes" );
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
            for(int conta =  0 ;stColss.hasMoreTokens(); conta++) {								
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
     
     public Boolean char2Bool(String valor){
        if (valor.equals("S"))
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
     }
     
     public String bool2check(Boolean lValor)
    {
        if (lValor == Boolean.TRUE)
            return "S";
        else
            return "N";
    }
}
