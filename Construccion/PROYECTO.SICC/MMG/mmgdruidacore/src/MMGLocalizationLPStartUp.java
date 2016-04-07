/*
    INDRA/CAR/mmg
    $Id: MMGLocalizationLPStartUp.java,v 1.1 2003/08/22 08:59:07 sahernan Exp $
    LP de arranque de la pagina para determinar las descripiones por localización

    DRUIDATARGET=/install/cvsiniciales
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import es.indra.belcorp.mso.SegIdiomData;
import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;

// Definicion de la clase
public class MMGLocalizationLPStartUp extends MMGDruidaBase {
	//Constantes asociadas a la accion
	public static final String NOMBRE_ATRIBUTO = "atributteName";
	public static final String LOCALIZATION_SIZE= "size";
	public static final String DESCRIPTION_FIELD = "description";
	public static final String UPDATE_DESCRIPTION_FIELD = "updateDescription";
	public static final String MAX_ATTRIBUTE = "max";
	public static final String LANGUAGE_CODES_FIELD = "languageWidgetsIds";
	public static final String DEDAULT_LANGUAGE_DESCRIPTION_FIELD = "defaultLanguageDescription"; 
	public static final String LOCALIZATION_LEFT_GAP = "localizationTableLeftGapTdId";
	public static final String LOCALIZATION_RIGHT_GAP = "localizationTableRightGapTdId";
		
	//Constantes de lógica de negocio
	public static final String LANGUAGE_QUERY_BUSINESSID = "MMGSegIdiomQueryFromToUser";
	
	// Definicion del constructor
	public MMGLocalizationLPStartUp(){
    	super();
    }

	// Definicion del metodo abstracto inicio
	public void inicio() throws Exception { 
	    pagina("MMGLocalizationPageV3");
	}
	
	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Determinamos el nombre del parametro que se va a internacionalizar
			asignar("VAR", NOMBRE_ATRIBUTO, conectorParametro(NOMBRE_ATRIBUTO));
			
			//Determinamos el codigo del idioma por defecto
			asignar("VAR", VAR_DEFAULT_LANGUAGE_CODE, MMGDruidaHelper.getUserDefaultLanguage(this));
			
			//Estabelcemos la longitud máxima de las descripcións 
			asignarAtributo("TEXT", DESCRIPTION_FIELD, MAX_ATTRIBUTE, conectorParametro(LOCALIZATION_SIZE));
			asignarAtributo("TEXT", UPDATE_DESCRIPTION_FIELD , MAX_ATTRIBUTE, conectorParametro(LOCALIZATION_SIZE));
			
			//Establecemos el valor de la longitud máxima a la variable del formulario
			asignar("VAR", LOCALIZATION_SIZE, conectorParametro(LOCALIZATION_SIZE));
			
			//Sacamos todos los idiomas que haya en la base de datos
			SegIdiomData query = new SegIdiomData(); 
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segIdiomFrom", query);
			dto.addProperty("segIdiomTo", query.clone());
			dto.addProperty("userProperties", (HashMap)conectorParametroSesion("propiedades"));
			datos.add(dto);
			datos.add(new MareBusinessID(LANGUAGE_QUERY_BUSINESSID));
			DruidaConector conectorQuery =  conectar(MMG_QUERY_CONNECTOR, datos);
			IMareDTO result = (IMareDTO)conectorQuery.objeto("result");
			Vector datosResult = (Vector)result.getProperty("result");
			
			//Nos recorremos todos los idiomas y vamos crenado de forma dinamica los elementos de la pagina
			//Ajustamos previamente el rowspan de las celdas que hacen de separador de los bordes
			//Aprovchamos el bucle i establecemos la descripción del idioma por defecto 
			asignarAtributo("TD", LOCALIZATION_LEFT_GAP, "rowspan", String.valueOf((datosResult.size()*3)+1));
			asignarAtributo("TD", LOCALIZATION_RIGHT_GAP, "rowspan", String.valueOf((datosResult.size()*3)+1));
			for (Iterator it = datosResult.iterator(); it.hasNext();) {
				SegIdiomData idioma = (SegIdiomData)it.next();
				generarIdiomaTags(idioma);
				if(idioma.getId().intValue() == Integer.parseInt(MMGDruidaHelper.getUserDefaultLanguage(this)))
					asignar("VAR", DEDAULT_LANGUAGE_DESCRIPTION_FIELD, idioma.toString());
			}
			
			//Almacenamos los codigos de los idomas que aparecen en el formulario
			asignar("VAR", LANGUAGE_CODES_FIELD, generarStirngCodigosIdiomas(datosResult)); 
		}catch(MMGNoSessionException e){
			conectorAvisoModal(LP_PANTALLA_ERROR);
			conectorAvisoModalParametro(PARAMETRO_CODIGO_ERROR, String.valueOf(ERRORCODE_NO_SESSION));
			conectorAvisoModalParametro(PARAMETRO_IDIOMA, MMGDruidaHelper.getIdioma(this));
			conectorAvisoModalParametro(PARAMETRO_PAIS, "ES");
		}catch(MMGException e){
			conectorAvisoModal(LP_PANTALLA_ERROR);
			conectorAvisoModalParametro(PARAMETRO_CODIGO_ERROR, String.valueOf(e.getErrorCode()));
			conectorAvisoModalParametro(PARAMETRO_IDIOMA, MMGDruidaHelper.getIdioma(this));
			conectorAvisoModalParametro(PARAMETRO_PAIS, "ES");
		}catch(Exception e){
			conectorAvisoModal(LP_PANTALLA_ERROR);
			conectorAvisoModalParametro(PARAMETRO_CODIGO_ERROR, String.valueOf(ERRORCODE_DESCONOCIDO));
			conectorAvisoModalParametro(PARAMETRO_IDIOMA, MMGDruidaHelper.getIdioma(this));
			conectorAvisoModalParametro(PARAMETRO_PAIS, "ES");
		}
	}
	
	/**
	 * Nos permite generar los tags necesarios en la pagina para añadir un nuevo idioma
	 * @param idioma el idioma para el cual vamos a generar los elementos
	 */
	protected void generarIdiomaTags(SegIdiomData idioma) throws Exception{
		DruidaDOMObjeto obj = null;
				
		//Creamos el tr correspondiente al titulo del idioma y las celdas con los elementos
		obj = crearTR("language" + idioma.getId()+ "TittleTrId", "", "", "");
		asignar("TABLE", "nombre", "localizationTable", obj);
		asignar("TR", "nombre", "language" + idioma.getId()+ "TittleTrId", generarTDVacio("language" + idioma.getId()+ "TittleTdId"));
		obj = crearLABELC("language" + idioma.getId() + "TitleLabel", "40", "17", "1", idioma.toString(), "datosTitle");
		asignar("TD", "nombre", "language" + idioma.getId()+ "TittleTdId", obj);

		//Creamos el tr correspondiente al widget del idioma y las celdas con los elementos
	  obj = crearTR("language" + idioma.getId()+ "WidgetTrId", "", "", "");
	  asignar("TABLE", "nombre", "localizationTable", obj);
	  asignar("TR", "nombre", "language" + idioma.getId()+ "WidgetTrId", generarTDVacio("language" + idioma.getId()+ "WidgetTdId"));
		if(Integer.parseInt(conectorParametro(LOCALIZATION_SIZE)) <= LOCALIZATION_THRESHOLD){
			obj = crearCaja("language" + idioma.getId() + "Value", "", conectorParametro(LOCALIZATION_SIZE), 
				conectorParametro(LOCALIZATION_SIZE), "", isIdiomaDefecto(idioma)? "S": "N", "", "", "", "datosCampos");
		}else{
			obj = crearTEXTAREA("language" + idioma.getId() + "Value", "", "3", "50", "", 
				isIdiomaDefecto(idioma)? "S": "N", "", "", "", "datosCampos");
		}
	  asignar("TD", "nombre", "language" + idioma.getId()+ "WidgetTdId", obj);
	  
		//Creamos el tr correspondiente al gap entre los widget de idioma
		obj = crearTR("language" + idioma.getId()+ "GapTrId", "", "", "");
	  asignar("TABLE", "nombre", "localizationTable", obj);
	  asignar("TR", "nombre", "language" + idioma.getId()+ "GapTrId", generarTDVacio("language" + idioma.getId()+ "GaptTdId"));
	}

	/**
	 * Nos permite generar un td vacui 
	 * @return el ojeto DruidaDOMObjeto representanre de celda vacía
	 * @throws Exception
	 */
	protected DruidaDOMObjeto generarTDVacio(String nombre) throws Exception{
		return crearTD(nombre, "", "", "", "", "", "");
	}
	
	protected DruidaDOMObjeto generarLabelVacio() throws Exception{
		DruidaDOMObjeto obj = crearTAG("IMG");
		obj.setAtributo("src", "b.gif");
		obj.setAtributo("width", "8");
		obj.setAtributo("height", "8");
		return obj;
	}
	
	/**
	 * Genera un string de la forma codIdiom1|codIdiom2|codIdiom3.... con los codigos 
	 * de los idiomas contenidos en el vector para como parmetro
	 * @param idiomas Vector con objetos de tipo SegIdiomData
	 * @return String con la cocatenación de los codigos de los idimas pasados y separados por "|"
	 */
	protected String generarStirngCodigosIdiomas(Vector idiomas){
		StringBuffer cadena = new StringBuffer();
		for (Iterator it = idiomas.iterator(); it.hasNext();) {
			SegIdiomData idioma = (SegIdiomData) it.next();
			cadena.append(idioma.getId());
			if(it.hasNext()) cadena.append("|");
		}
		return cadena.toString();
	}
	
	protected boolean isIdiomaDefecto(SegIdiomData idioma){
		return idioma.getId().intValue() == DEFAULT_LANGUAGE_CODE;
	}
}


