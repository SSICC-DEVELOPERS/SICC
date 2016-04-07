import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTODatosEstrategia;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;
import java.util.Iterator;

public class LPMantenimientoEstrategias extends LPSICCBase {    
    private Long oidIdioma = null;
    private String strOidIdioma = null;    
    private Long oidPais = null;
    private String strOidPais = null;
    private String descPais = null;    
    private String opcionMenu= null;
    private String accion = null;    
    private String strDesde = null;
    private String strHasta = null;
    private String strOidRango = null;
    private String strEstrategia = null; 
    private String strMarca = null;
    private String strCanal = null;
    private boolean blnModifico = false;
    private String idBusiness = "";
     
    public void inicio() throws Exception {

        setTrazaFichero();
        traza("* * * Entre a LPMantenimientoEstrategias * * *");
//        anyadeHiddensI18N(true, "PRE_ESTRA", null , new Integer(1),  "formulario", "txtDescipcion", false);
        opcionMenu  = conectorParametro("opcionMenu");
        accion  = conectorParametro("accion");
        if(opcionMenu==null) opcionMenu = "";     
        if(accion==null) accion = "";
        traza("* * * opcionMenu: " + opcionMenu);
        traza("* * * accion: " + accion);
        cargarVariablesDeSesion();         
    }    


    public void ejecucion() throws Exception{
        try{
            traza("* * * opcionMenu: " + opcionMenu);
            traza("* * * accion: " + accion);
            

            if(opcionMenu.equals("Insertar")) {   
                traza("Abriendo pantalla de insertar");
                if(accion.equals("")){
                    pagina("contenido_estrategia_insertar");
                    getFormatosValidaciones();
                    traza("Se abrio la pantalla")                    ;
                    anyadeHiddensI18N(false, "PRE_ESTRA", null , new Integer(1),  "formulario", "txtDescipcion", false);
                    traza("insertar : cargarDatos()" );
                    cargarDatos();             
                }else if(accion.equals("Guardar")) {     
                    traza("Accion Guardar");
                    pagina("salidaGenerica");
                    insertar();
                }
            }else 
            if((opcionMenu.equals("Consultar")) 
            || 
            (opcionMenu.equals("Modificar")) 
            || 
            (opcionMenu.equals("Eliminar"))
            || 
            (opcionMenu.equals("detalleConsulta"))
            ) {           
                if(accion.equals("")) {
                    pagina("contenido_estrategia_modificar"); 
                    asignaVariables();
            //      Deshabilita el botón Detalle 
                }else
                if(accion.equals("Mostrar datos")) {
                        traza("Mostrar Datos " + opcionMenu);
                        if(opcionMenu.equals("Consultar")){
/*                            asignarAtributo("VAR","accion","valor","detalleConsulta");
                            asignarAtributo("VAR","opcionMenu","valor","detalleConsulta");
                            accion = "detalleConsulta";
                            opcionMenu =  "detalleConsulta";*/
                            asignarAtributoPagina("cod","0782");
                        }else{
                            asignarAtributoPagina("cod","0780");
                        }
                        mostrarDatos();
                }else
                if(accion.equals("Guardar")){ 
                    traza("Ejecucion + Modificar");
                    pagina("salidaGenerica");                
                    modificar();
                }   
            }
            cargarMenuSecundario();
        }catch(Exception e){
            lanzarPaginaError(e);
            try{traza(e.toString());}catch(Exception ee){}
            e.printStackTrace();
        }
    }

    public void insertar() throws Exception{
        DTODatosEstrategia dto = crearDTODatosEstrategia(); 
        idBusiness = "PREGuardarEstrategia";
        MareBusinessID bussID = new MareBusinessID(idBusiness);
        Vector parametros = new Vector();
        parametros.add(dto);
        parametros.add(bussID);
        traza("* * * Antes de conectar con ConectorGuardarEstrategia");
        DruidaConector con = conectar("ConectorGuardarEstrategia",parametros);
        traza("* * con " + con);
        asignarAtributo("VAR","ejecutar","valor","despuesGuardar()");
        inicializarPagina();
    }

    public void modificar() throws Exception{
        DTODatosEstrategia dto = crearDTODatosEstrategia(); 
        traza("Modificar " + dto);        
        idBusiness = "PREModificarEstrategia";
        MareBusinessID bussID = new MareBusinessID(idBusiness);
        Vector parametros = new Vector();
        parametros.add(dto);
        parametros.add(bussID);
        traza("* * * Antes de conectar con ConectorGuardarEstrategia");
        DruidaConector con = conectar("ConectorGuardarEstrategia",parametros);
        traza("* * con " + con);
    }

    public void mostrarDatos() throws Exception{
        pagina("contenido_estrategia_insertar");
        String opcionMenu = conectorParametroLimpia("opcionMenu","",true);
        getFormatosValidaciones();
        traza(" opcionMenu : " +  opcionMenu);
        asignarAtributo("VAR", "casoDeUso", "valor", "Modificar");
        String oidEstr = conectorParametroLimpia("hidOidMatriz", null, true ); 
        traza("oidEstr" + oidEstr);
        if(!oidEstr.equals("")){
             if (opcionMenu.equals("Modificar"))  {
                anyadeHiddensI18N(true , "PRE_ESTRA", new Long(oidEstr) , new Integer(1),  "formulario", "txtDescipcion", false);
             }else{
                anyadeHiddensI18N(true, "PRE_ESTRA", new Long(oidEstr) , new Integer(1),  "formulario", "txtDescipcion", true);
             }
        }
        cargarDatos();
        String oid = conectorParametroLimpia("hidOidMatriz","",true);
        DTOOID dto = new DTOOID();
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOid(new Long(oid));
        Vector paramEntrada = new Vector();
        DruidaConector conector = null;
        MareBusinessID midi = new MareBusinessID("PREObtenerDetalleEstrategia");
        paramEntrada.add(dto);
        paramEntrada.add(midi);
       
        traza("antes de conectar");
        conector = conectar("ConectorObtenerDetalleEstrategia", paramEntrada);
        traza("despues de conectar");
        DTODatosEstrategia dtoDE = (DTODatosEstrategia)conector.objeto("dtoSalida");
        mostrarDetalleEstrategia(dtoDE);
      // deshabilitarCampos();
        asignarAtributo("VAR","hidOidMatriz","valor", oid );
        traza("opcionMenu"  + opcionMenu );
/*        if (opcionMenu.equals("Modificar"))  {
                configurarCampos(dtoDE);
        }*/
    }

    private void mostraDatos() throws Exception{
            asignarAtributo("VAR", "acciones", "valor", "muestradatos");
            pagina("contenido_estrategia_insertar");
    }

    public DTODatosEstrategia crearDTODatosEstrategia() throws Exception{
      DTODatosEstrategia dto  =new DTODatosEstrategia();
        try{
            dto.setOidPais(oidPais);
            dto.setOidIdioma(oidIdioma);
            traza("aaad " + conectorParametroLimpia("oidEstr", null, true ));
            traza("aaad " + !(conectorParametroLimpia("oidEstr", null, true ).equals("")));
            if(!(conectorParametroLimpia("oidEstr", null, true ).equals(""))){             
                dto.setOid(new Long(conectorParametro("oidEstr")));
            }
            dto.setCodigo(conectorParametro("vtxtCodEstrategia"));    
            traza("desc "+conectorParametro("txtDescipcion"));
            traza("txtOrdenAsignacionCUV: "+conectorParametro("txtOrdenAsignacionCUV"));
            traza("recupera " + recuperaTraduccionesI18N(new Integer(1)));
            dto.setAttriTraducible(recuperaTraduccionesI18N(new Integer(1)));
            traza("attri  " + dto.getAttriTraducible());
            traza("idioma " + dto.getOidIdioma());
            traza("getDesc(dto.getAttriTraducible(), dto.getOidIdioma()) " + getDesc(dto.getAttriTraducible(), dto.getOidIdioma()));
        
            dto.setDescripcion(getDesc(dto.getAttriTraducible(), dto.getOidIdioma()));
            traza("Combo Tipo Estra "  + conectorParametroLimpia("vcbTipoEstrategia",null,true));

            if(conectorParametroLimpia("vcbTipoEstrategia",null,true)!= null){
                dto.setOidTipoEstrategia(new Long(conectorParametroLimpia("vcbTipoEstrategia",null,true)));
            }
            traza("PASO Combo Tipo Estra ");
            dto.setDescripcionTipoEstrategia(conectorParametroLimpia("cbTipoEstrategiatxt","",true));
            dto.setIndGrupos(getBoole(conectorParametroLimpia("indgrupo","",true)));    
            dto.setIndCondicionada(getBoole(conectorParametroLimpia("indcondi","",true)));    
            dto.setIndVS(getBoole(conectorParametroLimpia("ckEstrategiaVR","",true)));    
            dto.setIndPaquetes(getBoole(conectorParametroLimpia("ckEstrategiaPaquetes","",true)));    
            traza("txtNumMaximoGrupo  : "  + conectorParametroLimpia("txtNumMaximoGrupo","",true));
            if(!conectorParametroLimpia("vtxtNumMaximoGrupo","",true).equals("")){
                dto.setMaxGrupos(new Integer(conectorParametroLimpia("vtxtNumMaximoGrupo","",true)));    
            }  
            if(!conectorParametroLimpia("vtxtNumMaximoGrupoCondicionantes","",true).equals("")){
                dto.setMaxGruposCondicionantes(new Integer(conectorParametroLimpia("vtxtNumMaximoGrupoCondicionantes","",true)));    
            }
            if(!conectorParametroLimpia("vtxtNumMaximoGrupoCondicionados","",true).equals("")){
                dto.setMaxGruposCondicionados(new Integer(conectorParametroLimpia("vtxtNumMaximoGrupoCondicionados","",true)));    
            }
            dto.setListaRanking(getBoole(conectorParametroLimpia("vckListaRanking","",true)));        
            dto.setCuadreGrupos(getBoole(conectorParametroLimpia("vckIndicadorCuadrePorGrupo","",true)));        
            String  tprod = conectorParametroLimpia("rbTipoProducto","",true);
            traza("tipo Producto " + tprod);
            if(tprod.equals(String.valueOf(ConstantesPRE.ORDEN_COMPRA))){
                dto.setOidTipoProducto(new Long(ConstantesPRE.ORDEN_COMPRA));        
            }
            if(tprod.equals(String.valueOf(ConstantesPRE.REEMPLAZO))){
                dto.setOidTipoProducto(new Long(ConstantesPRE.REEMPLAZO));        
            }
            if(tprod.equals(String.valueOf(ConstantesPRE.ALTERNATIVO))){
                dto.setOidTipoProducto(new Long(ConstantesPRE.ALTERNATIVO));        
            }
            if(tprod.equals(String.valueOf(ConstantesPRE.RECUPERACION))){
                dto.setOidTipoProducto(new Long(ConstantesPRE.RECUPERACION));        
            }
            traza("ahora los Checks "  +  conectorParametroLimpia("vckCodVentaImprimibles","",true));
            dto.setCvImprimible(getBoole(conectorParametroLimpia("vckCodVentaImprimibles","",true)));            
            dto.setModificableImprimible(getBoole(conectorParametroLimpia("vckModificableImprimibles","",true)));        
            dto.setCvDespachoAutomatico(getBoole(conectorParametroLimpia("vckCodVentaDespachoAutomatico","",true)));        
            dto.setModificableDespachoAutomatico(getBoole(conectorParametroLimpia("vckModificableDespachoAutomatico","",true)));            
            dto.setCvDigitable(getBoole(conectorParametroLimpia("vckCodVentaDigitables","",true)));            
            dto.setModificableDigitable(getBoole(conectorParametroLimpia("vckModificableDigitables","",true)));
            
            String ordenAsigCUV = conectorParametroLimpia("txtOrdenAsignacionCUV","",true);
            try{
                dto.setOrdenAsignacionCUV(Integer.valueOf(ordenAsigCUV));
            } catch (NumberFormatException nfe) {
              traza("ordenAsigCUV no es numero o es vacio");
            }
            
            traza("dto FIN" + dto);
        }catch(Exception e){
            e.printStackTrace();
            preservaHiddensI18n(new Integer(1), "PRE_ESTRA", "formulario","txtDescipcion" , false);
            throw new Exception(e.toString());
        }
        return dto;
    }

    private Boolean getBoole(String str)throws Exception{
        traza(str);
        if(str.equals("") || str == null){return Boolean.FALSE;}

        return (str.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);
    }


    public void inicializarPagina() throws Exception{
         conectorAction("LPInsertarEstrategia");
         conectorActionParametro("accion","");
    }

    public void mostrarDetalleEstrategia (DTODatosEstrategia dtoe) throws Exception{
        traza("DTO  : " + dtoe);
        asignarAtributo("CTEXTO", "txtCodEstrategia", "valor", dtoe.getCodigo());
        traza("DESC  " + getDesc(dtoe.getAttriTraducible(), oidIdioma));
        asignarAtributo("CTEXTO", "txtDescipcion", "valor", getDesc(dtoe.getAttriTraducible(), oidIdioma) );
    
        if(dtoe.getMaxGrupos() != null){
            asignarAtributo("CTEXTO", "txtNumMaximoGrupo", "valor", dtoe.getMaxGrupos().toString());
        }
    
        if(dtoe.getMaxGruposCondicionantes() != null){
            asignarAtributo("CTEXTO", "txtNumMaximoGrupoCondicionantes", "valor", dtoe.getMaxGruposCondicionantes().toString());
        }
    
        if(dtoe.getMaxGruposCondicionados() != null){
            asignarAtributo("CTEXTO", "txtNumMaximoGrupoCondicionados", "valor", dtoe.getMaxGruposCondicionados().toString() );
        }

        if(dtoe.getOrdenAsignacionCUV() != null){
            asignarAtributo("CTEXTO", "txtOrdenAsignacionCUV", "valor", dtoe.getOrdenAsignacionCUV().toString() );
        }        
    
        asignarAtributo("VAR", "oidEstr", "valor", dtoe.getOid().toString());

        asignarAtributo("VAR", "indgrupo", "valor", getSN(dtoe.getIndGrupos()));
        asignarAtributo("VAR", "indcondi", "valor", getSN(dtoe.getIndCondicionada()));
        asignarAtributo("VAR", "indvs", "valor", getSN(dtoe.getIndVS()));    
        asignarAtributo("VAR", "indpaq", "valor", getSN(dtoe.getIndPaquetes()));    
        asignarAtributo("VAR", "indlista", "valor", getSN(dtoe.getListaRanking()));    
        asignarAtributo("VAR", "indCGru", "valor", getSN(dtoe.getCuadreGrupos()));    
        asignarAtributo("VAR", "indCvimp", "valor", getSN(dtoe.getCvImprimible()));    
        asignarAtributo("VAR", "indMImp", "valor", getSN(dtoe.getModificableImprimible()));    
        asignarAtributo("VAR", "indCvDesp", "valor", getSN(dtoe.getCvDespachoAutomatico()));        
        asignarAtributo("VAR", "indMDesp", "valor", getSN(dtoe.getModificableDespachoAutomatico()));            
        asignarAtributo("VAR", "indCvDig", "valor", getSN(dtoe.getCvDigitable()));        
        asignarAtributo("VAR", "indMDig", "valor", getSN(dtoe.getModificableDigitable()));            

        asignarAtributo("VAR", "indCvTipoEstrategia", "valor", dtoe.getOidTipoEstrategia().toString());  

        // Seteo de constantesPRE
        asignarAtributo("VAR", "ORDEN_COMPRA", "valor", String.valueOf(ConstantesPRE.ORDEN_COMPRA) ); 
        asignarAtributo("VAR", "REEMPLAZO", "valor", String.valueOf(ConstantesPRE.REEMPLAZO)); 
        asignarAtributo("VAR", "ALTERNATIVO", "valor", String.valueOf(ConstantesPRE.ALTERNATIVO)); 
        asignarAtributo("VAR", "RECUPERACION", "valor", String.valueOf(ConstantesPRE.RECUPERACION));     

        if(dtoe.getOidTipoProducto() != null){
            asignarAtributo("VAR", "tipoCli", "valor", dtoe.getOidTipoProducto().toString());  
        }
    

    }

    private String getSN(Boolean b){
        if(b == null){return "N";}
        if(b.booleanValue()){return "S";}
        else{return "N";}
    }


    private String getDesc(Vector vec, Long idioma) throws Exception{
        Iterator iter = vec.iterator();
        while(iter.hasNext()){
            DTOI18nSICC dto = (DTOI18nSICC)iter.next();
            traza("DTOI18nSICC : " + dto);
            traza("DTOI18nSICC : " + dto.getOidIdioma() );
            if(dto.getOidIdioma().equals(idioma)){
                traza("DTOI18nSICC : " + dto.getOidIdioma() );
                return dto.getValorI18n();
            }
        }
        return "";
    }
      
    public void configurarCampos (DTODatosEstrategia DTOE) throws Exception{
        
    }

    public void deshabilitarCampos() throws Exception {
//        asignarAtributo("VAR", "acciones", "valor", "deshabilitar");
//        pagina("contenido_estrategia_insertar");
    }


    

/*                                */
    //Este metodo setea el titulo y los iconos del menu secundario
    //dependiendo el caso de uso
    private void cargarMenuSecundario() throws Exception {      
        traza("opcionMenu " + opcionMenu);
        traza("accion " + accion);
        if (opcionMenu.equals("Insertar")) {
            getConfiguracionMenu("LPMantenimientoEstrategias","Insertar");
            asignarAtributoPagina("cod","0779");
        }

        if (opcionMenu.equals("Consultar")){
            asignarAtributoPagina("cod","0782");
            if(accion.equals("Mostrar datos")){
                getConfiguracionMenu("LPMantenimientoEstrategias","DetalleConsulta");
            }else{
                getConfiguracionMenu("LPMantenimientoEstrategias","Consultar");
            }
        }

        if (opcionMenu.equals("Modificar")) {
            asignarAtributoPagina("cod","0780");  
            if(accion.equals("Mostrar datos")){           
                getConfiguracionMenu("LPMantenimientoEstrategias","Modificar");
            }else {
                getConfiguracionMenu("LPMantenimientoEstrategias","Consultar");
            }         
        }

        if (opcionMenu.equals("Eliminar")){
            getConfiguracionMenu("LPMantenimientoEstrategias","Eliminar");
            asignarAtributoPagina("cod","0781");
        }        
    }

    //Este metodo carga las variables de sesion en variables de clase
    private void cargarVariablesDeSesion() throws Exception {      
        oidIdioma = UtilidadesSession.getIdioma(this);
        strOidIdioma = oidIdioma.toString();      
        oidPais = UtilidadesSession.getPais(this);
        strOidPais = oidPais.toString();      
        descPais = UtilidadesSession.getDescripcionPais(this);      
    }

    //Este metodo es llamado para cargar valores iniciales
    public void cargarDatos() throws Exception {
        // Llenado del combo de Tipo de estrategia    
        DTOBelcorp dtbel = new DTOBelcorp();
        dtbel.setOidIdioma(oidIdioma);
        dtbel.setOidPais(oidPais);
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("PREObtenerTiposEstrategia");
        elem.setDTOE(dtbel);
        composerviewelementlist.addViewElement(elem);
        traza("composerviewelementlist" + composerviewelementlist);
        ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist,getRequest());
        traza("composerviewelementlist" + composerviewelementlist);
        conectorcomposerview.ejecucion();
        DruidaConector druidaconector = conectorcomposerview.getConector();
        asignar("COMBO", "cbTipoEstrategia", druidaconector,"PREObtenerTiposEstrategia");
	  
        Vector param = new Vector();
        param.add(dtbel);
        param.add(new MareBusinessID("PREObtenerTiposEstrategia"));
        DruidaConector conector = null;
        conector = conectar("ConectorObjetoGenerico",param);
        DTOSalida dtoSalida =(DTOSalida) conector.objeto("DTOSalida");		
        traza("dto: "+dtoSalida);
        RecordSet rs = dtoSalida.getResultado();

        asignar("LISTAEDITABLE", "listaEstrategia",UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()), "dtoSalida");
        asignaVariables();
    }

    private void asignaVariables() throws Exception{
        asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        asignarAtributo("VAR", "pais", "valor", this.strOidPais);
        asignarAtributo("VAR", "idioma", "valor", this.strOidIdioma);    
    }
}
