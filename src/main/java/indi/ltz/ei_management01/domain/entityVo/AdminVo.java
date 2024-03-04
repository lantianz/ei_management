package indi.ltz.ei_management01.domain.entityVo;

import indi.ltz.ei_management01.domain.entity.Admin;

public class AdminVo {
        private final Long id;
        private final String name;
        private final String phone;
        private final String username;
        private final Boolean level;

    public AdminVo(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.phone = admin.getPhone();
        this.username = admin.getUsername();
        this.level = admin.getLevel();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getLevel() {
        return level;
    }
}
