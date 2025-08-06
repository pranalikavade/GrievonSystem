package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}
