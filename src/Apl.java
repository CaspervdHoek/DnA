public class Apl {

	public static void main(String[] args){
		RedTrie rt = new RedTrie();
		
		rt.insert("ball", null);
		rt.insert("bat", null);
		rt.insert("sex", null);
		rt.insert("sense", null);
		
		System.out.println(rt.toDOTString());
	}

}
