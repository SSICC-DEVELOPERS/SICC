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
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTOAlerta;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasAplicar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovCupon3;
import es.indra.sicc.dtos.ccc.DTOGenerarAlertas;
import es.indra.sicc.dtos.ccc.DTOGenerarRegistrosCargosYAbonos;
import es.indra.sicc.dtos.ccc.DTOMovBancIndicadores;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTORecuperacionTASPYMarcas;
import es.indra.sicc.dtos.ccc.DTORespuestaCancelacion;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCuponesTramiteDepuracionLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.ccc.HelperConfirmacionMovimientosBancos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/*
 **************************************************************************
 *   El diseño de este MONActualizarCCporAplicacion cambio totalmente por
 *   la incidencia 10432
 **************************************************************************
 */

public class MONActualizarCCporAplicacionBean implements SessionBean {
private final static String MON_VALIDACION = "MONValidacion";
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

    /**
     * INCIDENCIA 10002 CAMBIA EL MÉTODO TOTALMENTE
     * INCIDENCIA V-CCC-019 CAMBIA EL METODO TOTALMENTE OTRA VEZ (GACEVEDO)
     * 
     * */

	public DTOMovBancIndicadores procesarMovBancporAplicacion(DTOMovBancIndicadores dto) throws MareException {
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.procesarMovBancporAplicacion(DTOMovBancIndicadores dto): Entrada");
      //long b = System.currentTimeMillis();
		// Crear variable llamada "movimientosBancarios" de tipo ArrayList 
		// movimientosBancarios = dto.dtoMovimientosBancarios
		ArrayList movimientosBancarios = new ArrayList();
      String usuario = null;
      if(dto.getUsuarioProceso()==null){
         usuario = ctx.getCallerPrincipal().getName();
      }else{
         usuario = dto.getUsuarioProceso();
      }
		DTOMovimientoBancario []matrizDTOMovimientosBancario = dto.getDtoMovimientosBancarios();
      //long a = System.currentTimeMillis();
		for (int i = 0; i < matrizDTOMovimientosBancario.length; i++) {
			movimientosBancarios.add(matrizDTOMovimientosBancario[i]);
		}
      //UtilidadesLog.warn("- GA - Armado array(2): "+((System.currentTimeMillis()-a)/1000)+" segundos.");
      Long empresa = new Long("-1");
      DTORecuperacionTASPYMarcas datosRecuperacion = null;

      Long oidCabecera = null;
      Integer numeroCabecera = null;
      datosRecuperacion = recuperarTiposAbonoSubprocesoYMarcasSituacionFijo((DTOMovimientoBancario)movimientosBancarios.get(0));
		DTOMovimientoBancario movBanc = null;
      StringBuffer detalleCargoAbono = null;
      //clase de ayuda
      HelperConfirmacionMovimientosBancos helperMovs = new HelperConfirmacionMovimientosBancos(ctx);
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      //CabeceraCargosAbonosDirectosLocal cabeceraAbono = null;
      Integer numeroLineaInt = null;
      BelcorpService bs = BelcorpService.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      String anio= null;
      String periodoMes= null;
	  Iterator iter = movimientosBancarios.iterator();
      
      DAOCCC daoCCC = new DAOCCC();
      //cambio fac 03, modulo ccc (SCS-29/01/2008)
      //Recuperamos el atributo Número-Días-Cruce-Cupón3, accediendo a la entidad 
      //SEG-Param-Interna-País filtrando por País (activo).
      long numeroDiasCruceCupon3 = daoCCC.obtenerDiasCruceCup3(dto.getOidPais().longValue());
      boolean aplicaCupon3 = daoCCC.aplicaCupon3(dto.getOidPais().longValue());
      //      
      int contador =1;

		while (iter.hasNext()) { // (1)
         if(contador > 0 && (contador%100)==0){
            UtilidadesLog.warn("- GA - Registro :"+contador);
         }
         contador+=1;
         //UtilidadesLog.warn("- GA - Next del iterador");
          movBanc = (DTOMovimientoBancario)iter.next();
          
          //La siguiente validacion se anula para que funcione correctamente
          //el cambio COL-CCC-03.
          //Tengase en cuenta que en principio, se vaidaba el importe del movimiento
          //bancario ya que los movimientos negativos producian problemas a la hora de
          //procesar los importes, pero todos los calculos de importes fueron reescritos
          //en teoria, deberia funcionar correctamente.
          //Gacevedo 14/09/2007
         /*if(movBanc.getImporteSaldo().doubleValue()<=0){
            //el movimiento bancario no se aplica
            //segun incidencia V-CCC036
            UtilidadesLog.debug("El movimiento bancario "+movBanc.getOid()+" tiene un importe negativo o cero. No se aplica.");
            continue;
         }*/
         this.validarAlertas(movBanc, dto.getIndicadorSaldoUnico());
         
			if (dto.getIndicadorSimulacion() != null && dto.getIndicadorSimulacion().booleanValue()) {
				UtilidadesLog.debug("****Metodo  MONActualizarCCporAplicacion.procesarMovBancporAplicacion: Salida(Por Simulacion)");
				return null;
            //se rehabilita la llamda, sacada en su momento.en virtud del cambio fac 03 (SCS-29/01/2008)
		 } else {
			this.validarCupon3(movBanc, numeroDiasCruceCupon3, aplicaCupon3);
		 }  
         Date fechaValor = new Date(System.currentTimeMillis());
         ArrayList movCCSaldados = new ArrayList();
         this.recuperarTiposAbonoSubprocesoYMarcasSituacionVariable(movBanc,datosRecuperacion);	
         datosRecuperacion.setOidTipoAbonoCreacionBanco(movBanc.getOidTipoAbonoCreacion());
			DTOBuscarCuotasAplicar dtoBuscar = datosRecuperacion.getDtoBuscar();
			if (dtoBuscar.getNumeroIdentCuota() != null) {
				if (! dto.getIndicadorSaldoUnico().booleanValue()) {
               DTORespuestaCancelacion respuestaCancelacion1 = this.cancelarCCSaldoNoUnico(datosRecuperacion);
               movCCSaldados.addAll(respuestaCancelacion1.getMovCCSaldados());
               if(datosRecuperacion.getImporteASaldar().doubleValue()==respuestaCancelacion1.getImporteASaldar().doubleValue()){
                  //no aplico nada voy al siguiente
                  continue;
               }
					datosRecuperacion.setImporteASaldar(respuestaCancelacion1.getImporteASaldar());
				}
			}
			if ( datosRecuperacion.getImporteASaldar() !=null && datosRecuperacion.getImporteASaldar().doubleValue() != 0) { //CAMBIO COL-CCC-03
            DTORespuestaCancelacion respuestaCancelacion2 = this.cancelarCCSaldoUnico(datosRecuperacion);		
				movCCSaldados.addAll(respuestaCancelacion2.getMovCCSaldados());
            if(datosRecuperacion.getImporteASaldar().doubleValue()==respuestaCancelacion2.getImporteASaldar().doubleValue()){
               //no aplico nada voy al siguiente
               continue;
            }
				datosRecuperacion.setImporteASaldar(respuestaCancelacion2.getImporteASaldar());
			}
         //Todo el proceso de movimientos bancarios se hace a nivel empresa, ya que cada cambio de empresa
         //genera una nueva cabecera de cargo abono (gacevedo 08/01/2007)
         //****************************************************************************
         //Validamos la empresa, si cambia, genero una nueva cabecera de cargo abono
         if(!empresa.equals(movBanc.getEmpresa())){
            empresa = movBanc.getEmpresa();
            Integer numero = helperMovs.obtenerSecuenciaPais(dto.getOidPais(), dto.getOidIdioma());
            Date fechaDocumento=fechaValor;
            try{
               anio = UtilidadesFecha.convertirAString(fechaDocumento,"yy"); 
               periodoMes = UtilidadesFecha.convertirAString(fechaDocumento,"MM"); 
            }catch(ParseException e){
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            Long proceso=helperMovs.obtenerProceso("TES002",dto.getOidPais());
            //cabeceraAbono = helperMovs.crearCabeceraAbonoDirecto(numero,anio, periodoMes, fechaDocumento,dto.getOidPais(),empresa,usuario, fechaValor, proceso );
            //cabeceraAbono.setCuentacorriente(movBanc.getCuentaCorrienteBancaria());
            //cabeceraAbono.setSubacceso(movBanc.getSubacceso());
            //helperMovs.insertarTemporalCabeceraCargosAbonos(cabeceraAbono.getOid());
            
           oidCabecera = SecuenciadorOID.obtenerSiguienteValor("CCC_CCAD_SEQ");
           numeroCabecera = numero;
           
           StringBuffer insertCabecera = new StringBuffer();
           insertCabecera.append("INSERT INTO CCC_CABEC_CARGA_ABONO_DIREC ");
           insertCabecera.append("(OID_CABE_CARG,");
           insertCabecera.append("NUM_CABE,");
           insertCabecera.append("ANIO,");
           insertCabecera.append("VAL_PERI_MES,");
           insertCabecera.append("FEC_DOCU,");
           insertCabecera.append("PAIS_OID_PAIS,");
           insertCabecera.append("SOCI_OID_SOCI,");
           insertCabecera.append("COD_USUA,");
           insertCabecera.append("FEC_VALO,");
           insertCabecera.append("CCPR_OID_PROC,");
           insertCabecera.append("SBAC_OID_SBAC,");
           insertCabecera.append("CCBA_OID_CUEN_CORR_BANC,");
           insertCabecera.append("VAL_OBSE) VALUES (");
           insertCabecera.append(oidCabecera).append(",");
           insertCabecera.append(numeroCabecera).append(",");
           insertCabecera.append("'").append(anio).append("',");
           insertCabecera.append("'").append(periodoMes).append("',");
           insertCabecera.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'),");
           insertCabecera.append(dto.getOidPais()).append(",");
           insertCabecera.append(empresa).append(",");
           insertCabecera.append("'").append(usuario).append("',");
           insertCabecera.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'),");
           insertCabecera.append(proceso).append(",");
           if(movBanc.getSubacceso()!=null){
            insertCabecera.append(movBanc.getSubacceso()).append(",");
           }else{
            insertCabecera.append("null,");  
           }
           if(movBanc.getCuentaCorrienteBancaria()!=null){
            insertCabecera.append(movBanc.getCuentaCorrienteBancaria()).append(",");
           }else{
            insertCabecera.append("null,");  
           }
           if(movBanc.getNumeroLote()!=null){
            insertCabecera.append("'").append(movBanc.getNumeroLote()).append("')");
           }else{
            insertCabecera.append("null)");
           }
           try {
               BelcorpService.getInstance().dbService.executeUpdate(insertCabecera.toString());
            }catch (Exception e) {
               UtilidadesLog.warn("- GA - String erroneo(6): "+insertCabecera.toString());
               throw new MareException(e);
            }
            numeroLineaInt = new Integer(0);
         }
         //Gacevedo. Se modifican los calculos de importe de los movimientos bancarios
         //en base a los cambios realizados en el calculo de importes de las cuentas corrientes.
         //Existe una tabla de relacion tipo de importe/modelo fisico, de la cual se deducen las
         //cuentas que siguen (06/01/2007)
         if(movBanc.getImporteAplicado()==null){movBanc.setImporteAplicado(new BigDecimal("0"));}
         //el importe de movimiento es lo que se haya pagado, que se deduce del importe movimiento original
         //menos el saldo restante luego de los pagos de cuentas corrientes
         movBanc.setImporteMovimiento(movBanc.getImporteMovimiento().subtract(datosRecuperacion.getImporteASaldar()));
         //el importe aplicado es el acumulado del aplicado mas lo pagado ahora que es el importe
         //movimiento menos los que haya quedado por saldar.
         movBanc.setImporteAplicado(movBanc.getImporteAplicado().add(movBanc.getImporteMovimiento()));
         //el saldo es el pendiente, lo que significa que es la deuda original
         //menos el aplicado que es el acumulado de los pagos.
         movBanc.setImporteSaldo(movBanc.getImportePago().subtract(movBanc.getImporteAplicado()));
         //Gacevedo. Debe cambiarse el subprocesoultimo segun incidencia de validacion 17/11/2006
         movBanc.setOidSubprocesoMarcaUltimo(datosRecuperacion.getSubProcesoBancarioSalida());
         //movBanc.setOidTipoAbonoUltimo(datosRecuperacion.getTipoCargoAbonoTES());
         
         //se actualizan aqui mismo las cuentas corrientes y los bancos para que el proceso funcione correctamente
         numeroLineaInt = new Integer(numeroLineaInt.intValue()+1);
         
         detalleCargoAbono = new StringBuffer();
         detalleCargoAbono.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
         detalleCargoAbono.append("OID_DETA_CARG_ABON_DIRE,CCAD_OID_CABE_CARG,");
         detalleCargoAbono.append("NUM_LINE,COD_USUA,SOCI_OID_SOCI,TASP_OID_TIPO_ABON_SUBP,");
         detalleCargoAbono.append("CUCO_OID_CUEN_CONT_CUOT_NUEV,CUCO_OID_CUEN_CONT_CUOT_ANTE,");
         detalleCargoAbono.append("CMBA_OID_MOVI_BANC,CLIE_OID_CLIE,FEC_MOVI,");
         detalleCargoAbono.append("IMP,NUM_HIST_GENE,FEC_PAGO_BANC,IMP_MONE,CCBA_OID_CUEN_CORR_BANC");
         detalleCargoAbono.append(") VALUES (");
         detalleCargoAbono.append("CCC_DCAD_SEQ.NEXTVAL,").append(oidCabecera).append(",");
         detalleCargoAbono.append(numeroLineaInt).append(",");
         detalleCargoAbono.append("'").append(usuario).append("',");
         detalleCargoAbono.append(movBanc.getEmpresa()).append(",");
         detalleCargoAbono.append(datosRecuperacion.getTipoAbonoTES()).append(",");
         detalleCargoAbono.append(datosRecuperacion.getCuentaContable()).append(",");
         detalleCargoAbono.append("null,");
         detalleCargoAbono.append(movBanc.getOid()).append(",");
         detalleCargoAbono.append(movBanc.getOidConsultoraReal()).append(",");
         detalleCargoAbono.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'),");
         detalleCargoAbono.append(movBanc.getImporteMovimiento().setScale(2,BigDecimal.ROUND_HALF_EVEN)).append(",");
         if (movBanc.getNumeroHistoria() != null) {
            detalleCargoAbono.append(movBanc.getNumeroHistoria().intValue()+1).append(",");
            //movBanc.setNumeroHistoria(new Integer(movBanc.getNumeroHistoria().intValue()+1));
        } else {
            detalleCargoAbono.append("0,");
        }
        Date auxDate = new Date(0);
        auxDate.setTime(movBanc.getFechaPago().getTime());
        detalleCargoAbono.append("TO_DATE('").append(formato.format(auxDate)).append("','DD/MM/YYYY'),");
        detalleCargoAbono.append("0,");
        detalleCargoAbono.append(movBanc.getCuentaCorrienteBancaria()).append(");");
        movBanc.setOidTipoAbonoUltimo(datosRecuperacion.getTipoCargoAbonoTES());
        movBanc.setFechaMovimientoAplicacion(new Date(System.currentTimeMillis()));
        movBanc.setUsuarioProceso(usuario);
        movBanc.setAnioDocumentoAplicacion(anio);
        movBanc.setSerieDocumentoAplicacion(periodoMes);
        movBanc.setNumeroDocumentoAplicacion(numeroCabecera);
        try{
         movBanc.setFechaUltimoMivimiento(sdf.parse(sdf.format(fechaValor)));
        }catch(Exception e){
         movBanc.setFechaUltimoMivimiento(new java.util.Date());  
        }
        try{
            UtilidadesLog.info(" Antes de actualizarMovBancario");
                this.getMONCuentasCorrientes().actualizarMovBancario(movBanc);
        }catch (Exception e) {
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        int largoCuentas = movCCSaldados.size();
        //numeroLineaInt = new Integer(0);
        for(int i=0; i<largoCuentas;i++ ){
            DTOMovimientoCuentaCompleto movCC = (DTOMovimientoCuentaCompleto)movCCSaldados.get(i);
            numeroLineaInt = new Integer(numeroLineaInt.intValue()+1);
            StringBuffer valores = new StringBuffer();
            detalleCargoAbono.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
            detalleCargoAbono.append("OID_DETA_CARG_ABON_DIRE, ");
            valores.append("CCC_DCAD_SEQ.NEXTVAL, ");
            detalleCargoAbono.append("CCAD_OID_CABE_CARG, ");
            valores.append(oidCabecera).append(", ");
            detalleCargoAbono.append("NUM_LINE, ");
            valores.append(numeroLineaInt).append(",");
            detalleCargoAbono.append("COD_USUA, ");
            valores.append("'").append(usuario).append("',");
            detalleCargoAbono.append("SOCI_OID_SOCI, ");
            valores.append(movBanc.getEmpresa()).append(",");
            detalleCargoAbono.append("TASP_OID_TIPO_ABON_SUBP,");
            valores.append(datosRecuperacion.getTipoAbonoCCC()).append(",");
            detalleCargoAbono.append("CUCO_OID_CUEN_CONT_CUOT_NUEV, ");
            if (movCC.getCuentaCuota() != null) {
                valores.append(movCC.getCuentaCuota()).append(",");
            }else{
               valores.append("null,");
            }            
            detalleCargoAbono.append("CUCO_OID_CUEN_CONT_CUOT_ANTE,");
            valores.append(movCC.getCuentaOrigen()).append(",");
            detalleCargoAbono.append("CLIE_OID_CLIE, ");
            valores.append(movCC.getOidCliente()).append(",");
            detalleCargoAbono.append("FEC_MOVI, ");
            valores.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'),");
            detalleCargoAbono.append("MVCC_OID_MOVI_CC, ");
            valores.append(movCC.getOid()).append(",");
            detalleCargoAbono.append("MPAB_OID_MEDI_PAGO, ");
            valores.append(movCC.getMedioPago()).append(",");
            detalleCargoAbono.append("IMP, ");
            valores.append(movCC.getImporteMovimiento().setScale(2,BigDecimal.ROUND_HALF_EVEN)).append(",");
            detalleCargoAbono.append("IMP_MONE, ");
            valores.append("0,");
            detalleCargoAbono.append("NUM_HIST_GENE ");
            if (movCC.getUltimoNumeroHistoria() != null) {
               valores.append(movCC.getUltimoNumeroHistoria().intValue()+1).append(");");
            } else {
               valores.append("0);");
            }            
           detalleCargoAbono.append(") VALUES (").append(valores);
           
           movCC.setOidPais(dto.getOidPais());
           movCC.setUltimoDocumentoMesSerie(periodoMes);
           movCC.setUltimoDocumentoAnyo(anio);
           movCC.setUltimoDocumentoNumero(numeroCabecera);
           movCC.setSubprocesoUltimo(datosRecuperacion.getOidSubprocesoCCC());
           movCC.setTipoAbonoUltimo(datosRecuperacion.getTipoCargoAbonoCCC());
           if(movBanc.getFechaPago()!=null){
            movCC.setFechaUltimoMovimiento(new Timestamp(movBanc.getFechaPago().getTime()));
           }else{
            movCC.setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
           }
           try{
               movCC.setFechaValor(sdf.parse(sdf.format(fechaValor)));
           }catch(Exception e){
               movCC.setFechaValor(fechaValor);  
           }

           if (movCC.getUltimoNumeroHistoria() != null) {
               movCC.setUltimoNumeroHistoria(new Integer(movCC.getUltimoNumeroHistoria().intValue()+1));
           }

           movCC.setCuentaCuota(movCC.getCuentaOrigen());
           movCC.setCuentaOrigen(datosRecuperacion.getCuentaContable());
           movCC.setUsuario(usuario);
           try{
               this.getMONCuentasCorrientes().actualizarCuentaDos(movCC);
           }catch (Exception e) {
               String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           } 
         }
        try{
           bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",detalleCargoAbono.toString());
        }catch(Exception e){
           UtilidadesLog.warn("- GA - String erroneo(3): "+detalleCargoAbono.toString());
           throw new MareException("Error al crear detalle cargo y abono",e);
        }
		} // (1)Fin Para 
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.procesarMovBancporAplicacion(DTOMovBancIndicadores dto): Salida");
      helperMovs.numerarDetallesCargoAbono();
		return dto;
	}

    public void validarAlertas(DTOMovimientoBancario dto,
        Boolean indicadorSaldoUnico) throws MareException {
        /** MONActualizarCCporAplicacion.validarAlertas(dto : DTOMovimientoBancario, indicadorSaldoUnico : Boolean) : void */
        
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validarAlertas(DTOMovimientoBancario dto, Boolean indicadorSaldoUnico): Entrada");

        //Entrada:
        //- dto : DTOMovimientoBancario
        //Proceso:
        //-> Crear variable llamada "dtoGA" de tipo DTOGenerarAlertas y hacer el siguiente mapeo
        //-> dtoGA.pais = dto.pais; 
        //-> dtoGA.oidCliente = dto.oidConsultoraReal;  
        //-> dtoGA.numeroCupon = dto.numeroCupon;
        //-> dtoGA.numeroFacturaBoleta = dto.numeroFactura; 
        //-> dtoGA.importePago = dto.importePago; 
        //-> dtoGA.saldoUnico = indicadorSaldoUnico;
        DTOGenerarAlertas dtoGA = new DTOGenerarAlertas();
        dtoGA.setOidPais(dto.getOidPais());
        dtoGA.setOidCliente(dto.getOidConsultoraReal());
        dtoGA.setNumeroCupon(dto.getNumeroCupon());
		if (dto.getNumeroFactura() != null){
			dtoGA.setNumeroFactuBoleta(new Integer(dto.getNumeroFactura().intValue()));
		}
        dtoGA.setImportePago(dto.getImportePago());
        dtoGA.setSaldoUnico(indicadorSaldoUnico);

        //-> Tomar dtoGA como parámetro para la siguiente llamada
        //-> Llamar al método "MONActualizarCCporAplicacion.generarAlertas(dto : DTOGenerarAlertas) : DTOAlerta"
        //-> Crear variable llamada "dtoA" de tipo DTOAlerta y asignarle la respuesta a la llamada anterior
        DTOAlerta dtoA = new DTOAlerta();
        
        dtoA = this.generarAlertas(dtoGA);

        if (dtoA.getIndAlerta().booleanValue()) {
            // Gacevedo. Segun incidencias DBLG700000234 y DBLG700000242
            // se deja sin efecto la incidencia de mas abajo, ya que el proceso
            // en caso de encontrar un alerta con el codigo IMPORTE_MOV_BANC_SUPERIOR_DEUDA
            // genera log de aplicacion indicando la situacion y continua con el proceso.
            // ---------------------------------------------------------------------
            // incidencia BELC300010464
            // Se lanza una ExcepcionParametrizada con el codigo recibido en el 
            // dotA.codigoAlerta y los parametros contenidos en dtoA.parametrosAlerta.
            //----------------------------------------------------------------------
            if (dtoA.getCodigoMensajeAlerta().equals(ErroresDeNegocio.IMPORTE_MOV_BANC_SUPERIOR_DEUDA)) {
               LogAPP.debug("El movimiento "+dto.getOid()+" esta pagando un monto que supera la alerta. OID Cliente: "+dtoGA.getOidCliente()+", monto pagado: "+dto.getImporteMovimiento() );
            } else {
                UtilidadesLog.info("Se genera la alarma por deuda cero o negativa");				
                LogAPP.debug("El movimiento "+dto.getOid()+" esta rerferido a un cliente("+dtoGA.getOidCliente()+") con deuda negativa o cero" );
                //MareException me = new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.DEUDA_CLIENTE_MENOR_IGUAL_CERO));
                //throw me;
            }
        }
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validarAlertas(DTOMovimientoBancario dto, Boolean indicadorSaldoUnico): Salida");
    }

    //se agregan los 2 ult. param. en virtud de cambio fac 03, modulo ccc (SCS-29/01/2008)
    public Long validarCupon3(DTOMovimientoBancario dto, 
                              long numeroDiasCruceCupon3, 
                              boolean aplicaCupon3) throws MareException {
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validarCupon3(DTOMovimientoBancario dto, long numeroDiasCruceCupon3, boolean aplicaCupon3): Entrada");

        /* MONActualizarCCporAplicacion.validarCupon3(dto : DTOMovimientoBancario) : Long */

        //Entrada:    - dto : DTOMovimientoBancario
        //Proceso:
        //-> Crear variable llamada "dtoBMC3" de tipo DTOBuscarMovCupon3 y hacer el siguiente mapeo
        //-> dtoBMC3.pais = dto.pais;
        DTOBuscarMovCupon3 dtoBMC3 = new DTOBuscarMovCupon3();
        dtoBMC3.setOidPais(dto.getOidPais());

        //(4)Si (dto.numeroCupon = null) entonces
        //-> dtoBMC3.numeroCupon = dto.numeroFactura
        //(4)Si no entonces
        //-> dtoBMC3.numeroCupon = dto.numeroCupon
        //(4)Fin Si
        if (dto.getNumeroCupon() == null) {
            dtoBMC3.setNumeroCupon(dto.getNumeroFactura());
        } else {
            dtoBMC3.setNumeroCupon(dto.getNumeroCupon());
        }

        //-> dtoBMC3.oidCliente = dto.oidConsultoraReal;
        dtoBMC3.setOidCliente(dto.getOidConsultoraReal());

        //-> dtoBMC3.fechaMovimiento = dto.fechaPago;
        dtoBMC3.setFechaMovimiento(dto.getFechaPago());

        //-> Tomar el valor del atributo "dto.cuentaCorrienteBancaria" para la siguiente llamada
        //-> Llamar al método "DAOCCC.obtenerOIDBancoPorOIDCC(dtoOIDCC : DTOOID) : DTOOID"
        DAOCCC daoCCC = new DAOCCC();
        DTOOID dtoOID = new DTOOID();
        DTOOID dtoOID1 = new DTOOID();
        dtoOID.setOid(dto.getCuentaCorrienteBancaria()); //VER JPB CAMBIO
        dtoOID1 = daoCCC.obtenerOIDBancoPorOIDCC(dtoOID); //VER

        //-> dtoBMC3.oidBanco = oid contenido en el dto de respuesta de la llamada anterior
        dtoBMC3.setOidBanco(dtoOID1.getOid());

        //-> dtoBMC3.situacion = CCCConstantes.SITUACION_CUPON_TRAMITE;
        dtoBMC3.setSituacion(CCCConstantes.SITUACION_CUPON_TRAMITE);

        //-> dtoBMC3.importe = dto.importePago;
        dtoBMC3.setImporte(dto.getImportePago());

        //-> Tomar "dtoBMC3" para la siguiente llamada
        //-> Llamar al método "DAOActualizarCCporAplicacion.buscarMovCupon3(dto : DTOBuscarMovCupon3) : DTOSalida";
        
        
        //-> Crear variable llamada "situacion" de tipo Long inicializada a null
        Long situacion = null;
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
        if (aplicaCupon3) {
            DAOActualizarCCporAplicacion daoActualizarCCporAplicacion = new DAOActualizarCCporAplicacion();
            DTOSalida dtoS = new DTOSalida();
            dtoS = daoActualizarCCporAplicacion.buscarMovCupon3(dtoBMC3, numeroDiasCruceCupon3);
    
            //-> Crear variable llamada "situacion" de tipo Long inicializada a null
            //Long situacion = null;
    
            // Si hay cupon3
            //(5)Si el RecordSet contenido en el dto respuesta de la llamada anterior tiene registros entonces
            //-> Tomar el registro, sólo debe tener uno
            if (dtoS.getResultado().getRowCount() > 0) {
                UtilidadesLog.debug("buscarMovCupon3, con registros!");
                //-> Crear variable llamada "oidSituacionCupon" de tipo Long
                Long oidSituacionCupon = null;
    
                //-> oidSituacionCupon = registro.get("OID_DETA_CUPO_TRAM_DEPU")
                oidSituacionCupon = new Long(((BigDecimal) dtoS.getResultado()
                                                               .getValueAt(0,
                            "OID_DETA_CUPO_TRAM_DEPU")).longValue());
    
                //-> Llamar al método "findByPrimaryKey()" de la entidad "DetalleCuponesTramiteDepuracion" pasando oidSituacionCupon
                /*DetalleCuponesTramiteDepuracionLocalHome detalleCuponesTramiteDepuracionLocalHome =
                    this.getDetalleCuponesTramiteDepuracionLocalHome();
                DetalleCuponesTramiteDepuracionLocal detalleCuponesTramiteDepuracionLocal =
                    null;
    
                try {
                    detalleCuponesTramiteDepuracionLocal = detalleCuponesTramiteDepuracionLocalHome.findByPrimaryKey(oidSituacionCupon);
                } catch (NoResultException e) {
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    this.logearError("detalleCuponesTramiteDepuracionLocalHome: FinderException",
                        e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                } SCS, se comenta xq' no funca el finder y porq' el dientudo es amargo! (24/06/2008)*/
    
                //-> Tomar el valor de la constante "CCCConstantes.SITUACION_CUPON_CONCILIADO" para la siguiente llamada
                //-> Llamar al método "DAOCCC.obtenerOIDSituacionCuponPorCodigo(codigo : String) : DTOOID"
                dtoOID = daoCCC.obtenerOIDSituacionCuponPorCodigo(CCCConstantes.SITUACION_CUPON_CONCILIADO);
    
                //-> situacion = oid contenido en el DTOOID respuesta de la llamada anterior
                situacion = dtoOID.getOid();
                
                //cambio fac 03, modulo ccc (SCS-29/01/2008)
                //2.1. Si existe cupón 3, se marca el cupón como aplicado por banco, para ello se actualiza el 
                //atributo Situación con el valor “Conciliado”.
                
                daoActualizarCCporAplicacion.actDetalleCuponesTramiteDepuracion(oidSituacionCupon, situacion);
                //detalleCuponesTramiteDepuracionLocal.setSituacion(situacion);
    
                //-> Llamar al método "findByPrimaryKey()" de la entidad "MovimientoBancario" pasando "dto.oid"
                /*MovimientosBancariosLocalHome movimientosBancariosLocalHome = this.getMovimientosBancariosLocalHome();
                MovimientosBancariosLocal movimientosBancariosLocal = null;
    
                try {
                    movimientosBancariosLocal = movimientosBancariosLocalHome.findByPrimaryKey(dto.getOid());
                } catch (FinderException e) {
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    this.logearError("MovimientosBancariosLocalHome: FinderException",
                        e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }SCS, esto se comenta por las dudas por el mismo motivo! (24/06/2008)*/
    
                //-> MovimientoBancario.codigoError = "05"
                //movimientosBancariosLocal.setCodigoError("05");
                
                daoActualizarCCporAplicacion.actMovBarios(dto.getOid(), new String("05"));
                dto.setCodError(new String("05"));
    
                //(5)Fin Si
            }
        }else{
            //Si no, continúa con la siguiente actividad.    
        }
        //-> Devolver "situacion"
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validarCupon3(DTOMovimientoBancario dto, long numeroDiasCruceCupon3, boolean aplicaCupon3): Salida");

        return situacion;
    }

    public DTOAlerta generarAlertas(DTOGenerarAlertas dto)
        throws MareException {
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.generarAlertas(DTOGenerarAlertas dto): Entrada");

        //Entrada: DTOGenerarAlertas dtoE 
        //Salida: DTOAlerta dtoS 
        //Obtenemos la interface Home de la entidad SEG.Pais 
        PaisLocalHome paisLocalHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        //objetoPais=homePais.findByPrimaryKey(dtoE.pais); 
        try {
            paisLocal = paisLocalHome.findByPrimaryKey(dto.getOidPais());
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logearError("generarAlertas: FinderException", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Long porcAlarma = paisLocal.getVal_porc_alar();

        //Long deudacliente = new Long(0);

        DTOAlerta dtoAlerta = new DTOAlerta();
        DTOSaldosPorFechasyVtos dtoSaldos = new DTOSaldosPorFechasyVtos();

        dtoSaldos.setOidCliente(dto.getOidCliente());
        dtoSaldos.setOidPais(dto.getOidPais());

        DTOTotal dtoTotal = new DTOTotal();
        BigDecimal deudaCliente = new BigDecimal(0);
        
        UtilidadesLog.info("dto.getSaldoUnico() " + dto.getSaldoUnico());

        if (dto.getSaldoUnico().booleanValue()) { //Si el país va por la saldoUnico

            //DTOTotal dtoTotal= MONInterfaceModulos.calcularSaldoCCCliente(dtoSaldos);
            MONInterfaceModulos monInterfaceModulos = this.getMONInterfaceModulos();

            try {
                dtoTotal = monInterfaceModulos.calcularSaldoCCCliente(dtoSaldos);
            } catch (RemoteException re) {
                UtilidadesLog.error("*** Error en generarAlertas", re);

                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            deudaCliente = dtoTotal.getTotal();
            UtilidadesLog.info("deudaCliente : " + deudaCliente);

        } else { //No por Saldo único

            String proceso = "CON001";
            Integer subproceso = new Integer(1);
            DAOCCC daoCCC = new DAOCCC();
            RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoSalida(proceso,
                    subproceso, dto.getOidPais());
                    
             UtilidadesLog.info("recordset :" + recordset.toString());       

            //numeroDocu pasa a ser  Long por la incidencia 9810
            Long numeroDocu = (dto.getNumeroCupon() != null)
                ? dto.getNumeroCupon()
                : new Long(dto.getNumeroFactuBoleta().longValue());

            //Creamos un array de OIDs (Long[] oidsMarcaSituacion) con los datos de la columna:OID_MARC_SITU.
            Long[] oidsMarcaSituacion = new Long[recordset.getRowCount()];

            for (int i = 0; i < recordset.getRowCount(); i++) {
                oidsMarcaSituacion[i] = new Long(((BigDecimal) recordset.getValueAt(
                            i, "OID_MARC_SITU")).longValue());
            }

            DAOActualizarCCporAplicacion daoActualizarCCporAplicacion = new DAOActualizarCCporAplicacion();
            dtoTotal = daoActualizarCCporAplicacion.calcularSaldoNoUnicoPendiente(dtoSaldos,
                    oidsMarcaSituacion, numeroDocu);

            deudaCliente = dtoTotal.getTotal();
            
            UtilidadesLog.info("deudaCliente : " + deudaCliente);
        }
		
        if (deudaCliente.doubleValue() > 0) { //Si la deuda es positiva
            UtilidadesLog.info("dto.getImportePago() : " + dto.getImportePago());
            UtilidadesLog.info("deudaCliente : " + deudaCliente);
            
            double excedente = dto.getImportePago().doubleValue() - deudaCliente.doubleValue();
            UtilidadesLog.info("excedente : " + excedente);

			   double porcentaje =  excedente/deudaCliente.doubleValue() * 100;
            
            UtilidadesLog.info("porcentaje : " + porcentaje);
            UtilidadesLog.info("porcAlarma : " + porcAlarma);

            if (porcentaje > porcAlarma.doubleValue()) {
                // incidencia BELC300010464
                dtoAlerta.setIndAlerta(Boolean.TRUE);
                dtoAlerta.setCodigoMensajeAlerta(ErroresDeNegocio.IMPORTE_MOV_BANC_SUPERIOR_DEUDA);
                ArrayList parametrosAlerta = new ArrayList();
                parametrosAlerta.add(new Double(porcentaje));
                parametrosAlerta.add(deudaCliente);
                dtoAlerta.setParametrosAlerta(parametrosAlerta);
            } else {
                dtoAlerta.setIndAlerta(Boolean.FALSE);
            }
        } else { //Deuda del cliente negativa o cero
            dtoAlerta.setIndAlerta(Boolean.TRUE);
            dtoAlerta.setCodigoMensajeAlerta(ErroresDeNegocio.DEUDA_CLIENTE_MENOR_IGUAL_CERO);
        }

        UtilidadesLog.info(" dtoAlerta : " + dtoAlerta);
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.generarAlertas(DTOGenerarAlertas dto): Salida");

        return dtoAlerta;
    }

    private MONInterfaceModulos getMONInterfaceModulos()
        throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONInterfaceModulos(): Entrada");

        MONInterfaceModulosHome home = (MONInterfaceModulosHome) UtilidadesEJB.getHome("MONInterfaceModulos",
                MONInterfaceModulosHome.class);

        // Se obtiene el interfaz remoto
        MONInterfaceModulos ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONInterfaceModulosHome", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONInterfaceModulos(): Salida");

        return ejb;
    }

    private void logearError(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.logearError(String mensaje, Throwable e): Entrada");
        UtilidadesLog.error(e);
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.logearError(String mensaje, Throwable e): Salida");
    }

    private void loguearSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.loguearSql(String metodo, String sql, Vector params): Entrada");
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
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.loguearSql(String metodo, String sql, Vector params): Salida");
    }

    private DetalleCuponesTramiteDepuracionLocalHome getDetalleCuponesTramiteDepuracionLocalHome()
        throws MareException {
        
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getDetalleCuponesTramiteDepuracionLocalHome(): Entrada");
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getDetalleCuponesTramiteDepuracionLocalHome(): Salida");
        
        return new DetalleCuponesTramiteDepuracionLocalHome();
    }

    private MovimientosBancariosLocalHome getMovimientosBancariosLocalHome()
        throws MareException {
        
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMovimientosBancariosLocalHome(): Entrada");
        
        MovimientosBancariosLocalHome movimientosBancariosLocalHome = (MovimientosBancariosLocalHome) UtilidadesEJB.getLocalHome(
                "java:comp/env/MovimientosBancarios");

        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMovimientosBancariosLocalHome(): Salida");
        
        return movimientosBancariosLocalHome;
    }

    private PaisLocalHome getPaisLocalHome() throws MareException {
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getPaisLocalHome(): Entrada");
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getPaisLocalHome(): Salida");

        return new PaisLocalHome();
    }

    private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome()
        throws MareException {
        
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getCabeceraCargosAbonosDirectosLocalHome(): Entrada");
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getCabeceraCargosAbonosDirectosLocalHome(): Salida");

        return new CabeceraCargosAbonosDirectosLocalHome();
    }


    private DTORecuperacionTASPYMarcas recuperarTiposAbonoSubprocesoYMarcasSituacionFijo(
        DTOMovimientoBancario dto) throws MareException {
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Entrada");
    UtilidadesLog.info("******************** DTOMovimientoBancario:" + dto);
        
        //-> Crear variable llamada "respuesta" de tipo DTORecuperacionTASPYMarcas
        DTORecuperacionTASPYMarcas respuesta = new DTORecuperacionTASPYMarcas();

			/*
			DTORecuperacionTASPYMarcas: 
			- dtoBuscar : DTOBuscarCuotasAplicar 
			- cuentaContable : Long 
			- marcasEntrada : Long[] 
			- importeASaldar : BigDecimal 
			- tipoAbonoTES : Long 
			- tipoAbonoCCC : Long 
			- oidSubprocesoCCC : Long 
			*/ 

        //-> Crear variable llamada "proceso" de tipo String
        String proceso;

        //-> Crear variable llamada "subproceso" de tipo String
        Integer subproceso;

        // Movimiento Bancario
        
        /* SCS, segun inc.: BELC300021792
        proceso = "TES002";
        subproceso = new Integer(1);
        */
        //proceso = "TES001";
        proceso = CCCConstantes.APLIC_AUTOMATICA_MOV_BANC;
        subproceso = new Integer(1);
        

        //-> Tomar proceso, subproceso y dto.pais para la siguiente llamada
        //-> Llamar al método "DAOCCC.obtenerOIDSubproceso(codigoProceso : String, codigoSubproceso : Integer, pais : Long) : Long"
        //-> Crear variable llamada "oidSubprocesoTES" de tipo Long y asignarle la respuesta a la llamada anterior
        DAOCCC daoCCC = new DAOCCC();
        
        /* @ssaavedr se elimina por inc: BELC300022992
        Long oidSubprocesoTES = daoCCC.obtenerOIDSubproceso(dto.getOidPais(),
                proceso, subproceso);

        //-> Tomar oidSubprocesoTES y dto.idioma como parámetros para la siguiente llamada
        //-> Llamar al método "DAOCCC.obtenerTiposCargoSubproceso(subproceso : Long, idioma : Long) : Recordset"
        RecordSet rs = daoCCC.obtenerTiposCargoSubproceso(oidSubprocesoTES,
                dto.getOidIdioma());
        */        
        
        // @ssaavedr se agrega por inc: BELC300022992
        //RecordSet rs = daoCCC.obtenerTiposAbonoSubproceso(proceso, subproceso, dto.getOidIdioma());
        // cvalenzu - 23/10/2006 - se le pasaba idioma pero la consulta usa pais
        RecordSet rs = daoCCC.obtenerTiposAbonoSubproceso(proceso, subproceso, dto.getOidPais());

        //-> Crear variable llamada "tipoAbonoTES" de tipo Long y asignarle el oid del primer registro del RecordSet obtenido en la llamada anterior
        if (!rs.esVacio()) {
                Long tipoAbonoTES = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
                Long tipoCargoAbonoTES = new Long(((BigDecimal) rs.getValueAt(0, 3)).longValue());
				// respuesta.tipoAbonoTES = oid del primer registro del RecordSet obtenido en la llamada anterior
				respuesta.setTipoAbonoTES(tipoAbonoTES);	
                //@ssaavedr, se modifica por inc.: BELC300022992
                respuesta.setTipoCargoAbonoTES(tipoCargoAbonoTES);
                if(rs.getValueAt(0,1)!=null){
                  respuesta.setSubProcesoBancarioSalida(new Long(rs.getValueAt(0,1).toString()));   
                }
                
        }

        // Movimiento de Cuenta
        //proceso = "CCC002";
        proceso = CCCConstantes.PROCESO_ACTUALIZ_AUT_CANCELACION_DEUDA;

        //-> Tomar proceso, subproceso y dto.pais para la siguiente llamada
        //-> Llamar al método "DAOCCC.obtenerOIDSubproceso(codigoProceso : String, codigoSubproceso : Integer, pais : Long) : Long"
        //-> Crear variable llamada "oidSubprocesoCCC" de tipo Long y asignarle la respuesta a la llamada anterior
        //Long oidSubprocesoCCC = daoCCC.obtenerOIDSubproceso(dto.getOidPais(), proceso, subproceso);
        
        //
        RecordSet datosSubProceso = daoCCC.obtenerDatosSubproceso(dto.getOidPais(), proceso, subproceso);
        UtilidadesLog.debug("Obtiene Datos SubProceso: "+datosSubProceso);
        respuesta.setOidSubprocesoCCC(new Long(datosSubProceso.getValueAt(0,"OID_SUBP").toString()));
        Long indicador = new Long(datosSubProceso.getValueAt(0,"VAL_INDI_ACTU_CUOT").toString());
        if(indicador.intValue()==0){
         respuesta.setIndicadorActualizaCuotaConImportePagado(new Boolean("False"));
         UtilidadesLog.debug("setIndicadorActualizaCuotaConImportePagado: False");
        }else{
         respuesta.setIndicadorActualizaCuotaConImportePagado(new Boolean("True"));
         UtilidadesLog.debug("setIndicadorActualizaCuotaConImportePagado: True");
        }
        
        
        
        //-> Tomar oidSubprocesoCCC y dto.idioma como parámetros para la siguiente llamada
        //-> Llamar al método "DAOCCC.obtenerTiposCargoSubproceso(subproceso : Long, idioma : Long) : Recordset"
        
        /* @ssaavedr se elimina por inc: BELC300022992
        rs = daoCCC.obtenerTiposCargoSubproceso(oidSubprocesoCCC,
                dto.getOidIdioma());
        */
        // @ssaavedr se agrega por inc: BELC300022992
        //rs = daoCCC.obtenerTiposAbonoSubproceso(proceso, subproceso, dto.getOidIdioma());
        // cvalenzu - 23/10/2006 - se le pasaba idioma pero la consulta usa pais
        rs = daoCCC.obtenerTiposAbonoSubproceso(proceso, subproceso, dto.getOidPais());

        //-> Crear variable llamada "tipoAbonoCCC" de tipo Long y asignarle el oid del primer registro del RecordSet obtenido en la llamada anterior
        if (!rs.esVacio()) {
            //respuesta.tipoAbonoCCC = oid del primer registro del RecordSet obtenido en la llamada anterior 
            Long tipoAbonoCCC = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
            respuesta.setTipoAbonoCCC(tipoAbonoCCC);
            
            //cvalenzu - 24/10/2006 - se le pasaba la posicion 0 del recordset
            //tanto a tipoAbonoCCC como a tipoCargoAbonoCCC, se debe
            //pasar la posicion 3, como en el caso de tipoAbonoTES y tipoCargoAbonoTES
            Long tipoCargoAbonoCCC = new Long(((BigDecimal) rs.getValueAt(0, 3)).longValue());         
            //Long tipoCargoAbonoCCC = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());         
            //@ssaavedr, se modifica por inc.: BELC300022992
            respuesta.setTipoCargoAbonoCCC(tipoCargoAbonoCCC);
        }
        
        // Cuenta contable
        //-> Tomar proceso, oidSubprocesoCCC y dto.pais como parámetros para la siguiente llamada
        //-> Llamar al método "DAOCC.obtenerTiposAbonoSubprocesoCContable(codProceso : String, codSubproceso : Integer, pais : Long) : DTOSalida"
        DTOSalida dtoS = new DTOSalida();
        dtoS = daoCCC.obtenerTiposAbonoSubprocesoCContable(dto.getOidPais(),
                proceso, subproceso);

        respuesta.setCuentaContable(new Long(
                ((BigDecimal) dtoS.getResultado().getValueAt(0,
                    "CUCO_OID_CUEN_CONT")).longValue()));

        // Obtenemos Marcas de Entrada para filtrar las cuotas y Marcas de Salida para actualizarlas
        // Nota: Los MovimientosBancarios no funcionan con Marcas de Situación
        //-> Tomar proceso, oidSubprocesoCCC y dto.pais como parámetros para la siguiente llamada
        rs = daoCCC.obtenerMarcasTipoAbonoSalida(proceso, subproceso,
                dto.getOidPais());

        Long[] marcasSalida = new Long[2];

        if (rs.getRowCount() > 0) {
            marcasSalida[0] = new Long(((BigDecimal) rs.getValueAt(0,
                        "OID_MARC_SITU")).longValue());
            marcasSalida[1] = new Long(((BigDecimal) rs.getValueAt(0,
                        "TASP_OID_TIPO_ABON_SUBP")).longValue());
        }

        respuesta.setMarcasSalida(marcasSalida); //Preguntar = Mapear el primer registro del RecordSet obtenido en la llamada anterior

        //-> Tomar proceso, oidSubprocesoCCC y dto.pais como parámetros para la siguiente llamada
        rs = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso, subproceso,
                dto.getOidPais());

        //Long[] marcasEntrada = new Long[rs.getColumnCount()];
		// antes se creaba un array de 3 elementos, pero solo se rellenaban
		// los 2 primeros
        
        //@ssaavedr, modificado por inc.:BELC300023531, inc. bloq. de peru
        //Long[] marcasEntrada = new Long[2];
        Long[] marcasEntrada = new Long[rs.getRowCount()];

        if (rs.getRowCount() > 0) {
            for (int i = 0; i < rs.getRowCount();i++) {
                marcasEntrada[i] = new Long((((BigDecimal) rs.getValueAt(i, "OID_MARC_SITU"))).longValue());
            }
            //marcasEntrada[0] = new Long(((BigDecimal) rs.getValueAt(0,
            //            "OID_MARC_SITU")).longValue());
            //marcasEntrada[1] = new Long(((BigDecimal) rs.getValueAt(0,
            //            "TASP_OID_TIPO_ABON_SUBP")).longValue());
        }

        //Cambia por lo Hablado con Antonio poyatos 10002, campo no necesario
        //respuesta.setMarcasEntrada(marcasEntrada); 
        //-> Crear variable llamada "indEmisionVto" de tipo String, y asignarle la respuesta a la llamada anterior	
        String indEmisionVto = (daoCCC.obtenerIndEmisionVtoPais(dto.getOidPais())).toString();
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Salida");
        DTOBuscarCuotasAplicar dtoB = new DTOBuscarCuotasAplicar();
        dtoB.setMarcasSituacion(marcasEntrada);
        dtoB.setIndEmisionVto(indEmisionVto);
        respuesta.setDtoBuscar(dtoB);
        //Devolver "respuesta"
        return respuesta;
    }

    private void recuperarTiposAbonoSubprocesoYMarcasSituacionVariable(
        DTOMovimientoBancario dto,  DTORecuperacionTASPYMarcas entrada) throws MareException {
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Entrada");
      UtilidadesLog.info("******************** DTOMovimientoBancario:" + dto);
        // Localizamos las cuotas a aplicar (saldar)
        DTOBuscarCuotasAplicar dtoB = entrada.getDtoBuscar();

        dtoB.setOidCliente(dto.getOidConsultoraReal());
        dtoB.setOidEmpresa(dto.getEmpresa());
        dtoB.setImportePago(dto.getImportePago());
        if (dto.getNumeroCupon()!=null)
            dtoB.setNumeroIdentCuota(new Integer(dto.getNumeroCupon().intValue()));

        entrada.setImporteASaldar(dto.getImportePago());
       UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Salida");
    }
   

    public DTORecuperacionTASPYMarcas recuperarTiposAbonoSubprocesoYMarcasSituacion(
        DTOMovimientoBancario dto) throws MareException {
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Entrada");
      UtilidadesLog.info("******************** DTOMovimientoBancario:" + dto);
        
        //-> Crear variable llamada "respuesta" de tipo DTORecuperacionTASPYMarcas
        DTORecuperacionTASPYMarcas respuesta = new DTORecuperacionTASPYMarcas();
        // Localizamos las cuotas a aplicar (saldar)
        DTOBuscarCuotasAplicar dtoB = new DTOBuscarCuotasAplicar();

        dtoB.setOidCliente(dto.getOidConsultoraReal());
        dtoB.setOidEmpresa(dto.getEmpresa());
        dtoB.setImportePago(dto.getImportePago());
        if (dto.getNumeroCupon()!=null)
            dtoB.setNumeroIdentCuota(new Integer(dto.getNumeroCupon().intValue()));

        respuesta.setDtoBuscar(dtoB);
        respuesta.setImporteASaldar(dto.getImportePago());
        
       UtilidadesLog.info("MONActualizarCCporAplicacionBean.recuperarTiposAbonoSubprocesoYMarcasSituacion(DTOMovimientoBancario dto): Salida");
        
        //Devolver "respuesta"
        return respuesta;
    }


    public DTORespuestaCancelacion cancelarCCSaldoUnico(
        DTORecuperacionTASPYMarcas dto) throws MareException{
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.cancelarCCSaldoUnico(DTORecuperacionTASPYMarcas dto): Entrada");
        
        //Entrada:
        //- dto : DTORecuperacionTASPYMarcas
        //Proceso:
        //-> Tomar dto.dtoBuscar, de tipo DTOBuscarCuotasAplicar para la siguiente llamada
        DAOActualizarCCporAplicacion daoActualizarCCporAplicacion = new DAOActualizarCCporAplicacion();
        DTOSalida dtoS = new DTOSalida();
        dtoS = daoActualizarCCporAplicacion.buscarCCporFechaAplicar(dto.getDtoBuscar());

        //-> Recorremos el RecordSet contenido en el DTOSalida de respuesta a la llamada anterior
        //-> Crear variable llamada "importeASaldar" de tipo BigDecimal y asignarle "dto.importeASaldar"
        BigDecimal importeASaldar = new BigDecimal(dto.getImporteASaldar().doubleValue());
        UtilidadesLog.debug("- GA - importeASaldar Inicial: "+importeASaldar);

        //-> Crear variable llamada "respuesta" de tipo DTOCancelacionCCSaldoNoUnico
        DTORespuestaCancelacion respuesta = new DTORespuestaCancelacion();

        ArrayList movCCSaldados = new ArrayList();

        //(1)Para cada registro hacer
        for (int i = 0; i < dtoS.getResultado().getRowCount(); i++){
            //-> Crear variable llamada "dtoMovCC" de tipo DTOMovimientoCuentaCompleto mapeando los datos del registro en él
            DTOMovimientoCuentaCompleto dtoMovCC = new DTOMovimientoCuentaCompleto();
            if (dtoS.getResultado().getValueAt(i, "oid_movi_cc".toUpperCase()) != null){
                dtoMovCC.setOid(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "oid_movi_cc".toUpperCase())).longValue()));
            }
            if (dtoS.getResultado().getValueAt(i, "soci_oid_soci".toUpperCase()) != null){
                dtoMovCC.setEmpresa(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "soci_oid_soci".toUpperCase())).longValue()));
            }
            if (dtoS.getResultado().getValueAt(i,
                        "masi_oid_marc_situ".toUpperCase()) != null){
                dtoMovCC.setMarcaSituacion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "masi_oid_marc_situ".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "mone_oid_mone".toUpperCase()) != null){
                dtoMovCC.setOidMoneda(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "mone_oid_mone".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "perd_oid_peri".toUpperCase()) != null){
                dtoMovCC.setPeriodoDesde(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "perd_oid_peri".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tcab_oid_tcab_ulti".toUpperCase()) != null){
                dtoMovCC.setTipoAbonoUltimo( new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tcab_oid_tcab_ulti".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "TCAB_OID_TCAB_CREA".toUpperCase()) != null){
                dtoMovCC.setTipoAbonoCreacion( new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "TCAB_OID_TCAB_CREA".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "sbac_oid_sbac".toUpperCase()) != null){
                dtoMovCC.setSubacceso(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "sbac_oid_sbac".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "subp_oid_subp_ulti".toUpperCase()) != null){
                dtoMovCC.setSubprocesoUltimo(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "subp_oid_subp_ulti".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "subp_oid_subp_crea".toUpperCase()) != null){
                dtoMovCC.setSubprocesoCreacion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "subp_oid_subp_crea".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "cuco_oid_cuen_cont_orig".toUpperCase()) != null){
                dtoMovCC.setCuentaOrigen(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "cuco_oid_cuen_cont_orig".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "cuco_oid_cuen_cont_cuot".toUpperCase()) != null){
                dtoMovCC.setCuentaCuota(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "cuco_oid_cuen_cont_cuot".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "clie_oid_clie".toUpperCase()) != null){
                dtoMovCC.setOidCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "clie_oid_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_docu_anio".toUpperCase()) != null){
                dtoMovCC.setDocumentoAnyo((String)dtoS.getResultado().getValueAt(i,"val_docu_anio".toUpperCase()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_docu_mes_seri".toUpperCase()) != null){
                dtoMovCC.setDocumentoMesSerie(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_docu_mes_seri".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "val_docu_nume".toUpperCase()) != null){
                dtoMovCC.setDocumentoNumero(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_docu_nume".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_ejer_cuot".toUpperCase()) != null){
                dtoMovCC.setEjercicioCuota(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ejer_cuot".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_conta".toUpperCase()) != null){
                dtoMovCC.setFechaContabilizacion(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_conta".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_docu".toUpperCase()) != null){
                dtoMovCC.setFechaDocumento(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_docu".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_ulti_movi".toUpperCase()) != null){
                dtoMovCC.setFechaUltimoMovimiento(new Timestamp(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_ulti_movi".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_valo".toUpperCase()) != null){
                dtoMovCC.setFechaValor(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_valo".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_venc".toUpperCase()) != null){
                dtoMovCC.setFechaVencimiento(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_venc".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_movi_cuen".toUpperCase()) != null){
                dtoMovCC.setImporteMovimiento(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi_cuen".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_divi".toUpperCase()) != null){
                dtoMovCC.setImporteDivisa(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_paga".toUpperCase()) != null){
                dtoMovCC.setImportePagado(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_paga".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_paga_divi".toUpperCase()) != null){
                dtoMovCC.setImportePagadoDivisa(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_paga_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pend".toUpperCase()) != null){
                dtoMovCC.setImportePendiente(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pend".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "num_iden_cuot".toUpperCase()) != null){
                dtoMovCC.setNumeroIdentificadorCuota(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_iden_cuot".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_nume_lote_cont".toUpperCase()) != null){
                dtoMovCC.setNumeroLoteContabilizacion(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_nume_lote_cont".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "num_orde_cuot".toUpperCase()) != null){
                dtoMovCC.setNumeroOrdenCuota(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_orde_cuot".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_obse".toUpperCase()) != null){
                dtoMovCC.setObservaciones(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_obse".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_refe_nume_docu_exte".toUpperCase()) != null){
                dtoMovCC.setReferenciaNumeroDocumentoExterno(
                              ((String) dtoS.getResultado().getValueAt(i,
                            "val_refe_nume_docu_exte".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_anio".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoAnyo(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_anio".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_mes_seri".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoMesSerie(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_mes_seri".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_nume".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoNumero(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_nume".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_nume_hist".toUpperCase()) != null){
                dtoMovCC.setUltimoNumeroHistoria(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_ulti_nume_hist".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "mpab_oid_medi_pago".toUpperCase()) != null){
                dtoMovCC.setMedioPago(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "mpab_oid_medi_pago".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "ztad_oid_terr_admi".toUpperCase()) != null){
                dtoMovCC.setTerritorioAdministrativo(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ztad_oid_terr_admi".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "ticl_oid_tipo_clie".toUpperCase()) != null){
                dtoMovCC.setTipoCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ticl_oid_tipo_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "marc_oid_marc".toUpperCase()) != null){
                dtoMovCC.setMarca(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "marc_oid_marc".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pago".toUpperCase()) != null){
                dtoMovCC.setImportePago(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pago".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pago_divi".toUpperCase()) != null){
                dtoMovCC.setImportePagoDivisa(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pago_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_movi_divi".toUpperCase()) != null){
                dtoMovCC.setImporteMovimientoDivisa(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "num_lote_fact".toUpperCase()) != null){
                dtoMovCC.setNumeroLoteFactu(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_lote_fact".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "cod_usua".toUpperCase()) != null){
                dtoMovCC.setUsuario(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "cod_usua".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "ind_tipo_camb".toUpperCase()) != null){
                dtoMovCC.setTipoCambio(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ind_tipo_camb".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "zscc_oid_secc".toUpperCase()) != null){
                dtoMovCC.setOidSeccion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zscc_oid_secc".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "zsgv_oid_subg_vent".toUpperCase()) != null){
                dtoMovCC.setOidSugerenciaVenta(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zsgv_oid_subg_vent".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "soca_oid_soli_cabe".toUpperCase()) != null){
                dtoMovCC.setOidPedidoSolicitudCab(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "soca_oid_soli_cabe".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "sbti_oid_subt_clie".toUpperCase()) != null){
                dtoMovCC.setOidSubtipoCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "sbti_oid_subt_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tspa_oid_tipo_soli_pais".toUpperCase()) != null){
                dtoMovCC.setOidTipoSolicitud(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tspa_oid_tipo_soli_pais".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tipe_oid_tipo_peri".toUpperCase()) != null){
                dtoMovCC.setTipoPeriodoDesde(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tipe_oid_tipo_peri".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "zorg_oid_regi".toUpperCase()) != null){
                dtoMovCC.setOidRegion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zorg_oid_regi".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tido_oid_tipo_docu".toUpperCase()) != null){
                dtoMovCC.setOidTipoDocumentoLegal(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tido_oid_tipo_docu".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "imp_movi".toUpperCase()) != null){
                dtoMovCC.setImporte(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi".toUpperCase())).doubleValue()));
            }

            //modificado por Sapaza, fecha 12-11-2007, cambio COL-CCC-03
            BigDecimal importePendiente = new BigDecimal(dtoMovCC.getImportePendiente().doubleValue());
            if(importeASaldar.abs().doubleValue() >= importePendiente.abs().doubleValue()){
               //sumatoria de lo pagado cuota a cuota
               dtoMovCC.setImportePagado(dtoMovCC.getImporte());
               //importa de la cuota
               dtoMovCC.setImporteMovimiento(new BigDecimal(dtoMovCC.getImportePendiente().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_UP));
               //deuda restante
               dtoMovCC.setImportePendiente(new Double("0"));
               if(dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()){
                  //pago de la cuota
                  dtoMovCC.setImportePago(dtoMovCC.getImporteMovimiento());
                  if(new BigDecimal(dtoMovCC.getImportePendiente().
                           doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP).abs().doubleValue()==0D){
                     dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
                  }
               }else{
                  dtoMovCC.setImportePago(new BigDecimal("0"));
                  dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
               }
               //resto del movimiento bancario
               importeASaldar = importeASaldar.subtract(dtoMovCC.getImporteMovimiento()).setScale(2, BigDecimal.ROUND_HALF_UP);
               if(importeASaldar.abs().doubleValue()==0D){ importeASaldar = new BigDecimal("0");}
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePagado(1): "+dtoMovCC.getImportePagado());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePago(1): "+dtoMovCC.getImportePago());
               UtilidadesLog.debug("-GA- dtoMovCC.getImporteMovimiento(1): "+dtoMovCC.getImporteMovimiento());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePendiente(1): "+dtoMovCC.getImportePendiente());
               UtilidadesLog.debug("-GA- importeASaldar(1): "+importeASaldar);
            }else{
               dtoMovCC.setImportePagado(new Double(importeASaldar.doubleValue()+dtoMovCC.getImportePagado().doubleValue()));
               dtoMovCC.setImportePendiente(new Double(dtoMovCC.getImporte().doubleValue()-dtoMovCC.getImportePagado().doubleValue()));
               //se redondea para evitar impresiciones
               if(new BigDecimal(dtoMovCC.getImportePendiente().doubleValue()).
                                          setScale(2,BigDecimal.ROUND_HALF_UP).abs().doubleValue()==0D){
                  dtoMovCC.setImportePendiente(new Double("0"));
               }else{
                  dtoMovCC.setImportePendiente(new Double(new BigDecimal(dtoMovCC.getImportePendiente().doubleValue()).
                                          setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
               }
               dtoMovCC.setImporteMovimiento(importeASaldar);
               if(dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()){
                  //pago de la cuota
                  dtoMovCC.setImportePago(importeASaldar);
                  if(dtoMovCC.getImportePendiente().doubleValue()==0){
                     dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
                  }
               }else{
                  dtoMovCC.setImportePago(new BigDecimal("0"));
                  dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
               }
               importeASaldar = new BigDecimal(0);
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePagado(2): "+dtoMovCC.getImportePagado());
               UtilidadesLog.debug("-GA- dtoMovCC.getImporteMovimiento(2): "+dtoMovCC.getImporteMovimiento());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePendiente(2): "+dtoMovCC.getImportePendiente());
               UtilidadesLog.debug("-GA- importeASaldar(2): "+importeASaldar);
            }
            //-> Añadir dtoMovCC al arrayList "movCCSaldados"
            dtoMovCC.setTipoAbonoUltimo(dto.getOidTipoAbonoCreacionBanco());
            movCCSaldados.add(dtoMovCC);
            //(3)Si (importeASaldar == 0) entonces
            if (importeASaldar.doubleValue() == 0D) {break;}
            // -> Salir del bucle
            //(3)Fin Si
        }
         //(1)Fin Para
        respuesta.setImporteASaldar(importeASaldar);
        respuesta.setMovCCSaldados(movCCSaldados);
		  UtilidadesLog.info("MONActualizarCCporAplicacionBean.cancelarCCSaldoUnico(DTORecuperacionTASPYMarcas dto): Salida");
        //-> Devolver "respuesta"
        return respuesta;
    }

    public DTORespuestaCancelacion cancelarCCSaldoNoUnico(
        DTORecuperacionTASPYMarcas dto) throws MareException{
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.cancelarCCSaldoNoUnico(DTORecuperacionTASPYMarcas dto): Entrada");
        
        //Entrada:
        //- dto : DTORecuperacionTASPYMarcas
        //Proceso:
        //-> Tomar dto.dtoBuscar, de tipo DTOBuscarCuotasAplicar para la siguiente llamada
        DAOActualizarCCporAplicacion daoActualizarCCporAplicacion = new DAOActualizarCCporAplicacion();
        DTOSalida dtoS = new DTOSalida();
		  dtoS = daoActualizarCCporAplicacion.buscarCCporNumeroIdentAplicar(dto.getDtoBuscar());
        //-> Recorremos el RecordSet contenido en el DTOSalida de respuesta a la llamada anterior
        //-> Crear variable llamada "importeASaldar" de tipo BigDecimal y asignarle "dto.importeASaldar"
        BigDecimal importeASaldar = new BigDecimal(dto.getImporteASaldar().doubleValue());

        //-> Crear variable llamada "respuesta" de tipo DTOCancelacionCCSaldoNoUnico
        DTORespuestaCancelacion respuesta = new DTORespuestaCancelacion();

        ArrayList movCCSaldados = new ArrayList();

        /**
        DTORespuestaCancelacion:
        - movCCSaldados : ArrayList
        - importeASaldar : BigDecimal
        */

        //(1)Para cada registro hacer
        for (int i = 0; i < dtoS.getResultado().getRowCount(); i++){
            //-> Crear variable llamada "dtoMovCC" de tipo DTOMovimientoCuentaCompleto mapeando los datos del registro en él
            DTOMovimientoCuentaCompleto dtoMovCC = new DTOMovimientoCuentaCompleto();

            if (dtoS.getResultado().getValueAt(i, "oid_movi_cc".toUpperCase()) != null){
                dtoMovCC.setOid(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "oid_movi_cc".toUpperCase())).longValue()));
            }
            if (dtoS.getResultado().getValueAt(i, "soci_oid_soci".toUpperCase()) != null){
                dtoMovCC.setEmpresa(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "soci_oid_soci".toUpperCase())).longValue()));
            }
            if (dtoS.getResultado().getValueAt(i,
                        "masi_oid_marc_situ".toUpperCase()) != null){
                dtoMovCC.setMarcaSituacion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "masi_oid_marc_situ".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "mone_oid_mone".toUpperCase()) != null){
                dtoMovCC.setOidMoneda(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "mone_oid_mone".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "perd_oid_peri".toUpperCase()) != null){
                dtoMovCC.setPeriodoDesde(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "perd_oid_peri".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tcab_oid_tcab_ulti".toUpperCase()) != null){
                dtoMovCC.setTipoAbonoUltimo( new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tcab_oid_tcab_ulti".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "TCAB_OID_TCAB_CREA".toUpperCase()) != null){
                dtoMovCC.setTipoAbonoCreacion( new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "TCAB_OID_TCAB_CREA".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "sbac_oid_sbac".toUpperCase()) != null){
                dtoMovCC.setSubacceso(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "sbac_oid_sbac".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "subp_oid_subp_ulti".toUpperCase()) != null){
                dtoMovCC.setSubprocesoUltimo(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "subp_oid_subp_ulti".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "subp_oid_subp_crea".toUpperCase()) != null){
                dtoMovCC.setSubprocesoCreacion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "subp_oid_subp_crea".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "cuco_oid_cuen_cont_orig".toUpperCase()) != null){
                dtoMovCC.setCuentaOrigen(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "cuco_oid_cuen_cont_orig".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "cuco_oid_cuen_cont_cuot".toUpperCase()) != null){
                dtoMovCC.setCuentaCuota(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "cuco_oid_cuen_cont_cuot".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "clie_oid_clie".toUpperCase()) != null){
                dtoMovCC.setOidCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "clie_oid_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_docu_anio".toUpperCase()) != null){
                dtoMovCC.setDocumentoAnyo((String) dtoS.getResultado().getValueAt(i,
                            "val_docu_anio".toUpperCase()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_docu_mes_seri".toUpperCase()) != null){
                dtoMovCC.setDocumentoMesSerie(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_docu_mes_seri".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "val_docu_nume".toUpperCase()) != null){
                dtoMovCC.setDocumentoNumero(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_docu_nume".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_ejer_cuot".toUpperCase()) != null){
                dtoMovCC.setEjercicioCuota(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ejer_cuot".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_conta".toUpperCase()) != null){
                dtoMovCC.setFechaContabilizacion(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_conta".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_docu".toUpperCase()) != null){
                dtoMovCC.setFechaDocumento(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_docu".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_ulti_movi".toUpperCase()) != null){
                dtoMovCC.setFechaUltimoMovimiento(new Timestamp(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_ulti_movi".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_valo".toUpperCase()) != null){
                dtoMovCC.setFechaValor(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_valo".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "fec_venc".toUpperCase()) != null){
                dtoMovCC.setFechaVencimiento(new java.util.Date(
                        ((java.sql.Date) dtoS.getResultado().getValueAt(i,
                            "fec_venc".toUpperCase())).getTime()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_movi_cuen".toUpperCase()) != null){
                dtoMovCC.setImporteMovimiento(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi_cuen".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_divi".toUpperCase()) != null){
                dtoMovCC.setImporteDivisa(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_paga".toUpperCase()) != null){
                dtoMovCC.setImportePagado(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_paga".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_paga_divi".toUpperCase()) != null){
                dtoMovCC.setImportePagadoDivisa(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_paga_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pend".toUpperCase()) != null){
                
                dtoMovCC.setImportePendiente(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pend".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "num_iden_cuot".toUpperCase()) != null){
                dtoMovCC.setNumeroIdentificadorCuota(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_iden_cuot".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_nume_lote_cont".toUpperCase()) != null){
                dtoMovCC.setNumeroLoteContabilizacion(((String) dtoS.getResultado().getValueAt(i,
                            "val_nume_lote_cont".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "num_orde_cuot".toUpperCase()) != null){
                dtoMovCC.setNumeroOrdenCuota(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_orde_cuot".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "val_obse".toUpperCase()) != null){
                dtoMovCC.setObservaciones(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_obse".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_refe_nume_docu_exte".toUpperCase()) != null){
                dtoMovCC.setReferenciaNumeroDocumentoExterno(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_refe_nume_docu_exte".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_anio".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoAnyo(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_anio".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_mes_seri".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoMesSerie(
                        ((String) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_mes_seri".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_docu_nume".toUpperCase()) != null){
                dtoMovCC.setUltimoDocumentoNumero(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_ulti_docu_nume".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "val_ulti_nume_hist".toUpperCase()) != null){
                dtoMovCC.setUltimoNumeroHistoria(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "val_ulti_nume_hist".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "mpab_oid_medi_pago".toUpperCase()) != null){
                dtoMovCC.setMedioPago(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "mpab_oid_medi_pago".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "ztad_oid_terr_admi".toUpperCase()) != null){
                dtoMovCC.setTerritorioAdministrativo(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ztad_oid_terr_admi".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "ticl_oid_tipo_clie".toUpperCase()) != null){
                dtoMovCC.setTipoCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ticl_oid_tipo_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "marc_oid_marc".toUpperCase()) != null){
                dtoMovCC.setMarca(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "marc_oid_marc".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pago".toUpperCase()) != null){
                dtoMovCC.setImportePago(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pago".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_pago_divi".toUpperCase()) != null){
                dtoMovCC.setImportePagoDivisa(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_pago_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_movi".toUpperCase()) != null){
                dtoMovCC.setImporte(new Double(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "imp_movi_divi".toUpperCase()) != null){
                dtoMovCC.setImporteMovimientoDivisa(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "imp_movi_divi".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "num_lote_fact".toUpperCase()) != null){
                dtoMovCC.setNumeroLoteFactu(new Integer(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "num_lote_fact".toUpperCase())).intValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "cod_usua".toUpperCase()) != null){
                dtoMovCC.setUsuario(((String) dtoS.getResultado().getValueAt(i,
                            "cod_usua".toUpperCase())));
            }

            if (dtoS.getResultado().getValueAt(i, "ind_tipo_camb".toUpperCase()) != null){
                dtoMovCC.setTipoCambio(new BigDecimal(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "ind_tipo_camb".toUpperCase())).doubleValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "zscc_oid_secc".toUpperCase()) != null){
                dtoMovCC.setOidSeccion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zscc_oid_secc".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "zsgv_oid_subg_vent".toUpperCase()) != null){
                dtoMovCC.setOidSugerenciaVenta(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zsgv_oid_subg_vent".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "soca_oid_soli_cabe".toUpperCase()) != null){
                dtoMovCC.setOidPedidoSolicitudCab(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "soca_oid_soli_cabe".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "sbti_oid_subt_clie".toUpperCase()) != null){
                dtoMovCC.setOidSubtipoCliente(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "sbti_oid_subt_clie".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tspa_oid_tipo_soli_pais".toUpperCase()) != null){
                dtoMovCC.setOidTipoSolicitud(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tspa_oid_tipo_soli_pais".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tipe_oid_tipo_peri".toUpperCase()) != null){
                dtoMovCC.setTipoPeriodoDesde(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tipe_oid_tipo_peri".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i, "zorg_oid_regi".toUpperCase()) != null){
                dtoMovCC.setOidRegion(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "zorg_oid_regi".toUpperCase())).longValue()));
            }

            if (dtoS.getResultado().getValueAt(i,
                        "tido_oid_tipo_docu".toUpperCase()) != null){
                dtoMovCC.setOidTipoDocumentoLegal(new Long(
                        ((BigDecimal) dtoS.getResultado().getValueAt(i,
                            "tido_oid_tipo_docu".toUpperCase())).longValue()));
            }

            //modificado por Sapaza, fecha 12-11-2007, cambio COL-CCC-03
            BigDecimal importePendiente = new BigDecimal(dtoMovCC.getImportePendiente().doubleValue());
            if(importeASaldar.abs().doubleValue() >= importePendiente.abs().doubleValue()){
               //sumatoria de lo pagado cuota a cuota
               dtoMovCC.setImportePagado(dtoMovCC.getImporte());
               //importa de la cuota
               dtoMovCC.setImporteMovimiento(new BigDecimal(dtoMovCC.getImportePendiente().doubleValue()));
               //deuda restante
               dtoMovCC.setImportePendiente(new Double("0"));
               if(dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()){
                  //pago de la cuota
                  dtoMovCC.setImportePago(new BigDecimal(dtoMovCC.getImporteMovimiento().doubleValue()));
                  if(dtoMovCC.getImportePendiente().doubleValue()==0){
                     dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
                  }
               }else{
                  dtoMovCC.setImportePago(new BigDecimal("0"));
                  dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
               }
               //resto del movimiento bancario
               importeASaldar = importeASaldar.subtract(dtoMovCC.getImporteMovimiento()).
                                       setScale(2,BigDecimal.ROUND_HALF_UP);
               if(importeASaldar.abs().doubleValue()==0D){ importeASaldar = new BigDecimal("0"); }
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePagado(1): "+dtoMovCC.getImportePagado());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePago(1): "+dtoMovCC.getImportePago());
               UtilidadesLog.debug("-GA- dtoMovCC.getImporteMovimiento(1): "+dtoMovCC.getImporteMovimiento());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePendiente(1): "+dtoMovCC.getImportePendiente());
               UtilidadesLog.debug("-GA- importeASaldar(1): "+importeASaldar);
            }else{
               dtoMovCC.setImportePagado(new Double(importeASaldar.doubleValue()+dtoMovCC.getImportePagado().doubleValue()));
               dtoMovCC.setImportePendiente(new Double(dtoMovCC.getImporte().doubleValue()-dtoMovCC.getImportePagado().doubleValue()));
               if(new BigDecimal(dtoMovCC.getImportePendiente().doubleValue()).
                              setScale(2,BigDecimal.ROUND_HALF_UP).abs().doubleValue()==0D){
                  dtoMovCC.setImportePendiente(new Double("0"));
               }
               dtoMovCC.setImporteMovimiento(importeASaldar);
               if(dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()){
                  //pago de la cuota
                  dtoMovCC.setImportePago(importeASaldar);
                  if(dtoMovCC.getImportePendiente().doubleValue()==0){
                     dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
                  }
               }else{
                  dtoMovCC.setImportePago(new BigDecimal("0"));
                  dtoMovCC.setMarcaSituacion(dto.getMarcasSalida()[0]);
               }
               importeASaldar = new BigDecimal(0);
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePagado(2): "+dtoMovCC.getImportePagado());
               UtilidadesLog.debug("-GA- dtoMovCC.getImporteMovimiento(2): "+dtoMovCC.getImporteMovimiento());
               UtilidadesLog.debug("-GA- dtoMovCC.getImportePendiente(2): "+dtoMovCC.getImportePendiente());
               UtilidadesLog.debug("-GA- importeASaldar(2): "+importeASaldar);
            }
            //-> Añadir dtoMovCC al arrayList "movCCSaldados"
            dtoMovCC.setTipoAbonoUltimo(dto.getOidTipoAbonoCreacionBanco());
            movCCSaldados.add(dtoMovCC);
            //(3)Si (importeASaldar == 0) entonces
            if(importeASaldar.doubleValue()== 0D){break;}
            // -> Salir del bucle
            //(3)Fin Si
        }
         //(1)Fin Para
        respuesta.setImporteASaldar(importeASaldar);
        respuesta.setMovCCSaldados(movCCSaldados);
		  UtilidadesLog.info("MONActualizarCCporAplicacionBean.cancelarCCSaldoNoUnico(DTORecuperacionTASPYMarcas dto): Salida");
        //-> Devolver "respuesta"
        return respuesta;
    }

	public void generarRegistrosCargosYAbonos(DTOGenerarRegistrosCargosYAbonos dto) throws MareException {
    
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.generarRegistrosCargosYAbonos(DTOGenerarRegistrosCargosYAbonos dto): Entrada");
        
	/* MONActualizarCCporAplicacion.generarRegistrosCargosYAbonos(dto : DTOGenerarRegistrosCargosYAbonos) : void */ 
		//Entrada: 
		//- dto : DTOGenerarRegistrosCargosYAbonos 
		/*
		DTOGenerarRegistrosCargosYAbonos: 
		- movCCSaldados : ArrayList 
		- movBancAplicados : ArrayList 
		- tipoAbonoTES : Long 
		- tipoAbonoCCC : Long 
		- oidSubprocesoCCC : Long 
		- cuentaContable : Long 
		- marcasSalida : Long[] 
		*/ 
      
        UtilidadesLog.info("DTOGenerarRegistrosCargosYAbonos de entrada: " + dto);
        Date auxDate = new Date(0);
            
		//Proceso: 
		//-> Crear variable llamada "longitudMovBanc" de tipo Long 
		//-> longitudMovBanc = longitud del ArrayList "dto.movBancAplicados" 
		Long longitudMovBanc= new Long(dto.getMovBancAplicados().size());
		//Crear variable llamada "longitudMovCC" de tipo Long 
		//-> longitudMovCC = longitud del ArrayList "dto.movCCSaldados" 
		Long longitudMovCC =new Long(dto.getMovCCSaldados().size());
		// Ordenamos los movBancAplicados y los movCCSaldados por empresa 
		//-> Crear variable llamada "indBanc" de tipo int inicializada a 0 
		int indBanc =0;
		//-> Crear variable llamada "indCC" de tipo int inicializada a 0 
		int indCC=0;
		//(1)Mientras (indBanc < longitudMovBanc.) hacer: 
		String usuario = ctx.getCallerPrincipal().getName();
		//DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos(usuario);
		Long empresa= null;
		
      DetalleCargosAbonosDirectosLocal detalleCargosAbonosDirectosLocal= null;
		DetalleCargosAbonosDirectosLocalHome detalleCargosAbonosDirectosLocalHome = this.getDetalleCargosAbonosDirectosLocalHome();;
      
		while (indBanc < longitudMovBanc.intValue()){
		
            //-> Crear variable llamada "empresa" de tipo Long y asignarle "dto.movBancAplicados[indBanc].empresa" 

            empresa= ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa();


            //-> Hacer "create" sobre la entidad "CabeceraCargosAbonosDirectos" con el siguiente mapeo: 
            CabeceraCargosAbonosDirectosLocalHome cabeceraCargosAbonosDirectosLocalHome = this.getCabeceraCargosAbonosDirectosLocalHome();
            CabeceraCargosAbonosDirectosLocal cabeceraCargosAbonosDirectosLocal= null;
		

            /* Modificado por incidencia BELC300010254
             Integer numero = daoCargosAbonos.obtieneSiguienteNumero(dto.getOidPais());
            */ 
            DTOBelcorp dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(dto.getOidPais());
            dtoBelcorp.setOidIdioma(dto.getOidIdioma());
            DAOCCC daoCCC = new DAOCCC();
            Integer numero = daoCCC.obtenerSecuenciaPais(dtoBelcorp);
            Date fechaDocumento=(new Date(System.currentTimeMillis()));
            String anio= null;
            String periodoMes= null;
            try{
            anio = UtilidadesFecha.convertirAString(fechaDocumento,"yy"); 
            }catch(ParseException e){
                throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            try{
            periodoMes = UtilidadesFecha.convertirAString(fechaDocumento,"MM"); 
            }catch(ParseException e){
                throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            
            Long pais = ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getOidPais();
            Date fechaValor =(new Date(System.currentTimeMillis()));
		
            // en el arrayList "MovBancAplicados" hay DTOMovimientoBancario, que solo tienen empresa y subacceso
            UtilidadesLog.info("###################################### Parametros de validaAcceso antes de create en CabeceraCargosAbonosDirectos");
            UtilidadesLog.info("Empresa: " + ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getEmpresa());
            UtilidadesLog.info("Subacceso: " + ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getSubacceso());
              
            /*  
             * Se comenta por inc 
             * Paola Cabrera 16/11/2005
             * this.validaAcceso(dto.getOidPais(),
                                    ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getEmpresa(),
                                    null, null, null,
                                    ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getSubacceso(),
                                    null, null, null, null, null);
                                    
                */                            
              Long proceso=daoCCC.obtieneProceso("TES002",pais);
              try{
                cabeceraCargosAbonosDirectosLocal= 
                cabeceraCargosAbonosDirectosLocalHome.create(numero,anio,periodoMes,fechaDocumento,pais,empresa,usuario,fechaValor, proceso);
              }catch (PersistenceException e) {
                  this.loguearError("generarRegistrosCargosYAbonos: CreateException:cabeceraCargosAbonosDirectos",
                      e);
                  ctx.setRollbackOnly();
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }							
              // Se añade al DTOMovimientoBancario el oid de subacceso, que le faltaba 
              //-> CabeceraCargosAbonosDirectos.oidSubacceso = dto.movBancAplicados[indBanc].oidSubacceso 
        
              cabeceraCargosAbonosDirectosLocal.setSubacceso(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getSubacceso());
                
              //SCS, segun inc.: BELC300022992 se setea el campo en cabecera con lo mismo que se setea en detalle; no se consulto a DT
              UtilidadesLog.info("seteo la cta. cte. bria. de cabecera con: " + ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getCuentaCorrienteBancaria());
              cabeceraCargosAbonosDirectosLocal.setCuentacorriente(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getCuentaCorrienteBancaria());
                
              // > Crear variable llamada "numeroLineaDetalle" de tipo int inicializada a 0 
              int numeroLineaDetalle=0;
        
              //(2)Mientras ((empresa = dto.movBancAplicados[indBanc].empresa)&& (indBanc < longitudMovBanc)) hacer: 
              //while ((empresa==((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa()) && (indBanc < longitudMovBanc.intValue())){
              if(empresa!=null){
                while ((indBanc < longitudMovBanc.intValue()) && (empresa.longValue()==((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa().longValue())) {
                    //-> Hacer create sobre la entidad "DetalleCargosAbonosDirectos" haciendo el siguiente mapeo: 
                    detalleCargosAbonosDirectosLocal= null;
              
                     // en el arrayList "MovBancAplicados" hay DTOMovimientoBancario, que solo tienen empresa y subacceso
                    UtilidadesLog.info("###################################### Parametros a validaAcceso antes de create sobre DetalleCargosAbonosDirectos con Movimientos Aplicados: ");
                    UtilidadesLog.info("Pais: " + dto.getOidPais());
                    UtilidadesLog.info("Empresa: " + ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getEmpresa());
                    UtilidadesLog.info("Subacceso: " + ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getSubacceso());
              
                    /*Se comenta por inc 
                    * Paola Cabrera 16/11/2005
                    * 
                    this.validaAcceso(dto.getOidPais(),((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getEmpresa(),
                                    null,
                                    null,
                                    null,
                                    ((DTOMovimientoBancario) dto.getMovBancAplicados().get(indBanc)).getSubacceso(),
                                    null,
                                    null, 
                                    null,
                                    null,
                                    null);       
                     */
                        try {
                            Integer numeroLineaInt = new Integer(++numeroLineaDetalle);            
                            UtilidadesLog.debug("-GA- Numero de linea del detalle de cargos y abonos(2): "+numeroLineaInt.toString());
                            UtilidadesLog.info(" cabeceraCargosAbonosDirectosLocal.getOid() :" + cabeceraCargosAbonosDirectosLocal.getOid());
                            UtilidadesLog.info(" new Integer(++numeroLineaDetalle) : " + new Integer(++numeroLineaDetalle));
                            UtilidadesLog.info(" usuario " + usuario);
                            UtilidadesLog.info(" empresa " + ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa());
                            UtilidadesLog.info(" dto.getTipoAbonoTES() " + dto.getTipoAbonoTES());
                
                            detalleCargosAbonosDirectosLocal= detalleCargosAbonosDirectosLocalHome.create(cabeceraCargosAbonosDirectosLocal.getOid(),
                                                                                                          numeroLineaInt,
                                                                                                          usuario,
                                                                                                          ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa(),
                                                                                                          dto.getTipoAbonoTES());// tipoabonasubpoceso)			
                        }catch (PersistenceException e) {
                            this.loguearError("generarRegistrosCargosYAbonos: CreateException:DetalleCargosAbonosDirectos",
                            e);
                            ctx.setRollbackOnly();
                            throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }	
            
                    detalleCargosAbonosDirectosLocal.setCuentaCorriente(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getCuentaCorrienteBancaria());

                    //scs, agregado por inc.: BELC300022992           
                    detalleCargosAbonosDirectosLocal.setMovimientoBancario(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getOid());
                    detalleCargosAbonosDirectosLocal.setConsultora(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getOidConsultoraReal());
                    detalleCargosAbonosDirectosLocal.setCuotaNueva(dto.getCuentaContable());
                    
                    auxDate.setTime(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getFechaPago().getTime());
                    detalleCargosAbonosDirectosLocal.setFechaPagoEnBancos(auxDate);
                    //
                    detalleCargosAbonosDirectosLocal.setImporteMoneda(new BigDecimal(0));
                    detalleCargosAbonosDirectosLocal.setEmpresa(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getEmpresa());
                   
    
                    if (((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getNumeroHistoria() != null) {
                        detalleCargosAbonosDirectosLocal.setNumeroHistoriaGenera(new Integer((((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getNumeroHistoria()).intValue()+1));			
                    } else {
                        detalleCargosAbonosDirectosLocal.setNumeroHistoriaGenera(new Integer(0));
                    }
                    detalleCargosAbonosDirectosLocal.setFechaMovimiento(new Date(System.currentTimeMillis()));
                    if (((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getImportePago() != null) {
                            detalleCargosAbonosDirectosLocal.setImporte(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getImportePago());
                    }
                    //Actualizamos el movimiento bancario aplicado 
                    //((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).setOidTipoAbonoUltimo(dto.getTipoAbonoTES());
                    //@ssaavedr, se modifica por inc.: BELC300022992
                    ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).setOidTipoAbonoUltimo(dto.getTipoCargoAbonoTES());
                    if (((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getNumeroHistoria() != null) {
                        ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).setNumeroHistoria(new Integer((((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).getNumeroHistoria().intValue())+1));
                    }
                    ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).setFechaMovimientoAplicacion(new Date(System.currentTimeMillis()));
                    ((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)).setUsuarioProceso(usuario);
                    //-> Llamar al método "MONCuentasCorrientes.actualizarMovimientoBancario() 
                    try{
                        UtilidadesLog.info(" Antes de actualizarMovBancario");
                            this.getMONCuentasCorrientes().actualizarMovBancario(((DTOMovimientoBancario)dto.getMovBancAplicados().get(indBanc)));
                    }catch (Exception e) {
                            this.logearError("*** Error en generarRegistrosCargosYAbonos: getMONCuentasCorrientes",e);
                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    } 
                    indBanc++; 
                }//(2)Fin Mientras 
                
                while ((indCC < longitudMovCC.intValue()) && (empresa.longValue() ==((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getEmpresa().longValue())) {
                        //(3)Mientras ((empresa = dto.movCCSaldados[indCC].empresa)&& (indCC < longitudMovCC)) hacer: 
                        //-> Hacer create sobre la entidad "DetalleCargosAbonosDirectos" haciendo el siguiente mapeo:
                        UtilidadesLog.debug("Entro en SALDOS");        
                        detalleCargosAbonosDirectosLocal = null;
                       
                       // en el arrayList "MovCCSaldados" hay DTOMovimientoCuentaCompleto, que tienen todos menos zona
                       UtilidadesLog.info("###################################### Parametros a validaAcceso antes de create sobre DetalleCargosAbonosDirectos con Movimientos Saldados: ");
                       UtilidadesLog.info("Pais: " + dto.getOidPais());
                       UtilidadesLog.info("Empresa: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getEmpresa());
                       UtilidadesLog.info("Marca: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getMarca());
                       UtilidadesLog.info("Canal: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidCanal());
                       UtilidadesLog.info("Acceso: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidAcceso());
                       UtilidadesLog.info("Subacceso: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getSubacceso());
                       UtilidadesLog.info("OidSugerenciaVenta: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidSugerenciaVenta());
                       UtilidadesLog.info("OidRegion: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidRegion());
                       UtilidadesLog.info("OidSeccion: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidSeccion());
                       UtilidadesLog.info("TerritorioAdministrativo: " + ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getTerritorioAdministrativo());
                       
                      /* Se comenta por inc 
                       * Paola Cabrera 16/11/2005
                       * 
                       * 
                       * this.validaAcceso(dto.getOidPais(),((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getEmpresa(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getMarca(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidCanal(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidAcceso(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getSubacceso(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidSugerenciaVenta(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidRegion(), 
                       null,
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getOidSeccion(),
                       ((DTOMovimientoCuentaCompleto) dto.getMovCCSaldados().get(indCC)).getTerritorioAdministrativo());
                        */
                    try{
                        Integer numeroLineaInt = new Integer(++numeroLineaDetalle);
                        UtilidadesLog.info("create sobre detalleCargosAbonosDirectosLocal : " + cabeceraCargosAbonosDirectosLocal.getOid());
                        detalleCargosAbonosDirectosLocal =detalleCargosAbonosDirectosLocalHome.create(cabeceraCargosAbonosDirectosLocal.getOid(),
                                                                                                      numeroLineaInt,
                                                                                                      usuario,
                                                                                                      (((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getEmpresa()),
                                                                                                      dto.getTipoAbonoCCC());
                    }catch (PersistenceException e) {
                        this.loguearError("generarRegistrosCargosYAbonos: CreateException:DetalleCargosAbonosDirectos",
                            e);
                        ctx.setRollbackOnly();
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }	
                    
                    if (((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getUltimoNumeroHistoria() != null) {
                        detalleCargosAbonosDirectosLocal.setNumeroHistoriaGenera(new Integer((((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getUltimoNumeroHistoria()).intValue()+1));			
                    } else {
                        detalleCargosAbonosDirectosLocal.setNumeroHistoriaGenera(new Integer(0));
                    }
                    detalleCargosAbonosDirectosLocal.setFechaMovimiento(new Date(System.currentTimeMillis()));
                    
                    //scs, agregado por inc.: BELC300022992
                    detalleCargosAbonosDirectosLocal.setMovimiento(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getOid());
                    detalleCargosAbonosDirectosLocal.setConsultora(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getOidCliente());
                    detalleCargosAbonosDirectosLocal.setMedioPago(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getMedioPago());
            		    if (((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getImportePagado() != null) {
                        detalleCargosAbonosDirectosLocal.setImporte(new BigDecimal(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getImportePagado().toString()));
                    }
                    //
                    detalleCargosAbonosDirectosLocal.setImporteMoneda(new BigDecimal(0));
                    
                    if (((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getCuentaCuota() != null) {
                        detalleCargosAbonosDirectosLocal.setCuotaAnterior(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getCuentaCuota());
                    }
                		detalleCargosAbonosDirectosLocal.setCuotaNueva(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getCuentaOrigen());

                    /*
                     * Actualizamos el movimiento en cuenta corriente saldado (parcial/totalmente) 
                     */
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setOidPais(dto.getOidPais());
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setUltimoDocumentoMesSerie(periodoMes);
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setUltimoDocumentoAnyo(anio);
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setUltimoDocumentoNumero(cabeceraCargosAbonosDirectosLocal.getNumero());
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setSubprocesoUltimo(dto.getOidSubprocesoCCC());

                    // Importe de pago = Importe –movimiento bancario-, si el Indicador actualiza cuota con importe pagado S/N = “S”
                    if (dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()) {
                        ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setImportePago(new BigDecimal(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getImportePagado().doubleValue()));
                    }
                    
                    //@ssaavedr, se modifica por inc.: BELC300022992
                    //((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setTipoAbonoUltimo(dto.getTipoAbonoCCC());
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setTipoAbonoUltimo(dto.getTipoCargoAbonoCCC());
                    
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getMovimientosBancariosCancelados();
                    //Se modifica la lógica a fin de responder a la 
                    //incidencia V-CCC-008. Lo que sigue esta en el DECU de CCC (Gacevedo)
                    if(dto.getIndicadorActualizaCuotaConImportePagado().booleanValue()){
                     //Si el atributo “Indicador actualiza cuota con importe pagado” = S, 
                     //se actualizará la marca de salida en el movimiento de cuenta corriente 
                     //sólo cuando Importe pagado=Importe y también se actualizará el atributo 
                     //Importe de Pago, si no se cumple esta condición, el movimiento de cuenta corriente 
                     //quedará con la marca de situación que tuviera rellena (pero sí se rellena el atributo Importe de Pago).
                     if(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getImportePendiente().doubleValue()==0){
                      ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setMarcaSituacion(dto.getMarcasSalida()[0]);   
                     }
                    }else{
                      //Si el atributo “Indicador actualiza cuota con importe pagado” = N, 
                      //se actualizará siempre la marca de salida en el movimiento de cuenta corriente
                      ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setMarcaSituacion(dto.getMarcasSalida()[0]);  
                    }
                    
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setFechaValor(fechaValor);

                    if (((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getUltimoNumeroHistoria() != null) {
                        ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setUltimoNumeroHistoria(new Integer(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getUltimoNumeroHistoria().intValue()+1));
                    }
		
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setCuentaCuota(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).getCuentaOrigen());
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setCuentaOrigen(dto.getCuentaContable());
                    ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)).setUsuario(usuario);

                    //-> Tomar el valor de "dto.movCCSaldados[indCC]" como parámetro para la siguiente llamada 
                    //-> Llamar al método "MONCuentasCorrientes.actualizarCuenta(movimientoCuenta : DTOMovimientoCuentaCompleto) : void" 
            		try{
                        UtilidadesLog.info("Antes de llamar a actualizarCuenta : " + ((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)));
                        this.getMONCuentasCorrientes().actualizarCuenta(((DTOMovimientoCuentaCompleto)dto.getMovCCSaldados().get(indCC)));
                    }catch (Exception e) {
                        this.logearError("*** Error en generarRegistrosCargosYAbonos: getMONCuentasCorrientes",e);
                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                    } 
                    indCC++;
                }//(3)Fin Mientras 
              } //if empresa!
        }//(1)Fin Mientras 

		//Nota: Los parámetros de entrada pasan por referencia */
		
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.generarRegistrosCargosYAbonos(DTOGenerarRegistrosCargosYAbonos dto): Salida");
	}

	private MONCuentasCorrientes getMONCuentasCorrientes() throws MareException {
        // Se obtiene el interfaz home
        
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONCuentasCorrientes(): Entrada");
        
        MONCuentasCorrientesHome home = (MONCuentasCorrientesHome)UtilidadesEJB.getHome(
            "MONCuentasCorrientes", MONCuentasCorrientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONCuentasCorrientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONCuentasCorrientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	} 

	   private void loguearError(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +
            e.getMessage());
        this.loguearStackTrace(e);
    }

    private void loguearStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: " + ex.getMessage());
        }
    }

	private DetalleCargosAbonosDirectosLocalHome getDetalleCargosAbonosDirectosLocalHome() 
	     throws MareException {
         
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getDetalleCargosAbonosDirectosLocalHome(): Entrada");
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getDetalleCargosAbonosDirectosLocalHome(): Salida");

        return new DetalleCargosAbonosDirectosLocalHome();
	}

  private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException {
        
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

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

        UtilidadesLog.info("MONActualizarCCporAplicacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }

    private MONValidacion getMONValidacion() throws MareException {
    
        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome(MON_VALIDACION,
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONValidacion", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONActualizarCCporAplicacionBean.getMONValidacion(): Salida");

        return ejb;
    }


}
