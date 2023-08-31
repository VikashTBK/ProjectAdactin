package org.dataProvider;

import org.testng.annotations.Test;

public class ParallelExecution {

	@Test
	private void tc01() {

		System.out.println("Test-01"+ Thread.currentThread().getId());

	}

	@Test
	private void tc02() {

		System.out.println("Test-02"+ Thread.currentThread().getId());

	}

	@Test
	private void tc03() {

		System.out.println("Test-03"+ Thread.currentThread().getId());

	}

	@Test
	private void tc04() {

		System.out.println("Test-04"+ Thread.currentThread().getId());

	}

	@Test
	private void tc05() {

		System.out.println("Test-05"+ Thread.currentThread().getId());

	}
}
