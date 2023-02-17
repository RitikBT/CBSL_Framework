package org.cbsl.newTestCase;

import org.cbsl.testBase.TestBase;
import org.testng.annotations.Test;

public class TestModel extends TestBase {

	@Test
	public void test01() {
		System.out.println("Done" + this.getClass().getName());
	}

	@Test
	public void test02() {
		System.out.println("Done" + this.getClass());
	}

	@Test
	public void test03() {
		System.out.println("Done" + this.getClass());
	}

}
