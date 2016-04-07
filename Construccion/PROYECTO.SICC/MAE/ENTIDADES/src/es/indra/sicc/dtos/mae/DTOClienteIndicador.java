package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;

public class DTOClienteIndicador extends DTOAuditableSICC {
    private DTOOIDs oidindicadores;
    private Long[] indicadores;


    public void setIndicadores(Long[] indicadores)
    {
        this.indicadores = indicadores;
    }


    public Long[] getIndicadores()
    {
        return indicadores;
    }


    public void setOidindicadores(DTOOIDs oidindicadores)
    {
        this.oidindicadores = oidindicadores;
    }


    public DTOOIDs getOidindicadores()
    {
        return oidindicadores;
    }


    

}