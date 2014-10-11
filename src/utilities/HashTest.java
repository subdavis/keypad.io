package utilities;

public class HashTest {
		public static void main(String[] args){
			for (double i=0; i<456976; i++){
				for (double j=0; j<456976; j++){
					Security.makeHash("123456asdfghjk");
				}
				System.out.println(i);
			}
		System.out.println("Done");
		}
}
