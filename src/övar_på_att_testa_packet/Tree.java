package övar_på_att_testa_packet;

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
				System.out.println("vänster");
				return höjdVänster;
			}
			else if(höjdHöger >= höjdVänster){
				System.out.println("höger");
				return höjdHöger;
			}
			
		}
		return höjd;
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
	tree.print();
	
	System.out.println("det finns " + tree.size() + " antal noder i trädet.");
	
	System.out.println("Höjden på trädet är " + tree.height() + " högt.");
	
	
    }
}


