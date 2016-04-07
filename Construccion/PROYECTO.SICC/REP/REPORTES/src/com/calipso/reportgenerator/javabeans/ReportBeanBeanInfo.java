package com.calipso.reportgenerator.javabeans;

import java.beans.SimpleBeanInfo;
import java.beans.BeanDescriptor;

/**
 * BeanInfo del JavaBean de la aplicacion
 */

public class ReportBeanBeanInfo extends SimpleBeanInfo {

  private final static Class beanClass = ReportBean.class;

  /*public BeanDescriptor getBeanDescriptor() {
      return new
      BeanDescriptor(ReportBean.class, ReportBeanCustomizer.class);
  }*/

  /**
   * Retorna la descripcion del Customizer para el JavaBean
   * @return
   */
  public BeanDescriptor getBeanDescriptor() {
    return new
      BeanDescriptor(ReportBean.class, ReportBeanCustomizer.class);
  }
}