import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  // Variables
  private String[] friends;
  private String[] places;
  private String[] captions = {
    "Van Nuys airport", 
    "After volleyball",
    "Friday night lights",
    "Bowling with friends",
    "Piano Recital",
    "Marianna's birthday",
  };

  
  // Constuctors
   public LastYear() {
    String[] friends = FileReader.toStringArray("data1.txt");
    String[] places = FileReader.toStringArray("data3.txt");
   }

  //paramaterized constructor
  public LastYear(String[] friends, String[] places){
    this.friends = friends;
    this.places = places;
  


  }

  /**
   * Top level drawScene method
   */
  public void drawScene() {
    drawTitleScreen();
    pause(2.0);
    drawImagesWithCaptions();
    drawPlaces();

  }

    public void drawBackground(){
    drawImage("download.jpeg", 0, 0, 800);
    }
  
    public void drawImagesWithCaptions() {
    setCaptionStyle();
    for (int index = 0; index < friends.length-1; index++) {

        if (index>=friends.length){
        return;
      }
      
      // arguments: image, xPosition, yPosition, width, height, rotation
      drawImage(friends[index], 0, 0, 400, 400, 0.0);
      // arguments: text, xPosition, yPosition
      drawText(captions[index], 50, 350);
      // arguments: seconds

      pause(2.0);
      
    }
      clear("white");
    }
    
    

  /* Draws an image of my trip to Disney
   * Adds title to the top
   * Stacks all images in the text file
   */
       
      public void drawPlaces() {
   
    setTextColor("white");
    drawText("Here are photos from my disney trip", 27,20);
    int centerX = 100;  
    int centerY = 200;
    int size = 550;
    
    for (String image : places) {
      int angle = (int) (Math.random() * 21);
      if (angle % 2 == 1) {
        angle = (-1) * angle;
      }
      double dAngle = (double) angle;
      
      // calculate position for center-based rotation
      // standard 2D rotation: 
      // newX = x * cos(angle) - y * sin(angle)
      // newY = x * sin(angle) + y * cos(angle)
      double radians = Math.toRadians(dAngle+90);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      drawImage(image, adjustedX, adjustedY, size, dAngle+90);
      pause(1.5);
    }

     pause(1.5);
     clear("white");
  }


  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("white");
    drawText("2025", 100, 175);
    drawText("Recap", 140, 210);
  }
 

  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("pink");
    setTextStyle(Font.SANS, FontStyle.ITALIC);

  }
  
  public void setCaptionStyle() {
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
  }

    

}
  
  
