package �var_p�_att_testa_packet;

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
     private void size(Node nodAttUtg�Fr�n){
    	 if(nodAttUtg�Fr�n != null){
    		 size++;
    		 size(nodAttUtg�Fr�n.left);
    		 size(nodAttUtg�Fr�n.right);
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
    
    private int height(Node nodAttUtg�Fr�Node, int h�jd) {
		if (nodAttUtg�Fr�Node != null) {
			h�jd++;
			int h�jdV�nster = height(nodAttUtg�Fr�Node.left,h�jd);
			int h�jdH�ger = height(nodAttUtg�Fr�Node.right, h�jd);
			
			if(h�jdV�nster >= h�jdH�ger){
				return h�jdV�nster;
			}
			else if(h�jdH�ger >= h�jdV�nster){
				return h�jdH�ger;
			}
			
		}
		return h�jd;
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
    
    String tr�det;
    ArrayList<ArrayList<String>> rader;
    private void printTree(Node nodAttUtg�Fr�Node, int niv�) {
    	if (nodAttUtg�Fr�Node != null) {
    		if(rader.size() > niv�){
//    			System.out.println(rader.size()+" >= "+ niv�);
    			rader.get(niv�).add(nodAttUtg�Fr�Node.namn);
    		}
    		else {
//    			System.out.println(rader.size()+"  "+ niv�);
    			ArrayList<String> tillf�lig = new ArrayList<String>();
    			tillf�lig.add(nodAttUtg�Fr�Node.namn);
				rader.add(tillf�lig);
			}
    		niv�++;
    		printTree(nodAttUtg�Fr�Node.left, niv�);
    		printTree(nodAttUtg�Fr�Node.right, niv�);
		}else {
			if(rader.size() > niv�){
//    			System.out.println(rader.size()+" >= "+ niv�);
    			rader.get(niv�).add("_______");
    		}
    		else {
//    			System.out.println(rader.size()+"  "+ niv�);
    			ArrayList<String> tillf�lig = new ArrayList<String>();
    			tillf�lig.add("_______");
				rader.add(tillf�lig);
			}
		}
    	
    	//h�r b�rjar utritandet
    	tr�det = nodAttUtg�Fr�Node.namn                      + tr�det;
		
	}
    
    private String[] printTreeNew(Node nodAttUtg�Fr�Node, int niv�){
    	if(nodAttUtg�Fr�Node != null){
    		String[] left = printTreeNew(nodAttUtg�Fr�Node.left, ++niv�);
    		String[] right = printTreeNew(nodAttUtg�Fr�Node.right, ++niv�);
    		
    		String tr�det;
    		if (left[1].length() > right[1].length()) {
				for(int i = 0; i < left[1].length();i++){
					if(i == left.length - 1){
					tr�det += "/\\";
				}else {
					tr�det += "_";
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
//	System.out.println("det finns " + tree.size() + " antal noder i tr�det.");
//	
//	System.out.println("H�jden p� tr�det �r " + tree.height() + " h�gt.");
	tree.printTree();
	
    }
}


