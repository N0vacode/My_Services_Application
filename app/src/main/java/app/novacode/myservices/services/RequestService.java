/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

public interface RequestService {

    Object postData(Object data);
    Object getData(Object data);
    Object deleteData(Object id);
    Object putDate(Object data);


}
