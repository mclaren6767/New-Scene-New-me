import org.code.theater.*;

public class TheaterRunner {

    //read text files for scene classes

    String[] friends = FileReader.toStringArray("data1.txt");
    String[] places = FileReader.toStringArray("data3.txt");
    String[] images2026 = FileReader.toStringArray("data2.txt");



    // Creates scene objects
    lastYear lastYear = new lastYear(memories,friends,music,musicCaptions);
    thisYear thisYear = new thisYear(images2026);

    // Calls the methods
    lastYear.drawScene();
    thisYear.drawScene();

    // Play scenes 
    Theater.playScenes(lastYear, thisYear);
    

  }