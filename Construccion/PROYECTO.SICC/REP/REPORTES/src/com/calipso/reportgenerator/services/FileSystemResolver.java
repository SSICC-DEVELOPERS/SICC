package com.calipso.reportgenerator.services;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import org.apache.commons.vfs.FileSystemManager;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.info.InfoException;

/**
 * FileSystemResolver
 * Clase abstracta para los distintos managers de File System que se implementen
 */
public abstract class FileSystemResolver {
	
	/**
	 * configuracion general del sistema
	 */
	private ReportGeneratorConfiguration reportGeneratorConfiguration;

	/**
	 * manager del file system por default
	 */
	private static DefaultFileSystemResolver defaultFileSystemResolver;

	/**
	 * manager del file system de MARE 
	 */
	private static MareFileSystemResolver mareFileSystemResolver;

	/**
	 * FileSystemResolver
	 * Setea la configuracion general del sistema en la instancia de la clase.
	 * @param reportGeneratorConfiguration
	 */
	public FileSystemResolver(ReportGeneratorConfiguration reportGeneratorConfiguration) {
		this.reportGeneratorConfiguration = reportGeneratorConfiguration;
	}

	/**
	 * getFileSystemManager()
	 * Debuelve un manager del file system sobre el PATH BASE.
	 * Dependiendo el tipo de servicio que se este usando MARE o CALIPSO(por default)
	 * @param reportGeneratorConfiguration
	 * @return FileSystemManager
	 * @throws MareServiceException
	 * @throws InfoException
	 * @throws MareMiiServiceNotFoundException
	 */
	public static FileSystemManager getFileSystemManager(ReportGeneratorConfiguration reportGeneratorConfiguration)
				throws MareServiceException, InfoException, MareMiiServiceNotFoundException {
		
		if (reportGeneratorConfiguration.getFrameworkPlatform().equalsIgnoreCase(FramewokPlatform.Calipso)) {
			if (defaultFileSystemResolver == null) {
				defaultFileSystemResolver = new DefaultFileSystemResolver(reportGeneratorConfiguration);
			}
			return defaultFileSystemResolver.getFileSystemManager();
			
		} else if (reportGeneratorConfiguration.getFrameworkPlatform().equalsIgnoreCase(FramewokPlatform.Mare)) {
			if (mareFileSystemResolver == null) {
				mareFileSystemResolver = new MareFileSystemResolver(reportGeneratorConfiguration);
			}
			return mareFileSystemResolver.getFileSystemManager();
			
		} else if (reportGeneratorConfiguration.getFrameworkPlatform().equalsIgnoreCase(FramewokPlatform.StandAlone)) {
			if (defaultFileSystemResolver == null) {
				defaultFileSystemResolver = new DefaultFileSystemResolver(reportGeneratorConfiguration);
			}
			return defaultFileSystemResolver.getFileSystemManager();
		}
		return null;
	}

	public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
		return reportGeneratorConfiguration;
	}

	/**
	 * resetFileSystemManager()
	 * Destruye los managers del file system
	 *
	 */
	public static void resetFileSystemManager() {
		try {
			defaultFileSystemResolver.finalize();
			defaultFileSystemResolver = null;
			mareFileSystemResolver.finalize();
			mareFileSystemResolver = null;
		} catch (Exception e) {
		} catch (Throwable throwable) {
		}
	}
}
