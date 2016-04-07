package com.calipso.reportgenerator.common;

import java.io.Serializable;

/**
 * Esta clase se utiliza describir una definicion.
 * Por ejemplo cuando se pide la lista de deportes disponible se devuelve un map con key 0 id de definición y value un objeto DefinitionInfo con el mismo id y la descripcion de la definición
 */
public class DefinitionInfo implements Serializable{
  private String id;
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String toString(){
    return getDescription();
  }

  public DefinitionInfo(String id, String description) {
    this.id = id;
    this.description = description;
  }

  public DefinitionInfo() {
  }
}
