/*
    INDRA/CAR/PROY
    $Id: LPInicioBelcorp.java,v 1.1 2009/12/03 18:43:06 pecbazalar Exp $
    DESC
*/

import es.indra.druida.DruidaBase;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.mgu.UserIDSICC;

import es.indra.sicc.druida.formatos.*;

import java.util.HashMap;

public class LPInicioBelcorp extends LPSICCBase {

    public LPInicioBelcorp() {super();}

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
    	setTrazaFichero();

		/* Obtengo la LP de inicio del usuario, perfil o sistema */
		HashMap propsUser = (HashMap) conectorParametroSesion(IVariablesSesion.PROPERTIES_USUARIO);
		String logicaDeInicio = null;

		MareCredentials mc = UtilidadesSession.getMareCredentials(this);
		String usuario = mc.getUser().toString();

        int aux = usuario.indexOf(" as ");
        String userSust = usuario;

        if(aux != -1)
            userSust = usuario.substring(aux + 4, usuario.length());

		if ((userSust!=null) && (!(userSust.equals("")))) {
			usuario = userSust;
		}

/*		conectorParametroSesion("DruidaUsuario", usuario);
		conectorParametroSesion("DruidaPassword", mc.getPassword().toString());		*/

      if(propsUser != null){

			/*
				Agregado de Gacevedo:
							Seteo las propiedades que necesita Druida para el formateo de los valores
							que el usuario vera en pantalla.
			*/
					es.indra.druida.DruidaDataBase druidadatabase = new es.indra.druida.DruidaDataBase();
					druidadatabase.setRequest(getRequest());
					
					//Configuracion para números reales
					
					//formateo de fechas
					druidadatabase.usuarioFormatoFecha(UtilidadesSession.getFormatoFecha(this));


					//primer tipo de numero decimal
					druidadatabase.usuarioNumeroDecimales(2);
					String separadorDecimal = UtilidadesSession.getSeparadorDecimales(this);
					druidadatabase.usuarioCaracterDecimal(separadorDecimal);
					if(separadorDecimal.equals(".")){
						druidadatabase.sesionString(FormateadorNumerico.CLAVE_SEPARADOR_MILES, ",");
						druidadatabase.sesion(Moneda.MONEDA_SEPARADOR_MILES, ",");
						druidadatabase.sesion(MonedaAlternativa.MONEDA_SEPARADOR_MILES, ",");
					}else{
						druidadatabase.sesionString(FormateadorNumerico.CLAVE_SEPARADOR_MILES, ".");
						druidadatabase.sesion(Moneda.MONEDA_SEPARADOR_MILES, ".");
						druidadatabase.sesion(MonedaAlternativa.MONEDA_SEPARADOR_MILES, ".");
					}
					//Configuracion de moneda
					druidadatabase.sesion(Moneda.MONEDA_NUM_DECI, UtilidadesSession.getFormatoNumerico(this));
					druidadatabase.sesion(Moneda.MONEDA_SEPARADOR_DECI, separadorDecimal);

					//Configuracion de moneda alternativa
					druidadatabase.sesion(MonedaAlternativa.MONEDA_NUM_DECI, UtilidadesSession.getFormatoNumericoAlternativo(this));
					druidadatabase.sesion(MonedaAlternativa.MONEDA_SEPARADOR_DECI, separadorDecimal);
					
					//Configuracion BOOLEAN
					druidadatabase.sesion(BooleanValue.VERDADERO_KEY, "SI");
					druidadatabase.sesion(BooleanValue.FALSO_KEY, "NO");

			/* Fin del Agregado de Gacevedo*/

         final Property propUser = (Property)propsUser.get("PantallaInicioAsociada");
         if(propUser != null){
            logicaDeInicio = (String)propUser.getValue();
         }
         if(logicaDeInicio == null || logicaDeInicio.equals("")){
            final Property prop = (Property)propsUser.get("NombrePantallaInicioEjecutablePerfil");
            //final Property prop = (Property)propsUser.get("PantallaInicioDeAplicacionAsociada");
            if(prop != null){
               logicaDeInicio = (String)prop.getValue();
            }
         }
      }
      if(logicaDeInicio == null || logicaDeInicio.equals("")){
         MareMGC mgc = null;
         try{
            mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
            logicaDeInicio = (String)mgc.getProperty("application/sicc.logicapantallaprincipal");
            if(logicaDeInicio == null || logicaDeInicio.equals("")){
               logicaDeInicio = "";
            }
         } catch(MareMiiServiceNotFoundException mgce){
         	pagina("InicioBelcorp");
            asignarAtributo("VAR", "errCodigo", "valor", "" + mgce.getCode());
            asignarAtributo("VAR", "errDescripcion", "valor", mgce.toString());
         } finally{
            if(mgc != null){
               //mgc.shutdown();
            }
         }
      }

//traza("logicaDeInicio: " + logicaDeInicio);

		if ( logicaDeInicio.equals("LPInicioBelcorp") ){

			pagina("InicioBelcorp");
			String recarga = conectorParametroLimpia("recargaMenu", "", true);
			//traza("recarga: " + recarga);
			asignarAtributo("VAR","hidRecargaMenu", "valor",recarga);				
			getConfiguracionMenu("LPInicioBelcorp","");
		} else {
						
			conectorAction(logicaDeInicio);
			
		}
    }

}

