import es.indra.druida.DruidaTransaction;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

//import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.mare.common.dto.MareDTO;
import java.util.Vector;

//DTOS
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.zon.DTOEstadoZona;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import es.indra.druida.DruidaConectorException;

public class DTZonificacion extends DruidaTransactionComun {
	//private static final String CONECTOR_CONSULTA_UA = "ConectorConsultaUA" ;
	//private static final String CONECTOR_ASIGNAR_ESTADOZONA = "ConectorAsignarEstadoZona" ;
	//private static final String CONECTOR_OBTENER_UNIGEO = "ConectorConsultaUnidadesGeograficas" ;

	public DTZonificacion() {
		super();
	}

	/**
	Parametros de entrada desde ConectorDTZON.xml

		nombreConector -> Es el codigo del conector a ejecutar
							1 -> 	CONECTOR_CONSULTA_UA
							2 -> 	CONECTOR_ASIGNAR_ESTADOZONA
							3 ->  CONECTOR_OBTENER_UNIGEO

		
		params ->	Todos los parametros con el separador de campos ? 
						Dependen de lo que se necesite en la funcion

					Ej: xxxxxx?rrrrrr?1111?aaaaaa?ddddd -> 5 parametros.
					Ej: vvvvvv?eeee							-> 2 parametros.
	
	*/

	public void ejecucion() throws Exception {
		DruidaConector dcFinal = null;
		String mensajeResultado = "";
		try{


			setTrazaFichero();

			String sIDConector =  (String) getEntrada("nombreConector") ;
			traza("sIDConector [nombreConector] " + sIDConector );
			String sParams =  (String) getEntrada("parametros") ;
			traza("sParams " + sParams );

			if ( sIDConector.equals( "ConectorConsultaUA" ) ){
				dcFinal = f_conector_consulta_ua( sParams ) ;
			} 
			else if ( sIDConector.equals( "ConectorAsignarEstadoZona" ) ){
				dcFinal = f_asignar_estado_zona( sParams ) ;
			}
			else if ( sIDConector.equals( "ConectorConsultaUnidadesGeograficas" ) ){
				dcFinal = f_obtener_ubigeo( sParams ) ;            
			}
            else if ( sIDConector.equals( "ConectorConsultaUnidadesGeograficasEstado" ) ){
				dcFinal = f_obtener_ubigeo_estado( sParams ) ;            
			}
			else if ( sIDConector.equals("ConectorConsultaUGTerritorios" ) ){
				dcFinal = f_obtener_ug_territorios( sParams ) ;            
			}
		}
		catch(Exception e){			
			ByteArrayOutputStream stack = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(stack);
			e.printStackTrace(out);

			traza(  stack.toString());
/*

			BelcorpError belcorpError = new BelcorpError();
			DTOError dtoError = belcorpError.obtenerError(	th, 
																			UtilidadesSession.getIdioma_ISO( this ) , 
																			""	
																		);

			String s = th.getMessage();
			traza("vivi2");
			traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
			asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
			asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()) ;			

			traza( "END EJECUCION CON ERRORES  ********************************************");	

			*/

			throw new DruidaConectorException(obtenerMensajeErrorCortado(e));

			
		}
		 setConector( dcFinal );		

	}

//////////////////////////////////////////////////////////////////////////////////

	private DruidaConector f_conector_consulta_ua(  String pParams ) throws Exception {
		traza("BEGIN f_conector_consulta_ua");
		//Parametros en sParams : :
		//	primero -> BusinessID a ejecutar 
		//	segundo -> marca
		//	tercero -> canal				
		DruidaConector dcRetorno = null;
		traza( "pParams " + pParams );

		StringTokenizer stk = new StringTokenizer( pParams , "?" );

		traza("stk.countTokens() " + stk.countTokens() );
		String sBizId = stk.nextToken();

		Vector vecParametros = new Vector(2);
		DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
		dtoUA.setIpCliente( UtilidadesBelcorp.getIPCliente( this) );
		dtoUA.setPrograma( UtilidadesSession.getFuncion( this ) );
		dtoUA.setOidIdioma( UtilidadesSession.getIdioma( this) );
		dtoUA.setOidPais( UtilidadesSession.getPais( this)  );

		traza("1");
		String sMarca = null;
		if ( stk.hasMoreTokens() ){
			 sMarca = stk.nextToken();
		}
		
		traza("2");
		String sCanal = null;
		if ( stk.hasMoreTokens() ){
			 sCanal = stk.nextToken();
		}
		traza("3");

		if ( sMarca != null && !sMarca.equals("") ){
			dtoUA.setOidMarca( new Long( sMarca )  );
		}
		
		traza("4");

		if ( sCanal != null &&  !sCanal.equals("") ){
			dtoUA.setOidCanal( new Long( sCanal )  );
		}
		traza("5");

		String sRegion = null;
		if ( stk.hasMoreTokens() ){
			 sRegion = stk.nextToken();
			 dtoUA.setOidRegion( new Long( sRegion )  );
			 traza("6");
		}

		traza("dtoUA:" +  dtoUA);

		vecParametros.add( dtoUA ); 

		if (  sBizId.equals("ZONObtenerRegiones") ){
		//////////////////////////////////////////////////////////////////////////////////
		//									ZONObtenerRegiones  
			traza("BEGIN ZONObtenerRegiones");
			vecParametros.add( new MareBusinessID( "ZONObtenerRegiones" ) ); 

			traza("Antes ConectorConsultaUA-ZONObtenerRegiones");
			DruidaConector dcTemp = conectar( "ConectorConsultaUA", vecParametros ); 
			dcRetorno = transformar( "ZON_xslArmaComboRegiones", dcTemp );

			conectorParametroSesion("ZONcomboRegiones" ,dcRetorno);
			conectorParametroSesion("ZONZonas" ,new Integer(0));

			 //traza( dcRetorno.getXML() );
			traza("END ZONObtenerRegiones");
		//////////////////////////////////////////////////////////////////////////////////
		}
		else if (  sBizId.equals("MLNFObtenerRegionesNoBorradas") ){
		//////////////////////////////////////////////////////////////////////////////////
		//									ZONObtenerRegiones  
			traza("BEGIN MLNFObtenerRegionesNoBorradas");
			vecParametros.add( new MareBusinessID( "MLNFObtenerRegionesNoBorradas" ) ); 

			traza("Antes ConectorConsultaUA-MLNFObtenerRegionesNoBorradas");
			DruidaConector dcTemp = conectar( "ConectorConsultaUA", vecParametros ); 
			dcRetorno = transformar( "XSLComboRegion", dcTemp );

			conectorParametroSesion("ZONcomboRegiones" ,dcRetorno);
			conectorParametroSesion("ZONZonas" ,new Integer(0));

			 //traza( dcRetorno.getXML() );
			traza("END MLNFObtenerRegionesNoBorradas");
		//////////////////////////////////////////////////////////////////////////////////
		}
		else if (  sBizId.equals("ZONObtenerZonas") ){ 
		//////////////////////////////////////////////////////////////////////////////////
		//									ZONObtenerZonas  
			traza("BEGIN ZONObtenerZonas");
			vecParametros.add( new MareBusinessID( "ZONObtenerZonas" ) ); 

			traza("Antes ConectorConsultaUA-ZONObtenerZonas");
			DruidaConector dcTempo = conectar( "ConectorConsultaUA", vecParametros ); 
			
			dcRetorno = transformar( "ZON_xslArmaComboRegiones", dcTempo );

			conectorParametroSesion("ZONZonas" ,dcRetorno);

			traza("END ZONObtenerZonas");
		//////////////////////////////////////////////////////////////////////////////////		
		}
		else if (  sBizId.equals("MLNFObtenerZonasNoBorradas") ){ 
		//////////////////////////////////////////////////////////////////////////////////
		//									ZONObtenerZonas  
			traza("BEGIN ZONObtenerZonas");
			vecParametros.add( new MareBusinessID( "MLNFObtenerZonasNoBorradas" ) ); 

			traza("Antes ConectorConsultaUA-MLNFObtenerZonasNoBorradas");
			DruidaConector dcTempo = conectar( "ConectorConsultaUA", vecParametros ); 
			
			dcRetorno = transformar( "XSLComboCodZonas", dcTempo );

			conectorParametroSesion("ZONZonas" ,dcRetorno);

			traza("END MLNFObtenerZonasNoBorradas");
		//////////////////////////////////////////////////////////////////////////////////		
		}

		traza("END f_conector_consulta_ua");
		return dcRetorno;
	}
 
//////////////////////////////////////////////////////////////////////////////////

	private DruidaConector f_asignar_estado_zona(  String pParams ) throws Exception {
		//CONECTOR_ASIGNAR_ESTADOZONA
		//
		//Parametros en sParams :
		//	primero -> valor id_zona
		//	segundo -> valor estadoZona									

		traza("BEGIN f_asignar_estado_zona");
		DTOEstadoZona dtoEZ = new DTOEstadoZona();

		dtoEZ.setIpCliente( UtilidadesBelcorp.getIPCliente( this ) );
		dtoEZ.setPrograma( UtilidadesSession.getFuncion( this ) );
		dtoEZ.setOidIdioma( UtilidadesSession.getIdioma( this ) );
		dtoEZ.setOidPais( UtilidadesSession.getPais( this )  );

		StringTokenizer stk = new StringTokenizer( pParams , "?" );
		traza("stk.countTokens() " + stk.countTokens() );

		dtoEZ.setOidZona( new Long( stk.nextToken() )  );
		dtoEZ.setEstadoZona( new Long( stk.nextToken() )  );

 
		Vector vecParametros = new Vector(2);
		//Añado el DTO de entrada al vector de parametros 
		vecParametros.add( dtoEZ ); 
		vecParametros.add( new MareBusinessID( "ZONAsignarEstadoZona" )  ); 

		DruidaConector dc = conectar( "ConectorAsignarEstadoZona", vecParametros ); 

		traza( dc.getXML() );

		  	
		traza("END f_asignar_estado_zona");
		return dc;
	}
//////////////////////////////////////////////////////////////////////////////////
	private DruidaConector f_obtener_ubigeo(  String pParams  ) throws Exception {
		//CONECTOR_OBTENER_UNIGEO
		//
		//Parametros en sParams :
		//	primero -> valor Unidad Geografica
		//	segundo -> valor Pais								

		traza("BEGIN f_obtener_ubigeo");
		DTOUG dtoUG = new DTOUG(); 

		dtoUG.setIpCliente( UtilidadesBelcorp.getIPCliente( this ) );
		dtoUG.setPrograma( UtilidadesSession.getFuncion( this ) );
		dtoUG.setOidIdioma( UtilidadesSession.getIdioma( this ) );

		StringTokenizer stk = new StringTokenizer( pParams , "?" );
		traza("stk.countTokens() " + stk.countTokens() ); 	  

    String token1 = stk.nextToken();

    if( token1 == null || token1.trim().equalsIgnoreCase( "" ) ){
      dtoUG.setOidUG( null ); 
    }
    else{
      dtoUG.setOidUG( new Long( token1 ) ); 
    }

		//dtoUG.setOidUG( new Long( stk.nextToken() )  ); 
		dtoUG.setOidPais( new Long( stk.nextToken() )  );
    
		dtoUG.setFiltroActiva( new Boolean( true )  );

		Vector vecParametros = new Vector(2);
		//Añado el DTO de entrada al vector de parametros 
		vecParametros.add( dtoUG ); 
		vecParametros.add( new MareBusinessID( "ZONConsultarUnidadesGeograficas" )  ); 

		DruidaConector dc = conectar( "ConectorConsultaUnidadesGeograficas" , vecParametros ); 

		//traza( dc.getXML() );

		
		traza("END f_obtener_ubigeo");
		return dc;
	}
//////////////////////////////////////////////////////////////////////////////////
	private DruidaConector f_obtener_ubigeo_estado(  String pParams  ) throws Exception 
	{
		//CONECTOR_OBTENER_UNIGEO_ESTADO
		//
		//Parametros en sParams :
		//	primero y unico -> valor Unidad Geografica						

		traza("BEGIN f_obtener_ubigeo_estado");
		DTOUG dtoUG = new DTOUG(); 

      if(!(pParams.equals("xxx")))
         dtoUG.setOidUG(new Long(pParams));       
	     dtoUG.setOidPais(UtilidadesSession.getPais(this));
         dtoUG.setFiltroActiva( new Boolean( false )  );
      
		 Vector vecParametros = new Vector(2);
		 //Añado el DTO de entrada al vector de parametros 
		 vecParametros.add( dtoUG ); 
		 vecParametros.add( new MareBusinessID("ZONModificaEstadoUniGeo") ); 

		 DruidaConector dc = conectar("ConectorConsultaUnidadesGeograficasEstado" , vecParametros ); 

		 //traza( dc.getXML() );		
		 traza("END f_obtener_ubigeo_estado");
		 return dc;
	}
/////////////////// METODO PARA OBTENER TERRITORIOS ult. nivel devuelve -1 //////////////////////////////
	private DruidaConector f_obtener_ug_territorios(  String pParams  ) throws Exception {
		//CONECTOR_OBTENER_UNIGEO_ESTADO
		//
		//Parametros en sParams :
		//	primero y unico -> valor Unidad Geografica						

		traza("BEGIN f_obtener_ug_territorios");
		DTOUG dtoUG = new DTOUG(); 

        if(!(pParams.equals("xxx")))
          dtoUG.setOidUG(new Long(pParams));       
	      dtoUG.setOidPais(UtilidadesSession.getPais(this));
          dtoUG.setFiltroActiva( new Boolean( false )  );
      
		  Vector vecParametros = new Vector(2);
		  //Añado el DTO de entrada al vector de parametros 
		  vecParametros.add( dtoUG ); 
				
		  // MONUnidadesGeograficas.obtenerUGTerritorios(DTOUG dto)
		  vecParametros.add( new MareBusinessID("ZONConsultaUGTerritorios") ); 

		  DruidaConector dc = conectar( "ConectorConsultaUGTerritorios" , vecParametros ); 

		  //traza( dc.getXML() );		
		  traza("END f_obtener_ug_territorios");
		  return dc;
	    }

}

