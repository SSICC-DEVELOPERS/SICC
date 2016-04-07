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
 * Modulo:            MAV
 */

//$Id: LPCargaListaClientes.java,v 1.2 2010/12/20 22:18:06 peextsapaza Exp $

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


public class LPCargaListaClientes extends LPSICCBase {     
    private String sNombreLP = "LPCargaListaClientes";
    private String idioma = null;
    private String pais   = null;
    private String targetName = null;

    public static final String FORMATO_DEFAULT_HORA = "hh:mm:ss"; 

    private String  fichero;	

    public LPCargaListaClientes() {
    }

    public void inicio() throws Exception {
        setTrazaFichero();
        String accion = conectorParametro("accion");
        if (accion ==null || accion.equals("")) {
            //pagina("contenido_seleccion_fichero");
            pagina("contenido_seleccion_fichero_BP");            
        } else {
            pagina("contenido_resultado_fichero_BP");
        }
    }

    public void ejecucion() throws Exception{
        String conectorN = null;
        String accion = conectorParametroLimpia("accion", "", true);           
        idioma = getIdioma();
        pais   = getPais();	  
    	  try{
            //rastreo();

            if ( accion.equals("") ){
            	mostrarListado(); 
            } else if (accion.equals("seleccionar") ) {
                pagina("contenido_seleccion_fichero_BP");                
                seleccionar();               
            } else if (accion.equals("procesar") ) {
                pagina("contenido_seleccion_fichero_BP");                
                procesar();               
            } else if (accion.equals("cancelar") ) {
                pagina("contenido_bp_lista_clientes");                
                mostrarListado();             
            } else if (accion.equals("aceptar") ) {
                pagina("contenido_bp_lista_clientes");                
                aceptar();             
            } 
            
        }catch (Exception ex){	  
            logStackTrace(ex);
            
            if(accion.equals(""))
            	pagina("contenido_seleccion_fichero_BP");
            else
            	pagina("contenido_bp_lista_clientes");

            this.lanzarPaginaError(ex);
        }      
    	  //getConfiguracionMenu();
    }

    private void mostrarListado() throws Exception{
    	pagina("contenido_bp_lista_clientes");
    	Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "hidOidPais", "valor", pais.toString() );
		asignarAtributo("VAR", "hidOidIdioma", "valor", idioma.toString() );

    	String varListaCliente = this.conectorParametroLimpia("varListaCliente", "", true);
        asignarAtributo("VAR", "varListaCliente", "valor", varListaCliente);
        
        String estadoProceso = this.conectorParametroLimpia("estadoProceso","",true);
    	asignarAtributo("VAR", "varEstadoProceso", "valor", estadoProceso );        
    }

    private void seleccionar() throws Exception{
        asignarAtributo("VAR","conectorAction", "valor" ,"LPCargaListaClientes");
        asignarAtributo("VAR","accion", "valor" , "");
        asignarAtributoPagina("cod", "01");
        
        String varListaCliente = this.conectorParametroLimpia("varListaCliente", "", true);
        asignarAtributo("VAR", "varListaCliente", "valor", varListaCliente);

    }
    
    private void procesar() throws Exception {
        Long paisActivo = UtilidadesSession.getPais(this); 
        traza("paisActivo: " + paisActivo);
        String tmpDirDruida = getDirTempDruida();           
        String fileName   = conectorParametro("seleccion");		
        traza("fileName: " + fileName);
        String pathDir    = getWebTmpDir();			
        traza("tmpDirDuirda:"+tmpDirDruida);
        traza("pathDir WEB:"+pathDir);


        DTOFicheroDisp dtoFichero = new DTOFicheroDisp();
        dtoFichero.setOidPais(paisActivo);
        dtoFichero.setNombreFichero(fileName);
        dtoFichero.setPathFichero(pathDir);

        // Validación de la cabecera del fichero
        DTOPais datos = new DTOPais();
        datos.setOidPais(paisActivo);    
        dtoFichero.setDatos(datos);          
			
        MareBusinessID bussID = new MareBusinessID("MAVCargaListaClientes");
        Vector params = new Vector();
        dtoFichero.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoFichero.setPrograma("LPCargaListaClientes");
        params.add( dtoFichero ); 
        params.add( bussID );

        DruidaConector con = conectar("ConectorProcesarFichero", params);			
        DTOManagerFileResult dtoResult = (DTOManagerFileResult) con.objeto("dtoSalida");
  	    Map errores = obtenerErrores();
  	   
        RecordSet rLista = new RecordSet();
        Vector vCols = new Vector();
        vCols.add("posicion");
        vCols.add("fila");
 	    vCols.add("codigoCliente");
		vCols.add("mensajeError");
		rLista.setColumnIdentifiers(vCols);
		
		ArrayList lista = dtoResult.getListaRespuesta();
		for(int i=0; i<lista.size(); i++) {
			Vector vFila = new Vector();
			Map mapAux= (Map)lista.get(i);
			
			vFila.add(String.valueOf(i));
            vFila.add(mapAux.get("numeroFila"));
            vFila.add(mapAux.get("codigoCliente"));
            vFila.add((String)errores.get(mapAux.get("mensajeError")));
            
            rLista.addRow(vFila);
		}
        
        traza("RecordSet generado: " + rLista);
 	    DruidaConector conFilas = UtilidadesBelcorp.generarConector("listaFilas", 
													rLista, rLista.getColumnIdentifiers());
 	    
 	   this.asignar("LISTADOA", "listado1", conFilas, "listaFilas"); 
        //---------------------------------
        
        traza("dtoResult: " + dtoResult);

        ArrayList listaArchivo = dtoResult.getListaRespuesta();		
        String numeroRegistros = dtoResult.getReporteRegistros();
        String numRegistrosError = String.valueOf(listaArchivo.size());
        String numRegistrosValido = String.valueOf(Integer.parseInt(numeroRegistros) - Integer.parseInt(numRegistrosError));
        
        if(Integer.parseInt(numRegistrosError)< Integer.parseInt(numeroRegistros))
        	asignarAtributo("VAR", "hidValido", "valor", "1");
		else
			asignarAtributo("VAR", "hidValido", "valor", "0");
        
        this.asignarAtributo("CAPA", "capa1", "visibilidad", "visible");
        this.asignarAtributo("LABELC","lbldtNumRegistros","valor", numeroRegistros);                                        
        this.asignarAtributo("LABELC","lbldtNumRegistrosError","valor", numRegistrosError);                                                  
        this.asignarAtributo("LABELC","lbldtNumRegistrosValido","valor", numRegistrosValido);
        
        this.asignarAtributo("LABELC","lbldtNumRegistrosValido","valor", numRegistrosValido);

        String varListaCliente = this.conectorParametroLimpia("varListaCliente", "", true);
        asignarAtributo("VAR", "varListaCliente", "valor", varListaCliente);
    }

	
    private void aceptar() throws Exception {
    	Long pais = UtilidadesSession.getPais(this);
		Long idioma = UtilidadesSession.getIdioma(this);

        DTOString dto = new DTOString();
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        
        MareBusinessID bussID = new MareBusinessID("MAVProcesarListaClientes");
        Vector params = new Vector();
        params.add( dto ); 
        params.add( bussID );

        DruidaConector con = conectar("ConectorProcesarFichero", params);			
        DTOString dtoResult = (DTOString) con.objeto("dtoSalida");
        
        String varListaCliente = dtoResult.getCadena();
        asignarAtributo("VAR", "varListaCliente", "valor", varListaCliente);
    }

    

    public void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException){
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
	
	/* 
	*  Retorna el Id de funcion.
    **/
	private String getIdFuncion() throws MareException, Exception {		
		String idFuncion = (String)conectorParametro("hidIdFuncion");
		return idFuncion;		
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
    private String getPais() throws Exception,MareException{
        Long pais = new Long(1);//UtilidadesSession.getPais(this);
        return pais.toString();
    }

    private String getIdioma() throws MareException{
        Long idioma = new Long(1);//UtilidadesSession.getIdioma(this);
        return idioma.toString();
    }

    /*
     * Retorna un String indicando el directorio donde Druida
     * almacena el archivo transferido desde la LP.
     * */
    private String getDirTempDruida() throws Exception{				
        String dir = null;
        dir = Contexto.getPropiedad("TMP.UPLOAD");		
        return dir;
    }

    /*
     * Retorna un String indicando el directorio temporario del 
     * web server. En dicho directorio se deben dejar los archivos
     * que se traen desde la pagina cliente. 
     **/
    private String getWebTmpDir()	throws Exception{
        return Contexto.getPropiedad("TMP.UPLOAD2");
    }
    
    private Map obtenerErrores() {
    	String msgCodigoPaisVacio = conectorParametro("msgCodigoPaisVacio");
    	String msgCodigoClienteVacio = conectorParametro("msgCodigoClienteVacio");
    	String msgUnidadesVacio = conectorParametro("msgUnidadesVacio");
    	String msgNoRegistroFila = conectorParametro("msgNoRegistroFila");
    	String msgPaisNoActivo = conectorParametro("msgPaisNoActivo");
    	String msgNoExisteConsultora = conectorParametro("msgNoExisteConsultora");
    	String msgNoFormatoNumeroUnidades = conectorParametro("msgNoFormatoNumeroUnidades");
    	String msgDuplicados = conectorParametro("msgDuplicados");
    	
    	Map errores = new HashMap();
    	errores.put("error.codigoPaisVacio", msgCodigoPaisVacio);
    	errores.put("error.codigoClienteVacio", msgCodigoClienteVacio);
    	errores.put("error.numeroUnidadesVacio", msgUnidadesVacio);
    	errores.put("error.noRegistroFila", msgNoRegistroFila);
    	errores.put("error.PaisNoActivo", msgPaisNoActivo);
    	errores.put("error.noExisteConsultora", msgNoExisteConsultora);
    	errores.put("error.noFormatoNumeroUnidades", msgNoFormatoNumeroUnidades);
    	errores.put("error.existenDuplicados", msgDuplicados);

    	return errores;
    }
    
}
