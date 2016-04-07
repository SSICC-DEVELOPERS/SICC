package es.indra.sicc.logicanegocio.pre.test;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.logicanegocio.pre.MONOferta;
import es.indra.sicc.logicanegocio.pre.MONOfertaHome;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class ClubPrivilegesCliente 
{
    /**
     * 
     * @date 
     */
    public ClubPrivilegesCliente() throws Exception   {

    }
    public static void main(String [] args) throws Exception   {
        CPAux clubPriv= new CPAux();
        DTOSCargarCriteriosDefinirOferta criterioGral = clubPriv.cargarCriteriosDefinirOferta();

    }
}

class CPAux extends DTOAuditableSICC  {
    public CPAux(){}
    /**
     * 
     * @date 
     * @throws java.lang.Exception
     * prueba el método cargarCriteriosDefinirOferta de PREConsultas
     */
    public DTOSCargarCriteriosDefinirOferta cargarCriteriosDefinirOferta() throws Exception{
        DTOSCargarCriteriosDefinirOferta criterioGral = null;
        try{
            Context context = getInitialContext();
            MONOfertaHome mon = (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("MONOferta"), MONOfertaHome.class);
            MONOferta monLocal = mon.create();
            DTOECargarCriteriosDefinirOferta dtoe = new  DTOECargarCriteriosDefinirOferta ();
            dtoe.setOidCabeceraMF(new Long (1042));
            dtoe.setOidIdioma(new Long (1));
            dtoe.setOidPais(new Long (1));
            dtoe.setOidEstrategia(new Long (4));
            
            criterioGral = monLocal.cargarCriteriosDefinirOferta(dtoe); 
            System.out.println("");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return criterioGral;
    }
    /**
     * 
     * @date 
     * @throws java.lang.Exception
     * prueba MONMantenimientoMF.obtenerVariantes y con este tambien se prueba el 
     * método PREConsultas.obtenerVariantes ya que el primero llama al segundo
     */
         public void obtenerVariantes() throws Exception{
        /*Ya fue realizado ver ClubPrivPREConsultasClient
         * 
         * */
     }
     
    
     
    
     public static  Context getInitialContext() throws NamingException  {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "welcome");
        env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server"); 

        return new InitialContext(env);
    }
    
    
}
