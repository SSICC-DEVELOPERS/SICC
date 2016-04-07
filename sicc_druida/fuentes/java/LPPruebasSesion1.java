import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.presentacion.cache.Cache;

import java.util.Enumeration;

public class LPPruebasSesion1 extends LPSICCBase{
    private String accion;
    private Long aPais;
    private Long aIdioma;
    private Cache sesion;

    public LPPruebasSesion1(){
        super();
    }

    public void inicio() throws Exception {
        traza("Entro a inicio Inicio");
        this.pagina("contenido_sesion1");
    }
         
    public void ejecucion() throws Exception{
        setTrazaFichero();
        accion = conectorParametroLimpia("accion","",true);
        aPais = UtilidadesSession.getPais(this);
        aIdioma = UtilidadesSession.getIdioma(this);
        String mensaje =  conectorParametroSesion("MENSAJE1") == null ? "":(String)conectorParametroSesion("MENSAJE1");
        asignarAtributo("VAR","mensaje","valor",mensaje);
        try{
            this.rastreo();
            traza("Entrando a Ejecucion");
            traza("LA ACCION jaja ES:"  + accion);
            sesion = this.getSessionCache();
            traza("Estos son loa parametros 1: " + (String) sesion.get("PARAMETRO1"));
            traza("Estos son loa parametros 2: " + (String) sesion.get("PARAMETRO2"));
            String strParametros = "";
            if (accion.equals(""))  {
                Enumeration enum = this.conectorParametros();
                long i = 0;
                while (enum.hasMoreElements()){
                    i++;
                    String parametro = (String) enum.nextElement();
                    sesion.put("PARAMETRO" + i,parametro);
                    traza("PARAMETRO" + i + ": " + (String) sesion.get("PARAMETRO" + i));
                    sesion.put("CONTADOR",new Long(i));
                }
                
            }else if (accion.equals("MostrarParametros")) {
                conectorParametroSesion("MENSAJE1",new String("Esto quedara en sesion??"));
                Long contador = (Long) sesion.get("CONTADOR");

                for (int j=1 ;j <=contador.intValue() ; j++ )  {
                    strParametros += ((String) sesion.get("PARAMETRO" + j)) + "|";
                }
                asignarAtributo("VAR","accion","valor", "MostrarParametros" );
                asignarAtributo("VAR","parametros","valor", strParametros);
                asignarAtributo("VAR","mensaje","valor",(String) conectorParametroSesion("MENSAJE1"));
            }else{
                conectorAction("LPPruebasSesion2");
            }
            
        } catch(Exception e){
               lanzarPaginaError(e);
        }
    }
}

