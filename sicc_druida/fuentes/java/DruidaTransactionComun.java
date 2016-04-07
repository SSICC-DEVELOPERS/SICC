import es.indra.druida.DruidaTransaction;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOError;

import es.indra.druida.DruidaConectorException;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
//import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.druida.DruidaConector;
import es.indra.druida.Contexto;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



/**
 * <p>Title: SICC</p>
 * <p>Description: Esta es la clase comun de la que heredan los subsistemas
 *   que utilizan druida transaction.</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public abstract class DruidaTransactionComun extends DruidaTransaction {

         public static final String SEPARADOR_PARAMETROS = "&";
         public static final String NOMBRE_DTO_PAIS = "oidPais";
         public static final String NOMBRE_DTO_IDIOMA = "oidIdioma";
		 public static final String NOMBRE_DTO_USUARIO = "usuario";
		 public static final String NOMBRE_DTO_PASSWORD = "password";

         /** Añade a la cadena de parametros el idioma y el pais del usuario obtenidos de
          *   la sesión, respetando el formato de la cadena de parametros (URL).
          * @param parametros
          * @return
          */
         protected String agregarParametrosBasicos(String parametros)  throws Exception{
				StringBuffer sb = new StringBuffer();
				  if(parametros!=null){
					sb.append(parametros);
				  }
         
                  String pais = null; 
                  String idioma = null;
				  String usuario = null;
				  String password = null;
                  
						setTrazaFichero();

                  try{
							pais = UtilidadesSession.getPais(this).toString();
							idioma = UtilidadesSession.getIdioma(this).toString();
							usuario = UtilidadesSession.getDruidaUsuario(this);
							password = UtilidadesSession.getDruidaPassword(this);
                  }catch(MareException me) {traza("no se pudieron recuperar de sesion el pais/idioma/usuario/password");}
                  
                  //Añadimos a la cadena de parametros el pais
                  if (pais != null) {
                           sb.append(SEPARADOR_PARAMETROS).append(NOMBRE_DTO_PAIS).append("=").append(pais);
                  } else {
                           System.err.println("no hay pais");
//                         throw (new DruidaConectorException("" +UtilidadesError.armarCodigoError(CodigosError.ERROR_OBTENER_PAIS_USUARIO)));	
//                         throw new MareException(new MareException(), UtilidadesError.armarCodigoError(CodigosError.ERROR_OBTENER_PAIS_USUARIO));
                  }
                  
                  //Añadimos a la cadena de parametros el idioma		              
                  if (idioma != null) {
                           sb.append(SEPARADOR_PARAMETROS).append(NOMBRE_DTO_IDIOMA).append("=").append(idioma);
                  } else {
                           System.err.println("no hay idioma");
//                         throw (new DruidaConectorException("" +UtilidadesError.armarCodigoError(CodigosError.ERROR_OBTENER_IDIOMA_USUARIO)));	
//                         throw new MareException(new MareException(), UtilidadesError.armarCodigoError(CodigosError.ERROR_OBTENER_IDIOMA_USUARIO));      
                  }
				  if(usuario!=null){
						sb.append(SEPARADOR_PARAMETROS).append(NOMBRE_DTO_USUARIO).append("=").append(usuario);
				  }else{
						System.err.println("no hay usuario");
				  }
				  if(password!=null){
						sb.append(SEPARADOR_PARAMETROS).append(NOMBRE_DTO_PASSWORD).append("=").append(password);
				  }else{
						System.err.println("no hay password");
				  }

				if(sb.toString().startsWith(SEPARADOR_PARAMETROS)){
					String valor = sb.toString();
					sb = new StringBuffer(valor.substring(1));
				}
                  return sb.toString();
         }	
         /** Genera un conector XML para devolver el mensaje que informa del resultado
          *   de la operacion.
          * @param result
          * @return
          * @throws DOMException
          * @throws Exception
          */
         protected DruidaConector crearConectorResultado(String result) throws DOMException, Exception {
                  DruidaConector druidaconector = new DruidaConector();
                  XMLDocument xmldocument = new XMLDocument();
                  Document document = xmldocument.makeDocument("<ROWSET2/>");
                  Element element = document.createElement("CAMPO");
                  element.setAttribute("NOMBRE", "resultado");
                  document.getDocumentElement().appendChild(element);
                  org.w3c.dom.Text text = document.createTextNode(result);
                  element.appendChild(text);
         
                  druidaconector.setXML(document.getDocumentElement());
						
						traza("Conector Resultado:");
						traza(druidaconector.getXML());

                  return druidaconector;
         }		

    /**
          * Devuelve el tamaño de página configurado
          * @return int
          */
         public int getPageSize() throws Exception {
                  String pagZise = Contexto.getPropiedad("PAG.SIZE");		
                  return Integer.parseInt(pagZise);
    }

	/** Obtiene el mensaje de error para la excepcion capturada
	 * @param e
	 * @return
	 */	
	public final String obtenerMensajeError(Exception e) throws Exception {
		//BelcorpError belcorpError = new BelcorpError();
		DTOError dtoError = this.mensajeError(e);
		return dtoError.getCodigoError() + "|" + dtoError.getDescripcionError();
	}
	
	public final String obtenerMensajeErrorCortado(Exception e) throws Exception {
		return this.mensajeError(e).getDescripcionError();
	}

	private final DTOError mensajeError(Exception e) throws Exception {
		//BelcorpError belcorpError = new BelcorpError();
		DTOError dtoError = null;
		dtoError = UtilidadesBelcorp.recuperarDatosException(e, this); 
		//dtoError = belcorpError.obtenerError(e, UtilidadesSession.getIdioma_ISO(this), UtilidadesSession._ISO(this));
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		e.printStackTrace(out);
		traza("En el metodo de obtencion del error");
		traza("exception cacheada:\n"+pila.toString());
		traza(dtoError.getCodigoError() + "|" + dtoError.getDescripcionError());
		return dtoError;
	}
}