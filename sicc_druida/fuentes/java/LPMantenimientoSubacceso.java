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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.seg.DTOColeccionSubaccesos;
import es.indra.sicc.dtos.seg.DTOSubacceso;
//import es.indra.sicc.dtos.seg.DTOValidarUbigeo;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.seg.*;

/**
 * Sistema:           Belcorp
 * Modulo:            SEG
 * Submódulo:         Seguridad
 * Componente:        LP
 * Fecha:
 * Observaciones:
 * @version
 * @autor             Emilio Noziglia
 */

// Definicion de la clase
public class LPMantenimientoSubacceso extends LPSICCBase {
    private String acceso = null;
    private String canal = null;
    private Long oidCanal = null;
    private Long oidAcceso = null;
    private Long oidSubacceso = null;
    private String codigoSubacceso = null;
//    private String descripcionUbigeo = null;
    private String descripcionSubacceso = null;
//    private String descripcionUbigeoDef = null;
    private String descripcionSubaccesoDef = null;
    private String accion = null;
    private Long idioma = null;
    private String ipCliente = null;
    private String programa = null;
    private String idUsuario = null;
    private Long pais = null;
    private String idiomaIso = null;
    private String paisIso = null;
    private String casoDeUso = null;
    private DTOSubacceso dtoe = new DTOSubacceso();

    private RecordSet descripciones = null;
    private DTOColeccionSubaccesos dtoec = new DTOColeccionSubaccesos();
    private Long canalDefecto = null;
    
    // Definicion del constructor
    public LPMantenimientoSubacceso() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
    
        setTrazaFichero();
        traza("Inicio LPMantenimientoSubacceso");

        //descripciones = this.recuperaHiddensI18N(Integer.valueOf("1"));
        accion = conectorParametro("accion");
        accion = (accion == null) ? "" : accion;

        casoDeUso = (String) conectorParametroSesion("casoDeUso");
        traza("CASO DE USO: " + casoDeUso);
        conectorParametroSesion("casoDeUso", "");
        
        if ((casoDeUso == null) || casoDeUso.equals("")) {
            casoDeUso = conectorParametro("casoDeUso");
            casoDeUso = (casoDeUso == null) ? "" : casoDeUso;
        }

        canal = conectorParametro("cbCodigoCanal");
        acceso = conectorParametro("cbCodigoAcceso");
        codigoSubacceso = conectorParametro("txtCodigoSubacceso");
        descripcionSubacceso = conectorParametro("txtDescripcionSubacceso");
//        descripcionUbigeo = conectorParametro("txtCodUbigeo");

        descripcionSubaccesoDef = conectorParametro("hidDescripcionSubacceso");
//        descripcionUbigeoDef = conectorParametro("hidDescUbigeo");

        if ((conectorParametro("hidOidCanal") != null) && !conectorParametro("hidOidCanal").equals("")) {
            oidCanal = new Long(conectorParametro("hidOidCanal"));
        } else {
            oidCanal = null;
        }

        traza("Subacceso:"+conectorParametro("hidOidSubacceso"));

        if ((conectorParametro("hidOidSubacceso") != null) &&
                !conectorParametro("hidOidSubacceso").equals("")) {
            oidSubacceso = new Long(conectorParametro("hidOidSubacceso"));
        } else {
            oidSubacceso = null;
        }
traza("1");
        if ((conectorParametro("hidOidAcceso") != null) &&
                !conectorParametro("hidOidAcceso").equals("")) {
            oidAcceso = new Long(conectorParametro("hidOidAcceso"));
        } else {
            oidAcceso = null;
        }
traza("2");
        //variables de sesion
        if (this.idioma == null)    this.idioma = UtilidadesSession.getIdioma(this);        
        if (this.ipCliente == null) this.ipCliente = UtilidadesBelcorp.getIPCliente(this);        
        if (this.programa == null)  this.programa = UtilidadesSession.getFuncion(this);        
        if (this.idUsuario == null) this.idUsuario = UtilidadesSession.getIdUsuario(this);
        if (this.pais == null)      this.pais = UtilidadesSession.getPais(this);
//        if (this.idiomaIso == null) this.idiomaIso = UtilidadesSession.getIdioma_ISO(this);
//        if (this.paisIso == null)   this.paisIso = UtilidadesSession._ISO(this);
traza("3");

        if (casoDeUso == "insertar")   
         this.canalDefecto = UtilidadesSession.getCanalPorDefecto(this);
         
traza("4");
        //seteo los dtos para que ya esten para las llamadas al servidor
        //dtoe.setDescripcionesSubacceso(this.prepararVectorDescripciones());
        dtoe.setCodigoSubacceso(codigoSubacceso);
        dtoe.setOidAcceso(oidAcceso);
        dtoe.setOidCanal(oidCanal);
        dtoe.setOidSubacceso(oidSubacceso);
//        dtoe.setUbigeo(descripcionUbigeo);
//        dtoe.setDescripcionUbigeo(descripcionUbigeo);
        dtoe.setDescripcionSubaccesoBusqueda(descripcionSubacceso);
        dtoec.setCollectionSubaccesos(prepararVector(conectorParametro("elementosSeleccionados")));
        dtoe.setPrograma(this.programa);
        dtoec.setPrograma(this.programa);
        dtoe.setIpCliente(this.ipCliente);
        dtoec.setIpCliente(this.ipCliente);
        dtoe.setOidIdioma(this.idioma);
        dtoec.setOidIdioma(this.idioma);
        dtoe.setOidPais(this.pais);
        dtoec.setOidPais(this.pais);
        
        traza("DTO formado por campos de la pantalla: " + dtoe);

        try {
            // Rastreo
            this.rastreo();
        
            asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
            asignarAtributo("VAR", "accion", "valor", accion);
            traza("Accion: " + accion);
            traza("Caso de Uso: " + casoDeUso);
            //cargarCombos();
            
            if (accion.equals("consultar")) {
                pagina("contenido_subacceso_buscar");
                //I18n
                anyadeHiddensI18N(true, "SEG_SUBAC", null, new Integer(1),
                    "frmBusquedaSubacceso", "txtDescripcionSubacceso", false);


                /*/-----------------------------------------
                  DTOEBuscarSubaccesos dtoen = new DTOEBuscarSubaccesos();
                  dtoen.setOidIdioma(new Long(1));
                  dtoen.setIndicadorSituacion(new Integer(0));
                  dtoen.setTamanioPagina(new Integer(20));
                  Vector paramEntrada = new Vector();
                  paramEntrada.add(dtoen);
                  paramEntrada.add(new MareBusinessID("SEGBuscarSubaccesos"));
                  traza("Antes de buscar subaccesos");
                  traza("Este es el dto de	ENTRADA" + dtoe);

                  DruidaConector conectorBusquedaSubaccesos = conectar("conectorBusquedaSubaccesos",
                          paramEntrada);                  
                  traza(conectorBusquedaSubaccesos.getXML());
                //-----------------------------------------*/
                
                cargarCombos();
                
                asignarAtributo("VAR","hidOidIdioma","valor",(UtilidadesSession.getIdioma(this)==null)?"":UtilidadesSession.getIdioma(this).toString());
    
                if (casoDeUso.equalsIgnoreCase("consultar")) { //buscar
                    this.asignarAtributoPagina("cod", "0362");
                    this.getConfiguracionMenu("LPMantenimientoSubacceso","buscar");                    
                    asignarAtributo("VAR","casoDeUso","valor","consultar");
                    asignarAtributo("VAR","hmultiselec","valor","false");
                    asignarAtributo("VAR","hdetalle","valor","true");
                }

                if (casoDeUso.equalsIgnoreCase("modificar")) { //modificar                    
                    this.asignarAtributoPagina("cod", "038");
                    this.getConfiguracionMenu("LPMantenimientoSubacceso","buscar");
                    asignarAtributo("VAR","casoDeUso","valor","modificar");
                    asignarAtributo("VAR","hmultiselec","valor","false");
                    asignarAtributo("VAR","hmodificar","valor","true");
                }
                
                if (casoDeUso.equalsIgnoreCase("insertar")) { //insertar
                    this.asignarAtributoPagina("cod", "020");
                    this.getConfiguracionMenu("LPMantenimientoSubacceso", "insertar");
                    //asignarAtributo("CAPA", "capaBtnBuscar", "visibilidad","hidden");
                }
                
                if (casoDeUso.equalsIgnoreCase("eliminar")) { //eliminar                    
                    this.asignarAtributoPagina("cod", "0363");
                    this.getConfiguracionMenu("LPMantenimientoSubacceso","buscar");
                    asignarAtributo("VAR","casoDeUso","valor","eliminar");
                    asignarAtributo("VAR","hmultiselec","valor","true");
                    asignarAtributo("VAR","hdetalle","valor","true");
                    //la habilitacion del boton borrado esta en la configuracion del menu
                }
                
            } else if (accion.equalsIgnoreCase("detalle")) {
                accionDetalle();
            } else if (accion.equalsIgnoreCase("insertar")) {

                traza("voy por insertar.......");   
            
                //asignarAtributo("CAPA", "capaBtnBuscar", "visibilidad", "hidden");
                traza("voy por insertar.......1");
                accionInsertar();
            } else if (accion.equalsIgnoreCase("modificar")) {
                accionModificar(true);
            } else if (accion.equalsIgnoreCase("guardar")) {
                pagina("contenido_subacceso_insertar");
                accionGuardar();
            }  
            
        } catch (Exception ex) {
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","ejecutarError","valor","ejecucionERROR();");
        }
    }


    private void accionDetalle() throws Exception {

        pagina("contenido_subacceso_insertar");        
        anyadeHiddensI18N(true, "SEG_SUBAC", oidSubacceso, new Integer(1),
            "frmInsertarSubacceso", "txtDescripcionSubacceso", true);
        //armo el dtooid
        DTOOID dtoe = new DTOOID();
        dtoe.setOid(oidSubacceso);
        dtoe.setIpCliente(UtilidadesSession.getIdUsuario(this));
        dtoe.setOidIdioma(idioma);
        dtoe.setPrograma(UtilidadesSession.getFuncion(this));
        dtoe.setOidPais(pais);
        
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoe);
        paramEntrada.add(new MareBusinessID("SEGConsultarSubacceso"));

        traza("Comienzo conectar!!!");
        DruidaConector conDetalle = conectar("conectorConsultarSubacceso",paramEntrada);
        traza("Fin conectar!!!");
        traza("Salida:"+conDetalle.objeto("dtoSalidaObjeto"));
        DTOSalida dtoDetalle = (DTOSalida) conDetalle.objeto("dtoSalidaObjeto");

        RecordSet rsDetalle = dtoDetalle.getResultado();

    		String casoDeta = conectorParametroLimpia("hCasoDetalle","",true);    
        traza("Caso Deta"+casoDeta);
        asignarAtributo("VAR", "hCasoDetalle", "valor", casoDeta);
        asignarAtributo("VAR", "casoDeUso", "valor", "detalle");
        asignarAtributo("VAR","hidOidSubacceso","valor",(oidSubacceso==null)?"":oidSubacceso.toString());
        asignarAtributo("CTEXTO","txtCodigoSubacceso","valor",(rsDetalle.getValueAt(0,"COD_SBAC")==null)?"":rsDetalle.getValueAt(0,"COD_SBAC").toString());
        asignarAtributo("CTEXTO","txtDescripcionSubacceso","valor",(rsDetalle.getValueAt(0,"DES_SBAC")==null)?"":rsDetalle.getValueAt(0,"DES_SBAC").toString());
        RecordSet rsCanal = RecordSet.clone(rsDetalle);
          traza("Columnas:"+rsCanal.getColumnIdentifiers());
          //rsCanal.removeColumn(7);
          rsCanal.removeColumn(6);rsCanal.removeColumn(5);
          rsCanal.removeColumn(2);rsCanal.removeColumn(1);rsCanal.removeColumn(0);
          traza("RecordSet:"+rsCanal );
          traza("Conector:"+UtilidadesBelcorp.generarConector("dtoSalida", rsCanal, rsCanal.getColumnIdentifiers()).getXML() );
        asignar("COMBO", "cbCodigoCanal",
            UtilidadesBelcorp.generarConector("dtoSalida", rsCanal, rsCanal.getColumnIdentifiers()), "dtoSalida");
            
        RecordSet rsAcceso = RecordSet.clone(rsDetalle);
          //rsAcceso.removeColumn(7);
          rsAcceso.removeColumn(4);rsAcceso.removeColumn(3);
          rsAcceso.removeColumn(2);rsAcceso.removeColumn(1);rsAcceso.removeColumn(0);
          
        asignar("COMBO", "cbCodigoAcceso",
            UtilidadesBelcorp.generarConector("dtoSalida", rsAcceso, rsAcceso.getColumnIdentifiers()), "dtoSalida");
        
//        asignarAtributo("CTEXTO","txtCodUbigeo","valor",(rsDetalle.getValueAt(0,"VAL_UBIG")==null)?"":rsDetalle.getValueAt(0,"VAL_UBIG").toString());

        asignarAtributo("VAR","hidSelectedCanales","valor",(rsDetalle.getValueAt(0,"CANA_OID_CANA")==null)?"":rsDetalle.getValueAt(0,"CANA_OID_CANA").toString());
        asignarAtributo("VAR","hidSelectedAccesos","valor",(rsDetalle.getValueAt(0,"ACCE_OID_ACCE")==null)?"":rsDetalle.getValueAt(0,"ACCE_OID_ACCE").toString());

        asignarAtributo("VAR","hTodosDisabled","valor","true");

        this.asignarAtributoPagina("cod", "0362");
        this.getConfiguracionMenu("LPMantenimientoSubacceso","detalle");        
        
    }

    private void accionInsertar() throws Exception {
        traza("accionInsertar()");
        pagina("contenido_subacceso_insertar");
        traza("SCS 1");
        asignarAtributo("VAR","hidOidIdioma","valor",(UtilidadesSession.getIdioma(this)==null)?"":UtilidadesSession.getIdioma(this).toString());
        traza("SCS 2");
        anyadeHiddensI18N(true, "SEG_SUBAC", null, new Integer(1), "frmInsertarSubacceso", "txtDescripcionSubacceso", false);
        traza("3");
        cargarCombos();
        traza("4");
        asignarAtributo("VAR", "casoDeUso", "valor", "insertar");
        traza("5");
        
        this.getConfiguracionMenu("LPMantenimientoSubacceso","insertar");
        traza("6");
        //setear el valor al combo
        
    }

    private void accionModificar(boolean anyade) throws Exception {
        
        if (anyade){
        pagina("contenido_subacceso_insertar");
        anyadeHiddensI18N(true, "SEG_SUBAC", oidSubacceso, new Integer(1),
            "frmInsertarSubacceso", "txtDescripcionSubacceso", false);
        }
        //armo el dtooid
        DTOOID dtoe = new DTOOID();
        dtoe.setOid(oidSubacceso);
        dtoe.setIpCliente(UtilidadesSession.getIdUsuario(this));
        dtoe.setOidIdioma(idioma);
        dtoe.setPrograma(UtilidadesSession.getFuncion(this));
        dtoe.setOidPais(pais);
        
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoe);
        paramEntrada.add(new MareBusinessID("SEGConsultarSubacceso"));

        DruidaConector conModif = conectar("conectorConsultarSubacceso",paramEntrada);        
        DTOSalida dtoModif = (DTOSalida) conModif.objeto("dtoSalidaObjeto");

        RecordSet rsModif = dtoModif.getResultado();

        asignarAtributo("VAR", "casoDeUso", "valor", "modificar");
        asignarAtributo("VAR","hidOidSubacceso","valor",(oidSubacceso==null)?"":oidSubacceso.toString());
        asignarAtributo("CTEXTO","txtCodigoSubacceso","valor",(rsModif.getValueAt(0,"COD_SBAC")==null)?"":rsModif.getValueAt(0,"COD_SBAC").toString());
        asignarAtributo("CTEXTO","txtDescripcionSubacceso","valor",(rsModif.getValueAt(0,"DES_SBAC")==null)?"":rsModif.getValueAt(0,"DES_SBAC").toString());
        
        RecordSet rsCanal = RecordSet.clone(rsModif);
          traza("Columnas:"+rsCanal.getColumnIdentifiers());
          //rsCanal.removeColumn(7);
          rsCanal.removeColumn(6);rsCanal.removeColumn(5);
          rsCanal.removeColumn(2);rsCanal.removeColumn(1);rsCanal.removeColumn(0);
          traza("RecordSet:"+rsCanal );
          traza("Conector:"+UtilidadesBelcorp.generarConector("dtoSalida", rsCanal, rsCanal.getColumnIdentifiers()).getXML() );
        asignar("COMBO", "cbCodigoCanal",
            UtilidadesBelcorp.generarConector("dtoSalida", rsCanal, rsCanal.getColumnIdentifiers()), "dtoSalida");
            
        RecordSet rsAcceso = RecordSet.clone(rsModif);
          //rsAcceso.removeColumn(7);
          rsAcceso.removeColumn(4);rsAcceso.removeColumn(3);
          rsAcceso.removeColumn(2);rsAcceso.removeColumn(1);rsAcceso.removeColumn(0);
          traza("RecordSet:"+rsAcceso );
        asignar("COMBO", "cbCodigoAcceso",
            UtilidadesBelcorp.generarConector("dtoSalida", rsAcceso, rsAcceso.getColumnIdentifiers()), "dtoSalida");
        
//        asignarAtributo("CTEXTO","txtCodUbigeo","valor",(rsModif.getValueAt(0,"VAL_UBIG")==null)?"":rsModif.getValueAt(0,"VAL_UBIG").toString());

        asignarAtributo("VAR","hidSelectedCanales","valor",(rsModif.getValueAt(0,"CANA_OID_CANA")==null)?"":rsModif.getValueAt(0,"CANA_OID_CANA").toString());
        asignarAtributo("VAR","hidSelectedAccesos","valor",(rsModif.getValueAt(0,"ACCE_OID_ACCE")==null)?"":rsModif.getValueAt(0,"ACCE_OID_ACCE").toString());

        asignarAtributo("VAR","hModifDisabled","valor","true");

        //ocultos
        asignarAtributo("VAR","hidCodigoSubacceso","valor",(rsModif.getValueAt(0,"COD_SBAC")==null)?"":rsModif.getValueAt(0,"COD_SBAC").toString());
        asignarAtributo("VAR","hidDescripcionSubacceso","valor",(rsModif.getValueAt(0,"DES_SBAC")==null)?"":rsModif.getValueAt(0,"DES_SBAC").toString());
//        asignarAtributo("VAR","hidDescUbigeo","valor",(rsModif.getValueAt(0,"VAL_UBIG")==null)?"":rsModif.getValueAt(0,"VAL_UBIG").toString());        
        
        this.asignarAtributoPagina("cod", "038");
        this.getConfiguracionMenu("LPMantenimientoSubacceso","modificar");        
    }

    private void accionGuardar() throws Exception {
      //i18n

      pagina("salidaGenerica");
      
      //pagina("contenido_subacceso_insertar");    
      anyadeHiddensI18N(false, "SEG_SUBAC", null, new Integer(1),"frmInsertarSubacceso","txtDescripcionSubacceso", false);
      
      //SCS asignarAtributo("VAR","hidOidIdioma","valor",(UtilidadesSession.getIdioma(this)==null?"":UtilidadesSession.getIdioma(this).toString()));
          
      Vector paramEntrada = new Vector();    
            
      paramEntrada = new Vector();
      
      //i18n recupera traducciones
      traza("Traduccciones:-->"+recuperaTraduccionesI18N(new Integer(1)));
      dtoe.setDescripcionesSubacceso(recuperaTraduccionesI18N(new Integer(1)));

      traza("DTO A GUARDAR:"+dtoe);
      // Setea estos campos por si se produce un error
      //SCS  asignarAtributo("CTEXTO","txtCodigoSubacceso","valor",this.codigoSubacceso);
//      asignarAtributo("CTEXTO","txtUbigeo","valor",this.descripcionUbigeo);

      paramEntrada.add(dtoe);
      paramEntrada.add( new MareBusinessID("SEGGuardarSubacceso"));
      
      traza("voy a guardar");
      conectar("conectorGuardarSubacceso", paramEntrada);
      traza("guarde");

      //this.ratrearFuncion();

      /*if (casoDeUso.equalsIgnoreCase("modificar")){
        asignarAtributo("VAR","hcerrar","valor","true"); 
      } else {      
        this.accion="insertar";
        asignarAtributo("VAR","casoDeUso","valor","insertar");
        asignarAtributo("VAR","accion","valor",accion);      
        asignarAtributo("VAR","hidOidSubacceso","valor","");
        asignarAtributo("CTEXTO","txtDescripcionSubacceso", "valor", "");      
        asignarAtributo("VAR","hidSelectedCanales", "valor", "");
        asignarAtributo("VAR","hidSelectedAccesos", "valor", "");
        asignarAtributo("VAR","hidCodigoSubacceso","valor","");
        asignarAtributo("CTEXTO","txtCodigoSubacceso","valor","");
//        asignarAtributo("CTEXTO","txtCodUbigeo","valor","");
        cargarCombos();
      }*/
      //pagina("contenido_subacceso_insertar");
              
      traza("regreso a paginilla");
  
      asignarAtributo("VAR","ejecutar","valor","persistioOk('" + UtilidadesSession.getIdioma(this).toString() + "','" + this.codigoSubacceso + "');");
 
      traza("asigne.........");
      
    }

    private void cargarCombos() throws Exception {
    		//Preparamos los parametros del subsistema

        traza("cargarCombos 1");
        ComposerViewElementList cv = crearParametrosEntrada();

        traza("cargarCombos 2");
		    
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());

        traza("cargarCombos 3");
        
        conector.ejecucion();

        traza("cargarCombos 4");
        
        DruidaConector resultados = conector.getConector();
		
        //Cargamos los combos con los resultados
        asignar("COMBO", "cbCodigoCanal", resultados, "SEGObtenerCanalesSinFiltro");
        if (canalDefecto!=null){
          asignar("COMBO", "cbCodigoAcceso", resultados, "SEGObtenerAccesosSinFiltro");
          traza("Canal Defecto:"+canalDefecto.toString());
          asignarAtributo("VAR","hidCanalPrevio","valor",canalDefecto.toString());
          if (UtilidadesSession.getAccesoPorDefecto(this)!=null) {
            asignarAtributo("VAR","hidAccesoPrevio","valor",UtilidadesSession.getAccesoPorDefecto(this).toString());
          }
        }
    }
    
    private ComposerViewElementList crearParametrosEntrada() throws Exception {
    
        ComposerViewElementList lista = new ComposerViewElementList(); 

        DTOBelcorp dto = new DTOBelcorp();
        traza("Idioma:"+idioma);
        dto.setOidIdioma(idioma);
        //Primer combo
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGObtenerCanalesSinFiltro");        
        ci1.setDTOE(dto);

        lista.addViewElement(ci1);

        traza("Canal:"+UtilidadesSession.getCanalPorDefecto(this));

        ComposerViewElement ci2 = new ComposerViewElement();
        if (canalDefecto!=null){
          //Segundo combo         
          ci2.setIDBusiness("SEGObtenerAccesosSinFiltro");
          DTOOID dto2 = new DTOOID();
          
          dto2.setOid(new Long(canalDefecto.longValue()));
          dto2.setOidIdioma(this.idioma);
          ci2.setDTOE(dto2);
          
        
          //Refefinimos la posición de las columnas porque el resultado de 
          // la operación de negocio no es estándar
          /*ci2.setPosOID((byte)2);
          ci2.setPosDesc((byte)0);*/
          lista.addViewElement(ci2);
        }
        return lista;

    }
//------------------------------------METODOS AYUDA---------------------------------------------
    /*
     * Arma un conector en base a un record set y los nombres de los campos
     * pasados como parámetro. En esta caso solo se aplica la petición de
     * 2 campos.
     */
    private DruidaConector generaConector(RecordSet rs, String ID_Rows,
        String campoCod, String campoNom, String campoOpcional)
        throws Exception {
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoCod);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");

            Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null)
                    ? "" : rs.getValueAt(i, campoCod).toString()));
            e_campo1.appendChild(txtCod);
            e_row.appendChild(e_campo1);

            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoNom);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");

            Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null)
                    ? "" : rs.getValueAt(i, campoNom).toString()));
            e_campo2.appendChild(txtDesc);
            e_row.appendChild(e_campo2);

            if (campoOpcional != null) {
                Element e_campo3 = docDestino.createElement("CAMPO");
                e_campo3.setAttribute("NOMBRE", campoOpcional);
                e_campo3.setAttribute("TIPO", "OBJECTO");
                e_campo3.setAttribute("LONGITUD", "50");

                Text txtOpc = docDestino.createTextNode(((rs.getValueAt(i,
                            campoOpcional) == null) ? ""
                                                    : rs.getValueAt(i,
                            campoOpcional).toString()));
                e_campo3.appendChild(txtOpc);
                e_row.appendChild(e_campo3);
            }
        }

        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());

        return conect;
    }
    private Vector prepararVector(String lista) throws Exception {
        if ((lista == null) || lista.equals("")) {
            return null;
        }

        Vector vec = new Vector();
        String tok;

        StringTokenizer st = new StringTokenizer(lista, "|");

        while (st.hasMoreTokens()) {
            try {
                DTOSubacceso dto = new DTOSubacceso();
                dto.setOidSubacceso(new Long(st.nextToken()));
                vec.add(dto);
            } catch (Exception e) {
                traza("numero mal formado");
            }
        }

        traza("Elementos a borrar: " + vec);

        return vec;
    }
   private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    private Vector prepararVectorDescripciones() throws Exception {
        Vector vec = new Vector();

        for (int i = 0; i < descripciones.getRowCount(); i++) {
            vec.add(descripciones.getValueAt(i, "IDIO_OID_IDIO"));
            vec.add(descripciones.getValueAt(i, "VAL_I18N"));
        }

        traza("Vector de descripciones: " + vec);

        return vec;
    }
//----------------------------------------------------------------------------------------------
    private void ratrearFuncion() throws Exception {
        IRastreador rastreador = Rastreador.getInstance();
        rastreador.RastrearFuncion(new Date(System.currentTimeMillis()),
            "LPBuscarSubacceso", idUsuario);
    }
    private void cargarCombosAntiguo() throws Exception {
        //Cargo el combo canal
        traza("Entrando a cargar Combos");

        RecordSet canales = (RecordSet) conectorParametroSesion("CANAL");
        DruidaConector conCanales = null;
        traza("canales: " + canales);

        if (canales == null) {
            DTOBelcorp dto = new DTOBelcorp();
            dto.setOidIdioma(this.idioma);

            Vector paramEntrada = new Vector();
            paramEntrada.add(dto);
            paramEntrada.add(new MareBusinessID("SEGRecuperaCanales"));
            this.ratrearFuncion();

            conCanales = conectar("ConectorObtenerModulos", paramEntrada);

            MareDTO dtoSalida = (MareDTO) conCanales.objeto("dtoSalidaObjeto");

            canales = (RecordSet) dtoSalida.getProperty("resultado");
            conectorParametroSesion("CANAL", canales);
        }

        conCanales = this.generaConector(canales, "dtoSalida.canales_ROWSET",
                "VAL_OID", "VAL_I18N", null);
        asignar("COMBO", "cbCodigoCanal", conCanales, "dtoSalida.canales_ROWSET");

        //Fin carga de canal
        //Cargo el combo acceso
        RecordSet accesos = (RecordSet) conectorParametroSesion("ACCESO");
        DruidaConector conAccesos = null;

        if (accesos == null) {
            DTOBelcorp dto = new DTOBelcorp();
            dto.setOidIdioma(this.idioma);

            Vector paramEntrada = new Vector();
            paramEntrada.add(dto);
            paramEntrada.add(new MareBusinessID("SEGRecuperaAccesos"));
            this.ratrearFuncion();
            conAccesos = conectar("ConectorObtenerModulos", paramEntrada);

            MareDTO dtoSalida = (MareDTO) conAccesos.objeto("dtoSalidaObjeto");
            accesos = (RecordSet) dtoSalida.getProperty("resultado");
            conectorParametroSesion("ACCESO", accesos);
        }

        conAccesos = this.generaConector(accesos, "dtoSalida.accesos_ROWSET",
                "VAL_OID", "VAL_I18N", "CANA_OID_CANA");
        asignar("LISTA", "lstAccesos", conAccesos, "dtoSalida.accesos_ROWSET");

        //Fin carga de canal
        //Asigno valores si estaban asignados
        asignarAtributo("CTEXTO", "txtDescripcionSubacceso", "valor",
            (((descripcionSubacceso == null) ||
            (descripcionSubacceso.length() == 0)) ? "" : descripcionSubacceso));
        asignarAtributo("VAR", "hidSelectedCanales", "valor",
            (((canal == null) || (canal.length() == 0)) ? "" : canal));
        asignarAtributo("VAR", "hidSelectedAccesos", "valor",
            (((acceso == null) || (acceso.length() == 0)) ? "" : acceso));
        asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaBotonM", "visibilidad", "hidden");
        asignarAtributo("CAPA", "capaBtnBuscar", "visibilidad", "visible");
        traza("Saliendo de cargar Combos");
    }
    private void accionBuscar() throws Exception {
        // Setea estos campos por si se produce un error
        asignarAtributo("CTEXTO", "txtCodigoSubacceso", "valor",
            this.codigoSubacceso);
//        asignarAtributo("CTEXTO", "txtUbigeo", "valor", this.descripcionUbigeo);

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoe);
        paramEntrada.add(new MareBusinessID("SEGBuscarSubaccesos"));
        traza("Antes de buscar subaccesos");
        traza("Este es el dto de	ENTRADA" + dtoe);

        DruidaConector conectorBusquedaSubaccesos = conectar("conectorBusquedaSubaccesos",
                paramEntrada);
        MareDTO dtoSalida = (MareDTO) conectorBusquedaSubaccesos.objeto(
                "dtoSalidaObjeto");
        traza(dtoSalida);

        //Se muestran el resultado en la tabla correspondiente de la pantalla buscar monedas
        //con los datos del DTOSalida recibido del conector (se muestran todos los datos recibidos en el RecordSet). 
        //traza(conectorBusquedaSubaccesos.getXML());
        this.ratrearFuncion();
        asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");

        asignar("LISTA", "lstBuscarSubaccesos", conectorBusquedaSubaccesos,
            "dtoSalida.subaccesos_ROWSET");

        if (casoDeUso.equalsIgnoreCase("consultar")) { //buscar
            this.getConfiguracionMenu("LPMantenimientoSubacceso", "buscar");
            asignarAtributo("BOTON", "capaBotonM", "visibilidad", "hidden");
            asignarAtributo("BOTON", "capaBotonE", "visibilidad", "hidden");
        }

        if (casoDeUso.equalsIgnoreCase("modificar")) { //modificar
            asignarAtributo("LISTA", "lstBuscarSubaccesos", "multisel", "1");
            asignarAtributo("BOTON", "capaBotonM", "visibilidad", "visible");
            this.getConfiguracionMenu("LPMantenimientoSubacceso", "buscar");
            this.asignarAtributoPagina("cod", "038");
        }

        if (casoDeUso.equalsIgnoreCase("eliminar")) { //eliminar
            asignarAtributo("LISTA", "lstBuscarSubaccesos", "multisel", "-1");
            this.getConfiguracionMenu("LPMantenimientoSubacceso", "eliminar");
            this.asignarAtributoPagina("cod", "0363");
            asignarAtributo("BOTON", "capaBotonE", "visibilidad", "visible");
        }

        asignarAtributo("VAR", "hidOidSubacceso", "valor",
            ((oidSubacceso == null) ? "" : this.oidSubacceso.toString()));
        asignarAtributo("CTEXTO", "txtDescripcionSubacceso", "valor",
            (((descripcionSubacceso == null) ||
            (descripcionSubacceso.length() == 0)) ? "" : descripcionSubacceso));
        asignarAtributo("VAR", "hidSelectedCanales", "valor",
            (((canal == null) || (canal.length() == 0)) ? "" : canal));
        asignarAtributo("VAR", "hidSelectedAccesos", "valor",
            (((acceso == null) || (acceso.length() == 0)) ? "" : acceso));
        asignarAtributo("VAR", "hidCodigoSubacceso", "valor",
            this.codigoSubacceso);
        asignarAtributo("CTEXTO", "txtCodigoSubacceso", "valor",
            this.codigoSubacceso);
//        asignarAtributo("CTEXTO", "txtUbigeo", "valor", this.descripcionUbigeo);
    }

    private void accionEliminar() throws Exception {
        // Setea estos campos por si se produce un error
        asignarAtributo("CTEXTO", "txtCodigoSubacceso", "valor",
            this.codigoSubacceso);
//        asignarAtributo("CTEXTO", "txtUbigeo", "valor", this.descripcionUbigeo);

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoec);
        paramEntrada.add(new MareBusinessID("SEGEliminarSubaccesos"));
        conectar("conectorIMESubaccesos", paramEntrada);
        this.ratrearFuncion();

        //Se muestran el resultado en la tabla correspondiente de la pantalla buscar monedas
        //con los datos del DTOSalida recibido del conector (se muestran todos los datos recibidos en el RecordSet). 
        asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
        this.getConfiguracionMenu("LPMantenimientoSubacceso", "eliminar");
        this.asignarAtributoPagina("cod", "0363");
    }
    
    private void accionPreModificar() throws Exception {
        oidSubacceso = new Long(conectorParametro("hidOidSubacceso"));
        descripcionSubacceso = conectorParametro("hidDescripcionSubacceso");
        canal = conectorParametro("hidCodigoCanal");
        acceso = conectorParametro("hidCodigoAcceso");
        codigoSubacceso = conectorParametro("hidCodigoSubacceso");
//        descripcionUbigeo = conectorParametro("hidDescUbigeo");

        //I18n
        anyadeHiddensI18N(true, "SEG_SUBAC", new Long(oidSubacceso.toString()),
            new Integer(1), "frmBusquedaSubacceso", "txtDescripcionSubacceso", false);

        asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
        asignarAtributo("VAR", "hidOidSubacceso", "valor",
            this.oidSubacceso.toString());
        asignarAtributo("CTEXTO", "txtDescripcionSubacceso", "valor",
            (((descripcionSubacceso == null) ||
            (descripcionSubacceso.length() == 0)) ? "" : descripcionSubacceso));
        asignarAtributo("VAR", "hidSelectedCanales", "valor",
            (((canal == null) || (canal.length() == 0)) ? "" : canal));
        asignarAtributo("VAR", "hidSelectedAccesos", "valor",
            (((acceso == null) || (acceso.length() == 0)) ? "" : acceso));
        asignarAtributo("VAR", "hidCodigoSubacceso", "valor",
            this.codigoSubacceso);
        asignarAtributo("CTEXTO", "txtCodigoSubacceso", "valor",
            this.codigoSubacceso);
//        asignarAtributo("CTEXTO", "txtUbigeo", "valor", this.descripcionUbigeo);

        asignarAtributo("VAR", "hidDescripcionSubacceso", "valor",
            this.descripcionSubacceso);
//        asignarAtributo("VAR", "hidDescUbigeo", "valor", this.descripcionUbigeo);

        this.asignarAtributoPagina("cod", "038");
    }
}
