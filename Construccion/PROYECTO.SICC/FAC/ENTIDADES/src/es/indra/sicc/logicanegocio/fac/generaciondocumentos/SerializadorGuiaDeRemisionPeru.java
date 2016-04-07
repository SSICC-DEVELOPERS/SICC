package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.UtilidadesLog;

public class SerializadorGuiaDeRemisionPeru extends FixedDocument implements ISerializableDocument
{
  public SerializadorGuiaDeRemisionPeru()
  {
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 16;
        this.tamSecciones[1] = 53;
        this.tamSecciones[2] = 7;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
  }

  /**
   * @author vconte
   * @param documento Hastable
   * @nota: cambio SICC-GCC-PED-003
   */
  public void rellenarTabla(Hashtable documento) {
    
      UtilidadesLog.info("SerializadorGuiaDeRemisionPeru.rellenarTabla(Hashtable "
                         + "documento):Entrada");
      String sMensaje; 
      Integer iKey; 

      sMensaje = "                                                                   PAG.<3|1> DE <3|1>";
      sMensaje = this.agregarSaltosLinea(sMensaje, 9);
      iKey = new Integer(0);
      documento.put(iKey, sMensaje);
      sMensaje = "           <10>                                                                 ";   //Fechas
      sMensaje = this.agregarSaltosLinea(sMensaje, 1);
      iKey = new Integer(1);
      documento.put(iKey, sMensaje);
      //sMensaje = "           <12>              <22|0|2>                                           ";   //Zona-Territorio - Referencia
      sMensaje = "                            <22|0|2>                                           ";   // Referencia
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      sMensaje += "           <12>             <22|0|2>                                            ";   // Zona-Territorio - Referencia
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      iKey = new Integer(2);
      documento.put(iKey, sMensaje);
      sMensaje = "           <12>                   ";    //Campaña
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      iKey = new Integer(3);
      documento.put(iKey, sMensaje);
      sMensaje = "           <12>             <12>                                              ";   //NroSalida
      sMensaje = this.agregarSaltosLinea(sMensaje,3);
      iKey = new Integer(4);
      documento.put(iKey, sMensaje);
      sMensaje = "   <40|0|2>                                 <38|0|2>                               ";   //Punto Partida - Punto Llegada
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      sMensaje += "   <40|0|2>                                 <38|0|2>                               ";   //Punto Partida - Punto Llegada
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      //sMensaje += "   <40|0|4>                                 ";   //Punto Partida - Punto Llegada
      sMensaje = this.agregarSaltosLinea(sMensaje,2);
      iKey = new Integer(5);
      documento.put(iKey, sMensaje);
      sMensaje = "           <32>                                                                     ";   // Destinatario
      sMensaje = this.agregarSaltosLinea(sMensaje,6);
      iKey = new Integer(6);
      documento.put(iKey, sMensaje);
      sMensaje = "                                                                              <1>";   //Motivo
      sMensaje = this.agregarSaltosLinea(sMensaje,4);
      iKey = new Integer(7);
      documento.put(iKey, sMensaje);
      sMensaje = "   <10>          <35>                                <9|1>    ";   //Detalle1
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      iKey = new Integer(8);
      documento.put(iKey, sMensaje);
      sMensaje = "                                                     <9>      ";   //Lineas
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      iKey = new Integer(9);
      documento.put(iKey, sMensaje);
      sMensaje = "                                               TOTAL <9|1>     ";   //Total
      sMensaje = this.agregarSaltosLinea(sMensaje,2);
      iKey = new Integer(10);
      documento.put(iKey, sMensaje);
      //sMensaje = "   <79|0|2>                                                                          ";   //GLOSA
      //sMensaje = this.agregarSaltosLinea(sMensaje,1);
      //sMensaje += "  <79|0|2>                                                                          ";   //GLOSA
      sMensaje = "   <78>                                                                              ";   //GLOSA
      sMensaje = this.agregarSaltosLinea(sMensaje,1);
      iKey = new Integer(11);
      documento.put(iKey, sMensaje);
      
      
      UtilidadesLog.info("SerializadorGuiaDeRemisionPeru.rellenarTabla(Hashtable "
                         + "documento):Salida");
 }   
    
    
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.info("SerializadorGuiaDeRemisionPeru.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }
        UtilidadesLog.debug("Documento Guia de REMISION: "+cadena.toString());
        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.info("SerializadorGuiaDeRemisionPeru.componerDocumento(): Salida");
    } 

    
}