import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.pre.DTOECabeceraMF;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.util.Vector;

public class LPSeleccionarNuevaMF extends LPSICCBase {
    String accion = null;
    String marca = null;
    String canal = null;
    String periodo = null;
    String descPeriodo = null;
    String descMarca = null;
    String descCanal = null;
    String descPais = null;
    String pedEstimados = null;
    String unidadesEstimadas = null;
    String clientesEstimados = null;
    String valorEstimado = null;
    Long pais = null;
    Long idioma = null; 
    String tipoCambio = null;
    Long oid = null;
    String idUsuario = null;
  
    public LPSeleccionarNuevaMF()  {
        super();
    }  

    public void inicio() throws Exception {
      
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("Ingresando a LPSeleccionarNuevaMF");
        try {
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            descPais = UtilidadesSession.getDescripcionPais(this);
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            canal = conectorParametro("cbCanal")==null?"":conectorParametro("cbCanal");
            marca = conectorParametro("cbMarca")==null?"":conectorParametro("cbMarca");
            periodo = conectorParametro("cbPeriodo")==null?"":conectorParametro("cbPeriodo");
            pedEstimados = conectorParametro("txtPedEstimados")==null?"":conectorParametro("txtPedEstimados");
            unidadesEstimadas = conectorParametro("txtUniEstimadas")==null?"":conectorParametro("txtUniEstimadas");
            clientesEstimados = conectorParametro("txtCliEstimados")==null?"":conectorParametro("txtCliEstimados");
            valorEstimado = conectorParametro("txtValorEstimado")==null?"":conectorParametro("txtValorEstimado");
            tipoCambio = conectorParametroNumero("txtTipoCambio",this.FORMATO_DEFAULT)==null?"":conectorParametroNumero("txtTipoCambio",this.FORMATO_DEFAULT);

            descPeriodo = conectorParametro("hidDescPeriodo")==null?"":conectorParametro("hidDescPeriodo");
            descMarca = conectorParametro("hidDescMarca")==null?"":conectorParametro("hidDescMarca");
            descCanal = conectorParametro("hidDescCanal")==null?"":conectorParametro("hidDescCanal");
            
            asignarAtributo("VAR","hidIdioma","valor",idioma.toString());
            asignarAtributo("VAR","hidPais","valor",pais.toString());

            traza("Accion elegida: " + accion );
            
            if (accion.equals("")) {
                conectorAction("LPSeleccionarMF");
                conectorParametroSesion("UltimaLP","LPSeleccionarNuevaMF");
                conectorActionParametro("nueva","true");
                
            }else if (accion.equals("Guardar")){
                pagina("salidaGenerica");
                guardar();
            }else if (accion.equals("Matriz seleccionada")){
                pagina("contenido_matriz_facturacion_nueva_seleccionar");
                cargarMarcaCanal();
                cargarDatos();
                getConfiguracionMenu("LPSeleccionarNuevaMF","");
            }
        }catch(Exception ex){
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
            //cargarMarcaCanal();
            //cargarDatos();
        }
        
    }
    
    private void guardar() throws Exception{
        traza("Entra a guardar SeleccionarNuevaMF");
        /*.................Crea el idBusiness="PREGuardarCabeceraMF......   .....*/
        MareBusinessID id = new MareBusinessID("PREGuardarCabeceraMF");
        /*......................Crea el DTOECabeceraMF........................*/
        DTOECabeceraMF dto = new DTOECabeceraMF();
        dto.setOidCanal(Long.valueOf(canal));
        dto.setOidMarca(Long.valueOf(marca));
        dto.setOidPeriodo(Long.valueOf(periodo));
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        
        dto.setNumeroPedidosEstimado(pedEstimados.equals("")?null:Long.valueOf(pedEstimados));
        dto.setUnidadesEstimadas(unidadesEstimadas.equals("")?null:Long.valueOf(unidadesEstimadas));
        dto.setClientesEstimados(clientesEstimados.equals("")?null:Long.valueOf(clientesEstimados));
        dto.setTotalMontoVentaNeta(valorEstimado.equals("")?null:Long.valueOf(valorEstimado));
        dto.setTipoCambioPromedioPeriodo(tipoCambio.equals("")?null:Double.valueOf(tipoCambio));
        dto.setRegistroEstadisticoGenerado(Boolean.FALSE);
        dto.setMatrizFacturada(Boolean.FALSE);
        dto.setMatrizGenerada(Boolean.FALSE);
        Vector param = new Vector();
        param.add(dto);
        
        param.add(id);
        /*......................Invoca a ConectorGuardarCabeceraMF............*/
        DruidaConector conSalida;
        try{
            conSalida = conectar("ConectorGuardarCabeceraMF",param);
        }catch(Exception e){
            traza("Error!!!!!");
            asignarAtributo("VAR","ejecutarError","valor","");
            e.printStackTrace();
            throw e;
        }
        traza("Grabe cabecera nueva");
        /*.....................Recoge el DTOSGuardarCabeceraMF................*/
        DTOOID dtoS = (DTOOID) conSalida.objeto("dtoSalida");
        //traza(dtoS);
        /*...........obtiene el identificador de la matriz (oidCabeceraMF)....*/ 
        oid = dtoS.getOid();
        /*...........Guarda los datos de la matriz seleccionada en sesión.....*/ 
        conectorParametroSesion("oidCabeceraMF",oid);
        conectorParametroSesion("descripcionPais",descPais);
        conectorParametroSesion("descripcionMarca",descMarca);
        conectorParametroSesion("descripcionCanal",descCanal);
        conectorParametroSesion("descripcionPeriodo",descPeriodo);
        /*.....Recoge de sesión la ultima LP activa (variable UltimaLP........*/
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("LPSeleccionarNuevaMF-guardar......: Invocando UltimaLP: "+
                (String)conectorParametroSesion("UltimaLP"));
        traza("oidCabeceraMF: "+ oid);
        traza("Pais Seleccionada:  " + descPais);
        traza("Marca Seleccionada:  " + descMarca);
        traza("Canal Seleccionada:  " + descCanal);
        traza("Periodo Seleccionada:  " + descPeriodo);
        
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");        
        conectorAction((String)conectorParametroSesion("UltimaLP"));
        /*..........la invoca con accion "Matriz seleccionada"................*/
        conectorActionParametro("accion","Matriz seleccionada");
    }
    
    private void cargarMarcaCanal() throws Exception{
        traza("Entró de Cargar Marca - Canal");
        es.indra.sicc.dtos.seg.DTOFiltroPMC paisMarcaCanal = new es.indra.sicc.dtos.seg.DTOFiltroPMC();
        paisMarcaCanal.setOidIdioma(idioma);
        paisMarcaCanal.setPaises(Boolean.TRUE);
        paisMarcaCanal.setMarcas(Boolean.TRUE);
        paisMarcaCanal.setCanales(Boolean.TRUE);
   
        Vector paramEntrada = new Vector();
        paramEntrada.add(paisMarcaCanal);

        paramEntrada.add(new MareBusinessID("CRAPaisMarcaCanal"));
        DruidaConector conectorCargarPaisMarcaCanal = conectar("ConectorCargarPaisMarcaCanal", paramEntrada);
        IMareDTO dtoSalida = (IMareDTO)conectorCargarPaisMarcaCanal.objeto("dtoSalidaObjeto");
      
        asignar("COMBO", "cbMarca", conectorCargarPaisMarcaCanal, "dtoSalida.marcas_ROWSET");
        asignar("COMBO", "cbCanal", conectorCargarPaisMarcaCanal, "dtoSalida.canales_ROWSET");

        /*asignarAtributo("VAR", "hMarca", "valor", this.marca);
        asignarAtributo("VAR", "hCanal", "valor", this.canal);*/
        traza("Salio de Cargar Marca - Canal");
    }

    /*private void cargarPeriodo() throws Exception{
        traza("Entró a Cargar Periodo");
        DTOPeriodo dtoe = new DTOPeriodo();
        dtoe.setOidPais(pais);
        dtoe.setMarca(Long.valueOf(marca));
        dtoe.setCanal(Long.valueOf(canal));
   
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoe);

        paramEntrada.add(new MareBusinessID("PRECargarPeriodos"));
        DruidaConector conectorPeriodo = conectar("ConectorGuardarCabeceraMF", paramEntrada);
        IMareDTO dtoSalida = (IMareDTO)conectorPeriodo.objeto("dtoSalida");
      
        asignar("COMBO", "cbPeriodo", conectorPeriodo, "dtoSalida.marcas_ROWSET");

        asignarAtributo("VAR", "hPeriodo", "valor", this.periodo);
        traza("Salio de Cargar Periodo");
    }*/
    
    private void cargarDatos() throws Exception{
        traza("esta en cargar datos");

        asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","hidMarca","valor",UtilidadesSession.getMarcaPorDefecto(this).toString());
        asignarAtributo("VAR","hidCanal","valor",UtilidadesSession.getCanalPorDefecto(this).toString());
        asignarAtributo("VAR","hPeriodo","valor",periodo);
        asignarAtributo("VAR","hidPais","valor",UtilidadesSession.getPais(this).toString());
        asignarAtributo("LABELC","lblPaisX","valor",descPais);
        getFormatosValidaciones();
    }

    /**
    * Imprime el stack trace en caso de errores.
    */
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
}
