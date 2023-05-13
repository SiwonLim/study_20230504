package Java;

public class prac3_LinkedList2 {
    public static void main(String[] args) throws Exception{
        SingleLinkedList2<Integer> s = new SingleLinkedList2<>();
        s.addNode(3);
        s.addNode(6);
        s.addNodeInside(4, 3);
        s.addNode(9);
        s.addNodeInside(10, 9);
        s.printAll();

        s.delNode(3);
        s.delNode(6);
        s.delNode(10);
        System.out.println("after delete....");
        s.printAll();
    }

    private static class SingleLinkedList2<T>{
        Node<T> head = null;
        public class Node<T>{
            T data;
            Node<T> next = null;
            public Node(T data){
                this.data = data;
            }
        }
        public void addNode(T data){
            if(head == null){
                head = new Node<T>(data);
            }else{
                Node<T> node = head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = new Node<T>(data);
            }
        }
        //데이터를 중간에 삽입
        public void addNodeInside(T data, T isData){
            //나의 data를, isData뒤에 추가해줘
            Node<T> searchedNode = this.search(isData);
            if(searchedNode == null){
                this.addNode(data);
            }else{
                Node<T> nextNode = searchedNode.next;
                searchedNode.next = new Node<T>(data);
                searchedNode.next.next = nextNode;
            }
        }
        public Node<T> search(T data){
            if(this.head == null){
                return null;
            }else{
                Node <T> node = this.head;
                while(node != null){
                    if(node.data == data){
                        return node;
                    }
                    node = node.next;
                }
            }
            return null;
        }
        //중간 데이터를 삭제
        public boolean delNode(T isData){
            Node<T> node = this.head;
            if(node == null){
                return false;
            }else{
                if(node.data == isData){
                    this.head = this.head.next;
                    return true;
                }else{
                    while(node.next != null){
                        if(node.next.data == isData){
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
            return false;
        }

        public void printAll(){
            if(head != null){
                Node<T> node = head;
                System.out.println("head : " + node.data);
                while(node.next != null){
                    node = node.next;
                    System.out.println(node.data);
                }
            }
        }
    }
}
