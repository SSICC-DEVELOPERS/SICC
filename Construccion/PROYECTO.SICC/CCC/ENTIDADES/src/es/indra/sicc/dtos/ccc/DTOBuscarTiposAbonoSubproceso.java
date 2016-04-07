package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * 
 * @author Noziglia Claus
 */
public class DTOBuscarTiposAbonoSubproceso extends DTOSiccPaginacion 
{
    private Long oidProceso;
    private Long oidSubproceso;
    private Long oidCuentaContable;
    private Long oidTipoAbono;

    public DTOBuscarTiposAbonoSubproceso()
    {
    }

    public Long getOidProceso()
    {
        return oidProceso;
    }

    public void setOidProceso(Long oidProceso)
    {
        this.oidProceso = oidProceso;
    }

    public Long getOidSubproceso()
    {
        return oidSubproceso;
    }

    public void setOidSubproceso(Long oidSubproceso)
    {
        this.oidSubproceso = oidSubproceso;
    }

    public Long getOidCuentaContable()
    {
        return oidCuentaContable;
    }

    public void setOidCuentaContable(Long oidCuentaContable)
    {
        this.oidCuentaContable = oidCuentaContable;
    }

    public Long getOidTipoAbono()
    {
        return oidTipoAbono;
    }

    public void setOidTipoAbono(Long oidTipoAbono)
    {
        this.oidTipoAbono = oidTipoAbono;
    }
}