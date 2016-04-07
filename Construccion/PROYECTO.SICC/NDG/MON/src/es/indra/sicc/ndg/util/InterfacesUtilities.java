package es.indra.sicc.ndg.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class InterfacesUtilities 
{
  private static final String BUZONES = "BUZONES";
  private static final String BUZONENTRADA = "BUZONENTRADA";
  private static final String BUZONSALIDA = "SALIDA";
  private static final String ATT_PATH = "path";
  private static final String ATT_PREFIJOS = "prefijos";
  private static Hashtable pathsEntrada = null;
  private static Hashtable prefijos = null;
  
  private static Long fechaUltimaModificacion = null;
  private static String archivoNodos;
  
  private static InterfacesUtilities interfacesUtilities;
  
  public static void iniciarActualizacionBuzones(){
    if(interfacesUtilities == null){
      String buzones = System.getProperty("MareConfigurationRoot")+"/buzonesNDG.xml";
      interfacesUtilities = new InterfacesUtilities(buzones);
    }
  }
  
  public InterfacesUtilities(String path)
  {
    archivoNodos = path;
    RunnableInterfaces runnable = new RunnableInterfaces();
    Thread thread = new Thread(runnable);
    thread.start();    
  
  }
  
  class RunnableInterfaces implements Runnable {
  
    public void run() {
      boolean parar = false;
      while(!parar) {
        File file = new File(archivoNodos);
        if(!file.exists() ||
          file.isDirectory()) 
          {
            System.out.println("La retua especificada es incorrecta.");
            parar = true;
          } else {
            long fechaModificacion = file.lastModified();
      
            if(fechaUltimaModificacion == null ||
              fechaUltimaModificacion.longValue() == fechaModificacion) {
                this.obtenerConfiguracionInterfaces();
            }
            
            if(pathsEntrada != null) {
              Enumeration enum = pathsEntrada.keys();
              while (enum.hasMoreElements()) {
                String key = (String) enum.nextElement();                
                this.copiarArchivo(key, (Collection)pathsEntrada.get(key));
              }
            }
             
          }
          try {
            Thread.sleep(1000 * 60);
          } catch(InterruptedException e) {
            e.printStackTrace();
          }
      }
    }
    
    private void copiarArchivo(String pathEntrada, Collection pathsSalida) {
      File file = new File(pathEntrada);
      if (file.exists()) {
        if(!file.isDirectory()) {          
          this.copiarArchivo(file, pathsSalida);
          file.delete();
        } else {
          File[] aux = file.listFiles();
          for (int i = 0; i < aux.length; i++) {
            if(!aux[i].isDirectory()) {              
              this.copiarArchivo(aux[i], pathsSalida);
            }            
          }
          this.delelte(aux);
        }
      }      
    }
    
    private void copiarArchivo(File file, Collection pathsSalida) {
      Iterator it = pathsSalida.iterator();
      String pathFile = file.getParent();
      Collection pref = (Collection)prefijos.get(pathFile);
      boolean copiar = true; 
      if(pref != null) {
        Iterator itPref = pref.iterator();
        boolean flag = false;
        while (itPref.hasNext() && !flag) {
          String str = (String)itPref.next();
          if(file.getName().toUpperCase().startsWith(str.toUpperCase())) {
            flag = true;
          }
        }
        copiar = flag;
      }
      System.out.println("el archivo " + file + " se copia??? " + copiar);
      while(copiar && it.hasNext()) {
        String path = (String)it.next();
        File fileDest = new File(path + File.separator + file.getName());
        try {
          this.copy(file, fileDest);
        } catch(IOException e) {
          System.out.println("No se pudo copiar el archivo " + file.getAbsolutePath() + " a " + fileDest.getAbsolutePath());
        }
      }
    }
    
    private void copy(File src, File dst) throws IOException {
        java.io.InputStream in = new java.io.FileInputStream(src);
        java.io.OutputStream out = new java.io.FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    private void delelte(File []files) {
      for (int i = 0; i < files.length; i++) {
        files[i].delete();
        
      }
      
    }
    
    private void obtenerConfiguracionInterfaces() {
      Document document = null;
      File pathConf = new File( archivoNodos );
      SAXReader reader = new SAXReader();
  
      try {
        document = reader.read( pathConf );
      } catch (java.net.MalformedURLException ex) {
        System.out.println("ERROR: URL mal formada");
      } catch (DocumentException dex) {
        System.out.println("ERROR: No se a podido parsear el archivo: " + dex );        
      }
      
      pathsEntrada = null;
      
      try {
        Element root = document.getRootElement();
        List buzones = document.selectNodes("//" + BUZONES + "/" + BUZONENTRADA);
  
        String pathEntrada = null;
        String auxPrefijos = null;
        for (Iterator j = buzones.iterator(); j.hasNext();) {
            Element entrada = (Element) j.next();
            
            pathEntrada = entrada.attribute(ATT_PATH).getValue();
            auxPrefijos = entrada.attribute(ATT_PREFIJOS).getValue();

            List salidas = entrada.selectNodes(BUZONSALIDA);
            String pathSalida = null;
            Collection pathsSalida = null;
            
            for (Iterator k = salidas.iterator(); k.hasNext();) {
                Element interfaz = (Element) k.next();
                pathSalida = interfaz.attributeValue(ATT_PATH);                      
                if(pathsSalida == null) {
                  pathsSalida = new Vector();
                }
                pathsSalida.add(pathSalida);
            }
            
            if(pathEntrada != null && pathsSalida != null) {
              if(pathsEntrada == null) {
                pathsEntrada = new Hashtable();
              }
              pathsEntrada.put(pathEntrada, pathsSalida);
              
              if(auxPrefijos !=null) {
                if(prefijos == null) {
                  prefijos = new Hashtable();
                }
                Collection colPrefijos = new Vector();
                StringTokenizer st = new StringTokenizer(auxPrefijos, ";");
                System.out.println("prefijos: " + auxPrefijos);
                System.out.println("prefijos 2 : " + st.toString());
                while(st.hasMoreTokens()) {
                  colPrefijos.add(st.nextToken());
                }
                prefijos.put(pathEntrada, colPrefijos);
                
              }
            }
        }
        
        fechaUltimaModificacion = new Long(System.currentTimeMillis());
      } catch (Exception ex) {
        System.out.println("ERROR: " + ex.getMessage());        
        ex.printStackTrace();
      }
    }
  }


  /*public static void main(String []args) {
    if (args.length == 0) {
      System.out.println("Falta especificar la ruta completa del archivo de configuración.");
      System.exit(0);
    }
    //String aux = "c:\\construccion\\Belcorp\\PROYECTO.V03.03\\NDG\\MON\\classes\\buzonesNDG.xml";
    new InterfacesUtilities( args[0] );
  }*/
  
  
  
}