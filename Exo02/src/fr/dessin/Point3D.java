package fr.dessin;

public class Point3D extends Point2D {

	private int z;

	////////////////////////

	public Point3D() {
		super();
		this.z=0;

	}

	public Point3D(int vX, int vY,int vZ) {
		super(vX, vY);
		this.z=vZ;

	}

	///////////////////////

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	//////////////////////////

	public void translater(int dX,int dY, int dZ){
		super.translater(dX, dY);
		this.z+=dZ;

	}

	@Override
	public void afficher()
	{
		System.out.println(super.getX()+" "+super.getY()+" "+this.z);
	}




}
