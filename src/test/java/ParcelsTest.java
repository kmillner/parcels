import org.junit.*;
import static org.junit.Assert.*;

public class ParcelsTest {

  @Test
  public void newParcels_instantiatesCorrectly() {
    Parcels testParcels = new Parcels(2, 2, 2, 10);
    assertEquals(true, testParcels instanceof Parcels);
  }

  @Test
  public void getVolume_returnsCorrectVolume() {
  Parcels testParcels = new Parcels(2, 2, 2, 10);
  assertEquals(8, testParcels.getVolume());
  }

  @Test
  public void getShippingCost_returnsCorrectCost() {
    Parcels testParcels = new Parcels(2, 2, 2, 10);
    assertEquals(85, testParcels.getShippingCost(5));

  }
}
