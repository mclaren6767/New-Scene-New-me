import org.code.theater.*;
import org.code.media.*;

public class lastYear extends Scene {

  // Variables
  private String[] pictures;
  private String[] captions = {
    "Van Nuys airport", 
    "After volleyball",
    "Friday night lights",
    "Bowling with friends",
    "Piano Recital",
  };

  
  // Constuctors
   public lastYear() {
    String[] friends = FileReader.toStringArray("data1.txt");
    String[] places = FileReader.toStringArray("data3.txt");
   }

  //paramaterized constructor
  public lastYear(String[] friends, String[] places){
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
    drawEndScreen();
  }

    public void drawBackground(){
    drawImage("download.jpeg", 0, 0, 800);

  
    public void drawImagesWithCaptions() {
    setCaptionStyle();
    for (int index = 0; index < pictures.length-1; index++) {

        if (index>=pictures.length){
        return;
      }
      
      // arguments: image, xPosition, yPosition, width, height, rotation
      drawImage(pictures[index], 0, 0, 400, 400, 0.0);
      // arguments: text, xPosition, yPosition
      drawText(captions[index], 50, 350);
      // arguments: seconds

      pause(2.0);
    }
  }


  /* Draws an image of my trip to Disney
   * Adds title to the top
   * Stacks all images in the text file
   */
       
public void drawPlaces() {
   
    setTextColor("white");
    drawText("Here are photos from my disney trip", 27,20);
    int centerX = 200;  
    int size = 200;
    
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
      double radians = Math.toRadians(dAngle);
      double halfSize = size / 2.0;
      int adjustedX = (int)(centerX - (halfSize * Math.cos(radians) - halfSize * Math.sin(radians)));
      int adjustedY = (int)(centerY - (halfSize * Math.sin(radians) + halfSize * Math.cos(radians)));
      
      drawImage(image, adjustedX, adjustedY, size, dAngle);
      pause(1.5);
    }

     pause(1.5);
     clear("white");
  }
}

  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("blue");
    drawText("2025", 100, 175);
    drawText("Recap", 140, 225);
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