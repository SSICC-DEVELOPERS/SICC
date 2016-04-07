/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
/**
 * @Autor: Hugo A. Mansi
 * @Fecha: 28/10/2004
 * @DMCO: SICC-DMCO-PED-201-354-N029
 * @Modifico: --
 * @Modificado: --
 * @Descripción:--
 * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
 *
 */
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.ped.DTOCargarPaginaDesglose;
import es.indra.sicc.dtos.ped.DTOEDesglose;
import es.indra.sicc.entidades.ped.GrupoProcesosLocal;
import es.indra.sicc.entidades.ped.GrupoProcesosLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;


public class MONDesglosesBean implements SessionBean {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 28/10/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción:--
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOCargarPaginaDesglose cargarPaginaDesglose(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("MONDesglosesBean.cargarPaginaDesglose(DTOEDesglose dto): Entrada ");
    
        /*// Crear variable llamada "respuesta" de tipo "DTOCargarPaginaDesgloseTSC
        DTOCargarPaginaDesglose rta = new DTOCargarPaginaDesglose();
        // respuesta.oidZona = dto.zona 
        rta.setOidZona(dto.getZona());
        // Hacer findByPrimaryKey sobre la entidad "Zona" tomando dto.zona 
        //ZonaLocalHome zonaLH = ZONEjbLocators.getZonaLocalHome();
        //ZonaLocal zona = zonaLH.findByPrimaryKey(dto.getZona());
        // AGREGADO: respuesta.descripcionZona = zona.descripcion
        rta.setDescripcionZona(zona.getDescripcion());
        // respuesta.oidMarca = Zona.oidMarca 
        rta.setOidMarca(zona.getOidMarca());
        // Hacer findByPrimaryKey sobre la entidad "Marca" tomando Zona.oidMarca 
        //MarcaLocalHome marcaLH = this.getMarcaLocalHome();
        //MarcaLocal marca = marcaLH.findByPrimaryKey(zona.getOidMarca());
        // respuesta.descripcionMarca = Marca.descripcion 
        rta.setDescripcionMarca(marca.getDes_marc());
        // respuesta.oidCanal = Zona.oidCanal 
        rta.setOidCanal(zona.getOidCanal());
        // Hacer findByPrimaryKey sobre la entidad "Canal" tomando Zona.oidCanal 
        //CanalLocalHome canalLH = this.getCanalLocalHome();
        //CanalLocal canal = canalLH.findByPrimaryKey(zona.getOidCanal());
        // respuesta.descripcionCanal = Descripción internacionalizada de Canal para Zona.oidCanal 
        //Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
        //Entidadi18nLocal i18n = e18nLH.findByEntAtrIdioPK("SEG_CANAL", new Long(1), dto.getOidIdioma(), zona.getOidCanal());
        rta.setDescripcionCanal(i18n.getDetalle());
        // respuesta.oidGrupoProcesos = dto.grupoProcesos 
        rta.setOidGrupoProcesos(dto.getGrupoProcesos());
        //GrupoProcesosLocalHome grupoLH = this.getGrupoProcesosLocalHome();
        //GrupoProcesosLocal grupo = grupoLH.findByPrimaryKey(dto.getGrupoProcesos());
        rta.setDescripcionGrupoProcesos(grupo.getDes_grup_proc());
        rta.setOidTipoSolicitud(dto.getTipoSolicitud());
        //TiposSolicitudPaisLocalHome tipoSolPaisLH = this.getTiposSolicitudPaisLocalHome();
        //Modificado por jrivas 13/1/2005
        //TiposSolicitudPaisLocal pais = tipoSolPaisLH.findByPrimaryKey(dto.getOidPais());
        //TiposSolicitudPaisLocal pais = tipoSolPaisLH.findByPrimaryKey(dto.getTipoSolicitud());
        //i18n = e18nLH.findByEntAtrIdioPK("PED_TIPO_SOLIC", new Long(1), dto.getOidIdioma(), pais.getOidTipoSolicitud());
        rta.setDescripcionTipoSolicitud(i18n.getDetalle());
        */
        DAODesgloses miDao = new DAODesgloses();
        RecordSet datos = miDao.obtenerDatosPaginaDesglose(dto.getZona().longValue(),
                                                           dto.getGrupoProcesos().longValue(), 
                                                           dto.getTipoSolicitud().longValue(), 
                                                           dto.getOidIdioma().longValue());

        DTOCargarPaginaDesglose rta = new DTOCargarPaginaDesglose();
        rta.setOidZona(dto.getZona());
        rta.setDescripcionZona(datos.getValueAt(0,"DES_ZONA").toString());
        rta.setOidMarca(new Long(datos.getValueAt(0,"OID_MARC").toString()));
        rta.setDescripcionMarca(datos.getValueAt(0,"DES_MARC").toString());
        rta.setOidCanal(new Long(datos.getValueAt(0,"OID_CANA").toString()));
        rta.setDescripcionCanal(datos.getValueAt(0,"DES_CANAL").toString());
        rta.setOidGrupoProcesos(dto.getGrupoProcesos());
        rta.setDescripcionGrupoProcesos(datos.getValueAt(0,"DES_GRUP_PROCE").toString());
        rta.setOidTipoSolicitud(dto.getTipoSolicitud());
        if( datos.getValueAt(0,"DES_TIPO_SOL_PAIS") != null ){
          rta.setDescripcionTipoSolicitud(datos.getValueAt(0,"DES_TIPO_SOL_PAIS").toString());
        } else {
          rta.setDescripcionTipoSolicitud("");
        }

                                                           
        DTOSalida dtoOut = new DTOSalida();                                                 
        if (dto.getTipoDesglose() == ConstantesDesglosesPED.DESGLOSE_TIPO_SUBTIPO_CLASIFICACION) {
          dtoOut = miDao.agrupacionTipoSubtipoClasificacionCliente(dto);
        } else if (dto.getTipoDesglose() == ConstantesDesglosesPED.DESGLOSE_ACCESO) {
          dtoOut = miDao.agrupacionAcceso(dto);
        } else if (dto.getTipoDesglose() == ConstantesDesglosesPED.DESGLOSE_ESTADOS) {
          dtoOut = miDao.agrupacionEstados(dto);
        } else if (dto.getTipoDesglose() == ConstantesDesglosesPED.DESGLOSE_CONTENIDO) {
          dtoOut = miDao.agrupacionContenido(dto);
        }
        rta.setTotalSolcitudes(new Long(dtoOut.getResultado().getValueAt(0, 0).toString()));
        UtilidadesLog.info("MONDesglosesBean.cargarPaginaDesglose(DTOEDesglose dto): Salida ");
        
        return rta;

      //fin si
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 28/10/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción:-> Llamar al método "DAODesgloses.agrupacionTipoSubtipoClasificacionCliente
         *                 pasando el dto de entrada
         *          -> Devolver respuesta a la llamada anterior
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("MONDesglosesBean.agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto): Entrada ");
        DAODesgloses miDao = new DAODesgloses();
		UtilidadesLog.debug("Llamando a DAO");
        DTOSalida dtoOut = miDao.agrupacionTipoSubtipoClasificacionCliente(dto);
        UtilidadesLog.info("MONDesglosesBean.agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
        * @Autor: Hugo A. Mansi
        * @Fecha: 01/11/2004
        * @DMCO: SICC-DMCO-PED-201-354-N029
        * @Modifico: --
        * @Modificado: --
        * @Descripción:-> Llamar al método "DAODesgloses.desgloseNumeroSolicitud(dto : DTOEDesglose) : DTOSalida" pasando el dto de entrada
        *              -> Devolver respuesta a la llamada anterior
        * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
        *
        */
    public DTOSalida desgloseNumeroSolicitud(DTOEDesglose dto) throws MareException {
		UtilidadesLog.info("MONDesglosesBean.desgloseNumeroSolicitud(DTOEDesglose dto): Entrada ");
        DAODesgloses miDao = new DAODesgloses();
        DTOSalida dtoOut = new DTOSalida();
		UtilidadesLog.debug("Llamando a DAO");
        dtoOut = miDao.desgloseNumeroSolicitud(dto);
		UtilidadesLog.info("MONDesglosesBean.desgloseNumeroSolicitud(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
         * @Autor: Hugo A. Mansi
         * @Fecha: 01/11/2004
         * @DMCO: SICC-DMCO-PED-201-354-N029
         * @Modifico: --
         * @Modificado: --
         * @Descripción:-> Llamar al método "DAODesgloses.agrupacionAcceso(dto : DTOEDesglose) : DTOSalida" pasando el dto de entrada
         *               -> Devolver respuesta a la llamada anterior
         * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
         *
         */
    public DTOSalida agrupacionAcceso(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("MONDesglosesBean.agrupacionAcceso(DTOEDesglose dto): Entrada ");
        DAODesgloses miDao = new DAODesgloses();
        DTOSalida dtoOut = new DTOSalida();
        dtoOut = miDao.agrupacionAcceso(dto);
        UtilidadesLog.info("MONDesglosesBean.agrupacionAcceso(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 01/11/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción:-> Llamar al método "DAODesgloses.agrupacionEstados(dto : DTOEDesglose) : DTOSalida" pasando el dto de entrada
     *               -> Devolver respuesta a la llamada anterior
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida agrupacionEstados(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("MONDesglosesBean.agrupacionEstados(DTOEDesglose dto): Entrada ");
        DAODesgloses miDao = new DAODesgloses();
        DTOSalida dtoOut = new DTOSalida();
        dtoOut = miDao.agrupacionEstados(dto);
        UtilidadesLog.info("MONDesglosesBean.agrupacionEstados(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 01/11/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción:-> Llamar al método "DAODesgloses.agrupacionContenido(dto : DTOEDesglose) : DTOSalida" pasando el dto de entrada
     *               -> Devolver respuesta a la llamada anterior
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida agrupacionContenido(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("MONDesglosesBean.agrupacionContenido(DTOEDesglose dto): Entrada ");
        DAODesgloses miDao = new DAODesgloses();
        DTOSalida dtoOut = new DTOSalida();
        dtoOut = miDao.agrupacionContenido(dto);
        UtilidadesLog.info("MONDesglosesBean.agrupacionContenido(DTOEDesglose dto): Salida ");
        return dtoOut;
    }


}
