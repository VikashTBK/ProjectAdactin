package org.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.test.TestingClass;
import org.test.dupTest;

@RunWith(Suite.class)
@SuiteClasses({ TestingClass.class, dupTest.class })
public class ExSuite {
}
