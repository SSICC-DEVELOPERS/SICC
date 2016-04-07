package com.calipso.reportgenerator.services;

import org.apache.commons.vfs.impl.StandardFileSystemManager;

import org.apache.commons.vfs.FileSystemManager;

import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;

import es.indra.mare.common.info.InfoException;

import java.io.File;

/**
 * DefaultFileSystemResolver
 * Resuerlve un file system por defecto
 */
public class DefaultFileSystemResolver extends FileSystemResolver {

	/**
	 * Manager para manejar un file system
	 */
	private FileSystemManager fileSystemManager;

	/**
	 * DefaultFileSystemResolver
	 * Setea la configuracion general del sistema en la instancia de esta clase.
	 * @param reportGeneratorConfiguration
	 */
	public DefaultFileSystemResolver(ReportGeneratorConfiguration reportGeneratorConfiguration) {
		super(reportGeneratorConfiguration);
	}

	/**
	 * getFileSystemManager()
	 * Devuelve el manager por default para manejar el file system
	 * @return FileSystemManager
	 * @throws InfoException
	 */
	public FileSystemManager getFileSystemManager() throws InfoException {
		if (fileSystemManager == null) {
			fileSystemManager = new StandardFileSystemManager();
			try {
				((StandardFileSystemManager) fileSystemManager).init();
				((StandardFileSystemManager) fileSystemManager).setBaseFile(new File(getReportGeneratorConfiguration().getBasePath()));
			} catch (Exception e) {
				throw new InfoException(LanguageTraslator.traslate("211"), e);
			}
		}
		return fileSystemManager;
	}
}
