package Lab41;

import java.util.Date;

public class Lab41 {
    public static void lab4_1() {
        ArtExhibition exhibition = new ArtExhibition("Русский авангард");
        ArtExhibition.ExhibitionInfo exhibitionInfo = exhibition.new
                ExhibitionInfo("Картина 1", "Автор 1", "15:00");

        System.out.println(exhibitionInfo);
    }
}
