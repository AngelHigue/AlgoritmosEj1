import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Fredy Velasquez <macacoloco696gmail.com>
 */
public class RadioTest {
    
    public RadioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of activarRadio method, of class Radio.
     */
    @Test
    public void testActivarRadio() {
        System.out.println("activarRadio");
        Vista miVista = new Vista();
        Radio miRadio = new Radio(miVista);
        miRadio.activarRadio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encenderApagar method, of class Radio.
     */
    @Test
    public void testEncenderApagar() {
        System.out.println("encenderApagar");
        Vista miVista = new Vista();
        Radio r = new Radio(miVista);
        Radio instance = null;
        boolean expResult = false;
        boolean result = instance.encenderApagar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of amFm method, of class Radio.
     */
    @Test
    public void testAmFm() {
        System.out.println("amFm-Caso 1");
        Vista miVista = new Vista();
        Radio instance = new Radio(miVista);
        boolean expResult = false;
        boolean result = instance.amFm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class Radio.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar 1 test");
        int btn = 1;
        Vista miVista = new Vista();
        Radio miRadio = new Radio(miVista);
        String expResult = "2";
        String result = miRadio.guardar(btn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of seleccionar method, of class Radio.
     */
    @Test
    public void testSeleccionar() {
        System.out.println("seleccionar");
        int btn = 0;
        Vista miVista = new Vista();
        Radio instance = new Radio(miVista);
        String expResult = "";
        String result = instance.seleccionar(btn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of avanzar method, of class Radio.
     */
    @Test
    public void testAvanzar() {
        System.out.println("avanzar");
        Radio instance = null;
        double expResult = 0.0;
        double result = instance.avanzar();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
