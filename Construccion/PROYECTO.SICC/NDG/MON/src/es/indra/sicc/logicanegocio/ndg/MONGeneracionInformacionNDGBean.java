package es.indra.sicc.logicanegocio.ndg;

/**
 * @author Cortaberria
 * @date 25/10/04
 * Modificacion metodo generarFicherosDeUsuariosNdg, generarFicheroRangoPeriodos
 */
 
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;

import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;
import es.indra.sicc.logicanegocio.intsys.ErroresDeNegocio;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Hashtable;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import es.indra.sicc.ndg.util.InterfacesUtilities;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

public class MONGeneracionInformacionNDGBean implements SessionBean  {

  private int cantidadRegistros = 0;
  private Date fechaHoraInicioProceso;
  //private String  NDG_1 = "NDG_1";
  //private String  NDG_2 = "NDG_2";
  //private String  NDG_3 = "NDG_3";
  //private  String  NDG_4 = "NDG-4";
  
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }

  public void eliminarRegistrosDeUsuarios() throws MareException {
  }

  public void cargarUsuarios() throws MareException {
  }

  public RecordSet obtenerInformacionDeUsuarios(DTOAuditableSICC dto) throws MareException {
  
    BelcorpService belcorpService;
	  String codigoError;
    RecordSet rs ;
    
    try{
      belcorpService = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
      codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
      throw new MareException(serviceNotFoundException,
        UtilidadesError.armarCodigoError(codigoError));
    }
        
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(" SELECT DISTINCT p.NAME, u.CREDENTIAL, p2.stringvalue IND_NDG, p3.stringvalue IND_ADM_NDG  ");
    stringBuffer.append(" FROM PRINCIPALS p, PROPERTYVALUES p1, PROPERTYVALUES p2, PROPERTYVALUES p3, USERS u  ");
    stringBuffer.append(" WHERE p1.idproperty = 36 AND p1.idprincipal = p.idprincipal  ");
    stringBuffer.append(" AND p2.idproperty = 54 AND p2.stringvalue = 'S' "); 
    stringBuffer.append(" AND p2.idprincipal = p.idprincipal  ");
    stringBuffer.append(" AND p3.idproperty = 55 AND p3.idprincipal = p.idprincipal  ");
    stringBuffer.append(" AND u.iduser = p.idprincipal AND p1.STRINGVALUE = '").append(dto.getOidPais()).append("'");
    
    try {
      rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
    } catch (Exception exception) {
      exception.printStackTrace();
      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      throw new MareException(exception, UtilidadesError.armarCodigoError(codigoError));
    }

    return rs;
  }
  
/**
 * @author Mario Bobadilla
 * @date 20/10/04 
 */
 /**
 * @author Cortaberria
 * @date 08/11/04 
 * Invierto la llamda de gestorinterfaces, primero se llama a cerrar y luego a enviar.
 */
  public void generarFicherosDeUsuariosNdg(DTOAuditableSICC dto) throws MareException {
  
    InterfacesUtilities.iniciarActualizacionBuzones();
  
    //System.out.println("Se entro al metodo generarFicherosDeUsuariosNdg del mon MONGeneracionInformacionNGD");
    
    Long pais = dto.getOidPais();
    
    RecordSet rs = obtenerInformacionDeUsuarios(dto);
    if(rs.getRowCount() == 0) {
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(
        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }

    MONGestorInterfacesHome monGIH = null; 
    MONGestorInterfaces monGI = null; 

    try {
      monGIH = getMONGestorInterfacesHome();
      monGI = monGIH.create();
    }catch(Exception e){
      e.printStackTrace();
      
      if(e instanceof MareException) {
        throw (MareException)e;
      } else {
        throw new MareException(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB, e);
      }  
    }
    
    InterfazInfo info = null; 

    try{
      System.out.println("MONGeneracionInformacionNGD antes del crearIntefaz");
      info = monGI.crearInterfaz(ConstantesNDG.NDG_INTERFAZ_USUARIO, pais);
      System.out.println("MONGeneracionInformacionNGD despues de crearIntefaz");
     
      for ( int i = 0; i < rs.getRowCount(); i++ ) { 
        RegistroSicc registro = new RegistroSicc(); 

        registro.anyadirCampo( "ID_USU" , (rs.getValueAt( i, "NAME") != null ? rs.getValueAt( i, "NAME").toString() : "") ); 
        registro.anyadirCampo( "CLAVE" , (rs.getValueAt( i, "CREDENTIAL") != null ? rs.getValueAt( i, "CREDENTIAL").toString() : "") ); 
        registro.anyadirCampo( "IND_NDG" , (rs.getValueAt( i, "IND_NDG") != null ? rs.getValueAt( i, "IND_NDG").toString() : "") ); 
        registro.anyadirCampo( "IND_ADMIN", (rs.getValueAt( i, "IND_ADM_NDG") != null ? rs.getValueAt( i, "IND_ADM_NDG").toString() : "") ); 

        monGI.anyadirRegistro(info, registro);
      } 
      
    }catch(Exception e){
      e.printStackTrace();
      
      if (e instanceof MareException) {
        throw (MareException)e;
      } else {
        throw new MareException(e, UtilidadesError.armarCodigoError(
          CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
      }
    }

    
    try{
      monGI.enviarInterfaz( info );
    }catch(Exception e){
      e.printStackTrace();
      throw new MareException(CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ, e);
    }
    System.out.println("termino el CU");
    
  }

  public File crearArchivo(String nombreArchivo) throws MareException {
    File file = new File(nombreArchivo);
    return file;
  }

  /**
   * Autor: Cortaberría
   * Fecha: 02/11/2004
   * Agrego parametro y armo query
   */
  /**
   * Autor: Cortaberría
   * Fecha: 01/12/2004
   * Modifico sp.COD_PAIS = "+ dto.getPais() por sp.OID_PAIS = "+ dto.getPais()
   */
   /**
   * Autor: Cortaberría
   * Fecha: 17/02/2005
   * Se toman los clientes que correspondan al tipo de solicitud NDG (Cambio sugerido por Vanesa)
   */
   /**
   * Autor: Cortaberría
   * Fecha: 19/02/2005
   * Se toman los clientes cuya fecha de modificación (en GEN_AUDIT) sea mayor o igual a la de 
   * la última vez que se genero el fichero)
   */
   /**
   * Autor: Cortaberría
   * Fecha: 19/02/2005
   * Se elimina la union con la tabla de gen_audit debido a que se creo un nuevo campo en mae_clien
   * que indica la fecha de última modificación o de creación
   * 
   * @cambio OCR-5 solicitado por el cliente en produccion. Se eliminan las validaciones sobre la tabla INT-HISTO-LOTES.
   * @autor gdmarzi(in situ)
   */
  public RecordSet obtenerInformacionConsultoras(DTOInformacionDeFiltrado dto) throws MareException {
  
    RecordSet consultoras ;
    StringBuffer buff = new StringBuffer();

    buff.append(" SELECT sp.COD_PAIS, clien.COD_CLIE, "); 
    buff.append(" clien.VAL_APE1, clien.VAL_APE2, "); 
    buff.append(" clien.VAL_NOM1, clien.VAL_NOM2, ");
    buff.append(" sgv.COD_SUBG_VENT, r.COD_REGI    , ");
    buff.append(" z.COD_ZONA, t.COD_TERR  ");   
    	    
    buff.append(" FROM SEG_PAIS  sp, MAE_CLIEN_DATOS_ADICI datosAdici, ");
    buff.append(" MAE_CLIEN clien, MAE_CLIEN_UNIDA_ADMIN cua, ");
    buff.append(" ZON_TERRI_ADMIN ta, ZON_TERRI t, ");
    buff.append(" ZON_SECCI secc, ZON_ZONA z, ");
    //buff.append(" ZON_REGIO r, ZON_SUB_GEREN_VENTA sgv, ");
    buff.append(" ZON_REGIO r, ZON_SUB_GEREN_VENTA sgv ");
    //buff.append(" MAE_CLIEN_TIPO_SUBTI M , PED_TIPO_SOLIC P ");
    
    buff.append(" WHERE sp.OID_PAIS = "+ dto.getPais());
    buff.append(" AND   sp.OID_PAIS = clien.PAIS_OID_PAIS ");
    buff.append(" AND   datosAdici.IND_ACTI = 1 ");
    buff.append(" AND   datosAdici.CLIE_OID_CLIE = clien.OID_CLIE ");
    buff.append(" AND   clien.OID_CLIE = cua.CLIE_OID_CLIE ");
    buff.append(" AND	  cua.IND_ACTI = 1 ");
    buff.append(" AND   cua.ZTAD_OID_TERR_ADMI = ta.OID_TERR_ADMI ");
    buff.append(" AND   ta.TERR_OID_TERR = t.OID_TERR ");
    buff.append(" AND   ta.ZSCC_OID_SECC = secc.OID_SECC ");
    buff.append(" AND   secc.ZZON_OID_ZONA = z.OID_ZONA ");
    buff.append(" AND   z.ZORG_OID_REGI = r.OID_REGI ");
    buff.append(" AND   r.ZSGV_OID_SUBG_VENT = sgv.OID_SUBG_VENT ");
    buff.append(" AND   sgv.PAIS_OID_PAIS = sp.OID_PAIS ");
    //buff.append(" AND   P.COD_TIPO_SOLI = 'NDG' ");
    //buff.append(" AND	  P.TICL_OID_TIPO_CLIE = M.TICL_OID_TIPO_CLIE ");
    //buff.append(" AND	  M.CLIE_OID_CLIE = clien.OID_CLIE ");

    consultoras = this.getConsulta(buff);
     
    return consultoras;
  }



/**
   * Es el encargado de leer las entidades de MAE para obtener los datos 
   * requeridos de las consultoras Este caso de uso hereda del Caso de uso Generar Fichero de Enviar Consultoras (OCR)
   * @author mbobadill
   * @date 12/11/04
   */
   public void devolverNumeroLoteNDG() throws MareException {
     
   }
   
  /**
   * Es el encargado de leer las entidades de MAE para obtener los datos 
   * requeridos de las consultoras Este caso de uso hereda del Caso de uso Generar Fichero de Enviar Consultoras (OCR)
   * @author mbobadill
   * @date 12/11/04
   */

  public DTOSalidaBatch generarFicheroDeEnviarConsultoras(DTOInformacionDeFiltrado dto) throws MareException {
    
    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicheroDeEnviarConsultoras(DTOInformacionDeFiltrado dto): Entrada");
    UtilidadesLog.debug("- generarFicheroDeEnviarConsultoras");

    //InterfacesUtilities.iniciarActualizacionBuzones();

    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;    
    RegistroSicc registro =  null;
    


    Long pais = dto.getPais();
    
    try{
    
      monGIH = this.getMONGestorInterfacesHome();
      monGI = monGIH.create();
      
    } catch (CreateException cEx)
    {
       UtilidadesLog.error(cEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(cEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (NamingException nEx)
    {
       UtilidadesLog.error(nEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(nEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (InterfacesException iEx)
    {
       UtilidadesLog.error(iEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(iEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (RemoteException rEx)
    {
       UtilidadesLog.error(rEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
    }
    
        UtilidadesLog.debug("Genera InterfazInfo");
    
    InterfazInfo interfazBuffer = new InterfazInfo( IGestorInterfaces.NDG_1,
                                                    dto.getNumeroLote().toString(),
                                                    dto.getOidPais());
                                                    
    InterfazInfo interfazInfo = null;  
    
    try {
       interfazInfo = monGI.crearInterfaz(interfazBuffer);
    } catch (RemoteException rEx)
    {
       UtilidadesLog.error(rEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (InterfacesException iEx)
    {
       UtilidadesLog.error("Excepcion: " + iEx.getMotivo() + " ******* " + iEx.getEx());
       String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));   
    }
      
    RecordSet rs = this.obtenerInformacionConsultoras(dto);     
        
    if(rs.getRowCount() == 0) {
      DTOINTError dtoError = new DTOINTError( interfazInfo, null, ErroresDeNegocio.INT_0032); 
      UtilidadesLog.debug("dtoError ** " + dtoError);
       
       
       
       try {       
          monGI.registrarError(dtoError);
       } catch (InterfacesException iEx)
       {
          UtilidadesLog.error(iEx);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));
       } catch (RemoteException rEx)
       {
          UtilidadesLog.error(rEx);
          String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
       }

       //salimos del metodo*/
       String mensaje = "";
       mensaje = "generarFicheroDeEnviarConsultoras procesado - ";
       return new DTOSalidaBatch( 0, mensaje );

    }
    
    try{
      
            for(int i= 0; i<rs.getRowCount();i++){
              registro = new RegistroSicc();
              if(rs.getValueAt(i,"COD_PAIS")!=null){
                registro.anyadirCampo( "COD_PAIS" , new String(rs.getValueAt( i, "COD_PAIS").toString()) ); 
              }else{
                registro.anyadirCampo("COD_PAIS",new String(""));
              }
      
              if(rs.getValueAt(i,"COD_CLIE")!=null){
                registro.anyadirCampo( "COD_CLIE" , new String(rs.getValueAt( i, "COD_CLIE").toString())); 
              }else{
                registro.anyadirCampo("COD_CLIE",new String(""));
              }
                  
              if(rs.getValueAt(i,"VAL_APE1")!=null){
                registro.anyadirCampo( "VAL_APE1" , new String(rs.getValueAt( i, "VAL_APE1").toString()) ); 
              }else{
                registro.anyadirCampo("VAL_APE1",new String(""));
              }
               
              if(rs.getValueAt(i,"VAL_APE2")!=null){
                registro.anyadirCampo( "VAL_APE2" , new String(rs.getValueAt( i, "VAL_APE2").toString())); 
              }else{
                registro.anyadirCampo("VAL_APE2",new String(""));
              }
                   
              if(rs.getValueAt(i,"VAL_NOM1")!=null){
                registro.anyadirCampo( "VAL_NOM1" , new String(rs.getValueAt( i, "VAL_NOM1").toString())); 
              }else{
                registro.anyadirCampo("VAL_NOM1",new String(""));
              }
                   
              if(rs.getValueAt(i,"VAL_NOM2")!=null){
                registro.anyadirCampo( "VAL_NOM2" ,new String( rs.getValueAt( i, "VAL_NOM2").toString())); 
              }else{
                registro.anyadirCampo("VAL_NOM2",new String(""));
              }
                   
              if(rs.getValueAt(i,"COD_SUBG_VENT")!=null){
                registro.anyadirCampo( "COD_SUBG_VENT" , new String(rs.getValueAt( i, "COD_SUBG_VENT").toString()) ); 
              }else{
                registro.anyadirCampo("COD_SUBG_VENT",new String(""));
              }
                   
              if(rs.getValueAt(i,"COD_REGI")!=null){
                registro.anyadirCampo( "COD_REGI" , new String(rs.getValueAt( i, "COD_REGI").toString()) ); 
              }else{
                registro.anyadirCampo("COD_REGI",new String(""));
              }
                   
              if(rs.getValueAt(i,"COD_ZONA")!=null){
                registro.anyadirCampo( "COD_ZONA" , new String(rs.getValueAt( i, "COD_ZONA").toString()) ); 
              }else{
                registro.anyadirCampo("COD_ZONA",new String(""));
              }
                   
              if(rs.getValueAt(i,"COD_TERR")!=null){
                registro.anyadirCampo( "COD_TERR" , new String(rs.getValueAt( i, "COD_TERR").toString()) ); 
              }else{
                registro.anyadirCampo("COD_TERR",new String(""));
              }
                                 
              UtilidadesLog.info("registro ******************* " + registro.toString());
              monGI.anyadirRegistro(interfazInfo, registro);
            }
     
    } catch(InterfacesException iEx) 
            {
                                  
                DTOINTError dtoError = new DTOINTError( interfazInfo, 
                                                        registro, 
                                                        ErroresDeNegocio.INT_0012);                                        
                                                                                                                
                try {
                   monGI.registrarError(dtoError);
                } catch (InterfacesException iEx2)
                {
                   UtilidadesLog.error(iEx2);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
                } catch (RemoteException rEx)
                {
                   UtilidadesLog.error(rEx);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
                } 
              
            } catch (RemoteException rEx)
            {
              UtilidadesLog.error(rEx);
              String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
            }
        
    try {
        monGI.enviarInterfaz(interfazInfo);
    } catch ( InterfacesException iex)
    {
        
        DTOINTError dtoError = new DTOINTError(interfazInfo, registro, ErroresDeNegocio.INT_0009);
        
        UtilidadesLog.error("dtoError :: " + dtoError);
        
        try {
          monGI.registrarError(dtoError);
        } catch (InterfacesException iEx2)
        {
          UtilidadesLog.error(iEx2);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
        } catch (RemoteException rEx)
        {
          UtilidadesLog.error(rEx);  
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
        } 
    } catch ( RemoteException rEx)
    {
        UtilidadesLog.error(rEx);
        String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (MareException mEx)
    {
      throw mEx;
    }
    
    String mensaje = new String();
    mensaje = "generarFicheroDeEnviarConsultoras procesado - ";

    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicheroDeEnviarConsultoras(DTOInformacionDeFiltrado dto): Salida");
    return new DTOSalidaBatch(0, mensaje);    
  }    
    
  
  
/**
 * @author Mario Bobadilla
 * @date 20/10/04 
 */
  public DTOSalida obtenerInformacionCriteriosDeSeleccion(DTOInformacionDeFiltrado dto) throws MareException {
    StringBuffer buff = new StringBuffer();
    buff.append(" SELECT m.OID_MARC ,m.COD_MARC ,c.OID_CANA ,c.COD_CANA ,a.OID_ACCE ,a.COD_ACCE ,cp.PERI_OID_PERI ,cp.VAL_NOMB_PERI   ");
    buff.append(" FROM VCA_SEG_PAIS p, VCA_SEG_MARCA m, VCA_SEG_CANAL c, VCA_SEG_ACCES a, CRA_PERIO cp ");
    buff.append(" WHERE p.OID_PAIS = " + dto.getPais() );
    buff.append(" AND p.COD_USUA = " + "'" + dto.getCodUsuario() + "'");
    buff.append(" AND p.COD_USUA = m.COD_USUA  ");
    buff.append(" AND p.COD_USUA = c.COD_USUA "); 
    buff.append(" AND p.COD_USUA = a.COD_USUA  ");
    buff.append(" AND c.OID_CANA = a.CANA_OID_CANA ");
    buff.append(" AND cp.MARC_OID_MARC = m.OID_MARC ");
    buff.append(" AND cp.CANA_OID_CANA = c.OID_CANA ");
    buff.append(" AND cp.ACCE_OID_ACCE = a.OID_ACCE ");
    buff.append(" AND cp.PAIS_OID_PAIS = p.OID_PAIS ");
    RecordSet rs = this.getConsulta(buff);
    DTOSalida out = new DTOSalida();
    out.setResultado(rs);
    return out;

  }
  
  public DTOSalidaBatch generarFicherosMatrizDePreciosBatch(DTOInformacionDeFiltrado dtoInformacionDeFiltrado) throws MareException {
  UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicherosMatrizDePreciosBatch(DTOInformacionDeFiltrado dtoInformacionDeFiltrado): Entrada");
  DTOSalidaBatch dtoSalidaBatch = null;
  try{
   
    String mensaje = null;    
    String nombre = "Generar Fichero Matriz de Precios";
    MareBusinessID IDOnline = new MareBusinessID("NDGGenerarFicherosMatrizPrecios");
   
    IMareDTO DTOOnline = (IMareDTO)dtoInformacionDeFiltrado;
    
    
    DTOBatch dtoBach = new DTOBatch(nombre,IDOnline,DTOOnline);   
    
    MareBusinessID IDProceso = new MareBusinessID("INTProcesoInterfaces");
    
    UtilidadesLog.debug("Antes de BatchUtil.executeMLN"); 
    BatchUtil.executeMLN(dtoBach,IDProceso);
    
    mensaje += "Generar Fichero Matriz de precios - ";
    UtilidadesLog.debug("Luego de BatchUtil.executeMLN");
    
    dtoSalidaBatch = new DTOSalidaBatch(0, mensaje);
    UtilidadesLog.debug("dtoSalidaBatch: " + dtoSalidaBatch);    
    
   }catch (RemoteException e){
         UtilidadesLog.error(e);
   }
   
   UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicherosMatrizDePreciosBatch(DTOInformacionDeFiltrado dtoInformacionDeFiltrado): Salida");
   return dtoSalidaBatch;  
   }
  
  
/**
 * @author Mario Bobadilla
 * @date 20/10/04
 */
//public DTOSalidaBatch generarFicherosMatrizDePrecios(DTOInformacionDeFiltrado dtoInformacionDeFiltrado) throws MareException {
  public DTOSalidaBatch generarFicherosMatrizDePrecios(DTOBatch dto) throws MareException {
    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicherosMatrizDePrecios(DTOInformacionDeFiltrado dtoInformacionDeFiltrado): Entrada");
    UtilidadesLog.debug("- generarFicherosMatrizDePrecios");

    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;    
    RegistroSicc registro =  null;
    
    //Long pais = dtoInformacionDeFiltrado.getPais();
    
    try{
      monGIH = getMONGestorInterfacesHome(); 
      monGI = monGIH.create(); 
    }catch (CreateException cEx)
    {
       UtilidadesLog.error(cEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(cEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (NamingException nEx)
    {
       UtilidadesLog.error(nEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(nEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (InterfacesException iEx)
    {
       UtilidadesLog.error(iEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(iEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (RemoteException rEx)
    {
       UtilidadesLog.error(rEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
    }
    
    UtilidadesLog.debug("Genera InterfazInfo");
    DTOInformacionDeFiltrado dtoInformacionDeFiltrado = (DTOInformacionDeFiltrado) dto.getDTOOnline();
    InterfazInfo interfazBuffer = new InterfazInfo( IGestorInterfaces.NDG_2,
                                                    dtoInformacionDeFiltrado.getNumeroLote().toString(),
                                                    dtoInformacionDeFiltrado.getPais());
                                                    
    InterfazInfo interfazInfo = null;  

    try {
           interfazInfo = monGI.crearInterfaz(interfazBuffer);
        } catch (RemoteException rEx)
        {
           UtilidadesLog.error(rEx);
           String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
        } catch (InterfacesException iEx)
        {
           UtilidadesLog.error("Excepcion: " + iEx.getMotivo() + " ******* " + iEx.getEx());
           String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));   
        }
        
    RecordSet rs = obtenerInformacionMatrizPrecios( dtoInformacionDeFiltrado );     
    
    if(rs.getRowCount() == 0) {
      DTOINTError dtoError = new DTOINTError( interfazInfo, null, ErroresDeNegocio.INT_0032); 
      UtilidadesLog.debug("dtoError ** " + dtoError);
       
       try {       
          monGI.registrarError(dtoError);
       } catch (InterfacesException iEx)
       {
          UtilidadesLog.error(iEx);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));
       } catch (RemoteException rEx)
       {
          UtilidadesLog.error(rEx);
          String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
       }

       //salimos del metodo*/
       String mensaje = "";
       mensaje = "generarFicherosMatrizDePrecios procesado - ";
       return new DTOSalidaBatch( 0, mensaje );

    }
    
    
    try{      
      
          for ( int i = 0; i < rs.getRowCount(); i++ ) { 
            registro = new RegistroSicc();
            
            if( rs != null && rs.getValueAt(i,"COD_PAIS") != null && !rs.getValueAt(i,"COD_PAIS").equals("")){
              registro.anyadirCampo( "COD_PAIS" , rs.getValueAt(i,"COD_PAIS") ); 
            }else{
              registro.anyadirCampo( "COD_PAIS" , new String("") );
            }
    
            if( rs != null && rs.getValueAt(i,"COD_PERI") != null && !rs.getValueAt(i,"COD_PERI").equals("")){
              registro.anyadirCampo( "COD_PERI" , rs.getValueAt( i, "COD_PERI") ); 
            }else{
              registro.anyadirCampo( "COD_PERI" , new String("") );
            }
    
            if( rs != null && rs.getValueAt(i,"VAL_CODI_VENT") != null && !rs.getValueAt(i,"VAL_CODI_VENT").equals("")){
              registro.anyadirCampo( "VAL_CODI_VENT" , rs.getValueAt( i, "VAL_CODI_VENT") ); 
            }else{
              registro.anyadirCampo( "VAL_CODI_VENT" , new String("") );
            }
        
              UtilidadesLog.info("registro ******************* " + registro.toString());
              monGI.anyadirRegistro(interfazInfo, registro);
            }
     
    } catch(InterfacesException iEx) 
            {
                                  
                DTOINTError dtoError = new DTOINTError( interfazInfo, 
                                                        registro, 
                                                        ErroresDeNegocio.INT_0012);                                        
                                                                                                                
                try {
                   monGI.registrarError(dtoError);
                } catch (InterfacesException iEx2)
                {
                   UtilidadesLog.error(iEx2);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
                } catch (RemoteException rEx)
                {
                   UtilidadesLog.error(rEx);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
                } 
              
            } catch (RemoteException rEx)
            {
              UtilidadesLog.error(rEx);
              String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
            }

    try {
        monGI.enviarInterfaz(interfazInfo);
    } catch ( InterfacesException iex)
    {
        
        DTOINTError dtoError = new DTOINTError(interfazInfo, registro, ErroresDeNegocio.INT_0009);
        
        UtilidadesLog.error("dtoError :: " + dtoError);
        
        try {
          monGI.registrarError(dtoError);
        } catch (InterfacesException iEx2)
        {
          UtilidadesLog.error(iEx2);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
        } catch (RemoteException rEx)
        {
          UtilidadesLog.error(rEx);  
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
        } 
    } catch ( RemoteException rEx)
    {
        UtilidadesLog.error(rEx);
        String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (MareException mEx)
    {
      throw mEx;
    }
    
    String mensaje = new String();
    mensaje = "generarFicheroDeEnviarConsultoras procesado - ";

    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicheroDeEnviarConsultoras(DTOInformacionDeFiltrado dto): Salida");
    return new DTOSalidaBatch(0, mensaje);    
  }
  
/**
 * @ author Mario Bobadilla
 * @date 20/10/04
 */
 /**
 * Autor Cortaberria
 * Fecha 20/11/04
 * Modifico query
 */
 //mmaidana 24/02/05 correcion de query
  /**
 * Autor Cortaberria
 * Fecha 23/05/05
 * Modificación a query segun lo hablado con Carlos Falco
 */
  public RecordSet obtenerInformacionMatrizPrecios(DTOInformacionDeFiltrado dto) throws MareException{
       
    StringBuffer buff = new StringBuffer();

    buff.append("SELECT DISTINCT PAIS.COD_PAIS AS COD_PAIS, OFERT_DETAL.VAL_CODI_VENT AS VAL_CODI_VENT, PERIO_CORPO.COD_PERI AS COD_PERI ");
    buff.append("FROM CRA_PERIO PERIO, ");
    buff.append("CRA_PERIO INI, ");
    buff.append("CRA_PERIO FIN, ");
    buff.append("PRE_MATRI_FACTU_CABEC FACTU_CABEC, ");
    buff.append("PRE_OFERT OFERT, ");
    buff.append("PRE_OFERT_DETAL OFERT_DETAL, ");
    buff.append("SEG_PAIS PAIS, ");
    buff.append("SEG_PERIO_CORPO PERIO_CORPO ");
    buff.append("WHERE ");
    buff.append("INI.PAIS_OID_PAIS = " + dto.getPais() + " AND ");
    buff.append("INI.MARC_OID_MARC = " + dto.getOidMarca() + " AND ");
    buff.append("INI.CANA_OID_CANA = " + dto.getOidCanal() + " AND ");
    buff.append("FIN.PAIS_OID_PAIS = " + dto.getPais() + " AND ");
    buff.append("FIN.MARC_OID_MARC = " + dto.getOidMarca() + " AND ");
    buff.append("FIN.CANA_OID_CANA = " + dto.getOidCanal() + " AND ");
    buff.append("PERIO.PAIS_OID_PAIS = " + dto.getPais() + " AND ");
    buff.append("PERIO.MARC_OID_MARC = " + dto.getOidMarca() + " AND ");
    buff.append("PERIO.CANA_OID_CANA = " + dto.getOidCanal() + " AND ");
    buff.append("PAIS.OID_PAIS = PERIO.PAIS_OID_PAIS AND ");
    buff.append("PERIO_CORPO.OID_PERI = PERIO.PERI_OID_PERI AND ");
    buff.append("INI.FEC_INIC <= PERIO.FEC_INIC AND ");
    buff.append("FIN.FEC_FINA >= PERIO.FEC_FINA AND ");
    buff.append("FACTU_CABEC.PERD_OID_PERI = PERIO.OID_PERI AND ");
    buff.append("OFERT.MFCA_OID_CABE = FACTU_CABEC.OID_CABE AND ");
    buff.append("OFERT_DETAL.OFER_OID_OFER = OFERT.OID_OFER AND ");
    buff.append("OFERT_DETAL.IND_DIGI = 1 AND ");
    buff.append("INI.OID_PERI = " + dto.getOidPeriodoDesde().toString() + " AND ");
    
    if(dto.getOidPeriodoHasta() == null){
      buff.append("FIN.OID_PERI = " + dto.getOidPeriodoDesde().toString() + " AND ");
    }else{
      buff.append("FIN.OID_PERI = " + dto.getOidPeriodoHasta().toString() + " AND ");
    }
    
    buff.append("OFERT_DETAL.VAL_CODI_VENT IS NOT NULL ");

    /**
     * Autor Cortaberria
     * Se agrega la condicion de que el codigo de venta sea distinto de null
     * ya que puede traer campos vacios.
     */        
    //buff.append(" AND a.val_codi_vent IS NOT NULL");

    RecordSet rs = getConsulta(buff);
    
    //System.out.println("RecordSet matriz precios: " + rs.toString());
    
    return rs;
  }


 /**
 * @author Cortaberria
 * @date 08/11/04 
 * Invierto la llamda de gestorinterfaces, primero se llama a cerrar y luego a enviar.
 */
  public DTOSalidaBatch generarFicheroRangoPeriodos(DTOInformacionDeFiltrado dtoInformacionDeFiltrado) throws MareException {
    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicheroRangoPeriodos(DTOInformacionDeFiltrado dtoInformacionDeFiltrado): Entrada");
    UtilidadesLog.debug("- generarFicheroRangoPeriodos");

    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;    
    RegistroSicc registro =  null;
    
    Long pais = dtoInformacionDeFiltrado.getPais();

    
    try{
      monGIH = getMONGestorInterfacesHome(); 
      monGI = monGIH.create(); 
    }catch (CreateException cEx)
    {
       UtilidadesLog.error(cEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(cEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (NamingException nEx)
    {
       UtilidadesLog.error(nEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(nEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (InterfacesException iEx)
    {
       UtilidadesLog.error(iEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(iEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (RemoteException rEx)
    {
       UtilidadesLog.error(rEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
    }
    
    UtilidadesLog.debug("Genera InterfazInfo");
    
    InterfazInfo interfazBuffer = new InterfazInfo( ConstantesNDG.NDG_INTERFAZ_PERIODO,
                                                    dtoInformacionDeFiltrado.getNumeroLote().toString(),
                                                    dtoInformacionDeFiltrado.getPais());
                                                    
    InterfazInfo interfazInfo = null;  
    
    try {
           interfazInfo = monGI.crearInterfaz(interfazBuffer);
        } catch (RemoteException rEx)
        {
           UtilidadesLog.error(rEx);
           String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
        } catch (InterfacesException iEx)
        {
           UtilidadesLog.error("Excepcion: " + iEx.getMotivo() + " ******* " + iEx.getEx());
           String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));   
        }
        
    RecordSet rs =  this.obtenerInformacionRangoPeriodos(dtoInformacionDeFiltrado);
    
     if(rs.getRowCount() == 0) {
      DTOINTError dtoError = new DTOINTError( interfazInfo, null, ErroresDeNegocio.INT_0032); 
      UtilidadesLog.debug("dtoError ** " + dtoError);
       
       try {       
          monGI.registrarError(dtoError);
       } catch (InterfacesException iEx)
       {
          UtilidadesLog.error(iEx);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx, UtilidadesError.armarCodigoError(codigoError));
       } catch (RemoteException rEx)
       {
          UtilidadesLog.error(rEx);
          String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
       }

       //salimos del metodo*/
       String mensaje = "";
       mensaje = "generarFicheroRangoPeriodos procesado - ";
       return new DTOSalidaBatch( 0, mensaje );

    }
   
    if (rs == null || rs.esVacio()) {
      throw new MareException(new Exception(), UtilidadesError.armarCodigoError(
        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    
    

    try{
        for ( int i = 0; i < rs.getRowCount(); i++ ) {
          registro = new RegistroSicc(); 
          
          if( rs != null && rs.getValueAt(i,"COD_PAIS") != null && !rs.getValueAt(i,"COD_PAIS").equals("")){
              registro.anyadirCampo( "PAIS" , rs.getValueAt( i, "COD_PAIS") );
          }else{
              registro.anyadirCampo( "PAIS" , new String("") );
          }

          Object codPeriIni = rs.getValueAt(i, "COD_PERI");
          
          //por incidencia BELC300012774 se pone que periodo inicial y final sea el mismo
          registro.anyadirCampo( "CODIGOINICIAL" , (codPeriIni != null ? codPeriIni.toString() : "") ); 
          registro.anyadirCampo( "CODIGOFINAL" , (codPeriIni != null ? codPeriIni.toString() : "") ); 
          //registro.anyadirCampo( "CODIGOFINAL" , (codPeriFin != null ? codPeriFin.toString() : "") ); 
          
          
          UtilidadesLog.debug("la fecha es del tipo: " + rs.getValueAt( i, "FEC_INIC").getClass());
          UtilidadesLog.debug("la fecha quedo SQL: " + (( java.sql.Date ) rs.getValueAt( i, "FEC_INIC")).toString());
          UtilidadesLog.debug("la fecha quedo: " + (( Date ) rs.getValueAt( i, "FEC_INIC")).toString());
          
          if (rs.getValueAt( i, "FEC_INIC") != null) {
            registro.anyadirCampo( "FECHA_FACTURACION" , ( Date ) rs.getValueAt( i, "FEC_INIC") );
          } else {
            registro.anyadirCampo( "FECHA_FACTURACION" , "" );
          }
          
          UtilidadesLog.debug("despues de añadir: " + registro.obtenerCampo("FECHA_FACTURACION"));
          monGI.anyadirRegistro(interfazInfo, registro);
      } 
      
    } catch(InterfacesException iEx) 
            {
                                  
                DTOINTError dtoError = new DTOINTError( interfazInfo, 
                                                        registro, 
                                                        ErroresDeNegocio.INT_0012);                                        
                                                                                                                
                try {
                   monGI.registrarError(dtoError);
                } catch (InterfacesException iEx2)
                {
                   UtilidadesLog.error(iEx2);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
                } catch (RemoteException rEx)
                {
                   UtilidadesLog.error(rEx);
                   String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                   throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
                } 
              
            } catch (RemoteException rEx)
            {
              UtilidadesLog.error(rEx);
              String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
            }

    try {
        monGI.enviarInterfaz(interfazInfo);
    } catch ( InterfacesException iex)
    {
        
        DTOINTError dtoError = new DTOINTError(interfazInfo, registro, ErroresDeNegocio.INT_0009);
        
        UtilidadesLog.error("dtoError :: " + dtoError);
        
        try {
          monGI.registrarError(dtoError);
        } catch (InterfacesException iEx2)
        {
          UtilidadesLog.error(iEx2);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(iEx2, UtilidadesError.armarCodigoError(codigoError) );
        } catch (RemoteException rEx)
        {
          UtilidadesLog.error(rEx);  
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigoError) );
        } 
    } catch ( RemoteException rEx)
    {
        UtilidadesLog.error(rEx);
        String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException (rEx, UtilidadesError.armarCodigoError(codigosError));
    } catch (MareException mEx)
    {
      throw mEx;
    }
    
    String mensaje = new String();
    mensaje = "generarFicheroRangoPeriodos procesado - ";

    UtilidadesLog.info("MONGeneracionInformacionNDGBean.generarFicheroRangoPeriodos(DTOInformacionDeFiltrado dto): Salida");
    return new DTOSalidaBatch(0, mensaje);    
}



  /**
   * Autor: Cortaberría
   * Fecha: 02/11/2004
   * Agrego parametro y armo query
   */
  /**
   * Autor: Cortaberría
   * Fecha: 03/11/2004
   * Modifico query
   */
  /**
   * Autor: Cortaberría
   * Fecha: 26/01/2005
   * Oid Acceso paso a ser opcional
   */
   /**
   * Autor: Cortaberría
   * Fecha: 03/05/2005
   * Se agrega to_char en la comparacion de las fechas, ya que en la base de datos 10G se colgaba
   */
  public RecordSet obtenerInformacionRangoPeriodos(DTOInformacionDeFiltrado dto) throws MareException {
  
    RecordSet consultoras ;
    StringBuffer query = new StringBuffer();
    RecordSet rs = null;
    
    query.append("SELECT DISTINCT SEGPERI.COD_PERI AS COD_PERI, CRONO.FEC_INIC AS FEC_INIC, sp.COD_PAIS ");
    query.append("FROM CRA_PERIO PERI, CRA_PERIO INICIO, CRA_PERIO FINAL, CRA_CRONO CRONO, CRA_ACTIV ACTIV, CRA_CLASE_ACTIV CLASE, ");
    query.append("SEG_PERIO_CORPO SEGPERI, SEG_PAIS  sp ");
    query.append("WHERE INICIO.pais_oid_pais = " + dto.getPais() + " AND ");
    //aGREGADO POR PZERBINO PARA TRAIGA EL COD DE PAIS
    query.append("sp.OID_PAIS = " + dto.getPais() + " AND ");
    query.append("sp.OID_PAIS = FINAL.pais_oid_pais AND ");
    query.append("peri.pais_oid_pais = " + dto.getPais() + " AND ");
    query.append("INICIO.cana_oid_cana = " + dto.getOidCanal() + " AND ");
    query.append("INICIO.marc_oid_marc = " + dto.getOidMarca() + " AND ");

    if(dto.getOidAcceso() != null) {
      query.append( "INICIO.ACCE_OID_ACCE = " + dto.getOidAcceso() + " AND ");
    }

    query.append("INICIO.VAL_ESTA = 1 AND ");
    query.append("FINAL.pais_oid_pais = " + dto.getPais() + " AND ");
    query.append("FINAL.cana_oid_cana = " + dto.getOidCanal() + " AND ");
    query.append("FINAL.marc_oid_marc = " + dto.getOidMarca() + " AND ");

    if (dto.getOidAcceso() != null) {
      query.append( "FINAL.ACCE_OID_ACCE = " + dto.getOidAcceso() + " AND ");
    }

    query.append("FINAL.VAL_ESTA = 1 AND ");
    query.append("INICIO.FEC_INIC <= PERI.FEC_INIC AND ");
    query.append("FINAL.FEC_FINA >= PERI.FEC_FINA AND ");
    query.append("INICIO.oid_peri = " + dto.getOidPeriodoDesde() + " AND ");

    if(dto.getOidPeriodoHasta() == null ) {
      query.append("FINAL.oid_peri = " + dto.getOidPeriodoDesde() +  " AND ");
    }else{
      query.append("FINAL.oid_peri = " + dto.getOidPeriodoHasta() + " AND ");
    }

    query.append("SEGPERI.OID_PERI = PERI.PERI_OID_PERI AND ");
    query.append("CRONO.PERD_OID_PERI =  PERI.OID_PERI AND ");
    query.append("CLASE.COD_CLAS_ACTI LIKE 'FAC' AND ");
    query.append("CRONO.CACT_OID_ACTI = ACTIV.OID_ACTI AND ");
    query.append("ACTIV.CLAC_OID_CLAS_ACTI = CLASE.OID_CLAS_ACTI AND ");
    query.append("to_char( CRONO.FEC_INIC ) = to_char( (SELECT MAX(CRO.FEC_INIC) ");
    query.append("FROM CRA_CRONO CRO, CRA_ACTIV CACTIV, CRA_CLASE_ACTIV CCACTIV ");
    query.append("WHERE CCACTIV.COD_CLAS_ACTI LIKE 'FAC' AND ");
    query.append("CRO.CACT_OID_ACTI = CACTIV.OID_ACTI AND ");
    query.append("CACTIV.CLAC_OID_CLAS_ACTI = CCACTIV.OID_CLAS_ACTI AND ");
    query.append("CRO.PERD_OID_PERI = PERI.OID_PERI))");

    System.out.println("query: " + query);

    rs = this.getConsulta(query);

    return rs;
  }

  public String getNombreArchivo(int n) throws MareException {
    String nombreArchivo = "";
    Date fecha_sistema = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
     
    switch(n){
      case 0:
        nombreArchivo = "NDG_1" + formato.format(fecha_sistema);
        break ;
      case 1:
        nombreArchivo = "NDG_2" + formato.format(fecha_sistema);
        break ;
      case 2:
        nombreArchivo = "NDG_3" + formato.format(fecha_sistema);
        break ;
      case 3:
        nombreArchivo = "USUARIOS" + formato.format(fecha_sistema);
        break ;
      
    }
    return nombreArchivo;
  }


  private RecordSet getConsulta(StringBuffer buff)throws MareException{
  
    RecordSet rs = null ;
    BelcorpService belcorpService = null;
    
    try{
      belcorpService = BelcorpService.getInstance();
    } catch (Exception e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(
        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
        
    try {
      rs = belcorpService.dbService.executeStaticQuery(buff.toString());
      
      return rs;
      
    } catch (Exception e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(
        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
  }

  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestorInterfacesHome)PortableRemoteObject.narrow(
      context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

}
