/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5C {

    protected static String userData;

    public static String convert() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(userData.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String getUserData() {
        return userData;
    }

    public static void setUserData(String userData) {
        MD5C.userData = userData;
    }
}
