/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOCabeceraPedido extends DTOBelcorp
{
    private String motivoAprobacion;
    private String estadoCredito;
    private String canal;
    private String acceso;
    private String localSubacceso;
    private String accesoFisico;
    private String destinatario;
    private String destino;
    private String pagador;
    private String consultoraAsociada;
    private String receptorFactura;
    private String moduloGeneraPedido;
    private String estadisticable;
    private String almacenSalida;
    private String sociedadVentas;
    private String glosa;
    private Date fechaFacturacion;
    private Date fechaProgFacturacion;

    public DTOCabeceraPedido()
    {
    }

    public String getMotivoAprobacion()
    {
        return motivoAprobacion;
    }

    public void setMotivoAprobacion(String motivoAprobacion)
    {
        this.motivoAprobacion = motivoAprobacion;
    }

    public String getEstadoCredito()
    {
        return estadoCredito;
    }

    public void setEstadoCredito(String estadoCredito)
    {
        this.estadoCredito = estadoCredito;
    }

    public String getCanal()
    {
        return canal;
    }

    public void setCanal(String canal)
    {
        this.canal = canal;
    }

    public String getAcceso()
    {
        return acceso;
    }

    public void setAcceso(String acceso)
    {
        this.acceso = acceso;
    }

    public String getLocalSubacceso()
    {
        return localSubacceso;
    }

    public void setLocalSubacceso(String localSubacceso)
    {
        this.localSubacceso = localSubacceso;
    }

    public String getAccesoFisico()
    {
        return accesoFisico;
    }

    public void setAccesoFisico(String accesoFisico)
    {
        this.accesoFisico = accesoFisico;
    }

    public String getDestinatario()
    {
        return destinatario;
    }

    public void setDestinatario(String destinatario)
    {
        this.destinatario = destinatario;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public String getPagador()
    {
        return pagador;
    }

    public void setPagador(String pagador)
    {
        this.pagador = pagador;
    }

    public String getConsultoraAsociada()
    {
        return consultoraAsociada;
    }

    public void setConsultoraAsociada(String consultoraAsociada)
    {
        this.consultoraAsociada = consultoraAsociada;
    }

    public String getReceptorFactura()
    {
        return receptorFactura;
    }

    public void setReceptorFactura(String receptorFactura)
    {
        this.receptorFactura = receptorFactura;
    }

    public String getModuloGeneraPedido()
    {
        return moduloGeneraPedido;
    }

    public void setModuloGeneraPedido(String moduloGeneraPedido)
    {
        this.moduloGeneraPedido = moduloGeneraPedido;
    }

    public String getEstadisticable()
    {
        return estadisticable;
    }

    public void setEstadisticable(String estadisticable)
    {
        this.estadisticable = estadisticable;
    }

    public String getAlmacenSalida()
    {
        return almacenSalida;
    }

    public void setAlmacenSalida(String almacenSalida)
    {
        this.almacenSalida = almacenSalida;
    }

    public String getSociedadVentas()
    {
        return sociedadVentas;
    }

    public void setSociedadVentas(String sociedadVentas)
    {
        this.sociedadVentas = sociedadVentas;
    }

    public String getGlosa()
    {
        return glosa;
    }

    public void setGlosa(String glosa)
    {
        this.glosa = glosa;
    }

    public Date getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion)
    {
        this.fechaFacturacion = fechaFacturacion;
    }

    public Date getFechaProgFacturacion()
    {
        return fechaProgFacturacion;
    }

    public void setFechaProgFacturacion(Date fechaProgFacturacion)
    {
        this.fechaProgFacturacion = fechaProgFacturacion;
    }
}