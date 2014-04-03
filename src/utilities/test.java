package utilities;


public class test {
	public static void main(String[] arguments){
		Message jimmy = new Message("1234.5678.james.1lkjsoid;lksjfd529384lskjfd");
		System.out.println(jimmy.getOrigin());
		System.out.println(jimmy.getDestination());
		System.out.println(jimmy.getMessage());
		System.out.println(jimmy.getHash());
	}
}
