/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOCruzarCupon3conCupon1;
import es.indra.sicc.dtos.ccc.DTOSituacionCupones;
import es.indra.sicc.entidades.ccc.SituacionCuponesLocal;
import es.indra.sicc.entidades.ccc.SituacionCuponesLocalHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;


public class MONGestionCuponTramiteBean implements SessionBean {
    private final static String MON_VALIDACION = "MONValidacion";
    private SessionContext ctx;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
    }

    public void cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto)
        throws MareException {
		UtilidadesLog.info("MONGestionCuponTramiteBean.cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto): Entrada"); 
        //-> Tomar el dto de entrada para la siguiente llamada
        //-> Llamar al método "DAOGestionCuponTramite.cruzarCupon3conCupon1(dto : DTOCruzarCupon3conCupon1) : DTOSalida"
        UtilidadesLog.debug("recibo..: " + dto);
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
        DAOCCC daoCCC = new DAOCCC();
        long numeroDiasCruceCupon3 = daoCCC.obtenerDiasCruceCup3(dto.getOidPais().longValue());
        UtilidadesLog.debug("numeroDiasCruceCupon3..: " + numeroDiasCruceCupon3);
        DAOGestionCuponTramite daoGestionCuponTramite = new DAOGestionCuponTramite();
        DTOSalida dtoSalida = new DTOSalida();
        boolean comparoImportePorIgual = true;
        dtoSalida = daoGestionCuponTramite.cruzarCupon3conCupon1(dto, numeroDiasCruceCupon3, comparoImportePorIgual);

        RecordSet cuponesEncontrados = new RecordSet();
        cuponesEncontrados = dtoSalida.getResultado();
        UtilidadesLog.debug("cuponesEncontrados (importe igual)..: " + cuponesEncontrados);
        
         // vbongiov -- 24/06/2008
        if (!cuponesEncontrados.esVacio()) {
            //flujo alt. 4
            throw new MareException(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                                                                          ErroresDeNegocio.CUPON_EXISTENTE));
            
        } else {
            comparoImportePorIgual = false;
            dtoSalida = daoGestionCuponTramite.cruzarCupon3conCupon1(dto, numeroDiasCruceCupon3, comparoImportePorIgual);
            RecordSet cuponesEncontradosNoIgual = new RecordSet();
            cuponesEncontradosNoIgual = dtoSalida.getResultado();
            UtilidadesLog.debug("cuponesEncontrados (importe no igual)..: " + cuponesEncontradosNoIgual);
            
            if (!cuponesEncontradosNoIgual.esVacio()) {
                 //flujo alt. 3
                 daoGestionCuponTramite.creoCabeceraYDetalle(dto, CCCConstantes.SITUACION_CUPON_DEPURACION);
             } else {
                //flujo alt. 2
                daoGestionCuponTramite.creoCabeceraYDetalle(dto, CCCConstantes.SITUACION_CUPON_TRAMITE);
             }
        }

		UtilidadesLog.info("MONGestionCuponTramiteBean.cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto): Salida"); 
    }

    public DTOSalida consultarCupon3(DTOConsultarCupon3 dto)
        throws MareException {
        //Parámetros e/s 
        //Entrada: DTOConsultarCupon3 dto 
        //Salida: DTOSalida 
        UtilidadesLog.info("MONGestionCuponTramiteBean.consultarCupon3(DTOConsultarCupon3 dto): Entrada"); 
        
        RecordSet rs = new RecordSet();
        DAOGestionCuponTramite daoGestionCuponTramite = new DAOGestionCuponTramite();
        DTOSalida dtoS = new DTOSalida();
        UtilidadesLog.debug("***- DTO para consulta: "+dto);
        dtoS = daoGestionCuponTramite.consultarCupon3(dto);
        UtilidadesLog.debug("***-la consulta trajo: "+dtoS);
        rs = dtoS.getResultado();
        UtilidadesLog.debug("***- RS: "+rs);
        if (rs.esVacio()) {
            //GEN-0007 --> 005                                                                                  
            UtilidadesLog.debug(
                "****DAOGestionCuponTramite.buscarRegistroVentas(dto): No hay datos ");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.consultarCupon3(DTOConsultarCupon3 dto): Salida"); 

        return dtoS;
    }

    public DTOSalida consultarCupon3(DTOCancelarCupon3 dto)
        throws MareException {
        //Entrada: DTOCancelarCupon3 dto 
        //Salida: DTOSalida 
        UtilidadesLog.info("MONGestionCuponTramiteBean.consultarCupon3(DTOCancelarCupon3 dto): Entrada"); 

        RecordSet rs = new RecordSet();
        DAOGestionCuponTramite daoGestionCuponTramite = new DAOGestionCuponTramite();
        DTOSalida dtoS = new DTOSalida();
        SituacionCuponesLocalHome scuponHome = this.getSituacionCuponesLocalHome();
        SituacionCuponesLocal scupon = null;

        try {
            scupon = scuponHome.findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_CONCILIADO);
            UtilidadesLog.debug("scupon: " + scupon);
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        dtoS = daoGestionCuponTramite.consultarCupon3(dto, scupon.getOid());
        rs = dtoS.getResultado();

        if (rs.esVacio()) {
            //GEN-0007 --> 005                                                                                  
            UtilidadesLog.debug(
                "****DAOGestionCuponTramite.buscarRegistroVentas(dto): No hay datos ");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.consultarCupon3(DTOCancelarCupon3 dto): Salida"); 

        return dtoS;
    }
    public void cancelarCupon3(DTOOIDs dtoOIDs) throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.cancelarCupon3(DTOOIDs dtoOIDs): Entrada"); 

        //Establece a "Conciliado" cada uno de los registros seleccionados en la lista 
        //Parámetros e/s 
        //Entrada: DTOOIDs dtoOIDs 
        //Salida: void 
        //Localizamos la entidad SituacionCupon correspondiente a "(C)onciliado": 
        SituacionCuponesLocalHome scuponHome = this.getSituacionCuponesLocalHome();
        SituacionCuponesLocal scupon = null;

        try {
            scupon = scuponHome.findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_CONCILIADO);
            UtilidadesLog.debug("scupon: " + scupon);
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Long oidSitu = scupon.getOid();
        UtilidadesLog.debug("oidSitu: " + oidSitu);

        //Localizamos la interface "Home" (detalleHome) de la entidad "DetalleCuponesTramiteDepuracion" 
        DAOGestionCuponTramite daoGCT = new DAOGestionCuponTramite();
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
        for (int i = 0; i < dtoOIDs.getOids().length; i++) {
            //Localizamos cada entidad a través de su OID: 
            UtilidadesLog.debug("oid leido: " + dtoOIDs.getOids()[i]);
            daoGCT.updateSitu(dtoOIDs.getOids()[i], oidSitu);
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.cancelarCupon3(DTOOIDs dtoOIDs): Salida"); 
    }


    public DTOColeccion situacionesACancelar() throws MareException {
        //Parámetros e/s 
        //Entrada: void 
        //Salida: DTOColeccion ( de objetos DTOSituacionCupones) 
        UtilidadesLog.info("MONGestionCuponTramiteBean.situacionesACancelar(): Entrada"); 

        ArrayList lista = new ArrayList();
        DTOSituacionCupones dto = new DTOSituacionCupones();

        //Localizamos la interface Home de la entidad SituacioCupones
        SituacionCuponesLocalHome situHome = this.getSituacionCuponesLocalHome();
        SituacionCuponesLocal situ = null;

        try {
            situ = situHome.findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_TRAMITE);
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (situ != null) {
            dto.setOid(situ.getOid());
            dto.setCodigoSituacion(situ.getCodigoSituacion());
            dto.setDescripcion(situ.getDescripcion());
            lista.add(dto);
        }

        try {
            situ = situHome.findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_DEPURACION);
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (situ != null) {
            dto = new DTOSituacionCupones();
            dto.setOid(situ.getOid());
            dto.setCodigoSituacion(situ.getCodigoSituacion());
            dto.setDescripcion(situ.getDescripcion());
            lista.add(dto);
        }

        DTOColeccion coleccion = new DTOColeccion();
        coleccion.setLista(lista);
        UtilidadesLog.info("MONGestionCuponTramiteBean.situacionesACancelar(): Salida"); 

        return coleccion;
    }

    //cambio fac 03, modulo ccc (SCS-29/01/2008), se modifica!!
    public void eliminarCupon3(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.eliminarCupon3(DTOOIDs dto): Entrada"); 

        Long[] valores = dto.getOids();
        //cambio fac 03, modulo ccc (SCS-29/01/2008), se modifica!!
        /*DetalleCuponesTramiteDepuracionLocalHome detalleCuponesTramiteDepuracionLH = null;
        DetalleCuponesTramiteDepuracionLocal detalleCuponesTramiteDepuracionL = null;
        detalleCuponesTramiteDepuracionLH = this.getDetalleCuponesTramiteDepuracionLocalHome();*/
            boolean masDetas = false;
            for (int i = 0; i < valores.length; i++) {
                    UtilidadesLog.debug("oid tratado: " + valores[i]);
                    //this.validaAcceso(dto.getOidPais(), null, 
                    //    null, null, null, null, null, null, null, null, null);
                    /*detalleCuponesTramiteDepuracionL = detalleCuponesTramiteDepuracionLH.findByPrimaryKey(valores[i]);
                    detalleCuponesTramiteDepuracionL.remove();*/
                    
                    masDetas = false;
                    DAOGestionCuponTramite daoGestionCuponTramite = new DAOGestionCuponTramite();
                    long cabeceraParaEsteDetalle = daoGestionCuponTramite.cabeceraParaEsteDetalle(valores[i]);
                    UtilidadesLog.debug("cabeceraParaEsteDetalle: " + cabeceraParaEsteDetalle);
                    
                    masDetas = daoGestionCuponTramite.masDetalles(valores[i]);
                    UtilidadesLog.debug("hay mas detalles?: " + masDetas);
                    daoGestionCuponTramite.eliminoDetalle(valores[i].longValue());
                    
                    if (!masDetas){
                        UtilidadesLog.debug("no hay + detalles, elim. cabecera");
                        daoGestionCuponTramite.eliminoCabecera(cabeceraParaEsteDetalle);
                    }
            }

        /*->
        -> Llamar al método "findByPrimaryKey()" de la entidad "DetalleCuponesTramiteDepuracion"
        -> Recorrer el atributo dto.oids
        (1)Para cada oid contenido en dto.oids hacer:
            -> Llamar al método "findByPrimaryKey()" de la entidad "DetalleCuponesTramiteDepuracion" tomando el oid
            -> Llamar el método "remove()" del entity recuperado
        (1)Fin Para
        */
        /*  VIEJO NO VALE SE CAMBIO POR INCIDENCIA BELC300009839
                //Localizamos la interface Home del Entity "DetalleCuponesTramiteDepuracion"
                DetalleCuponesTramiteDepuracionLocalHome detalleCuponesTramiteDepuracionLH = null;

                detalleCuponesTramiteDepuracionLH = this.getDetalleCuponesTramiteDepuracionLocalHome();
                Long oids [] = dto.getOids();
                for(int i = 0; i<oids.length; i++){
                    DetalleCuponesTramiteDepuracionLocal detalleCuponesTramiteDepuracionL = null;
                    //invocamos la método remove(dtoOIDs.oids[i]) del interface Home obtenido para eliminarlo.
                    //Si capturamos una Exception (no se ha podido borrar) establecemos todos=false;
                    try{

                        detalleCuponesTramiteDepuracionL = detalleCuponesTramiteDepuracionLH.findByPrimaryKey(oids[i]);
                        detalleCuponesTramiteDepuracionL.remove();

                    }catch(RemoveException ce){
                        //Si capturamos una Exception (no se ha podido borrar) establecemos todos=false;
                        todos = new Boolean(Boolean.FALSE.booleanValue());
                        UtilidadesLog.error("eliminarCupon3: RemoveException",ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                    catch (FinderException e) {
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        this.logearError("eliminarCupon3: FinderException", e);
                        throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                    }

                }
                if(todos.booleanValue()){//Si se han eliminado todos los detalles eliminamos la cabecera

                    DetalleCuponesTramiteDepuracionLocal detalleCuponesTramiteDepuracionLocal = null;
                    //Con el interface obtenido al principio del método localizamos el primer Entity
                    //"DetalleCuponesTramiteDepuracion" llamando a:
                    try{
                        detalleCuponesTramiteDepuracionLocal = detalleCuponesTramiteDepuracionLH.findByPrimaryKey(oids[0]);
                        Long oidCabecera = detalleCuponesTramiteDepuracionLocal.getTheCabeceraCuponesTramiteDepuracion();

                         //Localizamos la interface Home del Entity "CabeceraCuponesTramiteDepuracion"
                        //Invocamos al método remove(oidCabecera) y eliminamos el registro.
                        CabeceraCuponesTramiteDepuracionLocalHome cabeceraCuponesTramiteDepuracionLH = null;
                        CabeceraCuponesTramiteDepuracionLocal cabeceraCuponesTramiteDepuracionLocal = null;
                        cabeceraCuponesTramiteDepuracionLH = this.getCabeceraCuponesTramiteDepuracionLocalHome();
                        cabeceraCuponesTramiteDepuracionLocal = cabeceraCuponesTramiteDepuracionLH.findByPrimaryKey(oidCabecera);

                        cabeceraCuponesTramiteDepuracionLocal.remove();
                    }catch(RemoveException ce){
                        UtilidadesLog.error("eliminarCupon3: RemoveException",ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                    catch (FinderException e) {
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        this.logearError("eliminarCupon3: FinderException", e);
                        throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                    }

                }
        */
        UtilidadesLog.info("MONGestionCuponTramiteBean.eliminarCupon3(DTOOIDs dto): Salida");
    }

    private SituacionCuponesLocalHome getSituacionCuponesLocalHome()
        throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.getSituacionCuponesLocalHome(): Entrada");
        UtilidadesLog.info("MONGestionCuponTramiteBean.getSituacionCuponesLocalHome(): Salida");

        return new SituacionCuponesLocalHome();
    }

    private void logearError(Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error(e);
    }

    private void loguearSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("MONGestionCuponTramiteBean.loguearSql(String metodo, String sql, Vector params): Entrada");
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                if (params.elementAt(i) != null) {
                    sParams += ("param " + (i + 1) + ": " +
                    (params.elementAt(i)).toString() + ", ");
                } else {
                    sParams += ("param " + (i + 1) + ": es nulo, ");
                }
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("MONGestionCuponTramiteBean.loguearSql(String metodo, String sql, Vector params): Salida");
    }
    
    private void loguearError(Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error(e);
    }

    private void loguearStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: " + ex.getMessage());
        }
    }

    private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais +
            ",sociedad = " + sociedad + ", marca=" + marca + ", canal= " +
            canal + ", acceso=" + acceso + ",subacceso = " + subacceso +
            ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal,
                    acceso, subacceso, subgerencia, region, zona, seccion,
                    territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(rExc);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long seccion, Long territorio): Salida");
    }

    private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome(MON_VALIDACION,
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError(e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.getMONValidacion(): Salida");

        return ejb;
    }

    private void validaVinculos(Long pais, Long sociedad, Long marca,
        Long canal, Long acceso, Long subAcceso)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONGestionCuponTramiteBean.validaVinculos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("**** Llamada a validaVinculos(pais= " + pais +
            ", marca= " + marca + ", canal= " + canal + ", acceso= " + acceso +
            ")");
        b = monValidacion.validarVinculos(pais, sociedad, marca, canal, acceso,
                subAcceso);
        UtilidadesLog.debug("**** Retorno validaVinculos:  " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaVinculos: validarVinculos : ERROR_VINCULOS_INVALIDOS");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_VINCULOS_INVALIDOS));
        }

        UtilidadesLog.info("MONGestionCuponTramiteBean.validaVinculos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso): Salida");
    }

    private void validaAccesoVinculos(Long pais, Long empresa, Long sociedad,
        Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia,
        Long region, Long zona, Long seccion, Long territorio)
        throws RemoteException, MareException {
        
        UtilidadesLog.info("MONGestionCuponTramiteBean.validaAccesoVinculos(Long pais, Long empresa, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");
        
        validaAcceso(pais, empresa, marca, canal, acceso, subAcceso,
            subgerencia, region, zona, seccion, territorio);
        validaVinculos(pais, sociedad, marca, canal, acceso, subAcceso);
        
        UtilidadesLog.info("MONGestionCuponTramiteBean.validaAccesoVinculos(Long pais, Long empresa, Long sociedad, Long marca, Long canal, Long acceso, Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }
}
