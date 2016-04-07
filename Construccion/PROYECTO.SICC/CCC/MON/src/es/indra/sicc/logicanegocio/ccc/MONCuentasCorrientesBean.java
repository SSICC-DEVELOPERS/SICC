/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35monValidacion
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
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.dtos.ccc.DTOBuscarCuentasCorrientes;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasPendientes;
import es.indra.sicc.dtos.ccc.DTOBuscarLotesTrabajo;
import es.indra.sicc.dtos.ccc.DTODetalleCargos;
import es.indra.sicc.dtos.ccc.DTOFiltroCC;
import es.indra.sicc.dtos.ccc.DTOMovBancIndicadores;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTONumeroRegistros;
import es.indra.sicc.dtos.ccc.DTONumerosLineaVistaLotes;
import es.indra.sicc.dtos.ccc.DTOParametrosCuotasCancelacion;
import es.indra.sicc.dtos.ccc.DTORepBusquedaCC;
import es.indra.sicc.dtos.ccc.DTORepConsultaCCC;
import es.indra.sicc.dtos.ccc.DTORevertirCCFac;
import es.indra.sicc.dtos.ccc.DTOSaldoCampana;
import es.indra.sicc.dtos.ccc.DTOSigNroCupTram;
import es.indra.sicc.dtos.ccc.DTOSiguienteNumeroCupon;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.entidades.ccc.BloqueoMovBancLocal;
import es.indra.sicc.entidades.ccc.BloqueoMovBancLocalHome;
import es.indra.sicc.entidades.ccc.BloqueoMovCCLocal;
import es.indra.sicc.entidades.ccc.BloqueoMovCCLocalHome;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.HistoricoMovimientosBancLocal;
import es.indra.sicc.entidades.ccc.HistoricoMovimientosBancLocalHome;
import es.indra.sicc.entidades.ccc.HistoricoMovimientosCCLocal;
import es.indra.sicc.entidades.ccc.HistoricoMovimientosCCLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocal;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocal;
import es.indra.sicc.entidades.ccc.MovimientosCuentasCorrientesLocalHome;
import es.indra.sicc.entidades.ccc.ProcesosLocal;
import es.indra.sicc.entidades.ccc.ProcesosLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.ccc.DAOCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.HelperHistorial;
import es.indra.sicc.logicanegocio.ccc.MONActualizarCCporAplicacion;
import es.indra.sicc.logicanegocio.ccc.MONActualizarCCporAplicacionHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.cob.MONAsignacionCarteraPeriodo;
import es.indra.sicc.logicanegocio.cob.MONAsignacionCarteraPeriodoHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.lang.Long;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONCuentasCorrientesBean implements SessionBean {
    private final static String MON_VALIDACION = "MONValidacion";
    private final static String MON_CONFIGURACION_CLIENTES = "MONConfiguracionClientes";
    //private final static String EMISION_VENC_SI = "1";
    //private final static String EMISION_VENC_NO = "0";
    private ArrayList historicosMovimientosBancario = new ArrayList();

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    
    private static String[] fechasStatic;

    private SessionContext ctx;
    
    private static synchronized String[] getFechas() throws MareException{
      try {
      if((fechasStatic[0]==null || fechasStatic[1]==null)||(fechasStatic[0]!=null && !UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()), "MM").equalsIgnoreCase(fechasStatic[0]))){
            java.util.Date fechaSistema_java = new Date(System.currentTimeMillis());
            fechasStatic[1] = UtilidadesFecha.convertirAString(fechaSistema_java, "yy");
            fechasStatic[0] = UtilidadesFecha.convertirAString(fechaSistema_java, "MM");
         } 
      }catch (ParseException pe) {
         throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
      }         
      return fechasStatic;
   }
    

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

    /**
     * Este proceso realiza el retroceso de los movimientos en la tabla de
     * cuentas corrientes recuperando el estado anterior de la entidad
     * Histórico Movimientos en Cuenta Corriente
     * Para ello recibe los parametros cogidos de un movimiento y busca en
     * el historial el movimiento al que se hace referencia. Si no se puede
     * desacer porque no es el último se lanza una
     * ImposibleRetrocederCuentaException.     
     * @exception ImposibleRetrocederCuentaException
     * @return comments
     */

    public void retrocesoCuenta(DTOMovimientoCuentaCompleto dtoMov)
        throws MareException {
        //public void retrocesoCuenta(Long movimiento, Integer numeroHistoria) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.retrocesoCuenta(DTOMovimientoCuentaCompleto dtoMov): Entrada");

        // Con el parametro movimiento hacemos un findByPrimaryKey en la 
        // entidad MovimientosCuentasCorrientes
        MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
        MovimientosCuentasCorrientesLocal movimientosLocal;

        try {
            movimientosLocal = homeMCC.findByPrimaryKey(dtoMov.getOid());
        } catch (FinderException fe) {
            //GEN-0007 no existe -->
            this.loguearError(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        /* Llamamos a MONValidacion.validarAcceso pasandole los elementos del
         * entity que acabamos de buscar: pais, empresa, marca y subacceso,
         * (el resto de parametros van a null) Si nos devuelve false lanzamos
         * una MareException con el código de error GEN_0008
         * Ver BELC300003209
        */
        MONValidacion monValidacion = this.getMONValidacion();

        try {
            if (!(monValidacion.validarAccesos(null, null,
                        movimientosLocal.getMarca(), null, null,
                        movimientosLocal.getSubacceso(), null, null, null,
                        null, null)).booleanValue()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }
        } catch (RemoteException re) {
            this.loguearError(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException e) {
            throw e;
        }

        /*
         * -Si el dto.ultimoNumeroHistoria == 0, directamente elimina el registro en la entidad Movimientos en cuenta corriente
         * (invocamos el método remove(dto.oid) de la interfaz Home del Entity
         * Movimientos en cuenta corriente, y finaliza la ejecución del caso de uso.
        */
        if (dtoMov.getUltimoNumeroHistoria().longValue() == 0) {
            try {
                homeMCC.remove(dtoMov.getOid());
				return;
            } catch (RemoveException ex) {
                ctx.setRollbackOnly();
                this.loguearError(ex);
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        /*
         * -Llamamos a DAOCCC.obtenerHistoricoMovimiento, pasandole los parametros recibidos
         * (dto.oid, dto.numeroHistoria -1 ).
         * Si capturamos una HistorialNotFoundException lanzamos un IllegalArgumentException
         * con el mensaje: El movimiento a retroceder no existe.
        */
        DAOCCC daoCCC = new DAOCCC();
        Long historico = null;

        try {
            historico = daoCCC.obtenerHistoricoMovimiento(dtoMov.getOid(), new Integer(movimientosLocal.getUltimoNumeroHistoria().intValue() - 1));
           // historico = daoCCC.obtenerHistoricoMovimiento(dtoMov.getOid(), movimientosLocal.getUltimoNumeroHistoria());
        } catch (HistorialNotFoundException e) {
			//modificado por incidencia 10163
            this.loguearError(e);
			UtilidadesLog.error("retrocesoCuenta:  El movimiento a retroceder no existe.");
			throw new MareException(new Exception(),
									UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,
                                    "",ErroresDeNegocio.CCC_0051));
        }

        /*Hacemos un findByPrimaryKey de HistoricoMovimientosCC con
         * el Long obtenido (oid).
        */
        HistoricoMovimientosCCLocalHome homeHMCC = this.getHistoricoMovimientosCCLocalHome();
        HistoricoMovimientosCCLocal historicoLocal;

        try {
            historicoLocal = homeHMCC.findByPrimaryKey(historico);
        } catch (NoResultException fe) {
            //GEN-0007 no existe -->
             ctx.setRollbackOnly();
            this.loguearError(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        /* -Si no coincide el atributo dto.ultimoNumeroHistoria-1 del entity movimientos,
         * con el atributo numeroHistoria del entity histórico {
         * Lanzamos una ImposibleRetrocederCuentaException con el código de mensaje: CCC-0015 (El movimiento no se puede retroceder porque ha sido modificado)
        */
        Integer x = new Integer(movimientosLocal.getUltimoNumeroHistoria()
                                                .intValue() - 1);
        Integer y = historicoLocal.getNumeroHistoria();

        if (x.intValue() != y.intValue()) {
            UtilidadesLog.error(
                "retrocesoCuenta: ImposibleRetrocederCuentaException, validarAccesos " +
                " UltimoNumeroHistoria = " + x + " NumeroHistoria = " + y);
            throw new ImposibleRetrocederCuentaException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                    ErroresDeNegocio.IMPOSIBLE_RETROCEDER_MOVIMIENTO_MODIFICADO));
        }

        /*
         * -Actualizamos el entity movimientos con los atributos del entityHistorial
         * (En los casos de subproceso y tipo de abono se pasa el último;
         * (Fecha movimiento es la fechaUltimoMovimiento y Cuenta contable es cuentaCuota)
         * ) y restamos 1 al atributo ultimoNumeroHistoria.
        */
        try {
            movimientosLocal.setCliente(historicoLocal.getConsultora());
            movimientosLocal.setCuentaCuota(historicoLocal.getCuentaContable());

            //		movimientosLocal.setCuentaOrigen();
            movimientosLocal.setDivisa(historicoLocal.getDivisa());

            //		movimientosLocal.setDocumentoAnyo();
            //		movimientosLocal.setDocumentoMesSerie();
            //		movimientosLocal.setDocumentoNumero();
            //			movimientosLocal.setEjercicioCuota(historicoLocal.getEjercicioCuota());
            //		movimientosLocal.setEmpresa();
            movimientosLocal.setFechaContabilizacion(historicoLocal.getFechaContabilizacion()); //BELC300003185

            //		movimientosLocal.setFechaDocumento();//BELC300003068
            movimientosLocal.setFechaUltimoMovimiento(historicoLocal.getFechaMovimiento()); //BELC300003185
            movimientosLocal.setFechaValor(new Timestamp(historicoLocal.getFechaValor().getTime())); //BELC300003185
            movimientosLocal.setFechaVencimiento(historicoLocal.getFechaVencimiento()); //BELC300003185

            movimientosLocal.setImporte(historicoLocal.getImporte());

            movimientosLocal.setImporteDivisa(historicoLocal.getImporteDivisa());
            movimientosLocal.setImportePagado(historicoLocal.getImportePagado());
            movimientosLocal.setImportePagadoDivisa(historicoLocal.getImportePagadoDivisa());
            movimientosLocal.setImportePendiente(historicoLocal.getImportePendiente());

            // gPineda - 24/02/2007 - C-CCC-008
            movimientosLocal.setImporteMovimiento( historicoLocal.getImporteMovimiento() );
            movimientosLocal.setImportePago( historicoLocal.getImportePago() );

            movimientosLocal.setIndicaDescuentoRecargo(historicoLocal.getIndicaDescuentoRecargo());
            //		movimientosLocal.setMarca();
            movimientosLocal.setMarcaSituacion(historicoLocal.getMarcaSituacion());
            movimientosLocal.setMedioPago(historicoLocal.getMedioPagoTeorico());

            //			movimientosLocal.setNumeroLoteContabilizacion(historicoLocal.getNumeroLoteContabilizacion());
            //			movimientosLocal.setNumeroSerieCuota(historicoLocal.getNumeroSerieCuota());
            movimientosLocal.setObservaciones(historicoLocal.getObservaciones());

            //		movimientosLocal.setOid(historicoLocal.getOid());
            //			movimientosLocal.setPais(historicoLocal.getPais());
            //		movimientosLocal.setPeriodoDesde();
            movimientosLocal.setReferenciaNumeroDocumentoExterno(historicoLocal.getRefNumDocExt());

            //		movimientosLocal.setSubacceso();
            //		movimientosLocal.setSubprocesoDeCreacion();
            movimientosLocal.setSubprocesoUltimo(historicoLocal.getSubproceso());

            //		movimientosLocal.setTerritorioSeccion();
            //		movimientosLocal.setTipoAbonoCreacion();
            movimientosLocal.setTipoAbonoUltimo(historicoLocal.getTipoAbono()); //BELC300003068
            movimientosLocal.setTipoCliente(historicoLocal.getTipoCliente());
            movimientosLocal.setUltimoDocumentoAnyo(historicoLocal.getUltimoDocumentoAnyo());
            movimientosLocal.setUltimoDocumentoMesSerie(historicoLocal.getUltimoDocumentoMesSerie());
            movimientosLocal.setUltimoDocumentoNumero(historicoLocal.getUltimoDocumentoNumero());

            movimientosLocal.setUltimoNumeroHistoria(new Integer(movimientosLocal.getUltimoNumeroHistoria()
                                                                                 .intValue() -
                    1));
        } catch (Exception re) {
            ctx.setRollbackOnly();
            this.loguearError(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

		/*
			De la entidad Movimientos Cuenta Corriente:
			Tenemos una FK contra Subprocesos Ultimo: SUBP_OID_SUBP_ULTI
			Debemos hacer una consulta que nos devuelva el codigoProceso (marcas último) y codigoSubproceso:

			resultset regs=DAOCCC.obtenerProcUltimoSubprocMovCC(oidMovCC);
			Devolvemos el único registro recuperado con dos campos: 
			codigoProceso=recordset.COD_PROC y codigoSubproceso=recordset.COD_SUBP.

			Si  (codigoProceso == 'CCC002' AND codigoSubproceso=='1')
			{
			buscamos el último movimento bancario aplicado y hacemos un retroceso del movimiento. Invocamos para ello el
			método siguiente:
			  MONCuentasCorrientes.ultimoMovBancAplicado(oidCliente, oidPais,   numeroOrdenCuota)

			Si se produce una Exception la relanzamos y salimos de este método.
			}
		 */
		RecordSet regs = new RecordSet();
		regs = daoCCC.obtenerProcUltimoSubprocMovCC(movimientosLocal.getOid());
		String codigoProceso = new String();
		String codigoSubproceso = new String();
		codigoProceso=regs.getValueAt(0,"COD_PROC").toString();
		codigoSubproceso=regs.getValueAt(0,"COD_SUBP").toString();
		//Comentado por incidencia 9600 y 10365
		//if ((codigoProceso.equals("CCC002")) && (codigoSubproceso.equals("1"))){
			//Tapones tapon = new Tapones();
		//para poder compilar--->> da error de not found in class es.indra.log.ccc.Tapones >>>	
			//tapon.ultimoMovBancAplicado(movimientosLocal.getCliente(),dtoMov.getOidPais(),movimientosLocal.getNumeroOrdenCuota());
		
		//}		

        /*
         * -Llamamos al remove del entity histórico.
        */
        try {
            homeHMCC.remove(historicoLocal);
        } catch (PersistenceException ex) {
            ctx.setRollbackOnly();
            this.loguearError(ex);
           // throw new MareException(new Exception(),
		   // Variables no encontradas en ErroresDeNegocio>>>>>>>>>>>>>>>
		   throw new MareException(new Exception(),
           UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                   ErroresDeNegocio.CCC_0052));
        }

        /*
         * if (historicoMovimientosCC.importePagado <> movimientosCuentasCorrientes.importePagado) {
         *   Llamamos al metodo actualizarEstadoCartera de la interfaz ICartera de COB
         *   pasandole los siguientes parametros:
         *   -movimientoCC = el parametro movimiento
         * }
        */
		/*
        double importeHistorico = historicoLocal.getImportePagado().doubleValue();
        double importeCuenta = movimientosLocal.getImportePagado().doubleValue();

        if (importeHistorico != importeCuenta) {
            Tapon icartera = new Tapon();
            icartera.actualizarEstadoCartera(movimientosLocal.getOid());
        }*/
			//Modificado por incidencia 9792
		//Tapon icartera = new Tapon();
        DTOActualizacionCartera dtoActuCartera = new DTOActualizacionCartera();
		dtoActuCartera.setOidCuota(movimientosLocal.getOid());
        dtoActuCartera.setOidMarca(movimientosLocal.getMarca());
        dtoActuCartera.setImporteDeudaCancelada(movimientosLocal.getImportePago());
        dtoActuCartera.setOidSubacceso(movimientosLocal.getSubacceso());
        dtoActuCartera.setOidEstadoAsignacion(null);
        
        try{
            MONAsignacionCarteraPeriodoHome monAsignacionCarteraPeriodo = this.getMONAsignacionCarteraPeriodoHome();
            MONAsignacionCarteraPeriodo monAsigCartePeri  = monAsignacionCarteraPeriodo.create();
            monAsigCartePeri.actualizarEstadoCartera(dtoActuCartera);
        } catch (NamingException namingException) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(namingException);
            throw new MareException(namingException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException createException) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(createException);
            throw new MareException(createException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        UtilidadesLog.info("MONCuentasCorrientesBean.retrocesoCuenta(DTOMovimientoCuentaCompleto dtoMov): Salida");
    }

    /**
     * Delegamos la peticion en el metodo del mismo nombre del DAOCuentasCorrientes     
     * @param criterios DTO del tipo DTOBuscarCuentasCorrientes
     * @exception MareException
     * @return DTOSalida
     */
    public DTOSalida buscarCuotasPendientesCancelacion(
        DTOBuscarCuentasCorrientes criterios) throws MareException {
        /* Se cambia el DTO de entrada, que debe ser DTOBuscarCuentasCorrientes.
         * Ver incidencias BELC300002959 y BELC300002963
         */
        UtilidadesLog.info("MONCuentasCorrientesBean.buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes criterios): Entrada");
        /*
         *  Construimos un array de OIDs con la columna de los OIDs del DTOSalida.recordset y lo envolvemos en un DTOOIDs.
         *  if ( ! bloquearMovCC(dtoOIDs) )
         *  throw new MareException("CCC-0044");
         *  // "Algunos movimientos están bloqueados por otros usuarios"
         * Devolvemos el DTOSalida
         *
         */
        String usuario = ctx.getCallerPrincipal().getName();

        DTOSalida dtoSalida = (new DAOCuentasCorrientes(usuario)).buscarCuotasPendientesCancelacion(criterios);

        //AÑADIDO SEGUN PAQUETE N27-2
        Vector oidsCuotasV = new Vector();
        oidsCuotasV = dtoSalida.getResultado().getColumn(dtoSalida.getResultado()
                                                                  .getColumnPosition("OID")); //Columna OID
        UtilidadesLog.debug("oidsCuotasV: " + oidsCuotasV);

        Long[] oidsCuotasA = new Long[oidsCuotasV.size()];
        int i;

        for (i = 0; i < oidsCuotasV.size(); i++) {
            oidsCuotasA[i] = new Long(((BigDecimal)oidsCuotasV.elementAt(i)).longValue());
        }

        DTOOIDs dtoOIDs = new DTOOIDs();
        dtoOIDs.setOids(oidsCuotasA);

        if (!(this.bloquearMovCC(dtoOIDs).booleanValue())) {
            UtilidadesLog.debug(
                "** Algunos Movimientos están bloqueados por otros usuarios");
            throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC ,
                    "", ErroresDeNegocio.CCC_0049));
        }

        /*
                //Actualizamos el campo "bloqueado" (oculto) obtenido en el //DTOSalida anterior.
                //Recorremos el DTOSalida
                Long timeOut = new Long(0);

                //Máximo segundos bloqueo (Constante del fichero properties).
                //***********************************************************************
                try {
                    //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
                    BufferedReader br = new BufferedReader(new FileReader(
                                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                                                        "c:\\oc4j903\\mare-conf\\application.properties"));
                    String str;

                    while ((str = br.readLine()) != null) { //por cada linea.

                        StringTokenizer st = new StringTokenizer(str, "=");
                        String[] dat = new String[st.countTokens()];
                        int x = 0;

                        while (st.hasMoreTokens()) {
                            String cadena = st.nextToken();
                            cadena = cadena.trim();

                            if (cadena.equals((Object) "application.timeOutBloqueo")) {
                                timeOut = new Long((String) st.nextToken().trim());
                            }
                        }
                    }
                } catch (NoSuchElementException nse) {
                    throw new MareException(nse,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
                } catch (FileNotFoundException fnf) { //FileReader
                    throw new MareException(fnf,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
                }catch (IOException ioe) { //BufferedReader
                    throw new MareException(ioe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
                }

                //******************************************************************************
                int numRegs = dtoSalida.getResultado().getRowCount();

                dtoSalida.getResultado().addColumn((Object) "bloqueado");

                BloqueoMovCCLocalHome home = this.getBloqueoMovCCLocalHome();

                for (int i = 0; i < numRegs; i++) {
                    //Long oidMov=(Long) dtoSalida.getResultado().getValueAt(i,"oidMovimiento");
                    Long oidMov = new Long(dtoSalida.getResultado().getValueAt(i, "OID").toString());

                    try {
                        BloqueoMovCCLocal local = home.findByUk(oidMov);

                        //De otro usuario pero con el tiempo excedido
                        if (!(local.getUsuario().equals(usuario)) &&
                                ((System.currentTimeMillis() -
                                local.getTiempo().longValue()) > timeOut.longValue())) {
                            local.setUsuario(usuario);
                            local.setTiempo(new Long(System.currentTimeMillis()));

                            Object valor = new Integer(0);
                                                //dtoSalida.getResultado().setColumn("bloqueado",0);
                            dtoSalida.getResultado().setValueAt(valor, i, dtoSalida.getResultado().getColumnPosition("bloqueado"));

                        } else if ((local.getUsuario().equals(usuario)) &&
                                ((System.currentTimeMillis() -
                                local.getTiempo().longValue()) < timeOut.longValue())) {
                            Object valor = new Integer(0);
                            //dtoSalida.getResultado().setColumn("bloqueado",0);
                            dtoSalida.getResultado().setValueAt(valor, i, dtoSalida.getResultado().getColumnPosition("bloqueado"));
                        } else {
                            Object valor = new Integer(1);
                            //dtoSalida.getResultado().setColumn("bloqueado",1);
                            dtoSalida.getResultado().setValueAt(valor, i, dtoSalida.getResultado().getColumnPosition("bloqueado"));
                        }
                    } catch (FinderException e) {
                        //No encontrado, lo creamos
                        try {
                            home.create(usuario,
                                                                        new Long(System.currentTimeMillis()),
                                                                        oidMov);

                            Object valor = new Integer(0);
                            dtoSalida.getResultado().setValueAt(valor, i, dtoSalida.getResultado().getColumnPosition("bloqueado"));
                        } catch (CreateException ce) {
                            this.loguearError("*** Error en buscarCuotasPendientesCancelacion",
                                e);

                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(codigoError));
                        }
                    }
                }*/
        UtilidadesLog.info("MONCuentasCorrientesBean.buscarCuotasPendientesCancelacion(DTOBuscarCuentasCorrientes criterios): Salida");

        return dtoSalida;
    }


    public void actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta): Entrada");
        UtilidadesLog.info("**** DTOMovimientoCuentaCompleto = "+movimientoCuenta);

        // Hacemos un findByPrimaryKey en la entidad MovimientosCuentasCorrientes con el oid del dto. 
        MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
        MovimientosCuentasCorrientesLocal localMovimientos = null;

        try {
            localMovimientos = homeMCC.findByUK(movimientoCuenta.getSubacceso(),
                    movimientoCuenta.getEjercicioCuota(),
                    movimientoCuenta.getNumeroIdentificadorCuota(),
                    movimientoCuenta.getNumeroOrdenCuota(),
                    movimientoCuenta.getOidPais());
        } catch (FinderException fe) {
            UtilidadesLog.info("*** FinderException de MovimientosCC *** ");
            /*
             * Si no la localizamos debemos insertarla nueva. Invocaremos
             * al método create del entity MovimientosCuentaCorriente con
             * los parámetros del dto recibido estableciendo el atributo
             * ultimoNumeroHistoria=0. Finalizamos el CU
             */
            try {
                UtilidadesLog.info("*** Se realiza el create en movimientosCuentasCorrientes *** ");
                localMovimientos = homeMCC.create(movimientoCuenta.getEmpresa(),
                        movimientoCuenta.getMarcaSituacion(),
                        movimientoCuenta.getDivisa(),
                        movimientoCuenta.getPeriodoDesde(),
                        movimientoCuenta.getTipoAbonoUltimo(),
                        movimientoCuenta.getTipoAbonoCreacion(),
                        movimientoCuenta.getSubacceso(),
                        movimientoCuenta.getSubprocesoUltimo(),
                        movimientoCuenta.getSubprocesoCreacion(),
                        movimientoCuenta.getCuentaOrigen(),
                        movimientoCuenta.getCuentaCuota(),
                        movimientoCuenta.getOidCliente(),
                        movimientoCuenta.getDocumentoAnyo(),
                        movimientoCuenta.getDocumentoMesSerie(),
                        movimientoCuenta.getDocumentoNumero(),
                        movimientoCuenta.getEjercicioCuota(),
                        new java.sql.Date( movimientoCuenta.getFechaContabilizacion().getTime()),
                        new Timestamp ((movimientoCuenta.getFechaDocumento()).getTime()),
                        new Timestamp (movimientoCuenta.getFechaUltimoMovimiento().getTime()),
                        new Timestamp ((movimientoCuenta.getFechaValor()).getTime()),
                        new java.sql.Date(movimientoCuenta.getFechaVencimiento().getTime()),
                        movimientoCuenta.getImporte(),
                        movimientoCuenta.getImporteDivisa(),
                        movimientoCuenta.getImportePagado(),
                        movimientoCuenta.getImportePagadoDivisa(),
                        movimientoCuenta.getImportePendiente(),
                        movimientoCuenta.getIndicaDescuentoRecargo(),
                        movimientoCuenta.getNumeroIdentificadorCuota(),
                        movimientoCuenta.getNumeroLoteContabilizacion(),
                        movimientoCuenta.getNumeroOrdenCuota(),
                        movimientoCuenta.getObservaciones(),
                        movimientoCuenta.getReferenciaNumeroDocumentoExterno(),
                        movimientoCuenta.getUltimoDocumentoAnyo(),
                        movimientoCuenta.getUltimoDocumentoMesSerie(),
                        movimientoCuenta.getUltimoDocumentoNumero(),
                        new Integer(0),
                        movimientoCuenta.getMedioPago(),
                        movimientoCuenta.getTerritorioAdministrativo(),
                        movimientoCuenta.getTipoCliente(),
                        movimientoCuenta.getMarca(),
                        movimientoCuenta.getTipoCambio(),
                        movimientoCuenta.getUsuario(),
                        movimientoCuenta.getOidSubtipoCliente(),
                        movimientoCuenta.getOidSugerenciaVenta(),
                        movimientoCuenta.getOidSeccion(),
                        movimientoCuenta.getNumeroLoteFactu(),
                        movimientoCuenta.getImportePago(),
                        movimientoCuenta.getImportePagoDivisa(),
                        movimientoCuenta.getImporteMovimientoDivisa(),
                        movimientoCuenta.getTipoPeriodoDesde(),
                        movimientoCuenta.getOidTipoDocumentoLegal(),
                        movimientoCuenta.getOidTipoSolicitud(),
                        movimientoCuenta.getOidRegion(),
                        null, //movimientoCuenta.getConsolidado() 
                        movimientoCuenta.getImporteMovimiento());
						return;
            } catch (CreateException e) {
                this.loguearError(e);
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

         
        //double importeHistorico = localHistorico.getImporte().doubleValue();
        
        //obtenemos el importe pendiente que luego se usa para
        //la actualización de cartera de clientes.
        double importeHistorico = localMovimientos.getImportePendiente().doubleValue();
        HelperHistorial helper = new HelperHistorial();
        helper.generarHistoriaCuentaCorriente(localMovimientos.getOid());

        // Actualizamos los valores del entity encontrado en el primer paso, con los valores del DTOMovimientoCuenta. 
        localMovimientos.setCliente(movimientoCuenta.getOidCliente());
        localMovimientos.setCodigoUsuario(movimientoCuenta.getUsuario());
        localMovimientos.setCuentaCuota(movimientoCuenta.getCuentaCuota());
        localMovimientos.setCuentaOrigen(movimientoCuenta.getCuentaOrigen());
        localMovimientos.setDivisa(movimientoCuenta.getDivisa());
        localMovimientos.setDocumentoAnyo(movimientoCuenta.getDocumentoAnyo());
        localMovimientos.setDocumentoMesSerie(movimientoCuenta.getDocumentoMesSerie());
        localMovimientos.setDocumentoNumero(movimientoCuenta.getDocumentoNumero());
        localMovimientos.setEjercicioCuota(movimientoCuenta.getEjercicioCuota());
        localMovimientos.setEmpresa(movimientoCuenta.getEmpresa());
        if (movimientoCuenta.getFechaContabilizacion() != null) {
            localMovimientos.setFechaContabilizacion(new java.sql.Date(
                    (movimientoCuenta.getFechaContabilizacion()).getTime()));
        } else {
            localMovimientos.setFechaContabilizacion(null);
        }
        //fechaDocumento no puede ser null en BBDD
        localMovimientos.setFechaDocumento(new java.sql.Timestamp((movimientoCuenta.getFechaDocumento()).getTime()));
        //fechaUltimoMovimiento no puede ser null
        localMovimientos.setFechaUltimoMovimiento(new java.sql.Timestamp((movimientoCuenta.getFechaUltimoMovimiento()).getTime()));
        if (movimientoCuenta.getFechaValor() != null) {
            localMovimientos.setFechaValor(new java.sql.Timestamp((movimientoCuenta.getFechaValor()).getTime()));
        } else {
            localMovimientos.setFechaValor(null);
        } 
        if (movimientoCuenta.getFechaVencimiento() != null) {
            localMovimientos.setFechaVencimiento(new java.sql.Date((movimientoCuenta.getFechaVencimiento()).getTime()));
        } else {
            localMovimientos.setFechaVencimiento(null);
        }
        localMovimientos.setImporte(movimientoCuenta.getImporte());
        localMovimientos.setImporteDivisa(movimientoCuenta.getImporteDivisa());
        localMovimientos.setImporteMovimiento(movimientoCuenta.getImporteMovimiento());
        localMovimientos.setImporteMovimientoDivisa(movimientoCuenta.getImporteMovimientoDivisa());
        
        //SCS, segun inc.: V-CCC-013
        localMovimientos.setImportePagado( new Double(localMovimientos.getImportePagado().doubleValue() + 
                                                      movimientoCuenta.getImportePagado().doubleValue()) );

        //localMovimientos.setImportePagado(movimientoCuenta.getImportePagado());
        localMovimientos.setImportePagadoDivisa(movimientoCuenta.getImportePagadoDivisa());
        localMovimientos.setImportePago(movimientoCuenta.getImportePago());
        localMovimientos.setImportePagoDivisa(movimientoCuenta.getImportePagoDivisa());
        localMovimientos.setImportePendiente(movimientoCuenta.getImportePendiente());
        localMovimientos.setIndicaDescuentoRecargo(movimientoCuenta.getIndicaDescuentoRecargo());
        localMovimientos.setMarca(movimientoCuenta.getMarca());
        localMovimientos.setMarcaSituacion(movimientoCuenta.getMarcaSituacion());
        localMovimientos.setMedioPago(movimientoCuenta.getMedioPago());
        localMovimientos.setNumeroIdentificadorCuota(movimientoCuenta.getNumeroIdentificadorCuota());
        localMovimientos.setNumeroLoteContabilizacion(movimientoCuenta.getNumeroLoteContabilizacion());
        localMovimientos.setNumeroLoteFacturacion(movimientoCuenta.getNumeroLoteFactu());
        localMovimientos.setNumeroOrdenCuota(movimientoCuenta.getNumeroOrdenCuota());
        localMovimientos.setObservaciones(movimientoCuenta.getObservaciones());
        localMovimientos.setPeriodoDesde(movimientoCuenta.getPeriodoDesde());
        localMovimientos.setReferenciaNumeroDocumentoExterno(movimientoCuenta.getReferenciaNumeroDocumentoExterno());
        localMovimientos.setRegion(movimientoCuenta.getOidRegion());
        localMovimientos.setSeccion(movimientoCuenta.getOidSeccion());
        localMovimientos.setSubacceso(movimientoCuenta.getSubacceso());
        localMovimientos.setSubprocesoDeCreacion(movimientoCuenta.getSubprocesoCreacion());
        localMovimientos.setSubprocesoUltimo(movimientoCuenta.getSubprocesoUltimo());
        localMovimientos.setSubtipoCliente(movimientoCuenta.getOidSubtipoCliente());
        localMovimientos.setSugerencia(movimientoCuenta.getOidSugerenciaVenta());
        localMovimientos.setTerritorioAdministrativo(movimientoCuenta.getTerritorioAdministrativo());
        localMovimientos.setTipoAbonoCreacion(movimientoCuenta.getTipoAbonoCreacion());
        localMovimientos.setTipoAbonoUltimo(movimientoCuenta.getTipoAbonoUltimo());
        localMovimientos.setTipoCambio(movimientoCuenta.getTipoCambio());
        localMovimientos.setTipoCliente(movimientoCuenta.getTipoCliente());
        localMovimientos.setTipoDocumentoLegal(movimientoCuenta.getOidTipoDocumentoLegal());
        localMovimientos.setTipoPeriodo(movimientoCuenta.getTipoPeriodoDesde());
        localMovimientos.setTipoSolicitud(movimientoCuenta.getOidTipoSolicitud());
        localMovimientos.setUltimoDocumentoAnyo(movimientoCuenta.getUltimoDocumentoAnyo());
        localMovimientos.setUltimoDocumentoMesSerie(movimientoCuenta.getUltimoDocumentoMesSerie());
        localMovimientos.setUltimoDocumentoNumero(movimientoCuenta.getUltimoDocumentoNumero());
        localMovimientos.setUltimoNumeroHistoria(movimientoCuenta.getUltimoNumeroHistoria());
        UtilidadesLog.debug("Metodo actualizarCuenta: setters -----> localMovimiento");

        //double importeHistorico = localHistorico.getImporte().doubleValue();
        double importeCuenta = movimientoCuenta.getImporte().doubleValue();

        UtilidadesLog.debug("importeHistorico : " + importeHistorico);
        UtilidadesLog.debug("importeCuenta : " + importeCuenta);
        
         DTOActualizacionCartera dtoActuCartera = new DTOActualizacionCartera();
         dtoActuCartera.setOidCuota(localMovimientos.getOid());
         dtoActuCartera.setOidPais(movimientoCuenta.getOidPais());
         dtoActuCartera.setOidMarca(localMovimientos.getMarca());
         dtoActuCartera.setImporteDeudaCancelada(new BigDecimal(localMovimientos.getImportePagado().doubleValue()));
         dtoActuCartera.setOidSubacceso(localMovimientos.getSubacceso());
         dtoActuCartera.setOidEstadoAsignacion(null);
         try{
             MONAsignacionCarteraPeriodoHome monAsignacionCarteraPeriodo = this.getMONAsignacionCarteraPeriodoHome();
             MONAsignacionCarteraPeriodo monAsigCartePeri  = monAsignacionCarteraPeriodo.create();
             monAsigCartePeri.actualizarEstadoCartera(dtoActuCartera);
         } catch (NamingException namingException) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(namingException);
             throw new MareException(namingException,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         } catch (CreateException createException) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(createException);
             throw new MareException(createException,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         } catch (RemoteException re) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(re);
             throw new MareException(re,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta): Salida");
    }


    /**
     * Delegamos en el metodo obtenerCuentasCorrientesEmpresa el DAOCuentasCorrientes     
     * @param dto DTO del tipo DTOOID
     * @exception MareException
     * @return DTOSalida
     */
    public DTOSalida cargaInicialAplicacionCobros(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.cargaInicialAplicacionCobros(DTOOID dto): Entrada");

        // Delegamos en el metodo obtenerCuentasCorrientesEmpresa el DAOCuentasCorrientes
        String usuario = ctx.getCallerPrincipal().getName();
        DTOSalida dtoSalida = (new DAOCuentasCorrientes(usuario)).obtenerCuentasCorrientesEmpresa(dto);
        UtilidadesLog.info("MONCuentasCorrientesBean.cargaInicialAplicacionCobros(DTOOID dto): Salida");

        return dtoSalida;
    }

    /**
     * Delegamos en el metodo del mismo nombre de DAOCuentasCorrientes
     * Actualizamos el campo "bloqueado" (oculto) obtenido en el DTOSalida     
     * @param dto DTO del tipo DTOBuscarCuotasPendientes
     * @exception MareException
     * @return DTOSalida
     */
    public DTOSalida buscarCuotasPendientes(DTOBuscarCuotasPendientes dto)
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.buscarCuotasPendientes(DTOBuscarCuotasPendientes dto): Entrada");

        // Delegamos en el metodo del mismo nombre de DAOCuentasCorrientes
        String usuario = ctx.getCallerPrincipal().getName();
        DTOSalida dtoSalida = (new DAOCuentasCorrientes(usuario)).buscarCuotasPendientes(dto);

        //Construimos un array de OIDs con la columna de los OIDs del DTOSalida.recordset y lo envolvemos en un DTOOIDs. 
        DTOOIDs dtoOIDs = new DTOOIDs();
        Long[] array = new Long[dtoSalida.getResultado().getRowCount()];

        for (int i = 0; i < dtoSalida.getResultado().getRowCount(); i++) {
            array[i] = new Long(((BigDecimal) dtoSalida.getResultado()
                                                       .getValueAt(i, "OID")).longValue());
        }

        dtoOIDs.setOids(array);

        //if ( ! bloquearBancCC(dtoOIDs) ) 
        //throw new MareException("CCC-0044"); 
        // "Algunos movimientos están bloqueados por otros usuarios" 

/*
        if (bloquearMovBanc(dtoOIDs) == Boolean.FALSE) { //Comprobar
            //throw new MareException("CCC-0044");
			ExcepcionParametrizada excepcionParam = new ExcepcionParametrizada("",UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",

                                              ErroresDeNegocio.CCC_0049)); 

//en el SICCErrores.properties el mensaje de: 
//"Algunos movimientos están bloqueados por otros usuarios" corresponde al "CCC_0049"

                                               excepcionParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);

                                               excepcionParam.addParameter(" "+((BigDecimal)dtoSalida.getResultado()
                                                       .getValueAt(0, "OID")).longValue());

                                               throw excepcionParam;     

        }*/
        if (!(this.bloquearMovBanc(dtoOIDs).booleanValue())) {
            UtilidadesLog.debug(
                "** Algunos Movimientos están bloqueados por otros usuarios");
            throw new MareException(new Exception(),
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC ,
                                    "", ErroresDeNegocio.CCC_0049));
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.buscarCuotasPendientes(DTOBuscarCuotasPendientes dto): Salida");

        //Devolvemos el DTOSalida 
        return dtoSalida;
    }

    /*//ANTIGUO
            //Actualizamos el campo "bloqueado" (oculto) obtenido en el //DTOSalida anterior.
            //Recorremos el DTOSalida
            Long timeOut = new Long(0);

            //Máximo segundos bloqueo (Constante del fichero properties).
            //***********************************************************************
            try {
                BufferedReader br = new BufferedReader(new FileReader(
                            //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                                                    "c:\\oc4j903\\mare-conf\\application.properties"));
                String str;

                while ((str = br.readLine()) != null) { //por cada linea.

                    StringTokenizer st = new StringTokenizer(str, "=");
                    String[] dat = new String[st.countTokens()];
                    int x = 0;

                    while (st.hasMoreTokens()) {
                        String cadena = st.nextToken();
                        cadena = cadena.trim();

                        if (cadena.equals((Object) "application.timeOutBloqueo")) {
                            timeOut = new Long((String) st.nextToken().trim());
                        }
                    }
                }
            } catch (NoSuchElementException nse) {
                throw new MareException(nse,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
            } catch (FileNotFoundException fnf) { //FileReader
                throw new MareException(fnf,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
            }catch (IOException ioe) { //BufferedReader
                throw new MareException(ioe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
            }

            //******************************************************************************
            int numRegs = dtoSalida.getResultado().getRowCount();
            dtoSalida.getResultado().addColumn((Object) "bloqueado");
            int numColumna = dtoSalida.getResultado().getColumnPosition("bloqueado");
            BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();

            for (int i = 0; i < numRegs; i++) {
                //Long oidMov=(Long) dtoSalida.getResultado().getValueAt(i,"oidMovimiento");
                Long oidMov = new Long(dtoSalida.getResultado()
                                                .getValueAt(i, "OID")
                                                .toString());

                try {
                    BloqueoMovBancLocal local = home.findByUk(oidMov);

                    //De otro usuario pero con el tiempo excedido
                    if (!(local.getUsuario().equals(usuario)) &&
                            ((System.currentTimeMillis() -
                            local.getTiempo().longValue()) > timeOut.longValue())) {
                        local.setUsuario(usuario);
                        local.setTiempo(new Long(System.currentTimeMillis()));

                        Object valor = new Integer(0);
                        dtoSalida.getResultado().setValueAt(valor, i, numColumna);

                    } else if ((local.getUsuario().equals(usuario)) &&
                            ((System.currentTimeMillis() -
                            local.getTiempo().longValue()) < timeOut.longValue())) {
                        Object valor = new Integer(0);
                        dtoSalida.getResultado().setValueAt(valor, i, numColumna);


                    } else {

                        Object valor = new Integer(1);
                        dtoSalida.getResultado().setValueAt(valor, i, numColumna);
                    }
                } catch (Exception e) {
                    //No encontrado, lo creamos
                    try {
                                                home.create(usuario,
                                                    new Long(System.currentTimeMillis()),
                                                    oidMov);
                                                    /*home.create(usuario,
                                                    new Long(2234589),
                                                    oidMov);*/
    /*           Object valor = new Integer(0);
               dtoSalida.getResultado().setValueAt(valor, i, numColumna);
           } catch (CreateException ce) {
               this.loguearError("*** Error en buscarCuotasPendientes", e);

               String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
               throw new MareException(e,
                   UtilidadesError.armarCodigoError(codigoError));
           }
       }
    }*/
    /*        UtilidadesLog.debug("****Metodo buscarCuotasPendientes: Salida");

            return dtoSalida;

        }*/

    //BELC300003512
    public DTOSalida obtieneSucursalesBanco(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneSucursalesBanco(DTOOID dto): Entrada");

        /*
         * Delegamos en el método del mismo nombre del DAOCCC
         */
        RecordSet resultado = (new DAOCCC()).obtieneSucursalesBanco(dto);
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneSucursalesBanco(DTOOID dto): Salida");

        return dtoSalida;
    }

    //BELC300003512
    public DTOSalida obtieneCuentasSucursal(DTOOID dto)
        throws MareException {
        /*
         * Delegamos en el método del mismo nombre del DAOCCC y metemos el
         * resultado en un DTOSalida
         */
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneCuentasSucursal(DTOOID dto): Entrada");

        /*
         * Delegamos en el método del mismo nombre del DAOCCC
         */
        RecordSet resultado = (new DAOCCC()).obtieneCuentasSucursal(dto);
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneCuentasSucursal(DTOOID dto): Salida");

        return dtoSalida;
    }

    private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getMONValidacion(): Entrada");

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

        UtilidadesLog.info("MONCuentasCorrientesBean.getMONValidacion(): Salida");

        return ejb;
    }

    private MONConfiguracionClientes getMONConfiguracionClientes()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getMONConfiguracionClientes(): Entrada");

        // Se obtiene el interfaz home
        MONConfiguracionClientesHome home = (MONConfiguracionClientesHome) UtilidadesEJB.getHome(MON_CONFIGURACION_CLIENTES,
                MONConfiguracionClientesHome.class);

        // Se obtiene el interfaz remoto
        MONConfiguracionClientes ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError(e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.getMONConfiguracionClientes(): Salida");

        return ejb;
    }

    private HistoricoMovimientosCCLocalHome getHistoricoMovimientosCCLocalHome()
        throws MareException {
        
        UtilidadesLog.info("MONCuentasCorrientesBean.getHistoricoMovimientosCCLocalHome(): Entrada");                
        UtilidadesLog.info("MONCuentasCorrientesBean.getHistoricoMovimientosCCLocalHome(): Salida");
        return new HistoricoMovimientosCCLocalHome();
    }

    private MovimientosCuentasCorrientesLocalHome getMovimientosCuentasCorrientesLocalHome()
        throws MareException {
        
        UtilidadesLog.info("MONCuentasCorrientesBean.getMovimientosCuentasCorrientesLocalHome(): Entrada");

        MovimientosCuentasCorrientesLocalHome home = (MovimientosCuentasCorrientesLocalHome) UtilidadesEJB.getLocalHome(
                "java:comp/env/MovimientosCuentasCorrientes");
                
        UtilidadesLog.info("MONCuentasCorrientesBean.getMovimientosCuentasCorrientesLocalHome(): Salida");

        return home;
    }

    private void loguearError(Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("Error ",e);
    }

    private void loguearSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("MONCuentasCorrientesBean.loguearSql(String metodo, String sql, Vector params): Entrada");
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
        UtilidadesLog.info("MONCuentasCorrientesBean.loguearSql(String metodo, String sql, Vector params): Salida");
    }

    public DTOSalida obtenerDetalleMovimientos(DTOOIDs dto)
        throws MareException {
        /*
         * //Obtiene los campos numeroSerie, numeroIdentificacion, ejercicio,
         * numeroOrdenCuota, codigoCliente, fechaDocumento, fechaVencimiento,
         * importe, medioPago de los movimientos indicados
         * Delegamos en el método del mismo nombre del DAOCuentasCorrientes.
         */
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDetalleMovimientos(DTOOIDs dto): Entrada");

        String usuario = ctx.getCallerPrincipal().getName();
        DAOCuentasCorrientes dao = new DAOCuentasCorrientes(usuario);
        DTOSalida dtoSalida = dao.obtenerDetalleMovimientos(dto);
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDetalleMovimientos(DTOOIDs dto): Salida");

        return dtoSalida;
    }

    public DTONumeroRegistros eliminarBloqueoMovCC(DTOOIDs dto) throws MareException {
	/**
	 *	Entrada: DTOOIDs. 
	 * 	Salida: DTONumeroRegistros 
	 *
	 *	Por cada oid del array recibido invocamos al método 
	 *	remove(oid) del interfaz Home del Entity BloqueoMovCC. 
	 *
	 *	Envolvemos el dto.recordset.getRowCount(); en un DTONumeroRegistros y lo devolvemos.
	 */
	 
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovCC(DTOOIDs dto): Entrada");

        BloqueoMovCCLocalHome home = this.getBloqueoMovCCLocalHome();

        Long[] oid = dto.getOids();
        UtilidadesLog.debug("---- OIDS: " + oid);

        for (int i = 0; i < oid.length; i++) {
            try {
                BloqueoMovCCLocal local = home.findByUk(oid[i]);
                try {
                    home.remove(local);
                } catch (PersistenceException e) {
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    this.loguearError(e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }
            } catch (NoResultException fe) {
                UtilidadesLog.debug(
                    "****Metodo eliminarBloqueosMovCC: error -----> finderException");
                this.loguearError(fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
		DTONumeroRegistros numeroRegistros = new DTONumeroRegistros();
		numeroRegistros.setNumeroRegistros(new Long(oid.length));
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovCC(DTOOIDs dto): Salida");
		return numeroRegistros;
    }

    public DTONumeroRegistros eliminarBloqueoMovBanc(DTOOIDs dto) throws MareException {
	/**
	 *	Entrada: DTOOIDs. 
	 *	Salida: DTONumeroRegistros 
	 *
	 *	Por cada oid del array recibido invocamos al método 
	 *	remove(oid) del interfaz Home del Entity BloqueoMovCC. 
	 *
	 *	Envolvemos el dto.oids.length;(9223) en un DTONumeroRegistros y lo devolvemos. 
	 */
	
		UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovBanc(DTOOIDs dto): Entrada");

        BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();		

        Long[] oid = dto.getOids();

        for (int i = 0; i < oid.length; i++) {
            try {
                //BloqueoMovBancLocal local = home.findByPrimaryKey(oid[i]);
                UtilidadesLog.debug("voy a buscar a bloq. mov. bancarios, con: " + oid[i]);
                BloqueoMovBancLocal local = home.findByUk(oid[i]);
                try {
                    home.remove(local);					
                } catch (PersistenceException e) {
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    this.loguearError(e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }
            } catch (NoResultException fe) {
                UtilidadesLog.debug(
                    "****Metodo eliminarBloqueosMovBanc: error -----> finderException");
                this.loguearError(fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
		DTONumeroRegistros numeroRegistros = new DTONumeroRegistros();
        numeroRegistros.setNumeroRegistros(new Long(oid.length));
		UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovBanc(DTOOIDs dto): Salida");
		return numeroRegistros;
    }

    private BloqueoMovBancLocalHome getBloqueoMovBancLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getBloqueoMovBancLocalHome(): Entrada");
        UtilidadesLog.info("MONCuentasCorrientesBean.getBloqueoMovBancLocalHome(): Salida");

        return new BloqueoMovBancLocalHome();
    }

    private BloqueoMovCCLocalHome getBloqueoMovCCLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getBloqueoMovCCLocalHome(): Entrada");
        UtilidadesLog.info("MONCuentasCorrientesBean.getBloqueoMovCCLocalHome(): Salida");

        return new BloqueoMovCCLocalHome();
    }

    private HistoricoMovimientosBancLocalHome getHistoricoMovimientosBancLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getHistoricoMovimientosBancLocalHome(): Entrada");

        HistoricoMovimientosBancLocalHome home = (HistoricoMovimientosBancLocalHome) UtilidadesEJB.getLocalHome(
                "java:comp/env/HistoricoMovimientosBanc");

        UtilidadesLog.info("MONCuentasCorrientesBean.getHistoricoMovimientosBancLocalHome(): Salida");

        return home;
    }

    private MovimientosBancariosLocalHome getMovimientosBancariosLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getMovimientosBancariosLocalHome(): Entrada");

        MovimientosBancariosLocalHome home = (MovimientosBancariosLocalHome) UtilidadesEJB.getLocalHome(
                "java:comp/env/MovimientosBancarios");

        UtilidadesLog.info("MONCuentasCorrientesBean.getMovimientosBancariosLocalHome(): Salida");

        return home;
    }


    /**
     * 
     */
    public void actualizarMovBancario(DTOMovimientoBancario movimientoBanc) throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesBean.actualizarMovBancario(DTOMovimientoBancario movimientoBanc): Entrada");
        // Hacemos un findByUK en la entidad MovimientosBancarios
        MovimientosBancariosLocalHome homeMCC = this.getMovimientosBancariosLocalHome();
        MovimientosBancariosLocal localMovimientos = null;

        try {
            localMovimientos = homeMCC.findByUK(movimientoBanc.getOidPais(),
                movimientoBanc.getNumeroLote(),
                movimientoBanc.getConsecutivoTransaccion());
        } catch (Exception fe) {
            this.loguearError(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.debug("OID del mov. bancario hallado: " + localMovimientos.getOid());
        UtilidadesLog.debug("OID cliente del movimiento: " + localMovimientos.getOidCliente());

        /* Llamamos al create del entity HistoricoMovimientosCC, sacando los parametros del entity que acabamos de encontrar.
         * Ahora se realiza a travez de sql de forma masiva.
         */
        //StringBuffer historico = this.armarInsertHisotricoMovimientosBancarios(localMovimientos);
        //historicosMovimientosBancario.add(historico);

         HelperHistorial hist = new HelperHistorial();
         hist.generarHistoriaBancaria(localMovimientos.getOid());

        /* Actualizamos los valores del entity encontrado en el primer paso,
        * con los valores del DTOMovimientoBancario e incrementamos en 1 el atributo numeroHistoria.
        */
		localMovimientos.setCodigoConsultora(movimientoBanc.getCodConsultoraReal());
        localMovimientos.setEmpresa(movimientoBanc.getEmpresa());
        localMovimientos.setNumeroLote(movimientoBanc.getNumeroLote());
        if (movimientoBanc.getFechaPago() != null) {
            localMovimientos.setFechaPago(new java.sql.Date(movimientoBanc.getFechaPago().getTime()));
        }
        localMovimientos.setCuentaCorriente(movimientoBanc.getCuentaCorrienteBancaria());
        localMovimientos.setConsecutivoTransaccion(movimientoBanc.getConsecutivoTransaccion());
        localMovimientos.setNumeroFacturaBoleta(movimientoBanc.getNumeroFactura());
        localMovimientos.setDigitoChequeoFactura(movimientoBanc.getDigitoChequeo());
        if (movimientoBanc.getImportePago() != null) {
            localMovimientos.setImportePago(new BigDecimal(movimientoBanc.getImportePago().doubleValue()));
        }
        if (movimientoBanc.getNumeroCupon() != null) {
            localMovimientos.setNumeroCupon(new Long(movimientoBanc.getNumeroCupon().longValue()));		
        }
        localMovimientos.setOficinaRecaudadora(movimientoBanc.getOficinaRecaudadora());
        localMovimientos.setNombreOficina(movimientoBanc.getNombreOficina());
        localMovimientos.setTipoTransaccion(movimientoBanc.getTipoTransaccion());
        localMovimientos.setHorarioNormalAdicional(movimientoBanc.getHorario());
        localMovimientos.setUsuarioProceso(movimientoBanc.getUsuarioProceso());
        localMovimientos.setConsultoraReal(movimientoBanc.getOidConsultoraReal());
        localMovimientos.setDocumentoCreacionNumero(movimientoBanc.getNumeroDocumentoCreacion());
        localMovimientos.setDocumentoCreacionMesSerie(movimientoBanc.getSerieDocumentoCreacion());
        localMovimientos.setDocumentoCreacionAnyo(movimientoBanc.getAnioDocumentoCreacion());
        localMovimientos.setDocumentoAplicacionAnyo(movimientoBanc.getAnioDocumentoAplicacion());
        localMovimientos.setDocumentoAplicacionNumero(movimientoBanc.getNumeroDocumentoAplicacion());
        localMovimientos.setDocumentoAplicacionMesSerie(movimientoBanc.getSerieDocumentoAplicacion());
        if (movimientoBanc.getFechaMovimientoAplicacion() != null) {
            localMovimientos.setFechaMovimientoAplicacion(new Timestamp(movimientoBanc.getFechaMovimientoAplicacion().getTime()));
        }
        localMovimientos.setCodigoError(movimientoBanc.getCodError());
        localMovimientos.setIdentificadorProceso(movimientoBanc.getIdentificadorProceso());
        localMovimientos.setNumeroLoteContabilizacion(movimientoBanc.getNumeroLoteContabilizacion());
        if (movimientoBanc.getFechaContabilizacion() != null) {
            localMovimientos.setFechaContabilizacion(new java.sql.Date(movimientoBanc.getFechaContabilizacion().getTime()));
        }
        localMovimientos.setObservaciones(movimientoBanc.getObservaciones());
        localMovimientos.setPais(movimientoBanc.getOidPais());
        if (movimientoBanc.getEstatusMovimientoTesoreria() != null) {
            localMovimientos.setEstatusMovimientoPendienteAplicado( movimientoBanc.getEstatusMovimientoTesoreria().toString());
        }
        localMovimientos.setTipoAbonoUltimo(movimientoBanc.getOidTipoAbonoUltimo());
        localMovimientos.setSubprocesoMarcasUltimo(movimientoBanc.getOidSubprocesoMarcaUltimo());
        localMovimientos.setSubacceso(movimientoBanc.getSubacceso());
        localMovimientos.setImporteMovimiento(movimientoBanc.getImporteMovimiento());
        localMovimientos.setImporteAplicado(movimientoBanc.getImporteAplicado());
        localMovimientos.setSaldoPendiente(movimientoBanc.getImporteSaldo().setScale(2,BigDecimal.ROUND_HALF_UP));
        if (localMovimientos.getNumeroHistoria() != null) {
            localMovimientos.setNumeroHistoria(new Integer(localMovimientos.getNumeroHistoria().intValue() + 1));
        }
        
        if(movimientoBanc.getImporteSaldo().setScale(2,BigDecimal.ROUND_HALF_UP).abs().doubleValue()==0D){
           localMovimientos.setEstatusMovimientoPendienteAplicado("A");
        }else{
           localMovimientos.setEstatusMovimientoPendienteAplicado("P");
        }
        
        //Segun incidencia V-CCC036 El movimiento bancario no actualiza
        //la fecha/hora de proceso.
        //if(movimientoBanc.getHoraProceso()!=null){
        // localMovimientos.setHoraProceso(new Timestamp(movimientoBanc.getHoraProceso().getTime()));   
        //}
        
        
        //this.grabarHistoricosMovimientosBancarios(historicosMovimientosBancario);    
        
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarMovBancario(DTOMovimientoBancario movimientoBanc): Salida");
    }
    
    
    /**
     * Arma un insert de Historico Movimientos Bancarios.
     * @autor gdmarzi
     */
    private StringBuffer armarInsertHisotricoMovimientosBancarios(MovimientosBancariosLocal localMovimientos) throws MareException {
        StringBuffer query = new StringBuffer();
        StringBuffer values = new StringBuffer();
        Long oidHistoMovBanc = SecuenciadorOID.obtenerSiguienteValor("CCC_HMCC_SEQ");
        query.append(" INSERT INTO CCC_HISTO_MOVIM_BANCA ( ");
		// Campos Obligatorios
		query.append(" oid_movi_banc, ");
        values.append( oidHistoMovBanc + ", ");
		query.append(" tcab_oid_tipo_carg_abon_crea, ");
        values.append( localMovimientos.getTipoAbonoCreacion() + ", ");
	  	query.append(" soci_oid_soci, ");
        values.append( localMovimientos.getEmpresa() + ", ");
		query.append(" clie_oid_clie, ");
        values.append( localMovimientos.getOidCliente() + ", ");
		query.append(" fec_paso_hist, ");          
        values.append(" to_date( '" + new Date(System.currentTimeMillis()) + "', 'YYYY-MM-DD'), ");           
		query.append(" subp_oid_subp_crea, ");
        values.append( localMovimientos.getSubprocesoMarcaCreacion() + ", ");
		query.append(" ccba_oid_cuen_corr_banc ");
        values.append( localMovimientos.getCuentaCorriente() );
		// Campos No Obligatorios
        
		if (localMovimientos.getSubacceso() != null) {
			query.append(", sbac_oid_sbac ");
			values.append(", ").append(localMovimientos.getSubacceso());
		}
		if (localMovimientos.getUsuarioProceso() != null) {
			query.append(", val_usua_proc ");			
			values.append(", ").append("'").append(localMovimientos.getUsuarioProceso()).append("'");
		}
		if (localMovimientos.getNumeroHistoria() != null) {
			query.append(", num_hist ");			
			values.append(", ").append(localMovimientos.getNumeroHistoria());
		}
        //Este campo es parte del constraint que falla en la CCC-01.01 (Gacevedo)
   		if (localMovimientos.getOid() != null) {//no creo que sea nulo jamas
			query.append(", cmba_oid_movi_banc ");			
			values.append(", ").append(localMovimientos.getOid());
		}
		/*if (localMovimientos.getNMovimientoCaja() != null) {
			query.append(", cmba_oid_movi_banc ");			
			values.append(", ").append(localMovimientos.getNMovimientoCaja());
		}*/
		if (localMovimientos.getOficinaRecaudadora() != null) {
			query.append(", cod_ofic_reca ");			
			values.append(", ").append("'").append(localMovimientos.getOficinaRecaudadora()).append("'");
		}
		if (localMovimientos.getNumeroDocumento() != null) {
			query.append(", val_nume_docu ");			
			values.append(", ").append("'").append(localMovimientos.getNumeroDocumento()).append("'");
		}
		if (localMovimientos.getNumeroFacturaBoleta() != null) {
			query.append(", num_fact_bole ");			
			values.append(", ").append(localMovimientos.getNumeroFacturaBoleta());
		}
		if (localMovimientos.getObservaciones() != null) {
			query.append(", val_obse ");			
			values.append(", ").append("'").append(localMovimientos.getObservaciones()).append("'");
		}
		if (localMovimientos.getNumeroLoteContabilizacion() != null) {
			query.append(", val_num_lote_cont ");			
			values.append(", ").append("'").append(localMovimientos.getNumeroLoteContabilizacion()).append("'");
		}
        if (localMovimientos.getError() != null) {
			query.append(", tier_oid_erro ");			
			values.append(", ").append(localMovimientos.getError());
		}
        if (localMovimientos.getTipoAbonoUltimo() != null) {
			query.append(", tcab_oid_tipo_carg_abon_ulti ");			
			values.append(", ").append(localMovimientos.getTipoAbonoUltimo());
		}
        if (localMovimientos.getTipoTransaccion() != null) {
			query.append(", ttra_oid_tipo_tran ");			
			values.append(", ").append(localMovimientos.getTipoTransaccion());
		}
        if (localMovimientos.getSubprocesoMarcasUltimo() != null) {
			query.append(", subp_oid_subp_ulti ");			
			values.append(", ").append(localMovimientos.getSubprocesoMarcasUltimo());
		}
        if (localMovimientos.getSaldoPendiente() != null) {
			query.append(", imp_sald_pend ");			
			values.append(", ").append(localMovimientos.getSaldoPendiente());
		}
        if (localMovimientos.getImporteAplicado() != null) {
			query.append(", imp_apli ");			
			values.append(", ").append(localMovimientos.getImporteAplicado());
		}
        if (localMovimientos.getNumeroLoteExterno() != null) {
			query.append(", num_lote_exte ");			
			values.append(", ").append(localMovimientos.getNumeroLoteExterno());
		}
        if (localMovimientos.getDocumentoAplicacionMesSerie() != null) {
			query.append(", val_docu_apli_mes_seri ");			
			values.append(", ").append(localMovimientos.getDocumentoAplicacionMesSerie());
		}
        if (localMovimientos.getDocumentoAplicacionAnyo() != null) {
			query.append(", val_docu_apli_anio ");			
			values.append(", ").append(localMovimientos.getDocumentoAplicacionAnyo());
		}
        if (localMovimientos.getDocumentoAplicacionNumero() != null) {
			query.append(", val_docu_apli_nume ");			
			values.append(", ").append(localMovimientos.getDocumentoAplicacionNumero());
		}
        if (localMovimientos.getDocumentoCreacionMesSerie() != null) {
			query.append(", val_docu_crea_mes_seri ");			
			values.append(", ").append(localMovimientos.getDocumentoCreacionMesSerie());
		}
        if (localMovimientos.getDocumentoCreacionAnyo() != null) {
			query.append(", val_docu_crea_anio ");			
			values.append(", ").append(localMovimientos.getDocumentoCreacionAnyo());
		}
        if (localMovimientos.getDigitoChequeoFactura() != null) {
			query.append(", val_digi_cheq_fact ");			
			values.append(", ").append(localMovimientos.getDigitoChequeoFactura());
		}
        if (localMovimientos.getNumeroLote() != null) {
			query.append(", num_lote ");			
			values.append(", ").append(localMovimientos.getNumeroLote());
		}
        if (localMovimientos.getConsecutivoTransaccion() != null) {
			query.append(", num_cons_tran ");			
			values.append(", ").append(localMovimientos.getConsecutivoTransaccion());
		}
        if (localMovimientos.getCodigoConsultora() != null) {
			query.append(", cod_cons ");			
			values.append(", ").append("'").append(localMovimientos.getCodigoConsultora()).append("'");
		}
        if (localMovimientos.getCodigoError() != null) {
			query.append(", cod_erro ");			
			values.append(", ").append("'").append(localMovimientos.getCodigoError()).append("'");
		}
        if (localMovimientos.getDocumentoCreacionNumero() != null) {
			query.append(", val_docu_crea_nume ");			
			values.append(", ").append(localMovimientos.getDocumentoCreacionNumero());
		}
        if (localMovimientos.getIdentificadorProceso() != null) {
			query.append(", cod_iden_proc ");			
			values.append(", ").append("'").append(localMovimientos.getIdentificadorProceso()).append("'");
		}
        if (localMovimientos.getHorarioNormalAdicional() != null) {
			query.append(", val_hora_norm_adic ");			
			values.append(", ").append("'").append(localMovimientos.getHorarioNormalAdicional()).append("'");
		}
        if (localMovimientos.getImportePago() != null) {
			query.append(", imp_pago ");			
			values.append(", ").append(localMovimientos.getImportePago());
		}
        if (localMovimientos.getNumeroCupon() != null) {
			query.append(", num_cupo ");			
			values.append(", ").append(localMovimientos.getNumeroCupon());
		}
        if (localMovimientos.getNombreOficina() != null) {
			query.append(", val_nomb_ofic ");			
			values.append(", ").append("'").append(localMovimientos.getNombreOficina()).append("'");
		}
        if (localMovimientos.getHoraProceso() != null) {
			query.append(", val_hora_proc ");			
            values.append(", to_date( substr( '" + localMovimientos.getHoraProceso() + "' , 1, 19) , 'YYYY-MM-DD HH24:MI:SS') ");           
		}
        if (localMovimientos.getFechaContabilizacion() != null) {
			query.append(", fec_conta ");			
            values.append(", to_date( '" + new java.sql.Date(localMovimientos.getFechaContabilizacion().getTime())  + "', 'YYYY-MM-DD') ");           
		}
        if (localMovimientos.getEstatusMovimientoPendienteAplicado() != null) {
			query.append(", val_esta_movi_pend ");			
			values.append(", ").append("'").append(localMovimientos.getEstatusMovimientoPendienteAplicado()).append("'");
		}
        if (localMovimientos.getFechaMovimientoAplicacion() != null) {
			query.append(", fec_movi_apli ");			
            values.append(", to_date( '" + new java.sql.Date(localMovimientos.getFechaMovimientoAplicacion().getTime()) + "', 'YYYY-MM-DD') ");           
		}
        if (localMovimientos.getFechaProceso() != null) {
			query.append(", fec_proc ");			
            values.append(", to_date( '" + new java.sql.Date(localMovimientos.getFechaProceso().getTime()) + "', 'YYYY-MM-DD') ");           
		}
        if (localMovimientos.getFechaPago() != null) {
			query.append(", fec_pago ");			
            values.append(", to_date( '" + new java.sql.Date(localMovimientos.getFechaPago().getTime()) + "', 'YYYY-MM-DD') ");           
		}
        if (localMovimientos.getCodigoUsuario() != null) {
			query.append(", cod_usua ");			
			values.append(", ").append("'").append(localMovimientos.getCodigoUsuario()).append("'");
		}
        query.append(") VALUES (");
        query.append(values);
        query.append(")");
        return query;
    }    
        

    /**
     * Inserta los historicos de movimientos bancario de manera masiva.
     * @autor gdmarzi
     */
    private void grabarHistoricosMovimientosBancarios(ArrayList historicosMovimientoBancarios) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientes.grabarHistoricosMovimientosBancarios() - entrada");        
        BelcorpService bs;
        StringBuffer querySimple = new StringBuffer();
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        // -> Armamos una query con multiples inserts
        Iterator iter = historicosMovimientoBancarios.iterator();
        while (iter.hasNext()) {
            querySimple = (StringBuffer)iter.next();
            variasQuerys.append(querySimple);
            variasQuerys.append(";");
        }
        // -> Ejecutamos multiples inserts       
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        // -> limpiamos los hitoricos ya grabados
        historicosMovimientoBancarios.clear();
        UtilidadesLog.info("MONCuentasCorrientes.grabarHistoricosMovimientosBancarios() - salida");        
    }
        

    public void retrocesoMovBancario(DTOMovimientoBancario dto)
        throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesBean.retrocesoMovBancario(DTOMovimientoBancario dto): Entrada");
		
        // Modificado siguiendo incidencia 8097
        MovimientosBancariosLocalHome home = this.getMovimientosBancariosLocalHome();
        HistoricoMovimientosBancLocalHome histMovbancHome = this.getHistoricoMovimientosBancLocalHome();
		MovimientosBancariosLocal local = null;
		HistoricoMovimientosBancLocal localHistMovBanc = null;
 
			
			try{
				local = home.findByPrimaryKey(dto.getOid());
			}catch (FinderException e) {
                UtilidadesLog.debug(
                    "****Metodo retrocesoMovBancario: error -----> finderException");
                this.loguearError(e);
			}
            DTOSalida dtoSalida = new DTOSalida();
            DAOCCC daoCCC = new DAOCCC();

            dtoSalida = daoCCC.obtenerUltimoMovHistBancario((local.getPais()),
                    local.getNumeroLote(), local.getConsecutivoTransaccion());
			UtilidadesLog.debug("movimientosBancarios numerohistoria" );
            RecordSet rs = new RecordSet();
            rs = dtoSalida.getResultado(); //ultimo movimiento bancario
			int numHistorico = 0;
			MONValidacion monValidacion = this.getMONValidacion();
			if(!rs.esVacio()){
				BigDecimal numHist = (BigDecimal) rs.getValueAt(0, "NUM_HIST");
				numHistorico = numHist.intValue();
				numHistorico = numHistorico + 1;
				
				int numMovi = local.getNumeroHistoria().intValue();


                // gPineda - 24/02/2007 - C-CCC-008 - Si numHist == 0, se elimina directamente el registro.
                if ( local.getNumeroHistoria().longValue() == 0) {
                    try {
                        local.remove();
                        UtilidadesLog.info("MONCuentasCorrientesBean.retrocesoMovBancario(DTOMovimientoBancario dto): Salida - Reg eliminado");
                        return;
                    } catch (RemoveException ex) {
                        ctx.setRollbackOnly();
                        this.loguearError(ex);
                        throw new MareException(ex,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                }

				
				if (numMovi != numHistorico) { //si no es el ultimo no se puede eliminar
					UtilidadesLog.debug(
						"EL MOVIMIENTO NO SE PUEDE ELIMINAR PORQUE NO ES EL ÚLTIMO");

					//Añadido error 0047 por incidencia 8397 
					//(EL MOVIMIENTO NO SE PUEDE ELIMINAR PORQUE NO ES EL ÚLTIMO)
					throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(ErroresDeNegocio.CCC_0047));
				}

				//Si es el ultimo toma los datos del registro recuperado del historico y actualiza el 
				//registro recuperado del MovimientoBancario
				if (numMovi == numHistorico) {
				   

					try{
						if (!(monValidacion.validarAccesos(null,
									new Long(((BigDecimal)rs.getValueAt(0,"SOCI_OID_SOCI")).longValue()), null, null, null, rs.getValueAt(0, "SBAC_OID_SBAC") != null ?new Long(((BigDecimal)rs.getValueAt(0, "SBAC_OID_SBAC")).longValue()):null, null, null,
									null, null, null)).booleanValue()) {
							throw new MareException(new Exception(),
								UtilidadesError.armarCodigoError(
									CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
						}
				
					}catch (RemoteException rExc) {
					ctx.setRollbackOnly();
					UtilidadesLog.error(rExc);
					throw new MareException(new Exception(),
						UtilidadesError.armarCodigoError(
							CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
					}
					//obligatorios
					//local.setConsultoraReal(new Long(((BigDecimal) rs.getValueAt(0, "CLIE_OID_CLIE")).longValue()));
					local.setCuentaCorriente(new Long(((BigDecimal) rs.getValueAt(0,
							"CCBA_OID_CUEN_CORR_BANC")).longValue()));
					local.setEmpresa(new Long(((BigDecimal)rs.getValueAt(0,"SOCI_OID_SOCI")).longValue()));
					local.setTipoAbonoCreacion(new Long(((BigDecimal) rs.getValueAt(0,
							"TCAB_OID_TIPO_CARG_ABON_CREA")).longValue()));
					local.setSubprocesoMarcaCreacion(new Long(((BigDecimal) rs.getValueAt(0,
							"SUBP_OID_SUBP_CREA")).longValue()));


					//opcionales		
					local.setCodigoConsultora(rs.getValueAt(0, "COD_CONS") != null?(String)rs.getValueAt(0, "COD_CONS"):null);
					local.setCodigoError(rs.getValueAt(0, "COD_ERRO") != null?(String)rs.getValueAt(0, "COD_ERRO"):null);
					
                    // gPineda - 23/02/2007 - C-CCC-008 - No se actualiza PK
                    //local.setConsecutivoTransaccion( rs.getValueAt(0, "NUM_CONS_TRAN") != null ?new Long(((BigDecimal)rs.getValueAt(0, "NUM_CONS_TRAN")).longValue()): null);
					
                    local.setDigitoChequeoFactura(rs.getValueAt(0, "VAL_DIGI_CHEQ_FACT") != null?new Integer(((BigDecimal)rs.getValueAt(0, "VAL_DIGI_CHEQ_FACT")).intValue()):null);
					local.setDocumentoAplicacionAnyo(rs.getValueAt(0, "VAL_DOCU_APLI_ANIO") != null?(String)rs.getValueAt(0, "VAL_DOCU_APLI_ANIO"):null);
					local.setDocumentoAplicacionMesSerie(rs.getValueAt(0, "VAL_DOCU_APLI_MES_SERI") != null?(String)rs.getValueAt(0, "VAL_DOCU_APLI_MES_SERI"):null);
					local.setDocumentoAplicacionNumero(rs.getValueAt(0, "VAL_DOCU_APLI_NUME") != null?new Integer(((BigDecimal)rs.getValueAt(0, "VAL_DOCU_APLI_NUME")).intValue()):null);
					local.setEstatusMovimientoPendienteAplicado(rs.getValueAt(0, "VAL_ESTA_MOVI_PEND") != null?(String)rs.getValueAt(0, "VAL_ESTA_MOVI_PEND"):null);
					local.setFechaContabilizacion(rs.getValueAt(0, "FEC_CONTA") != null?(Date)rs.getValueAt(0, "FEC_CONTA"):null);
					local.setFechaMovimientoAplicacion(rs.getValueAt(0, "FEC_MOVI_APLI") != null?new Timestamp(((java.sql.Date)rs.getValueAt(0, "FEC_MOVI_APLI")).getTime()):null);
					local.setFechaPago(rs.getValueAt(0, "FEC_PAGO") != null?(java.sql.Date)rs.getValueAt(0, "FEC_PAGO"):null);
					local.setFechaProceso(rs.getValueAt(0, "FEC_PROC") != null?(java.sql.Date)rs.getValueAt(0, "FEC_PROC"):null);
					local.setHoraProceso(rs.getValueAt(0, "VAL_HORA_PROC") != null?new Timestamp(((java.sql.Date)rs.getValueAt(0, "VAL_HORA_PROC")).getTime()):null);
					local.setHorarioNormalAdicional(rs.getValueAt(0, "VAL_HORA_NORM_ADIC") != null?(String)rs.getValueAt(0, "VAL_HORA_NORM_ADIC"):null);
					local.setIdentificadorProceso(rs.getValueAt(0, "COD_IDEN_PROC") != null?(String)rs.getValueAt(0, "COD_IDEN_PROC"):null);
					local.setImportePago(rs.getValueAt(0, "IMP_PAGO") != null?(BigDecimal)rs.getValueAt(0, "IMP_PAGO"):null);
					local.setNombreOficina(rs.getValueAt(0, "VAL_NOMB_OFIC") != null?(String)rs.getValueAt(0, "VAL_NOMB_OFIC"):null);						
					local.setNumeroDocumento(rs.getValueAt(0, "VAL_NUME_DOCU") != null?(String)rs.getValueAt(0, "VAL_NUME_DOCU"):null);
					local.setNumeroFacturaBoleta(rs.getValueAt(0, "NUM_FACT_BOLE") != null?new Long(((BigDecimal)rs.getValueAt(0, "NUM_FACT_BOLE")).longValue()):null);
					
                    // gPineda - 23/02/2007 - C-CCC-008 - No se actualiza PK
                    // local.setNumeroLote(rs.getValueAt(0, "NUM_LOTE") != null ? new Long(((BigDecimal)rs.getValueAt(0, "NUM_LOTE")).longValue()) : null);
					
                    local.setNumeroLoteContabilizacion(rs.getValueAt(0, "VAL_NUM_LOTE_CONT") != null?(String)rs.getValueAt(0, "VAL_NUM_LOTE_CONT"):null);
					local.setObservaciones(rs.getValueAt(0, "VAL_OBSE") != null?(String)rs.getValueAt(0, "VAL_OBSE"):null);
					local.setOficinaRecaudadora(rs.getValueAt(0, "COD_OFIC_RECA") != null?(String)rs.getValueAt(0, "COD_OFIC_RECA"):null);						
					local.setUsuarioProceso(rs.getValueAt(0, "VAL_USUA_PROC") != null?(String)rs.getValueAt(0, "VAL_USUA_PROC"):null);
					local.setNumeroCupon(rs.getValueAt(0, "NUM_CUPO") != null?new Long(((BigDecimal)rs.getValueAt(0, "NUM_CUPO")).longValue()):null);
					local.setTipoAbonoUltimo(rs.getValueAt(0, "TCAB_OID_TIPO_CARG_ABON_ULTI") != null?new Long(((BigDecimal)rs.getValueAt(0, "TCAB_OID_TIPO_CARG_ABON_ULTI")).longValue()):null);
					local.setTipoTransaccion(rs.getValueAt(0, "TTRA_OID_TIPO_TRAN") != null ? new Long(((BigDecimal)rs.getValueAt(0, "TTRA_OID_TIPO_TRAN")).longValue()):null);
					local.setSubprocesoMarcasUltimo(rs.getValueAt(0, "SUBP_OID_SUBP_ULTI") != null?new Long(((BigDecimal)rs.getValueAt(0, "SUBP_OID_SUBP_ULTI")).longValue()):null);
					local.setNumeroLoteExterno(rs.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase()) != null ? new Long(((BigDecimal)rs.getValueAt(0, "NUM_LOTE_EXTE".toUpperCase())).longValue()) : null);

					local.setSaldoPendiente(rs.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) != null ? (BigDecimal)rs.getValueAt(0, "IMP_SALD_PEND".toUpperCase()) : null);
					local.setImporteAplicado(rs.getValueAt(0, "IMP_APLI") != null ? (BigDecimal)rs.getValueAt(0, "IMP_APLI") : null);
					local.setError(rs.getValueAt(0, "TIER_OID_ERRO") != null ? new Long(((BigDecimal)rs.getValueAt(0, "TIER_OID_ERRO")).longValue()) : null);
					local.setSubacceso(rs.getValueAt(0, "SBAC_OID_SBAC") != null ?new Long(((BigDecimal)rs.getValueAt(0, "SBAC_OID_SBAC")).longValue()): null);

					//Elimina el registro del histórico.
					try{
					localHistMovBanc = histMovbancHome.findByPrimaryKey(new Long(((BigDecimal)  rs.getValueAt(
								0, "OID_MOVI_BANC")).longValue()));
					}catch (FinderException fe) {
						UtilidadesLog.debug(
							"****Metodo retrocesoMovBancario: error -----> finderException");
						this.loguearError(fe);
						throw new MareException(fe,
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
					}

					//Validamos el acceso tantes de eliminar
					try{
						if (!(monValidacion.validarAccesos(null,
									localHistMovBanc.getEmpresa(), null, null, null,
									localHistMovBanc.getSubacceso(), null, null, null,
									null, null)).booleanValue()) {
							throw new MareException(new Exception(),
								UtilidadesError.armarCodigoError(
									CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
						}
					}catch (RemoteException rExc) {
						ctx.setRollbackOnly();
						UtilidadesLog.error(rExc);
						throw new MareException(new Exception(),
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
					}
					try{
					   histMovbancHome.remove(localHistMovBanc.getOid());
					}catch (RemoveException re) {
						UtilidadesLog.error(re);
						ctx.setRollbackOnly();
						throw new MareException(re,
							UtilidadesError.armarCodigoError(
								CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
					}
				}//if (numMovi == numHistorico)
			}//if rs.esvacio
				
				 
		//incidencia 8097
		/*home.create(rs.getValueAt(0, "COD_CONS") != null?(String)rs.getValueAt(0, "COD_CONS"):null,//String codigoConsultora
                                 new Long(((BigDecimal)rs.getValueAt(0,"CLIE_OID_CLIE")).longValue()),//Long consultoraReal
                                 rs.getValueAt(0, "COD_ERRO") != null?(String)rs.getValueAt(0, "COD_ERRO"):null,//String codigoError
                                 rs.getValueAt(0, "NUM_CONS_TRAN") != null ? new Long(((BigDecimal)rs.getValueAt(0, "NUM_CONS_TRAN")).longValue()): null,//Long consecutivoTransaccion
                                 rs.getValueAt(0,"VAL_DIGI_CHEQ_FACT")!=null ? new Integer(((BigDecimal)rs.getValueAt(0,"VAL_DIGI_CHEQ_FACT")).intValue()): null,//Integer digitoChequeoFactura
                                 rs.getValueAt(0,"VAL_DOCU_APLI_ANIO")!=null ? (String)rs.getValueAt(0,"VAL_DOCU_APLI_ANIO"):null,//String documentoAplicacionAnyo
								rs.getValueAt(0,"VAL_DOCU_APLI_MES_SERI")!=null? (String)rs.getValueAt(0,"VAL_DOCU_APLI_MES_SERI"):null,//String documentoAplicacionMesSerie				
                                rs.getValueAt(0,"VAL_DOCU_APLI_NUME")!=null? new Integer(((BigDecimal)rs.getValueAt(0,"VAL_DOCU_APLI_NUME")).intValue()):null,//Integer documentoAplicacionNumer
								rs.getValueAt(0," VAL_DOCU_CREA_ANIO")!=null?(String)rs.getValueAt(0," VAL_DOCU_CREA_ANIO"):null,//String documentoCreacionAnyo
								rs.getValueAt(0,"VAL_DOCU_CREA_MES_SERI")!=null?(String)rs.getValueAt(0,"VAL_DOCU_CREA_MES_SERI"):null,//(String) documentoCreacionMesSerie
								rs.getValueAt(0,"VAL_DOCU_CREA_NUME")!=null?new Integer(((BigDecimal)rs.getValueAt(0,"VAL_DOCU_CREA_NUME")).intValue()):null,//Integer documentoCreacionNumero
                                 rs.getValueAt(0,"VAL_ESTA_MOVI_PEND")!=null?(String)rs.getValueAt(0,"VAL_ESTA_MOVI_PEND"):null,//String estatusMovimientoPendienteAplicado
								rs.getValueAt(0,"FEC_CONTA")!=null?(Date)rs.getValueAt(0,"FEC_CONTA"):null,//Date fechaContabilizacion
                                rs.getValueAt(0,"FEC_MOVI_APLI")!=null?new Timestamp(((java.sql.Date)rs.getValueAt(0,"FEC_MOVI_APLI")).getTime()):null,//Timestamp fechaMovimientoAplicacion
                                 rs.getValueAt(0,"FEC_PAGO")!=null?(Date)rs.getValueAt(0,"FEC_PAGO"):null,//Date fechaPago
								 rs.getValueAt(0,"FEC_PROC")!=null?(Date)rs.getValueAt(0,"FEC_PROC"):null,//Date fechaProceso
                                 rs.getValueAt(0,"VAL_HORA_PROC")!=null? new Timestamp(((java.sql.Date)rs.getValueAt(0,"VAL_HORA_PROC")).getTime()):null,//Timestamp horaProceso
                                 rs.getValueAt(0,"VAL_HORA_NORM_ADIC")!=null?(String)rs.getValueAt(0,"VAL_HORA_NORM_ADIC"):null,//String horarioNormalAdicional
								rs.getValueAt(0,"COD_IDEN_PROC")!=null?(String)rs.getValueAt(0,"COD_IDEN_PROC"):null,//String identificadorProceso
                                 rs.getValueAt(0,"IMP_PAGO")!=null?(BigDecimal)rs.getValueAt(0,"IMP_PAGO"):null,//BigDecimal importePago
                                 rs.getValueAt(0,"VAL_NOMB_OFIC")!=null?(String)rs.getValueAt(0,"VAL_NOMB_OFIC"):null,//String nombreOficina
								rs.getValueAt(0,"VAL_NUME_DOCU")!=null?(String)rs.getValueAt(0,"VAL_NUME_DOCU"):null,//String numeroDocumento
                                 rs.getValueAt(0,"NUM_FACT_BOLE")!=null?new Long (((BigDecimal)rs.getValueAt(0,"NUM_FACT_BOLE")).longValue()):null,//Long numeroFacturaBoleta
                                rs.getValueAt(0,"NUM_LOTE")!=null? new Long (((BigDecimal)rs.getValueAt(0,"NUM_LOTE")).longValue()):null ,//Long numeroLote
								rs.getValueAt(0,"VAL_NUM_LOTE_CONT")!=null?(String)rs.getValueAt(0,"VAL_NUM_LOTE_CONT"):null,// String numeroLoteContabilizacion
                                 rs.getValueAt(0,"VAL_OBSE")!=null?(String)rs.getValueAt(0,"VAL_OBSE"):null,//String observaciones
                                 rs.getValueAt(0,"COD_OFIC_RECA")!=null?new Integer(((BigDecimal)rs.getValueAt(0,"COD_OFIC_RECA")).intValue()):null,//Integer oficinaRecaudadora
								rs.getValueAt(0,"VAL_USUA_PROC")!=null?(String)rs.getValueAt(0,"VAL_USUA_PROC"):null,//String usuarioProceso
                                 rs.getValueAt(0,"NUM_CUPO")!=null?new Long(((BigDecimal)rs.getValueAt(0,"NUM_CUPO")).longValue()):null,//Long numeroCupon
								rs.getValueAt(0,"SOCI_OID_SOCI")!=null?new Long(((BigDecimal)rs.getValueAt(0,"SOCI_OID_SOCI")).longValue()):null,//Long empresa
								new Long(((BigDecimal)rs.getValueAt(0,"TCAB_OID_TIPO_CARG_ABON_CREA")).longValue()),//Long tipoAbonoCreacion
                                 rs.getValueAt(0,"TCAB_OID_TIPO_CARG_ABON_ULTI")!=null?new Long(((BigDecimal)rs.getValueAt(0,"TCAB_OID_TIPO_CARG_ABON_ULTI")).longValue()):null,//Long tipoAbonoUltim
                                 rs.getValueAt(0,"TTRA_OID_TIPO_TRAN")!=null?new Long(((BigDecimal)rs.getValueAt(0,"TTRA_OID_TIPO_TRAN")).longValue()):null,//Long tipoTransaccion
								new Long(((BigDecimal)rs.getValueAt(0,"SUBP_OID_SUBP_CREA")).longValue()),//Long subprocesoMarcaCreacion
                                 rs.getValueAt(0,"SUBP_OID_SUBP_ULTI")!=null?new Long(((BigDecimal)rs.getValueAt(0,"SUBP_OID_SUBP_ULTI")).longValue()):null,//Long subprocesoMarcasUltimo
                                 new Long(((BigDecimal)rs.getValueAt(0,"CCBA_OID_CUEN_CORR_BANC")).longValue()),//Long cuentaCorriente
								rs.getValueAt(0,"NUM_LOTE_EXTE")!=null?new Long(((BigDecimal)rs.getValueAt(0,"NUM_LOTE_EXTE")).longValue()):null,//Long numeroLoteExterno
                                null,//local.getNMovimientoCaja(), //rs.getValueAt(0,"NUM_MOVI_CAJA")!=null? new Long(((BigDecimal)rs.getValueAt(0,"NUM_MOVI_CAJA")).longValue()):null,//Long nMovimientoCaja
                                 rs.getValueAt(0,"IMP_SALD_PEND")!=null?(BigDecimal)rs.getValueAt(0,"IMP_SALD_PEND"):null,//BigDecimal saldoPendiente
																
								rs.getValueAt(0,"COD_USUA")!=null?(String)rs.getValueAt(0,"COD_USUA"):null,//"codigousuario" , 
								rs.getValueAt(0," NUM_HIST")!=null?new Integer(((BigDecimal)rs.getValueAt(0," NUM_HIST")).intValue()):null, //Integer numeroHistoria
								rs.getValueAt(0,"IMP_APLI")!=null?(BigDecimal)rs.getValueAt(0,"IMP_APLI"):null,// BigDecimal importeAplicado
                                rs.getValueAt(0,"TIER_OID_ERRO")!=null?new Long(((BigDecimal)rs.getValueAt(0,"TIER_OID_ERRO")).longValue()):null,
								new Long (1),//local.getPais(),//new Long(((BigDecimal)rs.getValueAt(0,"PAIS_OID_PAIS")).longValue()),
								rs.getValueAt(0,"SBAC_OID_SBAC")!=null?new Long(((BigDecimal)rs.getValueAt(0,"SBAC_OID_SBAC")).longValue()):null);*/

        UtilidadesLog.info("MONCuentasCorrientesBean.retrocesoMovBancario(DTOMovimientoBancario dto): Salida");
    }

    public Boolean estanBloqueadosMovCC(DTOOIDs dto) throws MareException {
        /*Recorremos los oids y comprobamos si están bloqueados por otros
        usuarios o si el tiempo //de bloqueo máximo ha expirado. Si alguno
        de ellos lo está devolverá false.*/
        UtilidadesLog.info("MONCuentasCorrientesBean.estanBloqueadosMovCC(DTOOIDs dto): Entrada");

        Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
            /*BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        } /*catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        String usuario = ctx.getCallerPrincipal().getName();

        Long[] oids = dto.getOids();
        int numOIDs = oids.length;
        BloqueoMovCCLocalHome home = this.getBloqueoMovCCLocalHome();

        for (int i = 0; i < numOIDs; i++) {
            Long oidMov = new Long(oids[i].toString());

            try {
                BloqueoMovCCLocal local = home.findByUk(oidMov);

                if (!(local.getUsuario().equals(usuario)) ||
                        (local.getUsuario().equals(usuario) &&
                        ((System.currentTimeMillis() -
                        local.getTiempo().longValue()) > timeOutBloqueo.longValue()))) {
                        UtilidadesLog.info("MONCuentasCorrientesBean.estanBloqueadosMovCC(DTOOIDs dto): Salida");

                    return Boolean.TRUE;
                }
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug(
                    "****Metodo estanBloqueadosMovCC: error -----> finderException");
                this.loguearError(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.estanBloqueadosMovCC(DTOOIDs dto): Salida");

        return Boolean.FALSE;
    }

    public Boolean estanBloqueadosMovBanc(DTOOIDs dto)
        throws MareException {
        /*Recorremos los oids y comprobamos si están bloqueados por otros
                usuarios o si el tiempo //de bloqueo máximo ha expirado. Si alguno
                de ellos lo está devolverá false.*/
        UtilidadesLog.info("MONCuentasCorrientesBean.estanBloqueadosMovBanc(DTOOIDs dto): Entrada");

        Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
           /* BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }/* catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        String usuario = ctx.getCallerPrincipal().getName();

        Long[] oids = dto.getOids();
        int numOIDs = oids.length;

        BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();

        for (int i = 0; i < numOIDs; i++) {
            Long oidMov = new Long(oids[i].toString());

            try {
                BloqueoMovBancLocal local = home.findByUk(oidMov);

                if (!(local.getUsuario().equals(usuario)) ||
                        (local.getUsuario().equals(usuario) &&
                        ((System.currentTimeMillis() -
                        local.getTiempo().longValue()) > timeOutBloqueo.longValue()))) {
                    return Boolean.TRUE;
                }
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug(
                    "****Metodo estanBloqueadosMovBanc: error -----> finderException");
                this.loguearError(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.estanBloqueadosMovBanc(DTOOIDs dto): Salida");

        return Boolean.FALSE;
    }

    public Boolean estaBloqueadoMovCC(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovCC(DTOOID dto): Entrada");

        Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
           /* BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }/* catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        String usuario = ctx.getCallerPrincipal().getName();
        BloqueoMovCCLocalHome home = this.getBloqueoMovCCLocalHome();

        try {
            BloqueoMovCCLocal local = home.findByUk(dto.getOid());

            if (!(local.getUsuario().equals(usuario)) ||
                    (local.getUsuario().equals(usuario) &&
                    ((System.currentTimeMillis() -
                    local.getTiempo().longValue()) > timeOutBloqueo.longValue()))) {
                    UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovCC(DTOOID dto): Salida");

                return Boolean.TRUE;
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug(
                "****Metodo estaBloqueadoMovCC: error -----> finderException");
            this.loguearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovCC(DTOOID dto): Salida");

        return Boolean.FALSE;
    }

    public Boolean estaBloqueadoMovBanc(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovBanc(DTOOID dto): Entrada");

        Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
            /*BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        } /*catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        String usuario = ctx.getCallerPrincipal().getName();
        BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();

        try {
            BloqueoMovBancLocal local = home.findByUk(dto.getOid());

            if (!(local.getUsuario().equals(usuario)) ||
                    (local.getUsuario().equals(usuario) &&
                    ((System.currentTimeMillis() -
                    local.getTiempo().longValue()) > timeOutBloqueo.longValue()))) {
                UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovCC(DTOOID dto): Salida");

                return Boolean.TRUE;
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug(
                "****Metodo estaBloqueadoMovBanc: error -----> finderException");
            this.loguearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.estaBloqueadoMovBanc(DTOOID dto): Salida");

        return Boolean.FALSE;
    }
/*
    public DTOSalida bloquearMovCC(DTOSalida dto) throws MareException {
		//METODO ELIMIDADO SEGUN DISEÑO N27-2
    }
*/
    public Boolean bloquearMovCC(DTOOID dto) throws MareException, RemoteException {
        /**
        Recibe un DTOOID con un OID de lo MovimientosBancario a bloquear.
        Si estuviera aún bloqueado por otro usuario devolvemos false.
        Si se bloquea para el usuario actual devolvemos true.
		
        Construimos un array de OIDs con una sola fila 
        Long[] oid=new Long[1]; 
        oid[0]=dtoOID.oid; 
        DTOOIDs oids=new DTOOIDs(); 
        oids=oid; 
		*/
		
		UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovCC(DTOOID dto): Entrada");
        Long[] oid = new Long[1];
        oid[0] = dto.getOid();

        DTOOIDs oids = new DTOOIDs();
        oids.setOids(oid);
		
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovCC(DTOOID dto): Salida");
        return this.bloquearMovCC(oids);
    }

	
/*    public DTOSalida bloquearMovBanc(DTOSalida dto) throws MareException {
		//Metodo eliminado segun Diseño N27-2
    }
*/

    public Boolean bloquearMovBanc(DTOOIDs dtos) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOIDs dtos): Entrada");

        BloqueoMovBancLocalHome bloqueoMovBancHome = null;
        BloqueoMovBancLocal bloqueoMovBancLocal = null;
		// Posteriormente actualizaremos timeOutBloqueo. No es necesario hacer esta
		// iniciación
        //Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 
		Long timeOutBloqueo = null;
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
            /*BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while (((str = br.readLine()) != null)&&(timeOutBloqueo==null)) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
				// No se usa para nada
				// String[] dat = new String[st.countTokens()];
                int x = 0;

                while ((st.hasMoreTokens())&&(timeOutBloqueo==null)) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }/* catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        String usuario = ctx.getCallerPrincipal().getName();
        int longitud = dtos.getOids().length;

        bloqueoMovBancHome = this.getBloqueoMovBancLocalHome();

		boolean encontrado;
		
        //Recorremos el DTOOIDs 
        //Long[] array = new Long[dtos.getOids().length];
		Long[] array = dtos.getOids();
        for (int i = 0; i < longitud; i++) {
			encontrado = true;
            try {
                bloqueoMovBancLocal = bloqueoMovBancHome.findByUk(new Long(
                            array[i].longValue()));
            } catch (NoResultException e) {
                //No encontrado, lo creamos 
                try {
					encontrado = false;
					
                    bloqueoMovBancLocal = bloqueoMovBancHome.create(usuario,
	                    BigDecimal.valueOf(System.currentTimeMillis()),
						new Long(array[i].longValue()));
                } catch (PersistenceException fe) {
                    UtilidadesLog.error(fe);
                    ctx.setRollbackOnly();
                    throw new MareException(fe,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }

			if(encontrado==true) {
	            //De otro usuario pero con el tiempo excedido: Tomamos el control 
/*		        if (!(bloqueoMovBancLocal.getUsuario().equals(usuario)) &&
                    ((System.currentTimeMillis() -
                    bloqueoMovBancLocal.getTiempo().longValue()) > timeOutBloqueo.longValue())) {*/
				if (!bloqueoMovBancLocal.getUsuario().equals(usuario)){
					if ((System.currentTimeMillis() - bloqueoMovBancLocal.getTiempo().longValue()) > timeOutBloqueo.longValue()){
						bloqueoMovBancLocal.setUsuario(usuario);
						bloqueoMovBancLocal.setTiempo(BigDecimal.valueOf(System.currentTimeMillis()));
                                                bloqueoMovBancHome.merge(bloqueoMovBancLocal);
						UtilidadesLog.info("****Metodo bloquearMovBanc(DTOOIDs dtos): Salida");
						// Hay que esperar a recorrer el DTOOIDs entero
						// return Boolean.TRUE;
					} else {
						return Boolean.FALSE;
					}
				}
			}
		}
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOIDs dtos): Salida");

        return Boolean.TRUE;
    }

    public Boolean bloquearMovBanc(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOID dto): Entrada");

		// Cambiado por hsanchez para ajustarse al diseño
		// Elementos añadidos
		Long[] oid = new Long[1];

		oid[0] = dto.getOid();

		DTOOIDs dtoOids = new DTOOIDs();
		dtoOids.setOids(oid);
		Boolean resultado = this.bloquearMovBanc(dtoOids);

		UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOID dto): Salida");

		return resultado;
		
		// Elementos eliminados
		/*
        Long timeOutBloqueo = new Long(0); //Máximo segundos bloqueo (Constante del fichero properties). 

        try {
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
            BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        } catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }

        String usuario = ctx.getCallerPrincipal().getName();

        BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();

        try {
            BloqueoMovBancLocal local = home.findByUk(dto.getOid());

            //De otro usuario pero con el tiempo excedido 
            if (!(local.getUsuario().equals(usuario)) &&
                    ((System.currentTimeMillis() -
                    local.getTiempo().longValue()) > timeOutBloqueo.longValue())) {
                local.setUsuario(usuario);
                local.setTiempo(new Long(System.currentTimeMillis()));
                UtilidadesLog.debug(
                    "****Metodo bloquearMovBanc(DTOOID dto): Salida");

                return Boolean.TRUE;
            }

            UtilidadesLog.debug("****Metodo bloquearMovBanc(DTOOID dto): Salida");

            return Boolean.FALSE;
        } catch (FinderException e) {
            //No encontrado
            try {
                home.create(usuario, dto.getOid(),
                    new Long(System.currentTimeMillis()));
                UtilidadesLog.debug(
                    "****Metodo bloquearMovBanc(DTOOID dto): Salida");

                return Boolean.TRUE;
            } catch (CreateException ce) {
                this.loguearError("*** Error en bloquearMovBanc", e);

                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }
        }
		*/
    }
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param indActualizaCuotaSN
     * @param cuentaContable
     * @param oidSubproceso
     * @param numeroIdentificacion
     * @param marcaSalida
     * @param marcaEntrada
     * @param indEmisionVto
     * @param parcialACancelar
     * @param dto
     * 05/04/2006 - pperanzola - [1] se modifica según incidencia DBLG300000498
     * 25/04/2006 - pperanzola - [2] se modifica según incidencia DBLG300000498
     * 08/05/2006 - pperanzola - [3] se modifica según incidencia DBLG300000498
     * 15/05/2006 - pperanzola - [4] nuevamente se modifica según incidencia DBLG300000498 tras comunicación telefónica con jainiver (Belcorp)
     * 14/07/2006 - pperanzola - [5] nuevamente se modifica según incidencia DBLG500000718 
     * 
     */
    private void actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, double parcialACancelar,
                    String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion,
                    Long oidSubproceso, Long cuentaContable, Long indActualizaCuotaSN, Long tmpTipoAbonoCuentaContable) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Entrada");
        //Actualizar La Cuota de Cancelación
        dto.setImporteMovimiento(new BigDecimal(parcialACancelar * -1));//[2] parcialACancelar.doubleValue() * -1));

        if (indActualizaCuotaSN != null){
            if ( indActualizaCuotaSN.equals(Long.valueOf("0"))){
                dto.setMarcaSituacion(marcaSalida);
				dto.setImportePago(new BigDecimal(0.0)); 
            } else {
                dto.setImportePago(dto.getImporteMovimiento());//[3]
                ///*[4]
                dto.setImportePagado(new Double((dto.getImportePagado().doubleValue()) +
                    ((parcialACancelar) * -1)));
                dto.setImportePendiente(new Double(dto.getImporte().doubleValue() -
                    dto.getImportePagado().doubleValue()));
                ///*[4]
                BigDecimal importePagadoB = new BigDecimal (dto.getImportePagado().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                BigDecimal importeB = new BigDecimal (dto.getImporte().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                UtilidadesLog.debug("COMPARACION IMPORTES: "+importePagadoB.doubleValue()+" - "+importeB.doubleValue());
                
                if (importePagadoB.doubleValue()==importeB.doubleValue()) {
                    dto.setMarcaSituacion(marcaSalida);
                }

            }
        }
        
        //*/[1]
		Timestamp actual = new Timestamp(System.currentTimeMillis());
		Date actualDate = new Date(actual.getTime());
		String anyo = null;
		String mes = null;
		try{
			anyo = UtilidadesFecha.convertirAString(actualDate,"yy");		
			mes = UtilidadesFecha.convertirAString(actualDate,"MM");
		}catch(ParseException e){
			throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_FORMATO_FECHA));
		}

        dto.setUltimoDocumentoMesSerie(mes);
        dto.setUltimoDocumentoAnyo(anyo);
        dto.setUltimoDocumentoNumero(numeroIdentificacion);
        dto.setSubprocesoUltimo(oidSubproceso);
        dto.setTipoAbonoUltimo(tmpTipoAbonoCuentaContable);
        dto.setTipoAbonoSubprocesoUltimo(marcaEntrada);
        
        dto.setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
        dto.setUltimoNumeroHistoria(new Integer(dto.getUltimoNumeroHistoria().intValue() + 1));
        //[5] dto.setCuentaCuota(cuentaContable);
        dto.setUsuario(ctx.getCallerPrincipal().getName());
        this.actualizarCuenta(dto);
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Salida");
    }

    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param indActualizaCuotaSN
     * @param cuentaContable
     * @param oidSubproceso
     * @param numeroIdentificacion
     * @param marcaSalida
     * @param marcaEntrada
     * @param indEmisionVto
     * @param parcialACancelar
     * @param dtoCancelar
     *   05/04/2006 - pperanzola - [1] se modifica según incidencia DBLG300000498
     *   25/04/2006 - pperanzola - [2] se modifica según incidencia DBLG300000498
     *   08/05/2006 - pperanzola - [3] se modifica según incidencia DBLG300000498
     *   15/05/2006 - pperanzola - [4] nuevamente se modifica según incidencia DBLG300000498 tras comunicación telefónica con jainiver (Belcorp)
     *   14/07/2006 - pperanzola - [5] nuevamente se modifica según incidencia DBLG500000718
     */
    private void actualizarCuotasACancelar(DTOMovimientoCuentaCompleto dtoCancelar, double parcialACancelar,
                            String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion,
                            Long oidSubproceso, Long cuentaContable, Long indActualizaCuotaSN, Long tmpTipoAbonoCuentaContable) throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuotasACancelar(DTOMovimientoCuentaCompleto dtoCancelar, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Entrada");
        //Actualizar cuotas a cancelar 
        dtoCancelar.setImporteMovimiento(new BigDecimal(parcialACancelar));

        if (indActualizaCuotaSN != null){
            if ( indActualizaCuotaSN.equals(Long.valueOf("0"))){
                dtoCancelar.setMarcaSituacion(marcaSalida);
                dtoCancelar.setImportePago(new BigDecimal(0.0)); 
            }else {
                
                //[3]dtoCancelar.setImportePago(new BigDecimal(dtoCancelar.getImporte().doubleValue()));
                dtoCancelar.setImportePago(dtoCancelar.getImporteMovimiento()); //[3]
                ///*[4]
                dtoCancelar.setImportePagado(new Double(dtoCancelar.getImportePagado().doubleValue() +
                    parcialACancelar));
                dtoCancelar.setImportePendiente(new Double(dtoCancelar.getImportePendiente().doubleValue() -
                    parcialACancelar));
                //*/[4]
                BigDecimal importePagadoB = new BigDecimal (dtoCancelar.getImportePagado().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                BigDecimal importeB = new BigDecimal (dtoCancelar.getImporte().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
                UtilidadesLog.debug("COMPARACION IMPORTES: "+importePagadoB.doubleValue()+" - "+importeB.doubleValue());
                if (importePagadoB.doubleValue()==importeB.doubleValue()) {
                    dtoCancelar.setMarcaSituacion(marcaSalida);
                }
            }
        }
         //*/[1]
		Timestamp actual = new Timestamp(System.currentTimeMillis());
		Date actualDate = new Date(actual.getTime());
		String anyo = null;
		String mes = null;
		try{
			anyo = UtilidadesFecha.convertirAString(actualDate,"yy");		
			mes = UtilidadesFecha.convertirAString(actualDate,"MM");
		}catch(ParseException e){
			throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_FORMATO_FECHA));
		}
		
        dtoCancelar.setUltimoDocumentoNumero(numeroIdentificacion);
        dtoCancelar.setSubprocesoUltimo(oidSubproceso);
        dtoCancelar.setTipoAbonoSubprocesoUltimo(marcaEntrada);
        dtoCancelar.setTipoAbonoUltimo(tmpTipoAbonoCuentaContable);
        dtoCancelar.setFechaUltimoMovimiento(actual);
        dtoCancelar.setUltimoNumeroHistoria(new Integer(dtoCancelar.getUltimoNumeroHistoria().intValue() + 1));
        //[5]dtoCancelar.setCuentaCuota(cuentaContable);
        dtoCancelar.setUsuario(ctx.getCallerPrincipal().getName());

        this.actualizarCuenta(dtoCancelar);
		UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuotasACancelar(DTOMovimientoCuentaCompleto dtoCancelar, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Salida");
    }

    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param usuario
     * @param cuotasNegativas     
     * @param pais
     * 
     *      01/06/06    Se modifica porque daba null pointer exception
     */
    private void insertarCuotaNegativa(Long pais, DTOMovimientoCuentaCompleto[] cuotasNegativas, String usuario)
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.insertarCuotaNegativa(Long pais, Integer ultiOrdenCuota, DTOMovimientoCuentaCompleto[] cuotasNegativas): Entrada");

        //Llamamos a DAOCCC.obtenerMarcasTipoAbonoSalida para obtener un registro con el 
        //tipo de abono y la marca de situación relacionada de salida para : 
        //codigoProceso="CCC001" 
        //codigoSubproceso="2" 
        //y pais actual. 
        String codigoProceso = new String("CCC001");
        Integer codigoSubproceso = new Integer(2);
        RecordSet rs = new RecordSet();
        DAOCCC daoCCC = new DAOCCC();
        rs = daoCCC.obtenerMarcasTipoAbonoSalida(codigoProceso,
                codigoSubproceso, pais);

        //Lo guardamos en las variables: tipoAbono y marcaSalida. 
        BigDecimal marcaSalidaBig;
        marcaSalidaBig = (BigDecimal) rs.getValueAt(0, "OID_MARC_SITU");

        Long marcaSalida = new Long(marcaSalidaBig.longValue());
        BigDecimal tipoAbonoBig;
        tipoAbonoBig = (BigDecimal) rs.getValueAt(0, "TASP_OID_TIPO_ABON_SUBP");

        Long tipoAbono = new Long(tipoAbonoBig.longValue());
        
        
        ProcesosLocalHome homeP = this.getProcesosLocalHome();
        ProcesosLocal localP = null;
        Long oidTempProc = null;
        try {
            localP = homeP.findByUk(pais, "CCC001");
            oidTempProc = localP.getOid();
        } 
        catch (NoResultException fe) {
            UtilidadesLog.debug("****Metodo generarCuentaCorriente: error -----> finderException ProcesosHome.findByUk(pais, proceso): CCC001");
            this.loguearError(fe);
        }

        //Recibimos cuotasNegativas ordenadas por "empresa". Por ello 
        //generamos una única CabeceraCargosAbonosDirectos para cada empresa. Generaremos 
        //también un registro para cada fila de la lista en DetalleCargosAbonosDirectos 
        //y MovimientosCuentasCorrientes. 
        Long empresa = null;
        Long numeroLinea = new Long(0);
        int longitud = cuotasNegativas.length;

        for (int i = 0; i < longitud; i++) {
            this.validaAcceso(pais, null, cuotasNegativas[i].getMarca(),
                cuotasNegativas[i].getOidCanal(),
                cuotasNegativas[i].getOidAcceso(),
                cuotasNegativas[i].getSubacceso(),
                cuotasNegativas[i].getOidSugerenciaVenta(),
                cuotasNegativas[i].getOidRegion(), null,
                cuotasNegativas[i].getOidSeccion(),
                cuotasNegativas[i].getTerritorioAdministrativo(),
                usuario);

            //BELC300008111
            DTOMovimientoCuentaCompleto cuota = cuotasNegativas[i];
            UtilidadesLog.debug("(SCS) viendo cuota: " + cuota);
            DTOMovimientoCuentaCompleto cuotaActualizada = new DTOMovimientoCuentaCompleto();

            //Creamos una estructura con los datos actualizados de 
            //MovimientosCuentasCorrientes a partir del registro actual     
            //cuotaActualizada.setNumeroOrdenCuota(new Integer(ultiOrdenCuota.intValue() + 1)); //incrementar 
            cuotaActualizada.setNumeroOrdenCuota(cuota.getNumeroOrdenCuota());
            
            //@ssaavedra 26/07/06 se modifica segun acuerdo con ricardo kanna, bajo orden de mantilla
            //cuotaActualizada.setImporte(new Double(cuota.getImportePago().doubleValue() * (-1)));
            //cuotaActualizada.setImporte(new Double(cuota.getImporteMovimiento().doubleValue() * (-1)));
            cuotaActualizada.setImporte(new Double(cuota.getImporte().doubleValue() * (-1)));

            //Saldamos el movimiento 
            cuotaActualizada.setImporteMovimiento(new BigDecimal(
                    cuotaActualizada.getImporte().doubleValue()));
            cuotaActualizada.setImportePagado(new Double(0));

            //BELC300008136
            cuotaActualizada.setImportePago(new BigDecimal(0));
            cuotaActualizada.setImportePendiente(cuotaActualizada.getImporte());
            
            //@ssaavedra 26/07/06 se modifica segun acuerdo con ricardo kanna, bajo orden de mantilla
            //cuotaActualizada.setImporteDivisa(new Double(
            //        cuota.getImportePagadoDivisa().doubleValue() * (-1)));
            //@ ssaavedr 07/08/06 se modifica segun mail de AG
            //cuotaActualizada.setImporteDivisa(new Double(
            //        cuota.getImporteMovimientoDivisa().doubleValue() * (-1)));
            cuotaActualizada.setImporteDivisa(new Double(
                    cuota.getImporteDivisa().doubleValue() * (-1)));
            
            cuotaActualizada.setImportePagadoDivisa(new Double(0));

            //BELC300008136
            cuotaActualizada.setImportePagoDivisa(new BigDecimal(0));
            cuotaActualizada.setImporteMovimientoDivisa(new BigDecimal(
                    cuotaActualizada.getImporteDivisa().doubleValue()));
            cuotaActualizada.setFechaUltimoMovimiento(new Timestamp(
                    System.currentTimeMillis())); //fecha del sistema 

            //BELC300008050 
            cuotaActualizada.setSubprocesoCreacion(daoCCC.obtenerOIDSubproceso(
                    pais, codigoProceso, codigoSubproceso));
            cuotaActualizada.setTipoAbonoCreacion(tipoAbono); //(variable obtenida arriba * ) 

            //BELC300008050
            cuotaActualizada.setSubprocesoUltimo(cuotaActualizada.getSubprocesoCreacion());
            cuotaActualizada.setTipoAbonoUltimo(tipoAbono);
            cuotaActualizada.setMarcaSituacion(marcaSalida); //(variable obtenida arriba *) 
            cuotaActualizada.setUltimoNumeroHistoria(new Integer(0));

            cuotaActualizada.setUsuario(ctx.getCallerPrincipal().getName());

            //MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
            MovimientosCuentasCorrientesLocalHome homeMCC1 = this.getMovimientosCuentasCorrientesLocalHome();
            //MovimientosCuentasCorrientesLocal movimientosLocal = null;
            CabeceraCargosAbonosDirectosLocalHome home = this.getCabeceraCargosAbonosDirectosLocalHome();
            CabeceraCargosAbonosDirectosLocal local = null;
            Timestamp actual = new Timestamp(System.currentTimeMillis());
            StringTokenizer tk = new StringTokenizer(actual.toString(), "-");
            String anio = tk.nextToken();
            String anioDos = anio.substring(2, 4);
            String mes = tk.nextToken();
            if (empresa == null || empresa.equals(cuota.getEmpresa())) {//[1]if (empresa != cuota.getEmpresa()) {
                empresa = cuota.getEmpresa();
                numeroLinea = new Long(0);

                //Generaremos un registro en CabeceraCargosAbonosDirectos para las cuotas agrupadas por empresa. 
                //Obtenemos la interfaz Home de CabeceraCargosAbonosDirectos e invocamos al método create() pasándole los parámetros: 			
                //Long pais = pais;//No se necesita
                //DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos(ctx.getCallerPrincipal()
                //                                                         .getName());

                //BELC300008109

			/*Modificado por incidencia BELC300010254	
                Integer numeroIdentificacion = daoCargosAbonos.obtieneSiguienteNumero(pais);
			*/
				DTOBelcorp dtoBelcorp = new DTOBelcorp();
                dtoBelcorp.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
				dtoBelcorp.setOidPais(pais);
				//Aun no esta este metodo>>>>>>>>>>
                MONCuentasCorrientesLocal moncccLocal = getMONCuentasCorrientesLocal();
                Integer numeroIdentificacion = moncccLocal.obtenerSecuenciaPais(dtoBelcorp);
				//Integer numeroIdentificacion = daoCCC.obtenerSecuenciaPais(dtoBelcorp);
                
                //Long empresaSociedad = empresa;
                Date documento = new Date(System.currentTimeMillis());
                //Long tipoAbonoSubproceso = tipoAbono;
                String codigoUsuario = ctx.getCallerPrincipal().getName();

                //El resto de los datos los obtenemos del 
                //MovimientoCuentaCorriente en el que estamos posicionados 
                /*try {
                    //BELC300008142										
                    movimientosLocal = homeMCC.findByPrimaryKey(cuota.getOid());
                } catch (FinderException fe) {
					ctx.setRollbackOnly();
                    this.loguearError(fe);
                    throw new MareException(fe,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
                movimientosLocal.setConsolidado(null);*/
                
				//Long proceso = daoCCC.obtieneProceso(codigoProceso,pais);
               /* try {
                    //Incidencia BELC300008037 BELC300008152 falta modificar la base de datos										
                    local = home.create(numeroIdentificacion, anioDos, mes,
                            documento, pais, empresa, codigoUsuario,
                            new Date(movimientosLocal.getFechaValor().getTime()),proceso);//ver incidencia quique

                    //Puesto long(1) hasta que cambien la base de datos.
                } catch (CreateException e) {
					ctx.setRollbackOnly();
                    this.loguearError("*** Error en el método  insertarCuotasNegativas al tomar CabeceraCargosAbonosDirectosLocal ",
                        e);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }*/
                
                ///*[1]
                try {
                
                    local = home.create(numeroIdentificacion, //Integer
                                            //anio, //String
                                            anioDos, //String
                                            mes, //String
                                            documento, //Date
                                            pais, //Long
                                            empresa, //Long
                                            codigoUsuario, //String
                                            documento, //Date
                                            oidTempProc); //Long
                } catch (PersistenceException e) {
                        this.loguearError(e);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(codigoError));
                }     
                UtilidadesLog.info("*** Se realiza el create en CabeceraCargosAbonosDirectos ***, oid: " + local.getOid());
                //*/[1]
            }

            //Llamamos al create del entity MovimientosCuentaCorriente para cada posición 
            //del RecordSet (cuotasNegativas) utilizamos las actualizaciones de cuota_actualizada, el
            //resto de datos los totmamos de cuota.
            //Actualizando estos campos: 
            //VAL_DOCU_ANIO = CabeceraCargosAbonos.NUM_CABE 
            //VAL_DOCU_MES_SERI = CabeceraCargosAbonos.NUM_CABE 
            //VAL_DOCU_NUME = CabeceraCargosAbonos.NUM_CABE 
            //VAL_ULTI_DOCU_ANIO=VAL_EJER_CUOT 
            //VAL_ULTI_DOCU_NUME=NUM_IDEN_CUOT 
            //BELC300008246
            MovimientosCuentasCorrientesLocal movimientosLocalCreate;
            UtilidadesLog.debug("periodoDesde" +cuota.getPeriodoDesde());
            UtilidadesLog.debug("Subacceso" +cuota.getSubacceso());
            UtilidadesLog.debug("EjercicioCuota" +cuota.getEjercicioCuota());
            UtilidadesLog.debug("NumeroIdentificadorCuota" +cuota.getNumeroIdentificadorCuota());
            UtilidadesLog.debug("NumeroOrdenCuota" +cuota.getNumeroOrdenCuota());
            try {
                movimientosLocalCreate = homeMCC1.create(cuota.getEmpresa(), //Long empresa
                        cuotaActualizada.getMarcaSituacion(), //Long marcaSituacion
                        cuota.getDivisa(), //	Long divisa
                        cuota.getPeriodoDesde(), //Long periodoDesde
                        cuotaActualizada.getTipoAbonoUltimo(), //Long tipoAbonoUltimo
                        cuotaActualizada.getTipoAbonoCreacion(), //Long tipoAbonoCreacion
                        cuota.getSubacceso(), //Long subacceso
                        cuotaActualizada.getSubprocesoUltimo(), //Long subprocesoUltimo
                        cuotaActualizada.getSubprocesoCreacion(), //Long subprocesoDeCreacion
                        cuota.getCuentaOrigen(), //Long cuentaOrigen
                        cuota.getCuentaCuota(), //Long cuentaCuota
                        cuota.getOidCliente(), //Long cliente
                        anioDos,
                        mes,
                        //new String(local.getNumero().toString()), //String documentoAnyo
                        //new String(local.getNumero().toString()), //String documentoMesSerie
                        local.getNumero(), //Integer documentoNumero
                        cuota.getEjercicioCuota(), //String ejercicioCuota
                        (cuota.getFechaContabilizacion()!=null?new Date(cuota.getFechaContabilizacion().getTime()):null), //Date fechaContabilizacion
                        (cuota.getFechaDocumento()!=null? new Timestamp(cuota.getFechaDocumento().getTime()):null), //Timestamp fechaDocumento //pasar Timestamp
                        cuotaActualizada.getFechaUltimoMovimiento(), //Timestamp fechaUltimoMovimiento
                        (cuota.getFechaValor()!=null?new Timestamp(cuota.getFechaValor().getTime()):null), //Timestamp fechaValor //pasar Timestamp fechaValor,
                        (cuota.getFechaVencimiento()!=null?new Date(cuota.getFechaVencimiento().getTime()):null), //Date fechaVencimiento,
                        cuotaActualizada.getImporte(), //Double importe
                        cuotaActualizada.getImporteDivisa(), //Double importeDivisa,
                        cuotaActualizada.getImportePagado(), //Double importePagado
                        cuotaActualizada.getImportePagadoDivisa(), //Double impPagadoDivisa,
                        cuotaActualizada.getImportePendiente(), //Double importePendiente 
                        cuota.getIndicaDescuentoRecargo(), //BELC300008224    
                        cuota.getNumeroIdentificadorCuota(), //Integer numeroIdentificadorCuota,
                        cuota.getNumeroLoteContabilizacion(), //String numLoteContab
                        cuotaActualizada.getNumeroOrdenCuota(), //Integer numeroOrdenCuota
                        cuota.getObservaciones(), //String observaciones,
                        cuota.getReferenciaNumeroDocumentoExterno(), //String referenciaNumeroDocumentoExterno,
                        cuota.getEjercicioCuota(), //String ultimoDocumentoAnyo
                        cuota.getUltimoDocumentoMesSerie(), //String ultimoDocumentoMesSerie,
                        //@ssaavedr 08/08/2006 segun mail de kanna cuota.getNumeroIdentificadorCuota(), //Integer ultimoDocumentoNumero
                        local.getNumero(), //Integer ultimoDocumentoNumero
                        cuotaActualizada.getUltimoNumeroHistoria(), //Integer ultimoNumeroHistoria,
                        cuota.getMedioPago(), //Long medioPago,
                        cuota.getTerritorioAdministrativo(), //Long TerritorioAdministrativo,
                        cuota.getTipoCliente(), //Long tipoCliente,
                        cuota.getMarca(), //Long marca,
                        cuota.getTipoCambio(), //BigDecimal tipoCambio, 
                        cuotaActualizada.getUsuario(), //String codigoUsuario,
                        cuota.getOidSubtipoCliente(), //Long subtipoCliente,
                        cuota.getOidSugerenciaVenta(), //Long sugerencia,
                        cuota.getOidSeccion(), //Long seccion,
                        cuota.getNumeroLoteFactu(), //Integer numeroLoteFacturacion,
                        //cuota.getDcAplicado(), //String dcAplicado,
                        cuotaActualizada.getImportePago(), //BigDecimal importePago,
                        cuotaActualizada.getImportePagoDivisa(), //BigDecimal importePagoDivisa,
                        cuotaActualizada.getImporteMovimientoDivisa(), //BigDecimal importePagoDivisa,
                        cuota.getTipoPeriodoDesde(), //Long tipoPeriodo,
                        cuota.getOidTipoDocumentoLegal(), //Long tipoDocumentoLegal,
                        cuota.getOidTipoSolicitud(), //Long tipoSolicitud,
                        cuota.getOidRegion(), //Long region,
                        null, //Long consolidado,//null, //BELC300008224    
                        cuotaActualizada.getImporteMovimiento() ); //BigDecimal importeMovimiento
            } catch (CreateException e) {
				ctx.setRollbackOnly();
                this.loguearError(e);
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            UtilidadesLog.debug("se creo el mov. de C C: " + movimientosLocalCreate.getOid());
            
            // Fin del Si 
            DetalleCargosAbonosDirectosLocalHome homeDtc = this.getDetalleCargosAbonosDirectosLocalHome();
            DetalleCargosAbonosDirectosLocal localDtc = null;

            //El resto de los datos los obtenemos del
            //MovimientoCuentaCorriente en el que estamos posicionados
            try {
                //BELC300008181	             
                localDtc = homeDtc.create(local.getOid(), //cabecera
                        movimientosLocalCreate.getCliente(), //consultora
                        new Integer(numeroLinea.intValue()), //numeroLinea
                        null, //numeroHitoriGneral 
                        new Date(movimientosLocalCreate.getFechaUltimoMovimiento()
                                                 .getTime()), //fechaMovimiento 
                        null,
                        new BigDecimal(movimientosLocalCreate.getImporte()
                                                       .doubleValue()), //importeMoneda,importe 
                        null, null, null, null, null, //referenciaNumeroDocumento,observaciones,glosaContable,moneda,movimientoBancario
                        movimientosLocalCreate.getMedioPago(), //medioPago
                        movimientosLocalCreate.getCuentaOrigen(), //cuotaAnterior
                        movimientosLocalCreate.getCuentaCuota(), //cuotaNueva 
                        movimientosLocalCreate.getOid(), null, //movimiento,cuentaCorriente 
                        null, movimientosLocalCreate.getCodigoUsuario(), //fechaPagoEnBancos,codigoUsuario
                        local.getEmpresa(), tipoAbono); //empresa,tipoAbonoSubproceso
            } catch (PersistenceException e) {
		ctx.setRollbackOnly();
                this.loguearError(e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }
            
            UtilidadesLog.debug("se creo el detalle de C y A: " + localDtc.getOid());
            
        }

        // Fin del for
        UtilidadesLog.info("MONCuentasCorrientesBean.insertarCuotaNegativa(Long pais, Integer ultiOrdenCuota, DTOMovimientoCuentaCompleto[] cuotasNegativas): Salida");
    }

    private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getCabeceraCargosAbonosDirectosLocalHome(): Entrada");
        UtilidadesLog.info("MONCuentasCorrientesBean.getCabeceraCargosAbonosDirectosLocalHome(): Salida");
        return new CabeceraCargosAbonosDirectosLocalHome();
    }
    
    private RecordSet obtenerDatosSubproceso (String proceso, String supbroceso, Long oidPais) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDatosSubproceso (String proceso, String supbroceso, Long oidPais): Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT sub.* FROM CCC_SUBPR sub, CCC_PROCE pro ");
        query.append(" WHERE sub.ccpr_oid_proc = pro.OID_PROC ");
        query.append(" AND pro.PAIS_OID_PAIS= " + oidPais );
        query.append(" AND pro.COD_PROC = '" + proceso  + "' " );
        query.append(" AND sub.cod_subp = '" + supbroceso  + "' " );
        
        try {
            rs = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (Exception ex){
            UtilidadesLog.error("Se produjo un error inesperado en el método MONCuentasCorrientesBean.obtenerDatosSubproceso ");
            return null;
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDatosSubproceso (String proceso, String supbroceso, Long oidPais): Salida");
        return rs;
    }
    
    /**
     * Se actualizan los Movimientos Bancarios a partir de la facturacion.<P>
     * Recibimos un array con movimientos de cuentas corrientes de importe
     * negativo y que se van a cancelar (ya sea por documento de referencia
     * o por antigüedad).
     * 
     * @author
     * @date     
     * @throws MareException
     * Notas:
     *       METODO SIN PANTALLA SE ELIMINAN TODAS LAS REFERENCIAS A BLOQUEO 
     *       INCIDENCIA 9408.
     *       @eiraola 07/12/2005, refac. segun modelo: 
     *       GCC-CCC-001_2005.11.09 GMIOTTI DT 
     *       
     *       05/04/2006 - pperanzola - [1] se modifica para corregir la incidencia DBLG300000498
     *       
     *       @ssaavedr 25/04/2006 -> Se agrega el parámetro de entrada String tipoDeuda
     *                               Se mantiene el signo del total y de los parciales
     *                               Se evaluan los documentos de refencia asociados sólo si tipoDeuda = = “NEGATIVA”
     *                               Se agrega el tipoDeuda en el llamado a obtenerMovCCIndicadorEmisionVto
     *                               Se modifica el cálculo de los totales y los parciales para que se pueda usar 
     *                               cuando el tipo de deuda es positiva o negativa
     *                               (Cancelación automática de deuda positiva y negativa.doc)                         
     *
     *      25/04/2006 - pperanzola - [2] se modifica para corregir la incidencia DBLG300000498
     *      19/05/2006 - pperanzola - [3] se modifica para corregir la incidencia DBLG500000714 
     *      19/05/2006 - pperanzola - [4] se modifica para corregir la incidencia DBLG500000718 
     */
    public void cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos, String tipoDeuda) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos): Entrada");
        /*
         *  Recibimos un array con Movimientos
         *  de Cuentas Corrientes con importes negativos que vamos a cancelar
         *  Entrada: DTOMovimientoCuentaCompleto[] dtos;
         */
		
        double parcialACancelar;
        String proceso = "CCC002";
        String subproceso = "2";
        Long pais = dtos[0].getOidPais();        
        Long tmpOidCargoAbono;
        
        Long indActualizaCuotaSN = null; 
        ///*[1]
        RecordSet rs;
        rs = this.obtenerDatosSubproceso (proceso,subproceso,pais);
        if (rs!= null){
            indActualizaCuotaSN = new Long(((BigDecimal)rs.getValueAt(0,"VAL_INDI_ACTU_CUOT")).longValue()) ;
        }
        //*/[1]

        //sacamos el usuario de la sesion.
        String usuario = ctx.getCallerPrincipal().getName();
        //DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos(usuario);
        DAOCCC daoCCC = new DAOCCC(usuario);
		
    		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		    dtoBelcorp.setOidPais(pais);
        dtoBelcorp.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);

        MONCuentasCorrientesLocal moncccLocal = getMONCuentasCorrientesLocal();
        Integer numeroIdentificacion = moncccLocal.obtenerSecuenciaPais(dtoBelcorp);
        
		    UtilidadesLog.debug("numeroIdentificacion = "+numeroIdentificacion);
        Long oidSubproceso = daoCCC.obtenerOIDSubproceso(pais, proceso,new Integer(subproceso));
        UtilidadesLog.debug("oidSubproceso = "+oidSubproceso);
        DTOSalida cuentaContable = daoCCC.obtenerTiposAbonoSubprocesoCContable(pais,proceso, new Integer(subproceso));
        Long tmpCuotaNueva = new Long(((BigDecimal) cuentaContable.getResultado().getValueAt(0,"CUCO_OID_CUEN_CONT")).longValue());
        Long tmpTipoAbonoCuentaContable = new Long(((BigDecimal) cuentaContable.getResultado().getValueAt(0,"TCAB_OID_TCAB")).longValue());

        RecordSet marcasEntrada = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso,new Integer(subproceso), pais);
        UtilidadesLog.debug("marcasEntrada = "+marcasEntrada );
        RecordSet marcaSalida = daoCCC.obtenerMarcasTipoAbonoSalida(proceso,new Integer(subproceso), pais);
        UtilidadesLog.debug("marcaSalida = "+marcaSalida);
        Byte indicadorEmisionVto = daoCCC.obtenerIndEmisionVtoPais(pais);
        UtilidadesLog.debug("indicadorEmisionVto = "+indicadorEmisionVto);
        //En esta lista guardaremos todos los movimientos que se salden 
        ArrayList canceladas = new ArrayList(); //Contendrá tipos DTOMovimientoCuentaCompleto 
        DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(usuario);
        RecordSet regsDoc = null;
        
        HashMap hashMovimientos = new HashMap();

        //Recorremos el array de cuotas de cancelación que nos ha llegado como parámetro 
        for (int i = 0; i < dtos.length; i++) { // for (1)
            /*
             *  Vamos a cancelar:
             *  por documento referencia si lo tiene
             *  (Si cancelamos por documento referencia y aún no se ha agotado la deuda negativa
             *  aplicaremos por deuda más antigua el resto de la cuota).
             *   ó-
             *  por deuda más antigua
            */
            //@ssaavedr 24/04/2006, quitado por cbios. P2 E.Arese
            //double totalACancelar = Math.abs(dtos[i].getImporte().doubleValue()); //Le quitamos el signo negativo 
            //[2]double totalACancelar = dtos[i].getImporte().doubleValue(); //No se le cambia el signo 
            ///*[2]
            UtilidadesLog.debug("esto es lo que viene con muchos decimales de FAC = "+dtos[i].getImporte().doubleValue());
            dtos[i].setImporte(Double.valueOf(new BigDecimal (dtos[i].getImporte().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));
            dtos[i].setImportePagado(Double.valueOf(new BigDecimal (dtos[i].getImportePagado().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));
            dtos[i].setImportePendiente(Double.valueOf(new BigDecimal (dtos[i].getImportePendiente().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));
            UtilidadesLog.debug("Importe = "+dtos[i].getImporte().doubleValue());
            UtilidadesLog.debug("ImportePagado = "+dtos[i].getImportePagado().doubleValue());
            UtilidadesLog.debug("ImportePendiente= "+dtos[i].getImportePendiente().doubleValue());
            //*/[2]
            double totalACancelar = dtos[i].getImporte().doubleValue(); //No se le cambia el signo 
            
            UtilidadesLog.debug("totalACancelar = "+totalACancelar);
            
            int longitudDoc = 0;
            int longitudAntiguos = 0;

            /*
             *  POR DOCUMENTO REFERENCIA
             */
            Long[] oidsMarcasEntrada = new Long[marcasEntrada.getRowCount()];
            for (int f = 0; f < marcasEntrada.getRowCount(); f++) {      
				//Poner si es nullable
                oidsMarcasEntrada[f] = new Long(((BigDecimal) marcasEntrada.getValueAt(f, "OID_MARC_SITU")).longValue());
            }
            
            DTOMovimientoCuentaCompleto dtoCancelar = null;
            
            //@ssaavedr 24/04/2006, cambiado por cbios. P2 E.Arese
            //if (dtos[i].getOidPedidoSolicitudCab() != null){ // Si (2) 	
            /*
             * DBLG500000979 - dmorello, 07/08/2006
             * Con el OID de cabecera se obtiene el OID de la solicitud de referencia
             * y se pasa éste al método del DAO en vez de aquél.
             */
            DAOSolicitud daoSol = new DAOSolicitud();
            DTOCabeceraSolicitud dtoCabe = daoSol.obtenerCabeceraSolicitud(dtos[i].getOidPedidoSolicitudCab());
            //if ((dtos[i].getOidPedidoSolicitudCab() != null) && (tipoDeuda.equals(String.valueOf('N')))){ // Si (2) 
            if ((dtoCabe.getOidDocumentoReferencia() != null) && (tipoDeuda.equals(String.valueOf('N')))){ // Si (2) 
            
                UtilidadesLog.debug("*** Se cancelan coutas por documento de referencia ***"); 
                regsDoc = daoCuentasCorrientes.obtenerMovCCSolicitudPedido(dtos[i].getOidPais(), //LONG
                        dtos[i].getOidCliente(), //LONG
                        dtos[i].getEmpresa(), //LONG													
                        dtos[i].getEjercicioCuota(), //STRING
                        dtos[i].getNumeroIdentificadorCuota(), //INTEGER
                        //dtos[i].getOidPedidoSolicitudCab(), //LONG
                        //Gacevedo, no se usa el oidsolicitud (28/09/2006)
                        null,
                        //dtoCabe.getOidDocumentoReferencia(),  // LONG
                        oidsMarcasEntrada); //LONG []													

                longitudDoc = regsDoc.getRowCount();

                for (int j = 0; j < longitudDoc; j++) {//for (3) 
                    dtoCancelar = new DTOMovimientoCuentaCompleto();
                    //Recorremos el recordset y vamos rellenando los campos con los datos del registro
                    dtoCancelar.setOidPais(dtos[i].getOidPais());
                    dtoCancelar.setCuentaCuota(new Long(((BigDecimal) regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_CUOT")).longValue()));
                    dtoCancelar.setCuentaOrigen(new Long(((BigDecimal) regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_ORIG")).longValue()));
                    dtoCancelar.setDivisa((regsDoc.getValueAt(j, "MONE_OID_MONE") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j, "MONE_OID_MONE")).longValue()) : null); //nullable
                    dtoCancelar.setDocumentoAnyo(regsDoc.getValueAt(j,"VAL_DOCU_ANIO").toString());
                    dtoCancelar.setDocumentoMesSerie((String) regsDoc.getValueAt(j, "VAL_DOCU_MES_SERI"));
                    dtoCancelar.setDocumentoNumero(new Integer(((BigDecimal) regsDoc.getValueAt(j, "VAL_DOCU_NUME")).intValue()));
                    dtoCancelar.setEjercicioCuota((String) regsDoc.getValueAt(j, "VAL_EJER_CUOT"));
                    dtoCancelar.setEmpresa(new Long(((BigDecimal) regsDoc.getValueAt(j, "SOCI_OID_SOCI")).longValue()));
                    dtoCancelar.setFechaContabilizacion((regsDoc.getValueAt(j,"FEC_CONTA") != null) ? (Date) regsDoc.getValueAt(j, "FEC_CONTA") : null); //nullable
                    dtoCancelar.setFechaDocumento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_DOCU")).getTime()));
                    dtoCancelar.setFechaUltimoMovimiento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_ULTI_MOVI")).getTime()));
                    dtoCancelar.setFechaValor((regsDoc.getValueAt(j, "FEC_VALO") != null) ? new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_VALO")).getTime()) : null); //nullable
                    dtoCancelar.setFechaVencimiento((Date) regsDoc.getValueAt( j, "FEC_VENC"));
                    dtoCancelar.setImporte(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI")).doubleValue()));
                    dtoCancelar.setImporteDivisa((regsDoc.getValueAt(j,"IMP_DIVI") != null) ? new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_DIVI")).doubleValue()) : null); //nullable
                    dtoCancelar.setImporteMovimiento((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI"));
                    dtoCancelar.setImporteMovimientoDivisa((regsDoc.getValueAt(j, "IMP_MOVI_DIVI") != null) ? (BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI_DIVI") : null); //nullable
                    dtoCancelar.setImportePagado(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PAGA")).doubleValue()));
                    dtoCancelar.setImportePagadoDivisa((regsDoc.getValueAt(j,"IMP_PAGA_DIVI") != null) ? new Double(((BigDecimal)regsDoc.getValueAt(j, "IMP_PAGA_DIVI")).doubleValue()) : null); //nullable
                    dtoCancelar.setImportePago((regsDoc.getValueAt(j, "IMP_PAGO") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO") : null); //nullable
                    dtoCancelar.setImportePagoDivisa((regsDoc.getValueAt(j, "IMP_PAGO_DIVI") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO_DIVI") : null); //nullable
                    dtoCancelar.setImportePendiente(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PEND")).doubleValue()));
                    dtoCancelar.setIndicaDescuentoRecargo((regsDoc.getValueAt(j, "IND_DTO_CARG_APLI") != null) ? Boolean.valueOf((((BigDecimal) regsDoc.getValueAt(j,"IND_DTO_CARG_APLI")).intValue() == 1) ? true : false) : null); //nullable //13561
                    dtoCancelar.setMarca((regsDoc.getValueAt(j, "MARC_OID_MARC") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j, "MARC_OID_MARC")).longValue()) : null); //nullable
                    dtoCancelar.setMarcaSituacion(new Long(((BigDecimal) regsDoc.getValueAt(j,"MASI_OID_MARC_SITU")).longValue()));
                    dtoCancelar.setMedioPago((regsDoc.getValueAt(j,"MPAB_OID_MEDI_PAGO") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j,"MPAB_OID_MEDI_PAGO")).longValue()) : null); //nullable
                    dtoCancelar.setNumeroIdentificadorCuota(new Integer(((BigDecimal) regsDoc.getValueAt(i, "NUM_IDEN_CUOT")).intValue()));
                    dtoCancelar.setNumeroLoteContabilizacion((regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") != null) ? (String) regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") : null);
                    dtoCancelar.setNumeroLoteFactu((regsDoc.getValueAt(j,"NUM_LOTE_FACT") != null) ? new Integer(((BigDecimal) regsDoc.getValueAt(j, "NUM_LOTE_FACT")).intValue()) : null); //nullable
                    dtoCancelar.setNumeroOrdenCuota(new Integer(((BigDecimal) regsDoc.getValueAt(j, "NUM_ORDE_CUOT")).intValue()));
                    dtoCancelar.setNumeroSerieCuota(regsDoc.getValueAt(j,"VAL_NUME_SERI_CUOOT").toString());
                    dtoCancelar.setObservaciones((regsDoc.getValueAt(j,"VAL_OBSE") != null) ? (String) regsDoc.getValueAt(i, "VAL_OBSE") : null); //nullable
                    dtoCancelar.setOid(new Long(((BigDecimal) regsDoc.getValueAt(j, "OID_MOVI_CC")).longValue()));
                    dtoCancelar.setOidCliente(new Long(((BigDecimal) regsDoc.getValueAt(j, "CLIE_OID_CLIE")).longValue()));
                    dtoCancelar.setOidMoneda((regsDoc.getValueAt(j,"MONE_OID_MONE") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j, "MONE_OID_MONE")).longValue()) : null); //nullable
                    dtoCancelar.setOidPedidoSolicitudCab((regsDoc.getValueAt(j, "SOCA_OID_SOLI_CABE") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j,"SOCA_OID_SOLI_CABE")).longValue()) : null); // nullable
                    dtoCancelar.setOidRegion((regsDoc.getValueAt(j,"ZORG_OID_REGI") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j,"ZORG_OID_REGI")).longValue()) : null); // nullable
                    dtoCancelar.setOidSeccion(new Long(((BigDecimal) regsDoc.getValueAt(j, "ZSCC_OID_SECC")).longValue()));
                    dtoCancelar.setOidSubtipoCliente(new Long(((BigDecimal) regsDoc.getValueAt(j,"SBTI_OID_SUBT_CLIE")).longValue()));
                    dtoCancelar.setOidSugerenciaVenta(new Long(((BigDecimal) regsDoc.getValueAt(j,"ZSGV_OID_SUBG_VENT")).longValue()));
                    dtoCancelar.setOidTipoDocumentoLegal((regsDoc.getValueAt(j,"TIDO_OID_TIPO_DOCU")!=null) ? new Long(((BigDecimal)regsDoc.getValueAt(j,"TIDO_OID_TIPO_DOCU")).longValue()) : null);
                    dtoCancelar.setOidTipoSolicitud(regsDoc.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS") != null ? new Long(((BigDecimal) regsDoc.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS")).longValue()): null);
                    dtoCancelar.setPeriodoDesde(new Long(((BigDecimal) regsDoc.getValueAt(j, "PERD_OID_PERI")).longValue()));
                    dtoCancelar.setReferenciaNumeroDocumentoExterno((regsDoc.getValueAt(j, "VAL_REFE_NUME_DOCU_EXTE") != null) ? (String) regsDoc.getValueAt(j,"VAL_REFE_NUME_DOCU_EXTE") : null); //nullable
                    dtoCancelar.setSubacceso(new Long(((BigDecimal) regsDoc.getValueAt(j, "SBAC_OID_SBAC")).longValue()));
                    dtoCancelar.setSubprocesoCreacion(new Long(((BigDecimal) regsDoc.getValueAt(j,"SUBP_OID_SUBP_CREA")).longValue()));
                    dtoCancelar.setSubprocesoUltimo(new Long(((BigDecimal) regsDoc.getValueAt(j,"SUBP_OID_SUBP_ULTI")).longValue()));
                    dtoCancelar.setTerritorioAdministrativo(new Long(((BigDecimal) regsDoc.getValueAt(j,"ZTAD_OID_TERR_ADMI")).longValue()));
                    dtoCancelar.setTipoAbonoCreacion(new Long(((BigDecimal) regsDoc.getValueAt(j,"TCAB_OID_TCAB_CREA")).longValue()));
                    dtoCancelar.setTipoAbonoUltimo(new Long(((BigDecimal) regsDoc.getValueAt(j,"TCAB_OID_TCAB_ULTI")).longValue()));
                    dtoCancelar.setTipoCambio((BigDecimal) regsDoc.getValueAt(j, "IND_TIPO_CAMB"));
                    dtoCancelar.setTipoCliente(new Long(((BigDecimal) regsDoc.getValueAt(j,"TICL_OID_TIPO_CLIE")).longValue()));
                    dtoCancelar.setTipoPeriodoDesde((regsDoc.getValueAt(j,"TIPE_OID_TIPO_PERI") != null) ? new Long(((BigDecimal) regsDoc.getValueAt(j,"TIPE_OID_TIPO_PERI")).longValue()) : null); //nullable
                    dtoCancelar.setUltimoDocumentoAnyo((regsDoc.getValueAt(j,"VAL_ULTI_DOCU_ANIO") != null) ? (String) regsDoc.getValueAt(j, "VAL_ULTI_DOCU_ANIO") : null); //nullable
                    dtoCancelar.setUltimoDocumentoMesSerie((regsDoc.getValueAt( j, "VAL_ULTI_DOCU_MES_SERI") != null) ? (String) regsDoc.getValueAt(j,"VAL_ULTI_DOCU_MES_SERI") : null); //nullable
                    dtoCancelar.setUltimoDocumentoNumero((regsDoc.getValueAt(j, "VAL_ULTI_DOCU_NUME") != null) ? new Integer(((BigDecimal) regsDoc.getValueAt(j,"VAL_ULTI_DOCU_NUME")).intValue()) : null); //nullable
                    dtoCancelar.setUltimoNumeroHistoria((regsDoc.getValueAt(j,"VAL_ULTI_NUME_HIST") != null) ? new Integer(((BigDecimal) regsDoc.getValueAt(j,"VAL_ULTI_NUME_HIST")).intValue()) : null); //nullable);

                    parcialACancelar = 0;

                    /* //@ssaavedr 24/04/2006, cambiado por cbios. P2 E.Arese
                    if (totalACancelar > dtoCancelar.getImportePendiente().doubleValue()) {
                        totalACancelar -= dtoCancelar.getImportePendiente().doubleValue();
                        parcialACancelar = dtoCancelar.getImportePendiente().doubleValue();
                    } else {
                        parcialACancelar = totalACancelar;
                        totalACancelar = 0;
                    }*/
                    
                    if ( (totalACancelar+dtoCancelar.getImportePendiente().doubleValue()) < 0) {
                        totalACancelar += dtoCancelar.getImportePendiente().doubleValue();
                        parcialACancelar = dtoCancelar.getImportePendiente().doubleValue();
                    } else{
                        parcialACancelar = (totalACancelar * -1);
                        totalACancelar = 0;
                    }
                    
                    /*
                     *  Actualizar la Cuota de Cancelación (parámetro dtos[i])
                     *
                     */

                    //BigDecimal bParcialACancelar = new BigDecimal(parcialACancelar); [2]
                    UtilidadesLog.debug("*** parcialACancelar = "+parcialACancelar);
                    Long lngMarcasEntrada = new Long(((BigDecimal) marcasEntrada.getValueAt(0, "TASP_OID_TIPO_ABON_SUBP")).longValue());
                    Long lngMarcaSalida = new Long(((BigDecimal) marcaSalida.getValueAt(0, "OID_MARC_SITU")).longValue());
                    //[3] Long lngCuentaContable = new Long(((BigDecimal) cuentaContable.getResultado().getValueAt(0,"CUCO_OID_CUEN_CONT")).longValue());
                    UtilidadesLog.debug("*** dtoCancelar = "+dtoCancelar);
                    this.actualizarCuotasCancelacion(dtos[i], // DTOMovimientoCuentaCompleto
                        parcialACancelar, // [2] bParcialACancelar, // BIGDECIMAL
                        indicadorEmisionVto.toString(), // STRING
                        lngMarcasEntrada, // LONG
                        lngMarcaSalida, // LONG
                        numeroIdentificacion, // INTEGER
                        oidSubproceso, // LONG											
                        tmpCuotaNueva,//lngCuentaContable,
                        indActualizaCuotaSN, /*[1]*/ // LONG
                        tmpTipoAbonoCuentaContable);
                        
                        hashMovimientos.put(dtos[i].getOid(),dtos[i]);

                        //SCS-EA 07/09/2006, no se adhieren mas a canceladas los movimientos que entran  
                        //DTOMovimientoCuentaCompleto dtoTMP = new DTOMovimientoCuentaCompleto();
                        //dtoTMP = copiarDTOMovimientoCuentaCompleto(dtos[i]);
                        //canceladas.add(canceladas.size(), dtoTMP);
                        
                    this.actualizarCuotasACancelar(dtoCancelar, // DTOMovimientoCuentaCompleto 
                        parcialACancelar,//[2] bParcialACancelar, // BIGDECIMAL
                        indicadorEmisionVto.toString(), // STRING
                        lngMarcasEntrada, // LONG
                        lngMarcaSalida, // LONG
                        numeroIdentificacion, // INTEGER
                        oidSubproceso, // LONG											
                        tmpCuotaNueva,//lngCuentaContable,
                        indActualizaCuotaSN, /*[1]*/ // LONG
                        tmpTipoAbonoCuentaContable);
                        //canceladas.add(dtoCancelar);
                        
                        DTOMovimientoCuentaCompleto dtoTMP1 = new DTOMovimientoCuentaCompleto();
                        dtoTMP1 = copiarDTOMovimientoCuentaCompleto(dtoCancelar);
                        canceladas.add(canceladas.size(), dtoTMP1);

                    if (totalACancelar == 0) {
                        break;
                    }
                } // fin del for (3)     
            }// fin del Si (2) 

            /*
            *  Si no queda cuota de cancelación vamos a por la siguiente
            */
            if (totalACancelar == 0) {
                continue;
            }

            /*
            *   Si todavía queda cuota o no se ha encontrado documento de referencia entonces cancelamos las deudas más antiguas
            *        //POR ANTIGUEDAD
            */
            UtilidadesLog.debug(" *** Se cancelan deudas por antiguedad *** ");
            //@ssaavedr 24/04/2006, cambiado por cbios. P2 E.Arese
            /*RecordSet regsAntiguos = daoCuentasCorrientes.obtenerMovCCIndicadorEmisionVto(indicadorEmisionVto.toString(), //STRING
                    dtos[i].getOidPais(), //LONG
                    dtos[i].getOidCliente(), //LONG
                    dtos[i].getEmpresa(), //LONG																			 
                    dtos[i].getOidMoneda(), //LONG																		
                    oidsMarcasEntrada);//LONG[]
                    */
            RecordSet regsAntiguos = daoCuentasCorrientes.obtenerMovCCIndicadorEmisionVto(indicadorEmisionVto.toString(), //STRING
                    dtos[i].getOidPais(), //LONG
                    dtos[i].getOidCliente(), //LONG
                    dtos[i].getEmpresa(), //LONG																			 
                    dtos[i].getOidMoneda(), //LONG																		
                    oidsMarcasEntrada, 
                    tipoDeuda);

            longitudAntiguos = regsAntiguos.getRowCount();
			UtilidadesLog.debug("*** SCS Nº de registros obtenidos, en daoCuentasCorrientes.obtenerMovCCIndicadorEmisionVto(... = " + longitudAntiguos);
            UtilidadesLog.debug("*** SCS y los registros son: " + longitudAntiguos);
            //regsAntiguos.
            for (int k = 0; k < longitudAntiguos; k++) { //(4) 
                parcialACancelar = 0;
                dtoCancelar = new DTOMovimientoCuentaCompleto();
                dtoCancelar.setOidPais(dtos[i].getOidPais());
                //Recorremos el recordset y vamos rellenando los campos con los datos del registro
                dtoCancelar.setCuentaCuota(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"CUCO_OID_CUEN_CONT_CUOT")).longValue()));
                dtoCancelar.setCuentaOrigen(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"CUCO_OID_CUEN_CONT_ORIG")).longValue()));
                dtoCancelar.setDivisa((regsAntiguos.getValueAt(k,"MONE_OID_MONE") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k, "MONE_OID_MONE")).longValue()) : null); //nullable
                dtoCancelar.setDocumentoAnyo(regsAntiguos.getValueAt(k,"VAL_DOCU_ANIO").toString());
                dtoCancelar.setDocumentoMesSerie((String) regsAntiguos.getValueAt(k, "VAL_DOCU_MES_SERI"));
                dtoCancelar.setDocumentoNumero(new Integer(((BigDecimal) regsAntiguos.getValueAt(k, "VAL_DOCU_NUME")).intValue()));
                dtoCancelar.setEjercicioCuota((String) regsAntiguos.getValueAt(k, "VAL_EJER_CUOT"));
                dtoCancelar.setEmpresa(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "SOCI_OID_SOCI")).longValue()));
                dtoCancelar.setFechaContabilizacion((regsAntiguos.getValueAt(k, "FEC_CONTA") != null) ? (Date)regsAntiguos.getValueAt(k, "FEC_CONTA") : null); //nullable
                dtoCancelar.setFechaDocumento(new Timestamp(((Date)regsAntiguos.getValueAt(k, "FEC_DOCU")).getTime()));
                dtoCancelar.setFechaUltimoMovimiento(new Timestamp(((Date)regsAntiguos.getValueAt(k, "FEC_ULTI_MOVI")).getTime()));
                dtoCancelar.setFechaValor((regsAntiguos.getValueAt(k, "FEC_VALO") != null) ? new Timestamp(((Date) regsAntiguos.getValueAt(k, "FEC_VALO")).getTime()) : null); //nullable
                dtoCancelar.setFechaVencimiento((Date) regsAntiguos.getValueAt(k, "FEC_VENC"));
                dtoCancelar.setImporte(new Double(((BigDecimal) regsAntiguos.getValueAt(k, "IMP_MOVI")).doubleValue()));
                dtoCancelar.setImporteDivisa((regsAntiguos.getValueAt(k,"IMP_DIVI") != null) ? new Double(((BigDecimal) regsAntiguos.getValueAt(k, "IMP_DIVI")).doubleValue()) : null); //nullable
                dtoCancelar.setImporteMovimiento((BigDecimal) regsAntiguos.getValueAt(k, "IMP_MOVI"));
                dtoCancelar.setImporteMovimientoDivisa((regsAntiguos.getValueAt(k, "IMP_MOVI_DIVI") != null) ? (BigDecimal) regsAntiguos.getValueAt(k, "IMP_MOVI_DIVI") : null); //nullable
                dtoCancelar.setImportePagado(new Double(((BigDecimal) regsAntiguos.getValueAt(k, "IMP_PAGA")).doubleValue()));
                dtoCancelar.setImportePagadoDivisa((regsAntiguos.getValueAt(k,"IMP_PAGA_DIVI") != null) ? new Double(((BigDecimal) regsAntiguos.getValueAt(k, "IMP_PAGA_DIVI")).doubleValue()) : null); //nullable
                dtoCancelar.setImportePago((regsAntiguos.getValueAt(k, "IMP_PAGO") != null) ? (BigDecimal) regsAntiguos.getValueAt(k, "IMP_PAGO") : null); //nullable
                dtoCancelar.setImportePagoDivisa((regsAntiguos.getValueAt(k,"IMP_PAGO_DIVI") != null) ? (BigDecimal) regsAntiguos.getValueAt(k, "IMP_PAGO_DIVI") : null); //nullable
                dtoCancelar.setImportePendiente(new Double(((BigDecimal) regsAntiguos.getValueAt(k, "IMP_PEND")).doubleValue()));
                dtoCancelar.setIndicaDescuentoRecargo((regsAntiguos.getValueAt(k, "IND_DTO_CARG_APLI") != null) ? Boolean.valueOf((((BigDecimal) regsAntiguos.getValueAt(k,"IND_DTO_CARG_APLI")).intValue() == 1) ? true : false) : null); //nullable //13561
                dtoCancelar.setMarca((regsAntiguos.getValueAt(k, "MARC_OID_MARC") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k, "MARC_OID_MARC")).longValue()) : null); //nullable
                dtoCancelar.setMarcaSituacion(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"MASI_OID_MARC_SITU")).longValue()));
                dtoCancelar.setMedioPago((regsAntiguos.getValueAt(k,"MPAB_OID_MEDI_PAGO") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"MPAB_OID_MEDI_PAGO")).longValue()) : null); //nullable
                dtoCancelar.setNumeroIdentificadorCuota(new Integer(((BigDecimal) regsAntiguos.getValueAt(k, "NUM_IDEN_CUOT")).intValue()));
                dtoCancelar.setNumeroLoteContabilizacion((regsAntiguos.getValueAt(k, "VAL_NUME_LOTE_CONT") != null) ? (String) regsAntiguos.getValueAt(k, "VAL_NUME_LOTE_CONT") : null);
                dtoCancelar.setNumeroLoteFactu((regsAntiguos.getValueAt(k,"NUM_LOTE_FACT") != null) ? new Integer(((BigDecimal) regsAntiguos.getValueAt(k, "NUM_LOTE_FACT")).intValue()) : null); //nullable
                dtoCancelar.setNumeroOrdenCuota(new Integer(((BigDecimal) regsAntiguos.getValueAt(k, "NUM_ORDE_CUOT")).intValue()));
                dtoCancelar.setNumeroSerieCuota(regsAntiguos.getValueAt(k,"VAL_NUME_SERI_CUOOT").toString());
                dtoCancelar.setObservaciones((regsAntiguos.getValueAt(k,"VAL_OBSE") != null) ? (String) regsAntiguos.getValueAt(k, "VAL_OBSE") : null); //nullable
                dtoCancelar.setOid(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "OID_MOVI_CC")).longValue()));
                dtoCancelar.setOidCliente(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "CLIE_OID_CLIE")).longValue()));
                dtoCancelar.setOidMoneda((regsAntiguos.getValueAt(k,"MONE_OID_MONE") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k, "MONE_OID_MONE")).longValue()) : null); //nullable
                dtoCancelar.setOidPedidoSolicitudCab((regsAntiguos.getValueAt( k, "SOCA_OID_SOLI_CABE") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"SOCA_OID_SOLI_CABE")).longValue()) : null); // nullable
                dtoCancelar.setOidRegion((regsAntiguos.getValueAt(k,"ZORG_OID_REGI") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"ZORG_OID_REGI")).longValue()) : null); // nullable
                dtoCancelar.setOidSeccion(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "ZSCC_OID_SECC")).longValue()));
                dtoCancelar.setOidSubtipoCliente(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"SBTI_OID_SUBT_CLIE")).longValue()));
                dtoCancelar.setOidSugerenciaVenta(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"ZSGV_OID_SUBG_VENT")).longValue()));
                dtoCancelar.setOidTipoDocumentoLegal((regsAntiguos.getValueAt(k,"TIDO_OID_TIPO_DOCU")!=null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TIDO_OID_TIPO_DOCU")).longValue()) : null);
                dtoCancelar.setOidTipoSolicitud(regsAntiguos.getValueAt(k,"TSPA_OID_TIPO_SOLI_PAIS") != null ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TSPA_OID_TIPO_SOLI_PAIS")).longValue()): null);
                dtoCancelar.setPeriodoDesde(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "PERD_OID_PERI")).longValue()));
                dtoCancelar.setReferenciaNumeroDocumentoExterno((regsAntiguos.getValueAt(k, "VAL_REFE_NUME_DOCU_EXTE") != null) ? (String)regsAntiguos.getValueAt(k,"VAL_REFE_NUME_DOCU_EXTE") : null); //nullable
                dtoCancelar.setSubacceso(new Long(((BigDecimal) regsAntiguos.getValueAt(k, "SBAC_OID_SBAC")).longValue()));
                dtoCancelar.setSubprocesoCreacion(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"SUBP_OID_SUBP_CREA")).longValue()));
                dtoCancelar.setSubprocesoUltimo(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"SUBP_OID_SUBP_ULTI")).longValue()));
                dtoCancelar.setTerritorioAdministrativo(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"ZTAD_OID_TERR_ADMI")).longValue()));
                dtoCancelar.setTipoAbonoCreacion(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TCAB_OID_TCAB_CREA")).longValue()));
                dtoCancelar.setTipoAbonoUltimo(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TCAB_OID_TCAB_ULTI")).longValue()));
                dtoCancelar.setTipoCambio((BigDecimal) regsAntiguos.getValueAt(k, "IND_TIPO_CAMB"));
                dtoCancelar.setTipoCliente(new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TICL_OID_TIPO_CLIE")).longValue()));
                dtoCancelar.setTipoPeriodoDesde((regsAntiguos.getValueAt(k,"TIPE_OID_TIPO_PERI") != null) ? new Long(((BigDecimal) regsAntiguos.getValueAt(k,"TIPE_OID_TIPO_PERI")).longValue()) : null); //nullable
                dtoCancelar.setUltimoDocumentoAnyo((regsAntiguos.getValueAt(k,"VAL_ULTI_DOCU_ANIO") != null) ? (String)regsAntiguos.getValueAt(k, "VAL_ULTI_DOCU_ANIO") : null); //nullable
                dtoCancelar.setUltimoDocumentoMesSerie((regsAntiguos.getValueAt(k, "VAL_ULTI_DOCU_MES_SERI") != null) ? (String) regsAntiguos.getValueAt(k,"VAL_ULTI_DOCU_MES_SERI") : null); //nullable
                dtoCancelar.setUltimoDocumentoNumero((regsAntiguos.getValueAt(k, "VAL_ULTI_DOCU_NUME") != null) ? new Integer(((BigDecimal) regsAntiguos.getValueAt(k,"VAL_ULTI_DOCU_NUME")).intValue()) : null); //nullable
                dtoCancelar.setUltimoNumeroHistoria((regsAntiguos.getValueAt(k, "VAL_ULTI_NUME_HIST") != null) ? new Integer(((BigDecimal) regsAntiguos.getValueAt(k,"VAL_ULTI_NUME_HIST")).intValue()) : null); //nullable);
                
                //@ssaavedr 24/04/2006, cambiado por cbios. P2 E.Arese
                /*if (totalACancelar > dtoCancelar.getImportePendiente().doubleValue()) {
                    totalACancelar -= dtoCancelar.getImportePendiente().doubleValue();
                    parcialACancelar = dtoCancelar.getImportePendiente().doubleValue();
                } else {
                    parcialACancelar = totalACancelar;
                    totalACancelar = 0;
                }*/
                
                if ( (tipoDeuda.equals(String.valueOf('N')) && (totalACancelar + (dtoCancelar.getImportePendiente().doubleValue())<0)) || 
                     (tipoDeuda.equals(String.valueOf('P')) && (totalACancelar + (dtoCancelar.getImportePendiente().doubleValue())>0)) ) {
                     totalACancelar += dtoCancelar.getImportePendiente().doubleValue();
                     parcialACancelar = dtoCancelar.getImportePendiente().doubleValue();
                }else{
                    parcialACancelar = (totalACancelar * -1);
                    totalACancelar = 0;
                }
                
                //Actualizar la Cuota de Cancelación (parámetro dtos[i]) 	
                BigDecimal bParcialACancelar = new BigDecimal(parcialACancelar);
                UtilidadesLog.debug("*** bParcialACancelar = "+bParcialACancelar);
                UtilidadesLog.debug("*** parcialACancelar = "+parcialACancelar);
                Long lngMarcasEntrada = new Long(((BigDecimal) marcasEntrada.getValueAt(0, "TASP_OID_TIPO_ABON_SUBP")).longValue());
                UtilidadesLog.debug("*** lngMarcasEntrada = "+lngMarcasEntrada);
                Long lngMarcaSalida = new Long(((BigDecimal) marcaSalida.getValueAt(0, "OID_MARC_SITU")).longValue());
                UtilidadesLog.debug("*** lngMarcaSalida = "+lngMarcaSalida);
                //Long lngCuentaContable = new Long(((BigDecimal) cuentaContable.getResultado().getValueAt(0,"CUCO_OID_CUEN_CONT")).longValue());
                //UtilidadesLog.debug("*** lngCuentaContable = "+lngCuentaContable);
                UtilidadesLog.debug("*** dtoCancelar = "+dtoCancelar);
                
                this.actualizarCuotasCancelacion(dtos[i], // DTOMovimientoCuentaCompleto
                    parcialACancelar,// [2] bParcialACancelar, // BIGDECIMAL
                    indicadorEmisionVto.toString(), // STRING
                    lngMarcasEntrada, // LONG
                    lngMarcaSalida, // LONG
                    numeroIdentificacion, // INTEGER
                    oidSubproceso, // LONG											
                    tmpCuotaNueva//[3]lngCuentaContable
                    ,indActualizaCuotaSN,
                    tmpTipoAbonoCuentaContable);/*[1]*/ // LONG
                
                    //DTOMovimientoCuentaCompleto dtoTMP = new DTOMovimientoCuentaCompleto();
                    //dtoTMP = copiarDTOMovimientoCuentaCompleto(dtos[i]);
                    //canceladas.add(canceladas.size(), dtoTMP);
                
                hashMovimientos.put(dtos[i].getOid(),dtos[i]);
                
                this.actualizarCuotasACancelar(dtoCancelar, // DTOMovimientoCuentaCompleto 
                    parcialACancelar,//[2] bParcialACancelar, // BIGDECIMAL
                    indicadorEmisionVto.toString(), // STRING
                    lngMarcasEntrada, // LONG
                    lngMarcaSalida, // LONG
                    numeroIdentificacion, // INTEGER
                    oidSubproceso, // LONG											
                    tmpCuotaNueva//[3] lngCuentaContable
                    ,indActualizaCuotaSN, /*[1]*/ // LONG
                    tmpTipoAbonoCuentaContable);
                    //canceladas.add(dtoCancelar);
                    
                    DTOMovimientoCuentaCompleto dtoTMP2 = new DTOMovimientoCuentaCompleto();
                    dtoTMP2 = copiarDTOMovimientoCuentaCompleto(dtoCancelar);
                    canceladas.add(canceladas.size(), dtoTMP2);                    

                if (totalACancelar == 0) {
                    break;
                }
            } //fin del for (4) 
        } // fin del for (1) 

        /*
         * Generamos un solo registro de CabeceraCargosAbonosDirectos para todas las cuotas saldadas.
         * Llamamos al create() de la entidad CabeceraCargosAbonosDirectos con los
         * datos siguientes y los que nos falten los tomamos del primer dtos[0]:
        */
        CabeceraCargosAbonosDirectosLocalHome homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();
        CabeceraCargosAbonosDirectosLocal localCCAD = null;
        String anio = null;
        String periodoMes = null;
        Date fechaDocumento = new Date(System.currentTimeMillis());
        UtilidadesLog.debug("*** fechaDocumento = "+fechaDocumento);
        try {
            anio = UtilidadesFecha.convertirAString(fechaDocumento, "yy");
            periodoMes = UtilidadesFecha.convertirAString(fechaDocumento, "MM");
        } catch (ParseException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_FORMATO_FECHA));
        }
        UtilidadesLog.debug("anio = "+anio);
        UtilidadesLog.debug("periodoMes = "+periodoMes);
		Long oidProceso = daoCCC.obtieneProceso(proceso,pais); // Anadido por incidencia
        UtilidadesLog.debug("oidProceso = "+oidProceso);
        try {
            UtilidadesLog.debug("Se realiza el create en CabeceraCargosAbonosDirectos");
            localCCAD = homeCCAD.create(numeroIdentificacion, //numeroIdentificacion INTEGER
                    anio, // sacar el anio del sistema STRING
                    periodoMes, // sacar mes del sistema STRING
                    fechaDocumento, // fecha del sistema DATE
                    new java.sql.Date(dtos[0].getFechaValor().getTime()), // DATE fechaValor
                    dtos[0].getReferenciaNumeroDocumentoExterno(), //STRING ReferenciaExterna
                    dtos[0].getNumeroLoteContabilizacion(), // STRING numeroLoteContabilizacion
                    (dtos[0].getFechaContabilizacion() != null)
                    ? new java.sql.Date(dtos[0].getFechaContabilizacion()
                                               .getTime()) : null, //DATE setFechaContabilizacion
                    dtos[0].getObservaciones(), //STRING observaciones,		
                    null, // [4] dtos[0].getSubacceso(), //LONG subacceso
                    dtos[0].getOidPais(), //LONG pais
                    dtos[0].getEmpresa(), //LONG empresa //soci_oid_soci
                    null,// [4]dtos[0].getOidCliente(), //LONG  cliente
                    usuario, // STRING codigoUsuario
                    null,// [4]dtos[0].getTipoAbonoUltimo(), // LONG tipoAbonoSubproceso
                    null, //situacion  ver incidencia quique.
                    null, //dtos[0].//String setCodigoClienteDesde
                    null, //dtos[0].//String codigoClienteHasta
                    null, //dtos[0].// String periodoDesde
                    null, //periodoHasta
                    null, //fechaDocumentoDesde
                    null, //fechaDocumentoHasta
                    null, //fechaVencimientoHasta
                    null, //fechaVencimientoDesde
                    null,
                    oidProceso); //dtos[0].// String cuentacorriente

            /* 
             * Cambio: GCC-CCC-001_2005.11.09 GMIOTTI DT 
             * Completamos el dtos[0].oid con el generado para la cabecera insertada.
             */
            dtos[0].setOidCargoAbono(localCCAD.getOid()); //[1] dtos[0].setOid(localCCAD.getOid()); 
            tmpOidCargoAbono = localCCAD.getOid();
            
        } catch (PersistenceException e) {
            this.loguearError(e);
            ctx.setRollbackOnly();

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
         
        /*
         * Generamos un registro para cada cuota de cancelación y a cancelar que se salden,
         * en DetalleCargosAbonosDirecctos
         */
        int numeroLinea = 1;//[3] int numeroLinea = 0;
        UtilidadesLog.debug("Se crean los registros en DetalleCargosAbonosDirectos");
        for (int i = 0; i < canceladas.size(); i++) {
            DTOMovimientoCuentaCompleto dto = (DTOMovimientoCuentaCompleto) canceladas.get(i);
            dto.setOidCargoAbono(tmpOidCargoAbono);
            UtilidadesLog.debug("*** DTO = "+dto);
            
            /*
             *  Llamamos al create() de la entidad DetalleCargosAbonosDirectos pasándole los datos
             *  necesarios obtenidos en el dto de la fila anterior y los siguientes datos:
             *  numeroIdentificacion
             *  anyo
             *  mes
             *  ++numeroLinea 
             *  numeroHistoriaGenera=dto.ultimoNumeroHistoria+1;
             *  fechaDocumento = fecha del sistema
             *  cuentaContableAnterior = dto.cuentaOrigen;
             *  cuentaContableNueva = cuentaContable;
             */
            DetalleCargosAbonosDirectosLocalHome homeDCAD = this.getDetalleCargosAbonosDirectosLocalHome();
            DetalleCargosAbonosDirectosLocal localDCAD = null;

            try {
                UtilidadesLog.debug("*** Se realiza el create de DetalleCargosAbonosDirectos ***");
                localDCAD = homeDCAD.create(localCCAD.getOid(), // Long cabecera
                        dto.getOidCliente(), //[3] null, Long consultora
                        new Integer(numeroLinea++), //Integer numeroLinea 
                        dto.getUltimoNumeroHistoria(), //Integer numeroHistoriaGenera
                        (dto.getFechaUltimoMovimiento() != null) ? new java.sql.Date(dto.getFechaUltimoMovimiento().getTime()) : null, //Date fechaMovimiento
                        new BigDecimal ("0"),//[3}null, //BigDecimal importeMoneda
                        dto.getImporteMovimiento(),//[3] (dto.getImporte() != null) ? new BigDecimal(dto.getImporte().doubleValue()) : null, //BigDecimal importe
                        dto.getReferenciaNumeroDocumentoExterno(), //String referenciaNumeroDocumento
                        dto.getObservaciones(), //String observaciones
                        null, dto.getOidMoneda(), null, //[3]null, null, null, //String glosaContable, Long moneda, Long movimientoBancario
                        dto.getMedioPago(), //Long medioPago
                        dto.getCuentaCuota(),// [3] dto.getCuentaOrigen(), //Long cuotaAnterior
                        tmpCuotaNueva,//[3]dto.getCuentaCuota(), //Long cuotaNueva
                        dto.getOid(), // Long movimiento
                        null, //Long cuentaCorriente
                        null, //Date fechaPagoEnBancos
                        usuario, //String codigoUsuario
                        dto.getEmpresa(), //Long empresa
                        dto.getTipoAbonoSubprocesoUltimo());
                        //SCS-EEAA 06/09/2006 dto.getTipoAbonoUltimo()); //Long tipoAbonoSubproceso)
            } catch (PersistenceException e) {
                this.loguearError(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
        Iterator it = (hashMovimientos.values()).iterator();
        
        while (it.hasNext()){
            DTOMovimientoCuentaCompleto dto = (DTOMovimientoCuentaCompleto)it.next();
            dto.setOidCuotaNueva(tmpCuotaNueva);
            dto.setUsuario(usuario);
            //dto.setOidCargoAbono(oidCabecera);
            //dto.setNumeroLineaDetalleCargoAbono(numeroLinea);
        }
        
        UtilidadesLog.info("MONCuentasCorrientesBean.cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos): Salida");
    }


    /**
     * Elimina las cuentas generadas por una facturacion en proceso de reversion.
     * 
     * @author
     * @date     
     * @throws MareException
     * Notas:
     *       METODO SIN PANTALLA SE ELIMINAN TODAS LAS REFERENCIAS A BLOQUEO 
     *       INCIDENCIA 9408.
     *       @eiraola 07/12/2005, refac. segun modelo: 
     *       GCC-CCC-001_2005.11.09 GMIOTTI DT 
     */
    public void revertirCCFac(DTORevertirCCFac dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.revertirCCFac(DTORevertirCCFac dto): Entrada");
        
        String codigoProceso = "CCC001";
        String codigoSubproceso = "1";
        String ejercicioCuota = null;
        Integer numIdentCuota = null;
        String numeroIdntCuota = this.cerosIzq(dto.getNumIdentCuota(),10);
        UtilidadesLog.debug("Numero identif antes separar: "+numeroIdntCuota);

        if (numeroIdntCuota != null) {
            if (numeroIdntCuota.length() > 9) {
                //ejercicioCuota = new Long(numeroIdntCuota.substring(0, 2)).toString();
                ejercicioCuota = numeroIdntCuota.substring(0, 2);
                // incidencia: BELC300008105, convertirlo a Integer.
                numIdentCuota = new Integer(numeroIdntCuota.substring(2, 10));
            }
        }
        UtilidadesLog.debug("ejercicioCuota: "+ejercicioCuota);
        UtilidadesLog.debug("numIdentCuota: "+numIdentCuota);

        Long oid = null;
        //Date fechaContabilizacion = null; //Cambio GCC-CCC-001
        //Double importePagado = null;  //Cambio GCC-CCC-001

        DAOCCC dao = new DAOCCC();
        BigDecimal bigUltiOrdenCuota = null;
        int ultiOrdenCuota = 0;        
        RecordSet recordset = new RecordSet();
        
        //incidencia: BELC300008106, recibimos un RecordSet en lugar de DTOSalida
        recordset = dao.obtenerMovCCProcSubprocCreacion(dto.getOidPais(),
                codigoProceso, new Integer(codigoSubproceso),
                dto.getOidEmpresa(), dto.getOidSubacceso(), ejercicioCuota,
                numIdentCuota);
        UtilidadesLog.debug("Numero registros recuperados: "+recordset.getRowCount());
        UtilidadesLog.debug("(SCS) registros recuperados: "+recordset);
        
        for (int i = 0; i < recordset.getRowCount(); ++i) {
            //obtener maximo valor de NUM_ORDE_CUOT
            bigUltiOrdenCuota = (BigDecimal) recordset.getValueAt(i, "NUM_ORDE_CUOT");

            UtilidadesLog.debug("Numero orden cuota: "+bigUltiOrdenCuota);
            if (i == 0) {
                ultiOrdenCuota = bigUltiOrdenCuota.intValue();                
            }

            if (ultiOrdenCuota < bigUltiOrdenCuota.intValue()) {
                ultiOrdenCuota = bigUltiOrdenCuota.intValue();              
            }
        }		
        
        ultiOrdenCuota++;       
        
        //llenamos cuotasNegativas con las cuotas ya contabilizadas
        ArrayList cuotasNegativas = new ArrayList();

       /*
        * Cambio: GCC-CCC-001_2005.11.09 GMIOTTI DT 
        * Se modifican las validaciones para eliminar los registros.
        */
        for(int i = 0;i < recordset.getRowCount(); ++i){
        //if (longitud > 0) { // Verificamos que haya registros para procesar
            oid = new Long(((BigDecimal) recordset.getValueAt(i,"OID_MOVI_CC") ).longValue());
                    
          UtilidadesLog.debug("Oid de Movimientos de Cuenta Corriente :" + oid.toString());                    
      
            if ((recordset.getValueAt(i, "FEC_CONTA") == null) && (recordset.getValueAt(i, "VAL_NUME_LOTE_CONT") == null) &&
                ((((recordset.getValueAt(i, "VAL_ULTI_NUME_HIST")) == null)?
                new BigDecimal(0):(BigDecimal)recordset.getValueAt(i, "VAL_ULTI_NUME_HIST")).equals(new BigDecimal(0)))){
                Long oidCabeceraCargoAbono;
                
                oidCabeceraCargoAbono = dao.obtenerOidCabeceraCargoAbono(new Integer(codigoSubproceso), codigoProceso, dto.getOidPais(),oid);
                
                if (!(oidCabeceraCargoAbono == null)) {
                    CabeceraCargosAbonosDirectosLocalHome homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();
                    CabeceraCargosAbonosDirectosLocal localCCAD = null;
                
                    try {
                        localCCAD = homeCCAD.findByPrimaryKey(oidCabeceraCargoAbono);
                    } catch (NoResultException fe) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("ERROR",fe);
                        UtilidadesLog.error("No se encontraron Cabecera Cargo Abono Directo para la PK: "+ oidCabeceraCargoAbono.toString());
                        throw new MareException(fe,
                                      UtilidadesError.armarCodigoError(
                                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }
                
                    //Con los valores del registro recuperado:                  
                    if ((localCCAD.getFechaContabilizacion() != null) || (localCCAD.getNumeroLoteContabilizacion() != null)) {
                        //Preparar la nueva lista para crear cuotas negativas:
                        DTOMovimientoCuentaCompleto dtoMovimiento = new DTOMovimientoCuentaCompleto(); 
                    
                        //Le pasamos todos los datos del registro al dto
                        dtoMovimiento.setOid(oid);
                        dtoMovimiento.setEmpresa(new Long(((BigDecimal) recordset.getValueAt(i, "SOCI_OID_SOCI") ).longValue()));
                        dtoMovimiento.setMarcaSituacion(new Long(((BigDecimal) recordset.getValueAt(i,"MASI_OID_MARC_SITU")).longValue()));
                        dtoMovimiento.setDivisa((recordset.getValueAt(i,"MONE_OID_MONE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MONE_OID_MONE")).longValue()): null); //nullable
                        dtoMovimiento.setOidMoneda((recordset.getValueAt(i,"MONE_OID_MONE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MONE_OID_MONE")).longValue()): null); //nullable
                        dtoMovimiento.setPeriodoDesde(new Long(((BigDecimal) recordset.getValueAt(i,"PERD_OID_PERI")).longValue()));
                        dtoMovimiento.setTipoAbonoUltimo(new Long(((BigDecimal) recordset.getValueAt(i,"TCAB_OID_TCAB_ULTI")).longValue()));
                        dtoMovimiento.setTipoAbonoCreacion(new Long(((BigDecimal) recordset.getValueAt(i,"TCAB_OID_TCAB_CREA")).longValue()));
                        dtoMovimiento.setSubacceso(new Long(((BigDecimal) recordset.getValueAt(i,"SBAC_OID_SBAC")).longValue()));
                        dtoMovimiento.setSubprocesoUltimo(new Long(((BigDecimal) recordset.getValueAt(i,"SUBP_OID_SUBP_ULTI")).longValue()));
                        dtoMovimiento.setSubprocesoCreacion(new Long(((BigDecimal) recordset.getValueAt(i,"SUBP_OID_SUBP_CREA")).longValue()));
                        dtoMovimiento.setCuentaOrigen(new Long(((BigDecimal) recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_ORIG")).longValue()));
                        dtoMovimiento.setCuentaCuota((recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_CUOT") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_CUOT")).longValue()) : null); //nullable
                        dtoMovimiento.setOidCliente(new Long(((BigDecimal) recordset.getValueAt(i,"CLIE_OID_CLIE")).longValue()));
                        dtoMovimiento.setDocumentoAnyo(recordset.getValueAt(i,"VAL_DOCU_ANIO").toString());
                        dtoMovimiento.setDocumentoMesSerie((recordset.getValueAt(i,"VAL_DOCU_MES_SERI") != null)? ((String) recordset.getValueAt(i,"VAL_DOCU_MES_SERI")) : null); //nullable
                        dtoMovimiento.setDocumentoNumero(new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_DOCU_NUME")).intValue()));
                        dtoMovimiento.setEjercicioCuota((String) recordset.getValueAt(i,"VAL_EJER_CUOT"));
                        dtoMovimiento.setFechaContabilizacion((recordset.getValueAt(i,"FEC_CONTA") != null)? (Date) recordset.getValueAt(i, "FEC_CONTA"): null); //nullable
                        dtoMovimiento.setFechaDocumento(new Timestamp(((Date) recordset.getValueAt(i,"FEC_DOCU")).getTime()));
                        dtoMovimiento.setFechaUltimoMovimiento(new Timestamp(((Date) recordset.getValueAt(i,"FEC_ULTI_MOVI")).getTime()));
                        dtoMovimiento.setFechaValor((recordset.getValueAt(i,"FEC_VALO") != null)? new Timestamp(((Date) recordset.getValueAt(i,"FEC_VALO")).getTime()): null); //nullable
                        dtoMovimiento.setFechaVencimiento((Date) recordset.getValueAt(i,"FEC_VENC"));
                        dtoMovimiento.setImporte(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_MOVI")).doubleValue()));
                        dtoMovimiento.setImporteDivisa((recordset.getValueAt(i,"IMP_DIVI") != null)? new Double(((BigDecimal) recordset.getValueAt(i,"IMP_DIVI")).doubleValue()): null); //nullable
                        dtoMovimiento.setImportePagado(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PAGA")).doubleValue()));
                        dtoMovimiento.setImportePagadoDivisa((recordset.getValueAt(i,"IMP_PAGA_DIVI") != null)? new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PAGA_DIVI")).doubleValue()): null); //nullable
                        dtoMovimiento.setImportePendiente(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PEND")).doubleValue()));
                        dtoMovimiento.setNumeroIdentificadorCuota(new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_IDEN_CUOT")).intValue()));
                        dtoMovimiento.setNumeroLoteContabilizacion((recordset.getValueAt(i,"VAL_NUME_LOTE_CONT") != null)? (String) recordset.getValueAt(i,"VAL_NUME_LOTE_CONT"): null); //nullable
                        //dtoMovimiento.setNumeroOrdenCuota(new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_ORDE_CUOT")).intValue()));
                        dtoMovimiento.setNumeroOrdenCuota(new Integer(ultiOrdenCuota));
                        dtoMovimiento.setObservaciones((recordset.getValueAt(i,"VAL_OBSE") != null)? (String) recordset.getValueAt(i, "VAL_OBSE"): null); //nullable
                        dtoMovimiento.setReferenciaNumeroDocumentoExterno((recordset.getValueAt(i,"VAL_REFE_NUME_DOCU_EXTE") != null)? (String) recordset.getValueAt(i,"VAL_REFE_NUME_DOCU_EXTE"): null); //nullable
                        dtoMovimiento.setUltimoDocumentoAnyo((recordset.getValueAt(i,"VAL_ULTI_DOCU_ANIO") != null)? (String) recordset.getValueAt(i,"VAL_ULTI_DOCU_ANIO"): null); //nullable
                        dtoMovimiento.setUltimoDocumentoMesSerie((recordset.getValueAt(i,"VAL_ULTI_DOCU_MES_SERI") != null)? (String) recordset.getValueAt(i,"VAL_ULTI_DOCU_MES_SERI"): null); //nullable
                        dtoMovimiento.setUltimoDocumentoNumero((recordset.getValueAt(i,"VAL_ULTI_DOCU_NUME") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_ULTI_DOCU_NUME")).intValue()): null); //nullable
                        dtoMovimiento.setUltimoNumeroHistoria((recordset.getValueAt(i,"VAL_ULTI_NUME_HIST") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_ULTI_NUME_HIST")).intValue()): null); //nullable);
                        dtoMovimiento.setMedioPago((recordset.getValueAt(i,"MPAB_OID_MEDI_PAGO") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MPAB_OID_MEDI_PAGO")).longValue()): null); //nullable
                        dtoMovimiento.setTerritorioAdministrativo(new Long(((BigDecimal) recordset.getValueAt(i,"ZTAD_OID_TERR_ADMI")).longValue()));
                        dtoMovimiento.setTipoCliente(new Long(((BigDecimal) recordset.getValueAt(i,"TICL_OID_TIPO_CLIE")).longValue()));
                        dtoMovimiento.setMarca((recordset.getValueAt(i,"MARC_OID_MARC") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MARC_OID_MARC")).longValue()): null); //nullable
                        dtoMovimiento.setImportePago((recordset.getValueAt(i,"IMP_PAGO") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_PAGO"): null); //nullable
                        dtoMovimiento.setImportePagoDivisa((recordset.getValueAt(i,"IMP_PAGO_DIVI") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_PAGO_DIVI"): null); //nullable
                        dtoMovimiento.setImporteMovimiento((recordset.getValueAt(i,"IMP_MOVI_CUEN") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_MOVI_CUEN"): null);
                        dtoMovimiento.setImporteMovimientoDivisa((recordset.getValueAt(i,"IMP_MOVI_DIVI") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_MOVI_DIVI"): null); //nullable
                        dtoMovimiento.setNumeroLoteFactu((recordset.getValueAt(i,"NUM_LOTE_FACT") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_LOTE_FACT")).intValue()): null); //nullable
                        dtoMovimiento.setUsuario(ctx.getCallerPrincipal().getName());
                        dtoMovimiento.setTipoCambio((BigDecimal) recordset.getValueAt(i,"IND_TIPO_CAMB"));
                        //13561
                        /*dtoMovimiento.setDcAplicado((recordset.getValueAt(i,"IND_DTO_CARG_APLI") != null)? (String) recordset.getValueAt(i,"IND_DTO_CARG_APLI") : null); //nullable*/
                        dtoMovimiento.setIndicaDescuentoRecargo((recordset.getValueAt(i,"IND_DTO_CARG_APLI") != null)? new Boolean(((BigDecimal) recordset.getValueAt(i,"IND_DTO_CARG_APLI")).intValue() == 1 ? "true" : "false"): null); //nullable //13561
                        dtoMovimiento.setOidSeccion(new Long(((BigDecimal) recordset.getValueAt(i,"ZSCC_OID_SECC")).longValue()));
                        dtoMovimiento.setOidSugerenciaVenta(new Long(((BigDecimal) recordset.getValueAt(i,"ZSGV_OID_SUBG_VENT")).longValue()));
                        dtoMovimiento.setOidPedidoSolicitudCab((recordset.getValueAt(i,"SOCA_OID_SOLI_CABE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"SOCA_OID_SOLI_CABE")).longValue()): null); // nullable
                        dtoMovimiento.setOidSubtipoCliente(new Long(((BigDecimal) recordset.getValueAt(i,"SBTI_OID_SUBT_CLIE")).longValue()));
                        dtoMovimiento.setOidTipoSolicitud(new Long(((BigDecimal) recordset.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS")).longValue()));
                        dtoMovimiento.setTipoPeriodoDesde((recordset.getValueAt(i,"TIPE_OID_TIPO_PERI") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"TIPE_OID_TIPO_PERI")).longValue()): null); //nullable
                        dtoMovimiento.setOidRegion(new Long(((BigDecimal) recordset.getValueAt(i,"ZORG_OID_REGI")).longValue()));
                        dtoMovimiento.setOidTipoDocumentoLegal((recordset.getValueAt(i,"TIDO_OID_TIPO_DOCU") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"TIDO_OID_TIPO_DOCU")).longValue()): null); //nullable
                        dtoMovimiento.setNumeroSerieCuota(recordset.getValueAt(i,"VAL_NUME_SERI_CUOOT").toString());
                        dtoMovimiento.setOidPais(dto.getOidPais());               
                        ultiOrdenCuota++;
                        UtilidadesLog.debug("(SCS) adh. movimiento -1-: " + dtoMovimiento);
                        cuotasNegativas.add(dtoMovimiento);
                    } else {
                        DetalleCargosAbonosDirectosLocalHome homeDCAD = this.getDetalleCargosAbonosDirectosLocalHome();
                        //DetalleCargosAbonosDirectosLocal localDCAD = null;
  
                        try {
                            Collection coleDCAD = homeDCAD.findByMovCC(oid);
                            Iterator itColeDCAD = coleDCAD.iterator();
                            
                            while (itColeDCAD.hasNext()) {
                                try {
                                    homeDCAD.remove((DetalleCargosAbonosDirectosLocal)itColeDCAD.next());                                    
                                } catch (PersistenceException re) {
                                    UtilidadesLog.error(re);
                                    ctx.setRollbackOnly();
                                    throw new MareException(re,UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
                            }
                        } catch (NoResultException fe) {
                            UtilidadesLog.error(fe);
                            UtilidadesLog.error("No se encontraron Detalle Cargo Abono Directo para el oid del movimiento: "+oid);
                        }
                        //Eliminamos: MovimientosCuentasCorrientes 
                        this.eliminarMovimientosCuentasCorrientes(oid);
                    } // fin else
                } else {
                    this.eliminarMovimientosCuentasCorrientes(oid);
                }
            } else {   
                //Preparar la nueva lista para crear cuotas negativas:
                DTOMovimientoCuentaCompleto dtoMovimiento1 = new DTOMovimientoCuentaCompleto();
            
                //Le pasamos todos los datos del registro al dto
                dtoMovimiento1.setOid(oid);
                dtoMovimiento1.setEmpresa(new Long(((BigDecimal) recordset.getValueAt(i,"SOCI_OID_SOCI") ).longValue()));
                dtoMovimiento1.setMarcaSituacion(new Long(((BigDecimal) recordset.getValueAt(i,"MASI_OID_MARC_SITU")).longValue()));
                dtoMovimiento1.setDivisa((recordset.getValueAt(i,"MONE_OID_MONE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MONE_OID_MONE")).longValue()) : null); //nullable
                dtoMovimiento1.setOidMoneda((recordset.getValueAt(i,"MONE_OID_MONE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MONE_OID_MONE")).longValue()): null); //nullable
                dtoMovimiento1.setPeriodoDesde(new Long(((BigDecimal) recordset.getValueAt(i,"PERD_OID_PERI")).longValue()));
                dtoMovimiento1.setTipoAbonoUltimo(new Long(((BigDecimal) recordset.getValueAt(i,"TCAB_OID_TCAB_ULTI")).longValue()));
                dtoMovimiento1.setTipoAbonoCreacion(new Long(((BigDecimal) recordset.getValueAt(i,"TCAB_OID_TCAB_CREA")).longValue()));
                dtoMovimiento1.setSubacceso(new Long(((BigDecimal) recordset.getValueAt(i,"SBAC_OID_SBAC")).longValue()));
                dtoMovimiento1.setSubprocesoUltimo(new Long(((BigDecimal) recordset.getValueAt(i,"SUBP_OID_SUBP_ULTI")).longValue()));
                dtoMovimiento1.setSubprocesoCreacion(new Long(((BigDecimal) recordset.getValueAt(i,"SUBP_OID_SUBP_CREA")).longValue()));
                dtoMovimiento1.setCuentaOrigen(new Long(((BigDecimal) recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_ORIG")).longValue()));
                dtoMovimiento1.setCuentaCuota((recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_CUOT") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"CUCO_OID_CUEN_CONT_CUOT")).longValue()) : null); //nullable
                dtoMovimiento1.setOidCliente(new Long(((BigDecimal) recordset.getValueAt(i,"CLIE_OID_CLIE")).longValue()));
                dtoMovimiento1.setDocumentoAnyo(recordset.getValueAt(i,"VAL_DOCU_ANIO").toString());
                dtoMovimiento1.setDocumentoMesSerie((recordset.getValueAt(i,"VAL_DOCU_MES_SERI") != null)? ((String) recordset.getValueAt(i,"VAL_DOCU_MES_SERI")) : null); //nullable
                dtoMovimiento1.setDocumentoNumero(new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_DOCU_NUME")).intValue()));
                dtoMovimiento1.setEjercicioCuota((String) recordset.getValueAt(i,"VAL_EJER_CUOT"));
                //dtoMovimiento1.setFechaContabilizacion((recordset.getValueAt(i,"FEC_CONTA") != null)? (Date) recordset.getValueAt(i, "FEC_CONTA"): null); //nullable
                //@ssaavedr 08/08/2006 segun mail de kanna (Para el registro que se crea que correspondiente al registro
                // ocntabilizado, los campos VAL_NUME_LOTE_CONT y FEC_CONTA deben ir en nulos)
                dtoMovimiento1.setFechaContabilizacion(null); //nullable
                dtoMovimiento1.setFechaDocumento(new Timestamp(((Date) recordset.getValueAt(i,"FEC_DOCU")).getTime()));
                dtoMovimiento1.setFechaUltimoMovimiento(new Timestamp(((Date) recordset.getValueAt(i,"FEC_ULTI_MOVI")).getTime()));
                dtoMovimiento1.setFechaValor((recordset.getValueAt(i,"FEC_VALO") != null)? new Timestamp(((Date) recordset.getValueAt(i,"FEC_VALO")).getTime()): null); //nullable
                dtoMovimiento1.setFechaVencimiento((Date) recordset.getValueAt(i,"FEC_VENC"));
                dtoMovimiento1.setImporte(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_MOVI")).doubleValue()));
                dtoMovimiento1.setImporteDivisa((recordset.getValueAt(i,"IMP_DIVI") != null)? new Double(((BigDecimal) recordset.getValueAt(i,"IMP_DIVI")).doubleValue()): null); //nullable
                dtoMovimiento1.setImportePagado(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PAGA")).doubleValue()));
                dtoMovimiento1.setImportePagadoDivisa((recordset.getValueAt(i,"IMP_PAGA_DIVI") != null)? new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PAGA_DIVI")).doubleValue()): null); //nullable
                dtoMovimiento1.setImportePendiente(new Double(((BigDecimal) recordset.getValueAt(i,"IMP_PEND")).doubleValue()));
                dtoMovimiento1.setNumeroIdentificadorCuota(new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_IDEN_CUOT")).intValue()));
                //dtoMovimiento1.setNumeroLoteContabilizacion((recordset.getValueAt(i,"VAL_NUME_LOTE_CONT") != null)? (String) recordset.getValueAt(i,"VAL_NUME_LOTE_CONT"): null); //nullable
                //@ssaavedr 08/08/2006 segun mail de kanna (Para el registro que se crea que correspondiente al registro
                // ocntabilizado, los campos VAL_NUME_LOTE_CONT y FEC_CONTA deben ir en nulos)
                dtoMovimiento1.setNumeroLoteContabilizacion(null); //nullable
                //dtoMovimiento.setNumeroOrdenCuota(new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_ORDE_CUOT")).intValue()));
                dtoMovimiento1.setNumeroOrdenCuota(new Integer(ultiOrdenCuota));
                dtoMovimiento1.setObservaciones((recordset.getValueAt(i,"VAL_OBSE") != null)? (String) recordset.getValueAt(i, "VAL_OBSE"): null); //nullable
                dtoMovimiento1.setReferenciaNumeroDocumentoExterno((recordset.getValueAt(i,"VAL_REFE_NUME_DOCU_EXTE") != null)? (String) recordset.getValueAt(i,"VAL_REFE_NUME_DOCU_EXTE"): null); //nullable
                dtoMovimiento1.setUltimoDocumentoAnyo((recordset.getValueAt(i,"VAL_ULTI_DOCU_ANIO") != null)? (String) recordset.getValueAt(i,"VAL_ULTI_DOCU_ANIO"): null); //nullable
                dtoMovimiento1.setUltimoDocumentoMesSerie((recordset.getValueAt(i,"VAL_ULTI_DOCU_MES_SERI") != null)? (String) recordset.getValueAt(i,"VAL_ULTI_DOCU_MES_SERI"): null); //nullable
                dtoMovimiento1.setUltimoDocumentoNumero((recordset.getValueAt(i,"VAL_ULTI_DOCU_NUME") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_ULTI_DOCU_NUME")).intValue()): null); //nullable
                dtoMovimiento1.setUltimoNumeroHistoria((recordset.getValueAt(i,"VAL_ULTI_NUME_HIST") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"VAL_ULTI_NUME_HIST")).intValue()): null); //nullable);
                dtoMovimiento1.setMedioPago((recordset.getValueAt(i,"MPAB_OID_MEDI_PAGO") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MPAB_OID_MEDI_PAGO")).longValue()): null); //nullable
                dtoMovimiento1.setTerritorioAdministrativo(new Long(((BigDecimal) recordset.getValueAt(i,"ZTAD_OID_TERR_ADMI")).longValue()));
                dtoMovimiento1.setTipoCliente(new Long(((BigDecimal) recordset.getValueAt(i,"TICL_OID_TIPO_CLIE")).longValue()));
                dtoMovimiento1.setMarca((recordset.getValueAt(i,"MARC_OID_MARC") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"MARC_OID_MARC")).longValue()): null); //nullable
                dtoMovimiento1.setImportePago((recordset.getValueAt(i,"IMP_PAGO") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_PAGO"): null); //nullable
                dtoMovimiento1.setImportePagoDivisa((recordset.getValueAt(i,"IMP_PAGO_DIVI") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_PAGO_DIVI"): null); //nullable
                dtoMovimiento1.setImporteMovimiento((recordset.getValueAt(i,"IMP_MOVI_CUEN") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_MOVI_CUEN"): null);
                dtoMovimiento1.setImporteMovimientoDivisa((recordset.getValueAt(i,"IMP_MOVI_DIVI") != null)? (BigDecimal) recordset.getValueAt(i, "IMP_MOVI_DIVI"): null); //nullable
                dtoMovimiento1.setNumeroLoteFactu((recordset.getValueAt(i,"NUM_LOTE_FACT") != null)? new Integer(((BigDecimal) recordset.getValueAt(i,"NUM_LOTE_FACT")).intValue()): null); //nullable
                dtoMovimiento1.setUsuario(ctx.getCallerPrincipal().getName());
                dtoMovimiento1.setTipoCambio((BigDecimal) recordset.getValueAt(i,"IND_TIPO_CAMB"));
                dtoMovimiento1.setIndicaDescuentoRecargo((recordset.getValueAt(i,"IND_DTO_CARG_APLI") != null)? new Boolean(((BigDecimal) recordset.getValueAt(i,"IND_DTO_CARG_APLI")).intValue() == 1 ? "true" : "false"): null); //nullable //13561
                dtoMovimiento1.setOidSeccion(new Long(((BigDecimal) recordset.getValueAt(i,"ZSCC_OID_SECC")).longValue()));
                dtoMovimiento1.setOidSugerenciaVenta(new Long(((BigDecimal) recordset.getValueAt(i,"ZSGV_OID_SUBG_VENT")).longValue()));
                //dtoMovimiento1.setOidPedidoSolicitudCab((recordset.getValueAt(i,"SOCA_OID_SOLI_CABE") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"SOCA_OID_SOLI_CABE")).longValue()): null); // nullable
                dtoMovimiento1.setOidSubtipoCliente(new Long(((BigDecimal) recordset.getValueAt(i,"SBTI_OID_SUBT_CLIE")).longValue()));
                dtoMovimiento1.setOidTipoSolicitud(new Long(((BigDecimal) recordset.getValueAt(i,"TSPA_OID_TIPO_SOLI_PAIS")).longValue()));
                dtoMovimiento1.setTipoPeriodoDesde((recordset.getValueAt(i,"TIPE_OID_TIPO_PERI") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"TIPE_OID_TIPO_PERI")).longValue()): null); //nullable
                dtoMovimiento1.setOidRegion(new Long(((BigDecimal) recordset.getValueAt(i,"ZORG_OID_REGI")).longValue()));
                dtoMovimiento1.setOidTipoDocumentoLegal((recordset.getValueAt(i,"TIDO_OID_TIPO_DOCU") != null)? new Long(((BigDecimal) recordset.getValueAt(i,"TIDO_OID_TIPO_DOCU")).longValue()): null); //nullable
                dtoMovimiento1.setNumeroSerieCuota(recordset.getValueAt(i,"VAL_NUME_SERI_CUOOT").toString());
                dtoMovimiento1.setOidPais(dto.getOidPais());
                ultiOrdenCuota++;
                UtilidadesLog.debug("(SCS) adh. movimiento -2-: " + dtoMovimiento1);
                
                //@ssaavedr 07/08/06, segun mail de AG, se blanquea la FK a PED_SOLIC_CABEC, el SOCA_OID_SOLI_CABE
                this.blanquearRefSolicCabecera(oid);
                
                cuotasNegativas.add(dtoMovimiento1);
            }
        } // fin del if que verifica existencia de registros en el ResultSet
        // fin Cambio: GCC-CCC-001 (Se modifican las validaciones...)      
     
        UtilidadesLog.debug("Cuotas Negativas: "+cuotasNegativas.size());
        DTOMovimientoCuentaCompleto dtoMovArray[] = new DTOMovimientoCuentaCompleto[cuotasNegativas.size()];
        for(int i=0; i<cuotasNegativas.size(); i++){
            dtoMovArray[i] = new DTOMovimientoCuentaCompleto();
            dtoMovArray[i] = (DTOMovimientoCuentaCompleto)cuotasNegativas.get(i);
        }		
        //Si hay cuotas contabilizadas tendremos que saldarlas (crear cuota idéntica en negativo)
        if (cuotasNegativas.size() > 0) {
            UtilidadesLog.debug("Se insertan cuotas negativas");
            this.insertarCuotaNegativa(dto.getOidPais(), dtoMovArray, dto.getAppLogUser() );
        }  
        UtilidadesLog.info("MONCuentasCorrientesBean.revertirCCFac(DTORevertirCCFac dto): Salida");
    }
    
    
    private void blanquearRefSolicCabecera(Long oid) throws MareException {
        //MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
        //MovimientosCuentasCorrientesLocal localMCC = null;
        
        //try {
             //localMCC = homeMCC.findByPrimaryKey(oid);
             //localMCC.setConsolidado(null);
        //} catch (FinderException fe) {
            //UtilidadesLog.error(fe);
            //UtilidadesLog.error("No se encontraron Movimientos de Cuenta Corriente para el oid: "+oid);
        //}    
        
        StringBuffer buff = new StringBuffer();
        buff.append("UPDATE CCC_MOVIM_CUENT_CORRI SET SOCA_OID_SOLI_CABE = NULL WHERE OID_MOVI_CC = "+oid.toString());
        try{
            BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
        }catch(Exception e) {
            throw new MareException(e);
        }
    }
    
    private void eliminarMovimientosCuentasCorrientes(Long oid) throws MareException {
        //Eliminamos: MovimientosCuentasCorrientes                           
        MovimientosCuentasCorrientesLocalHome homeMCC = this.getMovimientosCuentasCorrientesLocalHome();
        MovimientosCuentasCorrientesLocal localMCC = null;
        
        try {
             localMCC = homeMCC.findByPrimaryKey(oid);
             localMCC.remove();
        } catch (FinderException fe) {
            UtilidadesLog.error(fe);
            UtilidadesLog.error("No se encontraron Movimientos de Cuenta Corriente para el oid: "+oid);
        } catch (RemoveException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }

    private DetalleCargosAbonosDirectosLocalHome getDetalleCargosAbonosDirectosLocalHome()
        throws MareException {

        UtilidadesLog.info("MONCuentasCorrientesBean.getDetalleCargosAbonosDirectosLocalHome(): Entrada");
        UtilidadesLog.info("MONCuentasCorrientesBean.getDetalleCargosAbonosDirectosLocalHome(): Salida");

        return new DetalleCargosAbonosDirectosLocalHome();
    }
	
    /**
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoBelcorp
   * Notas: este método se usa para iniciar una nueva transaccion al obtener la
   *        secuencia pais y evitar el bloqueo que se produce debido al "select for update"
   *        que realiza el método del DAO.
   */
    public Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws MareException{
      DAOCCC daoCCC = new DAOCCC();
      return daoCCC.obtenerSecuenciaPais(dtoBelcorp);
    }
  
  
    /**
     * Se recibe un array con los movimientos de la factura generada por el
     * modulo FAC. Se procesa dicho array y se seleccionan las cuotas a
     * Cancelar (negativas) y las que se van a Aplicar (positivas).
     * 
     * @author
     * @date     
     * @throws MareException
     * Notas:
     *       METODO SIN PANTALLA SE ELIMINAN TODAS LAS REFERENCIAS A BLOQUEO 
     *       INCIDENCIA 9408.
     *       @eiraola 12/12/2005, refac. segun modelo:
     *       GCC-CCC-001_2005.11.09 GMIOTTI DT 
     *       
     *       @jquiroga 14/03/2006 -> Rescritura del metodo, dado que los elementos del DTO de entrada
     *                               pertenecen al mismo pais/empresa. No hace falta agruparlos ni hacer
     *                               tantas consultas a la base de datos.
     *                               
     *       @ssaavedr 25/04/2006 -> Se agrega el paso del tipo de deuda (Positiva o Negativa) en el llamado 
     *                               a cancelacionAutomaticaDeuda, en virtud del cambio P2, de E.Arese 
     *                               (Cancelación automática de deuda positiva y negativa.doc)                         
     *                               
     *       @pperanzola 22/05/2006 - [1] se modifica según incidencia DBLG500000714                         
     */       
    public void generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto) throws MareException {
        //Entrada: DTOMovimientoCuentaCompleto[] dtos; //Array de movimientos que conforman una factura 
        UtilidadesLog.info("MONCuentasCorrientesBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto): Entrada");
        Cronometrador.startTransaction("MONCuentasCorrientesBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto)");
        try {
        int largoArray = dto.length; 
        ArrayList cuotasCancelar = new ArrayList(); //(Cancelación automática de la deuda), Guardaremos aquí las cuotas cuyo importe sea negativo para cancelarlas 
        ArrayList cuotasAplicar = new ArrayList();  //(Aplicación automática de la deuda positiva desde facturación) Guardaremos aquí las cuotas cuyo importe sea negativo para aplicarlas      
        DAOCCC daoCCC = new DAOCCC();
        RecordSet rs1=null;
        BigDecimal tipoAbonoBig=null;
        Long tipoAbono=null;
        BigDecimal marcaSituacionBig=null;
        Long marcaSituacion=null;
        Long cuentaContable=null;
        DTOSalida dtoSalida=null;
        String anioSistema=null;
        String mesSistema=null;        
        BigDecimal importePago=new BigDecimal(0);
        Integer ultimoNumeroHistoria=new Integer(0);
        String identificador=null;
        Long subprocesoCreacion=null;
        String ejerCuota=null;
        String identEjerCuota=null;
        
        if (largoArray>0) {
            rs1 = daoCCC.obtenerMarcasTipoAbonoSalida("CCC001", new Integer(1), dto[0].getOidPais());
            tipoAbonoBig = (BigDecimal) rs1.getValueAt(0,"TASP_OID_TIPO_ABON_SUBP");
            if (tipoAbonoBig!=null) {
                tipoAbono = new Long(tipoAbonoBig.longValue());
            }
            
            marcaSituacionBig = (BigDecimal) rs1.getValueAt(0,"OID_MARC_SITU");
            if (marcaSituacionBig!=null) {
                marcaSituacion = new Long(marcaSituacionBig.longValue());
            }
            
            dtoSalida = daoCCC.obtenerTiposAbonoSubprocesoCContable(dto[0].getOidPais(),"CCC001", new Integer(1));
            cuentaContable = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0,"CUCO_OID_CUEN_CONT")).longValue());
            
            subprocesoCreacion=daoCCC.obtenerOIDSubproceso(dto[0].getOidPais(), "CCC001", new Integer(1));
            
            try {
                java.util.Date fechaSistema_java = new Date(System.currentTimeMillis());
                anioSistema = UtilidadesFecha.convertirAString(fechaSistema_java, "yy");
                mesSistema = UtilidadesFecha.convertirAString(fechaSistema_java, "MM");
            } 
            catch (ParseException pe) {
                throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            
            /* 
             * Número identificador cuota (se reciben 10 posiciones, que en la actividad 3 de este caso de uso desglosará 
             * en dos campos: el ejercicio de la cuota (2 primeras posiciones) y el número identificador cuota (8 posiciones restantes).
            */            
            identificador = dto[0].getNumeroIdentificadorCuota().toString();            
            identificador = this.cerosIzq(identificador, 10);
            ejerCuota = identificador.substring(0,2);
            identEjerCuota = identificador.substring(2,10);
            UtilidadesLog.debug("identificador = "+ identificador + "ejerCuota = "+ ejerCuota + "identEjerCuota = " + identEjerCuota);  
        }
        for (int i = 0; i < largoArray; i++) {   
            dto[i].setEjercicioCuota(ejerCuota);            
            dto[i].setNumeroIdentificadorCuota(new Integer(identEjerCuota));      
            dto[i].setDocumentoAnyo(null);
            dto[i].setDocumentoMesSerie(null);
            dto[i].setDocumentoNumero(null);    
            dto[i].setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
            dto[i].setTipoAbonoCreacion(tipoAbono);
            dto[i].setMarcaSituacion(marcaSituacion);
            dto[i].setUltimoDocumentoNumero(dto[i].getDocumentoNumero());
            dto[i].setSubprocesoCreacion(subprocesoCreacion);
            dto[i].setSubprocesoUltimo(dto[i].getSubprocesoCreacion());
            dto[i].setTipoAbonoUltimo(dto[i].getTipoAbonoCreacion());
            dto[i].setUltimoNumeroHistoria(ultimoNumeroHistoria);
            dto[i].setCuentaOrigen(cuentaContable);
            dto[i].setCuentaCuota(dto[i].getCuentaOrigen());
            dto[i].setImportePago(importePago);
            dto[i].setImporteMovimiento(new BigDecimal(dto[i].getImporte().doubleValue())); 
            dto[i].setImporteDivisa(new Double(0));
            dto[i].setImporteMovimientoDivisa(new BigDecimal(dto[i].getImporteDivisa().doubleValue()));
            dto[i].setDocumentoMesSerie(mesSistema);
            dto[i].setDocumentoAnyo(anioSistema);
            dto[i].setUltimoDocumentoMesSerie( dto[i].getDocumentoMesSerie() );
            dto[i].setUltimoDocumentoAnyo( dto[i].getEjercicioCuota() );
             
            //Cuotas a cancelar 
            if (dto[i].getImporte().doubleValue() < new Double(0).doubleValue()) {
                cuotasCancelar.add(dto[i]);
            } else {
                cuotasAplicar.add(dto[i]);
            }      
        }        
        
        Integer numero;
        String anio;
        String periodoMes;
        java.util.Date fechaSistema;
        Date fechaDocumento;
        Date fechaValor;
        Long oidProceso;
        ProcesosLocalHome homeP;
        ProcesosLocal localP=null;        
        DTOBelcorp dtoBelcorp=null;
        MONCuentasCorrientesLocal moncccLocal = null;
        int numeroLinea=1;//[1] int numeroLinea=0;

        /* Variables para el create CabeceraCargosAbonosDirectos */
        CabeceraCargosAbonosDirectosLocalHome homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();
        CabeceraCargosAbonosDirectosLocal localCCAD = null;  
        /* Variables para el create DetalleCargosAbonosDirectos */        
        
        if (largoArray>0) {
            dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(dto[0].getOidPais());
            if ( dto[0].getOidIdioma() != null ) {
                dtoBelcorp.setOidIdioma(dto[0].getOidIdioma());    
            } else {
                dtoBelcorp.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
            }
            
            moncccLocal = getMONCuentasCorrientesLocal();
            numero = moncccLocal.obtenerSecuenciaPais(dtoBelcorp);
            
            anio = null;
            periodoMes = null;
            fechaSistema = new java.util.Date(System.currentTimeMillis());
            fechaDocumento = new Date(System.currentTimeMillis());
            fechaValor = fechaDocumento;
            try {
                anio = UtilidadesFecha.convertirAString(fechaSistema, "yy");
                periodoMes = UtilidadesFecha.convertirAString(fechaSistema, "MM");
            } catch (ParseException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            
            homeP = this.getProcesosLocalHome();
            try {
                localP = homeP.findByUk(dto[0].getOidPais(), "CCC001");
                oidProceso = localP.getOid();
            } catch (NoResultException fe) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("Metodo generarCuentaCorriente: error -----> finderException ProcesosHome.findByUk(pais, proceso): " + dto[0].getOidPais() + " CCC001");
                UtilidadesLog.debug("Metodo generarCuentaCorriente: error -----> finderException ProcesosLocal.getOid() contiene: " + localP.getOid());
                this.loguearError(fe);
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }
            
            /*
             * Se realiza un create sobre la Entidad CCC:CabeceraCargosAbonosDirectos. 
            */     
            try {
                UtilidadesLog.info("*** Se realiza el create en CabeceraCargosAbonosDirectos ***");
                localCCAD = homeCCAD.create(numero, //Integer
                                            anio, //String
                                            periodoMes, //String
                                            fechaDocumento, //Date
                                            dto[0].getOidPais(), //Long
                                            dto[0].getEmpresa(), //Long
                                            dto[0].getUsuario(), //String
                                            fechaValor, //Date
                                            oidProceso); //Long
            } catch (PersistenceException e) {
                this.loguearError(e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }     
        }       
       
        ArrayList movimientosCuentasCorrientes = new ArrayList();
        ArrayList detallesCargosAbonosDirectos = new ArrayList();
        Long oidmovimientoCuenta, oidCabeceraCargoAbono, numeroLineaDetalle;
       
        for (int i = 0; i < largoArray; i++) {
            /* Una vez creada la CabeceraCargosAbonosDirectos
               - Se asigna el nuevo Oid de Cabecera a los Dtos */
            dto[i].setOid(localCCAD.getOid());
            /* - Se asigna el numero de Documento de la Cabecera a los Dtos del  agrupamiento */
            dto[i].setDocumentoNumero(localCCAD.getNumero());
            /* - Se asigna el numero de Ultimo Documento a los Dtos del agrupamiento */
            dto[i].setUltimoDocumentoNumero(dto[i].getDocumentoNumero());            
                    
            /* 
             * Llamamos al método create de la entidad MovimientosCuentasCorrientes 
             * e insertamos un registro con los datos que tenemos en el DTOMovimientoCuentaCompleto (dtos[i]) .
             * Ahora se agrega a un arreglo para insertarlo de forma masiva. */
            oidmovimientoCuenta = this.agregarMovimientosCuentasCorrientes(dto[i], movimientosCuentasCorrientes);

            // A cada dtos[i].oid le asignamos el oid de su MovimientosCuentasCorrientes creado
            dto[i].setOid(oidmovimientoCuenta);

            /*
             * Se realiza un create sobre la Entidad CCC:DetalleCargosAbonosDirectos.
             * Ahora se agrega a un arreglo para insertarlo de forma masiva.
             */
            oidCabeceraCargoAbono = localCCAD.getOid();
            numeroLineaDetalle = new Long(++numeroLinea);
            this.agregarDetalleCargosAbonosDirectos(dto[i], detallesCargosAbonosDirectos, oidCabeceraCargoAbono, numeroLineaDetalle);
        } //for              

        // insertamos los movimientos cuentas corrientes
        this.grabarMovimientosCuentasCorrientes(movimientosCuentasCorrientes);

        // insertamos los detalles cargos abonos directos
        this.grabarDetallesCargosAbonosDirectos(detallesCargosAbonosDirectos);
        
        DTOMovimientoCuentaCompleto dtoMovArray[] = new DTOMovimientoCuentaCompleto[cuotasCancelar.size()]; 
        for(int i=0; i<cuotasCancelar.size(); i++){
          dtoMovArray[i] = new DTOMovimientoCuentaCompleto();
          dtoMovArray[i] = (DTOMovimientoCuentaCompleto)cuotasCancelar.get(i);
        }
        //Extraemos del ArrayList un Array de Objetos y los modelamos (casting) al tipo //necesario. 
        //De esta manera no tendremos que comprobar los tipos de datos que llegan al //método invocado 
        if (cuotasCancelar.size() > 0) {
            UtilidadesLog.debug("**** Hay que cancelar "+cuotasCancelar.size()+" cuotas");
            //ssaavedr 24/04/2006, cbios.P2 E.Arese
            this.cancelacionAutomaticaDeuda(dtoMovArray, "N");      
        }
        
        // Agregado GCC-CCC-001 
        int cantCuotasAplicar = cuotasAplicar.size();
        DTOMovimientoCuentaCompleto [] dtoMovParaAplicar = new DTOMovimientoCuentaCompleto[cantCuotasAplicar];
        
        if (cantCuotasAplicar > 0) {
            UtilidadesLog.debug("Hay que aplicar "+ cantCuotasAplicar +" cuotas");
            for(int i = 0; i < cantCuotasAplicar; i++) { // Pasamos de ArrayList a array
                dtoMovParaAplicar[i] = new DTOMovimientoCuentaCompleto();
                dtoMovParaAplicar[i] = (DTOMovimientoCuentaCompleto) cuotasAplicar.get(i);
            }
            //ssaavedr 24/04/2006, cbios.P2 E.Arese
            this.cancelacionAutomaticaDeuda(dtoMovParaAplicar, "P");
            
            UtilidadesLog.debug("voy a aplicacionAutomaticaDeudaPositivaFacturacion, con el dto, que mide: " + dtoMovParaAplicar.length);
            this.aplicacionAutomaticaDeudaPositivaFacturacion(dtoMovParaAplicar);
            

            //recorro e imprimo cada linea del dto
            for (int tito=0; tito<dtoMovParaAplicar.length; tito++){
                DTOMovimientoCuentaCompleto registro = dtoMovParaAplicar[tito];
                UtilidadesLog.warn("linea: " + tito + " del dto a la salida de aplicacionAutomaticaDeudaPositivaFacturacion, es: " + registro);
            }            
        }
		
        UtilidadesLog.info("MONCuentasCorrientesBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto): Salida");
     }
     catch(Exception ex){
        UtilidadesLog.error("Error en MONCuentasCorrientesBean.generarCuentaCorriente");
        ex.printStackTrace();
        if(ex instanceof MareException){
          throw (MareException) ex;
        }
        else{
            throw new MareException(ex);
        }
     }
    
        Cronometrador.endTransaction("MONCuentasCorrientesBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto)");
    }     


    /**
     * Retorna el oidmovimientoCuenta creado.
     * Agrega el movimiento cuenta corriente a movimientosCuentasCorrientes para realizar un insert masivo.
     * @autor gdmarzi
     */
    private Long agregarMovimientosCuentasCorrientes(DTOMovimientoCuentaCompleto movimientoCuenta, ArrayList movimientosCuentasCorrientes) throws MareException {
        // Asignar el nuevo oid
        Long oidmovimientoCuenta = new Long(SecuenciadorOID.obtenerSiguienteValor("CCC_MVCC_SEQ").longValue());
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();

        query.append(" INSERT INTO CCC_MOVIM_CUENT_CORRI (");
        // campos obligatorios
        query.append(" oid_movi_cc, ");
        values.append(oidmovimientoCuenta).append(",");
        query.append(" soci_oid_soci, ");
        values.append(movimientoCuenta.getEmpresa()).append(",");
        query.append(" masi_oid_marc_situ, ");
        values.append(movimientoCuenta.getMarcaSituacion()).append(",");
		query.append(" perd_oid_peri, ");
        values.append(movimientoCuenta.getPeriodoDesde()).append(",");
		query.append(" tcab_oid_tcab_ulti, ");
        values.append(movimientoCuenta.getTipoAbonoUltimo()).append(",");
        query.append(" tcab_oid_tcab_crea, ");
        values.append(movimientoCuenta.getTipoAbonoCreacion()).append(",");
        query.append(" sbac_oid_sbac, ");
        values.append(movimientoCuenta.getSubacceso()).append(",");
        query.append(" subp_oid_subp_ulti, ");
        values.append(movimientoCuenta.getSubprocesoUltimo()).append(",");
        query.append(" subp_oid_subp_crea, ");
        values.append(movimientoCuenta.getSubprocesoCreacion()).append(",");
        query.append(" cuco_oid_cuen_cont_orig, ");
        values.append(movimientoCuenta.getCuentaOrigen()).append(",");
        query.append(" clie_oid_clie, ");
        values.append(movimientoCuenta.getOidCliente()).append(",");
        query.append(" val_docu_anio, ");
        values.append("'").append(movimientoCuenta.getDocumentoAnyo()).append("'").append(",");
        query.append(" val_docu_nume, ");
        values.append("'").append(movimientoCuenta.getDocumentoNumero()).append("'").append(",");
        query.append(" val_ejer_cuot, ");
        values.append("'").append(movimientoCuenta.getEjercicioCuota()).append("'").append(",");
        query.append(" fec_docu, ");
        values.append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaDocumento().getTime()) + "', 'YYYY-MM-DD'), ");           
        query.append(" fec_ulti_movi, ");
        values.append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaUltimoMovimiento().getTime()) + "', 'YYYY-MM-DD'), ");           
        query.append(" fec_venc, ");
        values.append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaVencimiento().getTime()) + "', 'YYYY-MM-DD'), ");           
        query.append(" imp_movi, ");
        values.append(movimientoCuenta.getImporte()).append(",");
        query.append(" imp_paga, ");
        values.append(movimientoCuenta.getImportePagado()).append(",");
        query.append(" imp_pend, ");
        values.append(movimientoCuenta.getImportePendiente()).append(",");
        query.append(" num_iden_cuot, ");
        values.append(movimientoCuenta.getNumeroIdentificadorCuota()).append(",");
        query.append(" num_orde_cuot, ");
        values.append(movimientoCuenta.getNumeroOrdenCuota()).append(",");
        query.append(" ztad_oid_terr_admi, ");
        values.append(movimientoCuenta.getTerritorioAdministrativo()).append(",");
        query.append(" ticl_oid_tipo_clie, ");
        values.append(movimientoCuenta.getTipoCliente()).append(",");
        query.append(" ind_tipo_camb, ");
        values.append(movimientoCuenta.getTipoCambio()).append(",");
        query.append(" cod_usua, ");
        values.append("'").append(movimientoCuenta.getUsuario()).append("'").append(",");
        query.append(" sbti_oid_subt_clie, ");
        values.append(movimientoCuenta.getOidSubtipoCliente()).append(",");
        query.append(" zsgv_oid_subg_vent, ");
        values.append(movimientoCuenta.getOidSugerenciaVenta()).append(",");
        query.append(" zscc_oid_secc, ");
        values.append(movimientoCuenta.getOidSeccion()).append(",");
        query.append(" zorg_oid_regi, ");
        values.append(movimientoCuenta.getOidRegion()).append(",");
        query.append(" imp_movi_cuen ");
        values.append(movimientoCuenta.getImporteMovimiento());
        // campos No Obligatorios        
        if (movimientoCuenta.getDivisa() != null) {
            query.append(", mone_oid_mone");
            values.append(", ").append(movimientoCuenta.getDivisa());
        }
		if (movimientoCuenta.getCuentaCuota() != null) {
            query.append(", cuco_oid_cuen_cont_cuot");
            values.append(", ").append(movimientoCuenta.getCuentaCuota());
		}
		if (movimientoCuenta.getDocumentoMesSerie() != null) {
            query.append(", val_docu_mes_seri");
            values.append(", ").append("'").append(movimientoCuenta.getDocumentoMesSerie()).append("'");
		}
		if (movimientoCuenta.getFechaContabilizacion() != null) {
            query.append(", fec_conta");
            values.append(", ").append(" to_date( '" + movimientoCuenta.getFechaContabilizacion() + "', 'YYYY-MM-DD') ");           
        }
		if (movimientoCuenta.getFechaValor() != null) {
            query.append(", fec_valo");
            values.append(", ").append(" to_date( '" + movimientoCuenta.getFechaValor() + "', 'YYYY-MM-DD') ");           
        }
		if (movimientoCuenta.getImporteDivisa() != null) {
            query.append(", imp_divi");
            values.append(", ").append(movimientoCuenta.getImporteDivisa());
		}
		if (movimientoCuenta.getImportePagadoDivisa() != null) {
            query.append(", imp_paga_divi");
            values.append(", ").append(movimientoCuenta.getImportePagadoDivisa());
		}
		if (movimientoCuenta.getIndicaDescuentoRecargo() != null) {
            query.append(", ind_dto_carg_apli");
            if (movimientoCuenta.getIndicaDescuentoRecargo().booleanValue() ) {
                values.append(",").append("1");
            } else {
                values.append(",").append("0");
            }
		}
		if (movimientoCuenta.getNumeroLoteContabilizacion() != null) {
            query.append(", val_nume_lote_cont");
            values.append(", ").append("'").append(movimientoCuenta.getNumeroLoteContabilizacion()).append("'");
		}
		if (movimientoCuenta.getObservaciones() != null) {
            query.append(", val_obse");
            values.append(", ").append("'").append(movimientoCuenta.getObservaciones()).append("'");
		}
		if (movimientoCuenta.getReferenciaNumeroDocumentoExterno() != null) {
            query.append(", val_refe_nume_docu_exte");
            values.append(", ").append("'").append(movimientoCuenta.getReferenciaNumeroDocumentoExterno()).append("'");
		}
		if (movimientoCuenta.getUltimoDocumentoAnyo() != null) {
            query.append(", val_ulti_docu_anio");
            values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoAnyo()).append("'");
		}
		if (movimientoCuenta.getUltimoDocumentoMesSerie() != null) {
            query.append(", val_ulti_docu_mes_seri");
            values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoMesSerie()).append("'");
		}
		if (movimientoCuenta.getUltimoDocumentoNumero() != null) {
            query.append(", val_ulti_docu_nume");
            values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoNumero()).append("'");
		}
		if (movimientoCuenta.getUltimoNumeroHistoria() != null) {
            query.append(", val_ulti_nume_hist");
            values.append(", ").append("'").append(movimientoCuenta.getUltimoNumeroHistoria()).append("'");
		}
		if (movimientoCuenta.getMedioPago() != null) {
            query.append(", mpab_oid_medi_pago");
            values.append(", ").append(movimientoCuenta.getMedioPago());
		}
		if (movimientoCuenta.getMarca() != null) {
            query.append(", marc_oid_marc");
            values.append(", ").append(movimientoCuenta.getMarca());
		}
		if (movimientoCuenta.getNumeroLoteFactu() != null) {
            query.append(", num_lote_fact");
            values.append(", ").append(movimientoCuenta.getNumeroLoteFactu());
		}
		if (movimientoCuenta.getImportePago() != null) {
            query.append(", imp_pago");
            values.append(", ").append(movimientoCuenta.getImportePago());
		}
		if (movimientoCuenta.getImportePagoDivisa() != null) {
            query.append(", imp_pago_divi");
            values.append(", ").append(movimientoCuenta.getImportePagoDivisa());
		} else {
            query.append(", imp_pago_divi");
            values.append(", ").append(new Double(0));
        }
		if (movimientoCuenta.getImporteMovimientoDivisa() != null) {
            query.append(", imp_movi_divi");
            values.append(", ").append(movimientoCuenta.getImporteMovimientoDivisa());
		}
		if (movimientoCuenta.getTipoPeriodoDesde() != null) {
            query.append(", tipe_oid_tipo_peri");
            values.append(", ").append(movimientoCuenta.getTipoPeriodoDesde());
		}
		if (movimientoCuenta.getOidTipoDocumentoLegal() != null) {
            query.append(", tido_oid_tipo_docu");
            values.append(", ").append(movimientoCuenta.getOidTipoDocumentoLegal());
		}
		if (movimientoCuenta.getOidTipoSolicitud() != null) {
            query.append(", tspa_oid_tipo_soli_pais");
            values.append(", ").append(movimientoCuenta.getOidTipoSolicitud());
		}
		if (movimientoCuenta.getOidPedidoSolicitudCab() != null) {
            query.append(", soca_oid_soli_cabe");
            values.append(", ").append(movimientoCuenta.getOidPedidoSolicitudCab());
		}
        query.append(") VALUES (");
        query.append(values);
        query.append(")");
        // agregamos el movimiento cuenta corriente
        movimientosCuentasCorrientes.add(query);
        // retornamos el oidmovimientoCuenta creado
        return oidmovimientoCuenta;        
    }


    /**
     * Agrega el detalle Cargos Abonos Directos a detalleCargosAbonosDirectos para realizar un insert masivo.
     * @autor gdmarzi
     */
    private void agregarDetalleCargosAbonosDirectos(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto, ArrayList detalleCargosAbonosDirectos,
                                                    Long cabeceraCargoAbono, Long numeroLineaDetalle) throws MareException {
        // Asignar el nuevo oid
        Long oidDetalleCargoAbonoDirecto = new Long(SecuenciadorOID.obtenerSiguienteValor("CCC_DCAD_SEQ").longValue());
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();

        query.append(" INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
        // campos obligatorios
        query.append(" OID_DETA_CARG_ABON_DIRE, ");
        values.append(oidDetalleCargoAbonoDirecto).append(",");
        query.append(" CCAD_OID_CABE_CARG, ");
        values.append(cabeceraCargoAbono).append(",");
        query.append(" NUM_LINE, ");
        values.append(numeroLineaDetalle).append(",");
        query.append(" COD_USUA, ");
        values.append("'").append(detalleCargoAbonoDirecto.getUsuario()).append("'").append(", ");
        query.append(" SOCI_OID_SOCI, ");
        values.append(detalleCargoAbonoDirecto.getEmpresa()).append(",");
        query.append(" TASP_OID_TIPO_ABON_SUBP ");
        values.append(detalleCargoAbonoDirecto.getTipoAbonoCreacion());
        //campos no obligatorios
        if (detalleCargoAbonoDirecto.getOidCliente() != null) {
            query.append(", CLIE_OID_CLIE ");   // consultora
            values.append(", ").append(detalleCargoAbonoDirecto.getOidCliente());
        }
        query.append(", NUM_HIST_GENE ");
        values.append(", ").append(new Integer(0));
        query.append(", FEC_MOVI");
        values.append(", ").append(" to_date( '" + new Date(System.currentTimeMillis()) + "', 'YYYY-MM-DD') ");           
        if (detalleCargoAbonoDirecto.getImporteDivisa() != null) {
            query.append(", IMP_MONE ");   // importeDivisa eq importeMoneda
            values.append(", ").append(detalleCargoAbonoDirecto.getImporteDivisa());
        }
        if (detalleCargoAbonoDirecto.getImporte() != null) {
            query.append(", IMP ");
            values.append(", ").append(detalleCargoAbonoDirecto.getImporte());
        }
        query.append(", VAL_REFE ");    // referenciaNumeroDocumento
        values.append(", ").append("null");
        query.append(", VAL_OBSE ");    // observaciones
        values.append(", ").append("null");
        query.append(", VAL_GLOS_CONT ");    // glosaContable
        values.append(", ").append("null");
        if (detalleCargoAbonoDirecto.getOidMoneda() != null) {
            query.append(", MONE_OID_MONE ");
            values.append(", ").append(detalleCargoAbonoDirecto.getOidMoneda());
        }
        query.append(", CMBA_OID_MOVI_BANC ");    // movimientoBancario
        values.append(", ").append("null");
        if (detalleCargoAbonoDirecto.getMedioPago() != null) {
            query.append(", MPAB_OID_MEDI_PAGO ");
            values.append(", ").append(detalleCargoAbonoDirecto.getMedioPago());
        }
        if (detalleCargoAbonoDirecto.getCuentaOrigen() != null) {
            query.append(", CUCO_OID_CUEN_CONT_CUOT_ANTE ");    // cuentaAnterior
            values.append(", ").append(detalleCargoAbonoDirecto.getCuentaOrigen());
        }
        if (detalleCargoAbonoDirecto.getCuentaOrigen() != null) {
            query.append(", CUCO_OID_CUEN_CONT_CUOT_NUEV ");    // cuentaNueva
            values.append(", ").append(detalleCargoAbonoDirecto.getCuentaOrigen());
        }
        if (detalleCargoAbonoDirecto.getOid() != null) {
            query.append(", MVCC_OID_MOVI_CC ");    // movimientoCuenta
            values.append(", ").append(detalleCargoAbonoDirecto.getOid());
        }
        query.append(", CCBA_OID_CUEN_CORR_BANC ");    // cuentaCorriente
        values.append(", ").append("null");
        query.append(", FEC_PAGO_BANC ");    // fechaPagoEnBancos
        values.append(", ").append("null");
        query.append(") VALUES (");
        query.append(values);
        query.append(")");
        // agregamos el detalle cargo abono directo
        detalleCargosAbonosDirectos.add(query);
    }


    /**
     * Graba varios movimientos cuentas corrientes de forma masiva.
     * @autor gdmarzi
     */
    private void grabarMovimientosCuentasCorrientes(ArrayList movimientosCuentasCorrientes) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientes.grabarMovimientosCuentasCorrientes() - entrada");        
        BelcorpService bs;
        StringBuffer movimiento; 
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        // -> Armamos querys de insert
        Iterator iter = movimientosCuentasCorrientes.iterator();
        while(iter.hasNext()) {
            movimiento = (StringBuffer)iter.next();
            variasQuerys.append(movimiento);
            variasQuerys.append(";");
        }
        // -> Ejecutamos multiples inserts          
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en grabarMovimientosCuentasCorrientes al crear varios movimientos cta cte",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCuentasCorrientes.grabarMovimientosCuentasCorrientes()- salida");        
    }


    /**
     * Graba varios detalles cargos abonos directos de forma masiva.
     * @autor gdmarzi
     */
    private void grabarDetallesCargosAbonosDirectos(ArrayList detallesCargosAbonosDirectos) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientes.grabarDetallesCargosAbonosDirectos() - entrada");        
        BelcorpService bs;
        StringBuffer detalle; 
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        // -> Armamos querys de insert
        Iterator iter = detallesCargosAbonosDirectos.iterator();
        while(iter.hasNext()) {
            detalle = (StringBuffer)iter.next();
            variasQuerys.append(detalle);
            variasQuerys.append(";");
        }
        // -> Ejecutamos multiples inserts          
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en grabarDetallesCargosAbonosDirectos al crear detalles cargos abonos directos",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCuentasCorrientes.grabarDetallesCargosAbonosDirectos()- salida");        
    }


    // Validaciones
    private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio, String user) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

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
                    territorio, user);
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

        UtilidadesLog.info("MONCuentasCorrientesBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }

    /*************************************************************************
     *
     *              MÉTODOS DE CDOS
     *
     * ************************************************************************/
    public DTOSalida buscarLotesTrabajo(DTOBuscarLotesTrabajo dto)
        throws MareException {
        /* Delegamos el DAOCuentasCorrientes.bucarLotesMovimientosBancarios */
        UtilidadesLog.info("MONCuentasCorrientesBean.buscarLotesTrabajo(DTOBuscarLotesTrabajo dto): Entrada");
        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());
        UtilidadesLog.info("MONCuentasCorrientesBean.buscarLotesTrabajo(DTOBuscarLotesTrabajo dto): Salida");
        return daoCtaCte.buscarLotesMovimientosBancarios(dto);
    }

    public DTOSalida obtieneBancos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneBancos(DTOBelcorp dto): Entrada");
        DAOCCC daoCCC = new DAOCCC();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(daoCCC.obtieneBancos(dto));
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneBancos(DTOBelcorp dto): Salida");
        return dtoSalida;
    }

    public DTOSalida obtieneCCPorBanco(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneCCPorBanco(DTOOID dto): Entrada");
        DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                                .getName());
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(daoCuentasCorrientes.obtenerCuentasCorrientesBanco(
                dto));
        UtilidadesLog.info("MONCuentasCorrientesBean.obtieneCCPorBanco(DTOOID dto): Salida");
        return dtoSalida;
    }

  /*
   * Autor: Paola Cabrera
   * Fecha:  
   * Descripcion: Metodo que inserta en la entidad MovimientosBancarios
   * * 
   */

   public DTOOID insertarMovimientoBancario(DTOMovimientoBancario dto)
        throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesBean.insertarMovimientoBancario(DTOMovimientoBancario dto): Entrada");
        UtilidadesLog.debug("contenido del DTO>>>> " + dto);

        MovimientosBancariosLocal movBancL = null;

        try {
            MONClientes monCliente = MAEEjbLocators.getMONClientesHome().create();
            Long oidCliente = monCliente.obtenerOidCliente(dto.getOidPais(),
                    dto.getCodConsultoraReal());
            UtilidadesLog.debug("Este es el oid del cliente: " + oidCliente);

            if (oidCliente == null) {
                throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE,
                        "",
                        es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0027));
            }

            UtilidadesLog.debug("No entro a la excepcion");
            dto.setOidConsultoraReal(oidCliente);

            MovimientosBancariosLocalHome movBancLH = (MovimientosBancariosLocalHome) this.getEntitiHome(
                    "MovimientosBancarios");
            UtilidadesLog.debug("esta es dto contra el que se va a comparar: " + dto);

            UtilidadesLog.debug("dto.getCuentaCorrienteBancaria()>>>>" +  dto.getCuentaCorrienteBancaria());
            UtilidadesLog.debug("dto.getFechaPago()>>>> " + dto.getFechaPago());
            UtilidadesLog.debug("dto.getImportePago().doubleValue()>>>> " + dto.getImportePago().doubleValue());
            UtilidadesLog.debug("dto.getOidConsultoraReal()>>>> " + dto.getOidConsultoraReal());

			Collection movBancarios = null;	

			try{
				  movBancarios = movBancLH.findByParametros(dto.getCuentaCorrienteBancaria(),
				  (java.sql.Date)dto.getFechaPago(), dto.getImportePago(), dto.getOidConsultoraReal());
				  UtilidadesLog.debug("movBancarios: " + movBancarios);

			}catch(FinderException e){
				;
			} 
            if (!dto.getIndConfirmaMovimientoManual().booleanValue()){
                if ((movBancarios != null) && (movBancarios.size() != 0)) {
                    UtilidadesLog.debug("Los Movimientos Bancarios NO son null.. ");
                    throw new MareException(null, null,
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,
                              "", ErroresDeNegocio.CCC_0037));
                }
            }
            UtilidadesLog.debug("dto.getIpCliente() " + dto.getIpCliente());

            /*
			 * * Ha sido eliminado esto segun la incidencia 8853			
             *   accesoLocal  = accesoLocalh.findByClaveUnica(dto.getIpCliente());
             *   String subacceso = accesoLocal.getSubAcceso().toString();
             */
			 
			DAOCCC daoCCC = new DAOCCC();
            /*@ssaavedr se modifica segun inc.: BELC300022992
            Long subproceso = daoCCC.obtieneSubproceso(CCCConstantes.PROCESO_MOVIMIENTO_MANUAL,
                    "1", dto.getOidPais());
            */        
            //@ssaavedr, se agrega segun inc.: BELC300022992
            Long subproceso = daoCCC.obtieneSubproceso(CCCConstantes.RECAUDO_MANUAL_NO_APLICADO,
                    "2", dto.getOidPais());
				
            UtilidadesLog.debug("Se obtubieron los subprocesos.: " + subproceso);

			Long lTipoAbono = null;

			TiposAbonoSubprocesoLocalHome tipoAbonoLH = this.getTiposAbonoSubprocesoLocalHome();
					
            Collection tipoAbono = tipoAbonoLH.findBySubproceso(subproceso);
            UtilidadesLog.debug("se obtubieron los tipo abono...");

            if ((tipoAbono.size() == 0) || (tipoAbono.size() > 1)) {
                UtilidadesLog.debug("El tipo abono es null o el size es > 1");
                throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,
                        "", ErroresDeNegocio.CCC_0026));
            } else {
						UtilidadesLog.debug("El tipo abono es ....");
						// MODIFICACION -------------------------------
						// Autor: Maximiliano Dello Russo (grusso).
						// Motivo: Inc 11408.  Estaba equivocado el origen del dato para 
						// lTipoAbono.  Se cambia el getOid por getTipoAbono.
						//
						// lTipoAbono = ((TiposAbonoSubprocesoLocal) tipoAbono.iterator().next()).getOid();
						TiposAbonoSubprocesoLocal aux = (TiposAbonoSubprocesoLocal)tipoAbono.iterator().next();
						lTipoAbono =  aux.getTipoAbono();
						// FIN MODIFICACION ---------------------------
						
						UtilidadesLog.debug("tipoAbono: " + lTipoAbono);
					//	movBancL.setTipoAbonoCreacion(lTipoAbono);
					//	movBancL.setTipoAbonoUltimo(lTipoAbono);
            }

            /*
			 * Segun la incidencia 9592 se modifca el create de
			 * la entidad MovimientoBancarios -----------
			 * 
			 * movBancL = movBancLH.create(dto.getEmpresa(),
                     dto.getTipoTransaccion(), dto.getCuentaCorrienteBancaria(),
                    dto.getOidPais(), oidCliente);
			*/

            UtilidadesLog.debug("dto.getConsecutivoTransaccion()>>>>>" +
                dto.getConsecutivoTransaccion());
			UtilidadesLog.debug("dto.getNumeroLote()>>>>>" + dto.getNumeroLote());
            movBancL = movBancLH.create(dto.getEmpresa(),
                    subproceso, dto.getCuentaCorrienteBancaria(),
                    dto.getOidPais(), oidCliente, lTipoAbono,
                    dto.getConsecutivoTransaccion(),dto.getNumeroLote());
            
			
			movBancL.setTipoAbonoCreacion(lTipoAbono);
			movBancL.setTipoAbonoUltimo(lTipoAbono);
			UtilidadesLog.debug("despues de setear lTipoAbono");
			
            // *** Para las fecha del system ****
            java.util.Date now = GregorianCalendar.getInstance().getTime();		   
			long feP = now.getTime();
			
			java.sql.Date fechaP =   new java.sql.Date(feP);
			UtilidadesLog.debug("fechaPfechaPfechaP>>>> " + fechaP );
            movBancL.setFechaProceso(fechaP);
            
            UtilidadesLog.info("System.currentTimeMillis():: " + System.currentTimeMillis());            
            movBancL.setHoraProceso(new Timestamp(System.currentTimeMillis()));

            //CIERRE DE COMENTARIO
            UtilidadesLog.debug("dto.getCodConsultoraReal()>>>> " + dto.getCodConsultoraReal());
            movBancL.setCodigoConsultora(dto.getCodConsultoraReal());

			UtilidadesLog.debug("cupon>>> " + dto.getNumeroCupon());
            if (dto.getNumeroCupon() != null) {
                movBancL.setNumeroCupon(new Long(dto.getNumeroCupon().longValue()));
            }else{
				movBancL.setNumeroCupon(null);
			}

            movBancL.setSubprocesoMarcasUltimo(subproceso);
            movBancL.setSubprocesoMarcaCreacion(subproceso);          

            UtilidadesLog.debug("4 >>> " + dto.getDigitoChequeo());
 
            if (dto.getDigitoChequeo() != null) {
                movBancL.setDigitoChequeoFactura(dto.getDigitoChequeo());
            }else{
				movBancL.setDigitoChequeoFactura(null);
			}

            UtilidadesLog.debug(" 5 >><" + dto.getEstatusMovimientoTesoreria() );

            if (dto.getEstatusMovimientoTesoreria() != null) {
                movBancL.setEstatusMovimientoPendienteAplicado(String.valueOf(
                        dto.getEstatusMovimientoTesoreria()));
            }else{
				 movBancL.setEstatusMovimientoPendienteAplicado(null);
			}

            UtilidadesLog.debug("6 >>>> " + dto.getFechaMovimientoAplicacion() );
           
            if (dto.getFechaMovimientoAplicacion() != null) {
                UtilidadesLog.debug("*** con valor");
                long l = dto.getFechaMovimientoAplicacion().getTime();
                Timestamp tStamp = new Timestamp(l);
                movBancL.setFechaMovimientoAplicacion(tStamp);
            }
            else{
                //Modificado por: Cristian Valenzuela
                //Fecha: 15/12/2006
                //Incidencia: V-CCC-018
                //(Segun Antonio Guardiola se debe grabar la fecha de sistema en este campo)
                //Nota: En la LPInsertarMovimientos el metodo setFechaMovimientoAplicacion
                //estaba comentado, es decir, desde el caso de uso
                //Generar movimientos bancarios manual de CCC, siempre
                //llegaba con el valor nulo.
                UtilidadesLog.debug("*** sin valor, fecha de sistema");
                Timestamp tStamp = new Timestamp(feP);
                movBancL.setFechaMovimientoAplicacion(tStamp);
                //movBancL.setFechaMovimientoAplicacion(null);
            }


			UtilidadesLog.debug("dto.getFechaPago()>>>>" + dto.getFechaPago());
            if (dto.getFechaPago() != null) {
                UtilidadesLog.debug("dto.getFechaPago()>>>> " + dto.getFechaPago());
                movBancL.setFechaPago((java.sql.Date) dto.getFechaPago());
            }else{
				 movBancL.setFechaPago(null);
			}

            UtilidadesLog.debug("8 >>> " +dto.getHorario() );
            
            if (dto.getHorario() != null) {
                movBancL.setHorarioNormalAdicional(String.valueOf(dto.getHorario()));
            }else{
				movBancL.setHorarioNormalAdicional(null);
			}
			
            
            //--fin modificacion ------

           UtilidadesLog.debug("getIdentificadorProceso: " + dto.getIdentificadorProceso());

            if (dto.getIdentificadorProceso() != null) {
                movBancL.setIdentificadorProceso(String.valueOf(dto.getIdentificadorProceso()));
                
            }else{
				movBancL.setIdentificadorProceso(null);
			}

            /*Gacevedo 31/10/2006 Modificado por incidencia  V-CCC-007 de validacion*/
             movBancL.setImportePago(dto.getImportePago());
             UtilidadesLog.debug("dto.getImportePago()>>>>" +  dto.getImportePago());
             movBancL.setImporteMovimiento(dto.getImportePago());
             movBancL.setImporteAplicado(new BigDecimal("0"));
             movBancL.setSaldoPendiente(dto.getImportePago());
             /*Fin de la modificacion de incidencia  V-CCC-007*/


            UtilidadesLog.debug("11  >>>>" + dto.getNombreOficina());

            if (dto.getNombreOficina() != null) {
                movBancL.setNombreOficina(dto.getNombreOficina());
            }else{
				movBancL.setNombreOficina(null);
			}

            UtilidadesLog.debug("12 >>>>" + dto.getNumeroCupon());

            if (dto.getNumeroCupon() != null) {
                movBancL.setNumeroDocumento(dto.getNumeroCupon().toString());
            }else{
				movBancL.setNumeroDocumento(null);
			}

            UtilidadesLog.debug("13 >>><" + dto.getNumeroFactura());

            if (dto.getNumeroFactura() != null) {
                movBancL.setNumeroFacturaBoleta(dto.getNumeroFactura());
            }else{
				 movBancL.setNumeroFacturaBoleta(null);
			}
            UtilidadesLog.debug("14 >>>" + dto.getNumeroLoteContabilizacion());

            if (dto.getNumeroLoteContabilizacion() != null) {
                movBancL.setNumeroLoteContabilizacion(dto.getNumeroLoteContabilizacion());
            }else{
				movBancL.setNumeroLoteContabilizacion(null);
			}

            UtilidadesLog.debug("15 " + dto.getObservaciones() );

            if (dto.getObservaciones() != null) {
                movBancL.setObservaciones(dto.getObservaciones());
            }else{
				movBancL.setObservaciones(null);
			}
			

            UtilidadesLog.debug("16>>>> " + dto.getOficinaRecaudadora() );

            if (dto.getOficinaRecaudadora() != null) {
                movBancL.setOficinaRecaudadora(dto.getOficinaRecaudadora());
            }else{
				movBancL.setOficinaRecaudadora(dto.getOficinaRecaudadora());
			}

            UtilidadesLog.debug("17>>>>" +dto.getUsuarioProceso()  );

            if (dto.getUsuarioProceso() != null) {
                movBancL.setUsuarioProceso(dto.getUsuarioProceso());
            }else{
				movBancL.setUsuarioProceso(null);
			}

            movBancL.setEstatusMovimientoPendienteAplicado(new String("P"));
            movBancL.setNumeroHistoria(new Integer(0));
            /*Gacevedo Modificado por incidencia  V-CCC-007 de Validacion*/
            movBancL.setCodigoError(new String("00"));
             /*Fin de la modificacion de V-CCC-007*/
            
			movBancL.setIdentificadorProceso(new String("T"));
			movBancL.setTipoTransaccion(dto.getTipoTransaccion());
      
            //SCS, segun inc.: V-CCC-013
            movBancL.setCodigoUsuario(ctx.getCallerPrincipal().getName());


        } catch (NoResultException ex) {
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (DuplicateKeyException ex) {
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (MareException ex) {
            throw ex;
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(movBancL.getOid());
        UtilidadesLog.debug("contenido de DTOOid***** " + dtoOid.toString());
        UtilidadesLog.info("MONCuentasCorrientesBean.insertarMovimientoBancario(DTOMovimientoBancario dto): Salida"); 
        return dtoOid;
    }
	
    public DTOSalida obtienePorEmpresa(DTOOID dto) throws MareException {
        /* Delegamos en DAOCuentasCorrientes.obtienerCuentasCorrientesEmpresa */
        UtilidadesLog.info("MONCuentasCorrientesBean.obtienePorEmpresa(DTOOID dto): Entrada");
        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());
        UtilidadesLog.info("MONCuentasCorrientesBean.obtienePorEmpresa(DTOOID dto): Salida");
        return daoCtaCte.obtenerCuentasCorrientesEmpresa(dto);
    }

    public DTOSalida obtenerTiposTransaccion(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerTiposTransaccion(DTOBelcorp dto): Entrada"); 
        /* Delegamos en el metodo del mismo nombre del DAOCuentasCorrientes */
        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerTiposTransaccion(DTOBelcorp dto): Salida");
        return daoCtaCte.obtenerTiposTransaccion(dto);
    }

    public EJBLocalHome getEntitiHome(String ent) throws MareException {
        return (EJBLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/" +
            ent);
    }

    public void procesarLote(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.procesarLote(DTOOIDs dto): Entrada");
        Long[] arr = dto.getOids();
        MovimientosBancariosLocal movBanc = null;
        
        Vector vec= new Vector();


       DTOMovBancIndicadores dtoMBI = new DTOMovBancIndicadores();
       
        DTOMovimientoBancario dtoMBanc = new DTOMovimientoBancario();
		for (int i = 0; i < arr.length; i++) {
    
    
            UtilidadesLog.info("antes de movBancLH (for)");
            MovimientosBancariosLocalHome movBancLH = (MovimientosBancariosLocalHome) this.getEntitiHome(
                    "MovimientosBancarios");

            try {
                movBanc = movBancLH.findByPrimaryKey(arr[i]);
               
                //DTOMovimientoBancario dtoMBanc = new DTOMovimientoBancario();
                
                dtoMBanc.setAnioDocumentoAplicacion(movBanc.getDocumentoAplicacionAnyo());
                dtoMBanc.setAnioDocumentoCreacion(movBanc.getDocumentoCreacionAnyo());
                dtoMBanc.setCodConsultoraReal(movBanc.getCodigoConsultora());
                dtoMBanc.setCodError(movBanc.getCodigoError());
                dtoMBanc.setConsecutivoTransaccion(movBanc.getConsecutivoTransaccion());
                dtoMBanc.setCuentaCorrienteBancaria(movBanc.getCuentaCorriente());
                dtoMBanc.setDigitoChequeo(movBanc.getDigitoChequeoFactura());
                dtoMBanc.setEmpresa(movBanc.getEmpresa());

                if (movBanc.getEstatusMovimientoPendienteAplicado() != null) {
                    dtoMBanc.setEstatusMovimientoTesoreria(new Character(
                            movBanc.getEstatusMovimientoPendienteAplicado()
                                   .charAt(0))); //?
                }

                dtoMBanc.setFechaContabilizacion(movBanc.getFechaContabilizacion());

                if (movBanc.getFechaMovimientoAplicacion() != null) {
                    dtoMBanc.setFechaMovimientoAplicacion(new Date(
                            movBanc.getFechaMovimientoAplicacion().getTime()));
                }
                
                dtoMBanc.setFechaPago(movBanc.getFechaPago());

                if (movBanc.getHorarioNormalAdicional() != null) {
                    dtoMBanc.setHorario(movBanc.getHorarioNormalAdicional());
                }

                if (movBanc.getIdentificadorProceso() != null) {
                    dtoMBanc.setIdentificadorProceso(movBanc.getIdentificadorProceso());
                }
                
                
                //-- Paola Cabrera
                //-- 16/11/2005
                //--se agrega por inc 21425
                dtoMBanc.setOidConsultoraReal(movBanc.getConsultoraReal());
                dtoMBanc.setOidIdioma(dto.getOidIdioma());
                dtoMBanc.setOidPais(movBanc.getPais());
                //----
                
                    
                
                dtoMBanc.setImportePago(movBanc.getImportePago());
                dtoMBanc.setNombreOficina(movBanc.getNombreOficina());
                //dtoMBI.setNumeroCupon(new Integer(movBanc.getNumeroCupon().intValue()));
                //dtoMBI.setNumeroDocumentoAplicacion(movBanc.getDocumentoAplicacionNumero());
                //dtoMBI.setNumeroDocumentoCreacion(movBanc.getDocumentoCreacionNumero());
                dtoMBanc.setNumeroFactura(movBanc.getNumeroFacturaBoleta()); //?
                dtoMBanc.setNumeroLote(movBanc.getNumeroLote());
                dtoMBanc.setNumeroLoteContabilizacion(movBanc.getNumeroLoteContabilizacion());
                dtoMBanc.setObservaciones(movBanc.getObservaciones());
                dtoMBanc.setOficinaRecaudadora(movBanc.getOficinaRecaudadora());
                dtoMBanc.setOid(movBanc.getOid());
                dtoMBanc.setSerieDocumentoAplicacion(movBanc.getDocumentoAplicacionMesSerie());
                dtoMBanc.setSerieDocumentoCreacion(movBanc.getDocumentoCreacionMesSerie());
                dtoMBanc.setTipoTransaccion(movBanc.getTipoTransaccion());
                dtoMBanc.setUsuarioProceso(movBanc.getUsuarioProceso());
                
                
                UtilidadesLog.info("Contenido del dto dtoMBI: " + dtoMBanc) ;
                
				
                PaisLocal pais = null;
        
                try{
                  PaisLocalHome tPLH = this.getPaisLocalHome();
                  UtilidadesLog.info("paisLH ------- " + tPLH);
                  UtilidadesLog.debug("dto.getOidPais()>>>> " + dto.getOidPais());
                  pais= tPLH.findByPrimaryKey(dto.getOidPais());
                  UtilidadesLog.info("despues de  pais>>>> " +  pais);
                }
                        catch(MareException e){
                  UtilidadesLog.error(e);
                }
				
                if (pais.getInd_sald_unic().longValue() == 1) {
                    dtoMBI.setIndicadorSaldoUnico(new Boolean("true"));
                } else {
                    dtoMBI.setIndicadorSaldoUnico(new Boolean("false"));
                }

                
                dtoMBI.setIndicadorSimulacion(new Boolean("false"));
                dtoMBI.setIdentificadorProceso(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO);
                
                vec.add(i, dtoMBanc); 
                
                
            } catch (FinderException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
         }//--fin del for
        
        
        for(int a =0; a<vec.size(); a++){
            UtilidadesLog.info(" dtoMovimientosBancarios: " + vec.get(a));
          
        }
        
        
        DTOMovimientoBancario[] dtoMovimientosBancarios = (DTOMovimientoBancario[])vec.toArray(new DTOMovimientoBancario[vec.size()]);
        dtoMBI.setDtoMovimientosBancarios(dtoMovimientosBancarios);
        
        
        //--se agrega 
        //-- Paola Cabrera 16/11/2005
        dtoMBI.setOidPais(dto.getOidPais());
        dtoMBI.setOidIdioma(dto.getOidIdioma());
        
        //---------------------------
        
  
         for(int a =0; a<dtoMovimientosBancarios.length; a++){
                UtilidadesLog.info(" dtoMovimientosBancarios: " + dtoMovimientosBancarios[a].getTipoTransaccion());
              
         }
        
          MONActualizarCCporAplicacion monActualizarCCporAplicacion= this.getMONActualizarCCporAplicacion();
               
               try{
                      UtilidadesLog.info("Se llama a procesarMovBancporAplicacion " + dtoMBI);   
                      DTOMovimientoBancario dtos =   monActualizarCCporAplicacion.procesarMovBancporAplicacion(dtoMBI);
                      UtilidadesLog.info("DTOMovimientoBancario dtos: " + dtos);
                         
                         
                }catch (RemoteException re){                        
                                UtilidadesLog.debug("Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                 
                UtilidadesLog.info("MONCuentasCorrientesBean.procesarLote(DTOOIDs dto): Salida");
    }

    public DTONumeroRegistros eliminarBloqueoMovCC() throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovCC(): Entrada");
        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());

        String usuario = ctx.getCallerPrincipal().getName();
        DTONumeroRegistros dtoN = new DTONumeroRegistros();
        DTONumeroRegistros dto = new DTONumeroRegistros();
        dto = daoCtaCte.eliminarBloqueoMovCC(usuario);

        Long numeroRegistrosBorrados = dto.getNumeroRegistros();
        dtoN.setNumeroRegistros(numeroRegistrosBorrados);
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovCC(): Salida");

        return dtoN;
    }

    public DTOSalida obtenerMovimientosLote(DTONumerosLineaVistaLotes dto)
        throws RemoteException, MareException {
       /* return null;
         ya no se usa
         * System.out.println("entra a obtener Movimientos Lote de monCuentas");

        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());
        System.out.println("antes del metodo DAO");

        return daoCtaCte.obtenerMovimientosLote(dto);*/
        
        
        ///Modificacion por inc BELC300021307
        // Paola Cabrera
        // 08/11/20005
        
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerMovimientosLote(): Entrada"); 
        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerMovimientosLote(): Salida"); 
        return daoCtaCte.obtenerMovimientosLote(dto);   
   
    }

    
  /**
   * Metodo modificado segun la incidencia BELC300007924 *****
   * @autor: Paola Cabrera
   * Fecha:  
   * Descripcion: Metodo que elimina de la tabla de CCC_MOVIM_BANCA
   * @author: pperanzola
   *          - 30/08/2005 se modifica segun incidencia 17903
   * * 
   */
    public void eliminarLotes(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarLotes(DTOOIDs dto): Entrada"); 
        int i;
        int cantOids;
        int cantRegRS;
        int j;
        Long tmpOid = null;
        Boolean blnComprobarLote;
        DTOSalida dtoS;
        RecordSet rsDtoS = null;
        MovimientosBancariosLocal movBancL = null;        
        DTOOID dtoOidAux = new DTOOID();
        ExcepcionParametrizada exParam;
        DAOCuentasCorrientes DaoCCC = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());

        Long[] oidList;
        oidList = dto.getOids();
        cantOids = oidList.length;
        UtilidadesLog.debug(">>>>>MONCuentasCorrientes.eliminarLotes cantOids= " +cantOids);
        
        for (i = 0; i< cantOids; i++){
            UtilidadesLog.debug(">>>>> oidList = " + oidList[i]);
            dtoOidAux.setOid(oidList[i]);
            //dtoNum.setNumeroLinea(oidList[i]);
            dtoS = DaoCCC.obtenerMovimientosLote(dtoOidAux);
            UtilidadesLog.debug(">>>>> Salgo de obtenerMovimientosLote ");
            blnComprobarLote = this.comprobarLoteContabilizadado(dtoS);
            
            if (blnComprobarLote.equals(Boolean.FALSE)){
                rsDtoS = dtoS.getResultado();
                cantRegRS = rsDtoS.getRowCount();
                for (j = 0; j<cantRegRS ; j++){
                    tmpOid = new Long (((BigDecimal) rsDtoS.getValueAt(j,"OID_MOVI_BANC")).longValue());
                
                    UtilidadesLog.debug(">>>>> comprobarLoteContabilizadado dio FALSE ");
                    try {
                        MovimientosBancariosLocalHome movBancLH = (MovimientosBancariosLocalHome) this.getEntitiHome(
                            "MovimientosBancarios");
                        UtilidadesLog.debug(">>>>>VOY A BUSCAR POR PK=" + tmpOid);
                        movBancL = movBancLH.findByPrimaryKey(tmpOid);
                        UtilidadesLog.debug(">>>>>BUSCO POR PK");
                        movBancL.remove();
                        UtilidadesLog.debug(">>>>>REMOVI ");
                    }catch (FinderException ex) {
                        UtilidadesLog.error(ex);
                        ctx.setRollbackOnly();
                        throw new MareException(ex,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    } catch (RemoveException ex) {
                        ctx.setRollbackOnly();
                        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
             }else if (blnComprobarLote.equals(Boolean.TRUE)){
                   UtilidadesLog.debug(">>>>> comprobarLoteContabilizadado dio TRUE ");
                   /* throw new MareException(new Exception(),
									 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,
                                    "",ErroresDeNegocio.CCC_0038));*/
                    
                    /* mamontie - 05/10/2005
                     * Incincia 17902
                     * */  
                     rsDtoS = dtoS.getResultado();
                     cantRegRS = rsDtoS.getRowCount();
                     BigDecimal numLote = null; 
                     String numLoteStr = new String("");
                     for (int h = 0; h<cantRegRS ; h++){
                        numLote = (BigDecimal)rsDtoS.getValueAt(h,"NUM_LOTE");
                        if(h==0){                            
                            numLoteStr = numLote==null?"":numLote.toString();
                        }else {
                            numLoteStr = numLoteStr + ", " + ( numLote==null?"":numLote.toString());
                        }                          
                     }
                     UtilidadesLog.debug("numero de lote a mostrar " + numLoteStr);
                     exParam = new ExcepcionParametrizada(new MareException(),   
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",
                                                        ErroresDeNegocio.CCC_0038));
                     exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                     exParam.addParameter( numLoteStr );
                     throw exParam;
                    /* FIN mamontie - 05/10/2005
                     * Incincia 17902
                     * */  
                                          
             }
            
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.eliminarLotes(DTOOIDs dto): Salida");
      
    }
    
        /**
     * @author pperanzola
     * @date 04/07/2005     
     * @exception MareException
     * @return Boolean
     * creado : segun incidencia BELC300017903
     * @author pperanzola - se corrige porque no estaba cumpliendo correctamente con la condicion.
     *  Recorremos todos los registros contenidos en movBancarios, si alguno no cumple con una de las siguientes
        condiciones se devuelve TRUE si no FALSE
        - la columna FEC_CONT != null 
        - la columna COD_IDEN_PROC == CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO 
        - la columna NUM_HIST!=0 
     * modificado : segun incidencia V-CCC-039
     * @author sapaza - se corrige porque no estaba cumpliendo correctamente con la condicion.
     *  Recorremos todos los registros contenidos en movBancarios, si alguno no cumple con una de las siguientes
        condiciones se devuelve TRUE si no FALSE
        - la columna FEC_CONT != null 
        - la columna !(COD_IDEN_PROC == CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO)
        - la columna NUM_HIST!=0 
     */
    private Boolean comprobarLoteContabilizadado (DTOSalida dtoSalida) throws MareException{
        UtilidadesLog.info("MONCuentasCorrientesBean.comprobarLoteContabilizadado (DTOSalida dtoSalida): Entrada");
        RecordSet rs = null;
        int cantRegistros;
        int i;
        Date fecCont = null;
        String codIdenProc;
        BigDecimal numHist;
        Long lngNumHist;         
        rs = dtoSalida.getResultado();
        cantRegistros = rs.getRowCount();
        UtilidadesLog.debug(">>>>> cantidad Registros:" + cantRegistros + "\n");
        for (i=0 ; i <cantRegistros ; i++) {
            fecCont = ((rs.getValueAt(i,"FEC_CONT")==null) ? null :(Date) rs.getValueAt(i,"FEC_CONT") );
            UtilidadesLog.debug(">>>>> asigne fecCont \n");
            codIdenProc = (String) rs.getValueAt(i,"COD_IDEN_PROC");
            UtilidadesLog.debug(">>>>> asigne codIdenProc \n");
            numHist  = ((rs.getValueAt(i,"NUM_HIST"))==null ? null : (BigDecimal) rs.getValueAt(i,"NUM_HIST"));
            UtilidadesLog.debug(">>>>> asigne numHist \n");
            if (numHist!=null){ // se toma el null como 0
                lngNumHist = new Long(numHist.longValue());
                //aca realizo la comprobacion para saber si devuelvo true
                if ((  fecCont!=null
                     || !CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO.equals(codIdenProc) //Modificado de (Procesado) a (Transmitido)
                     || lngNumHist.longValue() !=0)){
                        UtilidadesLog.info("MONCuentasCorrientesBean.comprobarLoteContabilizadado (DTOSalida dtoSalida): Salida");
                        return Boolean.TRUE;
                }
            }else {
                UtilidadesLog.info("MONCuentasCorrientesBean.comprobarLoteContabilizadado (DTOSalida dtoSalida): Salida");
                return Boolean.TRUE;
            }
        }  

        UtilidadesLog.info("MONCuentasCorrientesBean.comprobarLoteContabilizadado (DTOSalida dtoSalida): Salida");          
        return Boolean.FALSE;
    
    }

    /**
     *  Recibe un DTOOIDs con los OIDs de los MovimientosCuentaCorriente a bloquear
     *  Si alguno de ellos estuviera aún bloqueado por otro usuario devolvemos false
     *  Si se bloquean todos para el usuario actual devolvemos true
     */
    public Boolean bloquearMovCC(DTOOIDs dtoOIDs) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovCC(DTOOIDs dtoOIDs): Entrada");
        MareMGC mgc;
        String strTimeOutBloqueo;
        long timeOutBloqueo = 10000;
        String usuario;
        int longitud;

        //try { 
        //Proceso  
        BloqueoMovCCLocalHome BloqueoMovCCLocalHome = getBloqueoMovCCLocalHome();
        BloqueoMovCCLocal movCC;
        mgc = (MareMGC) MareMii.getService(new MareTopic("Configuration"));
        strTimeOutBloqueo = (String) mgc.getProperty(
                "application/sicc.timeOutBloqueo"); // Máximo segundos bloqueo (Constante del fichero properties).
        UtilidadesLog.debug("TimeOutBloqueo : " + strTimeOutBloqueo);

        if (strTimeOutBloqueo != null) {
            timeOutBloqueo = Long.parseLong(strTimeOutBloqueo);
        }

        usuario = ctx.getCallerPrincipal().getName();
        longitud = dtoOIDs.getOids().length;

        //Recorremos el DTOOIDs 
        for (int i = 0; i < longitud; i++) {
            try {
                movCC = BloqueoMovCCLocalHome.findByUk(dtoOIDs.getOids()[i]);
                UtilidadesLog.debug("encontro movCC : " + dtoOIDs.getOids()[i]);

                if (!movCC.getUsuario().equals(usuario)) {

                    if ((System.currentTimeMillis() -
                            movCC.getTiempo().longValue()) > timeOutBloqueo) {
                        movCC.setUsuario(usuario);
                        movCC.setTiempo(new Long(System.currentTimeMillis()));
                    } else {

                        return Boolean.FALSE;
                    }
                }
            } catch (NoResultException fe) {
                try {
                    //No encontrado, lo creamos
                    // El create es diferente BloqueoMovCCC.create(dtoOIDs.oids[i], usuario, System.currentTimeMillis());
                    movCC = BloqueoMovCCLocalHome.create(usuario,
                            new Long(System.currentTimeMillis()),
                            dtoOIDs.getOids()[i]);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovCC(DTOOIDs dtoOIDs): Salida");
        return Boolean.TRUE;
    }

    public DTOSalida bloquearBloqueoMovCC() throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearBloqueoMovCC(): Entrada");

        DAOCuentasCorrientes daoCtaCte = new DAOCuentasCorrientes(ctx.getCallerPrincipal()
                                                                     .getName());

        String usuario = ctx.getCallerPrincipal().getName();
        RecordSet resultado = daoCtaCte.bloquearBloqueoMovCC(usuario)
                                       .getResultado();

        DTOSalida dtoSalida = new DTOSalida();

        dtoSalida.setResultado(resultado);
        
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearBloqueoMovCC(): Salida");
        return dtoSalida;
    }

    /*************************************************************************
     *
     *              FIN MÉTODOS DE CDOS
     *
     * ************************************************************************/
    public Boolean sigueBloqueadoMovCC(DTOOIDs dtos)
        throws RemoteException, MareException {
        /**
        *  //Concepto
        *        Si está bloqueado por otro usuario o estando bloqueado por el usuario actual ha expirado el tiempo máximo
        *        devolveremos false. En caso contrario devolveremos true.
        *
        *        //Parámetros de e/s
        *        Entrada: DTOOIDs dtoOIDs
        *        Salida:
        *        false: Si el usuario actual ha perdido el bloqueo en favor de otro usuario
        *        true: Si aún lo tiene bloqueado el usuario actual
        *
        *        //Proceso
        *        Long timeOutBloqueo = Máximo segundos bloqueo (Constante del fichero properties).
        *         String usuario = getCallerPrincipal().getName()
        *        longitud=DTOOIDs.oids.length;
        *
        *        for(int i=0; i<longitud; i++)
        *        {
        *        mov=BloqueoMovCC.findByUK(DTOOIDs.oids[i]);
        *
        *        if ( !(mov.getUsuario().equals(usuario)) || (mov.getUsuario().equals(usuario) &&
        *        (System.currentTimeMillis() - mov.getTiempo() ) > timeOutBloqueo) )
        *        return false;
        *        }
        *
        *        return true;
        */
        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovCC(DTOOIDs dtos): Entrada");

        //Máximo segundos bloqueo (Constante del fichero properties).
        //***********************************************************************
        Long timeOutBloqueo = null;
        MareMGC mgc = null; 
        try {
            mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));
            String time = (String) mgc.getProperty("application.sicc.timeOutBloqueo");
            timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }

        BloqueoMovCCLocalHome home = this.getBloqueoMovCCLocalHome();
        String usuario = ctx.getCallerPrincipal().getName();
        int longitud = dtos.getOids().length;
        Long[] oids = new Long[longitud];
        oids = dtos.getOids();

        try {
            for (int i = 0; i < longitud; i++) {
                UtilidadesLog.debug("oidmovimientoCuenta: " + oids[i]);
                BloqueoMovCCLocal movlocal = home.findByUk(oids[i]);
                if (!movlocal.getUsuario().equals(usuario)){
                    UtilidadesLog.debug("Metodo sigueBloqueadoMovCC(DTOOIDs): SALIDA ");
                    return Boolean.valueOf(false);
                }
                if (movlocal.getUsuario().equals(usuario) && ((System.currentTimeMillis() -
                            movlocal.getTiempo().longValue()) > timeOutBloqueo.longValue())) {
                    movlocal.setTiempo(new Long(System.currentTimeMillis()));
                    home.merge(movlocal);
                }
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Metodo sigueBloqueadoMovCC: -----> finderException");
            this.loguearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovCC(DTOOIDs dtos): Salida");
        return Boolean.valueOf(true);
    }


    public Boolean sigueBloqueadoMovCC(DTOOID dto) throws MareException {
        /**
         *  //Concepto
         *        Si está bloqueado por otro usuario o estando bloqueado por el usuario actual ha expirado el tiempo máximo
         *        devolveremos false. En caso contrario devolveremos true.
         *
         *        //Parámetros de e/s
         *        Entrada: DTOOID dtoOID
         *        Salida:
         *        false: Si el usuario actual ha perdido el bloqueo en favor de otro usuario
         *        true: Si aún lo tiene bloqueado el usuario actual
         *
         *        //Proceso
         *        Construimos un array de OIDs con una sola fila
         *
         *        Long[] oid=new Long[1];
         *        oid[0]=dtoOID.oid;
         *        DTOOIDs oids=new DTOOIDs();
         *        oids=oid;
         *
         *        Invocamos al método sobrecargado que hace lo mismo pero que necesita como parámetro un DTOOIDs
         *
         *        return sigueBloqueadoMovCC( oids );
         */
        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovCC(DTOOID dto): Entrada");

        Long[] oid = new Long[1];
        oid[0] = dto.getOid();

        DTOOIDs oids = new DTOOIDs();
        oids.setOids(oid);

        try {
            UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovCC(DTOOID dto): Salida");
            return this.sigueBloqueadoMovCC(oids);
        } catch (RemoteException re) {
            this.loguearError(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public Boolean sigueBloqueadoMovBanc(DTOOIDs dtos)
        throws RemoteException, MareException {
        /**
        *  //Concepto
        *        Si está bloqueado por otro usuario o estando bloqueado por el usuario actual ha expirado el tiempo máximo
        *        devolveremos false. En caso contrario devolveremos true.
        *
        *        //Parámetros de e/s
        *        Entrada: DTOOIDs dtoOIDs
        *        Salida:
        *        false: Si el usuario actual ha perdido el bloqueo en favor de otro usuario
        *        true: Si aún lo tiene bloqueado el usuario actual
        *
        *        //Proceso
        *        Long timeOutBloqueo = Máximo segundos bloqueo (Constante del fichero properties).
        *         String usuario = getCallerPrincipal().getName()
        *        longitud=DTOOIDs.oids.length;
        *
        *        for(int i=0; i<longitud; i++)
        *        {
        *        mov=BloqueoMovBanc.findByUK(DTOOIDs.oids[i]);
        *
        *        if ( !(mov.getUsuario().equals(usuario)) || (mov.getUsuario().equals(usuario) &&
        *        (System.currentTimeMillis() - mov.getTiempo() ) > timeOutBloqueo) )
        *        return false;
        *        }
        *
        *        return true;
        */
        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovBanc(DTOOIDs dtos): Entrada");

        //Máximo segundos bloqueo (Constante del fichero properties).
        //***********************************************************************
        Long timeOutBloqueo = null;
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
            //Cambiar ruta por la ruta del servidor de publicacion C:\oc4j903\mare-conf
           /* BufferedReader br = new BufferedReader(new FileReader(
                        
                //"c:\\construccion\\proyectos\\MARE-CONF\\mare\\mare-conf\\application.properties"));
                "c:\\oc4j903\\mare-conf\\application.properties"));
            String str;

            while ((str = br.readLine()) != null) { //por cada linea.

                StringTokenizer st = new StringTokenizer(str, "=");
                String[] dat = new String[st.countTokens()];
                int x = 0;

                while (st.hasMoreTokens()) {
                    String cadena = st.nextToken();
                    cadena = cadena.trim();

                    if (cadena.equals((Object) "application.timeOutBloqueo")) {
                        timeOutBloqueo = new Long((String) st.nextToken().trim());
                    }
                }
            }*/
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }/* catch (FileNotFoundException fnf) { //FileReader
            throw new MareException(fnf,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }catch (IOException ioe) { //BufferedReader
            throw new MareException(ioe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ARCHIVO));
        }*/

        BloqueoMovBancLocalHome home = this.getBloqueoMovBancLocalHome();
        String usuario = ctx.getCallerPrincipal().getName();
        int longitud = dtos.getOids().length;
        Long[] oids = new Long[longitud];
        oids = dtos.getOids();

        try {
            for (int i = 0; i < longitud; i++) {
                BloqueoMovBancLocal movlocal = home.findByUk(oids[i]);
/*
                if (!(movlocal.getUsuario().equals(usuario)) ||
                        (movlocal.getUsuario().equals(usuario) &&
                        ((System.currentTimeMillis() -
                        movlocal.getTiempo().longValue()) > timeOutBloqueo.longValue()))) {
                    UtilidadesLog.debug(
                        "**** Metodo sigueBloqueadoMovBanc(DTOOIDs): SALIDA ");

                    return new Boolean(false);
                }
*/
//modificado por incidencia 10070
               if (!movlocal.getUsuario().equals(usuario)){
					UtilidadesLog.debug("**** Metodo sigueBloqueadoMovCC(DTOOIDs): SALIDA ");
					return Boolean.valueOf(false);
				}
				if (movlocal.getUsuario().equals(usuario) && ((System.currentTimeMillis() -
                        movlocal.getTiempo().longValue()) > timeOutBloqueo.longValue())) {
					movlocal.setTiempo(BigDecimal.valueOf(System.currentTimeMillis()));
                }
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug(
                "****Metodo sigueBloqueadoMovBanc: error -----> finderException");
            this.loguearError(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovBanc(DTOOIDs dtos): Salida");

        return Boolean.valueOf(true);
    }

    public Boolean sigueBloqueadoMovBanc(DTOOID dto) throws MareException {
        /**
         *  //Concepto
         *        Si está bloqueado por otro usuario o estando bloqueado por el usuario actual ha expirado el tiempo máximo
         *        devolveremos false. En caso contrario devolveremos true.
         *
         *        //Parámetros de e/s
         *        Entrada: DTOOID dtoOID
         *        Salida:
         *        false: Si el usuario actual ha perdido el bloqueo en favor de otro usuario
         *        true: Si aún lo tiene bloqueado el usuario actual
         *
         *        //Proceso
         *        Construimos un array de OIDs con una sola fila
         *
         *        Long[] oid=new Long[1];
         *        oid[0]=dtoOID.oid;
         *        DTOOIDs oids=new DTOOIDs();
         *        oids=oid;
         *
         *        Invocamos al método sobrecargado que hace lo mismo pero que necesita como parámetro un DTOOIDs
         *
         *        return sigueBloqueadoMovBanc( oids );
         */
        UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovBanc(DTOOID dto): Entrada");

        Long[] oid = new Long[1];
        oid[0] = dto.getOid();

        DTOOIDs oids = new DTOOIDs();
        oids.setOids(oid);

        try {
            UtilidadesLog.info("MONCuentasCorrientesBean.sigueBloqueadoMovBanc(DTOOID dto): Salida");

            return this.sigueBloqueadoMovBanc(oids);
        } catch (RemoteException re) {
            this.loguearError(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTONumeroRegistros eliminarBloqueoMovBanc()
        throws MareException {
		/**
		 * 	//Concepto 
		 *	Elimina todos los registros pertenecientes al usuario en cuestión. 
		 *
		 *	//Parámetros de e/s 
		 *	Entrada: void 
		 *	Salida: DTONumeroRegistros 
		 *
		 *	//Proceso 
		 *	String usuario=ejbcontext.getCallerPrincipal().getName(); 
		 *	Long numeroRegistrosBorrados=DAOCuentasCorrientes.eliminarBloqueoMovBanc(usuario); 
		 *
		 *	return new DTONumeroRegistros(numeroRegistrosBorrados);
		 */
		UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovBanc(): Entrada");

		String usuario = ctx.getCallerPrincipal().getName();
		DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(usuario);
		DTONumeroRegistros dtoNumeroRegistros = null;
		dtoNumeroRegistros = daoCuentasCorrientes.eliminarBloqueoMovBanc(usuario);
		
		UtilidadesLog.info("MONCuentasCorrientesBean.eliminarBloqueoMovBanc(): Salida");
		return dtoNumeroRegistros;
    }

	public DTOSalida bloquearBloqueoMovBanc() throws  RemoteException, MareException {
	/**
	 * 	//Concepto 
	 *	Obtenemos los OIDs que el usuario actual tiene bloqueados y bloqueamos la tabla de bloqueos para que no 
	 *	se pueda modificar mientras se ejecuta la actualización de datos en las tablas de Movimientos. 
	 *
	 *	//Parámetros de e/s 
	 *	Entrada: void 
	 *	Salida: DTOSalida dtoSalida 
	 *
	 *	//Proceso 
	 *	String usuario = ejbContext.getCallerPrincipal().getName(); 
	 *	Llamamos a DAOCuentasCorrientes.bloquearBloqueoMovBanc( usuario ) 
	 *	Construimos un DTOSalida con el RecordSet obtenido de la llamada al método anterior. 
	 *
	 *	return dtoSalida
	 */
		UtilidadesLog.info("MONCuentasCorrientesBean.bloquearBloqueoMovBanc(): Entrada");

		String usuario = ctx.getCallerPrincipal().getName();
		DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(usuario);
		RecordSet rs =null;
		rs=daoCuentasCorrientes.bloquearBloqueoMovBanc();
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
		
		UtilidadesLog.info("MONCuentasCorrientesBean.bloquearBloqueoMovBanc(): Salida");
		return dtoSalida;
	}

	public DTOSalida obtenerSituacionesCupon() throws MareException {
	/**
	 * Llama al método del mismo nombre de DAOCCC para recuperar todos los registros de SituacionCupones. 
	 * Devuelve dos columnas: OID_SITU_CUPO, VAL_DESC_SITU_CUPO 
	 */
		UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSituacionesCupon(): Entrada");
		DAOCCC daoccc = new DAOCCC();
		DTOSalida dtoSalida = null;
		dtoSalida=daoccc.obtenerSituacionesCupon();
		UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSituacionesCupon(): Salida");
		return dtoSalida;
	}
/* Eliminado por incidencia
	public void ultimoMovBancAplicado(Long oidCliente, Long oidPais, Integer numeroOrdenCuota) throws  RemoteException, MareException {
	}
*/

	public DTOSiguienteNumeroCupon siguienteNumeroCuponTramiteNuevo(DTOSigNroCupTram dto)
        throws RemoteException, MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.siguienteNumeroCuponTramiteNuevo(DTOSigNroCupTram dto): Entrada");
        DTOSiguienteNumeroCupon dtoS = new DTOSiguienteNumeroCupon();
        StringBuffer query = new StringBuffer();                        
        
        RecordSet rs = null;
        
        UtilidadesLog.debug("dto: " + dto);
        
        SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
        String sFecha = miFecha.format(dto.getFechDigit());        
        String año = sFecha.substring(8,10);
        String mes = sFecha.substring(3,5);        
        
        UtilidadesLog.debug("año y mes act..:" + Long.valueOf(año).longValue() + " / " + Long.valueOf(mes).longValue());
        
        query.append("SELECT * FROM (SELECT sp.num_secu, sp.oid_secu_pais ");
        query.append("FROM ccc_secue_pais sp ");
        query.append("WHERE sp.pais_oid_pais = " + dto.getOidPais().longValue());
        query.append(" AND sp.num_anio = " + Long.valueOf(año).longValue());
        query.append(" AND (sp.num_mes = " +  Long.valueOf(mes).longValue());
        query.append(" OR sp.num_mes IS NULL) ");
        query.append("order by num_mes, num_anio ) ");
        query.append("where rownum = 1");
        rs = this.executeQuery(query.toString());     
        if ((rs.getRowCount()>0) && (rs!=null)){
            UtilidadesLog.info("MONCuentasCorrientesBean.siguienteNumeroCuponTramite(DTOSigNroCupTram dto): Salida");
            int incremento = 0;
            incremento = ((BigDecimal)rs.getValueAt(0, 0)).intValue();
            incremento++;
            dtoS.setNumeroCupon(new Integer(incremento));
            UtilidadesLog.debug("retorno: "+dtoS);
            this.actualizoRegistro(((BigDecimal)rs.getValueAt(0, 1)).longValue(), incremento);
            return dtoS;
        }else{
            //veo si hay registro para el año y mes anterior
            if (this.hayRegAñoMesAnterior( (Long.valueOf(año).longValue()+1), 
                                           Long.valueOf(mes).longValue(), 
                                           dto.getOidPais().longValue())){
                //creo registro con año y mes act, y contador en 1                                           
                this.creoRegistro(Long.valueOf(año).longValue(), Long.valueOf(mes).longValue(), dto.getOidPais().longValue());
                dtoS.setNumeroCupon(Integer.valueOf("1"));
                UtilidadesLog.debug("retorno: "+dtoS);
            }else{
                //veo si hay para el año ant. solamente
                if (this.hayRegAñoMesAnterior( Long.valueOf(año).longValue(), 
                                               -1, 
                                               dto.getOidPais().longValue())){
                    //creo registro con año y mes act, y contador en 1                                           
                    this.creoRegistro(Long.valueOf(año).longValue(), -1, dto.getOidPais().longValue());
                    dtoS.setNumeroCupon(Integer.valueOf("1"));
                    UtilidadesLog.debug("retorno: "+dtoS);
                }else{
                    this.creoRegistro(Long.valueOf(año).longValue(), Long.valueOf(mes).longValue(), dto.getOidPais().longValue());
                    dtoS.setNumeroCupon(Integer.valueOf("1"));
                    UtilidadesLog.debug("retorno: "+dtoS);
                }
            }
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.siguienteNumeroCuponTramite(DTOSigNroCupTram dto): Salida");
        return dtoS;
    } 
    
    private void actualizoRegistro(long oid, int secuenciaActual) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizoRegistro(long oid, int secuenciaActual): Entrada");
        StringBuffer buff = new StringBuffer();
        buff.append("UPDATE ccc_secue_pais SET num_secu = " + secuenciaActual + " WHERE oid_secu_pais = " + oid);
        try{
            BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
        }catch(Exception e) {
            throw new MareException(e);
        }
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizoRegistro(long oid, int secuenciaActual): Salida");
    } 

	public DTOSiguienteNumeroCupon siguienteNumeroCuponTramite(DTOBelcorp dto)
        throws RemoteException, MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.siguienteNumeroCuponTramite(DTOBelcorp dto): Entrada");
		/*MODIFICADO POR INCIDENCIA 10254
        PaisLocal pais;

        try {
            PaisLocalHome home = this.getPaisLocalHome();
            pais = home.findByPrimaryKey(dto.getOidPais());
        } catch (FinderException fe) {
            this.loguearError(
                "siguienteNumeroCuponTramite: FinderException, no existe Pais = " +
                dto.getOidPais(), fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (NamingException ne) {
            this.loguearError("siguienteNumeroCuponTramite: NamingException", ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

    

		 DTOSalida dtoS = null;
		 String confSec = pais.getVal_conf_secu_ccc();
        java.sql.Date fechaSql = new java.sql.Date(System.currentTimeMillis());

        String anio = null;
        String mes = null;
        StringTokenizer st = new StringTokenizer(fechaSql.toString(), "-");

        if (st.countTokens() > 0) {
            anio = st.nextToken().toString();
            mes = st.nextToken().toString();
        }

        String usuario = ctx.getCallerPrincipal().getName();
        DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(usuario);

        if (confSec.equals("U")) {
            dtoS = daoCuentasCorrientes.ultiNumCupTramite();
        }

        if (confSec.equals("A")) {
            dtoS = daoCuentasCorrientes.ultiNumCupTramiteAnio(anio);
        }

        if (confSec.equals("M")) {
            dtoS = daoCuentasCorrientes.ultiNumCupTramiteAnioMes(anio, mes);
        }

        Vector vector = new Vector();
        Integer numero = null;

        if (dtoS == null) {
            numero = new Integer(1);
        } else {
            numero = new Integer(dtoS.getResultado().getValueAt(0, "NUM_CUPE")
                                     .toString());
        }

        DTOSiguienteNumeroCupon dtoResultado = new DTOSiguienteNumeroCupon();
        dtoResultado.setNumeroCupon(numero);
		*/
        DTOSiguienteNumeroCupon dtoS = new DTOSiguienteNumeroCupon();
		
		// Aun no esta este metodo>>>>>>
        MONCuentasCorrientesLocal moncccLocal = getMONCuentasCorrientesLocal();
        Integer numero = moncccLocal.obtenerSecuenciaPais(dto);
		//dtoS.setNumeroCupon(daoCCC.obtenerSecuenciaPais(dto));
        dtoS.setNumeroCupon(numero);
        UtilidadesLog.info("MONCuentasCorrientesBean.siguienteNumeroCuponTramite(DTOBelcorp dto): Salida");

        return dtoS;
    }    
    
    private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Entrada");
        RecordSet rs = null;
    
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
        throw new MareException( ex, 
            UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Salida");  
        return rs;
    }  
    

    /** 
     * Método para generar un movimiento bancario bel
     * @param dto DTOMovimientoBancario con los datos del movimiento bancario
     * @exception MareException si no se pudo generara el movimiento
     */
    public void generarMovimientoBEL (DTOMovimientoBancario dto) throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesBean.generarMovimientoBEL (DTOMovimientoBancario dto): Entrada");
/*
 * tiposAbono = TiposAbonoSubproceso.findBySubproceso(CCCConstantes.OID_SUBPROCESO_FACTURACION) 
tipoAbono = Primer elemento de la collection tiposAbono 
oidTipoAbonoCreacion = tipoAbono.oid */
		TiposAbonoSubprocesoLocalHome tiposAbonoHome = this.getTiposAbonoSubprocesoLocalHome();
        Long oidTipoAbonoCreacion = null;
		try{
			Collection tiposAbonoColeccion = tiposAbonoHome.findBySubproceso(CCCConstantes.OID_SUBPROCESO_FACTURACION);
			Iterator tiposAbonoIterator = tiposAbonoColeccion.iterator();
			TiposAbonoSubprocesoLocal tipoAbono=(TiposAbonoSubprocesoLocal)tiposAbonoIterator.next();
			oidTipoAbonoCreacion = tipoAbono.getOid();
		}catch (NoResultException e)  {		
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.loguearError(e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}  		  		


/*Crea una entrada en la entidad MovimientosBancarios con los datos: 
- pais = DTOE.pais 
- empresa = DTOE.empresa 
- numeroLote = DTOE.numeroLote 
- consecutivoTransaccion = 1 
- numeroHistoria = 0 
- fechaPago = Fecha del sistema 
- importePago = DTOE.importePago 
- cuentaCorriente = DTOE.cuentaCorrienteBancaria 
- codigoConsultora = DTOE.codConsultoraReal 
- oficinaRecaudadora = DTOE.oficinaRecaudadora 
- nombreOficina = DTOE.nombreOficina 
- tipoTransaccion = DTOE.tipoTransaccion 
- subprocesoMarcaCreacion = CCCConstantes.OID_SUBPROCESO_FACTURACION 
- tipoAbonoCreacion = oidTipoAbonoCreacion (Recuperado arriba) 
- subprocesoMarcasUltimo = CCCConstantes.OID_SUBPROCESO_FACTURACION 
- tipoAbonoUltimo = oidTipoAbonoCreacion (Recuperado arriba) 
- codigoUsuario = DTOE.usuarioProceso 
- codigoError = DTOE.codigoError 
- fechaProceso = Fecha del sistema 
- horaProceso = Hora del sistema 
- consultoraReal = DTOE.oidConsultoraReal 
- estatusMovimientoPendienteAplicado = DTOE.estatusMovimientoTesoreria 
- identificadorProceso = DTOE.codigoIdentProceso 
- subacceso = DTOE.oidSubacceso 
- movimientoCajaCabecera = DTOE.movimientoCaja 
- usuarioProceso = DTOE.usuarioProceso 
 */
        MovimientosBancariosLocalHome homeMovBanc = this.getMovimientosBancariosLocalHome();
        try {
            homeMovBanc.create( dto.getCodConsultoraReal(), //codigoConsultora 
                dto.getOidConsultoraReal(), //consultoraReal	
                dto.getCodError(), //codigoError 
                new Long(1), //consecutivoTransaccion
                null, //digitoChequeoFactura 
                null, //documentoAplicacionAnyo 
                null, //documentoAplicacionMesSerie 
                null, //documentoAplicacionNumero 
                null, //documentoCreacionAnyo 
                null, //documentoCreacionMesSerie 
                null, //documentoCreacionNumero 
                dto.getEstatusMovimientoTesoreria()!=null?dto.getEstatusMovimientoTesoreria().toString():null, //estatusMovimientoPendienteAplicado 
                null, //Date fechaContabilizacion 
                null, //Timestamp fechaMovimientoAplicacion 
                new java.sql.Date(new java.util.Date().getTime()), //fechaPago 
                new java.sql.Date(new java.util.Date().getTime()), //fechaProceso 
                new Timestamp (new java.util.Date().getTime()), // horaProceso  (hora del sistema)
                null, //horarioNormalAdicional, 
                dto.getIdentificadorProceso(), //identificadorProceso 
                dto.getImportePago(), //BigDecimal importePago 
                dto.getNombreOficina(), // nombreOficina 
                null, //numeroDocumento 
                null, //numeroFacturaBoleta
                dto.getNumeroLote(), //numeroLote
                null, //numeroLoteContabilizacion 
                null, //observaciones 
                dto.getOficinaRecaudadora(), //Integer oficinaRecaudadora 
                dto.getUsuarioProceso(), //usuarioProceso 
                null, // numeroCupon 
                dto.getEmpresa(),//empresa	
                oidTipoAbonoCreacion, //Long tipoAbonoCreacion 
                oidTipoAbonoCreacion, //tipoAbonoUltimo 
                dto.getTipoTransaccion(), //tipoTransaccion 
                CCCConstantes.OID_SUBPROCESO_FACTURACION, //subprocesoMarcaCreacion 
                CCCConstantes.OID_SUBPROCESO_FACTURACION, //subprocesoMarcasUltimo 
                dto.getCuentaCorrienteBancaria(), // cuentaCorriente, 
                null, // numeroLoteExterno, 
                dto.getOidMovimientoCaja(), // movimientoCajaCabecera?
                null, //saldoPendiente, 
                dto.getUsuarioProceso(), //codigoUsuario, 
                new Integer(0), // numeroHistoria 
                null, //importeAplicado, 
                null, //dto.getCodError(), //error, 
                dto.getOidPais(), //pais
                dto.getSubacceso(), //subacceso
                null
            );
        } catch (DuplicateKeyException de) {
			//clave duplicada GEN-0001
			this.loguearError(de);
			String codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
			throw new MareException(de, UtilidadesError.armarCodigoError(codigoError));
		}  catch (CreateException e)  {
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.loguearError(e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    			
		}
		UtilidadesLog.info("MONCuentasCorrientesBean.generarMovimientoBEL (DTOMovimientoBancario dto): Salida");
      
    }

    private String cerosIzq(String cadena1, int cantidad) {
        UtilidadesLog.info("MONCuentasCorrientesBean.cerosIzq(String cadena1, int cantidad): Entrada");
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
      
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        UtilidadesLog.info("MONCuentasCorrientesBean.cerosIzq(String cadena1, int cantidad): Salida");
        return cadena2.toString();
    }
    private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getTiposAbonoSubprocesoLocalHome(): Entrada");        
        UtilidadesLog.info("MONCuentasCorrientesBean.getTiposAbonoSubprocesoLocalHome(): Salida");
        return new TiposAbonoSubprocesoLocalHome();
    }

  public DTOSalida recargaCC(DTOBelcorp dto) throws MareException{
     UtilidadesLog.info("MONCuentasCorrientesBean.recargaCC(DTOBelcorp dto): Entrada");
     DAOCuentasCorrientes daoCuentasCorrientes = new DAOCuentasCorrientes(ctx.getCallerPrincipal().getName());
     DTOSalida dtoSalida = new DTOSalida();
     dtoSalida.setResultado(daoCuentasCorrientes.recargaCC(dto));
     UtilidadesLog.info("MONCuentasCorrientesBean.recargaCC(DTOBelcorp dto): Salida");
     return dtoSalida;
  }
  
   /** 
     * Método para consultar el informe de REPConsultaCC
     * @param dto DTOString con el codigo de cliente
     * @return Recordset
     * @exception MareException si no encontro nada
     * mdolce
     * 18/05/2005
     * 16/08/2006 - [1] - pperanzola, se corrige por performance
     * 09/04/2007 - [2] - Rafael Romero, modificado para obtener direccion y fecha de nacimiento
    */

    public DTORepConsultaCCC repConsultaCC(DTORepBusquedaCC dto) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientesBean.repConsultaCC(DTORepBusquedaCC dto): Entrada");
      UtilidadesLog.debug("Ingreso al metodo repConsultaCC " + dto);
      DTORepConsultaCCC dtoS = new DTORepConsultaCCC();
      DAOCCC dao = new DAOCCC();
      RecordSet rs;
      Long oidCliente = null; //[1]
      BigDecimal total = null; //[1]
      int numDeci = dao.obtenerNumDeci(dto.getOidPais()).intValue();
      //[1] try{
          rs = dao.repConsultaCC(dto);
                 
          dtoS.setApenom(rs.getValueAt(0,0) != null?(String)rs.getValueAt(0,0):null);
          dtoS.setFechaIngreso(rs.getValueAt(0,1) != null?(Date)rs.getValueAt(0,1):null);
          dtoS.setTipoCodigoTipoDocumento(rs.getValueAt(0,2) != null?(String)rs.getValueAt(0,2):null);
          dtoS.setNumeroDocumento(rs.getValueAt(0,3) != null?(String)rs.getValueAt(0,3):null);
          dtoS.setSgv(rs.getValueAt(0,4) != null?(String)rs.getValueAt(0,4):null);
          dtoS.setRegion(rs.getValueAt(0,5) != null?(String)rs.getValueAt(0,5):null);
          dtoS.setZona(rs.getValueAt(0,6) != null?(String)rs.getValueAt(0,6):null);
          dtoS.setImporteLineaCredito(rs.getValueAt(0,7) != null?((BigDecimal)rs.getValueAt(0,7)).toString():null);
          dtoS.setCodNivelRiesgo(rs.getValueAt(0,8) != null?(String)rs.getValueAt(0,8):null);
          dtoS.setStatusCliente(rs.getValueAt(0,9) != null?(String)rs.getValueAt(0,9):null);
          ///*[1] ClienteDatosBasicosLocal cliente =  this.getClienteDatosBasicosLocalHome().findByUK( dto.getOidPais(), dto.getCodCliente());              
          //MONInterfaceModulos ccc = this.getMONInterfaceModulosHome().create();
          //DTOSaldosPorFechasyVtos dtoCcc = new DTOSaldosPorFechasyVtos();
          // dtoCcc.setOidCliente(cliente.getOid());        
          //dtoCcc.setOidPais(dto.getOidPais());
          //DTOTotal saldo = ccc.calcularSaldoCCCliente(dtoCcc);        
          //if(saldo.getTotal() != null){
          //   dtoS.setDeudaTotal(saldo.getTotal().toString());
         // }
          oidCliente = new Long (((BigDecimal)rs.getValueAt(0,"OIDCLIENTE")).longValue());
          total = dao.calcularSaldoCCCliente(dto.getOidPais(),oidCliente);
          if(total != null){
             dtoS.setDeudaTotal(total.toString());
          }
         //*/[1]
         
          //  Agregado por HRCS - Fecha 02/04/2007 - Incidencia Sicc20070176
          dtoS.setTerritorio(rs.getValueAt(0,"TERRITORIO")!= null?((BigDecimal)rs.getValueAt(0,"TERRITORIO")).toString():"");
          
          // [2]i Rafael Romero - 09/04/2007 - SiCC 20071077
          
          // Fecha Nacimiento
          dtoS.setFechaNacimiento((Date)rs.getValueAt(0,"FECHANACIMIENTO"));
          // Direccion
          // UtilidadesLog.debug("Por obtener direccion");
          dtoS.setDireccion(dao.obtenerDireccionPpalCliente(oidCliente));
          // [2]f
          
          //jrivas 22/7/2008 CCC-004
          dtoS.setPagoSaldoVencido(dao.calcularPagoSaldoVencido(oidCliente).setScale(numDeci, BigDecimal.ROUND_HALF_EVEN).toString());
          dtoS.setSaldoPorVencer(dao.calcularSaldoPorVencer(oidCliente, dto.getOidPais()).setScale(numDeci, BigDecimal.ROUND_HALF_EVEN).toString());
          //FIN CCC-004
          
          DTOFiltroCC dtof= new DTOFiltroCC();
          //[1] dtof.setOidCliente(cliente.getOid());
          dtof.setOidCliente(oidCliente); //[1]
          dtof.setOidIdioma(dto.getOidIdioma());
          dtof.setOidPais(dto.getOidPais());
          
          if(dto.getNumeroCargo() != null){
             dtof.setOidNumeroCargo(dto.getNumeroCargo());
          }
          
          //TO DO cambiar dto de entrada de este metodo, para poder seterale los otros parametros
          //dtof.setOidNumeroCargo();
          
          //[1] RecordSet rsDetalle = dao.obtenerDetalleConsultaCC(dtof);
          UtilidadesLog.debug("Por obtenerDetalleConsultaCC2...");
          RecordSet rsDetalle = dao.obtenerDetalleConsultaCC2(dtof); //[1]
          
          String indicadorConsulta = new String();
          Long oidDetalle;
          
          rsDetalle.setValueAt(total, 0, 9); //8 es la columna "Saldo" del rs

          //
          //  Agregado por HRCS - Fecha 21/06/2007 - Cambio Sicc20070296
          //  Se modifica el detalle de la consulta CCC para que muestre las descripciones de los registros originados por reclamos
          //
          int f = 0;
          HashMap consolidadosReclamos = new HashMap();
          while(f<rsDetalle.getRowCount()) {
              //  Si tiene consolidado y el importe es negativo
              if (rsDetalle.getValueAt(f,13)!=null && ((BigDecimal)rsDetalle.getValueAt(f,8)).doubleValue() < 0.0)   {
                  UtilidadesLog.debug("Importe es negativo...");
                  //  Obtenemos el oid del consolidado que genero el movimiento
                  Long consolidado = new Long( ((BigDecimal)rsDetalle.getValueAt(f,13)).longValue() );
                  //  Si el oid consolidado ya ha sido modificado o agregado, entonces ya no se toma en cuenta
                  if ( consolidadosReclamos.containsKey(consolidado) )   {
                      UtilidadesLog.debug("Eliminando registro...");
                      rsDetalle.removeRow(f);
                      f--;
                  }
                  else    {
                      ArrayList solicitudes = dao.obtenerSolicitudesOrigenReclamo( consolidado );
                      //  Si la lista tiene por lo menos un registro, entonces es un consolidado de RECLAMO
                      if (solicitudes!=null && !solicitudes.isEmpty())    {   // es reclamo
                      
                          //  Si solo esta formado por una solicitud:
                          if (solicitudes.size() == 1)    {
                              UtilidadesLog.debug("Reemplazando la descripcion por la del Reclamo...");
                              HashMap solicitudReclamo = (HashMap)solicitudes.get(0);
                              //  Obtiene la descripcion del reclamo
                              rsDetalle.setValueAt( (String)solicitudReclamo.get("DESCRIP"), f, 3);
                              //  El monto es el del CONSOLIDADO
                              rsDetalle.setValueAt( (Double)solicitudReclamo.get("CONVTPL"), f, 8);
                          }
                          else    {   //  Si son mas de una, se recorre todas las solicitudes del consolidado:
                              HashMap solicitud = null;
                              double montoAcumulado = 0.0;
                              for(int conta=0; conta<solicitudes.size(); conta++)   {
                                  solicitud = (HashMap)solicitudes.get(conta);
                                  montoAcumulado = montoAcumulado + ((Double)solicitud.get("RECPOSSUM")).doubleValue();
                              }
                              //  Calcula el ajuste de todos las solicitudes de reclamos
                              double ajuste = ((Double)solicitud.get("CONVTPL")).doubleValue() - montoAcumulado;
                              UtilidadesLog.debug("El ajuste para el consolidado("+ consolidado +") es de: ["+ ajuste +"]");
                              
                              //  Se imprime cada detalle del reclamo en el cupon de pago
                              for(int conta=0; conta<solicitudes.size(); conta++)   {
                                  HashMap solicitudReclamo = (HashMap)solicitudes.get(conta);

                                  //  Si es la primera solicitud, se le suma el ajuste
                                  if (conta==0)   {
                                      UtilidadesLog.debug("Se modifica el primer registro del consolidado de reclamos..." );
                                      Double montoAjustado = new Double( ((Double)solicitudReclamo.get("RECPOSSUM")).doubleValue() + ajuste );
                                      rsDetalle.setValueAt(montoAjustado, f, 8);
                                      //  Obtiene la descripcion del reclamo
                                      rsDetalle.setValueAt( (String)solicitudReclamo.get("DESCRIP"), f, 3);
                                  }
                                  else    {
                                      Vector v = rsDetalle.getRow(f); //  Vector actual
                                       
                                      Vector nuevoRegistro = new Vector();
                                      for(int i=0; i<v.size(); i++)   {
                                          //  Para la columna del monto se setea el valor calculado de las posiciones
                                          if (i==8)   {
                                               nuevoRegistro.add( new BigDecimal( ((Double)solicitudReclamo.get("RECPOSSUM")).doubleValue() ).setScale(2, BigDecimal.ROUND_HALF_EVEN) );
                                          }else if(i == 3){
                                             //  Obtiene la descripcion del reclamo
                                             nuevoRegistro.add((String)solicitudReclamo.get("DESCRIP"));
                                          }else    {
                                              if (v.get(i)!=null) {
                                                  if (v.get(i) instanceof BigDecimal) {
                                                      nuevoRegistro.add( (BigDecimal)v.get(i) );
                                                  }
                                                  else if (v.get(i) instanceof String) {
                                                      nuevoRegistro.add( v.get(i).toString() );
                                                  }
                                                  else    {
                                                      nuevoRegistro.add( v.get(i) );
                                                  }
                                              }
                                              else    {
                                                  nuevoRegistro.add( v.get(i) );
                                              }
                                          }
                                      }
                                      //rsDetalle.addRow( nuevoRegistro );
                                      rsDetalle.insertRow( f, (Vector)nuevoRegistro );
                                      f++;
                                      UtilidadesLog.debug("Se agrego un nuevo registro al detalle..." );
                                  }
                              }
                          }
                          //  Agregando al hash de consolidados...
                          consolidadosReclamos.put( consolidado, consolidado );
                      }
                  }
              }
              
              //  Agregado por HRCS - Fecha 09/07/2007 - Cambio Sicc20070318
              if (rsDetalle.getValueAt(f,14)!=null)   {
                  rsDetalle.setValueAt( rsDetalle.getValueAt(f,14), f, 2 );   //  fecha de pago
              }
              else if (rsDetalle.getValueAt(f,14)==null && rsDetalle.getValueAt(f,15)!=null)  {
                  rsDetalle.setValueAt( rsDetalle.getValueAt(f,15), f, 2 );   //  fecha de movimiento
              }
              else if (rsDetalle.getValueAt(f,14)==null && rsDetalle.getValueAt(f,15)==null && rsDetalle.getValueAt(f,2)==null)  {
                  rsDetalle.setValueAt( rsDetalle.getValueAt(f,1), f, 2 );    //  fecha del documento
              }
              //else    // Por defecto queda con la fecha valor
              f++;
          }
          //UtilidadesLog.debug("la longitud del recordset " + rsDetalle.getRowCount());
          
    //Modificado por incidencia BELC300022970
    //El calculo del saldo se realizara en la capa cliente
    /*
          for (int f = 1; f < rsDetalle.getRowCount(); f++){
             oidDetalle = new Long( ( (BigDecimal)rsDetalle.getValueAt(f,1)).longValue());
             indicadorConsulta = dao.obtenerIndicadorConsulta(oidDetalle);
             if(indicadorConsulta.equals("A")){
                rsDetalle.setValueAt(saldo.getTotal(), f, 10);
             }else{
                BigDecimal saldoAnterior;
                BigDecimal importe;
                BigDecimal saldoCuenta;
                
                saldoAnterior = ((BigDecimal)rsDetalle.getValueAt(f - 1 , 10));
                importe = ((BigDecimal)rsDetalle.getValueAt(f , 9));
                saldoCuenta = saldoAnterior.add(importe);
                rsDetalle.setValueAt(saldoCuenta,f,10);
             }
          }
          
          UtilidadesLog.debug("El indicador de consulta " + indicadorConsulta);
          UtilidadesLog.debug("El recordset final es " + rsDetalle); 
    */
          dtoS.setDatosCC(rsDetalle);
          //UtilidadesLog.debug("******El oid del clientes es " + cliente.getOid());
          dtoS.setOidCliente(oidCliente);//[1] cliente.getOid());
           
      ///*[1]
      /*} catch (NamingException namingException) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(namingException);
          throw new MareException(namingException,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException createException) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(createException);
          throw new MareException(createException,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      
      
      } catch (RemoteException re) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(re);
          throw new MareException(re,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
        catch (FinderException finderException) {
              throw new MareException(finderException,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } ///*[1]*/
      UtilidadesLog.info("MONCuentasCorrientesBean.repConsultaCC(DTORepBusquedaCC dto): Salida");
      return dtoS;
    }
  /** 
     * Método para obtenerel saldo de la campaña
     * @param dto DTOsaldoCampana con el oid de cliente y el oid del periodo
     * @return DTOSaldoCampana
     * @exception MareException
     * mdolce
     * 24/05/2005
     */


  public DTOSaldoCampana obtenerSaldoCampana(DTOSaldoCampana dto) throws MareException {
    
    UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSaldoCampana(DTOSaldoCampana dto): Entrada");
    
    DTOSaldoCampana dtoS = new DTOSaldoCampana();
    DAOCCC dao  = new DAOCCC();
    RecordSet rs;
    
    rs = dao.obtenerSaldoCampana(dto);
        
    dtoS.setSaldoCampana(rs);
    
    UtilidadesLog.debug("*** Método obtenerSaldoCampana: Salida ***" + dtoS);
    UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSaldoCampana(DTOSaldoCampana dto): Salida");
    return dtoS;
  
  }
  
   private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONInterfaceModulosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONInterfaceModulos"), MONInterfaceModulosHome.class);
  }

  /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * 16/08/2006 - [1] - pperanzola, mejoras para performance
     */
   public DTODetalleCargos obtenerDetalleCargos(DTOOID dto) throws MareException {
     UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDetalleCargos(DTOOID dto): Entrada");
     DTODetalleCargos dtoS = new DTODetalleCargos();
     DAOCCC dao = new DAOCCC();
     RecordSet rs;
     
     //ccc-04 JRIVAS 25/7/2008
     rs = dao.obtenerDatosDetalle(dto.getOidPais(), dto.getOidIdioma(), dto.getOid());
     
     Long oidCliente = rs.getValueAt(0,"OID_CLIE") != null?new Long(((BigDecimal)rs.getValueAt(0,"OID_CLIE")).longValue()):null;        
     Long oidPeriodo = rs.getValueAt(0,"PERD_OID_PERI") != null?new Long(((BigDecimal)rs.getValueAt(0,"PERD_OID_PERI")).longValue()):null;        
     
     //CCC-05 jrivas 6/10/08
     Long oidPeriodoSolicitud = rs.getValueAt(0,"PERIODO_SOLICITUD") != null?new Long(((BigDecimal)rs.getValueAt(0,"PERIODO_SOLICITUD")).longValue()):null;        
     
     dtoS.setCodigoConsultora(rs.getValueAt(0,"COD_CLIE") != null?rs.getValueAt(0,"COD_CLIE").toString():"");
     dtoS.setApenom(rs.getValueAt(0,"APENOM") != null?rs.getValueAt(0,"APENOM").toString():"");
     dtoS.setCampania(rs.getValueAt(0,"CAMPANIA") != null?rs.getValueAt(0,"CAMPANIA").toString():"");
     dtoS.setNumeroConsolidado(rs.getValueAt(0,"NUM_CONSOLIDADO") != null?rs.getValueAt(0,"NUM_CONSOLIDADO").toString():"");
     dtoS.setFechaFacturacion((Date)rs.getValueAt(0,"FECHA_FACTURACION"));
     dtoS.setIndicadorChequeo(rs.getValueAt(0,"IND_CHEQUEO") != null?rs.getValueAt(0,"IND_CHEQUEO").toString():"");
     dtoS.setImporteFletes(rs.getValueAt(0,"IMPORTE_FLETE") != null?rs.getValueAt(0,"IMPORTE_FLETE").toString():"");
     dtoS.setImpuestos(rs.getValueAt(0,"IMPUESTOS") != null?rs.getValueAt(0,"IMPUESTOS").toString():"");
     
     dtoS.setNumeroFactura(dao.obtenerNumeroFactura(dto.getOid()));
     //CCC-05 jrivas 6/10/08
     dtoS.setSaldoPendiente(dao.obtenerSaldoPendiente(dto.getOidPais(), oidCliente, oidPeriodoSolicitud));
     dtoS.setPagosPosteriores(dao.obtenerPagosPosteriores(dto.getOidPais(), oidCliente, oidPeriodo, oidPeriodoSolicitud));
     dtoS.setPagosDiferidos(dao.obtenerPagosDiferidos(dto.getOidPais(), oidCliente, oidPeriodo, oidPeriodoSolicitud));
     Long oidSolicitud = rs.getValueAt(0,"OID_SOLI_CABE") != null?new Long(((BigDecimal)rs.getValueAt(0,"OID_SOLI_CABE")).longValue()):null;        
     UtilidadesLog.debug("OIDSolicitud: " + oidSolicitud);
     dtoS.setDatosLista(dao.obtenerDetalleCargos2(dto,oidSolicitud)); 

     UtilidadesLog.info("MONCuentasCorrientesBean.obtenerDetalleCargos(DTOOID dto): Salida");
       
     return dtoS;

   }
  
  //--Se agrega segun la inc 21425
  //--Paola Cabrera
  //-- 10/11/2005
  private MONActualizarCCporAplicacion getMONActualizarCCporAplicacion() throws MareException {
        
        UtilidadesLog.info("MONCuentasCorrientes.getMONActualizarCCporAplicacion(): Entrada");
        
        MONActualizarCCporAplicacionHome home = (MONActualizarCCporAplicacionHome)UtilidadesEJB.getHome("MONActualizarCCporAplicacion", MONActualizarCCporAplicacionHome.class);


        MONActualizarCCporAplicacion ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en get MONActualizarCCporAplicacionHome",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONCuentasCorrientes.getMONActualizarCCporAplicacion(): Salida");	        
        return ejb;
	}
  
  /**
   * Se actualizan los Movimientos Bancarios a partir de la facturacion.<P>
   * Recibimos un array con movimientos de cuentas corrientes de importe
   * positivo y que se van a cancelar.
   * 
   * @author Ariel Diaz
   * @author Emilio Iraola
   * @date 09/12/2005   
   * @throws MareException
   * Notas:
   *       @eiraola 16/12/2005, metodo agregado segun modelo:
   *       GCC-CCC-001_2005.11.09 GMIOTTI DT
   *       
   *       @jquiroga 14/03/2006 -> Rescritura del metodo, dado que los elementos del DTO de entrada
   *                               pertenecen al mismo pais/empresa. No hace falta agruparlos ni hacer
   *                               tantas consultas a la base de datos.
   *                               
   *       @ssaavedr 25/04/2006 -> Se cambia el cálculo del importeSaldo de MovimientoBancario.
   *                               (Cancelación automática de deuda positiva y negativa.doc)                         
   * 
   *       @pperanzola 19/05/2006 - [1] se modifica según incidencia DBLG500000714
   */
  public void aplicacionAutomaticaDeudaPositivaFacturacion(DTOMovimientoCuentaCompleto[] dtos) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientes.aplicacionAutomaticaDeudaPositivaFacturacion(): Entrada");
      String usuarioActual = ctx.getCallerPrincipal().getName();
      MONCuentasCorrientesLocal moncccLocal = getMONCuentasCorrientesLocal();
      DAOCCC daoCCC = new DAOCCC();
  
      boolean hayImportePositivo = false;
      int longitudDtos = dtos.length; // Cantidad de dtos de entrada
      
      // Recorreremos el array de entrada hasta verificar que haya al menos una cuota positiva para aplicar.
      for (int i = 0; i < longitudDtos; i++) {
          if ( dtos[i].getImporte().doubleValue() > 0 ) {
              hayImportePositivo = true;
              i = longitudDtos;
          }
      }
      
      // Salimos del metodo si no habia importes positivos para procesar.
      if ( !hayImportePositivo ) {
          UtilidadesLog.info("MONCuentasCorrientes.aplicacionAutomaticaDeudaPositivaFacturacion(): Salida 2");	        
          return;
      }         
      
      /*@ssaavedr se modifica segun inc.: BELC300022992
      String proceso = CCCConstantes.PROCESO_MOVIMIENTO_MANUAL;  // TES0002 Recepción de movimientos re recargo manual
      */
      //@ssaavedr, se agrega segun inc.: BELC300022992
      String proceso = CCCConstantes.APLIC_AUTOMATICA_MOV_BANC;  
      
      String subproceso = "1";  // TES002 y 1: Recaudo manual y no aplicado
      Long pais = dtos[0].getOidPais();
     
      //Tomamos únicamente el primer registro y de él extraemos los campos cuentaContable y tipoAbono.     
      DTOSalida cuentaContableDto = daoCCC.obtenerTiposAbonoSubprocesoCContable(pais, proceso, Integer.valueOf(subproceso) ); // Devuelve un único registro y campo
      Long cuentaContable = new Long( ((BigDecimal) cuentaContableDto.getResultado().getValueAt(0,0)).longValue() );
      Long tipoAbono = new Long( ((BigDecimal) cuentaContableDto.getResultado().getValueAt(0,2)).longValue() );
          
      Long oidSubproceso = daoCCC.obtenerOIDSubproceso( pais, proceso,Integer.valueOf(subproceso) );
   
      //@ssaavedr 30/08/2006 en el marco de la inc bloq. ccc 04  ***************************
   		DTOBelcorp dtoBelcorpIdent = new DTOBelcorp();
   		dtoBelcorpIdent.setOidPais(pais);
      dtoBelcorpIdent.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);

      Integer numeroIdentificacion = moncccLocal.obtenerSecuenciaPais(dtoBelcorpIdent);
      
      Byte indicadorEmisionVto = daoCCC.obtenerIndEmisionVtoPais(pais);
      
      String procesoBancos = "CCC002";
      String subprocesoBancos = "2";
      
      Long oidSubprocesoBancos = daoCCC.obtenerOIDSubproceso(pais, procesoBancos,new Integer(subprocesoBancos));
      
      RecordSet marcaSalida = daoCCC.obtenerMarcasTipoAbonoSalida(procesoBancos,new Integer(subprocesoBancos), pais);
      //RecordSet marcasEntrada = daoCCC.obtenerMarcasTipoAbonoEntrada(procesoBancos,new Integer(subprocesoBancos), pais);

 //     Long lngMarcasEntrada = new Long(((BigDecimal) marcasEntrada.getValueAt(0, "TASP_OID_TIPO_ABON_SUBP")).longValue());
      Long lngMarcaSalida = new Long(((BigDecimal) marcaSalida.getValueAt(0, "OID_MARC_SITU")).longValue());
      
      DTOSalida cuentaContableBancos = daoCCC.obtenerTiposAbonoSubprocesoCContable(pais,procesoBancos, new Integer(subprocesoBancos));
      Long tmpTipoAbonoCuentaContable = new Long(((BigDecimal) cuentaContableBancos.getResultado().getValueAt(0,"TCAB_OID_TCAB")).longValue());
      
      
      Long indActualizaCuotaSN = null; 
      
      RecordSet rs;
      rs = this.obtenerDatosSubproceso (procesoBancos,subprocesoBancos,pais);
      if (rs!= null){
          indActualizaCuotaSN = new Long(((BigDecimal)rs.getValueAt(0,"VAL_INDI_ACTU_CUOT")).longValue()) ;
      }
      //*************************************************************************************************

      /* En esta lista guardaremos todos los movimientos que se salden,
         contendrá elementos de la clase DTOMovimientoCuentaCompleto */
      ArrayList movimientosCancelados = new ArrayList(); 

      /* En esta lista guardaremos todos los movimientosBancarios que se salden,
         contendrá elementos de la clase DTOMovimientoBancario */
      ArrayList movimientosBancariosCancelados = new ArrayList();

      // Recorremos el array de cuotas de cancelación que nos ha llegado como parámetro
      double totalACancelar;
      int longitudAntiguos=0;

      RecordSet regsAntiguos=null;
      DAOCuentasCorrientes daoCuentasCorri=null;
      if(longitudDtos>0) {
        daoCuentasCorri = new DAOCuentasCorrientes(usuarioActual);        
        regsAntiguos = daoCuentasCorri.obtenerMovBancarios(dtos[0].getOidPais(), dtos[0].getOidCliente(),dtos[0].getEmpresa());
        
        UtilidadesLog.debug("obtenerMovBancarios....: " + regsAntiguos);
        longitudAntiguos = regsAntiguos.getRowCount();
      }

      for (int i = 0; i < longitudDtos; i++) { //(1)   
          /* Quitamos el signo negativo al importe del movimiento */
          totalACancelar   = Math.abs( dtos[i].getImporte().doubleValue() );
          UtilidadesLog.debug("totalACancelar..: " + totalACancelar);
          
          DTOOIDs dtoOIDs = new DTOOIDs();
          if(longitudAntiguos > 0) { /* Comprobar Bloqueo */
              /* Construimos un array de OIDs con la columna de los OIDs del 
                 DTOSalida.recordset y lo envolvemos en un DTOOIDs (dtoOIDs) */
              Long[] columnaOid = new Long[longitudAntiguos];
              for (int j = 0; j < longitudAntiguos; j++) {
                  columnaOid[j] = new Long (((BigDecimal)
                      regsAntiguos.getValueAt(j, "OID_MOVI_CC")).longValue());
              }
              dtoOIDs.setOids(columnaOid);
              
              if( ! this.bloquearMovBanc(dtoOIDs).booleanValue() ) {
                  UtilidadesLog.debug("aplicacionAutomaticaDeudaPositiva: " + 
                      "Algunos Movimientos están bloqueados por otros usuarios");
                  throw new MareException(new Exception(),
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,
                          ErroresDeNegocio.CCC_0049));
              }
              try {
                  this.bloquearBloqueoMovBanc();
              } catch (RemoteException re) {
                  this.loguearError(re);
                  throw new MareException(re,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }
          }
          
          for(int j = 0; j < longitudAntiguos; j++) { //(2)
              double parcialACancelar = 0;
             
              /* Registro actual de Movimiento Bancario:
                                Fila j del RecordSet que lee CCC_MOVIM_BANCA */
              DTOMovimientoBancario dtoCancelar = new DTOMovimientoBancario();
              
              UtilidadesLog.debug("comienzo a cargar el dtoCancelar....");
              
              dtoCancelar.setAnioDocumentoAplicacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_APLI_ANIO") != null)
                      ? (String) regsAntiguos.getValueAt(j, "VAL_DOCU_APLI_ANIO")
                      : null ); 
              dtoCancelar.setAnioDocumentoCreacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_CREA_ANIO") != null)
                      ? (String) regsAntiguos.getValueAt(j, "VAL_DOCU_CREA_ANIO")
                      : null );
              dtoCancelar.setCodConsultoraReal(
                  (regsAntiguos.getValueAt(j, "COD_CONS") != null)
                      ? (String) regsAntiguos.getValueAt(j, "COD_CONS")
                      : null );
              dtoCancelar.setCodError(
                  (regsAntiguos.getValueAt(j, "COD_ERRO") != null)
                      ? (String) regsAntiguos.getValueAt(j, "COD_ERRO")
                      : null );
              dtoCancelar.setCodigoUsuario(
                  (regsAntiguos.getValueAt(j, "COD_USUA") != null)
                      ? (String) regsAntiguos.getValueAt(j, "COD_USUA")
                      : null );
              dtoCancelar.setConsecutivoTransaccion(
                  (regsAntiguos.getValueAt(j, "NUM_CONS_TRAN") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "NUM_CONS_TRAN")).longValue())
                      : null );
              dtoCancelar.setCuentaCorrienteBancaria(
                  new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                      "CCBA_OID_CC_BANC")).longValue()));
              dtoCancelar.setDigitoChequeo(
                  (regsAntiguos.getValueAt(j, "VAL_DIGI_CHEQ_FACT") != null)
                      ? new Integer(((BigDecimal) regsAntiguos.getValueAt(j,
                          "VAL_DIGI_CHEQ_FACT")).intValue())
                      : null );
              dtoCancelar.setEmpresa(
                  new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                      "SOCI_OID_SOCI")).longValue()));
              dtoCancelar.setEstatusMovimientoTesoreria(  
                  (regsAntiguos.getValueAt(j, "VAL_ESTA_MOVI_PEND") != null)
                      ? new Character(((String) regsAntiguos.getValueAt(j,
                          "VAL_ESTA_MOVI_PEND")).charAt(0))
                      : null );
              dtoCancelar.setFechaContabilizacion(
                  (regsAntiguos.getValueAt(j, "FEC_CONT") != null)
                      ? (Date) regsAntiguos.getValueAt(j,
                          "FEC_CONT")
                      : null );
              dtoCancelar.setFechaMovimientoAplicacion(
                  (regsAntiguos.getValueAt(j, "FEC_MOVI_APLI") != null)
                      ? new Timestamp(((Date) regsAntiguos.getValueAt(j,
                          "FEC_MOVI_APLI")).getTime())
                      : null );
              dtoCancelar.setFechaPago(
                  (regsAntiguos.getValueAt(j, "FEC_PAGO") != null)
                      ? (Date) regsAntiguos.getValueAt(j,
                          "FEC_PAGO")
                      : null );
              dtoCancelar.setHorario(
                  (regsAntiguos.getValueAt(j, "VAL_HORA_NORM_ADIC") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_HORA_NORM_ADIC")
                      : null );
              dtoCancelar.setIdentificadorProceso(
                  (regsAntiguos.getValueAt(j, "COD_IDEN_PROC") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "COD_IDEN_PROC")
                      : null );
              dtoCancelar.setImporteAplicado(
                  (regsAntiguos.getValueAt(j, "IMP_APLI") != null)
                      ? (BigDecimal) regsAntiguos.getValueAt(j,
                          "IMP_APLI")
                      : new BigDecimal(0) );   //le clavaba un null
              dtoCancelar.setImporteMovimiento(
                  (regsAntiguos.getValueAt(j, "VAL_IMPO_MOVI") != null)
                      ? (BigDecimal) regsAntiguos.getValueAt(j,
                          "VAL_IMPO_MOVI")
                      : new BigDecimal(0) );  //le clavaba un null
              dtoCancelar.setImportePago(
                  (regsAntiguos.getValueAt(j, "IMP_PAGO") != null)
                      ? (BigDecimal) regsAntiguos.getValueAt(j,
                          "IMP_PAGO")
                      : new BigDecimal(0) );  //le clavaba un null
              dtoCancelar.setImporteSaldo(
                  (regsAntiguos.getValueAt(j, "IMP_SALD_PEND") != null)
                      ? (BigDecimal) regsAntiguos.getValueAt(j,
                          "IMP_SALD_PEND")
                      : null );
              dtoCancelar.setNombreOficina(
                  (regsAntiguos.getValueAt(j, "VAL_NOMB_OFIC") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_NOMB_OFIC")
                      : null );
              dtoCancelar.setNumeroCupon(
                  (regsAntiguos.getValueAt(j, "NUM_CUPO") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "NUM_CUPO")).longValue())
                      : null );
              dtoCancelar.setNumeroDocumentoAplicacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_APLI_NUME") != null)
                      ? new Integer(((BigDecimal) regsAntiguos.getValueAt(j,
                          "VAL_DOCU_APLI_NUME")).intValue())
                      : null );
              dtoCancelar.setNumeroDocumentoCreacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_CREA_NUME") != null)
                      ? new Integer(((BigDecimal) regsAntiguos.getValueAt(j,
                          "VAL_DOCU_CREA_NUME")).intValue())
                      : null );
              dtoCancelar.setNumeroFactura(
                  (regsAntiguos.getValueAt(j, "NUM_FACT_BOLE") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "NUM_FACT_BOLE")).longValue())
                      : null );
              dtoCancelar.setNumeroHistoria(
                  (regsAntiguos.getValueAt(j, "NUM_HIST") != null)
                      ? new Integer(((BigDecimal) regsAntiguos.getValueAt(j,
                          "NUM_HIST")).intValue())
                      : null );
              dtoCancelar.setNumeroLote(
                  (regsAntiguos.getValueAt(j, "NUM_LOTE") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "NUM_LOTE")).longValue())
                      : null );
              dtoCancelar.setNumeroLoteContabilizacion(
                  (regsAntiguos.getValueAt(j, "VAL_NUME_LOTE_CONT") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_NUME_LOTE_CONT")
                      : null );
              dtoCancelar.setObservaciones(
                  (regsAntiguos.getValueAt(j, "VAL_OBSE") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_OBSE")
                      : null );
              dtoCancelar.setOficinaRecaudadora(
                  (regsAntiguos.getValueAt(j, "COD_OFIC_RECA") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "COD_OFIC_RECA").toString()
                      : null );
              dtoCancelar.setOid(
                  new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                      "OID_MOVI_BANC")).longValue()));
              dtoCancelar.setOidConsultoraReal(
                  (regsAntiguos.getValueAt(j, "CLIE_OID_CLIE") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "CLIE_OID_CLIE")).longValue())
                      : null );
              dtoCancelar.setOidSubprocesoMarcaUltimo(
                  (regsAntiguos.getValueAt(j, "SUBP_OID_MARC_ULTI") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "SUBP_OID_MARC_ULTI")).longValue())
                      : null );
              dtoCancelar.setOidTipoAbonoUltimo(
                  (regsAntiguos.getValueAt(j, "TCAB_OID_ABON_ULTI") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "TCAB_OID_ABON_ULTI")).longValue())
                      : null );
              dtoCancelar.setSerieDocumentoAplicacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_APLI_MES_SERI") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_DOCU_APLI_MES_SERI")
                      : null );
              dtoCancelar.setSerieDocumentoCreacion(
                  (regsAntiguos.getValueAt(j, "VAL_DOCU_CREA_MES_SERI") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_DOCU_CREA_MES_SERI")
                      : null );
              dtoCancelar.setSubacceso(
                  (regsAntiguos.getValueAt(j, "SBAC_OID_SBAC") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "SBAC_OID_SBAC")).longValue())
                      : null );
              dtoCancelar.setTipoTransaccion(
                  (regsAntiguos.getValueAt(j, "TTRA_OID_TIPO_TRANS") != null)
                      ? new Long(((BigDecimal) regsAntiguos.getValueAt(j,
                          "TTRA_OID_TIPO_TRANS")).longValue())
                      : null );
              dtoCancelar.setUsuarioProceso(
                  (regsAntiguos.getValueAt(j, "VAL_USUA_PROC") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_USUA_PROC")
                      : null );
              
              
              if (totalACancelar > dtoCancelar.getImporteSaldo().longValue()) {
                    totalACancelar -= dtoCancelar.getImporteSaldo().longValue();
                    parcialACancelar = dtoCancelar.getImporteSaldo().longValue();
              } else {
                    parcialACancelar = totalACancelar;
                    totalACancelar = 0;
              }
              
              // Actualizar el Movimiento Bancario con la Cuota de Cancelación (parámetro dtos[i])
              dtoCancelar.setImporteMovimiento( new BigDecimal(
                      Double.toString(parcialACancelar)) );
              dtoCancelar.setImporteAplicado( new BigDecimal( Double.toString(
                      dtoCancelar.getImporteAplicado().longValue() +
                      dtoCancelar.getImporteMovimiento().longValue())) );
                      
              //@ssaavedr 24/04/2006, quitado por cbios. P2 E.Arese        
              /*
              dtoCancelar.setImporteSaldo( new BigDecimal( Double.toString(
                      parcialACancelar -
                      dtoCancelar.getImporteAplicado().longValue())) );
              */
              dtoCancelar.setImporteSaldo(new BigDecimal( Double.toString(
                      dtoCancelar.getImportePago().longValue() -
                      dtoCancelar.getImporteAplicado().longValue())));
              
              dtoCancelar.setOidSubprocesoMarcaUltimo(oidSubproceso);
              dtoCancelar.setNumeroHistoria( new Integer(
                      (dtoCancelar.getNumeroHistoria().intValue()) + 1) );
              dtoCancelar.setCodigoUsuario(ctx.getCallerPrincipal().getName());
              
              UtilidadesLog.debug("se agrega a movimientosBancariosCancelados. el dto a cancelar: " + dtoCancelar);
              movimientosBancariosCancelados.add(dtoCancelar);
              
              //@ssaavedr 30/08/2006 en el marco de la inc bloq. ccc 04    
              UtilidadesLog.debug("se actualizarCuotasCancelacion, desde aplic auto fact., con: " + dtos[i] + "-" + 
                                   parcialACancelar + "-" + indicadorEmisionVto.toString() + "-" + tipoAbono + 
                                   "-" + lngMarcaSalida + "-" + numeroIdentificacion + "-" + oidSubprocesoBancos + "-" + 
                                   cuentaContable + "-" + indActualizaCuotaSN);
              this.actualizarCuotasCancelacion(dtos[i], // DTOMovimientoCuentaCompleto
                        (parcialACancelar * -1), // [2] bParcialACancelar, // BIGDECIMAL
                        indicadorEmisionVto.toString(), // STRING
                        tipoAbono, // LONG
                        lngMarcaSalida, // LONG
                        numeroIdentificacion, // INTEGER
                        oidSubprocesoBancos, // LONG											
                        cuentaContable,//lngCuentaContable,
                        indActualizaCuotaSN, /*[1]*/
                        tmpTipoAbonoCuentaContable); // LONG              
              //**************************************************************************
              
              if (totalACancelar == 0) {
                  break;
              } 
            
          } // fin del for //(2)
      
          /* Eliminamos los registros de las tablas de bloqueo y de esta manera
             liberamos dichos registros y el acceso a las tablas para otros
             usuarios */             
          if(longitudAntiguos > 0) {                  
              this.eliminarBloqueoMovBanc(dtoOIDs);              
          }
       
          /* Actualizar los datos del dto */
          int longitudMovBancCancelados = movimientosBancariosCancelados.size();
          dtos[i].setMovimientosBancariosCancelados(
              (DTOMovimientoBancario[]) movimientosBancariosCancelados.toArray(
                  new DTOMovimientoBancario[longitudMovBancCancelados]));

          if(longitudMovBancCancelados > 0) {
              movimientosCancelados.add(dtos[i]); 
          }
      } // fin del for (1) 
      
        /*
         * Se agrupan los DTOs DTOMovimientoCuentaCompleto contenidos en 
         * movimientosCancelados" segun pais y empresa.
         * Convertimos el ArrayList "movimientosCancelados" a un array "movCanc" */
        DTOMovimientoCuentaCompleto[] movCanc = (DTOMovimientoCuentaCompleto[])
          movimientosCancelados.toArray( 
              new DTOMovimientoCuentaCompleto[movimientosCancelados.size()] );
        /* Se agrupan los DTOs DTOMovimientoCuentaCompleto contenidos en 
         "movimientosCancelados" segun pais y empresa. */
        /**
        * Implementación del Agrupamiento por Pais y Empresa para un array
        * de DTOMovimientoCuentaCompleto.
        * Entrada: DTOMovimientoCuentaCompleto[] movCanc
        * Salida: DTOMovimientoCuentaCompleto[] movCancPorPaisEmpresa
        * @eiraola 27/12/2005
        */
        
        int cantidadDtos = movCanc.length;
        int cantidadAgrupaciones = 0;
        int cantidadAgregada = 0;
        
        Long claveEmpresa = null;
        
        ArrayList agrupaciones = new ArrayList();
        ArrayList agrupacionActual;
        ArrayList nuevaAgrupacion;
        
        DTOMovimientoCuentaCompleto[] movCancPorPaisEmpresa = new DTOMovimientoCuentaCompleto[cantidadDtos];
        DTOMovimientoCuentaCompleto dtoActual = null;
        DTOMovimientoCuentaCompleto nuevoDto = null;
        
        
        if (cantidadDtos > 0) { //Agrupamos el primer elemento: movCanc[0]
          nuevaAgrupacion = new ArrayList();
          nuevaAgrupacion.add(movCanc[0]);
          cantidadAgregada++;
          agrupaciones.add(nuevaAgrupacion);
          cantidadAgrupaciones++;
        }
        
        boolean agregado = false;
        
        for (int i = 1; i < cantidadDtos; i++) {
          claveEmpresa = movCanc[i].getEmpresa();
          nuevoDto = movCanc[i];
          cantidadAgrupaciones = agrupaciones.size();
        
          agregado = false;
          for (int j = 0; j < cantidadAgrupaciones; j++) { //Recorremos agrupaciones
              // Leemos el primer elemento de cada agrupacion para ver 
              // la empresa coincide con el que queremos clasificar (el pais es el mismo para un consolidado)
              agrupacionActual = (ArrayList) agrupaciones.get(j);
              dtoActual = (DTOMovimientoCuentaCompleto) agrupacionActual.get(0);
            
              if ( dtoActual.getEmpresa().compareTo(claveEmpresa) == 0) {
                  agrupacionActual.add(nuevoDto);
                  cantidadAgregada++;
                  agregado = true;
                  break; // Si ya agregamos a la agrupación dejamos de recorrer las mismas
              } else {
                  // Si la agrupacion no correspondía no hacemos nada     
              }
          }
          if (!agregado) { // Si era una nueva agrupacion
               nuevaAgrupacion = new ArrayList();
               nuevaAgrupacion.add(nuevoDto);
               cantidadAgregada++;
               agrupaciones.add(nuevaAgrupacion);   
          }
          agregado = false; //Reinicializamos la bandera
        }
        
        //Recorremos nuestro ArrayList de agrupaciones para crear un array plano
        Iterator itAgrupaciones = agrupaciones.iterator();
        
        int indice = 0;
        agrupacionActual = null;
        Iterator itAgrupacionActual = null;
        
        while (itAgrupaciones.hasNext()) {
          agrupacionActual = (ArrayList) itAgrupaciones.next();
          itAgrupacionActual = agrupacionActual.iterator();
          while (itAgrupacionActual.hasNext()) {
              movCancPorPaisEmpresa[indice] = (DTOMovimientoCuentaCompleto) itAgrupacionActual.next();
              indice++;
          }
          agrupacionActual = null;
          itAgrupacionActual = null;
        } 
        
        /* El array de DTOMovimientoCuentaCompleto ordenado está listo
           se sabe que cambia de agrupacion cuando cambia el pais-empresa
           actual respecto del anterior */
        /*
        * FIN de Implementación del Agrupamiento por Pais y Empresa
        */
              
      /* Recorremos las agrupaciones de dto (DTOMovimientoCuentaCompleto) por Pais-Empresa */
      boolean cambiaAgrupacion = true;
      boolean esPrimerDto = false; // bandera para reconocer al 1er. dto como de una agrupacion nueva
      boolean cabeceraNueva = false; // bandera para saber si a los dto de un agrupamiento hay que agregarles los datos de la nueva cabecera creada con el primero del grupo
      Long paisActual;
      Long empresaActual;
      Long paisAnterior = null;
      Long empresaAnterior = null;
      int numeroLinea = 0;
      //Variables necesarias para el create Cabecera
      CabeceraCargosAbonosDirectosLocalHome homeCCAD;
      CabeceraCargosAbonosDirectosLocal localCCAD = null;
      DTOBelcorp dtoBelcorp;
      Integer numero;
      String anio;
      String periodoMes;
      java.util.Date fechaSistema;
      Date fechaDocumento; // java.sql.Date
      Date fechaValor; // java.sql.Date
      Long oidProceso = null;
      ProcesosLocalHome homeP;
      ProcesosLocal localP;
      String codigoUsuario;
      //Variables necesarias para el create Detalle
      int cantidadMovBancCancEnDto;
      DTOMovimientoBancario[] dtoMovimientoBancario;        
      DetalleCargosAbonosDirectosLocalHome homeDCAD;
      DetalleCargosAbonosDirectosLocal localDCAD;
      homeCCAD = this.getCabeceraCargosAbonosDirectosLocalHome();

      if (cantidadDtos > 0) {
          //Obtenemos el oidProceso
          homeP = this.getProcesosLocalHome();
          try {
              localP = homeP.findByUk(pais, "CCC001");
              oidProceso = localP.getOid();
          } catch (NoResultException fe) {
              ctx.setRollbackOnly();
              UtilidadesLog.debug("finderException al obtener proceso CCC001");
              this.loguearError(fe);
              String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
              throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
          }

          // Para el primer dto marcamos la bandera 'esPrimerDto' de modo de que se cree la Cabecera 
          // sin haber tenido un pais y empresa "anterior" con los cuales comparar
          esPrimerDto = true;
          paisAnterior = movCancPorPaisEmpresa[0].getOidPais();
          empresaAnterior = movCancPorPaisEmpresa[0].getEmpresa();
     
          for (int i = 0; i < cantidadDtos; i++) {  // Recorremos todos los dto //Para (3)
              UtilidadesLog.debug("GA - For para insertar los cargos y abonos. Valor de i: "+i);
              dtoActual = movCancPorPaisEmpresa[i];
              UtilidadesLog.debug("GA - dtoActual: "+dtoActual);
              paisActual = dtoActual.getOidPais();
              empresaActual = dtoActual.getEmpresa();
                
              //Si estamos en el PRIMER dto de una nueva agrupación o es el primero  de todos
              if ( ( (paisActual.compareTo(paisAnterior) != 0) && 
                     (empresaActual.compareTo(empresaAnterior) != 0) )
                   || esPrimerDto ) {
                   UtilidadesLog.debug("GA - Cambio de agrupacion ");
                  esPrimerDto = false;
                  cabeceraNueva = false; // Reinicializamos la bandera al entrar a un nuevo agrupamiento
                    
                  // Se tomara uno de los DTOs de la agrupacion para trabajar sobre sus datos:
                  
                  //  Si la cabecera ya existía
                  if (dtoActual.getOidCargoAbono() != null) { //[1]if (dtoActual.getOid() != null) {
                      UtilidadesLog.debug("GA - La cabecera ya existia");
                      cabeceraNueva = false;
                      numeroLinea = daoCCC.obtenerUltimoDetalleCargosAbonos(
                          movCancPorPaisEmpresa[i].getOidCargoAbono()).intValue();//[1] movCancPorPaisEmpresa[i].getOid()).intValue();
                      localCCAD = null;
                      try {
                            UtilidadesLog.debug("GA - findByPrimaryKey ("+movCancPorPaisEmpresa[i].getOidCargoAbono()+")");
                            localCCAD = homeCCAD.findByPrimaryKey(
                            movCancPorPaisEmpresa[i].getOidCargoAbono()); //[1] movCancPorPaisEmpresa[i].getOid());
                            UtilidadesLog.debug("GA - Lo Encontre");
                      } catch (NoResultException fe) {
                          ctx.setRollbackOnly();  
                          UtilidadesLog.debug("Metodo generarCuentaCorriente: error -----> finderException");
                          this.loguearError(fe);
                          String codigoError = 
                              CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                          throw new MareException(fe,
                              UtilidadesError.armarCodigoError(codigoError));
                      }
                        
                  // Si debe crearse la cabecera
                  } else {
                      UtilidadesLog.debug("GA - Debe crearse la cabecera");
                      cabeceraNueva = true;
                        //Se realiza un create sobre la Entidad CCC: CabeceraCargosAbonosDirectos
                      // Numero de cabecera
                      dtoBelcorp = new DTOBelcorp();
                      dtoBelcorp.setOidPais(pais);
                      if ( movCancPorPaisEmpresa[0].getOidIdioma() != null ) {
                          dtoBelcorp.setOidIdioma(movCancPorPaisEmpresa[0].getOidIdioma());    
                      } else {
                          dtoBelcorp.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                      }
                      //numero = daoCCC.obtenerSecuenciaPais(dtoBelcorp);
                      numero = moncccLocal.obtenerSecuenciaPais(dtoBelcorp);
                      // Anio, PeriodoMes, FechaDocumento y FechaValor de la fecha del sistema
                      fechaSistema = new java.util.Date(System.currentTimeMillis());
                      fechaDocumento = new Date(System.currentTimeMillis()); // java.sql.Date
                      fechaValor = fechaDocumento; // java.sql.Date
                      UtilidadesLog.debug("fechaDocumento = "+ fechaDocumento);
                      try {
                          anio = UtilidadesFecha.convertirAString(fechaSistema, "yy");
                          periodoMes = UtilidadesFecha.convertirAString(fechaSistema, "MM");
                      } catch (ParseException e) {
                          throw new MareException(e,
                          UtilidadesError.armarCodigoError(
                              CodigosError.ERROR_DE_FORMATO_FECHA));
                      }
                      UtilidadesLog.debug("anio = "+anio);
                      UtilidadesLog.debug("periodoMes = "+ periodoMes);
                      
                      // Usuario
                      codigoUsuario = movCancPorPaisEmpresa[0].getUsuario();
                      
                      try {
                          UtilidadesLog.debug("*** Se realiza el create en CabeceraCargosAbonosDirectos ***");
                          localCCAD = homeCCAD.create(numero, //Integer
                                                      anio, //String
                                                      periodoMes, //String
                                                      fechaDocumento, //Date
                                                      pais, //Long
                                                      claveEmpresa, //Long
                                                      codigoUsuario, //String
                                                      fechaValor, //Date
                                                      oidProceso); //Long
                      } catch (PersistenceException e) {
                          this.loguearError(e);
                          ctx.setRollbackOnly();
                          String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(e,
                              UtilidadesError.armarCodigoError(codigoError));
                      }
                      
                      /* La variable numeroLinea se reinicializara cada vez que se
                       cambie de agrupacion, para mantener una secuencia de detalles
                       para cada cabecera. */
                      numeroLinea = 0;  
                      
                  } // fin del if que verifica la existencia previa de cabecera
                    
                } // fin del if que verifica si es el primer dto de un agrupamiento
                
                if (cabeceraNueva) {
                    /* Solamente si el dto pertenece a un agrupamiento que no tenia
                       CabeceraCargosAbonosDirectos: */
                
                    /* - Se asigna el nuevo Oid de Cabecera a los Dtos del
                         agrupamiento Pais-Empresa */
                    movCancPorPaisEmpresa[i].setOidCargoAbono(localCCAD.getOid());//[1] movCancPorPaisEmpresa[i].setOid(localCCAD.getOid());
                    /* - Se asigna el numero de Documento de la Cabecera a los
                         Dtos del agrupamiento */
                    movCancPorPaisEmpresa[i].setDocumentoNumero(
                        localCCAD.getNumero());
                    /* - Se asigna el numero de Ultimo Documento a los Dtos del
                         agrupamiento */
                    movCancPorPaisEmpresa[i].setUltimoDocumentoNumero(
                        movCancPorPaisEmpresa[i].getDocumentoNumero());
                } 
                
                // Para cada dtos[i] en la agrupacion, se toma el atributo dtos[i].movimientosBancariosCancelados
                dtoMovimientoBancario = movCancPorPaisEmpresa[i].getMovimientosBancariosCancelados();
                cantidadMovBancCancEnDto = dtoMovimientoBancario.length;
                
                /* Generamos un registro para cada movimiento bancario a cancelar,
                   en DetalleCargosAbonosDirectos */ //Para (4)
                for (int j = 0; j < cantidadMovBancCancEnDto; j++) { 
                    /* Se realiza un create sobre la Entidad CCC: DetalleCargosAbonosDirectos */
                    homeDCAD = this.getDetalleCargosAbonosDirectosLocalHome();
                    localDCAD = null;
                    dtoMovimientoBancario[j].setOidPais(pais);
                    try {
                        UtilidadesLog.debug("*** se crea dcad, con dto: " + dtoMovimientoBancario[j]);
                        localDCAD = homeDCAD.create(localCCAD.getOid(), //movCancPorPaisEmpresa[i].getOidCargoAbono(),// [1] dtoMovimientoBancario[j].getOid(), //Long cabecera
                            dtoMovimientoBancario[j].getOidConsultoraReal(), //Long consultora
                            new Integer(++numeroLinea), //Integer numeroLinea (de 1 a n)
                            new Integer((dtoMovimientoBancario[j].
                                getNumeroHistoria().intValue()) + 1), //Integer numeroHistoriaGenera
                            localCCAD.getFechaDocumento(), //Date fechaMovimiento
                            new BigDecimal("0"), //BigDecimal importeMoneda
                            dtoMovimientoBancario[j].getImporteMovimiento(), //BigDecimal importe
                            null, null, null, //referenciaNumeroDocumento, observaciones, glosaContable
                            null, //moneda
                            dtoMovimientoBancario[j].getOid(), //Long movimientoBancario
                            movCancPorPaisEmpresa[i].getMedioPago(), //Long medioPago
                            cuentaContable, //Long cuotaAnterior
                            cuentaContable, //Long cuotaNueva
                            null, //movimiento
                            null, //cuentaCorriente
                            null, //fechaPagoEnBancos
                            dtoMovimientoBancario[j].getCodigoUsuario(), //String codigoUsuario
                            dtoMovimientoBancario[j].getEmpresa(), //Long empresa
                            tipoAbono); //Long tipoAbonoSubproceso
                    } catch (PersistenceException e) {
                        ctx.setRollbackOnly();
                        this.loguearError(e);
                        String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(codigoError));
                    }      
                      
                    /* Se asignan valores desde la cabecera correspondiente */
                    dtoMovimientoBancario[j].setSerieDocumentoAplicacion(localCCAD.getPeriodoMes());
                    dtoMovimientoBancario[j].setAnioDocumentoAplicacion(localCCAD.getAnio());
                    dtoMovimientoBancario[j].setNumeroDocumentoAplicacion(localCCAD.getNumero());
                    dtoMovimientoBancario[j].setFechaMovimientoAplicacion(localCCAD.getFechaDocumento());
                    this.actualizarMovBancario(dtoMovimientoBancario[j]);
                    
                } // fin (4) del for 'j' que recorre los MovimientosBancariosCancelados de cada dto
                
          } // fin (3) del for 'i' que recorre todos los dto (de movCancPorPaisEmpre[])

          this.grabarHistoricosMovimientosBancarios(historicosMovimientosBancario);    
      }        
      UtilidadesLog.info("MONCuentasCorrientes.aplicacionAutomaticaDeudaPositivaFacturacion(): Salida 1");	        
  }


  /**
   * Obtiene la interfaz home de la entidad Procesos.
   */
  private ProcesosLocalHome getProcesosLocalHome() throws MareException {
    UtilidadesLog.info("MONCuentasCorrientesBean.getProcesosLocalHome(): Entrada");    
    UtilidadesLog.info("MONCuentasCorrientesBean.getProcesosLocalHome(): Salida");
    return new ProcesosLocalHome();
  }

  /**
   * Obtiene la interfaz home de este mismo MON.
   * 
   * @author Gaston Acevedo
   * @date 02/02/2006
   * @return MONCuentasCorrientesLocal 
   * @throws MareException
   * Notas:
   *        Se usa en performance
   *   
   */
  private MONCuentasCorrientesLocal getMONCuentasCorrientesLocal() throws MareException
  {
    UtilidadesLog.info("MONCuentasCorrientesBean.getMONCuentasCorrientesLocal(): Entrada");
    MONCuentasCorrientesLocalHome home = (MONCuentasCorrientesLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONCuentasCorrientes");
    MONCuentasCorrientesLocal salida = null;
    try
    {
      salida = home.create();  
    }catch (Exception e) {
      			UtilidadesLog.error("*** Error en getMONCuentasCorrientesLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONCuentasCorrientesBean.getMONCuentasCorrientesLocal(): Salida");
    return salida;
  }  
  
  private MONAsignacionCarteraPeriodoHome getMONAsignacionCarteraPeriodoHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONAsignacionCarteraPeriodoHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONAsignacionCarteraPeriodo"), MONAsignacionCarteraPeriodoHome.class);
    }    

    public DTOSalida obtenerCuentasCorrientesBancarias(DTOBelcorp dtoE) throws MareException
    {
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerCuentasCorrientesBancarias(DTOBelcorp dto): Entrada");

        String usuario = ctx.getCallerPrincipal().getName();
        DTOSalida dtoSalida = (new DAOCuentasCorrientes(usuario)).obtenerCuentasCorrientesBancarias(dtoE);
        UtilidadesLog.info("MONCuentasCorrientesBean.obtenerCuentasCorrientesBancarias(DTOBelcorp dto): Salida");
        
        return dtoSalida;
    }
    
    private DTOMovimientoBancario copiarDTOMovimientoBancario(DTOMovimientoBancario toClone)
    {
        UtilidadesLog.info("MONCuentasCorrientesBean.copiarDTOMovimientoBancario(DTOMovimientoBancario toClone): Entrada");
        DTOMovimientoBancario dtoResu = new DTOMovimientoBancario();
        dtoResu.setAnioDocumentoAplicacion(toClone.getAnioDocumentoAplicacion());
        dtoResu.setAnioDocumentoCreacion(toClone.getAnioDocumentoCreacion());
        dtoResu.setCodConsultoraReal(toClone.getCodConsultoraReal());
        dtoResu.setCodError(toClone.getCodError());
        dtoResu.setCodigoUsuario(toClone.getCodigoUsuario());
        dtoResu.setConsecutivoTransaccion(toClone.getConsecutivoTransaccion());
        dtoResu.setCuentaCorrienteBancaria(toClone.getCuentaCorrienteBancaria());
        dtoResu.setDigitoChequeo(toClone.getDigitoChequeo());
        dtoResu.setEmpresa(toClone.getEmpresa());
        dtoResu.setEstatusMovimientoTesoreria(toClone.getEstatusMovimientoTesoreria());
        dtoResu.setFechaContabilizacion(toClone.getFechaContabilizacion());
        dtoResu.setFechaMovimientoAplicacion(toClone.getFechaMovimientoAplicacion());
        dtoResu.setFechaPago(toClone.getFechaPago());
        dtoResu.setHorario(toClone.getHorario());
        dtoResu.setIdentificadorProceso(toClone.getIdentificadorProceso());
        dtoResu.setImporteAplicado(toClone.getImporteAplicado());
        dtoResu.setImporteMovimiento(toClone.getImporteMovimiento());
        dtoResu.setImportePago(toClone.getImportePago());
        dtoResu.setImporteSaldo(toClone.getImporteSaldo());
        dtoResu.setIndConfirmaMovimientoManual(toClone.getIndConfirmaMovimientoManual());
        dtoResu.setNombreOficina(toClone.getNombreOficina());
        dtoResu.setNumeroCupon(toClone.getNumeroCupon());
        dtoResu.setNumeroDocumentoAplicacion(toClone.getNumeroDocumentoAplicacion());
        dtoResu.setNumeroDocumentoCreacion(toClone.getNumeroDocumentoCreacion());
        dtoResu.setNumeroFactura(toClone.getNumeroFactura());
        dtoResu.setNumeroHistoria(toClone.getNumeroHistoria());
        dtoResu.setNumeroLote(toClone.getNumeroLote());
        dtoResu.setNumeroLoteContabilizacion(toClone.getNumeroLoteContabilizacion());
        dtoResu.setObservaciones(toClone.getObservaciones());
        dtoResu.setOficinaRecaudadora(toClone.getOficinaRecaudadora());
        dtoResu.setOid(toClone.getOid());
        dtoResu.setOidConsultoraReal(toClone.getOidConsultoraReal());
        dtoResu.setOidMovimientoCaja(toClone.getOidMovimientoCaja());
        dtoResu.setOidSubprocesoMarcaCreacion(toClone.getOidSubprocesoMarcaCreacion());
        dtoResu.setOidSubprocesoMarcaUltimo(toClone.getOidSubprocesoMarcaUltimo());
        dtoResu.setOidTipoAbonoCreacion(toClone.getOidTipoAbonoCreacion());
        dtoResu.setOidTipoAbonoUltimo(toClone.getOidTipoAbonoUltimo());
        dtoResu.setSerieDocumentoAplicacion(toClone.getSerieDocumentoAplicacion());
        dtoResu.setSerieDocumentoCreacion(toClone.getSerieDocumentoCreacion());
        dtoResu.setSubacceso(toClone.getSubacceso());
        dtoResu.setTipoTransaccion(toClone.getTipoTransaccion());
        dtoResu.setUsuarioProceso(toClone.getUsuarioProceso());

        UtilidadesLog.info("MONCuentasCorrientesBean.copiarDTOMovimientoBancario(DTOMovimientoBancario toClone): Salida");
        
        return null;
    }

    private DTOMovimientoCuentaCompleto copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone)
    {
        UtilidadesLog.info("MONCuentasCorrientesBean.copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone): Entrada");
        DTOMovimientoCuentaCompleto dtoResu = new DTOMovimientoCuentaCompleto();
        dtoResu.setCuentaCuota(toClone.getCuentaCuota());
        dtoResu.setCuentaOrigen(toClone.getCuentaOrigen());
        dtoResu.setDivisa(toClone.getDivisa());
        dtoResu.setDocumentoAnyo(toClone.getDocumentoAnyo());
        dtoResu.setDocumentoMesSerie(toClone.getDocumentoMesSerie());
        dtoResu.setDocumentoNumero(toClone.getDocumentoNumero());
        dtoResu.setEjercicioCuota(toClone.getEjercicioCuota());
        dtoResu.setEmpresa(toClone.getEmpresa());
        dtoResu.setFechaContabilizacion(toClone.getFechaContabilizacion());
        dtoResu.setFechaDocumento(toClone.getFechaDocumento());
        dtoResu.setFechaUltimoMovimiento(toClone.getFechaUltimoMovimiento());
        dtoResu.setFechaValor(toClone.getFechaValor());
        dtoResu.setFechaVencimiento(toClone.getFechaVencimiento());
        dtoResu.setImporte(toClone.getImporte());
        dtoResu.setImporteDivisa(toClone.getImporteDivisa());
        dtoResu.setImporteMovimiento(toClone.getImporteMovimiento());
        dtoResu.setImporteMovimientoDivisa(toClone.getImporteMovimientoDivisa());
        dtoResu.setImportePagado(toClone.getImportePagado());
        dtoResu.setImportePagadoDivisa(toClone.getImportePagadoDivisa());
        dtoResu.setImportePago(toClone.getImportePago());
        dtoResu.setImportePagoDivisa(toClone.getImportePagoDivisa());
        dtoResu.setImportePendiente(toClone.getImportePendiente());
        dtoResu.setIndicaDescuentoRecargo(toClone.getIndicaDescuentoRecargo());
        dtoResu.setMarca(toClone.getMarca());
        dtoResu.setMarcaSituacion(toClone.getMarcaSituacion());
        dtoResu.setMedioPago(toClone.getMedioPago());
        dtoResu.setMovimientosBancariosCancelados(toClone.getMovimientosBancariosCancelados());
        dtoResu.setNumeroIdentificadorCuota(toClone.getNumeroIdentificadorCuota());
        dtoResu.setNumeroLoteContabilizacion(toClone.getNumeroLoteContabilizacion());
        dtoResu.setNumeroLoteFactu(toClone.getNumeroLoteFactu());
        dtoResu.setNumeroOrdenCuota(toClone.getNumeroOrdenCuota());
        dtoResu.setNumeroSerieCuota(toClone.getNumeroSerieCuota());
        dtoResu.setObservaciones(toClone.getObservaciones());
        dtoResu.setOid(toClone.getOid());
        dtoResu.setOidAcceso(toClone.getOidAcceso());
        dtoResu.setOidCanal(toClone.getOidCanal());
        dtoResu.setOidCargoAbono(toClone.getOidCargoAbono());
        dtoResu.setOidCliente(toClone.getOidCliente());
        dtoResu.setOidDocumentoReferencia(toClone.getOidDocumentoReferencia());
        dtoResu.setOidMoneda(toClone.getOidMoneda());
        dtoResu.setOidPedidoSolicitudCab(toClone.getOidPedidoSolicitudCab());
        dtoResu.setOidRegion(toClone.getOidRegion());
        dtoResu.setOidSeccion(toClone.getOidSeccion());
        dtoResu.setOidSubtipoCliente(toClone.getOidSubtipoCliente());
        dtoResu.setOidSugerenciaVenta(toClone.getOidSugerenciaVenta());
        dtoResu.setOidTipoDocumentoLegal(toClone.getOidTipoDocumentoLegal());
        dtoResu.setOidTipoSolicitud(toClone.getOidTipoSolicitud());
        dtoResu.setPeriodoDesde(toClone.getPeriodoDesde());
        dtoResu.setReferenciaNumeroDocumentoExterno(toClone.getReferenciaNumeroDocumentoExterno());
        dtoResu.setSubacceso(toClone.getSubacceso());
        dtoResu.setSubprocesoCreacion(toClone.getSubprocesoCreacion());
        dtoResu.setSubprocesoUltimo(toClone.getSubprocesoUltimo());
        dtoResu.setTerritorioAdministrativo(toClone.getTerritorioAdministrativo());
        dtoResu.setTipoAbonoCreacion(toClone.getTipoAbonoCreacion());
        dtoResu.setTipoAbonoUltimo(toClone.getTipoAbonoUltimo());
        dtoResu.setTipoCambio(toClone.getTipoCambio());
        dtoResu.setTipoCliente(toClone.getTipoCliente());
        dtoResu.setTipoPeriodoDesde(toClone.getTipoPeriodoDesde());
        dtoResu.setUltimoDocumentoAnyo(toClone.getUltimoDocumentoAnyo());
        dtoResu.setUltimoDocumentoMesSerie(toClone.getUltimoDocumentoMesSerie());
        dtoResu.setUltimoDocumentoNumero(toClone.getUltimoDocumentoNumero());
        dtoResu.setUltimoNumeroHistoria(toClone.getUltimoNumeroHistoria());
        dtoResu.setUsuario(toClone.getUsuario());
        
        //atributo agregado
        dtoResu.setTipoAbonoSubprocesoUltimo(toClone.getTipoAbonoSubprocesoUltimo());        
        UtilidadesLog.info("MONCuentasCorrientesBean.copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone): Salida");
        return dtoResu;
    }
    
  /**
   * Obtiene la interfaz home de este mismo MON.
   * 
   * @author SCS, bajo modelo de EArese
   * @date 06/09/2006
   * @return MONCuentasCorrientesLocal 
   * @throws MareException
   * Notas:
   *        Se usa en performance
   *   
   */
  private DTOParametrosCuotasCancelacion obtenerParametrosCuotasCancelacion(Long Pais) throws MareException
  {
    UtilidadesLog.info("MONCuentasCorrientesBean.obtenerParametrosCuotasCancelacion(Long Pais): Entrada");
    
    DTOParametrosCuotasCancelacion paramCuotasCancelacion = new DTOParametrosCuotasCancelacion();
    
    DTOBelcorp dtoB = new DTOBelcorp();
    
    dtoB.setOidPais(Pais);
    //MONCuentasCorrientesLocal moncccLocal = getMONCuentasCorrientesLocal();
    //Integer numeroIdentificacion = moncccLocal.obtenerSecuenciaPais(dtoB);
    
    DAOCCC daoCCC = new DAOCCC();
    daoCCC.obtenerOIDSubproceso(Pais, CCCConstantes.PROCESO_ACTUALIZ_AUT_CANCELACION_DEUDA, Integer.valueOf("2"));
    
    //Tomamos únicamente el primer registro y de él extraemos los campos.
    //DTOSalida dto = daoCCC.obtenerTiposAbonoSubprocesoCContable(Pais, CCCConstantes.PROCESO_ACTUALIZ_AUT_CANCELACION_DEUDA, Integer.valueOf("2"));
    //Long tmpCuotaNueva = new Long(((BigDecimal) dto.getResultado().getValueAt(0,"CUCO_OID_CUEN_CONT")).longValue());
    //Long tmpTipoAbonoCuentaContable = new Long(((BigDecimal) dto.getResultado().getValueAt(0,"TCAB_OID_TCAB")).longValue());
    
    UtilidadesLog.info("MONCuentasCorrientesBean.obtenerParametrosCuotasCancelacion(Long Pais): Salida");
    return paramCuotasCancelacion;
  }  




  private void generarDetalleCargoAbonoTotal(DTOMovimientoCuentaCompleto[] dtos) 
  {
 
  }   


   /**
    * Este metodo hace lo mismo que actualizarCuenta, pero sin sumar el importe pagado,
    * es decir, graba exactamente lo que se le pasa como parametro.
    * Gacevedo
    * @throws es.indra.mare.common.exception.MareException
    * @param movimientoCuenta
    */
   public void actualizarCuentaDos(DTOMovimientoCuentaCompleto movimientoCuenta) throws MareException {
   
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta): Entrada");
        UtilidadesLog.info("**** DTOMovimientoCuentaCompleto = "+movimientoCuenta);

        RecordSet rs = null;
        Vector parametros = new Vector();
        StringBuffer query  = new StringBuffer();

        double importeHistorico = 0;
        try {
            query.append("SELECT C.OID_MOVI_CC, IMP_PEND FROM CCC_MOVIM_CUENT_CORRI C, CRA_PERIO CRA  WHERE CRA.OID_PERI= C.PERD_OID_PERI ");
            query.append(" AND SBAC_OID_SBAC = ?");
            query.append(" AND VAL_EJER_CUOT = ?");
            query.append(" AND NUM_IDEN_CUOT = ?");
            query.append(" AND NUM_ORDE_CUOT = ?");
            query.append(" AND CRA.PAIS_OID_PAIS = ?");
            parametros.add(movimientoCuenta.getSubacceso());
            parametros.add(movimientoCuenta.getEjercicioCuota());		
            parametros.add(movimientoCuenta.getNumeroIdentificadorCuota());
            parametros.add(movimientoCuenta.getNumeroOrdenCuota());
            parametros.add(movimientoCuenta.getOidPais());
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (Exception fe) {
          ctx.setRollbackOnly();
          throw new MareException(fe,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));         
        }
        if(rs.esVacio()){//lo creamos y salimos
        try {
               UtilidadesLog.info("*** Se realiza el insert del  movimiento de Cuentas Corrientes *** ");
               Long oidmovimientoCuenta = new Long(SecuenciadorOID.obtenerSiguienteValor("CCC_MVCC_SEQ").longValue());
               
               StringBuffer values = new StringBuffer();
               query  = new StringBuffer();
               query.append(" INSERT INTO CCC_MOVIM_CUENT_CORRI (");
               // campos obligatorios
               query.append(" oid_movi_cc, ");
               values.append(oidmovimientoCuenta).append(",");
               query.append(" soci_oid_soci, ");
               values.append(movimientoCuenta.getEmpresa()).append(",");
               query.append(" masi_oid_marc_situ, ");
               values.append(movimientoCuenta.getMarcaSituacion()).append(",");
               query.append(" perd_oid_peri, ");
               values.append(movimientoCuenta.getPeriodoDesde()).append(",");
               query.append(" tcab_oid_tcab_ulti, ");
               values.append(movimientoCuenta.getTipoAbonoUltimo()).append(",");
               query.append(" tcab_oid_tcab_crea, ");
               values.append(movimientoCuenta.getTipoAbonoCreacion()).append(",");
               query.append(" sbac_oid_sbac, ");
               values.append(movimientoCuenta.getSubacceso()).append(",");
               query.append(" subp_oid_subp_ulti, ");
               values.append(movimientoCuenta.getSubprocesoUltimo()).append(",");
               query.append(" subp_oid_subp_crea, ");
               values.append(movimientoCuenta.getSubprocesoCreacion()).append(",");
               query.append(" cuco_oid_cuen_cont_orig, ");
               values.append(movimientoCuenta.getCuentaOrigen()).append(",");
               query.append(" clie_oid_clie, ");
               values.append(movimientoCuenta.getOidCliente()).append(",");
               query.append(" val_docu_anio, ");
               values.append("'").append(movimientoCuenta.getDocumentoAnyo()).append("'").append(",");
               query.append(" val_docu_nume, ");
               values.append("'").append(movimientoCuenta.getDocumentoNumero()).append("'").append(",");
               query.append(" val_ejer_cuot, ");
               values.append("'").append(movimientoCuenta.getEjercicioCuota()).append("'").append(",");
               query.append(" fec_docu, ");
               values.append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaDocumento().getTime()) + "', 'YYYY-MM-DD'), ");           
               query.append(" fec_ulti_movi, ");
               values.append(" to_date( '" + sdf.format(movimientoCuenta.getFechaUltimoMovimiento()) + "', 'YYYY-MM-DD HH24:MI:SS'), ");           
               query.append(" fec_venc, ");
               values.append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaVencimiento().getTime()) + "', 'YYYY-MM-DD'), ");           
               query.append(" imp_movi, ");
               values.append(movimientoCuenta.getImporte()).append(",");
               query.append(" imp_paga, ");
               values.append(movimientoCuenta.getImportePagado()).append(",");
               query.append(" imp_pend, ");
               values.append(movimientoCuenta.getImportePendiente()).append(",");
               query.append(" num_iden_cuot, ");
               values.append(movimientoCuenta.getNumeroIdentificadorCuota()).append(",");
               query.append(" num_orde_cuot, ");
               values.append(movimientoCuenta.getNumeroOrdenCuota()).append(",");
               query.append(" ztad_oid_terr_admi, ");
               values.append(movimientoCuenta.getTerritorioAdministrativo()).append(",");
               query.append(" ticl_oid_tipo_clie, ");
               values.append(movimientoCuenta.getTipoCliente()).append(",");
               query.append(" ind_tipo_camb, ");
               values.append(movimientoCuenta.getTipoCambio()).append(",");
               query.append(" cod_usua, ");
               values.append("'").append(movimientoCuenta.getUsuario()).append("'").append(",");
               query.append(" sbti_oid_subt_clie, ");
               values.append(movimientoCuenta.getOidSubtipoCliente()).append(",");
               query.append(" zsgv_oid_subg_vent, ");
               values.append(movimientoCuenta.getOidSugerenciaVenta()).append(",");
               query.append(" zscc_oid_secc, ");
               values.append(movimientoCuenta.getOidSeccion()).append(",");
               query.append(" zorg_oid_regi, ");
               values.append(movimientoCuenta.getOidRegion()).append(",");
               query.append(" imp_movi_cuen ");
               values.append(movimientoCuenta.getImporteMovimiento());
               // campos No Obligatorios        
               if (movimientoCuenta.getDivisa() != null) {
                  query.append(", mone_oid_mone");
                  values.append(", ").append(movimientoCuenta.getDivisa());
               }
               if (movimientoCuenta.getCuentaCuota() != null) {
                  query.append(", cuco_oid_cuen_cont_cuot");
                  values.append(", ").append(movimientoCuenta.getCuentaCuota());
               }
               if (movimientoCuenta.getDocumentoMesSerie() != null) {
                  query.append(", val_docu_mes_seri");
                  //values.append(", ").append("'").append(movimientoCuenta.getDocumentoMesSerie()).append("'");
                  values.append(", TO_CHAR(SYSDATE,'MM') ");
               }
               if (movimientoCuenta.getFechaContabilizacion() != null) {
                  query.append(", fec_conta");
                  values.append(", ").append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaContabilizacion().getTime()) + "', 'YYYY-MM-DD') ");           
               }
               if (movimientoCuenta.getFechaValor() != null) {
                  query.append(", fec_valo");
                  values.append(", ").append(" to_date( '" + new java.sql.Date(movimientoCuenta.getFechaValor().getTime()) + "', 'YYYY-MM-DD') ");           
               }
               if (movimientoCuenta.getImporteDivisa() != null) {
                  query.append(", imp_divi");
                  values.append(", ").append(movimientoCuenta.getImporteDivisa());
               }
               if (movimientoCuenta.getImportePagadoDivisa() != null) {
                  query.append(", imp_paga_divi");
                  values.append(", ").append(movimientoCuenta.getImportePagadoDivisa());
               }
               if (movimientoCuenta.getIndicaDescuentoRecargo() != null) {
                  query.append(", ind_dto_carg_apli");
                  if (movimientoCuenta.getIndicaDescuentoRecargo().booleanValue() ) {
                      values.append(",").append("1");
                  } else {
                      values.append(",").append("0");
                  }
               }
               if (movimientoCuenta.getNumeroLoteContabilizacion() != null) {
                  query.append(", val_nume_lote_cont");
                  values.append(", ").append("'").append(movimientoCuenta.getNumeroLoteContabilizacion()).append("'");
               }
               if (movimientoCuenta.getObservaciones() != null) {
                  query.append(", val_obse");
                  values.append(", ").append("'").append(movimientoCuenta.getObservaciones()).append("'");
               }
               if (movimientoCuenta.getReferenciaNumeroDocumentoExterno() != null) {
                  query.append(", val_refe_nume_docu_exte");
                  values.append(", ").append("'").append(movimientoCuenta.getReferenciaNumeroDocumentoExterno()).append("'");
               }
               if (movimientoCuenta.getUltimoDocumentoAnyo() != null) {
                  query.append(", val_ulti_docu_anio");
                  values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoAnyo()).append("'");
               }
               if (movimientoCuenta.getUltimoDocumentoMesSerie() != null) {
                  query.append(", val_ulti_docu_mes_seri");
                  values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoMesSerie()).append("'");
               }
               if (movimientoCuenta.getUltimoDocumentoNumero() != null) {
                  query.append(", val_ulti_docu_nume");
                  values.append(", ").append("'").append(movimientoCuenta.getUltimoDocumentoNumero()).append("'");
               }
               if (movimientoCuenta.getUltimoNumeroHistoria() != null) {
                  query.append(", val_ulti_nume_hist");
                  values.append(", ").append("'").append(movimientoCuenta.getUltimoNumeroHistoria()).append("'");
               }
               if (movimientoCuenta.getMedioPago() != null) {
                  query.append(", mpab_oid_medi_pago");
                  values.append(", ").append(movimientoCuenta.getMedioPago());
               }
               if (movimientoCuenta.getMarca() != null) {
                  query.append(", marc_oid_marc");
                  values.append(", ").append(movimientoCuenta.getMarca());
               }
               if (movimientoCuenta.getNumeroLoteFactu() != null) {
                  query.append(", num_lote_fact");
                  values.append(", ").append(movimientoCuenta.getNumeroLoteFactu());
               }
               if (movimientoCuenta.getImportePago() != null) {
                  query.append(", imp_pago");
                  values.append(", ").append(movimientoCuenta.getImportePago());
               }
               if (movimientoCuenta.getImportePagoDivisa() != null) {
                  query.append(", imp_pago_divi");
                  values.append(", ").append(movimientoCuenta.getImportePagoDivisa());
               } else {
                  query.append(", imp_pago_divi");
                  values.append(", ").append(new Double(0));
               }
               if (movimientoCuenta.getImporteMovimientoDivisa() != null) {
                  query.append(", imp_movi_divi");
                  values.append(", ").append(movimientoCuenta.getImporteMovimientoDivisa());
               }
               if (movimientoCuenta.getTipoPeriodoDesde() != null) {
                  query.append(", tipe_oid_tipo_peri");
                  values.append(", ").append(movimientoCuenta.getTipoPeriodoDesde());
               }
               if (movimientoCuenta.getOidTipoDocumentoLegal() != null) {
                  query.append(", tido_oid_tipo_docu");
                  values.append(", ").append(movimientoCuenta.getOidTipoDocumentoLegal());
               }
               if (movimientoCuenta.getOidTipoSolicitud() != null) {
                  query.append(", tspa_oid_tipo_soli_pais");
                  values.append(", ").append(movimientoCuenta.getOidTipoSolicitud());
               }
               if (movimientoCuenta.getOidPedidoSolicitudCab() != null) {
                  query.append(", soca_oid_soli_cabe");
                  values.append(", ").append(movimientoCuenta.getOidPedidoSolicitudCab());
               }
               query.append(") VALUES (");
               query.append(values);
               query.append(")");
               
               BelcorpService.getInstance().dbService.executeUpdate(query.toString());
               
               return;
         } catch (Exception e) {
             ctx.setRollbackOnly();
             throw new MareException(e,
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
        }else{//lo encontramos, hacemos el update
               importeHistorico = ((BigDecimal)rs.getValueAt(0,"IMP_PEND")).doubleValue();
               new HelperHistorial().generarHistoriaCuentaCorriente(new Long(rs.getValueAt(0,"OID_MOVI_CC").toString()));
               query  = new StringBuffer();
               parametros = new Vector();
               query.append(" UPDATE CCC_MOVIM_CUENT_CORRI SET ");
               // campos obligatorios
               query.append(" soci_oid_soci = ?, ");
               parametros.add(movimientoCuenta.getEmpresa());
               query.append(" masi_oid_marc_situ=?, ");
               parametros.add(movimientoCuenta.getMarcaSituacion());
               query.append(" perd_oid_peri=?, ");
               parametros.add(movimientoCuenta.getPeriodoDesde());
               query.append(" tcab_oid_tcab_ulti=?, ");
               parametros.add(movimientoCuenta.getTipoAbonoUltimo());
               query.append(" tcab_oid_tcab_crea=?, ");
               parametros.add(movimientoCuenta.getTipoAbonoCreacion());
               query.append(" sbac_oid_sbac=?, ");
               parametros.add(movimientoCuenta.getSubacceso());
               query.append(" subp_oid_subp_ulti=?, ");
               parametros.add(movimientoCuenta.getSubprocesoUltimo());
               query.append(" subp_oid_subp_crea=?, ");
               parametros.add(movimientoCuenta.getSubprocesoCreacion());
               query.append(" cuco_oid_cuen_cont_orig=?, ");
               parametros.add(movimientoCuenta.getCuentaOrigen());
               query.append(" clie_oid_clie=?, ");
               parametros.add(movimientoCuenta.getOidCliente());
               query.append(" val_docu_anio=?, ");
               parametros.add(movimientoCuenta.getDocumentoAnyo());
               query.append(" val_docu_nume=?, ");
               parametros.add(movimientoCuenta.getDocumentoNumero());
               query.append(" val_ejer_cuot=?, ");
               parametros.add(movimientoCuenta.getEjercicioCuota());
               query.append(" fec_docu=?, ");
               parametros.add(new java.sql.Date(movimientoCuenta.getFechaDocumento().getTime()));           
               query.append(" fec_ulti_movi=?, ");
               parametros.add(movimientoCuenta.getFechaUltimoMovimiento());           
               query.append(" fec_venc=?, ");
               parametros.add(new java.sql.Date(movimientoCuenta.getFechaVencimiento().getTime()));           
               query.append(" imp_movi=?, ");
               parametros.add(movimientoCuenta.getImporte());
               query.append(" imp_paga=?, ");
               parametros.add(movimientoCuenta.getImportePagado());
               query.append(" imp_pend=?, ");
               parametros.add(movimientoCuenta.getImportePendiente());
               query.append(" num_iden_cuot=?, ");
               parametros.add(movimientoCuenta.getNumeroIdentificadorCuota());
               query.append(" num_orde_cuot=?, ");
               parametros.add(movimientoCuenta.getNumeroOrdenCuota());
               query.append(" ztad_oid_terr_admi=?, ");
               parametros.add(movimientoCuenta.getTerritorioAdministrativo());
               query.append(" ticl_oid_tipo_clie=?, ");
               parametros.add(movimientoCuenta.getTipoCliente());
               query.append(" ind_tipo_camb=?, ");
               parametros.add(new Double(movimientoCuenta.getTipoCambio().doubleValue()));
               query.append(" cod_usua=?, ");
               parametros.add(movimientoCuenta.getUsuario());
               query.append(" sbti_oid_subt_clie=?, ");
               parametros.add(movimientoCuenta.getOidSubtipoCliente());
               query.append(" zsgv_oid_subg_vent=?, ");
               parametros.add(movimientoCuenta.getOidSugerenciaVenta());
               query.append(" zscc_oid_secc=?, ");
               parametros.add(movimientoCuenta.getOidSeccion());
               query.append(" zorg_oid_regi=?, ");
               parametros.add(movimientoCuenta.getOidRegion());
               query.append(" imp_movi_cuen =? ");
               parametros.add(new Double(movimientoCuenta.getImporteMovimiento().doubleValue()));
               if (movimientoCuenta.getDivisa() != null) {
                  query.append(", mone_oid_mone=?,");
                  parametros.add(movimientoCuenta.getDivisa());
               }
               
               if (movimientoCuenta.getCuentaCuota() != null) {
                  query.append(" ,cuco_oid_cuen_cont_cuot=?");
                  parametros.add(movimientoCuenta.getCuentaCuota());
               }
               
               if (movimientoCuenta.getDocumentoMesSerie() != null) {
                  query.append(" ,val_docu_mes_seri=?");
                  parametros.add(movimientoCuenta.getDocumentoMesSerie());
               }
               
               if (movimientoCuenta.getFechaContabilizacion() != null) {
                  query.append(" , fec_conta=? ");
                  parametros.add(new java.sql.Date(movimientoCuenta.getFechaContabilizacion().getTime()));
               }
               
               if (movimientoCuenta.getFechaValor() != null) {
                  query.append(" ,fec_valo=? ");
                  parametros.add(new java.sql.Date(movimientoCuenta.getFechaValor().getTime()));
               }
               
               if (movimientoCuenta.getImporteDivisa() != null) {
                  query.append(" ,imp_divi=? ");
                  parametros.add(movimientoCuenta.getImporteDivisa());
               }
               
               if (movimientoCuenta.getImportePagadoDivisa() != null) {
                  query.append(" ,imp_paga_divi=? ");
                  parametros.add(movimientoCuenta.getImportePagadoDivisa());
               }
               query.append(" ,ind_dto_carg_apli=? ");
               if (movimientoCuenta.getIndicaDescuentoRecargo() != null) {
                  
                  if (movimientoCuenta.getIndicaDescuentoRecargo().booleanValue() ) {
                      parametros.add("1");
                  } else {
                      parametros.add("0");
                  }
               }else{
                  parametros.add("0");
               }
               
               if (movimientoCuenta.getNumeroLoteContabilizacion() != null) {
                  query.append(" ,val_nume_lote_cont=? ");
                  parametros.add(movimientoCuenta.getNumeroLoteContabilizacion());
               }
               if (movimientoCuenta.getObservaciones() != null) {
                  query.append(" ,val_obse=? ");
                  parametros.add(movimientoCuenta.getObservaciones());
               }
               if (movimientoCuenta.getReferenciaNumeroDocumentoExterno() != null) {
                  query.append(" ,val_refe_nume_docu_exte=? ");
                  parametros.add(movimientoCuenta.getReferenciaNumeroDocumentoExterno());
               }
               if (movimientoCuenta.getUltimoDocumentoAnyo() != null) {
                  query.append(" ,val_ulti_docu_anio=? ");
                  parametros.add(movimientoCuenta.getUltimoDocumentoAnyo());
               }
               if (movimientoCuenta.getUltimoDocumentoMesSerie() != null) {
                  query.append(" ,val_ulti_docu_mes_seri=? ");
                  parametros.add(movimientoCuenta.getUltimoDocumentoMesSerie());
               }
               if (movimientoCuenta.getUltimoDocumentoNumero() != null) {
                  query.append(" ,val_ulti_docu_nume=? ");                  
                  parametros.add(movimientoCuenta.getUltimoDocumentoNumero());
               }
               if (movimientoCuenta.getUltimoNumeroHistoria() != null) {
                  query.append(" ,val_ulti_nume_hist=? ");
                  parametros.add(movimientoCuenta.getUltimoNumeroHistoria());
               }
               if (movimientoCuenta.getMedioPago() != null) {
                  query.append(" ,mpab_oid_medi_pago=? ");
                  parametros.add(movimientoCuenta.getMedioPago());
               }
               
               if (movimientoCuenta.getMarca() != null) {
                  query.append(" ,marc_oid_marc=? ");
                  parametros.add(movimientoCuenta.getMarca());
               }
               
               if (movimientoCuenta.getNumeroLoteFactu() != null) {
                  query.append(" ,num_lote_fact=? ");
                  parametros.add(movimientoCuenta.getNumeroLoteFactu());
               }
               
               if (movimientoCuenta.getImportePago() != null) {
                  query.append(" ,imp_pago=? ");
                  parametros.add(movimientoCuenta.getImportePago());
               }
               query.append(" ,imp_pago_divi=? ");
               if (movimientoCuenta.getImportePagoDivisa() != null) {
                  
                  parametros.add(movimientoCuenta.getImportePagoDivisa());
               } else {
                  parametros.add(new Double(0));
               }
               if (movimientoCuenta.getImporteMovimientoDivisa() != null) {
                  query.append(" ,imp_movi_divi=? ");
                  parametros.add(movimientoCuenta.getImporteMovimientoDivisa());
               }
               
               if (movimientoCuenta.getTipoPeriodoDesde() != null) {
                  query.append(" ,tipe_oid_tipo_peri=? ");
                  parametros.add(movimientoCuenta.getTipoPeriodoDesde());
               }
               
               if (movimientoCuenta.getOidTipoDocumentoLegal() != null) {
                  query.append(" ,tido_oid_tipo_docu=? ");
                  parametros.add(movimientoCuenta.getOidTipoDocumentoLegal());
               }
               if (movimientoCuenta.getOidTipoSolicitud() != null) {
                  query.append(" ,tspa_oid_tipo_soli_pais=? ");
                  parametros.add(movimientoCuenta.getOidTipoSolicitud());
               }
               if (movimientoCuenta.getOidPedidoSolicitudCab() != null) {
                  query.append(" ,soca_oid_soli_cabe=? ");
                  parametros.add(movimientoCuenta.getOidPedidoSolicitudCab());
               }
               query.append(" WHERE OID_MOVI_CC = ?");
               parametros.add(new Long(rs.getValueAt(0,"OID_MOVI_CC").toString()));
               try{
                  BelcorpService.getInstance().dbService.executePreparedUpdate(query.toString(),parametros);
               }catch(Exception e){
                   throw new MareException(e,
                       UtilidadesError.armarCodigoError(
                           CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
               }
        }
        //double importeHistorico = localHistorico.getImporte().doubleValue();
        //double importeCuenta = movimientoCuenta.getImporte().doubleValue();

        
        //if (importeHistorico != importeCuenta) {
            DTOActualizacionCartera dtoActuCartera = new DTOActualizacionCartera();
            dtoActuCartera.setOidCuota(movimientoCuenta.getOid());
            dtoActuCartera.setOidPais(movimientoCuenta.getOidPais());
            dtoActuCartera.setOidMarca(movimientoCuenta.getMarca());
            dtoActuCartera.setImporteDeudaCancelada(new BigDecimal(movimientoCuenta.getImportePagado().doubleValue()));
            dtoActuCartera.setOidSubacceso(movimientoCuenta.getSubacceso());
            dtoActuCartera.setOidEstadoAsignacion(null);
            try{
                MONAsignacionCarteraPeriodoHome monAsignacionCarteraPeriodo = this.getMONAsignacionCarteraPeriodoHome();
                MONAsignacionCarteraPeriodo monAsigCartePeri  = monAsignacionCarteraPeriodo.create();
                monAsigCartePeri.actualizarEstadoCartera(dtoActuCartera);
            } catch (NamingException namingException) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(namingException);
                throw new MareException(namingException,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException createException) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(createException);
                throw new MareException(createException,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (RemoteException re) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        //}
        UtilidadesLog.info("MONCuentasCorrientesBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta): Salida");

   
   }

   public void insertarBloqueo(DTOBloqueo dto) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientes.insertarBloqueo(DTOBloqueo): Entrada");
      DAOCCC dao = new DAOCCC();
      ExcepcionParametrizada exParam;
      RecordSet rs;
      rs = dao.consultarBloqueo();
      
      if(rs.getRowCount() > 0){
         String usuarioGuardado = rs.getValueAt(0,1).toString();
         String fecha = rs.getValueAt(0,2).toString();
         String descripcionProceso = rs.getValueAt(0,3).toString();
         
         /*throw new MareException("El proceso no se puede ejecutar porque el usuario " + usuarioGuardado 
                                  + " ha bloqueado el " + fecha + " las tablas que son necesarias para el proceso " 
                                  + descripcionProceso);    */
         UtilidadesLog.warn("El proceso no se puede ejecutar porque el usuario " + usuarioGuardado 
                                  + " ha bloqueado el " + fecha + " las tablas que son necesarias para el proceso " 
                                  + descripcionProceso );

                                  
        exParam = new ExcepcionParametrizada(new MareException(),   
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC,"",
                                                        ErroresDeNegocio.PROCESO_BLOQUEADO_PARA_USUARIO));
        exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
        exParam.addParameter( usuarioGuardado );
        exParam.addParameter( descripcionProceso );
        throw exParam;
      
      }else{      
         dao.insertarBloqueo(dto);      
      }  
      
      UtilidadesLog.info("MONCuentasCorrientes.insertarBloqueo(DTOBloqueo):  Salida");
   
   }
  
   public void eliminarBloqueo(DTOBelcorp dto) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientes.eliminarBloqueo(): Entrada");
      DAOCCC dao = new DAOCCC();
      try{
        dao.eliminarBloqueo();
      }catch(Exception e){
        e.printStackTrace();
      } 
      UtilidadesLog.info("MONCuentasCorrientes.eliminarBloqueo():  Salida");
   
   }
    
    private void creoRegistro(long año, long mes, long pais) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.creoRegistro(String año, String mes, long pais): Entrada");
        StringBuffer insert = new StringBuffer();
        StringBuffer query = new StringBuffer();                        
        query.append("SELECT CCC_SEPA_SEQ.NEXTVAL FROM DUAL");                                  
        RecordSet rs = this.executeQuery(query.toString());
        Long oidSP = this.bigDecimalToLong(rs.getValueAt(0,0));
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        insert.append("INSERT INTO CCC_SECUE_PAIS (OID_SECU_PAIS, ");
        insert.append("PAIS_OID_PAIS, NUM_ANIO, NUM_MES, NUM_SECU)");
        insert.append(" VALUES(" + oidSP.longValue() + ", ");
        insert.append(pais + ", " +año + ", ");
        
        if (mes!=-1)
            insert.append(mes + ", ");
        else    
            insert.append("null, ");
            
        insert.append(1 + ")");
        
        UtilidadesLog.debug("insert .... " + insert.toString());
        try {
            bs.dbService.executeUpdate(insert.toString());     
            
        } catch (DuplicateKeyException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){        
            UtilidadesLog.error("insert CCC_CUPON_TRAMI_DEPUR: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        
        UtilidadesLog.info("MONCuentasCorrientesBean.creoRegistro(String año, String mes, long pais): Salida");
    }
   
	private boolean hayRegAñoMesAnterior(long año, long mes, long pais) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.hayRegAñoMesAnterior(String año, String mes, long pais): Entrada");
        UtilidadesLog.debug("año y mes nuevos: " + año + "/" + mes);
        long añoAnt = (año-1);
        long mesAnt = (mes-1);
        if (mesAnt==0)
            mesAnt=1;
            
        UtilidadesLog.debug("año y mes ant..:" + añoAnt + " / " + mesAnt);
        
        StringBuffer query = new StringBuffer();                        
        //BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        query.append("SELECT * FROM (SELECT sp.num_secu ");
        query.append("FROM ccc_secue_pais sp ");
        query.append("WHERE sp.pais_oid_pais = " + pais);
        query.append(" AND sp.num_anio = " + añoAnt);
        
        if (mes!=-1){
            query.append(" AND (sp.num_mes = " + mesAnt);
            query.append(" OR sp.num_mes IS NULL) ");
        }    
        query.append(" order by num_mes, num_anio ) ");
        query.append("where rownum = 1");
        rs = this.executeQuery(query.toString());     
        if ((rs.getRowCount()>0) && (rs!=null)){
            //tengo reg. con año y mes ant.!
            UtilidadesLog.info("MONCuentasCorrientesBean.hayRegAñoMesAnterior(String año, String mes, long pais): Salida (T)");
            return true;
        }else{
            UtilidadesLog.info("MONCuentasCorrientesBean.hayRegAñoMesAnterior(String año, String mes, long pais): Salida (F)");
            return false;
        }
    }    
  
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }        

    public DTOSalida obtenerSituacionesCuponTodas() throws MareException
    {
        //cambio fac 03, modulo ccc (SCS-29/01/2008), en este caso necesito todas las situaciones
		UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSituacionesCuponTodas(): Entrada");
		DAOCCC daoccc = new DAOCCC();
		DTOSalida dtoSalida = null;
		dtoSalida=daoccc.obtenerSituacionesCuponTodas();
		UtilidadesLog.info("MONCuentasCorrientesBean.obtenerSituacionesCuponTodas(): Salida");
		return dtoSalida;
    }    


    private PaisLocalHome getPaisLocalHome()
        throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesBean.getPaisLocalHome(): Entrada");
        UtilidadesLog.info("MONCuentasCorrientesBean.getPaisLocalHome(): Salida");
        return new PaisLocalHome();
    }    
    
    
  
}
