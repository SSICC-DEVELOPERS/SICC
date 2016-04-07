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
 *
 */

package es.indra.sicc.cmn.presentacion.i18n;


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import java.util.ArrayList;
import java.math.BigDecimal;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;

/**
 * Sistema:           Belcorp
 * Modulo:            CMN - Requisitos Generales
 * Componente:        Clase I18n
 * Fecha:             05/12/2003
 * Observaciones:     Basado en Modelo de Componentes SICC-DMCO-GEN-201-310
 * Descripcion:       Clase implementada siguiendo el patron de diseño Singleton  
 * 
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 
public class I18n {

    private BelcorpService belcorpService;
    private int errorCode;

    private static I18n instance = null;
    private static ArrayList idiomas = null;

    private I18n() {
        super();
    }

    public static I18n getInstance() {
        if (instance == null) {
            instance = new I18n();
        }
        return instance;         
    }

    /*
     * Devuelve un Collection con objetos Idioma Pej: 
     * [[1, Español], [2, Francés], [3, Portugués]] 
     * Para los idiomas definidos en el sistema.
     * Estos idiomas los cachea en un atributos "static" de la clase,
     * y los obtiene invocando el método recuperaIdiomas() del MON MONMantenimientoSEG mediante un motor plano.
     * En el método recuperaIdiomas mete un DTOBelcorp con el idioma seteado al por defecto (OID=1). 
     */
    /**
     * Deprecated. Este metodo se implemeto en LPSICCBase, segun incidencia 528.
     */
    public ArrayList getIdiomas() throws MareException {
        try {
            //si no tenemos los idiomas, los obtengo por unica vez
            if (idiomas == null) {
                idiomas = this.recuperarIdiomas();
            }
            return idiomas;
        } catch (Exception e) {
            errorCode = UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE );
            throw new MareException(new Exception(), errorCode);
        } 
    }


    private ArrayList recuperarIdiomas() throws MareException {
        DTOBelcorp dtoEntrada = null;
        DTOSalida dtoSalida = null;
        RecordSet rsIdiomas = null;
        MONMantenimientoSEG monMantenimientoSEG = null;
        ArrayList idiomas = null;
        try {
            //Creamos una instancia
            monMantenimientoSEG = getMONMantenimientoSEGHome().create();
            //Invocamos el metodo para obtener un nuevo numero de posicion
            dtoEntrada = new DTOBelcorp();
            dtoEntrada.setOidIdioma(new Long(1));   //segun diseño
            dtoSalida = monMantenimientoSEG.recuperarIdiomas(dtoEntrada);


            //pasamos los idiomas del recordSet a un ArrayList
            rsIdiomas = (RecordSet)dtoSalida.getResultado();
            idiomas = new ArrayList();
            for(int pos=0; pos < rsIdiomas.getRowCount(); pos++) {
                //creamos un idioma por cada regsitro del resultSet
                Idioma idioma = new Idioma();
                idioma.setOid( new Long(((BigDecimal)rsIdiomas.getValueAt(pos,0)).longValue()) ); // de GEN_I18N_SICC el campo val_oid
                idioma.setDescripcion( (String)rsIdiomas.getValueAt(pos,1) ); // de GEN_I18N_SICC el campo val_i18n 
                //idioma.setCodigo();
                idiomas.add(idioma);
            }
        } catch (Exception e) {
            errorCode = UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE );
            throw new MareException(new Exception(), errorCode);
        } 
        return idiomas;
    }


    // Se obtiene el MONMantenimientoSolicitud java:comp/env/
    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws MareException {
        MONMantenimientoSEGHome home = null;
        BelcorpService bs = null;
        
        try {
              bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            home = (MONMantenimientoSEGHome) bs.ejbLocator.getHome(
                   "MONMantenimientoSEG", MONMantenimientoSEGHome.class);
        } catch (MareServiceException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB ) );
        }
        return home;                                        
    }
    
}