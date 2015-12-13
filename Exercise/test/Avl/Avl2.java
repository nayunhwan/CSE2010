package AVL;

public class AVL_Tree {
   public Node root = null;

   public class Node{
      public Node rch;
      public Node lch;
      public int key;
      public Node parent;

      Node(int key){
         this.key = key;
         this.rch = new Node();
         this.lch = new Node();
         rch.parent = this;
         lch.parent = this;
         //생성자.
      }
      Node(){
   
      }
      Node(Node p){
         this.parent = p;
      }
   }

   public boolean isExternal(Node n){
      if(n.rch == null && n.lch == null){
         return true;
      }else{
         return false; // null 대신 마지막 노드를 external node로 판별해주는 함수.
      }
   }
   
   public int Bigger(int a, int b){ //큰값을 반환하는 함수
      if(a>b)
         return a;
      else
         return b;
   }
   
   private int height(Node n){ // 높이를 계산하는 함수.
      if(isExternal(n))
         return 0;
      else{
         int h = 0; //초기값 0
         h = Bigger(h, height(n.lch));
         h = Bigger(h, height(n.rch));
         return h+1;
      }
      
   }

   void insert(int key){
      Node n = new Node(key);
      
      if(root == null){
         root = n;
      }else{
         Node i = root;
         while(true){ // insert 할 노드 탐색.
            if(isExternal(i)){
               n.parent = i.parent;
               if(i.parent.lch == i) 
                  i.parent.lch = n;
               else
                  i.parent.rch = n;
                  
               i = n;
               break;
            }else{
               if(key < i.key){
                  i = i.lch;
               }else{
                  i = i.rch;
               }
            }
         }
         rotation(n.parent);
      }
   }
   void rotation(Node n){
      int lh = height(n.lch);
      int rh = height(n.rch);   
      if(lh-rh>1){ //LX Rotation
         lh = height(n.lch.lch);
         rh = height(n.lch.rch);
            if(lh>rh){ // LL Rotation
               Node temp = n.lch;
               temp.parent = n.parent;
               if(n == root)
                  root = temp;
               else if(n.parent.lch == n)
                  n.parent.lch = temp;
               else
                  n.parent.rch = temp;
               
               n.lch = temp.rch;
               temp.rch.parent = n;
               
               temp.rch = n;
               n.parent = temp;
            }else{ // LR Rotation을 LL로테이션으로 바꾼다.
            Node temp = n.lch;
            
            n.lch = temp.rch;
            temp.rch.parent = n;
            
            temp.rch=temp.rch.lch;
            temp.rch.parent = temp;
            
            temp.parent = n.lch;
            n.lch.lch = temp;
            
            rotation(n);
         }
      }else if(rh-lh>1){
         lh = height(n.rch.lch);
         rh = height(n.rch.rch);
         if(rh>lh){//RR Rotation
            Node temp = n.rch;
            temp.parent = n.parent;
            if(n == root)
               root = temp;
            else if(n.parent.lch == n)
               n.parent.lch = temp;
            else
               n.parent.rch = temp;
            
            n.rch = temp.lch;
            temp.lch.parent = n;
            
            temp.lch = n;
            n.parent = temp;
         }else{ //RL Rotation 을 RR로 바꿔준다.
            Node temp = n.rch;
            
            n.rch = temp.lch;
            temp.lch.parent = n;
            
            temp.lch=temp.lch.rch;
            temp.lch.parent = temp;
            
            temp.parent = n.rch;
            n.rch.rch = temp;
            
            rotation(n);
         }
      }else{ // 위 두 조건을 만족하지 않을 시, 상위 노드를 불러온다.
         if(n==root)
            return ;
         rotation(n.parent);//(재귀)
      }
   }
      
   void delete(int key){
         Node i = root;
         
         while(key != i.key){
            if(key < i.key){
               if(i.lch != null){
               i = i.lch;
               }
               else{
                  System.out.println("지울 값이 없습니다.");
                  break;
               }
            }else{
               if(i.rch != null)
               i = i.rch;   
               else{
                  System.out.println("지울 값이 없습니다.");
                  break;
               }
            }
         } // search 메소드와 같은 방식으로 노드 탐색.
         if(key == i.key){
            if(!isExternal(i.lch)  && !isExternal(i.rch) ){
               Node temp = i.lch;
               
               if(temp.rch == null){
                  i.key = temp.key;
                  i.parent.lch = temp.lch;
               }
               else{
                  while(temp.rch != null){
                     i.parent = temp;
                     temp = temp.rch;
                  }
                  i.key = temp.key;
                  i.parent.rch =temp.lch;
               }
               rotation(temp.parent);
            } 
            // 노드가 왼쪽과 오른쪽 모두에 존재할 경우.
            else if( !isExternal(i.lch) && isExternal(i.rch)){
               Node temp = i.lch;
               
               if(isExternal(temp.rch)){
                  i.key = temp.key;
                  i.parent.lch = temp.lch;
               }
               else{
                  while(isExternal(temp.rch)){
                     i.parent= temp;
                     temp = temp.rch;
                  }
                  i.key = temp.key;
                  i.parent.rch =temp.lch;
                      
               }
               rotation(temp.parent);
            } 
            // 노드가 왼쪽에만 존재할경우(왼쪽 가장 큰 노드).
            else if(isExternal(i.lch) && !isExternal( i.rch)){
               Node temp = i.lch;
               
               if(isExternal(temp.lch)){
                  i.key = temp.key;
                  i.parent.rch = temp.rch;
               }
               else{
                  while( !isExternal(temp.lch)){
                     i.parent =temp;
                     temp = temp.lch;
                  }
                  i.key = temp.key;
                  i.parent.lch = temp.rch;
               }
               rotation(temp.parent);
            }
            // 노드가 오른쪽에만 존재할 경우(오른쪽 가장 작은노드).
            else{
               if(i!=root &&i == i.parent.lch)
                  i.parent.lch = new Node(i.parent);
               else if(i!= root){
                  i.parent.rch = new Node(i.parent);
               }
               if(i==root) return ;
               rotation(i.parent);
            }
         }
            // leaf 노드인 경우.
         }
      
   Boolean search(int key){
      Node i = root;
      if(root == null){
         System.out.println("없다.");
         return false;
      }else{
         while(key != i.key){
            if(key < i.key){
               if(i.lch == null){
                  System.out.println("없다.");
                  return false;
               }else{
                  i = i.lch;
               }
            }else{
               if(i.rch == null){
                  System.out.println("없다.");
                  return false;
               }
               else{
                  i = i.rch;
               }
            }
            System.out.println("찾았다.");
         }return true;
      }

   }
   void print_preorder(){
      rec_preorder(root);
      System.out.println();
   }
   void rec_preorder(Node n){
      if(!isExternal(n)){
         System.out.print(n.key +" ");
         rec_preorder(n.lch);
         rec_preorder(n.rch);
      } // print 후 재귀
   }
   void print_preorder_diff(){
      rec_preorder_diff(root);
      System.out.println();
   }
   void rec_preorder_diff(Node n){
      if(!isExternal(n)){
         System.out.print(n.key+"("+height(n.lch)+","+height(n.rch)+")" +" ");
         rec_preorder_diff(n.lch);
         rec_preorder_diff(n.rch);
      } // print 후 재귀
   }

}