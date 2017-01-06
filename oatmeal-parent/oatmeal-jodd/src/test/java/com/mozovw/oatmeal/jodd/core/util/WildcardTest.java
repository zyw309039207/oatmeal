package com.mozovw.oatmeal.jodd.core.util;

import jodd.util.Wildcard;

import org.junit.Test;

public class WildcardTest {
	@Test
	public void test() {
		Wildcard.match("CfgOptions.class", "*C*g*cl*");         // true   
	    Wildcard.match("CfgOptions.class", "*g*c**s");          // true!   
	    Wildcard.match("CfgOptions.class", "??gOpti*c?ass");    // true   
	    Wildcard.match("CfgOpti*class", "*gOpti\\*class");      // true   
	    Wildcard.match("CfgOptions.class", "C*ti*c?a?*");       // true
	    Wildcard.matchPath("/foo/soo/doo/boo", "/**/bo*");          // true
	    Wildcard.matchPath("/foo/one/two/three/boo", "**/t?o/**");  // true
	}
}
