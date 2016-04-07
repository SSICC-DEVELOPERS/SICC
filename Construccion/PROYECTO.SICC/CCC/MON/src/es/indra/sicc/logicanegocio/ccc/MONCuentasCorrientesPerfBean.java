package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOAbonoSubprocesoMarcaSituacion;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTODatosAbonoSubprocesoMarcaSituacion;
import es.indra.sicc.dtos.ccc.DTOIdentificadoresDeCuota;
import es.indra.sicc.dtos.ccc.DTOMantenimientoTiposAbonoSubproceso;
import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTONumeroRegistros;
import es.indra.sicc.dtos.ccc.DTOSubproceso;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;
import es.indra.sicc.entidades.ccc.BloqueoMovBancLocal;
import es.indra.sicc.entidades.ccc.BloqueoMovBancLocalHome;
import es.indra.sicc.logicanegocio.ccc.HelperCancelacion;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesBD;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONCuentasCorrientesPerfBean implements SessionBean  {
  private SessionContext ctx;
  
  private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  
  private static HashMap solicitudesAsigTipoSolic;
  private static Byte IndicadorVencimiento;
  private static String anioStatico;
  private static String mesStatico;
  
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
 
 
  private static synchronized void precargaDatos(final Long oidPais, final Long[] tipoSolic) throws MareException{
     if(solicitudesAsigTipoSolic==null){
        solicitudesAsigTipoSolic = HelperCancelacion.obtenerSubprocesos(oidPais, tipoSolic);
     }
  }
 
  public void generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto) throws MareException {
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto): Entrada");    
    
    //long inicio = System.currentTimeMillis();
    //long tiempoMetodo = System.currentTimeMillis();
    try {
        final int largoArray = dto.length; 
        Long oidPais = null;
        DTOSubproceso dtoSubproceso;
        ArrayList arrayMarcaTipoAbono = new ArrayList();
        Long marcaSituacion=null;
        Long tipoAbono=null;
        Long tipoAbonoSubproceso =null;
        DTOMantenimientoTiposAbonoSubproceso dtoMantenimientoTiposAbonoSubproceso;
        Long cuentaContable=null;
        ArrayList cuotasCancelar = new ArrayList(); 
        ArrayList cuotasAplicar = new ArrayList();  
        String anioSistema=null;
        String mesSistema=null;        
        BigDecimal importePago=new BigDecimal(0);
        Integer ultimoNumeroHistoria=new Integer(0);
        String identificador=null;
        Long subprocesoCreacion=null;
        String ejerCuota=null;
        String identEjerCuota=null;
        String usuario = null;
        if(dto[0].getUsuario()!=null){
           usuario = dto[0].getUsuario();
        }else{
           usuario = ctx.getCallerPrincipal().getName();
        }
        DAOCCC daoCCC = new DAOCCC();
        
        //lo primero que hacemos es ordenar los dtos por fecha de vencimiento
        
        //inicio = System.currentTimeMillis();
        dto = HelperCancelacion.ordenarPorVencimiento(dto);
        //UtilidadesLog.warn("- GA - Ordenamiento en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
        //UtilidadesLog.debug("- GA - Usuario: "+usuario);
        
        if (largoArray > 0) {
            oidPais = dto[0].getOidPais();
            //inicio = System.currentTimeMillis();
            DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = daoCCC.obtenerAsignacionSubprocesosTiposSolicitudCreacion(oidPais, dto[0].getOidTipoSolicitud());
            if (dtoAbonSubMarSitu.getOid() != null){ //encontro data en la tabla: CCC_ASIGN_SUBPR_TIPO_SOLIC utilizo oid de proc. de crecion de cuotas y oid de subproceso
                                            //de crecion de cuotas y la cuenta corr. bria.
                dtoSubproceso = this.obtenerDatosSubprocesoSCS(oidPais, dtoAbonSubMarSitu.getOidProcesoCreacionCtas(), 
                                                                              dtoAbonSubMarSitu.getOidSubprocesoCreacionCtas());
            }else{  //no hay nada para el oid de tipo solicitud, recupero todo de la "forma general"
                dtoSubproceso = this.obtenerDatosSubproceso(oidPais, "CCC001", new Integer(1));
            }
            if (dtoSubproceso != null){
              subprocesoCreacion = dtoSubproceso.getOidSubproceso();
            }
            //UtilidadesLog.warn("- GA - buscar Subproceso en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            
            //inicio = System.currentTimeMillis();
            arrayMarcaTipoAbono = this.obtenerMarcasTipoAbonoDos(oidPais, subprocesoCreacion, "S");
            if (arrayMarcaTipoAbono.size() > 0){
              DTOMarcasPorTipoAbono dtoMarcasPorTipoAbono = (DTOMarcasPorTipoAbono)arrayMarcaTipoAbono.get(0);
              tipoAbono = dtoMarcasPorTipoAbono.getTipoAbono();
              tipoAbonoSubproceso = dtoMarcasPorTipoAbono.getTipoAbonoSubproceso();
              marcaSituacion = dtoMarcasPorTipoAbono.getOid();
            }        
            dtoMantenimientoTiposAbonoSubproceso = this.obtenerTiposAbonoSubprocesoCContable(oidPais, subprocesoCreacion);
            if (dtoMantenimientoTiposAbonoSubproceso != null){
               cuentaContable = dtoMantenimientoTiposAbonoSubproceso.getOidCuentaContable();
            }
            //UtilidadesLog.warn("- GA - buscar TipoAbonoSubproceso en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            
            try {
                java.util.Date fechaSistema_java = new Date(System.currentTimeMillis());
                anioSistema = UtilidadesFecha.convertirAString(fechaSistema_java, "yy");
                mesSistema = UtilidadesFecha.convertirAString(fechaSistema_java, "MM");
            } 
            catch (ParseException pe) {
                throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_FORMATO_FECHA));
            }
            identificador = dto[0].getNumeroIdentificadorCuota().toString();            
            identificador = this.cerosIzq(identificador, 10);
            ejerCuota = identificador.substring(0,2);
            identEjerCuota = identificador.substring(2,10);
            
            UtilidadesLog.debug("identificador = "+ identificador + "ejerCuota = "+ ejerCuota + "identEjerCuota = " + identEjerCuota);  
            
            //inicio = System.currentTimeMillis();        
            for (int i = 0; i < largoArray; i++) {
                dto[i].setEjercicioCuota(ejerCuota);            
                dto[i].setNumeroIdentificadorCuota(new Integer(identEjerCuota));      
                dto[i].setDocumentoAnyo(null);
                //dto[i].setDocumentoMesSerie(null);
                dto[i].setDocumentoNumero(null);    
                dto[i].setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
                dto[i].setTipoAbonoCreacion(tipoAbono);
                dto[i].setMarcaSituacion(marcaSituacion);
                dto[i].setUltimoDocumentoNumero(dto[i].getDocumentoNumero());
                dto[i].setSubprocesoCreacion(subprocesoCreacion);
                dto[i].setSubprocesoUltimo(dto[i].getSubprocesoCreacion());
                dto[i].setTipoAbonoUltimo(dto[i].getTipoAbonoCreacion());
                dto[i].setTipoAbonoSubprocesoUltimo(tipoAbonoSubproceso);
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

                if (dtoAbonSubMarSitu!=null && dtoAbonSubMarSitu.getOidCtaCteBancaria()!=null){
                    dto[i].setOidCtaCteBria(dtoAbonSubMarSitu.getOidCtaCteBancaria());
                }
                // sapaza -- PER-SiCC-2011-0246  -- 05/04/2011
                /*if (dto[i].getImporte().doubleValue() < new Double(0).doubleValue()) {
                    cuotasCancelar.add(dto[i]);
                } else {
                    cuotasAplicar.add(dto[i]);
                }*/
            }
            //UtilidadesLog.warn("- GA - Seteo de atributos en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
        }
        Integer numero;
        DTOBelcorp dtoBelcorp=null;
        MONCuentasCorrientesPerfLocal moncccPerfLocal = null;
        
        if (largoArray>0) {
            dtoBelcorp = new DTOBelcorp();
            dtoBelcorp.setOidPais(dto[0].getOidPais());
            DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos( usuario );
            DTOCargosAbonos dtoCargosAbonos = daoCargosAbonos.getCabeceraByMoviemientoCuenta( dto[0] );
            Long oidCabCargoAbono;
            //inicio = System.currentTimeMillis();
            if( dtoCargosAbonos == null ){
                moncccPerfLocal = this.getMONCuentasCorrientesPerfLocal();
                numero = moncccPerfLocal.obtenerSecuenciaPais(dtoBelcorp);
                //modificado por incidencia SiCC-20070262 (Sapaza) - 23/05/2007, las fechas se graban como se recibe de Facturacion
                oidCabCargoAbono = this.insertarCabeceraCargoAbono(numero, dto[0].getOidPais(), dto[0].getEmpresa(), usuario, dto[0].getNumeroLoteFactu(), 
                                                                   dto[0].getFechaValor(), dto[0].getFechaDocumento() );
            }else{
                numero = dtoCargosAbonos.getNumeroIdentificacion();
                oidCabCargoAbono = dtoCargosAbonos.getOid();
            }
            //UtilidadesLog.warn("- GA - busqueda de cabecera de cargo y abono en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            
            StringBuffer movimientosCuentasCorrientes = new StringBuffer();
            StringBuffer detallesCargosAbonosDirectos = new StringBuffer();
            Long oidMovimientoCtaCte, numeroLineaDetalle=null;
           
            //inicio = System.currentTimeMillis();
            for (int i = 0; i < largoArray; i++) {
                //dto[i].setOidCargoAbono(oidCabCargoAbono);
                dto[i].setDocumentoNumero(numero);
                dto[i].setUltimoDocumentoNumero(dto[i].getDocumentoNumero());            
                oidMovimientoCtaCte = this.agregarMovimientosCuentasCorrientes(dto[i], movimientosCuentasCorrientes);
                dto[i].setOid(oidMovimientoCtaCte);
                this.agregarDetalleCargosAbonosDirectos(dto[i], 
                detallesCargosAbonosDirectos, oidMovimientoCtaCte, 
                numeroLineaDetalle, oidCabCargoAbono);
            } //for              
            //UtilidadesLog.warn("- GA - generar detalles cargos abonos en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            movimientosCuentasCorrientes.append(detallesCargosAbonosDirectos.toString());
            //inicio = System.currentTimeMillis();
            this.grabarMovCCyDetCargoAbono(movimientosCuentasCorrientes);

            // sapaza -- PER-SiCC-2011-0246  -- 05/04/2011
            try {
                this.aplicarAbonosCargosCliente(dto[0].getOidCliente());
            } catch(Exception ex) {
                UtilidadesLog.error("Error en stored de AplicarAbonosCargosCliente (Primer Intento), para el oidCliente: " + dto[0].getOidCliente(), ex);

                try {
                    this.aplicarAbonosCargosCliente(dto[0].getOidCliente());
                } catch(Exception exn) {
                    UtilidadesLog.error("Error en stored de AplicarAbonosCargosCliente (Segundo Intento), para el oidCliente: " + dto[0].getOidCliente(), exn);
                }                
            }   

            /*
             * ESTE CODIGO FUE TRANSFERIDO A STORED (RCR PER-SiCC-2011-0246), QUE ES INVOCADO EN LA SENTENCIA ANTERIOR
             */
            //UtilidadesLog.warn("- GA - grabar detalles cargos abonos en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            //Generamos una unica cabecera de cargo abonos para 
            //todas las aplicaciones (positivas/negativas)
            //que se ejecuten
            /*Integer numeroIdentificacion = null;
            Long oidCabecera = null;
            Long oidCliente = null;
            if(cuotasCancelar.size()>0||cuotasAplicar.size()>0){
               //busco la cabecera de cargo y abono, si la encuentro, la uso, sino, la creo
               //inicio = System.currentTimeMillis();
               DTOMovimientoCuentaCompleto mov = dto[0];
               dtoCargosAbonos = this.getCabeceraByMovimientoCuentaAplicacion( dto[0] );
               if(dtoCargosAbonos!=null){
                  numeroIdentificacion = dtoCargosAbonos.getNumeroIdentificacion();
                  oidCabecera = dtoCargosAbonos.getOid();
               }else{
                  dtoBelcorp = new DTOBelcorp();
                  dtoBelcorp.setOidPais(mov.getOidPais());        
                  moncccPerfLocal = getMONCuentasCorrientesPerfLocal();
                  numeroIdentificacion = moncccPerfLocal.obtenerSecuenciaPais(dtoBelcorp);
                  oidCabecera = this.insertarCabeceraCargoAbonoCancelacionDeuda(numeroIdentificacion, 
                                                         mov.getOidPais(), mov.getEmpresa(), 
                                                                   usuario, mov);
               }
               //UtilidadesLog.warn("- GA - Segunda busqueda de cabeceras en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
            }else{
               //no habia nada que aplicar, ya fue
               return;
            }
            
            if (cuotasCancelar.size() > 0) {
                 // Modificacion de Gacevedo, por V-CCC-0020, V-CCC-029
               // ******************************************************************
               // La aplicacion y cancelacion debe tener en cuenta que
               // se pueden recibir varios consolidados pertenecientes
               // al mismo cliente, por ende a la hora de aplicar/cancelar
               // debe tratar toda la deuda de ese cliente en forma de bloque,
               // es decir, obtener toda la deuda de una sola vez y cancelar
               // contra toda la deuda obtenida en un unico paso.
               // Por otro lado, tanto cancelacion como aplicacion deben modificarse
               // a fin de tratar un array de dtos, en lugar de tratarlos
                 // uno a uno. 
               //
               //Uso un hash para ordenar los arrays de cuotas del mismo cliente.
               //inicio = System.currentTimeMillis();
               HashMap hashCuotasCancelar = agruparClientes(cuotasCancelar);
               //UtilidadesLog.warn("- GA - agrupar clientes en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
               Iterator it = hashCuotasCancelar.keySet().iterator();
               while(it.hasNext()){
                  oidCliente = (Long)it.next();
                  DTOMovimientoCuentaCompleto[] dtoMovArray = (DTOMovimientoCuentaCompleto[])hashCuotasCancelar.get(oidCliente);
                  //inicio = System.currentTimeMillis();
                  this.cancelacionAutomaticaDeuda(dtoMovArray, "N", oidCabecera, numeroIdentificacion);      
                  //UtilidadesLog.warn("- GA - Llamado a cancelacion con N en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
               }
            }
            int cantCuotasAplicar = cuotasAplicar.size();
            if (cantCuotasAplicar > 0) {
                HashMap hashOidsMCC = new HashMap();
                ArrayList arrayOidsMCC = new ArrayList();
                for(int i = 0; i < cantCuotasAplicar; i++) { // Pasamos de ArrayList a array
                    DTOMovimientoCuentaCompleto dtoMovim = (DTOMovimientoCuentaCompleto) cuotasAplicar.get(i);
                    hashOidsMCC.put(dtoMovim.getOid(), dtoMovim);
                    arrayOidsMCC.add(dtoMovim.getOid());
                }
                //este metodo no hace mas que actualizar los movimientos de cuenta corriente, ya
                //que modifica la referencia de los mismos. Pero yo no fui (gacevedo)
                //inicio = System.currentTimeMillis();
                hashOidsMCC = this.recuperarMovimientosCuentaCorriente(arrayOidsMCC, hashOidsMCC);
                //UtilidadesLog.warn("- GA - recuperar movimientos en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
                //
                  // Modificacion de Gacevedo, por V-CCC-0020, V-CCC-029
                // ******************************************************************
                // La aplicacion y cancelacion debe tener en cuenta que
                // se pueden recibir varios consolidados pertenecientes
                // al mismo cliente, por ende a la hora de aplicar/cancelar
                // debe tratar toda la deuda de ese cliente en forma de bloque,
                // es decir, obtener toda la deuda de una sola vez y cancelar
                // contra toda la deuda obtenida en un unico paso.
                // Por otro lado, tanto cancelacion como aplicacion deben modificarse
                // a fin de tratar un array de dtos, en lugar de tratarlos
                  // uno a uno. 
                //
               //Uso un hash para ordenar los arrays de cuotas del mismo cliente.
                HashMap hashCuotasAplicar = agruparClientes(cuotasAplicar);
               Iterator it = hashCuotasAplicar.keySet().iterator() ;
                while (it.hasNext()){
                   oidCliente = (Long)it.next();
                   DTOMovimientoCuentaCompleto[] dtoMovParaAplicar = (DTOMovimientoCuentaCompleto[])hashCuotasAplicar.get(oidCliente);
                   //inicio = System.currentTimeMillis();
                   this.cancelacionAutomaticaDeuda(dtoMovParaAplicar, "P", oidCabecera, numeroIdentificacion);
                   //UtilidadesLog.warn("- GA - Llamado a cancelacion con P en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
                   //inicio = System.currentTimeMillis();
                   this.aplicacionAutomaticaDeudaPositivaFacturacion(dtoMovParaAplicar, oidCabecera, numeroIdentificacion);
                   //UtilidadesLog.warn("- GA - Llamado a Aplicacion en Generar Cuenta corriente: "+(System.currentTimeMillis()-inicio));
                }
            }*/
            UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarCuentaCorriente(DTOMovimientoCuentaCompleto[] dto): Salida");
        }
     }  catch(Exception ex){
        UtilidadesLog.error("Error en MONCuentasCorrientesPerfBean.generarCuentaCorriente");
        ex.printStackTrace();
        if(ex instanceof MareException){
          throw (MareException) ex;
        }
        else{
            throw new MareException(ex);
        }
     }
     //UtilidadesLog.warn("- GA - Tiempo total de Generacion cuenta corriente "+(System.currentTimeMillis()-tiempoMetodo));
  }

  private HashMap agruparClientes(ArrayList cuotas){
            //Uso un hash para ordenar los arrays de cuotas del mismo cliente.
            HashMap hashCuotas = new HashMap();    
            Long oidCliente = new Long(-1);
            //agregamos los movimientos del cliente en la entrada que corresponda
            for(int i=0; i<cuotas.size(); i++){
              DTOMovimientoCuentaCompleto dtoTemp = (DTOMovimientoCuentaCompleto)cuotas.get(i);
              int ocurrenciasCliente =0;
              if(hashCuotas.get(oidCliente)==null){
                 oidCliente = dtoTemp.getOidCliente();
                 for(int w=0;w<cuotas.size();w++){
                    //contamos las ocurrencias del cliente en el array
                    if(dtoTemp.getOidCliente().equals(oidCliente)){
                       ocurrenciasCliente+=1;
                    }
                 }
                 //agregamos el array de movimientos, con el largo previamente calculado
                 hashCuotas.put(oidCliente,new DTOMovimientoCuentaCompleto[ocurrenciasCliente]);
              }
              DTOMovimientoCuentaCompleto[] array = (DTOMovimientoCuentaCompleto[])hashCuotas.get(oidCliente);
              //buscamos la ultima posicion del array y agregamos.
              for(int w=0; w< array.length;w++){
                 if(array[w]==null){
                    array[w] = dtoTemp;
                    break;
                 }
              }
            }
      return hashCuotas;
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
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.executeQuery(String query): Salida");  
    return rs;
  }
  private DTOSubproceso obtenerDatosSubprocesoSCS(Long oidPais, Long oidProceso, Long supbroceso) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerDatosSubprocesoSCS(Long oidPais, Long oidProceso, Integer supbroceso): Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer(300);
        
        query.append(" SELECT SUB.OID_SUBP, ");
    		query.append("        SUB.VAL_INDI_ACTU_CUOT "); 
        query.append(" FROM CCC_SUBPR SUB, ");
        query.append("      CCC_PROCE PRO ");
        query.append(" WHERE SUB.CCPR_OID_PROC = PRO.OID_PROC ");
        query.append("   AND PRO.PAIS_OID_PAIS = " + oidPais );
        //query.append("   AND PRO.COD_PROC = '" + proceso  + "' ");
        query.append("   AND PRO.OID_PROC = " + oidProceso.longValue());
        //query.append("   AND SUB.COD_SUBP = " + supbroceso.longValue());
        query.append("   AND SUB.OID_SUBP = " + supbroceso.longValue());
         
        rs = this.executeQuery(query.toString());
        DTOSubproceso dtoSubproceso = null; 
        if (rs!= null && ! rs.esVacio()){
            dtoSubproceso = new DTOSubproceso();
            dtoSubproceso.setOidSubproceso(this.bigDecimalToLong(rs.getValueAt(0,"OID_SUBP")));
            dtoSubproceso.setIndActualizaCuota(this.bigDecimalToLong(rs.getValueAt(0,"VAL_INDI_ACTU_CUOT")));
        }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerDatosSubprocesoSCS(Long oidPais, Long oidProceso, Integer supbroceso): Salida");
        return dtoSubproceso;
  
  }
  private DTOSubproceso obtenerDatosSubproceso (Long oidPais, String proceso, Integer supbroceso) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerDatosSubproceso (Long oidPais, String proceso, Integer supbroceso): Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT SUB.OID_SUBP, ");
		query.append("        SUB.VAL_INDI_ACTU_CUOT "); 
        query.append(" FROM CCC_SUBPR SUB, ");
		query.append("      CCC_PROCE PRO ");
        query.append(" WHERE SUB.CCPR_OID_PROC = PRO.OID_PROC ");
	    query.append("   AND PRO.PAIS_OID_PAIS = " + oidPais );
	    query.append("   AND PRO.COD_PROC = '" + proceso  + "' ");
		query.append("   AND SUB.COD_SUBP = '" + supbroceso  + "' ");
         
        rs = this.executeQuery(query.toString());
        DTOSubproceso dtoSubproceso = null; 
        if (rs!= null && ! rs.esVacio()){
            dtoSubproceso = new DTOSubproceso();
            dtoSubproceso.setOidSubproceso(this.bigDecimalToLong(rs.getValueAt(0,"OID_SUBP")));
            dtoSubproceso.setIndActualizaCuota(this.bigDecimalToLong(rs.getValueAt(0,"VAL_INDI_ACTU_CUOT")));
        }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerDatosSubproceso (Long oidPais, String proceso, Integer supbroceso): Salida");
        return dtoSubproceso;
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
   
  private ArrayList obtenerMarcasTipoAbono(Long oidPais, Long oidSubproceso, String indEntradaSalida) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMarcasTipoAbono(Long oidPais, Long oisSubproceso, String indEntradaSalida): Entrada ");        
      StringBuffer consulta = new StringBuffer();

      consulta.append(" SELECT U.OID_MARC_SITU, ");
      consulta.append("        M.TASP_OID_TIPO_ABON_SUBP");
      consulta.append(" FROM CCC_MARCA_SITUA U, ");
      consulta.append("      CCC_MARCA_TIPO_ABONO M, ");
      consulta.append("      CCC_TIPO_ABONO_SUBPR T ");
      consulta.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI ");
      consulta.append("   AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP ");
      consulta.append("   AND T.SUBP_OID_SUBP = " + oidSubproceso);
      consulta.append("   AND M.IND_ENTR_SALI LIKE '" + indEntradaSalida + "'");
      consulta.append("   AND U.PAIS_OID_PAIS = " + oidPais);

      RecordSet resultado = null;

      resultado = this.executeQuery(consulta.toString());
      ArrayList arrayDtoMarcas = new ArrayList();
      if (resultado != null && !resultado.esVacio()){
        int largoRS = resultado.getRowCount();
        for (int i = 0; i < largoRS; i++){
          DTOMarcasPorTipoAbono  dtoMarcasPorTipoAbono = new DTOMarcasPorTipoAbono();
          dtoMarcasPorTipoAbono.setOid(this.bigDecimalToLong(resultado.getValueAt(i,"OID_MARC_SITU")));
          dtoMarcasPorTipoAbono.setTipoAbono(this.bigDecimalToLong(resultado.getValueAt(i,"TASP_OID_TIPO_ABON_SUBP")));
          arrayDtoMarcas.add(dtoMarcasPorTipoAbono);
        }
      }
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMarcasTipoAbono(Long oidPais, Long oisSubproceso, String indEntradaSalida): Salida ");        
      return arrayDtoMarcas;
  }


  private ArrayList obtenerMarcasTipoAbonoDos(Long oidPais, Long oidSubproceso, String indEntradaSalida) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMarcasTipoAbonoDos(Long oidPais, Long oisSubproceso, String indEntradaSalida): Entrada ");        
      StringBuffer consulta = new StringBuffer();

      consulta.append(" SELECT U.OID_MARC_SITU, ");
      consulta.append("        M.TASP_OID_TIPO_ABON_SUBP, T.TCAB_OID_TCAB ");
      consulta.append(" FROM CCC_MARCA_SITUA U, ");
      consulta.append("      CCC_MARCA_TIPO_ABONO M, ");
      consulta.append("      CCC_TIPO_ABONO_SUBPR T ");
      consulta.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI ");
      consulta.append("   AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP ");
      consulta.append("   AND T.SUBP_OID_SUBP = " + oidSubproceso);
      consulta.append("   AND M.IND_ENTR_SALI LIKE '" + indEntradaSalida + "'");
      consulta.append("   AND U.PAIS_OID_PAIS = " + oidPais);

      RecordSet resultado = null;

      resultado = this.executeQuery(consulta.toString());
      ArrayList arrayDtoMarcas = new ArrayList();
      if (resultado != null && !resultado.esVacio()){
        int largoRS = resultado.getRowCount();
        for (int i = 0; i < largoRS; i++){
          DTOMarcasPorTipoAbono  dtoMarcasPorTipoAbono = new DTOMarcasPorTipoAbono();
          dtoMarcasPorTipoAbono.setOid(this.bigDecimalToLong(resultado.getValueAt(i,"OID_MARC_SITU")));
          //como bien dice el nombre, a este atributo se le setea el TIPO DE ABONO
          //Gacevedo (30/09/2006) Bloqueante de Validacion
          dtoMarcasPorTipoAbono.setTipoAbono(this.bigDecimalToLong(resultado.getValueAt(i,"TCAB_OID_TCAB")));
          dtoMarcasPorTipoAbono.setTipoAbonoSubproceso(this.bigDecimalToLong(resultado.getValueAt(i,"TASP_OID_TIPO_ABON_SUBP")));
          arrayDtoMarcas.add(dtoMarcasPorTipoAbono);
        }
      }
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMarcasTipoAbonoDos(Long oidPais, Long oisSubproceso, String indEntradaSalida): Salida ");        
      return arrayDtoMarcas;
  }
  
  
  
  private DTOMantenimientoTiposAbonoSubproceso obtenerTiposAbonoSubprocesoCContable(Long pais, Long oidSubproceso) throws MareException {        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerTiposAbonoSubprocesoCContable(Long pais, Long oidSubproceso): Entrada ");        

        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT T.CUCO_OID_CUEN_CONT, ");
        consulta.append("   	   T.TCAB_OID_TCAB, ");
        consulta.append("   	   T.OID_TIPO_ABON_SUBP  ");
        consulta.append(" FROM CCC_TIPO_ABONO_SUBPR T,	");
        consulta.append("      CCC_TIPO_CARGO_ABONO C	");
        consulta.append(" WHERE T.TCAB_OID_TCAB = C.OID_TIPO_CARG_ABON ");
        consulta.append("   AND T.SUBP_OID_SUBP = " + oidSubproceso);
        consulta.append("   AND C.PAIS_OID_PAIS = " + pais);
        
        RecordSet rs = null;

        rs = this.executeQuery(consulta.toString());
        DTOMantenimientoTiposAbonoSubproceso dtoMantenimientoTiposAbonoSubproceso = null;
        
        if (rs != null && !rs.esVacio()){
          dtoMantenimientoTiposAbonoSubproceso = new DTOMantenimientoTiposAbonoSubproceso();
          dtoMantenimientoTiposAbonoSubproceso.setOidTipoAbono(this.bigDecimalToLong(rs.getValueAt(0,"TCAB_OID_TCAB")));
          dtoMantenimientoTiposAbonoSubproceso.setOidCuentaContable(this.bigDecimalToLong(rs.getValueAt(0,"CUCO_OID_CUEN_CONT")));
          dtoMantenimientoTiposAbonoSubproceso.setOidTiposAbonoSubproceso(this.bigDecimalToLong(rs.getValueAt(0,"OID_TIPO_ABON_SUBP")));
        }

        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerTiposAbonoSubprocesoCContable(Long pais, Long oidSubproceso): Entrada ");        
        return dtoMantenimientoTiposAbonoSubproceso;
    }

    private String cerosIzq(String cadena1, int cantidad) {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cerosIzq(String cadena1, int cantidad): Entrada");
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
      
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cerosIzq(String cadena1, int cantidad): Salida");
        return cadena2.toString();
    }


  private MONCuentasCorrientesPerfLocalHome getMONCuentasCorrientesPerfLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuentasCorrientesPerfLocalHome)context.lookup("java:comp/env/MONCuentasCorrientesPerf");
  }

  private MONCuentasCorrientesPerfLocal getMONCuentasCorrientesPerfLocal() throws MareException
  {
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.getMONCuentasCorrientesPerfLocal(): Entrada");
    MONCuentasCorrientesPerfLocal salida = null;
    try
    {
      MONCuentasCorrientesPerfLocalHome home = this.getMONCuentasCorrientesPerfLocalHome();
      salida = home.create();  
    }catch (Exception e) {
      			UtilidadesLog.error("*** Error en getMONCuentasCorrientesLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.getMONCuentasCorrientesPerfLocal(): Salida");
    return salida;
  }  

  public Integer obtenerSecuenciaPais(DTOBelcorp dtoBelcorp) throws MareException {
    StringBuffer query = new StringBuffer();
    RecordSet rs = null;
    Integer secuencia = null;
    
    query.append(" SELECT PA.VAL_CONF_SECU_CCC FROM SEG_PAIS PA WHERE PA.OID_PAIS = "  + dtoBelcorp.getOidPais());

    rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()) {
        char confSecuenciaCC = rs.getValueAt(0,"VAL_CONF_SECU_CCC").toString().charAt(0);
        
        StringBuffer query2 = new StringBuffer();
        query2.append(" SELECT CSP.OID_SECU_PAIS, ");
        query2.append("        CSP.NUM_SECU ");
        query2.append(" FROM CCC_SECUE_PAIS CSP ");
        query2.append(" WHERE CSP.PAIS_OID_PAIS = " + dtoBelcorp.getOidPais()); 
       
        switch (confSecuenciaCC) {
            case 'U':
                query2.append(" AND CSP.NUM_ANIO IS NULL ");
                query2.append(" AND CSP.NUM_MES IS NULL ");
                break;
            case 'A':
                query2.append(" AND CSP.NUM_ANIO = TO_NUMBER(TO_CHAR(SYSDATE,'YY')) ");
                query2.append(" AND CSP.NUM_MES IS NULL ");
                break;
            case 'M':
                query2.append(" AND CSP.NUM_ANIO = TO_NUMBER(TO_CHAR(SYSDATE,'YY')) ");
                query2.append(" AND CSP.NUM_MES = TO_NUMBER(TO_CHAR(SYSDATE,'MM')) ");
                break;
            }
        query2.append(" FOR UPDATE");
        RecordSet rs2 = null;
        
        rs2 = this.executeQuery(query2.toString());
    
       if (rs2 != null && !rs2.esVacio()){
            Long oidSecuPais = this.bigDecimalToLong(rs2.getValueAt(0,"OID_SECU_PAIS"));
            secuencia = new Integer(this.bigDecimalToInteger(rs2.getValueAt(0,"NUM_SECU")).intValue() + 1);
            this.updateSecuenciaCC(oidSecuPais, secuencia);
       } else {
            secuencia = new Integer(1);
            this.insertarSecuenciaCC(secuencia, confSecuenciaCC, dtoBelcorp.getOidPais());
       }
    }
    return secuencia;
  }


  private void updateSecuenciaCC (Long oidSecuPais, Integer secuencia) throws MareException{
      StringBuffer query = new StringBuffer();
      
      query.append("UPDATE CCC_SECUE_PAIS SET NUM_SECU = " + secuencia);
      query.append(" WHERE OID_SECU_PAIS = " + oidSecuPais);
      
      try {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        bs.dbService.executeUpdate(query.toString());
      } catch (Exception e){        
        UtilidadesLog.error("updateSecuenciaCC: Exception", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }      
  }
  
  private void insertarSecuenciaCC (Integer secuencia, char confSecuenciaCC, Long oidPais) throws MareException{
      StringBuffer query = new StringBuffer();
      
      query.append("INSERT INTO CCC_SECUE_PAIS (OID_SECU_PAIS, PAIS_OID_PAIS, NUM_SECU");
      switch (confSecuenciaCC) {
            case 'A':
                query.append(", NUM_ANIO");
                break;
            case 'M':
                query.append(", NUM_ANIO, NUM_MES");
                break;
      }
      query.append(" ) VALUES (CCC_SEPA_SEQ.NEXTVAL," + oidPais + "," + secuencia);
      switch (confSecuenciaCC) {
            case 'A':
                query.append(", TO_NUMBER(TO_CHAR(SYSDATE,'YY'))");
                break;
            case 'M':
                query.append(", TO_NUMBER(TO_CHAR(SYSDATE,'YY')), TO_NUMBER(TO_CHAR(SYSDATE,'MM'))");
                break;
      }
      query.append(")");
      
      try {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        bs.dbService.executeUpdate(query.toString());        
      } catch (Exception e){        
        UtilidadesLog.error("insertarSecuenciaCC: Exception", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }      
  }
  
  private Long insertarCabeceraCargoAbono(Integer numero, Long oidPais, Long oidEmpresa, String usuario, Integer loteFacturacion,
                                        java.util.Date fechaValor, java.util.Date fechaDocumento) throws MareException{
      StringBuffer query = new StringBuffer();                        
      RecordSet rs = null;
      Long oidCabecera = null;
      query.append(" SELECT CCC_CCAD_SEQ.NEXTVAL FROM DUAL");                                  
      
      rs = this.executeQuery(query.toString());
      
      if(rs != null && !rs.esVacio()){
          oidCabecera = this.bigDecimalToLong(rs.getValueAt(0,0));
          StringBuffer query2 = new StringBuffer();
          
          // DBLG700000038 - gPineda - 17/10/2006
          // Se agrega el campo VAL_NUME_LOTE_FACT
          query2.append("INSERT INTO CCC_CABEC_CARGA_ABONO_DIREC (OID_CABE_CARG, NUM_CABE, ANIO, VAL_PERI_MES, PAIS_OID_PAIS, SOCI_OID_SOCI, ");
          query2.append(" FEC_VALO, FEC_DOCU, COD_USUA, CCPR_OID_PROC, VAL_NUME_LOTE_FACT, VAL_OBSE) VALUES (" + oidCabecera + "," + numero + ", TO_CHAR(SYSDATE,'YY'), TO_CHAR(SYSDATE,'MM')");
          query2.append("," + oidPais + "," + oidEmpresa + ", ");
          //<inicio>modificado por incidencia SiCC-20070262 (Sapaza) - 23/05/2007, las fechas se graban como se recibe de Facturacion
          query2.append(" to_date( '" + new java.sql.Date(fechaValor.getTime()) + "', 'YYYY-MM-DD'), ");
          query2.append(" to_date( '" + new java.sql.Date(fechaDocumento.getTime()) + "', 'YYYY-MM-DD'), ");
          query2.append("'" + usuario + "', (SELECT CP.OID_PROC FROM CCC_PROCE CP WHERE CP.PAIS_OID_PAIS = " + oidPais + " AND CP.COD_PROC = 'CCC001'), " );
          //<fin>modificado por incidencia SiCC-20070262 (Sapaza)
          query2.append(loteFacturacion.toString() +", '");
          query2.append(loteFacturacion.toString() +"') ");//este va en las observaciones
          
          try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            bs.dbService.executeUpdate(query2.toString());        
          } catch (Exception e){        
            UtilidadesLog.error("insertarCabeceraCargoAbono: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }      
      }
    return  oidCabecera;
  }

 private Long agregarMovimientosCuentasCorrientes(DTOMovimientoCuentaCompleto movimientoCtaCte, StringBuffer movimientosCuentasCorrientes) throws MareException {        
        Long oidMovimientoCtaCte = new Long(SecuenciadorOID.obtenerSiguienteValor("CCC_MVCC_SEQ").longValue());
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();

        query.append(" INSERT INTO CCC_MOVIM_CUENT_CORRI (");
        // campos obligatorios
        query.append(" oid_movi_cc, ");
        values.append(oidMovimientoCtaCte).append(",");
        query.append(" soci_oid_soci, ");
        values.append(movimientoCtaCte.getEmpresa()).append(",");
        query.append(" masi_oid_marc_situ, ");
        values.append(movimientoCtaCte.getMarcaSituacion()).append(",");
		query.append(" perd_oid_peri, ");
        values.append(movimientoCtaCte.getPeriodoDesde()).append(",");
		query.append(" tcab_oid_tcab_ulti, ");
        values.append(movimientoCtaCte.getTipoAbonoUltimo()).append(",");
        query.append(" tcab_oid_tcab_crea, ");
        values.append(movimientoCtaCte.getTipoAbonoCreacion()).append(",");
        query.append(" sbac_oid_sbac, ");
        values.append(movimientoCtaCte.getSubacceso()).append(",");
        query.append(" subp_oid_subp_ulti, ");
        values.append(movimientoCtaCte.getSubprocesoUltimo()).append(",");
        query.append(" subp_oid_subp_crea, ");
        values.append(movimientoCtaCte.getSubprocesoCreacion()).append(",");
        query.append(" cuco_oid_cuen_cont_orig, ");
        values.append(movimientoCtaCte.getCuentaOrigen()).append(",");
        query.append(" clie_oid_clie, ");
        values.append(movimientoCtaCte.getOidCliente()).append(",");
        query.append(" val_docu_anio, ");
        values.append("'").append(movimientoCtaCte.getDocumentoAnyo()).append("'").append(",");
        query.append(" val_docu_nume, ");
        values.append("'").append(movimientoCtaCte.getDocumentoNumero()).append("'").append(",");
        query.append(" val_ejer_cuot, ");
        values.append("'").append(movimientoCtaCte.getEjercicioCuota()).append("'").append(",");
        query.append(" fec_docu, ");
        values.append(" to_date( '" + new java.sql.Date(movimientoCtaCte.getFechaDocumento().getTime()) + "', 'YYYY-MM-DD'), ");           
        query.append(" fec_ulti_movi, ");
        values.append(" to_date( '" + sdf.format(movimientoCtaCte.getFechaUltimoMovimiento()) + "', 'DD/MM/YYYY HH24:MI:SS'), ");           
        query.append(" fec_venc, ");
        values.append(" to_date( '" + new java.sql.Date(movimientoCtaCte.getFechaVencimiento().getTime()) + "', 'YYYY-MM-DD'), ");           
        query.append(" imp_movi, ");
        values.append(movimientoCtaCte.getImporte()).append(",");
        query.append(" imp_paga, ");
        values.append(movimientoCtaCte.getImportePagado()).append(",");
        query.append(" imp_pend, ");
        values.append(movimientoCtaCte.getImportePendiente()).append(",");
        query.append(" num_iden_cuot, ");
        values.append(movimientoCtaCte.getNumeroIdentificadorCuota()).append(",");
        query.append(" num_orde_cuot, ");
        values.append(movimientoCtaCte.getNumeroOrdenCuota()).append(",");
        query.append(" ztad_oid_terr_admi, ");
        values.append(movimientoCtaCte.getTerritorioAdministrativo()).append(",");
        query.append(" ticl_oid_tipo_clie, ");
        values.append(movimientoCtaCte.getTipoCliente()).append(",");
        query.append(" ind_tipo_camb, ");
        values.append(movimientoCtaCte.getTipoCambio()).append(",");
        query.append(" cod_usua, ");
        values.append("'").append(movimientoCtaCte.getUsuario()).append("'").append(",");
        query.append(" sbti_oid_subt_clie, ");
        values.append(movimientoCtaCte.getOidSubtipoCliente()).append(",");
        query.append(" zsgv_oid_subg_vent, ");
        values.append(movimientoCtaCte.getOidSugerenciaVenta()).append(",");
        query.append(" zscc_oid_secc, ");
        values.append(movimientoCtaCte.getOidSeccion()).append(",");
        query.append(" zorg_oid_regi, ");
        values.append(movimientoCtaCte.getOidRegion()).append(",");
        query.append(" imp_movi_cuen ");
        values.append(movimientoCtaCte.getImporteMovimiento());
        // campos No Obligatorios        
        if (movimientoCtaCte.getDivisa() != null) {
            query.append(", mone_oid_mone");
            values.append(", ").append(movimientoCtaCte.getDivisa());
        }
		if (movimientoCtaCte.getCuentaCuota() != null) {
            query.append(", cuco_oid_cuen_cont_cuot");
            values.append(", ").append(movimientoCtaCte.getCuentaCuota());
		}
		if (movimientoCtaCte.getDocumentoMesSerie() != null) {
            query.append(", val_docu_mes_seri");
            //values.append(", ").append("'").append(movimientoCtaCte.getDocumentoMesSerie()).append("'");
            values.append(", TO_CHAR(SYSDATE,'MM') ");
		}
		if (movimientoCtaCte.getFechaContabilizacion() != null) {
            query.append(", fec_conta");
            values.append(", ").append(" to_date( '" + new java.sql.Date(movimientoCtaCte.getFechaContabilizacion().getTime()) + "', 'YYYY-MM-DD') ");           
        }
		if (movimientoCtaCte.getFechaValor() != null) {
            query.append(", fec_valo");
            values.append(", ").append(" to_date( '" + new java.sql.Date(movimientoCtaCte.getFechaValor().getTime()) + "', 'YYYY-MM-DD') ");           
        }
		if (movimientoCtaCte.getImporteDivisa() != null) {
            query.append(", imp_divi");
            values.append(", ").append(movimientoCtaCte.getImporteDivisa());
		}
		if (movimientoCtaCte.getImportePagadoDivisa() != null) {
            query.append(", imp_paga_divi");
            values.append(", ").append(movimientoCtaCte.getImportePagadoDivisa());
		}
		if (movimientoCtaCte.getIndicaDescuentoRecargo() != null) {
            query.append(", ind_dto_carg_apli");
            if (movimientoCtaCte.getIndicaDescuentoRecargo().booleanValue() ) {
                values.append(",").append("1");
            } else {
                values.append(",").append("0");
            }
		}
		if (movimientoCtaCte.getNumeroLoteContabilizacion() != null) {
            query.append(", val_nume_lote_cont");
            values.append(", ").append("'").append(movimientoCtaCte.getNumeroLoteContabilizacion()).append("'");
		}
		if (movimientoCtaCte.getObservaciones() != null) {
            query.append(", val_obse");
            values.append(", ").append("'").append(movimientoCtaCte.getObservaciones()).append("'");
		}
		if (movimientoCtaCte.getReferenciaNumeroDocumentoExterno() != null) {
            query.append(", val_refe_nume_docu_exte");
            values.append(", ").append("'").append(movimientoCtaCte.getReferenciaNumeroDocumentoExterno()).append("'");
		}
		if (movimientoCtaCte.getUltimoDocumentoAnyo() != null) {
            query.append(", val_ulti_docu_anio");
            values.append(", ").append("'").append(movimientoCtaCte.getUltimoDocumentoAnyo()).append("'");
		}
		if (movimientoCtaCte.getUltimoDocumentoMesSerie() != null) {
            query.append(", val_ulti_docu_mes_seri");
            values.append(", ").append("'").append(movimientoCtaCte.getUltimoDocumentoMesSerie()).append("'");
		}
		if (movimientoCtaCte.getUltimoDocumentoNumero() != null) {
            query.append(", val_ulti_docu_nume");
            values.append(", ").append("'").append(movimientoCtaCte.getUltimoDocumentoNumero()).append("'");
		}
		if (movimientoCtaCte.getUltimoNumeroHistoria() != null) {
            query.append(", val_ulti_nume_hist");
            values.append(", ").append("'").append(movimientoCtaCte.getUltimoNumeroHistoria()).append("'");
		}
		if (movimientoCtaCte.getMedioPago() != null) {
            query.append(", mpab_oid_medi_pago");
            values.append(", ").append(movimientoCtaCte.getMedioPago());
		}
		if (movimientoCtaCte.getMarca() != null) {
            query.append(", marc_oid_marc");
            values.append(", ").append(movimientoCtaCte.getMarca());
		}
		if (movimientoCtaCte.getNumeroLoteFactu() != null) {
            query.append(", num_lote_fact");
            values.append(", ").append(movimientoCtaCte.getNumeroLoteFactu());
		}
		if (movimientoCtaCte.getImportePago() != null) {
            query.append(", imp_pago");
            values.append(", ").append(movimientoCtaCte.getImportePago());
		}
		if (movimientoCtaCte.getImportePagoDivisa() != null) {
            query.append(", imp_pago_divi");
            values.append(", ").append(movimientoCtaCte.getImportePagoDivisa());
		} else {
            query.append(", imp_pago_divi");
            values.append(", ").append(new Double(0));
        }
		if (movimientoCtaCte.getImporteMovimientoDivisa() != null) {
            query.append(", imp_movi_divi");
            values.append(", ").append(movimientoCtaCte.getImporteMovimientoDivisa());
		}
		if (movimientoCtaCte.getTipoPeriodoDesde() != null) {
            query.append(", tipe_oid_tipo_peri");
            values.append(", ").append(movimientoCtaCte.getTipoPeriodoDesde());
		}
		if (movimientoCtaCte.getOidTipoDocumentoLegal() != null) {
            query.append(", tido_oid_tipo_docu");
            values.append(", ").append(movimientoCtaCte.getOidTipoDocumentoLegal());
		}
		if (movimientoCtaCte.getOidTipoSolicitud() != null) {
            query.append(", tspa_oid_tipo_soli_pais");
            values.append(", ").append(movimientoCtaCte.getOidTipoSolicitud());
		}
		if (movimientoCtaCte.getOidPedidoSolicitudCab() != null) {
            query.append(", soca_oid_soli_cabe");
            values.append(", ").append(movimientoCtaCte.getOidPedidoSolicitudCab());
		}
        query.append(") VALUES (");
        query.append(values);
        query.append(");");
        
        movimientosCuentasCorrientes.append(query.toString());
        
        return oidMovimientoCtaCte;        
    }


 private void agregarDetalleCargosAbonosDirectos(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto, 
        StringBuffer detalleCargosAbonosDirectos, Long oidMovCC, Long numeroLineaDetalle, 
        Long oidCabCargoAbono) throws MareException {
        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.agregarDetalleCargosAbonosDirectos(): Entrada");
        
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();

        query.append(" INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
      
        query.append(" OID_DETA_CARG_ABON_DIRE, ");
        values.append("CCC_DCAD_SEQ.NEXTVAL,");
        query.append(" CCAD_OID_CABE_CARG, ");
        values.append(oidCabCargoAbono).append(",");
        query.append(" NUM_LINE, ");
        values.append(" NULL, ");
        
        //values.append(this.ultimoNumeroLineaEnDetalleMas(oidCabCargoAbono)).append(",");
        
        query.append(" COD_USUA, ");
        values.append("'").append(detalleCargoAbonoDirecto.getUsuario()).append("'").append(", ");
        query.append(" SOCI_OID_SOCI, ");
        values.append(detalleCargoAbonoDirecto.getEmpresa()).append(",");
        query.append(" TASP_OID_TIPO_ABON_SUBP ");
        values.append(detalleCargoAbonoDirecto.getTipoAbonoSubprocesoUltimo());
        //campos no obligatorios
        if (detalleCargoAbonoDirecto.getOidCliente() != null) {
            query.append(", CLIE_OID_CLIE ");   // consultora
            values.append(", ").append(detalleCargoAbonoDirecto.getOidCliente());
        }
        query.append(", NUM_HIST_GENE ");
        values.append(", ").append(new Integer(0));
        query.append(", FEC_MOVI");
        //modificado por incidencia SiCC-20070262 (Sapaza) - 23/05/2007, las fecha se graban como se recibe de Facturacion
        values.append(", ").append(" to_date( '" + new java.sql.Date(detalleCargoAbonoDirecto.getFechaDocumento().getTime()) + "', 'YYYY-MM-DD') ");           
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
        if (oidMovCC != null) {
            query.append(", MVCC_OID_MOVI_CC ");    // movimientoCtaCte
            values.append(", ").append(oidMovCC);
        }
        query.append(", CCBA_OID_CUEN_CORR_BANC ");    // cuentaCorriente
        
        if (detalleCargoAbonoDirecto.getOidCtaCteBria()!=null)
            values.append(", ").append(detalleCargoAbonoDirecto.getOidCtaCteBria());
        else
            values.append(", ").append("null");
            
        query.append(", FEC_PAGO_BANC ");    // fechaPagoEnBancos
        values.append(", ").append("null");
        query.append(") VALUES (");
        query.append(values);
        query.append(");");
        // agregamos el detalle cargo abono directo
        detalleCargosAbonosDirectos.append(query.toString());
        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.agregarDetalleCargosAbonosDirectos(): Salida");
 }


 private void grabarMovCCyDetCargoAbono(StringBuffer query) throws MareException {
   BelcorpService bs = BelcorpService.getInstance();   
    try {
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
    } catch (Exception e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error en grabarMovCCyDetCargoAbono ",e);
        throw new MareException(e,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
 }
   public void cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos, String tipoDeuda, 
                                          Long oidCabecera, Integer numeroIdentificacion) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos): Entrada");
		
        UtilidadesLog.debug("cantidad de cuotas, que entran: " + dtos.length);
        long inicio = System.currentTimeMillis();                
        String proceso = "CCC002";
        Integer subproceso = new Integer(2);
        Long pais = dtos[0].getOidPais();
        Long indActualizaCuotaSN = null; 
        String[] fechas = generarFechas();
        DTODatosAbonoSubprocesoMarcaSituacion dtoDatos = new DTODatosAbonoSubprocesoMarcaSituacion();
        DTOSubproceso dtoSubproceso = new DTOSubproceso();
        String usuario = null;//ctx.getCallerPrincipal().getName();
        if(dtos[0].getUsuario()!=null){
           usuario = dtos[0].getUsuario();
        }else{
           usuario = ctx.getCallerPrincipal().getName();
        }
        
        //UtilidadesLog.debug("- GA - cancelacionAutomaticaDeuda-Usuario: "+usuario);
        inicio = System.currentTimeMillis();
        DAOCCC daoCCC = new DAOCCC(usuario);
        DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = daoCCC.obtenerAsignacionSubprocesosTiposSolicitudAplicacion(pais, dtos[0].getOidTipoSolicitud());
        if (dtoAbonSubMarSitu.getOid() != null){ //encontro data en la tabla: CCC_ASIGN_SUBPR_TIPO_SOLIC utilizo oid de proc. de aplicacion de cuotas y oid de subproceso
                                        //de aplicacion de cuotas y la cuenta corr. bria.
            dtoSubproceso = this.obtenerDatosSubprocesoSCS(pais, dtoAbonSubMarSitu.getOidProcesoAplicacionCtas(), 
                                                                          dtoAbonSubMarSitu.getOidSubprocesoAplicacionCtas());
        }else{    //no hay nada para el oid de tipo solicitud, recupero todo de la "forma general"                                
            dtoSubproceso = this.obtenerDatosSubproceso(pais, proceso, subproceso);
        }
        //UtilidadesLog.warn("- GA - Obtencion del subproceso en Cancelacion "+(System.currentTimeMillis()-inicio));
        if (dtoSubproceso != null){
            indActualizaCuotaSN = dtoSubproceso.getIndActualizaCuota();
            //oidSubproceso = dtoSubproceso.getOidSubproceso();
            dtoDatos.setOidSubProceso(dtoSubproceso.getOidSubproceso());
        }
        //DAOCargosAbonos daoCargosAbonos = new DAOCargosAbonos(usuario);
		
        UtilidadesLog.debug("oidSubproceso = "+dtoDatos.getOidSubProceso());

        inicio = System.currentTimeMillis();
        DTOMantenimientoTiposAbonoSubproceso dtoMantenimientoTiposAbonoSubproceso = new DTOMantenimientoTiposAbonoSubproceso();
        dtoMantenimientoTiposAbonoSubproceso = (DTOMantenimientoTiposAbonoSubproceso)this.obtenerTiposAbonoSubprocesoCContable(pais, dtoDatos.getOidSubProceso());
        
        if (dtoMantenimientoTiposAbonoSubproceso!= null){
          dtoDatos.setOidCuentaContable(dtoMantenimientoTiposAbonoSubproceso.getOidCuentaContable());
          dtoDatos.setOidMarcaSituacionEntrada(dtoMantenimientoTiposAbonoSubproceso.getOidTipoAbono());
          dtoDatos.setOidTipoAbonoSubProceso(dtoMantenimientoTiposAbonoSubproceso.getOidTiposAbonoSubproceso());
        }       
        ArrayList marcasEntrada = new ArrayList();
        marcasEntrada = this.obtenerMarcasTipoAbono(pais, dtoDatos.getOidSubProceso(), new String("E"));
        int lonMarcasEntrada = marcasEntrada.size();
        Long[] oidsMarcasEntrada = new Long[lonMarcasEntrada];
        for (int f = 0; f < lonMarcasEntrada; f++) {    
            DTOMarcasPorTipoAbono dtoMarcasPorTipoAbono = (DTOMarcasPorTipoAbono)marcasEntrada.get(f);
            oidsMarcasEntrada[f] = dtoMarcasPorTipoAbono.getOid();
        }        

        ArrayList marcaSalida = new ArrayList();
        marcaSalida = this.obtenerMarcasTipoAbono(pais, dtoDatos.getOidSubProceso(), new String("S"));

        Byte indicadorEmisionVto = this.obtenerIndEmisionVtoPais(pais);

        DTOMarcasPorTipoAbono dtoMarcaSalida = (DTOMarcasPorTipoAbono)marcaSalida.get(0);
        //Long lngMarcaSalida = null;
        if (dtoMarcaSalida != null){
           //lngMarcaSalida =  dtoMarcaSalida.getOid();
           dtoDatos.setOidMarcaSituacionSalida(dtoMarcaSalida.getOid());
        }
        //UtilidadesLog.warn("- GA - Obtencion de marcas en Cancelacion "+(System.currentTimeMillis()-inicio));
        
        inicio = System.currentTimeMillis();
        ArrayList arrayOidCabecera = new ArrayList();
        for (int i = 0; i < dtos.length; i++) {
            arrayOidCabecera.add(dtos[i].getOidPedidoSolicitudCab());            
        }
        
        //UtilidadesLog.debug("- GA - DTODatos: "+dtoDatos.toString());        
        HashMap hashSolCabecera = new HashMap();
        hashSolCabecera = this.obtenerDocumentosReferencia(arrayOidCabecera);
        //UtilidadesLog.warn("- GA - Obtencion de los oids documentos de referencia en Cancelacion "+(System.currentTimeMillis()-inicio));
        StringBuffer buffSalida = new StringBuffer();
        
        /* Como se ha modificado el caso de uso generar cuenta corriente para que 
         * envie los consolidados por grupo teniendo en cuenta el oidCliente,
         * este caso de uso se modifica a fin de tratar todas las cuotas que llegan
         * como una sola, ya que se aplicar� a la deuda de una sola vez. A excepcion
         * de las cuotas de pago segun documento de referencia, que siguen funcionando
         * exactamente igual.*/
        HelperHistorial helperHistorial = new HelperHistorial();
        int numeroLinea = 1;
        
        for (int i = 0; i < dtos.length; i++) { // for (1)
            dtos[i].setImporte(Double.valueOf(new BigDecimal (dtos[i].getImporte().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));
            dtos[i].setImportePagado(Double.valueOf(new BigDecimal (dtos[i].getImportePagado().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));
            dtos[i].setImportePendiente(Double.valueOf(new BigDecimal (dtos[i].getImportePendiente().doubleValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()));

            int longitudDoc = 0;
            Long oidDocumentoReferencia = (Long)hashSolCabecera.get(dtos[i].getOidPedidoSolicitudCab());

            if ((oidDocumentoReferencia != null) && (tipoDeuda.equals(String.valueOf('N')))){ // Si (2) 
             UtilidadesLog.debug("*** Se cancelan cuotas por documento de referencia ***"); 
             ArrayList arrayDtosCancelar = new ArrayList();
            
            inicio = System.currentTimeMillis();
            DTOIdentificadoresDeCuota identificadorCuota =  HelperCancelacion.obtenerDatosDocumentoReferencia(oidDocumentoReferencia);
            //UtilidadesLog.warn("- GA - Obtencion de los documentos de referencia en Cancelacion "+(System.currentTimeMillis()-inicio));
            
            if(identificadorCuota!=null){
               dtos[i].setEjercicioCuota(identificadorCuota.getEjercicioCuota());
               dtos[i].setNumeroIdentificadorCuota(new Integer(identificadorCuota.getIdentificadorEjercicioCuota()));
            }
            /* *************************************************/
            inicio = System.currentTimeMillis();
            arrayDtosCancelar = this.obtenerMovCCSolicitudPedido(dtos[i].getOidPais(), //LONG
                    dtos[i].getOidCliente(),
                    dtos[i].getEmpresa(), 													
                    dtos[i].getEjercicioCuota(), 
                    dtos[i].getNumeroIdentificadorCuota(), 
                    null,
                    oidsMarcasEntrada);
  
            //UtilidadesLog.warn("- GA - Obtencion de los pedidos en Cancelacion "+(System.currentTimeMillis()-inicio));
            longitudDoc = arrayDtosCancelar.size();

            inicio = System.currentTimeMillis();
            for (int j = 0; j < longitudDoc; j++) {//for (3) 
                DTOMovimientoCuentaCompleto dtoCancelar = (DTOMovimientoCuentaCompleto)arrayDtosCancelar.get(j);
                //obtengo la historia de los movimientos que voy a procesar
                buffSalida.append(helperHistorial.obtenerHistoriaCuentasCorrientes(dtos[i].getOid()));
                buffSalida.append(helperHistorial.obtenerHistoriaCuentasCorrientes(dtoCancelar.getOid()));

                dtoCancelar.setUsuario(usuario);
                dtoCancelar.setOidDocumentoReferencia(dtos[i].getOidDocumentoReferencia());
                //el metodo que se invoca debajo, actualiza los dtos con el calculo de importes y demases.
                aplicarSaldos(dtos[i], dtoCancelar, dtoDatos, indActualizaCuotaSN);
                dtoCancelar.setUltimoDocumentoNumero(numeroIdentificacion);
                dtoCancelar.setDocumentoAnyo(fechas[1]);
                dtoCancelar.setDocumentoMesSerie(fechas[0]);
                dtos[i].setUltimoDocumentoMesSerie(fechas[0]);
                dtos[i].setUltimoDocumentoAnyo(fechas[1]);
                dtos[i].setUltimoDocumentoNumero(numeroIdentificacion);
                dtoCancelar.setCuentaCuota(dtoDatos.getOidCuentaContable());
                if(dtos[i].getCuentaCuota()!=dtoDatos.getOidCuentaContable()){
                 dtos[i].setCuentaCuota(dtoDatos.getOidCuentaContable());
                 dtos[i].setOidCuotaNueva(dtoDatos.getOidCuentaContable());
                 dtos[i].setOidCargoAbono(oidCabecera);
                }
                buffSalida.append(this.generarStringUpdateMCC(dtos[i]).toString());
                buffSalida.append(this.generarStringUpdateMCC(dtoCancelar).toString());
                dtoCancelar.setOidCargoAbono(oidCabecera);
                numeroLinea+=1;
                dtoCancelar.setNumeroLineaDetalleCargoAbono(new Integer(numeroLinea));
                buffSalida.append(agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(dtoCancelar, numeroLinea, dtoDatos.getOidCuentaContable(), usuario).toString());
                numeroLinea+=1;
                dtos[i].setNumeroLineaDetalleCargoAbono(new Integer(numeroLinea));
                buffSalida.append(agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(dtos[i], numeroLinea, dtoDatos.getOidCuentaContable(), usuario).toString());
                buffSalida.append(actualizarCuenta(dtoCancelar,dtoCancelar));
                ////sbuchelli insertando en cargo abono ssicc
                this.insertarCargoAbono(dtos[i],dtoDatos.getOidSubProceso(),dtoCancelar,usuario);
                if(new BigDecimal(dtos[i].getImportePendiente().doubleValue()).
                    abs().setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() ==0D){
                   break;
                }
            } // fin del for (3)
            //UtilidadesLog.warn("- GA - Primer armado de updates en Cancelacion "+(System.currentTimeMillis()-inicio));
            if(buffSalida.length()>0){
               //si se aplicaron por documento de referencia, actualizamos antes de
               //la siguiente consulta.
               this.grabarDetCargoAbono(buffSalida);
               buffSalida = new StringBuffer();                
            }
           }// fin del Si (2) 
       }//fin del for 1

       //aplicadas las cuotas de cancelacion por documento de referencia
       //se calcula el saldo total a aplicar y se aplica contra toda la
       //deuda del cliente.
        
        UtilidadesLog.debug("- GA - Aplicando cancelacion contra deuda historica del cliente");
        
        //se comprueba que queden movimientos bancarios por cancelar.
        boolean sigoAplicando = false;
        
        for(int i = 0; i < dtos.length; i++){
           if(new BigDecimal(dtos[i].getImportePendiente().doubleValue()).
                  setScale(2,BigDecimal.ROUND_HALF_UP).abs().doubleValue()!=0D){
              sigoAplicando = true;
              UtilidadesLog.debug("- GA - Hay saldo para aplicar, Continuo");
              break;
           }
        }
        if(sigoAplicando){
         inicio = System.currentTimeMillis();
         ArrayList arrayDtosCancelarAntiguos = this.obtenerMovCCIndicadorEmisionVto(indicadorEmisionVto.toString(), //STRING
                 dtos[0].getOidPais(), //LONG
                 dtos[0].getOidCliente(), //LONG
                 dtos[0].getEmpresa(), //LONG
                 dtos[0].getOidMoneda(), //LONG
                 oidsMarcasEntrada,
                 tipoDeuda);
                 
                 
         //UtilidadesLog.warn("- GA - indicador documentos por vencimiento en Cancelacion "+(System.currentTimeMillis()-inicio));
               int longitudAntiguos =  arrayDtosCancelarAntiguos.size();
               UtilidadesLog.debug("- GA - Encontre deuda: "+longitudAntiguos);
               UtilidadesLog.debug(" *** Se cancelan deudas por antiguedad *** ");
        
        if(longitudAntiguos > 0){
        for(int i = 0; i < dtos.length; i++){
            //a partir de aqui, se implementa el cambio. Pasan 2 cosas, todas las cuotas del cliente aplican contra
            //toda la deuda del mismo y las cuotas de cancelacion deben ordenarse por fecha
           if(dtos[i].getImportePendiente().doubleValue()!=0){
            inicio = System.currentTimeMillis();
            for (int k = 0; k < longitudAntiguos; k++) { //(4)
                DTOMovimientoCuentaCompleto dtoCancelarAntiguos = (DTOMovimientoCuentaCompleto)arrayDtosCancelarAntiguos.get(k);
                if(dtoCancelarAntiguos.getImportePendiente().doubleValue()!=0){
                   aplicarSaldos(dtos[i], dtoCancelarAntiguos, dtoDatos, indActualizaCuotaSN);
                   dtos[i].setUltimoDocumentoMesSerie(fechas[0]);
                   dtos[i].setUltimoDocumentoAnyo(fechas[1]);
                   dtos[i].setUltimoDocumentoNumero(numeroIdentificacion);
                   dtoCancelarAntiguos.setUltimoDocumentoNumero(numeroIdentificacion);
                   dtoCancelarAntiguos.setDocumentoAnyo(fechas[1]);
                   dtoCancelarAntiguos.setDocumentoMesSerie(fechas[0]);
                   dtoCancelarAntiguos.setOidCtaCteBria(dtoAbonSubMarSitu.getOidCtaCteBancaria());  
                   dtoCancelarAntiguos.setUsuario(usuario);
                   if(dtos[i].getCuentaCuota()!=dtoDatos.getOidCuentaContable()){
                     dtos[i].setCuentaCuota(dtoDatos.getOidCuentaContable());
                     dtos[i].setOidCuotaNueva(dtoDatos.getOidCuentaContable());
                     dtos[i].setOidCargoAbono(oidCabecera);
                   }
                   dtoCancelarAntiguos.setOidCargoAbono(oidCabecera);
                   buffSalida.append(helperHistorial.obtenerHistoriaCuentasCorrientes(dtoCancelarAntiguos.getOid()));
                   buffSalida.append(this.generarStringUpdateMCC(dtoCancelarAntiguos).toString());
                   buffSalida.append(helperHistorial.obtenerHistoriaCuentasCorrientes(dtos[i].getOid()));
                   buffSalida.append(this.generarStringUpdateMCC(dtos[i]).toString());
                   numeroLinea+=1;
                   dtoCancelarAntiguos.setNumeroLineaDetalleCargoAbono(new Integer(numeroLinea));
                   buffSalida.append(agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(dtoCancelarAntiguos, numeroLinea, dtoDatos.getOidCuentaContable(), usuario).toString());
                   numeroLinea+=1;
                   dtos[i].setNumeroLineaDetalleCargoAbono(new Integer(numeroLinea));
                   buffSalida.append(agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(dtos[i], numeroLinea, dtoDatos.getOidCuentaContable(), usuario).toString());                                
                   buffSalida.append(actualizarCuenta(dtoCancelarAntiguos,dtoCancelarAntiguos));
                   ////sbuchelli insertando en cargo abono ssicc
                   this.insertarCargoAbono(dtos[i],dtoDatos.getOidSubProceso(),dtoCancelarAntiguos,usuario);
                   
                   if(new BigDecimal(dtos[i].getImportePendiente().doubleValue()).
                           setScale(2,BigDecimal.ROUND_HALF_UP).abs().doubleValue()==0D){
                      break;
                   }
               }
              } //fin del for (4)
              //UtilidadesLog.warn("- GA - Segundo armado de querys en Cancelacion "+(System.currentTimeMillis()-inicio));
           }// fin del for (1) 
         } 
        }
        }
        this.grabarDetCargoAbono(buffSalida);
        //UtilidadesLog.warn("- GA - Ultima grabacion en Cancelacion "+(System.currentTimeMillis()-inicio));
        //UtilidadesLog.warn("- GA - Tiempo total de cancelacion "+(System.currentTimeMillis()-tiempoMetodo));
        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cancelacionAutomaticaDeuda(DTOMovimientoCuentaCompleto[] dtos): Salida");
   }
 
   private String[] generarFechas() throws MareException{
      
      if(mesStatico==null || anioStatico==null){
         try{
           Timestamp actual = new Timestamp(System.currentTimeMillis());
           Date actualDate = new Date(actual.getTime());
           anioStatico = UtilidadesFecha.convertirAString(actualDate,"yy");		
           mesStatico = UtilidadesFecha.convertirAString(actualDate,"MM");
         }catch(ParseException e){throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_FORMATO_FECHA));
         }
      }
      return new String[]{mesStatico,anioStatico};
   }
 
 
   private void aplicarSaldos(DTOMovimientoCuentaCompleto cuotaCancelacion, 
                              DTOMovimientoCuentaCompleto dtoCancelar, 
                              DTODatosAbonoSubprocesoMarcaSituacion dtoDatos,
                              Long indActualizaCuotaSN){
    //este metodo aplica la cancelacion observando el signo de los importes.
    //es un metodo que solo sirve para hacer mas legible el codigo.
    if(Math.abs(dtoCancelar.getImportePendiente().doubleValue()) <= Math.abs(cuotaCancelacion.getImportePendiente().doubleValue()) ){
       dtoCancelar.setImporteMovimiento(new BigDecimal(dtoCancelar.getImportePendiente().doubleValue()));
       dtoCancelar.setImportePendiente(new Double("0"));
       dtoCancelar.setImportePagado(dtoCancelar.getImporte());
       //es el importe de movimiento de la cuota cancelada cambiada de signo
       cuotaCancelacion.setImporteMovimiento(new BigDecimal(dtoCancelar.getImporteMovimiento().doubleValue()*-1).setScale(2, BigDecimal.ROUND_HALF_UP));
       //suma algebraica
       cuotaCancelacion.setImportePendiente(new Double(new BigDecimal(cuotaCancelacion.getImportePendiente().doubleValue()+
                                                            dtoCancelar.getImporteMovimiento().doubleValue()).
                                                                setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
       //acumulado de los pagos realizados, es decir, pagado anterior + movimiento actual
       cuotaCancelacion.setImportePagado(new Double(new BigDecimal(cuotaCancelacion.getImportePagado().doubleValue()+
                                                cuotaCancelacion.getImporteMovimiento().doubleValue()).
                                                setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
       if(indActualizaCuotaSN.intValue()==0){
         dtoCancelar.setImportePago(new BigDecimal("0"));
         cuotaCancelacion.setImportePago(new BigDecimal("0"));
         cuotaCancelacion.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
         dtoCancelar.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
       }else{
         dtoCancelar.setImportePago(dtoCancelar.getImporteMovimiento() ); 
         cuotaCancelacion.setImportePago(cuotaCancelacion.getImporteMovimiento() );
         if(new BigDecimal(cuotaCancelacion.getImportePendiente().doubleValue()).
                abs().setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()==0D){
            cuotaCancelacion.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
         }
         if(new BigDecimal(dtoCancelar.getImportePendiente().doubleValue()).
                    abs().setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()==0D){
            dtoCancelar.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
         }
       }
    }else{
      dtoCancelar.setImporteMovimiento(new BigDecimal(cuotaCancelacion.getImportePendiente().doubleValue()*-1).setScale(2, BigDecimal.ROUND_HALF_UP));
      dtoCancelar.setImportePagado(new Double(dtoCancelar.getImporteMovimiento().
                                    add(new BigDecimal(dtoCancelar.getImportePagado().
                                            doubleValue())).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
      dtoCancelar.setImportePendiente(new Double(new BigDecimal(dtoCancelar.getImportePendiente().doubleValue()-
                                       dtoCancelar.getImporteMovimiento().doubleValue()).
                                            setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
      cuotaCancelacion.setImportePendiente(new Double("0"));
      cuotaCancelacion.setImporteMovimiento(new BigDecimal(dtoCancelar.getImporteMovimiento().doubleValue()*-1).setScale(2, BigDecimal.ROUND_HALF_UP));
      cuotaCancelacion.setImportePagado(cuotaCancelacion.getImporte());
      
      if(indActualizaCuotaSN.intValue()==0){
        dtoCancelar.setImportePago(new BigDecimal("0"));
        cuotaCancelacion.setImportePago(new BigDecimal("0"));
        cuotaCancelacion.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
        dtoCancelar.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
      }else{
        dtoCancelar.setImportePago(dtoCancelar.getImporteMovimiento() ); 
        cuotaCancelacion.setImportePago(cuotaCancelacion.getImporteMovimiento());
        cuotaCancelacion.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
        if(new BigDecimal(cuotaCancelacion.getImportePendiente().doubleValue()).
                abs().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()==0D){
           cuotaCancelacion.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
        }
        if(new BigDecimal(dtoCancelar.getImportePendiente().doubleValue()).
                abs().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()==0D){
           dtoCancelar.setMarcaSituacion(dtoDatos.getOidMarcaSituacionSalida());
        }         
      }                  
    }
      Timestamp momento = new Timestamp(System.currentTimeMillis());
      
      cuotaCancelacion.setSubprocesoUltimo(dtoDatos.getOidSubProceso());
      cuotaCancelacion.setTipoAbonoSubprocesoUltimo(dtoDatos.getOidTipoAbonoSubProceso());
      cuotaCancelacion.setTipoAbonoUltimo(dtoDatos.getOidMarcaSituacionEntrada());
      cuotaCancelacion.setFechaUltimoMovimiento(momento);
      cuotaCancelacion.setFechaValor(new Date(momento.getTime()));
      cuotaCancelacion.setUltimoNumeroHistoria(new Integer(cuotaCancelacion.getUltimoNumeroHistoria().intValue() + 1));
      dtoCancelar.setSubprocesoUltimo(dtoDatos.getOidSubProceso());
      dtoCancelar.setTipoAbonoUltimo(dtoDatos.getOidMarcaSituacionEntrada());
      dtoCancelar.setTipoAbonoSubprocesoUltimo(dtoDatos.getOidTipoAbonoSubProceso());
      dtoCancelar.setFechaUltimoMovimiento(momento);
      dtoCancelar.setFechaValor(new Date(momento.getTime()));
      dtoCancelar.setUltimoNumeroHistoria(new Integer(dtoCancelar.getUltimoNumeroHistoria().intValue() + 1));
      dtoCancelar.setCuentaCuota(dtoDatos.getOidCuentaContable());
   }
 
 
   private HashMap obetenerTiposAbonosSubproceso(){
      return null;
   }
 
  private HashMap obtenerDocumentosReferencia (ArrayList arrayOidCabecera) throws MareException {
    StringBuffer query = new StringBuffer();
    HashMap hashCabeceraSolicitud = new HashMap();
    
    if (arrayOidCabecera.size() > 0) {
        query.append(" SELECT PSC.OID_SOLI_CABE, ");
        query.append("        PSC.SOCA_OID_DOCU_REFE  ");
        query.append(" FROM PED_SOLIC_CABEC PSC  ");
        query.append(" WHERE (");
        
        Iterator it = arrayOidCabecera.iterator();
        int count = 0;
        String oids = "";
        while (it.hasNext()){
           if (count == 0) {
              oids = ((Long)it.next()).toString();
           } else { 
              oids += "," + ((Long)it.next()).toString();
           }
           if (count == 999)  {
                query.append(" PSC.OID_SOLI_CABE IN (" + oids.toString() + ") ");                     
                if (it.hasNext()){
                    query.append("  OR ");
                }                    
                count = 0;
                oids = "";
            } else {
                if (!it.hasNext()){
                    query.append(" PSC.OID_SOLI_CABE IN (" + oids.toString() + ") ");        
                }                    
                count++;            
            }            
            if (!it.hasNext()){              
              query.append(")");
            }
        }

        RecordSet rs = null;
        
        rs = this.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            for (int i=0;i<longRS;i++){
                hashCabeceraSolicitud.put(this.bigDecimalToLong(rs.getValueAt(i,"OID_SOLI_CABE")), this.bigDecimalToLong(rs.getValueAt(i,"SOCA_OID_DOCU_REFE")));
            }
        }
    }    
    return hashCabeceraSolicitud;
  } 
  
  
  private Byte obtenerIndEmisionVtoPais(Long oidPais) throws MareException {
  
      if(IndicadorVencimiento==null){
  
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerIndEmisionVtoPais(Long oidPais): Entrada ");
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT ");
        consulta.append(" IND_EMIS_VENC ");
        consulta.append(" FROM ");
        consulta.append(" SEG_PAIS p");
        consulta.append(" WHERE ");
        consulta.append(" p.OID_PAIS =  " + oidPais);

        RecordSet resultado = null;        

        resultado = this.executeQuery(consulta.toString());

        if (!resultado.esVacio()) {
            IndicadorVencimiento = new Byte(((BigDecimal) resultado.getValueAt(0, 0)).byteValue());
        }
      }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerIndEmisionVtoPais(Long oidPais): Salida ");
        return IndicadorVencimiento;
    }
    
    private ArrayList obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente,
        Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota, 
        Long oidPedidoSolicCab, Long oidsMarcasEntrada []) throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente, Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota,  Long oidPedidoSolicCab, Long oidsMarcasEntrada []): Entrada ");
        StringBuffer consulta = new StringBuffer();        
         
        consulta.append("SELECT m.* " );
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m" );        
        consulta.append(" WHERE m.IMP_PEND > 0 ");
        if ( oidCliente != null ){
            consulta.append(" AND m.CLIE_OID_CLIE = " + oidCliente);            
        }
        if ( oidEmpresa != null ){
            consulta.append(" AND m.SOCI_OID_SOCI  = " + oidEmpresa);            
        }
        if ( oidsMarcasEntrada != null){ 
            int count = 0;
            String oids = "";
            for (int i=0;i<oidsMarcasEntrada.length;i++){
               if (count == 0) {
                  oids = ((Long)oidsMarcasEntrada[i]).toString();
               } else { 
                  oids += "," + ((Long)oidsMarcasEntrada[i]).toString();                  
               }
               count++;
            }
            consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + oids.toString() + ") ");                     
       }
       if ( ejercicioCuota != null ){
            consulta.append(" AND m.VAL_EJER_CUOT  = " + ejercicioCuota);            
       }
       if ( numeroIdentCuota != null){
            consulta.append(" AND m.NUM_IDEN_CUOT = " + numeroIdentCuota);            
       }
       if ( oidPedidoSolicCab != null ){	
            consulta.append(" AND m.SOCA_OID_SOLI_CABE = " + oidPedidoSolicCab);             
       }        
       consulta.append(" ORDER BY m.NUM_ORDE_CUOT ASC ");
  
       RecordSet resultado = null; 
       
       resultado = this.executeQuery(consulta.toString());
       
       ArrayList arrayDtosCancelar = new ArrayList();
       arrayDtosCancelar = this.generarArrayDtosCancelar(resultado);
        
       UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMovCCSolicitudPedido(Long oidPais, Long oidCliente, Long oidEmpresa, String ejercicioCuota, Integer numeroIdentCuota,  Long oidPedidoSolicCab, Long oidsMarcasEntrada []): Salida");
       return arrayDtosCancelar;            
    }
    
    
    private ArrayList obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, 
                                                      Long oidCliente, Long oidEmpresa, Long oidMoneda, 
                                                      Long oidsMarcasEntrada[], String tipoDeuda) 
		throws MareException {
		UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, Long oidCliente, Long oidEmpresa, Long oidMoneda, Long oidsMarcasEntrada[]): Entrada ");

		RecordSet resultado = null;
		StringBuffer consulta = new StringBuffer();
		
		consulta.append(" SELECT m.* ");
		consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m ");		
		consulta.append(" WHERE 1 = 1 " );
    	if ( oidCliente != null ) {
			consulta.append(" AND m.CLIE_OID_CLIE = " + oidCliente); //parametro2: oidCliente			
		}
		if ( oidEmpresa != null ) {
			consulta.append(" AND m.SOCI_OID_SOCI = " + oidEmpresa); //parametro3: oidEmpresa			
		}
		if ( oidMoneda != null ) {
			consulta.append(" AND m.MONE_OID_MONE = " + oidMoneda); 			
		}
        if (tipoDeuda.equals(String.valueOf('N'))) 
        {
            consulta.append(" AND m.IMP_PEND > 0 ");
        }
        if (tipoDeuda.equals(String.valueOf('P'))) 
        {
            consulta.append(" AND m.IMP_PEND < 0 ");    
        }
        if ( oidsMarcasEntrada != null){ 
            int count = 0;
            String oids = "";
            for (int i=0;i<oidsMarcasEntrada.length;i++){
               if (count == 0) {
                  oids = (oidsMarcasEntrada[i]).toString();
               } else { 
                  oids += "," + (oidsMarcasEntrada[i]).toString();                  
               }
               count++;
            }
            consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + oids.toString() + ") ");                     
       }		
	   if(indEmisionVto == "1") {	//por fecha de facturaci�n
           consulta.append(" ORDER BY FEC_DOCU ");
	   } else {	//por fecha Vto
			consulta.append(" ORDER BY FEC_VENC ");
	   }        
		
       resultado = this.executeQuery(consulta.toString());			

       ArrayList arrayDtosCancelar = new ArrayList();
       arrayDtosCancelar = this.generarArrayDtosCancelar(resultado);
		
	   UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtenerMovCCIndicadorEmisionVto(String indEmisionVto, Long oidPais, Long oidCliente, Long oidEmpresa, Long oidMoneda, Long oidsMarcasEntrada[]): Salida");
	   return arrayDtosCancelar;
	}

    private String cadenaInt(Long cadena []) {
        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cadenaInt(Long cadena []): Entrada");
        int i;
        int size = cadena.length;
        StringBuffer sentencia = new StringBuffer("");
        String retorno = "";
        if (size > 0) {
            for (i = 0; i < size; i++) {
                sentencia.append(" ?, ");
            }
            //Quitamos la coma y el espacio del final
            retorno = sentencia.substring(0, sentencia.length() - 2);
        }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.cadenaInt(Long cadena []): Salida");
        return retorno;    
    }


    private ArrayList generarArrayDtosCancelar(RecordSet regsDoc) {
        ArrayList arrayDtosCancelar = new ArrayList();
        if (regsDoc != null && !regsDoc.esVacio()){            
            int longRs = regsDoc.getRowCount();
            for (int j=0;j<longRs;j++){
                DTOMovimientoCuentaCompleto dtoCancelar = new DTOMovimientoCuentaCompleto();
              //  dtoCancelar.setOidPais(this.bigDecimalToLong(regsDoc.getValueAt(j,"PAIS_OID_PAIS")));
                dtoCancelar.setCuentaCuota(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_CUOT")));
                dtoCancelar.setCuentaOrigen(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_ORIG")));
                dtoCancelar.setDivisa(this.bigDecimalToLong(regsDoc.getValueAt(j, "MONE_OID_MONE")));
                dtoCancelar.setDocumentoAnyo(regsDoc.getValueAt(j,"VAL_DOCU_ANIO").toString());
                dtoCancelar.setDocumentoMesSerie((String) regsDoc.getValueAt(j, "VAL_DOCU_MES_SERI"));
                dtoCancelar.setDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_DOCU_NUME")));
                dtoCancelar.setEjercicioCuota((String) regsDoc.getValueAt(j, "VAL_EJER_CUOT"));
                dtoCancelar.setEmpresa(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCI_OID_SOCI")));
                dtoCancelar.setFechaContabilizacion((regsDoc.getValueAt(j,"FEC_CONTA") != null) ? (Date) regsDoc.getValueAt(j, "FEC_CONTA") : null); //nullable
                dtoCancelar.setFechaDocumento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_DOCU")).getTime()));
                dtoCancelar.setFechaUltimoMovimiento(new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_ULTI_MOVI")).getTime()));
                dtoCancelar.setFechaValor((regsDoc.getValueAt(j, "FEC_VALO") != null) ? new Timestamp(((Date) regsDoc.getValueAt(j, "FEC_VALO")).getTime()) : null); //nullable
                dtoCancelar.setFechaVencimiento((Date) regsDoc.getValueAt( j, "FEC_VENC"));
                dtoCancelar.setImporte(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI")).doubleValue()));
                dtoCancelar.setImporteDivisa((regsDoc.getValueAt(j,"IMP_DIVI") != null) ? new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_DIVI")).doubleValue()) : null); //nullable
                dtoCancelar.setImporteMovimiento((BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI_CUEN"));
                dtoCancelar.setImporteMovimientoDivisa((regsDoc.getValueAt(j, "IMP_MOVI_DIVI") != null) ? (BigDecimal) regsDoc.getValueAt(j, "IMP_MOVI_DIVI") : null); //nullable
                dtoCancelar.setImportePagado(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PAGA")).doubleValue()));
                dtoCancelar.setImportePagadoDivisa((regsDoc.getValueAt(j,"IMP_PAGA_DIVI") != null) ? new Double(((BigDecimal)regsDoc.getValueAt(j, "IMP_PAGA_DIVI")).doubleValue()) : null); //nullable
                dtoCancelar.setImportePago((regsDoc.getValueAt(j, "IMP_PAGO") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO") : null); //nullable
                dtoCancelar.setImportePagoDivisa((regsDoc.getValueAt(j, "IMP_PAGO_DIVI") != null) ? (BigDecimal)regsDoc.getValueAt(j, "IMP_PAGO_DIVI") : null); //nullable
                dtoCancelar.setImportePendiente(new Double(((BigDecimal) regsDoc.getValueAt(j, "IMP_PEND")).doubleValue()));
                dtoCancelar.setIndicaDescuentoRecargo(this.bigDecimalToBoolean(regsDoc.getValueAt(j, "IND_DTO_CARG_APLI")));
                dtoCancelar.setMarca(this.bigDecimalToLong(regsDoc.getValueAt(j, "MARC_OID_MARC")));
                dtoCancelar.setMarcaSituacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"MASI_OID_MARC_SITU")));
                dtoCancelar.setMedioPago(this.bigDecimalToLong(regsDoc.getValueAt(j,"MPAB_OID_MEDI_PAGO")));
                dtoCancelar.setNumeroIdentificadorCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_IDEN_CUOT")));
                dtoCancelar.setNumeroLoteContabilizacion((regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") != null) ? (String) regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") : null);
                dtoCancelar.setNumeroLoteFactu(this.bigDecimalToInteger(regsDoc.getValueAt(j,"NUM_LOTE_FACT")));
                dtoCancelar.setNumeroOrdenCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_ORDE_CUOT")));
                /* Modificado por Migracion - La columna no existia con ese nombre ni tampoco con el nombre que deberia ser VAL_NUME_SERI_CUOT ---- AL --- 03/12/2008*/
                //dtoCancelar.setNumeroSerieCuota(regsDoc.getValueAt(j,"VAL_NUME_SERI_CUOOT").toString());
                dtoCancelar.setNumeroSerieCuota(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")).toString());
                /* Modificado por Migracion - La columna no existia con ese nombre ni tampoco con el nombre que deberia ser VAL_NUME_SERI_CUOT ---- AL --- 03/12/2008*/
                dtoCancelar.setObservaciones((regsDoc.getValueAt(j,"VAL_OBSE") != null) ? (String) regsDoc.getValueAt(j, "VAL_OBSE") : null); //nullable
                dtoCancelar.setOid(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")));
                dtoCancelar.setOidCliente(this.bigDecimalToLong(regsDoc.getValueAt(j, "CLIE_OID_CLIE")));
                dtoCancelar.setOidMoneda(this.bigDecimalToLong(regsDoc.getValueAt(j,"MONE_OID_MONE")));
                dtoCancelar.setOidPedidoSolicitudCab(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCA_OID_SOLI_CABE")));
                dtoCancelar.setOidRegion(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZORG_OID_REGI")));
                dtoCancelar.setOidSeccion(this.bigDecimalToLong(regsDoc.getValueAt(j, "ZSCC_OID_SECC")));
                dtoCancelar.setOidSubtipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"SBTI_OID_SUBT_CLIE")));
                dtoCancelar.setOidSugerenciaVenta(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZSGV_OID_SUBG_VENT")));
                dtoCancelar.setOidTipoDocumentoLegal(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIDO_OID_TIPO_DOCU")));
                dtoCancelar.setOidTipoSolicitud(this.bigDecimalToLong(regsDoc.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS")));
                dtoCancelar.setPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j, "PERD_OID_PERI")));
                dtoCancelar.setReferenciaNumeroDocumentoExterno((regsDoc.getValueAt(j, "VAL_REFE_NUME_DOCU_EXTE") != null) ? (String) regsDoc.getValueAt(j,"VAL_REFE_NUME_DOCU_EXTE") : null); //nullable
                dtoCancelar.setSubacceso(this.bigDecimalToLong(regsDoc.getValueAt(j, "SBAC_OID_SBAC")));
                dtoCancelar.setSubprocesoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_CREA")));
                dtoCancelar.setSubprocesoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_ULTI")));
                dtoCancelar.setTerritorioAdministrativo(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZTAD_OID_TERR_ADMI")));
                dtoCancelar.setTipoAbonoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_CREA")));
                dtoCancelar.setTipoAbonoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_ULTI")));
                dtoCancelar.setTipoCambio((BigDecimal) regsDoc.getValueAt(j, "IND_TIPO_CAMB"));
                dtoCancelar.setTipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"TICL_OID_TIPO_CLIE")));
                dtoCancelar.setTipoPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIPE_OID_TIPO_PERI")));
                dtoCancelar.setUltimoDocumentoAnyo((regsDoc.getValueAt(j,"VAL_ULTI_DOCU_ANIO") != null) ? (String) regsDoc.getValueAt(j, "VAL_ULTI_DOCU_ANIO") : null); //nullable
                dtoCancelar.setUltimoDocumentoMesSerie((regsDoc.getValueAt( j, "VAL_ULTI_DOCU_MES_SERI") != null) ? (String) regsDoc.getValueAt(j,"VAL_ULTI_DOCU_MES_SERI") : null); //nullable
                dtoCancelar.setUltimoDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_ULTI_DOCU_NUME")));
                dtoCancelar.setUltimoNumeroHistoria(this.bigDecimalToInteger(regsDoc.getValueAt(j,"VAL_ULTI_NUME_HIST")));
                arrayDtosCancelar.add(dtoCancelar);
            }
        }
        return arrayDtosCancelar;
    }
  
    private StringBuffer actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, double parcialACancelar,
                    String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion,
                    Long oidSubproceso, Long cuentaContable, Long indActualizaCuotaSN, DTOMovimientoCuentaCompleto dtoMCCAnterior, Long tipoAbonoSubproceso) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Entrada");
        
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
        dto.setTipoAbonoSubprocesoUltimo(tipoAbonoSubproceso);
        dto.setTipoAbonoUltimo(marcaEntrada);
        dto.setFechaUltimoMovimiento(new Timestamp(System.currentTimeMillis()));
        dto.setUltimoNumeroHistoria(new Integer(dto.getUltimoNumeroHistoria().intValue() + 1));
        //dto.setUsuario(ctx.getCallerPrincipal().getName());
        StringBuffer query = new StringBuffer();
        query = this.actualizarCuenta(dto, dtoMCCAnterior);
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarCuotasCancelacion(DTOMovimientoCuentaCompleto dto, BigDecimal parcialACancelar, String indEmisionVto, Long marcaEntrada, Long marcaSalida, Integer numeroIdentificacion, Long oidSubproceso, Long cuentaContable): Salida");
        return query;
    }


  public StringBuffer actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior) throws MareException {
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior): Entrada");
      DTOActualizacionCartera dtoActuCartera = new DTOActualizacionCartera();
      dtoActuCartera.setOidCuota(movimientoCuenta.getOid());
      dtoActuCartera.setOidPais(movimientoCuenta.getOidPais());
      dtoActuCartera.setOidMarca(movimientoCuenta.getMarca());
      dtoActuCartera.setImporteDeudaCancelada(new BigDecimal(movimientoCuenta.getImportePagado().doubleValue()));
      dtoActuCartera.setOidSubacceso(movimientoCuenta.getSubacceso());
      dtoActuCartera.setOidEstadoAsignacion(null);
      StringBuffer cadena = new StringBuffer();
      cadena = this.actualizarEstadoCartera(dtoActuCartera);
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarCuenta(DTOMovimientoCuentaCompleto movimientoCuenta, DTOMovimientoCuentaCompleto dtoMCCAnterior): Salida");       
      return cadena;
    }
    
 private DTOMovimientoCuentaCompleto copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone)
    {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone): Entrada");
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
        dtoResu.setTipoAbonoSubprocesoUltimo(toClone.getTipoAbonoSubprocesoUltimo());
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.copiarDTOMovimientoCuentaCompleto(DTOMovimientoCuentaCompleto toClone): Salida");
        return dtoResu;
    }

    public StringBuffer obtengoUltNumHist(DTOMovimientoCuentaCompleto dtoMCCAnterior) {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtengoUltNumHist(DTOMovimientoCuentaCompleto dtoMCCAnterior): Entrada");
        StringBuffer consulta = new StringBuffer();
        consulta.append("(SELECT NVL(MAX(NUM_HIST),-1) + 1 ");
        consulta.append("FROM CCC_HISTO_MOVIM_CC h ");
        consulta.append("WHERE h.MVCC_OID_MOVI_CC = " + dtoMCCAnterior.getOid().longValue());
        consulta.append(" )");
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.obtengoUltNumHist(DTOMovimientoCuentaCompleto dtoMCCAnterior): Salida");
        return consulta;
    }
    
    private StringBuffer generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior){
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior): Entrada");
        StringBuffer query = new StringBuffer();
        
        query.append("INSERT INTO CCC_HISTO_MOVIM_CC (OID_HIST_MOVI,SUBP_OID_SUBP,TCAB_OID_TIPO_CARG_ABON, NUM_HIST,");
        query.append("TICL_OID_TIPO_CLIE,  MASI_OID_MARC_SITU, CLIE_OID_CLIE,");
        query.append("VAL_REFE_NUME_DOCU_EXTE,  MVCC_OID_MOVI_CC,IMP,");
        query.append("IMP_PAGA,IMP_PAGA_DIVI,IMP_PEN,");
        query.append("IMP_DIVI,VAL_ULTI_DOCU_MES_SERI,VAL_ULTI_DOCU_ANIO,");
        query.append("VAL_ULTI_DOCU_NUME,VAL_NUME_LOTE_CONT,VAL_OBSE,");
        query.append("IMP_PAGO,IMP_MOVI,IMP_MOVI_DIVI,");
        query.append("IND_DESC_CARG_APLI,VAL_TIPO_CAMB,COD_USUA,");
        query.append("CUCO_OID_CUEN_CONT,MONE_OID_MONE,MPAB_OID_MEDI_PAGO_TEOR,");
        query.append("FEC_MOVI,");
        query.append("FEC_VENC,");
        if (dtoMCCAnterior.getFechaValor() != null){
            query.append("FEC_VALO,");
        }
        if (dtoMCCAnterior.getFechaContabilizacion() != null){
            query.append("FEC_CONT,");
        }
        query.append("FEC_DOCU");
        query.append(") VALUES (CCC_HMCC_SEQ.NEXTVAL,");
        //query.append(dtoMCCAnterior.getSubprocesoUltimo()+","+dtoMCCAnterior.getTipoAbonoUltimo()+","+dtoMCCAnterior.getUltimoNumeroHistoria()+",");
        
        query.append(dtoMCCAnterior.getSubprocesoUltimo()+","+dtoMCCAnterior.getTipoAbonoUltimo()+","+this.obtengoUltNumHist(dtoMCCAnterior)+",");
        
        query.append(dtoMCCAnterior.getTipoCliente()+","+dtoMCCAnterior.getMarcaSituacion()+","+dtoMCCAnterior.getOidCliente()+",");
        if(dtoMCCAnterior.getReferenciaNumeroDocumentoExterno()!=null){
         query.append("'"+dtoMCCAnterior.getReferenciaNumeroDocumentoExterno()+"',");   
        }else{
         query.append("null,");  
        }
        query.append(dtoMCCAnterior.getOid()+","+dtoMCCAnterior.getImporte()+",");
        query.append(dtoMCCAnterior.getImportePagado()+","+dtoMCCAnterior.getImportePagadoDivisa()+","+dtoMCCAnterior.getImportePendiente()+",");
        query.append(dtoMCCAnterior.getImporteDivisa()+",");
        if(dtoMCCAnterior.getDocumentoMesSerie()!=null){
         query.append("'"+dtoMCCAnterior.getDocumentoMesSerie()+"',");
        }else{
         query.append("null, ");  
        }
        if(dtoMCCAnterior.getDocumentoAnyo()!=null){
         query.append("'"+dtoMCCAnterior.getDocumentoAnyo()+"',");
        }else{
         query.append("null, ");    
        }
        query.append(dtoMCCAnterior.getDocumentoNumero()+",");
        if(dtoMCCAnterior.getNumeroLoteContabilizacion()!=null){
         query.append("'"+dtoMCCAnterior.getNumeroLoteContabilizacion()+"',");   
        }else{
         query.append("null, ");      
        }
        if (dtoMCCAnterior.getObservaciones() != null) {
          query.append("'" + dtoMCCAnterior.getObservaciones()+"',");
        } else {
          query.append("'',");
        }
        query.append(dtoMCCAnterior.getImportePago()+","+dtoMCCAnterior.getImporteMovimiento()+","+dtoMCCAnterior.getImporteMovimientoDivisa()+",");
        if (dtoMCCAnterior.getIndicaDescuentoRecargo() != null) {
          if (dtoMCCAnterior.getIndicaDescuentoRecargo().booleanValue()) {
            query.append("1,");
          } else {
            query.append("0,");
          }
        } else {
            query.append("NULL,");
        }
        query.append(dtoMCCAnterior.getTipoCambio()+",");
        if (dtoMCCAnterior.getUsuario() != null) {
          query.append("'"+dtoMCCAnterior.getUsuario()+"',");
        } else {
          query.append("'',");
        }
        query.append(dtoMCCAnterior.getCuentaCuota()+","+dtoMCCAnterior.getDivisa()+","+dtoMCCAnterior.getMedioPago()+",");
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaUltimoMovimiento())+"','dd/MM/yyyy'),");
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaVencimiento())+"','dd/MM/yyyy'),");
        if (dtoMCCAnterior.getFechaValor() != null){
            query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaValor())+"','dd/MM/yyyy'),");
        }
        if (dtoMCCAnterior.getFechaContabilizacion() != null){
            query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaContabilizacion())+"','dd/MM/yyyy'),");
        }
        query.append("TO_DATE('" + df.format(dtoMCCAnterior.getFechaDocumento())+"','dd/MM/yyyy')");
        query.append(");");
        
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarCadenaInsercionHistorico(DTOMovimientoCuentaCompleto dtoMCCAnterior): Salida");
        return query;        
    }
    
    
   private StringBuffer actualizarEstadoCartera(DTOActualizacionCartera dto) throws MareException{
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Entrada");
    StringBuffer query = new StringBuffer();
      query.append("UPDATE COB_ASIGN_COBRA  SET IMP_DEUD_CANC = round("+ dto.getImporteDeudaCancelada() + 
                  ",2) - NVL (imp_orig_deud, 0) + NVL (imp_deud_asig, 0), ");
	   query.append(" ESAS_OID_ESTA_ASIG = case when (round("+ dto.getImporteDeudaCancelada().
                                setScale(2,BigDecimal.ROUND_HALF_UP) + ",2) = imp_orig_deud ) ");
	   query.append(" then ESAS_OID_ESTA_ASIG else OBTENER_ESTADO_CARTERA("+dto.getOidCuota()+" ) end");
      query.append(" WHERE OID_ASIG_COBR in (SELECT asi.OID_ASIG_COBR FROM COB_ASIGN_COBRA asi ");
      query.append(" WHERE asi.HICC_OID_HIST_COMI_COBR IS NULL AND asi.MVCC_OID_MOVI_CC = "+dto.getOidCuota());
      query.append(" AND ASI.ESAS_OID_ESTA_ASIG = "+ConstantesCOB.OID_ESTA_ASIG_ABIERTA+" );");
    
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarEstadoCartera(DTOActualizacionCartera dto): Salida");
    return query;    
  }
  
    
    
   private StringBuffer generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC){
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC): Entrada");
      StringBuffer query = new StringBuffer();
      
      query.append("UPDATE CCC_MOVIM_CUENT_CORRI SET MASI_OID_MARC_SITU = " + dtoMovimCC.getMarcaSituacion() + ",");
      query.append("IMP_PAGO =" + dtoMovimCC.getImportePago() +" ,");
      query.append("IMP_PEND =" + dtoMovimCC.getImportePendiente() +" ,");
      query.append("IMP_PAGA =" + dtoMovimCC.getImportePagado() +" ,");
      query.append("IMP_MOVI_CUEN = " + dtoMovimCC.getImporteMovimiento() + ',');
      query.append("VAL_ULTI_DOCU_NUME =" + dtoMovimCC.getUltimoDocumentoNumero() +" ,");
      query.append("SUBP_OID_SUBP_ULTI =" + dtoMovimCC.getSubprocesoUltimo() +" ,");
      query.append("TCAB_OID_TCAB_ULTI = " + dtoMovimCC.getTipoAbonoUltimo() +",");
      //query.append("FEC_ULTI_MOVI = SYSDATE,")---Cambio 2007352 (CCC-002)
      query.append(" FEC_ULTI_MOVI =  to_date( '" + sdf.format(dtoMovimCC.getFechaUltimoMovimiento()) + "', 'DD/MM/YYYY HH24:MI:SS'), ");           
      query.append("COD_USUA = '" + dtoMovimCC.getUsuario() + "'");
      query.append(", CUCO_OID_CUEN_CONT_CUOT = " + dtoMovimCC.getCuentaCuota());
      query.append(", CUCO_OID_CUEN_CONT_ORIG = " + dtoMovimCC.getCuentaOrigen());
      query.append(", VAL_ULTI_DOCU_ANIO     = TO_CHAR(SYSDATE,'YY')"); 
      query.append(", VAL_ULTI_DOCU_MES_SERI = TO_CHAR(SYSDATE,'MM')");
      if(dtoMovimCC.getOidDocumentoReferencia()!=null){
         query.append(", VAL_REFE_NUME_DOCU_EXTE = '");   
         query.append(dtoMovimCC.getOidDocumentoReferencia().toString()).append("' ");
         
      }
      query.append(" WHERE OID_MOVI_CC = " + dtoMovimCC.getOid()+";");

      UtilidadesLog.info("MONCuentasCorrientesPerfBean.generarStringUpdateMCC(DTOMovimientoCuentaCompleto dtoMovimCC): Salida");
      return query;
   }

  private void grabarMovCCyHistorico(StringBuffer query) throws MareException {
  BelcorpService bs = BelcorpService.getInstance();      
    try {
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
    } catch (Exception e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error en grabarMovCCyHistorico ",e);
        throw new MareException(e,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }
 
 
   private DTOCargosAbonos getCabeceraByMovimientoCuentaAplicacion( DTOMovimientoCuentaCompleto dto ) throws MareException{
    DTOCargosAbonos salida = null;
    StringBuffer query = new StringBuffer("");
    
    query.append( " SELECT CAB.OID_CABE_CARG, CAB.NUM_CABE ");
    query.append( " FROM CCC_CABEC_CARGA_ABONO_DIREC CAB " );
    query.append( " WHERE CAB.PAIS_OID_PAIS = " + dto.getOidPais() );
    query.append( "   AND CAB.SOCI_OID_SOCI = " + dto.getEmpresa() );
    query.append( "   AND CAB.VAL_NUME_LOTE_FACT = '" + dto.getNumeroLoteFactu() +"' " );
    query.append( "   AND CAB.CCPR_OID_PROC = (SELECT CP.OID_PROC FROM CCC_PROCE CP WHERE CP.PAIS_OID_PAIS = " + dto.getOidPais() + " AND CP.COD_PROC = 'CCC002' AND ROWNUM=1) " );
    
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    try {
      RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
      
      if( ! rs.esVacio() ) {
        salida = new DTOCargosAbonos();
        salida.setOid(rs.getValueAt(0, "OID_CABE_CARG") != null?new Long(((BigDecimal)rs.getValueAt(0, "OID_CABE_CARG")).longValue()):null);         
        Integer entero = null;
        if (rs.getValueAt(0, "NUM_CABE") != null)
          entero = new Integer(((BigDecimal)rs.getValueAt(0, "NUM_CABE")).intValue());
        salida.setNumeroIdentificacion(entero != null?entero:null);   
      }
      
    } catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
    }
    
    return salida;
  }

 
   private Long insertarCabeceraCargoAbonoCancelacionDeuda(Integer numero, Long oidPais, Long oidEmpresa, String usuario, DTOMovimientoCuentaCompleto dto) throws MareException{
      StringBuffer query = new StringBuffer();                        
      RecordSet rs = null;
      Long oidCabecera = null;
      query.append(" SELECT CCC_CCAD_SEQ.NEXTVAL FROM DUAL");                                  
      
      rs = this.executeQuery(query.toString());
      
      if(rs != null && !rs.esVacio()){
          oidCabecera = this.bigDecimalToLong(rs.getValueAt(0,0));
          StringBuffer query2 = new StringBuffer();
          query2.append(" INSERT INTO CCC_CABEC_CARGA_ABONO_DIREC (OID_CABE_CARG, NUM_CABE, ANIO, VAL_PERI_MES, PAIS_OID_PAIS, SOCI_OID_SOCI, ");
          query2.append(" FEC_VALO, FEC_DOCU, COD_USUA, CCPR_OID_PROC, VAL_REFE_EXTE, VAL_NUME_LOTE_CONT, ");
          if (dto.getFechaContabilizacion() != null) {
                query2.append(" FEC_CONT, ");
          }
          query2.append("VAL_OBSE, VAL_NUME_LOTE_FACT) VALUES (");
          query2.append(oidCabecera + "," + numero + ", TO_CHAR(SYSDATE,'YY'), TO_CHAR(SYSDATE,'MM')");
          query2.append("," + oidPais + "," + oidEmpresa + ", TRUNC(SYSDATE), TRUNC(SYSDATE),'" + usuario + "', (SELECT CP.OID_PROC FROM CCC_PROCE CP WHERE CP.PAIS_OID_PAIS = " + oidPais + " AND CP.COD_PROC = 'CCC002'),");
          query2.append((dto.getReferenciaNumeroDocumentoExterno()!=null?"'"+dto.getReferenciaNumeroDocumentoExterno()+"'":null)+ "," + dto.getNumeroLoteContabilizacion());
          if (dto.getFechaContabilizacion() != null) {
                query2.append(",TO_DATE('" + df.format(dto.getFechaContabilizacion()) + "','DD/MM/yyyy')");
          }
          if(dto.getNumeroLoteFactu()!=null){
            query2.append(",'" + dto.getNumeroLoteFactu().toString() + "'");//observaciones
            query2.append(", "); 
            query2.append(dto.getNumeroLoteFactu().toString());
            query2.append(")");
          }else{
            query2.append(", null");
            query2.append(", null)");
          }
          try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            bs.dbService.executeUpdate(query2.toString());        
          } catch (Exception e){        
            UtilidadesLog.error("insertarCabeceraCargoAbono: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }      
      }
    return  oidCabecera;
  }


 private StringBuffer agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto, int numeroLinea,
                                                    Long tmpCuotaNueva, String usuario) throws MareException {
        StringBuffer query  = new StringBuffer();
        

        query.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
        query.append(" OID_DETA_CARG_ABON_DIRE, ");
        query.append(" CCAD_OID_CABE_CARG, ");
        query.append(" NUM_LINE, ");
        query.append(" COD_USUA, ");
        query.append(" SOCI_OID_SOCI, ");
        query.append(" TASP_OID_TIPO_ABON_SUBP, ");
        query.append(" FEC_CREA, ");
        query.append(" CLIE_OID_CLIE, ");        
        query.append(" NUM_HIST_GENE, ");
        query.append(" IMP_MONE,");  
        query.append(" IMP,");
        query.append(" VAL_REFE,");
        query.append(" VAL_OBSE, ");
        query.append(" MONE_OID_MONE,");
        query.append(" MPAB_OID_MEDI_PAGO,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_ANTE,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_NUEV,");  
        query.append(" MVCC_OID_MOVI_CC,");
        query.append(" FEC_MOVI");
        
        if (detalleCargoAbonoDirecto.getOidCtaCteBria()!=null)
            query.append(" ,CCBA_OID_CUEN_CORR_BANC");
        
        query.append(") VALUES (CCC_DCAD_SEQ.NEXTVAL,");
        query.append(detalleCargoAbonoDirecto.getOidCargoAbono() + ",");
        //el numero de linea va en null, ya q se numera con un PL al final de la facturacion
        query.append("null,'");
        query.append(usuario + "',");
        query.append(detalleCargoAbonoDirecto.getEmpresa() + ",");
        query.append(detalleCargoAbonoDirecto.getTipoAbonoSubprocesoUltimo() + ",");
        query.append("TRUNC(SYSDATE),");
        query.append(detalleCargoAbonoDirecto.getOidCliente() + ",");
        //query.append(detalleCargoAbonoDirecto.getUltimoNumeroHistoria() + ",");
        query.append(" (SELECT NVL(MAX(NUM_HIST),0)+1 FROM CCC_HISTO_MOVIM_CC WHERE MVCC_OID_MOVI_CC = "+detalleCargoAbonoDirecto.getOid()+" ),");
        query.append("0,");
        query.append(detalleCargoAbonoDirecto.getImporteMovimiento() + ",");
        query.append((detalleCargoAbonoDirecto.getReferenciaNumeroDocumentoExterno()!=null?"'"+detalleCargoAbonoDirecto.getReferenciaNumeroDocumentoExterno()+"'":null) + ",'");
        if (detalleCargoAbonoDirecto.getObservaciones() != null) {
            query.append(detalleCargoAbonoDirecto.getObservaciones() + "',");        
        } else {
            query.append("',");        
        }
        query.append(detalleCargoAbonoDirecto.getOidMoneda() + ",");        
        query.append(detalleCargoAbonoDirecto.getMedioPago() + ",");        
        query.append(detalleCargoAbonoDirecto.getCuentaCuota() + ",");        
        query.append(tmpCuotaNueva + ",");        
        query.append(detalleCargoAbonoDirecto.getOid() + ",");
        if (detalleCargoAbonoDirecto.getFechaUltimoMovimiento() != null){
            query.append("TO_DATE('" + df.format(detalleCargoAbonoDirecto.getFechaUltimoMovimiento()) + "','dd/MM/yyyy')");
        } else {
            query.append("NULL");
        }
        
        if (detalleCargoAbonoDirecto.getOidCtaCteBria()!=null)
            query.append(" ," + detalleCargoAbonoDirecto.getOidCtaCteBria());
 
        query.append(");");
        
        return query;                                                
 }
 
 private void grabarDetCargoAbono(StringBuffer query) throws MareException {
   BelcorpService bs = BelcorpService.getInstance();      
   try {
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
    } catch (Exception e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error en grabarDetCargoAbono ",e);
        throw new MareException(e,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }
 
 private StringBuffer generarStringInsercionDetalleCargoAbonoBalanceo(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto, Long oidPais) throws NamingException {
        UtilidadesLog.info("MONCuentasCorrientesPerf.generarStringInsercionDetalleCargoAbonoBalanceo(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto): Entrada");
        StringBuffer query  = new StringBuffer();

        query.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
        query.append(" OID_DETA_CARG_ABON_DIRE, ");
        query.append(" CCAD_OID_CABE_CARG, ");
        query.append(" NUM_LINE, ");
        query.append(" COD_USUA, ");
        query.append(" SOCI_OID_SOCI, ");
        query.append(" TASP_OID_TIPO_ABON_SUBP, ");
        query.append(" FEC_CREA, ");
        query.append(" CLIE_OID_CLIE, ");        
        query.append(" NUM_HIST_GENE, ");
        query.append(" IMP_MONE,");  
        query.append(" IMP,");
        query.append(" VAL_REFE,");
        query.append(" VAL_OBSE, ");
        query.append(" MONE_OID_MONE,");
        query.append(" MPAB_OID_MEDI_PAGO,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_ANTE,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_NUEV,");  
        query.append(" MVCC_OID_MOVI_CC,");
        query.append(" FEC_MOVI, ");
        query.append(" CCBA_OID_CUEN_CORR_BANC ");
        query.append(") VALUES (CCC_DCAD_SEQ.NEXTVAL,");
        query.append(detalleCargoAbonoDirecto.getOidCargoAbono() + ",");
        query.append((detalleCargoAbonoDirecto.getNumeroLineaDetalleCargoAbono()) + ",'");
        query.append(detalleCargoAbonoDirecto.getUsuario() + "',");
        query.append(detalleCargoAbonoDirecto.getEmpresa() + ", ");
        query.append("CASE WHEN ( EXISTS(SELECT asts.OID_ASIG_SUBP_POR_TIPO_SOLI ");
        query.append("FROM ccc_asign_subpr_tipo_solic asts, ");
        query.append("ped_tipo_solic_pais tsp , CCC_TIPO_ABONO_SUBPR t ");
        query.append("WHERE asts.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("AND t.SUBP_OID_SUBP = asts.SUBP_OID_SUBP_APLI_CUOT ");
        query.append("AND tsp.pais_oid_pais = "+ oidPais+" ");
        query.append("AND tsp.oid_tipo_soli_pais = "+ detalleCargoAbonoDirecto.getOidTipoSolicitud() +" ");
        query.append("AND ROWNUM=1)) ");
        query.append("then (SELECT t.OID_TIPO_ABON_SUBP ");
        query.append("FROM ccc_asign_subpr_tipo_solic asts, ");
        query.append("ped_tipo_solic_pais tsp, ccc_proce p, ");
        query.append("ccc_subpr s, CCC_TIPO_ABONO_SUBPR t ");
        query.append("WHERE asts.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("AND asts.subp_oid_subp_apli_cuot = s.oid_subp ");
        query.append("AND t.SUBP_OID_SUBP = asts.SUBP_OID_SUBP_APLI_CUOT ");
        query.append("AND s.ccpr_oid_proc = p.oid_proc ");
        query.append("AND tsp.pais_oid_pais = "+ oidPais+" ");
        query.append("AND tsp.oid_tipo_soli_pais = "+ detalleCargoAbonoDirecto.getOidTipoSolicitud() +") ");
        query.append("else (SELECT t.oid_tipo_abon_subp ");
        query.append("FROM ccc_tipo_abono_subpr t, ccc_tipo_cargo_abono c ");
        query.append("WHERE t.tcab_oid_tcab = c.oid_tipo_carg_abon ");
        query.append("AND t.subp_oid_subp = ");
        query.append("(SELECT sub.oid_subp ");
        query.append("FROM ccc_subpr sub, ccc_proce pro ");
        query.append("WHERE sub.ccpr_oid_proc = pro.oid_proc ");
        query.append("AND pro.pais_oid_pais = "+ oidPais+" ");
        query.append("AND pro.cod_proc = 'CCC002' ");
        query.append("AND sub.cod_subp = '1') ");
        query.append("AND c.pais_oid_pais = "+ oidPais+") ");
        query.append("END");
        query.append(", TRUNC(SYSDATE),");
        query.append(detalleCargoAbonoDirecto.getOidCliente() + ",");
        query.append(detalleCargoAbonoDirecto.getUltimoNumeroHistoria() + ",");
        query.append("0,");
        query.append(detalleCargoAbonoDirecto.getImportePagado() + ",");
        query.append((detalleCargoAbonoDirecto.getReferenciaNumeroDocumentoExterno()!=null?"'"+detalleCargoAbonoDirecto.getReferenciaNumeroDocumentoExterno()+"'":null) + ",'");
        if (detalleCargoAbonoDirecto.getObservaciones() != null) {
            query.append(detalleCargoAbonoDirecto.getObservaciones() + "',");        
        } else {
            query.append("',");        
        }
        query.append(detalleCargoAbonoDirecto.getOidMoneda() + ",");        
        query.append(detalleCargoAbonoDirecto.getMedioPago() + ",");        
        query.append(detalleCargoAbonoDirecto.getCuentaCuota() + ",");        
        query.append(detalleCargoAbonoDirecto.getOidCuotaNueva() + ",");        
        query.append(detalleCargoAbonoDirecto.getOid() + ",");
        if (detalleCargoAbonoDirecto.getFechaUltimoMovimiento() != null){
            query.append("TO_DATE('" + df.format(detalleCargoAbonoDirecto.getFechaUltimoMovimiento()) + "','dd/MM/yyyy')" + ",");
        } else {
            query.append("NULL " + ",");
        }
        if (detalleCargoAbonoDirecto.getOidCtaCteBria()!=null){
            query.append(detalleCargoAbonoDirecto.getOidCtaCteBria());
        }else{
            query.append("NULL");
        }
        
        query.append(");");
        
        UtilidadesLog.info("MONCuentasCorrientesPerf.generarStringInsercionDetalleCargoAbonoBalanceo(DTOMovimientoCuentaCompleto detalleCargoAbonoDirecto): Salida");
        return query;  
 }
 
 private StringBuffer subConsultaTipoAbonSubp(Long oidPais) {        
     StringBuffer query  = new StringBuffer();
     query.append("SELECT t.oid_tipo_abon_subp ");
     query.append("FROM CCC_SUBPR sub, CCC_PROCE pro, CCC_TIPO_ABONO_SUBPR t, CCC_TIPO_CARGO_ABONO c ");
     query.append("WHERE sub.ccpr_oid_proc = pro.oid_proc ");
     query.append("AND pro.pais_oid_pais = " + oidPais.longValue());
     query.append(" AND pro.cod_proc = 'CCC002' ");
     query.append("AND sub.cod_subp = '2' ");
     query.append("AND t.tcab_oid_tcab = c.oid_tipo_carg_abon ");
     query.append("AND t.subp_oid_subp = sub.OID_SUBP ");
     query.append("AND c.pais_oid_pais = pro.pais_oid_pais");
     return query;
 }
 
  public void aplicacionAutomaticaDeudaPositivaFacturacion(DTOMovimientoCuentaCompleto[] dtos, Long oidCabecera, Integer numeroIdentificacion) throws MareException, NamingException {
  
      UtilidadesLog.info("MONCuentasCorrientesPerf.aplicacionAutomaticaDeudaPositivaFacturacion(): Entrada");
      
      String usuarioActual = null;
      if(dtos[0].getUsuario()!=null){
         usuarioActual = dtos[0].getUsuario();
      }else{
         usuarioActual = ctx.getCallerPrincipal().getName();
      }
  
      boolean hayImportePositivo = false;
      int longitudDtos = dtos.length; 

      for (int i = 0; i < longitudDtos; i++) {
          if ( dtos[i].getImporte().doubleValue() > 0 ) {
              hayImportePositivo = true;
              break;
          }
      }
      
      // Salimos del metodo si no habia importes positivos para procesar.
      if ( !hayImportePositivo || longitudDtos==0 ){
          UtilidadesLog.info("MONCuentasCorrientes.aplicacionAutomaticaDeudaPositivaFacturacion(): Salida 2");	        
          return;
      }
      
      String proceso = CCCConstantes.APLIC_AUTOMATICA_MOV_BANC;  
      Integer subproceso = new Integer(1);  // TES002 y 1: Recaudo manual y no aplicado
      Long pais = dtos[0].getOidPais();      
      boolean encontreRegEnAsigSubpTipoSol = false;
     
      DAOCCC daoCCC = new DAOCCC(); 
      DTOSubproceso dtoSubproceso = new DTOSubproceso();
      DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = daoCCC.obtenerAsignacionSubprocesosTiposSolicitudAplicacion(dtos[0].getOidPais(), dtos[0].getOidTipoSolicitud());
      if (dtoAbonSubMarSitu.getOid() != null){ 
          dtoSubproceso = this.obtenerDatosSubprocesoSCS(pais, dtoAbonSubMarSitu.getOidProcesoAplicacionCtas(), 
                                                                        dtoAbonSubMarSitu.getOidSubprocesoAplicacionCtas());
          encontreRegEnAsigSubpTipoSol = true;                                                                        
      }else{
          dtoSubproceso = this.obtenerDatosSubproceso(pais, proceso, subproceso);
      }
      
      Long oidSubproceso = null;
      
      if (dtoSubproceso != null){oidSubproceso = dtoSubproceso.getOidSubproceso();}
      
      DTOMantenimientoTiposAbonoSubproceso dtoMantenimientoTiposAbonoSubproceso = new DTOMantenimientoTiposAbonoSubproceso();
      dtoMantenimientoTiposAbonoSubproceso = this.obtenerTiposAbonoSubprocesoCContable(pais, oidSubproceso);
      Long cuentaContable = null;
      Long tipoAbono = null;
      Long tipoAbonoBancos = null;
      Long tipoAbonoUltimo = null; 
      if (dtoMantenimientoTiposAbonoSubproceso!= null){
          cuentaContable = dtoMantenimientoTiposAbonoSubproceso.getOidCuentaContable();   
          tipoAbono = dtoMantenimientoTiposAbonoSubproceso.getOidTipoAbono();
          tipoAbonoUltimo = dtoMantenimientoTiposAbonoSubproceso.getOidTipoAbono();
          tipoAbonoBancos = dtoMantenimientoTiposAbonoSubproceso.getOidTiposAbonoSubproceso();
      }       
     
      String procesoBancos = "CCC002";
      Integer subprocesoBancos = new Integer(1);
      Long oidSubprocesoBancos = null;
      Long indActualizaCuotaSN = null;
      DTOSubproceso dtoSubprocesoBancos = new DTOSubproceso();
      dtoSubprocesoBancos = this.obtenerDatosSubproceso(pais, procesoBancos, subprocesoBancos);
      if (dtoSubprocesoBancos != null){            
          oidSubprocesoBancos = dtoSubprocesoBancos.getOidSubproceso();
          indActualizaCuotaSN = dtoSubprocesoBancos.getIndActualizaCuota();
      }
      ArrayList marcaSalida = new ArrayList();
      marcaSalida = this.obtenerMarcasTipoAbono(pais, oidSubprocesoBancos, new String("S"));
      DTOMarcasPorTipoAbono dtoMarcaSalida = (DTOMarcasPorTipoAbono)marcaSalida.get(0);
      Long lngMarcaSalida = null;
      if (dtoMarcaSalida != null){lngMarcaSalida =  dtoMarcaSalida.getOid();}
      
      DTOMantenimientoTiposAbonoSubproceso dtoMantenimientoTiposAbonoSubprocesoBancos = new DTOMantenimientoTiposAbonoSubproceso();
      dtoMantenimientoTiposAbonoSubprocesoBancos = this.obtenerTiposAbonoSubprocesoCContable(pais, oidSubprocesoBancos);
      Long tmpTipoAbonoCuentaContable = null; 
      Long tipoCargoAbonoUltimo = null;
      Long cuentaContCuota = null;
      if (dtoMantenimientoTiposAbonoSubprocesoBancos!= null){
          tmpTipoAbonoCuentaContable = dtoMantenimientoTiposAbonoSubprocesoBancos.getOidTiposAbonoSubproceso();
          tipoCargoAbonoUltimo = dtoMantenimientoTiposAbonoSubprocesoBancos.getOidTipoAbono();
          cuentaContCuota = dtoMantenimientoTiposAbonoSubprocesoBancos.getOidCuentaContable();
      }
      
      //UtilidadesLog.warn("- GA - Obtencion de tipos de abono en Aplicacion: "+(System.currentTimeMillis()-inicio));
      
      // Recorremos el array de cuotas de cancelaci�n que nos ha llegado como par�metro
      int longitudAntiguos = 0;
      ArrayList regsAntiguos= new ArrayList();
      if(longitudDtos>0) {
        regsAntiguos = this.obtenerMovBancarios(dtos[0].getOidPais(), dtos[0].getOidCliente(),dtos[0].getEmpresa());
        longitudAntiguos = regsAntiguos.size();
      }
      //UtilidadesLog.warn("- GA - Obtencion de los movimientos bancarios en Aplicacion: "+(System.currentTimeMillis()-inicio));
      //segun DECU, solo aplicara recaudos cuando se este procesando una Cuota 
      //de cancelacion sobre la que NO se haya recuperado registro en
      //Asignacion SubProcesos por Tipo de Solicitud
      if (encontreRegEnAsigSubpTipoSol) {
          UtilidadesLog.debug("- GA - No se aplica porq esta configurado el tipo solicitud pais");
          longitudAntiguos=0;  
      }

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

      HelperHistorial helpHist = new HelperHistorial();
      
      for (int i = 0; i < longitudDtos; i++) {//(1)
         DTOMovimientoCuentaCompleto movCC = dtos[i];
          if (!(new BigDecimal(movCC.getImportePendiente().doubleValue()).
                abs().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() > 0)){
            continue;
          }
            StringBuffer cadenaInsercion = new StringBuffer();
            int numeroLinea = 0;
            if ((movCC.getNumeroLineaDetalleCargoAbono() != null)){
                numeroLinea = movCC.getNumeroLineaDetalleCargoAbono().intValue();
             }
            for(int j = 0; j < longitudAntiguos; j++) { //(2)
                DTOMovimientoBancario dtoCancelar = (DTOMovimientoBancario)regsAntiguos.get(j);
                //generamos la historia del movimiento bancario
                cadenaInsercion.append(helpHist.obtenerHistoriaBancos(dtoCancelar.getOid()));
               //Calculamos la cancelacion
                if(dtoCancelar.getImporteSaldo().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() <= 
                    new BigDecimal(movCC.getImportePendiente().doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()){
                  //el saldo del banco se consume por completo
                   dtoCancelar.setImporteMovimiento(dtoCancelar.getImporteSaldo());
                   dtoCancelar.setImporteSaldo(new BigDecimal(0));
                   dtoCancelar.setImporteAplicado(dtoCancelar.getImporteAplicado().add(dtoCancelar.getImporteMovimiento()).
                                                                            setScale(2, BigDecimal.ROUND_HALF_UP));
                   //movCC.setImportePagado(new Double(movCC.getImportePagado().doubleValue()+dtoCancelar.getImporteMovimiento().doubleValue()));
                   movCC.setImportePagado(new Double(dtoCancelar.getImporteMovimiento().add(new BigDecimal(movCC.getImportePagado().
                                                                        doubleValue())).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
                   //movCC.setImportePendiente(new Double(movCC.getImportePendiente().doubleValue()-dtoCancelar.getImporteMovimiento().doubleValue()));
                   movCC.setImportePendiente(new Double(new BigDecimal(movCC.getImportePendiente().doubleValue()).
                                subtract(dtoCancelar.getImporteMovimiento()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) );
                   movCC.setImporteMovimiento(dtoCancelar.getImporteMovimiento());
                   if(indActualizaCuotaSN.intValue()==0){
                     dtoCancelar.setImportePago(new BigDecimal("0"));
                     movCC.setImportePago(new BigDecimal("0"));
                     movCC.setMarcaSituacion(lngMarcaSalida);
                   }else{
                     dtoCancelar.setImportePago(dtoCancelar.getImporteMovimiento() ); 
                     movCC.setImportePago(dtoCancelar.getImporteMovimiento() );
                     if(movCC.getImportePendiente().doubleValue()==0){
                        movCC.setMarcaSituacion(lngMarcaSalida);
                     }
                   }
                }else{//no alcanza a cubrir la cancelacion
                  dtoCancelar.setImporteMovimiento(new BigDecimal(movCC.getImportePendiente().doubleValue()).
                                                                                setScale(2, BigDecimal.ROUND_HALF_UP));
                  //dtoCancelar.setImporteSaldo(new BigDecimal(dtoCancelar.getImporteSaldo().doubleValue()-dtoCancelar.getImporteMovimiento().doubleValue()));
                  dtoCancelar.setImporteSaldo(dtoCancelar.getImporteSaldo().subtract(dtoCancelar.getImporteMovimiento()).
                                                                                setScale(2,BigDecimal.ROUND_HALF_UP));
                  //dtoCancelar.setImporteAplicado(new BigDecimal(dtoCancelar.getImporteAplicado().doubleValue()+dtoCancelar.getImporteMovimiento().doubleValue()));
                  dtoCancelar.setImporteAplicado(dtoCancelar.getImporteAplicado().add(dtoCancelar.getImporteMovimiento()).
                                                                                setScale(2,BigDecimal.ROUND_HALF_UP));
                  movCC.setImportePagado(movCC.getImporte());
                  movCC.setImportePendiente(new Double(0));
                  movCC.setImporteMovimiento(dtoCancelar.getImporteMovimiento());
                  if(indActualizaCuotaSN.intValue()==0){
                    dtoCancelar.setImportePago(new BigDecimal("0"));
                    movCC.setImportePago(new BigDecimal("0"));
                    movCC.setMarcaSituacion(lngMarcaSalida);
                  }else{
                        dtoCancelar.setImportePago(dtoCancelar.getImporteMovimiento() ); 
                        movCC.setImportePago(dtoCancelar.getImporteMovimiento());
                     if(movCC.getImportePendiente().doubleValue()==0){
                        movCC.setMarcaSituacion(lngMarcaSalida);
                     }
                  }                  
                }
                dtoCancelar.setFechaMovimientoAplicacion(new java.util.Date());
                dtoCancelar.setFechaUltimoMivimiento(new java.util.Date());
                dtoCancelar.setCodigoUsuario(usuarioActual);
                dtoCancelar.setOidTipoAbonoUltimo(tipoAbonoUltimo);
                dtoCancelar.setOidSubprocesoMarcaUltimo(oidSubprocesoBancos);
                //movCC.setSubprocesoUltimo(oidSubprocesoBancos); No se si va, cualquier cosa despues lo descomento.
                Character charEstado = new Character(new String("P").charAt(0));
                if(dtoCancelar.getImporteSaldo().doubleValue()==0.0){
                   charEstado = new Character(new String("A").charAt(0));
                }
                dtoCancelar.setEstatusMovimientoTesoreria(charEstado);
                numeroLinea += 1;
                cadenaInsercion.append(this.armarUpdateMovimientoBancario(dtoCancelar, numeroIdentificacion));
                //generamos el detalle de cargo y abono del movimiento bancario
                cadenaInsercion.append(this.agregarDetalleCADDeudaPositivaFacturacion(dtoCancelar, numeroLinea,
                                         usuarioActual,  oidCabecera, cuentaContable, movCC.getMedioPago(), tipoAbonoBancos));
                //Segun pedido de cambio 20070352 (CCC-002) (Gacevedo) se usa la fecha de pago en
                //banco se la misma es informada.
                if(dtoCancelar.getFechaPago()!=null){
                    movCC.setFechaUltimoMovimiento(new Timestamp(dtoCancelar.getFechaPago().getTime()));
                }
                movCC.setCuentaCuota(cuentaContable);
                movCC.setTipoAbonoUltimo(tipoAbono);
                movCC.setTipoAbonoSubprocesoUltimo(tmpTipoAbonoCuentaContable);
                movCC.setSubprocesoUltimo(oidSubprocesoBancos);
                movCC.setFechaValor(new java.util.Date());
                movCC.setFechaDocumento(new java.util.Date());
                movCC.setUltimoDocumentoMesSerie(mes);
                movCC.setUltimoDocumentoAnyo(anyo);
                movCC.setUltimoDocumentoNumero(numeroIdentificacion);
                movCC.setCuentaOrigen(cuentaContCuota);
                movCC.setCuentaCuota(dtos[i].getCuentaOrigen());
                movCC.setTipoAbonoUltimo(tipoCargoAbonoUltimo);
                movCC.setOidCtaCteBria(dtoAbonSubMarSitu.getOidCtaCteBancaria());
                movCC.setOidCargoAbono(oidCabecera);
                numeroLinea+=1;
                movCC.setNumeroLineaDetalleCargoAbono(new Integer(numeroLinea));
                //generamos la historia de la cuenta corriente
                cadenaInsercion.append(helpHist.obtenerHistoriaCuentasCorrientes(movCC.getOid()) );
                //generamos el update de la cuenta corriente
                cadenaInsercion.append(this.generarStringUpdateMCC(movCC).toString());
                //generamos el detalle cargo abono del movimiento de cuenta corriente
                cadenaInsercion.append(agregarDetalleCargosAbonosDirectosCancelacionDeudaAut(movCC, numeroLinea, cuentaContCuota, usuarioActual));
                //sbuchelli insertando en cargo abono ssicc
                this.insertarCargoAbonoBancario(dtos[i],movCC.getSubprocesoUltimo(),dtoCancelar,usuarioActual);
                //si pague todo, corto
                if (movCC.getImportePendiente().doubleValue() == 0) {
                  break;
                } 
            } // fin del for //(2)
            //UtilidadesLog.warn("- GA - proceso de la cuota en Aplicacion("+i+"): "+(System.currentTimeMillis()-inicio));
            this.grabarMovCCyHistorico(cadenaInsercion);
            //UtilidadesLog.warn("- GA - grabacion de las cuota en Aplicacion: "+(System.currentTimeMillis()-inicio));
      } // fin del for (1) 
      //UtilidadesLog.warn("- GA - Tiempo total de Aplicacion "+(System.currentTimeMillis()-tiempoMetodo));
      UtilidadesLog.info("MONCuentasCorrientesPerf.aplicacionAutomaticaDeudaPositivaFacturacion(): Salida 1");	    
  }  

 public Boolean bloquearMovBanc(DTOOIDs dtos) throws MareException, NamingException {
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOIDs dtos): Entrada");

        BloqueoMovBancLocalHome bloqueoMovBancHome = null;
        BloqueoMovBancLocal bloqueoMovBancLocal = null;
		Long timeOutBloqueo = null;
		MareMGC mgc = null; 
        try {

			mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));

			String time = (String) mgc.getProperty("application.timeOutBloqueo");
			timeOutBloqueo = new Long(time);
        } catch (NoSuchElementException nse) {
            throw new MareException(nse,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO));
        }
        
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
				if (!bloqueoMovBancLocal.getUsuario().equals(usuario)){
					if ((System.currentTimeMillis() - bloqueoMovBancLocal.getTiempo().longValue()) > timeOutBloqueo.longValue()){
						bloqueoMovBancLocal.setUsuario(usuario);
						bloqueoMovBancLocal.setTiempo(BigDecimal.valueOf(System.currentTimeMillis()));
                                                bloqueoMovBancHome.merge(bloqueoMovBancLocal);
						UtilidadesLog.info("****Metodo bloquearMovBanc(DTOOIDs dtos): Salida");
					} else {
						return Boolean.FALSE;
					}
				}
			}
		}
        UtilidadesLog.info("MONCuentasCorrientesBean.bloquearMovBanc(DTOOIDs dtos): Salida");
        return Boolean.TRUE;
    }

  private BloqueoMovBancLocalHome getBloqueoMovBancLocalHome(){    
    return new BloqueoMovBancLocalHome();
  }
  
  	public DTOSalida bloquearBloqueoMovBanc() throws  RemoteException, MareException {
	/**
	 * 	//Concepto 
	 *	Obtenemos los OIDs que el usuario actual tiene bloqueados y bloqueamos la tabla de bloqueos para que no 
	 *	se pueda modificar mientras se ejecuta la actualizaci�n de datos en las tablas de Movimientos. 
	 *
	 *	//Par�metros de e/s 
	 *	Entrada: void 
	 *	Salida: DTOSalida dtoSalida 
	 *
	 *	//Proceso 
	 *	String usuario = ejbContext.getCallerPrincipal().getName(); 
	 *	Llamamos a DAOCuentasCorrientes.bloquearBloqueoMovBanc( usuario ) 
	 *	Construimos un DTOSalida con el RecordSet obtenido de la llamada al m�todo anterior. 
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
  
  private double totalDispBco(ArrayList regsAntiguos) {
      UtilidadesLog.info("MonCuentasCorrientesPerf.totalDispBco(ArrayList regsAntiguos): Entrada");	
      double total = 0;
      for (int j = 0; j < regsAntiguos.size(); j++) {
          DTOMovimientoBancario dtoMovBancarios = (DTOMovimientoBancario)regsAntiguos.get(j);
          total = total + dtoMovBancarios.getImporteSaldo().doubleValue();
      }
      UtilidadesLog.info("MonCuentasCorrientesPerf.totalDispBco(ArrayList regsAntiguos): Salida");		
      return total;
  }
  
  private ArrayList obtenerMovBancarios(Long pais, Long cliente, Long empresa) throws MareException {
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovBancarios(Long pais, Long cliente, Long empresa): Entrada");		
        
        //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
        Vector params = new Vector();
        params.add(pais); //pais
        params.add(cliente); //cliente
        params.add(empresa); //empresa
        RecordSet rs = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.CCC_PR_OBTIE_MOVIM_BANCA", params);

        /*StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT m.* ");
        query.append(" FROM ccc_movim_banca m ");
        query.append(" WHERE m.pais_oid_pais = " + pais);
        query.append("   AND m.clie_oid_clie = " + cliente);
        query.append("   AND m.soci_oid_soci = " + empresa);
        query.append("   AND m.imp_sald_pend > 0 ");
        query.append("   AND m.cod_iden_proc = 'P' "); //(P)rocesado
        query.append(" ORDER BY FEC_PAGO, NUM_CONS_TRAN ");
        
        rs = this.executeQuery(query.toString());  */
        
        ArrayList arrayMovimientosBancarios = new ArrayList();
        arrayMovimientosBancarios = this.generarArrayDtosMovimientosBancarios(rs);
        
        UtilidadesLog.info("DAOCuentasCorrientes.obtenerMovBancarios(Long pais, Long cliente, Long empresa): Salida");
        return arrayMovimientosBancarios;
    }
    
  private ArrayList generarArrayDtosMovimientosBancarios(RecordSet regsAntiguos){
    ArrayList arrayMovimientoBancarios = new ArrayList();
    if (regsAntiguos != null && !regsAntiguos.esVacio()){
       int lonRS = regsAntiguos.getRowCount();      
       for (int j=0;j<lonRS;j++){
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
              dtoCancelar.setConsecutivoTransaccion(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "NUM_CONS_TRAN")));
              dtoCancelar.setCuentaCorrienteBancaria(this.bigDecimalToLong(regsAntiguos.getValueAt(j,"CCBA_OID_CC_BANC")));
              dtoCancelar.setDigitoChequeo(this.bigDecimalToInteger(regsAntiguos.getValueAt(j, "VAL_DIGI_CHEQ_FACT")));
              dtoCancelar.setEmpresa(this.bigDecimalToLong(regsAntiguos.getValueAt(j,"SOCI_OID_SOCI")));
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
              dtoCancelar.setNumeroCupon(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "NUM_CUPO")));
              dtoCancelar.setNumeroDocumentoAplicacion(this.bigDecimalToInteger(regsAntiguos.getValueAt(j, "VAL_DOCU_APLI_NUME")));
              dtoCancelar.setNumeroDocumentoCreacion(this.bigDecimalToInteger(regsAntiguos.getValueAt(j, "VAL_DOCU_CREA_NUME")));
              dtoCancelar.setNumeroFactura(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "NUM_FACT_BOLE")));
              dtoCancelar.setNumeroHistoria((this.bigDecimalToInteger(regsAntiguos.getValueAt(j, "NUM_HIST")) != null)?this.bigDecimalToInteger(regsAntiguos.getValueAt(j, "NUM_HIST")):new Integer(0));
              dtoCancelar.setNumeroLote(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "NUM_LOTE")));
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
              dtoCancelar.setOid(this.bigDecimalToLong(regsAntiguos.getValueAt(j,"OID_MOVI_BANC")));
              dtoCancelar.setOidConsultoraReal(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "CLIE_OID_CLIE")));
              dtoCancelar.setOidSubprocesoMarcaUltimo(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "SUBP_OID_MARC_ULTI")));
              dtoCancelar.setOidTipoAbonoUltimo(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "TCAB_OID_ABON_ULTI")));
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
              dtoCancelar.setSubacceso(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "SBAC_OID_SBAC")));
              dtoCancelar.setTipoTransaccion(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "TTRA_OID_TIPO_TRANS")));
              dtoCancelar.setUsuarioProceso(
                  (regsAntiguos.getValueAt(j, "VAL_USUA_PROC") != null)
                      ? (String) regsAntiguos.getValueAt(j,
                          "VAL_USUA_PROC")
                      : null );
              /* Modificado por Migracion - No existia la Columna, se toma la primera de la tabla en cuestion --- AL ---23/02/2009 */
              dtoCancelar.setOidMovimientoCC(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "OID_MOVI_BANC")));       
              //dtoCancelar.setOidMovimientoCC(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "OID_MOVI_CC")));       
              /* Fin Modificado --- AL ---23/02/2009 */
              dtoCancelar.setFechaProceso((regsAntiguos.getValueAt(j, "FEC_PROC") != null)
                      ? (Date) regsAntiguos.getValueAt(j,
                          "FEC_PROC")
                      : null );
              dtoCancelar.setHoraProceso((regsAntiguos.getValueAt(j, "VAL_HORA_PROC") != null)
                      ? new Timestamp(((Date) regsAntiguos.getValueAt(j,
                          "VAL_HORA_PROC")).getTime())
                      : null );
              dtoCancelar.setOidError(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "TIER_OID_ERRO")));
              // Incidencia Sicc20080573 - Modificado por HRCS - Fecha 14/03/2008
              //dtoCancelar.setNumeroDocumento(this.bigDecimalToLong(regsAntiguos.getValueAt(j, "VAL_NUME_DOCU")));
              dtoCancelar.setNumeroDocumento(
                  (regsAntiguos.getValueAt(j, "VAL_NUME_DOCU") != null)
                      ? new Long( (String)regsAntiguos.getValueAt(j,"VAL_NUME_DOCU") )
                      : null );
              dtoCancelar.setOidTipoAbonoCreacion(this.bigDecimalToLong(regsAntiguos.getValueAt(j,"TCAB_OID_ABON_CREA")));
              dtoCancelar.setOidSubprocesoMarcaCreacion(this.bigDecimalToLong(regsAntiguos.getValueAt(j,"SUBP_OID_MARC_CREA")));
              
            arrayMovimientoBancarios.add(dtoCancelar);
       }

    } 
    return arrayMovimientoBancarios;
  }

    public DTONumeroRegistros eliminarBloqueoMovBanc(DTOOIDs dto) throws MareException, NamingException {
	/**
	 *	Entrada: DTOOIDs. 
	 *	Salida: DTONumeroRegistros 
	 *
	 *	Por cada oid del array recibido invocamos al m�todo 
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
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }
            } catch (PersistenceException fe) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug(
                    "****Metodo eliminarBloqueosMovBanc: error -----> finderException");
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

 private StringBuffer agregarDetalleCADDeudaPositivaFacturacion(DTOMovimientoBancario detalleCargoAbonoDirecto, int numeroLinea,
                                                    String usuario, Long oidCabecera, Long CuentaContable, Long medioPago, Long tipoAbono) throws MareException {
        StringBuffer query  = new StringBuffer();

        query.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
        query.append(" OID_DETA_CARG_ABON_DIRE, ");
        query.append(" CCAD_OID_CABE_CARG, ");
        query.append(" NUM_LINE, ");
        query.append(" COD_USUA, ");
        query.append(" SOCI_OID_SOCI, ");
        query.append(" TASP_OID_TIPO_ABON_SUBP, ");
        query.append(" FEC_CREA, ");
        query.append(" CLIE_OID_CLIE, ");        
        query.append(" NUM_HIST_GENE, ");
        query.append(" IMP_MONE,");  
        query.append(" IMP,");
        query.append(" MPAB_OID_MEDI_PAGO,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_ANTE,");
        query.append(" CUCO_OID_CUEN_CONT_CUOT_NUEV,");  
        query.append(" CMBA_OID_MOVI_BANC,");
        query.append(" FEC_MOVI");
        query.append(", CCBA_OID_CUEN_CORR_BANC ");
        query.append(") VALUES (CCC_DCAD_SEQ.NEXTVAL,");
        query.append(oidCabecera + ",");
        //el numero de linea se actualiza mediante un PL al final de proceso de facturacion
        query.append("null,'");
        query.append(usuario + "',");
        query.append(detalleCargoAbonoDirecto.getEmpresa() + ",");
        query.append(tipoAbono + ",");
        query.append("TRUNC(SYSDATE),");
        query.append(detalleCargoAbonoDirecto.getOidConsultoraReal() + ",");
        query.append((detalleCargoAbonoDirecto.getNumeroHistoria().intValue() + 1) + ",");
        query.append("0,");
        query.append(detalleCargoAbonoDirecto.getImporteMovimiento() + ",");
        query.append(medioPago + ",");        
        query.append(CuentaContable + ",");        
        query.append(CuentaContable + ",");        
        query.append(detalleCargoAbonoDirecto.getOid() + ",");
        query.append("TRUNC(SYSDATE)");
        
        if (detalleCargoAbonoDirecto.getOidCtaCteBria()!=null){
            query.append(", ").append(detalleCargoAbonoDirecto.getOidCtaCteBria());
        }else{
            query.append(", ").append("null");        
        }
        query.append(");");
        
        return query;  
 }

 private StringBuffer actualizarMovBancario(DTOMovimientoBancario[] arrayMovimientosBancarios, HashMap hashMovBancariosAnteriores, Integer numero) {
     UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarMovBancario(DTOMovimientoBancario[] arrayMovimientosBancarios, HashMap hashMovBancariosAnteriores): Entrada");
     UtilidadesLog.debug("arrayMovimientosBancarios, mide: " + arrayMovimientosBancarios.length);
     int longMovimBancarios = arrayMovimientosBancarios.length;     
     StringBuffer cadenaInsercion = new StringBuffer();
      for (int j=0; j <longMovimBancarios ; j++){
           DTOMovimientoBancario dtoMovimientoBancario = (DTOMovimientoBancario)arrayMovimientosBancarios[j];   
           //DTOMovimientoBancario dtoMovimientoBancarioAnterior = (DTOMovimientoBancario)hashMovBancariosAnteriores.get(dtoMovimientoBancario.getOid());
           //cadenaInsercion.append(this.armarInsertHisotricoMovimientosBancarios(dtoMovimientoBancarioAnterior));
           UtilidadesLog.debug("armo update, con el dtoMovimientoBancario: " + dtoMovimientoBancario);
           cadenaInsercion.append(this.armarUpdateMovimientoBancario(dtoMovimientoBancario, numero));          
      }
      UtilidadesLog.info("MONCuentasCorrientesPerfBean.actualizarMovBancario(DTOMovimientoBancario[] arrayMovimientosBancarios, HashMap hashMovBancariosAnteriores): Entrada");
      return cadenaInsercion;
 }

    private StringBuffer armarInsertHisotricoMovimientosBancarios(DTOMovimientoBancario localMovimientos) {
        StringBuffer query = new StringBuffer();
        StringBuffer values = new StringBuffer();
        query.append("INSERT INTO CCC_HISTO_MOVIM_BANCA ( ");
		
		query.append(" oid_movi_banc, ");
        values.append( "CCC_HMCC_SEQ.NEXTVAL, ");
		query.append(" tcab_oid_tipo_carg_abon_crea, ");
        values.append( localMovimientos.getOidTipoAbonoCreacion() + ", ");
	  	query.append(" soci_oid_soci, ");
        values.append( localMovimientos.getEmpresa() + ", ");
		query.append(" clie_oid_clie, ");
        values.append( localMovimientos.getOidConsultoraReal() + ", ");
		query.append(" fec_paso_hist, ");          
        values.append(" to_date( '" + new Date(System.currentTimeMillis()) + "', 'YYYY-MM-DD'), ");           
		query.append(" subp_oid_subp_crea, ");
        values.append( localMovimientos.getOidSubprocesoMarcaCreacion() + ", ");
		query.append(" ccba_oid_cuen_corr_banc ");
        values.append( localMovimientos.getCuentaCorrienteBancaria() );
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
		if (localMovimientos.getNumeroFactura() != null) {
			query.append(", num_fact_bole ");			
			values.append(", ").append(localMovimientos.getNumeroFactura());
		}
		if (localMovimientos.getObservaciones() != null) {
			query.append(", val_obse ");			
			values.append(", ").append("'").append(localMovimientos.getObservaciones()).append("'");
		}
		if (localMovimientos.getNumeroLoteContabilizacion() != null) {
			query.append(", val_num_lote_cont ");			
			values.append(", ").append("'").append(localMovimientos.getNumeroLoteContabilizacion()).append("'");
		}
    if (localMovimientos.getOidError() != null) {
			query.append(", tier_oid_erro ");			
			values.append(", ").append(localMovimientos.getOidError());
		}
        if (localMovimientos.getOidTipoAbonoUltimo() != null) {
			query.append(", tcab_oid_tipo_carg_abon_ulti ");			
			values.append(", ").append(localMovimientos.getOidTipoAbonoUltimo());
		}
        if (localMovimientos.getTipoTransaccion() != null) {
			query.append(", ttra_oid_tipo_tran ");			
			values.append(", ").append(localMovimientos.getTipoTransaccion());
		}
        if (localMovimientos.getOidSubprocesoMarcaUltimo()!= null) {
			query.append(", subp_oid_subp_ulti ");			
			values.append(", ").append(localMovimientos.getOidSubprocesoMarcaUltimo());
		}
        if (localMovimientos.getImporteSaldo() != null) {
			query.append(", imp_sald_pend ");			
			values.append(", ").append(localMovimientos.getImporteSaldo());
		}
        if (localMovimientos.getImporteAplicado() != null) {
			query.append(", imp_apli ");			
			values.append(", ").append(localMovimientos.getImporteAplicado());
		}
        if (localMovimientos.getNumeroLote() != null) {
			query.append(", num_lote_exte ");			
			values.append(", ").append(localMovimientos.getNumeroLote());
		}
		query.append(", val_docu_apli_mes_seri ");			
		values.append(",TO_CHAR(SYSDATE,'MM') ");
			query.append(", val_docu_apli_anio ");			
			values.append(", TO_CHAR(SYSDATE,'YY')");
      
     if (localMovimientos.getNumeroDocumentoAplicacion()!= null) {
			query.append(", val_docu_apli_nume ");			
			values.append(", ").append(localMovimientos.getNumeroDocumentoAplicacion());
		}
        if (localMovimientos.getSerieDocumentoCreacion() != null) {
			query.append(", val_docu_crea_mes_seri ");			
			values.append(", ").append(localMovimientos.getSerieDocumentoCreacion());
		}
        if (localMovimientos.getAnioDocumentoCreacion() != null) {
			query.append(", val_docu_crea_anio ");			
			values.append(", ").append(localMovimientos.getAnioDocumentoCreacion());
		}
        if (localMovimientos.getDigitoChequeo() != null) {
			query.append(", val_digi_cheq_fact ");			
			values.append(", ").append(localMovimientos.getDigitoChequeo());
		}
        if (localMovimientos.getNumeroLote() != null) {
			query.append(", num_lote ");			
			values.append(", ").append(localMovimientos.getNumeroLote());
		}
        if (localMovimientos.getConsecutivoTransaccion() != null) {
			query.append(", num_cons_tran ");			
			values.append(", ").append(localMovimientos.getConsecutivoTransaccion());
		}
        if (localMovimientos.getCodConsultoraReal() != null) {
			query.append(", cod_cons ");			
			values.append(", ").append("'").append(localMovimientos.getCodConsultoraReal()).append("'");
		}
        if (localMovimientos.getCodError() != null) {
			query.append(", cod_erro ");			
			values.append(", ").append("'").append(localMovimientos.getCodError()).append("'");
		}
        if (localMovimientos.getNumeroDocumentoCreacion() != null) {
			query.append(", val_docu_crea_nume ");			
			values.append(", ").append(localMovimientos.getNumeroDocumentoCreacion());
		}
        if (localMovimientos.getIdentificadorProceso() != null) {
			query.append(", cod_iden_proc ");			
			values.append(", ").append("'").append(localMovimientos.getIdentificadorProceso()).append("'");
		}
        if (localMovimientos.getHorario() != null) {
			query.append(", val_hora_norm_adic ");			
			values.append(", ").append("'").append(localMovimientos.getHorario()).append("'");
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
            values.append(", to_date( substr( '" + localMovimientos.getHoraProceso().getTime() + "' , 1, 19) , 'YYYY-MM-DD HH24:MI:SS') ");           
		}
        if (localMovimientos.getFechaContabilizacion() != null) {
			query.append(", fec_conta ");			
            values.append(", to_date( '" + new java.sql.Date(localMovimientos.getFechaContabilizacion().getTime())  + "', 'YYYY-MM-DD') ");           
		}
        if (localMovimientos.getEstatusMovimientoTesoreria() != null) {
			query.append(", val_esta_movi_pend ");			
			values.append(", ").append("'").append(localMovimientos.getEstatusMovimientoTesoreria()).append("'");
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
        query.append(");");
        return query;
       /*StringBuffer xx = new StringBuffer();
        return xx;*/
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
        return dtoResu;
    }
    
    private StringBuffer armarUpdateMovimientoBancario(DTOMovimientoBancario dtoMovimBancario, Integer valDocuApliNume){
      StringBuffer cadena = new StringBuffer();
      cadena.append("UPDATE CCC_MOVIM_BANCA SET VAL_IMPO_MOVI = " + dtoMovimBancario.getImporteMovimiento());
      cadena.append(",IMP_APLI = " + dtoMovimBancario.getImporteAplicado() + " ,IMP_SALD_PEND = " + dtoMovimBancario.getImporteSaldo());
      cadena.append(",SUBP_OID_MARC_ULTI = " + dtoMovimBancario.getOidSubprocesoMarcaUltimo());// + " , NUM_HIST = " + dtoMovimBancario.getNumeroHistoria());
      cadena.append(",FEC_MOVI_APLI = SYSDATE");
      cadena.append(",TCAB_OID_ABON_ULTI = " + dtoMovimBancario.getOidTipoAbonoUltimo());  
      cadena.append(",VAL_ESTA_MOVI_PEND ='"+dtoMovimBancario.getEstatusMovimientoTesoreria().toString()+"' ");
      cadena.append(",VAL_DOCU_APLI_ANIO = TO_CHAR(SYSDATE,'YY')");
      cadena.append(",VAL_DOCU_APLI_MES_SERI = TO_CHAR(SYSDATE,'MM')");
      cadena.append(",VAL_DOCU_APLI_NUME = " + valDocuApliNume.longValue());
      
      if (dtoMovimBancario.getCodigoUsuario() != null) {
        cadena.append(",COD_USUA = '" + dtoMovimBancario.getCodigoUsuario() + "'");
      }
      cadena.append(" WHERE OID_MOVI_BANC = " + dtoMovimBancario.getOid()+";");
      return cadena;
    }
    
    private HashMap recuperarMovimientosCuentaCorriente (ArrayList arrayOidsMCC, HashMap hashAplicar) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append("SELECT * FROM CCC_MOVIM_CUENT_CORRI WHERE OID_MOVI_CC IN (");
      int longArray = arrayOidsMCC.size();
      for (int i =0;i<longArray;i++){
        if (i==0){
            query.append(arrayOidsMCC.get(i)); 
        } else {
            query.append("," + arrayOidsMCC.get(i));
        }
      }
      query.append(") order by OID_MOVI_CC");
      RecordSet rs = null;
      
      rs = this.executeQuery(query.toString());
      
      hashAplicar =  this.generarArrayDtosAplicar(rs, hashAplicar);
      
      return hashAplicar;
    }
    
    private HashMap generarArrayDtosAplicar(RecordSet regsDoc, HashMap hashAplicar) {        
      if (regsDoc != null && !regsDoc.esVacio()){            
          int longRs = regsDoc.getRowCount();
          for (int j=0;j<longRs;j++){                
              DTOMovimientoCuentaCompleto dtoCancelar = (DTOMovimientoCuentaCompleto)hashAplicar.get(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")));
           //   dtoCancelar.setOidPais(this.bigDecimalToLong(regsDoc.getValueAt(j,"PAIS_OID_PAIS")));
              dtoCancelar.setCuentaCuota(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_CUOT")));
              dtoCancelar.setCuentaOrigen(this.bigDecimalToLong(regsDoc.getValueAt(j,"CUCO_OID_CUEN_CONT_ORIG")));
              dtoCancelar.setDivisa(this.bigDecimalToLong(regsDoc.getValueAt(j, "MONE_OID_MONE")));
              dtoCancelar.setDocumentoAnyo(regsDoc.getValueAt(j,"VAL_DOCU_ANIO").toString());
              dtoCancelar.setDocumentoMesSerie((String) regsDoc.getValueAt(j, "VAL_DOCU_MES_SERI"));
              dtoCancelar.setDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_DOCU_NUME")));
              dtoCancelar.setEjercicioCuota((String) regsDoc.getValueAt(j, "VAL_EJER_CUOT"));
              dtoCancelar.setEmpresa(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCI_OID_SOCI")));
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
              dtoCancelar.setIndicaDescuentoRecargo(this.bigDecimalToBoolean(regsDoc.getValueAt(j, "IND_DTO_CARG_APLI")));
              dtoCancelar.setMarca(this.bigDecimalToLong(regsDoc.getValueAt(j, "MARC_OID_MARC")));
              dtoCancelar.setMarcaSituacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"MASI_OID_MARC_SITU")));
              dtoCancelar.setMedioPago(this.bigDecimalToLong(regsDoc.getValueAt(j,"MPAB_OID_MEDI_PAGO")));
              dtoCancelar.setNumeroIdentificadorCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_IDEN_CUOT")));
              dtoCancelar.setNumeroLoteContabilizacion((regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") != null) ? (String) regsDoc.getValueAt(j, "VAL_NUME_LOTE_CONT") : null);
              dtoCancelar.setNumeroLoteFactu(this.bigDecimalToInteger(regsDoc.getValueAt(j,"NUM_LOTE_FACT")));
              dtoCancelar.setNumeroOrdenCuota(this.bigDecimalToInteger(regsDoc.getValueAt(j, "NUM_ORDE_CUOT")));
              
              /* Modificado por Migracion - La columna no existia con ese nombre ni tampoco con el nombre que deberia ser VAL_NUME_SERI_CUOT ---- AL --- 05/10/2008*/
              //dtoCancelar.setNumeroSerieCuota(regsDoc.getValueAt(j,"VAL_NUME_SERI_CUOOT").toString());
              dtoCancelar.setNumeroSerieCuota(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")).toString());
              /* Modificado por Migracion - La columna no existia con ese nombre ni tampoco con el nombre que deberia ser VAL_NUME_SERI_CUOT ---- AL --- 05/10/2008*/
              
              dtoCancelar.setObservaciones((regsDoc.getValueAt(j,"VAL_OBSE") != null) ? (String) regsDoc.getValueAt(j, "VAL_OBSE") : null); //nullable
              dtoCancelar.setOid(this.bigDecimalToLong(regsDoc.getValueAt(j, "OID_MOVI_CC")));
              dtoCancelar.setOidCliente(this.bigDecimalToLong(regsDoc.getValueAt(j, "CLIE_OID_CLIE")));
              dtoCancelar.setOidMoneda(this.bigDecimalToLong(regsDoc.getValueAt(j,"MONE_OID_MONE")));
              dtoCancelar.setOidPedidoSolicitudCab(this.bigDecimalToLong(regsDoc.getValueAt(j, "SOCA_OID_SOLI_CABE")));
              dtoCancelar.setOidRegion(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZORG_OID_REGI")));
              dtoCancelar.setOidSeccion(this.bigDecimalToLong(regsDoc.getValueAt(j, "ZSCC_OID_SECC")));
              dtoCancelar.setOidSubtipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"SBTI_OID_SUBT_CLIE")));
              dtoCancelar.setOidSugerenciaVenta(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZSGV_OID_SUBG_VENT")));
              dtoCancelar.setOidTipoDocumentoLegal(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIDO_OID_TIPO_DOCU")));
              dtoCancelar.setOidTipoSolicitud(this.bigDecimalToLong(regsDoc.getValueAt(j,"TSPA_OID_TIPO_SOLI_PAIS")));
              dtoCancelar.setPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j, "PERD_OID_PERI")));
              dtoCancelar.setReferenciaNumeroDocumentoExterno((regsDoc.getValueAt(j, "VAL_REFE_NUME_DOCU_EXTE") != null) ? (String) regsDoc.getValueAt(j,"VAL_REFE_NUME_DOCU_EXTE") : null); //nullable
              dtoCancelar.setSubacceso(this.bigDecimalToLong(regsDoc.getValueAt(j, "SBAC_OID_SBAC")));
              dtoCancelar.setSubprocesoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_CREA")));
              dtoCancelar.setSubprocesoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"SUBP_OID_SUBP_ULTI")));
              dtoCancelar.setTerritorioAdministrativo(this.bigDecimalToLong(regsDoc.getValueAt(j,"ZTAD_OID_TERR_ADMI")));
              dtoCancelar.setTipoAbonoCreacion(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_CREA")));
              dtoCancelar.setTipoAbonoUltimo(this.bigDecimalToLong(regsDoc.getValueAt(j,"TCAB_OID_TCAB_ULTI")));
              dtoCancelar.setTipoCambio((BigDecimal) regsDoc.getValueAt(j, "IND_TIPO_CAMB"));
              dtoCancelar.setTipoCliente(this.bigDecimalToLong(regsDoc.getValueAt(j,"TICL_OID_TIPO_CLIE")));
              dtoCancelar.setTipoPeriodoDesde(this.bigDecimalToLong(regsDoc.getValueAt(j,"TIPE_OID_TIPO_PERI")));
              dtoCancelar.setUltimoDocumentoAnyo((regsDoc.getValueAt(j,"VAL_ULTI_DOCU_ANIO") != null) ? (String) regsDoc.getValueAt(j, "VAL_ULTI_DOCU_ANIO") : null); //nullable
              dtoCancelar.setUltimoDocumentoMesSerie((regsDoc.getValueAt( j, "VAL_ULTI_DOCU_MES_SERI") != null) ? (String) regsDoc.getValueAt(j,"VAL_ULTI_DOCU_MES_SERI") : null); //nullable
              dtoCancelar.setUltimoDocumentoNumero(this.bigDecimalToInteger(regsDoc.getValueAt(j, "VAL_ULTI_DOCU_NUME")));
              dtoCancelar.setUltimoNumeroHistoria(this.bigDecimalToInteger(regsDoc.getValueAt(j,"VAL_ULTI_NUME_HIST")));
          }
      }
      return hashAplicar;
    }
    
  /*  private void putOnHash(HashMap leHas, RecordSet registros) {
        int largoRS = 0;
        largoRS = registros.getRowCount();
        if (largoRS > 0) {
            for (int i = 0; i < largoRS; i++){
                DTOAbonoSubprocesoMarcaSituacion  dtoAbonSubMarSitu = new DTOAbonoSubprocesoMarcaSituacion();
                
                dtoAbonSubMarSitu.setOid(this.bigDecimalToLong(registros.getValueAt(i,"oid")));
                dtoAbonSubMarSitu.setOidTipoSolicitud(this.bigDecimalToLong(registros.getValueAt(i,"oidTipoSoli")));
                dtoAbonSubMarSitu.setOidProcesoCreacionCtas(this.bigDecimalToLong(registros.getValueAt(i,"oidProcesoCreacionCtas")));
                dtoAbonSubMarSitu.setCodigoProcesoCrea(registros.getValueAt(i,"codProceso").toString());
                dtoAbonSubMarSitu.setOidSubprocesoCreacionCtas(this.bigDecimalToLong(registros.getValueAt(i,"oidSubprocesoCreacionCtas")));
                dtoAbonSubMarSitu.setCodigoSubprocesoCrea(registros.getValueAt(i,"codSubproceso").toString());
                dtoAbonSubMarSitu.setOidCtaCteBancaria(this.bigDecimalToLong(registros.getValueAt(i,"oidCtaCteBancaria")));
                
                leHas.put(dtoAbonSubMarSitu.getOidTipoSolicitud(), dtoAbonSubMarSitu);
                
            }
        }    
    }
  */
  private int ultimoNumeroLineaEnDetalle(Long oidCabeceraCAD) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.ultimoNumeroLineaEnDetalle(Long oidCabeceraCAD): Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer(120);
        int resu = 0;
        
        query.append(" SELECT NVL(MAX(CCC.NUM_LINE), 0) AS MAX ");
        query.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC CCC ");
        query.append(" WHERE CCC.CCAD_OID_CABE_CARG = " + oidCabeceraCAD.longValue());
         
        rs = this.executeQuery(query.toString());
        if (rs!= null && ! rs.esVacio()){
            resu = this.bigDecimalToLong(rs.getValueAt(0,"MAX")).intValue();       
        }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.ultimoNumeroLineaEnDetalle(Long oidCabeceraCAD): Salida");
        return resu;
  }

  private int ultimoNumeroLineaEnDetalleMas(Long oidCabeceraCAD) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.ultimoNumeroLineaEnDetalleMas(Long oidCabeceraCAD): Entrada");
        RecordSet rs;
        StringBuffer query = new StringBuffer(150);
        int resu = 0;
        
        query.append(" (SELECT NVL(MAX(CCC.NUM_LINE), 0) + 1 AS MAX ");
        query.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC CCC ");
        query.append(" WHERE CCC.CCAD_OID_CABE_CARG = " + oidCabeceraCAD.longValue());
        query.append(" )");
         
        rs = this.executeQuery(query.toString());
        if (rs!= null && ! rs.esVacio()){
            resu = this.bigDecimalToLong(rs.getValueAt(0,"MAX")).intValue();       
        }
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.ultimoNumeroLineaEnDetalleMas(Long oidCabeceraCAD): Salida");
        return resu;
  }

    /**
     * realiza la insercion en la tbla de cargo de abono en ssicc
     * @param dtoMovimientoCuentaCompleto
     * @param oid
     * @param dtoCancelar
     * @param usuario
     */
    private void insertarCargoAbono(DTOMovimientoCuentaCompleto dtoMovimientoCuentaCompleto, 
                                    Long oidSubproceso, 
                                    DTOMovimientoCuentaCompleto dtoCancelar, 
                                    String usuario) throws MareException {
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.insertarCargoAbono(): Entrada");
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append("INSERT INTO CCC_APLIC_ABONO_CARGO( CCAD_OID_CABE_CARG,"); 
        query.append("  SUBP_OID_SUBP_APLI,");
        query.append("  MVCC_OID_MOVI_CARG,");
        query.append("  MVCC_OID_MOVI_ABON,");
        query.append("  CMBA_OID_MOVI_BANC,");
        query.append("  CLIE_OID_CLIE,");
        query.append("  IMP_ABON,");
        query.append("  FEC_PROC,");
        query.append("  FEC_APLI,");
        query.append("  USU_CREA,");
        query.append("  FEC_CREA,");
        query.append("  USU_MODI,");
        query.append("  FEC_MODI )");
        query.append("VALUES(?,?,?,?,NULL,?,?,SYSDATE, trunc(sysdate),?,SYSDATE,NULL,NULL)");        
        parametros.add(dtoMovimientoCuentaCompleto.getOidCargoAbono());
        parametros.add(oidSubproceso);
        parametros.add(dtoCancelar.getOid());        
        parametros.add(dtoMovimientoCuentaCompleto.getOid());
        parametros.add(dtoMovimientoCuentaCompleto.getOidCliente());
        parametros.add(dtoCancelar.getImporteMovimiento());
        parametros.add(usuario);
        try {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executePreparedUpdate(query.toString(),parametros);        
        } catch (Exception e){        
          UtilidadesLog.error("insertarCargoAbono: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }                                          
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.insertarCargoAbono(): Salida");                               
    }

    /**
     * realiza la insercion en la tbla de cargo de abono en ssicc
     * @param dtoMovimientoCuentaCompleto
     * @param long1 
     * @param dtoCancelar
     * @param usuarioActual
     * @throws MareException
     */
    private void insertarCargoAbonoBancario(DTOMovimientoCuentaCompleto dtoMovimientoCuentaCompleto, 
                                            Long oidSubproceso, 
                                            DTOMovimientoBancario dtoCancelar, 
                                            String usuarioActual) throws MareException {
                                            
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.insertarCargoAbono(): Entrada");                                            
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append("INSERT INTO CCC_APLIC_ABONO_CARGO( CCAD_OID_CABE_CARG,"); 
        query.append("  SUBP_OID_SUBP_APLI,");
        query.append("  MVCC_OID_MOVI_CARG,");
        query.append("  MVCC_OID_MOVI_ABON,");
        query.append("  CMBA_OID_MOVI_BANC,");
        query.append("  CLIE_OID_CLIE,");
        query.append("  IMP_ABON,");
        query.append("  FEC_PROC,");
        query.append("  FEC_APLI,");
        query.append("  USU_CREA,");
        query.append("  FEC_CREA,");
        query.append("  USU_MODI,");
        query.append("  FEC_MODI )");
        query.append("VALUES(?,?,?,NULL,?,?,?,SYSDATE, trunc(sysdate),?,SYSDATE,NULL,NULL)");        
        parametros.add(dtoMovimientoCuentaCompleto.getOidCargoAbono());
        parametros.add(oidSubproceso);        
        parametros.add(dtoMovimientoCuentaCompleto.getOid());
        parametros.add(dtoCancelar.getOid());        
        parametros.add(dtoMovimientoCuentaCompleto.getOidCliente());
        parametros.add(dtoCancelar.getImporteMovimiento());
        parametros.add(usuarioActual);
        try {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executePreparedUpdate(query.toString(),parametros);        
        } catch (Exception e){        
          UtilidadesLog.error("insertarCargoAbono: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }                                                                                      
        UtilidadesLog.info("MONCuentasCorrientesPerfBean.insertarCargoAbono(): Salida");                                            
    }
    
    // sapaza -- PER-SiCC-2011-0246  -- 05/04/2011
    private void aplicarAbonosCargosCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOCCC.aplicarAbonosCargosCliente(Long oidCliente): Entrada");
         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
           bs.dbService.executeProcedure("CCC_PKG_PROCE.CCC_PR_APLIC_ABONO_CARGO_CLIEN", oidCliente.toString());
        } catch (Exception e) {
           String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCCC.aplicarAbonosCargosCliente(Long oidCliente): Salida");
    }
    
}
