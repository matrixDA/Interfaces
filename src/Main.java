import java.awt.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ShortWordFilter filter = new ShortWordFilter();
        BigRectFilter lister = new BigRectFilter();

        ArrayList <String> line = new ArrayList<>();
        line.add(new String("Hello"));
        line.add(new String("my"));
        line.add(new String("name"));
        line.add(new String("is"));
        line.add(new String("Dinesh"));
        line.add(new String("and"));
        line.add(new String("I"));
        line.add(new String("like"));
        line.add(new String("Apples"));

        String[] fields;
        for (String l:line)
        {
            fields = l.split(" ");
            for (String w: fields)
            {
                if (filter.accept(w))
                {
                    System.out.println(w.trim());
                }
            }
        }

        ArrayList <Rectangle> rect = new ArrayList<>();
        rect.add(new Rectangle(5, 4));
        rect.add(new Rectangle(5, 6));
        rect.add(new Rectangle(1, 2));
        rect.add(new Rectangle(1, 1));
        rect.add(new Rectangle(3, 2));
        rect.add(new Rectangle(6, 3));

        System.out.println();
        for (Rectangle r: rect)
        {
            if (lister.accept(r))
            {
                System.out.println(r);
            }
        }

    }
}