import processing.core.*;

float angleX, angleY, angleZ;
float rotationSpeed = 0.01;
float sensitivity = 0.01;
float prevMouseX, prevMouseY;

void setup() {
  size(800, 600, P3D);
  prevMouseX = mouseX;
  prevMouseY = mouseY;
}

void draw() {
  background(0, 0, 0);
  lights();
  translate(width/2, height/2, 0);
  rotateX(angleX);
  rotateY(angleY);
  rotateZ(angleZ);

  // Membuat huruf "M"
  fill(128, 128, 1);
  pushMatrix();
  translate(-180, 0, 0);
  box(55, 220, 50);   //'|L'
  translate(180, 0, 0);
  box(55, 220, 50);   //'|R'
  rotateZ(radians(-45));
  translate(-50, -125, 0);
  box(40, 120, 50);   //'\'
  rotateZ(radians(90));
  translate(50, -50, 0);
  box(40, 120, 50);    //'/'
  popMatrix();

  // Menggerakkan huruf dengan input mouse
  float deltaX = mouseX - prevMouseX;
  float deltaY = mouseY - prevMouseY;

  angleY += deltaX * sensitivity;
  angleX += deltaY * sensitivity;

  // Keyboard input for pitch, yaw, and roll
  // pitch down  = s 
  // yaw left = a
  // yaw right = d 
  // roll left 
  // rol right 

  if (keyPressed) {
    if (key == 'w' || key == 'W') {  // Pitch up
      angleX -= rotationSpeed;
    } else if (key == 's' || key == 'S') {  // Pitch down
      angleX += rotationSpeed;
    } else if (key == 'a' || key == 'A') {  // Yaw left
      angleY -= rotationSpeed;
    } else if (key == 'd' || key == 'D') {  // Yaw right
      angleY += rotationSpeed;
    } else if (key == 'q' || key == 'Q') {  // Roll left
      angleZ -= rotationSpeed;
    } else if (key == 'e' || key == 'E') {  // Roll right
      angleZ += rotationSpeed;
    }
  }

  prevMouseX = mouseX;
  prevMouseY = mouseY;
}

