package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOEBuscarTiposMovimientosAlmacen;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocal;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoTiposMovimientosAlmacenBean implements SessionBean  {

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
		this.ctx=ctx;
	}

	public DTOSalida buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto):Entrada");
		DAOTiposMovimientosAlmacen daoTiposMovimientosAlmacen=new DAOTiposMovimientosAlmacen();
		DTOSalida salida=daoTiposMovimientosAlmacen.buscarTiposMovimientosAlmacen(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
        // Si la consulta no devuelve ningun dato
        if (salida.getResultado().esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****buscarTiposMovimientosAlmacen: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto):Salida");
		return salida;
	}
	public void eliminarTiposMovimientosAlmacen(DTOOIDs dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.eliminarTiposMovimientosAlmacen(DTOOIDs dto):Entrada");
		Long oids[]=dto.getOids();
		TipoMovimientosAlmacenLocalHome tipoMovimientosAlmacenLocalHome=this.getTipoMovimientosAlmacenLocalHome();
		Entidadi18nLocalHome entidadi18nLocalHome=this.getI18NEntityLocalHome();
		
		try{
			for (int i=0;i<oids.length;i++){
				try{
					TipoMovimientosAlmacenLocal tipoMovimientoAlmacenLocal = tipoMovimientosAlmacenLocalHome.findByPrimaryKey(oids[i]);
					this.validaAcceso(tipoMovimientoAlmacenLocal.getPais(),null,null,null,null,null,null,null,null);
					tipoMovimientosAlmacenLocalHome.remove(tipoMovimientoAlmacenLocal);
				
					Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("BEL_TIPO_MOVIM_ALMAC",oids[i]);					
					if(!coleccionI18N.isEmpty()){
						Iterator iterador=coleccionI18N.iterator();
						while(iterador.hasNext()){
							Entidadi18nLocal aux = (Entidadi18nLocal)iterador.next();
                                                        entidadi18nLocalHome.remove(aux);
						}				
					}					
				}catch(NoResultException finder){
					UtilidadesLog.debug("No se ha encontrado en Atributo Traducible con oid:"+oids[i]);
                                }  catch (PersistenceException ce) {   
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}
				
			}
		}catch(PersistenceException rm){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
			this.logearError("eliminarTiposMovimientosAlmacen: RemoveException",rm);
			throw new MareException(rm, UtilidadesError.armarCodigoError(codigoError));    			
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.eliminarTiposMovimientosAlmacen(DTOOIDs dto):Salida");
	}
	public  DTOTipoMovimientoAlmacen consultarTipoMovimientoAlmacen(DTOOID dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.consultarTipoMovimientoAlmacen(DTOOID dto):Entrada");
		DTOTipoMovimientoAlmacen dtoRetorno=new DTOTipoMovimientoAlmacen();
		DAOTiposMovimientosAlmacen daoTiposMovimientosAlmacen=new DAOTiposMovimientosAlmacen();
		Entidadi18nLocalHome entidadi18nLocalHome=this.getI18NEntityLocalHome();
		RecordSet rs=daoTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(dto);
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
			ArrayList arrayTraduc=null;
			
			Collection coleccionI18N=entidadi18nLocalHome.findByEntPK("BEL_TIPO_MOVIM_ALMAC",dto.getOid());
			if(!coleccionI18N.isEmpty()){
				arrayTraduc=new ArrayList();
				DTOI18nSICC dtoI18N=null;
				Iterator iterador=coleccionI18N.iterator();				
				while(iterador.hasNext()){
					Entidadi18nLocal i18N=(Entidadi18nLocal)iterador.next();
					dtoI18N=new DTOI18nSICC();
					dtoI18N.setOidAtriuto(i18N.getEntidad_pk());
					dtoI18N.setOidIdioma(i18N.getIdioma());
					dtoI18N.setValorI18n(i18N.getDetalle());
					arrayTraduc.add(dtoI18N);
				}				
			}
			dtoRetorno.setAttTraducible(arrayTraduc);
		}		
		}catch(NoResultException fe){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("consultarTipoMovimientoAlmacen: CreateException",fe);
			throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));   			
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.consultarTipoMovimientoAlmacen(DTOOID dto):Salida");
		return dtoRetorno;
	}
	public void guardarTipoMovimientoAlmacen(DTOTipoMovimientoAlmacen dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.guardarTipoMovimientoAlmacen(DTOTipoMovimientoAlmacen dto):Entrada");
		TipoMovimientosAlmacenLocalHome tipoMovimientosAlmacenLocalHome=this.getTipoMovimientosAlmacenLocalHome();
		Entidadi18nLocalHome entidadi18nLocalHome=this.getI18NEntityLocalHome();
		TipoMovimientosAlmacenLocal tipoMov=null;
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null);
		try{
			if(dto.getOid()==null){
				tipoMov=tipoMovimientosAlmacenLocalHome.create(
														dto.getOidPais(),/*Long pais*/
														dto.getCodigoMovimiento(),/*String codigoMovimiento*/
														dto.getCodigoMovimientoSAP(),/*String codigoMovimientoSAP*/
														dto.getMovimientoEntreAlmacenes(),/*Boolean movimientoEntreAlmacenes*/
														dto.getMantieneMovimientos(),/*Boolean mantieneMovimientos*/
														dto.getIndicadorSAP(),/*Boolean indicadorSAP*/
														dto.getOidEstadoMercancia1(),/*Long estadoMercancia1*/
														dto.getOidEstadoMercancia2(),/*Long estadoMercancia2*/
														dto.getOperacion1(),/*Character operacion1*/
														dto.getOperacion2()/*Character operacion2*/
														);
			}else{
					tipoMov=tipoMovimientosAlmacenLocalHome.findByPrimaryKey(dto.getOid());
					tipoMov.setPais(dto.getOidPais());/*Long pais*/
					tipoMov.setCodigoMovimiento(dto.getCodigoMovimiento());/*String codigoMovimiento*/
					tipoMov.setCodigoMovimientoSAP(dto.getCodigoMovimientoSAP());/*String codigoMovimientoSAP*/
					tipoMov.setMovimientoEntreAlmacenes(dto.getMovimientoEntreAlmacenes());/*Boolean movimientoEntreAlmacenes*/
					tipoMov.setMantieneMovimientos(dto.getMantieneMovimientos());/*Boolean mantieneMovimientos*/
					tipoMov.setIndicadorSAP(dto.getIndicadorSAP());/*Boolean indicadorSAP*/
					tipoMov.setEstadoMercancia1(dto.getOidEstadoMercancia1());/*Long estadoMercancia1*/
					tipoMov.setEstadoMercancia2(dto.getOidEstadoMercancia2());/*Long estadoMercancia2*/
					tipoMov.setOperacion1(dto.getOperacion1());/*Character operacion1*/
					tipoMov.setOperacion2(dto.getOperacion2());/*Character operacion2*/					
                                        
                                        tipoMovimientosAlmacenLocalHome.merge(tipoMov);
 
			}
			
      ArrayList arrayAttrTraduc=dto.getAttTraducible();
      
			if(arrayAttrTraduc!=null ){
        // cdos gPineda 03/08/2006 - BELC300023320 - INICIO
      	for(int i=0;i<arrayAttrTraduc.size();i++){
          DTOI18nSICC dtoi18n = (DTOI18nSICC)arrayAttrTraduc.get(i);
          Entidadi18nLocal i18n = null;
					try{
            //UtilidadesLog.debug("DTOI18nSICC[" + i + "]: " + dtoi18n );
            i18n = entidadi18nLocalHome.findByEntAtrIdioPK(
                                      "BEL_TIPO_MOVIM_ALMAC",/*String entidad*/
                                      new Long(1),/*Long atributo*/
                                      dtoi18n.getOidIdioma(),/*Long idioma*/
                                      tipoMov.getOid()/*Long entidad_pk*/
                                      );
            
            if( dtoi18n.getValorI18n().equals(" ") ){
              //Si esta con un caracter en blanco, es que fue borrado por el usuario
              entidadi18nLocalHome.remove(i18n);
              UtilidadesLog.debug("DTOI18nSICC: Se elimina");
            }else{
              i18n.setDetalle( ((DTOI18nSICC)arrayAttrTraduc.get(i)).getValorI18n() );
              entidadi18nLocalHome.merge(i18n);
              //UtilidadesLog.debug("DTOI18nSICC: Se actualiza");
            }
          }catch( NoResultException fe ){
            if( ! dtoi18n.getValorI18n().equals(" ") ){
              i18n = entidadi18nLocalHome.create(
                            "BEL_TIPO_MOVIM_ALMAC",/*String entidad*/
                            new Long(1),/*Long atributo*/
                            dtoi18n.getOidIdioma(),/*Long idioma*/
                            dtoi18n.getValorI18n(),/*String detalle*/
                            tipoMov.getOid()/*Long entidad_pk*/
                            );
              //UtilidadesLog.debug("DTOI18nSICC: Se creó: " + i18n );
            }else{
              //UtilidadesLog.debug("DTOI18nSICC: NO se creó, por getValorI18n()=\"" + dtoi18n.getValorI18n() + "\"");
            }
           }  catch (PersistenceException ce) {   
               UtilidadesLog.error("ERROR ", ce);
               throw new MareException(ce, 
               UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
				}
        // cdos gPineda 03/08/2006 - BELC300023320 -  FIN
			}
			
               }catch(NoResultException fe){
                         ctx.setRollbackOnly();
                         String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                         this.logearError("guardarTipoMovimientoAlmacen: CreateException",fe);
                         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));                                                                     
		}catch(PersistenceException cr){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logearError("guardarTipoMovimientoAlmacen: CreateException",cr);
			throw new MareException(cr, UtilidadesError.armarCodigoError(codigoError));    						
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.guardarTipoMovimientoAlmacen(DTOTipoMovimientoAlmacen dto):Salida");
	}
	public DTOSalida obtenerTiposMovimientosAlmacen(DTOBelcorp dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.obtenerTiposMovimientosAlmacen(DTOBelcorp dto):Entrada");
		DAOTiposMovimientosAlmacen daoTiposMovimientosAlmacen=new DAOTiposMovimientosAlmacen();
		RecordSet rs=daoTiposMovimientosAlmacen.obtenerTiposMovimientosAlmacen(dto);
		if(rs==null){
			rs=new RecordSet();
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.obtenerTiposMovimientosAlmacen(DTOBelcorp dto):Salida");
		return new DTOSalida(rs);
	}

    private void validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws  MareException {
        UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

		UtilidadesLog.debug("****Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);
		try{
			b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		}catch(RemoteException rExc){
       UtilidadesLog.error(rExc);
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB) );			
		}
		UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
   }


    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  getMONValidacion: Entrada");				
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMONValidacion: Salida");		        
        return ejb;
	}


	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}			

    public DTOSalida obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto) throws MareException  {
        UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto):Entrada");
		DAOTiposMovimientosAlmacen daoTiposMovimientosAlmacen=new DAOTiposMovimientosAlmacen();
		RecordSet rs=daoTiposMovimientosAlmacen.obtenerTiposMovimientosIndicadorSAP(dto);
		if(rs==null){
			rs=new RecordSet();
		}
		UtilidadesLog.info("MONMantenimientoTiposMovimientosAlmacenBean.obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto):Salida");
		return new DTOSalida(rs);
    }
    
    private Entidadi18nLocalHome getI18NEntityLocalHome() {
        return new Entidadi18nLocalHome();
    }   

    private TipoMovimientosAlmacenLocalHome getTipoMovimientosAlmacenLocalHome() {
        return new TipoMovimientosAlmacenLocalHome();
    }

}
