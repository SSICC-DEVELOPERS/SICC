package com.calipso.reportgenerator.common;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.awt.Image;

import es.indra.mare.common.info.InfoException;

import org.apache.commons.configuration.ConfigurationException;


/**
 * Configuración del ReportGegnerator.
 */
public class ReportGeneratorConfiguration implements java.io.Serializable {

	private Map values;

	private ILanguageTraslator currentLanguage;

	/**
	 * Inicializa la configuración
	 * 
	 * @param reportGeneratorConfiguration
	 * @throws es.indra.mare.common.info.InfoException
	 */
	public ReportGeneratorConfiguration(
			Configuration reportGeneratorConfiguration) throws InfoException {
		fillValues(reportGeneratorConfiguration);
		validate();
	}

	public Map getValues() {
		if (values == null) {
			values = new HashMap();
		}
		return values;
	}

	private void fillValues(Configuration reportGeneratorConfiguration) {
		// TODO : no le encuentro sentido a recorrer una collecion del tipo clave valor para ponerla en otra
		Iterator iter = reportGeneratorConfiguration.getKeys();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			String value = reportGeneratorConfiguration.getString(key);
			getValues().put(key, value);
		}

	}

	/**
	 * Inicializa la configuración a partir de un file
	 * 
	 * @param file
	 * @throws es.indra.mare.common.info.InfoException
	 */
	public ReportGeneratorConfiguration(String file) throws InfoException {
		try {
			fillValues(new PropertiesConfiguration(file));
			validate();
		} catch (ConfigurationException e) {
			throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("228"), e);
		}
	}

	/**
	 * Valida que la configuración sea la correcta
	 */
	public void validate() throws InfoException {
		if (getValues().isEmpty()) {
			throw new InfoException(
					com.calipso.reportgenerator.common.LanguageTraslator
							.traslate("81"));
		}
	}

	public boolean getIsDistributed() {
		return (values.get("IsDistributed").equals("true"));
	}

	public String getDistributedHost() {
		return (String) values.get("DistributedHost");
	}

	public String getDistributedPort() {
		return (String) values.get("DistributedPort");
	}

	private String getRoot() {
		String property = System.getProperty("MareConfigurationRoot");
		if (property != null) {
			return property + "/reportes";
		} else {
			return "";
		}
	}

	public String getReportDefinitionRepositoryPath() {
		return getRoot()
				+ (String) values.get("ReportDefinitionRepositoryPath");
	}

	public String getReportSourceDefinitionRepositoryPath() {
		return getRoot()
				+ (String) values.get("ReportSourceDefinitionRepositoryPath");
	}

	public String getReportSourceRepositoryPath() {
		return getRoot() + (String) values.get("ReportSourceRepositoryPath");
	}

	public String getReportViewRepositoryPath() {
		return getRoot() + (String) values.get("ReportViewRepositoryPath");
	}

	public String getINITIAL_CONTEXT_FACTORY() {
		return (String) values.get("INITIAL_CONTEXT_FACTORY");
	}

	public String getJavaNamingFactoryUrlPkgs() {
		return (String) values.get("java.naming.factory.url.pkgs");
	}

	public String getDatePattern() {
		return (String) values.get("DatePattern");
	}

	public boolean queryCacheEnabled() {
		if (values.containsKey("queryCacheEnabled")) {
			return (values.get("queryCacheEnabled").equals("true"));
		} else {
			return true;
		}

	}

	/**
	 * getLocaleLanguage()
	 * Busca el lenguaje seteado en el archivo de configuracion
	 * si no lo encuentra debuelve por defecto el español "ES"
	 * @return String
	 */
	public String getLocaleLanguage() {
		//TODO : "ES" deberia estar en una interfas que lleve las constantes
		if (values.containsKey("Language")) {
			if ((values.get("Language")).equals("")) {
				return "ES";
			} else {
				return (String) values.get("Language");
			}
		}
		return "ES";
	}

	public void setLocaleLanguage(String value) {
		if (values.containsKey("Language")) {
			values.remove("Language");
		}
		values.put(new String("Language"), new String(value));
	}

	public String getCountry() {
		if (values.containsKey("Country")) {
			return (String) values.get("Country");
		}
		return "";
	}

	public String getSourceReportDefinitionsPath() {
		return getRoot() + (String) values.get("SourceReportDefinitionsPath");
	}

	public String getSourceReportSourceDefinitionsPath() {
		return getRoot()
				+ (String) values.get("SourceReportSourceDefinitionsPath");
	}

	public String getSourceReportViewsPath() {
		return getRoot() + (String) values.get("SourceReportViewsPath");
	}

	public String getSourceReportSchemasPath() {
		return getRoot() + (String) values.get("SourceReportSchemasPath");
	}

	public String getFrameworkPlatform() {
		return (String) values.get("FrameworkPlatform");
	}

	public String getCachePath() {
		return getRoot() + (String) values.get("CachePath");
	}

	public String getCacheSizeLimit() {
		return (String) values.get("CacheSizeLimit");
	}

	public String getUsersRepositoryPath() {
		return getRoot() + (String) values.get("UsersRepositoryPath");
	}

	public String getBasePath() {
		if (values.containsKey("BasePath")) {
			return (String) values.get("BasePath");
		} else {
			return ".";
		}
	}

	public String getLanguagesPath() {
		if (values.containsKey("LanguagesPath")) {
			return getRoot() + (String) values.get("LanguagesPath");
		} else {
			return ".";
		}
	}

	public String getImagesPath() {
		if (values.containsKey("ImagesPath")) {
			return getRoot() + (String) values.get("ImagesPath");
		} else {
			return ".";
		}
	}

	public String getJasperReportPath() {
		String returnStr = "";
		if (values.containsKey("JasperReportPath")) {
			returnStr = getRoot() + (String) values.get("JasperReportPath");
		}
		return returnStr;
	}

	public String getJasperCompilerClass() {
		String returnStr = "";
		if (values.containsKey("JasperCompilerClass")) {
			returnStr = (String) values.get("JasperCompilerClass");
		}
		return returnStr;
	}

	public String getReportManagerEJB_SFName() {
		String returnStr = "ReportManagerSF";
		if (values.containsKey("ReportManagerEJB_SFName")) {
			returnStr = (String) values.get("ReportManagerEJB_SFName");
		}
		return returnStr;
	}

	public String getReportManagerEJB_SLName() {
		String returnStr = "ReportManagerSL";
		if (values.containsKey("ReportManagerEJB_SLName")) {
			returnStr = (String) values.get("ReportManagerEJB_SLName");
		}
		return returnStr;
	}

	public static PropertiesConfiguration getConfiguration(String propertiesPath)
			throws InfoException {
		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(ReportGeneratorConfiguration.getConfigurationPath(propertiesPath));
		} catch (ConfigurationException e) {
			ClassLoader loader = ReportGeneratorConfiguration.class.getClassLoader();
			InputStream inputStream = loader.getResourceAsStream("ReportGeneratorConfiguration.properties");
			config = new PropertiesConfiguration();
			try {
				config.load(inputStream);
			} catch (ConfigurationException e1) {
				throw new InfoException("372", e);
			}
		}
		return config;
	}

	public static String getConfigurationPath(String propertiesPath) {
	//	System.out.println("propertiesPath:" + propertiesPath);
		if (!propertiesPath.equals("")) {
			return propertiesPath + "/ReportGeneratorConfiguration.properties";
		} else {
			String property = System.getProperty("MareConfigurationRoot");
			if (property != null) {
				return property	+ "/reportes/ReportGeneratorConfiguration.properties";
			} else {
				property = System.getProperty("CalipsoConfigurationRoot");
				if (property != null) {
					return property	+ "/ReportGeneratorConfiguration.properties";
				} else {
					return "./ReportGeneratorConfiguration.properties";
				}
			}
		}
	}

	/**
	 * Retorna el directorio de las imágenes
	 * 
	 * @return
	 */
	public File getImageDir() {
		File file = new File(getImagesPath());
		String frameWork = getFrameworkPlatform();
		if (file.listFiles() != null) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().toUpperCase().trim().equals(frameWork)) {
					return files[i];
				}
			}
		}
		return null;
	}

	/**
	 * Retorna el path de una imagen
	 * 
	 * @param imageName
	 * @return
	 */
	public String getImagePath(String imageName) {
		String imagePath = null;
		File file = getImageDir();
		if (file != null) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().toUpperCase().trim().equals(
						imageName + ".JPG")
						|| files[i].getName().toUpperCase().trim().equals(
								imageName + ".PNG")
						|| files[i].getName().toUpperCase().trim().equals(
								imageName + ".BMP")
						|| files[i].getName().toUpperCase().trim().equals(
								imageName + ".GIF")) {
					imagePath = files[i].toString();
					break;
				}
			}
		}
		return imagePath;
	}

	/**
	 * Retorna una imagen
	 * 
	 * @param imageName
	 * @return
	 */
	public Image getImage(String imageName) {
		String path = getImagePath(imageName);
		if (path != null) {
			return java.awt.Toolkit.getDefaultToolkit().getImage(path);
		} else {
			return null;
		}
	}

	public String getSourceReportLayoutPath() {
		return getRoot() + (String) values.get("SourceReportLayoutsPath");
	}

	public String getReportLayoutStyle() {
		return (String) values.get("ReportLayoutStyle");
	}

	public ILanguageTraslator getLanguageTraslator() {
		if (currentLanguage == null) {
			if (!getLocaleLanguage().equals("")) {
				try {
					Configuration configuration = new PropertiesConfiguration(
							getLanguagePath());
					currentLanguage = new LanguageTraslatorCustomizable(
							configuration);
				} catch (Exception e) {
					{
						e.printStackTrace();
					}
				}
			}
		}
		return currentLanguage;
	}

	private String getLanguagePath() {
		String path = "";
		String property = System.getProperty("MareConfigurationRoot");
		if (property != null) {
			path = property + "/reportes/language_" + getLocaleLanguage()
					+ ".properties";
		} else {
			property = System.getProperty("CalipsoConfigurationRoot");
			if (property != null) {
				path = property + "/Language_" + getLocaleLanguage()
						+ ".properties";
			} else {
				path = "./repository/languajes/language_" + getLocaleLanguage() + ".properties";
			}
		}
		return path;
	}

  	public int getFetchSize() {
    	if(values.containsKey("FetchSize")){
      		return Integer.parseInt(values.get("FetchSize").toString());
    	}
    return 500;
  }



}
