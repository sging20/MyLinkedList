public class Node{
  private String data; //data of itself store address, reference to next and previous
  private Node next,prev; //location

public Node(String input){
  data= input;
  next= null;
  prev= null;
}


  public void setNext(Node input){
    next = input;
  }
  public Node getNext(){
    return next;
  }
  public Node getPrev(){
    return prev;
  }
  public void setPrev(Node input){
    prev = input;
  }
  public void setData(String input){
    data= input;
  }
  public String getData(){
    return data;
  }


}
