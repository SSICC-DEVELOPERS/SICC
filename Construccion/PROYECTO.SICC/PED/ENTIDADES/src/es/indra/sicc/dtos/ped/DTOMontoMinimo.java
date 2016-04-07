package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOOIDs;

import java.util.ArrayList;

public class DTOMontoMinimo extends DTOSiccPaginacion  {
    private BigDecimal nivel1;
    private BigDecimal nivel2;
    private BigDecimal nivel3;
    private BigDecimal recargo;
    private BigDecimal montoMinimo;
    private Long oid;
    private Long tipoSolicitudPais;
    private volatile Long oidTipoCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoClasificacion;
    private Long oidClasificacion;
    private ArrayList oidRegiones;
    private ArrayList oidZonas;

    public DTOMontoMinimo() {
    }

    public BigDecimal getNivel1() {
        return nivel1;
    }

    public void setNivel1(BigDecimal newNivel1) {
        nivel1 = newNivel1;
    }

    public BigDecimal getNivel2() {
        return nivel2;
    }

    public void setNivel2(BigDecimal newNivel2) {
        nivel2 = newNivel2;
    }

    public BigDecimal getNivel3() {
        return nivel3;
    }

    public void setNivel3(BigDecimal newNivel3) {
        nivel3 = newNivel3;
    }

    public BigDecimal getRecargo() {
        return recargo;
    }

    public void setRecargo(BigDecimal newRecargo) {
        recargo = newRecargo;
    }

    public BigDecimal getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(BigDecimal newMontoMinimo) {
        montoMinimo = newMontoMinimo;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getTipoSolicitudPais() {
        return tipoSolicitudPais;
    }

    public void setTipoSolicitudPais(Long newTipoSolicitudPais) {
        tipoSolicitudPais = newTipoSolicitudPais;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long newOidTipoCliente) {
        oidTipoCliente = newOidTipoCliente;
    }

    public Long getOidSubtipoCliente() {
        return oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        oidSubtipoCliente = newOidSubtipoCliente;
    }

    public Long getOidTipoClasificacion() {
        return oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        oidTipoClasificacion = newOidTipoClasificacion;
    }

    public Long getOidClasificacion() {
        return oidClasificacion;
    }

    public void setOidClasificacion(Long newOidClasificacion) {
        oidClasificacion = newOidClasificacion;
    }

    public ArrayList getOidRegiones()
    {
      return oidRegiones;
    }
    
    public void setOidRegiones(ArrayList newoidRegiones)
    {
      this.oidRegiones = newoidRegiones;
    }
    
    public ArrayList getOidZonas()
    {
      return oidZonas;
    }
    
    public void setOidZonas(ArrayList newoidZonas)
    {
      this.oidZonas = newoidZonas;
    }





}