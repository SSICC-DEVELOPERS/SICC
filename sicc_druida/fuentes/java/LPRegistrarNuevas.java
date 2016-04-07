import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.edu.DTOParticipante;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.edu.DTOValidarParticipantes;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPRegistrarNuevas extends LPRegistro {

    private String accion;
    private String opcionMenu;
    private Long idioma;
    private Long pais;

    public LPRegistrarNuevas() {
        super();
    }
            
    public void inicio() throws Exception {
        
    }

    public void ejecucion() throws Exception {
        try{
            this.setTrazaFichero();
            UtilidadesLog.debug("LPRegistrarNuevas.ejecucion(): Entrada");
            this.rastreo();
            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            UtilidadesLog.debug("LPRegistrarNuevas.ejecucion(): accion["+accion+"], opcionMenu["+opcionMenu+"], idioma["+idioma+"], pais["+pais+"]");
            if(accion.equals("")){
                cargaPantallaBuscaCurso();
            } else if(accion.equals("RegistrarNuevas")){
                cargaPantallaParaRegistrar();
            } else if(accion.equals("Registrar")){
                registraAsistencia();
            } else if(accion.equals("ObtenerDatosCliente")){
                obtenerDatosCliente();
            }
        }catch(Exception e){
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }finally{
            UtilidadesLog.debug("LPRegistrarNuevas.ejecucion(): Salida");
        }
    }
            
    private void cargaPantallaBuscaCurso() throws Exception {
        UtilidadesLog.debug("LPRegistrarNuevas.cargaPantallaBuscaCurso(): Entrada");
        try  {
            pagina("contenido_registrar_nuevas_buscar_curso");
            setsDeSiempre();
            asignarAtributoPagina("cod", "01070");
            getConfiguracionMenu("LPRegistrarNuevas");
            
            // Cada elemento del ArrayList es un combo a configurar 
            // sus parametros se definen en otyro ArrayList
            //  0 (String) BusinessID
            //  1 (String) Nombre de Combo en pantalla
            //  2 (Byte) Posicion del codigo. Puede ser nulo
            //  3 (Byte) Posicion de la descripcion
            //  4 (String) Elementos seleccionados 
            //  5 (String) Columnas
            ArrayList aConfigurar = new ArrayList();
            // 
            ArrayList configurar = new ArrayList();
            configurar.add("SEGConsultaMarcas");
            configurar.add("cbMarca");
            configurar.add(new Byte("0"));
            configurar.add(new Byte("1"));
            configurar.add(null);
            configurar.add(null);
            aConfigurar.add(configurar);
            
            configurar = new ArrayList();
            configurar.add("SEGConsultaCanales");
            configurar.add("cbCanal");
            configurar.add(new Byte("0"));
            configurar.add(new Byte("1"));
            configurar.add(null);
            configurar.add(null);
            aConfigurar.add(configurar);
                                             
            cargaCombos(aConfigurar);
            
        }catch ( Exception e ) {
            throw e;
        }finally{
            UtilidadesLog.debug("LPRegistrarNuevas.cargaPantallaBuscaCurso(): Salida");
        }
    }

    private void cargaPantallaParaRegistrar() throws Exception{
        try{
            UtilidadesLog.debug("LPRegistrarNuevas.cargaPantallaParaRegistrar(): Entrada");
            this.pagina("contenido_registrar_nuevas_actualizar_curso");
            setsDeSiempre();
            asignarAtributoPagina("cod", "01070");
            getConfiguracionMenu("LPRegistrarNuevas","Guardar");
            
            String strTipCurso = this.conectorParametroLimpia("oidTipoCurso", "", true);
            String strOidCurso = this.conectorParametroLimpia("oid","",true);
            this.asignarAtributo("VAR", "oidTipoCurso", "valor", strTipCurso);
            this.asignarAtributo("VAR", "oidCurso","valor", strOidCurso);
            Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
            if(longitudCodigoCliente!=null) 
                asignarAtributo("VAR", "hLongitudCodigoCliente", "valor",longitudCodigoCliente.toString());
            else
                asignarAtributo("VAR", "hLongitudCodigoCliente", "valor", "0");

            this.asignarAtributoElementoValidacion("grupoPPal", "txtFechaAsistenciaCurso", "max", (new SimpleDateFormat("dd/MM/yyyy")).format(new Date()));
            
            UtilidadesLog.debug("OIDCurso["+strOidCurso+"], TipoCurso["+strTipCurso+"], lngCodCli["+longitudCodigoCliente+"]");
            
        }catch(Exception e){
            throw e;
        }finally{
            UtilidadesLog.debug("LPRegistrarNuevas.cargaPantallaParaRegistrar(): Salida");
        }
    }
    
   
    private void registraAsistencia() throws Exception {
        try{
            UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): Entrada");
            this.pagina("salidaGenerica");
            setsDeSiempre();
            
            Long oidCurso = new Long( this.conectorParametroLimpia("oidCurso","",true));
            Long oidTipoCurso = new Long( this.conectorParametroLimpia("oidTipoCurso","",true));
            String lista = conectorParametroLimpia("lista","",true);
            UtilidadesLog.debug("oidCurso["+oidCurso+"], oidTipoCurso["+oidTipoCurso+"], lista["+lista+"]");
            
            ArrayList dtoPLista = parseaLista(lista);
            
            // Se valida los participantes
            DTOValidarParticipantes dtoValidadar = new DTOValidarParticipantes();
            dtoValidadar.setOidPais(pais);
            dtoValidadar.setCurso(oidCurso);
            dtoValidadar.setTipoCurso(oidTipoCurso);
            dtoValidadar.setValidar(dtoPLista);
            
            Vector vParams = new Vector();
            MareBusinessID busId = new MareBusinessID("EDUValidarParticipantesRegistrarNuevas");
            vParams.add(dtoValidadar);
            vParams.add(busId);
            DruidaConector con = this.conectar("ConectorValidarParticipantesRegistrarNuevas", vParams);
            DTOParticipantesValidados dtoPValidados = (DTOParticipantesValidados)con.objeto("DTOParticipantesValidados");
            

            if(dtoPValidados.getValidos()!=null && dtoPValidados.getValidos().length>0){
                UtilidadesLog.debug("Cantidad de Participantes Validos ["+dtoPValidados.getValidos().length+"]");
            }else{
                UtilidadesLog.debug("No hay participantes Validos");
            }
            if(dtoPValidados.getNoValidos()!=null && dtoPValidados.getNoValidos().length>0){
                UtilidadesLog.debug("Cantidad de Participantes NO Validos [" + dtoPValidados.getNoValidos().length+"]");
            }else{
                UtilidadesLog.debug("No hay participantes NO Validos");
            }
            
            
            // Luego de validar se registra lo valido
            // Lo no valido se reporta por pantalla
            if(dtoPValidados.getValidos()!=null && dtoPValidados.getValidos().length>0){
                UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): INICIO grabacion Validas...");
                DTORegistrarAsistencia dtoe = new DTORegistrarAsistencia();
                dtoe.setOidPais( pais );
                dtoe.setOidIdioma( idioma );
                dtoe.setOperacion( ConstantesEDU.REG_NUEV );
                dtoe.setOidCurso( oidCurso );
                dtoe.setParticipantes(dtoPValidados.getValidos());
                registro(dtoe);
                UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): FIN grabacion Validas");
            }else{
                UtilidadesLog.debug("No hay datos para grabar en Aptas A Cursos");
            }
            
            StringBuffer sFuncion = new StringBuffer("");
            String sErrorGUI = "";
            StringBuffer sRegNOValidos = new StringBuffer("");
            StringBuffer sRegValidos = new StringBuffer("");
            if(dtoPValidados.getNoValidos()!=null && dtoPValidados.getNoValidos().length>0){
                sErrorGUI = "UIEDU0007";
                for (int i = 0; i < dtoPValidados.getNoValidos().length; i++) {
                    if ( i != 0 ) {
                        sRegNOValidos.append(",");
                    }
                    sRegNOValidos.append(dtoPValidados.getNoValidos()[i].getNumeroRegistro());
                }
            }
                
            if(dtoPValidados.getValidos()!=null && dtoPValidados.getValidos().length>0){
                if(dtoPValidados.getValidos()!=null){
                    for (int i = 0; i < dtoPValidados.getValidos().length; i++) {
                        if ( i != 0 ) {
                            sRegValidos.append(",");
                        }
                        sRegValidos.append(dtoPValidados.getValidos()[i].getNumeroRegistro());
                    }
                }
            }
            
            sFuncion.append("insercionCorrecta('");
            sFuncion.append(sErrorGUI);
            sFuncion.append("', '");
            sFuncion.append(sRegNOValidos.toString());
            sFuncion.append("', '");
            sFuncion.append(sRegValidos.toString());
            sFuncion.append("')");
            
            this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
            this.asignarAtributo("VAR", "ejecutar", "valor", sFuncion.toString());
            
            /*
             * Invoca a MONInformes.generarPasoHistoricoExtemporaneas();
			 * - 25/04/2007 Se comenta paso a Historico
             */
			/*
            if(dtoPValidados.getValidos() != null && dtoPValidados.getValidos().length > 0){
                UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): INICIO paso a Historico...");
                
                DTORegistrarHistorico dtoR = new DTORegistrarHistorico();
                dtoR.setValidos(dtoPValidados.getValidos());
                dtoR.setOidIdioma(idioma);
                dtoR.setOidPais(pais);
                dtoR.setOidTipoCurso(oidTipoCurso);
                dtoR.setOidCurso(oidCurso);
                
                MareBusinessID busID = new MareBusinessID("EDUGenerarPasoHistorico2");
                vParams = new Vector();
                
                vParams.add(dtoR);
                vParams.add(busID);
                
                this.conectar("ConectorGenerarPasoHistorico2", vParams);
                
                UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): FIN paso a Historico");
            }else{
                UtilidadesLog.debug("No hay datos para pasar al historico");
            }
			*/
        
        }catch(Exception e){
            throw e;
        }finally{
            UtilidadesLog.debug("LPRegistrarNuevas.registraAsistencia(): Salida");
        }
    }


    private void obtenerDatosCliente() throws Exception {
        UtilidadesLog.debug("LPRegistrarNuevas.obtenerDatosCliente(): Entrada");
        pagina("salidaGenerica");
        setsDeSiempre();
        
        String sCodigoCliente = this.conectorParametroLimpia("codigoCliente", "" , true);
        UtilidadesLog.debug("CodigoCliente: " + sCodigoCliente);
        this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        this.asignarAtributo("VAR", "ejecutarError", "valor", "errorBusquedaCliente()");
        
        DTOBusquedaRapidaCliente dtoBusquedaRapida = new DTOBusquedaRapidaCliente();
        Vector vParams = new Vector(); 
        MareBusinessID busId = new MareBusinessID("MAEBusquedaRapidaCliente");
        
        dtoBusquedaRapida.setCodigoCliente(sCodigoCliente);
        dtoBusquedaRapida.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoBusquedaRapida.setOidPais(UtilidadesSession.getPais(this));
        dtoBusquedaRapida.setTamanioPagina(Integer.valueOf("1"));
        
        vParams.add(dtoBusquedaRapida);
        vParams.add(busId);
        DruidaConector con = this.conectar("ConectorBusquedaRapidaCliente", vParams);
        DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");
        RecordSet r = dtoSalida.getResultado();
        UtilidadesLog.debug("Resultado: " + r);
        
        StringBuffer sFuncion = new StringBuffer("");
        Long oidCliente = Long.valueOf( r.getValueAt(0,0).toString() );
        String sNombre1 = (String) r.getValueAt(0,2);
        String sNombre2 = (String) r.getValueAt(0,3);     
        String sApellido1 = (String) r.getValueAt(0,4);     
        String sApellido2 = (String) r.getValueAt(0,5);
        
        // Armo la funcion de jscript a llamar con sus valores correspondientes. 
        sFuncion.append("anyadeCampoALista('" + oidCliente.toString() + "', ");
        sFuncion.append("'" + sNombre1 + "', ");
        sFuncion.append("'" + sNombre2 + "', ");
        sFuncion.append("'" + sApellido1 + "', ");
        sFuncion.append("'" + sApellido2 + "')");
        UtilidadesLog.debug("sFuncion: " + sFuncion.toString());
        
        this.asignarAtributo("VAR", "ejecutar", "valor", sFuncion.toString());
        
        UtilidadesLog.debug("LPRegistrarNuevas.obtenerDatosCliente(): Salida");
    }
    
    private ArrayList parseaLista(String sLista) throws Exception {
        UtilidadesLog.debug("LPRegistrarNuevas.parseaLista(String): Entrada");
        ArrayList dtoPLista = new ArrayList();
        DTOParticipante dtoParticipante = null;
        StringTokenizer st = new StringTokenizer(sLista,"#");
        UtilidadesLog.debug("totalEnLista["+st.countTokens()+"]");
        while (st.hasMoreTokens()) {
            String fila = st.nextToken();
            StringTokenizer stFila = new StringTokenizer(fila,"@");
            while (stFila.hasMoreTokens()) {
               dtoParticipante=new DTOParticipante();
               String sNroRegistro = stFila.nextToken();
               String sFechaAsistencia = stFila.nextToken();
               String sOidCliente = stFila.nextToken();
               Integer iOidParticipante = Integer.valueOf(sNroRegistro);
               Long lOidCliente = Long.valueOf(sOidCliente);
               dtoParticipante.setOidIdioma(idioma);
               dtoParticipante.setNumeroRegistro(iOidParticipante);
               dtoParticipante.setFecAsistencia(this.fecha(sFechaAsistencia));
               dtoParticipante.setOidCliente(lOidCliente);
               //UtilidadesLog.debug("dtoParticipante = "+dtoParticipante);
               dtoPLista.add(dtoParticipante);
             }        
        }
        UtilidadesLog.debug("LPRegistrarNuevas.parseaLista(String): Salida");
        return dtoPLista;
    }
    
    private java.sql.Date fecha(String entrada)  throws Exception {
        if (entrada != null && !entrada.equals("-")) 
            return new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(entrada, UtilidadesSession.getFormatoFecha(this))).getTime());
        return null;
    }
    
    private void logStackTrace(Throwable e) throws Exception {
        UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        UtilidadesLog.error("Stack Trace: " + baos.toString());
    }
    
    private void setsDeSiempre() throws Exception{
        this.asignarAtributo("VAR", "pais", "valor", pais.toString());
        this.asignarAtributo("VAR", "idioma", "valor", idioma.toString());
        this.asignarAtributo("VAR", "accion", "valor", accion);
        this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        this.getFormatosValidaciones();
    }
     
    private void cargaCombos(ArrayList aConfigurar) throws Exception{
        //DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas, byte [] posicionOid, byte [] posicionDescripcion) throws Exception {
        UtilidadesLog.debug("LPRegistrarNuevas.cargaCombos(): Entrada");
        UtilidadesLog.debug("aConfigurar:"+aConfigurar);
        DTOBelcorp dtoEntrada = new DTOBelcorp();
        dtoEntrada.setOidPais(pais);
        dtoEntrada.setOidIdioma(idioma);
    
        ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = null;
        
        for(int i=0; i < aConfigurar.size(); i++){
            ArrayList configurando = (ArrayList)aConfigurar.get(i);
            elem=new ComposerViewElement(); 
            elem.setIDBusiness((String)configurando.get(0));
            elem.setDTOE(dtoEntrada);
            if(configurando.get(2)!=null) elem.setPosOID(((Byte)configurando.get(2)).byteValue());
            if(configurando.get(3)!=null) elem.setPosDesc(((Byte)configurando.get(3)).byteValue());
            listelem.addViewElement(elem);
        }
        
        // Se ejecuta el conector 
        ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsultar = conector.getConector();
        
        // Luego de la llamada se debe hacer el asignar a los elementos de la pantalla 
        // correspondiente utilizando el String que representa el BusinessID en cada caso.
        for(int i=0; i<aConfigurar.size(); i++){
            ArrayList configurando = (ArrayList)aConfigurar.get(i);
            if (configurando.get(4) == null) {
                asignar("COMBO", (String)configurando.get(1), conConsultar, (String)configurando.get(0)); 
            } else {
                if (((String)(configurando.get(4))).length()>0 && (configurando.get(5)!=null) && ((String)(configurando.get(5))).length()>0)
                    asignar("COMBO", (String)configurando.get(1), conConsultar, (String)configurando.get(0), (String)configurando.get(4), (String)configurando.get(5));
                else
                    asignar("COMBO", (String)configurando.get(1), conConsultar, (String)configurando.get(0)); 
            }              
        }
        UtilidadesLog.debug("LPRegistrarNuevas.cargaCombos(): Salida");
    }
}