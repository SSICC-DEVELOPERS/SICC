/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOBuscarInsertarComisiones
 * Fecha:             07/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033
 * Descripcion:       DTOBuscarInsertarComisiones
 * @version           1.0
 * @autor             idedough
 */
 
package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarInsertarComisiones extends DTOSiccPaginacion 
{
    private String descripcion;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidMarca;
    private Long oidPlantilla;
        
    public DTOBuscarInsertarComisiones()
    {
    }


    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }


    public String getDescripcion()
    {
        return descripcion;
    }


    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }


    public Long getOidCanal()
    {
        return oidCanal;
    }


    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }


    public Long getOidAcceso()
    {
        return oidAcceso;
    }


    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }    

    public Long getOidPlantilla()
    {
        return oidPlantilla;
    }

    public void setOidPlantilla(Long oidPlantilla)
    {
        this.oidPlantilla = oidPlantilla;
    }
}