import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("shipping cost");
  }
  @Test
  public void volumeTest() {
    goTo("http://localhost:4567/");
    fill("#length").with("5");
    fill("#width").with("5");
    fill("#height").with("5");
    fill("#weight").with("5");
    fill("#distance").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("has a volume of 125");
  }

  @Test
  public void shippingTest() {
    goTo("http://localhost:4567/");
    fill("#length").with("5");
    fill("#width").with("5");
    fill("#height").with("5");
    fill("#weight").with("5");
    fill("#distance").with("10");
    submit(".btn");
    assertThat(pageSource()).contains("It will cost 635");

  }
}
