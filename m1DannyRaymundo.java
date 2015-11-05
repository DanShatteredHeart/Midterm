//balls float
float dipperX, dipperY, dipperDX, dipperDY;
float billX, billY, billDX, billDY;
float robbieX, robbieY, robbieDX, robbieDY;

String title= "CST112 Midterm Exam";
//String news=;
//String author= "Danny Raymundo";

float left=50, right=850, top=200, bottom= 550;  //table bounderies
float middle=550;
boolean wall=true, all=false, rat=false;;

int tableRed=150, tableGreen=250, tableBlue=150;  //green table
int score=0,m=0,k=0;
 

int number=0;
//Table
void setup() {
  size( 640, 480 );
  
  //table boundaries
  left=50;
  right=590;
  top=200;
  bottom=430;
  middle=430;
  reset();
}
void reset() {
  dipperX= random(middle,right); dipperY= random(top,bottom);
  billX= random(middle,right); billY= random(top, bottom);
  robbieX= random(middle, right); robbieY= random(top, bottom);
  
  dipperDX= random(1,3); dipperDY= random(1,3);
  billDX= random(1,3); billDY= random(1,3);
  robbieDX= random(1,3); robbieDY= random(1,3);
}
//table, bounce, collisions
void draw() {
  background(170,239,255);
  rectMode( CORNERS );
  table( left, top, right, bottom );
  //buttons();
  bounce();
  //collisions();
  show();
 // messages();
}

//keys, click
void keyPressed() {
  if (key == 'q') {exit(); }
}

//table with wall
void table( float east, float north, float west, float south ){
  fill(tableRed, tableGreen, tableBlue );  //pool table
  strokeWeight (25);
  stroke(173,7,7); //red walls
  rect( east-20, north-20, west+20, south+20 );
  
  //wall in the middle
  if (wall) {
    float middle= (east+west)/2;
    stroke( 0,127,0);
    line( middle,north+10, middle,south-10);
  }
  stroke(0);
  strokeWeight(1);
}

//bounce off walls
void bounce(){
  dipperX += dipperDX; if ( dipperX< left || dipperX>right ) dipperDX*= -1;
  dipperY += dipperDY; if ( dipperY<top || dipperY>bottom ) dipperDY*= -1;
  
  billX += billDX; if ( billX<left || billX>right ) billDX*= -1;
  billY += billDY; if ( billY<top || billY>bottom ) billDY*= -1;
  
  robbieX += robbieDX; if ( robbieX<left || robbieX>right ) robbieDX*= -1;
  robbieY += robbieDY; if ( robbieY<top || robbieY>bottom ) robbieDY*= -1;
  

}
void collisions() {
  float tmp;
  if (dist( dipperX,dipperY, billX,billY ) < 30 ) {
    tmp=billDX;  billDX=dipperDX; dipperDX=tmp;
    tmp=billDY; billDY=dipperDY; dipperDY=tmp;
  }
  if (dist( dipperX,dipperY, robbieX,robbieY ) < 30 ) {
    tmp=robbieDX; robbieDX=dipperDX; dipperDX=tmp;
    tmp=robbieDY; robbieDY=dipperDY; dipperDY=tmp;
  }
  if ( dist( billX,billY, robbieX,robbieY ) < 30 ) {
    tmp=robbieDX; robbieDX=billDX; billDX=tmp;
    tmp=robbieDY; robbieDY=billDY; billDY=tmp;
  }
}
//balls
void show() {
  fill( 36,132,255); ellipse( dipperX,dipperY, 30,30 );
  fill(237,218,2); ellipse( billX,billY, 30,30 );
  fill(44,44,44); ellipse( robbieX,robbieY, 30,30 );

}

