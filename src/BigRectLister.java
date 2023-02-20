import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BigRectLister {
    static ArrayList<Rectangle> rect = new ArrayList<>();
    static BigRectFilter lister = new BigRectFilter();

    public static void main(String[] args) {
        rect.add(new Rectangle(4, 4));
        rect.add(new Rectangle(4, 2));
        rect.add(new Rectangle(5, 3));
        rect.add(new Rectangle(1, 3));
        rect.add(new Rectangle(2, 2));
        rect.add(new Rectangle(5, 4));
        rect.add(new Rectangle(5, 6));
        rect.add(new Rectangle(1, 2));
        rect.add(new Rectangle(1, 1));
        rect.add(new Rectangle(4, 2));
        rect.add(new Rectangle(6, 3));

        for (Rectangle r : rect)
        {
            if (lister.accept(r))
            {
                System.out.println(r);
            }
        }
    }


    }

