package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTAccesos;
import es.indra.sicc.dtos.intsys.DTOINTAptaCurso;
import es.indra.sicc.dtos.intsys.DTOINTBoletasDespacho;
import es.indra.sicc.dtos.intsys.DTOINTCampania;
import es.indra.sicc.dtos.intsys.DTOINTCampaniaAnio;
import es.indra.sicc.dtos.intsys.DTOINTCliente;
import es.indra.sicc.dtos.intsys.DTOINTCobranza;
import es.indra.sicc.dtos.intsys.DTOINTCurso;
import es.indra.sicc.dtos.intsys.DTOINTDatosConsultora;
import es.indra.sicc.dtos.intsys.DTOINTEmpresa;
import es.indra.sicc.dtos.intsys.DTOINTEstatusCliente;
import es.indra.sicc.dtos.intsys.DTOINTEstatusZona;
import es.indra.sicc.dtos.intsys.DTOINTGerente; 
import es.indra.sicc.dtos.intsys.DTOINTHijaDupla;
import es.indra.sicc.dtos.intsys.DTOINTInfoCampania;
import es.indra.sicc.dtos.intsys.DTOINTLider;
import es.indra.sicc.dtos.intsys.DTOINTMatrizCampania;
import es.indra.sicc.dtos.intsys.DTOINTProductoReemplazo;
import es.indra.sicc.dtos.intsys.DTOINTRegionCerrada;
import es.indra.sicc.dtos.intsys.DTOINTRegiones;
import es.indra.sicc.dtos.intsys.DTOINTSecciones;
import es.indra.sicc.dtos.intsys.DTOINTTipoOferta;
import es.indra.sicc.dtos.intsys.DTOINTTxCliente;
import es.indra.sicc.dtos.intsys.DTOINTUnidadGeografica;
import es.indra.sicc.dtos.intsys.DTOINTUnidadGeograficaCampania;
import es.indra.sicc.dtos.intsys.DTOINTZona;
import es.indra.sicc.dtos.intsys.DTOINTZonasRealesPorRegion;
import es.indra.sicc.dtos.intsys.DTOCambiosTerritorio;
import es.indra.sicc.dtos.intsys.DTOCambiosZON;
import es.indra.sicc.dtos.intsys.DTOCodigosZON;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.ccc.IServiceCCC;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosBean;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.zon.DatoRegistro;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.intsys.DTODAT32;
import java.util.Iterator;
import java.util.Collection;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialDAT;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import java.util.HashMap;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

// SPLATAS - PERFORMANCE(06/12/2006)
import es.indra.sicc.dtos.intsys.DTOINTEstatusCliente2;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONINTDATBean implements SessionBean  {

    private DTOINTCargaInicialDAT dtoe =null;   
    private RegistroSicc registro = new RegistroSicc();
    private InterfazInfo interfaz =null;    
    private MONGestorInterfaces gi=null; 
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

    public DTOSalidaBatch enviarTiposCurso(DTOBatch dtoBatch) throws MareException {
            UtilidadesLog.info("MONINTDATBean.enviarTiposCurso(DTOBatch dtoBatch): Entrada");
            String codigo = IDAT.COD_INTERFAZ_DAT30;
            UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiposCurso  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);

            
            try{        
                init( dtoBatch, codigo );
            }catch(MareException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTiposCurso ");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            } 

           
            String usuario = ctx.getCallerPrincipal().getName();
            DAOINTDAT dao =new DAOINTDAT(usuario);
            DTOConsultaCurso dtoCurso =null;
          
            
            ArrayList cursos = dao.obtenerTiposCurso( this.dtoe.getOidPais(),  this.dtoe.getMarca(),  this.dtoe.getOidIdioma());
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
             /*if(cursos.isEmpty()){//BELC300015312
                  String mensaje = "enviarTiposCursoFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            int n=cursos.size();
            for (int i=0 ;i<n ;i++ ) {
                 dtoCurso =(DTOConsultaCurso)cursos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO a ingresar dtoCurso "+ dtoCurso);    
                    try{
                            registro.vaciar();
                            
                            registro.anyadirCampo( IDAT.DAT30_CODIGO_TIPO_CURSO, dtoCurso.getCodigo() ); 
                            registro.anyadirCampo( IDAT.DAT30_DESCRIPCION_TIPO_CURSO, dtoCurso.getNombre());
                            // Cambio SiCC 20070511 - dmorello
                            registro.anyadirCampo(IDAT.DAT30_TIPO_CURSO, "");
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              
                              }
                          //Añadido incidencia 13120
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposCurso  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
            
          
            UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiposCurso  ---->SALIDA ");
            UtilidadesLog.info("MONINTDATBean.enviarTiposCurso(DTOBatch dtoBatch): Salida");
            return new DTOSalidaBatch( 0, "InterfazDAT30 Procesada" );
    }

    public DTOSalidaBatch enviarGenericoDatamart(DTOINTCargaInicialDAT dtoe) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarGenericoDatamart(DTOINTCargaInicialDAT dtoe): Entrada");
        UtilidadesLog.debug(" MONINTDAT:enviarGenericoDatamart  ---->Entrada \n\n\ndtoe  " +dtoe );
        /* agregado por cnoziglia Inc 20081 
         * Se modifica MOINTDAT.enviarGenericoDatamart() y se agrega la validación entre la fechaFacturacion y
           periodoFacturacion. El nuevo código va al comienzo del método:
           ....
           periodo = Obtener la entidad CRA_PERIODOS por el oid dteo.periodoFacturacion

           Si ( ! (periodo.fechaInicio <= dtoe.fechaFacturacion && periodo.fechaFin >= dtoe.fechaFacturacion)) {
           Arrojar una excepcion ya que la fecha de facturación no corresponde al período seleccionado.
           }*/
   
        PeriodoLocalHome periodoCraLocalHome= this.getPeriodoLocalHome();
        PeriodoLocal periodo = null;
        try{
            periodo = periodoCraLocalHome.findByPrimaryKey(dtoe.getPeriodoFacturacion());
        }catch(NoResultException fe){
              throw new MareException("FinderException EN procesarInterfaz PeriodoCorporativo ", fe);               
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        java.sql.Date fFactura =new java.sql.Date(dtoe.getFechaFacturacion().getTime());
        
        UtilidadesLog.debug("SCS fFactura: " + fFactura);
        UtilidadesLog.debug("SCS periodo.getFechainicio(): " + periodo.getFechainicio());
        UtilidadesLog.debug("SCS periodo.getFechaFin(): " + periodo.getFechaFin());
        
         if (! ((periodo.getFechainicio().getTime() <= fFactura.getTime()) && (periodo.getFechaFin().getTime() >= fFactura.getTime())) )
        {
                UtilidadesLog.debug("la fecha no corrsponde con el periodo tirar excepcion");
                int codigoerr = UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                    ErroresDeNegocio.INT_0089);
                UtilidadesLog.debug("La fecha de facturacion esta fuera del periodo lanza "+codigoerr );
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                    ErroresDeNegocio.INT_0089 ));           
        }
        
        //  Modificador por HRCS - Fecha 18/04/2007 - Cambio Sicc20070215
        try {
            String usuario = ctx.getCallerPrincipal().getName();
            DAOINTDAT dao =new DAOINTDAT(usuario);
            RecordSet procesos = dao.obtenerProcesosInterfacesParaEnviar( dtoe.getCodigosEnviar() );
            Vector v = procesos.getRecords();
            for(int j=0; j<v.size(); j++) {
                
                String codigo = (String)procesos.getValueAt(j,0);
                String descrip = (String)procesos.getValueAt(j,1);
                String codProc = (String)procesos.getValueAt(j,2);
                String idBusiness = (String)procesos.getValueAt(j,3);
                UtilidadesLog.debug("Por enviar: "+codigo + " - " + codProc + " - " + idBusiness );
                
                DTOBatch dtoBatch = null;
                dtoBatch = new DTOBatch( codProc, new MareBusinessID( idBusiness ),dtoe ) ;
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ); 
                UtilidadesLog.debug("enviado " + codProc );
            }
        }
        catch(RemoteException re)   {
            UtilidadesLog.debug("Error RemoteException enviarGenericoDatamart");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
            
         UtilidadesLog.info("MONINTDATBean.enviarGenericoDatamart(DTOINTCargaInicialDAT dtoe): Salida");
         return new DTOSalidaBatch( 0, "EnviarGDatamart ejecutado" );
    }

    public DTOSalidaBatch enviarTablaClientes(DTOBatch dtoBatch) throws MareException {
            UtilidadesLog.info("MONINTDATBean.enviarTablaClientes(DTOBatch dtoBatch): Entrada");
            String codigo = IDAT.COD_INTERFAZ_DAT2;
            String pathArchivo = null;
            String nombreArchivo = null;
            InterfazDef def  = null;
            UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTablaClientes  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);
            try{        
               init( dtoBatch, codigo );
               def = es.indra.sicc.cmn.negocio.interfaces.RegistroDefs.obtenerInterfaz( IDAT.COD_INTERFAZ_DAT2 );
               UtilidadesLog.debug("def: "+def);
               if(def != null){
                  pathArchivo = def.getPathBuzonES();
                  if(pathArchivo.endsWith(System.getProperty("file.separator"))){
                     pathArchivo = pathArchivo.substring(0,pathArchivo.length()-1);
                  }
                  String descLote = ((DTOINTCargaInicialDAT)dtoBatch.getDTOOnline()).getNumeroLote();
                  nombreArchivo = IDAT.COD_INTERFAZ_DAT2+"_"+descLote+"."+def.getExtension();
               }
               UtilidadesLog.debug("-GA- nombreArchivo: "+nombreArchivo);
               UtilidadesLog.debug("-GA- pathArchivo: "+pathArchivo);
               
            }catch(InterfacesException ie){
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al la definicion de la interfaz en enviarTablaClientes");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            }
            interfaz.setPeriodo(dtoe.getPeriodoFacturacion());
            
            String usuario = ctx.getCallerPrincipal().getName();
            DAOINTDAT dao =new DAOINTDAT(usuario);
            Date ultimaFecha = dao.obtenerUltimaFecha( dtoe.getOidPais(), IDAT.COD_INTERFAZ_DAT2 ); 


           //Gacevedo: Se modifica el proceso de esta interfaz en base a la incidencia tecnica
           //GENINTDAT-01/DAT-02. Basicamente, se quita el proceso de registros y se arma un sql
           //que obtenga la data y grabe el archivo de salida.

           //jrivas 23/1/2007 Se le agrega un parametro para la inserción en INT_HISTO_LOTES
           dao.obtenerTablaClientes( dtoe.getOidPais(), dtoe.getMarca(), 
                                     dtoe.getCanal(), ultimaFecha, dtoe.getOidIdioma(),
                                     pathArchivo, nombreArchivo, interfaz);
           
           /*ArrayList consultoras = dao.obtenerTablaClientes( dtoe.getOidPais(), dtoe.getMarca(), dtoe.getCanal(), ultimaFecha, dtoe.getOidIdioma());
            int n=consultoras.size();
            for (int i=0 ;i<n ;i++ ) {
                 DTOINTDatosConsultora  dto=(DTOINTDatosConsultora)consultoras.get(i);
                    
                    try{
                        // Incidencia 15436
                        registro.vaciar();
                        
                        //pzerbino 2/11/2006
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_CONSULTORA, dto.getCodigoConsultora() ); 
                        int valor = dto.getCodigoConsultora().length();
                        if (valor >= 10){
                              registro.anyadirCampo( IDAT.DAT2_CODIGO_CONSULTORA, dto.getCodigoConsultora().substring(valor-10,valor) ); 
                        }else {
                              registro.anyadirCampo( IDAT.DAT2_CODIGO_CONSULTORA, dto.getCodigoConsultora()); 
                        }                      
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_TERRITORIO, dto.getCodigoTerritorio() ) ;
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_APELLIDOS_NOMBRE, this.componerNombre( dto.getNombre1Consultora(), dto.getNombre2Consultora(),  dto.getApellido1Consultora(), dto.getApellido2Consultora() ) ); 
                        registro.anyadirCampo( IDAT.DAT2_NOMBRE, dto.getNombre1Consultora()+" "+dto.getNombre2Consultora()); 
                        registro.anyadirCampo( IDAT.DAT2_APELLIDO_PATERNO, dto.getApellido1Consultora() );//dto.getApellidoPaterno() ); 
                        registro.anyadirCampo( IDAT.DAT2_APELLIDO_MATERNO, dto.getApellido2Consultora() );//dto.getApellidoMaterno() ); 
                        registro.anyadirCampo( IDAT.DAT2_NIVEL_SOCIOECONOMICO, dto.getNSE() ); 
                        registro.anyadirCampo( IDAT.DAT2_ANYO_CAMPANYA_INGRESO, dto.getAnioCampaniaIngreso() ); 
                        registro.anyadirCampo( IDAT.DAT2_FECHA_NACIMIENTO, dto.getFechaNacimiento()); 
                        registro.anyadirCampo( IDAT.DAT2_ESTADO_CIVIL, dto.getEstadoCivil() ) ;
                        
                        
                        
                        MONInterfaceModulos monInterfacesModulos=this.getMONInterfaceModulos();
                        String total;
                        
                        try{
                              total = monInterfacesModulos.calcularSaldosCuentaCorriente(dtoe.getOidPais(), dto.getOidConsultora());
                         
                        }catch (RemoteException re){                        
                                UtilidadesLog.debug("Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        
                        registro.anyadirCampo( IDAT.DAT2_DEUDA_EN_BANCO, total);                       
                        
                        //--Paola Cabrera
                        //-- 10/11/2005
                        //--fin modificacion por inc 21163
                        
                        
                        registro.anyadirCampo( IDAT.DAT2_ANYO_CAMPANYA_ULTIMO_PEDIDO, dto.getAnioCampaniaUltimoPedido() ) ;                        
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_COSMETICOS, new String() );
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_ACCESORIOS, new String() );
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_SM, new String() );
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_REGALABLES, new String() );
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_HOGAR, new String() );
                        registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA, dto.getIndicadorEstrella() ) ;
       //15296          //registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_COSMETICOS, dto.getIndicadorEstrellaCosmeticos() );
                        //registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_ACCESORIOS, dto.getIndicadorEstrellaAccesorios() ); 
                        //registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_SM, dto.getIndicadorEstrellaSM() ); 
                        //registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_REGALABLES, dto.getIndicadorEstrellaRegalables() ); 
                        //registro.anyadirCampo( IDAT.DAT2_ES_ESTRELLA_HOGAR, dto.getIndicadorEstrellaHogar() ) ;
                        registro.anyadirCampo( IDAT.DAT2_CONSULTORA_TERRITORIAL, dto.getIndicadorConsultoraTerritorial() ); 
                        
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_ULTIMO_TIPO_CURSO_RECIBIDO, dto.getCodigoUltimoTipoCursoRecibido() ); 
                        registro.anyadirCampo( IDAT.DAT2_TIPO_DOCUMENTO_IDENTIDAD, dto.getTipoDocumentoIdentidad() );          
                        registro.anyadirCampo( IDAT.DAT2_NUMERO_DOCUMENTO_IDENTIDAD, dto.getNumeroDocumentoIdentidad() ); 
                        registro.anyadirCampo( IDAT.DAT2_CONSULTORA_ACTIVA, dto.getIndicadorActiva() ); 
                        registro.anyadirCampo( IDAT.DAT2_ESTATUS_VENTA_VIGENTE, dto.getEstatusVentaVigente() ) ;
                        registro.anyadirCampo( IDAT.DAT2_ESTATUS_CORPORATIVO, dto.getEstatusCorporativoEquivalente() ) ; //duas del nombre del dto?
                        registro.anyadirCampo( IDAT.DAT2_TELEFONO, dto.getTelefono() ); 
                        registro.anyadirCampo( IDAT.DAT2_TELEFONO_TRABAJO, dto.getTelefonoTrabajo() ) ;  
                        
                        //--Se cambia el orden en que saldra el archivo
                        //--Paola Cabrera
                        //--07/10/2005
                        registro.anyadirCampo( IDAT.DAT2_DIRECCION, dto.getDireccion() );
                        registro.anyadirCampo( IDAT.DAT2_NOMBRE_DEPARTAMENTO, dto.getNombreDepartamento() ) ;
                        registro.anyadirCampo( IDAT.DAT2_PROVINCIA, dto.getProvincia() ) ;
                        registro.anyadirCampo( IDAT.DAT2_DISTRITO, dto.getDistrito() ); 
                        //--Fin 
                      
                        
                        registro.anyadirCampo( IDAT.DAT2_FLAG_SELECT, dto.getFlagSelect() ); 
                        registro.anyadirCampo( IDAT.DAT2_CAMPANYA_PROMOCION, dto.getCampaniaPromocion() );
                        registro.anyadirCampo( IDAT.DAT2_META_SELECT, new String());//incidencia
                        registro.anyadirCampo( IDAT.DAT2_DESCRIPCION_TIPO_CENTRO_POBLADO, dto.getDescripcionTipocentroPoblado() ); 
                        registro.anyadirCampo( IDAT.DAT2_DESCRIPCION_CENTRO_POBLADO, dto.getDescripcionCentroPoblado() ); 
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_TIPO_CENTRO_POBLADO, dto.getCodigoTipoCentroPoblado() );
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_CENTRO_POBLADO, dto.getCodigoCentroPoblado() );
                        registro.anyadirCampo( IDAT.DAT2_NOMBRE_LIDER, this.componerNombre( dto.getNombre1Lider(), dto.getNombre2Lider(),  dto.getApellido1Lider(), dto.getApellido2Lider() ) );
                        
                       // eLIMINADO POR 15296 registro.anyadirCampo( IDAT.DAT2_CODIGO_UBICACION_GEOGRAFICA, dto.getCodigoUbigeo() ); 
                        //AÑADIDOS UBIGUEOS POR 15296
                        //Eliminados por BELC300018338 
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO1, dto.getOrden1() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO2, dto.getOrden2() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO3, dto.getOrden3() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO4, dto.getOrden4() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO5, dto.getOrden5() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO6, dto.getOrden6() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO7, dto.getOrden7() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO8, dto.getOrden8() );
                        //registro.anyadirCampo( IDAT.DAT2_CODIGO_UBIGEO9, dto.getOrden9() );
                        
                        registro.anyadirCampo(IDAT.DAT2_CODIGO_UBIGEO1,
                                                this.componerUbigeo(dto.getOrden1(),
                                                                    dto.getOrden2(),
                                                                    dto.getOrden3(), 
                                                                    dto.getOrden4(),
                                                                    dto.getOrden5(),
                                                                    dto.getOrden6(),
                                                                    dto.getOrden7(),
                                                                    dto.getOrden8(),
                                                                    dto.getOrden9()));
                       
                        registro.anyadirCampo( IDAT.DAT2_ES_LIDER, dto.getIndicadorLider() ); 
                        registro.anyadirCampo( IDAT.DAT2_ES_GERENTE_ZONA, dto.getIndicadorGerenteZona() ); 
                        registro.anyadirCampo( IDAT.DAT2_ES_GERENTE_REGION, dto.getIndicadorGerenteRegion() ); 
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_CONSULTORA_RECOMENDO, dto.getCodigoConsultoraRecomendante() ); 
                        registro.anyadirCampo( IDAT.DAT2_PERTENECE_CLUB_ELITE, dto.getIndicadorPerteneceClubElite() ); 
                        registro.anyadirCampo( IDAT.DAT2_ACTIVA_CLUB_ELITE, dto.getIndicadorActivaClubElite() ); 
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_FUENTE_INGRESO, dto.getCodigoFuenteIngreso() ); 
                        registro.anyadirCampo( IDAT.DAT2_CODIGO_ANTERIOR, dto.getCodigoAnterior() ); 
                        registro.anyadirCampo( IDAT.DAT2_NOMBRE_SEGMENTO, new String() );// Incidencia BELC300015436
                        registro.anyadirCampo( IDAT.DAT2_FLAG_TIPO_ACCION, dto.getFlagTipoAccion()); //incidencia 15296

                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                                UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              
                              }
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposCurso  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
            
       */
          UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTablaClientes  ---->SALIDA ");
          UtilidadesLog.info("MONINTDATBean.enviarTablaClientes(DTOBatch dtoBatch): Salida");
          return new DTOSalidaBatch( 0, "Interfaz DAT2 Procesada" );       
    }

    public DTOSalidaBatch enviarEmpresas(DTOBatch dtoBatch) throws MareException {
         UtilidadesLog.info("MONINTDATBean.enviarEmpresas(DTOBatch dtoBatch): Entrada");
         String codigo = IDAT.COD_INTERFAZ_DAT3;
         UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarEmpresas  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);
            UtilidadesLog.debug("======== Usuario BATCH  =====================");
            UtilidadesLog.debug(dtoBatch.getUser());
            UtilidadesLog.debug("======== Usuario BATCH  =====================");
            try{        
                init( dtoBatch, codigo );
            }catch(MareException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarEmpresas ");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            } 


            DTOINTCargaInicialDAT dtoe= null;
            String usuario = ctx.getCallerPrincipal().getName();
            UtilidadesLog.debug("++++++ setSessionContext en enviarEmpresas++++: " + ctx.getCallerPrincipal().getName());
             DAOINTDAT dao =new DAOINTDAT(usuario);
           ArrayList empresas = dao.obtenerEmpresas( this.dtoe.getOidPais(),  this.dtoe.getOidIdioma());
           
           // vbongiov -- 18/10/2006 -- DBLG700000156
           /* if(empresas.isEmpty()){//BELC300015312
                  String mensaje = "EmpresasFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            int n=empresas.size();
            for (int i=0 ;i<n ;i++ ) {
                 DTOINTEmpresa  dtoEmpresa=(DTOINTEmpresa)empresas.get(i);
                    
                    try{
                            registro.vaciar();
                            
                            registro.anyadirCampo( IDAT.DAT3_CODIGO_EMPRESA, dtoEmpresa.getCodigoEmpresa() ); //aquí se introduciran 50 espacios. 
                            registro.anyadirCampo( IDAT.DAT3_DESCRIPCION_EMPRESA, dtoEmpresa.getDescripcion());
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                                  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              
                              }
                          
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposCurso  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
            
       
           UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarEmpresas  ---->SALIDA ");
           UtilidadesLog.info("MONINTDATBean.enviarEmpresas(DTOBatch dtoBatch): Salida");
           return new DTOSalidaBatch( 0, "Interfaz DAT3 Procesada" ); 
    }

    public DTOSalidaBatch enviarFechaProceso(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarFechaProceso(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT4; 
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarFechaProceso  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);


        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarFechaProceso ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        CanalLocal canalLocal = null;
        CanalLocalHome canalLocalHome = this.getCanalLocalHome();
        
        //añadido por incidencia 20298
        PeriodoLocal periodoCra = null;
        PeriodoLocalHome periodoCraLocalHome= this.getPeriodoLocalHome();
        
        PeriodoCorporativoLocal periodoCorporativoLocal = null;
        PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();        
        try{ 
            try{
                canalLocal = canalLocalHome.findByPrimaryKey(this.dtoe.getCanal());
                    UtilidadesLog.debug(" [ "+codigo+" ] HEMOS ENCONTRADO EL FINDER EN CANAL");
            }catch(NoResultException fe){
                DTOINTError dtoError = new DTOINTError( this.interfaz, null, ErroresDeNegocio.INT_0010 + "Canal" );
                this.gi.registrarError(dtoError);
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 
    
            try{
                //añadido y modificado por incidencia 20298
                periodoCra=periodoCraLocalHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
                
                UtilidadesLog.debug("periodoCra.getOidPeriodoCorporativo(): " + periodoCra.getOidPeriodoCorporativo());
                periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoCra.getOidPeriodoCorporativo());
                
                UtilidadesLog.debug(" [ "+codigo+" ] HEMOS ENCONTRADO EL FINDER EN periodoCorporativoLocal");
            }catch(NoResultException fe){
                DTOINTError dtoError = new DTOINTError( this.interfaz, null, ErroresDeNegocio.INT_0010 + "Periodo" );
                this.gi.registrarError(dtoError);
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 

            //registro = new RegistroSicc();
            registro.vaciar();
            
            registro.anyadirCampo( IDAT.DAT4_CODIGO_CANAL_VENTA, canalLocal.getCodCanal() );
            UtilidadesLog.debug("periodoCorporativoLocal.getCodigoPeriodo() " + periodoCorporativoLocal.getCodigoPeriodo());             
            registro.anyadirCampo( IDAT.DAT4_ANYO_CAMPANYA_FACTURACION, periodoCorporativoLocal.getCodigoPeriodo() );
            
            if (dtoe.getFechaFacturacion()!=null){
                registro.anyadirCampo(  IDAT.DAT4_FECHA_PROCESO_FACTURACION, dtoe.getFechaFacturacion() );
            }else{
                registro.anyadirCampo( IDAT.DAT4_FECHA_PROCESO_FACTURACION, null );                
            }
            gi.anyadirRegistro( this.interfaz, registro );
            gi.enviarInterfaz( this.interfaz );
            
        } catch( InterfacesException iex ) { 
            //- se registra la excepción con el servicio MareLogging             
            UtilidadesLog.debug(" [ "+codigo+" ] Ha saltado una InterfacesException ");
        } catch( RemoteException re ) { 
            //- se registra la excepción con el servicio MareLogging             
            UtilidadesLog.debug(" [ "+codigo+" ] Ha saltado una RemoteException ");
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarFechaProceso  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarFechaProceso(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz DAT4 Procesada" );
    }

    public DTOSalidaBatch enviarUnidadesGeograficas(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarUnidadesGeograficas(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT5;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarUnidadesGeograficas  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);

        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarUnidadesGeograficas ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTUnidadGeografica dtoUG = null;
        String usuario = ctx.getCallerPrincipal().getName();
        UtilidadesLog.debug("++++++ setSessionContext en enviarUnidadesGeograficas++++: " + ctx.getCallerPrincipal().getName());
        DAOINTDAT dao =new DAOINTDAT(usuario);

        ArrayList unidades = dao.obtenerUnidadesGeograficas( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal());
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if(unidades.isEmpty()){//BELC300015312
              String mensaje = "UsdGeograficasFin SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
        
        int n=unidades .size();
        for (int i=0 ;i<n ;i++ ) {
            dtoUG = (DTOINTUnidadGeografica)unidades.get(i);
             
             registro.vaciar();
             
            try{
                if (dtoUG.getCodigoTerritorio()!=null){
                    registro.anyadirCampo( IDAT.DAT5_CODIGO_TERRITORIO, new Long(dtoUG.getCodigoTerritorio())); 
                }else{
                    registro.anyadirCampo( IDAT.DAT5_CODIGO_TERRITORIO, null); 
                }
                registro.anyadirCampo( IDAT.DAT5_CODIGO_SECCION, dtoUG.getCodigoSeccion() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_LIDER, dtoUG.getCodigoLiderSeccion() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_ZONA, dtoUG.getCodigoZona() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_REGION, dtoUG.getCodigoRegion() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_GERENTE_ZONA, dtoUG.getCodigoGerenteZona() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_GERENTE_REGIONAL, dtoUG.getCodigoGerenteRegional() ); 
                registro.anyadirCampo( IDAT.DAT5_NIVEL_SOCIOECONOMICO, dtoUG.getNivelSocioeconomico() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_DEPARTAMENTO_GEOGRAFICO, dtoUG.getCodigoDepartamentoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_PROVINCIA_GEOGRAFICA, dtoUG.getCodigoProvinciaGeografico() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_DISTRITO_GEOGRAFICO, dtoUG.getCodigoDistritoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_DEPARTAMENTO_GEOGRAFICO, dtoUG.getNombreDepartamentoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_PROVINCIA_GEOGRAFICA, dtoUG.getNombreProvinciaGeografica() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_DISTRITO_GEOGRAFICO, dtoUG.getNombreDistritoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_UBIGEO, dtoUG.getCodigoUbigeo() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_REGION, dtoUG.getNombreRegion() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_ZONA, dtoUG.getNombreZona() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_PAIS, dtoUG.getCodigoPais() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_PAIS, dtoUG.getNombrePais() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_LIDER, dtoUG.getNombreLider() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_GERENTE_REGIONAL, dtoUG.getNombreGerenteRegional() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_GERENTE_ZONA, dtoUG.getNombreGerenteZona() ); 
                registro.anyadirCampo( IDAT.DAT5_CAMPANYA_CREACION_TERRITORIO, dtoUG.getCampaniaCreacionTerritorio() ); 
                registro.anyadirCampo( IDAT.DAT5_CODIGO_SUBGERENCIA_VENTAS, dtoUG.getCodigoSubgerenciaVentas() ); 
                registro.anyadirCampo( IDAT.DAT5_NOMBRE_SUBGERENCIA_VENTAS, dtoUG.getNombreSubgerenciaVentas() ); 

                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                     UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                  }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug("\n\n 1.-InterfacesException En enviarUnidadesGeograficas  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }


        
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarUnidadesGeograficas  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarUnidadesGeograficas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080664 - dmorello, 13/11/2008
     * - Se modifica llamada a DAOINTDAT.obtenerUnidadesGeograficasCampania
     *   eliminando parametro dtoe.fechaFacturacion
     *   y agregando parametro dtoe.marca
     */
    public DTOSalidaBatch enviarUnidadesGeograficasCampania(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarUnidadesGeograficasCampania(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT6;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarUnidadesGeograficasCampania  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);


        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarUnidadesGeograficasCampania ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTUnidadGeograficaCampania dtoUnidad= null;
        String usuario = this.ctx.getCallerPrincipal().getName();
        UtilidadesLog.debug("++++++ setSessionContext en enviarUnidadesGeograficasCampania++++: " + ctx.getCallerPrincipal().getName());
        DAOINTDAT dao =new DAOINTDAT(usuario);

        ArrayList unidades = dao.obtenerUnidadesGeograficasCampania( this.dtoe.getOidPais(), this.dtoe.getMarca(),  this.dtoe.getCanal());
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if(unidades.isEmpty()){//BELC300015312
              String mensaje = "UsdGeogCampaniaFin SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
        
                //añadido por incidencia 21745
        PeriodoLocal periodoCra = null;
        PeriodoLocalHome periodoCraLocalHome= this.getPeriodoLocalHome();
        PeriodoCorporativoLocal periodoCorporativoLocal = null;
        PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();    
        try{
            periodoCra = periodoCraLocalHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
            periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoCra.getOidPeriodoCorporativo());
        }catch(NoResultException fe){
             UtilidadesLog.debug(" Error FinderException periodo");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        int n=unidades .size();
        for (int i=0 ;i<n ;i++ ) {
            dtoUnidad = (DTOINTUnidadGeograficaCampania)unidades.get(i);
                    
            try{
                registro.vaciar();
                
                //registro.anyadirCampo( IDAT.DAT6_CAMPANYA_VIGENCIA_TERRITORIO, dtoe.getPeriodoFacturacion() );
                  if(dtoe.getPeriodoFacturacion()!=null){//BELC300015441
                         registro.anyadirCampo( IDAT.DAT6_CAMPANYA_VIGENCIA_TERRITORIO, periodoCorporativoLocal.getCodigoPeriodo().toString() );
                }else{
                    	 registro.anyadirCampo( IDAT.DAT6_CAMPANYA_VIGENCIA_TERRITORIO, null );
                }
                CanalLocalHome canalLocalHome = this.getCanalLocalHome();
                try{
                    CanalLocal canalLocal = canalLocalHome.findByPrimaryKey(this.dtoe.getCanal());
                    registro.anyadirCampo( IDAT.DAT6_CODIGO_CANAL_VENTA, canalLocal.getCodCanal()) ;
                   
                }catch(NoResultException fe){
                    UtilidadesLog.debug(" [ "+codigo+" ] No se encontro el canal");                    
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
               if(dtoUnidad.getCodigoTerritorio()!=null){
                    registro.anyadirCampo( IDAT.DAT6_CODIGO_TERRITORIO, new Long(dtoUnidad.getCodigoTerritorio()) ) ;//BELC300015441
               }else {
                    registro.anyadirCampo( IDAT.DAT6_CODIGO_TERRITORIO, null ) ;//BELC300015441

               }
                registro.anyadirCampo( IDAT.DAT6_CODIGO_SECCION, dtoUnidad.getCodigoSeccion() ) ;
                
                //CAMBIO INCIDENCIA 15400
                registro.anyadirCampo( IDAT.DAT6_CODIGO_LIDER_TERRITORIO, dtoUnidad.getCodigoLiderSeccion() ) ;
                registro.anyadirCampo( IDAT.DAT6_CODIGO_ZONA, dtoUnidad.getCodigoZona() ) ;
                
                registro.anyadirCampo( IDAT.DAT6_CODIGO_REGION, dtoUnidad.getCodigoRegion() ) ;
                registro.anyadirCampo( IDAT.DAT6_CODIGO_GERENTE_ZONA, dtoUnidad.getCodigoGerenteZona() ) ;
                registro.anyadirCampo( IDAT.DAT6_CODIGO_GERENTE_REGIONAL, dtoUnidad.getCodigoGerenteRegional() ) ;
                registro.anyadirCampo( IDAT.DAT6_CODIGO_UBIGEO, // concatenación de 'ubigeoOrden1' a 'ubigeoOrden9')
                                        this.componerUbigeo(dtoUnidad.getUbigeoOrden1(), 
                                                            dtoUnidad.getUbigeoOrden2(), 
                                                            dtoUnidad.getUbigeoOrden3(), 
                                                            dtoUnidad.getUbigeoOrden4(),
                                                            dtoUnidad.getUbigeoOrden5(),
                                                            dtoUnidad.getUbigeoOrden6(), 
                                                            dtoUnidad.getUbigeoOrden7(),
                                                            dtoUnidad.getUbigeoOrden8(),
                                                            dtoUnidad.getUbigeoOrden9()));                                        
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_REGION, dtoUnidad.getNombreRegion() ) ;
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_ZONA, dtoUnidad.getNombreZona() ) ;
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_LIDER, 
                                componerNombre( dtoUnidad.getNombre1LiderSeccion(), dtoUnidad.getNombre2LiderSeccion(), 
                                                dtoUnidad.getApellido1LiderSeccion(), dtoUnidad.getApellido2LiderSeccion() ) ) ;
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_GERENTE_REGIONAL, 
                                componerNombre( dtoUnidad.getNombre1GerenteRegional(), dtoUnidad.getNombre2GerenteRegional(),
                                                dtoUnidad.getApellido1GerenteRegional(), dtoUnidad.getApellido2GerenteRegional() ) ) ;
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_GERENTE_ZONA, 
                                componerNombre( dtoUnidad.getNombre1GerenteZona(), dtoUnidad.getNombre2GerenteZona(), 
                                                dtoUnidad.getApellido1GerenteZona(), dtoUnidad.getApellido2GerenteZona() ) ) ;
                registro.anyadirCampo( IDAT.DAT6_ESTATUS_ZONA, dtoUnidad.getEstatusZona() ); 
                registro.anyadirCampo( IDAT.DAT6_CODIGO_SUBGERENCIA_VENTAS, dtoUnidad.getCodigoSubgerenciaVentas() ) ;
                registro.anyadirCampo( IDAT.DAT6_NOMBRE_SUBGERENCIA_VENTAS, dtoUnidad.getNombreSubgerenciaVentas() ) ;
                

                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                    UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO i " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                  }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarUnidadesGeograficasCampania  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
    
        
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarUnidadesGeograficasCampania  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarUnidadesGeograficasCampania(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080664 - dmorello, 13/11/2008
     * - Se elimina variable ultimaFecha
     * - Se quita dicha variable de la llamada a DAOINTDAT.obtenerGerentesRegionales
     */
    public DTOSalidaBatch enviarInformacionGerentesRegionales(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarInformacionGerentesRegionales(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT7;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionGerentesRegionales  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);    
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarInformacionLideres ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTGerente dtoGerente= null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);

        ArrayList gerentes = dao.obtenerGerentesRegionales( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal());
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*  if(gerentes.isEmpty()){//BELC300015312
              String mensaje = "GerenRegionalesFin SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
       
        int n=gerentes.size();
        UtilidadesLog.debug("DAT-7 Número de Datos del Array" + n);
        for (int i=0 ;i<n ;i++ ) {
            dtoGerente = (DTOINTGerente)gerentes.get(i);
                    
            try{
                registro.vaciar();
                
                registro.anyadirCampo( IDAT.DAT7_CODIGO_GERENTE_REGIONAL , dtoGerente.getCodigoGerente());
                registro.anyadirCampo( IDAT.DAT7_NOMBRE_GERENTE_REGIONAL , dtoGerente.getNombreGerente());
                registro.anyadirCampo( IDAT.DAT7_CODIGO_GERENTE_COMO_CONSULTORA , dtoGerente.getCodigoGerenteComoConsultora());
                registro.anyadirCampo( IDAT.DAT7_CODIGO_REGION_GERENTE , dtoGerente.getCodigoRegionGerente() );  
                registro.anyadirCampo( IDAT.DAT7_NOMBRE_DEPARTAMENTO_GEOGRAFICO , dtoGerente.getNombreDepartamentoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT7_NOMBRE_PROVINCIA_GEOGRAFICA , dtoGerente.getNombreProvinciaGeografica() ); 
                registro.anyadirCampo( IDAT.DAT7_NOMBRE_DISTRITO_GEOGRAFICO , dtoGerente.getNombreDistritoGeografico() ); 
                registro.anyadirCampo( IDAT.DAT7_DIRECCION_GERENTE, dtoGerente.getDireccionGerente() ); 
                registro.anyadirCampo( IDAT.DAT7_DESCRIPCION_TIPO_CENTRO_POBLADO , dtoGerente.getDescripcionTipoCentroPoblado() ) ;
                registro.anyadirCampo( IDAT.DAT7_DESCRIPCION_CENTRO_POBLADO , dtoGerente.getDescripcionCentroPoblado() ); 
                registro.anyadirCampo( IDAT.DAT7_CODIGO_TIPO_CENTRO_POBLADO , dtoGerente.getCodigoTipoCentroPoblado() ); 
                registro.anyadirCampo( IDAT.DAT7_CODIGO_CENTRO_POBLADO , dtoGerente.getCodigoCentroPoblado() ); 
                registro.anyadirCampo( IDAT.DAT7_CODIGO_UBIGEO , dtoGerente.getCodigoUbigeo() ); 
                registro.anyadirCampo( IDAT.DAT7_TELEFONO_DOMICILIO , dtoGerente.getTelefonoDomicilio() ) ;
                registro.anyadirCampo( IDAT.DAT7_FAX_DOMICILIO , dtoGerente.getFaxDomicilio() ); 
                registro.anyadirCampo( IDAT.DAT7_NUMERO_TELEFONO_CELULAR , dtoGerente.getNumeroTelefonoCelular() ); 
                registro.anyadirCampo( IDAT.DAT7_ESTADO_CIVIL , dtoGerente.getEstadoCivil() ); 
                registro.anyadirCampo( IDAT.DAT7_TIPO_DOCUMENTO_IDENTIDAD , dtoGerente.getTipoDocumentoIdentidad() ); 
                registro.anyadirCampo( IDAT.DAT7_NUMERO_DOCUMENTO_IDENTIDAD , dtoGerente.getNumeroDocumentoIdentidad() ); 
                registro.anyadirCampo( IDAT.DAT7_FECHA_NACIMIENTO , dtoGerente.getFechaNacimiento() ); 
                registro.anyadirCampo( IDAT.DAT7_EMAIL , dtoGerente.getEmail() ); 
                //BELC300018338
                registro.anyadirCampo( IDAT.DAT7_PASAPORTE, dtoGerente.getNumPasaporte());
                registro.anyadirCampo( IDAT.DAT7_FECHA_INICIO_CONTRATO , null ); 
                registro.anyadirCampo( IDAT.DAT7_FECHA_FIN_CONTRATO , null ); 
                //Incidencia BELC300015642
                registro.anyadirCampo( IDAT.DAT7_FLAG_TIPO_ACCION , new Integer(ConstantesINT.CONTROL_NOVEDAD_NUEVO )); 

                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                     UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                  }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionLideres  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionGerentesRegionales  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarInformacionGerentesRegionales(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

  /**
   * Modificado por Sapaza - Fecha 05/06/2007 - Cambio Sicc20070291, 
   *            se deshace el cambio hecho por la incidencia Sicc20070283
   * Modificado por dmorello - 13/11/2008 - Cambio RI 20080664
   * - Se elimina obtencion de ultima fecha de ejecucion de la interfaz (ultimaFecha)
   * - Se elimina ultimaFecha como parametro de DAOINTDAT.obtenerGerentesZonas
   */
    public DTOSalidaBatch enviarInformacionGerentesZona(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarInformacionGerentesZona(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT8;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionGerentesZona  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);
        // DISEÑO DEL METODO EN INCIDENCIA:BELC300015399

        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarInformacionGerentesZona ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTGerente dtoGerente= null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);

        ArrayList gerentes = dao.obtenerGerentesZonas( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal());
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
          /*if(gerentes.isEmpty()){//BELC300015312
              String mensaje = "GerenZonasFin SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/

        int n=gerentes.size();
        UtilidadesLog.debug(" [ "+codigo+" ]MONINTDAT:enviarInformacionGerentesZona valor de n=" + n);
        for (int i=0 ;i<n ;i++ ) {
            dtoGerente = (DTOINTGerente)gerentes.get(i);
                    
            try{
                registro.vaciar();
                
                registro.anyadirCampo( IDAT.DAT8_CODIGO_GERENTE_ZONA, dtoGerente.getCodigoGerente() );
                registro.anyadirCampo( IDAT.DAT8_NOMBRE_GERENTE_ZONA, dtoGerente.getNombreGerente() );
                int largo = dtoGerente.getCodigoGerente().length();
                UtilidadesLog.debug("mide " + largo);
                int fijo = 10;
                if(largo < fijo){
                    UtilidadesLog.debug("consultora gerente zona " + dtoGerente.getCodigoGerente());    
                    registro.anyadirCampo( IDAT.DAT8_CODIGO_CONSULTORA_GERENTE_ZONA, dtoGerente.getCodigoGerente() );
                }else{
                    int corte = largo - fijo; 
                    UtilidadesLog.debug("corta " + corte);
                    String cosultoragerente = dtoGerente.getCodigoGerente().substring(corte);
                    UtilidadesLog.debug("consultora gerente zona CORTADO " +cosultoragerente);    
                    registro.anyadirCampo( IDAT.DAT8_CODIGO_CONSULTORA_GERENTE_ZONA, cosultoragerente );
                }
                registro.anyadirCampo( IDAT.DAT8_CODIGO_ZONA_GERENTE, dtoGerente.getCodigoZonaGerente() );
                registro.anyadirCampo( IDAT.DAT8_NOMBRE_DEPARTAMENTO_GEOGRAFICO, dtoGerente.getNombreDepartamentoGeografico() );
                registro.anyadirCampo( IDAT.DAT8_NOMBRE_PROVINCIA_GEOGRAFICA, dtoGerente.getNombreProvinciaGeografica() );
                registro.anyadirCampo( IDAT.DAT8_NOMBRE_DISTRITO_GEOGRAFICO, dtoGerente.getNombreDistritoGeografico() );
                registro.anyadirCampo( IDAT.DAT8_DIRECCION_GERENTE, dtoGerente.getDireccionGerente() );
                registro.anyadirCampo( IDAT.DAT8_DESCRIPCION_TIPO_CENTRO_POBLADO, dtoGerente.getDescripcionTipoCentroPoblado() );
                registro.anyadirCampo( IDAT.DAT8_DESCRIPCION_CENTRO_POBLADO, dtoGerente.getDescripcionCentroPoblado() );
                registro.anyadirCampo( IDAT.DAT8_CODIGO_TIPO_CENTRO_POBLADO, dtoGerente.getCodigoTipoCentroPoblado() );
                registro.anyadirCampo( IDAT.DAT8_CODIGO_CENTRO_POBLADO, dtoGerente.getCodigoCentroPoblado() );
                registro.anyadirCampo( IDAT.DAT8_CODIGO_UBIGEO, dtoGerente.getCodigoUbigeo() );
                registro.anyadirCampo( IDAT.DAT8_TELEFONO_CASA, dtoGerente.getTelefonoDomicilio() );
                registro.anyadirCampo( IDAT.DAT8_NUMERO_FAX, dtoGerente.getFaxDomicilio() );
                registro.anyadirCampo( IDAT.DAT8_NUMERO_CELULAR, dtoGerente.getNumeroTelefonoCelular() );
                registro.anyadirCampo( IDAT.DAT8_ESTADO_CIVIL, dtoGerente.getEstadoCivil() );
                registro.anyadirCampo( IDAT.DAT8_TIPO_DOCUMENTO_IDENTIDAD, dtoGerente.getTipoDocumentoIdentidad() );
                registro.anyadirCampo( IDAT.DAT8_NUMERO_DOCUMENTO_IDENTIDAD, dtoGerente.getNumeroDocumentoIdentidad() );
                registro.anyadirCampo( IDAT.DAT8_FECHA_NACIMIENTO, dtoGerente.getFechaNacimiento() );
                registro.anyadirCampo( IDAT.DAT8_EMAIL, dtoGerente.getEmail() );

                registro.anyadirCampo( IDAT.DAT8_NUMERO_PASAPORTE, dtoGerente.getNumPasaporte() );   // DUDA SOBRE VALOR
                
                registro.anyadirCampo( IDAT.DAT8_FECHA_INICIO_CONTRATO, null );
                registro.anyadirCampo( IDAT.DAT8_FECHA_FIN_CONTRATO, null );
                //Incidencia BELC300015642
                registro.anyadirCampo( IDAT.DAT8_FLAG_TIPO_ACCION, new Integer(ConstantesINT.CONTROL_NOVEDAD_NUEVO ));

                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                     UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                  }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionGerentesZona  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));              
        }
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionGerentesZona  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarInformacionGerentesZona(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarInformacionLideres(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarInformacionLideres(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT10;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionLideres  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarInformacionLideres ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTLider dtoLider= null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);
        ArrayList lideres = dao.obtenerInformacionLideres( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal());
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*  if(lideres.isEmpty()){//BELC300015312
              String mensaje = "LideresFin SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
        
        int n=lideres.size();
        for (int i=0 ;i<n ;i++ ) {
            dtoLider=(DTOINTLider)lideres.get(i);
                    
            try{
                    registro.vaciar();
                    
                    registro.anyadirCampo( IDAT.DAT10_CODIGO_CONSULTORA_LIDER, dtoLider.getCodigoConsultora() );
                    registro.anyadirCampo( IDAT.DAT10_NOMBRE_LIDER, dtoLider.getNombreLider() );
                    registro.anyadirCampo( IDAT.DAT10_DIRECCION_LIDER, dtoLider.getDireccionLider() );
                    registro.anyadirCampo( IDAT.DAT10_TELEFONO, dtoLider.getTelefono() );
                    registro.anyadirCampo( IDAT.DAT10_ANYO_CAMPANYA_ES_LIDER, dtoLider.getAnioCampaniaEsLider() );

                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                         UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionLideres  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));              
        }
   
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionLideres  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarInformacionLideres(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }
    private void init(DTOBatch dtoBatch, String codigoInterfaz) throws MareException{
    UtilidadesLog.info("MONINTDATBean.init(DTOBatch dtoBatch, String codigoInterfaz): Entrada");
    UtilidadesLog.debug(" [ "+codigoInterfaz+" ] MONINTDAT:init  ---->Entrada \n dtoBatch   " +dtoBatch+ " String codigoInterfaz -->"+codigoInterfaz );
    /*
        - en este método, si se produce una excepción, se encapsula en una MareException, y se lanza esta última 
        dtoe = (DTOINTCargaInicialDAT)dtoBatch.dtoOnline 
        dao = new DAOINTDAT() 
        gestor = MONGestorInterfacesHome.create() 
        interfaz = new InterfazInfo( codigoInterfaz, 
        dtoe.numeroLote, 
        dtoe.pais ) 
        interfaz.setObservaciones( dtoe.observaciones ) 
        interfaz.setDescripcion( dtoe.descripcionLote ) 
        info = gestor.crearInterfaz( info ) 
        registro = new RegistroSicc()
        * */
        
        ArrayList listaDtos= new ArrayList();
        //IRegistroSicc registro=null;
       
        
        try{
              this.dtoe  = (DTOINTCargaInicialDAT)dtoBatch.getDTOOnline();
            UtilidadesLog.debug(" [ "+codigoInterfaz+" ] RECIBIDO dtoInt  "+dtoe);
           
         }catch(ClassCastException cce){
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]**** ClassCastException  en   init salimos del metodo : ");
             throw new MareException(" ClassCastException  en   init  ", cce);
         }
        
        
        InterfazInfo interfazInfo = new InterfazInfo( codigoInterfaz, dtoe.getNumeroLote(), dtoe.getOidPais()); 
        interfazInfo.setDescripcionLote(dtoe.getDescripcionLote());
        interfazInfo.setObservaciones(dtoe.getObservaciones());
        
        //UtilidadesLog.debug("interfaz creada + "+ interfaz.toString());
        this.gi = this.getMONGestorInterfaces();
        
        
           
      try{           
             this.interfaz =gi.importarInterfaz(interfazInfo); 
             
             this.interfaz.setDescripcionLote(dtoe.getDescripcionLote());
             this.interfaz.setObservaciones(dtoe.getObservaciones());
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]MIMPORTAMOS INTERFAZ : ");
                
       }catch(RemoteException re){             
             UtilidadesLog.debug("error RemoteException");
             throw new MareException(re,
                     UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (InterfacesException ie) {
              UtilidadesLog.debug(" [ "+codigoInterfaz+" ]**** 1.- INTERFACES EXCEPTION importarInterfaz ");             
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]===============================================");
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]ERROR: "+ie.getMotivo());
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]===============================================");
             //UtilidadesLog.debug("ERROR: "+ie.getEx().getMessage());
             throw new MareException("1.- INTERFACES EXCEPTION importarInterfaz ", ie);
             //return new DTOSalidaBatch( 0, "recEstiMAV fin con error" );
        }           
  
     UtilidadesLog.debug(" [ "+codigoInterfaz+" ] MONINTDAT:init  ---->SALIDA ");
     UtilidadesLog.info("MONINTDATBean.init(DTOBatch dtoBatch, String codigoInterfaz): Salida");
    }
    
    
     private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTDATBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 	        
        UtilidadesLog.info("MONINTDATBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}  
    
    private String componerNombre( String nombre1, String nombre2, String apellido1, String apellido2 ){
         UtilidadesLog.info("MONINTDATBean.componerNombre(String nombre1, String nombre2, String apellido1, String apellido2): Entrada");
         UtilidadesLog.debug("componerNombre   nombre1-->" +nombre1+" String nombre2-->" +nombre2+", String apellido1-->" + apellido1+" String apellido2--> " +apellido2 );
        String nombreCompleto= "";
        
            if(nombre1!=null && !nombre1.equals("null")){
                 nombreCompleto =" "+ nombre1; 
            }else nombre1="";
            
            if(nombre2!=null && !nombre2.equals("null")){
                nombreCompleto += " "+nombre2; 
            }else nombre2="";
            
             if(apellido1!=null && !apellido1.equals("null")){
                nombreCompleto += " "+apellido1; 
            }else apellido1="";
            
            if(apellido2!=null && !apellido2.equals("null")){
                nombreCompleto += " "+apellido2; 
            }else apellido2 ="";
           
            
            // Agregado por ssantana, 13/9/2005, a pedido de Jrivas (Peru)
            if (nombreCompleto.startsWith(" ")) { 
                 nombreCompleto = nombreCompleto.substring(1, nombreCompleto.length()); 
            }
            // Fin agregado por ssantana, 13/9/2005, a pedido de Jrivas (Peru)
            
            if(nombreCompleto.length() > IDAT.LONGITUD_NOMBRE.intValue()){
                   nombreCompleto =nombre1 + apellido1 + apellido2;
                if(nombreCompleto.length() > IDAT.LONGITUD_NOMBRE.intValue()){
                     nombreCompleto =nombre1 + apellido1;
                      if(nombreCompleto.length() > IDAT.LONGITUD_NOMBRE.intValue()){
                             nombreCompleto = nombre1;
                             if(nombreCompleto.length() > IDAT.LONGITUD_NOMBRE.intValue()){
                                nombreCompleto = nombre1.substring(0,54);    
                             }
                        }
                }
            }
            UtilidadesLog.debug("Longitud de la cadena devuleta = nombreCompleto = "+ nombreCompleto.length());
            UtilidadesLog.info("MONINTDATBean.componerNombre(String nombre1, String nombre2, String apellido1, String apellido2): Salida");
            return nombreCompleto;                    
    }


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws MareException {
        BusinessFacadeLocalHome home = (BusinessFacadeLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/BusinessFacadeBATCH");
        return home;
        //final InitialContext context = new InitialContext();
        //return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
    
     private String formatearNumero(BigDecimal numero){
        UtilidadesLog.info("MONINTDATBean.formatearNumero(BigDecimal numero): Entrada");
        String formato = "#.00";
        String s = null;
        
        String devolver = null;
        
        
         UtilidadesLog.debug("\n\n formatearNumero  -->Numero que Entra" +numero);
        if(numero!=null){
            devolver = numero.setScale(2).toString();        
        }else{
            devolver = "0.00";
        }
        /* if (numero != null){
            NumberFormat formatter = new DecimalFormat( formato );
            s = formatter.format( numero );
            
             if (numero.toString().equals(new String("0"))){
                devolver = numero.toString() + s;
                return devolver;
            }
            
            return s;
            
            
         }else{
            numero = new BigDecimal("0");
            NumberFormat formatter = new DecimalFormat( formato );
            s = formatter.format( numero );
            devolver = numero.toString() + s;
         }
         
         */
        //UtilidadesLog.debug("\n\n formatearNumero  -->Numero que devolvemos" +s);
        UtilidadesLog.debug("\n\n devolver  -->Numero que devolvemos" +devolver);
        UtilidadesLog.info("MONINTDATBean.formatearNumero(BigDecimal numero): Salida");
       return devolver;
    } 

    public DTOSalidaBatch enviarHomologacionEstatusClientes(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarHomologacionEstatusClientes(DTOBatch dtoBatch): Entrada");
          String codigo = IDAT.COD_INTERFAZ_DAT15;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarHomologacionEstatusClientes  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarHomologacionEstatusClientes ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
       
          DAOINTDAT dao= new DAOINTDAT();
          DTOINTEstatusCliente dto= new DTOINTEstatusCliente();
          ArrayList estatus = dao.obtenerEstatusClientes( this.dtoe.getOidIdioma());
          
          // vbongiov -- 18/10/2006 -- DBLG700000156
          /* if(estatus.isEmpty()){//BELC300015312
                  String mensaje = "tiposOfertaFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
        
           
              int n=estatus.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTEstatusCliente)estatus.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTEstatusCliente "+ dto);    
                    registro.vaciar();
                    
                    try{
                        try{
                            registro.vaciar();
                            
                            registro.anyadirCampo( IDAT.DAT15_CODIGO_STATUS, new Integer(dto.getCodigoEstatus()) ); 
                        }catch(NumberFormatException e){
                        //16053 cambiado a ultima hora
                            UtilidadesLog.debug("EXCEPCION enviarHomologacionEstatusClientes  Se recibio de base de datos una letra. Cuando deberia ser un número ");
                            String mensaje = "Error de formato en estatus de cliente: " + dto.getCodigoEstatus();
                            DTOINTError dtoError = new DTOINTError( this.interfaz, registro, mensaje );
                            this.privadaregistrarError(dtoError, codigo);
                            registro.vaciar(); 
                            continue;

                        }
                        
                        registro.anyadirCampo( IDAT.DAT15_DESCRIPCION_STATUS, dto.getDescripcionEstatus() ); 
                        registro.anyadirCampo( IDAT.DAT15_CODIGO_CORPORATIVO, new String() ); 
                        registro.anyadirCampo( IDAT.DAT15_NOMBRE_STATUS_CORPORATIVO, new String() );
                                              
                     
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposOferta  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarHomologacionEstatusClientes  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarHomologacionEstatusClientes(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT15 Procesada" );
    }

    public DTOSalidaBatch enviarTiposOferta(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarTiposOferta(DTOBatch dtoBatch): Entrada");
          String codigo = IDAT.COD_INTERFAZ_DAT17;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiposOferta  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTiposOferta ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
       
         
         
           DAOINTDAT dao= new DAOINTDAT();
           DTOINTTipoOferta dto= new DTOINTTipoOferta();
            ArrayList tiposOferta = dao.obtenerTiposOferta( this.dtoe.getOidIdioma(), this.dtoe.getCanal());
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(tiposOferta.isEmpty()){//BELC300015312
                  String mensaje = "tiposOfertaFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
        
           
              int n=tiposOferta.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTTipoOferta)tiposOferta.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTTipoOferta "+ dto);    
                    try{
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT17_CODIGO_CANAL, dto.getCodigoCanal() ); 
                        registro.anyadirCampo( IDAT.DAT17_CODIGO_TIPO_OFERTA, dto.getCodigoTipoOferta() ) ;
                        registro.anyadirCampo( IDAT.DAT17_DESCRIPCION_TIPO_OFERTA, dto.getDescripcionTipoOferta() ) ;
                        if (dto.getCodigoTipoProfit()!= null) 
                        {
                            registro.anyadirCampo( IDAT.DAT17_CODIGO_TIPO_PROFIT, new Long(dto.getCodigoTipoProfit()) );
                        }else
                        {
                            registro.anyadirCampo( IDAT.DAT17_CODIGO_TIPO_PROFIT, null);
                        }
                         
                        
                        registro.anyadirCampo( IDAT.DAT17_DESCRIPCION_TIPO_PROFIT, new String() );
                                                
                     
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposOferta  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiposOferta  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarTiposOferta(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT17 Procesada" );
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080664 - dmorello, 13/11/2008 -> Se elimina el filtrado por novedad
     * - Se elimina obtencion de ultima fecha de ejecucion (ultimaFecha)
     * - Se elimina ultimaFecha como parametro pasado a DAOINTDAT.obtenerTablaZonas
     */
    public DTOSalidaBatch enviarTablaZonas(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarTablaZonas(DTOBatch dtoBatch): Entrada");
         
           String codigo = IDAT.COD_INTERFAZ_DAT18;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTablaZonas  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTablaZonas ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
           DAOINTDAT dao= new DAOINTDAT();
           DTOINTZona dto= new DTOINTZona();
           
           ArrayList zonas = dao.obtenerTablaZonas( this.dtoe.getOidPais(),this.dtoe.getMarca(),this.dtoe.getCanal(), this.dtoe.getOidIdioma() );
           
           // vbongiov -- 18/10/2006 -- DBLG700000156
           /*if(zonas.isEmpty()){//BELC300015312
                  String mensaje = "TablaZonasFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
        
           
              int n=zonas.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTZona)zonas.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTZona "+ dto);    
                    try{
                        registro.vaciar();
                       registro.anyadirCampo( IDAT.DAT18_CODIGO_ZONA, dto.getCodigoZona() ); 
                        registro.anyadirCampo( IDAT.DAT18_CODIGO_GERENTE_ZONA, dto.getCodigoGerenteZona() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_GERENTE_ZONA, componerNombre( dto.getNombre1GerenteZona(), dto.getNombre2GerenteZona(), dto.getApellido1GerenteZona(), dto.getApellido2GerenteZona() )); 
                        registro.anyadirCampo( IDAT.DAT18_CODIGO_REGION, dto.getCodigoRegion() ); 
                        registro.anyadirCampo( IDAT.DAT18_CAPITAL_RESTO_PAISES, new String() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_EMPRESA, new String()); 
                        registro.anyadirCampo( IDAT.DAT18_CAMPANIA_CREACION_ZONA, new String() ); 
                        registro.anyadirCampo( IDAT.DAT18_FLAG_ACTIVIDAD_ZONA, dto.getIndicadorActiva() ); 
                        registro.anyadirCampo( IDAT.DAT18_CODIGO_GERENTE_REGIONAL, dto.getCodigoGerenteRegional() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_GERENTE_REGIONAL, componerNombre( dto.getNombre1GerenteRegional(), dto.getNombre2GerenteRegional(), dto.getApellido1GerenteRegional(), dto.getApellido2GerenteRegional() ) ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_REGION, dto.getNombreRegion() ); 
                        registro.anyadirCampo( IDAT.DAT18_CODIGO_PAIS, dto.getCodigoPais() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_PAIS, dto.getNombrePais() ); 
                        registro.anyadirCampo( IDAT.DAT18_STATUS_ZONA, dto.getEstatusZona() );//solucionado en EN el DTO  BELC300015969 
                        //registro.anyadirCampo( IDAT.DAT18_CODIGO_ZONA, ConstantesINT.CONTROL_NOVEDAD_NUEVO ); 
                        registro.anyadirCampo( IDAT.DAT18_FLAG_TIPO_ACCION, new Integer(ConstantesINT.CONTROL_NOVEDAD_NUEVO) ); 
                        registro.anyadirCampo( IDAT.DAT18_CODIGO_SUBGERENCIA, dto.getCodigoSubgerencia() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_SUBGERENCIA, dto.getNombreSubgerencia() ); 
                        registro.anyadirCampo( IDAT.DAT18_NOMBRE_ZONA, dto.getNombreZona() ); 


                                                
                     
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTiposOferta  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTablaZonas  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarTablaZonas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT18 Procesada" );
    }

    public DTOSalidaBatch enviarCapacitacionesClientes(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarCapacitacionesClientes(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT19;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCapacitacionesClientes  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarCapacitacionesClientes ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
           DAOINTDAT dao= new DAOINTDAT();
        
            //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
            //  Obtiene la fecha del ultimo procesamiento de INT_HISTO_LOTES para la interfaz
            java.sql.Date fechaUltimoProc = dao.obtenerUltimaFechaProceHistoLotes( codigo,  this.dtoe.getOidPais() );

            //  Modificado por Sapaza - Fecha 18/09/2007 - cambio Sicc20070392
            //  Obtiene la fecha del ultimo procesamiento de INT_HISTO_LOTES para la interfaz, formato yyyy-MM-dd HH:mm:ss
            String fechaUltimoProcSTR = dao.obtenerUltimaFechaProceHistoLotesSTR( codigo, this.dtoe.getOidPais() );

            //  Obtiene los cursos
            ArrayList cursos = dao.obtenerCursos( this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(),this.dtoe.getFechaFacturacion(),ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA, fechaUltimoProc, fechaUltimoProcSTR);
            if(cursos.isEmpty()){//BELC300015312
                  String mensaje = "capacitacionClientesFIN SinRegistros";
                try{ 
                    gi.enviarInterfaz(interfaz);
                } catch (InterfacesException ie) {
                    UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
                }catch(RemoteException re){                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                  return new DTOSalidaBatch( 0, mensaje );
            }


//ACCEDEMOS A CRA PERIODO         
          PeriodoLocalHome periodohome =this.getPeriodoLocalHome();
          PeriodoLocal periodolocal=null;
          try{
              periodolocal=periodohome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
          }catch (NoResultException e){
               String mensaje = "CapacitaClientes: " + ErroresDeNegocio.INT_0060; 
                DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
               
                this.privadaregistrarError( dtoError, codigo ); 
                try{ 
                    gi.enviarInterfaz(interfaz);
                } catch (InterfacesException ie) {
                    UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
                }catch(RemoteException re){                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                return new DTOSalidaBatch( 0, mensaje );
          }  catch (PersistenceException ce) {   
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
         
          PeriodoCorporativoLocalHome pCorhome =this.getPeriodoCorporativoLocalHome();
          PeriodoCorporativoLocal pCorplocal=null;
          
        
              try{
                    pCorplocal=pCorhome.findByPrimaryKey(periodolocal.getOidPeriodoCorporativo());
              }catch (NoResultException e){
                   String mensaje = "CapacitaClientes: " + ErroresDeNegocio.INT_0061; 
                DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                 this.privadaregistrarError( dtoError, codigo ); 
                try{ 
                    gi.enviarInterfaz(interfaz);
                } catch (InterfacesException ie) {
                    UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
                }catch(RemoteException re){                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                return new DTOSalidaBatch( 0, mensaje );
              }  catch (PersistenceException ce) {   
                  UtilidadesLog.error("ERROR ", ce);
                  throw new MareException(ce, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }
         
          DTOINTAptaCurso dto=null;
          String anioCampaniaCapacitacion=null;
          String anioCampaniaCurso=null;
          String tipoAccion=null;
       
           int n=cursos.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTAptaCurso)cursos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTCurso "+ dto);    
                
                if(dto.getIndicadorFF().booleanValue()) { // FFact = FDisp
                     
                    if( dto.getFechaAsistencia() == null ) { // FAsist es null
                        //anioCampaniaCurso = dto.getPeriodo(); // 18261 ahora FDisp                        
                        
                        // Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
                        //anioCampaniaCurso = pCorplocal.getCodigoPeriodo();
                        anioCampaniaCurso = dao.obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 2 );    //  Se suma mas dos campanias
                        //anioCampaniaCapacitacion = null;
                        anioCampaniaCapacitacion = dao.obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 0 );    //  De cuando fue nueva
                        
                        tipoAccion = ConstantesINT.CONTROL_NOVEDAD_NUEVO;
                        UtilidadesLog.debug(" Caso: (FF = FD) y (FA es null) -->NUEVO Recibio(1ro.)_null   Debe(6to.)_FDispo");
                    
                    } else { // FAsist no es null
                        
                        // Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
                        //anioCampaniaCapacitacion = pCorplocal.getCodigoPeriodo();
                        anioCampaniaCapacitacion = dao.obtenerPeriodoCorpoParaAnioCampaniaCapac( dto );
                        //anioCampaniaCurso = pCorplocal.getCodigoPeriodo();
                        anioCampaniaCurso = dao.obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 2 );    //  Se suma mas dos campanias
                        
                        // gPineda - 10/03/2007 - INT-DAT-PRD-12
                        //tipoAccion = ConstantesINT.CONTROL_NOVEDAD_MODIFICADO;
                        tipoAccion = ConstantesINT.CONTROL_NOVEDAD_NUEVO;
                        UtilidadesLog.debug(" Caso: (FF = FD) y (FA no es null) -->MODIF Recibio(1ro.)_parametro   Debe(6to.)_parametro");
                    }
                    
                } else { // FFact > FDisp
                    /* 
                    // Modificacion por Inc.DBLG400000745 eiraola 07/04/2006 
                    // Inicio agregado A - Inc.DBLG400000745 
                    String codPeriRecibio = null;
                    if (dto.getFechaAsistencia() != null) { // Fecha asistencia
                        DTODate fechaAsist = new DTODate();
                        fechaAsist.setFecha(dto.getFechaAsistencia());
                        
                        codPeriRecibio = dao.obtenerPeriodoCorporativo(
                                fechaAsist, this.dtoe.getOidPais(),
                                this.dtoe.getMarca(), this.dtoe.getCanal() );
                    }
                    // Fin agregado A - Inc.DBLG400000745
                    //anioCampaniaCapacitacion = dto.getPeriodo();
                    anioCampaniaCapacitacion = codPeriRecibio; */
                    anioCampaniaCapacitacion = dao.obtenerPeriodoCorpoParaAnioCampaniaCapac( dto );
                    anioCampaniaCurso = dao.obtenerPeriodoCorpoDeClienteNuevo( dto.getCodigoCliente(), 2 );    //  Se suma mas dos campanias
                    tipoAccion = ConstantesINT.CONTROL_NOVEDAD_MODIFICADO;
                    UtilidadesLog.debug(" Caso: (FF > FD) -->MODIF Recibio(1ro.)_FAsist   Debe(6to.)_null");
                }
  

          
                    try{
                        registro.vaciar();
//modificado POR LA 15963
                        registro.anyadirCampo( IDAT.DAT19_ANIO_CAMPANIA_CAPACITACION, anioCampaniaCapacitacion );
                        //pzerbino 2/11/2006                        
                        //registro.anyadirCampo( IDAT.DAT19_CODIGO_CONSULTORA, dto.getCodigoCliente() );
                        int valor = dto.getCodigoCliente().length();
                        if (valor >= 10){
                              registro.anyadirCampo( IDAT.DAT19_CODIGO_CONSULTORA, dto.getCodigoCliente().substring(valor-10,valor) ); 
                        }else {
                              registro.anyadirCampo( IDAT.DAT19_CODIGO_CONSULTORA, dto.getCodigoCliente()); 
                        }                                              
                        registro.anyadirCampo( IDAT.DAT19_CODIGO_TIPO_CONCURSO, dto.getCodigoTipoCurso()!=null?Long.valueOf(dto.getCodigoTipoCurso()):null );
                        registro.anyadirCampo( IDAT.DAT19_CODIGO_CANAL_VENTA, dto.getCodigoCanalVenta() );
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        UtilidadesLog.debug("fecha de facturacion date "+ dto.getFechaAsistencia());
                        if(dto.getFechaAsistencia()!=null){
                            String fechaCaptacion = sdf.format(dto.getFechaAsistencia()); 
                            UtilidadesLog.debug("fecha de facturacion string "+ fechaCaptacion);
                            registro.anyadirCampo( IDAT.DAT19_FECHA_CAPTACION, fechaCaptacion );
                        }else{
                            registro.anyadirCampo( IDAT.DAT19_FECHA_CAPTACION, "" );
                        }
                        registro.anyadirCampo( IDAT.DAT19_ANIO_CAMPANIA_CURSO, anioCampaniaCurso );
                        registro.anyadirCampo( IDAT.DAT19_FLAG_ASISTENCIA, dto.getIndicadorAsistencia()) ;
                        registro.anyadirCampo( IDAT.DAT19_FLAG_EXTEMPORANEA, dto.getFlagExtemporanea() );
                        registro.anyadirCampo( IDAT.DAT19_FLAG_APTA, dto.getFlagApta() );
                        registro.anyadirCampo( IDAT.DAT19_OPCION, dto.getOpcion() );
                        registro.anyadirCampo( IDAT.DAT19_FLAG_TIPO_ACCION, new Integer(tipoAccion) );

                     
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarCapacitacionclientes  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }

        //Modificado por Sapaza - Fecha 18/09/2007 - cambio Sicc20070392
        //Se actualiza el [indicador envio] para las consultoras enviados en la interfaz
        //dao.actualizarEnvioCursosDat(this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(),this.dtoe.getFechaFacturacion(),ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA  );
        dao.actualizarEnvioCursosDat(cursos);

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCapacitacionGerentes  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarCapacitacionesClientes(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT19 Procesada" );
    }

    public DTOSalidaBatch enviarCapacitacionGerentes(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarCapacitacionGerentes(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT20;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCapacitacionGerentes  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarCapacitacionGerentes ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
      
        DAOINTDAT dao= new DAOINTDAT();
        
            //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070122
            //  Obtiene la fecha del ultimo procesamiento de INT_HISTO_LOTES para la interfaz
            java.sql.Date fechaUltimoProc = dao.obtenerUltimaFechaProceHistoLotes( codigo,  this.dtoe.getOidPais() );
            
            //  Modificado por Sapaza - Fecha 18/09/2007 - cambio Sicc20070392
            //  Obtiene la fecha del ultimo procesamiento de INT_HISTO_LOTES para la interfaz, formato yyyy-MM-dd HH:mm:ss
            String fechaUltimoProcSTR = dao.obtenerUltimaFechaProceHistoLotesSTR( codigo, this.dtoe.getOidPais() );
            
            //  Obtiene los cursos
            ArrayList cursos = dao.obtenerCursos( this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(),this.dtoe.getFechaFacturacion(),ConstantesMAE.OID_TIPO_CLIENTE_GERENTE, fechaUltimoProc, fechaUltimoProcSTR );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(cursos.isEmpty()){//BELC300015312
                  String mensaje = "capacitacionGerentesFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
               DTOINTAptaCurso dto=null;         
              String tipoAccion= null;
              int n=cursos.size();
            for (int i=0 ;i<n ;i++ ) {
                dto =(DTOINTAptaCurso)cursos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTCurso "+ dto);    
            
                 if( dto.getIndicadorFF().booleanValue() ){
                        // gPineda - 10/03/2007 - INT-DAT-PRD-12
                        // if( dto.getFechaAsistencia() == null ){
                        //          tipoAccion = ConstantesINT.CONTROL_NOVEDAD_NUEVO;
                        //}else{
                        //tipoAccion = ConstantesINT.CONTROL_NOVEDAD_MODIFICADO;
                        tipoAccion = ConstantesINT.CONTROL_NOVEDAD_NUEVO;
                        //}
                }else{
                  tipoAccion = ConstantesINT.CONTROL_NOVEDAD_MODIFICADO;
               }  
                            
                               
                    try{
                    registro.vaciar();        
/// POR LA 15963
                    registro.anyadirCampo( IDAT.DAT20_ANIO_CAMPANIA, dto.getPeriodo() );
                    registro.anyadirCampo( IDAT.DAT20_CODIGO_GERENTE_ZONA, dto.getCodigoCliente() );
                    registro.anyadirCampo( IDAT.DAT20_CODIGO_TIPO_CURSO, dto.getCodigoTipoCurso() );
                    registro.anyadirCampo( IDAT.DAT20_CODIGO_CANAL_VENTA, dto.getCodigoCanalVenta() );
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    UtilidadesLog.debug("fecha de facturacion date "+ dto.getFechaCapacitacion());
                    String fechaCapacitacion = sdf.format(dto.getFechaCapacitacion()); 
                    UtilidadesLog.debug("fecha de facturacion string "+ fechaCapacitacion);
                    registro.anyadirCampo( IDAT.DAT20_FECHA_CAPACITACION, fechaCapacitacion );
                    registro.anyadirCampo( IDAT.DAT20_FLAG_ASISTENCIA, dto.getIndicadorAsistencia() );
                    registro.anyadirCampo( IDAT.DAT20_IND_FECHA_FIN_CURSO, dto.getFlagApta() );
                    registro.anyadirCampo( IDAT.DAT20_FLAG_CONTRATADA, new String() );
                    registro.anyadirCampo( IDAT.DAT20_FLAG_TIPO_ACCION, new Integer(tipoAccion));

                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarCapacitacionGerentes  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }

        //Modificado por Sapaza - Fecha 18/09/2007 - cambio Sicc20070392
        //Se actualiza el [indicador envio] para las consultoras enviados en la interfaz
        //dao.actualizarEnvioCursosDat(this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(),this.dtoe.getFechaFacturacion(),ConstantesMAE.OID_TIPO_CLIENTE_GERENTE  );
        if (cursos.size() > 0) 
            dao.actualizarEnvioCursosDat(cursos);
        
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCapacitacionGerentes  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarCapacitacionGerentes(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT20 Procesada" );       
    }

    public DTOSalidaBatch enviarEstatusZona(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarEstatusZona(DTOBatch dtoBatch): Entrada");
        
        String codigo = IDAT.COD_INTERFAZ_DAT27;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarEstatusZona  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarEstatusZona ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
         DAOINTDAT dao= new DAOINTDAT();
         DTOINTEstatusZona dto= new DTOINTEstatusZona();
            ArrayList estatusZonas = dao.obtenerEstatusZona( this.dtoe.getOidPais(), this.dtoe.getOidIdioma() );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(estatusZonas.isEmpty()){//BELC300015312
                  String mensaje = "EstatusZonaFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
          
              int n=estatusZonas.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTEstatusZona)estatusZonas.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTEstatusZona "+ dto);    
                    try{
                          registro.vaciar();
                          registro.anyadirCampo( IDAT.DAT27_CODIGO_STATUS_ZONA, dto.getCodigoEstatusZona() ) ;
                          registro.anyadirCampo( IDAT.DAT27_DESCRIPCION_STATUS_ZONA, dto.getDescripcionEstatusZona() );
                     
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En estatusZonas  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarEstatusZona  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarEstatusZona(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT27 Procesada" );  
    }

    public DTOSalidaBatch enviarProductosReemplazo(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarProductosReemplazo(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT28;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarProductosReemplazo  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarProductosReemplazo ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
           DAOINTDAT dao =new DAOINTDAT();
            
           // java.util.Date fechaUltimaEjecucion = dao.obtenerUltimaFecha( dtoe.getOidPais(), codigo );
            java.util.Date fechaUltimaEjecucion = dao.obtenerUltimaFechaPeriodo( dtoe.getOidPais(), codigo, dtoe.getPeriodoFacturacion() );
            DTOINTProductoReemplazo dto= new DTOINTProductoReemplazo();
            ArrayList productos = dao.obtenerProductosReemplazo( this.dtoe.getOidPais(), this.dtoe.getCanal(), this.dtoe.getMarca(), this.dtoe.getPeriodoFacturacion(),fechaUltimaEjecucion );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(productos.isEmpty()){//BELC300015312
                  String mensaje = "ProductoReemplazoFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
          
              int n=productos.size();
            for (int i=0 ;i<n ;i++ ) {
                 dto =(DTOINTProductoReemplazo)productos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoProductoRemplazo "+ dto);    
                    try{
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_CANAL_VENTA, dto.getCodigoCanalVenta() ); 
                        registro.anyadirCampo( IDAT.DAT28_ANIO_CAMPANIA, dto.getAnioCampania() ); 
                        
                        //[DT]registro.anyadirCampo( IDAT.DAT28_CODIGO_PRODUCTO_REEMPLAZO, dto.codigoProductoReemplazado )
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_PRODUCTO_REEMPLAZADO, dto.getCodigoProductoReemplazado() ); 
                        
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_TIPO_OFERTA_REEMPLAZADO, dto.getCodigoTipoOfertaReemplazado() ); 
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_VENTA_REEMPLAZADO, dto.getCodigoVentaReemplazado() ); 
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_PRODUCTO_REEMPLAZO, dto.getCodigoProductoReemplazo() ); 
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_TIPO_OFERTA_REEMPLAZO, dto.getCodigoTipoOfertaReemplazo() ); 
                        registro.anyadirCampo( IDAT.DAT28_CODIGO_VENTA_REEMPLAZO, dto.getCodigoVentaReemplazo() ); 
                        registro.anyadirCampo( IDAT.DAT28_DESCRIPCION_PRODUCTO_REEMPLAZADO, dto.getDescripcionProductoReemplazado() ); 
                        registro.anyadirCampo( IDAT.DAT28_DESCRIPCION_PRODUCTO_REEMPLAZO, dto.getDescripcionProductoReemplazo() ); 
                        registro.anyadirCampo( IDAT.DAT28_FLAG_TIPO_ACCION, new Integer(ConstantesINT.CONTROL_NOVEDAD_NUEVO) ); 

                    try{

                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarProductosReemplazo  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            // Agregado por cambio 20080664
            this.interfaz.setPeriodo(dtoe.getPeriodoFacturacion());
            //
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarProductosReemplazo  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarProductosReemplazo(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT28 Procesada" );
     }

    public DTOSalidaBatch enviarTiemposCampania(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarTiemposCampania(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT29;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiemposCampania  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTiemposCampania ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
       ArrayList listaPeriodos   =null;
        try{
             listaPeriodos = procesarInterfaz( dtoe.getOidPais(), dtoe.getCanal(), dtoe.getMarca(), dtoe.getPeriodoFacturacion() );
        } catch (MareException e){
            return new DTOSalidaBatch( 0, "TiemposCampaniaFIN sin procesar" );
        }
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if( listaPeriodos.isEmpty() ){
           return new DTOSalidaBatch( 0, "TiemposCampaniaFIN sin procesar" );
        }  */
     

        java.util.Date fechaFacturacion=null;
        DTOINTCampaniaAnio dtoMenor=(DTOINTCampaniaAnio)listaPeriodos.get(0);
        DTOINTCampaniaAnio dto1=null;
        int n=listaPeriodos.size();
        for (int i=1 ;i<n ;i++ ) {
             dto1 =(DTOINTCampaniaAnio)listaPeriodos.get(i);
             if(dtoMenor.getFechaInicio().compareTo(dto1.getFechaInicio())> 0){ //la primera es mas grande luego cambiamos
             //the value 0 if the argument Date is equal to this Date;//a value less than 0 if this Date is before the Date argument;//and a value greater than 0 if this Date is after the Date argument.
                    dtoMenor=dto1;
             
             }
        }//ahora
        
         //busco la mayor fecha de fin de todos los periodos (o sea la fecha de fin del ultimo periodo del año)
         java.util.Date fechaFin=null;
         DTOINTCampaniaAnio dtoMayor=(DTOINTCampaniaAnio)listaPeriodos.get(0);
         DTOINTCampaniaAnio dto2=null;        
         for (int i=1 ;i<n ;i++ ) {
              dto2 =(DTOINTCampaniaAnio)listaPeriodos.get(i);
              if(dtoMayor.getFechaFin().compareTo(dto2.getFechaFin())< 0){ //la primera es mas grande luego cambiamos         
                     dtoMayor=dto2;
              
              }
         }
          
          fechaFin = dtoMayor.getFechaFin();        
         fechaFacturacion=dtoMenor.getFechaInicio();
         CanalLocalHome canalHome=this.getCanalLocalHome();
         CanalLocal canalLocal= null;
         try{
               canalLocal=canalHome.findByPrimaryKey(dtoe.getCanal());
         }catch (NoResultException fe){
               UtilidadesLog.debug(" FinderException en enviarCampanias nos salimos en canal  ");
               String mensaje = "enviarSaldosCobranza: "+ ErroresDeNegocio.INT_0065;
               DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
               this.privadaregistrarError(dtoError, codigo );
               return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
        PeriodoLocalHome periodoHome=this.getPeriodoLocalHome();
        PeriodoLocal periodoLocal=null;
        //modificado por incidencia 20362
        try 
        {
            periodoLocal=periodoHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
        }catch (NoResultException fe)
        {
            UtilidadesLog.debug(" FinderException en enviarCampanias nos salimos  periodo  ");
            String mensaje = "enviarCampanias: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        
        PeriodoCorporativoLocalHome pcorpHome=this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal pCorpLocal=null;
        try{
                //modificado por incidencia 20362
                //pCorpLocal=pcorpHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
                pCorpLocal=pcorpHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        }catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en enviarCampanias nos salimos  periodoCorporativo  ");
             String mensaje = "enviarCampanias: " + ErroresDeNegocio.INT_0061;
             DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
             this.privadaregistrarError( dtoError, codigo );  
   
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
       // el periodo ya viene filtrado de pantalla por pais marca canal , ademas de eso se le estan enviando mal los parametros
       // no se le debe enviar el periodo de parametro si no el obtenido de periodo corporativo
       
     /*  try{ 
            periodoLocal=periodoHome.findByUk(this.dtoe.getPeriodoFacturacion(), this.dtoe.getMarca(),this.dtoe.getOidPais(),this.dtoe.getCanal());
       }catch(FinderException fe){
            String mensaje = "enviarFechaCierreCampania: " + ErroresDeNegocio.INT_0060; //Cuando se construya se cambia DIseño-0060 
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo ); 
            return new DTOSalidaBatch( 0, mensaje );
       }*/
       
/*
TiemposCampanya tiempos = new TiemposCampanya()
tiempos.campanyas = listaPeriodos (línea añadida)
ArrayList tiempoCampanias = tiempos.generarTiemposCampanya( fechaFacturacion, 
periodoCorporativo.codigoPeriodoCorporativo,
periodoCorporativo.año,
canal.codigo )..."
* */

        TiemposCampanya tiempos = new TiemposCampanya();
        tiempos.setCampanyas(listaPeriodos);
        ArrayList tiempoCampanias = tiempos.generarTiempoCampanya( fechaFacturacion,canalLocal.getCodCanal(), pCorpLocal.getCodigoPeriodo(), pCorpLocal.getAnio().toString(), fechaFin);
        //RegistroDiaCampanya dto= new RegistroDiaCampanya();
     
       RegistroDiaCampanya dtoReg = null;

        int n1=tiempoCampanias.size();
        for (int i=0 ;i<n1 ;i++ ) {
             dtoReg =(RegistroDiaCampanya)tiempoCampanias.get(i);
             UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtointcampania "+ dtoReg);    
             UtilidadesLog.debug(" [ "+codigo+" ] dtoReg.getCodPeriodo(): "+ dtoReg.getCodPeriodo());    
                try{
                        registro.vaciar();
                        
                        // gPineda - 06/02/2007 - DBLG70000319 
                        //registro.anyadirCampo( IDAT.DAT29_ANIO_CAMPANIA_ACTUAL , dtoReg.getCodPeriodoActual() );
                        registro.anyadirCampo( IDAT.DAT29_ANIO_CAMPANIA_ACTUAL , dtoReg.getCodPeriodo() );
                        
                        registro.anyadirCampo( IDAT.DAT29_CODIGO_CANAL_VENTA , dtoReg.getCodCanal() );
                        registro.anyadirCampo( IDAT.DAT29_FECHA_DIA_ANIO , dtoReg.getFecha() );
                        registro.anyadirCampo( IDAT.DAT29_ANIO_CONTABLE_DIA , dtoReg.getAnyo() );
                        registro.anyadirCampo( IDAT.DAT29_NUM_TRIMESTRE_ANIO , dtoReg.getTrimestre() );

//        Modificado segun incidencia BELC300021442
//                        registro.anyadirCampo( IDAT.DAT29_PERIODO_BELCORP , dtoReg.getCodPeriodo() );
                        registro.anyadirCampo( IDAT.DAT29_PERIODO_BELCORP, UtilidadCalendarioCampanya.obtenerPeriodoAnio ( dtoReg.getCodPeriodo() ) );  
                        
                        registro.anyadirCampo( IDAT.DAT29_DESCRIPCION_ESTACION , dtoReg.getEstacion() );
                        registro.anyadirCampo( IDAT.DAT29_NUM_SEMESTRE , dtoReg.getSemestre() );
                        registro.anyadirCampo( IDAT.DAT29_NOMBRE_MES , dtoReg.getMes() );
                        registro.anyadirCampo( IDAT.DAT29_NOMBRE_DIA_SEMANA , dtoReg.getDiaSemana() );
                        registro.anyadirCampo( IDAT.DAT29_NUM_SEMANA , dtoReg.getNumSemana() );
                        
                        
                        //registro.anyadirCampo( IDAT.DAT29_IND_FERIADO , dtoReg.getFeriado() );
                        if (dtoReg.getFeriado().booleanValue()){
                            registro.anyadirCampo( IDAT.DAT29_IND_FERIADO , new Integer(1) );
                        }else{
                            registro.anyadirCampo( IDAT.DAT29_IND_FERIADO , new Integer(0) );
                        }
                        
                        //registro.anyadirCampo( IDAT.DAT29_IND_LABORABLE , dtoReg.getLaboral() );
                        if (dtoReg.getLaboral().booleanValue()){
                            registro.anyadirCampo( IDAT.DAT29_IND_LABORABLE , new Integer(1) );
                        }else{
                            registro.anyadirCampo( IDAT.DAT29_IND_LABORABLE , new Integer(0) );
                        }                        
                        
                        //registro.anyadirCampo( IDAT.DAT29_IND_INICIO_PERIODO , dtoReg.getFechaInicio() );
                        if (dtoReg.getFechaInicio().booleanValue()){
                            registro.anyadirCampo( IDAT.DAT29_IND_INICIO_PERIODO , new Integer(1) );
                        }else{
                            registro.anyadirCampo( IDAT.DAT29_IND_INICIO_PERIODO , new Integer(0) );
                        }
                        
                        //registro.anyadirCampo( IDAT.DAT29_IND_FIN_PERIODO, dtoReg.getFechaFin() );
                        if (dtoReg.getFechaFin().booleanValue()){
                            registro.anyadirCampo( IDAT.DAT29_IND_FIN_PERIODO , new Integer(1) );
                        }else{
                            registro.anyadirCampo( IDAT.DAT29_IND_FIN_PERIODO , new Integer(0) );
                        }
                        
                        
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarSaldosCobranza  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTiemposCampania  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarTiemposCampania(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT29 Procesada" );    
    }

    public DTOSalidaBatch enviarFechaCierreCampania(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarFechaCierreCampania(DTOBatch dtoBatch): Entrada");
         String codigo = IDAT.COD_INTERFAZ_DAT33;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarFechaCierreCampania  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarFechaCierreCampania ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
           
           PeriodoLocalHome periodoHome=this.getPeriodoLocalHome();
           PeriodoLocal periodoLocal=null;
           PeriodoCorporativoLocalHome pCorporativoHome= this.getPeriodoCorporativoLocalHome();
           PeriodoCorporativoLocal pCorporativoLocal=null;
           
           
           try{
                //periodoLocal=periodoHome.findByUk(this.dtoe.getPeriodoFacturacion(), this.dtoe.getMarca(),this.dtoe.getOidPais(),this.dtoe.getCanal());
                //
                periodoLocal=periodoHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
           }catch(NoResultException fe){
                String mensaje = "enviarFechaCierreCampania: " + ErroresDeNegocio.INT_0060; //Cuando se construya se cambia DIseño-0060 
                DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                this.privadaregistrarError( dtoError, codigo ); 
                return new DTOSalidaBatch( 0, mensaje );
           }  catch (PersistenceException ce) {   
               UtilidadesLog.error("ERROR ", ce);
               throw new MareException(ce, 
               UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
           }
           
           //Si( periodo.fechaFin != dtoe.fechaFacturacion ) 
//{ 
//return new DTOSalidaBatch( 0, "enviarFechaCierreCampania finalizado sin registros" ) 
//} 
            //si las fechas no son igules nos vamos
           String fecFactu = null;
           String fecPeri = null;
           if((periodoLocal.getFechaFin()!=null)&&(dtoe.getFechaFacturacion()!=null)) { //se comprueba si las fechas son distintas para  salirse
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                UtilidadesLog.debug(periodoLocal.getFechaFin());
                UtilidadesLog.debug(dtoe.getFechaFacturacion());
                UtilidadesLog.debug("-------------------------------");
                java.sql.Date fechaSQLFactu = new java.sql.Date(dtoe.getFechaFacturacion().getTime());
                java.sql.Date fechaSQLPeri = new java.sql.Date(periodoLocal.getFechaFin().getTime());
                fecFactu = sdf.format(fechaSQLFactu); 
                fecPeri = sdf.format(fechaSQLPeri); 
                UtilidadesLog.debug(fecFactu);
                UtilidadesLog.debug(fecPeri);
               /*
               if((periodoLocal.getFechaFin().compareTo(dtoe.getFechaFacturacion()))!=0 ){ //si es igual a cero las fechs son iguales
                    return new DTOSalidaBatch( 0, "FechaCierreCampaFIN sin registros" );
               }
               */
               
               // vbongiov -- 18/10/2006 -- DBLG700000156
               /*if(!fecPeri.equals(fecFactu)){ //si es igual a cero las fechs son iguales
                    return new DTOSalidaBatch( 0, "FechaCierreCampaFIN sin registros" );
               }*/
               
            }
           
           // vbongiov -- 18/10/2006 -- DBLG700000156
           if(fecPeri.equals(fecFactu)){
               try{
                    pCorporativoLocal=pCorporativoHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
               }catch(NoResultException fe){
                    String mensaje = "enviarFechaCierreCampania: " + ErroresDeNegocio.INT_0061;//Cuando Se construya se cambia DIseño-0061 
                    DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                     this.privadaregistrarError( dtoError, codigo ); 
                    return new DTOSalidaBatch( 0, mensaje );
               }  catch (PersistenceException ce) {   
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, 
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
               }        
          
               try{
                      registro.vaciar();
                      registro.anyadirCampo( IDAT.DAT33_ANIO_CAMPANIA, pCorporativoLocal.getCodigoPeriodo() ); 
                      registro.anyadirCampo( IDAT.DAT33_FECHA_CIERRE_PERIODO, periodoLocal.getFechaFin() ); 
                    
                      try{
                          gi.anyadirRegistro(this.interfaz,this.registro);
                      }catch(RemoteException re){                         
                          UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                          throw new MareException(re, UtilidadesError.armarCodigoError(
                              CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        
                        }
                    //Añadido incidencia 13120
                      registro.vaciar();
                  
                  } catch( InterfacesException fex ){ 
                      //- se registra la excepción con el servicio MareLogging
                      UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En Enviarcampañas ");                    
                      registro.vaciar();
                     
                  }
           }
              
            try{ 
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
                
            }catch(RemoteException re){                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
            }
        
        
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarFechaCierreCampania  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarFechaCierreCampania(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT33 Procesada" );      
    }

    public DTOSalidaBatch enviarCampanias(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarCampanias(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT16;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCampanias  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarCampanias ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
       
        ArrayList listaPeriodos   =null;
        try{
             listaPeriodos = procesarInterfaz( dtoe.getOidPais(), dtoe.getCanal(), dtoe.getMarca(), dtoe.getPeriodoFacturacion() );
        } catch (MareException e){
            return new DTOSalidaBatch( 0, "ENVIARCampaniaFIN sin procesar" );
        }
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*
        if( listaPeriodos.isEmpty() ){
           return new DTOSalidaBatch( 0, "ENVIARTiemposCampaniaFIN sin procesar" );
        }  */
        
         CanalLocalHome canalHome=this.getCanalLocalHome();
         CanalLocal canalLocal= null;
     
         try{
               canalLocal=canalHome.findByPrimaryKey(dtoe.getCanal());
         }catch (NoResultException fe){
               UtilidadesLog.debug(" FinderException en enviarCampanias nos salimos en canal  ");
               String mensaje = "enviarSaldosCobranza: "+ ErroresDeNegocio.INT_0065;
               DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
               this.privadaregistrarError(dtoError, codigo );
               return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
    
        PeriodoCorporativoLocalHome pcorpHome=this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal pCorpLocal=null;
        //agregado por incidencia 21440 CNoziglia
        PeriodoLocalHome pDeCraHome = this.getPeriodoLocalHome();
        PeriodoLocal pDeCraLocal= null;
        //-----------
        
        try{
               //agregado por incidencia 21440 CNoziglia
                UtilidadesLog.info("this.dtoe.getPeriodoFacturacion()" + this.dtoe.getPeriodoFacturacion());
                pDeCraLocal=pDeCraHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
                //--------------------------
                UtilidadesLog.info("pDeCraLocal.getOidPeriodoCorporativo()" + pDeCraLocal.getOidPeriodoCorporativo());
                pCorpLocal=pcorpHome.findByPrimaryKey(pDeCraLocal.getOidPeriodoCorporativo());
        }catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en enviarCampanias nos salimos  periodoCorporativo  ");
             String mensaje = "enviarCampanias: " + ErroresDeNegocio.INT_0061;
             DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
             this.privadaregistrarError( dtoError, codigo );  
   
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      
        DTOINTCampaniaAnio dto=null;
        
          
            int n=listaPeriodos.size();
            for (int i=0 ;i<n ;i++ ) { 
                 dto =(DTOINTCampaniaAnio)listaPeriodos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoCampania "+ dto);    
                 UtilidadesLog.debug(" [ "+codigo+" ] dto.getCodPeriodo(): "+ dto.getCodigoPeriodo());    
                  try{
                          UtilidadCalendarioCampanya utilidadCampana=new UtilidadCalendarioCampanya();
                          registro.vaciar();                    
                          registro.anyadirCampo( IDAT.DAT16_ANYO_CAMPANYA, dto.getCodigoPeriodo() );
                          registro.anyadirCampo( IDAT.DAT16_CODIGO_CANAL_VENTA, canalLocal.getCodCanal()  );
                          SimpleDateFormat sdfANIO = new SimpleDateFormat("yyyy");
                          String anio = sdfANIO.format(dto.getFechaInicio()); 

//        Modificado segun incidencia BELC300021442
//                          registro.anyadirCampo( IDAT.DAT16_PERIODO_ANYO, (anio+" "+utilidadCampana.obtenerTrimestre( dto.getFechaInicio())) );                          

                          registro.anyadirCampo( IDAT.DAT16_PERIODO_ANYO,UtilidadCalendarioCampanya.obtenerPeriodoAnio( dto.getCodigoPeriodo() ) );
                          registro.anyadirCampo( IDAT.DAT16_DESCRIPCION_ESTACION, new String() );
                          registro.anyadirCampo( IDAT.DAT16_ANYO_CAMPANYA_ACTUAL, pCorpLocal.getCodigoPeriodo() );                       
                  
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En Enviarcampañas ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarCampanias  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarCampanias(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT16 Procesada" );       
    }

    public DTOSalidaBatch enviarMatrizCampania(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarMatrizCampania(DTOBatch dtoBatch): Entrada");
         UtilidadesLog.debug("****Metodo  enviarMatrizCampania: Entrada");
         String codigo = IDAT.COD_INTERFAZ_DAT11;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarMatrizCampania  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarMatrizCampania ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
         
            DAOINTDAT dao =new DAOINTDAT();
            
            //<inicio>incidencia SiCC-20070218
            //Se busca la ultima fecha procesada para el periodo seleccionado
            java.util.Date ultimaFecha = dao.obtenerUltimaFechaPeriodo( dtoe.getOidPais(), codigo, dtoe.getPeriodoFacturacion());
            boolean esReproceso = false;
          
            //si la ultimaFecha > fechaFacturacion, se busca la ultima fecha procesada
            //que sea menor a la fecha de facturacion ingresada
            if(ultimaFecha != null &&  formateaFecha(dtoe.getFechaFacturacion()).compareTo(formateaFecha(ultimaFecha)) <=0 ) {
                UtilidadesLog.debug("****Metodo  enviarMatrizCampania: FechaFacturacion :" + formateaFecha(dtoe.getFechaFacturacion()));
                UtilidadesLog.debug("****Metodo  enviarMatrizCampania: ultimaFecha :" + formateaFecha(ultimaFecha));                
                
                ultimaFecha = dao.obtenerUltimaFechaMenorFacturacion( dtoe.getOidPais(), codigo, dtoe.getPeriodoFacturacion(), dtoe.getFechaFacturacion());
                esReproceso = true;
            }
            //<fin>incidencia SiCC-20070218
            
            DTOINTMatrizCampania dtoMatrizCampania= new DTOINTMatrizCampania();
            // Cambio SiCC 2070511 - dmorello, 22/01/2008 - Agrego el parametro pais
            ArrayList matrizCampania = dao.obtenerMatrizCampania( this.dtoe.getPeriodoFacturacion(), ultimaFecha, this.dtoe.getOidIdioma(), dtoe.getOidPais() );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(matrizCampania.isEmpty()){//BELC300015312
                  String mensaje = "MatrizCampaniaFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
          
              int n=matrizCampania.size();
            for (int i=0 ;i<n ;i++ ) {
                 dtoMatrizCampania =(DTOINTMatrizCampania)matrizCampania.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoMatrizCampania "+ dtoMatrizCampania);    
                    try{
    
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT11_CODIGO_CANAL_VENTA, dtoMatrizCampania.getCodigoCanal() ); 
                        registro.anyadirCampo( IDAT.DAT11_ANYO_CAMPANYA, dtoMatrizCampania.getAnioCampania() );
                        registro.anyadirCampo( IDAT.DAT11_CODIGO_PRODUCTO, dtoMatrizCampania.getCodigoProducto() ); 
                        registro.anyadirCampo( IDAT.DAT11_CODIGO_TIPO_OFERTA, dtoMatrizCampania.getCodigoTipoOferta() ); 
                        registro.anyadirCampo( IDAT.DAT11_CODIGO_VENTA, dtoMatrizCampania.getCodigoVenta() ); 
                        registro.anyadirCampo( IDAT.DAT11_DESCRIPCION_TIPO_OFERTA, dtoMatrizCampania.getDescripcionTipoOferta() ); 
                        registro.anyadirCampo( IDAT.DAT11_PRECIO_OFERTA, formatearNumero(dtoMatrizCampania.getPrecioOferta()) ); 
                        registro.anyadirCampo( IDAT.DAT11_FLAG_ESTADISTICABLE, dtoMatrizCampania.getFlagEstadisticable() ); 

                       // Cambio SiCC 20070511 - dmorello
                        registro.anyadirCampo(IDAT.DAT11_FLAG_PERTENECE_PROGRAMA_SESSION_EXPERT, dtoMatrizCampania.getFlagPerteneceProgramaSessionExpert()); 

                        /*20090831 SICC-GCC-INT-DAT-2009-001 DAT-11 Retirar Flitro de eventualidad
                        //<inicio>incidencia SiCC-20070218, si fecha de proceso no es nula, se envia 1
                        if(ultimaFecha!=null)
                            registro.anyadirCampo( IDAT.DAT11_FLAG_TIPO_ACCION, new Integer("1") ); 
                        else {
                            if(esReproceso) //si es reproceso se envia 1, sino 0 (nuevo envio para el periodo)
                                registro.anyadirCampo( IDAT.DAT11_FLAG_TIPO_ACCION, new Integer("1") ); 
                            else
                                registro.anyadirCampo( IDAT.DAT11_FLAG_TIPO_ACCION, new Integer("0") ); 
                        }  
                        //<fin>incidencia SiCC-20070218
                        */
                        registro.anyadirCampo( IDAT.DAT11_FLAG_TIPO_ACCION, new Integer("1") );
                        //SE ENVIA PRECIO DE VENTA PROPUESTO S.B
                         registro.anyadirCampo( IDAT.DAT11_PRECIO_VENTA_PROPUESTO, formatearNumero(dtoMatrizCampania.getPrecioVenta()) );
                         registro.anyadirCampo( IDAT.DAT11_PRECIO_VENTA_NORMAL, formatearNumero(dtoMatrizCampania.getPrecioVentaNormal()) );                         
                    try{

                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En EnviarMAtrizCampania  ");                    
                    registro.vaciar();
                    continue;
                }
               
        }//Fin del bucle lista
        
        try{ 
            // Agregado por cambio 20080664
                this.interfaz.setPeriodo(dtoe.getPeriodoFacturacion());
            //
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarMatrizCampania  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarMatrizCampania(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT11 Procesada" );
    }

    public DTOSalidaBatch enviarBoletasDespacho(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarBoletasDespacho(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT12;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarBoletasDespacho  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarBoletasDespacho ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
            String flagPedidoNormal=null;
            DAOINTDAT dao =new DAOINTDAT();
            DTOINTBoletasDespacho dtoBoletasDespacho= new DTOINTBoletasDespacho();
            
            //jrivas 12/12/2006 Se cambio el metodo ppor este mas performante.
            ArrayList boletasDespacho = dao.obtenerBoletasDespachoPerf( this.dtoe.getOidPais(), this.dtoe.getAcceso(), this.dtoe.getPeriodoFacturacion(), this.dtoe.getFechaFacturacion() );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(boletasDespacho.isEmpty()){//BELC300015312
                  String mensaje = "boletasDespachosFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
           
            int n=boletasDespacho.size();
            UtilidadesLog.debug(" El array recibido del dao tiene regsitros= "+n);
            for (int i=0 ;i<n ;i++ ) {
                 dtoBoletasDespacho =(DTOINTBoletasDespacho)boletasDespacho.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoRegiones "+ dtoBoletasDespacho);   
                 
                 //  Modificado por Sapaza - Fecha 03/07/2007 - Incidencia SICC 20070309, tambien se envia devoluciones
                 //  Modificado por HRCS - Fecha 16/03/2007 - Incidencia SICC 20070120
                 //  Se enviara solo las solicitudes O/C y anulaciones
                 /*if (dtoBoletasDespacho.getOidModulo().longValue() != new Long(ConstantesSEG.MODULO_REC).longValue() ||
                     dtoBoletasDespacho.getFlagAnulacion().equals(new Integer(1)) || 
                     dtoBoletasDespacho.getFlagDevolucion().equals(new Integer(1))) {*/
                    try{
    
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT12_ANYO_CAMPANYA_FACTURACION, dtoBoletasDespacho.getAnioCampania() ); 
                        registro.anyadirCampo( IDAT.DAT12_CODIGO_CANAL_VENTA, dtoBoletasDespacho.getCodigoCanal() );//DUDA
                        registro.anyadirCampo( IDAT.DAT12_CODIGO_ACCESO, dtoBoletasDespacho.getCodigoAcceso() ); 
                        registro.anyadirCampo( IDAT.DAT12_NUMERO_DOCUMENTO_FACTURACION, dtoBoletasDespacho.getNumDocumentoFacturacion() ); 
                        registro.anyadirCampo( IDAT.DAT12_CODIGO_TERRITORIO, dtoBoletasDespacho.getCodigoTerritorio() ); 
                        //pzerbino 02/11/2006
                        //registro.anyadirCampo( IDAT.DAT12_CODIGO_CONSULTORA, dtoBoletasDespacho.getCodigoConsultora() ); 
                        int valor = dtoBoletasDespacho.getCodigoConsultora().length();
                        if (valor >= 10){
                              registro.anyadirCampo( IDAT.DAT12_CODIGO_CONSULTORA, dtoBoletasDespacho.getCodigoConsultora().substring(valor-10,valor) ); 
                        }else {
                              registro.anyadirCampo( IDAT.DAT12_CODIGO_CONSULTORA, dtoBoletasDespacho.getCodigoConsultora()); 
                        }
                        
                        registro.anyadirCampo( IDAT.DAT12_FECH_DOCUMENTO, dtoBoletasDespacho.getFechaDocumento() ); 
                       
                        if(dtoBoletasDespacho.getOidConsultora().intValue()==dtoBoletasDespacho.getOidClienteReceptor().intValue())                            { 
                            flagPedidoNormal ="N";
                        }else{flagPedidoNormal = "E"; }
                        
                        registro.anyadirCampo( IDAT.DAT12_FLAG_PEDIDO_NORMAL, flagPedidoNormal ); 
                        registro.anyadirCampo( IDAT.DAT12_FLAG_ANULACION_ORDEN, dtoBoletasDespacho.getFlagAnulacion() ); 
                        
                        if(dtoBoletasDespacho.getVentaFactura()!=null){
                            registro.anyadirCampo( IDAT.DAT12_VENTA_FACTURA, dtoBoletasDespacho.getVentaFactura().setScale(2).toString()); 
                        }else{
                            registro.anyadirCampo( IDAT.DAT12_VENTA_FACTURA,null); 
                        }
                        registro.anyadirCampo( IDAT.DAT12_MONTO_FLETE, formatearNumero(dtoBoletasDespacho.getMontoFlete()) ); 
                        
                        //jrivas 12/12/2006 Este Saldo ahora se trea en la query usando PQ_APL_REP.FN_CU_CALC_SALDO_CTA_CTE
                        /*MONInterfaceModulos monInterfacesModulos=this.getMONInterfaceModulos();
                        String total;
                        try{                       
                            long a = System.currentTimeMillis();
                            total = monInterfacesModulos.calcularSaldosCuentaCorriente(dtoBoletasDespacho.getOidPais(), dtoBoletasDespacho.getOidConsultora());
                            acumul = acumul + (System.currentTimeMillis() - a);
                        }catch (RemoteException re){                        
                                UtilidadesLog.debug("Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        
                        BigDecimal daudaBanco= new BigDecimal("0");
                        if (total!=null){
                           daudaBanco = new BigDecimal(total);
                        }
                        registro.anyadirCampo( IDAT.DAT12_MONTO_FACTURA, daudaBanco) ;*/
                        
                        registro.anyadirCampo( IDAT.DAT12_MONTO_FACTURA, dtoBoletasDespacho.getSaldoCC().setScale(2)) ;
                        registro.anyadirCampo( IDAT.DAT12_NUMERO_CLIENTES, dtoBoletasDespacho.getNumeroClientes() ) ;
   
                  
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                  //Añadido incidencia 13120
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En EnviarBOLETASDESPACHO  ");                    
                    registro.vaciar();
                    continue;
                }
            //}  
        }//Fin del bucle lista
        boletasDespacho = null;
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));              
        }
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarBoletasDepacho  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarBoletasDespacho(DTOBatch dtoBatch): Salida");
        
        this.enviarTransaccionesCliente(dtoBatch);
        
        return new DTOSalidaBatch( 0, "InterfazDAT12 - InterfazDAT24 Procesadas" );      
    }

    public DTOSalidaBatch enviarRegiones(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarRegiones(DTOBatch dtoBatch): Entrada");
        UtilidadesLog.debug("****Metodo  enviarRegiones: Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT13;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarRegiones  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarRegiones ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        DAOINTDAT dao =new DAOINTDAT();
        DTOINTRegiones dtoRegiones= new DTOINTRegiones();
        ArrayList regiones = dao.obtenerRegiones( this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(), this.dtoe.getOidIdioma() );
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if(regiones.isEmpty()){//BELC300015312
              String mensaje = "enviarRegionesFIN SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
       
        int n=regiones.size();
        for (int i=0 ;i<n ;i++ ) {
             dtoRegiones =(DTOINTRegiones)regiones.get(i);
             UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoRegiones "+ dtoRegiones);    
                try{
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT13_CODIGO_SUBGERENCIA, dtoRegiones.getCodigoSGV() ); 
                        registro.anyadirCampo( IDAT.DAT13_NOMBRE_SUBGERENCIA, dtoRegiones.getNombreSGV() ) ;
                        registro.anyadirCampo( IDAT.DAT13_CODIGO_REGION, dtoRegiones.getCodigoRegion() ); 
                        registro.anyadirCampo( IDAT.DAT13_NOMBRE_REGION, dtoRegiones.getNombreRegion() ); 
                        registro.anyadirCampo( IDAT.DAT13_CODIGO_PAIS, dtoRegiones.getCodigoPais() ); 
                        registro.anyadirCampo( IDAT.DAT13_NOMBRE_PAIS, dtoRegiones.getNombrePais() ); 
                        registro.anyadirCampo( IDAT.DAT13_CODIGO_GERENTE_REGIONAL, dtoRegiones.getCodigoGerenteRegional() ); 
                        registro.anyadirCampo( IDAT.DAT13_NOMBRE_GERENTE_REGIONAL, componerNombre( dtoRegiones.getNombre1(), dtoRegiones.getNombre2(), dtoRegiones.getApellido1(), dtoRegiones.getApellido2() ) ) ;
                        registro.anyadirCampo( IDAT.DAT13_CAMPANYA_CREACION_REGION, new String("      ") ); // Blancos, longitud 6 
                        
                        try{
                            gi.anyadirRegistro(this.interfaz,this.registro);
                        }catch(RemoteException re){                             
                            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                            throw new MareException(re, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                          
                          }
                      //Añadido incidencia 13120
                        registro.vaciar();
                    
                    } catch( InterfacesException fex ){ 
                        //- se registra la excepción con el servicio MareLogging
                        UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En EnviarRegiones  ");                        
                        registro.vaciar();
                        continue;
                    }
                   
            }//Fin del bucle lista
            
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarRegiones  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarRegiones(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT13 Procesada" );
    }

    public DTOSalidaBatch enviarSecciones(DTOBatch dtoBatch) throws  MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarSecciones(DTOBatch dtoBatch): Entrada");
         String codigo = IDAT.COD_INTERFAZ_DAT14;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarSecciones  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarSecciones ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
           DAOINTDAT dao =new DAOINTDAT();
        DTOINTSecciones dtoSecciones= new DTOINTSecciones();
        ArrayList secciones = dao.obtenerSecciones( this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal());
        
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if(secciones.isEmpty()){//BELC300015312
              String mensaje = "enviarSeccionesFIN SinRegistros";
              return new DTOSalidaBatch( 0, mensaje );
        }*/
       
        int n=secciones.size();
        for (int i=0 ;i<n ;i++ ) {
             dtoSecciones =(DTOINTSecciones)secciones.get(i);
             UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoRegiones "+ dtoSecciones);    
                try{
                        registro.vaciar();
                        registro.anyadirCampo( IDAT.DAT14_CODIGO_SUBGERENCIA, dtoSecciones.getCodigoSGV() ); 
                        registro.anyadirCampo( IDAT.DAT14_CODIGO_REGION, dtoSecciones.getCodigoRegion() ) ;
                        registro.anyadirCampo( IDAT.DAT14_CODIGO_SECCION, dtoSecciones.getCodigoSeccion() ); 
                        registro.anyadirCampo( IDAT.DAT14_CODIGO_ZONA, dtoSecciones.getCodigoZona() ); 
                        registro.anyadirCampo( IDAT.DAT14_NOMBRE_SUBGERENCIA, dtoSecciones.getNombreSGV() ); 
                        registro.anyadirCampo( IDAT.DAT14_NOMBRE_REGION, dtoSecciones.getNombreRegion() ); 
                        registro.anyadirCampo( IDAT.DAT14_NOMBRE_ZONA, dtoSecciones.getNombreZona() ); 
                        registro.anyadirCampo( IDAT.DAT14_CODIGO_LIDER, dtoSecciones.getCodigoLider() ); 
                        registro.anyadirCampo( IDAT.DAT14_NOMBRE_LIDER,componerNombre( dtoSecciones.getNombre1(), dtoSecciones.getNombre2(), dtoSecciones.getApellido1(), dtoSecciones.getApellido2() ) ) ;
                        registro.anyadirCampo( IDAT.DAT14_FLAG_APTA_LIDER, dtoSecciones.getFlagAptaLider() ); 
                                                                       
                        try{
                            gi.anyadirRegistro(this.interfaz,this.registro);
                        }catch(RemoteException re){                             
                            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                            throw new MareException(re, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                          
                          }
                      //Añadido incidencia 13120
                        registro.vaciar();
                    
                    } catch( InterfacesException fex ){ 
                        //- se registra la excepción con el servicio MareLogging
                        UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarSecciones  ");                        
                        registro.vaciar();
                        continue;
                    }
                   
            }//Fin del bucle lista
            
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
       
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarSecciones  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarSecciones(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT14 Procesada" );     
    }

    public DTOSalidaBatch enviarZonasRealesPorRegion(DTOBatch dtoBatch) throws MareException
    {
         UtilidadesLog.info("MONINTDATBean.enviarZonasRealesPorRegion(DTOBatch dtoBatch): Entrada");
         UtilidadesLog.debug("****Metodo  enviarZonasRealesPorRegion: Entrada");
          String codigo = IDAT.COD_INTERFAZ_DAT34;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarZonasRealesPorRegion  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarZonasRealesPorRegion ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
           DAOINTDAT dao=new DAOINTDAT();
           DTOINTZonasRealesPorRegion dtoZonas= new DTOINTZonasRealesPorRegion();
           ArrayList zonas = dao.obtenerZonasRealesPorRegion( this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal() );
            
           CanalLocalHome canalhome=this.getCanalLocalHome();
           CanalLocal canalLocal=null;
           PeriodoLocalHome periodoHome=this.getPeriodoLocalHome();
           PeriodoLocal periodoLocal=null;
           PeriodoCorporativoLocalHome pCorporativoHome= this.getPeriodoCorporativoLocalHome();
           PeriodoCorporativoLocal pCorporativoLocal=null;
          String codigoCanal=null;
               try{
                    UtilidadesLog.debug("Entramos a buecar a los entitys");
                    canalLocal=canalhome.findByPrimaryKey(this.dtoe.getCanal());
                    
                    UtilidadesLog.debug("primero oid del canal "+canalLocal.getOid());
                     codigoCanal=canalLocal.getCodCanal();
                    UtilidadesLog.debug("primero2 CODIGOCANAL [CS] "+codigoCanal);
                }catch(NoResultException fe){
                    UtilidadesLog.debug("enviarZonasRealesPorRegion No encuentra CANAL");
                    return new DTOSalidaBatch( 0, "ZonasRealesPorRegionFIN sinProcesar " );
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try{
                    periodoLocal=periodoHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());//diseño enviando dtoe.periodo
                    UtilidadesLog.debug("segundo oid del periodo de CRA "+periodoLocal.getOid());
                }
                catch (NoResultException e){
                     UtilidadesLog.debug("enviarZonasRealesPorRegion No encuentra PERIODO");
                    return new DTOSalidaBatch( 0, "ZonasRealesPorRegionFIN sinProcesar " );
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try{
                    pCorporativoLocal=pCorporativoHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());//diseño enviando Periodo.tipoPeriodo
                    UtilidadesLog.debug("tercero oid del SEGperiodoCorporativo "+pCorporativoLocal.getOid());

                }
                catch (NoResultException e){
                      UtilidadesLog.debug("enviarZonasRealesPorRegion No encuentra PERIODOCOPRORATIVO");
                    return new DTOSalidaBatch( 0, "ZonasRealesPorRegionFIN sinProcesar " );
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                String anioCampania=pCorporativoLocal.getCodigoPeriodo();
                UtilidadesLog.debug("aniocampania "+anioCampania);

            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*
            if(zonas.isEmpty()){//BELC300015312
                  String mensaje = "ZonasRealesPorRegionFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            Long cero=new Long("0");
            int n=zonas.size();
            for (int i=0 ;i<n ;i++ ) {
                 dtoZonas =(DTOINTZonasRealesPorRegion)zonas.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr DTOINTZonasRealesPorRegion "+ dtoZonas);    
                    try{
                            registro.vaciar();
                            
                            UtilidadesLog.debug("[cs]1");
                            registro.anyadirCampo( IDAT.DAT34_CODIGO_CANAL_VENTA, codigoCanal ); 
                            UtilidadesLog.debug("[cs]2");
                            registro.anyadirCampo( IDAT.DAT34_ANIO_CAMPANIA, anioCampania ); 
                            UtilidadesLog.debug("[cs]3");
                            registro.anyadirCampo( IDAT.DAT34_CODIGO_REGION, dtoZonas.getCodigoRegion() ); 
                            UtilidadesLog.debug("[cs]4");
                            registro.anyadirCampo( IDAT.DAT34_NUM_ESTIMADO_ZONAS, cero); 
                            UtilidadesLog.debug("[cs]5");
                            registro.anyadirCampo( IDAT.DAT34_NUM_REAL_ZONAS, dtoZonas.getNumZonas() ); 
                            UtilidadesLog.debug("[cs]6");
                            /* public static final String DAT34_CODIGO_CANAL_VENTA   ="codigoCanalVenta"; 
                            public static final String DAT34_ANIO_CAMPANIA   ="anoCampana"; 
                            public static final String DAT34_CODIGO_REGION   ="codigoRegion"; 
                            public static final String DAT34_NUM_ESTIMADO_ZONAS   ="numeroEstimadoZonas"; 
                            public static final String DAT34_NUM_REAL_ZONAS   ="numeroRealZonas"; 
                          */
                            
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              
                              }
                          //Añadido incidencia 13120
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarZonasRealesPorRegion  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
            
         
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarZonasRealesPorRegion  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarZonasRealesPorRegion(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT34 Procesada" );
    }

    public DTOSalidaBatch enviarAccesos(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarAccesos(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT35;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarAccesos  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarAccesos ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        
           
            DAOINTDAT dao =new DAOINTDAT();
            DTOINTAccesos dtoAccesos= new DTOINTAccesos();
            ArrayList accesos = dao.obtenerAccesos(this.dtoe.getCanal(), this.dtoe.getOidIdioma() );
            
            // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(accesos.isEmpty()){//BELC300015312
                  String mensaje = "enviarAccesosFIN SinRegistros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            int n=accesos.size();
            for (int i=0 ;i<n ;i++ ) {
                 dtoAccesos =(DTOINTAccesos)accesos.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGERSAr dtoAccesos "+ dtoAccesos);    
                    try{
                            registro.vaciar();
                            
                            registro.anyadirCampo( IDAT.DAT35_CODIGO_ACCESO, dtoAccesos.getCodigoAcceso() ); 
                            registro.anyadirCampo( IDAT.DAT35_DESCRIPCION_ACCESO, dtoAccesos.getDescripcionAcceso());
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                             
                              }
                          //Añadido incidencia 13120
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarAccesos  ");                            
                             registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
            
         
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarAccesos  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarAccesos(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT35 Procesada" );     
    }

   private ArrayList procesarInterfaz (Long pais, Long canal, Long marca, Long periodo) throws MareException{
        UtilidadesLog.info("MONINTDATBean.procesarInterfaz(Long pais, Long canal, Long marca, Long periodo): Entrada");
        PeriodoCorporativoLocalHome pcorpHome=this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal pcorpLocal=null;
       //agregado por incidencia 21440 CNoziglia
        PeriodoLocalHome pDeCraHome = this.getPeriodoLocalHome();
        PeriodoLocal pDeCraLocal= null;       
       
        Integer anio=null;
        try{
            //agregado por incidencia 21440 CNoziglia
            pDeCraLocal=pDeCraHome.findByPrimaryKey(periodo);
            pcorpLocal=pcorpHome.findByPrimaryKey(pDeCraLocal.getOidPeriodoCorporativo());
            anio =new Integer( pcorpLocal.getAnio().toString()  );// es un campo obligatorio 
            
        }catch (NoResultException e){
            UtilidadesLog.debug("FinderException EN procesarInterfaz PeriodoCorporativo  ");
            throw new MareException("FinderException EN procesarInterfaz PeriodoCorporativo ", e);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
/*   BELC300015957
* procesarInterfaz( pais:Long, marca:Long, canal:Long, periodo:Long ): ArrayList
"
PeriodoCorporativo periodo
periodo = PeriodoCorporativoHome.findByPrimaryKey( periodo )
Integer anio = periodo.año

DTOINTCampaniaAnio dtoCampania
ArrayList listaCampanias = dao.obtenerCampaniasAnio( pais, marca, canal, anio )
Si( listaCampanias.isEmpty() )
{
listaCampanias = dao.obtenerCampaniasAnio( pais, marca, canal, anio+1 )
}

retornar 'listaCampanias'"
* 
* */
        DTOINTCampaniaAnio dtoCampania =null;
        DAOINTDAT dao=new DAOINTDAT();
        ArrayList listaCampanias=dao.obtenerCampaniasAnio(pais,marca,canal,anio);//anio en el dao es integer 
      
        if(listaCampanias.isEmpty()){
                      anio=new Integer(anio.intValue()+1);
                     listaCampanias = dao.obtenerCampaniasAnio( pais, marca, canal, anio );
        }
       
       UtilidadesLog.info("MONINTDATBean.procesarInterfaz(Long pais, Long canal, Long marca, Long periodo): Salida");
       return listaCampanias;
   }
   
   
   private void privadaregistrarError(DTOINTError dtoError, String codigo) throws MareException{
       UtilidadesLog.info("MONINTDATBean.privadaregistrarError(DTOINTError dtoError, String codigo): Entrada");
       
        try {
        
            this.gi.registrarError( dtoError );
            
        } catch (InterfacesException ie){
            UtilidadesLog.error("\n\n InterfacesException PRIVATE registrarError" );
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        } catch (RemoteException re){              
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException En PRIVATE registrarError");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
       
       UtilidadesLog.info("MONINTDATBean.privadaregistrarError(DTOINTError dtoError, String codigo): Salida");
   }
   
    private MONInterfaceModulos getMONInterfaceModulos() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTDATBean.getMONInterfaceModulos(): Entrada");
        MONInterfaceModulosHome home = (MONInterfaceModulosHome)UtilidadesEJB.getHome("MONInterfaceModulos", MONInterfaceModulosHome.class);
        // Se obtiene el interfaz remoto
        MONInterfaceModulos ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en get MONInterfaceModulos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONINTDATBean.getMONInterfaceModulos(): Salida");	        
        return ejb;
	}

   public DTOSalidaBatch enviarInformacionCampania(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONINTDATBean.enviarInformacionCampania(DTOBatch dtoBatch): Entrada");
      String codigo = IDAT.COD_INTERFAZ_DAT21;
      try{        
                init( dtoBatch, codigo );
            }catch(MareException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarInformacionCampania ");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            } 


            DTOINTCargaInicialDAT dtoe= null;
            String usuario = ctx.getCallerPrincipal().getName();
             DAOINTDAT dao =new DAOINTDAT(usuario);
           ArrayList infoCampania = dao.obtenerInfoCampania( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal(), this.dtoe.getAcceso(), this.dtoe.getPeriodoFacturacion(), this.dtoe.getFechaFacturacion());
           
           // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(infoCampania.isEmpty()){
                  String mensaje = "Método enviarInformacionCampania finalizado sin registros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            PeriodoLocalHome pHome=this.getPeriodoLocalHome();
            PeriodoLocal pLocal=null;
            try{
                pLocal=pHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
            }catch(NoResultException fe){
                 UtilidadesLog.debug(" FinderException en enviarInformacionCampania nos salimos  periodo  ");
                 String mensaje = "enviarInformacionCampania: " + ErroresDeNegocio.INT_0060;
                 DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                 this.privadaregistrarError( dtoError, codigo );  
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            PeriodoCorporativoLocalHome pcorpHome=this.getPeriodoCorporativoLocalHome();
            PeriodoCorporativoLocal pCorpLocal=null;
            try{
                pCorpLocal=pcorpHome.findByPrimaryKey(pLocal.getOidPeriodoCorporativo());
            }catch(NoResultException fe){
                 UtilidadesLog.debug(" FinderException en enviarInformacionCampania nos salimos  periodoCorporativo  ");
                 String mensaje = "enviarInformacionCampania: " + ErroresDeNegocio.INT_0061;
                 DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                 this.privadaregistrarError( dtoError, codigo );  
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            CanalLocalHome canalHome=this.getCanalLocalHome();
             CanalLocal canalLocal= null;
         
             try{
                   canalLocal=canalHome.findByPrimaryKey(this.dtoe.getCanal());
             }catch (NoResultException fe){
                   UtilidadesLog.debug(" FinderException en enviarInformacionCampania nos salimos en canal  ");
                   String mensaje = "enviarInformacionCampania: "+ ErroresDeNegocio.INT_0065;
                   DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
                   this.privadaregistrarError(dtoError, codigo );
                   return new DTOSalidaBatch( 0, mensaje );
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
            
            int n=infoCampania.size();
            for (int i=0 ;i<n ;i++ ) {
                 DTOINTInfoCampania  dtoInfoCampania=(DTOINTInfoCampania)infoCampania.get(i);
                    
                    try{
                            registro.vaciar();
                            registro.anyadirCampo( IDAT.DAT21_CODIGO_CANAL_VENTA, canalLocal.getCodCanal());
                            registro.anyadirCampo( IDAT.DAT21_ANIO_CAMPANIA, pCorpLocal.getCodigoPeriodo());
                            registro.anyadirCampo( IDAT.DAT21_TIPO_CAMBIO, dtoInfoCampania.getTipoCambio());
                            registro.anyadirCampo( IDAT.DAT21_MONTO_MINIMO, dtoInfoCampania.getMontoMinimo());
                            registro.anyadirCampo( IDAT.DAT21_NUM_REAL_CLIENTES, dtoInfoCampania.getNumeroClientes());
                            registro.anyadirCampo( IDAT.DAT21_NUM_REAL_PEDIDOS, dtoInfoCampania.getNumeroPedidos());
                            registro.anyadirCampo( IDAT.DAT21_NUM_REAL_ORDENES, dtoInfoCampania.getNumeroOrdenesCompra());
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                                  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              
                              }
                          
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionCampania  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
      UtilidadesLog.debug("**** Metodo MONINTDAT.enviarInformacionCampania: Salida");		        
      UtilidadesLog.info("MONINTDATBean.enviarInformacionCampania(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch( 0, "Interfaz " + codigo + " Procesada" );
   }

   public DTOSalidaBatch enviarInformacionPedidosPorDia(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONINTDATBean.enviarInformacionPedidosPorDia(DTOBatch dtoBatch): Entrada");
       String codigo = IDAT.COD_INTERFAZ_DAT22;    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionPedidosPorDia   ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);

        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarInformacionPedidosPorDia ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
   
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);
        DTOINTInfoCampania dtoInfoCampania = null;            
  
        ArrayList infoCampania = dao.obtenerInfoPedidosPorDia(this.dtoe.getOidPais(),this.dtoe.getMarca(),this.dtoe.getCanal(),this.dtoe.getAcceso(),this.dtoe.getPeriodoFacturacion(),this.dtoe.getFechaFacturacion());
            
        // vbongiov -- 18/10/2006 -- DBLG700000156    
        /*if(infoCampania.isEmpty()){
            String mensaje = "Método enviarInformacionPedidosPorDia finalizado sin registros";
            return new DTOSalidaBatch( 0, mensaje );
        }*/

        PeriodoLocalHome periodoHome = this.getPeriodoLocalHome();
        PeriodoLocal periodoLocal = null;

        try{
            periodoLocal = periodoHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
        }catch(NoResultException fex){
            UtilidadesLog.debug(" FinderException en enviarInformacionPedidosPorDia nos salimos  periodo  ");
            String mensaje = "enviarInformacionPedidosPorDia: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            return new DTOSalidaBatch( 0, mensaje );                 
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
            
        PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal periodoCorporativoLocal = null;
            
        try{
            periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        }catch(NoResultException fex){
            UtilidadesLog.debug(" FinderException en enviarInformacionPedidosPorDia nos salimos  periodoCorporativo  ");
            String mensaje = "enviarInformacionPedidosPorDia: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            return new DTOSalidaBatch( 0, mensaje );                 
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }            
            
        CanalLocalHome canalHome=this.getCanalLocalHome();
        CanalLocal canalLocal= null;
         
        try{
            canalLocal=canalHome.findByPrimaryKey(this.dtoe.getCanal());
        }catch (NoResultException fe){
            UtilidadesLog.debug(" FinderException en enviarInformacionPedidosPorDia nos salimos en canal  ");
            String mensaje = "enviarInformacionPedidosPorDia: "+ ErroresDeNegocio.INT_0065;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
            this.privadaregistrarError(dtoError, codigo );
            return new DTOSalidaBatch( 0, mensaje );
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
                         
        //pzerbino 18/10/2006 Cambios por Incidencia 24361
        
        UtilidadesLog.debug("Antes de llamar a obtenerTipoCambio con this.dtoe " + this.dtoe );    
        BigDecimal tipocambio = dao.obtenerTipoCambio(this.dtoe.getOidPais(),this.dtoe.getFechaFacturacion());
        UtilidadesLog.debug("salio" + tipocambio );    
        
        int n=infoCampania.size();
        UtilidadesLog.debug("infoCampania " + infoCampania);
        UtilidadesLog.debug("salio por n" + n );  
        for (int i=0 ;i<n ;i++ ) {
            dtoInfoCampania =(DTOINTInfoCampania)infoCampania.get(i);
            
            UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGRESAR DTOINTInfoCampania "+ dtoInfoCampania);    
            try{
                registro.vaciar();            
                registro.anyadirCampo( IDAT.DAT22_CODIGO_CANAL_VENTA, canalLocal.getCodCanal());
                registro.anyadirCampo( IDAT.DAT22_CODIGO_EMPRESA, dtoInfoCampania.getCodigoEmpresa()); 
                registro.anyadirCampo( IDAT.DAT22_FECHA_PROCESO, this.dtoe.getFechaFacturacion()); 
                registro.anyadirCampo( IDAT.DAT22_ANIO_CAMPANIA, periodoCorporativoLocal.getCodigoPeriodo());
                registro.anyadirCampo( IDAT.DAT22_NUM_REAL_PEDIDOS, dtoInfoCampania.getNumeroPedidos());
                registro.anyadirCampo( IDAT.DAT22_NUM_REAL_ORDENES, dtoInfoCampania.getNumeroOrdenesCompra());
                registro.anyadirCampo( IDAT.DAT22_TIPO_CAMBIO, tipocambio);
                
                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                    UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i = " +i);
                }catch(RemoteException re){                    
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionPedidosPorDia  ");                
                registro.vaciar();                
                continue;
            }
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarInformacionPedidosPorDia  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarInformacionPedidosPorDia(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
   }

   public DTOSalidaBatch enviarEstatusClientes(DTOBatch dtoBatch) throws MareException {
        
        UtilidadesLog.info("MONINTDATBean.enviarEstatusClientes(DTOBatch dtoBatch): Entrada");
        long time1 = System.currentTimeMillis();
        String codigo = IDAT.COD_INTERFAZ_DAT23;

        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarEstatusClientes ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        //  Agregador por HRCS - Fecha 20/03/2007 - CAMBIO SICC20070118
        RecordSet rs = this.obtenerPeriodoCorpoyCanal(this.dtoe.getPeriodoFacturacion(),this.dtoe.getCanal());
        if (rs.esVacio()){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientes nos salimos  periodo  ");
            String mensaje = "enviarEstatusClientes: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            //return;
            return new DTOSalidaBatch( 0, mensaje );
        }
        Object perioCorpoRef = rs.getValueAt(0,"PERIO_CORPO");
        Object canalRef = rs.getValueAt(0,"CANAL");
        
        if (perioCorpoRef == null){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientes nos salimos  periodoCorporativo  ");
            String mensaje = "enviarEstatusClientes: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            //return;
            return new DTOSalidaBatch( 0, mensaje );
        }else if (canalRef == null){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientes nos salimos en canal  ");
            String mensaje = "enviarEstatusClientes: "+ ErroresDeNegocio.INT_0065;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
            this.privadaregistrarError(dtoError, codigo );
            //return;   
            return new DTOSalidaBatch( 0, mensaje );
        }
        
        String strPerioCorpo = (String)perioCorpoRef;
        String strCanal = (String)canalRef;
        
        RecordSet rsCliente = this.obtenerClientesCierreZonaEstatus(this.dtoe.getPeriodoFacturacion(), this.dtoe.getFechaFacturacion(), codigo,  this.dtoe.getOidPais() );
        
        int n=rsCliente.getRowCount();
        
        for(int i=0 ;i < n; i++){
            Long oidCliente  = new Long (rsCliente.getValueAt(i,"OIDCLIENTE").toString());
            String codigoEstatus = (String) rsCliente.getValueAt(i,"CODIGOESTATUS").toString();
            Long inicadorEstrella = new Long (rsCliente.getValueAt(i,"INDICADORESESTRELLA").toString());
            Object codigoCursoRef =  rsCliente.getValueAt(i,"CODIGOCURSO");
            Long nroTotalOrdenes = new Long (rsCliente.getValueAt(i,"NUMEROTOTALORDENES").toString());
            String codigoCliente = (String) rsCliente.getValueAt(i,"CODIGOCLIENTE").toString();
            Object codigoTerritorio = rsCliente.getValueAt(i,"CODIGOTERRITORIO");
            Integer inicadorDuplaCyzone = new Integer(rsCliente.getValueAt(i,"FLAGDUPLACYZONE").toString());   // Cambio DuplaCyzone 20070163

            try{
                registro.vaciar();
                        
                registro.anyadirCampo( IDAT.DAT23_CODIGO_CANAL_VENTA, strCanal);
                registro.anyadirCampo( IDAT.DAT23_ANIO_CAMPANIA, strPerioCorpo);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_CONSULTORA, codigoCliente);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_TERRITORIO, ((codigoTerritorio== null)?null: new Long (codigoTerritorio.toString())));
                registro.anyadirCampo( IDAT.DAT23_CODIGO_ESTATUS_CONSULTORA, codigoEstatus);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_TIPO_CURSO, ((codigoCursoRef== null)?null: new Long (codigoCursoRef.toString())));
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA, ((inicadorEstrella.longValue()>0)? "1":"0"));
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_COSMETICOS, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_ACCESORIOS, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_SM, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_REGALABLES, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_HOGAR, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_CONSULTORA_TERRITORIAL, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_SELECT, new String());
                registro.anyadirCampo( IDAT.DAT23_CAMPANIA_PROMOCION_SELECT, new String());
                registro.anyadirCampo( IDAT.DAT23_META_SELECT, new BigDecimal("0"));
                if(nroTotalOrdenes.longValue()>0){
                    registro.anyadirCampo( IDAT.DAT23_FLAG_PASE_PEDIDO, new Integer(1));
                }
                else{
                    registro.anyadirCampo( IDAT.DAT23_FLAG_PASE_PEDIDO, new Integer(0));
                }
                
                registro.anyadirCampo(IDAT.DAT23_NUM_TOTAL_ORDENES, nroTotalOrdenes);
                registro.anyadirCampo(IDAT.DAT23_FLAG_DUPLA_CYZONE, inicadorDuplaCyzone);   // Cambio DuplaCyzone 20070163
           
                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                    //  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                }catch(RemoteException re){                                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  }
              
                registro.vaciar();
            
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarEstatusClientesPorCierreZona  ");                            
                registro.vaciar();
                continue;
            } catch (Exception e){
                UtilidadesLog.error("ERROR",e);
                registro.vaciar();
                continue;
            }          
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }        
        
        UtilidadesLog.debug("*[CS]Metodo  enviarEstatusClientes: Salida");		 
        UtilidadesLog.info("MONINTDATBean.enviarEstatusClientes(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0,"Interfaz " + codigo + " procesada");
   }

 /**
  * @CHANGELOG MGRODRIGUEZ Cambios INT-001 
  * Se agrega campos ubicacionGeografica y marcaProducto.
  */
   public DTOSalidaBatch enviarTransaccionesCliente(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarTransaccionesCliente(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT24;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTransaccionesCliente---->Entrada\n\n\n  dTOBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTransaccionesCliente ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
            
        DTOINTCargaInicialDAT dtoe = null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);
        
        //jrivas 18/12/2006 DAT-24
        RecordSet solicitudes = dao.obtenerSolicitudesTransaccionesClientePerf();
        int longi = solicitudes.getRowCount() - 1;
        int f = 0;
        int h = 0;        
        String aux = "";
        ArrayList sOids = new ArrayList();
        
        //<inicio>modificado por Sapaza, en caso que llegue a la fila 500, y sea el mismo cliente
        //se continua con el bucle hasta que el cliente sea diferente
        while (f <= longi) { //Modificado por Sapaza - Fecha 06/08/2007 - incidencia Sicc20070379
            boolean flag = true;
            
            while (f < longi && h < 500) {
                aux = aux + solicitudes.getValueAt(f, 0).toString() + ", ";
                f++;
                h++;
            }
            
            while (f < longi && flag) {
                if (solicitudes.getValueAt(f, 1).toString().equalsIgnoreCase(solicitudes.getValueAt(f-1, 1).toString())) {
                  aux = aux + solicitudes.getValueAt(f, 0).toString() + ", ";
                  f++;
                }
                else {
                  flag = false;
                }
            }            
            
            if (f == longi) {
                aux = aux + solicitudes.getValueAt(f, 0).toString().toString();
                f++;
            }
            else {
                //se corta la ultima coma (, ) del IN de Solicitudes
                aux = aux.substring(0, aux.length() - 2);
            }    
            
            sOids.add(aux);
            h = 0;
            aux = "";
        }   
        //<fin>modificado por Sapaza
        
        aux = null;
       UtilidadesLog.debug("[enviarTransaccionesCliente] SIZE = "+sOids.size());
       int cantEquiv = dao.obtenerCantidadEquivalencias();
       UtilidadesLog.debug("[enviarTransaccionesCliente] CANTIDAD = "+cantEquiv);
       //19-01-2011 PER-SiCC-2011-0044 DOliva
       String indicadorEquivalencia = dao.obtenerIndicadorEquivalencias(this.dtoe.getOidPais());
       UtilidadesLog.debug("[enviarTransaccionesCliente] indicadorEquivalencia = "+indicadorEquivalencia);
       
        for (int m = 0; m < sOids.size(); m++) {
            ArrayList txCliente = new ArrayList();            
            //--------------------- Doliva                      
            if(cantEquiv != 0){
                if(indicadorEquivalencia.equals("1")){
                    UtilidadesLog.warn("Equivalencia con datos - Indicador del bas_pais prendido, se ejecuta con equivalencia");
                    // logica de reemplazos
                    // 1.- Se inserta el resultado obtenido en una tabla temporal
                     UtilidadesLog.debug("[enviarTransaccionesCliente] cargarTemporalTransaccionesClientePerf");
                    dao.cargarTemporalTransaccionesClientePerf((String)sOids.get(m));
                    // 2.- Se ejecuta el proceso de reemplazo x las equivalencias
                     UtilidadesLog.debug("[enviarTransaccionesCliente] ejecutarProcesoEquivalencia");
                    dao.ejecutarProcesoEquivalencia(this.dtoe.getOidPais());
                    // 3.- Se llena txCliente con la data de la tabla temporal agrupada por los criterios del decu
                     UtilidadesLog.debug("[enviarTransaccionesCliente] obtenerEquivalenciaTransaccionesClientePerf");
                    txCliente = dao.obtenerEquivalenciaTransaccionesClientePerf();                                   
                }
                else{
                    UtilidadesLog.warn("Equivalencia con datos - Indicador del bas_pais apagado, se ejecuta como siempre");
                    txCliente = dao.obtenerTransaccionesClientePerf((String)sOids.get(m));// this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(), this.dtoe.getAcceso(), this.dtoe.getPeriodoFacturacion(), this.dtoe.getFechaFacturacion() );
                }
            }                        
            else{
                UtilidadesLog.warn("Equivalencia sin datos - se ejecuta como siempre");
                txCliente = dao.obtenerTransaccionesClientePerf((String)sOids.get(m));// this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(), this.dtoe.getAcceso(), this.dtoe.getPeriodoFacturacion(), this.dtoe.getFechaFacturacion() );
            }
            //---------------------
             sOids.set(m, null);
             int n=txCliente.size();            
            
            for (int i=0 ;i<n ;i++ ) {
    
                DTOINTTxCliente  dTOINTTxCliente=(DTOINTTxCliente)txCliente.get(i);                    
                UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGRESAR DTOINTTxCliente "+ dTOINTTxCliente);    
    
                try{
                    registro.vaciar();
                    
                    registro.anyadirCampo( IDAT.DAT24_ANIO_CAMPANIA_FACTURACION, dTOINTTxCliente.getPeriodoDocumento());
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_CANAL_VENTA, dTOINTTxCliente.getCodigoCanal());
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_ACCESO, dTOINTTxCliente.getCodigoAcceso());
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_PRODUCTO, dTOINTTxCliente.getCodigoProducto()); 
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_TERRITORIO, dTOINTTxCliente.getCodigoTerritorio()); 

                    int valor = dTOINTTxCliente.getCodigoCliente().length();
                    if (valor >= 10){
                            registro.anyadirCampo( IDAT.DAT24_CODIGO_CONSULTORA, dTOINTTxCliente.getCodigoCliente().substring(valor-10,valor) ); 
                    }else {
                            registro.anyadirCampo( IDAT.DAT24_CODIGO_CONSULTORA, dTOINTTxCliente.getCodigoCliente()); 
                    }                           
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_TIPO_OFERTA, dTOINTTxCliente.getTipoOferta()); 
                    registro.anyadirCampo( IDAT.DAT24_NUMERO_SOLICITUD, dTOINTTxCliente.getNumeroSolicitud()); 
                    registro.anyadirCampo( IDAT.DAT24_CODIGO_VENTA, dTOINTTxCliente.getCodigoVenta());
                    registro.anyadirCampo( IDAT.DAT24_ANIO_CAMPANIA_VENTA, dTOINTTxCliente.getPeriodoDocumentoReferencia()); //BELC300016580 
                    registro.anyadirCampo( IDAT.DAT24_FECHA_FACTURACION, this.dtoe.getFechaFacturacion() ); 
                    
                    registro.anyadirCampo( IDAT.DAT24_UNIDADES_ATENDIDAS, dTOINTTxCliente.getUnidadesAtendidas()); 
                    
                    registro.anyadirCampo( IDAT.DAT24_VENTA_NETA, formatearNumero( dTOINTTxCliente.getMontoNetoVenta()) ); 
                    registro.anyadirCampo( IDAT.DAT24_VENTA_FACTURA, formatearNumero( dTOINTTxCliente.getPrecioFacturaTotalLocal() ));
                    registro.anyadirCampo( IDAT.DAT24_UNIDADES_NO_ATENDIDAS, dTOINTTxCliente.getUnidadesNoAtendidas());

                    if(dTOINTTxCliente.getUnidadesDevueltas().longValue() > 0){
                        registro.anyadirCampo( IDAT.DAT24_UNIDADES_DEVUELTAS, dTOINTTxCliente.getUnidadesDevueltas());  // Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147
                    }else{
                        registro.anyadirCampo( IDAT.DAT24_UNIDADES_DEVUELTAS, new Long(0)); 
                    }
                    if(dTOINTTxCliente.getUnidadesAnuladas().longValue() > 0){
                        registro.anyadirCampo( IDAT.DAT24_UNIDADES_ANULADAS, dTOINTTxCliente.getUnidadesAnuladas()); // Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147
                    }else{
                        registro.anyadirCampo( IDAT.DAT24_UNIDADES_ANULADAS, new Long(0));
                    }

                    if ( dTOINTTxCliente.getMontoFaltante()!=null &&
                         !formatearNumero(dTOINTTxCliente.getMontoFaltante()).equals("0.00") )   {
                        BigDecimal ventaFaltante = dTOINTTxCliente.getMontoFaltante(); 
                        registro.anyadirCampo( IDAT.DAT24_VENTA_NETA_FALTANTE , formatearNumero(ventaFaltante));
                    }
                    else    {
                         registro.anyadirCampo( IDAT.DAT24_VENTA_NETA_FALTANTE , formatearNumero(new BigDecimal(0)));
                    }
                    
                    registro.anyadirCampo( IDAT.DAT24_VALOR_NETO_DEVOLUCIONES, formatearNumero(dTOINTTxCliente.getMontoNetoDevolucion())); 
                    registro.anyadirCampo( IDAT.DAT24_VALOR_NETO_ANULACIONES, formatearNumero(dTOINTTxCliente.getMontoNetoAnulacion())); 
                    
                    // vbongiov -- 12/10/2006 - Reversión del cambio "INT-001 Interfaces Calypso-Retail"                            
                    //registro.anyadirCampo( IDAT.DAT24_MARCA_PRODUCTO, dTOINTTxCliente.getMarcaProducto());
                    //registro.anyadirCampo( IDAT.DAT24_UBICACION_GEOGRAFICA, dTOINTTxCliente.getUbicacionGeografica());

                    // Cambio SiCC 20070511 - dmorello
                    registro.anyadirCampo(IDAT.DAT24_TIPO_DOCUMENTO, "N");
                    
                    //campo oportunidad ahoroo
                     registro.anyadirCampo(IDAT.DAT24_OPORTUNIDAD_AHORRO, formatearNumero(dTOINTTxCliente.getOportunidadAhorro()));

                    // sapaza -- PER-SiCC-2011-0566 -- 01/09/2011    
                    registro.anyadirCampo( IDAT.DAT24_UNIDADES_RETORNO, dTOINTTxCliente.getUnidadesRetorno()); 
                    registro.anyadirCampo( IDAT.DAT24_UNIDADES_ATENCION, dTOINTTxCliente.getUnidadesAtencion()); 
                    registro.anyadirCampo( IDAT.DAT24_MONTO_NETO_RETORNO, formatearNumero(dTOINTTxCliente.getMontoNetoRetorno())); 
                    registro.anyadirCampo( IDAT.DAT24_MONTO_NETO_ATENCION, formatearNumero(dTOINTTxCliente.getMontoNetoAtencion())); 
                    
                                        
                        try{
    
                            gi.anyadirRegistro(this.interfaz,this.registro);
                            UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
    
                        }catch(RemoteException re){                                
                            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                            throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
                        }                         
                        
                        registro.vaciar();                        
    
                    } catch( InterfacesException fex ){
                        //- se registra la excepción con el servicio MareLogging
                        UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTransaccionesCliente  ");                        
                        registro.vaciar();
                        continue;
                    }                     
    
                }//Fin del bucle lista               
        }
        try{
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
        }catch(RemoteException re){
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
        }
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarTransaccionesCliente  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarTransaccionesCliente(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "" + codigo + " procesada" );     
   }

   public DTOSalidaBatch enviarResumenTxPorSeccion(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONINTDATBean.enviarResumenTxPorSeccion(DTOBatch dtoBatch): Entrada");
      String codigo = IDAT.COD_INTERFAZ_DAT25;
      //Incidencia BELC300016438
      try{        
                init( dtoBatch, codigo );
            }catch(MareException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarResumenTxPorSeccion ");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            } 


            DTOINTCargaInicialDAT dtoe= null;
            String usuario = ctx.getCallerPrincipal().getName();
             DAOINTDAT dao =new DAOINTDAT(usuario);
           ArrayList listaTx = dao.obtenerResumenTxPorSeccion(this.dtoe.getOidPais(), this.dtoe.getCanal(), this.dtoe.getPeriodoFacturacion());
           
           // vbongiov -- 18/10/2006 -- DBLG700000156
            /*if(listaTx.isEmpty()){
                  String mensaje = "Método enviarResumenTxPorSeccion finalizado sin registros";
                  return new DTOSalidaBatch( 0, mensaje );
            }*/
            
            PeriodoLocalHome pHome=this.getPeriodoLocalHome();
            PeriodoLocal pLocal=null;
            try{
                pLocal=pHome.findByPrimaryKey(this.dtoe.getPeriodoFacturacion());
            }catch(NoResultException fe){
                 UtilidadesLog.debug(" FinderException en enviarResumenTxPorSeccion nos salimos  periodo  ");
                 String mensaje = "enviarResumenTxPorSeccion: " + ErroresDeNegocio.INT_0060;
                 DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                 this.privadaregistrarError( dtoError, codigo );  
                 return new DTOSalidaBatch( 0, mensaje );
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            PeriodoCorporativoLocalHome pcorpHome=this.getPeriodoCorporativoLocalHome();
            PeriodoCorporativoLocal pCorpLocal=null;
            try{
                pCorpLocal=pcorpHome.findByPrimaryKey(pLocal.getOidPeriodoCorporativo());
            }catch(NoResultException fe){
                 UtilidadesLog.debug(" FinderException en enviarResumenTxPorSeccion nos salimos  periodoCorporativo  ");
                 String mensaje = "enviarResumenTxPorSeccion: " + ErroresDeNegocio.INT_0061;
                 DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                 this.privadaregistrarError( dtoError, codigo );  
                 return new DTOSalidaBatch( 0, mensaje );
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            CanalLocalHome canalHome=this.getCanalLocalHome();
             CanalLocal canalLocal= null;
         
             try{
                   canalLocal=canalHome.findByPrimaryKey(this.dtoe.getCanal());
             }catch (NoResultException fe){
                   UtilidadesLog.debug(" FinderException en enviarResumenTxPorSeccion nos salimos en canal  ");
                   String mensaje = "enviarResumenTxPorSeccion: "+ ErroresDeNegocio.INT_0065;
                   DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
                   this.privadaregistrarError(dtoError, codigo );
                   return new DTOSalidaBatch( 0, mensaje );
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
            
            int n=listaTx.size();
            for (int i=0 ;i<n ;i++ ) {
                 DTOINTTxCliente  dtoTxClien=(DTOINTTxCliente)listaTx.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGRESAR DTOINTTxCliente "+ dtoTxClien);
                    try{
                        registro.vaciar();
                            registro.anyadirCampo( IDAT.DAT25_CODIGO_CANAL_VENTA, canalLocal.getCodCanal());
                            registro.anyadirCampo( IDAT.DAT25_ANIO_CAMPANIA_FACTURACION, pCorpLocal.getCodigoPeriodo());
                            registro.anyadirCampo( IDAT.DAT25_CODIGO_ZONA, dtoTxClien.getCodigoZona());
                            
                            // gPineda - 15/02/2007 - CAMBIO INT-DAT-003
                            //registro.anyadirCampo( IDAT.DAT25_CODIGO_SECCION, new String());
                            registro.anyadirCampo( IDAT.DAT25_CODIGO_SECCION, dtoTxClien.getCodigoSeccion() );
                            
                            registro.anyadirCampo( IDAT.DAT25_NUM_TOTAL_ORDENES, dtoTxClien.getNumeroOrdenes());
                            registro.anyadirCampo( IDAT.DAT25_NUM_TOTAL_CLIENTES, dtoTxClien.getNumeroClientes());
                            registro.anyadirCampo( IDAT.DAT25_NUM_TOTAL_CONSULTORAS_ACTIVAS, dtoTxClien.getNumeroConsultorasActivas());
                            registro.anyadirCampo( IDAT.DAT25_NUM_ACTIVAS_INICIO, dtoTxClien.getNumeroActivasInicioCampania());
                            registro.anyadirCampo( IDAT.DAT25_NUM_INGRESOS, dtoTxClien.getNumeroIngresos());
                            registro.anyadirCampo( IDAT.DAT25_NUM_EGRESOS, dtoTxClien.getNumeroEgresos());
                            registro.anyadirCampo( IDAT.DAT25_NUM_CONSULTORAS_REINGRESO, dtoTxClien.getNumeroConsultorasReingreso());
                            registro.anyadirCampo( IDAT.DAT25_NUM_CONSULTORAS_RECIBIDAS, dtoTxClien.getNumeroConsultorasRecibidas());
                            registro.anyadirCampo( IDAT.DAT25_NUM_CONSULTORAS_ENTREGADAS, dtoTxClien.getNumeroConsultorasEntregadas());
                            registro.anyadirCampo( IDAT.DAT25_NUM_REAL_PEDIDOS, dtoTxClien.getNumeroRealPedidos());
                            
                            
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                                  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                            }catch(RemoteException re){
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                                              
                              }
                          
                            registro.vaciar();
                        
                        } catch( InterfacesException fex ){ 
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarResumenTxPorSeccion  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }    
      UtilidadesLog.info("MONINTDATBean.enviarResumenTxPorSeccion(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
   }
   
   /**
     * Metodo que obtiene el resumen de transacciones por zona
     * Modificado por HRCS - Fecha 11/05/2007 - Cambio Sicc20070255
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalidaBatch
     * @param dtoBatch
     */
   public DTOSalidaBatch enviarResumenTxPorZona(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONINTDATBean.enviarResumenTxPorZona(DTOBatch dtoBatch): Entrada");
      String codigo = IDAT.COD_INTERFAZ_DAT26;
      
            try{        
                init( dtoBatch, codigo );
            }catch(MareException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarResumenTxPorZona ");
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
            } 

            DTOINTCargaInicialDAT dtoe= null;
            String usuario = ctx.getCallerPrincipal().getName();
            DAOINTDAT dao =new DAOINTDAT(usuario);
            ArrayList listaTx = dao.obtenerResumenTxPorZona(this.dtoe.getOidPais(), this.dtoe.getCanal(), this.dtoe.getPeriodoFacturacion(),this.dtoe.getMarca());
           
            CanalLocalHome canalHome=this.getCanalLocalHome();
            CanalLocal canalLocal= null;
         
            try{
                   canalLocal=canalHome.findByPrimaryKey(this.dtoe.getCanal());
            }catch (NoResultException fe){
                   UtilidadesLog.debug(" FinderException en enviarResumenTxPorZona nos salimos en canal  ");
                   String mensaje = "enviarResumenTxPorZona: "+ ErroresDeNegocio.INT_0065;
                   DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
                   this.privadaregistrarError(dtoError, codigo );
                   return new DTOSalidaBatch( 0, mensaje );
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            int n=listaTx.size();
            for (int i=0 ;i<n ;i++ ) {
                 DTOINTTxCliente  dtoTxClien=(DTOINTTxCliente)listaTx.get(i);
                 UtilidadesLog.debug(" [ "+codigo+" ] DTO A INGRESAR DTOINTTxCliente "+ dtoTxClien);
                    
                    try {
                            registro.vaciar();
                            registro.anyadirCampo( IDAT.DAT26_CODIGO_CANAL_VENTA, canalLocal.getCodCanal());
                            registro.anyadirCampo( IDAT.DAT26_ANIO_CAMPANIA_FACTURACION, dtoTxClien.getPeriodoDocumento());
                            registro.anyadirCampo( IDAT.DAT26_CODIGO_ZONA, dtoTxClien.getCodigoZona());
                            registro.anyadirCampo( IDAT.DAT26_NUM_TOTAL_ORDENES, dtoTxClien.getNumeroOrdenes());
                            registro.anyadirCampo( IDAT.DAT26_NUM_TOTAL_CLIENTES, dtoTxClien.getNumeroClientes());
                            registro.anyadirCampo( IDAT.DAT26_NUM_TOTAL_CONSULTORAS_ACTIVAS, dtoTxClien.getNumeroConsultorasActivas());
                            registro.anyadirCampo( IDAT.DAT26_NUM_TOTAL_CONSULTORAS_ACTIVAS_INICIO, dtoTxClien.getNumeroActivasInicioCampania());
                            registro.anyadirCampo( IDAT.DAT26_NUM_INGRESOS, dtoTxClien.getNumeroIngresos());
                            registro.anyadirCampo( IDAT.DAT26_NUM_EGRESOS, dtoTxClien.getNumeroEgresos());
                            registro.anyadirCampo( IDAT.DAT26_NUM_CONSULTORAS_REINGRESOS, dtoTxClien.getNumeroConsultorasReingreso());
                            registro.anyadirCampo( IDAT.DAT26_NUM_CONSULTORAS_RECIBIDAS, dtoTxClien.getNumeroConsultorasRecibidas());
                            registro.anyadirCampo( IDAT.DAT26_NUM_CONSULTORAS_ENTREGADAS, dtoTxClien.getNumeroConsultorasEntregadas());
                            registro.anyadirCampo( IDAT.DAT26_NUM_REAL_PEDIDOS, dtoTxClien.getNumeroRealPedidos());
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_UNIDADES_VENDIDAS, new Long(dtoTxClien.getUnidadesVendidas() != null ?
                                                                                                dtoTxClien.getUnidadesVendidas().intValue() : 0)); 
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_VENTAS_NETAS, formatearNumero( dtoTxClien.getEstimadoVentasNetas())); //Incidencia BELC300016657
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_PEDIDOS, dtoTxClien.getEstimadoNumeroPedidos()); 
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_CLIENTES, dtoTxClien.getEstimadoNumeroClientes());
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_ACTIVAS, dtoTxClien.getEstimadoNumeroActivas());
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_INGRESOS, dtoTxClien.getEstimadoNumeroIngresos());
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_EGRESOS, dtoTxClien.getEstimadoNumeroEgresos());
                            registro.anyadirCampo( IDAT.DAT26_ESTIMADO_NUM_REINGRESOS, dtoTxClien.getEstimadoNumeroReingresos()); 

                            //// Cambio SiCC 20070511 - dmorello
                            // Formateo a dos decimales los campos correspondientes
                            /*final BigDecimal cien = new BigDecimal("100");
                            BigDecimal porcentajeRotacion = dtoTxClien.getPorcentajeRotacion().divide(cien, 2, BigDecimal.ROUND_UNNECESSARY);
                            BigDecimal porcentajeEgresos = dtoTxClien.getPorcentajeEgresos().divide(cien, 2, BigDecimal.ROUND_UNNECESSARY);
                            BigDecimal pup = dtoTxClien.getPup().divide(cien, 2, BigDecimal.ROUND_UNNECESSARY);
                            BigDecimal ppu = dtoTxClien.getPpu().divide(cien, 2, BigDecimal.ROUND_UNNECESSARY);*/
                            // Agrego los campos al registro
                            
                            registro.anyadirCampo(IDAT.DAT26_ACTIVIDAD_INFLADA_ZONA, dtoTxClien.getActividadInfladaZona());
                            registro.anyadirCampo(IDAT.DAT26_NRO_CONSULTORAS_CLIENTES_PRIVILEGE, dtoTxClien.getNroConsultorasClientesPrivilege());
                            registro.anyadirCampo(IDAT.DAT26_NRO_CLIENTES_INSCRITOS_PRIVILEGE, dtoTxClien.getNroClientesInscritosPrivilege());
                            registro.anyadirCampo(IDAT.DAT26_NRO_CLIENTES_TRANSACCIONES_PRIVILEGE, dtoTxClien.getNroClientesTransaccionesPrivilege());
                            registro.anyadirCampo(IDAT.DAT26_RETENCION_2DO_PEDIDO, dtoTxClien.getRetencion2doPedido());
                            registro.anyadirCampo(IDAT.DAT26_RETENCION_3ER_PEDIDO, dtoTxClien.getRetencion3erPedido());
                            registro.anyadirCampo(IDAT.DAT26_RETENCION_4TO_PEDIDO, dtoTxClien.getRetencion4toPedido());
                            registro.anyadirCampo(IDAT.DAT26_RETENCION_ACTIVAS, dtoTxClien.getRetencionActivas());
                            registro.anyadirCampo(IDAT.DAT26_PORCENTAJE_ROTACION, dtoTxClien.getPorcentajeRotacion());
                            registro.anyadirCampo(IDAT.DAT26_POSIBLES_EGRESOS, dtoTxClien.getPosiblesEgresos());
                            registro.anyadirCampo(IDAT.DAT26_RETENCION_POSIBLES_EGRESOS, dtoTxClien.getRetencionPosiblesEgresos());
                            registro.anyadirCampo(IDAT.DAT26_PORCENTAJE_EGRESOS, dtoTxClien.getPorcentajeEgresos());
                            registro.anyadirCampo(IDAT.DAT26_PUP, dtoTxClien.getPup());
                            registro.anyadirCampo(IDAT.DAT26_PPU, dtoTxClien.getPpu());
                            //// Fin cambio SiCC 20070511 - dmorello
                            
                            try{
                                gi.anyadirRegistro(this.interfaz,this.registro);
                                  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                            }catch(RemoteException re){                                 
                                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                                throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                          
                            registro.vaciar();
                        
                        } catch( InterfacesException fex )  {
                            //- se registra la excepción con el servicio MareLogging
                            UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarResumenTxPorZona  ");                            
                            registro.vaciar();
                            continue;
                        }
                       
                }//Fin del bucle lista
                
        try {
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      
      UtilidadesLog.debug("**** Metodo MONINTDAT.enviarResumenTxPorZona: Salida");		        
      UtilidadesLog.info("MONINTDATBean.enviarResumenTxPorZona(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
   }


    public DTOSalidaBatch enviarHistoriaCambiosTerritorio(DTOBatch dtoBatch) throws MareException
    {
        UtilidadesLog.info("MONINTDATBean.enviarHistoriaCambiosTerritorio(DTOBatch dtoBatch): Entrada");
        UtilidadesLog.debug("**** Metodo MONINTDAT.enviarHistoriaCambiosTerritorio: Entrada");
        
        String codigo = IDAT.COD_INTERFAZ_DAT9;
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarHistoriaCambiosTerritorio ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        MONINT monINT = this.getMONINT();
        java.util.Date ultimaFecha = null;
        Long[] listaCriterios = {dtoe.getOidPais(),dtoe.getMarca(),dtoe.getCanal(),dtoe.getAcceso()};
        try{
            ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios,codigo);
        }catch(RemoteException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        
        
        //seteamos en el objeto interfazInfo la lista de criterios para posteriormente 
        //actualizar en BD la fecha de ultima ejecucion del histórico de lotes según los criterios 
        String listaCriteriosString = dtoe.getOidPais()+"&"+dtoe.getMarca()+
                "&"+dtoe.getCanal()+"&"+dtoe.getAcceso();
        this.interfaz.setCriteriosConsulta(listaCriteriosString);
        UtilidadesLog.debug("Lista criterios: "+this.interfaz.getCriteriosConsulta());        

        ArrayList listaCambiosTerritorio = null;    
        DAOINTDAT dao =new DAOINTDAT();
        //Modificado por incidencia 18732
        
        listaCambiosTerritorio =dao.obtenerCambiosTerritorio(dtoe.getOidPais(),
            dtoe.getMarca(),dtoe.getCanal(),ultimaFecha);
            
        // vbongiov -- 18/10/2006 -- DBLG700000156
        /*if (listaCambiosTerritorio.size()==0){
            UtilidadesLog.debug("Consulta no ha devuelto datos");
            return new DTOSalidaBatch(0, "enviarHistoriaCambiosTerritorio sin registros");
        }*/
        
        int destinos = 1;
        DTOCambiosTerritorio dto = null;
        DTOCambiosZON dtoCod = null;
        DTOCambiosZON dtoCod1 = null;
        DTOCambiosZON dtoCod2 = null;
        
        for (int i =0; i< listaCambiosTerritorio.size();i++){
            dto = (DTOCambiosTerritorio)listaCambiosTerritorio.get(i);
            
            if (dto.getTipoModificacion().equals(DatoRegistro.TIPO_OPERACION_PARTICION)){
                UtilidadesLog.debug("***El tipo modificacion es igual al tipo de operacion PARTICION");
                dtoCod1 = this.obtenerCodigosCambio(dto.getCodigoUA1(),dto.getCodigoUA2());
            }
            if (dto.getTipoModificacion().equals(DatoRegistro.TIPO_OPERACION_FUSION)){
                UtilidadesLog.debug("***El tipo modificacion es igual al tipo de operacion FUSION");
                //en este caso tenemos 1 origen y 2 destinos, tenemos que enviar dos registros 
                //con el mismo origen y cambiando los destinos 
                dtoCod1 = this.obtenerCodigosCambio(dto.getCodigoUA1(),dto.getCodigoUA2());
                dtoCod2 = this.obtenerCodigosCambio(dto.getCodigoUA1(),dto.getCodigoUA3());
                destinos = 2;
            }
            if (dto.getTipoModificacion().equals(DatoRegistro.TIPO_OPERACION_TRASVASE)){
                UtilidadesLog.debug("***El tipo modificacion es igual al tipo de operacion TRASVASE");
                dtoCod1 = this.obtenerCodigosCambio(dto.getCodigoUA1(),dto.getCodigoUA2());
            }
                
            dtoCod = dtoCod1;
                
            for (int j=1;j<=destinos;j++){
                if (j==2){
                    dtoCod = dtoCod2;
                }
                try{
                    registro.anyadirCampo(IDAT.DAT9_CAMPANIA_MODIFICACION,dto.getCodPeriodo());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_TERRITORIO_ORIGINAL,dtoCod.getCodTerritorioOrigen());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_SECCION_ORIGINAL,dtoCod.getCodSeccionOrigen());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_ZONA_ORIGINAL,dtoCod.getCodZonaOrigen());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_REGION_ORIGINAL,dtoCod.getCodRegionOrigen());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_SUBGERENCIA_ORIGINAL,dtoCod.getCodSGVOrigen());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_TERRITORIO_DESTINO,dtoCod.getCodTerritorioDestino());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_SECCION_DESTINO,dtoCod.getCodSeccionDestino());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_ZONA_DESTINO,dtoCod.getCodZonaDestino());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_REGION_DESTINO,dtoCod.getCodRegionDestino());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_SUBGERENCIA_DESTINO,dtoCod.getCodSGVDestino());
                    registro.anyadirCampo(IDAT.DAT9_CODIGO_NIVEL_CAMBIO,dtoCod.getNivelCambio());
                        
                    //Se añade el registro al fichero de interfaz
                    try{
                        gi.anyadirRegistro(this.interfaz,registro);
                    }catch(RemoteException re){                        
                        UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }catch(InterfacesException iex){
                        //- se registra la excepción con el servicio MareLogging
                        UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarHistoriaCambiosTerritorio ");                        
                    }
                
                    registro.vaciar();
                    
                }catch(InterfacesException iex){
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException en enviarHistoriaCambiosTerritorio");                    
                    registro.vaciar();
                    continue;
                }                   
            }
        }

        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONINTDATBean.enviarHistoriaCambiosTerritorio(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch ( 0, "Interfaz "+codigo + " procesada");
    }

    private MONINT getMONINT() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTDATBean.getMONINT(): Entrada");
        MONINTHome home = (MONINTHome)UtilidadesEJB.getHome("MONINT", MONINTHome.class);
            
        // Se obtiene el interfaz remoto
        MONINT ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONINT",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 	        
        UtilidadesLog.info("MONINTDATBean.getMONINT(): Salida");
        return ejb;
	}
    
    private DTOCodigosZON recuperarCodigos (String codigoUA) throws MareException{
        UtilidadesLog.info("MONINTDATBean.recuperarCodigos(String codigoUA): Entrada");
        //Se recibe el código de la UA, con los que obtendremos del objeto DatoRegistro los codigos de la zonificacion 
        
        String subgerencia = null; 
        String region = null; 
        String zona = null; 
        String seccion = null; 
        Long territorio = null; 
        String nivelCambio = null; 
        
        DatoRegistro datoRegistro = new DatoRegistro(codigoUA); 
        int tipoUnidad = datoRegistro.obtenerTipoUnidad(); 
        
        if (tipoUnidad == datoRegistro.SUBGERENCIA) { 
            subgerencia = datoRegistro.getSubgerencia(); 
            nivelCambio = "G";        
        } else if (tipoUnidad == datoRegistro.REGION) { 
            subgerencia = datoRegistro.getSubgerencia(); 
            region = datoRegistro.getRegion(); 
            nivelCambio = "R"; 
        } else if (tipoUnidad == datoRegistro.ZONA) { 
            subgerencia = datoRegistro.getSubgerencia();
            region = datoRegistro.getRegion(); 
            zona = datoRegistro.getZona(); 
            nivelCambio = "Z";
        } else if (tipoUnidad == datoRegistro.SECCION) { 
            subgerencia = datoRegistro.getSubgerencia();
            region = datoRegistro.getRegion(); 
            zona = datoRegistro.getZona(); 
            seccion = datoRegistro.getSeccion(); 
            nivelCambio = "S";
        
        } else if (tipoUnidad == datoRegistro.TERRITORIO) { 
            subgerencia = datoRegistro.getSubgerencia();
            region = datoRegistro.getRegion(); 
            zona = datoRegistro.getZona(); 
            seccion = datoRegistro.getSeccion(); 
            territorio = new Long(datoRegistro.getTerritorio()); 
            nivelCambio = "T";
        } 
        /*
        Devolver un objeto del tipo DTOCodigosZON con los siguientes atributos: 
        subgerencia = subgerencia 
        region = region 
        zona = zona 
        seccion = seccion 
        territorio = territorio 
        nivelCambio = nivelCambio */
        DTOCodigosZON dtoCodigosZON = new DTOCodigosZON();
        dtoCodigosZON.setSubgerencia(subgerencia);
        dtoCodigosZON.setRegion(region);
        dtoCodigosZON.setZona(zona);
        dtoCodigosZON.setSeccion(seccion);
        dtoCodigosZON.setTerritorio(territorio);
        dtoCodigosZON.setNivelCambio(nivelCambio);
        
        UtilidadesLog.info("MONINTDATBean.recuperarCodigos(String codigoUA): Salida");
        return dtoCodigosZON;
    }

    private DTOCambiosZON obtenerCodigosCambio (String codigoUAOrigen,  String codigoUADestino) throws MareException{
        UtilidadesLog.info("MONINTDATBean.obtenerCodigosCambio(String codigoUAOrigen,  String codigoUADestino): Entrada");
        //vamos a obtener los códigos para cada Unidad Administrativa 
        
        DTOCodigosZON dtoOrigen = recuperarCodigos(codigoUAOrigen); 
        DTOCodigosZON dtoDestino = recuperarCodigos(codigoUADestino); 
        
        /*Devolvemos un objeto del tipo DTOCambiosZON con los siguientes atributos 
        - codigoSGVOrigen = dtoOrigen.subgerencia 
        - codigoRegionOrigen = dtoOrigen.region 
        - codigoZonaOrigen = dtoOrigen.zona 
        - codigoSeccionOrigen = dtoOrigen.seccion 
        - codigoTerritorioOrigen = dtoOrigen.territorio 
        - codigoSGVDestino = dtoDestino.subgerencia 
        - codigoRegionDestino = dtoDestino.region 
        - codigoZonaDestino = dtoDestino.zona 
        - codigoSeccionDestino = dtoDestino.seccion 
        - codigoTerritorioDestino = dtoDestino.territorio 
        - nivelCambio = dtoOrigen.nivelCambio //el nivel de cambio es el mismo para el origen y para el destino.
        */
        DTOCambiosZON dtoCambiosZON = new DTOCambiosZON();
        dtoCambiosZON.setCodSGVOrigen(dtoOrigen.getSubgerencia());
        dtoCambiosZON.setCodRegionOrigen(dtoOrigen.getRegion());
        dtoCambiosZON.setCodZonaOrigen(dtoOrigen.getZona());
        dtoCambiosZON.setCodSeccionOrigen(dtoOrigen.getSeccion());
        dtoCambiosZON.setCodTerritorioOrigen(dtoOrigen.getTerritorio());
        dtoCambiosZON.setCodSGVDestino(dtoDestino.getSubgerencia());
        dtoCambiosZON.setCodRegionDestino(dtoDestino.getRegion());
        dtoCambiosZON.setCodZonaDestino(dtoDestino.getZona());
        dtoCambiosZON.setCodSeccionDestino(dtoDestino.getSeccion());
        dtoCambiosZON.setCodTerritorioDestino(dtoDestino.getTerritorio());
        dtoCambiosZON.setNivelCambio(dtoOrigen.getNivelCambio());
        
        UtilidadesLog.info("MONINTDATBean.obtenerCodigosCambio(String codigoUAOrigen,  String codigoUADestino): Salida");
        return dtoCambiosZON;
    }
    
    private String componerUbigeo(String ubigeo1, String ubigeo2, String ubigeo3, 
        String ubigeo4, String ubigeo5, String ubigeo6, String ubigeo7, String ubigeo8, 
        String ubigeo9) {
        
        UtilidadesLog.info("MONINTDATBean.componerUbigeo(String ubigeo1, String ubigeo2, String ubigeo3, String ubigeo4, String ubigeo5, String ubigeo6, String ubigeo7, String ubigeo8, String ubigeo9): Entrada");
        
        String ubigeo = new String();
        
        if(ubigeo1!=null) {
            ubigeo += ubigeo1;        
            
            if(ubigeo2!=null) {
                ubigeo += ubigeo2;        
                
                if(ubigeo3!=null) {
                    ubigeo += ubigeo3;
                    
                    if(ubigeo4!=null) {
                        ubigeo += ubigeo4;        
                        
                        if(ubigeo5!=null) {
                            ubigeo += ubigeo5;
                            
                            if(ubigeo6!=null) {
                                ubigeo += ubigeo6; 
                                
                                if(ubigeo7!=null) {
                                    ubigeo += ubigeo7;        
                                    
                                    if(ubigeo8!=null) {
                                        ubigeo += ubigeo8;
                                        
                                        if(ubigeo9!=null) {
                                            ubigeo += ubigeo9;        
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        UtilidadesLog.info("MONINTDATBean.componerUbigeo(String ubigeo1, String ubigeo2, String ubigeo3, String ubigeo4, String ubigeo5, String ubigeo6, String ubigeo7, String ubigeo8, String ubigeo9): Salida");
        return ubigeo;
    }
    
    /**
     * Recibe una lista de cobranzas ORDENADA POR CODZONA
     * @return Lista de grupos de cobranzas
     * @param cobranzas
     */
    private ArrayList agruparPorCodigoZona(ArrayList cobranzas){
        UtilidadesLog.info("MONINTDATBean.agruparPorCodigoZona(ArrayList cobranzas): Entrada");
        ArrayList resultado=new ArrayList();
        
        //Iniciar a 0 los sumatorios
        long totalMontDeudaPend=0;
        long totalCargosDirectos=0;
        long totalAjustesNotasCred=0;
        long totalDepuraciones=0;
        long totalabonos21dias=0;
        long totalabonos31dias=0;
        long totalabonos42dias=0;
        long totalabonos63dias=0;
        long totalabonosMayores63dias=0;
        
        int tam=cobranzas.size();
        
        DTOINTCobranza cobranzaAct=null;
        DTOINTCobranza grupoCobranzas=null;
        String codigoZona=((DTOINTCobranza)cobranzas.get(0)).getCodigoZona();
        
        
        for(int i=0;i<tam;i++){
            cobranzaAct=(DTOINTCobranza)cobranzas.get(i);
            if(cobranzaAct!=null){
                if(cobranzaAct.getCodigoZona().equals(codigoZona)){
                    //Sumamos
                    if(cobranzaAct.getMontoDeudaPendiente()!=null){
                        totalMontDeudaPend+=cobranzaAct.getMontoDeudaPendiente().longValue();
                    }
                    if(cobranzaAct.getTotalCargosDirectos()!=null){
                        totalCargosDirectos+=cobranzaAct.getTotalCargosDirectos().longValue();
                    }
                    if(cobranzaAct.getTotalAjustesNotasCreditos()!=null){
                        totalAjustesNotasCred+=cobranzaAct.getTotalAjustesNotasCreditos().longValue();
                    }
                    if(cobranzaAct.getTotalDepuraciones()!=null){
                        totalDepuraciones+=cobranzaAct.getTotalDepuraciones().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios21Dias()!=null){
                        totalabonos21dias+=cobranzaAct.getAbonosMonetarios21Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios31Dias()!=null){
                        totalabonos31dias+=cobranzaAct.getAbonosMonetarios31Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios42Dias()!=null){
                        totalabonos42dias+=cobranzaAct.getAbonosMonetarios42Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios63Dias()!=null){
                        totalabonos63dias+=cobranzaAct.getAbonosMonetarios63Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetariosMayores63Dias()!=null){
                        totalabonosMayores63dias+=cobranzaAct.getAbonosMonetariosMayores63Dias().longValue();
                    }
                }
                else{//Ha cambiado el codigoZona
                    //Almacenar el grupo de cobranzas anterior
                    grupoCobranzas=new DTOINTCobranza();
                    grupoCobranzas.setCodigoZona(codigoZona);                
                    grupoCobranzas.setMontoDeudaPendiente(new BigDecimal(totalMontDeudaPend));
                    grupoCobranzas.setTotalCargosDirectos(new BigDecimal(totalCargosDirectos));
                    grupoCobranzas.setTotalAjustesNotasCreditos(new BigDecimal(totalAjustesNotasCred));
                    grupoCobranzas.setTotalDepuraciones(new BigDecimal(totalDepuraciones));
                    grupoCobranzas.setAbonosMonetarios21Dias(new BigDecimal(totalabonos21dias));
                    grupoCobranzas.setAbonosMonetarios31Dias(new BigDecimal(totalabonos31dias));
                    grupoCobranzas.setAbonosMonetarios42Dias(new BigDecimal(totalabonos42dias));
                    grupoCobranzas.setAbonosMonetarios63Dias(new BigDecimal(totalabonos63dias));                    
                    grupoCobranzas.setAbonosMonetariosMayores63Dias(new BigDecimal(totalabonosMayores63dias));
                    resultado.add(grupoCobranzas);
                    
                    codigoZona=((DTOINTCobranza)cobranzas.get(i)).getCodigoZona(); //Ha cambiado el codigo
                    
                    //Reiniciar contadores
                    totalMontDeudaPend=0;
                    totalCargosDirectos=0;
                    totalAjustesNotasCred=0;
                    totalDepuraciones=0;
                    totalabonos21dias=0;
                    totalabonos31dias=0;
                    totalabonos42dias=0;
                    totalabonos63dias=0;
                    totalabonosMayores63dias=0;
                    
                    //Sumamos el actual
                    if(cobranzaAct.getMontoDeudaPendiente()!=null){
                        totalMontDeudaPend+=cobranzaAct.getMontoDeudaPendiente().longValue();
                    }
                    if(cobranzaAct.getTotalCargosDirectos()!=null){
                        totalCargosDirectos+=cobranzaAct.getTotalCargosDirectos().longValue();
                    }
                    if(cobranzaAct.getTotalAjustesNotasCreditos()!=null){
                        totalAjustesNotasCred+=cobranzaAct.getTotalAjustesNotasCreditos().longValue();
                    }
                    if(cobranzaAct.getTotalDepuraciones()!=null){
                        totalDepuraciones+=cobranzaAct.getTotalDepuraciones().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios21Dias()!=null){
                        totalabonos21dias+=cobranzaAct.getAbonosMonetarios21Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios31Dias()!=null){
                        totalabonos31dias+=cobranzaAct.getAbonosMonetarios31Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios42Dias()!=null){
                        totalabonos42dias+=cobranzaAct.getAbonosMonetarios42Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetarios63Dias()!=null){
                        totalabonos63dias+=cobranzaAct.getAbonosMonetarios63Dias().longValue();
                    }
                    if(cobranzaAct.getAbonosMonetariosMayores63Dias()!=null){
                        totalabonosMayores63dias+=cobranzaAct.getAbonosMonetariosMayores63Dias().longValue();
                    }                
                }
            }
        }
        UtilidadesLog.info("MONINTDATBean.agruparPorCodigoZona(ArrayList cobranzas): Salida");
        return resultado;
    }  
    
    public void enviarEstatusClientesPorCierreZona(DTOFACProcesoCierre dtoe) throws MareException {        
        UtilidadesLog.info("MONINTDATBean.enviarEstatusClientesPorCierreZona(DTOFACProcesoCierre dtoe): Entrada"); 
        String codigo = IDAT.COD_INTERFAZ_DAT23;
        this.gi=this.getMONGestorInterfaces();
        this.registro=new RegistroSicc();      

        
            
        RecordSet rs = this.obtenerPeriodoCorpoyCanal(dtoe.getPeriodo(),dtoe.getCanal());
        if (rs.esVacio()){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientesPorCierreZona nos salimos  periodo  ");
            String mensaje = "enviarEstatusClientesPorCierreZona: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            return;
        }
        Object perioCorpoRef = rs.getValueAt(0,"PERIO_CORPO");
        Object canalRef = rs.getValueAt(0,"CANAL");
        
        if (perioCorpoRef == null){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientesPorCierreZona nos salimos  periodoCorporativo  ");
            String mensaje = "enviarEstatusClientesPorCierreZona: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
            this.privadaregistrarError( dtoError, codigo );  
            return;
        }else if (canalRef == null){
            UtilidadesLog.debug(" FinderException en enviarEstatusClientesPorCierreZona nos salimos en canal  ");
            String mensaje = "enviarEstatusClientesPorCierreZona: "+ ErroresDeNegocio.INT_0065;
            DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje );
            this.privadaregistrarError(dtoError, codigo );
            return;   
        }
        
        String strPerioCorpo = (String)perioCorpoRef;
        String strCanal = (String)canalRef;
        
        //RecordSet rsCliente = this.obtenerClientesCierreZonaEstatus(dtoe.getPeriodo(),dtoe.getZona(), dtoe.getRegion());
        RecordSet rsCliente = this.obtenerClientesCierreZonaEstatus(dtoe.getPeriodo(), dtoe.getFechaFacturacion(), codigo, this.dtoe.getOidPais());
        
        try{
            this.interfaz = gi.crearInterfaz(codigo, dtoe.getOidPais());
        }catch( InterfacesException fex ){
            UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarResumenTxPorSeccion  ");                
            registro.vaciar();
        }catch(RemoteException re){                
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        int n=rsCliente.getRowCount();
        
        for(int i=0 ;i < n; i++){
            Long oidCliente  = new Long (rsCliente.getValueAt(i,"OIDCLIENTE").toString());
            String codigoEstatus = (String) rsCliente.getValueAt(i,"CODIGOESTATUS").toString();
            Long inicadorEstrella = new Long (rsCliente.getValueAt(i,"INDICADORESESTRELLA").toString());
            Object codigoCursoRef =  rsCliente.getValueAt(i,"CODIGOCURSO");
            Long nroTotalOrdenes = new Long (rsCliente.getValueAt(i,"NUMEROTOTALORDENES").toString());
            String codigoCliente = (String) rsCliente.getValueAt(i,"CODIGOCLIENTE").toString();
            Object codigoTerritorio = rsCliente.getValueAt(i,"CODIGOTERRITORIO");

            try{
                registro.vaciar();
                        
                registro.anyadirCampo( IDAT.DAT23_CODIGO_CANAL_VENTA, strCanal);
                registro.anyadirCampo( IDAT.DAT23_ANIO_CAMPANIA, strPerioCorpo);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_CONSULTORA, codigoCliente);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_TERRITORIO, ((codigoTerritorio== null)?null: new Long (codigoTerritorio.toString())));
                registro.anyadirCampo( IDAT.DAT23_CODIGO_ESTATUS_CONSULTORA, codigoEstatus);
                registro.anyadirCampo( IDAT.DAT23_CODIGO_TIPO_CURSO, ((codigoCursoRef== null)?null: new Long (codigoCursoRef.toString())));
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA, ((inicadorEstrella.longValue()>0)? "1":"0"));
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_COSMETICOS, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_ACCESORIOS, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_SM, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_REGALABLES, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_ESTRELLA_HOGAR, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_CONSULTORA_TERRITORIAL, new String());
                registro.anyadirCampo( IDAT.DAT23_FLAG_SELECT, new String());
                registro.anyadirCampo( IDAT.DAT23_CAMPANIA_PROMOCION_SELECT, new String());
                registro.anyadirCampo( IDAT.DAT23_META_SELECT, new BigDecimal("0"));
                if(nroTotalOrdenes.longValue()>0){
                    registro.anyadirCampo( IDAT.DAT23_FLAG_PASE_PEDIDO, new Integer(1));
                }
                else{
                    registro.anyadirCampo( IDAT.DAT23_FLAG_PASE_PEDIDO, new Integer(0));
                }
                
                registro.anyadirCampo(IDAT.DAT23_NUM_TOTAL_ORDENES, nroTotalOrdenes);
           
                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                    //  UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro numero i= " +i);
                }catch(RemoteException re){                                 
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  }
              
                registro.vaciar();
            
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarEstatusClientesPorCierreZona  ");                            
                registro.vaciar();
                continue;
            } catch (Exception e){
                UtilidadesLog.error("ERROR",e);
                registro.vaciar();
                continue;
            }
                       
        }//Fin del bucle lista
                
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
      //Cronometrador.endTransaction("PP_enviarEstatusClientesPorCierreZona");
      UtilidadesLog.info("MONINTDATBean.enviarEstatusClientesPorCierreZona(DTOFACProcesoCierre dtoe): Salida"); 
   }
   


    /**
    * @Correccion SiCC 20070312 Se comporta erroneamente el group by con el nvl.
    */
    private RecordSet obtenerClientesCierreZonaEstatus(Long oidPeriodo, Date fechaFacturacion, String codigoInterface, Long codigoPais) throws MareException{ 
        RecordSet resultado=null;
        try {
            StringBuffer query = new StringBuffer();
            Vector parametros = new Vector();
            SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
            DAOINTDAT dao =new DAOINTDAT();
            
            String fechaUltimoProc = dao.obtenerUltimaFechaProceHistoLotesSTR( codigoInterface,  codigoPais );
            
            query.append(" SELECT   oidcliente, ");
            query.append(" codigoestatus, ");
            query.append(" indicadoresestrella, ");
            query.append(" codigocurso, ");
            query.append(" codigocliente, ");
            query.append(" codigoterritorio, ");
            query.append(" numerototalordenes, ");
            query.append(" flagduplacyzone ");  // Cambio DuplaCyzone 20070163
            query.append(" FROM ( ");
            /* Clientes que sufrieron cierre de su region */
            query.append(" (SELECT   cli.oid_clie oidcliente, ");
            //  Modificado por HRCS - Fecha 26/03/2007
            //  Recuperado de DAOINTDAT.obtenerEstatusClientes2
            query.append(" SUBSTR(");
            query.append(" CASE WHEN EST.COD_ESTA_CLIE = '"+ ConstantesMAE.ESTATUS_EGRESADA +"' AND ADI.NUM_CAMP_SIN_PEDI > "+ ConstantesINT.NRO_CAMP_SIN_PEDI +" THEN '"+ ConstantesMAE.ESTATUS_RETIRADO +"' ELSE ");
            query.append(" CASE WHEN EST.COD_ESTA_CLIE = '"+ ConstantesMAE.ESTATUS_REACTIVADO +"' THEN '"+ ConstantesMAE.ESTATUS_NUEVO +"' ELSE EST.COD_ESTA_CLIE END END ");
            query.append(" ,2,1) CODIGOESTATUS, ");
            query.append(" (SELECT COUNT (*) ");
            query.append(" FROM v_mae_tipif_clien vtc ");
            query.append(" WHERE vtc.ticl_oid_tipo_clie = "+ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            query.append(" AND vtc.tccl_oid_tipo_clasi = "+ConstantesMAE.OID_TIPO_CLASIFICACION_ESTRELLA);
            query.append(" AND vtc.clas_oid_clas = "+ConstantesMAE.OID_CLASIFICACION_ESTRELLA);
            query.append(" AND clie_oid_clie = cli.oid_clie) indicadoresestrella, ");
            query.append(" (SELECT mcur.cod_curs ");
            query.append(" FROM edu_histo_curso hcur, ");
            query.append(" edu_matri_curso mcur, ");
            query.append(" (SELECT   fec_inic, fec_fina ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = " + oidPeriodo);
            query.append(" ORDER BY fec_fina) peri ");
            query.append(" WHERE hcur.clie_oid_clie = cli.oid_clie ");
            query.append(" AND mcur.oid_curs = hcur.mcur_oid_curs ");
            query.append(" AND peri.fec_inic <= mcur.fec_fin_curs ");
            query.append(" AND (   mcur.fec_fin_curs IS NULL ");
            query.append(" OR (peri.fec_fina >= mcur.fec_fin_curs) ");
            query.append(" )) codigocurso, ");
            query.append(" 0 numerototalordenes, cli.cod_clie codigocliente, ");
            query.append(" terr.cod_terr codigoterritorio, ");
            query.append(" (SELECT COUNT(*) ");
            query.append("  FROM mae_clien_clasi mcc, ");
            query.append("       mae_clien_tipo_subti mcts, ");
            query.append("       mae_clasi mc, ");
            query.append("       mae_tipo_clasi_clien mtcc, ");
            query.append("       mae_subti_clien msc, ");
            query.append("       mae_tipo_clien mtc ");
            query.append("  WHERE mcc.ctsu_oid_clie_tipo_subt = mcts.oid_clie_tipo_subt ");
            query.append("    AND mcc.clas_oid_clas = mc.oid_clas ");
            query.append("    AND mcc.tccl_oid_tipo_clasi = mtcc.oid_tipo_clas ");
            query.append("    AND mcts.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
            query.append("    AND mcts.sbti_oid_subt_clie = msc.oid_subt_clie ");
            query.append("    AND mcts.clie_oid_clie = cli.oid_clie ");
            query.append("    AND mc.cod_clas = '"+ConstantesMAE.COD_CLASIFICACION_DULPACYZONE +"' ");
            query.append("    AND mtcc.cod_tipo_clas = '"+ConstantesMAE.COD_TIPO_CLASIFICACION_DULPACYZONE +"' ");
            query.append(" ) flagduplacyzone "); // Cambio DuplaCyzone 20070163
            query.append(" FROM mae_clien_unida_admin adm, ");
            query.append(" mae_clien cli, ");
            query.append(" zon_terri_admin tadm, ");
            query.append(" zon_terri terr, ");
            query.append(" zon_secci secc, ");
            query.append(" mae_clien_datos_adici adi, ");
            query.append(" mae_estat_clien est, ");
            query.append(" cra_perio per_ini, ");
            query.append(" (SELECT DISTINCT zorg_oid_regi ");
            query.append(" FROM fac_contr_cierr c, fac_tipos_cierr tc ");
            query.append(" WHERE zorg_oid_regi IS NOT NULL ");
            query.append(" AND c.tcie_oid_tipo_cier = tc.oid_tipo_cier ");
            query.append(" AND tc.cod_tipo_cier = '"+ ConstantesFAC.TIPO_CIERRE_REGION +"' ");
            query.append(" AND perd_oid_peri = " + oidPeriodo);            
            if (fechaUltimoProc != null) //modificado por Sapaza, fecha 24-01-2008, incidencia SiCC-20080548
                query.append(" AND c.fec_ulti_actu between to_date('"+ fechaUltimoProc +"', 'YYYY-MM-DD HH24:MI:SS') AND SYSDATE ");
            query.append(" ) controlcierre, ");
            query.append(" zon_zona zon_zon, ");
            query.append(" (SELECT fec_inic, fec_fina, oid_peri ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = " + oidPeriodo+" ) per_ref ");
            query.append(" WHERE adm.clie_oid_clie = cli.oid_clie ");
            query.append(" AND adm.ztad_oid_terr_admi = tadm.oid_terr_admi ");
            query.append(" AND tadm.zscc_oid_secc = secc.oid_secc ");
            query.append(" AND secc.ind_acti = 1 and secc.ind_borr = 0 ");
            query.append(" AND adi.clie_oid_clie = cli.oid_clie ");
            query.append(" AND adi.esta_oid_esta_clie = est.oid_esta_clie ");
            query.append(" AND adi.ind_acti = 1 ");
            query.append(" AND tadm.terr_oid_terr = terr.oid_terr ");
            query.append(" AND terr.ind_borr = 0 ");
            query.append(" AND secc.zzon_oid_zona = zon_zon.oid_zona ");
            query.append(" AND zon_zon.ind_acti = 1 and zon_zon.ind_borr = 0 ");
            query.append(" AND adm.ind_acti = 1 ");
            query.append(" AND adm.perd_oid_peri_ini = per_ini.oid_peri ");
            query.append(" AND per_ref.fec_inic >= per_ini.fec_inic ");
            query.append(" AND controlcierre.zorg_oid_regi = zon_zon.zorg_oid_regi ");
            query.append(" AND (   adm.perd_oid_peri_fin IS NULL ");
            query.append(" OR (SELECT fec_fina ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = adm.perd_oid_peri_fin) <= ");
            query.append(" per_ref.fec_fina ");
            query.append(" ) ");
            query.append(" GROUP BY cli.oid_clie, ");
            query.append(" est.cod_esta_clie, ");
            query.append(" adi.num_camp_sin_pedi, ");
            query.append(" 'indicadoresestrella', ");
            query.append(" 'codigocurso', ");
            query.append(" cli.cod_clie, ");
            query.append(" terr.cod_terr, ");
            query.append(" 'flagduplacyzone' ");  // Cambio DuplaCyzone 20070163
            query.append(" ) ");
            query.append(" UNION ");          
            /* Clientes que pasaron pedido el dia de hoy pero no corrieron el cierre de su region*/
            query.append(" (SELECT   cli.oid_clie oidcliente, ");
            //  Modificado por HRCS - Fecha 26/03/2007
            //  Recuperado de DAOINTDAT.obtenerEstatusClientes2
            query.append(" SUBSTR(");
            query.append(" CASE WHEN EST.COD_ESTA_CLIE = '"+ ConstantesMAE.ESTATUS_EGRESADA +"' AND ADI.NUM_CAMP_SIN_PEDI > "+ ConstantesINT.NRO_CAMP_SIN_PEDI +" THEN '"+ ConstantesMAE.ESTATUS_RETIRADO +"' ELSE ");
            query.append(" CASE WHEN EST.COD_ESTA_CLIE = '"+ ConstantesMAE.ESTATUS_REACTIVADO +"' THEN '"+ ConstantesMAE.ESTATUS_NUEVO +"' ELSE EST.COD_ESTA_CLIE END END ");
            query.append(" ,2,1) CODIGOESTATUS, ");
            query.append(" (SELECT COUNT (*) ");
            query.append(" FROM v_mae_tipif_clien vtc ");
            query.append(" WHERE vtc.ticl_oid_tipo_clie = "+ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            query.append(" AND vtc.tccl_oid_tipo_clasi = "+ConstantesMAE.OID_TIPO_CLASIFICACION_ESTRELLA);
            query.append(" AND vtc.clas_oid_clas = "+ConstantesMAE.OID_CLASIFICACION_ESTRELLA);
            query.append(" AND clie_oid_clie = cli.oid_clie) indicadoresestrella, ");
            query.append(" (SELECT mcur.cod_curs ");
            query.append(" FROM edu_histo_curso hcur, ");
            query.append(" edu_matri_curso mcur, ");
            query.append(" (SELECT   fec_inic, fec_fina ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = " + oidPeriodo);
            query.append(" ORDER BY fec_fina) peri ");
            query.append(" WHERE hcur.clie_oid_clie = cli.oid_clie ");
            query.append(" AND mcur.oid_curs = hcur.mcur_oid_curs ");
            query.append(" AND peri.fec_inic <= mcur.fec_fin_curs ");
            query.append(" AND (   mcur.fec_fin_curs IS NULL ");
            query.append(" OR (peri.fec_fina >= mcur.fec_fin_curs) ");
            query.append(" )) codigocurso, ");
            query.append(" COUNT (soc.oid_soli_cabe) numerototalordenes, ");
            query.append(" cli.cod_clie codigocliente, ");
            query.append(" terr.cod_terr codigoterritorio, ");
            query.append(" (SELECT COUNT(*) ");
            query.append("  FROM mae_clien_clasi mcc, ");
            query.append("       mae_clien_tipo_subti mcts, ");
            query.append("       mae_clasi mc, ");
            query.append("       mae_tipo_clasi_clien mtcc, ");
            query.append("       mae_subti_clien msc, ");
            query.append("       mae_tipo_clien mtc ");
            query.append("  WHERE mcc.ctsu_oid_clie_tipo_subt = mcts.oid_clie_tipo_subt ");
            query.append("    AND mcc.clas_oid_clas = mc.oid_clas ");
            query.append("    AND mcc.tccl_oid_tipo_clasi = mtcc.oid_tipo_clas ");
            query.append("    AND mcts.ticl_oid_tipo_clie = mtc.oid_tipo_clie ");
            query.append("    AND mcts.sbti_oid_subt_clie = msc.oid_subt_clie ");
            query.append("    AND mcts.clie_oid_clie = cli.oid_clie ");
            query.append("    AND mc.cod_clas = '"+ConstantesMAE.COD_CLASIFICACION_DULPACYZONE +"' ");
            query.append("    AND mtcc.cod_tipo_clas = '"+ConstantesMAE.COD_TIPO_CLASIFICACION_DULPACYZONE +"' ");
            query.append(" ) flagduplacyzone "); // Cambio DuplaCyzone 20070163
            query.append(" FROM mae_clien_unida_admin adm, ");
            query.append(" mae_clien cli, ");
            query.append(" zon_terri_admin tadm, ");
            query.append(" zon_terri terr, ");
            query.append(" zon_secci secc, ");
            query.append(" cra_perio per_ini, ");
            query.append(" ped_solic_cabec soc, ");
            query.append(" mae_clien_datos_adici adi, ");
            query.append(" mae_estat_clien est, ");
            query.append(" zon_zona zon_zon, ");
            query.append(" (SELECT fec_inic, fec_fina, oid_peri ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = " + oidPeriodo+" ) per_ref ");
            query.append(" WHERE adm.clie_oid_clie = cli.oid_clie ");
            query.append(" AND adm.ztad_oid_terr_admi = tadm.oid_terr_admi ");
            query.append(" AND tadm.zscc_oid_secc = secc.oid_secc ");
            query.append(" AND secc.ind_acti = 1 and secc.ind_borr = 0 ");
            query.append(" AND tadm.terr_oid_terr = terr.oid_terr ");
            query.append(" AND terr.ind_borr = 0 ");
            query.append(" AND secc.zzon_oid_zona = zon_zon.oid_zona ");
            query.append(" AND zon_zon.ind_acti = 1 and zon_zon.ind_borr = 0 ");
            query.append(" AND adm.ind_acti = 1 ");
            query.append(" AND adm.perd_oid_peri_ini = per_ini.oid_peri ");
            query.append(" AND per_ref.fec_inic >= per_ini.fec_inic ");
            query.append(" AND zon_zon.zorg_oid_regi NOT IN ( ");
            query.append(" SELECT DISTINCT zorg_oid_regi ");
            query.append(" FROM fac_contr_cierr c, fac_tipos_cierr tc ");
            query.append(" WHERE zorg_oid_regi IS NOT NULL ");
            query.append(" AND c.tcie_oid_tipo_cier = tc.oid_tipo_cier ");
            query.append(" AND tc.cod_tipo_cier = '"+ ConstantesFAC.TIPO_CIERRE_REGION +"' ");
            query.append(" AND perd_oid_peri = " + oidPeriodo);
            if (fechaUltimoProc != null) //modificado por Sapaza, fecha 24-01-2008, incidencia SiCC-20080548
                query.append(" AND c.fec_ulti_actu between to_date('"+ fechaUltimoProc +"', 'YYYY-MM-DD HH24:MI:SS') AND SYSDATE ");
            query.append(" ) ");
            query.append(" AND (   adm.perd_oid_peri_fin IS NULL ");
            query.append(" OR (SELECT fec_fina ");
            query.append(" FROM cra_perio ");
            query.append(" WHERE oid_peri = adm.perd_oid_peri_fin) <= ");
            query.append(" per_ref.fec_fina ");
            query.append(" ) ");
            query.append(" AND soc.clie_oid_clie = cli.oid_clie ");
            query.append(" AND soc.ind_ts_no_conso = 1 ");
            query.append(" AND soc.ind_oc = 1 ");
            query.append(" AND soc.ind_pedi_prue <> 1 ");
            query.append(" AND soc.modu_oid_modu <> " + ConstantesSEG.MODULO_REC );
            query.append(" AND soc.perd_oid_peri = " + oidPeriodo);
            query.append(" AND soc.fec_fact = to_date('"+sf.format(fechaFacturacion)+"','dd-MM-yyyy') ");
            query.append(" AND adi.clie_oid_clie = cli.oid_clie ");
            query.append(" AND adi.esta_oid_esta_clie = est.oid_esta_clie ");
            query.append(" AND adi.ind_acti = 1 ");
            query.append(" GROUP BY cli.oid_clie, ");
            query.append(" est.cod_esta_clie, ");
            query.append(" adi.num_camp_sin_pedi, ");            
            query.append(" 'indicadoresestrella', ");
            query.append(" 'codigocurso', ");
            query.append(" cli.cod_clie, ");
            query.append(" terr.cod_terr, ");
            query.append(" 'flagduplacyzone' ");   // Cambio DuplaCyzone 20070163
            query.append(" )) a ");
            query.append(" ORDER BY oidcliente ");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerClientesCierreZonaEstatus  SQL: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 
        return resultado;
        
    }
    
     private RecordSet obtenerPeriodoCorpoyCanal(Long oidPeriodo,  Long oidCanal) throws MareException{ 
        RecordSet resultado=null;
        StringBuffer query = new StringBuffer();
        query.append(" SELECT ");
        query.append("  (SELECT spc.cod_peri ");
        query.append("   FROM CRA_PERIO cp, seg_perio_corpo spc ");
        query.append("   WHERE cp.oid_peri = " + oidPeriodo);
        query.append("   AND cp.peri_oid_peri = spc.oid_peri) PERIO_CORPO ");
        query.append("  ,(SELECT sc.cod_cana codigocanal ");
        query.append("    FROM seg_canal sc ");
        query.append("    WHERE sc.oid_cana = " +oidCanal+ ") CANAL ");
        query.append(" FROM DUAL ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerPeriodoCorpoyCanal  : Exception= "+ e.getMessage());
            UtilidadesLog.error(" obtenerPeriodoCorpoyCanal  SQL: "+ query.toString());
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        return resultado;
        
    }
    
    
   public DTOSalidaBatch enviarSaldosCobranza(DTOBatch dtoBatch) throws MareException    {
    
        UtilidadesLog.info("MONINTDATBean.enviarSaldosCobranza(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT32;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarSaldosCobranza  ---->Entrada\n\n\n  dtoBatch   " +dtoBatch);
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarSaldosCobranza ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        Long oidPais  = this.dtoe.getOidPais();
        Long oidMarca = this.dtoe.getMarca();
        Long oidCanal = this.dtoe.getCanal();
        Date fechaFacturacion = this.dtoe.getFechaFacturacion();
        Long periodoFacturacion = this.dtoe.getPeriodoFacturacion();
        
        java.sql.Date fecha1 = new java.sql.Date(fechaFacturacion.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFac = sdf.format(fecha1);

        RecordSet rs = null;
        
        rs = this.obtenerPeriodoCorpoyCanal(periodoFacturacion, oidCanal);
        
        String codigoPeriodo = new String();
        String codigoCanal = new String();
        if (rs != null && !rs.esVacio()) {
            codigoPeriodo = rs.getValueAt(0,"PERIO_CORPO").toString();
            codigoCanal = rs.getValueAt(0,"CANAL").toString();
        }

        rs = this.obtenerZonas(oidPais, oidCanal, oidMarca);
        
        HashMap hashZonas = new HashMap();
        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {
              DTODAT32 dto32 = new DTODAT32();
              dto32.setCodigoZona(rs.getValueAt(i,"COD_ZONA").toString());    
              
              //modificado por Sapaza, fecha 12-10-2007, incidencia Sicc20070476
              dto32.setAbonos21dias(new BigDecimal("0"));   
              dto32.setAbonos31dias(new BigDecimal("0"));   
              dto32.setAbonos42dias(new BigDecimal("0"));   
              dto32.setAbonos63dias(new BigDecimal("0"));   
              dto32.setAbonosMayores63dias(new BigDecimal("0"));
              
              Long oidZona = this.bigDecimalToLong(rs.getValueAt(i,"OID_ZONA"));
              hashZonas.put(oidZona, dto32);
            }          
        }    

        rs = this.obtenerMontoDeudaPendiente(oidPais, oidCanal, oidMarca, fechaFac);

        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {              
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              dto32.setMontoDeudaPendiente((BigDecimal)rs.getValueAt(i,"IMP_PEND"));                                
            }          
        }    

        rs = this.obtenerTotalCargosDirectos(oidPais, oidCanal, oidMarca);

        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {              
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              dto32.setTotalCargosDirectos((BigDecimal)rs.getValueAt(i,"IMP"));                                
            }          
        }    

        rs = this.obtenerTotalAjustesNC(oidPais, oidCanal, oidMarca);

        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {              
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              dto32.setTotalAjustesNC((BigDecimal)rs.getValueAt(i,"IMP"));                                
            }          
        }    

        rs = this.obtenerDepuraciones(oidPais, oidCanal, oidMarca);

        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {              
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              dto32.setTotalDepuraciones((BigDecimal)rs.getValueAt(i,"IMP_PEND"));                                
            }          
        }    
        
        rs = this.obtenerImportesMCC(oidPais, oidCanal, oidMarca, fechaFac);
        
        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {  
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              BigDecimal total = (BigDecimal)rs.getValueAt(i,"IMP_PEND");
              dto32.setAbonos21dias(total);   
              dto32.setAbonos31dias(total);   
              dto32.setAbonos42dias(total);   
              dto32.setAbonos63dias(total);   
              dto32.setAbonosMayores63dias(total);
            }
        }
        
        rs = this.obtenerImportesHistoricoCC(oidPais, oidCanal, oidMarca, fechaFac);

        if (rs != null && !rs.esVacio()) {
            int longRS = rs.getRowCount();
            UtilidadesLog.debug("Cantidad Rs " + longRS);
            for (int i=0;i< longRS ;i++) {              
              DTODAT32 dto32 = (DTODAT32)hashZonas.get(this.bigDecimalToLong(rs.getValueAt(i,"ZZON_OID_ZONA")));
              dto32.setAbonos21dias(new BigDecimal(dto32.getAbonos21dias().doubleValue() + ((BigDecimal)rs.getValueAt(i,"IMP_PEND_21")).doubleValue()));   
              dto32.setAbonos31dias(new BigDecimal(dto32.getAbonos31dias().doubleValue() + ((BigDecimal)rs.getValueAt(i,"IMP_PEND_31")).doubleValue()));   
              dto32.setAbonos42dias(new BigDecimal(dto32.getAbonos42dias().doubleValue() + ((BigDecimal)rs.getValueAt(i,"IMP_PEND_42")).doubleValue()));   
              dto32.setAbonos63dias(new BigDecimal(dto32.getAbonos63dias().doubleValue() + ((BigDecimal)rs.getValueAt(i,"IMP_PEND_63")).doubleValue()));   
              dto32.setAbonosMayores63dias(new BigDecimal(dto32.getAbonosMayores63dias().doubleValue() + ((BigDecimal)rs.getValueAt(i,"IMP_PEND_MAYOR_63")).doubleValue()));   }          
        }   
        
        
        Iterator it = (Iterator)((Collection)hashZonas.values()).iterator();
        while (it.hasNext()){
             DTODAT32 dto32 = (DTODAT32)it.next();
            
             try{
                    registro.vaciar();
                    registro.anyadirCampo( IDAT.DAT32_CAMPANIA_FACTURADA, codigoPeriodo );
                    registro.anyadirCampo( IDAT.DAT32_CODIGO_CANAL_VENTA, codigoCanal );
                    registro.anyadirCampo( IDAT.DAT32_CODIGO_ZONA, dto32.getCodigoZona());
                    registro.anyadirCampo( IDAT.DAT32_MONTO_DEUDA_PENDIENTE, dto32.getMontoDeudaPendiente() ); 
                    registro.anyadirCampo( IDAT.DAT32_TOTAL_CARGOS_DIRECTOS,  dto32.getTotalCargosDirectos()  ); 
                    registro.anyadirCampo( IDAT.DAT32_TOTAL_AJUSTES_NOTAS_CREDITO, dto32.getTotalAjustesNC() ); 
                    registro.anyadirCampo( IDAT.DAT32_TOTAL_DEPURACIONES, dto32.getTotalDepuraciones() ); 
                    registro.anyadirCampo( IDAT.DAT32_ABONOS_MONETARIOS_21_DIAS, dto32.getAbonos21dias() ); 
                    registro.anyadirCampo( IDAT.DAT32_ABONOS_MONETARIOS_31_DIAS, dto32.getAbonos31dias()); 
                    registro.anyadirCampo( IDAT.DAT32_ABONOS_MONETARIOS_42_DIAS, dto32.getAbonos42dias()); 
                    registro.anyadirCampo( IDAT.DAT32_ABONOS_MONETARIOS_63_DIAS, dto32.getAbonos63dias() ); 
                    registro.anyadirCampo( IDAT.DAT32_ABONOS_MONETARIOS_MAYORES_63_DIAS, dto32.getAbonosMayores63dias()); 

                  
      
                    try{
                        gi.anyadirRegistro(this.interfaz,this.registro);
                    }catch(RemoteException re){                         
                        UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                      
                      }
                    registro.vaciar();
                
                } catch( InterfacesException fex ){ 
                    UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarSaldosCobranza  ");                    
                    registro.vaciar();
                    continue;
                }

        }// fin for ZONAS
        
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            
        }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              
        }
        
        UtilidadesLog.info("MONINTDATBean.enviarSaldosCobranza(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "InterfazDAT32 Procesada" );       
    } 
    
    
    private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Salida");  
    return rs;
  }
  
   private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
   }
   
   private RecordSet obtenerZonas(Long oidPais, Long oidCanal, Long oidMarca) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append(" SELECT ZON.OID_ZONA, ");
      query.append(" ZON.COD_ZONA");
      query.append(" FROM ZON_ZONA ZON");
      query.append(" WHERE ZON.PAIS_OID_PAIS = " + oidPais);
      query.append("   AND ZON.CANA_OID_CANA = " + oidCanal);
      query.append("   AND ZON.MARC_OID_MARC = " + oidMarca);
      query.append("   AND ZON.IND_ACTI = 1");
      query.append("   AND ZON.IND_BORR <> 1 ");
      query.append(" ORDER BY COD_ZONA");
      
      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   

   private RecordSet obtenerMontoDeudaPendiente(Long oidPais, Long oidCanal, Long oidMarca, String fechaFac) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append(" SELECT SUM (M.IMP_PEND) IMP_PEND,ZZON_OID_ZONA ");
      query.append(" FROM CCC_MOVIM_CUENT_CORRI M,       ");
      query.append(" (SELECT U.OID_MARC_SITU");
      query.append(" FROM CCC_MARCA_SITUA U,");
      query.append(" CCC_MARCA_TIPO_ABONO M,");
      query.append(" CCC_TIPO_ABONO_SUBPR T,");
      query.append(" CCC_SUBPR S,");
      query.append(" CCC_PROCE P");
      query.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI");
      query.append(" AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP");
      query.append(" AND T.SUBP_OID_SUBP = S.OID_SUBP");
      query.append(" AND S.CCPR_OID_PROC = P.OID_PROC");
      query.append(" AND S.COD_SUBP = 1");
      query.append(" AND P.COD_PROC = 'CON001'");
      query.append(" AND U.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND M.IND_ENTR_SALI LIKE 'E') MARCASITU,");
      query.append(" ZON_SECCI SEC, ");
      query.append(" ZON_ZONA ZON	    ");
      query.append(" WHERE M.ZSCC_OID_SECC = SEC.OID_SECC");
      query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA");
      query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
      query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
      query.append(" AND ZON.IND_ACTI = 1");
      query.append(" AND ZON.IND_BORR <> 1 ");
      query.append(" AND FEC_DOCU > TO_DATE((SELECT TO_CHAR(TO_DATE('"+fechaFac+"','YYYY-MM-DD'),'DD-MM')||'-'||(TO_CHAR(TO_DATE('"+fechaFac+"','YYYY-MM-DD'),'YYYY') - 5) FECHA_ANT ");
   	  query.append(" FROM DUAL),'DD-MM-YYYY')");
      query.append(" AND FEC_DOCU <= TO_DATE('"+fechaFac+"','yyyy-MM-dd')  ");
      query.append(" AND M.IMP_PEND <> 0");
      query.append(" AND M.MASI_OID_MARC_SITU = MARCASITU.OID_MARC_SITU");
      query.append(" GROUP BY ZZON_OID_ZONA    "); 
     
      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   

  private RecordSet obtenerTotalCargosDirectos(Long oidPais, Long oidCanal, Long oidMarca) throws MareException{
      StringBuffer query = new StringBuffer();
        query.append(" SELECT SUM (cd.imp) IMP, ZZON_OID_ZONA ");
        query.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC CD,");
        query.append(" CCC_TIPO_ABONO_SUBPR CT,");
        query.append(" CCC_MOVIM_CUENT_CORRI MCC,");
        query.append(" ZON_SECCI SEC,");
        query.append(" INT_TIPOS_ABONO_DAT ITA,");
        query.append(" ZON_ZONA ZON	");
        query.append(" WHERE CD.TASP_OID_TIPO_ABON_SUBP = CT.OID_TIPO_ABON_SUBP");
        query.append(" AND CT.TCAB_OID_TCAB = ITA.TCAB_OID_TIPO_CARG_ABON");
        query.append(" AND ITA.IND_INDI IN ('C')");
        query.append(" AND MCC.ZSCC_OID_SECC = SEC.OID_SECC");
        query.append(" AND MCC.OID_MOVI_CC = CD.MVCC_OID_MOVI_CC");
        query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA");
        query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
        query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
        query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
        query.append(" AND ZON.IND_ACTI = 1");
        query.append(" AND ZON.IND_BORR <> 1 ");
        query.append(" GROUP BY ZZON_OID_ZONA");
  
      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   

  private RecordSet obtenerTotalAjustesNC(Long oidPais, Long oidCanal, Long oidMarca) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append(" SELECT SUM (cd.imp) IMP, ZZON_OID_ZONA ");
      query.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC CD,");
      query.append(" CCC_TIPO_ABONO_SUBPR CT,");
      query.append(" CCC_MOVIM_CUENT_CORRI MCC,");
      query.append(" ZON_SECCI SEC,");
      query.append(" INT_TIPOS_ABONO_DAT ITA,");
      query.append(" ZON_ZONA ZON	");
      query.append(" WHERE CD.TASP_OID_TIPO_ABON_SUBP = CT.OID_TIPO_ABON_SUBP");
      query.append(" AND CT.TCAB_OID_TCAB = ITA.TCAB_OID_TIPO_CARG_ABON");
      query.append(" AND ITA.IND_INDI IN ('A','N')");
      query.append(" AND MCC.ZSCC_OID_SECC = SEC.OID_SECC");
      query.append(" AND MCC.OID_MOVI_CC = CD.MVCC_OID_MOVI_CC");
      query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA");
      query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
      query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
      query.append(" AND ZON.IND_ACTI = 1");
      query.append(" AND ZON.IND_BORR <> 1 ");
      query.append(" GROUP BY ZZON_OID_ZONA");
    
      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   
   
   
   
   private RecordSet obtenerDepuraciones(Long oidPais, Long oidCanal, Long oidMarca) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append(" SELECT SUM(MCC.IMP_PEND) IMP_PEND, ZZON_OID_ZONA ");
      query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC,");
      query.append(" (SELECT U.OID_MARC_SITU ");
      query.append(" FROM CCC_MARCA_SITUA U,");
      query.append(" CCC_MARCA_TIPO_ABONO M,");
      query.append(" CCC_TIPO_ABONO_SUBPR T,");
      query.append(" CCC_SUBPR S,");
      query.append(" CCC_PROCE P");
      query.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI");
      query.append(" AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP");
      query.append(" AND T.SUBP_OID_SUBP = S.OID_SUBP");
      query.append(" AND S.CCPR_OID_PROC = P.OID_PROC");
      query.append(" AND S.COD_SUBP = 1");
      query.append(" AND P.COD_PROC = 'CON001'");
      query.append(" AND U.IND_CUEN_CAST = 1");
      query.append(" AND U.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND M.IND_ENTR_SALI LIKE 'E') MARCASITU,");
      query.append(" ZON_SECCI SEC,");
      query.append(" ZON_ZONA ZON");
      query.append(" WHERE MCC.IMP_PEND <> 0   ");
      query.append(" AND MCC.MASI_OID_MARC_SITU = MARCASITU.OID_MARC_SITU ");
      query.append(" AND MCC.ZSCC_OID_SECC = SEC.OID_SECC");
      query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA");
      query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
      query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
      query.append(" AND ZON.IND_ACTI = 1");
      query.append(" AND ZON.IND_BORR <> 1");
      query.append(" GROUP BY ZZON_OID_ZONA  ");  
    
    
      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   


  private RecordSet obtenerImportesMCC(Long oidPais, Long oidCanal, Long oidMarca, String fechaFac) throws MareException{
      StringBuffer query = new StringBuffer();
      query.append(" SELECT ZZON_OID_ZONA, ");
      query.append(" SUM(MCC.IMP_PEND) IMP_PEND");
      query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC,");
      query.append(" ZON_SECCI SEC,");
      query.append(" ZON_ZONA ZON");
      query.append(" WHERE MCC.ZSCC_OID_SECC = SEC.OID_SECC");
      query.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA");
      query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
      query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
      query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
      query.append(" AND ZON.IND_ACTI = 1");
      query.append(" AND ZON.IND_BORR <> 1");
      query.append(" AND MCC.FEC_DOCU = TO_DATE('"+fechaFac + "','YYYY-MM-DD')");
      query.append(" AND MCC.IMP_PAGO <> 0");
      query.append(" GROUP BY ZZON_OID_ZONA  "); 

      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   


 private RecordSet obtenerImportesHistoricoCC(Long oidPais, Long oidCanal, Long oidMarca, String fechaFac) throws MareException{
      StringBuffer query = new StringBuffer();
   			query.append(" SELECT ZZON_OID_ZONA, ");
			 	query.append("	NVL(CASE WHEN ((HMC.FEC_MOVI - HMC.FEC_DOCU) <= 21) THEN");
				query.append(" SUM(HMC.IMP_PEN) ");
				query.append(" END,0) IMP_PEND_21,  ");
    		query.append(" NVL(CASE WHEN ((HMC.FEC_MOVI - HMC.FEC_DOCU) > 21 AND (HMC.FEC_MOVI - HMC.FEC_DOCU) <= 31) THEN");
				query.append(" SUM(HMC.IMP_PEN) ");
				query.append(" END,0) IMP_PEND_31,  ");
        query.append(" NVL(CASE WHEN ((HMC.FEC_MOVI - HMC.FEC_DOCU) > 31 AND (HMC.FEC_MOVI - HMC.FEC_DOCU) <= 42) THEN");
				query.append(" SUM(HMC.IMP_PEN) ");
				query.append(" END,0) IMP_PEND_42,  ");
    		query.append(" NVL(CASE WHEN ((HMC.FEC_MOVI - HMC.FEC_DOCU) > 42 AND (HMC.FEC_MOVI - HMC.FEC_DOCU) <= 63) THEN");
				query.append(" SUM(HMC.IMP_PEN) ");
				query.append(" END,0) IMP_PEND_63,  ");
    		query.append(" NVL(CASE WHEN ((HMC.FEC_MOVI - HMC.FEC_DOCU) > 63) THEN");
				query.append(" SUM(HMC.IMP_PEN) ");
				query.append(" END,0) IMP_PEND_MAYOR_63  ");
			  query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC,");
			 	query.append(" ZON_SECCI SEC,");
				query.append(" CCC_HISTO_MOVIM_CC HMC, ");
				query.append("  ZON_ZONA ZON   ");
        query.append(" WHERE SEC.OID_SECC = MCC.ZSCC_OID_SECC    ");
        query.append(" AND MCC.IMP_PAGO <> 0 ");
        query.append(" AND MCC.FEC_ULTI_MOVI = TO_DATE('"+ fechaFac +"', 'yyyy-MM-dd')");
			  query.append(" AND HMC.MVCC_OID_MOVI_CC = MCC.OID_MOVI_CC");
			  query.append(" AND HMC.IMP_PAGO <> 0");
			  query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA");
			  query.append(" AND ZON.PAIS_OID_PAIS = " + oidPais);
			  query.append(" AND ZON.CANA_OID_CANA = " + oidCanal);
			  query.append(" AND ZON.MARC_OID_MARC = " + oidMarca);
			  query.append(" AND ZON.IND_ACTI = 1");
			  query.append(" AND ZON.IND_BORR <> 1");
		    query.append(" GROUP BY ZZON_OID_ZONA, (HMC.FEC_MOVI - HMC.FEC_DOCU)");

      RecordSet rs = null;        
      rs = this.executeQuery(query.toString());
      return rs;
   }   

    private String formateaFecha(java.util.Date fecha) {
        UtilidadesLog.info("MONINTDATBean.formateaFechaHora(java.util.Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date fechaD = new java.sql.Date(fecha.getTime());
        String fechaFormateada = sdf.format(fechaD);
        UtilidadesLog.info("MONINTDATBean.formateaFechaHora(java.util.Date fecha): Salida");
        return fechaFormateada;
    }

    public DTOSalida obtenerInterfacesDAT(DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("MONINTDATBean.obtenerInterfacesDAT(): Entrada"); 
        DAOINTDAT dao = new DAOINTDAT();
        DTOSalida dtoR = new DTOSalida( dao.obtenerInterfacesParaVisualizar( "DAT", dto.getOidPais() ) );
        UtilidadesLog.info("MONINTDATBean.obtenerInterfacesDAT(): Salida"); 
        return dtoR;
    }

    /**
     * 09-07-2007    Creado por Sapaza, incidencia SiCC-20070307. Se envia las regiones cerradas con sus zonas
     *               para un determinado periodo
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoBatch
     */
    public DTOSalidaBatch enviarRegionesCerradas(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarRegionesCerradas(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT36;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarRegionesCerradas  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);    
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarRegionesCerradas ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTRegionCerrada dtoRegion= null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);

        //recuperamos la ultima fecha de procesamiento
        String ultimaFecha = dao.obtenerUltimaFechaProceHistoLotesSTR( codigo, this.dtoe.getOidPais() );
        
        //recuperamos las regiones cerradas a partir de la ultima fecha de procesamiento
        ArrayList regiones = dao.obtenerRegionesCerradas( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal(), this.dtoe.getPeriodoFacturacion(), ultimaFecha);
       
        int n = regiones.size();
        UtilidadesLog.debug("DAT-36 Número de Datos del Array :" + n);
        
        for (int i=0 ;i<n ;i++ ) {
            dtoRegion = (DTOINTRegionCerrada)regiones.get(i);
                    
            try{
                registro.vaciar();
                
                registro.anyadirCampo( IDAT.DAT36_ANIO_CAMPANIA_FACTURACION , dtoRegion.getAnioCampania());
                registro.anyadirCampo( IDAT.DAT36_CODIGO_REGION , dtoRegion.getCodigoRegion());
                registro.anyadirCampo( IDAT.DAT36_CODIGO_ZONA , dtoRegion.getCodigoZona());
                registro.anyadirCampo( IDAT.DAT36_FLAG_IMPRESION , dtoRegion.getFlagImpresion());  
                registro.anyadirCampo( IDAT.DAT36_FLAG_STATUS_FACTURACION , dtoRegion.getFlagStatusFacturacion()); 
    
                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                     UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarInformacionRegionesCerradas  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
        }catch(RemoteException re){                 
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarRegionesCerradas  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarRegionesCerradas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    /**
     * 17-07-2007    Creado por Sapaza, incidencia SiCC-20070323. Se envia el maestro de hijas duplas
     *               y su correspondiente madre dupla
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoBatch
     */
    public DTOSalidaBatch enviarMaestroHijasDuplas(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTDATBean.enviarMaestroHijasDuplas(DTOBatch dtoBatch): Entrada");
        String codigo = IDAT.COD_INTERFAZ_DAT37;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarMaestroHijasDuplas  ---->Entrada \n\n\n  dtoBatch   " +dtoBatch);    
        
        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarMaestroHijasDuplas ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DTOINTHijaDupla dtoHijaDupla= null;
        String usuario = ctx.getCallerPrincipal().getName();
        DAOINTDAT dao =new DAOINTDAT(usuario);

        //recuperamos la ultima fecha de procesamiento
        String ultimaFecha = dao.obtenerUltimaFechaProceHistoLotesSTR( codigo, this.dtoe.getOidPais() );
        
        //recuperamos informacion delas hijas duplas a partir de la ultima fecha de procesamiento
        ArrayList hijasDuplas = dao.obtenerMaestroHijasDuplas( this.dtoe.getOidPais(),  this.dtoe.getMarca(), this.dtoe.getCanal(), ultimaFecha);
       
        int n = hijasDuplas.size();
        UtilidadesLog.debug("DAT-37 Número de Datos del Array :" + n);
        
        for (int i=0 ;i<n ;i++ ) {
            dtoHijaDupla = (DTOINTHijaDupla)hijasDuplas.get(i);
                    
            try{
                registro.vaciar();
                
                registro.anyadirCampo( IDAT.DAT37_CODIGO_CLIENTE , dtoHijaDupla.getCodigoCliente());
                registro.anyadirCampo( IDAT.DAT37_CODIGO_MADRE_DUPLA , dtoHijaDupla.getCodigoMadreDupla());
                registro.anyadirCampo( IDAT.DAT37_NOMBRE_COMPLETO , dtoHijaDupla.getNombreCompleto());
                registro.anyadirCampo( IDAT.DAT37_APELLIDO_PATERNO , dtoHijaDupla.getApellidoPaterno());  
                registro.anyadirCampo( IDAT.DAT37_APELLIDO_MATERNO , dtoHijaDupla.getApellidoMaterno()); 
                registro.anyadirCampo( IDAT.DAT37_NOMBRE , dtoHijaDupla.getNombre());
                registro.anyadirCampo( IDAT.DAT37_FECHA_NACIMIENTO , dtoHijaDupla.getFechaNacimiento());
                registro.anyadirCampo( IDAT.DAT37_EMAIL , dtoHijaDupla.getEmail());
                registro.anyadirCampo( IDAT.DAT37_TELEFONO_FIJO , dtoHijaDupla.getTelefonoFijo());  
                registro.anyadirCampo( IDAT.DAT37_TELEFONO_MOVIL , dtoHijaDupla.getTelefonoMovil()); 
                registro.anyadirCampo( IDAT.DAT37_INDICADOR_CONTACTADA , dtoHijaDupla.getIndicadorContactada()); 
                registro.anyadirCampo( IDAT.DAT37_ESTATUS , dtoHijaDupla.getEstatus());
                registro.anyadirCampo( IDAT.DAT37_CAMPANIA_INGRESO , dtoHijaDupla.getCampaniaIngreso());
                registro.anyadirCampo( IDAT.DAT37_FECHA_INGRESO , dtoHijaDupla.getFechaIngreso());
                registro.anyadirCampo( IDAT.DAT37_FECHA_ULTIMA_ACTUALIZACION , dtoHijaDupla.getFechaUltimaActualizacion());  
                registro.anyadirCampo( IDAT.DAT37_CODIGO_CANAL_INGRESO , dtoHijaDupla.getCodigoCanalIngreso()); 
                //SB PER-SiCC-2010-0002 Implementar nuevo atributo en Interfaces
                registro.anyadirCampo( IDAT.DAT37_IND_CONFIRMACION_COMUNICACION , dtoHijaDupla.getIndicadorConfirmacion()); 
                try{
                    gi.anyadirRegistro(this.interfaz,this.registro);
                     UtilidadesLog.debug(" [ "+codigo+" ] AÑADIDO EL REGISTRO I " +i);
                }catch(RemoteException re){                     
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
              
                registro.vaciar();
                
            } catch( InterfacesException fex ){ 
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarMaestroHijasDuplas  ");                
                registro.vaciar();
                continue;
            }
               
        }//Fin del bucle lista
        
        try{ 
            gi.enviarInterfaz(this.interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
        }catch(RemoteException re){                 
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTDAT:enviarMaestroHijasDuplas  ---->SALIDA ");
        UtilidadesLog.info("MONINTDATBean.enviarMaestroHijasDuplas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    private PeriodoLocalHome getPeriodoLocalHome() {
            return new PeriodoLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
            return new PeriodoCorporativoLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {
            return new CanalLocalHome();
    }

}