// demonstrates AVL tree
import java.io.*;                 // for I/O
import java.lang.Integer;         // for parseInt()
////////////////////////////////////////////////////////////////
class Node
   {
   public int iData;              // data item (key)
   public int height;             // height of node
   public Node left;         // this node's left child
   public Node right;        // this node's right child

   public Node(int id) 			// constructor
      {
      iData = id;
      height = 0;
      left = null;
      right = null;
      }

   }  // end class Node

////////////////////////////////////////////////////////////////

class Tree
   {
   private Node root;             // first node of tree

// -------------------------------------------------------------
   public Tree()                  // constructor
      { root = null; }            // no nodes in tree yet
// -------------------------------------------------------------

   public Node getRoot()
      { return root;}

//--------------------------------------------------------------

   public Node find(int key, Node foo)  // RECURSIVE find node with given key
      {

       if (foo == null)
           return null;
       else
       if (foo.iData == key)
           return foo;
       else
       if (foo.iData < key)
           return find(key, foo.right);
       else
           return find(key, foo.left);

       return null;  // pointless return to satisfy idiot compiler

       }  // end find()

// -------------------------------------------------------

   public int height(Node x)  // return height of tree rooted at x
     {
      if (x == null) return -1;
         else return x.height;
     }

   public Node rotatewithleft(Node c)
   {
     Node p;  // left child of c

     p = c.left;
     c.left = p.right;
     p.right = c;

     c.height = Math.max(height(c.left), height(c.right)) + 1;
     p.height = Math.max(height(p.left), height(p.right)) + 1;

     return p;

   }

   public Node rotatewithright(Node c)
   {

     Node p;  // right child of c

     p = c.right;
     c.right = p.left;
     p.left = c;

     c.height = Math.max(height(c.left), height(c.right)) + 1;
     p.height = Math.max(height(p.left), height(p.right)) + 1;

     return p;

   }

   public Node doublerotatewithleft(Node c)
   {

     Node tmp;

     c.left = rotatewithright(c.left);
     tmp = rotatewithleft(c);

     return tmp;

   }


   public Node doublerotatewithright(Node c)
   {

    Node tmp;

    c.right = rotatewithleft(c.right);
    tmp = rotatewithright(c);

    return tmp;

   }


   public Node avlinsert(Node newNode, Node par)
   {

   Node newpar = par;  // root of subtree par

   if (newNode.iData < par.iData)
   {
     if (par.left == null)
       {

         par.left = newNode;  //attach new node as leaf

       }
     else {

         par.left = avlinsert(newNode, par.left);   // branch left

         if ((height(par.left) - height(par.right)) == 2) {

            if (newNode.iData < par.left.iData) {

              newpar=rotatewithleft(par);

            }
            else {

              newpar=doublerotatewithleft(par);

            } //else
         } //if
      } // else
   } // if

   else if (newNode.iData > par.iData)  // branch right
   {
        if (par.right == null)
       {

         par.right = newNode;   // attach new node as leaf

       }
     else {

           par.right = avlinsert(newNode, par.right);  // branch right

           if ((height(par.right) - height(par.left)) == 2) {

            if (newNode.iData > par.right.iData) {

              newpar=rotatewithright(par);


            } //if
            else {

              newpar=doublerotatewithright(par);

            } //else
           } //if
        } //else
   }  // else if

   else System.out.println("Duplicate Key");

 // Update the height, just in case

   if ((par.left == null) && (par.right != null))
      par.height = par.right.height + 1;
   else if ((par.right == null) && (par.left != null))
      par.height = par.left.height + 1;
   else
      par.height = Math.max(height(par.left), height(par.right)) + 1;

   return newpar; // return new root of this subtree

 }  // end avlinsert

// -------------------------------------------------------------
   public void insert(int id) // Recursive insert
      {
      Node newNode = new Node(id);    // make new node

      if(root==null)
         root = newNode;
      else
         {

          root=avlinsert(newNode, root);

          }
      }  // end insert()

   }  // end class Tree

////////////////////////////////////////////////////////////////
class avl
   {
   public static void main(String[] args) throws IOException
      {

      Tree theTree = new Tree();

      theTree.insert(50);
      theTree.insert(25);
      theTree.insert(75);
      theTree.insert(12);
      theTree.insert(37);
      theTree.insert(43);
      theTree.insert(30);

      theTree.insert(33);
      theTree.insert(87);
      theTree.insert(93);
      theTree.insert(97);


      theTree.find(97, theTree.getRoot());

      }  // end main()

// -------------------------------------------------------------
   public static void putText(String s)
      {
      System.out.print(s);
      System.out.flush();
      }
// -------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
// -------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }

//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class TreeApp