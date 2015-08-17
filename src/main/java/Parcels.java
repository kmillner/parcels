public class Parcels {

private Integer mLength;
private Integer mWidth;
private Integer mHeight;
private Integer mVolume;
private Integer mWeight;

public Parcels(int length, int height, int width , int weight){
  mLength = length;
  mWidth = width;
  mHeight = height;
  mWeight = weight;

  mVolume = length * width * height;
  }

  public int getLength() {
    return mLength;
  }
  public int getWidth(){
    return mWidth;
  }
  public int getHeight() {
    return mHeight;

  }
  public int getWeight(){
    return mWeight;
  }

  public int getVolume(){

    return mVolume;
  }

  public int getShippingCost(int distance){
    int shippingCost = mVolume * mWeight + distance;
    return shippingCost;
  }
}
