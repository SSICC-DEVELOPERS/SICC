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
import java.sql.Date;

import java.util.Hashtable;
import java.math.BigDecimal;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;                 // JVM, sicc 20070300
import es.indra.sicc.util.CodigosError;                                         // JVM, sicc 20070300
import es.indra.sicc.util.UtilidadesError;                                      // JVM, sicc 20070300
import es.indra.sicc.util.BelcorpService;                                       // JVM, sicc 20070300

public class Solicitud extends ObjetoImprimible implements Serializable {
    private static int CANT_DECIMALES_PUNTOS = 0;
    private Long oidSolicitud;
    private Periodo periodo;
    private Cliente cliente;
    private Periodo periodoCalculo;
    private Hashtable solicitudConcursos;
    private Posicion[] posiciones;
    private Long oidCanal;
    private Long oidPais;
    private Long oidMarca;
    private Long oidAcceso;
    private boolean ordenDeCompra;
    private boolean indAnulacion;
    private boolean indDevolucion;
    private Long oidZona;
    private Date fechaDocumento;
    private Long oidIdioma;
    
    //jrivas 25/7/2006 DBLG50000902
    private BigDecimal montoAcumuladoPedido;
    private Long unidadesAcumuladasPedido;
    private Date fechaFacturacion;
    
    private BigDecimal incrementoReal;          // JVM, sicc 20070300
    private BigDecimal incremento;              // JVM, sicc 20070300
    private Double numNivelIncremento;          // JVM, sicc 20070300
    
    // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
    private String codigoTipoSolPais;

    // sapaza -- PER-SiCC-2011-0279 -- 07/06/2011
    private boolean validaReemplazo;
    
    public Solicitud() {
        solicitudConcursos = new Hashtable();
    }

    public int obtenerNumeroPeriodosEvaluados(Long oidConcurso) {
        SolicitudConcurso solCon = (SolicitudConcurso) this.solicitudConcursos.get(oidConcurso);

        return solCon.getNumeroPeriodosEvaluados();
    }

    public void setIndActualizaCuentaCorriente(boolean boEntrada, Long oidConcurso) {
        SolicitudConcurso solCon = (SolicitudConcurso) this.solicitudConcursos.get(oidConcurso);
        solCon.setIndActualizaCuentaCorriente(boEntrada);
    }

    /**
     * Obtiene el concursoSolicitud asociado al oid del concurso recibido
     * y si no la encuentra la crea y la retorna
     */
    public SolicitudConcurso getSolicitudConcurso(Long oidConcurso) {
        UtilidadesLog.info("Solicitud.getSolicitudConcurso(Long oidConcurso):Entrada");
        SolicitudConcurso solCon = (SolicitudConcurso) this.solicitudConcursos.get(oidConcurso);

        if (solCon != null) {
            UtilidadesLog.debug("encontro solCon");
            UtilidadesLog.info("Solicitud.getSolicitudConcurso(Long oidConcurso):Salida");
            return solCon;
        } else {
            solCon = new SolicitudConcurso();
            solCon.setOidConcurso(oidConcurso);
            
            if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("this.getCliente(): " + this.getCliente());
              UtilidadesLog.debug("this.getCliente().getAmbitoGeografico(): " + this.getCliente().getAmbitoGeografico());
            }
            
            //Julian 5/08/2005
            if ((this.getCliente() != null) && (this.getCliente().getAmbitoGeografico() != null)) {
                solCon.getGerenteParticipante(this.getCliente().getAmbitoGeografico().getLider());
                solCon.getGerenteParticipante(this.getCliente().getAmbitoGeografico().getGerenteRegion());
                solCon.getGerenteParticipante(this.getCliente().getAmbitoGeografico().getGerenteZona());
                solCon.getGerenteParticipante(this.getCliente().getAmbitoGeografico().getSubgerente());
            }

            //Julian 5/08/2005
            this.solicitudConcursos.put(oidConcurso, solCon);
            UtilidadesLog.debug("creo nuevo solCon");
            UtilidadesLog.info("Solicitud.getSolicitudConcurso(Long oidConcurso):Salida");
            return solCon;
        }
    }

    public boolean getDentroPeriodo(Periodo periodoInicio, Periodo periodoHasta) {
        return periodo.contenidoEn(periodoInicio, periodoHasta);
    }

    public boolean getRechazado(Long oidConcurso) {
        boolean retorna = getSolicitudConcurso(oidConcurso).getRechazado();

        return retorna;
    }

    public void setRechazado(Long oidConcurso) {
        UtilidadesLog.info("Solicitud.setRechazado(Long oidConcurso):Entrada");
        UtilidadesLog.debug("rechazado: " + oidConcurso);
        getSolicitudConcurso(oidConcurso).setRechazado(true);
        UtilidadesLog.info("Solicitud.setRechazado(Long oidConcurso):Salida");
    }

    /**
     * este metodo indica si el cliente se encuentra descalificado para el concurso.
     */
    public boolean getDescalificado(Long oidConcurso) {
        SolicitudConcurso solCon = (SolicitudConcurso) solicitudConcursos.get(oidConcurso);

        return solCon.getClienteDescalificado();
    }

    public Long getOidSolicitud() {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long oidSolicitud) {
        this.oidSolicitud = oidSolicitud;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Periodo getPeriodoCalculo() {
        return periodoCalculo;
    }

    public void setPeriodoCalculo(Periodo periodoCalculo) {
        this.periodoCalculo = periodoCalculo;
    }

    public Hashtable getSolicitudConcursos() {
        return solicitudConcursos;
    }

    public void setSolicitudConcursos(Hashtable solicitudConcursos) {
        this.solicitudConcursos = solicitudConcursos;
    }

    public Posicion[] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(Posicion[] posiciones) {
        this.posiciones = posiciones;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
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

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public boolean getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(boolean ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
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

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    //jrivas 18/7/2005
    //Inc 19840

    /**
     * Descripcion: valida si el cliente de la solicitud cumple con las metas establecidas.
     * Autor: Jrivas
     * fecha 18/7/2005
     */
    public Double getPuntosFaltantesMeta(Concurso con) throws MareException {
        //1.-
        UtilidadesLog.info("Solicitud.getPuntosFaltantesMeta(Concurso con):Entrada");
        Double saldoCuentaCorriente;
        double puntosValidosAux1;
        Double puntosValidosAux;        
        
        puntosValidosAux1 = this.getSolicitudConcurso(con.getOidConcurso()).getPuntosValidos().doubleValue() +
                            this.getSolicitudConcurso(con.getOidConcurso()).getPuntosBonificados().doubleValue();

        /*if (this.getIndAnulacion() || this.getIndDevolucion()) {
            puntosValidosAux = new Double((-1) * puntosValidosAux1);
        } else {*/
            puntosValidosAux = new Double(puntosValidosAux1);
        //}
    
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("this.getSolicitudConcurso(con.getOidConcurso()).getPuntosAcumuladosCC(): " + 
                            this.getSolicitudConcurso(con.getOidConcurso()).getPuntosAcumuladosCC());
        
        //jrivas INC-132 28/6/2006
        saldoCuentaCorriente = new Double(this.getSolicitudConcurso(con.getOidConcurso()).getPuntosAcumuladosCC().doubleValue() +
                                          puntosValidosAux.doubleValue());
                                        
        if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                        
          UtilidadesLog.debug("saldoCuentaCorriente: " + saldoCuentaCorriente);

          UtilidadesLog.debug("this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente(): " + 
                            this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente());
        }                    
        
        // ---------------------------------------------------------------------
        //  JVM, sicc 20070300, inicio de cambios
        // ---------------------------------------------------------------------        
        BigDecimal puntosVentaBase;                
        BigDecimal incrementoReal= new BigDecimal(0);         
        BigDecimal metaAsignada= new BigDecimal(0);
        BigDecimal montoMinimo = new BigDecimal(0);
        BigDecimal incremento= new BigDecimal(0);  
        BigDecimal ventaBase;                
        BigDecimal meta= new BigDecimal(0);
        Double numNivelIncremento = new Double(0); 
        
        // ---------------------------------------------------------------------
        //  JVM, sicc 20070300, inicio de cambios
        //  Se reemplaza la línea siguiente
        //    meta = this.getSolicitudConcurso(con.getOidConcurso()).getMetaTipoVenta().getValMeta();
        //  por
        //    meta = this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente(); 
        // ---------------------------------------------------------------------               
        meta = this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente(); 
        metaAsignada = meta;
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("JVM300, meta="+meta+" metaAsignada="+metaAsignada);

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;       

        if (con.getIndDuplaCyzone()){
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("JVM300, is DuplaCyZone="+con.getIndDuplaCyzone());
/*            
            if (    (this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente() == null)
                    ||
                    (this.getSolicitudConcurso(con.getOidConcurso()).getMetasCliente().doubleValue() == 0)
                ) 
*/
            if(metaAsignada.doubleValue() == 0)
            {
                    /* -------------------------------------- */
                    /* Recuperar Meta                         */
                    /* -------------------------------------- */
                    query = new StringBuffer();;
                    query.append(" SELECT M.IMP_MONT_MINI ");
                    query.append(" FROM INC_MONTO_MINIM_RANGO_CONSU M ");
                    query.append(" WHERE 1=1 ");
                    query.append(" AND M.ESTV_OID_ESTA_VENT IN ( "); 
                    query.append(" SELECT OID_ESTA_VENT ");
                    query.append(" FROM INC_ESTAT_VENTA ");
                    query.append(" WHERE COPA_OID_PARA_GRAL = " + con.getOidConcurso());
                    query.append(" AND ESTA_OID_ESTA_CLIE = 2) ");
                    
                    try {
                        rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
    
                    if(!rs.esVacio()){
                        montoMinimo = (BigDecimal) rs.getValueAt(0, "IMP_MONT_MINI");
                    }                    
                    meta = montoMinimo;         
                    if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
                      UtilidadesLog.debug("JVM300, modifica meta, meta="+meta);
            }  
            
            /* -------------------------------------- */
            /* Recuperar Incremento                   */
            /* -------------------------------------- */
            query = new StringBuffer();
            query.append(" SELECT P.NUM_NIVE NUM_NIVE, P.NUM_CANT_INIC_PUNT NUM_CANT_INIC_PUNT  ");
            query.append(" FROM INC_PARAM_NIVEL_PREMI P, ");
            query.append(" INC_PARAM_GENER_PREMI pg  ");
            query.append(" WHERE P.PAGP_OID_PARA_GENE_PREM = pg.OID_PARA_GENE_PREM ");
            query.append(" AND pg.COPA_OID_PARA_GRAL = " + con.getOidConcurso());
            query.append(" AND P.NUM_NIVE = 1 ");
            
            try {
                rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if(!rs.esVacio()){
                numNivelIncremento = new Double (rs.getValueAt(0, "NUM_NIVE").toString());
                incremento = (BigDecimal) rs.getValueAt(0, "NUM_CANT_INIC_PUNT");
            }else{
                incremento = new BigDecimal(0);
            }
            this.setIncremento(incremento);
            this.setNumNivelIncremento(numNivelIncremento);
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("JVM300,  getIncremento="+this.getIncremento()+
                                " getNumNivelIncremento="+this.getNumNivelIncremento());
            
            /* -------------------------------------- */
            /* Calcular                               */
            /* -------------------------------------- */
            ventaBase = meta;  
            
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("JVM300, ventaBase="+ventaBase+
                " con.getFactorConversion().doubleValue()="+con.getFactorConversion().doubleValue()+
                " CANT_DECIMALES_PUNTOS="+CANT_DECIMALES_PUNTOS+
                " con.getPuntosAsignar()="+con.getPuntosAsignar());
                                    
            puntosVentaBase =ventaBase.divide(
                                        new BigDecimal(
                                                        con.getFactorConversion().doubleValue()
                                                      ), 
                                                      CANT_DECIMALES_PUNTOS, 
                                                      BigDecimal.ROUND_HALF_UP 
                                    ).multiply(new BigDecimal (con.getPuntosAsignar().doubleValue()));            
            
            meta=meta.add(incremento);                                    
            
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("JVM300, meta=meta+incremento, ("+meta+")");
            
            BigDecimal saldoPuntos = new BigDecimal(saldoCuentaCorriente.doubleValue());            
            // incrementoReal.add(saldoPuntos).subtract(puntosVentaBase); 
            incrementoReal=saldoPuntos.subtract(puntosVentaBase);            
            
            if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
              UtilidadesLog.debug("JVM300, incrementoReal("+incrementoReal+") = saldoPuntos("+saldoPuntos+") - puntosVentaBase("+puntosVentaBase+")");
            
            this.setIncrementoReal(incrementoReal);
        }
        
        //2.-, Calcular                
        Double puntosMeta;      
        puntosMeta = new Double(
                                (
                                    meta.divide
                                    (
                                        new BigDecimal(
                                                        con.getFactorConversion().doubleValue()
                                                      ), 
                                                      CANT_DECIMALES_PUNTOS, 
                                                      BigDecimal.ROUND_HALF_UP 
                                    ).multiply(new BigDecimal (con.getPuntosAsignar().doubleValue()))
                                ).doubleValue());

        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                  
          UtilidadesLog.debug("JVM300, puntosMeta: " + puntosMeta);
        
        // ---------------------------------------------------------------------
        //  JVM, sicc 20070300, fin de cambios 
        // ---------------------------------------------------------------------

        Double rc = new Double(puntosMeta.doubleValue() - saldoCuentaCorriente.doubleValue());
        
        if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
          UtilidadesLog.debug("rc("+rc.toString()+") = puntosMeta("+puntosMeta.doubleValue()+") - saldoCuentaCorriente("+saldoCuentaCorriente.doubleValue()+")");
        
        UtilidadesLog.info("Solicitud.getPuntosFaltantesMeta(Concurso con):Salida");
        
        return rc;
    }
    
    /**
     * @author dmorello
     * @date   19/01/2006
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("Solicitud:");
        
        sb.append("\noidSolicitud:"
            + this.getOidSolicitud());
        sb.append("\nperiodo:"
            + this.getPeriodo());
        sb.append("\ncliente:"
            + this.getCliente());
        sb.append("\nperiodoCalculo:"
            + this.getPeriodoCalculo());
        sb.append("\nsolicitudConcursos:"
            + this.getSolicitudConcursos());
        sb.append("\nposiciones:"
            + this.getPosiciones());
        sb.append("\noidCanal:"
            + this.getOidCanal());
        sb.append("\noidPais:"
            + this.getOidPais());
        sb.append("\noidMarca:"
            + this.getOidMarca());
        sb.append("\noidAcceso:"
            + this.getOidAcceso());
        sb.append("\nordenDeCompra:"
            + this.getOrdenDeCompra());
        sb.append("\nindAnulacion:"
            + this.getIndAnulacion());
        sb.append("\nindDevolucion:"
            + this.getIndDevolucion());
        sb.append("\noidZona:"
            + this.getOidZona());
        sb.append("\nfechaDocumento:"
            + this.getFechaDocumento());
        sb.append("\nidioma:"
            + this.getOidIdioma());
        sb.append("\nmontoAcumuladoPedido:"
            + this.getMontoAcumuladoPedido());
        sb.append("\nunidadesAcumuladasPedido:"
            + this.getUnidadesAcumuladasPedido());

        return sb.toString();
    }

  public Long getOidIdioma()
  {
    return oidIdioma;
  }

  public void setOidIdioma(Long oidIdioma)
  {
    this.oidIdioma = oidIdioma;
  }

    public BigDecimal getMontoAcumuladoPedido()
    {
        return montoAcumuladoPedido;
    }

    public void setMontoAcumuladoPedido(BigDecimal montoAcumuladoPedido)
    {
        this.montoAcumuladoPedido = montoAcumuladoPedido;
    }

    public Long getUnidadesAcumuladasPedido()
    {
        return unidadesAcumuladasPedido;
    }

    public void setUnidadesAcumuladasPedido(Long unidadesAcumuladasPedido)
    {
        this.unidadesAcumuladasPedido = unidadesAcumuladasPedido;
    }

  public Date getFechaFacturacion() {
    return fechaFacturacion;
  }
  
  // vbongiov -- 28/08/2006 -- DBLG500000680
  public void setFechaFacturacion(Date fechaFacturacion) {
    this.fechaFacturacion = fechaFacturacion;
  }

  //vbongiov -- 20/11/2006 
  public boolean getRechazadoActividadConstancia(Long oidConcurso) {
      boolean retorna = getSolicitudConcurso(oidConcurso).getRechazadoActividadConstancia();
  
      return retorna;
  }

  public void setRechazadoActividadConstancia(Long oidConcurso) {
      UtilidadesLog.info("Solicitud.setRechazadoActividadConstancia(Long oidConcurso):Entrada");

      if(FactoriaConcurso.getlog().isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010  
        UtilidadesLog.debug("rechazadoActividadConstancia: " + oidConcurso);
      getSolicitudConcurso(oidConcurso).setRechazadoActividadConstancia(true);
      UtilidadesLog.info("Solicitud.setRechazadoActividadConstancia(Long oidConcurso):Salida");
  }


    /*
     * JVM, sicc 20070300
     */
    public void setIncrementoReal(BigDecimal incrementoReal) {
        this.incrementoReal = incrementoReal;
    }

    /*
     * JVM, sicc 20070300
     */
    public BigDecimal getIncrementoReal() {
        return incrementoReal;
    }

    /*
     * JVM, sicc 20070300
     */
    public void setIncremento(BigDecimal incremento) {
        this.incremento = incremento;
    }

    /*
     * JVM, sicc 20070300
     */
    public BigDecimal getIncremento() {
        return incremento;
    }

    /*
     * JVM, sicc 20070300
     */
    public void setNumNivelIncremento(Double numNivelIncremento) {
        this.numNivelIncremento = numNivelIncremento;
    }

    /*
     * JVM, sicc 20070300
     */
    public Double getNumNivelIncremento() {
        return numNivelIncremento;
    }

    public void setCodigoTipoSolPais(String codigoTipoSolPais) {
        this.codigoTipoSolPais = codigoTipoSolPais;
    }

    public String getCodigoTipoSolPais() {
        return codigoTipoSolPais;
    }

    public void setValidaReemplazo(boolean validaReemplazo) {
        this.validaReemplazo = validaReemplazo;
    }

    public boolean isValidaReemplazo() {
        return validaReemplazo;
    }
}
