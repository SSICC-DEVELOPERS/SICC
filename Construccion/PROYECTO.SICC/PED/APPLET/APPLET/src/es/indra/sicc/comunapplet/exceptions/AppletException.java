package es.indra.sicc.comunapplet.exceptions;
import es.indra.mare.common.exception.MareException;

public class AppletException extends MareException 
{
  public AppletException(Exception t)
	{
    super(t);
	}

 public AppletException(Exception t, String msg)
	{
    super(msg, t);
	}

  public AppletException(Exception t, int i)
	{
    super(t, i);
	}

  public AppletException(String msg)
	{
    super(msg);
	}
  
  public AppletException(int i)
	{
    super();
    super.setCode(i);
	}
  
  
  
}