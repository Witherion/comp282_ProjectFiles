package comp282_ProjectFiles;

public class Driver{
	public static void main(String[] args) 
	{
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		
		System.out.println("Welcome to my Project 1 demo:");
		
		tree.insert("dog");
		tree.insert("cat");
		tree.insert("pig");
		tree.insert("horse");
		
		System.out.println("The current tree height is: " + tree.treeHeight());
		System.out.println("The pig is present: " + tree.find("pig"));
		System.out.println("Pig status is: " + tree.status("pig"));
		System.out.println("pig is in a leaf node: "+ tree.isLeaf("pig"));
		System.out.println("Pig height is: " + tree.itemHeight("pig"));
		System.out.println("horse is in a leaf node: " + tree.isLeaf("horse"));
		System.out.println("horse height is: " + tree.itemHeight("horse"));
		
		tree.delete("pig");
		
		System.out.println("pig is present: " + tree.find("pig"));
		
		tree.insert("mango");
		tree.insert("apple");
		tree.insert("mangrove");
		tree.insert("igloo");
		
		tree.display();
		
		System.out.println("BST height :" + tree.treeHeight());
		System.out.println("horse height is: " + tree.itemHeight("horse"));
		System.out.println("horse's left subtree height is: " + tree.leftHeight("horse"));
		System.out.println("horse's right subtree height is: " + tree.rightHeight("horse"));
	}
}
