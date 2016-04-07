/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega491
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor : Alejandro Cortaberria, Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.rules.RuleService;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTODatosMensajeMultinivel;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.entidades.inc.GanadorasLocalHome;
import es.indra.sicc.entidades.inc.PremiosElegidosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rules.StatelessRuleSession;
import es.indra.sicc.entidades.inc.DespachoPremiosLocalHome;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPremiacionBean implements SessionBean {
    private SessionContext sessionContext;
    private String reglasCalificacionPremiacion = "variable_4";
    private String reglasTransformaPuntosAPremios = "variable_5";
    private ArrayList objetosDelMotor;
    private String reglasDeterminarGanadoraRecomendacion = "variable_6";
    private String reglasDeterminarGanadoraRecomendacionGerente = "variable_7";
    private StatelessRuleSession workSpace = null;
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

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    public DTOEstatusSolicitud premiarPorSolicitud(DTOSolicitudValidacion solicitud)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.premiarPorSolicitud(DTOSolicitudValidacion solicitud):Entrada");
        
        ClientePremiacion clientePremiacion = new ClientePremiacion();
        DTOOIDs dtoOids = null; // adaptado segun esta en la especificacion FactoriaConcurso
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("solicitud.getOidPais(): " + solicitud.getOidPais());
          
        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso().getConcursos(solicitud.getOidPais());
        
        if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){

            DTOETramitarCierre dtoe = new DTOETramitarCierre();
            dtoe.setOidPeriodo(solicitud.getOidPeriodo());
            dtoe.setOidMarca(solicitud.getOidMarca());
            dtoe.setOidCanal(solicitud.getOidCanal());
            dtoe.setOidZona(solicitud.getZona());
            dtoe.setOidPais(solicitud.getOidPais());
    
            clientePremiacion.setOidPais(solicitud.getOidPais());
            clientePremiacion.setOidMarca(solicitud.getOidMarca());
            clientePremiacion.setOidCanal(solicitud.getOidCanal());
            clientePremiacion.setOidCliente(solicitud.getOidCliente());
            clientePremiacion.setSubacceso(solicitud.getOidSubAcceso());
            clientePremiacion.setAcceso(solicitud.getOidAcceso());
    
            //Cleal 5/07/2005
    
            /*Periodo per = new Periodo();
            per.setOidPeriodo(solicitud.getOidPeriodo());
            clientePremiacion.setPeriodo(per);*/
    
            //Cleal 5/07/2005
            DAOClientePremiacion daoClientePremiacion = new DAOClientePremiacion();
            daoClientePremiacion.rellenarClientePremiacion(clientePremiacion, solicitud.getOidPeriodo());
    
            daoClientePremiacion.obtenerAsistenciaCursos(clientePremiacion);
            
            daoClientePremiacion.obtenerProductos(clientePremiacion);
    
            //jrivas 28/7/2005 -- Se agrega la llamada 
            //INC 20292
            daoClientePremiacion.obtenerPeriodosConPedidosCliente(clientePremiacion);

            //jrivas 18/1/2005
            //INC-44
            DAOConcursoPremiacion daoConcurso = new DAOConcursoPremiacion();
            dtoOids = daoConcurso.obtenerConcursos(dtoe, solicitud.getOidCliente());                
            
            premiar(clientePremiacion, dtoOids, null);
        }

        DTOEstatusSolicitud dtoes = new DTOEstatusSolicitud();
        dtoes.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPremiacionBean.premiarPorSolicitud(DTOSolicitudValidacion solicitud):Salida");
        Cronometrador.endTransaction("MONPremiacionBean.premiarPorSolicitud");
        return dtoes;
    }

    public void premiarPorCierrePeriodo(DTOFACProcesoCierre dtoFac) throws MareException {
        /*
         * Autor : JVM
         * Fecha : 26-Mar-2006
         * Desc  : SICC-20070148, se agrega el metodo premierPorCierrePeriodo el cual invoca a 
         *         premiarPorCierre con parámetro ConstantesFAC.TIPO_CIERRE_PERIODO
         */         
         
        UtilidadesLog.info("MONPremiacionBean.premiarPorCierrePeriodo(DTOFACProcesoCierre dtoFac):Entrada");      
        premiarPorCierre(dtoFac, ConstantesFAC.TIPO_CIERRE_PERIODO); 
        UtilidadesLog.info("MONPremiacionBean.premiarPorCierrePeriodo(DTOFACProcesoCierre dtoFac):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    * Este método es invocado por por le CU Tramitar Cierre (FAC)
    * Modificado: Carlos Leal 23/06/2005
    */
    public void premiarPorCierreZona(DTOFACProcesoCierre dtoFac) throws MareException {
        /*
         * Autor : JVM
         * Fecha : 26-Mar-2006
         * Desc  : SICC-20070148, se reemplaza código del metodo con la llamada al metodo premierPorCierre
         *         pasandolo como constante ConstantesFAC.TIPO_CIERRE_ZONA
         */  

        UtilidadesLog.info("MONPremiacionBean.premiarPorCierreZona(DTOFACProcesoCierre dtoFac):Entrada");         
        premiarPorCierre(dtoFac, ConstantesFAC.TIPO_CIERRE_ZONA);        
        UtilidadesLog.info("MONPremiacionBean.premiarPorCierreZona(DTOFACProcesoCierre dtoFac):Salida");
    }

    public void premiarPorCierre(DTOFACProcesoCierre dtoFac, String tipoCierre) throws MareException {
        /*
         * Autor : JVM
         * Fecha : 26-Mar-2006
         * Desc  : SICC-20070148 se agrega el parametro tipoCierre en el metodo obtenerClientesPers
         */

        //0) Transformo el DTO de entrada en otro DTO compatible con el resto de la implementación del método, 
        //de la siguiente manera: 
        
        UtilidadesLog.info("MONPremiacionBean.premiarPorCierre(DTOFACProcesoCierre dtoFac, String tipoCierre["+tipoCierre+"]):Entrada");
        
        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso().getConcursos(dtoFac.getOidPais());
        
        if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){

            DTOETramitarCierre dtoe = new DTOETramitarCierre();
            dtoe.setOidPeriodo(dtoFac.getPeriodo());
            dtoe.setOidMarca(dtoFac.getMarca());
            dtoe.setOidCanal(dtoFac.getCanal());
            dtoe.setOidZona(dtoFac.getZona());
            dtoe.setOidPais(dtoFac.getOidPais());
    
            //jrivas 18/1/2005
            //INC-44
            //Obtener los concursos que intervienen 
            //DAOConcursoPremiacion daoConcurso = new DAOConcursoPremiacion();
            //DTOOIDs dtooidsConcursos = daoConcurso.obtenerConcursos(dtoe);
    
            //Obtener los clientes intervinientes: 
            DAOClientePremiacion daoClientes = new DAOClientePremiacion();

            /*
             * Autor : JVM
             * Fecha : 26-Mar-2006
             * Desc  : SICC-20070148, se agrega el parametro tipoCierre en la llamada del metodo
             *         daoClientes.obtenerClientesPerf
             */            
            DTOOIDs clientes = daoClientes.obtenerClientesPerf(dtoe, tipoCierre);
        
            //2.1) Por cada elemento de clientes recuperado: 
            if ((clientes != null) && (clientes.getOids() != null)) {
    
                for (int i = 0; i < clientes.getOids().length; ++i) {
 
                    ClientePremiacion clientePremiacion = new ClientePremiacion();
                    clientePremiacion.setOidPais(dtoe.getOidPais());
                    clientePremiacion.setOidMarca(dtoe.getOidMarca());
                    clientePremiacion.setOidCanal(dtoe.getOidCanal());
                    clientePremiacion.setOidCliente(clientes.getOids()[i]);
    
                    //Pendiente por incidencia
                    //clientePremiacion.setPeriodo(daoClientePremiacion.obtenerPeriodo(dtoe));
                    //
                    daoClientes.rellenarClientePremiacion(clientePremiacion, dtoFac.getPeriodo());
    
                    daoClientes.obtenerAsistenciaCursos(clientePremiacion);
                    daoClientes.obtenerProductos(clientePremiacion);
    
                    //jrivas 28/7/2005 -- Se agrega la llamada 
                    //INC 20292
                    daoClientes.obtenerPeriodosConPedidosCliente(clientePremiacion);
                    
                    // vbongiov -- Cambio 20090929 -- 18/09/2009
                    daoClientes.obtenerDeudaPeriodoCierreMenosUno(clientePremiacion);
                                        
                    
                    //jrivas 18/1/2005
                    //INC-44
                    DAOConcursoPremiacion daoConcurso = new DAOConcursoPremiacion();
                    DTOOIDs dtooidsConcursos = daoConcurso.obtenerConcursos(dtoe, clientes.getOids()[i]);     
                                        
                    // vbongiov -- Cambio 20090929 -- 18/09/2009
                    if(ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoCierre)){
                        clientePremiacion.setTipoCierre(ConstantesINC.TIPO_CIERRE_ZONA);
                    }
                    
                    UtilidadesLog.debug("clientePremiacion.getTipoCierre():" + clientePremiacion.getTipoCierre());
                                
                    premiar(clientePremiacion, dtooidsConcursos, tipoCierre);
                }
            }
        }

        UtilidadesLog.info("MONPremiacionBean.premiarPorCierre(DTOFACProcesoCierre dtoFac, String tipoCierre):Salida");
    }


    /**
    * Fecha de Creacion: 12/05/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    public void tranformarPuntosAPremios(ClientePremiacion clientePremiacion, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.tranformarPuntosAPremios(ClientePremiacion clientePremiacion, ArrayList concursos):Entrada");
        try {
            Iterator itConcursos = concursos.iterator();
            DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
            ClientePremiacionConcurso clientePremiacionConcurso = null;
            GestorMensajesTransformar gestorMensajesTransformar = new GestorMensajesTransformar();
            DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
            Concurso concurso = null;
            GanadorasLocal ganadoras = null;
            
            //jrivas BLO-001
            if (clientePremiacion.getClienteBloqueado()) {
                DAOCandidataGanadora daoCandidata = new DAOCandidataGanadora();
                daoCandidata.actualizaCandidataGanadoraBloqueo(clientePremiacion);
            }

            HashMap clientesPremiacionConcurso = clientePremiacion.getClientesPremiacionConcurso();
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("JVM , ALE .... getClientesPremiacionConcurso().size() ="+clientePremiacion.getClientesPremiacionConcurso().size());
            
            Iterator itCliePremConcurso = clientesPremiacionConcurso.keySet().iterator();

            while (itCliePremConcurso.hasNext()) {
                double totalPuntos = 0;
                ArrayList premiosGanados = new ArrayList();

                clientePremiacionConcurso = (ClientePremiacionConcurso) clientesPremiacionConcurso.get(itCliePremConcurso.next());

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("clientePremiacionConcurso " + clientePremiacionConcurso);
                  
                crearWorkSpace(reglasTransformaPuntosAPremios);
                insertarClientePremiacionEnMotor(clientePremiacionConcurso);
                concurso = despacharPremiosHelper.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("despacharPremiosHelper.concurso " + concurso.getOidConcurso());
                //jrivas 1/9/2005 inc 20474
                //gestorMensajesTransformar.crearMensajeINC08(clientePremiacion, clientePremiacionConcurso, concurso);
                //UtilidadesLog.debug("despues de crearMensajeINC08 ");

                ArrayList premiosEscogidos = clientePremiacionConcurso.getPremiosEscogidos();
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("premiosEscogidos " + premiosEscogidos);

                if (premiosEscogidos != null) {
                    Iterator itPremios = premiosEscogidos.iterator();

                    while (itPremios.hasNext()) {
                        insertarObjetoEnMotor(itPremios.next());
                    }

                    UtilidadesLog.debug("antes de arrancar motor ");

                    Iterator u = objetosDelMotor.iterator();

                    while (u.hasNext()) {
                      UtilidadesLog.debug("Objetos :  " + u.next());
                    }

                    arrancarMotorDeReglas();
                    UtilidadesLog.debug("despues de arrancar motor ");
                }
            }
            
            Iterator itCliePremConcurso2 = clientesPremiacionConcurso.keySet().iterator();

            double totalPuntos = 0;
            double auxTotalPuntos = 0;
            double auxAnterior=-1;
            double auxActual=-1;
            
            while (itCliePremConcurso2.hasNext()) 
            {
                totalPuntos = 0;
                //  Modificado por HRCS - Incidencia Sicc20080597
                auxTotalPuntos = 0;
                auxAnterior=-1;
                auxActual=-1;
            
                ArrayList premiosGanados = new ArrayList();
                objetosDelMotor = new ArrayList();

                clientePremiacionConcurso = (ClientePremiacionConcurso) clientesPremiacionConcurso.get(itCliePremConcurso2.next());
                concurso = despacharPremiosHelper.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());
                
                //jrivas 20070439
                //Si es por niveles agrupo los premias acticulos
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("POR NIVELES? " + ConstantesINC.TIPO_PREMIACION_POR_NIVELES.equals(concurso.getTipoPremiacion()));
                if (ConstantesINC.TIPO_PREMIACION_POR_NIVELES.equals(concurso.getTipoPremiacion())) {                    
                    clientePremiacionConcurso.setPremiosEscogidos(this.agruparPremiosArtculos(clientePremiacionConcurso.getPremiosEscogidos()));
                }

                ArrayList premiosEscogidos = clientePremiacionConcurso.getPremiosEscogidos();

                if ((premiosEscogidos != null) && (premiosEscogidos.size() > 0)) {
                    Iterator itPremios = premiosEscogidos.iterator();

                    while (itPremios.hasNext()) 
                    {
                        Premio premioElegido = (Premio) itPremios.next();
                        
                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("premioElegido " + premioElegido);

                          UtilidadesLog.debug("premioElegido.getActualizarGanadora() " + premioElegido.getActualizarGanadora());
                        }  

                        if (premioElegido.getActualizarGanadora()) 
                        {
                            boolean inserte = false;

                            if ( (premioElegido.getNivel().getCantidadFijaPuntos() != null) && (premioElegido.getNivel().getCantidadFijaPuntos().doubleValue() != 0) ) {
                                // JVM, sicc20070300, se adicion  if (concurso.getPremiosAcumulativosNiveles()) y totalPuntos = premioElegido.getNivel().getCantidadFijaPuntos().doubleValue();                                
                                if (concurso.getPremiosAcumulativosNiveles()){
                                    totalPuntos = premioElegido.getNivel().getCantidadFijaPuntos().doubleValue();
                                }
                                else{
                                    totalPuntos = totalPuntos + premioElegido.getNivel().getCantidadFijaPuntos().doubleValue();
                                }
                                
                            } else {
                                // JVM, sicc20070300, se adicion  if (concurso.getPremiosAcumulativosNiveles()) y totalPuntos = premioElegido.getNivel().getCantidadInicialPuntos().doubleValue();
                                if (concurso.getPremiosAcumulativosNiveles()){
                                    totalPuntos = premioElegido.getNivel().getCantidadInicialPuntos().doubleValue();
                                }
                                else{
                                    totalPuntos = totalPuntos + premioElegido.getNivel().getCantidadInicialPuntos().doubleValue();
                                }
                            }
                            
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                              UtilidadesLog.debug("JVM300, concurso.getPremiosAcumulativosNiveles()="+concurso.getPremiosAcumulativosNiveles()+" totalPuntos("+totalPuntos+")");

                              UtilidadesLog.debug("premioElegido.getTipoPremio() " + premioElegido.getTipoPremio());
                            }  

                            if (ConstantesINC.TIPO_PREMIO_MONETARIO.equals(premioElegido.getTipoPremio())) {
                                PremioMonetario premioMonetario = (PremioMonetario) premioElegido;

                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("premioMonetario.getPagoEnPartes() " + premioMonetario.getPagoEnPartes());

                                if (premioMonetario.getPagoEnPartes()) {
                                    Iterator itPagosPartes = premioMonetario.getPagosEnPartes().iterator();

                                    while (itPagosPartes.hasNext()) {
                                        PagoPartes pagoPartes = (PagoPartes) itPagosPartes.next();

                                        BigDecimal unidades = BigDecimal.valueOf(premioMonetario.getUnidades().longValue());

                                        //jrivas 14/7/2006 INC-141
                                        unidades = new BigDecimal(unidades.doubleValue() * pagoPartes.getPorcentajePremio().doubleValue() / 100);
                                        
                                        //jrivas 5/8/2005 INC 20411
                                        Boolean listarGanador = Boolean.FALSE;
                                        Boolean descontar = Boolean.FALSE;
                                        Boolean despachado = Boolean.FALSE;

                                        Long oidCliente = clientePremiacion.getOidCliente();
                                        Long oidPeriodo = pagoPartes.getPeriodoControl().getOidPeriodo();
                                        Long oidNivel = premioMonetario.getNivel().getOidNivel();
                                        
                                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                          UtilidadesLog.debug("oidCliente: " + oidCliente);
                                          UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                                          UtilidadesLog.debug("oidNivel: " + oidNivel);
                                        }  

                                        //public Long ejbCreate(BigDecimal unidades, Boolean listarGanador, Boolean descontar, Boolean despachado, Long oidCliente, Long periodoDespacho, Long nivelPremiacion) throws MareException
                                        ganadoras = this.getGanadorasLocalHome().create(unidades, listarGanador, descontar, despachado,
                                                                                                  oidCliente, oidPeriodo, oidNivel);
                                                                                                  
                                        ganadoras.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));     
                                        
                                        //jrivas BLO-001
                                        ganadoras.setClienteBloqueado(new Boolean(clientePremiacion.getClienteBloqueado()));
                                        
                                        this.getGanadorasLocalHome().merge(ganadoras);
                                        
                                        pagoPartes.setOidGanadora(ganadoras.getOid());
                                        
                                        inserte = true;
                                    }
                                } else {
                                    inserte = false;
                                }
                            }

                            if (!inserte) {
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("*** premioElegido.getUnidades(): " + premioElegido.getUnidades());

                                BigDecimal unidades = BigDecimal.valueOf(premioElegido.getUnidades().longValue());

                                //jrivas 5/8/2005 INC 20411
                                Boolean listarGanador = Boolean.FALSE;
                                Boolean descontar = Boolean.FALSE;
                                Boolean despachado = Boolean.FALSE;

                                Long oidCliente = clientePremiacion.getOidCliente();

                                //20393
                                Long oidPeriodo = null;

                                //jrivas 3/7/2006  DBLG500000754
                                //se necesita primero ver si tengo periodo despacho, si no lo ntego, guardo periodo actual.
                                if ((concurso.getPeriodoDeDespacho() != null) && (concurso.getPeriodoDeDespacho().getOidPeriodo() != null) && (!concurso.getIndRanking())) {
                                    oidPeriodo = concurso.getPeriodoDeDespacho().getOidPeriodo();
                                } else {
                                    MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();            
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("pais: " + clientePremiacion.getOidPais() + " marca: " + clientePremiacion.getOidMarca() +
                                                        "canal: " + clientePremiacion.getOidCanal());
                                    
                                    DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                                clientePremiacion.getOidMarca(),
                                                                clientePremiacion.getOidCanal());
                                   
                                    oidPeriodo = periodoActual.getOid();
                                }

                                Long oidNivel = premioElegido.getNivel().getOidNivel();
                                
                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                                  UtilidadesLog.debug("oidCliente: " + oidCliente);
                                  UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                                  UtilidadesLog.debug("oidNivel: " + oidNivel);
                                }  

                                ganadoras = this.getGanadorasLocalHome().create(unidades, listarGanador, descontar, despachado, oidCliente,
                                                                                          oidPeriodo, oidNivel);
                                                                                          
                                ganadoras.setFechaObtencion(new java.sql.Date(System.currentTimeMillis())); 
                                
                                //jrivas BLO-001
                                ganadoras.setClienteBloqueado(new Boolean(clientePremiacion.getClienteBloqueado()));
                                
                                this.getGanadorasLocalHome().merge(ganadoras);
                                
                                premioElegido.setOidGanadora(ganadoras.getOid());
                                
                                //Brecha INC-003 6-9-07 jrivas
                                //jrivas BLO-001
                                
                                // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
                                /*if (!clientePremiacion.getClienteBloqueado()) {
                                    if (ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premioElegido.getTipoPremio())) {
                                        gestorMensajesTransformar.crearMensajeINC98(clientePremiacion.getOidCliente(), concurso, premioElegido);
                                    }
                                }*/
                                
                            }

                            // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                            if(premioElegido.isIndAtenderPremio())
                                premiosGanados.add(premioElegido);
                            
                            if(premiosGanados != null){
                                for(int i=0; i<premiosGanados.size();i++){
                                    Premio pg = (Premio) premiosGanados.get(i);
                                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("JVM idx("+i+"), oidGanadora= "+pg.getOidGanadora());
                                      UtilidadesLog.debug("JVM pg.Object("+i+"), pg= " + pg.toString());
                                    }   
                                }
                            }
                            
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                              UtilidadesLog.debug("concurso.getComunicacionAutomatica() " + concurso.getComunicacionAutomatica());
                            
                            try {

                                this.getDespachoPremiosLocalHome().findByConcurso(concurso.getOidConcurso());
                                // vbongiov -- 29/06/06 -- DBLG500000723
                                //jrivas BLO-001
                                
                                // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
                                /*if (!clientePremiacion.getClienteBloqueado()) {
                                    gestorMensajesTransformar.crearMensajeINC08Despacho(clientePremiacion, clientePremiacionConcurso, concurso, premioElegido, totalPuntos);
                                }*/
                                
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                UtilidadesLog.debug("*** No encontro el concurso en DespachoPremios");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }                                                                                                                                    
                        }                        
                                                
                        // JVM, sicc2007033
                        if (auxActual == -1){
                            auxActual = totalPuntos;
                        }else{
                            auxAnterior = auxActual;
                            auxActual = totalPuntos;
                            
                            if(auxActual <= auxAnterior){
                                auxTotalPuntos+=auxAnterior;
                            }
                        }
                                                    
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                    
                          UtilidadesLog.debug("JVM300,  AUXS totalPuntos("+totalPuntos+") auxAnterior("+auxAnterior+") auxActual("+auxActual+") auxTotalPuntos("+auxTotalPuntos+")");

                    }
                    auxTotalPuntos+=auxActual;
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("JVM300,  END WHILE AUXS totalPuntos("+totalPuntos+") auxAnterior("+auxAnterior+") auxActual("+auxActual+") auxTotalPuntos("+auxTotalPuntos+")");

                    //jrivas 17/8/2005
                    //inc 20447
                    if(totalPuntos > 0 && (!concurso.getProgramaNuevas())) {
                        // JVM, sicc20070300
                        if (concurso.getNivelesRotatorios() ){
                            totalPuntos = auxTotalPuntos + clientePremiacionConcurso.getPuntosMeta().doubleValue();                               
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("JVM300, NivelesRotatorios="+concurso.getNivelesRotatorios()+" clientePremiacionConcurso.getPuntosMeta()="+clientePremiacionConcurso.getPuntosMeta().toString()+" totalPuntos="+totalPuntos);
                        }else{
                            if (concurso.getIndDuplaCyzone()){
                                totalPuntos += clientePremiacionConcurso.getPuntosMeta().doubleValue();
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("JVM300, concurso.getIndDuplaCyzone()="+concurso.getIndDuplaCyzone()+" clientePremiacionConcurso.getPuntosMeta()="+clientePremiacionConcurso.getPuntosMeta().toString()+" totalPuntos="+totalPuntos);
                            }
                        }      
                        
                        //jrivas 10/12/2008 20080808
                        //Cuando saldoADescontar > 0, es porque viene de recuperarPremiosMultinivel, y los puntos a descontar es el acumulado de los premios a entregar.
                        if (clientePremiacionConcurso.getSaldoADescontar() > 0) {
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                              UtilidadesLog.debug("Saldo A descontar = " + clientePremiacionConcurso.getSaldoADescontar());
                            totalPuntos = clientePremiacionConcurso.getSaldoADescontar();
                        }

                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("totalPuntos: " + new Integer(new Double((-1) * totalPuntos).intValue()));
                          UtilidadesLog.debug("getSaldoPuntosExigidos(): " + new Integer(clientePremiacionConcurso.getSaldoPuntosExigidos().intValue()));
                          UtilidadesLog.debug("concurso.getOidConcurso(): " + concurso.getOidConcurso());
                          UtilidadesLog.debug("clientePremiacion.getPeriodo().getOidPeriodo(): " + clientePremiacion.getPeriodo().getOidPeriodo());
                          UtilidadesLog.debug("ConstantesINC.TIPO_MOVIMIENTO_CARGO: " + ConstantesINC.TIPO_MOVIMIENTO_CARGO);
                          UtilidadesLog.debug("clientePremiacion.getOidCliente(): " + clientePremiacion.getOidCliente());
                        }  
                        
                        CuentaCorrientePuntosLocal cuentaCorriente = this.getCuentaCorrientePuntosLocalHome().create(new Integer(new Double((-1) * totalPuntos).intValue()),
                                                                                                                               new Integer(clientePremiacionConcurso.getSaldoPuntosExigidos().intValue()),
                                                                                                                               new Date(System.currentTimeMillis()),
                                                                                                                               concurso.getOidConcurso(),
                                                                                                                               clientePremiacion.getOidCliente(),
                                                                                                                               clientePremiacion.getPeriodo().getOidPeriodo(),
                                                                                                                               ConstantesINC.TIPO_MOVIMIENTO_CARGO);

                        cuentaCorriente.setVal_desc( ConstantesINC.DESC_ENTREGA_PREMIO );
                        
                        this.getCuentaCorrientePuntosLocalHome().merge(cuentaCorriente);
                        
                        // sapaza -- PER-SiCC-2014-0081 -- 30/01/2014
                        daoClientePremiacionConcurso.actualizarCandidataGanadora(clientePremiacion.getOidCliente(), concurso.getOidConcurso());
                    }

                    //FIN DE CAMBIO
                    double restaPremios = clientePremiacionConcurso.getSaldoPuntos().doubleValue() - totalPuntos;
                    clientePremiacionConcurso.setSaldoPuntos(new Double(restaPremios));
                    clientePremiacionConcurso.setPremiosGanados(premiosGanados);
                }
            }
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e);
        }

        UtilidadesLog.info("MONPremiacionBean.tranformarPuntosAPremios(ClientePremiacion clientePremiacion, ArrayList concursos):Salida");
    }


    /**
    * Fecha de Creacion: 18/05/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    //jrivas 20080535
    public void determinarGanadorasRecomendacionConsultora(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultora(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente)):Entrada");

        DAOClientePremiacionConcurso daoCliente = new DAOClientePremiacionConcurso();
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        ClientePremiacionRecomendado cliePremReco = null;
        ClientePremiacionConcurso cliePremConcu = null;
        Concurso concurso = null;

        UtilidadesLog.debug("Obtenemos recomnedantes.");

        //jrivas 20080535
        ArrayList clientesPremiacion = daoCliente.getRecomendantes(oidPeriodo, tipoProceso, oidZona, oidCliente);
        
        //jrivas 16/8/2006 BELC300023774 
            String descCuentaCorrientePuntos = daoCliente.obtenerDescCuentaCorrientePuntos(oidPeriodo);
        
        ArrayList clientesPremiacionRecomendado = new ArrayList();
        ArrayList premiosEscogidos = new ArrayList();
        GanadorasLocal ganadoras = null;

        try {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("clientesPremiacion: " + clientesPremiacion);

            //genero Long[] para setear DTOOIDs
            if (clientesPremiacion != null) {
                for (int index = 0; clientesPremiacion.size() > index; index++) {
                    ClientePremiacion clientePremiacion = (ClientePremiacion) clientesPremiacion.get(index);
                    // vbongiov -- 27/06/2006
                    //clientePremiacion.setSubacceso(subacceso);
                   
                    //obtengo los clientespremiacionconcurso de dicho clientePremiacion
                    HashMap clientesPremiacionConcurso = clientePremiacion.getClientesPremiacionConcurso();

                    //obtengo un Array de Longs de oidsConcurso
                    if (clientesPremiacionConcurso != null) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("clientesPremiacionConcurso " + clientesPremiacionConcurso.values().size());

                        Iterator itCliePremConcu = clientesPremiacionConcurso.values().iterator();
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("itCliePremConcu " + itCliePremConcu);

                        while (itCliePremConcu.hasNext()) {
                            cliePremConcu = clientePremiacion.getClientePremiacionConcurso(((ClientePremiacionConcurso) itCliePremConcu.next()).getOidConcurso());
                            //cliePremConcu = (ClientePremiacionConcurso) itCliePremConcu.next();
                            concurso = despacharPremiosHelper.obtenerConcurso(cliePremConcu.getOidConcurso());
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente(): " + concurso.getRecomendacionEfectivaGerente());

                            if (concurso.getRecomendacionEfectivaGerente()) {
                                UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente() true ");
                                
                                if((concurso.getIndTipoEvaluacion()==null) || (concurso.getIndTipoEvaluacion().intValue()==1)) {
                                    crearWorkSpace(reglasDeterminarGanadoraRecomendacion);
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("Antes de insertar Concurso: " + concurso);
                                    insertarTipoMontoEnMotor(concurso);
    
                                    //jrivas 19/8/2005
                                    //INC 20636 faltaba poner el concurso.
                                    insertarObjetoEnMotor(concurso);
    
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("Antes de insertar cliePremConcu: " + cliePremConcu);
                                    insertarClientePremiacionEnMotor(cliePremConcu);
                                    
                                    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                                    //insertarPedidosRecomendante(cliePremConcu);
                                    
                                    insertarPedidosRecomendados(cliePremConcu);
    
                                    Iterator u = objetosDelMotor.iterator();
    
                                    while (u.hasNext()) {
                                       UtilidadesLog.debug("Objetos :  " + u.next());
                                    }
    
                                    arrancarMotorDeReglas();
                                    
                                } else { //getIndTipoEvaluacion == 2
                                    if (cliePremConcu.getRecomendados() != null) {
                                     for (int i = 0; i < cliePremConcu.getRecomendados().size(); i++) {
                                         ClientePremiacionRecomendado recomendado = (ClientePremiacionRecomendado) cliePremConcu.getRecomendados().get(i);
                                         
                                         for (int j = 0; j < recomendado.getPedidosRecomendacion().size(); j++) {
                                             PedidoRecomendacion pedidoRecomendacion = (PedidoRecomendacion) recomendado.getPedidosRecomendacion().get(j);
                                             
                                             BigDecimal montoRecuperado = daoCliente.obtenerMontoRecuperado(concurso.getOidPais(), concurso.getNumeroConcurso(),
                                                                                    "2", pedidoRecomendacion.getSecuencia()); 
                                             
                                             // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
                                             if(montoRecuperado != null) {
                                                if((pedidoRecomendacion.getMontoPedido().doubleValue()>0) &&
                                                   ((pedidoRecomendacion.getMontoPedido().doubleValue()+
                                                            pedidoRecomendacion.getMontoRetail().doubleValue())>=montoRecuperado.doubleValue())) 
                                                    pedidoRecomendacion.setValido(true);
                                                else    
                                                    pedidoRecomendacion.setValido(false);
                                             } else {
                                                 pedidoRecomendacion.setValido(true);
                                             }
                                         }
                                     }
                                 }
                                }
                                
                                //jrivas 25/8/2005
                                //inc 20713
                                cliePremConcu.calcularTotalPedidosRecomendados();

                                UtilidadesLog.debug("Obtenemos recomnedados.");
                                clientesPremiacionRecomendado = cliePremConcu.getRecomendados();

                                if (clientesPremiacionRecomendado != null) {
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("clientesPremiacionRecomendado " + clientesPremiacionRecomendado.size());

                                    for (int index2 = 0; clientesPremiacionRecomendado.size() > index2; index2++) {
                                        cliePremReco = (ClientePremiacionRecomendado) clientesPremiacionRecomendado.get(index2);
                                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                          UtilidadesLog.debug("cliePremReco.getPremioElegido(): " + cliePremReco.getPremioElegido());
                                          UtilidadesLog.debug("cliePremReco.getOidClienteRecomendado(): " + cliePremReco.getOidClienteRecomendado());
                                    }
                                        //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                                        //Calculo de Pedido Recomendante
                                        if(concurso.getIndTipoEvaluacion() == null) {
                                            Iterator it = cliePremConcu.getPedidosRecomendacion().iterator();
                                            while (it.hasNext()) {
                                                PedidoRecomendacion ped = (PedidoRecomendacion) it.next();
                                                if ((ped.getMontoPedido().doubleValue() > 0) &&
                                                    (ped.getMontoPedido().doubleValue()+ped.getMontoRetail().doubleValue() >= concurso.getMontoMinimoPedido().doubleValue()) &&
                                                    (ped.getUnidadesPedido().doubleValue() >= concurso.getUnidadesMinimasPedido().doubleValue())) {
                                                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                                      UtilidadesLog.debug(" PROCESOSOSO!!!!");
                                                      UtilidadesLog.debug("ped.getPeriodo(): " + ped.getPeriodo().getOidPeriodo());
                                                      UtilidadesLog.debug("cliePremReco.getPeriodoFinVinculo(): " + cliePremReco.getPeriodoFinVinculo().getOidPeriodo());
                                                      UtilidadesLog.debug("cliePremReco.getPeriodoInicioVinculo(): " + cliePremReco.getPeriodoInicioVinculo().getOidPeriodo());
                                                    }  
                                                    
                                                    if (!ped.getPeriodo().mayorQue(cliePremReco.getPeriodoFinVinculo()) &&
                                                       (!ped.getPeriodo().menorQue(cliePremReco.getPeriodoInicioVinculo()))) {
                                                        UtilidadesLog.debug(" PROCESOSOSO!!!! 2");
                                                        cliePremConcu.setTotalPedidosRecomendante(
                                                                             new Long(cliePremConcu.getTotalPedidosRecomendante().longValue() + 1));
                                                    } else {
                                                        UtilidadesLog.debug("NO PROCESOSOSO 2  2 2 2!!!!");
                                                    }
                                                } else {
                                                    UtilidadesLog.debug("NO PROCESOSOSO!!!!");
                                                }
                                            }
                                            
                                        } else if(concurso.getIndTipoEvaluacion().intValue() == 1) {
                                            Iterator it = cliePremConcu.getPedidosRecomendacion().iterator();
                                            BigDecimal sumaMontoPedido = new BigDecimal(0);
                                            BigDecimal sumaMontoRetail = new BigDecimal(0);
                                            Long sumaUnidadesPedido = new Long(0);
                                            long totalPedidos = 0;
                                            
                                            while (it.hasNext()) {
                                                PedidoRecomendacion ped = (PedidoRecomendacion) it.next();
                                                
                                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                                  UtilidadesLog.debug("ped.getPeriodo(): " + ped.getPeriodo().getOidPeriodo());
                                                  UtilidadesLog.debug("cliePremReco.getPeriodoFinVinculo(): " + cliePremReco.getPeriodoFinVinculo().getOidPeriodo());
                                                  UtilidadesLog.debug("cliePremReco.getPeriodoInicioVinculo(): " + cliePremReco.getPeriodoInicioVinculo().getOidPeriodo());
                                                }
                                                
                                                if (!ped.getPeriodo().mayorQue(cliePremReco.getPeriodoFinVinculo()) &&
                                                   (!ped.getPeriodo().menorQue(cliePremReco.getPeriodoInicioVinculo()))) {
                                                    UtilidadesLog.debug(" PROCESO getIndTipoEvaluacion 1");
                                                    
                                                    sumaMontoPedido = sumaMontoPedido.add(ped.getMontoPedido());
                                                    sumaMontoRetail = sumaMontoRetail.add(ped.getMontoRetail());
                                                    sumaUnidadesPedido = sumaUnidadesPedido + ped.getUnidadesPedido();
                                                    totalPedidos++;
                                                } else {
                                                    UtilidadesLog.debug("NO PROCESO getIndTipoEvaluacion 1");
                                                }
                                                
                                                
                                            }    
                                            
                                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                                UtilidadesLog.debug("sumaMontoPedido: " + sumaMontoPedido);
                                                UtilidadesLog.debug("sumaUnidadesPedido: " + sumaUnidadesPedido);
                                                UtilidadesLog.debug("totalPedidos: " + totalPedidos);
                                            }
                                            
                                            if ((sumaMontoPedido.doubleValue() > 0) &&
                                                (sumaMontoPedido.doubleValue()+sumaMontoRetail.doubleValue() >= concurso.getMontoMinimoPedido().doubleValue()) &&
                                                (sumaUnidadesPedido.doubleValue() >= concurso.getUnidadesMinimasPedido().doubleValue())) {
                                                cliePremConcu.setTotalPedidosRecomendante(totalPedidos);
                                            }    
                                            
                                        } else if(concurso.getIndTipoEvaluacion().intValue() == 2) {
                                            Iterator it = cliePremConcu.getPedidosRecomendacion().iterator();
                                            while (it.hasNext()) {
                                                PedidoRecomendacion ped = (PedidoRecomendacion) it.next();
                                                
                                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                                  UtilidadesLog.debug("ped.getPeriodo(): " + ped.getPeriodo().getOidPeriodo());
                                                  UtilidadesLog.debug("cliePremReco.getPeriodoFinVinculo(): " + cliePremReco.getPeriodoFinVinculo().getOidPeriodo());
                                                  UtilidadesLog.debug("cliePremReco.getPeriodoInicioVinculo(): " + cliePremReco.getPeriodoInicioVinculo().getOidPeriodo());
                                                }
                                                
                                                if (!ped.getPeriodo().mayorQue(cliePremReco.getPeriodoFinVinculo()) &&
                                                   (!ped.getPeriodo().menorQue(cliePremReco.getPeriodoInicioVinculo()))) {

                                                    UtilidadesLog.debug(" PROCESO getIndTipoEvaluacion 2");
                                                    
                                                    Integer cantidadPeriodos = ped.getPeriodo().calcularCantidadPeriodos(cliePremReco.getPeriodoInicioVinculo().getOidPeriodo(),
                                                                                ped.getPeriodo().getOidPeriodo());
                                                    ped.setSecuencia(cantidadPeriodos);
                                                    
                                                    BigDecimal montoRecuperado = daoCliente.obtenerMontoRecuperado(concurso.getOidPais(), concurso.getNumeroConcurso(),
                                                                                 "1", ped.getSecuencia()); 
                                                    
                                                    if((montoRecuperado == null) || 
                                                       ((ped.getMontoPedido().doubleValue() > 0) &&
                                                         (ped.getMontoPedido().doubleValue()+ped.getMontoRetail().doubleValue()>=montoRecuperado.doubleValue()))) {
                                                        cliePremConcu.setTotalPedidosRecomendante(
                                                                         new Long(cliePremConcu.getTotalPedidosRecomendante().longValue() + 1));
                                                    }                     
                                                } else {
                                                    UtilidadesLog.debug("NO PROCESOSOSO!!!!");
                                                }
                                            }    
                                        }

                                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                          UtilidadesLog.debug("cliePremConcu.getTotalPedidosRecomendante(): " +
                                                           cliePremConcu.getTotalPedidosRecomendante());

                                          UtilidadesLog.debug("concurso.getNumeroMinimoPedido(): " + concurso.getNumeroMinimoPedido());
                                          UtilidadesLog.debug("cliePremReco.getTotalPedidosRecomendada(): " + cliePremReco.getTotalPedidosRecomendada());
                                          UtilidadesLog.debug("concurso.getNumeroMinimoPedidoRecomendada(): " +
                                                           concurso.getNumeroMinimoPedidoRecomendada());
                                        }                   

                                        if ((cliePremConcu.getTotalPedidosRecomendante().intValue() >= concurso.getNumeroMinimoPedido().intValue()) &&
                                                (cliePremReco.getTotalPedidosRecomendada().intValue() >= concurso.getNumeroMinimoPedidoRecomendada()
                                                                                                                     .intValue())) {
                                            cliePremConcu.setRecomendacionesEfectivas(new Long(cliePremConcu.getRecomendacionesEfectivas().longValue() +
                                                                                               1));
                                                                                               
                                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                                               
                                              UtilidadesLog.debug("cliePremConcu.getRecomendacionesEfectivas: " +
                                                               cliePremConcu.getRecomendacionesEfectivas());
                                                               
                                            //jrivas 25/8/2008 INICIO 20080580
                                            if (concurso.getIndGeneraPuntajeRecda()) {
                                                Integer numeroPuntos = new Integer(concurso.getPuntosAsignarConcuRedca().intValue() / concurso.getFactorConversionConcursoRedca().intValue());
                                                UtilidadesLog.debug("---> Crea CuentaCorrientePuntos Recomendada.");
                                                
                                                CuentaCorrientePuntosLocal ccp = this.getCuentaCorrientePuntosLocalHome().create(numeroPuntos, //
                                                                                                          new Integer(0), //
                                                                                                          new Date(System.currentTimeMillis()),//
                                                                                                          concurso.getConcursoPuntajeRecda(), //
                                                                                                          cliePremReco.getOidCliente(), // 
                                                                                                          oidPeriodo, //
                                                                                                          ConstantesINC.TIPO_MOVIMIENTO_ABONO); //
                                                                                                      
                                                ccp.setVal_desc("Abono Cliente Recomendante " + clientePremiacion.getDatosPersonales().getCodCliente()); //
                                                
                                                // vbongiov -- RI SiCC 20090999 -- 14/07/2009
                                                this.getCuentaCorrientePuntosLocalHome().merge(ccp);

                                                //jrivas 29/4/2009 20090903
                                                daoCliente.actualizarCandidata(concurso.getConcursoPuntajeRecda(), cliePremReco.getOidCliente(), oidPeriodo, false);

                                                /*CandidataGanadoraLocalHome candidataGanadoraHome = this.getCandidataGanadoraLocalHome();
                                                CandidataGanadoraLocal candidataGanadora = null;
                                                try {
                                                    candidataGanadora = candidataGanadoraHome.findByUK(concurso.getConcursoPuntajeRecda(), 
                                                                                                        cliePremReco.getOidCliente(),
                                                                                                        oidPeriodo);
                                                    candidataGanadora.setRequisitosPremiacionSuperados(Boolean.FALSE);
                                                } catch (NoResultException fe) {
                                                    UtilidadesLog.debug(fe);
                                                    UtilidadesLog.debug("---> Crea CandidataGanadora Recomendada.");
                                                    candidataGanadora = candidataGanadoraHome.create(Boolean.FALSE, 
                                                                                                      Boolean.FALSE,
                                                                                                      oidPeriodo,
                                                                                                      concurso.getConcursoPuntajeRecda(),
                                                                                                      cliePremReco.getOidCliente());
                                                }*/
                                            }                                            
                                            //FIN 20080580                                                               

                                            if ((cliePremReco.getPremioElegido() != null) && (cliePremReco.getPremioElegido().getNivel() != null) &&
                                                    (cliePremReco.getPremioElegido().getNivel().getOidNivel() != null)) {
                                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                    
                                                  UtilidadesLog.debug("Nivel: " + cliePremReco.getPremioElegido().getNivel().getOidNivel());
                                                
                                                //jrivas 29/8/2005
                                                //INC 20796

                                                cliePremConcu.setRequisitosPremiacionSuperado(false);   // Modificado por HRCS - Cambio Sicc20070275
                                                clientePremiacion.setIndCrearMensajePremio(false);      // JVM , sicc 20070275
                                                clientePremiacion.setIndGrabaCandidataGanadora(false);  // JVM , sicc 20070275
                                                
                                                UtilidadesLog.debug("*** 1 +++");
                                                this.determinarPremiosCuponRecomendacion(clientePremiacion, cliePremConcu, cliePremReco, concurso);                                       
                                                                                                                                            
                                                //UtilidadesLog.debug("*** 2 +++");
                                                //this.despacharPremios(clientePremiacion);
                                                //UtilidadesLog.debug("*** 3 +++");
                                                //  Agregado por HRCS - Fecha 03/07/2007 - Cambio Sicc20070275
                                                
                                                 // sapaza -- PER-SiCC-2014-0192 -- 06/03/2014
                                                if(ConstantesINC.TIPO_PREMIACION_POR_NIVELES.equals(concurso.getTipoPremiacion()) && 
                                                        cliePremReco.getPremioElegido().getNivel().isNivelSelectivo()) {
                                                    PremiosElegidosLocalHome incPremiosElegidos = this.getPremiosElegidosLocalHome();
                                                    Premio premioElegido = cliePremReco.getPremioElegido();
                                                    
                                                    incPremiosElegidos.create( new Integer(premioElegido.getNumeroPremio().intValue()), 
                                                                               clientePremiacion.getOidCliente(), 
                                                                               concurso.getOidConcurso(), 
                                                                               premioElegido.getNivel().getOidNivel(),  
                                                                               new java.sql.Date(System.currentTimeMillis()) );
                                                }                               
                                                
                                            } else {
                                                this.gestionarCandidataGanadoraRecomendada(clientePremiacion, cliePremConcu, cliePremReco, concurso);
                                            }
                                        }
                                    //jrivas 8/12/2006 V-INC-021
                                    cliePremConcu.setTotalPedidosRecomendante(new Long(0));
                                    }
                                }
                            } else {
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente() false: " + cliePremConcu.getRecomendados().size());
                                cliePremConcu.setRecomendacionesEfectivas(Long.valueOf(Integer.toString(cliePremConcu.getRecomendados().size())));
                            }

                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("Numero recomendacion efectiva: " + cliePremConcu.getRecomendacionesEfectivas());

                            if (!cliePremConcu.getRecomendacionesEfectivas().equals(new Long(0))) {
                                Integer numeroPuntos = Integer.valueOf(Integer.toString(cliePremConcu.getRecomendacionesEfectivas().intValue() / concurso.getFactorConversion().intValue() * concurso.getPuntosAsignar().intValue()));
                                UtilidadesLog.debug("---> Crea CuentaCorrientePuntos.");
                                
                                // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
                                BigDecimal bonificacion = daoCliente.obtenerMontoBonificacion(concurso.getOidPais(), oidPeriodo, concurso.getNumeroConcurso());
                                if(bonificacion != null) {
                                    numeroPuntos = numeroPuntos + bonificacion.multiply(new BigDecimal(numeroPuntos)).intValue();
                                }

                                CuentaCorrientePuntosLocal ccp = this.getCuentaCorrientePuntosLocalHome().create(numeroPuntos,
                                                                                          new Integer(cliePremConcu.getSaldoPuntosExigidos().intValue()),
                                                                                          new Date(System.currentTimeMillis()),
                                                                                          concurso.getOidConcurso(),
                                                                                          clientePremiacion.getOidCliente(), oidPeriodo,
                                                                                          ConstantesINC.TIPO_MOVIMIENTO_ABONO);
                                                                                          
                                //jrivas 16/8/2006 BELC300023774                                                                                           
                                ccp.setVal_desc(descCuentaCorrientePuntos);
                                
                                this.getCuentaCorrientePuntosLocalHome().merge(ccp);
                                
                                //jrivas 29/4/2009 20090903
                                daoCliente.actualizarCandidata(concurso.getOidConcurso(), clientePremiacion.getOidCliente(), oidPeriodo, cliePremConcu.getRequisitosPremiacionSuperado());
                                
                                //jrivas 25/8/2005
                                //inc 20713
                                /*CandidataGanadoraLocalHome candidataGanadoraHome = this.getCandidataGanadoraLocalHome();
                                CandidataGanadoraLocal candidataGanadora = null;
                               
                                UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + concurso.getOidConcurso());
                                UtilidadesLog.debug("CLIE_OID_CLIE:  " + clientePremiacion.getOidCliente());
                                UtilidadesLog.debug("periodo.getOidPeriodo():  " + oidPeriodo); 
                                
                                try {
                                    candidataGanadora = candidataGanadoraHome.findByUK(concurso.getOidConcurso(), 
                                                                                        clientePremiacion.getOidCliente(),
                                                                                        oidPeriodo);
                                    //jrivas 20080535
                                    candidataGanadora.setRequisitosPremiacionSuperados(Boolean.FALSE);
                                    
                                    candidataGanadoraHome.merge(candidataGanadora);

                                } catch (NoResultException fe) {
                                    UtilidadesLog.debug(fe);
                                    UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + concurso.getOidConcurso());
                                    UtilidadesLog.debug("CLIE_OID_CLIE:  " + clientePremiacion.getOidCliente());
                                    UtilidadesLog.debug("periodo.getOidPeriodo():  " + oidPeriodo); 
                                    UtilidadesLog.debug("cliePremConcu.getRequisitosPremiacionSuperado(): " + cliePremConcu.getRequisitosPremiacionSuperado());
                                    //public Long ejbCreate(Boolean indMetaSupe, Boolean valRequPremSupe, Long perdOidPeri, Long copaOidParaGral, Long clieOidClie)
                                    candidataGanadora = candidataGanadoraHome.create(Boolean.FALSE, new Boolean(cliePremConcu.getRequisitosPremiacionSuperado()),
                                                                                                            oidPeriodo,
                                                                                                            concurso.getOidConcurso(),
                                                                                                            clientePremiacion.getOidCliente());
                                } catch (PersistenceException ce) {
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }*/
                            }
                        }
                    }
                }
            }

            UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultora(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente)):Salida");
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e);
        }
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    * Revierte el proceso de premiación
    */
    public DTOEstatusSolicitud revertirPremiacion(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.revertirPremiacion(DTOSolicitudValidacion solicitudValidacion):Entrada");
        RevertirPremiacionHelper helper = new RevertirPremiacionHelper();
        DTOEstatusSolicitud dto = new DTOEstatusSolicitud();

        helper.revertirGanadoras(solicitudValidacion);
        helper.revertirCuentaCorrientePuntos(solicitudValidacion);
        helper.revertirCandidataGanadora(solicitudValidacion);

        dto.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPremiacionBean.revertirPremiacion(DTOSolicitudValidacion solicitudValidacion):Salida");
        return dto;
    }

    /**
    * Autor: Cortaberria
    * Fecha: 27/04/2005
    * Descripcion: Este metodo invoca al motor de reglas
    * @param listConcursos
    * @param clientePremiacion
    * Correccion: Damasia Maneiro
    */
    private void premiar(ClientePremiacion clientePremiacion, DTOOIDs oidsConcurso, String tipoCierre) throws MareException {
        
        UtilidadesLog.info("MONPremiacionBean.premiar(ClientePremiacion clientePremiacion, DTOOIDs oidsConcurso, String tipoCierre["+tipoCierre+"]):Entrada ");
        
        DAOCandidataGanadora daoCandidata = new DAOCandidataGanadora();
        DAOClientePremiacion daoCliente = new DAOClientePremiacion();
        RecuperadorDatosPremiacion recu = new RecuperadorDatosPremiacion();
        DespacharPremiosHelper dph = new DespacharPremiosHelper();
        ArrayList listaConcursosMotor = null;

        try {
            crearWorkSpace(reglasCalificacionPremiacion);
            insertarClientePremiacionEnMotor(clientePremiacion);

            if (oidsConcurso == null) {
                listaConcursosMotor = FactoriaConcurso.getFactoriaConcurso().getConcursos(clientePremiacion.getOidPais());
            } else {
                listaConcursosMotor = FactoriaConcurso.getFactoriaConcurso().getConcursosPorOID(oidsConcurso);
            }

            if (listaConcursosMotor.size() > 0) {
               // vbongiov 23/03/2006 - INC71
               HashMap auxClientePremiacionConcurso = new HashMap();
               Iterator itClientePremiacionConcurso = clientePremiacion.getClientesPremiacionConcurso().keySet().iterator();                                   
               Iterator itConcursosMotor = listaConcursosMotor.iterator();
               Concurso concurso = null;
               boolean encontro = false;
               
                while (itClientePremiacionConcurso.hasNext()) {
                    Object keyClientePremiacionConcurso = itClientePremiacionConcurso.next();
                    ClientePremiacionConcurso eleClientePremiacionConcurso = (ClientePremiacionConcurso) clientePremiacion.getClientesPremiacionConcurso().get(keyClientePremiacionConcurso);
                    encontro = false;
                    
                    itConcursosMotor = listaConcursosMotor.iterator();                    
                    while (itConcursosMotor.hasNext()) {
                    
                        concurso = (Concurso) itConcursosMotor.next();

                        if(concurso.getOidConcurso().equals(eleClientePremiacionConcurso.getOidConcurso())){
                            encontro = true;
                            break;
                        }
                    }
                    
                    if(encontro){
                        auxClientePremiacionConcurso.put(keyClientePremiacionConcurso, eleClientePremiacionConcurso);
                    }
                } 
    
                clientePremiacion.getClientesPremiacionConcurso().clear();
                clientePremiacion.getClientesPremiacionConcurso().putAll(auxClientePremiacionConcurso);
              
             
                //jrivas 2/8/2005
                //inc 20269
                Iterator it = listaConcursosMotor.iterator();    
                while (it.hasNext()) {
                    clientePremiacion.getClientePremiacionConcurso(((Concurso) it.next()).getOidConcurso());
                }
    
                insertarConcursosEnMotor(listaConcursosMotor);
                arrancarMotorDeReglas();
    
                //jrivas 2/8/2005
                //inc. 20353
                //daoCandidata.actualizaCandidataGanadora(clientePremiacion);

                HashMap mapClientePremiacionConcurso = clientePremiacion.getClientesPremiacionConcurso();
                Iterator itClientes = clientePremiacion.getClientesPremiacionConcurso().keySet().iterator();
    
                HashMap aux = new HashMap();
        
                while (itClientes.hasNext()) {
                    Object key = itClientes.next();
                    ClientePremiacionConcurso elemento = new ClientePremiacionConcurso(); // JVM 20070359
    
                    elemento = (ClientePremiacionConcurso) clientePremiacion.getClientesPremiacionConcurso().get(key);
                
    
                    // gPineda - 12/03/2007
                    if (
                            (elemento.getDescalificaClientePorSolicitud() == ConstantesINC.CAUSA_DESCALIF_ACTIVIDAD)  ||
                            (elemento.getDescalificaClientePorSolicitud() == ConstantesINC.CAUSA_DESCALIF_CONSTANCIA) &&
                            (
                                (tipoCierre != null &&  !ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoCierre)) || 
                                tipoCierre  == null) 
                        ) 
                    {
                        daoCliente.actualizarDescalificaciones(elemento, clientePremiacion);
                        daoCliente.actualizarCuentaCorriente(elemento, clientePremiacion);
                    }
    
                    //
                    // Se modifica, if (!elemento.getRechazado()) 
                    //
                    
                    if (!elemento.getRechazado() && 
                        (
                            (tipoCierre != null && ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoCierre))
                            || 
                            (tipoCierre == null)
                        )
                        )
                    {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("getRechazado="+elemento.getRechazado()+" no rechazado, oidConcurso: " + elemento.getOidConcurso());
    
                        //jrivas 1/8/2005
                        //inc. 20353
                        elemento.setRequisitosPremiacionSuperado(true);
    
                        //jrivas 26/7/2006 DBLG500001076 se agrega el ultimo periodo a evaluar en candidata ganadora
                        concurso = dph.obtenerConcurso(elemento.getOidConcurso());
                        Long oidPeriodo;
                        if ((concurso.getPeriodoDeDespacho() != null) && (concurso.getPeriodoDeDespacho().getOidPeriodo() != null) && (!concurso.getIndRanking())) {
                            oidPeriodo = concurso.getPeriodoDeDespacho().getOidPeriodo();
                        } else {
                            //oidPeriodo = clientePremiacion.getPeriodo().getOidPeriodo();
                            // Obtener periodo actual 
                            // vbongiov - 10/05/2006 - DBLG500000363
                            MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();            
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("opais: " + clientePremiacion.getOidPais() + " marca: " + clientePremiacion.getOidMarca() +
                                        "canal: " + clientePremiacion.getOidCanal());
                            
                            DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                clientePremiacion.getOidMarca(),
                                                clientePremiacion.getOidCanal());
                            
                            oidPeriodo = periodoActual.getOid();
                        }                       
                        
                        Periodo periodo = new Periodo();
                        periodo.setOidPeriodo(oidPeriodo);
                        elemento.setUltimoPeriodoEvaluado(periodo);

                        //jrivas 12/8/2005
                        //inc 20545                    
                        elemento.setActualizarCandidataGanadora(true);
                        
                        aux.put(key, elemento);
    
                        //clientePremiacion.getClientesPremiacionConcurso().remove(key);
                    } else {
                        if (ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoCierre) || tipoCierre == null) {
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("getRechazado="+elemento.getRechazado()+" rechazado, oidConcurso: " + elemento.getOidConcurso());
                        } 
                        if (ConstantesFAC.TIPO_CIERRE_PERIODO.equals(tipoCierre)){
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("getRechazado="+elemento.getRechazado()+" No se premia por ser Periodo, oidConcurso: " + elemento.getOidConcurso());
                        }                        
                    }
                    
                    // vbongiov -- Cambio 20090929 -- 18/09/2009
                    if(!elemento.getRechazadoPeriodoDespacho()) {
                        if(elemento.getActualizarAsignacionPremiosPendientes()){
                            daoCliente.actualizarAsignacionPremiosPendientes(elemento, clientePremiacion);                        
                        }
                        
                        if(elemento.getActualizarAsignacionPremiosPendientesCierre()){
                            concurso = dph.obtenerConcurso(elemento.getOidConcurso());
                            daoCliente.actualizarAsignacionPremiosPendientesCierre(concurso, elemento, clientePremiacion);                        
                        }
                        
                        if(elemento.getCreacionAsignacionPremiosPendientesCierre()){
                            concurso = dph.obtenerConcurso(elemento.getOidConcurso());
                            daoCliente.creacionAsignacionPremiosPendientesCierre(concurso, elemento, clientePremiacion);    
                        }
                    }    
                                        
                } //fin de iteracion 


                // gPineda - 12/03/2007
                /*
                if( (tipoCierre != null && ! ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoCierre)) || tipoCierre == null){
                    //jrivas 12/8/2005
                    //inc 20545
                    daoCandidata.actualizaCandidataGanadora(clientePremiacion);
                }
                */
                
                /*
                 * Autor : JVM
                 * Fecha : 26-Mar-2006
                 * Desc  : SICC-20070148,
                 */                   
                daoCandidata.actualizaCandidataGanadora(clientePremiacion, tipoCierre);
                clientePremiacion.getClientesPremiacionConcurso().clear();
                clientePremiacion.getClientesPremiacionConcurso().putAll(aux);
                    
                /*
                 * Autor : JVM
                 * Fecha : 26-Mar-2006
                 * Desc  : SICC-20070148, se agrega la condición por tipo de cierre diferente a Periodo
                 *         e imprimir un mensaje en el log de "tipoCierre, distinto a Cierre de Periodo" 
                 *         de ser igual.
                 */ 
                if (tipoCierre != ConstantesFAC.TIPO_CIERRE_PERIODO){
                    //jrivas 2/8/2005
                    //inc. 20353 (se cambio en 20545)
                    //daoCandidata.actualizaCandidataGanadora(clientePremiacion);
            
                    if (!clientePremiacion.getClientesPremiacionConcurso().isEmpty()) {
                        //INI sapaza -- PER-SiCC-2012-0398 -- 20/06/2012
                        DAODespachoPremios daoDespachoPremios = new DAODespachoPremios();
                        boolean despachoNuevas = daoDespachoPremios.consultarProgramasNuevasRegalo(clientePremiacion.getOidPais(), 
                                clientePremiacion.getPeriodo().getOidPeriodo(), clientePremiacion.getOidCliente());
                    
                        if(despachoNuevas) {
                            HashMap auxNuevas = new HashMap();     
                            
                            Iterator itClientesNuevas = clientePremiacion.getClientesPremiacionConcurso().keySet().iterator();
                            while (itClientesNuevas.hasNext()) {
                                Object key = itClientesNuevas.next();
                                ClientePremiacionConcurso elementoNuevas = (ClientePremiacionConcurso)clientePremiacion.getClientesPremiacionConcurso().get(key);
                                
                                String progNuevasRegalo = daoDespachoPremios.ejecutarProgramasNuevasRegalo(clientePremiacion.getOidPais(),
                                                                    clientePremiacion.getPeriodo().getOidPeriodo(), elementoNuevas.getOidConcurso(), 
                                                                    clientePremiacion.getOidCliente());
                                                   
                                if(progNuevasRegalo.equals("0")) {
                                    auxNuevas.put(key, elementoNuevas);
                                }
                            }
                            
                            clientePremiacion.getClientesPremiacionConcurso().clear();
                            clientePremiacion.getClientesPremiacionConcurso().putAll(auxNuevas);
                        }
                        //FIN sapaza -- PER-SiCC-2012-0398 -- 20/06/2012
                        
                        if (!clientePremiacion.getClientesPremiacionConcurso().isEmpty()) {
                            recu.obtenerDatosTransformasPuntosPremios(clientePremiacion, listaConcursosMotor);                       
                            tranformarPuntosAPremios(clientePremiacion, listaConcursosMotor);
                            this.despacharPremios(clientePremiacion);   
                        }    
                    } else {
                        UtilidadesLog.debug("todos rechazados");
                    }
                    
                }else{
                    UtilidadesLog.debug("tipoCierre es igual al Cierre de Periodo");
                }
            }
        } catch (MareException me) {
            UtilidadesLog.error("ERROR",me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e);
        }
        UtilidadesLog.info("MONPremiacionBean.premiar(ClientePremiacion clientePremiacion, DTOOIDs oidsConcurso):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 27/04/2005
    * Descripcion: este metodo despacha los premios obtenidos por el cliente y el concurso recibidos por parametro.
    * @param clientePremiacion
    */
    public void despacharPremios(ClientePremiacion clientePremiacion)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.despacharPremios(ClientePremiacion clientePremiacion):Entrada");
       
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        Iterator itClienConcursos = clientePremiacion.getClientesPremiacionConcurso().keySet().iterator();
        ClientePremiacionConcurso clienteConcurso = null;


        try {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("ClientesPremiacionConcurso cantidad" + 
                clientePremiacion.getClientesPremiacionConcurso().size());

            while (itClienConcursos.hasNext()) {
                Object key = itClienConcursos.next();
                clienteConcurso = (ClientePremiacionConcurso) clientePremiacion.getClientesPremiacionConcurso().get(key);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("clienteConcurso.getRequisitosPremiacionSuperado() " + 
                    clienteConcurso.getRequisitosPremiacionSuperado());

                if (clienteConcurso.getRequisitosPremiacionSuperado()) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("clienteConcurso.getPremiosGanados()() " + 
                        clienteConcurso.getPremiosGanados());

                    if (clienteConcurso.getPremiosGanados() != null) {
                        Iterator itPremios = clienteConcurso.getPremiosGanados().iterator();

                        while (itPremios.hasNext()) {
                            Premio premioGanado = (Premio) itPremios.next();
                            
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("premioGanado " + premioGanado.getOidGanadora());
                              UtilidadesLog.debug("premioGanado.getTipoPremio() " + premioGanado.getTipoPremio());
                            }  

                            if (ConstantesINC.TIPO_PREMIO_MONETARIO.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoMonetario(clientePremiacion, 
                                premioGanado, clienteConcurso);
                            }
                            else if (ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoArticulo(clientePremiacion, 
                                premioGanado, clienteConcurso);
                            }
                            else if (ConstantesINC.TIPO_PREMIO_PUNTUACION.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoPuntuacion(clientePremiacion, 
                                premioGanado, clienteConcurso);
                            }
                            else if (ConstantesINC.TIPO_PREMIO_DESCUENTOS.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoDescuentos(clientePremiacion, 
                                premioGanado, clienteConcurso);
                            }
                        } //while(itPremios.hasNext())
                    } //clienteConcurso.getPremiosGanados() != null
                } //clienteConcurso.getRequisitosPremiacionSuperado()
            } //while(itClienConcursos.hasNext())
        }
        catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONPremiacionBean.despacharPremios(ClientePremiacion clientePremiacion):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void crearWorkSpace(String reglasAplicables)
            throws MareException {
            UtilidadesLog.info("MONPremiacionBean.crearWorkSpace(String reglasAplicables):Entrada");
        try {
            RuleService ruleService = (RuleService) MareMii.getService(new MareTopic(MareMii.SERVICE_RULE));
            objetosDelMotor = new ArrayList();
            workSpace = (StatelessRuleSession) ruleService.createRuleSession(reglasAplicables, null, 1);
        } catch (MareMiiServiceNotFoundException mm) {
            UtilidadesLog.error("ERROR ", mm);
            sessionContext.setRollbackOnly();
            throw new MareException(mm, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONPremiacionBean.crearWorkSpace(String reglasAplicables):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void arrancarMotorDeReglas() throws MareException {
        UtilidadesLog.info("MONPremiacionBean.arrancarMotorDeReglas():Entrada");
        try {
            workSpace.executeRules(objetosDelMotor);
            objetosDelMotor.clear();
            workSpace.release();
            workSpace = null;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            try {
                workSpace.release();
            } catch (Exception w) {
                UtilidadesLog.error("ERROR ", w);
            }  
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONPremiacionBean.arrancarMotorDeReglas():Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarConcursosEnMotor(java.util.ArrayList concursos) {
        if (concursos != null) {
            objetosDelMotor.addAll(concursos);
        }
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarPremioEnMotor(Premio premio) {
        //1.- Al atributo objetosDelMotor le concatenamos la entrada del método
        objetosDelMotor.add(premio);
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarClientePremiacionEnMotor(ClientePremiacion clientePremiacion) {
        //1.- Al atributo objetosDelMotor le concatenamos la entrada del método
        objetosDelMotor.add(clientePremiacion);
    }

    /**
    * Fecha de Creacion: 16/05/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    private void determinarPremiosCuponRecomendacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,
    ClientePremiacionRecomendado recomendado, Concurso concurso) throws MareException {
        
        UtilidadesLog.info("MONPremiacionBean.determinarPremiosCuponRecomendacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
        "ClientePremiacionRecomendado recomendado, Concurso concurso):Entrada");

        ArrayList premiosGanados = new ArrayList();
        GestorMensajesTransformar gestorMensajesTransformar = new GestorMensajesTransformar();
        GanadorasLocal ganadoras = null;
        ClienteRecomendadoLocal clienteRecomendadoLocal = null;

        UtilidadesLog.debug("Preparamos WorkSpace");
        crearWorkSpace(reglasTransformaPuntosAPremios);
        insertarClientePremiacionEnMotor(clientePremiacionConcurso);

        Premio premioElegido = recomendado.getPremioElegido();
        insertarPremioEnMotor(premioElegido);

        try {
            arrancarMotorDeReglas();
            UtilidadesLog.debug("Arramcamos el MotorDeReglas");

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("Premio elegido: " + premioElegido.getOidPremio());

            if (premioElegido.getActualizarGanadora()) {
                boolean inserte = false;
                
                // vbongiov -- 14/11/2006 -- DBLG700000221
                clientePremiacion.setIndCuponRecomendacion(Boolean.TRUE);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("premioElegido.getTipoPremio() " + premioElegido.getTipoPremio());

                if (ConstantesINC.TIPO_PREMIO_MONETARIO.equals(premioElegido.getTipoPremio())) {
                    PremioMonetario premioMonetario = (PremioMonetario) premioElegido;

                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("premioMonetario.getPagoEnPartes() " + premioMonetario.getPagoEnPartes());

                    if (premioMonetario.getPagoEnPartes()) {
                        Iterator itPagosPartes = premioMonetario.getPagosEnPartes().iterator();

                        while (itPagosPartes.hasNext()) {
                            PagoPartes pagoPartes = (PagoPartes) itPagosPartes.next();

                            BigDecimal unidades = BigDecimal.valueOf(premioMonetario.getUnidades().longValue());
                            
                            //jrivas 14/7/2006 INC-141
                            unidades = new BigDecimal(unidades.doubleValue() * pagoPartes.getPorcentajePremio().doubleValue() / 100);

                            Boolean listarGanador = Boolean.FALSE;
                            Boolean descontar = Boolean.FALSE;
                            Boolean despachado = Boolean.FALSE;

                            //Boolean listarGanador = Boolean.valueOf(premioMonetario.getListarGanador());
                            //Boolean descontar = Boolean.valueOf(premioMonetario.getDescontarPagosAnticipados());
                            //Boolean despachado = Boolean.valueOf(premioMonetario.getDespachado());
                            Long oidCliente = clientePremiacion.getOidCliente();
                            Long oidPeriodo = pagoPartes.getPeriodoControl().getOidPeriodo();
                            Long oidNivel = premioMonetario.getNivel().getOidNivel();
                            
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("oidCliente: " + oidCliente);
                              UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                              UtilidadesLog.debug("oidNivel: " + oidNivel);
                            }   
                            
                            //public Long ejbCreate(BigDecimal unidades, Boolean listarGanador, Boolean descontar, Boolean despachado, Long oidCliente, Long periodoDespacho, Long nivelPremiacion) throws MareException
                            if (clientePremiacion.getIndGrabaCandidataGanadora() == true){ // JVM - sicc 20070275
                                ganadoras = this.getGanadorasLocalHome().create
                                    (unidades, listarGanador, descontar, despachado, oidCliente, oidPeriodo, oidNivel);
                                ganadoras.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));     
                                this.getGanadorasLocalHome().merge(ganadoras);
                                //agreagado por cvalenzu - 13/11/2006
                                //DBLG 614
                                 if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("*** ganadoras.getOid(): " + ganadoras.getOid());
                                  
                                pagoPartes.setOidGanadora(ganadoras.getOid());
                                //FIN - agreagado por cvalenzu - 13/11/2006  
                                inserte = true;
                            }                                                    
                        }
                    } else {
                        inserte = false;
                    }
                }

                if (!inserte && clientePremiacion.getIndGrabaCandidataGanadora() == true) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("*** premioElegido.getUnidades(): " + premioElegido.getUnidades());

                    BigDecimal unidades = BigDecimal.valueOf(premioElegido.getUnidades().longValue());

                    Boolean listarGanador = Boolean.FALSE;
                    Boolean descontar = Boolean.FALSE;
                    Boolean despachado = Boolean.FALSE;

                    Long oidCliente = clientePremiacion.getOidCliente();

                    Long oidPeriodo = null;

                    //jrivas 11/8/2006  DBLG500000754
                    //se necesita primero ver si tengo periodo despacho, si no lo ntego, guardo periodo actual.
                    if ((concurso.getPeriodoDeDespacho() != null) && (concurso.getPeriodoDeDespacho().getOidPeriodo() != null) && (!concurso.getIndRanking())) {
                        oidPeriodo = concurso.getPeriodoDeDespacho().getOidPeriodo();
                    } else {
                        // Obtener periodo actual 
                        // vbongiov - 10/05/2006 - DBLG500000363
                        MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();          
                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("pais: " + clientePremiacion.getOidPais() + " marca: " + clientePremiacion.getOidMarca() +
                                            "canal: " + clientePremiacion.getOidCanal());
                        }
                        
                          DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                    clientePremiacion.getOidMarca(),
                                                    clientePremiacion.getOidCanal());
                       
                        oidPeriodo = periodoActual.getOid();
                    }
                   
                    Long oidNivel = premioElegido.getNivel().getOidNivel();
                    
                    if(log.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("oidCliente: " + oidCliente);
                      UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
                      UtilidadesLog.debug("oidNivel: " + oidNivel);
                    }  

                    //public Long ejbCreate(BigDecimal unidades, Boolean listarGanador, Boolean descontar, Boolean despachado, Long oidCliente, Long periodoDespacho, Long nivelPremiacion) throws MareException
                    ganadoras = this.getGanadorasLocalHome().create(unidades, listarGanador, descontar, despachado, oidCliente, oidPeriodo,
                                                                              oidNivel);
                                                                              
                    ganadoras.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));                                                                                   
                    
                    this.getGanadorasLocalHome().merge(ganadoras);
                    
                    //agreagado por cvalenzu - 13/11/2006
                    //DBLG 614
                     if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("*** ganadoras.getOid(): " + ganadoras.getOid());
                    premioElegido.setOidGanadora(ganadoras.getOid());
                    //FIN - agreagado por cvalenzu - 13/11/2006
                }
              
                // BELC300024320 - gPineda - 13/10/06
                Double puntosCanjeadosPremio;
                if( premioElegido.getNivel().getCantidadFijaPuntos() != null 
                      && premioElegido.getNivel().getCantidadFijaPuntos().compareTo( new Double(0) ) != 0 ){
                  puntosCanjeadosPremio = premioElegido.getNivel().getCantidadFijaPuntos();
                }else{
                  puntosCanjeadosPremio = premioElegido.getNivel().getCantidadInicialPuntos();
                }
                
                if(clientePremiacionConcurso.getPuntosCanjeados()==null){
                  clientePremiacionConcurso.setPuntosCanjeados(puntosCanjeadosPremio);
                }else{
                  double suma = clientePremiacionConcurso.getPuntosCanjeados().doubleValue() + puntosCanjeadosPremio.doubleValue();
                  clientePremiacionConcurso.setPuntosCanjeados( new Double(suma) );
                }
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("clientePremiacionConcurso.getPuntosCanjeados() : "+ 
                    clientePremiacionConcurso.getPuntosCanjeados() );

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                   UtilidadesLog.debug("concurso.getComunicacionDespachoAutomatico(): " + 
                     concurso.getComunicacionDespachoAutomatico());
                //if (concurso.getComunicacionAutomatica()) {
                
                if (clientePremiacion.getIndCrearMensajePremio() == true ){
                    if ( concurso.getComunicacionDespachoAutomatico() ) {
                        gestorMensajesTransformar.crearMensajeINC08Premio(clientePremiacion, 
                        clientePremiacionConcurso, concurso, premioElegido);
                    }
                }

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("Comunicacion en obtencion puntos: " + concurso.getComunicacionEnObtencionPuntos());

                if (concurso.getComunicacionEnObtencionPuntos()) {
                    gestorMensajesTransformar.crearMensajeRecomendacionEfectiva(clientePremiacion, 
                                                                            clientePremiacionConcurso, recomendado, concurso);
                }
                
                clienteRecomendadoLocal = this.getClienteRecomendadoLocalHome().findByPrimaryKey(recomendado.getOidClienteRecomendado());
                clienteRecomendadoLocal.setEfectiva(Boolean.TRUE);

                //jrivas 20080535
                clienteRecomendadoLocal.setEval(Boolean.TRUE);
                this.getClienteRecomendadoLocalHome().merge(clienteRecomendadoLocal);
                
                premiosGanados.add(premioElegido);
                clientePremiacionConcurso.setPremiosGanados(premiosGanados);
            }
        }
        catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONPremiacionBean.determinarPremiosCuponRecomendacion(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
                            "ClientePremiacionRecomendado recomendado, Concurso concurso):Salida");
    }
    
    /**
    * Autor: Cortaberria / Dante Castiglione
    * Fecha: 25/04/2005
    */
    private void gestionarCandidataGanadoraRecomendada(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,
                                                       ClientePremiacionRecomendado recomendado, Concurso concurso)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.gestionarCandidataGanadoraRecomendada(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
                                                       "ClientePremiacionRecomendado recomendado, Concurso concurso):Entrada");

        if (concurso.getComunicacionEnObtencionPuntos()) {
            UtilidadesLog.debug("MSG MensajeRecomendacionEfectiva");

            GestorMensajesTransformar msg = new GestorMensajesTransformar();
            msg.crearMensajeRecomendacionEfectiva(clientePremiacion, clientePremiacionConcurso, recomendado, concurso);
        }

        try {
            ClienteRecomendadoLocalHome clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
            ClienteRecomendadoLocal clienteRecomendado = clienteRecomendadoHome.findByPrimaryKey(recomendado.getOidClienteRecomendado());
            clienteRecomendado.setEfectiva(new Boolean(true));
            
            //jrivas 20080535
            clienteRecomendado.setEval(Boolean.TRUE);
            
            clienteRecomendadoHome.merge(clienteRecomendado);
            
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            sessionContext.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPremiacionBean.gestionarCandidataGanadoraRecomendada(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
                                                       "ClientePremiacionRecomendado recomendado, Concurso concurso):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarPedidosRecomendante(ClientePremiacionConcurso clientePremiacionConcurso) {
        //1.- Al atributo objetos del motor le añadimos todos los elementos de clientePremiacionConcurso.pedidosRecomendacion
        UtilidadesLog.debug("Antes de insertar getPedidosRecomendacion: " + clientePremiacionConcurso.getPedidosRecomendacion());
        objetosDelMotor.addAll(clientePremiacionConcurso.getPedidosRecomendacion());
    }

    /**
    * Fecha de Creacion: 09/05/2005
    * Autor: Damasia Maneiro
    * Comentario:
    *
    */
    private void insertarPedidosRecomendados(ClientePremiacionConcurso clientePremiacionConcurso) {
        UtilidadesLog.info("MONPremiacionBean.insertarPedidosRecomendados(ClientePremiacionConcurso clientePremiacionConcurso):Entrada");
        ArrayList recomendados = clientePremiacionConcurso.getRecomendados();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("getRecomendados: " + clientePremiacionConcurso.getRecomendados());

        for (int pos = 0; recomendados.size() > pos; pos++) {
            ClientePremiacionRecomendado clientePremiacion = (ClientePremiacionRecomendado) recomendados.get(pos);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("clientePremiacion.getPedidosRecomendacion: " + clientePremiacion.getPedidosRecomendacion());

            //jrivas 25/8/2005
            //inc 20713
            objetosDelMotor.add(clientePremiacion);

            if (clientePremiacion.getPedidosRecomendacion() != null) {
                objetosDelMotor.addAll(clientePremiacion.getPedidosRecomendacion());
            }
        }
        UtilidadesLog.info("MONPremiacionBean.insertarPedidosRecomendados(ClientePremiacionConcurso clientePremiacionConcurso):Salida");
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarTipoMontoEnMotor(Concurso concurso) {
        //1.- Al atributo objetosDelMotor le concatenamos los objetos TipoMontos de concurso.montosRecomendada
        if (concurso.getMontosRecomendada() != null) {
            objetosDelMotor.addAll(concurso.getMontosRecomendada());
        }
    }

    /**
    * Autor: Cortaberria
    * Fecha: 25/04/2005
    */
    private void insertarClientePremiacionEnMotor(ClientePremiacionConcurso clientePremiacionConcurso) {
        //1.- Al atributo objetosDelMotor le concatenamos la entrada del método
        objetosDelMotor.add(clientePremiacionConcurso);
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    */
    private void insertarObjetoEnMotor(Object p0) {
        UtilidadesLog.info("MONPremiacionBean.insertarObjetoEnMotor " + p0);
        objetosDelMotor.add(p0);
    }

   /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: El objetivo de este método es evaluar la premiar de los gerente para los concursos de tipo "Recomendacion Gerente"
    * Modificado: 28/7/2006 jrivas
    */
    public void premiarRecomendacionGerente(Long oidPais, Long oidPeriodo, Long subacceso) throws MareException {
        UtilidadesLog.info("MONPremiacionBean.premiarRecomendacionGerente2(Long oidPais, Long oidPeriodo, Long subacceso):Entrada");

        DAOGerentes daoGerentes = new DAOGerentes();
        DespacharPremiosHelper dph = new DespacharPremiosHelper();
        HashMap clientesRecomendadosGerencia = new HashMap();
        //ClientePremiacion clientePremiacion = null;
        //Iterator cliePremConcIt = null;
        ClientePremiacionConcurso clientePremiacionConcurso = null;
        ClientePremiacionRecomendado clienteRecomendado = null;
        Concurso concurso = null;
        //HashMap clienteGerencia;

        try {
            clientesRecomendadosGerencia = daoGerentes.recuperarRecomendadosGerente(oidPais, oidPeriodo);
            
            Iterator listasItGerente = clientesRecomendadosGerencia.values().iterator();

            while (listasItGerente.hasNext()) {
                //obtenemos los clientesRecomendados por gerencia
                ArrayList gerentes = (ArrayList) listasItGerente.next(); //arraylist clientepremiacionconcurso

                Iterator clientesIt = gerentes.iterator();
                while (clientesIt.hasNext()) {
                        //crearWorkSpace(reglasDeterminarGanadoraRecomendacionGerente);
                        clientePremiacionConcurso = (ClientePremiacionConcurso) clientesIt.next();
                        concurso = dph.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());

                        if  (concurso.getRecomendacionEfectivaGerente()) {
                            Iterator recomendadasIt = clientePremiacionConcurso.getRecomendados().iterator();
                            while (recomendadasIt.hasNext()) {
                                crearWorkSpace(reglasDeterminarGanadoraRecomendacionGerente);
                                insertarObjetoEnMotor(concurso);
                                insertarObjetoEnMotor(clientePremiacionConcurso);
                                clienteRecomendado = (ClientePremiacionRecomendado) recomendadasIt.next();
                                insertarObjetoEnMotor(clienteRecomendado);
                                arrancarMotorDeReglas();
                            }
                        } else {
                            clientePremiacionConcurso.setRecomendacionesEfectivas(new Long(clientePremiacionConcurso.getRecomendados().size()));
                        }
                }

                //recorremos los clientesRecomendados pertenecientes a un gerente
                clientesIt = gerentes.iterator();

                while (clientesIt.hasNext()) {
                    clientePremiacionConcurso = (ClientePremiacionConcurso) clientesIt.next();
                    // 3.7.1.- creamos una variable puntos = clientesPremiacionConcurso*numRecomendacionesEfectivas / concurso.factorConversion* concurso.puntosAsignar. (el concurso deberá ser el que tenga el mismo oidConcurso que clientePremiacionConcurso.oidConcurso) 
                    concurso = dph.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());

                    long puntajeTotal = clientePremiacionConcurso.getRecomendacionesEfectivas().longValue() / concurso.getFactorConversion().longValue() * concurso.getPuntosAsignar().longValue();

                    //crear una entidad CuentaCorrientePuntos
                    UtilidadesLog.debug("*** Crea CuentaCorrientePuntos " + puntajeTotal + " -- " + clientePremiacionConcurso.getOidConcurso() + " -- " + clientePremiacionConcurso.getGerente().getOidCliente() + " -- " + oidPeriodo);
                    CuentaCorrientePuntosLocal cuentaCorrientePuntos = this.getCuentaCorrientePuntosLocalHome().create(
                                                                              Integer.valueOf(Long.toString(puntajeTotal)),
                                                                              new Integer(clientePremiacionConcurso.getSaldoPuntosExigidos().intValue()),                        
                                                                              new Date(System.currentTimeMillis()),
                                                                              clientePremiacionConcurso.getOidConcurso(),
                                                                              clientePremiacionConcurso.getGerente().getOidCliente(), oidPeriodo,
                                                                              ConstantesINC.TIPO_MOVIMIENTO_ABONO);
                                                                              
                    // vbongiov -- 18/10/2006 -- DBLG700000140
                    // Obtener descripcion
                    DAOConcursoPremiacion daoConcursoPremiacion = new DAOConcursoPremiacion();
                    
                    RecuperadorIdiomaDefectoServidor recuperadorIdiomaDefectoServidor = new RecuperadorIdiomaDefectoServidor(); 
                    Long oidIdioma = recuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();                     
                    
                    RecordSet rs = daoConcursoPremiacion.recuperarDatosDescripcionAbono(oidPeriodo, oidIdioma, ConstantesINC.TIPO_MOVIMIENTO_ABONO);
                    
                    String descripcion = (String)rs.getValueAt(0, "DESCTIPOMOV") + " Puntaje del periodo " +
                                  (String)rs.getValueAt(0, "DES_MARC") + " " + (String)rs.getValueAt(0, "DESCCANAL") + " " +
                                  (String)rs.getValueAt(0, "COD_PERI");  
                                  
                    UtilidadesLog.debug("descripcion: "+ descripcion);
                    cuentaCorrientePuntos.setVal_desc( descripcion );                                  
                    
                    this.getCuentaCorrientePuntosLocalHome().merge(cuentaCorrientePuntos);

                    //primero lo busco
                    //crear una entidad CandidataGanadora
                    CandidataGanadoraLocalHome candiGanaHome = this.getCandidataGanadoraLocalHome();;
                    CandidataGanadoraLocal candiGana;
                                                
                    UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + clientePremiacionConcurso.getOidConcurso());
                    UtilidadesLog.debug("CLIE_OID_CLIE:  " + clientePremiacionConcurso.getGerente().getOidCliente());
                    UtilidadesLog.debug("oidPeriodo:  " + oidPeriodo); 
                
                    try {
                        candiGana = candiGanaHome.findByUK(
                        clientePremiacionConcurso.getOidConcurso(), clientePremiacionConcurso.getGerente().getOidCliente(), 
                                oidPeriodo);
                        UtilidadesLog.debug("Candidata a ganadora: la encontré ");
                        UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + Boolean.FALSE);
                        
                        candiGana.setRequisitosPremiacionSuperados(Boolean.FALSE);
                        candiGana.setMetasSuperadas(Boolean.FALSE);
                        if (clientePremiacionConcurso.getUltimoPeriodoEvaluado() != null) {
                            candiGana.setUltimoPeriodoEvaluado(clientePremiacionConcurso.getUltimoPeriodoEvaluado().getOidPeriodo());
                        }
                        candiGana.setBaseIncumplida(clientePremiacionConcurso.getOidBaseIncumplida());
                        candiGanaHome.merge(candiGana);
                    } catch (NoResultException fe) {
                        //crear una entidad CandidataGanadora
                        UtilidadesLog.debug("*** Crea CandidataGanadora");
                        
                        UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + Boolean.FALSE);
                        UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + clientePremiacionConcurso.getOidConcurso());
                        UtilidadesLog.debug("CLIE_OID_CLIE:  " + clientePremiacionConcurso.getGerente().getOidCliente());
                        UtilidadesLog.debug("oidPeriodo:  " + oidPeriodo); 
                    
                        candiGana = candiGanaHome.create(Boolean.FALSE, Boolean.FALSE, oidPeriodo,
                                                                              clientePremiacionConcurso.getOidConcurso(),
                                                                              clientePremiacionConcurso.getGerente().getOidCliente());
                        candiGana.setBaseIncumplida(clientePremiacionConcurso.getOidBaseIncumplida());
                        if (clientePremiacionConcurso.getUltimoPeriodoEvaluado() != null) {
                            candiGana.setUltimoPeriodoEvaluado(clientePremiacionConcurso.getUltimoPeriodoEvaluado().getOidPeriodo());
                        }
                        candiGanaHome.merge(candiGana);
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }

                    if (concurso.getComunicacionAutomatica()) {
                        DAOMultinivel daoMultinivel = new DAOMultinivel();
                        GestorMensajesTransformar gestorMensajesTransformar = new GestorMensajesTransformar();
                        DTODatosMensajeMultinivel datosGerente = null;
                        DTODatosMensajeMultinivel datosRecomendado = new DTODatosMensajeMultinivel();
                        datosGerente = daoMultinivel.recuperarDatosMensaje(clientePremiacionConcurso.getGerente().getOidCliente(), concurso);
                        gestorMensajesTransformar.crearMensajeNumPuntosRecomendacionesGerente(concurso, datosGerente, datosRecomendado,
                                                                                              puntajeTotal);
                    }
                
                }
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        }
        UtilidadesLog.info("MONPremiacionBean.premiarRecomendacionGerente2(Long oidPais, Long oidPeriodo, Long subacceso):Salida");
    }


    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: El objetivo de este método es evaluar la premiar de los gerente para los concursos de tipo "Recomendacion Gerente"
    */
    public DTOOIDs obtenerConcursosRecomendadosOIDs(ArrayList clientesRecomendadosGerencia)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.obtenerConcursosRecomendadosOIDs(ArrayList clientesRecomendadosGerencia):Entrada");
        ClientePremiacionConcurso clientePremiacionConcurso = new ClientePremiacionConcurso();
        ArrayList concursos = new ArrayList();
        DTOOIDs dtoOIDs = new DTOOIDs();
        Long oidConcurso = null;

        for (int pos = 0; clientesRecomendadosGerencia.size() > pos; pos++) {
            clientePremiacionConcurso = (ClientePremiacionConcurso) clientesRecomendadosGerencia.get(pos);
            oidConcurso = clientePremiacionConcurso.getOidConcurso();

            if (!seRepite(oidConcurso, concursos)) {
                concursos.add(oidConcurso);
            }
        }

        Long[] oidsConcurso = (Long[]) concursos.toArray(new Long[concursos.size()]);
        dtoOIDs.setOids(oidsConcurso);
        UtilidadesLog.info("MONPremiacionBean.obtenerConcursosRecomendadosOIDs(ArrayList clientesRecomendadosGerencia):Salida");
        return dtoOIDs;
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: El objetivo de este método es saber si un oidConcurso se repite entre los clientesPremiacionConcurso
    */
    private boolean seRepite(Long oidConcurso, ArrayList concursos) {
        UtilidadesLog.info("MONPremiacionBean.seRepite():Entrada");
        Iterator cliRecGerIt = concursos.iterator();

        while (cliRecGerIt.hasNext()) {
            Long aux = (Long) cliRecGerIt.next();

            if (aux.equals(oidConcurso)) {
                UtilidadesLog.info("MONPremiacionBean.seRepite():Salida TRUE");
                return true;
            }
        }

        UtilidadesLog.info("MONPremiacionBean.seRepite():Salida FALSE");
        return false;
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: Este metodo procesa la premiacion de gerentes. Este método es invocado desde el CU Procesar Cierre Incentivos.
    */
    public void premiarGerentes(DTOFACProcesoCierre dtoe)
            throws MareException {
        UtilidadesLog.info("MONPremiacionBean.premiarGerentes(DTOFACProcesoCierre dtoe):Entrada");

        try {
            EvaluadorDeMetas evaluadorDeMetas = new EvaluadorDeMetas();
            DAOGerentes daoGerentes = new DAOGerentes();
            DAOClientePremiacion daoCliePrem = new DAOClientePremiacion();
            ClientePremiacion clientePremiacion = new ClientePremiacion();
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = this.getClienteDatosBasicosLocalHome();
          
            // inc 19779 -- Cleal
            DTOETramitarCierre dtoeT = new DTOETramitarCierre();
            dtoeT.setOidCanal(dtoe.getCanal());
            dtoeT.setOidMarca(dtoe.getMarca());
            dtoeT.setOidPeriodo(dtoe.getPeriodo());
            dtoeT.setOidPais(dtoe.getOidPais());
            Periodo periodo = daoCliePrem.obtenerPeriodo(dtoeT);
    
            evaluadorDeMetas.evaluarMetasParaUnPeriodo(periodo);
    
            //jrivas 18/1/2005
            //INC-44
            //DTOOIDs dtoOIDsCon = daoGerentes.obtenerConcursosPremiacion(dtoe);
            DTOOIDs dtoOIDsCon;
            
            DTOOIDs dtoOIDsGer = daoGerentes.obtenerGerentesPremiacion(dtoe);
            Long[] oidsGerente = dtoOIDsGer.getOids();
            Periodo periodo1 = null;
            ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
            DatosPersonales datosPersonales = null;
    
            UtilidadesLog.debug("oidsGerente: " + oidsGerente);
    
            for (int pos = 0; oidsGerente.length > pos; pos++) {
            
                UtilidadesLog.debug("Gerente en ganadora: " + oidsGerente[pos]);
                
                clientePremiacion = new ClientePremiacion();
                clientePremiacion.setOidPais(dtoe.getOidPais());
                clientePremiacion.setOidMarca(dtoe.getMarca());
                clientePremiacion.setOidCanal(dtoe.getCanal());
                clientePremiacion.setOidCliente(oidsGerente[pos]);
                
                periodo1 = new Periodo();
                periodo1.setOidPeriodo(dtoe.getPeriodo());
                clientePremiacion.setPeriodo(periodo1);
                // vbongiov inc 20831
                clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByPrimaryKey(oidsGerente[pos]);
                
                datosPersonales = new DatosPersonales();
                datosPersonales.setNombre1(clienteDatosBasicosLocal.getVal_nom1());
                datosPersonales.setNombre2(clienteDatosBasicosLocal.getVal_nom2());
                datosPersonales.setApellido1(clienteDatosBasicosLocal.getVal_ape1());
                datosPersonales.setApellido2(clienteDatosBasicosLocal.getVal_ape2());
                datosPersonales.setCodCliente(clienteDatosBasicosLocal.getCod_clie());
                
                clientePremiacion.setDatosPersonales(datosPersonales);
    
                daoGerentes.rellenarClientePremiacionGerentes(clientePremiacion);
    
                daoCliePrem.obtenerAsistenciaCursos( clientePremiacion ); 
                
                //jrivas 18/1/2005
                //INC-44
                dtoOIDsCon = daoGerentes.obtenerConcursosPremiacion(dtoe, oidsGerente[pos]);            
                
                this.premiar(clientePremiacion, dtoOIDsCon, null);
            }
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("MONPremiacionBean.premiarGerentes(DTOFACProcesoCierre dtoe):Salida");
    }    
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/01/2007
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500001077
     */
    public ArrayList determinarGanadorasRecomendacionConsultoraCalculo(Long pais, Periodo periodo, Long cliente) throws MareException {
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraCalculo(Long pais, Periodo periodo, Long cliente):Entrada");

        DAOClientePremiacionConcurso daoCliente = new DAOClientePremiacionConcurso();
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        ClientePremiacionRecomendado cliePremReco = null;
        ClientePremiacionConcurso cliePremConcu = null;
        Concurso concurso = null;

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Obtenemos recomnedantes.");

        ArrayList clientesPremiacion = daoCliente.getRecomendantesCalculo(periodo.getOidPeriodo(), cliente);
        
        ArrayList clientesPremiacionRecomendado = new ArrayList();
        ArrayList premiosEscogidos = new ArrayList();
        GanadorasLocal ganadoras = null;

        try {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("clientesPremiacion: " + clientesPremiacion);

            //genero Long[] para setear DTOOIDs
            if (clientesPremiacion != null) {
                for (int index = 0; clientesPremiacion.size() > index; index++) {
                    ClientePremiacion clientePremiacion = (ClientePremiacion) clientesPremiacion.get(index);
                                    
                    //obtengo los clientespremiacionconcurso de dicho clientePremiacion
                    HashMap clientesPremiacionConcurso = clientePremiacion.getClientesPremiacionConcurso();

                    //obtengo un Array de Longs de oidsConcurso
                    if (clientesPremiacionConcurso != null) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("clientesPremiacionConcurso " + clientesPremiacionConcurso.values().size());

                        Iterator itCliePremConcu = clientesPremiacionConcurso.values().iterator();
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("itCliePremConcu " + itCliePremConcu);

                        while (itCliePremConcu.hasNext()) {
                            cliePremConcu = clientePremiacion.getClientePremiacionConcurso(((ClientePremiacionConcurso) itCliePremConcu.next()).getOidConcurso());
                            //cliePremConcu = (ClientePremiacionConcurso) itCliePremConcu.next();
                            concurso = despacharPremiosHelper.obtenerConcurso(cliePremConcu.getOidConcurso());
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente(): " + concurso.getRecomendacionEfectivaGerente());

                            if (concurso.getRecomendacionEfectivaGerente()) {
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente() true ");
                                crearWorkSpace(reglasDeterminarGanadoraRecomendacion);
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("Antes de insertar Concurso: " + concurso);
                                insertarTipoMontoEnMotor(concurso);

                                //jrivas 19/8/2005
                                //INC 20636 faltaba poner el concurso.
                                insertarObjetoEnMotor(concurso);

                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("Antes de insertar cliePremConcu: " + cliePremConcu);
                                  
                                insertarClientePremiacionEnMotor(cliePremConcu);
                                
                                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                                //insertarPedidosRecomendante(cliePremConcu);
                                
                                insertarPedidosRecomendados(cliePremConcu);

                                Iterator u = objetosDelMotor.iterator();

                                while (u.hasNext()) {
                                   UtilidadesLog.debug("Objetos :  " + u.next());
                                }

                                arrancarMotorDeReglas();

                                //jrivas 25/8/2005
                                //inc 20713
                                cliePremConcu.calcularTotalPedidosRecomendados();

                                UtilidadesLog.debug("Obtenemos recomnedados.");
                                clientesPremiacionRecomendado = cliePremConcu.getRecomendados();

                                if (clientesPremiacionRecomendado != null) {
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("clientesPremiacionRecomendado " + clientesPremiacionRecomendado.size());

                                    for (int index2 = 0; clientesPremiacionRecomendado.size() > index2; index2++) {
                                        cliePremReco = (ClientePremiacionRecomendado) clientesPremiacionRecomendado.get(index2);
                                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                          UtilidadesLog.debug("cliePremReco.getPremioElegido(): " + cliePremReco.getPremioElegido());
                                          UtilidadesLog.debug("cliePremReco.getOidClienteRecomendado(): " + cliePremReco.getOidClienteRecomendado());
                                        }  
                                        
                                        // No se suman a las recomendaciones efectivas la recomendacion de los recomendados con cupon
                                        // para que no sean tenidas en cuenta para sacar el flag de recomendacion efectiva del recomendado
                                        if (!((cliePremReco.getPremioElegido() != null) && (cliePremReco.getPremioElegido().getNivel() != null) &&
                                                    (cliePremReco.getPremioElegido().getNivel().getOidNivel() != null))) {

                                            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                                            //Calculo de Pedido Recomendante
                                            Iterator it = cliePremConcu.getPedidosRecomendacion().iterator();
                                            while (it.hasNext()) {
                                                PedidoRecomendacion ped = (PedidoRecomendacion) it.next();
                                                if ((ped.getMontoPedido().doubleValue() >= concurso.getMontoMinimoPedido().doubleValue()) &&
                                                    (ped.getUnidadesPedido().doubleValue() >= concurso.getUnidadesMinimasPedido().doubleValue())) {
                                                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                                      UtilidadesLog.debug(" PROCESOSOSO!!!!");
                                                      UtilidadesLog.debug("ped.getPeriodo(): " + ped.getPeriodo().getOidPeriodo());
                                                      UtilidadesLog.debug("cliePremReco.getPeriodoFinVinculo(): " + cliePremReco.getPeriodoFinVinculo().getOidPeriodo());
                                                      UtilidadesLog.debug("cliePremReco.getPeriodoInicioVinculo(): " + cliePremReco.getPeriodoInicioVinculo().getOidPeriodo());
                                                    }  
                                                    
                                                    if (!ped.getPeriodo().mayorQue(cliePremReco.getPeriodoFinVinculo()) &&
                                                       (!ped.getPeriodo().menorQue(cliePremReco.getPeriodoInicioVinculo()))) {
                                                        UtilidadesLog.debug(" PROCESOSOSO!!!! 2");
                                                        cliePremConcu.setTotalPedidosRecomendante(
                                                                             new Long(cliePremConcu.getTotalPedidosRecomendante().longValue() + 1));
                                                    } else {
                                                        UtilidadesLog.debug("NO PROCESOSOSO 2  2 2 2!!!!");
                                                    }
                                                } else {
                                                    UtilidadesLog.debug("NO PROCESOSOSO!!!!");
                                                }
                                            }

                                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
                                              UtilidadesLog.debug("cliePremConcu.getTotalPedidosRecomendante(): " +
                                                               cliePremConcu.getTotalPedidosRecomendante());
    
                                              UtilidadesLog.debug("concurso.getNumeroMinimoPedido(): " + concurso.getNumeroMinimoPedido());
                                              UtilidadesLog.debug("cliePremReco.getTotalPedidosRecomendada(): " + cliePremReco.getTotalPedidosRecomendada());
                                              UtilidadesLog.debug("concurso.getNumeroMinimoPedidoRecomendada(): " +
                                                               concurso.getNumeroMinimoPedidoRecomendada());
                                            }                   
    
                                            if ((cliePremConcu.getTotalPedidosRecomendante().intValue() >= concurso.getNumeroMinimoPedido().intValue()) &&
                                                    (cliePremReco.getTotalPedidosRecomendada().intValue() >= concurso.getNumeroMinimoPedidoRecomendada()
                                                                                                                         .intValue())) {
                                                cliePremConcu.setRecomendacionesEfectivas(new Long(cliePremConcu.getRecomendacionesEfectivas().longValue() +
                                                                                                   1));
                                                                                                   
                                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                                                   
                                                   UtilidadesLog.debug("cliePremConcu.getRecomendacionesEfectivas: " +
                                                                   cliePremConcu.getRecomendacionesEfectivas());
                                                                   
                                                cliePremReco.setIndRecomendacionEfectiva(true);                                            
                                            }
                                            //jrivas 8/12/2006 V-INC-021
                                            cliePremConcu.setTotalPedidosRecomendante(new Long(0));
                                        }
                                    }
                                }
                            } else {
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("concurso.getRecomendacionEfectivaGerente() false: " + cliePremConcu.getRecomendados().size());
                                cliePremConcu.setRecomendacionesEfectivas(Long.valueOf(Integer.toString(cliePremConcu.getRecomendados().size())));
                            }

                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("Numero recomendacion efectiva: " + cliePremConcu.getRecomendacionesEfectivas());
                        }
                    }
                }
            }
            
            UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraCalculo(Long pais, Periodo periodo, Long cliente):Salida");
            return clientesPremiacion;
            
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e);
        }
    }


    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }

    //jrivas 20080535
    public void determinarGanadorasRecomendacionConsultoraCierreZona(DTOFACProcesoCierre dtoin) throws MareException {
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraCierreZona(DTOFACProcesoCierre dtoin):Entrada");
        this.determinarGanadorasRecomendacionConsultora(dtoin.getPeriodo(), ConstantesFAC.TIPO_CIERRE_ZONA, dtoin.getZona(), null);
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraCierreZona(DTOFACProcesoCierre dtoin):Salida");        
    }

    //jrivas 20080535
    public DTOEstatusSolicitud determinarGanadorasRecomendacionConsultoraMonitor(DTOSolicitudValidacion solicitud) throws MareException {
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraMonitor(DTOSolicitudValidacion solicitud):Entrada");
        this.determinarGanadorasRecomendacionConsultora(solicitud.getOidPeriodo(), "C", null, solicitud.getOidCliente());
        DTOEstatusSolicitud dtoes = new DTOEstatusSolicitud();
        dtoes.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPremiacionBean.determinarGanadorasRecomendacionConsultoraMonitor(DTOSolicitudValidacion solicitud):Salida");
        return dtoes;
    }
    
    //jrivas 20070439
    private ArrayList agruparPremiosArtculos(ArrayList premios) {
        UtilidadesLog.info("MONPremiacionBean.agruparPremiosArtculos():Entrada");
        ArrayList aux = new ArrayList();
        HashMap premiosArticulo = new HashMap();
        if (premios != null) {
            Iterator it = premios.iterator();
            while (it.hasNext()) {
                Premio premioElegido = (Premio) it.next();
                if (ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premioElegido.getTipoPremio()) &&
                        premioElegido.getActualizarGanadora()) {
                    //Busco el Premio, si ya esta lo sumo, sino lo agrego.
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Premio Articulo " + premioElegido.getOidPremio());
                    
                    // vbongiov -- SiCC 20091070 --30/07/2009
                    Long numPremio = ((PremioArticuloLote)premioElegido).getNumeroPremio();
                    
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Nivel " + premioElegido.getNivel().getOidNivel());
                      UtilidadesLog.debug("Nro Premio " + numPremio);
                    }  
                    
                    if (premiosArticulo.containsKey((premioElegido.getNivel().getOidNivel()).toString() + numPremio.toString())) {
                    
                        PremioArticuloLote premArtiLote = (PremioArticuloLote) premiosArticulo.get(
                                                            (premioElegido.getNivel().getOidNivel()).toString() + numPremio.toString());
                                                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                            
                          UtilidadesLog.debug("Premio premArtiLote " + premArtiLote.getOidPremio()); 
                          
                        premArtiLote.setUnidades(new BigDecimal(premArtiLote.getUnidades().longValue() + premioElegido.getUnidades().longValue()));
                        premArtiLote.getPremio().setNumeroUnidades(new Long(premArtiLote.getPremio().getNumeroUnidades().longValue() + ((PremioArticuloLote)premioElegido).getPremio().getNumeroUnidades().longValue()));
                        premArtiLote.getNivel().setCantidadFijaPuntos(new Double(premArtiLote.getNivel().getCantidadFijaPuntos().doubleValue() + premioElegido.getNivel().getCantidadFijaPuntos().doubleValue()));
                        premArtiLote.getNivel().setCantidadInicialPuntos(new Double(premArtiLote.getNivel().getCantidadInicialPuntos().doubleValue() + premioElegido.getNivel().getCantidadInicialPuntos().doubleValue()));
                        
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("SUMO Premio premArtiLote Unid: " + premArtiLote.getUnidades() + " Premi-uni " + premArtiLote.getPremio().getNumeroUnidades() +
                                                            " CantiF " + premArtiLote.getNivel().getCantidadFijaPuntos() +
                                                            " CantiI" + premArtiLote.getNivel().getCantidadInicialPuntos());
                        premiosArticulo.put((premioElegido.getNivel().getOidNivel()).toString() + numPremio.toString(), premArtiLote);
                        
                    } else {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("NUEVO Premio Ejlegido Unid: " + premioElegido.getUnidades() + " Premi-uni " + ((PremioArticuloLote)premioElegido).getPremio().getNumeroUnidades() +
                                                            " CantiF " + premioElegido.getNivel().getCantidadFijaPuntos() +
                                                            " CantiI" + premioElegido.getNivel().getCantidadInicialPuntos());
                       premiosArticulo.put((premioElegido.getNivel().getOidNivel()).toString() + numPremio.toString(), premioElegido);
                    }
                } else {
                    //Si no es Articulo, entonces no se agrupa
                    aux.add(premioElegido);
                }
            }
            aux.addAll(premiosArticulo.values());
            UtilidadesLog.info("MONPremiacionBean.agruparPremiosArtculos():Salida 0");
            return aux;
        } else {
            UtilidadesLog.info("MONPremiacionBean.agruparPremiosArtculos():Salida 1");
            return premios;
        }
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
      }   
      
    private PremiosElegidosLocalHome getPremiosElegidosLocalHome() {
            return new PremiosElegidosLocalHome();
    }
    
    private GanadorasLocalHome getGanadorasLocalHome() {
            return new GanadorasLocalHome();
    }

    private DespachoPremiosLocalHome getDespachoPremiosLocalHome() {
            return new DespachoPremiosLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    private ClienteRecomendadoLocalHome getClienteRecomendadoLocalHome() {
            return new ClienteRecomendadoLocalHome();
    }
    

      

  
}
