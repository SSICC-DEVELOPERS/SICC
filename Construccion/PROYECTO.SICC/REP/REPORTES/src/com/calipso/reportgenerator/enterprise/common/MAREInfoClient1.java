package com.calipso.reportgenerator.enterprise.common;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import com.calipso.reportgenerator.enterprise.common.MAREInfo;
import com.calipso.reportgenerator.enterprise.common.MAREInfoHome;
import javax.naming.NamingException;

public class MAREInfoClient1 
{
  Hashtable env;
  Context context;
  
  private void addParam(HashMap param)
  {
      param.put(ConstantesREP.MODULO,"MOD");      
      param.put(ConstantesREP.USUARIO, "USUARIO2");
      param.put(ConstantesREP.PAIS, new Long(1));
      param.put(ConstantesREP.DESCPAIS,"PERU");
      param.put(ConstantesREP.FORMATOFECHA, "dd/MM/yyyy");
      param.put(ConstantesREP.SEPARADORDECIMALES, ".");
      param.put(ConstantesREP.TITULO, "Título");
      param.put(ConstantesREP.IDIOMA, new Long(1));      
      param.put(ConstantesREP.CRITERIOSDESC, "criterios de seleccion");

  }


  public void grabar(DTOReporte dtoS, boolean excel) throws Exception
  {
    if (dtoS!=null){
        FileOutputStream file;
        if (!excel){
          file = new FileOutputStream(dtoS.getNombreResultados()+".pdf");
        }else{
          file = new FileOutputStream(dtoS.getNombreResultados()+".xls");
        }
        file.write(dtoS.getResultados());
    //  System.out.println(dtoS.getResultados());
    //  System.out.println(dtoS.getNombreResultados());
    }
  }

  public MAREInfo getMareInfo() throws Exception
  {
      Context context = getInitialContext();
      MAREInfoHome mAREInfoHome = (MAREInfoHome)PortableRemoteObject.narrow(context.lookup("MAREInfo"), MAREInfoHome.class);

      return mAREInfoHome.create();
//            return null;
  }
  
  public DTOReporte ejecutar037(String repId) throws Exception
  {
     iniciandoEjecucion(repId);

      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
  
   
  
   public DTOReporte ejecutar001(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

  public DTOReporte ejecutar026(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }


  public DTOReporte ejecutar027(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);      
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

  public DTOReporte ejecutar028(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */

      //param.put(ConstantesREP.IDIOMA, new Long(1));
      /*param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
      param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.NOMBRE2, "%N%");                  */

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

  public DTOReporte ejecutar029(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

 

  public DTOReporte ejecutar154(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

  public DTOReporte ejecutar155(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }


  public DTOReporte ejecutar155Resumen(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
  
   public DTOReporte ejecutar156(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
  
    public DTOReporte ejecutar038(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
  
  public DTOReporte ejecutar039(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);      
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
  public DTOReporte ejecutar040(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
  
  public DTOReporte ejecutar041(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
  
  public DTOReporte ejecutar001_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
  
  public DTOReporte ejecutar001_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
 

  public DTOReporte ejecutar001_03(String repId) throws Exception
  {
     iniciandoEjecucion(repId);
     MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar002(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar003(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
/*      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
        param.put(ConstantesREP.GRUPOZONAS,"2");*/

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

  public DTOReporte ejecutar004(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "41");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.GRUPOFACTURACION,"1");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  



public DTOReporte ejecutar005(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.GRUPOFACTURACION, "2");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar006(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar007(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


  public DTOReporte ejecutar008_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      dto.getParametros().put(ConstantesREP.FORMATOSALIDA,"EXCEL");            
      dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,true);      
      return dto;
    
  }  

  public DTOReporte ejecutar008_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      dto.getParametros().put(ConstantesREP.FORMATOSALIDA,"EXCEL");            
      dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,true);            
      return dto;
    
  }  
public DTOReporte ejecutar110(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar042_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
      param.put(ConstantesREP.MARCA, "1");      
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      param.put(ConstantesREP.OPERADORPRECIOCATALOGO,"'>='");
      param.put(ConstantesREP.PRECIOCATALOGO,new Float(20));
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

  public DTOReporte ejecutar042_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar043(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      //param.put(ConstantesREP.NUMEROLINEADESDE, new Integer(1));
      param.put(ConstantesREP.NUMEROLINEAHASTA, new Integer(11231212));


      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar045(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "61");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar046_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
    /*  param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");*/

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar046_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar046_03(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar046_04(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  



public DTOReporte ejecutar046_01_D(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar046_02_D(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar046_03_D(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar046_04_D(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar033(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1209");
    
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar034(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
public DTOReporte ejecutar035(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar010(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
		  param.put(ConstantesREP.ZONA, "1");      
		  param.put(ConstantesREP.CURSO, "1042");            
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar011(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "1379");      
      param.put(ConstantesREP.PERIODOHASTA, "71");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
		  param.put(ConstantesREP.ZONA, "1");      
		  param.put(ConstantesREP.CURSO, "1042");            
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar011_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "1379");      
      param.put(ConstantesREP.PERIODOHASTA, "71");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
		  param.put(ConstantesREP.ZONA, "1");      
		  param.put(ConstantesREP.CURSO, "1042");            
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar036(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      */
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar031_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar031_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar030(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar032(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar012(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar092(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar091_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar091_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
public DTOReporte ejecutar091_03(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
public DTOReporte ejecutar091_04(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar091_05(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar013(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar015(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar084(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.FECHAINICIO,"01/01/2000");
      param.put(ConstantesREP.FECHAFIN,"01/01/2030");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar084_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar014_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar014_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
      param.put(ConstantesREP.MARCA, "1");      
      param.put(ConstantesREP.PAIS, "1");            
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar090(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.AGENTE,"2");
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar047_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar047_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar047_ALT_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar047_ALT_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO,] "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar047_REEM_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar047_REEM_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar085(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
    param.put(ConstantesREP.FECHAINICIO, "20001209");
    param.put(ConstantesREP.FECHAFIN, "20151209");
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar086_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar086_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar087(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
    param.put(ConstantesREP.FECHAINICIO, "20001209");
    param.put(ConstantesREP.FECHAFIN, "20151209");
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar088(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar089_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
public DTOReporte ejecutar089_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar018(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar017(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar019(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar020(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

public DTOReporte ejecutar021(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "20041209");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

    public DTOReporte ejecutar022(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "01/01/2004");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

    public DTOReporte ejecutar023(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

    public DTOReporte ejecutar024(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

    public DTOReporte ejecutar025(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }
    public DTOReporte ejecutar026PED(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

public DTOReporte ejecutar095(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "20041209");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar093_01(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
      
/*      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "20041209");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");*/
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO( dto ,mAREInfo);
      grabar(dtoS,true);
      return dto;
    
  }

    public DTOReporte ejecutar093_02(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();
          param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

          param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "20041209");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO( dto,mAREInfo );
          grabar(dtoS,false);
          return dto;

      }
    public DTOReporte ejecutar093_03(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();
          param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }




    public DTOReporte ejecutar094(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

      /*    param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHA, "20041209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
    //      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");
    */
          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

public DTOReporte ejecutar096_02(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();

      param.put(ConstantesREP.MARCA, "1");
      param.put(ConstantesREP.CANAL, "1");
      param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");
      param.put(ConstantesREP.PERIODOHASTA, "57");
      param.put(ConstantesREP.PERIODOS, "55,57");
	    param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
     	param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.ACCESO,"1");
	    param.put(ConstantesREP.SUBACCESOS,"1");
      param.put(ConstantesREP.FECHADESDE, "20000101");
      param.put(ConstantesREP.FECHAHASTA, "20500101");
      param.put(ConstantesREP.HORADESDE, "10:10:10");
      param.put(ConstantesREP.HORAHASTA, "10:10:10");

      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
  //    param.put(ConstantesREP.NOMBRE1, "%N%");
      //param.put(ConstantesREP.NOMBRE2, "%N%");

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;

  }
    public DTOReporte ejecutar096_01(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
          param.put(ConstantesREP.CANAL, "1");
          param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
            param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
             param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.ACCESO,"1");
            param.put(ConstantesREP.SUBACCESOS,"1");
          param.put(ConstantesREP.FECHADESDE, "20000101");
          param.put(ConstantesREP.FECHAHASTA, "20500101");
          param.put(ConstantesREP.HORADESDE, "10:10:10");
          param.put(ConstantesREP.HORAHASTA, "10:10:10");

          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,true);
          return dto;

      }

    public DTOReporte ejecutar096_03(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
          param.put(ConstantesREP.CANAL, "1");
          param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
            param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
             param.put(ConstantesREP.REGIONES, "1");
              param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
              param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.ACCESO,"1");
            param.put(ConstantesREP.SUBACCESOS,"1");
          param.put(ConstantesREP.FECHADESDE, "20000101");
          param.put(ConstantesREP.FECHAHASTA, "20500101");
          param.put(ConstantesREP.HORADESDE, "10:10:10");
          param.put(ConstantesREP.HORAHASTA, "10:10:10");

          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

 public DTOReporte ejecutar097(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHADESDE, "20000101");
      param.put(ConstantesREP.FECHAHASTA, "20500101");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

    public DTOReporte ejecutar099(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();

         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }

    public DTOReporte ejecutar100_01(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();

         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }

      public DTOReporte ejecutar102(String repId) throws Exception
  {
      iniciandoEjecucion(repId);      
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
     
      public DTOReporte ejecutar111(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");
      
         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }

 public DTOReporte ejecutar112(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHADESDE, "20000101");
      param.put(ConstantesREP.FECHAHASTA, "20500101");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }
 public DTOReporte ejecutar115(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }
     
      public DTOReporte ejecutar118(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");
      
         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }
    public DTOReporte ejecutar123(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
         param.put(ConstantesREP.TIPOREPORTE, "2");

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      

      addParam(param);        
      dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  

 public DTOReporte ejecutar124(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }
     
      public DTOReporte ejecutar125(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }
     
     
      public DTOReporte ejecutar126(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");
         //param.put(ConstantesREP.CRITERIOORDENACION1,"'OPERAD'");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }

 public DTOReporte ejecutar127(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }



 public DTOReporte ejecutar128(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }


    public DTOReporte ejecutar129(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }

   public DTOReporte ejecutar130(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }



public DTOReporte ejecutar132(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHADESDE, "01/01/2000");
      param.put(ConstantesREP.FECHAHASTA, "01/01/2055");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }

    public DTOReporte ejecutar143(String repId) throws Exception
     {
         iniciandoEjecucion(repId);
         MAREInfo mAREInfo;

         mAREInfo = getMareInfo();
         DTOReporte dto = new DTOReporte();
         String idRep = "RD_REP-"+repId;
         dto.setIdReporte(idRep);
         HashMap param = new HashMap();
  //param.put(ConstantesREP.IDIOMA, "1");
         /*param.put(ConstantesREP.MARCAS, "1");
             param.put(ConstantesREP.CANALES, "1");
             param.put(ConstantesREP.CANAL, "1");
             param.put(ConstantesREP.EMPRESAS, "1");
         param.put(ConstantesREP.PERIODO, "57");
         param.put(ConstantesREP.PERIODODESDE, "41");
         param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
         param.put(ConstantesREP.FECHADESDE, "20000101");
         param.put(ConstantesREP.FECHAHASTA, "20500101");

         //param.put(ConstantesREP.IDIOMA, new Long(1));
     //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
     //    param.put(ConstantesREP.NOMBRE1, "%N%");
         param.put(ConstantesREP.TIPOREPORTE, "2");

         //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");

         addParam(param);
         dto.setParametros(param);
         DTOReporte dtoS = getDTO(dto,mAREInfo);
         grabar(dtoS,false);
         return dto;

     }


public DTOReporte ejecutar158(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  //param.put(ConstantesREP.REGIONES, "1");
		  //param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHAINICIO, "20001209");
      param.put(ConstantesREP.FECHAFIN, "20151209");      
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  


public DTOReporte ejecutar(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  //param.put(ConstantesREP.REGIONES, "1");
		  //param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHAINICIO, "20001209");
      param.put(ConstantesREP.FECHAFIN, "20151209");      
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }


public DTOReporte ejecutar163(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              //param.put(ConstantesREP.REGIONES, "1");
              //param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHAINICIO, "20001209");
          param.put(ConstantesREP.FECHAFIN, "20151209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }

    public DTOReporte ejecutar162(String repId) throws Exception
      {
          iniciandoEjecucion(repId);
          MAREInfo mAREInfo;

          mAREInfo = getMareInfo();
          DTOReporte dto = new DTOReporte();
          String idRep = "RD_REP-"+repId;
          dto.setIdReporte(idRep);
          HashMap param = new HashMap();

          param.put(ConstantesREP.MARCA, "1");
              param.put(ConstantesREP.CANALES, "1");
              param.put(ConstantesREP.CANAL, "1");
              param.put(ConstantesREP.EMPRESAS, "1");
          param.put(ConstantesREP.PERIODO, "57");
          param.put(ConstantesREP.PERIODODESDE, "41");
          param.put(ConstantesREP.PERIODOHASTA, "57");
          param.put(ConstantesREP.PERIODOS, "55,57");
              param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
              //param.put(ConstantesREP.REGIONES, "1");
              //param.put(ConstantesREP.REGION, "1");
              param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
          param.put(ConstantesREP.FECHAINICIO, "20001209");
          param.put(ConstantesREP.FECHAFIN, "20151209");
          param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");
          param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");
          param.put(ConstantesREP.TIPOCLIENTE1, "1");
          param.put(ConstantesREP.NUMERODESCUENTO,"1187");
          param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");
          param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
          param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
          param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");
          param.put(ConstantesREP.ACCESO,"1");
          param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");

          //param.put(ConstantesREP.IDIOMA, new Long(1));
      //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");
      //    param.put(ConstantesREP.NOMBRE1, "%N%");
          //param.put(ConstantesREP.NOMBRE2, "%N%");

          //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");
          addParam(param);
          dto.setParametros(param);
          DTOReporte dtoS = getDTO(dto,mAREInfo);
          grabar(dtoS,false);
          return dto;

      }


public DTOReporte ejecutar157(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
      param.put(ConstantesREP.CODIGOCLIENTE,"00000000183");
		  //param.put(ConstantesREP.REGIONES, "1");
		  //param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHAINICIO, "20001209");
      param.put(ConstantesREP.FECHAFIN, "20151209");      
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  


public DTOReporte ejecutar159(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      param.put(ConstantesREP.MARCA, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            
      param.put(ConstantesREP.PERIODOS, "55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
      param.put(ConstantesREP.CODIGOCLIENTE,"00000000183");
		  //param.put(ConstantesREP.REGIONES, "1");
		  //param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
//		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHAINICIO, "20001209");
      param.put(ConstantesREP.FECHAFIN, "20151209");      
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      
      param.put(ConstantesREP.TIPODESCUENTOS, "1010,1011,1020");      
      param.put(ConstantesREP.TIPOCLIENTE1, "1");            
      param.put(ConstantesREP.NUMERODESCUENTO,"1187");
      param.put(ConstantesREP.TIPOCLIENTE1DESC,"Prueba1");      
      param.put(ConstantesREP.TIPOCLIENTE2DESC,"Prueba2");
      param.put(ConstantesREP.MODALIDADMUESTRAVENTAS,"'asc'");
      param.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA,"2");      
      param.put(ConstantesREP.ACCESO,"1");            
      param.put(ConstantesREP.TIPOSOLICITUDES,"1,2,8,10,16,13,61,64,66,67,1382,1392,1418,1423");            
      
      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      //param.put(ConstantesREP.NOMBRE2, "%N%");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
      addParam(param);        
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }  
  
public DTOReporte ejecutar160(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHAINICIO, "01/01/2000");
      param.put(ConstantesREP.FECHAFIN, "01/01/2050");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }


public DTOReporte ejecutar161(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHADESDE, "20000101");
      param.put(ConstantesREP.FECHAHASTA, "20500101");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }


public DTOReporte ejecutar164(String repId) throws Exception
  {
      iniciandoEjecucion(repId);
      MAREInfo mAREInfo;

      mAREInfo = getMareInfo();
      DTOReporte dto = new DTOReporte();
      String idRep = "RD_REP-"+repId;
      dto.setIdReporte(idRep);
      HashMap param = new HashMap();
      
      /*param.put(ConstantesREP.MARCAS, "1");
		  param.put(ConstantesREP.CANALES, "1");
		  param.put(ConstantesREP.CANAL, "1");      
		  param.put(ConstantesREP.EMPRESAS, "1");
      param.put(ConstantesREP.PERIODO, "57");
      param.put(ConstantesREP.PERIODODESDE, "41");      
      param.put(ConstantesREP.PERIODOHASTA, "57");            */
/*      param.put(ConstantesREP.PERIODOS, "41,55,57");      
		  param.put(ConstantesREP.DEPARTAMENTOS, "-1");//new SharedInteger(new Integer(5)));
		  param.put(ConstantesREP.REGIONES, "1");
		  param.put(ConstantesREP.REGION, "1");      
		  param.put(ConstantesREP.SECCIONES, "1");
		  param.put(ConstantesREP.ZONAS, "1");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.FECHA, "02/12/2004");
      param.put(ConstantesREP.ACTIVIDADES, "1,2,3,4,5");      */
      param.put(ConstantesREP.FECHADESDE, "12/08/2001");
      param.put(ConstantesREP.FECHAHASTA, "23/06/2015");

      //param.put(ConstantesREP.IDIOMA, new Long(1));
  //    param.put(ConstantesREP.APELLIDOPATERNO, "%A%");
//      param.put(ConstantesREP.APELLIDOMATERNO, "%A%");      
  //    param.put(ConstantesREP.NOMBRE1, "%N%");            
      param.put(ConstantesREP.TIPOREPORTE, "2");                  

      //param.put(ConstantesREP.FORMATOSALIDA,"EXCEL");      
        
      addParam(param);
      dto.setParametros(param);
      DTOReporte dtoS = getDTO(dto,mAREInfo);
      grabar(dtoS,false);
      return dto;
    
  }



  public void ejecutarSEG() throws Exception
  {
      ejecutar026("026");      
  //    ejecutar027("027");      
      ejecutar028("028");      
      ejecutar029("029");  
    
  }


 public void ejecutarREC() throws Exception
  {
      ejecutar102("102");   
   //   ejecutar103("103");     
   //   ejecutar104("104");     
   //   ejecutar105("105");     
   //   ejecutar106("106");     
   //   ejecutar107("107");     
   //   ejecutar108("108");     
   //   ejecutar109("109");     
      ejecutar110("110");     
      ejecutar111("111");     
      ejecutar112("112");     
   //   ejecutar113("113");     
   //   ejecutar114("114");     
      ejecutar115("115");     
   //   ejecutar116("116");     
   //   ejecutar117("117");     
      ejecutar118("118");  
   //   ejecutar165("165");     
   
 
  }

  public void ejecutarZON() throws Exception
  {
      ejecutar154("154");      
      ejecutar155("155");      
      ejecutar155Resumen("155-RESUMEN");            
      ejecutar156("156");  
  }
  
  public void ejecutarMAE() throws Exception
  {
      ejecutar037("037");            
      ejecutar038("038");                  
      ejecutar039("039");            
      ejecutar040("040");                  
      ejecutar041("041");                        
  }

  public void ejecutarCRA() throws Exception
  {
      ejecutar001_01("001_01");                  
      ejecutar001_02("001_02");                  
      ejecutar001_03("001_03");                        
      ejecutar002("002");                
      ejecutar003("003");                  
      ejecutar004("004");                  
      ejecutar005("005");                  
      ejecutar006("006");                  
      ejecutar007("007");                
      ejecutar008_01("008_01");                  
      ejecutar008_02("008_02");                        
  }


  public void ejecutarPRE() throws Exception
  {
      ejecutar042_01("042_01");                  
      ejecutar042_02("042_02");                  
      ejecutar043("043");                        
      ejecutar045("045");                        
      ejecutar046_01("046_01");                  
      ejecutar046_02("046_02");                  
      ejecutar046_03("046_03");                  
      ejecutar046_04("046_04");                        
      ejecutar046_01_D("046_01_D");                  
      ejecutar046_02_D("046_02_D");                  
      ejecutar046_03_D("046_03_D");                  
      ejecutar046_04_D("046_04_D");                        
      ejecutar047_01("047_01");                              
      ejecutar047_02("047_02");                                    
      ejecutar047_ALT_01("047-ALT_01");                              
      ejecutar047_ALT_02("047-ALT_02");                                    
      ejecutar047_REEM_01("047-REEM_01");                              
      ejecutar047_REEM_02("047-REEM_02");                                    
      
  }
  
  public void ejecutarDTO() throws Exception
  {
    ejecutar033("033");                                
    ejecutar034("034");                                    
    ejecutar035("035");                                    
    ejecutar036("036");                                        
  }
  
  public void ejecutarMAV() throws Exception
  {
    ejecutar030("030");                                
    ejecutar031_01("031_01");                                    
    ejecutar031_02("031_02");                               
    ejecutar032("032");                                        
  }
  
  
  public void ejecutarEDU() throws Exception
  {
    ejecutar010("010");                                
    ejecutar011("011");                                    
    ejecutar011_02("011_02");                                    
    ejecutar012("012");                                        
    ejecutar013("013");                                        
    ejecutar014_01("014_01");                                            
    ejecutar014_02("014_02");                                                
    ejecutar015("015");    
  }
  
  public void ejecutarCAR() throws Exception
  {
    ejecutar091_01("091_01");                                  
    ejecutar091_02("091_02");                                  
    ejecutar091_03("091_03");                                  
    ejecutar091_04("091_04");                                  
    ejecutar091_05("091_05");                                      
    ejecutar092("092");                                
    ejecutar157("157");
  }

  public void ejecutarCAL() throws Exception
  {
    ejecutar084("084");                                
    ejecutar084_02("084_02");                                    
    ejecutar085("085");                                    
    ejecutar086_01("086_01");                                    
    ejecutar086_02("086_02");                                        
    ejecutar087("087");                                        
    ejecutar088("088");                                    
    ejecutar089_01("089_01");                                    
    ejecutar089_02("089_02");                                        
    ejecutar090("090");                                    
  }

  public void ejecutarPED() throws Exception
  {
    ejecutar017("017");                                  
    ejecutar018("018");                                
    ejecutar019("019");                                    
    ejecutar020("020");                                        
    ejecutar021("021");
    ejecutar022("022");
    ejecutar023("023");
    ejecutar024("024");
    ejecutar025("025");
    ejecutar026("026");
  }

  public void ejecutarBEL() throws Exception
  {
    ejecutar093_01("093_01");
    ejecutar093_02("093_02");
    ejecutar093_03("093_03");
    ejecutar094("094");
    ejecutar095("095");
    ejecutar096_01("096_01");
    ejecutar096_02("096_02");
    ejecutar096_03("096_03");
    ejecutar097("097");
    ejecutar099("099");
    ejecutar100_01("100_01");

  }
  
  public void ejecutarFAC() throws Exception
  {
    ejecutar158("158");                                  
    ejecutar159("159");   
    ejecutar160("160");
    ejecutar161("161");
    //ejecutar162("162");
    ejecutar163("163");
    ejecutar164("164");




  }
  
   public void ejecutarCCC() throws Exception
  {
    ejecutar132("132");                                  
    
     

  }
   public void ejecutarCOB() throws Exception
  {
    ejecutar123("123");
    ejecutar124("124"); 
    ejecutar125("125");  
    ejecutar126("126");                                  
    ejecutar127("127");  
    ejecutar128("128");  
    ejecutar129("129");  
    ejecutar130("130");  
    
     

  }
  
  public void ejecutarTest()
  {
    try
    {
     /*ejecutarSEG();   
      ejecutarZON();
      ejecutarMAE();
      ejecutarCRA();
      ejecutarPRE();
      ejecutarDTO();*/
      /*ejecutarEDU();
      ejecutarMAV();    
      ejecutarCAR();      
      ejecutarCAL();

     ejecutarPED();
     ejecutarBEL();

      //REVISADO
  ejecutarREC();
 //    ejecutarFAC();

       ejecutarCCC();*/
         ejecutarCOB();
    
    //ejecutar008_01("008_01");
   //ejecutar154("154");
//          ejecutar043("043");

//ejecutar126("126");


// ejecutar157("157"); 
//ejecutar099("099");  
 //ejecutar096_02("096_02");  
//ejecutar091_02("040");
//    ejecutar002("002");                                    
  //  ejecutar014_02("014_02");                                    
//ejecutar100_01("100_01");
    //ejecutar031_02("031_02");                               
  
  
                               
  //  ejecutar031_02("031_02");                               
  

//     ejecutar159("159");                  
 ///     ejecutar155Resumen("155-RESUMEN");                  
//Boolean value = (new Boolean((new String($F{MAX_PERIO)).equals("0"))));
    //  ejecutar031_01("031_01");                  
    //  ejecutar011_02("011_02");                  
    //ejecutar043("043");                                  
 //   ejecutar039("039");                                      
//    ejecutar007("007");                                      
  //  ejecutar008_02("008_02");                                          
    //    ejecutar042_01("042_01");                               
 
//      ejecutar157("157");      
        ejecutar096_01("096_01");
       //ejecutar163("163");
  //ejecutarEjemploExcel();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
    
  }
  
  public void ejecutarEjemploExcel() throws Exception {
       iniciandoEjecucion("VENTAS_CLIENTES_2002_EXCEL");
       MAREInfo mAREInfo;

       mAREInfo = getMareInfo();
       DTOReporte dto = new DTOReporte();
       String idRep = "VENTAS_CLIENTES_2002_EXCEL";
       dto.setIdReporte(idRep);
       HashMap param = new HashMap();
       param.put("FORMATOSALIDA","EXCEL");
       dto.setParametros(param);
       DTOReporte dtoS = getDTO(dto,mAREInfo);
       grabar(dtoS,false);

  }

  public static void main(String [] args)
  {
    MAREInfoClient1 mAREInfoClient1 = new MAREInfoClient1();
    mAREInfoClient1.ejecutarTest(); 


  }

  private Context getInitialContext() throws NamingException
  {
    if (context == null){
      // Get InitialContext for Embedded OC4J.
      // The embedded server must be running for lookups to succeed.
      env = new Hashtable();
      // Standalone OC4J connection details
      env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
      env.put(Context.SECURITY_PRINCIPAL, "admin");
      env.put(Context.SECURITY_CREDENTIALS, "welcome");
      env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");
      context = new InitialContext(env);
    }
    return context;
  }

  DTOReporte getDTO(DTOReporte dto, MAREInfo mAREInfo){
      try {
        //  System.out.println(dto.getIdReporte());
          if  (mAREInfo==null){
            return new MAREInfoBean().ejecutarReporteOrig(dto);
          }else{
            return mAREInfo.ejecutarReporteOrig(dto);
          }
      } catch (Exception e) {
                //   System.out.println("E  R  R  O  R ..................."+dto.getIdReporte());
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
          return null;
      }
  }


  private void iniciandoEjecucion(String repId)
  {
    //System.out.print("Reporte:"+repId);
  }
}