package com.calipso.reportgenerator.common;
import es.indra.mare.common.info.InfoException;

public class MultipleStringInfoException extends InfoException 
{
  private String[] messages;
  private Throwable cause;
  private Integer code;
 
  public MultipleStringInfoException(String[] messages)
  {
    this.messages = messages;
  }

  public MultipleStringInfoException(String[] messages, Throwable cause)
  {
    this.messages = messages;
    this.cause = cause;
  }

  public MultipleStringInfoException(String[] messages, int code)
  {
    this.messages = messages;
    this.code = new Integer(code);
  }

  public MultipleStringInfoException(String[] messages, Throwable cause, int code)
  {
    this.messages = messages;
    this.cause = cause;
    this.code = new Integer(code);
  }
  
  public String[] getMessages()
  {
    return messages;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public InfoException getInfoException(String message, Throwable cause)
  {
    if(code != null)
    {
      if(cause != null)
      {
        return new InfoException(message, cause, code.intValue());
      }else
      {
        return new InfoException(message, code.intValue());
      }
    }else if(cause != null)
    {
      return new InfoException(message, cause);
    }else
    {
      return new InfoException(message);
    }
  }
  
  public void setOriginalCause(Throwable e)
  {
    this.cause = e;
  }

}