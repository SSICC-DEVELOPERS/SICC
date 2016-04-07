package es.indra.sicc.dtos.ccc;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTODetalleCargos extends DTOAuditableSICC  {
  private RecordSet datosLista;
  private Double total;

  //jrivas 23/7/2008 CCC-004
  private String apenom;
  private String codigoConsultora;
  private String campania;
  private String numeroConsolidado;
  private RecordSet numeroFactura;
  private Date fechaFacturacion;
  private String indicadorChequeo;
  private String importeFletes;
  private String impuestos;
  private String saldoPendiente;
  private String pagosPosteriores;
  private String pagosDiferidos;
 
  public DTODetalleCargos() {
  }

  public RecordSet getDatosLista() {
    return datosLista;
  }

  public void setDatosLista(RecordSet datosLista) {
    this.datosLista = datosLista;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

    public String getApenom()
    {
        return apenom;
    }

    public void setApenom(String apenom)
    {
        this.apenom = apenom;
    }

    public String getCodigoConsultora()
    {
        return codigoConsultora;
    }

    public void setCodigoConsultora(String codigoConsultora)
    {
        this.codigoConsultora = codigoConsultora;
    }

    public String getCampania()
    {
        return campania;
    }

    public void setCampania(String campania)
    {
        this.campania = campania;
    }

    public String getNumeroConsolidado()
    {
        return numeroConsolidado;
    }

    public void setNumeroConsolidado(String numeroConsolidado)
    {
        this.numeroConsolidado = numeroConsolidado;
    }

    public RecordSet getNumeroFactura()
    {
        return numeroFactura;
    }

    public void setNumeroFactura(RecordSet numeroFactura)
    {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion)
    {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getIndicadorChequeo()
    {
        return indicadorChequeo;
    }

    public void setIndicadorChequeo(String indicadorChequeo)
    {
        this.indicadorChequeo = indicadorChequeo;
    }

    public String getImporteFletes()
    {
        return importeFletes;
    }

    public void setImporteFletes(String importeFletes)
    {
        this.importeFletes = importeFletes;
    }

    public String getImpuestos()
    {
        return impuestos;
    }

    public void setImpuestos(String impuestos)
    {
        this.impuestos = impuestos;
    }

    public String getSaldoPendiente()
    {
        return saldoPendiente;
    }

    public void setSaldoPendiente(String saldoPendiente)
    {
        this.saldoPendiente = saldoPendiente;
    }

    public String getPagosPosteriores()
    {
        return pagosPosteriores;
    }

    public void setPagosPosteriores(String pagosPosteriores)
    {
        this.pagosPosteriores = pagosPosteriores;
    }

    public String getPagosDiferidos()
    {
        return pagosDiferidos;
    }

    public void setPagosDiferidos(String pagosDiferidos)
    {
        this.pagosDiferidos = pagosDiferidos;
    }

 
}