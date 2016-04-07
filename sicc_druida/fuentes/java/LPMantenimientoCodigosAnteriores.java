/**
 * Copyright 2006 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
  import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
  import es.indra.mare.common.mln.MareBusinessID;
  import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
  import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
  import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
 
  import es.indra.sicc.dtos.mae.DTODataCodigoAnterior;
  import es.indra.sicc.util.DTOOID;
  import es.indra.sicc.util.UtilidadesSession;
  import es.indra.sicc.util.DTOBelcorp;
  import es.indra.sicc.util.UtilidadesBelcorp;
  import java.util.Vector;

 
  public class LPMantenimientoCodigosAnteriores  extends LPSICCBase {
    	


        private String accion = null;
        private String opcionMenu = null;
                
        private String CLIENTENUEVO = null;
        private String CLIENTEANTI = null;
        private String SISTEMA = null;
        private String PAIS_OID_PAIS = null;
        private String OID_CLIE = null;
        private String OID_CODI_CLIE_ANTE = null;
               

          public LPMantenimientoCodigosAnteriores() {
                    super();
          }
          
          public void inicio() throws Exception {}

          public void ejecucion() throws Exception {
                        
              rastreo();
              setTrazaFichero();
              traza("*** Entrada - LPMantenimientoCodigosAnteriores  - ejecucion ***");
               
               try  {
               
                      accion = conectorParametroLimpia("accion", "", true);
                      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
                      
                      if (accion.equals("")) {
                          inicializar();
                      } else {
                              if (accion.equals("guardar")) {
                                  guardar();
                              } else {
                                      if (accion.equals("modificar")) {
                                          modificarCodigosAnteriores();
                                      } else {
                                              if (accion.equals("detalle")) {
                                                detalleCodigosAnteriores();
                                              }
                                        }
                                }
                        }
          
               } catch ( Exception e )  {
                        traza("....Excepcion LPMantenimientoCodigosAnteriores - opcionMenu: " + opcionMenu);

                        lanzarPaginaError(e);
                }
           traza("*** Salida - LPMantenimientoCodigosAnteriores  - ejecucion ***");
          }
          
      private void inicializar() throws Exception {
          traza("*** Entrada - LPMantenimientoCodigosAnteriores  - inicializar ***");
		
          opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
          traza(" **** opcionMenu : " + opcionMenu);
          
          if (opcionMenu.equals("InsertarCodigoAnterior")) {
              cargarPaginaInsertarCodigoAnterior();
			
          }
          else {
                if (opcionMenu.equals("ModificarCodigoAnterior") || opcionMenu.equals("ConsultarCodigoAnterior") 
																					|| opcionMenu.equals("EliminarCodigoAnterior")) {
              	
                    cargarPaginaConsultarCodigoAnterior();
                }
          }

      }
      
      
      		public void cargarPaginaConsultarCodigoAnterior() throws Exception{
                traza("*** Entrada - LPMantenimientoCodigosAnteriores  - cargarPaginaConsultarCodigoAnterior ***");
              
                pagina("contenido_clientes_anteriores_consultar");
                        this.getFormatosValidaciones();
        	asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

                DTOBelcorp dtoe = new DTOBelcorp();
                    
                Long pais = UtilidadesSession.getPais(this); 
                Long idioma = UtilidadesSession.getIdioma(this);

                dtoe.setOidPais(pais);
                dtoe.setOidIdioma(idioma);

                asignarAtributo("VAR", "hIdioma", "valor",idioma.toString());
                asignarAtributo("VAR", "hPais", "valor", pais.toString());

                ComposerViewElementList lista = new ComposerViewElementList();
                //Obtenemos los paises
        
                ComposerViewElement elem1 = new ComposerViewElement();
                elem1.setIDBusiness("MENConsultaPaises");
                elem1.setDTOE(dtoe);
                lista.addViewElement(elem1);
          
                // Invocar al  subsistema GestorCargaPantalla
                ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());

                conector.ejecucion();

                DruidaConector resultados = conector.getConector();
                
                traza("*** antes de asignar resultados a combo"  + resultados);

                asignar("COMBO", "cbPaisNuevo", resultados, "MENConsultaPaises");                
                
                asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
                
                if(opcionMenu.equals("ConsultarCodigoAnterior")){
                    
                    getConfiguracionMenu("LPMantenimientoCodigosAnteriores","consultar");
                    this.asignarAtributoPagina("cod", "01047");
        
                    asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
                    asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");

                }			
              
                if(opcionMenu.equals("ModificarCodigoAnterior")){
        
                  getConfiguracionMenu("LPMantenimientoCodigosAnteriores","modificar");
                  this.asignarAtributoPagina("cod", "01048");
                
                  asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
                  asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");
                }
              
                if(opcionMenu.equals("EliminarCodigoAnterior")){
        
                  getConfiguracionMenu("LPMantenimientoCodigosAnteriores","eliminar");
                  this.asignarAtributoPagina("cod", "01049");
        
                  asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");
                  asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");
        
                }
              
                asignarAtributo("VAR", "accion", "valor",accion);
                asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
                asignarAtributo("VAR", "hpais", "valor", pais.toString());
                asignarAtributo("VAR", "hIdioma", "valor", idioma.toString());						
                
    }

    
    public void cargarPaginaInsertarCodigoAnterior() throws Exception{
			traza("*********** Entre a cargarPaginaInsertarCodigoAnterior - LPMantenimientoCodigosAnteriores");
        traza("Paso antes de pagina");  
				pagina("contenido_clientes_anteriores_insertar");
        traza("Paso despues de pagina");  
        this.getFormatosValidaciones();
        asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
			
        DTOBelcorp dtoe = new DTOBelcorp();
        
        
                    
        Long pais = UtilidadesSession.getPais(this); 
        Long idioma = UtilidadesSession.getIdioma(this);

        dtoe.setOidPais(pais);
        dtoe.setOidIdioma(idioma);

        asignarAtributo("VAR", "hIdioma", "valor",idioma.toString());
        asignarAtributo("VAR", "hPais", "valor", pais.toString());
        
        traza("Paso 1");        
				//	Crear una lista ComposerViewElementList
				ComposerViewElementList lista = new ComposerViewElementList();

				ComposerViewElement elem1 = new ComposerViewElement();
				elem1.setIDBusiness("MENConsultaPaises");
				elem1.setDTOE(dtoe);
				lista.addViewElement(elem1);
        
        traza("Paso 2");        
        
				 // Invocar al  subsistema GestorCargaPantalla
				 ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		       conector.ejecucion();
		       DruidaConector resultados = conector.getConector();
           
           traza("Paso 3");        
            
           asignar("COMBO", "cbPaisNuevo", resultados, "MENConsultaPaises");                
           
           traza("Paso 4");        
                
           asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);								
            
           traza("Paso 5");         
            
	         if(opcionMenu.equals("InsertarCodigoAnterior")){
              traza("Paso 6");        
     					getConfiguracionMenu("LPMantenimientoCodigosAnteriores","insertar");
             } 
             
           
          traza("opcionMenu:CargaInsertar---- " + opcionMenu);
          
          if(opcionMenu.equals("ConsultarCodigoAnterior")){
                    
             getConfiguracionMenu("LPMantenimientoCodigosAnteriores","detalle");
             this.asignarAtributoPagina("cod", "01050");
              
             asignarAtributo("VAR", "habilitaBtnGuardar", "valor","N"); 
             asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
             asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");

          }			

          if(opcionMenu.equals("EliminarCodigoAnterior")){
        
                  getConfiguracionMenu("LPMantenimientoCodigosAnteriores","detalle");
                  this.asignarAtributoPagina("cod", "01050");
	             asignarAtributo("VAR", "habilitaBtnGuardar", "valor","N"); 
	             asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
	             asignarAtributo("VAR", "habilitaBtnModificar", "valor","N");
        
          }
              
          if(opcionMenu.equals("ModificarCodigoAnterior")){
             
             traza("opcionMenu del Modificar : " + opcionMenu);
             
             getConfiguracionMenu("LPMantenimientoCodigosAnteriores","modificar");
             this.asignarAtributoPagina("cod", "01048");
             
             asignarAtributo("VAR", "habilitaBtnEliminar", "valor","N");
             asignarAtributo("VAR", "habilitaBtnDetalle", "valor","N");
          }
          
          traza("Paso 9");            		
          asignarAtributo("VAR", "accion", "valor",accion);
          asignarAtributo("VAR", "opcionMenu", "valor",opcionMenu);
          traza("Paso 10");          
          asignarAtributo("VAR", "hpais", "valor", pais.toString());
          asignarAtributo("VAR", "hidioma", "valor", idioma.toString());			
		
    			traza("*********** Salida de cargarPGInsertarCodigosAnteriores - LPMantenimientoCodigosAnteriores");
    }	


		public void guardar()throws Exception{
		traza("*** Entrada - LPMantenimientoCodigosAnteriores  - guardar ***");
      
      this.pagina("salidaGenerica");
      
      this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");      
      
      asignarAtributo("VAR","ejecutar","valor","guardoCorrectamente('" + opcionMenu + "')");
      asignarAtributo("VAR","ejecutarError","valor","noPudoGuardar()");
      
			DTODataCodigoAnterior dtoDataCA = crearDTODataCodigoAnterior(); 

			MareBusinessID businessID = new MareBusinessID("MAEGuardarCodigoAnterior");
		
			Vector parametros = new Vector();
			parametros.add(dtoDataCA);
			parametros.add(businessID);

			conectar("ConectorGuardarCodigoAnterior", parametros);
			
			if(opcionMenu.equals("ModificarCodigoAnterior")){
					asignarAtributo("VAR", "cerrar", "valor", "S");
          
			}
      
      traza("*** Salida - LPMantenimientoCodigosAnteriores  - guardar ***");
		}
    
    /**
		Recupera los valores de la página PGInsertarCodigosAnteriores y los guarda 
		en un DTODataCodigoAnterior 
		*/
		public DTODataCodigoAnterior crearDTODataCodigoAnterior() throws Exception{
		traza("*** Entrada - LPMantenimientoCodigosAnteriores  - crearDTODataCodigoAnterior ***");
		
			DTODataCodigoAnterior dtoDataCA = new DTODataCodigoAnterior(); 
      
			OID_CODI_CLIE_ANTE = conectorParametroLimpia("OID_CODI_CLIE_ANTE", "", true);

			traza("*********** OID_CODI_CLIE_ANTE " + OID_CODI_CLIE_ANTE);
		
    
			if (opcionMenu.equals("InsertarCodigoAnterior")) {				
				dtoDataCA.setOidCodigoAnterior(null);
        traza("*********** Seteando oid a null");
			}
			else {
				traza("*********** Seteando oid");
				
				if(!OID_CODI_CLIE_ANTE.equals("")){					
          dtoDataCA.setOidCodigoAnterior(Long.valueOf(OID_CODI_CLIE_ANTE));
				}				
			}
      
      traza("*********** Antes del OID con el conectorParametroLimpia");      
      OID_CLIE = conectorParametroLimpia("hoidCliente", "", true);
      
      traza("*********** despues del OID con el conectorParametroLimpia" + OID_CLIE);      
      if (!OID_CLIE.equals("")){
          dtoDataCA.setOidCliente(Long.valueOf(OID_CLIE));
      }
      traza("*********** OID_CLIE " + OID_CLIE);
      
      
      CLIENTENUEVO = conectorParametroLimpia("CLIENTENUEVO", "", true);      
      dtoDataCA.setCodigoClienteNuevo(CLIENTENUEVO.equals("") ? null: CLIENTENUEVO);
      traza("*********** CLIENTENUEVO " + CLIENTENUEVO);
      
      CLIENTEANTI  = conectorParametroLimpia("CLIENTEANTI", "", true);          
      dtoDataCA.setCodigoClienteAntiguo(CLIENTEANTI.equals("") ? null: CLIENTEANTI);
      traza("*********** CLIENTEANTI " + CLIENTEANTI);
      
      SISTEMA = conectorParametroLimpia("SISTEMA", "", true);                
      dtoDataCA.setSistemaProcedencia(SISTEMA.equals("") ? null: SISTEMA);
      traza("*********** SISTEMA " + SISTEMA);
      
      traza("*********** Antes del PAIS_OID_PAIS con el conectorParametroLimpia");       
      PAIS_OID_PAIS = conectorParametroLimpia("PAIS_OID_PAIS", "", true);      
      traza("*********** despues del PAIS_OID_PAIS con el conectorParametroLimpia" + PAIS_OID_PAIS);      
      dtoDataCA.setOidPaiscmb(Long.valueOf(PAIS_OID_PAIS));
      
      dtoDataCA.setOidPais(UtilidadesSession.getPais(this));      
      
      
			traza("*** Salida - LPMantenimientoCodigosAnteriores  - crearDTODataCodigoAnterior ***");
      return dtoDataCA;
		}
    
    
    
    		
		public void modificarCodigosAnteriores() throws Exception{
		traza("*** Entrada - LPMantenimientoCodigosAnteriores  - modificarCodigosAnteriores ***");
		
       	pagina("contenido_clientes_anteriores_insertar");
              this.getFormatosValidaciones();
        
        			cargarPaginaInsertarCodigoAnterior();
        			CLIENTENUEVO = conectorParametroLimpia("CLIENTENUEVO", "", true);
              CLIENTEANTI = conectorParametroLimpia("CLIENTEANTI", "", true);
        			SISTEMA = conectorParametroLimpia("SISTEMA", "", true);
        			PAIS_OID_PAIS = conectorParametroLimpia("PAIS_OID_PAIS", "", true);
        			OID_CLIE = conectorParametroLimpia("OID_CLIE", "", true);
        			OID_CODI_CLIE_ANTE = conectorParametroLimpia("OID_CODI_CLIE_ANTE", "", true); 
              
              
              //Asigno los campos
              asignarAtributo("VAR", "CLIENTENUEVO", "valor", CLIENTENUEVO);
              asignarAtributo("VAR", "CLIENTEANTI", "valor", CLIENTEANTI);
              asignarAtributo("VAR", "SISTEMA", "valor", SISTEMA);
              asignarAtributo("VAR", "PAIS_OID_PAIS", "valor", PAIS_OID_PAIS);
              asignarAtributo("VAR", "OID_CLIE", "valor", OID_CLIE);
              asignarAtributo("VAR", "hoidCliente", "valor", OID_CLIE);
              asignarAtributo("VAR", "OID_CODI_CLIE_ANTE", "valor", OID_CODI_CLIE_ANTE);
              
              //Deshabilita los campos para el detalle
              //asignarAtributoElemento("cbPaisNuevo", "disabled", "S");
              //asignarAtributoElemento("txtClienteNuevo", "disabled", "S");
              //asignarAtributoElemento("txtClienteAntiguo", "disabled", "S");
              //asignarAtributoElemento("txtSistemaProcedencia", "disabled", "S");
		
		traza("*** Salida - LPMantenimientoCodigosAnteriores  - modificarCodigosAnteriores ***");
    }

		public void detalleCodigosAnteriores() throws Exception{
		traza("*********** Entre a detalleCodigosAnteriores - LPMantenimientoCodigosAnteriores");
        
       	//pagina("contenido_clientes_anteriores_insertar");
         //     this.getFormatosValidaciones();
        
        			cargarPaginaInsertarCodigoAnterior();
        			CLIENTENUEVO = conectorParametroLimpia("CLIENTENUEVO", "", true);
              CLIENTEANTI = conectorParametroLimpia("CLIENTEANTI", "", true);
        			SISTEMA = conectorParametroLimpia("SISTEMA", "", true);
        			PAIS_OID_PAIS = conectorParametroLimpia("PAIS_OID_PAIS", "", true);
        			OID_CLIE = conectorParametroLimpia("OID_CLIE", "", true);
        			OID_CODI_CLIE_ANTE = conectorParametroLimpia("OID_CODI_CLIE_ANTE", "", true); 
              
              
     		traza("*********** CLIENTENUEVO " + CLIENTENUEVO);
			traza("*********** CLIENTEANTI " + CLIENTEANTI);
			traza("*********** SISTEMA " +  SISTEMA);
			traza("*********** PAIS_OID_PAIS " + PAIS_OID_PAIS);
			traza("*********** OID_CLIE " + OID_CLIE);
			traza("*********** OID_CODI_CLIE_ANTE " + OID_CODI_CLIE_ANTE);

              //Asigno los campos
              asignarAtributo("VAR", "CLIENTENUEVO", "valor", CLIENTENUEVO);
              asignarAtributo("VAR", "CLIENTEANTI", "valor", CLIENTEANTI);
              asignarAtributo("VAR", "SISTEMA", "valor", SISTEMA);
              asignarAtributo("VAR", "PAIS_OID_PAIS", "valor", PAIS_OID_PAIS);
              asignarAtributo("VAR", "OID_CLIE", "valor", OID_CLIE);
              asignarAtributo("VAR", "OID_CODI_CLIE_ANTE", "valor", OID_CODI_CLIE_ANTE);
              
              //Deshabilita los campos para el detalle
              asignarAtributoElemento("cbPaisNuevo", "disabled", "S");
              asignarAtributoElemento("txtClienteNuevo", "disabled", "S");
              asignarAtributoElemento("txtClienteAntiguo", "disabled", "S");
              asignarAtributoElemento("txtSistemaProcedencia", "disabled", "S");
              //asignarAtributoElemento("iconBuscar.gif", "disabled", "S");
              
              traza("*********** Salida de detalleCodigosAnteriores - LPMantenimientoCodigosAnteriores");		
      }
  
        
    
}

  
  
  
  
  
