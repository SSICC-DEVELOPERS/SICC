/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesCriterio;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesGrupo;
import es.indra.sicc.dtos.ped.DTOAlarmaPedidos;
import es.indra.sicc.dtos.ped.DTOAlarmas;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTOCargaInicialMonitor;
import es.indra.sicc.dtos.ped.DTODatosMonitor;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOElementoPlantilla;
import es.indra.sicc.dtos.ped.DTOGrupoSolicitudes;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOListaSolicitudes;
import es.indra.sicc.dtos.ped.DTOListaTipificaciones;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOPlantilla;
import es.indra.sicc.dtos.ped.DTOTipificacion;
import es.indra.sicc.entidades.ped.PlantillaMonitorDetalleLocal;
import es.indra.sicc.entidades.ped.PlantillaMonitorDetalleLocalHome;
import es.indra.sicc.entidades.ped.PlantillaMonitorLocal;
import es.indra.sicc.entidades.ped.PlantillaMonitorLocalHome;
import es.indra.sicc.entidades.ped.SecuenciaTipificacionLocal;
import es.indra.sicc.entidades.ped.SecuenciaTipificacionLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

import es.indra.sicc.entidades.ped.MonitorEjecucionLocal;
import es.indra.sicc.entidades.ped.MonitorEjecucionLocalHome;

import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;

import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Collections;

import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMonitorBean implements SessionBean {
    private SessionContext sessionContext;
    private UtilidadesLog log = new UtilidadesLog();
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }

    public DTOCargaInicialMonitor cargaInicialMonitor(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.cargaInicialMonitor(DTOBelcorp dto): Entrada ");
        
        DTOOID param = new DTOOID();
        param.setOidIdioma(dto.getOidIdioma());
        param.setOidPais(dto.getOidPais());

        try {            
            MONMantenimientoSEGHome mmsHome = getMONMantenimientoSEGHome();
            DTOSalida dtoSSeg = mmsHome.create().recuperarPais(param);
        } catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception) {
            sessionContext.setRollbackOnly();
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOCargaInicialMonitor dtoCI = new DTOCargaInicialMonitor();

        PaisLocal paisLocal = null;
        boolean utPlant = false;
        try {
            PaisLocalHome paisLocalHome = new PaisLocalHome();
            paisLocal = paisLocalHome.findByPrimaryKey(dto.getOidPais());
        } catch (NoResultException e) {            
            UtilidadesLog.error("NoResultException: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("PersistenceException: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 
        String indiSecuMoni = paisLocal.getVal_indi_secu_moni();
        if (indiSecuMoni.trim().equals(new String("S"))) {
            utPlant = true;
        } else if (indiSecuMoni.trim().equals(new String("1"))) {
            utPlant = true;
        }
        

        dtoCI.setUsaPlantillas(Boolean.valueOf(utPlant));

        /** Por lo anterior **/
        RecordSet rs = new RecordSet();
        DAOMonitor daoM = new DAOMonitor();
        if ((dtoCI.getUsaPlantillas() != null) && dtoCI.getUsaPlantillas().booleanValue()) {
            rs = daoM.obtenerPlantillas(dto.getOidPais());
        }

        dtoCI.setPlantillas(rs);
        
        // sapaza -- PER-SiCC-2011-0079 -- 14/02/2011
        RecordSet rsAux = daoM.obtenerDatosCampañaActiva(dto.getOidPais());
        if(rsAux!=null && !rsAux.esVacio()) {
            if (rsAux.getValueAt(0, "COD_PAIS") != null) {
                dtoCI.setCodigoPais(rsAux.getValueAt(0, "COD_PAIS").toString());
            }
            if (rsAux.getValueAt(0, "COD_PERI") != null) {
                dtoCI.setCodigoPeriodo(rsAux.getValueAt(0, "COD_PERI").toString());
            }
            if (rsAux.getValueAt(0, "FEC_PROC") != null) {
               dtoCI.setFechaProceso((java.sql.Date)rsAux.getValueAt(0, "FEC_PROC"));
            }
            if (rsAux.getValueAt(0, "OID_PERI") != null) {
                dtoCI.setOidPeriodo(new Long(rsAux.getValueAt(0, "OID_PERI").toString()));
            }
            
            //Recuperamos datos de la campaña siguiente
            if(dtoCI.getOidPeriodo()!=null) {
                RecordSet rsSig = daoM.obtenerDatosCampañaSiguiente(dtoCI.getOidPeriodo());
                
                if(rsSig!=null && !rsSig.esVacio()) {
                    if (rsSig.getValueAt(0, "OID_PERI") != null) {
                        dtoCI.setOidPeriodoSiguiente(new Long(rsSig.getValueAt(0, "OID_PERI").toString()));
                    }
                    if (rsSig.getValueAt(0, "FEC_FINA") != null) {
                       dtoCI.setFechaFinPeriodoSiguiente((java.sql.Date)rsSig.getValueAt(0, "FEC_FINA"));
                    }
                }
            }    
        }
        
        UtilidadesLog.info("MONMonitorBean.cargaInicialMonitor(DTOBelcorp dto): Salida ");
        return dtoCI;
    }

    public DTODatosMonitor obtenerDatos(DTOBuscarDatosMonitor criterios) throws MareException {
        UtilidadesLog.info("MONMonitorBean.obtenerDatos(DTOBuscarDatosMonitor criterios): Entrada ");
        DAOMonitor daoM = new DAOMonitor();
        RecordSet rs = daoM.obtenerDatos(criterios);

        long[] totales = new long[5];

        for (int k = 0; k < 5; k++) {
            totales[k] = 0;
        }

        DTODatosMonitor dtoDM = new DTODatosMonitor();

        RecordSet rsRes = new RecordSet();
        rsRes.addColumn("tieneTextBox");

        for (int i = 0; i < rs.getColumnCount(); i++) {
            rsRes.addColumn(rs.getColumnName(i));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            Vector fila = new Vector();

            //if ( la tercera columna es null) 
            if (rs.getValueAt(i, 2) == null) {
                fila.add("0");
                fila.add("|||" + rs.getValueAt(i, 0) + "|e1");

                for (int k = 1; k < rs.getColumnCount(); k++) {
                    //3, 5, 7, 9, 11 
                    if ((k == 3) || (k == 5) || (k == 7) || (k == 9) || (k == 11)) {
                        fila.add("|||" + rs.getValueAt(i, k) + "|e1");
                    } else {
                        fila.add(rs.getValueAt(i, k));
                    }
                }

                rsRes.addRow(fila);
                continue;
            } else {
                fila.add("1");

                for (int k = 0; k < rs.getColumnCount(); k++) {
                    if ((k == 4) || (k == 6) || (k == 8) || (k == 10) || (k == 12)) {
                        fila.add(rs.getValueAt(i, k));
                    } else {
                        fila.add("|||" + rs.getValueAt(i, k) + "|datosCampos");
                    }
                }
                rsRes.addRow(fila);
            }

            //Acumulamos la fila a los totales 
            for (int k = 0; k < 5; k++) {
                totales[k] += ((rs.getValueAt(i, (k * 2) + 3) == null) ? 0 : ((BigDecimal) rs.getValueAt(i,(k * 2) + 3)).intValue());
            }
        }

        dtoDM.setProcesos(rsRes);

        dtoDM.setTotalGP1(new Long(totales[0]));
        dtoDM.setTotalGP2(new Long(totales[1]));
        dtoDM.setTotalGP3(new Long(totales[2]));
        dtoDM.setTotalGP4(new Long(totales[3]));
        dtoDM.setTotalGP5(new Long(totales[4]));
        UtilidadesLog.info("MONMonitorBean.obtenerDatos(DTOBuscarDatosMonitor criterios): Salida ");
        return dtoDM;
    }

    public void guardar(DTOPlantilla dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Entrada ");
        PlantillaMonitorLocal plantillaLocal = null;

        if (dto.getOid() != null) {
             UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): dto:"+dto);
            try {
                UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Paso 1");
                PlantillaMonitorLocalHome plantillaLocalHome = new PlantillaMonitorLocalHome();
                plantillaLocal = plantillaLocalHome.findByPrimaryKey(dto.getOid());
                
                plantillaLocal.setDesc(dto.getDescripcion());
                try {
                    plantillaLocalHome.merge(plantillaLocal);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("PersistenceException: ",e);
                    sessionContext.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Paso 2");

                PlantillaMonitorDetalleLocalHome plantDetaLocalHome = new PlantillaMonitorDetalleLocalHome();

                UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Paso 3");
                Collection plantDetaCol = plantDetaLocalHome.findByPlantillaMonitor(dto.getOid());
                Iterator it = plantDetaCol.iterator();

                while (it.hasNext()) {
                    PlantillaMonitorDetalleLocal plantDetaLocal = (PlantillaMonitorDetalleLocal) it.next();
                    try {
                        plantDetaLocalHome.remove(plantDetaLocal);
                    } catch (PersistenceException e) {
                        UtilidadesLog.error("PersistenceException: ",e);
                        sessionContext.setRollbackOnly();
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }
                UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Paso 4");
            } catch (NoResultException e) {
                UtilidadesLog.error("NoResultException: ",e);
                sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                UtilidadesLog.error("PersistenceException: ",e);
                sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        } else {
            if (dto.getCodigo() != null) {
                try {
                    PlantillaMonitorLocalHome plantillaLocalHome = new PlantillaMonitorLocalHome();
                    plantillaLocal = plantillaLocalHome.create(dto.getCodigo(),dto.getDescripcion(), dto.getOidPais());
                } catch (EntityExistsException e) {
                    UtilidadesLog.error("EntityExistsException: ",e);
                    sessionContext.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } catch (PersistenceException e) {
                    UtilidadesLog.error("PersistenceException: ",e);
                    sessionContext.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }

        if(plantillaLocal != null){
            UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Paso 5");
            crearGP(dto.getGp1(), ConstantesPED.GP1, dto, plantillaLocal.getOid());
            crearGP(dto.getGp2(), ConstantesPED.GP2, dto, plantillaLocal.getOid());
            crearGP(dto.getGp3(), ConstantesPED.GP3, dto, plantillaLocal.getOid());
            crearGP(dto.getGp4(), ConstantesPED.GP4, dto, plantillaLocal.getOid());
            crearGP(dto.getGp5(), ConstantesPED.GP5, dto, plantillaLocal.getOid());
        }
        UtilidadesLog.info("MONMonitorBean.guardar(DTOPlantilla dto): Salida ");
    }

  private void crearGP(TreeSet tsGP, Long gp, DTOPlantilla dto, Long oidPlantilla) throws MareException {
    UtilidadesLog.info("MONMonitorBean.crearGP(TreeSet tsGP, Long gp, DTOPlantilla dto, Long oidPlantilla): Entrada ");
    if (tsGP != null) {
      Iterator it = tsGP.iterator();
      long numSecuencia = 10;

      while (it.hasNext()) {
        DTOElementoPlantilla dtoE = (DTOElementoPlantilla) it.next();
        try {
          PlantillaMonitorDetalleLocalHome plantDetaLocalHome = new PlantillaMonitorDetalleLocalHome();

          PlantillaMonitorDetalleLocal plantDetaLocal = plantDetaLocalHome.create(new Long(numSecuencia), dtoE.getTipoSolicitud(), dtoE.getZona(), oidPlantilla, gp);
          plantDetaLocal.setRegion(dtoE.getRegion());
          plantDetaLocalHome.merge(plantDetaLocal);
        } catch (EntityExistsException e) {
          sessionContext.setRollbackOnly();
          UtilidadesLog.error("EntityExistsException:", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (PersistenceException e) {
          sessionContext.setRollbackOnly();
          UtilidadesLog.error("PersistenceException:", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

          numSecuencia = numSecuencia + 10;
        }
    }
    UtilidadesLog.info("MONMonitorBean.crearGP(TreeSet tsGP, Long gp, DTOPlantilla dto, Long oidPlantilla): Salida ");
 }

    public void agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto): Entrada ");
        DAOSolicitud daosolicitud = new DAOSolicitud();
        daosolicitud.agregarSolicitudesGrupo(dto);
        UtilidadesLog.info("MONMonitorBean.agregarSolicitudesGrupo(DTOAgregarSolicitudesGrupo dto): Salida ");
    }

    public void agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto): Entrada ");
        DAOSolicitud daosolicitud = new DAOSolicitud();
        daosolicitud.agregarSolicitudesCriterio(dto);
        UtilidadesLog.info("MONMonitorBean.agregarSolicitudesCriterio(DTOAgregarSolicitudesCriterio dto): Salida ");
    } 

    public DTOSalida cargarGrupoReversion(DTOEGrupoReversion dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.cargarGrupoReversion(DTOEGrupoReversion dto): Entrada ");
        DAOSolicitud daosolicitud = new DAOSolicitud();
        DTOSalida out = daosolicitud.cargarGrupoReversion(dto);
        UtilidadesLog.info("MONMonitorBean.cargarGrupoReversion(DTOEGrupoReversion dto): Salida ");
        return out;
    }

    public DTOSalida contarSolicitudesGrupo(DTOEGrupoReversion dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.contarSolicitudesGrupo(DTOEGrupoReversion dto): Entrada ");        
        DAOSolicitud daosolicitud = new DAOSolicitud();
        DTOSalida out = daosolicitud.contarSolicitudesGrupo(dto);
        UtilidadesLog.info("MONMonitorBean.contarSolicitudesGrupo(DTOEGrupoReversion dto): Salida ");        
        return out;
    }

    public void eliminarSolicitudesGrupo(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.eliminarSolicitudesGrupo(DTOOIDs dto): Entrada ");
        DAOSolicitud dao = new DAOSolicitud();
        dao.eliminarSolicitudesGrupo(dto);
        UtilidadesLog.info("MONMonitorBean.eliminarSolicitudesGrupo(DTOOIDs dto): Salida ");
    }

    public DTOListaSolicitudes obtenerSolicitudes(DTOInfoMonitor dto) throws MareException {
        UtilidadesLog.info("MONMonitorBean.obtenerSolicitudes(DTOInfoMonitor dto): Entrada ");
        DTOListaSolicitudes dtoL = new DTOListaSolicitudes();
        DAOSolicitud daoS = new DAOSolicitud();
        dtoL = daoS.obtenerSolicitudporTipoSolicitudyZona(dto);
        UtilidadesLog.info("MONMonitorBean.obtenerSolicitudes(DTOInfoMonitor dto): Salida ");
        return dtoL;
    }

    public void revertirProcesos(DTOEGrupoReversion dtoe) throws MareException {
        UtilidadesLog.info("MONMonitorBean.revertirProcesos(DTOEGrupoReversion dtoe): Entrada ");
        UtilidadesLog.debug("el dto recibido es: " + dtoe);
        
        DAOMonitor daoM = new DAOMonitor();
        DAOSolicitud daoS = new DAOSolicitud();
        Integer oidGrupoProceso = new Integer(0);

        UtilidadesLog.debug("antes de: daoM.validarGrupoReversion(..."); 
        oidGrupoProceso = daoM.validarGrupoReversion(dtoe);
        UtilidadesLog.debug("luego de: daoM.validarGrupoReversion(...");
        
        DTOListaSolicitudes dtoLS = null;
        if (oidGrupoProceso.longValue() == -1) {
          throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_043));
        }else if (oidGrupoProceso.longValue() == 5 ){ //agregado inc.22468 mamontie 19/01/06 por reversion FAC
            UtilidadesLog.debug("antes de: daoS.obtenerSoliGrupoReverConsolidada(...");
            dtoLS = daoS.obtenerSoliGrupoReverConsolidado(dtoe);
        }else{
            UtilidadesLog.debug("antes de: daoS.obtenerSolicitudporGrupoReversion(...");
            dtoLS = daoS.obtenerSolicitudporGrupoReversion(dtoe);
        }
      
        UtilidadesLog.debug("antes de: daoS.obtenerSolicitudporGrupoReversion(...");
        UtilidadesLog.debug("el dto resultante es: " + dtoLS);
        UtilidadesLog.debug("aca pais es: " + dtoLS.getOidPais());

        DTOArranqueGP dtoAGP = new DTOArranqueGP();

        ArrayList mn = new ArrayList();

        if (dtoLS.getLista() != null) {
            mn.addAll((Collection) dtoLS.getLista());
        }

        DTOParametroMonitor dtoPM = new DTOParametroMonitor();
        dtoPM.setOidGrupoProceso(new Long(oidGrupoProceso.longValue()));
        dtoPM.setGrupoReversion(dtoe.getGrupoReversion());

        dtoAGP.setListaSolicitudes(mn);
        dtoAGP.setParametros(dtoPM);

        MareBusinessID id = new MareBusinessID(new String("PEDReversarSecuenciaProcesos"));
        DTOBatch dtoB = new DTOBatch(new String("MONITOR"), id, dtoAGP, sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.debug("(SCS)a punto de: batch.executeMLN(....con DTOBatch: " + dtoB);
        try {
            BatchUtil batch = new BatchUtil();
            UtilidadesLog.debug("antes de batch.executeMLN(...");
            batch.executeMLN(dtoB, "PEDSecuenciaProcesos");
            UtilidadesLog.debug("luego de batch.executeMLN(...");
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONMonitorBean.revertirProcesos(DTOEGrupoReversion dtoe): Salida ");
    }

  public void procesarSolicitudes(DTOInfoMonitor dtoin) throws MareException {
    UtilidadesLog.info("MONMonitorBean.procesarSolicitudes(DTOInfoMonitor dtoin): Entrada ");
    if (dtoin == null) {
      return;
    }
        
    if (dtoin.getSecuencia().size()>0) {
      ComparadorSecuencia comparator = new ComparadorSecuencia();
      Collections.sort(dtoin.getSecuencia(), comparator);
    }
        
    boolean indTipificacion = false;
        
        //(SCS)-Se verifica que ninguna de los grupos de solicitudes se esta procesando en este 
        // momento (usando como criterio el tipo de solicitud, zona y gp) 
    ArrayList lista = new ArrayList();
    lista = dtoin.getSecuencia();        
        
    if (lista.size()>0) 
      UtilidadesLog.debug("Lista de Sol., no nula, verifico ejec.");
      if (!(this.verificarEjecucionActiva(lista, dtoin.getGP()))) {
            //MAREException 
        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_041)); 
      }
      
      //doliva -- cambio Optimizacion Logs -- 09/04/2010
      if(log.isDebugEnabled())
        UtilidadesLog.debug("SCS, aca el GP, es: " + dtoin.getGP().longValue());

      UtilidadesLog.debug("estamos en procesarSolicitudes..........");

      DTOParametroMonitor dtoPM = new DTOParametroMonitor();
      DTOListaSolicitudes dtoLS = new DTOListaSolicitudes();

      DAOGruposProceso daoGP = new DAOGruposProceso();
      dtoPM.setOidGrupoProceso(daoGP.obtenerProximoGrupoProceso(dtoin.getGP()));
      dtoPM.setSecuencia(dtoin.getSecuencia());
      dtoPM.setOidIdioma(dtoin.getOidIdioma());
      dtoPM.setOidPais(dtoin.getOidPais()); // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011

      if(dtoin.getCodigoUsuario()!=null)
        dtoPM.setCodigoUsuario(dtoin.getCodigoUsuario());

      if (dtoin.getGP().longValue() == ConstantesPED.GP1.longValue()) {
        UtilidadesLog.debug("ConstantesPED.GP1..........");
        DAOSolicitud daosolicitud = new DAOSolicitud();        
        dtoLS = daosolicitud.obtenerSolicitudporTipoSolicitudyZonaPerf(dtoin);
        dtoPM.setModoFacturacion("R");
        dtoPM.setFechaFacturacion(dtoin.getFechaFacturacion());
        dtoPM.setIndOrdenesCompra(dtoin.getIndOrdenesCompra()); // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
      }

      if (dtoin.getGP().longValue() == ConstantesPED.GP3.longValue()) {
        if (dtoin.getIndTipificacion() != null) {
          if (dtoin.getIndTipificacion().booleanValue()) {
           //Valido que hay una tipificacion definida
            try {
              UtilidadesLog.debug("ConstantesPED.GP3; getSecuenciaTipificacionLocalHome..........");
              SecuenciaTipificacionLocalHome secuenciaTipificacionLocalHome = new SecuenciaTipificacionLocalHome();

              if (secuenciaTipificacionLocalHome.findByPais(dtoin.getOidPais()).size() > 0) {
                            //Buscar los solicitudes en el orden de la tipificacion y monitor
                DAOSolicitud daosolicitud = new DAOSolicitud();
                UtilidadesLog.debug("daosolicitud.obtenerSolicitudporGestionStock..........");
                dtoLS = daosolicitud.obtenerSolicitudXTipificacionPerf(dtoin);
                indTipificacion = true;
              } else {
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_031)); 
              }
            } catch (NoResultException e) {
               UtilidadesLog.error("NoResultException: ",e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
               UtilidadesLog.error("PersistenceException: ",e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
          } else {
                    //Busco las solicitudes en el orden del monitor 
            DAOSolicitud daosolicitud = new DAOSolicitud();
            UtilidadesLog.debug("daosolicitud.obtenerSolicitudporTipoSolicitudyZona..........");
            dtoLS = daosolicitud.obtenerSolicitudporTipoSolicitudyZonaPerf(dtoin);
          }
        }
      }

      if (dtoin.getGP().longValue() == ConstantesPED.GP4.longValue()) {
         if (dtoin.getIndPreFacturacion() != null) {
            if (dtoin.getIndPreFacturacion().booleanValue()) {
              DAOSolicitud daosolicitud = new DAOSolicitud();
              UtilidadesLog.debug("ConstantesPED.GP4; daosolicitud.obtenerSolicitudporPrefacturar..........");
              dtoLS = daosolicitud.obtenerSolicitudporPrefacturar(dtoin);

              dtoPM.setModoFacturacion(new String("P"));

              if (dtoin.getFechaFacturacion() != null) {
                dtoPM.setFechaFacturacion(dtoin.getFechaFacturacion());
              }
           } else {
           
              DAOSolicitud daosolicitud = new DAOSolicitud();
              UtilidadesLog.debug("obtenerSolicitudporTipoSolicitudyZona..........");

              dtoLS = daosolicitud.obtenerSolicitudporTipoSolicitudyZonaPerf(dtoin);

              dtoPM.setModoFacturacion(new String("R"));
              dtoPM.setFechaFacturacion(dtoin.getFechaFacturacion());
           }
         }
       }

        //Realiza la solicitud al subsistema Batch para que lance el proceso 
       DTOArranqueGP dtoAGP = new DTOArranqueGP();
       ArrayList mn = new ArrayList();

       if (dtoLS.getLista() != null) {
         mn.addAll((Collection) dtoLS.getLista());
       }
        
       if (indTipificacion){
         dtoAGP.setIndTipificacion(Boolean.TRUE);
       }

       dtoAGP.setListaSolicitudes(mn);
       dtoAGP.setParametros(dtoPM);

       MareBusinessID id = new MareBusinessID(new String("PEDEjecutarSecuenciaProcesos"));
        
       DTOBatch dtoB = new DTOBatch(new String("MONITOR"), id, dtoAGP, sessionContext.getCallerPrincipal().getName());
       
       // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
       dtoin.setCodigoBatch(dtoB.getProcessID());
       
       // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
       dtoAGP.setCodigoBatch(dtoB.getProcessID());
       
       if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
         UtilidadesLog.debug("(SCS)a punto de: batch.executeMLN(....con DTOBatch: " + dtoB);
       
       try {
         UtilidadesLog.debug("llamo a batch..........");
            
         BatchUtil batch = new BatchUtil();
         DTOSalidaBatch salidaBatch = (DTOSalidaBatch)batch.executeMLN(dtoB, "PEDSecuenciaProcesos"); 
         UtilidadesLog.debug("llamé a batch..........");
         this.registrarEjecucion(dtoin.getSecuencia(), dtoin.getGP(), salidaBatch.getProcessID()) ;
         UtilidadesLog.debug("sali de registrarEjecucion(....");
       } catch (RemoteException re) {
         throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
       }
       UtilidadesLog.info("MONMonitorBean.procesarSolicitudes(DTOInfoMonitor dtoin): Salida ");
    }

    public void guardarTipificaciones(DTOListaTipificaciones dotin) throws MareException {
      UtilidadesLog.info("MONMonitorBean.guardarTipificaciones(DTOListaTipificaciones dotin): Entrada ");
      try {
        UtilidadesLog.debug("Estoy dentro de: guardarTipificaciones");
        UtilidadesLog.debug("DTO, Recibido: " + dotin);
        UtilidadesLog.debug("Pais, Recibido: " + dotin.getOidPais());
        
        SecuenciaTipificacionLocalHome secuenciaTipificacionLocalHome = new SecuenciaTipificacionLocalHome();
        Collection col = secuenciaTipificacionLocalHome.findByPais(dotin.getOidPais());

        UtilidadesLog.debug("Collection, Recibida: " + col);
        SecuenciaTipificacionLocal secTipifLocal;

        if (col.size() > 0) {
          Iterator it = col.iterator();
          while (it.hasNext()) {
            secTipifLocal = (SecuenciaTipificacionLocal) it.next();
            try {
                secuenciaTipificacionLocalHome.remove(secTipifLocal);
            } catch (PersistenceException e) {
                UtilidadesLog.error("PersistenceException: ", e);
                sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
          }
        }

        UtilidadesLog.debug("Removi............");
        ArrayList tipific = dotin.getTipificaciones();

        for (int i = 0; i < tipific.size(); i++) {
           DTOTipificacion elmDtoTipi = (DTOTipificacion) tipific.get(i);
                
           try {
               secTipifLocal = secuenciaTipificacionLocalHome.create(elmDtoTipi.getOrden(), dotin.getOidPais(), elmDtoTipi.getOidTipoCliente());
    
               if (elmDtoTipi.getOidSubtipoCliente().longValue() == -1) {
                 secTipifLocal.setSubtipoCliente(null);
               } else {
                 secTipifLocal.setSubtipoCliente(elmDtoTipi.getOidSubtipoCliente());
               }
               
               if (elmDtoTipi.getOidClasificacion().longValue() == -1) {
                 secTipifLocal.setClasificacion(null);
               } else {
                 secTipifLocal.setClasificacion(elmDtoTipi.getOidClasificacion());
               }
               
               if (elmDtoTipi.getOidTipoClasificacion().longValue() == -1) {
                 secTipifLocal.setTipoClasificacion(null);
               } else {
                 secTipifLocal.setTipoClasificacion(elmDtoTipi.getOidTipoClasificacion());
               }
               
               secuenciaTipificacionLocalHome.merge(secTipifLocal);
           } catch (PersistenceException e) {
               UtilidadesLog.error("PersistenceException: ", e);
               sessionContext.setRollbackOnly();
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
         }
        } catch (NoResultException e) {
          sessionContext.setRollbackOnly();
          UtilidadesLog.error("NoResultException: ",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
          UtilidadesLog.error("PersistenceException: ",e);
          sessionContext.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMonitorBean.guardarTipificaciones(DTOListaTipificaciones dotin): Salida ");
    }

    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoSEGHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
    }


    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 10/09/2004
     * @Recibe: DTOAlarmaPedidos
     * @Devuelve: DTOAlarmas
     * @Descripción: Cuenta el número de pedidos sin facturar
     * @DMCO: SICC-DMCO-PED-201-354-N002b 
     **/
    public DTOAlarmas cuentaAlarmas(DTOAlarmaPedidos dtoe) throws MareException {
        UtilidadesLog.info("MONMonitorBean.cuentaAlarmas(DTOAlarmaPedidos dtoe): Entrada ");
        DTOAlarmas miDto = new DTOAlarmas();
        DAOMonitor miDao = new DAOMonitor();

        miDto = miDao.cuentaAlarmas(dtoe);
        UtilidadesLog.info("MONMonitorBean.cuentaAlarmas(DTOAlarmaPedidos dtoe): Salida ");
        return miDto;
    }  //FIN cuentaAlarmas

    /**
      * @Autor: Hugo A. Mansi
      * @Fecha: 10/09/2004
      * @Recibe: DTOAlarmaPedidos
      * @Devuelve: DTOAlarmas
      * @Descripción: Obtiene los pedidos sin facturar
      * @DMCO: SICC-DMCO-PED-201-354-N002b 
    **/
	public DTOSalida cargaAlarmaPedidos(DTOAlarmaPedidos dtoe) throws MareException {
    UtilidadesLog.info("MONMonitorBean.cargaAlarmaPedidos(DTOAlarmaPedidos dtoe): Entrada ");
    DTOSalida miDto = new DTOSalida();
    DAOMonitor miDao = new DAOMonitor();
    miDto = miDao.consultaAlarmaPedidos(dtoe);
    UtilidadesLog.info("MONMonitorBean.cargaAlarmaPedidos(DTOAlarmaPedidos dtoe): Salida ");
		return miDto;
	}//FIN cargaAlarmaPedidos

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }
  
   /**
   * @Autor: SCSaavedra
   * @Fecha: 10/02/2005
   */  
  private boolean verificarEjecucionActiva(ArrayList secuencia, Long gp) throws MareException {
    //doliva -- cambio Optimizacion Logs -- 09/04/2010
     if(log.isDebugEnabled())
        UtilidadesLog.debug("secuencia recibida en verificarEjecucionActiva(... " + secuencia);
    DAOMonitor dMonitor = new DAOMonitor();
    return dMonitor.verificarEjecucionActiva(secuencia, gp);
  }
  
   /**
   * @Autor: SCSaavedra
   * @Fecha: 10/02/2005
   */  
  private void registrarEjecucion(ArrayList secuencia, Long gp, String CodigoProceso) throws MareException {
    UtilidadesLog.info("MONMonitorBean.registrarEjecucion(ArrayList secuencia, Long gp, String CodigoProceso): Entrada ");
    //doliva -- cambio Optimizacion Logs -- 09/04/2010
    if(log.isDebugEnabled())
        UtilidadesLog.debug("Secuencia: " + secuencia);
    if (secuencia.size()>0) {
      Iterator it = null;
      it = secuencia.iterator();
      DTOSecuenciaSolicitudes elemento = null;
      
         MonitorEjecucionLocalHome mEjeLocalHome = new MonitorEjecucionLocalHome();
         while(it.hasNext()) {
           elemento = (DTOSecuenciaSolicitudes)it.next();
             //doliva -- cambio Optimizacion Logs -- 09/04/2010
             if(log.isDebugEnabled())
                 UtilidadesLog.debug("Iterando secuencia, elemento: " + elemento);
           try {              
              MonitorEjecucionLocal plantillaLocal = mEjeLocalHome.findByUK(elemento.getOidTipoSolicitud(), elemento.getOidZona(), gp);
               //doliva -- cambio Optimizacion Logs -- 09/04/2010
              if(log.isDebugEnabled())
                   UtilidadesLog.debug("finder en: MonitorEjecucion, con: " + elemento.getOidTipoSolicitud() + "-" + elemento.getOidZona() + "-" + gp);
                   UtilidadesLog.debug("Esta!, actualizo en codigo de proceso, con: " + CodigoProceso);                                                                            
              plantillaLocal.setCodProceso(CodigoProceso); 
              try {
                  mEjeLocalHome.merge(plantillaLocal);
              } catch (PersistenceException e) {
                  UtilidadesLog.error("PersistenceException: ", e);
                  sessionContext.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
           } catch (NoResultException e) {
             UtilidadesLog.debug("finder exc., creo registro!!");
             UtilidadesLog.debug("codigo de proceso a crear: " + CodigoProceso);
             try {
                mEjeLocalHome.create(elemento.getOidTipoSolicitud(), gp, elemento.getOidZona(), CodigoProceso);
             } catch (PersistenceException pe) {
                 UtilidadesLog.error("PersistenceException: ", pe);
                 sessionContext.setRollbackOnly();
                 throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
             UtilidadesLog.debug("registro creado!!");                     
           } catch (PersistenceException e) {
               UtilidadesLog.error("PersistenceException: ", e);
               sessionContext.setRollbackOnly();
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
         }
    }
    UtilidadesLog.info("MONMonitorBean.registrarEjecucion(ArrayList secuencia, Long gp, String CodigoProceso): Salida ");
  }


    public DTODatosMonitor obtenerDatosMejorado(DTOBuscarDatosMonitor criterios) throws MareException{
        UtilidadesLog.info("MONMonitorBean.obtenerDatosMejorado(DTOBuscarDatosMonitor criterios): Entrada ");
        DAOMonitor daoM = new DAOMonitor();
        RecordSet rs = daoM.obtenerDatosNuevoEstadoBatch(criterios);

        long[] totales = new long[5];

        for (int k = 0; k < 5; k++) {
            totales[k] = 0;
        }

        DTODatosMonitor dtoDM = new DTODatosMonitor();

        RecordSet rsRes = new RecordSet();
        rsRes.addColumn("tieneTextBox");

        for (int i = 0; i < rs.getColumnCount(); i++) {
            rsRes.addColumn(rs.getColumnName(i));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            Vector fila = new Vector();

            //if ( la tercera columna es null) 
            if (rs.getValueAt(i, 2) == null) {
                fila.add("0");

                for (int k = 0; k < rs.getColumnCount(); k++) {
                    fila.add(rs.getValueAt(i, k));
                }

                rsRes.addRow(fila);

                continue;
            } else {
                fila.add("1");
                for (int k = 0; k < rs.getColumnCount(); k++) {
                    fila.add(rs.getValueAt(i, k));
                }
                rsRes.addRow(fila);
            }

            //Acumulamos la fila a los totales 
            for (int k = 0; k < 5; k++) {
                totales[k] += ((rs.getValueAt(i, (k * 2) + 3) == null) ? 0
                                                                       : ((BigDecimal) rs.getValueAt(i,
                    (k * 2) + 3)).intValue());
            }
        }
        dtoDM.setProcesos(rsRes);
        dtoDM.setTotalGP1(new Long(totales[0]));
        dtoDM.setTotalGP2(new Long(totales[1]));
        dtoDM.setTotalGP3(new Long(totales[2]));
        dtoDM.setTotalGP4(new Long(totales[3]));
        dtoDM.setTotalGP5(new Long(totales[4]));
        UtilidadesLog.info("MONMonitorBean.obtenerDatosMejorado(DTOBuscarDatosMonitor criterios): Salida ");
        return dtoDM;
    }

  public DTOListaSolicitudes obtenerSolicitudesReversion(DTOInfoMonitor dto) throws MareException {
    UtilidadesLog.info("MONMonitorBean.obtenerSolicitudesReversion(DTOInfoMonitor dto): Entrada ");
    DTOListaSolicitudes dtoL = new DTOListaSolicitudes();
    DAOSolicitud daoS = new DAOSolicitud();        
    dtoL = daoS.obtenerSolicitudporTipoSolicitudyZona(dto);
        
    Vector arOid = dtoL.getLista();
        
    for (int i = 0; i < arOid.size(); i++) {
       DTOSolicitudValidacion dtoSV = (DTOSolicitudValidacion) arOid.get(i);
          
       if ((dtoSV.getGP().longValue() == ConstantesPED.GP5.longValue()) && (dtoSV.getIndNoConso().longValue() == 1)) {
         throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_055)); 
       }
    }        
    UtilidadesLog.info("MONMonitorBean.obtenerSolicitudesReversion(DTOInfoMonitor dto): Salida ");
    return dtoL;
  }

    /**
     * Metodo que lanza el proceso de reversion de solicitudes de servicios
     * Agregado por HRCS - Fecha 23/07/2007 - Cambio Sicc20070303
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE DTO de Entrada con la fecha de facturacion
     */
    public void revertirSolicitudesServicio(DTOInfoMonitor dtoE) throws MareException {
    
        UtilidadesLog.info("MONMonitorBean.revertirSolicitudesServicio(DTOParametroMonitor dtoe): Entrada ");
        UtilidadesLog.debug("el dto recibido es: " + dtoE);

        MareBusinessID id = new MareBusinessID(new String("PEDReversarSolicitudesServicio"));
        DTOBatch dtoB = new DTOBatch(new String("MONITOR"), id, dtoE, sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.debug("(SCS)a punto de: batch.executeMLN(....con DTOBatch: " + dtoB);
        try {
            BatchUtil batch = new BatchUtil();
            UtilidadesLog.debug("antes de batch.executeMLN(...");
            batch.executeMLN(dtoB, "PEDSecuenciaProcesos");
            UtilidadesLog.debug("luego de batch.executeMLN(...");
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONMonitorBean.revertirSolicitudesServicio(DTOParametroMonitor dtoe): Salida ");    
    }

    // sapaza -- PER-SiCC-2011-0529 -- 05/08/2011
    public String procesarSolicitudesIntegracionSSICC(DTOInfoMonitor dtoin) throws MareException {
        this.procesarSolicitudes(dtoin);
        
        return dtoin.getCodigoBatch();
    }
    
}
