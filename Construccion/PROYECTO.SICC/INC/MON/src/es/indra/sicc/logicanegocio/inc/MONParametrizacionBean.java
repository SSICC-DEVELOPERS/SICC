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
 * Autor : Julian Rivas, Marta Aurora Montiel, Igor Dedough
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.inc.DTOBusquedaPlantilla;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.entidades.inc.AccesoPlantillaLocal;
import es.indra.sicc.entidades.inc.AccesoPlantillaLocalHome;
import es.indra.sicc.entidades.inc.MarcaPlantillaLocal;
import es.indra.sicc.entidades.inc.MarcaPlantillaLocalHome;
import es.indra.sicc.entidades.inc.PaisPlantillaLocal;
import es.indra.sicc.entidades.inc.PaisPlantillaLocalHome;
import es.indra.sicc.entidades.inc.PlantillaConcursoLocal;
import es.indra.sicc.entidades.inc.PlantillaConcursoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONParametrizacionBean
        implements SessionBean {
    private SessionContext ctx = null;

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

    public DTOSalida consultarTiposCalificacion(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposCalificacion(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.consultarTiposCalificacion(DTOE);
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposCalificacion(DTOBelcorp DTOE):Salida");
        return new DTOSalida(tipos);
    }

    public DTOSalida consultarDirigidoA(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.consultarDirigidoA(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.consultarDirigidoA(DTOE);
        UtilidadesLog.info("MONParametrizacionBean.consultarDirigidoA(DTOBelcorp DTOE):Salida");
        return new DTOSalida(tipos);
    }

    public DTOSalida consultarBasesCalculo(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.consultarBasesCalculo(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.consultarBasesCalculo(DTOE);
        UtilidadesLog.info("MONParametrizacionBean.consultarBasesCalculo(DTOBelcorp DTOE):Salida");

        return new DTOSalida(tipos);
    }

    public DTOSalida consultarTiposVenta(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposVenta(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.consultarTiposVenta(DTOE);
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposVenta(DTOBelcorp DTOE):Salida");

        return new DTOSalida(tipos);
    }

    public DTOSalida consultarTiposConcursoIVR(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposConcursoIVR(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.consultarTiposConcursoIVR(DTOE);
        UtilidadesLog.info("MONParametrizacionBean.consultarTiposConcursoIVR(DTOBelcorp DTOE):Salida");
        return new DTOSalida(tipos);
    }

    public void actualizarPlantilla(DTOPlantilla DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.actualizarPlantilla(DTOPlantilla DTOE):Entrada");
        UtilidadesLog.debug("************* Entre a actualizarPlantilla - MONParametrizacion");

        try {
            PlantillaConcursoLocalHome plan;
            PlantillaConcursoLocal plantilla;
            Iterator it;

            if (DTOE.getOidPlantilla() == null) {
                UtilidadesLog.debug("************* Insercion");
                plan = getPlantillaConcursoLocalHome();

                UtilidadesLog.debug("************* Antes de hacer el create en PlantillaConcurso ");
                plantilla = plan.create(DTOE.getIndFaseCalificacion(), DTOE.getOidCanal(), DTOE.getOidDirigidoA());

                it = DTOE.getAttriTraducible().iterator();

                while (it.hasNext()) {
                    DTOI18nSICC dto = (DTOI18nSICC) it.next();
                    Entidadi18nLocalHome entidadi18nLocalHome = this.getEntidadi18nLocalHome();
                    UtilidadesLog.debug("************* Antes de hacer el create en Entidad i18n");

                    Entidadi18nLocal i18n = entidadi18nLocalHome.create("INC_PLANT_CONCU", new Long(1), dto.getOidIdioma(), dto.getValorI18n(),
                                                                        plantilla.getOid());
                }
            } else {
                UtilidadesLog.debug("************* Modificacion");
                UtilidadesLog.debug("************* oidPlantilla " + DTOE.getOidPlantilla());

                plan = getPlantillaConcursoLocalHome();
                UtilidadesLog.debug("************* Llamando al findByPrimaryKey de la entidad Plantilla Concurso");
                plantilla = plan.findByPrimaryKey(DTOE.getOidPlantilla());

                it = DTOE.getAttriTraducible().iterator();

                Entidadi18nLocalHome entidadi18nLocalHome;
                Entidadi18nLocal entidadi18n;
                DTOI18nSICC dto;

                while (it.hasNext()) {
                    dto = (DTOI18nSICC) it.next();
                    entidadi18nLocalHome = this.getEntidadi18nLocalHome();

                    try {
                        UtilidadesLog.debug("************* Llamando al findByEntAtrIdioPK de la entidad i18n");
                        entidadi18n = entidadi18nLocalHome.findByEntAtrIdioPK("INC_PLANT_CONCU", new Long(1), dto.getOidIdioma(), plantilla.getOid());

                        UtilidadesLog.debug("************* Antes de setear el detalle - entidad i18n");
                        entidadi18n.setDetalle(dto.getValorI18n());
                        entidadi18nLocalHome.merge(entidadi18n);
                    } catch (NoResultException nre) {
                        UtilidadesLog.debug(nre);
                        UtilidadesLog.debug("************* Entre al catch por FinderException");
                        UtilidadesLog.debug("************* Antes de hacer el create en Entidad i18n");

                        Entidadi18nLocal i18n = entidadi18nLocalHome.create("INC_PLANT_CONCU", new Long(1), dto.getOidIdioma(), dto.getValorI18n(),
                                                                            plantilla.getOid());
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }

                UtilidadesLog.debug("************* Antes de setear canal - plantilla concurso");
                plantilla.setCanal(DTOE.getOidCanal());
                UtilidadesLog.debug("************* Antes de setear fase calificacion - plantilla concurso");
                plantilla.setFaseCalificacion(DTOE.getIndFaseCalificacion());

                UtilidadesLog.debug("************* Borrando de pais plantilla");

                PaisPlantillaLocalHome paislh = this.getPaisPlantillaLocalHome();
                Collection paises = paislh.findByPlantilla(DTOE.getOidPlantilla());
                it = paises.iterator();

                while (it.hasNext()) {
                    paislh.remove((PaisPlantillaLocal) it.next());
                }

                UtilidadesLog.debug("************* Borrando de acceso plantilla");

                AccesoPlantillaLocalHome acceslh = this.getAccesoPlantillaLocalHome();
                Collection acceso = acceslh.findByPlantilla(DTOE.getOidPlantilla());
                it = acceso.iterator();

                while (it.hasNext()) {
                    acceslh.remove((AccesoPlantillaLocal) it.next());
                }

                UtilidadesLog.debug("************* Borrando de marca plantilla");

                MarcaPlantillaLocalHome marcalh = this.getMarcaPlantillaLocalHome();
                Collection marcas = marcalh.findByPlantilla(DTOE.getOidPlantilla());
                it = marcas.iterator();

                while (it.hasNext()) {
                    marcalh.remove((MarcaPlantillaLocal) it.next());
                }
            }

            UtilidadesLog.debug("************* Seteando valores del DTOE a la entidad");
            plantilla.setMultinivel(DTOE.getIndMultinivel());
            plantilla.setTipoCalificacion(DTOE.getOidTipoCalificacion());
            plantilla.setIncremental(DTOE.getIndIncremental());
            plantilla.setDirigido(DTOE.getOidDirigidoA());
            plantilla.setBaseCalculo(DTOE.getOidBaseCalculo());
            plantilla.setTipoVenta(DTOE.getOidTipoVenta());
            plantilla.setAmbitoGeograficoCompleto(DTOE.getIndAmbitoGeografico());
            plantilla.setParticipantesCo(DTOE.getIndPartParticipantesCompleto());
            plantilla.setProductosValidos(DTOE.getIndProductosValidos());
            plantilla.setProductosExcluidos(DTOE.getIndProductosExcluidos());
            plantilla.setProductosBonificados(DTOE.getIndProductosBonificados());
            plantilla.setProductosExigidos(DTOE.getIndProductosExigidos());
            plantilla.setAcumularNivel(DTOE.getIndPremiosAcumuPorNiveles());
            plantilla.setNivelesRotativos(DTOE.getIndNivelesRotativos());
            plantilla.setPremiosElectivos(DTOE.getIndPremiosElectivos());
            plantilla.setPuntajeServicio(DTOE.getIndPuntajeServicio());
            plantilla.setActiva(DTOE.getIndActiva());
            plantilla.setTipoConcursoIVR(DTOE.getOidTipoConcursoIVR());
            plantilla.setProgramaNuevas(DTOE.getIndProgramaNuevas());
            plantilla.setBloqueado(DTOE.getIndBloqueado());
            
            // vbongiov -- Cambio 20080811 -- 26/08/2009
             plantilla.setIndSorteo(DTOE.getIndSorteo());

            plan.merge(plantilla);
            
            UtilidadesLog.debug("************* Create en pais plantilla");
            it = DTOE.getOidPaises().iterator();

            PaisPlantillaLocalHome paislh = this.getPaisPlantillaLocalHome();
            PaisPlantillaLocal pais = null;

            while (it.hasNext()) {
                pais = paislh.create((Long) it.next(), plantilla.getOid());
            }

            UtilidadesLog.debug("************* Create en acceso plantilla");
            it = DTOE.getOidAccesos().iterator();

            AccesoPlantillaLocalHome accesolh = this.getAccesoPlantillaLocalHome();
            AccesoPlantillaLocal acceso = null;

            while (it.hasNext()) {
                acceso = accesolh.create(plantilla.getOid(), (Long) it.next());
            }

            UtilidadesLog.debug("************* Create en marca plantilla");
            it = DTOE.getOidMarcas().iterator();

            MarcaPlantillaLocalHome marcalh = this.getMarcaPlantillaLocalHome();
            MarcaPlantillaLocal marca = null;

            while (it.hasNext()) {
                marca = marcalh.create((Long) it.next(), plantilla.getOid());
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONParametrizacionBean.actualizarPlantilla(DTOPlantilla DTOE):Salida");
    }

    public DTOSalida buscarPlantillas(DTOBusquedaPlantilla DTOE)
            throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.buscarPlantillas(DTOBusquedaPlantilla DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        RecordSet tipos = dao.buscarPlantillas(DTOE);
        UtilidadesLog.debug("Consecuencia ValidarTipoVinculoNinguno");
        UtilidadesLog.info("MONParametrizacionBean.buscarPlantillas(DTOBusquedaPlantilla DTOE):Salida");

        return new DTOSalida(tipos);
    }

    public DTOPlantilla obtenerPlantilla(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("MONParametrizacionBean.obtenerPlantilla(DTOOID DTOE):Entrada");

        try {
            PlantillaConcursoLocalHome plantillalh = getPlantillaConcursoLocalHome();
            PlantillaConcursoLocal plantilla = plantillalh.findByPrimaryKey(DTOE.getOid());

            DTOPlantilla dtos = new DTOPlantilla();

            dtos.setOidPlantilla(plantilla.getOid());
            dtos.setOidCanal(plantilla.getCanal());
            dtos.setIndFaseCalificacion(plantilla.getFaseCalificacion());
            dtos.setIndMultinivel(plantilla.getMultinivel());
            dtos.setIndIncremental(plantilla.getIncremental());
            dtos.setIndAmbitoGeografico(plantilla.getAmbitoGeograficoCompleto());
            dtos.setIndPartParticipantesCompleto(plantilla.getParticipantesCo());
            dtos.setIndProductosValidos(plantilla.getProductosValidos());
            dtos.setIndProductosExcluidos(plantilla.getProductosExcluidos());
            dtos.setIndProductosExigidos(plantilla.getProductosExigidos());
            dtos.setIndPremiosAcumuPorNiveles(plantilla.getAcumularNivel());
            dtos.setIndNivelesRotativos(plantilla.getNivelesRotativos());
            dtos.setIndPremiosElectivos(plantilla.getPremiosElectivos());
            dtos.setIndPuntajeServicio(plantilla.getPuntajeServicio());
            dtos.setIndActiva(plantilla.getActiva());
            dtos.setOidTipoConcursoIVR(plantilla.getTipoConcursoIVR());
            dtos.setIndMultinivel(plantilla.getMultinivel());
            dtos.setIndProductosBonificados(plantilla.getProductosBonificados());
            dtos.setOidTipoCalificacion(plantilla.getTipoCalificacion());
            dtos.setOidBaseCalculo(plantilla.getBaseCalculo());
            dtos.setOidTipoVenta(plantilla.getTipoVenta());
            dtos.setIndBloqueado(plantilla.getBloqueado());
            dtos.setOidDirigidoA(plantilla.getDirigido());
            dtos.setIndProgramaNuevas(plantilla.getProgramaNuevas());
            // vbongiov -- Cambio 20080811 -- 26/08/2009
            dtos.setIndSorteo(plantilla.getIndSorteo());

            //Comienzo de cambios:      
            Entidadi18nLocalHome ei18nlh = this.getEntidadi18nLocalHome();
            Long atrib = new Long(ConstantesINC.NUM_ATRIBUTO.longValue());

            try {
                UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con:");
                UtilidadesLog.debug("********* ConstantesINC.ENTIDAD_CANAL " + ConstantesINC.ENTIDAD_CANAL);
                UtilidadesLog.debug("********* atrib " + atrib);
                UtilidadesLog.debug("********* DTOE.getOidIdioma() " + DTOE.getOidIdioma());
                UtilidadesLog.debug("********* plantilla.getCanal() " + plantilla.getCanal());

                Entidadi18nLocal ei18nl = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_CANAL, atrib, DTOE.getOidIdioma(), plantilla.getCanal());

                dtos.setDesCanal(ei18nl.getDetalle());
            } catch (NoResultException nre) {
                UtilidadesLog.debug(nre);
                UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con idioma por defecto");

                Entidadi18nLocal ei18nl2 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_CANAL, atrib, ConstantesSEG.IDIOMA_DEFECTO,
                                                                      plantilla.getCanal());

                dtos.setDesCanal(ei18nl2.getDetalle());
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 

            try {
                UtilidadesLog.debug("********* " + ConstantesINC.ENTIDAD_DIRIGIDO_A);
                UtilidadesLog.debug("********* " + atrib);
                UtilidadesLog.debug("********* " + DTOE.getOidIdioma());
                UtilidadesLog.debug("********* " + plantilla.getDirigido());

                Entidadi18nLocal ei18nl3 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_DIRIGIDO_A, atrib, DTOE.getOidIdioma(),
                                                                      plantilla.getDirigido());

                UtilidadesLog.debug("********* " + ei18nl3.getDetalle());
                dtos.setDesDirigidoA(ei18nl3.getDetalle());
            } catch (NoResultException nre) {
                UtilidadesLog.debug(nre);
                UtilidadesLog.debug("********* " + ConstantesINC.ENTIDAD_DIRIGIDO_A);
                UtilidadesLog.debug("********* " + atrib);
                UtilidadesLog.debug("********* " + ConstantesSEG.IDIOMA_DEFECTO);
                UtilidadesLog.debug("********* " + plantilla.getDirigido());

                Entidadi18nLocal ei18nl4 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_DIRIGIDO_A, atrib, ConstantesSEG.IDIOMA_DEFECTO,
                                                                      plantilla.getDirigido());

                UtilidadesLog.debug("********* " + ei18nl4.getDetalle());
                dtos.setDesDirigidoA(ei18nl4.getDetalle());
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //Fin de cambios  
            Entidadi18nLocalHome entidadi18nLocalHome = null;
            Collection entidadesi18n = null;
            try{
                 entidadi18nLocalHome = this.getEntidadi18nLocalHome();
                 entidadesi18n = entidadi18nLocalHome.findByEntAtrPK("INC_PLANT_CONCU", new Long(1), DTOE.getOid());
            
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
            
            Iterator it = entidadesi18n.iterator();
            Vector descrip = new Vector();

            while (it.hasNext()) {
                DTOI18nSICC dto = new DTOI18nSICC();
                Entidadi18nLocal entidad = (Entidadi18nLocal) it.next();
                dto.setOidAtriuto(entidad.getAtributo());
                dto.setOidIdioma(entidad.getIdioma());
                dto.setValorI18n(entidad.getDetalle());
                descrip.add(dto);
            }

            dtos.setAttriTraducible(descrip);

            PaisPlantillaLocalHome paislh = this.getPaisPlantillaLocalHome();
            Collection paises = paislh.findByPlantilla(DTOE.getOid());
            Iterator itp = paises.iterator();
            ArrayList pais = new ArrayList();

            while (itp.hasNext()) {
                pais.add(((PaisPlantillaLocal) itp.next()).getPais());
            }

            dtos.setOidPaises(pais);

            MarcaPlantillaLocalHome marcalh = this.getMarcaPlantillaLocalHome();
            Collection marcas = marcalh.findByPlantilla(DTOE.getOid());
            Iterator itm = marcas.iterator();
            ArrayList marca = new ArrayList();

            while (itm.hasNext()) {
                marca.add(((MarcaPlantillaLocal) itm.next()).getMarca());
            }

            dtos.setOidMarcas(marca);

            AccesoPlantillaLocalHome accesolh = this.getAccesoPlantillaLocalHome();
            Collection accesos = accesolh.findByPlantilla(DTOE.getOid());
            Iterator ita = accesos.iterator();
            ArrayList acceso = new ArrayList();

            while (ita.hasNext()) {
                acceso.add(((AccesoPlantillaLocal) ita.next()).getAcceso());
            }

            dtos.setOidAccesos(acceso);
            UtilidadesLog.info("MONParametrizacionBean.obtenerPlantilla(DTOOID DTOE):Salida");
            return dtos;
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void eliminarPlantilla(DTOOIDs DTOE) throws MareException {
        UtilidadesLog.info("MONParametrizacionBean.eliminarPlantilla(DTOOIDs DTOE):Entrada");

        try {
            for (int i = 0; i < DTOE.getOids().length; i++) {
                // Eliminamos todos los paises asociados a la plantilla 
                PaisPlantillaLocalHome paislh = this.getPaisPlantillaLocalHome();
                Collection paises = paislh.findByPlantilla(DTOE.getOids()[i]);
                Iterator itp = paises.iterator();

                while (itp.hasNext()) {
                    paislh.remove((PaisPlantillaLocal) itp.next());
                }

                // Eliminamos todos las marcas asociados a la plantilla 
                MarcaPlantillaLocalHome marcalh = this.getMarcaPlantillaLocalHome();
                Collection marcas = marcalh.findByPlantilla(DTOE.getOids()[i]);
                Iterator itm = marcas.iterator();

                while (itm.hasNext()) {
                    marcalh.remove((MarcaPlantillaLocal) itm.next());                
                }

                // Eliminamos todos los accesos asociados a la plantilla
                AccesoPlantillaLocalHome accesolh = this.getAccesoPlantillaLocalHome();
                Collection accesos = accesolh.findByPlantilla(DTOE.getOids()[i]);
                Iterator ita = accesos.iterator();

                while (ita.hasNext()) {
                    accesolh.remove((AccesoPlantillaLocal) ita.next());                                
                }

                // Finalmente eliminamos la plantilla 
                PlantillaConcursoLocalHome plantillalh = getPlantillaConcursoLocalHome();
                PlantillaConcursoLocal plantilla = plantillalh.findByPrimaryKey(DTOE.getOids()[i]);
                plantillalh.remove(plantilla);

                UtilidadesLog.debug("********** Borrando en GEN_I18N_SICC_COMUN");

                Entidadi18nLocalHome entidadi18nLocalHome = this.getEntidadi18nLocalHome();
                Collection col = entidadi18nLocalHome.findByEntPK(ConstantesINC.ENTIDAD_PLANTILLA_CONCURSO, DTOE.getOids()[i]);
                Iterator ite = col.iterator();

                while (ite.hasNext()) {
                    Entidadi18nLocal ei18nl = (Entidadi18nLocal) ite.next();
                    try {
                        entidadi18nLocalHome.remove(ei18nl);
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        throw new MareException(pe, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("MONParametrizacionBean.eliminarPlantilla(DTOOIDs DTOE):Salida");
    }
    
    // vbongiov -- INC 014 -- 20/10/2008
    public DTOSalida consultarEstadoConcurso(DTOBelcorp dtoe) throws MareException
    {
        UtilidadesLog.info("MONParametrizacionBean.consultarEstadoConcurso(DTOBelcorp DTOE):Entrada");
        DAOParametrizacion dao = new DAOParametrizacion();
        es.indra.mare.common.mii.services.jdbcservice.RecordSet tipos = dao.consultarEstadoConcurso(dtoe);
        UtilidadesLog.info("MONParametrizacionBean.consultarEstadoConcurso(DTOBelcorp DTOE):Salida");
        return new DTOSalida(tipos);
    }


    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
            return new Entidadi18nLocalHome();
    }
    
    private PlantillaConcursoLocalHome getPlantillaConcursoLocalHome() {
            return new PlantillaConcursoLocalHome();
    }

    private PaisPlantillaLocalHome getPaisPlantillaLocalHome() {
            return new PaisPlantillaLocalHome();
    }

    private AccesoPlantillaLocalHome getAccesoPlantillaLocalHome() {
            return new AccesoPlantillaLocalHome();
    }

    private MarcaPlantillaLocalHome getMarcaPlantillaLocalHome() {
            return new MarcaPlantillaLocalHome();
    }


    
}
