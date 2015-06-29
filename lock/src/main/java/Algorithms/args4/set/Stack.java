package Algorithms.args4.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xu on 2015/6/26.
 * 下压栈，后进先出 LIFO
 */
public class Stack<Item> implements Iterable<Item> {

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    private int N;
    private Node<Item> first;

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    /**
     * 压入
     * @param item
     */
    public void push(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    /**
     * 弹出
     * @return
     */
    public Item pop(){
        if (isEmpty())
            throw new NoSuchElementException("stack underlow");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek(){
        if (isEmpty())
            throw new NoSuchElementException("stack underlow");
        return first.item;
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

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

}
