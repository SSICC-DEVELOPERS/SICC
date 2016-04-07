/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
* 
* 
* @Autor: Paola Cabrera
* @Fecha: 17/01/2006
* @Modulo: CCC
* 
*/ 

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;
import es.indra.sicc.dtos.ccc.DTOMantenimientoTiposAbonoSubproceso;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;


public class LPMantenimientoTiposAbonoSubproceso extends LPSICCBase {

   private String accion    	= null;
   private String oid         	= null;
   private String pais     		= null;     
   private String idioma        = null;	
   private String opcionMenu    = null;
   private String ultimaAcc     = null;   
   private String oidTipoAbonoSubproceso = null;
 
 
 
  public LPMantenimientoTiposAbonoSubproceso() {
		super();
	}

   public void inicio() throws Exception {  
     pagina("contenido_tipo_abonos_subproceso_mantenimiento");
	 this.getFormatosValidaciones();
   }
  
   public void ejecucion() throws Exception {
    
	 
       try{
	       rastreo();
		   //getConfiguracionMenu("LPMantenimientoTiposAbonoSubproceso","");				   
           
           idioma     = UtilidadesSession.getIdioma(this).toString();
           pais       = UtilidadesSession.getPais(this).toString();
           accion     = conectorParametroLimpia("accion", "", true);
           opcionMenu = conectorParametro("opcionMenu");
           ultimaAcc  = conectorParametro("ultimaAccion");
           
	       asignarAtributo("VAR","hPais","valor",pais);
		   asignarAtributo("VAR","hIdioma","valor",idioma);
			
           cargaConfiguracionPantalla();           
           
           traza("opcionMenu " + opcionMenu);
           
           
          
            
		   if (accion.equals("")){
                //Cargar pantalla 	
                //Invocar al metodo cargarPantalla pasandole como parametro
                //"opcionMenu". 
                traza("antes de cargarPantalla");
                cargarPantalla();
                
           }else{
           
                //Si accion == "Guardar" 
                //Guarda un nuevo registro o actualiza uno existente 
				 if (accion.equals("Guardar")){
                 
                 /*
                  * 
                  * 
                    Recuperar los datos que se van a guardar de la pantalla. 
                    - oidTiposAbonoSubproceso // del elemento seleccionado de 
                    la lista si se trata de una modificacion, en otro caso sera null. 
                    - oidProceso // del elemento seleccionado en el combo 
                    - oidSubroceso // del elemento seleccionado en el combo 
                    - oidTipoAbono // del elemento seleccionado en el combo 
                    - oidCuentaContable // del elemento seleccionado en el combo 
                    Invocar al metodo guardar con los valores recogidos.                  
                * 
                  * 
                  */
                  
                  traza("en Guardar");
                  String oidProceso = conectorParametro("cbProceso");                  
                  String oidSubroceso = conectorParametro("cbSubproceso");                 
                  String oidTipoAbono = conectorParametro("cbTipoAbono");
                  String oidCuentaContable  = conectorParametro("cbCuentaContable");
                   
                  traza("oidProceso: " + oidProceso);
                  traza("oidSubroceso: " + oidSubroceso);
                  traza("oidTipoAbono: " + oidTipoAbono);
                  traza("oidCuentaContable: " + oidCuentaContable);
                  
                  DTOMantenimientoTiposAbonoSubproceso dto = new DTOMantenimientoTiposAbonoSubproceso();
                  
                  if (!(oidProceso.equals("")))
                     dto.setOidProceso(Long.valueOf(oidProceso));
                 
                  if (!(oidSubroceso.equals("")))
                     dto.setOidSubproceso(Long.valueOf(oidSubroceso));
                  
                  if (!(oidTipoAbono.equals("")))
                     dto.setOidTipoAbono(Long.valueOf(oidTipoAbono));
                  
                  if (!(oidCuentaContable.equals("")))
                     dto.setOidCuentaContable(Long.valueOf(oidCuentaContable));
                
                  oidTipoAbonoSubproceso =conectorParametro("oidTipoAbonoSubproceso");
                  traza("oidTipoAbonoSubproceso: " + oidTipoAbonoSubproceso); 
                  
                  
                  if (!oidTipoAbonoSubproceso.equals("")){
                        traza("bsbsbsbsbs");
                      dto.setOidTiposAbonoSubproceso(new Long(oidTipoAbonoSubproceso));
                 } 
                        
                  
                  
                 
                  traza("se llama a guardar: ");
                  this.guardar(dto);
                  traza("sale de guardar");           
                  
                  } 
                  
                  //Si accion == "Eliminar" 
                  //Elimina un conjunto de registros 
                  if (accion.equals("Eliminar")){
                  
                  /*  String oidProceso = conectorParametro("cbProceso");                  
                    String oidSubroceso = conectorParametro("cbSubproceso");
                    String oidTipoAbono = conectorParametro("cbTipoAbono");
                    String oidCuentaContable  = conectorParametro("cbCuentaContable");*/
                    
                    
                    String oiDetalle  = conectorParametro("oidsDetalle");
                      
                    traza("oidsDetalle: " + oiDetalle);
                                        
                    DTOMantenimientoTiposAbonoSubproceso dto = new DTOMantenimientoTiposAbonoSubproceso();
                  
                  
                    StringTokenizer tokTemp = new StringTokenizer(oiDetalle, ",");
                    
                    
                    traza("tokTemp : " + tokTemp);
                    
                    
                    int cant = tokTemp.countTokens();
                    
                    traza("cant " + cant);
                    
                    Long[] oids = new Long[cant];
                    
                    int i = 0;
					while (tokTemp.hasMoreTokens()){
						   traza("antes de oid");
						   String conte = tokTemp.nextToken();
						   traza("despues ::::" + conte);							
						   oids[i] = new Long(conte);
						   i++;
                     }
                  
                    dto.setOidsRegistrosAEliminar(oids);
                    
                
                    this.eliminar(dto);
                  
                  }
                  //Si accion == "Detalle" 
                  //Muestra el detalle de un registro                   
                  if (accion.equals("Detalle")){
                  
                  
                    String oidProceso = conectorParametro("proce");                  
                    String oidSubroceso = conectorParametro("subProce");
                    String oidTipoAbono = conectorParametro("tAbono");
                    String oidCuentaContable  = conectorParametro("cContable");                    
                   
                    
                    asignarAtributo("VAR", "oidCC", "valor",oidCuentaContable ); 
                    asignarAtributo("VAR", "oidPr", "valor",oidProceso );
                    asignarAtributo("VAR", "oidSubPr", "valor", oidSubroceso);
                    asignarAtributo("VAR", "oidTipoAB", "valor", oidTipoAbono);
                    
                    ultimaAcc =conectorParametro("ultimaAccion");
                    
                   
                    traza("oidProceso: " + oidProceso);
                    traza("oidSubroceso: " + oidSubroceso);
                    traza("oidTipoAbono: " + oidTipoAbono);
                    traza("oidCuentaContable: " + oidCuentaContable);
                  
                    opcionMenu = conectorParametro("opcionMenu");
                    
                    traza("opcionMenu: " + opcionMenu);
                    
                    if(opcionMenu.equals("Modificar")){
                        ultimaAcc = opcionMenu;       
                        asignarAtributo("COMBO", "cbProceso", "req", "S");
                        asignarAtributo("COMBO", "cbSubproceso", "req", "S");
                        asignarAtributo("COMBO", "cbTipoAbono", "req", "S");
                        asignarAtributo("COMBO", "cbCuentaContable", "req", "S");    
                        oidTipoAbonoSubproceso =conectorParametro("oidTipoAbonoSubproceso");
                        traza("oidTipoAbonoSubproceso: " + oidTipoAbonoSubproceso);
                         
                        if (!oidTipoAbonoSubproceso.equals("")){
                            asignarAtributo("VAR", "oidTipoAbonoSubproceso", "valor", oidTipoAbonoSubproceso);
                        }
                        
                        
                        
                        
                    }
                    traza("ultimaAcc: " + ultimaAcc);
                   
                    asignarAtributo("VAR", "ultimaAccion", "valor", ultimaAcc);
                   
                    DTOMantenimientoTiposAbonoSubproceso dto = new DTOMantenimientoTiposAbonoSubproceso();
                  
                    
                  
                  
                    if (!(oidProceso.equals("")))
                        dto.setOidProceso(Long.valueOf(oidProceso));                
                 
                
                    if (!(oidSubroceso.equals("")))
                        dto.setOidSubproceso(Long.valueOf(oidSubroceso));
                  
                    if (!(oidTipoAbono.equals("")))
                        dto.setOidTipoAbono(Long.valueOf(oidTipoAbono));
                  
                    if (!(oidCuentaContable.equals("")))
                        dto.setOidCuentaContable(Long.valueOf(oidCuentaContable));
                       
                     if (oidTipoAbonoSubproceso!=null){
                        traza("aaaaaaa");
                        dto.setOidTiposAbonoSubproceso(new Long(oidTipoAbonoSubproceso));
                     
                     }   
                        
                    traza("se llama a detalle: ");
                    this.mostrarDetalle(dto);
                    traza("sale de detalle");  
                    
                    traza("ultimaAcc: " + ultimaAcc);
                    
                    if (ultimaAcc.equals("Buscar"))                  
                            asignarAtributo("VAR", "Des", "valor", "SI");
                  
                  }
                 
           }//--Fin else--
           
           if (!opcionMenu.equals("")){
                asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
           } 
           
     }catch(Exception e){
          traza("pincho la lp principal");
          ByteArrayOutputStream pila = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(pila);
          e.printStackTrace(out);
          traza("EL STACK ES COMO SIGUE : " +  pila.toString());
          e.printStackTrace(); 
          e.getMessage();
			 lanzarPaginaError(e);
	
  }
}      


    //Metodo que se ejecuta al inciar el caso de uso
    //Descripción: Carga las combos necesarias para la página. .
	public void cargarPantalla() throws Exception{  
    
        traza("** Entre a cargarPantalla");
		String listaPremiar = new String();    
	   
		DTOBelcorp dtoe = new DTOBelcorp();       
		  
		dtoe.setOidIdioma(new Long(idioma));
		dtoe.setOidPais(new Long(pais));
		
        
        traza("a : " + dtoe);
                    
        //--Se obtienen los procesos            
		ComposerViewElementList lista = new ComposerViewElementList();  
		ComposerViewElement cmb1 = new ComposerViewElement();
		cmb1.setIDBusiness("CCCObtieneProcesos");
		cmb1.setDTOE(dtoe);  
        
        traza("b");
        
        //Obtenemos los subprocesos. Solo se cargara si las variables recibida 
        //como parametro opcionMenu = "Consultar" y accion = "Detalle" 

     /*  if (accion.equals("Detalle")){
			  
            DTOOID dtoO = new DTOOID();
            String oidSubroceso = conectorParametro("subProce");
            traza("oidSubroceso: " + oidSubroceso);
            
            dtoO.setOid(new Long(oidSubroceso));
            ComposerViewElement cmb2 = new ComposerViewElement();
            cmb2.setIDBusiness("CCCobtieneSubprocesos"); 
          //  cmb2.setDTOE(dtoe);
           cmb2.setDTOE(dtoO);
            lista.addViewElement(cmb2);		
        
       }			 		*/
        //--Obtenemos los tipos abono
		ComposerViewElement cmb3 = new ComposerViewElement();
		cmb3.setIDBusiness("CCCObtenerTiposAbono");
		cmb3.setDTOE(dtoe); 
        
        traza("c");
        //--Obtenemos las cuentas Contables
		ComposerViewElement cmb4 = new ComposerViewElement();
		cmb4.setIDBusiness("CCCObtenerCuentasContables");
		cmb4.setDTOE(dtoe);         
        
        
        traza("d");
        //--Se cargan a la lista
        lista.addViewElement(cmb1);
        lista.addViewElement(cmb3);
        lista.addViewElement(cmb4);		
		
        traza("e");
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
        
        traza("f");
			
		DruidaConector resultados = conector.getConector();
				
		asignar("COMBO","cbProceso", resultados,"CCCObtieneProcesos");     
        
        /*if (accion.equals("Detalle")){
		   asignar("COMBO","cbSubproceso", resultados,"CCCobtieneSubprocesos"); 
        } */
    
        asignar("COMBO","cbTipoAbono", resultados,"CCCObtenerTiposAbono");                                             
		asignar("COMBO","cbCuentaContable", resultados,"CCCObtenerCuentasContables");
        
        
        traza("1");
        /*
         * Llamar a la pantalla PantallaMantenimientoTiposAbonoSubproceso, 
         * pasandole como parametros "opcionMenu" y "oidsDetalle". 
         *  este ultimo si estuviese
         */
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
        
    }
    
    
    
    private void guardar(DTOMantenimientoTiposAbonoSubproceso dto) throws Exception{
        traza("* guardar *");
        pagina("salidaGenerica");
        
               
        String casoDeUso = conectorParametroLimpia("opcionMenu", "", true);
        traza(" casoDeUso " + casoDeUso );
          
		//try{
            
            MareBusinessID id = new MareBusinessID("CCCGuardarTiposAbonoSubproceso");
          
          
			Vector paramEntrada = new Vector();
			paramEntrada.add(dto);
			paramEntrada.add(id);

            traza("antes de conectar guardar");
			DruidaConector con = conectar("ConectorMantenimientoTiposAbonoSubproceso", paramEntrada);
            traza("sale de conectar guardar");
            
            
            
            if(casoDeUso.equals("Modificar") ){
				asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
            } else {
				asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()");
            }
        
       /*   }catch(Exception e){
			   asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			   throw e;
		}				 */
    }
    
    
     private void eliminar(DTOMantenimientoTiposAbonoSubproceso dto) throws Exception{
        traza("* eliminar *");
        pagina("salidaGenerica");
        asignarAtributo("VAR", "ejecutarError", "valor", "cerrarEliminar(false)");  

            
          MareBusinessID id = new MareBusinessID("CCCEliminarTiposAbonoSubproceso");
          Vector paramEntrada = new Vector();
          paramEntrada.add(dto);
          paramEntrada.add(id);
          
          traza("antes de conectar Eliminar");
          DruidaConector con = conectar("ConectorMantenimientoTiposAbonoSubproceso", paramEntrada);
          DTOBoolean  dtoBool= (DTOBoolean) con.objeto("dtoSalida");
          traza("sale de conectar Eliminar");
          
          asignarAtributo("VAR", "ejecutar", "valor", "cerrarEliminar(false)");
           
          if (dtoBool.getValor() == false ){
          asignarAtributo("VAR", "ejecutar", "valor", "cerrarEliminar(true)");
          }

    }
    
    
    
    private void mostrarDetalle(DTOMantenimientoTiposAbonoSubproceso dto) throws Exception{
        traza("* mostrarDetalle *");
        
        String ultimaAccion = conectorParametroLimpia("ultimaAccion","",true); 
        
        this.cargarPantalla();      
        	traza("despues de cargar pantalla ");
        
        if(!(ultimaAccion.equals(""))){
			  traza("entro a asignar atributo a  ultima accion ");
            asignarAtributo("VAR", "ultimaAccion", "valor", ultimaAccion);
				traza("despues de asignar atributo a  ultima accion");
        }        
        
       
    }
    
    
    private void cargaConfiguracionPantalla() throws Exception{
       
        opcionMenu = conectorParametro("opcionMenu");
       
        if (opcionMenu.equals("Insertar")){        
            getConfiguracionMenu("LPMantenimientoTiposAbonoSubproceso", "Insertar");	
			asignarAtributoPagina("cod", "01026");	
            
            asignarAtributo("COMBO", "cbProceso", "req", "S");
            asignarAtributo("COMBO", "cbSubproceso", "req", "S");
            asignarAtributo("COMBO", "cbTipoAbono", "req", "S");
            asignarAtributo("COMBO", "cbCuentaContable", "req", "S");
        }
       
        if(opcionMenu.equals("Buscar")){
            getConfiguracionMenu("LPMantenimientoTiposAbonoSubproceso", "Buscar");	
			asignarAtributoPagina("cod", "01031"); 
           
        }  
        
        if(opcionMenu.equals("Eliminar")){
            getConfiguracionMenu("LPMantenimientoTiposAbonoSubproceso", "Eliminar");	
			asignarAtributoPagina("cod", "01027");        
        }
        
        if(opcionMenu.equals("Modificar")){
            getConfiguracionMenu("LPMantenimientoTiposAbonoSubproceso", "Modificar");
			asignarAtributoPagina("cod", "01028");   
            
            
        }    
       
       
    }
  
}
