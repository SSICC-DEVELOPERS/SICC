package com.calipso.reportgenerator.reportcalculator;
import com.calipso.reportgenerator.common.ReportFieldSpec;
import es.indra.mare.common.info.InfoException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExternalFunctionResolver 
{
  private static ExternalFunctionResolver instance;
  private HashMap instances;
  
  private HashMap getInstances(){
    if(instances==null){
      instances = new HashMap();
    }
    return instances;
  }
  
  private ExternalFunctionResolver(){
    
  }
  
  public static ExternalFunctionResolver getInstance(){
    if(instance == null){
      instance = new ExternalFunctionResolver();
    }
    return instance;
  }
  
  private IExternalUseCaseResolver getResolverClassInstance(String id) throws InfoException{
    if(getInstances().containsKey(id)){
      return (IExternalUseCaseResolver)getInstances().get(id);
    }else{
      try{
        IExternalUseCaseResolver instance = (IExternalUseCaseResolver)Class.forName(id).newInstance();
        getInstances().put(id, instance);
        return instance;
      }catch (Exception e){
        throw new InfoException(e);
      }
    }
  }
  
  public Object resolveValue(Map paramValues, String id, Collection params) throws Exception{
    String classId = id.substring(ReportFieldSpec.externalFunctionConstant.length() + 1, id.length() - 1); 
    return getResolverClassInstance(classId).getValue(paramValues, params);
  }
}