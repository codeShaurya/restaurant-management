package dto;

public class Response {
   private Object data;
   private String message;
   private Integer code;

   public Response(Object data, String message, Integer code) {

      this.data = data;
      this.message = message;
      this.code = code;
   }

   public Object getData() {

      return data;
   }

   public void setData(Object data) {

      this.data = data;
   }

   public String getMessage() {

      return message;
   }

   public void setMessage(String message) {

      this.message = message;
   }

   public Integer getCode() {

      return code;
   }

   public void setCode(Integer code) {

      this.code = code;
   }

   @Override
   public String toString() {

      return "Response{" + "data=" + data + ", message='" + message + '\'' + ", code=" + code + '}';
   }
}
