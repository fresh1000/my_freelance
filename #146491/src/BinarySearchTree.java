import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin()
    {
        if(isEmpty())
            throw new RuntimeException();
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new RuntimeException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element );
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    

    
    private int nodeCount(BinaryNode<AnyType> t)
    {
    	if (t.left == null && t.right == null)
            return 1;
        int left, right;
        if (t.left != null)
            left = nodeCount(t.left);
        else
            left = 0;
        if (t.right != null)
            right = nodeCount(t.right); 
        else 
            right = 0;

        return left+right+1;
    }
    
    private boolean isFullTree(BinaryNode<AnyType> t)
    {
        // if empty tree
        if(t == null)
        return true;
          
        // if leaf node
        if(t.left == null && t.right == null )
            return true;
          
        // if both left and right subtrees are not null
        // the are full
        if((t.left!=null) && (t.right!=null))
            return (isFullTree(t.left) && isFullTree(t.right));
          
        // if none work
        return false;
    }
    
    private boolean compareStructure(BinaryNode<AnyType> n1, BinaryNode<AnyType> n2) //maybe equals
    {
		if (n1 == null && n2 == null)
			return true;
		if ((n1 == null && n2 != null) || (n2 == null && n1 != null))
			return false;
		return compareStructure(n1.left, n2.left) & compareStructure(n1.right, n2.right);
    }
    
    private boolean equals(BinaryNode<AnyType> n1, BinaryNode<AnyType> n2) //maybe equals
    {
        if (n1 == null && n2 == null)
            return true;  // i.e. both null
        //if (n1.element != n2.element)
         //   return false;
        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }
    
    private BinaryNode<AnyType> copy(BinaryNode<AnyType> t)
    {
       	if(t == null)
    		return t;
    	else{
    		BinaryNode<AnyType> newTree = new BinaryNode<AnyType>(null);
    		newTree.element = t.element;
    		newTree.left = t.left;
    		newTree.right = t.right;
    		return newTree;
    	}
    }
    
    private BinaryNode<AnyType> mirror(BinaryNode<AnyType> t)
    {
		if(t != null)
		{
			BinaryNode<AnyType> z = t.left;
			t.left = t.right;
			t.right = z;
			mirror(t.right);
			mirror(t.left);
		}
    	return t;
    }
    
    private boolean isMirrors(BinaryNode<AnyType> t, BinaryNode<AnyType> treeNew)
    {
		if(t == null && treeNew == null)
			return true;
		if(t == null || treeNew == null)
			return false;
		return (t.element == treeNew.element) && isMirrors(t.left, treeNew.right) && isMirrors(t.right, treeNew.left);
    }
    
    public void levelOrderNaiveApproach(BinaryNode<AnyType> root){
		int h = height(root);
		for(int i=1;i<=h;i++){
 			printLevels(root,i);
 			System.out.println("");
 		}
 	}
    
 	public void printLevels(BinaryNode<AnyType> root, int h){
 		if(root==null) return;
 		if(h==1) System.out.print(" " + root.element);
 		else{
 			printLevels(root.left,h-1);
 			printLevels(root.right,h-1);
 		} 	
    }
 	
 	public void levelOrderQueue(BinaryNode<AnyType> root){
 		Queue q = new LinkedList();
 		int levelNodes =0; 
		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
 				BinaryNode<AnyType> n = (BinaryNode<AnyType>) q.remove();
				System.out.print(" " + n.element);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
 	}
 	
    private BinaryNode<AnyType> rotateLeft(BinaryNode<AnyType> t)
    {
    	BinaryNode<AnyType> newRootLeft = t.right;
    	t.right = newRootLeft.left;
    	newRootLeft.left = t;
    	return newRootLeft;
    	
    }
    
    private BinaryNode<AnyType> rotateRight(BinaryNode<AnyType> t)
    {
    	BinaryNode<AnyType> newRootRight = t.left;
    	t.left = newRootRight.right;
    	newRootRight.right = t;
    	return newRootRight;
    	
    }
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }

      /** The tree root. */
    private BinaryNode<AnyType> root;
    
        // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<>( );
        BinarySearchTree<Integer> newTree = new BinarySearchTree<>();
        final int NUMS = 4000;
        final int GAP  =   37;
        
        final int NUMS2 = 4000;
        final int GAP2  =   37;

        System.out.println( "Checking... (no more output means success)" );
        
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );
        
        for( int i = GAP2; i != 0; i = ( i + GAP2 ) % NUMS2 )
             newTree.insert( i );
        
        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );
        
        for( int i = 1; i < NUMS2; i+= 2 )
            newTree.remove( i );
        
        if( NUMS < 40 )
            t.printTree( );
        if( t.findMin() != 2 || t.findMax() != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
             if( !t.contains( i ) )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }
        
        int c = t.nodeCount(t.root);
        System.out.println(c);
        
        boolean full = t.isFullTree(t.root);
        System.out.println(full);
        
        boolean compare = t.compareStructure(t.root, newTree.root);
        System.out.println(compare);
        
        boolean equal = t.equals(t.root, newTree.root);
        System.out.println(equal);
        
        //t.levelOrderNaiveApproach(t.root);
        
        //t.levelOrderNaiveApproach(t.root);
        
        boolean isMirr = t.isMirrors(t.root, newTree.root);
        System.out.println(isMirr);
        
        t.levelOrderNaiveApproach(t.root);//printLevels
        t.mirror(t.root);
        t.levelOrderNaiveApproach(t.root);//printLevels
        
        
        //t.rotateLeft(t.root);
        //t.rotateRight(t.root);
        //t.levelOrderNaiveApproach(t.root);
        //BinaryNode<Integer> as = t.copy(t.root);
    }
}