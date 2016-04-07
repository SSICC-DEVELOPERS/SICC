package es.indra.sicc.dtos.ape;
import java.util.ArrayList;

public class DTOSublineaZonas 
{
    private Long oidSublinea;
    private String letraParaAnaquel;
    private ArrayList Zonas;

    public DTOSublineaZonas() {}

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }


    public void setZonas(ArrayList Zonas)
    {
        this.Zonas = Zonas;
    }


    public ArrayList getZonas()
    {
        return Zonas;
    }

    public void setLetraParaAnaquel(String letraParaAnaquel) {
        this.letraParaAnaquel = letraParaAnaquel;
    }

    public String getLetraParaAnaquel() {
        return letraParaAnaquel;
    }
}
