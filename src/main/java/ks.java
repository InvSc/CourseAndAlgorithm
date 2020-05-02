public class ks {
  public static void main(String[] args) {
	  String[] split = "http://google.ru/test".split("/");
	  String head = split[0] + "//" + split[2];
    	System.out.println(head);
  }
}
