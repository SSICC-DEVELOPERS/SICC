package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCampo extends DTOAuditableSICC 
{
    private String codigoCampo;
    private Boolean obligatorio;
    private Boolean modificable;
    private String valorDefecto;

    public DTOCampo()
    {
    }

    public String getCodigoCampo()
    {
        return codigoCampo;
    }

    public void setCodigoCampo(String newCodigoCampo)
    {
        codigoCampo = newCodigoCampo;
    }

    public Boolean getObligatorio()
    {
        return obligatorio;
    }

    public void setObligatorio(Boolean newObligatorio)
    {
        obligatorio = newObligatorio;
    }

    public Boolean getModificable()
    {
        return modificable;
    }

    public void setModificable(Boolean newModificable)
    {
        modificable = newModificable;
    }

    public String getValorDefecto()
    {
        return valorDefecto;
    }

    public void setValorDefecto(String newValorDefecto)
    {
        valorDefecto = newValorDefecto;
    }
}