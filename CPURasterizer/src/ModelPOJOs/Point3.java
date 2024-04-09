package ModelPOJOs;

public class Point3 {
        
    private float x;
    private float y;
    private float z;

    public Point3 (float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point3 scalePoint3(int scale) {
        return new Point3(this.x * scale, this.y * scale, this.z * scale);
    }
}
