/**
 * Version 3.0
 *	LPConfigurarMFPais
 *  Auto: ALem Joaquin
 *
 */

 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOEConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOELeerConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOSConfiguracionMF;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;


public class LPConfigurarMFPais extends LPSICCBase {

    private Long pais = null;
    private Long idioma = null;

    private String accion = null;

    private Long oidMarca = null;
    private Long oidCanal = null;
    private Long oidConfiguracionMF = null;

    private String sMarca = null;
    private String sCanal = null;
    private String hMoneda = null;
    //private String txtTipo = null;
    //private String txtSerie = null;

    ////// CONSTRUCTOR  //////////

    public LPConfigurarMFPais()  {
        super();
    }  

    //////  METODO INICIO PARA CARGAR LA PAGINA    //////////
    public void inicio() throws Exception {
        this.pagina("contenido_pais_configurar");
    }


    //// METODO EJECUCCION //////
    public void ejecucion() throws Exception {   

        setTrazaFichero();
        accion = conectorParametro("accion")==null?"":conectorParametro("accion");
        sMarca = conectorParametro("cbMarca")==null?"":conectorParametro("cbMarca");
        sCanal = conectorParametro("cbCanal")==null?"":conectorParametro("cbCanal");
        hMoneda = conectorParametro("cbMoneda")==null?"":conectorParametro("cbMoneda");
        //txtSerie = conectorParametro("txtLonSerie")==null?"":conectorParametro("txtLonSerie");
        //txtTipo = conectorParametro("txtLonTipo")==null?"":conectorParametro("txtLonTipo");
        oidConfiguracionMF = (conectorParametro("oidConfiguracionMF")==null || conectorParametro("oidConfiguracionMF").equals(""))?
        null: Long.valueOf(conectorParametro("oidConfiguracionMF"));
   
  
        idioma = UtilidadesSession.getIdioma(this);
        pais = UtilidadesSession.getPais(this);

        if (accion == null)
            accion = "";

        traza("Accion: " + accion);	
	  
        try {

            //Funcion Rastreo 
            //rastreo(); 

            if (accion.equals("")) {
                asignarAtributo("VAR","accion","valor","");
                traza ("========> ACCION: ");
                // Para desabilitar el combo y los textos;
                getConfiguracionMenu("LPConfigurarMFPais","");
                traza ("==========> LLAMO AL CARGARPASIMARCACANAL()");
                this.cargarPaisMarcaCanal();
                traza ("==========> Llamó al cargarPaisMarcaCanal()");
                // Cargo los Combo de Marca y Canal
            }else if (accion.equals("Siguiente")) {
                siguiente();
                cargarPaisMarcaCanal();
                cargarDatos();
            }else  if (accion.equals("Guardar")){
                guardar();
            }
            // VER SI TENGO QUE CARGAR LOS COMBOS DE NUEVO
            //cargarPaisMarcaCanal();
        } catch (Exception ex) {
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            cargarPaisMarcaCanal();
            cargarDatos();
            llenarCamposException();
        } 

    }

    /* HACER METODO PARA QUE DESHABILITE LOS CAMPOS Y HABILITE SEGUN DONDE ESTE
    * SI ESTOY ARRIBA O ABAJO Y CAMBIAR LA LLAMADA DE CARGARPAISMARCACANAL
    */

    private void llenarCamposException() throws Exception {

        traza ("========> ENTRA AL LLENAR CAMPOS EXCEPTION");
        traza (accion);
        if (accion.equals("Siguiente")){
            asignarAtributo("VAR","accion","valor","");
        }else if (accion.equals("Guardar")){
            asignarAtributo("VAR","accion","valor","Guardar");
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
 
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }

    /**
    * Se cargan paises, marcas y canales en los combos correspondientes
    **/
    private void cargarDatos() throws Exception{
        asignarAtributo("VAR","hMoneda","valor",hMoneda);
        asignarAtributo("VAR","sMarca","valor",sMarca);
        asignarAtributo("VAR","sCanal","valor",sCanal);
        asignarAtributo("VAR","oidConfiguracionMF","valor",oidConfiguracionMF==null?"":oidConfiguracionMF.toString());
        //asignarAtributo("CTEXTO","txtLonSerie","valor",txtSerie);
        //asignarAtributo("CTEXTO","txtLonTipo","valor",txtTipo);
    }

    private void cargarPaisMarcaCanal() throws Exception {
        es.indra.sicc.dtos.seg.DTOFiltroPMC paisMarcaCanal = new es.indra.sicc.dtos.seg.DTOFiltroPMC();
        traza ("==========> SETEO LAS VARIABLES EN EL CARGARPAISMARCACANAL()");
        paisMarcaCanal.setOidIdioma(new Long (1));
        paisMarcaCanal.setPaises(Boolean.TRUE);
        paisMarcaCanal.setMarcas(Boolean.TRUE);
        paisMarcaCanal.setCanales(Boolean.TRUE);
      
        Vector paramEntrada = new Vector();
        paramEntrada.add(paisMarcaCanal);
 
        paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));

        traza ("==========> CONECTO CONECTORCARGARPAISMARCACANAL");
        DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);

        IMareDTO dtoSalida = (IMareDTO)conectorCargarPaisMarcaCanal.objeto("dtoSalidaObjeto");

        traza ("==========> CARGO LOS COMBOS DE MARCA Y CANAL");
        // Cargo los combos de Marca y Canal      
        asignar("COMBO", "cbMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "cbCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

        asignarAtributo("VAR", "sMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
        asignarAtributo("VAR", "sCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
        asignarAtributo("VAR", "hMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString());
        asignarAtributo("VAR", "hCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString());
    }

    private void siguiente() throws Exception {
        traza ("========> ACCION: SIGUIENTE");
    
        getConfiguracionMenu("LPConfigurarMFPais","Guardar");
        // Creo en DTOLeerConfiguracionMF

        asignarAtributo("VAR","accion","valor","Siguiente");
    
        traza ("Anter de llenar el DTO");
        DTOELeerConfiguracionMF dtol = new DTOELeerConfiguracionMF();
    
        // Seteo las variables al conector
        dtol.setOidMarca(Long.valueOf(conectorParametro("oidMarca")));
        dtol.setOidCanal(Long.valueOf(conectorParametro("oidCanal")));
        dtol.setOidIdioma(idioma);
        dtol.setOidPais(pais);
        traza ("Despues de llenar el DTO");
        //Creo el idBusiness "PRELeerConfiguracionMF"
        MareBusinessID id = new MareBusinessID("PRELeerConfiguracionMF");
    
        // Creo el Vector y lo cargo con el id t dot para pasarlo al Conector
        Vector paramEntrada   = new Vector();
        paramEntrada.addElement(dtol);
        paramEntrada.addElement(id); 

        // Creo el conector conectorLeerConfiguracionMF
        traza ("Creo el Vector y lo cargo con el id t dot para pasarlo al Conector");
        DruidaConector conectorLeerConfiguracionMF = null;

        // Conecto 
        conectorLeerConfiguracionMF  = conectar("ConectorLeerConfiguracionMF", paramEntrada);

        DTOSConfiguracionMF dtoSalida = (DTOSConfiguracionMF) conectorLeerConfiguracionMF.objeto("dtoSalida");
        RecordSet r = new RecordSet();
        r.addColumn("OID");
        r.addColumn("VALOR");

        Vector v = null;
        //se ordena el campo moneda
        if (ConstantesPRE.MONEDA_PAIS.compareToIgnoreCase(dtoSalida.getDescripcionMoneda()) <= 0) {
          v = new Vector();
          v.add(ConstantesPRE.MONEDA_PAIS);
          v.add(ConstantesPRE.MONEDA_PAIS);
          r.addRow(v);
          v = new Vector();
          v.add(dtoSalida.getOidMonedaAlternativa());
          v.add(dtoSalida.getDescripcionMoneda());
          r.addRow(v);          
        } else {
          v = new Vector();
          v.add(dtoSalida.getOidMonedaAlternativa());
          v.add(dtoSalida.getDescripcionMoneda());
          r.addRow(v);
          v = new Vector();
          v.add(ConstantesPRE.MONEDA_PAIS);
          v.add(ConstantesPRE.MONEDA_PAIS);
          r.addRow(v);        
        }
        
        asignar("COMBO","cbMoneda",UtilidadesBelcorp.generarConector("dtoSalida_RowSet",r,
        r.getColumnIdentifiers()));
    
        if (dtoSalida.getOidConfiguracionMF() != null){
            //cargo la configuracion en la pantalla, el asignar atriburo espera todos String
            hMoneda = dtoSalida.getOidMoneda()!=null?dtoSalida.getOidMoneda().toString():ConstantesPRE.MONEDA_PAIS;
            //txtTipo = dtoSalida.getLongitudTipo().toString();
            //txtSerie = dtoSalida.getLongitudSerie().toString();
            oidConfiguracionMF = dtoSalida.getOidConfiguracionMF();
                             
        }else {
            // salta si asigno null
            hMoneda = ConstantesPRE.MONEDA_PAIS;
            //txtTipo = "";
            //txtSerie = "";
        }
    }

    private void guardar() throws Exception {
        traza ("====> ENTRA AL GUARDAR");
        // Crea el DTO   
        DTOEConfiguracionMF dtoe = new DTOEConfiguracionMF();
        traza ("====> ENTRA AL GUARDAR ===> CREA EL DTO");
    
        // Setea el DTO
        dtoe.setOidConfiguracionMF(oidConfiguracionMF);
        //dtoe.setLongitudTipo(Integer.valueOf(conectorParametro("longitudTipo")));
        //dtoe.setLongitudSerie(Integer.valueOf(conectorParametro("longitudSerie")));
        dtoe.setOidPais(pais);
        dtoe.setOidIdioma(idioma);
        dtoe.setOidMarca(Long.valueOf(sMarca));
        dtoe.setOidCanal(Long.valueOf(sCanal));
        if (hMoneda.equalsIgnoreCase(ConstantesPRE.MONEDA_PAIS))
            dtoe.setOidMoneda(null);
        else
            dtoe.setOidMoneda(Long.valueOf(hMoneda));
        traza ("====> ENTRA AL GUARDAR ===> SETEA EL DTO");

        // Crea el MareBusinessID  
        MareBusinessID idB = new MareBusinessID("PREGuardarConfiguracionMF");
        traza ("====> ENTRA AL GUARDAR ===> CREA EL MAREBUSINESSID");

        //Creo el Vector y lo cargo con el id t dot para pasarlo al Conector 
        Vector paramEntrada2   = new Vector();
        paramEntrada2.addElement(dtoe);
        paramEntrada2.addElement(idB); 
        traza ("====> ENTRA AL GUARDAR ===> AGREGA EN PARAM");
        traza (paramEntrada2);
    
        //Creo el conector conectorGuardarConfiguracionMF 
        DruidaConector conectorGuardarConfiguracionMF = null;
        traza ("====> ENTRA AL GUARDAR ===> CREA EL CONECTOR");
        //  Conecto 
        conectorGuardarConfiguracionMF  = conectar("ConectorGuardarConfiguracionMF",paramEntrada2);
        traza ("====> ENTRA AL GUARDAR ===> CONECTO");
        // Carga de nuevo la LP con la accion "" ????
        traza ("====> ENTRA AL GUARDAR ===> SETEO LA LP Y LA ACCION");
        conectorAction("LPConfigurarMFPais");
        conectorActionParametro("accion","");
    }
}
