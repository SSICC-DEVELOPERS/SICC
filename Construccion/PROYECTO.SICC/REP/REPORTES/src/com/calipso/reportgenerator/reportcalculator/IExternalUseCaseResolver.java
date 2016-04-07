package com.calipso.reportgenerator.reportcalculator;

import java.util.Collection;
import java.util.Map;

public interface IExternalUseCaseResolver 
{
  public Object getValue(Map paramValues, Collection rowValues) throws Exception;
}