package utility;

import com.restapibase.BaseClass;

public class createURL {

    public final static String baseURI = "https://api.github.com";

    public static String getBaseURI(){
        return baseURI;
    }
    //overload methods with different parameter to functions.
    public static String getBaseURI(String resourcePath){
        return baseURI + resourcePath;
    }


}