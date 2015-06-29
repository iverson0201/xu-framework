package Algorithms.args4.set;

import stdlib.StdIn;
import stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xu on 2015/6/26.
 * 背包
 */
public class Bag<Item> implements Iterable<Item> {

    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    private int N;
    private Node<Item> first;

    public Bag() {
        first = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void add(Item item){
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
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

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            bag.add(item);
        }
        StdOut.println("size of bag = " + bag.size());
        for (String s : bag)
            StdOut.println(s);

    }
}
