import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

// barebones implementation of BST

// Every vertex in this BST is a Java Class
class BSTVertex {
   
      // all these attributes remain public to slightly simplify the code
      public BSTVertex parent, left, right;
      public Team key;
      public int height; // will be used in lecture on AVL
      public int size; // will be used in lecture on AVL
  
   BSTVertex(Team v) { 
        key = v;  
        parent = left = right = null; 
        height = 0; 
        size = 1; }


    public boolean equalsTo(BSTVertex r) {
      return ((this.key.teamID == r.key.teamID));
    }
  }
  
  // This is just a sample implementation
  // There are other ways to implement BST concepts...
  class AVL {
    public BSTVertex root;
  
    public AVL() { root = null; }

    public int size(BSTVertex N) {
      if (N == null) {
        return 0;
      }
      return N.size;
    }
  
    public int height(BSTVertex N) { 
      if (N == null) 
          return -1; 

      return N.height; 
  } 
    public int max(int a , int b) {
        if (a > b) {
          return a;
        } else {
          return b;
        }
    }

    public int rank(Team v) {
      return rank(root, v);
    }

    public int rank(BSTVertex T, Team v) {
      if (T == null) {
        return 0;
      }
      int comp = v.compareTo(T.key);
      if (comp < 0) {
        return rank(T.left,v);
      } else if (comp > 0) {
        return 1 + size(T.left) + rank(T.right,v);    
      } else if (T.key.equalsTo(v)) {
        return size(T.left) + 1;
      }
      return 0;
    }

    public boolean contains(Team v) {
       return search(v) != null; 
      }

    public BSTVertex leftRotate(BSTVertex T) {
     
      BSTVertex w = T.right;
      if (T.right != null) {
      w.parent = T.parent;
      T.parent = w;
      T.right = w.left;
      if (w.left != null) {
        w.left.parent = T;
      }
      w.left = T;
      
      T.height = max(height(T.left), height(T.right)) + 1; 
      w.height = max(height(w.left), height(w.right)) + 1;
      T.size = size(T.left) + size(T.right) + 1; 
      w.size = size(w.left) + size(w.right) + 1;

    }
      return w;
    

    }

    public BSTVertex rightRotate(BSTVertex T) {
      BSTVertex w = T.left;
      if (T.left != null) {
      w.parent = T.parent;
      T.parent = w;
      T.left = w.right;
      if (w.right != null) {
        w.right.parent = T;
      }
      w.right = T;
      T.height = max(height(T.left), height(T.right)) + 1; 
      w.height = max(height(w.left), height(w.right)) + 1;
      T.size = size(T.left) + size(T.right) + 1; 
      w.size = size(w.left) + size(w.right) + 1;
    }
      return w;
    }

    public int getBalance(BSTVertex N) { 
      if (N == null) 
          return 0; 

      return height(N.left) - height(N.right); 
  } 

    

    // public method called to search for a value v. 
    // Return v if it is found in the BST otherwise return -1.
    // Here the assumption is that -1 is never a valid key value.
    public Team search (Team v) {   //need to call search using team v and the same teamID
      BSTVertex res = search(root, v);
      return res == null ? null : res.key;
    }
  
    // helper method to perform search
    public BSTVertex search(BSTVertex T, Team v) {
           if (T == null)  return null;                     // not found
      else if ((T.key.teamID == v.teamID)) return T;                        // found
      else if (T.key.compareTo(v) < 0)  return search(T.right, v);       // search to the right
      else                 return search(T.left, v);        // search to the left
    }
    
    // public method called to find Minimum key value in BST
    public BSTVertex findMin() { return findMin(root); }
  
    // helper method to perform findMin
    // Question: What happens if BST is empty?
    public BSTVertex findMin(BSTVertex T) {
      if (T.left == null) return T;                    // this is the min
      else                return findMin(T.left);           // go to the left
    }
  
    // public method called to find Maximum key value in BST
    public Team findMax() { return findMax(root); }
  
    // helper method to perform findMax
    // Question: Again, what happens if BST is empty?
    public Team findMax(BSTVertex T) {
      if (T.right == null) return T.key;                   // this is the max
      else                 return findMax(T.right);        // go to the right
    }
  
    // public method to find successor to given value v in BST.
    public BSTVertex successor(Team v) { 
      BSTVertex vPos = search(root, v);
      return vPos == null ? null : successor(vPos);
    }
  
    // helper recursive method to find successor to for a given vertex T in BST
    public BSTVertex successor(BSTVertex T) {
      if (T.right != null)                       // this subtree has right subtree
        return findMin(T.right);  // the successor is the minimum of right subtree
      else {
        BSTVertex par = T.parent;
        BSTVertex cur = T;
        // if par(ent) is not root and cur(rent) is its right children
        while ((par != null) && (cur.equalsTo(par.right))) {
          cur = par;                                         // continue moving up
          par = cur.parent;
        }
        return par == null ? null : par;           // this is the successor of T
      }
    }
 ////////////////////////////////////////////////////////////////////////////////////////////////////// 
    // public method to find predecessor to given value v in BST
    public Team predecessor(Team v) { 
      BSTVertex vPos = search(root, v);
      return vPos == null ? null : predecessor(vPos);
    }
  
    // helper recursive method to find predecessor to for a given vertex T in BST
    public Team predecessor(BSTVertex T) {
      if (T.left != null)                         // this subtree has left subtree
        return findMax(T.left);  // the predecessor is the maximum of left subtree
      else {
        BSTVertex par = T.parent;
        BSTVertex cur = T;
        // if par(ent) is not root and cur(rent) is its left children
        while ((par != null) && (cur.equalsTo(par.left))) { 
          cur = par;                                         // continue moving up
          par = cur.parent;
        }
        return par == null ? null : par.key;           // this is the successor of T
      }
    }
  
    // public method called to perform inorder traversal
    public void inorder() { 
      inorder(root);
      System.out.println();
    }
  
    // helper method to perform inorder traversal
    public void inorder(BSTVertex T) {
      if (T == null) return;
      inorder(T.left);                               // recursively go to the left
      System.out.println(T.key);                      // visit this BST node
      inorder(T.right);                             // recursively go to the right
    }

        // public method called to perform preorder traversal
        public void preorder() { 
          preorder(root);
          System.out.println();
        }
      
        // helper method to perform preorder traversal
        public void preorder(BSTVertex T) {
          if (T == null) return;
          System.out.println(T.key);                      // visit this BST node
          inorder(T.left);                               // recursively go to the left
          inorder(T.right);                             // recursively go to the right
        }
  
    // public method called to insert a new key with value v into BST
    public void insert(Team v) { root = insert(root, v); }
  
    // helper recursive method to perform insertion of new vertex into BST
    public BSTVertex insert(BSTVertex T, Team v) {
      if (T == null) return new BSTVertex(v);          // insertion point is found
  
      if (v.compareTo(T.key) > 0) {                                  // search to the right
        T.right = insert(T.right, v);
        T.right.parent = T;
      }
      else if (v.compareTo(T.key) < 0) {                                                 // search to the left
        T.left = insert(T.left, v);
        T.left.parent = T;
      } else if (T.key.teamID == v.teamID) {
        return T;
      }

      T.height = 1 + max(height(T.left),height(T.right));
      T.size = 1 + size(T.left) + size(T.right);

      int balance = getBalance(T);  

      if (balance > 1) {
        int leftBalanceFactor = getBalance(T.left);
        if (leftBalanceFactor < 0) {
          //left right case
          T.left = leftRotate(T.left);
          return rightRotate(T);
        } else {
          //left left case
          return rightRotate(T);
        }
      }

      if (balance < -1) {
        int rightBalanceFactor = getBalance(T.right);
        if (rightBalanceFactor <= 0) {
          //right right case
          return leftRotate(T);
        } else {
          // right left case
          T.right = rightRotate(T.right);
          return leftRotate(T);
        }
      }
  
      return T;                                          // return the updated BST
    }  
  
    // public method to delete a vertex containing key with value v from BST
    public void delete(Team v) { root = delete(root, v); }
  
    // helper recursive method to perform deletion 
    public BSTVertex delete(BSTVertex T, Team v) {
      if (T == null)  return T;              // cannot find the item to be deleted
  
      if (v.compareTo(T.key) > 0)                                    // search to the right
        T.right = delete(T.right, v);
      else if (v.compareTo(T.key) < 0)                               // search to the left
        T.left = delete(T.left, v);
      else {                                            // this is the node to be deleted
        if (T.left == null && T.right == null)                   // this is a leaf
          T = null;                                      // simply erase this node
        else if (T.left == null && T.right != null) {   // only one child at right        
          T.right.parent = T.parent;
          T = T.right;                                                 // bypass T        
        }
        else if (T.left != null && T.right == null) {    // only one child at left        
          T.left.parent = T.parent;
          T = T.left;                                                  // bypass T        
        }
        else {                                 // has two children, find successor
          BSTVertex successorV = successor(v);
          T.key = successorV.key;         // replace this key with the successor's key
          T.right = delete(T.right, successorV.key);   // delete the old successorV
       //   T.left = successorV.left;
        }
      }

      if (T == null) {
      return T;
      }
      T.height = max(height(T.left), height(T.right)) + 1;
      T.size = 1 + size(T.left) + size(T.right);

      int balance = getBalance(T);

      if (balance > 1) {
        int leftBalanceFactor = getBalance(T.left);
        if (leftBalanceFactor < 0) {
          //left right case
          T.left = leftRotate(T.left);
          return rightRotate(T);
        } else {
          //left left case
          return rightRotate(T);
        }
      }

      if (balance < -1) {
        int rightBalanceFactor = getBalance(T.right);
        if (rightBalanceFactor <= 0) {
          //right right case
          return leftRotate(T);
        } else {
          // right left case
          T.right = rightRotate(T.right);
          return leftRotate(T);
        }
      
    }
      
      return T;                                   // return the updated BST
    }
}


class Team implements Comparable<Team> {
    public int teamID;
    public int penalty;
    public int score;
    
    public Team(int teamID, int penalty) {
        this.teamID = teamID;
        this.penalty = penalty;
        this.score = 1;
    }

    public void updateWith(Team t) { // to update the team that is currently inside
        this.penalty += t.penalty;
        this.score += t.score;
    }

    public boolean equalsTo(Team t) {
      return this.teamID == t.teamID && this.penalty == t.penalty && this.score == t.score;
    }

    @Override
    public int compareTo(Team t2) {
        if (this.score != t2.score) {
         return t2.score - this.score;
        } else if (this.penalty != t2.penalty) {
            return this.penalty - t2.penalty;
        } else {
            return this.teamID - t2.teamID;
        }
    }
    
    @Override
    public String toString() {
      return "this is team "+ teamID+" with total penalty at "+penalty+" and score of "+score;
    }

}
  
  public class GCPC {
    public static void main(String[] args) throws Exception {
        FastIO fio = new FastIO();
        Hashtable<Integer, Team> h = new Hashtable<Integer, Team>();
        

       AVL avl = new AVL();                                           // an empty BST
       int numberOfTeams = fio.nextInt();
       int numberOfEvents = fio.nextInt();
       
       for(int i = 0; i < numberOfEvents; i++) {
            int teamNum = fio.nextInt();
            int penalty = fio.nextInt();
            Team team = new Team(teamNum,penalty);
            
            if (h.containsKey(teamNum)){
              Team oldTeam = h.get(teamNum);
              avl.delete(oldTeam);
              team.updateWith(oldTeam);
              avl.insert(team);
              h.remove(teamNum);
              h.put(teamNum,team);
            } else {
            h.put(teamNum,team);
            avl.insert(team);
            }
      //      fio.println("THIS IS THE NEW TEAM CREATED N UPDATED: " + team);
  
         //  avl.inorder();

            if (h.containsKey(1)){
                Team teamToSearch = h.get(1);
                int position = avl.rank(teamToSearch);
                fio.println(position);
              } else {
              // print size of root + 1
              int position = h.size();
              fio.println(position + 1);
              }

            //make new team with teamNum
            // search for teamNum
            // if null --> insert into bst
            // else 
            // update the new team
            // delete the node
            // insert into bst
            // end

            //search team 1
            // if null, print size of root + 1
            // else print rank(team 1)

       }

       
  
    //   // Sample BST as shown in Lecture
    //   T.insert(15);
    //   T.insert(23);
    //   T.insert(6);
    //   T.insert(71);
    //   T.insert(50);
    //   T.insert(4);
    //   T.insert(7);
    //   T.insert(5);
  
    //   System.out.println(T.search(71));         // found, 71
    //   System.out.println(T.search(7));          // found, 7
    //   System.out.println(T.search(22));         // not found, -1
  
    //   System.out.println(T.findMin());          // 4
    //   System.out.println(T.findMax());          // 71
  
    //   System.out.println(T.successor(23));      // 50
    //   System.out.println(T.successor(7));       // 15
    //   System.out.println(T.successor(71));      // -1
    //   System.out.println(T.predecessor(23));    // 15
    //   System.out.println(T.predecessor(7));     // 6
    //   System.out.println(T.predecessor(71));    // 50
  
    //   T.inorder();                              // The BST: 4, 5, 6, 7, 15, 23, 50, 71
  
    //   System.out.println("Deleting 5");
    //   T.delete(5);
    //   System.out.println("Deleting 71");
    //   T.delete(71);
    //   System.out.println("Deleting 15");
    //   T.delete(15);
  
    //   T.inorder();         
  // avl.inorder();                     // The BST: 4, 6, 7, 23, 50
    fio.close();
    }
  }

  
/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

