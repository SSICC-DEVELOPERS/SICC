package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Hashtable;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.intsys.DTOClienteFechaFinPeriodo;
import es.indra.sicc.dtos.intsys.DTOAtributo;
import es.indra.sicc.dtos.intsys.DTOINTEnviarInfCliente;
import es.indra.sicc.dtos.intsys.DTOINT;

import java.math.BigDecimal;

import es.indra.sicc.dtos.intsys.DTOInfoCliente;
import es.indra.sicc.dtos.intsys.DTOVentasGis;
import es.indra.sicc.dtos.intsys.DTODatosAdicionales;
import es.indra.sicc.dtos.intsys.DTOEnvio;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;


import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
//import es.indra.sicc.logicanegocio.ccc.IServiceCCC;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;

import es.indra.sicc.logicanegocio.ccc.IServiceCCC;
import es.indra.sicc.logicanegocio.intsys.ErroresDeNegocio;




import es.indra.sicc.logicanegocio.intsys.DAOInfCliente;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGisBean implements SessionBean
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }
  
  
   /**
   * @Author: pcabrera, 16/2/2005
   * Se obtiene a partir de un DTOINTEnviarInfCliente un dtoBatch  
   * 06/05/2005 - rgiorgi - se eliminaron los UtilidadesLog.debug 
   *                      - se formatearon algunas lineas
   *                      - se corrigió el error de registros duplicados.
   */

  public DTOSalidaBatch enviarInfoClienteBatch(DTOINTEnviarInfCliente dto) throws MareException
  {
      /*   
        String mensaje 

      // Se invoca al caso de uso "Enviar Informacion Cliente", en modo batch 
      DTOBatch dtoBatch = new DTOBatch( nombre = "Enviar Informacion Cliente", 
      IDOnline = "INTEnviarInformacionCliente", 
      DTOOnline = dtoe ) 
      
      BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 
      
      mensaje += "Enviar Informacion del Cliente procesado - "    } 
       Retornar new DTOSalidaBatch( 0, mensaje )

    */
  UtilidadesLog.info("MONGisBean.enviarInfoClienteBatch(DTOINTEnviarInfCliente dto): Entrada");
  DTOSalidaBatch dtoSalidaBatch = null;
  try{
   
    String mensaje = null;    
    String nombre = "Enviar Informacion Cliente";
    MareBusinessID IDOnline = new MareBusinessID("INTEnviarInformacionCliente");
   
    IMareDTO DTOOnline = (IMareDTO)dto;
    
    
    DTOBatch dtoBach = new DTOBatch(nombre,IDOnline,DTOOnline);   
    
    MareBusinessID IDProceso = new MareBusinessID("INTProcesoInterfaces");
    
    UtilidadesLog.debug("Antes de BatchUtil.executeMLN"); 
    BatchUtil.executeMLN(dtoBach,IDProceso);
    
    mensaje += "Enviar Informacion del Cliente procesado - ";
    UtilidadesLog.debug("Luego de BatchUtil.executeMLN");
    
    dtoSalidaBatch = new DTOSalidaBatch(0, mensaje);
    UtilidadesLog.debug("dtoSalidaBatch: " + dtoSalidaBatch);    
    
   }catch (RemoteException e){
         UtilidadesLog.error(e);
   }
   
   UtilidadesLog.info("MONGisBean.enviarInfoClienteBatch(DTOINTEnviarInfCliente dto): Salida");
   return dtoSalidaBatch;  
   }


  /**
   * @Author: ssantana, 16/2/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return ArrayList
   * @param Long oidPeriodo
   * @param ArrayList ListaOids
   * 
   * 10-05-2005 - rgiorgi: por inc. 16837 se modifica el calculo del atributo 06.
   */
  public ArrayList consultarSaldo(ArrayList ListaOids, Long oidPeriodo, Long oidPais) throws MareException
  {
    UtilidadesLog.info("MONGisBean.consultarSaldo(ArrayList ListaOids, Long oidPeriodo, Long oidPais): Entrada");

    MONInterfaceModulosHome monInterfazHome = null;
    MONInterfaceModulos monInterfaz = null;
    PeriodoLocalHome pLHome = null;
    PeriodoLocal pLocal = null;
    PeriodoCorporativoLocalHome pcLHome = null;
    PeriodoCorporativoLocal pcLocal = null;
    
    SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
    java.sql.Date sqlDate = null;
    ArrayList clienteFechaFinPeriodo = null;
    ArrayList aRetorno = new ArrayList();
    DTOTotal dtoTotal = null;

   
    try {
      monInterfazHome = this.getMONInterfaceModulosHome();
      monInterfaz = monInterfazHome.create();
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
    } catch (RemoteException rEx)
    {
       UtilidadesLog.error(rEx);
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
    }
    
    // Se crea una fechaDesde inicializada a 1/1/1900    
    try {
      java.util.Date utilDate = simpleDate.parse("01/01/1900");
      sqlDate = new java.sql.Date(utilDate.getTime());
    } catch (ParseException pEx)
    {
      UtilidadesLog.error(pEx);
      String codigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
      throw new MareException(pEx,  UtilidadesError.armarCodigoError(codigosError));
    }
    
    Date fechaDesde = sqlDate;
    DTOSaldosPorFechasyVtos dtoSaldo = new DTOSaldosPorFechasyVtos();

    try {
        pLHome = getPeriodoLocalHome();
        pcLHome = getPeriodoCorporativoLocalHome();
        
        pLocal = pLHome.findByPrimaryKey(oidPeriodo);
        pcLocal  = pcLHome.findByPrimaryKey( pLocal.getOidPeriodoCorporativo());
        
    } catch (NoResultException fe) {
       UtilidadesLog.debug(fe);       
       String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       throw new MareException(fe, UtilidadesError.armarCodigoError(codigosError));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    
    for (int i = 0; i < ListaOids.size(); i++){
        
        Long nOidCliente = (Long) ListaOids.get(i);
        DTOAtributo dtoAtributo = new DTOAtributo();

        dtoSaldo.setOidCliente(nOidCliente);
        dtoSaldo.setFechaVtoDesde(fechaDesde);
        dtoSaldo.setFechaVtoHasta(pLocal.getFechaFin() );
        dtoSaldo.setOidPais(oidPais);
                
        try {
          dtoTotal = monInterfaz.calcularSaldoCCCliente(dtoSaldo);
        } catch (RemoteException rEx)
        {
          UtilidadesLog.error(rEx);
          String codigosError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(rEx, UtilidadesError.armarCodigoError(codigosError));
        }
        
        BigDecimal bigSaldo = dtoTotal.getTotal();
                
        dtoAtributo.setOidCliente(nOidCliente);
        dtoAtributo.setCodAcceso(null);
        dtoAtributo.setCodPeriodo(pcLocal.getCodigoPeriodo());
        dtoAtributo.setCodAtributo(ConstantesINT.COD_ATRIBUTO6);
        dtoAtributo.setValorAtributo(bigSaldo.toString());
        
        aRetorno.add(dtoAtributo);

    }
    UtilidadesLog.info("MONGisBean.consultarSaldo(ArrayList ListaOids, Long oidPeriodo, Long oidPais): Salida");
    return aRetorno;
  }

/** vconte - Se cambia el nombre del parámetro ListaAtributo3 
 * por ListaAtributo4 (BELC300022766)
  *
 */
  public ArrayList formarListaEnvio(ArrayList ListaClientes, ArrayList ListaAtributo1, 
                                    ArrayList ListaAtributo4, ArrayList ListaAtributo5, 
                                    ArrayList ListaAtributo6, ArrayList ListaVenta, 
                                    ArrayList ListaDatosAdicionales) throws MareException
  {

    UtilidadesLog.info("MONGisBean.formarListaEnvio(ArrayList ListaClientes, ArrayList ListaAtributo1, ArrayList ListaAtributo3, ArrayList ListaAtributo5, ArrayList ListaAtributo6, ArrayList ListaVenta, ArrayList ListaDatosAdicionales): Entrada");

    DTOInfoCliente dtoDatosCliente = null;
    DTOAtributo dtoAtributo = null;
    DTOVentasGis dtoVenta = null;
    DTODatosAdicionales dtoDatosAdic = null;
    ArrayList aList = new ArrayList();   
  
    UtilidadesLog.debug("ListaClientes mide: " + ListaClientes.size());
    
    for (int i = 0; i < ListaClientes.size(); i++)
    {
      
      DTOEnvio dtoEnvio = new DTOEnvio();
      dtoDatosCliente = (DTOInfoCliente) ListaClientes.get(i);
      
      UtilidadesLog.debug("viendo cliente (DTOInfoCliente.oidCliente): " + dtoDatosCliente.getOidCliente());
      
      dtoEnvio.setOidCliente(dtoDatosCliente.getOidCliente());
      dtoEnvio.setCodMarca(dtoDatosCliente.getCodMarca());
      dtoEnvio.setCodCanal(dtoDatosCliente.getCodCanal());
      dtoEnvio.setCodPais(dtoDatosCliente.getCodPais());
      dtoEnvio.setCodSGV(dtoDatosCliente.getCodSGV());
      dtoEnvio.setCodRegion(dtoDatosCliente.getCodRegion());
      dtoEnvio.setCodZona(dtoDatosCliente.getCodZona());
      dtoEnvio.setCodSeccion(dtoDatosCliente.getCodSeccion());
      dtoEnvio.setCodTerritorio(dtoDatosCliente.getCodTerritorio());
      dtoEnvio.setCodCliente(dtoDatosCliente.getCodCliente()); 

      dtoEnvio.setAtributos(new ArrayList());
      
      dtoEnvio.setAtributos(this.aniadirAtributoA( dtoEnvio.getAtributos(), 
                                                   ListaAtributo1, 
                                                   dtoDatosCliente.getOidCliente() ));
                                                   
      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(),
                                                   ListaVenta,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO2));
                                                   
      dtoEnvio.setAtributos(this.aniadirAtributoA( dtoEnvio.getAtributos(),
                                                   ListaAtributo4,
                                                   dtoDatosCliente.getOidCliente() ));
      
      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(),
                                                   ListaVenta, 
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO3 ));
                                                  //Por incidencia 22765                                                   
                                                   //ConstantesINT.COD_ATRIBUTO4 ));
                                                   
      dtoEnvio.setAtributos(this.aniadirAtributoA( dtoEnvio.getAtributos(), 
                                                   ListaAtributo5,
                                                   dtoDatosCliente.getOidCliente() ));

      dtoEnvio.setAtributos(this.aniadirAtributoA( dtoEnvio.getAtributos(), 
                                                   ListaAtributo6,
                                                   dtoDatosCliente.getOidCliente() ));                    

      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(), 
                                                   ListaVenta,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO7));

      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(), 
                                                   ListaVenta,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO8));      
                                                   
      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(), 
                                                   ListaVenta,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO9));                                                       
                                                   
      dtoEnvio.setAtributos(this.aniadirAtributoB( dtoEnvio.getAtributos(), 
                                                   ListaVenta,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO10));          
                                                                                                      
    
      dtoEnvio.setAtributos(this.aniadirAtributoC( dtoEnvio.getAtributos(),
                                                   ListaDatosAdicionales,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO11));
                                                  
      dtoEnvio.setAtributos(this.aniadirAtributoC( dtoEnvio.getAtributos(),
                                                   ListaDatosAdicionales,
                                                   dtoDatosCliente.getOidCliente(),
                                                   ConstantesINT.COD_ATRIBUTO12));
                                                   
      aList.add(dtoEnvio);      
    }
    UtilidadesLog.info("MONGisBean.formarListaEnvio(ArrayList ListaClientes, ArrayList ListaAtributo1, ArrayList ListaAtributo3, ArrayList ListaAtributo5, ArrayList ListaAtributo6, ArrayList ListaVenta, ArrayList ListaDatosAdicionales): Salida");
    return aList;
  }

  
  
 /**
     *@Author: Pcabrera, 17/2/2005
     *@throws es.indra.mare.common.exception.MareException
     *@return ArrayList
     *@Descripcion: Se quiere aniadir dinamicamente los atributos recibidos
     * en el arrayList ListaAtributos para el long oidCliente recibido
     *
   */


  public ArrayList aniadirAtributoA(ArrayList atributos, ArrayList Lista, Long oidCliente) throws MareException
  {
    /*Se recibe el DTOEnvio.Atributos, donde queremos añadir un array con los 
     * campos de la ListaAtributo para el cliente que estamos procesando, 
     * un arrayList ListaAtributo y el oidCliente*/ 
    /*  DTOEnvio.Atributos Atributos //Tenemos el campo Atributos del DTOEnvio 
     * que es un arrayList 
      DTOAtributo dtoAtr 
      
      //Se recorre la lista, y se obtiene el siguiente DTOAtributo que tenga el 
      mismo oidCliente que el recibido en el método 
      - Se Recorre la ListaAtributo y se obtiene el siguiente dtoAtr de la 
      ListaAtributo donde el campo dtoAtr.oidCliente= oidCliente recibido 
      - Atributos.add(crearAtributo(dtoAtr.oidCliente,dtoAtr.codAcceso, 
      dtoAtr.codPeriodo, dtoAtr.codAtributo, dtoAtr.valorAtributo)) 
      //Se añade al arrayList Atributos 
      } 
      
      Se devuelve el arrayList Atributos*/
    /*  DTOEnvio dto = new DTOEnvio();
      dto.setAtributos(atributos);*/
      UtilidadesLog.info("MONGisBean.aniadirAtributoA(ArrayList atributos, ArrayList Lista, Long oidCliente): Entrada");
      UtilidadesLog.debug("Lista A, mide: " + Lista.size());
       
      for(int j = 0; j< Lista.size() ; j++){
            
            DTOAtributo dtoA = ((DTOAtributo)Lista.get(j));
            
            //UtilidadesLog.debug("*** aniadirAtributoA");         
            
            if (dtoA.getOidCliente().longValue() == oidCliente.longValue())
            {
                UtilidadesLog.debug("*oid A* " + dtoA.getOidCliente().longValue());
                
                atributos.add(crearAtributo( dtoA.getOidCliente(), 
                dtoA.getCodAcceso(),dtoA.getCodPeriodo(), dtoA.getCodAtributo(),
                dtoA.getValorAtributo()));
            
            }
      }      
          
       UtilidadesLog.info("MONGisBean.aniadirAtributoA(ArrayList atributos, ArrayList Lista, Long oidCliente): Salida");
       return atributos;
  }

  /**
   *@Author: Cargain, 17/2/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return ArrayList
   *@param ArrayList atributos
   *@param Long oidPeriodo
   */
  public ArrayList aniadirAtributoB(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante) throws MareException
  {
       UtilidadesLog.info("MONGisBean.aniadirAtributoB(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante): Entrada");
       String cod = new String();
       String valor = new String();
       
       UtilidadesLog.debug("Lista B, mide: " + Lista.size());
          
       for(int k = 0; k< Lista.size() ; k++){     
          
         DTOVentasGis dtoVG = ((DTOVentasGis)Lista.get(k));            
         
         //UtilidadesLog.debug("*** aniadirAtributoB");
           
         if (dtoVG.getOidCliente().longValue() == oidCliente.longValue())
             {
             
               if (dtoVG.getOidCliente().longValue() == new Long(1571).longValue())
               {
                  UtilidadesLog.debug("#################### cliente 1571!!!!!!!!!!!!!!!!!!!!!!!!");
               }
             
               UtilidadesLog.debug("*oid B* " + dtoVG.getOidCliente().longValue());
               
                if (constante.equals(ConstantesINT.COD_ATRIBUTO2)) { 
                //Si la constante recibida por el método identifica el atributo2 
                  cod = dtoVG.getCodAtributo2(); 
                  valor = dtoVG.getValorAtributo2();
                }else if (constante.equals(ConstantesINT.COD_ATRIBUTO3)) {
                 /* Se modifica el valor de la constante con la que se compara en el segundo if de COD_ATRIBUTO4 a 
                  * COD_ATRIBUTO3  y el nombre de los campos del dtoAtr
                  *de codAtributo4 a codAtributo3  y valAtributo4 a valAtributo3 (BELC300022766)
                  */
                  cod = dtoVG.getCodAtributo3(); 
                  valor = dtoVG.getValorAtributo3();
                } else if (constante.equals(ConstantesINT.COD_ATRIBUTO7)) { 
                //Si la constante recibida por el método identifica el atributo7 
                  cod = dtoVG.getCodAtributo7(); 
                  valor = dtoVG.getValorAtributo7();
                } else if (constante.equals(ConstantesINT.COD_ATRIBUTO8)) { 
                //Si la constante recibida por el método identifica el atributo8
                  cod = dtoVG.getCodAtributo8(); 
                  valor = dtoVG.getValorAtributo8();
                } else if (constante.equals(ConstantesINT.COD_ATRIBUTO9)) { 
                //Si la constanterecibida por el método identifica el atributo9 
                  cod = dtoVG.getCodAtributo9(); 
                  valor = dtoVG.getValorAtributo9();
                } else if (constante.equals(ConstantesINT.COD_ATRIBUTO10)) { 
                //Si la constante recibida por el método identifica el atributo10 
                  cod = dtoVG.getCodAtributo10(); 
                  valor = dtoVG.getValorAtributo10();
                }
                //30/08/2005 - ssaavedr & rgiorgi - eliminación de registros multi-plicados.
                atributos.add(crearAtributo( dtoVG.getOidCliente(),dtoVG.getCodAcceso(),dtoVG.getCodPeriodo(), cod, valor));
            }
        }
   
    UtilidadesLog.info("MONGisBean.aniadirAtributoB(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante): Salida");
    return atributos;    
  }
  

  
 /**
 * Autor: pcabrera
 * Fecha : 16/02/2005
 * Descripcion : Se recibe el DTOEnvio.Atributos, donde queremos añadir un array 
 * con los campos de la ListaDatosAdicionales para el cliente que estamos 
 * procesando, un arrayList ListaDatosAdicionales, el oidCliente y una constante 
 * que identifica el atributo que vamos a obtener de la lista
 * 
 * */ 

  public ArrayList aniadirAtributoC(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante) throws MareException
  {
          UtilidadesLog.info("MONGisBean.aniadirAtributoC(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante): Entrada");
          String cod = new String();
          String valor = new String();
          
         
          if (atributos == null)
            UtilidadesLog.debug("Atributos es NULL");
          
          UtilidadesLog.debug("Lista C, mide: " + Lista.size());  
            
          for(int i = 0; i< Lista.size() ; i++){        
            
            DTODatosAdicionales dto = ((DTODatosAdicionales)Lista.get(i));  
                   
            if (dto != null){
            
                if (dto.getOidCliente().longValue() == oidCliente.longValue()){
                      
                      UtilidadesLog.debug("*oid C* " + dto.getOidCliente().longValue());
                      
                      if (constante != null){
                          if (constante.equals(ConstantesINT.COD_ATRIBUTO11)) {
                          //Si la constante recibida por el método identifica el atributo11 
                            cod = dto.getCodAtributo11(); 
                            valor = dto.getValorAtributo11();
                          } 
                          else if (constante.equals(ConstantesINT.COD_ATRIBUTO12)) {
                            //Si la constante recibida por el método identifica el atributo12 
                              cod = dto.getCodAtributo12(); 
                              valor = dto.getValorAtributo12();
                          } 
                      }  

                      //6/5/2005 - rgiorgi - eliminación de registros duplicados.
                      if(atributos != null){
                          atributos.add(crearAtributo( dto.getOidCliente(),dto.getCodAcceso(),dto.getCodPeriodo(), cod, valor));
                      }
                }
                
            }else{
                UtilidadesLog.debug("AniadirAtributoC es vacio ****");
            }
     }
    UtilidadesLog.info("MONGisBean.aniadirAtributoC(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante): Salida");
    return atributos;    
  } 

  
  
  
  /**
   * autor: pcabrera
   * Fecha: 17/02/2005
   * Descripcion: Recibe un oidCliente, un codAcceso, un codPeriodo, un 
   * codAtributo y un valorAtributo y devuelve estos campos en un objeto del 
   * tipo DTOAtributo 
   * 
   * */

  public DTOAtributo crearAtributo(Long oidCliente, String codAcceso, String codPeriodo, String codAtributo, String valorAtributo) throws MareException
  {
    UtilidadesLog.info("MONGisBean.crearAtributo(Long oidCliente, String codAcceso, String codPeriodo, String codAtributo, String valorAtributo): Entrada");
    DTOAtributo  dto = new DTOAtributo();
    dto.setCodAcceso(codAcceso);
    dto.setCodAtributo(codAtributo);
    dto.setOidCliente(oidCliente);
    dto.setValorAtributo(valorAtributo);
    dto.setCodPeriodo(codPeriodo);
   
    UtilidadesLog.info("MONGisBean.crearAtributo(Long oidCliente, String codAcceso, String codPeriodo, String codAtributo, String valorAtributo): Salida");
    return dto;      
  }

  /**
   * @Author: ssantana, 17/2/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalidaBatch
   * @param DTOBatch dto
   */
  public DTOSalidaBatch enviarInfCliente(DTOBatch dto) throws MareException
  {
    UtilidadesLog.info("MONGisBean.enviarInfCliente(DTOBatch dto): Entrada");
    UtilidadesLog.debug("- enviarInfCliente");
    MONGestorInterfacesHome monGestorHome = null;
    MONGestorInterfaces monGestor = null;
    RegistroSicc registroSicc = new RegistroSicc();
    DAOInfCliente dao = new DAOInfCliente();
    //Integer num = null;   
    
    HashMap listanum =  null;
    ArrayList listaClientes = new ArrayList();
    ArrayList listaAtributos1 = null;   
    //2006.03.13 NRISARO DT Se modifica el nombre de la lista de listaAtributo3 a l
    //istaAtributo4. (BELC300022766)

    ArrayList listaAtributos4 = null;    
    ArrayList listaVenta = null;
    ArrayList listaAtributos5 = null;
    ArrayList listaAtributos6 = null;
    ArrayList listaDatosAdicionales = null;
    ArrayList listaEnvio = new ArrayList();
    ArrayList listaOids = new ArrayList();
    DTOEnvio dtoEnvio = null;
    DTOAtributo dtoAtributo = null;   

    try {
       monGestorHome = this.getMONGestorInterfacesHome();
       monGestor = monGestorHome.create();
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
    DTOINTEnviarInfCliente dtoEnviarInf = (DTOINTEnviarInfCliente) dto.getDTOOnline();
    InterfazInfo interfazBuffer = new InterfazInfo( IGestorInterfaces.COD_INTERFAZ_GIS6,
                                                    dtoEnviarInf.getNumeroLote().toString(),
                                                    dtoEnviarInf.getOidPais());
                                                    
    InterfazInfo interfazInfo = null;                                           
    
    
    // Agregado por inc. 13576
    try {
       interfazInfo = monGestor.crearInterfaz(interfazBuffer);
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
      
    interfazInfo.setDescripcionLote(dtoEnviarInf.getDescripcionLote());
    interfazInfo.setObservaciones(dtoEnviarInf.getObservaciones());
    
    listaClientes = dao.obtenerDatosCliente(dtoEnviarInf.getOidPais(),
                                                      dtoEnviarInf.getOidMarca(), 
                                                      dtoEnviarInf.getOidCanal());

    if (listaClientes == null || listaClientes.size() == 0)
    {
     
      DTOINTError dtoError = new DTOINTError( interfazInfo, null, ErroresDeNegocio.INT_0032); 
      UtilidadesLog.debug("dtoError ** " + dtoError);
       
       
       
       try {       
          monGestor.registrarError(dtoError);
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
       mensaje = "enviarInfCliente procesado - ";
       return new DTOSalidaBatch( 0, mensaje );
    }

    // -------------- Arma ArrayLista con oids de Cliente ----------------------------
    for (int i = 0; i < listaClientes.size(); i++)
    {
      DTOInfoCliente dtoInfoCliente = (DTOInfoCliente) listaClientes.get(i);
      Long oidCliente = dtoInfoCliente.getOidCliente();
      
      if (!listaOids.contains(oidCliente))
          UtilidadesLog.info("oidCliente ---  " + oidCliente +  " ------i---------- " + i);
          listaOids.add(oidCliente);
    }
         
    
    // -------------- Obtiene los distintos ArrayLists -------------------------------
    Long oidPeriodo = dtoEnviarInf.getOidPeriodo();
    UtilidadesLog.info("oidPeriodo++++ " + oidPeriodo);
    listaAtributos1 = dao.calcularMontoDevoluciones(listaOids, oidPeriodo);
    listaAtributos4 = dao.calcularMontoAnulaciones(listaOids, oidPeriodo);
    
    //num = dao.obtenerNumCabLeidas(listaOids, oidPeriodo);
    listanum = dao.obtenerNumCabLeidas(listaOids, oidPeriodo);
    
    listaVenta = dao.calcularVentas(listaOids, oidPeriodo, listanum);
    listaAtributos5 = dao.calcularFlete(listaOids, oidPeriodo);
    listaAtributos6 = this.consultarSaldo(listaOids, oidPeriodo, dtoEnviarInf.getOidPais() );
    listaDatosAdicionales = dao.completarDatosCliente(listaOids, oidPeriodo);    
  
    listaEnvio= this.formarListaEnvio(listaClientes, 
                                      listaAtributos1, 
                                      listaAtributos4, 
                                      listaAtributos5, 
                                      listaAtributos6, 
                                      listaVenta, 
                                      listaDatosAdicionales);
      
   UtilidadesLog.error("listaEnvio mide: " + listaEnvio.size());  
   
    for (int i = 0; i < listaEnvio.size(); i++)
    {
       dtoEnvio= (DTOEnvio) listaEnvio.get(i); 
          
       ArrayList listaAtributos = dtoEnvio.getAtributos();
       UtilidadesLog.error("listaAtributos mide: " + listaAtributos.size() + " para pos. de lista envio: " + i + " cliente: " + dtoEnvio.getCodCliente());  
       
       String marca = new String(dtoEnvio.getCodMarca());
       String canal = new String(dtoEnvio.getCodCanal());         
       String pais = new String(dtoEnvio.getCodPais());       
       String subgVentas = new String(dtoEnvio.getCodSGV());
       String region = new String(dtoEnvio.getCodRegion());       
       String zona = new String(dtoEnvio.getCodZona());
       String territorio = new String(dtoEnvio.getCodTerritorio());
       String codigoCliente = new String(dtoEnvio.getCodCliente());
       String seccion = new String(dtoEnvio.getCodSeccion());  
       
      
        for (int j = 0; j < listaAtributos.size(); j++)
        {
            dtoAtributo = (DTOAtributo) listaAtributos.get(j);
            
            try
            {
               
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_MARCA, marca);                 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_CANAL, canal); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_PAIS, pais); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_ACCESO, dtoAtributo.getCodAcceso());
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_SUBGERENCIA_VENTAS, subgVentas); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_REGION, region);
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_ZONA, zona); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_SECCION, seccion);
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_TERRITORIO, territorio); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_CLIENTE, codigoCliente); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_PERIODO, dtoAtributo.getCodPeriodo()); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_CODIGO_ATRIBUTO, dtoAtributo.getCodAtributo()); 
                registroSicc.anyadirCampo( IRegistroSicc.GIS6_VALOR_ATRIBUTO, dtoAtributo.getValorAtributo());   
                            
                monGestor.anyadirRegistro( interfazInfo, registroSicc);
                registroSicc.vaciar();                             
                
                
            } catch(InterfacesException iEx) 
            {
                
                   
                DTOINTError dtoError = new DTOINTError( interfazInfo, 
                                                        registroSicc, 
                                                        ErroresDeNegocio.INT_0012);                                        
                                                        
                                                        
                try {
                   monGestor.registrarError(dtoError);
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
        } // Fin Bucle j
    } // Fin Bucle i
    
    UtilidadesLog.debug("---Salio de AMBOS bucles" );
    // ----------------------------------------------------------------------------------
    try {
        monGestor.enviarInterfaz(interfazInfo);
    } catch ( InterfacesException iex)
    {
        
   
        DTOINTError dtoError = new DTOINTError(interfazInfo, registroSicc, ErroresDeNegocio.INT_0009);
        
        UtilidadesLog.error("dtoError :: " + dtoError);
        
        try {
          monGestor.registrarError(dtoError);
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
    mensaje = "enviarInfCliente procesado - ";
    
    UtilidadesLog.info("MONGisBean.enviarInfCliente(DTOBatch dto): Salida");
    return new DTOSalidaBatch(0, mensaje);    
  }

  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
  }

  private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONInterfaceModulosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONInterfaceModulos"), MONInterfaceModulosHome.class);
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }
  
  private PeriodoLocalHome getPeriodoLocalHome() {
    return new PeriodoLocalHome(); 
  }
  
    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
      return new PeriodoCorporativoLocalHome(); 
    }  
  




}
