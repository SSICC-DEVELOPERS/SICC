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
 * la distribución de este código sin permiso expreso.
 */

/*
    INDRA/CAR/PROY
    $Id: LPModificarMateriales.java,v 1.1 2009/12/03 18:39:28 pecbazalar Exp $
    DESC
*/


import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOCombosMateriales;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposProducto;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;



public class LPModificarMateriales extends LPSICCBase {

  String accion;

  String oIDModificar;

  Long lOIDModificar;

  String codigoSAP;
  String codigoAntiguo;
  String descripcionSAP;
  String descripcionCorta;
  String indicadorLote;
  String indicadorProdServ;
  String marca;
  String unidadNegocio;
  String negocio;
  String generico;
  String superGenerico;

	Vector vTraducciones;

	public LPModificarMateriales ()  {
    super();
  }


	public void inicio() throws Exception {
		 pagina("contenido_materiales_modificar2");
		 getConfiguracionMenu();
  }


  public void ejecucion() throws Exception  {

    try{

      this.getFormatosValidaciones();
      
      setTrazaFichero();
      traza("********************************************************");
      traza("********************* ejecucion() LPModificarMateriales **********************");
      traza("********************************************************");
      
      accion = conectorParametroLimpia("accion","",true);
      oIDModificar = conectorParametro("oIDSeleccionado");
      
      traza("accion : "   + accion);
      traza("oIDModificar : "   + oIDModificar);

      lOIDModificar = ( ( oIDModificar == null || oIDModificar.trim().length() == 0 ) ? null : Long.valueOf( oIDModificar ) );
      
      /*
      codigoSAP = conectorParametro("lblR1");
      codigoAntiguo = conectorParametro("txtAnt");
      descripcionSAP = conectorParametro("txtDSAP");
      descripcionCorta = conectorParametro("txtDCorta");
      indicadorLote = conectorParametro("R5");
      indicadorProdServ = conectorParametro("cbIndicadorPS");
      marca = conectorParametro("cbM");
      unidadNegocio = conectorParametro("cbUN");
      negocio = conectorParametro("cbNeg");
      generico = conectorParametro("cbGenr");
      superGenerico = conectorParametro("cbSuperGeg");
      */

  //accion == " " -----------------------------------------------------------------------------------------
      if (accion.equals(""))  {

        traza(" Entra en accion vacia ");

        this.anyadeHiddensI18N( true, "MAE_PRODU", lOIDModificar, 
                                new Integer( "1" ), "frmFormulario", "txtDSAP", false);
        
        // no asigna a los combos, pone en sesion: linea producto , unidades medida, status
        rellenarComboModificarMateriales();
        consultarProducto();

        //REVISAR
        consultarConfiguracionCampos();

        // HCcbIndicadorPS cbM, cbUN, cbNeg, cbGenr, cbSuperGeg, cbLin, cbUNMedidaDimensiones,
        //cbUDV cbUDP MAQUETAcbSituac cbSProd HCcbSCaja
        obtenerSesion(); //combos
        traza(" Sale de accion vacia " );
	} else if (accion.equals("Guardar"))  {
        //accion == "Guardar" -----------------------------------------------------------------------------------

        traza(" Entra en accion Guardar ");

        this.anyadeHiddensI18N( false, "MAE_PRODU", lOIDModificar, 
                                new Integer( "1" ), "frmFormulario", "txtDSAP", false );

        //devuelve un Vector de DTOI18nSICC
        vTraducciones = recuperaTraduccionesI18N( new Integer("1") );

		traza("***************************************************");
		traza("VECTOR DE TRADUCCIONES");
		traza(vTraducciones.toString());
		traza("***************************************************");

        traza( "--> COMPLETO I18N" );
        
        //Se crea un DTOProducto y se rellena con los campos de la pantalla. 
        //Se llama al ConectorModificarProducto 
        DTOProducto dtoGuardar = new DTOProducto();
        dtoGuardar = completarDTOProducto(dtoGuardar);
        Vector objBussines = new Vector();
        objBussines.add(dtoGuardar);

        traza( "--> PASO 2" );

        traza( "********************************************************" );
        traza( "DTO A GUARDAR: " );
        traza(dtoGuardar);
        traza( "********************************************************" );

        pagina( "salidaGenerica" );

        //idBusiness="MAEModificarProducto"
		try {
			objBussines.add(new MareBusinessID("MAEModificarProducto"));
			DruidaConector con = conectar("ConectorModificarProductos",objBussines); 
			asignarAtributo("VAR","exito","valor","si");

			//----------------------------------------------------------------------
			asignarAtributo("VAR","ejecutar","valor","cerrarModal()");
			asignarAtributo("VAR","cerrarVentana","valor","false");
			//----------------------------------------------------------------------

			traza( "--> PASO 3" );

		} catch (Exception e)  { 
			asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlModificar()");
			throw e;
      }


/*
        obtenerSesion(); //combos
        
        cargarCamposPagina();

        traza( "--> accion: " + accion );
       
        asignarAtributo("VAR","accion","valor",accion);
*/

        traza(" Sale de accion Guardar ");

      } else if (accion.equals("Volver"))  {

        //accion == "Volver" ------------------------------------------------------------------------------------

        traza(" Entra en accion Volver ");
        
        /*      
        conectorAction("LPBusquedaMateriales");
        //o Guardar ?? depende lo que haga en lp busqueda
        conectorActionParametro("accion",accion);
        */          
        traza(" Sale de accion Volver ");
      }

      this.getConfiguracionMenu( "LPModificarMateriales", "" );

  //-------------------------------------------------------------------------------------------------------
    } catch (Exception ex)  {

		traza("TIRO EXCEPCION LA LP");

      //preservaHiddensI18n( new Integer( "1" ) , "MAE_PRODU" , "frmFormulario" , "txtDSAP", false );

		traza("-A-");

      //¿Hace falta??
      asignarAtributo("VAR","exito","valor","no");
		traza("-B-");

      traza("ex.printStackTrace()");
      ex.printStackTrace();
	  		traza("-C-");

      traza("logStackTrace(ex)");
      logStackTrace(ex);
		traza("-D-");

      traza("lanzarPaginaError(ex)");
      //traza("ex.printStackTrace()" + ex.toString() );
      lanzarPaginaError(ex); //no se encontro errSeverity, generando...··

	  		traza("-E-");

    }
  } //ejecucion()
  //-------------------------------------------------------------------------------------------------------

	/**
	 * pperanzola - 07/10/2005 - [1] se modifica según SICC-DMCO-PRE_MAE_INT-GCC-001
 	 */
	private void rellenarComboModificarMateriales() throws Exception  {
        traza(" Entra en rellenarComboModificarMateriales ");
      //Se crea un DTOBelcorp y se mete el idioma y el pais del usuario
      DTOBelcorp dtoBelcorp = new DTOBelcorp();
      UtilidadesSession sesion = new UtilidadesSession();
      dtoBelcorp.setOidPais(sesion.getPais(this));
      dtoBelcorp.setOidIdioma(sesion.getIdioma(this));
      Vector objBussines = new Vector();
      objBussines.add(dtoBelcorp);
      //idBusiness="MAERellenarCombosMateriales" 
      
      objBussines.add(new MareBusinessID("MAERellenarCombosMateriales"));
      
      //Se llama ConectorRellenarCombosMateriales y con el DTOCombosMateriales obtenido se cargan los combos de la pantalla:
      //salvo el de productoServicio que sólo tiene dos elementos (Producto y Servicio) y el de dentroCaja que tambien sólo tiene dos elementos (SI y NO)
      //los tres combos unidMedida se cargan con el atributo unidadesMedida
      traza("VA A LLAMAR A BID EN MODIF MATERIALES");
      DruidaConector con = conectar("ConectorRellenarCombosMateriales",objBussines);
      traza("OK LLAMAR A BID EN MODIF MATERIALES");


      
      IMareDTO dtoOut = (IMareDTO) con.objeto("DTOSalida");
      DTOCombosMateriales dtoCombos = (DTOCombosMateriales)dtoOut.getProperty("resultado");



      traza("========================================================0");
      traza("DATOS A CARGAR EN COMBOS");
      traza(dtoCombos);
      traza("========================================================0");



      RecordSet rsLineaProducto = (RecordSet)dtoCombos.getLineaProducto();
      Vector columnasLineaProducto = rsLineaProducto.getColumnIdentifiers();
      DruidaConector dcLinea = UtilidadesBelcorp.generarConector("DTOSalida.lineaProducto_ROWSET",rsLineaProducto, columnasLineaProducto);
      conectorParametroSesion("DCLinea",dcLinea);

      RecordSet rsUnidadesMedida = (RecordSet)dtoCombos.getUnidadesMedida();
      Vector columnasUnidadesMedida = rsUnidadesMedida.getColumnIdentifiers();
      DruidaConector dcUnidadMedida = UtilidadesBelcorp.generarConector("DTOSalida.unidadesMedida_ROWSET",rsUnidadesMedida, columnasUnidadesMedida);
      conectorParametroSesion("DCUnidadMedida",dcUnidadMedida);

      RecordSet rsEstatus = (RecordSet)dtoCombos.getEstatus();
      Vector columnasEstatus = rsEstatus.getColumnIdentifiers();
      DruidaConector dcEstatus = UtilidadesBelcorp.generarConector("DTOSalida.estatus_ROWSET",rsEstatus, columnasEstatus);
      conectorParametroSesion("DCEstatus",dcEstatus);

      RecordSet rsFormasPago = (RecordSet)dtoCombos.getFormasPago();
      Vector columnasFormasPago = rsFormasPago.getColumnIdentifiers();
      DruidaConector dcFormasPago = UtilidadesBelcorp.generarConector("DTOSalida.formasPago_ROWSET",rsFormasPago, columnasFormasPago);
      conectorParametroSesion("DCFormasPago",dcFormasPago);


	  // /* [1]

	  Vector objBussinesProgFide = new Vector();
      objBussinesProgFide.add(dtoBelcorp);
     
      objBussinesProgFide.add(new MareBusinessID("MAEObtenerProgramasFidelizacion"));
      traza("pperanzola : a conectar ");
      DruidaConector conProgFide = conectar("ConectorObtenerProgramasFidelizacion",objBussinesProgFide);
      traza("pperanzola :  ya conecto");

      IMareDTO dtoOutProgFide = (IMareDTO) conProgFide.objeto("DTOSalida");
      DTOSalida dtoSalida = (DTOSalida)dtoOutProgFide;

	  traza("pperanzola :  obtuvo dtoSalida");
	  RecordSet rsProgramasFide = (RecordSet)dtoSalida.getResultado();
      Vector colProgramasFide = rsProgramasFide.getColumnIdentifiers();
      DruidaConector dcProgramasFide = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsProgramasFide, colProgramasFide);
      asignar("COMBO","cbProgFidelizacion", dcProgramasFide, "DTOSalida.resultado_ROWSET");
	  // [1] */ 
      
      traza(" Sale de rellenarComboModificarMateriales ");

	}
	
	
/**
* @author pperanzola
* @date 06/09/2005
*		                    [1] se modifica segun DT de codigo unico de venta
* pperanzola - 07/10/2005 -	[2] se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
*/
  public void consultarProducto() throws Exception  {
  
    traza(" Entra en consultarProducto ");
    
    Vector objBussines = new Vector();
    
    //Se crea un DTOOID con el oid recibido como parametro de la página de consulta. 
    DTOOID dtoOID = new DTOOID();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoOID.setOidPais(sesion.getPais(this));
    dtoOID.setOidIdioma(sesion.getIdioma(this));
    dtoOID.setOid(new Long(oIDModificar));
    objBussines.add(dtoOID);
    
    //idBusiness=" MAEConsultarProducto" 
    objBussines.add(new MareBusinessID("MAEConsultarProducto"));
    
    //Se llama al ConectorConsultarProducto
    DruidaConector con = conectar("ConectorConsultarProducto",objBussines);
    IMareDTO dtoOut = (IMareDTO) con.objeto("DTOSalida");
    
    //Con el DTOProducto que obtenemos rellenamos los campos de la pantalla. 
    DTOProducto dtoProd =(DTOProducto)dtoOut.getProperty("resultado");
    traza(" dtoProd a modificar : " + dtoProd );

    boolean bIndLote = ((dtoProd.getIndLote()!=null) ? dtoProd.getIndLote().booleanValue() : false); //Boolean

    asignarAtributo("VAR", "hOID", "valor", oIDModificar);
    //asignarAtributo("VAR", "hIndLote", "valor", (bIndLote) ? "S" : "N" );
	asignarAtributo("VAR", "hIndLote", "valor", dtoProd.getIndLote()==null?"":(dtoProd.getIndLote().booleanValue()? "S" : "N" ));

    //completa los 37 campos de la pantalla
    if (dtoProd.getCodSAP() != null) {
      asignarAtributo("LABELC","lblR1","valor",dtoProd.getCodSAP().toString());
      asignarAtributo("VAR","hCodSap","valor",dtoProd.getCodSAP().toString());
      conectorParametroSesion("lblR1",dtoProd.getCodSAP().toString());
    } 
    else { 
      asignarAtributo("LABELC","lblR1","valor",""); 
    }
    
    if (dtoProd.getCodAntiguo() != null)  { 
      asignarAtributo("CTEXTO","txtAnt","valor",dtoProd.getCodAntiguo());
      asignarAtributo("VAR", "hTxtAnt","valor", dtoProd.getCodAntiguo());
    } else { 
      asignarAtributo("CTEXTO","txtAnt","valor",""); 
    }
    
    if (dtoProd.getDescSapI18n() != null)  { 
      if( dtoProd.getDescSapI18n().size()>0 ){
        traza("dtoProd.getDescSapI18n(): " + dtoProd.getDescSapI18n());
        //traza( "Primer elemento: " + ((dtoProd.getDescSapI18n().firstElement()==null) ? null : dtoProd.getDescSapI18n().firstElement()) );
        asignarAtributo("CTEXTO","txtDSAP","valor",dtoProd.getDescSapI18n().firstElement().toString());
        asignarAtributo("VAR", "hTxtDSap", "valor",dtoProd.getDescSapI18n().firstElement().toString());
      }
    } 
    else { 
      asignarAtributo("CTEXTO","txtDSAP","valor",""); 
    }

    if (dtoProd.getDescCorta() != null)  { 
      asignarAtributo("CTEXTO","txtDCorta","valor",dtoProd.getDescCorta());
      asignarAtributo("VAR", "hTxtDCorta", "valor",dtoProd.getDescCorta()); 
    } 
    else { 
      asignarAtributo("CTEXTO","txtDCorta","valor",""); 
    }

    if (dtoProd.getIndLote() != null)  {
      if (dtoProd.getIndLote().booleanValue()){
        asignarAtributo("VAR","hR5","valor","s");
      }
      else {
        asignarAtributo("VAR","hR5","valor","n"); 
      }
    }
    else { 
      asignarAtributo("VAR","hR5","valor",""); 
    }

    if (dtoProd.getProductoServicio() != null){
      if (dtoProd.getProductoServicio().booleanValue()) 
        asignarAtributo("VAR","hcbIndicadorPS","valor","1");
      else 
        asignarAtributo("VAR","hcbIndicadorPS","valor","0"); }
    else { asignarAtributo("VAR","hcbIndicadorPS","valor",""); }

    if(dtoProd.getOidMarca() != null){ 
       asignarAtributo("VAR","hcbM","valor",dtoProd.getOidMarca().toString());
    }else{ 
       asignarAtributo("VAR","hcbM","valor",""); 
    }

    if (dtoProd.getUnidadNegocio() != null){ 
       asignarAtributo("VAR","hcbUN","valor",dtoProd.getUnidadNegocio().toString());
    }else{ 
       asignarAtributo("VAR","hcbUN","valor",""); 
    }

    if (dtoProd.getNegocio() != null){ 
       asignarAtributo("VAR","hcbNeg","valor",dtoProd.getNegocio().toString());
    }else{ 
       asignarAtributo("VAR","hcbNeg","valor",""); 
    }

    if (dtoProd.getGenerico() != null){ 
       asignarAtributo("VAR","hcbGenr","valor",dtoProd.getGenerico().toString());
    }else{ 
       asignarAtributo("VAR","hcbGenr","valor",""); 
    }

    if (dtoProd.getSupergenerico() != null){ 
       asignarAtributo("VAR","hcbSuperGeg","valor",dtoProd.getSupergenerico().toString());
    }else{ 
       asignarAtributo("VAR","hcbSuperGeg","valor",""); 
    }

    if (dtoProd.getJerarquia1() != null){ 
       asignarAtributo("CTEXTO","txtJ1","valor",dtoProd.getJerarquia1());
       asignarAtributo("VAR", "hTxtJ1", "valor",dtoProd.getJerarquia1()); 
    }else{ 
       asignarAtributo("CTEXTO","txtJ1","valor",""); 
    }

    if (dtoProd.getJerarquia2() != null){ 
       asignarAtributo("CTEXTO","txtJ2","valor",dtoProd.getJerarquia2());
       asignarAtributo("VAR", "hTxtJ2", "valor",dtoProd.getJerarquia2());
    }else{ 
       asignarAtributo("CTEXTO","txtJ2","valor",""); 
    }          

    if (dtoProd.getJerarquia3() != null){ 
       asignarAtributo("CTEXTO","txtJ3","valor",dtoProd.getJerarquia3());
       asignarAtributo("VAR", "hTxtJ3", "valor",dtoProd.getJerarquia3());
    }else{ 
       asignarAtributo("CTEXTO","txtJ3","valor",""); 
    }

    if (dtoProd.getLineaProducto() != null){ 
       asignarAtributo("VAR","hcbLin","valor",dtoProd.getLineaProducto().toString());
    }else{ 
       asignarAtributo("VAR","hcbLin","valor",""); 
    }

    if (dtoProd.getAtributo1() != null){ 
       asignarAtributo("CTEXTO","txtA1","valor",dtoProd.getAtributo1());
       asignarAtributo("VAR", "hTxtA1", "valor",dtoProd.getAtributo1());
    }else{ 
       asignarAtributo("CTEXTO","txtA1","valor",""); 
    }

    if (dtoProd.getAtributo2() != null){ 
       asignarAtributo("CTEXTO","txtA2","valor",dtoProd.getAtributo2());
        asignarAtributo("VAR", "hTxtA2", "valor",dtoProd.getAtributo2());
    }else{ 
       asignarAtributo("CTEXTO","txtA2","valor",""); 
    }

    if (dtoProd.getAtributo3() != null){ 
       asignarAtributo("CTEXTO","txtA3","valor",dtoProd.getAtributo3());
        asignarAtributo("VAR", "hTxtA3", "valor",dtoProd.getAtributo3());
    }else{ 
       asignarAtributo("CTEXTO","txtA3","valor",""); 
    }

    if (dtoProd.getAlto() != null){ 
       asignarAtributo("CTEXTO","txtDA","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getAlto().toString(), this.FORMATO_DEFAULT, this));
       asignarAtributo("VAR", "hTxtDA", "valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getAlto().toString(), this.FORMATO_DEFAULT, this));
    }else{ 
       asignarAtributo("CTEXTO","txtDA","valor",""); 
    }

    if (dtoProd.getLargo() != null){
       asignarAtributo("CTEXTO","txtDL","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getLargo().toString(), this.FORMATO_DEFAULT, this));
       asignarAtributo("VAR", "hTxtDL", "valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getLargo().toString(), this.FORMATO_DEFAULT, this));
    }else{ 
       asignarAtributo("CTEXTO","txtDL","valor",""); 
    }

    if (dtoProd.getAncho() != null){ 
       asignarAtributo("CTEXTO","txtDAL","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getAncho().toString(), this.FORMATO_DEFAULT, this));
       asignarAtributo("VAR", "hTxtDAL", "valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getAncho().toString(), this.FORMATO_DEFAULT, this));
    }else{ 
       asignarAtributo("CTEXTO","txtDAL","valor",""); 
    }

    if (dtoProd.getUnidMedidaDimensiones() != null){ 
       asignarAtributo("VAR","hcbUNMedidaDimensiones","valor",dtoProd.getUnidMedidaDimensiones().toString());
    }else{ 
       asignarAtributo("VAR","hcbUNMedidaDimensiones","valor",""); 
    }

    if (dtoProd.getVolumen() != null){ 
       asignarAtributo("CTEXTO","txtVoluA","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getVolumen().toString(), this.FORMATO_DEFAULT, this));
       asignarAtributo("VAR", "hTxtVoluA", "valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getVolumen().toString(), this.FORMATO_DEFAULT, this));
    }else{ 
       asignarAtributo("CTEXTO","txtVoluA","valor",""); 
    }

    if (dtoProd.getUnidMedidaVolumen() != null){ 
       asignarAtributo("VAR","hcbUDV","valor",dtoProd.getUnidMedidaVolumen().toString());
    }else{ 
       asignarAtributo("VAR","hcbUDV","valor",""); 
    }

    if (dtoProd.getPeso() != null)  { 
      //asignarAtributo("CTEXTO","txtDAPesodf","valor",dtoProd.getPeso().toString());
      asignarAtributo("CTEXTO","txtPeso","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPeso().toString(), this.FORMATO_DEFAULT, this));
      asignarAtributo("VAR","hTxtPeso","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPeso().toString(), this.FORMATO_DEFAULT, this));
    } else { 
      //asignarAtributo("CTEXTO","txtDAPesodf","valor",""); 
      asignarAtributo("CTEXTO","txtPeso","valor",""); 
    }

    if (dtoProd.getUnidMedidaPeso() != null){ 
       asignarAtributo("VAR","hcbUDP","valor",dtoProd.getUnidMedidaPeso().toString());
    }else{ 
       asignarAtributo("VAR","hcbUDP","valor",""); 
    }

    if (dtoProd.getUnidDentroPedido() != null)  { 
      asignarAtributo("CTEXTO","txtUnidDentroPedido","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getUnidDentroPedido().toString(), this.FORMATO_DEFAULT, this));
      asignarAtributo("VAR","hTxtUnidDentroPedido","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getUnidDentroPedido().toString(), this.FORMATO_DEFAULT, this));
    } else { 
      asignarAtributo("CTEXTO","txtUnidDentroPedido","valor","");
    }

    if (dtoProd.getUnidPorCaja() != null){ 
       asignarAtributo("CTEXTO","txtUDC","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getUnidPorCaja().toString(), this.FORMATO_DEFAULT, this));
       asignarAtributo("VAR","hTxtUDC","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getUnidPorCaja().toString(), this.FORMATO_DEFAULT, this));
    }else{ 
    asignarAtributo("CTEXTO","txtUDC","valor",""); }

    if (dtoProd.getCosteEstandar() != null)  { 
      asignarAtributo("CTEXTO","txtCosteEstandar","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getCosteEstandar().toString(), this.FORMATO_MONEDA, this) );
      asignarAtributo("VAR","hTxtCosteEstandar","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getCosteEstandar().toString(), this.FORMATO_MONEDA, this) );
    } else { 
      asignarAtributo("CTEXTO","txtCosteEstandar","valor","");
    }

    if (dtoProd.getPrecioPosicionamiento() != null){ 
       asignarAtributo("CTEXTO","txtPPos","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioPosicionamiento().toString(), this.FORMATO_MONEDA, this) );
       asignarAtributo("VAR","hTxtPPos","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioPosicionamiento().toString(), this.FORMATO_MONEDA, this) );
    }else{ 
       asignarAtributo("CTEXTO","txtPPos","valor",""); 
    }

    if (dtoProd.getSituacion() != null){ 
       asignarAtributo("VAR","hcbSituac","valor",dtoProd.getSituacion().toString());
    }else{ 
       asignarAtributo("VAR","hcbSituac","valor",""); 
    }

    if (dtoProd.getEstatus() != null){ 
       asignarAtributo("VAR","hcbSProd","valor",dtoProd.getEstatus().toString());
    }else{ 
       asignarAtributo("VAR","hcbSProd","valor",""); 
    }

    if (dtoProd.getCajaBolsa() != null)  { 
      asignarAtributo("VAR","hcbSCaja","valor",dtoProd.getCajaBolsa().toString());
    }else{ 
      asignarAtributo("VAR","hcbSCaja","valor",""); 
    }

    if (dtoProd.getFormaPago() != null)  {
      asignarAtributo("VAR","hFormaPago","valor",String.valueOf(dtoProd.getFormaPago()));
    }else{ 
      asignarAtributo("COMBO","hFormaPago","valor","");
    }

    if (dtoProd.getCodImpuesto() != null)  { 
      asignarAtributo("CTEXTO","txtCodImpuesto","valor",dtoProd.getCodImpuesto());
      asignarAtributo("VAR","hTxtCodImpuesto","valor",dtoProd.getCodImpuesto());
    }else{ 
      asignarAtributo("CTEXTO","txtCodImpuesto","valor","");
    }

    if (dtoProd.getPrecioCatalogo() != null)  { 
      asignarAtributo("CTEXTO","txtPrecioCatalogo","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioCatalogo().toString(), this.FORMATO_MONEDA, this) );
      asignarAtributo("VAR","hTxtPrecioCatalogo","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioCatalogo().toString(), this.FORMATO_MONEDA, this) );
    }else{ 
      asignarAtributo("CTEXTO","txtPrecioCatalogo","valor","");
    }

    if (dtoProd.getPrecioContable() != null)  { 
      asignarAtributo("CTEXTO","txtPrecioContable","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioContable().toString(), this.FORMATO_MONEDA, this) );
      asignarAtributo("VAR","hTxtPrecioContable","valor", UtilidadesBelcorp.formateaNumeroSICC(dtoProd.getPrecioContable().toString(), this.FORMATO_MONEDA, this) );
    }else{ 
      asignarAtributo("CTEXTO","txtPrecioContable","valor","");
    }


    if (dtoProd.getGrupoArticulos() != null)  { 
      asignarAtributo("CTEXTO", "txtGrupoArticulos", "valor", dtoProd.getGrupoArticulos());
      asignarAtributo("VAR", "hTxtGrupoArticulos", "valor", dtoProd.getGrupoArticulos());
    }else{ 
      asignarAtributo("CTEXTO", "txtGrupoArticulos", "valor", "");
    }
	// /* [1]
	if (dtoProd.getCodigoUnicoVenta() != null)  { 
      asignarAtributo("LABELC", "lblcodigoUnicoVenta", "valor", dtoProd.getCodigoUnicoVenta());
    }else{ 
      asignarAtributo("LABELC", "lblcodigoUnicoVenta", "valor", "");
    }
	// */ [1]
	// /* [2]
	if (dtoProd.getProgramaFidelizacion() != null)  { 
       asignarAtributo("VAR","hcbProgFide","valor",dtoProd.getProgramaFidelizacion().toString());
    }else{ 
      asignarAtributo("VAR","hcbProgFide","valor","");
    }
	// */ [2]
    
    
    traza(" Sale de consultarProducto ");
  }


  private void consultarConfiguracionCampos() throws Exception  {
    traza(" Entra en consultarConfiguracionCampos ");

    //se crea un DTOCampo para cada campo de la pantalla rellenando sólamente 
    //el código de campo (mirar nota en el diagrama).

    //Se obtienen los codigos de campo
    Hashtable src1    = this.getClavesNombre();
    int longArray     = src1.size();
    Enumeration keys  = src1.keys();
    DTOCampo campo    = null;
    Vector config     = new Vector();

    while( keys.hasMoreElements() ){
      campo = new DTOCampo();
      campo.setCodigoCampo( src1.get( keys.nextElement().toString() ).toString() );
      config.addElement( campo );
    } 
      
    //Metemos todos los DTOCampo que hemos creado en un DTOConfiguracionCamposProducto,
    //(se rellena el pais y el idioma)
    DTOConfiguracionCamposProducto camposProducto = new DTOConfiguracionCamposProducto();
    camposProducto.setOidIdioma( UtilidadesSession.getIdioma(this) );
    camposProducto.setOidPais( UtilidadesSession.getPais(this) );
    camposProducto.setCampos(config);
    Vector objBussines = new Vector();
    objBussines.add(camposProducto);
    //idBusiness="MAEConsultarConfiguracionCamposProductos"
    objBussines.add(new MareBusinessID("MAEConfiguracionCamposProductos"));
      
    //se llama al ConectorConfiguracionCamposProductos y obtenemos el mismo 
    //DTOConfiguracionCampos pero cada DTOCampo tiene rellenadas sus propiedades.
    //Leemos las propiedades de cada campo y actuamos en consecuencia: 
    //si modificable es false ese campo no será editable y si obligatorio es 
    //true el campo no se puede dejar en blanco.
	traza("VA A CONECTAR...");
    DruidaConector ver = conectar("ConectorConfiguracionCamposProductos", objBussines);
	traza("CONECTO");
    DTOConfiguracionCamposProducto dtos = (DTOConfiguracionCamposProducto) ver.objeto("DTOSalidaTipoConfig");
      traza("DTO campos parametrizados " + dtos);
    Vector SalidaTipoConfig =(Vector)dtos.getProperty("campos");
    
    for (int i = 0; i < SalidaTipoConfig.size(); i++) {
      setearAtribCampos( (DTOCampo)SalidaTipoConfig.get(i) );
    }
    
      traza(" Sale de consultarConfiguracionCampos ");    
  }

  //Devuelve la key que contiene un determinado valor (value)
  //en un Hashtable (hash).
	private String findKey( Hashtable hash, String value ){
		String key = null;
		String tempKey = null;
		Enumeration keys = hash.keys();

		while( keys.hasMoreElements() ){
			key = keys.nextElement().toString();
			if( hash.get( key ).toString().equals(value) ){
				//key = hash.get( key ).toString();
				break;
			}
		}
		return key;
	}

  private void setearAtribCampos(DTOCampo field) throws Exception {
    traza(" Entra en setearAtribCampos ");

    //Se obtienen los codigos de campo
    Hashtable src1    = this.getClavesNombre();

	//findKey(src1, field.getCodigoCampo()).equals("txtGrupoArticulos")

    if( findKey(src1, field.getCodigoCampo()).equals("txtAnt") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtAnt", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtAnt", "req", "S");
        asignarAtributoElementoValidacion("txtAnt","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtDSAP") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtDSAP", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtDSAP", "req", "S");
        asignarAtributoElementoValidacion("txtDSAP","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtDCorta") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtDCorta", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtDCorta", "req", "S");
        asignarAtributoElementoValidacion("txtDCorta","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("rbIdLote") ){
      if(!field.getModificable().booleanValue()){
        //asignarAtributo("RADIOB","R5", "disabled", "true");
        asignarAtributo("VAR","hModrbIdLote", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("RADIO","rbIdLote", "req", "S");
		asignarAtributo("VAR", "hIdLoteReq", "valor", "S");
        asignarAtributoElementoValidacion("rbIdLote","required", "true");
      }else{
		asignarAtributo("RADIO","rbIdLote", "req", "N");
		asignarAtributo("VAR", "hIdLoteReq", "valor", "N");
	  }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbIdPS") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbIndicadorPS", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbIdPS", "req", "S");
        asignarAtributoElementoValidacion("cbIdPS","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbM") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbM", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbM", "req", "S");
        asignarAtributoElementoValidacion("cbM","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbUN") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbUN", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbUN", "req", "S");
        asignarAtributoElementoValidacion("cbUN","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbNeg") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbNeg", "valor", "S");
      }
       if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbNeg", "req", "S");
        asignarAtributoElementoValidacion("cbNeg","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbGenr") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbGenr", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        traza("*******************entro*****************");
        asignarAtributo("COMBO","cbGenr", "req", "S");
        asignarAtributoElementoValidacion("cbGenr","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbSuperGeg") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbSuperGeg", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbSuperGeg", "req", "S");
        asignarAtributoElementoValidacion("cbSuperGeg","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtJ1") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtJ1", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtJ1", "req", "S");
        asignarAtributoElementoValidacion("txtJ1","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtJ2") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtJ2", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtJ2", "req", "S");
        asignarAtributoElementoValidacion("txtJ2","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtJ3") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtJ3", "valor", "S");
      }
       if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtJ3", "req", "S");
        asignarAtributoElementoValidacion("txtJ3","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbLin") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbLin", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbLin", "req", "S");
        asignarAtributoElementoValidacion("cbLin","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtA1") ){
      if(!field.getModificable().booleanValue()){
		  traza("entro a modificable");
        asignarAtributo("VAR","hModtxtA1", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
		  traza("entro a obligatorio");
        asignarAtributo("CTEXTO","txtA1", "req", "S");
        asignarAtributoElementoValidacion("txtA1","required", "true");
      }
    } else if( findKey(src1, field.getCodigoCampo()).equals("txtA2") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtA2", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtA2", "req", "S");
        asignarAtributoElementoValidacion("txtA2","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtA3") ){
      if(!field.getModificable().booleanValue()){
       asignarAtributo("VAR","hModtxtA3", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtA3", "req", "S");
        asignarAtributoElementoValidacion("txtA3","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtDA") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtDA", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtDA", "req", "S");
        asignarAtributoElementoValidacion("txtDA","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtDL") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtDL", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtDL", "req", "S");
        asignarAtributoElementoValidacion("txtDL","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtDAL") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtDAL", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtDAL", "req", "S");
        asignarAtributoElementoValidacion("txtDAL","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbUNMedidaDimensiones") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbUNMedidaDimensiones", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbUNMedidaDimensiones", "req", "S");
        asignarAtributoElementoValidacion("cbUNMedidaDimensiones","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtVoluA") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtVoluA", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtVoluA", "req", "S");
        asignarAtributoElementoValidacion("txtVoluA","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbUDV") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbUDV", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbUDV", "req", "S");
        asignarAtributoElementoValidacion("cbUDV","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtPeso") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtPeso", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtPeso", "req", "S");
        asignarAtributoElementoValidacion("txtPeso","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbUDP") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbUDP", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbUDP", "req", "S");
        asignarAtributoElementoValidacion("cbUDP","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtUnidDentroPedido") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtUnidDentroPedido", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtUnidDentroPedido", "req", "S");
        asignarAtributoElementoValidacion("txtUnidDentroPedido","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtUDC") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtUDC", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtUDC", "req", "S");
        asignarAtributoElementoValidacion("txtUDC","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtCosteEstandar") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtCosteEstandar", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtCosteEstandar", "req", "S");
        asignarAtributoElementoValidacion("txtCosteEstandar","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtPPos") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtPPos", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtPPos", "req", "S");
        asignarAtributoElementoValidacion("txtPPos","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbSituac") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbSituac", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbSituac", "req", "S");
        asignarAtributoElementoValidacion("cbSituac","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbSProd") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbSProd", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbSProd", "req", "S");
        asignarAtributoElementoValidacion("cbSProd","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbSCaja") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbSCaja", "valor", "S");
        traza("modificable verdadero");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbSCaja", "req", "S");
        asignarAtributoElementoValidacion("cbSCaja","required", "true");
        traza("obligatorio verdadero");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("cbFormaPago") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModcbFormaPago", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("COMBO","cbFormaPago", "req", "S");
        asignarAtributoElementoValidacion("cbFormaPago","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtCodImpuesto") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtCodImpuesto", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtCodImpuesto", "req", "S");
        asignarAtributoElementoValidacion("txtCodImpuesto","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtPrecioCatalogo") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtPrecioCatalogo", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtPrecioCatalogo", "req", "S");
        asignarAtributoElementoValidacion("txtPrecioCatalogo","required", "true");
      }

    } else if( findKey(src1, field.getCodigoCampo()).equals("txtPrecioContable") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtPrecioContable", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtPrecioContable", "req", "S");
        asignarAtributoElementoValidacion("txtPrecioContable","required", "true");
      }

	//txtGrupoArticulos
    } else if( findKey(src1, field.getCodigoCampo()).equals("txtGrupoArticulos") ){
      if(!field.getModificable().booleanValue()){
        asignarAtributo("VAR","hModtxtGrupoArticulos", "valor", "S");
      }
      if(field.getObligatorio().booleanValue()){
        asignarAtributo("CTEXTO","txtGrupoArticulos", "req", "S");
        asignarAtributoElementoValidacion("txtGrupoArticulos","required", "true");
      }

    }
    
    traza(" Sale de setearAtribCampos ");
  }

  /* pperanzola - 07/10/2005 - [1] se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
  */
  private DTOProducto completarDTOProducto(DTOProducto dtoP) throws Exception  {
    traza(" Entra en completarDTOProducto ");
    HashMap map = conectorParametro();
    
    String valor;
    valor = (String)map.get("hOID");
    dtoP.setOid(Long.valueOf(valor)); traza("0 : hOID " + valor);

    valor = (String)map.get(new String("lblR1"));

    //conectorParametroSesion("lblR1",dtoProd.getCodSAP().toString());

    String codigoSap = (String)this.conectorParametroSesion( "lblR1" );
    dtoP.setCodSAP( ((codigoSap==null) ? null : codigoSap) ); 

    valor = (String)map.get(new String("txtAnt"));
    if (!valor.equals(""))  { dtoP.setCodAntiguo(valor); }

    valor = (String)map.get(new String("txtDSAP"));
    if (!valor.equals("")) { dtoP.setDescSAP(valor); }
	
    dtoP.setDescSapI18n(vTraducciones);


/*
    Vector newDescSapI18n = new Vector();
    newDescSapI18n.addElement(valor);
    if (!valor.equals(""))  { dtoP.setDescSapI18n(newDescSapI18n); }
*/


    valor = (String)map.get(new String("txtDCorta"));
    if (!valor.equals(""))  { dtoP.setDescCorta(valor); }
    
    //valor = (String)map.get(new String("R5"));
    valor = null;
    String sLote = (String)map.get(new String("hR5"));

    if( sLote != null && sLote.equalsIgnoreCase( "S" ) ){
      valor = "true";
    } else if( sLote != null && sLote.equalsIgnoreCase( "N" ) ){
      valor = "false";
    }else{
	  valor = "";
	}

    if (!valor.equals(""))  { dtoP.setIndLote(Boolean.valueOf(valor)); }
    
    //valor = (String)map.get(new String("cbIndicadorPS"));

    //Indicador Producto/Servicio
    //La variable hcbIndicadorPS puede valer "0" o "1"
    valor = null;
    
    //String sPS = (String)map.get(new String("hcbIndicadorPS"));
    String sPS = (String)map.get(new String("cbIdPS"));

    if( sPS != null && sPS.equalsIgnoreCase( "1" ) ){
      valor = "true";
    } else if( sPS != null && sPS.equalsIgnoreCase( "0" ) ) {
      valor = "false";
    } else{
      valor = null;
    }
    
    if ( valor != null && !valor.equals("") ) { 
      dtoP.setProductoServicio(Boolean.valueOf(valor)); 
    } else{
      dtoP.setProductoServicio( null );
    }

    valor = (String)map.get(new String("cbM"));
    if (!valor.equals(""))  { dtoP.setOidMarca(Long.valueOf(valor)); }
    
    valor = (String)map.get(new String("cbUN"));
    if (!valor.equals(""))  { dtoP.setUnidadNegocio(Long.valueOf(valor)); }
    
    valor = (String)map.get(new String("cbNeg"));
    if (!valor.equals(""))  { dtoP.setNegocio(Long.valueOf(valor)); }
    
    valor = (String)map.get(new String("cbGenr"));
    if (!valor.equals(""))  { dtoP.setGenerico(Long.valueOf(valor)); }
    
    valor = (String)map.get(new String("cbSuperGeg"));
    if (!valor.equals(""))  { dtoP.setSupergenerico(Long.valueOf(valor)); }
    
    valor = (String)map.get(new String("txtJ1"));
    if (!valor.equals(""))  { dtoP.setJerarquia1(valor); }
    
    valor = (String)map.get(new String("txtJ2"));
    if (!valor.equals(""))  { dtoP.setJerarquia2(valor); }
    
    valor = (String)map.get(new String("txtJ3"));
    if (!valor.equals("")) { dtoP.setJerarquia3(valor); }
    
    valor = (String)map.get(new String("cbLin"));
    
    if (!valor.equals(""))  { dtoP.setLineaProducto(new Long(valor)); }
    
    valor = (String)map.get(new String("txtA1"));
    if (!valor.equals(""))  { dtoP.setAtributo1(valor); }
    
    valor = (String)map.get(new String("txtA2"));
    if (!valor.equals(""))  { dtoP.setAtributo2(valor); }
    
    valor = (String)map.get(new String("txtA3"));
    if (!valor.equals(""))  { dtoP.setAtributo3(valor); }
    

	valor = conectorParametroNumero("txtDA", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtDA"));
    if (!valor.equals(""))  { dtoP.setAlto(new BigDecimal(valor)); }
    

	valor = conectorParametroNumero("txtDL", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtDL"));
    if (!valor.equals(""))  { dtoP.setLargo(new BigDecimal(valor)); }
    


	valor = conectorParametroNumero("txtDAL", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtDAL"));
    if (!valor.equals(""))  { dtoP.setAncho(new BigDecimal(valor)); }
    


    valor = (String)map.get(new String("cbUNMedidaDimensiones"));
    if (!valor.equals(""))  { dtoP.setUnidMedidaDimensiones(new Long(valor)); }
    

	valor = conectorParametroNumero("txtVoluA", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtVoluA"));
    if (!valor.equals(""))  { dtoP.setVolumen(new BigDecimal(valor)); }
    

    valor = (String)map.get(new String("cbUDV"));
    if (!valor.equals(""))  { dtoP.setUnidMedidaVolumen(new Long(valor)); }
    

	valor = conectorParametroNumero("txtPeso", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtDAPesodf"));
    //valor = (String)map.get(new String("txtPeso"));
    if (!valor.equals(""))  { dtoP.setPeso(new BigDecimal(valor)); }
    


    valor = (String)map.get(new String("cbUDP"));
    if (!valor.equals(""))  { dtoP.setUnidMedidaPeso(new Long(valor)); }
    

	valor = conectorParametroNumero("txtUnidDentroPedido", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtPeso"));
    //valor = (String)map.get(new String("txtUnidDentroPedido"));
    if (!valor.equals(""))  { dtoP.setUnidDentroPedido(new Integer(valor)); }


	valor = conectorParametroNumero("txtUDC", this.FORMATO_DEFAULT);
    //valor = (String)map.get(new String("txtUDC"));
    if (!valor.equals("")) { dtoP.setUnidPorCaja(new Integer(valor)); }


	valor = conectorParametroNumero("txtCosteEstandar", this.FORMATO_MONEDA);
    //valor = (String)map.get(new String("txtCosteEstandar"));
    if (!valor.equals(""))  { dtoP.setCosteEstandar(new BigDecimal(valor)); }
    

	valor = conectorParametroNumero("txtPPos", this.FORMATO_MONEDA);
    //valor = (String)map.get(new String("txtPPos"));
    if (!valor.equals(""))  { dtoP.setPrecioPosicionamiento(new BigDecimal(valor)); }
    

    valor = (String) map.get(new String("cbSituac"));


    traza("************************************************");
    traza("SITUACION: " + valor);
    traza("************************************************");

    
    if (valor != null && valor.equals("A"))  { 
      dtoP.setSituacion(new Character('A')); 
    } else if( valor != null && valor.equals("I") ) { 
      dtoP.setSituacion(new Character('I')); 
    } else{
      dtoP.setSituacion( null );
    }
    
    valor = (String)map.get(new String( "cbSProd"));
    if (!valor.equals(""))  { dtoP.setEstatus(new Long(valor)); }
    
    valor = (String)map.get(new String("cbSCaja"));

    traza("************************************************");
    traza("CAJA: " + valor);
    traza("************************************************");
    
    if ( valor != null && valor.equals("C") )  { 
      dtoP.setCajaBolsa(new Character('C')); 
    } else if( valor != null && valor.equals("B") ) { 
      dtoP.setCajaBolsa(new Character('B')); 
    } else{
      dtoP.setCajaBolsa( null );
    }
    
    //valor = (String)map.get(new String("txtPrecCa"));

    valor = (String)map.get(new String("cbFormaPago"));
    if (valor != null && !valor.equals("")) {
      dtoP.setFormaPago(Long.valueOf(valor));
    }
    
    //valor = (String)map.get(new String("txtPrecCont")); 
    valor = (String)map.get(new String("txtCodImpuesto"));
    if (!valor.equals(""))  { dtoP.setCodImpuesto(valor); }
    

	valor = conectorParametroNumero("txtPrecioCatalogo", this.FORMATO_MONEDA);
    //valor = (String)map.get(new String("txtPrecContdf"));
    //valor = (String)map.get(new String("txtPrecioCatalogo"));
    if (!valor.equals(""))  { dtoP.setPrecioCatalogo(new BigDecimal(valor)); }
    

	valor = conectorParametroNumero("txtPrecioContable", this.FORMATO_MONEDA);
    //valor = (String)map.get(new String("txtIDC")); 
    //valor = (String)map.get(new String("txtPrecioContable"));
    if (!valor.equals(""))  { dtoP.setPrecioContable(new BigDecimal(valor)); }


    valor = (String)map.get("txtGrupoArticulos");
    if (!valor.equals(""))  { dtoP.setGrupoArticulos(valor); }

	// /* [1]
	String oidProgFide = conectorParametroLimpia( "cbProgFidelizacion","",true );
	traza(" valor de oidProgFide = " + oidProgFide);
	if (!oidProgFide.equals("")){
		dtoP.setProgramaFidelizacion(new Long (oidProgFide));
	}
	// [1] */
    
    traza(" Sale de completarDTOProducto ");
    traza("DTO COMPLETO " + dtoP);
    return dtoP;
  }

  //Metodo que mapea codigos con atributos nombres de la página
  private Hashtable getClavesNombre()  {
    Hashtable tabla = new Hashtable();
    tabla.put("txtDSAP",    "MAEDESSAP"); //MAEPRODCODSAP
    tabla.put("txtAnt",     "MAEPRODCODANT");
    tabla.put("txtDCorta",  "MAEPRODDESCORT");
    tabla.put("rbIdLote",   "MAEPRODINDLOT");
    tabla.put("cbIdPS",     "MAEPRODINDPS");
    tabla.put("cbM",        "MAEPRODMARCAPROD");
    tabla.put("cbUN",       "MAEPRODUNIDNEG");
    tabla.put("cbNeg",      "MAEPRODNEG");
    tabla.put("cbGenr",     "MAEPRODGEN");
    tabla.put("cbSuperGeg", "MAEPRODSGEN");
    tabla.put("txtJ1",      "MAEPRODJER1");
    tabla.put("txtJ2",      "MAEPRODJER2");
    tabla.put("txtJ3",      "MAEPRODJER3");
    tabla.put("cbLin",      "MAEPRODLINPRO");
    tabla.put("txtA1",      "MAEPRODATR1");
    tabla.put("txtA2",      "MAEPRODATR2");
    tabla.put("txtA3",      "MAEPRODATR3");
    tabla.put("txtDA",      "MAEPRODDIMAL");
    tabla.put("txtDL",      "MAEPRODDIMLAR");
    tabla.put("txtDAL",     "MAEPRODDIMANCH");
    tabla.put("cbUNMedidaDimensiones", "MAEPRODUMDIM");
    tabla.put("txtVoluA",   "MAEPRODVOL");
    tabla.put("cbUDV",      "MAEPRODUMVOL");
    tabla.put("txtPeso",    "MAEPRODPESO");
    tabla.put("cbUDP",      "MAEPRODUMPESO");
    tabla.put("txtUnidDentroPedido", "MAEPRODUDENPED");
    tabla.put("txtUDC",     "MAEPRODUNIDCAJ");
    tabla.put("txtCosteEstandar", "MAEPRODPRECOSE");
    tabla.put("txtPPos",    "MAEPRODPREPOS");
    tabla.put("cbSituac",   "MAEPRODSITU");
    tabla.put("cbSProd",    "MAEPRODESTPROD");
    tabla.put("cbSCaja",    "MAEPRODINDDFCAJ");
    
    tabla.put("cbFormaPago", "MAEPRODCODPAF");
    
    tabla.put("txtPrecioCatalogo", "MAEPRODPRECAT");
    tabla.put("txtPrecioContable", "MAEPRODPRECON");
    tabla.put("txtCodImpuesto", "MAEPRODCODIMPUE");
    tabla.put("txtGrupoArticulos", "MAEGRUPARTI");
    
    return tabla;
  }

/*
  private Hashtable getClavesCod()  {
    Hashtable tabla = new Hashtable();
    tabla.put(new Integer(0),"585");
    tabla.put(new Integer(1),"1059");
    tabla.put(new Integer(2),"47");
    tabla.put(new Integer(3),"1086");
    tabla.put(new Integer(4),"1087");
    tabla.put(new Integer(5),"0069");
    tabla.put(new Integer(6),"587");
    tabla.put(new Integer(7),"588");
    tabla.put(new Integer(8),"589");
    tabla.put(new Integer(9),"590");
    tabla.put(new Integer(10),"1088");
    tabla.put(new Integer(11),"1089");
    tabla.put(new Integer(12),"1090");
    tabla.put(new Integer(13),"1091");
    tabla.put(new Integer(14),"481");
    tabla.put(new Integer(15),"482");
    tabla.put(new Integer(16),"483");
    tabla.put(new Integer(17),"1070");
    tabla.put(new Integer(18),"1072");
    tabla.put(new Integer(19),"1071");
    tabla.put(new Integer(20),"1132");
    tabla.put(new Integer(21),"1140");
    tabla.put(new Integer(22),"1135");
    tabla.put(new Integer(23),"1115");
    tabla.put(new Integer(24),"1134");
    tabla.put(new Integer(25),"1132");
    tabla.put(new Integer(26),"1136");
    tabla.put(new Integer(27),"1239");
    tabla.put(new Integer(28),"1116");
    tabla.put(new Integer(29),"695");
    tabla.put(new Integer(30),"1077");
    tabla.put(new Integer(31),"1083");
    tabla.put(new Integer(32),"1063");
    tabla.put(new Integer(33),"1062");
    tabla.put(new Integer(34),"974");
    return tabla;
  }
*/

  private void obtenerSesion() throws Exception  {
      traza(" Entra a obtenerSesion ");
    //recupero objetos de sesion
    DruidaConector dcMarca = (DruidaConector)conectorParametroSesion("DCMarca");
    DruidaConector dcUnidadNegocio = (DruidaConector)conectorParametroSesion("DCUnidadNegocio");
    DruidaConector dcNegocio = (DruidaConector)conectorParametroSesion("DCNegocio");
    DruidaConector dcGenerico = (DruidaConector)conectorParametroSesion("DCGenerico");
    DruidaConector dcSuperGenerico = (DruidaConector)conectorParametroSesion("DCSuperGenerico");
    DruidaConector dcLinea = (DruidaConector)conectorParametroSesion("DCLinea");
    DruidaConector dcUnidadMedida = (DruidaConector)conectorParametroSesion("DCUnidadMedida");
    DruidaConector dcEstatus = (DruidaConector)conectorParametroSesion("DCEstatus");
    DruidaConector dcFormasPago = (DruidaConector)conectorParametroSesion("DCFormasPago");

    traza( "OPCION FORMAS PAGO: " + dcFormasPago.getXML() );
    
    asignar("COMBO","cbM",dcMarca,"DTOSalida.resultado_ROWSET");
    asignar("COMBO","cbUN",dcUnidadNegocio,"DTOSalida.resultado_ROWSET");
    asignar("COMBO","cbNeg",dcNegocio,"DTOSalida.resultado_ROWSET");
    asignar("COMBO","cbGenr",dcGenerico,"DTOSalida.resultado_ROWSET");
    asignar("COMBO","cbSuperGeg",dcSuperGenerico,"DTOSalida.resultado_ROWSET");
    asignar("COMBO","cbLin",dcLinea,"DTOSalida.lineaProducto_ROWSET");
    asignar("COMBO","cbUNMedidaDimensiones",dcUnidadMedida,"DTOSalida.unidadesMedida_ROWSET");
    asignar("COMBO","cbUDV",dcUnidadMedida,"DTOSalida.unidadesMedida_ROWSET");
    asignar("COMBO","cbUDP",dcUnidadMedida,"DTOSalida.unidadesMedida_ROWSET");
    asignar("COMBO","cbSProd",dcEstatus,"DTOSalida.estatus_ROWSET");
    asignar("COMBO","cbFormaPago",dcFormasPago,"DTOSalida.formasPago_ROWSET");
    
    traza(" Sale de obtenerSesion ");
  }


  private void cargarCamposPagina() throws Exception  {
  
    traza(" Entra en cargarCamposPagina ");
    
    int largo;
    HashMap param = new HashMap();
    param = conectorParametro();
    
    traza("Parametros " + param);
      
    asignarAtributo("LABELC","lblR1","valor",(String)conectorParametroSesion("lblR1"));
    
    if (!param.get("txtAnt").equals(null))  {
      asignarAtributo("CTEXTO","txtAnt","valor",(String)param.get("txtAnt"));
      largo = this.getLargo(param.get("txtAnt"));
      asignarAtributo("CTEXTO","txtAnt","size",new String(new Integer(largo).toString())); }
      
    if (!param.get("txtDSAP").equals(null))  {
      asignarAtributo("CTEXTO","txtDSAP","valor",(String)param.get("txtDSAP"));
      largo = this.getLargo(param.get("txtDSAP"));
      asignarAtributo("CTEXTO","txtDSAP","size",new String(new Integer(largo).toString())); }
      
    if (!param.get("txtDCorta").equals(null))  {
      asignarAtributo("CTEXTO","txtDCorta","valor",(String)param.get("txtDCorta"));
      largo = this.getLargo(param.get("txtDCorta"));
      asignarAtributo("CTEXTO","txtDCorta","size",new String(new Integer(largo).toString())); }

    //if (!param.get("R5").equals(null)) asignarAtributo("VAR","hR5","valor",(String)param.get("R5"));

    if (!param.get("hR5").equals(null)) asignarAtributo("VAR","hR5","valor",(String)param.get("hR5"));

    //if (!param.get("cbIndicadorPS").equals(null)) asignarAtributo("VAR","hcbIndicadorPS","valor",(String)param.get("cbIndicadorPS"));

    if (param.get("hcbIndicadorPS") != null ) asignarAtributo("VAR","hcbIndicadorPS","valor",(String)param.get("hcbIndicadorPS"));

    if (param.get("cbM") != null ) asignarAtributo("VAR","hcbM","valor",(String)param.get("cbM"));

    if (param.get("cbUN") != null) asignarAtributo("VAR","hcbUN","valor",(String)param.get("cbUN"));

    if (param.get("cbNeg") != null) asignarAtributo("VAR","hcbNeg","valor",(String)param.get("cbNeg"));

    if (param.get("cbGenr") != null) asignarAtributo("VAR","hcbGenr","valor",(String)param.get("cbGenr"));

    if (param.get("cbSuperGeg") != null) asignarAtributo("VAR","hcbSuperGeg","valor",(String)param.get("cbSuperGeg"));

    if (param.get("txtJ1") != null) asignarAtributo("CTEXTO","txtJ1","valor",(String)param.get("txtJ1"));

    if (param.get("txtJ2") != null) asignarAtributo("CTEXTO","txtJ2","valor",(String)param.get("txtJ2"));

    if (param.get("txtJ3") != null) asignarAtributo("CTEXTO","txtJ3","valor",(String)param.get("txtJ3"));

    if (param.get("cbLin") != null) asignarAtributo("VAR","hcbLin","valor",(String)param.get("cbLin"));

    if (param.get("txtA1") != null) asignarAtributo("CTEXTO","txtA1","valor",(String)param.get("txtA1"));

    if (param.get("txtA2") != null) asignarAtributo("CTEXTO","txtA2","valor",(String)param.get("txtA2"));

    if (param.get("txtA3") != null) asignarAtributo("CTEXTO","txtA3","valor",(String)param.get("txtA3"));

    if (param.get("txtDA") != null) asignarAtributo("CTEXTO","txtDA","valor",(String)param.get("txtDA"));

    if (param.get("txtDL") != null) asignarAtributo("CTEXTO","txtDL","valor",(String)param.get("txtDL"));


    if (param.get("txtDAL") != null) asignarAtributo("CTEXTO","txtDAL","valor",(String)param.get("txtDAL"));


    if (param.get("cbUNMedidaDimensiones") != null) asignarAtributo("VAR","hcbUNMedidaDimensiones","valor",(String)param.get("cbUNMedidaDimensiones"));

    if (param.get("txtVoluA") != null) asignarAtributo("CTEXTO","txtVoluA","valor",(String)param.get("txtVoluA"));

    if (param.get("cbUDV") != null) asignarAtributo("VAR","hcbUDV","valor",(String)param.get("cbUDV"));

    //if (!param.get("txtDAPesodf").equals(null)) asignarAtributo("CTEXTO","txtDAPesodf","valor",(String)param.get("txtDAPesodf"));
    if (param.get("txtPeso") != null) asignarAtributo("CTEXTO","txtPeso","valor",(String)param.get("txtPeso"));

    if (param.get("cbUDP") != null) asignarAtributo("VAR","hcbUDP","valor",(String)param.get("cbUDP"));

    if (param.get("txtUnidDentroPedido") != null) asignarAtributo("CTEXTO","txtUnidDentroPedido","valor",(String)param.get("txtUnidDentroPedido"));

    if (param.get("txtUDC") != null) asignarAtributo("CTEXTO","txtUDC","valor",(String)param.get("txtUDC"));

    if (param.get("txtCosteEstandar") != null) asignarAtributo("CTEXTO","txtCosteEstandar","valor",(String)param.get("txtCosteEstandar"));

    if (param.get("txtPPos") != null) asignarAtributo("CTEXTO","txtPPos","valor",(String)param.get("txtPPos"));

    if (param.get("cbSituac") != null) asignarAtributo("VAR","hcbSituac","valor",(String)param.get("cbSituac"));

    if (param.get("cbSProd") != null) asignarAtributo("VAR","hcbSProd","valor",(String)param.get("cbSProd"));

    if (param.get("cbSCaja") != null) asignarAtributo("VAR","hcbSCaja","valor",(String)param.get("cbSCaja"));

    //if (!param.get("txtPrecCa").equals(null)) asignarAtributo("CTEXTO","txtPrecCa","valor",(String)param.get("txtPrecCa"));
    //if (!param.get("cbCodPagoFraccionado").equals(null)) asignarAtributo("CTEXTO","cbCodPagoFraccionado","valor",(String)param.get("cbCodPagoFraccionado"));
    
    if (param.get("cbFormaPago") != null ) asignarAtributo("COMBO","cbFormaPago","valor",(String)param.get("cbFormaPago"));

    if (param.get("txtCodImpuesto") != null) asignarAtributo("CTEXTO","txtCodImpuesto","valor",(String)param.get("txtCodImpuesto"));

    if (param.get("txtPrecioCatalogo") != null) asignarAtributo("CTEXTO","txtPrecioCatalogo","valor",(String)param.get("txtPrecioCatalogo"));

    if (param.get("txtPrecioContable") != null) asignarAtributo("CTEXTO","txtPrecioContable","valor",(String)param.get("txtPrecioContable"));

    if (param.get("txtGrupoArticulos") != null) asignarAtributo("CTEXTO","txtGrupoArticulos","valor",(String)param.get("txtGrupoArticulos"));

    traza(" Sale de cargarCamposPagina ");
  }

  private int getLargo(Object param)  {
    String var = new String(param.toString());
    return var.length();
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

}

/******************************************************************************************************
si accion="" {
idBusiness="MAERellenarCombosMateriales"
Se crea un DTOBelcorp y se mete el idioma y el pais del usuario
Se llama ConectorRellenarCombosMateriales y con el DTOCombosMateriales obtenido se cargan los combos de la pantalla:
salvo el de productoServicio que sólo tiene dos elementos (Producto y Servicio) y el de dentroCaja que tambien sólo tiene dos elementos (SI y NO)
los tres combos unidMedida se cargan con el atributo unidadesMedida

idBusiness=" MAEConsultarProducto"
Se crea un DTOOID con el oid recibido como parametro de la página de consulta.
Se llama al ConectorConsultarProducto
Con el DTOProducto que obtenemos rellenamos los campos de la pantalla.

idBusiness="MAEConsultarConfiguracionCamposProductos"
se crea un DTOCampo para cada campo de la pantalla rellenando sólamente el código de campo (mirar nota en el diagrama).
Metemos todos los DTOCampo que hemos creado en un DTOConfiguracionCamposProducto, (se rellena el pais y el idioma)
se llama al ConectorConfiguracionCamposProductos y obtenemos el mismo DTOConfiguracionCampos pero cada DTOCampo tiene rellenadas sus propiedades.
Leemos las propiedades de cada campo y actuamos en consecuencia: si modificable es false ese campo no será editable y si obligatorio es true el campo no se puede dejar en blanco.
}

si accion ="Guardar" {
idBusiness="MAEModificarProducto"
Se crea un DTOProducto y se rellena con los campos de la pantalla.
Se llama al ConectorModificarProducto
}
******************************************************************************************************/
/*
public Long getOid()
public void setOid(Long newOid)
  public String getCodSAP()
  public void setCodSAP(String newCodSAP)
  public String getCodAntiguo()
  public void setCodAntiguo(String newCodAntiguo)
  public Vector getDescSapI18n() {
  public void setDescSapI18n(Vector newDescSapI18n)
    public String getDescSAP()
    public void setDescSAP(String newDescSAP)
  public String getDescCorta()
  public void setDescCorta(String newDescCorta)
public Boolean getIndLote()
public void setIndLote(Boolean newIndLote)
public Boolean getProductoServicio()
public void setProductoServicio(Boolean newProductoServicio)
public Long getOidMarca()
public void setOidMarca(Long newOidMarca)
public Long getUnidadNegocio()
public void setUnidadNegocio(Long newUnidadNegocio)
public Long getNegocio()
public void setNegocio(Long newNegocio)
public Long getGenerico()
public void setGenerico(Long newGenerico)
public Long getSupergenerico()
public void setSupergenerico(Long newSupergenerico)
public String getJerarquia1()
public void setJerarquia1(String newJerarquia1)
public String getJerarquia2()
public void setJerarquia2(String newJerarquia2)
public String getJerarquia3()
public void setJerarquia3(String newJerarquia3)
public Long getLineaProducto()
public void setLineaProducto(Long newLineaProducto)
public String getAtributo1()
public void setAtributo1(String newAtributo1)
public String getAtributo2()
public void setAtributo2(String newAtributo2)
public String getAtributo3()
public void setAtributo3(String newAtributo3)
public BigDecimal getAlto()
public void setAlto(BigDecimal newAlto)
public BigDecimal getLargo()
public void setLargo(BigDecimal newLargo)
public BigDecimal getAncho()
public void setAncho(BigDecimal newAncho)
public Long getUnidMedidaDimensiones()
public void setUnidMedidaDimensiones(Long newUnidMedidaDimensiones)
public BigDecimal getVolumen()
public void setVolumen(BigDecimal newVolumen)
public Long getUnidMedidaVolumen()
public void setUnidMedidaVolumen(Long newUnidMedidaVolumen)
public BigDecimal getPeso()
public void setPeso(BigDecimal newPeso)
public Long getUnidMedidaPeso()
public void setUnidMedidaPeso(Long newUnidMedidaPeso)
public Integer getUnidDentroPedido()
public void setUnidDentroPedido(Integer newUnidDentroPedido)
public Integer getUnidPorCaja()
public void setUnidPorCaja(Integer newUnidPorCaja)
public BigDecimal getCosteEstandar()
public void setCosteEstandar(BigDecimal newCosteEstandar)
public BigDecimal getPrecioPosicionamiento()
public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento)
public Character getSituacion()
public void setSituacion(Character newSituacion)
public Long getEstatus()
public void setEstatus(Long newEstatus)
public Character getCajaBolsa()
public void setCajaBolsa(Character newCajaBolsa)
public String getCodPagoFraccionado()
public void setCodPagoFraccionado(String newCodPagoFraccionado)
public String getCodImpuesto()
public void setCodImpuesto(String newCodImpuesto)
public BigDecimal getPrecioCatalogo()
public void setPrecioCatalogo(BigDecimal newPrecioCatalogo)
public BigDecimal getPrecioContable()
public void setPrecioContable(BigDecimal newPrecioContable)
*/
