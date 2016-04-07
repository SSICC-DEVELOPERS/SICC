package es.indra.sicc.comunapplet;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.comunapplet.dtos.applet.DTOException;
import es.indra.sicc.comunapplet.exceptions.AppletException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Title: Communicator
 * Description: Defines methods that deal with the data interchange process between
 * client-side applications and the server. 
 * The data is sent to the server's <i>scripts</i> through the HTTP's <i>POST</i> method.
 */
public class Communicator {

  private void printTrace(String trace){
    System.out.println("Trace: " + trace);
  }

  private void printTrace(Exception e){
    e.printStackTrace();
  }

  /**
   * Receive the response of the previously executed function
   * {@link utils.communicator#postRequest postRequest}.
   */
  public String receiveResponse(URLConnection urlConn) {
    BufferedReader input;
    String str;
    String strResponse;
    //printTrace("_I receiveResponse(URLConnection urlConn) urlConn="+((urlConn==null)?"null":urlConn.toString()));
    try {
      InputStream is = urlConn.getInputStream();
      input = new BufferedReader(new InputStreamReader (urlConn.getInputStream()));
      //ORIGINAL CODE
      //input = new BufferedReader(new InputStreamReader (urlConn.getInputStream()));
      strResponse="";
      while (null != (str = input.readLine())) 
        strResponse += str;
      input.close();
    } catch (Exception e) {
      printTrace(e);
      strResponse=null;
    }
    //printTrace("_F receiveResponse(URLConnection urlConn) "+strResponse);
    return strResponse;
  }

  /**
   * Receive the response of the previously executed function
   * {@link utils.communicator#postRequest postRequest}.
   * Returns the response in binary format.
   */
  public byte[] receiveBinaryResponse(URLConnection urlConn) {
    byte imageBytes[];
    byte buffer[] = new byte[512*1024];
    int currByte;

    int bytesRead;
    InputStream in;

    //printTrace("_I receiveBinaryResponse(URLConnection urlConn) urlConn="+((urlConn==null)?"null":urlConn.toString()));
    try {
      in = urlConn.getInputStream();
      bytesRead=0;
      currByte = in.read();
      while(currByte!=-1) {
        buffer[bytesRead++]=(byte)currByte;
        currByte=in.read();
      }
      imageBytes = new byte[bytesRead];
      System.arraycopy(buffer,0,imageBytes,0,bytesRead);
    } catch (Exception e) {
      printTrace(e);
      imageBytes = new byte[0];
    }
    //printTrace("_F receiveBinaryResponse(URLConnection urlConn) "+(new String(imageBytes)));
    return imageBytes;
  }

  /**
   * Send data to the server through the HTTP's <i>POST</i> method.
   * @param urlConn A connection with a URL.
   * @param content Data to be sent to the server's <i>script</i>.
   */
  public void postRequest(URLConnection urlConn, String content) {
    DataOutputStream printout;
    //printTrace("_I postRequest(URLConnection urlConn, String content) urlConn="+((urlConn==null)?"null":urlConn.toString())+", content="+content);
    urlConn.setRequestProperty ("Content-Type","application/x-www-form-urlencoded");
//"application/octet-stream");
    try {
      urlConn.setUseCaches(false);
      printout = new DataOutputStream (urlConn.getOutputStream());
      //new ObjectOutputStream(
      
      // You must replace every white space in the data sent with %20 (ASCII 32 Hex) 
      // in order to preserve data integrity.
      printout.writeBytes(content);//.replaceAll(" ","%20"));
      printout.flush();
      printout.close();
    } catch (Exception e) {
      printTrace(e);
    }
    //printTrace("_F postRequest(URLConnection urlConn, String content)");
    return;
  }

  /**
   * Send data to the server through the HTTP's <i>POST</i> method with the ENCODER option.
   * In this case, the page that receives the data must use a DECODER to translate the data.
   * @param urlConn A connection with a URL.
   * @param content Data to be sent to de server's <i>script</i>.
   * @param encoder true if the data has to be sent encoded.
   */
  public void postRequest(URLConnection urlConn, String content, boolean encoder) {
    DataOutputStream printout;
    //printTrace("_I postRequest(URLConnection urlConn, String content, boolean encoder) urlConn="+((urlConn==null)?"null":urlConn.toString())+", content="+content+", encoder="+(new Boolean(encoder)).toString());
    urlConn.setRequestProperty ("Content-Type","application/x-www-form-urlencoded");

    try {
      urlConn.setUseCaches(false);
      printout = new DataOutputStream (urlConn.getOutputStream());
      printout.writeBytes(encoder?URLEncoder.encode(content, "UTF-8"):content);
      printout.flush();
      printout.close();
    } catch (Exception e) {
      printTrace(e);
    }
    //printTrace("_F postRequest(URLConnection urlConn, String content, boolean encoder)");
    return;
  }

  /**
   * Creates a connection with an specified URL.
   * @param document Character sequence that represents the URL to connect to.
   */
  public static URLConnection createURLConnection (String document) {
    URLConnection urlConn;
    URL url;
    //System.out.println("_I createURLConnection(String document) document="+document);
    try {
      url = new URL (document);
      urlConn = url.openConnection();
      urlConn.setDoOutput(true);
      urlConn.setDoInput(true);
      urlConn.setUseCaches(false);
      urlConn.setDefaultUseCaches (false);

      //System.out.println("_F createURLConnection(String document) "+urlConn.toString());
      return urlConn;
    } catch (Exception e) {
      //System.out.println(e);
      e.printStackTrace();
      return null;
    }
  }
 
  /**
   * Send data to the server through HTTP's <i>POST</i> method and
   * returns the server's response.
   * @param document Character sequence that represents the URL to connect to.
   * @param content Data to be sent to the server.
   */
  public String postRequest(String document, String content) {
    URLConnection urlConn;
    //printTrace("_I postRequest(String document, String content) document="+document+", content="+content);
    urlConn = createURLConnection(document);
    postRequest(urlConn,content);
    String result = receiveResponse(urlConn);
    //printTrace("_F postRequest(String document, String content) "+result);
    return result;
  }

  /**
   * Send base 64 encoded data to the server through the HTTP's <i>POST</i> method.
   * @param urlConn A connection with a URL.
   * @param content Data to be encode and sent to the server's <i>script</i>.
   */
  public void postRequest64Encode(URLConnection urlConn, String content) {
    DataOutputStream printout;
    //printTrace("_I postRequest64Encode(URLConnection urlConn, String content) urlConn="+((urlConn==null)?"null":urlConn.toString())+", content="+content);
    urlConn.setRequestProperty ("Content-Type","application/x-www-form-urlencoded");
    //urlConn.setRequestProperty ("Content-Type","text/plain");
    //urlConn.setRequestProperty ("Content-Transfer-Encoding","base64");
    //urlConn.setRequestProperty ("charset","ISO-8859-1");

    try {
      urlConn.setUseCaches(false);
      printout = new DataOutputStream (urlConn.getOutputStream());
      printout.writeBytes(content);
      printout.flush();
      printout.close();
    } catch (Exception e) {
      printTrace(e);
    }
    //printTrace("_F postRequest64Encode(URLConnection urlConn, String content)");
    return;
  }

  //yyy !!!FALTA!!! url la recibe CobrarBelcenter por parametro de su clase llamante
  //03/03/2005 mmaidana
  public MareDTO ejecutarNegocio(String url, String idBusiness, String nombreDTO, MareDTO dto ) throws AppletException {
    Object object = null;
    
    //Se serializa el objeto
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try {
      ObjectOutputStream oos = new ObjectOutputStream(baos);

      oos.writeObject(dto);
      oos.flush();
    } catch (java.io.IOException e) {
      throw new AppletException("Error de serealización del objeto");
    }
    byte []serializedBytes = baos.toByteArray();
    
    String serializedDto = new sun.misc.BASE64Encoder().encode(serializedBytes);
    //serializedBytes = Base64.encode(serializedBytes);
    //String serializedDto = new String(serializedBytes);
        
    //se arma el mensaje a ser enviado
    URLConnection urlConn = Communicator.createURLConnection(url);
    //URLConnection urlConn = Communicator.createURLConnection("http://192.168.118.101:7777/sicc/ServletApplet");
    String content = "IDBusiness=" + idBusiness + "&-&DTOE=" + nombreDTO;
    content += "&-&DTOData=" + serializedDto;
    
    //Communicator com = new Communicator();
    
    this.postRequest(urlConn, content);
    byte[] response = this.receiveBinaryResponse(urlConn);

    if(response != null || response.length > 0) {
      //se deserealiza la respuesta y se retorna el objeto
          
      ByteArrayInputStream bais = new ByteArrayInputStream(response);
      try {
      //System.out.println("bais: " + bais);
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
        //System.out.println("mmmm");
        object = ois.readObject();
        //System.out.println("object: " + object);
      } catch (java.io.IOException e) {
        e.printStackTrace();
        throw new AppletException(ConstantesApplet.ERROR_DE_SERVIDOR);// "Error de comunicación con servlet");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new AppletException(ConstantesApplet.ERROR_DE_SERVIDOR);//"Error de comunicación con servlet");
      }
    }
    System.out.println("el object es: " + object);    
    
    if(object == null) {
      throw new AppletException(ConstantesApplet.ERROR_DE_SERVIDOR);
    }
    
    if(object instanceof DTOException) {
      throw new AppletException(((DTOException)object).getException(), ((DTOException)object).getDescripcion());
    } 
    
    return (MareDTO) object;
  }
  
}
