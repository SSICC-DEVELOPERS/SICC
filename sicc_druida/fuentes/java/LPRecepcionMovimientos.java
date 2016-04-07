import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTORecepcionarMovimientos;

import java.lang.reflect.InvocationTargetException;

import java.util.Vector;
import java.util.Date;
import java.text.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
 

public class LPRecepcionMovimientos extends LPSICCBase 
{
      String accion = "";
      private String pais = null;
	  String numLote = null;
	  String obser = null;
	  java.util.Date fecha = null;
	  String fechaString = null;
	  String descrip = null;

      
      public LPRecepcionMovimientos()
      { 
            super();
      }
      
       public void inicio() throws Exception
      {
         pagina("contenido_movimientos_bancarios_recepcionar");
         setTrazaFichero();
      }
      
      public void ejecucion() throws Exception
      {
        try{
            
             this.getFormatosValidaciones();
             
             this.rastreo();
             accion = conectorParametroLimpia("accion","",true);
             traza("emtre a la LPRecepconMovimientos");
             if(accion.equals("recepcionar"))
             {
                traza("accion recepcionar");
                
                DTORecepcionarMovimientos dtor = new DTORecepcionarMovimientos();

				fecha = conectorParametro("Fecha")==""?null:toDate(conectorParametro("Fecha"));
				fechaString = conectorParametroLimpia("Fecha", "", true);
                numLote = conectorParametroLimpia("numeroL", "", true);
				descrip = conectorParametroLimpia("Descripcion","",true);
				obser = conectorParametroLimpia("areatxtObservaciones","",true);


                dtor.setDescripcionLote(descrip);
                dtor.setObservaciones(obser);
                
                traza( descrip );
                traza("numero de lote>>>> " + numLote);                
                traza("antes de asignar la fecha " + fecha);
                
                
                dtor.setFechaGenerar(fecha);
                dtor.setOidIdioma(UtilidadesSession.getIdioma(this));
                dtor.setOidPais(UtilidadesSession.getPais(this));
                
                
                traza("numeroLote es: " + numLote);
                
                
                dtor.setNumeroLote(new Long(numLote));
                Vector vec = new Vector();
                MareBusinessID midi = new MareBusinessID("INTRecepcionarMovimientos");
                vec.add(dtor);
                vec.add(midi);
                
                traza("contenido del dto>>>>>> " + dtor);
                
                
                traza("antes del conector");
                DruidaConector dcc = conectar("ConectorGuardar", vec);
                traza("despues del conector");
                
                
                
                asignarAtributo("VAR", "accion", "valor", "");
                this.conectorAction("LPInicioBelcorp");
                this.conectorActionParametro("accion", "");
             }
             if(accion.equals(""))
             {
				cargaDatos();
             
             }
             getConfiguracionMenu("LPRecepcionMovimientos","");
         }catch (Exception ex){
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
		 		cargaDatosError();
		 	} catch (Exception exp){
		 		this.lanzarPaginaError(exp);
			}
		 }

      }


    /*******************FECHA****************************/
	private Date toDate(String sFecha) throws Exception{
      String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
      char frmFecha[] = formatoUsuario.toCharArray();
      for (int i=0; i < frmFecha.length; i++ ) {
         if ( frmFecha[i] == 'm' )
            frmFecha[i] = 'M';
         else if ( frmFecha[i] == 'a' || frmFecha[i] == 'A')
            frmFecha[i] = 'y';
      }

      String formatoFecha = new String(frmFecha);

      traza("formatoUsuario: '" + formatoFecha + "'");
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
		java.util.Date fecha = miFecha.parse(sFecha);
      traza("La fecha recuperada es : " + fecha );
      return fecha;
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
    
	public void cargaDatos() throws Exception {
             
		 traza("Si la acción es vacía");
         DTOString dtos = new DTOString();
         //Asigno la constante
         dtos.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtos.setOidPais(UtilidadesSession.getPais(this));
         dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_BAN1);
            
         MareBusinessID mid = new MareBusinessID("INTCargaInicialInterfaz");
         Vector vec = new Vector();
         vec.add(dtos);
         vec.add(mid);
         DruidaConector dc = conectar("ConectorObjeto", vec);
         DTOCargaInicialInterfaz dtocii = ((DTOCargaInicialInterfaz) dc.objeto("DTOSalida"));
         traza(" numeroLote: " + dtocii.getNumeroLote());
         traza(" descripcion: "  + dtocii.getDescripcion());
         asignarAtributo("LABELC", "lblvalorLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
         asignarAtributo("CTEXTO", "Descripcion", "valor", dtocii.getDescripcion());
         asignarAtributo("VAR", "numeroLote", "valor", (dtocii.getNumeroLote()==null? "": dtocii.getNumeroLote().toString()));
         
         // Fecha del dia por defecto. Inc 20227
         String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
	  asignar("CTEXTO", "Fecha", fecha);
             
    }

	public void cargaDatosError() throws Exception {
             
		 traza("Si entro por error recarga la pantalla");

         traza(" numeroLote: " + numLote);
         traza(" descripcion: "  + descrip);
         traza(" fecha: "  + fecha);
         traza(" fechaString: "  + fechaString);		 
         traza(" observaciones: "  + obser);

         asignarAtributo("LABELC", "lblvalorLote", "valor", numLote);
         asignarAtributo("CTEXTO", "Descripcion", "valor", descrip);
         asignarAtributo("VAR", "numeroLote", "valor", numLote);
		 asignarAtributo("CTEXTO","areatxtObservaciones","valor",obser);
         
	     asignar("CTEXTO", "Fecha", fechaString);
             
    }

}
