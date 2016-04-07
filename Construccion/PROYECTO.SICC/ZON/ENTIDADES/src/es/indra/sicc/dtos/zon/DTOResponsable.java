package es.indra.sicc.dtos.zon;

import es.indra.sicc.util.DTOBelcorp;

import java.sql.Date;

public class DTOResponsable extends DTOBelcorp  {
    private Long oidUA;
    private String codigoResponsable;
    private Integer indUA;
    private String codigoUA;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidResponsable;

    //ZON-05.
    private Long subgerRegZonSecc;
    
    // sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
    private Date fechaProceso;  //fecha Proceso de Facturacion
    private Long oidPeriodo;    //periodo de Facturacion

    public DTOResponsable() {
    }

    public Long getOidUA() {
        return oidUA;
    }

    public void setOidUA(Long oidUA) {
        this.oidUA = oidUA;
    }

    public String getCodigoResponsable() {
        return codigoResponsable;
    }

    public void setCodigoResponsable(String codigoResponsable) {
        this.codigoResponsable = codigoResponsable;
    }

    public Integer getIndUA() {
        return indUA;
    }

    public void setIndUA(Integer indUA) {
        this.indUA = indUA;
    }

    public String getCodigoUA() {
        return codigoUA;
    }

    public void setCodigoUA(String codigoUA) {
        this.codigoUA = codigoUA;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidResponsable()
    {
        return oidResponsable;
    }

    public void setOidResponsable(Long oidResponsable)
    {
        this.oidResponsable = oidResponsable;
    }


    public void setSubgerRegZonSecc(Long subgerRegZonSecc)
    {
        this.subgerRegZonSecc = subgerRegZonSecc;
    }


    public Long getSubgerRegZonSecc()
    {
        return subgerRegZonSecc;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }
}
