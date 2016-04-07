/*
 * Created on 27-oct-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaDataBase;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.LPSICCBaseNueva;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class MMGDruidaBase extends LPSICCBaseNueva implements MMGDruidaDataBaseEnabled, MMGConstants{

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception{
		//Obtenemos la configuración del menu secunadrio para el caso de uso
		String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
		String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
		this.getConfiguracionMenu("MMGLPStartup", accion + "/" + origen);
	}

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#inicio()
	 */
	public abstract void inicio() throws Exception;
	
	public MMGDruidaBase(){
		super();
	}
	

	/**
	 * Nos permite saber si es necesario hacer requery al cargar una pagina en modo query o update
	 * @return
	 */
	protected boolean isPerformRequery(){
		//Comprobamos que en la sesión se ha indicado que hay que realizar la requery y la ejecución
		//de la LP de StartUp es por una vuleta hacia atras
		String requery = conectorParametro(VAR_PERFORM_REQUERY);
		if(requery != null && requery.equals("true")){
			return true;
		}else{
			//Si no hay que hcer requery limpiamos los atributos de la sessión de last query y perform query
			cleanActionForRequery();
			return false;
		}
	}
	
	/**
	 * Este método establece en las variables de la clase los elementos necesarios para realziar
	 * una operación de requery  
	 */
	protected void performActionForRequery() throws Exception{
		//Metemos en la página la última query realziada
		asignar("VAR", VAR_LAST_QUERY_TO_SESSION, (String)conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
		
		//Indicamos que ya se ha hecho el requery poniendo a null el atributo en la sesión
		conectorParametroSesion(SESSION_ATTRIBUTE_REQUERY, "");
	}
	
	/**
	 * Limpia de la sesión todos los elementos asociados con la requery
	 *
	 */
	protected void cleanActionForRequery(){
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, "");
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, "");
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, "");
	}
	
	/**
	 * Este método nos permite elimianr de la capa con los botones de la lista los botones
	 * que no sean necesarios
	 * @param entidad El nombre de la entidad con la que se esta trabajando. 
	 * @param accion La acción que se esta ejecutando sobre la entidad 
	 */
	protected void limpiarBotoneraLista(String entidad, String accion) throws Exception{
		if(accion.equals(ACCION_LOV)){
			borrarNodo("TD","nombre", entidad + "UpdateButtonTd");
			borrarNodo("TD","nombre", entidad + "UpdateButtonGapTd");
			borrarNodo("TD","nombre", entidad + "RemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "RemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonGapTd");
		}else if(accion.equals(ACCION_QUERY)){
			borrarNodo("TD","nombre", entidad + "UpdateButtonTd");
			borrarNodo("TD","nombre", entidad + "UpdateButtonGapTd");
			borrarNodo("TD","nombre", entidad + "RemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "RemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonGapTd");
		}else if(accion.equals(ACCION_REMOVE)){
			borrarNodo("TD","nombre", entidad + "UpdateButtonTd");
			borrarNodo("TD","nombre", entidad + "UpdateButtonGapTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonGapTd");
		}else if(accion.equals(ACCION_UPDATE)){
			borrarNodo("TD","nombre", entidad + "RemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "RemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewForRemoveButtonGapTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonTd");
			borrarNodo("TD","nombre", entidad + "LovSelectButtonGapTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonTd");
			borrarNodo("TD","nombre", entidad + "ViewButtonGapTd");
		}
	}

	/**
	 * Nos permite ejecutar una lçogica de negocio para obtener un único objeto
	 * @param businessID El bussines id que ejecutar
	 * @param objFrom El objeto con los datos del to
	 * @param objTo El objeto con los datos del from
	 * @param entidad La entidad a la cual corresponde el objeto (debe ir en formato loweriza (Ej: "nombreDeLaEntidad")
	 * @return El objeto solicitdo
	 * @throws Exception
	 */
	protected Object getSingleObject(String businessID, Object objFrom, 
		Object objTo, String entidad) throws Exception{
		return getSingleObject(businessID, objFrom, objTo, entidad, true);
	}
	
	/**
	 * Nos permite ejecutar una lçogica de negocio para obtener un único objeto
	 * @param businessID El bussines id que ejecutar
	 * @param objFrom El objeto con los datos del to
	 * @param objTo El objeto con los datos del from
	 * @param entidad La entidad a la cual corresponde el objeto (debe ir en formato loweriza (Ej: "nombreDeLaEntidad")
	 * @param applyStructuralSecurity Nos permite indicar si hay que aplicar seguridad estructural
	 * @return El objeto solicitdo
	 * @throws Exception
	 */
	protected Object getSingleObject(String businessID, Object objFrom, 
		Object objTo, String entidad, boolean applyStructuralSecurity) throws Exception{
			//Construimos el vector con la infromación a ejecutar
			Vector datos = new Vector();
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);      
			MareDTO dto = new MareDTO();
			dto.addProperty(entidad + "From", objFrom);
			dto.addProperty(entidad + "To", objTo);
			//dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
      dto.addProperty("userProperties", userProperties);//se reemplaza para que mande el pais en session
			dto.addProperty("pageCount", new Integer(1));
			dto.addProperty("pageSize", new Integer(0));
			dto.addProperty("applyStructuralSecurity", new Boolean(applyStructuralSecurity));
			datos.add(dto);
			datos.add(new MareBusinessID(businessID));

			//Ejecutamos la lógica de negocio y sacamos el resultado de la petición y lo devolvemos
			DruidaConector conectorQuery =  conectar(MMG_QUERY_CONNECTOR, datos);
			IMareDTO result = (IMareDTO)conectorQuery.objeto("result");
			Vector datosResult = (Vector)result.getProperty("result");		
			if(datosResult.size() != 0) return datosResult.get(0);
			else return null;
	}
	
	
	
	/**
	 * Nos permite invocar una lógica de negocio para poder obtener una colección de elementos
	 * @param businessID El businessid de la lógica a invocar 
	 * @param objFrom El obj from con los datos de la búsqueda
	 * @param objTo El obj to con los datos de la búsqueda
	 * @param entidad El nomreb de la entidad sobre la cual se hace la búsqueda (formato lowerize)
	 * @return la colección con los resultados de la búsqueda
	 * @throws Exception
	 */
	protected Vector getCollectionObjects(String businessID, Object objFrom, 
		Object objTo, String entidad) throws Exception{
			//Construimos el vector con la infromación a ejecutar
			Vector datos = new Vector();
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);
			MareDTO dto = new MareDTO();
			dto.addProperty(entidad + "From", objFrom);
			dto.addProperty(entidad + "To", objTo);
			//dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
      dto.addProperty("userProperties", userProperties);//se reemplaza para que mande el pais en session
			datos.add(dto);
			datos.add(new MareBusinessID(businessID));

			//Ejecutamos la lógica de negocio y sacamos el resultado de la petición y lo devolvemos
			DruidaConector conectorQuery =  conectar(MMG_QUERY_CONNECTOR, datos);
			IMareDTO result = (IMareDTO)conectorQuery.objeto("result");
			return (Vector)result.getProperty("result");		
	}
	
	/**
	 * Nos permite invocar un lógica de negocio y volcar el resultado sobre un como
	 * @param businessID El businessid de la lógica a invocar 
	 * @param objFrom El obj from con los datos de la búsqueda
	 * @param objTo El obj to con los datos de la búsqueda
	 * @param entidad El nomreb de la entidad sobre la cual se hace la búsqueda (formato lowerize)
	 * @param conectorNombre El nombre del conector usado para ejecutar la lçogica de negocio
	 * @param comboNombre El nombre del combo sobre el cual se va a volcar el código del resultado
	 * @param resultSet El nombre del resultset qie contiene los datos de vuelta
	 * @throws Exception
	 */
	protected void asignarComboResultados(String businessID, String conectorNombre, Object objFrom, 
		Object objTo, String entidad, String comboNombre, String resultSet) throws Exception{
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);
			dto.addProperty(entidad + "From", objFrom);
			dto.addProperty(entidad + "To", objTo);
			//dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
      dto.addProperty("userProperties", userProperties);//se reemplaza para que mande el pais en session
			datos.add(dto);
			datos.add(new MareBusinessID(businessID));
			DruidaConector connector =  conectar(conectorNombre, datos);
			asignar("COMBO", comboNombre, connector, resultSet);
	}
	
	/**
	 * Nos permite invocar un lógica de negocio y volcar el resultado sobre un como con la posibilidad de aplicar seguridad estructutal o no
	 * @param businessID El businessid de la lógica a invocar 
	 * @param objFrom El obj from con los datos de la búsqueda
	 * @param objTo El obj to con los datos de la búsqueda
	 * @param entidad El nomreb de la entidad sobre la cual se hace la búsqueda (formato lowerize)
	 * @param conectorNombre El nombre del conector usado para ejecutar la lçogica de negocio
	 * @param comboNombre El nombre del combo sobre el cual se va a volcar el código del resultado
	 * @param resultSet El nombre del resultset qie contiene los datos de vuelta
	 * @throws Exception
	 */
	protected void asignarComboResultados(String businessID, String conectorNombre, Object objFrom, 
		Object objTo, String entidad, String comboNombre, String resultSet, boolean applyStructuralSecurity) throws Exception{
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
      HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
      Long loidPais = UtilidadesSession.getPais(this);
      userProperties.put("loidPais",loidPais);
			dto.addProperty(entidad + "From", objFrom);
			dto.addProperty(entidad + "To", objTo);
			//dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
      dto.addProperty("userProperties", userProperties);//se reemplaza para que mande el pais en session      
			dto.addProperty("applyStructuralSecurity", new Boolean(applyStructuralSecurity));
			datos.add(dto);
			datos.add(new MareBusinessID(businessID));
			DruidaConector connector =  conectar(conectorNombre, datos);
			asignar("COMBO", comboNombre, connector, resultSet);
	}
	
	/**
	 * Nos permite borrar un campo del formulario. 
	 * @param nombre El nombre del campo a borrar
	 */
	protected void borrarCampo(String nombreAtributo) throws Exception{
		borrarNodo("TD","nombre", nombreAtributo + "TdId");
		borrarNodo("TD","nombre", nombreAtributo + "GapTdId");
	}
	
	/**
	 * Ejecuta la operación de split ya que el jodido jdk1.3 no lo soporta....
	 * @param cadena
	 * @param separador
	 * @return
	 */
	protected String[] mmgSplit(String cadena, String separador){
		Vector tokens = new Vector();
		int posAnterior = 0;
		int posActual = 0;
		
		while(posAnterior >= 0 && posAnterior < cadena.length()){
			posActual = cadena.indexOf(separador, posAnterior);
			if(posActual != -1){
				tokens.add(cadena.substring(posAnterior, posActual));
				posAnterior = posActual + separador.length();
			}else{
				tokens.add(cadena.substring(posAnterior));
				posAnterior = posActual;
			}
		}
		
		//Su el utlimo elemento es el separador suponemos que hay un elemento final vacio
		if(cadena.endsWith(separador)) tokens.add(" ");
		
		return (String[])tokens.toArray(new String[tokens.size()]);
	}
	
	/**
	 * Permite ejecutar la operación de druidabase asignarAtributo con la diferencia
	 * de que si el valor es nulo, el valor que se asigna es cadena vacia
	 * @param elemento EL tipo de elemento sobre el cual se va a realizar la asignación
	 * @param nombre El nombre del elemento
	 * @param atributo El atributo de elemento sobre el cual se va a realizar la operación
	 * @param valor El valor a asignar
	 * @throws Exception
	 */
	public void asignarAtributo(String tipoElemento, String nombre, 
		String atributo, String valor) throws Exception{
		if(valor == null) super.asignarAtributo(tipoElemento, nombre, atributo, "");
		else super.asignarAtributo(tipoElemento, nombre, atributo, valor);
	}
	
	/**
	 * Permite ejecutar la operación de asignar de druida base con la diferencia de que
	 * si es null se sustituye por cadena vacía 
	 * @param tipoElemento
	 * @param nombre
	 * @param valor
	 * @throws Exception
	 */
	public void asignar(String tipoElemento, String  nombre, 
		String valor) throws Exception{
		if(valor == null) super.asignar(tipoElemento, nombre, "");
		else super.asignar(tipoElemento, nombre, valor); 		
	}
	
	/**
	 * Método que centraliza la gestíón de excepciones producidas en el servidor
	 * Analiza la excepción producida en el servidor y redurige a la pagina de error
	 * @param e
	 */
	protected void handleException(Exception e) throws Exception{
		//Sacamos la pila del error por el out y por las trazas de druida
		e.printStackTrace();
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		traza(writer.toString());
		
		//Primero sacamos la información del error
		DTOError errorInfo = (new MMGBelcorpError()).obtenerError(
			e, MMGDruidaHelper.getIdioma(this), MMGDruidaHelper.getPais(this));
			
		//Redirigimos a la pantalla que dipare la ventana de error en el cliente
		conectorAction(LP_ERROR_DIALOG_TRIGGER);
		conectorActionOpener(false);
		conectorActionParametro(ERROR_DIALOG_TRIGGER_CODE, String.valueOf(errorInfo.getCodigoError()));
		conectorActionParametro(ERROR_DIALOG_TRIGGER_DESCRIPTION, errorInfo.getDescripcionError());
		conectorActionParametro(ERROR_DIALOG_TRIGGER_SEVERITY, String.valueOf(errorInfo.getSeveridad()));
	}
	
	/**
	 * Nos permite obtener el obheto DruidaDatabase asocido a la lp donde se guarda toda la información asoicada
	 * al pais del usuario que está ejecutando la funcionalidad
	 * @return El DruidaDataBase asociado a la lp
	 */
	public DruidaDataBase getDruidaDataBase(){
		return this.DruidaData;
	}
	
	/**
	 * Nos permite anadir el codigo en la pagina para establecer el tamaño de la página
	 * @param formName El nombre del formulario de la página
	 * @throws Exception Si se produce algún error no esperado
	 */
	protected void buildJsPageSize(String formName) throws Exception{
		DOMXPath path = new DOMXPath("//JS[@src='" + formName.toLowerCase() +"']");
		Element jsEntity = (Element)path.selectSingleNode(getXML());
		DruidaDOMObjeto obj = crearJAVASCRIPT("mmgPageSize = " + Contexto.getPropiedad("PAG.SIZE") + ";");
		getXML().getElementsByTagName("PAGINA").item(0).insertBefore(obj.getXML(), jsEntity);
	}
	
	/**
	 * Nos permite establecer el valor de las variables de las página correspodniente a las entidades estructurales
	 * con el valor por defecto del usuario 
	 */
	protected void setDefaultStructuralValues() throws Exception{
		asignar("VAR", VAR_COUNTRY_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegPais"));
		asignar("VAR", VAR_SOCIEDAD_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSocie"));
		asignar("VAR", VAR_MARCA_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegMarca"));
		asignar("VAR", VAR_CANAL_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegCanal"));
		asignar("VAR", VAR_ACCESO_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegAcces"));
		asignar("VAR", VAR_SUBACCESO_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "SegSubac"));
		asignar("VAR", VAR_SUBGERENCIA_VENTA_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonSubGenrenVenta"));
		asignar("VAR", VAR_REGION_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonRegio"));
		asignar("VAR", VAR_ZONA_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonZona"));
		asignar("VAR", VAR_SECCION_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonSecci"));
		asignar("VAR", VAR_TERRITORIO_DEFAULT, MMGDruidaHelper.gerUserStructuralEntityValue(this, "ZonTerri"));
	}
	
	/**
	 * Nos permite establecer en la variable ocutla del formulario correspondinete al tamaño del código del cliente
	 * @throws Exception
	 */
	protected void setClienteCodeSize() throws Exception{
		Byte size = obtenerLongitudCodigoCliente();
		asignar("VAR", VAR_CLIENTE_CODE_SIZE, String.valueOf(size.intValue()));
	}
	
		
}
