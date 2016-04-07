package com.calipso.reportgenerator.reportmanager;

import java.io.File;
import java.util.Vector;

/**
 * Representa un hilo que corre como demonio, y cada 10 segundos
 * verifica que el tamano del cache no supere el limite especificado
 * en el archivo de configuracion.
 * En caso que se dicho limite sea superado, elimina aquellos
 * archivos cuya fecha de modificacion es mas antigua.
 */

public class CacheLimitVerifier implements Runnable {

  private Thread cacheVerifier;
  private String cacheUrl;
  private long cacheSizeLimit;

  /**
   * Inicializa una instancia de <code>CacheLimitVerifier</code>
   * @param cacheUrl
   */
  public CacheLimitVerifier(String cacheUrl, String cacheSizeLimit) {
    this.cacheUrl = cacheUrl;
    this.cacheSizeLimit = (Long.valueOf(cacheSizeLimit)).longValue();
    cacheVerifier = new Thread(this);
    cacheVerifier.setDaemon(true);
    cacheVerifier.setPriority(Thread.MIN_PRIORITY);
  }

  /**
   * Devuelve el thread que verifica el cache
   * @return
   */
  public Thread getThread() {
    return cacheVerifier;
  }

  /**
   * Metodo que implementa de Runnable
   */
  public void run() {
    File file = new File(cacheUrl);
    while(true) {
      long repositorySize = getRepositorySize(file, 0);
      while(repositorySize > cacheSizeLimit) {
        Vector repositoryFiles = new Vector();
        fillVector(file, repositoryFiles);
        File oldestCachedFile = getOldestCachedFile(repositoryFiles);
        oldestCachedFile.delete();
        repositorySize = getRepositorySize(file, 0);
      }
      try {
        cacheVerifier.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Llena el vector correspondiente con todos los archivos
   * actuales del cache.
   * @param file
   * @param repositoryFiles
   */
  private void fillVector(File file, Vector repositoryFiles) {
    if(file.isFile()) {
      repositoryFiles.add(file);
      return;
    } else {
      File files [] = file.listFiles();
      for(int i = 0 ; i < files.length ; i++) {
        fillVector(files [i], repositoryFiles);
      }
    }
  }

  /**
   * Devuelve el archivo con mas antiguedad. Para ello
   * se fija en la ultima modificacion de cada archivo.
   * @param repositoryFiles
   * @return
   */
  private File getOldestCachedFile(Vector repositoryFiles) {
    if(repositoryFiles.size() > 0) {
      File comparisonValue = ((File)repositoryFiles.get(0));
      for(int i = 1 ; i < repositoryFiles.size() ; i++) {
        File current = (File)repositoryFiles.get(i);
        if(current.lastModified() < comparisonValue.lastModified()) {
          comparisonValue = current;
        }
      }
      return comparisonValue;
    }
    return null;
  }

  /**
   * Devuelve el tamano del repositorio actual en KB.
   * @param file
   * @param size
   * @return
   */
  private long getRepositorySize(File file, long size) {
    if(file.isFile()) {
      return file.length()/1024;
    } else {
      File files [] = file.listFiles();
      for(int i = 0 ; i < files.length ; i++) {
        size = size + getRepositorySize(files [i], size);
      }
    }
    return size;
  }
}
