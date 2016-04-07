package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import com.sun.star.sheet.XSpreadsheet;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.beans.PropertyValue;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.IndexOutOfBoundsException;
import com.sun.star.lang.WrappedTargetException;
import com.sun.star.container.XIndexAccess;
import com.sun.star.table.XCell;
import com.sun.star.text.XText;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportFilterBuilder;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.common.ReportSpec;
import java.util.List;
import java.util.ArrayList;

/**
 * Resuelve un data source desde la clanilla de cálculo de Open Office
 */

public class OOCalcReportDataSource extends ReportDataSource {

  private OOConnectionManager connectionManager;
  private IRDataSource dataSource;
  private int rowStart, columnStart, rowEnd, columnEnd;

  public OOCalcReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec dataSourceSpec, ReportGeneratorConfiguration managerConfiguration) {
    super(reportSpec, dataSourceSpec);
    super.setGeneratorConfiguration(managerConfiguration);
    connectionManager = new OOConnectionManager("uno:socket,host=223.255.255.147,port=8100;urp;StarOffice.ServiceManager");
  }

  private void loadFromOOCalc() throws InfoException {
    try {
      XSpreadsheetDocument xSpreadsheetDocument = loadFile();
      XSpreadsheet xSheet = getWorkingSheet(xSpreadsheetDocument);
      setEndPoint(xSheet);
      fillDataSource(xSheet);
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("275"),e);
    }
  }

  private void fillDataSource(XSpreadsheet xSheet) throws IndexOutOfBoundsException, InfoException {
    XCell xCell;
    try {
      for(int i = rowStart ; i < rowEnd ; i++) {
        List row = new ArrayList();
        for( int j = columnStart ; j < columnEnd ; j++) {
          xCell = xSheet.getCellByPosition(j, i);
          XText xCellText = (XText) UnoRuntime.queryInterface(XText.class, xCell);
          row.add(xCellText.getString());
        }
        getDataSource().addRow(row);
      }
    } catch(OutOfMemoryError e) {
      throw new InfoException(LanguageTraslator.traslate("326"), e);
    }
  }

  private XSpreadsheet getWorkingSheet(XSpreadsheetDocument xSpreadsheetDocument) throws IndexOutOfBoundsException, WrappedTargetException {
    XSpreadsheets xSheets = xSpreadsheetDocument.getSheets();
    XIndexAccess xSIndexAccess = (XIndexAccess) UnoRuntime.queryInterface(XIndexAccess.class, xSheets);
    return (XSpreadsheet) xSIndexAccess.getByIndex(0);
  }

  private void setEndPoint(XSpreadsheet xSheet) throws IndexOutOfBoundsException {
    rowEnd = getEndCoordinate(xSheet, rowStart, columnStart, true);
    columnEnd = getEndCoordinate(xSheet, columnStart, rowStart, false);
  }

  private int getEndCoordinate(XSpreadsheet xSheet, int num1, int num2, boolean row) throws IndexOutOfBoundsException {
    int point = 0;
    for(int i = num1 ; ; i++) {
      for(int j = num2 ; ; j++) {
        XCell xCell;
        XText xCellText;
        if(row) {
          xCell = xSheet.getCellByPosition(i, j);
          xCellText = (XText) UnoRuntime.queryInterface(XText.class, xCell);
        } else {
          xCell = xSheet.getCellByPosition(j, i);
          xCellText = (XText) UnoRuntime.queryInterface(XText.class, xCell);
        }
        if(xCellText.getString().equals("")) {
          point = j;
          break;
        }
      }
      break;
    }
    return point;
  }


  private XSpreadsheetDocument loadFile() throws InfoException {
    try {
      Object desktop = connectionManager.getConnection().getServiceManager().createInstanceWithContext(
        "com.sun.star.frame.Desktop", connectionManager.getConnection());
      XComponentLoader xComponentLoader = (XComponentLoader) UnoRuntime.queryInterface(
        XComponentLoader.class, desktop);
      PropertyValue [] loadProps = new PropertyValue[1];
      loadProps[0] = new PropertyValue();
      loadProps[0].Name = "Hidden";
      loadProps[0].Value = new Boolean(true);
      XComponent xComponent = xComponentLoader.loadComponentFromURL("file:///C:/Projects/Indra/Deve/Java/src/sourcefiles/datasources/VENTAS_CLIENTES.sxc","_blank", 0, loadProps);
      XSpreadsheetDocument spreadsheetDocument = (XSpreadsheetDocument) UnoRuntime.queryInterface(
        XSpreadsheetDocument.class, xComponent);
      return spreadsheetDocument;
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("274"),e);
    }
  }

  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = newDataSource();
      loadFromOOCalc();
      }
    return dataSource;
  }

  public int getFilterVarMode() {
    return ReportFilterBuilder.VARMODE_DATAINDEX;
  }
}
