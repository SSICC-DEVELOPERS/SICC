package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTEstatusCliente extends DTOBelcorp
{
    public DTOINTEstatusCliente()
    {
    }
    
    private String codigoEstatus;
    private String descripcionEstatus;
    private Long oidCliente;
    private String indicadorEsEstrella;
    private Long codigoTipoCurso;
    private Long numeroTotalOrdenes;

    public String getCodigoEstatus()
    {
        return codigoEstatus;
    }

    public void setCodigoEstatus(String codigoEstatus)
    {
        this.codigoEstatus = codigoEstatus;
    }

    public String getDescripcionEstatus()
    {
        return descripcionEstatus;
    }

    public void setDescripcionEstatus(String descripcionEstatus)
    {
        this.descripcionEstatus = descripcionEstatus;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getIndicadorEsEstrella() {
        return indicadorEsEstrella;
    }

    public void setIndicadorEsEstrella(String indicadorEsEstrella) {
        this.indicadorEsEstrella = indicadorEsEstrella;
    }

    public Long getCodigoTipoCurso() {
        return codigoTipoCurso;
    }

    public void setCodigoTipoCurso(Long codigoTipoCurso) {
        this.codigoTipoCurso = codigoTipoCurso;
    }

    public Long getNumeroTotalOrdenes() {
        return numeroTotalOrdenes;
    }

    public void setNumeroTotalOrdenes(Long numeroTotalOrdenes) {
        this.numeroTotalOrdenes = numeroTotalOrdenes;
    }
}