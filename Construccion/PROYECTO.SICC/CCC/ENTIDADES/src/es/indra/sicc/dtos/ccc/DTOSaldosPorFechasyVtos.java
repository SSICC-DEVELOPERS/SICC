/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ccc;

import java.util.Date;


public class DTOSaldosPorFechasyVtos extends DTOSaldosPorFechas {
    private Date fechaVtoDesde;
    private Date fechaVtoHasta;

    public DTOSaldosPorFechasyVtos() {
    }

    public Date getFechaVtoDesde() {
        return fechaVtoDesde;
    }

    public void setFechaVtoDesde(Date newFechaVtoDesde) {
        fechaVtoDesde = newFechaVtoDesde;
    }

    public Date getFechaVtoHasta() {
        return fechaVtoHasta;
    }

    public void setFechaVtoHasta(Date newFechaVtoHasta) {
        fechaVtoHasta = newFechaVtoHasta;
    }
}
