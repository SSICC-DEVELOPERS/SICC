/*
 * Created on 10-mar-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

import java.io.Serializable;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.ErrorManager;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.utils.FormatUtils;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MMGDruidaHelper implements Serializable, MMGConstants {

	/**
	 * Nos permite obtener el mensaje de error asociado al errorCode. 
	 * Si se produce algún error se devuleve cadena vacía 
	 * @param errorCode El codgio del error del que queremos obtener el mensaje	 * @return EL mensaje asociado al codigo de error
	 * @throws Exception Error no controlado producido por elementos druida
	 */
	public static String getErrorMessage(MMGDruidaBase druidaBase, int errorCode){
		return getErrorMessage(druidaBase, errorCode, new Locale("", ""));
	}
	
	/**
	 * Nos permite obtener el mensaje de error internacionalizado asociado a un código de error
	 * @param errorCode errorCode El codgio del error del que queremos obtener el mensaje
	 * @param locale El locale en el cual queremos obtener el mensaje internacionalizado
	 * @return El mensaje. Se se produjera algún error se devuelve cadena vacia
	 * @throws Exception
	 */
	public static String getErrorMessage(MMGDruidaBase druidaBase, int errorCode, Locale locale){
		try{
			return ErrorManager.getErrorMessage(errorCode, locale.getLanguage(), locale.getCountry());
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Nos permite obtener el hasmap con los atributos del usuario
	 * @return
	 * @throws MMGNoSessionException Si la sesión a espirado o no están definidos los parámetros de los usuarios
	 */
	public static HashMap getUserProperties(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = (HashMap)druidaBase.conectorParametroSesion(USER_PROPERTIES);
		if(userProperties == null) throw new MMGNoSessionException();
		else return userProperties;
	}
	
	/**
	 * Nos permite obtener el hasmap con los atributos del usuario
	 * @param formater El formater desde el cual se ha hecho la llamda
	 * @return
	 * @throws MMGNoSessionException
	 */
	public static HashMap getUserProperties(DruidaFormatoObjeto formater) throws MMGNoSessionException{
		HashMap userProperties = (HashMap)formater.conectorParametroSesion(USER_PROPERTIES);
		if(userProperties == null) throw new MMGNoSessionException();
		else return userProperties;
	}
	
	/**
	 * Nos permite obtenber el codigo del idioma del ususario
	 * @return El código del idioma del usuario
	 * @throws MMGNoSessionException
	 * @throws MMGNoLanguageException
	 */
	public static String getUserLanguage(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		return druidaBase.getDruidaDataBase().usuarioIdioma();
	}
	
	/**
	 * Nos permite obtener el pais del usuario
	 * @return El pais del usuario
	 * @throws MMGNoSessionException Si ha cadecado la sesión
	 * @throws MMGNoLanguageException No el usuario no tiene definido un pais
	 */
	public static String getUserCountry(DruidaBase druidaBase) throws MMGNoSessionException, MMGException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_COUNTRY);
		if(property == null) throw new MMGException(ERRORCODE_NO_USER_COUNTRY);
		
		HashSet paises = (HashSet)property.getValue();
		if(paises.size() == 0) throw new MMGException(ERRORCODE_NO_USER_COUNTRY);
		else return (String)paises.iterator().next();
	}
	
	/**
	 * Nos permite obtener el patron de fechas del usuario
	 * @return EL patrón de las fechas del usuario
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String getUserDatePattern(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		return druidaBase.getDruidaDataBase().usuarioFormatoFecha();
	}
	
	/**
	 * Iguua getUserDatePattern pero con la diferencia de si queremos el pattron en formato java ("M" para meses (m en minuscula es minuto) y "y" para años)
	 * @param druidaBase La lp desde la que se ha hecho la llamada al método
	 * @param javaStyle javaStyle flag que indica si el patron devuelto debe obtener la normativa java: 'd' para dias 'M' para meses y 'y' para los años
	 * @return
	 */
	public static String getUserDatePattern(MMGDruidaDataBaseEnabled druidaBase, boolean javaStyle) throws Exception{
		String datePattern = getUserDatePattern(druidaBase);
		if(javaStyle){
			datePattern = FormatUtils.replaceAll(datePattern, "d", "dd");
			datePattern = FormatUtils.replaceAll(datePattern, "D", "dd");
			datePattern = FormatUtils.replaceAll(datePattern, "m", "MM");
			datePattern = FormatUtils.replaceAll(datePattern, "M", "MM");
			datePattern = FormatUtils.replaceAll(datePattern, "Y", "yyyy"); 
		}
		return datePattern;
	}
	
	/**
	 * Nos permite obtener el separador decimal del usuario
	 * @return
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String getUserDecimalSeparator(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		return druidaBase.getDruidaDataBase().usuarioCaracterDecimal();
	}
	
	/**
	 * Nos permite obtener el separador de miles configurado para el usuario
	 * @return El separador de miles configurado para el usuario
	 * @throws MMGNoSessionException Si la sesión a caducado
	 * @throws MMGException Si el usuario no tiene definido el simbolo de separador de miles
	 */
	public static String getUserGroupingSeparator(MMGDruidaDataBaseEnabled druidaBase) throws MMGNoSessionException, MMGException{
		return ".";
	}
	
	/**
	 * Nos pormite obtener el número de decimales asociados al usuario para el formate
	 * @param druidaBase LP desde la cual se realiza la llamada
	 * @return El numero de decimales configurados para el usuario. SI el usuario no tiene configurado ninguno for defecto se devuleve 1 
	 * @throws MMGNoSessionException
	 */
	public static short getUserDecimalPrecision(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		return new Integer(druidaBase.getDruidaDataBase().usuarioNumeroDecimales()).shortValue();
	}
	
	/**
	 * Nos permite obtener los simbolos de formateo correspondiete al usuario
	 * @return Objeto de tipo DecimalFormatSymbols con la configuración de separador de miles y seprador decimal
	 */
	public static DecimalFormatSymbols getUserDecimalFormatSymbols(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator(getUserDecimalSeparator(druidaBase).charAt(0));		
		symbols.setGroupingSeparator(getUserGroupingSeparator(druidaBase).charAt(0));
		return symbols;
	}
	
	/**
	 * Nos permite obtener el patron de formateo de numero para el usuario
	 * @param druidaBase La lp desde la cual se realiza la llamada
	 * @return
	 */
	public static String getUserDecimalFormatPattern(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		StringBuffer pattern = new StringBuffer("#,##0.");
		short decimalPrecision = getUserDecimalPrecision(druidaBase);
		for (short i = 0; i < decimalPrecision; i++) pattern.append("0");
		return pattern.toString();
	}
	
	/**
	 * Nos permite obtener el codigo del idioma por defecto configurado al usuario
	 * @return 
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String getUserDefaultLanguage(DruidaBase druidaBase) throws MMGNoSessionException, MMGException{
		return String.valueOf(DEFAULT_LANGUAGE_CODE);
	}
	
	/**
	 * Nos permite obetner el codigo del pais por defecto asociado al usuario 
	 * @return
	 * @throws MMGNoSessionException Si la sesión ha expirado
	 * @throws MMGException Si el usaurio no tiene dedinifo pais por defecto
	 */
	public static String getUserDefaultCountry(DruidaBase druidaBase) throws MMGNoSessionException, MMGException{
		Property property = (Property)getUserProperties(druidaBase).get(USER_PROPERTY_COUNTRY_DEFAULT);
		if(property == null)throw new MMGException(ERRORCODE_NO_DEFAULT_COUNTRY);
		
		String paisDefecto = (String)property.getValue();
		if(paisDefecto == null || paisDefecto.trim().equals("")) throw new MMGException(ERRORCODE_NO_DEFAULT_COUNTRY);
		else return paisDefecto;
	}
	
	/**
	 * Nos permite obtener la sociedad configurada para el usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultSociedad(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_SOCIEDAD_DEFAULT);
		if(property == null) return null;
		
		String sociedad = (String)property.getValue();
		if(sociedad != null && !sociedad.trim().equals("")) return sociedad;
		else return null;
	}
	
	/**
	 * Nos permite obtener la maraca asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultMarca(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_MARCA_DEFAULT);
		if(property == null) return null;
		
		String marca = (String)property.getValue();
		if(marca != null && !marca.trim().equals("")) return marca;
		else return null;
	}

	/**
	 * Nos permite obtener el canal asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultCanal(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_CANAL_DEFAULT);
		if(property == null) return null;
		
		String canal = (String)property.getValue();
		if(canal != null && !canal.trim().equals("")) return canal;
		else return null;
	}
	
	/**
	 * Nos permite obtener el acceso asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultAcceso(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_ACCESO_DEFAULT);
		if(property == null)return null;
		
		String acceso = (String)property.getValue();
		if(acceso != null && !acceso.trim().equals("")) return acceso;
		else return null;
	}
	
	/**
	 * Nos permite obtener el subacceso asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultSubAcceso(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_SUBACCESO);
		if(property == null)return null;
		
		String subacceso = (String)property.getValue();
		if(subacceso != null && !subacceso.trim().equals("")) return subacceso;
		else return null;
	}
	
	/**
	 * Nos permite obtener la subgerencia de ventas asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultSubgerenciaVentas(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_SUBGERENCIA_VENTA_DEFAULT);
		if(property == null) return null;
		
		String subgerenciaVentas = (String)property.getValue();
		if(subgerenciaVentas!= null && !subgerenciaVentas.trim().equals("")) return subgerenciaVentas;
		else return null;
	}
	
	/**
	 * Nos permite obtener la región asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultRegion(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_REGION_DEFAULT);
		if(property == null) return null;
		
		String region = (String)property.getValue();
		if(region!= null && !region.trim().equals("")) return region;
		else return null;
	}
	
	/**
	 * Nos permite obtener la zona asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultZona(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_ZONA_DEFAULT);
		if(property == null) return null;
		
		String zona = (String)property.getValue();
		if(zona!= null && !zona.trim().equals("")) return zona;
		else return null;
	}
	
	/**
	 * Nos permite obtener la seccion asociada al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultSeccion(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_SECCION_DEFAULT);
		if(property == null) return null;
		
		String seccion = (String)property.getValue();
		if(seccion!= null && !seccion.trim().equals("")) return seccion;
		else return null;
	}
	
	/**
	 * Nos permite obtener el territorio asociado al usuario
	 * @param druidaBase La lp desde la que se ha realizado la llamada
	 * @return
	 */
	public static String getUserDefaultTerritorio(DruidaBase druidaBase) throws MMGNoSessionException{
		HashMap userProperties = getUserProperties(druidaBase);
		Property property = (Property)userProperties.get(USER_PROPERTY_TERRITORIO_DEFAULT);
		if(property == null) return null;
		
		String territorio = (String)property.getValue();
		if(territorio!= null && !territorio.trim().equals("")) return territorio;
		else return null;
	}
	
	
	/**
	 * Nos permite obtener el valor del usuario para una determinada entidada estructurak
	 * @param druidaBase La lp desde la cual se realiza la llamada al método
	 * @param entity El nombre de la entidada estructural: SegPais, SegSocie, SegMarca, SegCanal, SegAcces, SegSubac, ZonSubGenrenVenta, ZonRegio, ZonZona, ZonSecci, ZonTerri 
	 * @return El codigo de la entidad asociada al usuario. Null si no es una entidad estructural o el usuario no tiene asociado ningún valor
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String gerUserStructuralEntityValue(DruidaBase druidaBase, String entity) throws MMGNoSessionException, MMGException{
		if(entity.equals("SegPais")) return getUserCountry(druidaBase);
		else if(entity.equals("SegSocie")) return getUserDefaultSociedad(druidaBase);
		else if(entity.equals("SegMarca")) return getUserDefaultMarca(druidaBase);
		else if(entity.equals("SegCanal")) return getUserDefaultCanal(druidaBase);
		else if(entity.equals("SegAcces")) return getUserDefaultAcceso(druidaBase);
		else if(entity.equals("SegSubac")) return getUserDefaultSubAcceso(druidaBase);
		else if(entity.equals("ZonSubGenrenVenta")) return getUserDefaultSubgerenciaVentas(druidaBase);
		else if(entity.equals("ZonRegio")) return getUserDefaultRegion(druidaBase);
		else if(entity.equals("ZonZona")) return getUserDefaultZona(druidaBase);
		else if(entity.equals("ZonSecci")) return getUserDefaultSeccion(druidaBase);
		else if(entity.equals("ZonTerri")) return getUserDefaultTerritorio(druidaBase);
		else return null;
	}
	
	/**
	 * Nos permite obtener el idioma de la sessión
	 * @return El idioma con el que se traba en la sesion
	 */
	public static String getIdioma(MMGDruidaDataBaseEnabled druidaBase) throws Exception{
		return getUserLanguage(druidaBase);
	}
	
	/**
	 * Saca de la pagina asociada a la LP el valor del atriburo "xml:lang" del elemento &lt;PAGINA&gt;
	 * @return lo dicho en la descripción
	 * @throws Exception
	 */
	public static String getLanguageFromXML(MMGDruidaBase druidaBase) throws Exception{
		return druidaBase.getXML().getDocumentElement().getAttribute("xml:lang");
	}
	
	/**
	 * Nos permite obtener el codigo ISO del pais del usuario
	 * @return
	 */
	public static String getPais(DruidaBase druidaBase) throws Exception{
		//TODO. Por ahora devuleve el valor que haya en el app.properties pero esto habrá que cambiarlo
		return UtilidadesSession._ISO(druidaBase);
	}
	
	/**
	 * Nos permite completar el patón de validación de valor maximo para la función de javascript de druida ValidaInt
	 * @param numeroDigitosEnteros
	 * @param druidaBase
	 * @return
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String getMaxValueForDruidaValidaInt(int numeroDigitosEnteros) throws MMGNoSessionException, MMGException{
		StringBuffer maxValue = new StringBuffer("");
		for(int i=0; i < numeroDigitosEnteros; i++) maxValue.append("9");
		return maxValue.toString();
	}	
	
	/**
	 * Nos permite completar el patón de validación de valor maximo para la función de javascript de druida ValidaFloat
	 * @param validacionParteEnera La parte del la validación correpondiente a la parte entera
	 * @param druidaBase La lp que hace la llamada
	 * @return patrón de valiadción de valor maximo para la función javascript de druida ValidaFloat
	 * @throws MMGNoSessionException
	 * @throws MMGException
	 */
	public static String getMaxValueForDruidaValidaFloat(int numeroDigitosEnteros, MMGDruidaBase druidaBase) throws MMGNoSessionException, MMGException, Exception{
		StringBuffer maxValue = new StringBuffer(getMaxValueForDruidaValidaInt(numeroDigitosEnteros)); 
		maxValue.append(",");
		short digitosDecimales = getUserDecimalPrecision(druidaBase);
		for(short i = 0; i < digitosDecimales; i++) maxValue.append("9");
		return maxValue.toString();
	}
}
