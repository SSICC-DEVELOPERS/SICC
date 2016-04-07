import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.mav.DTOParametroDBP;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import java.util.ArrayList;
import java.util.Vector;

public class LPMantenimientoPDBP extends LPSICCBase  {

    public static final String CODIGO_CAMPO_VD_NEBP_ACCE     = "002";
    public static final String CODIGO_CAMPO_VD_NEBP_SUB_ACCE = "003";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_OFER = "004";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_CLIE = "005";
    public static final String CODIGO_CAMPO_VD_NEBP_SBT_CLIE = "006";
    public static final String CODIGO_CAMPO_VD_NEBP_CIC_VIDA = "007";
    public static final String CODIGO_CAMPO_VD_NEBP_CRI_ASIG = "008";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_DESP = "009";

    String casoDeUso;
    String accion;
    Long idioma;
    Long pais;
    
    public LPMantenimientoPDBP() {
        super();    
    }

    public void inicio() throws Exception {
        pagina("contenido_param_bp_valores_defecto");
        getFormatosValidaciones();
        //asignarAtributoPagina("cod","01077");
        getConfiguracionMenu("LPMantenimientoPDBP");
    }

    public void ejecucion() throws Exception {

        setTrazaFichero();
        rastreo();
        
        casoDeUso = conectorParametroLimpia("casoDeUso","",true);
        accion = conectorParametroLimpia("accion","",true);
        idioma = UtilidadesSession.getIdioma(this);
        pais = UtilidadesSession.getPais(this);
        
        UtilidadesLog.debug("casoDeUso:["+casoDeUso+"]");
        UtilidadesLog.debug("accion:["+accion+"]");
        
        // Realizando logica segun accion
        try {
            asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
            asignarAtributo("VAR","accion","valor",accion);
            asignarAtributo("VAR","hPais","valor",pais.toString());
            asignarAtributo("VAR","hIdioma","valor",idioma.toString());
            if(accion.equals("guardar")){ // Aqui se capturan los valores recibidos y se envia los datos al servidor
                DTOValoresDefectoDatosBP dtoe = new DTOValoresDefectoDatosBP();

                String actividad = conectorParametroLimpia("hOidActi","",true);
                String canal = conectorParametroLimpia("hOidCana","",true);
                String acceso = conectorParametroLimpia("hOidAcce","",true);
                String subAcceso = conectorParametroLimpia("hOidSubAcce","",true);
                String tipoOferta = conectorParametroLimpia("hOidTipOfer","",true);
                String tipoCliente = conectorParametroLimpia("hOidTipClie","",true);
                String subTipoCliente = conectorParametroLimpia("hOidSubTipClie","",true);
                String cicloVida = conectorParametroLimpia("hOidCicVida","",true);
                String critAsig = conectorParametroLimpia("hOidCriAsig","",true);
                String tipoDespacho = conectorParametroLimpia("hOidTipDesp","",true);
                
                if(actividad.length()>0){
                    dtoe.setOidActividad(new Long(actividad));
                    ArrayList lista = new ArrayList();
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_ACCE,acceso);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_SUB_ACCE,subAcceso);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_TIP_OFER,tipoOferta);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_TIP_CLIE,tipoCliente);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_SBT_CLIE,subTipoCliente);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_CIC_VIDA,cicloVida);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_CRI_ASIG,critAsig);
                    agregarElemento(lista,CODIGO_CAMPO_VD_NEBP_TIP_DESP,tipoDespacho);
                    dtoe.setValoresDefecto(lista);
                    
                    pagina("salidaGenerica");
                    MareBusinessID bussID = new MareBusinessID("MAVGuardarValoresDefectoActividadDBP");
                    Vector params = new Vector();
                    params.add(dtoe);
                    params.add(bussID);
                    
                    try{
                        DruidaConector con = conectar("ConectorGuardarRegistrosMAV", params);
                        asignarAtributo("VAR", "ejecutar", "valor", "ejecucionCorrecta();");
                    }catch(Exception e){
                        asignarAtributo("VAR", "ejecutarError", "valor", "ejecucionError();");
                        this.lanzarPaginaError(e);
                    }
                    
                }else{
                    UtilidadesLog.debug("No se ha establecido actividad");
                }
                
            }else{ // Toda accion que no sea guardar debe mostrar los valores
                UtilidadesLog.debug("Iniciando configuracion de pantalla... ");
                ComposerViewElementList cListCarga = preparaCargaInicial();
                ConectorComposerView conector = new ConectorComposerView(cListCarga, this.getRequest());
                conector.ejecucion();
                DruidaConector conPantalla = conector.getConector();
                asignar("COMBO", "cbCanal", conPantalla, "SEGConsultaCanales");
            
                String canal = conectorParametroLimpia("hOidCana","",true);
                asignarAtributo("VAR","hOidCana","valor",canal);

                String actividad = conectorParametroLimpia("hOidActi","",true);
                asignarAtributo("VAR","hOidActi","valor",actividad);

                UtilidadesLog.debug("canal:["+canal+"]");
                UtilidadesLog.debug("actividad:["+actividad+"]");
                
                if(actividad.length()>0){
                    MareBusinessID bussID = new MareBusinessID("MAVObtenerValoresDefectoActividadDBP");
                    Vector params = new Vector();
                    DTOValoresDefectoDatosBP dtoe = new DTOValoresDefectoDatosBP();
                    dtoe.setOidActividad(new Long(actividad));
                    dtoe.setOidPais(pais);
                    params.add(dtoe);
                    params.add(bussID);
                    DruidaConector con = this.conectar("ConectorBuscarParametrosDBP", params);
                    DTOValoresDefectoDatosBP dtos = (DTOValoresDefectoDatosBP) con.objeto("dtoSalida");
                    
                    UtilidadesLog.debug("DTO obtenido:\n"+dtos);
                    
                    ArrayList lista = dtos.getValoresDefecto();
                    if(lista!=null && lista.size()>0){
                        for(int i = 0; i < lista.size(); i++){
                            DTOParametroDBP dtoi = (DTOParametroDBP)lista.get(i);
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_ACCE)){
                                asignarAtributo("VAR","hOidAcce","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_SUB_ACCE)){
                                asignarAtributo("VAR","hOidSubAcce","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_TIP_OFER)){
                                asignarAtributo("VAR","hOidTipOfer","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_TIP_CLIE)){
                                asignarAtributo("VAR","hOidTipClie","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_SBT_CLIE)){
                                asignarAtributo("VAR","hOidSubTipClie","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_CIC_VIDA)){
                                asignarAtributo("VAR","hOidCicVida","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_CRI_ASIG)){
                                asignarAtributo("VAR","hOidCriAsig","valor",dtoi.getValor());
                            }
                            if(dtoi.getCodigo().equals(CODIGO_CAMPO_VD_NEBP_TIP_DESP)){
                                asignarAtributo("VAR","hOidTipDesp","valor",dtoi.getValor());
                            }
                        }
                    }
                }
            }

        }catch(Exception e){
            this.lanzarPaginaError(e);
        }catch (Throwable th) {
            UtilidadesLog.error("ERROR TH en la ejecucion de la logica",th);
            this.lanzarPaginaError(new Exception(th));
        }
    }
    
    private void agregarElemento(ArrayList lista, String codigo, String valor){
        DTOParametroDBP dto = new DTOParametroDBP();
        dto.setOidPais(pais);
        dto.setCodigo(codigo);
        dto.setValor(valor);
        lista.add(dto);
    }
    
    private ComposerViewElementList preparaCargaInicial() throws Exception{
        UtilidadesLog.debug("Configurando sub-sistema de carga inicial...");
        DTOBelcorp dtoe = new DTOBelcorp();
        
        ComposerViewElementList cList = new ComposerViewElementList();
        ComposerViewElement cElem1 = new ComposerViewElement();
        
        dtoe.setOidIdioma(idioma);
        dtoe.setOidPais(pais);
        
        cElem1.setIDBusiness("SEGConsultaCanales");
        cElem1.setDTOE(dtoe);
        
        cList.addViewElement(cElem1);
        
        return cList;
    }

}
