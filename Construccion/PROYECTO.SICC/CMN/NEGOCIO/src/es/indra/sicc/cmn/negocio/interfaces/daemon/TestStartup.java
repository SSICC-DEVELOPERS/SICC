package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.sicc.cmn.negocio.interfaces.daemon.INTDaemonStartup;

public class TestStartup  {

	INTDaemonStartup startup = null;

	public TestStartup() throws Exception {
		startup = INTDaemonStartup.getInstance();
		startup.start();
		Thread.sleep( 10000L );
		startup.stop();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		TestStartup testStartup = new TestStartup();
	}
}