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
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipante;
import es.indra.sicc.dtos.inc.DTOIncrementoPorRango;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;

public class Meta {
    private BigDecimal monto;
    private Integer unidades;
    private Long baseCalculo;
    private ArrayList tablaIncremento;
    private BigDecimal incremento;
    private Long tipoIncremento;
    private Long formaCalculo;
    private Integer numPeriodoPedido;
    private Integer numPeriodoCalificacion;
    private Boolean incrementoPorNiveles;
    
     //Agregado jrivas DBLG500000255 23/05/2006
    private BigDecimal montoMinimo;
    private ArrayList lstEstatusVentaConc;
    private ArrayList lstCalificacionParticipantesConc;
    private HistoricoEstatusCliente[] arrEstatusCliente;
    private TipificacionCliente[] arrTipificacionesCliente;
    private TipificacionCliente[] arrTipificacionesConc = new TipificacionCliente[0];
    private Long dirigidoA;
    private HistoricoEstatusCliente[] arrEstatusConcurso;
    
    public Meta() {
    }

    public BigDecimal calcularMeta() throws MareException {
        /*Se llama la metodo validar para verificar que todos los datos necesarios para
         * realizar el calculo han sido seteados. */
        /*Si formaCalculo=SUMATORIA
        Si BaseCalculo=MONTOVENTA entonces
        metaTemp=monto
        Sino Si BaseCalculo=UNIDADESVENDIDAS entonces
        metaTemp=unidades

        formaCalculo=PROMEDIO
        Si BaseCalculo=MONTOVENTA entonces
        metaTemp=monto/numPeriodoCalificacion
        Sino Si BaseCalculo=UNIDADESVENDIDAS entonces
        metaTemp=unidades/numPeriodoCalificacion

        formaCalculo=FACTORIZACION
        Si BaseCalculo=MONTOVENTA entonces
        metaTemp=monto/numPeriodoPedido
        Sino Si BaseCalculo=UNIDADESVENDIDAS entonces
        metaTemp=unidades/numPeriodoPedido
        Fin Si

        return calcularIncremento(metaTemp) */
        UtilidadesLog.info("Meta.calcularMeta():Entrada");
        this.validar();

        BigDecimal metaTemp = new BigDecimal(0);
        BigDecimal montoTemp = new BigDecimal(0);
        
        if (ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.equals(this.dirigidoA)) {
            montoMinimo = this.obtenerMontoMinimoConsultoras();
        } else {
            montoMinimo = this.obtenerMontoMinimoGerentes();
        }

        if (montoMinimo.longValue() > monto.longValue()) {
            montoTemp = montoMinimo;
        } else {
            montoTemp = monto;
        }

        if (ConstantesINC.OID_FORMA_CALCULO_SUMATORIA.equals(formaCalculo)) {
            if (ConstantesINC.OID_BASE_CALCULO_MONTO.equals(baseCalculo)) {
                metaTemp = montoTemp;
            } else {
                if (ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(baseCalculo)) {
                    metaTemp = new BigDecimal(unidades.intValue());
                }
            }
        }

        if (ConstantesINC.OID_FORMA_CALCULO_PROMEDIO.equals(formaCalculo)) {
            if (ConstantesINC.OID_BASE_CALCULO_MONTO.equals(baseCalculo)) {
                metaTemp = montoTemp.divide(new BigDecimal(numPeriodoCalificacion.intValue()), 2,BigDecimal.ROUND_HALF_UP);
            } else {
                if (ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(baseCalculo)) {
                    metaTemp = new BigDecimal(unidades.intValue()).divide(new BigDecimal(numPeriodoCalificacion.intValue()),2,BigDecimal.ROUND_HALF_UP);
                }
            }
        }

        if (ConstantesINC.OID_FORMA_CALCULO_FACTORIZACION.equals(formaCalculo)) {
            if (ConstantesINC.OID_BASE_CALCULO_MONTO.equals(baseCalculo)) {
                metaTemp = montoTemp.divide(new BigDecimal(numPeriodoPedido.intValue()), 2,BigDecimal.ROUND_HALF_UP);
            } else {
                if (ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(baseCalculo)) {
                    metaTemp = new BigDecimal(unidades.intValue()).divide(new BigDecimal(numPeriodoPedido.intValue()),2, BigDecimal.ROUND_HALF_UP);
                }
            }
        }
        UtilidadesLog.info("Meta.calcularMeta():Salida");
        return this.calcularIncremento(metaTemp);
    }

    private void validar() {
        //Se realizan las siguientes validaciones en cualquier error se lanza una excepción: IllegalArgumentException 
        //1.- los campos monto, unidades, baseCaluclo, tipoIncremento, tablaIncremento, 
        //formaCalculo, numPeriodoPedido y nimPeriodoCalificacion no puede ser null 
        //2.- Si incrementoPorNiveles es true entonces se valida que tablaincremento tenga elemento 
        //Sino se valida que incremento sea diferente de NULL
        UtilidadesLog.info("Meta.validar():Entrada");
        UtilidadesLog.debug("Meta.validar() -  monto" + monto);
        UtilidadesLog.debug("Meta.validar() -  unidades" + unidades);
        UtilidadesLog.debug("Meta.validar() -  baseCalculo" + baseCalculo);
        UtilidadesLog.debug("Meta.validar() -  tipoIncremento" + tipoIncremento);
        UtilidadesLog.debug("Meta.validar() -  tablaIncremento" + tablaIncremento);
        UtilidadesLog.debug("Meta.validar() -  formaCalculo" + formaCalculo);
        UtilidadesLog.debug("Meta.validar() -  numPeriodoPedido" + numPeriodoPedido);
        UtilidadesLog.debug("Meta.validar() -  numPeriodoCalificacion" + numPeriodoCalificacion);

        UtilidadesLog.debug("meta -  incrementoPorNiveles" + incrementoPorNiveles);

        if (incrementoPorNiveles != null) {
            UtilidadesLog.debug("meta -  incrementoPorNiveles.booleanValue()" + incrementoPorNiveles.booleanValue());
        }

        UtilidadesLog.debug("meta -  tablaIncremento" + tablaIncremento);

        if (tablaIncremento != null) {
            UtilidadesLog.debug("meta -  tablaIncremento.size()" + tablaIncremento.size());
        }

        UtilidadesLog.debug("meta -  incremento" + incremento);

        if ((monto == null) || (unidades == null) || (baseCalculo == null) || (tipoIncremento == null) || (
            /*tablaIncremento== null || */ formaCalculo == null) || (numPeriodoPedido == null) || (numPeriodoCalificacion == null)) {
            throw new IllegalArgumentException("La meta no es valida");
        }

        //COMENTADO POR INCIDENCIA 21054 - Cristian Valenzuela 4/10/05
        //if ((incrementoPorNiveles != null) && incrementoPorNiveles.booleanValue()) {
            if ((tablaIncremento == null) || !(tablaIncremento.size() > 0)) {
                throw new IllegalArgumentException("La meta no es valida, tablaIncremento nula o sin valores");
            }
        /*} else {
            if (incremento == null) {
                throw new IllegalArgumentException("La meta no es valida, incremento nulo");
            }
        }*/
        UtilidadesLog.info("Meta.validar():Salida");
    }

    private BigDecimal calcularIncremento(BigDecimal cantidad) {
        /*Se crear la variable incrementoCantidad

        Si incrementoPorNiveles entonces
        se busca en el arreglo tablaIncremento el RangoIncremento que se
        conresponde con la cantidad (recibida como parametro)
        incrementoCantidad=rangoIngremento.incremento
        Sino incrementoCantidad=incremento (atributo de la clase)


        Si tipoIncremento=PORCENTAJE entonces
        return cantidad + (cantidad*incrementoCantidad/100)
        Sino Si tipoIncremento=CANTIDAD entonces
        return cantidad + incrementoCantidad*/
        UtilidadesLog.info("Meta.calcularIncremento(BigDecimal cantidad):Entrada");
        
        UtilidadesLog.debug("cantidad: " + cantidad);
        
        BigDecimal incrementoCantidad = new BigDecimal(0);
        BigDecimal cantidaARetornar = new BigDecimal(0);

        //COMENTADO POR INCIDENCIA 21054 - Cristian Valenzuela - 4/10/2005
        //if ((incrementoPorNiveles != null) && incrementoPorNiveles.booleanValue()) {
            Iterator it = tablaIncremento.iterator();

            while (it.hasNext()) {
                DTOIncrementoPorRango rango = (DTOIncrementoPorRango) it.next();

                //Esperando confirmacion de respuesta de incidencia 21155
                if(cantidad.compareTo(rango.getDesde()) >=0  &&
                   cantidad.compareTo(rango.getHasta()) <=0)  {
                    
                    incrementoCantidad = rango.getIncremento();
                    continue;
                }
                
                //COMENTADO POR INCIDENCIA 21155
                /*if (rango.getIncremento().equals(cantidad)) {
                    incrementoCantidad = rango.getIncremento();

                    continue;
                }*/
            }
        /*} else {
            incrementoCantidad = this.getIncremento();
        }*/
        this.setIncremento(incrementoCantidad);        

        if (ConstantesINC.OID_TIPO_INCREMENTO_PORCENTAJE.equals(tipoIncremento)) {
            UtilidadesLog.info("Meta.calcularIncremento(BigDecimal cantidad):Salida");
            return cantidaARetornar = cantidad.add((cantidad.multiply(incrementoCantidad)).divide(new BigDecimal(100), 2,BigDecimal.ROUND_HALF_UP));
        } else {
            if (ConstantesINC.OID_TIPO_INCREMENTO_CANTIDAD.equals(tipoIncremento)) {
                UtilidadesLog.info("Meta.calcularIncremento(BigDecimal cantidad):Salida");
                return cantidaARetornar = cantidad.add(incrementoCantidad);
            }
        }
        UtilidadesLog.info("Meta.calcularIncremento(BigDecimal cantidad):Salida");
        return cantidaARetornar;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Long getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(Long baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public ArrayList getTablaIncremento() {
        return tablaIncremento;
    }

    public void setTablaIncremento(ArrayList tablaIncremento) {
        this.tablaIncremento = tablaIncremento;
    }

    public BigDecimal getIncremento() {
        return incremento;
    }

    public void setIncremento(BigDecimal incremento) {
        this.incremento = incremento;
    }

    public Long getTipoIncremento() {
        return tipoIncremento;
    }

    public void setTipoIncremento(Long tipoIncremento) {
        this.tipoIncremento = tipoIncremento;
    }

    public Long getFormaCalculo() {
        return formaCalculo;
    }

    public void setFormaCalculo(Long formaCalculo) {
        this.formaCalculo = formaCalculo;
    }

    public Integer getNumPeriodoPedido() {
        return numPeriodoPedido;
    }

    public void setNumPeriodoPedido(Integer numPeriodoPedido) {
        this.numPeriodoPedido = numPeriodoPedido;
    }

    public Integer getNumPeriodoCalificacion() {
        return numPeriodoCalificacion;
    }

    public void setNumPeriodoCalificacion(Integer numPeriodoCalificacion) {
        this.numPeriodoCalificacion = numPeriodoCalificacion;
    }

    public Boolean isIncrementoPorNiveles() {
        return incrementoPorNiveles;
    }

    public void setIncrementoPorNiveles(Boolean incrementoPorNiveles) {
        this.incrementoPorNiveles = incrementoPorNiveles;
    }

    public BigDecimal getMontoMinimo()
    {
        return montoMinimo;
    }

    public void setMontoMinimo(BigDecimal montoMinimo)
    {
        this.montoMinimo = montoMinimo;
    }

    public ArrayList getLstEstatusVentaConc()
    {
        return lstEstatusVentaConc;
    }

    public void setLstEstatusVentaConc(ArrayList lstEstatusVentaConc)
    {
        this.lstEstatusVentaConc = lstEstatusVentaConc;
    }

    public ArrayList getLstCalificacionParticipantesConc()
    {
        return lstCalificacionParticipantesConc;
    }

    public void setLstCalificacionParticipantesConc(ArrayList lstCalificacionParticipantesConc)
    {
        this.lstCalificacionParticipantesConc = lstCalificacionParticipantesConc;
    }

    public HistoricoEstatusCliente[] getArrEstatusCliente()
    {
        return arrEstatusCliente;
    }

    public void setArrEstatusCliente(HistoricoEstatusCliente[] arrEstatusCliente)
    {
        this.arrEstatusCliente = arrEstatusCliente;
    }

    public TipificacionCliente[] getArrTipificacionesCliente()
    {
        return arrTipificacionesCliente;
    }

    public void setArrTipificacionesCliente(TipificacionCliente[] arrTipificacionesCliente)
    {
        this.arrTipificacionesCliente = arrTipificacionesCliente;
    }

    public TipificacionCliente[] getArrTipificacionesConc()
    {
        return arrTipificacionesConc;
    }

    public void setArrTipificacionesConc(TipificacionCliente[] arrTipificacionesConc)
    {
        this.arrTipificacionesConc = arrTipificacionesConc;
    }

    public Long getDirigidoA()
    {
        return dirigidoA;
    }

    public void setDirigidoA(Long dirigidoA)
    {
        this.dirigidoA = dirigidoA;
    }
    
    public HistoricoEstatusCliente[] getArrEstatusConcurso()
    {
        return arrEstatusConcurso;
    }

    public void setArrEstatusConcurso(HistoricoEstatusCliente[] arrEstatusConcurso)
    {
        this.arrEstatusConcurso = arrEstatusConcurso;
    }    
    
    public void asignarTipificacionGerente(Solicitud solicitud, Long oidGerente) {
        UtilidadesLog.info("Meta.asignarTipificacionGerente():Entrada");
        //Descripcion: busca y asigna la tipificacion del gerente recibido por parametro. 

        if (oidGerente != null && solicitud.getCliente().getAmbitoGeografico() != null) {
            if (solicitud.getCliente().getAmbitoGeografico().getSubgerente() != null && 
                    oidGerente.equals(solicitud.getCliente().getAmbitoGeografico().getSubgerente().getOidCliente())) {
                this.arrTipificacionesCliente = solicitud.getCliente().getAmbitoGeografico().getSubgerente().getTipificacionCliente(); 
            }

            if (solicitud.getCliente().getAmbitoGeografico().getGerenteRegion() != null && 
                    oidGerente.equals(solicitud.getCliente().getAmbitoGeografico().getGerenteRegion().getOidCliente())) {
                this.arrTipificacionesCliente = solicitud.getCliente().getAmbitoGeografico().getGerenteRegion().getTipificacionCliente(); 
            }

            if (solicitud.getCliente().getAmbitoGeografico().getGerenteZona() != null && 
                    oidGerente.equals(solicitud.getCliente().getAmbitoGeografico().getGerenteZona().getOidCliente())) {
                this.arrTipificacionesCliente = solicitud.getCliente().getAmbitoGeografico().getGerenteZona().getTipificacionCliente(); 
            }
            
            if (solicitud.getCliente().getAmbitoGeografico().getLider() != null && 
                    oidGerente.equals(solicitud.getCliente().getAmbitoGeografico().getLider().getOidCliente())) {
                this.arrTipificacionesCliente = solicitud.getCliente().getAmbitoGeografico().getLider().getTipificacionCliente(); 
            }            
        }
        UtilidadesLog.info("Meta.asignarTipificacionGerente():Salida");
    }
    
    public void generarArrayTipificacionesConcurso() throws MareException {
        UtilidadesLog.info("Meta.generarArrayTipificacionesConcurso():Entrada");
        RecordSet rs;
        String codigoError;

        if ((this.lstCalificacionParticipantesConc != null) &&
                (this.lstCalificacionParticipantesConc.size() > 0)) {

            StringBuffer query = new StringBuffer();
            query.append(" SELECT DISTINCT OID_PART_CONC_CABE, TICL_OID_TIPO_CLIE, SBTI_OID_SUBT_CLIE,  ");
            query.append(" TCCL_OID_TIPO_CLAS, CLAS_OID_CLAS  ");
            query.append(" FROM INC_PARTI_CONCU_CABEC PCC,  ");
            query.append(" INC_PARTI_CONCU_DETAL PCD  ");
            query.append(" WHERE PCC.OID_PART_CONC_CABE = PCD.PACI_OID_PART_CONC_CABE  ");
            query.append(" AND PCC.OID_PART_CONC_CABE IN (");
    
            DTOCalificacionParticipante registro;
            for (int j = 0; j < this.lstCalificacionParticipantesConc.size(); j++) {
                registro = (DTOCalificacionParticipante) this.lstCalificacionParticipantesConc.get(j);

                if (j < (this.lstCalificacionParticipantesConc.size() - 1)) {
                    query.append(registro.getOidParticipante().longValue() + ", ");
                } else {
                    query.append(registro.getOidParticipante().longValue());
                }
            }

            query.append(") ");            

            try {
                rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("Respuesta: " + rs);
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            TipificacionCliente tipi; 
            int cantidad = rs.getRowCount();
            this.arrTipificacionesConc = new TipificacionCliente[cantidad];
            for (int i = 0; i < cantidad; i++) {
                tipi = new TipificacionCliente();

                BigDecimal oidClasificacionCliente = (BigDecimal)rs.getValueAt(i, "CLAS_OID_CLAS");
                tipi.setOidClasificacionCliente((oidClasificacionCliente != null) ? new Long(oidClasificacionCliente.longValue()) : null);

                BigDecimal oidSubtipoCliente = (BigDecimal) rs.getValueAt(i, "SBTI_OID_SUBT_CLIE");
                tipi.setOidSubTipoCliente((oidSubtipoCliente != null)? new Long(oidSubtipoCliente.longValue()) : null);

                BigDecimal oidTipoClasificacionCliente = (BigDecimal)rs.getValueAt(i, "TCCL_OID_TIPO_CLAS");
                tipi.setOidTipoClasificacionCliente((oidTipoClasificacionCliente != null)? new Long(oidTipoClasificacionCliente.longValue()) : null);

                tipi.setOidTipoCliente(new Long(((BigDecimal)rs.getValueAt(i, "TICL_OID_TIPO_CLIE")).longValue()));
                
                tipi.setOidParticipante(new Long(((BigDecimal)rs.getValueAt(i, "OID_PART_CONC_CAB")).longValue()));

                this.arrTipificacionesConc[i] = tipi;
            }
        }
        UtilidadesLog.info("Meta.generarArrayTipificacionesConcurso():Salida arrTipificacionesConc " + this.arrTipificacionesConc);
    }
    
    public BigDecimal obtenerMontoMinimoConsultoras() throws MareException {
        UtilidadesLog.info("Meta.obtenerMontoMinimoConsultoras():Entrada");        
        BigDecimal menorMontoMinimo = new BigDecimal(0);            
        TipificacionCliente[] arrTipifObjetivo;
        HistoricoEstatusCliente[] arrEstatusObjetivo;
        this.generarArrayTipificacionesConcurso();
        this.generarArrayEstatusConcurso();
        arrTipifObjetivo = this.obtenerTipificacionesObjetivo();
        arrEstatusObjetivo = this.obtenerEstatusObjetivo();
        if (arrTipifObjetivo.length > 0 && arrEstatusObjetivo.length > 0) {
            menorMontoMinimo = this.buscaMontoMinimo(arrTipifObjetivo[0].getOidParticipante(), arrEstatusObjetivo[0].getOidEstatus());

            BigDecimal montoMinimo;
            for (int i = 0; i < arrTipifObjetivo.length; i++) {
                for (int j = 0; j < arrEstatusObjetivo.length; j++) {
                    montoMinimo = this.buscaMontoMinimo(arrTipifObjetivo[i].getOidParticipante(), arrEstatusObjetivo[j].getOidEstatus());
                    if (montoMinimo.longValue() < menorMontoMinimo.longValue()) {
                        menorMontoMinimo = montoMinimo;
                    }
                }
            }
        }
        UtilidadesLog.info("Meta.obtenerMontoMinimoConsultoras():Salida " + menorMontoMinimo);        
        return menorMontoMinimo;
    }
    
    public TipificacionCliente[] obtenerTipificacionesObjetivo() {
        UtilidadesLog.info("Meta.obtenerTipificacionesObjetivo():Entrada");
        int tipificacionesConc = this.arrTipificacionesConc.length;
        int tipificacionesClie = this.arrTipificacionesCliente.length;
        UtilidadesLog.debug("obtenerTipificacionesObjetivo arrTipificacionesConc: " + tipificacionesConc);
        UtilidadesLog.debug("obtenerTipificacionesObjetivo arrTipificacionesCliente: " + tipificacionesClie);        
        ArrayList aux = new ArrayList();
        for (int i = 0; i < tipificacionesConc; i++) {
            for (int j = 0; j < tipificacionesClie; j++) {
                UtilidadesLog.debug("1: " + this.arrTipificacionesConc[i].getOidClasificacionCliente());
                UtilidadesLog.debug("1: " + this.arrTipificacionesConc[i].getOidSubTipoCliente());
                UtilidadesLog.debug("1: " + this.arrTipificacionesConc[i].getOidTipoClasificacionCliente());
                UtilidadesLog.debug("1: " + this.arrTipificacionesConc[i].getOidTipoCliente());
                UtilidadesLog.debug("2: " + this.arrTipificacionesCliente[j].getOidClasificacionCliente());
                UtilidadesLog.debug("2: " + this.arrTipificacionesCliente[j].getOidSubTipoCliente());
                UtilidadesLog.debug("2: " + this.arrTipificacionesCliente[j].getOidTipoClasificacionCliente());
                UtilidadesLog.debug("2: " + this.arrTipificacionesCliente[j].getOidTipoCliente());
                if (this.arrTipificacionesConc[i].equals(this.arrTipificacionesCliente[j])) {
                    UtilidadesLog.debug("nuevo tipif");    
                    aux.add(arrTipificacionesConc[i]);
                }
            }        
        }
        TipificacionCliente[] arrTipifObjetivo = new TipificacionCliente[aux.size()];
        aux.toArray(arrTipifObjetivo);
        UtilidadesLog.info("Meta.obtenerTipificacionesObjetivo():Salida arrTipifObjetivo " + arrTipifObjetivo.length);
        return arrTipifObjetivo;
    }
    
    public HistoricoEstatusCliente[] obtenerEstatusObjetivo() {
        UtilidadesLog.info("Meta.obtenerEstatusObjetivo():Entrada");
        HistoricoEstatusCliente[] arrEstatusObjetivo;
        ArrayList aux = new ArrayList();
        int cantConcu = arrEstatusConcurso.length;    
        int cantClie = arrEstatusCliente.length;
        UtilidadesLog.debug("obtenerEstatusObjetivo arrEstatusConcurso : " + cantConcu + "arrEstatusCliente : " + cantClie);
        for (int i = 0; i < cantConcu; i++) {
            for (int j = 0; j < cantClie; j++) {
                UtilidadesLog.debug("1: " + this.arrEstatusConcurso[i].getOidEstatus());
                UtilidadesLog.debug("1: " + this.arrEstatusConcurso[i].getPeriodoInicio());
                UtilidadesLog.debug("1: " + this.arrEstatusConcurso[i].getPeriodoFin());
                UtilidadesLog.debug("2: " + this.arrEstatusCliente[j].getOidEstatus());
                UtilidadesLog.debug("2: " + this.arrEstatusCliente[j].getPeriodoInicio());
                UtilidadesLog.debug("2: " + this.arrEstatusCliente[j].getPeriodoFin());
                if (arrEstatusConcurso[i].equals(arrEstatusCliente[j])) {
                    UtilidadesLog.debug("nuevo estatus");            
                    aux.add(arrEstatusConcurso[i]);
                }
            }
        }
        arrEstatusObjetivo = (HistoricoEstatusCliente[]) aux.toArray(new HistoricoEstatusCliente[aux.size()]);
        UtilidadesLog.info("Meta.obtenerEstatusObjetivo():Salida arrEstatusObjetivo " + arrEstatusObjetivo.length);
        return arrEstatusObjetivo;
    }
    
    public BigDecimal obtenerMontoMinimoGerentes() throws MareException {
        UtilidadesLog.info("Meta.obtenerMontoMinimoGerentes():Entrada");
        BigDecimal menorMontoMinimo = new BigDecimal(0);            
        TipificacionCliente[] arrTipifObjetivo;
        this.generarArrayTipificacionesConcurso();
        arrTipifObjetivo = this.obtenerTipificacionesObjetivo();

        if (arrTipifObjetivo.length > 0) {
            menorMontoMinimo = this.buscaMontoMinimo(arrTipifObjetivo[0].getOidParticipante(), null);
    
            BigDecimal montoMinimo;
            for (int i = 1; i < arrTipifObjetivo.length; i++) {
                montoMinimo = this.buscaMontoMinimo(arrTipifObjetivo[i].getOidParticipante(), null);
                if (montoMinimo.longValue() < menorMontoMinimo.longValue()) {
                    menorMontoMinimo = montoMinimo;
                }
            }
        }
        UtilidadesLog.info("Meta.obtenerMontoMinimoGerentes():Salida " + menorMontoMinimo);
        return menorMontoMinimo;
    }
    
    public BigDecimal buscaMontoMinimo(Long oidParticipante, Long oidEstatus) {
        UtilidadesLog.info("Meta.buscaMontoMinimo():Entrada");
        Iterator it = this.lstCalificacionParticipantesConc.iterator();
        while (it.hasNext()) {
            DTOCalificacionParticipante listaPartic = (DTOCalificacionParticipante)it.next();
            if (listaPartic.getOidParticipante().equals(oidParticipante)) {
                if (oidEstatus != null) {
                    if (listaPartic.getOidEstatusVenta().equals(oidEstatus)) {
                        UtilidadesLog.info("Meta.buscaMontoMinimo():Salida 1 " + listaPartic.getMontoMinimo());
                        return listaPartic.getMontoMinimo();
                    }
                } else {
                    UtilidadesLog.info("Meta.buscaMontoMinimo():Salida 2 " + listaPartic.getMontoMinimo());
                    return listaPartic.getMontoMinimo();
                }
            }
        }
        UtilidadesLog.info("Meta.buscaMontoMinimo():Salida 0");
        return new BigDecimal(0);
    }

    public void generarArrayEstatusConcurso() throws MareException {
        UtilidadesLog.info("Meta.generarArrayEstatusConcurso():Entrada");
        DAOClientePremiacion daocliepre = new DAOClientePremiacion();
        Iterator it = this.lstEstatusVentaConc.iterator();
        HistoricoEstatusCliente[] aux = new HistoricoEstatusCliente[this.lstEstatusVentaConc.size()];
        DTOEstatusVenta estVtaEntrada;
        int i = 0;
        while (it.hasNext()) {
            estVtaEntrada = (DTOEstatusVenta)it.next();
            UtilidadesLog.info("generarArrayEstatusConcurso estVtaEntrada : " + estVtaEntrada);
            HistoricoEstatusCliente histEstClie = new HistoricoEstatusCliente();
            histEstClie.setOidEstatus(estVtaEntrada.getOidEstatusVentaMae());
            histEstClie.setPeriodoInicio(daocliepre.obtenerPeriodo(estVtaEntrada.getOidPeriodoDesde(), 0));
            histEstClie.setPeriodoFin(daocliepre.obtenerPeriodo(estVtaEntrada.getOidPeriodoHasta(), 0));
            aux[i] = histEstClie;
            i++;
        }
        this.setArrEstatusConcurso(aux);
        UtilidadesLog.info("Meta.generarArrayEstatusConcurso():Salida setArrEstatusConcurso " + this.getArrEstatusConcurso());
    }
    
}
