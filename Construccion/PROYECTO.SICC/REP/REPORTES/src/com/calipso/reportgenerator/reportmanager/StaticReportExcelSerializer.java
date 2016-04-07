package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.QueryDimension;
import com.calipso.reportgenerator.common.QueryMetric;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportMap;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.StaticReportResult;
import com.calipso.reportgenerator.reportcalculator.DataTree;
import com.calipso.reportgenerator.reportcalculator.DataTreeNode;
import com.calipso.reportgenerator.reportcalculator.DataTreeSubItem;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedFloat;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.SharedString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * Created by IntelliJ IDEA.
 * User: aaboudar
 * Date: 07/05/2005
 * Time: 12:13:08
 * To change this template use File | Settings | File Templates.
 */
public class StaticReportExcelSerializer {
    private StaticReportResult reportResult;
    private int metricsCount;


    public StaticReportExcelSerializer(ReportResult reportResult) {
        initilize(reportResult);
    }

    private void initilize(ReportResult reportResult) {
        this.reportResult = (StaticReportResult)reportResult;
        this.metricsCount = reportResult.getReportQuery().getMetrics().size();
        
    }

    public byte[] serialize(){
        int sum = 1;
        if (reportResult != null){
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("new sheet");
            fillFirstRow(sheet);
            Vector vec = getDataVector(reportResult.getDataTree());
            for (int i=0;i< vec.size();i++) {

                int index = 0;
                HSSFRow row = sheet.createRow((short)(sum));
                fillRow((Vector)vec.get(i),row,index);
                sum++;
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                wb.write(outputStream);
                return outputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return null;

    }

    private Vector getDataVector(DataTree dataTree) {
      Vector dataVector = new Vector();
      Vector previousValues = new Vector();
      fillFromNode(dataVector, dataTree.getRoot(), previousValues);
      return dataVector;
    }

    private void fillFromNode(Vector dataVector, DataTreeNode node, Vector previousValues) {
      if (node.getSubNodes().size() == 0) {
        Iterator iterator = node.getSubItems().iterator();
        while (iterator.hasNext()) {
          DataTreeSubItem subItem = (DataTreeSubItem) iterator.next();
          dataVector.add(getItemVector(previousValues, subItem));
        }
      }
      else {
        Iterator iterator = node.getSubNodes().values().iterator();
        while (iterator.hasNext()) {
          DataTreeNode subNode = (DataTreeNode) iterator.next();
          previousValues.add(subNode.getValue());
          fillFromNode(dataVector, subNode, previousValues);
          previousValues.remove(previousValues.size() - 1);
        }
      }
    }

    private Vector getItemVector(Vector previousValues, DataTreeSubItem subItem) {
      Vector itemVector = new Vector(previousValues);
      Object[] ngValues = subItem.getNonGroupingDimensionValues();
      for (int i = 0; i < ngValues.length; i++) {
        Object ngValue = ngValues[i];
        itemVector.add(ngValue);
      }

      SharedFloat[] metricValues = subItem.getMetricValues();
      for (int i = 0; i < metricValues.length; i++) {
        SharedFloat metricValue = metricValues[i];
        itemVector.add(new Float(metricValue.floatValue()));
      }


      SharedFloat[] accMetricValues = subItem.getAccumulableMetricValues();
      for (int i = 0; i < accMetricValues.length; i++) {
        SharedFloat accMetricValue = accMetricValues[i];
        itemVector.add(new Float(accMetricValue.floatValue()));
      }

      return itemVector;
    }

    private void fillRow(Vector vector, HSSFRow row, int index) {
        for (int i = 0;i < vector.size();i++){
            HSSFCell cell = row.createCell((short)index++);
            setCellValue(vector,i,cell);
        }
    }

    private void setCellValue(Vector vector, int i, HSSFCell cell) {
        ReportDimensionSpec spec = null;

        if (i < reportResult.getReportQuery().getDimensions().size()) {
            String dimName = ((QueryDimension)reportResult.getReportQuery().getDimensions().get(i)).getName();
            spec = reportResult.getReportSpec().getDimensionFromName(dimName);
        }

        Object o = vector.get(i);
        if (o instanceof SharedFloat){
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            if ( ((SharedFloat)o).getValue() !=null) {
            cell.setCellValue(((Float)ReportMap.setValueToSimpleType(((SharedFloat)o).getValue())).doubleValue());
            }
       } else if (o instanceof SharedDate){
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            if ( ((SharedDate)o).getValue() !=null) {
              cell.setCellValue(((Date)ReportMap.setValueToSimpleType(((SharedDate)o).getValue())));
            }
        } else if (o instanceof SharedString){
            if ( ((SharedString)o).getValue() !=null) {
//            cell.setCellValue(((String)ReportMap.setValueToSimpleType(((SharedString)o).getValue())));
              if ( spec != null) {
                    if (  !spec.getCalculated()  &&  !spec.getExpression().equalsIgnoreCase("")) {
                      cell.setCellValue(((SharedString)o).format(extractOutputFormatPatternFromExpression(spec.getExpression()),extractInputSeparatorFromExpression(spec.getExpression()),extractLanguageFromExpression(spec.getExpression())));
                    } else {
                      cell.setCellValue(((String)ReportMap.setValueToSimpleType(((SharedString)o).getValue())));
                    }
              } else {
                  cell.setCellValue(((String)ReportMap.setValueToSimpleType(((SharedString)o).getValue())));              
              }
            }
        } else if (o instanceof SharedInteger){
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            if ( ((SharedInteger)o).getValue() !=null) {
            cell.setCellValue(((Integer)ReportMap.setValueToSimpleType(((SharedInteger)o).getValue())).doubleValue());
            }
        } else {
            cell.setCellValue(o.toString());
        }


        //To change body of created methods use File | Settings | File Templates.
    }
    
    private String extractOutputFormatPatternFromExpression (String expression) {
      String s;
        s= expression.substring(0,expression.indexOf("|"));
        return s;
    }

    private String extractInputSeparatorFromExpression (String expression) {
      String s;
      int ini = expression.indexOf("|") + 1;
      s= expression.substring(ini,expression.indexOf("|",ini));
      return s;
    }

    private Long extractLanguageFromExpression (String expression) {
      Long l;
      int ini = expression.indexOf("|") + 1;
      int ini2 = expression.indexOf("|",ini) + 1;
      l = new Long (expression.substring(ini2));
      return l;
    }

    private void fillDimensionValues(DataTreeSubItem dataTreeSubItem, HSSFRow row, int index) {
        for (int i = 0;i < dataTreeSubItem.getNonGroupingDimensionValues().length;i++){
            row.createCell((short)index++).setCellValue((dataTreeSubItem.getNonGroupingDimensionValues()[i]).toString());
        }
    }

    private void fillFirstRow(HSSFSheet sheet) {
       HSSFRow row = sheet.createRow((short)0);
       int i = 0;

       Iterator rowDimensionsIterator = reportResult.getReportQuery().getDimensions().iterator();
       for(; rowDimensionsIterator.hasNext() ; i++) {
         QueryDimension queryDimension = (QueryDimension) rowDimensionsIterator.next();
         String caption = (reportResult.getReportSpec().getDimensionFromName(queryDimension.getName())).getCaption();
         row.createCell((short)i).setCellValue(caption);
       }

        Iterator metricsIterator = reportResult.getReportQuery().getMetrics().iterator();
        for(; metricsIterator.hasNext() ; i++) {
          QueryMetric queryMetric = (QueryMetric) metricsIterator.next();
          String caption = (reportResult.getReportSpec().getMetricFromName(queryMetric.getName())).getCaption();
          row.createCell((short)i).setCellValue(caption);
        }


/*       Iterator colDimensionsIterator = reportResult.getReportQuery().getColumnDimensions().iterator();
       for(; colDimensionsIterator.hasNext() ; i++) {
         QueryDimension queryDimension = (QueryDimension) colDimensionsIterator.next();
         String caption = (reportResult.getReportSpec().getDimensionFromName(queryDimension.getName())).getCaption();
         row.createCell((short)i).setCellValue(caption);
       }*/

   /*   for(int j = 0; j < metricsCount ; i++, j++) {
         Object [] elements = reportResult.getReportQuery().getMetrics().toArray();
         row.createCell((short)i).setCellValue(elements [elements.length - 1].toString());
       }*/
     }


}
