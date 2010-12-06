/*
Name: Vacuum_Paint
Version: Update V1.003
    Copyright (C) 2010  Omar Zarzur

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
class MyCanvas extends ControlWindowCanvas {

  public void draw(PApplet theApplet) {
    theApplet.strokeWeight(0);
    theApplet.background(255);
    theApplet.image(cp,0, 0);
    theApplet.stroke(0);
    theApplet.line(170,0,170,141);
    theApplet.line(141,141,170,141);
    theApplet.strokeWeight(SizeValue);
    theApplet.fill(c, TransValue);
    theApplet.stroke(c, TransValue);
    if(TipValue == 1) {
      theApplet.point(200, 300);
    }
    if(TipValue == 2) {
      theApplet.strokeWeight(0);
      theApplet.rect(200, 300, SizeValue, SizeValue);
    }
    if(TipValue == 3) {
      theApplet.strokeWeight(0);
      theApplet.ellipse(200, 300, SizeValue, SizeValue);
    }
    if(TipValue == 4) {
      theApplet.strokeWeight(0);
      int cX = 200;
      int cY = 300;
      theApplet.triangle(cX, cY-SizeValue, cX+SizeValue, cY+SizeValue, cX-SizeValue, cY+SizeValue);
    }
      if(TipValue == 5) {
      theApplet.strokeWeight(0);
      theApplet.image(star1, 200 - (SizeValue/2), 300 - (SizeValue/2), SizeValue, SizeValue);
    }
      if(TipValue == 6) {
      theApplet.strokeWeight(0);
      theApplet.image(star2, 200 - (SizeValue/2), 300 - (SizeValue/2), SizeValue, SizeValue);
    }
          if(TipValue == 7) {
      theApplet.strokeWeight(0);
      theApplet.image(clver, 200 - (SizeValue/2), 300 - (SizeValue/2), SizeValue, SizeValue);
    }
          if(TipValue == 8) {
      theApplet.strokeWeight(0);
      theApplet.image(airplane1, 200 - (SizeValue/2), 300 - (SizeValue/2), SizeValue, SizeValue);
    }
          if(TipValue == 9) {
      theApplet.strokeWeight(0);
      theApplet.image(airplane2, 200 - (SizeValue/2), 300 - (SizeValue/2), SizeValue, SizeValue);
    }

    // a rectangle will be drawn if the mouse has been
    // pressed inside the main sketch window.
    // mousePressed here refers to the mousePressed
    // variable of your main sketch
    if(mousePressed) {
    }
    // will draw a rectangle into the controlWindow
    // if the mouse has been pressed inside the controlWindow itself.
    // theApplet.mousePressed here refers to the
    // mousePressed variable of the controlWindow.
    if(theApplet.mousePressed) {
      if(theApplet.mouseX>0 && theApplet.mouseX<170 && theApplet.mouseY>0 && theApplet.mouseY<142) {
        theApplet.fill(theApplet.get(theApplet.mouseX, theApplet.mouseY));

        theApplet.stroke(theApplet.get(theApplet.mouseX, theApplet.mouseY));
        theApplet.println(theApplet.get(theApplet.mouseX, theApplet.mouseY));
        c = theApplet.get(theApplet.mouseX, theApplet.mouseY);
      }
    }
  }
}

