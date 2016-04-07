package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTProductoVentaReal extends DTOBelcorp{
    public DTOINTProductoVentaReal()
    {
    }
    
        private Long oid;                                
        private String codigoSAP;                        
        private String descripcionSAP;                   
        private String codigoMarca;                      
        private String codigoUnidadNegocio;              
        private String codigoNegocio;                    
        private String estatusProducto;
        private String indicadorDentroFueraCajaBolsa; 
        private Integer totalUnidades;                   
        private Integer largoCentimetros;                
        private Integer anchoCentimetros;                
        private Integer altoCentimetros;                 
        private Integer pesoBrutoGramos;                 

    public Integer getAltoCentimetros()
    {
        return altoCentimetros;
    }

    public void setAltoCentimetros(Integer altoCentimetros)
    {
        this.altoCentimetros = altoCentimetros;
    }

    public Integer getAnchoCentimetros()
    {
        return anchoCentimetros;
    }

    public void setAnchoCentimetros(Integer anchoCentimetros)
    {
        this.anchoCentimetros = anchoCentimetros;
    }

    public String getCodigoMarca()
    {
        return codigoMarca;
    }

    public void setCodigoMarca(String codigoMarca)
    {
        this.codigoMarca = codigoMarca;
    }

    public String getCodigoNegocio()
    {
        return codigoNegocio;
    }

    public void setCodigoNegocio(String codigoNegocio)
    {
        this.codigoNegocio = codigoNegocio;
    }

    public String getCodigoSAP()
    {
        return codigoSAP;
    }

    public void setCodigoSAP(String codigoSAP)
    {
        this.codigoSAP = codigoSAP;
    }

    public String getCodigoUnidadNegocio()
    {
        return codigoUnidadNegocio;
    }

    public void setCodigoUnidadNegocio(String codigoUnidadNegocio)
    {
        this.codigoUnidadNegocio = codigoUnidadNegocio;
    }

    public String getDescripcionSAP()
    {
        return descripcionSAP;
    }

    public void setDescripcionSAP(String descripcionSAP)
    {
        this.descripcionSAP = descripcionSAP;
    }

    public String getEstatusProducto()
    {
        return estatusProducto;
    }

    public void setEstatusProducto(String estatusProducto)
    {
        this.estatusProducto = estatusProducto;
    }

    public String getIndicadorDentroFueraCajaBolsa()
    {
        return indicadorDentroFueraCajaBolsa;
    }

    public void setIndicadorDentroFueraCajaBolsa(String indicadorDentroFueraCajaBolsa)
    {
        this.indicadorDentroFueraCajaBolsa = indicadorDentroFueraCajaBolsa;
    }

    public Integer getLargoCentimetros()
    {
        return largoCentimetros;
    }

    public void setLargoCentimetros(Integer largoCentimetros)
    {
        this.largoCentimetros = largoCentimetros;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Integer getPesoBrutoGramos()
    {
        return pesoBrutoGramos;
    }

    public void setPesoBrutoGramos(Integer pesoBrutoGramos)
    {
        this.pesoBrutoGramos = pesoBrutoGramos;
    }

    public Integer getTotalUnidades()
    {
        return totalUnidades;
    }

    public void setTotalUnidades(Integer totalUnidades)
    {
        this.totalUnidades = totalUnidades;
    }

}