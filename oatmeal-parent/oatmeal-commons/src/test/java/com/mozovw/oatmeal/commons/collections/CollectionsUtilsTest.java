package com.mozovw.oatmeal.commons.collections;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class CollectionsUtilsTest extends BaseTestCase{
	
	@Test
	public void test(){
		List<User> list = new ArrayList<User>();
		list.add(new User("a"));
		list.add(new User("b"));
		list.add(new User("c"));
		list.add(new User("c"));
		System.out.println(list.contains(new User("b")));
		List<User> list2 = new ArrayList<User>();
		list2.add(new User("d"));
		list2.add(new User("b"));
		System.out.println(CollectionUtils.isEmpty(new ArrayList<String>()));
		//Counts the number of elements in the input collection that match the predicate.
		System.out.println(CollectionUtils.countMatches(list, new User("c")));
		System.out.println(CollectionUtils.exists(list, new User("c")));
		System.out.println(CollectionUtils.union(list, list2));
		System.out.println(CollectionUtils.subtract(list, list2));
	}
}
class User implements Predicate{
	String name;
	
	
	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}

	@Override
	public boolean evaluate(Object object) {
		return equals(object);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

