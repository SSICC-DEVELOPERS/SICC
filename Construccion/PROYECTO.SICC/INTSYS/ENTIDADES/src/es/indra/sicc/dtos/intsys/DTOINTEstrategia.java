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

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTEstrategia extends DTOBelcorp {
    public DTOINTEstrategia()
    {
    }
    
    private Long  oid;                              
    private String  codigo;                         
    private Integer maxGrupos;                      
    private Integer maxGruposCondicionados;         
    private Integer maxGruposCondicionantes;        
    private Boolean listaRanking;                   
    private Boolean cuadreGrupos;                   
    private Boolean cvImprimible;                   
    private Boolean modificableImprimible;          
    private Boolean cvDespachoAutomatico;           
    private Boolean modificableDespachoAutomatico;  
    private Boolean cvDigitable;                    
    private Boolean modificableDigitable;           
    private Long tipoEstrategia;                    
    private Long tipoProducto;                      
    private Long pais;                              

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public Boolean getCuadreGrupos()
    {
        return cuadreGrupos;
    }

    public void setCuadreGrupos(Boolean cuadreGrupos)
    {
        this.cuadreGrupos = cuadreGrupos;
    }

    public Boolean getCvDespachoAutomatico()
    {
        return cvDespachoAutomatico;
    }

    public void setCvDespachoAutomatico(Boolean cvDespachoAutomatico)
    {
        this.cvDespachoAutomatico = cvDespachoAutomatico;
    }

    public Boolean getCvDigitable()
    {
        return cvDigitable;
    }

    public void setCvDigitable(Boolean cvDigitable)
    {
        this.cvDigitable = cvDigitable;
    }

    public Boolean getCvImprimible()
    {
        return cvImprimible;
    }

    public void setCvImprimible(Boolean cvImprimible)
    {
        this.cvImprimible = cvImprimible;
    }

    public Boolean getListaRanking()
    {
        return listaRanking;
    }

    public void setListaRanking(Boolean listaRanking)
    {
        this.listaRanking = listaRanking;
    }

    public Integer getMaxGrupos()
    {
        return maxGrupos;
    }

    public void setMaxGrupos(Integer maxGrupos)
    {
        this.maxGrupos = maxGrupos;
    }

    public Integer getMaxGruposCondicionados()
    {
        return maxGruposCondicionados;
    }

    public void setMaxGruposCondicionados(Integer maxGruposCondicionados)
    {
        this.maxGruposCondicionados = maxGruposCondicionados;
    }

    public Integer getMaxGruposCondicionantes()
    {
        return maxGruposCondicionantes;
    }

    public void setMaxGruposCondicionantes(Integer maxGruposCondicionantes)
    {
        this.maxGruposCondicionantes = maxGruposCondicionantes;
    }

    public Boolean getModificableDespachoAutomatico()
    {
        return modificableDespachoAutomatico;
    }

    public void setModificableDespachoAutomatico(Boolean modificableDespachoAutomatico)
    {
        this.modificableDespachoAutomatico = modificableDespachoAutomatico;
    }

    public Boolean getModificableDigitable()
    {
        return modificableDigitable;
    }

    public void setModificableDigitable(Boolean modificableDigitable)
    {
        this.modificableDigitable = modificableDigitable;
    }

    public Boolean getModificableImprimible()
    {
        return modificableImprimible;
    }

    public void setModificableImprimible(Boolean modificableImprimible)
    {
        this.modificableImprimible = modificableImprimible;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Long getPais()
    {
        return pais;
    }

    public void setPais(Long pais)
    {
        this.pais = pais;
    }

    public Long getTipoEstrategia()
    {
        return tipoEstrategia;
    }

    public void setTipoEstrategia(Long tipoEstrategia)
    {
        this.tipoEstrategia = tipoEstrategia;
    }

    public Long getTipoProducto()
    {
        return tipoProducto;
    }

    public void setTipoProducto(Long tipoProducto)
    {
        this.tipoProducto = tipoProducto;
    }

}