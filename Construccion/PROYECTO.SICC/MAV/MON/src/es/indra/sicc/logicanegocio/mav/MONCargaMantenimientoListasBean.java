package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import es.indra.sicc.dtos.mav.DTOEValidarProducto;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.sicc.dtos.pre.DTOProductoMatriz;
import es.indra.sicc.logicanegocio.mae.MONProductos;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
//import es.indra.sicc.util.CodigosModulos;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import java.rmi.RemoteException;

import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;


public class MONCargaMantenimientoListasBean implements SessionBean {
    private SessionContext ctx;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {}

    public DTOSProductoValidado validarProductos(DTOEValidarProducto dto)
        throws MareException {
        UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Entrada");
        try {
            MONMantenimientoMFHome mmMFH = this.getMONMantenimientoMFHome();
            MONMantenimientoMF mmMF = mmMFH.create();

            MONProductosHome mph = this.getMONProductosHome();
            MONProductos mp = mph.create();

            Long oidProd = new Long(0);
            oidProd = mp.obtenerOidProducto(dto.getOidPais(), dto.getCodigoSAP());

            if(oidProd != null) 
            {
                DTOProductoMatriz dtoPM = new DTOProductoMatriz();

                dtoPM.setOidIdioma(dto.getOidIdioma());
                dtoPM.setIpCliente(dto.getIpCliente());
                dtoPM.setPrograma(dto.getPrograma());

                //asignacion, segun inc.: 5543
                //dtoPM.setCodigoVenta();
                dtoPM.setOidAcceso(dto.getOidAcceso());
                dtoPM.setOidCanal(dto.getCanal());
                dtoPM.setOidCicloVida(dto.getCicloVida());
                //dtoPM.setOidEstrategia();
                dtoPM.setOidFormaPago(dto.getFormaPago());
                dtoPM.setOidMarca(dto.getMarca());
                dtoPM.setOidPais(dto.getPais());
                dtoPM.setOidPeriodo(dto.getPeriodo());
                dtoPM.setOidPeriodoFin(dto.getPeriodoFin());
                dtoPM.setOidSAP(oidProd);
                dtoPM.setOidSubacceso(dto.getOidSubacceso());
                dtoPM.setOidTipoOferta(dto.getTipoOferta());
                dtoPM.setPrecioCatalogo((dto.getPrecioCatalogo()!=null)?new BigDecimal(dto.getPrecioCatalogo().doubleValue()):null);
                dtoPM.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);

                DTOProductoMatriz dtoPM1 = new DTOProductoMatriz();

                UtilidadesLog.debug("Busca Producto en MAtriz");
                dtoPM1 = mmMF.buscaProductoEnMatriz(dtoPM);
                UtilidadesLog.debug("Termino Buscar PRoducto en Matriz");
                UtilidadesLog.debug("dtoPM1: " + dtoPM1);

                if(dtoPM1 != null) 
                {
                    UtilidadesLog.debug(" ---------- Entra al Primer Branch");
                    if((dtoPM1.getOidTipoOferta().longValue() == dto.getTipoOferta().longValue())
                        && (dtoPM1.getOidCicloVida().longValue() == dto.getCicloVida().longValue())) 
                    {
                        // Modificado por ssantana, 24/6/2005
                        // Se contempla que Forma de Pago y PrecioCatalogo pueden ser NULL.
                        Long formaPago = dtoPM1.getOidFormaPago();
                        BigDecimal bigPrecioCatalogo = dtoPM1.getPrecioCatalogo();
                        
                        // Aclaracion: dto.getFormaPago puede ser null (si la forma de Cobro es Gratis)
                        //    por lo que el if es:
                        //     Si ( (dto.getFormaPago y formaPago son NULL) o (ambos poseen 
                        //          poseen valor Y coinciden en su valor) )
                        //       Y
                        //        (bigPrecioCatalogo no es NULL y coincide con dto.getPrecioCatalogo())
                        // Nota: dto.getPrecioCatalogo() no puede ser NULL (es obligatorio en la pantalla).
                                        
                        UtilidadesLog.debug("dto.getFormaPago: " + dto.getFormaPago());
                        UtilidadesLog.debug("dto.getPrecioCatalogo(): " + dto.getPrecioCatalogo().doubleValue());
                        if ( ( (dto.getFormaPago() == null && formaPago == null) ||
                               (formaPago != null &&  dto.getFormaPago() != null && 
                                formaPago.longValue() == dto.getFormaPago().longValue())  
                              ) && 
                              ( bigPrecioCatalogo != null && 
                                (bigPrecioCatalogo.doubleValue() == dto.getPrecioCatalogo().doubleValue())) )
                           {
                                  UtilidadesLog.debug("ZZZZZZZZZZZZZZZZZZZZZ");
                                  //Crear un objeto "DTOSProductoValidado"
                                  DTOSProductoValidado dtosPV = new DTOSProductoValidado();
                                  dtosPV.setCodigoVenta(dtoPM1.getCodigoVenta());
                                  dtosPV.setPrecioCatalogo((dtoPM1.getPrecioCatalogo()!=null)?new Double(dtoPM1.getPrecioCatalogo().doubleValue()):null);
                                  UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Salida");
                                  return dtosPV;
                            } else {
                               
                                /*
                                 * A pedido de Guardiola, se modifica el comportamiento,
                                 * Ahora no lanza exception, sino que agrega el producto,
                                 * es decir, se modifica el flujo alternativo 4 del caso de uso
                                 * validar producto y se hace lo mismo que en el flujo alternativo 3
                                 * 
                                //log....
                                  UtilidadesLog.debug("YYYYYYYYYYYYY");
                                  BelcorpService belcorpService = BelcorpService.getInstance();
                                  LogAPP.info(new String("validarProductos: " + ErroresNegocio.MAV_0003));

                                  throw new MareException(new Exception(),
                                  //  UtilidadesError.armarCodigoError(CodigosModulos.PRE, "", ErroresNegocio.MAV_0003));
                                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0003));
                                  */
                                 return this.agregarProducto(dto,dtoPM, mmMF ,oidProd);
                            }
                    } else {
                        UtilidadesLog.debug("Entra por acaaaaaaaaa");
                        DAOParametrizacionMAV daoPM = new DAOParametrizacionMAV();
                        Long oidEstr = new Long(0);

                        try {
                            oidEstr = new Long(daoPM.obtenerEstrategiaParametrizacionMAVPais(dto.getOidPais()).toString());
                        } catch(MareException ne) {
                          UtilidadesLog.error(ne);
                          throw ne;
                        } catch(Exception exception) {
                            throw new MareException(exception,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                        }

                        dtoPM.setOidEstrategia(oidEstr);

                        //insertar prod. en matriz.
                        String sCodVta = new String();
                        UtilidadesLog.debug("insertarProductoEnMatriz 11111111111111");
                        //sCodVta = mmMF.insertarProductoEnMatriz(dtoPM);

                        //Crear un objeto "DTOSProductoValidado"
                        DTOSProductoValidado dtosPV1 = new DTOSProductoValidado();
                        dtosPV1.setCodigoVenta(sCodVta);
                        dtosPV1.setPrecioCatalogo((dtoPM1.getPrecioCatalogo()!=null)?new Double(dtoPM1.getPrecioCatalogo().doubleValue()):null);
                        UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Salida");
                        return dtosPV1;
                    }
                } else {
/*                
                    UtilidadesLog.debug(" ---------- Entra al Segundo Branch");                
                    DAOParametrizacionMAV daoPM1 = new DAOParametrizacionMAV();

                    Long oidEstr1 = new Long(0);

                    try {
                        oidEstr1 = new Long(daoPM1.obtenerEstrategiaParametrizacionMAVPais(dto.getOidPais()).toString());
                    } catch(MareException ne) {
                      UtilidadesLog.error(ne);
                      throw ne;
                    } catch(Exception exception) {
                        throw new MareException(exception,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    //creo DTOProductoMatriz
                    DTOProductoMatriz dtoPM2 = new DTOProductoMatriz();

                    //dtoPM2.setCodigoVenta();
                    dtoPM2.setOidAcceso(dto.getOidAcceso());
                    dtoPM2.setOidCanal(dto.getCanal());
                    dtoPM2.setOidCicloVida(dto.getCicloVida());
                    dtoPM2.setOidEstrategia(oidEstr1);
                    dtoPM2.setOidFormaPago(dto.getFormaPago());
                    dtoPM2.setOidMarca(dto.getMarca());
                    dtoPM2.setOidPais(dto.getOidPais());
                    dtoPM2.setOidPeriodo(dto.getPeriodo());
                    dtoPM2.setOidPeriodoFin(dto.getPeriodoFin());
                    dtoPM2.setOidSAP(oidProd);
                    dtoPM2.setOidSubacceso(dto.getOidSubacceso());
                    dtoPM2.setOidTipoOferta(dto.getTipoOferta());
          					dtoPM2.setPrecioCatalogo((dto.getPrecioCatalogo()!=null)?new BigDecimal(dto.getPrecioCatalogo().doubleValue()):null);
          					dtoPM2.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);
                    dtoPM2.setOidIdioma(dto.getOidIdioma());
                    dtoPM2.setIpCliente(dto.getIpCliente());
                    dtoPM2.setPrograma(dto.getPrograma());

                    //insertar prod. en matriz.
                    String sCodVta1 = new String();

                    UtilidadesLog.debug("insertarProductoEnMatriz 22222222222222");
                    UtilidadesLog.debug("---- DTOPM2: " + dtoPM2 );
                    sCodVta1 = mmMF.insertarProductoEnMatriz(dtoPM2);

                    //Crear un objeto "DTOSProductoValidado"
                    DTOSProductoValidado dtosPV2 = new DTOSProductoValidado();
                    dtosPV2.setCodigoVenta(sCodVta1);
                    dtosPV2.setPrecioCatalogo((dtoPM.getPrecioCatalogo()!=null)?new Double(dtoPM.getPrecioCatalogo().doubleValue()):null);
*/
                    UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Salida");
                    
                    return this.agregarProducto(dto,dtoPM, mmMF ,oidProd);
                    //return dtosPV2;
                    
                    
                }
            } else {
                BelcorpService belcorpService = BelcorpService.getInstance();
                LogAPP.info(new String("validarProductos: " + ErroresNegocio.MAV_0002));

                throw new MareException(new Exception(),
                   // UtilidadesError.armarCodigoError(CodigosModulos.PRE, "", ErroresNegocio.MAV_0002));
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0002));                                                   
            }
        } catch(NamingException Ne) {
            UtilidadesLog.error(Ne);
            ctx.setRollbackOnly();
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private DTOSProductoValidado agregarProducto(DTOEValidarProducto dto,DTOProductoMatriz dtoPM, MONMantenimientoMF mmMF ,Long oidProd)throws MareException{

        DAOParametrizacionMAV daoPM1 = new DAOParametrizacionMAV();

        // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010        
        Long oidEstr1 = null;
        Long oidCatalogo = null;
        Long oidCondicionPromocion = null;

        try {
            Map resultado = daoPM1.obtenerParametrizacionMAVPais(dto.getOidPais());
            
            oidEstr1 = (Long)resultado.get("oidEstrategia");
            
            if(resultado.get("oidCatalogo")!=null)
                oidCatalogo = (Long)resultado.get("oidCatalogo");
            if(resultado.get("oidCondicionPromocion")!=null)
                oidCondicionPromocion = (Long)resultado.get("oidCondicionPromocion");
            
        } catch(MareException ne) {
          UtilidadesLog.error(ne);
          throw ne;
        } catch(Exception exception) {
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        //creo DTOProductoMatriz
        DTOProductoMatriz dtoPM2 = new DTOProductoMatriz();
        
        //dtoPM2.setCodigoVenta();
        dtoPM2.setOidAcceso(dto.getOidAcceso());
        dtoPM2.setOidCanal(dto.getCanal());
        dtoPM2.setOidCicloVida(dto.getCicloVida());
        dtoPM2.setOidEstrategia(oidEstr1);
        dtoPM2.setOidFormaPago(dto.getFormaPago());
        dtoPM2.setOidMarca(dto.getMarca());
        dtoPM2.setOidPais(dto.getOidPais());
        dtoPM2.setOidPeriodo(dto.getPeriodo());
        dtoPM2.setOidPeriodoFin(dto.getPeriodoFin());
        dtoPM2.setOidSAP(oidProd);
        dtoPM2.setOidSubacceso(dto.getOidSubacceso());
        dtoPM2.setOidTipoOferta(dto.getTipoOferta());
        dtoPM2.setPrecioCatalogo((dto.getPrecioCatalogo()!=null)?new BigDecimal(dto.getPrecioCatalogo().doubleValue()):null);
        dtoPM2.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);
        dtoPM2.setOidIdioma(dto.getOidIdioma());
        dtoPM2.setIpCliente(dto.getIpCliente());
        dtoPM2.setPrograma(dto.getPrograma());
        
        // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
        dtoPM2.setOidCatalogo(oidCatalogo);
        dtoPM2.setOidCondicionPromocion(oidCondicionPromocion);
        
        //insertar prod. en matriz.
        String sCodVta1 = new String();
        
        UtilidadesLog.debug("insertarProductoEnMatriz 22222222222222");
        UtilidadesLog.debug("---- DTOPM2: " + dtoPM2 );
        try{
            sCodVta1 = mmMF.insertarProductoEnMatriz(dtoPM2);
        }catch(Exception e) {
            throw new MareException("Excepcion al crear el producto",e);
        }
        
        //Crear un objeto "DTOSProductoValidado"
        DTOSProductoValidado dtosPV2 = new DTOSProductoValidado();
        dtosPV2.setCodigoVenta(sCodVta1);
        dtosPV2.setPrecioCatalogo((dtoPM.getPrecioCatalogo()!=null)?new Double(dtoPM.getPrecioCatalogo().doubleValue()):null);
        
        UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Salida");
        return dtosPV2;
        
    }


    private MONProductosHome getMONProductosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProductos"), MONProductosHome.class);
    }

    private MONMantenimientoMFHome getMONMantenimientoMFHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"),
            MONMantenimientoMFHome.class);
    }
}