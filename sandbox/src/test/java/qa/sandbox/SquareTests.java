package qa.sandbox;

//import org.junit.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(6);
    Assert.assertEquals(s.area(), 35);
  }
}
