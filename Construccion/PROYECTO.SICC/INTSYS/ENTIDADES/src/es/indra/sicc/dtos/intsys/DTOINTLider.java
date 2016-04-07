package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTLider extends DTOBelcorp
{
    public DTOINTLider()
    {
    }
    
    private String codigoConsultora;     
    private String nombreLider;          
    private String direccionLider;       
    private String telefono;             
    private String anioCampaniaEsLider;  

    public String getAnioCampaniaEsLider()
    {
        return anioCampaniaEsLider;
    }

    public void setAnioCampaniaEsLider(String anioCampaniaEsLider)
    {
        this.anioCampaniaEsLider = anioCampaniaEsLider;
    }

    public String getCodigoConsultora()
    {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String codigoConsultora)
    {
        this.codigoConsultora = codigoConsultora;
    }

    public String getDireccionLider()
    {
        return direccionLider;
    }

    public void setDireccionLider(String direccionLider)
    {
        this.direccionLider = direccionLider;
    }

    public String getNombreLider()
    {
        return nombreLider;
    }

    public void setNombreLider(String nombreLider)
    {
        this.nombreLider = nombreLider;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

}