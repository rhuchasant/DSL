package bst;
import java.util.*;

class node{
	String keyword, meaning;
	node left,right;
	
	public node(String keyword,String meaning) {
		this.left=null;
		this.right=null;
		this.keyword=keyword;
		this.meaning=meaning;
		
	}
	
}
class binary{
	Scanner sc=new Scanner(System.in);
	node root,ptr;
	
	
	public binary() {
		root=null;
	}
	
	void create() {
		System.out.println("ENTER KEYWORD");
		String keyword=sc.next();
		System.out.println("ENTER MEANING");
		String meaning=sc.next();
		node temp=new node(keyword, meaning);
		if(root==null) {
			root=temp;
		}
		else {
			ptr = root;
			while(ptr!=null) {
				if(temp.keyword.compareTo(ptr.keyword)<0) {
					if(ptr.left==null) {
						ptr.left=temp;
						break;
					}
					else {
						ptr=ptr.left;
					}
				}
				else {
					if(temp.keyword.compareTo(ptr.keyword)>0) {
						if(ptr.right==null) {
							ptr.right=temp;
							break;
						}
						else {
							ptr=ptr.right;
						}
					}
				
				
			}
		}
		}
		System.out.println("Do you want to add more words to the dictionary? ENTER Y FOR YES, N FOR NO");
		String ans=sc.next();
		if(ans.equalsIgnoreCase("Y")) {
			create();
		}
		else {
			return;
		}
	}
	void display(node lroot) {
		if(lroot!=null) {
		display(lroot.left);
		System.out.println(lroot.keyword+ ":" +lroot.meaning);
		display(lroot.right);
		}
		else {
			return;
		}
	}
	void search() {
		int flag=0;
		System.out.println("ENTER KEYWORD YOU WANT TO SEARCH");
		String key=sc.next();
		ptr=root;
		while(ptr!=null) {
			if(key.compareTo(ptr.keyword)<0) {
				ptr=ptr.left;
				break;
			}
			else if(key.compareTo(ptr.keyword)>0) {
				ptr=ptr.right;
				break;
			}
			else {
				flag=1;
				break;
			}
			
		
		}
		if (flag==1) {
			System.out.println("Keyword found");
			System.out.println(ptr.keyword+ ":" +ptr.meaning);
		}
	}
	void update() {
		int flag=0;
		System.out.println("Enter word to be updated");
		String key=sc.next();
		ptr=root;
		while(ptr!=null) {
			if(key.compareTo(ptr.keyword)<0) {
				ptr=ptr.left;
				break;
			}
			else if(key.compareTo(ptr.keyword)>0) {
				ptr=ptr.right;
				
			}
			else {
				flag=1;
				break;
			}
			
			
		}
		if(flag==1) {
			System.out.println("Enter the new updated meaning");
			String key1=sc.next();
			ptr.meaning=key1;
			System.out.println(ptr.keyword+ ":" +ptr.meaning);
		}
		else {
			System.out.println("No data found");
		}
	}
	public void delete(){
        System.out.print("Enter the word to delete: ");
        String key = sc.nextLine();
        this.root = delete(this.root, key);
    }

    private node delete(node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (key.compareTo(root.keyword) < 0)
            root.left = delete(root.left, key);
        else if (key.compareTo(root.keyword) > 0)
            root.right = delete(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            node temp = getSuccessor(root.right);
            root.keyword = temp.keyword;
            root.meaning = temp.meaning;

            // Delete the inorder successor
            root.right = delete(root.right, root.keyword);
        }
        return root;
    }

    private node getSuccessor(node node)
    {
        String keyword = node.keyword;
        String meaning = node.meaning;

        while (node.left != null)
        {
            keyword = node.left.keyword;
            meaning = node.left.meaning;
            node = node.left;
        }
        return new node(keyword, meaning);
    }
	}


public class Main {
	

	public static void main(String args[]) {

	binary b=new binary();
	Scanner sc=new Scanner(System.in);
	int ch;
	do {
		System.out.println("MENU:");
		System.out.println("1. CREATE A DICTIONARY");
		System.out.println("2. DISPLAY");
		System.out.println("3. SEARCH");
		System.out.println("4. UPDATE");
		System.out.println("5. DELETE");
		System.out.println("6. EXIT");
		System.out.println("ENTER YOUR CHOICE");
		ch=sc.nextInt();
		if (ch==0) {
			break;
		}
		switch(ch) {
		case 1:
		b.create();
		break;
		case 2:
		b.display(b.root);
		break;
		case 3:
		b.search();
		break;
		case 4:
		b.update();
		break;
		case 5:
		b.delete();
		break;
		default:
		System.out.println("INVALID CHOICE");

		}
	}while(ch!=7);
}
}
