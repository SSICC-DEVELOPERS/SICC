package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.ped.DTOFlete;
import es.indra.sicc.dtos.ped.DTORangoFlete;
import es.indra.sicc.entidades.ped.FleteLocal;
import es.indra.sicc.entidades.ped.FleteLocalHome;
import es.indra.sicc.entidades.ped.RangoFleteLocal;
import es.indra.sicc.entidades.ped.RangoFleteLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;

import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONFleteBean implements SessionBean  {

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

    public void elimina(DTOOIDs dto) throws MareException {
            UtilidadesLog.info("MONFleteBean.elimina(DTOOIDs dto): Entrada ");
            //Se eliminan los fletes que cumplan las condiciones de aquel flete identificado por cada elemento de dto.oids. 
            Long[] oids = dto.getOids();
            UtilidadesLog.debug("oids >>>> " + oids);
            DTOOID oid;
            for (int i = 0 ;i < oids.length ; i++)  {
                    oid = new DTOOID();
                    UtilidadesLog.debug("oids>>>>>>>>>> ---- "+ oids );
                    UtilidadesLog.debug("dentro del for >>>> " + i);
                    oid.setOid(oids[i]);
                    this.eliminaFlete(oid);
            }
            UtilidadesLog.info("MONFleteBean.elimina(DTOOIDs dto): Salida ");
    }

    public void guarda(DTOFlete dto) throws MareException {
            UtilidadesLog.info("MONFleteBean.guarda(DTOFlete dto): Entrada ");
            FleteLocalHome fletelh = null;
            FleteLocal flete = null;
            UtilidadesLog.debug("contenido DTOFlete>>>>>" + dto);
            DTOOID d = new DTOOID();
            d.setOid(dto.getOid());
            UtilidadesLog.debug("dentro del guardar dtooid >>>>>>" + d);
            if(dto.getOid() != null)
            {
                eliminaFlete(d);
            }
            UtilidadesLog.debug("despues de eliminaFlete >>>>>>");
            Long oidUbigeo = null;
            if(!dto.getUbigeo().equals(""))
            {
                try
                {
                    MONUnidadesGeograficasHome unidHome = ZONEjbLocators.getMONUnidadesGeograficasHome();
                    UtilidadesLog.debug(" dto.getOidPais()>>>> " + dto.getOidPais());
                    UtilidadesLog.debug(" --------------------------------");
                    UtilidadesLog.debug(" -dto.getUbigeo()dto.getUbigeo()--" + dto.getUbigeo());
                    oidUbigeo = unidHome.create().obtenerOidUBIGEO(dto.getOidPais(), dto.getUbigeo());
                } catch(CreateException createException) {
                    ctx.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                } catch(Exception exception) {
                    ctx.setRollbackOnly();
                    throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                if(oidUbigeo == null){
                   // throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_033));
                                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_033));
                }
                UtilidadesLog.debug(" despues de verificar por el oidUbigeo");
            }
            if(oidUbigeo != null)
            {
                dto.setOidUbigeo(oidUbigeo);
            }
            UtilidadesLog.debug(" ----------oidUbigeo-----------------" + oidUbigeo);
            try
            {
                fletelh = new FleteLocalHome();
                flete = fletelh.create(dto.getOidCanal(), dto.getOidTipoDespacho(), dto.getOidMarca(), dto.getOidTipoCliente());
                flete.setUbigeo(dto.getOidUbigeo());
                flete.setMontoFijo(dto.getMontoFijo());
                flete.setTasa(dto.getTasa());
                flete.setZona(dto.getZona());
                flete.setFleteMin(dto.getFleteMin());
                flete.setFleteMax(dto.getFleteMax());
                flete.setContraEntrega(dto.getContraEntrega());
                flete.setSubtipoCliente(dto.getOidSubtipoCliente());
                flete.setTipoClasificacion(dto.getOidTipoClasificacion());
                flete.setClasificacion(dto.getOidClasificacion());
                
                fletelh.merge(flete);
                
                //Inserto los rangos flete.
                UtilidadesLog.debug("dtoRangos" + dto.getRangosFlete());                

                if ((dto.getRangosFlete()!=null)&&(!dto.getRangosFlete().isEmpty())) {
                    try {
                        RangoFleteLocalHome rfLH = new RangoFleteLocalHome();
                        Iterator itRF = dto.getRangosFlete().iterator();
                        Long oidFlete = flete.getOid();
                        
                        while (itRF.hasNext()) {
                            DTORangoFlete dtoRF = (DTORangoFlete)itRF.next();
                            RangoFleteLocal rfL = rfLH.create(oidFlete, dtoRF.getRangoInf(), dtoRF.getRangoSup(), dtoRF.getMontoFij());
                            rfLH.merge(rfL);
                        }                   
                        UtilidadesLog.debug("despues del while de rangos");
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("Error al insertar en rangos: ", pe);
                        throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }  
                }
                
                //Internacionalizacion               
                UtilidadesLog.debug("dto" + flete);
                Vector descrs = dto.getAttriTraducible();
                UtilidadesLog.debug("descrs>>>>>> " + descrs);
                Long oidIdioma;
                String descripcion;
                
                try {
                    Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
                    for(Iterator it2 = descrs.iterator(); it2.hasNext(); e18nLH.create("PED_FLETE", new Long(1L), oidIdioma, descripcion, flete.getOid()))
                    {
                        DTOI18nSICC desc = (DTOI18nSICC)it2.next();
                        oidIdioma = desc.getOidIdioma();
                        UtilidadesLog.debug("desc>>>>>> " + desc);
                        descripcion = desc.getValorI18n();
                    }
                    UtilidadesLog.debug("despues del while");
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error al insertar en i18n: ", pe);
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
            } catch(PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Error al insertar Flete: ", pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.info("MONFleteBean.guarda(DTOFlete dto): Salida ");
    }

    public DTOSalida consulta(DTOFlete dto) throws MareException {
            //Consulta los fletes con los criterios dados en el dto. 
            UtilidadesLog.info("MONFleteBean.consulta(DTOFlete dto): Entrada ");
            Long oidUbigeo= null;
            try {
                    MONUnidadesGeograficasHome unidHome = ZONEjbLocators.getMONUnidadesGeograficasHome();
                    if(dto.getUbigeo()!= null){
                        oidUbigeo = unidHome.create().obtenerOidUBIGEO(dto.getOidPais(), dto.getUbigeo());
                    }
            } catch (CreateException createException) {
                    throw new MareException(createException,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            } catch (Exception exception) {
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            dto.setOidUbigeo(oidUbigeo);

            String usuario = ctx.getCallerPrincipal().getName();
            DAOPED dao = new DAOPED(usuario);
            DTOSalida salida = dao.obtieneFlete(dto);
            
            UtilidadesLog.info("MONFleteBean.consulta(DTOFlete dto): Salida ");
            return salida;
    }

    public DTOFlete consultaDetalles(DTOOID dto) throws MareException {
    
            UtilidadesLog.info("MONFleteBean.consultaDetalles(DTOOID dto): Entrada ");
            //Consulta los detalles del flete identificado por dto.oid. 
            DTOFlete dtos = this.obtieneFlete(dto); 
            FleteLocalHome fletelh = null;
            Collection fletes = null;

            try {
                    fletelh = new FleteLocalHome();	
                    Entidadi18nLocalHome i18nLH = new Entidadi18nLocalHome();
                    fletes = i18nLH.findByEntAtrPK("PED_FLETE", new Long(1), dto.getOid()); 
                    Iterator it = fletes.iterator();
                    Vector traducciones = new Vector();
                    while (it.hasNext()) {
                            Entidadi18nLocal inte = (Entidadi18nLocal)it.next();
                            DTOI18nSICC inter = new DTOI18nSICC();
                            inter.setOidAtriuto(inte.getAtributo());
                            inter.setOidIdioma(inte.getIdioma());
                            inter.setValorI18n(inte.getDetalle());
                            traducciones.add(inter);
                    }
                    dtos.setAttriTraducible(traducciones);
                    
            } catch (NoResultException exception) {
                    ctx.setRollbackOnly();
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException exception) {
                    ctx.setRollbackOnly();
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            UtilidadesLog.info("MONFleteBean.consultaDetalles(DTOOID dto): Salida ");
            return dtos;
            
    }

    private DTOFlete obtieneFlete(DTOOID dto) throws MareException {
            UtilidadesLog.info("MONFleteBean.obtieneFlete(DTOOID dto): Entrada ");
            //Obtiene el flete con el detalle (subtipo cliente, tipo clasificación, clasificación). 

            RangoFleteLocalHome rangofletelh = null;		

            FleteLocalHome fletelh = null;
            FleteLocal flete = null;
            String ubigeo = null;

            ValoresEstructuraGeopoliticaLocalHome valoresh = null;
            ValoresEstructuraGeopoliticaLocal valores = null;
            
            String[] ubigeoArrayRef = new String[9];

            //cargo en un array el ubigeo obtenido en la ref al entity
            int a=0;
            
            try {
                    fletelh = new FleteLocalHome();
                    UtilidadesLog.debug("1 **");
                    flete = fletelh.findByPrimaryKey(dto.getOid());
                    UtilidadesLog.debug("flete **" + flete);

                    UtilidadesLog.debug("flete **" + flete.getUbigeo());

                    if (flete.getUbigeo() != null) {	

                            valoresh = new ValoresEstructuraGeopoliticaLocalHome();
                            UtilidadesLog.debug("valoresh **" + valoresh);
                            valores = valoresh.findByPrimaryKey(flete.getUbigeo());
                            UtilidadesLog.debug("22222 ");
                            
                            if(valores.getOrde_1()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_1(); 
                                    a++;
                            }		

                            UtilidadesLog.debug("despues de el primer orden");
                            if(valores.getOrde_2()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_2(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el seg orden");
                            if(valores.getOrde_3()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_3(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el tercer orden");
                            if(valores.getOrde_4()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_4(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el cuarto orden");
                            if(valores.getOrde_5()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_5(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el quinto orden");
                            if(valores.getOrde_6()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_6(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el sexto orden");
                            if(valores.getOrde_7()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_7(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el orden 7");
                            if(valores.getOrde_8()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_8(); 
                                    a++;
                            }
                            UtilidadesLog.debug("despues de el orden 8");
                            if(valores.getOrde_9()!=null){
                                    ubigeoArrayRef[a] = valores.getOrde_9(); 
                                    a++;
                            }		
                            UtilidadesLog.debug("despues de el orden 9");
                            for ( int i = 0; i < ubigeoArrayRef.length; i++) {
                                    if ( ubigeoArrayRef[i] !=null){					
                                            ubigeo = ubigeo + ubigeoArrayRef[i] + ",";						
                                    }
                            }	
                            UtilidadesLog.debug("contenido de ubigeo**" + ubigeo);
                    }
                                    
            } catch (NoResultException exception) {
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException exception) {
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            DTOFlete dtos = new DTOFlete();
            dtos.setUbigeo(ubigeo);
            dtos.setOidUbigeo(flete.getUbigeo());
            dtos.setZona(flete.getZona());
            dtos.setMontoFijo(flete.getMontoFijo());
            dtos.setTasa(flete.getTasa());
            dtos.setFleteMin(flete.getFleteMin());
            dtos.setFleteMax(flete.getFleteMax());
            dtos.setContraEntrega(flete.getContraEntrega());
            dtos.setOid(flete.getOid());
            dtos.setOidMarca(flete.getMarca());
            dtos.setOidCanal(flete.getCanal());
            dtos.setOidTipoCliente(flete.getTipoCliente());
            dtos.setOidTipoDespacho(flete.getTipoDespacho());
            dtos.setOidPais(dto.getOidPais());
            dtos.setOidIdioma(dto.getOidIdioma());

            dtos.setOidSubtipoCliente(flete.getSubtipoCliente());
            dtos.setOidTipoClasificacion(flete.getTipoClasificacion());
            dtos.setOidClasificacion(flete.getClasificacion());

            try {
            
               rangofletelh = new RangoFleteLocalHome();
               Collection colRangos =  rangofletelh.findByOidFlete(flete.getOid());
               
               if (!colRangos.isEmpty()){
                    dtos.setRangosFlete(new ArrayList());
                    Iterator itRangos = colRangos.iterator();
                    while (itRangos.hasNext()) {
                        RangoFleteLocal rangoflete = (RangoFleteLocal)itRangos.next();
                        DTORangoFlete dtoRangoFlete = new DTORangoFlete();
                        
                        dtoRangoFlete.setOidRangoFlete(rangoflete.getOid());
                        dtoRangoFlete.setOidFlete(rangoflete.getOidFlete());
                        dtoRangoFlete.setRangoInf(rangoflete.getRangoInf());
                        dtoRangoFlete.setRangoSup(rangoflete.getRangoSup());
                        dtoRangoFlete.setMontoFij(rangoflete.getMontoFij());                            
                        
                        dtos.getRangosFlete().add(dtoRangoFlete);
                    }
               }
            
            } catch (NoResultException exception) {
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException exception) {
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            UtilidadesLog.info("MONFleteBean.obtieneFlete(DTOOID dto): Salida ");
            return dtos;
    }


    private void eliminaFlete(DTOOID dto) throws MareException {
            UtilidadesLog.info("MONFleteBean.eliminaFlete(DTOOID dto): Entrada ");
            //Se eliminan los fletes que cumplan las condiciones de aquel flete identificado por dto.oid. 
            //DTOFlete dtos = this.obtieneFlete(dto); 
            UtilidadesLog.debug("----- eliminaFlete ----- ");
            FleteLocalHome fletelh = null;
            FleteLocal flete = null;		

            try {
                            fletelh = new FleteLocalHome();
                            UtilidadesLog.debug("----- dto.getOid() ----- " +dto.getOid());
                            flete = fletelh.findByPrimaryKey( dto.getOid() );
                            UtilidadesLog.debug("----- flete ----- " + flete);
                            Long oid = flete.getOid();	
                            
                            //Previo a eliminar los Fletes se eliminan los rangos por dependencia
                             RangoFleteLocalHome rfLH = new RangoFleteLocalHome();

                             UtilidadesLog.debug("eliminado rangos del flete oid ----- " + oid);
                             Collection rFlet = rfLH.findByOidFlete(oid);

                             Iterator itRF = rFlet.iterator();
                             while (itRF.hasNext()) {
                                 RangoFleteLocal rFl = (RangoFleteLocal)itRF.next();
                                 try {
                                     rfLH.remove(rFl);
                                 } catch (PersistenceException exception) {
                                     ctx.setRollbackOnly();
                                     throw new MareException(exception,
                                               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                 }
                             }                                
                            
                            
                            //Se eliminan los fletes
                            try {
                                fletelh.remove(flete);
                            } catch (PersistenceException exception) {
                                ctx.setRollbackOnly();
                                throw new MareException(exception,
                                          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                            }
                            
                            Entidadi18nLocalHome i18nLH = new Entidadi18nLocalHome();

                            UtilidadesLog.debug("----- oid ----- " + oid);
                            Collection desc = i18nLH.findByEntAtrPK("PED_FLETE", new Long(1), oid);

                            Iterator it2 = desc.iterator();
                            while (it2.hasNext()) {
                                Entidadi18nLocal i18 = (Entidadi18nLocal)it2.next();
                                try {
                                    i18nLH.remove(i18);
                                } catch (PersistenceException exception) {
                                    ctx.setRollbackOnly();
                                    throw new MareException(exception,
                                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
                            }	
            
            } catch (NoResultException exception) {
                    ctx.setRollbackOnly();
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException exception) {
                    ctx.setRollbackOnly();
                    throw new MareException(exception,
                              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            UtilidadesLog.info("MONFleteBean.eliminaFlete(DTOOID dto): Salida ");
    }


}
