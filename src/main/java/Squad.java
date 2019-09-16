import java.util.ArrayList;
import java.util.List;

public class Squad {

    private String squad_name;
    private String cause;
    private int maxsize;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int id;

    public Squad (String squad_name, String cause, int maxsize){
        this.squad_name = squad_name;
        this.cause =  cause;
        this.maxsize = maxsize;
        instances.add(this);
        id = instances.size();
    }

    public String getName(){
        return squad_name;
    }

    public String getCause(){
        return cause;
    }

    public int getMax(){
        return maxsize;
    }

    public static List<Squad> all(){
        return instances;
    }
    public int getId(){
        return id;
    }
    public static Squad find(int id){
        return instances.get(id-1);
    }
}

