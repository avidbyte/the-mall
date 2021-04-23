package com.inst.mall.backstage.security;

import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.inst.mall.backstage.entity.po.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aaron
 */
public class AdminUserDetails implements UserDetails {

    private static final long serialVersionUID = 7824511198073431162L;

    private UmsAdmin umsAdmin;

    private List<UmsResource> resourceList;

    public AdminUserDetails() {

    }

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsResource> resourceList) {
        this.umsAdmin = umsAdmin;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public String getUsername() {
        return umsAdmin.getAccount();
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public UmsAdmin getUmsAdmin() {
        return umsAdmin;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
