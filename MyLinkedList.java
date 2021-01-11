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
   if(size()== 0) return "[]";
   if(size() == 1) return "[" + start.getData() + "]";
   while(counter.getNext() != null){
     ret+= counter.getData() + ", ";
     counter = counter.getNext();
   }
   return ret + counter.getData() + "]";
}

public boolean add(String input){
  Node newNode= new Node(input);
  if(size==0){
    start= newNode;
    end= newNode;
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


public void add(int index, String input){
  if(index < 0 || index> size()){
    throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
  }
  Node newNode = new Node(input);
if(size() == 0){
  newNode.setNext(start);
  start= newNode;
  end= newNode;
  size++;
  }
  else if (index == size()){
    add(input);
  }
  else if (index == 0){
    start.setPrev(newNode);
    newNode.setNext(start);
    start = newNode;
    size++;
  }
  else{
    newNode.setNext(getNthNode(index+1));
    newNode.setPrev(getNthNode(index));
    newNode.getNext().setPrev(newNode);
    newNode.getPrev().setNext(newNode);
    size+=1;
  }
}
  private Node getNthNode(int n){
    Node counter= start;
    for(int i=1; i< n; i++){
      counter= counter.getNext();
    }
    return counter;
  }

  public String get(int index){
    if(index>= size() || index< 0){
      throw new IndexOutOfBoundsException("Index"+ index + "is out of bounds");
    }
    if(index == 0) return start.getData();
    if(index == size()) return end.getData();
    else{
      return getNthNode(index+1).getData();
    }
  }

}
