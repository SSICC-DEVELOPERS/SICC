package com.calipso.reportgenerator.common;

import dori.jasper.engine.design.JasperDesign;
import dori.jasper.engine.JRException;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Feb 5, 2004
 * Time: 4:55:16 PM
 * To change this template use Options | File Templates.
 */

public interface IJasperDefinition {

  public JasperDesign getJasperDefinition(boolean isLandscape) throws JRException;

}
