/*
 * This file was automatically generated by EvoSuite
 * Tue Nov 13 19:48:50 BRT 2018
 */

package whenDoc.whenDOc.entity;

import static org.evosuite.runtime.EvoAssertions.verifyException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true, separateClassLoader = true, useJEE = true) 
public class Medico_ESTest extends Medico_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico((String) null, (Long) null, "", long0, (String) null, "", "");
      medico0.setConsulta((Set<Consulta>) null);
      assertEquals("", medico0.getTelefone());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico((String) null, (Long) null, "", long0, (String) null, "", "");
      medico0.setEmail("");
      assertEquals("", medico0.getSenha());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Medico medico0 = new Medico();
      Long long0 = medico0.getCpf();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Medico medico0 = new Medico();
      String string0 = medico0.getEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Medico medico0 = new Medico();
      Long long0 = new Long(0L);
      medico0.setCpf(long0);
      assertNull(medico0.getEmail());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Medico medico0 = new Medico();
      Set<Consulta> set0 = medico0.getConsulta();
      assertNull(set0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Medico medico0 = new Medico();
      Long long0 = medico0.getCrm();
      assertNull(long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Medico medico0 = new Medico();
      Set<Paciente> set0 = medico0.getPacientes();
      assertNull(set0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Medico medico0 = new Medico();
      String string0 = medico0.getEspecialidade();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico("", long0, "", long0, "", "", "");
      String string0 = medico0.getTelefone();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Medico medico0 = new Medico();
      medico0.setEspecialidade("");
      assertNull(medico0.getCpf());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Medico medico0 = new Medico();
      String string0 = medico0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico((String) null, (Long) null, "", long0, (String) null, "", "");
      medico0.setNome("");
      assertEquals("", medico0.getTelefone());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Medico medico0 = new Medico();
      medico0.setTelefone("");
      assertNull(medico0.getCpf());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico((String) null, (Long) null, "", long0, (String) null, "", "");
      medico0.setCrm(long0);
      assertEquals(0L, (long)medico0.getCpf());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Medico medico0 = new Medico("", (Long) null, "", (Long) null, "", (String) null, "");
      medico0.setSenha("");
      assertNull(medico0.getCpf());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico("", long0, "", long0, (String) null, (String) null, "");
      String string0 = medico0.getSenha();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Long long0 = new Long(0L);
      Medico medico0 = new Medico((String) null, (Long) null, "", long0, (String) null, "", "");
      Paciente paciente0 = new Paciente();
      // Undeclared exception!
      try { 
        medico0.addPaciente(paciente0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("whenDoc.whenDOc.entity.Medico", e);
      }
  }
}
