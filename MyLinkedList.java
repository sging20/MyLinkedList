public class MyLinkedList{
  private int size; // total amount(?)
  private Node start,end; //adding to front, not linear, constant time, new node point to head, head point to new front

  public MyLinkedList(){
  size= 0;
  start= null;
  end= null;
}

 public int size(){
   return size;
 }

 public String toString(){
   String ret = "[";
   Node counter= start;
   if(size==0){
     return "[]";
   }
   while(counter.getNext() != null){
     ret+= counter.getValue() + ", ";
     counter = counter.getNext();
   }
   return ret + counter.getValue() + "]";
}

public boolean add(String input){
  Node newNode= new Node(input);
  if(size==0){
    start= input;
    end= input;
    size++;
  }
  else{
    newNode.setPrev(end);
    newNode.getPrev().setNext(newNode);
    end= newNode;
    size+=1;
    return true;
  }
      return true;
}


  }

}
