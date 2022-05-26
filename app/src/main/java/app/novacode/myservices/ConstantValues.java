/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices;

public class ConstantValues {

    public final static String URL_API = "http://172.245.226.231:8080/myservice/api/v1/";
    //public final static String URL_API = "http://localhost:8080/myservice/api/v1/";

    public final static String AUTH_API = "";
    public final static String HEADER_API = "";
    public final static String PATH_SIGNUP_CLIENT = "user/body";
    public final static String PATH_SIGNUP_BUSINESS = "business";
    public final static String PATH_SIGNUP_SERVICES = "service";
    public final static String PATH_DELETE_SERVICES = "service/{id}";
    public final static String PATH_GET_BUSINESS = "business/all";
    public final static String PATH_GET_SERVICE = "service/business/{businessId}";
    public final static String PATH_GET_EMAIL = "user/account/{mail}";
    public final static String PATH_EXIST_MAIL = "user/validate/{mail}";
    public final static String PATH_LOGIN = "user/login/{mail}/{password}";
    public final static String PATH_SEND_CODE = "reset_password";
    public final static String PATH_GET_CODE_INFO = "reset_password/info_code/{reset_code}";
    public final static String PATH_USER_MAIN = "user";
    public final static String PATH_SEND_RATE = "rate";



    // Value Key User Client
    public final static String USER_ROL_KEY   = "userRol";
    public final static String USER_ID_KEY    = "userId";
    public final static String USER_FNAME_KEY = "userFirstName";
    public final static String USER_SNAME_KEY = "userSecondName";
    public final static String USER_CITY_KEY  = "userCity";
    public final static String USER_MAIL_KEY  = "userMail";
    public final static String CLIENT_MAIL_KEY  = "userMail";
    public final static String USER_PHONE_KEY = "userPhone";
    public final static String USER_PASS_KEY  = "userPassword";
    public final static String SAVED_DATA_USER = "userSaved";


    // Values Key Business Seller
    public final static String BUSINESS_NAME_KEY = "businessName";
    public final static String BUSINESS_ABOUT_KEY = "businessAbout";
    public final static String BUSINESS_AREA_KEY = "businessArea";
    public final static String BUSINESS_WEBSITE_KEY = "businessWebsite";
    public final static String BUSINESS_IMAGE_KEY = "imageUrl";
    public final static String BUSINESS_ID_KEY = "businessId";
    public final static String BUSINESS_RATE_KEY = "rate";
    public final static String BUSINESS_SELLER_DATA_KEY = "sellerData";


    // Value key Service
    public final static String SERVICE_CONTACT_KEY = "contactService";
    public final static String SERVICE_ABOUT_KEY = "specializationService";
    public final static String SERVICE_PRICE_KEY = "priceService";
    public final static String SERVICE_NAME_KEY = "nameService";
    public final static String SERVICE_ID_KEY = "idService";






    // key for send validator code
    public final static String PATH_KEY_MAIL_RECOVERY = "emailReset";

    public static int rateBusiness(double rate){

        if (rate == 1d) return R.drawable.rating1;
        if (rate == 1.5d) return R.drawable.rating1_5;
        if (rate == 2d) return R.drawable.rating2;
        if (rate == 2.5d) return R.drawable.rating2_5;
        if (rate == 3d) return R.drawable.rating3;
        if (rate == 3.5d) return R.drawable.rating3_5;
        if (rate == 4d) return R.drawable.rating4;
        if (rate == 4.5) return R.drawable.rating4_5;
        if (rate == 5) return R.drawable.rating5;
        else
            return R.drawable.rating;
    }


}
