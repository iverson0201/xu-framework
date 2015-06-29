package Algorithms.args4.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by xu on 2015/6/26.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;


    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        if (N == a.length)
            resize(2*a.length);
        a[N++] = item;
    }

    private void resize(int capacity) {
        assert capacity > N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item pop(){
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = a[N-1];
        a[N-1] = null;
        if (N > 0 && N == a.length/4)
            resize(a.length/2);
        return item;
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
