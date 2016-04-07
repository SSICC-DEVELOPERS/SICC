
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.msg.DTODatosConsultora;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;


public class LPCargaFicheroConsultoras extends LPSICCBase {     
     public LPCargaFicheroConsultoras() {
    }

    public void inicio() throws Exception {
       setTrazaFichero();
	   traza("En metodo inicio...");
       
       String accion = conectorParametro("accion");
       if (accion ==null || accion.equals("")) {
          traza("entro en accion vacia");
          pagina("contenido_seleccion_fichero_LC");             
       }else{
          pagina("salidaGenerica");
          asignarAtributo("VAR","ejecutar","valor","retornaConExito();");
          //asignarAtributo("VAR","ejecutarError","valor","retornaConError();");
       }
    }

    public void ejecucion() throws Exception{
		traza("Entró en ejecucion......");
         
       String accion = conectorParametroLimpia("accion", "", true);            
                   
       try{
            
         if(accion.equals("") ){
              traza("************SELECCIONAR");
              conectorParametroSesion("oidMensaje",conectorParametroLimpia("oidMensaje", "", true));
              seleccionar();
         }else if(accion.equals("procesar") ) {
              traza("***************PROCESAR");
              procesar();                 
         } 
       }catch (Exception ex){    
          logStackTrace(ex);
          traza("lanzo la excepcion " + ex);
          this.lanzarPaginaError(ex);
       } 
       getConfiguracionMenu( "LPCargaFicheroConsultoras");
           
    }

    private void seleccionar() throws Exception{
         asignarAtributo("VAR","conectorAction", "valor" ,"LPCargaFicheroConsultoras");
         asignarAtributo("VAR","accion", "valor" , "procesar");
         asignarAtributoPagina("cod", "0643");
    }

    
    private void procesar() throws Exception {
         String s1 = getDirTempDruida();   
         traza("paso 1");
         String s2 = conectorParametro("seleccion");
         traza("paso 2");
         String s3 = getWebTmpDir();
         traza("paso 3");
       

         DTOFicheroDisp dtoin = new DTOFicheroDisp();
         traza("paso 4");

         dtoin.setNombreFichero(s2);
         traza("paso 5");

         if((s2.equals("")) || (s2 == null)){
            conectorAviso("MSG-0012");
            pagina("contenido_seleccion_fichero");             
         }

         traza("paso 6");
         dtoin.setPathFichero(s3);
         dtoin.setOidPais(UtilidadesSession.getPais(this));
         traza("paso 7");
         DTODatosConsultora datos = new DTODatosConsultora();
         traza("paso 8");
         

         String oidMensajeSesion = null;
         oidMensajeSesion = (String)conectorParametroSesion("oidMensaje");
         traza("el oid mensaje es " + oidMensajeSesion);
         datos.setOidMensaje(new Long(oidMensajeSesion));
         datos.setOidPais(UtilidadesSession.getPais(this));
         
         dtoin.setDatos(datos);
         traza("paso 9");

         dtoin.setDatos(datos);
         traza("paso 10");

         MareBusinessID id = new MareBusinessID("MSGProcesarFicheroConsultoras");
         traza("paso 11");

         Vector param = new Vector();
         traza("paso 12");
         param.add(dtoin);
         traza("paso 13");
         param.add(id);
         traza("paso 14");
        
         DruidaConector con = conectar("ConectorProcesarFichero", param);
         traza("paso 15");
       
         //throw new MareException( new Exception(), UtilidadesError.armarCodigoError("60016"));
          
    }
     
    private String getDirTempDruida() throws Exception{                            
         return Contexto.getPropiedad("TMP.UPLOAD");                
    }
 
    private String getWebTmpDir() throws Exception{
         return Contexto.getPropiedad("TMP.UPLOAD2");
    } 

    public void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());
         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
         if (e instanceof MareException){
             MareException e2=(MareException)e;
             traza("Es una mare Exception con codigo de error: "+e2.getCode());
         }
         e.printStackTrace(out);
         traza("stack Trace : " +  pila.toString());
    }
}

