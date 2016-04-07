package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;
/**
 * 
 * @author Noziglia Claus
 */
public class DTOMantenimientoTiposAbonoSubproceso extends DTOBelcorp {
   
    private Long oidTiposAbonoSubproceso;
    private Long oidProceso;
    private Long oidSubproceso;
    private Long oidTipoAbono;
    private Long oidCuentaContable;
    private Long[] oidsRegistrosAEliminar;

    public DTOMantenimientoTiposAbonoSubproceso()
    {
    }

    public Long getOidTiposAbonoSubproceso()
    {
        return oidTiposAbonoSubproceso;
    }

    public void setOidTiposAbonoSubproceso(Long oidTiposAbonoSubproceso)
    {
        this.oidTiposAbonoSubproceso = oidTiposAbonoSubproceso;
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

    public Long getOidTipoAbono()
    {
        return oidTipoAbono;
    }

    public void setOidTipoAbono(Long oidTipoAbono)
    {
        this.oidTipoAbono = oidTipoAbono;
    }

    public Long getOidCuentaContable()
    {
        return oidCuentaContable;
    }

    public void setOidCuentaContable(Long oidCuentaContable)
    {
        this.oidCuentaContable = oidCuentaContable;
    }

    public Long[] getOidsRegistrosAEliminar()
    {
        return oidsRegistrosAEliminar;
    }

    public void setOidsRegistrosAEliminar(Long[] oidsRegistrosAEliminar)
    {
        this.oidsRegistrosAEliminar = oidsRegistrosAEliminar;
    }
}