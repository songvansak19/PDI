import io.javalin.Javalin;

public class TinyUpdateServer {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8000);

        app.get("/", context -> {
            String data = "You are using GET";
            context.result(data);
        });

        app.put("/", context -> {
            String data;
            data = context.body();
            context.result(data);
        });
    }
}