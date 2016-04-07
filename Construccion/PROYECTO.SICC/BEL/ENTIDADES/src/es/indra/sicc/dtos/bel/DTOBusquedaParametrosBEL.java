package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * 
 * @date 26/06/2006
 * @author ciglesias
 */
public class DTOBusquedaParametrosBEL extends DTOSiccPaginacion
{

    private Long canal;
    private Long acceso;
    private Long subacceso;
    
    public DTOBusquedaParametrosBEL()
    {
    }

    public Long getCanal()
    {
        return canal;
    }

    public void setCanal(Long canal)
    {
        this.canal = canal;
    }

    public Long getAcceso()
    {
        return acceso;
    }

    public void setAcceso(Long acceso)
    {
        this.acceso = acceso;
    }

    public Long getSubacceso()
    {
        return subacceso;
    }

    public void setSubacceso(Long subacceso)
    {
        this.subacceso = subacceso;
    }
}