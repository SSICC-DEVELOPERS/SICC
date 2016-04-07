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

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.UtilidadesLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
//import es.indra.sicc.dtos.pre


/**
 * Sistema:                Belcorp - SICC
 * Modulo:                  PRE - Precios
 * Componente:            LPSeleccionarMF
 * Fecha:                   13/02/2004
 * Dcoumentacion:         
 *                            documentos: SICC-DMCO-MEN-201-307
 * Observaciones:
 * @version                3.0
 * @author                  Cintia Verónica Argain
 */
public class LPSeleccionarMF extends LPSICCBase {
    private final String nombreLogica = "LPSeleccionarMF";

    private Long oidCabeceraMF;
    private String sDesPaisSelec ;
    private String sDesMarcaSelec;
    private String sDesCanalSelec;
    private String sDesPeriSelec;

    private String nombreLogicaLP;
    
    // Agregar por SICC20070322 - Rafael Romero - 24/07/2007
    String sAccion = null;
    String sNueva = null;
    // Fin agregado SICC20070322

    public LPSeleccionarMF() {
          super();
    }

    public void inicio() throws Exception {
          pagina("contenido_matriz_facturacion_seleccionar");
    }

    
    public void ejecucion() throws Exception {
          setTrazaFichero();      
          /*.................................Cuerpo principal.................................*/
          // Modificado por SICC20070322 - Rafael Romero - 24/07/2007
          sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
          sNueva = conectorParametro("nueva")==null?"":conectorParametro("nueva");
          // Fin modificado SICC20070322

          Vector paramEntrada = new Vector();
          DruidaConector ConectorBuscaMatrices = null;   

          traza("Accion elegida: " + sAccion );
          traza("nueva: " + sNueva );

          try {
             
              /*......................1.Se verifica la acción seleccionada ....................*/
              if (sAccion.equals("")) {
              // Modificado por SICC20070322
                    if((conectorParametroSesion("oidCabeceraMF") != null) &&
                            (conectorParametroSesion("descripcionPais") != null) &&
                            (conectorParametroSesion("descripcionMarca") != null) &&
                            (conectorParametroSesion("descripcionCanal") != null) &&
                            (conectorParametroSesion("descripcionPeriodo") != null)
                            ){
                        UtilidadesLog.debug("Existe una MF seleccionada en session. Se redirecciona...");
                        conectorAction((String)conectorParametroSesion("UltimaLP"));
                        conectorActionParametro("accion","Matriz seleccionada");
                    }else{
                        UtilidadesLog.debug("No existe MF seleccionada en session. Se carga pantalla para elegir una.");
                        cargarPagina();
                    }
              }else if (sAccion.equals("ElegirMatriz")){
                    cargarPagina();
              // Fin modificado SICC20070322
              }else if (sAccion.equals("Matriz seleccionada")) {

                    // Leo los datos seleccionados de la lista
                    oidCabeceraMF = Long.valueOf(conectorParametroLimpia("hidOidCabeceraMF", "", true));
                    sDesPaisSelec = new String(conectorParametroLimpia
                                         ("hidDesPaisSelec", "", true));
                    sDesMarcaSelec = new String(conectorParametroLimpia
                                         ("hidDesMarcaSelec", "", true));
                    sDesCanalSelec = new String(conectorParametroLimpia
                                         ("hidDesCanalSelec", "", true));
                    sDesPeriSelec = new String(conectorParametroLimpia
                                         ("hidDesPeriSelec", "", true));
                    /*... Guarda los datos de la matriz seleccionada en sesión ...*/
                    
                    conectorParametroSesion("oidCabeceraMF",oidCabeceraMF);
                    conectorParametroSesion("descripcionPais", sDesPaisSelec);
                    conectorParametroSesion("descripcionMarca", sDesMarcaSelec);
                    conectorParametroSesion("descripcionCanal", sDesCanalSelec);
                    conectorParametroSesion("descripcionPeriodo", sDesPeriSelec);

                    // Modificado por SICC20070322 - Rafael Romero - 25/07/2007
                    if(conectorParametroSesion("UltimaLP")!=null && !((String)conectorParametroSesion("UltimaLP")).equals("")){
                        conectorAction((String)conectorParametroSesion("UltimaLP")); 
                        conectorActionParametro("accion","Matriz seleccionada");
                    }else{
                        conectorAction("LPElegirMatrizFacturacion"); 
                    }
                    // Fin modificado SICC20070322
                    
			  }

		  } catch (Exception e) {
              ByteArrayOutputStream pila = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(pila);
              e.printStackTrace(out);
              traza("EL STACK ES COMO SIGUE : " + pila.toString());
              lanzarPaginaError(e);
          }
    }


    public void EstablecerMatrizSeleccionada() throws Exception   {
          oidCabeceraMF =   
                    (conectorParametroSesion("oidCabeceraMF") != null)?
                    (Long)conectorParametroSesion("oidCabeceraMF"):
                    null;
          
          sDesPaisSelec =   
                    (conectorParametroSesion("descripcionPais") != null)?
                    (String)conectorParametroSesion("descripcionPais"):
                    null;  

          sDesMarcaSelec =   
                    (conectorParametroSesion("descripcionMarca") != null)?
                    (String)conectorParametroSesion("descripcionMarca"):
                    null;  

          sDesCanalSelec =   
                    (conectorParametroSesion("descripcionCanal") != null)?
                    (String)conectorParametroSesion("descripcionCanal"):
                    null;
                              
          sDesPeriSelec =
                    (conectorParametroSesion("descripcionPeriodo") != null)?
                    (String)conectorParametroSesion("descripcionPeriodo"):
                    null;

         
          if (oidCabeceraMF != null){
              asignarAtributo("VAR","hidOidCabeceraMF","valor",oidCabeceraMF.toString());
          }
                                         
          if (sDesPaisSelec != null)
              asignarAtributo("VAR", "hidDesPaisSelec", "valor", sDesPaisSelec);

          if (sDesMarcaSelec != null)
              asignarAtributo("VAR", "hidDesMarcaSelec", "valor", sDesMarcaSelec);
                                         
          if (sDesCanalSelec != null)
              asignarAtributo("VAR","hidDesCanalSelec","valor",sDesCanalSelec);

          if (sDesPeriSelec != null)
              asignarAtributo("VAR","hidDesPeriSelec","valor",sDesPeriSelec);      
    }
    
    
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void cargarPagina() throws Exception{
        String error = conectorParametroLimpia("hidError","",true);
        asignarAtributo("VAR","hidError","valor",error);
        /*Se deshabilita el botón nueva de acuerdo a la variable de sesión nueva*/
        if (sNueva.equals(""))
             asignarAtributo("VAR","hidOcultarNueva","valor","SI"); 
        else
             asignarAtributo("VAR","hidOcultarNueva","valor", "NO");
        String parametro = conectorParametroLimpia("hidParametro","",true);
        asignarAtributo("VAR","hidParametro","valor", parametro);
        
        EstablecerMatrizSeleccionada();
        this.getConfiguracionMenu("LPSeleccionarMF","");
        //String ultima = (String)conectorParametroSesion("UltimaLP");
    }

}

