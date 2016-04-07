package es.indra.sicc.cmn.negocio.interfaces.daemon.dao;

import java.sql.Date;

public class FileInfo 
{
  private String interfaz;
  private String file;
  private Integer state;
  private Date inDate;
  private Date notifDate;
  private Date outDate;
  
  public FileInfo()
  {
    
  }

  public FileInfo( String interfaz, String file, Integer state, Date inDate )
  {
    this.interfaz = interfaz;
    this.file = file;
    this.state = state;
    this.inDate = inDate;
  }
  
  public String toString()
  {
    return interfaz + "(" + file + ")";
  }

  public String getInterfaz()
  {
    return interfaz;
  }

  public void setInterfaz(String interfaz)
  {
    this.interfaz = interfaz;
  }

  public String getFile()
  {
    return file;
  }

  public void setFile(String file)
  {
    this.file = file;
  }

  public Integer getState()
  {
    return state;
  }

  public void setState(Integer state)
  {
    this.state = state;
  }

  public Date getInDate()
  {
    return inDate;
  }

  public void setInDate(Date inDate)
  {
    this.inDate = inDate;
  }

  public Date getNotifDate()
  {
    return notifDate;
  }

  public void setNotifDate(Date notifDate)
  {
    this.notifDate = notifDate;
  }

  public Date getOutDate()
  {
    return outDate;
  }

  public void setOutDate(Date outDate)
  {
    this.outDate = outDate;
  }
}