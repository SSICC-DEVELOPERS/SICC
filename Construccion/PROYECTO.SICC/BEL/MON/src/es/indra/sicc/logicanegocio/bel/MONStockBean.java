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
package es.indra.sicc.logicanegocio.bel;

//import com.sun.ejb.ejbql.parser.ParseException;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.bel.DTOActualizarStockMinimo;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocal;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocalHome;
import es.indra.sicc.entidades.bel.EstimadosDeVentaBelcenterLocal;
import es.indra.sicc.entidades.bel.EstimadosDeVentaBelcenterLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;

import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.DAOServicioBel;

import es.indra.sicc.entidades.ped.AsignacionAlmacenLocal;
import es.indra.sicc.entidades.ped.AsignacionAlmacenLocalHome;

import es.indra.sicc.logicanegocio.pre.PREConsultas;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;

import java.math.BigDecimal;
import java.sql.Date;

import java.text.ParseException;

import java.util.Calendar;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONStockBean implements SessionBean 
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
  {
    this.ctx = ctx;
  }


  
  private void loguearError(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +
            e.getMessage());
        UtilidadesLog.info("Error: ",e);
    }


  
  private Integer diferenciaDiasFecha(Date fechaInicio, Date fechaFin){
    UtilidadesLog.info("MONStockBean.diferenciaDiasFecha(Date fechaInicio, Date fechaFin):Entrada");
    int tiempo = 86400000;//milisegundos de un dia
    /*
    Long diferencia = new Long( fechaFin.getTime() - fechaInicio.getTime());
    Integer dias = new Integer(diferencia.intValue() / tiempo);
    */
    
    Calendar fecha = Calendar.getInstance();
    fecha.setTime(fechaInicio);
    long milisFechaInic = fecha.getTimeInMillis();
    fecha.setTime(fechaFin);
    long milisFechaFin = fecha.getTimeInMillis();
    
    long diferencia = milisFechaFin - milisFechaInic;
    Long dias = new Long(diferencia / tiempo);

    UtilidadesLog.info("MONStockBean.diferenciaDiasFecha(Date fechaInicio, Date fechaFin):Salida");
    return new Integer(dias.intValue());
  }



  public Long obtenerEADP(Long estimadoVenta, Float factorLocal) throws MareException
  {
    UtilidadesLog.info("MONStockBean.obtenerEADP(Long estimadoVenta, Float factorLocal):Entrada");
    // Hallamos el número de unidades estimadas de Belcenter 
    //-> Llamar al método "findByPrimaryKey" de la entidad 
    //"EstimadosDeVentaBelcenter" tomando "estimadoVenta" 
    EstimadosDeVentaBelcenterLocalHome estimadosDeVentaBelcenterLocalHome = null;
    EstimadosDeVentaBelcenterLocal estimadosDeVentaBelcenterLocal = null;
    
    estimadosDeVentaBelcenterLocalHome = this.getEstimadosDeVentaBelcenterLocalHome();
    try{
    
      estimadosDeVentaBelcenterLocal = estimadosDeVentaBelcenterLocalHome.findByPrimaryKey(estimadoVenta);
    }catch(NoResultException fe){
      //ctx.setRollbackOnly();
      this.loguearError("obtenerEADP: FinderException",fe);
      throw new MareException(fe,UtilidadesError.armarCodigoError(
      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    //Crear variable llamada "producto" 
    //de tipo Long = EstimadosDeVentaBelcenter.oidMaestroProductos 
    Long producto = estimadosDeVentaBelcenterLocal.getProducto(); //Si es esto por el diseño y la incidencia 11940
    
    //-> Crear variable llamada "unidadesEstimadas" 
    //de tipo Long = EstimadosDeVentaBelcenter.unidadesEstimadas 
    Long unidadesEstimadas = estimadosDeVentaBelcenterLocal.getUnidadesEstimadas();
    //-> Crear variable llamada "periodo" de tipo Long = EstimadosDeVentaBelcenter.oidPeriodo
    Long periodo = estimadosDeVentaBelcenterLocal.getPeriodo();
    
    // Calculamos el número de días del período 
    //-> Hacer findByPrimaryKey sobre la entidad Periodo tomando el valor de "periodo"
    PeriodoLocalHome periodoLocalHome = null;
    PeriodoLocal periodoLocal = null;
    
    periodoLocalHome = this.getPeriodoLocalHome();
    try{
        periodoLocal = periodoLocalHome.findByPrimaryKey(periodo);
      
    }catch(NoResultException fe){
      // como no se ejecuta en un contexto transaccional no se puede hacer rollback
      //ctx.setRollbackOnly();
      this.loguearError("obtenerEADP: FinderException",fe);
      throw new MareException(fe,UtilidadesError.armarCodigoError(
      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    
    //Crear variable llamada "diasPeriodo" de tipo Integer 
    //y asignarle la diferencia de días entre Periodo.fechaIni y Periodo.fechaFin
    Date fechaIni = periodoLocal.getFechainicio();
    Date fechaFin = periodoLocal.getFechaFin();
    Integer diasPeriodo = this.diferenciaDiasFecha(fechaIni,fechaFin);
    
    /* Calculamos el número de unidades estimadas de venta directa 
    -> Tomar producto y periodo para la siguiente llamada 
    -> Llamar al método "PREConsultas.obtenerEstimadosVentaProducto
    (producto : Long, periodo : Long) : Long" */
    //Crear variable llamada "unidadesEstimadasVD" de tipo Long = respuesta de la llamada anterior 
    //incidencia 11914
    PREConsultas preConsultas = new PREConsultas(ctx);
    DTOSalida dtoSalida = new DTOSalida();
    Long unidadesEstimadasVD = null;
    unidadesEstimadasVD = preConsultas.obtenerEstimadosVentaProducto(producto,periodo);
    //Crear variable llamada "respuesta" de tipo Long 
    // Cálculo del EADP, redondear sin decimales 
    //respuesta = (unidadesEstimadas / diasPeriodo) + ((unidadesEstimadasVD / diasPeriodo) * factorLocal) 
    //Devolver "respuesta"
    
    /*Long respuesta = new Long((unidadesEstimadas.longValue()/diasPeriodo.longValue())+
    ((unidadesEstimadasVD.longValue()/diasPeriodo.longValue())*factorLocal.longValue()));*/

    double sumando1 = unidadesEstimadas.doubleValue()/diasPeriodo.doubleValue();
    double sumando2 = (unidadesEstimadasVD.doubleValue()/diasPeriodo.doubleValue()) * factorLocal.doubleValue();
    double resultado = sumando1 + sumando2;
    double redondeo = Math.rint(resultado);
    Long respuesta = new Long((new Double(redondeo)).longValue());
/*    
    Long respuesta = new Long(Math.rint((unidadesEstimadas.doubleValue()/diasPeriodo.doubleValue())+
    ((unidadesEstimadasVD.doubleValue()/diasPeriodo.doubleValue())*factorLocal.doubleValue())));
  */
    UtilidadesLog.info("MONStockBean.obtenerEADP(Long estimadoVenta, Float factorLocal):Salida");
    return respuesta;
    
  }

  public void actualizarStockMinimo(DTOActualizarStockMinimo dto) throws MareException
  {
    UtilidadesLog.info("MONStockBean.actualizarStockMinimo(DTOActualizarStockMinimo dto):Entrada");
    
    String usuario = ctx.getCallerPrincipal().getName();
    //Tomar dto.pais y dto.subacceso para la siguiente llamada 
    //Llamar el método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
    ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
    ParametrosBelcenterLocal parametrosBelcenterLocal = null;
    parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
    
    try {
       parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
       dto.getSubacceso());
    } catch(NoResultException fe){
       ctx.setRollbackOnly();
       this.loguearError("actualizarStockMinimo: FinderException",fe);
       /* Modificado por ssantana, 08/07/2006, MAN-BEL-011 */
       /* El mensaje de error debe ser "Peticion de Datos No existente" */ 
       String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
       throw new MareException(fe,
                               UtilidadesError.armarCodigoError(sCodigoError));
       /* Fin Modificado por ssantana, 08/07/2006, MAN-BEL-011 */
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    //Crear variable llamada "tiempoDeReposicion" de 
    //tipo Integer = ParametrosBelcenter.tiempoDeReposicion
    Integer tiempoDeReposicion = parametrosBelcenterLocal.getTiempoDeReposicion();
    
    //Crear variable llamada "factorLocal" de tipo Float = ParametrosBelcenter.factorLocal 
    Float factorLocal = parametrosBelcenterLocal.getFactorLocal();
    
    /*Tomar dto.periodo y dto.subacceso para la siguiente llamada 
     ->Llamar al método "DAOServicioBEL.obtenerEstimadosVenta
     (periodo : Long, subacceso : Long) : DTOSalida" 
     -> Crear variable llamada "estimadosVenta" de tipo RecordSet 
     y asignarle la respuesta a la llamada anterior*/
     
     DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
     RecordSet estimadosVenta = daoServicioBel.obtenerEstimadosDeVentaBelcenter
     (dto.getPeriodo(),dto.getSubacceso());
     //Añadido por la incidencia 12171
    //Crear variable llamada "almacen"
    Long almacen = null;
    //Llamar al método "findByPrimaryKey()" de la entidad Periodo pasando como parámetro dto.periodo
    PeriodoLocalHome periodoLocalHome = null;
    PeriodoLocal periodoLocal = null;
    
    periodoLocalHome = this.getPeriodoLocalHome();
    try{
        periodoLocal = periodoLocalHome.findByPrimaryKey(dto.getPeriodo());
      
    }catch(NoResultException fe){
      ctx.setRollbackOnly();
      this.loguearError("actualizarStockMinimo: FinderException",fe);
      throw new MareException(fe,UtilidadesError.armarCodigoError(
      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    
    //Tomar los valores de dto.pais, Periodo.oidMarca y dto.subacceso para la siguiente llamada
    //Llamar al método "findByUK(pais : Long, marca : Long, subacceso : Long) : 
    //AsignacionAlmacen" de la entidad AsignacionAlmacen
    AsignacionAlmacenLocalHome asignacionAlmacenLocalHome = null;
    AsignacionAlmacenLocal asignacionAlmacenLocal = null;
    
    asignacionAlmacenLocalHome = this.getAsignacionAlmacenLocalHome();
    try{
                asignacionAlmacenLocal = asignacionAlmacenLocalHome.findByUK(dto.getOidPais(),
                periodoLocal.getOidMarca(), dto.getSubacceso());
    }catch(NoResultException fe){
      ctx.setRollbackOnly();
      this.loguearError("actualizarStockMinimo: FinderException",fe);
      throw new MareException(fe,UtilidadesError.armarCodigoError(
      ErroresDeNegocio.BEL_0018));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    //almacen = AsignacionAlmacen.oidAlmacen
    almacen = asignacionAlmacenLocal.getAlmacen();
    UtilidadesLog.info("EstimadosVenta.RowCount: "+estimadosVenta.getRowCount());
     //(1)Para cada registro de "estimadosVenta" hacer 
     for(int i = 0; i< estimadosVenta.getRowCount(); i++){
       
        /*Tomar el valor del campo "OID_ESTI" y factorLocal para la siguiente llamada 
        -> Llamar al método "MONStock.obtenerEADP
        (estimadoVenta : Long, factorLocal : Float) : Long" 
        -> Crear variable llamada "eadp" de tipo Long = respuesta a la llamada anterior*/
        
        Long oidEstimados = new Long(((BigDecimal)estimadosVenta.getValueAt(i,"OID_ESTI")).longValue());
        Long eadp = this.obtenerEADP(oidEstimados, factorLocal);
        
        //-> Crear variable llamada "SMn" de tipo Long = eadp * tiempoReposicion 
        Long SMn = new Long(eadp.longValue()*tiempoDeReposicion.longValue());
        
        /*-> Llamar al método "findByPrimaryKey()" de la entidad EstimadosDeVentaBelcenter 
        -> Crear variable llamada "producto" de tipo Long = 
        EstimadosDeVentaBelcenter.oidMaestroProductos */
        EstimadosDeVentaBelcenterLocalHome estimadosDeVentaBelcenterLocalHome = null;
        EstimadosDeVentaBelcenterLocal estimadosDeVentaBelcenterLocal = null;
        
        estimadosDeVentaBelcenterLocalHome = this.getEstimadosDeVentaBelcenterLocalHome();
        try{
        
          estimadosDeVentaBelcenterLocal = estimadosDeVentaBelcenterLocalHome.findByPrimaryKey(oidEstimados);
        }catch(NoResultException fe){
          ctx.setRollbackOnly();
          this.loguearError("actualizarStockMinimo: FinderException",fe);
          throw new MareException(fe,UtilidadesError.armarCodigoError(
          CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Long producto = estimadosDeVentaBelcenterLocal.getProducto(); //  no se si será así
        
       try{
            /*-> Tomar dto.subacceso y producto 
            -> Llamar al método "findByUK(subacceso : Long, producto : Long) : ControlesDeAlmacen" de la entidad ControlesDeAlmacen 
            -> ControlesDeAlmacen.stockMinimo = SMn 
            -> ControlesDeAlmacen.activado = ConstantesBEL.CONTROL_ALMACEN_ACTIVADO*/
            ControlesDeAlmacenLocalHome controlesDeAlmacenLocalHome = null;
            ControlesDeAlmacenLocal controlesDeAlmacenLocal = null;
            
            controlesDeAlmacenLocalHome = this.getControlesDeAlmacenLocalHome();
            
              controlesDeAlmacenLocal = controlesDeAlmacenLocalHome.findByUK(dto.getSubacceso(),
              producto, almacen);
            
            controlesDeAlmacenLocal.setStockMinimo(SMn);
            controlesDeAlmacenLocal.setActivado(ConstantesBEL.CONTROL_ALMACEN_ACTIVADO);
            
            this.getControlesDeAlmacenLocalHome().merge(controlesDeAlmacenLocal);
          
        }catch(NoResultException fe){
          
          UtilidadesLog.info("Se produce error FinderException y se procede a hacer create en ControlesDeAlmacen");
          /*Hacer create en la entidad ControlesDeAlmacen tomando dto.subacceso y producto, y hacer el siguiente mapeo: 
          -> ControlesDeAlmacen.stockMinimo = SMn 
          -> ControlesDeAlmacen.stockMaximo = SMn * 3 
          -> ControlesDeAlmacen.stockReposicion = SMn 
          -> ControlesDeAlmacen.activado = ConstantesBEL.CONTROL_ALMACEN_ACTIVADO */
          
          ControlesDeAlmacenLocalHome controlesDeAlmacenLocalHome = null;
          ControlesDeAlmacenLocal controlesDeAlmacenLocal = null;
            
          controlesDeAlmacenLocalHome = this.getControlesDeAlmacenLocalHome();
         try{
            controlesDeAlmacenLocal = controlesDeAlmacenLocalHome.create(dto.getSubacceso(),
            producto, almacen);
         }catch(PersistenceException ce){
            
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            this.loguearError("actualizarStockMinimo: CreateException",ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
          }
          if(controlesDeAlmacenLocal != null)
          {
            controlesDeAlmacenLocal.setStockMinimo(SMn);
            controlesDeAlmacenLocal.setStockMaximo(new Long(SMn.longValue()*3));
            controlesDeAlmacenLocal.setStockReposicion(SMn);
            controlesDeAlmacenLocal.setActivado(ConstantesBEL.CONTROL_ALMACEN_ACTIVADO);
            controlesDeAlmacenLocalHome.merge(controlesDeAlmacenLocal);
          }
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

        }
        
     }
    
    UtilidadesLog.info("MONStockBean.actualizarStockMinimo(DTOActualizarStockMinimo dto):Salida");
  }

    private PeriodoLocalHome getPeriodoLocalHome() {
        return new PeriodoLocalHome();
    }

    private EstimadosDeVentaBelcenterLocalHome getEstimadosDeVentaBelcenterLocalHome() {
        return new EstimadosDeVentaBelcenterLocalHome();
    }

    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
        return new ParametrosBelcenterLocalHome();
    }
      
     private ControlesDeAlmacenLocalHome getControlesDeAlmacenLocalHome() {
        return new ControlesDeAlmacenLocalHome();
    }

     private AsignacionAlmacenLocalHome getAsignacionAlmacenLocalHome() {
        return new AsignacionAlmacenLocalHome();
    }    
}

