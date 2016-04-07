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
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTODatosMensajeMultinivel;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.inc.DespachoPremiosLocal;
import es.indra.sicc.entidades.inc.DespachoPremiosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocal;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * @author Cortaberria
 * Fecha: 28/04/2005
 */
public class GestorMensajesTransformar {
    private UtilidadesLog log = new UtilidadesLog();
    
    /**
      * autor Cortabería Alejandro
      * fecha 28/05/05
      */
    /*public void crearMensajeINC06(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC06(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Entrada");
        DTOBuzonMensajes buzon = new DTOBuzonMensajes();
        buzon.setOidPais(concurso.getOidPais());

        DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();

        buzon.setCodigoMensaje("INC06");
        buzon.setOidCliente(clientePremiacion.getOidCliente());
        buzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
        // vbongiov -- 02/08/2006 -- inc 1022
        buzon.setDatoVariable1(
            (clientePremiacion.getDatosPersonales().getNombre1()!=null?clientePremiacion.getDatosPersonales().getNombre1():"") + " " +
            (clientePremiacion.getDatosPersonales().getNombre2()!=null?clientePremiacion.getDatosPersonales().getNombre2():"") );
        buzon.setDatoVariable2(
            (clientePremiacion.getDatosPersonales().getApellido1()!=null?clientePremiacion.getDatosPersonales().getApellido1():"") + " " +
            (clientePremiacion.getDatosPersonales().getApellido2()!=null?clientePremiacion.getDatosPersonales().getApellido2():""));
                
        buzon.setDatoVariable3(clientePremiacion.getDatosPersonales().getCodCliente());
        buzon.setDatoVariable4(clientePremiacion.getDatosPersonales().getCodZona());
        buzon.setDatoVariable5(clientePremiacion.getDatosPersonales().getCodTerritorio());
        //jrivas 1/3/2006 inc 22678
        BigDecimal monto = new BigDecimal(clientePremiacionConcurso.getPuntajeObtenido().doubleValue()).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
        buzon.setDatoVariable6(monto.toString());
        buzon.setDatoVariable10(clientePremiacionConcurso.getSaldoPuntos().toString());
        buzon.setListaConsultoras(ConstantesMSG.NO);
        buzon.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);

        try {
            MONGestionMensajesHome msgHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes", MONGestionMensajesHome.class);
            MONGestionMensajes msg = msgHome.create();
            buzon = msg.insertaDatosMensajeBatch(buzon);
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.error("ERROR ", rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException mex) {
            UtilidadesLog.error("ERROR ", mex);
            throw mex;
        }

        buzon.setDatoVariable17(concurso.getNumeroConcurso());

        Periodo perdsd = concurso.getPeriodoDesde();

        if (perdsd != null) {
            buzon.setDatoVariable18(concurso.getPeriodoDesde().getCodperiodo());
        }

        Periodo perhst = concurso.getPeriodoHasta();

        if (perhst != null) {
            buzon.setDatoVariable19(concurso.getPeriodoHasta().getCodperiodo());
        }

        buzon.setListaConsultoras(ConstantesMSG.NO);
        buzon.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);

        //MONGestionMensajes implements IMSG
        MONGestionMensajesHome monGestionMensajesHome = null;
        MONGestionMensajes monGestionMensajes = null;
        DTOBuzonMensajes dtoBuzonMensajes2 = null;

        try {
            monGestionMensajesHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes", MONGestionMensajesHome.class);
            monGestionMensajes = monGestionMensajesHome.create();

            dtoBuzonMensajes2 = monGestionMensajes.insertaDatosMensajeBatch(buzon);
        } catch (RemoteException rex) {
            UtilidadesLog.error("ERROR ", rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.error("ERROR ", cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException mex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.error("ERROR ", mex);
            throw mex;
        }
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC06(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Salida");
    }*/

    /**
    * @autor Noziglia C.
    * @throws MareException
    * @param ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso, Premio premio
    * @return void
    * @documentation
    1.- Se crea una instancia mensaje DTOBuzonMensajes y rellenamos los siguientes campos:
    - pais= concurso.pais
    - codigoDeMensaje= DAOClientePremiacionConcurso.recuperarCodigoMensajeObtencion(oidConcurso)
    - moduloOrigen= 13
    - variable1=clientePremiacion.datosPersonales.nombre1 + " " + clientePremiacion.datosPersonales.nombre2
    - variable2=clientePremiacion.datosPersonales.apellido1 + " " + clientePremiacion.datosPersonales.apellido2
    - =clientePremiacion.oidCliente
    - variable3=clientePremiacion.codCliente
    - variable4=clientePremiacion.codZona
    - variable5=clientePremiacion.codTerritorio
    - variable6=clientePremiacionConcurso.puntosObtenidos
    - variable7=premio.descripcionTipoPremio
    - variable8=premio.unidades
    - variable9=premio.costePuntos
    - variable10=clientePremiacion.saldoPuntos
    - variable11=premio.nombre
    - variable13=premio.nivel.nivel
    - variable14=premio.puntosCanjeados
    - variable15=premio.unidadesSolicitadas
    - variable17=concurso.numeroConcurso
    - listaConsultoras=NO
    - codigoPatron="Ulitmas Noticias"

    * @date 28/05/05
    *
    */
    public void crearMensajeINC08Premio(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso,
                                        Premio premio) throws MareException 
    {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC08Premio(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso,"+"Premio premio):Entrada");

        String codMensajeAux = null;
        try {
            DespachoPremiosLocalHome despachPremLH = this.getDespachoPremiosLocalHome();
            Collection despachPrem = despachPremLH.findByConcurso(concurso.getOidConcurso());            
            MensajesLocalHome mensajesLH = this.getMensajesLocalHome();
            Iterator despachPremIt = despachPrem.iterator();            
            codMensajeAux = mensajesLH.findByPrimaryKey(((DespachoPremiosLocal)despachPremIt.next()).getMensajeDespachoAutomatico()).getCodMensaje();        
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DatosPersonales datPerso = clientePremiacion.getDatosPersonales();
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** Datos Personales: " + datPerso);
          UtilidadesLog.debug("*** codMensajeAux: " + codMensajeAux);
        }  
        
        if (codMensajeAux != null) {
        
            long cantArticulos=1;
            
            if(ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premio.getTipoPremio())){
                cantArticulos=((PremioArticuloLote)premio).getArticulos().size();
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** cantArticulos: "+cantArticulos);
            }
            
            /*
             * Buzon de mensajes por articulos 
             */
            for(int i=0; i<cantArticulos; i++){
            
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** Articulo["+i+"]");
                
                DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
                
                dtoBuzonMensajes.setOidPais(concurso.getOidPais());
                dtoBuzonMensajes.setCodigoMensaje(codMensajeAux);
                dtoBuzonMensajes.setOidCliente(clientePremiacion.getOidCliente());
                dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
                
                // Define Variables 1,2,3,4,5
                // --------------------------
                if(datPerso != null){
                    dtoBuzonMensajes.setDatoVariable1((datPerso.getNombre1()!=null?datPerso.getNombre1():"") + " " +(datPerso.getNombre2()!=null?datPerso.getNombre2():""));
                    dtoBuzonMensajes.setDatoVariable2((datPerso.getApellido1()!=null?datPerso.getApellido1():"") + " " +(datPerso.getApellido2()!=null?datPerso.getApellido2():""));                                        
                    dtoBuzonMensajes.setDatoVariable3(datPerso.getCodCliente());
                    dtoBuzonMensajes.setDatoVariable4(datPerso.getCodZona());
                    dtoBuzonMensajes.setDatoVariable5(datPerso.getCodTerritorio());
                }

                Double puntaje = clientePremiacionConcurso.getPuntajeObtenido();
                String monto;
                
                if (puntaje != null && puntaje.longValue()>0){
                    monto=(new BigDecimal(puntaje.doubleValue()).divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP).toString());
                }else{
                    monto="0";
                }
                
                // Define Variables 6,7
                // --------------------
                dtoBuzonMensajes.setDatoVariable6(monto);
                dtoBuzonMensajes.setDatoVariable7(premio.getDescripcionTipoPremio());

                // Define Variables 8,15
                // ---------------------
                if(premio.getUnidades()!=null){
                    if(ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premio.getTipoPremio())){
                        dtoBuzonMensajes.setDatoVariable8(((ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i)).getNumeroUnidades().toString());
                    }else{ 
                        dtoBuzonMensajes.setDatoVariable8(premio.getUnidades().toString());
                    }
                    dtoBuzonMensajes.setDatoVariable15(premio.getUnidades().toString());
                }

                // Define Variables 9
                // ------------------            
                if(premio.getNivel().getCantidadFijaPuntos() != null && premio.getNivel().getCantidadFijaPuntos().compareTo(new Double(0)) != 0 ){
                    dtoBuzonMensajes.setDatoVariable9(double2String(premio.getNivel().getCantidadFijaPuntos()));
                }else{
                    dtoBuzonMensajes.setDatoVariable9(double2String(premio.getNivel().getCantidadInicialPuntos()));
                }
                
                // Define Variables 13
                // -------------------
                NivelPremiacion nvlPremia = premio.getNivel();               
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** NivelPremio: "+nvlPremia);                
                if(nvlPremia!=null){
                    dtoBuzonMensajes.setDatoVariable13(integer2String(nvlPremia.getNivel()));
                }
                
                // Define Variables 14
                // -------------------
                /* OJO_JVM
                String puntoscanjeados;
                
                Iterator it = clientePremiacionConcurso.getPremiosGanados().iterator();
                String preGando = new String();
                
                while(it.hasNext()){
                    preGando+=it.next();
                } 
                
                puntoscanjeados = double2String(new Double(clientePremiacionConcurso.getPuntajeObtenido().doubleValue()-(new Double(preGando).doubleValue())));
                
                dtoBuzonMensajes.setDatoVariable14(puntoscanjeados);                
                */
                
                if(clientePremiacionConcurso.getPuntosCanjeados() != null){
                    dtoBuzonMensajes.setDatoVariable14(double2String(clientePremiacionConcurso.getPuntosCanjeados()));
                }else{
                    dtoBuzonMensajes.setDatoVariable14("0");
                }
                                
                // Define Variables 15
                // -------------------                
                dtoBuzonMensajes.setDatoVariable15(bd2String(premio.getUnidades()));
                dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO);
                dtoBuzonMensajes.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);
                
                // Define Variables 11,18,19,20
                // ----------------------------                
                if(ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premio.getTipoPremio())){
                  dtoBuzonMensajes.setDatoVariable11( ((ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i) ).getNombre() );
                  dtoBuzonMensajes.setDatoVariable18( ((ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i) ).getCodSapProducto() );
                  dtoBuzonMensajes.setDatoVariable19( ((ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i) ).getCodigoVentaFicticio() );
                  dtoBuzonMensajes.setDatoVariable20( ((PremioArticuloLote)premio).getDescripcionLote());
                }else{
                    dtoBuzonMensajes.setDatoVariable11(premio.getNombre());
                }
                
                // Define Variables 17
                // -------------------                
                dtoBuzonMensajes.setDatoVariable17(concurso.getNumeroConcurso());
                
                //jrivas SiCC 20070242  28/5/07
                dtoBuzonMensajes.setDatoVariable16(concurso.getNombreConcurso() );
                
                try {
                    MONGestionMensajesLocalHome msgHome = getMONGestionMensajesLocalHome();
                    MONGestionMensajesLocal msg = msgHome.create();
                    dtoBuzonMensajes = msg.insertaDatosMensajeBatch(dtoBuzonMensajes);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (NamingException rex) {
                    UtilidadesLog.error("ERROR ", rex);
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (MareException mex) {
                    UtilidadesLog.error("ERROR ", mex);
                    throw mex;
                }
            }
        }

        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC08Premio(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso,"+"Premio premio):Salida");
    }

    /**
     *
     * @author Noziglia C.
     * Fecha: 20/05/2005
     */
    public void crearMensajeRecomendacionEfectiva(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,
                                                  ClientePremiacionRecomendado recomendado, Concurso concurso)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeRecomendacionEfectiva(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
                                                  "ClientePremiacionRecomendado recomendado, Concurso concurso):Entrada");
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("clientePremiacion " + clientePremiacion);
          UtilidadesLog.debug("clientePremiacionConcurso " + clientePremiacionConcurso);
          UtilidadesLog.debug("recomendado " + recomendado);
          UtilidadesLog.debug("concurso " + concurso);
         }  

        DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
        String codMensajeAux = daoClientePremiacionConcurso.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());

        //Inc 19944    
        if (codMensajeAux != null) {
            DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
            dtoBuzonMensajes.setOidPais(concurso.getOidPais());

            dtoBuzonMensajes.setCodigoMensaje(codMensajeAux);

            dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
            // vbongiov -- 20/07/2006 -- inc DBLG500001048
            dtoBuzonMensajes.setDatoVariable11(concurso.getNumeroConcurso());

            DatosPersonales datpers = clientePremiacion.getDatosPersonales();

            dtoBuzonMensajes.setOidCliente(clientePremiacion.getOidCliente()); 

            if (datpers != null) {
                UtilidadesLog.debug("DATPERS: " + datpers);
                dtoBuzonMensajes.setDatoVariable1((datpers.getNombre1()!=null?datpers.getNombre1():"") + " " + 
                                                  (datpers.getNombre2()!=null?datpers.getNombre2():"") + " " + 
                                                  (datpers.getApellido1()!=null?datpers.getApellido1():"") + " " +
                                                  (datpers.getApellido2()!=null?datpers.getApellido2():""));
            }

            // vbongiov -- 20/07/2006 -- inc DBLG500001048
            Periodo perDesde = concurso.getPeriodoDesde();
            
            if (perDesde != null) {
                dtoBuzonMensajes.setDatoVariable2(perDesde.getCodperiodo());
            }

            Periodo perHasta = concurso.getPeriodoHasta();

            if (perHasta != null) {
                dtoBuzonMensajes.setDatoVariable3(perHasta.getCodperiodo());
            }
            
            UtilidadesLog.debug("recomendado.getDatosPersonales().getApellido1(): " + recomendado.getDatosPersonales().getApellido1());
            UtilidadesLog.debug("recomendado.getDatosPersonales().getApellido2(): " + recomendado.getDatosPersonales().getApellido2());
            
            if(recomendado.getDatosPersonales()!=null) {
                dtoBuzonMensajes.setDatoVariable4((recomendado.getDatosPersonales().getNombre1()!=null?recomendado.getDatosPersonales().getNombre1():"") + " " +
                                                  (recomendado.getDatosPersonales().getNombre2()!=null?recomendado.getDatosPersonales().getNombre2():"") + " " +
                                                  (recomendado.getDatosPersonales().getApellido1()!=null?recomendado.getDatosPersonales().getApellido1():"") + " " +
                                                  (recomendado.getDatosPersonales().getApellido2()!=null?recomendado.getDatosPersonales().getApellido2():""));
            }

            if (recomendado.getPeriodoInicioVinculo() != null) {    
                dtoBuzonMensajes.setDatoVariable7(recomendado.getPeriodoInicioVinculo().getCodperiodo());
            }
            
            String sumaMontoPedidos = null;

            try {
                sumaMontoPedidos = daoClientePremiacionConcurso.recuperarSumaMontoPedidos(clientePremiacion.getOidCliente(),
                                                                                          recomendado.getOidClienteRecomendado(), concurso);
                dtoBuzonMensajes.setDatoVariable8(sumaMontoPedidos);
            } catch (MareException mex) {
                UtilidadesLog.error("ERROR ", mex);
                throw new MareException(mex);
            }

            dtoBuzonMensajes.setDatoVariable10(long2String(clientePremiacionConcurso.getRecomendacionesEfectivas()));
            
            
            dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO);
            dtoBuzonMensajes.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);
            
            //jrivas SiCC 20070242  28/5/07
            dtoBuzonMensajes.setDatoVariable16(concurso.getNombreConcurso() );
      
            try {
                MONGestionMensajesLocalHome msgHome = getMONGestionMensajesLocalHome();
                MONGestionMensajesLocal msg = msgHome.create();
                dtoBuzonMensajes = msg.insertaDatosMensajeBatch(dtoBuzonMensajes);
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (NamingException rex) {
                UtilidadesLog.error("ERROR ", rex);
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (MareException mex) {
                UtilidadesLog.error("ERROR ", mex);
                throw mex;
            }
        }
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeRecomendacionEfectiva(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso,"+
                                                  "ClientePremiacionRecomendado recomendado, Concurso concurso):Salida");
    }

    private String long2String(Long num) {
        return (num == null) ? null : num.toString();
    }

    private String double2String(Double num) {
        return (num == null) ? null : num.toString();
    }

    private String integer2String(Integer num) {
        return (num == null) ? null : num.toString();
    }

    private String bd2String(BigDecimal num) {
        return (num == null) ? null : num.toString();
    }

    /**
    * @Autor: Emilio Noziglia
    * @Fecha : 21/06/2005
    * @Recibe: DTODatosMensajeMultinivel datos, Concurso concurso, Long puntos
    * @Retorna: void
    * @Descripción: crea un mensaje
    * @Referencia: SICC-DMCO-INC-INC9 y BELC300018971
    */
    public void crearMensajeGanadoraMultinivel(DTODatosMensajeMultinivel datos, Concurso concurso, Long puntos)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeGanadoraMultinivel(DTODatosMensajeMultinivel datos, Concurso concurso, Long puntos):Entrada");
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("entra al metodo crearMensajeGanadoraMultinivel con DTODatosMensajeMultinivel:" + datos + " Concurso:" + concurso +
                           " puntos:" + puntos);

        DAOClientePremiacionConcurso daoCliePremConcurso = new DAOClientePremiacionConcurso();
        String codMensajeAux = daoCliePremConcurso.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());

        //Inc 19944    
        if (codMensajeAux != null) {
            MONGestionMensajesHome monGestionMensajesHome = null;
            MONGestionMensajes monGestionMensajes = null;
            DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
            DTOBuzonMensajes dtoBuzonMensajesRes = null;
            DAOSolicitudActualizacion daoSolicitudActualizacion = new DAOSolicitudActualizacion();
            String codMensaje = codMensajeAux;

            dtoBuzonMensajes.setOidPais(concurso.getOidPais());
            dtoBuzonMensajes.setCodigoMensaje(codMensaje);
            dtoBuzonMensajes.setDatoVariable3(datos.getCodCliente()); //BELC300018971
            dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC)); //new Long(13)    
            dtoBuzonMensajes.setDatoVariable14(concurso.getNumeroConcurso());
            
            dtoBuzonMensajes.setDatoVariable1(
                (datos.getNombre1()!=null?datos.getNombre1():"") + " " +
                (datos.getNombre2()!=null?datos.getNombre2():"") + " " +
                (datos.getApellido1()!=null?datos.getApellido1():"") + " " +
                (datos.getApellido2()!=null?datos.getApellido2():""));
            
            //jrivas 1/3/2006 inc 22678
            BigDecimal monto = new BigDecimal(puntos.doubleValue()).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
            dtoBuzonMensajes.setDatoVariable6(monto.toString());
            dtoBuzonMensajes.setDatoVariable7(concurso.getPeriodoDesde().getCodperiodo());
            dtoBuzonMensajes.setDatoVariable8(concurso.getPeriodoHasta().getCodperiodo());
            dtoBuzonMensajes.setDatoVariable10((datos.getSaldoPuntos() != null) ? datos.getSaldoPuntos().toString() : null);
            dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO); //"NO"
            dtoBuzonMensajes.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);

            try {
                monGestionMensajesHome = (MONGestionMensajesHome) UtilidadesEJB.getHome("MONGestionMensajes", MONGestionMensajesHome.class);
                monGestionMensajes = monGestionMensajesHome.create();

                dtoBuzonMensajesRes = monGestionMensajes.insertaDatosMensajeBatch(dtoBuzonMensajes);
            } catch (RemoteException rex) {
                UtilidadesLog.error("ERROR ", rex);
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException cex) {
                UtilidadesLog.error("ERROR ", cex);
                throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeGanadoraMultinivel(DTODatosMensajeMultinivel datos, Concurso concurso, Long puntos):Salida");
    }

    /**
    * Fecha de Creacion: 04/07/2005
    * Autor: Damasia Maneiro
    * Comentario:
    */
    public void crearMensajeNumPuntosRecomendacionesGerente(Concurso concurso, DTODatosMensajeMultinivel datosGerente,
                                                            DTODatosMensajeMultinivel datosRecomendados, long numPuntos)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeNumPuntosRecomendacionesGerente(Concurso concurso, DTODatosMensajeMultinivel datosGerente,"+
                                                            "DTODatosMensajeMultinivel datosRecomendados, long numPuntos):Entrada");
        DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
        DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
        DAOSolicitudActualizacion daoSolicitudActualizacion = new DAOSolicitudActualizacion();

        String codMensajeAux = daoClientePremiacionConcurso.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());

        //Inc 19944    
        if (codMensajeAux != null) {
            dtoBuzonMensajes.setOidPais(concurso.getOidPais());
            dtoBuzonMensajes.setCodigoMensaje(codMensajeAux);
            dtoBuzonMensajes.setDatoVariable1(datosGerente.getNombre1() + " " + datosGerente.getNombre2() + " " + datosGerente.getApellido1() + " " +
                                              datosGerente.getApellido2());
            dtoBuzonMensajes.setDatoVariable2(concurso.getPeriodoDesde().getCodperiodo());
            dtoBuzonMensajes.setDatoVariable3(concurso.getPeriodoHasta().getCodperiodo());
            
            dtoBuzonMensajes.setDatoVariable4(            
                (datosRecomendados.getNombre1() !=null?datosRecomendados.getNombre1() :"") + " " +
                (datosRecomendados.getNombre2() !=null?datosRecomendados.getNombre2() :"") + " " +
                (datosRecomendados.getApellido1()!=null?datosRecomendados.getApellido1():"") + " " +
                (datosRecomendados.getApellido2()!=null?datosRecomendados.getApellido2():""));
                        
            dtoBuzonMensajes.setDatoVariable8(String.valueOf(numPuntos));
            dtoBuzonMensajes.setDatoVariable11(concurso.getNumeroConcurso());
            dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
            dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO);
            dtoBuzonMensajes.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);

            try {
                MONGestionMensajesLocalHome msgHome = getMONGestionMensajesLocalHome();
                MONGestionMensajesLocal msg = msgHome.create();
                dtoBuzonMensajes = msg.insertaDatosMensajeBatch(dtoBuzonMensajes);
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (NamingException rex) {
                UtilidadesLog.error("ERROR ", rex);
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (MareException mex) {
                UtilidadesLog.error("ERROR ", mex);
                throw mex;
            }
        }
         UtilidadesLog.info("GestorMensajesTransformar.crearMensajeNumPuntosRecomendacionesGerente(Concurso concurso, DTODatosMensajeMultinivel datosGerente,"+
                                                            "DTODatosMensajeMultinivel datosRecomendados, long numPuntos):Salida");

    }

    /**
    * Fecha de Creacion: 05/07/2005
    * Autor: Damasia Maneiro
    * Comentario:
    */
    /*public void crearMensajeNumeroRecomendacionesGerentes(Concurso concurso, Long oidGerente, Long numRecomendacionesEfectivas)
            throws MareException {
        
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeNumeroRecomendacionesGerentes(Concurso concurso, Long oidGerente, Long numRecomendacionesEfectivas):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
        DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
        DAOSolicitudActualizacion daoSolicitudActualizacion = new DAOSolicitudActualizacion();

        String codMensajeAux = daoClientePremiacionConcurso.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());

        //Inc 19944    
        if (codMensajeAux != null) {
            dtoBuzonMensajes.setOidPais(concurso.getOidPais());
            dtoBuzonMensajes.setCodigoMensaje(codMensajeAux);

            query.append(" SELECT COD_CLIE");
            query.append(" FROM MAE_CLIEN");
            query.append(" WHERE OID_CLIE = " + oidGerente);

            try {
                rs = (RecordSet) belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            if (!rs.esVacio()) {
                dtoBuzonMensajes.setDatoVariable3((String) rs.getValueAt(0, "COD_CLIE"));
            }

            dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
            dtoBuzonMensajes.setDatoVariable10(numRecomendacionesEfectivas.toString());
            dtoBuzonMensajes.setDatoVariable11(concurso.getNumeroConcurso());
            dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO);
            dtoBuzonMensajes.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);

            try {
                dtoBuzonMensajes = MSGEjbLocators.getMONGestionMensajesHome().create().insertaDatosMensajeBatch(dtoBuzonMensajes);
            } catch (CreateException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (RemoteException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeNumeroRecomendacionesGerentes(Concurso concurso, Long oidGerente, Long numRecomendacionesEfectivas):Salida");
    }*/
    
    public void crearMensajeINC08Despacho(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso, Premio premio, double totalPuntos)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC08Despacho(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Entrada");


        DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
        String codigoMensajeDespacho = daoClientePremiacionConcurso.recuperarCodigoMensajeDespacho(concurso.getOidConcurso() );
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** CodigoMensajeObtencion: "+codigoMensajeDespacho );
                
        DatosPersonales datPerso = clientePremiacion.getDatosPersonales();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** Datos Personales: " + datPerso);

        ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
        ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = this.getClienteDatosBasicosLocalHome();

        if (datPerso == null || (datPerso !=null && datPerso.getCodCliente()==null)) {
            try {                    
                if (datPerso == null) {
                    datPerso = new DatosPersonales();
                } 
                
                clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByPrimaryKey(clientePremiacion.getOidCliente());
               
                datPerso.setNombre1(clienteDatosBasicosLocal.getVal_nom1());
                datPerso.setNombre2(clienteDatosBasicosLocal.getVal_nom2());
                datPerso.setApellido1(clienteDatosBasicosLocal.getVal_ape1());
                datPerso.setApellido2(clienteDatosBasicosLocal.getVal_ape2());
                datPerso.setCodCliente(clienteDatosBasicosLocal.getCod_clie());
                
            } catch (NoResultException nre) {
                UtilidadesLog.debug(nre);
                //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
             } catch (PersistenceException pe) {
                 UtilidadesLog.error("ERROR ", pe);
                 throw new MareException(pe,
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }                
        }
                
        // DBLG500001023 - gPineda - 25/10/2006
        //if (buzon.getCodigoMensaje() != null) {
        if (codigoMensajeDespacho != null) {
            long cantArticulos = 1;
            if( ConstantesINC.TIPO_PREMIO_ARTICULO.equals( premio.getTipoPremio() ) ) {
                cantArticulos = ((PremioArticuloLote) premio).getArticulos().size();
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** cantArticulos: " + cantArticulos);
            }
            for( int i = 0; i < cantArticulos; i++ ){
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** Articulo["+ i +"] ");
            
                DTOBuzonMensajes buzon = new DTOBuzonMensajes();
                buzon.setOidPais(concurso.getOidPais());
                buzon.setCodigoMensaje( codigoMensajeDespacho );                
                
                buzon.setOidCliente(clientePremiacion.getOidCliente());
                buzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
    
                if (datPerso != null) {
                    buzon.setDatoVariable1(
                        (datPerso.getNombre1()!=null?datPerso.getNombre1():"") + " " +
                        (datPerso.getNombre2()!=null?datPerso.getNombre2():""));
                
                    buzon.setDatoVariable2(
                        (datPerso.getApellido1()!=null?datPerso.getApellido1():"") + " " +
                        (datPerso.getApellido2()!=null?datPerso.getApellido2():""));
                   
                    buzon.setDatoVariable3(datPerso.getCodCliente());
                    buzon.setDatoVariable4(datPerso.getCodZona());
                    buzon.setDatoVariable5(datPerso.getCodTerritorio());
                }
    
                //jrivas 1/3/2006 inc 22678
                Double puntaje = clientePremiacionConcurso.getPuntajeObtenido();
                String monto; 
                if (puntaje != null && puntaje.longValue() > 0) {
                    monto = (new BigDecimal(puntaje.doubleValue()).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP)).toString();
                } else {
                    monto = "0";
                }
                buzon.setDatoVariable6(monto);
                
                // vbongiov -- 29/06/06 -- DBLG500000723  
                buzon.setDatoVariable7(premio.getDescripcionTipoPremio());
                ArticuloLote articulo = (ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i);
                if (premio.getUnidades() != null) {
                    
                    //DBLG500001023 - gPineda - 25/10/2006
                    //buzon.setDatoVariable8(premio.getUnidades().toString());
                    if( ConstantesINC.TIPO_PREMIO_ARTICULO.equals( premio.getTipoPremio() ) ) {
                      buzon.setDatoVariable8( articulo.getNumeroUnidades().toString());
                    }else{
                      buzon.setDatoVariable8(premio.getUnidades().toString());
                    }
                    
                    buzon.setDatoVariable15(premio.getUnidades().toString());
                }
                if (premio.getNivel().getCantidadFijaPuntos() != null 
                   && premio.getNivel().getCantidadFijaPuntos().intValue()!=0) {
                    buzon.setDatoVariable9(premio.getNivel().getCantidadFijaPuntos().toString());
                } else {
                    buzon.setDatoVariable9(premio.getNivel().getCantidadInicialPuntos().toString());
                }
                
                //DBLG500001023 - gPineda - 25/10/2006
                if( ConstantesINC.TIPO_PREMIO_ARTICULO.equals( premio.getTipoPremio() ) ) {
                    buzon.setDatoVariable11( articulo.getNombre() );
                    buzon.setDatoVariable18( articulo.getCodSapProducto() );
                    buzon.setDatoVariable19( articulo.getCodigoVentaFicticio() );
                    //Brecha INC-003 6-9-07 jrivas
                    if (!ConstantesINC.TIPO_ENTREGA_CENTRO_SERVICIO.equals(articulo.getTipoEntregaPremio())) {
                        buzon.setDatoVariable20( ((PremioArticuloLote)premio).getDescripcionLote() );
                    } else {
                        buzon.setDatoVariable20( ((PremioArticuloLote)premio).getDescripcionLote() + " " + 
                                        articulo.getCodigoCentroServicio() + " " + 
                                        articulo.getDescripcionCentroServicio());
                    }
                }else{
                      buzon.setDatoVariable11( premio.getNombre() );
                }
                    
                buzon.setDatoVariable12(premio.getDescripcionTipoPremio());
                if (premio.getNivel() != null) {
                    buzon.setDatoVariable13(premio.getNivel().getNivel().toString());
                }
                
                // Puntos canjeados                      
                buzon.setDatoVariable14(new Double(totalPuntos).toString());            
                
                buzon.setDatoVariable17(concurso.getNumeroConcurso());
                buzon.setDatoVariable10((new Double(clientePremiacionConcurso.getSaldoPuntos().doubleValue() - totalPuntos)).toString()); //saldoPuntos
                buzon.setListaConsultoras(ConstantesMSG.NO);
                buzon.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);
                
                //jrivas SiCC 20070242  28/5/07
                buzon.setDatoVariable16(concurso.getNombreConcurso() );
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("DTOBuzonMensajes: " + buzon);
    
                try {
                    MONGestionMensajesLocalHome msgHome = getMONGestionMensajesLocalHome();
                    MONGestionMensajesLocal msg = msgHome.create();
                    buzon = msg.insertaDatosMensajeBatch(buzon);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (NamingException rex) {
                    UtilidadesLog.error("ERROR ", rex);
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (MareException mex) {
                    UtilidadesLog.error("ERROR ", mex);
                    throw mex;
                }
            }
        }
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC08Despacho(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Salida");
    } 
    
    //Brecha INC-003 6-9-07 jrivas
    public void crearMensajeINC98(Long oidCliente, Concurso concurso, Premio premio)
            throws MareException {
        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC98(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Entrada");

        long cantArticulos = 1;
        cantArticulos = ((PremioArticuloLote) premio).getArticulos().size();
        
        for( int i = 0; i < cantArticulos; i++ ){
            ArticuloLote articulo = (ArticuloLote)((PremioArticuloLote)premio).getArticulos().get(i);
            if (ConstantesINC.TIPO_ENTREGA_CENTRO_SERVICIO.equals(articulo.getTipoEntregaPremio())) {
                DTOBuzonMensajes buzon = new DTOBuzonMensajes();
    
                buzon.setOidPais(concurso.getOidPais());
                buzon.setCodigoMensaje("INC98");                
                buzon.setOidCliente(oidCliente);
                buzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_INC));
                
                //jrivas 20080540 15/1/2008
                buzon.setDatoVariable1( articulo.getNombre() );
                //buzon.setDatoVariable1( articulo.getCodSapProducto() );
                
                buzon.setDatoVariable2( articulo.getCodigoVentaFicticio() );
                buzon.setDatoVariable3( concurso.getNumeroConcurso() );
                buzon.setDatoVariable4( concurso.getNombreConcurso() );
                buzon.setDatoVariable5( articulo.getCodigoCentroServicio() );
                buzon.setDatoVariable6( articulo.getDescripcionCentroServicio() );
                buzon.setListaConsultoras(ConstantesMSG.NO);
                buzon.setCodigoPatron(ConstantesINC.ULTIMAS_NOTICIAS);
                
                try {
                    MONGestionMensajesLocalHome msgHome = getMONGestionMensajesLocalHome();
                    MONGestionMensajesLocal msg = msgHome.create();
                    buzon = msg.insertaDatosMensajeBatch(buzon);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (NamingException rex) {
                    UtilidadesLog.error("ERROR ", rex);
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (MareException mex) {
                    UtilidadesLog.error("ERROR ", mex);
                    throw mex;
                }
            }
        }

        UtilidadesLog.info("GestorMensajesTransformar.crearMensajeINC98(ClientePremiacion clientePremiacion, ClientePremiacionConcurso clientePremiacionConcurso, Concurso concurso):Salida");
    }   
    
    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }
      
    private DespachoPremiosLocalHome getDespachoPremiosLocalHome() {
            return new DespachoPremiosLocalHome();
    }
    
    private MensajesLocalHome getMensajesLocalHome() {
            return new MensajesLocalHome();
    }
    

      
    
}
