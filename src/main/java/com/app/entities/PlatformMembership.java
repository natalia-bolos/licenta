package com.app.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="platform_membership")
public class PlatformMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="platform_membership_id")
    private int platformMembershipId;

    @Column(name="user_id")
    private int userId;

    @Column(name="role_id")
    private int roleId;

    @CreatedDate
    private Timestamp timestamp;

    public PlatformMembership() {
    }

    public PlatformMembership(int userId, int roleId, Timestamp timestamp) {
        this.userId = userId;
        this.roleId = roleId;
        this.timestamp = timestamp;
    }

    public int getPlatformMembershipId() {
        return platformMembershipId;
    }

    public void setPlatformMembershipId(int platformMembershipId) {
        this.platformMembershipId = platformMembershipId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
