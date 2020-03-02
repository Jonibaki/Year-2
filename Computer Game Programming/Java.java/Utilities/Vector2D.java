package Utilities;

// mutable 2D vectors
public final class Vector2D {
public double x, y;

// constructor for zero vector
public Vector2D() {}

// constructor for vector with given coordinates
public Vector2D(double x, double y) {
    this.x=x;
    this.y=y;
}

// constructor that copies the argument vector 
public Vector2D(Vector2D v) {
    this.x= v.x;
    this.y= v.y;

}

// set coordinates
public Vector2D set(double x, double y) {
    this.x= x;
    this.y= y;
    return this;
}

// set coordinates based on argument vector 
public Vector2D set(Vector2D v) {
    this.x=v.x;
    this.y= v.y;
    return this;
}

// compare for equality (note Object type argument) 
public boolean equals(Object o) {
    if (this==o)
        return  true;
    if(o==null)
        return false;
    if (getClass() != o.getClass())
        return false;
    if(!(o instanceof Vector2D) )
        return false;

    Vector2D v = (Vector2D) o;
    return this.x==v.x && this.y==v.y;
}

// String for displaying vector as text 
public String toString() {
    return "Vector2D(" + x + ", " + y + ")";
}

    //  magnitude (= "length") of this vector
public double mag() {
    double magnitude = Math.sqrt(x*x+y*y);
    return magnitude;
}

// angle between vector and horizontal axis in radians in range [-PI,PI] 
// can be calculated using Math.atan2 
public double angle() {
    return Math.atan2(y,x);
}

// angle between this vector and another vector in range [-PI,PI] 
public double angle(Vector2D other) {
    double angle= Math.atan2(other.y,other.x)-Math.atan2(this.y,this.x);

    if(angle<-Math.PI){
        return angle+2*Math.PI;
    }else if (angle>Math.PI){
        return angle-2*Math.PI;
    }else{
        return angle;
    }
}

// add argument vector 
public Vector2D add(Vector2D v) {
    this.x +=v.x;
    this.y +=v.y;
    return  this;
}

// add values to coordinates 
public Vector2D add(double x, double y) {
    this.x+=x;
    this.y+=y;
    return this;
}

// weighted add - surprisingly useful
public Vector2D addScaled(Vector2D v, double fac) {
    this.x+= v.x*fac;
    this.y += v.y*fac;
    return this;
}

// subtract argument vector 
public Vector2D subtract(Vector2D v) {
   this.x-=v.x;
   this.y-=v.y;
   return this;
}

// subtract values from coordinates 
public Vector2D subtract(double x, double y) {
   this.x -=x;
   this.y -=y;
    return this;
}

// multiply with factor 
public Vector2D mult(double fac) {
    this.x *=fac;
    this.y *=fac;
    return this;
}

// rotate by angle given in radians 
public Vector2D rotate(double angle) {
    double cos = Math.cos(angle);
    double sin = Math.sin(angle);
    Vector2D v =new Vector2D(cos*this.x-sin*this.y, sin*this.x+cos*this.y);

    this.x=v.x;
    this.y=v.y;
    return this;
}

// "dot product" ("scalar product") with argument vector 
public double dot(Vector2D v) {
    return this.x*v.x + this.y*v.y;
}

// distance to argument vector 
public double dist(Vector2D v) {
    return Math.hypot(v.x-this.x, v.y-this.y);
}

// normalise vector so that magnitude becomes 1 
public Vector2D normalise() {
    double length = Math.sqrt( this.x*this.x + this.y*this.y );
    if (length != 0) {
        this.x = this.x/length;
        this.y = this.y/length;
    }

    return this;
}

// wrap-around operation, assumes w> 0 and h>0
// remember to manage negative values of the coordinates
public Vector2D wrap(double w, double h) {
    x = (x + w) % w;
    y = (y + h) % h;
    return this;
}

// construct vector with given polar coordinates  
public static Vector2D polar(double angle, double mag) {
    return new Vector2D(mag*Math.cos(angle), mag*Math.sin(angle));
}

}