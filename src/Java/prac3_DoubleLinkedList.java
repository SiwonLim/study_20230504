package Java;
public class prac3_DoubleLinkedList {
    //3-1) Linked List
    public static void main(String[] args) throws Exception{
        DoubleLinkedList<Integer> d = new DoubleLinkedList<>();
        d.addNode(3);
        d.addNode(6);
        d.addNode(9);        
        if(d.searchFromHead(6) != null){
            System.out.println("found it");
        }else{
            System.out.println("can't find it");
        }
        if(d.searchFormTail(2) != null){
            System.out.println("found it");
        }else{
            System.out.println("can't find it");
        }
        d.insertToFront(6, 5);
        d.insertToFront(5, 4);
        d.insertToBack(6, 7);
        d.insertToBack(7, 8);
        d.insertToBack(100, 101);
        d.printAll();
    }
    private static class DoubleLinkedList<T>{
        public Node<T> head = null;
        public Node<T> tail = null;
        public class Node<T>{
            T data;
            Node<T> prev = null;
            Node<T> next = null;
            public Node(T data){
                this.data = data;
            }
        }
        public void addNode(T data){
            if(this.head == null){
                this.head = new Node<T>(data);
                this.tail = this.head;
            }else{
                Node<T> node = this.head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = new Node<T>(data);
                node.next.prev = node;
                this.tail = node.next;                
            }
        }
        public boolean insertToFront(T existedData, T addData){
            if(this.head == null){
                this.head = new Node<T>(addData);
                this.tail = this.head;
                return true;
            }else if(this.head.data == existedData){
                if(this.head.data == existedData){
                    Node<T> newHead = new Node<T>(addData);
                    newHead.next = this.head;
                    this.head.prev = newHead;
                    this.head = newHead;
                    return true;
                }
            }else{
                Node<T> searchedNode = searchFromHead(existedData);
                if(searchedNode != null){
                    Node<T> prevNode = searchedNode.prev;
                    prevNode.next = new Node<T>(addData);
                    prevNode.next.next = searchedNode;
                    prevNode.next.prev = prevNode;
                    searchedNode.prev = prevNode.next;
                    return true;
                }
            }
            return false;
        }
        public boolean insertToBack(T existedData, T addData){
            if(this.head == null){
                this.head = new Node<T>(addData);
                this.tail = this.head;
                return true;
            }else if(this.head.data == existedData){
                this.head.next = new Node<T>(addData);
                this.head.next.prev = this.head;
                this.setTail();
                return true;
            }else if(this.tail.data == existedData){
                this.tail.next = new Node<T>(addData);
                this.tail.next.prev = this.tail;
                this.tail = this.tail.next;
            }
            else{
                Node<T> searchedNode = this.searchFormTail(existedData);
                if(searchedNode != null){
                    Node<T> nextNode = searchedNode.next;
                    searchedNode.next = new Node<T>(addData);
                    searchedNode.next.next = nextNode;
                    searchedNode.next.next.prev = searchedNode.next;
                    searchedNode.next.prev = searchedNode;
                    setTail();
                    return true;
                }
            }
            return false;
        }
        public void setTail(){
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            this.tail = node;
        }
        public void printAll(){
            if(this.head != null){
                Node<T> node = this.head;
                System.out.println((node.prev == null ? "null" : node.prev.data) + " < " + node.data + " > " + (node.next == null ? "null" : node.next.data));
                while(node.next != null){
                    node = node.next;
                    System.out.println((node.prev == null ? "null" : node.prev.data) + " < " + node.data + " > " + (node.next == null ? "null" : node.next.data));
                }
            }
        }
        public Node<T> searchFromHead(T isData){
            if(this.head == null){
                return null;
            }else{
                Node<T> node = this.head;
                while(node != null){
                    if(node.data == isData){
                        return node;
                    }
                    node = node.next;
                }
            }
            return null;
        }
        public Node<T> searchFormTail(T isData){
            if(this.head == null){
                return null;
            }else{
                Node<T> node = this.tail;
                while(node != null){
                    if(node.data == isData){
                        return node;
                    }
                    node = node.prev;
                }
            }
            return null;
        }
    }
}
