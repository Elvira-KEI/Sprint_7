package org.example;
import java.util.List;
public class OrderGenerator {
   public static Order getWithBlackColor(){
        return new Order("Naruto",
                "Uzumaki",
                "Kanoha, 142 apt.",
                "1",
                "+7 800 355 35 35",
                5,
               "2020-06-06",
                "Saske, come back to Kanoha",
                List.of("BLACK")
                );
    }
    public static Order getWithGreyColor(){
        return new Order("Naruto",
                "Uzumaki",
                "Kanoha, 142 apt.",
                "1",
                "+7 800 355 35 35",
                5,
                "2020-06-06",
                "Saske, come back to Kanoha",
                List.of("GREY")
        );
    }
    public static Order getWithBlackAndGrayColors(){
        return new Order("Naruto",
                "Uzumaki",
                "Kanoha, 142 apt.",
                "1",
                "+7 800 355 35 35",
                5,
                "2020-06-06",
                "Saske, come back to Kanoha",
                List.of("BLACK", "GREY")
        );
    }
    public static Order getWithoutColor(){
        return new Order("Naruto",
                "Uzumaki",
                "Kanoha, 142 apt.",
                "1",
                "+7 800 355 35 35",
                5,
                "2020-06-06",
                "Saske, come back to Kanoha",
                List.of()
        );
    }
}
