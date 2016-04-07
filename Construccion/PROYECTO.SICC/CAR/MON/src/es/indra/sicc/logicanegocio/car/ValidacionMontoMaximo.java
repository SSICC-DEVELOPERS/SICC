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
package es.indra.sicc.logicanegocio.car;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class ValidacionMontoMaximo {

    private BigDecimal montoMaximoPermitido;
    private BigDecimal montoSolicitud;
    private BigDecimal excesoMontoMaximo;   

    public ValidacionMontoMaximo(BigDecimal monMax, BigDecimal monSol, BigDecimal excesoMon) {
        this.montoMaximoPermitido = monMax;
        this.montoSolicitud = monSol;
        this.excesoMontoMaximo = excesoMon;
    }

    public void setExcesoMontoMaximo(BigDecimal monto) {
        this.excesoMontoMaximo = monto;
    }

    public Boolean validar() {
        UtilidadesLog.info("ValidacionMontoMaximo.validar():Entrada");

        UtilidadesLog.debug("this.montoSolicitud: " + this.montoSolicitud); 
      
        if(this.montoSolicitud.compareTo(new BigDecimal(0))== 0){
            UtilidadesLog.info("ValidacionMontoMaximo.validar():Salida");
            return Boolean.FALSE;
        }
        UtilidadesLog.debug("comparo: montoSolicitud: " + this.montoSolicitud + " contra, this.montoMaximoPermitido: " + this.montoMaximoPermitido);
        if (this.montoSolicitud.compareTo(this.montoMaximoPermitido) == 1) { 
            int compare = this.montoSolicitud.subtract(this.montoMaximoPermitido).divide(this.montoSolicitud, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).compareTo(this.excesoMontoMaximo);
            if(compare == 0 || compare == -1){  
                UtilidadesLog.info("ValidacionMontoMaximo.validar():Salida");
                return Boolean.TRUE;
            } else {
                UtilidadesLog.info("ValidacionMontoMaximo.validar():Salida");
                return Boolean.FALSE;
            } 
        } else {
            UtilidadesLog.info("ValidacionMontoMaximo.validar():Salida");
            return Boolean.TRUE;
        }
    }
    
}