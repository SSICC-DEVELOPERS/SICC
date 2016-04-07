package es.indra.sicc.logicanegocio.ndg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

//import es.indra.sicc.cmn.negocio.interfaces.InterfazInfo;
//import es.indra.sicc.cmn.negocio.interfaces.MONGestorInterfaces;
//import es.indra.sicc.cmn.negocio.interfaces.MONGestorInterfacesHome;
//import es.indra.sicc.cmn.negocio.interfaces.RegistroSicc;
//import es.indra.sicc.cmn.negocio.interfaces.exception.InterfacesException;

import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ndg.ConstantesNDG;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.util.BelcorpService;

import es.indra.sicc.util.SecuenciadorOID;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;

import es.indra.sicc.logicanegocio.intsys.MONOCRHome;
import es.indra.sicc.logicanegocio.intsys.MONOCR;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.intsys.DTOCargarOrdenesDeCompra;
import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;

public class MONRecepcionNDGBean implements SessionBean  {
  public void ejbCreate() {
    System.out.println("MONRecepcionNDGBean creado");
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
    System.out.println("MONRecepcionNDGBean removido");
  }

  public void setSessionContext(SessionContext ctx) {
  }

  public void recibirOrdenesDeCompra() throws  RemoteException, MareException, InterfacesException {
  }

  /*****************
  Autor: Juan Pablo Sabadini
  Fecha: 18/11/2004
  Modificacion de la asignatura
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 01/11/2004
  Se comento el contenido del metodo, debido a que dejó de existir cargarEstadisticas.
  Ahora se deberá llamar directamente a los métodos cargarEstadisticasLotes y luego cargarEstadisticasRegistros
  *******************/
  public void recibirEstadisticas() throws MareException, InterfacesException, RemoteException {
    /*boolean corte = true;
    while( corte ) {
      try{     
        corte = (this.cargarEstadisticas()).booleanValue();
        throw new InterfacesException();
        */
        /*
      } catch(RemoteException e) {
        System.out.println("Excepcion: " + e.toString());
        e.printStackTrace();
        corte = false;
        throw new InterfacesException();
      } catch(MareException e) {
        System.out.println("Excepcion: " + e.toString());
        e.printStackTrace();
        corte = false;
        throw new InterfacesException();  
      }
      */
      /*}catch(Exception e){
        throw new MareException(
          CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ,
          e);
      }
      }*/
  
    throw new MareException(CodigosError.CASO_DE_USO_INDEFINIDO, new Exception());
  }

  /*****************
  Autor: Juan Pablo Sabadini
  Fecha: 10/11/2004
  Modificacion del metodo para traer la zona segun el pais y el cliente.
  *******************/

  /*****************
  Autor: Juan Pablo Sabadini
  Fecha: 15/11/2004
  Modificacion del metodo para traer la zona cuando la query ppal trae valores nulos. Se agregaron queries para traer la zona segun
  unidad administrativa.
  *******************/

  /*****************
  Autor: Juan Pablo Sabadini
  Fecha: 18/11/2004
  Modificacion de la asignatura
  *******************/

  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestorInterfacesHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONGestorInterfaces" ), MONGestorInterfacesHome.class);
  }

  public void cargarOrdenesDeCompra(DTOAuditableSICC dto) throws MareException {
    MONOCRHome home = null;
    MONOCR ocr = null;
    
    try {
      home = this.getMONOCRHome();
      ocr = home.create();
    }catch(Exception e)  {
      e.printStackTrace();
      if (e instanceof MareException) {
        throw (MareException)e;
      } else {
        throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
    }
    
    DTOCargarOrdenesDeCompra dtoc = new DTOCargarOrdenesDeCompra();
    dtoc.setIndInterfaz(ConstantesOCR.INDICADOR_INTERFAZ_NDG);
    dtoc.setOidPais(dto.getOidPais());
    
    try{
      ocr.cargarOrdenesDeCompra(dtoc);
    } catch (Exception e) {
      e.printStackTrace();
      if (e instanceof MareException){
        throw (MareException)e;
      } else {
        throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
      }
    }
  }

  private MONOCRHome getMONOCRHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONOCRHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOCR"), MONOCRHome.class);
  }

  /*****************
  Autor: Cortaberria
  Fecha: 30/11/2004
  Creada mediante divicion del metodo cargarEstadisticas 
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 26/01/2005
  Le sumo un mes ya que se genera el archivo con rango de mes 0 a 11
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 01/02/2005
  Retorna un DTOSalisda con un RecordSet, el cual posee el NUM_LOTE segun NDG
  y el NUM_LOTE generado para SICC para cada uno de los de NDG. Estos seran usados
  en cargarEstadisticasRegistro
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 17/05/2005
  Se agrega el último canal y la última marca leidos, ya que un fichero vendrá de 
  un nodo digitación y este solo tiene asignado un canal y una marca por defecto,
  en el DTOSalida devuelto
  *******************/  
  public DTOSalida cargarEstadisticasLote(DTOAuditableSICC dto) throws MareException, InterfacesException {
    DTOSalida dtoSalida = new DTOSalida();
    RecordSet recorset = new RecordSet();
    
    BelcorpService belcorpService = BelcorpService.getInstance();
    String codigoError;
    MONGestorInterfaces monGI = null;
    Boolean result = Boolean.TRUE;
    InterfazInfo iLote = null;
    
    Long OIDPais = dto.getOidPais();
    
    try{
      MONGestorInterfacesHome monGIH = getMONGestorInterfacesHome();
      monGI = monGIH.create();
    } catch(Exception e) {
      System.out.println("Excepcion en cargarEstadisticas: " + e.toString());
      e.printStackTrace();
      throw new MareException (e, UtilidadesError.armarCodigoError(
        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    
    try {
      iLote = monGI.importarInterfaz(ConstantesNDG.NDG_INTERFAZ_LOTE, OIDPais);
    } catch (Exception ie) {
      System.out.println("Excepcion: " + ie.toString());
      ie.printStackTrace();

      throw new MareException (ie, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
    }

    Long numLote = null;
    Date fechaReg;
    String periodo = null;
    String pais = null;
    String marca = null;
    String canal = null;
    String tipoSolicitud;
    //Vector v = new Vector();
    StringBuffer stringBuffer = null;
    
    try {
      RegistroSicc registro = null;
      SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");

      int day, month, year;
      
      /*se crea crea la variable cacheTipoSoli y cacheOidPerio, que funcionaran como cache, para 
       * no hacer busquedas innecesarias en la BD*/
      Hashtable cacheTipoSoli = new Hashtable();
      Hashtable cacheOidPerio = new Hashtable();
      
      Hashtable lotesAux = new Hashtable();
      
      MONProcesosPED monProcesosPED = null;
      try {
        MONProcesosPEDHome procesosHome = this.getMONProcesosPEDHome();
        monProcesosPED = procesosHome.create();
      } catch (CreateException cex) {
        cex.printStackTrace();
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(RemoteException rex) {
          rex.printStackTrace();
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
      } catch (Exception ex) { //ERROR NO DOCUMENTADO
          ex.printStackTrace();
          throw new MareException(ex);
      }  
      
      while( (registro = (RegistroSicc)monGI.cargarRegistro(iLote)) != null){
        
        fechaReg = (Date)registro.obtenerCampo( ConstantesNDG.PED_LOTE_FEC_REGI );
        String periodoStr = (String) registro.obtenerCampo( ConstantesNDG.PED_LOTE_PERIODO );
        pais = ((String) registro.obtenerCampo( ConstantesNDG.PED_LOTE_COD_PAIS ));
        marca = (String) registro.obtenerCampo( ConstantesNDG.PED_LOTE_MARCA );
        canal = (String) registro.obtenerCampo( ConstantesNDG.PED_LOTE_CANAL );
        String tipoSolicitudStr = ((String) registro.obtenerCampo( ConstantesNDG.PED_TIPO_SOLICITUD )).toString();
        
        Integer aux = (Integer) registro.obtenerCampo( ConstantesNDG.PED_LOTE_NUM_LOTE );
        numLote = (Long) lotesAux.get(aux);
        if (numLote == null) {
          String numeroLoteString = null;
          if(monProcesosPED != null) {
            DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
            dtoNumero.setCodCanal(canal.trim());
            dtoNumero.setCodPais(pais.trim());
            dtoNumero.setOperacion(ConstantesBEL.COD_PED110);            
            numeroLoteString = monProcesosPED.generaNumeroDocumento(dtoNumero);
          }
          
          //numeroLoteString = Long.toString(System.currentTimeMillis());
          //numeroLoteString = numeroLoteString.substring(numeroLoteString.length() - 10 );
          lotesAux.put(aux, new Long(numeroLoteString));
          numLote = (Long) lotesAux.get(aux);
        }
        
        String key = tipoSolicitudStr + "--" + pais;
        tipoSolicitud = (String)cacheTipoSoli.get(key);
        if (tipoSolicitud == null) {
          StringBuffer queryTipoSoli = new StringBuffer();
          queryTipoSoli.append("SELECT ptsp.OID_TIPO_SOLI_PAIS ");
          queryTipoSoli.append("FROM PED_TIPO_SOLIC pts, ");
          queryTipoSoli.append("PED_TIPO_SOLIC_PAIS ptsp, ");
          queryTipoSoli.append("SEG_PAIS pais ");
          queryTipoSoli.append("WHERE pais.OID_PAIS = ptsp.PAIS_OID_PAIS ");
          queryTipoSoli.append("AND ptsp.TSOL_OID_TIPO_SOLI = pts.OID_TIPO_SOLI ");
          queryTipoSoli.append("AND pts.COD_TIPO_SOLI = '").append(tipoSolicitudStr).append("' ");
          queryTipoSoli.append("AND pais.COD_PAIS = '").append(pais).append("'");
                    
          try {
            RecordSet rs = belcorpService.dbService.executeStaticQuery(queryTipoSoli.toString());
            if (!rs.esVacio()) {
              tipoSolicitud = ((BigDecimal)rs.getValueAt(0,0)).toString();
            }
            cacheTipoSoli.put(key, tipoSolicitud);  
          } catch (Exception exception) {
            System.out.println("Excepcion: " + exception);
            exception.printStackTrace();
            //codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            //throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }
        
        periodo = (String)cacheOidPerio.get(periodoStr);
        if (periodo == null) {
          StringBuffer queryPeriodo = new StringBuffer();
          queryPeriodo.append("SELECT c.OID_PERI ");
          queryPeriodo.append("FROM SEG_PERIO_CORPO s, CRA_PERIO c ");
          queryPeriodo.append("WHERE s.OID_PERI = c.PERI_OID_PERI ");
          queryPeriodo.append("AND s.COD_PERI = '").append(periodoStr).append("'");
          
          try {
            RecordSet rs = belcorpService.dbService.executeStaticQuery(queryPeriodo.toString());
            if (!rs.esVacio()) {
              periodo = ((BigDecimal)rs.getValueAt(0,0)).toString();
            }
            cacheOidPerio.put(periodoStr, periodo);  
          } catch (Exception exception) {
            System.out.println("Excepcion: " + exception);
            //codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            //throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fechaReg);

        day = gc.get(GregorianCalendar.DAY_OF_MONTH);
        month = gc.get(GregorianCalendar.MONTH);
        year = gc.get(GregorianCalendar.YEAR);
                
        Long oid = SecuenciadorOID.obtenerSiguienteValor("PED_LOTE_SEQ");
        
        stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO PED_LOTE (OID_LOTE, NUM_LOTE, FEC_REGI ,PERD_OID_PERI ,TSPA_OID_TIPO_SOLI_PAIS ) ");
        stringBuffer.append(" VALUES("+ oid +", "+ numLote +", TO_DATE('"+ day + "-" + (month + 1) + "-" + year + "', 'DD-MM-YYYY')" + 
              ", "+ periodo +", "+ tipoSolicitud +") ");

        try {
          belcorpService.dbService.executeUpdate(stringBuffer.toString());
        } catch (Exception exception) {
          System.out.println("Excepcion: " + exception);
          exception.printStackTrace();
          codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
      }

      recorset.addColumn("NUM_LOTE_NDG");
      recorset.addColumn("NUM_LOTE_SICC");
      recorset.addColumn("COD_MARCA");
      recorset.addColumn("COD_CANAL");
      
      Vector v = null;
      Enumeration enum = lotesAux.keys();
      while(enum.hasMoreElements()) {
        v = new Vector();
        Integer key = (Integer) enum.nextElement();
        Long value = (Long)lotesAux.get(key);
        v.add(key);
        v.add(value);
        //Se agrega el último canal y la última marca leidos ya que un fichero vendrá de 
        //un nodo digitación y este solo tiene asignado un canal y una marca por defecto
        v.add(marca);
        v.add(canal);
        recorset.addRow(v);
      }
      
      dtoSalida.setResultado(recorset);
      
    } catch( Exception e ){
      System.out.println("Excepcion: " + e.toString());
      e.printStackTrace();
      throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CIERRE_DE_INTERFAZ));
    } 

    
    
    
    
    return dtoSalida;
  }

  /*****************
  Autor: Cortaberria
  Fecha: 30/11/2004
  Creada mediante divicion del metodo cargarEstadisticas 
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 01/02/2005
  Se agrega el parametro
  *******************/
  /*****************
  Autor: Cortaberria
  Fecha: 17/05/2005
  Se modifica la primer query para obtener la zona. La misma fue armada junto a Carlos Falco
  *******************/
  public void cargarEstadisticasRegistros(DTOSalida dtos) throws MareException, InterfacesException {
  
    Hashtable numerosLotes = new Hashtable();
    RecordSet recordset = dtos.getResultado();
    
    Long OIDPais = dtos.getOidPais();
    String marca = null;
    String canal = null;
    if (!recordset.esVacio()) {
      for (int i = 0; i < recordset.getRecords().size(); ++i) {
        Integer numLoteNdg = (Integer) recordset.getValueAt(i, "NUM_LOTE_NDG");
        Long numLoteSicc = (Long) recordset.getValueAt(i, "NUM_LOTE_SICC");
        marca = (String) recordset.getValueAt(i, "COD_MARCA");
        canal = (String) recordset.getValueAt(i, "COD_CANAL");
        numerosLotes.put(numLoteNdg, numLoteSicc);
      }
    } else {
      //TODO nunca debería entrar aca
      System.out.println("Entro en una parte donde jamas debería entrar. Creo!");
      return;
    }
  
    RecordSet rsRegistros = new RecordSet();
    BelcorpService belcorpService = BelcorpService.getInstance();
    String codigoError;
    MONGestorInterfaces monGI = null;
    Boolean result = Boolean.TRUE;
    InterfazInfo iRegistro = null;
    
      StringBuffer stringBuffer = new StringBuffer();
      Integer numRegi;
      Integer numDigi;
      String cliente;
      Long lote;
      String periodo = null;
      String pais = null;
      //String marca = null;
      //String canal = null;
      Vector v = null;
      Vector vecLotes = new Vector();
      RecordSet rsLotes = new RecordSet();
      rsLotes.addColumn("NUM_LOTE");
      rsLotes.addColumn("MARCA");
      rsLotes.addColumn("CANAL");
      rsLotes.addColumn("OID_LOTE");


      IRegistroSicc registro = null;

      Vector identifiersReg = new Vector();
      identifiersReg.add("NUM_REGI");
      identifiersReg.add("NUM_DIGI");
      identifiersReg.add("COD_CLIE");
      identifiersReg.add("NUM_LOTE");
      identifiersReg.add("COD_PAIS");

      rsRegistros.setColumnIdentifiers( identifiersReg );

      try{
        MONGestorInterfacesHome monGIH = getMONGestorInterfacesHome();
        monGI = monGIH.create();
      } catch(Exception e) {
        System.out.println("Excepcion en cargarEstadisticas: " + e.toString());
        e.printStackTrace();
        throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
    
      try {
        iRegistro = monGI.importarInterfaz(ConstantesNDG.NDG_INTERFAZ_REGISTRO, OIDPais);
      } catch (Exception ie) {
        System.out.println("Excepcion: " + ie.toString());
        ie.printStackTrace();

        throw new MareException (ie, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));        
      }


      try {
        Hashtable cacheNumLotes = new Hashtable();
        while((registro = monGI.cargarRegistro(iRegistro)) != null){
                
          numRegi = (Integer) registro.obtenerCampo( ConstantesNDG.PED_REGIS_SOLIC_NUM_REGI );
          numDigi = (Integer) registro.obtenerCampo( ConstantesNDG.PED_REGIS_SOLIC_NUM_DIGI );
          cliente = (String) registro.obtenerCampo( ConstantesNDG.PED_REGIS_SOLIC_CLIENTE );
          pais = (String) registro.obtenerCampo( ConstantesNDG.PED_REGIS_SOLIC_PAIS );

          Integer loteNdg = (Integer) registro.obtenerCampo( ConstantesNDG.PED_REGIS_SOLIC_LOTE );
          lote = (Long) numerosLotes.get(loteNdg);
          
           
          v = new Vector();

          v.add(numRegi);
          v.add(numDigi);
          v.add(cliente);
          v.add(lote);
          v.add(pais);

          rsRegistros.addRow(v);
          System.out.println("El vector quedo: " + v);

          if (!vecLotes.contains(lote)) {
            try {
              String query = "SELECT P.OID_LOTE, sm.COD_MARC, sc.COD_CANA " +
                  "FROM PED_LOTE p, CRA_PERIO c, SEG_MARCA sm, SEG_CANAL sc " + 
                  "WHERE p.PERD_OID_PERI = c.OID_PERI AND sm.OID_MARC = c.MARC_OID_MARC "+
                  "AND sc.OID_CANA = c.CANA_OID_CANA AND NUM_LOTE = " + lote;
              RecordSet rs = belcorpService.dbService.executeStaticQuery(query);             
              if (!rs.esVacio()) {
                System.out.println("Se agrega el lote " + lote);
                Vector aux = new Vector();
                aux.add(lote);
                //aux.add( (String)rs.getValueAt(0,"COD_MARC") ); 
                //aux.add( (String)rs.getValueAt(0,"COD_CANA") ); 
                aux.add(marca);
                aux.add(canal);
                aux.add( new Long(((BigDecimal)rs.getValueAt(0,"OID_LOTE")).longValue()) ); 
                vecLotes.add(lote);
                rsLotes.addRow(aux);
              } else {
                System.out.println("No se pudo encontrar el numero de lote " + lote);
              }
            } catch ( Exception e ) {
              System.out.println("ERROR: No se pudo encontrar el numero de lote " + lote);
              System.out.println("Descripcion: " + e);
            }
          }
        }

      } catch(Exception e) {
        System.out.println("ERROR iniesperado " );
        e.printStackTrace();
        if (e instanceof MareException) {
          throw (MareException) e;
        } else {
          throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
        }
      }
      
      String zona = null;
      Integer oidCliente = null;
      for(int k = 0; k < rsLotes.getRowCount(); k++){
        Long numLoteLot = (Long)rsLotes.getValueAt(k,"NUM_LOTE");
        canal = (String)rsLotes.getValueAt(k,"CANAL");
        marca = (String)rsLotes.getValueAt(k,"MARCA");
        for(int j = 0 ; j < rsRegistros.getRowCount(); j++){
System.out.println("registro: " + j);      

          Long numLoteReg = (Long)((Vector)(rsRegistros.getRow(j))).get(3);
          if(numLoteLot.equals(numLoteReg)){
            
            numRegi = (Integer)((Vector)(rsRegistros.getRow(j))).get(0);
            numDigi = (Integer)((Vector)(rsRegistros.getRow(j))).get(1);
            cliente = (String)((Vector)(rsRegistros.getRow(j))).get(2);
            //lote = (Integer)((Vector)(rsRegistros.getRow(j))).get(3);
            lote = (Long)rsLotes.getValueAt(k,"OID_LOTE");
            pais = (String)((Vector)(rsRegistros.getRow(j))).get(4);

            stringBuffer = new StringBuffer();
            
            stringBuffer.append("SELECT DISTINCT zona.OID_ZONA ");
            stringBuffer.append("FROM mae_clien_unida_admin unid, ");
            stringBuffer.append("zon_terri_admin tadm, ");
            stringBuffer.append("zon_secci seccion, ");
            stringBuffer.append("zon_zona zona, ");
            stringBuffer.append("mae_clien mae, ");
            stringBuffer.append("seg_pais seg_pais, ");
            stringBuffer.append("seg_marca m, ");
            stringBuffer.append("seg_canal c ");
            stringBuffer.append("WHERE (    (tadm.oid_terr_admi = unid.ztad_oid_terr_admi) ");
            stringBuffer.append("AND (seccion.oid_secc = tadm.zscc_oid_secc) ");
            stringBuffer.append("AND (zona.oid_zona = seccion.zzon_oid_zona) ");
            stringBuffer.append("AND (mae.oid_clie = unid.clie_oid_clie) ");
            stringBuffer.append("AND (seg_pais.oid_pais = zona.pais_oid_pais) ");
            stringBuffer.append("AND (m.oid_marc = zona.marc_oid_marc) ");
            stringBuffer.append("AND (c.oid_cana = zona.cana_oid_cana) ");
            stringBuffer.append("AND (unid.ind_acti = 1) ");
            stringBuffer.append("AND (mae.cod_clie = '").append(cliente).append("') ");
            stringBuffer.append("AND (seg_pais.cod_pais = '").append(pais).append("') ");
            stringBuffer.append("AND (m.cod_marc = '").append(marca).append("') ");
            stringBuffer.append("AND (c.cod_cana = '").append(canal).append("') ");
            stringBuffer.append(") ");

            try {
              RecordSet rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
              if(rs.esVacio()){
                stringBuffer = new StringBuffer();
                stringBuffer.append("SELECT cliUniAdmin.OID_CLIE_UNID_ADMI ");   
                stringBuffer.append("FROM SEG_PAIS sp, ");   
                stringBuffer.append("SEG_MARCA sm, "); 
                stringBuffer.append("SEG_CANAL sc, "); 
                stringBuffer.append("MAE_CLIEN cli, "); 
                stringBuffer.append("MAE_CLIEN_UNIDA_ADMIN cliUniAdmin, ");  
                stringBuffer.append("ZON_TERRI_ADMIN zta "); 
                stringBuffer.append("WHERE ");  
                stringBuffer.append("sp.COD_PAIS = '" + pais + "' AND ");          
                stringBuffer.append("cli.COD_CLIE = '" + cliente + "' AND ");          
                stringBuffer.append("sc.COD_CANA = '" + canal + "' AND ");  
                stringBuffer.append("sm.COD_MARC = '" + marca + "' AND ");  
                stringBuffer.append("cli.OID_CLIE = cliUniAdmin.CLIE_OID_CLIE AND "); 
                stringBuffer.append("cliUniAdmin.IND_ACTI = 0 AND "); 
                stringBuffer.append("zta.OID_TERR_ADMI = cliUniAdmin.ZTAD_OID_TERR_ADMI AND "); 
                stringBuffer.append("zta.PAIS_OID_PAIS = sp.OID_PAIS AND "); 
                stringBuffer.append("zta.MARC_OID_MARC = sm.OID_MARC AND "); 
                stringBuffer.append("zta.CANA_OID_CANA = sc.OID_CANA ");

                rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
                BigDecimal unidadAdm = ( BigDecimal )rs.getValueAt(0,0);

                stringBuffer = new StringBuffer();
                stringBuffer.append("SELECT DISTINCT z.COD_ZONA ");  
                stringBuffer.append("FROM MAE_CLIEN_UNIDA_ADMIN cliUniAdmin, ");  
                stringBuffer.append("ZON_ZONA  z, "); 
                stringBuffer.append("ZON_SECCI s, ");  
                stringBuffer.append("ZON_TERRI_ADMIN zta ");
                stringBuffer.append("WHERE cliUniAdmin.OID_CLIE_UNID_ADMI = "+ unidadAdm +" AND ");
                stringBuffer.append("zta.OID_TERR_ADMI = cliUniAdmin.ZTAD_OID_TERR_ADMI AND ");
                stringBuffer.append("s.OID_SECC = zta.ZSCC_OID_SECC AND ");  
                stringBuffer.append("z.OID_ZONA = s.ZZON_OID_ZONA ");

                rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
                zona = (( BigDecimal )rs.getValueAt(0,0)).toString();
                stringBuffer = new StringBuffer();
                stringBuffer.append("SELECT OID_ZONA FROM ZON_ZONA WHERE COD_ZONA = '" + zona + "'");
                rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
                
              }
              zona = (( BigDecimal )rs.getValueAt(0,0)).toString();
            } catch (Exception exception) {
              System.out.println("Excepcion: " + exception);
              throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            stringBuffer = new StringBuffer();
            stringBuffer.append("SELECT OID_CLIE FROM MAE_CLIEN WHERE COD_CLIE = '" + cliente + "'");
            try {
              RecordSet rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());              
              oidCliente = new Integer((( BigDecimal )rs.getValueAt(0,0)).intValue());
            } catch (Exception exception) {
              System.out.println("Excepcion: " + exception);
              throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            Long poid = SecuenciadorOID.obtenerSiguienteValor("PED_RESO_SEQ");
            stringBuffer = new StringBuffer();
            stringBuffer.append("INSERT INTO PED_REGIS_SOLIC (OID_REGI_SOLI, NUM_REGI, NUM_DIGI, CLIE_OID_CLIE, LOTE_OID_LOTE, ZZON_OID_ZONA)");
            stringBuffer.append(" VALUES ("+ poid +", "+ numRegi +", "+ numDigi +", "+ oidCliente +", "+ lote +", "+ zona +" ) "); //oidZona

            try {
              belcorpService.dbService.executeUpdate(stringBuffer.toString());
            } catch (Exception exception) {
              System.out.println("Excepcion: " + exception);
              throw new MareException (exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          }
        }
      }
  }

  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }
}
