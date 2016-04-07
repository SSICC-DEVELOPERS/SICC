package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTProductoEstimado extends DTOBelcorp
{
    public DTOINTProductoEstimado()
    {  
    }
        private Long  oidProducto;                
        private String codigoSAP;                 
        private String descripcionProducto;       
        private String marca;                     
        private String unidadNegocio;             
        private String negocio;                   
        private String estatusProducto;           
        private Integer totalUnidadesProducto;    
        private String indicadorDentroFueraCaja;  
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

    public String getCodigoSAP()
    {
        return codigoSAP;
    }

    public void setCodigoSAP(String codigoSAP)
    {
        this.codigoSAP = codigoSAP;
    }

    public String getDescripcionProducto()
    {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto)
    {
        this.descripcionProducto = descripcionProducto;
    }

    public String getEstatusProducto()
    {
        return estatusProducto;
    }

    public void setEstatusProducto(String estatusProducto)
    {
        this.estatusProducto = estatusProducto;
    }

    public String getIndicadorDentroFueraCaja()
    {
        return indicadorDentroFueraCaja;
    }

    public void setIndicadorDentroFueraCaja(String indicadorDentroFueraCaja)
    {
        this.indicadorDentroFueraCaja = indicadorDentroFueraCaja;
    }

    public Integer getLargoCentimetros()
    {
        return largoCentimetros;
    }

    public void setLargoCentimetros(Integer largoCentimetros)
    {
        this.largoCentimetros = largoCentimetros;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getNegocio()
    {
        return negocio;
    }

    public void setNegocio(String negocio)
    {
        this.negocio = negocio;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public Integer getPesoBrutoGramos()
    {
        return pesoBrutoGramos;
    }

    public void setPesoBrutoGramos(Integer pesoBrutoGramos)
    {
        this.pesoBrutoGramos = pesoBrutoGramos;
    }

    public Integer getTotalUnidadesProducto()
    {
        return totalUnidadesProducto;
    }

    public void setTotalUnidadesProducto(Integer totalUnidadesProducto)
    {
        this.totalUnidadesProducto = totalUnidadesProducto;
    }

    public String getUnidadNegocio()
    {
        return unidadNegocio;
    }

    public void setUnidadNegocio(String unidadNegocio)
    {
        this.unidadNegocio = unidadNegocio;
    }

    
}