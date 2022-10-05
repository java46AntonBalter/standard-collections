package telran.structure;

import java.util.*;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, value - counter
	TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); // key counter, value - set of items having the key -
																	// counter
	// consider using the Map method computeIfAbsent

	@Override
	public Integer addItem(Object item) {
		int key = items.merge(item, 1, Integer::sum);
		counters.compute(key, (k, v) -> {
			if (v == null) {
				v = new HashSet<Object>();
			}
			v.add(item);
			return v;
		});
		if (key > 1) {
			counters.compute(key - 1, (k, v) -> {
				v.remove(item);
				return v;
			});
		}
		return key;
	}

	@Override
	public Integer getValue(Object item) {
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		var res = items.containsKey(item);
		if (res) {
			counters.compute(items.get(item), (k, v) -> {
				v.remove(item);
				return v;
			});
			items.computeIfPresent(item, (k, v) -> v = null);
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		return counters.get(counters.lastKey());
	}

}
//public class MultiCountersImpl implements MultiCounters {
// HashMap<Object, Integer> items = new HashMap<>(); //key - item, value - counter
// TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); //key counter, value - set of items having the key - counter
////consider using the Map method computeIfAbsent	
// @Override
//	public Integer addItem(Object item) {
//		items.merge(item, 1, Integer::sum);
//		return items.get(item);
//	}
//
//	@Override
//	public Integer getValue(Object item) {
//		return items.get(item);
//	}
//
//	@Override
//	public boolean remove(Object item) {
//		var res = items.containsKey(item);
//		items.computeIfPresent(item, (k, v) ->  v = null);
//		return res;
//	}
//
//	@Override
//	public Set<Object> getMaxItems() {
//		counters = new TreeMap<>();
//		items.entrySet().stream().forEach(e -> counters.compute(e.getValue(), (k, v) -> {
//			if (v == null) {
//				v = new HashSet<Object>();
//			}
//			v.add(e.getKey());
//			return v;			
//		}));
//		return counters.get(counters.lastKey());
//	}
//
//}