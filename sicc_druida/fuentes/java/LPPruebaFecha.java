
import java.util.HashMap;
import java.util.Set;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LPPruebaFecha extends LPSICCBase {

	public LPPruebaFecha() {super();}

	private String accion		= null;
         
	public void inicio() throws Exception {
         	// Asignar nombre de la vista
         	pagina("plantilla_cursos_copiar");
    	}

    	public void ejecucion() throws Exception {

           this.accion = conectorParametroLimpia("accion", "", true);

           try {
           	if (accion.equals("")) {
           		this.generarHiddenFormatoFecha();
           	} else if (accion.equals("aceptar")) {
			 
           		HashMap hm = conectorParametro();
         		Object lista[] = (hm.keySet()).toArray();
         		String param ="";
         		for (int i=0; i< lista.length; i++)
         			param += "-"+lista[i];
         		lista = (hm.values()).toArray();
         		for (int i=0; i< lista.length; i++)
         			param += "-"+lista[i];
          		asignar("CTEXTO","txtNombrePlantilla",param);
		}
           } catch (Exception ex) {

               this.lanzarPaginaError(ex);   
           }
    	} 
}