package uy.com.ces.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages({"uy.com.ces.tests"})
@IncludeTags("testerData")
@SuiteDisplayName("Tester Data Test Suite")
public class TesterDataTestSuite {
}