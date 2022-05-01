/**
 * Name:Nuojinli Xu
 * ID:A16826845
 * Email:n1xu@ucsd.edu
 * Sources used: lectrue slides
 * 
 * This file contains MyArrayList class which implements 
 * Mylist interface
 */

 /**
  * This class is my implementation of MyArraylist containing 
  constructors, expand capacity method, get capacity method, insert,
  append,prepend, get,set and remove.
  */
public class MyArrayList<E> implements MyList<E> {
    public static final int DEFAULT_CAPACITY = 5;
    Object[] data;
    int size;
   
    //this is a default constructor that set data to default capacity
    //and set size to zero
    public MyArrayList(){
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    /**
     * This constructor checks the input initialCapacity
     * and set the size to zero and data to initialCapacity 
     * if the input is equal or larger than zero
     * @param initialCapacity
     * @throws IllegalArgumentException
     */
    public MyArrayList(int initialCapacity) throws IllegalArgumentException{
        if(initialCapacity >= 0){
            this.data = new Object[initialCapacity];
            this.size = 0;
        }
        else{
            throw new IllegalArgumentException();
        }
       
    }
    /**
     * This constructor performs a shallow copy from arr to data
     * and set the size to the length of the input array
     * @param arr
     */
    public MyArrayList(E[] arr){
        this();
        if(arr != null){
            this.data = arr;
            this.size = arr.length;
            System.out.println();
        }
    }

    /**
     * This method expand the capacity of Array according to 
     * the requiredCapacity and throws IllegalArgumentException
     * is the requiredcapacity is strictly less than the initial capacity
     */
    public void expandCapacity(int requiredCapacity) throws IllegalArgumentException{
        if(requiredCapacity < data.length){
            throw new IllegalArgumentException();
        }
        int capacity = data.length;
        if(capacity == 0){
            capacity = DEFAULT_CAPACITY;
        }
        else{
            capacity *= 2;
        }
        if(capacity < requiredCapacity){
            capacity = requiredCapacity;
        }
        Object[] temp = new Object[capacity];
        for(int i = 0; i < this.size; i++){
            temp[i] = this.data[i];
        }
        this.data = temp;

    }
    //this method returns the capacity of data
    public int getCapacity(){
        return this.data.length;
    }
    /**
     * This method insert an element at a specific index
     * and throws IndexOutOfBoundsException when the index
     * is strictly less than zero or larger than the size
     * of data
     */
    public void insert(int index, E element){
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        if(this.size == this.data.length){
            this.expandCapacity(this.size+1);
        }
        for(int i = this.size; i > index;i--){
            this.data[i] = this.data[i-1];
        }
        this.data[index] = element;
        this.size++;
    }
    //this method insert an element at the begining of the data
    public void append(E element){
        this.insert(this.size, element);
    }
    //this method insert an element at the end of the data
    public void prepend(E element){
        this.insert(0, element);
    }
    /**
     * this method returns the element at the required index
      * and throws IndexOutOfBoundsException when the index
     * is strictly less than zero or larger or equal than the size
     * of data
     */
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        return (E)this.data[index];

    }
    /**
     * this method changes the element at the required index
     * and throws IndexOutOfBoundsException when the index
     * is strictly less than zero or larger or equal than the size
     * of data
     */
    @SuppressWarnings("unchecked")
    public E set(int index,E element) throws IndexOutOfBoundsException{
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Object temp = this.data[index];
        this.data[index] = element;
        return (E)temp;
    }
    @SuppressWarnings("unchecked")
    /**
     * this method remove the element at the required index
      * and throws IndexOutOfBoundsException when the index
     * is strictly less than zero or larger or equal than the size
     * of data
     */
    public E remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Object temp = this.data[index];
        for(int i = index; i < this.size-1;i++){
            this.data[i] = this.data[i+1];
        }
        return (E)temp;
    }
    //this method returns the size of data
    public int size(){
        return this.size;
    }
    
}

 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid
 // elements in the array