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
 *
 * @date 25/04/2005
 * @author Gustavo Viñales
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;


public class ClientePremiacionConcurso extends ObjetoImprimible
    implements Serializable {
    private Long oidConcurso;
    private Long dirigidoA;
    private boolean requisitosPremiacionSuperado;
    private Periodo ultimoPeriodoEvaluado;
    private boolean rechazado;
    private Double saldoPuntos;
    private Double saldoPuntosExigidos;
    private Long oidBaseIncumplida;
    private Long totalPedidosRecomendante;
    private Long totalPedidosRecomendadas;
    private Double puntajeObtenido;
    private boolean actualizarCandidataGanadora;
    private int descalificaClientePorSolicitud;
    private BigDecimal montoPedidos;
    private long cantidadPedidos;
    private boolean indPagoEnTermino;
    private Long recomendacionesEfectivas;

    // Asociaciones
    private ArrayList recomendados;
    private ArrayList pedidosRecomendacion;
    private ArrayList premiosGanados;
    private ArrayList premiosEscogidos;
    private Gerente gerente;
    private int numeroPeriodosEvaluados;

    //jrivas 18/8/2005
    //inc 20450
    private Periodo periodoDespachoDespuesObtencion;

    // INC 20638
    private boolean descalificado;

    //INC-133 jrivas 29/6/2006
    private boolean rechazadoPeriodoDespacho;
    
    //INC-137 jrivas 6/7/2006
    private Float saldoPuntosConcurso;

    //BELC300024320 - gPineda - 18/10/2006
    private Double puntosCanjeados;
    
    // JVM, sicc20070300
    private BigDecimal puntosMeta;
    
    //jrivas 20070536 13/11/2008
    private Integer ultimaRotacion;
    private BigDecimal ultimoSaldo;
    private Integer ultimoNivel;
    
    //jrivas 10/12/2008 20080808
    private double saldoADescontar;
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    private ArrayList asignacionPremiosPendientes;
    private boolean actualizarAsignacionPremiosPendientes;
    private boolean actualizarAsignacionPremiosPendientesCierre;
    private boolean deudaPeriodoHastaConc;
    private boolean creacionAsignacionPremiosPendientesCierre;
    
    // sapaza -- Cambio 20090929 -- 23/02/2010
    private boolean deudaPeriodoValidado;
    private boolean rechazadoPeriodoDeuda;
    
    // sapaza -- PER-SiCC-2010-0403 -- 07/07/2010
    private Long oidReglaRechazada;
    
    // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
    private boolean premioDespachado;
    
    public ClientePremiacionConcurso() {
        totalPedidosRecomendante = new Long(0);
        rechazado = false;
        recomendados = new ArrayList();
        pedidosRecomendacion = new ArrayList();
        actualizarCandidataGanadora = false;
        recomendacionesEfectivas = new Long(0);
        saldoPuntos = new Double(0);
        saldoPuntosConcurso = new Float(0);
        saldoPuntosExigidos = new Double(0);

        //Cleal 19/08
        premiosEscogidos = new ArrayList();
        descalificado = false;
        montoPedidos = new BigDecimal(0);
        cantidadPedidos = 0;
        
        //jrivas 17/9/2008
        puntosMeta = new BigDecimal(0);
        
        //jrivas 10/12/2008 20080808
        saldoADescontar = 0;
        
        // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
        premioDespachado = false;
    }

    public void setActualizarCandidataGanadora(
        boolean actualizarCandidataGanadora) {
        this.actualizarCandidataGanadora = actualizarCandidataGanadora;
    }

    public boolean getActualizarCandidataGanadora() {
        return actualizarCandidataGanadora;
    }

    public void setCantidadPedidos(long cantidadPedidos) {
        this.cantidadPedidos = cantidadPedidos;
    }

    public long getCantidadPedidos() {
        return cantidadPedidos;
    }

    public void setDescalificaClientePorSolicitud(
        int descalificaClientePorSolicitud) {
        this.descalificaClientePorSolicitud = descalificaClientePorSolicitud;
    }

    public int getDescalificaClientePorSolicitud() {
        return descalificaClientePorSolicitud;
    }

    public void setDirigidoA(Long dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public Long getDirigidoA() {
        return dirigidoA;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setIndPagoEnTermino(boolean indPagoEnTermino) {
        this.indPagoEnTermino = indPagoEnTermino;
    }

    public boolean getIndPagoEnTermino() {
        return indPagoEnTermino;
    }

    public void setMontoPedidos(BigDecimal montoPedidos) {
        this.montoPedidos = montoPedidos;
    }

    public BigDecimal getMontoPedidos() {
        return montoPedidos;
    }

    public void setOidBaseIncumplida(Long oidBaseIncumplida) {
        this.oidBaseIncumplida = oidBaseIncumplida;
    }

    public Long getOidBaseIncumplida() {
        return oidBaseIncumplida;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setPedidosRecomendacion(ArrayList pedidosRecomendacion) {
        this.pedidosRecomendacion = pedidosRecomendacion;
    }

    public ArrayList getPedidosRecomendacion() {
        return pedidosRecomendacion;
    }

    public void setPremiosEscogidos(ArrayList premiosEscogidos) {
        this.premiosEscogidos = premiosEscogidos;
    }

    public ArrayList getPremiosEscogidos() {
        return premiosEscogidos;
    }

    public void setPremiosGanados(ArrayList premiosGanados) {
        this.premiosGanados = premiosGanados;
    }

    public ArrayList getPremiosGanados() {
        return premiosGanados;
    }

    public void setPuntajeObtenido(Double puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public Double getPuntajeObtenido() {
        return puntajeObtenido;
    }

    public void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }

    public boolean getRechazado() {
        return rechazado;
    }
    
    public void setRechazadoPeriodoDespacho(boolean rechazado) {
        this.rechazadoPeriodoDespacho = rechazado;
    }

    public boolean getRechazadoPeriodoDespacho() {
        return rechazadoPeriodoDespacho;
    }    

    public void setRecomendados(ArrayList recomendados) {
        this.recomendados = recomendados;
    }

    public ArrayList getRecomendados() {
        return recomendados;
    }

    public void setRequisitosPremiacionSuperado(
        boolean requisitosPremiacionSuperado) {
        this.requisitosPremiacionSuperado = requisitosPremiacionSuperado;
    }

    public boolean getRequisitosPremiacionSuperado() {
        return requisitosPremiacionSuperado;
    }

    public void setSaldoPuntos(Double saldoPuntos) {
        this.saldoPuntos = saldoPuntos;
    }

    public Double getSaldoPuntos() {
        return saldoPuntos;
    }

    public void setSaldoPuntosConcurso(Float saldoPuntosConcurso) {
        this.saldoPuntosConcurso = saldoPuntosConcurso;
    }

    public Float getSaldoPuntosConcurso() {
        return saldoPuntosConcurso;
    }


    public void setSaldoPuntosExigidos(Double saldoPuntosExigidos) {
        this.saldoPuntosExigidos = saldoPuntosExigidos;
    }

    public Double getSaldoPuntosExigidos() {
        return saldoPuntosExigidos;
    }

    public void setTotalPedidosRecomendadas(Long totalPedidosRecomendadas) {
        this.totalPedidosRecomendadas = totalPedidosRecomendadas;
    }

    public Long getTotalPedidosRecomendadas() {
        return totalPedidosRecomendadas;
    }

    public void setTotalPedidosRecomendante(Long totalPedidosRecomendante) {
        this.totalPedidosRecomendante = totalPedidosRecomendante;
    }

    public Long getTotalPedidosRecomendante() {
        return totalPedidosRecomendante;
    }

    public void setUltimoPeriodoEvaluado(Periodo newPeriodo) {
        this.ultimoPeriodoEvaluado = newPeriodo;

        //jrivas 12/8/2005
        //inc 20545
        //actualizarCandidataGanadora = true;
    }

    public Periodo getUltimoPeriodoEvaluado() {
        return ultimoPeriodoEvaluado;
    }

    /**
     *
     * Llamamos calcularPedidosValidos de cada elemento y adicionamos a suma
     * el valor retornado
     */
    public void calcularTotalPedidosRecomendados() {
        UtilidadesLog.info("ClientePremiacionConcurso." +
            "calcularTotalPedidosRecomendados():Entrada");

        long suma = 0;
        if (recomendados != null) {
            for (int i = 0; i < recomendados.size(); i++) {
                Long adding = ((ClientePremiacionRecomendado) recomendados.get(i))
                    .calcularPedidosValidos();
                if (adding != null) {
                    suma += adding.longValue();
                }
            }
        }
        totalPedidosRecomendadas = new Long(suma);
        UtilidadesLog.info("ClientePremiacionConcurso." +
            "calcularTotalPedidosRecomendados():Salida");
    }

    public Long getRecomendacionesEfectivas() {
        return recomendacionesEfectivas;
    }

    public void setRecomendacionesEfectivas(Long recomendacionesEfectivas) {
        this.recomendacionesEfectivas = recomendacionesEfectivas;
    }

    /**
     * Agregado según Inc.18505.
     * @author Sergio Platas
     * @date 16/06/2005
     *
     * @param
     * @return Float
     * RESUMEN: El objetivo es hacer el sumatorio de todos los 'montoPedidos'
     * de todos los 'pedidos'
     * de los 'recomendados'
     */
     //eliminado jrivas 31/7/2006 inc DBLG50000840
   /* public Float calcularSumaMontoPedidosValidos() {
        UtilidadesLog.info("ClientePremiacionConcurso." +
            "calcularSumaMontoPedidosValidos():Entrada");

        
        float sumatoria = 0.0F;
        int size = recomendados.size();

        for (int indice1 = 0; indice1 < size; indice1++) {
            ClientePremiacionRecomendado recomend2 = (ClientePremiacionRecomendado) recomendados.get(indice1);
            UtilidadesLog.info("recomend2 " + recomend2);
            for (int indice2 = 0; indice2 < recomend2.getPedidosRecomendacion().size() ; indice2++) {
                PedidoRecomendacion pedRec = (PedidoRecomendacion) recomend2.getPedidosRecomendacion().get(indice2);
                UtilidadesLog.info("pedRec " + pedRec);
                if (pedRec.getValido()) {
                    sumatoria = sumatoria + pedRec.getMontoPedido().floatValue();
                }
            }
        }

        UtilidadesLog.info("ClientePremiacionConcurso.calcularSumaMontoPedidosValidos():Salida " + sumatoria);

        return (new Float(sumatoria));
    }*/

    /**
     *  Agregado según Inc.19183
     *  @author Sergio Platas
     *  @date 17/06/2005
     *
     *  @param
     *  @return Integer
     *  RESUMEN: El objetivo es obtener el numero de pedidos validos de los
     *  recomendados
     */
    //eliminado jrivas 31/7/2006 inc DBLG50000840
    /*public Integer getNumPedValidos() {
        UtilidadesLog.info("ClientePremiacionConcurso.getNumPedValidos()" +
            ":Entrada");

        
        int sumatoria = 0;
        int size = recomendados.size();

        for (int indice1 = 0; indice1 < size; indice1++) {
            ClientePremiacionRecomendado recomend2 = (ClientePremiacionRecomendado) recomendados.get(indice1);

            for (int indice2 = 0; indice2 < recomend2.getPedidosRecomendacion().size(); indice2++) {
                PedidoRecomendacion pedRec = (PedidoRecomendacion) recomend2.getPedidosRecomendacion().get(indice2);
                UtilidadesLog.info("pedRec.getValido() " + pedRec.getValido());
                if (pedRec.getValido()) {
                    sumatoria += 1;
                }
            }
        }

        UtilidadesLog.info("ClientePremiacionConcurso.getNumPedValidos()" +
            ":Salida " + sumatoria);

        return (new Integer(sumatoria));
    }*/

    public int getNumeroPeriodosEvaluados() {
        return numeroPeriodosEvaluados;
    }

    public void setNumeroPeriodosEvaluados(int numeroPeriodosEvaluados) {
        this.numeroPeriodosEvaluados = numeroPeriodosEvaluados;
    }

    public Periodo getPeriodoDespachoDespuesObtencion() {
        return periodoDespachoDespuesObtencion;
    }

    public void setPeriodoDespachoDespuesObtencion(
        Periodo periodoDespachoDespuesObtencion) {
        this.periodoDespachoDespuesObtencion = periodoDespachoDespuesObtencion;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }


  public void setPuntosCanjeados(Double puntosCanjeados)
  {
    this.puntosCanjeados = puntosCanjeados;
  }


  public Double getPuntosCanjeados()
  {
    return puntosCanjeados;
  }


    public void setPuntosMeta(BigDecimal puntosMeta) {
        this.puntosMeta = puntosMeta;
    }


    public BigDecimal getPuntosMeta() {
        return puntosMeta;
    }
    
    public Integer getUltimaRotacion() {
        return ultimaRotacion;
    }

    public void setUltimaRotacion(Integer ultimaRotacion) {
        this.ultimaRotacion = ultimaRotacion;
    }

    public BigDecimal getUltimoSaldo() {
        return ultimoSaldo;
    }

    public void setUltimoSaldo(BigDecimal ultimoSaldo) {
        this.ultimoSaldo = ultimoSaldo;
    }

    public Integer getUltimoNivel() {
        return ultimoNivel;
    }

    public void setUltimoNivel(Integer ultimoNivel) {
        this.ultimoNivel = ultimoNivel;
    }
    
    public void setSaldoADescontar(double saldoADescontar) {
        this.saldoADescontar = saldoADescontar;
    }
    
    
    public double getSaldoADescontar() {
        return saldoADescontar;
    }     
    
   public void setAsignacionPremiosPendientes(ArrayList asignacionPremiosPendientes) {
       this.asignacionPremiosPendientes = asignacionPremiosPendientes;
   }

   public ArrayList getAsignacionPremiosPendientes() {
       return asignacionPremiosPendientes;
   }
   
   public boolean getActualizarAsignacionPremiosPendientes() {
       return actualizarAsignacionPremiosPendientes;
   }

   public void setActualizarAsignacionPremiosPendientes(boolean actualizarAsignacionPremiosPendientes) {
       this.actualizarAsignacionPremiosPendientes = actualizarAsignacionPremiosPendientes;
   }
   
   public boolean getActualizarAsignacionPremiosPendientesCierre() {
       return actualizarAsignacionPremiosPendientesCierre;
   }

   public void setActualizarAsignacionPremiosPendientesCierre(boolean actualizarAsignacionPremiosPendientesCierre) {
       this.actualizarAsignacionPremiosPendientesCierre = actualizarAsignacionPremiosPendientesCierre;
   }
   
   public boolean getDeudaPeriodoHastaConc() {
       return deudaPeriodoHastaConc;
   }

   public void setDeudaPeriodoHastaConc(boolean deudaPeriodoHastaConc) {
       this.deudaPeriodoHastaConc = deudaPeriodoHastaConc;
   }
   
   public boolean getCreacionAsignacionPremiosPendientesCierre() {
       return creacionAsignacionPremiosPendientesCierre;
   }

   public void setCreacionAsignacionPremiosPendientesCierre(boolean creacionAsignacionPremiosPendientesCierre) {
       this.creacionAsignacionPremiosPendientesCierre = creacionAsignacionPremiosPendientesCierre;
   }

    public void setDeudaPeriodoValidado(boolean deudaPeriodoValidado) {
        this.deudaPeriodoValidado = deudaPeriodoValidado;
    }

    public boolean isDeudaPeriodoValidado() {
        return deudaPeriodoValidado;
    }

    public void setRechazadoPeriodoDeuda(boolean rechazadoPeriodoDeuda) {
        this.rechazadoPeriodoDeuda = rechazadoPeriodoDeuda;
    }

    public boolean isRechazadoPeriodoDeuda() {
        return rechazadoPeriodoDeuda;
    }

    public void setOidReglaRechazada(Long oidReglaRechazada) {
        this.oidReglaRechazada = oidReglaRechazada;
    }

    public Long getOidReglaRechazada() {
        return oidReglaRechazada;
    }

    public void setPremioDespachado(boolean premioDespachado) {
        this.premioDespachado = premioDespachado;
    }

    public boolean isPremioDespachado() {
        return premioDespachado;
    }
}
