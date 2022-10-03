package telran.structure;

import java.util.Set;

public interface MultiCounters {
	/** 
	 * adds Object item
	 * @param item
	 * @return number of times the item has been added
	 * if item is the new one then 1 will be returned
	 */
	Integer addItem(Object item);
	/**
	 * 
	 * @param item
	 * @return number of times the item has been added
	 * if none = null will be returned
	 */
	Integer getValue(Object item);
	/**
	 * removes item with all counters;
	 * @param item
	 * @return true if item has been removed, otherwise return false(if a given item doesn's exist)
	 */
	boolean remove(Object item);
	/**
	 * 
	 * @return item with max Counters
	 */
	Set<Object> getMaxItems();
	

}
