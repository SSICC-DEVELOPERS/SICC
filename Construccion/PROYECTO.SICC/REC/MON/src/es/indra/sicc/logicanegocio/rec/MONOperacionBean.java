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
 
package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.entidades.rec.TiposOperacionLocal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.StringTokenizer;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.math.BigDecimal;

import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.dtos.rec.DTOBusqueda;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;

import es.indra.sicc.entidades.rec.OperacionesLocalHome;
import es.indra.sicc.entidades.rec.OperacionesLocal;
import es.indra.sicc.entidades.rec.TiposOperacionLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONOperacionBean implements SessionBean {

    private SessionContext ctx;
   
    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void ejbRemove(){
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;
    }


    public void insertarOperacion(DTOOperacion dtoE) throws MareException{
        UtilidadesLog.info("MONOperacion.insertarOperacion(DTOOperacion):Entrada");
        this.validaAcceso(dtoE.getOidPais(),null,null,null,null,null,null,null,null,null,null);
        Entidadi18nLocalHome entidadi18nLocalHome= new Entidadi18nLocalHome();
        OperacionesLocalHome opeLH = new OperacionesLocalHome();
        if(dtoE.getOidOperacion() == null){
            OperacionesLocal local = null;  
            
            try{
      
                //Hacemos el Create del entity Operaciones
                local = opeLH.create(
                    dtoE.getCodOperacion(),
                    dtoE.getDescripcionLarga(),
                    dtoE.getAnulacion(),
                    dtoE.getOidPais(),
                    dtoE.getOidPrecios(),
                    dtoE.getRecojo()
                );       
          
                //metemos los datos que no son obligatorios de la tabla
                 
                local.setPerdida(dtoE.getPerdida());
                local.setTipoSolicitudPerdida(dtoE.getOidTIpoSolicitudPerdida());
                local.setEsperarMercaderiaFisica(dtoE.getEsperarMercaderiaFisica());
                local.setDevueltoFisicoEnFactura(dtoE.getDevueltoFisicoFactura());
                local.setNumeroCampanias(dtoE.getNumeroCampaniasHistoria());
                local.setPrecioEnvia(dtoE.getOidPrecioEnvia());
                local.setBloqueoChequeo(dtoE.getOidBloqueoChequeo());
                local.setFaltanteMercaderia(dtoE.getFaltanteMercaderia());
                local.setIngresaEnvia(dtoE.getIngresaEnvia());
                local.setTipoSolicitud1(dtoE.getOidTipoSolicitud1());
                local.setTipoSolicitud2(dtoE.getOidTipoSolicitud2()); //Incidencia 12865
                local.setMensajeTs2(dtoE.getOidMensajeGenerar());
                local.setEnviaGeneraDevuelve(dtoE.getEnviaGeneraDevuelve());
                local.setIngresaDevuelve(dtoE.getIngresaDevuelve());
                local.setTipoSolicitudGenera(dtoE.getOidTipoSolicitudGenera());
                local.setAlmacen(dtoE.getOidAlmacen());
                local.setMovimientoAlmacen(dtoE.getOidMovimientoAlmacen());
                local.setDevuelveGeneraEnvia(dtoE.getDevuelveGeneraEnvia());                
                //vbongiov -- GCC-COL-REC-001-- 17/12/2007    
                local.setTipoSolicitudRecojoInicial(dtoE.getOidTipoSolicitudRecojoInicial());
                local.setTipoSolicitudPrimerRecojoNoExitoso(dtoE.getOidTipoSolicitudPrimerRecojoNoExitoso());
                local.setTipoSolicitudSegundoRecojoNoExitoso(dtoE.getOidTipoSolicitudSegundoRecojoNoExitoso());
                local.setAlmacenPostVenta(dtoE.getOidAlmacenPostVenta());
                local.setMovimientoAlmacenRecojoInicial(dtoE.getOidMovimientoAlmacenRecojoInicial());
                local.setMovimientoAlmacenRecojoExitoso(dtoE.getOidMovimientoAlmacenRecojoExitoso());
                local.setMovimientoAlmacenRecojoNoExitoso(dtoE.getOidMovimientoAlmacenRecojoNoExitoso());
                opeLH.merge(local);
                             
                dtoE.setOidOperacion(local.getOid()); //asignamos al dto el oid del registro insertado
          
                  
          
            }catch(PersistenceException c){
                UtilidadesLog.error("MONOperacion.insertarOperacion: CreateException de REC_OPERA", c);
                ctx.setRollbackOnly();
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }else{
        
            try{
                
                OperacionesLocal local = opeLH.findByPrimaryKey(dtoE.getOidOperacion());
          
                //Modificamos los datos del registro devuelto por el findByPrimaryKey
                local.setDescripcionLarga(dtoE.getDescripcionLarga());
                local.setPrecios(dtoE.getOidPrecios());
                local.setAnulacion(dtoE.getAnulacion());
                local.setPerdida(dtoE.getPerdida());
                local.setTipoSolicitudPerdida(dtoE.getOidTIpoSolicitudPerdida());
                local.setEsperarMercaderiaFisica(dtoE.getEsperarMercaderiaFisica());
                local.setDevueltoFisicoEnFactura(dtoE.getDevueltoFisicoFactura());
                local.setNumeroCampanias(dtoE.getNumeroCampaniasHistoria());
                local.setPrecioEnvia(dtoE.getOidPrecioEnvia());
                local.setBloqueoChequeo(dtoE.getOidBloqueoChequeo());
                local.setFaltanteMercaderia(dtoE.getFaltanteMercaderia());
                local.setIngresaEnvia(dtoE.getIngresaEnvia());
                local.setTipoSolicitud1(dtoE.getOidTipoSolicitud1());
                local.setTipoSolicitud2(dtoE.getOidTipoSolicitud2());  // Incidencia 12865
                local.setMensajeTs2(dtoE.getOidMensajeGenerar());
                local.setEnviaGeneraDevuelve(dtoE.getEnviaGeneraDevuelve());
                local.setIngresaDevuelve(dtoE.getIngresaDevuelve());
                local.setTipoSolicitudGenera(dtoE.getOidTipoSolicitudGenera());
                local.setAlmacen(dtoE.getOidAlmacen());
                local.setMovimientoAlmacen(dtoE.getOidMovimientoAlmacen());
                local.setDevuelveGeneraEnvia(dtoE.getDevuelveGeneraEnvia());
                
                //vbongiov -- GCC-COL-REC-001-- 17/12/2007    
                local.setRecojo(dtoE.getRecojo());
                local.setTipoSolicitudRecojoInicial(dtoE.getOidTipoSolicitudRecojoInicial());
                local.setTipoSolicitudPrimerRecojoNoExitoso(dtoE.getOidTipoSolicitudPrimerRecojoNoExitoso());
                local.setTipoSolicitudSegundoRecojoNoExitoso(dtoE.getOidTipoSolicitudSegundoRecojoNoExitoso());
                local.setAlmacenPostVenta(dtoE.getOidAlmacenPostVenta());
                local.setMovimientoAlmacenRecojoInicial(dtoE.getOidMovimientoAlmacenRecojoInicial());
                local.setMovimientoAlmacenRecojoExitoso(dtoE.getOidMovimientoAlmacenRecojoExitoso());
                local.setMovimientoAlmacenRecojoNoExitoso(dtoE.getOidMovimientoAlmacenRecojoNoExitoso());
                opeLH.merge(local);
                Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_OPERA",dtoE.getOidOperacion());
                if(!coleccionI18N.isEmpty()){
                    Iterator iterador=coleccionI18N.iterator();
                    while(iterador.hasNext()){
                        entidadi18nLocalHome.remove((Entidadi18nLocal)iterador.next());
                    }				
                }
            }catch(NoResultException fe){
                    UtilidadesLog.error("MONOperacion.insertarTiposOperacion: FinderException de REC_OPERA", fe);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }catch(PersistenceException re){
                    UtilidadesLog.error("MONOperacion.insertarTiposOperacion: RemoveException de i18n", re);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        try{
            Vector arrayAttrTraduc=dtoE.getAttriTraducible();
            if(arrayAttrTraduc!=null){
                for(int i=0;i<arrayAttrTraduc.size();i++){
                    entidadi18nLocalHome.create(
                        "REC_OPERA",/*String entidad*/
                        new Long(1),/*Long atributo*/
                        ((DTOI18nSICC)arrayAttrTraduc.get(i)).getOidIdioma(),/*Long idioma*/
                        ((DTOI18nSICC)arrayAttrTraduc.get(i)).getValorI18n(),/*String detalle*/
                        dtoE.getOidOperacion()/*Long entidad_pk*/
                    );
                }				
            }
        }catch(PersistenceException c){
            UtilidadesLog.error("MONOperacion.insertarOperacion: CreateException de i18n", c);
            ctx.setRollbackOnly();
            throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        // Capturamos la excepcion para poder ver el error concreto
        try{
            this.insertarTiposOperacion(dtoE);
        }catch(Exception e){
            UtilidadesLog.error("**** EXCEPCION EN TIPOS OPERACION ***",e);
            ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(e.getMessage()));
        }
      
        UtilidadesLog.info("MONOperacion.insertarOperacion(DTOOperacion):Salida");
    }

    public void insertarTiposOperacion(DTOOperacion dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.insertarTiposOperacion(DTOOperacion):Entrada " + dtoE);
        this.validaAcceso(dtoE.getOidPais(),null,null,null,null,null,null,null,null,null,null);
        ArrayList tiposOperacion = dtoE.getArrayListTiposOperacion();
        ArrayList eliminados = dtoE.getArrayListEliminados();
        
        Entidadi18nLocalHome entidadi18nLocalHome=new Entidadi18nLocalHome();        
        
        TiposOperacionLocalHome tiposOperacionHome = new TiposOperacionLocalHome();
        TiposOperacionLocal tiposOperacionLocal  = null;
        Boolean campania = null;
        
        Iterator itTiposOperacion = tiposOperacion.iterator();
        String fila = "";
        while(itTiposOperacion.hasNext()){
            fila = (String)itTiposOperacion.next(); //cada elemento del array es una fila de la lista
            UtilidadesLog.debug("*** FILA = "+fila);            
            StringTokenizer st = new StringTokenizer(fila,"|");
            // obtenemos los campos de cada fila
            if(st.hasMoreTokens()){
                String oid = st.nextToken();
                String tipoOperacion = st.nextToken();
                st.nextToken();
                String campaniaReferencia = st.nextToken();
                if(campaniaReferencia.equals("Si")){
                    campania = Boolean.TRUE;  
                }else{
                     campania = Boolean.FALSE;   
                }
                String cantidadDias = st.nextToken();
                String informacionEbel = st.nextToken();
                String devuelveFactura = st.nextToken();
                String enviaFactura = st.nextToken();
                String oidBloqueoPorDiferenciaPrecio = st.nextToken();
                String oidBloqueoPorReclamoAnterior = st.nextToken();
                String oidBloqueoPorImporte = st.nextToken();
                String oidBloqueoPorUnidades = st.nextToken();
                String oidBloqueoPorValoracion = st.nextToken();
                String checkModificado = st.nextToken();
                String descripciones = st.nextToken();
                          
                if(oid.equals("0")){ //Se trata de un tipo operacion nuevo, q trae oid = 0
                    //Si DTOE.ArrayListTiposOperacion.oidTipoOperacion == null { //Se trata de un tipo operacion nuevo                                                                  
                    UtilidadesLog.debug("*** OID = 0, se inserta un tipo nuevo ***");
                    try{
                       tiposOperacionLocal = tiposOperacionHome.create(tipoOperacion,campania,dtoE.getOidOperacion(),new Long(oidBloqueoPorValoracion));
                    }catch(PersistenceException c){
                        UtilidadesLog.error("MONOperacion.insertarTiposOperacion: CreateException de REC_TIPOS_OPER", c);
                        ctx.setRollbackOnly();
                        throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    } 
                    // setear el resto de campos q no estan en el create
                    // se comprueba los campos que no son obligatorios
                    if(!oidBloqueoPorDiferenciaPrecio.equals("-"))
                        tiposOperacionLocal.setBloqueoPorDiferencia(new Long(oidBloqueoPorDiferenciaPrecio));
                    if(!oidBloqueoPorImporte.equals("-"))
                        tiposOperacionLocal.setBloqueoPorImporte(new Long(oidBloqueoPorImporte));
                    if(!oidBloqueoPorReclamoAnterior.equals("-"))
                        tiposOperacionLocal.setBloqueoReclamoAnterior(new Long(oidBloqueoPorReclamoAnterior));
                    if(!oidBloqueoPorUnidades.equals("-"))
                        tiposOperacionLocal.setBloqueoUnidades(new Long(oidBloqueoPorUnidades));
                    if(!cantidadDias.equals("-")){
                        tiposOperacionLocal.setCantidadDiasHaciaAtras(new Integer(cantidadDias));
                    }else{ //mamontie incidencia DBLG400000916 02/05/06
                      tiposOperacionLocal.setCantidadDiasHaciaAtras(new Integer(0));
                    }
                   
                    tiposOperacionLocal.setDevuelveEstaEnFactura((devuelveFactura.equals("Si")) ? Boolean.TRUE : Boolean.FALSE );
                    tiposOperacionLocal.setInformacionEbelNoticias((informacionEbel.equals("Si")) ? Boolean.TRUE : Boolean.FALSE);
                    tiposOperacionLocal.setEnviaEstaEnFactura((enviaFactura.equals("Si")) ? Boolean.TRUE : Boolean.FALSE);
                    tiposOperacionHome.merge(tiposOperacionLocal);
                    
                    
                }else if(checkModificado.equals("true")){
                    UtilidadesLog.debug("*** OID != 0 y modificado = true, se modifica un tipo  ***");
                    try{
                       tiposOperacionLocal = tiposOperacionHome.findByPrimaryKey(new Long(oid)); 
                    }catch(NoResultException fe){
                        UtilidadesLog.error("MONOperacion.insertarTiposOperacion: FinderException REC_TIPOS_OPER", fe);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                    }catch (PersistenceException createException) {
                       UtilidadesLog.debug(createException);
                       ctx.setRollbackOnly();
                       throw new MareException(createException,
                           UtilidadesError.armarCodigoError(
                               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
                    }
                   
                    tiposOperacionLocal.setTipoOperacion(tipoOperacion);
                    //tiposOperacionLocal.setDescripcionTipoOperacion(descripcion); incidencia 15009
                    tiposOperacionLocal.setCampanaReferenciaUnica(campania);
                    
                     if(!oidBloqueoPorDiferenciaPrecio.equals("-"))
                        tiposOperacionLocal.setBloqueoPorDiferencia(new Long(oidBloqueoPorDiferenciaPrecio));
                    if(!oidBloqueoPorImporte.equals("-"))
                        tiposOperacionLocal.setBloqueoPorImporte(new Long(oidBloqueoPorImporte));
                    if(!oidBloqueoPorReclamoAnterior.equals("-"))
                        tiposOperacionLocal.setBloqueoReclamoAnterior(new Long(oidBloqueoPorReclamoAnterior));
                    if(!oidBloqueoPorUnidades.equals("-"))
                        tiposOperacionLocal.setBloqueoUnidades(new Long(oidBloqueoPorUnidades));
                    if(!cantidadDias.equals("-")){
                        tiposOperacionLocal.setCantidadDiasHaciaAtras(new Integer(cantidadDias));
                    }else{//mamontie incidencia DBLG400000916 02/05/06
                      tiposOperacionLocal.setCantidadDiasHaciaAtras(new Integer(0));                    
                    }
                    //mamontie agregado por inc DBLG400000916  MRDB_OID_MOTI_RECH_DESB
                    tiposOperacionLocal.setBloqueoPorValidacion(new Long(oidBloqueoPorValoracion));
                    
                    tiposOperacionLocal.setDevuelveEstaEnFactura((devuelveFactura.equals("Si")) ? Boolean.TRUE : Boolean.FALSE );
                    tiposOperacionLocal.setInformacionEbelNoticias((informacionEbel.equals("Si")) ? Boolean.TRUE : Boolean.FALSE);
                    tiposOperacionLocal.setEnviaEstaEnFactura((enviaFactura.equals("Si")) ? Boolean.TRUE : Boolean.FALSE);
                    tiposOperacionHome.merge(tiposOperacionLocal);
                    try{
                        Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_TIPOS_OPERA",new Long(oid));
                        if(!coleccionI18N.isEmpty()){
                            Iterator iterador=coleccionI18N.iterator();
                            while(iterador.hasNext()){
                                entidadi18nLocalHome.remove((Entidadi18nLocal)iterador.next());
                            }				
                        }
                    }catch(NoResultException fe){
                        UtilidadesLog.error("MONOperacion.insertarTiposOperacion: FinderException de i18n", fe);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                    }catch(PersistenceException re){
                        UtilidadesLog.error("MONOperacion.insertarTiposOperacion: RemoveException de i18n", re);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                    }
                }
                
                if(oid.equals("0") || checkModificado.equals("true")){
                    UtilidadesLog.debug("*** Se van a insertar las descripciones i18n ****");
                    UtilidadesLog.debug("*** Descripciones = "+descripciones);
                    try{
                        if(!descripciones.equals("")){
                            UtilidadesLog.debug("*** Hay descripciones  ");
                            UtilidadesLog.debug("*** tiposOperacionLocal.getOid() = "+tiposOperacionLocal.getOid());
                            Long oidTO = tiposOperacionLocal.getOid();           
                            StringTokenizer stDesc = new StringTokenizer(descripciones,"@");
                            while(stDesc.hasMoreTokens()){
                                String descripcioni18n = stDesc.nextToken();
                                UtilidadesLog.debug("*** descripcioni18n = "+descripcioni18n);
                                StringTokenizer stAux = new StringTokenizer(descripcioni18n,":");
                                String oidIdioma = stAux.nextToken();
                                String desc = stAux.nextToken();
                                UtilidadesLog.debug("*** OidIdioma = " + oidIdioma);
                                UtilidadesLog.debug("*** Descripcion = "+ desc);
                                if(!desc.equals("-")){
                                    UtilidadesLog.debug("*** dentro del if ");
                                    
                                    entidadi18nLocalHome.create(
                                        "REC_TIPOS_OPERA",/*String entidad*/
                                        new Long(1),/*Long atributo*/
                                        new Long(oidIdioma),/*Long idioma*/
                                        desc,/*String detalle*/
                                        oidTO /*Long entidad_pk*/
                                    );
                                }
                            }
                        }
                     }catch(PersistenceException c){
                        UtilidadesLog.error("MONOperacion.insertarTiposOperacion: CreateException de i18n", c);
                        ctx.setRollbackOnly();
                        throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    } 
                }
                  
            }
           
       
        }
        
        //AÑADIDO POR INCIDENCIA BELC300013297: Se eliminan los registros de
        //los oids que vienen en el array ArrayListEliminados;
        
        if(eliminados.size() != 0){
            UtilidadesLog.debug("**** Se van a eliminar los registros almacenados en ArrayListEliminados ***");
            for(int i=0;i<eliminados.size();i++){
                try{
                    tiposOperacionLocal = tiposOperacionHome.findByPrimaryKey(new Long(eliminados.get(i).toString()));
                
                }catch(NoResultException fe){
                    UtilidadesLog.error("MONOperacion.insertarTiposOperacion: FinderException de REC_TIPOS_OPER", fe);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                }catch (PersistenceException createException) {
                   UtilidadesLog.debug(createException);
                   ctx.setRollbackOnly();
                   throw new MareException(createException,
                       UtilidadesError.armarCodigoError(
                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
                }
                try{ 
                    
                
                    Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_TIPOS_OPERA",tiposOperacionLocal.getOid());					
                    if(!coleccionI18N.isEmpty()){
                        Iterator iterador=coleccionI18N.iterator();
                        while(iterador.hasNext()){
                            entidadi18nLocalHome.remove((Entidadi18nLocal)iterador.next());
                        }				
                    }
                    
                    tiposOperacionHome.remove(tiposOperacionLocal);
                    
                }catch(NoResultException finder){
					UtilidadesLog.debug("No se ha encontrado en Atributo Traducible con oid:"+tiposOperacionLocal.getOid());
			                
                }catch(PersistenceException re){
                    UtilidadesLog.error("MONOperacion.eliminarTiposOperacion: FinderException", re);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }        
            }
        }
        UtilidadesLog.info("MONOperacion.insertarTiposOperacion(DTOOperacion):Salida");
    }

    public DTOSalida obtenerOperaciones(DTOBusqueda dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.obtenerOperaciones(DTOBusqueda):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerOperaciones(DTOE)
        del DAOOperacion
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerOperaciones(dtoE));
        
        // Si la consulta no devuelve ningun dato
        if (salida.getResultado().esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****MONOperacion.obtenerOperaciones: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONOperacion.obtenerOperaciones(DTOBusqueda):Salida");
        return salida;
    }

    public DTOSalida obtenerTiposOperacion(DTOOID dtoE) throws MareException{
        
        UtilidadesLog.info("MONOperacion.obtenerTiposOperacion(DTOOID):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerTiposOperacion(DTOE) del DAOOperacion
        */
        Entidadi18nLocalHome entidadi18nLocalHome=new Entidadi18nLocalHome();
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        RecordSet rs = dao.obtenerTiposOperacion(dtoE);
       
        Vector columna = new Vector();
        for(int i=0;i<rs.getRowCount();i++){
            String descripciones = "";
            try{
                Long oid = new Long(((BigDecimal)rs.getValueAt(i,0)).longValue());
                Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_TIPOS_OPERA",oid);
                if(!coleccionI18N.isEmpty()){
                    Iterator iterador=coleccionI18N.iterator();				
                    while(iterador.hasNext()){
                        Entidadi18nLocal i18N=(Entidadi18nLocal)iterador.next();
                        descripciones += i18N.getIdioma().toString() +":"+i18N.getDetalle()+"@";
                    }				
                }
                columna.add(descripciones);
            }catch(NoResultException fe){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                UtilidadesLog.error("MONOperacion.detalleOperaciones: FinderException de i18n",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));   			
            }catch (PersistenceException createException) {
               UtilidadesLog.debug(createException);
               ctx.setRollbackOnly();
               throw new MareException(createException,
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
            }
            
        }
        rs.addColumn("CHECKMODIFICADO",new Vector()); 
        rs.addColumn("DESCRIPCION",columna);
        UtilidadesLog.debug("*** RecordSet con la nueva columna de descripciones ="+rs);
        salida.setResultado(rs);
        
        
        UtilidadesLog.info("MONOperacion.obtenerTiposOperacion(DTOOID):Salida");
        return salida;
    }

    public DTOSalida obtenerMovimientoAlmacen(DTOBelcorp dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.obtenerMovimientoAlmacen(DTOBelcorp):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerMovimientoAlmacen(DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerMovimientoAlmacen(dtoE));        
        UtilidadesLog.info("MONOperacion.obtenerMovimientoAlmacen(DTOBelcorp):Salida");
        return salida;
    }

    public DTOSalida obtenerMotivosBloqueo(DTOBelcorp dtoE) throws MareException{
        
        UtilidadesLog.info("MONOperacion.obtenerMotivosBloqueo(DTOBelcorp):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerMotivosBloqueo(DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerMotivosBloqueo(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerMotivosBloqueo(DTOBelcorp):Salida");
        return salida;
    }

    public DTOSalida obtenerPrecioEnvia(DTOBelcorp dtoE) throws MareException{
        
        UtilidadesLog.info("MONOperacion.obtenerPrecioEnvia(DTOBelcorp):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerPrecioEnvia(DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerPrecioEnvia(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerPrecioEnvia(DTOBelcorp):Salida");
        return salida;
    }

    public DTOSalida obtenerPrecios(DTOBelcorp dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.obtenerPrecios(DTOBelcorp):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerPrecios(DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerPrecios(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerPrecios(DTOBelcorp):Salida");
        return salida;
    }

    public DTOSalida obtenerTipoSolicitud(DTOBelcorp dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitud(DTOBelcorp):Entrada");    
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerTipoSolicitud2(DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
    
        salida.setResultado(dao.obtenerTipoSolicitud(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitud(DTOBelcorp):Salida");    
        return salida;
    }

    public DTOSalida obtenerAlmacen(DTOBelcorp dtoE) throws MareException {
    
        UtilidadesLog.info("MONOperacion.obtenerAlmacen(DTOBelcorp):Entrada");    
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerAlmacen (DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();

        salida.setResultado(dao.obtenerAlmacen(dtoE));        
        UtilidadesLog.info("MONOperacion.obtenerAlmacen(DTOBelcorp):Salida");
        return salida;
    }

    public DTOSalida obtenerMensajes(DTOBelcorp dtoE) throws MareException {
    
        UtilidadesLog.info("MONOperacion.obtenerMensajes(DTOBelcorp):Entrada");
        /*Se crea un DTOSalida 
        DTOSalida.resultado= llamar al método obtenerMensajes (DTOE) del DAOOperaciones
        */
        DTOSalida salida = new DTOSalida();
        DAOOperacion dao = new DAOOperacion();
        
        salida.setResultado(dao.obtenerMensajes(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerMensajes(DTOBelcorp):Salida");
        return salida;
    }

    public void  eliminarOperaciones(DTOOIDs dtoE) throws MareException {
       
        UtilidadesLog.info("MONOperacion.eliminarOperaciones(DTOOIDs):Entrada");
        /*
         * Para cada oid recibido{ 
         * Llamar al metodo eliminarTiposOperacion() pasandole el oid 
         * Se hace un findByPk sobre la entidad Operaciones pasandole el oid 
         * de la operacion recibida 
         * Para el entity obtenido en el paso anterior se llama al metodo remove. 
         * }
         */
        this.validaAcceso(dtoE.getOidPais(),null,null,null,null,null,null,null,null,null,null);
        OperacionesLocalHome operacionesLocalHome = new OperacionesLocalHome();
        OperacionesLocal operacionesLocal = null;
        Entidadi18nLocalHome entidadi18nLocalHome=new Entidadi18nLocalHome();
        Long dtos[] = dtoE.getOids();
        
        for ( int i=0; i < dtos.length; i++ ){
            Long oid = dtos[i];
            
            try{    
                this.eliminarTiposOperacion(oid);
            }catch(Exception e){
                UtilidadesLog.error("**** EXCEPCION EN TIPOS OPERACION ***",e);
                ctx.setRollbackOnly();
                throw new MareException(e,UtilidadesError.armarCodigoError(e.getMessage()));
            }
            
            try{
                operacionesLocal = operacionesLocalHome.findByPrimaryKey(oid);
            }catch(NoResultException fe){
                UtilidadesLog.error("MONOperacion.eliminarOperaciones: FinderException", fe);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }catch (PersistenceException createException) {
               UtilidadesLog.debug(createException);
               ctx.setRollbackOnly();
               throw new MareException(createException,
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
            }
            
            try{
                Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_OPERA",oid);					
				if(!coleccionI18N.isEmpty()){
                                    Iterator iterador=coleccionI18N.iterator();
                                    while(iterador.hasNext()){
                                        entidadi18nLocalHome.remove((Entidadi18nLocal)iterador.next());
                                    }				
				}
                
                
                operacionesLocalHome.remove(operacionesLocal);
                
            }catch(NoResultException finder){
					UtilidadesLog.debug("No se ha encontrado en Atributo Traducible con oid:"+oid);
			
                
            }catch(PersistenceException re){
                UtilidadesLog.error("MONOperacion.eliminarOperaciones: FinderException", re);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        }
       
       
        UtilidadesLog.info("MONOperacion.eliminarOperaciones(DTOOIDs):Salida");
    
    }

    public DTOOperacion detalleOperaciones(DTOOID dtoE) throws MareException{
    
        UtilidadesLog.info("MONOperacion.detalleOperaciones(DTOOIDs):Entrada");
        /*Se crea un DTOOperacion 
        DTOOperacion.resultado= llamar al método obtenerOperaciones(DTOE) del DAOOperaciones
        */
        Entidadi18nLocalHome entidadi18nLocalHome= new Entidadi18nLocalHome();
        DTOOperacion salida = new DTOOperacion();
        DAOOperacion dao = new DAOOperacion();
        
        salida = dao.detalleOperaciones(dtoE);
       
        try{
            Vector vTraduc = null;
            Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_OPERA",dtoE.getOid());
            if(!coleccionI18N.isEmpty()){
                vTraduc=new Vector();
                DTOI18nSICC dtoI18N=null;
                Iterator iterador=coleccionI18N.iterator();				
                while(iterador.hasNext()){
                    Entidadi18nLocal i18N=(Entidadi18nLocal)iterador.next();
                    dtoI18N=new DTOI18nSICC();
                    dtoI18N.setOidAtriuto(i18N.getEntidad_pk());
                    dtoI18N.setOidIdioma(i18N.getIdioma());
                    dtoI18N.setValorI18n(i18N.getDetalle());
                    vTraduc.add(dtoI18N);
                }				
            }
            salida.setAttriTraducible(vTraduc);
        }catch(NoResultException fe){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			UtilidadesLog.error("MONOperacion.detalleOperaciones: FinderException de i18n",fe);
			throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));   			
		}catch (PersistenceException createException) {
                   UtilidadesLog.debug(createException);
                   ctx.setRollbackOnly();
                   throw new MareException(createException,
                       UtilidadesError.armarCodigoError(
                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
                }   
        
        UtilidadesLog.info("MONOperacion.detalleOperaciones(DTOOIDs):Salida");
        return salida;
    }

    public void eliminarTiposOperacion(Long oidOperacion) throws MareException{
        
        UtilidadesLog.info("MONOperacion.eliminarTiposOperacion(Long):Entrada");
        
        //Se obtiene todas las entidades asociadas al tipo de operacion 
        //Se eliminan los tipos recibidos 
        
        TiposOperacionLocalHome tiposOperacionLocalHome = new TiposOperacionLocalHome();
        TiposOperacionLocal tiposOperacionLocal;
        Entidadi18nLocalHome entidadi18nLocalHome=new Entidadi18nLocalHome();
        Collection colecion = null;
         
        try{
            colecion = tiposOperacionLocalHome.findByOperacion(oidOperacion);
        }catch(NoResultException fe){
            UtilidadesLog.error("MONOperacion.eliminarTiposOperacion: FinderException", fe);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }catch (PersistenceException createException) {
               UtilidadesLog.debug(createException);
               ctx.setRollbackOnly();
               throw new MareException(createException,
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
            }
         
        Iterator iterator = colecion.iterator();
        while (iterator.hasNext()){
            tiposOperacionLocal = (TiposOperacionLocal) iterator.next();
    
            try{
                
                Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("REC_TIPOS_OPERA",tiposOperacionLocal.getOid());					
				if(!coleccionI18N.isEmpty()){
                                    Iterator iterador=coleccionI18N.iterator();
                                    while(iterador.hasNext()){
                                        entidadi18nLocalHome.remove((Entidadi18nLocal)iterador.next());
                                    }				
				}
                
                
                tiposOperacionLocalHome.remove(tiposOperacionLocal);
                
            }catch(NoResultException finder){
					UtilidadesLog.error("No se ha encontrado en Atributo Traducible con oid:"+tiposOperacionLocal.getOid());
			                
            }catch(PersistenceException re){
                UtilidadesLog.error("MONOperacion.eliminarTiposOperacion: FinderException", re);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
            
         }         

        UtilidadesLog.info("MONOperacion.eliminarTiposOperacion(Long):Salida");
    }
    
  
    public DTOSalida obtenerTipoSolicitudGenera(DTOBelcorp DTOE) throws MareException
    {
        //Agregado por incidencia 12915
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudGenera(DTOBelcorp):Entrada");
        DAOOperacion dao = new DAOOperacion();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerTipoSolicitudGenera(DTOE)); 
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudGenera(DTOBelcorp):Salida");
        return dtoS;
    }

  
 
  private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException {
        UtilidadesLog.info("MONOperacion.validaAcceso:Entrada");

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
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
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

        UtilidadesLog.info("MONOperacion.validaAcceso:Salida");
    }


    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
						
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		
        return ejb;
	}

  public DTOSalida obtenerTipoOperacionREP(DTOBelcorp dto) throws MareException {
      
    UtilidadesLog.info("MONOperacion.obtenerTipoOperacionREP(DTOBelcorp):Entrada");
    DAORec dao = new DAORec();
    
    UtilidadesLog.info("MONOperacion.obtenerTipoOperacionREP(DTOBelcorp):Salida");
    return dao.obtenerTipoOperacionREP(dto); 
        
  }

    public DTOSalida obtenerTipoSolicitudNoNegativa(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudNoNegativa(DTOBelcorp):Entrada");

        RecordSet resultado = new DAOOperacion().obtenerTipoSolicitudNoNegativa(dtoE);
        
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudNoNegativa(DTOBelcorp):Salida");
        
        return new DTOSalida(resultado); 
    }
    
    public DTOSalida obtenerTipoSolicitudNegativa(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudNegativa(DTOBelcorp):Entrada");

        RecordSet resultado = new DAOOperacion().obtenerTipoSolicitudNegativa(dtoE);
        
        UtilidadesLog.info("MONOperacion.obtenerTipoSolicitudNegativa(DTOBelcorp):Salida");
        
        return new DTOSalida(resultado); 
    }
    
    public DTOSalida obtenerOperacionesAnulacion(DTOBelcorp dto) throws MareException {
      
    UtilidadesLog.info("MONOperacion.obtenerOperacionesAnulacion(DTOBelcorp):Entrada");
    DAORec dao = new DAORec();
    
    UtilidadesLog.info("MONOperacion.obtenerOperacionesAnulacion(DTOBelcorp):Salida");
    return dao.obtenerOperacionesAnulacion(dto); 
        
  }

   public DTOSalida obtenerOperacionesPremio(DTOBelcorp dto) throws MareException{
       UtilidadesLog.info("MONOperacion.obtenerOperacionesPremio(DTOBelcorp):Entrada");
       DAOOperacion dao = new DAOOperacion();
    
       UtilidadesLog.info("MONOperacion.obtenerOperacionesPremio(DTOBelcorp):Salida");
       return dao.obtenerOperacionesPremio(dto); 
    }

    /*
     * @ssaavedr, 26/06/2006; se const. de acuerdo a inc.: BELC300021659
     */
    public DTOSalida obtenerOperacionesDescLarga(DTOBelcorp dtoE) throws MareException
    {
       UtilidadesLog.info("MONOperacion.obtenerOperacionesDescLarga(DTOBelcorp dtoE): Entrada");
       DAOOperacion dao = new DAOOperacion();
       
       DTOSalida resu = new DTOSalida();
       resu.setResultado(dao.obtenerOperacionesDescLarga(dtoE).getResultado());
       UtilidadesLog.info("MONOperacion.obtenerOperacionesDescLarga(DTOBelcorp dtoE): Salida");
       return resu;
    }
    
    /*
     * @ssaavedr, 26/06/2006; se const. de acuerdo a inc.: BELC300021659
     */
    public DTOSalida recargaTipoOperacion(DTOOID dto) throws MareException
    {
       UtilidadesLog.info("MONOperacion.recargaTipoOperacion(DTOOID dto): Entrada");
       DAOOperacion dao = new DAOOperacion();
       
       DTOSalida resu = new DTOSalida();
       resu.setResultado(dao.recargaTipoOperacion(dto).getResultado());
       UtilidadesLog.info("MONOperacion.recargaTipoOperacion(DTOOID dto): Salida");
       return resu;    
    }

    public DTOSalida obtenerParamIntPais(DTOBelcorp dtoE) throws MareException{
        
        UtilidadesLog.info("MONOperacion.obtenerParamIntPais(DTOBelcorp):Entrada");
        DTOSalida salida = new DTOSalida();
        DAOGestionRecojos dao = new DAOGestionRecojos();
        
        salida.setResultado(dao.obtenerParametriaIntPais(dtoE));
        UtilidadesLog.info("MONOperacion.obtenerParamIntPais(DTOBelcorp):Salida");
        return salida;
    }

}
