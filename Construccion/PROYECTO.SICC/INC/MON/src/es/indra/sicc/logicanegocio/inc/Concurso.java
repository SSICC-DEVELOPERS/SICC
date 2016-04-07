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
 *
 * @author: Dante CastiglionevalidarProductoExcluido
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Concurso extends ObjetoImprimible implements Serializable {
    private static final boolean debug = true;
    private Long oidConcurso;
    private String numeroConcurso;
    private boolean participacionParticipantesCompleta;
    private TipificacionCliente[] tipificacionesClientesParticipantes;
    private Periodo periodoDesde;
    private Periodo periodoHasta;
    private EstatusVentaConsultoras[] estatusVentaConsultoras;
    private HashMap estatusFuturoClientes;
    private ArrayList cronograma;
    private Long oidTipoExigencia;
    private RequisitosProgramaNuevas[] requisitosProgramaNuevas;
    private ListaProductos productosExigidos;
    private ListaProductos productosBonificados;
    private ListaProductos productosExcluidos;
    private ListaProductos productosValidos;
    private boolean indFaltantesAnunciados;
    private Double puntosAsignar;
    private Long tipoVenta;
    private Double factorConversion;
    private boolean indProductosExigidos;
    private boolean indProductosBonificados;
    private boolean indProductosValidosCompletos;
    private boolean indProductosExcluidos;
    private ParametrosNivelPremiacion[] parametrosNivelPremiacion;
    private Long baseCalculo;
    private boolean multiNivel;
    private Long dirigidoA;
    private boolean programaNuevas;
    private Periodo periodoDeDespacho;
    private AmbitoGeografico[] ambitosGeograficos;
    private Long oidPais;
    private Long oidMarca;
    private Long oidCanal;
    private Long[] oidAccesos;
    private Periodo ultimoPeridoEvaluar;
    private Periodo ultimoPeriodoPremiacion;
    private boolean indAmbitoGeograficoCompleto;
    private boolean indAnulacion;
    private boolean indDevolucion;

    //Agregado por jquiroga - 26/05/2005
    private boolean puntajeAcumulativo;
    private Long tipoPremiacion;
    private boolean accesoNivelSuperior;
    private boolean nivelesRotatorios;
    private Integer numeroRotaciones;
    private Boolean indPeriodoDespachoExigido;
    private Periodo periodoDespacho;
    private Long numeroPeriodos;

    //jrivas 18/8/2005
    //inc 20450
    //private Periodo periodoDespachoDespuesObtencion;
    private boolean pedidoEnPeriodo;
    private BigDecimal montoMinimoPedido;
    private ArrayList productosExigidosPremiacion;
    private BigDecimal montoMinimoConcurso;
    private Double cuotaMinimaIngreso;
    private Long numeroPedidos;
    private boolean indAsistenciaCursos;
    private ArrayList tipoCursosExigidos;
    private boolean indPagoATiempo;
    private Long diasGracia;
    private boolean premiosAcumulativosNiveles;
    private boolean comunicacionAutomatica;
    private Long numeroMinimoPedido;
    private Long numeroMinimoPedidoRecomendada;
    private boolean comunicacionEnObtencionPuntos;
    private ArrayList montosRecomendada; //Arraylist de TipoMonto

    //Agregado por Sergio Platas - 09/05/2005
    private ListaProductos productosCalificar;
    private ListaProductos productosExcluirCalificar;
    private Long unidadesMinimasPedido;

    //Agregado por Damasia Maneiro- 06/06/2005
    private boolean faseCalificacion;

    //Agregado por enozigli 6/6/05 inc. BELC300018836
    private Long calculoPremio;

    //Agregado por enozigli 9/6/05 inc.BELC300018974 
    //y esta en SICC-DMCO-INC-201-374-INC8.    
    private Integer periodosEsperaParaCalculo;
    private Integer periodosEsperaSobreCalculo;

    //Agregado por enozigli 8/6/05 inc.BELC300018836
    private BigDecimal porcentajeSobreVenta;

    //Agregado por enozigli 9/6/05 inc.BELC300019006
    private BigDecimal montoMinimoMadre;
    private BigDecimal montoMinimoHija;
    private BigDecimal montoMinimoRed;
    private Integer unidadesMinimasMadre;
    private Integer unidadesMinimasHija;
    private Integer unidadesMinimasRed;
    private Integer numPedidoMinimoMadre;
    private Integer numPedidoMinimoHija;
    private Integer numPedidoMinimoRed;

    //Agregado por splatas - 15/06/2005 - Inc.BELC300018548
    private boolean recomendacionEfectivaGerente;

    //Agregado por jrivas - 21/06/2005
    private Long formaCalculo;

    // Agregado por dmorello - 22/06/2005
    private HashMap variablesVentaConcursoRanking;

    //Agregado por Carlos Leal - 23/06/2005
    private Periodo periodoLimiteEsperaParaCalculo;
    private Long numPeriodosEsperaCalculo;
    private boolean indRanking;

    //Agregado jrivas 28/7/2005 inc 20276
    private boolean indActividad;
    private boolean indConstancia;

    //Agregado por Carlos Leal inc 20585
    private BigDecimal montoMinimoPedidoPremiacion;
  private Periodo periodoDesdeMultinivel;
  private Periodo periodoHastaMultinivel;
  
  private Periodo periodoDesdeNueva; 
  
    //INC-46 jrivas 28/3/2006
    private Long hastaNivelPremiacion; 
    
    //INC-114 jrivas 7/5/2006
    private Long tipoRanking;
   
   
    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
    private Periodo periodoInicialEvaluacion;
    private Periodo periodoFinalEvaluacion;
    private Long numeroPeriodosAEvaluar;
    
    // BELC300024320 - gPineda - 13/10/06
    private boolean comunicacionDespachoAutomatico;
    
    private Long nivelAgrupacionRanking;
    
    //jrivas 25/1/2007 Cambio Dupla Cyzone
    private boolean indDuplaCyzone;
    private TipificacionCliente[] tipificacionesClientesCalificacion;
  
    //jrivas SiCC 20070242  28/5/07
    private String nombreConcurso;
    
    // vbongiov -- Cambio 20080809 -- 7/04/2009
    private boolean indNoGeneraPunt;
    
    //jrivas 21/8/2008 20080580
    private boolean indGeneraPuntajeRecda;
    private Long concursoPuntajeRecda;
    private Double puntosAsignarConcuRedca;
    private Double factorConversionConcursoRedca;    
    
    // vbongiov -- Cambio 20090942 -- 28/07/2009
    private Long oidClasificacionConcurso;
    
    // vbongiov -- Cambio 20080811 -- 26/08/2009
     private boolean indSorteo;
     private Integer cantidadNumerosAOtorgar;     
     private String descProducto;
     
     // vbongiov -- Cambio 20090929 -- 18/09/2009
     private Long numPerioEspe;
     private Periodo periodoMaxi;
     private Long oidValidaDeuda;

     // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
     private String textoRanking;
     
    // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
    private boolean sinPremioPorDefecto;
    
    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    private Long indTipoEvaluacion;
     
    // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
    private Periodo periodoInicioDeDespacho;
    
    // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
    private Long indDespachoPremio;
    private Long numeroPeriodosVinculo;
    
    // sapaza -- PER-SiCC-2014-0753 -- 10/09/2014
    private String periodoProceso;
    
    // sapaza -- PER-SiCC-2015-0063 -- 16/02/2015
    private boolean indExigCampAnte;
        
    public Concurso() {
    }

    /**
     * Este método debe verificar si alguna de las tipificaciones que tiene el
     * cliente se encuentra dentro de la lista de tipificaciones del concurso
     * (tipificacionesClientesParticipantes).
     * Para ello se puede recorrer cada tipificacion del cliente y buscarla
     * dentro de la lista del concurso comparando por igualdad mediante método
     * equals provisto por la clase TipificacionCliente.
     * Con solo encontrar una tipificacion del cliente en las tipificaciones
     * del concurso, se deberá retornar true, caso contrario false.
     */

    /* Modificado por Sergio Platas - 13/05/2005
     * @CHANGELOG
     * --------------------------
     * 2005.04.06 DVJUIZ DT Se modifico la clase del parametro de entrada
     * "cliente" de Cliente a Participante.
     */
    public boolean getClienteParticipanteConcurso(Participante cliente) {
        UtilidadesLog.info("Concurso.getClienteParticipanteConcurso(" +
            "Participante cliente):Entrada " + cliente.getOidCliente());
            
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
          UtilidadesLog.debug("Concurso:" + this.oidConcurso);

        // no hay tipificaciones de clientes
        if ((this.tipificacionesClientesParticipantes == null) ||
                (this.tipificacionesClientesParticipantes.length == 0)) {
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
              UtilidadesLog.debug("*** tipificacionesClientesParticipantes: " +
                tipificacionesClientesParticipantes);

            UtilidadesLog.info("Concurso.getClienteParticipanteConcurso(" +
                "Participante cliente):Salida");

            return true;
        }

        // comparar si la tipificacion coincide
        TipificacionCliente[] tp = cliente.getTipificacionCliente();

        boolean cumplioClasificacion = false;
        for (int i = 0; i < this.tipificacionesClientesParticipantes.length;
                i++) {
            for (int j = 0; j < tp.length; j++) {
                if (this.tipificacionesClientesParticipantes[i].equals(tp[j])){
                    cumplioClasificacion = true;
                    
                    // coincide
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("*** Dentro del if: " + tp[j].getOidTipoCliente() + " - " + tp[j].getOidSubTipoCliente() + 
                                        " - " + tp[j].getOidTipoClasificacionCliente() + " - " + tp[j].getOidClasificacionCliente());

                    if(this.tipificacionesClientesParticipantes[i].isIndExclusion()) {
                        UtilidadesLog.debug(" rechazo por exclusion");
                        UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
                        return false;
                    }
                        
                    UtilidadesLog.info(
                        "Concurso.getClienteParticipanteConcurso" +
                        "(Participante cliente):Salida");
                }
            }
        }
        
        if(cumplioClasificacion)
            return true;
        
        // sapaza -- PER-SiCC-2013-0825 -- 30/07/2013
        boolean indTotalExclusiones = true;
        for (int i = 0; i < this.tipificacionesClientesParticipantes.length; i++) {
            if(!this.tipificacionesClientesParticipantes[i].isIndExclusion()) 
                indTotalExclusiones = false;
        }

        // no se encontro una tipificación que coincidiera 
        UtilidadesLog.info("Concurso.getClienteParticipanteConcurso(" +
            "Participante cliente):Salida");

        // sapaza -- PER-SiCC-2013-0825 -- 30/07/2013
        if(indTotalExclusiones)
            return true;
        else    
            return false;
    }

    /**
     * Indica si el cliente es valido efectuando la validacion
     * con el atributo Estatus Venta Consultoras
     * teniendo en cuenta el periodoCalculado
     */
/*    public boolean validaClienteConPeriodoCalculado(Solicitud sol) {
        UtilidadesLog.info("Concurso.validaClienteConPeriodoCalculado(S" +
            "olicitud sol):Entrada");

        if ((this.estatusVentaConsultoras == null) ||
                (this.estatusVentaConsultoras.length == 0)) {
            UtilidadesLog.debug("retorna true para sol.getOidSolicitud()" + sol.getOidSolicitud() + " concurso: " + this.getOidConcurso());
            UtilidadesLog.info("Concurso.validaClienteConPeriodoCalculado" +
                "(Solicitud sol):Salida");

            return true;
        }

        HistoricoEstatusCliente[] historicoEstatusCliente = 
            sol.getCliente().getHistoricoEstatusCliente();

        UtilidadesLog.debug("estatusVentaConsultoras " +
            estatusVentaConsultoras.length);
        UtilidadesLog.debug("historicoEstatusCliente " +
            historicoEstatusCliente.length);

        for (int i = 0; i < this.estatusVentaConsultoras.length; i++) {
            for (int j = 0; j < historicoEstatusCliente.length; j++) {
                UtilidadesLog.debug("sol.getPeriodoCalculo() " +
                    sol.getPeriodoCalculo());

                UtilidadesLog.debug("estatusVentaConsultoras[i]." +
                    "getPeriodoDesde() " +
                    estatusVentaConsultoras[i].getPeriodoDesde());

                UtilidadesLog.debug("estatusVentaConsultoras[i]." +
                    "getPeriodoHasta() " +
                    estatusVentaConsultoras[i].getPeriodoHasta());

                if (sol.getPeriodoCalculo().contenidoEn(
                    estatusVentaConsultoras[i].getPeriodoDesde(),
                    estatusVentaConsultoras[i].getPeriodoHasta())) {
                    
                    UtilidadesLog.debug("contenido 1 ");
                    UtilidadesLog.debug("historicoEstatusCliente[j]." +
                        "getOidEstatus() " +
                        historicoEstatusCliente[j].getOidEstatus());

                    UtilidadesLog.debug("estatusVentaConsultoras[i]." +
                        "getOidEstatusAnterior() " +
                        estatusVentaConsultoras[i].getOidEstatusAnterior());

                    UtilidadesLog.debug("estatusVentaConsultoras[i]." +
                        "getPeriodoDesde() " +
                        estatusVentaConsultoras[i].getPeriodoDesde()
                                                  .getFechaDesde());
                    UtilidadesLog.debug(
                        "historicoEstatusCliente[i].getPeriodoInicio() " +
                        historicoEstatusCliente[j].getPeriodoInicio()
                                                  .getFechaDesde());

                    if ((historicoEstatusCliente[j].getOidEstatus()!=null &&
                        historicoEstatusCliente[j].getOidEstatus().equals(
                        estatusVentaConsultoras[i].getOidEstatusAnterior())) &&
                    (
                        estatusVentaConsultoras[i].getPeriodoDesde()
                        .getFechaDesde().getTime() >= 
                        historicoEstatusCliente[j].getPeriodoInicio()
                        .getFechaDesde().getTime())&&((
                        historicoEstatusCliente[j].getPeriodoFin() == null)|| 
                        (estatusVentaConsultoras[i].getPeriodoHasta() == null) 
                        || (estatusVentaConsultoras[i].getPeriodoHasta()
                        .getFechaHasta().getTime() <= 
                        historicoEstatusCliente[j].getPeriodoFin()
                        .getFechaHasta().getTime()))){
                        UtilidadesLog.debug("retorna true 1 para sol.getOidSolicitud()" + sol.getOidSolicitud() + " concurso: " + this.getOidConcurso());
                        UtilidadesLog.info(" Concurso.validaClienteCon Periodo"
                            +"Calculado(Solicitud sol):Salida");

                        return true;
                    } else {
                        if ((estatusVentaConsultoras[i].getOidEstatusCliente()
                        .equals(historicoEstatusCliente[j].getOidEstatus())) &&
                         (estatusVentaConsultoras[i].getPeriodoDesde()
                          .getFechaDesde()
                          .getTime() >= 
                          historicoEstatusCliente[j].getPeriodoInicio()
                          .getFechaDesde()
                          .getTime()) &&
                          ((historicoEstatusCliente[j].getPeriodoFin() == null) 
                          ||(estatusVentaConsultoras[i].getPeriodoHasta() == 
                          null) ||(estatusVentaConsultoras[i].getPeriodoHasta()
                          .getFechaHasta()
                          .getTime() <= 
                            historicoEstatusCliente[j].getPeriodoFin()
                            .getFechaHasta()
                            .getTime()))) {
                            UtilidadesLog.debug("retorna true 2 para sol.getOidSolicitud()" + sol.getOidSolicitud() + " concurso: " + this.getOidConcurso());
                            UtilidadesLog.info("Concurso.validaCliente"
                                + "ConPeriodoCalculado(Solicitud sol):Salida");

                            return true;
                        }
                    }
                }
            }
        }

        UtilidadesLog.debug("retorna false para sol.getOidSolicitud()" + sol.getOidSolicitud() + " concurso: " + this.getOidConcurso());
        UtilidadesLog.info("Concurso.validaClienteConPeriodoCalculado(Solici"
            +"tud sol):Salida");

        return false;
    }*/

    /**
     * Indica si el cliente es valido efectuando la validacion con el atributo
     * Estatus Venta Consultoras.
     */
/*    public boolean validaClienteSinPeriodoCalculado(Solicitud sol) {
        UtilidadesLog.info("Concurso.validaClienteSinPeriodoCalculado( "
            +"Solicitud sol):Entrada");

        if ((this.estatusVentaConsultoras == null) ||
                (this.estatusVentaConsultoras.length == 0)) {
            UtilidadesLog.debug("estatusVentaConsultoras == null");
            UtilidadesLog.info("Concurso.validaClienteSinPeriodoCalculado("
            +"Solicitud sol):Salida NULL");

            return true;
        }

        HistoricoEstatusCliente[] historicoEstatusCliente = 
            sol.getCliente().getHistoricoEstatusCliente();

        for (int i = 0; i < this.estatusVentaConsultoras.length; i++) {
            for (int j = 0; j < historicoEstatusCliente.length; j++) {
                if ((historicoEstatusCliente[j].getOidEstatus()!= null &&
                    historicoEstatusCliente[j].getOidEstatus().equals(
                    estatusVentaConsultoras[i].getOidEstatusCliente())) &&
                        (estatusVentaConsultoras[i].getPeriodoDesde()
                        .getFechaDesde().getTime() >= 
                            historicoEstatusCliente[j].getPeriodoInicio()
                            .getFechaDesde().getTime()) &&
                        ((historicoEstatusCliente[j].getPeriodoFin() == null) 
                        || (estatusVentaConsultoras[i].getPeriodoHasta() 
                            == null) ||
                            (estatusVentaConsultoras[i].getPeriodoHasta()
                             .getFechaHasta().getTime() <= 
                                historicoEstatusCliente[j].getPeriodoFin()
                                .getFechaHasta().getTime()))) {
                    UtilidadesLog.info("Concurso.validaClienteSinPeriodo "
                        +"Calculado(Solicitud sol):Salida TRUE");

                    return true;
                }
            }
        }

        UtilidadesLog.info("Concurso.validaClienteSinPeriodoCalculado(Solici"
            +"tud sol):Salida FALSE");

        return false;
    }*/

    /**
     * retorna el OID del estatus que contiene al estatus pasado
     * por parametro en su campo oidEstatusFuturo.
     */
    public Long getEstatusPasado(Long oidEstatusCliente) {
        UtilidadesLog.info(
            "Concurso.getEstatusPasado(Long oidEstatusCliente):Entrada");

        Set keys = estatusFuturoClientes.keySet();
        Iterator iter = keys.iterator();

        while (iter.hasNext()) {
            EstatusFuturoClientes efc = (EstatusFuturoClientes) iter.next();

            if (oidEstatusCliente.equals(efc.getOidEstatusFuturo())) {
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("Concurso.getEstatusPasado(Long "
                    +"oidEstatusCliente):Salida " + efc.getOidEstatusCliente());

                return efc.getOidEstatusCliente();
            }
        }

        UtilidadesLog.info(
            "Concurso.getEstatusPasado(Long oidEstatusCliente):Salida NULL");

        return null;
    }

    /**
     * Verifica si la posicion se corresponde con alguno
     * de los productos definidos como exigidos
     */
    public boolean validarProductoExigido(Posicion pos) {
        UtilidadesLog.info("Concurso.validarProductoExigido(Posicion pos):En"
            +"trada");

        Long oidProducto = productoContenidoLista(pos, this.productosExigidos);

        if (oidProducto != null) {
            pos.getPosicionPuntaje(oidConcurso).setOidProductoExigido(
                oidProducto);
            UtilidadesLog.info("Concurso.validarProductoExigido(Posicion pos):Salida TRUE");

            return true;
        } else {
            UtilidadesLog.info(
                "Concurso.validarProductoExigido(Posicion pos):Salida FALSE");

            return false;
        }
    }

    /**
     * Este metodo recibe una posicon y una ListaProductos y verifica
     * si se encuentra contenida la posicion en la lista.
     */
    private Long productoContenidoLista(Posicion pos, ListaProductos lst) {
        UtilidadesLog.info( "Concurso.productoContenidoLista(Posicion pos, "
            +"ListaProductos lst):Entrada " + pos.getOidPosicion());

        if (lst == null) {
            UtilidadesLog.info("Concurso.productoContenidoLista(Posicion pos, "
                +"ListaProductos lst):Salida NULL");

            return null;
        }

        ArrayList lista = lst.getProductos();
        Iterator productos = lista.iterator();

        while (productos.hasNext()) {
            PrdBloque producto = (PrdBloque) productos.next();

            if (producto.validarProducto(pos, this.oidConcurso)) {
                if (producto.getOidProductoExigido() != null) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Concurso.productoContenidoLista(Posicion pos, "
                                +"ListaProductos lst):Salida " + producto.getOidProductoExigido());
                    return producto.getOidProductoExigido();
                } else { //entonces lo encontramos pero no tengo el oid (quizas se esta creando)
                   if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                     UtilidadesLog.debug("Concurso.productoContenidoLista(Posicion pos, "
                                +"ListaProductos lst):Salida Integer.MAX_VALUE");
                    return new Long(Integer.MAX_VALUE);
                }
            }
        }

        UtilidadesLog.info("Concurso.productoContenidoLista(Posicion pos, "
            +"ListaProductos lst):Salida NO LO ENCONTRE");

        return null;
    }

    /**
     * Este metodo recibe un objeto ConcursoSolicitud y verifica
     * si este cumple con todas las exigencias definidas
     */
    public boolean exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo) throws MareException {
      UtilidadesLog.info("Concurso.exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo):Entrada");
      boolean valor = this.exigenciasCumplidas(conSol, periodo, null);
      UtilidadesLog.info("Concurso.exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo):Salida");
      return valor; 
    }
     
    
    /**
   * Se agrega un nuevo parámetro y se crea otro método para mantener la firma.
   * BELC300024526
   * 
   *  sapaza -- PER-SiCC-2012-0082 -- 16/05/2012, se consolido en un solo while, el manejo de agrupacion Todos u Opcional
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return boolean
   * @param solicitud - puede venir en null si se llama desde exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo)
   * @param periodo
   * @param conSol
   */
   public boolean exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud) throws MareException {
        // si ya se han cumplido las exigencias se retornar true y termina 
        UtilidadesLog.info("Concurso.exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Entrada");
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Entro-Concurso.exigenciasCumplidas Concurso: " + conSol.getOidConcurso());
          UtilidadesLog.debug("Concurso.exigenciasCumplidas - conSol.getIndExigenciasCumplidas()" +  conSol.getIndExigenciasCumplidas());
        }  

        // sapaza -- SIN-RCR-20131003 AJUSTE CALCULAR PUNTAJE CONSULTORAS -- 03/10/2013
        /*if (conSol.getIndExigenciasCumplidas()
                    && ( solicitud == null || (solicitud != null 
                    && ! solicitud.getIndAnulacion() && ! solicitud.getIndDevolucion()) ) ){
            UtilidadesLog.info("Concurso.exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida TRUE 1");

            return true;
        }*/

        Concurso con = new DespacharPremiosHelper().obtenerConcurso(conSol.getOidConcurso());

        //jrivas 20090807 21/4/2009
        // procesar los productos exigidos (solo Bloque Producto)
        ArrayList listaLocal = productosExigidos.getProductos();
        Iterator productosLocal = listaLocal.iterator();
        
        //boolean valido = false;
        boolean tieneOpcionales = false;
        
        //jrivas 20090807.V2 3/6/2009
        boolean cumpleOpcionales = false;

        //jrivas 20090807.V2 3/6/2009
        //while (productosLocal.hasNext() && !valido) {
        while (productosLocal.hasNext()) {
            PrdBloque produc = (PrdBloque) productosLocal.next();
            
            //es Bloque Producto
            //if (produc.getIndAgrupacion() != null) {
                boolean todos;
                if ((produc.getIndAgrupacion() == null) || (produc.getIndAgrupacion().equals("T"))) {
                    todos = true;
                } else {
                    todos = false;
                    tieneOpcionales = true;
                }
            
                if (periodo.contenidoEn(produc.getPeriodoDesde(), produc.getPeriodoHasta())) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("**A Concurso.exigenciasCumplidas** produc " + produc);
            
                    Collection listaParam = conSol.getListaProductosExigidos().values();
                    Iterator productosParam = listaParam.iterator();
            
                    // buscar el producto en la solicitud
                    boolean loEncontre = false;
            
                    while (productosParam.hasNext()) {
                        ProductoExigido productoExigido = (ProductoExigido) productosParam.next();

                        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("A Concurso.exigenciasCumplidas - productoExigido " + productoExigido);
                          UtilidadesLog.debug("A Concurso.exigenciasCumplidas - productoExigido.getOidProductoExigido() " + productoExigido.getOidProductoExigido());
                          UtilidadesLog.debug("A Concurso.exigenciasCumplidas - produc.getOidProductoExigido() " + produc.getOidProductoExigido());
                        }  
                                
                        if (productoExigido.getOidProductoExigido().equals(produc.getOidProductoExigido())) {
                            UtilidadesLog.debug("A exigenciasCumplidas - lo encontre");
                            loEncontre = true;

                            if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - produc.getUnidadesExigidas() " +  produc.getUnidadesExigidas());
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - productoExigido.getUnidadesPedido() " + productoExigido.getUnidadesPedido());
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - produc.getMontoExigido()" +produc.getMontoExigido());
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - productoExigido.getMontoPedido() " + productoExigido.getMontoPedido());
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - produc.getPuntosExigidos()" + produc.getPuntosExigidos());
                              UtilidadesLog.debug("A Concurso.exigenciasCumplidas - productoExigido.getPuntosPedido() " + productoExigido.getPuntosPedido());
                            }  
            
                            //Si prd.unidadesExigidas<>null entonces 
                            if (produc.getUnidadesExigidas() != null) {
                                //Si prdExigido.unidadesPedido<prd.unidadesExigidas 
                                //retorna false y termina 
                                if (productoExigido.getUnidadesPedido().compareTo(produc.getUnidadesExigidas()) < 0) {
                                    UtilidadesLog.debug("A Concurso.exigenciasCumplidas - unidadesPedido<prd.unidadesExigidas");
                                    UtilidadesLog.info("A Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 1");
            
                                    if (todos)
                                        return false;
                                    else
                                        loEncontre = false;
                                }
                            }
            
                            //Si prd.montoExigido<>null entonces 
                            if (produc.getMontoExigido() != null) {
                                //Si prdExigido.montoPedido<prd.montoExigido retorna
                                //false y termina 
                                if (productoExigido.getMontoPedido().compareTo(produc.getMontoExigido()) < 0) {
                                    UtilidadesLog.debug("*A Concurso.exigenciasCumplidas  - prdExigido.montoPedido<prd.montoExigido");
                                    UtilidadesLog.info("A Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida");
            
                                    if (todos)
                                        return false;
                                    else
                                        loEncontre = false;

                                }
                            }
            
                            //Si prd.puntosExigidos<>null && (con.getBaseCalculo() no es BASE_CALCULO_NUM_PEDIDOS) entonces 
                            //jrivas 19/7/2006 DBLG50001046 se agrega  que no sea RECOMENDADA
                            if ( (produc.getPuntosExigidos() != null) 
                                        && !(con.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                                        && !(con.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA))) {
                                //Si prdExigido.puntosPedido<prd.puntosExigidos 
                                //retorna false y termina 
                                if (productoExigido.getPuntosPedido().compareTo(produc.getPuntosExigidos()) < 0) {
                                    UtilidadesLog.debug("A Concurso.exigenciasCumplidas puntosPedido<prd.puntosExigidos");
                                    UtilidadesLog.info("A Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 2");
            
                                    if (todos)
                                        return false;
                                    else
                                        loEncontre = false;

                                }
                            }
                        }
                    }
    
                    if (!loEncontre) {
                        UtilidadesLog.debug("A Concurso.exigenciasCumplidas**** false no lo encontre");
                        UtilidadesLog.info("A Concurso.exigenciasCumplidas( SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 3");
            
                        if (todos)
                            return false;
                    } else {
                        if (!todos)
                            cumpleOpcionales = true;
                    }
                }
            //}
        }    
        
        if (tieneOpcionales && !cumpleOpcionales) {
            UtilidadesLog.debug("A Concurso.exigenciasCumplidas**** no valido");
            UtilidadesLog.info("A Concurso.exigenciasCumplidas( SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 4");
            return false;
        }
        
        // procesar los productos exigidos
        /*listaLocal = productosExigidos.getProductos();
        productosLocal = listaLocal.iterator();

        while (productosLocal.hasNext()) {
            PrdBloque produc = (PrdBloque) productosLocal.next();
            
            //NO es Bloque Producto
            if (produc.getIndAgrupacion() == null) {

                if (periodo.contenidoEn(produc.getPeriodoDesde(), produc.getPeriodoHasta())) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("**Concurso.exigenciasCumplidas** produc " + produc);
        
                    Collection listaParam = conSol.getListaProductosExigidos().values();
                    Iterator productosParam = listaParam.iterator();
        
                    // buscar el producto en la solicitud
                    boolean loEncontre = false;
        
                    while (productosParam.hasNext()) {
                        ProductoExigido productoExigido = (ProductoExigido) productosParam.next();
                        
                        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                      
                          UtilidadesLog.debug("Concurso.exigenciasCumplidas - productoExigido " + productoExigido);
                          UtilidadesLog.debug("Concurso.exigenciasCumplidas - productoExigido.getOidProductoExigido() " + productoExigido.getOidProductoExigido());
                          UtilidadesLog.debug("Concurso.exigenciasCumplidas - produc.getOidProductoExigido() " + produc.getOidProductoExigido());
                        }  
                                
                        if (productoExigido.getOidProductoExigido().equals(produc.getOidProductoExigido())) {
                            UtilidadesLog.debug("exigenciasCumplidas - lo encontre");
                            loEncontre = true;

                            if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - produc.getUnidadesExigidas() " +  produc.getUnidadesExigidas());
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - productoExigido.getUnidadesPedido() " + productoExigido.getUnidadesPedido());
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - produc.getMontoExigido()" +produc.getMontoExigido());
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - productoExigido.getMontoPedido() " + productoExigido.getMontoPedido());
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - produc.getPuntosExigidos()" + produc.getPuntosExigidos());
                              UtilidadesLog.debug("Concurso.exigenciasCumplidas - productoExigido.getPuntosPedido() " + productoExigido.getPuntosPedido());
                            }    
        
                            //Si prd.unidadesExigidas<>null entonces 
                            if (produc.getUnidadesExigidas() != null) {
                                //Si prdExigido.unidadesPedido<prd.unidadesExigidas 
                                //retorna false y termina 
                                if (productoExigido.getUnidadesPedido().compareTo(produc.getUnidadesExigidas()) < 0) {
                                    UtilidadesLog.debug("Concurso.exigenciasCumplidas - unidadesPedido<prd.unidadesExigidas");
                                    UtilidadesLog.info("Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 1");
        
                                    return false;
                                }
                            }
        
                            //Si prd.montoExigido<>null entonces 
                            if (produc.getMontoExigido() != null) {
                                //Si prdExigido.montoPedido<prd.montoExigido retorna
                                //false y termina 
                                if (productoExigido.getMontoPedido().compareTo(produc.getMontoExigido()) < 0) {
                                    UtilidadesLog.debug("*Concurso.exigenciasCumplidas  - prdExigido.montoPedido<prd.montoExigido");
                                    UtilidadesLog.info("Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida");
        
                                    return false;
                                }
                            }
        
                            //Si prd.puntosExigidos<>null && (con.getBaseCalculo() no es BASE_CALCULO_NUM_PEDIDOS) entonces 
                            //jrivas 19/7/2006 DBLG50001046 se agrega  que no sea RECOMENDADA
                            if ( (produc.getPuntosExigidos() != null) 
                                        && !(con.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                                        && !(con.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA))) {
                                //Si prdExigido.puntosPedido<prd.puntosExigidos 
                                //retorna false y termina 
                                if (productoExigido.getPuntosPedido().compareTo(produc.getPuntosExigidos()) < 0) {
                                    UtilidadesLog.debug("Concurso.exigenciasCumplidas puntosPedido<prd.puntosExigidos");
                                    UtilidadesLog.info("Concurso.exigenciasCumplidas (SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 2");
        
                                    return false;
                                }
                            }
                        }
                    }
    
                    if (!loEncontre) {
                        UtilidadesLog.debug("Concurso.exigenciasCumplidas**** false no lo encontre");
                        UtilidadesLog.info("Concurso.exigenciasCumplidas( SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida FALSE 3");
        
                        return false;
                    }
                }
            }
        }

        // si se cumplen todas las condiciones entonces se retorna true 
        UtilidadesLog.debug("*Salio  Concurso.exigenciasCumplidas** true");
        UtilidadesLog.info("Concurso.exigenciasCumplidas(SolicitudConcurso conSol, Periodo periodo, Solicitud solicitud):Salida");*/

        return true;
    }
    
    /**
     * Verifica si la posicion se corresponde con alguno
     * de los productos definidos como validos
     */
    public boolean validarProductoValido(Posicion pos) {
        UtilidadesLog.info(
            "Concurso.validarProductoValido(Posicion pos):Entrada");

        if (productoContenidoLista(pos, this.productosValidos) != null) {
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("validarProductoValido true pos: " + pos.getOidPosicion());
            UtilidadesLog.info("Concurso.validarProductoValido(Posicion pos):Salida");

            return true;
        } else {
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("validarProductoValido false pos: " + pos.getOidPosicion());
            UtilidadesLog.info("Concurso.validarProductoValido(Posicion pos):Salida");

            return false;
        }
    }

    /**
     * Verifica si la posicion se corresponde con alguno
     * de los productos definidos como excluidos
     */
    public boolean validarProductoExcluido(Posicion pos) {
        UtilidadesLog.info(
            "Concurso.validarProductoExcluido(Posicion pos):Entrada");

        if (productoContenidoLista(pos, this.productosExcluidos) != null) {
            UtilidadesLog.info("Concurso.validarProductoExcluido(Posicion pos):Salida TRUE");

            return true;
        } else {
            UtilidadesLog.info("Concurso.validarProductoExcluido(Posicion pos):Salida FALSE");

            return false;
        }
    }

    /**
     * Verifica si la posicion se corresponde con alguno
     * de los productos definidos como bonificados
     */
    public boolean validarProductoBonificado(Posicion pos) {
        UtilidadesLog.info("Concurso.validarProductoBonificado(Posicion pos):Entrada");

        Long oidProducto = productoContenidoLista(pos, 
            this.productosBonificados);

        if (oidProducto != null) {
            pos.getPosicionPuntaje(oidConcurso).setOidProductoBonificado(
                oidProducto);
            UtilidadesLog.info(
                "Concurso.validarProductoBonificado(Posicion pos):Salida TRUE ");

            return true;
        } else {
            UtilidadesLog.info(
                "Concurso.validarProductoBonificado(Posicion pos):Salida FALSE");

            return false;
        }
    }

    /**
     * Busca los puntos bonificados por producto
     * y realiza el calculo del puntaje adicional
     * para esto se busca el PrdBloque que cumple con el producto
     */
    public Double calcularPuntosBonificados(Posicion pos)
        throws MareException {
        UtilidadesLog.info(
            "Concurso.calcularPuntosBonificados(Posicion pos):Entrada");

        ArrayList listaProductos = productosBonificados.getProductos();
        Iterator productos = listaProductos.iterator();

        while (productos.hasNext()) {
            PrdBloque producto = (PrdBloque) productos.next();

            UtilidadesLog.debug("producto.getOidProductoExigido() " +
                producto.getOidProductoExigido());
            UtilidadesLog.debug(
                "pos.getPosicionPuntaje().getOidProductoBonificado() " +
                pos.getPosicionPuntaje(this.oidConcurso)
                   .getOidProductoBonificado());

            if (producto.getOidProductoExigido().equals(pos.getPosicionPuntaje(
                            this.oidConcurso).getOidProductoBonificado())) {
                            
                if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                  UtilidadesLog.debug("producto.getOidProductoExigido() " +
                    producto.getOidProductoExigido());
                  UtilidadesLog.debug("producto.getPuntosUnidad() " +
                    producto.getPuntosUnidad());
                  UtilidadesLog.debug("producto.getFactorMultiplicador() " +
                    producto.getFactorMultiplicador());
                }    
                
                UtilidadesLog.info(
                    "Concurso.calcularPuntosBonificados(Posicion pos):Salida");

                return new Double(producto.getPuntosUnidad().doubleValue() * 
                    producto.getFactorMultiplicador().doubleValue());
            }
        }

        UtilidadesLog.debug( "Clase Concurso metodo calcularPuntosBonificados: "
            +"nunca deberia pasar que no se encontrase un PrdBloque dado que "
            +" esto se valido previamente.");

        /*try {
        } catch (MareException me) {
            if (debug) {
               UtilidadesLog.error(me);
            }

            UtilidadesLog.debug("Clase Concurso metodo 
            calcularPuntosBonificados: nunca deberia pasar que no se encontrase
            un PrdBloque dado que esto se valido previamente. NO SE PUDO GRABAR
            EN LOG.");
        }*/
        UtilidadesLog.info(
            "Concurso.calcularPuntosBonificados(Posicion pos):Salida");
        throw new MareException(
            "Clase Concurso metodo calcularPuntosBonificados: nunca deberia "
            +"pasar que no se encontrase un PrdBloque dado que esto se valido "
            +"previamente.");
    }

    /**
     * este metodo retorna las exigencias minimas para el concurso
     * al que pertenece segun la cantidad de periodos de la solicitud recibida 
     * por parametro.
     */
    public BigDecimal obtenerExigenciaMinima(Solicitud solicitud) {
        UtilidadesLog.info(
            "Concurso.obtenerExigenciaMinima(Solicitud solicitud):Entrada");

        SolicitudConcurso solCon = solicitud.getSolicitudConcurso(
            this.oidConcurso);
        int periodos = solCon.getNumeroPeriodosEvaluados();

        if (this.requisitosProgramaNuevas != null) {
            for (int i = 0; i < requisitosProgramaNuevas.length; i++) {
                if (requisitosProgramaNuevas[i].getNumeroPedido().equals(
                    new Long(periodos))) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Concurso.obtenerExigenciaMinima( "
                        +"Solicitud solicitud):Salida " + requisitosProgramaNuevas[i].getExigenciaMinima());

                    return requisitosProgramaNuevas[i].getExigenciaMinima();
                }
            }
        }

        UtilidadesLog.info(
            "Concurso.obtenerExigenciaMinima(Solicitud solicitud):Salida =0=");

        return new BigDecimal(0);
    }

    /**
     * verificar si cumple el ambito geografico
     */
    public boolean cumpleAmbitoGeografico(AmbitoGeografico ambitoEntrada) {
        UtilidadesLog.info("Concurso.cumpleAmbitoGeografico(AmbitoGeografico "
            +"ambitoEntrada):Entrada");

        if (ambitosGeograficos == null) {
            UtilidadesLog.debug("AmbitoGeografico == null");
            UtilidadesLog.info("Concurso.cumpleAmbitoGeografico( "
                +"AmbitoGeografico ambitoEntrada):Salida");

            return true;
        } else {
            if (ambitosGeograficos.length == 0) {
                UtilidadesLog.info(
                    "Concurso.cumpleAmbitoGeografico(AmbitoGeografico "
                    +" ambitoEntrada):Salida =0=");

                return true;
            }
        }

        for (int i = 0; i < ambitosGeograficos.length; i++) {
            if (ambitosGeograficos[i].equalsAmbito(ambitoEntrada) == true) {
                UtilidadesLog.info(
                    "Concurso.cumpleAmbitoGeografico(AmbitoGeografico"
                     +" ambitoEntrada):Salida TRUE");

                return true;
            }
        }

        UtilidadesLog.info("Concurso.cumpleAmbitoGeografico(AmbitoGeografico " 
            +"ambitoEntrada):Salida FALSE");

        return false;
    }

    /**
     * este metodo retorna el tipo de requisito para el concurso
     * al que pertenece segun la cantidad de periodos de la solicitud recibida 
     * por parametro.
     */
    public Long obtenerTipoRequisito(Solicitud solicitud)
        throws MareException {
        UtilidadesLog.info(
            "Concurso.obtenerTipoRequisito(Solicitud solicitud):Entrada");
        UtilidadesLog.debug("Entro a obtenerTipoRequisito");

        SolicitudConcurso solCon = solicitud.getSolicitudConcurso(
            this.oidConcurso);
        int periodos = solCon.getNumeroPeriodosEvaluados();
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("obtenerTipoRequisito periodos " + periodos);

        if (this.requisitosProgramaNuevas != null) {
            for (int i = 0; i < requisitosProgramaNuevas.length; i++) {
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("obtenerTipoRequisito "
                    +"requisitosProgramaNuevas[i].getNumeroPedido() " +
                    requisitosProgramaNuevas[i].getNumeroPedido());

                if (requisitosProgramaNuevas[i].getNumeroPedido().intValue() == periodos) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Salgo de obtenerTipoRequisito con: " +
                        requisitosProgramaNuevas[i].getOidTipoRequisito());
                        
                    UtilidadesLog.info("Concurso.cumpleAmbitoGeografico( "
                        +" AmbitoGeografico ambitoEntrada):Salida");

                    return requisitosProgramaNuevas[i].getOidTipoRequisito();
                }
            }
        }

        UtilidadesLog.debug("Salgo de obtenerTipoRequisito con NULL");
        UtilidadesLog.info("Concurso.obtenerTipoRequisito(Solicitud "
            +"solicitud):Salida");

        return null;
    }

    /**
     * Este método determina si el cliente es Activo para un rango de periodos
     */
    public boolean esActivo(Solicitud sol) {
        UtilidadesLog.info("Concurso.esActivo(Solicitud sol):Entrada");

        // Determinar periodos inicial y final
        Periodo periodoIngreso = (sol.getCliente().getPeriodoPrimerContacto()
            != null)? sol.getCliente().getPeriodoPrimerContacto() : 
                this.periodoDesde;
            
        Periodo periodoInicial = (periodoIngreso.menorQue(this.periodoDesde))
            ? this.periodoDesde : periodoIngreso;
            
        Periodo periodoFinal = (sol.getPeriodo().menorQue(this.periodoHasta) ||
            sol.getPeriodo().equals(this.periodoHasta)) ? sol.getPeriodo()
                                                        : this.periodoHasta;

        /*UtilidadesLog.info("sol.getCliente().getPeriodoPrimerContacto(): " + 
         * sol.getCliente().getPeriodoPrimerContacto());
        UtilidadesLog.info("periodoDesde: " + periodoDesde);
        UtilidadesLog.info("periodoHasta: " + periodoHasta);
        UtilidadesLog.info("sol.getPeriodo(): " + sol.getPeriodo());

        UtilidadesLog.info("periodoIngreso: " + periodoIngreso);
        UtilidadesLog.info("periodoInicial: " + periodoInicial);
        UtilidadesLog.info("periodoFinal: " + periodoFinal);*/

        // Evaluar actividad
        // Mediante el cronograma del concurso itero entre periodoInicial y 
        //periodoFinal 
        
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;
        int noPasoPedidos = 0;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            // verificar si el periodo es limite de rango
            //UtilidadesLog.info("periodo.getOidPeriodo: " +
            //periodo.getOidPeriodo());
            //UtilidadesLog.info("periodoInicial.getOidPeriodo: " +
            //periodoInicial.getOidPeriodo());            
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                //UtilidadesLog.info("true encontrePeriodoInicial");
                encontrePeriodoInicial = true;
            }

            //UtilidadesLog.info("periodo.getOidPeriodo: " + 
            //periodo.getOidPeriodo());
            //UtilidadesLog.info("periodoFinal.getOidPeriodo: " + 
            //periodoFinal.getOidPeriodo());            
            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())){
                //UtilidadesLog.info("true encontrePeriodoFinal");
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna true el Cliente ha sido activo para 
                //ese rango
                //UtilidadesLog.info("sol.getCliente().pasoPedidos(
                //periodo.getOidPeriodo()): " + sol.getCliente().pasoPedidos
                //(periodo.getOidPeriodo()));            
                if (!sol.getCliente().pasoPedidos(periodo.getOidPeriodo()).booleanValue()) {
                    noPasoPedidos++;
                    if (noPasoPedidos > 1) {
                        UtilidadesLog.info("Concurso.esActivo(Solicitud sol):Salida FALSE 2");
                        return false;
                    }
                } else {
                    noPasoPedidos = 0;
                }            
            }
        }

        // si el rango se verifico completo y paso pedidos, todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)) {
            UtilidadesLog.info("Concurso.esActivo(Solicitud sol):Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esActivo(Solicitud sol):Salida FALSE");
            return false;
        }
    }

    /**
     * Este método determina si el cliente es Constante para un rango de 
     * periodos
     */
    public boolean esConstante(Solicitud sol) {
        UtilidadesLog.info("Concurso.esConstante(Solicitud sol):Entrada");

        // Determinar periodos inicial y final
        Periodo periodoIngreso = (sol.getCliente().getPeriodoPrimerContacto() 
        != null)? sol.getCliente().getPeriodoPrimerContacto() : 
            this.periodoDesde;
        Periodo periodoInicial = (periodoIngreso.menorQue(this.periodoDesde))
            ? this.periodoDesde : periodoIngreso;
            
        Periodo periodoFinal = (sol.getPeriodo().menorQue(this.periodoHasta) ||
            sol.getPeriodo().equals(this.periodoHasta)) ? sol.getPeriodo()
                                                        : this.periodoHasta;

        // Evaluar constancia 
        // Mediante el cronograma del concurso itero entre periodoInicial 
        //y periodoFinal 
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            // verificar si el periodo es limite de rango
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                encontrePeriodoInicial = true;
            }

            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())){
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso 
            //pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna false el Cliente no ha sido 
                //constante para ese rango
                if (!sol.getCliente().pasoPedidos(periodo.getOidPeriodo())
                            .booleanValue()) {
                    UtilidadesLog.info("Concurso.esConstante(Solicitud sol):Salida FALSE " + periodo.getOidPeriodo());
                    return false;
                }
            }
        }

        // si el rango se verifico completo y no salio por no pasar pedidos,
        //todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)) {
            UtilidadesLog.info("Concurso.esConstante(Solicitud sol):Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esConstante(Solicitud sol):Salida FALSE 27");
            return false;
        }
    }

    public boolean contieneAcceso(Long oidAcceso) {
        UtilidadesLog.info("Concurso.contieneAcceso(Long oidAcceso):Entrada");

        if (this.oidAccesos == null) {
            UtilidadesLog.info("Concurso.contieneAcceso(Long oidAcceso): "
                +"Salida TRUE NULL");

            return true;
        } else {
            if (this.oidAccesos.length == 0) {
                UtilidadesLog.info(
                    "Concurso.contieneAcceso(Long oidAcceso):Salida TRUE 0");

                return true;
            }
        }

        for (int i = 0; i < this.oidAccesos.length; i++) {
            if (this.oidAccesos[i].equals(oidAcceso)) {
                UtilidadesLog.info(
                    "Concurso.contieneAcceso(Long oidAcceso):Salida TRUE ");

                return true;
            }
        }

        UtilidadesLog.info("Concurso.contieneAcceso(Long oidAcceso):Salida FALSE ");

        return false;
    }

    /**
     * Este método determina si el cliente es Activo para un rango de periodos
     */
    public boolean esActivoRecomendada(Solicitud sol) {
        UtilidadesLog.info(
            "Concurso.esActivoRecomendada(Solicitud sol):Entrada");

        if (sol.getSolicitudConcurso(
            this.oidConcurso).getPeriodoInicioVinculo() == null) {
            UtilidadesLog.info( "Concurso.esActivoRecomendada(Solicitud sol): "
                +"Salida TRUE");

            return true;
        }

        // Determinar periodos inicial y final
        Periodo periodoInicial = sol.getSolicitudConcurso(this.oidConcurso)
                                    .getPeriodoInicioVinculo();

        Periodo finVincu = sol.getSolicitudConcurso(this.oidConcurso).getPeriodoFinVinculo();
        if (finVincu == null) {
           finVincu = sol.getPeriodo();
        } 

        Periodo periodoFinal = (sol.getPeriodo().menorQue(finVincu) ||
                sol.getPeriodo().equals(finVincu)) ? sol.getPeriodo()
                                                            : finVincu;
        
        // Evaluar actividad
        // Mediante el cronograma del concurso itero entre periodoInicial y 
        //periodoFinal 
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;
        int noPasoPedidos = 0;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            // verificar si el periodo es limite de rango
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                encontrePeriodoInicial = true;
            }

            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())){
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso 
            //pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna true el Cliente ha sido activo para 
                //ese rango
                if (!sol.getCliente().getClienteRecomendante().pasoPedidos(periodo.getOidPeriodo()).booleanValue()){
                    noPasoPedidos++;
                    if (noPasoPedidos > 1) {
                        UtilidadesLog.info("Concurso.esActivo(Solicitud sol):Salida FALSE 2");
                        return false;
                    }
                } else {
                    noPasoPedidos = 0;
                }  
            }
        }

        // si el rango se verifico completo y paso pedidos, todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)) {
            UtilidadesLog.info( "Concurso.esActivoRecomendada(Solicitud sol):"
                +"Salida TRUE 2");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esActivoRecomendada(Solicitud sol): "
                +"Salida FALSE");
            return false;
        }
    }

    /**
     * Este método determina si el cliente es Constante para un rango de
     * periodos
     */
    public boolean esConstanteRecomendada(Solicitud sol) {
        UtilidadesLog.info(
            "Concurso.esConstanteRecomendada(Solicitud sol):Entrada");

        if (sol.getSolicitudConcurso(
            this.oidConcurso).getPeriodoInicioVinculo() == null) {
            
            UtilidadesLog.info("Concurso.esConstanteRecomendada(Solicitud sol):"
                + " Salida");

            return true;
        }

        // Determinar periodos inicial y final
        Periodo periodoInicial = sol.getSolicitudConcurso(this.oidConcurso)
                                    .getPeriodoInicioVinculo();

        Periodo finVincu = sol.getSolicitudConcurso(this.oidConcurso).getPeriodoFinVinculo();
        if (finVincu == null) {
           finVincu = sol.getPeriodo();
        } 

        Periodo periodoFinal = (sol.getPeriodo().menorQue(finVincu) ||
                sol.getPeriodo().equals(finVincu)) ? sol.getPeriodo()
                                                            : finVincu;

        // Evaluar constancia
        // Mediante el cronograma del concurso itero entre periodoInicial y 
        //periodoFinal 
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            // verificar si el periodo es limite de rango
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                encontrePeriodoInicial = true;
            }

            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())){
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso 
            //pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna false el Cliente no ha sido 
                //constante para ese rango
                if (!sol.getCliente().getClienteRecomendante()
                     .pasoPedidos(periodo.getOidPeriodo()).booleanValue()){
                    UtilidadesLog.info("Concurso.esConstanteRecomendada:Salida FALSE");
                    return false;
                }
            }
        }

        // si el rango se verifico completo y no salio por no pasar pedidos, 
        //todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)){
            UtilidadesLog.info("Concurso.esConstanteRecomendada:Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esConstanteRecomendada:Salida FALSE 2");
            return false;
        }
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public boolean getParticipacionParticipantesCompleta() {
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** participacionParticipantesCompleta: " +
            participacionParticipantesCompleta);

        return participacionParticipantesCompleta;
    }

    public void setParticipacionParticipantesCompleta(
        boolean participacionParticipantesCompleta) {
        this.participacionParticipantesCompleta = 
            participacionParticipantesCompleta;
    }

    public TipificacionCliente[] getTipificacionesClientesParticipantes() {
        return tipificacionesClientesParticipantes;
    }

    public void setTipificacionesClientesParticipantes(
        TipificacionCliente[] tipificacionesClientesParticipantes) {
        this.tipificacionesClientesParticipantes = 
            tipificacionesClientesParticipantes;
    }

    public Periodo getPeriodoDesde() {
        return periodoDesde;
    }

    public void setPeriodoDesde(Periodo periodoDesde) {
        this.periodoDesde = periodoDesde;
    }

    public Periodo getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodoHasta(Periodo periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    public EstatusVentaConsultoras[] getEstatusVentaConsultoras() {
        return estatusVentaConsultoras;
    }

    public void setEstatusVentaConsultoras(
        EstatusVentaConsultoras[] estatusVentaConsultoras) {
        this.estatusVentaConsultoras = estatusVentaConsultoras;
    }

    public HashMap getEstatusFuturoClientes() {
        return estatusFuturoClientes;
    }

    public void setEstatusFuturoClientes(HashMap estatusFuturoClientes) {
        this.estatusFuturoClientes = estatusFuturoClientes;
    }

    public ArrayList getCronograma() {
        return cronograma;
    }

    public void setCronograma(ArrayList cronograma) {
        this.cronograma = cronograma;
    }

    public Long getOidTipoExigencia() {
        return oidTipoExigencia;
    }

    public void setOidTipoExigencia(Long oidTipoExigencia) {
        this.oidTipoExigencia = oidTipoExigencia;
    }

    public RequisitosProgramaNuevas[] getRequisitosProgramaNuevas() {
        return requisitosProgramaNuevas;
    }

    public void setRequisitosProgramaNuevas(
        RequisitosProgramaNuevas[] requisitosProgramaNuevas) {
        this.requisitosProgramaNuevas = requisitosProgramaNuevas;
    }

    public ListaProductos getProductosExigidos() {
        return productosExigidos;
    }

    public void setProductosExigidos(ListaProductos productosExigidos) {
        this.productosExigidos = productosExigidos;
    }

    public ListaProductos getProductosBonificados() {
        return productosBonificados;
    }

    public void setProductosBonificados(ListaProductos productosBonificados) {
        this.productosBonificados = productosBonificados;
    }

    public ListaProductos getProductosExcluidos() {
        return productosExcluidos;
    }

    public void setProductosExcluidos(ListaProductos productosExcluidos) {
        this.productosExcluidos = productosExcluidos;
    }

    public ListaProductos getProductosValidos() {
        return productosValidos;
    }

    public void setProductosValidos(ListaProductos productosValidos) {
        this.productosValidos = productosValidos;
    }

    public boolean getIndFaltantesAnunciados() {
        return indFaltantesAnunciados;
    }

    public void setIndFaltantesAnunciados(boolean indFaltantesAnunciados) {
        this.indFaltantesAnunciados = indFaltantesAnunciados;
    }

    public Double getPuntosAsignar() {
        return puntosAsignar;
    }

    public void setPuntosAsignar(Double puntosAsignar) {
        this.puntosAsignar = puntosAsignar;
    }

    public Long getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(Long tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Double getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(Double factorConversion) {
        this.factorConversion = factorConversion;
    }

    public boolean getIndProductosExigidos() {
        return indProductosExigidos;
    }

    public void setIndProductosExigidos(boolean indProductosExigidos) {
        this.indProductosExigidos = indProductosExigidos;
    }

    public boolean getIndProductosBonificados() {
        return indProductosBonificados;
    }

    public void setIndProductosBonificados(boolean indProductosBonificados) {
        this.indProductosBonificados = indProductosBonificados;
    }

    public boolean getIndProductosValidosCompletos() {
        return indProductosValidosCompletos;
    }

    public void setIndProductosValidosCompletos(
        boolean indProductosValidosCompletos) {
        this.indProductosValidosCompletos = indProductosValidosCompletos;
    }

    public boolean getIndProductosExcluidos() {
        return indProductosExcluidos;
    }

    public void setIndProductosExcluidos(boolean indProductosExcluidos) {
        this.indProductosExcluidos = indProductosExcluidos;
    }

    public ParametrosNivelPremiacion[] getParametrosNivelPremiacion() {
        return parametrosNivelPremiacion;
    }

    public void setParametrosNivelPremiacion(
        ParametrosNivelPremiacion[] parametrosNivelPremiacion) {
        this.parametrosNivelPremiacion = parametrosNivelPremiacion;
    }

    public Long getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(Long baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public boolean getMultiNivel() {
        return multiNivel;
    }

    public void setMultiNivel(boolean multiNivel) {
        this.multiNivel = multiNivel;
    }

    public Long getDirigidoA() {
        return dirigidoA;
    }

    public void setDirigidoA(Long dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public boolean getProgramaNuevas() {
        return programaNuevas;
    }

    public void setProgramaNuevas(boolean programaNuevas) {
        this.programaNuevas = programaNuevas;
    }

    public Periodo getPeriodoDeDespacho() {
        return periodoDeDespacho;
    }

    public void setPeriodoDeDespacho(Periodo periodoDeDespacho) {
        this.periodoDeDespacho = periodoDeDespacho;
    }

    public AmbitoGeografico[] getAmbitosGeograficos() {
        return ambitosGeograficos;
    }

    public void setAmbitosGeograficos(AmbitoGeografico[] ambitosGeograficos) {
        this.ambitosGeograficos = ambitosGeograficos;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long[] getOidAccesos() {
        return oidAccesos;
    }

    public void setOidAccesos(Long[] oidAccesos) {
        this.oidAccesos = oidAccesos;
    }

    public Periodo getUltimoPeridoEvaluar() {
        return ultimoPeridoEvaluar;
    }

    public void setUltimoPeridoEvaluar(Periodo ultimoPeridoEvaluar) {
        this.ultimoPeridoEvaluar = ultimoPeridoEvaluar;
    }

    public Periodo getUltimoPeriodoPremiacion() {
        return ultimoPeriodoPremiacion;
    }

    public void setUltimoPeriodoPremiacion(Periodo ultimoPeriodoPremiacion) {
        this.ultimoPeriodoPremiacion = ultimoPeriodoPremiacion;
    }

    public boolean getIndAmbitoGeograficoCompleto() {
        return indAmbitoGeograficoCompleto;
    }

    public void setIndAmbitoGeograficoCompleto(
        boolean indAmbitoGeograficoCompleto) {
        this.indAmbitoGeograficoCompleto = indAmbitoGeograficoCompleto;
    }

    public boolean getIndAnulacion() {
        return indAnulacion;
    }

    public void setIndAnulacion(boolean indAnulacion) {
        this.indAnulacion = indAnulacion;
    }

    public boolean getIndDevolucion() {
        return indDevolucion;
    }

    public void setIndDevolucion(boolean indDevolucion) {
        this.indDevolucion = indDevolucion;
    }

    public void setPuntajeAcumulativo(boolean puntajeAcumulativo) {
        this.puntajeAcumulativo = puntajeAcumulativo;
    }

    public boolean getPuntajeAcumulativo() {
        return puntajeAcumulativo;
    }

    public void setTipoPremiacion(Long tipoPremiacion) {
        this.tipoPremiacion = tipoPremiacion;
    }

    public Long getTipoPremiacion() {
        return tipoPremiacion;
    }

    public void setAccesoNivelSuperior(boolean accesoNivelSuperior) {
        this.accesoNivelSuperior = accesoNivelSuperior;
    }

    public boolean getAccesoNivelSuperior() {
        return accesoNivelSuperior;
    }

    public void setNivelesRotatorios(boolean nivelesRotatorios) {
        this.nivelesRotatorios = nivelesRotatorios;
    }

    public boolean getNivelesRotatorios() {
        return nivelesRotatorios;
    }

    public void setNumeroRotaciones(Integer numeroRotaciones) {
        this.numeroRotaciones = numeroRotaciones;
    }

    public Integer getNumeroRotaciones() {
        return numeroRotaciones;
    }

    public void setIndPeriodoDespachoExigido(Boolean indPeriodoDespachoExigido){
        this.indPeriodoDespachoExigido = indPeriodoDespachoExigido;
    }

    public Boolean getIndPeriodoDespachoExigido() {
        return indPeriodoDespachoExigido;
    }

    public void setPeriodoDespacho(Periodo periodoDespacho) {
        this.periodoDespacho = periodoDespacho;
    }

    public Periodo getPeriodoDespacho() {
        return periodoDespacho;
    }

    public void setNumeroPeriodos(Long numeroPeriodos) {
        this.numeroPeriodos = numeroPeriodos;
    }

    public Long getNumeroPeriodos() {
        return numeroPeriodos;
    }

    //jrivas 18/8/2005
    //inc 20450

    /*public void setPeriodoDespachoDespuesObtencion(Periodo
     * periodoDespachoDespuesObtencion) {
        this.periodoDespachoDespuesObtencion = 
            periodoDespachoDespuesObtencion;
    }

    public Periodo getPeriodoDespachoDespuesObtencion() {
        return periodoDespachoDespuesObtencion;
    }*/
    public void setPedidoEnPeriodo(boolean pedidoEnPeriodo) {
        this.pedidoEnPeriodo = pedidoEnPeriodo;
    }

    public boolean getPedidoEnPeriodo() {
        return pedidoEnPeriodo;
    }

    public void setMontoMinimoPedido(BigDecimal montoMinimoPedido) {
        this.montoMinimoPedido = montoMinimoPedido;
    }

    public BigDecimal getMontoMinimoPedido() {
        return this.montoMinimoPedido;
    }

    public void setProductosExigidosPremiacion(
        ArrayList productosExigidosPremiacion) {
        this.productosExigidosPremiacion = productosExigidosPremiacion;
    }

    public ArrayList getProductosExigidosPremiacion() {
        return productosExigidosPremiacion;
    }

    public void setMontoMinimoConcurso(BigDecimal montoMinimoConcurso) {
        this.montoMinimoConcurso = montoMinimoConcurso;
    }

    public BigDecimal getMontoMinimoConcurso() {
        return montoMinimoConcurso;
    }

    public void setCuotaMinimaIngreso(Double cuotaMinimaIngreso) {
        this.cuotaMinimaIngreso = cuotaMinimaIngreso;
    }

    public Double getCuotaMinimaIngreso() {
        return cuotaMinimaIngreso;
    }

    public void setNumeroPedidos(Long numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public Long getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setIndAsistenciaCursos(boolean indAsistenciaCursos) {
        this.indAsistenciaCursos = indAsistenciaCursos;
    }

    public boolean getIndAsistenciaCursos() {
        return indAsistenciaCursos;
    }

    public void setTipoCursosExigidos(ArrayList tipoCursosExigidos) {
        this.tipoCursosExigidos = tipoCursosExigidos;
    }

    public ArrayList getTipoCursosExigidos() {
        return tipoCursosExigidos;
    }

    public void setIndPagoATiempo(boolean indPagoATiempo) {
        this.indPagoATiempo = indPagoATiempo;
    }

    public boolean getIndPagoATiempo() {
        return indPagoATiempo;
    }

    public void setDiasGracia(Long diasGracia) {
        this.diasGracia = diasGracia;
    }

    public Long getDiasGracia() {
        return diasGracia;
    }

    public void setPremiosAcumulativosNiveles(
        boolean premiosAcumulativosNiveles) {
        this.premiosAcumulativosNiveles = premiosAcumulativosNiveles;
    }

    public boolean getPremiosAcumulativosNiveles() {
        return premiosAcumulativosNiveles;
    }

    public void setComunicacionAutomatica(boolean comunicacionAutomatica) {
        this.comunicacionAutomatica = comunicacionAutomatica;
    }

    public boolean getComunicacionAutomatica() {
        return comunicacionAutomatica;
    }

    public void setNumeroMinimoPedido(Long numeroMinimoPedido) {
        this.numeroMinimoPedido = numeroMinimoPedido;
    }

    public Long getNumeroMinimoPedido() {
        return numeroMinimoPedido;
    }

    public void setNumeroMinimoPedidoRecomendada(
        Long numeroMinimoPedidoRecomendada) {
        this.numeroMinimoPedidoRecomendada = numeroMinimoPedidoRecomendada;
    }

    public Long getNumeroMinimoPedidoRecomendada() {
        return numeroMinimoPedidoRecomendada;
    }

    public void setComunicacionEnObtencionPuntos(
        boolean comunicacionEnObtencionPuntos) {
        this.comunicacionEnObtencionPuntos = comunicacionEnObtencionPuntos;
    }

    public boolean getComunicacionEnObtencionPuntos() {
        return comunicacionEnObtencionPuntos;
    }

    public void setMontosRecomendada(ArrayList montosRecomendada) {
        this.montosRecomendada = montosRecomendada;
    }

    public ArrayList getMontosRecomendada() {
        return montosRecomendada;
    }

    /**
     * Verifica si la posicion se corresponde con alguno de los productos
     * definidos como validos.
     * Llama al metodo productoContenidoLista(pos,this.produtosCalificados)
     * retornar el valor obtenido en la llamada anterior.
     *
     * @return prodContList
     * @param pos
     *
     * @Author Sergio Platas
     * @date 09/05/2005
     */
    public Boolean validarProductoCalificado(Posicion pos) {
        UtilidadesLog.info("Concurso.validarProductoCalificado(Posicion pos):Entrada");
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
          UtilidadesLog.debug("Posicion: " + pos.getOidPosicion());

        if (productoContenidoLista(pos, this.productosCalificar) != null) {
            UtilidadesLog.info("Concurso.validarProductoCalificado(Posicion pos):Salida TRUE");

            return Boolean.TRUE;
        } else {
            UtilidadesLog.info("Concurso.validarProductoCalificado(Posicion pos):Salida FALSE");

            return Boolean.FALSE;
        }
    }

    /**
     * Verifica si la posicion se corresponde con alguno de los productos 
     * definidos como validos
     * 
     * Llama al metodo productoContenidoLista(pos,
     *                              this.produtosExcluirCalificados)
     * retornar el valor obtenido en la llamada anterior.
     *
     * @return prodExclCal
     * @param pos
     *
     * @Author Sergio Platas
     * @date 10/05/2005
     */
    public Boolean validarProductoExcluidoCalificado(Posicion pos) {
        UtilidadesLog.info(
          "Concurso.validarProductoExcluidoCalificado(Posicion pos):Entrada");
        UtilidadesLog.debug("Posicion: " + pos.getOidPosicion());

        if (productoContenidoLista(pos, 
            this.productosExcluirCalificar) != null) {
            
            UtilidadesLog.info("Concurso.validarProductoExcluidoCalificado "
                +"(Posicion pos):Salida TRUE");

            return Boolean.TRUE;
        } else {
            UtilidadesLog.info("Concurso.validarProductoExcluidoCalificado "
                +"(Posicion pos):Salida FALSE");

            return Boolean.FALSE;
        }
    }

    public ListaProductos getProductosCalificar() {
        return this.productosCalificar;
    }

    public void setProductosCalificar(ListaProductos productosCalificar) {
        this.productosCalificar = productosCalificar;
    }

    public void setProductosExcluirCalificar(
        ListaProductos productosExcluirCalificar) {
        this.productosExcluirCalificar = productosExcluirCalificar;
    }

    public ListaProductos getProductosExcluirCalificar() {
        return this.productosExcluirCalificar;
    }

    /**
     * Iterar la lista de 'tipoCursosExigidos' y por cada uno de los 
     * elementos de la lista (son del tipo Long)
     * verificar su existencia en el mapa recibido como parametro.
     * Si todos los elementos de tipoCursosExigidos se encuentran en el mapa 
     * recibido como parametro
     * retornar true, caso contrario false
     * 
     * @author Sergio Platas
     * @date 27/05/2005
     * @param cursos
     */
    public boolean verificaAsistenciaCursos(HashMap cursos) {
        UtilidadesLog.info(
            "Concurso.verificaAsistenciaCursos(HashMap cursos):Entrada");

        boolean existe = true;

        if (this.tipoCursosExigidos != null) {
            for (int i = 0; i < (this.tipoCursosExigidos.size()); i++) {
                if (!cursos.containsKey(tipoCursosExigidos.get(i))) {
                    existe = false;
                    break;
                } 
            }
        }

        UtilidadesLog.info(
            "Concurso.verificaAsistenciaCursos(HashMap cursos):Salida " + existe);

        return existe;
    }

    /**
      * Iterar la lista de 'productosExigidosPremiacion' y por cada uno de los 
      * elementos de la lista (son del tipo Long) verificar su existencia en 
      * el mapa recibido como parametro.
      * Si todos los elementos de productosExigidosPremiacion se encuentran en 
      * el mapa retornar true, caso contrario false.
      *
      * @author Sergio Platas
      * @date 30/05/2005
      * @param productos
      */
    public boolean verificaProductosExigidos(HashMap productos) {
        UtilidadesLog.info(
            "Concurso.verificaProductosExigidos(HashMap productos):Entrada");

        boolean existe = true;

        if (this.productosExigidosPremiacion != null) {
            for (int i = 0; i < (this.productosExigidosPremiacion.size()); i++) {
                if (!productos.containsKey(productosExigidosPremiacion.get(i))) {
                    existe = false;
                    break;
                } 
            }
        }

        UtilidadesLog.info(
            "Concurso.verificaProductosExigidos(HashMap productos):Salida");

        return existe;
    }

    // Agregado por Sergio Platas - 27/05/2005 - Inc.16374
    public void setUnidadesMinimasPedido(Long unidadesMinimasPedido) {
        this.unidadesMinimasPedido = unidadesMinimasPedido;
    }

    // Agregado por Sergio Platas - 27/05/2005 - Inc.16374
    public Long getUnidadesMinimasPedido() {
        return this.unidadesMinimasPedido;
    }

    /**
     *    Descripcion: Este método determina si el cliente es Activo para un 
     *    rango de periodos
     *    
     *    Implementacion:
     *    1) Determinar periodos inicial y final
     *    periodoIngreso = (cliente.periodoPrimerContacto != null) ? 
     *          cliente.periodoPrimerContacto : this.periodoDesde
     *    periodoInicial = (!(periodoIngreso.menorQue(this.periodoDesde))) ? 
     *          this.periodoDesde : periodoIngreso
     *    periodoFinal = (cliente.periodo.menorQue(this.periodoHasta)
     *                      || cliente.periodo.equals(this.periodoHasta)) ? 
     *                          cliente.periodo : this.periodoHasta
     *
     *    2) Evaluar actividad
     *    Considero contador = 0
     *    Mediante el cronograma del concurso itero entre periodoInicial y
     *    periodoFinal por cada periodo invoco al método cliente.pasoPedidos()
     *    si cliente.pasoPedidos() da false
     *    contador ++
     *    si contador > 1 entonces retorno false
     *    sino
     *    contador = 0
     *    fin
     *
     *    return true
     *    
     *  @author Sergio Platas
     *  @date 31/05/2005
     *  @param cliente
     */
    public boolean esActivo(ClientePremiacion cliente) {
        UtilidadesLog.info(
            "Concurso.esActivo(ClientePremiacion cliente):Entrada");

        // Determinar periodos inicial y final
        Periodo periodoIngreso = (cliente.getPeriodoPrimerContacto() != null)
            ? cliente.getPeriodoPrimerContacto() : this.periodoDesde;
        Periodo periodoInicial = (periodoIngreso.menorQue(this.periodoDesde))
            ? this.periodoDesde : periodoIngreso;
        Periodo periodoFinal = ((cliente.getPeriodo().menorQue(
            this.periodoHasta) ||cliente.getPeriodo().equals(this.periodoHasta))
            ? cliente.getPeriodo() : this.periodoHasta);

        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("cliente: " + cliente.getOidCliente());
          UtilidadesLog.debug("cliente.getPeriodoPrimerContacto(): " + (cliente.getPeriodoPrimerContacto()!=null?cliente.getPeriodoPrimerContacto().getOidPeriodo().toString():"nulo"));
        
          UtilidadesLog.debug("periodoIngreso: " + (periodoIngreso!=null?periodoIngreso.getOidPeriodo().toString():"nulo"));
          UtilidadesLog.debug("periodoInicial: " + (periodoInicial!=null?periodoInicial.getOidPeriodo().toString():"nulo"));
          UtilidadesLog.debug("periodoFinal: " + (periodoFinal!=null?periodoFinal.getOidPeriodo().toString():"nulo"));
        }  

        // Evaluar actividad
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;
        int noPasoPedidos = 0;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("periodo a procesar: " + periodo.getOidPeriodo()); 

            // verificar si el periodo es limite de rango
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                UtilidadesLog.debug("periodo igual al inicial");
                encontrePeriodoInicial = true;
            }

            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())) {
                UtilidadesLog.debug("periodo igual al final");
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso 
            //pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna true el Cliente ha sido activo para 
                //ese rango
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("paso pedido: " + cliente.pasoPedidos(periodo.getOidPeriodo()));
                  
                if (!cliente.pasoPedidos(periodo.getOidPeriodo())) {
                    noPasoPedidos++;
                    if (noPasoPedidos > 1) {
                        UtilidadesLog.info("Concurso.esActivo(ClientePremiacion cliente):Salida FALSE 2");
                        return false;
                    }
                } else {
                    noPasoPedidos = 0;
                }
            }
        }

        // si el rango se verifico completo y paso pedidos, todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)) {
            UtilidadesLog.info("Concurso.esActivo(ClientePremiacion cliente):Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esActivo(ClientePremiacion cliente):Salida FALSE");
            return false;
        }
    }

    public boolean getFaseCalificacion() {
        return faseCalificacion;
    }

    public void setFaseCalificacion(boolean faseCalificacion) {
        this.faseCalificacion = faseCalificacion;
    }

    public Long getCalculoPremio() {
        return this.calculoPremio;
    }

    public void setCalculoPremio(Long calculoPremio) {
        this.calculoPremio = calculoPremio;
    }

    public Integer getPeriodosEsperaParaCalculo() {
        return this.periodosEsperaParaCalculo;
    }

    public void setPeriodosEsperaParaCalculo(Integer numPeriodosEsperaCalculo){
        this.periodosEsperaParaCalculo = numPeriodosEsperaCalculo;
    }

    public Integer getPeriodosEsperaSobreCalculo() {
        return this.periodosEsperaSobreCalculo;
    }

    public void setPeriodosEsperaSobreCalculo(
        Integer periodosEsperaSobreCalculo) {
        this.periodosEsperaSobreCalculo = periodosEsperaSobreCalculo;
    }

    public BigDecimal getPorcentajeSobreVenta() {
        return this.porcentajeSobreVenta;
    }

    public void setPorcentajeSobreVenta(BigDecimal porcentajeSobreVenta) {
        this.porcentajeSobreVenta = porcentajeSobreVenta;
    }

    /**BELC300019006 desde aqui */  
    public BigDecimal getMontoMinimoMadre() {
        return this.montoMinimoMadre;
    }

    public void setMontoMinimoMadre(BigDecimal montoMinimoMadre) {
        this.montoMinimoMadre = montoMinimoMadre;
    }

    public BigDecimal getMontoMinimoHija() {
        return this.montoMinimoHija;
    }

    public void setMontoMinimoHija(BigDecimal montoMinimoHija) {
        this.montoMinimoHija = montoMinimoHija;
    }

    public BigDecimal getMontoMinimoRed() {
        return this.montoMinimoRed;
    }

    public void setMontoMinimoRed(BigDecimal montoMinimoRed) {
        this.montoMinimoRed = montoMinimoRed;
    }

    public Integer getUnidadesMinimasMadre() {
        return this.unidadesMinimasMadre;
    }

    public void setUnidadesMinimasMadre(Integer unidadesMinimasMadre) {
        this.unidadesMinimasMadre = unidadesMinimasMadre;
    }

    public Integer getUnidadesMinimasHija() {
        return this.unidadesMinimasHija;
    }

    public void setUnidadesMinimasHija(Integer unidadesMinimasHija) {
        this.unidadesMinimasHija = unidadesMinimasHija;
    }

    public Integer getUnidadesMinimasRed() {
        return this.unidadesMinimasRed;
    }

    public void setUnidadesMinimasRed(Integer unidadesMinimasRed) {
        this.unidadesMinimasRed = unidadesMinimasRed;
    }

    //----------------------------------------------------------
    public void setNumPedidoMinimoMadre(Integer numPedidoMinimoMadre) {
        this.numPedidoMinimoMadre = numPedidoMinimoMadre;
    }

    public Integer getNumPedidoMinimoMadre() {
        return this.numPedidoMinimoMadre;
    }

    public void setNumPedidoMinimoHija(Integer numPedidoMinimoHija) {
        this.numPedidoMinimoHija = numPedidoMinimoHija;
    }

    public Integer getNumPedidoMinimoHija() {
        return this.numPedidoMinimoHija;
    }

    public void setNumPedidoMinimoRed(Integer numPedidoMinimoRed) {
        this.numPedidoMinimoRed = numPedidoMinimoRed;
    }

    public Integer getNumPedidoMinimoRed() {
        return this.numPedidoMinimoRed;
    }

    /** BELC300019006 hasta aqui*/
    
    //Agregado por Sergio Platas - 09/06/2005
    //Descripcion: Este método determina si el cliente es Constante para un 
    //rango de periodos 
    public boolean esConstante(ClientePremiacion cliente) {
        UtilidadesLog.info(
            "Concurso.esConstante(ClientePremiacion cliente):Entrada");

        /*
           1)Determinar periodos inicial y final
           periodoIngreso = ( cliente.periodoPrimerContacto!=null) ? 
           cliente.periodoPrimerContacto : this.periodoDesde
           periodoInicial = (!(periodoIngreso.menorQue(this.periodoDesde))) ? 
           this.periodoDesde : periodoIngreso
           periodoFinal = (cliente.periodo.menorQue(this.periodoHasta) || 
           cliente.periodo.equals(this.periodoHasta)) ?
                                   cliente.periodo : this.periodoHasta
         */
        Periodo periodoIngreso = new Periodo();
        Periodo periodoInicial = new Periodo();
        Periodo periodoFinal = new Periodo();
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("cliente: " + cliente.getOidCliente());
          UtilidadesLog.debug("cliente.getPeriodoPrimerContacto(): " + (cliente.getPeriodoPrimerContacto()!=null?cliente.getPeriodoPrimerContacto().getOidPeriodo().toString():"nulo"));
        }  
        
        periodoIngreso = ((cliente.getPeriodoPrimerContacto() != null)
            ? cliente.getPeriodoPrimerContacto() : this.getPeriodoDesde());
        periodoInicial = ((periodoIngreso.menorQue(this.periodoDesde))
            ? this.periodoDesde : periodoIngreso);
        periodoFinal = ((cliente.getPeriodo().menorQue(this.periodoHasta) ||
            cliente.getPeriodo().equals(this.periodoHasta))
            ? cliente.getPeriodo() : this.periodoHasta);
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
          UtilidadesLog.debug("periodoIngreso: " + (periodoIngreso!=null?periodoIngreso.getOidPeriodo().toString():"nulo"));
          UtilidadesLog.debug("periodoInicial: " + (periodoInicial!=null?periodoInicial.getOidPeriodo().toString():"nulo"));
          UtilidadesLog.debug("periodoFinal: " + (periodoFinal!=null?periodoFinal.getOidPeriodo().toString():"nulo"));
        }  

        /*
          2) Evaluar constancia
          Mediante el cronograma del concurso itero entre periodoInicial y
          periodoFinal por cada periodo invoco al método cliente.
          pasoPedidos(oidPeriodo).
          Si uno de ellos retorna false el Cliente no ha sido constante para 
          ese rango y consecuentemente el método retornará false.
          
          Caso contario retornar true
        */
        Iterator crono = this.cronograma.iterator();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;

        while (crono.hasNext() && (encontrePeriodoFinal == false)) {
            Periodo periodo = (Periodo) crono.next();

            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("periodo a procesar: " + periodo.getOidPeriodo());

            // verificar si el periodo es limite de rango
            if (periodo.getOidPeriodo().equals(periodoInicial.getOidPeriodo())){
                UtilidadesLog.debug("periodo igual al inicial");
                encontrePeriodoInicial = true;
            }

            if (periodo.getOidPeriodo().equals(periodoFinal.getOidPeriodo())) {
                UtilidadesLog.debug("periodo igual al final");
                encontrePeriodoFinal = true;
            }

            // si el periodo esta en el rango, verificar si cliente paso 
            //pedidos
            if (encontrePeriodoInicial == true) {
                // Si uno de ellos retorna false el Cliente no ha sido 
                //constante para ese rango
                if (!cliente.pasoPedidos(periodo.getOidPeriodo())) {
                    UtilidadesLog.info("Concurso.esConstante(ClientePremiacion cliente):Salida FALSE 2");
                    return false;
                }
            }
        }

        // si el rango se verifico completo y paso pedidos, todo OK
        if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true)) {
            UtilidadesLog.info("Concurso.esConstante(ClientePremiacion cliente):Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("Concurso.esConstante(ClientePremiacion cliente):Salida FALSE");
            return false;
        }
    }

    //Agregado por splatas - 15/06/2005 - Inc.BELC300018548
    public boolean getRecomendacionEfectivaGerente() {
        return recomendacionEfectivaGerente;
    }

    //Agregado por splatas - 15/06/2005 - Inc.BELC300018548
    public void setRecomendacionEfectivaGerente(
        boolean recomendacionEfectivaGerente) {
        this.recomendacionEfectivaGerente = recomendacionEfectivaGerente;
    }

    //Agregado por CNoziglia - 15/06/2005
    public Double getFactorMultiplicador(Posicion pos) {
        UtilidadesLog.info(
            "Concurso.getFactorMultiplicador(Posicion pos):Entrada");

        int ciclo = productosBonificados.getProductos().size();

        for (int i = 0; i < ciclo; i++) {
            PrdBloque prdBloque = (PrdBloque) productosBonificados
                .getProductos().get(i);
            Long prodexigido = prdBloque.getOidProductoExigido();
            Long prodbonificado = pos.getPosicionPuntaje(this.oidConcurso)
                                     .getOidProductoBonificado();

            if (prodexigido.equals(prodbonificado)) {
                return prdBloque.getFactorMultiplicador();
            }
        }

        UtilidadesLog.info(
            "Concurso.getFactorMultiplicador(Posicion pos):Salida");

        return new Double(1);
    }

    //Agregado por jrivas - 2/8/2005 inc 20269
    public Long obtenerNivelPremiacionNuevas(int numeroPedidos) {
        UtilidadesLog.info(
            "Concurso.obtenerNivelPremiacionNuevas(int numeroPedidos):Entrada");
            
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Entro a  obtenerNivelPremiacionNuevas " +
            numeroPedidos);
          UtilidadesLog.debug("requisitosProgramaNuevas " +
            requisitosProgramaNuevas);
        }    

        if (this.requisitosProgramaNuevas != null) {
            UtilidadesLog.info("requisitosProgramaNuevas " +
                requisitosProgramaNuevas.length);

            int cant = this.requisitosProgramaNuevas.length;

            for (int i = 0; i < cant; i++) {
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("this.requisitosProgramaNuevas[i].getNumeroPedido() " +
                    this.requisitosProgramaNuevas[i].getNumeroPedido());

                if (this.requisitosProgramaNuevas[i].getNumeroPedido().equals(new Long(numeroPedidos))) {
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("retorno " + this.requisitosProgramaNuevas[i].getNivelPremiacion());
                        
                    UtilidadesLog.info("Concurso.obtenerNivelPremiacionNuevas "
                        +"(int numeroPedidos):Salida");

                    return this.requisitosProgramaNuevas[i]
                        .getNivelPremiacion();
                }
            }
        }

        UtilidadesLog.debug("Salgo de obtenerNivelPremiacionNuevas null");
        UtilidadesLog.info(
            "Concurso.obtenerNivelPremiacionNuevas(int numeroPedidos):Salida");

        return null;
    }

    public Long getFormaCalculo() {
        return formaCalculo;
    }

    public void setFormaCalculo(Long formaCalculo) {
        this.formaCalculo = formaCalculo;
    }

    public HashMap getVariablesVentaConcursoRanking() {
        return variablesVentaConcursoRanking;
    }

    public void setVariablesVentaConcursoRanking(
        HashMap variablesVentaConcursoRanking) {
        this.variablesVentaConcursoRanking = variablesVentaConcursoRanking;
    }

    public void setNumPeriodosEsperaCalculo(Long numPeriodosEsperaCalculo) {
        this.numPeriodosEsperaCalculo = numPeriodosEsperaCalculo;
    }

    public Long getNumPeriodosEsperaCalculo() {
        return numPeriodosEsperaCalculo;
    }

    public void setPeriodoLimiteEsperaParaCalculo(
        Periodo periodoLimiteEsperaParaCalculo) {
        this.periodoLimiteEsperaParaCalculo = periodoLimiteEsperaParaCalculo;
    }

    public Periodo getPeriodoLimiteEsperaParaCalculo() {
        return periodoLimiteEsperaParaCalculo;
    }

    public boolean getIndRanking() {
        return indRanking;
    }

    public void setIndRanking(boolean indRanking) {
        this.indRanking = indRanking;
    }

    public boolean getIndActividad() {
        return indActividad;
    }

    public void setIndActividad(boolean IndActividad) {
        this.indActividad = IndActividad;
    }

    public boolean getIndConstancia() {
        return indConstancia;
    }

    public void setIndConstancia(boolean IndConstancia) {
        this.indConstancia = IndConstancia;
    }

    public void setMontoMinimoPedidoPremiacion(
        BigDecimal montoMinimoPedidoPremiacion) {
        this.montoMinimoPedidoPremiacion = montoMinimoPedidoPremiacion;
    }

    public BigDecimal getMontoMinimoPedidoPremiacion() {
        return montoMinimoPedidoPremiacion;
    }

  public Periodo getPeriodoDesdeMultinivel()
  {
    return periodoDesdeMultinivel;
  }

  public void setPeriodoDesdeMultinivel(Periodo periodoDesdeMultinivel)
  {
    this.periodoDesdeMultinivel = periodoDesdeMultinivel;
  }

  public Periodo getPeriodoHastaMultinivel()
  {
    return periodoHastaMultinivel;
  }

  public void setPeriodoHastaMultinivel(Periodo periodoHastaMultinivel)
  {
    this.periodoHastaMultinivel = periodoHastaMultinivel;
  }


  public Periodo getPeriodoDesdeNueva()
  {
    return periodoDesdeNueva;
  }

  public void setPeriodoDesdeNueva(Periodo newPeriodoDesdeNueva)
  {
    this.periodoDesdeNueva = newPeriodoDesdeNueva;
  }
  
  public Long getHastaNivelPremiacion()
  {
    return hastaNivelPremiacion;
  }

  public void setHastaNivelPremiacion(Long hastaNivelPremiacion)
  {
    this.hastaNivelPremiacion = hastaNivelPremiacion;
  }
  

    /**
     * Jrivas INC - 77
     * 27/3/2006
     * @return boolean
     * @param sol
     */
    public boolean validarEstatusCliente(Solicitud sol) throws MareException {
        UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Entrada " + this.getOidConcurso());

        Iterator crono;
        EstatusVentaConsultoras[] estatus =  this.getEstatusVentaConsultoras();
        boolean encontrePeriodoInicial = false;
        boolean encontrePeriodoFinal = false;

        //UtilidadesLog.debug("validarEstatusCliente crono: " + crono);
        if (estatus != null) {
            for (int i = 0; i < estatus.length; i++) {
                encontrePeriodoInicial = false;
                encontrePeriodoFinal = false;
                crono = this.cronograma.iterator();
                while (crono.hasNext() && (encontrePeriodoFinal == false)) {
                    Periodo periodo = (Periodo) crono.next();
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("periodo: " + periodo.getOidPeriodo());
                      
                    //UtilidadesLog.debug("estatus[i]: " + estatus[i]);
        
                    if (periodo.getOidPeriodo().equals(estatus[i].getPeriodoDesde().getOidPeriodo())){
                       // UtilidadesLog.debug("encontrePeriodoInicial");
                        encontrePeriodoInicial = true;
                    }
        
                    if (periodo.getOidPeriodo().equals(estatus[i].getPeriodoHasta().getOidPeriodo())){
                        //UtilidadesLog.debug("encontrePeriodoFinal");
                        encontrePeriodoFinal = true;
                    }
        
                    if (encontrePeriodoInicial == true) {
                        // sapaza -- PER-SiCC-2011-0207 -- 13/04/2011
                        if (periodo.equals(sol.getPeriodo())) {
                            if (verficaEstatus(estatus[i].getOidEstatusAnterior(), periodo.calcularPeriodoAnterior(1) , sol)) {
                                UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida TRUE 13");
                                return true;
                            }
                            if(estatus[i].getOidEstatusCliente().equals(ConstantesINC.ESTATUS_FUTURO_NUEVA)) {
                                if (verficaEstatus(estatus[i].getOidEstatusAnterior(), periodo , sol)) {
                                    UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida TRUE 14");
                                    return true;
                                }
                            }    
                        } else {
                            if (verficaEstatus(estatus[i].getOidEstatusCliente(), periodo, sol)) {
                                UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida TRUE 23");
                                return true;
                            }
                        }
                    }
                }
            }                 
        } else {
            UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida TRUE 3");
            return true;
        }
        
       // if ((encontrePeriodoInicial == true) && (encontrePeriodoFinal == true))  {
        UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida FALSE 2");
        return false;
        /*} else {
            UtilidadesLog.info("Concurso.validarEstatusCliente(Solicitud sol):Salida TRUE 2");
            return true;*/
        }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   18/04/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc 22569
     */
    public boolean cumpleAmbitoGeograficoGerentes(AmbitoGeografico ambitoEntrada, Long oidGerente) {
        UtilidadesLog.info("Concurso.cumpleAmbitoGeograficoGerentes(AmbitoGeograficoambitoEntrada):Entrada " + oidGerente);
 
        if (ambitosGeograficos == null) {
            UtilidadesLog.debug("AmbitoGeografico == null");
            UtilidadesLog.info("Concurso.cumpleAmbitoGeograficoGerentes(AmbitoGeografico ambitoEntrada):Salida");

            return true;
        } else {
            if (ambitosGeograficos.length == 0) {
                UtilidadesLog.info("Concurso.cumpleAmbitoGeograficoGerentes(AmbitoGeograficoambitoEntrada):Salida =0=");

                return true;
            }
        }

        for (int i = 0; i < ambitosGeograficos.length; i++) {
            if (ambitosGeograficos[i].equalsAmbitoGerente(ambitoEntrada, oidGerente) == true) {
                UtilidadesLog.info("Concurso.cumpleAmbitoGeograficoGerentes(AmbitoGeograficoambitoEntrada):Salida TRUE");

                return true;
            }
        }

        UtilidadesLog.info("Concurso.cumpleAmbitoGeograficoGerentes(AmbitoGeograficoambitoEntrada):Salida FALSE");

        return false;
    }

    
    /**
     * Jrivas INC - 77
     * 27/3/2006
     * @return boolean
     * @param sol
     */
    private boolean verficaEstatus(Long oidEstatus, Periodo periodo, Solicitud sol) {
        UtilidadesLog.info("Concurso.verficaEstatus(Long oidEstatus, Periodo periodoCalculo):Entrada " + oidEstatus);            
        HistoricoEstatusCliente[] historicoEstatusCliente = sol.getCliente().getHistoricoEstatusCliente();
        for (int j = 0; j < historicoEstatusCliente.length; j++) {
                if (
                    (historicoEstatusCliente[j].getOidEstatus()!=null &&
                    historicoEstatusCliente[j].getOidEstatus().equals(
                    oidEstatus)) && 
                    (periodo.contenidoEn(
                    historicoEstatusCliente[j].getPeriodoInicio(),
                    historicoEstatusCliente[j].getPeriodoFin()))
                    ){
                    UtilidadesLog.info(" Concurso.verficaEstatus()Salida TRUE");
                    return true;
                }
        }
        UtilidadesLog.info(" Concurso.verficaEstatus()Salida FALSE");        
        return false;
    }
    
  
    /**
     * Agregado por dmorello, 19/01/2006
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("Concurso:");
        
        sb.append("\naccesoNivelSuperior:"
            + this.getAccesoNivelSuperior());
        sb.append("\nambitosGeograficos:"
            + this.getAmbitosGeograficos());
        sb.append("\nbaseCalculo:"
            + this.getBaseCalculo());
        sb.append("\ncalculoPremio:"
            + this.getCalculoPremio());
        sb.append("\ncomunicacionAutomatica:"
            + this.getComunicacionAutomatica());
        sb.append("\ncomunicacionEnObtencionPuntos:"
            + this.getComunicacionEnObtencionPuntos());
        sb.append("\ncronograma:"
            + this.getCronograma());
        sb.append("\ncuotaMinimaIngreso:"
            + this.getCuotaMinimaIngreso());
        sb.append("\ndiasGracia:"
            + this.getDiasGracia());
        sb.append("\ndirigidoA:"
            + this.getDirigidoA());
        sb.append("\nestatusFuturoClientes:"
            + this.getEstatusFuturoClientes());
        sb.append("\nestatusVentaConsultoras:"
            + this.getEstatusVentaConsultoras());
        sb.append("\nfactorConversion:"
            + this.getFactorConversion());
        sb.append("\nfaseCalificacion:"
            + this.getFaseCalificacion());
        sb.append("\nformaCalculo:"
            + this.getFormaCalculo());
        sb.append("\nindActividad:"
            + this.getIndActividad());
        sb.append("\nindAmbitoGeograficoCompleto:"
            + this.getIndAmbitoGeograficoCompleto());
        sb.append("\nindAnulacion:"
            + this.getIndAnulacion());
        sb.append("\nindAsistenciaCursos:"
            + this.getIndAsistenciaCursos());
        sb.append("\nindConstancia:"
            + this.getIndConstancia());
        sb.append("\nindDevolucion:"
            + this.getIndDevolucion());
        sb.append("\nindFaltantesAnunciados:"
            + this.getIndFaltantesAnunciados());
        sb.append("\nindPagoATiempo:"
            + this.getIndPagoATiempo());
        sb.append("\nindPeriodoDespachoExigido:"
            + this.getIndPeriodoDespachoExigido());
        sb.append("\nindProductosBonificados:"
            + this.getIndProductosBonificados());
        sb.append("\nindProductosExcluidos:"
            + this.getIndProductosExcluidos());
        sb.append("\nindProductosExigidos:"
            + this.getIndProductosExigidos());
        sb.append("\nindProductosValidosCompletos:"
            + this.getIndProductosValidosCompletos());
        sb.append("\nindRanking:"
            + this.getIndRanking());
        sb.append("\nmontoMinimoConcurso:"
            + this.getMontoMinimoConcurso());
        sb.append("\nmontoMinimoHija:"
            + this.getMontoMinimoHija());
        sb.append("\nmontoMinimoMadre:"
            + this.getMontoMinimoMadre());
        sb.append("\nmontoMinimoPedido:"
            + this.getMontoMinimoPedido());
        sb.append("\nmontoMinimoPedidoPremiacion:"
            + this.getMontoMinimoPedidoPremiacion());
        sb.append("\nmontoMinimoRed:"
            + this.getMontoMinimoRed());
        sb.append("\nmontosRecomendada:"
            + this.getMontosRecomendada());
        sb.append("\nmultiNivel:"
            + this.getMultiNivel());
        sb.append("\nnivelesRotatorios:"
            + this.getNivelesRotatorios());
        sb.append("\nnumeroConcurso:"
            + this.getNumeroConcurso());
        sb.append("\nnumeroMinimoPedido:"
            + this.getNumeroMinimoPedido());
        sb.append("\nnumeroMinimoPedidoRecomendada:"
            + this.getNumeroMinimoPedidoRecomendada());
        sb.append("\nnumeroPedidos:"
            + this.getNumeroPedidos());
        sb.append("\nnumeroPeriodos:"
            + this.getNumeroPeriodos());
        sb.append("\nnumeroRotaciones:"
            + this.getNumeroRotaciones());
        sb.append("\nnumPedidoMinimoHija:"
            + this.getNumPedidoMinimoHija());
        sb.append("\nnumPedidoMinimoMadre:"
            + this.getNumPedidoMinimoMadre());
        sb.append("\nnumPedidoMinimoRed:"
            + this.getNumPedidoMinimoRed());
        sb.append("\nnumPeriodosEsperaCalculo:"
            + this.getNumPeriodosEsperaCalculo());
        sb.append("\noidAccesos:"
            + this.getOidAccesos());
        sb.append("\noidCanal:"
            + this.getOidCanal());
        sb.append("\noidConcurso:"
            + this.getOidConcurso());
        sb.append("\noidMarca:"
            + this.getOidMarca());
        sb.append("\noidPais:"
            + this.getOidPais());
        sb.append("\noidTipoExigencia:"
            + this.getOidTipoExigencia());
        sb.append("\nparametrosNivelPremiacion:"
            + this.getParametrosNivelPremiacion());
        sb.append("\nparticipacionParticipantesCompleta:"
            + this.getParticipacionParticipantesCompleta());
        sb.append("\npedidoEnPeriodo:"
            + this.getPedidoEnPeriodo());
        sb.append("\nperiodoDeDespacho:"
            + this.getPeriodoDeDespacho());
        sb.append("\nperiodoDesde:"
            + this.getPeriodoDesde());
        sb.append("\nperiodoDesdeMultinivel:"
            + this.getPeriodoDesdeMultinivel());
        sb.append("\nperiodoDespacho:"
            + this.getPeriodoDespacho());
        sb.append("\nperiodoHasta:"
            + this.getPeriodoHasta());
        sb.append("\nperiodoHastaMultinivel:"
            + this.getPeriodoHastaMultinivel());
        sb.append("\nperiodoLimiteEsperaParaCalculo:"
            + this.getPeriodoLimiteEsperaParaCalculo());
        sb.append("\nperiodosEsperaParaCalculo:"
            + this.getPeriodosEsperaParaCalculo());
        sb.append("\nperiodosEsperaSobreCalculo:"
            + this.getPeriodosEsperaSobreCalculo());
        sb.append("\nporcentajeSobreVenta:"
            + this.getPorcentajeSobreVenta());
        sb.append("\npremiosAcumulativosNiveles:"
            + this.getPremiosAcumulativosNiveles());
        sb.append("\nproductosBonificados:"
            + this.getProductosBonificados());
        sb.append("\nproductosCalificar:"
            + this.getProductosCalificar());
        sb.append("\nproductosExcluidos:"
            + this.getProductosExcluidos());
        sb.append("\nproductosExcluirCalificar:"
            + this.getProductosExcluirCalificar());
        sb.append("\nproductosExigidos:"
            + this.getProductosExigidos());
        sb.append("\nproductosExigidosPremiacion:"
            + this.getProductosExigidosPremiacion());
        sb.append("\nproductosValidos:"
            + this.getProductosValidos());
        sb.append("\nprogramaNuevas:"
            + this.getProgramaNuevas());
        sb.append("\npuntajeAcumulativo:"
            + this.getPuntajeAcumulativo());
        sb.append("\npuntosAsignar:"
            + this.getPuntosAsignar());
        sb.append("\nrecomendacionEfectivaGerente:"
            + this.getRecomendacionEfectivaGerente());
        sb.append("\nrequisitosProgramaNuevas:"
            + this.getRequisitosProgramaNuevas());
        sb.append("\ntipificacionesClientesParticipantes:"
            + this.getTipificacionesClientesParticipantes());
        sb.append("\ntipoCursosExigidos:"
            + this.getTipoCursosExigidos());
        sb.append("\ntipoPremiacion:"
            + this.getTipoPremiacion());
        sb.append("\ntipoVenta:"
            + this.getTipoVenta());
        sb.append("\nultimoPeridoEvaluar:"
            + this.getUltimoPeridoEvaluar());
        sb.append("\nultimoPeriodoPremiacion:"
            + this.getUltimoPeriodoPremiacion());
        sb.append("\nunidadesMinimasHija:"
            + this.getUnidadesMinimasHija());
        sb.append("\nunidadesMinimasMadre:"
            + this.getUnidadesMinimasMadre());
        sb.append("\nunidadesMinimasPedido:"
            + this.getUnidadesMinimasPedido());
        sb.append("\nunidadesMinimasRed:"
            + this.getUnidadesMinimasRed());
        sb.append("\nvariablesVentaConcursoRanking:"
            + this.getVariablesVentaConcursoRanking());
        sb.append("\nNivelAgrupacionRanking:"
            + this.getNivelAgrupacionRanking() );

        // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
        sb.append("\nTextoRanking:"
            + this.getTextoRanking());
        
        return sb.toString();
    }

  /**
   * Creado por la inc BELC300024301
   * Obtiene los puntos por unidad parametrizados en el concurso para el 
   * producto bonificado que se este tratando. 
   * @date 04/10/06
   * @author gPineda
   */
  public Double getPuntosPorUnidad(Posicion pos)
  {
    ArrayList productosBonificados = this.getProductosBonificados().getProductos();
    int tamanio = productosBonificados.size();
    
    for(int i = 0; i < tamanio; i++){
      if( ( (PrdBloque)productosBonificados.get(i) ).getOidProductoExigido().equals(
              pos.getPosicionPuntaje( this.oidConcurso ).getOidProductoBonificado() ) ){
                return ( (PrdBloque)productosBonificados.get(i) ).getPuntosUnidad();
              }
    }
    return new Double(1);
  }


  public Long getTipoRanking()
  {
    return tipoRanking;
  }

  public void setTipoRanking(Long tipoRanking)
  {
    this.tipoRanking = tipoRanking;
  }

    public Periodo getPeriodoInicialEvaluacion()
    {
        return periodoInicialEvaluacion;
    }

    public void setPeriodoInicialEvaluacion(Periodo periodoInicialEvaluacion)
    {
        this.periodoInicialEvaluacion = periodoInicialEvaluacion;
    }

    public Periodo getPeriodoFinalEvaluacion()
    {
        return periodoFinalEvaluacion;
    }

    public void setPeriodoFinalEvaluacion(Periodo periodoFinalEvaluacion)
    {
        this.periodoFinalEvaluacion = periodoFinalEvaluacion;
    }

    public Long getNumeroPeriodosAEvaluar()
    {
        return numeroPeriodosAEvaluar;
    }

    public void setNumeroPeriodosAEvaluar(Long numeroPeriodosAEvaluar)
    {
        this.numeroPeriodosAEvaluar = numeroPeriodosAEvaluar;
    }


  public void setComunicacionDespachoAutomatico(boolean comunicacionDespachoAutomatico)
  {
    this.comunicacionDespachoAutomatico = comunicacionDespachoAutomatico;
  }


  public boolean getComunicacionDespachoAutomatico()
  {
    return comunicacionDespachoAutomatico;
  }


  public void setNivelAgrupacionRanking(Long nivelAgrupacionRanking)
  {
    this.nivelAgrupacionRanking = nivelAgrupacionRanking;
  }


  public Long getNivelAgrupacionRanking()
  {
    return nivelAgrupacionRanking;
  }

  public boolean getIndDuplaCyzone()
  {
    return indDuplaCyzone;
  }

  public void setIndDuplaCyzone(boolean indDuplaCyzone)
  {
    this.indDuplaCyzone = indDuplaCyzone;
  }

  public TipificacionCliente[] getTipificacionesClientesCalificacion()
  {
    return tipificacionesClientesCalificacion;
  }

  public void setTipificacionesClientesCalificacion(TipificacionCliente[] tipificacionesClientesCalificacion)
  {
    this.tipificacionesClientesCalificacion = tipificacionesClientesCalificacion;
  }
  
    //jrivas 25/1/2007 Cambio Dupla Cyzone
    public boolean getClienteParticipanteCalificacion(Participante cliente) {
        UtilidadesLog.info("Concurso.getClienteParticipanteCalificacion(" +
            "Participante cliente):Entrada " + cliente.getOidCliente());

        // no hay tipificaciones de clientes
        if ((this.tipificacionesClientesCalificacion == null) ||
                (this.tipificacionesClientesCalificacion.length == 0)) {
                
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
              UtilidadesLog.debug("*** tipificacionesClientesParticipantes: " +
                tipificacionesClientesCalificacion);

            UtilidadesLog.info("Concurso.getClienteParticipanteCalificacion(" +
                "Participante cliente):Salida TRUE 1");

            return true;
        }

        // comparar si la tipificacion coincide
        TipificacionCliente[] tp = cliente.getTipificacionCliente();

        for (int i = 0; i < this.tipificacionesClientesCalificacion.length;
                i++) {
            for (int j = 0; j < tp.length; j++) {
                if (this.tipificacionesClientesCalificacion[i].equals(tp[j])){
                    // coincide
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("*** Dentro del if: " + tp[j].getOidTipoCliente() + " - " + tp[j].getOidSubTipoCliente() + 
                                           " - " + tp[j].getOidTipoClasificacionCliente() + " - " + tp[j].getOidClasificacionCliente());
                    UtilidadesLog.info(
                        "Concurso.getClienteParticipanteCalificacion" +
                        "(Participante cliente):Salida TRUE 2");

                    return true;
                }
            }
        }

        // no se encontro una tipificación que coincidiera 
        UtilidadesLog.info("Concurso.getClienteParticipanteConcurso(" +
            "Participante cliente):Salida FALSE");

        return false;
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public boolean validaPeriodosDeuda(boolean verificaIgual, Periodo periodo) {
        UtilidadesLog.info("Concurso.validaPeriodosDeuda(boolean verificaIgual, Periodo periodo):Entrada");
        
        boolean validacion = false;
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("verificaIgual: " + verificaIgual);
          UtilidadesLog.debug("this.getPeriodoDeDespacho(): " + this.getPeriodoDeDespacho());
          UtilidadesLog.debug("this.getPeriodoMaxi(): " + this.getPeriodoMaxi());
          UtilidadesLog.debug("periodo: " + periodo);
        }  
        
        if(verificaIgual){
            if(this.getPeriodoDeDespacho().getCodperiodo().compareTo(periodo.getCodperiodo()) <=0 &&
               this.getPeriodoMaxi().getCodperiodo().compareTo(periodo.getCodperiodo()) >= 0){       
            /*if(this.getPeriodoDeDespacho().getFechaDesde().compareTo(periodo.getFechaDesde()) <= 0 &&
               this.getPeriodoMaxi().getFechaHasta().compareTo(periodo.getFechaHasta()) >= 0){*/
            
               validacion = true;
            }
            
        } else {
            if(this.getPeriodoDeDespacho().getCodperiodo().compareTo(periodo.getCodperiodo())<0 &&
                this.getPeriodoMaxi().getCodperiodo().compareTo(periodo.getCodperiodo()) >= 0){
            /*if(this.getPeriodoDeDespacho().getFechaDesde().compareTo(periodo.getFechaDesde()) < 0 &&
               this.getPeriodoMaxi().getFechaHasta().compareTo(periodo.getFechaHasta()) >= 0){*/
            
               validacion = true;
            }
            
        }

        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("validacion: " + validacion);
        
        UtilidadesLog.info("Concurso.validaPeriodosDeuda(boolean verificaIgual, Periodo periodo):Salida");
        return validacion;
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public boolean validaPeriodosMaximoDeuda(Periodo periodo) {
        UtilidadesLog.info("Concurso.validaPeriodosMaximoDeuda(Periodo periodo):Entrada");
        
        boolean validacion = false;
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("this.getPeriodoMaxi(): " + this.getPeriodoMaxi());
          UtilidadesLog.debug("periodo: " + periodo);
        }  

        /*if(periodo.getFechaDesde().compareTo(this.getPeriodoMaxi().getFechaDesde()) <= 0 &&
           periodo.getFechaHasta().compareTo(this.getPeriodoMaxi().getFechaHasta()) <= 0){*/
        if(periodo.getCodperiodo().compareTo(this.getPeriodoMaxi().getCodperiodo()) <= 0) {
           validacion = true;
        }
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("validacion: " + validacion);
        
        UtilidadesLog.info("Concurso.validaPeriodosMaximoDeuda(Periodo periodo):Salida");
        return validacion;
    }

  public String getNombreConcurso()
  {
    return nombreConcurso;
  }

  public void setNombreConcurso(String nombreConcurso)
  {
    this.nombreConcurso = nombreConcurso;
  }
  
  // vbongiov -- Cambio 20080809 -- 7/04/2009
  public Boolean getIndNoGeneraPunt() {return indNoGeneraPunt;}
    
  public void setIndNoGeneraPunt(Boolean indNoGeneraPunt){this.indNoGeneraPunt=indNoGeneraPunt;}
  

        public boolean getIndGeneraPuntajeRecda() {
            return indGeneraPuntajeRecda;
        }

        public void setIndGeneraPuntajeRecda(boolean indGeneraPuntajeRecda) {
            this.indGeneraPuntajeRecda = indGeneraPuntajeRecda;
        }

        public Long getConcursoPuntajeRecda() {
            return concursoPuntajeRecda;
        }

        public void setConcursoPuntajeRecda(Long concursoPuntajeRecda) {
            this.concursoPuntajeRecda = concursoPuntajeRecda;
        }

        public Double getPuntosAsignarConcuRedca()
        {
            return puntosAsignarConcuRedca;
        }

        public void setPuntosAsignarConcuRedca(Double puntosAsignarConcuRedca)
        {
            this.puntosAsignarConcuRedca = puntosAsignarConcuRedca;
        }

        public Double getFactorConversionConcursoRedca()
        {
            return factorConversionConcursoRedca;
        }

        public void setFactorConversionConcursoRedca(Double factorConversionConcursoRedca)
        {
            this.factorConversionConcursoRedca = factorConversionConcursoRedca;
        }  
        
        public Long getOidClasificacionConcurso()
        {
           return oidClasificacionConcurso;
        }

        public void setOidClasificacionConcurso(Long oidClasificacionConcurso)
        {
           this.oidClasificacionConcurso = oidClasificacionConcurso;
        }    
        
        public boolean getIndSorteo() {
          return this.indSorteo;    
        }
          
        public void setIndSorteo(boolean newIndSorteo) {
          this.indSorteo = newIndSorteo;
        }
        
        public Integer getCantidadNumerosAOtorgar(){
          return this.cantidadNumerosAOtorgar;
        }
          
        public void setCantidadNumerosAOtorgar(Integer cantidadNumerosAOtorgar){
          this.cantidadNumerosAOtorgar = cantidadNumerosAOtorgar;
        }
        
        public String getDescProducto(){
          return this.descProducto;
        }
          
        public void setDescProducto(String descProducto) {
          this.descProducto = descProducto;
        }
        
        public Long getNumPerioEspe(){
           return numPerioEspe;
        }
    
        public void setNumPerioEspe(Long numPerioEspe){
           this.numPerioEspe = numPerioEspe;
        }    
        
        public Periodo getPeriodoMaxi(){
           return periodoMaxi;
        }
        
        public void setPeriodoMaxi(Periodo periodoMaxi){
           this.periodoMaxi = periodoMaxi;
        }    

        public Long getOidValidaDeuda(){
           return oidValidaDeuda;
        }
        
        public void setOidValidaDeuda(Long oidValidaDeuda){
           this.oidValidaDeuda = oidValidaDeuda;
        }

        public void setTextoRanking(String textoRanking) {
            this.textoRanking = textoRanking;
        }
    
        public String getTextoRanking() {
            return textoRanking;
        }

    public void setSinPremioPorDefecto(boolean sinPremioPorDefecto) {
        this.sinPremioPorDefecto = sinPremioPorDefecto;
    }

    public boolean isSinPremioPorDefecto() {
        return sinPremioPorDefecto;
    }

    public void setIndTipoEvaluacion(Long indTipoEvaluacion) {
        this.indTipoEvaluacion = indTipoEvaluacion;
    }

    public Long getIndTipoEvaluacion() {
        return indTipoEvaluacion;
    }
    
    public void setPeriodoInicioDeDespacho(Periodo periodoInicioDeDespacho) {
        this.periodoInicioDeDespacho = periodoInicioDeDespacho;
    }

    public Periodo getPeriodoInicioDeDespacho() {
        return periodoInicioDeDespacho;
    }

    public void setIndDespachoPremio(Long indDespachoPremio) {
        this.indDespachoPremio = indDespachoPremio;
    }

    public Long getIndDespachoPremio() {
        return indDespachoPremio;
    }

    public void setNumeroPeriodosVinculo(Long numeroPeriodosVinculo) {
        this.numeroPeriodosVinculo = numeroPeriodosVinculo;
    }

    public Long getNumeroPeriodosVinculo() {
        return numeroPeriodosVinculo;
    }

    public void setPeriodoProceso(String periodoProceso) {
        this.periodoProceso = periodoProceso;
    }

    public String getPeriodoProceso() {
        return periodoProceso;
    }

    public void setIndExigCampAnte(boolean indExigCampAnte) {
        this.indExigCampAnte = indExigCampAnte;
    }

    public boolean isIndExigCampAnte() {
        return indExigCampAnte;
    }
    
    // sapaza -- PER-SiCC-2015-0063 -- 16/02/2015  
    public boolean validarExigCampAnterior(Solicitud sol) throws MareException {
        UtilidadesLog.info("Concurso.validarExigCampAnterior():Entrada");            
        
        DAOClientePremiacion daoClientePremiacion = new DAOClientePremiacion();
        return daoClientePremiacion.validarExigCampAnterior(sol.getOidPais(), sol.getCliente().getOidCliente(), sol.getPeriodo().getOidPeriodo());
               
    }
    
}
