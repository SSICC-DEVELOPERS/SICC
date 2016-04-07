/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.bel.DTOStock;
import es.indra.sicc.dtos.bel.DTOGrabarStock;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.bel.MovimientosAlmacenCabeceraLocal;
import es.indra.sicc.entidades.bel.MovimientosAlmacenCabeceraLocalHome;
import es.indra.sicc.entidades.bel.MovimientosAlmacenDetalleLocal;
import es.indra.sicc.entidades.bel.MovimientosAlmacenDetalleLocalHome;
import es.indra.sicc.entidades.bel.OperacionesLocal;
import es.indra.sicc.entidades.bel.OperacionesLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocal;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocalHome;
import es.indra.sicc.logicanegocio.bel.DAOTiposMovimientosAlmacen;
import es.indra.sicc.logicanegocio.bel.MONMantenimientoTiposMovimientosAlmacen;
import es.indra.sicc.logicanegocio.bel.MONMantenimientoTiposMovimientosAlmacenHome;
import es.indra.sicc.logicanegocio.fac.ProcesoFacturacionHelper;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import java.rmi.RemoteException;


import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.ArrayList;
import es.indra.sicc.util.BelcorpService;

import es.indra.sicc.util.UtilidadesBD;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONGenerarMovimientoAlmacenBean implements SessionBean, IGenerarMovimientoAlmacen {
    private final static String MON_MANTENIMIENTO_TIPOS_MOVIMIENTOS_ALMACEN = "MONMantenimientoTiposMovimientosAlmacen";
    private final static String MON_VALIDACION = "MONValidacion";
    private final static String MON_PROCESO_PED = "MONProcesosPED";
    private SessionContext ctx;
    private DTOReportePedidos reportePedidos;
    private DTOMovimientoAlmacen datosMovimientoAlmacen;
    private DTOTipoMovimientoAlmacen tipoMovimientoAlmacen;

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
    * M�todo para grabar los movimientos de stock
    * @param dto DTOMovimientoAlmacen
    * @return DTOReportePedidos
    * @exception MareException
    */
    public DTOReportePedidos grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dto) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dto):Entrada");
        //UtilidadesLog.debug("****grabarMovimientoAlmacenYStock detalles: " + dto.getDetalle());
        if (dto.getDetalle() != null){
            UtilidadesLog.debug("****Metodo  guardarIngresoFisicoHD: detalles: " + dto.getDetalle().size());		                              
        }
    		reportePedidos=new DTOReportePedidos();
    		reportePedidos.setLineasDetalle(new ArrayList());
        if (dto.getDetalle().size()<1){
            return this.reportePedidos;
        }
        // Validar accesos

        /*public Boolean validarAccesos(Long pais,
                Long sociedad,
                Long marca,
                Long canal,
                Long acceso,
                Long subAcceso,
                Long subgerencia,
                Long region,
                Long zona,
                Long seccion,
                Long territorio) */
    
        /*QUITADO POR INCIDENCIA 9666
		 * MONValidacion monValidacion = this.getMONValidacion();

        try {
            if (!(monValidacion.validarAccesos(dto.getOidPais(), null, null,
                        null, null, dto.getCabecera().getOidSubacceso(), null,
                        null, null, null, null)).booleanValue()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }
        } catch (RemoteException re) {
            this.loguearError("grabarMovimientoAlmacenYStock: RemoteException, validarAccesos",
                re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException e) {
            throw e;
        }*/
        try{
            this.datosMovimientoAlmacen = dto;
            this.procesarMovimientoAlmacen();
        }catch(Exception e){
            ctx.setRollbackOnly();
            this.loguearError("GENERAL",e);
            if (e instanceof MareException)
                throw (MareException)e;
            throw new MareException(e);
        }

        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dto):Salida");
        return this.reportePedidos;
    }

    private void procesarMovimientoAlmacen() throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.procesarMovimientoAlmacen():Entrada");
        Cronometrador.startTransaction("Grabar Detalle");
        this.grabarMovimientoCabecera();

        if (this.datosMovimientoAlmacen.getDetalle() != null) {
            this.grabarMovimientoDetalle();   
        }
        /* Modificacion por Performance alorenzo 16/08/2006 */
        /*
        if (this.datosMovimientoAlmacen.getDetalle() != null) {
            int longitud = this.datosMovimientoAlmacen.getDetalle().size();

            for (int i = 0; i < longitud; i++) {
                this.grabarMovimientoDetalle(i);
            }
        }
        */
        Cronometrador.endTransaction("Grabar Detalle");
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.procesarMovimientoAlmacen():Salida");
    }

    private void copiarValoresCabeceraADetalle(int posicion)
        throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.copiarValoresCabeceraADetalle(int posicion):Entrada");
        DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle()
                                                                                                                           .get(posicion);

        //BELC300006111
        if (datosMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen() != null) {
            dtoMovimientoAlmacenDetalle.setOidTipoMovimientoAlmacen(datosMovimientoAlmacen.getCabecera()
                                                                                          .getOidTipoMovimientoAlmacen());
        }

        if (datosMovimientoAlmacen.getCabecera().getOidAlmacenSalida() != null) {
            dtoMovimientoAlmacenDetalle.setOidAlmacenSalida(datosMovimientoAlmacen.getCabecera()
                                                                                  .getOidAlmacenSalida());
        }

        if (datosMovimientoAlmacen.getCabecera().getOidAlmacenEntrada() != null) {
            dtoMovimientoAlmacenDetalle.setOidAlmacenEntrada(datosMovimientoAlmacen.getCabecera()
                                                                                   .getOidAlmacenEntrada());
        }

        //this.datosMovimientoAlmacen.getDetalle().set(posicion,dtoMovimientoAlmacenDetalle);Ya se cambia
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.copiarValoresCabeceraADetalle(int posicion):Salida");
    }

    private void recuperarOperaciones(Long tipoMovimientoAlmacen)
        throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.recuperarOperaciones(Long tipoMovimientoAlmacen):Entrada");
        /*
         * 1. Tomar par�metro de entrada y crear un objeto DTOOID.
         */
        
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(tipoMovimientoAlmacen);
        
        if (this.datosMovimientoAlmacen.getOidIdioma()!=null)        
           dtoOid.setOidIdioma(this.datosMovimientoAlmacen.getOidIdioma());    
        else if(this.datosMovimientoAlmacen.getCabecera().getOidIdioma()!=null)
           dtoOid.setOidIdioma(this.datosMovimientoAlmacen.getCabecera().getOidIdioma());


        if (this.datosMovimientoAlmacen.getOidPais()!=null) 
           dtoOid.setOidPais(this.datosMovimientoAlmacen.getOidPais());
        else if(this.datosMovimientoAlmacen.getCabecera().getOidPais()!=null)
           dtoOid.setOidPais(this.datosMovimientoAlmacen.getCabecera().getOidPais()); 
        
        UtilidadesLog.debug("dtoOid: " + dtoOid);

        /*
         * 2. Llamar al m�todo "MONMantenimientoTipoMovimientosAlmacen.consultarTipoMovimientoAlmacen(dto : DTOOID) : DTOTipoMovimientoAlmacen"
         * pasando el objeto DTOOID creado en el paso anterior
         */
        MONMantenimientoTiposMovimientosAlmacen mon = this.getMONMantenimientoTiposMovimientosAlmacen();
        DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen = null;

        //sapaza -- cambio RoadMap Internacionalizacion Toplink -- 19/05/2010                
        dtoTipoMovimientoAlmacen = this.consultarTipoMovimientoAlmacen(dtoOid);
        UtilidadesLog.debug("dtoTipoMovimientoAlmacen: " + dtoTipoMovimientoAlmacen);

        /*
         * 3. Asignar objeto DTOTipoMovimientoAlmacen recuperado de la llamada
         * al atributo tipoMovimientoAlmacen de esta clase, machacando el dato
         * que hubiese si lo hubiese.
         */
        this.tipoMovimientoAlmacen = dtoTipoMovimientoAlmacen;
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.recuperarOperaciones(Long tipoMovimientoAlmacen):Salida");
    }

    private void grabarMovimientoCabecera() throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoCabecera():Entrada");
	if (this.datosMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen()!=null) {
            this.recuperarOperaciones(this.datosMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen());
        } else {
            ArrayList array=this.datosMovimientoAlmacen.getDetalle();
            DTOMovimientoAlmacenDetalle dto=(DTOMovimientoAlmacenDetalle)array.get(0);
            this.recuperarOperaciones(dto.getOidTipoMovimientoAlmacen());
	}
        
        if (this.tipoMovimientoAlmacen.getMantieneMovimientos().booleanValue() == true) {
            if (this.datosMovimientoAlmacen.getCabecera().getIndicadorNoGenerarCabecera() == null
                || this.datosMovimientoAlmacen.getCabecera().getIndicadorNoGenerarCabecera().booleanValue() == false) {
                StringBuffer query = new StringBuffer();
                
                query.append("SELECT ("); 
                query.append(" SELECT COD_PAIS"); 
                query.append(" FROM SEG_PAIS"); 
                query.append(" WHERE OID_PAIS = ").append(datosMovimientoAlmacen.getCabecera().getOidPais());
                query.append(" ) COD_PAIS,"); 
                query.append(" ("); 
                query.append(" SELECT COD_SBAC"); 
                query.append(" FROM SEG_SUBAC"); 
                query.append(" WHERE OID_SBAC = ").append(datosMovimientoAlmacen.getCabecera().getOidSubacceso());
                query.append(" ) COD_SBAC"); 
                query.append(" FROM DUAL");
                
                RecordSet rs = null;
                
                rs = UtilidadesBD.executeQuery(query.toString());
                ArrayList arrayParametros = new ArrayList();
                
                if (rs != null && !rs.esVacio()){
                    arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));    
                    arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SBAC")));    
                }
                
                arrayParametros.add("BEL001");
                SimpleDateFormat sdf = new SimpleDateFormat("yy");
                Date currentYear = new Date( System.currentTimeMillis());
                String yy = sdf.format(currentYear);   
                arrayParametros.add(new Integer(yy)); 
                
                String numeroSolicitud = null;
                
                try {
                    numeroSolicitud = this.getMONGenerarMovimientoAlmacenLocal().ejecutarFuncionGeneraNumeros(arrayParametros);
                } catch (NamingException ne) {
                    UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
                    throw new MareException(ne);
                }
                
                StringBuffer numeroFormateado = new StringBuffer();
                numeroFormateado.append(cerosIzq(yy.toString(), 2));
                numeroFormateado.append(cerosIzq(numeroSolicitud, 8));         
                this.datosMovimientoAlmacen.getCabecera().setNumeroMovimiento(numeroFormateado.toString());

                query = new StringBuffer();
                 
                query.append("SELECT BEL_MVAL_SEQ.NEXTVAL FROM DUAL");
                 
                rs = null;
                 
                rs = this.executeQuery(query.toString());
                Long oidCabecera = null;
                if (rs != null && !(rs.esVacio())){
                    oidCabecera = this.bigDecimalToLong(rs.getValueAt(0,0));
                    StringBuffer queryIns = new StringBuffer();
                    String observaciones = "";
                    if (this.datosMovimientoAlmacen.getCabecera().getObservaciones() != null) {
                      observaciones = this.datosMovimientoAlmacen.getCabecera().getObservaciones();
                    }
                    Date fecha = this.datosMovimientoAlmacen.getCabecera().getFecha();
                    sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    queryIns.append("INSERT INTO BEL_MOVIM_ALMAC_CABEC (OID_MOVI_ALMA,PAIS_OID_PAIS,NUM_DOCU,SBAC_OID_SBAC,FEC_MOVI,VAL_OBSE,ALMC_OID_ALMA_1,");
                    queryIns.append("ALMC_OID_ALMA_2,TMAL_OID_TIPO_MOVI_ALMA,PERD_OID_PERI,N_MOVIMIENTO) VALUES (");
                    queryIns.append(oidCabecera + "," + this.datosMovimientoAlmacen.getCabecera().getOidPais() + "," + this.datosMovimientoAlmacen.getCabecera().getNumeroDocumento());
                    queryIns.append("," + this.datosMovimientoAlmacen.getCabecera().getOidSubacceso() + ",TO_DATE('" + sdf.format(fecha) + "','yyyy-MM-dd HH24:MI:SS')");
                    queryIns.append(",'" + observaciones.toString() + "'," + this.datosMovimientoAlmacen.getCabecera().getOidAlmacenEntrada());
                    queryIns.append("," + this.datosMovimientoAlmacen.getCabecera().getOidAlmacenSalida() + "," + this.datosMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen());
                    queryIns.append("," + this.datosMovimientoAlmacen.getCabecera().getOidPeriodo() + "," + new Long(this.datosMovimientoAlmacen.getCabecera().getNumeroMovimiento()));
                    queryIns.append(");");
                    
                     try {
                      BelcorpService belcorpService = BelcorpService.getInstance();
                      belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", queryIns.toString());
                    } catch ( Exception ex ) {
                      ctx.setRollbackOnly();
                      throw new MareException( ex, 
                          UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
                    } 
                    this.datosMovimientoAlmacen.getCabecera().setOid(oidCabecera);
                 } else {
                    UtilidadesLog.error("Error al Generar el Oid de Cabecera de Movimiento de Almacen");
                    ctx.setRollbackOnly();
                 }
            }
        }

        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoCabecera():Salida");
    }


    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Entrada ");
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Salida ");
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }
    
    /*
     * Incidencia (7487)
     * */
    /**
    * Sistema:     Belcorp
    * Modulo:      BEL
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
    private void grabarMovimientoDetalle(int posicion)
        throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoDetalle(int posicion):Entrada");

        DTOMovimientoAlmacenDetalle dtoMAD = null;

        /*
         * Nuevo proceso por incidencia BELC300007328. Modificado por BELC300007487
         * */
        /*
         * -> Llamar al m�todo privado "copiarValoresCabeceraADetalle(posicion : int) : void" pasando el
         * par�metro de entrada
         * */
        this.copiarValoresCabeceraADetalle(posicion);

        /*
         * -> Llamar al m�todo privado "recuperarOperaciones(tipoMovimientoAlmacen : Long) : void"
         * pasando como par�metro el valor del atributo
         * "datosMovimientoAlmacen.detalle[posicion].oidTipoMovimientoAlmacen"
         * */
        dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle()
                                                                          .get(posicion);
        //UtilidadesLog.debug("dtoMAD: " + dtoMAD);
        /* 
         * cambio jpbosnja
         * Se comento porque ya se ejecuta cuando se crea la cabecera
         * */
        //this.recuperarOperaciones(dtoMAD.getOidTipoMovimientoAlmacen());
        
        UtilidadesLog.debug("****tipoMovimientoAlmacen: "+ this.tipoMovimientoAlmacen);
        
        /*
         * -> Llamar al m�todo privado "grabarStock(posicion : int, almacen : Long, estado : Long, producto :
         *        Long, operacion : String) : void" pasando los siguientes datos
         *   - posicion
         *   - datosMovimientoAlmacen.detalle[posicion].oidAlmacenSalida
         *   - tipoMovimientoAlmacen.oidEstadoMercancia1
         *   - datosMovimientoAlmacen.detalle[posicion].oidProducto
         *   - tipoMovimientoAlmacen.operacion1
         * */
            this.grabarStock(posicion, dtoMAD.getOidAlmacenSalida(),
            this.tipoMovimientoAlmacen.getOidEstadoMercancia1(),
            dtoMAD.getOidProducto(),
            this.tipoMovimientoAlmacen.getOperacion1().toString());

        /*
         * Si (tipoMovimientoAlmacen.movimientoEntreAlmacenes = "True") entonces
         * -> Llamar al m�todo privado "grabarStock(posicion : int, almacen : Long, estado : Long, producto :
         * Long, operacion : String) : void" pasando los siguientes datos
         *          - posicion
         *          Si datosMovimientoAlmacen.detalle[posicion].oidAlmacenEntrada == null {
         *              - datosMovimientoAlmacen.detalle[posicion].oidAlmacenSalida
         *          } sino {
         *               - datosMovimientoAlmacen.detalle[posicion].oidAlmacenEntrada
         *          }
         *          - datosMovimientoAlmacen.detalle[posicion].oidAlmacenEntrada
         *          - tipoMovimientoAlmacen.oidEstadoMercancia2
         *          - datosMovimientoAlmacen.detalle[posicion].oidProducto
         *          - tipoMovimientoAlmacen.operacion2
         * Fin Si
         * */
         
         //cambio por incidencia 19044: No se comprueba por MovimientoEntreAlmacenes
         //sino, por tipoMovimientoAlmacen.operacion2!=null
        //if (this.tipoMovimientoAlmacen.getMovimientoEntreAlmacenes().booleanValue() == true) {
        if (this.tipoMovimientoAlmacen.getOperacion2()!=null){
            UtilidadesLog.debug("La operaci�n 2 es: " + this.tipoMovimientoAlmacen.getOperacion2());
            Long oidAlmacen = dtoMAD.getOidAlmacenEntrada();
            if (oidAlmacen == null) oidAlmacen = dtoMAD.getOidAlmacenSalida();
            this.grabarStock(posicion, oidAlmacen, this.tipoMovimientoAlmacen.getOidEstadoMercancia2(),
                dtoMAD.getOidProducto(), "" + this.tipoMovimientoAlmacen.getOperacion2());
        }

        /*
        * -> Comprobar el valor del atributo tipoMovimientoAlmacen.mantieneMovimientos
        * Si el valor comprobado en el paso anterior es igual a "True" entonces
        * -> Comprobar el valor del atributo "datosMovimientoAlmacen.cabecera.numeroMovimiento"
        * Si el valor comprobado en el punto anterior es distinto de NULL entonces
        * -> Asignar el valor al atributo "datosMovimientoAlmacen.detalle[posicion].numeroMovimiento"
        * Fin Si
        * */
        if (this.tipoMovimientoAlmacen.getMantieneMovimientos().booleanValue() == true) {
            String numeroDocumento = null;

            if (this.datosMovimientoAlmacen.getCabecera().getNumeroMovimiento() != null) {
                //numeroDocumento = this.datosMovimientoAlmacen.getCabecera().getNumeroMovimiento();
                dtoMAD.setNumeroMovimiento(this.datosMovimientoAlmacen.getCabecera()
                                                                      .getNumeroMovimiento());
            }

            //fin if
            /*
             * -> Tomar los valores del atributo "datosMovimientoAlmacen.detalle[posicion]"
             * de tipo DTOMovimientoAlmacenDetalle:
             * */
            dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle()
                                                                              .get(posicion);

            MovimientosAlmacenDetalleLocalHome homeMAD = this.getMovimientosAlmacenDetalleLocalHome();
            MovimientosAlmacenDetalleLocal localMAD = null;

            OperacionesLocalHome homeOperaciones = this.getOperacionesLocalHome();
            OperacionesLocal localOperaciones = null;

            try {
                localOperaciones = homeOperaciones.findByUK(dtoMAD.getOperacion());
            } catch (NoResultException fe) {
                ctx.setRollbackOnly();
                this.loguearError("grabarMovimientoDetalle: CreateException: FinderException", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            /*
             * -> Hacer un create sobre la entidad MovimientoAlmacenDetalle con los datos tomados con el
             * siguiente mapeo:
             * atributo de MovimientoAlmacenDetalle <= correspondencia
             * -----------------------------------------------------------------------------------------------------
             * oid <= es autonum�rico
             * oidMovimientoAlmacenCabecera <= datosMovimientoAlmacen.cabecera.oid
             * numeroLinea <= par�metro de entrada "pos" + 1
             * cantidad <= datosMovimientoAlmacen.detalle(pos).cantidad
             * precioVentaNeto <= datosMovimientoAlmacen.detalle(pos).precioVentaNeto
             * precioContable <= datosMovimientoAlmacen.detalle(pos).precioContable
             * numeroDocumentoReferencia <=datosMovimientoAlmacen.detalle(pos).numeroDocumentoReferencia
             * numeroPosicionReferencia <=datosMovimientoAlmacen.detalle(pos).numeroPosicionReferencia
             * oidAlmacenEntrada <= datosMovimientoAlmacen.detalle(pos).oidAlmacenEntrada
             * oidAlmacenSalida <= datosMovimientoAlmacen.detalle(pos).oidAlmacenSalida
             * oidProducto <= datosMovimientoAlmacen.detalle(pos).oidProducto
             * oidTipoMovimientoAlmacen <=datosMovimientoAlmacen.detalle(pos).oidTipoMovimientoAlmacen
             * oidOperaciones <= Hacer findByUK sobre la entidad Operaciones con el campo
             * datosMovimientoAlmacen.detalle(pos).operaci�n y obtener el oid
             * nMovimiento <= datosMovimientoAlmacen.detalle(pos).numeroMovimiento
             * oidTipoOferta <= datosMovimientoAlmacen.detalle[posicion].oidTipoOferta 
             */
            try {
                /*UtilidadesLog.debug("****posicion: "+ posicion);
                UtilidadesLog.debug("****canntidad: "+ dtoMAD.getCantidad());
                UtilidadesLog.debug("****tipoMovimientoAlmacen: "+ dtoMAD.getOidTipoMovimientoAlmacen());
                UtilidadesLog.debug("****producto: "+ dtoMAD.getOidProducto());
                UtilidadesLog.debug("****operacion: "+ localOperaciones.getOid());
                UtilidadesLog.debug("****almacenSalida: "+ dtoMAD.getOidAlmacenSalida());                
                UtilidadesLog.debug("****precioVentaNeto: "+ dtoMAD.getPrecioVentaNeto());
                UtilidadesLog.debug("****precioContable: "+ dtoMAD.getPrecioContable());
                UtilidadesLog.debug("****numeroDocumentoReferencia: "+ dtoMAD.getNumeroDocumentoReferencia());
                UtilidadesLog.debug("****numeroPosicionReferencia: "+ dtoMAD.getNumeroPosicionReferencia());
                UtilidadesLog.debug("****almacenEntrada: "+ dtoMAD.getOidAlmacenEntrada());                
                UtilidadesLog.debug("****numeroMovimiento: "+ dtoMAD.getNumeroMovimiento());
                UtilidadesLog.debug("****tipoOferta: "+ dtoMAD.getOidTipoOferta()); */ 

                if (dtoMAD.getCantidad() == null) dtoMAD.setCantidad(new Long(0)); 
                
                localMAD = homeMAD.create(this.datosMovimientoAlmacen.getCabecera()
                                                                     .getOid(), //Long movimientoAlmacenCabecera, 
                        new Integer(posicion + 1), // Integer numeroLinea, 
                        dtoMAD.getCantidad(), // Long cantidad, 
                        dtoMAD.getOidTipoMovimientoAlmacen(), // Long tipoMovimientoAlmacen, 
                        dtoMAD.getOidProducto(), // Long producto, 
                        localOperaciones.getOid(), // Long operacionReferencia, 
                        dtoMAD.getOidAlmacenSalida(), // Long almacenSalida, 
                        dtoMAD.getPrecioVentaNeto(), // BigDecimal precioVentaNeto, 
                        dtoMAD.getPrecioContable(), // BigDecimal precioContable,
                        dtoMAD.getNumeroDocumentoReferencia(), // Long numeroDocumentoReferencia,
                        dtoMAD.getNumeroPosicionReferencia(), // Integer numeroPosicionReferencia,
                        dtoMAD.getOidAlmacenEntrada(), // Long almacenEntrada
                        new Long(dtoMAD.getNumeroMovimiento()), //Long numeroMovimiento
                        dtoMAD.getOidTipoOferta()//Long oidTipoOferta incidencia 8595
                        );
                    
                //Agregado por Cristian Valenzuela - 3/10/2005
                //CAMBIOS - SAM01
                localMAD.setTipoPosicion(dtoMAD.getOidTipoPosicion());
                localMAD.setSubtipoPosicion(dtoMAD.getOidSubtipoPosicion());
                //FIN - Agregado por Cristian Valenzuela - 3/10/2005
                    
            } catch (PersistenceException ce) {
                ctx.setRollbackOnly();
                this.loguearError("grabarMovimientoDetalle: CreateException: MovimientosAlmacenDetalle", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            /*
                 * -> Asignar al atributo "datosMovimientoAlmacen.detalle[posicion].oid" el oid del registro creado
                 * */
            dtoMAD.setOid(localMAD.getOid());
        }

        //fin if
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoDetalle(int posicion):Salida");
    }

    private void grabarStock(int posicion, Long almacen, Long estado,
        Long producto, String operacion) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(int posicion, Long almacen, Long estado, Long producto, String operacion):Entrada");
        UtilidadesLog.debug("****posicion: "+ posicion);
        UtilidadesLog.debug("****almacen: "+ almacen);
        UtilidadesLog.debug("****estado: "+ estado);
        UtilidadesLog.debug("****producto: "+ producto);
        UtilidadesLog.debug("****operacion: "+ operacion);
        /*
         * // Localizaci�n del registro de Stock
         * -> Hacer un findByClaveUnica sobre la entidad Stock pasando los siguientes valores
         * - almacen
         * - estado
         * - producto
         * Si no se encuentra el registro entonces
         * -> Hacer create sobre entidad Stock con los datos anteriores y saldo = 0
         * Fin Si
         */
        StockLocalHome home = this.getStockLocalHome();
        StockLocal localStock;

        try {
            UtilidadesLog.debug("SCS , busco en bel-stock: " + almacen + "-" + estado + "-" + producto);
            localStock = home.findByClaveUnica(almacen, estado, producto);
        } catch (NoResultException fe) {
            UtilidadesLog.debug("grabarStock: No encuentra stock: ", fe);

            try {
                localStock = home.create(almacen, //create(Long almacen, 
                        estado, //Long estadoMercancia, 
                        producto, //Long producto, 
                        new Long(0)); //Long saldo));
                
                UtilidadesLog.debug("la local que cree: " + localStock.getAlmacen() + " - " + 
                                                           localStock.getEstadoMercancia() + " - " + 
                                                           localStock.getProducto() + " - " +
                                                           localStock.getSaldo());
                        
            } catch (PersistenceException ce) {
                this.ctx.setRollbackOnly();
                this.loguearError("grabarStock: CreateException: Strock", ce);
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        /*
         * Llamamos al entity encontrado o creado: Stock
         * // Operaciones
         * Si (operacion = '+') entonces
         * -> Stock.saldo = Stock.saldo + datosMovimientoAlmacen.detalle[posicion].cantidad
         */
        UtilidadesLog.debug("SCS, voy a ver el tema de: tMovimientoOk!!"); 
        DTOMovimientoAlmacenDetalle dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle().get(posicion);        

        UtilidadesLog.debug("dtoMAD SS: " + dtoMAD);
        if ("+".equals(operacion)) {
            UtilidadesLog.debug("operacion: +"); 
            long cantidad = 0;
            if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
            localStock.setSaldo(new Long(localStock.getSaldo().longValue() + cantidad));
        } else if ("-".equals(operacion)) {
            /*
             * Si no Si (operacion = '-') entonces
             * Si (datosMovimientoAlmacen.detalle[posicion].operacion = 'PED%') entonces
             * // 'PED%' significa que empieza por PED
             * Si (Stock.saldo >= datosMovimientoAlmacen.detalle[posicion].cantidad) entonces
             * -> Stock.saldo = Stock.saldo - datosMovimientoAlmacen.detalle[posicion].cantidad
             * -> datosMovimientoAlmacen.detalle[posicion].movimientoOk = "True"
             */
            if (dtoMAD.getOperacion().indexOf("PED") == 0) {
                long cantidad = 0;
                if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
                //UtilidadesLog.debug("SCS, localStock.getSaldo() y cantidad, son: " + localStock.getSaldo().longValue() + " - " + cantidad);
                if ((localStock.getSaldo().longValue() > 0) && (localStock.getSaldo().longValue() >= cantidad)) {                 
                    localStock.setSaldo(new Long(localStock.getSaldo().longValue() - cantidad));
                    dtoMAD.setMovimientoOk(Boolean.TRUE);
                } else {
                    /*
                     * Si no entonces
                     * -> datosMovimientoAlmacen.detalle[posicion].cantidad = datosMovimientoAlmacen.detalle[posicion].cantidad - Stock.saldo
                     * -> Stock.saldo = 0 -> datosMovimientoAlmacen.detalle[posicion].movimientoOk = "False"
                     * Fin Si
                     */
                    //dtoMAD.setCantidad(new Long(cantidad - localStock.getSaldo().longValue()));
                    dtoMAD.setCantidad(new Long(localStock.getSaldo().longValue()));   //segun JF         
                    localStock.setSaldo(new Long(0));
                    dtoMAD.setMovimientoOk(Boolean.FALSE);
                }

                /*
                 * -> a�adir al atributo de esta clase "reportePedidos.lineasDetalle",
                 * de tipo array, el objeto "datosMovimientoAlmacen.detalle[posicion]"
                 */
				 
                this.reportePedidos.getLineasDetalle().add(dtoMAD);
				
			
            } else {
                /*
                 * Si no entonces
                 * -> Stock.saldo = Stock.saldo - datosMovimientoAlmacen.detalle[posicion].cantidad
                 * Fin Si
                 * Fin Si
                 */
                long cantidad = 0;
                if (dtoMAD.getCantidad() != null){
                    cantidad = dtoMAD.getCantidad().longValue();
                }
                localStock.setSaldo(new Long(localStock.getSaldo().longValue() - cantidad));
            }
        }
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(int posicion, Long almacen, Long estado, Long producto, String operacion):Salida");
    }

    /**
    * M�todo para Anula los movimientos de almac�n y regenera los stocks anteriores
     * atendiendo a los par�metros de entrada recibidos.
    * @param dto DTOReversionMovimiento
    * @exception MareException
    */
    public void reversionMovimientoAlmacen(DTOReversionMovimiento dto)
        throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.reversionMovimientoAlmacen(DTOReversionMovimiento dto):Entrada");

        //Modificado el metodo por la incidencia 9245
        //Se llama al m�todo DAOMovimientosAlmacen.obtenerLineasReversion pas�ndole 
        //como par�metro de entrada dto (recibido por par�metro). 
        //El m�todo retorna un RecordSet (lineas). 
        RecordSet lineas = null;
        DAOMovimientosAlmacen daoMovimientosAlmacen = new DAOMovimientosAlmacen();
    
        lineas = daoMovimientosAlmacen.obtenerLineasReversion(dto);
        TipoMovimientosAlmacenLocalHome tipoMovAlma = this.getTipoMovimientosAlmacenLocalHome();
        TipoMovimientosAlmacenLocal tipoMovAlmaLocal = null;

        for (int i=0; i < lineas.getRowCount(); i++){
			
            try {
                tipoMovAlmaLocal = tipoMovAlma.findByPrimaryKey(new Long(lineas.getValueAt(i,"TIPOMOVIMIENTOALMACEN").toString()));
            } catch (NoResultException fe) {
                ctx.setRollbackOnly();
                this.loguearError("reversionMovimientoAlmacen: FinderException", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            //Si TipoMovimientosAlmacen.estadoMercancia1 <> null y TipoMovimientosAlmacen.operacion1 <> null 
            //reversionStock (MovimientosAlmacenDetalle(i).almacenSalida, TipoMovimientosAlmacen.estadoMercancia1, TipoMovimientosAlmacen.operacion1, MovimientosAlmacenDetalle(i).producto, MovimientosAlmacenDetalle(i).cantidad) 
            //Fin del Si 
            if (tipoMovAlmaLocal.getEstadoMercancia1() != null && tipoMovAlmaLocal.getOperacion1() != null) {
                //llamada a reversion stock
                this.reversionStock(new Long(lineas.getValueAt(i,"ALMACENSALIDA").toString()),
                    tipoMovAlmaLocal.getEstadoMercancia1(),
                    tipoMovAlmaLocal.getOperacion1(), 
					new Long(lineas.getValueAt(i,"PRODUCTO").toString()),
                    new Long(lineas.getValueAt(i,"CANTIDAD").toString()));
            }

            //Si MovimientosAlmacenDetalle(i).almacenEntrada <> null 
            //Si TipoMovimientosAlmacen.estadoMercancia2 <> null y TipoMovimientosAlmacen.operacion2 <> null 
            //reversionStock (MovimientosAlmacenDetalle(i).almacenEntrada, TipoMovimientosAlmacen.estadoMercancia2, TipoMovimientosAlmacen.operacion2, MovimientosAlmacenDetalle(i).producto, MovimientosAlmacenDetalle(i).cantidad) 
            //Fin del Si 
            //Fin del Si 
            if (lineas.getValueAt(i,"ALMACENENTRADA") != null) {
                if ((tipoMovAlmaLocal.getEstadoMercancia2() != null) &&
                        (tipoMovAlmaLocal.getOperacion2() != null)) {
                    this.reversionStock(new Long(lineas.getValueAt(i,"ALMACENENTRADA").toString()),
                        tipoMovAlmaLocal.getEstadoMercancia2(),
                        tipoMovAlmaLocal.getOperacion2(),
                        new Long(lineas.getValueAt(i,"PRODUCTO").toString()), 
						new Long(lineas.getValueAt(i,"CANTIDAD").toString()));
                }
            }

            //Se elimina de la entidad (EJB Entity) MovimientosAlmacenDetalle el objeto cuyo oid es MovimientosAlmacenDetalle(i).oid 
            MovimientosAlmacenDetalleLocalHome homeMAD = this.getMovimientosAlmacenDetalleLocalHome();
            MovimientosAlmacenDetalleLocal localMAD = null;
    
            try{
                localMAD = homeMAD.findByPrimaryKey(new Long(lineas.getValueAt(i,"OIDLINEA").toString()));
            } catch (NoResultException fe){
                  ctx.setRollbackOnly();
                  this.loguearError("reversionMovimientoAlmacen: FinderException", fe);
                  throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
			
            try {
                homeMAD.remove(localMAD);
            } catch (PersistenceException re) {
                ctx.setRollbackOnly();
                this.loguearError("reversionMovimientoAlmacen: RemoveException", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }

        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.reversionMovimientoAlmacen(DTOReversionMovimiento dto):Salida");
    }

    private void reversionStock(Long almacen, Long estado, Character operacion,
        Long producto, Long cantidad) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.reversionStock(Long almacen, Long estado, Character operacion, Long producto, Long cantidad):Entrada");

        /*Se llama al m�todo findByClaveUnica de la entidad (EJB Entity) Stock con los par�metros de entrada: almacen, estado y producto
        Si operacion == '+'
        Stock.saldo = Stock.saldo - cantidad
        Si no
        Stock.saldo = Stock.saldo + cantidad
        Fin del Si*/
        StockLocalHome stockLocalHome = this.getStockLocalHome();
        StockLocal stockLocal = null;

        try {
            stockLocal = stockLocalHome.findByClaveUnica(almacen, estado,
                    producto);
        } catch (NoResultException fe) {
            ctx.setRollbackOnly();
            this.loguearError("reversionStock: FinderException", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if ("+".equals(operacion)) {
            //localStock.setSaldo(new Long(localStock.getSaldo().longValue()+dtoMAD.getCantidad().longValue()));
            stockLocal.setSaldo(new Long(stockLocal.getSaldo().longValue() - cantidad.longValue()));
        } else {
            stockLocal.setSaldo(new Long(stockLocal.getSaldo().longValue() + cantidad.longValue()));
        }
        stockLocalHome.merge(stockLocal);
        
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.reversionStock(Long almacen, Long estado, Character operacion, Long producto, Long cantidad):Salida");
    }

    private void loguearError(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +e.getMessage());
        UtilidadesLog.error("ERORR",e);
    }

    private MONMantenimientoTiposMovimientosAlmacen getMONMantenimientoTiposMovimientosAlmacen()
        throws MareException {
        UtilidadesLog.debug(
            "****Metodo  getMONMantenimientoTiposMovimientosAlmacen: Entrada");

        // Se obtiene el interfaz home
        MONMantenimientoTiposMovimientosAlmacenHome home = (MONMantenimientoTiposMovimientosAlmacenHome) UtilidadesEJB.getHome(MON_MANTENIMIENTO_TIPOS_MOVIMIENTOS_ALMACEN,
                MONMantenimientoTiposMovimientosAlmacenHome.class);

        // Se obtiene el interfaz remoto
        MONMantenimientoTiposMovimientosAlmacen ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONMantenimientoTiposMovimientosAlmacen",
                e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo  getMONMantenimientoTiposMovimientosAlmacen: Salida");
        return ejb;
    }

    private MONValidacion getMONValidacion() throws MareException {
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
        return ejb;
    }
	

    private MONProcesosPED getMONProcesosPED() throws MareException {
        // Se obtiene el interfaz home
        MONProcesosPEDHome home = (MONProcesosPEDHome) UtilidadesEJB.getHome(MON_PROCESO_PED,
                MONProcesosPEDHome.class);

        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.loguearError("*** Error en getMONProcesosPED", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        return ejb;
    }
    
    
    private void grabarMovimientoDetalle() throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoDetalle():Entrada");
        DTOMovimientoAlmacenDetalle dtoMAD = null;
        HashMap hashStockOp1 = new HashMap();
        HashMap hashStockOp2 = new HashMap();
        ArrayList arrayOperaciones = new ArrayList();
        if (this.datosMovimientoAlmacen.getDetalle() != null) {
          for (int i = 0; i <  this.datosMovimientoAlmacen.getDetalle().size(); i++) {
              this.copiarValoresCabeceraADetalle(i);
              dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle().get(i);  
              if (!arrayOperaciones.contains(dtoMAD.getOperacion().toString())){
                arrayOperaciones.add(dtoMAD.getOperacion().toString());
              }
              DTOStock dtoStock = new DTOStock();
              dtoStock.setOidAlmacen(dtoMAD.getOidAlmacenSalida());
              dtoStock.setOidEstadoMercancia( this.tipoMovimientoAlmacen.getOidEstadoMercancia1());
              dtoStock.setOidProducto(dtoMAD.getOidProducto());
              dtoStock.setSaldo(new Long(0));
              dtoStock.setIndicadorUpdate(Boolean.FALSE);
              hashStockOp1.put(dtoMAD.getOidAlmacenSalida().toString()+"-"+dtoMAD.getOidProducto().toString(), dtoStock);      
              if (this.tipoMovimientoAlmacen.getOperacion2()!=null){
                  Long oidAlmacen = dtoMAD.getOidAlmacenEntrada();
                  if (oidAlmacen == null) oidAlmacen = dtoMAD.getOidAlmacenSalida();
                  dtoStock = new DTOStock();
                  dtoStock.setOidAlmacen(oidAlmacen);
                  dtoStock.setOidEstadoMercancia( this.tipoMovimientoAlmacen.getOidEstadoMercancia2());
                  dtoStock.setOidProducto(dtoMAD.getOidProducto());
                  dtoStock.setSaldo(new Long(0));
                  dtoStock.setIndicadorUpdate(Boolean.FALSE);
                  hashStockOp2.put(oidAlmacen.toString()+"-"+dtoMAD.getOidProducto().toString(), dtoStock);                            
              }            
          }
        }
        
        DTOGrabarStock dtoGrabarStock = new DTOGrabarStock();
        dtoGrabarStock.setDtoMovimientoAlmacen(this.datosMovimientoAlmacen);
        dtoGrabarStock.setDtoReportePedidos(this.reportePedidos);
        dtoGrabarStock.setDtoTipoMovimientoAlmacen(this.tipoMovimientoAlmacen);
        dtoGrabarStock.setHashOperacion1(hashStockOp1);
        dtoGrabarStock.setHashOperacion2(hashStockOp2);
        dtoGrabarStock.setNumeroOperacion(new Integer(1));
        
        try {
            dtoGrabarStock = this.getMONGenerarMovimientoAlmacenLocal().grabarStock(dtoGrabarStock);
        }catch(Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR",e);
            UtilidadesLog.debug("Error al Grabar Stock");
            throw new MareException(e);
        }   
                
        if (this.tipoMovimientoAlmacen.getOperacion2()!=null){ 
            try {
                dtoGrabarStock.setNumeroOperacion(new Integer(2));        
                dtoGrabarStock = this.getMONGenerarMovimientoAlmacenLocal().grabarStock(dtoGrabarStock);
            }catch(Exception e){
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR",e);
                UtilidadesLog.debug("Error al Grabar Stock");
                throw new MareException(e);
            }           
        }
        
      /*hashStockOp1 = this.recuperarValoresDeStock(hashStockOp1, this.tipoMovimientoAlmacen.getOidEstadoMercancia1());
        this.grabarStock(hashStockOp1, this.tipoMovimientoAlmacen.getOperacion1().toString(), this.tipoMovimientoAlmacen.getOidEstadoMercancia1());
        if (this.tipoMovimientoAlmacen.getOperacion2()!=null){ 
          hashStockOp2 = this.recuperarValoresDeStock(hashStockOp2, this.tipoMovimientoAlmacen.getOidEstadoMercancia2());
          this.grabarStock(hashStockOp2, this.tipoMovimientoAlmacen.getOperacion2().toString(),  this.tipoMovimientoAlmacen.getOidEstadoMercancia2());
        }*/
        
        this.tipoMovimientoAlmacen = dtoGrabarStock.getDtoTipoMovimientoAlmacen();
        this.datosMovimientoAlmacen = dtoGrabarStock.getDtoMovimientoAlmacen();
        this.reportePedidos = dtoGrabarStock.getDtoReportePedidos();
        
        if (this.tipoMovimientoAlmacen.getMantieneMovimientos().booleanValue() == true) {
            String numeroDocumento = null;
            
            HashMap hashOperaciones = new HashMap();
            hashOperaciones = this.recuperarOperaciones(arrayOperaciones);
            arrayOperaciones.clear();
            StringBuffer query = new StringBuffer("");
            for (int i = 0; i <  this.datosMovimientoAlmacen.getDetalle().size(); i++) {
              dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle().get(i); 
              if (this.datosMovimientoAlmacen.getCabecera().getNumeroMovimiento() != null) {
                dtoMAD.setNumeroMovimiento(this.datosMovimientoAlmacen.getCabecera().getNumeroMovimiento());
              }
              if (dtoMAD.getCantidad() == null) dtoMAD.setCantidad(new Long(0)); 
              query.append(this.generarStringInsercionMovAlmacenDetalle(dtoMAD, hashOperaciones, i));             
            }

            try {
              BelcorpService belcorpService = BelcorpService.getInstance();
              belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
            } catch ( Exception ex ) {
              throw new MareException( ex, 
                  UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
            } 
            
            //dtoMAD.setOid(localMAD.getOid());
        }
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarMovimientoDetalle():Salida");
    }
    
    
    private HashMap recuperarValoresDeStock(HashMap hashStock, Long oidEstadoMercancia) throws MareException {
      UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.recuperarValoresDeStock(HashMap hashStock): Entrada");
      StringBuffer query = new StringBuffer("");
      
      query.append(" SELECT BS.OID_STOC, ");
			query.append("        BS.ALMC_OID_ALMA, ");
			query.append("        BS.ESME_OID_ESTA_MERC, ");
			query.append("        BS.PROD_OID_PROD, ");
			query.append("        BS.VAL_SALD ");
		  query.append(" FROM BEL_STOCK BS ");
		  query.append(" WHERE BS.ESME_OID_ESTA_MERC = " + oidEstadoMercancia);      
      query.append(" AND (");      
      Iterator it = (Iterator)((Collection)hashStock.values()).iterator();
      while (it.hasNext()){        
          DTOStock dtoStock = (DTOStock)it.next();
          query.append("(BS.ALMC_OID_ALMA = " + dtoStock.getOidAlmacen() + " AND BS.PROD_OID_PROD = " + dtoStock.getOidProducto() + ")");
          if (!it.hasNext()){              
            query.append(")");
          } else {
            query.append(" OR ");
          }
      }
      
      query.append(" FOR UPDATE");
      RecordSet rs = null;
      rs = this.executeQuery(query.toString());
      
      if (rs != null && !rs.esVacio()){
        for (int i = 0; i<rs.getRowCount();i++){
          Long oidAlmacen = this.bigDecimalToLong(rs.getValueAt(i,"ALMC_OID_ALMA"));
          Long oidProducto = this.bigDecimalToLong(rs.getValueAt(i,"PROD_OID_PROD"));
          DTOStock dtoStock = (DTOStock) hashStock.get(oidAlmacen.toString()+"-"+oidProducto.toString());
          dtoStock.setSaldo(this.bigDecimalToLong(rs.getValueAt(i,"VAL_SALD")));
          dtoStock.setOidStock(this.bigDecimalToLong(rs.getValueAt(i,"OID_STOC")));
          dtoStock.setIndicadorUpdate(Boolean.TRUE);
          hashStock.put(oidAlmacen.toString()+"-"+oidProducto.toString(),dtoStock);
        }
      }      
      
      UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.recuperarValoresDeStock(HashMap hashStock): Salida");
      return hashStock;
    }
    
   private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.executeQuery(String query): Salida");  
    return rs;
  }

 private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
  }
 /* 
  private void grabarStock(HashMap hashStock, String operacion, Long oidMovimiento) throws MareException {
     UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(HashMap hashStock, String operacion, Long oidMovimiento):Entrada");
     StringBuffer query = new StringBuffer();
     for (int i = 0;i<this.datosMovimientoAlmacen.getDetalle().size();i++){
        DTOMovimientoAlmacenDetalle dtoMAD = (DTOMovimientoAlmacenDetalle) this.datosMovimientoAlmacen.getDetalle().get(i);
        Long oidAlmacen = null;
        if (this.tipoMovimientoAlmacen.getOidEstadoMercancia1() == oidMovimiento){
            oidAlmacen = dtoMAD.getOidAlmacenEntrada();
        }
        if (oidAlmacen == null) {
          oidAlmacen = dtoMAD.getOidAlmacenSalida();   
        }
        DTOStock dtoStock = (DTOStock)hashStock.get(oidAlmacen.toString()+dtoMAD.getOidProducto());
        
        if ("+".equals(operacion)) {            
            long cantidad = 0;
            if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
            dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() + cantidad));
        } else if ("-".equals(operacion)) {
            if (dtoMAD.getOperacion().indexOf("PED") == 0) {
                long cantidad = 0;
                if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
                 if ((dtoStock.getSaldo().longValue() > 0) && (dtoStock.getSaldo().longValue() >= cantidad)) {                 
                    dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() - cantidad));
                    dtoMAD.setMovimientoOk(Boolean.TRUE);
                } else {
                    dtoMAD.setCantidad(new Long(dtoStock.getSaldo().longValue()));         
                    dtoStock.setSaldo(new Long(0));
                    dtoMAD.setMovimientoOk(Boolean.FALSE);
                }
                this.reportePedidos.getLineasDetalle().add(dtoMAD);
            } else {
                long cantidad = 0;
                if (dtoMAD.getCantidad() != null){
                    cantidad = dtoMAD.getCantidad().longValue();
                }
                dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() - cantidad));
            }
        }        
        if (dtoStock.getIndicadorUpdate().booleanValue()){
           query.append(this.generarStringUpdateStock(dtoStock).toString());
        } else {
           query.append(this.generarStringInsercionStock(dtoStock));
        }        
     }     
     
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    } 
       UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(HashMap hashStock, String operacion, Long oidMovimiento):Salida");
  }
*/

  private StringBuffer generarStringUpdateStock (DTOStock dtoStock) {
     StringBuffer query = new  StringBuffer();
     query.append("UPDATE BEL_STOCK SET VAL_SALD = " + dtoStock.getSaldo() + " WHERE OID_STOC = " + dtoStock.getOidStock() + ";");
     return query;  
  }
  
  private StringBuffer generarStringUpdateStockDos (DTOStock dtoStock) {
     StringBuffer query = new  StringBuffer();
     query.append("UPDATE BEL_STOCK SET VAL_SALD = " + dtoStock.getSaldo().toString());
     query.append(" WHERE ALMC_OID_ALMA = "+dtoStock.getOidAlmacen().toString() );
     query.append(" AND ESME_OID_ESTA_MERC = "+dtoStock.getOidEstadoMercancia().toString());
     query.append(" AND PROD_OID_PROD = "+dtoStock.getOidProducto().toString());
     return query;  
  }
  
  
  private StringBuffer generarStringInsercionStock (DTOStock dtoStock) {
     StringBuffer query = new  StringBuffer();
     query.append("INSERT INTO BEL_STOCK (OID_STOC,ALMC_OID_ALMA,ESME_OID_ESTA_MERC,PROD_OID_PROD,VAL_SALD) VALUES (");
     query.append("BEL_STCK_SEQ.NEXTVAL," + dtoStock.getOidAlmacen() + "," + dtoStock.getOidEstadoMercancia() + "," + dtoStock.getOidProducto() + "," + dtoStock.getSaldo());
     query.append(");");
     return query;  
  }
   
  private HashMap recuperarOperaciones(ArrayList arrayOperaciones)  throws MareException {
    HashMap hashOperaciones = new HashMap();
    if (arrayOperaciones.size() > 0) {
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT BO.OID_OPER, BO.COD_OPER ");
      query.append(" FROM BEL_OPERA BO ");
      query.append(" WHERE (");
    
      Iterator it = arrayOperaciones.iterator();
      int count = 0;
      String operaciones = "";
      while (it.hasNext()){
          String operacion = (String) it.next();          
          if (operacion != null){
              if (count == 0) {
                  operaciones = "'" + operacion.toString() + "'";
              } else { 
                  operaciones += ",'" + operacion.toString() + "'";
              }
          }                    
          if (count == 999)  {
              query.append(" BO.COD_OPER IN (" + operaciones.toString() + ") ");                     
              if (it.hasNext()){
                  query.append("  OR ");
              }                    
              count = 0;
              operaciones = "";                         
          } else {
              if (!it.hasNext()){
                  query.append(" BO.COD_OPER IN (" + operaciones.toString() + ") ");        
              }                    
              count++;            
          } 
          
          if (!it.hasNext()){              
            query.append(")");
          }
      }
      
      RecordSet rs = null;
      
      rs = this.executeQuery(query.toString());
    
      if (rs != null && !rs.esVacio()){
        for (int i = 0; i<rs.getRowCount();i++){
            hashOperaciones.put(this.bigDecimalToString(rs.getValueAt(i,"COD_OPER")),this.bigDecimalToLong(rs.getValueAt(i,"OID_OPER")));    
        }
      }    
    }
    return hashOperaciones;  
  } 
  
  private String bigDecimalToString(Object ob) {
        if (ob != null) {
            return ob.toString();
        } else {
            return null;
        }
  } 
  
  private StringBuffer generarStringInsercionMovAlmacenDetalle(DTOMovimientoAlmacenDetalle dtoMAD, HashMap hashOperaciones, int posicion){
    StringBuffer query = new StringBuffer();
    query.append("INSERT INTO BEL_MOVIM_ALMAC_DETAL ");
		query.append("  (OID_DETA,MVAL_OID_MOVI_ALMA,NUM_LINE,VAL_CANT,VAL_PREC_VENT_NETO,VAL_PREC_CONT,NUM_DOCU_REFE,NUM_POSI_REFE,TMAL_OID_TIPO_MOVI_ALMA, ");
		query.append("  PROD_OID_PROD,OPER_OID_OPER,ALMC_OID_ALMA_ENTR,ALMC_OID_ALMA_SALI,N_MOVIMIENTO,TOFE_OID_TIPO_OFER,NUM_LOTE_SAPM,TPOS_OID_TIPO_POSI, ");
		query.append("  STPO_OID_SUBT_POSI) VALUES (BEL_MADE_SEQ.NEXTVAL," + this.datosMovimientoAlmacen.getCabecera().getOid() + ",");
    query.append(new Integer(posicion + 1) + "," + dtoMAD.getCantidad() + "," + dtoMAD.getPrecioVentaNeto() + "," + dtoMAD.getPrecioContable() + "," + dtoMAD.getNumeroDocumentoReferencia());
    query.append("," + dtoMAD.getNumeroPosicionReferencia() + "," + dtoMAD.getOidTipoMovimientoAlmacen() + "," + dtoMAD.getOidProducto() + ",");
    Long operacion = (Long)hashOperaciones.get(dtoMAD.getOperacion().toString());
    query.append(operacion + "," + dtoMAD.getOidAlmacenEntrada() + "," + dtoMAD.getOidAlmacenSalida() + "," + dtoMAD.getNumeroMovimiento() + "," + dtoMAD.getOidTipoOferta());
    query.append(",NULL," + dtoMAD.getOidTipoPosicion() + "," + dtoMAD.getOidSubtipoPosicion() + ");");
    
		return query;
  }

  public DTOGrabarStock grabarStock(DTOGrabarStock dtoGrabarStock) throws MareException {
     this.lockeaTabla();
     if (dtoGrabarStock.getNumeroOperacion().intValue() == 1) {
        HashMap hashStockOp1 = (HashMap)dtoGrabarStock.getHashOperacion1();        
        hashStockOp1 = this.recuperarValoresDeStock(hashStockOp1, dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOidEstadoMercancia1());         
        dtoGrabarStock = this.grabarStock(hashStockOp1,dtoGrabarStock, dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOperacion1().toString(), dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOidEstadoMercancia1());
     } else {
        HashMap hashStockOp2 = (HashMap)dtoGrabarStock.getHashOperacion2();
        hashStockOp2 = this.recuperarValoresDeStock(hashStockOp2, dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOidEstadoMercancia2());     
        dtoGrabarStock = this.grabarStock(hashStockOp2, dtoGrabarStock, dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOperacion2().toString(), dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOidEstadoMercancia2());
     }
     this.liberaTabla();
     return dtoGrabarStock;
  }
  
    private void lockeaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("SELECT OID_CONT_CORR_STOC FROM BEL_CONTR_CORRE_STOCK WHERE OID_CONT_CORR_STOC = 1 FOR UPDATE");
            this.executeQuery(queryFinal.toString());
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }
    
    private void liberaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("UPDATE BEL_CONTR_CORRE_STOCK SET FEC_ULTI_STOC = SYSDATE WHERE OID_CONT_CORR_STOC = 1");
            BelcorpService belcorpService = BelcorpService.getInstance();
            int cant = belcorpService.dbService.executeUpdate( queryFinal.toString() );
            if (cant == 0){
                queryFinal = new StringBuffer("INSERT INTO BEL_CONTR_CORRE_STOCK ( OID_CONT_CORR_STOC, FEC_ULTI_STOC ) VALUES ( 1, SYSDATE) ");
                belcorpService.dbService.executeUpdate( queryFinal.toString() );
            }
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }



    private MONGenerarMovimientoAlmacenLocalHome getMONGenerarMovimientoAlmacenLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarMovimientoAlmacenLocalHome)context.lookup("java:comp/env/MONGenerarMovimientoAlmacen");
    }

    private MONGenerarMovimientoAlmacenLocal getMONGenerarMovimientoAlmacenLocal() throws NamingException, MareException {

        MONGenerarMovimientoAlmacenLocalHome localHome = this.getMONGenerarMovimientoAlmacenLocalHome();
        // Se obtiene el interfaz remoto
        MONGenerarMovimientoAlmacenLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGenerarMovimientoAlmacenLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }
    
    private static String SQL_COORDINADOR= "UPDATE BEL_STOCK_COOR SET ULT_OID_STOC = ";


    private DTOGrabarStock grabarStock(HashMap hashStock, DTOGrabarStock dtoGrabarStock, String operacion, Long oidMovimiento) throws MareException {
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(HashMap hashStock, DTOGrabarStock dtoGrabarStock, String operacion, Long oidMovimiento):Entrada");
        StringBuffer query = new StringBuffer();
        HashMap agrupados = new HashMap();
        int lon = dtoGrabarStock.getDtoMovimientoAlmacen().getDetalle().size();
        for (int i = 0;i < lon;i++){
            DTOMovimientoAlmacenDetalle dtoMAD = (DTOMovimientoAlmacenDetalle)dtoGrabarStock.getDtoMovimientoAlmacen().getDetalle().get(i);
            Long oidAlmacen = null;
            if (dtoGrabarStock.getDtoTipoMovimientoAlmacen().getOidEstadoMercancia1() == oidMovimiento){
                oidAlmacen = dtoMAD.getOidAlmacenEntrada();
            }
            if (oidAlmacen == null) {
                oidAlmacen = dtoMAD.getOidAlmacenSalida();   
            }
            DTOStock dtoStock = (DTOStock)hashStock.get(oidAlmacen.toString()+"-"+dtoMAD.getOidProducto());
        
            if ("+".equals(operacion)) {            
                long cantidad = 0;
                if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
                dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() + cantidad));
            } else if ("-".equals(operacion)) {
                if (dtoMAD.getOperacion().indexOf("PED") == 0) {
                    long cantidad = 0;
                    if (dtoMAD.getCantidad() != null) cantidad = dtoMAD.getCantidad().longValue();
                     if ((dtoStock.getSaldo().longValue() > 0) && (dtoStock.getSaldo().longValue() >= cantidad)) {                 
                        dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() - cantidad));
                        dtoMAD.setMovimientoOk(Boolean.TRUE);
                    } else {
                        dtoMAD.setCantidad(new Long(dtoStock.getSaldo().longValue()));         
                        dtoStock.setSaldo(new Long(0));
                        dtoMAD.setMovimientoOk(Boolean.FALSE);
                    }
                   dtoGrabarStock.getDtoReportePedidos().getLineasDetalle().add(dtoMAD);
                } else {
                    long cantidad = 0;
                    if (dtoMAD.getCantidad() != null){
                        cantidad = dtoMAD.getCantidad().longValue();
                    }
                    dtoStock.setSaldo(new Long(dtoStock.getSaldo().longValue() - cantidad));
                }
            }      
            
            
            
            if (dtoStock.getIndicadorUpdate().booleanValue()){
                query.append(this.generarStringUpdateStock(dtoStock).toString());
            } else {
               //Modificado por gacevedo, seg�n incidencia bloqueante de validacion (29/06/2006)
               //Pueden existir mas de un codigo de venta asociado al mismo producto, por lo que
               //debemos validar que el insert de stock, si es que el registro no existe, se haga
               //solo una vez.
                if(agrupados.get(oidAlmacen.toString()+"-"+dtoMAD.getOidProducto())!=null){
                  //como acabamos de insertar no tenemos oid, por lo que este
                  //update se hace por el UK de almacen-producto-estado.
                  //Esta parte solo se ejecuta si ya hice con anterioridad un insert
                  //para esta misma combinacion de producto-almacen-estado, ya que lo
                  //encuentre en el hash de control.
                   query.append(this.generarStringUpdateStockDos(dtoStock).toString());
                }else{
                  //si hago un insert, agrego la clave a un hash que luego uso de control
                  agrupados.put(oidAlmacen.toString()+"-"+dtoMAD.getOidProducto(),"");
                  query.append(this.generarStringInsercionStock(dtoStock));   
                }
               //la siguiente linea no se para que esta, pero la dejo por las dudas
               dtoStock.setIndicadorUpdate(Boolean.TRUE);

            }        
        }
    
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch ( Exception ex ) {
            throw new MareException( ex, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.grabarStock(HashMap hashStock, DTOGrabarStock dtoGrabarStock, String operacion, Long oidMovimiento):Salida");
        return dtoGrabarStock;
    }


    private TipoMovimientosAlmacenLocalHome getTipoMovimientosAlmacenLocalHome() {
        return new TipoMovimientosAlmacenLocalHome();
    }

    private MovimientosAlmacenDetalleLocalHome getMovimientosAlmacenDetalleLocalHome() {
        return new MovimientosAlmacenDetalleLocalHome();
    }

    private StockLocalHome getStockLocalHome() {
        return new StockLocalHome();
    }

    private OperacionesLocalHome getOperacionesLocalHome() {
        return new OperacionesLocalHome();
    }

    public String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException {
        String numeroSolicitud = null;
        try {       
          numeroSolicitud = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_NUM_SOL_OCR", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        return numeroSolicitud;
    }

    //sapaza -- cambio RoadMap Internacionalizacion Toplink -- 19/05/2010                    
    public  DTOTipoMovimientoAlmacen consultarTipoMovimientoAlmacen(DTOOID dto) throws MareException{
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.consultarTipoMovimientoAlmacen(DTOOID dto):Entrada");
        DTOTipoMovimientoAlmacen dtoRetorno=new DTOTipoMovimientoAlmacen();
        DAOTiposMovimientosAlmacen daoTiposMovimientosAlmacen=new DAOTiposMovimientosAlmacen();

        //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011        
        ProcesoFacturacionHelper helper = ProcesoFacturacionHelper.getInstance(dto.getOidPais(), dto.getOidIdioma());
        RecordSet rs = (RecordSet)helper.getTipoMovimientoAlmacen().get(dto.getOid());
        //RecordSet rs=daoTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(dto);
        
        try{
            if(rs!=null&&!rs.esVacio()){
                if(rs.getValueAt(0,0)!=null){
                        dtoRetorno.setOid(new Long(rs.getValueAt(0,0).toString()));
                }
                if(rs.getValueAt(0,1)!=null){
                        dtoRetorno.setOidPais(new Long(rs.getValueAt(0,1).toString()));
                }
                if(rs.getValueAt(0,2)!=null){
                        dtoRetorno.setCodigoMovimiento(rs.getValueAt(0,2).toString());
                }
                if(rs.getValueAt(0,3)!=null){
                        dtoRetorno.setDescripcion(rs.getValueAt(0,3).toString());
                }
                if(rs.getValueAt(0,4)!=null){
                        dtoRetorno.setCodigoMovimientoSAP(rs.getValueAt(0,4).toString());
                }
                if(rs.getValueAt(0,5)!=null){
                        dtoRetorno.setOperacion1(new Character(rs.getValueAt(0,5).toString().charAt(0)));
                }
                if(rs.getValueAt(0,6)!=null){
                        dtoRetorno.setOperacion2(new Character(rs.getValueAt(0,6).toString().charAt(0)));
                }
                if(rs.getValueAt(0,7)!=null){
                        if(rs.getValueAt(0,7).toString().equals("0")){
                                dtoRetorno.setMovimientoEntreAlmacenes(Boolean.FALSE);
                        }else{
                                dtoRetorno.setMovimientoEntreAlmacenes(Boolean.TRUE);
                        }
                }
                if(rs.getValueAt(0,8)!=null){
                        if(rs.getValueAt(0,8).toString().equals("0")){
                                dtoRetorno.setMantieneMovimientos(Boolean.FALSE);
                        }else{
                                dtoRetorno.setMantieneMovimientos(Boolean.TRUE);
                        }                       
                }
                if(rs.getValueAt(0,9)!=null){
                        if(rs.getValueAt(0,9).toString().equals("0")){
                                dtoRetorno.setIndicadorSAP(Boolean.FALSE);
                        }else{
                                dtoRetorno.setIndicadorSAP(Boolean.TRUE);
                        }                                               
                }
                if(rs.getValueAt(0,10)!=null){
                        dtoRetorno.setOidEstadoMercancia1(new Long(rs.getValueAt(0,10).toString()));
                }
                if(rs.getValueAt(0,11)!=null){
                        dtoRetorno.setOidEstadoMercancia2(new Long(rs.getValueAt(0,11).toString()));
                }
                if(rs.getValueAt(0,12)!=null){
                        dtoRetorno.setDescripcionEstado1(rs.getValueAt(0,12).toString());
                }
                if(rs.getValueAt(0,13)!=null){
                        dtoRetorno.setDescripconEstado2(rs.getValueAt(0,13).toString());
                }               
            }               
            
        }catch(NoResultException fe){
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.loguearError("consultarTipoMovimientoAlmacen: CreateException",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));                     
            
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONGenerarMovimientoAlmacenBean.consultarTipoMovimientoAlmacen(DTOOID dto):Salida");
        return dtoRetorno;
    }
    
}
