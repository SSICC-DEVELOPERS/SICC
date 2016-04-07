import es.indra.mare.common.mgu.manager.MarePrincipal;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPassword;
import es.indra.sicc.util.UtilidadesSession;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Vector;

public class LPCambiarClave extends LPSICCBase
{

    String accion;
    String txtClaveNueva;
    String txtConfirmarClaveNueva;
    String gLPVolver;
    String volverAlLogin;

    private void $init$()
    {
        accion = null;
        txtClaveNueva = null;
        txtConfirmarClaveNueva = null;
        gLPVolver = null;
        volverAlLogin = null;
    }

    public LPCambiarClave()
    {
        $init$();
    }

    public void inicio()
        throws Exception
    {
        pagina("contenido_clave_acceso_cambiar");
    }

    public void ejecucion()
        throws Exception
    {
        setTrazaFichero();
        getConfiguracionMenu("LPCambiarClave");
        accion = conectorParametroLimpia("accion", "", true);
        txtClaveNueva = conectorParametroLimpia("txtClaveNueva", "", true);
        txtConfirmarClaveNueva = conectorParametroLimpia("txtConfirmarClaveNueva", "", true);
        String modal = conectorParametroLimpia("modal", "", true);
        asignarAtributo("VAR", "modal", "valor", modal);
        volverAlLogin = conectorParametroLimpia("volverAlLogin", "", true);
        gLPVolver = (String)conectorParametroSesion("gLPVolver");
        MareCredentials credenciales = (MareCredentials)conectorParametroSesion("MARE_CREDENTIALS");
        if(volverAlLogin.equals(""))
        {
            volverAlLogin = "false";
        }
        asignarAtributo("VAR", "volverAlLogin", "valor", volverAlLogin);
        if(gLPVolver != null)
        {
            if(gLPVolver.equals("LPCambiarClave"))
            {
                asignarAtributo("VAR", "desactivarBotonBack", "valor", "true");
            } else
            {
                asignarAtributo("VAR", "desactivarBotonBack", "valor", "false");
                asignarAtributo("VAR", "hidAqueLPseVuelve", "valor", gLPVolver);
            }
        } else
        {
            asignarAtributo("VAR", "desactivarBotonBack", "valor", "true");
        }
        if(credenciales == null)
        {
            asignarAtributo("VAR", "errCodigo", "valor", "");
            asignarAtributo("VAR", "errDescripcion", "valor", "ERR_43");
            return;
        }
        HashMap propiedades = null;
        boolean claveVencida = false;
        try
        {
            if(!accion.equals("continuar"))
            {
                if(accion.equals(""))
                {
                    try
                    {
                        propiedades = (HashMap)conectorParametroSesion("propiedades");
                        Property claveInicial = (Property)propiedades.get("IndicacionClaveInicial");
                        if(claveVencida || claveInicial != null && claveInicial.getValue() != null && claveInicial.getValue().toString().equals("S"))
                        {
                            asignarAtributo("VAR", "desactivarBotonBack", "valor", "true");
                        }
                        asignarAtributo("VAR", "accion", "valor", "CambiarClave");
                    }
                    catch(Exception re)
                    {
                        asignarValoresPagina();
                        asignarAtributo("VAR", "errCodigo", "valor", "");
                        asignarAtributo("VAR", "errDescripcion", "valor", re.getMessage());
                    }
                } else
                if(accion.equals("CambiarClave"))
                {
                    cambiarClave(credenciales);
                } else
                {
                    String esito = conectorParametroLimpia("exito", "", true);
                    asignarAtributo("VAR", "exito", "valor", esito);
                    asignarAtributo("VAR", "user", "valor", credenciales.getUser().toString());
                    asignarAtributo("VAR", "pass", "valor", credenciales.getPassword().toString());
                }
            }
        }
        catch(Exception e)
        {
            asignarValoresPagina();
            lanzarPaginaError(e);
            asignarAtributo("VAR", "recargaMenu", "valor", "true");
        }
    }

    private void asignarValoresPagina()
        throws Exception
    {
        asignarAtributo("CTEXTO", "txtClaveNueva", "valor", txtClaveNueva);
        asignarAtributo("CTEXTO", "txtConfirmarClaveNueva", "valor", txtConfirmarClaveNueva);
    }

    private void cambiarClave(MareCredentials credenciales)
        throws Exception
    {
        try
        {
            if(txtClaveNueva.toUpperCase().equals(credenciales.getUser().toString().toUpperCase()))
            {
                asignarAtributo("VAR", "mensaje", "valor", "134");
                asignarAtributo("VAR", "recargaMenu", "valor", "true");
            } else
            {
                DTOEntradaCambiarPassword dto = new DTOEntradaCambiarPassword();
                dto.setNewPass(txtClaveNueva);
                dto.setNewPassConfirm(txtConfirmarClaveNueva);
                dto.setPassword(UtilidadesSession.getDruidaPassword(this));
                dto.setUsuario(UtilidadesSession.getDruidaUsuario(this));
                dto.setUserName(dto.getUsuario());
                Vector vector = new Vector();
                vector.add(dto);
                vector.add(new MareBusinessID("MENCambiarPasswordUsuario"));
                conectar("ConectorCargaFormatos", vector);
                asignarAtributo("VAR", "mensaje", "valor", "135");
                asignarAtributo("VAR", "exito", "valor", "true");
                asignarAtributo("VAR", "volverAlLogin", "valor", "true");
                if(gLPVolver != null && gLPVolver.equals("LPCambiarClave"))
                {
                    traza("    conectorAction(LPCambiarClave);");
                    conectorAction("LPCambiarClave");
                }
            }
        }
        catch(RemoteException re)
        {
            re.printStackTrace();
            asignarAtributo("VAR", "recargaMenu", "valor", "true");
        }
    }
}
