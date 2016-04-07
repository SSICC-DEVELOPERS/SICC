package es.indra.sicc.dtos.bel;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOParametrosBEL extends DTOBelcorp
{
    private Long oidParametro;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidSubacceso;
    private String direccion;
    private String telefono;
    private BigDecimal montoMaxDiferencia;
    private BigDecimal limiteEfectCaja;
    private Integer nroCajas;
    private String nombreLocal;
    private Long oidMoviStockEnTransito;
    private Long alertaStock;
    private Integer tiempoReposicion;
    private Long oidMoviStockDevolucion;
    private Long oidTipoMoviCajaCobrar;
    private BigDecimal factorXLocal;
    private Integer nroMaxProdu;
    private Long oidMoviConfirmarStock;
    private Long oidMoviConfirmarStockTransito;
    private Long oidMoviRegularizacion;
    private Long oidMoviRegularizacionSAP;
    private Long oidMoviDevolStockExistencias;
    private Long oidMoviPeticionExistencias;
    private Long oidTipoMoviCajaCierre;
    private String codigoCliente;
    private Long oidCuentaCorriente;
    private Long oidEmpresa;
    private Long oidTipoTransaccion;
    private Long oidCliente;
    private String nombreAdministrador;

    public Long getOidParametro()
    {
        return oidParametro;
    }

    public void setOidParametro(Long oidParametro)
    {
        this.oidParametro = oidParametro;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long oidSubacceso)
    {
        this.oidSubacceso = oidSubacceso;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public BigDecimal getMontoMaxDiferencia()
    {
        return montoMaxDiferencia;
    }

    public void setMontoMaxDiferencia(BigDecimal montoMaxDiferencia)
    {
        this.montoMaxDiferencia = montoMaxDiferencia;
    }

    public BigDecimal getLimiteEfectCaja()
    {
        return limiteEfectCaja;
    }

    public void setLimiteEfectCaja(BigDecimal limiteEfectCaja)
    {
        this.limiteEfectCaja = limiteEfectCaja;
    }

    public Integer getNroCajas()
    {
        return nroCajas;
    }

    public void setNroCajas(Integer nroCajas)
    {
        this.nroCajas = nroCajas;
    }

    public String getNombreLocal()
    {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal)
    {
        this.nombreLocal = nombreLocal;
    }

    public Long getOidMoviStockEnTransito()
    {
        return oidMoviStockEnTransito;
    }

    public void setOidMoviStockEnTransito(Long oidMoviStockEnTransito)
    {
        this.oidMoviStockEnTransito = oidMoviStockEnTransito;
    }

    public Long getAlertaStock()
    {
        return alertaStock;
    }

    public void setAlertaStock(Long alertaStock)
    {
        this.alertaStock = alertaStock;
    }

    public Integer getTiempoReposicion()
    {
        return tiempoReposicion;
    }

    public void setTiempoReposicion(Integer tiempoReposicion)
    {
        this.tiempoReposicion = tiempoReposicion;
    }

    public Long getOidMoviStockDevolucion()
    {
        return oidMoviStockDevolucion;
    }

    public void setOidMoviStockDevolucion(Long oidMoviStockDevolucion)
    {
        this.oidMoviStockDevolucion = oidMoviStockDevolucion;
    }

    public Long getOidTipoMoviCajaCobrar()
    {
        return oidTipoMoviCajaCobrar;
    }

    public void setOidTipoMoviCajaCobrar(Long oidTipoMoviCajaCobrar)
    {
        this.oidTipoMoviCajaCobrar = oidTipoMoviCajaCobrar;
    }

    public BigDecimal getFactorXLocal()
    {
        return factorXLocal;
    }

    public void setFactorXLocal(BigDecimal factorXLocal)
    {
        this.factorXLocal = factorXLocal;
    }

    public Integer getNroMaxProdu()
    {
        return nroMaxProdu;
    }

    public void setNroMaxProdu(Integer nroMaxProdu)
    {
        this.nroMaxProdu = nroMaxProdu;
    }

    public Long getOidMoviConfirmarStock()
    {
        return oidMoviConfirmarStock;
    }

    public void setOidMoviConfirmarStock(Long oidMoviConfirmarStock)
    {
        this.oidMoviConfirmarStock = oidMoviConfirmarStock;
    }

    public Long getOidMoviConfirmarStockTransito()
    {
        return oidMoviConfirmarStockTransito;
    }

    public void setOidMoviConfirmarStockTransito(Long oidMoviConfirmarStockTransito)
    {
        this.oidMoviConfirmarStockTransito = oidMoviConfirmarStockTransito;
    }

    public Long getOidMoviRegularizacion()
    {
        return oidMoviRegularizacion;
    }

    public void setOidMoviRegularizacion(Long oidMoviRegularizacion)
    {
        this.oidMoviRegularizacion = oidMoviRegularizacion;
    }

    public Long getOidMoviRegularizacionSAP()
    {
        return oidMoviRegularizacionSAP;
    }

    public void setOidMoviRegularizacionSAP(Long oidMoviRegularizacionSAP)
    {
        this.oidMoviRegularizacionSAP = oidMoviRegularizacionSAP;
    }

    public Long getOidMoviDevolStockExistencias()
    {
        return oidMoviDevolStockExistencias;
    }

    public void setOidMoviDevolStockExistencias(Long oidMoviDevolStockExistencias)
    {
        this.oidMoviDevolStockExistencias = oidMoviDevolStockExistencias;
    }

    public Long getOidMoviPeticionExistencias()
    {
        return oidMoviPeticionExistencias;
    }

    public void setOidMoviPeticionExistencias(Long oidMoviPeticionExistencias)
    {
        this.oidMoviPeticionExistencias = oidMoviPeticionExistencias;
    }

    public Long getOidTipoMoviCajaCierre()
    {
        return oidTipoMoviCajaCierre;
    }

    public void setOidTipoMoviCajaCierre(Long oidTipoMoviCajaCierre)
    {
        this.oidTipoMoviCajaCierre = oidTipoMoviCajaCierre;
    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public Long getOidCuentaCorriente()
    {
        return oidCuentaCorriente;
    }

    public void setOidCuentaCorriente(Long oidCuentaCorriente)
    {
        this.oidCuentaCorriente = oidCuentaCorriente;
    }

    public Long getOidEmpresa()
    {
        return oidEmpresa;
    }

    public void setOidEmpresa(Long oidEmpresa)
    {
        this.oidEmpresa = oidEmpresa;
    }

    public Long getOidTipoTransaccion()
    {
        return oidTipoTransaccion;
    }

    public void setOidTipoTransaccion(Long oidTipoTransaccion)
    {
        this.oidTipoTransaccion = oidTipoTransaccion;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }


    public void setNombreAdministrador(String nombreAdministrador)
    {
        this.nombreAdministrador = nombreAdministrador;
    }


    public String getNombreAdministrador()
    {
        return nombreAdministrador;
    }
}