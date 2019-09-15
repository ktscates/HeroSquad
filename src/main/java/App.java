import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){

        Map<String, Object> model = new HashMap<String, Object>();
        String layout = "templates/layout.hbs";

        get("/", (request, response) -> {

            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {

            String hero_name = request.queryParams("hero_name");
            String age = request.queryParams("age");
            String squad = request.queryParams("squad");
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            model.put("hero_name", hero_name);
            model.put("age", age);
            model.put("squad", squad);
            model.put("power", power);
            model.put("weakness", weakness);
            model.put("template", "templates/hero.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());
    }
}
