import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaConectorException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOGenerico;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** 
 * <p>Title: SICC</p>
 * <p>Description: Este es el conector transaccional que utilizan el subsistema
 *  de paginacion</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class PaginadoDruidaTransaction extends DruidaTransactionComun {

	public static final String PROPIEDAD_SITUACION = "indicadorSituacion";	
	public static final String PROPIEDAD_PAGESIZE = "tamanioPagina";	

	/**
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception {                    
	  try {
			//setTrazaFichero();
		  traza("entrando en PaginadoDruidaTransaction");
		  Vector vParametros = new Vector();
    
		  //Obtengo los parámetros de entrada
		  String oid = (String) getEntrada("oidE");
		  String idBusiness = (String) getEntrada("idBusiness");
		  String nombreConector = (String) getEntrada("conector");
		  String nombreDTO  = (String) getEntrada("dto");
		  String parametros = (String) getEntrada("parametros");
  		  String posicion = (String)getEntrada("posicion");
		  String pageSizeString = (String)getEntrada("pageSize"); 

		  traza("oid: "+ oid);
		  traza("idBusiness: "+ idBusiness);
		  traza("nombreConector: "+ nombreConector);
		  traza("nombreDTO: "+ nombreDTO);
		  traza("parametros: "+ parametros);
		  traza("posicion: "+ posicion);
		  traza("pageSizeString: "+ pageSizeString);

          parametros = agregarParametrosBasicos(parametros);
        
		  int pageSize = 0;
   		  try { 
			pageSize = Integer.parseInt(pageSizeString);
   		  } catch (NumberFormatException e) {/*Si no es un número no pasa nada*/}
   		  if (pageSize == 0) {
   		  	pageSize = getPageSize();  
   		  }
   		    
		  parametros = agregarParametrosPaginacion(parametros, oid, String.valueOf(pageSize));          

		  //Almaceno el dto en el vector de parametros
		  //parametros = "pais=españa&idioma=cristiano&indicadorSituacion=0&tamanioPagina=10";
		  DTOGenerico dtoGenerico = new DTOGenerico(nombreDTO, parametros);        	
		  vParametros.add(dtoGenerico.toDTO());
 
		  //Añado el idNegocio al vector de parametros
		  vParametros.add(new MareBusinessID(idBusiness));    
		  long tiempoInicio=0;
    	  long tiempoFin=0;
		  
		  tiempoInicio = System.currentTimeMillis();
		  DruidaConector conector = conectar(nombreConector, vParametros);
		  tiempoFin = System.currentTimeMillis();
		  System.out.println("El tiempo de ejecucion de la transacion "+idBusiness+" fue de "+(tiempoFin-tiempoInicio) + ".\n");

			//traza("DTEliminacion.borrado: "+DTEliminacion.borrado);
			//if (!DTEliminacion.borrado) {
				  //Antes de asignar el resultado del conector lo manipulo para que funcione la paginación 
				  AdaptadorConectorPaginacion adaptador = new AdaptadorConectorPaginacion(conector, 
														pageSize, Short.parseShort(posicion));
	          conector = adaptador.obtenerConectorPaginacion();
				 traza("conectorPaginado Resultado: "+conector.getXML());
				  adaptador = null; 
			//}
			//DTEliminacion.borrado = false;
           
                 
		  //Definimos el resultado del conector transaccional
		  setConector(conector);
	  }catch (Exception e) {
		/*try{
			UtilidadesBelcorp.lanzarPaginaErrorDT(e, this);
		}catch (Exception ex){*/
			logStackTrace(e);
			throw new DruidaConectorException( obtenerMensajeError(e));
		//throw new DruidaConectorException( pila.toString());
		//}
	  }
	}


	private void logStackTrace(Throwable e) {
     ByteArrayOutputStream os = new ByteArrayOutputStream();
	 PrintStream ps = new PrintStream(os);

	 e.printStackTrace(ps);
     try {
		System.out.println("Se produjo la excepcion: " 
			+ e.getMessage() 
			+ "\n" 
			+ "stackTrace = " 
		    + os.toString());
     }
     catch (Exception ex) {
        //traza ("Error en logStackTrace: " + ex.getMessage ());
		e.printStackTrace ();
     }
	}

	/**
	 * Añade a la cadena de parametros la posicion y el tamaño de página.
	 * @param parametros
	 * @param posicion
	 * @param size
	 * @return String
	 */
	private String agregarParametrosPaginacion(String parametros, String posicion, String size) {
		StringBuffer sb = new StringBuffer(parametros);
		sb.append(SEPARADOR_PARAMETROS).append(PROPIEDAD_SITUACION).append("=")
			.append(posicion).append(SEPARADOR_PARAMETROS).append(PROPIEDAD_PAGESIZE)
			.append("=").append(size);
		return sb.toString();
	}   
}