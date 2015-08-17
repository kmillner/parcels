import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    model.put("template", "templates/home.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/calculateshipping", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/calculateshipping.vtl");


    int length = Integer.parseInt(request.queryParams("length"));
    int width = Integer.parseInt(request.queryParams("width"));
    int height = Integer.parseInt(request.queryParams("height"));
    int weight = Integer.parseInt(request.queryParams("weight"));
    int distance = Integer.parseInt(request.queryParams("distance"));

    Parcels yourParcel = new Parcels(length,width,height,weight);

    int volume = yourParcel.getVolume();
    int shippingCost = yourParcel.getShippingCost(distance);

    model.put("volume",volume);
    model.put("shippingCost",shippingCost);

    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
  }
}
