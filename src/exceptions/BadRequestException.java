package exceptions;

public class BadRequestException extends Exception {

   private String message;

   public BadRequestException(String message) {

      this.message = message;
   }

   public String getMessage() {

      return message;
   }

   public void setMessage(String message) {

      this.message = message;
   }
}
