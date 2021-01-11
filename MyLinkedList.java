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

  public String set(int index, String value){
    if(index > size() || index < 0){
      throw new IndexOutOfBoundsException("Index" + index + "is out of bounds");
    }
    else{
      String ret = getNthNode(index+1).getData();
      getNthNode(index+1).setData(value);
      return ret;
    }
  }

public void extend(MyLinkedList other){
  if((size() == 0 && other.size() == 0)){ //both are empty
    this.start = null;
    this.end = null;
  }
  if((size() == 0 && other.size() == 1)){ // first is empty other is 1
    this.start = other.start;
    this.end = other.end;
    this.size++;
    other.size= 0;
    other.start= null;
    other.end= null;
}
  if(size()!=0 && other.size() ==0){
    this.start= this.start;
    this.end= this.end;
  }
  if(size()==0 && other.size() !=0){
    this.start= other.start;
    this.end= other.end;
    this.size = other.size();
    other.start= null;
    other.end= null;
    other.size = 0;
  }
  if(size()==1 && other.size() == 1){
    this.end.setNext(other.end);
    other.end.setPrev(this.start);
    other.start= null;
    other.end = null;
    other.size = 0;
    this.end = other.start;
    size++;
  }
  if(size()!=0 && other.size()!= 0){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    this.end= other.end;
    other.end= null;
    other.start= null;
    this.size += other.size();
    other.size = 0;
  }
}

  public String toStringReversed(){
    Node current = end;
    if(size()== 0) return "[]";
    String ret= "[";
    while(current.getPrev() != null){
      ret += current.getData() + ", ";
      current = current.getPrev();
    }
    return ret + current.getData() + "]";
  }


  public String remove(int index){
    if(index>= size() || index <0){
      throw new IndexOutOfBoundsException("Index" + index +"is out of bounds");
    }
    if(size() == 1){
      String ret= start.getData();
      start= null;
      end= null;
      size--;
      return ret;
    }
    else if(index== size()-1){
      String ret= end.getData();
      end.getPrev().setNext(null);
      size--;
      end= end.getPrev();
      return ret;
    }
    else if(index== 0){
      String ret= start.getData();
      start.getNext().setPrev(null);
      start = start.getNext();
      size--;
      return ret;
    }
    else{
      Node current= getNthNode(index+1);
      getNthNode(index+1).getPrev().setNext(current.getNext());
      getNthNode(index+1).getNext().setPrev(current.getPrev());
      size--;
      String ret= current.getData();
      return ret;
    }
  }

}
