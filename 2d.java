float scale = 1;
float xPan = 640 ;  // mengatur posisi geseran horizontal 
float yPan = 360 ;  // geseran vertikal 
int posisi_awal = 0; // posisi awal rotasi
int pergeseran = 5; // mengatur kecepatan pergerseran rotasi 
boolean zoomIn = false; //nilai awal control paning , zoom  , rotasi 
boolean zoomOut = false;
boolean panUp = false;
boolean panDown = false;
boolean panLeft = false;
boolean panRight = false;
boolean rotateX = false;
boolean rotateY = false;

void setup(){
  size(1280 , 720 , P2D ) ; //ukuran jendela
}

void draw(){
  translate(width/2, height/2);
  scale(scale);
  translate(-xPan, -yPan);
  background(255);
  if(rotateX){
    rotate(radians(posisi_awal));
  }
  if(rotateY){
    rotate(radians(-posisi_awal));
  }
  posisi_awal += pergeseran;

  if (posisi_awal < 0){
    pergeseran = -pergeseran;
    posisi_awal += pergeseran;
  }
  
noStroke();
  
pushMatrix();
// Huruf H
fill(#DEA057);
rect(100, 100, 50, 200);
rect(200, 100, 50, 200);
rect(100, 200, 150, 50);
popMatrix();

pushMatrix();
// Huruf F
fill(#DEA057);
rect(350, 100, 50, 200);
rect(350, 100, 150, 50);
rect(350, 200, 150, 50);
popMatrix();

pushMatrix();
// Huruf A
translate(250, 0); // Geser huruf A ke kanan sejauh 250 piksel agar tidak menabrak huruf F
fill(#DEA057);
triangle(500, 100, 350, 300, 650, 300);
fill(255);
quad(450, 260, 420, 300, 580, 300, 550, 260);
triangle(500, 170, 462, 230, 538, 230);
popMatrix();

if(zoomIn){
    scale *= 1.01;
  }
  if(zoomOut){
    scale /= 1.01;
  }
  if(panUp){
    yPan += 1.01;
  }
  if(panDown){
    yPan -= 1.01;
  }
  if(panLeft){
    xPan += 1.01;
  }
  if(panRight){
    xPan -= 1.01;
  }
}


void keyReleased(){
  if(keyCode == UP){
    zoomIn = false;
  }
  if(keyCode == DOWN){
    zoomOut = false;
  }
  if(key == 'w'){
    panUp = false;
  }
  if(key == 's'){
    panDown = false;
  }
  if(key == 'a'){
    panLeft = false;
  }
  if(key == 'd'){
    panRight = false;
  }
  if(key == 'x'){
    rotateX = false;
  }
  if(key == 'y'){
    rotateY = false;
  }
}


void keyPressed(){
  if(keyCode == UP){
    zoomIn = true;
    zoomOut = false;
  }
  if(keyCode == DOWN){
    zoomOut = true;
    zoomIn = false;
  }
  if(key == 'w'){
    panUp = true;
    panDown = false;
  }
  if(key == 's'){
    panDown = true;
    panUp = false;
  }
  if(key == 'a'){
    panLeft = true;
    panRight = false;
  }
  if(key == 'd'){
    panRight = true;
    panLeft = false;
  }
  if(key == 'x'){
    rotateX = true;
  }
  if(key == 'y'){
    rotateY = true;
  }
}

