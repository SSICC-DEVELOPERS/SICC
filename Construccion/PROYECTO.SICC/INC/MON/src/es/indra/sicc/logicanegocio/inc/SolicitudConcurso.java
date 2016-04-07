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
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SolicitudConcurso implements Serializable {
    private Long oidConcurso;
    private boolean rechazado;
    private boolean clienteDescalificado;
    private Long tipoVinculo;
    private boolean finEvaluacion;
    private boolean indActualizaCuentaCorriente;
    private int numeroPeriodosEvaluados;
    private boolean candidataGanadora;
    private Double puntajeBonificado;
    private boolean indExigenciasCumplidas;
    private Double puntajeFaltantesNoAnunciados;
    private Double numeroPuntos;
    private HashMap listaProductosExigidos;
    private HashMap posiciones;
    private boolean actualizarPuntos;
    private Double puntosCuentaCorriente;
    private boolean crearMensaje;
    private boolean cambioTipoVinculo;
    private BigDecimal montoAcumulado;
    private Long unidadesAcumuladas;
    private boolean actualizarPuntajeRecomendacion;
    private Double puntosAcumulados;
    private boolean cuentaCorrientePuntos;
    private boolean exigenciasCumplidasEnSolicitud;
    private boolean indPeriodoCalculado;
    private int descalificaClientePorSolicitud;
    private Periodo periodoInicioVinculo;
    private Periodo periodoFinVinculo;

    //Agregado por Jrivas 30/5/2005
    private boolean actulaizarPedidoRecomendanteMultinivel;
    
    //INC-132 jrivas 28/6/2006
    private Double puntosAcumuladosCC;

    /**
     * Descripcion: contiene un hashmap con los gerentesParticipantes para cada
     * solicitud en cada concurso
     */
    private HashMap gerentesParticipantes;

    /**
     *  INC 4
     */
    private boolean actualizarPuntanjeRecomendacionGerente;

    //Agregado por Jrivas 18/7/2005
    //INC 19840
    private BigDecimal metasCliente;
    
    //jrivas 30/8/2006 DBLG5000839
    private boolean actualizarGerentesRecomendacion;
    private boolean actualizarClienteRecomendacionGerente;

    // BELC300024358 - gPineda - 18/10/2006
    private MetaTipoVenta metaTipoVenta;
    
    // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
    private boolean indAnulaPedido;
    
    // vbongiov -- 20/11/2206
    private boolean rechazadoActividadConstancia;
    
    // DBLG700000193 - gPineda - 22/11/2006
    private boolean indAnulaCandidataGanadora;
    
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    private boolean indActualizaSorteo;
    
    // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
    private boolean premioDespachado;
    
    public SolicitudConcurso() {
        puntajeBonificado = new Double(0);
        puntajeFaltantesNoAnunciados = new Double(0);
        numeroPuntos = new Double(0);
        rechazado = false;
        // vbongiov -- 20/11/2206
        rechazadoActividadConstancia = false;
        numeroPeriodosEvaluados = 0;
        clienteDescalificado = false;
        cambioTipoVinculo = false;
        tipoVinculo = ConstantesINC.TIPO_VINC_NINGUNO;
        actualizarPuntajeRecomendacion = false;
        exigenciasCumplidasEnSolicitud = false;
        candidataGanadora = false;
        indPeriodoCalculado = false;
        cuentaCorrientePuntos = false;
        descalificaClientePorSolicitud = ConstantesINC.CLIENTE_CALIFICADO;
        indExigenciasCumplidas = false;
        montoAcumulado = new BigDecimal(0);
        unidadesAcumuladas = new Long(0);
        puntosAcumulados = new Double(0);
        puntosAcumuladosCC = new Double(0);
        indActualizaCuentaCorriente = false;
        listaProductosExigidos = new HashMap();
        posiciones = new HashMap();
        actualizarPuntanjeRecomendacionGerente = false;
        actulaizarPedidoRecomendanteMultinivel = false;
        gerentesParticipantes = new HashMap();
        metasCliente = new BigDecimal(0);
        
        // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
        indAnulaPedido = false;
        
        indAnulaCandidataGanadora = false;
        
        // vbongiov -- Cambio 20080811 -- 26/08/2009
        indActualizaSorteo = false;
        
        // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
        premioDespachado = false;
    }

    public void setActualizarPuntajeRecomendacion(boolean actualizarPuntajeRecomendacion) {
        this.actualizarPuntajeRecomendacion = actualizarPuntajeRecomendacion;
    }

    public boolean getActualizarPuntajeRecomendacion() {
        return actualizarPuntajeRecomendacion;
    }

    public void setActualizarPuntanjeRecomendacionGerente(boolean actualizarPuntanjeRecomendacionGerente) {
        this.actualizarPuntanjeRecomendacionGerente = actualizarPuntanjeRecomendacionGerente;
    }

    public boolean getActualizarPuntanjeRecomendacionGerente() {
        return actualizarPuntanjeRecomendacionGerente;
    }

    public void setActualizarPuntos(boolean actualizarPuntos) {
        this.actualizarPuntos = actualizarPuntos;
    }

    public boolean getActualizarPuntos() {
        return actualizarPuntos;
    }

    public void setCambioTipoVinculo(boolean cambioTipoVinculo) {
        this.cambioTipoVinculo = cambioTipoVinculo;
    }

    public boolean getCambioTipoVinculo() {
        return cambioTipoVinculo;
    }

    public void setCandidataGanadora(boolean candidataGanadora) {
        this.candidataGanadora = candidataGanadora;
    }

    public boolean getCandidataGanadora() {
        return candidataGanadora;
    }

    public void setClienteDescalificado(boolean clienteDescalificado) {
        this.clienteDescalificado = clienteDescalificado;
    }

    public boolean getClienteDescalificado() {
        return clienteDescalificado;
    }

    public void setCrearMensaje(boolean crearMensaje) {
        this.crearMensaje = crearMensaje;
    }

    public boolean getCrearMensaje() {
        return crearMensaje;
    }

    public void setCuentaCorrientePuntos(boolean cuentaCorrientePuntos) {
        this.cuentaCorrientePuntos = cuentaCorrientePuntos;
    }

    public boolean getCuentaCorrientePuntos() {
        return cuentaCorrientePuntos;
    }

    public void setDescalificaClientePorSolicitud(int descalificaClientePorSolicitud) {
        this.descalificaClientePorSolicitud = descalificaClientePorSolicitud;
    }

    public int getDescalificaClientePorSolicitud() {
        return descalificaClientePorSolicitud;
    }

    public void setExigenciasCumplidasEnSolicitud(boolean exigenciasCumplidasEnSolicitud) {
        this.exigenciasCumplidasEnSolicitud = exigenciasCumplidasEnSolicitud;
    }

    public boolean getExigenciasCumplidasEnSolicitud() {
        return exigenciasCumplidasEnSolicitud;
    }

    public void setFinEvaluacion(boolean finEvaluacion) {
        this.finEvaluacion = finEvaluacion;
    }

    public boolean getFinEvaluacion() {
        return finEvaluacion;
    }

    /**
     * Descripcion: este metodo setea el valor del parametro participa en un gerente
     * para el concurso y la solicitud al que pertenece
     * @param participa
     * @param oidGerente
     * @author Sergio Platas
     */
    public void setGerenteParticipante(Long oidGerente, boolean participa) {
        /**
         *  1- Verifica si el elemento existe en el hashmap gerentesParticipantes con el
         *    oidGerente recibido por parametro.
         *  1.1- Si existe setea el valor del parametro 'participa' en dicho elemento.
         *  1.2- Si no existe crea un objeto de la clase Boolean y le asigna el valor del
         *    parametro participa.
         *  1.3- Agrega el objeto del punto 1.2 al hashmap con el valor del parametro oidGerente
         *    como clave
         */
        UtilidadesLog.info("SolicitudConcurso.setGerenteParticipante(Long oidGerente, boolean participa):Entrada"); 
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("gerentesParticipantes: " + gerentesParticipantes);
          UtilidadesLog.debug("oidGerente: " + oidGerente);
          UtilidadesLog.debug("participa: " + Boolean.valueOf(participa));
        }  
        
        gerentesParticipantes.put(oidGerente, Boolean.valueOf(participa));
        UtilidadesLog.info("SolicitudConcurso.setGerenteParticipante(Long oidGerente, boolean participa):Entrada");
    }

    /**
     * Descripcion: este metodo informa si un gerente participa o no en un concurso determinado.
     * @return
     * @param oidGerente
     * @author Sergio Platas
     */
    public boolean getGerenteParticipante(Gerente gerente) {
        UtilidadesLog.info("SolicitudConcurso.getGerenteParticipante(Gerente gerente):Entrada");
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("***OID Cliente: " + gerente.getOidCliente());

        boolean result = false;

        /*
           1.- Verifica si el elemento existe en el hashmap gerentesParticipantes
           con el oidGerente recibido por parametro.
           1.1.- Si existe retorna el valor de dicho elemento.
           1.2.- Si no existe crea un objeto de la clase Boolean y le asigna el valor true.
           1.3.- Agrega el objeto del punto 1.2 al hashmap con el valor del parametro
           oidGerente como clave.
           1.4.- Retorna el valor true.
         */

        //jrivas 29/6/2005
        //modificado in 19479
        if ((gerente != null) && (gerente.getOidCliente() != null)) {
            if (gerentesParticipantes.containsKey(gerente.getOidCliente())) {
                result = ((Boolean) gerentesParticipantes.get(gerente.getOidCliente())).booleanValue();
            } else {
                gerentesParticipantes.put(gerente.getOidCliente(), Boolean.TRUE);
                result = true;
            }
        } else {
            result = false;
        }

        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("***getGerenteParticipante Retorna: " + result);
          
        UtilidadesLog.info("SolicitudConcurso.getGerenteParticipante(Gerente gerente):Salida");
        return result;
    }

    public void setIndActualizaCuentaCorriente(boolean indActualizaCuentaCorriente) {
        this.indActualizaCuentaCorriente = indActualizaCuentaCorriente;
    }

    public boolean getIndActualizaCuentaCorriente() {
        return indActualizaCuentaCorriente;
    }

    public void setIndExigenciasCumplidas(boolean indExigenciasCumplidas) {
        this.indExigenciasCumplidas = indExigenciasCumplidas;
    }

    public boolean getIndExigenciasCumplidas() {
        return indExigenciasCumplidas;
    }

    public void setIndPeriodoCalculado(boolean indPeriodoCalculado) {
        this.indPeriodoCalculado = indPeriodoCalculado;
    }

    public boolean getIndPeriodoCalculado() {
        return indPeriodoCalculado;
    }

    public void setListaProductosExigidos(HashMap listaProductosExigidos) {
        this.listaProductosExigidos = listaProductosExigidos;
    }

    public HashMap getListaProductosExigidos() {
        return listaProductosExigidos;
    }

    public void setMontoAcumulado(BigDecimal montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public BigDecimal getMontoAcumulado() {
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("montoAcumulado: " + montoAcumulado);
        return montoAcumulado;
    }

    /**
     *
     * @return
     */
    public BigDecimal getMontoValido() throws MareException {
        UtilidadesLog.info("SolicitudConcurso.getMontoValido():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        BigDecimal montoValido = new BigDecimal(0);
        
        // vbongiov -- 02/08/2006 -- inc DBLG500001055
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(this.oidConcurso);

        while (pos.hasNext()) {            
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            
            // vbongiov -- 02/08/2006 -- inc DBLG500001055
            if(!concurso.getIndRanking() || (concurso.getIndRanking() && !posicionPuntaje.isRechazada())){
                if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug("posicionPuntaje.getOidPosicion(): " + posicionPuntaje.getOidPosicion());
                  UtilidadesLog.debug("posicionPuntaje.getMontoValido(): " + posicionPuntaje.getMontoValido());
                  UtilidadesLog.debug("posicionPuntaje.getUnidadesValidas(): " + posicionPuntaje.getUnidadesValidas());            
                }   
                
                montoValido = montoValido.add(posicionPuntaje.getMontoValido());
            }
        }
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("montoValido: " + montoValido);
          
        UtilidadesLog.info("SolicitudConcurso.getMontoValido():Salida");
        return montoValido;
    }

    public void setNumeroPeriodosEvaluados(int numeroPeriodosEvaluados) {
        this.numeroPeriodosEvaluados = numeroPeriodosEvaluados;
    }

    public int getNumeroPeriodosEvaluados() {
        return numeroPeriodosEvaluados;
    }

    public void setNumeroPuntos(Double numeroPuntos) {
        this.numeroPuntos = numeroPuntos;
    }

    public Double getNumeroPuntos() {
        return numeroPuntos;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setPeriodoFinVinculo(Periodo periodoFinVinculo) {
        this.periodoFinVinculo = periodoFinVinculo;
    }

    public Periodo getPeriodoFinVinculo() {
        return periodoFinVinculo;
    }

    public void setPeriodoInicioVinculo(Periodo periodoInicioVinculo) {
        this.periodoInicioVinculo = periodoInicioVinculo;
    }

    public Periodo getPeriodoInicioVinculo() {
        return periodoInicioVinculo;
    }

    /*
     * Obtiene la posicionPuntaje asociada al oid de la posicion recibida
     * y si no la encuentra la crea y la retorna
     */
    public PosicionPuntaje getPosicionPuntaje(Long oidPosicion) {
        UtilidadesLog.info("SolicitudConcurso.getPosicionPuntaje(Long oidPosicion):Entrada");
        PosicionPuntaje posicionPuntaje = (PosicionPuntaje) this.posiciones.get(oidPosicion);

        if (posicionPuntaje != null) {
            UtilidadesLog.info("encontro posicionPuntaje");
            UtilidadesLog.info("SolicitudConcurso.getPosicionPuntaje(Long oidPosicion):Salida");
            return posicionPuntaje;
        } else {
            UtilidadesLog.info("creo posicionPuntaje");
            posicionPuntaje = new PosicionPuntaje(oidPosicion);
            posiciones.put(oidPosicion, posicionPuntaje);
            UtilidadesLog.info("SolicitudConcurso.getPosicionPuntaje(Long oidPosicion):Salida");
            return posicionPuntaje;
        }
    }

    public void setPosiciones(HashMap posiciones) {
        this.posiciones = posiciones;
    }

    public HashMap getPosiciones() {
        return posiciones;
    }

    public void setPuntajeBonificado(Double puntajeBonificado) {
        this.puntajeBonificado = puntajeBonificado;
    }

    public Double getPuntajeBonificado() {
        return puntajeBonificado;
    }

    public void setPuntajeFaltantesNoAnunciados(Double puntajeFaltantesNoAnunciados) {
        this.puntajeFaltantesNoAnunciados = puntajeFaltantesNoAnunciados;
    }

    public Double getPuntajeFaltantesNoAnunciados() {
        return puntajeFaltantesNoAnunciados;
    }

    public void setPuntosAcumulados(Double puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public Double getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumuladosCC(Double puntosAcumuladosCC) {
        this.puntosAcumuladosCC = puntosAcumuladosCC;
    }

    public Double getPuntosAcumuladosCC() {
        return puntosAcumuladosCC;
    }


    public Double getPuntosBonificados() throws MareException {
        UtilidadesLog.info("SolicitudConcurso.getPuntosBonificados():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        Double puntosBonificados = new Double(0);
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("getPuntosBonificados() " + puntosBonificados);
        
        // vbongiov -- 02/08/2006 -- inc DBLG500001055
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(this.oidConcurso);
        BigDecimal ceroB = new BigDecimal(0);
        Double ceroD = new Double(0);

        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("posicionPuntaje() " + posicionPuntaje);
              
            // vbongiov -- 02/08/2006 -- inc DBLG500001055
            if(!concurso.getIndRanking() || (concurso.getIndRanking() && !posicionPuntaje.isRechazada())){
                double puntosValidos = 0;
                double unidadesValidos = 0;
                
                if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug("posicionPuntaje.getOidPosicion(): " + posicionPuntaje.getOidPosicion());
                  UtilidadesLog.debug("posicionPuntaje.getFactorMultiplicadorImporteBonificado()): " + posicionPuntaje.getFactorMultiplicadorImporteBonificado());
                  UtilidadesLog.debug("posicionPuntaje.getPuntosPorUnidad(): " + posicionPuntaje.getPuntosPorUnidad());
                  UtilidadesLog.debug("posicionPuntaje.getPuntosValidos(): " + posicionPuntaje.getPuntosValidos());
                  UtilidadesLog.debug("posicionPuntaje.getUnidadesValidas(): " + posicionPuntaje.getUnidadesValidas());                
                }  
                
                if( posicionPuntaje.getFactorMultiplicadorImporteBonificado().compareTo( ceroB ) > 0 ){
                    puntosValidos = (posicionPuntaje.getPuntosValidos().doubleValue() * posicionPuntaje.getFactorMultiplicadorImporteBonificado().doubleValue());
                }
                if( posicionPuntaje.getPuntosPorUnidad().compareTo( ceroD ) > 0 ){
                    unidadesValidos = (posicionPuntaje.getUnidadesValidas().doubleValue() * posicionPuntaje.getPuntosPorUnidad().doubleValue());    
                }
                
              puntosBonificados = new Double(puntosBonificados.doubleValue() + puntosValidos + unidadesValidos);
              
              if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                UtilidadesLog.debug("PuntosBonificados parcial: " + puntosBonificados);
            }

            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("getPuntosBonificados() " + puntosBonificados);
        }
        UtilidadesLog.info("SolicitudConcurso.getPuntosBonificados():Salida");
        return puntosBonificados;
    }

    public void setPuntosCuentaCorriente(Double puntosCuentaCorriente) {
        this.puntosCuentaCorriente = puntosCuentaCorriente;
    }

    public Double getPuntosCuentaCorriente() {
        return puntosCuentaCorriente;
    }

    public Double getPuntosExigidos() {
        UtilidadesLog.info("SolicitudConcurso.getPuntosExigidos():Entrada");
        Collection col = this.listaProductosExigidos.values();
        Iterator pos = col.iterator();
        Double puntosPedido = new Double(0);

        while (pos.hasNext()) {
            ProductoExigido  productoExigido  = (ProductoExigido) pos.next();
            
            // sapaza -- SIN-RCR-20131003 AJUSTE CALCULAR PUNTAJE CONSULTORAS -- 03/10/2013
            puntosPedido = new Double(puntosPedido.doubleValue() + productoExigido.getPuntosSolicitud().doubleValue());
        }
        UtilidadesLog.info("SolicitudConcurso.getPuntosExigidos():Salida");
        return puntosPedido;
    }

    public Double getPuntosExigidosSolicitud() {
        UtilidadesLog.info("SolicitudConcurso.getPuntosExigidosSolicitud():Entrada");
        Collection col = this.listaProductosExigidos.values();
        Iterator pos = col.iterator();
        Double puntosSolicitud = new Double(0);

        while (pos.hasNext()) {
            ProductoExigido  productoExigido  = (ProductoExigido) pos.next();
            puntosSolicitud = new Double(puntosSolicitud.doubleValue() + productoExigido.getPuntosSolicitud().doubleValue());
        }
        UtilidadesLog.info("SolicitudConcurso.getPuntosExigidosSolicitud():Salida");
        return puntosSolicitud;
    }

    public Double getPuntosFaltantesNoAnunciados() {
        UtilidadesLog.info("SolicitudConcurso.getPuntosFaltantesNoAnunciados():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        Double puntajeFaltanteNoAnunciado = new Double(0);

        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            puntajeFaltanteNoAnunciado = new Double(puntajeFaltanteNoAnunciado.doubleValue() +
                                                    posicionPuntaje.getPuntajeFaltanteNoAnunciado().doubleValue());
        }
        UtilidadesLog.info("SolicitudConcurso.getPuntosFaltantesNoAnunciados():Salida");
        return puntajeFaltanteNoAnunciado;
    }

    public Double getPuntosValidos() throws MareException {
        UtilidadesLog.info("SolicitudConcurso.getPuntosValidos():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        Double puntosValidos = new Double(0);
        
        // vbongiov -- 02/08/2006 -- inc DBLG500001055
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(this.oidConcurso);

        while (pos.hasNext()) {
            
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            
            // vbongiov -- 02/08/2006 -- inc DBLG500001055
            if(!concurso.getIndRanking() || (concurso.getIndRanking() && !posicionPuntaje.isRechazada())){
                if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug("posicionPuntaje.getOidPosicion(): " + posicionPuntaje.getOidPosicion());
                  UtilidadesLog.debug("posicionPuntaje.getPuntosValidos(): " + posicionPuntaje.getPuntosValidos());
                }  
                
                puntosValidos = new Double(puntosValidos.doubleValue() + posicionPuntaje.getPuntosValidos().doubleValue());
                
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug("PuntosValidos parciales: " + puntosValidos);
            }
        }
        UtilidadesLog.info("SolicitudConcurso.getPuntosValidos():Salida");
        return puntosValidos;
    }

    public void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }

    public boolean getRechazado() {
        return rechazado;
    }

    public void setTipoVinculo(Long tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public Long getTipoVinculo() {
        return tipoVinculo;
    }

    public void setGerentesParticipantes(HashMap gerentesParticipantes) {
        this.gerentesParticipantes = gerentesParticipantes;
    }

    public HashMap getGerentesParticipantes() {
        return gerentesParticipantes;
    }

    public void setActulaizarPedidoRecomendanteMultinivel(boolean actulaizarPedidoRecomendanteMultinivel) {
        this.actulaizarPedidoRecomendanteMultinivel = actulaizarPedidoRecomendanteMultinivel;
    }

    public boolean getActulaizarPedidoRecomendanteMultinivel() {
        return actulaizarPedidoRecomendanteMultinivel;
    }

    public void setUnidadesAcumuladas(Long unidadesAcumuladas) {
        this.unidadesAcumuladas = unidadesAcumuladas;
    }

    public Long getUnidadesAcumuladas() {
        return unidadesAcumuladas;
    }

    public Long getUnidadesValidas() throws MareException {
        UtilidadesLog.info("SolicitudConcurso.getUnidadesValidas():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        Long unidadesValidas = new Long(0);
        
        // vbongiov -- 02/08/2006 -- inc DBLG500001055
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(this.oidConcurso);

        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            
            // vbongiov -- 02/08/2006 -- inc DBLG500001055
            if(!concurso.getIndRanking() || (concurso.getIndRanking() && !posicionPuntaje.isRechazada())){
                unidadesValidas = new Long(unidadesValidas.longValue() + posicionPuntaje.getUnidadesValidas().longValue());
            }
        }
        UtilidadesLog.info("SolicitudConcurso.getUnidadesValidas():Salida");
        return unidadesValidas;
    }

    /*
     * Busca en el hashmap el producto exigido uitlizando como key el oidProductoExigido
     * Se agrega indDevolucion (CAMBIO ANUL_DEVO) gPineda - 30/10/2006
     */
    public void addProductoExigido(Long oidProductoExigido, BigDecimal montoSolicitud, Long unidadesSolicitud, Double puntosSolicitud, boolean valorAnterior, boolean indDevolucion) {
        UtilidadesLog.info("SolicitudConcurso.addProductoExigido(Long oidProductoExigido, BigDecimal montoSolicitud, Long unidadesSolicitud, Double puntosSolicitud):Entrada");
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("SolicitudConcurso.addProductoExigido() " + oidProductoExigido );        
          UtilidadesLog.debug("montoSolicitud " + montoSolicitud + " unidadesSolicitud " + unidadesSolicitud + " puntosSolicitud " + puntosSolicitud );        
        }
        
        ProductoExigido productoExigido = (ProductoExigido) listaProductosExigidos.get(oidProductoExigido);
        
        if (productoExigido != null) {
            // acumula en ProductoExigido los atributos como sigue:
            productoExigido.setMontoPedido(productoExigido.getMontoPedido().add(montoSolicitud));
            productoExigido.setUnidadesPedido(new Long(productoExigido.getUnidadesPedido().longValue() + unidadesSolicitud.longValue()));
            productoExigido.setPuntosPedido(new Double(productoExigido.getPuntosPedido().doubleValue() + puntosSolicitud.doubleValue()));

            productoExigido.setMontoSolicitud(productoExigido.getMontoSolicitud().add(montoSolicitud));
            productoExigido.setUnidadesSolicitud(new Long(productoExigido.getUnidadesSolicitud().longValue() + unidadesSolicitud.longValue()));
            productoExigido.setPuntosSolicitud(new Double(productoExigido.getPuntosSolicitud().doubleValue() + puntosSolicitud.doubleValue()));

        } else {
            // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
            // vbongiov -- 23/11/2006
            if( !indDevolucion ){
                // crea un ProductoExigido con todos sus atributos como sigue:
                productoExigido = new ProductoExigido();
                productoExigido.setOidProductoExigido(oidProductoExigido);
                productoExigido.setMontoPedido(montoSolicitud);
                productoExigido.setUnidadesPedido(unidadesSolicitud);
                productoExigido.setPuntosPedido(puntosSolicitud);
    
                //jrivas 17/8/2006 DBLG50000721
                if (valorAnterior) {
                    productoExigido.setMontoSolicitud(new BigDecimal(0));
                    productoExigido.setUnidadesSolicitud(new Long(0));
                    productoExigido.setPuntosSolicitud(new Double(0));
                } else {
                    productoExigido.setMontoSolicitud(montoSolicitud);
                    productoExigido.setUnidadesSolicitud(unidadesSolicitud);
                    productoExigido.setPuntosSolicitud(puntosSolicitud);
                }
                listaProductosExigidos.put(oidProductoExigido, productoExigido);
            }
        }
        
        if( productoExigido != null ){
          if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010  
            UtilidadesLog.debug("productoExigido.getMontoPedido() " + productoExigido.getMontoPedido() );
            UtilidadesLog.debug("productoExigido.getUnidadesPedido() " + productoExigido.getUnidadesPedido() );
            UtilidadesLog.debug("productoExigido.getPuntosSolicitud() " + productoExigido.getPuntosSolicitud() );
          }  
        }else{
          UtilidadesLog.debug("productoExigido == null ");
        }
        
        UtilidadesLog.info("SolicitudConcurso.addProductoExigido(Long oidProductoExigido, BigDecimal montoSolicitud, Long unidadesSolicitud, Double puntosSolicitud):Salida");
    }


    /**
     * Agregado por Jrivas 30/5/2005
     */
    public BigDecimal getMontoCalificacion() {
        UtilidadesLog.info("SolicitudConcurso.getMontoCalificacion():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        BigDecimal montoValido = new BigDecimal(0);

        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("posicionPuntaje.getMontoCalificacion(): " + posicionPuntaje.getMontoCalificacion());
              
            montoValido = montoValido.add(posicionPuntaje.getMontoCalificacion());
        }
        UtilidadesLog.info("SolicitudConcurso.getMontoCalificacion():Salida");
        return montoValido;
    }

    /**
     * Agregado por Jrivas 30/5/2005
     */
    public BigDecimal getMontoBonificado() throws MareException {
        UtilidadesLog.info("SolicitudConcurso.getMontoBonificado():Entrada");
        // vbongiov -- 02/08/2006 -- inc DBLG500001055
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(this.oidConcurso);
        
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        BigDecimal montoBonificado = new BigDecimal(0);
        BigDecimal posicionBonif = new BigDecimal(0);
        
        BigDecimal cero = new BigDecimal(0);
        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            // vbongiov -- 02/08/2006 -- inc DBLG500001055
            if(!concurso.getIndRanking() || (concurso.getIndRanking() && !posicionPuntaje.isRechazada())){
                // vbongiov -- 20/10/2006 -- DBLG700000049  
                posicionBonif = posicionPuntaje.getMontoValido().multiply(posicionPuntaje.getFactorMultiplicadorImporteBonificado());
                
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug(" posicionPuntaje.getMontoValido(): "+posicionPuntaje.getMontoValido() +" posicionPuntaje.getFactorMultiplicadorImporteBonificado(): "+posicionPuntaje.getFactorMultiplicadorImporteBonificado() );
                
                montoBonificado = montoBonificado.add(posicionPuntaje.getMontoValido().add(posicionBonif));
                
                if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                  UtilidadesLog.debug(" montoBonificado: " + montoBonificado );
            }
        }
        UtilidadesLog.info("SolicitudConcurso.getMontoBonificado():Salida");
        return montoBonificado;
    }

    /**
     * Agregado por Jrivas 30/5/2005
     */
    public Long getUnidadesCalificacion() {
        UtilidadesLog.info("SolicitudConcurso.getUnidadesCalificacion():Entrada");
        Collection col = this.posiciones.values();
        Iterator pos = col.iterator();
        Long unidadesCalificaci = new Long(0);

        while (pos.hasNext()) {
            PosicionPuntaje posicionPuntaje = (PosicionPuntaje) pos.next();
            unidadesCalificaci = new Long(unidadesCalificaci.longValue() + posicionPuntaje.getUnidadesCalificacion().longValue());
        }
        UtilidadesLog.info("SolicitudConcurso.getUnidadesCalificacion():Salida");
        return unidadesCalificaci;
    }

    public BigDecimal getMetasCliente() {
        return metasCliente;
    }

    public void setMetasCliente(BigDecimal metasCliente) {
        this.metasCliente = metasCliente;
    }
    
    /**
     * @author dmorello
     * @date   19/01/2006
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("SolicitudConcurso:");
        
        sb.append("\nactualizarPuntajeRecomendacion:"
            + this.getActualizarPuntajeRecomendacion());
        sb.append("\nactualizarPuntanjeRecomendacionGerente:"
            + this.getActualizarPuntanjeRecomendacionGerente());
        sb.append("\nactualizarPuntos:"
            + this.getActualizarPuntos());
        sb.append("\nactulaizarPedidoRecomendanteMultinivel:"
            + this.getActulaizarPedidoRecomendanteMultinivel());
        sb.append("\nmetasCliente:"
            + this.getMetasCliente());
        sb.append("\ncambioTipoVinculo:"
            + this.getCambioTipoVinculo());
        sb.append("\ncandidataGanadora:"
            + this.getCandidataGanadora());
        sb.append("\nclienteDescalificado:"
            + this.getClienteDescalificado());
        sb.append("\ncrearMensaje:"
            + this.getCrearMensaje());
        sb.append("\ncuentaCorrientePuntos:"
            + this.getCuentaCorrientePuntos());
        sb.append("\ndescalificaClientePorSolicitud:"
            + this.getDescalificaClientePorSolicitud());
        sb.append("\nexigenciasCumplidasEnSolicitud:"
            + this.getExigenciasCumplidasEnSolicitud());
        sb.append("\nfinEvaluacion:"
            + this.getFinEvaluacion());
        sb.append("\ngerentesParticipantes:"
            + this.getGerentesParticipantes());
        sb.append("\nindActualizaCuentaCorriente:"
            + this.getIndActualizaCuentaCorriente());
        sb.append("\nindExigenciasCumplidas:"
            + this.getIndExigenciasCumplidas());
        sb.append("\nindPeriodoCalculado:"
            + this.getIndPeriodoCalculado());
        sb.append("\nlistaProductosExigidos:"
            + this.getListaProductosExigidos());
        sb.append("\nmontoAcumulado:"
            + this.getMontoAcumulado());
        sb.append("\nnumeroPeriodosEvaluados:"
            + this.getNumeroPeriodosEvaluados());
        sb.append("\nnumeroPuntos:"
            + this.getNumeroPuntos());
        sb.append("\noidConcurso:"
            + this.getOidConcurso());
        sb.append("\nperiodoFinVinculo:"
            + this.getPeriodoFinVinculo());
        sb.append("\nperiodoInicioVinculo:"
            + this.getPeriodoInicioVinculo());
        sb.append("\nposiciones:"
            + this.getPosiciones());
        sb.append("\npuntajeBonificado:"
            + this.getPuntajeBonificado());
        sb.append("\npuntajeFaltantesNoAnunciados:"
            + this.getPuntajeFaltantesNoAnunciados());
        sb.append("\npuntosAcumulados:"
            + this.getPuntosAcumulados());
        sb.append("\npuntosCuentaCorriente:"
            + this.getPuntosCuentaCorriente());
        sb.append("\nrechazado:"
            + this.getRechazado());
        sb.append("\ntipoVinculo:"
            + this.getTipoVinculo());
        sb.append("\nunidadesAcumuladas:"
            + this.getUnidadesAcumuladas());
        sb.append("\npuntosAcumuladosCC:"
            + this.getPuntosAcumuladosCC());
        sb.append("\nrechazadoActividadConstancia:"
            + this.getRechazadoActividadConstancia());
        sb.append("\nindAnulaPedido:"
            + this.getIndAnulaPedido());
        sb.append("\nindAnulaCandidataGanadora:"
            + this.getIndAnulaCandidataGanadora());
        return sb.toString();
    }

    public boolean getActualizarGerentesRecomendacion()
    {
        return actualizarGerentesRecomendacion;
    }

    public void setActualizarGerentesRecomendacion(boolean actualizarGerentesRecomendacion)
    {
        this.actualizarGerentesRecomendacion = actualizarGerentesRecomendacion;
    }

    public boolean getActualizarClienteRecomendacionGerente()
    {
        return actualizarClienteRecomendacionGerente;
    }

    public void setActualizarClienteRecomendacionGerente(boolean actualizarClienteRecomendacionGerente)
    {
        this.actualizarClienteRecomendacionGerente = actualizarClienteRecomendacionGerente;
    }


  public void setMetaTipoVenta(MetaTipoVenta metaTipoVenta)
  {
    this.metaTipoVenta = metaTipoVenta;
  }


  public MetaTipoVenta getMetaTipoVenta()
  {
    return metaTipoVenta;
  }


  public void setIndAnulaPedido(boolean indAnulaPedido)
  {
    this.indAnulaPedido = indAnulaPedido;
  }


  public boolean getIndAnulaPedido()
  {
    return indAnulaPedido;
  }

  // vbongiov -- 20/11/2006
  public boolean getRechazadoActividadConstancia() {
    return rechazadoActividadConstancia;
  }

  public void setRechazadoActividadConstancia(boolean rechazadoActividadConstancia) {
    this.rechazadoActividadConstancia = rechazadoActividadConstancia;
  }


  public void setIndAnulaCandidataGanadora(boolean indAnulaCandidataGanadora)
  {
    this.indAnulaCandidataGanadora = indAnulaCandidataGanadora;
  }


  public boolean getIndAnulaCandidataGanadora()
  {
    return indAnulaCandidataGanadora;
  }
  
  public void setIndActualizaSorteo(boolean indActualizaSorteo) {
      this.indActualizaSorteo = indActualizaSorteo;
  }

  public boolean getIndActualizaSorteo() {
      return indActualizaSorteo;
  }

    public void setPremioDespachado(boolean premioDespachado) {
        this.premioDespachado = premioDespachado;
    }

    public boolean isPremioDespachado() {
        return premioDespachado;
    }
}
