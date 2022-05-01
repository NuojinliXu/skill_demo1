/**
 *
 * Name: Nuojinli Xu
 * ID:A16826845
 * Email:n1xu@ucsd.edu
 * Sources used: Lecture slides
 * 
 * This file contains some hiddern tester for methods implemented in MyArrayList
 * specifcally tests for invalid inputs and exception handles
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;


/**
 * This class contains Junit tests for invalid inputs for constructor,
 * insert method, remove and expand capacity
 */
public class MyArrayListHiddenTester {

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test */
	static final int INVALID_INPUT = -99;
	static final int INVALID_INPUT_1 = 99;
	static final int DEFAULT_CAPACITY = 5;
	private MyArrayList listInvalid,listNull,listFull;
	private int test = 0;
	Integer[] arrInts = {1,2,3,4,5};
	@Before
	public void setUp() throws Exception {
		listFull = new MyArrayList(arrInts);

	}

	/**
	 * Aims to test the constructor when the input argument
	 * is not valid
	 */
	@Test
	public void testConstructorInvalidArg(){
		try{
			listInvalid = new MyArrayList(INVALID_INPUT);
		}
		catch(IllegalArgumentException e){
			test = 1;
		}
		assertEquals(1, test);
	}

	/**
	 * Aims to test the constructor when the input argument
	 * is null
	 */
	@Test
	public void testConstructorNullArg(){
		listNull = new MyArrayList(null);
		assertEquals(listNull.data.length, DEFAULT_CAPACITY);
		assertEquals(listNull.size,0);
	}

	/**
	 * Aims to test the append method when an element is added to a full list
	 * Check reflection on size and capacity
	 */
	@Test
	public void testAppendAtCapacity(){
		listFull.append(6);
		assertEquals(DEFAULT_CAPACITY+1, listFull.size);
		assertEquals(2*DEFAULT_CAPACITY,listFull.data.length);
		
	}

	/**
	 * Aims to test the prepend method when a null element is added
	 * Checks reflection on size and capacity
	 * Checks whether null was added successfully
	 */
	@Test
	public void testPrependNull(){
		listFull.prepend(null);
		assertEquals(DEFAULT_CAPACITY+1,listFull.size);
		assertEquals(2*DEFAULT_CAPACITY, listFull.data.length);
		assertEquals(null, listFull.data[0]);
		assertEquals(5, listFull.data[5]);
		
	}
	
	/**
	 * Aims to test the insert method when input index is out of bounds
	 */
	@Test
	public void testInsertOutOfBound(){
		try{
			listFull.insert(INVALID_INPUT, 21);
		}
		catch(IndexOutOfBoundsException e){
			test = 2;
		}
		assertEquals(2, test);

		try{
			listFull.insert(INVALID_INPUT_1, 21);
		}
		catch(IndexOutOfBoundsException e){
			test = 20;
		}
		assertEquals(20, test);
		
	}

	/**
	 * Insert multiple (eg. 1000) elements sequentially beyond capacity -
	 * Check reflection on size and capacity
	 * Hint: for loop could come in handy
	 */
	@Test
	public void testInsertMultiple(){
		listFull.insert(1, 11);
	   	listFull.insert(2, 22);
		listFull.insert(5, 55);
		Object[] anwer = {1,11,22,2,3,55,4,5,null,null};
		assertArrayEquals(anwer,listFull.data);
		
	}

	/**
	 * Aims to test the get method when input index is out of bound
	 */
	@Test
	public void testGetOutOfBound(){
		try{
			listFull.get(INVALID_INPUT);
		}
		catch(IndexOutOfBoundsException e){
			test = 3;
		}
		assertEquals(3,test);

		try{
			listFull.get(INVALID_INPUT_1);
		}
		catch(IndexOutOfBoundsException e){
			test = 30;
		}
		assertEquals(30,test);
		
	}

	/**
	 * Aims to test the set method when input index is out of bound
	 */
	@Test
	public void testSetOutOfBound(){
		try{
			listFull.set(INVALID_INPUT,21);
		}
		catch(IndexOutOfBoundsException e){
			test = 4;
		}
		assertEquals(4, test);

		try{
			listFull.set(INVALID_INPUT_1,21);
		}
		catch(IndexOutOfBoundsException e){
			test = 40;
		}
		assertEquals(40, test);
	}


	/**
	 * Aims to test the remove method when input index is out of bound
	 */
	@Test
	public void testRemoveOutOfBound(){
		try{
			listFull.remove(INVALID_INPUT);
		}
		catch(IndexOutOfBoundsException e){
			test = 5;
		}
		assertEquals(5, test);

		try{
			listFull.remove(INVALID_INPUT_1);
		}
		catch(IndexOutOfBoundsException e){
			test = 50;
		}
		assertEquals(50, test);
		
	}

	/**
	 * Aims to test the expandCapacity method when 
	 * requiredCapacity is strictly less than the current capacity
	 */
	@Test
	public void testExpandCapacitySmaller(){
	  try{
		  listFull.expandCapacity(3);
	  }
	  catch (IllegalArgumentException e){
		  test = 6;
	  }
	  assertEquals(6, test);
	}

	/**
	 * Aims to test the expandCapacity method when 
	 * requiredCapacity is greater than double(2x) the current capacity
	 */
	@Test
	public void testExpandCapacityExplode(){
		listFull.expandCapacity(18);
		assertEquals(18, listFull.data.length);
	}
	

}
