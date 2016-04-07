import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaBaseComun;

public class LPBusquedaGenerica extends LPSICCBase{

    public LPBusquedaGenerica(){
    }

    public void inicio()throws Exception{
         pagina("GENBusquedaGenerica");
    }




    public void ejecucion()throws Exception{
		getConfiguracionMenu("LPBusquedaGenerica","");
		String titulo = conectorParametroLimpia("titulo","",true);
		if(titulo.equals("")){
			titulo = "-1";
		}
		asignarAtributoPagina("cod",titulo);
    }
}