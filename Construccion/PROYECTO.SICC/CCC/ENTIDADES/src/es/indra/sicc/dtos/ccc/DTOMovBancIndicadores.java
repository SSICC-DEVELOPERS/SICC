/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.dtos.ccc;

import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;


public class DTOMovBancIndicadores extends DTOMovimientoBancario {
    private Boolean indicadorSaldoUnico;
    private Boolean indicadorSimulacion;
    private DTOMovimientoBancario[] dtoMovimientosBancarios;

    public DTOMovBancIndicadores() {
    }

    public Boolean getIndicadorSaldoUnico() {
        return indicadorSaldoUnico;
    }

    public void setIndicadorSaldoUnico(Boolean newIndicadorSaldoUnico) {
        indicadorSaldoUnico = newIndicadorSaldoUnico;
    }

    public Boolean getIndicadorSimulacion() {
        return indicadorSimulacion;
    }

    public void setIndicadorSimulacion(Boolean newIndicadorSimulacion) {
        indicadorSimulacion = newIndicadorSimulacion;
    }

    public DTOMovimientoBancario[] getDtoMovimientosBancarios() {
        return dtoMovimientosBancarios;
    }

    public void setDtoMovimientosBancarios(
        DTOMovimientoBancario[] newDtoMovimientosBancarios) {
        dtoMovimientosBancarios = newDtoMovimientosBancarios;
    }
}
