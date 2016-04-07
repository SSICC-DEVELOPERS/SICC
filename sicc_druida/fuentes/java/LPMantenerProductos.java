import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOProducto;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.inc.DTOProdu;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.util.Vector;

public class LPMantenerProductos extends LPIncentivos{
	private String ocultarPestanyas;

    public LPMantenerProductos() { super();	}

    public void inicio() throws Exception { }

    public void ejecucion() throws Exception {
		try {
	        accion = this.conectorParametroLimpia("accion", "", true);      
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            ocultarPestanyas = this.conectorParametroLimpia("ocultarPestanyas", "", true);
            this.setTrazaFichero();
            traza(" ********* Entrando a LPMantenerProductos **********");          
            traza("--- Accion: " + accion);
            traza("--- opcionMenu: " + opcionMenu);

            this.obtenerFlagsPestanyas();
                           
            if (accion.equals("") ) {
	            if ("nueva version".equals(opcionMenu)) {
	                // obtener DTOConcursoBufferSS
                    DTOConcurso dtoConcurso = 
					(DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
                    traza(" dtoConcurso : " + dtoConcurso);
                    this.setConcurso(dtoConcurso);
                    traza("Inicial dtoProductosValidosAuxSS"+
					(DTOProducto) this.conectorParametroSesion("dtoProductosValidosAuxSS"));
                 } 
                 // Inc. 17557
                 this.cargarPantalla(ConstantesINC.IND_GRUPO_PRODUCTO_0);
            }
			else if (accion.equals("cargarProductosGrupo1") ) {
	            // Inc. 17557
                this.cargarPantalla(ConstantesINC.IND_GRUPO_PRODUCTO_1);
            }
			else if (accion.equals("mantener") ) {
	            this.seleccionarCargarPantalla();
            }
			else if (accion.equals("almacenar") ) {
	            traza("Antes de almacenar dtoProductosValidosAuxSS: "+
				(DTOProducto) this.conectorParametroSesion("dtoProductosValidosAuxSS"));
                this.almacenar(); 
                traza("Despues de almacenar dtoProductosValidosAuxSS: "+
				(DTOProducto) this.conectorParametroSesion("dtoProductosValidosAuxSS"));
            }
			else if (accion.equals("guardar") ) {
	            // No hace falta almacenar, ya que el almacenar() se llamó al darle
                // Aceptar dentro de la Modal.
                traza("Antes de guardar dtoProductosValidosAuxSS: "+
				(DTOProducto) this.conectorParametroSesion("dtoProductosValidosAuxSS"));
                this.guardar();
            }
			else if (accion.equals("redirigir") ) {
	            this.redirigir();
            }
                      
            if(opcionMenu.equals("Crear concurso")){
		        asignarAtributoPagina("cod", "0491");
            }
            else  if(opcionMenu.equals("Consultar Concurso")){
			    asignarAtributoPagina("cod", "0493");
            }
            else if(opcionMenu.equals("Modificar Concurso")){
				asignarAtributoPagina("cod", "0486");
            } 
        }
		catch (Exception ex) {
			ex.printStackTrace();
            this.lanzarPaginaError(ex);
        }         
    }

// -------------------------------------------------------------------------------------------------      
    private void cargarPantalla(Integer indGrupo) throws Exception { 
      traza("cargarPantalla(Integer indGrupo)");                 
             
      DTOConcurso dtoConcurso = null;
      
      opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);             
      this.pagina("contenido_productos_mantener");
      this.getFormatosValidaciones();
      
      if ("nueva version".equals(opcionMenu)) {
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
           this.getConfiguracionMenu("LPMantenerProductos", "nuevaVersion");                          
      }
	  else {
           dtoConcurso = this.getConcurso();
           this.getConfiguracionMenu("LPMantenerProductos", "");           
      }

      
      this.asignarAtributoPagina("cod", "0491");
      this.cargarFlagsPestanyas();

      traza("ocultarPestanyas en cargarPantalla: " + ocultarPestanyas);

      //En caso de que la pagina se abra en una modal (pestanya calificacion),
      //no se muestran las pestanyas de esta pagina.
      this.asignarAtributo("VAR", "ocultarPestanyas", "valor", ocultarPestanyas);
      
      DTOTipoProducto dtoTipo = new DTOTipoProducto();

      traza(" ********* dtoConcurso 1 " + dtoConcurso);
     
      
      /* Habiendo tomado el DTOConcurso de sesion, lo setea en sesión bajo el nombre
        * "dtoConcursoBufferSS" para poder usarlo en las modales.
        */
      
      dtoTipo.setOidPais(dtoConcurso.getOidPais());
      dtoTipo.setOidIdioma(dtoConcurso.getOidIdioma());
      dtoTipo.setIndGrupoProducto(indGrupo);
      dtoTipo.setOidPlantilla( dtoConcurso.getPlantilla().getOidPlantilla() );
      
      ComposerViewElementList cViewList = new ComposerViewElementList();
      ComposerViewElement cElement = new ComposerViewElement();
      cElement.setIDBusiness("INCObtenerTiposProducto");
      cElement.setDTOE(dtoTipo);
      
      cViewList.addViewElement(cElement);
      
      ConectorComposerView cComposerView = new ConectorComposerView(cViewList, this.getRequest());
      cComposerView.ejecucion();
      DruidaConector con = cComposerView.getConector();
      this.asignar("COMBO", "cbProductos", con, "INCObtenerTiposProducto");

      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);            
   }
    
// -------------------------------------------------------------------------------------------------      
    public void cargarPantalla()  { return; }
    
// ---------------------------------------------------------------------------------------------------------------    
    private void seleccionarCargarPantalla() throws Exception {
      // Nota: Siempre tienen que venir con valores, ya que se valida desde la pantalla. 
      String descProducto= this.conectorParametroLimpia("descCombo", "", true);
      String oidProducto = this.conectorParametroLimpia("oidCombo", "", true);
      String sEsRecarga = this.conectorParametroLimpia("yaEntroAModal", "", true);
      
      traza("Recarga? " + sEsRecarga);
      traza("descProducto: " + descProducto);
      traza("oidProducto: " + oidProducto);
                           
      if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_VALIDOS");
           this.cargarPantallaProductosValidos();
      } else if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_EXCLUIDOS");         
           this.cargarPantallaProductosExcluidos();
      } else if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_BONIFICADOS"); 
           this.cargarPantallaProductosBonificados();
      } else if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_EXIGIDOS");
           this.cargarPantallaProductosExigidos();
      } else if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_A_CALIFICAR.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_A_CALIFICAR");
           this.cargarPantallaProductosACalificar();
      } else if (Long.parseLong(oidProducto) == ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION.longValue() )
      {
           traza("OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION");
           this.cargarPantallaProductosExcluidosCalificacion();
      }
      
    }
    
    // inc. 20335
     /* DT: jpollio  Implantacion de cambio: idedough
     
     3. Se modifica LPMantenerProductos.cargarPantallaProductosValidos() : void

     ******************AGREGADO*************************
     Si opcionMenu = "nueva versión" {
         Se recupera de sesion dtoConcurso del tipo DTOConcurso
         Se deben ocultar las pestñas de la página
     }else { // si se definen productos para la definición del concurso
     ********************************************************
        dtoConcurso = getConcurso() 
     ***************AGREGADO*******************
     }
     ******************************************

     Crear un DTOBelcorp dtob con:
      - pais = dtoConcurso.pais
      - idioma = dtoConcurso.idioma

     Crear un DTOPeriodo dtop con:
      - pais = dtoConcurso.pais
      - marca = dtoConcurso.paramGenerales.oidMarca
      - canal = dtoConcurso.paramGenerales.oidCanal

     Crear una lista ComposerViewElementList

     Crear un dtoOid del tipo DTOOID con:
      - pais = dtoConcurso.pais
      - idioma = dtoConcurso.idioma
      - oid = dtoConcurso.paramGenerales.oidMarca

    //Obtenemos las marcas de productos
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="SEGRecuperarMarcasProductoMP";
     elem.DTOE=dtoOid;
     Añadir el elemento a la lista

    //Obtenemos las unidades de negocio
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="MAEObtenerUnidadesNegocioPorPais";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

    //Obtenemos negocio
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="MAEObtenerNegocioPorPais";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

    //Obtenemos supergenérico
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="MAEObtenerSuperGenericosPorPais";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

    //Obtenemos genérico
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="MAEObtenerGenericosPorPais";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

    Crear un dtoOid2 del tipo DTOOID con:
      - pais = dtoConcurso.pais
      - idioma = dtoConcurso.idioma
      - oid = dtoConcurso.paramGenerales.oidCanal

    //Obtenemos los tipos de oferta
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="PREObtenerTiposOfertaPorCanal";
     elem.DTOE=dtoOid2;
     Añadir el elemento a la lista

    //Obtenemos los ciclos de vida
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="PREObtenerCiclosVida";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

     Invocar al  subsistema GestorCargaPantalla

     Asigna las combos:
        cbMarcaProducto
        cbUnidadNegocio
        cbNegocio
        cbSupergenerico
        cbGenerico
        cbTipoOferta
        cbCicloVida
     
        Asignar al label lbProductos = desTipoProducto
        Envia a la página la variable oculta oidTipoProducto

        Seleccionar la pestaña pestanyaBloqueNegocio   // por defecto se selecciona esta pestanya 
        Se muestra la capa "bloque negocio" y se ocultan las capas "bloque  oferta - producto" y "bloque producto" 
        
        Deshabilita los siguientes campos:
          cbPeriodoDesde
          cbPeriodoHasta
          txtPuntosUnidad
          txtFactorMultiplicidad
          txtUnidadesExigidas
          txtMontoExigido
          txtPuntosExigidos
    
         Si dtoConcurso.indProductosValidos //Si el indicador de que se ha rellenado ya la pestaña Productos/ProductosVálidos está a true, cargo la pantalla con la información del dtoConcurso
         {
            Asignar valores a la página:
             
              - oidTipoProducto = dtoConcurso.productosValidos.oidTipoProducto    
              - lstProductos = dtoConcurso.productosValidos.lstProductos
              - chkComunicacion = dtoConcurso.productosValidos.indComunicacion //si es 1 se selecciona el check
              - txtCodigoMensaje = dtoConcurso.productosValidos.codigoMensaje
         }

         Si opcionMenu = "Consultar Concurso"
            Deshabilitar todos los campos de la PGMantenerProductosDetalle

         Mostrar la PGMantenerProductosDetalle
         Enviar también a la página:
            cteOidTipoProductoValido = ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS
            accion
            opcionMenu
         */

// ---------------------------------------------------------------------------------------------------------------    
    private void cargarPantallaProductosValidos() throws Exception
    {
         traza("Entra a cargarPantallaProductosValidos()");
         
         String descProducto= this.conectorParametroLimpia("descCombo", "", true);
         String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
         opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);                                             
         
         traza("descProducto: " + descProducto);
         traza("oidTipoProducto: " + oidTipoProducto);         
         
         this.pagina("contenido_productos_mantener_detalle");
         this.getConfiguracionMenu("LPMantenerProductos", "");
         this.asignarAtributoPagina("cod", "0491");
         
         
         this.getFormatosValidaciones();
         
         DruidaConector con = this.cargaPantallaGeneral();

         // inc. 20335
         //******************AGREGADO********************
         DTOConcurso dtoConcurso = null;
         if ("nueva version".equals(opcionMenu)) {
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
         } else {
           dtoConcurso = this.getConcurso();
         }             
         
         //******************AGREGADO********************

                  traza("***** dtoConcurso " + dtoConcurso);

         /*DTOConcurso dtoConcurso2 = null;

         if ("nueva version".equals(opcionMenu)) {
           dtoConcurso2 = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
         } else {
           dtoConcurso2 = this.getConcurso();
         }    */


                  //traza("***** dtoConcurso2 " + dtoConcurso2);



         //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
         // ********** Hardcodeo ****************      
         //dtoConcurso = new DTOConcurso();
         // ********** Hardcodeo ****************          
         traza("Asigna valores a combos...");
         traza("1");
         this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
         traza("2");         
         this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
         traza("3");         
         this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");   
         traza("4");         
         //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
         traza("5");         
         //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");         
         traza("6");         
         this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");                  
         this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");                           
         traza("7");         
         this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");                           
         this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");                                    
         traza("8");         
         
         traza("Asigna valores a labels...");
         this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
         this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
         this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);
         
         traza("Genera cadena de campos a deshabilitar...");
         StringBuffer sCadena = this.generaCadenaDeshabilitacion("pValidos");
         
         traza("Cadena generada: " + sCadena.toString() );
         
         this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );
         
         // Si el indicador de que se ha rellenado ya la pestaña Productos/ProductosVálidos 
         // está a true, cargo la pantalla con la información del dtoConcurso.
         if ( dtoConcurso != null && 
              dtoConcurso.getIndProductosValidos() != null && 
              dtoConcurso.getIndProductosValidos().booleanValue() )
         {
             // Modificado por inc. 17717 - by ssantana
             // Ya no se recargan todos los controles. 
             traza("Indicar de relleno anterior en true, carga con valores anteriores...");
             Boolean indComunicacion = dtoConcurso.getProductosValidos().getIndComunicacion();
             String codigoMensaje = dtoConcurso.getProductosValidos().getCodigoMensaje();
             ArrayList listaProductos = dtoConcurso.getProductosValidos().getLstProductos();             
             
             if ( indComunicacion != null && indComunicacion.booleanValue() )
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
             else
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");
             
             this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
             
             RecordSet r = this.armarRecordSetLista(listaProductos, "pValidos");
             traza("r: " + r);
             DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
             this.asignar("LISTADOA", "listado1", conectorLista, "Con");
         }
         
         // En caso que sea una Consulta deshabilita todos los campos.
      if (opcionMenu.equals("Consultar Concurso"))
      {
          traza("Es Consulta, deshabilita TODOS los campos...");
          sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
          this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else {
          this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }
                                
      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005
 
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pValidos");
      
    }
    
    // inc. 20335  DT: jpollio  Implantacion de cambio: idedough

    /* 4. Se modifica LPMantenerProductos.cargarPantallaProductosExcluidos() : void
     ********************AGREGADO***********************
     Si opcionMenu == "nueva version" {
          Se recupera de la sesión dtoConcurso del tipo DTOConcurso
          Se deben ocultar las pestañas de la página
     } else {
     **************************************************
           dtoConcurso = getConcurso() 
     ******************AGREGADO********************
     }
     **********************************************

     Crear un DTOBelcorp dtob con:
        - pais = dtoConcurso.pais
        - idioma = dtoConcurso.idioma

         Crear un DTOPeriodo dtop con:
           - pais = dtoConcurso.pais
           - marca = dtoConcurso.paramGenerales.oidMarca
           - canal = dtoConcurso.paramGenerales.oidCanal

         Crear una lista ComposerViewElementList

         Crear un dtoOid del tipo DTOOID con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma
           - oid = dtoConcurso.paramGenerales.oidMarca

         //Obtenemos las marcas de productos
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="SEGRecuperarMarcasProductoMP";
          elem.DTOE=dtoOid;
          Añadir el elemento a la lista

         //Obtenemos las unidades de negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerUnidadesNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos supergenérico
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerSuperGenericosPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

    //Obtenemos genérico
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="MAEObtenerGenericosPorPais";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

    Crear un dtoOid2 del tipo DTOOID con:
      - pais = dtoConcurso.pais
      - idioma = dtoConcurso.idioma
      - oid = dtoConcurso.paramGenerales.oidCanal

    //Obtenemos los tipos de oferta
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="PREObtenerTiposOfertaPorCanal";
     elem.DTOE=dtoOid2;
     Añadir el elemento a la lista

    //Obtenemos los ciclos de vida
    Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="PREObtenerCiclosVida";
     elem.DTOE=dtob;
     Añadir el elemento a la lista

     //Obtenemos los períodos Desde
     Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="CRAObtienePeriodos";
     elem.DTOE=dtop;
     Añadir el elemento a la lista

    //Obtenemos los períodos Hasta
     Crear un elemento de tipo ComposerViewElement()
     elem.IDBusiness="CRAObtienePeriodos";
     elem.DTOE=dtop;
     Añadir el elemento a la lista

     Invocar al  subsistema GestorCargaPantalla

     Asigna las combos:
        cbMarcaProducto
        cbUnidadNegocio
        cbNegocio
        cbSupergenerico
        cbGenerico
        cbTipoOferta
        cbCicloVida
        cbPeriodoDesde
        cbPeriodoHasta
     
        Asignar al label lbProductos = desTipoProducto
        Envia a la página el oidTipoProducto

        Seleccionar la pestaña pestanyaBloqueNegocio   // por defecto se seleccion esta pestanya
        Se muestra la capa "bloque negocio" y se ocultan las capas "bloque  oferta - producto" y "bloque producto" 
        
        Deshabilita los siguientes campos:
          txtPuntosUnidad
          txtFactorMultiplicidad
          txtUnidadesExigidas
          txtMontoExigido
          txtPuntosExigidos
         
    Si dtoConcurso.indProductosExcluidos //Si el indicador de que se ha rellenado ya la pestaña Productos/ProductosExcluidos está a true, cargo la pantalla con la información del dtoConcurso
    {
        Asignar valores a la página:

          - oidTipoProducto = dtoConcurso.productosExcluidos.oidTipoProducto
          - lstProductos = dtoConcurso.productosExcluidos.lstProductos
          - chkComunicacion = dtoConcurso.productosExcluidos.indComunicacion //si es 1 se selecciona el check
          - txtCodigoMensaje = dtoConcurso.productosExcluidos.codigoMensaje
     }

     Si opcionMenu = "Consultar Concurso"
           Deshabilitar todos los campos de la PGMantenerProductosDetalle

    Mostrar la PGMantenerProductosDetalle
    Enviar también a la página:
        cteOidTipoProductoValido = ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS
        accion
        opcionMenu
    */

// ---------------------------------------------------------------------------------------------------------------
    private void cargarPantallaProductosExcluidos() throws Exception
    {
         traza("Entra a cargarPantallaProductosExcluidos()");
         
         String descProducto= this.conectorParametroLimpia("descCombo", "", true);
         String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
         opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);                  
                  
         traza("descProducto: " + descProducto);
         traza("oidTipoProducto: " + oidTipoProducto);         
         
         this.pagina("contenido_productos_mantener_detalle");
         this.getConfiguracionMenu("LPMantenerProductos", "");
         this.asignarAtributoPagina("cod", "0491");
         
         this.getFormatosValidaciones();
         DruidaConector con = this.cargaPantallaGeneral();
         
         // inc. 20335
         //******************AGREGADO********************
           
         DTOConcurso dtoConcurso = null;
         
         if ("nueva version".equals(opcionMenu)) {
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
         } else {
           dtoConcurso = this.getConcurso();
         }    
         
         //******************AGREGADO********************
         
         //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");         
         // ********** Hardcodeo ****************      
         //dtoConcurso = new DTOConcurso();
         // ********** Hardcodeo ****************            

         
         traza("Asigna valores a combos...");
         this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
         this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
         this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
         //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
         //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
         this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
         this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");         
         this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
         this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");         
         this.asignar("COMBO", "cbPeriodoDesde", con, "CRAObtienePeriodos"); 
		 // vbongiov -- 15/09/2006 -- inc DBLG500000020
         //this.asignar("COMBO", "cbPeriodoHasta", con, "CRAObtienePeriodos");      
		 
                  //Cleal inc 21046
                  if(dtoConcurso.getParamGenerales() != null && dtoConcurso.getParamGenerales().getOidPeriodoDesde() != null){
         this.asignarAtributo("VAR", "hOidPeriodoDesde", "valor", 
           dtoConcurso.getParamGenerales().getOidPeriodoDesde().toString());
                    traza("Periodo Desde: "+dtoConcurso.getParamGenerales().getOidPeriodoDesde().toString());
         }

         if(dtoConcurso.getParamGenerales() != null && dtoConcurso.getParamGenerales().getOidPeriodoHasta() != null){
         this.asignarAtributo("VAR", "hOidPeriodoHasta", "valor", 
           dtoConcurso.getParamGenerales().getOidPeriodoHasta().toString());
                    traza("Periodo hasta: "+dtoConcurso.getParamGenerales().getOidPeriodoHasta().toString());
         }

         // vbongiov -- 15/09/2006 -- inc DBLG500000020
		 this.asignarAtributo("VAR", "hPaisParamGener", "valor", dtoConcurso.getOidPais().toString());
		 this.asignarAtributo("VAR", "hMarcaParamGener", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
		 this.asignarAtributo("VAR", "hCanalParamGener", "valor", dtoConcurso.getParamGenerales().getOidCanal().toString());

         
         traza("Asigna valores a labels...");
         this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
         this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
         this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);                
         
         traza("Genera cadena de campos a deshabilitar...");
         StringBuffer sCadena = this.generaCadenaDeshabilitacion("pExcluidos");
         
         traza("Cadena generada: " + sCadena.toString() );
         this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );
         
         
         if ( dtoConcurso != null && 
              dtoConcurso.getIndProductosExcluidos() != null && 
              dtoConcurso.getIndProductosExcluidos().booleanValue() )
         {
             // Modificado por inc. 17717 - by ssantana
             // Ya no se recargan todos los controles. 
             traza("Indicar de relleno anterior en true, carga con valores anteriores...");
             Boolean indComunicacion = dtoConcurso.getProductosExcluidos().getIndComunicacion();
             String codigoMensaje = dtoConcurso.getProductosExcluidos().getCodigoMensaje();
             ArrayList listaProductos = dtoConcurso.getProductosExcluidos().getLstProductos();
             
             if ( indComunicacion != null && indComunicacion.booleanValue() )
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
             else
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");
             
             this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
             
             RecordSet r = this.armarRecordSetLista(listaProductos, "pExcluidos");
             traza("r: " + r);             
             DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
             this.asignar("LISTADOA", "listado2", conectorLista, "Con");
             
             
         }
         
      if (opcionMenu.equals("Consultar Concurso"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         // Deshabilita TODOS los campos.... 
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else
      {
         this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }

      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005

         
      /*this.asignarAtributo("VAR", "oidTipoProductoValido", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());*/
 
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pExcluidos");
         
   }
   
   // inc. 20335  DT: jpollio  Implantacion de cambio: idedough
  
   /*5. Se modifica LPMantenerProductos.cargarPantallaProductosBonificados():void
      *******************AGREGADO******************************
        Si opcionMenu == "nueva version" {
                   Se recupera de la sesión dtoConcurso del tipo DTOConcurso
                   Se deben ocultar las pestañas de la página
        } else {
        *************************************************************
                  dtoConcurso = getConcurso() 
        *********************AGREGADO*******************************
        }
        *************************************************************

         Crear un DTOBelcorp dtob con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma

         Crear un DTOPeriodo dtop con:
           - pais = dtoConcurso.pais
           - marca = dtoConcurso.paramGenerales.oidMarca
           - canal = dtoConcurso.paramGenerales.oidCanal

         Crear una lista ComposerViewElementList

         Crear un dtoOid del tipo DTOOID con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma
           - oid = dtoConcurso.paramGenerales.oidMarca

         //Obtenemos las marcas de productos
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="SEGRecuperarMarcasProductoMP";
          elem.DTOE=dtoOid;
          Añadir el elemento a la lista

         //Obtenemos las unidades de negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerUnidadesNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos supergenérico
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerSuperGenericosPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos genérico
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerGenericosPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         Crear un dtoOid2 del tipo DTOOID con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma
           - oid = dtoConcurso.paramGenerales.oidCanal

         //Obtenemos los tipos de oferta
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="PREObtenerTiposOfertaPorCanal";
          elem.DTOE=dtoOid2;
          Añadir el elemento a la lista

         //Obtenemos los ciclos de vida
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="PREObtenerCiclosVida";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

          //Obtenemos los períodos Desde
          Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="CRAObtienePeriodos";
          elem.DTOE=dtop;
          Añadir el elemento a la lista

         //Obtenemos los períodos Hasta
          Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="CRAObtienePeriodos";
          elem.DTOE=dtop;
          Añadir el elemento a la lista

          Invocar al  subsistema GestorCargaPantalla

          Asigna las combos:
            cbMarcaProducto
            cbUnidadNegocio
            cbNegocio
            cbSupergenerico
            cbGenerico
            cbTipoOferta
            cbCicloVida
            cbPeriodoDesde
            cbPeriodoHasta
          
            Asignar al label lbProductos = desTipoProducto
            Envia a la página el oidTipoProducto
             
            Seleccionar la pestaña pestanyaBloqueNegocio   // por defecto se seleccion esta pestanya 
            Se muestra la capa "bloque negocio" y se ocultan las capas "bloque  oferta - producto" y "bloque producto" 

            Deshabilita los siguientes campos:
              txtUnidadesExigidas
              txtMontoExigido
              txtPuntosExigidos
             
         Si dtoConcurso.indproductosBonificados //Si el indicador de que se ha rellenado ya la pestaña Productos/productosBonificados está a true, cargo la pantalla con la información del dtoConcurso
         {
            Asignar valores a la página:
          
              - oidTipoProducto = dtoConcurso.productosBonificados.oidTipoProducto
              - lstProductos = dtoConcurso.productosBonificados.lstProductos
              - chkComunicacion = dtoConcurso.productosBonificados.indComunicacion //si es 1 se selecciona el check
              - txtCodigoMensaje = dtoConcurso.productosBonificados.codigoMensaje
          }

          Si opcionMenu = "Consultar Concurso"
                Deshabilitar todos los campos de la PGMantenerProductosDetalle

         Mostrar la PGMantenerProductosDetalle
         Enviar también a la página:
            cteOidTipoProductoValido = ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS
            accion
            opcionMenu
         */
   
// ---------------------------------------------------------------------------------------------------------------
    private void cargarPantallaProductosBonificados() throws Exception
    {
         traza("Entra a cargarPantallaProductosBonificados()");
         
         String descProducto= this.conectorParametroLimpia("descCombo", "", true);
         String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
         opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
         
         traza("descProducto: " + descProducto);
         traza("oidTipoProducto: " + oidTipoProducto);         
         
         this.pagina("contenido_productos_mantener_detalle");
          this.getConfiguracionMenu("LPMantenerProductos", "");
           this.asignarAtributoPagina("cod", "0491");
         this.getFormatosValidaciones();
         DruidaConector con = this.cargaPantallaGeneral();
      
         // inc. 20335
         //******************AGREGADO********************
                    
         DTOConcurso dtoConcurso = null;
         if ("nueva version".equals(opcionMenu)) {
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
         } else {
           dtoConcurso = this.getConcurso();
         }    
         
         //******************AGREGADO********************

         //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");         
         // ********** Hardcodeo ****************      
         /*dtoConcurso = new DTOConcurso();
         DTOProducto dtoProdu = new DTOProducto();
         dtoProdu.setOidMarcaProducto(new Long(1));
         dtoProdu.setOidUnidadNegocio(new Long(1));
         dtoProdu.setOidNegocio(new Long(1));
         dtoProdu.setOidGenerico(new Long(1));
         dtoProdu.setOidSupergenerico(new Long(1));
         dtoProdu.setOidCicloVida(new Long(2));
         dtoProdu.setOidTipoOferta(new Long(1));
         
         dtoProdu.setCodigoProducto("PRODU YZ_475_WY");
         dtoProdu.setOidPeriodoDesde(new Long(56));
         dtoProdu.setOidPeriodoHasta(new Long(57));
         dtoProdu.setPuntosUnidad(new Integer(12));
         dtoProdu.setFactorMultiplicidad(new Integer(10));
         dtoProdu.setUnidadesExigidas(new Integer(20));
         dtoProdu.setMontoExigido(new Double(2.4));
         dtoProdu.setPuntosExigidos(new Integer(30));
         dtoProdu.setIndComunicacion(new Boolean(true));
         dtoProdu.setCodigoMensaje("MSGX");
         dtoConcurso.setProductosBonificados(dtoProdu);
         
         dtoProdu = new DTOProducto();
         dtoProdu.setOidProducto(new Long(1));
         dtoConcurso.setProductosValidos(dtoProdu );
         dtoConcurso.setIndProductosBonificados(new Boolean(true));*/
         
         // ********** Hardcodeo *****************   
         
         traza("Asigna valores a combos...");
         this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
         this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
         this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
         //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
         //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
         this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
         this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");                  
         this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
         this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");         
         this.asignar("COMBO", "cbPeriodoDesde", con, "CRAObtienePeriodos");

         // vbongiov -- 15/09/2006 -- inc DBLG500000020
         //this.asignar("COMBO", "cbPeriodoHasta", con, "CRAObtienePeriodos");

                  //Cleal inc 21046
                  if(dtoConcurso.getParamGenerales() != null && dtoConcurso.getParamGenerales().getOidPeriodoDesde() != null){
         this.asignarAtributo("VAR", "hOidPeriodoDesde", "valor", 
           dtoConcurso.getParamGenerales().getOidPeriodoDesde().toString());
                    traza("Periodo Desde: "+dtoConcurso.getParamGenerales().getOidPeriodoDesde().toString());
         }



         if(dtoConcurso.getParamGenerales() != null && dtoConcurso.getParamGenerales().getOidPeriodoHasta() != null){
         this.asignarAtributo("VAR", "hOidPeriodoHasta", "valor", 
           dtoConcurso.getParamGenerales().getOidPeriodoHasta().toString());
                    traza("Periodo hasta: "+dtoConcurso.getParamGenerales().getOidPeriodoHasta().toString());
         }

		 // vbongiov -- 15/09/2006 -- inc DBLG500000020
		 this.asignarAtributo("VAR", "hPaisParamGener", "valor", dtoConcurso.getOidPais().toString());
		 this.asignarAtributo("VAR", "hMarcaParamGener", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
		 this.asignarAtributo("VAR", "hCanalParamGener", "valor", dtoConcurso.getParamGenerales().getOidCanal().toString());

         
         traza("Asigna valores a labels...");
         this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
         this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
         this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);
         
         traza("Genera cadena de campos a deshabilitar...");
         StringBuffer sCadena = this.generaCadenaDeshabilitacion("pBonificados");
         
         traza("Cadena generada: " + sCadena.toString() );
         this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );

         if (  dtoConcurso != null && 
                dtoConcurso.getIndProductosBonificados() != null && 
                dtoConcurso.getIndProductosBonificados().booleanValue() )
         {
             // Modificado por inc. 17717 - by ssantana
             // Ya no se recargan todos los controles. 
             traza("Indicar de relleno anterior en true, carga con valores anteriores...");         
             Boolean chkComunicacion = dtoConcurso.getProductosBonificados().getIndComunicacion();
             String codigoMensaje = dtoConcurso.getProductosBonificados().getCodigoMensaje();
             ArrayList listaProductos = dtoConcurso.getProductosBonificados().getLstProductos();
             
             if ( chkComunicacion != null && chkComunicacion.booleanValue() )
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
             else
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");
             
             this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
             RecordSet r = this.armarRecordSetLista(listaProductos, "pBonificados");
             traza("r: " + r);             
             DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
             this.asignar("LISTADOA", "listado3", conectorLista, "Con");
             
         }
         
      if (opcionMenu.equals("Consultar Concurso"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         // Deshabilita TODOS los campos.... 
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else
      {
         this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }

      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005

      /*this.asignarAtributo("VAR", "oidTipoProductoValido", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());*/
 
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pBonificados");
         
    }
     
     // inc. 20335  DT: jpollio  Implantacion de cambio: idedough
     
     /*
     6. Se modifica LPMantenerProductos.cargarPantallaProductosExigidos() : void
         ************************AGREGADO***********************
         Si opcionMenu == "nueva version"
                  Se recupera de la sesión dtoConcurso del tipo DTOConcurso
                  Se deben ocultar las pestañas de la página
         } else {
         **********************************************************
                   dtoConcurso = getConcurso() 
         **************************AGREGADO************************
         }
         ************************************************************

         Crear un DTOBelcorp dtob con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma

         Crear un DTOPeriodo dtop con:
           - pais = dtoConcurso.pais
           - marca = dtoConcurso.paramGenerales.oidMarca
           - canal = dtoConcurso.paramGenerales.oidCanal

         Crear una lista ComposerViewElementList

         Crear un dtoOid del tipo DTOOID con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma
           - oid = dtoConcurso.paramGenerales.oidMarca

         //Obtenemos las marcas de productos
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="SEGRecuperarMarcasProductoMP";
          elem.DTOE=dtoOid;
          Añadir el elemento a la lista

         //Obtenemos las unidades de negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerUnidadesNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos negocio
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerNegocioPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos supergenérico
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerSuperGenericosPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         //Obtenemos genérico
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="MAEObtenerGenericosPorPais";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

         Crear un dtoOid2 del tipo DTOOID con:
           - pais = dtoConcurso.pais
           - idioma = dtoConcurso.idioma
           - oid = dtoConcurso.paramGenerales.oidCanal

         //Obtenemos los tipos de oferta
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="PREObtenerTiposOfertaPorCanal";
          elem.DTOE=dtoOid2;
          Añadir el elemento a la lista

         //Obtenemos los ciclos de vida
         Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="PREObtenerCiclosVida";
          elem.DTOE=dtob;
          Añadir el elemento a la lista

          //Obtenemos los períodos Desde
          Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="CRAObtienePeriodos";
          elem.DTOE=dtop;
          Añadir el elemento a la lista

         //Obtenemos los períodos Hasta
          Crear un elemento de tipo ComposerViewElement()
          elem.IDBusiness="CRAObtienePeriodos";
          elem.DTOE=dtop;
          Añadir el elemento a la lista

          Invocar al  subsistema GestorCargaPantalla

          Asigna las combos:
            cbMarcaProducto
            cbUnidadNegocio
            cbNegocio
            cbSupergenerico
            cbGenerico
            cbTipoOferta
            cbCicloVida
            cbPeriodoDesde
            cbPeriodoHasta
          
            Asignar al label lbProductos = desTipoProducto
            Envia a la página el oidTipoProducto
            
            Seleccionar la pestaña pestanyaBloqueNegocio   // por defecto se seleccion esta pestanya
            Se muestra la capa "bloque negocio" y se ocultan las capas "bloque  oferta - producto" y "bloque producto" 

            Deshabilita los siguientes campos:
              txtPuntosUnidad
              txtFactorMultiplicidad
             
             
         Si dtoConcurso.indproductosExigidos //Si el indicador de que se ha rellenado ya la pestaña Productos/productosExigidos está a true, cargo la pantalla con la información del dtoConcurso
         {
            Asignar valores a la página:
           
              - oidTipoProducto = dtoConcurso.productosExigidos.oidTipoProducto
              - lstProductos = dtoConcurso.productosExigidos.lstProductos
              - chkComunicacion = dtoConcurso.productosExigidos.indComunicacion //si es 1 se selecciona el check
              - txtCodigoMensaje = dtoConcurso.productosExigidos.codigoMensaje
          }

          Si opcionMenu = "Consultar Concurso"
                Deshabilitar todos los campos de la PGMantenerProductosDetalle

         Mostrar la PGMantenerProductosDetalle
         Enviar también a la página:
            cteOidTipoProductoValido = ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS
            accion
            opcionMenu
*/

// ---------------------------------------------------------------------------------------------------------------    
   private void cargarPantallaProductosExigidos() throws Exception
   {
         traza("Entra a cargarPantallaProductosExigidos()");
         
         String descProducto= this.conectorParametroLimpia("descCombo", "", true);
         String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
         opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
         
         traza("descTipoProducto: " + descProducto);
         traza("oidTipoProducto: " + oidTipoProducto);         
         
         this.pagina("contenido_productos_mantener_detalle");
         this.getConfiguracionMenu("LPMantenerProductos", "");
         this.asignarAtributoPagina("cod", "0491");
         
         this.getFormatosValidaciones();
         DruidaConector con = this.cargaPantallaGeneral();
      
         // inc. 20335
         //******************AGREGADO********************
                     
         DTOConcurso dtoConcurso = null; 
         
         if ("nueva version".equals(opcionMenu)) {
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
         } else {
           dtoConcurso = this.getConcurso();
         }    
         
         //******************AGREGADO********************

         //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");         
         
         // ********** Hardcodeo ****************      
/*         dtoConcurso = new DTOConcurso();
         DTOProducto dtoProdu = new DTOProducto();
         dtoProdu.setOidMarcaProducto(new Long(1));
         dtoProdu.setOidUnidadNegocio(new Long(1));
         dtoProdu.setOidNegocio(new Long(1));
         dtoProdu.setOidGenerico(new Long(1));
         dtoProdu.setOidSupergenerico(new Long(1));
         dtoProdu.setOidCicloVida(new Long(2));
         dtoProdu.setOidTipoOferta(new Long(1));
         dtoProdu.setCodigoProducto("PRODU YZ_475_WY");
         dtoProdu.setOidPeriodoDesde(new Long(56));
         dtoProdu.setOidPeriodoHasta(new Long(57));
         //dtoProdu.setPuntosUnidad(new Integer(12));
         //dtoProdu.setFactorMultiplicidad(new Integer(10));
         dtoProdu.setUnidadesExigidas(new Integer(2000));
         dtoProdu.setMontoExigido(new Double(2.4));
         dtoProdu.setPuntosExigidos(new Integer(30));
         dtoProdu.setIndComunicacion(new Boolean(true));
         dtoProdu.setCodigoMensaje("MSGX");
         dtoConcurso.setIndProductosExigidos(new Boolean(true));
         
         dtoConcurso.setProductosExigidos(dtoProdu);*/

         // ********** Hardcodeo ****************            

         traza("Asigna valores a combos...");
         this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
         this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
         this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
         //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
         //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
         this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
         this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");         
         this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
         this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");         
         this.asignar("COMBO", "cbPeriodoDesde", con, "CRAObtienePeriodos");
		 // vbongiov -- 15/09/2006 -- inc DBLG500000020
         //this.asignar("COMBO", "cbPeriodoHasta", con, "CRAObtienePeriodos");

		 // vbongiov -- 15/09/2006 -- inc DBLG500000020
		 this.asignarAtributo("VAR", "hPaisParamGener", "valor", dtoConcurso.getOidPais().toString());
		 this.asignarAtributo("VAR", "hMarcaParamGener", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
		 this.asignarAtributo("VAR", "hCanalParamGener", "valor", dtoConcurso.getParamGenerales().getOidCanal().toString());

         
         traza("Asigna valores a labels...");
         this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
         this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
         this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);
         
         traza("Genera cadena de campos a deshabilitar...");
         StringBuffer sCadena = this.generaCadenaDeshabilitacion("pExigidos");
         
         traza("Cadena generada: " + sCadena.toString() );
         this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );
         
          if ( dtoConcurso != null && 
                dtoConcurso.getIndProductosExigidos() != null && 
                dtoConcurso.getIndProductosExigidos().booleanValue() )
          {
             // Modificado por inc. 17717 - by ssantana
             // Ya no se recargan todos los controles. 
             traza("Indicar de relleno anterior en true, carga con valores anteriores...");      
             Boolean indComunicacion = dtoConcurso.getProductosExigidos().getIndComunicacion();
             String codigoMensaje = dtoConcurso.getProductosExigidos().getCodigoMensaje();
             ArrayList listaProductos = dtoConcurso.getProductosExigidos().getLstProductos();
             
             if ( indComunicacion != null && indComunicacion.booleanValue() )
                  this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
             else
                  this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");             
             
             this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
             
             RecordSet r = this.armarRecordSetLista(listaProductos, "pExigidos");
             traza("r: " + r);             
             DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
             this.asignar("LISTADOA", "listado4", conectorLista, "Con");
         }
         
      if (opcionMenu.equals("Consultar Concurso"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         // Deshabilita TODOS los campos.... 
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else
      {
         this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }
      
      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005

         
      /*this.asignarAtributo("VAR", "oidTipoProductoValido", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());*/
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pExigidos");         
   
      // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
      if( dtoConcurso.getParamGenerales() != null && dtoConcurso.getParamGenerales().getIndMultiMarca() != null){
			this.asignarAtributo("VAR", "hIndMultiMarca", "valor", 
					dtoConcurso.getParamGenerales().getIndMultiMarca().booleanValue()?"S":"N");
	  } else {
		  this.asignarAtributo("VAR", "hIndMultiMarca", "valor", "N");
	  }	  
   }
    
// ---------------------------------------------------------------------------------------------------------------    
   private void cargarPantallaProductosACalificar() throws Exception
   {
      traza("Entra a cargarPantallaProductosACalificar()");
      
      String descProducto= this.conectorParametroLimpia("descCombo", "", true);
      String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
      opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
         
      traza("descTipoProducto: " + descProducto);
      traza("oidTipoProducto: " + oidTipoProducto);         
      
      
      this.pagina("contenido_productos_mantener_detalle");
      this.getConfiguracionMenu("LPMantenerProductos", "");
      this.asignarAtributoPagina("cod", "0491");
      this.getFormatosValidaciones();
    //  this.asignarAtributoPagina("cod", "0491");
      DruidaConector con = this.cargaPantallaGeneral();
      
      DTOConcurso dtoConcurso = this.getConcurso();
      //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");      
      // ********** Hardcodeo ****************      
      
      //if (dtoConcurso == null) 
      //  dtoConcurso = new DTOConcurso();
      // ********** Hardcodeo ****************         
      
      traza("Asigna valores a combos...");
      this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
      this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
      this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
      //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
      //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
      this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
      this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");      
      this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
      this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");      
      
      traza("Asigna valores a labels...");
      this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
      this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
      this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);
      
      traza("Genera cadena de campos a deshabilitar...");
      StringBuffer sCadena = this.generaCadenaDeshabilitacion("pACalificar");

      this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );
      
      
      if (dtoConcurso != null && 
           dtoConcurso.getIndProductosACalificar() != null && 
           dtoConcurso.getIndProductosACalificar().booleanValue() )
      {
           // Modificado por inc. 17717 - by ssantana
           // Ya no se recargan todos los controles. 
           traza("Indicar de relleno anterior en true, carga con valores anteriores...");
           Boolean indComunicacion = dtoConcurso.getProductosACalificar().getIndComunicacion();
           String codigoMensaje = dtoConcurso.getProductosACalificar().getCodigoMensaje();
           ArrayList listaProductos = dtoConcurso.getProductosACalificar().getLstProductos();
           
           if ( indComunicacion != null && indComunicacion.booleanValue() )
             this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
           else
             this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");
           
           this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
           
           // Es igual que lista de Productos Validos
           RecordSet r = this.armarRecordSetLista(listaProductos, "pValidos");
           traza("r: " + r);           
           DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
           this.asignar("LISTADOA", "listado1", conectorLista, "Con");
         
      }
      
      if (opcionMenu.equals("Consultar Concurso"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         // Deshabilita TODOS los campos.... 
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else
      {
         this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }

      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005

      
      /*this.asignarAtributo("VAR", "oidTipoProductoValido", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());*/
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);          
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pValidos");      

   }
   
 // ---------------------------------------------------------------------------------------------------------------      
   private void cargarPantallaProductosExcluidosCalificacion() throws Exception
   {
      traza("Entra a cargarPantallaProductosExcluidosCalificacion()");
      
      String descProducto= this.conectorParametroLimpia("descCombo", "", true);
      String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
      opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
         
      traza("descTipoProducto: " + descProducto);
      traza("oidTipoProducto: " + oidTipoProducto);         
      
      
      this.pagina("contenido_productos_mantener_detalle");
      this.getConfiguracionMenu("LPMantenerProductos", "");
      this.asignarAtributoPagina("cod", "0491");
      this.getFormatosValidaciones();
      DTOConcurso dtoConcurso = this.getConcurso();
      //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");      

      // ********** Hardcodeo ****************      
      // ********** Hardcodeo ****************      

      DruidaConector con = this.cargaPantallaGeneral();
      
      traza("Asigna valores a combos...");
      this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
      this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
      this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
      //this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
      //this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
      this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
      this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");      
      this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
      this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");      
      this.asignar("COMBO", "cbPeriodoDesde", con, "CRAObtienePeriodos");
	  // vbongiov -- 15/09/2006 -- inc DBLG500000020
      //this.asignar("COMBO", "cbPeriodoHasta", con, "CRAObtienePeriodos");

	  // vbongiov -- 15/09/2006 -- inc DBLG500000020
	  this.asignarAtributo("VAR", "hPaisParamGener", "valor", dtoConcurso.getOidPais().toString());
	  this.asignarAtributo("VAR", "hMarcaParamGener", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
	  this.asignarAtributo("VAR", "hCanalParamGener", "valor", dtoConcurso.getParamGenerales().getOidCanal().toString());
      
      traza("Asigna valores a labels...");
      this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
      this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
      this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);
      
      traza("Genera cadena de campos a deshabilitar...");
      StringBuffer sCadena = this.generaCadenaDeshabilitacion("pExcluidosClasificacion");
      this.asignarAtributo("VAR", "camposDeshabilitados", "valor", sCadena.toString() );
 
        if (dtoConcurso != null && 
            dtoConcurso.getIndProductosExcluidosCalificacion() != null && 
            dtoConcurso.getIndProductosExcluidosCalificacion().booleanValue() )
        {
             // Modificado por inc. 17717 - by ssantana
             // Ya no se recargan todos los controles. 
             traza("Indicar de relleno anterior en true, carga con valores anteriores...");
             Boolean indComunicacion = dtoConcurso.getProductosExcluidosCalificacion().getIndComunicacion();
             String codigoMensaje = dtoConcurso.getProductosExcluidosCalificacion().getCodigoMensaje();
             ArrayList listaProductos = dtoConcurso.getProductosExcluidosCalificacion().getLstProductos();
             
             if ( indComunicacion != null && indComunicacion.booleanValue() )
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "1");
             else
                this.asignarAtributo("VAR", "hchkComunicacion", "valor", "0");             
             
             this.asignarVAROculta(codigoMensaje, "htxtCodigoMensaje");
             
             // Es igual que lista de Productos Excluidos. 
             RecordSet r = this.armarRecordSetLista(listaProductos, "pExcluidos");
             traza("r: " + r);             
             DruidaConector conectorLista = UtilidadesBelcorp.generarConector("Con", r, r.getColumnIdentifiers());
             
             // ssantana, 17/6/2005 - Inc. 18900
             // Ahora queda igual a Excluidos. 
             //this.asignar("LISTADOA", "listado4", conectorLista, "Con");
             this.asignar("LISTADOA", "listado2", conectorLista, "Con");
             
             
        }
        
      if (opcionMenu.equals("Consultar Concurso"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         // Deshabilita TODOS los campos.... 
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductos", "detalleConsulta");           
      } else
      {
         this.getConfiguracionMenu("LPMantenerProductos", "detalleABM");
      }


      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005
         
      /*this.asignarAtributo("VAR", "oidTipoProductoValido", "valor", 
                              ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());*/

      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);                                    
      // Modificado por ssantana, 17/6/2005
      // Inc. 18900 - Ahora es igual a Bonificados, así que se utiliza esa lista. 
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pExcluidos");        
      
   }
   
// -------------------------------------------------------------------------------------------------     
   private DruidaConector cargaPantallaGeneral() throws Exception
   {
	  traza("LPMantenerProductos.cargaPantallaGeneral() - Entrada");
      DTOConcurso dtoConcurso = this.getConcurso();
      
      
      //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");      
      
        // ********** Hardcodeo ****************      
      //dtoConcurso = new DTOConcurso();         
      //dtoConcurso.setOidIdioma(new Long(1));
      //dtoConcurso.setOidIdioma(UtilidadesSession.g
      //dtoConcurso.setOidIdioma(UtilidadesSession. );
      //dtoConcurso.setOidPais(new Long(1));
         
      DTOBelcorp dtoBelcorp = new DTOBelcorp();
         
      dtoBelcorp.setOidIdioma( dtoConcurso.getOidIdioma() );
      dtoBelcorp.setOidPais( dtoConcurso.getOidPais() );
      
      DTOPeriodo dtoPeriodo = new DTOPeriodo();
      dtoPeriodo.setOidPais(dtoConcurso.getOidPais());
      dtoPeriodo.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
      dtoPeriodo.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
      //dtoPeriodo.setMarca(new Long(1));
      //dtoPeriodo.setCanal(new Long(1));
      
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOidPais(dtoConcurso.getOidPais());
      dtoOid.setOidIdioma(dtoConcurso.getOidIdioma());
      dtoOid.setOid(dtoConcurso.getParamGenerales().getOidMarca());
      //dtoOid.setOid(new Long(1));
      
      DTOOID dtoOid2 = new DTOOID();
      dtoOid2.setOidPais(dtoConcurso.getOidPais());
      dtoOid2.setOidIdioma(dtoConcurso.getOidIdioma());
      dtoOid2.setOid(dtoConcurso.getParamGenerales().getOidCanal());
      //dtoOid2.setOid(new Long(1));
 
      ComposerViewElementList cView = new ComposerViewElementList();         
      ComposerViewElement cElem1 = new ComposerViewElement();
      ComposerViewElement cElem2 = new ComposerViewElement();
      ComposerViewElement cElem3 = new ComposerViewElement();
      /*ComposerViewElement cElem4 = new ComposerViewElement();
      ComposerViewElement cElem5 = new ComposerViewElement();*/
      ComposerViewElement cElem6 = new ComposerViewElement();
      ComposerViewElement cElem7 = new ComposerViewElement();
      ComposerViewElement cElem8 = new ComposerViewElement();      
     
      cElem1.setIDBusiness("SEGRecuperarMarcasProductoMP");
      cElem1.setDTOE(dtoOid);
      
      cElem2.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
      cElem2.setDTOE(dtoBelcorp);
      
      cElem3.setIDBusiness("MAEObtenerNegocioPorPais");
      cElem3.setDTOE(dtoBelcorp);
      
      /*cElem4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
      cElem4.setDTOE(dtoBelcorp);
      
      cElem5.setIDBusiness("MAEObtenerGenericosPorPais");
      cElem5.setDTOE(dtoBelcorp);*/
      
      cElem6.setIDBusiness("PREObtenerTiposOfertaPorCanal");
      cElem6.setDTOE(dtoOid2);
      
      cElem7.setIDBusiness("PREObtenerCiclosVida");
      cElem7.setDTOE(dtoBelcorp);     
      
      cElem8.setIDBusiness("CRAObtienePeriodos");
      cElem8.setDTOE(dtoPeriodo);    
      
      cView.addViewElement(cElem1);
      cView.addViewElement(cElem2);      
      cView.addViewElement(cElem3);      
      /*cView.addViewElement(cElem4);      
      cView.addViewElement(cElem5);*/      
      cView.addViewElement(cElem6);
      cView.addViewElement(cElem7);      
      cView.addViewElement(cElem8);      
      
      ConectorComposerView cConector = new ConectorComposerView(cView, this.getRequest());
      traza("Se conecta");
      cConector.ejecucion();
      traza("Salio de Conectar");
      DruidaConector con = cConector.getConector();
   
      traza("LPMantenerProductos.cargaPantallaGeneral() - Salida");
      return con;
   
   }
   
// -------------------------------------------------------------------------------------------------     
   private StringBuffer generaCadenaDeshabilitacion(String tipoProducto) throws Exception
   {
      StringBuffer sCadena = new StringBuffer("");
      if (tipoProducto.equals("pValidos") )
      {
          sCadena.append("cbPeriodoDesde,");
          sCadena.append("cbPeriodoHasta,");
          sCadena.append("txtPuntosUnidad,");
          sCadena.append("txtFactorMultiplicidad,");
          sCadena.append("txtUnidadesExigidas,");
          sCadena.append("txtMontoExigido,");
          sCadena.append("txtPuntosExigidos,");
          sCadena.append("cbIndAgrup");
      }
      
      if ( tipoProducto.equals("pExcluidos"))
      {
         sCadena.append("cbPeriodoHasta,"); 
         sCadena.append("txtPuntosUnidad,");
         sCadena.append("txtFactorMultiplicidad,");
         sCadena.append("txtUnidadesExigidas,");
         sCadena.append("txtMontoExigido,");
         sCadena.append("txtPuntosExigidos,");
         sCadena.append("cbIndAgrup");
      }
      
      if ( tipoProducto.equals("pBonificados") )
      {
		 sCadena.append("cbPeriodoHasta,");
         sCadena.append("txtUnidadesExigidas,");
         sCadena.append("txtMontoExigido,");
         sCadena.append("txtPuntosExigidos,");
         sCadena.append("cbIndAgrup");
      }
      
      if ( tipoProducto.equals("pExigidos") )
      {
         sCadena.append("cbPeriodoHasta,"); 
         sCadena.append("txtPuntosUnidad,");
         sCadena.append("txtFactorMultiplicidad");
      }
      
      if ( tipoProducto.equals("pACalificar") )
      {
         sCadena.append("cbPeriodoDesde,");
         sCadena.append("cbPeriodoHasta,");
         sCadena.append("txtPuntosUnidad,");
         sCadena.append("txtFactorMultiplicidad,");
         sCadena.append("txtUnidadesExigidas,");
         sCadena.append("txtMontoExigido,");
         sCadena.append("txtPuntosExigidos,");
         sCadena.append("cbIndAgrup");
      }
      
      if ( tipoProducto.equals("pExcluidosClasificacion") )
      {
         // Ssantana, 17/6/2005
         // Por inc. 19800, ahora los campos txtUnidadesExigidas, txtMontoExigido, txtPuntosExigidos
         // para este caso no van, así que se deshabilitan (queda igual a Excluidos)
		 sCadena.append("cbPeriodoHasta,");
         sCadena.append("txtPuntosUnidad,");
         sCadena.append("txtFactorMultiplicidad,");
         sCadena.append("txtUnidadesExigidas,");
         sCadena.append("txtMontoExigido,");
         sCadena.append("txtPuntosExigidos,");
         sCadena.append("cbIndAgrup");
      }
      
      if ( tipoProducto.equals("deshabilitarTodos") )
      {
         sCadena.append("formulario.cbPeriodoDesde,");
         sCadena.append("formulario.cbPeriodoHasta,");
         sCadena.append("formulario.txtPuntosUnidad,");
         sCadena.append("formulario.txtFactorMultiplicidad,");
         sCadena.append("formulario.txtUnidadesExigidas,");
         sCadena.append("formulario.txtMontoExigido,");
         sCadena.append("formulario.txtPuntosExigidos,");
         
         sCadena.append("formulario.cbMarcaProducto,");
         sCadena.append("formulario.cbUnidadNegocio,");
         sCadena.append("formulario.cbNegocio,");
         sCadena.append("formulario.cbSupergenerico,");
         sCadena.append("formulario.cbGenerico");           
         
         sCadena.append("formulario.txtCodProducto");
         sCadena.append("formulario.cbTipoOferta2");
         sCadena.append("formulario.cbCicloVida2");       
         sCadena.append("formulario.cbIndAgrup");
      }
      
      traza("Cadena generada: " + sCadena.toString() );      
      
      return sCadena;
     
   }
   
// -------------------------------------------------------------------------------------------------     
   public void almacenar() throws Exception {
      traza("almacenar()");
      String tipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      traza("tipoProducto: " + tipoProducto); 
      Long oidTipoProducto = new Long(tipoProducto);

	  if ( oidTipoProducto.longValue() ==
	  ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.longValue() ) {
         this.almacenarProductosValidos();
      }
      
      if ( oidTipoProducto.longValue() == 
      ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.longValue() ) { 
         this.almacenarProductosExcluidos();                   
      }
      
      if ( oidTipoProducto.longValue() == 
      ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS.longValue() ) {
        this.almacenarProductosBonificados(); 
      }
      
      if ( oidTipoProducto.longValue() == 
      ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS.longValue() ) {
         this.almacenarProductosExigidos();
      }
      
      if ( oidTipoProducto.longValue() == 
      ConstantesINC.OID_TIPO_PRODUCTOS_A_CALIFICAR.longValue() ) {
	      this.almacenarProductosACalificar();
      }
    
      if ( oidTipoProducto.longValue() == 
      ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION .longValue() ) { 
	      this.almacenarProductosExcluidosCalificacion(); 
      }      
   }
   
// -------------------------------------------------------------------------------------------------     
   private void asignarVAROculta(Object o, String nombreVariable) throws Exception
   {
     if ( o == null)
         this.asignarAtributo("VAR", nombreVariable, "valor", "");
     else
         this.asignarAtributo("VAR", nombreVariable, "valor", o.toString() );
         
   }
   
   // inc. 20335  DT: jpollio  Implantacion de cambio: idedough

   /*7. Se modifica LPMantenerProductos.almacenarProductosValidos():void
    ***************AGREGADO********************************
        Si opcionMenu == "nueva version" {
                Se recupera de la sesión dtoConcurso del tipo DTOConcurso
        } else { 
    **********************************************************
                  dtoConcurso = getConcurso() 
    *********************AGREGADO**************************
     }
    ***********************************************************
      
        dtoConcurso.indObligProductosValidos = datosObligatorios //parámetro que se recibe desde la página
      
        //Rellena el dtoConcurso.productosValidos
     
        Si dtoConcurso.indProductosValidos { // si el indicador es true la lista tiene elementos
             Borrar dtoConcurso.productosValidos.lstProductos
        }
        dtoConcurso.indProductosValidos = true //indica que ya se ha rellenado la pestaña
        dtoConcurso.productosValidos.oidTipoProducto = oidTipoProducto
         
        Para cada elemento de la lista de la página lstProductos{  //desde i = 0 hasta el final de la lista   
             guardar en dtoConcurso.productosValidos.lstProductos todas las columnas de cada un de los elementos de la lista lstProductos de la página
        }
        dtoConcurso.productosValidos.indComunicacion = chkComunicacion
        dtoConcurso.productosValidos.codigoMensaje = txtCodigoMensaje
     
        **************************AGREGADO***************
         Si opcionMenu == "nueva version" { 
             Guardar en sesión dtoConcurso
        } else {
        ******************************************************
             setConcurso(dtoConcurso)
    ************************AGREGADO*******************
    }
    *******************************************************
    */
   
// -------------------------------------------------------------------------------------------------     
   private void almacenarProductosValidos() throws Exception
   {
      traza("--- almacenarProductosValidos");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);
      
      this.pagina("salidaGenerica");
      
      // inc. 20335
      //******************AGREGADO********************
                  
      DTOConcurso dtoConcurso = null;
      dtoConcurso = this.getConcurso();
      if ("nueva version".equals(opcionMenu)) {
           traza("Obtiene de Sesion");      
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
                    traza("Entro por nueva version...");
      } else {
           dtoConcurso = this.getConcurso();
      } 
      
      //******************AGREGADO********************            
      
      traza("dtoConcurso: " + dtoConcurso);
      dtoConcurso.setIndObligProductosValidos(indDatosObligatorios);
      if ( indDatosObligatorios.booleanValue() )
         dtoConcurso.setIndObligProductos(indDatosObligatorios);
      
      dtoConcurso.setIndProductosValidos(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcurso.getProductosValidos();      
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
      
      traza("sLista: " + sLista);      
      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "valido");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
         dtoProducto.setIndComunicacion(new Boolean(true));
      else
         dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
      dtoConcurso.setProductosValidos(dtoProducto);
      if ("nueva version".equals(opcionMenu)) {
           traza("Sube a dtoConcursoBufferSS");
                    traza("dtoConcursoBufferSS: "+dtoConcurso);
           this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcurso);
      } else {
           this.setConcurso(dtoConcurso);
      }    
      
   }

   // inc. 20335  DT: jpollio  Implantacion de cambio: idedough

   /*8. Se modifica LPMantenerProductos.almacenarProductosExcluidos() :void 
    ****************AGREGADO*************************
        Si opcionMenu == "nueva version" {
             Se recupera de sesión dtoConcurso del tipo DTOConcurso
        } else {
    ****************************************************
              dtoConcurso = getConcurso()   
    ***************AGREGADO*******************
        }
    *********************************************
        dtoConcurso.indObligProductosExcluidos = datosObligatorios //parámetro que se recibe desde la página
      
        //Rellena el dtoConcurso.productosExcluidos
     
        Si dtoConcurso.indProductosExcluidos { // si el indicador es true la lista tiene elementos
             Borrar dtoConcurso.productosExcluidos.lstProductos
        }
        dtoConcurso.indProductosExcluidos = true //indica que ya se ha rellenado la pestaña
        dtoConcurso.productosExcluidos.oidTipoProducto = oidTipoProducto
         
        Para cada elemento de la lista de la página lstProductos{  //desde i = 0 hasta el final de la lista   
             guardar en dtoConcurso.productosExcluidos.lstProductos todas las columnas de cada un de los elementos de la lista lstProductos de la página
        }
        dtoConcurso.productosExcluidos.indComunicacion = chkComunicacion
        dtoConcurso.productosExcluidos.codigoMensaje = txtCodigoMensaje
     
      **********************AGREGADO*************************
      Si opcionMenu == "nueva version" {
             Guardar en sesion dtoConcurso
      } else {
      **********************************************************
            setConcurso(dtoConcurso)
      **********************AGREGADO*************************
      }
      ********************************************************/

// -------------------------------------------------------------------------------------------------         
   private void almacenarProductosExcluidos() throws Exception
   {
      traza("--- almacenarProductosExcluidos");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);

	  String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
	  traza("sOpcionMenu: " + sOpcionMenu);
      
      this.pagina("salidaGenerica");

      // inc. 20335
      //******************AGREGADO********************
                  
      DTOConcurso dtoConcurso = null;
      dtoConcurso = this.getConcurso();
      if ("nueva version".equals(opcionMenu)) {
           traza("Obtiene de Sesion");      
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
      } else {
           dtoConcurso = this.getConcurso();
      }    
      
      //******************AGREGADO********************

	  if ("Modificar Concurso".equals(sOpcionMenu) && !indDatosObligatorios.booleanValue() ){ 
		dtoConcurso.setIndBorradoProductosExcluidos(Boolean.TRUE);
	  }
      
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
            
      traza("dtoConcurso: " + dtoConcurso);
      dtoConcurso.setIndObligProductosExcluidos(indDatosObligatorios);
      if ( indDatosObligatorios.booleanValue() )
         dtoConcurso.setIndObligProductos(indDatosObligatorios);
      
      dtoConcurso.setIndProductosExcluidos(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcurso.getProductosExcluidos();      
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
      
      traza("sDatosObligatorios: " + sDatosObligatorios);
      traza("sOidTipoProducto: " + sOidTipoProducto);
      traza("sIndComunicacion: " + sIndComunicacion);
      traza("sCodigoMensaje: "  + sCodigoMensaje);
      traza("sLista: " + sLista);      
      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "excluido");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
         dtoProducto.setIndComunicacion(new Boolean(true));
      else
         dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
      
      dtoConcurso.setProductosExcluidos(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcurso);
      if ("nueva version".equals(opcionMenu)) {
           traza("Sube a dtoConcursoBufferSS");
           this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcurso);
      } else {
           this.setConcurso(dtoConcurso);
      }    
      //dtoConcursoBuffer.getProductosValidos().setOidTipoProducto(new Long(sOidTipoProducto));
     
   }
   
   // inc. 20335  DT: jpollio  Implantacion de cambio: idedough

   /*10. Se modifica LPMantenerProductos.almacenarProductosExigidos() : void
    ************************AGREGADO******************
      Si opcionMenu == "nueva version" {  
                 Recuperar de sesión dtoConcurso del DTOConcurso
        } else {
     ********************************************
                  dtoConcurso = getConcurso()   
    ****************AGREGADO****************************
    }
    *******************************************************
        dtoConcurso.indObligProductosExigidos = datosObligatorios //parámetro que se recibe desde la página
      
        //Rellena el dtoConcurso.productosExigidos
     
        Si dtoConcurso.indProductosExigidos { // si el indicador es true la lista tiene elementos
             Borrar dtoConcurso.productosExigidos.lstProductos
        }
        dtoConcurso.indProductosExigidos = true //indica que ya se ha rellenado la pestaña
        dtoConcurso.productosExigidos.oidTipoProducto = oidTipoProducto
         
        Para cada elemento de la lista de la página lstProductos{  //desde i = 0 hasta el final de la lista   
             guardar en dtoConcurso.productosExigidos.lstProductos todas las columnas de cada un de los elementos de la lista lstProductos de la página
        }
        dtoConcurso.productosExigidos.indComunicacion = chkComunicacion
        dtoConcurso.productosExigidos.codigoMensaje = txtCodigoMensaje
     
    ************************AGREGADO****************************
    Si opcionMenu == "nueva version" { 
             Guardar en sesión dtoConcurso
    }else {
    *************************************************************
             setConcurso(dtoConcurso)
    ***************************AGREGADO**********************
    }
    ***********************************************************/

// -------------------------------------------------------------------------------------------------         
   private void almacenarProductosExigidos() throws Exception  {
      traza("--- almacenarProductosExigidos");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);
	  String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
	  traza("sOpcionMenu: " + sOpcionMenu);
      
      this.pagina("salidaGenerica");

      // inc. 20335
      //******************AGREGADO********************
                  
      DTOConcurso dtoConcurso = null;
      dtoConcurso = this.getConcurso();
      if ("nueva version".equals(opcionMenu)) {
           traza("Obtiene de Sesion");      
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
      } else {
           dtoConcurso = this.getConcurso();
      } 
      
      //******************AGREGADO********************

	  if ("Modificar Concurso".equals(sOpcionMenu) && !indDatosObligatorios.booleanValue() ){ 
		dtoConcurso.setIndBorradoProductosExigidos(Boolean.TRUE);
	  }
      
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
             
      traza("dtoConcurso: " + dtoConcurso);
      dtoConcurso.setIndObligProductosExigidos(indDatosObligatorios);
      if ( indDatosObligatorios.booleanValue() )
         dtoConcurso.setIndObligProductos(indDatosObligatorios);
      
      dtoConcurso.setIndProductosExigidos(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcurso.getProductosExigidos();    
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
      
      traza("sDatosObligatorios: " + sDatosObligatorios);
      traza("sOidTipoProducto: " + sOidTipoProducto);
      traza("sIndComunicacion: " + sIndComunicacion);
      traza("sCodigoMensaje: "  + sCodigoMensaje);
      traza("sLista: " + sLista);      
      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "exigido");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
         dtoProducto.setIndComunicacion(new Boolean(true));
      else
         dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
      
      dtoConcurso.setProductosExigidos(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcurso);
      if ("nueva version".equals(opcionMenu)) {
           this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcurso);
      } else {
           this.setConcurso(dtoConcurso);
      }    

     
   }   
   
   // inc. 20335  DT: jpollio  Implantacion de cambio: idedough

   /*9. Se modifica LPMantenerProductos.almacenarProductosBonificados() : void
    ************************AGREGADO******************** 
    Si opcionMenu == "nueva version" {
            Recuperar de sesión dtoConcurso del tipo DTOConcurso
    } else {  
    **********************************************************
           dtoConcurso = getConcurso()   
    ****************************AGREGADO*******************
    }
    ************************************
        dtoConcurso.indObligProductosBonificados = datosObligatorios //parámetro que se recibe desde la página
      
        //Rellena el dtoConcurso.productosBonificados
     
        Si dtoConcurso.indProductosBonificados { // si el indicador es true la lista tiene elementos
             Borrar dtoConcurso.productosBonificados.lstProductos
        }
        dtoConcurso.indProductosBonificados = true //indica que ya se ha rellenado la pestaña
        dtoConcurso.productosBonificados.oidTipoProducto = oidTipoProducto
         
        Para cada elemento de la lista de la página lstProductos{  //desde i = 0 hasta el final de la lista   
             guardar en dtoConcurso.productosBonificados.lstProductos todas las columnas de cada un de los elementos de la lista lstProductos de la página
        }
        dtoConcurso.productosBonificados.indComunicacion = chkComunicacion
        dtoConcurso.productosBonificados.codigoMensaje = txtCodigoMensaje
     
    ***************************AGREGADO**********************
      Si opcionMenu = "nueva version" {
                Guardar en sesión dtoConcurso
      }else {
    ***********************************************************
            setConcurso(dtoConcurso)
    *************************AGREGADO***********************
    }
    **********************************************************/

// -------------------------------------------------------------------------------------------------         
   private void almacenarProductosBonificados() throws Exception
   {
      traza("--- almacenarProductosBonificados");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);

	  String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
	  traza("sOpcionMenu: " + sOpcionMenu);
      
      this.pagina("salidaGenerica");

      // inc. 20335
      //******************AGREGADO********************
                   
      DTOConcurso dtoConcurso = null; 
      dtoConcurso = this.getConcurso();
      if ("nueva version".equals(opcionMenu)) {
           traza("Obtiene de Sesion");
           dtoConcurso = (DTOConcurso) this.
                          conectorParametroSesion("dtoConcursoBufferSS");
      } else {
           dtoConcurso = this.getConcurso();
      }    
      
      //******************AGREGADO********************

	  if ("Modificar Concurso".equals(sOpcionMenu) && !indDatosObligatorios.booleanValue() ){ 
		dtoConcurso.setIndBorradoProductosBonificados(Boolean.TRUE);
	  }
      
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
            
      traza("dtoConcurso: " + dtoConcurso);
      dtoConcurso.setIndObligProductosBonificados(indDatosObligatorios);
      
      if ( indDatosObligatorios.booleanValue() )
         dtoConcurso.setIndObligProductos(indDatosObligatorios);
         
      dtoConcurso.setIndProductosBonificados(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcurso.getProductosBonificados();      
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
      
      traza("sDatosObligatorios: " + sDatosObligatorios);
      traza("sOidTipoProducto: " + sOidTipoProducto);
      traza("sIndComunicacion: " + sIndComunicacion);
      traza("sCodigoMensaje: "  + sCodigoMensaje);
      traza("sLista: " + sLista);      
      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      traza("1");
      ArrayList aList = this.parseaListaEditable(sLista, "bonificado");
         
      traza("2");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));
      traza("3");
      if ( sIndComunicacion.equals("S") ){
         traza("4");
         dtoProducto.setIndComunicacion(new Boolean(true));
      }
      else{
         traza("5");      
         dtoProducto.setIndComunicacion(new Boolean(false));
      }
             traza("6");
      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
             traza("7");
      dtoConcurso.setProductosBonificados(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcurso);
      
      if ("nueva version".equals(opcionMenu)) {
           traza("Sube a dtoConcursoBufferSS");
           this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcurso);
      } else {
           this.setConcurso(dtoConcurso);
      }    

      //this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcursoBuffer);
      
            traza("8");
   }
   
// -------------------------------------------------------------------------------------------------         
   private void almacenarProductosExcluidosCalificacion() throws Exception
   {
      traza("--- almacenarProductosExcluidosCalificacion");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
	  traza("sOpcionMenu: " + sOpcionMenu);

      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);
      
      this.pagina("salidaGenerica");
      
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
      DTOConcurso dtoConcursoBuffer = this.getConcurso();      
      traza("dtoConcurso: " + dtoConcursoBuffer);
      dtoConcursoBuffer.setIndObligProductosExcluidosCalificacion(indDatosObligatorios);
      dtoConcursoBuffer.setIndProductosExcluidosCalificacion(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcursoBuffer.getProductosExcluidosCalificacion();   
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
      
      traza("sDatosObligatorios: " + sDatosObligatorios);
      traza("sOidTipoProducto: " + sOidTipoProducto);
      traza("sIndComunicacion: " + sIndComunicacion);
      traza("sCodigoMensaje: "  + sCodigoMensaje);
      traza("sLista: " + sLista);      

	  if ("Modificar Concurso".equals(sOpcionMenu) && !indDatosObligatorios.booleanValue() ){ 
		 dtoConcursoBuffer.setIndBorradoProdExcluidosCalificacion(Boolean.TRUE);
	  }

      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "excluidoClasificacion");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
         dtoProducto.setIndComunicacion(new Boolean(true));
      else
         dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
      dtoConcursoBuffer.setProductosExcluidosCalificacion(dtoProducto);
      
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcursoBuffer);
      //this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcursoBuffer);
      this.setConcurso(dtoConcursoBuffer);      
      //dtoConcursoBuffer.getProductosValidos().setOidTipoProducto(new Long(sOidTipoProducto));
     
   }
   
// -------------------------------------------------------------------------------------------------         
   private void almacenarProductosACalificar() throws Exception
   {
      traza("--- almacenarProductosACalificar");   
      String sDatosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
      String sLista = this.conectorParametroLimpia("hlstProductos", "", true);
      String sOidTipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      String sIndComunicacion = this.conectorParametroLimpia("hchkComunicacion", "", true);
      String sCodigoMensaje = this.conectorParametroLimpia("htxtCodigoMensaje", "", true);
      String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
	  traza("sOpcionMenu: " + sOpcionMenu);

      Boolean indDatosObligatorios = new Boolean(sDatosObligatorios);
      
      this.pagina("salidaGenerica");
      
      DTOConcurso dtoConcursoBuffer = this.getConcurso();
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
      traza("dtoConcurso: " + dtoConcursoBuffer);
      dtoConcursoBuffer.setIndObligProductosACalificar(indDatosObligatorios);
      dtoConcursoBuffer.setIndProductosACalificar(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcursoBuffer.getProductosACalificar();      
      if (dtoProducto == null)
         dtoProducto = new DTOProducto();
         
      traza("sDatosObligatorios: " + sDatosObligatorios);
      traza("sOidTipoProducto: " + sOidTipoProducto);
      traza("sIndComunicacion: " + sIndComunicacion);
      traza("sCodigoMensaje: "  + sCodigoMensaje);
      traza("sLista: " + sLista);      

	  /* If opcion Menu = Modificar Concurso && !sDatosObligatorios */ 
	  if ("Modificar Concurso".equals(sOpcionMenu) && !indDatosObligatorios.booleanValue() ){ 
		 dtoConcursoBuffer.setIndBorradoProdACalificar(Boolean.TRUE);
	  }

      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "aCalificar");

      dtoProducto.setLstProductos(aList);
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
         dtoProducto.setIndComunicacion(new Boolean(true));
      else
         dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje);
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));      
      
      
      dtoConcursoBuffer.setProductosACalificar(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcursoBuffer);
      this.setConcurso(dtoConcursoBuffer);
      //this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcursoBuffer);
   }
   
   
   
   
// -------------------------------------------------------------------------------------------------         
   private ArrayList parseaListaEditable(String sCadena, String tipoProducto) throws Exception
   {
   
      traza("--- parseaListaEditable");
      traza("tipoProducto: " + tipoProducto);
      // Parsea la cadena de entrada, que tiene el formato [...@...@...|...@...@...] 
      // (separa las filas de la LE con "|" y las celdas dentro de cada fila con "@"
      ArrayList aList = new ArrayList();
      
      if ( sCadena != null && !sCadena.equals("") ) 
      {
         // Primero quita los "[", "]".
         sCadena = sCadena.substring(1, sCadena.length()-1); // "["
         sCadena = sCadena.substring(0, sCadena.length());
         
         traza("sCadena sin []: " + sCadena);
         
         // Llama al método correspondiente al tipo de Producto, para que parsee la cadena
         // de acuerdo al formato de lista respectivo. 
         if (tipoProducto.equals("valido") || tipoProducto.equals("aCalificar"))
           aList = this.parseaListaValidos(sCadena);
           
         if (tipoProducto.equals("excluido") || tipoProducto.equals("excluidoClasificacion"))
           aList = this.parseaListaExcluidos(sCadena);
         
         // Modificado por ssantana, 17/6/2005 
         // Inc. 18900. - Ahora Excluidos Clasificacion es igual a Excluidos
         if (tipoProducto.equals("exigido") )
           aList = this.parseaListaExigidos(sCadena);
           
         if (tipoProducto.equals("bonificado")  )
           aList = this.parseaListaBonificados(sCadena);
         
      }
      
      
      return aList; 
   }

// -------------------------------------------------------------------------------------------------         
   private ArrayList parseaListaValidos(String sCadena) throws Exception
   {
     // La lista para tipo prod. "validos" posee el sig. formato: 
     // 
     // - oid
                   // - Marca Producto
                   // - Unidad negocio
                   // - Negocio
                   // - Supergenérico
                   // - Genérico
                   // - Tipo oferta
                   // - Ciclo vida
                   // - Cód. producto
                   // - Tipo oferta
                   // - Ciclo vida
            // - oidMarcaProducto
     // - oidUNegocio
                   // - oidNegocio
                   // - oidSuperGenerico
                   // - oidGenerico
                   // - oidTipoOferta
                   // - oidCicloVida
                   // - oidProducto
                   // - oidTipoOferta
                   // - oidCicloVida
     
     ArrayList aList = new ArrayList(); 
     traza("--- parseaListaValidos()");      
     // Con esto obtenemos las cadenas correspondientes a las filas. 
     StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
     
     while ( sTok.hasMoreTokens() )
     {
         String sFila = sTok.nextToken();
         DTOProdu dtoProdu = new DTOProdu();
         // Con esto separamos cada campo de la cadena de la fila. 
         StringTokenizer sTokFila = new StringTokenizer(sFila, "@");
         
         int i = 0;
         while ( sTokFila.hasMoreTokens()) 
         {
            String sCampo = sTokFila.nextToken();
            traza("i: " + i + " - " + sCampo);            
            switch (i)
            {
                case 0: // Oid.
                  dtoProdu.setOid(null);
                  break;
                  
                case 1: // MarcaProducto
                  dtoProdu.setMarcaProducto((String)quitaEspacio(sCampo, "S"));
                  break;
                  
                case 2: // Unidad Negocio 
                  dtoProdu.setUnidadNegocio((String)quitaEspacio(sCampo, "S"));
                  break;
                    
                case 3: // Negocio 
                  dtoProdu.setNegocio((String)quitaEspacio(sCampo, "S"));
                  break;
                    
                case 4: // Supergenérico
                   dtoProdu.setSupergenerico((String)quitaEspacio(sCampo, "S"));
                   break;
                    
                case 5: // Generico
                  dtoProdu.setGenerico((String)quitaEspacio(sCampo, "S"));
                  break;

                case 6: // Tipo Oferta
                  dtoProdu.setTipoOferta((String)quitaEspacio(sCampo, "S"));
                  break; 
                    
                case 7: // Ciclo Vida
                  dtoProdu.setCicloVida((String)quitaEspacio(sCampo, "S"));
                  break;
                    
                case 8: // Codigo Producto
                  dtoProdu.setCodigoProducto((String)quitaEspacio(sCampo, "S"));
                  break; 
                  
                case 9: // Tipo Oferta (Aparición en el 2do bloque)
                  // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                  // y por lo tanto no se toca. 
                  // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                  // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                  // (por logica de pantalla), por lo que no habria problema 
                  // en realizar el if de chequeo. 
                  if ( dtoProdu.getTipoOferta() == null)
                    dtoProdu.setTipoOferta((String)quitaEspacio(sCampo, "S"));
                  break;
                  
                case 10: // Ciclo Vida, idem a Tipo Oferta
                  if ( dtoProdu.getCicloVida() == null )
                      dtoProdu.setCicloVida((String)quitaEspacio(sCampo, "S"));
                  break;
                  
                case 11: // OidMarcaProducto
                  dtoProdu.setOidMarcaProducto((Long)quitaEspacio(sCampo, "L"));
                  break;
                
                case 12: // OidUNegocio
                  dtoProdu.setOidUnidadNegocio((Long)quitaEspacio(sCampo, "L"));
                  break;
                
                case 13: // OidNegocio
                  dtoProdu.setOidNegocio((Long)quitaEspacio(sCampo, "L"));
                  break;
                
                case 14: // OidSuperGenerico
                  dtoProdu.setOidSupergenerico((Long)quitaEspacio(sCampo, "L"));
                  break;
                  
                case 15: // OidGenerico
                  dtoProdu.setOidGenerico((Long)quitaEspacio(sCampo, "L"));
                  break;
                
                case 16: // OidTipoOferta
                  dtoProdu.setOidTipoOferta((Long)quitaEspacio(sCampo, "L"));
                  break;
                  
                case 17: // OidCicloVida
                  dtoProdu.setOidCicloVida((Long)quitaEspacio(sCampo, "L"));
                  break;

                case 18: // OidProducto
                  dtoProdu.setOidProducto((Long)quitaEspacio(sCampo, "L"));
                  break;
                  
                case 19: // Idem case 9 y 10, pero con los oids. 
                  if (dtoProdu.getOidTipoOferta() == null)
                    dtoProdu.setOidTipoOferta((Long)quitaEspacio(sCampo, "L"));
                  break;
                
                case 20: // Idem case 9 y 10, pero con los oids. 
                  if (dtoProdu.getOidCicloVida() == null)
                    dtoProdu.setOidCicloVida((Long)quitaEspacio(sCampo, "L"));
                  break;
                
            }
            i++;   
         }
         
         aList.add(dtoProdu);
         traza("dtoProdu: " + dtoProdu);         
     }
     
     return aList;
     
   }
   
// -------------------------------------------------------------------------------------------------         
   private ArrayList parseaListaExcluidos(String sCadena) throws Exception
   {
      /*  La lista "Productos Excluidos" tiene el siguiente formato de columna:
        * 
        * - Oid
        * - Marca Producto
        * - Unidad Negocio
        * - Negocio
        * - SuperGenerico
        * - Generico
        * - Tipo Oferta
        * - Ciclo Vida
        * - Codigo Producto
        * - Tipo Oferta 
        * - Ciclo Vida 
        * - Periodo Desde
        * - Periodo Hasta
        * - OidMarcaProducto
        * - oidUnidadNegocio
        * - oidNegocio
        * - oidSuperGenerico
        * - oidGenerico
        * - oidTipoOferta
        * - oidCicloVida
        * - oidCodigoProducto
        * - oidTipoOferta
        * - oidCicloVida
        * - oidPeriodoDesde
        * - oidPeriodoHasta
        * 
        */
  
   
        ArrayList aList = new ArrayList(); 
        traza("--- parseaListaExcluidos()");      
        // Con esto obtenemos las cadenas correspondientes a las filas. 
        StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
     
        while ( sTok.hasMoreTokens() ) 
        {
             String sFila = sTok.nextToken();
             DTOProdu dtoProdu = new DTOProdu();
             // Con esto separamos cada campo de la cadena de la fila. 
             StringTokenizer sTokFila = new StringTokenizer(sFila, "@");
           
             int i = 0;
             while ( sTokFila.hasMoreTokens())  
             { 
                 String sCampo = sTokFila.nextToken();
                 traza("i: " + i + " - " + sCampo);                 
                 switch (i)
                 {
                    case 0: // Oid 
                      dtoProdu.setOid(null);
                      break;
                      
                    case 1: // Marca Producto
                      dtoProdu.setMarcaProducto((String)quitaEspacio(sCampo, "S"));
                      break;
                    
                    case 2: // Unidad Negocio
                      dtoProdu.setUnidadNegocio((String)quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 3: // Negocio
                      dtoProdu.setNegocio((String)quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 4: // SuperGenerico
                      dtoProdu.setSupergenerico((String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 5: // Generico
                      dtoProdu.setGenerico((String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 6: // Tipo Oferta
                      dtoProdu.setTipoOferta((String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 7: // Ciclo Vida
                      dtoProdu.setCicloVida((String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 8: // Codigo Producto 
                      dtoProdu.setCodigoProducto((String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 9: // Tipo Oferta (Aparición en el 2do bloque)
                             // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                             // y por lo tanto no se toca. 
                             // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                             // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                             // (por logica de pantalla), por lo que no habria problema 
                             // en realizar el if de chequeo. 
                             
                      if ( dtoProdu.getTipoOferta() == null)
                         dtoProdu.setTipoOferta( (String)quitaEspacio(sCampo, "S") );
                      break;
                      
                    case 10: // Idem case 9.
                      if ( dtoProdu.getCicloVida() == null)
                         dtoProdu.setCicloVida( (String)quitaEspacio(sCampo, "S") );
                      break;
                      
                    case 11: // Periodo Desde
                      dtoProdu.setPeriodoDesde( (String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 12: // Periodo Hasta
                      dtoProdu.setPeriodoHasta( (String) quitaEspacio(sCampo, "S"));
                      break;
                      
                    case 13: // oidMarcaProducto
                      dtoProdu.setOidMarcaProducto( (Long) quitaEspacio(sCampo, "L"));
                      break;
                  
                    case 14: // oidUnidadNegocio 
                      dtoProdu.setOidUnidadNegocio( (Long)quitaEspacio(sCampo, "L") );
                      break;
                      
                    case 15: // oidNegocio
                      dtoProdu.setOidNegocio( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 16: // oidSuperGenerico
                      dtoProdu.setOidSupergenerico( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 17: // oidGenerico
                      dtoProdu.setOidGenerico( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 18: // oidTipoOferta
                      dtoProdu.setOidTipoOferta( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 19: // oidCicloVida
                      dtoProdu.setOidCicloVida( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 20: // oidProducto
                      dtoProdu.setOidProducto( (Long)quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 21: // oidTipoOferta (Idem case 9 y 10) 
                      if (dtoProdu.getOidTipoOferta() == null)
                         dtoProdu.setOidTipoOferta( (Long) quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 22: // oidCicloVida (Idem case 9 y 10)
                      if (dtoProdu.getOidCicloVida() == null)
                         dtoProdu.setOidCicloVida( (Long) quitaEspacio(sCampo, "L"));
                      break;
                      
                    case 23: // oidPeriodoDesde
                      dtoProdu.setOidPeriodoDesde( (Long) quitaEspacio(sCampo, "L"));
                      break;
                    
                    case 24: // oidPeriodoHasta
                      dtoProdu.setOidPeriodoHasta( (Long) quitaEspacio(sCampo, "L"));
                      break;

                 } // Fin switch
                 i++;
   
            } // Fin inner while
            
            aList.add(dtoProdu);
            traza("dtoProdu: " + dtoProdu);         

      } // Fin outer while
      return aList;
      
   }
   
// -------------------------------------------------------------------------------------------------         
  private ArrayList parseaListaExigidos(String sCadena) throws Exception   
  {
    /*  La lista "productos exigidos" tiene el siguiente formato:
     * 
     * Oid - 0 
     * MarcaProducto
     * Unid. Negocio
     * Negocio
     * SuperGenerico
     * Generico - 5 
     * TipoOferta
     * CicloVida
     * CodigoProducto
     * TipoOferta
     * CicloVida - 10
     * Periodo Desde
     * PeriodoHasta
     * Unidades Exigidas
     * Monto Exigido
     * Puntos Exigidos - 15
     * oidMarcaProducto 
     * oidUnidadNegocio
     * oidNegocio
     * oidSuperGenerico
     * oidGenerico - 20
     * oidTipo Oferta
     * oidCicloVida
     * Cod. Producto
     * oidTipo Oferta
     * oidCiclo Vida - 25
     * oidPeriodoDesde
     * oidPeriodoHasta
     * 
     */
     
      ArrayList aList = new ArrayList(); 
      traza("--- parseaListaExigidos()");      
      // Con esto obtenemos las cadenas correspondientes a las filas. 
      StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
      
      while ( sTok.hasMoreTokens() ) 
      {
           String sFila = sTok.nextToken();
           DTOProdu dtoProdu = new DTOProdu();
           // Con esto separamos cada campo de la cadena de la fila. 
           StringTokenizer sTokFila = new StringTokenizer(sFila, "@");
           
           int i = 0;
           while ( sTokFila.hasMoreTokens())  
           { 
                String sCampo = sTokFila.nextToken();
                traza("i: " + i + " - " + sCampo);                
                switch (i)
                {
                  case 0: // oid 
                    dtoProdu.setOid(null);
                    break;
                    
   /*  * MarcaProducto
     * Unid. Negocio
     * Negocio
     * SuperGenerico
     * Generico
     * TipoOferta
     * CicloVida
     * CodigoProducto
     * TipoOferta
     * CicloVida
     * Periodo Desde
     * PeriodoHasta*/
                  
                  case 1: // Marca Producto 
                    dtoProdu.setMarcaProducto( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 2: // Unidad Negocio
                    dtoProdu.setUnidadNegocio( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 3: // Negocio
                    dtoProdu.setNegocio( (String)quitaEspacio(sCampo, "S"));
                    break;
                
                  case 4: // SuperGenerico
                    dtoProdu.setSupergenerico( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 5: // Generico
                    dtoProdu.setGenerico( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 6: // Tipo Oferta
                    dtoProdu.setTipoOferta( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 7: // Ciclo Vida
                    dtoProdu.setCicloVida( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 8: // Codigo Producto
                    dtoProdu.setCodigoProducto( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 9: // Tipo Oferta (Aparición en el 2do bloque)
                             // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                             // y por lo tanto no se toca. 
                             // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                             // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                             // (por logica de pantalla), por lo que no habria problema 
                             // en realizar el if de chequeo. 
                    if ( dtoProdu.getTipoOferta() == null)
                        dtoProdu.setTipoOferta( (String)quitaEspacio(sCampo, "S"));
                    break;
                    
                  case 10: // Ciclo Vida (idem case 9)
                     if ( dtoProdu.getCicloVida() == null)
                         dtoProdu.setCicloVida( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 11: // Ind Agrup
                      dtoProdu.setIndAgrup((String)quitaEspacio(sCampo, "S"));
                      break;
                      
                  case 12: // Periodo Desde
                     dtoProdu.setPeriodoDesde( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 13: // Periodo Hasta
                     dtoProdu.setPeriodoHasta( (String)quitaEspacio(sCampo, "S"));
                     break;
                  
                  case 14: // Unidades Exigidas
                     if ( !sCampo.equals(" ") )
                        sCampo = this.desFormatearNumero(sCampo, this.FORMATO_DEFAULT);
                     dtoProdu.setUnidadesExigidas((Integer) quitaEspacio(sCampo, "I"));
                     break;
                    
                  case 15: // Monto Exigido
                    if ( !sCampo.equals(" ") )
                      sCampo = this.desFormatearNumero(sCampo, this.FORMATO_DEFAULT);
                    dtoProdu.setMontoExigido((BigDecimal) quitaEspacio(sCampo, "Big"));
                    break;
                    
                  case 16: // Puntos Exigidos
                    if ( !sCampo.equals(" ") )
                      sCampo = this.desFormatearNumero(sCampo, this.FORMATO_DEFAULT);
                    dtoProdu.setPuntosExigidos( (Integer)quitaEspacio(sCampo, "I"));
                    break;
                    
                  case 17: // oidMarcaProduco
                    dtoProdu.setOidMarcaProducto( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 18: // oidUnidadNegocio
                    dtoProdu.setOidUnidadNegocio( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 19: // oidNegocio
                    dtoProdu.setOidNegocio( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 20: // oidSuperGenerico
                    dtoProdu.setOidSupergenerico( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 21: // oidGenerico
                    dtoProdu.setOidGenerico( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 22: // oidTipoOferta
                    dtoProdu.setOidTipoOferta( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 23: // oidCicloVida
                    dtoProdu.setOidCicloVida( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 24: // oidProducto
                    dtoProdu.setOidProducto( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 25: // Oid Tipo Oferta (Aparición en el 2do bloque)
                             // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                             // y por lo tanto no se toca. 
                             // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                             // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                             // (por logica de pantalla), por lo que no habria problema 
                             // en realizar el if de chequeo. 
                    if ( dtoProdu.getOidTipoOferta() == null)
                      dtoProdu.setOidTipoOferta( (Long)quitaEspacio(sCampo, "L"));
                    break;

                  case 26: // idem case 24 pero para oid Ciclo Vida
                      if ( dtoProdu.getOidCicloVida() == null)
                        dtoProdu.setOidCicloVida( (Long)quitaEspacio(sCampo, "L"));
                      break;

                  case 27: // CodIndAgrup
                      dtoProdu.setCodIndAgrup((String)quitaEspacio(sCampo, "S"));
                      break;
                    
                  case 28: // Oid Periodo desde
                    dtoProdu.setOidPeriodoDesde( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 29: // oid Periodo Hasta
                    dtoProdu.setOidPeriodoHasta( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                } // Fin switch
                i++;
           } // Fin inner  while
           aList.add(dtoProdu);
           traza("dtoProdu: " + dtoProdu);         

      } // Fin outer while
      
      return aList;
  
  }
   
 // -------------------------------------------------------------------------------------------------         
  private ArrayList parseaListaBonificados(String sCadena) throws Exception   
  {
  
      /* La Lista "Productos Bonificados" tiene el siguiente formato:
        * 
        * Oid  - 0
        * Marca Producto
        * Unidad Negocio
        * Negocio
        * SuperGenerico
        * Generico     - 5
        * Tipo Oferta 
        * Ciclo Vida
        * Codigo Producto
        * Tipo Oferta
        * Ciclo Vida
        * Periodo Desde   - 11
        * Periodo Hasta   
        * Puntos Unidad   - 13
        * Factor Multiplicidad
        * oidMarcaProducto
        * oidUnidadNegocio
        * oidNegocio
        * oidSuperGenerico
        * oidGenerico
        * oidTipoOferta
        * oidCicloVida    - 21
        * oidProducto
        * oidTipoOferta
        * oidCicloVida
        * oidPeriodo Desde
        * oidPeriodo Hasta
        */
        
      ArrayList aList = new ArrayList(); 
      traza("--- parseaListaBonificados()");      
      // Con esto obtenemos las cadenas correspondientes a las filas. 
      StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
      
      while ( sTok.hasMoreTokens() ) 
      {
           String sFila = sTok.nextToken();
           DTOProdu dtoProdu = new DTOProdu();
           // Con esto separamos cada campo de la cadena de la fila. 
           StringTokenizer sTokFila = new StringTokenizer(sFila, "@");
           
           int i = 0;
           while ( sTokFila.hasMoreTokens())  
           { 
                String sCampo = sTokFila.nextToken();
                traza("i: " + i + " - " + sCampo);
                switch (i)
                {
                  case 0: // oid 
                    dtoProdu.setOid(null);
                    break;
                    
                  case 1: // Marca Producto
                     dtoProdu.setMarcaProducto( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 2: // Unidad Negocio
                     dtoProdu.setUnidadNegocio( (String)quitaEspacio(sCampo, "S"));
                     break;
                  
                  case 3: // Negocio
                     dtoProdu.setNegocio( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 4: // SuperGenerico
                     dtoProdu.setSupergenerico( (String)quitaEspacio(sCampo, "S"));
                     break;
                  
                  case 5: // Generico
                     dtoProdu.setGenerico( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 6: // Tipo Oferta
                     dtoProdu.setTipoOferta( (String)quitaEspacio(sCampo, "S"));
                     break;
                    
                  case 7: // Ciclo Vida
                     dtoProdu.setCicloVida( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 8: // Codigo Producto
                     dtoProdu.setCodigoProducto( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 9: // Tipo Oferta
                           // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                           // y por lo tanto no se toca. 
                           // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                           // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                           // (por logica de pantalla), por lo que no habria problema 
                           // en realizar el if de chequeo. 
                     if (dtoProdu.getTipoOferta() == null)
                         dtoProdu.setTipoOferta( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 10:  // Ciclo Vida - Idem case 9 para Tipo Oferta
                     if (dtoProdu.getCicloVida() == null)
                         dtoProdu.setCicloVida( (String)quitaEspacio(sCampo, "S"));
                      break;
                      
                  case 11:  // Periodo Desde
                     dtoProdu.setPeriodoDesde( (String)quitaEspacio(sCampo, "S"));
                     break;
                     
                  case 12: // Periodo Hasta
                     dtoProdu.setPeriodoHasta( (String)quitaEspacio(sCampo, "S"));
                     break;
                    
                  case 13: // Puntos Unidad
                    if ( !sCampo.equals(" "))
                      sCampo = this.desFormatearNumero(sCampo, this.FORMATO_DEFAULT);

                    Integer iCampo = (Integer)quitaEspacio(sCampo, "I");
                    if ( iCampo == null ) 
                      iCampo = new Integer(0);
                      
                    dtoProdu.setPuntosUnidad( iCampo );
                    break;
                  
                  case 14: // Factor Multiplicidad 
                    if ( !sCampo.equals(" "))
                      sCampo = this.desFormatearNumero(sCampo, this.FORMATO_DEFAULT);
                    
                    iCampo = (Integer)quitaEspacio(sCampo, "I");
                    if ( iCampo == null ) 
                      iCampo = new Integer(0);
                    
                    dtoProdu.setFactorMultiplicidad( iCampo );
                    break;
                    
                  case 15: // oidMarcaProducto
                    dtoProdu.setOidMarcaProducto( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 16: // oidUnidadNegocio
                    dtoProdu.setOidUnidadNegocio( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 17: // oidNegocio
                    dtoProdu.setOidNegocio( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 18: // oidSuperGenerico  
                    dtoProdu.setOidSupergenerico( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 19: // oidGenerico
                    dtoProdu.setOidGenerico( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 20: // oidTipoOferta
                    dtoProdu.setOidTipoOferta( (Long)quitaEspacio(sCampo, "L"));
                    break;
                  
                  case 21: // oidCicloVida
                    dtoProdu.setOidCicloVida( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 22: // oidProducto
                    dtoProdu.setOidProducto( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 23:  // Oid Tipo Oferta (Aparición en el 2do bloque)
                             // Si ya tiene valor, entonces se cargó para el 1er bloque (case 6) 
                             // y por lo tanto no se toca. 
                             // Si no tiene valor, AUN puede haberse cargado como vacío en el 1er bloque (es opcional) 
                             // pero entonces este 2do bloque NUNCA podria contener un valor en ese caso, 
                             // (por logica de pantalla), por lo que no habria problema 
                             // en realizar el if de chequeo. 
                    if (dtoProdu.getOidTipoOferta() == null)
                      dtoProdu.setOidTipoOferta( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 24: // Idem case 22, pero para oid ciclo Vida.
                    if (dtoProdu.getOidCicloVida() == null)
                      dtoProdu.setOidCicloVida( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 25: // oidPeriodo Desde
                    dtoProdu.setOidPeriodoDesde( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                  case 26: // oidPeriodo Hasta
                    dtoProdu.setOidPeriodoHasta( (Long)quitaEspacio(sCampo, "L"));
                    break;
                    
                } // Fin switch
                i++;
        
           } // Fin inner while
           
           //  By ssantana, 27/7/2005, inc. 20146, si Puntos Unidad o Factor Multiplicidad
           //  es NULL, entonces le setea un 1 (uno).
           aList.add(dtoProdu);
           traza("dtoProdu: " + dtoProdu);         
           
      } // Fin outer while
        
      return aList;
        
        
  
  
  
  
  }
  
   
// -------------------------------------------------------------------------------------------------     
   private Object quitaEspacio(String sValor, String tipoDato) throws Exception
   {
     // Si el valor es " " (en los metodos de parseo, " " representa que no se introdujo valor)
     // entonces retorna NULL. Si no, retorna el valor corresp. segun su tipo de dato.
     Object oRetorno = null;
     traza("sValor: " + sValor);

     if ( !sValor.equals(" " ) )
     {
        traza("Entro al if");
        if ( tipoDato.equals("I"))
          return new Integer(sValor);
          
        if ( tipoDato.equals("S"))
          return new String(sValor);
         
        if ( tipoDato.equals("L"))
          return new Long(sValor);
         
        if (tipoDato.equals("Big") )
          return new BigDecimal(sValor);
     }
     
     return oRetorno;
 
   }
   
// -------------------------------------------------------------------------------------------------         
  private RecordSet armarRecordSetLista(ArrayList aList, String sLista) throws Exception
  {
    // Recibe un arrayList con objetos DTOProducto y a partir de los mismo, genera un RecordSet
    // con el formato correspondiente, indicado en "lista".
    traza("armarRecordSetLista para lista " + sLista);
    RecordSet r = new RecordSet();

    Vector vCols = this.armarColsIdent(sLista);    
    r.setColumnIdentifiers(vCols);

    String descMarcaProducto = null;
    String descUNegocio = null;
    String descNegocio = null;
    String descSuperGenerico = null;
    String descGenerico = null;
    String descTipoOferta = null;
    String descCicloVida = null;
    String codProducto = null;
    String indAgrup = null;
    String descPeriodoDesde = null;
    String descPeriodoHasta = null;
    Integer unidadesExigidas = null;
    BigDecimal montoExigido = null;
    Integer puntosExigidos = null;
    Integer puntosUnidad = null;
    Integer factorMultiplicidad = null;
    
    Long oidMarcaProducto = null;
    Long oidUNegocio = null;
    Long oidNegocio = null;
    Long oidSuperGenerico = null;
    Long oidGenerico = null;
    Long oidTipoOferta = null;
    Long oidCicloVida = null;
    Long oidProducto = null;
    String codIndAgrup = null;
    Long oidPeriodoDesde = null;
    Long oidPeriodoHasta = null;
    
    
    for ( int i = 0; i < aList.size(); i++)
    {
        traza("Arma fila " + i);
        DTOProdu dtoProdu = (DTOProdu) aList.get(i);
        Vector vFilaNueva = new Vector();
        
        descMarcaProducto = dtoProdu.getMarcaProducto();
        descUNegocio = dtoProdu.getUnidadNegocio();
        descNegocio = dtoProdu.getNegocio();
        descSuperGenerico = dtoProdu.getSupergenerico();
        descGenerico = dtoProdu.getGenerico();
        descTipoOferta = dtoProdu.getTipoOferta();
        descCicloVida = dtoProdu.getCicloVida();
        indAgrup = dtoProdu.getIndAgrup();
        codProducto = dtoProdu.getCodigoProducto();
        
        descPeriodoDesde = dtoProdu.getPeriodoDesde();
        descPeriodoHasta = dtoProdu.getPeriodoHasta();
        unidadesExigidas = dtoProdu.getUnidadesExigidas();
        montoExigido = dtoProdu.getMontoExigido();
        puntosExigidos = dtoProdu.getPuntosExigidos();
        puntosUnidad = dtoProdu.getPuntosUnidad();
        factorMultiplicidad = dtoProdu.getFactorMultiplicidad();
        
        oidMarcaProducto = dtoProdu.getOidMarcaProducto();
        oidUNegocio = dtoProdu.getOidUnidadNegocio();
        oidNegocio = dtoProdu.getOidNegocio();
        oidSuperGenerico = dtoProdu.getOidSupergenerico();
        oidGenerico = dtoProdu.getOidGenerico();
        oidTipoOferta = dtoProdu.getOidTipoOferta();
        oidCicloVida = dtoProdu.getOidCicloVida();
        oidProducto = dtoProdu.getOidProducto();
        codIndAgrup = dtoProdu.getCodIndAgrup();
        oidPeriodoDesde = dtoProdu.getOidPeriodoDesde();
        oidPeriodoHasta = dtoProdu.getOidPeriodoHasta();

        // Campos Comunes a cualquier Lista.         
        vFilaNueva.add("" + i); // Oid (no se usa, asi que no importa el valor)
        vFilaNueva.add(descMarcaProducto);
        vFilaNueva.add(descUNegocio);
        vFilaNueva.add(descNegocio);
        vFilaNueva.add(descSuperGenerico);
        vFilaNueva.add(descGenerico);
        
        // Determina si es el primer o segundo juego de "CicloVida, Oferta" que se 
        // ha de completar. PAra ello chequea el valor del Código de Producto. 
        // Como este campo es obligatorio para su grupo de datos, si tiene valor, entonces 
        // "CicloVida, Oferta", pertenece a "Bloque Producto" (tercer pestaña)
        if ( codProducto != null && !codProducto.equals(""))
        {
           vFilaNueva.add(""); // Tipo Oferta 2ndo Bloque
           vFilaNueva.add(""); // Ciclo Vida 2ndo Bloque
           vFilaNueva.add(codProducto);           
           vFilaNueva.add(descTipoOferta);
           vFilaNueva.add(descCicloVida);
        } else
        {
           vFilaNueva.add(descTipoOferta); // Tipo Oferta 2ndo Bloque
           vFilaNueva.add(descCicloVida); // Ciclo Vida 2ndo Bloque
           vFilaNueva.add(codProducto);          
           vFilaNueva.add("");
           vFilaNueva.add("");
        }
        
        if (sLista.equals("pValidos"))
         ;
        // No hace nada, ya que no hay campos adicionales
         
        if (sLista.equals("pExigidos"))
        {
           vFilaNueva.add(indAgrup);
           vFilaNueva.add(descPeriodoDesde);
           vFilaNueva.add(descPeriodoHasta);
           vFilaNueva.add(unidadesExigidas);
           vFilaNueva.add(montoExigido);
           vFilaNueva.add(puntosExigidos);
        }
        
        if (sLista.equals("pExcluidos"))
        {
           vFilaNueva.add(descPeriodoDesde);
           vFilaNueva.add(descPeriodoHasta);
        }
        
        if (sLista.equals("pBonificados"))
        {
           vFilaNueva.add(descPeriodoDesde);
           vFilaNueva.add(descPeriodoHasta);
           vFilaNueva.add(puntosUnidad);
           vFilaNueva.add(factorMultiplicidad);
        }
        
        // Setea oids Ocultos
        vFilaNueva.add(oidMarcaProducto);
        vFilaNueva.add(oidUNegocio);
        vFilaNueva.add(oidNegocio);
        vFilaNueva.add(oidSuperGenerico);
        vFilaNueva.add(oidGenerico);
        
        if (codProducto != null && !codProducto.equals(""))
        {
            vFilaNueva.add(oidTipoOferta);
            vFilaNueva.add(oidCicloVida);
            vFilaNueva.add(oidProducto);          
            vFilaNueva.add("");
            vFilaNueva.add("");
        } else
        {
            vFilaNueva.add("");
            vFilaNueva.add("");
            vFilaNueva.add(oidProducto);        
            vFilaNueva.add(oidTipoOferta);
            vFilaNueva.add(oidCicloVida);
        }
        
        if(sLista.equals("pExigidos"))
        {
            vFilaNueva.add(codIndAgrup);
            vFilaNueva.add(oidPeriodoDesde);
            vFilaNueva.add(oidPeriodoHasta);
        }
        if(sLista.equals("pExcluidos") || sLista.equals("pBonificados"))
        {
           vFilaNueva.add(oidPeriodoDesde);
           vFilaNueva.add(oidPeriodoHasta);
        }
        
        // Añade la fila al recordset. 
        r.addRow(vFilaNueva);
          
        
    }
    
    return r;
    
    
  }
  

// -------------------------------------------------------------------------------------------------           
  private Vector armarColsIdent(String sLista) throws Exception
  {
      // Retorna los Column Identifiers correspondientes, de acuerdo a la lista indicada en 
      // "sLista"
      traza("--- armaColsIdent() para lista " + sLista);
      Vector vCols = new Vector();
      
      // Esta parte es común a todas las listas. 
      vCols.add("OID");
      vCols.add("DESC_MARCA");
      vCols.add("DESC_UNEGOCIO");
      vCols.add("DESC_NEGOCIO");
      vCols.add("DESC_SUPERGENERICO");
      vCols.add("DESC_GENERICO");
      vCols.add("DESC_TIPOOFERTA");
      vCols.add("DESC_CICLOVIDA");
      vCols.add("COD_PRODUCTO");
      vCols.add("DESC_TIPOOFERTA");
      vCols.add("DESC_CICLOVIDA");
      
      // Ahora setea campos especificos para cada lista. 
      if (sLista.equals("pValidos"))
         ;
          // No agrega nada mas, ya que no hay campos extras.
      
      if (sLista.equals("pExigidos"))
      {
           vCols.add("IND_AGRUP");
           vCols.add("DESC_PERIODO_DESDE");
           vCols.add("DESC_PERIODO_HASTA");
           vCols.add("UNIDADES_EXIGIDAS");
           vCols.add("MONTO_EXIGIDO");
           vCols.add("PUNTOS_EXIGIDOS");
      }
      
      if (sLista.equals("pExcluidos"))
      {
           vCols.add("DESC_PERIODO_DESDE");
           vCols.add("DESC_PERIODO_HASTA");
      }
      
      if (sLista.equals("pBonificados"))
      {
           vCols.add("DESC_PERIODO_DESDE");
           vCols.add("DESC_PERIODO_HASTA");
           vCols.add("PUNTOS_UNIDAD");
           vCols.add("FACTOR_MULTIPLICIDAD");
      }
      
      // Continúa con los campos de Oids (que estarían ocultos en la lista)
      vCols.add("OID_MARCA");
      vCols.add("OID_UNEGOCIO");
      vCols.add("OID_NEGOCIO");
      vCols.add("OID_SUPERGENERICO");
      vCols.add("OID_GENERICO");
      vCols.add("OID_TIPO_OFERTA");
      vCols.add("OID_CICLO_VIDA");
      vCols.add("OID_PRODUCTO");
      vCols.add("OID_TIPO_OFERTA");
      vCols.add("OID_CICLO_VIDA");
      
      if(sLista.equals("pExigidos"))
      {
          vCols.add("COD_IND_AGRUP");
          vCols.add("OID_PERIODO_DESDE");
          vCols.add("OID_PERIODO_HASTA");
      }
      if(sLista.equals("pExcluidos") || sLista.equals("pBonificados"))
      {
          vCols.add("OID_PERIODO_DESDE");
          vCols.add("OID_PERIODO_HASTA");
      }
      
      traza("vCols: " + vCols);
      return vCols;
      
  }
  
  
  private void asignarConstantesTipoProducto() throws Exception {
      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      traza("LPMantenerProductos.asignarConstantesTipoProducto()");
      this.asignarAtributo("VAR", "oidTipoProductoValidos", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());
                                
      this.asignarAtributo("VAR", "oidTipoProductoExcluidos", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.toString());
                                
      this.asignarAtributo("VAR", "oidTipoProductoBonificados", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS.toString());
                                
      this.asignarAtributo("VAR", "oidTipoProductoExigidos", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS.toString());
                                
      this.asignarAtributo("VAR", "oidTipoProductoACalificar", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_A_CALIFICAR.toString());
                                
      this.asignarAtributo("VAR", "oidTipoProductoExcluidosCalificacion", "valor", 
                                ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION.toString());
      // Fin Modificacion ssantana, 17/6/2005
    
  }
         
}

