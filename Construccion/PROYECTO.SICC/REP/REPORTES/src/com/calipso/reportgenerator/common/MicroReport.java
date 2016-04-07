package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.Matrix;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;

import com.sun.org.apache.xml.internal.serializer.WriterToUTF8;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.Map;
import java.util.HashMap;
import org.xml.sax.InputSource;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.MarshalException;
import es.indra.mare.common.info.InfoException;

/**
 * Representa un reporte completo con sus datos incluidos. Utilizado normalmente para enportar un informe y dejarlo conjelado para su posteriri a´nalisis off line o en otro momento
 */
public class MicroReport implements Serializable {
  private Matrix matrix;
  private ReportSourceDefinition reportSourceDefinition;
  private ReportDefinition reportDefinition;
  private ReportView  reportView;
  private String name;
  private Map views;
  private String userName;
  private Map definitionsInfo;
  private Map configuration;


  public MicroReport(Matrix matrix, ReportSourceDefinition reportSourceDefinition, ReportDefinition reportDefinition, ReportView reportView, String name, String userName, Map views) {
    this.matrix = matrix;
    this.reportSourceDefinition = reportSourceDefinition;
    this.reportDefinition = reportDefinition;
    this.reportView = reportView;
    this.name = name;
    this.userName = userName;
    this.views = views;
  }


  /**
   * Lista de vistas
   * @return
   */
  public Map getViews() {
    if (views == null){
      views = new HashMap();
    }
    return views;
  }

  /**
   * retorna un Zip con el micro report
   * @param outFileName
   * @return
   * @throws es.indra.mare.common.info.InfoException
   */
  public ZipOutputStream getZip(String outFileName) throws InfoException {
    try {
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFileName));
      configuration = null;
      addObjectToZip(1,out, matrix,reportDefinition.getId()+"_Matrix","Matrix");
      addObjectToZip(2,out, reportSourceDefinition,reportDefinition.getId()+"_ReportSourceDefinition","ReportSourceDefinition");
      addObjectToZip(2,out, reportDefinition,reportDefinition.getId()+"_ReportDefinition","ReportDefinition");
      addObjectToZip(2,out, reportView,reportDefinition.getId()+"_ReportView","ReportView");
      for (int i=0;i<getViews().size();i++ ){
        addObjectToZip(2,out, getViews().values().toArray()[i],reportDefinition.getId()+"_ReportView"+i,"ReportView"+i);
      }
      addObjectToZip(1,out,getConfiguration(),"description","description");
      return out;
    }
    catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("266"),e);
    }
  }

  /**
   * Agrega el objeto al zip
   * @param serializerType  1- serializado, 2- XML
   * @param zipOutputStream
   * @param o Objeto a aagregar
   * @param name
   * @throws org.exolab.castor.xml.ValidationException
   * @throws org.exolab.castor.xml.MarshalException
   * @throws java.io.IOException
   */
  protected void addObjectToZip(int serializerType, ZipOutputStream zipOutputStream,Object o,String name, String typeName) throws ValidationException, MarshalException, IOException {
    ByteArrayInputStream in=null;
    ObjectOutputStream oos;
    int len;
    byte[] buf = new byte[1024];

    if (serializerType == 1){
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      oos = new ObjectOutputStream(outputStream);
      oos.writeObject(o);
      in = new ByteArrayInputStream(outputStream.toByteArray());
    }
    else if (serializerType== 2){
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

      Writer writer = new WriterToUTF8(outputStream);
      Marshaller.marshal(o, writer);
      in = new ByteArrayInputStream(((WriterToUTF8)writer).getOutputStream().toString().getBytes());
    }
    zipOutputStream.putNextEntry(new ZipEntry(name));
    while ((len = in.read(buf)) > 0) {
      zipOutputStream.write(buf, 0, len);
    }
    getConfiguration().put(typeName,name);
    zipOutputStream.closeEntry();
    in.close();
  }

  /**
   * Inicializa un Micro report desde un zip
   * @param microReportFileName
   * @param reportGeneratorConfiguration
   * @throws es.indra.mare.common.info.InfoException
   */
  public MicroReport(String microReportFileName, ReportGeneratorConfiguration reportGeneratorConfiguration) throws InfoException {
    try {
      java.util.zip.ZipFile zipFile = new ZipFile(microReportFileName); //todo:revisar pasar file
      InputStream inputStream = zipFile.getInputStream(zipFile.getEntry("description"));
      ObjectInputStream ois;
      ois = new ObjectInputStream(inputStream);
      configuration = (HashMap)ois.readObject();
      matrix = (Matrix) loadSerializedObject(zipFile,"Matrix");
      reportSourceDefinition = (ReportSourceDefinition)loadSerializedXmlObject(zipFile,"ReportSourceDefinition",ReportSourceDefinition.class);
      reportDefinition = (ReportDefinition)loadSerializedXmlObject(zipFile,"ReportDefinition",ReportDefinition.class);
      reportView = (ReportView)loadSerializedXmlObject(zipFile,"ReportView",ReportView.class);
      loadReportViews(zipFile);
    }catch(Exception e){
      throw new InfoException(LanguageTraslator.traslate("265"),e);
    }
  }

  private Object loadSerializedObject(ZipFile zipFile, String name) throws IOException, ClassNotFoundException {
    InputStream inputStream;
    if (getConfiguration().containsKey(name)){
      ZipEntry  zipEntry = zipFile.getEntry(getConfiguration().get(name).toString());
      inputStream = zipFile.getInputStream(zipEntry);
      ObjectInputStream ois = new ObjectInputStream(inputStream);
      return ois.readObject();
    }
    return null;
  }

  private Object loadSerializedXmlObject(ZipFile zipFile,String name,Class classLoad) throws IOException, MarshalException, ValidationException {
    InputStream inputStream;
    InputSource inputSource;
    if (getConfiguration().containsKey(name)){
      ZipEntry  zipEntry = zipFile.getEntry(getConfiguration().get(name).toString());
      inputStream = zipFile.getInputStream(zipEntry);
      inputSource = new InputSource(inputStream);
      return Unmarshaller.unmarshal(classLoad, inputSource);
    }
    return null;
  }

  private void loadReportViews(ZipFile zipFile) throws IOException, MarshalException, ValidationException {
    int count=0;
    boolean eol = false;
    String viewName;
    Object addicReportView;

    while (!eol){
      viewName = "ReportView"+count;
      addicReportView = loadSerializedXmlObject(zipFile,viewName,ReportView.class);
      if (addicReportView !=null){
        getViews().put(((ReportView)addicReportView).getId(),addicReportView);
      }
      eol = !getConfiguration().containsKey(viewName);
      count = count + 1;
    }
  }


  public Matrix getMatrix() {
    return matrix;
  }

  public ReportSourceDefinition getReportSourceDefinition() {
    return reportSourceDefinition;
  }

  public ReportDefinition getReportDefinition() {
    return reportDefinition;
  }

  public ReportView getReportView() {
    return reportView;
  }

  public String getName() {
    return name;
  }

  public Map getDefinitionsInfo() {
    if (definitionsInfo == null){
      definitionsInfo = new HashMap();
      ReportView reportView;
      DefinitionInfo definitionInfo;
      for (int i = 0;i<getViews().size();i++){
        reportView = (ReportView)getViews().values().toArray()[i];
        definitionInfo = new DefinitionInfo();
        definitionInfo.setId(reportView.getId());
        definitionInfo.setDescription(reportView.getDescription());
        definitionsInfo.put(reportView.getId(),definitionInfo);
      }
    }
    return definitionsInfo;
  }

  public Map getConfiguration() {
    if (configuration == null){
      configuration= new HashMap();
    }
    return configuration;
  }
}
