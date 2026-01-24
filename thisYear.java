
import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  private String[] images2026;

  // Variables (instance & static)
     public ThisYear() {
     String[] images2026 = FileReader.toStringArray("data2.txt");
  }
  // Paramterized Constructor
  public ThisYear(String[] images2026) {
    this.images2026 = images2026;
  }

 // Constuctor

  
  /**
   * Top level drawScene method
   */
 
   public void drawScene() {
    drawTitleScreen ();
    drawTiles(4,true);
    drawBanner(200,50);
    drawEndScreen();
   }
  
   /*
   * Imports 14 images into a 4x4 grid
   */
    
    public void drawTiles(int size, boolean staggered) {
    if (size <= 0 || size > 5) {
      System.out.println("These pictures represent what has been happening this year. Pictures of my boyfriend, dog, hockey game ive been to, and a picture of our penthouse in Canada");
      return;
    }

    int tileSize = getTileSize(size);
    int width = getWidth();
    int height = getHeight();
    int imageIndex = 0;
    for (int y = 0; y < height; y += tileSize) {
      for (int x = 0; x < width; x += tileSize) {

        if (imageIndex >= images2026.length) {
  return; // or break out
}

        drawImage(images2026[imageIndex], x, y, tileSize);
        
        if (staggered) {
          pause(0.5); // change time
        }
        
        imageIndex++;
      }
    }  
    
       
  }

  /**
   * Determines the tile size of the image to draw
   * precondition: size > 0 && size < 5
   */
  public int getTileSize(int size) {
    if (size == 1) {
      return 400;
    } else if (size == 2) {
      return 200;
    } else if (size == 3) {
      return 133;
    } else {  // when size = 4
      return 100;
    }
  }

   

    


  
  public void drawBanner(int yPos, int textSize) {
    setTextHeight(textSize);
    String text = "Welcome to 2026!";


    int xPos = 400; // start on right side of screen
    int textWidth = getEstimateLengthInPixels(text, textSize);

    while (xPos > -textWidth) {
      clear("white"); // can change to different color or image
      
      drawText(text, xPos, yPos);
      pause(0.1); // this is the fastest it can be, can slow down
      
      xPos -= 10; // shift over by 10px, can change
    }
  }

  /**
   * Helper method, estimates the with of text in pixels
   */
  public static int getEstimateLengthInPixels(String text, int textSize) {
    // the average width per character at size 22 is ~15px, which is about 70%
    double avgWidthPerChar = 0.7 * textSize;
    // add 15% buffer to overestimate
    return (int) (text.length() * avgWidthPerChar * 1.15);
  }

  

  
  public void drawEndScreen() {
    setEndScreenStyle();
    clear("pink");
    drawText("This year I want to be more productive", 10, 175);
    drawBanner(100,12);
  }

   public void setEndScreenStyle() {
    setTextHeight(60);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD_ITALIC);
  }
  public void drawTitleScreen() {
    setTitleScreenStyle();
    clear("white");
  }


  public void setTitleScreenStyle() {
    setTextHeight(50);
    setTextColor("pink");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
  }

  

  // other methods
  

  
}
  
