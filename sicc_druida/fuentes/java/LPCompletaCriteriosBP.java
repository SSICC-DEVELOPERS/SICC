//import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPCompletaCriteriosBP extends LPSICCBase
{ 
  public void inicio() throws Exception 
  {	
  }

 public void ejecucion() throws Exception
 {
     this.setTrazaFichero();
     //this.rastreo();
     traza("Entra a LPCompletaCriteriosBP");

     try
     {
        
        String accion = this.conectorParametro("accion");
        traza("accion: " + accion);

        if (accion.equals("atributos") )
          this.muestraAtributos();
        if (accion.equals("variables") ) 
          this.muestraVariables();
        if (accion.equals("formula") )
          this.muestraFormulas();
        
     } catch (Exception ex)
     {
        this.lanzarPaginaError(ex);    
        this.traza("Error en ejecucion");
        logStackTrace(ex);

     }


 }

 private void muestraAtributos() throws Exception
 {
     traza("---- muestraAtributos ----");
     DTOBelcorp dtoe = new DTOBelcorp(); 
     DTOOID dtoOid = new DTOOID();
     DTOPeriodo dtoP = new DTOPeriodo();
     
     String sOidPeriodo = this.conectorParametroLimpia("varPeriodo", "", true);
     traza("sOidPeriodo: " + sOidPeriodo);
     
     ComposerViewElementList cList = new ComposerViewElementList();
     ComposerViewElement cElem1 = new ComposerViewElement();
     ComposerViewElement cElem2 = new ComposerViewElement();     
     ComposerViewElement cElem3 = new ComposerViewElement();          
     ComposerViewElement cElem4 = new ComposerViewElement();     
     ComposerViewElement cElem5 = new ComposerViewElement();     
     ComposerViewElement cElem6 = new ComposerViewElement();          

     String sCriterio = this.conectorParametro("varCriterio");
     String sCanal = this.conectorParametro("varCanal");
     String sMarca = this.conectorParametro("varMarca");

     // Variables para Recarga de Pantalla
     String numUnidadesRepartir = this.conectorParametroLimpia("varNumUnidadesCliente", "", true);     
     String subCriterio = this.conectorParametroLimpia("varSubcriterio", "", true);
     String numAniversario = this.conectorParametroLimpia("varNumeroAniversario", "", true);
     String edadDesde = this.conectorParametroLimpia("varEdadDesde", "", true);
     String edadHasta = this.conectorParametroLimpia("varEdadHasta", "", true);
     String monto = this.conectorParametroLimpia("varMonto", "", true);
     String periodoDesde = this.conectorParametroLimpia("varPeriodoDesde", "", true);
     String periodoHasta = this.conectorParametroLimpia("varPeriodoHasta", "", true);     
     String marca = this.conectorParametroLimpia("varMarcaCriterio", "", true);
     String catalogo = this.conectorParametroLimpia("varCatalogo", "", true);
     String unidadNegocio = this.conectorParametroLimpia("varUnidadNegocio", "", true);
     String negocio = this.conectorParametroLimpia("varNegocio", "", true);     
     // Fin variables para Recarga de Pantalla

     
     traza("sCriterio: " + sCriterio);
     traza("sCanal: " + sCanal);
     traza("sMarca: " + sMarca);
     traza("periodoDesde: " + periodoDesde);          
     pagina("contenido_bp_atributos");
     this.getConfiguracionMenu();
     this.getFormatosValidaciones();     
     
    // Agregado por Rafael Romero - SiCC 20070189 - 23/04/2007
    asignarAtributo("VAR", "varEstadoProceso", "valor", this.conectorParametroLimpia("estadoProceso","",true) );
    //Fin Agregado [1]
     
     asignarAtributo("VAR", "hFormatoFechaPais", "valor", UtilidadesSession.getFormatoFecha(this) );

     dtoe.setOidIdioma(UtilidadesSession.getIdioma(this) );
     dtoe.setOidPais(UtilidadesSession.getPais(this) );

     cElem1.setDTOE(dtoe);
     cElem1.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");

     cElem2.setDTOE(dtoe);
     cElem2.setIDBusiness("MAEObtenerNegocioPorPais");

     cElem3.setDTOE(dtoe);
     // Hecho por RRV - Incidencia V-MAV10: Combo de marcas no muestra datos apropiados (2007-01-06)
     // cElem3.setIDBusiness("SEGConsultaMarcas");
     cElem3.setIDBusiness("SEGRecuperarMarcasProducto");

     dtoP.setPais(UtilidadesSession.getPais(this));
     dtoP.setOidPais(UtilidadesSession.getPais(this));
     dtoP.setCanal( Long.valueOf( sCanal ) );
     dtoP.setMarca( Long.valueOf( sMarca ) );
     dtoP.setOid( Long.valueOf(sOidPeriodo) );
     cElem4.setDTOE(dtoP);
     //cElem4.setIDBusiness("MAVObtienePeriodosBP");
     cElem4.setIDBusiness("MAVObtienePeriodosRangoAnyo");
     

     dtoOid.setOid( new Long(sCriterio) );
     cElem5.setDTOE(dtoOid);
     cElem5.setIDBusiness("MAVObtieneSubcriteriosPorCriterio");

     cElem6.setDTOE(dtoe);
     //cElem6.setIDBusiness("PREObtenerCatalogos");
     cElem6.setIDBusiness("MAVCargarCatalagosBP");     


     cList.addViewElement(cElem1);
     cList.addViewElement(cElem2);
     cList.addViewElement(cElem3);     
     cList.addViewElement(cElem4);          
     cList.addViewElement(cElem5);
     cList.addViewElement(cElem6);

     ConectorComposerView conector = new ConectorComposerView(cList, this.getRequest());
     traza("Ejecucion...");     
     conector.ejecucion();
     traza("Luego de Ejecucion...");
     DruidaConector conPantalla = conector.getConector();
     traza("-------------");

     traza("XML: " + conPantalla.getXML().toString() );

     // -------- Asigna Valores a Combos de Periodo --------------------------
     asignar("COMBO", "cbPeriodoDesde1", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta1", conPantalla, "MAVObtienePeriodosRangoAnyo");     
     asignar("COMBO", "cbPeriodoDesde2", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta2", conPantalla, "MAVObtienePeriodosRangoAnyo");     
     asignar("COMBO", "cbPeriodoDesde3", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta3", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoDesde4", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta4", conPantalla, "MAVObtienePeriodosRangoAnyo");      
     asignar("COMBO", "cbPeriodoDesde5", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta5", conPantalla, "MAVObtienePeriodosRangoAnyo");           
     /*asignar("COMBO", "cbPeriodoDesde6", conPantalla, "MAVObtienePeriodosBP");
     asignar("COMBO", "cbPeriodoHasta6", conPantalla, "MAVObtienePeriodosBP");*/
     /*sbuchelli*/
     asignar("COMBO", "cbPeriodoDesde23", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta23", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoDesde24", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta24", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoDesde25", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta25", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoDesde26", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta26", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoDesde27", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta27", conPantalla, "MAVObtienePeriodosRangoAnyo");     

     // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010	
     asignar("COMBO", "cbPeriodoDesde7", conPantalla, "MAVObtienePeriodosRangoAnyo");
     asignar("COMBO", "cbPeriodoHasta7", conPantalla, "MAVObtienePeriodosRangoAnyo");           
     
    // -------- Asigna Valores a Combos de Marca --------------------------
    //asignar("COMBO", "cbMarca6", conPantalla, "SEGConsultaMarcas");
    // Hecho por RRV - Incidencia V-MAV10: Combo de marcas no muestra datos apropiados (2007-01-06)
    //asignar("COMBO", "cbMarca", conPantalla, "SEGConsultaMarcas");
    asignar("COMBO", "cbMarca", conPantalla, "SEGRecuperarMarcasProducto");
    //sbuchelli
    asignar("COMBO", "cbMarca2", conPantalla, "SEGRecuperarMarcasProducto");
    // -------- Asigna Valores a Combos de Catalogo --------------------------    
    //asignar("COMBO", "cbCatalogo6", conPantalla, "MAVCargarCatalagosBP");
    asignar("COMBO", "cbCatalogo", conPantalla, "MAVCargarCatalagosBP");
    //sbuchelli
    asignar("COMBO", "cbCatalogo2", conPantalla, "MAVCargarCatalagosBP");

    // -------- Asigna Valores a Combos de Catalogo --------------------------        
    asignar("COMBO", "cbAtributoEvaluar", conPantalla, "MAVObtieneSubcriteriosPorCriterio");
    
    // -------- Asigna Valores a Combos de U. de Negocio --------------------------    
    //asignar("COMBO", "cbUnidNegocio6", conPantalla, "MAEObtenerUnidadesNegocioPorPais");
    asignar("COMBO", "cbUnidNegocio", conPantalla, "MAEObtenerUnidadesNegocioPorPais");
    //sbuchelli
    asignar("COMBO", "cbUnidNegocio2", conPantalla, "MAEObtenerUnidadesNegocioPorPais");
    
    // -------- Asigna Valores a Combos de Negocio --------------------------    
    //asignar("COMBO", "cbNegocio6", conPantalla, "MAEObtenerNegocioPorPais");
    asignar("COMBO", "cbNegocio", conPantalla, "MAEObtenerNegocioPorPais");
    //sbuchelli
    asignar("COMBO", "cbNegocio2", conPantalla, "MAEObtenerNegocioPorPais");

    // Asigna Variables Recarga
    this.asignarAtributo("VAR", "varNumUnidadesCliente", "valor", numUnidadesRepartir);    
    this.asignarAtributo("VAR", "varSubcriterio", "valor", subCriterio);    
    this.asignarAtributo("VAR", "varNumeroAniversario", "valor", numAniversario);
    this.asignarAtributo("VAR", "varEdadDesde", "valor", edadDesde);    
    this.asignarAtributo("VAR", "varEdadHasta", "valor", edadHasta);

    traza("Monto antes: " + monto);
    if (!monto.equals("") ){ // O sea, contiene un numero, formatea ese numero,
      monto = UtilidadesBelcorp.formateaNumeroSICC(monto, LPSICCBase.FORMATO_MONEDA, this);
      traza("Cambio");
    }
    traza("Monto Luego:" + monto);
    
    this.asignarAtributo("VAR", "varMonto", "valor", monto);    
    this.asignarAtributo("VAR", "varPeriodoDesde", "valor", periodoDesde);        
    this.asignarAtributo("VAR", "varPeriodoHasta", "valor", periodoHasta);            
    this.asignarAtributo("VAR", "varMarcaCriterio", "valor", marca);                
    this.asignarAtributo("VAR", "varCatalogo", "valor", catalogo);                    
    this.asignarAtributo("VAR", "varUnidadNegocio", "valor", unidadNegocio);                        
    this.asignarAtributo("VAR", "varNegocio", "valor", negocio);                            

     traza("Asignacion Hecha!");
   
 }

 private void muestraVariables() throws Exception
 {
   traza("--- muestra Variables Venta ----");
   String sCriterio = this.conectorParametro("varCriterio");   
   String sActividad = this.conectorParametro("varActividad");;

   // Variables para recarga de datos en caso de reentrar
   String subCriterio = this.conectorParametro("varSubcriterio");
   if (subCriterio == null) { subCriterio = "";}   
   
   String numUnidadesTotales = this.conectorParametro("varNumUnidadesTotales");   
   if (numUnidadesTotales == null) { numUnidadesTotales = "";}   
   
   String campanyaFuente = this.conectorParametro("varCampanyaFuente");
   if (campanyaFuente == null) { campanyaFuente = "";}      
   // Fin Variables para recarga de datos en caso de reentrar
   
   traza("sCriterio: " + sCriterio);
   traza("sActividad: " + sActividad);
   traza("subCriterio: " + subCriterio);
   traza("numUnidadesTotales: " + numUnidadesTotales);
   traza("campanyaFuente: " + campanyaFuente);
   
   this.pagina("contenido_bp_variables");
   this.getConfiguracionMenu();
   this.getFormatosValidaciones();     

    // Agregado por Rafael Romero - SiCC 20070189 - 23/04/2007
    asignarAtributo("VAR", "varEstadoProceso", "valor", this.conectorParametroLimpia("estadoProceso","",true) );
    //Fin Agregado [1]
   
   DTOOID dtoOid = new DTOOID();
   ComposerViewElementList cList = new ComposerViewElementList();
   ComposerViewElement cElem1 = new ComposerViewElement();

   dtoOid.setOid( new Long(sCriterio) );
   cElem1.setIDBusiness("MAVObtieneSubcriteriosPorCriterio");
   cElem1.setDTOE(dtoOid);

   cList.addViewElement(cElem1);

   ConectorComposerView conector = new ConectorComposerView(cList, this.getRequest());
   traza("Ejecucion...");     
   conector.ejecucion();
   traza("Luego de Ejecucion...");
   DruidaConector conPantalla = conector.getConector();
   traza("-------------");

   asignar("COMBO", "cbVariableVentas", conPantalla, "MAVObtieneSubcriteriosPorCriterio");


   // Obtiene la campanya a partir de la actividad.
   if (campanyaFuente == null || campanyaFuente.equals("") )
     campanyaFuente = this.obtieneCampanyaDefecto( new Long(sActividad) );   
      
   this.asignarAtributo("VAR", "hidCampanyaFuente", "valor", campanyaFuente);
   this.asignarAtributo("VAR", "hidNumUnidadesTotales", "valor", numUnidadesTotales);
   this.asignarAtributo("VAR", "hidSubcriterio", "valor", subCriterio);
   
   traza("Asignacion DONE!!!!");
   
 }

 private void muestraFormulas() throws Exception
 {
    traza("--- Muestra Formulas  ----");
    String sCriterio = this.conectorParametro("varCriterio");   
    String sCanal = this.conectorParametro("varCanal");
    String sMarca = this.conectorParametro("varMarca");
    String sActividad = this.conectorParametro("varActividad");

    // Variables para recarga de pantalla
//    String sNumUnidadesRepartir = this.conectorParametroLimpia("varNumUnidadesTotales", "", true);
	String sNumUnidadesRepartir = this.conectorParametroLimpia("varNumUnidadesCliente", "", true);
    String sFormula = this.conectorParametroLimpia("varSubcriterio", "", true);
    String sCampanya = this.conectorParametroLimpia("varCampanyaFuente", "", true);
    String sAsistenciaCurso = this.conectorParametroLimpia("varCurso", "", true);
    String sPeriodo = this.conectorParametroLimpia("varPeriodoCurso", "", true);
    // Fin Variables para recarga de pantalla
    
    // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
    String sTipoCliente = this.conectorParametroLimpia("varTipoClienteCriterio", "", true);
    String sSubtipoCliente = this.conectorParametroLimpia("varSubtipoClienteCriterio", "", true);
    String sTipoClasificacionCliente = this.conectorParametroLimpia("varTipoClasificacionClienteCriterio", "", true);
    String sClasificacionCliente = this.conectorParametroLimpia("varClasificacionClienteCriterio", "", true);
    
     
    traza("sCriterio: " + sCriterio);
    traza("sCanal: " + sCanal);
    traza("sMarca: " + sMarca);
    traza("sActividad: " + sActividad);

    traza(" ----------------------- ");
    traza("sNumUnidadesRepartir: " + sNumUnidadesRepartir);
    traza("sFormula (AKA Subcriterio): " + sFormula);
    traza("sCampanya: " + sCampanya);
    traza("sAsistenciaCurso: " + sAsistenciaCurso);
    traza("sPeriodo: " + sPeriodo);

    DTOPeriodo dtoP = new DTOPeriodo();
    DTOOID dtoOid = new DTOOID();
    DTODruidaBusqueda dtoCurso = new DTODruidaBusqueda();
    
    ComposerViewElementList cList = new ComposerViewElementList();
    ComposerViewElement cElem1 = new ComposerViewElement();
    ComposerViewElement cElem2 = new ComposerViewElement();     
    ComposerViewElement cElem3 = new ComposerViewElement();
   
    this.pagina("contenido_bp_formula");
    this.getConfiguracionMenu();
    this.getFormatosValidaciones();     

    // Agregado por Rafael Romero - SiCC 20070189 - 23/04/2007
    asignarAtributo("VAR", "varEstadoProceso", "valor", this.conectorParametroLimpia("estadoProceso","",true) );
    //Fin Agregado [1]

    // Oculta las Capas.
    this.asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");
    this.asignarAtributo("CAPA", "capa3", "visibilidad", "hidden");
    
    dtoOid.setOid( new Long(sCriterio) );
    cElem1.setDTOE(dtoOid);
    cElem1.setIDBusiness("MAVObtieneSubcriteriosPorCriterio");

    dtoP.setPais(UtilidadesSession.getPais(this));
    dtoP.setCanal( new Long( sCanal ) );
    dtoP.setMarca( new Long( sMarca ) );
    cElem2.setDTOE(dtoP);
    cElem2.setIDBusiness("MAVObtienePeriodosBP");
 
    // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010	
    DTOBelcorp dto1 = new DTOBelcorp();
	dto1.setOidIdioma(UtilidadesSession.getIdioma(this));
	dto1.setOidPais(UtilidadesSession.getPais(this));
    cElem3.setIDBusiness("MAEObtenerTipos"); 	
    cElem3.setDTOE(dto1);
	
    dtoCurso.setOidPais( UtilidadesSession.getPais(this) ); 
    dtoCurso.setOidIdioma( UtilidadesSession.getIdioma(this) );
    dtoCurso.setOidCanal( new Long(sCanal) );
    dtoCurso.setOidMarca( new Long(sMarca) );

    MareBusinessID bussID = new MareBusinessID("CMNObtieneCursos");
    Vector v = new Vector();
    v.add(dtoCurso);
    v.add(bussID);
    traza("Antes de conectar");
    DruidaConector con = this.conectar("ConectorObtieneDetalleMAV", v);
    traza("Luego de Conectar");
    DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");
    RecordSet r = dtoSalida.getResultado();

    DruidaConector conCurso = new DruidaConector();

    if (r.getRowCount() > 0)
      conCurso = UtilidadesBelcorp.generarConector("cursos", r, r.getColumnIdentifiers() );

    cList.addViewElement(cElem1);
    cList.addViewElement(cElem2);
    cList.addViewElement(cElem3); // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010	

    ConectorComposerView conector = new ConectorComposerView(cList, this.getRequest());
    traza("Ejecucion...");     
    conector.ejecucion();
    traza("Luego de Ejecucion...");
    DruidaConector conPantalla = conector.getConector();
    traza("-------------");

    // Asignar Combo Campaña Fuente Ventas
    this.asignar("COMBO", "cbFormulaReparto", conPantalla, "MAVObtieneSubcriteriosPorCriterio");

    // Asignar Combo Periodo
    this.asignar("COMBO", "cbPeriodo2", conPantalla, "MAVObtienePeriodosBP");    
    this.asignar("COMBO", "cbPeriodo3", conPantalla, "MAVObtienePeriodosBP");
    this.asignar("COMBO", "cbTipoCliente", conPantalla, "MAEObtenerTipos");
    
    // Asignar Combo Cursos.
    this.asignar("COMBO", "cbAsistenciaCurso", conCurso, "cursos");

    // Asignar Var Campanya con el valor de la Campanya);
    if (sCampanya == null || sCampanya.equals("") )
      sCampanya = this.obtieneCampanyaDefecto( new Long(sActividad) );

    this.asignarAtributo("VAR", "campanya", "valor", sCampanya);
    this.asignarAtributo("VAR", "hidNumUnidadesRepartir", "valor", sNumUnidadesRepartir);
    this.asignarAtributo("VAR", "hidFormula", "valor", sFormula);    
    this.asignarAtributo("VAR", "hidAsistenciaCurso", "valor", sAsistenciaCurso);
    this.asignarAtributo("VAR", "hidPeriodo", "valor", sPeriodo);    
    
    // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
    this.asignarAtributo("VAR", "hidTipoCliente", "valor", sTipoCliente);
    this.asignarAtributo("VAR", "hidSubtipoCliente", "valor", sSubtipoCliente);
    this.asignarAtributo("VAR", "hidTipoClasificacionCliente", "valor", sTipoClasificacionCliente);
    this.asignarAtributo("VAR", "hidClasificacionCliente", "valor", sClasificacionCliente);
    this.asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
    this.asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );
    
    traza("Termino de asignar!!!!!!!!!!!!!!!!!");

 }

 private String obtieneCampanyaDefecto(Long oidActividad) throws Exception
 {
    traza(" ---- obtieneCampanyaDefecto ---- ");

    String campanya = null;
    Vector param = new Vector();
    DTOOID dtoOid = new DTOOID();
    DruidaConector con = new DruidaConector();
    MareBusinessID bussID = new MareBusinessID("MAVConsultarActividad");

    dtoOid.setOid(oidActividad);
    dtoOid.setOidIdioma( UtilidadesSession.getIdioma(this) );
    dtoOid.setOidPais( UtilidadesSession.getPais(this) );

    param.add(dtoOid);
    param.add(bussID);

    try 
    {
      traza("Antes de conectar");
      con = this.conectar("ConectorObtieneDetalleMAV", param);
      traza("Despues de conectar");
      DTOActividadMAV dtoActiv = (DTOActividadMAV) con.objeto("dtoSalida");
      Integer camp = dtoActiv.getCampagnaEvaluacion();
      if (camp.intValue() > 0)
        campanya = "+" + camp.toString();
      else if (camp.intValue() < 0)
        campanya = "-" + camp.toString();
      else 
        campanya = "0";
        
      

      
      //campanya = dtoActiv.getCampagnaEvaluacion().toString();
    } catch (Exception ex)
    {
      campanya = new String("0");
    }

    traza("campanya: " + campanya);
    traza(" ---- Fin obtieneCampanyaDefecto ---- ");

    return campanya;
 }



  private void logStackTrace(Throwable e) throws Exception 
  { 
      traza("Se produjo la excepcion: " + e.getMessage()); 

      ByteArrayOutputStream pila = new ByteArrayOutputStream(); 
      PrintStream out = new PrintStream(pila); 
      if (e instanceof MareException) 
      { 
          MareException e2=(MareException)e; 
          traza("Es una mare Exception con codigo de error: "+e2.getCode()); 
      } 
      e.printStackTrace(out); 
      traza("stack Trace : " +  pila.toString()); 
  } 

  private void prueba()
  {
      DTODruidaBusqueda dtoCurso = new DTODruidaBusqueda();
      



  }
  

 


}