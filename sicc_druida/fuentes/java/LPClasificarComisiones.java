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
 
  
 /**
 * Sistema:             Belcorp - SICC
 * Modulo:              COM - Comisiones
 * Componente:          LPClasificarComisiones
 * Fecha:               05/05/2005
 * Dcoumentacion:       
 *                      documentos: SICC-DMCO-COM-202-334-N034
 * Observaciones:
 * @version             3.4
 * @author              Cintia Verónica Argain
 */
 
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.com.DTOClasificarComisiones;

/*Imports para el uso del subsistema GestorCargaPantalla */
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

public class LPClasificarComisiones extends LPSICCBase {
    
    private String  sAccion = null;    
    private Long lIdioma 	= null;
    private Long lPais 		= null;
    private Long lOidMarca;
    private Long lOidCanal;
    private Long lOidPeriodo;
    

    public LPClasificarComisiones() {
    }

    public void inicio() throws Exception {
        pagina("contenido_comisiones_clasificar");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();

        try{
			this.rastreo();
            //sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
            sAccion = conectorParametroLimpia("accion","",true);
            lIdioma = UtilidadesSession.getIdioma(this);
            lPais = UtilidadesSession.getPais(this);
            Long lMarca = UtilidadesSession.getMarcaPorDefecto(this);
            Long lCanal = UtilidadesSession.getCanalPorDefecto(this);
            traza(">>>> Acción................" + sAccion);            
            traza(">>>> Idioma................" + lIdioma);
            traza(">>>> Pais.................." + lPais);
            traza(">>>> Marca................." + lMarca);            
            traza(">>>> Canal................." + lCanal);
            
			asignarAtributo("VAR","oidPais","valor",lPais.toString());
            asignarAtributo("VAR","hidMarcaDef","valor", lMarca.toString());
            asignarAtributo("VAR","hidCanalDef","valor", lCanal.toString());
			
/*
 Si (accion == "") entonces 
    -> ejecutar el método privado "cargarPagina()" 
sino Si (accion == "clasificar") entonces 
-> ejecutar el método privado "clasificarComisiones()"
*/
            if (sAccion.equals(""))
            {
                cargarPagina();
                asignarAtributoPagina("cod","0662");
                getConfiguracionMenu("LPClasificarComisiones","");
            }
            else if (sAccion.equals("clasificar"))
            {
                clasificarComisiones();
                //pagina("contenido_comisiones_clasificar");
                //cargarPagina();
            }            
        }catch(Exception ex) {
             logStackTrace(ex);
             this.lanzarPaginaError(ex);
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
    
    private void cargarPagina()throws Exception
    {
        traza("Entrando a cargarPagina" );
//-> Crear un DTOBelcorp con pais e idioma de la sesión 
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidPais(lPais);
        dto.setOidIdioma(lIdioma);
//- idBusiness = "SEGConsultaMarcas" y DTOBelcorp => llena el combo "marca" 
//- idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena el combo "canal" 
        cargarMarcaCanal(dto);
//-> Mostrar página
    }
    
    private void clasificarComisiones() throws Exception{
        traza("Entrando a clasificarComisiones" );
        pagina("salidaGenerica");	/*Envio oculto!*/
        Long lOidMarca  = Long.valueOf(conectorParametro("hidOidMarca"));        
        Long lOidCanal  = Long.valueOf(conectorParametro("hidOidCanal"));
        Long lOidPeriodo  = Long.valueOf(conectorParametro("hidOidPeriodo"));
        
//->Crear un DTOClasificarComisiones "dtoEntrada" con: 
        DTOClasificarComisiones dtoEntrada = new DTOClasificarComisiones ();
//=> oidMarca , get(marca) 
        dtoEntrada.setOidMarca(lOidMarca);
//=> oidCanal , get(canal) 
        dtoEntrada.setOidCanal(lOidCanal);
//=> oidPeriodo , get(periodo) 
        dtoEntrada.setOidPeriodo(lOidPeriodo);
//=> oidPais, se toma el pais de sesion 
        dtoEntrada.setOidPais(lPais);
//=> oidIdioma, se toma el idioma de sesion 
        dtoEntrada.setOidIdioma(lIdioma);
//=> Se crea el idBusiness = COMClasificarComisiones 
        MareBusinessID idClasifCom = new MareBusinessID("COMClasificarComisiones");
//=> Asignar el conector ConectorClasificarComisiones con: ->idBBusiness 
//->dtoEntrada    
        Vector paramClasCom = new Vector();
        paramClasCom.add(dtoEntrada);
        paramClasCom.add(idClasifCom);
        try{
            DruidaConector conSalidaDtoDG = conectar("ConectorClasificarComisiones",paramClasCom);
            asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
        }
        catch(Exception ex)
        {
            asignarAtributo("VAR","ejecutarError","valor","accionError()");
            throw ex;
        }
    }
    
    /*=================Uso del subsistema GestorCargaPantalla==================*/
    private void cargarMarcaCanal(DTOBelcorp dtoBel) throws Exception{
        //Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntradaMarcaCanal(dtoBel);
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");

        traza(">>>>>>>> Salio de cargarMarcaCanal");
    }
    
     private ComposerViewElementList crearParametrosEntradaMarcaCanal(DTOBelcorp dtoBel){
        
		ComposerViewElementList lista = new ComposerViewElementList();
		//Combo Marca
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGConsultaMarcas");
		//Combo Canal
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("SEGConsultaCanales");
		ci2.setDTOE(dtoBel);
        
		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
        
		return lista;
	}
}
