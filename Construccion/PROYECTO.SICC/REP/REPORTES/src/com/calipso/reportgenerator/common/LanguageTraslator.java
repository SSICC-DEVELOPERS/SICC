package com.calipso.reportgenerator.common;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.util.Locale;

/**
 * Esta clase se encarga de convertir los textos al lenguaje indicado.
 * Implementa la internacionalización.
 */

public class LanguageTraslator {

	private static Locale locale;

	private static ILanguageTraslator currentLanguage;

	private static String path;

	/**
	 * Crea una nueva instancia de Locale segun el lenguaje por recibe por
	 * parametro
	 * 
	 * @param language
	 * @param country
	 * @param languagePath
	 */
	public static void newLocaleFrom(String language, String country,
			String languagePath) {
		locale = new Locale(language, country);
		path = languagePath;
	}

	public static Locale getLocale() {
		return locale;
	}

	/**
	 * Devuelve un String a partir del id. El idioma del String devuelto
	 * corresponde a la instancia del Locale actual.
	 * 
	 * @param id
	 * @return
	 */
	public static String traslate(String id) {
		String s = "";
		try {
			s = getInstance().getExceptionFromId(id);
		} catch (Exception e) {
			ReportManagerLogger.error("Traslate Error:" + id);
			s = id;
		}
		return s;
	}

	/**
	 * Crea una instancia de la clase que contiene las traducciones segun el
	 * lenguaje definido en la instancia de Locale. Para cada lenguaje existe
	 * una clase diferente. Por defecto devuelve una clase que contiene las
	 * traducciones en castellano.
	 * 
	 * @return ILanguageTraslator
	 */
	private static ILanguageTraslator getInstance() {
		Class languageTraslatorClass = null;
		if ((currentLanguage == null) && ((locale != null))) {
			if (locale.getLanguage().toUpperCase().equals("ES")) {
				// intenta cargar un leguaje para logear los mensages
				try {
					// TODO : cambiar la forma en la que se realizan la
					// parametrizacion de los idiaomas para el logeo
					// deberia haber administrador de parametrizacion mas
					// unificado
					languageTraslatorClass = Class.forName("com.calipso.reportgenerator.common.LanguageTraslator"+ locale.getLanguage().toUpperCase());
				} catch (Exception e) {
					ReportManagerLogger.error("ERROR - LanguageTraslator"+ locale.getLanguage().toUpperCase());
					// si no puede cargar la clase con las descripciones carga
					// una por defecto
					// TODO: esto debe estar centralizado atraves de un
					// administrador
					languageTraslatorClass = new LanguageTraslatorES().getClass(); // TODO : revisar en modo EJB
				}

				// instancia creada para iniciar el logeuo con las descripciones
				// del lenguaje correspondiente
				try {
					currentLanguage = (ILanguageTraslator) languageTraslatorClass.newInstance();
				} catch (Exception e) {
					ReportManagerLogger.error("ERROR - LanguageTraslator"+ locale.getLanguage().toUpperCase());
					currentLanguage = null;
				}
			} else {
				try {
					// TODO : inisto no esta centralizada la forma de trabajar
					// con un gestor de parametrizacion
					Configuration configuration = new PropertiesConfiguration(path + "/" + locale.getLanguage() + ".properties");
					currentLanguage = new LanguageTraslatorCustomizable(configuration);
				} catch (Exception e) {
					ReportManagerLogger.error("ERROR - LanguageTraslator"+ locale.getLanguage().toUpperCase());
					currentLanguage = null;
				}
			}
		}
		return currentLanguage;
	}
}
