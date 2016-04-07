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
import es.indra.sicc.dtos.ccc.DTODias;
import es.indra.sicc.dtos.ccc.DTOMarcasSalida;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ccc.DTOEtapasDeCobranzas;


public class MONInterfaceModulosBean implements SessionBean, IMONCCC, IServiceCCC, ICalcularSaldosCCC {

    private static int CANT_DECIMALES = 2; 

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /**
     * @revision inicidencia V-CCC-032 se verifico que utilize las marcas de entradas, revision del DECU.
     * @autor gdmarzi
     */
    public DTOTotal calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto)
        throws MareException {
        UtilidadesLog.info("MONInterfaceModulosBean.calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto): Entrada"); 

        /**
         * Permite la consulta de saldo de un cliente
         */

        //Comprobamos que el contenido de los parámetros del dto sean validos
        if (dto.getOidCliente() == null) {
           /* throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosModulos.CCC, "",
                    ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));*/
            UtilidadesLog.info("MONInterfaceModulosBean.calcularSaldoCCCliente==>> el oid del cliente es nulo!!!!");        
	          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", 
                                    ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));
        }

        //Consulta de saldos
        String proceso = "CON001";
        Integer subproceso = new Integer(1);
        DAOCCC daoCCC = new DAOCCC();

        //cambiado por incidencia 12631:mchamorro
        //RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoSalida(proceso,
                //subproceso, dto.getOidPais());
        RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso,
                subproceso, dto.getOidPais());

        Long[] oidsMarcaSituacion = new Long[recordset.getRowCount()];

        for (int i = 0; i < recordset.getRowCount(); i++) {
            oidsMarcaSituacion[i] = new Long(((BigDecimal) recordset.getValueAt(
                        i, "OID_MARC_SITU")).longValue());
        }

        DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();

        
        DTOTotal dtoTotal = daoInterfaceModulos.calcularSaldoCCCliente(dto,
                oidsMarcaSituacion);

        UtilidadesLog.info("MONInterfaceModulosBean.calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto): Salida"); 

        return dtoTotal;
    }

    /**
     * @revision inicidencia V-CCC-032 se verifico que utilize las marcas de entradas, revision del DECU.
     * @autor gdmarzi
     */
    public DTOTotalyDias calcularDeudaVencidaCCCliente(
        DTOSaldosPorDiasPeriodos dto) throws MareException {
        UtilidadesLog.info("MONInterfaceModulosBean.calcularDeudaVencidaCCCliente(DTOSaldosPorDiasPeriodos dto): Entrada"); 

        /**
         * Permite la consulta del saldo total de deuda vencida de un cliente
         * y el número de días de la mas antigua.
         */

        //Comprobamos que el contenido de los parámetros del dto sean validos
        if (dto.getOidCliente() == null) {
            /*throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosModulos.CCC, "",
                    ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));*/
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));

					
        }

        //Consulta de saldos
        String proceso = "CON001";
        Integer subproceso = new Integer(1);
        DAOCCC daoCCC = new DAOCCC();

        //Cambiado por incidencia 12631:mchamorro
        //RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoSalida(proceso,subproceso, dto.getOidPais());
        RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso,subproceso, dto.getOidPais());

        Long[] oidsMarcaSituacion = new Long[recordset.getRowCount()];

        for (int i = 0; i < recordset.getRowCount(); i++) {
            oidsMarcaSituacion[i] = new Long(((BigDecimal) recordset.getValueAt(
                        i, "OID_MARC_SITU")).longValue());
        }

        DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();

        DTOTotalyDias dtoTotalyDias = daoInterfaceModulos.calcularDeudaVencidaCCCCliente(dto,
                oidsMarcaSituacion);

        UtilidadesLog.info("MONInterfaceModulosBean.calcularDeudaVencidaCCCliente(DTOSaldosPorDiasPeriodos dto): Salida");

        return dtoTotalyDias;
    }

    public DTOTotal calcularCuponTramiteCliente(DTOSaldosPorFechas dto)
        throws MareException {
        UtilidadesLog.info("MONInterfaceModulosBean.calcularCuponTramiteCliente(DTOSaldosPorFechas dto): Entrada");

        /**
         * Permite la consulta del saldo total de cupones en trámite de un cliente.
         */

        //Comprobamos que el contenido de los parámetros del dto sean validos
        if (dto.getOidCliente() == null) {
           /* throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosModulos.CCC, "",
                    ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));*/
		throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));

					
        }

        DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();

        DTOTotal dtoTotal = daoInterfaceModulos.calcularCuponTramiteCliente(dto);

        UtilidadesLog.info("MONInterfaceModulosBean.calcularCuponTramiteCliente(DTOSaldosPorFechas dto): Salida");

        return dtoTotal;
    }


  /**
   * @Modificadopor: Emilio Noziglia
   * @Fecha : 16/09/2005
   * @Recibe: DTOSaldosPorFechasyVtos dto
   * @Retorna: DTODias 
   * @Referencia: SICC-DMCO-CCC-201-344-N027-2
   * @Nota: se ajusto al modelo ya que habia un error en el calculo de numero de dias
   *        segun el DMCO se debe acumular y se estaba tomando el valor en cada iteracion
   *        del for sin acumular.[1]
   * @cambio se ajusta la presicion a decimales para los montos tratados. fallo de la DBLG70000200.
   * @autor gdmarzi
   * @revision inicidencia V-CCC-032 se verifico que utilize las marcas de entradas, revision del DECU.
   * @autor gdmarzi
   */ 
    public DTODias calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto) throws MareException {
        UtilidadesLog.info("MONInterfaceModulosBean.calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto): Entrada");
        /**
         * Permite la consulta de los días de retraso de pago de un cliente.
         */
        //Comprobamos que el contenido de los parámetros del dto sean validos
        if (dto.getOidCliente() == null) {
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "", ErroresDeNegocio.CONTENIDO_PARAMETROS_NO_ES_VALIDO));
        }

        //Consulta de saldos
        String proceso = "CON001";
        Integer subproceso = new Integer(1);
        DAOCCC daoCCC = new DAOCCC();

        RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso, subproceso, dto.getOidPais());

        Long[] oidsMarcaSituacion = new Long[recordset.getRowCount()];

        for (int i = 0; i < recordset.getRowCount(); i++) {
            oidsMarcaSituacion[i] = new Long(((BigDecimal) recordset.getValueAt(i, "OID_MARC_SITU")).longValue());
        }

        DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();

        RecordSet regs = daoInterfaceModulos.calcularDiasAtrasoCliente(dto, oidsMarcaSituacion);
        
        int longitud = regs.getRowCount();
        DTODias dtoDias = new DTODias();
        
        dtoDias.setNumeroDias(new Integer(0));//[1]
        
        if (longitud == 0) {
            dtoDias.setNumeroDias(new Integer(0));
        } else {
            // Inc. DBLG700000200 eiraola
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis()); // Fecha del sistema
            Timestamp fechaDocumento;
            BigDecimal importeMovimiento;
            BigDecimal importePagado;
            long cantDiasAtraso;
            BigDecimal montoAtraso;
            BigDecimal montoDeudaTotal = new BigDecimal(0);
            BigDecimal sumatoria = new BigDecimal(0);
            
            for (int i = 0; i < longitud; i++) {
                fechaDocumento = new Timestamp(((Date) regs.getValueAt(i, "FEC_DOCU")).getTime());
                importeMovimiento = (BigDecimal)regs.getValueAt(i,"IMP_MOVI");
                importePagado = (BigDecimal)regs.getValueAt(i,"IMP_PAGA");
                
                cantDiasAtraso = ((fechaActual.getTime() - fechaDocumento.getTime()) / 86400000);
                montoAtraso = importeMovimiento.subtract(importePagado);
                
                sumatoria = sumatoria.add((montoAtraso.multiply(new BigDecimal(cantDiasAtraso))));
                
                montoDeudaTotal = montoDeudaTotal.add(montoAtraso);
            }
            UtilidadesLog.debug(" ---- sumatoria_ " + sumatoria + " montoDeudaTotal_ " + montoDeudaTotal);
            
            if (montoDeudaTotal.doubleValue() > 0) {
                Integer cantDiasAtrasoPonderada = new Integer(sumatoria.divide(montoDeudaTotal,CANT_DECIMALES, BigDecimal.ROUND_FLOOR).intValue());
                dtoDias.setNumeroDias(cantDiasAtrasoPonderada);
                UtilidadesLog.debug(" ---- Dias de atraso: " + dtoDias.getNumeroDias());
            }
        }
        UtilidadesLog.info("MONInterfaceModulosBean.calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto): Salida");

        return dtoDias;
    }

    /**
    * @revision inicidencia V-CCC-032 se verifico que utilize las marcas de entradas, revision del DECU.
    * @autor gdmarzi
    */
	public DTOTotal consultarCuentasCastigadasCliente(DTOSaldosPorFechasyVtos dto) throws MareException {
		UtilidadesLog.info("MONInterfaceModulosBean.consultarCuentasCastigadasCliente(DTOSaldosPorFechasyVtos dto): Entrada");

		/*
		 * Permite la consulta de las cuentas castigadas de un cliente 
		 * entre unas determinadas fechas
		 */

		DTOTotal dtoTotal = null;
		DTOSalida dtoSalida = new DTOSalida();
		DTOMarcasSalida dtoMarcasSalida = null;
		String proceso = "CON002"; //Consulta de deuda provisionada 
		Integer subproceso = new Integer(1);
		DAOCCC daoCCC = new DAOCCC();
		DAOInterfaceModulos daoIM = new DAOInterfaceModulos();
 
		
        //Cambio por incidencia 12631:mchamorro
        //RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoSalida(proceso,subproceso,dto.getOidPais());
        RecordSet recordset = daoCCC.obtenerMarcasTipoAbonoEntrada(proceso,subproceso,dto.getOidPais());
		
        dtoSalida.setResultado(recordset); 
		int numfilas = dtoSalida.getResultado().getRowCount();
		Long[] marcasSalida = new Long[numfilas];
		for(int i=0; i < numfilas; i++){
			marcasSalida[i] = new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(
                        i, "OID_MARC_SITU")).longValue());
		}

		dtoMarcasSalida = new DTOMarcasSalida();
		dtoMarcasSalida.setFechaDocDesde(dto.getFechaDocDesde());
		dtoMarcasSalida.setFechaDocHasta(dto.getFechaDocHasta());
		dtoMarcasSalida.setFechaVtoDesde(dto.getFechaVtoDesde());
		dtoMarcasSalida.setFechaVtoHasta(dto.getFechaVtoHasta());
		dtoMarcasSalida.setOidCliente(dto.getOidCliente());
		dtoMarcasSalida.setOidIdioma(dto.getOidIdioma());
		dtoMarcasSalida.setOidPais(dto.getOidPais());
		dtoMarcasSalida.setOidsMarcasSalida(marcasSalida);

		dtoTotal = daoIM.consultarCuentasCastigadasCliente(dtoMarcasSalida);
			 
		UtilidadesLog.info("MONInterfaceModulosBean.consultarCuentasCastigadasCliente(DTOSaldosPorFechasyVtos dto): Salida");
		return dtoTotal;
	}

  /**
   * @Author: ssantana, 15/2/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida   
   */
  public DTOSalida consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto) throws MareException
  {
    UtilidadesLog.info("MONInterfaceModulosBean.consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto): Entrada");
    DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();
    DTOSalida dtoSalida = daoInterfaceModulos.consultarClientesDeudaVencidaUA(dto);
    UtilidadesLog.info("MONInterfaceModulosBean.consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto): Salida");
    return dtoSalida;
  }

  public Integer obtenerNroVecesProntoPago(Long oidCliente, Long oidPais) throws MareException
  {
    UtilidadesLog.info("MONInterfaceModulosBean.obtenerNroVecesProntoPago(Long oidCliente, Long oidPais): Entrada");
    DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();
    Integer salida = daoInterfaceModulos.obtenerNroVecesProntoPago(oidCliente, oidPais);
    UtilidadesLog.info("MONInterfaceModulosBean.obtenerNroVecesProntoPago(Long oidCliente, Long oidPais): Salida");
    return salida;
  }

  public Integer obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais) throws MareException
  {
    UtilidadesLog.info("MONInterfaceModulosBean.obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais): Entrada");
    DAOInterfaceModulos daoInterfaceModulos = new DAOInterfaceModulos();
    Integer salida = daoInterfaceModulos.obtenerNroVecesRecargoFinanciero(oidCliente, oidPais);
    UtilidadesLog.info("MONInterfaceModulosBean.obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais): Salida");
    return salida;
  }



    //--Paola Cabrera
    //-- 10/11/2005
    //--Agregado por inc 21163
    //--
    public String calcularSaldosCuentaCorriente(Long pais, Long codCliente) throws MareException
    {
    
        UtilidadesLog.info("MONInterfaceModulosBean.calcularSaldosCuentaCorriente(Long pais, Long codCliente): Entrada");
        DTOSaldosPorFechasyVtos dto = new DTOSaldosPorFechasyVtos();        
        
        //--Se setea el dto antes creado, con los parametros recibidos
        //-- El resto se inicializa en NULL
        dto.setOidPais(pais);
        dto.setOidCliente(codCliente);
        dto.setFechaDocDesde(null);
        dto.setFechaDocHasta(null);
        dto.setFechaVtoDesde(null);
        dto.setFechaVtoHasta(null);
        
        DTOTotal dtoTotal = this.calcularSaldoCCCliente(dto);
       
        UtilidadesLog.info("dto total "+dtoTotal.getTotalString());
        UtilidadesLog.info("MONInterfaceModulosBean.calcularSaldosCuentaCorriente(Long pais, Long codCliente): Salida");   
        
        return dtoTotal.getTotalString();  
     
                
    }
  
}
