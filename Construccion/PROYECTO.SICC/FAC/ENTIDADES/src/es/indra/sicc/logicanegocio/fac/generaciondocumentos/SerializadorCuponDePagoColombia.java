package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorCuponDePagoColombia extends FixedDocument implements ISerializableDocument  {

    public SerializadorCuponDePagoColombia() {
        this.MSG = new ArrayList();
        this.numeroSecciones = 2;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 20;
        this.tamSecciones[1] = 20;
     
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
    }
    
       public void rellenarTabla(Hashtable documento) {
        UtilidadesLog.info("SerializadorCuponDePagoColombia.rellenarTabla(Hashtable documento): Entrada");
        StringBuffer sMensaje;
        Integer iKey;
        
        sMensaje = new StringBuffer("                                                          <8|1>            ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 5));
        iKey = new Integer(0);
        documento.put(iKey, sMensaje.toString());

        sMensaje = new StringBuffer(" <14>                  <20>                   ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 2));
        iKey = new Integer(1);
        documento.put(iKey, sMensaje.toString());

        sMensaje = new StringBuffer(" <45>                                                   <10>           ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 1));
        iKey = new Integer(2);
        documento.put(iKey, sMensaje.toString());
        
        
        sMensaje = new StringBuffer( " <45|0|3>                                                 ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 1));
        sMensaje.append(" <45|0|3>                                                     ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 1));
        sMensaje.append(" <45|0|3>                                          <15>            ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 1));
        iKey = new Integer(3);
        documento.put(iKey, sMensaje.toString());

        

        sMensaje = new StringBuffer(" <45>                                                   <10>       ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 3));
        iKey = new Integer(4);
        documento.put(iKey, sMensaje.toString());
      
        sMensaje = new StringBuffer(" SE ADJUNTAN <10|1>     UNIDADES FUERA DE CAJA            ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 1));
        iKey = new Integer(5);
        documento.put(iKey, sMensaje.toString());
   
        sMensaje = new StringBuffer(" SE ADJUNTAN <10|1>     UNIDADES EN BOLSA                 ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 3));
        iKey = new Integer(6);
        documento.put(iKey, sMensaje.toString());
   
   
        sMensaje = new StringBuffer("                                    <10|1>            ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 3));
        iKey = new Integer(7);
        documento.put(iKey, sMensaje.toString());
   
        sMensaje = new StringBuffer( "                                    <10|1>            ");
        sMensaje.append(this.agregarSaltosLinea(sMensaje.toString(), 30));
        iKey = new Integer(8);
        documento.put(iKey, sMensaje.toString());
   
        String sMensaj = this.agregarSaltosLinea("",1);
        iKey=new Integer(9);
        documento.put(iKey, sMensaj);
        
        UtilidadesLog.info("SerializadorCuponDePagoColombia.rellenarTabla(Hashtable documento): Salida");
   
    }       
    
    public void componerDocumento() {
        UtilidadesLog.info("SerializadorCuponDePagoColombia.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.info("SerializadorCuponDePagoColombia.componerDocumento(): Salida");
    }   
   
  public void addMensaje(String entrada)  {
    MSG.add(entrada);
  }   
}