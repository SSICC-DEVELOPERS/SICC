package es.indra.sicc.logicanegocio.bel;


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL;
import es.indra.sicc.dtos.bel.DTOParametrosBEL;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import java.math.BigDecimal;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoParametrosBelBean implements SessionBean 
{
    
    private SessionContext ctx;
    
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    { this.ctx = ctx; }

    public DTOSalida obtenerParametrosBel(DTOBusquedaParametrosBEL dtoE) throws MareException {
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.obtenerParametrosBel:Entrada");
        DAOMantenimientoParametrosBel dao = new DAOMantenimientoParametrosBel();
       
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.obtenerParametrosBel:Salida");
        return dao.obtenerParametrosBEL(dtoE);
    }

    public void guardarParametros(DTOParametrosBEL dtoE) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros:Entrada");

        Long oidCliente;
        
        if (dtoE.getOidCliente() == null) 
        {
            
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null):Entrada");
            UtilidadesLog.debug("DTO ENTRADA" + dtoE);
            
            DTOParametrosBEL dto = new DTOParametrosBEL();
            ClienteDatosBasicosLocalHome clieDatosBasicHome = this.getClienteDatosBasicosLocalHome();
            ClienteDatosBasicosLocal clieDatosBasicLocal = null;
            
            try {

                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).try:Entrada");
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros CodigoCliente " + dtoE.getCodigoCliente());
            
                clieDatosBasicLocal = clieDatosBasicHome.findByCodigoYPais(dtoE.getOidPais(), dtoE.getCodigoCliente());
                
                oidCliente = clieDatosBasicLocal.getOid();
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).try:Salida");
            } catch (NoResultException fe) {
                UtilidadesLog.info("MONMantenimientoParamerosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).catch:Entrada");

                ctx.setRollbackOnly();
                UtilidadesLog.error("****Error Metodo: guardarParametros: FinderException: " +
                    fe.getMessage());
                UtilidadesLog.error(fe);

                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).catch:Salida");
                throw new MareException(new Exception(), 
                    UtilidadesError.armarCodigoError(
                        ConstantesSEG.MODULO_MAE, "", 
                        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros:Salida");
        } else 
        {
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).else:Entrada");
            oidCliente = dtoE.getOidCliente();
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidCliente() == null).else:Salida");
        }
        
        if (dtoE.getOidParametro() == null) 
        {
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null):Entrada");
            try
            {
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).try:Entrada");
                UtilidadesLog.debug("DTO CREATE:" + dtoE );
            
                ParametrosBelcenterLocalHome prmBelCentrHome = this.getParametrosBelcenterLocalHome();
                ParametrosBelcenterLocal prmBelCenterLocal = prmBelCentrHome.create(
                    dtoE.getOidSubacceso(), dtoE.getDireccion(), 
                    dtoE.getMontoMaxDiferencia(), dtoE.getLimiteEfectCaja(), dtoE.getNroCajas(),
                    dtoE.getNombreLocal(), dtoE.getTiempoReposicion(), Float.valueOf(dtoE.getFactorXLocal().toString()), 
                    dtoE.getNroMaxProdu(), BigDecimal.valueOf(dtoE.getAlertaStock().longValue()),
                    dtoE.getNombreAdministrador(), oidCliente, dtoE.getOidEmpresa(),
                    dtoE.getOidTipoTransaccion(), dtoE.getOidCuentaCorriente(), 
                    dtoE.getOidTipoMoviCajaCobrar(), dtoE.getOidTipoMoviCajaCierre(),
                    dtoE.getOidMoviConfirmarStock(), dtoE.getOidMoviConfirmarStockTransito(),
                    dtoE.getOidMoviStockEnTransito(), dtoE.getOidMoviStockDevolucion(),
                    dtoE.getOidMoviRegularizacion(), dtoE.getOidMoviRegularizacionSAP(),
                    dtoE.getOidMoviDevolStockExistencias(), dtoE.getOidMoviPeticionExistencias(),
                    dtoE.getOidPais());
                    
                prmBelCenterLocal.setTelefono(dtoE.getTelefono());
                prmBelCentrHome.merge(prmBelCenterLocal);

                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).try:Salida");
            } catch(PersistenceException ce) {
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).catch:Entrada");

                ctx.setRollbackOnly();
                UtilidadesLog.error("****Error Metodo: guardarParametros: CreateException: " +
                    ce.getMessage());
                UtilidadesLog.error(ce);

                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).catch:Salida");
                
                throw new MareException(ce,UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null):Salida");
        } else
        {
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).else:Entrada");

            ParametrosBelcenterLocalHome prmBelCentrHome = this.getParametrosBelcenterLocalHome();
            ParametrosBelcenterLocal prmBelCentrLocal = null;
            
            try {
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).else.try:Entrada");

                prmBelCentrLocal = prmBelCentrHome.findByUK(dtoE.getOidPais(), dtoE.getOidSubacceso());

                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).else.try:Salida");
            } catch (NoResultException fe) {
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).else.catch:Entrada");
                ctx.setRollbackOnly();
                UtilidadesLog.error("****Error Metodo: buscarParametrosBel: FinderException: " +
                    fe.getMessage());
                UtilidadesLog.error(fe);
                UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros.if (dtoE.getOidParametro() == null).else.catch:Salida");
                throw new MareException(fe,UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            prmBelCentrLocal.setAlertaStock( BigDecimal.valueOf(dtoE.getAlertaStock().longValue()));

            prmBelCentrLocal.setCliente(oidCliente);
            prmBelCentrLocal.setUsuario(dtoE.getNombreAdministrador());
            prmBelCentrLocal.setDireccion(dtoE.getDireccion());
            prmBelCentrLocal.setLimiteEfectivoCaja(dtoE.getLimiteEfectCaja());
            prmBelCentrLocal.setMontoMaximoDiferencia(dtoE.getMontoMaxDiferencia());
            prmBelCentrLocal.setNombreDeLocal(dtoE.getNombreLocal());
            prmBelCentrLocal.setNumeroDeCajas(dtoE.getNroCajas());
            prmBelCentrLocal.setNumeroMaximoProductos(dtoE.getNroMaxProdu());
            prmBelCentrLocal.setCuentaCorriente(dtoE.getOidCuentaCorriente());
            prmBelCentrLocal.setEmpresa(dtoE.getOidEmpresa());
            prmBelCentrLocal.setMovimientoConfirmarStock(dtoE.getOidMoviConfirmarStock());
            prmBelCentrLocal.setMovimientoConfirmarStockEnTransito(dtoE.getOidMoviConfirmarStockTransito());
            prmBelCentrLocal.setMovimientoDevolverStockExistencias(dtoE.getOidMoviDevolStockExistencias());
            prmBelCentrLocal.setMovimientoPeticionExistencias(dtoE.getOidMoviPeticionExistencias());
            prmBelCentrLocal.setMovimientoRegularizacion(dtoE.getOidMoviRegularizacion());
            prmBelCentrLocal.setMovimientoRegularizacionSAP(dtoE.getOidMoviRegularizacionSAP());
            prmBelCentrLocal.setMovimientoStockDevolucion(dtoE.getOidMoviStockDevolucion());
            prmBelCentrLocal.setMovimientoStockEnTransito(dtoE.getOidMoviStockEnTransito());
            prmBelCentrLocal.setTipoMovimientoCierre(dtoE.getOidTipoMoviCajaCierre());
            prmBelCentrLocal.setTipoMovimientoCobrar(dtoE.getOidTipoMoviCajaCobrar());
            prmBelCentrLocal.setTipoTransaccion(dtoE.getOidTipoTransaccion());
            prmBelCentrLocal.setTelefono(dtoE.getTelefono());
            prmBelCentrLocal.setTiempoDeReposicion(dtoE.getTiempoReposicion());
            
            prmBelCentrHome.merge(prmBelCentrLocal);
        }
        
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.guardarParametros:Salida");
    }

    public DTOParametrosBEL buscarParametrosBel(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel:Entrada");

        DTOParametrosBEL dto = new DTOParametrosBEL();
        ParametrosBelcenterLocalHome prmBelCentrHome = getParametrosBelcenterLocalHome();
        ParametrosBelcenterLocal prmBelCentrLocal = null;

        SubaccesoLocalHome subaccesoHome = getSubaccesoLocalHome();
        SubaccesoLocal subaccesoLocal = null;
        
        AccesoLocalHome accesoHome = getAccesoLocalHome();
        AccesoLocal accesoLocal = null;

        CanalLocalHome canalHome = getCanalLocalHome();
        CanalLocal canalLocal = null;
        
        ClienteDatosBasicosLocalHome clienteHome = getClienteDatosBasicosLocalHome();
        ClienteDatosBasicosLocal clienteLocal = null;
        
        try {
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel.try:Entrada");
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel.try:oidPais " 
                + dtoE.getOidPais());
            
            prmBelCentrLocal = prmBelCentrHome.findByPrimaryKey(dtoE.getOid());
            subaccesoLocal = subaccesoHome.findByPrimaryKey(prmBelCentrLocal.getSubacceso());
            accesoLocal = accesoHome.findByPrimaryKey(subaccesoLocal.getOidAcceso());
            canalLocal = canalHome.findByPrimaryKey(accesoLocal.getOidCanal());
            clienteLocal = clienteHome.findByPrimaryKey(prmBelCentrLocal.getCliente());
            
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel.try:Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel.catch:Entrada");
        
            //ctx.setRollbackOnly();
            UtilidadesLog.error("****Error Metodo: buscarParametrosBel: FinderException: " +
                fe.getMessage());
            UtilidadesLog.error(fe);

            UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel.catch:Salida");
            throw new MareException(fe,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        dto.setAlertaStock(Long.valueOf(prmBelCentrLocal.getAlertaStock().toString()));
        dto.setOidCliente(prmBelCentrLocal.getCliente());
        dto.setCodigoCliente(clienteLocal.getCod_clie());
        dto.setDireccion(prmBelCentrLocal.getDireccion());
        dto.setLimiteEfectCaja(prmBelCentrLocal.getLimiteEfectivoCaja());
        dto.setMontoMaxDiferencia(prmBelCentrLocal.getMontoMaximoDiferencia());
        dto.setNombreLocal(prmBelCentrLocal.getNombreDeLocal());
        dto.setNroCajas(prmBelCentrLocal.getNumeroDeCajas());
        dto.setNroMaxProdu(prmBelCentrLocal.getNumeroMaximoProductos());
        dto.setOidCuentaCorriente(prmBelCentrLocal.getCuentaCorriente());
        dto.setOidEmpresa(prmBelCentrLocal.getEmpresa());
        dto.setNombreAdministrador(prmBelCentrLocal.getUsuario());
        dto.setFactorXLocal(new BigDecimal(prmBelCentrLocal.getFactorLocal().toString()));
        dto.setOidMoviConfirmarStock(prmBelCentrLocal.getMovimientoConfirmarStock());
        dto.setOidMoviConfirmarStockTransito(prmBelCentrLocal.getMovimientoConfirmarStockEnTransito());
        dto.setOidMoviDevolStockExistencias(prmBelCentrLocal.getMovimientoDevolverStockExistencias());
        dto.setOidMoviPeticionExistencias(prmBelCentrLocal.getMovimientoPeticionExistencias());
        dto.setOidMoviRegularizacion(prmBelCentrLocal.getMovimientoRegularizacion());
        dto.setOidMoviRegularizacionSAP(prmBelCentrLocal.getMovimientoRegularizacionSAP());
        dto.setOidMoviStockDevolucion(prmBelCentrLocal.getMovimientoStockDevolucion());
        dto.setOidMoviStockEnTransito(prmBelCentrLocal.getMovimientoStockEnTransito());
        dto.setOidParametro(prmBelCentrLocal.getOid());
        dto.setOidSubacceso(subaccesoLocal.getOid());
        dto.setOidAcceso(accesoLocal.getOid());
        dto.setOidCanal(canalLocal.getOid());
        dto.setOidTipoMoviCajaCierre(prmBelCentrLocal.getTipoMovimientoCierre());
        dto.setOidTipoMoviCajaCobrar(prmBelCentrLocal.getTipoMovimientoCobrar());
        dto.setOidTipoTransaccion(prmBelCentrLocal.getTipoTransaccion());
        dto.setTelefono(prmBelCentrLocal.getTelefono());
        dto.setTiempoReposicion(prmBelCentrLocal.getTiempoDeReposicion());
        dto.setOidPais(dtoE.getOidPais());
        dto.setOidIdioma(dtoE.getOidIdioma());
                
        UtilidadesLog.info("MONMantenimientoParametrosBelBean.buscarParametrosBel:Salida");
        return dto;
    }
    
    private void loguearError(String mensaje,Throwable e) {
		UtilidadesLog.error("****Error Metodo: " + mensaje + ": " + e.getMessage());
		UtilidadesLog.error(e);
	}

    public void eliminarParametrosBEL(DTOOIDs dto) throws MareException {
    		 UtilidadesLog.info("MONMantenimientoParametrosBelBean.eliminarParametrosBEL(DTOOIDs dto):Entrada");
        /*
         * Para cada "oid" encontrado en DTOE hacer:
         * {
         * parametroBel = Llamar al método findByPrimaryKey(oid) de la entidad ParametrosBelcenter
         * parametroBel.remove()
         * }
         */
        Long oids[] = dto.getOids();
        String codigoError = null;
       
        if(oids != null && oids.length > 0) {
            try {
                ParametrosBelcenterLocalHome parametrosBelLocalHome = getParametrosBelcenterLocalHome();
                            
                for (int i = 0; i < oids.length; i++) {
                    ParametrosBelcenterLocal parametrosBel = parametrosBelLocalHome.findByPrimaryKey(oids[i]);
                    parametrosBelLocalHome.remove(parametrosBel);
                }
            } catch (NoResultException fe) {		
				this.loguearError("eliminarMediosPagoBelcenter: FinderException", fe);
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_ELIMINAR_NO_EXISTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch (PersistenceException re) {
				this.loguearError("eliminarMediosPagoBelcenter: RemoveException" , re);
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
		UtilidadesLog.info("MONMantenimientoParametrosBelBean.eliminarParametrosBEL(DTOOIDs dto):Salida");
    }

    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
        return new ParametrosBelcenterLocalHome();
    }

    private AccesoLocalHome getAccesoLocalHome() {
        return new AccesoLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {
        return new CanalLocalHome();
    }

    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }


}
