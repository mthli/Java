public class Welcome {
    public static void main(String[] args) {
        String[] greeting = new String[3];
        greeting[0] = "Welcome to Croe Java";
        greeting[1] = "by Gay Horstmann";
        greeting[2] = "and Gary Cornell";

        for (String g : greeting) {
            System.out.println(g);
        }
    }
}
