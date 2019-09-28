package co.simplon.airbus_shop.service;

import co.simplon.airbus_shop.entities.AppRole;
 import co.simplon.airbus_shop.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username,String password,String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}

