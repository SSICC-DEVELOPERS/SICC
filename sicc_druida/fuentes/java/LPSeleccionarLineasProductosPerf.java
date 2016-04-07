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

//import LPSICCBase;

import es.indra.sicc.dtos.pre.DTOLineaProducto;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.StringTokenizer;

public class LPSeleccionarLineasProductosPerf extends LPSICCBase{
    private String sAccion = null;
    private Long lIdioma = null;
    private Long lPais = null;
    private Vector vLineasProducto = null;

    public LPSeleccionarLineasProductosPerf(){
            super();
    }

    public void inicio()throws Exception{
        pagina("contenido_lineas_producto_seleccionar_perf");
    }

    public void ejecucion() throws Exception{
        int iIndexDel = 0;  
        Long lLinea = null;
        String sCodigo = new String();
        String sDesc = new String();
        String sIDLinea = new String();
                
        setTrazaFichero();
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("Inicializando contenido_lineas_producto_seleccionar_perf");
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        try{
            sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
            lPais = UtilidadesSession.getPais(this);
            lIdioma = UtilidadesSession.getIdioma(this);

            traza("+++++ Accion Seleccionada:  +++++" +sAccion);
            //this.rastreo();
            if (sAccion.equals(""))
            {
                this.getConfiguracionMenu("LPSeleccionarLineasProductosPerf","");
            }
            else  if (sAccion.equals("Lineas seleccionadas"))
            {
                vLineasProducto = new Vector();
                /*............... Recupera el Vector de sesión ................*/
                vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");
            
                /*... Crea un DTOLineaProducto por cada linea seleccionada ...*/
                String sLineasProducto = null; 
                sLineasProducto = (String)conectorParametro("hidLineasSeleccionadas");
                traza(" CONTENIDO SELECCIONADO : " + sLineasProducto);
                String[] LineasSel = construirLineaSeleccionada (sLineasProducto);


                /*Se parsea el string que contiene las líneas de producto 
                 * seleccionados.
                 * Ejemplo de string:  1,1,desc1;2,2,desc2*/
                for (int i=0;LineasSel.length > i ;i++ ){
                    iIndexDel =  LineasSel[i].indexOf(",");

                    sIDLinea = LineasSel[i].substring(0,iIndexDel);      
                    sCodigo =  LineasSel[i].substring(iIndexDel+1,
                                        LineasSel[i].indexOf(";"));

                    iIndexDel =  LineasSel[i].indexOf(";");
                    
                    sDesc = LineasSel[i].substring(iIndexDel+1,LineasSel[i].length());
                    
                    DTOLineaProducto dtoLineaP = new DTOLineaProducto();
                    dtoLineaP.setOidLinea(lLinea);

                    dtoLineaP.setOidLinea(Long.valueOf(sIDLinea));
                    dtoLineaP.setCodigo(sCodigo);
                    dtoLineaP.setDescripcion(sDesc);
                    dtoLineaP.setOidIdioma(lIdioma);
                    dtoLineaP.setOidPais(lPais);
                    
                    /*................ Añade los DTO al Vector ...............*/
                    //if(!vLineasProducto.contains(dtoLineaP))
                    if (!inVectorProductos(vLineasProducto, dtoLineaP))
                        vLineasProducto.add(dtoLineaP);
                    else
                        traza("La línea seleccionada ya se encontraba ingresada");
                }
                /*............... Guarda el Vector en sesión .................*/
                conectorParametroSesion("lineasProducto",vLineasProducto);

                /*............. Recoge de sesión la LP anterior ..............*/
                String sPreviaLP = (String)conectorParametroSesion("volverLPSeleccionarLineasProductos");
                traza("++++++++++++ sPreviaLP: "+sPreviaLP + "+++++++++++++++");
                /*............. Activar de sesión la LP anterior ..............*/
                if (!sPreviaLP.equals("") && sPreviaLP!=null )
                {
                    conectorAction( sPreviaLP  );
                    /*................ Setea Accion a ejecutar ...................*/
                    conectorActionParametro("accion","Lineas seleccionadas");
                }
            }
            
        }catch(Exception e){
                ByteArrayOutputStream pila = new ByteArrayOutputStream();
                PrintStream out = new PrintStream(pila);
                e.printStackTrace(out);
                traza("El stack es como sigue : " + pila.toString());
                //lanzarPaginaError(e);
        }
    }

    public String[] construirLineaSeleccionada (String elementosSeleccionados) 
        throws Exception{
        
        StringTokenizer stk = new StringTokenizer(elementosSeleccionados,"|");
		String[] arr = new String[stk.countTokens()];
		int cuenta = 0;
        while (stk.hasMoreTokens()) {
			arr[cuenta] = stk.nextToken();
			cuenta++;
        }

        return arr;
     }

     
    private boolean inVectorProductos(Vector vector, DTOLineaProducto dto){

        boolean result = false;
        String dtoEntrada = dtoSinOid(dto);
        for (int i=0;i< vector.size();i++)  {
            String dtoProdString = dtoSinOid((DTOLineaProducto)vector.get(i));
            if (dtoProdString.equals(dtoEntrada)){
                result = true;
                break;
            }
        }
        return result;        
    }

    private String dtoSinOid(DTOLineaProducto dto){
        String aString = dto.toString();
        aString = aString.substring(5) ;        
        aString = aString.substring(aString.indexOf('\n')+1);    
        return aString;
    }     
}
