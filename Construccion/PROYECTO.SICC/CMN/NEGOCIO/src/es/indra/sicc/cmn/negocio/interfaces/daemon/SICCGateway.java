package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
//import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.ConfigFactory;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;

import es.indra.sicc.util.DTOString;
import java.rmi.RemoteException;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class SICCGateway
{
  public SICCGateway()
  {
  }
  
  public static boolean notifyFile( String IDBusiness, String country )
  {
		Util.getLog().info( "[INTDaemon] Método notifyFile" );

		
		try
		{
      BusinessFacade bf = getBusinessFacade();
			DTOString dto = new DTOString();
			dto.setCadena( country );
			//MareDTO dto = new MareDTO();
			//dto.setProperty( "cadena", country );
			DTOBatch dtoBatch = new DTOBatch( "{INTDaemon] notifyFile", 
																				new MareBusinessID( IDBusiness ),
																				dto );
			bf.execute( dtoBatch, 
								  new MareBusinessID( ConfigFactory.getINTDaemonConfig().getQueueingIDBusiness() ) );

		} catch( Exception rex ){
			Util.getLog().error( "Error en invocación remota al Business Facade", rex );
			return false;
		}
		
		return true;
  }
  
  public static BusinessFacade getBusinessFacade() throws MareException
  {
    BusinessFacade businessFacade = null;
	  
	  try {
		  Context context = getInitialContext();
		  String jndiName = ConfigFactory.getINTDaemonConfig().getBusinessFacade();
      
          //BusinessFacadeHome mlnHome = (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup(jndiName), BusinessFacadeHome.class);
          BusinessFacadeHome mlnHome = (BusinessFacadeHome)context.lookup( jndiName );
		  businessFacade = mlnHome.create();

	  } catch (Exception e) {
      Util.getLog().error("ERROR",e);
		  throw new MareException( "Error localizando la BusinessFacade remota", e );
	  }
	  return businessFacade;
  }
	
	private static Context getInitialContext() 
		throws NamingException, MareException {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
						ConfigFactory.getINTDaemonConfig().getInitialContextFactory());
		env.put(Context.SECURITY_PRINCIPAL, 
						ConfigFactory.getINTDaemonConfig().getPrincipal() );
		env.put(Context.SECURITY_CREDENTIALS, 
						ConfigFactory.getINTDaemonConfig().getCredentials() );
        Util.getLog().debug(ConfigFactory.getINTDaemonConfig().getProvider());
		env.put(Context.PROVIDER_URL, ConfigFactory.getINTDaemonConfig().getProvider());
  
		return new InitialContext(env);
	}
}