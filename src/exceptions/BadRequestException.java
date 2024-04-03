package exceptions;

public class BadRequestException extends Exception {

   public BadRequestException(String message) {

      this.message = message;
   }

   private String message;

   public String getMessage() {

      return message;
   }

   public void setMessage(String message) {

      this.message = message;
   }
}
