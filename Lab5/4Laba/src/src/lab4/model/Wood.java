package src.lab4.model;

public class Wood {
private int id;
private String name;
private float density;
public Wood(int id, String name, float density) {
	super();
	this.id = id;
	this.name = name;
	this.density = density;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getDensity() {
	return density;
}
public void setDensity(float density) {
	this.density = density;
}

@Override
public String toString() {
	return "Wood [id=" + id + ", name=" + name + ", density=" + density + "]";
}


}
