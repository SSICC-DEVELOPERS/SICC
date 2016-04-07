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
/**
 * Sistema:           Belcorp
 * Modulo:            ZON
 * Submódulo:         Zonificación
 * Componente:        LP
 * Fecha:             2/12/2003
 * Observaciones:     
 * @version           
 * @autor             
 */

//$Id: LPCargaFichero.java,v 1.1 2009/12/03 18:35:42 pecbazalar Exp $

import es.indra.druida.DruidaBase;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.Calendar;

import java.sql.Date;

import java.util.HashMap;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.util.DTOPais;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.Contexto;
import es.indra.druida.util.MultipartRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;

import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

import es.indra.sicc.util.DTOError;


public class LPCargaFichero 
    extends LPSICCBase    
{     
     private String sNombreLP = "LPCargaFichero";
     private String idioma = null;
     private String pais   = null;
     private String targetName = null;

     public static final String FORMATO_DEFAULT_HORA = "hh:mm:ss"; 


	 // Por cada caso de uso, se debe tener el IdFuncion y ademas se debe
	 // conocer el IdBusiness
	 private String  idBusiness;	
	 private String  codTituloLP;	

     //		BORRARRRRRRRRRRRRRR
	 private String  fichero;	

	 //Caso de Uso 'Asociar Territorio'
	 //MON invocado: 'MantenerUnidadesGeograficas'
	 private static final String LP_ID_ASOC_TERR = "asociarTerritorio";	
	 private static final String ID_BUSINESS_ASOC_TERR = "ZONProcesarFicheroAsociarTerritorio";	

	 //Caso de Uso 'MantenerUnidadesGeograficas.'
	 //MON invocado: 'MONUnidadAdmInterfaceGIS'
	 private static final String LP_ID_UG = "mantenerUnidadesGeograficas";	
	 private static final String ID_BUSINESS_UG = "ZONProcesarFicheroUG";

	 //Caso de Uso 'Crear Unidades Administrativas'	 
	 private static final String LP_ID_CREAR_UA = "crearUnidadesAdministrativas";	
	 private static final String ID_BUSINESS_CREAR_UA = "ZONProcesarFicheroCrearUA";

	 //Caso de Uso 'Eliminar Unidades Administrativas'	 
	 private static final String LP_ID_ELIM_UA = "eliminarUnidadesAdministrativas";	
	 private static final String ID_BUSINESS_ELIM_UA = "ZONProcesarFicheroEliminarUA";

	 //Caso de Uso 'Cargar Estructura Vial'	 
	 private static final String LP_ID_CREAR_EV = "cargarEstructuraVial";	
	 private static final String ID_BUSINESS_CREAR_EV = "ZONProcesarFicheroCargaEV";

	 //Caso de Uso 'Modificar Estructura Vial'	 
	 private static final String LP_ID_MOD_EV = "modificarEstructuraVial";		
	 private static final String ID_BUSINESS_MOD_EV = "ZONProcesarFicheroModificacionEV";

	 //Caso de Uso 'Baja Estructura Vial'	 
	 private static final String LP_ID_ELIM_EV = "bajaEstructuraVial";		
	 private static final String ID_BUSINESS_ELIM_EV = "ZONProcesarFicheroBajaEV";



    public LPCargaFichero() {
    }

    public void inicio() throws Exception 
	{
		setTrazaFichero();
		String accion = conectorParametroLimpia("accion", "", true);      
		if (accion.equals("")) {
			pagina("contenido_seleccion_fichero");
			traza("pagina seleccion");
		} else {
			pagina("contenido_resultado_fichero");
			traza("pagina resultado");
		}
	}

    public void ejecucion() throws Exception
    {
	  String conectorN = null;
	  String accion = conectorParametroLimpia("accion", "", true);      
	  String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);      
     
	  
      idioma = getIdioma();
      pais   = getPais();
	  

		traza("LPCargaFichero metodo Ejecucion ..... ");
		traza("pais: " + pais);
		traza("propiedades del usuario: " + (HashMap) conectorParametroSesion("propiedades"));
		traza("getWebTmpDir: " + getWebTmpDir());

	  try
      {
		 traza("casoDeUso: " + casoDeUso);

		 // Caso de uso que invoca
		 eleccionCasoDeUso(casoDeUso);
		 asignarAtributo("VAR","casoDeUso", "valor" , casoDeUso);

         // Titulo de la página
		 asignarAtributoPagina("cod", codTituloLP);

       
         if ( accion.equals("") ){

			traza("0. ACCION = Vacio ");       
		
            asignarAtributo("VAR","conectorAction", "valor" , sNombreLP);  
			asignarAtributo("VAR","procesarArchivoP0003", "valor" , "S");  

			//traza("mare trans: " + (HashMap)conectorParametroSesion( "propiedades"));
			
         } else if (accion.equals("procesar") ) {

			traza("ACCION = PROCESAR  LPCargaFICHERO");
		
			String tmpDirDruida = getDirTempDruida();           
            String fileName   = conectorParametro("seleccion");		
			traza("fileName: " + fileName);
            String pathDir    = getWebTmpDir();			
			String typeProc   = idBusiness;

			traza("tmpDirDuirda:"+tmpDirDruida);
			traza("pathDir WEB:"+pathDir);
			//traza("typeProc:"+typeProc);
			//traza("businessID:"+businessID);


			//traza("Luego de mover Archivo , nombre de archivo:"+fileName);

			traza("businessID: " + idBusiness);

			DTOFicheroDisp dtoFichero = new DTOFicheroDisp();
			dtoFichero.setNombreFichero(fileName);
            dtoFichero.setPathFichero(pathDir);

            dtoFichero.setTypeProc(typeProc);

            // Validación de la cabecera del fichero
			DTOPais datos = new DTOPais();
			datos.setOidPais(new Long(getPais()));
            
			dtoFichero.setDatos(datos);          
			
			// Auditoria
			dtoFichero.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
            dtoFichero.setPrograma(UtilidadesSession.getFuncion(this));


            MareBusinessID bussID = new MareBusinessID(idBusiness);
            Vector params = new Vector();
            params.add( dtoFichero ); 
            params.add( bussID );

            //Realiza el Conectar
			traza("antes 1");
			DruidaConector con = conectar("ConectorProcesarFichero", params);			
			traza("despues 1");

			//traza("con: " + con.getXML().toString());

			// Formateo la fecha
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd 'at' HH:mm:ss");

			// Resultado del proceso			
			DTOManagerFileResult dtoResult = (DTOManagerFileResult) con.objeto("dtoSalida");	

			traza("dtoResult: " + dtoResult);

			java.util.Date fechaDate = formatter.parse(dtoResult.getFechaLog());
			Long IDProc    = dtoResult.getIDProc();            
			String typeProcRes = dtoResult.getTypeProc();
			Long estatus     = dtoResult.getEstatus();
			
			traza("fechaDate: " + fechaDate);

			String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
			
			traza("formato fecha: " + formatoFechaPais);

			asignarAtributo("VAR","hidIdProcesoX", "valor" , IDProc.toString());  
			asignarAtributo("VAR","hidTipoProcesoX", "valor" , typeProcRes);  
			asignarAtributo("VAR","hidFechaReporteX", "valor" , UtilidadesBelcorp.fechaFormateada(fechaDate ,formatoFechaPais) + " " +
				                                                UtilidadesBelcorp.horaFormateada(fechaDate ,FORMATO_DEFAULT_HORA));  			
			asignarAtributo("VAR","hidMensajeEstatusX", "valor" , estatus.toString());  
				
			// Formato de valores: "fecha;dato;men"
			String valores = dtoResult.getReporteRegistros();

			traza("valores:"+valores);            
			StringTokenizer st = new StringTokenizer(valores,";");
			String fechaDetalle = null;
			java.util.Date fecha = null;
			String dato = null;
			String mensaje  = null;
			
			RecordSet rDatos = new RecordSet();			
			rDatos.addColumn("oid");
			rDatos.addColumn("Fecha");
			rDatos.addColumn("Mensaje");
			rDatos.addColumn("Dato");

            int i = 0;
           							
			while(st.hasMoreTokens()){				
				
				fecha  = formatter.parse(st.nextToken());
				traza("fe: " + fecha);           

				fechaDetalle   = UtilidadesBelcorp.fechaFormateada(fecha ,formatoFechaPais) + " " +
				                 UtilidadesBelcorp.horaFormateada(fecha ,FORMATO_DEFAULT_HORA);  
				traza("det: " + fechaDetalle);
				// 23002 - dmorello, 16/06/2006: Se reconvierten en ";" los "\n" que vienen de parte server
				dato    = st.nextToken().replaceAll("\n",";");
				mensaje = st.nextToken();
				rDatos.addRow(new Object[] {new Integer(i++),fechaDetalle, mensaje, dato});     
			}

			DruidaConector cDatos = UtilidadesBelcorp.generarConector("RowsetID",rDatos,rDatos.getColumnIdentifiers());

			traza("cDatos: " + cDatos.getXML().toString());

			asignar("LISTA","listado1", cDatos , "RowsetID");

         } 
         
      }
      catch (Exception ex)
      {	  
		  traza(ex);

           logStackTrace(ex); 
           /*
		   DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(ex, this);
		   traza("Error:" + dtoError.getCodigoError());
		   traza("Error:" + dtoError.getDescripcionError());
           */
		   this.lanzarPaginaError(ex);

      }      

	  getConfiguracionMenu();
    }

	

	public void logStackTrace(Throwable e) throws Exception {
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


	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}
  
	

    /*
     * Retorna un nuevo recordset a partir de un argumento de String.
     */
    private RecordSet getRecordSet(String arg[]){
        RecordSet datos = new RecordSet();
        datos.addColumn("CODIGO");
		datos.addColumn("VALOR");        

        for(int j=0;j<arg.length;j++) {        
            datos.addRow(new Object[] { arg[j],  arg[j] });            
        }
        return datos;
    }


    /**
    * Retorna el codigo de pais.
    */
    private String getPais()
        throws Exception,MareException
	{
		Long pais = UtilidadesSession.getPais(this);
		return pais.toString();
	}

    /* Retorna el codigo de idioma asociado al usuario.
     * TODO !!
	 */
    private String getIdioma()
        throws MareException
    {
		Long idioma = UtilidadesSession.getIdioma(this);
		return idioma.toString();
    }

    /*
     * Retorna un String indicando el directorio donde Druida
     * almacena el archivo transferido desde la LP.
     * */
    private String getDirTempDruida()
			throws Exception
    {				
			String dir = null;
			dir = Contexto.getPropiedad("TMP.UPLOAD");		
			return dir;
    }

    /*
     * Retorna un String indicando el directorio temporario del 
     * web server. En dicho directorio se deben dejar los archivos
     * que se traen desde la pagina cliente. 
     **/
    private String getWebTmpDir()
			throws Exception
	{
			return Contexto.getPropiedad("TMP.UPLOAD2");
    }    

	/**
	* Este metodo retorna el 'IdBuisness', dependiendo del
	* Id de funcion pasado como parametro.
	*/
	private void eleccionCasoDeUso(String casoDeUso) throws MareException{		
	  // Seteo de titulo y ID_BUSINESS
	  if(casoDeUso.equals(LP_ID_ASOC_TERR)){
			idBusiness = ID_BUSINESS_ASOC_TERR;
			codTituloLP = "0378";
			fichero= "muestraUG.txt";
	  }else if(casoDeUso.equals(LP_ID_UG)){
			idBusiness = ID_BUSINESS_UG;
			codTituloLP = "0377";
			fichero = "muestraMUG.txt";
	  }else if(casoDeUso.equals(LP_ID_CREAR_UA)){
			idBusiness = ID_BUSINESS_CREAR_UA;
			codTituloLP = "0637";
			fichero = "muestraCUAG.txt";
	  }else if(casoDeUso.equals(LP_ID_ELIM_UA)){
			idBusiness = ID_BUSINESS_ELIM_UA;
			codTituloLP = "0380";
			fichero = "EliminaUnidadAdministrativa.txt";
	  }else if(casoDeUso.equals(LP_ID_CREAR_EV)){
			idBusiness = ID_BUSINESS_CREAR_EV;
			codTituloLP = "0381";
			fichero = "altaZON.txt";
	  }else if(casoDeUso.equals(LP_ID_MOD_EV)){
			idBusiness = ID_BUSINESS_MOD_EV;
			codTituloLP = "0382";
			fichero = "modifZON.txt";
	  }else if(casoDeUso.equals(LP_ID_ELIM_EV)){
			idBusiness = ID_BUSINESS_ELIM_EV;
			codTituloLP = "0383";
			fichero = "bajaZON.txt";			
	  }    
	}
}