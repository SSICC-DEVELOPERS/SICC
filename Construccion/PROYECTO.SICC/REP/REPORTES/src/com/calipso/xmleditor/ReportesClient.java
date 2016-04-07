package com.calipso.xmleditor;

public class ReportesClient 
{
  public ReportesClient(String[] args)
  {
    XmlEditorUI ui = new XmlEditorUI("", args);
    ui.checkReport("EMPTY", "RD_REP-019");
    //ui.checkReport("OBLIGATORY_ONLY", "RD_REP-019");
    //ui.checkReport("ALL", "RD_REP-019");
  }
  
  public static void main(String[] args)
  {
    ReportesClient cl = new ReportesClient(args);
  }
  
}