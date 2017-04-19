package qz.seventeen.melius;

/**
 * Created by wizarniak on 3/27/17.
 */
public class Restaurant {
    public double latitude;
    public double longitude;
    public String name;
    public double rating;
    public double priceLevel;

    public Restaurant(String aName, double aLatitude, double aLongitude, double aRating,
                      double aPriceLevel) {
        name = aName;
        latitude = aLatitude;
        longitude = aLongitude;
        rating = aRating;
        priceLevel = aPriceLevel;
    }
}
