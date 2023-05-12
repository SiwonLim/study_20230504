public class prac3_LinkedList {
    //3-1) Linked List
    public static void main(String[] args) throws Exception{
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.printAll();
    }
    private static class SingleLinkedList<T>{
        public Node<T> head = null;
        public class Node<T>{
            T data;
            Node<T> next = null;
            public Node(T data){
                this.data = data;
            }
        }
        public void addNode(T data){
            if(head == null){
                head = new Node(data);
            }else{
                Node<T> node = head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = new Node<T>(data);
            }
        }
        public void printAll(){
            if(head != null){
                Node<T> node = this.head;
                System.out.println("head : " + node.data);
                while(node.next != null){
                    node = node.next;
                    System.out.println(node.data);
                }
            }
        }
    }
}
