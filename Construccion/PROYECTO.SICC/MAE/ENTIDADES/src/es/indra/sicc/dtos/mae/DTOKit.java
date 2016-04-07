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
package es.indra.sicc.dtos.mae;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           19/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */
import java.util.ArrayList;

public class DTOKit extends DTOProducto  {
    private Integer porcentajeUnidades;
    private Long marca;
    private Long canal;
    private Long periodoInicio;
    private Long periodoFin;
    private ArrayList productos;
    /*
     * dnh 4/3/2004
     */
    private Long marcaPeriodo;
    private Long tipoPeriodo;

    public DTOKit() {
        super();
    }

    public Integer getPorcentajeUnidades() {
        return porcentajeUnidades;
    }

    public void setPorcentajeUnidades(Integer newPorcentajeUnidades) {
        porcentajeUnidades = newPorcentajeUnidades;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Long newPeriodoInicio) {
        periodoInicio = newPeriodoInicio;
    }

    public Long getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Long newPeriodoFin) {
        periodoFin = newPeriodoFin;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList newProductos) {
        productos = newProductos;
    }

    public Long getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Long newTipoPeriodo) {
        tipoPeriodo = newTipoPeriodo;
    }

    public Long getMarcaPeriodo() {
        return marcaPeriodo;
    }

    public void setMarcaPeriodo(Long newMarcaPeriodo) {
        marcaPeriodo = newMarcaPeriodo;
    }


}