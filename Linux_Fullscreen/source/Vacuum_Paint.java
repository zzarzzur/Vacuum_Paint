import processing.core.*; 
import processing.xml.*; 

import controlP5.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Vacuum_Paint extends PApplet {


ControlP5 controlP5;
ControlWindow controlWindow;
ControlWindowCanvas cc;
int c;
public int SizeValue = 40;
public int TransValue = 40;
public int TipValue = 1;
int mx;
int my;
PImage cp;
PImage star1;
PImage star2;
PImage clver;
PImage sve;
PImage cpen;
DropdownList p1;
boolean shown = true;
boolean Detonated;
boolean Finished;
boolean dead;
boolean done;
boolean sad;
boolean sunlight1;
boolean sunlight2;
boolean grab = false;
boolean grabstart = false;
String help;
String Detonator;
String Countdown;
String Clock;
String Reset;
String Happy;
String Starlight1;
String Starlight2;
Button b;
public int buttonValue = 0;
// this example demonstrates how to use a ControlWindowCanvas 
// which can from different windows.
// click the mouse in both windows to see the effect.

// your controlWindowCanvas class



public void setup() {
  size(1280,1024);
  frameRate(30);
  controlP5 = new ControlP5(this);
  cp = loadImage("color.jpg");
  star1 = loadImage("star1.tga");
  star2 = loadImage("star2.tga");
  cpen = loadImage("cpen.tga");
  clver = loadImage("clver.tga");
  controlWindow = controlP5.addControlWindow("Attributes",100,100,400,400,30);
  controlWindow.setUpdateMode(ControlWindow.NORMAL);
  controlWindow.hideCoordinates();
  Controller mySlider = controlP5.addSlider("SizeValue",0,400,0,170,400,10);
  Controller mySlider1 = controlP5.addSlider("TransValue",0,255,0,190,255,10);
  Controller mySlider2 = controlP5.addSlider("TipValue",1,7,0,210,400,10);
  Controller hi = controlP5.addButton("Reset",0,220,0,80,19);
  Controller ccpen = controlP5.addButton("Grab_Color",0,300,0,80,19);
  mySlider.setWindow(controlWindow);
  mySlider1.setWindow(controlWindow);
  mySlider2.setWindow(controlWindow);
  hi.setWindow(controlWindow);
  ccpen.setWindow(controlWindow);



  cc = new MyCanvas();
  cc.pre();
  controlWindow.addCanvas(cc);
}

public void draw() {

  fill(c, TransValue);
  stroke(c, TransValue);



  strokeWeight(SizeValue);
  if(grab == true) {
    if(grabstart == true) {
    saveFrame("/data/sve.jpg");
    sve = loadImage("sve.jpg");
    grabstart = false;
    }
    if(mouseX != mx || mouseY != my) {
      image(sve, 0, 0);
      image(cpen,mouseX,mouseY-160);
      mx = mouseX;
      my = mouseY;
    }
    if(mousePressed) {
      image(sve, 0, 0);
      c = get(mouseX, mouseY);
      fill(c);
      stroke(c);
      println(c);
      cursor();
      grab = false;
    }
      
}

}
public void mouseDragged() {
  if(TipValue == 1) {
    line(mouseX, mouseY, pmouseX, pmouseY);
  }
  if(TipValue == 2) {
    strokeWeight(0);
    rect(mouseX, mouseY, SizeValue, SizeValue);
  }
  if(TipValue == 3) {
    strokeWeight(0);
    ellipse(mouseX, mouseY, SizeValue, SizeValue);
  }
  if(TipValue == 4) {
    strokeWeight(0);
    triangle(mouseX, mouseY-SizeValue, mouseX+SizeValue, mouseY+SizeValue,mouseX-SizeValue, mouseY+SizeValue);
  }
  if(TipValue == 5) {
    strokeWeight(0);
    image(star1, mouseX - 98, mouseY - 94);
  }
  if(TipValue == 6) {
    strokeWeight(0);
    image(star2, mouseX - 98, mouseY - 94);
  }
    if(TipValue == 7) {
    strokeWeight(0);
    image(clver, mouseX - 74, mouseY - 80);
  }
}
public void mousePressed() {
  if(TipValue == 1) {
    point(mouseX, mouseY);
  }
  if(TipValue == 2) {
    strokeWeight(0);
    rect(mouseX, mouseY, SizeValue, SizeValue);
  }
  if(TipValue == 3) {
    strokeWeight(0);
    ellipse(mouseX, mouseY, SizeValue, SizeValue);
  }
  if(TipValue == 4) {
    strokeWeight(0);
    triangle(mouseX, mouseY-SizeValue, mouseX+SizeValue, mouseY+SizeValue,mouseX-SizeValue, mouseY+SizeValue);
  }
  if(TipValue == 5) {
    strokeWeight(0);
    image(star1, mouseX - 98, mouseY - 94);
  }
  if(TipValue == 6) {
    strokeWeight(0);
    image(star2, mouseX - 98, mouseY - 94);
  }
      if(TipValue == 7) {
    strokeWeight(0);
    image(clver, mouseX - 74, mouseY - 80);
  }
}

public void keyPressed() {
  if (key == 's') {

    controlP5.window("Attributes").show();
  }
  if (key == 'h') {
    controlP5.window("Attributes").hide();
  }
}
public void Reset(int theValue) {
  println("a button event from buttonA: "+theValue);
  println("Background Reset");
  background(255);

}
public void Grab_Color(int theValue) {
  println("a button event from buttonB: "+theValue);
  println("Grabbing Color");
  noCursor();
  grab = true;
  grabstart = true;

}
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
      theApplet.image(star1, 200, 300);
    }
      if(TipValue == 6) {
      theApplet.strokeWeight(0);
      theApplet.image(star2, 200, 300);
    }
          if(TipValue == 7) {
      theApplet.strokeWeight(0);
      theApplet.image(clver, 200, 300);
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

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--hide-stop", "Vacuum_Paint" });
  }
}
