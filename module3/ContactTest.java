import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest { 
  private Contact contact;
 
  @BeforeEach
  void setUp() {
    contact = new Contact("Ada Lovelace", "+1 617 555 0101");
  } 
  
  @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }
  
  @Test
  void duplicateEntriesAreUnique() {
    Contact c1 = new Contact("John Smith", "+1 617 555 0101");
    Contact c2 = new Contact("John Smith", "+1 613 552 3513");
    assertNotEquals(c1, c2);
  }
} 
  