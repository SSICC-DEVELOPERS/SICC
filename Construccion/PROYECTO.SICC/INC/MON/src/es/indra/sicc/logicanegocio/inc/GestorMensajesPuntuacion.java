/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor Viviana Bongiovanni
 * Inc DBLG500000246 / DBLG500000347
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.CreateException;

public class GestorMensajesPuntuacion {
  private UtilidadesLog log = new UtilidadesLog();
    
  public GestorMensajesPuntuacion() {
  }

  public void crearMensajeMontoUnidadesConsultoras(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos) throws MareException {
      UtilidadesLog.info("GestorMensajesPuntuacion.crearMensajeMontoUnidadesConsultoras(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Entrada");
      
      Iterator i = concursos.iterator();
      boolean found = false;
      Concurso concurso = null;

      while (i.hasNext() && !found) {
          concurso = (Concurso) i.next();

          if (concurso.getOidConcurso().longValue() == solicitudConc.getOidConcurso().longValue()) {
              found = true;
          }
      }

      DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
      dtoBuzon.setOidPais(solicitud.getOidPais());
      
      DAOClientePremiacionConcurso daoCli = new DAOClientePremiacionConcurso();
      String codMensajeAux = daoCli.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
        UtilidadesLog.debug("*** codMensajeAux: " + codMensajeAux);
        
      dtoBuzon.setCodigoMensaje(codMensajeAux);
  
      dtoBuzon.setOidCliente(solicitud.getCliente().getOidCliente());
      dtoBuzon.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);      
      dtoBuzon.setDatoVariable1(solicitud.getCliente().getNombre()!=null?solicitud.getCliente().getNombre():"");
      dtoBuzon.setDatoVariable4(concurso.getPeriodoDesde().getCodperiodo());
      dtoBuzon.setDatoVariable5(concurso.getPeriodoHasta().getCodperiodo());
      
      // Asigna variable 6 y 7
      ClientePremiacion cliPrem = new ClientePremiacion();        
      Periodo periodo = new Periodo();
      periodo.setOidPeriodo(solicitud.getPeriodo().getOidPeriodo());
      
      cliPrem.setOidCliente(solicitud.getCliente().getOidCliente());
      cliPrem.setPeriodo(periodo);
      
      ClientePremiacionConcurso cliPremConc = new ClientePremiacionConcurso();        
      cliPremConc.setOidConcurso(concurso.getOidConcurso());
      
      DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();
      
      daoClientePremiacionConcurso.recuperarSaldoPuntos(cliPrem, cliPremConc, null);

      if(ConstantesINC.OID_BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo())) {
      
          if(cliPremConc.getSaldoPuntos()!= null) {
              dtoBuzon.setDatoVariable6((new BigDecimal(cliPremConc.getSaldoPuntos().doubleValue())).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
          } else {
              dtoBuzon.setDatoVariable6("0");
          }
        
      } else if(ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(concurso.getBaseCalculo())) {
          if(cliPremConc.getSaldoPuntos()!= null) {
              dtoBuzon.setDatoVariable6((new BigDecimal(cliPremConc.getSaldoPuntos().doubleValue())).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
          } else {
              dtoBuzon.setDatoVariable6("0");
          }
      }
      
      // Asigna variable 8
      //vbongiov -- 2/08/2006 -- inc DBLG500000980
      if (concurso.getFaseCalificacion() && solicitud.getPuntosFaltantesMeta(concurso) != null 
          && solicitud.getPuntosFaltantesMeta(concurso).intValue() > 0) {
          dtoBuzon.setDatoVariable8(((new BigDecimal(solicitud.getPuntosFaltantesMeta(concurso).doubleValue())).setScale(0, BigDecimal.ROUND_HALF_UP)).toString());
      } else {
          dtoBuzon.setDatoVariable8("0");
      }
      
      // Asigna variable 9
      //Float saldoPunto9 = daoClientePremiacionConcurso.recuperarPuntos(solicitud.getCliente().getOidCliente(), concurso);
      //jrivas BRECHA MSG-01 8/10/2007 INICIO
      ArrayList puntos = daoClientePremiacionConcurso.recuperarPuntos(solicitud.getCliente().getOidCliente(), concurso);

      // Asigna variable 9
      if (((Integer)puntos.get(0)).intValue() != 0) {
          dtoBuzon.setDatoVariable9(new BigDecimal(((Integer)puntos.get(0)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
      } else {
          dtoBuzon.setDatoVariable9("0");
      }

      // Asigna variable 3
      if (((Integer)puntos.get(1)).intValue() != 0) {
          dtoBuzon.setDatoVariable3(new BigDecimal(((Integer)puntos.get(1)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
      } else {
          dtoBuzon.setDatoVariable3("0");
      }      

      // Asigna variable 10
      if (((Integer)puntos.get(2)).intValue() != 0) {
          dtoBuzon.setDatoVariable10(new BigDecimal(((Integer)puntos.get(2)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
      } else {
          dtoBuzon.setDatoVariable10("0");
      }  
      
      // Asigna variable 19
      if (((Integer)puntos.get(3)).intValue() != 0) {
          dtoBuzon.setDatoVariable19(new BigDecimal(((Integer)puntos.get(3)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
      } else {
          dtoBuzon.setDatoVariable19("0");
      }
      
      // Asigna variable 20
      if (((Integer)puntos.get(4)).intValue() != 0) {
          dtoBuzon.setDatoVariable20(new BigDecimal(((Integer)puntos.get(4)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP).toString());
      } else {
          dtoBuzon.setDatoVariable20("0");
      }   
      //jrivas BRECHA MSG-01 13/11/2007 FIN
      
      // Asigna variable 11
      if (solicitudConc.getPuntosBonificados() != null && concurso.getIndProductosBonificados()) {
          // vbongiov -- inc DBLG500001091 -- 31/07/06
          DAOSolicitudConcurso daoSolicitudConcurso = new DAOSolicitudConcurso();
          dtoBuzon.setDatoVariable11(daoSolicitudConcurso.obtenerPuntosBonificados(solicitud, concurso).toString());
      } else {
          dtoBuzon.setDatoVariable11("0");
      }
      
      // vbongiov -- inc DBLG500000772 -- 29/06/06
      // Asigna variable 12
      //jrivas 12/9/2006 DBLG700000005
      //if(solicitudConc.getExigenciasCumplidasEnSolicitud()) {
      if (concurso.getIndProductosExigidos()) {
          dtoBuzon.setDatoVariable12(new Integer(solicitudConc.getPuntosExigidos().intValue()).toString());
      } else {
          dtoBuzon.setDatoVariable12("0");
      }
      //} else {
          //dtoBuzon.setDatoVariable12(new Integer(solicitudConc.getPuntosExigidosSolicitud().intValue()).toString());
      //}

      dtoBuzon.setListaConsultoras(ConstantesMSG.NO);
      dtoBuzon.setCodigoPatron(null);
      
      //jrivas SiCC 20070242  28/5/07
      dtoBuzon.setDatoVariable18(concurso.getNombreConcurso() );
     
      // BELC300024358 - gPineda - 18/10/2006
      //dtoBuzon.setDatoVariable14(concurso.getNumeroConcurso());
      dtoBuzon.setDatoVariable2( concurso.getNumeroConcurso() );
      if( concurso.getFaseCalificacion() ){
        if( solicitudConc.getMetaTipoVenta() != null){
          MetaTipoVenta meta = solicitudConc.getMetaTipoVenta();

          dtoBuzon.setDatoVariable13( meta.getMontoVenta().toString() );
          dtoBuzon.setDatoVariable14( meta.getUnidadesVendidas().toString() );
          dtoBuzon.setDatoVariable15( meta.getValorIncremento().toString() );
          
          if( meta.getValMeta().compareTo( concurso.getMontoMinimoConcurso() ) < 0 ){
            dtoBuzon.setDatoVariable16( concurso.getMontoMinimoConcurso().toString() );
          }else{
            dtoBuzon.setDatoVariable16( meta.getValMeta().toString() );
          }
          
          RecuperadorDatosPremiacion recDatosPremiacion = new RecuperadorDatosPremiacion();
          // gPineda - DBLG700000298 - 25/01/2007
          //Long nivelMeta = recDatosPremiacion.recuperarNivelMeta(solicitud.getCliente().getOidCliente(), solicitudConc.getOidConcurso());
          Long nivelMeta = recDatosPremiacion.recuperarNumNivelMeta(solicitud.getCliente().getOidCliente(), solicitudConc.getOidConcurso());
          if (nivelMeta == null){
              dtoBuzon.setDatoVariable17("");
          } else {
              dtoBuzon.setDatoVariable17( nivelMeta.toString() );
          }
          
        }else{
          dtoBuzon.setDatoVariable16( concurso.getMontoMinimoConcurso().toString() );
        }
      }
      
      // vbongiov -- Cambio 20090942 -- 28/07/2009
      if(ConstantesINC.OID_CLAS_CONCUR_RECONOCIMIENTO.equals(concurso.getOidClasificacionConcurso())){
      
          ArrayList nivelSuperior = daoClientePremiacionConcurso.recuperarSiguienteNivelDesc(concurso,
                                    new BigDecimal(((Integer)puntos.get(0)).intValue()).setScale(0, BigDecimal.ROUND_HALF_UP));
                                    
          dtoBuzon.setDatoVariable8((String)nivelSuperior.get(0)); 
          
          dtoBuzon.setDatoVariable17((String)nivelSuperior.get(1));          
          
          dtoBuzon.setDatoVariable13(daoClientePremiacionConcurso.recuperarPuntBonifRecomocimiento(solicitud.getCliente().getOidCliente(), concurso).toString());
          
      }
      
      // -----------------------------------------------------------------------
      // JVM sicc 20070300
      // -----------------------------------------------------------------------
      if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
        UtilidadesLog.debug("JVM300, CONCURSO="+concurso);
        UtilidadesLog.debug("JVM300, SOLICITUD="+solicitud);
      }  
      
      /*
      UtilidadesLog.debug
      (
            "JVM300, setDatoVariable7 " +
            " concurso.getFaseCalificacion()="+concurso.getFaseCalificacion()+
            " solicitud.getIncremento().compareTo(new BigDecimal(0))="+solicitud.getIncremento().compareTo(new BigDecimal("0"))+
            " concurso.getIndDuplaCyzone()="+concurso.getIndDuplaCyzone()+
            " solicitud.getIncrementoReal().compareTo(new BigDecimal(0)="+solicitud.getIncrementoReal().compareTo(new BigDecimal("0"))+
            " solicitud.getIncrementoReal().toString()="+solicitud.getIncrementoReal().toString()
      );
      */

      if (  
            (concurso.getFaseCalificacion()) &&
            (concurso.getIndDuplaCyzone()) &&
            !(solicitud.getIncrementoReal().compareTo(new BigDecimal("0")) == -1)  
         ) 
      {         
          dtoBuzon.setDatoVariable7(solicitud.getIncrementoReal().setScale(0, BigDecimal.ROUND_HALF_UP).toString());
          
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
            UtilidadesLog.debug(
              "JVM300, solicitud.getIncrementoReal().toString()="+solicitud.getIncrementoReal().toString()+
              " getDatoVariable7="+dtoBuzon.getDatoVariable7());
          
      }else{
          dtoBuzon.setDatoVariable7("0");
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
            UtilidadesLog.debug("JVM300, 0 to getDatoVariable7="+dtoBuzon.getDatoVariable7());
      }
      
      // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
      if(ConstantesINC.OID_CLAS_CONCUR_RECONOCIMIENTO.equals(concurso.getOidClasificacionConcurso())){
          ArrayList datosRanking = daoClientePremiacionConcurso.recuperarPuntajeRanking(solicitud.getCliente().getOidCliente(),
                                        concurso.getNumeroConcurso(), solicitud.getPeriodo());
                                    
          if(datosRanking.size() > 0) {
              dtoBuzon.setDatoVariable7((String)datosRanking.get(0)); 
              
              if((concurso.getTextoRanking() != null) && (datosRanking.get(1) != null)) {
                  dtoBuzon.setDatoVariable14(concurso.getTextoRanking() + " " + (String)datosRanking.get(1)); 
              } else {
                  dtoBuzon.setDatoVariable14(" "); 
              }
          } else {
              dtoBuzon.setDatoVariable14(" "); 
          }
      }
      
      
      // -----------------------------------------------------------------------
      
      try {
          MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
          DTOBuzonMensajes dtoBuzonRetorno = monMSG.insertaDatosMensajeBatch(dtoBuzon);
          if (dtoBuzonRetorno!=null && dtoBuzonRetorno.getOid()!=null){
            DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
            dao.actualizarMensajeIncentivos(solicitud.getOidSolicitud(), solicitudConc.getOidConcurso(), dtoBuzonRetorno);
          }
          
      } catch (CreateException ce) {
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re) {
          UtilidadesLog.error("ERROR ", re);
          throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }      
      UtilidadesLog.info("GestorMensajesPuntuacion.crearMensajeMontoUnidadesConsultoras(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Salida");
  }
  
  public void crearMensajeGenerico(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos) throws MareException {
      UtilidadesLog.info("GestorMensajesPuntuacion.crearMensajeGenerico(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Entrada");
      Iterator i = concursos.iterator();
        boolean found = false;
        Concurso concurso = null;

        while (i.hasNext() && !found) {
            concurso = (Concurso) i.next();

            if (concurso.getOidConcurso().longValue() == solicitudConc.getOidConcurso().longValue()) {
                found = true;
            }
        }

        DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
        dtoBuzon.setOidPais(solicitud.getOidPais());

        DAOClientePremiacionConcurso daoCli = new DAOClientePremiacionConcurso();

        //jrivas 12/8/2005
        //Inc 20454
        String codMensajeAux = daoCli.recuperarCodigoMensajeObtencion(concurso.getOidConcurso());
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** codMensajeAux: " + codMensajeAux);
          
        dtoBuzon.setCodigoMensaje(codMensajeAux);

        //dtoBuzon.setCodigoMensaje(concurso.getProductosValidos().getMensaje());
        dtoBuzon.setOidCliente(solicitud.getCliente().getOidCliente());
        dtoBuzon.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);
        // vbongiov -- 19/09/2006
        dtoBuzon.setDatoVariable1(solicitud.getCliente().getNombre()!=null?solicitud.getCliente().getNombre():"");
        dtoBuzon.setDatoVariable2(concurso.getPeriodoDesde().getCodperiodo());
        dtoBuzon.setDatoVariable3(concurso.getPeriodoHasta().getCodperiodo());
        dtoBuzon.setDatoVariable4(new Integer(solicitudConc.getNumeroPeriodosEvaluados() + 1).toString());
        dtoBuzon.setDatoVariable5(concurso.getNumeroConcurso().toString());
        //jrivas 1/3/2006 inc 22678
        BigDecimal monto = solicitudConc.getMontoValido().divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
        dtoBuzon.setDatoVariable6(monto.toString());
        dtoBuzon.setDatoVariable9(solicitudConc.getPuntosValidos().toString());
        dtoBuzon.setDatoVariable11(solicitudConc.getPuntosBonificados().toString());
        
        // vbongiov -- inc DBLG500000772 -- 29/06/06
        // Variable 12
        //jrivas 12/9/2006 DBLG700000005
        if (concurso.getIndProductosExigidos()) {
          dtoBuzon.setDatoVariable12(new Integer(solicitudConc.getPuntosExigidos().intValue()).toString());
        } else {
          dtoBuzon.setDatoVariable12("0");
        }
        
        dtoBuzon.setListaConsultoras(ConstantesMSG.NO);
        dtoBuzon.setCodigoPatron(null);
        
        //jrivas SiCC 20070242  28/5/07
        dtoBuzon.setDatoVariable16(concurso.getNombreConcurso() );
        
        try {
            MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
            DTOBuzonMensajes dtoBuzonRetorno = monMSG.insertaDatosMensajeBatch(dtoBuzon);
            
            DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
            dao.actualizarMensajeIncentivos(solicitud.getOidSolicitud(), solicitudConc.getOidConcurso(), dtoBuzonRetorno);
            
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
      
      UtilidadesLog.info("GestorMensajesPuntuacion.crearMensajeGenerico(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Salida");
  }
  
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public void generarMensajeSorteo(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos, String numerosAsignados) throws MareException {
        UtilidadesLog.info("GestorMensajesPuntuacion.generarMensajeSorteo(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos, String numerosAsignados):Entrada");
        
        Iterator i = concursos.iterator();
        boolean found = false;
        Concurso concurso = null;

        while (i.hasNext() && !found) {
            concurso = (Concurso) i.next();

            if (concurso.getOidConcurso().longValue() == solicitudConc.getOidConcurso().longValue()) {
                found = true;
            }
        }

        DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
        dtoBuzon.setOidPais(solicitud.getOidPais());        
        dtoBuzon.setCodigoMensaje("INC44");    
        dtoBuzon.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);     
        dtoBuzon.setOidCliente(solicitud.getCliente().getOidCliente());
        dtoBuzon.setDatoVariable1(concurso.getPeriodoDesde().getCodperiodo());
        dtoBuzon.setDatoVariable2(concurso.getPeriodoHasta().getCodperiodo());
        dtoBuzon.setDatoVariable3(concurso.getMontoMinimoConcurso()==null?"":concurso.getMontoMinimoConcurso().toString());         
        dtoBuzon.setDatoVariable4(concurso.getDescProducto());
        dtoBuzon.setDatoVariable5(numerosAsignados);        
        dtoBuzon.setDatoVariable6(concurso.getCantidadNumerosAOtorgar().toString());        
        
        try {
            MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
            DTOBuzonMensajes dtoBuzonRetorno = monMSG.insertaDatosMensajeBatch(dtoBuzon);
           
            
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }      
        UtilidadesLog.info("GestorMensajesPuntuacion.generarMensajeSorteo(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos, String numerosAsignados):Salida");
    }
}