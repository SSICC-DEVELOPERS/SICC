package com.calipso.reportgenerator.services;

import org.apache.commons.vfs.FileSystemManager;

import es.indra.mare.common.mii.services.vfs.MareVFS;

import es.indra.mare.common.mii.services.MareServiceException;

import es.indra.mare.common.mii.helper.ServicesHelper;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;

/**
 * MareFileSystemResolver
 * Resuelve el FileSystem soportado por MARE
 */
public class MareFileSystemResolver extends FileSystemResolver {

	/**
	 * Servicio de MARE para menejar un file system
	 */
	private MareVFS mareVFS;

	/**
	 * MareFileSystemResolver
	 * Setea la configuracion general del sistema en la instancia de esta clase.
	 * @param reportGeneratorConfiguration
	 */
	public MareFileSystemResolver(ReportGeneratorConfiguration reportGeneratorConfiguration) {
		super(reportGeneratorConfiguration);
	}

	/**
	 * getFileSystemManager()
	 * Devuelve el manager de file system de MARE
	 * @return
	 * @throws MareMiiServiceNotFoundException
	 * @throws MareServiceException
	 */
	public FileSystemManager getFileSystemManager()
			throws MareMiiServiceNotFoundException, MareServiceException {
		if (mareVFS == null) {
			mareVFS = ServicesHelper.getVFSService();
		}
		return mareVFS.getManager();
	}

}
