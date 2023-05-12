import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App<T> {
    public static void main(String[] args) throws Exception {
        //1)queue
        /* 
        App<Integer> mq = new App<>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        while(mq.isEmpty() == false){
            System.out.println(mq.dequeue());
        }
        */
        //2) stack
        App<Integer> ms = new App<>();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        while(ms.isEmpty()){
            Integer item = ms.pop();
            if(item == null){
                break;
            }
            System.out.println(item);
        }
    }

    //1) queue : first-in-first-out/first-some-first-served
    private ArrayList<T> queue = new ArrayList<>();
    public void enqueue(T item){
        queue.add(item);
    }
    public T dequeue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    //2) stack : last-in-first-out / first-in-last-out
    private ArrayList<T> stack = new ArrayList<>();
    public void push(T item){
        stack.add(item);
    }
    public T pop(){
        if(stack.isEmpty()){
            return null;
        }
        //한번더 변수에 담아줄 필요 없었음
        //T value = stack.get(stack.size()-1);        
        return stack.remove(stack.size()-1);
    }
}

