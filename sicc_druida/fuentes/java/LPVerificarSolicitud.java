import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOObtenerPosicionesVerificacion;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

import es.indra.sicc.logicanegocio.ped.ConstantesProcesosPED;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.mare.common.mln.MareBusinessID;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPVerificarSolicitud extends LPSICCBase {

    private String accion;
    private Long aPais;
    private Long aIdioma;
    private String posicionesDigitacion;
    private String posicionesConsolidar;
    private Long oidTipoSolicitud;
    private Long oidPeriodo;
    private Long oidCliente;
    private Long oidCabeceraSolicitud;


    public LPVerificarSolicitud(){
    
    }
    
    public void inicio() throws Exception  {
    
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        try  {
            //rastreo();
            aPais = UtilidadesSession.getPais(this);
            aIdioma = UtilidadesSession.getIdioma(this);
            accion = conectorParametroLimpia("accion","",true);
            trazarAtributos();
            traza("Esta es la accion: " +  accion);
            if (accion.equals(""))  {
                traza("Entro a digitar solicitud..!!!");
                digitarSolicitud();
            } else if (accion.equals("Seleccionar_solicitud"))  {
                traza("Entro por accion Seleccionar_solicitud");
                posicionesDigitacion = conectorParametroLimpia("hPosicionesDigitacion","",true);
                oidTipoSolicitud = conectorParametro("hOidTipoSolicitud").equals("")? null:new Long(conectorParametro("hOidTipoSolicitud"));
                oidPeriodo = conectorParametro("hPeriodo").equals("")? null:new Long(conectorParametro("hPeriodo"));
                oidCliente = conectorParametro("hOidCliente").equals("")? null:new Long(conectorParametro("hOidCliente"));
                seleccionarSolicitud();
                getConfiguracionMenu();
            } else if (accion.equals("Verificar_solicitud"))  {
                posicionesDigitacion = conectorParametroLimpia("hPosicionesDigitacion","",true);
                oidTipoSolicitud = conectorParametro("hOidTipoSolicitud").equals("")? null:new Long(conectorParametro("hOidTipoSolicitud"));
                oidPeriodo = conectorParametro("hPeriodo").equals("")? null:new Long(conectorParametro("hPeriodo"));
                oidCliente = conectorParametro("hOidCliente").equals("")? null:new Long(conectorParametro("hOidCliente"));
                verificarSolicitud();
                getConfiguracionMenu();
            } else if (accion.equals("Consolidar_posiciones"))  {
                posicionesDigitacion = conectorParametroLimpia("hPosicionesDigitacion","",true);
                oidTipoSolicitud = conectorParametro("hOidTipoSolicitud").equals("")? null:new Long(conectorParametro("hOidTipoSolicitud"));
                oidPeriodo = conectorParametro("hPeriodo").equals("")? null:new Long(conectorParametro("hPeriodo"));
                oidCliente = conectorParametro("hOidCliente").equals("")? null:new Long(conectorParametro("hOidCliente"));
                consolidarPosiciones();
            }        
            //getConfiguracionMenu();
        } catch (Exception ex)  {
            traza("Entro a la exception...");
            lanzarPaginaError(ex);
        }
    }

    public void digitarSolicitud() throws Exception{
        /*Llama a LPDigitarSolicitudInicial con: 
        - accion = "" 
        - verificacion = "Si" */
        conectorAction("LPDigitarSolicitudInicial");
        conectorActionParametro("accion","");
        conectorActionParametro("verificacion","SI");
        traza("termino de llamar a digitarsolicitud inicial");
    }

    public void seleccionarSolicitud() throws Exception {
       
        /*Muestra la página PGSeleccionarSolicitud y envia los parámetros: 
        - posicionesDigitacion 
        - oidTipoSolicitud 
        - oidPeriodo 
        - oidCliente 
        - oidProceso = ConstantesProcesosPED.DIGITAR_SOLICITUD */
        traza("Entro a seleccionarSolicitud... ");
        pagina("contenido_detalle_digitar");
        
        asignarAtributo("VAR","hPais","valor", aPais.toString());
        asignarAtributo("VAR","hIdioma","valor", aIdioma.toString());
        asignarAtributo("VAR","hPosicionesDigitacion","valor", posicionesDigitacion);
        asignarAtributo("VAR","hOidTipoSolicitud","valor", oidTipoSolicitud.toString());
        asignarAtributo("VAR","hPeriodo","valor", oidPeriodo.toString());
        asignarAtributo("VAR","hOidCliente","valor",oidCliente.toString());
        asignarAtributo("VAR","hOidProceso","valor",ConstantesProcesosPED.DIGITAR_SOLICITUD.toString());        
    }

    public void verificarSolicitud() throws Exception {
        /*
        Crea un DTOObtenerPosicionesVerificacion con: 
        - oidCabeceraSolicitud 
        - posicionesVerificacion 
        */        
        oidCabeceraSolicitud = conectorParametro("hOidCabeceraSolicitud").equals("")? null:new Long(conectorParametro("hOidCabeceraSolicitud"));
        posicionesDigitacion = conectorParametroLimpia("hPosicionesDigitacion","",true);
        DTOObtenerPosicionesVerificacion dtoObtenerPosVerificacion = new DTOObtenerPosicionesVerificacion();
        
        dtoObtenerPosVerificacion.setOidCabeceraSolicitud(oidCabeceraSolicitud);
        dtoObtenerPosVerificacion.setPosicionesVerificacion(posicionesDigitacion);
        
        //Crear idBusiness = "PEDObtenerPosicionesVerificacion" 
        MareBusinessID idBusiness = new MareBusinessID("PEDObtenerPosicionesVerificacion");

        Vector vector = new Vector();
        vector.addElement(dtoObtenerPosVerificacion);
        vector.addElement(idBusiness);

        traza(" ANTES DE CONECTAR");
        DruidaConector druidaconector = conectar("ConectorObtenerPosicionesVerificacion",vector);
        traza(" DESPUES DE CONECTAR");

        DTOSalida dtoSalida = (DTOSalida) druidaconector.objeto("DTOSalida");
            
        traza("seteando la pagina...");
        pagina("contenido_errores_digitar"); 
        traza("despues de setear la pagina...");
        asignarAtributo("VAR","hOidCabeceraSolicitud","valor", oidCabeceraSolicitud.toString());
        asignar("LISTADOA","listado1",UtilidadesBelcorp.generarConector("dtosalida", dtoSalida.getResultado(),
                    dtoSalida.getResultado().getColumnIdentifiers()),"dtosalida");
        //Recibe DTOSalida y lo muestra en la lista de resultados de la página PGConsolidarPosiciones 
        
        /*Para aquellas posiciones con estado == ConstantesPED.CORRECTO (Primera columna) 
        deshabillitamos el check "Aceptar cambio" de la fila correspondiente
        */
        traza("Salio del metodo..!!");
    }

    public void consolidarPosiciones() throws Exception {
        // Obtiene las posiciones que se van a consolidar 
        
        /*Crea un DTOCabeceraSolicitud con: 
        - oidCabeceraSolicitud */
        posicionesConsolidar = conectorParametroLimpia("hPosicionesConsolidar","",true);
        oidCabeceraSolicitud = conectorParametro("hOidCabeceraSolicitud").equals("")? null:new Long(conectorParametro("hOidCabeceraSolicitud"));        
        Long numeroPosiciones = conectorParametro("hNumPosiciones").equals("")? null:new Long(conectorParametro("hNumPosiciones"));
        
        DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
        dtoCabeceraSolicitud.setOidCabeceraSolicitud(oidCabeceraSolicitud);

        
        traza("posicionesConsolidar: " + posicionesConsolidar);
        ArrayList arr = new ArrayList();
        
        for (int posicion=0; posicion < numeroPosiciones.intValue(); posicion++)  {
            String posicionSolicitud = obtenerPosicion(posicion);
            traza("Esta es la posicion: " + posicionSolicitud);
            DTOPosicionSolicitud dtoPosicionSolicitud = consolidarPosicion(posicionSolicitud);
            arr.add(dtoPosicionSolicitud);
        }
        dtoCabeceraSolicitud.setPosiciones(arr);
        
        pagina("salidaGenerica");
/*        String[] aPosiciones = obtenerArray(posicionesConsolidar, "#");
        int numeroPosiciones = aPosiciones.length;
        
        for (int i=0; i< numeroPosiciones; i++)  {
            DTOPosicionSolicitud dtoPosSolicitud = consolidarPosicion(aPosiciones[i]);
            arr.add(dtoPosSolicitud);
        }
        traza("Este es el array:  " + arr);
        dtoCabeceraSolicitud.setPosiciones(arr);*/

        MareBusinessID idBusiness = new MareBusinessID("PEDConsolidarPosicionesVerificacion");

        Vector vector = new Vector();
        vector.addElement(dtoCabeceraSolicitud);
        vector.addElement(idBusiness);

        traza(" ANTES DE CONECTAR");
        DruidaConector druidaconector = conectar("ConectorConsolidarPosicionesVerificacion",vector);
        traza(" DESPUES DE CONECTAR");

    }

    public DTOPosicionSolicitud consolidarPosicion(String posicionSolicitud) throws Exception {
        // Consolida una posición 
        // El formato de la posición recibida es: 
        // | OID | CV_VERIFICACION | UD_VERIFICACION | 
        Long oid = null;
        Long ud = null;
        
        String[] aPosicion = obtenerArray(posicionSolicitud,"|");        
        
        if (aPosicion[0].equals(""))
            oid = new Long(0);
        else 
            oid = new Long(aPosicion[0]);

        String cv = aPosicion[1];
        
        if (aPosicion[2].equals(""))
            ud = new Long(0);
        else 
            ud = new Long(aPosicion[2]);
        
        
        DTOPosicionSolicitud dtoPosSolicitud = crearDTOPosicionSolicitud(oid, cv, ud);
        
        //Devuelve DTOPosicionSolicitud 
        return dtoPosSolicitud;
    }

    public String obtenerPosicion(int posicion) throws Exception{
        String[] aPosiciones = obtenerArray(posicionesConsolidar, "#");
        return aPosiciones[posicion];
    }

    public DTOPosicionSolicitud crearDTOPosicionSolicitud(Long oid, String cv, Long ud) throws Exception {
    

    //    Si oid == 0 
    //    oid = null 
        if (oid.intValue() == 0)
            oid = null;
    
    //    Si cv == ' ' 
    //    cv = null 
        if (cv.equals(""))
            cv = null;
                
        
    //    Si ud == ' ' 
    //    ud = null  
        if (ud.intValue() == 0)
            ud = null;
    
    //    Crear un DTOPosicionSolicitud con: 
    //    - oidPosicionSolicitud: oid 
    //    - codigoVenta: cv 
    //    - unidadesDemandadas: ud 
        DTOPosicionSolicitud dtoPosSolicitud =  new DTOPosicionSolicitud();
        dtoPosSolicitud.setOidPosicionSolicitud(oid);
        dtoPosSolicitud.setCodigoVenta(cv);
        dtoPosSolicitud.setUnidadesDemandadas(ud);

    //    Devuelve DTOPosicionSolicitud
        return dtoPosSolicitud;
    }

    public String[] obtenerArray(String posConsolidar, String delim) 
        throws Exception{
        
        StringTokenizer stk = new StringTokenizer(posConsolidar,delim);
		String[] arr = new String[stk.countTokens()];
		int cuenta = 0;
        while (stk.hasMoreTokens()) {
			arr[cuenta] = stk.nextToken();
			cuenta++;
        }
        return arr;
     }

    public void trazarAtributos() throws Exception {
        
        traza("accion; " + accion);
        traza("aPais; " + aPais);
        traza("aIdioma; " + aIdioma);
        traza("posicionesDigitacion; " + posicionesDigitacion);
        traza("posicionesConsolidar; " + posicionesConsolidar);
        traza("oidTipoSolicitud; " + oidTipoSolicitud);
        traza("oidPeriodo; " + oidPeriodo);
        traza("oidCliente; " + oidCliente);
        traza("oidCabeceraSolicitud; " + oidCabeceraSolicitud);
    }
}
