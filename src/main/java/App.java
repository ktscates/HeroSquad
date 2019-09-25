import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        Map<String, Object> model = new HashMap<String, Object>();
        String layout = "templates/layout.hbs";

        get("/", (request, response) -> {
            model.put("squads", Squad.all());
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        post("/homepage", (request, response) -> {
//            model.put("squads", Squad.all());
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            List<Squad> squads = Squad.all();
            model.put("squads", squads);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());


        get("squads/new", (request, response) -> {
//            model.put("template", "templates/squadform.hbs");
            return new ModelAndView(model, "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            String squad_name = request.queryParams("squad_name");
            String cause = request.queryParams("cause");
            String maxsize = request.queryParams("maxsize");
            Squad squad = new Squad(squad_name, cause, Integer.parseInt(maxsize));
            model.put("squad_name", squad.getName());
            model.put("cause", squad.getCause());
            model.put("maxsize", squad.getMax());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            List<Hero> heroes = Hero.all();
            model.put("heroes", heroes);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());


        get("heroes/new", (request, response) -> {
//            model.put("template", "templates/squadform.hbs");
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            String hero_name = request.queryParams("hero_name");
            String age = request.queryParams("age");
            String powers = request.queryParams("powers");
            String weakness = request.queryParams("weakness");
            Hero hero = new Hero(hero_name, Integer.parseInt(age), powers, weakness);
            model.put("hero_name", hero.getName());
            model.put("age", hero.getAge());
            model.put("powers", hero.getPowers());
            model.put("weakness", hero.getWeakness());
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
