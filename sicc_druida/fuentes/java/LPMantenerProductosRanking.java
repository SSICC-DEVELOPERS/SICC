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
import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.Vector;


public class LPMantenerProductosRanking extends LPIncentivosRanking {
  public LPMantenerProductosRanking() {
    super();  
  }
  
  public void inicio() throws Exception {        
    this.obtenerFlagsPestanyas();
    pagina("contenido_productos_mantener_ranking");    
    this.cargarFlagsPestanyas();
    this.getFormatosValidaciones();
  }
  
  
  
  public void ejecucion() throws Exception {
		try {

			accion = this.conectorParametroLimpia("accion", "", true);      
			opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
			//ocultarPestanyas = this.conectorParametroLimpia("ocultarPestanyas", "", true);

			this.setTrazaFichero();
			traza(" ********* Entrando a LPMantenerProductos **********");         
			traza("--- Accion: " + accion);
			traza("--- opcionMenu: " + opcionMenu);

      this.obtenerFlagsPestanyas();
			 
			if (accion.equals("") )
			 {
				// Inc. 17557
				this.cargarPantalla(ConstantesINC.IND_GRUPO_PRODUCTO_0);
			 } else if (accion.equals("mantener") )
			 {
				  this.seleccionarCargarPantalla();
			 } else if (accion.equals("almacenar") ) 
			 {
				  this.almacenar(); 
			 } else if (accion.equals("guardar") )
			 {
			   // No hace falta almacenar, ya que el almacenar() se llamó al darle
			   // Aceptar dentro de la Modal.
			   this.guardar();
			 } else if (accion.equals("redirigir") )
			 {
			   this.redirigir();
			 }
           
			 
       if(opcionMenu.equals("Crear Concurso Ranking")){
           asignarAtributoPagina("cod", "0508");
       } else if(opcionMenu.equals("Consultar Concurso Ranking")){
           asignarAtributoPagina("cod", "0525");
       } else if(opcionMenu.equals("Modificar Concurso Ranking")){
           asignarAtributoPagina("cod", "0524");
       }
		  } catch (Exception ex)
		  {
			ex.printStackTrace();
			this.lanzarPaginaError(ex);
		  }  
  
  
  }
  
// -------------------------------------------------------------------------------------------------        
   public void cargarPantalla() {}

// -------------------------------------------------------------------------------------------------      
   private void cargarPantalla(Integer indGrupo) throws Exception
   { 
      traza("cargarPantalla(Integer indGrupo)");
      traza("indGrupo " + indGrupo);
      
      // String sOpcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
      this.pagina("contenido_productos_mantener_ranking");
      this.getFormatosValidaciones();
      this.getConfiguracionMenu("LPMantenerProductosRanking", "");
      
      //this.asignarAtributoPagina("cod", "0491");
      this.cargarFlagsPestanyas();

      String dato = conectorParametroLimpia("valorMenu", "", true);
      traza("dato " + dato);
      
      if (!dato.equals("")){
            traza("aca");
            this.asignarAtributo("VAR", "valorMenu", "valor", "no"); 
      
      }
      
      DTOTipoProducto dtoTipo = new DTOTipoProducto();
      
      dtoConcurso = this.getConcurso();
      
      dtoTipo.setOidPais(dtoConcurso.getOidPais());
      dtoTipo.setOidIdioma(dtoConcurso.getOidIdioma());
      dtoTipo.setIndGrupoProducto(indGrupo);

      ComposerViewElementList cViewList = new ComposerViewElementList();
      ComposerViewElement cElement = new ComposerViewElement();
      cElement.setIDBusiness("INCObtenerTiposProductoRanking");
      cElement.setDTOE(dtoTipo);
      
      cViewList.addViewElement(cElement);
      
      ConectorComposerView cComposerView = new ConectorComposerView(cViewList, this.getRequest());
      cComposerView.ejecucion();
      DruidaConector con = cComposerView.getConector();
      this.asignar("COMBO", "cbProductos", con, "INCObtenerTiposProductoRanking");

	    this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);      
      
  }
  
  
// ---------------------------------------------------------------------------------------------------------------    
    private void seleccionarCargarPantalla() throws Exception
    {
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
      }   
      
    }
    
    
// ---------------------------------------------------------------------------------------------------------------    
    private void cargarPantallaProductosValidos() throws Exception
    {
        traza("Entra a cargarPantallaProductosValidos()");
        
        String descProducto= this.conectorParametroLimpia("descCombo", "", true);
        String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
        opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
        
        traza("descProducto: " + descProducto);
        traza("oidTipoProducto: " + oidTipoProducto);        
        
        this.pagina("contenido_productos_mantener_detalle_ranking");
        //this.asignarAtributoPagina("cod", "0491");
        
        this.getFormatosValidaciones();
        
        DruidaConector con = this.cargaPantallaGeneral();
        DTOConcurso dtoConcurso = this.getConcurso();
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
        this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
        traza("5");        
        this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");        
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
        
        this.asignarAtributo("VAR", "hOidMarca", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
        
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
      if (opcionMenu.equals("Consultar Concurso Ranking"))
      {
         traza("Es Consulta, deshabilita TODOS los campos...");
         sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
         this.getConfiguracionMenu("LPMantenerProductosRanking", "detalleConsulta");          
      } else {
         traza("Insertar y Modif");
         this.getConfiguracionMenu("LPMantenerProductosRanking", "detalleABM");
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
  
// ---------------------------------------------------------------------------------------------------------------
    private void cargarPantallaProductosExcluidos() throws Exception
    {
        traza("Entra a cargarPantallaProductosExcluidos()");
        
        String descProducto= this.conectorParametroLimpia("descCombo", "", true);
        String oidTipoProducto = this.conectorParametroLimpia("oidCombo", "", true);
        opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
        
        traza("descProducto: " + descProducto);
        traza("oidTipoProducto: " + oidTipoProducto);        
        
        this.pagina("contenido_productos_mantener_detalle_ranking");
          //this.asignarAtributoPagina("cod", "0491");
        
        this.getFormatosValidaciones();
        DruidaConector con = this.cargaPantallaGeneral();
        
        DTOConcurso dtoConcurso = this.getConcurso();
        //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");        
        // ********** Hardcodeo ****************      
        //dtoConcurso = new DTOConcurso();
        // ********** Hardcodeo ****************           

        
        traza("Asigna valores a combos...");
        this.asignar("COMBO", "cbMarcaProducto", con, "SEGRecuperarMarcasProductoMP");
        this.asignar("COMBO", "cbUnidadNegocio", con, "MAEObtenerUnidadesNegocioPorPais");
        this.asignar("COMBO", "cbNegocio", con, "MAEObtenerNegocioPorPais");
        this.asignar("COMBO", "cbSupergenerico", con, "MAEObtenerSuperGenericosPorPais");
        this.asignar("COMBO", "cbGenerico", con, "MAEObtenerGenericosPorPais");
        this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");
        this.asignar("COMBO", "cbTipoOferta2", con, "PREObtenerTiposOfertaPorCanal");        
        this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
        this.asignar("COMBO", "cbCicloVida2", con, "PREObtenerCiclosVida");        
        this.asignar("COMBO", "cbPeriodoDesde", con, "CRAObtienePeriodos");        
        this.asignar("COMBO", "cbPeriodoHasta", con, "CRAObtienePeriodos");                
        
        traza("Asigna valores a labels...");
        this.asignarAtributo("LABELC", "lbldtProductos", "valor", descProducto);
        this.asignarAtributo("VAR", "oidTipoProducto", "valor", oidTipoProducto);
        this.asignarAtributo("VAR", "descTipoProducto", "valor", descProducto);     
        
        this.asignarAtributo("VAR", "hOidMarca", "valor", dtoConcurso.getParamGenerales().getOidMarca().toString());
        
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
        
      if (opcionMenu.equals("Consultar Concurso Ranking"))
      {
        traza("Es Consulta, deshabilita TODOS los campos...");
        // Deshabilita TODOS los campos.... 
        sCadena = this.generaCadenaDeshabilitacion("deshabilitarTodos");
        this.getConfiguracionMenu("LPMantenerProductosRanking", "detalleConsulta");          
      } else
      {
        this.getConfiguracionMenu("LPMantenerProductosRanking", "detalleABM");
      }

      // Modificado por ssantana, 17/6/2005
      // Se envían los valores de las Constantes de Tipo de Productos a la pantalla 
      // para posterior uso en Javascript (inc. 18900).
      this.asignarConstantesTipoProducto();
      // Fin Modificacion ssantana, 17/6/2005

      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "listadoAMostrar", "valor", "pExcluidos");
        
   }    
   
// -------------------------------------------------------------------------------------------------     
   private DruidaConector cargaPantallaGeneral() throws Exception
   {
      traza("cargaPantallaGeneral");
      DTOConcurso dtoConcurso = this.getConcurso();
      
      
      //DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");      
      
      DTOBelcorp dtoBelcorp = new DTOBelcorp();
        
      dtoBelcorp.setOidIdioma( dtoConcurso.getOidIdioma() );
      dtoBelcorp.setOidPais( dtoConcurso.getOidPais() );
      
      DTOPeriodo dtoPeriodo = new DTOPeriodo();
      dtoPeriodo.setOidPais(dtoConcurso.getOidPais());
      dtoPeriodo.setMarca(dtoConcurso.getParamGenerales().getOidMarca());
      dtoPeriodo.setCanal(dtoConcurso.getParamGenerales().getOidCanal());
      
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
      ComposerViewElement cElem4 = new ComposerViewElement();
      ComposerViewElement cElem5 = new ComposerViewElement();
      ComposerViewElement cElem6 = new ComposerViewElement();
      ComposerViewElement cElem7 = new ComposerViewElement();
      ComposerViewElement cElem8 = new ComposerViewElement();      
     
      cElem1.setIDBusiness("SEGRecuperarMarcasProductoMP");
      cElem1.setDTOE(dtoOid);
      
      cElem2.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
      cElem2.setDTOE(dtoBelcorp);
      
      cElem3.setIDBusiness("MAEObtenerNegocioPorPais");
      cElem3.setDTOE(dtoBelcorp);
      
      cElem4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
      cElem4.setDTOE(dtoBelcorp);
      
      cElem5.setIDBusiness("MAEObtenerGenericosPorPais");
      cElem5.setDTOE(dtoBelcorp);
      
      cElem6.setIDBusiness("PREObtenerTiposOfertaPorCanal");
      cElem6.setDTOE(dtoOid2);
      
      cElem7.setIDBusiness("PREObtenerCiclosVida");
      cElem7.setDTOE(dtoBelcorp);     
      
      cElem8.setIDBusiness("CRAObtienePeriodos");
      cElem8.setDTOE(dtoPeriodo);    
      
      cView.addViewElement(cElem1);
      cView.addViewElement(cElem2);      
      cView.addViewElement(cElem3);      
      cView.addViewElement(cElem4);      
      cView.addViewElement(cElem5);      
      cView.addViewElement(cElem6);
      cView.addViewElement(cElem7);      
      cView.addViewElement(cElem8);      
      
      ConectorComposerView cConector = new ConectorComposerView(cView, this.getRequest());
      traza("Se conecta");
      cConector.ejecucion();
      traza("Salio de Conectar");
      DruidaConector con = cConector.getConector();
      
      return con;
   
   }   
   
// -------------------------------------------------------------------------------------------------     
   private StringBuffer generaCadenaDeshabilitacion(String tipoProducto) throws Exception
   {
      StringBuffer sCadena = new StringBuffer("");
      if (tipoProducto.equals("pValidos") )
      {
         sCadena.append("cbPeriodoDesde,");
         sCadena.append("cbPeriodoHasta");
		 /* vbongiov -- inc 21867
         sCadena.append("txtPuntosUnidad,");
         sCadena.append("txtFactorMultiplicidad,");
         sCadena.append("txtUnidadesExigidas,");
         sCadena.append("txtMontoExigido,");
         sCadena.append("txtPuntosExigidos");    
		 */
      }
      
      if ( tipoProducto.equals("pExcluidos"))
      { /* vbongiov -- inc 21867
        sCadena.append("txtPuntosUnidad,");
        sCadena.append("txtFactorMultiplicidad,");
        sCadena.append("txtUnidadesExigidas,");
        sCadena.append("txtMontoExigido,");
        sCadena.append("txtPuntosExigidos");
		*/
      }
      
      if ( tipoProducto.equals("deshabilitarTodos") )
      {
        sCadena.append("formulario.cbPeriodoDesde,");
        sCadena.append("formulario.cbPeriodoHasta,");
		/* vbongiov -- inc 21867
        sCadena.append("formulario.txtPuntosUnidad,");
        sCadena.append("formulario.txtFactorMultiplicidad,");
        sCadena.append("formulario.txtUnidadesExigidas,");
        sCadena.append("formulario.txtMontoExigido,");
        sCadena.append("formulario.txtPuntosExigidos,");
		*/
        
        sCadena.append("formulario.cbMarcaProducto,");
        sCadena.append("formulario.cbUnidadNegocio,");
        sCadena.append("formulario.cbNegocio,");
        sCadena.append("formulario.cbSupergenerico,");
        sCadena.append("formulario.cbGenerico,");          
        
        sCadena.append("formulario.txtCodProducto,");
        sCadena.append("formulario.cbTipoOferta2,");
        sCadena.append("formulario.cbCicloVida2");       
      }
      
      traza("Cadena generada: " + sCadena.toString() );      
      
      return sCadena;
     
   }
   
// -------------------------------------------------------------------------------------------------     
   private void asignarVAROculta(Object o, String nombreVariable) throws Exception
   {
     if ( o == null)
        this.asignarAtributo("VAR", nombreVariable, "valor", "");
     else
        this.asignarAtributo("VAR", nombreVariable, "valor", o.toString() );
        
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
        
       if (sLista.equals("pExcluidos"))
       {
          vFilaNueva.add(descPeriodoDesde);
          vFilaNueva.add(descPeriodoHasta);
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
       
       if ( sLista.equals("pExcluidos") )
       {
          vFilaNueva.add(oidPeriodoDesde);
          vFilaNueva.add(oidPeriodoHasta);
       }
       
       // Añade la fila al recordset. 
       r.addRow(vFilaNueva);
         
       
    }
    
    return r;
    
    
  }
  
// --------------------------------------------------------------------------------------------  
  private void asignarConstantesTipoProducto() throws Exception {
      // Asigna las Constantes con los Oid de los Tipo de Productos usados,
      // en VARs en la pantalla.
      traza("LPMantenerProductos.asignarConstantesTipoProducto()");
      
      this.asignarAtributo("VAR", "oidTipoProductoValidos", "valor", 
                            ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.toString());
                            
      this.asignarAtributo("VAR", "oidTipoProductoExcluidos", "valor", 
                            ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.toString());
                            
    
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
      
      if (sLista.equals("pExcluidos"))
      {
          vCols.add("DESC_PERIODO_DESDE");
          vCols.add("DESC_PERIODO_HASTA");
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
      
      /*if ( sLista.equals("pExigidos") || sLista.equals("pExcluidos") || 
           sLista.equals("pBonificados"))*/
      if (sLista.equals("pExcluidos") )
      {
          vCols.add("OID_PERIODO_DESDE");
          vCols.add("OID_PERIODO_HASTA");
      }
      
      traza("vCols: " + vCols);
      return vCols;
      
  }
  
  
// -------------------------------------------------------------------------------------------------     
   public void almacenar() throws Exception
   {
      traza("almacenar()");
      String tipoProducto = this.conectorParametroLimpia("oidTipoProducto", "", true);
      traza("tipoProducto: " + tipoProducto); 
      Long oidTipoProducto = new Long(tipoProducto);
      if ( oidTipoProducto.longValue() ==
                        ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.longValue() )
      {
        this.almacenarProductosValidos();
      }
      
      if ( oidTipoProducto.longValue() == 
                        ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.longValue() )
      { 
        this.almacenarProductosExcluidos();                 
      }
      
   }

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
      
      DTOConcurso dtoConcursoBuffer = this.getConcurso();      
      traza("dtoConcurso: " + dtoConcursoBuffer);
      
      dtoConcursoBuffer.setIndObligProductosValidos(indDatosObligatorios);
      if ( indDatosObligatorios.booleanValue() )
        dtoConcursoBuffer.setIndObligProductos(indDatosObligatorios);
      
      dtoConcursoBuffer.setIndProductosValidos(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcursoBuffer.getProductosValidos();      
      if (dtoProducto == null)
        dtoProducto = new DTOProducto();
        
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      traza("sLista: " + sLista);      
      // Parseo la cadena de la lista, para obtener un arrayList de Productos.
      ArrayList aList = this.parseaListaEditable(sLista, "valido");

      dtoProducto.setLstProductos(aList);      
      dtoProducto.setOidTipoProducto(new Long(sOidTipoProducto));

      if ( sIndComunicacion.equals("S") )
        dtoProducto.setIndComunicacion(new Boolean(true));
      else
        dtoProducto.setIndComunicacion(new Boolean(false));

      dtoProducto.setCodigoMensaje(sCodigoMensaje.equals("")?null:sCodigoMensaje);
      
      dtoConcursoBuffer.setProductosValidos(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcursoBuffer);
      //this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcursoBuffer);
      this.setConcurso(dtoConcursoBuffer);     
      //dtoConcursoBuffer.getProductosValidos().setOidTipoProducto(new Long(sOidTipoProducto));
      
   }
   
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
      
      this.pagina("salidaGenerica");
      
      //DTOConcurso dtoConcursoBuffer = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS");
      DTOConcurso dtoConcursoBuffer = this.getConcurso();      
      traza("dtoConcurso: " + dtoConcursoBuffer);
      dtoConcursoBuffer.setIndObligProductosExcluidos(indDatosObligatorios);
      if ( indDatosObligatorios.booleanValue() )
        dtoConcursoBuffer.setIndObligProductos(indDatosObligatorios);
        
      // Verifica si hay que registros en la base de datos
      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      
      if(opcionMenu.equals("Modificar Concurso Ranking") && !dtoConcursoBuffer.getIndObligProductosExcluidos().booleanValue()) {
           dtoConcursoBuffer.setIndBorradoProductosExcluidos(Boolean.TRUE);
      }

      
      dtoConcursoBuffer.setIndProductosExcluidos(new Boolean(true));
      
      DTOProducto dtoProducto = dtoConcursoBuffer.getProductosExcluidos();      
      if (dtoProducto == null)
        dtoProducto = new DTOProducto();
        
      dtoProducto.setOidPais(UtilidadesSession.getPais(this));
      dtoProducto.setOidIdioma(UtilidadesSession.getIdioma(this));
      
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

      dtoProducto.setCodigoMensaje(sCodigoMensaje.equals("")?null:sCodigoMensaje);
      
      dtoConcursoBuffer.setProductosExcluidos(dtoProducto);
      traza("dtoConcursoBuffer a subir a sesion: " + dtoConcursoBuffer);
      //this.conectorParametroSesion("dtoConcursoBufferSS", dtoConcursoBuffer);
      this.setConcurso(dtoConcursoBuffer);      
      //dtoConcursoBuffer.getProductosValidos().setOidTipoProducto(new Long(sOidTipoProducto));
     
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
        if (tipoProducto.equals("valido") )
          aList = this.parseaListaValidos(sCadena);
          
        if (tipoProducto.equals("excluido") )
          aList = this.parseaListaExcluidos(sCadena);
        
       
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
     traza("--- parseaListaValidos() pais");      
     // Con esto obtenemos las cadenas correspondientes a las filas. 
     StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
     
     while ( sTok.hasMoreTokens() )
     {
        String sFila = sTok.nextToken();
        DTOProdu dtoProdu = new DTOProdu();
        dtoProdu.setOidPais(UtilidadesSession.getPais(this));
        dtoProdu.setOidIdioma(UtilidadesSession.getIdioma(this));
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
       traza("--- parseaListaExcluidos() pais");      
       // Con esto obtenemos las cadenas correspondientes a las filas. 
       StringTokenizer sTok = new StringTokenizer(sCadena, "|"); 
     
       while ( sTok.hasMoreTokens() ) 
       {
            String sFila = sTok.nextToken();
            DTOProdu dtoProdu = new DTOProdu();
            dtoProdu.setOidPais(UtilidadesSession.getPais(this));
            dtoProdu.setOidIdioma(UtilidadesSession.getIdioma(this));
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
   
  
  
}
