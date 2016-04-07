package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.fac.DTOFACListaConsolidados;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOAnticipo;
import es.indra.sicc.dtos.inc.DTOClienteAnticipo;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.dtos.inc.DTOClienteEgreso;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.entidades.inc.GanadorasLocalHome;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCierreIncentivosBean
        implements SessionBean {
    private SessionContext sessionContext;
	  
    
    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private Integer tamanioSegmento;  
    private Integer numeroMaximoSegmentos;      

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

    public void cerrarIncentivos(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.cerrarIncentivos(DTOFACProcesoCierre dtoin):Entrada");

        UtilidadesLog.debug("MONCierreIncentivos.cerrarIncentivos()");
        UtilidadesLog.debug("DTOFACProcesoCierre " + dtoin);
        UtilidadesLog.debug("pais " + dtoin.getOidPais());

        try {
        
            // vbongiov 13/03/206 - INC 46 y INC 60
            //jrivas 30/11/2006
            this.preProcesoCierreIncentivosPerf(dtoin);
            
            // Durante este proceso se realiza el cierre de los siguientes concursos:
            // Consultoras, Gerentes, MultiNivel y Ranking 
            this.cerrarConsultoras(dtoin);
            
            this.cerrarGerentes(dtoin);
            
            this.cerrarMultinivel(dtoin);
            
            this.evaluarRanking(dtoin);
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        } 
        
        //UtilidadesLog.warn("cerrarIncentivos TOTAL --> " + (System.currentTimeMillis() - comienzo));

        UtilidadesLog.debug("****Salio MONCierreIncentivos.cerrarIncentivos****");
        UtilidadesLog.info("MONCierreIncentivos.cerrarIncentivos(DTOFACProcesoCierre dtoin):Salida");
    }

    private void cerrarConsultoras(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.cerrarConsultoras(DTOFACProcesoCierre dtoin):entrada");
        // Se ejecuta el proceso de DeterminarGanadorasConsultoras 
        UtilidadesLog.debug("****Entro MONCierreIncentivos.cerrarConsultoras****");

        try {
            final InitialContext context = new InitialContext();
            MONPremiacionHome mONPremiacionHome = (MONPremiacionHome) PortableRemoteObject.narrow(context.lookup("MONPremiacion"),
                                                                                                  MONPremiacionHome.class);
            MONPremiacion mONPremiacion = mONPremiacionHome.create();
            Periodo periodo = new Periodo();
            periodo.setOidPeriodo(dtoin.getPeriodo());
            //jrivas 20080535
            mONPremiacion.determinarGanadorasRecomendacionConsultora(dtoin.getPeriodo(), ConstantesFAC.TIPO_CIERRE_PERIODO, null, null);
        } catch (NamingException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw ex;
        } catch (RemoteException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Salio MONCierreIncentivos.cerrarConsultoras****");
        UtilidadesLog.info("MONCierreIncentivos.cerrarConsultoras(DTOFACProcesoCierre dtoin):Salida");
    }


    /** 
     * Se ejecuta el proceso de Aplicar Requisitos de Premiación Gerentes.
     * No es necesario llamar a los procesos de Calcular puntospara los diferentes concursos 
     * de gerentes dado que esto se hace según se van recibiendo las solicitudes.
     * @Cambio incidencia 20716
     * @Autor gdmarzi
     */
    private void cerrarGerentes(DTOFACProcesoCierre dtoin) throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.cerrarGerentes(DTOFACProcesoCierre dtoin):Entrada");
        UtilidadesLog.debug("****Entro MONCierreIncentivos.cerrarGerentes****");
        
        try {
            // Calcular Variable de Venta
            MONVariablesVentaHome monVariablesVentaHome = getMONVariablesVentaHome();            
            MONVariablesVenta monVariablesVenta = monVariablesVentaHome.create();
            
            monVariablesVenta.calcularVariablesVenta(dtoin);
            
            this.anularPuntajesEgresos(dtoin);
        
            final InitialContext context = new InitialContext();
            MONPremiacionHome mONPremiacionHome = (MONPremiacionHome) PortableRemoteObject.narrow(context.lookup("MONPremiacion"), MONPremiacionHome.class);
            MONPremiacion mONPremiacion;
            mONPremiacion = mONPremiacionHome.create();

            mONPremiacion.premiarRecomendacionGerente(dtoin.getOidPais(), dtoin.getPeriodo(), dtoin.getSubacceso());
                                                                                                  
            mONPremiacion.premiarGerentes(dtoin);
                        
            this.tratarCumplimientoBonoAnual(dtoin);
             
        } catch (NamingException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException e) {
            UtilidadesLog.error("ERROR ", e);
            throw e;
        } catch (RemoteException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug("****Salio MONCierreIncentivos.cerrarGerentes****");
        UtilidadesLog.info("MONCierreIncentivos.cerrarGerentes(DTOFACProcesoCierre dtoin):Salida");
    }


    private void cerrarMultinivel(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.cerrarMultinivel(DTOFACProcesoCierre dtoin):Entrada");
        // Se ejecuta el proceso de determinar Ganadores Multinivel.
        UtilidadesLog.debug("****Entro MONCierreIncentivos.cerrarMultinivel****");

        try {
            final InitialContext context = new InitialContext();
            MONPremiacionMultinivelHome mONPremiacionMultinivelHome = (MONPremiacionMultinivelHome) PortableRemoteObject.narrow(context.lookup("MONPremiacionMultinivel"),
                                                                                                                                MONPremiacionMultinivelHome.class);
            MONPremiacionMultinivel mONPremiacionMultinivel = mONPremiacionMultinivelHome.create();
            mONPremiacionMultinivel.determinarGanadoraMultinivel(dtoin.getPeriodo());
        } catch (NamingException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw ex;
        } catch (RemoteException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONCierreIncentivos.cerrarMultinivel(DTOFACProcesoCierre dtoin):Salida");
        UtilidadesLog.debug("****Salio MONCierreIncentivos.cerrarMultinivel****");
        
    }

    private void evaluarRanking(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.evaluarRanking(DTOFACProcesoCierre dtoin):Entrada");
        // Se ejecuta el proceso de Evaluar Ranking 
        UtilidadesLog.debug("****Entro MONCierreIncentivos.evaluarRanking****");

        try {
            final InitialContext context = new InitialContext();
            MONRankingHome mONRankingHome = (MONRankingHome) PortableRemoteObject.narrow(context.lookup("MONRanking"), MONRankingHome.class);
            MONRanking mONRanking;
            mONRanking = mONRankingHome.create();

            // hay que exponer el metodo en la interfaz remota pero esta tomado
            mONRanking.evaluarRanking(dtoin);
        } catch (NamingException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw ex;
        } catch (RemoteException ex) {
            UtilidadesLog.error("ERROR ", ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Salio MONCierreIncentivos.evaluarRanking****");
        UtilidadesLog.info("MONCierreIncentivos.evaluarRanking(DTOFACProcesoCierre dtoin):Salida");
    }

    private void tratarCumplimientoBonoAnual(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.tratarCumplimientoBonoAnual(DTOFACProcesoCierre dtoin):Entrada");
        UtilidadesLog.debug("****Entro MONCierreIncentivos.tratarCumplimientoBonoAnual****");

        // Se identifican los concursos de esta tipologia 
        DAOGanadora dAOGanadora = new DAOGanadora();
        DAOCandidataGanadora dAOCandidataGanadora = new DAOCandidataGanadora();

        DTOClienteAnticipo[] dtos = dAOGanadora.obtenerClientesConAnticipos();

        for (int z = 0; z < dtos.length; z++) {
            // Se verifica que si se han inclumplidos las metas en periodos de control anteriores 
            if (!dAOCandidataGanadora.validarInclumplientosAnterioresMetas(dtos[z].getOidCliente(), dtos[z].getOidConcurso(), dtoin.getPeriodo())
                                         .booleanValue()) {
                // Se verifica que haya cumplido las metas para el periodo de control actual (El que esta desactivado) 
                if (dAOCandidataGanadora.validarIncumplimientoMetas(dtos[z].getOidCliente(), dtos[z].getOidConcurso(), dtoin.getPeriodo())
                                            .booleanValue()) {
                    //this.descontarAnticipo(dtos[z].getOidConcurso(), dtos[z].getOidCliente(), dtoin.getPeriodo());
                    //Inc 17813
                    this.descontarAnticipo(dtos[z].getOidConcurso(), dtos[z].getOidCliente(), dtoin.getPeriodo(), dtoin);
                }
            }
        }

        UtilidadesLog.debug("****Salio MONCierreIncentivos.tratarCumplimientoBonoAnual****");
        UtilidadesLog.info("MONCierreIncentivos.tratarCumplimientoBonoAnual(DTOFACProcesoCierre dtoin):Salida");
    }

    private void anularPuntajesEgresos(DTOFACProcesoCierre dtoin)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.anularPuntajesEgresos(DTOFACProcesoCierre dtoin):Entrada");
        UtilidadesLog.debug("****Entro MONCierreIncentivos.anularPuntajesEgresos****");

        DAOEgreso dAOEgreso = new DAOEgreso();
        ArrayList clientesEgresados = dAOEgreso.getInformacionClientesEgresados(dtoin.getPeriodo());
        Iterator clientes = clientesEgresados.iterator();
        UtilidadesLog.debug("Numero clientes egresos: " + clientesEgresados.size());

        while (clientes.hasNext()) {
            DTOClienteEgreso dtoe = (DTOClienteEgreso) clientes.next();
            dAOEgreso.hacerCargoCCPuntos(dtoe, dtoin.getPeriodo());
        }

        UtilidadesLog.debug("****Salio MONCierreIncentivos.anularPuntajesEgresos****");
        UtilidadesLog.info("MONCierreIncentivos.anularPuntajesEgresos(DTOFACProcesoCierre dtoin):Salida");
    }

    private void descontarAnticipo(Long oidConcurso, Long oidCliente, Long oidPeriodo, DTOFACProcesoCierre dtoFac)
            throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.descontarAnticipo((Long oidConcurso, Long oidCliente, Long oidPeriodo, DTOFACProcesoCierre dtoFac):Entrada");
        UtilidadesLog.debug("****Entro MONCierreIncentivos.descontarAnticipo****");

        // Se recuperan los anticipos generados para el cliente en este concurso 
        DAOGanadora dAOGanadora = new DAOGanadora();
        ParametrosGeneralesPremiacionLocalHome paramG = this.getParametrosGeneralesPremiacionLocalHome();

        DTOAnticipo[] dtos = dAOGanadora.obtenerPremiosAnticipo(oidCliente, oidConcurso);

        for (int z = 0; z < dtos.length; z++) {
            try {
                ParametrosGeneralesPremiacionLocal paramGralesPremLocal = paramG.findByPrimaryKey(dtos[z].getOidParametrosGeneralesPremiacion());

                Long periodoDespacho = paramGralesPremLocal.getPeriodoDespacho();
                //Inc 17813
                procesarDescuento(oidConcurso, oidCliente, oidPeriodo,dtos[z], dtoFac);
                
                GanadorasLocalHome ganadorasLocalHome = this.getGanadorasLocalHome();
                GanadorasLocal ganadorasLocal = ganadorasLocalHome.create(dtos[z].getUnidades().negate(), new Boolean(false), new Boolean(false),
                                                                          new Boolean(false), dtos[z].getOidGanadora(), periodoDespacho,
                                                                          dtos[z].getOidNivelPremiacion());
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                sessionContext.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                sessionContext.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.debug("****Salio MONCierreIncentivos.descontarAnticipo****");
        UtilidadesLog.info("MONCierreIncentivos.descontarAnticipo((Long oidConcurso, Long oidCliente, Long oidPeriodo, DTOFACProcesoCierre dtoFac):Salida");
    }
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoCierre
     * @param anticipo
     * @param oidPeriodo
     * @param oidCliente
     * @param oidConcurso
     * autor: Cleal por INC BELC300017813
     */
    public void procesarDescuento(Long oidConcurso, Long oidCliente, Long oidPeriodo,
                                  DTOAnticipo anticipo, DTOFACProcesoCierre dtoCierre) throws MareException{
        UtilidadesLog.info("MONCierreIncentivos.procesarDescuento((Long oidConcurso, Long oidCliente, Long oidPeriodo, DTOFACProcesoCierre dtoFac):Entrada");        
        UtilidadesLog.debug("****Entro MONCierreIncentivos.procesarDescuento****");    
        ClientePremiacion cliePrem = new ClientePremiacion();
        //Cleal Inc 17813
        NivelPremiacion nivePrem = new NivelPremiacion();
        try{
            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);
    
            
            cliePrem.setOidPais(dtoCierre.getOidPais());
            cliePrem.setOidCanal(dtoCierre.getCanal());
            cliePrem.setOidMarca(dtoCierre.getMarca());
            cliePrem.setOidCliente(oidCliente);
            
            ClientePremiacionConcurso clientePremiacionConcurso = new ClientePremiacionConcurso();
            clientePremiacionConcurso.setDirigidoA(concursoParametrosGeneralesL.getDirigidoA()); 
            clientePremiacionConcurso.setOidConcurso(oidConcurso);
            
            PremioMonetario premioGanado = new PremioMonetario();
            premioGanado.setNumeroPremio(anticipo.getNumPremio());
            //Inc 17813
            premioGanado.setOidFormaPago(anticipo.getOidFormaPago());
            nivePrem.setOidNivel(anticipo.getOidNivelPremiacion());
            premioGanado.setNivel(nivePrem);
            premioGanado.setUnidades(anticipo.getUnidades());
            //
            
            
            DespacharPremiosHelper despach = new DespacharPremiosHelper();        
            despach.despacharPremioTipoMonetario(cliePrem, premioGanado, clientePremiacionConcurso);
            
            UtilidadesLog.debug("****Entro MONCierreIncentivos.procesarDescuento****");    
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw ex;
        }
        UtilidadesLog.info("MONCierreIncentivos.procesarDescuento((Long oidConcurso, Long oidCliente, Long oidPeriodo, DTOFACProcesoCierre dtoFac):Salida");            
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   13/03/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     */
    public void preProcesoCierreIncentivos(DTOFACProcesoCierre dtoin) throws MareException {
    
        UtilidadesLog.info("MONCierreIncentivos.preProcesoCierreIncentivos(DTOFACProcesoCierre dtoin):Entrada");
        UtilidadesLog.debug("dtoin.getOidPais(): " + dtoin.getOidPais());
        
        try {
        
            FactoriaConcurso.refrescarConcursos();  
            
            DAOBaseCalculo daoBaseCalculo = new DAOBaseCalculo();
            DAOConcursos daoConcursos = new DAOConcursos();
            
            ArrayList arrConcCierre;
            
            MONIncentivos monInc = this.getMONIncentivosHome().create();
                
            arrConcCierre = daoConcursos.obtenerConcursosCierre(dtoin.getOidPais());           
           
            if(IncetivosHelper.contieneConcursos(arrConcCierre).booleanValue()){
            
                RecordSet rs = daoBaseCalculo.obtenerSolicitudesFacturadas(null, dtoin.getPeriodo(), 
                                                                           dtoin.getPeriodo(), Boolean.valueOf(true),Boolean.valueOf(true));
                
                if(rs!=null) {
                                  
                    int cant = rs.getRowCount();
                    
                    for (int row = 0; row < cant; row++) {
                    
                        DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                        
                        registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                             : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                        registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                               : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                        registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                        registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                             : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                        registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                          : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                        registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                           : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                        registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                           : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));
                                                                                           
                        registro.setIndOrdenCompra((rs.getValueAt(row, "IND_OC")).toString().equals("1")?Boolean.TRUE: Boolean.FALSE);
                        
                        registro.setOidAcceso(new Long(((BigDecimal) rs.getValueAt(row, "ACCE_OID_ACCE")).toString()));
                        
                        UtilidadesLog.debug("registro.getOidSolicitud: " + registro.getOidSolicitud());
        
                        monInc.concursarSolicitudPorConcursos(registro, arrConcCierre);
                    }
                }
            }
            
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }                                                                   
        
        UtilidadesLog.info("MONCierreIncentivos.preProcesoCierreIncentivos(DTOFACProcesoCierre dtoin):Salida");
    }


    private MONPremiacionHome getMONPremiacionHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONPremiacionHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class);
    }

    private MONPremiacionMultinivelHome getMONPremiacionMultinivelHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONPremiacionMultinivelHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacionMultinivel"),
                                                                         MONPremiacionMultinivelHome.class);
    }

    private MONRankingHome getMONRankingHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONRankingHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRanking"), MONRankingHome.class);
    }


    private MONIncentivosHome getMONIncentivosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONIncentivosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONIncentivos"), MONIncentivosHome.class);
  }


    private MONVariablesVentaHome getMONVariablesVentaHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONVariablesVentaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONVariablesVenta"), MONVariablesVentaHome.class);
  }


    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   29/12/2006
     * @version 1.00
     * @autor   Julián Rivas
     */
    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private void preProcesoCierreIncentivosPerf(DTOFACProcesoCierre dtoin) throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.preProcesoCierreIncentivosPerf(DTOFACProcesoCierre dtoin):Entrada");
        int count = 0;
        ArrayList segmento= new ArrayList();
        boolean ejecuta = false;
        int segmentosEjecutandoSimultaneamente = 0;
        
        MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String tamanio= (String) mgc.getProperty("application.TamanioSegmentoINC");
        String numero = (String) mgc.getProperty("application.NumeroMaximoSegmentosINC");
        if ((tamanio == null) || (tamanio.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 500
            this.tamanioSegmento = new Integer(500);
        } else {
            this.tamanioSegmento = new Integer(tamanio);
        }
        if ((numero == null) || (numero.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 12 (numero de procesadores de ejecucion)
            this.numeroMaximoSegmentos = new Integer(12);
        } else {
            this.numeroMaximoSegmentos = new Integer(numero);
        }        
        
        try {
            
            // sapaza -- PER-SiCC-2011-1005 -- 21/12/2011
            //FactoriaConcurso.refrescarConcursos();  
            
            DAOBaseCalculo daoBaseCalculo = new DAOBaseCalculo();
            DAOConcursos daoConcursos = new DAOConcursos();
            ArrayList arrConcCierre;

            MONIncentivos monInc = this.getMONIncentivosHome().create();
            arrConcCierre = daoConcursos.obtenerConcursosCierre(dtoin.getOidPais());           
            RecordSet oids = this.obtenerSolicitudesCierre(dtoin.getPeriodo());
            
            if(IncetivosHelper.contieneConcursos(arrConcCierre).booleanValue()){
                if(oids != null) {
                    Long oid;
                    Long cliente;
                    int cant = oids.getRowCount();
                    for (int i = 0; i < cant; ) {
                        oid = new Long (((BigDecimal)oids.getValueAt(i, "OID_SOLI_CABE")).toString());
                        if (count == this.tamanioSegmento.intValue()){
                            cliente = new Long (((BigDecimal)oids.getValueAt(i, "CLIE_OID_CLIE")).toString());
                            
                            //Saco los las ultimas solicitudes del mismo cliente, para agrupar por cliente en el segmento.
                            for (int j = i; cliente.equals(new Long (((BigDecimal)oids.getValueAt(j-1, "CLIE_OID_CLIE")).toString())); j--) {
                                segmento.remove(segmento.size()-1);
                                i--;  
                            }

                            count = 0;
                            ejecuta = true;
                        }else{
                            segmento.add(oid);
                            count++;
                            i++;
                        }

                        if (ejecuta){
                            ejecucionBatch(segmento, dtoin.getIDProc(), dtoin.getOidPais());
                            ejecuta = false;
                            segmento= new ArrayList();
                            segmentosEjecutandoSimultaneamente++;
                        }
                        
                        if (segmentosEjecutandoSimultaneamente == numeroMaximoSegmentos.intValue()){
                            try{
                                UtilidadesLog.debug("*** Se espera el procesamiento en Batch ***");
                                UtilidadesLog.debug("*** El IDProceso es = "+dtoin.getIDProc());
                                this.esperarProcesamiento(dtoin.getIDProc());
                            }catch(InterruptedException ie){
                                UtilidadesLog.error("ERROR" , ie);
                                String codigoError = ie.getMessage();
                                throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
                            }    
                            segmentosEjecutandoSimultaneamente= 0;
                            count = 0;
                        }
                    }
                    
                    if (segmento.size()>0){
                        ejecucionBatch(segmento, dtoin.getIDProc(), dtoin.getOidPais());
                        segmento= new ArrayList();
                    } 
                    
                    try{
                        this.esperarProcesamiento(dtoin.getIDProc());
                    }catch(InterruptedException ie){
                        UtilidadesLog.error("ERROR ", ie);
                        String codigoError = ie.getMessage();
                        throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
                    }    
                }
            }
            
            //UtilidadesLog.warn("Cuantas solis " + oids.getRowCount() + " Ejecucion de TODOS SEGMENTOS " + tiempo + "   por solic " + (tiempo / oids.getRowCount()));

        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }                                                                   
        
        UtilidadesLog.info("MONCierreIncentivos.preProcesoCierreIncentivosPerf(DTOFACProcesoCierre dtoin):Salida");
    }
    
    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private RecordSet obtenerSolicitudesCierre(Long oidPeriodo) throws MareException {
                                                       
        UtilidadesLog.info("obtenerSolicitudesCierre(Long oidPeriodo):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean primerRegistro = true;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE ");
        query.append(" FROM PED_SOLIC_CABEC A ");
        query.append(" WHERE A.FEC_FACT IS NOT NULL ");
        query.append(" AND A.PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND A.IND_OC = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND A.IND_TS_NO_CONSO = " + ConstantesINC.IND_ACTIVO);
        query.append(" ORDER BY A.CLIE_OID_CLIE ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {            
            UtilidadesLog.info("obtenerSolicitudesCierre(Long oidPeriodo):Salida VACIO");
            return null;
        } else {
            UtilidadesLog.info("obtenerSolicitudesCierre(Long oidPeriodo):Salida " + rs.getRowCount());
            return rs;
        }
    }         

    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private void ejecucionBatch(ArrayList listaSegmentos, String IDProceso, Long oidPais) throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Entrada");
    
        UtilidadesLog.debug(" tamanio de segmento = "+listaSegmentos.size());
        DTOFACListaConsolidados dtoSegmento = new DTOFACListaConsolidados();
        dtoSegmento.setListaConsolidados(listaSegmentos);
        dtoSegmento.setOidPais(oidPais);
        IMareDTO DTOSegmento = dtoSegmento;
        DTOSubBatch dtoSubBatch = new DTOSubBatch("INC_CIER_INC_",IDProceso,sessionContext.getCallerPrincipal().getName() ,new MareBusinessID("INCProcesarSegmentoCierreIncentivos"),DTOSegmento);
        try{
            BatchUtil.executeMLN( dtoSubBatch, new MareBusinessID( "INCPROCESOSBATCH" ));
        }catch(RemoteException re){
            UtilidadesLog.error("ERROR ", re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
        }
        UtilidadesLog.info("MONCierreIncentivos.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Salida");
    }

    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException {
        UtilidadesLog.info("MONCierreIncentivos.esperarProcesamiento(String codigoProceso): Entrada");
        BatchUtil.esperarHijos(codigoProceso);	
        UtilidadesLog.info("MONCierreIncentivos.esperarProcesamiento(String codigoProceso): Salida");
    }

    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    public DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException{
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        String IDPROC = dtoin.getProcessID();
        ArrayList arrConcCierre;
        DAOConcursos daoConcursos = new DAOConcursos();

        try {
            MONIncentivosLocal monInc = this.getMONIncentivosLocalHome().create();
            
            if (dtoonline instanceof DTOFACListaConsolidados) {
                DTOFACListaConsolidados segmento = (DTOFACListaConsolidados)dtoonline;
                //UtilidadesLog.warn("procesarSegmento cuantos --> " + segmento.getListaConsolidados().size()); 
                arrConcCierre = daoConcursos.obtenerConcursosCierre(segmento.getOidPais());           
                RecordSet rs = this.obtenerSolicitudFacturadas(segmento.getListaConsolidados());
                if(rs!=null) {
                    int cant = rs.getRowCount();
                    for (int row = 0; row < cant; row++) {
                        DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                        registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                             : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                        registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                               : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                        registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                        registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                             : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                        registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                          : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                        registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                           : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                        registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                           : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));
                                                                                           
                        registro.setIndOrdenCompra((rs.getValueAt(row, "IND_OC")).toString().equals("1")?Boolean.TRUE: Boolean.FALSE);
                        
                        registro.setOidAcceso(new Long(((BigDecimal) rs.getValueAt(row, "ACCE_OID_ACCE")).toString()));
                        
                        UtilidadesLog.debug("registro.getOidSolicitud: " + registro.getOidSolicitud());
        
                        monInc.concursarSolicitudPorConcursosCierre(registro, arrConcCierre);
                    }
                }  
                return new DTOSalidaBatch(0,"Ejecucion MONCierreIncentivos:procesarSegmento completada");  
            } else {
                throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ""));
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
    }


    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    private RecordSet obtenerSolicitudFacturadas(ArrayList oids) throws MareException {
        UtilidadesLog.info("obtenerSolicitudFacturadas(ArrayList oid):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean primerRegistro = true;

        StringBuffer query = new StringBuffer();
        query.append(" SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE, A.ZZON_OID_ZONA, A.PERD_OID_PERI, ");
        query.append("        A.PAIS_OID_PAIS, B.MARC_OID_MARC, B.CANA_OID_CANA, A.IND_OC, ");
        query.append("        SUB.ACCE_OID_ACCE ");
        query.append("   FROM PED_SOLIC_CABEC A, SEG_SUBAC SUB, CRA_PERIO B ");
        query.append("  WHERE A.SBAC_OID_SBAC = SUB.OID_SBAC ");
        query.append("    AND A.PERD_OID_PERI = B.OID_PERI ");
        query.append("  AND (");
        Long oid;
        Iterator it = oids.iterator();
        int count = 0;
        String sOids = "";
        while (it.hasNext()){
            oid = (Long) it.next();
            if (count == 0) {
                sOids = oid.toString();
            } else { 
                sOids = sOids + "," + oid.toString();
            }
            
            if (count == 999)  {
                query.append(" A.OID_SOLI_CABE IN (" + sOids + ") ");                     
                if (it.hasNext()){
                    query.append("  OR ");
                }                    
                count = 0;
                sOids = "";
            } else {
                if (!it.hasNext()){
                    query.append(" A.OID_SOLI_CABE IN (" + sOids + ") ");        
                }                    
                count++;            
            } 
            
            if (!it.hasNext()){              
              query.append(")");
            }
            
        }
        query.append(" ORDER BY A.CLIE_OID_CLIE ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {            
            UtilidadesLog.info("obtenerSolicitudFacturadas(ArrayList oid):SALIDA VACIO");
            return null;
        } else {
            UtilidadesLog.info("obtenerSolicitudFacturadas(ArrayList oid):SALIDA" + rs);
            return rs;
        }
    }    

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

  private MONIncentivosLocalHome getMONIncentivosLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONIncentivosLocalHome)context.lookup("java:comp/env/ejb/local/MONIncentivos");
  }

  private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");
  }
  
    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private GanadorasLocalHome getGanadorasLocalHome() {
            return new GanadorasLocalHome();
    }  
    
    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    // sapaza -- PER-SiCC-2011-0585 -- 23/08/2011
    public void actualizarResumenPedidos(DTOFACProcesoCierre dtoe) throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.actualizarResumenPedidos(DTOFACProcesoCierre dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = BelcorpService.getInstance();

        try {
            ArrayList params = new ArrayList();
            params.add(dtoe.getOidPais().toString());
            params.add(dtoe.getMarca().toString());
            params.add(dtoe.getCanal().toString());
            params.add(dtoe.getPeriodo().toString());
            
            bs.dbService.executeProcedure("PQ_PLANI.INC_PR_ACTUA_RESUM_PEDID", params);
            
            UtilidadesLog.info("MONCierreIncentivos.actualizarResumenPedidos(DTOFACProcesoCierre dtoe): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    // sapaza -- PER-SiCC-2011-0585 -- 23/08/2011
    public void actualizarPedidosIncentivo(DTOFACProcesoCierre dtoe) throws MareException {
        UtilidadesLog.info("MONCierreIncentivos.actualizarPedidosIncentivo(DTOFACProcesoCierre dtoe): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs = BelcorpService.getInstance();

        try {
            ArrayList params = new ArrayList();
            params.add(dtoe.getOidPais().toString());
            params.add(dtoe.getMarca().toString());
            params.add(dtoe.getCanal().toString());
            params.add(dtoe.getPeriodo().toString());
            
            bs.dbService.executeProcedure("PQ_PLANI.INC_PR_ACTUA_PEDID_INCEN", params);
            
            UtilidadesLog.info("MONCierreIncentivos.actualizarPedidosIncentivo(DTOFACProcesoCierre dtoe): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
}
