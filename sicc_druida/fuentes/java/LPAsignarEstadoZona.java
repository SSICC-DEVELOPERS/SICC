import java.util.*;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOColeccion;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream ;
import java.util.Stack;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.zon.DTOBuscaZonaEstIni;
import es.indra.sicc.dtos.zon.DTOEstadoZona;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

//Librerias Mare
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;

//Librerias DTO modulo
import es.indra.sicc.dtos.zon.DTOPantallaAsignarEstado;

//Librerias utilidades XML
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;
import java.lang.StringBuffer;
import java.lang.Boolean;
import java.lang.Throwable;
import java.lang.Exception;


public class LPAsignarEstadoZona extends LPSICCBase  {

	public void inicio() throws Exception{
		pagina("contenido_estado_zona_manual_asociar");
	}

	public void ejecucion() throws Exception{
		try{
			setTrazaFichero();
  	  
			traza( "BEGIN EJECUCION	*******************************************************");		

			String sAccion = conectorParametroLimpia( "accion", "", true);	
			traza( "sAccion " + sAccion);		

			if ( sAccion.equals("") ){

				// Rastreo
				this.rastreo();

  				getConfiguracionMenu("LPAsignarEstadoZona","asignar"); 

				conectorParametroSesion("ZONcomboRegiones" ,new Integer(0));
				conectorParametroSesion("ZONZonas" ,new Integer(0));
				asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
				asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
				if (UtilidadesSession.getMarcaPorDefecto(this) != null)  {
				  obtenerComboEstados();
				  asignarAtributo( "VAR", "hDefMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
				}

				f_accion_nula();
        
			}
			else if ( sAccion.equals("BUSCAR") ){
				traza( "I" );
				f_accion_nula();
				traza( "II" );
				f_accion_buscar();
				traza( "III" );
			}
			else if ( sAccion.equals("ASIGNAR") ){
				guardar();
				/*traza( "I" );
				f_asignar_estado_zona();
				traza( "II" );
				f_accion_nula();
				traza( "III" );
				f_accion_buscar();*/
			}

			traza( "END EJECUCION   *******************************************************");

		}
		catch(Exception th){

			ByteArrayOutputStream stack = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(stack);
			th.printStackTrace(out);

			traza(  stack.toString());
			this.lanzarPaginaError(th);
           /*here ?
		     primera modificiacion by Patricio Picard Peralta 23/01/2004

			BelcorpError belcorpError = new BelcorpError();
			DTOError dtoError = belcorpError.obtenerError(	th, 
																			"ES",//UtilidadesSession.getIdioma_ISO( this ) , 
																			""	
																		);

			String s = th.getMessage();
			traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
			asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
			asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()) ;			

			traza( "END EJECUCION CON ERRORES  ********************************************");	
			*/
		}
	}

	private void f_accion_nula() throws Exception {
		traza("BEGIN f_accion_nula()");
		/*
		accion = "" 
		{ 
		//Debe obtener las marcas y canales. 
		idBusiness = "SEGcargaPMC" 
		Activor el conector "ConectorCargaPMC" 
		Se crea un DTOFiltroPMC con las propiedades bpais=false,bmarca=true y bcanal=true 
		Se ejecuta el conector. 
		Se obtiene un DTOPMC. Con los valores en marcas se llena el combo marca y con los datos en canales se llena el combo canal. 
		//El combo de estados de zona se llena cuando se activa la accion buscar, mientras tanto permanece vacio. 
		Se muestra la pantalla "PantallaAsignarEstado" 
		} 
		*/
 
		DTOFiltroPMC dtoFPMC = new DTOFiltroPMC();

		dtoFPMC.setIpCliente( UtilidadesBelcorp.getIPCliente( this) );
		dtoFPMC.setPrograma( UtilidadesSession.getFuncion( this ) );
		dtoFPMC.setOidIdioma( UtilidadesSession.getIdioma( this) );

		dtoFPMC.setCanales( new Boolean(true) );
		dtoFPMC.setMarcas( new Boolean(true) );
		dtoFPMC.setPaises( new Boolean(true) );


		MareBusinessID bizId = new MareBusinessID("SEGcargaPMC");
		Vector params = new Vector();
		params.addElement( dtoFPMC );
		params.addElement( bizId );
		traza("1");
		DruidaConector dc  =	conectar( "ConectorCargaPMC" , params );
		traza("2");		
		traza( "dc " + dc.getXML().toString() );

		asignar("COMBO", "comboCanal", dc , "dtoSalida.canales_ROWSET");
		asignar("COMBO", "comboMarca", dc , "dtoSalida.marcas_ROWSET");
		//asignar("COMBO", "comboRegion", dc , "dtoSalida.paises_ROWSET");
    asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
    asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());

    Long marcaDef = UtilidadesSession.getMarcaPorDefecto(this);
    if (marcaDef != null) {
        MareBusinessID bizIdReg = new MareBusinessID("MLNFObtenerRegionesNoBorradas");

        DTOUnidadAdministrativa dtoU = new DTOUnidadAdministrativa();
        dtoU.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoU.setOidPais(UtilidadesSession.getPais(this));
        dtoU.setOidMarca(marcaDef);

        Vector paramsReg = new Vector();
        paramsReg.addElement( dtoU );
        paramsReg.addElement( bizIdReg );

        DruidaConector dcReg =	conectar( "ConectorConsultaUA" , paramsReg ); 
    		traza( "dcReg " + dcReg.getXML().toString() );
				DruidaConector conectorCombo = transformar("XSLComboRegion",dcReg);
         
    		asignar("COMBO", "comboRegion", conectorCombo , "dtoSalida.resultado_ROWSET");
        
    }
    
		traza("END f_accion_nula()");
	}

	private void f_accion_buscar() throws Exception {
		traza("BEGIN f_accion_buscar()");
/*
accion = "buscar" 
{ 
//Busca las zonas que corresponden al filtro indicado y los estados de zona asociados a la marca seleccionada y el país en sesion. 
//Debe obtener las marcas y canales. 
idBusiness = "ZONBuscarZonaEstINI" 
Activa el conector "ConectorBuscarZonasEstIni" 
Se crea un DTOBuscaZonaEstIni. 
El oid de marca se recibe de la pantalla y el oid de pais se toma de la sesion. 
Los oid correspondientes a canal, region y zona son opcionales y pueden recibirse o no. 
Si se reciben se asignan a las propiedades que corresponden, de lo contrario se le asigna NULL. 
Se ejecuta el conector. 
Se obtiene un DTOPantallaAsignarEstado. Con los valores en Zonas se llena la lista y con los valores de EstadosZona se llena el combo de estados de zona. 
Se muestra la pantalla "PantallaAsignarEstado" 
} 
*/

		String sMarca = conectorParametroLimpia( "comboMarca", "", true );	
		String sCanal = conectorParametroLimpia( "comboCanal", "", true );	
		String sRegion = conectorParametroLimpia( "comboRegion", "", true );	
		String sCodZona = conectorParametroLimpia( "comboCodZona", "", true );	

		traza("sMarca" + sMarca );
		traza("sCanal" + sCanal );
		traza("sRegion" + sRegion );
		traza("sCodZona" + sCodZona );

 		DTOBuscaZonaEstIni dtoBZEI = new DTOBuscaZonaEstIni();
 
		dtoBZEI.setOidIdioma( UtilidadesSession.getIdioma( this) );
 		dtoBZEI.setIpCliente( UtilidadesBelcorp.getIPCliente( this) );
 		dtoBZEI.setPrograma( UtilidadesSession.getFuncion( this ) );
 		dtoBZEI.setOidPais( UtilidadesSession.getPais( this ) );
    dtoBZEI.setIndicadorSituacion(new Long(1));
 
		traza("1");
		if ( ! sMarca.equals("") ){
			dtoBZEI.setOidMarca( new Long( sMarca ) );
			/*
			<VAR nombre="marcaSelected" valor=""/>
			<VAR nombre="canalSelected" valor=""/>
			<VAR nombre="regionSelected" valor=""/>
			<VAR nombre="codZonaSelected" valor=""/>
			*/
			asignarAtributo("VAR","marcaSelected","valor", sMarca);

		}

		traza("2");
		if ( ! sCanal.equals("") ){
			dtoBZEI.setOidCanal( new Long( sCanal ) );
			asignarAtributo("VAR","canalSelected","valor", sCanal);
		}

		traza("3");
		if ( ! sRegion.equals("") ){
			dtoBZEI.setOidRegion( new Long( sRegion ) );
			asignarAtributo("VAR","regionSelected","valor", sRegion);
		}

		traza("4");
		if ( ! sCodZona.equals("") ){
			dtoBZEI.setOidZona( new Long( sCodZona ) );
			asignarAtributo("VAR","codZonaSelected","valor", sCodZona);
		}
 
 		traza("5");
		MareBusinessID bizId = new MareBusinessID("ZONBuscarZonaEstINI");
		Vector params = new Vector();
		params.addElement( dtoBZEI );
		params.addElement( bizId );
 
	 
		traza("6");
		DruidaConector dc  =	conectar( "ConectorBuscarZonasEstIni" , params );
		DruidaConector dcTransformado = transformar( "ZON_xslArmaListaZonas", dc );

		traza("7");
		
      DTOPantallaAsignarEstado dtos = (DTOPantallaAsignarEstado) dc.objeto("DTOSalida");
      traza("DTOSalida: "+dtos);

      RecordSet zonas = (RecordSet)dtos.getZonas();
		

		asignar("LISTA", "Lista1", dcTransformado , "DTOPantallaAsignarEstado.Zonas_ROWSET");
		asignar("COMBO", "comboEstado", dc , "DTOPantallaAsignarEstado.EstadosZona_ROWSET");

		
 
		Object objRegiones = conectorParametroSesion("ZONcomboRegiones");
		if ( objRegiones != null  && objRegiones instanceof  DruidaConector && (!sRegion.equals("")) ){
			DruidaConector dcRegiones = (DruidaConector) objRegiones;
			traza("dcZonas " + dcRegiones.getXML() );
			asignar("COMBO", "comboRegion", dcRegiones , "dtoSalida.resultado_ROWSET");
			Object objZonas = conectorParametroSesion("ZONZonas");

			if ( objZonas != null && objZonas instanceof  DruidaConector  && (!sCodZona.equals(""))){
				DruidaConector dcZonas = (DruidaConector) objZonas;
				traza("dcZonas " + dcZonas.getXML() );
				asignar("COMBO", "comboCodZona", dcZonas , "dtoSalida.resultado_ROWSET");
			}
		}

		if(zonas.esVacio()) {			        
           throw new MareException(new MareException(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
		}

		traza("END f_accion_buscar()"); 
 
	}

  private void obtenerComboEstados() throws Exception {
    traza("Inicio obtenerComboEstados");
		//Long sMarca = UtilidadesSession.getMarcaPorDefecto(this);	
 		DTOBuscaZonaEstIni dtoBZEI = new DTOBuscaZonaEstIni();
 
		dtoBZEI.setOidIdioma(UtilidadesSession.getIdioma( this));
 		dtoBZEI.setOidPais(UtilidadesSession.getPais( this ));
 		dtoBZEI.setOidMarca(UtilidadesSession.getMarcaPorDefecto(this));
 
		MareBusinessID bizId = new MareBusinessID("ZONBuscarEstadosZona");
		Vector params = new Vector();
		params.addElement( dtoBZEI );
		params.addElement( bizId );
 
		DruidaConector dc  =	conectar( "ConectorConsultarEstadosZona" , params );
		//DruidaConector dcTransformado = transformar( "ZON_xslArmaListaZonas", dc );
    traza("*** ESTADOS ***"+dc);
		asignar("COMBO", "comboEstados", dc , "dtoSalida.resultado_ROWSET");

    //DTOSalida dtos = (DTOSalida) dc.objeto("DTOSalida");
    //traza("DTO Salida: "+dtos);

    traza("Fin obtenerComboEstados");
    
  }

  private void guardar() throws Exception {
      traza("Inicio guardar()");
      pagina("salidaGenerica");
      String sDatos = conectorParametroLimpia("hDatosGrabar","",true);

      traza("hDatosGrabar: "+sDatos);
      ArrayList al = new ArrayList();    
  		StringTokenizer stk = new StringTokenizer(sDatos,"|");
      while (stk.hasMoreTokens())
      {
    		StringTokenizer stkFila = new StringTokenizer((String) stk.nextToken(),",");
        String zona = (String) stkFila.nextToken();
        //traza("zona: "+zona);
        String estado = null;
        if (stkFila.hasMoreTokens())
          estado = (String) stkFila.nextToken();
        //traza("estado: "+estado);
        DTOEstadoZona dtoEZ = new DTOEstadoZona();
        dtoEZ.setOidZona(new Long(zona));
        dtoEZ.setEstadoZona(estado == null ? null : new Long(estado));
        dtoEZ.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoEZ.setPrograma(UtilidadesSession.getFuncion(this));
        //traza("DTOEstadoZona: "+dtoEZ);

        al.add(dtoEZ);
      }

      traza("El arrayList a enviar: "+al);
      
      DTOColeccion dtoCol = new DTOColeccion();
      dtoCol.setLista(al);
      dtoCol.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoCol.setPrograma(UtilidadesSession.getFuncion(this));
      
      Vector vecParametros = new Vector();
      vecParametros.add( dtoCol ); 
      vecParametros.add( new MareBusinessID( "ZONAsignarEstadoZona" )  ); 
		
      DruidaConector dc = conectar( "ConectorAsignarEstadoZona", vecParametros ); 

      traza("Fin guardar()");

  }


	private DruidaConector f_asignar_estado_zona(  ) throws Exception {
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

		String sIDZona = conectorParametroLimpia("nuevoestadozona","",true);
		String sEstadoZona = conectorParametroLimpia("comboEstado","",true);

		dtoEZ.setOidZona( new Long( sIDZona )  );
		dtoEZ.setEstadoZona( new Long( sEstadoZona)  );

 
		Vector vecParametros = new Vector(2);
		//Añado el DTO de entrada al vector de parametros 
		vecParametros.add( dtoEZ ); 
		vecParametros.add( new MareBusinessID( "ZONAsignarEstadoZona" )  ); 
		
		traza("1");
		DruidaConector dc = conectar( "ConectorAsignarEstadoZona", vecParametros ); 
		traza("2");
		traza("END f_asignar_estado_zona");
		return dc;
	}

	 private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) throws DOMException,Exception	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++)
		{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}
}
 
