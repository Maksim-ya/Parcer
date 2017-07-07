

public class Main {
    public static void main(String[] args) {

        //String s = new Word().enterWord();
        String s = args[0];
        new MakeFile().beginFile("D:\\"+s+".txt");
        new Parcer().parcing("https://www.aboutyou.de/suche?term="+s+"&category=20202","D:\\"+s+".txt");
        new Parcer().parcing("https://www.aboutyou.de/suche?term="+s+"&category=20201", "D:\\"+s+".txt");

        new MakeFile().finishFile("D:\\"+s+".txt");
        System.out.println("Your file is at disc D:");

    }
}
