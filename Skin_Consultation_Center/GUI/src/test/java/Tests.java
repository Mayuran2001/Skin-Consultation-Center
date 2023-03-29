import org.example.ConsultationManager;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.InputMismatchException;

public class Tests {

    @Test (expected = RuntimeException.class)
    public void TEST_CASE_01() {
        System.out.println("""
                TEST CASE 01:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        ConsultationManager.ValidateString("Ram85");
    }

    @Test (expected = RuntimeException.class)
    public void TEST_CASE_02() {
        System.out.println("""
                TEST CASE 02:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        ConsultationManager.ValidateString("854242");
    }

    @Test (expected = RuntimeException.class)
    public void TEST_CASE_03() {
        System.out.println("""
                TEST CASE 03:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        ConsultationManager.ValidateString("@#$%^&*(");
    }

    @Test (expected = RuntimeException.class)
    public void TEST_CASE_04() {
        System.out.println("""
                TEST CASE 04:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        ConsultationManager.ValidateString("Mayuran854242");
    }

    @Test
    public void TEST_CASE_05() {
        System.out.println("""
                TEST CASE 05:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        assertEquals(854242, ConsultationManager.ValidateInteger(854242));
    }

    @Test
    public void TEST_CASE_06() {
        System.out.println("""
                TEST CASE 06:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        assertEquals(854242, ConsultationManager.ValidateInteger(854242));
    }

    @Test
    public void TEST_CASE_07() {
        System.out.println("""
                TEST CASE 07:
                
                Input           :  Ram85
                Expected Output :  RuntimeException
                Description     :  Name/surname/specialisation cannot contain alphanumeric
                                   values
                """);
        assertEquals("Good", ConsultationManager.ValidateString("Good"));
    }
}