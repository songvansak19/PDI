import io.javalin.Javalin;

public class TinyUpdateServer {
    static String data = "Initial data";

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8000);

        app.get("/", context -> context.result(data));

        app.put("/", context -> {
            data = context.body();
            System.out.println(data);
            context.result(data);
        });
    }
}