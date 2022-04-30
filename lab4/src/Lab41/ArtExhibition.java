package Lab41;

import java.util.Date;

public class ArtExhibition {
    private String name;

    public ArtExhibition(String name) {
        this.name = new String(name);
    }

    public String getName() {
        return name;
    }

    public class ExhibitionInfo {
        private String pictureName;
        private String authorName;
        private String time;

        public ExhibitionInfo(String pictureName, String authorName, String time) {
            this.authorName = new String(authorName);
            this.pictureName = new String(pictureName);
            this.time = new String(time);
        }

        public String getPictureName() {
            return pictureName;
        }

        public String getTime() {
            return time;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setDate(String time) {
            this.time = new String(time);
        }

        @Override
        public String toString() {
            return ("Выставка \"" + name + "\", " + "Картина \"" + pictureName + "\", автор " + authorName + ", время выставки " + time);
        }
    }
}
