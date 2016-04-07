package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOConcursoCerrar;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.VersionesConcursoLocal;
import es.indra.sicc.entidades.inc.VersionesConcursoLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.logicanegocio.inc.DAOActivacionCerradoConcursos;
import es.indra.mare.common.exception.MareException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

import java.math.BigDecimal;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCerradoConcursosBean implements SessionBean  {

    private SessionContext ctx;
    
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
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 22/09/2008
     *     - Se modifica condicion para determinar si hay pendientes
     *     - Se agregan trazas en el log de la aplicacion
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOOIDs dtoe
     */
    private void cerrarConcursos(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursos(MareDTO dtoe)" + 
                           ":Entrada");
                           
        UtilidadesLog.info("dtoe: " + dtoe);
                           
        ArrayList aListPeriodosOrdenados = new ArrayList();
        ArrayList aListConcursosCerrar = new ArrayList();
        DTOPeriodo dtoPeriodoE = null;
        DTOBuscarConcursos dtoBuscar = null;
        DTOConcursoCerrar dtoConcursoCerrar = null;
        RecordSet rPeriodos = null;
        RecordSet rConcursos = null;
        DAOActivacionCerradoConcursos daoActivacion = new DAOActivacionCerradoConcursos();
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        RecordSet rConcursosCerrados = new RecordSet();
        rConcursosCerrados.addColumn("OIDCONCURSO");
        String user = null;
        if (dtoe.containsKey("USER_PROPERTY")){
            user = (String)dtoe.getProperty("USER_PROPERTY");
        }
    
        Long oidPais = null;
        Long oidMarca = null;
        Long oidCanal = null;
        Long oidPeriodo = null;
        SimpleDateFormat sdf = null;
        String nombrePeriodo = null;
        Date fechaFinPeriodo = null;
        MONPeriodos monPeriodos = null;
        
        // Esta variable viene en el dtoe cuando el CU es llamado desde el menu
        // y no desde Quartz (en tal caso es null). Segun su valor se hacen
        // diferentes validaciones de fechas para ver si hay que determinar 
        // si quedan pendientes.
        Boolean variableEntorno = null;
        
        boolean invocadoDesdeCRA = false;
        
        /* Obtengo los Periodos */ 
        if (dtoe.containsKey(ConstantesCRA.DATO_PAIS)){
            oidPais = (Long) dtoe.getProperty(ConstantesCRA.DATO_PAIS);
        }

        if (dtoe.containsKey(ConstantesCRA.DATO_MARCA)){
            oidMarca = (Long) dtoe.getProperty(ConstantesCRA.DATO_MARCA);
        }

        if (dtoe.containsKey(ConstantesCRA.DATO_CANAL)){
            oidCanal = (Long) dtoe.getProperty(ConstantesCRA.DATO_CANAL);
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_PERIODO)){
            oidPeriodo = (Long) dtoe.getProperty(ConstantesCRA.DATO_PERIODO);
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_VARIABLE_ENTORNO)){
            variableEntorno = (Boolean)dtoe.getProperty(ConstantesCRA.DATO_VARIABLE_ENTORNO);
        }
        
        if (dtoe.containsKey(ConstantesCRA.DATO_MODULO)) {
            Long modulo = (Long) dtoe.getProperty(ConstantesCRA.DATO_MODULO);
            // Si (modulo == ConstantesSEG.MODULO_CRA)
            if (Long.parseLong(ConstantesSEG.MODULO_CRA) == modulo.longValue()) {
                invocadoDesdeCRA = true;
            }
        }
        
        try {
            monPeriodos = this.getMONPeriodosHome().create();
            DTOOID dtoOidPeri = new DTOOID();
            dtoOidPeri.setOid(oidPeriodo);
            DTOPeriodo dtoPeri = monPeriodos.obtenerPeriodo(dtoOidPeri);
            if (dtoPeri != null) {
                nombrePeriodo = dtoPeri.getNombre();
                fechaFinPeriodo = dtoPeri.getFechaFin();
            } else {
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException("", UtilidadesError.armarCodigoError(error));
            }
        } catch (NamingException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        dtoPeriodoE = new DTOPeriodo();
        dtoPeriodoE.setOidPais(oidPais);
        dtoPeriodoE.setPais(oidPais);
        dtoPeriodoE.setMarca(oidMarca);
        dtoPeriodoE.setCanal(oidCanal);
        
        UtilidadesLog.debug("**** Llamando a obtenerPeriodosOrdenadosFechaIni con: " + dtoPeriodoE);
        rPeriodos = daoActivacion.obtenerPeriodosOrdenadosFechaIni(dtoPeriodoE);
        
        UtilidadesLog.debug("**** Llamando a obtenerPeriodos con: " + rPeriodos);
        aListPeriodosOrdenados = this.obtenerPeriodos(rPeriodos);
        
        /* Obtengo concursos */ 
        dtoBuscar = new DTOBuscarConcursos();
        dtoBuscar.setOidPais(oidPais);
        dtoBuscar.setOidMarca(oidMarca);
        dtoBuscar.setOidCanal(oidCanal);
        dtoBuscar.setIndActivo(Boolean.TRUE);
        dtoBuscar.setOidVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_VIGENTE);
        
        UtilidadesLog.debug("**** Llamando a obtenerConcursosCerrar con: " + dtoBuscar);
        rConcursos = daoActivacion.obtenerConcursosCerrar(dtoBuscar);
        
        UtilidadesLog.debug("**** Llamando a obtenerConcursosCandidatos con: " + rConcursos);
        aListConcursosCerrar = this.obtenerConcursosCandidatos(rConcursos);
        
        /* 
         * Una vez que tengo los Concursos y los Periodos, se recorren los concursos 
         * candidatos a cerrar y se cierran en caso que corresponda.
         */ 
        int cantRegistros = aListConcursosCerrar.size();
        UtilidadesLog.debug("**** aListConcursosCerrar.size() " + cantRegistros);        
        
        DTOPeriodo dtoPeriodoHasta = null;
        DTOPeriodo dtoPeriodoDespacho = null;
        DTOPeriodo periodoHastaEvaluar = null;
        //jrivas 9/1/2009 20080804
        DTOPeriodo periodoHastaRecomendadas = null;
        DTOPeriodo periodoHastaObtencion = null;
        DTOPeriodo dtoPeriodoPremiacion = null;
        DTOPeriodo dtoPeriodoHastaSobreCalculo = null;        
        
        Object[] arrayObjetos = null;
        Long oidPeriodoHasta = null;        
        Long oidPeriodoDespacho = null;
        Long oidPeriodoPremiacion = null;
        Long indicePeriodoHasta = null;
        
        int indicePeriodoHastaEvaluar;
        //jrivas 9/1/2009 20080804
        int indicePeriodoHastaRecomendadas;
        int indicePeriodoHastaObtencion;
        int indicePeriodoHastaSobreCalc;
        java.sql.Date fechaFin = null;
        java.sql.Date fechaFinHastaEvaluar = null;
        //jrivas 9/1/2009 20080804
        java.sql.Date fechaFinHastaRecomendadas = null;
        java.sql.Date fechaFinDespacho = null;
        java.sql.Date fechaFinPremiacion = null;
        java.sql.Date fechaFinHastaSobreCalc = null;
        java.sql.Date fechaFinHastaObtencion = null;
        java.sql.Date fechaFinal = null;
        java.sql.Date fechaBuffer = null;
        
        sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        for (int i=0; i<cantRegistros; i++) {
           // Limpio las variables para evitar que queden datos de la iteracion anterior
           fechaFin = null;
           fechaFinHastaEvaluar = null;
           //jrivas 9/1/2009 20080804
           fechaFinHastaRecomendadas = null;
           fechaFinDespacho = null;
           fechaFinPremiacion = null;
           fechaFinHastaSobreCalc = null;
           fechaFinHastaObtencion = null;
           fechaFinal = null;
           fechaBuffer = null;
        
           /** Se recuperan los datos de periodo hasta */
           UtilidadesLog.debug("****** Obteniendo FechaFin...");
           dtoConcursoCerrar = (DTOConcursoCerrar) aListConcursosCerrar.get(i);
           
           if (! invocadoDesdeCRA) {
               LogAPP.info("Nombre del concurso: " + dtoConcursoCerrar.getNumeroConcurso()
                   + " - " + sdf.format(new Date(System.currentTimeMillis()))
                   + " - " + nombrePeriodo);
           }
           
           oidPeriodoHasta = dtoConcursoCerrar.getOidPeriodoHasta();
           arrayObjetos = this.buscarPeriodoPorOid(oidPeriodoHasta, 
                                                   aListPeriodosOrdenados);
                                                   
           dtoPeriodoHasta = (DTOPeriodo) arrayObjetos[0];
           indicePeriodoHasta = (Long) arrayObjetos[1];
           fechaFin = dtoPeriodoHasta.getFechaFin();
           UtilidadesLog.debug("****** fechaFin " + fechaFin);
           
            /** Se calcula el indice del array para hacer el salto de nro. de
             * periodos a evaluar - 1 */
            UtilidadesLog.debug("****** Obteniendo FechaFinHastaEvaluar...");
            if(dtoConcursoCerrar.getPeriodosEvaluar()!=null) {
               int lTemp = dtoConcursoCerrar.getPeriodosEvaluar().intValue() - 1;
               indicePeriodoHastaEvaluar = indicePeriodoHasta.intValue() + lTemp;
               periodoHastaEvaluar = 
               (DTOPeriodo) aListPeriodosOrdenados.get(indicePeriodoHastaEvaluar);
               fechaFinHastaEvaluar = periodoHastaEvaluar.getFechaFin();             
            }           
            UtilidadesLog.debug("****** fechaFinHastaEvaluar " + fechaFinHastaEvaluar);
            
            //jrivas 9/1/2009 20080804
            /** Se calcula el indice del array para hacer el salto de nro. de
             * Períodos Recomendadas */
            UtilidadesLog.debug("****** Obteniendo FechaFinHastaRecomendadas...");
            if(dtoConcursoCerrar.getPeriodosRecomendadas()!=null) {
               int lTemp = dtoConcursoCerrar.getPeriodosRecomendadas().intValue();
               indicePeriodoHastaRecomendadas = indicePeriodoHasta.intValue() + lTemp;
               periodoHastaRecomendadas = 
               (DTOPeriodo) aListPeriodosOrdenados.get(indicePeriodoHastaRecomendadas);
               fechaFinHastaRecomendadas = periodoHastaRecomendadas.getFechaFin();             
            }           
            UtilidadesLog.debug("****** FechaFinHastaRecomendadas " + fechaFinHastaRecomendadas); 
           
           /** Se calcula el indice del array para hacer el salto de nro. de 
            * periodos a partir obtención */
           UtilidadesLog.debug("****** Obteniendo fechaFinHastaObtencion...");
           if(dtoConcursoCerrar.getPeriodosObtencion()!=null) {
              int lTemp = dtoConcursoCerrar.getPeriodosObtencion().intValue();
              indicePeriodoHastaObtencion = indicePeriodoHasta.intValue() + lTemp;
              periodoHastaObtencion = 
              (DTOPeriodo) aListPeriodosOrdenados.get(indicePeriodoHastaObtencion);
              fechaFinHastaObtencion = periodoHastaObtencion.getFechaFin();             
           }
           UtilidadesLog.debug("****** fechaFinHastaObtencion " + fechaFinHastaObtencion);
           
                        
           /** Se recuperan los datos de periodo despacho */
           UtilidadesLog.debug("****** Obteniendo fechaFinDespacho...");
           if(dtoConcursoCerrar.getOidPeriodoDespacho()!=null) {
              oidPeriodoDespacho = dtoConcursoCerrar.getOidPeriodoDespacho();
              arrayObjetos = this.buscarPeriodoPorOid(oidPeriodoDespacho, 
                                                   aListPeriodosOrdenados);
              dtoPeriodoDespacho = (DTOPeriodo) arrayObjetos[0];
              fechaFinDespacho = dtoPeriodoDespacho.getFechaFin();             
           }
           UtilidadesLog.debug("****** fechaFinDespacho " + fechaFinDespacho);
           
           
           /** Se recuperan los datos de periodo premiación */
           UtilidadesLog.debug("****** Obteniendo fechaFinPremiacion...");
           if(dtoConcursoCerrar.getOidPeriodoPremiacion()!=null) {
              oidPeriodoPremiacion = dtoConcursoCerrar.getOidPeriodoPremiacion();
              arrayObjetos = this.buscarPeriodoPorOid(oidPeriodoPremiacion, 
                                                   aListPeriodosOrdenados);
              dtoPeriodoPremiacion = (DTOPeriodo) arrayObjetos[0];
              fechaFinPremiacion = dtoPeriodoPremiacion.getFechaFin();             
           }
           UtilidadesLog.debug("****** fechaFinPremiacion " + fechaFinPremiacion);
           
           
           /** Se calcula el indice del array para hacer el salto de Período 
            * de espera sobre el cálculo-1 */
           UtilidadesLog.debug("****** Obteniendo fechaFinHastaSobreCalc...");
           if(dtoConcursoCerrar.getPeriodosSobreCalculo()!=null) {
              int lTemp = dtoConcursoCerrar.getPeriodosSobreCalculo().intValue() - 1;
              indicePeriodoHastaSobreCalc = indicePeriodoHasta.intValue() + lTemp;
              dtoPeriodoHastaSobreCalculo = 
              (DTOPeriodo) aListPeriodosOrdenados.get(indicePeriodoHastaSobreCalc);
              fechaFinHastaSobreCalc = dtoPeriodoHastaSobreCalculo.getFechaFin();             
           }           
           UtilidadesLog.debug("****** fechaFinHastaSobreCalc " + fechaFinHastaSobreCalc);           
           
            //jrivas 5/1/2009 20080804
            fechaFinal = this.obtenerFechaMayor(fechaFin, 
                                                fechaFinHastaEvaluar, 
                                                fechaFinHastaRecomendadas, 
                                                fechaFinHastaObtencion,
                                                fechaFinDespacho, 
                                                fechaFinPremiacion,
                                                fechaFinHastaSobreCalc);                                            
           
           UtilidadesLog.debug("****** fechaFinal " + fechaFinal);                     
           /** Comparo Fecha Actual del Concurso con la fecha Final */
           fechaBuffer = dtoConcursoCerrar.getFechaActual();           
           UtilidadesLog.debug("****** fechaBuffer " + fechaBuffer);      
           
           if(fechaBuffer!=null && fechaFinal!=null) {
              // Si variableEntorno == null o true y fecha actual >= fecha final (concurso)
              // o bien si variableEntorno == false y fecha final periodo recibido >= fecha final (concurso)
              // (en cualquiera de ambos casos) se determinara si hay pendientes
              if ( ( (Boolean.TRUE.equals(variableEntorno) || variableEntorno == null) && ! fechaBuffer.before(fechaFinal))
                   || (Boolean.FALSE.equals(variableEntorno) && !fechaFinPeriodo.before(fechaFinal))) {
                   
                 DTOOID dtoOid = new DTOOID();
                 dtoOid.setOid(dtoConcursoCerrar.getOidConcurso());
                 UtilidadesLog.debug("*** Llamando a determinarPendientes con: " + dtoOid);
                 DTOBoolean dtoBoolean = daoActivacion.determinarPendientes(dtoOid);
                 if (!dtoBoolean.getValor()) {
                   // vbongiov -- Cambio 20090929 -- 18/09/2009
                   if(!daoActivacion.determinarPendientesConcurso(dtoConcursoCerrar.getOidConcurso(),oidPeriodo)){                  
                       try {
                         UtilidadesLog.debug("*** Llamando a cerrarConcurso con: " + dtoOid);
                           // vbongiov -- Cambio 20090863 -- 30/06/2009
                         rConcursosCerrados.addRow(new Object[] {new BigDecimal(dtoConcursoCerrar.getOidConcurso().toString())}); 
                         this.cerrarConcurso(dtoOid);  
                         
                       } catch (Exception ex) {
                         UtilidadesLog.debug("* * * Exception en cerrarConcurso * * *");
                         UtilidadesLog.error(ex);                   
                       }               
                   }
                 }
              }             
           }
           
           if (! invocadoDesdeCRA) {
               LogAPP.info("Nombre del concurso: " + dtoConcursoCerrar.getNumeroConcurso()
                   + " - " + sdf.format(new Date(System.currentTimeMillis()))
                   + " - " + nombrePeriodo);
           }
           
        }
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        daoActivacion.guardarHistoricoActivacionCerrado("C", oidPeriodo, user, rConcursosCerrados);   
        
        //jrivas 06/02/2007 Luego de Cerrar los concursos se limpia la Factoria
        //para que se cargue la primera vez que se necesite.
        FactoriaConcurso.refrescarConcursos();
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        daoActivacion.actualizarUltimaActualizacionConcurso();
        
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursos(MareDTO dtoe)" + 
                           ":Salida");
    }
    
    
    public DTOSalidaBatch cerrarConcursosBatch(DTOBatch dtoe) throws MareException{
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursosBatch(DTOBatch dtoe): Entrada");
        MareDTO mareDTO = (MareDTO)dtoe.getDTOOnline();
        
        // vbongiov -- Cambio 20090863 -- 30/06/2009
        mareDTO.setProperty("USER_PROPERTY", dtoe.getUser());;
        
        UtilidadesLog.debug("mareDTO: " + mareDTO);
        this.cerrarConcursos(mareDTO);
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursosBatch(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch(0, "Cerrar concursos finalizado");
    }

    public void cerrarConcursosQuartz(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursosQuartz(MareDTO dtoe): Entrada");
        this.cerrarConcursos(dtoe);
        UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcursosQuartz(MareDTO dtoe): Salida");
    }

    public void lanzarCerradoConcursosBatch(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONCerradoConcursosBean.lanzarCerradoConcursosBatch(MareDTO dtoe): Entrada");
        
        MareBusinessID id = new MareBusinessID(("INCCerrarConcursosBatch"));
        DTOBatch dtoB = new DTOBatch(new String("Cerrado de concursos"), id, dtoe, ctx.getCallerPrincipal().getName());
        
        try {
            BatchUtil.executeMLN(dtoB, "INCPROCESOSBATCH");
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONCerradoConcursosBean.lanzarCerradoConcursosBatch(MareDTO dtoe): Salida");
    }
    

    
    /**
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return java.sql.Date
     */
     //jrivas 5/1/2009 20080804
     private java.sql.Date obtenerFechaMayor(java.sql.Date fechaFin, 
                                             java.sql.Date fechaFinHastaEvaluar, 
                                             java.sql.Date fechaFinHastaRecomendadas, 
                                             java.sql.Date fechaFinHastaObtencion,
                                             java.sql.Date fechaFinDespacho, 
                                             java.sql.Date fechaFinPremiacion,
                                             java.sql.Date fechaFinHastaSobreCalc) 
                                             throws MareException {
         
         UtilidadesLog.info("MONCerradoConcursosBean.obtenerFechaMayor()" + 
                            ":Entrada");
         
         java.sql.Date fechaRetorno = null;
         
         java.sql.Date[] arrayFechas = new java.sql.Date[7];
         arrayFechas[0] = fechaFin;
         arrayFechas[1] = fechaFinHastaEvaluar;
         arrayFechas[2] = fechaFinHastaObtencion;
         arrayFechas[3] = fechaFinDespacho;
         arrayFechas[4] = fechaFinPremiacion;
         arrayFechas[5] = fechaFinHastaSobreCalc;
         arrayFechas[6] = fechaFinHastaRecomendadas;        
         
         for (int i = 0; i<7; i++) {
             if(arrayFechas[i]!=null) {
                 if (fechaRetorno == null || fechaRetorno.before(arrayFechas[i])){
                     fechaRetorno = arrayFechas[i];
                 }              
             }            
         }
         
         UtilidadesLog.info("MONCerradoConcursosBean.obtenerFechaMayor()" + 
                            ":Salida");
         return fechaRetorno;
     }
    
    
    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 22/09/2008 - Se setea num de concurso a cada DTOVersion
     * 
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param RecordSet rConcursos
     */
    private ArrayList obtenerConcursosCandidatos(RecordSet rConcursos) 
                    throws MareException {
        UtilidadesLog.info("MONCerradoConcursosBean.obtenerConcursosCandidatos(RecordSet rConcursos)" + 
                           ":Entrada");
                           
        ArrayList aListConcursosCerrar = new ArrayList();                    
        int cantRegistros = rConcursos.getRowCount();
        DTOConcursoCerrar dtoConcursoCerrar = null;
        Long oidConcurso = null;
        Long oidEstado = null;
        Long oidConcursoOrigen = null;
        Long oidPeriodoHasta = null;
        Integer periodosEvaluar = null;
        Integer periodosObtencion = null;
        Long oidPeriodoDespacho = null;
        Long oidPeriodoPremiacion = null;
        Integer periodosSobreCalculo = null;
        java.sql.Date fechaActual = null;
        String numeroConcurso = null;
        //jrivas 5/1/2009 20080804
        Integer periodosRecomendadas = null;
        
        for (int i=0; i<cantRegistros; i++) {
            dtoConcursoCerrar = new DTOConcursoCerrar();
            oidConcurso = (Long) this.retornaValor(rConcursos.getValueAt(i,0), "L");
            oidEstado = (Long) this.retornaValor(rConcursos.getValueAt(i,1), "L");
            oidConcursoOrigen = (Long) this.retornaValor(rConcursos.getValueAt(i,2), "L");
            oidPeriodoHasta = (Long) this.retornaValor(rConcursos.getValueAt(i,3), "L");
            periodosEvaluar = (Integer) this.retornaValor(rConcursos.getValueAt(i,4), "I");
            periodosObtencion = (Integer) this.retornaValor(rConcursos.getValueAt(i,5), "I");
            oidPeriodoDespacho = (Long) this.retornaValor(rConcursos.getValueAt(i,6), "L");
            oidPeriodoPremiacion = (Long) this.retornaValor(rConcursos.getValueAt(i,7),"L");
            periodosSobreCalculo = (Integer) this.retornaValor(rConcursos.getValueAt(i,8), "I");
            fechaActual = (java.sql.Date) rConcursos.getValueAt(i,9);
            numeroConcurso = (String)rConcursos.getValueAt(i, "NUMEROCONCURSO");
            //jrivas 5/1/2009 20080804
            periodosRecomendadas = (Integer) this.retornaValor(rConcursos.getValueAt(i,11), "I");
            
            dtoConcursoCerrar.setOidConcurso(oidConcurso);
            dtoConcursoCerrar.setOidEstado(oidEstado);
            dtoConcursoCerrar.setOidConcursoOrigen(oidConcursoOrigen);
            dtoConcursoCerrar.setOidPeriodoHasta(oidPeriodoHasta);
            dtoConcursoCerrar.setPeriodosEvaluar(periodosEvaluar);
            dtoConcursoCerrar.setPeriodosObtencion(periodosObtencion);
            dtoConcursoCerrar.setOidPeriodoDespacho(oidPeriodoDespacho);
            dtoConcursoCerrar.setOidPeriodoPremiacion(oidPeriodoPremiacion);
            dtoConcursoCerrar.setPeriodosSobreCalculo(periodosSobreCalculo);
            dtoConcursoCerrar.setFechaActual(fechaActual);
            dtoConcursoCerrar.setNumeroConcurso(numeroConcurso);
            //jrivas 5/1/2009 20080804
            dtoConcursoCerrar.setPeriodosRecomendadas(periodosRecomendadas);
            
            aListConcursosCerrar.add(dtoConcursoCerrar);
        }
        
        UtilidadesLog.info("MONCerradoConcursosBean.obtenerConcursosCandidatos(RecordSet rConcursos)" + 
                           ":Salida");
        return aListConcursosCerrar;
    }
    
    /**
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param RecordSet rPeriodos
     */
    private ArrayList obtenerPeriodos(RecordSet rPeriodos) throws MareException {
        UtilidadesLog.info("MONCerradoConcursosBean.obtenerPeriodos(RecordSet " + 
                           "rPeriodos) :Entrada");    
                           
        UtilidadesLog.debug("***** RecordSet rPeriodos: " + rPeriodos);
        
        ArrayList aListPeriodosOrdenados = new ArrayList();
        int cantRegistros = rPeriodos.getRowCount();
        DTOPeriodo dtoPeriodoTemp = null;
        Long lOid = null;
        java.sql.Date fechaInicial = null;
        java.sql.Date fechaFinal = null;
        
        for (int i=0; i<cantRegistros; i++) {
            dtoPeriodoTemp = new DTOPeriodo();
            lOid = Long.valueOf(rPeriodos.getValueAt(i, 0).toString());
            fechaInicial = (java.sql.Date) rPeriodos.getValueAt(i, 1);
            fechaFinal = (java.sql.Date) rPeriodos.getValueAt(i, 2);
            
            dtoPeriodoTemp.setOid(lOid);
            dtoPeriodoTemp.setFechaInicio(fechaInicial);
            dtoPeriodoTemp.setFechaFin(fechaFinal);            
            aListPeriodosOrdenados.add(dtoPeriodoTemp);
        }
        
        UtilidadesLog.info("MONCerradoConcursosBean.obtenerPeriodos(RecordSet " + 
                           "rPeriodos) :Salida");
        return aListPeriodosOrdenados;
    }
    
    
    /**
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOPeriodo
     * @param ArrayList aList
     * @param Long oid
     */
    private Object[] buscarPeriodoPorOid(Long oid, ArrayList aList) 
                throws MareException {      
        UtilidadesLog.info("MONCerradoConcursosBean.buscarPeriodoPorOid(Long oid, ArrayList aList)" + 
                           ":Entrada");
                           
        /* Retorna 
         *      - en posicion 0: DTOPeriodo encontrado
         *      - en posicion 1: Indice elemento encontrado */
         
        Object[] arrayRetorno = new Object[2];
        DTOPeriodo dtoPeriodo = null;
        boolean bMatch = false;
        int cantRegistros = aList.size();
        int indiceMatch = -1;
        UtilidadesLog.debug("Oid Periodo a buscar: " + oid);
        
        for (int i=0; (i < cantRegistros) && (!bMatch); i++) {
            dtoPeriodo = (DTOPeriodo) aList.get(i);
            if (dtoPeriodo.getOid().equals(oid)) {
                bMatch = true;
                indiceMatch = i;
            }
        }
        
        UtilidadesLog.debug("DTOPeriodo: " + dtoPeriodo);        
        UtilidadesLog.debug("Indice: " + indiceMatch);
        
        arrayRetorno[0] = dtoPeriodo;
        arrayRetorno[1] = new Long(indiceMatch);
        
        UtilidadesLog.info("MONCerradoConcursosBean.buscarPeriodoPorOid(Long oid, ArrayList aList)" + 
                           ":Salida");
        return arrayRetorno;
    }
    
    /**
     * @author: ssantana, 23/05/2006
     * @return Object
     * @param String tipoDato
     * @param Object o
     */
    private Object retornaValor(Object o, String tipoDato) {
        Object oRetorno = null;
        if (o != null) {
            if (tipoDato.equals("I") ) {
                oRetorno = Integer.valueOf(o.toString());
            }
            
            if (tipoDato.equals("L") ) {
                oRetorno = Long.valueOf(o.toString());
            }
       }
       return oRetorno;
    }
    
    
    /**
     * @author: ssantana, 24/05/2006
     * @throws java.lang.Exception
     * @param DTOOID dtoe
     */
    private void cerrarConcurso(DTOOID dtoe) throws Exception {
        try {
            UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcurso(DTOOID dtoe)" + 
                           ":Entrada");
                           
            Collection col = null;
            VersionesConcursoLocal versionesConcursoL = null;
            VersionesConcursoLocalHome versionesConcursoLH = this.getVersionesConcursoLocalHome();
            ConcursoParametrosGeneralesLocal concuParamGeneralL = null;
            ConcursoParametrosGeneralesLocalHome concuParamGeneralLH = null;                
            
            /** Actualizo el Estado */ 
            col = versionesConcursoLH.findByConcurso(dtoe.getOid());
            Iterator it = col.iterator();
            while (it.hasNext()){
               versionesConcursoL = (VersionesConcursoLocal) it.next();
               versionesConcursoL.setVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_CERRADO);
               versionesConcursoLH.merge(versionesConcursoL);
            }
            
            /** Desactivo el Concurso */
            concuParamGeneralLH = this.getConcursoParametrosGeneralesLocalHome();
            concuParamGeneralL = concuParamGeneralLH.findByPrimaryKey(dtoe.getOid());
            concuParamGeneralL.setActivo(Boolean.FALSE);
            concuParamGeneralLH.merge(concuParamGeneralL);
            
            UtilidadesLog.info("MONCerradoConcursosBean.cerrarConcurso(DTOOID dtoe)" + 
                           ":Salida");
            
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);

            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }


    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
    
    private VersionesConcursoLocalHome getVersionesConcursoLocalHome() {
            return new VersionesConcursoLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }



}