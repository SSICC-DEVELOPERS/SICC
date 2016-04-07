/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.men;

//MARE
import es.indra.mare.common.exception.MareException;
//import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
//import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
//import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.dtos.men.DTOCargaFavoritos;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.dtos.men.DTOEntradaSeleccionarFuncionesFavoritas;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.dtos.men.DTOFavoritos;
import es.indra.sicc.entidades.men.FavoritosLocal;
import es.indra.sicc.entidades.men.FavoritosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

//import org.apache.commons.logging.Log;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
/**
 * Sistema:       Belcorp
 * Modulo:        MEN
 * Componente:    MONFuncionesFavoritas - Clase Bean
 * Fecha:         01/04/2003
 * Observaciones:
 * Este componente realiza las inserciones y consulta de la entidad Funciones 
 * Favoritas.
 * 
 * @version       1.x
 * @author        Walter Villafañe
 */

public class MONFuncionesFavoritasBean implements SessionBean  {
  
    private SessionContext ctx;

   // private BelcorpService belcorpService;

    public void ejbCreate() throws CreateException {

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


    // BEGIN Proceso de insertar
    public void insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF) throws MareException	{
        UtilidadesLog.info("MONFuncionesFavoritasBean.insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF): Entrada");
            
        FavoritosLocalHome entHome = null;


        //***************** Validaciones *****************
        if( dtoESFF  == null ) {
            UtilidadesLog.info("MONFuncionesFavoritasBean.insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF): Salida");
            throw new MareException( CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO );
        }		

        validarUsuario( dtoESFF.getIdUsuario() );

        validarFunciones( dtoESFF.getIdFuncionMarcadas() );

        //***************** Validaciones *****************
        
        //BEGIN busco los favoritos del usuario
        try {

                entHome = getFavoritosLocalHome();
                
        } catch(Exception e) {
            throw new MareException(e,
            UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }

        Iterator itRemove = null;
        try {			

                itRemove = entHome.findByUsuario(dtoESFF.getIdUsuario()).iterator();

                while (itRemove.hasNext()) {
                        FavoritosLocal favorLocal = (FavoritosLocal) itRemove.next();			
                        entHome.remove(favorLocal);
                }
                
        } catch(NoResultException nre) {
        
                throw new MareException(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS, nre);
                
        } catch(PersistenceException pex) {
        
                ctx.setRollbackOnly();
                throw new MareException(CodigosError.ERROR_DE_BORRADO_DE_DATOS, pex);
                
        }
        //END Borro los favoritos de ese usuario		
        
        //BEGIN Inserto los favoritos de ese usuario

        Iterator itInsertar = dtoESFF.getIdFuncionMarcadas().iterator();

        try{

                while (itInsertar.hasNext()) {

                        Long lngIdFuncion = Long.valueOf( itInsertar.next().toString() );

                        entHome.create( lngIdFuncion , dtoESFF.getIdUsuario() );

                }						
        } catch(PersistenceException pex) {
        
                ctx.setRollbackOnly();
                throw new MareException(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS, pex);
                
        }
        //END Inserto los favoritos de ese usuario		

        UtilidadesLog.info("MONFuncionesFavoritasBean.insertaFavorito(DTOEntradaSeleccionarFuncionesFavoritas dtoESFF): Salida");
    }
    
    private void validarFunciones(List lstFunciones ) throws MareException {  
        UtilidadesLog.info("MONFuncionesFavoritasBean.validarFunciones(List lstFunciones ): Entrada");

        if ( lstFunciones == null ) {
                UtilidadesLog.info("MONFuncionesFavoritasBean.validarFunciones(List lstFunciones ): Salida");
                throw new MareException( CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO );
        }

        Iterator it = lstFunciones.iterator();

        while ( it.hasNext() ){
                if ( ! esStringValido( it.next().toString() ) ) {
                        UtilidadesLog.info("MONFuncionesFavoritasBean.validarFunciones(List lstFunciones ): Salida");
                        throw new MareException( CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO );
                }
        }

        UtilidadesLog.info("MONFuncionesFavoritasBean.validarFunciones(List lstFunciones ): Salida");
    }
    // END Proceso de insertar

    private void validarUsuario( String p_usuario ) throws MareException {
    UtilidadesLog.info("MONFuncionesFavoritasBean.validarUsuario( String p_usuario ): Entrada");

            if( p_usuario  == null || p_usuario.trim().equals( "" ) ){
                UtilidadesLog.info("MONFuncionesFavoritasBean.validarUsuario( String p_usuario ): Salida");
                throw new MareException( CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO );
            }

    UtilidadesLog.info("MONFuncionesFavoritasBean.validarUsuario( String p_usuario ): Salida");
    }
    
    public DTOSalida consultaFavorito(DTOEntradaObtieneFuncion dtoEOF) throws MareException {
        UtilidadesLog.info("MONFuncionesFavoritasBean.consultaFavorito(DTOEntradaObtieneFuncion dtoEOF): Entrada");

        RecordSet rsRetorno = null;
        String codigoError;
        FavoritosLocalHome entHome = null;
        DTOSalida dtoSalida = null;
        
        //***************** Validaciones *****************
        if( dtoEOF  == null ){
            UtilidadesLog.info("MONFuncionesFavoritasBean.consultaFavorito(DTOEntradaObtieneFuncion dtoEOF): Salida");
            throw new MareException( CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO );
        }		
        
        validarUsuario( dtoEOF.getIdUsuario() );
        //getLog();
        
        try {
                entHome = getFavoritosLocalHome();
                
        } catch(Exception e) {
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Iterator it = null;
        try{
                it = entHome.findByUsuario(dtoEOF.getIdUsuario()).iterator();
                
        } catch( NoResultException nre ) {
        
                throw new MareException(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS, nre);
                
        }
        
        dtoSalida = new DTOSalida();

        rsRetorno = new RecordSet();
        rsRetorno.addColumn("idFuncion");
        
 
        while ( it.hasNext() ){
                FavoritosLocal favorLocal = (FavoritosLocal) it.next();

                Object[] arrayObj = new Object[1];
                arrayObj[0] = favorLocal.getFunc_oid_func();

                rsRetorno.addRow( arrayObj );
        }

        dtoSalida.setResultado( rsRetorno );

        UtilidadesLog.info("MONFuncionesFavoritasBean.consultaFavorito(DTOEntradaObtieneFuncion dtoEOF): Salida");

        return dtoSalida;
            
    }


   private FavoritosLocalHome getFavoritosLocalHome() throws MareException {
        UtilidadesLog.info("MONFuncionesFavoritasBean.getFavoritosLocalHome(): Entrada");
        
        FavoritosLocalHome localHome = new FavoritosLocalHome();
      
        UtilidadesLog.info("MONFuncionesFavoritasBean.getFavoritosLocalHome(): Salida");
        return localHome;
    }	

    //Validaciones
    private boolean esStringValido(String pString) {
        UtilidadesLog.info("MONFuncionesFavoritasBean.esStringValido(String pString): Entrada");
        
        if( pString == null || pString.trim().toString().equals( "" ) ){
            UtilidadesLog.info("MONFuncionesFavoritasBean.esStringValido(String pString): Salida");
            return false;
        }		
        
        UtilidadesLog.info("MONFuncionesFavoritasBean.esStringValido(String pString): Salida");
        return true;
    }

    public DTOSalida obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe) throws MareException {
        UtilidadesLog.info("MONFuncionesFavoritasBean.obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe): Entrada");

        String codigoError;
        RecordSet recordSet=null;
        RecordSet recordSetTipoUsuario=null;
        
        String sIdUsuario="";
        String sTipoUsuario="";
        Long idIdioma;
        BelcorpService bs = null;


        /*
         * Validacion de Id de Usuario
         */
        if (dtoe.getIdUsuario()==null || 
            dtoe.getIdUsuario()=="") {
                UtilidadesLog.info("MONFuncionesFavoritasBean.obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe): Salida");
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(null, null, 
                        UtilidadesError.armarCodigoError(codigoError));
         } else sIdUsuario = dtoe.getIdUsuario();

        /*
         * Obtencion del idIdioma, sino se envia se toma como default el 1
         */
        if (dtoe.getIdIdioma()==null) {
            idIdioma = new Long(1);   
        } else idIdioma = dtoe.getIdIdioma();

        /*
         * Obtencion del tipo de Usuario
         */

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
            
        try {

                String sConsultaTipoUsuario = this.armaConsultaTipoUsuario(sIdUsuario);
                recordSetTipoUsuario = bs.dbService.executeStaticQuery
                        (sConsultaTipoUsuario);
        } catch (Exception e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        sTipoUsuario = (String)recordSetTipoUsuario.getRow(0).get(0);

        /*
         * Tipo de Usuario Batch
         */
        if (sTipoUsuario.equalsIgnoreCase("BATCH")) {
                RecordSet rsSalida=null;
                rsSalida = new RecordSet();
                rsSalida.addColumn("idfuncion");
                rsSalida.addColumn("nombrefuncion");
                rsSalida.addColumn("nombreprograma");
                rsSalida.addColumn("jerarquia");
                rsSalida.addColumn("nodofinal");
                rsSalida.addColumn("habilitado");

                /*
                 * Se retorna unicamente la raiz del menu
                 */
                rsSalida.addRow(new Object[] {
                                new String("F0001"), 
                                new String("Menu"),
                                new String(""),
                                new String("F0001"),
                                new String("0"),
                                new String("1")
                                });
                DTOSalida dtos = new DTOSalida();
                dtos.setResultado(rsSalida);
  
                UtilidadesLog.info("MONFuncionesFavoritasBean.obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe): Salida");
  
                return dtos;
        }

        /*
         * Tipo de Usuario Tercero o Interactivo
         */
        try {
                recordSet = bs.dbService.executeStaticQuery
                        (this.armaConsultaMenu(sTipoUsuario, sIdUsuario, idIdioma));
        } catch (Exception e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(recordSet);

        UtilidadesLog.info("MONFuncionesFavoritasBean.obtieneFavoritosUsuario(DTOEntradaObtieneFuncion dtoe): Salida");

        return dtos;  
    }

    private String armaConsultaTipoUsuario(String sIdUsuario) {
        UtilidadesLog.info("MONFuncionesFavoritasBean.armaConsultaTipoUsuario(String sIdUsuario): Entrada");
        
        String sConsulta="select pv.stringvalue as TipoUsuario " +
            "from principals pri, properties pro, propertyvalues pv " +
            "where pri.idprincipal = pv.idprincipal and " +
            "pro.idproperty = pv.idproperty and pri.name='"+ sIdUsuario +"' and pv.idproperty = 13 ";
        
        UtilidadesLog.info("MONFuncionesFavoritasBean.armaConsultaTipoUsuario(String sIdUsuario): Salida");
        
        return sConsulta;
    }

    private String armaConsultaMenu(String sTipoUsuario, 
                                String sIdUsuario,
                                Long idIdioma) {
        UtilidadesLog.info("MONFuncionesFavoritasBean.armaConsultaMenu(String sTipoUsuario, String sIdUsuario,Long idIdioma): Entrada");
        
        StringBuffer sConsulta= new StringBuffer();
        String sConsultaPerfil="select perfiles.name " +
            "from memberof m, principals p, " +
            "(SELECT p.idprincipal, p.name FROM principals p, principals p2, memberof m where p2.name = 'PerfilesSICC' and m.idmember = p2.idprincipal and m.idrole = p.idprincipal) perfiles " +
            "where m.idrole = perfiles.idprincipal and p.idprincipal = m.idmember and p.name = '"+ sIdUsuario +"' ";
            
		sConsulta.append(" SELECT OID_FUNC, nom_func, VAL_NOMB_PROG, FUNC_OID_FUNC, IND_NIVE,DECODE (NAME, NULL, 0, 1) AS habilitado, nivel ");
		sConsulta.append(" FROM (SELECT LEVEL - 1 AS nivel, OID_FUNC, nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC,SYS_CONNECT_BY_PATH (nom_func, '#') AS PATH ");
		sConsulta.append(" FROM (SELECT OID_FUNC, VAL_I18N as nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC ");
		sConsulta.append(" FROM men_funci, v_GEN_I18N_SICC where ATTR_ENTI = 'MEN_FUNCI' and ATTR_NUM_ATRI = 1 and IDIO_OID_IDIO = "+ idIdioma.toString() +" and VAL_OID = OID_FUNC) ");
		sConsulta.append(" CONNECT BY PRIOR OID_FUNC = FUNC_OID_FUNC ");
		sConsulta.append(" START WITH OID_FUNC = 1),(SELECT DISTINCT (SELECT NAME FROM principals WHERE idprincipal = idrole) AS NAME FROM memberof CONNECT BY PRIOR idrole = idmember START WITH idmember = (SELECT idprincipal FROM principals WHERE NAME = ("+ sConsultaPerfil +"))) ");
            
		//Nota: TERCERO solo ve lo que debe, INTERACTIVO retorna todo -> (+).
        if(sTipoUsuario.equalsIgnoreCase("TERCERO")) {
			//sConsulta.append("WHERE NAME = to_char(OID_FUNC) and nivel >= 4 ORDER BY PATH ");
			sConsulta.append("WHERE NAME = to_char(OID_FUNC) and ind_nive = 1 ORDER BY PATH ");
		} else if (sTipoUsuario.equalsIgnoreCase("INTERACTIVO")) {
            //sConsulta.append("WHERE NAME(+) = to_char(OID_FUNC)  and	 nivel >= 4 ORDER BY PATH ");
			sConsulta.append("WHERE NAME(+) = to_char(OID_FUNC)  and	 ind_nive = 1 ORDER BY PATH ");
        }
		
        UtilidadesLog.info("MONFuncionesFavoritasBean.armaConsultaMenu(String sTipoUsuario, String sIdUsuario,Long idIdioma): Salida");
        return sConsulta.toString();
    }

    public DTOCargaFavoritos consultaFavoritos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONFuncionesFavoritasBean.consultaFavoritos(DTOBelcorp dto): Entrada");

        String codigoError;
        DTOCargaFavoritos dtos = new DTOCargaFavoritos();
        DTOBoolean aux = new DTOBoolean();
        aux.setValor(true);
        aux.setOidIdioma(dto.getOidIdioma());
        aux.setOidPais(dto.getOidPais());		
        DAOMenu doamenu = new DAOMenu(ctx.getCallerPrincipal().getName());
        dtos.setFavoritos(doamenu.obtenerFavoritosUsuario(dto));

        MONFuncionesMenuHome monFuncionesMenu = null;
        try {
            monFuncionesMenu = (MONFuncionesMenuHome)BelcorpService.getInstance().ejbLocator.getHome("MONFuncionesMenu", MONFuncionesMenuHome.class);
    
        } catch(MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


         try {
                dtos.setArbol(monFuncionesMenu.create().obtenerMenuUsuario(aux));		
        } catch(RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch(CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
        UtilidadesLog.info("MONFuncionesFavoritasBean.consultaFavoritos(DTOBelcorp dto): Salida");        

        return dtos;
    }

    public DTOString insertaFavoritos(DTOFavoritos dto) throws MareException {
        UtilidadesLog.info("MONFuncionesFavoritasBean.insertaFavoritos(DTOFavoritos dto): Entrada");
    
        String codigoError;
        FavoritosLocalHome entHome = null;
        String usuario = ctx.getCallerPrincipal().getName();
        Set setFavoritos = new HashSet(); 

        Long[] favoritos = dto.getFavoritos();
        for (int i = 0; i < favoritos.length; i++) {
                setFavoritos.add(favoritos[i]);
        }
    
                //Quitamos los elementos que ha eliminado 
        try {
                entHome = getFavoritosLocalHome();                
        } catch(Exception e) {
                UtilidadesLog.error(e);		
                ctx.setRollbackOnly();			
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
   
        Iterator it = null;
        try {
                it = entHome.findByUsuario( usuario ).iterator();
    
                while (it.hasNext()) {
                        FavoritosLocal favoritoLocal = (FavoritosLocal)it.next();
                        if (setFavoritos.contains(favoritoLocal.getFunc_oid_func())) { 
                                setFavoritos.remove(favoritoLocal.getFunc_oid_func()); //El elemento permanece como favorito 
                        } else { 
                                entHome.remove(favoritoLocal); //Eliminamos el entity porque ya no está en los favoritos del usuario 
                        } 
                }
    
                //Añadimos los elementos nuevos 
                Iterator it2 = setFavoritos.iterator();
                while (it2.hasNext()) {
                        Long oid = (Long)it2.next();                        
                        entHome.create(oid, usuario);
                }

        } catch( NoResultException e ) {
            UtilidadesLog.error(e);		
            ctx.setRollbackOnly();			
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch( PersistenceException e ){
            UtilidadesLog.error(e);		
            ctx.setRollbackOnly();			
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info("MONFuncionesFavoritasBean.insertaFavoritos(DTOFavoritos dto): Salida");

        return null;
    }
	
}