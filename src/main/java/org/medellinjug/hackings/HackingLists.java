package org.medellinjug.hackings;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class HackingLists {

	public static Result addEnd(int amountData, Integer newNumber) {

		Collection<Integer> data = Utils.populate( amountData );

		List<Integer> arrayList = new ArrayList<>( data );
		List<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime  = addToEnd( arrayList, newNumber );
		long linkedListTime = addToEnd( linkedList, newNumber );

		return new Result( arrayListTime, linkedListTime );
	}

	private static long addToEnd(List<Integer> list, Integer number) {
		return Utils.calculateTime( () -> list.add( number ) );
	}

	public static Result addMiddle(int amountData, Integer newNumber) {

		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = addToMiddle(arrayList, newNumber);
		long linkedListTime = addToMiddle( linkedList, newNumber);


		return new Result( arrayListTime, linkedListTime );
	}

	private static long addToMiddle(List<Integer> list, Integer value) {
		return Utils.calculateTime( () -> list.add( value, value ) );
	}

	public static Result addStart(int amountData, Integer newNumber) {

		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = addToStart(arrayList, newNumber);
		long linkedListTime = addToStart(linkedList, newNumber);

		return new Result( arrayListTime, linkedListTime );
	}

	private static long addToStart(List<Integer> list, Integer value) {
		return Utils.calculateTime( () -> list.add( 0, value ) );
	}

	private static long deleteFromPosition(List<Integer> list, int position) {
		return Utils.calculateTime( () -> list.remove( position ) );
	}
	public static Result deleteEnd(int amountData) {

		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = deleteFromPosition( arrayList, arrayList.size() - 1);
		long linkedListTime = deleteFromPosition( linkedList, linkedList.size() - 1 );

		return new Result( arrayListTime, linkedListTime );
	}

	public static Result deleteMiddle(int amountData) {
		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = deleteFromPosition( arrayList, arrayList.size() / 2 );
		long linkedListTime = deleteFromPosition( linkedList, linkedList.size() / 2 );

		return new Result( arrayListTime, linkedListTime );
	}

	public static Result deleteStart(int amountData) {

		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = deleteFromPosition( arrayList, 0);
		long linkedListTime = deleteFromPosition( linkedList, 0 );

		return new Result( arrayListTime, linkedListTime );
	}


	public static Result getFromPosition(int amountData, int position) {

		Collection<Integer> data = Utils.populate( amountData );

		ArrayList<Integer> arrayList = new ArrayList<>( data );
		LinkedList<Integer> linkedList = new LinkedList<>( data );

		long arrayListTime = getFromPosition( arrayList, position );
		long linkedListTime = getFromPosition( linkedList, position );

		return new Result( arrayListTime, linkedListTime );
	}

	private static long getFromPosition(List<Integer> list, int position) {
		return Utils.calculateTime( () -> list.get( position ) );
	}

	public static class Result {
		private final long timeArrayList;
		private final long timeLinkedList;

		public Result(long timeArrayList, long timeLinkedList) {
			this.timeArrayList = timeArrayList;
			this.timeLinkedList = timeLinkedList;
		}

		public long getTimeArrayList() {
			return timeArrayList;
		}

		public long getTimeLinkedList() {
			return timeLinkedList;
		}
	}
}
