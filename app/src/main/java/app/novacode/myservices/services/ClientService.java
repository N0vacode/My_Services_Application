/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

import app.novacode.myservices.repository.UserRepository;

public interface ClientService {


    String login(String mail, String password);
    UserRepository signUp(UserRepository user);
    String restorePassword(String email);
    boolean isValidCode(String code);
    void newPassword(String password);



}
