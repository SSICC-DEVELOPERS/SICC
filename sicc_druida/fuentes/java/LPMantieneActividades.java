
//import LPSICCBase; CRA-02

import es.indra.druida.DruidaConector;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


import java.util.StringTokenizer;

import java.util.Vector;


public class LPMantieneActividades extends LPSICCBase {
    private Long oidIdioma = null;
    private String strOidIdioma = null;
    private Long oidPais = null;
    private Long marca = null;
    private String strCanal = null;
    private String strMarca = null;
    private String valueCanal = null;
    private String valueMarca = null;
    private Long oidClaseActividad = null;
    private Long canal = null;
    private String descripcionActividad = null;
    private String nombreActividad = null;
    private String descripcionTipoActividad = null;
    private String descripcionActividadOrigen = null;
    private String descripcionAreaResponsable = null;
    private String descripcionEbelNoticia = null;
    private String descripcionTipoDireccion = null;
    private String numeroCampanaAntelacion = null;
    private String procesoAsignado = null;
    private String cantidadProcesoDisponibles = null;
    private String numeroDiasDesplazamiento = null;
    private String numeroCampanasDesplazamiento = null;
    private Long oidMensaje = null;
    private String indicadorDiasLaborables = null;
    private String codigoTipoActividad = null;
    private String codigoClaseActividad = null;
    
    private String codigoActividad = null;
    private String codigoActividadOrigen = null;
    private String oidActividadOrigen = null;
    private String hCasoDeUso = null;
    private String oidDepartamento = null;
    private Long oidAcceso = null;
    private Long oidTipoDireccion = null;
    private String indicadorEbelNoticia = null;
    private String indicadorFestivos = null;
    private String descripcionCodigoOrigen = null;
    private String descripcionLarga = null;
    private String strOidPais = null;
    private String descPais = null;
    private String accion = null;
    private String casoDeUso = null;
    private Long oid = null;
    private String IPCliente = null;
    private String programa = null;
    private String oidMarcaParaCombo = null;
    private String oidCanalParaCombo = null;
    private Long oidMarcaDef = null;
    private Long oidCanalDef = null;

	public LPMantieneActividades() {
        super();
    }

    public void inicio() throws Exception {
    }

    /* 
      **************************************************************************
                                        METODO EJECUCCION
      **************************************************************************
    */ 
    public void ejecucion() throws Exception {
        try {
            setTrazaFichero();
            rastreo();

            traza(
                "*************** Entre a LPMantieneActividades ***************");

            accion = conectorParametroLimpia("accion", "", true);
            hCasoDeUso = conectorParametroLimpia("hCasoDeUso", "", true);

            traza("*************  entrada-accion : " + accion);
            traza("************* entrada-hCasoDeUso :" + hCasoDeUso);

            // cargo variables de sesion
            this.oidIdioma = UtilidadesSession.getIdioma(this);

            this.strOidIdioma = oidIdioma.toString();
            this.oidPais = UtilidadesSession.getPais(this);
            this.strOidPais = oidPais.toString();
            this.descPais = UtilidadesSession.getDescripcionPais(this);
            this.IPCliente = UtilidadesBelcorp.getIPCliente(this);
            this.programa = UtilidadesSession.getFuncion(this);
            this.oidMarcaDef = UtilidadesSession.getMarcaPorDefecto(this); 
            this.oidCanalDef = UtilidadesSession.getCanalPorDefecto(this);

            if (accion.equals("modificar")) {
                traza("********** TRAE DATOS PARA MODIFICAR*****************");
               this.asignarAtributo("VAR", "hCasoDeUso", "valor", "modificar");
                this.traeDatos();
                this.modifica();
            }

            if (accion.equals("consultar")) {
                traza("********** TRAE DATOS PARA CONSULTAR************");
                this.traeDatos();
                this.consultar();
            }

            if (accion.equals("muestraConsulta")) {
                muestraBuscar();
            }

            if (accion.equals("muestraBorrado")) {
                muestraBuscar();
            }

            if (accion.equals("muestraModificacion")) {
                muestraBuscar();
            }

            if (accion.equals("muestraInsercion")) {
                muestraInsertar();
            }

            if (accion.equals("guardar")) {                  
                  this.guarda();
            }

            if (accion.equals("guardar_mod")) {
                this.guarda();
                
            }            
        } catch (Exception ex) {           
  			//preservaHiddensI18n(new Integer(1),"CRA_ACTIV", "frmInsertarActividades", "txtdesActividad", true);
            this.logStackTrace(ex);
            this.lanzarPaginaError(ex);            
        }
    }



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

    }//logStackTrace()





    /* 
      **************************************************************************
                                        METODO TRAE DATOS 
      **************************************************************************
    */ 
    
    private void traeDatos() throws Exception {

        traza ("entra a trae datos");
        this.pagina("contenido_actividades_insertar");
        traza ("despues de pagina");

        this.casoDeUso = (conectorParametro("hCasoDeUso") == null) ? "" : conectorParametro("hCasoDeUso");
   
        if (((conectorParametro("oid") != null) && (!(conectorParametro("oid").equals(""))))){
           this.oid = Long.valueOf(conectorParametro("oid"));
        }
               
        this.marca = ((conectorParametro("marca") == null) ? "": conectorParametro("marca")).equals("") ? null : Long.valueOf((conectorParametro("marca") == null) ? "" : conectorParametro("marca"));
        this.canal = ((conectorParametro("canal") == null) ? "": conectorParametro("canal")).equals("") ? null : Long.valueOf((conectorParametro("canal") == null) ? "" : conectorParametro("canal"));
        this.strCanal = (conectorParametro("strCanal") == null) ? "" : conectorParametro("strCanal");
        this.strMarca = (conectorParametro("strMarca") == null) ? "" : conectorParametro("strMarca");
        this.valueMarca = (conectorParametro("valueMarca") == null) ? "" : conectorParametro("valueMarca");
        this.valueCanal = (conectorParametro("valueCanal") == null) ? "" : conectorParametro("valueCanal");
        traza("TRAE DATOS -----> CASO DE USO" + this.casoDeUso);

        
        DTOActividad dtoa = new DTOActividad();
        DTOSalida dtos = new DTOSalida();
        traza("el oid es " + oid);
        dtoa.setOid(oid);
        dtoa.setOidPais(oidPais);
        //dtoa.setOidCanal(canal);
        //dtoa.setOidMarca(marca);
        dtoa.setOidIdioma(oidIdioma);

        Vector vec = new Vector();
        MareBusinessID id_bus = new MareBusinessID("CRAConsultarActividades");
        vec.add(dtoa);
        vec.add(id_bus);

        DruidaConector conectorConsultarActividades = conectar("ConectorObjeto", vec);

        dtos = (DTOSalida) conectorConsultarActividades.objeto("DTOSalida");

        if ((dtos.getResultado().getValueAt(0, 0)) != null) {
            this.oid = new Long((dtos.getResultado().getValueAt(0, 0)).toString());
        }

        if ((dtos.getResultado().getValueAt(0, 1)) != null) {
            this.descripcionActividad = (dtos.getResultado().getValueAt(0, 1)).toString();
        } else {
             this.descripcionActividad = ""; // Descripcion de la clase que de la Actividad
        }

        if ((dtos.getResultado().getValueAt(0, 3)) != null) {
             this.nombreActividad = (dtos.getResultado().getValueAt(0, 3)).toString();
        } else {
             this.nombreActividad = ""; // Nombre de la Actividad de I18n
        }

        if ((dtos.getResultado().getValueAt(0, 4)) != null) {
            this.descripcionTipoActividad = (dtos.getResultado().getValueAt(0, 4)).toString();
        } else {
            this.descripcionTipoActividad = ""; //Descripcion del tipo de la actividad Origen/Fija/Ref. Otra Campaña
        }
		
		/*inicio enozigli 30/10/2007 modificado por COL-CRA-001*/
        if ((dtos.getResultado().getValueAt(0, 5)) != null) {
            this.numeroCampanasDesplazamiento = (dtos.getResultado().getValueAt(0, 5)).toString();
        } else {
            this.numeroCampanasDesplazamiento = ""; // Campañas Desplazamiento Puede ser Nulo
        }


        if ((dtos.getResultado().getValueAt(0, 6)) != null) {
            this.descripcionActividadOrigen = (dtos.getResultado().getValueAt(0, 6)).toString();
        } else {
            this.descripcionActividadOrigen = ""; // DESCRIPCION ACTIVIDAD ORIGEN Puede ser Nulo
        }


        if ((dtos.getResultado().getValueAt(0, 7)) != null) {
            this.descripcionAreaResponsable = (dtos.getResultado().getValueAt(0, 7)).toString();
        } else {
            this.descripcionAreaResponsable = ""; // Descripcion del area responsable
        }

        if ((dtos.getResultado().getValueAt(0, 8)) != null) {
            this.descripcionEbelNoticia = (dtos.getResultado().getValueAt(0, 8)).toString();
        }  //Descripcion Ebel Noticia - Si/No


        if ((dtos.getResultado().getValueAt(0, 9)) != null) {
          this.descripcionTipoDireccion = (String) (dtos.getResultado().getValueAt(0, 9));
            } // Descripcion tipo direccion 



        if ((dtos.getResultado().getValueAt(0, 10)) != null) {
            this.numeroCampanaAntelacion = (dtos.getResultado().getValueAt(0, 10)).toString();
        } else {
            this.numeroCampanaAntelacion = "";
        }  // Numero Campana Antelacion - Puede Ser nul
      


        if ((dtos.getResultado().getValueAt(0, 11)) != null) {
            this.procesoAsignado = (dtos.getResultado().getValueAt(0, 11)).toString();
        } else {
            this.procesoAsignado = "";
        }  // Cantidad de Procesos Asignados



        if ((dtos.getResultado().getValueAt(0, 12)) != null) {
            this.cantidadProcesoDisponibles = (dtos.getResultado()
                                                   .getValueAt(0, 12)).toString();
        } else {
            this.cantidadProcesoDisponibles = "";
        } // Cantidad Procesos Disponibles
        

        if ((dtos.getResultado().getValueAt(0, 13)) != null) {
            this.numeroDiasDesplazamiento = (dtos.getResultado()
                                                 .getValueAt(0, 13)).toString();
        } else {
            this.numeroDiasDesplazamiento = "";
        } // NUMERO DE DIAS DESPLAZAMIENTO


		//16 cod mensaje
			
        if ((dtos.getResultado().getValueAt(0, 16)) != null) {
            this.codigoTipoActividad = (dtos.getResultado().getValueAt(0, 16)).toString();
        } else {
            this.codigoTipoActividad = "";
        }// CODIGO TIPO ACTIVIDAD Toma el codigo del Combo del Tipo Actividad



        if ((dtos.getResultado().getValueAt(0, 17)) != null) {
            this.codigoActividad = (dtos.getResultado().getValueAt(0, 17)).toString();
        } else {
            this.codigoActividad = "";
        }// CODIGO ACTIVIDAD


        if ((dtos.getResultado().getValueAt(0, 18)) != null) {
            this.codigoActividadOrigen = (dtos.getResultado().getValueAt(0, 18)).toString();
        } 
          // oid ACTIVIDAD ORIGEN

        if ((dtos.getResultado().getValueAt(0, 19)) != null) {
            this.valueMarca = (dtos.getResultado().getValueAt(0, 19).toString());
        }


        if ((dtos.getResultado().getValueAt(0, 20)) != null) {
            this.valueCanal = (dtos.getResultado().getValueAt(0, 20)).toString();
        }


        if ((dtos.getResultado().getValueAt(0, 21)) != null) {
            this.oidDepartamento = (dtos.getResultado().getValueAt(0, 21)).toString();
        }


        if ((dtos.getResultado().getValueAt(0, 22)) != null) {
            this.oidAcceso = (Long.valueOf((dtos.getResultado().getValueAt(0, 22)).toString()));
        }

        // OID ACCESO
        if ((dtos.getResultado().getValueAt(0, 23)) != null) {
            this.oidTipoDireccion = (Long.valueOf((dtos.getResultado().getValueAt(0, 23)).toString()));
            
        }


        //  OID TIPO DIRECCION
        if ((dtos.getResultado().getValueAt(0, 24)) != null) {
            this.indicadorEbelNoticia = (dtos.getResultado().getValueAt(0, 24)).toString();
        } else {
            this.indicadorEbelNoticia = "";
        }


        // IND EBEL
        traza("IND EBEL: "+dtos.getResultado().getValueAt(0, 25));
        if ((dtos.getResultado().getValueAt(0, 25)) != null) {
            this.indicadorFestivos = (dtos.getResultado().getValueAt(0, 25)).toString();
        } else {
            this.indicadorFestivos = "";
        }

       traza("IND LABORABLES: "+dtos.getResultado().getValueAt(0, 14));
        if ((dtos.getResultado().getValueAt(0, 14)) != null) {
            this.indicadorDiasLaborables = (dtos.getResultado().getValueAt(0, 14)).toString();
        } else {
            this.indicadorDiasLaborables = "";
        } // INDICADOR DIAS LABORABLES

        

        // IND FESTIVO
        if ((dtos.getResultado().getValueAt(0, 26)) != null) {
            this.descripcionCodigoOrigen = (dtos.getResultado().getValueAt(0, 26)).toString();
        } else {
            this.descripcionCodigoOrigen = "";
        }


        // CODIGO ORIGEN
        if ((dtos.getResultado().getValueAt(0, 27)) != null) {
            this.descripcionLarga = (dtos.getResultado().getValueAt(0, 27)).toString();
        } else {
            this.descripcionLarga = "";
        }
        // DESCRIPCION LARGA
        
        if ((dtos.getResultado().getValueAt(0, 28)) != null) {
            this.codigoClaseActividad = (dtos.getResultado().getValueAt(0, 28)).toString();
        } else {
            this.codigoClaseActividad = "";
        }
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/
		
		if ((dtos.getResultado().getValueAt(0, 29)) != null) {
            this.oidMensaje = (Long.valueOf((dtos.getResultado().getValueAt(0, 29)).toString()));
        }
       	

        
    }


    /* 
      **************************************************************************
                                        METODO CONSULTAR 
      **************************************************************************
    */ 


    
    private void consultar() throws Exception {
        traza("===========================> ENTRA A: METODO CONSULTAR");


        // Para cargar los combos
        muestraInsertar();
        getConfiguracionMenu("LPMantieneActividades", "detalle");
		    this.asignarAtributoPagina("cod", "092");
        this.asignarAtributo("LABELC", "lblPaisActual", "valor", descPais);
        this.asignarAtributo("CTEXTO", "txtcdActividad", "valor",(this.codigoActividad).toString());
        this.asignarAtributo("CTEXTO", "txtdesActividad", "valor",this.nombreActividad);
		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
		this.asignarAtributo("CTEXTO", "txtCampDesp", "valor",
            this.numeroCampanasDesplazamiento);
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

        if((this.codigoActividadOrigen != null) && (!this.codigoActividadOrigen.equals(""))){
           this.asignarAtributo("VAR", "oidActRef", "valor",this.codigoActividadOrigen);
        }
        this.asignarAtributo("CTEXTO", "txtActRef", "valor",this.descripcionCodigoOrigen);
        this.asignarAtributo("CTEXTO", "txtDias", "valor",this.numeroDiasDesplazamiento);
        this.asignarAtributo("CTEXTO", "txtCampaAntela", "valor",this.numeroCampanaAntelacion);
        this.asignarAtributo("VAR", "hCasoDeUso", "valor", "consultar");
        this.asignarAtributo("VAR", "valueMarca", "valor",(this.valueMarca).toString());
        this.asignarAtributo("VAR", "valueCanal", "valor",(this.valueCanal).toString());
       // ACA TENGO Q ASIGANAR TODOS LOS CODIGO DE LOS CB
        this.asignarAtributo("VAR", "areaResponsable", "valor",(this.oidDepartamento));
        this.asignarAtributo("VAR", "ClaseActividad", "valor",(this.codigoClaseActividad));
        this.asignarAtributo("VAR", "diaLaborable", "valor", this.indicadorDiasLaborables);
        this.asignarAtributo("VAR", "codigoTipoActividad", "valor",(this.codigoTipoActividad));
        this.asignarAtributo("VAR", "ebelNoticia", "valor",(this.indicadorEbelNoticia));
		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
		this.asignarAtributo("VAR", "hCampDespl", "valor",(this.numeroCampanasDesplazamiento));
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

        if (this.oidTipoDireccion == null){  
           this.asignarAtributo("VAR", "tipoDireccionOid", "valor","");
        }else{   
           this.asignarAtributo("VAR", "tipoDireccionOid", "valor",(this.oidTipoDireccion).toString());
        }
    
		if (this.oidMensaje == null){  
           this.asignarAtributo("VAR", "mensajeOid", "valor","");
        }else{   
           this.asignarAtributo("VAR", "mensajeOid", "valor",(this.oidMensaje).toString());
        }
    }


    /* 
      **************************************************************************
                                        METODO MODIFICA 
      **************************************************************************
    */ 

    
    private void modifica() throws Exception {
        traza("===========================> ENTRA A: METODO MODIFICA");
        
        // Para cargar los combos
        muestraInsertar();
        getConfiguracionMenu("LPMantieneActividades", "modificar");

        this.asignarAtributoPagina("cod", "091");

        this.asignarAtributo("LABELC", "lblPaisActual", "valor", descPais);
        this.asignarAtributo("CTEXTO", "txtcdActividad", "valor",
            (this.codigoActividad).toString());

        this.asignarAtributo("CTEXTO", "txtdesActividad", "valor",
            this.nombreActividad);

		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
		this.asignarAtributo("CTEXTO", "txtCampDesp", "valor",
            this.numeroCampanasDesplazamiento);
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

        if((this.codigoActividadOrigen != null) && (!this.codigoActividadOrigen.equals(""))){
           this.asignarAtributo("VAR", "oidActRef", "valor", this.codigoActividadOrigen);
        }

        this.asignarAtributo("CTEXTO", "txtDias", "valor",
            this.numeroDiasDesplazamiento);
        this.asignarAtributo("CTEXTO", "txtCampaAntela", "valor",
            this.numeroCampanaAntelacion);

        this.asignarAtributo("VAR", "hCasoDeUso", "valor", "modificar");

        this.asignarAtributo("VAR", "valueMarca", "valor", (this.valueMarca));
        this.asignarAtributo("VAR", "valueCanal", "valor", (this.valueCanal));
        this.asignarAtributo("VAR", "oid", "valor", (this.oid).toString());

        
        this.asignarAtributo("VAR", "nombreActividad", "valor", this.nombreActividad);
        this.asignarAtributo("VAR", "codigoActividad", "valor",(this.codigoActividad).toString());
        this.asignarAtributo("VAR", "codigoActividadOrigen", "valor", this.descripcionCodigoOrigen);
        this.asignarAtributo("VAR", "diasDesplazamiento", "valor", this.numeroDiasDesplazamiento);
        this.asignarAtributo("VAR", "campanasAntelacion", "valor", this.numeroCampanaAntelacion);
        this.asignarAtributo("VAR", "codigoTipoActividad", "valor", (this.codigoTipoActividad));
        this.asignarAtributo("VAR", "areaResponsable", "valor", this.oidDepartamento);
        this.asignarAtributo("VAR", "diaLaborable", "valor", this.indicadorDiasLaborables);
        this.asignarAtributo("VAR", "ClaseActividad", "valor",(this.codigoClaseActividad));
        this.asignarAtributo("VAR", "ebelNoticia", "valor",(this.indicadorEbelNoticia));
		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
		this.asignarAtributo("VAR", "hCampDespl", "valor",(this.numeroCampanasDesplazamiento));
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

        if (this.oidTipoDireccion == null)  this.asignarAtributo("VAR", "tipoDireccionOid", "valor","");
         else   this.asignarAtributo("VAR", "tipoDireccionOid", "valor",(this.oidTipoDireccion).toString());

	
		if (this.oidMensaje == null){  
           this.asignarAtributo("VAR", "mensajeOid", "valor","");
        }else{   
           this.asignarAtributo("VAR", "mensajeOid", "valor",(this.oidMensaje).toString());
        }
	}
    /* 
      **************************************************************************
                                        METODO MUESTRA INSETAR 
      **************************************************************************
    */ 

    
    private void muestraInsertar() throws Exception {
        traza("===========================> ENTRA A: MUESTRA INSERTAR");      
    
        pagina("contenido_actividades_insertar");
        this.asignarAtributo("VAR", "accion", "valor", this.accion);
      
       
        if (accion.equals("modificar")){
              
            this.anyadeHiddensI18N(true,"CRA_ACTIV", this.oid, new Integer(1), "frmInsertarActividades", "txtdesActividad", false);
        } else if  (accion.equals("consultar")){
            this.anyadeHiddensI18N(true,"CRA_ACTIV", this.oid, new Integer(1), "frmInsertarActividades", "txtdesActividad", true);
        } else {        
            this.anyadeHiddensI18N(true,"CRA_ACTIV", null, new Integer(1), "frmInsertarActividades", "txtdesActividad", false);
        } 
        
        getConfiguracionMenu("LPMantieneActividades", "");

        this.asignarAtributo("LABELC", "lblPaisActual", "valor", descPais);

        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);        

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGConsultaCanales");
        ci1.setDTOE(dtoe);
        

        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness("SEGConsultaMarcas");
        ci2.setDTOE(dtoe);
        

        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("CRAObtieneClasesActividades");
        ci3.setDTOE(dtoe);

        ComposerViewElement ci4 = new ComposerViewElement();
        ci4.setIDBusiness("SEGObtenerDepartamentos");
        ci4.setDTOE(dtoe);
        
        ComposerViewElement ci5 = new ComposerViewElement();
        ci5.setIDBusiness("MAEObtenerTiposDireccion");
        ci5.setDTOE(dtoe);

		ComposerViewElement ci9 = new ComposerViewElement();
        ci9.setIDBusiness("CRAObtieneMensajesCRA");
        ci9.setDTOE(dtoe);
        

        DTOActividad dtoa = new DTOActividad();
        dtoa.setOidPais(oidPais);
        dtoa.setOidIdioma(oidIdioma);

        // Cuando va a insertar es null, cuando esta por Modificar se pone el oid
        if (accion.equalsIgnoreCase("MuestraInsercion")){
            dtoa.setOid(null);
        }else {
            dtoa.setOid(this.oid);
        }       

        ComposerViewElement ci6 = new ComposerViewElement();
        ci6.setIDBusiness("CRAObtieneProcesos");
        ci6.setDTOE(dtoa);
        
        ComposerViewElement ci7 = new ComposerViewElement();
        if (dtoa.getOid() != null) {                  
            ci7.setIDBusiness("CRAObtieneProcesosAsignados");
            ci7.setDTOE(dtoa);
        }
        
        //Carga del los valores del combo actividadOrigen 
        // Si oidMarca y oidCanal<>NULL entonces (atributos privados de la LP)
        ComposerViewElement ci8 = new ComposerViewElement();

        DTOActividad dtoa2 = new DTOActividad();
        dtoa2.setOidPais(oidPais);
        dtoa2.setOidIdioma(oidIdioma);

        if((this.valueCanal != null) && (this.valueMarca != null) && (!this.valueCanal.equals("")) && (!this.valueMarca.equals("")) ){
            if (accion.equalsIgnoreCase("MuestraInsercion")) {
                dtoa2.setOid(null);
            }else{
                dtoa2.setOid(this.oid);
            }

            dtoa2.setOidMarca(new Long(this.valueMarca));
            dtoa2.setOidCanal(new Long(this.valueCanal));
        }else{
            if (accion.equalsIgnoreCase("MuestraInsercion")) {
               dtoa2.setOid(null);
            }else{
               dtoa2.setOid(this.oid);
            } 
            dtoa2.setOidMarca(oidMarcaDef);
            dtoa2.setOidCanal(oidCanalDef);
        }
           
        ci8.setIDBusiness("CRAObtieneActividad"); 
        ci8.setDTOE(dtoa2);

        lista.addViewElement(ci1);
        lista.addViewElement(ci2);
        lista.addViewElement(ci3);
        lista.addViewElement(ci4);
        lista.addViewElement(ci5);
        lista.addViewElement(ci6);

        if (dtoa.getOid() != null) {
           lista.addViewElement(ci7);                    
        }

        lista.addViewElement(ci8);
		
		lista.addViewElement(ci9);
		//Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = null;
        resultados = conector.getConector();
		traza("resultados"+resultados);
        asignar("COMBO", "cbProcDisp", resultados, "CRAObtieneProcesos");
        asignar("COMBO", "cboCanales", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cboMarcas", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cboClaseAct", resultados, "CRAObtieneClasesActividades");
        asignar("COMBO", "cboAreaResp", resultados, "SEGObtenerDepartamentos");
        asignar("COMBO", "cbTipoDirec", resultados, "MAEObtenerTiposDireccion");

        if (dtoa.getOid() != null) {
           asignar("COMBO", "cbProcAsig", resultados, "CRAObtieneProcesosAsignados");
        }

        if(oidMarcaDef != null && oidCanalDef != null ){
           asignar("COMBO", "cbactividadRef", resultados, "CRAObtieneActividad"); 
        } 

        asignar("COMBO", "cbMensaje", resultados, "CRAObtieneMensajesCRA");

        if (accion.equalsIgnoreCase("MuestraInsercion")) {
            this.asignarAtributo("VAR", "valueMarca", "valor",oidMarcaDef.toString());
            this.asignarAtributo("VAR", "valueCanal", "valor", oidCanalDef.toString());
        }

        asignarAtributo("VAR", "varPais", "valor", UtilidadesSession.getPais(this).toString());
        asignarAtributo("VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
    }


    /* 
      **************************************************************************
                                        METODO MUESTRA BUSCAR  
      **************************************************************************
    */     
    private void muestraBuscar() throws Exception {
        traza("===========================> ENTRA A: MUESTRA BUSCAR");
     
        /*this.valueMarca = (conectorParametro("valueMarca") == null) ? ""
                                                                    : conectorParametro(
                "valueMarca");

        this.valueCanal = (conectorParametro("valueCanal") == null) ? ""
                                                                    : conectorParametro(
                "valueCanal");*/

        if (accion != null) {
            if (accion.equals("muestraInsercion")) {
                pagina("contenido_actividades_insertar");
                this.asignarAtributo("VAR", "hCasoDeUso", "valor", "");
                this.asignarAtributoPagina("cod", "050");              
            } else if (accion.equals("muestraModificacion")) {
                this.pagina("contenido_actividades_buscar");
                getConfiguracionMenu("LPMantieneActividades", "consultar");
                this.asignarAtributo("VAR", "hCasoDeUso", "valor", "modificar");
                this.asignarAtributoPagina("cod", "091");
            } else if (accion.equals("muestraConsulta")) {
                this.pagina("contenido_actividades_buscar");
                getConfiguracionMenu("LPMantieneActividades", "consultar");
                this.asignarAtributo("VAR", "hCasoDeUso", "valor", "consultar");
                this.asignarAtributoPagina("cod", "092");
            } else if (accion.equals("muestraBorrado")) {
                this.pagina("contenido_actividades_buscar");
                getConfiguracionMenu("LPMantieneActividades", "eliminar");
                this.asignarAtributo("VAR", "hCasoDeUso", "valor", "eliminar");
                this.asignarAtributoPagina("cod", "093");
            }
        }


        asignarAtributo("LABELC", "lblPaisActual", "valor", descPais);
        this.asignarAtributo("VAR", "hIdioma", "valor",
            ((oidIdioma == null) ? "" : oidIdioma.toString()));
        this.asignarAtributo("VAR", "hIPCliente", "valor",
            ((IPCliente == null) ? "" : IPCliente));
        this.asignarAtributo("VAR", "hPrograma", "valor",
            ((programa == null) ? "" : programa));
        this.asignarAtributo("VAR", "hPais", "valor",
            ((oidPais == null) ? "" : oidPais.toString()));

        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(oidPais);
        dtoe.setOidIdioma(oidIdioma);

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGConsultaCanales");
        ci1.setDTOE(dtoe);

        ComposerViewElement ci2 = new ComposerViewElement();
        ci2.setIDBusiness("SEGConsultaMarcas");
        ci2.setDTOE(dtoe);

        lista.addViewElement(ci1);
        lista.addViewElement(ci2);

        ConectorComposerView conector = new ConectorComposerView(lista,
                this.getRequest());
        conector.ejecucion();

        DruidaConector resultados = null;

        resultados = conector.getConector();

        asignar("COMBO", "cbCanales", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cbMarcas", resultados, "SEGConsultaMarcas");
        this.asignarAtributo("VAR", "valueMarca", "valor",oidMarcaDef.toString());
        this.asignarAtributo("VAR", "valueCanal", "valor", oidCanalDef.toString());
    }



    /* 
      **************************************************************************
                                        METODO GUARDA 
      **************************************************************************
    */ 
    
    private void guarda() throws Exception {
        traza("ENTRO AL METODO GUARDAR");
        //pagina("contenido_actividades_insertar");        

        this.valueMarca = (conectorParametro("valueMarca") == null) ? "": conectorParametro("valueMarca");
        this.valueCanal = (conectorParametro("valueCanal") == null) ? "": conectorParametro("valueCanal");
        
        if ((conectorParametro("oid") != null) && (!((conectorParametro("oid").equals(""))))){
            this.oid = Long.valueOf(conectorParametro("oid"));
        }               

        // Valor del Area Responsable
        if ((conectorParametro("cboAreaResp") != null) && (!(conectorParametro("cboAreaResp").equals("")))){
            this.oidDepartamento =  conectorParametro("cboAreaResp");
        }
        
        // Codigo Actividad
        if ((conectorParametro("txtcdActividad") != null) && (!(conectorParametro("txtcdActividad").equals("")))){
             this.codigoActividad =  conectorParametro("txtcdActividad");
        }
		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
        // Campañas desplazamiento
        if ((conectorParametro("txtCampDesp") != null) && (!(conectorParametro("txtCampDesp").equals("")))){
             this.numeroCampanasDesplazamiento =  conectorParametro("txtCampDesp");
        }
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/
        
		
		// Descripcion del Codigo Actividad Origen
        if ((conectorParametro("txtcdActividad") != null) && (!(conectorParametro("txtcdActividad").equals(""))) ){
           traza("entro al if con oid act origen " + conectorParametro("txtcdActividad"));
           this.codigoActividadOrigen = conectorParametro("txtcdActividad");
        }

        if ((conectorParametro("cbactividadRef") != null) && (!(conectorParametro("cbactividadRef").equals(""))) ){
           traza("entro al if con oid act origen " + conectorParametro("cbactividadRef"));
           this.oidActividadOrigen = conectorParametro("cbactividadRef");
        }

        

        // Codigo Tipo Actividad
        if ((conectorParametro("codigoTipoActividad") != null) && (!(conectorParametro("codigoTipoActividad").equals("")))){
           this.codigoTipoActividad = conectorParametro("codigoTipoActividad");
        }
            
        // Ebel Noticia
        if ((conectorParametro("ebelNoticia") != null) ){            
            this.indicadorEbelNoticia = conectorParametro("ebelNoticia");
        }

        // Indicador de Dias
        if ((conectorParametro("indFestivo") != null) && (!(conectorParametro("indFestivo").equals("")))){            
            this.indicadorFestivos = conectorParametro("indFestivo");
        }else{
            this.indicadorFestivos = "";
        }

        // Dias Desplazamiento
        if ((conectorParametro("diasDesplazamiento") != null) && (!(conectorParametro("diasDesplazamiento").equals("")))){            
            this.numeroDiasDesplazamiento = conectorParametro("diasDesplazamiento");
        }

        // Numero Campañas Antelacion
        if ((conectorParametro("campanasAntelacion") != null) && (!(conectorParametro("campanasAntelacion").equals(""))))
              {            
                this.numeroCampanaAntelacion = conectorParametro("campanasAntelacion") ;
              }

        // Valor del Tipo Direccion

        if ((conectorParametro("mensajeOid") != null) && (!(conectorParametro("mensajeOid").equals("")))){
             this.oidMensaje =   Long.valueOf(conectorParametro("mensajeOid"));
        }

        // ESTO ES NUEEEVO
        if  ((conectorParametro("cboTipoDias") != null) && (!(conectorParametro("cboTipoDias").equals("")))){    
            this.indicadorDiasLaborables =  (conectorParametro("cboTipoDias"));
        } else{
            this.indicadorDiasLaborables = "";
        }

        if ((conectorParametro("tipoDireccion") != null) && (!(conectorParametro("tipoDireccion").equals(""))))
              {    
                this.oidTipoDireccion =  Long.valueOf(conectorParametro("tipoDireccion"));
              }
        if ((conectorParametro("ClaseActividad") != null) && (!(conectorParametro("ClaseActividad").equals(""))))
              {            
                   this.oidClaseActividad =  Long.valueOf(conectorParametro("ClaseActividad"));
              }

        DTOActividad dtoa = new DTOActividad();
        dtoa.setOidAcceso(null);
        dtoa.setOidMarca(Long.valueOf(this.valueMarca));
        dtoa.setOidCanal(Long.valueOf(this.valueCanal));


        dtoa.setOidPais(this.oidPais);
        dtoa.setIpCliente(this.IPCliente);
        dtoa.setPrograma(this.programa);
       
        dtoa.setOidIdioma(this.oidIdioma);

        if ((this.oidDepartamento != null) && ((!this.oidDepartamento.equals(""))))
              dtoa.setOidDepartamento(Long.valueOf(this.oidDepartamento));

        if ((this.oidActividadOrigen != null) && ((!this.oidActividadOrigen.equals(""))))
              dtoa.setOidActividadOrigen(Long.valueOf(this.oidActividadOrigen));

		if ((this.oidMensaje != null) && ((!this.oidMensaje.equals(""))))
              dtoa.setOidMensaje(this.oidMensaje);
       
        if ((this.oidClaseActividad != null) && ((!this.oidClaseActividad.equals(""))))
              dtoa.setOidClasificacion((this.oidClaseActividad));

        if ((this.oidDepartamento != null) && ((!this.oidDepartamento.equals(""))))      
                dtoa.setCodigoActividad(this.codigoActividad);

        if ((this.codigoActividadOrigen != null) && ((!this.codigoActividadOrigen.equals("")))) 
                    dtoa.setCodigoActividadOrigen((this.codigoActividadOrigen));

        if ((this.codigoTipoActividad != null) && ((!this.codigoTipoActividad.equals(""))))
                dtoa.setTipoActividad(Integer.valueOf(this.codigoTipoActividad));

		/*enozigli 30/10/2007 modificado por COL-CRA-001*/
		if ((this.numeroCampanasDesplazamiento != null) && ((!this.numeroCampanasDesplazamiento.equals(""))))
	            dtoa.setCampanyasDesplazamiento((Integer.valueOf(this.numeroCampanasDesplazamiento)));
		/*fin enozigli 30/10/2007 modificado por COL-CRA-001*/

      if ((this.numeroDiasDesplazamiento != null) && ((!this.numeroDiasDesplazamiento.equals(""))))
                 dtoa.setDiasDesplazamiento((Integer.valueOf(this.numeroDiasDesplazamiento)));

      traza(this.indicadorEbelNoticia);

           if (this.indicadorEbelNoticia.equals("N")) {
          
                     dtoa.setEbelNoticias(Boolean.FALSE);
                     
               } else {
        
                    dtoa.setEbelNoticias(Boolean.TRUE);
                }

      

        if (this.indicadorDiasLaborables.equals("0")) {
               dtoa.setLaborales(Boolean.FALSE);
                                      
            } else if (this.indicadorDiasLaborables.equals("1")){
                dtoa.setLaborales(Boolean.TRUE);
            }  
        if ((this.oidTipoDireccion != null) && ((!this.oidTipoDireccion.equals(""))))
         {
                       dtoa.setTipoDireccion((this.oidTipoDireccion));
         }


       if ((this.numeroCampanaAntelacion != null) && ((!this.numeroCampanaAntelacion.equals(""))))  
            {
                dtoa.setCampanyasAntelacion(Integer.valueOf(this.numeroCampanaAntelacion));
            }
            
   
          if (this.indicadorFestivos == "0") {
              dtoa.setFestivos(Boolean.FALSE);
          } else if (this.indicadorFestivos == "1"){
              dtoa.setFestivos(Boolean.TRUE);
          }

          dtoa.setVectorConTraducciones(this.recuperaTraduccionesI18N(new Integer(1)));
          this.procesoAsignado = (conectorParametro("procesosAsignado") == null)
                   ? "" : conectorParametro("procesosAsignado");

          String dato;
          StringTokenizer strTok = new StringTokenizer(procesoAsignado,"|");
           
          Vector vecProcesosAsignados = new Vector();

          while (strTok.hasMoreTokens()){
            dato = strTok.nextToken();
            vecProcesosAsignados.add(Long.valueOf(dato));
          }  
          dtoa.setProcesosAsignados(vecProcesosAsignados);

          Vector vec = new Vector();
          vec.add(dtoa);

       
          pagina("salidaGenerica");
          if (this.oid == null) {            
              traza("************ VA A INSERTAR *******************");
              MareBusinessID id_bus = new MareBusinessID("CRAInsertarActividad");
              vec.add(id_bus);
              traza(dtoa);
              traza("************ INSERTA......... ***************");
              DruidaConector conectorActividad = conectar("ConectorInsertarActividad", vec);

              traza("POR LLAMAR A limpiaInsertar()");
              asignarAtributo("VAR", "ejecutar","valor", "limpiaInsertar();");
				  traza("EJECUTADO  limpiaInsertar()");
          } else {
              traza("********** VA A MODIFICAR *****************");
              dtoa.setOid(this.oid);
              traza("********* GUARDAR ****** OID:" + dtoa.getOid());
            
              MareBusinessID id_bus = new MareBusinessID("CRAActualizarActividad");
              vec.add(id_bus);
              traza(dtoa);
              traza("MODIFICA................");
              DruidaConector conectorActividad = conectar("ConectorActividad", vec);

              this.asignarAtributo("VAR", "ok", "valor", "si");
              asignarAtributo("VAR", "ejecutar","valor", "LoadBar()");
          }        
     }
}
