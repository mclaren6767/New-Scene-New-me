import org.code.theater.*;

public class TheaterRunner {
public static void main(String[] args) {

    //read text files for scene classes

    String[] friends = FileReader.toStringArray("data1.txt");
    String[] places = FileReader.toStringArray("data3.txt");
    String[] images2026 = FileReader.toStringArray("data2.txt");



    // Creates scene objects
    LastYear lastYear = new LastYear(friends,places);
    ThisYear thisYear = new ThisYear(images2026);

    // Calls the methods
    lastYear.drawScene();
    thisYear.drawScene();

    // Play scenes 
    Theater.playScenes(lastYear, thisYear);

}
}

  