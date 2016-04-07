package com.calipso.reportgenerator.reportcalculator;
import es.indra.mare.common.dto.MareDTO;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMONResolver implements IExternalUseCaseResolver{

  private HashMap cache;
  
  public Object getValue(Map paramValues, Collection row) throws Exception{
    MareDTO dto = getDTO(paramValues, row);
    //if(!getCache().containsKey(dto)){
      Object value = getValue(paramValues, dto);
      //getCache().put(dto, value);
      return value; //sacar
    //}
    //return getCache().get(dto);
  }
  
  private HashMap getCache(){
    if(cache==null){
      cache = new HashMap();
    }
    return cache;
  }
  
  protected abstract Object getValue(Map paramValues, MareDTO dto) throws Exception;
  
  protected abstract MareDTO getDTO(Map paramValues, Collection row);

}