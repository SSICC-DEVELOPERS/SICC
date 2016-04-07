package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;

import java.util.HashMap;

import com.calipso.reportgenerator.common.LanguageTraslator;

/**
 * Esta clase se encarga de cachear los repositorios
 */
public class CacheRepository {
  private HashMap cache;
  private String repositoryName;

  /**
   * Inicializa y asigna un nombre al repositorio
   * @param name
   */
  public CacheRepository(String name) {
    this.repositoryName = name;
  }

  /**
   * Devuelve el cache
   * @return
   */
  public HashMap getCache() {
    if (cache == null) {
      cache = new HashMap();
    }
    return cache;
  }

  /**
   * Indica si existe un objeto cacheado con el nombre indicado
   * @param name
   * @return
   */
  public boolean containsObject(String name) {
    return getCache().containsKey(name.toUpperCase());
  }

  /**
   * Indica si existe cacheado el objeto indicado
   * @param object
   * @return
   */
  public boolean containsObject(Object object) {
    return getCache().containsValue(object);
  }

  /**
   * Agrega al repositorio de objectos cacheados el objeto indicado
   * @param name Nombre del objeto
   * @param object Objeto a cachear
   */
  public void addObject(String name, Object object) {
    if (!containsObject(name)) {
    //  System.out.println(repositoryName + ":Objeto agregado:" + name);
      getCache().put(name, object);
    }
  }

  /**
   * Remueve el objeto del cache
   * @param name Nombre del objeto
   * @throws InfoException
   */
  public void removeObject(String name) throws InfoException {
    if (name.equalsIgnoreCase("")) {
      throw new InfoException(LanguageTraslator.traslate("72"));
    }
    else {
      if (getCache().remove(name) == null) {
        throw new InfoException(LanguageTraslator.traslate("73") + name);
      }
    }
  }

  /**
   * Devuelve el objeto con el nombre indicado
   * @param name
   * @return
   * @throws InfoException
   */
  public Object getObject(String name) throws InfoException {
    Object returnObject = null;
    if (name.equalsIgnoreCase("")) {
      throw new InfoException(LanguageTraslator.traslate("74"));
    }
    else {
      returnObject = getCache().get(name);
    //  System.out.println(repositoryName + ":Objeto recuperado:" + name);
      if (returnObject == null) {
        throw new InfoException(LanguageTraslator.traslate("75") + name);
      }
      else {
        return returnObject;
      }
    }
  }

  /**
   * Borra el cache
   */
  public void deleteAll(){
    getCache().clear();
  }

  /**
   * Elimina del cache el objeto indicado
   * @param name
   */
  public void delete(String name){
    getCache().remove(name);
  }

}
