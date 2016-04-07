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
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasDtoRecargo;
import es.indra.sicc.dtos.ccc.DTOBuscarTipoSolicitudProceso;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.sicc.dtos.ccc.DTOEntidad;
import es.indra.sicc.dtos.ccc.DTONumero;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.ccc.CabeceraDtoRecargLocal;
import es.indra.sicc.entidades.ccc.CabeceraDtoRecargLocalHome;
import es.indra.sicc.entidades.ccc.DetalleDtoRecargoLocal;
import es.indra.sicc.entidades.ccc.DetalleDtoRecargoLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.text.ParseException;

import java.util.ArrayList;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONGenerarDtoRecargoBean implements SessionBean {
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

    public DTOSalida obtenerSubprocesosPorCodigoProceso(DTOCodigoProceso dto)
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.obtenerSubprocesosPorCodigoProceso(DTOCodigoProceso dto): Entrada"); 
        DAOCCC miDao = new DAOCCC();
        DTOSalida dtoS = miDao.obtenerSubprocesosPorCodProceso(dto);
        UtilidadesLog.info("MONGenerarDtoRecargoBean.obtenerSubprocesosPorCodigoProceso(DTOCodigoProceso dto): Salida"); 

        return dtoS;
    }

    public DTOSalida buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dto)
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dto): Entrada"); 

        DAOCCC daoCCC = new DAOCCC();
        DAOGenerarDtoRecargo daoGenerar = new DAOGenerarDtoRecargo();

        dto.setCodigoSubproceso(daoCCC.obtieneCodSubproceso(
                dto.getOidSubproceso()));

        if (dto.getCodigoCliente() != null) {
            MONClientes monClientes = this.getMONClientes();

            try {
                dto.setOidCliente(monClientes.obtenerOidCliente(
                        dto.getOidPais(), dto.getCodigoCliente()));
            } catch (RemoteException re) {
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));    
            }

            if (dto.getOidCliente() == null) {
                UtilidadesLog.debug( "****Metodo buscarCuotasDtoRecargo: Cliente no existe");
                ExcepcionParametrizada excepcionParam = new ExcepcionParametrizada("",
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0032));
                excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                excepcionParam.addParameter(" " + dto.getCodigoCliente());
                throw excepcionParam;
            }

            UtilidadesLog.debug("****MONGenerarDtoRecargo: Método buscarCuotasDtoRecargo: Salida");
			DTOSalida salida = daoGenerar.buscarCuotasInsertar(dto);
			UtilidadesLog.debug("salida = "+salida);
            return salida;
        } else {
            MONClientes monClientes = this.getMONClientes();

            if ((dto.getCodigoClienteDesde() != null) && (dto.getCodigoClienteHasta() != null)) {
                try {
                    dto.setOidClienteDesde(monClientes.obtenerOidCliente(
                    dto.getOidPais(), dto.getCodigoClienteDesde()));
                } catch (RemoteException re) {
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));    
                }

                if (dto.getOidClienteDesde() == null) {
                    UtilidadesLog.debug( "****Metodo buscarCuotasDtoRecargo: Cliente no existe");
                    ExcepcionParametrizada excepcionParam = new ExcepcionParametrizada("",
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0032));
                    excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                    excepcionParam.addParameter(" " + dto.getCodigoClienteDesde());
                    throw excepcionParam;
                }


                try {
                    dto.setOidClienteHasta(monClientes.obtenerOidCliente(
                            dto.getOidPais(), dto.getCodigoClienteHasta()));
                } catch (RemoteException re) {
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));    
                }
                if (dto.getOidClienteHasta() == null) {
                    UtilidadesLog.debug( "****Metodo buscarCuotasDtoRecargo: Cliente no existe");
                    ExcepcionParametrizada excepcionParam = new ExcepcionParametrizada("",
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0032));
                    excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                    excepcionParam.addParameter(" " + dto.getCodigoClienteHasta());
                    throw excepcionParam;
                }
            }

            UtilidadesLog.info("MONGenerarDtoRecargoBean.buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dto): Salida"); 

			DTOSalida salida = daoGenerar.buscarCuotasDtoRecargo(dto);
			UtilidadesLog.debug("salida = "+salida);
            return salida;
        }
    }

    public void confirmarDtoRecargo(DTOBuscarCuotasDtoRecargo dto)
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.confirmarDtoRecargo(DTOBuscarCuotasDtoRecargo dto): Entrada"); 

        try{//Obtiene las cuotas a procesar.
            DTOSalida dtoS = this.buscarCuotasDtoRecargo(dto);
    
            //Actualiza las cuotas a procesar.
            DAOGenerarDtoRecargo daoGenerarDtoRecargo = new DAOGenerarDtoRecargo();
    
            daoGenerarDtoRecargo.actualizarCuotasDtoRecargo(dtoS.getResultado());
    
            //Agrupamos importes por cliente, tipo de cliente y subacceso: creamos 
            //un solo registro con el importe total dto/recargo agrupado por oidCliente, 
            //oidTipoCliente y oidSubacceso. 
            DTOEntidad[] agrupado = this.agrupar(dtoS.getResultado());
    
            //Obtiene el código del subproceso.
            DAOCCC daoCCC = new DAOCCC();
            CabeceraDtoRecargLocal cab = null;
            DTOSalida tiposAbono = new DTOSalida();
            dto.setCodigoSubproceso(daoCCC.obtieneCodSubproceso(
                    dto.getOidSubproceso()));
    
            //Pone la operación adecuada al subproceso.
            Long operacion = null;
    
            if (dto.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)) {
                operacion = ConstantesBEL.CCC065;
            } else {
                operacion = ConstantesBEL.CCC064;
            }
    
            DTOCabeceraSolicitud dtoCabSolicitud = new DTOCabeceraSolicitud();
            DTOBuscarTipoSolicitudProceso dtoBuscarTipoSolic = new DTOBuscarTipoSolicitudProceso();
            DTOSalida tipoSolicitudProceso = new DTOSalida();
            DTOPeriodo periodoActual = null; //Incidencia 12191
            //Por cada elemento en agrupado 
            for (int i = 0; i < agrupado.length; i++) {
                ArrayList lista = new ArrayList();
                ////Obtenemos todos los campos del registro (el primero) de TipoSolicitudProceso.
                UtilidadesLog.debug("Agrupado: "+agrupado[i]);
                dtoBuscarTipoSolic.setOidPais(dto.getOidPais());
                dtoBuscarTipoSolic.setOperacion(operacion);
                dtoBuscarTipoSolic.setOidTipoCliente(agrupado[i].getOidTipoCliente());
                //dtoBuscarTipoSolic.setOidSubacceso(agrupado[i].getOidSubacceso());
                dtoBuscarTipoSolic.setOidSubacceso(dto.getOidSubacceso());
                tipoSolicitudProceso = daoGenerarDtoRecargo.obtenerTipoSolicitudProceso(dtoBuscarTipoSolic);
                if (tipoSolicitudProceso.getResultado().esVacio()) {
                    UtilidadesLog.debug("confirmarDtoRecargo: no hay tipoSolicitudProceso ");				
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(codigoError));
                }
                // Incidencia 12191
                // Obtiene el periodo actual
                MONPeriodosHome home = (MONPeriodosHome) UtilidadesEJB.getHome("MONPeriodos",MONPeriodosHome.class);                  
                
                MONPeriodos periodos = null;
                try{
                    periodos = home.create();
                } catch (Exception e) {
                    UtilidadesLog.error("*** Error en MONGenerarDtoRecargo.confirmarDtoRecargo", e);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
                }
                try{
                    periodoActual = periodos.obtienePeriodoActual(dto.getOidPais(),new Long(((BigDecimal) tipoSolicitudProceso.getResultado().getValueAt(0, "OIDMARCA")).longValue()),new Long(((BigDecimal) tipoSolicitudProceso.getResultado().getValueAt(0, "OIDCANAL")).longValue()));
                } catch (RemoteException re){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(re);
                    throw new MareException(new Exception(), 
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                // Fin incidencia 12191
                
                //Invocamos al CU Generar solicitud de pedido desde módulos externos (PED)
                //----- cabecera ------
                UtilidadesLog.debug("Despues llamada obtenerTipoSolicitudProceso");
                dtoCabSolicitud.setOidPais(dto.getOidPais());
                dtoCabSolicitud.setOidIdioma(dto.getOidIdioma()); //INCIDENCIA 12191
                dtoCabSolicitud.setMarca(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0, "OIDMARCA")).longValue()));
                UtilidadesLog.debug("La marca es: " + dtoCabSolicitud.getMarca());
                // Añadido por incidencia 12191
                dtoCabSolicitud.setCanal(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                        .getValueAt(0, "OIDCANAL")).longValue()));
                // Fin del añadido
                dtoCabSolicitud.setAcceso(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0, "OIDACCESO")).longValue()));
                UtilidadesLog.debug("El acceso es: " + dtoCabSolicitud.getAcceso());
                if (tipoSolicitudProceso.getResultado().getValueAt(0,"OIDSUBACCESO")!=null){
                    dtoCabSolicitud.setSubacceso(new Long(((BigDecimal)tipoSolicitudProceso.getResultado().getValueAt(0,"OIDSUBACCESO")).longValue()));
                }
                UtilidadesLog.debug("El subacceso es: " + dtoCabSolicitud.getSubacceso());
                // Añadido por incidencia 12191
                dtoCabSolicitud.setPeriodo(periodoActual.getOid());
                // Fin del añadido
                dtoCabSolicitud.setOperacion(operacion);
                dtoCabSolicitud.setModulo(CCCConstantes.MODULO_CCC);
                dtoCabSolicitud.setTipoSolicitud(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0,
                            "OIDTIPOSOLICITUDPAIS")).longValue()));
                UtilidadesLog.debug("El tipo de solicitud es: " + dtoCabSolicitud.getTipoSolicitud());
                dtoCabSolicitud.setCliente(agrupado[i].getCodigoCliente());//INCIDENCIA BELC300012176
                dtoCabSolicitud.setOidCliente(agrupado[i].getOidCliente());//INCIDENCIA BELC300012176
                dtoCabSolicitud.setIndicadorDigitacion(Boolean.valueOf(false));
    
                String anio = dto.getAnio();
                UtilidadesLog.debug("El Anio es: " + anio);
                String mes = dto.getMes();
                UtilidadesLog.debug ("El mes es: " + mes);
                String num = dto.getNumero().toString();
                //String num = "9";
                UtilidadesLog.debug("El numero es: " + num);
                UtilidadesLog.debug("La longitud del anio es: " + anio.length());
                UtilidadesLog.debug("La substring es: " + anio.substring(anio.length() - 2, anio.length()));
                String aux = anio.substring(anio.length() - 2, anio.length()) +
                    mes + num;
                UtilidadesLog.debug("Aux es: " + aux);
                dtoCabSolicitud.setNumeroDocumentoOrigen(new Long(aux));
                UtilidadesLog.debug("El numeroDocumentoOrigen es: " + dtoCabSolicitud.getNumeroDocumentoOrigen());
                
                //---- detalles ---------
                UtilidadesLog.debug("1.Detalles");
                DTOPosicionSolicitud dtoPosSolic = new DTOPosicionSolicitud();
                //dtoPosSolic = (DTOPosicionSolicitud) dtoCabSolicitud.getPosiciones().get(0);
                dtoPosSolic.setTipoPosicion(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0,
                            "OIDTIPOPOSICION")).longValue()));
                dtoPosSolic.setSubtipoPosicion(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0,
                            "OIDSUBTIPOPOSICION")).longValue()));
                dtoPosSolic.setProducto(new Long(
                        ((BigDecimal) tipoSolicitudProceso.getResultado()
                                                          .getValueAt(0,
                            "OIDPRODUCTO")).longValue()));
               /* Si operacion = ConstantesBEL.CCC064
                   {
                    dtoCabSolicitud.posiciones(0).unidadesDemandadas = 1
                    dtoCabSolicitud.posiciones(0).unidadesPorAtender = 1
                    dtoCabSolicitud.posiciones(0).unidadesDemandaReal = 1
                   }  
                   Si operacion = ConstantesBEL.CCC065
                   {
                    dtoCabSolicitud.posiciones(0).unidadesDemandadas = -1
                    dtoCabSolicitud.posiciones(0).unidadesPorAtender = -1
                    dtoCabSolicitud.posiciones(0).unidadesDemandaReal = -1
                   }
                */ //Inc BELC300018599
                if (operacion.equals(ConstantesBEL.CCC064)){
                    dtoPosSolic.setUnidadesDemandadas(new Long(1));
                    dtoPosSolic.setUnidadesPorAtender(new Long(1));
                    dtoPosSolic.setUnidadesDemandaReal(new Long(1));
                }else if (operacion.equals(ConstantesBEL.CCC065)){
                    dtoPosSolic.setUnidadesDemandadas(new Long(-1));
                    dtoPosSolic.setUnidadesPorAtender(new Long(-1));
                    dtoPosSolic.setUnidadesDemandaReal(new Long(-1));
                } else{
                    //Por si las dudas
                    UtilidadesLog.error("ERROR: Operacion no es igual a ninguna constante, se pone 1");
                    dtoPosSolic.setUnidadesDemandadas(new Long(1));
                    dtoPosSolic.setUnidadesPorAtender(new Long(1));
                    dtoPosSolic.setUnidadesDemandaReal(new Long(1));
                }
                
                /*DTOPosicionSolicitud dtoPosSolic2 = null;
                dtoPosSolic2 = (DTOPosicionSolicitud) dtoCabSolicitud.getPosiciones()
                                                                     .get(i);*/
                
                //modificado por incidencia 19190
                /*if (dto.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)) {
                  UtilidadesLog.debug("2.Entra If");
                    double auxDoble = -1 * agrupado[i].getImporteDtoRecargo()
                                                      .doubleValue();
                    dtoPosSolic.setPrecioCatalogoUnitarioLocal(new BigDecimal(auxDoble));
                } else {
                    UtilidadesLog.debug("3.EntraElse");
                    dtoPosSolic.setPrecioCatalogoUnitarioLocal(agrupado[i].getImporteDtoRecargo());
                }*/
                dtoPosSolic.setPrecioCatalogoUnitarioLocal(agrupado[i].getImporteDtoRecargo());
                
                
                lista.add(dtoPosSolic);
                dtoCabSolicitud.setPosiciones(lista);
                //Obtenemos el codigoSolicitud
                MONGenerarSolicitudModulosExternos mONGenerarSolicitudModulosExternos =
                    this.getMONGenerarSolicitudModulosExternos();
                DTOOID codigoSolicitud = null;
    
                try {
                    codigoSolicitud = mONGenerarSolicitudModulosExternos.generaSolicitud(dtoCabSolicitud);
                } catch (Exception re) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(re);
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                UtilidadesLog.debug("4.El codigo de solicitud es: " + codigoSolicitud.getOid());
                if (codigoSolicitud==null || codigoSolicitud.getOid()==null){
                    UtilidadesLog.error("NO SE CREO NADA EN PED_SOLIC_CABEC!!!!! SALGO");
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                agrupado[i].setOidSolicitud(codigoSolicitud.getOid());
                //agrupado[i].setOidSolicitud(new Long(1));
            }//Fin del bucle para cada elemento en agrupado
            
            //Obtener el primer registro de tipoabono para el proceso y subproceso seleccionado
            tiposAbono.setResultado(daoCCC.obtenerTiposCargoSubproceso(
                    dto.getOidSubproceso(), dto.getOidIdioma()));
    
            //Solo usamos el primer registro devuelto. 
            //Creamos la cabecera y los detalles descuento / recargo. 
            int numeroLinea = 0;
    
            //Por cada elemento en dtoS.resultado (las cuotas que se están procesando)
            for (int j = 0; j < dtoS.getResultado().getRowCount(); j++) {
                 UtilidadesLog.debug("5.Entra for " + j);
                //Creamos una sola cabecera (CabeceraDtoRecargo)
                if (j == 0) { //primer elemento de dtoS.resultado
    
                    //Llamamos al método create del Entity: CabeceraDtoRecargo (cab) con los datos:
                    CabeceraDtoRecargLocalHome homeCabeceraDtoRecarg = this.getCabeceraDtoRecargLocalHome();
                    Integer numero = dto.getNumero(); //NUM_CABE
                    //Integer numero = new Integer("9");
                    Long pais = dto.getOidPais(); //PAIS_OID_PAIS
                    Date fechaAux = new Date(System.currentTimeMillis());
                    String periodoMes = null;
                    String anio = null;
    
                    try {
                        //Mes de la fecha del sistema, VAL_PERI_MES
                        periodoMes = UtilidadesFecha.convertirAString(fechaAux, "MM");
    
                        //Anio de la fecha del sistema, VAL_ANIO
                        anio = UtilidadesFecha.convertirAString(fechaAux, "yy");
                    } catch (ParseException e) {
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_FORMATO_FECHA));
                    }
    
                    Long subProceso = dto.getOidSubproceso(); //SUBP_OID_SUBP
    
                    /*MODIFICADO POR INCIDENCIA 11485
                     * Long tipoAbono = (Long) tiposAbono.getResultado().getValueAt(0,
                            "OIDTIPOABONSUBP"); //TCAB_OID_TIPO_CARG_ABON
                     */
                    Long tipoAbono = new Long(((BigDecimal) tiposAbono.getResultado()
                                                                      .getValueAt(0,
                                "TCAB_OID_TCAB")).longValue()); //TCAB_OID_TIPO_CARG_ABON 										
                    String situacion = CCCConstantes.SITUACION_DTO_RECARGO_APROBADO.toString(); //VAL_SITU
                    Date fechaDocumento = fechaAux; //fecha actual del sistema //FEC_DOCU 
                    Date fechaDocumentoDesde = null;
                    Date fechaDocumentoHasta = null;
                    Date fechaVencimientoDesde = null;
                    Date fechaVencimientoHasta = null;
                    Long clienteDesde = null;
                    Long clienteHasta = null;
                    String observaciones = null;
                    String referenciaExterna = null;
                    if(dto.getFechaDocDesde()!=null)
                        fechaDocumentoDesde = new Date (dto.getFechaDocDesde().getTime()); //FEC_DOCU_DESD 
                    if(dto.getFechaDocHasta()!=null)
                        fechaDocumentoHasta = new Date (dto.getFechaDocHasta().getTime()); //FEC_DOCU_HAST 
                    if(dto.getFechaVtoDesde()!=null)
                        fechaVencimientoDesde = new Date (dto.getFechaVtoDesde().getTime()); //FEC_VENC_DESD 
                    if(dto.getFechaVtoHasta()!=null)
                        fechaVencimientoHasta = new Date (dto.getFechaVtoHasta().getTime()); //FEC_VENC_HAST 
                    if(dto.getOidClienteDesde()!=null)
                        clienteDesde = dto.getOidClienteDesde(); //CLIE_OID_CLIE
                    if(dto.getOidClienteHasta()!=null)
                        clienteHasta = dto.getOidClienteHasta(); //CLIE_OID_CLIE_CARGA_HASTA 
                    BigDecimal importeDescuentoRecargo = dto.getImporteFijo(); //IMP_DESC_RECA
                    Integer diasCadencia = dto.getDiasCadencia(); //NUM_DIAS_CADE 
                    Integer diasCorte = dto.getDiasCorte(); //NUM_DIAS_CORT 
                    BigDecimal tipoInteres = dto.getTipoInteres(); //VAL_TIPO_INTE 
                    Long empresa = dto.getOidEmpresa(); //SOCI_OID_SOCI */
                    if(dto.getRefExterna()!=null)
                        referenciaExterna = dto.getRefExterna(); //VAL_REFE_EXTE 
                    if(dto.getObservaciones()!=null)
                        observaciones = dto.getObservaciones(); //VAL_OBSE
    
                    try {
                        cab = homeCabeceraDtoRecarg.create(diasCadencia, diasCorte,
                                tipoInteres, numero, anio, periodoMes,
                                fechaDocumento, situacion, pais, empresa,
                                subProceso, tipoAbono);
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error(ce);
                        ctx.setRollbackOnly();
                        throw new MareException(ce,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
    
                    cab.setFechaDocumentoDesde(fechaDocumentoDesde);
                    cab.setFechaDocumentoHasta(fechaDocumentoHasta);
                    cab.setFechaVtoDesde(fechaVencimientoDesde);
                    cab.setFechaVtoHasta(fechaVencimientoHasta);
                    cab.setClienteDesde(clienteDesde);
                    cab.setClienteHasta(clienteHasta);
                    cab.setImporteDescuentoRecargo(importeDescuentoRecargo);
                    cab.setReferenciaExterna(referenciaExterna);
                    cab.setObservaciones(observaciones);
                    homeCabeceraDtoRecarg.merge(cab);
                }
    
                //Fin del SI primer elemento
                DetalleDtoRecargoLocalHome homeDetalleDtoRecargo = this.getDetalleDtoRecargoLocalHome();
                DetalleDtoRecargoLocal detalleDtoRecarg = null;
    
                try {
                    UtilidadesLog.debug("Antes create detalle " + (Long)cab.getOid());
                    UtilidadesLog.debug("El oid cliente es: " + new Long(((BigDecimal) dtoS.getResultado().getValueAt(j,
                                    "OIDCLIENTE")).longValue()));
                    detalleDtoRecarg = homeDetalleDtoRecargo.create(new Long(1),
                            (Long) cab.getOid(), new Integer(++numeroLinea),
                            new Long(((BigDecimal) dtoS.getResultado().getValueAt(j,
                                    "OIDCLIENTE")).longValue()));
                    UtilidadesLog.debug("Despues 2º create detalle");
                } catch (PersistenceException ce) {
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();
                    throw new MareException(ce,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
    
                if((dtoS.getResultado().getValueAt(j, "REFERENCIAEXTERNA"))!=null)
                    detalleDtoRecarg.setReferenciaDocumentoExterno(dtoS.getResultado()
                                                                   .getValueAt(j,
                        "REFERENCIAEXTERNA").toString()); //REF_DOCU_EXTE 
                if((dtoS.getResultado().getValueAt(j, "FECHADOCUMENTO"))!=null)
                    detalleDtoRecarg.setFechaDocumento((java.sql.Date) dtoS.getResultado()
                                                              .getValueAt(j,
                        "FECHADOCUMENTO")); //FEC_DOCU 
                if((dtoS.getResultado().getValueAt(j, "FECHAVENCIMIENTO"))!=null)
                    detalleDtoRecarg.setFechaVencimiento((java.sql.Date) dtoS.getResultado()
                                                              .getValueAt(j,
                        "FECHAVENCIMIENTO")); //FEC_VENC 
                if((dtoS.getResultado().getValueAt(j, "FECHALIQUIDACION"))!=null)
                    detalleDtoRecarg.setFechaLiquidacion((java.sql.Date) dtoS.getResultado()
                                                              .getValueAt(j,
                        "FECHALIQUIDACION")); //FEC_LIQU 
                if((dtoS.getResultado().getValueAt(j, "DIASCALCULADOS"))!=null)
                    detalleDtoRecarg.setNumeroDiasCalculados(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(j,
                            "DIASCALCULADOS")).intValue())); //NUM_DIAS_CALC 
                if((dtoS.getResultado().getValueAt(j, "IMPORTENOMINAL"))!=null)
                    detalleDtoRecarg.setImporte(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(j,
                            "IMPORTENOMINAL")).doubleValue())); //IMP_DETA 
                if((dtoS.getResultado().getValueAt(j, "IMPORTEPAGO"))!=null)
                    detalleDtoRecarg.setImportePago((BigDecimal) dtoS.getResultado()
                                                                 .getValueAt(j,
                        "IMPORTEPAGO")); //IMP_PAGO 
                
                if((dtoS.getResultado().getValueAt(j, "IMPORTEDTO"))!=null)
                {
                    //modificado por incidencia 19190
                                       
                    if (((BigDecimal)(dtoS.getResultado().getValueAt(j, "IMPORTEDTO"))).doubleValue()<0)
                    {
                        detalleDtoRecarg.setImporteLiquidacionCalculado(new BigDecimal(0));
                    }else
                    {
                        detalleDtoRecarg.setImporteLiquidacionCalculado((BigDecimal) dtoS.getResultado()
                                                                                 .getValueAt(j,
                                                                                 "IMPORTEDTO")); //IMP_LIQU_CALC 
                    }
                }
                    
                
               /*
                    Se comenta luego de la migracion , la columna no existe ni el campo en la tabla mencionado
                    
                    if((dtoS.getResultado().getValueAt(j, "IMPORTELIQUIDACIONCALCULADO"))!=null)
                    detalleDtoRecarg.setImporteLiquidacionUsuario((BigDecimal) dtoS.getResultado()
                                                                               .getValueAt(j,
                        "IMPORTELIQUIDACIONCALCULADO")); //IMP_LIQU_USUA 
                */
                //Se crea un DTOEntidad (entidad) que se carga con:
                DTOEntidad entidad = new DTOEntidad();
                entidad.setOidCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(j, "OIDCLIENTE")).longValue()));
                entidad.setOidTipoCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(j,
                            "OIDTIPOCLIENTE")).longValue()));
                entidad.setOidSubacceso(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(j,
                            "OIDSUBACCESO")).longValue()));
    
                //Por cada elemento en agrupado 
                for (int k = 0; k < agrupado.length; k++) {
                    //Si entidad.equals(agrupado(h)) == True
                    if (entidad.getOidCliente().equals(agrupado[k].getOidCliente()) &&
                            entidad.getOidTipoCliente().equals(agrupado[k].getOidTipoCliente()) &&
                            entidad.getOidSubacceso().equals(agrupado[k].getOidSubacceso())) {
                            UtilidadesLog.debug("El valor de k es: " +k);
                            UtilidadesLog.debug("La solicitud es: " + agrupado[k].getOidSolicitud());
                        detalleDtoRecarg.setCabecera(agrupado[k].getOidSolicitud()); //SOCA_OID_SOLI_CABE
    
                        break;
                    }
                }
    
                if (dtoS.getResultado().getValueAt(j, "ENTIDAD").toString().equals("1")) {
                    UtilidadesLog.debug("El movimientos es: " + new Long(
                            ((BigDecimal) dtoS.getResultado().getValueAt(j, "OID")).longValue()));
                    detalleDtoRecarg.setMovimiento(new Long(
                            ((BigDecimal) dtoS.getResultado().getValueAt(j, "OID")).longValue())); //MVCC_OID_MOVI_CC 
                } else {
                    UtilidadesLog.debug("El historico es: " + new Long(
                            ((BigDecimal) dtoS.getResultado().getValueAt(j, "OID")).longValue()));
                    detalleDtoRecarg.setHistorico(new Long(
                            ((BigDecimal) dtoS.getResultado().getValueAt(j, "OID")).longValue())); //HMCC_OID_HIST_MOVI_CC 
                }
                homeDetalleDtoRecargo.merge(detalleDtoRecarg);
            }
            
             
    
            //Fin del for (cuotas que se están procesando)
            UtilidadesLog.info("MONGenerarDtoRecargoBean.confirmarDtoRecargo(DTOBuscarCuotasDtoRecargo dto): Salida"); 
        }catch(Exception e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            if (e instanceof MareException)
                throw (MareException)e;
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));            
        }finally{
           try{
            new DAOCCC().eliminarBloqueo();
         }catch (Exception e){
            e.printStackTrace();
         }
      
      }
    }

    public DTOEntidad[] agrupar(RecordSet resultado) throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.agrupar(RecordSet resultado): Entrada"); 

        DTOEntidad[] agrupado = new DTOEntidad[resultado.getRowCount()];
        ArrayList arrayTemporal = new ArrayList();
        Boolean bEncontrado = null;
        ClienteDatosBasicosLocalHome cdbLHome = null;
        ClienteDatosBasicosLocal cdbLocal = null;
        int contador = 0;

        for (int i = 0; i < resultado.getRowCount(); i++) {
            UtilidadesLog.debug("Entra for vuelta: " + i);
            bEncontrado = Boolean.valueOf(false);
            //modificado por incidencia 19190
            if((resultado.getValueAt(i, "IMPORTEDTO"))!=null)
            {                                      
                if (((BigDecimal)(resultado.getValueAt(i, "IMPORTEDTO"))).doubleValue()!=0){
            
                    DTOEntidad entidad = new DTOEntidad();
                    //entidad.setOidCliente((Long) resultado.getValueAt(i, "OIDCLIENTE"));
                    entidad.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(i,"OIDCLIENTE")).longValue()));
                    
                    //entidad.setOidTipoCliente((Long) resultado.getValueAt(i,"OIDTIPOCLIENTE"));
                    entidad.setOidTipoCliente(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOCLIENTE")).longValue()));
                  
                    //entidad.setOidSubacceso((Long) resultado.getValueAt(i,"OIDSUBACCESO"));
                    entidad.setOidSubacceso(new Long(((BigDecimal)resultado.getValueAt(i,"OIDSUBACCESO")).longValue()));
                    
                    entidad.setImporteDtoRecargo((BigDecimal) resultado.getValueAt(i,"IMPORTEDTO"));
            
                    for (int j = 0; j < contador; j++) {
                      UtilidadesLog.debug("Entra 2º for vuelta: " + j);
                      UtilidadesLog.debug("Compara:  " + entidad.getImporteDtoRecargo()+" = "+agrupado[j].getImporteDtoRecargo());
                      UtilidadesLog.debug("Compara:  " + entidad.getOidCliente()+" = "+agrupado[j].getOidCliente());
                      UtilidadesLog.debug("Compara:  " + entidad.getOidSubacceso()+" = "+agrupado[j].getOidSubacceso());
                      UtilidadesLog.debug("Compara:  " + entidad.getOidTipoCliente()+" = "+agrupado[j].getOidTipoCliente());
                        if ( entidad.getImporteDtoRecargo().equals(agrupado[j].getImporteDtoRecargo()) &&
                             entidad.getOidCliente().equals(agrupado[j].getOidCliente()) &&
                             entidad.getOidSubacceso().equals(agrupado[j].getOidSubacceso()) &&
                             entidad.getOidTipoCliente().equals(agrupado[j].getOidTipoCliente())) {
                            bEncontrado = Boolean.TRUE;
                            ((DTOEntidad)arrayTemporal.get(j)).setImporteDtoRecargo(new BigDecimal(((DTOEntidad)arrayTemporal.get(j)).getImporteDtoRecargo().intValue()+entidad.getImporteDtoRecargo().intValue()));
                            UtilidadesLog.debug("Encontro!!");
                        }
                    }
        
                    if (bEncontrado.booleanValue() == false) {
                        /* Añadidos incidencia BELC300012176 */
                        cdbLHome = getClienteDatosBasicosLocalHome();
                        try{
                            cdbLocal = cdbLHome.findByPrimaryKey(entidad.getOidCliente());
                        }catch(NoResultException fe){
                            UtilidadesLog.debug("clienteDatosBasicos: FinderException:",fe);
                            throw new MareException(fe,UtilidadesError.armarCodigoError
                                (CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        }
                        entidad.setCodigoCliente(cdbLocal.getCod_clie());
                        /* Fin incidencia */
                        agrupado[contador] = entidad;
                        arrayTemporal.add(deepCopy(entidad));
                        UtilidadesLog.debug("El agrupado numero "+contador+" quedo asi "+agrupado[contador]);
                        contador++;
                    }
                }//fin bucle resultado(i).importeDto<>0   
            }
        }
        
        agrupado = new DTOEntidad[arrayTemporal.size()];
        for(int i = 0; i < arrayTemporal.size(); i++){
            agrupado[i] = (DTOEntidad)arrayTemporal.get(i);
        }
        
        UtilidadesLog.info("MONGenerarDtoRecargoBean.agrupar(RecordSet resultado): Salida");

        return agrupado;
    }
    
    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private static Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.deepCopy(Object oldObj): Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            UtilidadesLog.info("MONGenerarDtoRecargoBean.deepCopy(Object oldObj): Salida");  
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.error(ex);
                throw new MareException(ex);
            }
        }
    }

    public DTONumero obtenerSiguienteNumeroDtoRecargo(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.obtenerSiguienteNumeroDtoRecargo(DTOBelcorp dto): Entrada");

        /* MODIFICADO POR INCIDENCIA 10254
        DAOGenerarDtoRecargo dao = new DAOGenerarDtoRecargo();
        //DTOSalida dtoSalida = dao.obtenerSiguienteNumeroDtoRecargo(dto);
        */
        DTONumero dtoN = new DTONumero();
        DAOCCC daoCCC = new DAOCCC();
        dtoN.setNumero(daoCCC.obtenerSecuenciaPais(dto));
        UtilidadesLog.info("MONGenerarDtoRecargoBean.obtenerSiguienteNumeroDtoRecargo(DTOBelcorp dto): Salida");
        UtilidadesLog.debug("dtoN = "+dtoN);
        if(dtoN!=null){
            UtilidadesLog.debug("setNumero ="+dtoN.getNumero());
        }else{
            UtilidadesLog.debug("El dtoN es null");
        }
        return dtoN;
    }

    private CabeceraDtoRecargLocalHome getCabeceraDtoRecargLocalHome()
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getCabeceraDtoRecargLocalHome(): Entrada");
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getCabeceraDtoRecargLocalHome(): Salida");

        return new CabeceraDtoRecargLocalHome();
    }

    private DetalleDtoRecargoLocalHome getDetalleDtoRecargoLocalHome()
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getDetalleDtoRecargoLocalHome(): Entrada");
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getDetalleDtoRecargoLocalHome(): Salida");

        return new DetalleDtoRecargoLocalHome();
    }

    private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome()
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMovimientosCuentasCorrientesLocalHome(): Entrada");

        MovimientosCuentasCorrientesLocalHome movimientosCuentasCorrientesLocalHome =
            (MovimientosCuentasCorrientesLocalHome) UtilidadesEJB.getLocalHome(
                "java:comp/env/MovimientosCuentasCorrientes");
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMovimientosCuentasCorrientesLocalHome(): Salida");

        return movimientosCuentasCorrientesLocalHome;
    }

    private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos()
        throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMONGenerarSolicitudModulosExternos(): Entrada");

        // Se obtiene el interfaz home
        MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome) UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos",
                MONGenerarSolicitudModulosExternosHome.class);

        // Se obtiene el interfaz remoto
        MONGenerarSolicitudModulosExternos ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGenerarSolicitudModulosExternos",
                e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMONGenerarSolicitudModulosExternos(): Salida");

        return ejb;
    }

    private MONClientes getMONClientes() throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMONClientes(): Entrada");

        // Se obtiene el interfaz home
        MONClientesHome home = (MONClientesHome) UtilidadesEJB.getHome("MONClientes",
                MONClientesHome.class);

        // Se obtiene el interfaz remoto
        MONClientes ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONClientes", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONGenerarDtoRecargoBean.getMONClientes(): Salida");

        return ejb;
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() throws MareException {
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getClienteDatosBasicosLocalHome(): Entrada");
        UtilidadesLog.info("MONGenerarDtoRecargoBean.getClienteDatosBasicosLocalHome(): Salida");
        return new ClienteDatosBasicosLocalHome();
    }
    
}
