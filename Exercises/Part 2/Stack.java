import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Stack<E> implements MyCollection<E>, Iterable<E> {

    /**
     * Private Iterator class, used to iterate over the stack
     */
    private class StackIterator implements Iterator<E>{

        //Class Attributes
        private E[] iterStack;
        private int iterTop;
        private int pos;
        
        //Contructor
        public StackIterator(){

            this.iterTop = top;
            this.pos = this.iterTop-1;

            iterStack = (E[]) new Object[this.iterTop];

            for (int i = 0; i < this.iterTop; i++){
                this.iterStack[i] = stack[i];
            }

        }

        public boolean hasNext(){
            return (this.pos > -1);
        }

        public E next() throws NoSuchElementException{

            if (this.iterStack[this.pos] == null){
                throw new NoSuchElementException("No elements left in the stack");
            }
            E next = this.iterStack[this.pos];
            this.pos--;
            return next;
        }

    }

    
    //Class Attributes
    private E[] stack;
    private int top;
    private int length;

    //Contructor
    public Stack(){
        
        this.length = 10;
        this.stack = (E[]) new Object[this.length];
        this.top = 0;


    }

    public void add(E e){

        if (this.top == this.stack.length){
            extendArr();
        }

        this.stack[this.top] = e;

        this.top++;


    }

    private void extendArr(){

        this.length = this.length * 2;
        E[] newArr = (E[]) new Object[this.length];

        for (int i = 0; i < this.top; i++){

            newArr[i] = this.stack[i];

        }

        this.stack = newArr;

    }

    public void clear(){

        for (int i = 0; i < this.top; i++){
            this.stack[i] = null;
        }
        this.top = 0;

    }

    public int size(){
        return this.top;
    }

    public boolean isEmpty(){
        return (this.top == 0);
    }

    public boolean contains(E e){

        int i = 0;
        boolean flag = false;
        while (i < this.top && !flag){
            flag = this.stack[i].equals(e);
            i++;
        }
        return flag;

    }

    public E top(){
        return this.stack[this.top-1];
    }

    public void pop(){

        this.stack[this.top] = null;
        this.top--;

    }

    /**
     * Iterator implementation
     */

    public Iterator<E> iterator() {
        return new StackIterator();
    }


    /**
     * The first element printed is the top
     */
    public String toString(){

        String res = "[";
        int i = this.top-1;
        while (i > 0){
            res = res + this.stack[i] + ", ";
            i--;

        }
    
        res = res + this.stack[i] + "]";
        return res;

    }

    public boolean equals(Object other){

        
        if (!(other instanceof Stack)){
            return false;
        }
        Stack<?> otherStack = (Stack<?>) other;
        if (this.size() != otherStack.size()){
            return false;
        }

        int i = 0;
        boolean flag = true;
        while ( i < this.top && flag){

            flag = this.stack[i] == otherStack.stack[i];
            i++;

        }

        return flag;

    }

    public int hashCode(){
        return Objects.hash(this.stack);
    }

    public Stack<E> copy(){
        Stack<E> cpy = new Stack<>();

        for (int i = 0; i < this.top; i++){
            cpy.add(this.stack[i]);
        }

        return cpy;
    }

    /*
     * Basic testing.
     */
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(1);
        s.add(2);
        System.out.println("Top: " + s.top());
        System.out.println("Size: " + s.size());
        System.out.println("Contains 1: " + s.contains(1));
        System.out.println("Contains 2: " + s.contains(2));
        System.out.println("Contains 4: " + s.contains(4));
        System.out.println("Empty? " + s.isEmpty());
        s.clear();
        System.out.println("Size: " + s.size());
        System.out.println("Empty? " + s.isEmpty());
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        for (Integer i : s){
            System.out.println("Iterating: " + i);
        }
        Stack<Integer> cpy = s.copy();
        System.out.println("cpy == s? "+cpy.equals(s));
        s.pop();
        s.pop();
        System.out.println("cpy == s? "+cpy.equals(s));
        System.out.println("Top: " + s.top());
        System.out.println("Size: " + s.size());
        s.pop();
        System.out.println("Top: " + s.top());
        System.out.println("Size: " + s.size());
    }

}
