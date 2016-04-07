package com.calipso.reportgenerator.reportmanager;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Representa el repositorio de los usuarios con
 * sus respectivas contrasenas
 */

public class UsersRepository {

  private HashMap users;
  private String repositoryPath;

  /**
   * Crea una instancia de <code>UsersRepository</code>
   * @param repositoryPath
   */
  public UsersRepository(String repositoryPath) {
    try {
      this.repositoryPath = repositoryPath;
      initialize(new File(repositoryPath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Llena un diccionario con los valores del repositorio
   * en caso de que este ultimo exista
   * @param repositoryFile
   * @throws IOException
   */
  private void initialize(File repositoryFile) throws IOException {
    if(repositoryFile.exists()) {
      fillUsersMapFrom(repositoryFile);
    }
  }

  /**
   * Llena un diccionario con los valores del repositorio.
   * Cada entrada al diccionario contiene el nombre de usuario
   * mientras que a cada entrada le corresponden las contrasenas
   * de los usuarios.
   * @param repositoryFile
   */
  private void fillUsersMapFrom(File repositoryFile) {
    try {
      FileReader fileReader = new FileReader(repositoryFile);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line = bufferedReader.readLine();
      while(line != null)  {
        if(!line.equals("")) {
          StringTokenizer tokenizer = new StringTokenizer(line, "=");
          String user = tokenizer.nextToken();
          String password = tokenizer.nextToken();
          getUsers().put(user, password);
        }
        line = bufferedReader.readLine();
      }
      bufferedReader.close();
      fileReader.close();
    } catch(FileNotFoundException e) {

    } catch(IOException e) {

    }
  }

  /**
   * Valida un usuario. En caso de ser un usuario inexistente
   * permite dar de alta el usuario siempre y cuando se ingrese
   * la contrasena de root o admin. Por ello solo root puede dar
   * de alta usuarios.
   * @param userName nombre de usuario
   * @param password contrasena de usuario
   * @return
   */
  public boolean validate(String userName, String password) {
    boolean returnVal = false;
    if(getUsers().containsKey(userName)) {
      String encryptPassword = PasswordEncryptor.getEncryptedPassword(password);
      String storedPassword = getUsers().get(userName).toString();
      if(storedPassword.trim().equalsIgnoreCase(encryptPassword.trim())) {
        returnVal = true;
      }
    }
    return returnVal;
  }

  /**
   * Cambia la contrasena de un usuario
   * @param userName nombre de usuario
   * @param newPasswd nueva contrasena
   */
  public void changePasswd(String userName, String newPasswd) {
    getUsers().remove(userName);
    getUsers().put(userName, newPasswd);
    updateChanges();
  }

  /**
   * Borra un usuario del repositorio
   * @param userName
   */
  public void deleteUser(String userName) {
    getUsers().remove(userName);
    updateChanges();
  }

  /**
   * Actualiza los cambios realizados en el repositorio.
   */
  private void updateChanges() {
    try {
      File outputFile = new File(repositoryPath);
      FileWriter fileWriter = null;
      fileWriter = new FileWriter(outputFile.getPath(), true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      Iterator iterator = getUsers().keySet().iterator();
      while(iterator.hasNext()) {
        String currentUserName = iterator.next().toString();
        String hashedPasswd = getUsers().get(currentUserName).toString();
        bufferedWriter.write(currentUserName + "=" + hashedPasswd + '\n');
      }
      bufferedWriter.close();
      fileWriter.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Agrega un nuevo usuario.
   * @param userName
   * @param password
   */
  public void addNewUser(String userName, String password) {
    try {
      File outputFile = new File(repositoryPath);
      FileWriter fileWriter = null;
      fileWriter = new FileWriter(outputFile.getPath(), true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(userName + "=" + PasswordEncryptor.getEncryptedPassword(password) + '\n');
      bufferedWriter.close();
      fileWriter.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Devuelve los usuarios del repositorio
   * @return
   */
  private HashMap getUsers() {
    if(users == null) {
      users = new HashMap();
    }
    return users;
  }
}
