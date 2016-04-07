package es.indra.sicc.logicanegocio.seg;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.dtos.seg.AyudaDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.zon.DTOUsuario;

import es.indra.sicc.logicanegocio.men.IMenu;

import java.util.Collection;
import java.util.Iterator;

import es.indra.sicc.logicanegocio.men.MONFuncionesMenuHome;
import es.indra.sicc.logicanegocio.men.MONFuncionesMenu;
import es.indra.sicc.entidades.seg.AyudaLocal;
import es.indra.sicc.entidades.seg.AyudaLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.CMNEjbLocators;

import java.rmi.RemoteException;
import javax.ejb.CreateException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONConfiguracionAyudaBean implements SessionBean, IMenu {
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

    public AyudaDTO recuperaAyuda(AyudaDTO ayudaDTO) throws MareException {
        UtilidadesLog.info("MONConfiguracionAyuda.recuperaAyuda(AyudaDTO):Entrada");
        Long oidFuncion = ayudaDTO.getOidFuncion();
        UtilidadesLog.debug("Obtuve OidFuncion: " + oidFuncion);
        Long oidIdioma = ayudaDTO.getOidIdioma();
        AyudaLocalHome ayudaLocalHome = null;
        Entidadi18nLocalHome entidadInterLocalHome = null;    
        Entidadi18nLocal entidadInterLocal = null;
        Collection col = null;

        UtilidadesLog.debug("Obtiene la LocalHome");
        ayudaLocalHome = new AyudaLocalHome();
    
        try {
            UtilidadesLog.debug("Llama al finder oidFuncion:" + oidFuncion);
            col = ayudaLocalHome.findOidFunc(oidFuncion); 
        } catch (PersistenceException pex) {
            // Se podria crear en el momento si no existe, para luego devolver
            // aquí mismo un DTO en blanco.
            UtilidadesLog.error("Error en el Finder: ", pex);
            ctx.setRollbackOnly();
            String error = (pex instanceof NoResultException)?
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE :
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pex, UtilidadesError.armarCodigoError(error) );
        }
        // Al no hacer un findByPrimaryKey, no tira el NoResultException por lo que la 
        // Collection puede estar vacía. 
        if (col.isEmpty()) {
            // No encontró registro en SEG_AYUDA que coincida con el codigo de funcion
            // de entrada en ayudaDTO. 
            UtilidadesLog.debug("No hay tupla con esa funcion");      
            // Setea los campos a devolver. Excepto oid, los demás se setean en vacio.
            ayudaDTO.setTextoAyuda("");  // Vacio.
            //SCS, no mas field.... ayudaDTO.setUbicacionFicheroAyuda(""); // Vacio.
            ayudaDTO.setOidFuncion(oidFuncion); // Oid de funcion segun entrada.
            UtilidadesLog.info("MONConfiguracionAyuda.recuperaAyuda(AyudaDTO):Salida");
            return ayudaDTO;
        }
        UtilidadesLog.debug("Se ha encontrado una tupla con esa funcion");    
        Iterator it = col.iterator();

        UtilidadesLog.debug("iterador SCS");  
       
        AyudaLocal ayudaLocal = (AyudaLocal) it.next();

        UtilidadesLog.debug("next SCS");

        // Obtiene los datos que se necesitan del Entity.
        Long oidAyuda = ayudaLocal.getOid();

        UtilidadesLog.debug("post getter");
        
        UtilidadesLog.debug("oidAyuda de Entity: " + oidAyuda.toString() );    
        oidFuncion = ayudaLocal.getOidFunc();
        UtilidadesLog.debug("oidFuncion de Entity: " + oidFuncion.toString() );
        //SCS, no mas field.... String sUbicacionFichero = ayudaLocal.getUbicacionFichero();
        //SCS, no mas field.... System.out.println("sUbicacionFichero de Entity: " + sUbicacionFichero );

        // Obtiene el texto de Ayuda internacionalizado
        UtilidadesLog.debug("Obtiene la LocalHome del Entity Inter");
        entidadInterLocalHome = new Entidadi18nLocalHome();

        try {
            entidadInterLocal = entidadInterLocalHome.findByEntAtrIdioPK("SEG_AYUDA", new Long(1), oidIdioma, oidFuncion);      
        } catch (NoResultException nre) {
             //si pincho, se hace la busqueda por idioma por defecto
             UtilidadesLog.debug("Se hace la busqueda por idioma por defecto");
             try  {
             	entidadInterLocal = entidadInterLocalHome.findByEntAtrIdioPK("SEG_AYUDA", new Long(1), new Long(1), oidFuncion);      
             } catch (PersistenceException e)  {
                UtilidadesLog.error("Error al buscar por idioma por defecto: ", e);
                ctx.setRollbackOnly();
                String error = (e instanceof NoResultException)?
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE :
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
             	throw new MareException(e, UtilidadesError.armarCodigoError(error) );
             } 
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        }

        String sTextoAyuda = entidadInterLocal.getDetalle();
        UtilidadesLog.debug("Obtuvo la LocalHome del Entity Inter");
        UtilidadesLog.debug("sTextoAyuda: " + sTextoAyuda);
        //String sTextoAyuda = "Prueba de Texto de Ayuda para la funcion " + oidFuncion.toString();

        // Setea el DTO que devolverá los datos a la pantalla. 
        ayudaDTO.setOidAyuda(oidAyuda);
        ayudaDTO.setOidFuncion(oidFuncion);
        //SCS, no mas field.... ayudaDTO.setUbicacionFicheroAyuda(sUbicacionFichero);
        ayudaDTO.setTextoAyuda(sTextoAyuda);
    
        UtilidadesLog.debug("DTOAyuda a retornar: " + ayudaDTO.toString() );
        UtilidadesLog.info("MONConfiguracionAyuda.recuperaAyuda(AyudaDTO):Salida");
        return ayudaDTO;
    }


    public void modificarAyuda(AyudaDTO ayudaDTO) throws MareException {
        UtilidadesLog.info("MONConfiguracionAyuda.modificarAyuda(AyudaDTO):Entrada");
        Collection col = null;
        //SCS, no mas field.... String sUbicacionFichero = ayudaDTO.getUbicacionFicheroAyuda();
        Long oidFuncion = ayudaDTO.getOidFuncion();
        UtilidadesLog.debug("AyudaDTO: " + ayudaDTO);
      
        AyudaLocalHome ayudaLocalHome = new AyudaLocalHome();
        try {
            col = ayudaLocalHome.findOidFunc(oidFuncion);        
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        AyudaLocal ayudaLocal = null;
        if ( col.isEmpty() ) {
            UtilidadesLog.debug("La Colleccion de funciones esta vacia.");
            // No hay tuplas, por lo que crea un nuevo registro en SEG_AYUDA
            try {
                ayudaLocal = ayudaLocalHome.create( oidFuncion );  
            } catch (PersistenceException ex) {
                ctx.setRollbackOnly();
                throw new MareException(ex,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS) );         
            }
            //SCS, no mas field.... ayudaLocal.setUbicacionFichero(sUbicacionFichero);
        } else {
            UtilidadesLog.debug("Coleccion de funciones Size: " + col.size() );
            ayudaLocal = (AyudaLocal) col.iterator().next();
            //SCS, no mas field.... ayudaLocal.setUbicacionFichero(sUbicacionFichero);
        }
      
        /**  Actualiza o crea las tuplas en la entidad I18N. */
        UtilidadesLog.debug("Actualizar I18N.");
        Entidadi18nLocalHome i18nLocalHome = new Entidadi18nLocalHome();

        UtilidadesLog.debug("Traducciones: " + ayudaDTO.getVectorTraducciones() );
        //por cada traduccion
        Iterator iterAyuda = ayudaDTO.getVectorTraducciones().iterator();
        while (iterAyuda.hasNext()) {
            DTOI18nSICC dtoTraduccion = (DTOI18nSICC) iterAyuda.next();
            Long oidIdioma = dtoTraduccion.getOidIdioma();
            Long oidAtributo = dtoTraduccion.getOidAtriuto();
            String valorI18n = dtoTraduccion.getValorI18n();
            try {
                Entidadi18nLocal i18nLocal = i18nLocalHome.findByEntAtrIdioPK("SEG_AYUDA", oidAtributo, oidIdioma, oidFuncion);
                i18nLocal.setDetalle(valorI18n);
                i18nLocalHome.merge(i18nLocal);
                UtilidadesLog.debug("Modifica traduccion para este idioma.");
            } catch (NoResultException nre) {
                UtilidadesLog.debug("Inserta traduccion para este idioma.");
                // No hay tuplas, por lo que crea un nuevo registro en i18n
                try {
                    i18nLocalHome.create("SEG_AYUDA", new Long(1), oidIdioma, valorI18n, oidFuncion);                
                } catch (PersistenceException ex) {
                    ctx.setRollbackOnly();
                    throw new MareException(ex,      
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS) );         
                }
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONConfiguracionAyuda.modificarAyuda(AyudaDTO):Salida");
    }


    public DTOSalida obtenerFunciones(DTOUsuario perfiles) throws MareException {
        UtilidadesLog.info("MONConfiguracionAyuda.obtenerFunciones(DTOUsuario):Entrada");
        String usuario = perfiles.getIdUsuario();
        Long idIdioma = perfiles.getOidIdioma();

        // Obtiene el RecordSet con las funciones del usuario.
        RecordSet r = obtenerFuncionesI(usuario,idIdioma);
        
        // Setea ese recordset en el ArrayList;
        //listFunciones.add(r);
        //  Setea el ArrayList en el dto.

        DTOSalida dto = new DTOSalida();
        dto.setResultado(r);
        
        //dto.setListaFunciones(listFunciones);
        UtilidadesLog.info("MONConfiguracionAyuda.obtenerFunciones(DTOUsuario):Salida");
        return dto;
    }


    // Método de interfaz IMenu.
    public RecordSet obtenerFuncionesI(String usuario, Long idIdioma) throws MareException {
        UtilidadesLog.info("MONConfiguracionAyuda.obtenerFuncionesI(String , Long):Entrada");
        RecordSet r = null;
        UtilidadesLog.debug("Usuario: " + usuario);
        UtilidadesLog.debug("idIdioma: " + idIdioma);
        MONFuncionesMenuHome menuH = getMONFuncionesMenuHome();
        UtilidadesLog.debug("Luego de método obtenerHome");
    
        try {
            MONFuncionesMenu MONMenu = menuH.create();   
            r = MONMenu.obtieneFuncionesConfigurarAyuda(usuario,idIdioma);
        } catch (RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug("Funciones retornadas: " + r.getRowCount());
        UtilidadesLog.info("MONConfiguracionAyuda.obtenerFuncionesI(String , Long):Salida");
        return r;
    }


    private MONFuncionesMenuHome getMONFuncionesMenuHome() throws MareException {
        MONFuncionesMenuHome localHome = null;
        BelcorpService service = null;
        String codigoError = "";

        try   {
            service = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONFuncionesMenuHome)service.ejbLocator.getHome("MONFuncionesMenu", MONFuncionesMenuHome.class);
        } catch(MareServiceException e) {
            //ctx.setRollbackOnly();
           codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
           throw new MareException(e.getLocalizedMessage(), UtilidadesError.armarCodigoError(codigoError));
        }
        return localHome;
    }

    private AyudaLocalHome getAyudaLocalHome() {
        return new AyudaLocalHome();
    }
    
    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }
}
