package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;
import java.io.StringWriter;

/**
 * Interface para los distintos writers de xml
 */
public abstract interface ReportXmlWriter {
  public abstract StringWriter getXml() throws InfoException;
}
