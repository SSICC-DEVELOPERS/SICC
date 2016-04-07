import es.indra.druida.Contexto;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;

//import LPSICCBase;

public abstract class LPGenericaSubirFichero extends LPSICCBase {

  public LPGenericaSubirFichero() {
    super();
  }

  public void inicio() throws Exception {

     String accion = conectorParametroLimpia("accion", "", true);

     if(accion.equals("")){
        pagina("contenido_seleccion_fichero");
     }else{
        pagina("contenido_resultado_fichero");
     }

  }    

  public void ejecucion() throws Exception {

     String accion = conectorParametroLimpia("accion", "", true);

     if(accion.equals("")){
        seleccionar();
     }else{
        procesar();
     }
    
  }

  public String getDirTempDruida() throws Exception{
     return Contexto.getPropiedad("TMP.UPLOAD"); 
  }

  public String getWebTmpDir() throws Exception{
     return Contexto.getPropiedad("TMP.UPLOAD2"); 
  }

  public void llenaPantallaResultados(DTOFicheroResultado dto) throws Exception{

  }

  public abstract void seleccionar()throws Exception;
  public abstract void procesar() throws Exception;

  
}

