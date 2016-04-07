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
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.dtos.intsys.DTOECMRecibir;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTORegistroECM2;

import es.indra.sicc.dtos.mae.DTOGenerarCodigoCliente;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

import es.indra.sicc.entidades.intsys.RecepcionVentasAsociadasLocal;
import es.indra.sicc.entidades.intsys.RecepcionVentasAsociadasLocalHome;

import es.indra.sicc.entidades.mae.ClasificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocal;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocal;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDireccionLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.entidades.mae.ClienteIdentificacionLocal;
import es.indra.sicc.entidades.mae.ClienteIdentificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteMarcaLocal;
import es.indra.sicc.entidades.mae.ClienteMarcaLocalHome;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocal;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocalHome;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.ClienteVinculoLocal;
import es.indra.sicc.entidades.mae.ClienteVinculoLocalHome;
import es.indra.sicc.entidades.mae.EstadoCivilLocal;
import es.indra.sicc.entidades.mae.EstadoCivilLocalHome;
import es.indra.sicc.entidades.mae.NivelEstudiosLocal;
import es.indra.sicc.entidades.mae.NivelEstudiosLocalHome;
import es.indra.sicc.entidades.mae.TipoClasificacionLocal;
import es.indra.sicc.entidades.mae.TipoClasificacionLocalHome;
import es.indra.sicc.entidades.mae.TipoClienteLocal;
import es.indra.sicc.entidades.mae.TipoClienteLocalHome;
import es.indra.sicc.entidades.mae.TipoComunicacionLocal;
import es.indra.sicc.entidades.mae.TipoComunicacionLocalHome;
import es.indra.sicc.entidades.mae.TipoDocumentoLocal;
import es.indra.sicc.entidades.mae.TipoDocumentoLocalHome;
import es.indra.sicc.entidades.mae.SubtipoClienteLocal;
import es.indra.sicc.entidades.mae.SubtipoClienteLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClasificacionLocal;
import es.indra.sicc.entidades.mae.TipoVinculoLocal;
import es.indra.sicc.entidades.mae.TipoVinculoLocalHome;

import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.EmpresaLocal;
import es.indra.sicc.entidades.seg.EmpresaLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.NacionalidadLocal;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.TipoViaLocal;
import es.indra.sicc.entidades.seg.TipoViaLocalHome;

import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocal;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocalHome;

import es.indra.sicc.entidades.zon.ViaLocal;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.entidades.zon.ViaLocalHome;
import es.indra.sicc.entidades.seg.NacionalidadLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONECMBean implements SessionBean 
{
	private SessionContext ctx;
	//private DTORegistroECM2 valoresInterfaz;
	private Hashtable valoresDefecto = new Hashtable();

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

public DTOSalidaBatch cargarVentasPED(DTOBatch dtoBatch) throws MareException 
        {
        UtilidadesLog.info("MONECMBean.cargarVentasPED(DTOBatch dtoBatch): Entrada");
        /*-> Llamar al metodo obtenerRecepcionVentas() del DAOECM con el dtoe (DTOINT) recibido 
        -> Recuperar y recorrer RecordSet obtenido */ 
        DTOINT dto  = (DTOINT) dtoBatch.getDTOOnline(); 
        DAOECM daoEcm = new DAOECM(); 
        Long tipoSolicitud = null; 
        DTOCabeceraSolicitud dtoCabeceraSolicitud = null; 
        DTOPosicionSolicitud dtoPosicionSolicitud = null; 
        RecordSet rs = daoEcm.obtenerRecepcionVentas(dto); 
        UtilidadesLog.debug("cargarVentasPED ---->RS QUE DEVULEVE daoEcm.obtenerRecepcionVentas " + rs); 
        if (!rs.esVacio()){ 
            int filas = rs.getRowCount(); 
            for (int i = 0 ; i < filas ; i++){ 
                //Llamar al metodo obtenerTipoSolicitud() del DAOECM , 
                //enviando los campos pais, marca, canal y sociedad del registro tratado 
                RecordSet rsTipoSolicitud=daoEcm.obtenerTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue()), 
                                            new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()), 
                                            new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue()), 
                                            new Long(((BigDecimal)rs.getValueAt(i,"SOCIEDAD")).longValue())); 
                //Recuperar primer registro obtenido en consulta anterior 
                tipoSolicitud = new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,0)).longValue()); 
                UtilidadesLog.debug("  cargarVentasPED ----->tipoSolicitud "+tipoSolicitud); 
                
                 UtilidadesLog.debug("  cargarVentasPED ----->rsTipoSolicitud "+rsTipoSolicitud); 
                
                if (rsTipoSolicitud.getValueAt(0,"PRODUCTO")==null){ 
                    //Si campo producto del registro = NULL , 
                    //mediante MareLogging generar mensaje de error INT-0038 y pasar a procesar siguiente registro 
                    UtilidadesLog.debug ("Error INT_0038: No existe en la Entidad Tipo de Solicitud por Proceso el Código de Producto:");                     
                    continue; 
                } 
                //------------- 
                /*Con valores recuperados y valores de los campos del registro tratado, 
                  crear un dto de tipo DTOCabeceraSolicitud:*/ 
                dtoCabeceraSolicitud = new DTOCabeceraSolicitud(); 
                                dtoCabeceraSolicitud.setOidIdioma(dto.getOidIdioma());//Pendiente de preguntar a diseño 
                dtoCabeceraSolicitud.setOperacion(ConstantesBEL.INT161); 
                //Incidencia 15142 CORREGIDA 
                dtoCabeceraSolicitud.setModulo(ConstantesSEG.MODULO_INT_ECM); 
                dtoCabeceraSolicitud.setOidPais(new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue())); 
                dtoCabeceraSolicitud.setTipoSolicitud(tipoSolicitud); 
                dtoCabeceraSolicitud.setTipoCliente(new Long(ConstantesMAE.TIPO_CLIENTE_CONSULTORA)); 
                dtoCabeceraSolicitud.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"CLIENTE")).longValue())); 
                dtoCabeceraSolicitud.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue())); 
                dtoCabeceraSolicitud.setCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue())); 
                UtilidadesLog.debug("cargarVentasPED ---->Acceso "+ new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"ACCESO")).longValue())); 
                UtilidadesLog.debug("cargarVentasPED ---->SUBACCESO "+ new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"SUBACCESO")).longValue())); 
                dtoCabeceraSolicitud.setAcceso(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"ACCESO")).longValue())); 
                dtoCabeceraSolicitud.setSubacceso(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"SUBACCESO")).longValue())); 
                String codigocliente=(String)rs.getValueAt(i,"CODIGOCLIENTE"); 
                dtoCabeceraSolicitud.setCliente(codigocliente); 
                //convierto a string el numero de lote para trabajar con el substring 
                String numLote = dto.getNumeroLote().toString(); 
                UtilidadesLog.debug("cargarVentasPED----> NumeroLote: "+numLote); 
                UtilidadesLog.debug("cargarVentasPED---->NumeroDocumentoOrigen(10 ultimos de NumLote): "+numLote.substring(numLote.length()-10,numLote.length())); 
                dtoCabeceraSolicitud.setNumeroDocumentoOrigen(new Long(numLote.substring(numLote.length()-10,numLote.length()))); 
                dtoCabeceraSolicitud.setFecha(new Date(((java.sql.Date)rs.getValueAt(i,"FECHA")).getTime())); 
                UtilidadesLog.debug("cargarVentasPED----> dtoCabeceraSolicitud Antes de Evnviar a IPeriodo  " + dtoCabeceraSolicitud); 
                
                MONPeriodos iPeriodo = this.getMONPeriodos(); 
                DTOPeriodo oidPeriodo; 
                try{ 
                    oidPeriodo = iPeriodo.obtienePeriodoActual(new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue()), 
                                    new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()), 
                                    new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue())); 
                }catch(RemoteException re){ 
                                        UtilidadesLog.error(re); 
                                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB; 
                                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError)); 
                                } 
                dtoCabeceraSolicitud.setPeriodo(oidPeriodo.getOid()); 
                //------------ 
                /*Con valores previamente recuperados y valores de los campos del registro tratado, 
                  crear un dto de tipo DTOPosicionSolicitud:*/ 
                dtoPosicionSolicitud = new DTOPosicionSolicitud(); 
                dtoPosicionSolicitud.setTipoPosicion(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"TIPOPOSICION")).longValue())); 
                dtoPosicionSolicitud.setSubtipoPosicion(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"SUBTIPOPOSICION")).longValue())); 
                dtoPosicionSolicitud.setProducto(new Long(((BigDecimal)rsTipoSolicitud.getValueAt(0,"PRODUCTO")).longValue())); 
                dtoPosicionSolicitud.setUnidadesDemandadas(new Long(-1)); 
                dtoPosicionSolicitud.setUnidadesPorAtender(new Long(-1)); 
                dtoPosicionSolicitud.setUnidadesDemandaReal(new Long(-1)); 
                dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rs.getValueAt(i,"IMPORTEABONOCONSULTORA")); 
                
                dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento((BigDecimal)rs.getValueAt(i,"IMPORTEABONOCONSULTORA"));
                
                //-------- 
                //Añadido por incidencia BELC300015153 
                ArrayList posiciones = new ArrayList(); 
                posiciones.add(dtoPosicionSolicitud); 
                dtoCabeceraSolicitud.setPosiciones(posiciones); 
                UtilidadesLog.debug("cargarVentasPED---->dtoCabeceraSolicitud Con el que llamamos a Generar SolicitudesExternas "); 
                UtilidadesLog.debug("cargarVentasPED---->dtoCabeceraSolicitud "+dtoCabeceraSolicitud); 
                //Llamar a IPEDGenerarSolicitudesExternas.generaSolicitud() con dtos creados 
                MONGenerarSolicitudModulosExternos iPEDGenerarSolicitudesExternas = this.getMONGenerarSolicitudModulosExternos(); 
                try{ 
                    iPEDGenerarSolicitudesExternas.generaSolicitud(dtoCabeceraSolicitud); 
                    UtilidadesLog.debug("cargarVentasPED----> iPEDGenerarSolicitudesExternas.generaSolicitud HA SALIDO"); 
                }catch(RemoteException re){ 
                                        UtilidadesLog.error(re); 
                                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB; 
                                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError)); 
                                } 
            }//fin For 
        } 
        
        UtilidadesLog.info("MONECMBean.cargarVentasPED(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0,"MONECM.cargarVentasPED ejecutado"); 
	} 

	/**
   * Como parte de la recepcion de ventas por e-commerce mediante interfaz ecm-1,
   * se asignan los puntajes a concursos vigentes para los clientes afectados 
   * siempre que posean el estatus adecuado.
   * @return: DTOSalidaBatch
   * @param: DTOBatch dtoBatch con info de la interfaz
   * Modificaciones:
   *  - 06/04/2006 alorenzo BELC300022779
   *  - 27/06/2006 eiraola  DBLG400001109 Ya no asigna puntaje en base a periodos
   *    sino por la fecha de internet.
   */
  public DTOSalidaBatch cargarVentasINC(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONECMBean.cargarVentasINC(DTOBatch dtoBatch): Entrada");
		  // Obtenemos registros de INT:RecepcionVentasAsociadas para numeroLote y codigo del Interfaz 
      DTOINT dto  = (DTOINT) dtoBatch.getDTOOnline();
      UtilidadesLog.debug("cargarVentasINC ----> Idioma " + dto.getOidIdioma());
		  
      DAOECM dao = new DAOECM();
		  RecordSet rs = dao.obtenerRecepcionVentasTodas(dto);
		  UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'rs' de las ventas recibidas " + rs  );
      
      if (!rs.esVacio()) {
          int cantRegistrosRecepVtas = rs.getRowCount();
                    
          for (int i = 0; i < cantRegistrosRecepVtas; i++) {  //para(1) i - registros de recepcion de ventas
              Long oidCliente = bigDecimalToLong(rs.getValueAt(i, "CLIENTE"));
              UtilidadesLog.debug("cargarVentasINC ==========>> oidCliente_" + oidCliente);
              
              RecepcionVentasAsociadasLocal valor = null;
              try {
                  valor = this.getRecepcionVentasAsociadasLocalHome().findByPrimaryKey(new Long(((BigDecimal)rs.getValueAt(i,"OID")).toString()));
              } catch (NoResultException f) {
                  UtilidadesLog.error(f);
                  String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(f, UtilidadesError.armarCodigoError(codigoError));
              }  catch (PersistenceException ce) {
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              valor.setIndGeneroPuntos(new Boolean(false));
              this.getRecepcionVentasAsociadasLocalHome().merge(valor);
              
              DTOPeriodo dtoP = new DTOPeriodo();
              dtoP.setPais(bigDecimalToLong(rs.getValueAt(i, "PAIS")));
              dtoP.setMarca(bigDecimalToLong(rs.getValueAt(i, "MARCA")));
              dtoP.setCanal(bigDecimalToLong(rs.getValueAt(i, "CANAL")));
              dtoP.setFechaInicio(dateToSqlDate(rs.getValueAt(i, "FECHA")));
              UtilidadesLog.debug("cargarVentasINC ----> DTOPeriodo dtoP con la Fecha Internet (no tiene OID)" + dtoP);
              
              
						  //Obtenemos concursos en los que se puede asignar Puntaje
              RecordSet concursos = dao.obtenerConcursos(dtoP);
              UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'concursos' para la fecha de Internet " + concursos);
              if (!concursos.esVacio()) {
                  int cantConcursos = concursos.getRowCount();
                  
                  MONPeriodos monPeriodos;
                  DTOSalida dtoSalida;
                  RecordSet periodos;
                  
                  for (int k = 0; k < cantConcursos ; k++) {  //para(2) k - concursos
                      Long oidConcurso = bigDecimalToLong(concursos.getValueAt(k, "CONCURSO"));
                      UtilidadesLog.debug("cargarVentasINC ==========>> oidConcurso_" + oidConcurso);
                      boolean generaPuntos = false;
                      
                      
                      //Evaluamos si la consultora esta descalificada para el concurso
                      RecordSet descalificacion = dao.obtenerDescalificacion(oidCliente, oidConcurso);
                      UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'descalificacion' para el oidCliente y oidConcurso" + descalificacion);
                      
                      if (descalificacion.esVacio()) {  //La consultora no esta descalificada para el concurso
                          generaPuntos = true;
                      } else {
                          UtilidadesLog.debug(" el cliente: " + oidCliente + " está descalificado para el concurso: " + oidConcurso);
                          UtilidadesLog.debug(" pasamos al proximo concurso...");
                          continue;
                      }
                      
                      
                      //Obtenemos periodos para el registro de Ventas Asociadas y fechaOrdenInternet del Interfaz
                      monPeriodos = this.getMONPeriodos();
                      dtoSalida = null;
                      try {
                          dtoSalida = monPeriodos.obtienePeriodosFecha(dtoP);
                      } catch (RemoteException re) {
                          UtilidadesLog.error(re);
                          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                          throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                      }
                      periodos = dtoSalida.getResultado();
                      UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'periodos' para la fecha de Internet " + periodos);
                      
                      if (!periodos.esVacio()) {
                          int j = 0;
                          //for (int j = 0; j < cantPeriodos; j++) {  //para(3) j - periodos
                              Long oidPeriodo = bigDecimalToLong(periodos.getValueAt(j, "OID"));
                              
                              //Obtenemos la Unidad Administrativa del Cliente 
                              MONClientes clientes = this.getMONClientes();
                              DTOUnidadAdministrativa respuestaUA = null;
                              try {
                                  respuestaUA = clientes.obtenerUAActiva(oidCliente, oidPeriodo);
                                  UtilidadesLog.debug("cargarVentasINC ----> unidad administrativa " + respuestaUA);
                              } catch (RemoteException re) {
                                  UtilidadesLog.error(re);
                                  String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                                  throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                              }
                              
                              if (respuestaUA != null) { // respuesta no esta vacia (4)
                                  RecordSet concursoUA = null;
                                  Boolean ambitoGeoCompleto = bigDecimalToBoolean(concursos.getValueAt(k, "AMBITOGEOCOMP"));
                                  
                                  // Modificado por SiCC20070528 - Rafael Romero - 19/12/2007
                                  // Se imlpementa similar a la validacion que se hace por el motor de reglas.
                                  
                                  if ( ambitoGeoCompleto.equals(Boolean.TRUE) ) {
                                      generaPuntos = true;
                                      UtilidadesLog.debug("cargarVentasINC ----> Concurso de ambito geografico completo. No valida nada.");
                                  } else {
                                      if(!dao.existenUAsPorConcurso(oidConcurso)){
                                          generaPuntos = true;
                                          UtilidadesLog.debug("cargarVentasINC ----> NO ES concurso de ambito geografico completo. No hay UAs asignadas. No valida nada.");
                                      }else{
                                          concursoUA = dao.obtenerConcursoPorUA(respuestaUA, oidConcurso);
                                          UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'concursoUA' " + concursoUA);
                                          if ( !concursoUA.esVacio() )  { // El cliente está dentro del ambito geografico del concurso 
                                              generaPuntos = true;
                                              UtilidadesLog.debug("cargarVentasINC ----> Cliente en ambito geografico del concurso.");
                                          } else {
                                              generaPuntos = false;
                                              UtilidadesLog.debug(" El cliente NO está dentro del ambito geografico del concurso.");
                                              continue;
                                          }
                                      }
                                  }
                                  // Fin modificacion SICC20070528
                                  
                              } else { // respuesta esta vacia (4)
                                  generaPuntos = false;
                                  UtilidadesLog.debug("respuestaUA == null (no se recupero Unidad Administrativa para el cliente y periodo)");
                                  continue;
                              }
                              
                              RecordSet participante = null;
                              Boolean participanteCompleto = bigDecimalToBoolean(concursos.getValueAt(k, "PARTICIPANTESCOMPLETO"));
                              
                              if ( participanteCompleto.equals(Boolean.FALSE) ) {
                                  participante = dao.obtenerTipoParticipante(oidCliente, oidConcurso);
                                  UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'participante' " + participante);
                              }
                                    
                              if ( (participanteCompleto.equals(Boolean.TRUE)) || (!participante.esVacio()) ) {  // El tipo de Participante esta en el ambito del concurso
                                  generaPuntos = true;
                              } else {
                                  generaPuntos = false;
                                  UtilidadesLog.debug(" El tipo de Participante NO esta en el ambito del concurso. Vamos al proximo Concurso.");
                                  // Modificado por SICC20070528 - Rafael Romero - 17/12/2007
                                  //break;
                                  continue;
                                  // Fin modificado SICC20070528 - Rafael Romero - 17/12/2007
                              }
                              
                              //Obtenemos la próxima fecha de Facturación para el pais, marca, canal y zona del concurso
                              RecordSet fechaFactu =  dao.obtenerProximaFechaFacturacion(oidConcurso, respuestaUA.getOidZona());  // (5)
                              UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'fechaFactu' " + fechaFactu);
                              Long periProximaFechaFact = null;
                              Date fechaFin = null;
                              Date fechaIni = null;
                              if (fechaFactu != null && !fechaFactu.esVacio()) {
                                  //fechaFin = bigDecimalToDate(fechaFactu.getValueAt(0, "FECHAFINAL"));
                                  //fechaIni = bigDecimalToDate(fechaFactu.getValueAt(0, "FECHAINICIO"));
                                  periProximaFechaFact = bigDecimalToLong(fechaFactu.getValueAt(0, "PERIODO"));
                              } else {
                                  UtilidadesLog.debug(" no se puede validar estatus pues NO hay PERIODO CALCULADO (de la proxima fecha de facturacion)");
                                  continue;
                              }
                          
                              RecordSet fechaEsta = dao.obtenerFechasEstatus(oidConcurso); // (6)
                              UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'fechaEsta' "+ fechaEsta);
                              
                              Boolean estatusValido = Boolean.FALSE;
                                
                              if (!fechaEsta.esVacio()) {
                                  int cantFechasEstatus = fechaEsta.getRowCount();
                                  for (int m = 0; m < cantFechasEstatus; m++) {  //para(7) m - Estatus de Venta
                                      Long estado = null; 
                                      if (estatusValido.equals(Boolean.FALSE)) {
                                      
                                         //DBLG400001108
                                         //Los periodos a comparar son aquellos que estan incluidos en el rango de fechas de cada
                                         //uno de los registros obtenidos con anterioridad, por lo que ahora se obtienen.
                                          DTOSalida periodosEnRango;
                                          try{
                                            dtoP.setFechaInicio(new java.sql.Date(((Date)fechaEsta.getValueAt(m, "FECHAINIDESDE")).getTime()));
                                            dtoP.setFechaFin(new java.sql.Date(((Date)fechaEsta.getValueAt(m, "FECHAFINHASTA")).getTime()));
                                            periodosEnRango = monPeriodos.obtenerPeriodosEntreFechas(dtoP);
                                          } catch (RemoteException re) {
                                            UtilidadesLog.error(re);
                                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                                            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                                          }
                                          RecordSet rsPeriodosEnRango = periodosEnRango.getResultado();
                                          
                                          if(rsPeriodosEnRango.esVacio()){
                                             String error = "No se encontraron periodos en el rango de fechas: "+dtoP.getFechaInicio()+"--"+dtoP.getFechaFin();
                                             UtilidadesLog.debug(error);
                                             throw new MareException(error);
                                          }
                                          
                                          int largoPeriodos = rsPeriodosEnRango.getRowCount();
                                          for(int fila=0; fila < largoPeriodos;fila++){
                                              if (bigDecimalToLong(rsPeriodosEnRango.getValueAt(fila, "OID")).longValue() == periProximaFechaFact.longValue()) {
                                                  estado = bigDecimalToLong(fechaEsta.getValueAt(m, "ESTATUSFUTURO"));
                                              } else {
                                                  estado = bigDecimalToLong(fechaEsta.getValueAt(m, "ESTATUS"));
                                              }
                                              //las fechas que se pasan para evaluar el historico deben ser las fechas
                                              //del periodo que estoy evaluando, y no las del periodo de calculo que se
                                              //ha obtenido mas arriba (Gacevedo).-
                                              fechaIni = (Date)rsPeriodosEnRango.getValueAt(fila, "FECHAINICIO");
                                              fechaFin = (Date)rsPeriodosEnRango.getValueAt(fila, "FECHAFINAL");
                                              RecordSet historico = dao.obtenerHistoricoEstatus(estado, oidConcurso, oidCliente, fechaIni, fechaFin);
                                              UtilidadesLog.debug("cargarVentasINC ----> RecordSet 'historico' " + historico);
                                        
                                              if (!historico.esVacio()) {
                                                  estatusValido = Boolean.TRUE;
                                                  break; // Salimos de para(7) m
                                              } 
                                          }
                                      }else {
                                          break;
                                      }
                                  } //FIN para(7) m
                              } else {
                                  estatusValido = Boolean.TRUE;
                              }
                              
                              UtilidadesLog.debug(" El estatus de venta del cliente es valido? Rta: " + estatusValido);
                              if(estatusValido.equals(Boolean.TRUE)) {
                                  generaPuntos = true;
                              } else {
                                  generaPuntos = false;
                                  UtilidadesLog.debug(" Vamos al proximo Periodo");
                                  continue;
                              }
                              
                              
                              if (generaPuntos == true) { //Obtenemos el puntaje para el concurso (8)
                                  ObtencionPuntosLocal puntos = null;
                                  UtilidadesLog.debug(" SE DEBE ASIGNAR PUNTAJE... Buscamos para asignar puntaje...");
                                  try {
                                      puntos = this.getObtencionPuntosLocalHome().findByUK(oidConcurso);	
                                      UtilidadesLog.debug(" Encontramos en  getObtencionPuntosLocalHome().findByUK " + puntos.getOid());
                                  } catch (NoResultException f) {
                                      UtilidadesLog.error(f);
                                      String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                      throw new MareException(f, UtilidadesError.armarCodigoError(codigoError));
                                  }  catch (PersistenceException ce) {   
                                      UtilidadesLog.error("ERROR ", ce);
                                      throw new MareException(ce, 
                                      UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                  }
                                  BigDecimal factorConversion = puntos.getFactorConversion();
                                  Integer puntosAAsignar = puntos.getNumPuntosAsignados();
                                  
                                  
                                  //Actualizamos Entidades INC:CuentaCorrientePuntos, INT:RecepcionVentasAsociadas
                                  UtilidadesLog.debug("... se va a actualizar INT RecepcionVentasAsociadas");
                                  RecepcionVentasAsociadasLocal recepcionVentas = null;
                                  Long oidRecepcionVenta = bigDecimalToLong(rs.getValueAt(i, "OID"));
                                  try {
                                      recepcionVentas = this.getRecepcionVentasAsociadasLocalHome().findByPrimaryKey(oidRecepcionVenta);	
                                      UtilidadesLog.debug(" Encontramos en  getRecepcionVentasAsociadasLocalHome().findByPrimaryKey() " + recepcionVentas.getOid());
                                  } catch (NoResultException f) {
                                      UtilidadesLog.error(f);
                                      String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                      throw new MareException(f, UtilidadesError.armarCodigoError(codigoError));
                                  }  catch (PersistenceException ce) {
                                       UtilidadesLog.error("ERROR ", ce);
                                       throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                  }
                                  
                                  recepcionVentas.setIndGeneroPuntos(new Boolean(true));
                                  BigDecimal importe = recepcionVentas.getImporteVentaInternet();
                                  recepcionVentas.setNumeroPunto(new Long(importe.longValue() / factorConversion.longValue() * puntosAAsignar.longValue()));
                                  this.getRecepcionVentasAsociadasLocalHome().merge(recepcionVentas);
                                  
                                  UtilidadesLog.debug("... se va a actualizar INC CuentaCorrientePuntos (Antes de hacer el Create)");
                                  CuentaCorrientePuntosLocal cuentas = null;
                                  
                                  UtilidadesLog.debug(" cliente "+ oidCliente);
                                  UtilidadesLog.debug(" concurso "+ oidConcurso);
                                  UtilidadesLog.debug(" recepcionVentas.getFechaOrdenInternet() "+ recepcionVentas.getFechaOrdenInternet()); 
                                  UtilidadesLog.debug(" recepcionVentas.getNumeroPunto().toString() " + recepcionVentas.getNumeroPunto().toString());
                                  
                                  try {
                                      cuentas = this.getCuentaCorrientePuntosLocalHome().create(new Integer(recepcionVentas.getNumeroPunto().toString()),
                                                                                            new Integer(0),
                                                                                            recepcionVentas.getFechaOrdenInternet(),
                                                                                            oidConcurso,
                                                                                            oidCliente,
                                                                                            //Cleal
                                                                                            //periodoFactu,
                                                                                            bigDecimalToLong(periodos.getValueAt(j,"OID")),
                                                                                            ConstantesINC.TIPO_MOVIMIENTO_ABONO);
                                      //Introducir descripcion internacionalizable.
                                      RecordSet codClienteTraduc = dao.traducirCodigoCliente(recepcionVentas.getIdentEnPlataformaIn());
                                      String codigoDeCliente = "";
                                      if (codClienteTraduc!=null && !codClienteTraduc.esVacio()) {
                                          codigoDeCliente = codClienteTraduc.getValueAt(0,"COD_CLIE").toString();
                                      }                                
                                      String descripcion = ConstantesINC.PUNTOS_VENTA_ECM + "" + codigoDeCliente;
                                      UtilidadesLog.debug(" descripcion internacionalizable " + descripcion);
                                      //  Modificacion por Inc. BELC300022987 alorenzo 12/04/2006
                                      cuentas.setVal_desc(descripcion);
                                      this.getCuentaCorrientePuntosLocalHome().merge(cuentas);
                                
                                  } catch (PersistenceException c) {
                                      ctx.setRollbackOnly();
                                      UtilidadesLog.error(c);
                                      throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                  }
                              }  //fin if (generaPuntos == true) {  (8)
                          //} //FIN para(3) j
					            }     //fin if(!periodos.esVacio()) {
					        } //FIN para(2) k
				      }     //fin if (!concursos.esVacio()) {
			    } //FIN para(1) i
      }     //fin if (!rs.esVacio()) {
      UtilidadesLog.info("MONECMBean.cargarVentasINC(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch(0, "MONECM.cargarVentasINC ejecutado");
	}

	public DTOSalidaBatch cargarVentasINT(DTOBatch dtoBatch) throws MareException
	{
        UtilidadesLog.info("MONECMBean.cargarVentasINT(DTOBatch dtoBatch): Entrada");
		
		DTOINT dto  = (DTOINT) dtoBatch.getDTOOnline();
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		DTOECMRecibir dtoE = new DTOECMRecibir();
		dtoE.setDescripcion(dto.getDescripcionLote());
		dtoE.setNumLote(dto.getNumeroLote().toString());
		dtoE.setObservaciones(dto.getObservaciones());
		dtoE.setOidIdioma(dto.getOidIdioma());
		dtoE.setOidPais(dto.getOidPais());
		UtilidadesLog.debug("DTO DTOECMRecibir: "+dtoE);
		//Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
		//handle de la interfaz que se va a procesar 
		InterfazInfo info = new InterfazInfo( IGestorInterfaces.COD_INTERFAZ_ECM1, 
											dtoE.getNumLote(), 
											dtoE.getOidPais() );
		//Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
		info.setDescripcionLote(dtoE.getDescripcion());
		info.setObservaciones(dtoE.getObservaciones());
		
		IRegistroSicc registro = null;
		InterfazInfo interfazInfo = null;
		
		try{
			 interfazInfo = gi.importarInterfaz(info);
             UtilidadesLog.debug("cargarVentasINT--->dto.getDescripcionLote() " +dto.getDescripcionLote());
             UtilidadesLog.debug("cargarVentasINT--->dto.getObservaciones()" +dto.getObservaciones());
             interfazInfo.setDescripcionLote(dto.getDescripcionLote());
             interfazInfo.setObservaciones(dto.getObservaciones());
             
		}catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
		}catch(RemoteException re){
			UtilidadesLog.error(re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}		
		
		try{
			while ((registro = gi.cargarRegistro(interfazInfo)) != null){
				
				String codigoPais = (String)registro.obtenerCampo(IECM.ECM1_CODIGO_PAIS);
                 UtilidadesLog.debug("cargarVentasINT-->pais :  "+(String)registro.obtenerCampo(IECM.ECM1_CODIGO_PAIS));
				//Si viene codigo de pais, lo traducimos por su oid generando un error en caso de que no se encuentre.
				PaisLocal pais = null;
				try{
					pais = this.getPaisLocalHome().findByUk(codigoPais);
				
					Long oidPais = pais.getOid();
				
					//comprobamos que existe el canal que viene en la interfaz 
					CanalLocal canal = null;
					String codCanal = (String)registro.obtenerCampo(IECM.ECM1_CODIGO_CANAL);
                                        UtilidadesLog.debug("cargarVentasINT-->codCanal :  "+codCanal);
					try{
						canal = this.getCanalLocalHome().findByUK(codCanal);
						
						//comprobamos que existe la sociedad que viene en la interfaz 
						String codSoci = (String)registro.obtenerCampo(IECM.ECM1_CODIGO_SOCIEDAD);
                                                UtilidadesLog.debug("cargarVentasINT-->codSoci :  "+codSoci);
						EmpresaLocal sociedad = null;
						try{
							sociedad = this.getEmpresaLocalHome().findByUK(codSoci);
                            
							
							//comprobamos que el codigo de cliente correspondiente a la consultora, existe 
							ClienteDatosBasicosLocal cliente = null;
							String clien = (String)registro.obtenerCampo(IECM.ECM1_CODIGO_CONSULTORA);
                                                        UtilidadesLog.debug("cargarVentasINT-->ECM1_CODIGO_CONSULTORA :  "+clien);
							try{
								cliente = this.getClienteDatosBasicosLocalHome().findByUK(oidPais,clien);
								 UtilidadesLog.debug("cargarVentasINT-->Cliente que metemos en BDD :  "+cliente.getOid());
                                                                UtilidadesLog.debug("cargarVentasINT-->CANal que metemos en BDD :  "+canal.getOid());
                               
								MarcaLocal marca = null;
								String codMarca = (String)registro.obtenerCampo(IECM.ECM1_CODIGO_MARCA);
                                                                UtilidadesLog.debug("cargarVentasINT-->ECM1_CODIGO_MARCA :  "+codMarca);
								try{
									marca = this.getMarcaLocalHome().findByUK(codMarca);
                                    UtilidadesLog.debug("cargarVentasINT-->marca que metemos en BDD :  "+marca.getOid());
                                    UtilidadesLog.debug("cargarVentasINT-->fecha que metemos en BDD :  "+(Date)registro.obtenerCampo(IECM.ECM1_FECHA_INTERNET));
									
                                     // Al create de BPS
                                           ArrayList array= new ArrayList();
                                           array.add((Date)registro.obtenerCampo(IECM.ECM1_FECHA_INTERNET));
                                           array.add(cliente.getOid());
                                           array.add(marca.getOid());
                                           array.add(sociedad.getOid());
                                           array.add((Float)registro.obtenerCampo(IECM.ECM1_IMPORTE_VENTA_INTERNET));
                                           array.add((Float)registro.obtenerCampo(IECM.ECM1_IMPORTE_ABONO_CONSULTORA));
                                           array.add((Long)registro.obtenerCampo(IECM.ECM1_ID_CLIENTE_INTERNET));
                                           array.add(canal.getOid());
                                           UtilidadesLog.debug("Llamamos al metodo del REALIZARCREATE");
                                           MONECM monECM = this.getMONECM();
                                           try{
                                                    monECM.realizarCreate(dto,array,interfazInfo,gi);
                                           }catch(Exception e){
                                                UtilidadesLog.error(e);
                                            }
                                    
								}catch(NoResultException f){
									try{
										DTOINTError dtoError = new DTOINTError(info,registro,"No existe Marca "+(String)registro.obtenerCampo(IECM.ECM1_CODIGO_MARCA)+"para el Pais"+ codigoPais);
										//UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "",
										//ErroresDeNegocio.INT_0004)+ "" +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_MARCA)+"para el Pais"+ codigoPais);
										gi.registrarError(dtoError);
										continue;
									}catch(InterfacesException ie){
										UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
									}catch(RemoteException ne){										
										UtilidadesLog.error(ne);
										throw new MareException(ne,
										UtilidadesError.armarCodigoError(
										CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
									}
                                                                }  catch (PersistenceException ce) {   
                                                                    UtilidadesLog.error("ERROR ", ce);
                                                                    throw new MareException(ce, 
                                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
								}
							
							}catch(NoResultException f){
								try{
								DTOINTError dtoError = new DTOINTError(info,registro,"No existe Consultora con el codigo "+(String)registro.obtenerCampo(IECM.ECM1_CODIGO_CONSULTORA)+" para el pais " + codigoPais);
								//UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "",
								//ErroresDeNegocio.INT_0036)+ "" +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_CONSULTORA)+"para el Pais"+ codigoPais);
								gi.registrarError(dtoError);
								continue;
                                                        }  catch (PersistenceException ce) {   
                                                            UtilidadesLog.error("ERROR ", ce);
                                                            throw new MareException(ce, 
                                                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
							}catch(InterfacesException ie){
								UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
							}catch(RemoteException ne){								
								UtilidadesLog.error(ne);
								throw new MareException(ne,
									UtilidadesError.armarCodigoError(
									CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
							}
							}
						
						}catch(NoResultException f){
							try{
								DTOINTError dtoError = new DTOINTError(info,registro,
                                " No existe Empresa con el codigo "+(String)registro.obtenerCampo(IECM.ECM1_CODIGO_SOCIEDAD)+" para el pais "+codigoPais );
								//UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "",
								//ErroresDeNegocio.INT_0015)+ "" +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_SOCIEDAD)+"para el Pais"+ codigoPais);
								gi.registrarError(dtoError);
								continue;
							}catch(InterfacesException ie){
								UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
							}catch(RemoteException ne){								
								UtilidadesLog.error(ne);
								throw new MareException(ne,
									UtilidadesError.armarCodigoError(
									CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
							}
                                                }  catch (PersistenceException ce) {   
                                                    UtilidadesLog.error("ERROR ", ce);
                                                    throw new MareException(ce, 
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
						}
					}catch(NoResultException f){
						try{
							DTOINTError dtoError = new DTOINTError(info,registro,"No existe Canal con el codigo "+(String)registro.obtenerCampo(IECM.ECM1_CODIGO_CANAL)+ "para el pais"+ codigoPais);
							//UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "",
							//ErroresDeNegocio.INT_0035)+ "" +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_CANAL)+"para el Pais"+ codigoPais);
							gi.registrarError(dtoError);
							continue;
						}catch(InterfacesException ie){
							UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
						}catch(RemoteException ne){							
							UtilidadesLog.error(ne);
							throw new MareException(ne,
								UtilidadesError.armarCodigoError(
								CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
						}
                                        }  catch (PersistenceException ce) {   
                                            UtilidadesLog.error("ERROR ", ce);
                                            throw new MareException(ce, 
                                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
					}
				}catch(NoResultException f){
					try{
                        DTOINTError dtoError = new DTOINTError(info,registro, "No existe pais con el codigo " +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_PAIS) );
                        //UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT, "",
                       // ErroresDeNegocio.INT_0003)+ "" +(String)registro.obtenerCampo(IECM.ECM1_CODIGO_PAIS));
                        gi.registrarError(dtoError);
                        continue;
                    }catch(InterfacesException ie){
                        UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                    }catch(RemoteException ne){                        
                        UtilidadesLog.error(ne);
                        throw new MareException(ne,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                                }  catch (PersistenceException ce) {   
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}
			}
		}catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
		}catch(RemoteException re){
			UtilidadesLog.error(re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}
                
        // sapaza -- PROCESO ACO -- 25/02/2015       
         if(dto.getNombreArchivo() == null) {  //Si es null, es invocado de la pantalla de SICC    
            UtilidadesLog.debug("cargarVentasINT  ---> LLLAMOA  CARGAR VENTAS  PED EN MODO BATCH ");
               dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en PED",new MareBusinessID("INTCargarVentasAsociadasPED"),dto);
            try {
                BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
            }catch(RemoteException re){
                    UtilidadesLog.error(re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
            }
       
              UtilidadesLog.debug("cargarVentasINT --->Idioma " + dto.getOidIdioma());
              dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en INC", new MareBusinessID( "INTCargarVentasAsociadasINC" ),dto);        
            try {
                BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
            }catch(RemoteException re){
                    UtilidadesLog.error(re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
            }
         }
        
        //this.cargarVentasPED(dtoBatch);
        UtilidadesLog.info("MONECMBean.cargarVentasINT(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0,"MONECM.cargarVentasINT ejecutado");
	}

	public DTOSalidaBatch recibirVentasAsociadas(DTOINT dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.recibirVentasAsociadas(DTOINT dto): Entrada");
        DTOBatch dtoBatch = null;
        
        //Encolado en Batch de "Cargar Ventas Asociadas en INT"
        dtoBatch = new DTOBatch("Cargar Ventas Asociadas en INT",new MareBusinessID("INTCargarVentasAsociadasINT"),dto);
        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        }catch(RemoteException re){
                UtilidadesLog.error(re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }                

        //Encolado en Batch de "Cargar Ventas Asociadas en INC"
     /*   dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en INC", new MareBusinessID( "INTCargarVentasAsociadasINC" ),dto);        
        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        */
        /*BELC300017730    
        //Encolado en Batch de "Cargar Ventas Asociadas en PED"
        dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en PED",new MareBusinessID("INTCargarVentasAsociadasPED"),dto);
        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
*/
        UtilidadesLog.info("MONECMBean.recibirVentasAsociadas(DTOINT dto): Salida");
        return new DTOSalidaBatch( 0, "Recibir Ventas Asociadas a Consultoras finalizado");
	}

	public DTOSalidaBatch recibirClientesBatch(DTOINT dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.recibirClientesBatch(DTOINT dto): Entrada");
        /*
        String mensaje 
        
        // Se invoca al caso de uso "Recepción de Clientes", en modo batch 
        DTOBatch dtoBatch = new DTOBatch( nombre = "Recepcion de Clientes", 
        IDOnline = "ECMRecibirClientes", 
        DTOOnline = dtoe ) 
        
        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 
        
        mensaje += "Recepcionar Clientes Batch ejecutado - " 
        }*/
                
        DTOBatch dtoBatch = new DTOBatch("Recepcion de Clientes", new MareBusinessID("ECMRecibirClientes"),dto);        
        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        }catch(RemoteException re){
                UtilidadesLog.error(re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }		
        
        UtilidadesLog.info("MONECMBean.recibirClientesBatch(DTOINT dto): Salida");
        return new DTOSalidaBatch( 0, "Recepcionar Clientes Batch ejecutado");
	}
	public DTOSalidaBatch recibirClientes(DTOBatch dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.recibirClientes(DTOBatch dto): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        DTOINT dtoE = (DTOINT)dto.getDTOOnline();
        // Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
        // handle de la interfaz que se va a procesar 
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_ECM2,dtoE.getNumeroLote().toString(),dtoE.getOidPais());
        UtilidadesLog.debug("info: " + info);
        //Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
        info.setDescripcionLote(dtoE.getDescripcionLote());
        info.setObservaciones(dtoE.getObservaciones());
         UtilidadesLog.debug("info: " + info);
        //Creamos un objeto IRegistroSicc, con la informacion recibida de la interfaz 
        InterfazInfo interfaz = null;
		IRegistroSicc registro = null;
        try{
           interfaz = gi.importarInterfaz(info);
           interfaz.setDescripcionLote(dtoE.getDescripcionLote());
           interfaz.setObservaciones(dtoE.getObservaciones());
        }catch(InterfacesException iex){
            UtilidadesLog.debug("Error InterfacesException: "+iex.getMotivo());
        }catch(RemoteException re){
                UtilidadesLog.error(re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        try{
			while ((registro = gi.cargarRegistro(interfaz)) != null){
				/*------ Llamamos al CU Tratar Registro de Clientes -------*/ 
                getMONECMLocalHome().create().tratarRegistroClientes(registro,info);
			}
		}catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        }catch(RemoteException ne){
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(Exception e){
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONECMBean.recibirClientes(DTOBatch dto): Salida");
		return new DTOSalidaBatch(0, "TratarFichero de Clientes ejecutado -");
	}

	public DTOSalidaBatch enviarClientesConsultoraBatch(DTOINT dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.enviarClientesConsultoraBatch(DTOINT dto): Entrada");
        /* Se invoca al caso de uso "Enviar ClientesConsultoras", en modo batch 
        DTOBatch dtoBatch = new DTOBatch( nombre = "Enviar Clientes Consultora",
        IDOnline = "ECMEnviarClientesConsultora",
        DTOOnline = dtoe );*/
    
        DTOBatch dtoBatch = new DTOBatch( "Enviar ClientesConsultoras", new MareBusinessID( "ECMEnviarClientesConsultoras" ),dto);        
        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        }catch(RemoteException re){
                UtilidadesLog.error(re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        UtilidadesLog.info("MONECMBean.enviarClientesConsultoraBatch(DTOINT dto): Salida");
        //Modificado por incidencia HAY QUE PONERLA Este método debe devolver DTOSalidaBatch
        return new DTOSalidaBatch( 0, "Enviar Clientes Consultora ejecutado");
	}

	public DTOSalidaBatch enviarClientesConsultora(DTOBatch dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.enviarClientesConsultora(DTOBatch dto): Entrada");
		
		DTOINT dtoE = (DTOINT)dto.getDTOOnline();
		
        DAOINT dao = new DAOINT();
		
        // Se cambia la llamada a obtener fecha ultima ejecucion porque existe un
        // problema en MARE con el formateo de fecha. INCIDENCIA 17531
        //DAOECM dao = new DAOECM();
        //RecordSet fecha = dao.obtenerFechaUltimaEjecucion(dtoE.getOidPais(),IGestorInterfaces.COD_INTERFAZ_ECM3);
        /*
		Date fechaEjecucion = null;
		if(!fecha.esVacio()){
			fechaEjecucion =(Date)fecha.getValueAt(0,"ULTIMAFECHA");
		}else{
			fechaEjecucion = null;
		}
        */
    UtilidadesLog.info("IGestorInterfaces.COD_INTERFAZ_ECM3 " + IGestorInterfaces.COD_INTERFAZ_ECM3);    
		Date fechaEjecucion = dao.obtenerUltimaFecha(dtoE.getOidPais(),IGestorInterfaces.COD_INTERFAZ_ECM3,null);
    UtilidadesLog.info("PablofechaEjecucion ---- " + fechaEjecucion);    
		
		String mensaje = null;
		DTOECMRecibir DTOE = new DTOECMRecibir();
		DTOE.setObservaciones(dtoE.getObservaciones());
		DTOE.setDescripcion(dtoE.getDescripcionLote());
		DTOE.setNumLote(dtoE.getNumeroLote().toString());
		DTOE.setOidIdioma(dtoE.getOidIdioma());
		DTOE.setOidPais(dtoE.getOidPais());
		
		this.generarClientesConsultoras(fechaEjecucion,IGestorInterfaces.COD_INTERFAZ_ECM3,DTOE);
		
		mensaje += "Enviar Clientes Consultoras ejecutado - "; 
		
        UtilidadesLog.info("MONECMBean.enviarClientesConsultora(DTOBatch dto): Salida");
		return new DTOSalidaBatch( 0, mensaje );
	}

	public DTOSalidaBatch recibirVentasSistemaBatch(DTOINT dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.recibirVentasSistemaBatch(DTOINT dto): Entrada");		
		String mensaje = null;
		IMareDTO  DTOOnline = dto;
     
		MareBusinessID IDOnline =  new MareBusinessID("ECMRecibirVentasSistema");

		
		// Se invoca al caso de uso "Recbir por Sistema Ventas Asociadas a Consultoras", en modo batch 
		DTOBatch dtoBatch = new DTOBatch("Recbir por Sistema Ventas Asociadas a Consultoras", 
										IDOnline, 
										DTOOnline); 
		
		try{							
			BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ); 
		}catch(RemoteException re){
			UtilidadesLog.error(re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}

		mensaje += "Recibir por Sistema Ventas Asociadas a Consultoras Batch ejecutado - ";

        UtilidadesLog.info("MONECMBean.recibirVentasSistemaBatch(DTOINT dto): Salida");		
		return new DTOSalidaBatch(0, mensaje);
	}

	public DTOSalidaBatch recibirVentasSistema(DTOBatch dto) throws MareException
	{
        UtilidadesLog.info("MONECMBean.recibirVentasSistema(DTOBatch dto): Entrada");
		//MOdificado por BELC300017570
        
        DTOString mareDto=(DTOString)dto.getDTOOnline();
        UtilidadesLog.debug("Traza del MARETDTO que llega "+mareDto);
        
        PaisLocalHome home=this.getPaisLocalHome();
        PaisLocal local=null;

                

        try{
            local=home.findByUk(mareDto.getString("cadena"));
            UtilidadesLog.debug("Pais localizado ="+local.getOid() );
        }catch (NoResultException fe){
             UtilidadesLog.error(
                "MONINECM.recibirVentasSistema: FinderException, no existe Pais = "+mareDto.getString("cadena"), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        InterfazInfo interfaz=null;
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        try{
             interfaz=gi.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_ECM1, local.getOid());
        }catch (InterfacesException e){
            UtilidadesLog.debug(" RECIVIRVENTAS ASOCIADAS error en obtenerInterfazInfo");
            return new DTOSalidaBatch(0,"Finalizado con Error");
        }catch (RemoteException re){             
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        DTOINT dtoInt=new DTOINT();
        dtoInt.setNumeroLote(new Long(interfaz.getNumeroLote())); 
        dtoInt.setOidPais(local.getOid());
        dtoInt.setDescripcionLote(interfaz.getDescripcionLote());

        //Faltaba adicionar el idioma
        UtilidadesLog.debug("IDIOMA DESDE DEMONIO: "+mareDto.getOidIdioma());
        //dtoInt.setOidIdioma(mareDto.getOidIdioma());
        // ESTO ESTA PENDIENTE DE LA INCIDENCIA !!!!!!!!!!!!!!
        dtoInt.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
        
        UtilidadesLog.debug("recibirVentasSistema --->Numero de Lote " + interfaz.getNumeroLote());
        
         MareBusinessID mare=new MareBusinessID();
         mare.setBusinessID("INTProcesosBatch");
        
        UtilidadesLog.debug("recibirVentasSistema --->Idioma " + dtoInt.getOidIdioma() + " -- " + mareDto.getOidIdioma());
        DTOBatch dtoBatch=new DTOBatch("RecibirVentasSistema",mare, dtoInt,"CS");
        
       
        DTOSalidaBatch dtoSalidaINT= this.cargarVentasINT(dtoBatch);
        UtilidadesLog.debug("this.cargarVentasINT acabado " +dtoSalidaINT);
        //DTOSalidaBatch dtoSalidaINC= this.cargarVentasINC(dtoBatch);
       /// UtilidadesLog.debug("this.cargarVentasINC acabado "+dtoSalidaINC);
        
        
       /*  Incidencia BELC300017730    
        DTOSalidaBatch dtoSalidaPED= this.cargarVentasPED(dtoBatch);
        UtilidadesLog.debug("this.cargarVentasPED acabado "+dtoSalidaPED);
        */
       
        //MOdificado por BELC300017570
		/*DTOString dtoE = (DTOString)dto.getDTOOnline();
		//DTOString dtoE = new DTOString();
		dtoE.setCadena(IGestorInterfaces.COD_INTERFAZ_ECM1);
		//dtoE.setOidIdioma();
		//dtoE.setOidPais();
		
		MONINT in = this.getMONINT();
		DTOCargaInicialInterfaz dtoInt = null;
		try{
			dtoInt = in.cargaInicial(dtoE);
		}catch(RemoteException ne){			
			UtilidadesLog.error("error RemoteException en MONECM.tratarRegistroClientes");
            throw new MareException(ne,
					UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		
		DTOINT dtoI = new DTOINT();
		dtoI.setNumeroLote(dtoInt.getNumeroLote());
		dtoI.setDescripcionLote(dtoInt.getDescripcion());*/
		/*
		DTOECMRecibir dtoE = (DTOECMRecibir)dto.getDTOOnline();
		
		IMareDTO  DTOOnline = dtoE;
		
		DTOBatch dtoBatch = new DTOBatch("Cargar Ventas Asociadas en INT",
								new MareBusinessID( "INTCaragarVentasAsociadasINT" ), 
								DTOOnline); 
		try{
			BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
		}catch(RemoteException re){
			UtilidadesLog.error("*** Error MONECM.recibirVentasSistemaBach", re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}
		
		dtoBatch = new DTOBatch("Cargar Ventas Asociadas en INC",
								new MareBusinessID( "INTCaragarVentasAsociadasINC" ), 
								DTOOnline); 
		try{
			BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
		}catch(RemoteException re){
			UtilidadesLog.error("*** Error MONECM.recibirVentasSistemaBach", re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}
		
		dtoBatch = new DTOBatch("Cargar Ventas Asociadas en PED",
								new MareBusinessID( "INTCaragarVentasAsociadasPED" ), 
								DTOOnline); 
		try{
			BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
		}catch(RemoteException re){
			UtilidadesLog.error("*** Error MONECM.recibirVentasSistemaBach", re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.debug("***MONECM.recibirVentasSistema - Salida");
        *///MOdificado por BELC300017570
        UtilidadesLog.info("MONECMBean.recibirVentasSistema(DTOBatch dto): Salida");
		return new DTOSalidaBatch( 0, "RecibirSistemaVentas Asociadas a Consultoras finalizado" );
	}

    /**
     * Modificado por HRCS - Fecha 05/09/2007 - Cambio Sicc20070385
     * Se restructura todo el metodo
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param info
     * @param registro
     */
	public DTOSalidaBatch tratarRegistroClientes(IRegistroSicc registro, InterfazInfo info) throws MareException
	{
        UtilidadesLog.info("MONECMBean.tratarRegistroClientes(IRegistroSicc registro, InterfazInfo info): Entrada");
        DTOSalidaBatch dtoBatch = null;
        DTORegistroECM2 valoresInterfaz;
        
        try {
            MONGestorInterfaces gi = this.getMONGestorInterfaces();
            DAOECM daoECM = new DAOECM();
            
            //  Variables Locales
            //
            Long oidTipoDocumento = null;
            RecordSet rsIdentificacionCliente = null;
            String numeroDocumento=null;
            Long oidCliente=null;
            Long oidTipoCliente=null;
            Long oidSubtipoCliente=null;
            Long oidClienteTipoSubTipo=null;
            String codigoCliente = null;
            Long oidMarca = null;
            Long oidCanal = null;
            
            //  Obtenemos el tipo de cliente del registro tratado
            //
            TipoClienteLocal tipoClient = null;
            String tipoClien = (String)registro.obtenerCampo(IECM.ECM2_TIPO_CLIENTE);
            try{
                tipoClient = this.getTipoClienteLocalHome().findByUK(tipoClien);	
            }catch(NoResultException f){
                DTOINTError dtoError = new DTOINTError(info,registro,ErroresDeNegocio.INT_0046 + " " + tipoClien);
                try{
                    gi.registrarError(dtoError);
                    //return null;
                    throw new ECM2Exception( ErroresDeNegocio.INT_0046 + " " + tipoClien, null );
                }catch(InterfacesException ie){
                    UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                }catch(RemoteException ne){
                    UtilidadesLog.debug(ne);
                    throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            oidTipoCliente = tipoClient.getOid();
            
            //  Obtenemos el pais del registro tratado
            //
            PaisLocal pais = null;
            String campoPais = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_PAIS);
            try{
                pais = this.getPaisLocalHome().findByUk(campoPais);
            }catch(NoResultException fex){
                DTOINTError dtoError = new DTOINTError(info,registro,ErroresDeNegocio.INT_0003 + " " + campoPais);
                try{
                    gi.registrarError(dtoError);
                    throw new ECM2Exception( ErroresDeNegocio.INT_0003 + " " + campoPais, null );
                    //return null;
                }catch(InterfacesException ie){
                    UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                }catch(RemoteException ne){UtilidadesLog.error(ne);
                    throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    
            //  Obtiene el subtipo de cliente del registro tratado
            //
            SubtipoClienteLocalHome subTipoClienteHome = this.getSubtipoClienteLocalHome();
            SubtipoClienteLocal subTipoCliente = null;
            String campoSubTipoCliente = (String)registro.obtenerCampo(IECM.ECM2_SUBTIPO_CLIENTE);
            try{
                subTipoCliente = subTipoClienteHome.findByUK(campoSubTipoCliente,oidTipoCliente);
            }catch(NoResultException fex){
                DTOINTError dtoError = new DTOINTError(info,registro,ErroresDeNegocio.INT_0041 + " " + campoSubTipoCliente);
                try{
                    gi.registrarError(dtoError);
                    throw new ECM2Exception( ErroresDeNegocio.INT_0041 + " " + campoSubTipoCliente, null );
                    //return null;
                }catch(InterfacesException ie){
                    UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                }catch(RemoteException ne){                
                    UtilidadesLog.error(ne);
                    throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            oidSubtipoCliente = subTipoCliente.getOid();
    
            // 1. Comprobamos los campos obligatorios
            // Primero obtenemos los valores que llegan en el interfaz 
            //
            valoresInterfaz = this.obtenerValoresInterfaz(registro,info,subTipoCliente.getOid(),pais.getOid());
            UtilidadesLog.info("*** valoresInterfaz: "+valoresInterfaz);
            
            // 3. Comprobamos que existe el tipo de Documento que viene en la interfaz
            //
            oidTipoDocumento = this.comprobarTipoDocumento(valoresInterfaz,registro,info);
            if(oidTipoDocumento == null)
                return null;
    
            // 4. Comprobamos que existe la Marca que viene en la interfaz 
            //
            oidMarca = this.comprobarMarca(valoresInterfaz,registro,info);
            if(oidMarca == null)
                return null;
    
            // 5. Comprobamos que existe la Marca que viene en la interfaz 
            //
            oidCanal = this.comprobarCanal(valoresInterfaz,registro,info);
            if(oidCanal == null)
                return null;
                
            // 8. Verificar si se trata de un cliente nuevo
            // Busca si existe en MAE Identificacion un registro
            boolean esClienteNuevo = true;
            rsIdentificacionCliente = daoECM.obtenerIdentificacionCliente(pais.getOid(),oidTipoDocumento,valoresInterfaz.getNumeroDocumento());
            if (!rsIdentificacionCliente.esVacio()){
                numeroDocumento = (String)rsIdentificacionCliente.getValueAt(0,"NUM_DOCU_IDEN");
                oidCliente = new Long(((BigDecimal)rsIdentificacionCliente.getValueAt(0,"CLIE_OID_CLIE")).longValue());
                codigoCliente = (String)rsIdentificacionCliente.getValueAt(0,"COD_CLIE");
                esClienteNuevo = false;
            }
    
            // 9. Crear Codigo de Cliente. Si el cliente es NUEVO
            //
            if (esClienteNuevo) {
                MONClientes maestroClientes = this.getMONClientes();
                DTOBelcorp dto = new DTOBelcorp();
                dto.setOidPais(pais.getOid());
                dto.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                DTOGenerarCodigoCliente dtos;
                try{
                    dtos=maestroClientes.generaCodigoCliente(dto);  // obtenemos el código del cliente en función del pais 
                }catch(RemoteException re){
                    UtilidadesLog.error(re);
                    throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                codigoCliente = dtos.getCodigoCliente();
            }
                
            // 10. Creamos o actualizamos un registro en Cliente - Datos Basicos
            //
            oidCliente = this.mantenerClienteDatosBasicos( esClienteNuevo, valoresInterfaz, codigoCliente, pais.getOid());
            UtilidadesLog.debug("*** oidCliente: "+oidCliente);
            
            // 11. Creamos o actualizamos un registro en Cliente - Datos Adicionales 
            //
            this.mantenerClienteDatosAdicionales( esClienteNuevo, valoresInterfaz, oidCliente, pais.getOid());
            
            // 12. Creamos un registro con la relacion Cliente - Identificacion 
            //
            if (esClienteNuevo) {
                this.crearClienteIdentificacion( oidCliente, oidTipoDocumento, valoresInterfaz.getNumeroDocumento());
            }
            
            // 13. Creamos o actualizamos un registro con la relacion Cliente - Subtipo de Cliente
            // Verificamos si ya tiene un registro con la relacion Cliente - Subtipo de Cliente
            //
            oidClienteTipoSubTipo = this.mantenerClienteTipoSubtipo( esClienteNuevo, oidCliente, oidTipoCliente, oidSubtipoCliente);
         
            // 14. Comprobamos que el tipo de clasificacion y clasificacion existan
            // 15. Creamos si no existe la Clasificacion Cliente que viene en la interfaz 
            //
            this.mantenerClienteClasificacion( esClienteNuevo, valoresInterfaz, pais.getOid(), oidSubtipoCliente, oidCliente, oidClienteTipoSubTipo, oidMarca, oidCanal);
            
            // 16. Comprobamos via, tipo de via y ubigeo si son validos
            // 17. Grabamos el registro de direccion del cliente
            //
            this.mantenerClienteViaUbigeo( esClienteNuevo, valoresInterfaz, pais.getOid(), oidCliente);
            
            // 18. Comprueba el tipo de comunicacion
            // 19. Graba el registro en Cliente Comunicacion
            //
            this.mantenerClienteComunicacion( esClienteNuevo, valoresInterfaz, oidCliente );
            
            // 20. Comprobar y grabar Cliente Primer Contacto
            //
            this.mantenerClienteContacto( esClienteNuevo, valoresInterfaz, oidCliente, pais.getOid(), oidMarca, oidCanal);
            
            // 21. Comprobacion y validacion si es DuplaCyzone
            // 22. Creamos registro con relacion Cliente - Vinculo (y mensajes si es DuplaCyzone)
            //
            this.mantenerClienteVinculo( esClienteNuevo, valoresInterfaz, registro, info, oidCliente, pais.getOid(), oidTipoCliente, oidSubtipoCliente, oidMarca, oidCanal);
            
            // 23. Inserta en Cliente Estatus si es nuevo
            //
            if (esClienteNuevo) {
                this.insertarClienteEstatus( oidCliente, pais.getOid(), oidMarca, oidCanal );
            }

            //modificado por Sapaza, fecha 24-09-2007, cambio Sicc20070416
            // Comprobar y grabar Cliente Marca
            this.mantenerClienteMarca( esClienteNuevo, oidCliente, oidMarca);

            dtoBatch = new DTOSalidaBatch(0,"Tratar Registro de Clientes Ejecutado.");
        }
        catch(ECM2Exception ecm2)   {
        
            dtoBatch = new DTOSalidaBatch(1,"Error Registro de Clientes -" + ecm2.getMessage() );
        }
        
        UtilidadesLog.info("MONECMBean.tratarRegistroClientes(IRegistroSicc registro, InterfazInfo info): Salida");
        //return new DTOSalidaBatch(0,"Tratar Registro de Clientes Ejecutado -");
        return dtoBatch;
	}

    private DTORegistroECM2 blanquearDTORegistro(DTORegistroECM2 dtoECM2) throws MareException
    {
        UtilidadesLog.info("MONECMBean.blanquearDTORegistro(DTORegistroECM2 dtoECM2): Entrada");
        dtoECM2.setApellidoCasada("");
        dtoECM2.setApellidoMaterno("");
        dtoECM2.setApellidoPaterno("");
        dtoECM2.setApellidoCasada("");
        dtoECM2.setCargo("");
        dtoECM2.setCentroEstudios("");
        dtoECM2.setCentroTrabajo("");
        dtoECM2.setClasificacion("");
        dtoECM2.setCodigoCanalVenta("");
        dtoECM2.setCodigoCliente("");
        dtoECM2.setCodigoClienteAntiguo("");
        dtoECM2.setCodigoClienteVinculo("");
        dtoECM2.setCodigoMarca("");
        dtoECM2.setCodigoPais("");
        dtoECM2.setCodigoPaisAntiguo("");
        dtoECM2.setCodigoTipoComunicacion("");
        dtoECM2.setCodigoTipoContacto("");
        dtoECM2.setCodigoTipoVinculo("");
        dtoECM2.setEspecialidad("");
        dtoECM2.setEstadoCivil("");
        /*dtoECM2.setFechaContacto(new Date(System.currentTimeMillis()));
        dtoECM2.setFechaDesde(new Date(System.currentTimeMillis()));
        dtoECM2.setFechaHasta(new Date(System.currentTimeMillis()));
        dtoECM2.setFechaNacimiento(new Date(System.currentTimeMillis()));*/
        dtoECM2.setIndVinculoPrincipal("");
        dtoECM2.setNacionalidad("");
        dtoECM2.setNivelEstudios("");
        dtoECM2.setNombrePrimero("");
        dtoECM2.setNombreSegundo("");
        dtoECM2.setNombreVia("");
        dtoECM2.setNumeroDocumento("");
        dtoECM2.setNumeroHijos(new Long(0));
        dtoECM2.setNumeroPrincipal("0");
        dtoECM2.setOcupacion("");
        dtoECM2.setProfesion("");
        dtoECM2.setSexo("");
        dtoECM2.setSubtipoCliente("");
        dtoECM2.setTextoMedioComunicacion("");
        dtoECM2.setTipoClasificacion("");
        dtoECM2.setTipoCliente("");
        dtoECM2.setTipoDocumento("");
        dtoECM2.setTipoVia("");
        dtoECM2.setUbiGeo("");        
        UtilidadesLog.info("MONECMBean.blanquearDTORegistro(DTORegistroECM2 dtoECM2): Salida");
        return dtoECM2;
    }
    
  public void insertarActualizarCliente (DTORegistroECM2 dtoe, ArrayList listaRegistros){
        UtilidadesLog.info("MONECMBean.insertarActualizarCliente(DTORegistroECM2 dtoe, ArrayList listaRegistros): Entrada");
  /*Verificar si ya fue ingresado el cliente en la listaRegistros
    Recorrer la lista comparando DTOE.codigoCliente con listaRegistros(i).dto.codigoCliente

    Si se encuentra el cliente en la lista{
          Actualizar los datos del cliente (solo los que están en blanco en la lista y no en el DTOE)
    }en otro caso{
          Insertar el cliente en la lista
    }
  */    
        UtilidadesLog.info("1");
        Iterator it = listaRegistros.iterator();
        UtilidadesLog.info("2");
        boolean agrega = false;
        while (it.hasNext()){
              UtilidadesLog.info("3");
              DTORegistroECM2 dt = (DTORegistroECM2) (it.next());
              UtilidadesLog.info("4 " + dt.getCodigoCliente() +  " ----- " + dtoe.getCodigoCliente());
              if (dtoe.getCodigoCliente().equals(dt.getCodigoCliente())){
                  
                  agrega = true;                
                  UtilidadesLog.info("5");
                  if(dt.getApellidoMaterno().equals("")){
                     dt.setApellidoMaterno(dtoe.getApellidoMaterno());
                  }
                  UtilidadesLog.info("6");
                  if(dt.getApellidoPaterno().equals("")){
                          dt.setApellidoPaterno(dtoe.getApellidoPaterno());
                  }
                  UtilidadesLog.info("7");
                  if(dt.getApellidoCasada().equals("")){
                     dt.setApellidoCasada(dtoe.getApellidoCasada()); 
                  }
                  UtilidadesLog.info("8");
                  if(dt.getCargo().equals("")){
                      dt.setCargo(dtoe.getCargo());
                  }
                  UtilidadesLog.info("9");
                  if(dt.getCentroEstudios().equals("")){
                      dt.setCentroEstudios(dtoe.getCentroEstudios());
                  }
                  UtilidadesLog.info("10");
                  if(dt.getCentroTrabajo().equals("")){
                      dt.setCentroTrabajo(dtoe.getCentroTrabajo());
                  }
                  UtilidadesLog.info("11");
                  if(dt.getClasificacion().equals("")){
                      dt.setClasificacion(dtoe.getClasificacion());
                  }
                  UtilidadesLog.info("12");
                  if(dt.getCodigoCanalVenta().equals("")){
                      dt.setCodigoCanalVenta(dtoe.getCodigoCanalVenta());
                  }
                  UtilidadesLog.info("13");
                  if(dt.getCodigoClienteAntiguo().equals("")){
                      dt.setCodigoClienteAntiguo(dtoe.getCodigoClienteAntiguo());
                  }
                  UtilidadesLog.info("14");
                  if(dt.getCodigoClienteVinculo().equals("")){
                      dt.setCodigoClienteVinculo(dtoe.getCodigoClienteVinculo());
                  }
                  UtilidadesLog.info("15");
                  if(dt.getCodigoMarca().equals("")){
                      dt.setCodigoMarca(dtoe.getCodigoMarca());
                  }
                  UtilidadesLog.info("16");
                  if(dt.getCodigoPais().equals("")){
                      dt.setCodigoPais(dtoe.getCodigoPais());
                  }
                  UtilidadesLog.info("17");
                  if(dt.getCodigoPaisAntiguo().equals("")){
                      dt.setCodigoPaisAntiguo(dtoe.getCodigoPaisAntiguo());
                  }
                  UtilidadesLog.info("18");
                  if(dt.getCodigoTipoComunicacion().equals("")){
                      dt.setCodigoTipoComunicacion(dtoe.getCodigoTipoComunicacion());
                  }
                  UtilidadesLog.info("19");
                  if (dt.getCodigoTipoContacto().equals("")){
                      dt.setCodigoTipoContacto(dtoe.getCodigoTipoContacto());
                  }
                  UtilidadesLog.info("20");
                  if(dt.getCodigoTipoVinculo().equals("")){
                      dt.setCodigoTipoVinculo(dtoe.getCodigoTipoVinculo());
                  }
                  UtilidadesLog.info("21");
                  if (dt.getEspecialidad().equals("")){
                      dt.setEspecialidad(dtoe.getEspecialidad());
                  }
                  UtilidadesLog.info("22");
                  if (dt.getEstadoCivil().equals("")){
                      dt.setEstadoCivil(dtoe.getEstadoCivil());
                  }
                  UtilidadesLog.info("23");
                  if (dt.getIndVinculoPrincipal().equals("")){
                      dt.setIndVinculoPrincipal(dtoe.getIndVinculoPrincipal());
                  }
                  UtilidadesLog.info("24");
                  if(dt.getNacionalidad().equals("")){
                      dt.setNacionalidad(dtoe.getNacionalidad());
                  }
                  UtilidadesLog.info("25");
                  if(dt.getNivelEstudios().equals("")){
                     dt.setNivelEstudios(dtoe.getNivelEstudios());
                  }
                  UtilidadesLog.info("26");
                  if(dt.getNombrePrimero().equals("")){
                     dt.setNombrePrimero(dtoe.getNombrePrimero());
                  }
                  UtilidadesLog.info("27");
                  if(dt.getNombreSegundo().equals("")){
                     dt.setNombreSegundo(dtoe.getNombreSegundo());
                  }
                  UtilidadesLog.info("28");
                  if(dt.getNombreVia().equals("")){
                     dt.setNombreVia(dtoe.getNombreVia());
                  }
                  UtilidadesLog.info("29");
                  if(dt.getNumeroDocumento().equals("")){
                     dt.setNumeroDocumento(dtoe.getNumeroDocumento());
                  }
                  UtilidadesLog.info("30");
                  
                  if(dt.getNumeroHijos().equals("0")){
                     
                     if (dtoe.getNumeroHijos() != null){
                         dt.setNumeroHijos(dtoe.getNumeroHijos());
                     }else{
                         dt.setNumeroHijos(new Long(0));  
                     }
                  }
                  UtilidadesLog.info("31"); 
                  if(dt.getNumeroPrincipal().equals("")){
                     if(dtoe.getNumeroPrincipal() != null){
                        dt.setNumeroPrincipal(dtoe.getNumeroPrincipal());
                     }else{
                        dt.setNumeroPrincipal("0");
                     }     
                  }
                  UtilidadesLog.info("32"); 
                  if(dt.getOcupacion().equals("")){
                      dt.setOcupacion(dtoe.getOcupacion());
                  }
                  UtilidadesLog.info("33"); 
                  if(dt.getProfesion().equals("")){
                      dt.setProfesion(dtoe.getProfesion());
                  }
                  UtilidadesLog.info("34"); 
                  if(dt.getSexo().equals("")){
                          dt.setSexo(dtoe.getSexo());
                  }
                  UtilidadesLog.info("35"); 
                  if(dt.getSubtipoCliente().equals("")){
                    dt.setSubtipoCliente(dtoe.getSubtipoCliente());
                  }
                  UtilidadesLog.info("36"); 
                  if(dt.getTextoMedioComunicacion().equals("")){                        
                    dt.setTextoMedioComunicacion(dtoe.getTextoMedioComunicacion());
                  }
                  UtilidadesLog.info("37"); 
                  if(dt.getTipoClasificacion().equals("")){
                    dt.setTipoClasificacion(dtoe.getTipoClasificacion());
                  }
                  UtilidadesLog.info("38"); 
                  if(dt.getTipoCliente().equals("")){
                    dt.setTipoCliente(dtoe.getTipoCliente());
                  }
                  UtilidadesLog.info("39"); 
                  if(dt.getTipoDocumento().equals("")){
                    dt.setTipoDocumento(dtoe.getTipoDocumento());
                  }
                  UtilidadesLog.info("40"); 
                  if(dt.getTipoVia().equals("")){
                    dt.setTipoVia(dtoe.getTipoVia());
                  }
                  UtilidadesLog.info("41"); 
                  if(dt.getUbiGeo().equals("")){
                    dt.setUbiGeo(dtoe.getUbiGeo());  
                  } 
              }              
        }
        UtilidadesLog.info("Agrega" + agrega);
        if (!agrega){
            UtilidadesLog.info("Antes de agregar el DTOE " );
            listaRegistros.add(dtoe);
            UtilidadesLog.info("Ya agrego el DTOE");
        }
        UtilidadesLog.info("MONECMBean.insertarActualizarCliente(DTORegistroECM2 dtoe, ArrayList listaRegistros): Salida");       
  }
  
    
    
	public void generarClientesConsultoras(Date fechaActuacion, String codInterfaz, DTOECMRecibir dtoe) throws MareException{
        UtilidadesLog.info("MONECMBean.generarClientesConsultoras(Date fechaActuacion, String codInterfaz, DTOECMRecibir dtoe): Entrada");
        DAOECM daoECM = new DAOECM();
        RecordSet rs = null;
        
       
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo info = new InterfazInfo(codInterfaz,dtoe.getNumLote(),dtoe.getOidPais());
        try{
             info = gi.crearInterfaz(info);
             info.setObservaciones(dtoe.getObservaciones());
             info.setDescripcionLote(dtoe.getDescripcion());
        }catch(InterfacesException iex){
            UtilidadesLog.error("***error InterfacesException: "+iex.getMotivo(), iex);
            return;
        }catch(RemoteException re){            
            UtilidadesLog.error("***error RemoteException: "+re.getMessage(), re);
            throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        
        rs = daoECM.obtenerDatosCompletosClientesNovedad(dtoe, fechaActuacion );
        
        int tamanio = rs.getRowCount();
        UtilidadesLog.debug("["+ codInterfaz +"] Total Registros: "+ tamanio );
        for (int i=0; i<tamanio;i++){
            registro.vaciar();

            try{
                registro.anyadirCampo(IECM.ECM2_CODIGO_CLIENTE,         rs.getValueAt(i, "CODIGOCLIENTE") );
                registro.anyadirCampo(IECM.ECM2_CODIGO_PAIS,            rs.getValueAt(i, "CODIGOPAIS") );
                registro.anyadirCampo(IECM.ECM2_APELLIDO_PATERNO,       rs.getValueAt(i, "APELLIDOPATERNO") );
                registro.anyadirCampo(IECM.ECM2_APELLIDO_MATERNO,       rs.getValueAt(i, "APELLIDOMATERNO") );
                registro.anyadirCampo(IECM.ECM2_APELLIDO_CASADA,        rs.getValueAt(i, "APELLIDOCASADA") );
                registro.anyadirCampo(IECM.ECM2_NOMBRE_PRIMERO,         rs.getValueAt(i, "NOMBREPRIMERO") );
                registro.anyadirCampo(IECM.ECM2_NOMBRE_SEGUNDO,         rs.getValueAt(i, "NOMBRESEGUNDO") );
                registro.anyadirCampo(IECM.ECM2_FECHA_NACIMIENTO,       rs.getValueAt(i, "FECHANACIMIENTO") );
                registro.anyadirCampo(IECM.ECM2_SEXO,                   rs.getValueAt(i, "SEXO") );
                registro.anyadirCampo(IECM.ECM2_TIPO_CLIENTE,           rs.getValueAt(i, "TIPOCLIENTE") );
                registro.anyadirCampo(IECM.ECM2_SUBTIPO_CLIENTE,        rs.getValueAt(i, "SUBTIPOCLIENTE") );
                registro.anyadirCampo(IECM.ECM2_NACIONALIDAD,           rs.getValueAt(i, "NACIONALIDAD") );
                registro.anyadirCampo(IECM.ECM2_ESTADO_CIVIL,           rs.getValueAt(i, "ESTADOCIVIL") );
                registro.anyadirCampo(IECM.ECM2_TIPO_DOCUMENTO,         rs.getValueAt(i, "TIPODOCUMENTO") );
                registro.anyadirCampo(IECM.ECM2_NUMERO_DOCUMENTO,       rs.getValueAt(i, "NUMERODOCUMENTO") );
                registro.anyadirCampo(IECM.ECM2_TIPO_VIA,               rs.getValueAt(i, "TIPOVIA") );
                registro.anyadirCampo(IECM.ECM2_NOMBRE_VIA,             rs.getValueAt(i, "NOMBREVIA") );
                registro.anyadirCampo(IECM.ECM2_NUMERO_PRINCIPAL,       rs.getValueAt(i, "NUMEROPRINCIPAL") );
                registro.anyadirCampo(IECM.ECM2_UBI_GEO,                rs.getValueAt(i, "UBIGEO"));              
                registro.anyadirCampo(IECM.ECM2_CODIGO_MARCA,           rs.getValueAt(i, "CODIGOMARCA") );
                registro.anyadirCampo(IECM.ECM2_CODIGO_PAIS_ANTIGUO,    "");
                registro.anyadirCampo(IECM.ECM2_CODIGO_CLIENTE_ANTIGUO, "");
                registro.anyadirCampo(IECM.ECM2_CODIGO_CANAL_ANTIGUO,   "");    //  Modificado HRCS - 04/09/2007 - Cambio Sicc20070385
                registro.anyadirCampo(IECM.ECM2_PROFESION,              rs.getValueAt(i, "PROFESION") );
                registro.anyadirCampo(IECM.ECM2_OCUPACION,              rs.getValueAt(i, "OCUPACION") );
                registro.anyadirCampo(IECM.ECM2_ESPECIALIDAD,           "");
                registro.anyadirCampo(IECM.ECM2_CENTRO_TRABAJO,         rs.getValueAt(i, "CENTROTRABAJO") );
                registro.anyadirCampo(IECM.ECM2_CARGO,                  rs.getValueAt(i, "CARGO") );
                registro.anyadirCampo(IECM.ECM2_NIVEL_ESTUDIOS,         rs.getValueAt(i, "NIVELESTUDIOS") );
                registro.anyadirCampo(IECM.ECM2_CENTRO_ESTUDIOS,        rs.getValueAt(i, "CENTROESTUDIOS") );                
                if (rs.getValueAt(i, "NUMEROHIJOS")!=null){ 
                    registro.anyadirCampo(IECM.ECM2_NUMERO_HIJOS,        rs.getValueAt(i, "NUMEROHIJOS"));
                }
                else{
                    registro.anyadirCampo(IECM.ECM2_NUMERO_HIJOS,        "0");            
                }
                
                registro.anyadirCampo(IECM.ECM2_TIPO_CLASIFICACION,     "" ); // 
                registro.anyadirCampo(IECM.ECM2_CLASIFICACION,          "" ); //
                if (rs.getValueAt(i, "CODIGOTIPOCOMUNICACION")!=null)   {
                    registro.anyadirCampo(IECM.ECM2_TIPO_COMUNICACION,      rs.getValueAt(i, "CODIGOTIPOCOMUNICACION") );
                }
                else    {
                    registro.anyadirCampo(IECM.ECM2_TIPO_COMUNICACION,  "" );
                }
                if ( rs.getValueAt(i, "TEXTOMEDIOCOMUNICACION")!=null)   {
                    registro.anyadirCampo(IECM.ECM2_TEXTO_MEDIO_COMUNICACION, rs.getValueAt(i, "TEXTOMEDIOCOMUNICACION") );
                }
                else    {
                    registro.anyadirCampo(IECM.ECM2_TEXTO_MEDIO_COMUNICACION, "" );
                }
                registro.anyadirCampo(IECM.ECM2_TIPO_CONTACTO,          rs.getValueAt(i, "CODIGOTIPOCONTACTO") );
                registro.anyadirCampo(IECM.ECM2_FECHA_CONTACTO,         rs.getValueAt(i, "FECHACONTACTO") );
                registro.anyadirCampo(IECM.ECM2_TIPO_VINCULO,           rs.getValueAt(i, "CODIGOTIPOVINCULO") );
                registro.anyadirCampo(IECM.ECM2_CODIGO_CLIENTE_VINCULO, rs.getValueAt(i, "CODIGOCLIENTEVINCULO") );
                registro.anyadirCampo(IECM.ECM2_FECHA_DESDE,            rs.getValueAt(i, "FECHADESDE") );
                registro.anyadirCampo(IECM.ECM2_FECHA_HASTA,            rs.getValueAt(i, "FECHAHASTA") );
                if (rs.getValueAt(i, "INDVINCULOPRINCIPAL")!=null)   {
                    registro.anyadirCampo(IECM.ECM2_IND_VINCULO_PRINCIPAL,  ((BigDecimal)rs.getValueAt(i, "INDVINCULOPRINCIPAL")).toString() );
                }
                else    {
                    registro.anyadirCampo(IECM.ECM2_IND_VINCULO_PRINCIPAL,  "" );
                }
                registro.anyadirCampo(IECM.ECM2_ESTATUS,                rs.getValueAt(i, "ESTATUS") );
                
            }catch(InterfacesException iex){
                UtilidadesLog.error("*** error InterfacesException: anyadirCampo: "+iex.getMotivo(), iex);
                continue;
            }
            
            try{
               gi.anyadirRegistro(info,registro);
            }catch(InterfacesException iex){
                UtilidadesLog.error("*** error InterfacesException: anyadirRegistro: "+iex.getMotivo(), iex);
            }catch(RemoteException re){                
                UtilidadesLog.error(re);
                throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        try{
           gi.enviarInterfaz(info); 
        }catch (InterfacesException iex){
            UtilidadesLog.error("*** error InterfacesException: enviarInterfaz: "+iex.getMotivo(), iex);
        }catch(RemoteException re){            
            UtilidadesLog.error(re);
            throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONECMBean.generarClientesConsultoras(Date fechaActuacion, String codInterfaz, DTOECMRecibir dtoe): Salida");
	}
    
	private Long comprobarTipoDocumento(DTORegistroECM2 valoresInterfaz,IRegistroSicc registro, InterfazInfo info) throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.comprobarTipoDocumento(IRegistroSicc registro, InterfazInfo info): Entrada");		
		
		MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		Long oidTipoDocumento = null;
		TipoDocumentoLocal tipoDocu = null;
		try{
			tipoDocu = this.getTipoDocumentoLocalHome().findByUK(info.getPais(),valoresInterfaz.getTipoDocumento());
			oidTipoDocumento = tipoDocu.getOid();
		}catch(NoResultException f){
			try{
                            DTOINTError dtoError = new DTOINTError(info,registro,ErroresDeNegocio.INT_0044 + "" +valoresInterfaz.getTipoDocumento());
                            gi.registrarError(dtoError);
                            throw new ECM2Exception(ErroresDeNegocio.INT_0044 + "" +valoresInterfaz.getTipoDocumento(), null);
                        }catch(InterfacesException ie){
                            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                        }catch(RemoteException ne){
                                            UtilidadesLog.error(ne);
                            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		UtilidadesLog.info("MONECMBean.comprobarTipoDocumento(IRegistroSicc registro, InterfazInfo info): Salida");		
		return oidTipoDocumento;
	}

	private Long comprobarMarca (DTORegistroECM2 valoresInterfaz, IRegistroSicc registro, InterfazInfo info) throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.comprobarMarca(IRegistroSicc registro, InterfazInfo info): Entrada");		
		
		MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		MarcaLocal marca = null;
		Long oidMarca = null;
		try{
			marca = this.getMarcaLocalHome().findByUK(valoresInterfaz.getCodigoMarca());
			oidMarca = marca.getOid();
		}catch(NoResultException f){
			try{
                            DTOINTError dtoError = new DTOINTError(info,registro, ErroresDeNegocio.INT_0004+ "" +valoresInterfaz.getCodigoMarca());
                            gi.registrarError(dtoError);
                            throw new ECM2Exception(ErroresDeNegocio.INT_0004+ "" +valoresInterfaz.getCodigoMarca(), null);
                        }catch(InterfacesException ie){
                            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                        }catch(RemoteException ne){
                            UtilidadesLog.error(ne);
                            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
        UtilidadesLog.info("MONECMBean.comprobarMarca(IRegistroSicc registro, InterfazInfo info): Salida");		
		return oidMarca;
	}

	private java.sql.Date truncarFecha(java.sql.Date fecha){
        UtilidadesLog.info("MONECMBean.truncarFecha(java.sql.Date fecha): Entrada");
		if (fecha!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechaTruncada = java.sql.Date.valueOf(sdf.format(fecha));
            UtilidadesLog.info("MONECMBean.truncarFecha(java.sql.Date fecha): Salida");
			return fechaTruncada;
		}
        else {
            UtilidadesLog.info("MONECMBean.truncarFecha(java.sql.Date fecha): Salida");
            return null;
        }
	}

    //modificada cabecera metodo por incidencia 14898
    private void obtenerValorDefectoObligatorio (IRegistroSicc registro, InterfazInfo info, String atributo, Long oidSubtipoCliente, Long oidPais)throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.obtenerValorDefectoObligatorio(IRegistroSicc registro, InterfazInfo info, String atributo, Long oidSubtipoCliente, Long oidPais): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        Long pais = oidPais;
        Long subtipoCliente = oidSubtipoCliente;
        String codigo = null;
        //Evaluamos el parametro  "atributo" recibido:
        //incidencia 14899
        if (atributo.equals(IECM.ECM2_APELLIDO_PATERNO)){
            codigo = "MAECLIEAPELL1";
        }else if(atributo.equals(IECM.ECM2_APELLIDO_MATERNO)){
            codigo = "MAECLIEAPELL2";
        }else if(atributo.equals(IECM.ECM2_APELLIDO_CASADA)){
            codigo = "MAECLIEAPELLCA";
        }else if(atributo.equals(IECM.ECM2_NOMBRE_PRIMERO)){
            codigo = "MAECLIENOM1";
        }else if(atributo.equals(IECM.ECM2_NOMBRE_SEGUNDO)){
            codigo = "MAECLIENOM2";
        }else if(atributo.equals(IECM.ECM2_FECHA_NACIMIENTO)){
            codigo = "MAECLIEFECHNA";
        }else if(atributo.equals(IECM.ECM2_SEXO)){
            codigo = "MAECLIESEXO";
        }else if(atributo.equals(IECM.ECM2_NACIONALIDAD)){
            codigo = "MAECLIENACIO";
        }else if(atributo.equals(IECM.ECM2_ESTADO_CIVIL)){
            codigo = "MAECLIEESTCIV";
        }else if(atributo.equals(IECM.ECM2_PROFESION)){
            codigo = "MAECLIEPROF";
        }else if(atributo.equals(IECM.ECM2_OCUPACION)){
            codigo = "MAECLIEOCUP";
        }else if(atributo.equals(IECM.ECM2_CENTRO_TRABAJO)){
            codigo = "MAECLIECENTRA";
        }else if(atributo.equals(IECM.ECM2_CARGO)){
            codigo = "MAECLIECARGO";
        }else if(atributo.equals(IECM.ECM2_NIVEL_ESTUDIOS)){
            codigo = "MAECLIENIVESTU";
        }else if(atributo.equals(IECM.ECM2_CENTRO_ESTUDIOS)){
            codigo = "MAECLIECENESTU";
        }else if(atributo.equals(IECM.ECM2_NUMERO_HIJOS)){
            codigo = "MAENUMHIJOS";
        }else if(atributo.equals(IECM.ECM2_TRATAMIENTO)){
            codigo = "MAECLIETRAT";
        }else if(atributo.equals(IECM.ECM2_FORMA_PAGO)){
            codigo = "MAECLIEFORMPA";
        }
        
        // Llamar al metodo obtenerValorDefectoObligatorio() del DAOECM, enviando codigo, pais y subtipoCliente 
        DAOECM daoECM = new DAOECM();
        RecordSet rs = null;
        rs = daoECM.obtenerValorDefectoObligatorio(pais,subtipoCliente,codigo);
        String valorDefecto = null;
        Boolean obligatorio = null;
        BigDecimal rsObligatorio = null;
        
        if(!rs.esVacio()){
          valorDefecto = (String)rs.getValueAt(0,"VALORDEFECTO");
          rsObligatorio = (BigDecimal)rs.getValueAt(0,"OBLIGATORIO");
        }
        
        if ((rsObligatorio != null) && (rsObligatorio.intValue()==1)){
            obligatorio = new Boolean(true);
        }else{
            obligatorio = new Boolean(false);
        }
            
        /*
         * Comentado por HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
        if ((valorDefecto!=null) && (obligatorio.booleanValue())){
            //incidencia 14901
            DTOINTError dtoError = new DTOINTError (info,registro,ErroresDeNegocio.INT_0048);
            try{
                gi.registrarError(dtoError);
            }catch (InterfacesException ie){
                UtilidadesLog.error("Excepcion de la Interfaz en MONECM.obtenerValorDefectoObligatorio: "+ ie.getMotivo() ,ie);
            }catch(RemoteException re){
					UtilidadesLog.error(re);
					String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
					throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			}
            return;
        }else{
            // Crear registro en propiedad valoresDefecto de este MON: 
            // clave = atributo 
            // valor = valorDefecto 
            UtilidadesLog.debug("***MONECM.obtenerValorDefectoObligatorio - Atributo : " + atributo);
            UtilidadesLog.debug("***MONECM.obtenerValorDefectoObligatorio - ValorDefecto : " + valorDefecto);
            if(valorDefecto == null)
                valorDefecto = "";
                
            valoresDefecto.put(atributo,valorDefecto);
        }*/
        
        //  Agregado por HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
        if (valorDefecto==null && obligatorio.booleanValue())   {
            DTOINTError dtoError = new DTOINTError (info,registro,ErroresDeNegocio.INT_0048);
            try{
                gi.registrarError(dtoError);
                throw new ECM2Exception( ErroresDeNegocio.INT_0048.toString(), null );
            }catch (InterfacesException ie){
                UtilidadesLog.error("Excepcion de la Interfaz en MONECM.obtenerValorDefectoObligatorio: "+ ie.getMotivo() ,ie);
            }catch(RemoteException re){
					UtilidadesLog.error(re);
					String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
					throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
			}
            return;            
        }
        else    {
            UtilidadesLog.debug("***MONECM.obtenerValorDefectoObligatorio - Atributo : " + atributo);
            UtilidadesLog.debug("***MONECM.obtenerValorDefectoObligatorio - ValorDefecto : " + valorDefecto);
            if(valorDefecto == null)
                valorDefecto = "";
            valoresDefecto.put(atributo,valorDefecto);
        }
        
        UtilidadesLog.info("MONECMBean.obtenerValorDefectoObligatorio(IRegistroSicc registro, InterfazInfo info, String atributo, Long oidSubtipoCliente, Long oidPais): Salida");
    }
    
	/**
     * 
     * Modificado: Cleal
     * Se modifico el tipo de datos de numero principal
     */
	private DTORegistroECM2 obtenerValoresInterfaz (IRegistroSicc registro, InterfazInfo info, Long oidSubtipoCliente, Long oidPais)throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.obtenerValoresInterfaz(IRegistroSicc registro, InterfazInfo info, Long oidSubtipoCliente, Long oidPais): Entrada");
        /* Leemos cada uno de los campos que llegan en el interfaz. 
         * (Tambien recibe oidPais y oidSubtipoCliente, necesarios para obtener los valores por defecto.) 
         * Si alguno de ellos llega vacio, comprobamos si es un campo obligatorio o no, y obtenemos su valor por defecto. 
         * Si su valor por defecto es NULL , se lanza una excepcion, indicando que faltan campos obligatorios, 
         *  y finaliza el Caso de Uso.
         * Como resultado final del método, y si no se lanza la excepcion, se creara un Array 
         *  con los valores por defecto de cada uno de los valores que vienen a NULL en el interfaz, junto a su codigo de atributo 
         */
		DTORegistroECM2 valoresInterfaz = new DTORegistroECM2();
		
       
        //apellidoPaterno
        String apellidoPaterno = (String)registro.obtenerCampo(IECM.ECM2_APELLIDO_PATERNO);
        UtilidadesLog.debug("apellidoPaterno: " + apellidoPaterno);
        if ((apellidoPaterno==null) || (apellidoPaterno.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_APELLIDO_PATERNO,oidSubtipoCliente,oidPais);
        }        
        //apellidoMaterno
        String apellidoMaterno = (String)registro.obtenerCampo(IECM.ECM2_APELLIDO_MATERNO);
        if ((apellidoMaterno==null) || (apellidoMaterno.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_APELLIDO_MATERNO,oidSubtipoCliente,oidPais);
        }        
        //apellidoCasada
        String apellidoCasada = (String)registro.obtenerCampo(IECM.ECM2_APELLIDO_CASADA);
        if ((apellidoCasada==null) || (apellidoCasada.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_APELLIDO_CASADA,oidSubtipoCliente,oidPais);
        }        
        //nombrePrimero
        String nombrePrimero = (String)registro.obtenerCampo(IECM.ECM2_NOMBRE_PRIMERO);
        UtilidadesLog.debug("nombrePrimero: " + nombrePrimero);
        if ((nombrePrimero==null) || (nombrePrimero.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_NOMBRE_PRIMERO,oidSubtipoCliente,oidPais);
        }        
        //nombreSegundo
        String nombreSegundo = (String)registro.obtenerCampo(IECM.ECM2_NOMBRE_SEGUNDO);
        if ((nombreSegundo==null) || (nombreSegundo.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_NOMBRE_SEGUNDO,oidSubtipoCliente,oidPais);
        }        
        //fechaNacimiento
        Date fechaNacimiento = (Date)registro.obtenerCampo(IECM.ECM2_FECHA_NACIMIENTO);
        if ((fechaNacimiento==null) || (fechaNacimiento.equals(""))){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_FECHA_NACIMIENTO,oidSubtipoCliente,oidPais);
        }        
        //sexo
        String sexo = (String)registro.obtenerCampo(IECM.ECM2_SEXO);
        UtilidadesLog.debug("sexo: " + sexo);
        if ((sexo==null) || (sexo.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_SEXO,oidSubtipoCliente,oidPais);
        }        
        String tipoCliente = (String)registro.obtenerCampo(IECM.ECM2_TIPO_CLIENTE);
        String subTipoCliente = (String)registro.obtenerCampo(IECM.ECM2_SUBTIPO_CLIENTE);
        //nacionalidad
        String nacionalidad = (String)registro.obtenerCampo(IECM.ECM2_NACIONALIDAD);
        if ((nacionalidad==null) || (nacionalidad.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_NACIONALIDAD,oidSubtipoCliente,oidPais);
        }
        //estadoCivil
        String estadoCivil = (String)registro.obtenerCampo(IECM.ECM2_ESTADO_CIVIL);
        if ((estadoCivil==null) || (estadoCivil.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_ESTADO_CIVIL,oidSubtipoCliente,oidPais);
        }        
        String tipoDocumento = (String)registro.obtenerCampo(IECM.ECM2_TIPO_DOCUMENTO);
        UtilidadesLog.debug("tipoDocumento: " + tipoDocumento);
        String numeroDocumento = (String)registro.obtenerCampo(IECM.ECM2_NUMERO_DOCUMENTO);
        UtilidadesLog.debug("numeroDocumento: " + numeroDocumento);
        String tipoVia = (String)registro.obtenerCampo(IECM.ECM2_TIPO_VIA);
        UtilidadesLog.debug("tipoVia: " + tipoVia);
        String nombreVia = (String)registro.obtenerCampo(IECM.ECM2_NOMBRE_VIA);
        UtilidadesLog.debug("nombreVia: " + nombreVia);
        String numeroPrincipal = (String)registro.obtenerCampo(IECM.ECM2_NUMERO_PRINCIPAL);
        UtilidadesLog.debug("numeroPrincipal: " + tipoDocumento);
        String ubiGeo = (String)registro.obtenerCampo(IECM.ECM2_UBI_GEO);
        
        String codigoMarca = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_MARCA);
        String codigoCanal = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_CANAL); //  Agregado HRCS - 04/09/2007 - Cambio Sicc20070385
        String codigoPaisAntiguo = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_PAIS_ANTIGUO);
        String codigoClienteAntiguo = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_CLIENTE_ANTIGUO);
        String codigoCanalVenta = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_CANAL_ANTIGUO); // Modificado HRCS - 04/09/2007 - Cambio Sicc20070385
        //profesion
        String profesion = (String)registro.obtenerCampo(IECM.ECM2_PROFESION);
        if ((profesion==null) || (profesion.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_PROFESION,oidSubtipoCliente,oidPais);
        } 
        //ocupacion
        String ocupacion = (String)registro.obtenerCampo(IECM.ECM2_OCUPACION);
        if ((ocupacion==null) || (ocupacion.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_OCUPACION,oidSubtipoCliente,oidPais);
        }
        String especialidad = (String)registro.obtenerCampo(IECM.ECM2_ESPECIALIDAD);
        //centroTrabajo
        String centroTrabajo = (String)registro.obtenerCampo(IECM.ECM2_CENTRO_TRABAJO);
        if ((centroTrabajo==null) || (centroTrabajo.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_CENTRO_TRABAJO,oidSubtipoCliente,oidPais);
        }        
        //cargo
        String cargo = (String)registro.obtenerCampo(IECM.ECM2_CARGO);
        if ((cargo==null) || (cargo.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_CARGO,oidSubtipoCliente,oidPais);
        }        
        //nivelEstudios
        String nivelEstudios = (String)registro.obtenerCampo(IECM.ECM2_NIVEL_ESTUDIOS);
        if ((nivelEstudios==null) || (nivelEstudios.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_NIVEL_ESTUDIOS,oidSubtipoCliente,oidPais);
        }        
        //centroEstudios
        String centroEstudios = (String)registro.obtenerCampo(IECM.ECM2_CENTRO_ESTUDIOS);
        if ((centroEstudios==null) || (centroEstudios.length()<1)){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_CENTRO_ESTUDIOS,oidSubtipoCliente,oidPais);
        }
        //numeroHijos
        Long numeroHijos = (Long)registro.obtenerCampo(IECM.ECM2_NUMERO_HIJOS);
        UtilidadesLog.debug("numeroHijos" + numeroHijos);
        if (numeroHijos==null){
            this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_NUMERO_HIJOS,oidSubtipoCliente,oidPais);
        }
        //  Agregado HRCS - Fecha 13/09/2007 - Cambio Sicc2007416
        String indCorrespondencia = (String)registro.obtenerCampo(IECM.ECM2_IND_CORRESPONDENCIA);
        //tratamiento
        this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_TRATAMIENTO,oidSubtipoCliente,oidPais);
        //forma depago
        this.obtenerValorDefectoObligatorio(registro,info,IECM.ECM2_FORMA_PAGO,oidSubtipoCliente,oidPais);

        String tipoClasificacion = (String)registro.obtenerCampo(IECM.ECM2_TIPO_CLASIFICACION);
        String clasificacion = (String)registro.obtenerCampo(IECM.ECM2_CLASIFICACION);
        String codigoTipoComunicacion = (String)registro.obtenerCampo(IECM.ECM2_TIPO_COMUNICACION);
        String textoMedioComunicacion = (String)registro.obtenerCampo(IECM.ECM2_TEXTO_MEDIO_COMUNICACION);
        //  Agregado HRCS - Fecha 13/09/2007 - Cambio Sicc2007416
        String indComunicacionPrincipal = (String)registro.obtenerCampo(IECM.ECM2_IND_COMUNICACION_PRINCIPAL);
        String codigoTipoContacto = (String)registro.obtenerCampo(IECM.ECM2_TIPO_CONTACTO);
        Date fechaContacto = (Date)registro.obtenerCampo(IECM.ECM2_FECHA_CONTACTO);
        String codigoTipoVinculo = (String)registro.obtenerCampo(IECM.ECM2_TIPO_VINCULO);
        String codigoClienteVinculo = (String)registro.obtenerCampo(IECM.ECM2_CODIGO_CLIENTE_VINCULO);
        Date fechaDesde = (Date)registro.obtenerCampo(IECM.ECM2_FECHA_DESDE);
        Date fechaHasta = (Date)registro.obtenerCampo(IECM.ECM2_FECHA_HASTA);
        String indVinculoPrincipal = (String)registro.obtenerCampo(IECM.ECM2_IND_VINCULO_PRINCIPAL);
        
        //sb
        String indicadorConfirmacion = (String)registro.obtenerCampo(IECM.ECM2_IND_CONFIRMACION_COMUNICACION);
        
        valoresInterfaz.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);   //  Agregado HRCS - 06/09/2007 - Cambio Sicc2007385
        valoresInterfaz.setApellidoCasada(apellidoCasada);
        valoresInterfaz.setApellidoMaterno(apellidoMaterno);
        valoresInterfaz.setApellidoPaterno(apellidoPaterno);
        valoresInterfaz.setCargo(cargo);
        valoresInterfaz.setCentroEstudios(centroEstudios);
        valoresInterfaz.setCentroTrabajo(centroTrabajo);
        valoresInterfaz.setClasificacion(clasificacion);
        valoresInterfaz.setCodigoCanalVenta(codigoCanalVenta);
        valoresInterfaz.setCodigoClienteAntiguo(codigoClienteAntiguo);
        valoresInterfaz.setCodigoClienteVinculo(codigoClienteVinculo);
        valoresInterfaz.setCodigoMarca(codigoMarca);
        valoresInterfaz.setCodigoCanal(codigoCanal);    //  Agregado HRCS - 04/09/2007 - Cambio Sicc20070385
        valoresInterfaz.setCodigoPaisAntiguo(codigoPaisAntiguo);
        valoresInterfaz.setCodigoTipoComunicacion(codigoTipoComunicacion);
        valoresInterfaz.setCodigoTipoContacto(codigoTipoContacto);
        valoresInterfaz.setCodigoTipoVinculo(codigoTipoVinculo);
        valoresInterfaz.setEspecialidad(especialidad);
        valoresInterfaz.setEstadoCivil(estadoCivil);
        valoresInterfaz.setFechaContacto(fechaContacto);
        valoresInterfaz.setFechaDesde(fechaDesde);
        valoresInterfaz.setFechaHasta(fechaHasta);
        valoresInterfaz.setFechaNacimiento(fechaNacimiento);
        valoresInterfaz.setIndVinculoPrincipal(indVinculoPrincipal);
        valoresInterfaz.setNacionalidad(nacionalidad);
        valoresInterfaz.setNivelEstudios(nivelEstudios);
        valoresInterfaz.setNombrePrimero(nombrePrimero);
        valoresInterfaz.setNombreSegundo(nombreSegundo);
        valoresInterfaz.setNombreVia(nombreVia);
        valoresInterfaz.setNumeroDocumento(numeroDocumento);
        valoresInterfaz.setNumeroHijos(numeroHijos);
        valoresInterfaz.setNumeroPrincipal(numeroPrincipal);
        valoresInterfaz.setOcupacion(ocupacion);
        valoresInterfaz.setProfesion(profesion);
        valoresInterfaz.setSexo(sexo);
        valoresInterfaz.setSubtipoCliente(subTipoCliente);
        valoresInterfaz.setTextoMedioComunicacion(textoMedioComunicacion);
        valoresInterfaz.setTipoClasificacion(tipoClasificacion);
        valoresInterfaz.setTipoCliente(tipoCliente);
        valoresInterfaz.setTipoDocumento(tipoDocumento);
        valoresInterfaz.setTipoVia(tipoVia);
        valoresInterfaz.setUbiGeo(ubiGeo);
        valoresInterfaz.setIndCorrespondencia(indCorrespondencia);
        valoresInterfaz.setIndComunicacionPrincipal(indComunicacionPrincipal);
        //sb
        valoresInterfaz.setIndicadorConfirmacion(indicadorConfirmacion);
        UtilidadesLog.debug("valoresInterfaz: " + valoresInterfaz);
        
        UtilidadesLog.info("MONECMBean.obtenerValoresInterfaz(IRegistroSicc registro, InterfazInfo info, Long oidSubtipoCliente, Long oidPais): Salida");
        return valoresInterfaz;
    }
    
	 private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}
		
	private MONClientes getMONClientes() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONClientes(): Entrada");
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome("MONClientes", MONClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONClientes(): Salida");
        return ejb;
	}

	private MONUnidadesGeograficas getMONUnidadesGeograficas() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONUnidadesGeograficas(): Entrada");
        MONUnidadesGeograficasHome home = (MONUnidadesGeograficasHome)UtilidadesEJB.getHome("MONUnidadesGeograficas", MONUnidadesGeograficasHome.class);
            
        // Se obtiene el interfaz remoto
        MONUnidadesGeograficas ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONUnidadesGeograficas(): Salida");
        return ejb;
	}        
		
	private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONPeriodos(): Salida");
        return ejb;
	}
		
	private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONMantenimientoSEG(): Entrada");
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONMantenimientoSEG(): Salida");
        return ejb;
	}
		
	private MONINT getMONINT() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONINT(): Entrada");
        MONINTHome home = (MONINTHome)UtilidadesEJB.getHome("MONINT", MONINTHome.class);
            
        // Se obtiene el interfaz remoto
        MONINT ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONINT(): Salida");
        return ejb;
	}	

	private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONGenerarSolicitudModulosExternos(): Entrada");
        MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome)UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
            
        // Se obtiene el interfaz remoto
        MONGenerarSolicitudModulosExternos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONECMBean.getMONGenerarSolicitudModulosExternos(): Salida");
        return ejb;
	}


    private Date pasarAFecha(java.util.Date fecha){
        UtilidadesLog.info("MONECMBean.pasarAFecha(java.util.Date fecha): Entrada");
        UtilidadesLog.debug("Fecha de entrada: "+fecha);
        Date fechaFin=null;
        if(fecha!=null){
            fechaFin = new Date(fecha.getTime());
        }else if(fecha==null){
            UtilidadesLog.debug("La fecha pasada a la clase pasarAFecha es null");
        }
        
        UtilidadesLog.debug("Fecha de cambiada: "+ fechaFin);
        UtilidadesLog.info("MONECMBean.pasarAFecha(java.util.Date fecha): Salida");
        return fechaFin;
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBatch");
    }
    
   

    public void realizarCreate(DTOINT dto, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi) throws MareException
    {
            UtilidadesLog.info("MONECMBean.realizarCreate(DTOINT dto, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Entrada");
                  //sacamos los datos del Array
           UtilidadesLog.debug(" --> CREATE DE LA INTERFAZ ECM-1");
           Date   FechaInternet = (Date)array.get(0);
           Long   cliente=(Long)array.get(1);
           Long   marca= (Long)array.get(2);
           Long   sociedad =(Long)array.get(3);
           
           Float importeVenta =(Float)array.get(4);
           Float importeConsultora =(Float)array.get(5);
           Long   iDClienteIntenet =(Long)array.get(6);
           
           Long canal =(Long)array.get(7);
           
             UtilidadesLog.debug("\n dto.getNumeroLote() " + dto.getNumeroLote());
             UtilidadesLog.debug("\n FechaInternet " + FechaInternet);
             UtilidadesLog.debug("\ncliente " + cliente);
             UtilidadesLog.debug("\nmarca " + marca);
             UtilidadesLog.debug("\nsociedad " + sociedad);
             UtilidadesLog.debug("\nimporteVenta " + importeVenta);
             UtilidadesLog.debug("\nimporteconsultora " + importeConsultora);
             UtilidadesLog.debug("\niDClienteIntenet " + iDClienteIntenet);
             
             try{
                        RecepcionVentasAsociadasLocalHome home= this.getRecepcionVentasAsociadasLocalHome();
                        RecepcionVentasAsociadasLocal local=null;
                        
                        local=home.create(dto.getNumeroLote(),
                                new java.sql.Date((FechaInternet).getTime()),
                                cliente,
                                canal,
                                marca,
                                sociedad);
                        local.setCodigoInterfaz(IGestorInterfaces.COD_INTERFAZ_ECM1);
                        
                       
                        if(importeVenta!=null){
                            UtilidadesLog.debug("cargarVentasINT-->importeVenta Inernet : "+ importeVenta);
                            local.setImporteVentaInternet(new BigDecimal(importeVenta.doubleValue()));
                        }
                        
                        
                         if(importeConsultora!=null){
                            local.setImporteAbonoConsultora(new BigDecimal(importeConsultora.doubleValue()));
                         }
                        
                         local.setIdentEnPlataformaIn(iDClienteIntenet);
                         home.merge(local);
                          
                    }catch(PersistenceException c){
                        ctx.setRollbackOnly();
                        UtilidadesLog.error(c);
                        throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
             UtilidadesLog.info("MONECMBean.realizarCreate(DTOINT dto, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Salida");
    }
    
     private MONECM getMONECM() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONECMBean.getMONECM(): Entrada");
        MONECMHome home = (MONECMHome)UtilidadesEJB.getHome("MONECM", MONECMHome.class);
        // Se obtiene el interfaz remoto
        MONECM ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONECMBean.getMONECM(): Salida");
        return ejb;
	}


    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    private Integer bigDecimalToInteger(Object numero) {
    
        if (numero != null) {
            return new Integer(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }
    
    private Double bigDecimalToDouble(Object numero) {    
        if (numero != null) {
            return new Double(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }

    private Boolean bigDecimalToBoolean(Object indicador) {
    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }
    
    private java.sql.Date dateToSqlDate(Object fecha) {    
        if (fecha != null) {
            return (java.sql.Date)fecha;
        } else {
            return null;
        }
    }

    private Date bigDecimalToDate(Object fecha) {    
        if (fecha != null) {
            return (Date) fecha;
        } else {
            return null;
        }
    }

    private MONECMLocalHome getMONECMLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONECMLocalHome)context.lookup("java:comp/env/MONECM");
    }

    /**
     * Agregado por HRCS - Fecha 05/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param info
     * @param registro
     */
	private Long comprobarCanal(DTORegistroECM2 valoresInterfaz, IRegistroSicc registro, InterfazInfo info) throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.comprobarCanal(IRegistroSicc registro, InterfazInfo info): Entrada");		
		
		MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		CanalLocal canal = null;
		Long oidCanal = null;
		try{
			canal = this.getCanalLocalHome().findByUK(valoresInterfaz.getCodigoCanal());
			oidCanal = canal.getOid();
		}catch(NoResultException f){
			try{
                            DTOINTError dtoError = new DTOINTError(info,registro, ErroresDeNegocio.INT_0035+ "" +valoresInterfaz.getCodigoCanal());
                            gi.registrarError(dtoError);
                            throw new ECM2Exception(ErroresDeNegocio.INT_0035+ "" +valoresInterfaz.getCodigoCanal(), null);
                        }catch(InterfacesException ie){
                            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                        }catch(RemoteException ne){
                            UtilidadesLog.error(ne);
                            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
        UtilidadesLog.info("MONECMBean.comprobarCanal(IRegistroSicc registro, InterfazInfo info): Salida");		
		return oidCanal;
	}


    /**
     * Modificado por HRCS - Fecha 05/09/2007 - Cambio Sicc20070385
     * Modificado por Sapaza - Fecha 24/09/2007 - Cambio Sicc20070416, modificamos para que cada uno de los campos
     *                          recibidos, en caso que sea nuevo y venga vacio o en caso que exista y tenga
     *                          valor nulo, se grabe o actualice con el valor por defecto de ese campo.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPais
     * @param codigoCliente
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
    private Long mantenerClienteDatosBasicos( boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, String codigoCliente, Long oidPais) throws MareException{

        UtilidadesLog.info("MONECMBean.mantenerClienteDatosBasicos(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, String codigoCliente, Long oidPais): Entrada");		
		ClienteDatosBasicosLocal datosBasicos = null;
        if (esClienteNuevo) {
            try{
                datosBasicos = this.getClienteDatosBasicosLocalHome().create(oidPais,codigoCliente,false);
            }catch(PersistenceException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        else    {
            try{
                datosBasicos = this.getClienteDatosBasicosLocalHome().findByUK(oidPais,codigoCliente);
            }catch(NoResultException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
		
		String apePat = null;
		if(valoresInterfaz.getApellidoPaterno()==null || valoresInterfaz.getApellidoPaterno().equals("")){
            if(esClienteNuevo)  {
                apePat = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_PATERNO);
            } else {
                apePat = datosBasicos.getVal_ape1();
                if (apePat == null) 
                    apePat = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_PATERNO);
            }
            datosBasicos.setVal_ape1(apePat);            
		}else{
			apePat = valoresInterfaz.getApellidoPaterno();
            datosBasicos.setVal_ape1(apePat);
		}
		
		String apeCas = null;
		if(valoresInterfaz.getApellidoCasada()==null || valoresInterfaz.getApellidoCasada().equals("")){
            if(esClienteNuevo)  {
                apeCas = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_CASADA);
            } else {
                apeCas = datosBasicos.getVal_apel_casa();
                if (apeCas == null) 
                    apeCas = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_CASADA);
            }
            datosBasicos.setVal_apel_casa(apeCas);
		}else{
			apeCas = valoresInterfaz.getApellidoCasada();
            datosBasicos.setVal_apel_casa(apeCas);
		}
		
		String apeMat = null;
		if(valoresInterfaz.getApellidoMaterno()==null || valoresInterfaz.getApellidoMaterno().equals("")){
            if(esClienteNuevo)  {
                apeMat = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_MATERNO);
            } else {
                apeMat = datosBasicos.getVal_ape2();
                if (apeMat == null) 
                    apeMat = (String)valoresDefecto.get(IECM.ECM2_APELLIDO_MATERNO);
            }
            datosBasicos.setVal_ape2(apeMat);
		}else{
			apeMat = valoresInterfaz.getApellidoMaterno();
            datosBasicos.setVal_ape2(apeMat);
		}
		
		String nombre1 = null;
		if(valoresInterfaz.getNombrePrimero()==null || valoresInterfaz.getNombrePrimero().equals("")){
            if(esClienteNuevo)  {
                nombre1 = (String)valoresDefecto.get(IECM.ECM2_NOMBRE_PRIMERO);
            } else {
                nombre1 = datosBasicos.getVal_nom1();
                if (nombre1 == null) 
                    nombre1 = (String)valoresDefecto.get(IECM.ECM2_NOMBRE_PRIMERO);
            }
            
            datosBasicos.setVal_nom1(nombre1);            
		}else{
			nombre1 = valoresInterfaz.getNombrePrimero();
            datosBasicos.setVal_nom1(nombre1);
		}
		
		String nombre2 = null;
		if(valoresInterfaz.getNombreSegundo()==null || valoresInterfaz.getNombreSegundo().equals("")){
            if(esClienteNuevo)  {
                nombre2 = (String)valoresDefecto.get(IECM.ECM2_NOMBRE_SEGUNDO);
            } else {
                nombre2 = datosBasicos.getVal_nom2();
                if (nombre2 == null) 
                    nombre2 = (String)valoresDefecto.get(IECM.ECM2_NOMBRE_SEGUNDO);
            }
            datosBasicos.setVal_nom2(nombre2);
		}else{
			nombre2 = valoresInterfaz.getNombreSegundo();
            datosBasicos.setVal_nom2(nombre2);
		}
		
		String sexo = null;
		if(valoresInterfaz.getSexo()==null || valoresInterfaz.getSexo().equals("")){
            if(esClienteNuevo)  {
                sexo = (String)valoresDefecto.get(IECM.ECM2_SEXO);
            } else {
                sexo = datosBasicos.getCod_sexo();
                if (sexo == null) 
                    sexo = (String)valoresDefecto.get(IECM.ECM2_SEXO);
            }
            datosBasicos.setCod_sexo(sexo);            
		}else{
			sexo = valoresInterfaz.getSexo();
            datosBasicos.setCod_sexo(sexo);
		}

        //  Agregado por HRCS - Fecha 05/09/2007 - Cambio Sicc20070385
        DAOECM daoEcm = new DAOECM(); 
        if(esClienteNuevo) {
            Long oidTratamiento = daoEcm.obtenerOidDeDescripcion( "MAE_TIPO_TRATA", valoresInterfaz.getOidIdioma(), (String)valoresDefecto.get(IECM.ECM2_TRATAMIENTO) );
            datosBasicos.setVal_trat( (oidTratamiento!=null?oidTratamiento.toString():null) );
            
            Long oidFormaPago = daoEcm.obtenerOidDeDescripcion( "BEL_FORMA_PAGO", valoresInterfaz.getOidIdioma(), (String)valoresDefecto.get(IECM.ECM2_FORMA_PAGO) );
            datosBasicos.setFopa_oid_form_pago( oidFormaPago );
            
            java.sql.Date fecha = truncarFecha(new java.sql.Date(System.currentTimeMillis()));
            datosBasicos.setFec_ingr(new Timestamp(fecha.getTime()));
    
            datosBasicos.setPais_oid_pais(oidPais);
        } else {
            if(datosBasicos.getVal_trat() == null) {
                Long oidTratamiento = daoEcm.obtenerOidDeDescripcion( "MAE_TIPO_TRATA", valoresInterfaz.getOidIdioma(), (String)valoresDefecto.get(IECM.ECM2_TRATAMIENTO) );
                datosBasicos.setVal_trat( (oidTratamiento!=null?oidTratamiento.toString():null) );
            }

            if(datosBasicos.getFopa_oid_form_pago() == null) {
                Long oidFormaPago = daoEcm.obtenerOidDeDescripcion( "BEL_FORMA_PAGO", valoresInterfaz.getOidIdioma(), (String)valoresDefecto.get(IECM.ECM2_FORMA_PAGO) );
                datosBasicos.setFopa_oid_form_pago( oidFormaPago );
            }
            
        }
        
        // sapaza -- PER-SiCC-2013-0918 -- 21/08/2013
	datosBasicos.setInd_orig("Z");
        
	this.getClienteDatosBasicosLocalHome().merge(datosBasicos);

        UtilidadesLog.info("MONECMBean.mantenerClienteDatosBasicos(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, String codigoCliente, Long oidPais): Salida");		
		return datosBasicos.getOid();
	}
 
    /**
     * Modificado por HRCS - Fecha 06/09/2007 - Cambio Sicc20070385
     * Modificado por Sapaza - Fecha 24/09/2007 - Cambio Sicc20070416, modificamos para recibir el campo 
     *                          indicador de Correspondencia, y modificamos para que cada uno de los campos
     *                          recibidos, en caso que sea nuevo y venga vacio o en caso que exista y tenga
     *                          valor nulo, se grabe o actualice con el valor por defecto de ese campo.
     * @throws es.indra.mare.common.exception.MareException
     * @param oidPais
     * @param oidCliente
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
	private void mantenerClienteDatosAdicionales(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, Long oidCliente,Long oidPais) throws MareException {
        UtilidadesLog.info("MONECMBean.mantenerClienteDatosAdicionales(boolean esClienteNuevo,DTORegistroECM2 valoresInterfaz,Long oidCliente,Long oidPais): Entrada");
		DAOECM daoEcm = new DAOECM(); 
        
		ClienteDatosAdicionalesLocal datosAdicc = null;
        if (esClienteNuevo) {
            try{
                datosAdicc = this.getClienteDatosAdicionalesLocalHome().create(oidCliente,null,new java.sql.Date(System.currentTimeMillis()));	
                datosAdicc.setEsta_oid_esta_clie( ConstantesMAE.OID_ESTATUS_REGISTRADA );
                this.getClienteDatosAdicionalesLocalHome().merge(datosAdicc);
            }catch(PersistenceException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        else    {
            try{
                datosAdicc = this.getClienteDatosAdicionalesLocalHome().findByCliente(oidCliente);
            }catch(NoResultException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
		
        //Nacionalidad
        Long oidNacionalidad = null;
		if(valoresInterfaz.getNacionalidad()==null || valoresInterfaz.getNacionalidad().equals("")){
            if (esClienteNuevo) {
                oidNacionalidad = daoEcm.obtenerOidDeDescripcion("SEG_NACIO",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_NACIONALIDAD) );
            } else {
                oidNacionalidad = datosAdicc.getSnon_oid_naci();
                if (oidNacionalidad == null) 
                    oidNacionalidad = daoEcm.obtenerOidDeDescripcion("SEG_NACIO",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_NACIONALIDAD) );
            }
            datosAdicc.setSnon_oid_naci(oidNacionalidad);            
		}else{
            try{
                NacionalidadLocal nacionalidad = this.getNacionalidadLocalHome().findByUk(valoresInterfaz.getNacionalidad());
                oidNacionalidad = nacionalidad.getOid();
                datosAdicc.setSnon_oid_naci( oidNacionalidad );
            }catch(NoResultException f){
                UtilidadesLog.debug("No se encontro registro en BD del campo [nacionalidad] del cliente tratado");        
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }    
		}
        
        //Fecha de Nacimiento
		java.util.Date fechaN = null;
		if(valoresInterfaz.getFechaNacimiento()==null || valoresInterfaz.getFechaNacimiento().equals("")){
			if (esClienteNuevo) {
                fechaN =(java.util.Date)valoresDefecto.get(IECM.ECM2_FECHA_NACIMIENTO);
            } else {
                fechaN = datosAdicc.getFec_naci();
                if (fechaN == null) 
                    fechaN = (java.util.Date)valoresDefecto.get(IECM.ECM2_FECHA_NACIMIENTO);
            }
            datosAdicc.setFec_naci(new java.sql.Date(fechaN.getTime()));
		}else{
			fechaN = valoresInterfaz.getFechaNacimiento();
            datosAdicc.setFec_naci(new java.sql.Date(fechaN.getTime()));
		}
		
        //Estado Civil
        Long oidEstado = null;
		if(valoresInterfaz.getEstadoCivil()==null || valoresInterfaz.getEstadoCivil().equals("")){
            if (esClienteNuevo) {
                oidEstado = daoEcm.obtenerOidDeDescripcion("MAE_ESTAD_CIVIL",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_ESTADO_CIVIL) );
            } else {
                oidEstado = datosAdicc.getEscv_oid_esta_civi();
                if (oidEstado == null) 
                    oidEstado = daoEcm.obtenerOidDeDescripcion("MAE_ESTAD_CIVIL",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_ESTADO_CIVIL) );
            }
            datosAdicc.setEscv_oid_esta_civi(oidEstado);            
		}else{
            try{
                EstadoCivilLocal estado = this.getEstadoCivilLocalHome().findByUK(valoresInterfaz.getEstadoCivil());
                oidEstado = estado.getOid();
                datosAdicc.setEscv_oid_esta_civi( oidEstado );
            }catch(NoResultException f){
                UtilidadesLog.debug("No se encontro registro en BD del campo [estadoCivil] del cliente tratado");        
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }    
		}

        //Profesion
		String profesion = null;
		if(valoresInterfaz.getProfesion()==null || valoresInterfaz.getProfesion().equals("")){
            if (esClienteNuevo) {
                profesion = (String)valoresDefecto.get(IECM.ECM2_PROFESION);
            } else {
                profesion = datosAdicc.getVal_prof();
                if (profesion == null) 
                    profesion = (String)valoresDefecto.get(IECM.ECM2_PROFESION);
            }
            datosAdicc.setVal_prof(profesion);
		}else{
			profesion = valoresInterfaz.getProfesion();
            datosAdicc.setVal_prof(profesion);
		}
		
        //Ocupacion
        String ocupacion = null;
		if(valoresInterfaz.getOcupacion()==null || valoresInterfaz.getOcupacion().equals("")){
            if (esClienteNuevo) {
                ocupacion = (String)valoresDefecto.get(IECM.ECM2_OCUPACION);
            } else {
                ocupacion = datosAdicc.getVal_ocup();
                if (ocupacion == null) 
                    ocupacion = (String)valoresDefecto.get(IECM.ECM2_OCUPACION);
            }
            datosAdicc.setVal_ocup(ocupacion);            
		}else{
			ocupacion = valoresInterfaz.getOcupacion();
            datosAdicc.setVal_ocup(ocupacion);
		}
		
        //Centro de Trabajo
		String centroTrabajo = null;
		if(valoresInterfaz.getCentroTrabajo()==null || valoresInterfaz.getCentroTrabajo().equals("")){
            if (esClienteNuevo) {
                centroTrabajo = (String)valoresDefecto.get(IECM.ECM2_CENTRO_TRABAJO);
            } else {
                centroTrabajo = datosAdicc.getVal_cent_trab();
                if (centroTrabajo == null) 
                    centroTrabajo = (String)valoresDefecto.get(IECM.ECM2_CENTRO_TRABAJO);
            }
            datosAdicc.setVal_cent_trab(centroTrabajo);            
		}else{
			centroTrabajo = valoresInterfaz.getCentroTrabajo();
            datosAdicc.setVal_cent_trab(centroTrabajo);
		}
		
        //Cargo
		String cargo = null;
		if(valoresInterfaz.getCargo()==null || valoresInterfaz.getCargo().equals("")){
            if (esClienteNuevo) {
                cargo = (String)valoresDefecto.get(IECM.ECM2_CARGO);
            } else {
                cargo = datosAdicc.getVal_carg_dese();
                if (cargo == null) 
                    cargo = (String)valoresDefecto.get(IECM.ECM2_CARGO);
            }
            datosAdicc.setVal_carg_dese(cargo);            
		}else{
			cargo = valoresInterfaz.getCargo();
            datosAdicc.setVal_carg_dese(cargo);
		}
		
        //Nivel de Estudios
		Long oidNivelEstudio = null;        
		if(valoresInterfaz.getNivelEstudios()==null || valoresInterfaz.getNivelEstudios().equals("")){
            if (esClienteNuevo) {
                oidNivelEstudio = daoEcm.obtenerOidDeDescripcion("MAE_NIVEL_ESTUD",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_NIVEL_ESTUDIOS) );
            } else {
                oidNivelEstudio = datosAdicc.getNied_oid_nive_estu();
                if (oidNivelEstudio == null) 
                    oidNivelEstudio = daoEcm.obtenerOidDeDescripcion("MAE_NIVEL_ESTUD",valoresInterfaz.getOidIdioma(),(String)valoresDefecto.get(IECM.ECM2_NIVEL_ESTUDIOS) );
            }
            datosAdicc.setNied_oid_nive_estu(oidNivelEstudio);            
		}else{
            try{
                NivelEstudiosLocal nivelE = this.getNivelEstudiosLocalHome().findByUK(oidPais,valoresInterfaz.getNivelEstudios());
                oidNivelEstudio = nivelE.getOid();
                datosAdicc.setNied_oid_nive_estu( oidNivelEstudio );
            }catch(NoResultException f){
                UtilidadesLog.debug("No se encontro registro en BD del campo [NivelEstudios] del cliente tratado");        
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }    
		}

        //Centro de Estudios
		String centroE = null;
		if(valoresInterfaz.getCentroEstudios()==null || valoresInterfaz.getCentroEstudios().equals("")){
            if (esClienteNuevo) {
                centroE = (String)valoresDefecto.get(IECM.ECM2_CENTRO_ESTUDIOS);
            } else {
                centroE = datosAdicc.getVal_cent_estu();
                if (centroE == null) 
                    centroE = (String)valoresDefecto.get(IECM.ECM2_CENTRO_ESTUDIOS);
            }
            datosAdicc.setVal_cent_estu(centroE);            
		}else{
			centroE = valoresInterfaz.getCentroEstudios();
            datosAdicc.setVal_cent_estu(centroE);
		}

        //Numero de Hijos
		Long numeroHijos = null;
		if(valoresInterfaz.getNumeroHijos()==null || valoresInterfaz.getNumeroHijos().toString().equals("")){
            if (esClienteNuevo) {
                numeroHijos = (Long)valoresDefecto.get(IECM.ECM2_NUMERO_HIJOS);
            } else {
                numeroHijos = datosAdicc.getNum_hijo();
                if (numeroHijos == null) 
                    numeroHijos = (Long)valoresDefecto.get(IECM.ECM2_NUMERO_HIJOS);
            }
            datosAdicc.setNum_hijo(numeroHijos);            
		}else{
			numeroHijos = valoresInterfaz.getNumeroHijos();
            datosAdicc.setNum_hijo(numeroHijos);
		}
		
        //indicador de Correspondencia
		String indCorrespondencia = null;
		if(valoresInterfaz.getIndCorrespondencia()==null || valoresInterfaz.getIndCorrespondencia().equals("")){
            if (esClienteNuevo) {
                indCorrespondencia = (String)valoresDefecto.get(IECM.ECM2_IND_CORRESPONDENCIA);
            } else {
                if (datosAdicc.getInd_corr() == null) 
                    indCorrespondencia = (String)valoresDefecto.get(IECM.ECM2_IND_CORRESPONDENCIA);
                else
                    indCorrespondencia = datosAdicc.getInd_corr().toString();    
            }
            datosAdicc.setInd_corr(obtenerIndicadorDefectoL(indCorrespondencia));            
		}else{
			indCorrespondencia = valoresInterfaz.getIndCorrespondencia();
            datosAdicc.setInd_corr(obtenerIndicadorDefectoL(indCorrespondencia));
		}
                
	    // sapaza -- PER-SiCC-2013-0918 -- 21/08/2013
	    if (esClienteNuevo) 
                datosAdicc.setInd_acti(new Long(1));
            
	    this.getClienteDatosAdicionalesLocalHome().merge(datosAdicc);
        
		UtilidadesLog.info("MONECMBean.mantenerClienteDatosAdicionales(boolean esClienteNuevo,DTORegistroECM2 valoresInterfaz,Long oidCliente,Long oidPais): Salida");
	}

    /**
     * Revisado por HRCS - Fecha 07/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param numeroDocumento
     * @param oidTipoDocumento
     * @param oidCliente
     */
	private void crearClienteIdentificacion (Long oidCliente, Long oidTipoDocumento, String numeroDocumento) throws MareException {
        UtilidadesLog.info("MONECMBean.crearClienteIdentificacion(Long oidCliente, Long oidTipoDocumento, String numeroDocumento): Entrada");
		
		ClienteIdentificacionLocal identificacion = null;
		try{
			identificacion = this.getClienteIdentificacionLocalHome().create(oidTipoDocumento,oidCliente,numeroDocumento,new Long(1),new java.sql.Date(System.currentTimeMillis()));
		}catch(PersistenceException c){
			ctx.setRollbackOnly();
			UtilidadesLog.error(c);
			throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
        UtilidadesLog.info("MONECMBean.crearClienteIdentificacion(Long oidCliente, Long oidTipoDocumento, String numeroDocumento): Salida");
	}
    
    /**
     * Modificado por HRCS - Fecha 07/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidSubTipoCliente
     * @param oidTipoCliente
     * @param oidCliente
     * @param esClienteNuevo
     */
	private Long mantenerClienteTipoSubtipo(boolean esClienteNuevo, Long oidCliente, Long oidTipoCliente, Long oidSubTipoCliente) throws MareException{
        UtilidadesLog.info("MONECMBean.mantenerClienteTipoSubtipo(boolean esClienteNuevo, Long oidCliente, Long oidTipoCliente, Long oidSubTipoCliente): Entrada");
		
        boolean noExiste = false;
        ClienteTipoSubTipoLocal subTipo = null;
        //  Valida si es cliente nuevo
        if (esClienteNuevo) {
            noExiste = true;
        }
        else    {
            try{
                subTipo = this.getClienteTipoSubTipoLocalHome().findByUK( oidCliente, oidTipoCliente );
                if (subTipo.getSbti_oid_subt_clie().longValue() != oidSubTipoCliente.longValue())   {
                    noExiste = true;
                }
            }catch(NoResultException c){
                noExiste = true;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        //  Si no existe el registro de tipo y subtipo de cliente
        if (noExiste)   {
            try{
                subTipo = this.getClienteTipoSubTipoLocalHome().create(oidCliente,oidTipoCliente,oidSubTipoCliente,new Long(0),new java.sql.Date(System.currentTimeMillis()));
            }catch(PersistenceException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
		UtilidadesLog.info("MONECMBean.mantenerClienteTipoSubtipo(boolean esClienteNuevo, Long oidCliente, Long oidTipoCliente, Long oidSubTipoCliente): Salida");
		return subTipo.getOid(); 
	}
    
    /**
     * Modificado por HRCS - Fecha 07/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param oidClienteTipoSubTipo
     * @param oidCliente
     * @param oidSubtipoCliente
     * @param oidPais
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
	private void mantenerClienteClasificacion(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, Long oidPais,Long oidSubtipoCliente,
                                              Long oidCliente, Long oidClienteTipoSubTipo, Long oidMarca, Long oidCanal) throws MareException   {
        UtilidadesLog.info("MONECMBean.mantenerClienteClasificacion(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, Long oidPais,Long oidSubtipoCliente, "+
                           "Long oidCliente, Long oidClienteTipoSubTipo, Long oidMarca, Long oidCanal): Entrada");
       
		MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		TipoClasificacionLocal tipoClasi = null;
		ClasificacionLocal clasificacion = null;
		Long oidClasificacion = null;
		Long oidTipoClasificacion = null;
		try{
            //  Primero: recuperamos el oid de tipo de clasificacion y el oid de clasificacion
            UtilidadesLog.debug("*** valoresInterfaz.getTipoClasificacion(): "+valoresInterfaz.getTipoClasificacion());
            UtilidadesLog.debug("*** oidSubtipoCliente: "+oidSubtipoCliente);
			tipoClasi = this.getTipoClasificacionLocalHome().findByUK(valoresInterfaz.getTipoClasificacion(),oidSubtipoCliente);
            oidTipoClasificacion = tipoClasi.getOid();
            UtilidadesLog.debug("*** oidTipoClasificacion: "+oidTipoClasificacion);
            UtilidadesLog.debug("*** valoresInterfaz.getClasificacion(): "+valoresInterfaz.getClasificacion());
			clasificacion = this.getClasificacionLocalHome().findByUK(oidTipoClasificacion,valoresInterfaz.getClasificacion());
            UtilidadesLog.debug("*** clasificacion: "+clasificacion);
			oidClasificacion = clasificacion.getOid();
            UtilidadesLog.debug("*** oidClasificacion: "+oidClasificacion);
			
            //  Segundo: obtiene el periodo actual
            RecordSet rs = this.getMONClientes().obtenerPeriodoActualPorFecha( oidPais, oidMarca, oidCanal );
            Long periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
            
            boolean creaClasificacion = false;
            if (esClienteNuevo) {
            //  Tercero: Si es cliente nuevo, crea directamente la clasificacion
                creaClasificacion = true;
            }
            else    {
            // Cuarto: Si ya existe el cliente, se valida si ya tiene la clasificacion antes de grabar
                try {
                    ClienteClasificacionLocal clienClasi = this.getClienteClasificacionLocalHome().findByUK( oidTipoClasificacion, oidClienteTipoSubTipo );
                    if (clienClasi.getClas_oid_clas().longValue() != oidClasificacion.longValue())    {
                        creaClasificacion = true;
                    }
                } catch(NoResultException fe) {
                    creaClasificacion = true; 
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }

            // Quinto: crea una clasificacion para el cliente            
            if (creaClasificacion)   {
                ClienteClasificacionLocal cliente = null;
                try{
                    cliente = this.getClienteClasificacionLocalHome().create(oidClienteTipoSubTipo,
                                                                             oidClasificacion,
                                                                             periodoActual,
                                                                             oidTipoClasificacion,
                                                                             ConstantesINT.INDICADOR_DESACTIVO, // no principal
                                                                             new java.sql.Date(System.currentTimeMillis()));
                    java.sql.Date fecha = truncarFecha(new java.sql.Date(System.currentTimeMillis()));
                    cliente.setFec_clas(new Timestamp(fecha.getTime()));
                    this.getClienteClasificacionLocalHome().merge(cliente);
                        
                }catch(PersistenceException c){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(c);
                    throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            
		}catch(NoResultException f){
            UtilidadesLog.debug("No se graba en MAE_CLIEN_CLASI porque no se encontro tipo de clasificacion y/o clasificacion.");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException ne){
            UtilidadesLog.error(ne);
            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONECMBean.mantenerClienteClasificacion(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz, Long oidPais,Long oidSubtipoCliente,"+
                           "Long oidCliente, Long oidClienteTipoSubTipo, Long oidMarca, Long oidCanal): Salida");
	}

    /**
     * Nuevo metodo creado por HRCS - Fecha 07/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param oidCliente
     * @param oidPais
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
    private void mantenerClienteViaUbigeo(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidPais,Long oidCliente) throws MareException {
    
        UtilidadesLog.info("MONECMBean.mantenerClienteViaUbigeo(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidPais,Long oidCliente): Entrada");
       
        TipoViaLocal tipoVia = null;
        ViaLocal via = null;
        ValoresEstructuraGeopoliticaLocal valEstGeo = null;
        Collection coleccionVia = null;
        Collection coleccionEstGeo = null;
        Collection coleccionDirec = null;
        Long oidTipoVia = null;
        Long oidVia = null;
        try{
            //  Primero: Validamos si existe el tipo de via que viene en la interfaz
            tipoVia = this.getTipoViaLocalHome().findByUK(valoresInterfaz.getTipoVia());
            oidTipoVia = tipoVia.getOid();
            
            //  Segundo: Vamos a traducir el nombre de la via por el oid de ZON VIA
            coleccionVia = this.getViaLocalHome().findByPaisNombreTipoVia(valoresInterfaz.getNombreVia(), oidTipoVia,oidPais);
            if(coleccionVia.size() > 0){
                via = (ViaLocal) coleccionVia.iterator().next();
                oidVia= via.getOid();   //  Recupera el primero
            }
            
            //  Tercero: Comprobamos si existe el codigo ubigeo
            String ubiGeo = (String) valoresInterfaz.getUbiGeo();
            UtilidadesLog.debug("UbigeoRecuperado: ["+ubiGeo+"]");
            if (ubiGeo!=null)   {

                int lonUbigeo = ubiGeo.length();
                int numPartes = lonUbigeo/6;
                
                String parte1 = ubiGeo.substring( 0, 6 );
                String parte2 = ubiGeo.substring( 6, 12 );
                String parte3 = ubiGeo.substring( 12, 18 );
                String parte4 = null;
                if (numPartes>3)
                    parte4 = ubiGeo.substring( 18, 24 );
                
                UtilidadesLog.debug("Partes Ubigeo: ["+parte1+"]-["+parte2+"]-["+parte3+"]-["+parte4+"]");
                coleccionEstGeo = this.getValoresEstructuraGeopoliticaLocalHome().findByUbigeo( parte1, parte2, parte3, parte4, 
                                                                                                null, null, null, null, null, oidPais);
                UtilidadesLog.debug("Encontro ("+ coleccionEstGeo.size() +") que coinciden con el ubigeo");
                if (coleccionEstGeo.size()>0)   {
                    valEstGeo = (ValoresEstructuraGeopoliticaLocal)coleccionEstGeo.iterator().next();
                    UtilidadesLog.debug("Oid del Val_Est_Geo:" + valEstGeo.getOid() );
                    UtilidadesLog.debug("Descrip del Val_Est_Geo:" + valEstGeo.getDes_geog() );
                }
                
                //  Cuarto: Obtenemos el territorio en base a la via y tipo de via
                DAOECM dao = new DAOECM();
                RecordSet terri = dao.obtenerTerritorioPorVia(oidTipoVia,valoresInterfaz.getNombreVia(),valoresInterfaz.getNumeroPrincipal(),oidPais);
                Long territorio = null;
                if (terri!=null && !terri.esVacio() && terri.getValueAt(0,"TERR_OID_TERR")!=null)
                    territorio = new Long(((BigDecimal)terri.getValueAt(0,"TERR_OID_TERR")).toString());
                UtilidadesLog.debug("territorio encontrado: ["+territorio+"]");
                
                //  Quinto: Valida si existe una direccion activa en el cliente
                if (!esClienteNuevo) {
                    coleccionDirec = this.getClienteDireccionLocalHome().findDireccionPrincipalCliente(oidCliente);
                    Iterator ite = coleccionDirec.iterator();
                    while(ite.hasNext()) {
                        ClienteDireccionLocal clieDirec = (ClienteDireccionLocal)ite.next();
                        UtilidadesLog.debug("Direccion encontrada: ["+clieDirec.getOid()+"]");
                        Long indElim = clieDirec.getInd_elim();
                        if (indElim!=null && indElim.intValue()!=ConstantesINT.INDICADOR_ACTIVO.longValue())    {
                            //  No funciona con Entity, se cambio a UPDATE
                            //clieDirec.setInd_elim( new Long(ConstantesINT.INDICADOR_ACTIVO.longValue()) );  //  Setea direccion como eliminada
                            dao.eliminarDireccionCliente(clieDirec.getOid());
                        }
                    }
                }
    
                // Sexto: Graba la direccion del cliente
                ClienteDireccionLocal direccion = null;
                try{
                    direccion = this.getClienteDireccionLocalHome().create(oidCliente,
                                                                    dao.obtenerOidTipoDireccion(ConstantesMAE.COD_TIPO_DIRECCION_DOMICILIO),
                                                                    oidTipoVia,
                                                                    new java.sql.Date(System.currentTimeMillis()), 
                                                                    ubiGeo);
                    direccion.setTerr_oid_terr(territorio);
                    direccion.setVal_nomb_via(valoresInterfaz.getNombreVia());
                    direccion.setInd_dire_ppal( ConstantesINT.INDICADOR_ACTIVO );
                    direccion.setInd_elim( ConstantesINT.INDICADOR_DESACTIVO );
                    
                    if (valoresInterfaz.getNumeroPrincipal() != null)
                        direccion.setNum_ppal(valoresInterfaz.getNumeroPrincipal());
                    if(oidVia != null)
                        direccion.setZvia_oid_via(oidVia);
                    this.getClienteDireccionLocalHome().merge(direccion);
                        
                }catch(PersistenceException c){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(c);
                    throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }catch(NoResultException f){
            UtilidadesLog.debug("No se graba en MAE_CLIEN_DIREC por no encontrarse el tipo de via y ubigeo.");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(StringIndexOutOfBoundsException se)  {
            se.printStackTrace();
            UtilidadesLog.debug("No se graba en MAE_CLIEN_DIREC porque encontro un error al leer el ubigeo.");
        }
        UtilidadesLog.info("MONECMBean.mantenerClienteViaUbigeo(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidPais,Long oidCliente): Salida");
    }

    /**
     * Nuevo metodo que unifica la validacion de comunicacion y la creacion en Cliente Comunicacion
     * Fecha 10/09/2007 - Cambio Sicc20070385
     * Fecha 10/09/2007 - Cambio Sicc20070416 (Sapaza), se recupera indicador de comunicacion principal
     *                    y si tiene valor, 
     * @throws es.indra.mare.common.exception.MareException
     * @param oidTipoComunicacion
     * @param oidCliente
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
	private void mantenerClienteComunicacion(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidCliente) throws MareException {
        UtilidadesLog.info("MONECMBean.mantenerClienteComunicacion(Long oidCliente, Long oidTipoComunicacion): Entrada");
				
		Long oidTipoComunicacion = null;
		TipoComunicacionLocal tipoComunicacion = null;
		try{
            //  Recupera el oid de tipo de comunicacion
			tipoComunicacion = this.getTipoComunicacionLocalHome().findByUK(valoresInterfaz.getCodigoTipoComunicacion());
            oidTipoComunicacion = tipoComunicacion.getOid();
            UtilidadesLog.debug("ClienteComunicacion oidCliente:" + oidCliente + " - oidTipoComunicacion:" + oidTipoComunicacion);
            ClienteComunicacionLocal cliente = null;
            
            //  Valida si ya existe el registro en cliente comunicacion
            boolean creaRegistro = false;
            if (esClienteNuevo) {
                creaRegistro = true;
            }
            else    {
                try {
                    cliente = this.getClienteComunicacionLocalHome().findByUK(oidCliente,oidTipoComunicacion);
                    
                    if(valoresInterfaz.getTextoMedioComunicacion()!=null && !valoresInterfaz.getTextoMedioComunicacion().equals("")){
                        cliente.setVal_text_comu(valoresInterfaz.getTextoMedioComunicacion());
                        //sb
                        cliente.setIndicadorConfirmacion(valoresInterfaz.getIndicadorConfirmacion().equals("1")?"1":"0");
                    }    
                        this.getClienteComunicacionLocalHome().merge(cliente);
                        
                } catch(NoResultException fe) {
                    creaRegistro = true;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

                }
            }

            //  Primero validamos si tiene ya algun registro Activo como Pricipal
            DAOECM dao = new DAOECM();
            Long oidClieComuPrin = dao.obtenerOidClienteComunicacionPrincipal(oidCliente);
            
            //  Graba Cliente Comunicacion
            if (creaRegistro)   {
                //  Pasamos a crear el nuevo registro en Cliente Comunicacion
                try{
                    cliente = this.getClienteComunicacionLocalHome().create(oidCliente,oidTipoComunicacion,new java.sql.Date(System.currentTimeMillis()));
                    cliente.setVal_text_comu(valoresInterfaz.getTextoMedioComunicacion());
                    //sb
                    cliente.setIndicadorConfirmacion(valoresInterfaz.getIndicadorConfirmacion().equals("1")?"1":"0");                    
                    this.getClienteComunicacionLocalHome().merge(cliente);
                }catch(PersistenceException c){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(c);
                    throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            
            if (valoresInterfaz.getIndComunicacionPrincipal()!=null && !valoresInterfaz.getIndComunicacionPrincipal().equals(""))    {
                Long indicador = obtenerIndicadorDefectoL(valoresInterfaz.getIndComunicacionPrincipal());

                //  Valida si esta Activo el Indicador Principal
                if (indicador!=null && indicador.longValue()==ConstantesINT.INDICADOR_ACTIVO.longValue()) {
                    if (oidClieComuPrin!=null)  {
                        //  Actualizando un registro de Cliente Comunicacion como No Principal
                        UtilidadesLog.debug("Actualizando el registro de Cliente-Comunicacion:["+oidClieComuPrin+"] como No Principal.");
                        ClienteComunicacionLocal clieComu = this.getClienteComunicacionLocalHome().findByPrimaryKey(oidClieComuPrin);
                            clieComu.setInd_comu_ppal( ConstantesINT.INDICADOR_DESACTIVO );
                    }
                }
                cliente.setInd_comu_ppal(indicador);
                this.getClienteComunicacionLocalHome().merge(cliente);
                
            }
            
		}catch(NoResultException f){
            UtilidadesLog.debug("No se graba en MAE_CLIEN_COMUN porque no se encontro el tipo de comunicacion.");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		UtilidadesLog.info("MONECMBean.mantenerClienteComunicacion(Long oidCliente, Long oidTipoComunicacion): Salida");
	}

    /**
     * Modificado por HRCS - Fecha 10/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param oidCanal
     * @param oidMarca
     * @param oidPais
     * @param oidClienteTipoSubtipo
     * @param oidCliente
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
	private void mantenerClienteContacto(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal) throws MareException{
        UtilidadesLog.info("MONECMBean.mantenerClienteContacto(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal): Entrada");

        //  Primero: recuperamos los parametros de la interface
        String tipoContacto = valoresInterfaz.getCodigoTipoContacto();
        java.util.Date fechaContacto = valoresInterfaz.getFechaContacto();
        
        //if (((tipoContacto.equals("0") || (tipoContacto.equals("1"))) && (fechaContacto != null))){
        if (tipoContacto!=null && fechaContacto!=null)  {
            try {
                //  Segundo: obtiene el periodo actual
                RecordSet rs = this.getMONClientes().obtenerPeriodoActualPorFecha( oidPais, oidMarca, oidCanal );
                Long periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
                UtilidadesLog.debug("ClientePrimerContacto oidCliente:" + oidCliente + " - tipoContacto:" + tipoContacto + " - periodoActual:"+ periodoActual);
                ClientePrimerContactoLocal cliente = null;
                
                //  Tercero: anzalimos si ya existe un registro en Cliente Primer Contacto
                boolean creaRegistro = false;
                if (esClienteNuevo) {
                    creaRegistro = true;
                }
                else    {
                    try {
                        cliente = this.getClientePrimerContactoLocalHome().findByCliente(oidCliente);
                        cliente.setCod_tipo_cont(tipoContacto.toString());
                        this.getClientePrimerContactoLocalHome().merge(cliente);
                    } catch(NoResultException fe) {
                        creaRegistro = true;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
                
                if (creaRegistro)   {
                    //  Cuarto: recuperamos el oid de tipo subtipo del cliente vinculo
                    String codigoClienteVinculo = valoresInterfaz.getCodigoClienteVinculo();
                    Long oidClienteVinculo = null;
                    try{
                        oidClienteVinculo = this.getClienteDatosBasicosLocalHome().findByUK(oidPais,codigoClienteVinculo).getOid();
                    } catch(NoResultException f) {
                    } catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    DAOECM dao = new DAOECM();
                    Long oidTipoSubtClienteVinculo = dao.obtenerOidTipoSubtiParaContacto(oidClienteVinculo);
                    
                    //  Quinto: graba el registro en Cliente - Primer Contacto
                    try{
                        cliente = this.getClientePrimerContactoLocalHome().create(oidCliente,oidTipoSubtClienteVinculo, new java.sql.Date(System.currentTimeMillis()));
                        cliente.setFec_cont(new Timestamp(fechaContacto.getTime()));
                        cliente.setCod_tipo_cont(tipoContacto.toString());
                        cliente.setMarc_oid_marc( oidMarca );
                        cliente.setCana_oid_cana( oidCanal );
                        cliente.setPerd_oid_peri( periodoActual );
                        this.getClientePrimerContactoLocalHome().merge(cliente);
                    }catch(PersistenceException c){
                        ctx.setRollbackOnly();
                        UtilidadesLog.error(c);
                        throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                }
            }catch(RemoteException ne){
                UtilidadesLog.error(ne);
                throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        UtilidadesLog.info("MONECMBean.mantenerClienteContacto(boolean esClienteNuevo, DTORegistroECM2 valoresInterfaz,Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal): Salida");
	}
 
    /**
     * Modificado por HRCS - Fecha 10/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param canal
     * @param marca
     * @param oidSubtipoCliente
     * @param oidTipoCliente
     * @param oidPais
     * @param oidCliente
     * @param valoresInterfaz
     * @param esClienteNuevo
     */
	private void mantenerClienteVinculo(boolean esClienteNuevo,DTORegistroECM2 valoresInterfaz,IRegistroSicc registro,InterfazInfo info,
                                        Long oidCliente,Long oidPais,Long oidTipoCliente, Long oidSubtipoCliente, Long oidMarca, Long oidCanal) throws MareException,ECM2Exception {
        UtilidadesLog.info("MONECMBean.mantenerClienteVinculo(boolean esClienteNuevo,DTORegistroECM2 valoresInterfaz,IRegistroSicc registro,InterfazInfo info,"+
                           "Long oidCliente,Long oidPais,Long oidTipoCliente, Long oidSubtipoCliente, Long oidMarca, Long oidCanal): Entrada");
		
		ClienteDatosBasicosLocal datos = null;
        Long oidClienteVinculo = null;
		try{
			datos = this.getClienteDatosBasicosLocalHome().findByUK(oidPais,valoresInterfaz.getCodigoClienteVinculo());
    		oidClienteVinculo = datos.getOid();
		}catch(NoResultException f){
			UtilidadesLog.debug(f);
            UtilidadesLog.debug("Codigo Cliente Vinculo No existe");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		TipoVinculoLocal tipoVinculo = null;
		Long tipoVin = null;
        Long tipoVinDuplaCyzone = null;
        try{
			tipoVinculo = this.getTipoVinculoLocalHome().findByUK(oidPais,valoresInterfaz.getCodigoTipoVinculo());
            tipoVin = tipoVinculo.getOid();
            tipoVinculo = this.getTipoVinculoLocalHome().findByUK(oidPais,ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE);
            tipoVinDuplaCyzone = tipoVinculo.getOid();
		}catch(NoResultException f){
			UtilidadesLog.debug(f);
            UtilidadesLog.debug("Codigo Tipo Vinculo No existe");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		
		TipoClienteLocal tipoCliente = null;
        Long tipoClienteConsultora = null;
        Long tipoClienteHijaDupla = null;
        try{
            tipoCliente = this.getTipoClienteLocalHome().findByUK(ConstantesMAE.TIPO_CLIENTE_CONSULTORA);
            tipoClienteConsultora = tipoCliente.getOid();
            tipoCliente = this.getTipoClienteLocalHome().findByUK(ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA);
            tipoClienteHijaDupla = tipoCliente.getOid();
		}catch(NoResultException f){
			UtilidadesLog.debug(f);
            UtilidadesLog.debug("Codigo Tipo Cliente No existe");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}

		SubtipoClienteLocal subtipoCliente = null;
        Long subTipoClienteConsultoraNegocio = null;
        Long subTipoClienteHijaDupla = null;
        try{
            subtipoCliente = this.getSubtipoClienteLocalHome().findByUK(ConstantesMAE.CODIGO_CONSULTORA_TIPO_NEGOCIO, tipoClienteConsultora);
            subTipoClienteConsultoraNegocio = subtipoCliente.getOid();
            subtipoCliente = this.getSubtipoClienteLocalHome().findByUK(ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA, tipoClienteHijaDupla);
            subTipoClienteHijaDupla = subtipoCliente.getOid();
		}catch(NoResultException f){
			UtilidadesLog.debug(f);
            UtilidadesLog.debug("Codigo SubTipo Cliente No existe");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
        
        if(oidClienteVinculo != null && tipoVin != null){
            //  Agregado por HRCS - Fecha 04/04/2007 - Cambio Sicc20070184
            boolean pasoValidaciones = true;
            if (tipoVin.longValue()==tipoVinDuplaCyzone.longValue())    {   //  Si es Tipo de Vinculo DuplaCyzone
                
                MONGestorInterfaces gi = this.getMONGestorInterfaces();
                //  Valida que el tipo de cliente sea "Hija Dupla"
                UtilidadesLog.debug("tipoVin: ["+tipoVin+"] - oidTipoCliente: ["+ oidTipoCliente +"] - oidSubtipoCliente: ["+ oidSubtipoCliente +"]");
                if ( (oidTipoCliente.longValue()!=tipoClienteHijaDupla.longValue()) || 
                     (oidSubtipoCliente.longValue()!=subTipoClienteHijaDupla.longValue()) )  {
                    pasoValidaciones = false;
                    DTOINTError dtoError = new DTOINTError (info,registro,ErroresDeNegocio.INT_0116);
                    try{
                        gi.registrarError(dtoError);
                        ctx.setRollbackOnly();
                        throw new ECM2Exception( ErroresDeNegocio.INT_0116, null );
                    }catch (InterfacesException ie){
                        UtilidadesLog.error("Excepcion de la Interfaz en MONECM.crearClienteVinculo: "+ ie.getMotivo() ,ie);
                    }catch(RemoteException re){
                            UtilidadesLog.error(re);
                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                    }
                }
                if (pasoValidaciones)   {
                    // comprobamos que existen el Tipo y Subtipo de Cliente que vienen en la interfaz 
                    ClienteTipoSubTipoLocal clienteTipoSubtipo;
                    try{
                        clienteTipoSubtipo = this.getClienteTipoSubTipoLocalHome().findByUK( oidClienteVinculo, tipoClienteConsultora );
                        UtilidadesLog.debug("oidClienteTipoSubtiConsultora: ["+ clienteTipoSubtipo.getOid() +"] - oidClienteVinculo: ["+ oidClienteVinculo +"]");
                    }catch(NoResultException fex) {
                        pasoValidaciones = false;
                        DTOINTError dtoError = new DTOINTError (info,registro,ErroresDeNegocio.INT_0122);
                        try{
                            gi.registrarError(dtoError);
                            ctx.setRollbackOnly();
                            throw new ECM2Exception( ErroresDeNegocio.INT_0122, null );
                        }catch (InterfacesException ie){
                            UtilidadesLog.error("Excepcion de la Interfaz en MONECM.crearClienteVinculo: "+ ie.getMotivo() ,ie);
                        }catch(RemoteException re){
                                UtilidadesLog.error(re);
                                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            }
            //  Valida que haya pasado las 2 validaciones
            if (pasoValidaciones)   {
                try {

                    java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
                                    
                    //  Agregado por HRCS - Fecha 27/08/2007 - Cambio Sicc20070361
                    //
                    if (tipoVin.longValue()==tipoVinDuplaCyzone.longValue())    {   //  Si es Tipo de Vinculo DuplaCyzone

                        //  Variable que indica si continua con el proceso
                        boolean continua = true;
                        if (!esClienteNuevo)    {
                            if (this.getMONClientes().existeClienteVinculo(oidPais,
                                                           oidClienteVinculo, // vinculante = madre
                                                           oidCliente,  // vinculando = hija
                                                           tipoVin,
                                                           new Boolean(true)))   {
                                continua = false;
                            }
                        }
                        
                        if (continua)   {
                            //  Obtiene el periodo actual
                            RecordSet rs = this.getMONClientes().obtenerPeriodoActualPorFecha( oidPais, oidMarca, oidCanal );
                            Long periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
                            //  Validar si ya existe un vinculo para la Madre
                            Long oidRegistroClienteVinculo = this.getMONClientes().buscarClienteVinculoDuplaCyzone( oidClienteVinculo, now);
                            if (oidRegistroClienteVinculo!=null)    {
                                //  Actualizar Vinculo de la Madre
                                this.getMONClientes().actualizarFechaHastaClienteVinculo( oidRegistroClienteVinculo );
                            }
                            else    {
                                //  Insertar Nueva Clasificacion Dupla Cyzone de la Madre
                                this.getMONClientes().crearClasificacionDuplaCyzone( oidClienteVinculo, periodoActual, now);
                            }
                            
                            if (!esClienteNuevo) {
                                //  Busca si la hija ya tenia un vinculante, para actualizarlo y borrarle su clasificacion DuplaCyzone
                                this.getMONClientes().actualizarAnteriorVinculanteDuplaCyzone( oidCliente, now);
                            }
                            
                            //  Comunicar Bienvenida Dupla
                            this.getMONClientes().comunicarBienvenidaDuplaCyzone( oidClienteVinculo, oidPais, ConstantesSEG.IDIOMA_DEFECTO );
                            
                            ClienteVinculoLocal clienteVinculoL = null;
                            //  Busca si tiene ya un registro en cliente vinculo que este cerrado (fechaHasta no nula)
                            if (this.getMONClientes().existeClienteVinculo( oidPais,
                                                           oidClienteVinculo, // vinculante = madre
                                                           oidCliente,  // vinculando = hija
                                                           tipoVin,
                                                           new Boolean(false)))   {
                                clienteVinculoL = this.getClienteVinculoLocalHome().findByUK( oidClienteVinculo, oidCliente, tipoVin );
                            }
                            else    {
                                //  Crear el nuevo vinculo de Dupla Cyzone con fecha hasta = null
                                clienteVinculoL = this.getClienteVinculoLocalHome().create(oidClienteVinculo,
                                                                          oidCliente,
                                                                          tipoVin,
                                                                          now);
                            }
                            
                            clienteVinculoL.setFec_desd(new Timestamp(valoresInterfaz.getFechaDesde().getTime()));
                            clienteVinculoL.setFec_hast(null);
                            Long indicador = null;
                            if (valoresInterfaz.getIndVinculoPrincipal().equalsIgnoreCase(ConstantesINT.S)) indicador = new Long(1);
                            else indicador= new Long(0);
                            clienteVinculoL.setInd_vinc_ppal(indicador);
                            this.getClienteVinculoLocalHome().merge(clienteVinculoL);
                        }
                        else    {
                            UtilidadesLog.error("El cliente ya tiene un vinculo DuplaCyzone con los datos ingresados. Como no se ha modificado entonces no se actualiza.");
                        }
                    }
                    //  Si NO es tipo de vinculo DuplaCyzone, entonces se procede a insertar o actualizar
                    //
                    else    {
                        boolean creaRegistro = false;
                        ClienteVinculoLocal cliente = null;
                        
                        if (esClienteNuevo) {
                            creaRegistro = true;
                        }
                        //  En caso el cliente no sea nuevo, se procede a validar si tiene ya un vinculo del tipo recomendante/recomendada
                        else    {
                            if (!this.getMONClientes().existeClienteVinculo(oidPais,
                                                           oidClienteVinculo, // vinculante = madre
                                                           oidCliente,  // vinculando = hija
                                                           tipoVin,
                                                           null))   {    // Sin fechas
                                DAOECM dao = new DAOECM();
                                Long oidVinculoClienteReco = dao.buscarClienteVinculoRecomendante(oidCliente,now);
                                //  Si encontra un registro entonces se actualiza...
                                if (oidVinculoClienteReco!=null)    {
                                    try {
                                        ClienteVinculoLocal clienVincu = this.getClienteVinculoLocalHome().findByPrimaryKey(oidVinculoClienteReco);
                                        clienVincu.setClie_oid_clie_vnte( oidCliente );
                                        clienVincu.setFec_desd(new Timestamp(valoresInterfaz.getFechaDesde().getTime()));
                                        clienVincu.setFec_hast(new Timestamp(valoresInterfaz.getFechaHasta().getTime()));
                                        this.getClienteVinculoLocalHome().merge(clienVincu);
                                    } catch(NoResultException fe) {
                                        UtilidadesLog.debug("No se encontro el oid cliente vinculo 'recomendante': (" + oidVinculoClienteReco + ")");
                                    }  catch (PersistenceException ce) {   
                                        UtilidadesLog.error("ERROR ", ce);
                                        throw new MareException(ce, 
                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                    }
                                }
                                else    {
                                    creaRegistro = true;
                                }
                            }
                            else    {
                                UtilidadesLog.error("El cliente ya tiene un vinculo con los datos ingresados. Como no se ha modificado entonces no se actualiza.");
                            }
                        }
                        
                        //  Graba el cliente - vinculo nuevo
                        //
                        if (creaRegistro)   {
                            
                            cliente = this.getClienteVinculoLocalHome().create(oidClienteVinculo,oidCliente,tipoVin,now);
                            UtilidadesLog.debug("Creando Cliente Vinculo: ( oid=" + oidClienteVinculo + ", cliente=" + oidCliente + " ... )");
                            
                            cliente.setFec_desd(new Timestamp(valoresInterfaz.getFechaDesde().getTime()));
                            cliente.setFec_hast(new Timestamp(valoresInterfaz.getFechaHasta().getTime()));

                            
                            Long indicador = null;
                            if (valoresInterfaz.getIndVinculoPrincipal().equalsIgnoreCase(ConstantesINT.S)) {
                                indicador = new Long(1);
                            }
                            else {
                                indicador= new Long(0);
                            }
                            cliente.setInd_vinc_ppal(indicador);
                            this.getClienteVinculoLocalHome().merge(cliente);                            
                        }
                    }
                }
                catch(RemoteException re)   {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(re); 
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB; 
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
                }catch(NoResultException c){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(c);
                    throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }catch(PersistenceException c){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(c);
                    throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            else    {
                UtilidadesLog.debug("Se aborta la grabacion del registro con OID: " + oidCliente.longValue() );
             }
        }
        else    {
            UtilidadesLog.debug("No se graba en MAE_CLIEN_VINCU porque no OidClienteVinculo o OidTipoVinculo es nulo.");
        }
        UtilidadesLog.info("MONECMBean.mantenerClienteVinculo(boolean esClienteNuevo,DTORegistroECM2 valoresInterfaz,IRegistroSicc registro,InterfazInfo info,"+
                           "Long oidCliente,Long oidPais,Long oidTipoCliente, Long oidSubtipoCliente, Long oidMarca, Long oidCanal): Salida");
	}

    /**
     * Nuevo metodo que inserta en Cliente Estatus si es nuevo
     * Agregado HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param oidCanal
     * @param oidMarca
     * @param oidPais
     * @param oidCliente
     */
	private void insertarClienteEstatus(Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal) throws MareException{
        UtilidadesLog.info("MONECMBean.insertarClienteEstatus(Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal): Entrada");

        try {
            //  Obtiene el periodo actual
            RecordSet rs = this.getMONClientes().obtenerPeriodoActualPorFecha( oidPais, oidMarca, oidCanal );
            Long periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
            
            //  Creamos el Cliente Estatus
            this.getClienteHistoricoEstatusLocalHome().create(oidCliente, ConstantesMAE.OID_ESTATUS_REGISTRADA, periodoActual, null);
            
        }catch(PersistenceException c){
            ctx.setRollbackOnly();
            UtilidadesLog.error(c);
            throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }catch(RemoteException re)   {
            ctx.setRollbackOnly();
            UtilidadesLog.error(re); 
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONECMBean.insertarClienteEstatus(Long oidCliente,Long oidPais, Long oidMarca, Long oidCanal): Salida");
	}
    
    /**
     * Modificado por Sapaza - Fecha 21/09/2007 - Cambio Sicc20070416
     * @throws es.indra.mare.common.exception.MareException
     * @param esClienteNuevo
     * @param oidCliente
     * @param oidMarca
     */
	private void mantenerClienteMarca(boolean esClienteNuevo, Long oidCliente, Long oidMarca) throws MareException {
        UtilidadesLog.info("MONECMBean.mantenerClienteMarca(boolean esClienteNuevo, Long oidCliente,Long oidMarca): Entrada");
	ClienteMarcaLocal marca = null;
        if (esClienteNuevo) {
            try{
                marca = this.getClienteMarcaLocalHome().create(oidCliente,oidMarca,new Long(0),new java.sql.Date(System.currentTimeMillis()));	
            }catch(PersistenceException c){
                ctx.setRollbackOnly();
                UtilidadesLog.error(c);
                throw new MareException(c, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        else    {
            try{
                marca = this.getClienteMarcaLocalHome().findByUK(oidCliente, oidMarca);
            }catch(NoResultException c){
                UtilidadesLog.debug("No Existe la marca para el cliente, procedemos a registrarla");            

                try{
                    marca = this.getClienteMarcaLocalHome().create(oidCliente,oidMarca,new Long(0),new java.sql.Date(System.currentTimeMillis()));	
                }catch(PersistenceException d){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(d);
                    throw new MareException(d, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        
		UtilidadesLog.info("MONECMBean.mantenerClienteMarca(boolean esClienteNuevo, Long oidCliente,Long oidMarca): Salida");
	}


    private Long obtenerIndicadorDefectoL(String indicador) {
        Long indicadorL = null;
        
        if(indicador != null) {
            if (Character.isDigit(indicador.toCharArray()[0]))
                indicadorL = new Long(indicador);
            else    {
                if (indicador.equalsIgnoreCase(ConstantesINT.S)) 
                    indicadorL = new Long(1);
                else 
                    indicadorL= new Long(0);
            }
        }
        
        return indicadorL;
    }


    private PaisLocalHome getPaisLocalHome() {
        return new PaisLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {
        return new CanalLocalHome();
    }
    
    private EmpresaLocalHome getEmpresaLocalHome() {
        return new EmpresaLocalHome();
    }    

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }        

    private MarcaLocalHome getMarcaLocalHome() {
        return new MarcaLocalHome();
    }           

    private TipoClienteLocalHome getTipoClienteLocalHome() {
        return new TipoClienteLocalHome();
    }        
    
    private SubtipoClienteLocalHome getSubtipoClienteLocalHome() {
        return new SubtipoClienteLocalHome();
    }    
    
    private TipoDocumentoLocalHome getTipoDocumentoLocalHome() {
        return new TipoDocumentoLocalHome();
    }        
    
    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome() {
        return new ClienteDatosAdicionalesLocalHome();
    }       
        
    private NacionalidadLocalHome getNacionalidadLocalHome() {
        return new NacionalidadLocalHome();
    }    
    
    private EstadoCivilLocalHome getEstadoCivilLocalHome() {
        return new EstadoCivilLocalHome();
    }        
    
    private NivelEstudiosLocalHome getNivelEstudiosLocalHome() {
        return new NivelEstudiosLocalHome();
    }     
 
    private ClienteIdentificacionLocalHome getClienteIdentificacionLocalHome() {
        return new ClienteIdentificacionLocalHome();
    }       
        
    private ClienteTipoSubTipoLocalHome getClienteTipoSubTipoLocalHome() {
        return new ClienteTipoSubTipoLocalHome();
    }    
    
    private TipoClasificacionLocalHome getTipoClasificacionLocalHome() {
        return new TipoClasificacionLocalHome();
    }        
    
    private ClasificacionLocalHome getClasificacionLocalHome() {
        return new ClasificacionLocalHome();
    }     
     


    private ClienteClasificacionLocalHome getClienteClasificacionLocalHome() {
        return new ClienteClasificacionLocalHome();
    }

    private TipoViaLocalHome getTipoViaLocalHome() {
        return new TipoViaLocalHome();
    }

    private ViaLocalHome getViaLocalHome() {
        return new ViaLocalHome();
    }

    private ValoresEstructuraGeopoliticaLocalHome  getValoresEstructuraGeopoliticaLocalHome() {
        return new ValoresEstructuraGeopoliticaLocalHome();
    }

    private ClienteDireccionLocalHome getClienteDireccionLocalHome() {
        return new ClienteDireccionLocalHome();
    }

    private TipoComunicacionLocalHome getTipoComunicacionLocalHome() {
        return new TipoComunicacionLocalHome();
    }

    private ClienteComunicacionLocalHome getClienteComunicacionLocalHome() {
        return new ClienteComunicacionLocalHome();
    }

    private ClientePrimerContactoLocalHome getClientePrimerContactoLocalHome() {
        return new ClientePrimerContactoLocalHome();
    }

    private TipoVinculoLocalHome getTipoVinculoLocalHome() {
        return new TipoVinculoLocalHome();
    }

    private ClienteVinculoLocalHome getClienteVinculoLocalHome() {
        return new ClienteVinculoLocalHome();
    }

    private ClienteHistoricoEstatusLocalHome getClienteHistoricoEstatusLocalHome() {
        return new ClienteHistoricoEstatusLocalHome();
    }

    private ClienteMarcaLocalHome getClienteMarcaLocalHome() {
        return new ClienteMarcaLocalHome();
    }

    private RecepcionVentasAsociadasLocalHome getRecepcionVentasAsociadasLocalHome() {
            return new RecepcionVentasAsociadasLocalHome();
    }

    private ObtencionPuntosLocalHome getObtencionPuntosLocalHome() {
            return new ObtencionPuntosLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }


   
    
}