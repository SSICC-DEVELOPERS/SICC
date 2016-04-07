package com.calipso.reportgenerator.reportmanager;

/**
 * Resuelce la conexion con el Open Office
 */

import com.sun.star.uno.XComponentContext;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.bridge.XUnoUrlResolver;
import com.sun.star.beans.XPropertySet;
import com.calipso.reportgenerator.common.LanguageTraslator;
import es.indra.mare.common.info.InfoException;

public class OOConnectionManager {

  private XComponentContext xRemoteContext;
  private String unoUrl;

  public OOConnectionManager(String unoUrl) {
    this.unoUrl = unoUrl;
    xRemoteContext = null;
  }

  public XComponentContext getConnection() throws InfoException {
    if(xRemoteContext == null) {
      try {
        XComponentContext xLocalContext = Bootstrap.createInitialComponentContext(null);
        XMultiComponentFactory xLocalServiceManager = xLocalContext.getServiceManager();
        Object urlResolver = xLocalServiceManager.createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", xLocalContext);
        XUnoUrlResolver xUnoUrlResolver = (XUnoUrlResolver) UnoRuntime.queryInterface(XUnoUrlResolver.class, urlResolver);

        Object initialObject = xUnoUrlResolver.resolve(unoUrl);
        XPropertySet xPropertySet = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, initialObject);
        Object context = xPropertySet.getPropertyValue("DefaultContext");
        xRemoteContext = (XComponentContext) UnoRuntime.queryInterface(XComponentContext.class, context);
      } catch (Exception e) {
        throw new InfoException(LanguageTraslator.traslate("273"),e);
      }
    }
    return xRemoteContext;
  }
}
