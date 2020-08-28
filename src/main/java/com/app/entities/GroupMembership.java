package com.app.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="group_membership")
public class GroupMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int membershipId;

    @Column(name="group_id")
    private int groupId;

    @Column(name="user_id")
    private int userId;

    @Column(name="role_id")
    private int roleId;

    @Column
    private Timestamp timestamp;

    public GroupMembership() {
    }

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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

    public void setRoleId(int role_id) {
        this.roleId = role_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
