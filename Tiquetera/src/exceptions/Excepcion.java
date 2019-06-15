package exceptions;

public class Excepcion extends Exception {
  private static final long serialVersionUID = 1L;
  public Excepcion(String message) {
    super(message);
  }
  public Excepcion(String message, int code) {
    super(message + "\n Error #" + code);
  }

}