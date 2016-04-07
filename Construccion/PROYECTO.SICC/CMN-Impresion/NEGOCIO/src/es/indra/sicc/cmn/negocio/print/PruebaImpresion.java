package es.indra.sicc.cmn.negocio.print;

public class PruebaImpresion 
{
  public PruebaImpresion()
  {
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    PruebaImpresion pruebaImpresion = new PruebaImpresion();
    try{
        ImpressionParameters parametros = new ImpressionParameters();
        parametros.setAtributo_1("192.168.119.246");
        parametros.setAtributo_2("515");
        parametros.setAtributo_3("HP");
        LPRPrint lpr = new LPRPrint(parametros);
        byte[] aImprimir = new String("Pistola3").getBytes();
        lpr.print(aImprimir);
    }catch(Exception e){
        e.printStackTrace();
    }
  }
}