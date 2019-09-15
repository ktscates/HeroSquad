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
            model.put("username", request.session().attribute("username"));
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        post("/homepage", (request, response) -> {
            String inputtedUsername = request.queryParams("username");
            request.session().attribute("username", inputtedUsername);
            model.put("username", inputtedUsername);
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
