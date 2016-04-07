package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.dtos.ped.DTOSecuenciaProcesos;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.entidades.ped.ProcesoPedidosLocal;
import es.indra.sicc.entidades.ped.ProcesoPedidosLocalHome;
import es.indra.sicc.entidades.ped.SecuenciaProcesosLocal;
import es.indra.sicc.entidades.ped.SecuenciaProcesosLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.logicanegocio.inc.FactoriaConcurso;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.ped.DAOGruposProceso;
import es.indra.sicc.logicanegocio.fac.MONFacturacion;
import es.indra.sicc.logicanegocio.dto.ServiciosDTO;

import es.indra.sicc.logicanegocio.fac.MONFacturacionHome;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.logicanegocio.fac.MONReversionFACHome;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;

import es.indra.sicc.dtos.ped.DTOParametroMonitor;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONSecuenciaProcesosBean implements SessionBean {
    private SessionContext ctx;
    private String IDProc;
    private String user;
    private Long tamanioSegmentosGP2;
    private Long maximaCantSegmentosGP2;
    private Long tamanioSegmentosGP4;
    private Long maximaCantSegmentosGP4;
    private Long oidGrupoProceso;
    private String IDPadre;    
    private UtilidadesLog log = new UtilidadesLog();
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    private static String tipoSegmentacion;
    private Long cantSegmentosInicGP2;
    private Long cantSegmentosInicGP4;
    private String codigoBatch;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       21/07/2004
     * @version     1.0
     * @autor       Andr�s Pollitzer
    *
    * Elimina las secuencias de proceso de todos los oids del dto.
     */
    public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.elimina(DTOOIDs dto): Entrada ");
        try {

            SecuenciaProcesosLocalHome secuenciaProcesosLocalHome = new SecuenciaProcesosLocalHome();

            SecuenciaProcesosLocal secuenciaProcesos = null;
            Long[] oids = dto.getOids();

            for (int i = 0; i < oids.length; i++) {
                secuenciaProcesos = secuenciaProcesosLocalHome.findByPrimaryKey(oids[i]);
                try {
                    secuenciaProcesosLocalHome.remove(secuenciaProcesos);
                } catch (PersistenceException pe) {
                    UtilidadesLog.error("Exception: ",pe);
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.elimina(DTOOIDs dto): Salida ");
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       21/07/2004
     * @version     1.0
     * @autor       Andr�s Pollitzer
    *
    * Guarda el Subtipo de Posici�n.
     */
  public void guarda(DTOSecuenciaProcesos dto) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.guarda(DTOSecuenciaProcesos dto): Entrada ");
    UtilidadesLog.debug("### Entra en MONSecuenciaProcesosBean.guarda() ###");

    verificaGuardar(dto);

    try {
      SecuenciaProcesosLocalHome secuenciaProcesosLocalHome = new SecuenciaProcesosLocalHome();

      SecuenciaProcesosLocal secuenciaProcesos = null;

      if (dto.getOid() != null) {
        secuenciaProcesos = secuenciaProcesosLocalHome.findByPrimaryKey(dto.getOid());
        secuenciaProcesos.setSecuencia(dto.getSecuencia());
        secuenciaProcesos.setIndEjecucion(dto.getIndEjecucion());
        secuenciaProcesos.setOidTiposSolicitudPais(dto.getOidTipoSolicitudPais());
        secuenciaProcesos.setOidProcesoPedidos(dto.getOidProceso());
        secuenciaProcesos.setOidGrupoProcesos(dto.getOidGrupoProcesos());
        
        try {
            secuenciaProcesosLocalHome.merge(secuenciaProcesos);
        } catch (PersistenceException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
      } else {
        try {
            secuenciaProcesos = secuenciaProcesosLocalHome.create(dto.getSecuencia(), dto.getOidGrupoProcesos(), dto.getOidProceso(), dto.getOidTipoSolicitudPais(), dto.getIndEjecucion());
        } catch (PersistenceException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
      }
    } catch (NoResultException e) {
       UtilidadesLog.error("Exception: ",e);
       ctx.setRollbackOnly();
       throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch (PersistenceException e) {
       UtilidadesLog.error("Exception: ",e);
       ctx.setRollbackOnly();
       throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.guarda(DTOSecuenciaProcesos dto): Salida ");
  }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       21/07/2004
     * @version     1.0
     * @autor       Andr�s Pollitzer
    *
    * Obtiene las secuencias de proceso que cumplen los criterios del dto.
     */
    public DTOSalida consulta(DTOSecuenciaProcesos dto) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.consulta(DTOSecuenciaProcesos dto): Entrada ");
        UtilidadesLog.debug("### Entra en MONSecuenciaProcesosBean.consulta() ###");

        String user = ctx.getCallerPrincipal().getName();
        DAOPED dao = new DAOPED(user);
        DTOSalida dtoSalida;
        dtoSalida = dao.obtieneSecuenciaProcesos(dto);
        UtilidadesLog.debug(dtoSalida.toString());
        UtilidadesLog.info("MONSecuenciaProcesosBean.consulta(DTOSecuenciaProcesos dto): Salida ");
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       21/07/2004
     * @version     1.0
     * @autor       Andr�s Pollitzer
    *
    * Obtiene los detalles de la secuencia de procesos
     */
  public DTOSecuenciaProcesos consultaDetalles(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.consultaDetalles(DTOOID dto): Entrada ");
    try {
      UtilidadesLog.debug("### Entra en MONSecuenciaProcesosBean.consultaDetalles() ###");

      SecuenciaProcesosLocalHome secuenciaProcesosLocalHome = new SecuenciaProcesosLocalHome();
      SecuenciaProcesosLocal secuenciaProcesos = secuenciaProcesosLocalHome.findByPrimaryKey(dto.getOid());
      DTOSecuenciaProcesos dtos = new DTOSecuenciaProcesos();
      dtos.setSecuencia(secuenciaProcesos.getSecuencia());
      dtos.setIndEjecucion(secuenciaProcesos.getIndEjecucion());
      dtos.setOidTipoSolicitudPais(secuenciaProcesos.getOidTiposSolicitudPais());
      dtos.setOidProceso(secuenciaProcesos.getOidProcesoPedidos());
      dtos.setOidGrupoProcesos(secuenciaProcesos.getOidGrupoProcesos());
      dtos.setOid(secuenciaProcesos.getOid());
      UtilidadesLog.debug(dtos.toString());
      UtilidadesLog.info("MONSecuenciaProcesosBean.consultaDetalles(DTOOID dto): Salida ");
      return dtos;
   } catch (NoResultException e) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
   } catch (PersistenceException e) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
   }
 }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       21/07/2004
     * @version     1.0
     * @autor       Andr�s Pollitzer
    *
    * Verifica la posibilidad de guardar los datos de la secuencia de procesos.
     */
 public void verificaGuardar(DTOSecuenciaProcesos dto) throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.verificaGuardar(DTOSecuenciaProcesos dto): Entrada ");
   try {
     SecuenciaProcesosLocalHome secuenciaProcesosLocalHome = new SecuenciaProcesosLocalHome();
     Collection grupoProcesos = null;
     grupoProcesos = secuenciaProcesosLocalHome.findByGrupoTipoSolicitud(dto.getOidGrupoProcesos(), dto.getOidTipoSolicitudPais());

     Iterator it = null;
     it = grupoProcesos.iterator();
     SecuenciaProcesosLocal secuenciaProcesos = null;
     
     while(it.hasNext()){
         secuenciaProcesos = (SecuenciaProcesosLocal)it.next();
         if( secuenciaProcesos.getIndEjecucion().booleanValue() != dto.getIndEjecucion().booleanValue() ){
             if( dto.getOid()==null || (dto.getOid()!=null && !(secuenciaProcesos.getOid().equals(dto.getOid())))) {          
                 throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_006));
             }
         }
     }

     TiposSolicitudPaisLocalHome tiposSolicitudPaisLocalHome = new TiposSolicitudPaisLocalHome();
     TiposSolicitudPaisLocal tiposSolicitud = tiposSolicitudPaisLocalHome.findByPrimaryKey(dto.getOidTipoSolicitudPais());

     ProcesoPedidosLocalHome procesoPedidosLocalHome = new ProcesoPedidosLocalHome();
     ProcesoPedidosLocal proceso = procesoPedidosLocalHome.findByPrimaryKey(dto.getOidProceso());

      if ((!tiposSolicitud.getSujetoFlete().booleanValue()) && (proceso.getCodigo().equals(ConstantesPED.PROCESO_VALIDAR_FLETE))) {
         throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_004));
      }

      if (dto.getOid() == null) {
        SecuenciaProcesosLocal procesos;
        procesos = null;
        UtilidadesLog.debug("secuenciaProcesosLocalHome.findByProceso(, con: " + dto.getOidProceso());
        try {
           UtilidadesLog.debug("busco sobre la entidad sec.proc. con: " + dto.getOidGrupoProcesos()+" "+dto.getOidProceso()+" "+dto.getOidTipoSolicitudPais()+" "+dto.getSecuencia());
           procesos = secuenciaProcesosLocalHome.findByUK(dto.getOidGrupoProcesos(), dto.getOidProceso(),
                      dto.getOidTipoSolicitudPais(), dto.getSecuencia());
        } catch (NoResultException e) {
           UtilidadesLog.debug("los datos no estan,.....");
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (procesos != null) {
          UtilidadesLog.debug("la busqueda sobre secuencia x las 4 UK, retorna la fila: " + procesos.getOid());                                                                
          throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_005));
        }
      }
   } catch (NoResultException e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
   } catch (PersistenceException e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
   }
   UtilidadesLog.info("MONSecuenciaProcesosBean.verificaGuardar(DTOSecuenciaProcesos dto): Salida ");
   return;
 }

    //-----------------------------------------------------------------------------
    //reversarBatch

    /**Autor Hugo Mansi
         * Creado el 30/07/2004
         * Ultima modificaci�n:--
         * Recibe DTOBatch
         * Devuelve: nada
         * Exception: MareExcepciton con error PED-024
     **/
  public DTOSalidaBatch reversarBatch(DTOBatch dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.reversarBatch(DTOBatch dtoin): Entrada ");
    MareDTO dtoonline = (MareDTO) dtoin.getDTOOnline();

    if (dtoonline instanceof DTOArranqueGP) {
      IDProc = dtoin.getProcessID();
  		user = dtoin.getUser();
           
      UtilidadesLog.debug("voy a reversar(...");
      this.reversar((DTOArranqueGP) dtoonline, dtoin.getUser());
      UtilidadesLog.debug("reverse.......");
    } else {
      throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_024));
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.reversarBatch(DTOBatch dtoin): Salida ");
    return new DTOSalidaBatch(0,"Ejecucion MONSecuenciaProcesos:reversarBatch completada");
 }//fin reversarBatch

    //-----------------------------------------------------------------------------
    //reversar

    /**Autor Hugo Mansi
    * Creado el 30/07/2004
    * Ultima modificaci�n:--
    * Recibe DTOArranqueGP
    * Devuelve: nada
    * Exception: --z
    **/
    public void reversar(DTOArranqueGP dtoonline, String user) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversar(DTOArranqueGP dtoonline): Entrada ");
        BelcorpService bs = null;
        //inc.: BELC300008797.
        try {

            UtilidadesLog.debug("estoy en reversar..........");

            ConstantesPED constant = new ConstantesPED();
            oidGrupoProceso = dtoonline.getParametros().getOidGrupoProceso();
            bs = BelcorpService.getInstance();

            // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
            this.tipoSegmentacion = ConstantesPED.TIPO_SEGMENTACION_PROPERTIES;
            
            if (oidGrupoProceso.equals(constant.GP2)) {
                this.obtenerDatosSegmentosGP2(dtoonline.getCodigoBatch());
                UtilidadesLog.debug("se ejecuta: reversarGP2");
                reversarGP2(dtoonline);
            }

            if (oidGrupoProceso.equals(constant.GP3)) {
                this.obtenerDatosSegmentosGP2(dtoonline.getCodigoBatch());
                UtilidadesLog.debug("se ejecuta: reversarGP3");
                reversarGP3(dtoonline);
            }

            if (oidGrupoProceso.equals(constant.GP4)) {
                this.obtenerDatosSegmentosGP4(dtoonline.getCodigoBatch());
                UtilidadesLog.debug("se ejecuta: reversarGP4");
                reversarGP4(dtoonline);
            }

            if (oidGrupoProceso.equals(constant.GP5)) {
                UtilidadesLog.debug("se ejecuta: anularFacturacion");
                this.anularFacturacion(dtoonline, user);
            }

            UtilidadesLog.debug("antes de verificarSiguienteGrupoProceso(..."); 
            this.verificarSiguienteGrupoReversion(dtoonline); 
            UtilidadesLog.debug("luego de verificarSiguienteGrupoProceso(...");
            
        } catch (MareException e) {
            LogAPP.error("",e);
        }
        
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversar(DTOArranqueGP dtoonline): Salida ");     
    }
    
    //-----------------------------------------------------------------------------
    //ReversarGP2

    /**Autor Hugo Mansi
         * Creado el 30/07/2004
         * Ultima modificaci�n:--
         * Recibe DTOArranqueGP
         * Devuelve: nada
         * Exception: --
    **/
    protected void reversarGP2(DTOArranqueGP dtoin) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP2(DTOArranqueGP dtoin): Entrada ");
        ArrayList miArray = dtoin.getListaSolicitudes();
        DAOGruposProceso dao = new DAOGruposProceso();
        Boolean continuar = Boolean.TRUE;
        Boolean inicio = Boolean.TRUE;
        Long tipoAnt = null;
        Long zonaAnt = null;
        Boolean ejecucionOnLine = new Boolean(null);
        int count = 0;
        ArrayList miVector = new ArrayList();
        Boolean flagA = Boolean.FALSE; //inidicador para el corte

        UtilidadesLog.debug("....... reversar GP2 ........");

        // por zona o tipo diferente
        Boolean flagB = Boolean.FALSE; //indicador por tamanio de segmento       

        if (miArray != null) {
            DTOSolicitudValidacion dtoSol;
            ListIterator it = miArray.listIterator();

            UtilidadesLog.debug("....... array no nulo ........");

            while (continuar.booleanValue()) {
                while (it.hasNext()) {

                    UtilidadesLog.debug("itero ...");  
                
                    dtoSol = (DTOSolicitudValidacion) it.next();

                    if (inicio.booleanValue()) {
                        UtilidadesLog.debug("inicio.booleanValue(), true....");
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);
                        miVector.add(dtoSol);
                        zonaAnt = dtoSol.getZona();
                        tipoAnt = dtoSol.getOidTipoSolPais();
                        inicio = Boolean.FALSE;
                        count++;
                    } else {
                        UtilidadesLog.debug("inicio.booleanValue(), false....");
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);

                        if (!dtoSol.getZona().equals(zonaAnt) ||
                                !dtoSol.getOidTipoSolPais().equals(tipoAnt)) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagA = Boolean.TRUE;
                            flagB = Boolean.FALSE;
                            UtilidadesLog.debug("## 1 ##");
                            it.previous();

                            break;
                        } else if (this.tamanioSegmentosGP2.intValue() == count) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagB = Boolean.TRUE;
                            flagA = Boolean.FALSE;
                            UtilidadesLog.debug("## 2 ##");
                            it.previous();

                            break;
                        } else {
                            ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                    oidGrupoProceso);
                            miVector.add(dtoSol);
                            zonaAnt = dtoSol.getZona();
                            tipoAnt = dtoSol.getOidTipoSolPais();
                            UtilidadesLog.debug("## count++ ##");
                            count++;
                        }
                         //Fin IF 
                    }
                     //fin IF
                }
                 //fin while 2	
                UtilidadesLog.debug("maldito tipoAnt...: " + tipoAnt);
                UtilidadesLog.debug("antes de reversarGrupoProcesos...");
                reversarGrupoProcesos(miVector, oidGrupoProceso, tipoAnt,
                    ejecucionOnLine);
                UtilidadesLog.debug("luego de reversarGrupoProcesos...");    

                if (flagA.booleanValue()) {
                    if (!ejecucionOnLine.booleanValue()) {
                        esperarProcesamiento();   
                        miVector = new ArrayList();
                    }
                     //fin si
                }
                if (flagB.booleanValue()) {
                  miVector = new ArrayList();
                }
                if (!it.hasNext()) {
                    continuar = Boolean.FALSE;
                }
            }
             //FIN WHILE 1 
        } else {
            UtilidadesLog.debug("El Array de Solicitudes esta vacio");
        }
        
        if (!ejecucionOnLine.booleanValue()) {
            esperarProcesamiento();   
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP2(DTOArranqueGP dtoin): Salida ");
         //fin IF 
    }
     //FIN ReversarGP2

    //-----------------------------------------------------------------------------
    //ReversarGP3

    /**Autor Hugo Mansi
         * Creado el 30/07/2004
         * Ultima modificaci�n:--
         * Recibe DTOArranqueGP
         * Devuelve: nada
         * Exception: --
    **/
    protected void reversarGP3(DTOArranqueGP dtoin) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP3(DTOArranqueGP dtoin): Entrada ");
        ArrayList miArray = dtoin.getListaSolicitudes();
        DAOGruposProceso dao = new DAOGruposProceso();
        Boolean continuar = Boolean.TRUE;
        Boolean inicio = Boolean.TRUE;
        Long tipoAnt = null;
        Long zonaAnt = null;
        Boolean ejecucionOnLine = new Boolean(null);
        int count = 0;
        ArrayList miVector = new ArrayList();
        Boolean flagA = Boolean.FALSE; //inidicador para el corte 

        // por zona o tipo diferente
        Boolean flagB = Boolean.FALSE; //indicador por tamanio de segmento       

        if (miArray != null) {
            DTOSolicitudValidacion dtoSol;
            ListIterator it = miArray.listIterator();

            while (continuar.booleanValue()) {
                while (it.hasNext()) {
                    dtoSol = (DTOSolicitudValidacion) it.next();

                    if (inicio.booleanValue()) {
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);
                        miVector.add(dtoSol);
                        zonaAnt = dtoSol.getZona();
                        tipoAnt = dtoSol.getOidTipoSolPais();
                        inicio = Boolean.FALSE;
                        count++;
                    } else {
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);

                        if (!dtoSol.getZona().equals(zonaAnt) ||
                                !dtoSol.getOidTipoSolPais().equals(tipoAnt)) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagA = Boolean.TRUE;
                            flagB = Boolean.FALSE;
                            it.previous();

                            break;
                        } else if (this.tamanioSegmentosGP2.intValue() == count) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagB = Boolean.TRUE;
                            flagA = Boolean.FALSE;
                            it.previous();

                            break;
                        } else {
                            ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                    oidGrupoProceso);
                            miVector.add(dtoSol);
                            zonaAnt = dtoSol.getZona();
                            tipoAnt = dtoSol.getOidTipoSolPais();
                            count++;
                        }
                         //Fin IF 
                    }
                     //fin IF
                }
                 //fin while 2	

                reversarGrupoProcesos(miVector, oidGrupoProceso, tipoAnt,
                    ejecucionOnLine);

                if (flagA.booleanValue()) {
                    if (!ejecucionOnLine.booleanValue()) {
                        this.esperarProcesamiento();   
                        miVector = new ArrayList();
                    }
                }
                if (flagB.booleanValue()) {                
                  miVector = new ArrayList();
                }  

                 //fin si

                if (!it.hasNext()) {
                    continuar = Boolean.FALSE;
                }
            }
             //FIN while 1
        } else {
            UtilidadesLog.debug("El Array de Solicitudes esta vacio");
        }
        
        if (!ejecucionOnLine.booleanValue()) {
            esperarProcesamiento();   
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP3(DTOArranqueGP dtoin): Salida ");
         //fin IF 
    }


    /**
	 * @author Hugo Mansi
	 * @since 30/07/2004
     * @param dtoin - lista de solicitudes y par�metros asociados
     * @return void
     * @throws MareException
     */
    protected void reversarGP4(DTOArranqueGP dtoin) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP4(DTOArranqueGP dtoin): Entrada ");
        ArrayList miArray = dtoin.getListaSolicitudes();
        DAOGruposProceso dao = new DAOGruposProceso();
        Boolean continuar = Boolean.TRUE;
        Boolean inicio = Boolean.TRUE;
        Long tipoAnt = null;
        Long zonaAnt = null;
        Boolean ejecucionOnLine = new Boolean(null);
        int count = 0;
        ArrayList miVector = new ArrayList();
        Boolean flagA = Boolean.FALSE; //inidicador para el corte 

        // por zona o tipo diferente
        Boolean flagB = Boolean.FALSE; //indicador por tamanio de segmento       

        if (miArray != null) {
            DTOSolicitudValidacion dtoSol;
            ListIterator it = miArray.listIterator();

            while (continuar.booleanValue()) {
                while (it.hasNext()) {
                    dtoSol = (DTOSolicitudValidacion) it.next();

                    if (inicio.booleanValue()) {
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);
                        miVector.add(dtoSol);
                        zonaAnt = dtoSol.getZona();
                        tipoAnt = dtoSol.getOidTipoSolPais();
                        inicio = Boolean.FALSE;
                        count++;
                    } else {
                        ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                oidGrupoProceso);

                        if (!dtoSol.getZona().equals(zonaAnt) ||
                                !dtoSol.getOidTipoSolPais().equals(tipoAnt)) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagA = Boolean.TRUE;
                            flagB = Boolean.FALSE;
                            it.previous();

                            break;
                        } else if (this.tamanioSegmentosGP4.intValue() == count) {
                            inicio = Boolean.TRUE;
                            count = 0;
                            flagB = Boolean.TRUE;
                            flagA = Boolean.FALSE;
                            it.previous();

                            break;
                        } else {
                            ejecucionOnLine = dao.esGrupoProcesosOnline(dtoSol.getOidTipoSolPais(),
                                    oidGrupoProceso);
                            miVector.add(dtoSol);
                            zonaAnt = dtoSol.getZona();
                            tipoAnt = dtoSol.getOidTipoSolPais();
                            count++;
                        } //Fin IF
                          
                    } //fin IF
                     
                } //fin while hijo

                reversarGrupoProcesos(miVector, oidGrupoProceso, tipoAnt,
                    ejecucionOnLine);

                if (flagA.booleanValue()) {
                    if (!ejecucionOnLine.booleanValue()) {
                        this.esperarProcesamiento();   
                        miVector = new ArrayList();
                    }
                }
                
                if (flagB.booleanValue()) {
                  miVector = new ArrayList();
                }  

                if (!it.hasNext()) {
                    continuar = Boolean.FALSE;
                }    
            } //while padre
        } else {
        }
        
        if (!ejecucionOnLine.booleanValue()) {
            esperarProcesamiento();   
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGP4(DTOArranqueGP dtoin): Salida ");
         //fin IF 
    }

    private MareDTO ejecutarGP2y4xZona(DTOArranqueGP dtoin) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP2y4xZona(ArrayList lista): Entrada ");
      Boolean continuar = Boolean.TRUE;
      Boolean inicio = Boolean.TRUE;
      Boolean ejecucionOnLine = new Boolean(null);
      ArrayList miVector = new ArrayList();
      ArrayList lista = dtoin.getListaSolicitudes();
      Long numOrden = new Long(0);
      Long tipoSolicitud = null;
      int segmentosEjecutandose = 0;
      MareDTO Mdto = new MareDTO();

      DTOSolicitudValidacion dtoSol;
      ListIterator it = lista.listIterator();
      while (continuar.booleanValue()) {
        while (it.hasNext()) {
          dtoSol = (DTOSolicitudValidacion) it.next();
          dtoSol.setOidIdioma(dtoin.getParametros().getOidIdioma());
          if (inicio.booleanValue()) {
            ejecucionOnLine = dtoSol.getIndEjecOnLine();
            miVector.add(dtoSol);
            tipoSolicitud = dtoSol.getOidTipoSolPais();
            inicio = Boolean.FALSE;
          } else {
            if (dtoSol.getOidTipoSolPais().longValue() != tipoSolicitud.longValue()) {
              inicio = Boolean.TRUE;
              it.previous();
              break;
            } else {
              miVector.add(dtoSol);              
            }
          }//fin IF
        }//fin while 2	

        if (ejecucionOnLine.booleanValue()) {
          Mdto = this.ejecutarGrupoProcesosOnLine(miVector, oidGrupoProceso, tipoSolicitud);
        } else {
          Mdto = this.ejecutarGrupoProcesosGP(miVector, oidGrupoProceso, tipoSolicitud, segmentosEjecutandose);
          segmentosEjecutandose = ((Long)Mdto.getProperty("SegmentosEjecutandose")).intValue();
        }
        miVector = new ArrayList();

        if (!it.hasNext()) {
          continuar = Boolean.FALSE;
        }
      }//FIN while 1
      if (!ejecucionOnLine.booleanValue()) {
        this.esperarProcesamiento();
      }
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP2y4xZona(ArrayList lista): Salida ");
      return Mdto;
    }

    private MareDTO ejecutarGP4xTipificacion(DTOArranqueGP dtoin) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP4xTipificacion(ArrayList lista): Entrada ");
      ArrayList lista = dtoin.getListaSolicitudes();            
      Boolean continuar = Boolean.TRUE;
      Boolean inicio = Boolean.TRUE;
      Long ordenTipificacion = null;      
      Boolean ejecucionOnLine = new Boolean(null);      
      ArrayList miVector = new ArrayList();
      int segmentosEjecutandose = 0;      
      Long tipoSolicitud = null;
      Boolean esperarTipificacion = Boolean.FALSE;
      MareDTO Mdto = new MareDTO();

      DTOSolicitudValidacion dtoSol;
      ListIterator it = lista.listIterator();
      while (continuar.booleanValue()) {
        while (it.hasNext()) {
          dtoSol = (DTOSolicitudValidacion) it.next();
          dtoSol.setOidIdioma(dtoin.getParametros().getOidIdioma());
          if (inicio.booleanValue()) {
            ejecucionOnLine = dtoSol.getIndEjecOnLine();
            miVector.add(dtoSol);            
            ordenTipificacion = new Long(dtoSol.getOrdenTipificacion().longValue());
            tipoSolicitud = new Long(dtoSol.getOidTipoSolPais().longValue());
            inicio = Boolean.FALSE;
            esperarTipificacion = Boolean.FALSE;
          } else {
            if (ordenTipificacion.longValue() != dtoSol.getOrdenTipificacion().longValue()) {
              esperarTipificacion = Boolean.TRUE;
              inicio = Boolean.TRUE;
              it.previous();
              break;              
            } else {
              if (tipoSolicitud.longValue() != dtoSol.getOidTipoSolPais().longValue()) {
                inicio = Boolean.TRUE;
                it.previous();
                break;
              } else {
                miVector.add(dtoSol);
              }
            }
          }	
        }  //fin while 2
        
        if (ejecucionOnLine.booleanValue()) {
          Mdto = this.ejecutarGrupoProcesosOnLine(miVector, oidGrupoProceso, tipoSolicitud);              
        } else {
          Mdto = this.ejecutarGrupoProcesosGP(miVector, oidGrupoProceso, tipoSolicitud, segmentosEjecutandose);
          segmentosEjecutandose = ((Long)Mdto.getProperty("SegmentosEjecutandose")).intValue();
        }

        if (esperarTipificacion.booleanValue() && !ejecucionOnLine.booleanValue()) {
          this.esperarProcesamiento();
        }
        miVector = new ArrayList();
     
        if (!it.hasNext()) {
          continuar = Boolean.FALSE;
        }
      }
      if (!ejecucionOnLine.booleanValue()) {
        this.esperarProcesamiento();   
      }
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP4xTipificacion(ArrayList lista): Salida "); 
      return Mdto;
    }


    protected MareDTO ejecutarGP4(DTOArranqueGP dtoin) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP4(DTOArranqueGP dtoin): Entrada ");
      ArrayList lista = dtoin.getListaSolicitudes();
      MareDTO Mdto = new MareDTO();
      if ((lista != null) && (lista.size() > 0)) {
        if (dtoin.getIndTipificacion() == null || (!dtoin.getIndTipificacion().booleanValue())) {
          Mdto = this.ejecutarGP2y4xZona(dtoin);
        } else {
          Mdto = this.ejecutarGP4xTipificacion(dtoin);
        }
      }
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP4(DTOArranqueGP dtoin): Salida ");
      return Mdto;
   }
    

    /**
	 * @author Hugo Mansi
     * @since 30/07/2004
     * @param dtoin - lista de solicitudes y par�metros asociados
     * @return void
	 * @throws MareException
     * 17-05-2005 - rgiorgi: inc. BELC300018307
     */
    protected void anularFacturacion(DTOArranqueGP dtoin, String user) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.anularFacturacion(DTOArranqueGP dtoin): Entrada ");
        
      ArrayList miArray = dtoin.getListaSolicitudes();
      DAOSolicitud dao = new DAOSolicitud();
      ArrayList listaSolicitudes = dao.obtenerSolicitudPorListaConsolidados(miArray);
        
      if (miArray != null) {
        DTOSolicitudValidacion dtoSol;
        dtoSol = (DTOSolicitudValidacion) miArray.get(0);
            
        try {      
          DAOGruposProceso daoG = new DAOGruposProceso();
          Boolean ejecucionOnLine = daoG.esGrupoProcesosOnlineFAC(dtoSol.getOidTipoSolPais(), oidGrupoProceso);
          MONReversionFACHome mRFH = this.getMONReversionFACHome();
          if (ejecucionOnLine.booleanValue()){
            UtilidadesLog.debug("a pto. de ejec.: MONReversionFAC==>>revertirFacturacionOnline(...");
            mRFH.create().revertirFacturacion(dtoin, dtoSol.getOidPais(), dtoin.getParametros().getGrupoReversion(), user);
            UtilidadesLog.debug("ejecute anularFacturacionOnline");
          }else{
            UtilidadesLog.debug("a pto. de ejec.: MONReversionFAC==>>revertirFacturacionOffLine(...");
            mRFH.create().revertirFacturacionOffLine(dtoin, dtoSol.getOidPais(), dtoin.getParametros().getGrupoReversion(), user);
            UtilidadesLog.debug("ejecute anularFacturacionOffLine");
          }
        }catch (NamingException e){
          UtilidadesLog.error("Exception: ",e);
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
          if (e instanceof MareException){
            throw (MareException)e;
          }else{
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }        
      }
      dtoin.setListaSolicitudes(listaSolicitudes);
      UtilidadesLog.info("MONSecuenciaProcesosBean.anularFacturacion(DTOArranqueGP dtoin): Salida ");
    }

    //----------------------------------------------------------------------------

    /**Autor Hugo Mansi
            * Creado el 30/07/2004
            * Ultima modificaci�n:--
            * Recibe array con solicitudes de proceso
                    *        oidGrupoProceso
                    *        oidTipoSolicitudPais
                    *        y el estado de la ejecucion
                    *
            * Devuelve: nada
            * Exception: --
       **/
    protected void reversarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso,
        Long oidTipoSolicitudPais, Boolean online) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, Boolean online): Entrada ");
        DTOEjecucionProcesos dtoEjec = new DTOEjecucionProcesos();
        ArrayList aListSol = Lista; 

        dtoEjec.setOidGrupoProcesos(oidGrupoProceso);
        dtoEjec.setOidTipoSolicitud(oidTipoSolicitudPais);
        dtoEjec.setListaSolicitudes(aListSol);
        
        UtilidadesLog.debug("estoy en: reversarGrupoProcesos...");
        UtilidadesLog.debug("aca oidTipoSolicitudPais es: " + oidTipoSolicitudPais);

        try {
            if (online.booleanValue()) {
                MONGrupoProcesoHome monHome = this.getMONGrupoProcesoHome();
                MONGrupoProceso monGP = monHome.create();
                monGP.reversar(dtoEjec);
            }

            if (!online.booleanValue()) {
                MareBusinessID id = new MareBusinessID();
                id.setBusinessID("PEDReversarProcesos");

                UtilidadesLog.debug("creo DTOSubBatch...");
                DTOSubBatch dtoSB = new DTOSubBatch("SEGMENTO_GP_", IDProc, user, id, dtoEjec);
                UtilidadesLog.debug("cree DTOSubBatch...");        
                        
                BatchUtil batch = new BatchUtil();
                UtilidadesLog.debug("antes de executeMLN...");
                batch.executeMLN(dtoSB, "PEDSegmentosProcesos");
                UtilidadesLog.debug("luego de executeMLN...");
            }
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
            throw new MareException(me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, Boolean online): Salida ");
    }//FIN reversarGrupoProcesos

  private MONGrupoProcesoHome getMONGrupoProcesoHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGrupoProcesoHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGrupoProceso"), MONGrupoProcesoHome.class);
  }

    /**Autor Hugo Mansi
         * Creado el 30/07/2004
         * Ultima modificaci�n:--
         * Recibe nada
         * Devuelve: nada
         * Exception: --
    **/
   protected void verificarSiguienteGrupoReversion(DTOArranqueGP dtoin) throws MareException {
     UtilidadesLog.info("MONSecuenciaProcesosBean.verificarSiguienteGrupoReversion(DTOArranqueGP dtoin): Entrada ");
     Long grupoAnterior;

     if (!oidGrupoProceso.equals(ConstantesPED.GP2) && !oidGrupoProceso.equals(ConstantesPED.GP1)) {
       DAOGruposProceso miDao = new DAOGruposProceso();
       grupoAnterior = miDao.obtenerGrupoProcesoAnterior(oidGrupoProceso);
       dtoin.getParametros().setOidGrupoProceso(grupoAnterior);
       reversar(dtoin, String.valueOf("noUser")); 
     }
     UtilidadesLog.info("MONSecuenciaProcesosBean.verificarSiguienteGrupoReversion(DTOArranqueGP dtoin): Salida ");
  }

    /*--------------------------------------------------------------------------*/

    /**Autor Hugo Mansi
         * Creado el 30/07/2004
         * Ultima modificaci�n:--
         * Recibe DTOArranqueGP
         * Devuelve: MareDTO
         * Exception: MareException
    **/
  protected MareDTO verificarSiguienteGrupoProceso(DTOArranqueGP dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.verificarSiguienteGrupoProceso(DTOArranqueGP dtoin): Entrada ");
    Long oidGrupoProcesosSiguiente;
    Long oidTipoSolicitud;
    MareDTO mareDto = null;

    if (!oidGrupoProceso.equals(ConstantesPED.GP5) && (dtoin.getListaSolicitudes() != null) && (dtoin.getListaSolicitudes().size() >0) ) { 
      DTOSolicitudValidacion dtoVal = (DTOSolicitudValidacion) dtoin.getListaSolicitudes().get(0);
      oidTipoSolicitud = dtoVal.getOidTipoSolPais();
      DAOGruposProceso miDao = new DAOGruposProceso();
      oidGrupoProcesosSiguiente = miDao.obtenerProximoGrupoProceso(oidGrupoProceso);
            
      if (miDao.esGrupoProcesosOnline(oidTipoSolicitud,oidGrupoProcesosSiguiente).booleanValue()){
        dtoin.getParametros().setOidGrupoProceso(oidGrupoProcesosSiguiente);        
        mareDto = ejecutar(dtoin);        
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(log.isDebugEnabled()){ 
            UtilidadesLog.debug("Estoy en verificarSiguienteGrupoProceso.., el oidGrupoProcesosSiguiente, es: " + oidGrupoProcesosSiguiente);
            UtilidadesLog.debug("El mareDto q' obtuve, es......: " + mareDto); 
            UtilidadesLog.debug("Ejecute desde verificarSiguienteGrupoProceso...............");
        }
      }
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.verificarSiguienteGrupoProceso(DTOArranqueGP dtoin): Salida ");
    return mareDto;
  }

  public MareDTO ejecutar(DTOArranqueGP dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutar(DTOArranqueGP dtoin): Entrada ");
    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
        UtilidadesLog.debug("la lista, aca, es: " + dtoin.getListaSolicitudes());
  
    MareDTO resu = new MareDTO();  
    MareDTO resu1 = new MareDTO();
    oidGrupoProceso =dtoin.getParametros().getOidGrupoProceso();

    BelcorpService bs = null;

    try {
        // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        this.tipoSegmentacion = daoSolicitud.obtenerTipoSegmentacion();
        this.codigoBatch = dtoin.getCodigoBatch();
        
        if(this.codigoBatch==null) {
            UtilidadesLog.info("SE ACTUALIZA A SEGMENTACION TIPO PROPERTIES");
            this.tipoSegmentacion = ConstantesPED.TIPO_SEGMENTACION_PROPERTIES;
        } else {
            UtilidadesLog.warn("CODIGO BATCH : " + this.codigoBatch);
            UtilidadesLog.warn("TIPO SEGMENTACION : " + this.tipoSegmentacion);
        }

      bs = BelcorpService.getInstance();      
      if (oidGrupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
          // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
          if(tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_MANUAL) || 
                tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_AUTOMATICO)) {
              daoSolicitud.ejecutarCalculoSegmentacion(dtoin.getCodigoBatch(), "GP2", new Long(dtoin.getListaSolicitudes().size()));
          }
          
        this.obtenerDatosSegmentosGP2(dtoin.getCodigoBatch());
        resu = this.ejecutarGP2(dtoin);        
      }  
      if (oidGrupoProceso.longValue() == ConstantesPED.GP3.longValue()) {
        resu = this.ejecutarGP3(dtoin);    
        
        if(dtoin.getParametros().getIndOrdenesCompra()!=null && dtoin.getParametros().getIndOrdenesCompra()) {
            // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011 ,invocamos a Procesos Especiales
            String usuario = this.user;
            if(dtoin.getParametros().getCodigoUsuario()!=null)
              usuario = dtoin.getParametros().getCodigoUsuario();
        
            // sapaza -- PER-SiCC-2011-0726 -- 07/02/2011
            boolean esPedidoOnline = validarPedidoOnline(dtoin);
            
            if(esPedidoOnline) {
                DTOSolicitudValidacion dtoSolicitud = (DTOSolicitudValidacion)dtoin.getListaSolicitudes().get(0);
                daoSolicitud.ejecutarProcesosEspecialesxSolicitud(dtoin.getParametros().getOidPais(), 
                                dtoSolicitud.getOidSolicitud(), usuario);
            } else
                daoSolicitud.ejecutarProcesosEspeciales(dtoin.getParametros().getOidPais(), usuario);
        }
      }  
      if (oidGrupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
          // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
          if(tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_MANUAL) || 
                tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_AUTOMATICO)) {
              daoSolicitud.ejecutarCalculoSegmentacion(dtoin.getCodigoBatch(), "GP4", new Long(dtoin.getListaSolicitudes().size()));
          }
          
        this.obtenerDatosSegmentosGP4(dtoin.getCodigoBatch());
        resu = this.ejecutarGP4(dtoin);    
      }  
      if (oidGrupoProceso.longValue() == ConstantesPED.GP5.longValue()) {
        resu = this.arrancarFacturacion(dtoin);
      } 

      UtilidadesLog.debug("antes de verificarSiguienteGrupoProceso...");
      resu1 = this.verificarSiguienteGrupoProceso(dtoin);
      UtilidadesLog.debug("despues de verificarSiguienteGrupoProceso...");
      
    } catch(Exception ex){
       UtilidadesLog.error("Error en metodo Ejecutar: ", ex);
       LogAPP.error("Error en metodo Ejecutar: ", ex);
    }
    
    //doliva -- cambio Optimizacion Logs -- 24/03/2010
    if(log.isDebugEnabled()){ 
        UtilidadesLog.debug("resul....: " + resu1);
    }
    
    if ( resu1 == null) {
        UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutar(DTOArranqueGP dtoin): Salida ");
      return resu;
    } else {
        UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutar(DTOArranqueGP dtoin): Salida ");
      return resu1;
    }    

  }

  public DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarBatch(DTOBatch dtoin): Entrada ");
    MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
    IDPadre = dtoin.getProcessID();
    
    if (dtoonline instanceof DTOArranqueGP) {
      UtilidadesLog.debug("llamo a ejecutar.........");
    
      IDProc = dtoin.getProcessID(); 
      user = dtoin.getUser();
      this.ejecutar((DTOArranqueGP)dtoonline);

      UtilidadesLog.debug("llam� a ejecutar.........");
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarBatch(DTOBatch dtoin): Salida ");
      return new DTOSalidaBatch(0,"Ejecucion MONSecuenciaProcesos:ejecutarBatch completada");  
    } else {
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarBatch(DTOBatch dtoin): Salida ");
      throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_024));
    }

  }

  protected MareDTO ejecutarGP2(DTOArranqueGP dtoin) throws MareException  { 
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP2(DTOArranqueGP dtoin): Entrada ");
    ArrayList lista = dtoin.getListaSolicitudes();
    MareDTO Mdto = new MareDTO();
    if ((lista != null) && (lista.size() > 0)) {
      Mdto = this.ejecutarGP2y4xZona(dtoin);
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP4(DTOArranqueGP dtoin): Salida ");
    return Mdto;
  }

 protected MareDTO ejecutarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, Boolean online) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, Boolean online): Entrada ");
    DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
    dtoEP.setListaSolicitudes(Lista);
    dtoEP.setOidTipoSolicitud(oidTipoSolicitudPais);
    dtoEP.setOidGrupoProcesos(oidGrupoProceso);
    MareDTO mDTOResu = new MareDTO();

    try {
      if (online.booleanValue() == true) {
        MONGrupoProcesoHome monHome = this.getMONGrupoProcesoHome();
        MONGrupoProceso monGP = monHome.create();
        UtilidadesLog.debug("a punto de: monGP.ejecutar..........");
        UtilidadesLog.debug("estando en: ejecutarGrupoProcesos, la lista es " + Lista);
        mDTOResu = monGP.ejecutar(dtoEP);
      } else {
        UtilidadesLog.debug("entrando por ejecutarGrupoProcesos, online.booleanValue() == false, la lista es: " + dtoEP.getListaSolicitudes());
         
        MareBusinessID mBI = new MareBusinessID();
        mBI.setBusinessID(new String("PEDEjecutarProcesos"));
        DTOSubBatch dtoSB = new DTOSubBatch(new String("SEGMENTO_GP_"), IDProc, this.user, mBI, dtoEP);
 
        BatchUtil batch = new BatchUtil();
        mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");

        UtilidadesLog.debug("ejecutarGrupoProcesos, retorna null.......");
      }
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, Boolean online): Salida ");
      return mDTOResu;
    } catch (NamingException ne) {
       throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (RemoteException re) {
       throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ce) {
       throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
  }
    
    protected void esperarProcesamiento() throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Entrada ");
        try {
            if (this.IDProc != null) {
                MONBatch mb = new MONBatch();
                mb.esperarHijos(this.IDProc);
            }  
        } catch (InterruptedException ie) {
            UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Salida ");
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        }  
        UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Salida ");
    }

  protected MareDTO ejecutarGP3(DTOArranqueGP dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP3(DTOArranqueGP dtoin): Entrada ");
    ArrayList lista = new ArrayList();
    lista = dtoin.getListaSolicitudes();
    Boolean EjecucionOnline = Boolean.FALSE;

    Long tipoAnt = null;
    Long zonaAnt = null;
    Boolean inicio = Boolean.TRUE;
    ArrayList miVector = new ArrayList();

    Boolean flagA = Boolean.FALSE; //corte 
    Boolean flagB = Boolean.FALSE; //segmento

    Boolean continuar = Boolean.TRUE;
    int puntero = 0;

    int count = 0;

    MareDTO Mdto = new MareDTO();
    UtilidadesLog.debug("Estoy en EjecutarGP3");

    if ((lista != null) && (lista.size() > 0)) {
      ListIterator it = lista.listIterator(); 
      DTOSolicitudValidacion elemLista;
      
      while (continuar.booleanValue()) { 
        UtilidadesLog.debug("Mientras continuo");
        while (it.hasNext()) {
          DAOGruposProceso daoGP = new DAOGruposProceso();
          
          elemLista = (DTOSolicitudValidacion)it.next();
          UtilidadesLog.debug("elemento de la lista (oid sol.): " + elemLista.getOidSolicitud());
          if (elemLista != null) { 
              UtilidadesLog.debug("lista no nula");
              if (inicio.booleanValue()) {
                UtilidadesLog.debug("antes de: daoGP.esGrupoProcesosOnline1");
                EjecucionOnline = daoGP.esGrupoProcesosOnline(elemLista.getOidTipoSolPais(), oidGrupoProceso);
                UtilidadesLog.debug("luego de: daoGP.esGrupoProcesosOnline1");
                inicio = Boolean.FALSE;
                miVector.add(elemLista);
                zonaAnt = elemLista.getZona();
                tipoAnt = elemLista.getOidTipoSolPais();

                count++;
              } else {
                UtilidadesLog.debug("antes de: daoGP.esGrupoProcesosOnline2");
                EjecucionOnline = daoGP.esGrupoProcesosOnline(elemLista.getOidTipoSolPais(), oidGrupoProceso);
                UtilidadesLog.debug("luego de: daoGP.esGrupoProcesosOnline2");
          
                if (!elemLista.getZona().equals(zonaAnt) || !elemLista.getOidTipoSolPais().equals(tipoAnt)) {
                  inicio = Boolean.TRUE;
                  flagA = Boolean.TRUE;
                  flagB = Boolean.FALSE;
                  it.previous();

                  break;
                } else {
                  UtilidadesLog.debug("antes de: daoGP.esGrupoProcesosOnline3");
                  EjecucionOnline = daoGP.esGrupoProcesosOnline(elemLista.getOidTipoSolPais(), oidGrupoProceso);
                  UtilidadesLog.debug("luego de: daoGP.esGrupoProcesosOnline3");
                  miVector.add(elemLista);
                  zonaAnt = elemLista.getZona();
                  tipoAnt = elemLista.getOidTipoSolPais();
                  count++;
                }
          
              }
          }
        } //for!!
        UtilidadesLog.debug("antes de: ejecutarGrupoProcesos");
        Mdto = this.ejecutarGrupoProcesos(miVector, oidGrupoProceso, tipoAnt, EjecucionOnline);
        UtilidadesLog.debug("luego de: ejecutarGrupoProcesos");
        if (flagA.booleanValue()) {
            if (!EjecucionOnline.booleanValue()) {
                UtilidadesLog.debug("antes de: esperarProcesamiento");
                esperarProcesamiento();   
                UtilidadesLog.debug("luego de: esperarProcesamiento");
                flagA = Boolean.FALSE;
            }
        }

        miVector = new ArrayList();
        if (!it.hasNext()) {
          continuar = Boolean.FALSE;
        }

      } //while     
    } else { //if 
     UtilidadesLog.debug("El Array de Solicitudes esta vacio");
    }
    
    if (!EjecucionOnline.booleanValue()) {
        esperarProcesamiento();   
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGP3(DTOArranqueGP dtoin): Salida ");
    return Mdto;
  }

  protected MareDTO arrancarFacturacion(DTOArranqueGP dtoin) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.arrancarFacturacion(DTOArranqueGP dtoin): Entrada ");
    try {
      Date date1 = new Date();

      dtoin.getParametros().setIDProc(IDProc);

      MONFacturacion mf = PEDEjbLocators.getMONFacturacionHome().create();

      mf.arrancarFacturacion(dtoin);
      
      Date date2 = new Date();
      UtilidadesLog.warn("Generacion de Consolidados ->>> "+(date2.getTime()-date1.getTime()));
    } catch (RemoteException re) {
        UtilidadesLog.error("Exception: ",re);
        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException Ce) {
        UtilidadesLog.error("Exception: ",Ce);
        ctx.setRollbackOnly();
        throw new MareException(Ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    } catch (Exception e){
        UtilidadesLog.error("Exception: ",e);
        if (e instanceof MareException)
          throw (MareException)e;
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    UtilidadesLog.info("MONSecuenciaProcesosBean.arrancarFacturacion(DTOArranqueGP dtoin): Salida ");
    return null;

  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

  private MONReversionFACHome getMONReversionFACHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONReversionFACHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONReversionFAC"), MONReversionFACHome.class);
  }
  
  protected MareDTO ejecutarGrupoProcesosOnLine(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais) throws MareException {
    UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesosOnLine(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais): Entrada ");

    MareDTO mDTOResu = new MareDTO();        
    try {
      DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
      dtoEP.setListaSolicitudes(Lista);
      dtoEP.setOidTipoSolicitud(oidTipoSolicitudPais);
      dtoEP.setOidGrupoProcesos(oidGrupoProceso);
      MONGrupoProcesoHome monHome = this.getMONGrupoProcesoHome();
      MONGrupoProceso monGP = monHome.create();
      mDTOResu = monGP.ejecutar(dtoEP);
      UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesosOnLine(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais): Salida ");
      return mDTOResu;        
    } catch (NamingException ne) {
       throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (RemoteException re) {
       throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ce) {
       throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
 }
 
 protected MareDTO ejecutarGrupoProcesosGP(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, int segEjecutandose) throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesosGP(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, int segEjecutandose): Entrada ");

   MareDTO mDTOResu = new MareDTO();        
   try {
     int size = Lista.size();
     int tamanoSeg = 0;
     int maxCantSegmentos = 0;  
     int count = 0;
     int segmentosEjecutados = segEjecutandose;
     
     // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
     int cantSegmentosInic = 0;
       
     ArrayList listaFinal = new ArrayList();
     ListIterator it = Lista.listIterator();
     boolean continua = true;
     String nombreGP = "";
     
     if (oidGrupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
       tamanoSeg = this.tamanioSegmentosGP2.intValue();
       maxCantSegmentos = this.maximaCantSegmentosGP2.intValue();
       nombreGP = new String("SEGMENTO_GP2_");
       
       // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
       cantSegmentosInic = this.cantSegmentosInicGP2.intValue();
       
     } else if (oidGrupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
       tamanoSeg = this.tamanioSegmentosGP4.intValue();
       maxCantSegmentos = this.maximaCantSegmentosGP4.intValue();
       nombreGP = new String("SEGMENTO_GP4_");
       
       // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
       cantSegmentosInic = this.cantSegmentosInicGP4.intValue();
     }
     
     while (continua){     
       MareBusinessID mBI = new MareBusinessID();
       mBI.setBusinessID(new String("PEDEjecutarSegmentosCacheEntidades")); 
          
       DTOSubBatch dtoSB = new DTOSubBatch(nombreGP, IDProc, this.user, mBI, new DTOEjecucionProcesos());
       BatchUtil batch = new BatchUtil();
       mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");
       
       segmentosEjecutados++;
       if (segmentosEjecutados == (cantSegmentosInic)) { // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
            this.esperarProcesamiento();
            segmentosEjecutados = 0;
            continua = false;
       }      
     }     
     continua = true;
     while (continua) {
       while (it.hasNext()) {
         listaFinal.add(it.next());
         count++;
         if (count == tamanoSeg) {
           count = 0;
           break;
         }
       }
       DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
       dtoEP.setListaSolicitudes(listaFinal);
       dtoEP.setOidTipoSolicitud(oidTipoSolicitudPais);
       dtoEP.setOidGrupoProcesos(oidGrupoProceso);
       
       // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
       dtoEP.setCodigoBatch(this.codigoBatch);
       
       MareBusinessID mBI = new MareBusinessID();
       mBI.setBusinessID(new String("PEDEjecutarProcesos"));
          
       DTOSubBatch dtoSB = new DTOSubBatch(nombreGP, IDProc, this.user, mBI, dtoEP);
          
       BatchUtil batch = new BatchUtil();
       mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");
       listaFinal = new ArrayList();
       segmentosEjecutados++;
       if (segmentosEjecutados == maxCantSegmentos) {
          this.esperarProcesamiento();
          segmentosEjecutados = 0;
       }
       if (!it.hasNext()){
         continua = false;
       }                    
     }
     UtilidadesLog.info("MONSecuenciaProcesosBean.ejecutarGrupoProcesosGP(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais, int segEjecutandose): Salida ");
     mDTOResu.setProperty("SegmentosEjecutandose", new Long(segmentosEjecutados));
     return mDTOResu;        
   } catch (RemoteException re) {
     throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
   }    
 }

 protected void obtenerTamanioSegmentosGP2() throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmentosGP2(): Entrada ");
   MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC)); 
   String salida = (String) mgc.getProperty("application.TamanioSegmentosGP2");
   if ((salida == null) || (salida.equals(""))) {
     UtilidadesLog.warn("No existe parametro TamanioSegmentosGP2, se tomara 30 de segmento");
     this.tamanioSegmentosGP2 = new Long(30);           
   } else {
     this.tamanioSegmentosGP2 = new Long(salida);
   }
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmentosGP2(): Salida ");	
 }

 protected void obtenerMaximaCantSegmentosGP2() throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerMaximaCantSegmentosGP2(): Entrada ");
   MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
   String salida = (String) mgc.getProperty("application.MaximaCantSegmentosGP2");
   if ((salida == null) || (salida.equals(""))) {
     UtilidadesLog.warn("No existe parametro MaximaCantSegmentosGP2, se tomara 12 de segmento");
     this.maximaCantSegmentosGP2 = new Long(12);           
   } else {
     this.maximaCantSegmentosGP2 = new Long(salida);
   }
   
   // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
   this.cantSegmentosInicGP2 = this.maximaCantSegmentosGP2 * 2;
     
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerMaximaCantSegmentosGP2(): Salida ");	
 }
 
 protected void obtenerTamanioSegmentosGP4() throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmentosGP4(): Entrada ");
   MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
   String salida = (String) mgc.getProperty("application.TamanioSegmentosGP4");
   if ((salida == null) || (salida.equals(""))) {
     UtilidadesLog.warn("No existe parametro TamanioSegmentosGP4, se tomara 30 de segmento");
     this.tamanioSegmentosGP4 = new Long(30);           
   } else {
     this.tamanioSegmentosGP4 = new Long(salida);
   }
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmentosGP4(): Salida ");	
 }

 protected void obtenerMaximaCantSegmentosGP4() throws MareException {
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerMaximaCantSegmentosGP4(): Entrada ");
     MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
   String salida = (String) mgc.getProperty("application.MaximaCantSegmentosGP4");
   if ((salida == null) || (salida.equals(""))) {
     UtilidadesLog.warn("No existe parametro MaximaCantSegmentosGP4, se tomara 12 de segmento");
     this.maximaCantSegmentosGP4 = new Long(12);           
   } else {
     this.maximaCantSegmentosGP4 = new Long(salida);
   }
   
   // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
   this.cantSegmentosInicGP4 = this.maximaCantSegmentosGP4 * 2;
     
   UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerMaximaCantSegmentosGP4(): Salida ");	
 }

    /**
     * Metodo que revierte las solicitudes de servicio
     * Agregado por HRCS - Fecha 23/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalidaBatch
     * @param dtoin
     */
    public DTOSalidaBatch reversarSolicitudesServicioBatch(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarSolicitudesServicioBatch(DTOBatch dtoin): Entrada ");
        MareDTO dtoonline = (MareDTO) dtoin.getDTOOnline();
    
        try {
            user = dtoin.getUser();
            DTOInfoMonitor dtoE = (DTOInfoMonitor)dtoin.getDTOOnline();
            DAOPED daoPED = new DAOPED( user );
            
            //sapaza -- cambio Optimizacion Reversa Solicitudes Servicio -- 12/05/2011
            daoPED.reversarSolicitudesServicio(dtoE.getOidPais(), dtoE.getFechaInicio());
                        
            //  Obtenemos los Oids de las solicitudes de servicio
            /*java.util.HashMap registros = daoPED.obtenerSolicitudesServicioEnGP4( dtoE.getOidPais(), dtoE.getFechaInicio() );
            ArrayList oids = (ArrayList)registros.get("ListaOids");
            ArrayList numSolic = (ArrayList)registros.get("ListaNumeSoli");
            
            //  Actualizamos las solicitudes de servicio a GP3
            daoPED.actualizarSolicitudesServicioGP3( oids );
            //  Actualizamos las posiciones de las solicitudes de servicio
            daoPED.actualizarPosicionesSolicitudesServicio( oids );
            
            //  Obtenemos los Oids de los movimientos de almacen
            ArrayList oids2 = daoPED.obtenerOidsMovimBelCabec( numSolic );

            //  Borrar detalles BEL
            daoPED.borrarMovimBelDetal( oids2 );
            //  Borrar cabecera BEL
            daoPED.borrarMovimBelCabec( oids2 );*/
        }
        catch(Exception e) {
            UtilidadesLog.error("Exception: ", e);
            ctx.setRollbackOnly();
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_085) );
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.reversarSolicitudesServicioBatch(DTOBatch dtoin): Salida ");
        return new DTOSalidaBatch(0,"Ejecucion MONSecuenciaProcesos:reversarSolicitudesServicioBatch completada");
    }

    // sapaza -- PER-SiCC-2011-0726 -- 07/02/2011
    private boolean validarPedidoOnline(DTOArranqueGP dtoin) {
        UtilidadesLog.info("MONSecuenciaProcesosBean.validarPedidoOnline(DTOArranqueGP dtoin): Entrada ");
        boolean esPedidoOnline = false;
        
        ArrayList lista = dtoin.getListaSolicitudes();        
        if(lista.size() > 0) {
            DTOSolicitudValidacion dtoSolicitud = (DTOSolicitudValidacion)lista.get(0);
            if(dtoSolicitud.getIndRecepcionOnline()!=null && dtoSolicitud.getIndRecepcionOnline()) {
                esPedidoOnline = true;
            }
        }
        
        UtilidadesLog.info("MONSecuenciaProcesosBean.validarPedidoOnline(DTOArranqueGP dtoin): Salida ");
        
        return esPedidoOnline;
    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    private void obtenerDatosSegmentosGP2(String procesoBatch) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerDatosSegmentosGP2(String procesoBatch): Entrada ");      
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      
      if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_PROPERTIES)) {
          this.obtenerTamanioSegmentosGP2();
          this.obtenerMaximaCantSegmentosGP2();   
      }
      if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_MANUAL) || 
           this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_AUTOMATICO)) {
          this.tamanioSegmentosGP2 = new Long(daoSolicitud.obtenerTamanioSegmento(procesoBatch, "GP2"));
          this.maximaCantSegmentosGP2 = new Long(daoSolicitud.obtenerMaxCantSegmento(procesoBatch, "GP2"));   
          this.cantSegmentosInicGP2 = new Long(daoSolicitud.obtenerTamanioSegmentoInicio(procesoBatch, "GP2"));
      }
      
      UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerDatosSegmentosGP2(String procesoBatch): Salida ");       
    }
    
    // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
    private void obtenerDatosSegmentosGP4(String procesoBatch) throws MareException {
      UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerDatosSegmentosGP4(String procesoBatch): Entrada ");      
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      
      if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_PROPERTIES)) {
          this.obtenerTamanioSegmentosGP4();
          this.obtenerMaximaCantSegmentosGP4();   
      }
      if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_MANUAL) || 
           this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_AUTOMATICO)) {
          this.tamanioSegmentosGP4 = new Long(daoSolicitud.obtenerTamanioSegmento(procesoBatch, "GP4"));
          this.maximaCantSegmentosGP4 = new Long(daoSolicitud.obtenerMaxCantSegmento(procesoBatch, "GP4"));   
          this.cantSegmentosInicGP4 = new Long(daoSolicitud.obtenerTamanioSegmentoInicio(procesoBatch, "GP4"));
      }
      
      UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerDatosSegmentosGP4(String procesoBatch): Salida ");       
    }
    
}
 
