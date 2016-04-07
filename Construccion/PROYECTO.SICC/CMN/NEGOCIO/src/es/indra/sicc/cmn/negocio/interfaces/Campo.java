package es.indra.sicc.cmn.negocio.interfaces;

public class Campo 
{
  private String nombre;
  private Class clase;
  private int ancho;
  private int decimales;
  private String coma;

  public Campo()
  {
  }

  public Campo( String nombre, Class clase, int ancho, int decimales, String coma )
  {
    this.nombre = nombre;
    this.clase = clase;
    this.ancho = ancho;
    this.decimales = decimales;
    this.coma = coma;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String newNombre)
  {
    nombre = newNombre;
  }

  public Class getClase()
  {
    return clase;
  }

  public void setClase(Class newClase)
  {
    clase = newClase;
  }

  public int getAncho()
  {
    return ancho;
  }

  public void setAncho(int newAncho)
  {
    ancho = newAncho;
  }

  public int getDecimales()
  {
    return decimales;
  }

  public void setDecimales(int newDecimales)
  {
    decimales = newDecimales;
  }

  public String getComa()
  {
    return coma;
  }

  public void setComa(String newComa)
  {
    coma = newComa;
  }
}