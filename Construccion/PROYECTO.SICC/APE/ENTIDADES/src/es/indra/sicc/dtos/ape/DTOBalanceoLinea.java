package es.indra.sicc.dtos.ape;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOBalanceoLinea extends DTOBelcorp {
    private Long oidCentroDistribucion;
    private Long oidLineaArmado;
    private Long oidMapaCentroDistribucion;
    private Long oidMapaZonas;
    private Long oidOrdenAnaqueles;
    private Long oidPeriodo;
    private Long oidAsignacionProductosAnaqueles;
    private String version;
    // vbongiov -- BELC400000594 -- 23/07/2007
    private String oidOrigenDatos;
    private Long oidOrdenacionProductos;
    private ArrayList lstPorcentajeSublineas;
    private Long oidSublinea;
    private RecordSet productosOrdenados;
    private RecordSet anaquelesOrdenados;
    private ArrayList listaProductos;
    private ArrayList listaAnaqueles;
    private ArrayList lstCargaSublineas;
    private String codigoError;

    public DTOBalanceoLinea()  {  }
    
    public String getCodigoError()
    {
        return this.codigoError;
    }
    
    public void setCodigoError(String codigoError)
    {
        this.codigoError = codigoError;
    }
    
    public ArrayList getLstCargaSublineas() 
    {
        return this.lstCargaSublineas;
    }
    
    public void setLstCargaSublineas(ArrayList lstCargaSublineas) 
    {
        this.lstCargaSublineas = lstCargaSublineas;
    }

    public Long getOidCentroDistribucion()
    {
        return oidCentroDistribucion;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion)
    {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidLineaArmado()
    {
        return oidLineaArmado;
    }

    public void setOidLineaArmado(Long oidLineaArmado)
    {
        this.oidLineaArmado = oidLineaArmado;
    }

    public Long getOidMapaCentroDistribucion()
    {
        return oidMapaCentroDistribucion;
    }

    public void setOidMapaCentroDistribucion(Long oidMapaCentroDistribucion)
    {
        this.oidMapaCentroDistribucion = oidMapaCentroDistribucion;
    }

    public Long getOidMapaZonas()
    {
        return oidMapaZonas;
    }

    public void setOidMapaZonas(Long oidMapaZonas)
    {
        this.oidMapaZonas = oidMapaZonas;
    }

    public Long getOidOrdenAnaqueles()
    {
        return oidOrdenAnaqueles;
    }

    public void setOidOrdenAnaqueles(Long oidOrdenAnaqueles)
    {
        this.oidOrdenAnaqueles = oidOrdenAnaqueles;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidAsignacionProductosAnaqueles()
    {
        return oidAsignacionProductosAnaqueles;
    }

    public void setOidAsignacionProductosAnaqueles(Long oidAsignacionProductosAnaqueles)
    {
        this.oidAsignacionProductosAnaqueles = oidAsignacionProductosAnaqueles;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getOidOrigenDatos()
    {
        return oidOrigenDatos;
    }

    public void setOidOrigenDatos(String oidOrigenDatos)
    {
        this.oidOrigenDatos = oidOrigenDatos;
    }

    public Long getOidOrdenacionProductos()
    {
        return oidOrdenacionProductos;
    }

    public void setOidOrdenacionProductos(Long oidOrdenacionProductos)
    {
        this.oidOrdenacionProductos = oidOrdenacionProductos;
    }

    public ArrayList getLstPorcentajeSublineas()
    {
        return lstPorcentajeSublineas;
    }

    public void setLstPorcentajeSublineas(ArrayList lstPorcentajeSublineas)
    {
        this.lstPorcentajeSublineas = lstPorcentajeSublineas;
    }

    public Long getOidSublinea()
    {
        return oidSublinea;
    }

    public void setOidSublinea(Long oidSublinea)
    {
        this.oidSublinea = oidSublinea;
    }

    public RecordSet getProductosOrdenados()
    {
        return productosOrdenados;
    }

    public void setProductosOrdenados(RecordSet productosOrdenados)
    {
        this.productosOrdenados = productosOrdenados;
    }

    public RecordSet getAnaquelesOrdenados()
    {
        return anaquelesOrdenados;
    }

    public void setAnaquelesOrdenados(RecordSet anaquelesOrdenados)
    {
        this.anaquelesOrdenados = anaquelesOrdenados;
    }

    public ArrayList getListaProductos()
    {
        return listaProductos;
    }

    public void setListaProductos(ArrayList listaProductos)
    {
        this.listaProductos = listaProductos;
    }

    public ArrayList getListaAnaqueles()
    {
        return listaAnaqueles;
    }

    public void setListaAnaqueles(ArrayList listaAnaqueles)
    {
        this.listaAnaqueles = listaAnaqueles;
    }
}