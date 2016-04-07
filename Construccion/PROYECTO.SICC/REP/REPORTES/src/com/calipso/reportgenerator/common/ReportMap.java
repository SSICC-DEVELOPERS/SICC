package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.common.DateEx;

import java.util.Map;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Breto
 * Date: 20-abr-2004
 * Time: 15:03:57
 * To change this template use File | Settings | File Templates.
 */
public class ReportMap {

  public static Map setParametersToSimpleType(Map params){
    Iterator iterator = params.entrySet().iterator();
    Object value;
    Object newValue = null;
    while(iterator.hasNext()){
      Map.Entry current = (Map.Entry)iterator.next();
      value = current.getValue();
      if(value!=null){
        newValue = setValueToSimpleType(value);
        current.setValue(newValue);
      }
    }
    return params;
  }

  public static Object setValueToSimpleType(Object value){
    Object newValue = value;
    if(value.getClass()==SharedInteger.class){
      newValue = ((SharedInteger)value).getValue();
    } else if(value.getClass()==SharedDate.class){
      newValue = ((SharedDate)value).getValue();
      if(newValue!=null){
        newValue = ((DateEx)newValue).getDate();
      }
    } else if(value.getClass()==SharedString.class){
      newValue = ((SharedString)value).getValue();
    } else if(value.getClass()==SharedFloat.class){
      newValue = ((SharedFloat)value).getValue();
    } else if(value.getClass()==DateEx.class){
      newValue = ((DateEx)value).getDate();
    } else {
      newValue = value;
    }
    return newValue;
  }

}
