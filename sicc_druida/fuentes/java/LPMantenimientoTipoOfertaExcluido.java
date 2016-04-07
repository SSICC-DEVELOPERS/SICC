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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.text.SimpleDateFormat;
import java.util.Vector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPMantenimientoTipoOfertaExcluido extends LPSICCBase {
     
         
        private String accion;
        private String opcionMenu;
        
        private Long pais;
        private Long idioma;

        public void inicio() throws Exception {}
  
       /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         * 
         * -> Si accion == "" -> llamar al método inicializar() 
         * -> en otro caso Si accion == "guardar" -> llamar al método guardar() 
         * -> en otro caso Si accion == "modificar" -> llamar al método modificarTipoOfertaExcluido() 
         */
        public void ejecucion() throws Exception {

         rastreo();
         setTrazaFichero();

         traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - ejecucion ***");

          accion = conectorParametroLimpia("accion", "", true);
          opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
          
          idioma = UtilidadesSession.getIdioma(this);
          pais = UtilidadesSession.getPais(this); 
          
          try {
               if (accion.equalsIgnoreCase("")) {
                   inicializar();
               } else if (accion.equalsIgnoreCase("modificar")) {
                   modificarTipoOfertaExcluido();
               } else if (accion.equalsIgnoreCase("guardar")) {
                   guardar();
               }

               this.getFormatosValidaciones();

          } catch (Exception e)  {
               logStackTrace(e);
               lanzarPaginaError(e);
          }

         traza("*** Salida - LPMantenimientoTipoOfertaExcluido - ejecucion ***");
    }

       /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         * 
         *
         * -> Si opcionMenu == "InsertarTipoOfertaExcluido" 
         *     -> llamar al método cargarPGInsertarTipoOfertaExcluido() 
         * -> sino Si opcionMenu == "ModificarTipoOfertaExcluido" o 
         *            opcionMenu == "ConsultarTipoOfertaExcluido" o 
         *            opcionMenu == "EliminarTipoOfertaExcluido" 
         *     -> llamar al método cargarPGConsultarTipoOfertaExcluido() 
         */        
         private void inicializar() throws Exception {
         traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - inicializar ***");        
       
             if (opcionMenu.equalsIgnoreCase("InsertarTipoOfertaExcluido")) {
                        cargarPGInsertarTipoOfertaExcluido();          
             } else if ((opcionMenu.equalsIgnoreCase("ConsultarTipoOfertaExcluido")) ||
                        (opcionMenu.equalsIgnoreCase("ModificarTipoOfertaExcluido")) ||
                        (opcionMenu.equalsIgnoreCase("EliminarTipoOfertaExcluido"))) {
                        cargarPGConsultarTipoOfertaExcluido();
             }
         traza("*** Salida - LPMantenimientoTipoOfertaExcluido - inicializar ***");        
         }



       /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         *
         *  -> Crear un DTOBelcorp dtoe con:  pais = Pais activo,  idioma = Idioma del usuario 
         *  -> Crear una lista ComposerViewElementList 
         *  
         *  -> Obtenemos los canales: 
         *  Crear un elemento de tipo ComposerViewElement() 
         *  elem.IDBusiness="SEGObtenerCanalesSinFiltro"; 
         *  elem.DTOE= dtoe; 
         *  Añadir el elemento a la lista 
         *  
         *  -> Invocar al subsistema GestorCargaPantalla
         *  
         * ->  Asignar los combos: 
         *     - cbCanal 
         *     
         * ->  Ocultar los botones btModificar y btEliminar 
        /* ->  Mostrar la página PGConsultarTipoOfertaExcluido pasándole además: 
                - accion 
                -opcionMenu
         */  

        private void cargarPGConsultarTipoOfertaExcluido()throws Exception {
                traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - cargarPGConsultarTipoOfertaExcluido ***");
                
                pagina("contenido_tipos_oferta_excluidos_consultar");
                
                getConfiguracionMenu(getClass().getName(), "consultar");
                
                if (opcionMenu.equalsIgnoreCase("ConsultarTipoOfertaExcluido")) {
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.query.label");                    
                }                
                else if (opcionMenu.equalsIgnoreCase("ModificarTipoOfertaExcluido")){
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.update.label");                    
                }
                else if (opcionMenu.equalsIgnoreCase("EliminarTipoOfertaExcluido")){
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.remove.label");                    
                }                

                //Carga variables pagina
                asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
                asignarAtributo("VAR", "accion", "valor", accion);
                asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                asignarAtributo("VAR", "pais", "valor", pais.toString());
                

                //Carga combo canal
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(idioma);
                dtoBelcorp.setOidPais(pais);
                String[] idBusiness = new String[] {"SEGObtenerCanalesSinFiltro"};
                String[] comboBox = new String[] {"cbCanal"};
                cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
              
                traza("*** Salida - LPMantenimientoTipoOfertaExcluido - cargarPGConsultarTipoOfertaExcluido ***");              
        }

 
        /**
        * @author Guido Pons
        * @date 29/08/2006
        * @throws Exception
        *
        * Si accion != "modificar"
        *   -->     Crear un DTOBelcorp dtoe con:
        *                   - pais = Pais activo
        *                   - idioma = Idioma del usuario
        *   -->     Crear una lista ComposerViewElementList
        *   
        *   //Obtenemos los canales
        *   -->    Crear un elemento de tipo ComposerViewElement()
        *   -->     elem.IDBusiness="SEGObtenerCanalesSinFiltro";
        *   -->    elem.DTOE= dtoe;
        *   -->    Añadir el elemento a la lista
        *  //Obtenemos los paises
        *   -->    Crear un elemento de tipo ComposerViewElement()
        *   -->    elem.IDBusiness="SEGRecuperarPaises";
        *   -->    elem.DTOE= dtoe;
        *   -->    Añadir el elemento a la lista

        *   -->    Invocar al  subsistema GestorCargaPantalla
        *   -->    Asignar los combos:
        *            - cbCanal
        *            - cbPais
        *
        * Sino Si accion == "modificar"
        *   -->        Crear un DTOBelcorp dtoe con:
        *             - pais = Pais activo
        *             - idioma = Idioma del usuario
        *    
        *   -->        Crear una lista ComposerViewElementList
        *   
        *         //Obtenemos los paises
        *   -->          Crear un elemento de tipo ComposerViewElement()
        *   -->          elem.IDBusiness="SEGRecuperarPaises";
        *   -->          elem.DTOE= dtoe;
        *   -->          Añadir el elemento a la lista
        *   
        *   -->          Invocar al  subsistema GestorCargaPantalla
        *   -->          Asignar los combos:
        *                    - cbPais
        *    
        *   -->          Cargar los combos cbCanal y cbTipoOferta de la página PGInsertarTipoOfertaExcluido, 
        *   -->          con las listas cargadas en los combos de la página PGConsultarTipoOfertaExcluido
        *   -->          Deshabilita cbCanal, cbTipoOferta y fechaDesde
        *Fin Sino
        *
        *   --> Se muestra y deshabilita el país
        *   --> Asignar a la variable oidPais de PGInsertarTipoOfertaExcluido el oid del Pais activo
        *   --> Deshabilitar el combo cbPais
        *
        *   Si opcionMenu == "ConsultarTipoOfertaExcluido" 
        *   -->  Ocultar el boton btGuardar
        *   -->  Mostrar la página PGInsertarTipoOfertaExcluido pasándole además:
        *   - accion
        *   - opcionMenu
        */

        private void cargarPGInsertarTipoOfertaExcluido() throws Exception {
                traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - cargarPGInsertarTipoOfertaExcluido ***");

                pagina("contenido_tipos_oferta_excluidos_insertar");
                        
                asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
                asignarAtributo("VAR", "accion", "valor", accion);
                asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                asignarAtributo("VAR", "pais", "valor", pais.toString());

                //Carga combos canal y pais
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(idioma);
                dtoBelcorp.setOidPais(pais);
                String[] idBusiness = new String[] {"SEGObtenerCanalesSinFiltro","SEGRecuperarPaises" };
                String[] comboBox = new String[] {"cbCanal", "cbPais"};
                cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);                

                if (opcionMenu.equalsIgnoreCase("InsertarTipoOfertaExcluido")){
                    getConfiguracionMenu(getClass().getName(), "insertar");
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.create.label");                    
                }
                
                if  ( opcionMenu.equalsIgnoreCase("ConsultarTipoOfertaExcluido") 
                    || opcionMenu.equalsIgnoreCase("EliminarTipoOfertaExcluido")) {
                     
                    getConfiguracionMenu(getClass().getName(), "detalle");
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.query.label");                    
                }                
                else if (opcionMenu.equalsIgnoreCase("ModificarTipoOfertaExcluido")){
                    getConfiguracionMenu(getClass().getName(), "modificar");
                    asignarAtributoPagina("cod", "FacTipoOfertExclu.update.label");                    
                }
                
                
                traza("*** Salida - LPMantenimientoTipoOfertaExcluido - cargarPGInsertarTipoOfertaExcluido ***");            
        } 


        
        /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         *
         * -> DTOTipoOfertaExcluido = crearDTOTipoOfertaExcluido() 
         * -> Crea idBusiness = "FACActualizarTipoOfertaExcluido" 
         * -> Invoca a ConectorActualizarTipoOfertaExcluido con el idBusiness y el DTOTipoOfertaExcluido 
         */
         
         private void guardar() throws Exception {
              traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - guardar ***");

              pagina("salidaGenerica");

              asignar("VAR", "ejecutar", "guardarCorrecto()");
              asignar("VAR", "ejecutarError", "guardarError()");
              
              DTOTipoOfertaExcluido dto = crearDTOTipoOfertaExcluido();

              MareBusinessID id = new MareBusinessID("FACActualizarTipoOfertaExcluido");
              Vector parameters = new Vector();
              parameters.add(dto);
              parameters.add(id);

              DruidaConector conector = conectar("ConectorActualizarTipoOfertaExcluido", parameters);			

              traza("*** Salida - LPMantenimientoTipoOfertaExcluido - guardar ***");
         }

        

        /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         *
         * //Recupera los valores de la página PGInsertarTipoOfertaExcluido y los guarda en un DTOTipoOfertaExcluido 
         * -> Crear un dto del tipo DTOTipoOfertaExcluido dto con los siguientes valores: 
         * 
         * -> Si opcionMenu == "InsertarTipoOfertaExcluido" 
         *      -> dto.oid = null 
         * -> en otro caso 
         *       -> dto.oid = oidTipoOfertaExcluido // variable de la página PGInsertarTipoOfertaExcluido 
         * -> dto.oidPais = el de sesion 
         * -> dto.oidCanal = oid del canal seleccionado en cbCanal 
         * -> dto.oidTipoOferta = oid del tipo de oferta seleccionado en cbTipoOferta 
         * -> dto.fechaDesde = valor de fechaDesde de la pagina 
         * -> dto.fechaHasta = valor de fechaHasta de la pagina 
         * -> Devuelve el DTOTipoOfertaExcluido dto
         */
         private DTOTipoOfertaExcluido crearDTOTipoOfertaExcluido() throws Exception {
             traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - crearDTOTipoOfertaExcluido ***");

              DTOTipoOfertaExcluido dto = new DTOTipoOfertaExcluido();
              if (opcionMenu.equalsIgnoreCase("InsertarTipoOfertaExcluido")) {
                  dto.setOid(null);
              } 
              else {
                String oidTipoOfertaExc = conectorParametroLimpia("oidTipoOfertaExcluida", "", true);
                dto.setOid(new Long(oidTipoOfertaExc));
              }                  
              String fdesde = conectorParametroLimpia("txtFecDesd", "", true);
              String fhasta = conectorParametroLimpia("txtFecHast", "", true);
              String canal = conectorParametroLimpia("cbCanal", "", true);
              String tipoOferta = conectorParametroLimpia("cbTipoOferta", "", true);
              
              dto.setOidPais(pais);
              dto.setOidIdioma(idioma);
              dto.setOidTipoOferta(new Long(tipoOferta));
              dto.setOidCanal(new Long(canal));

              
              SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
              dto.setFechaDesde(formatter.parse(fdesde));
              dto.setFechaHasta(formatter.parse(fhasta));
              
              traza("*** dto : " + dto);                  
              traza("*** Salida - LPMantenimientoTipoOfertaExcluido - crearDTOTipoOfertaExcluido ***");                  
              return dto;
         }          

        /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         *
         * -> Llamar al método cargarPGInsertarTipoOfertaExcluido() 
         * -> Llamar al método mostrarDatosTipoOfertaExcluido() 
         */
         private void modificarTipoOfertaExcluido() throws Exception  {
                traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - modificarTipoOfertaExcluido ***");

                cargarPGInsertarTipoOfertaExcluido();
                mostrarDatosTipoOfertaExcluido();
                
                traza("*** Salida - LPMantenimientoTipoOfertaExcluido - modificarTipoOfertaExcluido ***");
         }

         
        /**
         * @author Guido Pons
         * @date 29/08/2006
         * @throws Exception
         *
         * -> Muestra en la página PGInsertarTipoOfertaExcluido los datos del elemento seleccionado 
         * -> Cargar en la página PGInsertarTipoOfertaExcluido los siguientes datos: 
         * oidTipoOfertaExcluido = oid del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarTipoOfertaExcluido 
         * oidCanal = oidCanal del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarTipoOfertaExcluido 
         * oidTipoOferta = oidTipoOferta del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarTipoOfertaExcluido 
         * fechaDesde = fechaDesde del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarTipoOfertaExcluido 
         * fechaHasta = fechaHasta del elemento seleccionado en la lista resultado "lstResultado" de la pagina PGConsultarTipoOfertaExcluido 
         */
         private void mostrarDatosTipoOfertaExcluido() throws Exception {
               traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - mostrarDatosTipoOfertaExcluido ***");

               // Obtengo los datos de la ventana llamante
               String oidTipoOfertaExc = conectorParametroLimpia("oidTipoOfertaExc", "", true);
               String fdesde = conectorParametroLimpia("fdesde", "", true);
               String fhasta = conectorParametroLimpia("fhasta", "", true);
               String oidCanal = conectorParametroLimpia("oidCanal", "", true);
               String oidTipoOferta = conectorParametroLimpia("oidTipoOferta", "", true);

               traza("*** oidTipoOfertaExc" + oidTipoOfertaExc);
               traza("*** fdesde" + fdesde);
               traza("*** fhasta" + fhasta);
               traza("*** oidCanal" + oidCanal);
               traza("*** oidTipoOferta" + oidTipoOferta);

               // Cargo la info para llenar los combos
               asignarAtributo("VAR", "oidTipoOfertaExcluida", "valor", oidTipoOfertaExc);
               asignarAtributo("VAR", "hCbanal", "valor", oidCanal);
               asignarAtributo("VAR", "hCbTipoOferta", "valor", oidTipoOferta);               
               asignarAtributo("CTEXTO", "txtFecDesd", "valor", fdesde);
               asignarAtributo("CTEXTO", "txtFecHast", "valor", fhasta);
     
               traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - mostrarDatosTipoOfertaExcluido ***");     
         }     

/**
 * ******************************
 * 
 *      Funciones de soporte    *
 *
 ********************************
 */

         private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
                traza("*** Entrada - LPMantenimientoTipoOfertaExcluido - cargarCombos ***");
        
                ComposerViewElementList list = new ComposerViewElementList();
                ComposerViewElement element = null;
        
                for (int i = 0; i < idBusiness.length; i++) { 
                    element = new ComposerViewElement(); 
                    element.setIDBusiness(idBusiness[i]);
                    traza("*** idBusiness[i]: , " + idBusiness[i]);
                    element.setDTOE(dto);
                    list.addViewElement(element);
                }
                
                traza("***dto : , " + dto);
        
                // Obtener un RowSet que contiene los datos solicitados por list.
                ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
               
                ccv.ejecucion();
                DruidaConector dc = ccv.getConector();
        
                // Asignar los datos obtenidos a los combos.
                if (selected != null && column != null) {
                    for (int i = 0; i < comboBox.length; i++) {
                        if (selected[i] != null && column[i] != null) {
                            asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
                        } else {
                            asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                        }
                    }
                } else {
                    for(int i = 0; i < comboBox.length; i++) {
                        asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                    }
                }
        
                traza("*** Salida - LPMantenimientoTipoOfertaExcluido - cargarCombos ***");
         }   
         
         private void logStackTrace(Throwable e) throws Exception {
             traza("Se produjo la excepción: " + e.getMessage());
    
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream print = new PrintStream(out);
             e.printStackTrace(print);
    
             traza("Stack Trace: " + out);
        }
}
