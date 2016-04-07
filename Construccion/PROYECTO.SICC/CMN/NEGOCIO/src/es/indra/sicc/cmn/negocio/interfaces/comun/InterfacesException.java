package es.indra.sicc.cmn.negocio.interfaces.comun;

public class InterfacesException extends Exception 
{
  private String motivo;
  private Exception ex;

  public InterfacesException()
  {
	super();
  }

  public InterfacesException( String motivo, Exception ex ) {
	  super();
	  this.motivo = motivo;
	  this.ex = ex;
  }

  public InterfacesException( String motivo )
  {
    this( motivo, null );
  }

  public InterfacesException( Exception ex )
  {
    this( null, ex );
  }

  public String getMotivo()
  {
    return motivo;
  }


  public Exception getEx()
  {
    return ex;
  }
}