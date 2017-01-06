package com.mozovw.oatmeal.jodd.json;

import java.util.ArrayList;
import java.util.List;

import jodd.json.JsonSerializer;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class JsonSerializerTest extends BaseTestCase {

	@Test
	public void test() {
		Person object = new Person();
		String json = new JsonSerializer().exclude("work")
		        .include("phones")
		        .exclude("phones.areaCode")
		        .serialize(object);
		System.out.println(json);
		  json = new JsonSerializer()
			        .exclude("*")
			        .include("name")
			        .serialize(object);
		 System.out.println(json);
		 
	}

	class Person {

		private String name;
		private Address home;
		private Address work;
		private List<Phone> phones = new ArrayList<Phone>();

		class Address {
		};

		class Phone {
			String areaCode;

			public String getAreaCode() {

				return areaCode;
			}

			public void setAreaCode(String areaCode) {

				this.areaCode = areaCode;
			}

		}

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public Address getHome() {

			return home;
		}

		public void setHome(Address home) {

			this.home = home;
		}

		public Address getWork() {

			return work;
		}

		public void setWork(Address work) {

			this.work = work;
		}

		public List<Phone> getPhones() {

			return phones;
		}

		public void setPhones(List<Phone> phones) {

			this.phones = phones;
		};

		// ... and getters and setters
	}
}
