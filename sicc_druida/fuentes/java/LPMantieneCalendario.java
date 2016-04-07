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
/*
    INDRA/CAR/sicc
    $Id: LPMantieneCalendario.java,v 1.1 2009/12/03 18:40:41 pecbazalar Exp $
    Insertar Calendario
*/

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOCalendario;
import es.indra.sicc.dtos.cra.DTOFeriado;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.sicc.dtos.cra.DTOSalidaCalendario;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;

import java.util.Hashtable;

// Definicion de la clase
public class LPMantieneCalendario extends LPSICCBase {

    int weekDay;
    Vector diasSabados;
    Vector diasDomingos;
    Vector vFeriados;
    Vector vGruposZonas;
    Vector paramEntrada;

    String pais;
    String canal;
    String anio;
    String marca;
    String grupoZona;
    String actividad;
    String sabados;
    String domingos;

    String accion;
    String casoDeUso;

    Long marcaDefecto;
    Long canalDefecto;

    String opcionMenu;

    // Definicion del constructor
    public LPMantieneCalendario() {super();}

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {}

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
        setTrazaFichero();
        accion  = conectorParametroLimpia("accion", "", true);
        traza ("entrada-accion :" + accion);

        try{
            if( accion.equals( "modificar" ) || accion.equals( "guardar" ) || 
                accion.equals( "eliminar" ) || accion.equals( "crear" ) || accion.equals( "cargarCalendario" ) ){
                opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            }
            if( accion.equals( "modificar" ) ){
                this.modifica();
            } else if( accion.equals( "muestraConsulta" ) ){
                this.muestraPantalla(null);
            } else if( accion.equals( "muestraBorrado" ) ){
                this.muestraPantalla(null);
            } else if( accion.equals( "muestraModificacion" ) ){
                this.muestraPantalla(null);
            } else if( accion.equals( "muestraInsercion" ) ){
                this.muestraPantalla(null);
            } else if( accion.equals( "guardar" ) ){
                this.guarda();
            } else if( accion.equals( "eliminar" ) ){
                this.elimina();
            } else if( accion.equals( "cargarCalendario" ) ){
                this.cargarCalendario();
            }
        } catch( Exception ex ){
            traza("-->Manejo de excepcion:");          
            this.logStackTrace(ex);
            this.recargaPostError();
            this.lanzarPaginaError(ex);
        }
    }


    /**
     * Recarga la pagina luego de un error.
     * Recarga la pagina segun el caso de uso actual.
     * El estado deseado es el mismo que produce ejecucion.
     */
    private void recargaPostError() throws Exception {
        traza("opcionMenu:"+opcionMenu);
        if( opcionMenu != null  && (accion == null || accion.equals(""))){
            accion = opcionMenu;
        }
        traza("cu: "+casoDeUso);
        if (casoDeUso != null) { 
            //ponemos la accion para mostrar la pantalla segun el Caso de Uso
            if (casoDeUso.equalsIgnoreCase("crear")) {
                accion = "muestraInsercion";
            } else if (casoDeUso.equalsIgnoreCase("modificar")) {
                accion = "muestraModificacion";
            } else if (casoDeUso.equalsIgnoreCase("consultar")) {
                accion = "muestraConsulta";
            } else if (casoDeUso.equalsIgnoreCase("eliminar")) {
                accion = "muestraBorrado";
            }
            this.muestraPantalla(null);
        }

        //Menu Secundario
        if ( casoDeUso!=null&&casoDeUso.equalsIgnoreCase( "modificar" ) ){
            this.getConfiguracionMenu( "LPMantieneCalendario", "cargarCalendario" );
        } else if ( casoDeUso!=null && casoDeUso.equalsIgnoreCase( "consultar" ) ){
            this.asignarAtributoPagina( "cod", "088" );
            this.getConfiguracionMenu( "LPMantieneCalendario", "muestraConsulta" );
        } else if ( casoDeUso!=null && casoDeUso.equalsIgnoreCase( "crear" ) ) {
            this.asignarAtributoPagina( "cod", "086" );
            this.getConfiguracionMenu( "LPMantieneCalendario", "muestraInsercion" );
        }
        traza( "--> Va a Invocar a lanzarPaginaError()." );
        asignarAtributo("VAR","ejecutarError","valor","despuesError()");
    }


    /**
     * 
     */
    private void modifica(  ) throws Exception {
        pais = conectorParametroLimpia("hPais", "", true);
        canal = conectorParametroLimpia("cmbCanal", "", true);
        anio = conectorParametroLimpia("txtAnio", "", true);
        marca = conectorParametroLimpia("cmbMarca", "", true);
        grupoZona = conectorParametroLimpia("cmbGruposZonas", "", true);
        actividad = conectorParametroLimpia("cmbActividades", "", true);

        sabados = conectorParametroLimpia("txtSabados", "", true);
        domingos = conectorParametroLimpia("txtDomingos", "", true);
        this.casoDeUso="modificar";

        DTOCalendario dtoe = new DTOCalendario();

        Vector vectorFeriados = this.armarListaDeFeriadosModificar();

        dtoe = new DTOCalendario();
        dtoe.setOidPais((pais == null || pais.length()==0?null: new Long(pais)));
        dtoe.setAnyo((anio == null || anio.length()==0?null: new Integer(anio)));
        dtoe.setOidMarca((marca == null || marca.length()==0?null: new Long(marca)));
        dtoe.setOidCanal((canal == null || canal.length()==0?null: new Long(canal)));        
        dtoe.setFeriados( vectorFeriados );

        traza("antes modificar: ");     
		//traza(dtoe);
        // Identificador de la lógica de negocio.          
        MareBusinessID id = new MareBusinessID("CRAModificaCalendario");

        paramEntrada = new Vector();
        paramEntrada.addElement(dtoe);
        paramEntrada.addElement(id);
        accion = "muestraModificacion";

        //Se hace una llamada al Conector
        traza("Antes de CRAModificaCalendario");
        conectar("ConectorCalendario", paramEntrada);
        traza("Despues de CRAModificaCalendario");

        conectorAction("LPMantieneCalendario");
        conectorActionParametro("accion","muestraModificacion");

        //accion = "muestraModificacion";
        this.muestraPantalla(null);
    }



    /**
     * 
     */
    private void muestraPantalla(String anioSel) throws Exception {
        traza( "accion: " + ( (accion==null) ? "null" : accion ) );
        if( accion != null ){
          if( accion.equals( "muestraInsercion" ) ){
            pagina( "Contenido_calendario_insertar" );
            this.asignarAtributo( "VAR", "hCasoDeUso", "valor", "crear" );
          } else if( accion.equals( "muestraModificacion" ) ){
            this.pagina( "contenido_calendario_modificar" );
            this.asignarAtributo( "VAR", "hAnioCreado", "valor", anioSel == null ? "" : anioSel);
	        this.asignarAtributo( "CTEXTO", "txtAnio", "valor", anioSel == null ? "" : anioSel);
            this.asignarAtributo( "VAR", "hCasoDeUso", "valor", "Modificar" );
          } else if( accion.equals( "muestraConsulta" ) ){
            this.pagina( "contenido_calendario_modificar" );
            this.asignarAtributoPagina( "cod", "088" );
            this.asignarAtributo( "VAR", "hCasoDeUso", "valor", "consultar" );
          } else if( accion.equals( "muestraBorrado" ) ){
            this.pagina( "Contenido_calendario_eliminar" );
            this.asignarAtributo( "VAR", "hCasoDeUso", "valor", "eliminar" );
          }

          this.asignarAtributo( "VAR", "opcionMenu", "valor", accion );
        }

        this.asignarAtributo( "VAR", "accion", "valor", accion );

        this.cargarCombosMarcaCanal();

        //se obtiene pais, idioma, programa e ipcliente para asignarlos a la pagina
        //y ser utilizados por recargaCombo
        Long pais = UtilidadesSession.getPais( this );
        String descPais = UtilidadesSession.getDescripcionPais( this );
        Long idioma = UtilidadesSession.getIdioma( this );
        String IPCliente = UtilidadesBelcorp.getIPCliente( this );
        String programa = UtilidadesSession.getFuncion( this );

        traza( "pais: " + pais.toString() );
        traza( "idioma: " + idioma.toString() );

        this.asignarAtributo( "VAR", "hPais", "valor", ((pais==null) ? "" : pais.toString() ) );
        this.asignarAtributo( "LABELC", "lblContenidoPais", "valor", ((descPais==null) ? "" : descPais ) );
        this.asignarAtributo( "VAR", "hIdioma", "valor", ((idioma==null) ? "" : idioma.toString() ) );
        this.asignarAtributo( "VAR", "hIPCliente", "valor", ((IPCliente==null) ? "" : IPCliente) );
        this.asignarAtributo( "VAR", "hPrograma", "valor", ((programa==null) ? "" : programa) );

        marcaDefecto = UtilidadesSession.getMarcaPorDefecto( this );
        canalDefecto = UtilidadesSession.getCanalPorDefecto( this );

        this.asignarAtributo( "VAR", "hMarcaDefecto", "valor", ((marcaDefecto==null) ? "" : marcaDefecto.toString() ) );
        this.asignarAtributo( "VAR", "hCanalDefecto", "valor", ((canalDefecto==null) ? "" : canalDefecto.toString() ) );
        this.asignarAtributo( "VAR", "accion", "valor", ((accion==null) ? "" : accion ) );

        //se configura el menu secundario para las siguientes acciones:
        //muestraModificacion, muestraConsulta, muestraBorrado
        this.getConfiguracionMenu( "LPMantieneCalendario", accion );
    }


    /**
     * 
     */
    private void cargarCombosMarcaCanal() throws Exception {
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais( UtilidadesSession.getPais( this ) );
        dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness( "SEGConsultaCanales" );
        ci1.setDTOE( dtoe );
    
        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness( "SEGConsultaMarcas" );
        ci2.setDTOE( dtoe );

        lista.addViewElement( ci1 );
        lista.addViewElement( ci2 );

		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
        DruidaConector resultados = null;
        resultados = conector.getConector();

        asignar("COMBO", "cmbCanal", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cmbMarca", resultados, "SEGConsultaMarcas");
    }


    /**
     * 
     */
    private void guarda(  ) throws Exception {
        pais = conectorParametroLimpia("hPais", "", true);
        String descPais = UtilidadesSession.getDescripcionPais( this );
        Long idioma = UtilidadesSession.getIdioma( this );
        String IPCliente = UtilidadesBelcorp.getIPCliente( this );
        String programa = UtilidadesSession.getFuncion( this );
        canal = conectorParametroLimpia("cmbCanal", "", true);
        anio = conectorParametroLimpia("txtAnio", "", true);
        marca = conectorParametroLimpia("cmbMarca", "", true);
        grupoZona = conectorParametroLimpia("cmbGruposZonas", "", true);
        sabados = conectorParametroLimpia("txtSabados", "", true);
        domingos = conectorParametroLimpia("txtDomingos", "", true);
        opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        casoDeUso = conectorParametroLimpia("hCasoDeUso", "", true);

        DTOCalendario dtoe = new DTOCalendario();
        dtoe.setOidPais( UtilidadesSession.getPais( this ) );
        dtoe.setOidMarca( (( marca==null || marca.length()==0 ) ? null : new Long(marca)) );
        dtoe.setOidCanal( (( canal==null || canal.length()==0 ) ? null : new Long(canal)) );
        dtoe.setAnyo( ( anio==null || anio.length()==0 ) ? null : new Integer(anio) );
        dtoe.setPrograma( UtilidadesSession.getFuncion(this) );
        dtoe.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        marcaDefecto = UtilidadesSession.getMarcaPorDefecto( this );
        canalDefecto = UtilidadesSession.getCanalPorDefecto( this );

        this.asignarAtributo( "VAR", "conectorAction", "valor", "LPMantieneCalendario" );
        this.asignarAtributo( "VAR", "hPais", "valor", ((pais==null) ? "" : pais.toString() ) );
        this.asignarAtributo( "LABELC", "lblContenidoPais", "valor", ((descPais==null) ? "" : descPais ) );
        this.asignarAtributo( "VAR", "hIdioma", "valor", ((idioma==null) ? "" : idioma.toString() ) );
        this.asignarAtributo( "VAR", "hIPCliente", "valor", ((IPCliente==null) ? "" : IPCliente) );
        this.asignarAtributo( "VAR", "hPrograma", "valor", ((programa==null) ? "" : programa) );
        this.asignarAtributo( "VAR", "hMarcaDefecto", "valor", ((marcaDefecto==null) ? "" : marcaDefecto.toString() ) );
        this.asignarAtributo( "VAR", "hCanalDefecto", "valor", ((canalDefecto==null) ? "" : canalDefecto.toString() ) );
        this.asignarAtributo( "VAR", "accion", "valor", ((accion==null) ? "" : accion ) );
        this.asignarAtributo( "VAR", "opcionMenu", "valor", ((opcionMenu==null) ? "" : opcionMenu ) );
        this.asignarAtributo( "VAR", "hCasoDeUso", "valor", ((casoDeUso==null) ? "" : casoDeUso ) );

        //Agregar feriados
        //DTOFeriado feriado = null;
        Enumeration enum = null;
        Date fechaFeriado = null;
        Vector feriados = new Vector();

        //Desarrolado en base a la Incidencia 8817
        vGruposZonas = vectorDeItems( grupoZona, "|" );
        Vector ferias = new Vector();
        for (int i = 0; i < vGruposZonas.size(); i++) {
            DTOFeriado dtoF = new DTOFeriado();
            dtoF.setOidGrupoZona(new Long((String) vGruposZonas.get(i)));
            ferias.add(dtoF);
        }
        dtoe.setFeriados(ferias);
        if (sabados.equals("S")) {
            dtoe.setIndSabado(new Boolean(true));
        } else {
            dtoe.setIndSabado(new Boolean(false));
        }

        if (domingos.equals("S")) {
            dtoe.setIndDomingo(new Boolean(true));
        } else {
            dtoe.setIndDomingo(new Boolean(false));
        }
    
        MareBusinessID id = new MareBusinessID("CRACreaCalendario");
    
        paramEntrada = new Vector();
        paramEntrada.addElement(dtoe);
        paramEntrada.addElement(id);

        //DruidaConector ConectorCreaCalendario = null;
        DruidaConector conectorCalendario = null;

        traza("Antes de CRACreaCalendario");    //traza(dtoe);
        conectorCalendario = conectar( "ConectorCalendario", paramEntrada );
        traza("Despues de CRACreaCalendario");

        asignarAtributo("VAR","ejecutar","valor","fLimpiar()");
        accion = "muestraModificacion";
        casoDeUso = "Modificar";

        this.muestraPantalla(anio);

        this.getConfiguracionMenu( "LPMantieneCalendario", "guardar" );
    }


    /**
     * 
     */
    private void elimina(  ) throws Exception {
        String pais = this.conectorParametroLimpia( "hPais", "", true );
        String descPais = this.conectorParametroLimpia( "lblContenidoPais", "", true );
        String marca = this.conectorParametroLimpia( "hMarca", "", true );
        String canal = this.conectorParametroLimpia( "hCanal", "", true );
        String anio = this.conectorParametroLimpia( "txtAnio", "", true );

        DTOCalendario dtoc = new DTOCalendario();
        dtoc.setOidPais( ((pais==null) ? null : new Long( pais )) );
        dtoc.setOidMarca( ((marca==null) ? null : new Long( marca )) );
        dtoc.setOidCanal( ((canal==null) ? null : new Long( canal )) );
        dtoc.setAnyo( ((anio==null) ? null : new Integer( anio )) );

        MareBusinessID id = new MareBusinessID( "CRAEliminaCalendario" );

        Vector paramEntrada = new Vector();
        paramEntrada.addElement( dtoc );
        paramEntrada.addElement( id );

        traza( "VA A ELIMINAR..." );
        pagina( "salidaGenerica" );
        DruidaConector dc = this.conectar( "ConectorCalendario", paramEntrada );
        traza( "ELIMINO CON EXITO." );

        accion = "muestraBorrado";
        asignarAtributo("VAR","ejecutar","valor","fLimpiar()");
    }


    /**
     * Carga el calendario segun el criterio de busqueda.
     */
    private void cargarCalendario() throws Exception{
        traza("cargarCalendario()");

        this.pagina( "contenido_calendario_modificar" );

        String pais = this.conectorParametroLimpia( "hPais", "", true );
        String descPais = this.conectorParametroLimpia( "lblContenidoPais", "", true );
        String marca = this.conectorParametroLimpia( "hMarca", "", true );
        String canal = this.conectorParametroLimpia( "hCanal", "", true );
        String actividad = this.conectorParametroLimpia( "hActividad", "", true );
        String grupoZona = this.conectorParametroLimpia( "hGrupoDeZona", "", true );
        String casoDeUso = this.conectorParametroLimpia( "hCasoDeUso", "", true );
        String anio = this.conectorParametroLimpia( "txtAnio", "", true );
        Long idioma = UtilidadesSession.getIdioma( this );
        String IPCliente = UtilidadesBelcorp.getIPCliente( this );
        String programa = UtilidadesSession.getFuncion( this );
        String opcionMenu = this.conectorParametroLimpia( "opcionMenu", "", true );

        this.asignarAtributo( "VAR", "accion", "valor", accion );
        this.asignarAtributo( "VAR", "hPais", "valor", pais );
        this.asignarAtributo( "LABELC", "lblContenidoPais", "valor", UtilidadesSession.getDescripcionPais( this ) );
        this.asignarAtributo( "VAR", "hMarca", "valor", ( marca==null || marca.length()==0 ? "" : marca ) );
        this.asignarAtributo( "VAR", "hCanal", "valor", ( canal==null || canal.length()==0 ? "" : canal ) );
        this.asignarAtributo( "VAR", "hActividad", "valor", ( actividad==null || actividad.length()==0 ? "" : actividad ) );
        this.asignarAtributo( "VAR", "hGrupoDeZona", "valor", ( grupoZona==null || grupoZona.length()==0 ? "" : grupoZona ) );
        this.asignarAtributo( "VAR", "hCasoDeUso", "valor", casoDeUso );
        this.asignarAtributo( "CTEXTO", "txtAnio", "valor", ( ( anio == null ) ? "" : anio ) );
        this.asignarAtributo( "VAR", "hIdioma", "valor", ((idioma==null) ? "" : idioma.toString() ) );
        this.asignarAtributo( "VAR", "hIPCliente", "valor", ((IPCliente==null) ? "" : IPCliente) );
        this.asignarAtributo( "VAR", "hPrograma", "valor", ((programa==null) ? "" : programa) );
        this.asignarAtributo( "VAR", "opcionMenu", "valor", ((opcionMenu==null) ? "" : opcionMenu) );
	
        this.casoDeUso = casoDeUso;
        DTOCalendario dtoe = new DTOCalendario();
        DTOFeriado dtof = new DTOFeriado();

        dtoe.setOidPais( new Long( pais ) );
        dtoe.setOidMarca( new Long( marca ) );
        dtoe.setOidCanal( new Long( canal ) );
        dtoe.setAnyo( new Integer( anio ) );

        traza("grupoZona en pipe: " + grupoZona);
        Vector vGruposZonas = this.vectorDeItems(grupoZona, ",");
        Vector vActividades = null;

        if( actividad.equals( "" ) ){
            vActividades = new Vector();
        } else{
            traza("actividad en pipe: " + actividad);
            vActividades = this.vectorDeItems(actividad, ",");
        }

        Vector vFeriadosConsulta = null;

        vFeriadosConsulta = this.armarListaDeFeriadosConsulta( anio, vGruposZonas, vActividades );
    
        dtoe.setFeriados( vFeriadosConsulta );

        paramEntrada = new Vector();
        paramEntrada.add(dtoe);
        paramEntrada.add(new MareBusinessID("CRACargaCalendario"));

        traza("Antes CRACargaCalendario");    
        DruidaConector conectorBAcceso = conectar("ConectorConsultarCalendario", paramEntrada);
        traza("Despues CRACargaCalendario");
    
		DTOSalidaCalendario dtos = (DTOSalidaCalendario) conectorBAcceso.objeto("dtoSalida");

        /*
         * Construir los tags para el componente Calendario
         */
        Vector fecha      = null;
        Enumeration enum  = null;
        fecha             = dtos.getFecha();
        enum              = (fecha == null) ? null : fecha.elements();
        Date d            = null;
        String sd         = null; // para guardar el valor de una fecha en formato yyyy-mm-dd
        StringTokenizer sToken  = null; // usado para extraer yyyy, mm y dd del String de fecha
        String strAnio          = null;
        String strMes           = null;
        String strDia           = null;

        //Se obtienen los indicadores festivos
        Vector indFestivo = dtos.getIndicadorFestivo();
    
        Enumeration eIndFestivo = ( indFestivo == null ) ? null : indFestivo.elements();
        BigDecimal b = null;
        String strIndFestivo = null;

		/*
         * INICIO DE ASIGNACION DE ATRIBUTOS A CALENDARIO
         * Asignacion de fm y fM
         */
		Integer intAnno = null;
		intAnno = dtos.getAnno();

		//Si el anio viene vacio entonces es porque no hay festivos,
		//se agrego para que muestre correctamente el anio es caso de no existir datos
		if(intAnno == null){
			intAnno = new Integer(anio);
		}
		//if(intAnno != null){
            int iAnno = intAnno.intValue();
            String sFm = "11/" + (iAnno - 1);
            String sFM = "02/" + (iAnno + 1);
            asignarAtributo("CALENDARIO", "mical", "fm", sFm);
            asignarAtributo("CALENDARIO", "mical", "fM", sFM);
		//}

        //Se agregan las etiquetas FESTIVO que correspondan (si corresponden)
        Vector fers = new Vector();
        Hashtable hFers = new Hashtable();
        String fer  = null;

        if (enum != null) {
            while (enum.hasMoreElements()) {
                d = (Date) enum.nextElement();
                b = (BigDecimal) eIndFestivo.nextElement();
        
                strIndFestivo = null;
                if ( b.intValue() == 1 ) {
                    strIndFestivo = "F";
                } else {
                    strIndFestivo = "DON";
                }
        
                sd = d.toString();
                if (sd != null && sd.length() != 0) {
                    sToken = new StringTokenizer(sd, "-");
                    strAnio = null;
                    strMes = null;
                    strDia = null;
          
                    if (sToken.hasMoreTokens()) {
                        strAnio = sToken.nextToken();
                    }
                    if (sToken.hasMoreTokens()) {
                        strMes = sToken.nextToken();
                    }
                    if (sToken.hasMoreTokens()) {
                        strDia = sToken.nextToken();
                    }

                    /*
                     * Si se obtuvieron los datos Mes y Dia, se crea una nueva etiqueta
                     * HTML <FESTIVOS> con esa fecha y se agrega al StringBuffer
                     * Anio no es necesario ya que Calendario no lo considera.
                     */
                    if (strMes != null && strMes.length() != 0 &&
                        strDia != null && strDia.length() != 0 &&
                        strAnio != null && strAnio.length() != 0 &&
                        strIndFestivo != null && strIndFestivo.length() != 0) {

                        //El Vector fers se pasa luego al metodo getElementFromVector
                        //para obtener el Element correspondiente y asignarlo al Calendario.
                        fer = strDia + "|" + strMes + "|" + strAnio;

                        if (hFers.containsKey(fer)) {
                            String tipoFest = (String) hFers.get(fer);
                            //Si es DON (No laborable) entonces pongo el nuevo, es decir, será festivo o seguirá como no laborable
                            if (tipoFest.equals("DON"))
                                hFers.put(fer,strIndFestivo);
                        } else {
                            hFers.put(fer, strIndFestivo);
                        }
                        
                        //if( ! this.buscarEnVector( fers, fer ) ) {
                        //    fer += "|" + strIndFestivo; //se agrega el indicador festivo
                        //    fers.add( fer );
                        //}
                        
                    } //if
                } //if
            } // while

            //Convierto la hash en el vector correspondiente
            Enumeration en = hFers.keys();
            while (en.hasMoreElements()) {
                String clave = (String) en.nextElement();
                fers.add(clave + "|" + hFers.get(clave));
            }
        } //if 

		/*
         * Se asignan los festivos al calendario
         * colocando los valores en la REJILLA ubicada dentro de CALENDARIO
         */
        Element elll = this.getElementFromVector( fers );
        DruidaConector dr = new DruidaConector();
        dr.setXML( elll );
		traza("El calenda:"+dr.getXML());

        asignar("REJILLA", "salida", dr);

        //Se hace visible la capa inferior, que contiene el calendario
        asignarAtributo( "CALENDARIO", "mical", "visibilidad", "visible" );

        this.cargarCombosMarcaCanal();

        //Menu Secundario
        if( casoDeUso.equalsIgnoreCase( "modificar" ) ){
            this.getConfiguracionMenu( "LPMantieneCalendario", "cargarCalendario" );
        }
        else if( casoDeUso.equalsIgnoreCase( "consultar" ) ){
            this.asignarAtributoPagina( "cod", "088" );
            this.getConfiguracionMenu( "LPMantieneCalendario", "muestraConsulta" );
        }
    }


    /**
     * Devuelve un Vector de objetos DTOFeriado (Marcelo Maidana)
     */
    private Vector armarListaDeFeriados() throws Exception {
        //Se obtiene la lista de festivos de sesion
        //en un String con formato '06/01/2004|09/07/2004|...'
        DTOFeriado dtof           = null;
        Vector vectorFeriados     = new Vector();
        Enumeration enumSQLDates  = vFeriados.elements();
        Enumeration eGruposZonas  = vGruposZonas.elements();
        Date fechaAGrabar         = null;

        //Con los datos reunidos se crea el objeto DTOFeriado
        //y se lo agrega a un nuevo vector.
        while( enumSQLDates.hasMoreElements() ){
            fechaAGrabar = (Date)enumSQLDates.nextElement();
            for( int i = 0; i < vGruposZonas.size(); i++ ){
                dtof = new DTOFeriado();
                dtof.setAnio( new Integer( anio ) );
                dtof.setDiaFeriado( fechaAGrabar );
                dtof.setIndicadorFestivo( Boolean.FALSE );
                dtof.setIndicadorNoLaborable( Boolean.TRUE );
                dtof.setOidGrupoZona( new Long( (String)vGruposZonas.get(i) ) );

                //Auditoria
                dtof.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
                dtof.setPrograma( UtilidadesSession.getFuncion(this) );
          
                vectorFeriados.add( dtof );
            }
        }
        //Se retorna un String de DTOFeriado
        return vectorFeriados;
    }


    /**
     * Recibe un String con elementos separada por tokens y el separados.
     * Se devuelve un Vector con elementos contenidos en el String utilizando el pipe.
     * Ejemplo: para el String 12|17|8 y el separador "|" retorna el vector [12,17,8].
     */
    private Vector vectorDeItems( String items, String separador ) throws Exception {
        Vector vItems = new Vector();
    
        if( items != null && items.indexOf( separador ) >= 0 ) {
            StringTokenizer strToken = new StringTokenizer( items, separador );
            while( strToken.hasMoreTokens() ){
                vItems.add( strToken.nextToken() );
            }
        }
        else {
            vItems.add( items );
        }
        return vItems;
    }


    /**
     * Funciona de manera similar a armarListaDeFeriados().
     * Pero este metodo se utiliza en la consulta, con todas las combinaciones de
     * anio, Grupos de Zonas y Actividades.
     */
    private Vector armarListaDeFeriadosConsulta( String anio, Vector gruposZonas, Vector actividades ) throws Exception {
        //gruposZonas: Vector de Strings
        //actividades: Vector de Strings

        DTOFeriado dto = null;
        Vector vector = new Vector();
        Integer iAnio = new Integer( anio );
        int i;
        int j;

        if( gruposZonas != null && actividades != null && 
                gruposZonas.size() > 0 && actividades.size() > 0 ) {
            for( i = 0; i < gruposZonas.size(); i++ ){
                for( j = 0; j < actividades.size(); j++ ){
                    dto = this.crearDTOFeriado( anio, gruposZonas.get( i ).toString(), actividades.get( j ).toString() );
                    vector.add( dto );
                }
            }
        }
        else if( gruposZonas != null && gruposZonas.size() > 0 ){
            for( i = 0; i < gruposZonas.size(); i++ ){
                dto = this.crearDTOFeriado( anio, gruposZonas.get( i ).toString(), null );
                vector.add( dto );
            }
        }
        else if( actividades != null && actividades.size() > 0 ){
            for( j = 0; j < actividades.size(); j++ ){
                dto = this.crearDTOFeriado( anio, null, actividades.get( j ).toString() );
                vector.add( dto );
            }
        }
        else{
            return vector;
        }
        return vector;
    }


    /**
    * Devuelve un DTOFeriado con los datos que se reciben. Es usado por el 
    * metodo armarListaDeFeriadosConsulta.
    */
    private DTOFeriado crearDTOFeriado( String anio, String grupoZonas, String actividad ) throws Exception {
        DTOFeriado dto = new DTOFeriado();
        dto.setAnio( (anio == null) ? null : new Integer(anio) );
        dto.setOidGrupoZona( (grupoZonas == null) ? null : new Long( grupoZonas ) );
        dto.setOidActividad( (actividad == null) ? null : new Long( actividad ) );

        return dto;
    }


    /**
     * 
     */
    private void logStackTrace(Throwable e) throws Exception{
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException){
          MareException e2 = (MareException)e;
          traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }


    /**
     * Retorna true si el string s esta en el Vector v.
     */
    private boolean buscarEnVector( Vector v, String s ) throws Exception {
        String date = "";
        Enumeration e = v.elements();

        while( e.hasMoreElements() ){
            date = (String)e.nextElement();
            if( date.equals( s ) ){
                return true;
            }
        }
        return false;
    }


    /**
     * Retorna Element con los los festivos que corresponden al calendario.
     */
    private Element getElementFromVector( Vector fers ) throws Exception {
        DocumentBuilder docBuild = null;
        docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = docBuild.newDocument();
        Element raiz = doc.createElement("FESTIVOS");
        doc.appendChild(raiz);
        Element festivo = null;
        Enumeration e   = null;
        String fer      = null;
        String dia      = null;
        String mes      = null;
        String anio     = null;
        String tipo     = null; //tipo de feriado --> F(Festivo) o DOM(No Festivo)

        if( fers != null && fers.size() > 0 ){
            e = fers.elements();

            while( e.hasMoreElements() ){
                //Se obtiene un String con el formato "dia|mes|anio"
                fer = (String)e.nextElement();

                StringTokenizer st = new StringTokenizer( fer, "|" );
                dia = st.nextToken();
                mes = st.nextToken();
                anio = st.nextToken();
                tipo = st.nextToken();

                festivo = doc.createElement("FESTIVO");
                festivo.setAttribute("dia", dia);
                festivo.setAttribute("mes", mes);
                festivo.setAttribute("anio", anio);

                //tipo de feriado
                festivo.setAttribute("id", tipo);
                doc.getDocumentElement().appendChild( festivo );
            }
        }
        return doc.getDocumentElement();
    }


    /**
    * Devuelve un Vector de objetos DTOFeriado (Marcelo Maidana)
    */
    private Vector armarListaDeFeriadosModificar() throws Exception {
        traza("armarListaDeFeriadosModificar()");
        //Se obtiene la lista de festivos de sesion
        //en un String con formato '06/01/2004|09/07/2004|...'
        DTOFeriado dtof = null; 

        String listaFestivos = (String)conectorParametro("listaFestivos");
        String listaTipoFestivos = (String)conectorParametro("listaTipoFestivos");
        String anio = (String)conectorParametro("txtAnio");
        
		traza("anio : " + anio);
		traza("Lista de festivos traidos desde la pagina : "+listaFestivos);
		traza("Y Lista de Tipos festivos traidos desde la pagina : "+listaTipoFestivos);

		//Se crea un StringTokenizer para obtener cada uno de los anios en el String
        StringTokenizer fechas = new StringTokenizer(listaFestivos,"|");
        Vector vecFechas = new Vector();

        //Se agrega la fecha en formato String al Vector
        while (fechas.hasMoreTokens()) {
            String fecha = fechas.nextToken();
            vecFechas.addElement(fecha);
        }

        //Se crear un StringTokenizer para los tipos de feriados
        StringTokenizer tipos = new StringTokenizer( listaTipoFestivos, "|" );
        Vector vecTipos = new Vector();

        //Se agregan los tipos de de feriados String al Vector
        while (tipos.hasMoreTokens()) {
            String tipo = tipos.nextToken();
            vecTipos.addElement(tipo);
        }

        Vector vecSQLDatesFiltrado = new Vector();
        Vector vecTiposFiltrado = new Vector();

        //Se recorre el Vector de fechas para formatear cada uno de los datos
        //que componen la fecha.
        //Se crea el objeto fecha correspondiente a cada uno de estos strings
        //y se lo agrega a un nuevo vector.
		//Se filtran la fechas y tipos de feriados del año con actual seleccionado.
        for (int i = 0; i < vecFechas.size(); i++) {
            String f = (String) vecFechas.elementAt(i);
            String tipoFeri = (String) vecTipos.elementAt(i);

            //Se crea el StringTokenizer para separar dia, mes y anio
            StringTokenizer parseFecha = new StringTokenizer(f,"/");
            String dia = parseFecha.nextToken();
            String mes = parseFecha.nextToken();
            String nanio = parseFecha.nextToken();
                           
            if(dia.length() == 1){dia = "0" + dia;}
            if(mes.length() == 1){mes = "0" + mes;}

            //Se crea el objeto Date en base al String
            if (nanio.equals(anio)){
                // Solo se toman las fechas del anio actual seleccionado
                Date date = Date.valueOf(nanio +"-"+ mes +"-"+ dia); // yyyy-mm-dd
                vecSQLDatesFiltrado.add(date);
				vecTiposFiltrado.add(tipoFeri);
            }
        }

        Vector vectorFeriados     = new Vector();
        Enumeration enumSQLDates  = vecSQLDatesFiltrado.elements();

        traza("grupoZona con separadores: " + grupoZona);
        Vector vGruposZonas       = this.vectorDeItems(grupoZona, "|" );
        traza("actividad con separadores: " + actividad);
        Vector vActividades       = this.vectorDeItems(actividad, "|");
        Enumeration eGruposZonas  = vGruposZonas.elements();
        Enumeration eActividades  = vActividades.elements();
        Date fechaAGrabar         = null;

        //Se obtiene el Enumeration con los tipos de Feriado
        //Estos pueden ser: 'DON' --> Feriado no festivo
        //                  'F'   --> Feriado festivo
        Enumeration eTipos = vecTiposFiltrado.elements();
        String tipoFeriado = null;

		traza("vecSQLDatesFiltrado.size(): " + vecSQLDatesFiltrado.size()  );
		traza("vecTiposFiltrado.size(): " + vecTiposFiltrado.size()  );
		
		//Con los datos reunidos se crea el objeto DTOFeriado
        //y se lo agrega a un nuevo vector.
        while( enumSQLDates.hasMoreElements() ){
            fechaAGrabar = (Date)enumSQLDates.nextElement();
            tipoFeriado = (String)eTipos.nextElement();

            for( int i = 0; i < vGruposZonas.size(); i++ ){
                for( int j = 0; j < vActividades.size(); j++ ){
                    dtof = new DTOFeriado();
                    dtof.setAnio( new Integer( anio ) );
                    dtof.setDiaFeriado( fechaAGrabar );

                    dtof.setIndicadorFestivo( Boolean.FALSE );
                    if( tipoFeriado != null && tipoFeriado.equals( "DON" ) ){
                        dtof.setIndicadorFestivo( Boolean.FALSE );
                    }
                    else if( tipoFeriado != null && tipoFeriado.equals( "F" ) ){
                        dtof.setIndicadorFestivo( Boolean.TRUE );
                    }

                    dtof.setIndicadorNoLaborable( Boolean.TRUE );
                    dtof.setOidGrupoZona( new Long( (String)vGruposZonas.get(i) ) );
                    dtof.setOidActividad( new Long( (String)vActividades.get(j) ) );

                    //Auditoria
                    dtof.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
                    dtof.setPrograma( UtilidadesSession.getFuncion(this) );
                    vectorFeriados.add( dtof );
                }
            }
        }
        //Se retorna un String de DTOFeriado
        return vectorFeriados;
    }
}

