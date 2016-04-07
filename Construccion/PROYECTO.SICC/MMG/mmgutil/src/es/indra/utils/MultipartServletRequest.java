package es.indra.utils;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MultipartServletRequest implements Serializable 
{
  private static final int SIZE = 1024;
  private Hashtable parameters;
  private Hashtable fileNames;
  private String queryString;
  private Hashtable htQueryString;

  public MultipartServletRequest(HttpServletRequest request) throws Exception
  {
    parameters = new Hashtable();
    fileNames = new Hashtable();
    queryString = request.getQueryString();

    if (queryString != null)
      htQueryString = HttpUtils.parseQueryString(queryString);
    else
      htQueryString = new Hashtable();

    ServletInputStream sis = request.getInputStream();

    String boundary;

    ByteArrayOutputStream baos = null;
          
    int pos = 0;
    boundary = request.getHeader("Content-Type");

    if (boundary != null)
    {
      pos = boundary.indexOf("boundary=");
      boundary = boundary.substring(pos + 9);
    
      byte[] buffer = new byte[SIZE];
    
      int status = 0;

      int len = 0;
      int namePos;
      int namePosEnd;
      String name = "";
      int fileNamePos;
      int fileNamePosEnd;
      String fileName = "";
      String value;

      byte[] writeBuffer = null;

      while (len != (-1))
      {
        len = sis.readLine(buffer, 0, SIZE);

        if (len != (-1))
        {
          String str = new String(buffer, 0, len);
    
          if (status == 3)
          {
            if (str.indexOf(boundary) == (-1)) 
            {
              if (writeBuffer != null)
              {
                baos.write(writeBuffer);
              }

              writeBuffer = new byte[len];
              for (int i = 0; i < len; i++)
              {
                writeBuffer[i] = buffer[i];
              }
            }
            else
            {
              if (writeBuffer != null) 
              {
                baos.write(writeBuffer, 0, writeBuffer.length - 2);
              }

              parameters.put(name, baos.toByteArray());

              fileNames.put(name, fileName);

              status = 1;
            }
          }
    
          else if (status == 2)
          {
            while (!str.equals(new String(new byte[] {13,10})))
            {
              len = sis.readLine(buffer, 0, SIZE);        
              str = new String(buffer, 0, len);
            }

            status++;

            baos = new ByteArrayOutputStream();
  
            writeBuffer = null;
          }
    
          else if (status == 1)
          {
            namePos = str.indexOf("name=\"");
            namePosEnd = str.indexOf("\"", namePos + 6);
            name = str.substring(namePos + 6, namePosEnd);

            fileNamePos = str.indexOf("filename=\"");
            if (fileNamePos == (-1))
            {
              fileName = ""; 
            }
            else
            {
              fileNamePosEnd = str.indexOf("\"", fileNamePos + 10);
              fileName = str.substring(fileNamePos + 10, fileNamePosEnd);
            }

            status++;
          }
    
          else if (status == 0)
          {
            if (str.indexOf(boundary) != (-1)) status++;        
          }
        }
      }
    }
  }
   
  public String getFileName(String name)
  {
    String fileName = (String) fileNames.get(name);
    if (fileName != null) return fileName;
    else return "";
  }

  public String getParameter(String name)
  {
    byte[] bytes = (byte[]) parameters.get(name);
    if (bytes == null) return null;
    else return new String(bytes);
  }

  public byte[] getParameterBytes(String name)
  {
    return (byte[]) parameters.get(name); 
  }

  public void setParameter(String paramName, byte[] paramValue)
  {
  	parameters.put(paramName, paramValue);
  }

  public Enumeration getParameterNames()  
  {
    return parameters.keys(); 
  }

  public String getQueryString()
  {
    return queryString; 
  }

  public String getQueryString(String name)
  {
    String[] parameter = (String[]) htQueryString.get(name);
    
    if (parameter != null)
      return parameter[0];
    else
      return null;
  }

  public Enumeration getQueryStringNames()
  {
    return htQueryString.keys(); 
  }
}