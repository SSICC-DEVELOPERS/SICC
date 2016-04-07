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
    $Id: LPBusquedaMateriales.java,v 1.1 2009/12/03 18:42:57 pecbazalar Exp $
    DESC
*/

import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.util.UtilidadesSession;
import java.util.HashMap;
import java.io.*;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOCombosBusquedaMateriales;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.util.DTOSalida;


public class LPBusquedaMateriales extends LPSICCBase {

  String accion;
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


  public LPBusquedaMateriales()  {
    super();
  }


	public void inicio() throws Exception  {
    pagina("contenido_materiales_modificar");
	getConfiguracionMenu();
  }


  public void ejecucion() throws Exception  {
    try{
     
      setTrazaFichero();
      traza("********************************************************");
      traza("********************* ejecucion() LPBusquedaMateriales **********************");
      traza("********************************************************");
      accion = conectorParametroLimpia("accion","",true);
      codigoSAP = conectorParametroLimpia("txtCodSAP","",true);
      codigoAntiguo = conectorParametroLimpia("txtAnt","",true);
      descripcionSAP = conectorParametroLimpia("txtDSAP","",true);
      descripcionCorta = conectorParametroLimpia("txtDCorta","",true);
      indicadorLote = conectorParametroLimpia("R5","",true);
      indicadorProdServ = conectorParametroLimpia("cbIndicadorPS","",true);
      marca = conectorParametroLimpia("cbM","",true);
      unidadNegocio = conectorParametroLimpia("cbUN","",true);
      negocio = conectorParametroLimpia("cbNeg","",true);
      generico = conectorParametroLimpia("cbGeg","",true);
      superGenerico = conectorParametroLimpia("cbSNeg","",true);

        traza(" accion : " + accion);
        traza(" codigoSAP : " + codigoSAP);
        traza(" codigoAntiguo : " + codigoAntiguo );
        traza(" descripcionSAP : " + descripcionSAP );
        traza(" descripcionCorta : " + descripcionCorta );
        traza(" indicadorLote : " + indicadorLote );
        traza(" indicadorProdServ : " + indicadorProdServ );
        traza(" marca : " + marca );
        traza(" unidadNegocio : " + unidadNegocio );
        traza(" negocio : " + negocio );
        traza(" generico : " + generico );
        traza(" superGenerico : " + superGenerico );

  //accion == " " -----------------------------------------------------------------------------------------
      if (accion.equals(""))  {
        traza(" Entra en accion vacia ");
		// Rastreo
		this.rastreo();

        rellenarComboBusquedaMateriales(); 
        getConfiguracionMenu("LPBusquedaMateriales", "");
        traza(" Sale de accion vacia " );
      }

  //accion == "Buscar" -------------------------------------------------------------------------------------
	if (accion.equals("Buscar"))  {
        traza(" Entra en accion Buscar ");
        buscar();
        asignarAtributo("VAR","accion", "valor", accion);

        //flag para mover la capa de resultado hacia abajo
        this.asignarAtributo( "VAR", "hMostrarResultado", "valor", "S" );

        traza(" Sale de accion Buscar ");
      }

  //accion == "Modificar" -----------------------------------------------------------------------------------
      if (accion.equals("Modificar"))  {
        //-Se pasa el control a la LPModificarMateriales pasandole el oid oculto de la fila que ha seleccionado
          traza(" Entra en accion Modificar ");
        invocaLP();
        // guarda en sesion los valores del filtro para utilizarlo despues de guardar en la LPModificarMateriales   
        conectorParametroSesion("filtroCodigoSAP",codigoSAP);
        conectorParametroSesion("filtroCodigoAntiguo",codigoAntiguo);
        conectorParametroSesion("filtroDescripcionSAP",descripcionSAP);
        conectorParametroSesion("filtroDescripcionCorta",descripcionCorta);
        conectorParametroSesion("filtroIndicadorLote",indicadorLote);
        conectorParametroSesion("filtroIndicadorProdServ",indicadorProdServ);
        conectorParametroSesion("filtroMarca",marca);
        conectorParametroSesion("filtroUnidadNegocio",unidadNegocio);
        conectorParametroSesion("filtroNegocio",negocio);
        conectorParametroSesion("filtroGenerico",generico);
        conectorParametroSesion("filtroSuperGenerico",superGenerico);
        traza(" Sale de accion Modificar ");
      }

  //accion == "Volver" -------------------------------------------------------------------------------------
      if (accion.equals("Volver"))  {

//NO DEBERIA HABER VOLVER
/*
          traza("Entra a accion Volver ");
        String txtCodSAP = (String)conectorParametroSesion("txtCodSAP");
        String txtAnt= (String)conectorParametroSesion("txtAnt");
        String txtDSAP= (String)conectorParametroSesion("txtDSAP");
        String txtDCorta= (String)conectorParametroSesion("txtDCorta");
        String R5= (String)conectorParametroSesion("R5");
        String cbPS= (String)conectorParametroSesion("cbPS");
        String cbMarca= (String)conectorParametroSesion("cbMarca");
        String cbUnNeg= (String)conectorParametroSesion("cbUnNeg");
        String cbNego= (String)conectorParametroSesion("cbNego");
        String cbGenerico= (String)conectorParametroSesion("cbGenerico");
        String cbSupGenerico= (String)conectorParametroSesion("cbSupGenerico");

          //traza("Cargo los componentes de la pagina");
        DruidaConector dcMarca = (DruidaConector)conectorParametroSesion("DCMarca"); 
        asignar("COMBO","cbM",dcMarca,"DTOSalida.resultado_ROWSET");
        DruidaConector dcUnidadNegocio = (DruidaConector)conectorParametroSesion("DCUnidadNegocio");
        asignar("COMBO","cbUN",dcUnidadNegocio,"DTOSalida.resultado_ROWSET");
        DruidaConector dcNegocio = (DruidaConector)conectorParametroSesion("DCNegocio");
        asignar("COMBO","cbNeg",dcNegocio,"DTOSalida.resultado_ROWSET");
        DruidaConector dcGenerico = (DruidaConector)conectorParametroSesion("DCGenerico");
        asignar("COMBO","cbGeg",dcGenerico,"DTOSalida.resultado_ROWSET");
        DruidaConector dcSuperGenerico = (DruidaConector)conectorParametroSesion("DCSuperGenerico");
        asignar("COMBO","cbSNeg",dcSuperGenerico,"DTOSalida.resultado_ROWSET");
          //traza("Realizamos la transform XSL");
//        DruidaConector lista = (DruidaConector)conectorParametroSesion("lista");
//        DruidaConector conectorFinal= transformar("XSLListaModificarMateriales",lista); 
//        asignar("LISTA","lstresultados",conectorFinal,"DTOSalida.resultado_ROWSET");
        asignarAtributo("CTEXTO","txtCodSAP","valor",txtCodSAP);
        asignarAtributo("CTEXTO","txtAnt","valor",txtAnt);
        asignarAtributo("CTEXTO","txtDSAP","valor",txtDSAP);
        asignarAtributo("CTEXTO","txtDCorta","valor",txtDCorta);
        asignarAtributo("VAR","cbPS","valor",cbPS);
        asignarAtributo("VAR","cbMarca","valor",cbMarca);
        asignarAtributo("VAR","cbNego","valor",cbNego);
        asignarAtributo("VAR","cbUnNeg","valor",cbUnNeg);
        asignarAtributo("VAR","cbGenerico","valor",cbGenerico);
        asignarAtributo("VAR","cbSupGenerico","valor",cbSupGenerico);
        asignarAtributo("VAR","hR5","valor",R5);
//asignarAtributo("VAR",hOID,"valor",((Object)new Integer(rsUnidadNegocio.getColumnCount())).toString());
        asignarAtributo("CAPA","capaModif","visibilidad","visible");
        asignarAtributo("CAPA","Resultado","visibilidad","visible");
        asignarAtributo("VAR","accion","valor","Volver");
          traza(" Sale de accion Volver ");
*/
      }


  //-------------------------------------------------------------------------------------------------------
    } catch (Exception ex){
		traza( ex );
        traza( "-------------------------------------------------" );
        lanzarPaginaError(ex);
	}
  }//ejecucion()
  //-------------------------------------------------------------------------------------------------------


  private void rellenarComboBusquedaMateriales() throws Exception  {
    traza(" Entra a rellenarComboBusquedaMateriales ");
    
    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoBelcorp.setOidPais(sesion.getPais(this));
    dtoBelcorp.setOidIdioma(sesion.getIdioma(this));
    Vector objBussines = new Vector();
    //-idBusiness="MAERellenarCombosBusquedaMateriales"
    objBussines.add(dtoBelcorp);
    objBussines.add(new MareBusinessID("MAERellenarCombosBusquedaMateriales"));
    //-Se llama al ConectorCargaCombosMateriales con un DTOBelcorp en el que se mete el pais y el idioma del usuario.

    traza("------------------------------------------------");
    traza("dtoBelcorp: " + dtoBelcorp);
    traza("------------------------------------------------");

    traza("ANTES DE CONECTAR");
    DruidaConector con = null;
    con = conectar("ConectorBusquedaMateriales", objBussines);
    traza("CONECTADO");
    
    DTOCombosBusquedaMateriales dtoCBM = (DTOCombosBusquedaMateriales) con.objeto("DTOSalida");
    //-Con el DTOCombosBusquedaMateriales recibido cargamos los correspondientes combos de la PantallaBusquedaMateriales
    RecordSet rsMarca = (RecordSet)dtoCBM.getMarcasProducto();
	Vector colMarca = null;
	DruidaConector dcMarca = null;

	if(rsMarca != null && !rsMarca.esVacio()){
		colMarca = rsMarca.getColumnIdentifiers();
		if(colMarca != null){
			dcMarca = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsMarca, colMarca);
			asignar("COMBO","cbM",dcMarca,"DTOSalida.resultado_ROWSET");
		}
	}

    //************************************************
    RecordSet rsUnidadNegocio = (RecordSet)dtoCBM.getUnidadNegocio();
	Vector colUnidadNegocio = null;
	DruidaConector dcUnidadNegocio = null;

	if( rsUnidadNegocio != null && !rsUnidadNegocio.esVacio() ){
		colUnidadNegocio = rsUnidadNegocio.getColumnIdentifiers();
		if( colUnidadNegocio != null ){
			dcUnidadNegocio = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsUnidadNegocio, colUnidadNegocio);
			asignar("COMBO","cbUN",dcUnidadNegocio,"DTOSalida.resultado_ROWSET");
		}
	}

    //************************************************
    RecordSet rsNegocio = (RecordSet)dtoCBM.getNegocio();
	Vector colNegocio = null;
	DruidaConector dcNegocio = null;

	if( rsNegocio != null && !rsNegocio.esVacio() ){
		colNegocio = rsNegocio.getColumnIdentifiers();
		if( colNegocio != null ){
			dcNegocio = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsNegocio, colNegocio);
			asignar("COMBO","cbNeg",dcNegocio,"DTOSalida.resultado_ROWSET");
		}
	}

    //************************************************
    RecordSet rsGenerico = (RecordSet)dtoCBM.getGenerico();
	Vector colGenerico = null;
	DruidaConector dcGenerico = null;

	if( rsGenerico != null && !rsGenerico.esVacio() ){
		 colGenerico = rsGenerico.getColumnIdentifiers();
		if( colGenerico != null ){
			dcGenerico = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsGenerico, colGenerico);
			asignar("COMBO","cbGeg",dcGenerico,"DTOSalida.resultado_ROWSET");
		}
	}

    //************************************************
    RecordSet rsSuperGenerico = (RecordSet)dtoCBM.getSupergenerico();
	Vector colSuperGenerico = null;
	DruidaConector dcSuperGenerico = null;

	if( rsSuperGenerico != null && !rsSuperGenerico.esVacio() ){
		 colSuperGenerico = rsSuperGenerico.getColumnIdentifiers();
		if( colSuperGenerico != null ){
			dcSuperGenerico = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsSuperGenerico, colSuperGenerico);
			asignar("COMBO","cbSNeg",dcSuperGenerico,"DTOSalida.resultado_ROWSET");
		}
	}

    //valores de combos en sesion para carga futura
	if( dcMarca != null ){
		conectorParametroSesion("DCMarca", dcMarca);
	}
	if( dcUnidadNegocio != null ){
		conectorParametroSesion("DCUnidadNegocio", dcUnidadNegocio);
	}
	if( dcNegocio != null ){
		conectorParametroSesion("DCNegocio", dcNegocio);
	}
	if( dcGenerico != null ){
		conectorParametroSesion("DCGenerico", dcGenerico);
	}
	if( dcSuperGenerico != null ){
		conectorParametroSesion("DCSuperGenerico", dcSuperGenerico);
	}
    
    traza(" Sale de rellenarComboBusquedaMateriales ");
  }


  private void buscar() throws Exception  {
        traza(" Entra en FUNCION BUSCAR ");
        
      //-Se crea a un DTOBusquedaMateriales con los valores que ha introducido el usuario, si no ha introducido algún campo se pone null
      DTOBusquedaMateriales dtoBusMat = new DTOBusquedaMateriales();
      UtilidadesSession sesion = new UtilidadesSession();
      dtoBusMat.setOidPais(sesion.getPais(this));
      dtoBusMat.setOidIdioma(sesion.getIdioma(this));
      
    //Hardcodeado
      dtoBusMat.setIndicadorSituacion(new Long(1));
      dtoBusMat.setTamanioPagina(new Integer(1000));
      
      if ( codigoSAP == null || codigoSAP.equals("") ) dtoBusMat.setCodSAP(null);
        else dtoBusMat.setCodSAP(codigoSAP);
      if ( codigoAntiguo == null || codigoAntiguo.equals("") ) dtoBusMat.setCodAntiguo(null);
        else dtoBusMat.setCodAntiguo(codigoAntiguo);
			if ( descripcionSAP == null || descripcionSAP.equals("") ) dtoBusMat.setDescSAP(null);
        else dtoBusMat.setDescSAP( descripcionSAP );
			if ( descripcionCorta == null || descripcionCorta.equals("") ) dtoBusMat.setDescCorta(null);
        else dtoBusMat.setDescCorta( descripcionCorta );
			if ( indicadorLote == null || indicadorLote.equals("") ) dtoBusMat.setIndLote(null);
        else if (indicadorLote.equals("S")) dtoBusMat.setIndLote(Boolean.TRUE);
             else dtoBusMat.setIndLote(Boolean.FALSE);
			if ( indicadorProdServ == null || indicadorProdServ.equals("") ) dtoBusMat.setIndProductoServicio(null);
        else if (indicadorProdServ.equals("1")) dtoBusMat.setIndProductoServicio(Boolean.TRUE);
             else dtoBusMat.setIndProductoServicio(Boolean.FALSE);
			if ( marca == null || marca.equals("") ) dtoBusMat.setMarca(null);
        else dtoBusMat.setMarca( Long.valueOf(marca) );
			if ( unidadNegocio == null || unidadNegocio.equals("") ) dtoBusMat.setUnidadNegocio(null);
        else dtoBusMat.setUnidadNegocio( Long.valueOf(unidadNegocio) );
			if ( negocio == null || negocio.equals("") ) dtoBusMat.setNegocio(null);
        else dtoBusMat.setNegocio( Long.valueOf(negocio) );
			if ( generico == null || generico.equals("") ) dtoBusMat.setGenerico(null);
        else dtoBusMat.setGenerico( Long.valueOf(generico) );
			if ( superGenerico == null || superGenerico.equals("") ) dtoBusMat.setSupergenerico(null);
        else dtoBusMat.setSupergenerico( Long.valueOf(superGenerico) );

      Vector objBussines = new Vector();
      
      //-idBusiness = "MAEBuscarMateriales"
      objBussines.add(dtoBusMat);
      objBussines.add(new MareBusinessID("MAEBuscarMateriales"));

      //-Se llama al ConectorBusquedaMateriales
      //DruidaConector con = conectar("ConectorBusquedaMaterialesPaginado",objBussines);
      
      //IMareDTO dtoOut = (IMareDTO) con.objeto("DTOSalida");
      //traza(" dtoOut " + dtoOut );

      
      //0=[801_02, codi_anti, des_cort, 0, 0, 1, Marca 1, 1, 2, 1, 1, 1, fasdfasdf, Unidad 2, Negocio 1, Generico1, Super Generico1]

      //-Con el DTOSalida que obtenemos rellenamos la lista resultados depues de hacer las siguientes modificaciones:
      //la columna indLote se debe poner un "SI" donde esté un 1 y un "NO" donde esté un 0 (o en el idioma que corresponda)
      //en la columna indProductoServicio si tenemos un 1 pondremos "Servicio" y si es un 0 será "Producto" (o en el idioma que corresponda)
      //La primera columna del recordset no se muestra sino que se guarda en un campo oculto de cada fila (es el oid)

      /*
      DTOSalida dtoResultado = (DTOSalida)dtoOut.getProperty("resultado");
      RecordSet rsResultado = (RecordSet)dtoResultado.getResultado();  
      Vector columnas = rsResultado.getColumnIdentifiers();
      */
      
      //columnas :
      // [COD_SAP, CODI_ANTI, DES_CORT, IND_LOTE, IND_PROD_SERV, MARC_OID_MARC, DES_MARC, 
      //  OID_PROD, UNEG_OID_UNID_NEGO, NEGO_OID_NEGO, GENE_OID_GENE, SGEN_OID_SUPE_GENE, 
      //  DES_MAE_PRODU, DES_MAE_UNIDA_NEGOC, DES_MAE_NEGOC, DES_MAE_GENER, DES_MAE_SUPER_GENER]

      /*
      DruidaConector dcListaBusqueda = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsResultado, columnas);
      traza("-----------------------------------------");
      traza("conector antes de transformar");
      traza(dcListaBusqueda.getXML());
      traza("-----------------------------------------");
      DruidaConector dcLista = transformar("XSLListaModificarMateriales",dcListaBusqueda);
        traza(" dcLista " + dcLista.getXML() );
      */
        
      //asignar("LISTA","lstresultados",dcLista,"DTOSalida.resultado_ROWSET");
      //asignar("LISTA", "lstresultados", dcListaBusqueda, "DTOSalida.resultado_ROWSET");

/*
      traza("---------------------------");
      traza("CONECTOR:");
      traza( con.getXML() );
      traza("---------------------------");
*/

      //asignar("LISTA", "lstresultados", con, "DTOSalida.resultado_ROWSET");
      asignarAtributo("CAPA", "Resultado", "visibilidad", "visible");
      asignarAtributo("CAPA","capaModif","visibilidad","visible");

      //podria hacer funcion enviarVarsOcultas()
      //para completar filtros de la búsqueda
      asignarAtributo("CTEXTO","txtCodSAP","valor",codigoSAP);
      asignarAtributo("CTEXTO","txtAnt","valor",codigoAntiguo);
      asignarAtributo("CTEXTO","txtDSAP","valor",descripcionSAP);
      asignarAtributo("CTEXTO","txtDCorta","valor",descripcionCorta);
      asignarAtributo("VAR","hR5","valor",indicadorLote);
      asignarAtributo("VAR","hcbIndicadorPS","valor",indicadorProdServ);
      asignarAtributo("VAR","hcbM","valor",marca);
      asignarAtributo("VAR","hcbUN","valor",unidadNegocio);
      asignarAtributo("VAR","hcbNeg","valor",negocio);
      asignarAtributo("VAR","hcbGeg","valor",generico);
      asignarAtributo("VAR","hcbSNeg","valor",superGenerico);

//podria hacer funcion completarCombosFiltro()
      //completa combos para filtos de la búsqueda
      DruidaConector dcMarca = (DruidaConector)conectorParametroSesion("DCMarca");
      asignar("COMBO","cbM",dcMarca,"DTOSalida.resultado_ROWSET");
      DruidaConector dcUnidadNegocio = (DruidaConector)conectorParametroSesion("DCUnidadNegocio");
      asignar("COMBO","cbUN",dcUnidadNegocio,"DTOSalida.resultado_ROWSET");
      DruidaConector dcNegocio = (DruidaConector)conectorParametroSesion("DCNegocio");
      asignar("COMBO","cbNeg",dcNegocio,"DTOSalida.resultado_ROWSET");
      DruidaConector dcGenerico = (DruidaConector)conectorParametroSesion("DCGenerico");
      asignar("COMBO","cbGeg",dcGenerico,"DTOSalida.resultado_ROWSET");
      DruidaConector dcSuperGenerico = (DruidaConector)conectorParametroSesion("DCSuperGenerico");
      asignar("COMBO","cbSNeg",dcSuperGenerico,"DTOSalida.resultado_ROWSET");
        traza( " Sale de FUNCION BUSCAR " );
  }


  private void invocaLP() throws Exception  {
        traza(" Entra a invocaLP");
      conectorAction("LPModificarMateriales");

      traza("------------------------------------------");
      traza( "oIDSeleccionado: " + conectorParametroLimpia("hOID","",true) );
      traza("------------------------------------------");
      
      conectorActionParametro("oIDSeleccionado", conectorParametroLimpia("hOID","",true) );
/*      
      conectorActionParametro("txtCodSAP",codigoSAP);
      conectorActionParametro("txtAnt",codigoAntiguo);
      conectorActionParametro("txtDSAP",descripcionSAP);
      conectorActionParametro("txtDCorta",descripcionCorta);
      conectorActionParametro("R5",indicadorLote);
      conectorActionParametro("cbIndicadorPS",indicadorProdServ);
      conectorActionParametro("cbM",marca);
      conectorActionParametro("cbUN",unidadNegocio);
      conectorActionParametro("cbNeg",negocio);
      conectorActionParametro("cbGeg",generico);
      conectorActionParametro("cbSNeg",superGenerico);
*/
      
		traza(" Sale de invocaLP");
  }

}//class

/******************************************************************************************************
si accion = "" {
-idBusiness="MAERellenarCombosBusquedaMateriales"
-Se llama al ConectorCargaCombosMateriales con un DTOBelcorp en el que se mete el pais y el idioma del usuario.
-Con el DTOCombosBusquedaMateriales recibido cargamos los correspondientes combos de la PantallaBusquedaMateriales
} 

si accion= "Buscar" {
-idBusiness = "MAEBuscarMateriales"
-Se crea a un DTOBusquedaMateriales con los valores que ha introducido el usuario, si no ha introducido algún campo se pone null
-Se llama al ConectorBusquedaMateriales
-Con el DTOSalida que obtenemos rellenamos la lista resultados depues de hacer las siguientes modificaciones:
la columna indLote se debe poner un "SI" donde esté un 1 y un "NO" donde esté un 0 (o en el idioma que corresponda)
en la comuna indProductoServicio si tenemos un 1 pondremos "Servicio" y si es un 0 será "Producto" (o en el idioma que corresponda)
La primera columna del recordset no se muestra sino que se guarda en un campo oculto de cada fila (es el oid)
}

si accion="Modificar" {
- Se pasa el control a la LPModificarMateriales pasandole el oid oculto de la fila que ha seleccionado
}
******************************************************************************************************/
