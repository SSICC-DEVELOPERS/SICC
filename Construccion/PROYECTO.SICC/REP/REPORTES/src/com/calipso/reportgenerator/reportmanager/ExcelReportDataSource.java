package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Enumeration;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportFilterBuilder;
import com.calipso.reportgenerator.common.ReportDataSourceSpec;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
import com.calipso.common.DateEx;

/**
 * Representa un origen de datos Excel
 */

public class ExcelReportDataSource extends ReportDataSource {

  private static final int STRING = 1;
  private static final int NUMERIC = 0;
  private IRDataSource dataSource;
  private org.apache.poi.poifs.filesystem.POIFSFileSystem fileSystem;
  private int dimensionsCount;
  private String sheetName;
  private String dataInitialCell;
  private String dataEndingCell;
  private ExcelSheetPosition initialPosition;
  private ExcelSheetPosition endingPosition;

  /**
   * Inicializa una instancia de <code>ExcelReportDataSource</code>
   * @param reportSpec
   * @param reportDataSourceSpec
   */
  public ExcelReportDataSource(ReportSpec reportSpec, ReportDataSourceSpec reportDataSourceSpec) {
    super(reportSpec, reportDataSourceSpec);
    dimensionsCount = reportSpec.getNotCalculatedDimensions().size();
    File file = new File(reportDataSourceSpec.getExpression());
    sheetName = reportDataSourceSpec.getSheetName();
    dataEndingCell = reportDataSourceSpec.getDataEndingCell();
    dataInitialCell = reportDataSourceSpec.getDataInitialCell();
    try {
      InputStream inputStream = new FileInputStream(file);
      fileSystem = new org.apache.poi.poifs.filesystem.POIFSFileSystem(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public IRDataSource getDataSource() throws InfoException {
    if (dataSource == null) {
      dataSource = newDataSource();
      fillFromFile();
    }
    return dataSource;
  }

  private void fillFromFile() throws InfoException{
    try {
      HSSFWorkbook wb = new HSSFWorkbook(fileSystem);
      HSSFSheet sheet;
      if(sheetName!=null && !sheetName.equalsIgnoreCase("")){
        sheet = wb.getSheet(sheetName);
      }else{
        sheet = wb.getSheetAt(0);
      }
      createInitialPositions(sheet);
      //for(int i = sheet.getFirstRowNum() ; i <= sheet.getLastRowNum() ; i++) {
      for(int i = initialPosition.getRow() ; i <= endingPosition.getRow() ; i++) {
        List dataSourceRow = new ArrayList();
        fillDataSourceRowFrom(getItemVector(sheet.getRow(i)), dataSourceRow);
        try {
          if ((getFilter()== null)||((getFilter()!= null) && (getFilter().matches(dataSourceRow.toArray())))) {
            dataSource.addRow(dataSourceRow);
          }
        } catch (InfoException e) {
          throw new InfoException(LanguageTraslator.traslate("386"), e);
        }
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("316"),e);
    } catch(OutOfMemoryError e) {
      throw new InfoException(LanguageTraslator.traslate("326"), e);
    }
  }

  private void createInitialPositions(HSSFSheet sheet) throws InfoException {
    if(dataInitialCell==null || dataInitialCell.equalsIgnoreCase("")){
      int initialRow = sheet.getFirstRowNum();
      short initialColumn = sheet.getRow(initialRow).getFirstCellNum();
      initialPosition = new ExcelSheetPosition(initialRow, initialColumn);
    }else{
      initialPosition = new ExcelSheetPosition(getDataInitialCell());
      initialPosition.setRow(initialPosition.getRow()-1);
    }
    if(dataEndingCell==null || dataEndingCell.equalsIgnoreCase("")){
      int finalRow = sheet.getLastRowNum();
      short finalColumn = (short)(sheet.getRow(finalRow).getLastCellNum()-1);
      endingPosition = new ExcelSheetPosition(finalRow, finalColumn);
    }else{
      endingPosition = new ExcelSheetPosition(getDataEndingCell());
      endingPosition.setRow(endingPosition.getRow()-1);      
    }
  }

  private String getDataEndingCell() {
    return dataEndingCell;
  }

  private String getDataInitialCell() {
    return dataInitialCell;
  }

  private void fillDataSourceRowFrom(Vector itemVector, List dataSourceRow) throws InfoException{
    int i = 0;
    //int size = getReportSpec().getDataSourceIndexes().size();
    int dimensionSize = getReportSpec().getNotCalculatedDimensions().size();
    for(Enumeration enumeration = itemVector.elements() ; enumeration.hasMoreElements() ; i++) {
      Object object = enumeration.nextElement();
      if(i < dimensionSize) {
        String name = getReportSpec().getDataSourceIndexNameByIndex(i);
        ReportDimensionSpec dimensionSpec = getReportSpec().getDimensionFromName(name);
        //ReportDimensionSpec dimensionSpec = (ReportDimensionSpec)getReportSpec().getDimensionsByIndex().get(i);
        if(object instanceof String) {
          fillDataSourceItemFrom((String)object, dataSourceRow, dimensionSpec, i);
        } else if(object instanceof Double){
          fillDataSourceItemFrom((Double)object, dataSourceRow, dimensionSpec, i);
        } else if(object instanceof Integer){
          fillDataSourceItemFrom((Integer)object, dataSourceRow, dimensionSpec, i);
        }

      } else {
        dataSourceRow.add(object.toString());
      }
    }
  }

  private void fillDataSourceItemFrom(Number value, List dataSourceRow, ReportDimensionSpec dimensionSpec, int index) throws InfoException{
    switch(dimensionSpec.getDataType().getType()){
      case ReportDataType.DATETIME_TYPE:
      case ReportDataType.DATE_TYPE:
        dataSourceRow.add(index, SharedDate.newFrom(new DateEx(value, getReportDataSourceSpec().getPattern(dimensionSpec.getDataType().getType()))));
        //DecimalFormat numberFormat = new DecimalFormat("########");
        //Format numberFormat = new DecimalFormat("#####################");
        //dataSourceRow.add(index, SharedDate.newFrom(new DateEx(numberFormat.format(value), getReportDataSourceSpec().getPattern(dimensionSpec.getDataType().getType()))));
        break;
      case ReportDataType.STRING_TYPE:
        dataSourceRow.add(index, SharedString.newFrom(value.toString()));
        break;
      case ReportDataType.FLOAT_TYPE:
        dataSourceRow.add(index, SharedFloat.newFrom(new Float(value.floatValue())));
        break;
      case ReportDataType.INTEGER_TYPE:
        dataSourceRow.add(index, SharedInteger.newFrom(new Integer(value.intValue())));
        break;
      case ReportDataType.BOOLEAN_TYPE:
        throw new InfoException("374");
    }
  }




  private void fillDataSourceItemFrom(String strValue, List dataSourceRow, ReportDimensionSpec dimensionSpec, int index) throws InfoException{
    switch(dimensionSpec.getDataType().getType()){
      case ReportDataType.DATETIME_TYPE:
        dataSourceRow.add(index, SharedDate.newFrom(new DateEx(strValue, getReportDataSourceSpec().getDateTimePattern())));
        break;
      case ReportDataType.DATE_TYPE:
        dataSourceRow.add(index, SharedDate.newFrom(new DateEx(strValue, getReportDataSourceSpec().getDatePattern())));
        break;
      case ReportDataType.STRING_TYPE:
        dataSourceRow.add(index, SharedString.newFrom(strValue));
        break;
      case ReportDataType.FLOAT_TYPE:
        dataSourceRow.add(index, SharedFloat.newFrom(new Float(strValue)));
        break;
      case ReportDataType.INTEGER_TYPE:
        dataSourceRow.add(index, SharedInteger.newFrom(new Integer(strValue)));
        break;
      case ReportDataType.BOOLEAN_TYPE:
        dataSourceRow.add(index, Boolean.valueOf(strValue));
        break;
    }
  }

  private Vector getItemVector(HSSFRow row) {
    Vector itemVector = new Vector();
    //for(int i = row.getFirstCellNum() ; i < row.getLastCellNum() ; i++) {
    for(int i = initialPosition.getColumn() ; i <= endingPosition.getColumn() ; i++) {
      HSSFCell cell = row.getCell((short)i);
      if (cell != null) {
        switch(cell.getCellType()) {
          case STRING:
            itemVector.add(cell.getStringCellValue());
            break;
          case NUMERIC:
            Double aDouble = new Double(cell.getNumericCellValue());
            if ( aDouble.doubleValue() == aDouble.intValue()) {
              itemVector.add(new Integer(aDouble.intValue()));
            } else {
              itemVector.add(aDouble);
            }
            break;
        }
      }else{
        itemVector.add("");
      }
    }
    return itemVector;
  }

  public int getFilterVarMode() {
    return ReportFilterBuilder.VARMODE_DATAINDEX;
  }
}
