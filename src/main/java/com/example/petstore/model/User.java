package com.example.petstore.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

    @Entity
    public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String password;
        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
        @Enumerated(EnumType.STRING)
        private List<Role> roleList;
        private Boolean enable;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String getUsername() {
            return username;
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

        @Override
        public boolean isEnabled() {
            return getEnable();
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoleList();
        }

        @Override
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Role> getRoleList() {
            return roleList;
        }

        public void setRoleList(List<Role> roleList) {
            this.roleList = roleList;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public User(Long id, String name, String password) {
            this.id = id;
            this.username = name;
            this.password = password;
        }
        public User() {
        }

        public User(String name, String password) {
            this.username = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", roleList=" + roleList +
                    ", enable=" + enable +
                    '}';
        }
    }