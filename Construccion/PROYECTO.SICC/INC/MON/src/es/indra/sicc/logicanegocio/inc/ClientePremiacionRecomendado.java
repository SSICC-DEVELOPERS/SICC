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
 * @date 25/04/2005
 * @author Gustavo Viñales
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.ArrayList;


public class ClientePremiacionRecomendado extends ObjetoImprimible implements Serializable  {
    private ArrayList pedidosRecomendacion;
    private DatosPersonales datosPersonales;
    private Long oidClienteRecomendado;
    private Long totalPedidosRecomendada;
    private Periodo periodoInicioVinculo;
    private Premio premioElegido;
    
    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
    private Periodo periodoFinVinculo;
    // vbongiov -- 9/01/2007 -- DBLG500001077
    private boolean indRecomendacionEfectiva;
    
    //jrivas 22/8/2008 20080580
    private Long oidCliente;    

    public ClientePremiacionRecomendado() {
        totalPedidosRecomendada = new Long(0);
        pedidosRecomendacion = new ArrayList();
        // vbongiov -- 9/01/2007 -- DBLG500001077
        this.indRecomendacionEfectiva = false;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setOidClienteRecomendado(Long oidClienteRecomendado) {
        this.oidClienteRecomendado = oidClienteRecomendado;
    }

    public Long getOidClienteRecomendado() {
        return oidClienteRecomendado;
    }

    public void setPedidosRecomendacion(ArrayList pedidosRecomendacion) {
        this.pedidosRecomendacion = pedidosRecomendacion;
    }

    public ArrayList getPedidosRecomendacion() {
        return pedidosRecomendacion;
    }

    public void setPeriodoInicioVinculo(Periodo periodoInicioVinculo) {
        this.periodoInicioVinculo = periodoInicioVinculo;
    }

    public Periodo getPeriodoInicioVinculo() {
        return periodoInicioVinculo;
    }

    public void setPremioElegido(Premio premioElegido) {
        this.premioElegido = premioElegido;
    }

    public Premio getPremioElegido() {
        return premioElegido;
    }

    public void setTotalPedidosRecomendada(Long totalPedidosRecomendada) {
        this.totalPedidosRecomendada = totalPedidosRecomendada;
    }

    public Long getTotalPedidosRecomendada() {
        return totalPedidosRecomendada;
    }

    /**
     * Invalida todos los PedidoRecomendacion
     */
    public void anularPedidos() {
        UtilidadesLog.info("ClientePremiacionRecomendado.anularPedidos():" +
            "Entrada");
        
        if (pedidosRecomendacion != null) {
            for (int i = 0; i < pedidosRecomendacion.size(); i++) {
                ((PedidoRecomendacion) pedidosRecomendacion.get(i))
                    .setValido(false);
            }
        }
        UtilidadesLog.info("ClientePremiacionRecomendado.anularPedidos():" +
            "Salida");
    }

    /**
     * cuenta los PedidoRecomendacion validos
     * @return la cantidad de pedidos validos.
     */
    public Long calcularPedidosValidos() {
        UtilidadesLog.info("ClientePremiacionRecomendado.calcularPedidosVali"
            +"dos():Entrada");

        int counter = 0;
        if (pedidosRecomendacion != null) {
            for (int i = 0; i < pedidosRecomendacion.size(); i++) {
                if (((PedidoRecomendacion) pedidosRecomendacion.get(i))
                    .getValido()) {
                    counter++;
                    UtilidadesLog.debug("counter " + counter);
                }
            }
        }
        
        this.setTotalPedidosRecomendada(new Long(counter));
        UtilidadesLog.info("ClientePremiacionRecomendado." +
            "calcularPedidosValidos():Salida");

        return new Long(counter);
    }

    /**
     * Calcula el promedio de montoPedido de todos los PedidoRecomendacion
     * @return el promedio de los montoPedido de todos los PedidoRecomendacion
     */
    public BigDecimal calcularPromedioVenta() {
        UtilidadesLog.info("ClientePremiacionRecomendado.calcularPromedioVen"
            +"ta():Entrada");

        BigDecimal promedio = new BigDecimal(0);

        if (pedidosRecomendacion != null) {
            if (pedidosRecomendacion.size() > 0) {
                for (int i = 0; i < pedidosRecomendacion.size(); i++) {
                    BigDecimal monto = ((PedidoRecomendacion)pedidosRecomendacion.get(i)).getMontoPedido();
                    if (monto != null) {
                        promedio = promedio.add(monto);
                    }
                    
                    // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
                    BigDecimal montoRetail = ((PedidoRecomendacion)pedidosRecomendacion.get(i)).getMontoRetail();
                    if (montoRetail != null) {
                        promedio = promedio.add(montoRetail);
                    }
                }
    
                promedio = promedio.divide(new BigDecimal(
                            pedidosRecomendacion.size()),
                            2, BigDecimal.ROUND_HALF_UP);
            }
        }
        UtilidadesLog.info("ClientePremiacionRecomendado." +
            "calcularPromedioVenta():Salida");

        return promedio;
    }

    /**
     * Calcula la suma de montoPedido de todos los PedidoRecomendacion
     * @return la suma de los montoPedido de todos los PedidoRecomendacion
     */
    public BigDecimal calcularSumaMontoPedidosRecomendacion() {
        UtilidadesLog.info("ClientePremiacionRecomendado." +
            "calcularSumaMontoPedidosRecomendacion():Entrada");

        BigDecimal sumatorio = new BigDecimal(0);

        if (pedidosRecomendacion != null) {
            for (int i = 0; i < pedidosRecomendacion.size(); i++) {
                BigDecimal monto = ((PedidoRecomendacion)pedidosRecomendacion.get(i)).getMontoPedido();
                if (monto != null) {
                    sumatorio = sumatorio.add(monto);
                }
            }
        }
        
        UtilidadesLog.info("ClientePremiacionRecomendado." +
            "calcularSumaMontoPedidosRecomendacion():Salida");

        return sumatorio;
    }
    
    /**
     *  Agregado según DBLG50000840
     *  @author Julián Rivas
     *  @date 31/07/2006
     */
    public Float calcularSumaMontoPedidosValidos(ArrayList montosRecomendada) {
        UtilidadesLog.info("ClientePremiacionRecomendado.calcularSumaMontoPedidosValidos(ArrayList montosRecomendada):Entrada");

        float sumatoria = 0.0F;
        for (int indice2 = 0; indice2 < this.getPedidosRecomendacion().size() ; indice2++) {
            PedidoRecomendacion pedRec = (PedidoRecomendacion) this.getPedidosRecomendacion().get(indice2);
            UtilidadesLog.info("pedRec.getUnidadesPedido " + pedRec.getUnidadesPedido());
            UtilidadesLog.info("pedRec.getMontoPedido " + pedRec.getMontoPedido());
            UtilidadesLog.info("montosRecomendada " + montosRecomendada);
            if ( (!montosRecomendada.isEmpty()) && 
                  (((montosRecomendada.get(0) != null) 
                        && ((pedRec.getMontoPedido().doubleValue()) < ((TipoMonto)montosRecomendada.get(0)).getCantidad().doubleValue())) ||
                  ((montosRecomendada.get(1) != null) 
                        && ((pedRec.getUnidadesPedido().doubleValue()) < ((TipoMonto)montosRecomendada.get(1)).getCantidad().doubleValue())) ) ) {
                UtilidadesLog.info("false");
                pedRec.setValido(false);
            }
            
            if (pedRec.getValido()) {
                UtilidadesLog.info("true");
                sumatoria = sumatoria + pedRec.getMontoPedido().floatValue();
            }
        }

        UtilidadesLog.info("calcularSumaMontoPedidosValidos(ArrayList montosRecomendada):Salida " + sumatoria);

        return (new Float(sumatoria));
    }  
    
    /**
     *  Agregado según DBLG50000840
     *  @author Julián Rivas
     *  @date 31/07/2006
     */
    public Integer getNumPedValidos() {
        UtilidadesLog.info("ClientePremiacionRecomendado.getNumPedValidos()" +
            ":Entrada");

        /*
         *  1.- Sumatorio=0
         *  2.- Recorremos todos los elementos de recomendados usando indice1,
         *      para cada uno hacer:
         *  2.1. Recorremos todos los elementos de recomendados(indice1).
         *      pedidosRecomendacion usando
         *       indice2, para cada uno hacer:
         *             Si pedidoRecomendacion.valido==TRUE entonces
         *             Sumatorio= Sumatorio + 1
         *  3.- Devolvemos Sumatorio.
         */
        int sumatoria = 0;
        for (int indice2 = 0; indice2 < this.getPedidosRecomendacion().size(); indice2++) {
            PedidoRecomendacion pedRec = (PedidoRecomendacion) this.getPedidosRecomendacion().get(indice2);
            UtilidadesLog.info("pedRec.getValido() " + pedRec.getValido());
            if (pedRec.getValido()) {
                sumatoria += 1;
            }
        }

        UtilidadesLog.info("ClientePremiacionRecomendado.getNumPedValidos()" +
            ":Salida " + sumatoria);

        if (sumatoria == 0)
            return new Integer(1);
        else
            return (new Integer(sumatoria));
    }    

    public Periodo getPeriodoFinVinculo()
    {
        return periodoFinVinculo;
    }

    public void setPeriodoFinVinculo(Periodo periodoFinVinculo)
    {
        this.periodoFinVinculo = periodoFinVinculo;
    }

  public boolean getIndRecomendacionEfectiva() {
    return indRecomendacionEfectiva;
  }

  public void setIndRecomendacionEfectiva(boolean indRecomendacionEfectiva) {
    this.indRecomendacionEfectiva = indRecomendacionEfectiva;
  }
  
    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidClienteRecdo) {
        this.oidCliente = oidClienteRecdo;
    }  
    
    // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
    public BigDecimal calcularSumaMontoRetailRecomendacion() {
        UtilidadesLog.info("ClientePremiacionRecomendado.calcularSumaMontoRetailRecomendacion():Entrada");

        BigDecimal sumatorio = new BigDecimal(0);

        if (pedidosRecomendacion != null) {
            for (int i = 0; i < pedidosRecomendacion.size(); i++) {
                BigDecimal monto = ((PedidoRecomendacion)pedidosRecomendacion.get(i)).getMontoRetail();
                if (monto != null) {
                    sumatorio = sumatorio.add(monto);
                }
            }
        }
        
        UtilidadesLog.info("ClientePremiacionRecomendado.calcularSumaMontoRetailRecomendacion():Salida");

        return sumatorio;
    }
    
    
    
}