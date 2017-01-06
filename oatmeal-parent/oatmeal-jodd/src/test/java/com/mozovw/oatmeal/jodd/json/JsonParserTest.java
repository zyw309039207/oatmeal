package com.mozovw.oatmeal.jodd.json;

import java.util.Map;

import jodd.json.JsonParser;

import org.junit.Test;

import com.mozovw.oatmeal.root.test.BaseTestCase;

public class JsonParserTest extends BaseTestCase {
	String json = "{\"name\" : \"Mak\",\"bars\" : {\"123\": {\"amount\" : 12300},\"456\": {\"amount\" : 45600}},\"inters\" : {\"letterJ\" : {\"sign\" : \"J\"},\"letterO\" : {\"sign\" : \"O\"},\"letterD\" : {\"sign\" : \"D\"}}}";

	@Test
	public void test() {
		JsonParser jsonParser = new JsonParser();
		@SuppressWarnings("rawtypes")
		Map map = jsonParser
				.parse("{ \"one\" : { \"two\" : 285 }, \"three\" : true}");
		System.out.println(map.toString());
		User user = jsonParser.map("inters.values", InterImpl.class).parse(
				json, User.class);
		System.out.println(user.getInters().get("letterD").getSign());
		json = "{\"eee\" : {\"123\" : \"name\"}}";
		Map<String, Map<Long, String>> map2 = new JsonParser().map(
				"values.keys", Long.class).parse(json);
		System.out.println(map2);
	}

}

class User {
	private String name;
	private Map<String, Bar> bars;
	private Map<String, Inter> inters;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Map<String, Bar> getBars() {

		return bars;
	}

	public void setBars(Map<String, Bar> bars) {

		this.bars = bars;
	}

	public Map<String, Inter> getInters() {

		return inters;
	}

	public void setInters(Map<String, Inter> inters) {

		this.inters = inters;
	}

}

class Bar {
	private Integer amount;

	public Integer getAmount() {

		return amount;
	}

	public void setAmount(Integer amount) {

		this.amount = amount;
	}

}

interface Inter {
	public char getSign();
}

class InterImpl implements Inter {
	protected char sign;

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}
}
