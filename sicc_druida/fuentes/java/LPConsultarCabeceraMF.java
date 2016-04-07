/*
    INDRA/CAR/PROY
    $Id: LPConsultarCabeceraMF.java,v 1.1 2009/12/03 18:38:39 pecbazalar Exp $
    DESC
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
 * 1° L.P: by Patricio Peralta L.P., B.A., Argentina
*/


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.StringTokenizer;
import java.util.Vector;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPConsultarCabeceraMF extends LPSICCBase {

    String accion="";
    protected String nombreLogica="LPConsultarCabeceraMF";
    protected String nombrePagina ="contenido_cabecera_matriz_facturacion_consultar";
    protected String tag ="LABELC";
    protected boolean throwsException = true;
    protected boolean correctInvokation = false;

    String mIdioma    = null;

    /* Metodos de soporte */
    // auxiliar, suprimir por replaceAll cuando se use la version 1.4!
	
    public String replaceBlanc(String s){
        String result=s;
        StringTokenizer st = new  StringTokenizer(s);
        if (st.hasMoreTokens())
            result = st.nextToken();
        while (st.hasMoreTokens())
            result = result+"_" +st.nextToken();
        return result;	
    }   //replaceBlanc 

	
    protected void beforeActionExecute() throws Exception {
        this.accion = conectorParametroLimpia("accion","",true);
        traza(nombreLogica + "==>accion: " + this.accion);
    }
	
    protected void afterActionExecute() throws Exception {}   

    protected void invokeAction() throws Exception{
        try {
			
            Method actionMethod =  //obtengo el metodo a ejecutar
            this.getClass().getMethod(this.replaceBlanc(this.accion),null);
            traza("accion de: " + actionMethod); 
            actionMethod.invoke(this,null); //invocamos al metodo!	
        }catch ( NoSuchMethodException nme){ 
            this.traza(nombreLogica + "/ no se implemento el metodo "+ this.accion +" o no es publico");
            this.traza(nombreLogica + "/// "+nme);
            throw nme;
        }catch ( IllegalAccessException iae){ 
            this.traza(nombreLogica + "//////no se accedio  el metodo "+ this.accion );
            this.traza(nombreLogica + "////// "+iae);
            throw iae;
        } 
        catch ( IllegalArgumentException iaE){ 
            this.traza(nombreLogica + "/////// / argumentos erroneos pra el metodo "+ this.accion );			
            this.traza(nombreLogica + "///////// "+iaE);
            throw  iaE;
        }
        catch ( InvocationTargetException ite){
            traza("CLASE: "+ite.getTargetException().getClass());
            throw (InvocationTargetException)ite.getTargetException();
        } 		
    } //invokeAction
    // Definicion del metodo abstracto ejecucion
    
    public void ejecucion() throws Exception {
        try{	
            mIdioma    = UtilidadesSession.getIdioma(this).toString();
            this.beforeActionExecute();
            if (this.accion.equals("")) 
                this.accion = "defaultAction";
            this.correctInvokation = true;		
            this.invokeAction();
            this.afterActionExecute();
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
        }catch ( Exception e ){			
            if (e instanceof InvocationTargetException){
                traza("Codigo: "+(((MareException)((InvocationTargetException)e).getTargetException()).getCode()));
            }
            lanzarPaginaError(e);
            logStackTrace(e);
        }
    }//ejecucion
    /* Fin Metodos de soporte */

    /* Metodos especificos a ESTA Logica */
	
    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        this.setTrazaFichero();
        
    }
	
    public void defaultAction()throws Exception {
        this.conectorParametroSesion("UltimaLP",this.nombreLogica);
        this.conectorAction("LPSeleccionarMF");
        //this.conectorActionParametro("nueva","False");
    }//defaultAction


    //esta es la accion "Matriz seleccionada", neo
    public void Matriz_seleccionada() throws Exception {
        try{
            this.pagina(this.nombrePagina);     
            cargarMenuSecundario();
	    			this.getFormatosValidaciones();		
            Long oidMatrizSeleccionada = (Long) this.conectorParametroSesion("oidCabeceraMF");	
            MareBusinessID bsId = new MareBusinessID("PREConsultarCabeceraMF"); 

            DruidaConector con = null;			
            DTOOID dto = new DTOOID();
			
            dto.setOid(oidMatrizSeleccionada);
            dto.setOidIdioma(new Long(mIdioma));	
			
            Vector parametrosEntrada = new Vector();

            parametrosEntrada.add(dto); 
            parametrosEntrada.add(bsId);

            con = conectar("ConectorConsultarCabeceraMF", parametrosEntrada);
            MareDTO mareDTO = (MareDTO)con.objeto("DTOSalida");


            //	    	RecordSet rs = dtoSalida.getResultado();
            RecordSet rs = (RecordSet) mareDTO.getProperty("resultado");

            if(rs.getValueAt(0,"descripcionMarca")!=null) 
            asignarAtributo("LABELC","Marca","valor", 
            (String)rs.getValueAt(0,"descripcionMarca"));

            if(rs.getValueAt(0,"descripcionCanal")!=null) 
            asignarAtributo("LABELC","Canal","valor",
            (String)rs.getValueAt(0,"descripcionCanal"));
			

            if(rs.getValueAt(0,"descripcionPeriodo")!=null) 
            asignarAtributo("LABELC","Periodo","valor",
            (String)rs.getValueAt(0,"descripcionPeriodo"));				
			
            if(rs.getValueAt(0,"numeroPedidosEstimados")!=null) {
              String numPedidos = (String)rs.getValueAt(0,"numeroPedidosEstimados");             
              numPedidos = UtilidadesBelcorp.formateaNumeroSICC(numPedidos, 
                                                this.FORMATO_DEFAULT, 
                                                this);
              asignarAtributo(tag,"NumeroPedidosEstimados","valor", numPedidos);
              //(String)rs.getValueAt(0,"numeroPedidosEstimados"));	
            }
            
			
            if(rs.getValueAt(0,"unidadesEstimadas")!=null) {
              String unidades = (String)rs.getValueAt(0,"unidadesEstimadas");             
              unidades = UtilidadesBelcorp.formateaNumeroSICC(unidades, 
                                                this.FORMATO_DEFAULT, 
                                                this);
              asignarAtributo(tag,"UnidadesEstimadas","valor", unidades);
              //(String)rs.getValueAt(0,"unidadesEstimadas"));                                                
            }
            
			
            if(rs.getValueAt(0,"clientesEstimados")!=null) {
              String clientes = (String)rs.getValueAt(0,"clientesEstimados");             
              clientes = UtilidadesBelcorp.formateaNumeroSICC(clientes, 
                                                this.FORMATO_DEFAULT, 
                                                this);
              asignarAtributo(tag,"ClientesEstimados","valor",clientes);
              //(String)rs.getValueAt(0,"clientesEstimados"));
            }
            
			
            if(rs.getValueAt(0,"totalMontoVentaNeta")!=null) {
              String total = (String)rs.getValueAt(0,"totalMontoVentaNeta");             
              total = UtilidadesBelcorp.formateaNumeroSICC(total, 
                                                this.FORMATO_DEFAULT, 
                                                this);
              asignarAtributo(tag,"ValorEstimado","valor", total);
              //(String)rs.getValueAt(0,"totalMontoVentaNeta"));
            }
            
			
            if(rs.getValueAt(0,"tipoCambioPromedioPeriodo")!=null) {
              String tipoCambio = (String)rs.getValueAt(0,"tipoCambioPromedioPeriodo");             
              tipoCambio = UtilidadesBelcorp.formateaNumeroSICC(tipoCambio, 
                                                this.FORMATO_ALTERNATIVA, 
                                                this);
              asignarAtributo(tag,"TipoCambio","valor", tipoCambio);
              //(String)rs.getValueAt(0,"tipoCambioPromedioPeriodo"));
            }
        }
        catch ( Exception e )  {
            ByteArrayOutputStream pil = new ByteArrayOutputStream();
            PrintStream outs = new PrintStream(pil);
            e.printStackTrace(outs);
            traza("EL STACK ES COMO SIGUE-------- : " +  pil.toString());
            e.printStackTrace(); 
            e.getMessage();
            lanzarPaginaError(e);
        }
    }   

    //Agrgado para la configuracion de la barra
    private void cargarMenuSecundario() throws Exception {
        traza("contenido de nombreLogica" + nombreLogica);
        if (this.nombreLogica.equals("LPModificarCabeceraMF")) {
            getConfiguracionMenu("LPModificarCabeceraMF","Guardar");
            asignarAtributoPagina("cod","0142");
            asignarAtributo("VAR","nombreLogicas","valor", "LPModificarCabeceraMF");	
        }
        if (this.nombreLogica.equals("LPConsultarCabeceraMF")) {
            getConfiguracionMenu("LPConsultarCabeceraMF","Matriz seleccionada");
            asignarAtributoPagina("cod","0141");
            asignarAtributo("VAR","nombreLogicas","valor", "LPConsultarCabeceraMF");
        }   
    }//cargarMenuSecundario

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
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
