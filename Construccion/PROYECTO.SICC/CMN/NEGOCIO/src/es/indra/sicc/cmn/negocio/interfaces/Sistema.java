//Source file: F:\\SICC\\src\\es\\indra\\sicc\\cmn\\negocio\\interfaces\\Sistema.java

package es.indra.sicc.cmn.negocio.interfaces;


public class Sistema 
{
   
   /**
    * Código alfanumérico que identifica a un sistema informático de Belcorp.
    */
   private String codigo;
      
   /**
    * @roseuid 407F3C17010F
    */
   public Sistema() 
   {
   }

   public Sistema( String codigo )
   {
     this.codigo = codigo;
   }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

}
