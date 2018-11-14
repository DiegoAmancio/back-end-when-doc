/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 19:24:10 BRT 2018
 */

package whenDoc.whenDOc;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.fail;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class WhenDOcApplication_ESTest extends WhenDOcApplication_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      WhenDOcApplication whenDOcApplication0 = new WhenDOcApplication();
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      String[] stringArray0 = new String[2];
      // Undeclared exception!
      try { 
        WhenDOcApplication.main(stringArray0);
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // org/springframework/boot/SpringApplication
         //
         verifyException("whenDoc.whenDOc.WhenDOcApplication", e);
      }
  }
}
