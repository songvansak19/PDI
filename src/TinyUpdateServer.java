import io.javalin.Javalin;

public class TinyUpdateServer {
    static String data = "Initial data";

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8000);

        app.get("/", ctx -> ctx.result(data));

        app.put("/", ctx -> {
            data = ctx.body();
            System.out.println(data);
            ctx.result(data);
        });
    }
}