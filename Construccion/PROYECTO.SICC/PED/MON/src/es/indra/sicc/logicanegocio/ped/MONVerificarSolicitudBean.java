package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitudVerificacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import java.util.ArrayList;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import java.rmi.RemoteException;
import es.indra.sicc.util.UtilidadesEJB;
import javax.ejb.CreateException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.dtos.ped.DTOObtenerPosicionesVerificacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Vector;
import java.util.StringTokenizer;



public class MONVerificarSolicitudBean implements SessionBean  {
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
    
    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       28/12/2004
    * @version     3.3
    * @autor       Maximiliano Dello Russo (grusso)
    * Descripcion: Busca solicitudes para realizar la correspondiente verificación 
    * @param  DTOBuscarSolicitudVerificacion
    * @return DTOSalida
    * @throws es.indra.mare.common.exception.MareException
    */
    public DTOSalida buscarSolicitud(DTOBuscarSolicitudVerificacion dtoe) throws MareException {
        UtilidadesLog.info("MONVerificarSolicitudBean.buscarSolicitud(DTOBuscarSolicitudVerificacion dtoe): Entrada ");
        // Crea un DTOSalida con: 
        DTOSalida dtoSalida = new DTOSalida();
        // - resultado = DAOSolicitud.buscarSolicitudVerificacion(DTOE) 
        DAOSolicitud dao = new DAOSolicitud();
        dtoSalida.setResultado(dao.buscarSolicitudVerificacion(dtoe));        
        // Devuelve DTOSalida 
        UtilidadesLog.info("MONVerificarSolicitudBean.buscarSolicitud(DTOBuscarSolicitudVerificacion dtoe): Salida ");
        return dtoSalida;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       28/12/2004
    * @version     3.3
    * @autor       Maximiliano Dello Russo (grusso)
    * Descripcion  Actualiza una solicitud recibida con las posiciones recibidas 
    * @param  DTOCabeceraSolicitud
    * @return void
    * @throws es.indra.mare.common.exception.MareException
    */
    public void consolidarPosiciones(DTOCabeceraSolicitud dtoe) throws MareException {
        UtilidadesLog.info("MONVerificarSolicitudBean.consolidarPosiciones(DTOCabeceraSolicitud dtoe): Entrada ");
        try{
            // Obtenemos las posiciones 
            // posicionesSolicitud = DTOE.posiciones 
            ArrayList posicionesSolicitud = dtoe.getPosiciones();
            
            // Recorremos las posiciones de la solicitud utilizando el contador posicion 
            for( int posicion=0; posicion < posicionesSolicitud.size(); posicion++){
                // DTOE = Llamar al método consolidarPosicion(DTOE, posicion) 
                dtoe = consolidarPosicion(dtoe, posicion);
            }

        }catch(CreateException ce){
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException re){
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONVerificarSolicitudBean.consolidarPosiciones(DTOCabeceraSolicitud dtoe): Salida ");
    }


    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       28/12/2004
    * @version     3.3
    * @autor       Maximiliano Dello Russo (grusso)
    * Descripcion: Actualiza, inserta o elimina una posición de la solicitud recibida en función del estado 
    * @param  DTOCabeceraSolicitud dtoCabeceraSolicitud, int posicion
    * @return DTOCabeceraSolicitud
    * @throws es.indra.mare.common.exception.MareException
    */
    private DTOCabeceraSolicitud consolidarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, int posicion) 
        throws MareException, RemoteException, CreateException{
        
        UtilidadesLog.info("MONVerificarSolicitudBean.consolidarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, int posicion): Entrada ");
        // -- Obtiene la posición:
        // DTOPosicionSolicitud = DTOCabeceraSolicitud.posiciones.get(posicion) 
        DTOPosicionSolicitud dtoPosicionSolicitud = (DTOPosicionSolicitud)(dtoCabeceraSolicitud.getPosiciones().get(posicion));
                
        // oidPosicion = DTOPosicionSolicitud.oidPosicionSolicitud 
        Long oidPosicion = dtoPosicionSolicitud.getOidPosicionSolicitud();
        // codigoVenta = DTOPosicionSolicitud.codigoVenta 
        String codigoVenta = dtoPosicionSolicitud.getCodigoVenta();
        // unidadesDemandadas = DTOPosicionSolicitud.unidadesDemandadas 
        Long unidadesDemandadas = dtoPosicionSolicitud.getUnidadesDemandadas();
        
        // Si DTOPosicionSolicitud.oidPosicionSolicitud == null 
        if( dtoPosicionSolicitud.getOidPosicionSolicitud() == null ){
            // { 
            // -- Nueva posición:
            MONGenerarPosicionSolicitudHome monHome = (MONGenerarPosicionSolicitudHome)UtilidadesEJB.getHome("MONGenerarPosicionSolicitud", 
                MONGenerarPosicionSolicitudHome.class);
            MONGenerarPosicionSolicitud mon = monHome.create();
            // DTOE = Llamar al método MONGenerarPosicionSolicitud.generarPosicion(DTOE, posicion, True) 
            try{
                dtoCabeceraSolicitud = mon.generarPosicion(dtoCabeceraSolicitud, Long.decode(String.valueOf(posicion)), Boolean.TRUE);           
            }catch(RemoteException re){}
            // } 
        // sino 
        // Si DTOPosicionSolicitud.codigoVenta == null 
        }else if( dtoPosicionSolicitud.getCodigoVenta() == null ){
            // { 
            // -- Eliminamos la posición:
            DAOPosicion dao = new DAOPosicion();
            // DAOPosicion.eliminarPosicion(oidPosicionSolicitud) 
            dao.eliminarPosicion(oidPosicion);
            // } 
        // sino 
        }else{
            // { 
            // -- Actualizamos la posición:
            // DAOPosicion.actualizarPosicion(oidPosicionSolicitud, codigoVenta, unidadesDemandadas) 
            DAOPosicion dao = new DAOPosicion();
            dao.actualizarPosicionVerificacion(oidPosicion, codigoVenta, unidadesDemandadas);
            // } 
        }
        // DTOCabeceraSolicitud
        UtilidadesLog.info("MONVerificarSolicitudBean.consolidarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud, int posicion): Salida ");
        return dtoCabeceraSolicitud;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Maximiliano Dello Russo (grusso)
    * Descripcion: Busca las posiciones de una solicitud que se va a verificar 
    * @param    DTOObtenerPosicionesVerificacion
    * @return   DTOSalida
    * @throws es.indra.mare.common.exception.MareException
    */
    public DTOSalida obtenerPosicionesVerificacion(DTOObtenerPosicionesVerificacion dtoe) throws MareException {
        UtilidadesLog.info("MONVerificarSolicitudBean.obtenerPosicionesVerificacion(DTOObtenerPosicionesVerificacion dtoe): Entrada ");
        // RecordSet resultado = DAOSolicitud.obtenerPosicionesDigitacion(DTOE.oidCabeceraSolicitud) 
        DAOSolicitud dao = new DAOSolicitud();
        RecordSet resultado = dao.obtenerPosicionesDigitacion(dtoe.getOidCabeceraSolicitud());
        UtilidadesLog.debug("Este es el recordset: " + resultado);
        // Crea un DTOSalida con: 
        DTOSalida dtoSalida = new DTOSalida();
        // - resultado = completarPosiciones(resultado, DTOE.posicionesVerificacion) 
        resultado = this.completarPosiciones(resultado, dtoe.getPosicionesVerificacion());
        // Devuelve DTOSalida 
        dtoSalida.setResultado(resultado);
        UtilidadesLog.info("MONVerificarSolicitudBean.obtenerPosicionesVerificacion(DTOObtenerPosicionesVerificacion dtoe): Salida ");
        return dtoSalida;
    }
    
    
    
    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Pablo Perez (grusso)
    * Descripcion: Completa el RecordSet con las posiciones de digitación, añadiendo las posiciones de verificación 
    * @param RecordSet posicionesDigitacion, String posicionesVerificacion
    * @return RecordSet
    * @throws es.indra.mare.common.exception.MareException
    */
    private RecordSet completarPosiciones(RecordSet posicionesDigitacion, String posicionesVerificacion) throws MareException{
        UtilidadesLog.info("MONVerificarSolicitudBean.completarPosiciones(RecordSet posicionesDigitacion, String posicionesVerificacion): Entrada ");
        // El formato del RecordSet posicionesDigitacion es: 
        // OID | ESTADO | CV_DIGITACION | UD_DIGITACION | CV_VERIFICACION | UD_VERIFICACION 
        
        // (Las columnas ESTADO, CV_VERIFICACION y UD_VERIFICACION están vacias) 
        
        // El formato del String posicionesVerificacion es: 
        // CV1 | UD1 | # | CV2 | UD2 | # | CV3 | UD3 | # | .....| CVN | UDN | 
                
        // Debemos completar las columnas vacías (CV_VERIFICACION y UD_VERIFICACION) del RecordSet 
        // posicionesDigitacion utilizando los valores del String posicionesVerificacion de la siguiente forma: 
        
        // OID | ESTADO | CV_DIGITACION | UD_DIGITACION | CVN | UDN 
        
        // donde N es el número de fila dentro del RecordSet 
        
        // La columna ESTADO se rellena llamando al método calcularEstadoPosicion con los parámetros: 
        // - CV_DIGITACION, UD_DIGITACION, CVN, UDN 
        // (Alguno de los parámetros puede estar vacío o ser null) 
        
        // Ejemplo: 
        
        // posicionesDigitacion 
        // 1 | | 10002 | 25 | | | 
        // 2 | | 10003 | 30 | | | 
        // 3 | | 20023 | 12 | | | 
        
        // posicionesVerificacion 
        // 10002 | 25 | # | 10007 | 30 | # |20004 | 12 | # | 10007 | 10 | 
        
        // Al completar posicionesDigitacion 
        // 1 | Correcto | 10002 | 25 | 10002 | 25 | 
        // 2 | Error en CV | 10003 | 30 | 10004 | 30 | 
        // 3 | Error en UD | 20023 | 15 | 20023 | 12 | 
        // 0 | Nueva posición | | | 10006 | 10 | 
        UtilidadesLog.debug("Entro a completarPosicion... ");
        UtilidadesLog.debug("Posiciones Verificacion: " + posicionesVerificacion);
        UtilidadesLog.debug("RecordSet: "  + posicionesDigitacion);
        
        try  {
            String[] arr = obtenerArray(posicionesVerificacion,"#");    
            
            int pos = 0;
            
            while (pos < arr.length && pos < posicionesDigitacion.getRowCount())  {
                String[] posicion = obtenerArray(arr[pos],"|");
                posicionesDigitacion.setValueAt(posicion[0],pos,4);
                posicionesDigitacion.setValueAt(posicion[1],pos,5);
                String CV_D = (String)posicionesDigitacion.getValueAt(pos,2);
                Long UN_D = new Long(((BigDecimal)posicionesDigitacion.getValueAt(pos,3)).longValue());
                String CV_V = posicion[0];
                Long UN_V = new Long(posicion[1]);
                String estado = calcularEstadoPosicion(CV_D,UN_D,CV_V,UN_V);
                
                posicionesDigitacion.setValueAt(estado,pos,1);
                pos++;
            }
            
            if (arr.length > posicionesDigitacion.getRowCount())  {
                while (pos < arr.length)  {
                    String[] posicion = obtenerArray(arr[pos],"|");
                    Vector posNueva = new Vector();
                    String estado = calcularEstadoPosicion(null,null,posicion[0], new Long(posicion[1]));
                    posNueva.add(new BigDecimal("0"));
                    posNueva.add(estado);
                    posNueva.add(null);
                    posNueva.add(null);
                    posNueva.add(posicion[0]);
                    posNueva.add(new BigDecimal(posicion[1]));
                    posicionesDigitacion.addRow(posNueva);
                    pos++;
                }
            } else if (arr.length < posicionesDigitacion.getRowCount())  {
                while (pos < posicionesDigitacion.getRowCount())  {
                    String CV_D = (String)posicionesDigitacion.getValueAt(pos,2);
                    Long UN_D = new Long(((BigDecimal)posicionesDigitacion.getValueAt(pos,3)).longValue());
                    String estado = calcularEstadoPosicion(CV_D,UN_D,null,null);
                    posicionesDigitacion.setValueAt(estado,pos,1);
                    pos++;
                }
                
                    
            }
            UtilidadesLog.debug(posicionesDigitacion);

        } catch (Exception ex)  {
            UtilidadesLog.error("Exception: ",ex);
        } 
        UtilidadesLog.info("MONVerificarSolicitudBean.completarPosiciones(RecordSet posicionesDigitacion, String posicionesVerificacion): Salida ");
        return posicionesDigitacion;
    }
    
    
    
    /**
    * Sistema:     Belcorp
    * Modulo:      PED
    * Fecha:       29/12/2004
    * @version     3.3
    * @autor       Maximiliano Dello Russo (grusso)
    * Descripcion    
    * @param String cvDigitacion, Long udDigitacion, String cvVerificacion, Long udVerificacion
    * @return String estado
    * @throws es.indra.mare.common.exception.MareException
    */
    private String calcularEstadoPosicion(String cvDigitacion, Long udDigitacion, String cvVerificacion, Long udVerificacion) throws MareException{
        UtilidadesLog.info("MONVerificarSolicitudBean.calcularEstadoPosicion(String cvDigitacion, Long udDigitacion, String cvVerificacion, Long udVerificacion): Entrada ");
        String estado;
        // Si cvDigitacion == null OR cvDigitacion == ' ' 
        if( cvDigitacion == null || cvDigitacion.equals("") ){
            // estado = ConstantesPED.NUEVA_POSICION 
            estado = ConstantesPED.NUEVA_POSICION;
        // sino 
        // Si cvVerificacion == null OR cvVerificacion == ' ' 
        }else if( cvVerificacion == null || cvVerificacion.equals("") ){
            // estado = ConstantesPED.POSICION_ELIMINADA 
            estado = ConstantesPED.POSICION_ELIMINADA;
        // sino 
        // Si cvDigitacion != cvVerificacion 
        }else if( !cvDigitacion.equals(cvVerificacion) ){
            // estado = ConstantesPED.CV_ERROR 
            estado = ConstantesPED.CV_ERROR;
        // sino 
        // Si udDigitacion != udVerificacion 
        } else if( udDigitacion.longValue() != udVerificacion.longValue() ){
            // estado = ConstantesPED.UD_ERROR 
            estado = ConstantesPED.UD_ERROR;
        // sino 
        } else {
            // estado = ConstantesPED.CORRECTO 
            estado = ConstantesPED.CORRECTO;
        }
        
        // Devuelve estado
        UtilidadesLog.info("MONVerificarSolicitudBean.calcularEstadoPosicion(String cvDigitacion, Long udDigitacion, String cvVerificacion, Long udVerificacion): Salida ");
        return estado;
    }

    private String[] obtenerArray(String posConsolidar, String delim) 
        throws Exception{
        UtilidadesLog.info("MONVerificarSolicitudBean.obtenerArray(String posConsolidar, String delim): Entrada ");
        StringTokenizer stk = new StringTokenizer(posConsolidar,delim);
		String[] arr = new String[stk.countTokens()];
		int cuenta = 0;
        while (stk.hasMoreTokens()) {
			arr[cuenta] = stk.nextToken();
			cuenta++;
        }
        UtilidadesLog.info("MONVerificarSolicitudBean.obtenerArray(String posConsolidar, String delim): Salida ");
        return arr;
     }    

    /**
     * 
     */
    public void actualizarCabeceraVerificacion(DTOCabeceraSolicitud dtoe) throws MareException {
        UtilidadesLog.info("MONVerificarSolicitudBean.actualizarCabeceraVerificacion(): Entrada ");
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        //Actualizamos la cabecera de la solicitud a estado Validado y proceso Verificación
        // DAOSolicitud.actualizarProcesoSolicitud(DTOE.oidCabeceraSolicitud, ConstantesPED.GP1, ConstantesProcesosPED.VERIFICAR_SOLICITUD, ConstantesPED.ESTADO_SOLICITUD_VALIDADO)
        daoSolicitud.actualizarProcesoSolicitud(dtoe.getOidCabeceraSolicitud(), 
                                                            ConstantesPED.GP1,
                                                            ConstantesProcesosPED.VERIFICAR_SOLICITUD, 
                                                            ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONVerificarSolicitudBean.actualizarCabeceraVerificacion(): Salida ");
    }

}