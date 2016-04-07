import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.DruidaConector;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

public class LPRecepcionarVias extends LPSICCBase{
      String accion = "";
      
      public LPRecepcionarVias(){ 
            super();
      }
      
       public void inicio() throws Exception{
         pagina("contenido_via_recepcionar");
        // getConfiguracionMenu("LPRecepcionarVias","");
      }
      
      public void ejecucion() throws Exception{
        try{
             setTrazaFichero();
             this.rastreo();
             accion = conectorParametroLimpia("accion","",true);
             traza("Entro al método Ejercicio de LPRecepcionarVias");
             if(accion.equals("recepcionar")){
                traza("accion recepcionar");
                DTOINT dtoi = new DTOINT();
                

                dtoi.setDescripcionLote(conectorParametroLimpia("Descripcion","",true));
                dtoi.setObservaciones(conectorParametroLimpia("areatxtObservaciones","",true));

                dtoi.setOidIdioma(UtilidadesSession.getIdioma(this));
                dtoi.setOidPais(UtilidadesSession.getPais(this));
                dtoi.setNumeroLote(new Long(conectorParametro("hiddenNumLote")));
                traza(" dtoi.descripcionLote: " + dtoi.getDescripcionLote());
                traza(" dtoi.observaciones: " + dtoi.getObservaciones());
                Vector vec = new Vector();
                MareBusinessID midi = new MareBusinessID("INTRecepcionarVia");
                vec.add(dtoi);
                vec.add(midi);
                traza("antes del conector");
                DruidaConector dcc = conectar("ConectorGuardar", vec);            
                asignarAtributo("VAR", "accion", "valor", "");
                this.conectorAction("LPInicioBelcorp");
                this.conectorActionParametro("accion", "");
             }
             if(accion.equals(""))
             {
                traza("Si la acción es vacía");
				cargaDatos();
             }
             getConfiguracionMenu("LPRecepcionarVias","");        
         }catch (Exception ex){
            traza("Lanzo una Exception " + ex.getClass().getName() );
            traza("detalle: " + ex.getMessage());
            logStackTrace(ex);
			if (ex instanceof InvocationTargetException) {

                if (((InvocationTargetException) ex).getTargetException() instanceof MareException) {

                    MareException mareException = (MareException) ((InvocationTargetException) ex).getTargetException();
					traza("codigo error: " + mareException.getCode());
					traza("mensaje error: " + mareException.getMessage());
					if(mareException.getCode() > 0) {
						this.lanzarPaginaError(ex);
					} else {
						asignarAtributo("VAR","errDescripcion","valor", mareException.getMessage());
					}
                } else {
					this.lanzarPaginaError(ex);
				}

			} else {
				this.lanzarPaginaError(ex);
			}
			try{
				cargaDatos();
			} catch (Exception exp){
				this.lanzarPaginaError(exp);
			}  
		 }
    }


    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            //traza ("Error en logStackTrace: " + ex.getMessage ());
            e.printStackTrace ();
         }
    }

    private void cargaDatos() throws Exception{
				 DTOString dtos = new DTOString();
                //Asigno la constante
                dtos.setOidIdioma(UtilidadesSession.getIdioma(this));
                dtos.setOidPais(UtilidadesSession.getPais(this));
                dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_GIS3);
                     
                traza("antes de setea businessid");
                MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
                Vector vec = new Vector();
                vec.add(dtos);
                vec.add(mid);
                traza("antes de llamar al conector");
                DruidaConector dc = conectar("ConectorObjeto", vec);
                DTOCargaInicialInterfaz dtocii = (DTOCargaInicialInterfaz)dc.objeto("DTOSalida");
                traza("antes de asignar a la pantalla " + dtocii);
                asignarAtributo("LABELC", "lblvalorLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
                asignarAtributo("CTEXTO", "Descripcion", "valor", dtocii.getDescripcion());
                asignarAtributo("VAR", "hiddenNumLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));

	}
}
