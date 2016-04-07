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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTOCORRecepcionar;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.entidades.intsys.ConfirmacionRepartoLARLocal;
import es.indra.sicc.entidades.intsys.ConfirmacionRepartoLARLocalHome;
import es.indra.sicc.entidades.intsys.SeguimientoPedidosINTLocal;
import es.indra.sicc.entidades.intsys.SeguimientoPedidosINTLocalHome;
import es.indra.sicc.entidades.intsys.TipoDireccionRepartoLocal;
import es.indra.sicc.entidades.intsys.TipoDireccionRepartoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocal;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidos;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Date;

import es.indra.sicc.entidades.seg.EmpresaLocal;
import es.indra.sicc.entidades.seg.EmpresaLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCORBean implements SessionBean 
{
    private SessionContext ctx;
    
    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
    }

    public DTOSalidaBatch recepcionarSeguimientoPedidosBatch(DTOCORRecepcionar dtoe) throws MareException
    {
        UtilidadesLog.info("MONCORBean.recepcionarSeguimientoPedidosBatch(DTOCORRecepcionar dtoe): Entrada");
        /*String mensaje;

        // Se invoca al caso de uso "Recepcionar Seguimiento Pedidos Larissa", en modo batch 
        DTOBatch dtoBatch = new DTOBatch( nombre = "Recepcionar Seguimiento Pedidos Larissa", 
        IDOnline = "CORSeguimientoPedios", 
        DTOOnline = dtoe ) 

        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 

        mensaje += "Recepcionar Seguimiento de Pedido procesado - " 
        } 
        Retornar new DTOSalidaBatch( 0, mensaje )*/
        
        String mensaje = null;
        IMareDTO  DTOOnline = dtoe; //Falla esto y tengo ke poner una incidencia
        
        MareBusinessID IDOnline =  new MareBusinessID("CORSeguimientoPedidos");
        DTOBatch dtoBatch = new DTOBatch("Seguimiento Pedidos Larissa", IDOnline , DTOOnline );
        
        try{
				UtilidadesLog.debug(" **** Antes de BatchUtil ***");
				BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }
        
        mensaje += "Recepcionar Seguimiento de Pedido procesado - ";
        
        UtilidadesLog.info("MONCORBean.recepcionarSeguimientoPedidosBatch(DTOCORRecepcionar dtoe): Salida");
        return new DTOSalidaBatch(0, mensaje); //return null;       
    }

    public DTOSalidaBatch recepcionarSeguimientoPedidos(DTOBatch dtoe) throws MareException
    {
        UtilidadesLog.info("MONCORBean.recepcionarSeguimientoPedidos(DTOBatch dtoe): Entrada");
        
        InterfazInfo info = null;
        InterfazInfo interfaz=null;
        IRegistroSicc registro=null;
        String codigo=null;
        
        try{
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
               
       /*
        * MONGestorInterfaces gi= MONGestorInterfacesHome.create() 
            xtraer el DTOCORRecepcionar del DTOBatch recibido 
            DTOCORRecepcionar DTOE 
            //Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
            //handle de la interfaz que se va a procesar 
            InterfazInfo info = new InterfazInfo( codigo = IGestorInterfaces.COD_INTERFAZ_COR1, 
            DTOE.numeroLote, 
            DTOE.pais ) 
          //Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
            info.setDescripcionLote( DTOE.descripcionLote ) 
            info.setObservaciones( DTOE.observaciones ) 
            
            IRegistroSicc registro = gi.cargarRegistro(info); //nos creamos un objeto IRegistroSicc, con la informacion recibida de la interfaz 
        * 
        * */
         
                    //DTOCORRecepcionar dto= new DTOCORRecepcionar();
                    //dto.getOidPais();
        //IMareDTO dtoNumero=(DTOCORRecepcionar)dtoe.getDTOOnline();
        //Long numeroLote=new Long(dtoNumero.getLong("numLote"));
        //long longpais=dtoNumero.getLong("oidPais");
        //Long pais=new Long("1");//new Long(dtoNumero.getLong("oidPais"));
        //UtilidadesLog.debug("PAIS = "+pais);
        DTOCORRecepcionar dtoNumero = (DTOCORRecepcionar)dtoe.getDTOOnline();
        Long numeroLote=dtoNumero.getNumLote();
        Long pais=dtoNumero.getOidPais();
        UtilidadesLog.debug("numero de LOTE = "+numeroLote);
        UtilidadesLog.debug("Pais = "+pais);
        

        
        info = new InterfazInfo( IGestorInterfaces.COD_INTERFAZ_COR1, numeroLote.toString(),  pais ); 
        Long getOidSociedad=null;
       
        //try{
          interfaz=gi.importarInterfaz(info);
          interfaz.setDescripcionLote(dtoNumero.getDescripcionLote());
          interfaz.setObservaciones(dtoNumero.getObservaciones());

          UtilidadesLog.debug("Recogido el fichero ");        
               
          while ((registro=gi.cargarRegistro(interfaz))!=null)
          {
                
            //SOCIEDAD----------------------------------------
             EmpresaLocal sociedadlocal = null;
             EmpresaLocalHome sociedadHome =  this.getEmpresaLocalHome();
            
              try{
                //atencion aqui devuelve uan coleccion.....
                 String codigoSociedad=(String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_SOCIEDAD);
                 UtilidadesLog.debug("codigoSociedad"+ codigoSociedad);
                 sociedadlocal = sociedadHome.findByPaisYCodigo(pais,(String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_SOCIEDAD));
                 getOidSociedad = sociedadlocal.getOid();
                 UtilidadesLog.debug("getOidSociedad==" +getOidSociedad);
              
              }catch(NoResultException f){
               codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_SOCIEDAD);
                    if (codigo==null || codigo.trim().equals("")){
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0022 + codigo);
                        gi.registrarError(dtoError);
                       
                    }else if(codigo!=null ){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0022 + codigo);
                        gi.registrarError(dtoError);
                    
                    }
                     continue;
                 
              }  catch (PersistenceException ce) {   
                  UtilidadesLog.error("ERROR ", ce);
                  throw new MareException(ce, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }
            ClaseSolicitudLocal claseDeSolicitudLocal=null;
            ClaseSolicitudLocalHome claseDeSolicitudHome=this.getClaseSolicitudLocalHome();
            
       //comprobamos si existe la clase de solicitud: 
            try { 
                String claseSolicitud=(String)registro.obtenerCampo(IRegistroSicc.COR1_CLASE_SOLICITUD);
                UtilidadesLog.debug("claseSolicitud= "+ claseSolicitud);
                claseDeSolicitudLocal= claseDeSolicitudHome.findByUK((String)registro.obtenerCampo(IRegistroSicc.COR1_CLASE_SOLICITUD));
            }catch( NoResultException fex ) { 
                    codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_CLASE_SOLICITUD);
                     if (codigo==null || codigo.trim().equals("")){
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0023 + codigo);
                        gi.registrarError(dtoError);
                       
                    }else if(codigo!=null ){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0022 + codigo);
                            gi.registrarError(dtoError);
                    
                    }
                     continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            //Añadido por incidencia 17677
            TiposSolicitudLocal tiposSolicitudLocal=null;
            TiposSolicitudLocalHome tiposSolicitudHome = this.getTiposSolicitudLocalHome();
            try{
                String tipoSolicitud=(String)registro.obtenerCampo(IRegistroSicc.COR1_TIPO_SOLICITUD);
                UtilidadesLog.debug("tipoSolicitud= "+ tipoSolicitud);
                tiposSolicitudLocal = tiposSolicitudHome.findByUK(tipoSolicitud);
            }catch( NoResultException fex ) { 
                codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_TIPO_SOLICITUD);
                if (codigo==null || codigo.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0024 + codigo);
                    gi.registrarError(dtoError);
                   
                 }else if(codigo!=null ){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0024 + codigo);
                    gi.registrarError(dtoError);
                    
                    }
                 continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            TiposSolicitudPaisLocal tipoSoliLocal=null;
            TiposSolicitudPaisLocalHome tipoSoliHome= this.getTiposSolicitudPaisLocalHome();
            Long tipoSoli=null;
            //comprobamos el tipo de solicitud 
            try { 
                //Modificado por incidencia 17677
                //String tipoSolicitud=(String)registro.obtenerCampo(IRegistroSicc.COR1_TIPO_SOLICITUD);
                UtilidadesLog.debug("OIDTipoSolicitud= "+ tiposSolicitudLocal.getOid());
                tipoSoli = tiposSolicitudLocal.getOid();
                tipoSoliLocal= tipoSoliHome.findByUK(pais,tipoSoli); //añadimos pais BELC300013342     1455
            
            }catch( NoResultException fex ) { 
                codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_TIPO_SOLICITUD);
                if (codigo==null || codigo.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0024 + codigo);
                    gi.registrarError(dtoError);
                   
                 }else if(codigo!=null ){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0024 + codigo);
                    gi.registrarError(dtoError);
                    
                    }
                 continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            //falta el getEn Todas
            ClienteDatosBasicosLocalHome clientehome=this.getClienteDatosBasicosLocalHome();
            ClienteDatosBasicosLocal clienteLocal =null;
            
             //comprobamos el código de cliente 
                try { 
                
                 String cliente=(String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_CLIENTE);
                 UtilidadesLog.debug("cliente= "+ cliente);
                 clienteLocal= clientehome.findByCodigoYPais(pais, (String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_CLIENTE)) ;
                
                }catch( NoResultException fex ) { 
                    codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_CLIENTE);
                    if (codigo==null || codigo.trim().equals("")){
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0019 + codigo);
                        gi.registrarError(dtoError);
                       
                     }else if(codigo!=null ){
                           DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0019 + codigo);
                        gi.registrarError(dtoError);
                    
                    }
                     continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } 

                    UtilidadesLog.debug("tipoSoliLocal.getOid()= " +tipoSoliLocal.getOid());
                    UtilidadesLog.debug("clienteLocal.getOid()= " +clienteLocal.getOid());
                    UtilidadesLog.debug("getOidSociedad= " +getOidSociedad);
                    UtilidadesLog.debug("(Long)registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_PEDIDO)= " +(Long)registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_PEDIDO));
                   
                     //vamos a buscar el pedido asociado 
                    DAOCOR dao= new DAOCOR(); //nos creamos un objeto DAOCOR 
                    
                    DTOOID dtoPedido= dao.buscarPeriodoAsociado(tipoSoliLocal.getOid(), clienteLocal.getOid(), getOidSociedad, (Long)registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_PEDIDO)); 
                    if (dtoPedido==null) { 
                        codigo = (Long)registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_PEDIDO)!=null?
                                registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_PEDIDO).toString():null;

                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0025 + codigo);
                        gi.registrarError(dtoError);

                        continue;
                    } 
                    
                    String dniRepartido=(String)registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR);
                    UtilidadesLog.debug("dniRepartido = "+dniRepartido);
                    //buscamos los datos del Repartidor en SICC 
                    DTOOID dtoRepartidor= dao.buscarDatosRepartidor(pais, (String)registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR));
                    if (dtoRepartidor==null) { 
                     codigo = (String)registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR);
                        if (codigo==null || codigo.trim().equals("")){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0025 + codigo);
                            gi.registrarError(dtoError);
                           
                         }else if(codigo!=null ){
                           DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0025 + codigo);
                            gi.registrarError(dtoError);
                    
                        }
                         continue;
                    }
                    
                    //llegamos al kit de la cuestion
                    SeguimientoPedidosINTLocal seguiLocal=null;
                    SeguimientoPedidosINTLocalHome seguiHome=this.getSeguimientoPedidosINTLocalHome();
                    //Vamos a insertar el registro, para ello, 
                    //antes debemos comprobar si no existe ya puesto que si existe se trata de una actualización 
                    DTOOID dtoRegistro = dao.comprobarExistenciaRegistro(dtoPedido.getOid()); 
                    Date fecha=null;
                    if (dtoRegistro!=null) {//Si en la consulta anterior, obtuvimos un registro, tenemos que actualizarlo 
                    //Actualizamos la siguiente información de la entidad SeguimientoPedidosINT para el registro donde SeguimientoPedidosINT.oid = dtoRegistro.oid 
                    try{
                           UtilidadesLog.debug("dtoRegistro.getOid ="+ dtoRegistro.getOid());
                          seguiLocal=seguiHome.findByPrimaryKey(dtoRegistro.getOid());
                          
                          seguiLocal.setSociedad(getOidSociedad);
                          UtilidadesLog.debug("getOidSociedad ="+ getOidSociedad);
                          seguiLocal.setNumeroSolicitud(dtoPedido.getOid());
                          seguiLocal.setTipoSolicitud(tipoSoliLocal.getOid());
                          UtilidadesLog.debug("tipoSoliLocal.getOid() ="+ tipoSoliLocal.getOid());
                          seguiLocal.setPais(pais);
                          seguiLocal.setCliente(clienteLocal.getOid());
                          UtilidadesLog.debug("clienteLocal.getOid() ="+ clienteLocal.getOid());
                          seguiLocal.setClienteRepartidor(dtoRepartidor.getOid());
                          UtilidadesLog.debug("dtoRepartidor.getOid() ="+ dtoRepartidor.getOid());
                          
                          seguiLocal.setCodRepartidorLarissa((String)registro.obtenerCampo(IRegistroSicc.COR1_COD_REPARTIDOR_LARISSA));
                          seguiLocal.setDocuIdenRepartidor((String)registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR));
                          seguiLocal.setChip((String)registro.obtenerCampo(IRegistroSicc.COR1_CHIP));
                          
                          fecha=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_INICIO_LINEA_SACADO));
                          seguiLocal.setFechaInicioLineaSacado(fecha);
                          seguiLocal.setHoraInicioLineaSacado((String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_INICIO_LINEA_SACADO));
                          fecha=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FIN_LINEA_SACADO));
                          seguiLocal.setFechaFinLineaSacado(fecha);
                          seguiLocal.setHoraFinLineaSacado((String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_FIN_LINEA_SACADO));
                          seguiLocal.setCantidadBultos((Integer)registro.obtenerCampo(IRegistroSicc.COR1_CANTIDAD_BULTOS));
                          fecha=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_DESPACHO));
                          seguiLocal.setFechaDespacho(fecha);
                           seguiLocal.setHoraDespacho(((String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_DESPACHO)));
                          //numero de despacho
                          seguiHome.merge(seguiLocal);
                     
                    }catch(NoResultException ce){
                        UtilidadesLog.debug(ce);                      
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                        
                            
                     }else{ //si no hemos encontrado nada quiere decri que lo creamos y listo.
                     
                         try{
                         /*}else { 
                                Hacemos un create en entidad SeguimientoPedidosINT con la siguiente información. 
                                SeguimientoPedidosINT.oidSociedad= Sociedad.oid 
                                SeguimientoPedidosINT.oidTipoSolicitud = TipoSolicitud.oid 
                                SeguimientoPedidosINT.oidSolicitud=dtoPedido.oid 
                                SeguimientoPedidosINT.oidPais= DTOE.pais 
                                SeguimientoPedidosINT.oidCliente=Cliente.oid 
                                SeguimientoPedidosINT.oidClienteRepartidor= dtoRepartidor.oid 
                                SeguimientoPedidosINT.codRepartidorLarissa=registro.obtenerCampo(IRegistroSicc.COR1_COD_REPARTIDOR_LARISSA) 
                                SeguimientoPedidosINT.docuIdenRepartidor= registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR) 
                                SeguimientoPedidosINT.chip= registro.obtenerCampo(IRegistroSicc.COR1_CHIP) 
                                SeguimientoPedidosINT.fechaInicioLineaSacado= registro.obtenerCampo(IRegistroSicc.COR1_FECHA_INICIO_LINEA_SACADO) 
                                SeguimientoPedidosINT.horaInicioLineaSacado=registro.obtenerCampo(IRegistroSicc.COR1_HORA_INICIO_LINEA_SACADO) 
                                SeguimientoPedidosINT.fechaFinLineaSacado=registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FIN_LINEA_SACADO) 
                                SeguimientoPedidosINT.horaFinLineaSacado=registro.obtenerCampo(IRegistroSicc.COR1_HORA_FIN_LINEA_SACADO) 
                                SeguimientoPedidosINT.cantidadBultos=registro.obtenerCampo(IRegistroSicc.COR1_CANTIDAD_BULTOS) 
                                SeguimientoPedidosINT.fechaDespacho=registro.obtenerCampo(IRegistroSicc.COR1_FECHA_DESPACHO) 
                                SeguimientoPedidosINT.horaDespacho=registro.obtenerCampo(IRegistroSicc.COR1_HORA_DESPACHO) 
*/
                                String numeroDespacho=(String)registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_DESPACHO); //CAMBIADO por BELC300013388    
                                String chip=(String)registro.obtenerCampo(IRegistroSicc.COR1_CHIP);  
                                String documentorepartidor=(String)registro.obtenerCampo(IRegistroSicc.COR1_DOCU_IDENT_REPARTIDOR); 
                                
                                Date fechaInicio=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_INICIO_LINEA_SACADO));
                                String horaInicio=(String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_INICIO_LINEA_SACADO); 
                                
                                //java.util.Date = (java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FIN_LINEA_SACADO);
                                
                                Date fechaFin=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FIN_LINEA_SACADO));
                                String horaFin=(String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_FIN_LINEA_SACADO); 
                                Integer cantidaBultos=(Integer)registro.obtenerCampo(IRegistroSicc.COR1_CANTIDAD_BULTOS);
                                Date fechaDespacho=this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR1_FECHA_DESPACHO));
                                String horaDespacho=(String)registro.obtenerCampo(IRegistroSicc.COR1_HORA_DESPACHO); 
                                //pais, tiposolicitud, sociedad, clienterepartidor, cliente, numeroSolicitud= claseSolicitud telefono , String CodrepartidorLarisa
                                String codRepartidorLarisa=(String)registro.obtenerCampo(IRegistroSicc.COR1_COD_REPARTIDOR_LARISSA); 
                                UtilidadesLog.debug("dtoPedido.getOid()= "+dtoPedido.getOid());
                                
                        seguiLocal=seguiHome.create(numeroDespacho, chip, documentorepartidor, 
                                                    fechaInicio, horaInicio,
                                                    fechaFin,horaFin,
                                                    cantidaBultos,
                                                    fechaDespacho, horaDespacho, 
                                                    pais,
                                                    tipoSoliLocal.getOid(),
                                                    getOidSociedad,
                                                    dtoRepartidor.getOid(),
                                                    clienteLocal.getOid(),
                                                    dtoPedido.getOid(),
                                                    codRepartidorLarisa);
                            
                         
                         }catch(PersistenceException ce){
                         ctx.setRollbackOnly();
                          UtilidadesLog.error(ce);                   
                      }
                     
                     }
                     
                     
                    
                    /*
                     * //vamos a actualizar el seguimiento de pedidos, para ello invocamos al caso de uso: "Actualizar Seguimiento de Pedidos (PED)" 
                        //Nos creamos un objeto del tipo 
                        DTOSeguimientoPedidos 
                        DTOSeguimientoPedidos dtoSeg con los siguientes atributos: //los demás atributos no indicados se dejarán a null 
                        dtoSeg.solicitud=dtoPedido.oid 
                        dtoSeg.hitoSeguimiento=ConstantesPED.HITO_21 
                        dtoSeg.indCompleto=true 
                        Llamamamos al método ISeguimientoPedidos.actualizarSeguimientoPedidos(dtoSeg) 
                        (El MON que implementa la interfaz es MONSeguimientoPedidos) 
                    
                        }//pasamos al siguiente registro

                     * */
                     
                     // sapaza -- PER-SiCC-2011-0477 -- 08/07/2011, se comenta la insercion en PED_SEGUI_PEDID
                     /*UtilidadesLog.debug("Se ha hecho el registro en intSeguiPedidos");
                      DTOSeguimientoPedidos  dtoSeg=new DTOSeguimientoPedidos();
                       dtoSeg.setSolicitud(dtoPedido.getOid());
                        UtilidadesLog.debug("\n\n dtoSeg.setSolicitud = "+dtoSeg.getSolicitud());
                
                        dtoSeg.setHitoSeguimiento(ConstantesPED.HITO_21);
                        UtilidadesLog.debug("\n\n dtoSeguimientoPedidos.getHitoSeguimiento = "+dtoSeg.getHitoSeguimiento());

                        dtoSeg.setIndCompleto(Boolean.TRUE);
                         UtilidadesLog.debug("\n\n dtoSeguimientoPedidos.setIndCompleto = TRUE = ");
                        try{
                            MONSeguimientoPedidos monSeguimiento = this.getMONSeguimientoPedidosHome();
                            //UtilidadesLog.debug("\n\nParametros monSeguimiento.actualizarSeguimientoPedidos dtoSeguimientoPedidos  :" + dtoSeg );
                            monSeguimiento.actualizarSeguimientoPedidos(dtoSeg);
                        }catch(RemoteException re){                           
                            UtilidadesLog.error(re);
                              throw new MareException(re,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
                       }*/
            
    
             
            
           
          } //while ((registro=gi.cargarRegistro
        }catch(InterfacesException ie){            
            UtilidadesLog.debug(ie);
            throw new MareException("MONCOR.recepcionarSeguimientoPedidos InterfacesException ", ie);
        
        }catch(RemoteException re){            
            UtilidadesLog.error(re);
            throw new MareException(re,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
        }
         //AÑADIDO POR INCIDECIA 13391
        /*String mensaje
        mensaje += "Recepcionar Seguimiento de Pedidos procesado - "
        Retornar new DTOSalidaBatch( 0, mensaje )*/
        String mensaje = "";
        mensaje += "Recepcionar seguimineto de pedidos procesado - ";
        
        UtilidadesLog.info("MONCORBean.recepcionarSeguimientoPedidos(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch( 0, mensaje );  
    }
    
     private MONSeguimientoPedidos getMONSeguimientoPedidosHome() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONCORBean.getMONSeguimientoPedidosHome(): Entrada");
        MONSeguimientoPedidosHome home = (MONSeguimientoPedidosHome)UtilidadesEJB.getHome("MONSeguimientoPedidos", MONSeguimientoPedidosHome.class);
            
        // Se obtiene el interfaz remoto
        MONSeguimientoPedidos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 		        
        UtilidadesLog.info("MONCORBean.getMONSeguimientoPedidosHome(): Salida");
        return ejb;
	}   

    public DTOSalidaBatch recibirConfirmacionRepartoBatch(DTOCORRecepcionar dtoe) throws MareException
    {
        UtilidadesLog.info("MONCORBean.recibirConfirmacionRepartoBatch(DTOCORRecepcionar dtoe): Entrada");
        
        /*String mensaje 
 
        Se invoca al caso de uso "Recibir Fichero de Confirmacion de Reparto", en modo batch 
        DTOBatch dtoBatch = new DTOBatch( nombre = "Recepcionar Fichero Confirmacion Reparto", 
        IDOnline = "CORConfirmacionReparto", 
        DTOOnline = dtoe ) 
 
        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 
 
        mensaje += "Recibir Fichero Confirmacion Reparto procesado - " 
        } 
        Retornar new DTOSalidaBatch( 0, mensaje )
        */
        String mensaje = null;
        IMareDTO  DTOOnline = dtoe;
        
        MareBusinessID IDOnline =  new MareBusinessID("CORConfirmacionReparto");
        DTOBatch dtoBatch = new DTOBatch("Fichero Confirmacion Reparto", IDOnline , DTOOnline );
        
        try{
    UtilidadesLog.debug(" **** Antes de BatchUtil ***");
    BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }
        
        mensaje += "Recibir Fichero Confirmacion Reparto procesado - ";
        
        UtilidadesLog.info("MONCORBean.recibirConfirmacionRepartoBatch(DTOCORRecepcionar dtoe): Entrada");
        return new DTOSalidaBatch(0, mensaje);
    }

    public DTOSalidaBatch recibirConfirmacionReparto(DTOBatch dtoe) throws MareException
    {
        UtilidadesLog.info("MONCORBean.recibirConfirmacionReparto(DTOBatch dtoe): Entrada");
          MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo interfaz=null;
        IRegistroSicc registro=null;
        String codigo=null;
       /*
        * MONGestorInterfaces gi= MONGestorInterfacesHome.create() 
           Extraer el DTOCORRecepcionar del DTOBatch recibido 
            DTOCORRecepcionar DTOE 
            // Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
            // handle de la interfaz que se va a procesar 
            InterfazInfo info = new InterfazInfo( codigo = IGestorInterfaces.COD_INTERFAZ_COR1, 
            DTOE.numeroLote, 
            DTOE.pais ) 
            //Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
            info.setDescripcionLote( DTOE.descripcionLote ) 
            info.setObservaciones( DTOE.observaciones ) 
            IRegistroSicc registro = gi.cargarRegistro(info); //nos creamos un objeto IRegistroSicc, con la informacion recibida de la interfaz 
           DAOCOR dao=new DAOCOR() 
            * */
        
       
        DTOCORRecepcionar dtoNumero = (DTOCORRecepcionar)dtoe.getDTOOnline();
        Long numeroLote=dtoNumero.getNumLote();
        Long pais=dtoNumero.getOidPais();
        UtilidadesLog.debug("dtoNumero = "+dtoNumero);
        
        InterfazInfo info = new InterfazInfo( IGestorInterfaces.COD_INTERFAZ_COR2, numeroLote.toString(),  pais );  
        //IMareDTO dtoNumero=(DTOCORRecepcionar)dtoe.getDTOOnline();
        //Long numeroLote=new Long(dtoNumero.getLong("numLote"));
        //Long pais=new Long(dtoNumero.getLong("OidPais"));
        //InterfazInfo info = new InterfazInfo( IGestorInterfaces.COD_INTERFAZ_COR2, numeroLote.toString(),  pais ); 
        //info.setDescripcionLote(dtoNumero.getString("descripcionLote"));
        //info.setObservaciones(dtoNumero.getString("observaciones"));

        DAOCOR dao=new DAOCOR();
        try{
          interfaz=gi.importarInterfaz(info);
          interfaz.setDescripcionLote(dtoNumero.getDescripcionLote());
          interfaz.setObservaciones(dtoNumero.getObservaciones());            
        
          //vamos a ver si existe el codigo marca T en la entidad SEGMarca, si recibimos una excepción (no existe ese código), el codigo de marca será EB 
            String codMarca; 
            MarcaLocal marcaLocal=null;
            MarcaLocalHome marcaHome=this.getMarcaLocalHome();
            try { 
                marcaLocal=marcaHome.findByUK(ConstantesSEG.COD_MARCA_T);  
                codMarca=ConstantesSEG.COD_MARCA_T;
            }catch( NoResultException fex ) { 
                codMarca=ConstantesSEG.COD_MARCA_EB;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 
            
           
               
          while ((registro=gi.cargarRegistro(interfaz))!=null){
          
          
                     //vamos a obtener el oidZona, para el código recibido
                    
            UtilidadesLog.debug("Chip:" + (String) registro.obtenerCampo(IRegistroSicc.COR2_CHIP));
            UtilidadesLog.debug("Valor en IRegistroSicc para buscar zona:" + IRegistroSicc.COR2_CODIGO_ZONA);
            UtilidadesLog.debug("Codigo Zona:" + (String)registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA));
            UtilidadesLog.debug("Valor en IRegistroSicc para buscar numero secuencia:" + IRegistroSicc.COR2_NUMERO_SECUENCIA);
            UtilidadesLog.debug("Numero de Secuencia:" + (Integer)registro.obtenerCampo(IRegistroSicc.COR2_NUMERO_SECUENCIA));
            UtilidadesLog.debug("Parametros de dao.obtenerZona : Zona"+(String)registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA)+",Codigo Marca="
            +codMarca+", Pais:"+pais);
            
            DTOOID dtoZona= dao.obtenerZona((String)registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA), codMarca, pais ); 
            if (dtoZona==null) { 
                       codigo =(String)registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA);
                        if (codigo==null || codigo.trim().equals("")){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0027 + codigo);
                            gi.registrarError(dtoError);
                        }else if(codigo!=null){
                             DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0027 + codigo);
                            gi.registrarError(dtoError);
                        }
            
                       continue; //Cambiamos el continue de sitio
            }
           
            /*
             * //vamos a buscar el número de solicitud 
                DTOOid dtoSolic = dao.buscarNumeroSolicitud(registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FACTURACION), dtoZona.oid, registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_SECUENCIA) ) 
                if (dtoSolic==null) { 
                DTOINTError dtoError = new DTOINTError( info, registro, mensaje error INT-0028+ registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FACTURACION) + registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_ZONA) + registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_SECUENCIA)) 
                gi.registrarError( dtoError ) 
                continue; 
                } 

             * */
             DTOOID dtoSolic = null;
             DAOCOR daoBuscar=new DAOCOR();
             java.util.Date fechaFacturacion = (java.util.Date) registro.obtenerCampo(IRegistroSicc.COR2_FECHA_FACTURACION);
             UtilidadesLog.debug("Fecha Facturacion:"+ fechaFacturacion);
            // Date fechaFacturacion = this.pasarAFecha(fecha);
             dtoSolic = daoBuscar.buscarNumeroSolicitud(fechaFacturacion, (Integer)registro.obtenerCampo(IRegistroSicc.COR2_NUMERO_SECUENCIA), dtoZona.getOid());
            
             if(dtoSolic==null) {
                
                String codigo1 = registro.obtenerCampo(IRegistroSicc.COR2_FECHA_FACTURACION).toString();
                String codigo2 = registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA).toString();
                String codigo3 = registro.obtenerCampo(IRegistroSicc.COR2_NUMERO_SECUENCIA).toString();
                String respuesta = this.comprobarCodigo(codigo1,codigo2,codigo3);
                if(respuesta==null || respuesta.trim().equals("")){
                    DTOINTError dtoError = new DTOINTError( info, registro, 
                    ErroresDeNegocio.INT_0028 + respuesta);
                    gi.registrarError( dtoError ); 
                }
                continue; //Cambiamos el continue de sitio
             }

             /*//vamos a traducir el codigo TipoDireccionReparto que viene en la interfaz por el oid para poder hacer el create en la entidad. 
                try { 
                TipoReparto= llamar al método findByUk(registro.obtenerCampo(IRegistroSicc.COR1_TIPO_DIRECCION_REPARTO)) de la entidad TipoDireccionReparto (INT) 
                }catch( FinderException fex ) { 
                    DTOINTError dtoError = new DTOINTError( info, registro, mensaje error INT-0029 + registro.obtenerCampo(IRegistroSicc.COR1_TIPO_DIRECCION_REPARTO)) 
                    gi.registrarError( dtoError ) 
                    continue; 
                }
                * */
                //Lo comento por el entity ke no me lo pillaba
                
                TipoDireccionRepartoLocal tipoDireccionRepartoLocal = null;
                TipoDireccionRepartoLocalHome tipoDireccionRepartoHome = this.getTipoDireccionRepartoLocalHome();
                Long getOidTipodireccionreparto=null;
                UtilidadesLog.debug("Paramtros del findByUK TipoDireccionReparto:"+(String)registro.obtenerCampo(IRegistroSicc.COR2_TIPO_DIRECCION_REPARTO));
                try{
                    tipoDireccionRepartoLocal = tipoDireccionRepartoHome.findByUk((String)registro.obtenerCampo(IRegistroSicc.COR2_TIPO_DIRECCION_REPARTO));
                    getOidTipodireccionreparto=(tipoDireccionRepartoLocal.getOid());
                }catch( NoResultException fex ) { 
                    codigo = registro.obtenerCampo(IRegistroSicc.COR2_TIPO_DIRECCION_REPARTO).toString();
                        if (codigo==null || codigo.trim().equals("")){
                            DTOINTError dtoError =new DTOINTError(info,registro,ErroresDeNegocio.INT_0029 + codigo);
                            gi.registrarError(dtoError);
                        }else if(codigo!=null){
                             DTOINTError dtoError =new DTOINTError(info,registro,ErroresDeNegocio.INT_0029 + codigo);
                            gi.registrarError(dtoError);
                        
                        }
                    continue; //Cambiamos el continue de sitio
                 }  catch (PersistenceException ce) {
                      UtilidadesLog.error("ERROR ", ce);
                      throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                /*Actualizamos el registro de la entidad SeguimientoPedidosINT, para ello primero debemos comprobar que evidentemente existe el registro en la entidad 
                DTOOid dtoRegistro = dao.comprobarExisteciaRegistro(dtoSolic.oid) 
                if (dtoRegistro==null) { 
                    DTOINTError dtoError = new DTOINTError( info, registro, mensaje error INT-0030 + registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FACTURACION) + registro.obtenerCampo(IRegistroSicc.COR1_CODIGO_ZONA) + registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_SECUENCIA)) 
                    gi.registrarError( dtoError ) 
                    continue; 
                }
                * */
                DTOOID dtoRegistro = null;
                UtilidadesLog.debug("Parametros de dao.comprobarExistenciaRegistro Oid Solicitud :" +dtoSolic.getOid());
                dtoRegistro = dao.comprobarExistenciaRegistro(dtoSolic.getOid());
                if (dtoRegistro==null) { //y si alguno viene a null que??
                    String codigo1 = registro.obtenerCampo(IRegistroSicc.COR2_FECHA_FACTURACION).toString();
                    String codigo2 = registro.obtenerCampo(IRegistroSicc.COR2_CODIGO_ZONA).toString();
                    String codigo3 = registro.obtenerCampo(IRegistroSicc.COR2_NUMERO_SECUENCIA).toString();
                    String respuesta = this.comprobarCodigo(codigo1,codigo2,codigo3);
                    if(respuesta==null || respuesta.trim().equals("")){
                        DTOINTError dtoError = new DTOINTError( info, registro, 
                        ErroresDeNegocio.INT_0030 + respuesta ); 
                        gi.registrarError( dtoError ); 
                    }
                    continue; //Cambiamos el continue de sitio
                }

                
                /*Actualizamos la siguiente información de la entidad SeguimientoPedidosINT para el registro donde SeguimientoPedidosINT.oid = dtoRegistro.oid 
                SeguimientoPedidosINT.fechaReparto=registro.obtenerCampo(IRegistroSicc.COR1_FECHA_REPARTO) 
                SeguimientoPedidosINT.horaReparto=registro.obtenerCampo(IRegistroSicc.COR1_HORA_REPARTO)*/ 
                //Vamos por aqui Carlos
                SeguimientoPedidosINTLocalHome seguimientoPedidosINTLocalHome = null;
                SeguimientoPedidosINTLocal seguimientoPedidosINTLocal = null;
                
                seguimientoPedidosINTLocalHome = this.getSeguimientoPedidosINTLocalHome();
                UtilidadesLog.debug("Fecha Reparto:" + (java.util.Date)registro.obtenerCampo(IRegistroSicc.COR2_FECHA_REPARTO));
                try{
                    UtilidadesLog.debug("Parametros seguimientoPedidosINTLocalHome.findByPrimaryKey :" + dtoRegistro.getOid());
                    seguimientoPedidosINTLocal = seguimientoPedidosINTLocalHome.findByPrimaryKey(dtoRegistro.getOid());
                    
                    Date fechaReparto = this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR2_FECHA_REPARTO));
                    seguimientoPedidosINTLocal.setFechaReparto(fechaReparto);
                    seguimientoPedidosINTLocal.setHoraReparto((String)registro.obtenerCampo(IRegistroSicc.COR2_HORA_REPARTO));
                    seguimientoPedidosINTLocalHome.merge(seguimientoPedidosINTLocal);
                }catch(NoResultException fe){
                    UtilidadesLog.debug(fe);
                }
                /*Insertamos el registro en la entidad ConfirmacionRepartoLAR 
                Llamamos al create() de la entidad ConfirmacionRepartoLAR con la siguiente información 
                ConfirmacionRepartoLAR.secuencia=registro.obtenerCampo(IRegistroSicc.COR1_NUMERO_SECUENCIA) 
                ConfirmacionRepartoLAR.fechaFacturacion=registro.obtenerCampo(IRegistroSicc.COR1_FECHA_FACTURACION) 
                ConfirmacionRepartoLAR.oidZona=dtoZona.oid 
                ConfirmacionRepartoLAR.chip=registro.obtenerCampo(IRegistroSicc.COR1_CHIP) 
                ConfirmacionRepartoLAR.fechaReparto=registro.obtenerCampo(IRegistroSicc.COR1_FECHA_REPARTO) 
                ConfirmacionRepartoLAR.horaReparto=registro.obtenerCampo(IRegistroSicc.COR1_HORA_REPARTO) 
                ConfirmacionRepartoLAR.oidTipoDireccionReparto= TipoDireccionReparto.oid 
                * */
                ConfirmacionRepartoLARLocalHome confirmacionRepartoLARLocalHome = null;
                ConfirmacionRepartoLARLocal confirmacionRepartoLARLocal = null;
                
                confirmacionRepartoLARLocalHome = this.getConfirmacionRepartoLARLocalHome();
                Integer secuencia = (Integer)registro.obtenerCampo(IRegistroSicc.COR2_NUMERO_SECUENCIA);
                Date fechaFactura = this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR2_FECHA_FACTURACION));
                Date fechaReparto = this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.COR2_FECHA_REPARTO));
                Long zona = dtoZona.getOid();
               
                try{
                    UtilidadesLog.debug("Paramtros confirmacionRepartoLARLocalHome.create :" + secuencia + ", "+ fechaFactura +", "+
                    registro.obtenerCampo(IRegistroSicc.COR2_CHIP).toString()+", "+fechaReparto.toString()+", "+registro.obtenerCampo(IRegistroSicc.COR2_HORA_REPARTO).toString()
                    +", "+zona+", "+ getOidTipodireccionreparto);
                    confirmacionRepartoLARLocal = confirmacionRepartoLARLocalHome.create(secuencia, fechaFactura, 
                                                                                        registro.obtenerCampo(IRegistroSicc.COR2_CHIP).toString(),
                                                                                        fechaReparto,
                                                                                        registro.obtenerCampo(IRegistroSicc.COR2_HORA_REPARTO).toString(),
                                                                                        zona,
                                                                                        getOidTipodireccionreparto);
                
                }catch(PersistenceException ce){
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();                    
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                /*vamos a actualizar el seguimiento de pedidos, para ello invocamos al caso de uso: "Actualizar Seguimiento de Pedidos (PED)" 
                Nos creamos un objeto del tipo DTOSeguimientoPedidos 
                DTOSeguimientoPedidos dtoSeg con los siguientes atributos: //los demás atributos no indicados se dejarán a null 
                dtoSeg.solicitud=dtoSolic.oid 
                dtoSeg.hitoSeguimiento=ConstantesPED.HITO_31 
                dtoSeg.indCompleto=true 
                * */
                
                // sapaza -- PER-SiCC-2011-0477 -- 08/07/2011, se comenta la insercion en PED_SEGUI_PEDID
                /*DTOSeguimientoPedidos dtoSeguimientoPedidos = new DTOSeguimientoPedidos();
                dtoSeguimientoPedidos.setSolicitud(dtoSolic.getOid());
                UtilidadesLog.debug("\n\n dtoSeguimientoPedidos.getSolicitud = "+dtoSeguimientoPedidos.getSolicitud());
                dtoSeguimientoPedidos.setHitoSeguimiento(ConstantesPED.HITO_31);
                UtilidadesLog.debug("\n\n dtoSeguimientoPedidos.getHitoSeguimiento = "+dtoSeguimientoPedidos.getHitoSeguimiento());
                dtoSeguimientoPedidos.setIndCompleto(Boolean.TRUE);
                
                
                
                //Llamamamos al método ISeguimientoPedidos.actualizarSeguimientoPedidos(dtoSeg) 
                //(El MON que implementa la interfaz es MONSeguimientoPedidos) 
               try{
                            MONSeguimientoPedidos monSeguimiento = this.getMONSeguimientoPedidosHome();
                           //UtilidadesLog.debug("\n\nParametros monSeguimiento.actualizarSeguimientoPedidos dtoSeguimientoPedidos  :" + dtoSeguimientoPedidos );
                            monSeguimiento.actualizarSeguimientoPedidos(dtoSeguimientoPedidos);
                        }catch(RemoteException re){                           
                            UtilidadesLog.error(re);
                              throw new MareException(re,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
                       }*/
                
                
            
          }//(registro=gi.cargarReg
        }catch(InterfacesException ie){            
            UtilidadesLog.debug(ie);
            throw new MareException(ie,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
        
        }catch(RemoteException re){            
            UtilidadesLog.error(re);
             
            throw new MareException(re,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
        }
        
        //AÑADIDO POR INCIDECIA 13391
        /*String mensaje
        mensaje += "Recepcionar Seguimiento de Pedidos procesado - "
        Retornar new DTOSalidaBatch( 0, mensaje )*/
        String mensaje = "";
        mensaje += "Recepcionar confirmacin de repartos procesado - ";
        
        UtilidadesLog.info("MONCORBean.recibirConfirmacionReparto(DTOBatch dtoe): Salida");
        return new DTOSalidaBatch( 0, mensaje );
    }
    
    private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONCORBean.getMONGestorInterfaces(): Entrada");
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
        UtilidadesLog.info("MONCORBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}


    private String comprobarCodigo(String codigo , String codigo1 , String codigo2){
     UtilidadesLog.info("MONCORBean.comprobarCodigo(String codigo , String codigo1 , String codigo2): Entrada");
     UtilidadesLog.debug("codigo  "+ codigo);
     UtilidadesLog.debug("codigo1  "+ codigo1);
     UtilidadesLog.debug("codigo2  "+ codigo2);
        String retorno = "";
        
        if (codigo!=null || !codigo.trim().equals("")){
            retorno = retorno + codigo;   
        }
        if(codigo1!=null || !codigo1.trim().equals("")){
            retorno = retorno + codigo1;
        }
        if(codigo2!=null || !codigo2.trim().equals("")){
            retorno = retorno + codigo2;
        }
        UtilidadesLog.debug("retorno " + retorno);
        UtilidadesLog.info("MONCORBean.comprobarCodigo(String codigo , String codigo1 , String codigo2): Salida");
        return retorno;        
    }
    
    
     private Date pasarAFecha(java.util.Date fecha){
        UtilidadesLog.info("MONCORBean.pasarAFecha(java.util.Date fecha): Entrada");
        UtilidadesLog.debug("Fecha de entrada: "+fecha);
        Date fechaFin=null;
        if(fecha!=null){
            fechaFin = new Date(fecha.getTime());
        }else if(fecha==null){
            UtilidadesLog.debug("La fecha pasada a la clase pasarAFecha es null");
        }
        
        UtilidadesLog.debug("Fecha de cambiada: "+ fechaFin);
        UtilidadesLog.info("MONCORBean.pasarAFecha(java.util.Date fecha): Salida");
       return fechaFin;
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }


    private EmpresaLocalHome getEmpresaLocalHome() {
        return new EmpresaLocalHome();
    }
    
    private MarcaLocalHome getMarcaLocalHome() {
        return new MarcaLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
       return new ClienteDatosBasicosLocalHome();
    }
    
    private TiposSolicitudLocalHome getTiposSolicitudLocalHome() {        
        return new TiposSolicitudLocalHome();
    }
    
    private ClaseSolicitudLocalHome getClaseSolicitudLocalHome()  {
       return new ClaseSolicitudLocalHome();
    }

    private TiposSolicitudPaisLocalHome getTiposSolicitudPaisLocalHome() {
        return new TiposSolicitudPaisLocalHome();
    }   
    
    private SeguimientoPedidosINTLocalHome getSeguimientoPedidosINTLocalHome() {
            return new SeguimientoPedidosINTLocalHome();
    }

    private TipoDireccionRepartoLocalHome getTipoDireccionRepartoLocalHome() {
            return new TipoDireccionRepartoLocalHome();
    }

    private ConfirmacionRepartoLARLocalHome getConfirmacionRepartoLARLocalHome() {
            return new ConfirmacionRepartoLARLocalHome();
    }


}//clase