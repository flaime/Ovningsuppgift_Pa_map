package övar_på_att_testa_packet;

import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

class Node{
    String namn;
    int nr;
    Node left, right;

    Node(String namn, int nr){
	this.namn = namn;
	this.nr = nr;
    }

    public String toString(){
	return namn + " " + nr;
    }
} // Node

class Tree{
    private Node root = null;

    private Node add(Node where, Node ny){
	if (where == null)
	    where = ny;
	else if (where.nr > ny.nr)
	    where.left = add(where.left, ny);
	else if (where.nr < ny.nr)
	    where.right = add(where.right, ny);
	return where;
    }

    public void add(Node ny){
	root = add(root, ny);
    }
    
     public int size(){
    	 size = 0;
    	 size(root);
    	 return size;
     }
     
     private int size;
     private void size(Node nodAttUtgåFrån){
    	 if(nodAttUtgåFrån != null){
    		 size++;
    		 size(nodAttUtgåFrån.left);
    		 size(nodAttUtgåFrån.right);
    	 }
     }

    public void print(){
	print(root );// , 0);
    }

    private void print(Node where){
	if (where != null){
	    print(where.right);
	    System.out.println(where);
	    print(where.left);
	}
    }
    
    public int height() {
		return height(root, 0);
	}
    
    private int height(Node nodAttUtgåFråNode, int höjd) {
		if (nodAttUtgåFråNode != null) {
			höjd++;
			int höjdVänster = height(nodAttUtgåFråNode.left,höjd);
			int höjdHöger = height(nodAttUtgåFråNode.right, höjd);
			
			if(höjdVänster >= höjdHöger){
				return höjdVänster;
			}
			else if(höjdHöger >= höjdVänster){
				return höjdHöger;
			}
			
		}
		return höjd;
	}
    
    public void printTree() {
    	rader = new ArrayList<ArrayList<String>>();
		printTree(root, 0);
		for (ArrayList<String> al : rader) {
			System.out.println(al.toString());
//			for(String s : al){
//				System.out.println(s);
//			}
		}
		System.out.println(rader.size());
	}
    
    String trädet;
    ArrayList<ArrayList<String>> rader;
    private void printTree(Node nodAttUtgåFråNode, int nivå) {
    	if (nodAttUtgåFråNode != null) {
    		if(rader.size() > nivå){
//    			System.out.println(rader.size()+" >= "+ nivå);
    			rader.get(nivå).add(nodAttUtgåFråNode.namn);
    		}
    		else {
//    			System.out.println(rader.size()+"  "+ nivå);
    			ArrayList<String> tillfälig = new ArrayList<String>();
    			tillfälig.add(nodAttUtgåFråNode.namn);
				rader.add(tillfälig);
			}
    		nivå++;
    		printTree(nodAttUtgåFråNode.left, nivå);
    		printTree(nodAttUtgåFråNode.right, nivå);
		}else {
			if(rader.size() > nivå){
//    			System.out.println(rader.size()+" >= "+ nivå);
    			rader.get(nivå).add("_______");
    		}
    		else {
//    			System.out.println(rader.size()+"  "+ nivå);
    			ArrayList<String> tillfälig = new ArrayList<String>();
    			tillfälig.add("_______");
				rader.add(tillfälig);
			}
		}
    	
    	//här börjar utritandet
    	trädet = nodAttUtgåFråNode.namn                      + trädet;
		
	}
    
    private String[] printTreeNew(Node nodAttUtgåFråNode, int nivå){
    	if(nodAttUtgåFråNode != null){
    		String[] left = printTreeNew(nodAttUtgåFråNode.left, ++nivå);
    		String[] right = printTreeNew(nodAttUtgåFråNode.right, ++nivå);
    		
    		String trädet;
    		if (left[1].length() > right[1].length()) {
				for(int i = 0; i < left[1].length();i++){
					if(i == left.length - 1){
					trädet += "/\\";
				}else {
					trädet += "_";
				}
				}
			}
    		
    	}
    	
    	
    	
    	return "fuck somthing";
    }
    
    
}

class TreeExempel{
    public static void main(String[] args){
	Tree tree = new Tree();
	tree.add(new Node("Stefan", 47));
	tree.add(new Node("Bea", 29));
	tree.add(new Node("Jozef", 73));
	tree.add(new Node("Anna", 17));
	tree.add(new Node("Harald", 61));
	tree.add(new Node("Eskel", 97));
	tree.add(new Node("Mats", 52));
	tree.add(new Node("Tobbe", 67));
	tree.add(new Node("Alex", 85));
	tree.add(new Node("Peter", 103));
	tree.add(new Node("Doris", 80));
//	tree.print();
//	
//	System.out.println("det finns " + tree.size() + " antal noder i trädet.");
//	
//	System.out.println("Höjden på trädet är " + tree.height() + " högt.");
	tree.printTree();
	
    }
}


