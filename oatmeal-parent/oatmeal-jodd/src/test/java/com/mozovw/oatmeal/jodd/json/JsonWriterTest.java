package com.mozovw.oatmeal.jodd.json;

import jodd.json.JsonWriter;

import org.junit.Test;

public class JsonWriterTest {

	@Test
	public void test() {
		StringBuilder sb = new StringBuilder();
		JsonWriter jsonWriter = new JsonWriter(sb);
		jsonWriter.writeOpenObject();
		jsonWriter.writeName("one");
		jsonWriter.writeNumber(Long.valueOf(123));
		jsonWriter.writeComma();
		jsonWriter.writeName("two");
		jsonWriter.writeString("UberLight");
		jsonWriter.writeCloseObject();
		System.out.println(sb.toString());
	}
}
