package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTOINTDirecciones;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.seg.NivelSocioeconomicoBelcorpLocal;
import es.indra.sicc.entidades.seg.NivelSocioeconomicoBelcorpLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.TipoViaLocal;
import es.indra.sicc.entidades.seg.TipoViaLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.logicanegocio.zon.IServiceUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import java.util.Iterator;

import es.indra.sicc.entidades.mae.ClienteDireccionLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONINTGEOBean implements SessionBean{
  
  private SessionContext ctx = null;
  private Long oidTerritorio = null;
  
  
  public void ejbCreate(){
  }

  public void ejbActivate(){
  }

  public void ejbPassivate() {
  }

  public void ejbRemove(){
  }

  public void setSessionContext(SessionContext ctx){
      this.ctx = ctx;
  }
  
  public DTOSalidaBatch enviarEstandarizacionDeDirecciones(DTOBatch dtoBatch) throws MareException{
    
    UtilidadesLog.info("MONINTGEOBean.enviarEstandarizaciónDeDirecciones(DTOOID DTOE): Entrada");
       
      DAOGEO dao = new DAOGEO();
      
      UtilidadesLog.debug("****JAS**** antes de dao.obtenerDirecciones()");
      ArrayList listaDirecciones = dao.obtenerDirecciones();
      UtilidadesLog.debug("****JAS**** despues de dao.obtenerDirecciones()");
      if(listaDirecciones!=null&&!listaDirecciones.isEmpty()){
        try{
    
          
          MONGestorInterfaces gestor = this.getMONGestorInterfaces();
          
          //en vez de usar DTOID....
          PaisLocalHome paisLocalHome = null;
          PaisLocal paisLocal = null;
          paisLocalHome = this.getPaisLocalHome();
          
          DTOString dtoPais = (DTOString) dtoBatch.getDTOOnline();
          try {
            paisLocal = paisLocalHome.findByUk(dtoPais.getString("cadena"));
            UtilidadesLog.debug("****JAS**** pais = " + paisLocal.getOid());
          }catch (NoResultException fe) {
            UtilidadesLog.error("MONGEOINT.enviarEstandarizacionDirecciones: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          }  catch (PersistenceException ce) {   
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
          
          InterfazInfo interfaz = gestor.crearInterfaz(IGestorInterfaces.COD_INTERFAZ_GEO1,paisLocal.getOid());
          
    
          if (listaDirecciones != null | listaDirecciones.size() > 0){
            
            UtilidadesLog.debug("****JAS**** elementos en listaDirecciones: " + listaDirecciones.size());
            
            RegistroSicc registro = new RegistroSicc();
            DTOINTDirecciones dtoDirecciones = null;
            
            int elementosLista = listaDirecciones.size();
            int contador=0;
            
            UtilidadesLog.debug("****JAS**** voy al primer while");
            while(contador < elementosLista){
              
              UtilidadesLog.debug("****JAS**** while1 - nueva iteracion");
              
              dtoDirecciones = (DTOINTDirecciones) listaDirecciones.get(contador);
              
              registro.anyadirCampo(IRegistroSicc.GEO1_CODIGO_PAIS, dtoDirecciones.getCodPais());
              registro.anyadirCampo(IRegistroSicc.GEO1_CODIGO_CLIENTE, dtoDirecciones.getCodClie());
              registro.anyadirCampo(IRegistroSicc.GEO1_CODIGO_TIPO_DIRECCION, dtoDirecciones.getCodTipoDir());
              
              StringBuffer direcciones = new StringBuffer();
              
              String tipoVia = dtoDirecciones.getTipoVia();
              if(tipoVia.length() < 2){
                tipoVia = rellenarEspacios(tipoVia,2,tipoVia.length(),0);
              }
              UtilidadesLog.debug("****JAS**** tipoVia: " + tipoVia);
              direcciones.append(tipoVia);
              
              String nombreVia = dtoDirecciones.getNombreVia();
              if(nombreVia.length() < 50){
                nombreVia = rellenarEspacios(nombreVia,50,nombreVia.length(),0);
              }
              UtilidadesLog.debug("****JAS**** nombreVia: " + nombreVia);
              direcciones.append(nombreVia);
              
              String numero = dtoDirecciones.getNumero();
              if(numero.length() < 6){
                numero = rellenarEspacios(numero,6,numero.length(),0);
              }
              UtilidadesLog.debug("****JAS**** numero: " + numero);
              direcciones.append(numero);
              
              String interior = dtoDirecciones.getInterior().toString();
              if(interior.length() < 3){
                interior = rellenarEspacios(interior,3,interior.length(),1);
              }
              UtilidadesLog.debug("****JAS**** interior: " + interior);
              direcciones.append(interior);
              
              String manzana = dtoDirecciones.getManzana().toString();
              if(manzana.length() < 3){
                manzana = rellenarEspacios(manzana,3,manzana.length(),1);
              }
              UtilidadesLog.debug("****JAS**** manzana: " + manzana);
              direcciones.append(manzana);
              
              String lote = dtoDirecciones.getLote().toString();
              if(lote.length() < 3){
                lote = rellenarEspacios(lote,3,lote.length(),1);
              }
              UtilidadesLog.debug("****JAS**** lote: " + lote);
              direcciones.append(lote);
              
              String kilometro = dtoDirecciones.getKilometro().toString();
              if(kilometro.length() < 3){
                kilometro = rellenarEspacios(kilometro,3,kilometro.length(),1);
              }
              UtilidadesLog.debug("****JAS**** kilometro: " + kilometro);
              direcciones.append(kilometro);
              
              UtilidadesLog.debug("****JAS**** contenido de direcciones: " + direcciones.toString());
              UtilidadesLog.debug("****JAS**** caracteres de direcciones: " + direcciones.length());
              
              registro.anyadirCampo(IRegistroSicc.GEO1_DIRECCIONES, direcciones.toString());
              registro.anyadirCampo(IRegistroSicc.GEO1_UBIGEO_NIVEL_1, dtoDirecciones.getCodUbiNivel1());
              registro.anyadirCampo(IRegistroSicc.GEO1_UBIGEO_NIVEL_2, dtoDirecciones.getCodUbiNivel2());
              registro.anyadirCampo(IRegistroSicc.GEO1_UBIGEO_NIVEL_3, dtoDirecciones.getCodUbiNivel3());
              registro.anyadirCampo(IRegistroSicc.GEO1_UBIGEO_NIVEL_4, dtoDirecciones.getCodUbiNivel4());
              registro.anyadirCampo(IRegistroSicc.GEO1_NIVEL_SOCIO_ECONOMICO, null);
              registro.anyadirCampo(IRegistroSicc.GEO1_COORDENADA_X, null);
              registro.anyadirCampo(IRegistroSicc.GEO1_COORDENADA_Y, null);
              registro.anyadirCampo(IRegistroSicc.GEO1_COORDENADA_Z, null);
              registro.anyadirCampo(IRegistroSicc.GEO1_CODIGO_TERRITORIO, null);
              registro.anyadirCampo(IRegistroSicc.GEO1_CONTROL_INTERFACE_GEORREFERENCIADOR, ConstantesINT.INDICADOR_ENVIADO);
              
              UtilidadesLog.debug("****JAS**** despues de todos los registro.anyadirCampo(....)");
              
              gestor.anyadirRegistro(interfaz,registro);
              UtilidadesLog.debug("****JAS**** despues de gestor.anyadirRegistro(interfaz,registro)");
              
              registro.vaciar();
              contador++;
            
            }//cierro while
            
            UtilidadesLog.debug("****JAS**** a la salida del while");
            
            gestor.enviarInterfaz(interfaz);
            UtilidadesLog.debug("****JAS**** despues de gestor.enviarInterfaz(interfaz)");
            
            UtilidadesLog.debug("****JAS**** voy al segundo while");
            int contador2=0;
            while(contador2 < elementosLista){
              UtilidadesLog.debug("****JAS**** while2 - nueva iteracion");
              dtoDirecciones = (DTOINTDirecciones) listaDirecciones.get(contador2);
              actualizarDireccion(dtoDirecciones.getOid(),interfaz.getNumeroLote());
              contador2++;
            }
          
          }//cierro if
          
          UtilidadesLog.debug("****JAS**** a la salida de listaDirecciones != null");
        
        }catch (InterfacesException ie) { //viene del primer try
          UtilidadesLog.error("MONINTGEO.enviarEstandarizaciónDeDirecciones(DTOOID DTOE) Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);
          throw new MareException(ie.getMotivo(), ie);
        }catch (RemoteException re) {
          UtilidadesLog.debug("*** Error MONGEOINT.enviarEstandarizaciónDeDirecciones(DTOOID DTOE)", re);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
       
        UtilidadesLog.info("MONINTGEOBean.enviarEstandarizaciónDeDirecciones(DTOOID DTOE): Salida");
        return new DTOSalidaBatch(0, "enviarEstandarizacionDirec finalizado");
     }
     UtilidadesLog.info("MONINTGEOBean.enviarEstandarizaciónDeDirecciones(DTOOID DTOE): Salida");
     return new DTOSalidaBatch(0, "enviarEstandarizacionDirec finalizado SIN registros");
  }
  
  
  private void actualizarDireccion (Long oid, String nombreFichero) throws MareException {
    
    UtilidadesLog.info("MONINTGEOBean.actualizarDireccion(Long oid, String nombreFichero : Entrada");
    
    try{
      
      ClienteDireccionLocalHome clienteDireccionLocalHome = null;
      ClienteDireccionLocal clienteDireccionLocal = null;
      clienteDireccionLocalHome = this.getClienteDireccionLocalHome();
      
      UtilidadesLog.debug("****JAS**** oid: " + oid + ", nombreFichero: " + nombreFichero);
      clienteDireccionLocal = clienteDireccionLocalHome.findByPrimaryKey(oid);
      UtilidadesLog.debug("****JAS**** clienteDireccionLocalHome.findByPrimaryKey(oid): " + clienteDireccionLocal.getOid());
      clienteDireccionLocal.setInd_ctrl_inte_geor(new Character(ConstantesINT.INDICADOR_ENVIADO.charAt(0)));
      clienteDireccionLocal.setVal_nomb_fich(nombreFichero);
      clienteDireccionLocalHome.merge(clienteDireccionLocal);
    }catch (NoResultException ex){
      UtilidadesLog.error("*** Error finder en actualizarDireccion de MONINTGEO",ex);
      throw new MareException(null,null,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    
    UtilidadesLog.info("MONINTGEOBean.actualizarDireccion(Long oid, String nombreFichero : Salida");
  
  }
  
  
    public DTOSalidaBatch recepcionarEstandarizacionDirecciones (DTOBatch dtoBatch) throws MareException{
    
        UtilidadesLog.info("MONINTGEOBean.recepcionarEstandarizacionDirecciones(DTOOID pais): Entrada");
        Cronometrador.startTransaction("MONINTGEOBean.recepcionarEstandarizacionDirecciones");
        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        try {
      
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = null;
            ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
            clienteDatosBasicosLocalHome = this.getClienteDatosBasicosLocalHome();
      
            PaisLocalHome paisLocalHome = null;
            PaisLocal paisLocal = null;
            paisLocalHome = this.getPaisLocalHome();
      
            ClienteDireccionLocalHome clienteDireccionLocalHome = null;
            ClienteDireccionLocal clienteDireccionLocal = null;
            clienteDireccionLocalHome = this.getClienteDireccionLocalHome();
      
            ClienteDatosAdicionalesLocalHome clienteDatosAdicionalesLocalHome = null;
            ClienteDatosAdicionalesLocal clienteDatosAdicionalesLocal = null;
            clienteDatosAdicionalesLocalHome = this.getClienteDatosAdicionalesLocalHome();
      
            DTOString dtoPais = (DTOString) dtoBatch.getDTOOnline();
            try {
                paisLocal = paisLocalHome.findByUk(dtoPais.getString("cadena"));
            }catch (NoResultException fe) {
                UtilidadesLog.error("MONGEOINT.recepcionarEstandarizacionDirecciones: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            gi = this.getMONGestorInterfaces();
            DAOGEO dao = new DAOGEO();
            interfaz = gi.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_GEO2, paisLocal.getOid());
      
            DTOAuditableSICC dto = new DTOAuditableSICC();
            dto.setIpCliente("127.0.0.1");
            dto.setPrograma("MONINTGEO.recepcionarEstandarizacionDirecciones");
      
            MONUnidadesAdministrativas mua = this.getMONUnidadesAdministrativas();
      
            IRegistroSicc registro = null;
            String direcciones = null;
            String codTipoVia = null;
            String codNSE = null;
            Integer codTerritorio = null;
            String codCliente = null;
            String codTipoDireccion = null;
            String codPais = null;
            Long coordenadaX = null;
            Long coordenadaY = null;
            Long coordenadaZ = null;
            String controlInterfaceGeo = null;

            while ( (registro = gi.cargarRegistro(interfaz,false) ) != null)    {
        
                direcciones = (String) registro.obtenerCampo(IRegistroSicc.GEO1_DIRECCIONES);
                codTipoVia = direcciones.substring(0,2).trim();
                codNSE = ( (String) registro.obtenerCampo(IRegistroSicc.GEO1_NIVEL_SOCIO_ECONOMICO) ).trim();
                Object oCodTerritorio = registro.obtenerCampo(IRegistroSicc.GEO1_CODIGO_TERRITORIO);
                if(oCodTerritorio!=null && !oCodTerritorio.toString().trim().equals("") ){
                    codTerritorio = new Integer(  oCodTerritorio.toString().trim() );
                }
                codPais = ( (String) registro.obtenerCampo(IRegistroSicc.GEO1_CODIGO_PAIS) ).trim();
                codCliente = ( (String) registro.obtenerCampo(IRegistroSicc.GEO1_CODIGO_CLIENTE) ).trim() ;
                codTipoDireccion = ( (String) registro.obtenerCampo(IRegistroSicc.GEO1_CODIGO_TIPO_DIRECCION) ).trim();
                coordenadaX = new Long( ( (registro.obtenerCampo(IRegistroSicc.GEO1_COORDENADA_X) ).toString() ).trim() );
                coordenadaY = new Long( ( (registro.obtenerCampo(IRegistroSicc.GEO1_COORDENADA_Y) ).toString() ).trim() );
                coordenadaZ = new Long( ( (registro.obtenerCampo(IRegistroSicc.GEO1_COORDENADA_Z) ).toString() ).trim() );
        
                //Hacer un findByUK en la entidad Pais pasándole como parámetro el campo codPais
                //y asignar el resultado a 'entityPais'        
                try {
                    UtilidadesLog.debug("****JAS1**** paisLocalHome.findByUk("+ codPais + ")");
                    paisLocal = paisLocalHome.findByUk(codPais);
                    UtilidadesLog.debug("****JAS1**** despues del find");
                }catch (NoResultException ex){
                    UtilidadesLog.error("*** Error finder en recepcionarEstandarizacionDirecciones de MONINTGEO - 1",ex);
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003 + codPais);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
        
                //Hacer un findByCodigoYPais en la entidad ClienteDatosBasicos pasándole los campos codCliente
                //y entityPais.oid, y asignar el resultado a 'entityCliente'
                try {
                    UtilidadesLog.debug("****JAS2**** clienteDatosBasicosLocalHome.findByCodigoYPais("+paisLocal.getOid()+","+codCliente+")");
                    clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByCodigoYPais(paisLocal.getOid(),codCliente);
                    UtilidadesLog.debug("****JAS2**** despues del find");
                }catch (NoResultException ex){
                    UtilidadesLog.error("*** Error finder en recepcionarEstandarizacionDirecciones de MONINTGEO - 2",ex);
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0032 + "pais: " + paisLocal.getOid() + "cliente: " + codCliente);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
          
                //Hacer un findByUK en la entidad TipoDireccion pasándole como parámetro el campo
                //codTipoDireccion y asignar el resultado a 'entityTipoDireccion' 
                UtilidadesLog.debug("****JAS3**** antes de dao.obtenerOidTipoDireccion(" + codTipoDireccion +")");
                RecordSet resultado = dao.obtenerOidTipoDireccion(codTipoDireccion);
                UtilidadesLog.debug("****JAS4**** al volver obtengo " + resultado.getValueAt(0,0).toString());
                String oidTipoDireccionRecuperado = resultado.getValueAt(0,0).toString();
        
                UtilidadesLog.debug("****JAS5**** antes de comprobarExistenciaCodigos(....)");
                String msgError = comprobarExistenciaCodigos(codTipoVia,codNSE,codTerritorio,paisLocal.getOid());
                UtilidadesLog.debug("****JAS6**** despues de comprobarExistenciaCodigos(....)");

                if(msgError == null)    {
          
                    UtilidadesLog.debug("****JAS7**** entro por msgError == null");
                    Long indicadorDirePrincipal = null;  
          
                    //Hacer un findByClienteyTipo en la entidad ClienteDireccion pasándole como parámetros los campos
                    //entityCliente.oid y entityTipoDireccion.oid, y asignar el resultado a 'entityDireccion'
                    try {
                        UtilidadesLog.debug("****JAS8**** clienteDireccionLocalHome.findByClienteYTipo(oidCliente: "+clienteDatosBasicosLocal.getOid()+",oidTipoDireccionRecuperado: "+oidTipoDireccionRecuperado+")");
                        Collection resultadoClienteDireccion = clienteDireccionLocalHome.findByClienteYTipo(clienteDatosBasicosLocal.getOid(),new Long(oidTipoDireccionRecuperado));
          
                        UtilidadesLog.debug("****JAS9**** antes de actualizar coordenadas");
                        Iterator itResultadoClienteDireccion = resultadoClienteDireccion.iterator();
                        while (itResultadoClienteDireccion.hasNext())   {
                            clienteDireccionLocal = (ClienteDireccionLocal)itResultadoClienteDireccion.next();
                            if (clienteDireccionLocal.getInd_elim()==null || clienteDireccionLocal.getInd_elim().longValue()!=1)    {
                                clienteDireccionLocal.setVal_coor_x(coordenadaX);
                                clienteDireccionLocal.setVal_coor_y(coordenadaY);
                                clienteDireccionLocal.setVal_coor_z(coordenadaZ);
                    
                                if(codTerritorio != null)   {
                                    clienteDireccionLocal.setTerr_oid_terr(oidTerritorio);
                                }
                                clienteDireccionLocalHome.merge(clienteDireccionLocal);
                    
                                indicadorDirePrincipal = clienteDireccionLocal.getInd_dire_ppal();
                            }
                            UtilidadesLog.debug("****JAS10**** despues de actualizar coordenadas");
                        }
                    }catch (NoResultException ex){
                        UtilidadesLog.error("*** Error finder en recepcionarEstandarizacionDirecciones de MONINTGEO - 3",ex);
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0032 + "cliente: " + clienteDatosBasicosLocal.getOid()+",oidTipoDireccionRecuperado: " + oidTipoDireccionRecuperado );
                        gi.registrarError(dtoError);
                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
            
                    //Hacer un findByCliente en la entidad ClienteDatosAdicionales pasándole como parámetros
                    //el campo entityCliente.oid y asignar el resultado a 'entityClienteAdicionales'
                    //Actualizar el campo en el entity obtenido (entityClienteAdicionales): NSE3 = codNSE
                    try {
                        UtilidadesLog.debug("****JAS11**** clienteDatosAdicionalesLocalHome.findByCliente(oidCliente: "+clienteDatosBasicosLocal.getOid()+")");
                        clienteDatosAdicionalesLocal = clienteDatosAdicionalesLocalHome.findByCliente(clienteDatosBasicosLocal.getOid());
                        UtilidadesLog.debug("****JAS12**** antes de actualizar codNSE");
                        clienteDatosAdicionalesLocal.setVal_nive_soci_eco3(codNSE);
                        //esto se modifica a pedido de Belcorp a fin de solucionar
                        //la incidencia Bloqueante MAE-5 (Gacevedo)
                        if (clienteDatosAdicionalesLocal.getNiri_oid_nive_ries()==null){
                            clienteDatosAdicionalesLocal.setNiri_oid_nive_ries(new Long(4));
                            clienteDatosAdicionalesLocal.setImp_mont_line_cred(new Double("0"));
                            clienteDireccionLocalHome.merge(clienteDireccionLocal);
                        }
                        UtilidadesLog.debug("****JAS13**** despues de actualizar codNSE");
                    }catch (NoResultException ex){
                        UtilidadesLog.error("*** Error finder en recepcionarEstandarizacionDirecciones de MONINTGEO - 4",ex);
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0032 + "cliente: " + clienteDatosBasicosLocal.getOid());
                        gi.registrarError(dtoError);
                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
          
                    //Llamar al método obtenerMarcasCanalesCliente(entityCliente.oid, entityPais.oid) del
                    //DAOGEO y obtener el RecordSet de salida.
                    UtilidadesLog.debug("****JAS14**** antes de dao.obtenerMarcasCanalesCliente(cliente: " + clienteDatosBasicosLocal.getOid()+",pais: " +paisLocal.getOid());
                    RecordSet rMarcasCanales = dao.obtenerMarcasCanalesCliente(clienteDatosBasicosLocal.getOid(),paisLocal.getOid());
                    UtilidadesLog.debug("****JAS15**** registros recuperados: " + rMarcasCanales.getRowCount());
          
                    //por cada registro llamar al método actualizarUnidadesAdmMAE de la 
                    //interfaz IServiceUnidadesAdministrativas de ZON

                    for(int i=0;i<rMarcasCanales.getRowCount();i++) {
                        UtilidadesLog.debug("****JAS**** rMarcasCanales.getValueAt(i,0).toString() " + rMarcasCanales.getValueAt(i,0).toString());
                        UtilidadesLog.debug("****JAS**** paisLocal.getOid() " + paisLocal.getOid());
                        UtilidadesLog.debug("****JAS**** rMarcasCanales.getValueAt(i,1).toString() " + rMarcasCanales.getValueAt(i,1).toString());
                        UtilidadesLog.debug("****JAS**** oidTerritorio " + oidTerritorio);
                        UtilidadesLog.debug("****JAS**** clienteDatosBasicosLocal.getOid() " + clienteDatosBasicosLocal.getOid());
                        UtilidadesLog.debug("****JAS**** dto " + dto.getIpCliente() + ", " + dto.getPrograma());
            
                        Long marca = new Long(rMarcasCanales.getValueAt(i,0).toString());
                        Long canal = new Long(rMarcasCanales.getValueAt(i,1).toString());
            
                        //metodo definido en la interface ZON/IServiceUnidadesAdministrativas
                        //implementado en MONUnidadesAdministrativas que despues llama a MONClientes
                        mua.actualizarUnidadesAdmMAE(marca, paisLocal.getOid(),canal,oidTerritorio,clienteDatosBasicosLocal.getOid(),dto,indicadorDirePrincipal);
                    }
          
                }
                else    {   //msgError != null
          
                    UtilidadesLog.debug("****JAS**** entro por msgError != null");
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, msgError);
                    gi.registrarError(dtoError);
                }
        
                UtilidadesLog.debug("****JAS**** a la salida de msgError");
        
                //Sigo despues del IF
                //Recuperar datos de Parámetros Estados Georreferenciador
                controlInterfaceGeo = (String) registro.obtenerCampo(IRegistroSicc.GEO1_CONTROL_INTERFACE_GEORREFERENCIADOR);
        
                //Hacer un findByCodigo en la entidad ParametrosEstadosGeorreferenciador pasándole
                //por parámetro el campo controlInterfaceGeo y el resultado obtenido asignarlo a 'entityParametrosEstadosGeo'
                //dt informa que esta 'entidad' mapea contra int_param_estad_geore
                RecordSet resultadoValorSICC = dao.obtenerValorSICC(controlInterfaceGeo);
        
                String  valorSICC=null;
        
                if (resultadoValorSICC==null | resultadoValorSICC.esVacio()){
                    valorSICC = "N";
                }else{
                    UtilidadesLog.debug("****JAS**** resultadoValorSICC.getValueAt(0,0).toString() es: " +resultadoValorSICC.getValueAt(0,0).toString());
                    valorSICC = (String) resultadoValorSICC.getValueAt(0,0);
                }
        
                UtilidadesLog.debug("****JAS**** valorSICC asignado: " +valorSICC);
        
                //Se hace otra vez un find en ClienteDireccion porque pudo no haberse hecho con exito anteriormente
                //Hacer un findByClienteyTipo en la entidad ClienteDireccion pasándole como parámetros los campos
                //entityCliente.oid y entityTipoDireccion.oid, y asignar el resultado a 'entityDireccion'
        
                try {
                    UtilidadesLog.debug("****JAS**** clienteDireccionLocalHome.findByClienteYTipo(oidCliente: "+clienteDatosBasicosLocal.getOid()+",oidTipoDireccionRecuperado: "+oidTipoDireccionRecuperado+")");
                    Collection resultadoClienteDireccion = clienteDireccionLocalHome.findByClienteYTipo(clienteDatosBasicosLocal.getOid(),new Long(oidTipoDireccionRecuperado));
          
                    Iterator itResultadoClienteDireccion = resultadoClienteDireccion.iterator();
                    while (itResultadoClienteDireccion.hasNext())   {
                        clienteDireccionLocal = (ClienteDireccionLocal)itResultadoClienteDireccion.next();
              
                        if (clienteDireccionLocal.getInd_elim()==null || clienteDireccionLocal.getInd_elim().longValue()!=1){
                            UtilidadesLog.debug("****JAS****ConstantesINT.VALOR_SICC_N = " + ConstantesINT.VALOR_SICC_N);
                            UtilidadesLog.debug("****JAS****ConstantesINT.VALOR_SICC_S = " + ConstantesINT.VALOR_SICC_S);
                            if (valorSICC == ConstantesINT.VALOR_SICC_S | valorSICC.equals(ConstantesINT.VALOR_SICC_S) ){
                                UtilidadesLog.debug("****JAS**** entro por valorSICC == ConstantesINT.VALOR_SICC_S");
                                clienteDireccionLocal.setInd_ctrl_inte_geor(new Character(valorSICC.charAt(0)));
                                clienteDireccionLocal.setVal_nomb_fich(interfaz.getNumeroLote());
                                clienteDireccionLocalHome.merge(clienteDireccionLocal);
                            }else{
                                if (valorSICC == ConstantesINT.VALOR_SICC_N | valorSICC.equals(ConstantesINT.VALOR_SICC_N)){
                                    UtilidadesLog.debug("****JAS**** entro por valorSICC == ConstantesINT.VALOR_SICC_N");
                                    clienteDireccionLocal.setInd_ctrl_inte_geor(new Character(valorSICC.charAt(0)));
                                    DTOINTError dtoError = new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0103);
                                    gi.registrarError(dtoError);
                                }
                            }
                        }
                    }
                }catch (NoResultException ex){
                    UtilidadesLog.error("*** Error finder en actualizarDireccion de MONINTGEO",ex);
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }
            //cierro while
            //gi.cerrarInterfaz(interfaz);
      
        }catch (InterfacesException ie) {
            UtilidadesLog.error("MONINTGEO.recepcionarEstandarizacionDirecciones(DTOOID pais) " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);
            throw new MareException(ie.getMotivo(), ie);
        }catch (RemoteException re) {
            UtilidadesLog.error("*** Error MONGEOINT.enviarEstandarizaciónDeDirecciones(DTOOID DTOE)", re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }catch (Exception ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //  Agregado por HRCS - Incidencia SiCC20080604
        finally {
            try {
                UtilidadesLog.debug("*** Cerrando Interfaz en finally.");
                gi.cerrarInterfaz(interfaz);
            } catch(Exception e) {
                UtilidadesLog.error("Error cerrando interfaz: " + e.getMessage(), e);
            }
        }
    
        Cronometrador.endTransaction("MONINTGEOBean.recepcionarEstandarizacionDirecciones");    
        UtilidadesLog.info("MONINTGEOBean.recepcionarEstandarizacionDirecciones(DTOOID pais): Salida");
        return new DTOSalidaBatch(0, "recepEstandarizacionDirec finalizado");
    }
  
  
  public String comprobarExistenciaCodigos (String codTipoVia, String codNSE, Integer codTerritorio, Long codPais) throws MareException{
  
    UtilidadesLog.info("MONINTGEOBean.comprobarExistenciaCodigos(....): Entrada");
    //Gacevedo MAE-04 (Tengamos en cuenta que este método jamás va a funcionar
    //si no lo escribimos correctamente
    String error = null;
    
  
      TipoViaLocalHome tipoViaLocalHome = null;
      TipoViaLocal tipoViaLocal = null;
      tipoViaLocalHome = this.getTipoViaLocalHome();
      
      NivelSocioeconomicoBelcorpLocalHome nseLocalHome = null;
      NivelSocioeconomicoBelcorpLocal nseLocal = null;
      nseLocalHome = this.getNivelSocioeconomicoBelcorpLocalHome();
      
      TerritorioLocalHome territorioLocalHome = null;
      TerritorioLocal territorioLocal = null;
      territorioLocalHome = this.getTerritorioLocalHome();
      
      
      //Comprobar que el campo código Tipo de vía exista en la entidad 'Tipos de via'
      //if (codTipoVia != null & codTipoVia != ""){
      if (codTipoVia != null && !codTipoVia.trim().equals("")){
        try{
          UtilidadesLog.debug("****JAS**** tipoViaLocalHome.findByUK("+codTipoVia+")");
          tipoViaLocal = tipoViaLocalHome.findByUK(codTipoVia);
          UtilidadesLog.debug("****JAS**** despues del find");
        }catch(NoResultException f){
          UtilidadesLog.error("*** Error finder en comprobarExistenciaCodigos(..) de MONINTGEO - 1",f);
          error = ErroresDeNegocio.INT_0100 + codTipoVia;  
          return error;
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      }
      
      //Comprobar que el campo codigo nivel socioeconomico exista en la entidad 'NivelSocioeconomicoBelcorp'
      //if (codNSE != null & codNSE != ""){
      if (codNSE != null && !codNSE.trim().equals("")){
        try{
          UtilidadesLog.debug("****JAS**** nseLocalHome.findByUK("+codNSE+")");
          nseLocal = nseLocalHome.findByUK(codNSE);
          UtilidadesLog.debug("****JAS**** despues del find");
          UtilidadesLog.debug("****JAS**** nse recuperado: " + nseLocal.getOid());
          
        }catch(NoResultException f){
          UtilidadesLog.error("*** Error finder en comprobarExistenciaCodigos(..) de MONINTGEO - 2",f);
          error = ErroresDeNegocio.INT_0101 + codNSE;
          return error;
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      }
      
      //Comprobar que el campo codigo territorio exista en la entidad 'Territorio'
      if (codTerritorio != null){
        try{
          UtilidadesLog.debug("****JAS**** territorioLocalHome.findByCodigoPais(territorio: " +codTerritorio + ",pais: " + codPais +")" );
          Collection resultado = territorioLocalHome.findByCodigoPais(new Long(codTerritorio.toString()),codPais);
          UtilidadesLog.debug("****JAS**** despues del find");
          
          Iterator iterator = resultado.iterator();
          if (iterator.hasNext()){
            territorioLocal = (TerritorioLocal) iterator.next();
            UtilidadesLog.debug("****JAS**** oidTerritorio recuperado: " + territorioLocal.getOid());
            oidTerritorio =territorioLocal.getOid();
          }else{
            throw new NoResultException();
          }
        }catch(NoResultException f){
          UtilidadesLog.error("*** Error finder en comprobarExistenciaCodigos(..) de MONINTGEO - 3",f);
          error = ErroresDeNegocio.INT_0102 + codTerritorio;
          return error;
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      }
      
      UtilidadesLog.info("MONINTGEOBean.comprobarExistenciaCodigos(....): Salida");
      
      return error;//null
           

  }
  
  private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
    
    //Se obtiene el interfaz home
    UtilidadesLog.info("MONINTGEOBean.getMONGestorInterfaces(): Entrada");
    MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
        
    //Se obtiene el interfaz remoto
    MONGestorInterfaces ejb = null;
    try{
        ejb = home.create();
    }catch (Exception e) {
        UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONINTGEOBean.getMONGestorInterfaces(): Salida");
    return ejb;
	
  }
  
  private MONUnidadesAdministrativas getMONUnidadesAdministrativas() throws MareException {
    
    // Se obtiene el interfaz home
    UtilidadesLog.info("MONINTGEOBean.getMONUnidadesAdministrativas(): Entrada");
    MONUnidadesAdministrativasHome home = (MONUnidadesAdministrativasHome)UtilidadesEJB.getHome("MONUnidadesAdministrativas", MONUnidadesAdministrativasHome.class);
    
    // Se obtiene el interfaz remoto
    MONUnidadesAdministrativas ejb = null;
    try{
      ejb = home.create();
    }catch (Exception e) {
      UtilidadesLog.error("*** Error en getMONUnidadesAdministrativas",e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    UtilidadesLog.info("MONINTGEOBean.getMONUnidadesAdministrativas(): Salida");
    return ejb;
	
  }
  
  private String rellenarEspacios(String cadena,int longitudDeseada, int longitudActual,int tipoDato){
  
    int caracteresFaltantes = longitudDeseada - longitudActual;
    
    for(int i=0;i<caracteresFaltantes;i++){
      
        if (tipoDato==0){
            cadena = " " + cadena;
        }else{
            if (tipoDato==1){
                cadena = "0" + cadena;
            }
        }
    
    }
    
    return cadena;
  
  }
  
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    private ClienteDireccionLocalHome getClienteDireccionLocalHome() {
            return new ClienteDireccionLocalHome();
    }

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
            return new ClienteDatosBasicosLocalHome();
    }

    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome() {
            return new ClienteDatosAdicionalesLocalHome();
    }

    private TipoViaLocalHome getTipoViaLocalHome() {
            return new TipoViaLocalHome();
    }

    private NivelSocioeconomicoBelcorpLocalHome getNivelSocioeconomicoBelcorpLocalHome() {
            return new NivelSocioeconomicoBelcorpLocalHome();
    }

    private TerritorioLocalHome getTerritorioLocalHome() {
            return new TerritorioLocalHome();
    }

  


}
