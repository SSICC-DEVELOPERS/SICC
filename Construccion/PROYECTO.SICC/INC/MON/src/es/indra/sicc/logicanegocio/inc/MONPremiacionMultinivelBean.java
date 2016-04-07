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
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.rules.RuleService;

import es.indra.sicc.dtos.inc.DTODatosMensajeMultinivel;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendadoMultinivelLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoMultinivelLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.rules.StatelessRuleSession;


import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:        Sicc Belcorp
 * Modulo:        INC
 * Fecha:                01/06/2005
 * @version        1.0
 * @autor                enozigli
 */
public class MONPremiacionMultinivelBean
        implements SessionBean {
    private ArrayList objetosDelMotor;
    private StatelessRuleSession workSpace = null;
    SessionContext ctx;
    private String reglasPuntuacion = "variable_2";

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: un SessionContext
     * @Retorna: void
     * @Descripción: setea el contexto de sesion del mon
     */
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 07/06/2005
     * @Recibe: un Long oidPeriodo
     * @Retorna: void
     */
    public void determinarGanadoraMultinivel(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONPremiacionMultinivelBean.determinarGanadoraMultinivel(Long oidPeriodo):Entrada");
        UtilidadesLog.debug("entra a determinarGanadoraMultinivel() con oidPeriodo:" + oidPeriodo);

        DAOConcursos daoConcu = new DAOConcursos();
        DAOMultinivel daoMulti = new DAOMultinivel();
        FactoriaConcurso factConcursos = FactoriaConcurso.getFactoriaConcurso();
        ArrayList concursos = factConcursos.getConcursosMultinivel(oidPeriodo);
        Iterator itConcursosMulti = concursos.iterator();
        Periodo periodoGanador = null;
        CandidataGanadoraLocalHome cglh = this.getCandidataGanadoraLocalHome();
        CandidataGanadoraLocal candidataGanadora;
        UtilidadesLog.debug("Concursos Multinivel: " + concursos.size());

        while (itConcursosMulti.hasNext()) { //BELC300018974

            Concurso concurso = (Concurso) itConcursosMulti.next();
            periodoGanador = daoConcu.obtenerPeriodoAntesDe(oidPeriodo,
                                                            new Long((concurso.getPeriodosEsperaSobreCalculo() != null)
                                                                     ? concurso.getPeriodosEsperaSobreCalculo().longValue() : 0)); //BELC300018974
            UtilidadesLog.debug("periodoGanador: " + periodoGanador.getOidPeriodo());

            if (periodoGanador != null) {
                this.recuperarClientesRecomendados(periodoGanador, concursos);

                ArrayList arrMadres = daoMulti.getMadres(concurso, periodoGanador); //BELC300018976
                Iterator itMadres = arrMadres.iterator();
                UtilidadesLog.debug("arrMadres.size() " + arrMadres.size());

                while (itMadres.hasNext()) { //BELC300018976

                    Madre madre = (Madre) itMadres.next(); //BELC300018976
                    boolean valido = false;
                    Long cantidadMadreHijas = new Long(madre.getCantidadMadre().longValue() + madre.getCantidadHijas().longValue());
                    UtilidadesLog.debug("cantidadMadreHijas " + cantidadMadreHijas);

                    if (concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_MONTO)) {
                        if ( (madre.getCantidadMadre().longValue() >= concurso.getMontoMinimoMadre().longValue()) &&
                                (madre.getCantidadHijas().longValue() >= concurso.getMontoMinimoHija().longValue()) &&
                                (cantidadMadreHijas.longValue() >= concurso.getMontoMinimoRed().longValue()) ) {
                            valido = true;
                        } //BELC300019006 
                    } else if (concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_UNIDADES)) {
                        if ((madre.getCantidadMadre().longValue() >= concurso.getUnidadesMinimasMadre().longValue()) &&
                                (madre.getCantidadHijas().longValue() >= concurso.getUnidadesMinimasHija().longValue()) &&
                                (cantidadMadreHijas.longValue() >= concurso.getUnidadesMinimasRed().longValue()) ) {
                            valido = true;
                        } //BELC300019006 
                    }

                    UtilidadesLog.debug("valido uno " + valido);

                    if (valido == true) {
                        Iterator itHijas = madre.getHijas().iterator();
                        int cantPedHijas = 0;

                        while (itHijas.hasNext()) {
                            Hijas hija = (Hijas) itHijas.next();
                            cantPedHijas = cantPedHijas + ((hija.getPedidos() != null) ? hija.getPedidos().size() : 0);
                        }

                        int cantPedMadresHijas = ((madre.getPedidos() != null) ? madre.getPedidos().size() : 0) + cantPedHijas;

                        valido = false;

                        if ((madre.getPedidos().size() >= concurso.getNumPedidoMinimoMadre().intValue()) &&
                                (cantPedHijas >= concurso.getNumPedidoMinimoHija().intValue()) &&
                                (cantPedMadresHijas >= concurso.getNumPedidoMinimoRed().intValue())) {
                            valido = true;
                        } ////BELC300019006
                    }

                    UtilidadesLog.debug("valido dos " + valido);

                    if (valido == true) {
                        Double puntos = this.calcularPuntajeCliente(madre, concurso); //BELC300019269            
                        Boolean pagoAtiempo = this.calcularPagoATiempo(concurso, madre.getOidCliente());
                        UtilidadesLog.debug("pagoAtiempo " + pagoAtiempo);

                        if ((pagoAtiempo != null) && (pagoAtiempo.equals(new Boolean(true)))) {
                            try {
                                CuentaCorrientePuntosLocalHome cclh = this.getCuentaCorrientePuntosLocalHome();
                                Date fechaActual = new Date(System.currentTimeMillis());
                                int puntosExigidos = 0;
                                Iterator itPedidos = madre.getPedidos().iterator();

                                while (itPedidos.hasNext()) {
                                    PedidoMultinivel pedido = (PedidoMultinivel) itPedidos.next();
                                    puntosExigidos = puntosExigidos +
                                                     ((pedido.getNumPuntosExigidos() != null) ? pedido.getNumPuntosExigidos().intValue() : 0);
                                }

                                UtilidadesLog.debug("puntosExigidos " + puntosExigidos);

                                CuentaCorrientePuntosLocal cuentaCorrientePuntos = cclh.create(new Integer(puntos.intValue()),
                                                                                               new Integer(puntosExigidos), fechaActual,
                                                                                               madre.getOidConcurso(), madre.getOidCliente(),
                                                                                               periodoGanador.getOidPeriodo(),
                                                                                               ConstantesINC.TIPO_MOVIMIENTO_ABONO);
                                // Creamos o actualizamos Candidata Ganadora
                                // BELC300019011                                     
                                UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + madre.getOidConcurso());
                                UtilidadesLog.debug("CLIE_OID_CLIE:  " + madre.getOidCliente());
                                UtilidadesLog.debug("periodoGanador.getOidPeriodo():  " + periodoGanador.getOidPeriodo()); 
                                
                                try {
                                    candidataGanadora = cglh.findByUK(madre.getOidConcurso(),
                                                                                                madre.getOidCliente(),
                                                                                                periodoGanador.getOidPeriodo());
                                    UtilidadesLog.debug("Candidata a ganadora: la encontré ");

                                } catch (NoResultException fe) {
                                
                                    UtilidadesLog.debug(fe);
                                    UtilidadesLog.debug("Candidata a ganadora: no la encontré ");
                                    try {
                                    
                                        UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + Boolean.FALSE);
                                        UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + madre.getOidConcurso());
                                        UtilidadesLog.debug("CLIE_OID_CLIE:  " + madre.getOidCliente());
                                        UtilidadesLog.debug("periodoGanador.getOidPeriodo():  " + periodoGanador.getOidPeriodo()); 
                        
                                        Boolean metasSuperadas = Boolean.FALSE;
                                        Boolean requisitosPremiacionSuperados = Boolean.FALSE; 
                                        candidataGanadora = cglh.create(metasSuperadas, 
                                                                         requisitosPremiacionSuperados, 
                                                                         periodoGanador.getOidPeriodo(),
                                                                         madre.getOidConcurso(), 
                                                                         madre.getOidCliente());            
                                     } catch (PersistenceException ce) {
                                        UtilidadesLog.error("ERROR ", ce);
                                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                     }
                                } catch (PersistenceException ce) {
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }

                                //BELC300019008                
                                UtilidadesLog.debug("concurso.getComunicacionAutomatica() " + concurso.getComunicacionAutomatica());

                                if (concurso.getComunicacionAutomatica()) { //BELC300018971

                                    DTODatosMensajeMultinivel dtoDmM = daoMulti.recuperarDatosMensaje(madre.getOidCliente(), concurso);
                                    GestorMensajesTransformar gestMen = new GestorMensajesTransformar();
                                    gestMen.crearMensajeGanadoraMultinivel(dtoDmM, concurso, new Long(puntosExigidos));
                                }
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                ctx.setRollbackOnly();
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        } else {
                            UtilidadesLog.debug("determinarGanadoraMultinivel - No paso calcularPagoATiempo.");
                        }
                    } else {
                        UtilidadesLog.debug("determinarGanadoraMultinivel - No paso las validaciones.");
                    }
                }
            } else {
                UtilidadesLog.debug("determinarGanadoraMultinivel - No se encontró periodoGanador. No se indica MareException en el DMCO.");
            }
        }

        UtilidadesLog.info("MONPremiacionMultinivelBean.determinarGanadoraMultinivel(Long oidPeriodo):Salida");
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: un Concurso, (Long oidCliente (Incidencia 18790))
     * @Retorna: un Boolean
     * @Descripción: metodo que chequea si no quedan movimientos de cuenta corriente
     *               pendientes y de ser asi devuelve Verdadero y sino Falso
     */
    private Boolean calcularPagoATiempo(Concurso concurso, Long oidCliente)
            throws MareException {
        UtilidadesLog.info("MONPremiacionMultinivelBean.calcularPagoATiempo(Concurso concurso, Long oidCliente):Entrada");
        UtilidadesLog.debug("Entra a calcularPagoATiempo - Concurso:" + concurso);

        DAOMultinivel daoMult = new DAOMultinivel();
        RecordSet rs = null;
        UtilidadesLog.debug("Sale de calcularPagoATiempo - Boolean:" + Boolean.TRUE);
        UtilidadesLog.info("MONPremiacionMultinivelBean.calcularPagoATiempo(Concurso concurso, Long oidCliente):Salida");
        return new Boolean(daoMult.recuperarRegistrosMovCCC(concurso, oidCliente)); //incidencia 18790
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: Madre madre, Concurso concurso
     * @Retorna: un Double
     * @Descripción: calcula el puntaje del cliente.
     */
    private Double calcularPuntajeCliente(Madre madre, Concurso concurso)
            throws MareException {
        UtilidadesLog.info("MONPremiacionMultinivelBean.calcularPuntajeCliente(Madre madre, Concurso concurso):Entrada");
        UtilidadesLog.debug("Entra a calcularPuntajeCliente - Madre:" + madre + " Concurso:" + concurso);

        double puntos = 0;

        //BELC300018839
        double cantMadre = ((madre.getCantidadMadre() != null) ? madre.getCantidadMadre() : new Long(0)).doubleValue();
        double cantHijas = ((madre.getCantidadHijas() != null) ? madre.getCantidadHijas() : new Long(0)).doubleValue();
        double factorConversion = ((concurso.getFactorConversion() != null) ? concurso.getFactorConversion().doubleValue() : 0);
        double puntosAsignar = ((concurso.getPuntosAsignar() != null) ? concurso.getPuntosAsignar().doubleValue() : 0);
        double porcentajeSobreVenta = ((concurso.getPorcentajeSobreVenta() != null) ? concurso.getPorcentajeSobreVenta().doubleValue() : 0); //BELC300018836

        if (concurso.getCalculoPremio().equals(ConstantesINC.TIPO_CALCULO_MULTINIVEL_RED)) { // BELC300018836

            if ((factorConversion != 0) && (puntosAsignar != 0)) {
                puntos = (cantMadre + cantHijas) / (factorConversion * puntosAsignar);
            }
        }

        if (concurso.getCalculoPremio().equals(ConstantesINC.TIPO_CALCULO_MULTINIVEL_HIJAS)) { //BELC300018836    

            if ((factorConversion != 0) && (puntosAsignar != 0)) {
                puntos = cantHijas / (factorConversion * puntosAsignar);
            }
        }

        if (concurso.getPorcentajeSobreVenta() != null) { //BELC300018836
            puntos = (puntos * porcentajeSobreVenta) / 100;
        }

        UtilidadesLog.debug("Sale de calcularPuntajeCliente - puntos:" + puntos);
        UtilidadesLog.info("MONPremiacionMultinivelBean.calcularPuntajeCliente(Madre madre, Concurso concurso):Salida");
        return new Double(puntos);
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: void
     * @Retorna: void
     * @Descripción: arranca el motor de reglas.
     */
    private void arrancarMotorDeReglas() throws MareException {
        UtilidadesLog.info("MONPremiacionMultinivelBean.arrancarMotorDeReglas():Entrada");
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
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONPremiacionMultinivelBean.arrancarMotorDeReglas():Salida");
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: String reglasAplicables
     * @Retorna: void
     * @Descripción: crea el workspace
     */
    private void crearWorkSpace(String reglasAplicables)
            throws MareException {
            UtilidadesLog.info("MONPremiacionMultinivelBean.crearWorkSpace(String reglasAplicables):Entrada");
        try {
            RuleService ruleService = (RuleService) MareMii.getService(new MareTopic(MareMii.SERVICE_RULE));
            objetosDelMotor = new ArrayList();
            workSpace = (StatelessRuleSession) ruleService.createRuleSession(reglasAplicables, null, 1);
        } catch (MareMiiServiceNotFoundException mm) {
            UtilidadesLog.error("ERROR ", mm);
            throw new MareException(mm, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONPremiacionMultinivelBean.crearWorkSpace(String reglasAplicables):Salida");
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 01/06/2005
     * @Recibe: Object
     * @Retorna: void
     * @Descripción: agrega un objeto al motor de reglas.
     */
    private void insertarObjetoEnMotor(Object objeto) throws MareException {
        UtilidadesLog.debug("insertarObjetoEnMotor:" + objeto);
        objetosDelMotor.add(objeto);
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 02/06/2005
     * @Recibe: Periodo periodoGanador, ArrayList concursos
     * @Retorna: void
     * @Descripción: Toma las posiciones de las solicitudes correspondientes a los
     *               clientes recomendados de los concursos recibidos por parametro
     *               para el periodo recibido por parametro y las introduce en el
     *               motor de reglas y lo arranca, luego si se dan ciertas condiciones
     *               inserta un registro para el cliente y el periodo en la tabla
     *               PedidoRecomendadoMultinivel.
     *
     */
    private void recuperarClientesRecomendados(Periodo periodoGanador, ArrayList concursos) throws MareException {
        UtilidadesLog.info("MONPremiacionMultinivelBean.recuperarClientesRecomendados(Periodo periodoGanador, ArrayList concursos):Entrada");
        UtilidadesLog.debug("Entra a recuperarClientesRecomendados - Periodo:" + periodoGanador + " ArrayList:" + concursos);
        ClienteRecomendanteMultinivelLocalHome clienteRecomendanteMultinivelHome;
        ClienteRecomendanteMultinivelLocal clienteRecomendanteMultinivel;
        ClienteRecomendadoMultinivelLocalHome clienteRecomendadoMultinivelHome;
        ClienteRecomendadoMultinivelLocal clienteRecomendadoMultinivel;
        DAOMultinivel daoMulti = new DAOMultinivel();
        DAOSolicitudes daoSolic = new DAOSolicitudes();
        DAOSolicitudActualizacion daoSolAct = new DAOSolicitudActualizacion();

        Iterator itConcursos = concursos.iterator();

        while (itConcursos.hasNext()) {
            Concurso concursoActual = (Concurso) itConcursos.next();

            DTOOIDs dtoOidsRecomendantes = daoMulti.getRecomendantesMultinivel(periodoGanador); //BELC300018879
            Long[] oidsRecomendantes = dtoOidsRecomendantes.getOids();

            for (int i = 0; i < oidsRecomendantes.length; i++) {
                Long oidRecomendante = oidsRecomendantes[i];

                //jrivas 4/7/2005
                //Inc 16978
                DTOOIDs dtoOidsRecomendados = daoMulti.getRecomendadosMultinivel(oidRecomendante, periodoGanador.getOidPeriodo());

                if ((dtoOidsRecomendados != null) && (dtoOidsRecomendados.getOids() != null)) {
                    ArrayList arrSolicMulti = daoMulti.getSolicitudesMultinivel(periodoGanador, dtoOidsRecomendados); //BELC300018880

                    //ArrayList de DTOSolicitudValidacion INC. 18816
                    Iterator itArrSolicMulti = arrSolicMulti.iterator();

                    while (itArrSolicMulti.hasNext()) {
                        //ArrayList de DTOSolicitudValidacion INC. 18816
                        DTOSolicitudValidacion dtoSoliVal = (DTOSolicitudValidacion) itArrSolicMulti.next();
                        Solicitud solicitud = daoSolic.obtenerSolicitud(dtoSoliVal);

                        for (int j = 0; j < solicitud.getPosiciones().length; j++) {
                            this.crearWorkSpace(reglasPuntuacion); //BELC300018944
                            this.insertarObjetoEnMotor(solicitud.getPosiciones()[j]); //BELC300018944
                            this.insertarObjetoEnMotor(concursoActual); //BELC300018944
                            this.arrancarMotorDeReglas(); //BELC300018944
                        } //for posiciones

                        if (((concursoActual.getIndProductosExigidos() == false) ||
                                (solicitud.getSolicitudConcurso(concursoActual.getOidConcurso()).getIndExigenciasCumplidas()) ||
                                (concursoActual.exigenciasCumplidas(solicitud.getSolicitudConcurso(concursoActual.getOidConcurso()), solicitud.getPeriodo()))) &&
                                (solicitud.getSolicitudConcurso(concursoActual.getOidConcurso()).getMontoAcumulado().compareTo(concursoActual.getMontoMinimoPedido()) >= 0) &&
                                (solicitud.getSolicitudConcurso(concursoActual.getOidConcurso()).getUnidadesAcumuladas().compareTo(concursoActual.getUnidadesMinimasPedido()) >= 0)) {

                                daoSolAct.actualizarPedidoRecomendadoMultinivel(solicitud, concursoActual, periodoGanador);
                        }
                    } //while solicitudes
                }
            } //for recomendantes
        } //while concursos

        UtilidadesLog.info("MONPremiacionMultinivelBean.recuperarClientesRecomendados(Periodo periodoGanador, ArrayList concursos):Salida");
    }
    
    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    


}
