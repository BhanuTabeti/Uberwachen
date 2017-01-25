/*
 * Copyright 2016.
 * This code is part of IBM Mobile UI Builder
 */

package ibmmobileappbuilder.services;

/**
 * Base interface for a login service
 */
public interface LoginService {

    void attemptLogin(String email, String password);
}
