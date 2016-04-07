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

package es.indra.sicc.dtos.zon;

import es.indra.sicc.util.DTOBelcorp;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Submódulo:         Zonificación
 * Componente:        DTO's
 * Fecha:             18/05/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-334-N028
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             
 */

public class DTOPedidosZona 
    extends DTOBelcorp
{
    private Long oidPeriodo;
    private Long oidZona;
    private Integer totalPedidos;
    private Integer numeroConsultoras;
    private Double montoTotal;
    /* DBLG500000150 - dmorello, 09/08/06: Se agregan estos dos campos */
    private Long oidPais;
    private Long oidMarca;


    public DTOPedidosZona() {
        super();
    }

   /* public DTOPedidosZona(String filePath,String fileName,String description,
                        String typeProc,Object data)
    {
        super();
        this.pathFichero    = filePath;
        this.nombreFichero  = fileName;
        this.descripcion    = description;
        this.typeProc       = typeProc;
        this.datos          = data;        
    }*/


    public Long getOidZona(){
        return oidZona;
    }
    
    public Long getOidPeriodo(){
        return oidPeriodo;
    }


    public Integer getTotalPedidos(){
        return totalPedidos;
    }


    public Integer getNumeroConsultoras(){
        return numeroConsultoras;
    }    


    public Double getMontoTotal(){
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setTotalPedidos(Integer totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public void setNumeroConsultoras(Integer numeroConsultoras) {
        this.numeroConsultoras = numeroConsultoras;
    }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

}
