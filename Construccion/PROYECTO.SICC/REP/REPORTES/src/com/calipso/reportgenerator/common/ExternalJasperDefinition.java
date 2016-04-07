package com.calipso.reportgenerator.common;

import dori.jasper.engine.design.JasperDesign;
import dori.jasper.engine.JRException;
import dori.jasper.engine.JasperManager;
import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.LanguageTraslator;

/**
 *
 */
public class ExternalJasperDefinition implements IJasperDefinition {
  private JasperDesign jasperDesign;
  public JasperDesign getJasperDefinition(boolean isLandscape) throws JRException {
    return jasperDesign;
  }

  public ExternalJasperDefinition(String externalDefinitionFile) throws InfoException {
    try {
    //  System.out.println("LayoutDesign_FileName:"+ externalDefinitionFile);      
      jasperDesign = JasperManager.loadXmlDesign(externalDefinitionFile);
    } catch (JRException e) {
      throw new InfoException(LanguageTraslator.traslate("257"));
    }
  }

}
