package Algorithms.args4.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xu on 2015/6/26.
 * 先进先出 FIFO 队列
 * 优先服务等待最久的人
 */
public class Queue<Item> implements Iterable<Item> {

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    private int N;
    private Node<Item> first;
    private Node<Item> last;

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public Item peek(){
        if (!isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * 入队
     * @param item
     */
    public void enqueue(Item item){
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    /**
     * 出列
     * @return
     */
    public Item dequeue(){
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty())
            last = null;
        return item;
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            this.current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
