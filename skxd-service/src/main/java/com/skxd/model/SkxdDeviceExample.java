package com.skxd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkxdDeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkxdDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andLeaderNameIsNull() {
            addCriterion("leader_name is null");
            return (Criteria) this;
        }

        public Criteria andLeaderNameIsNotNull() {
            addCriterion("leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderNameEqualTo(String value) {
            addCriterion("leader_name =", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotEqualTo(String value) {
            addCriterion("leader_name <>", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameGreaterThan(String value) {
            addCriterion("leader_name >", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("leader_name >=", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameLessThan(String value) {
            addCriterion("leader_name <", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("leader_name <=", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameLike(String value) {
            addCriterion("leader_name like", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotLike(String value) {
            addCriterion("leader_name not like", value, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameIn(List<String> values) {
            addCriterion("leader_name in", values, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotIn(List<String> values) {
            addCriterion("leader_name not in", values, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameBetween(String value1, String value2) {
            addCriterion("leader_name between", value1, value2, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderNameNotBetween(String value1, String value2) {
            addCriterion("leader_name not between", value1, value2, "leaderName");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIsNull() {
            addCriterion("leader_phone is null");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIsNotNull() {
            addCriterion("leader_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneEqualTo(String value) {
            addCriterion("leader_phone =", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotEqualTo(String value) {
            addCriterion("leader_phone <>", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneGreaterThan(String value) {
            addCriterion("leader_phone >", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("leader_phone >=", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLessThan(String value) {
            addCriterion("leader_phone <", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLessThanOrEqualTo(String value) {
            addCriterion("leader_phone <=", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneLike(String value) {
            addCriterion("leader_phone like", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotLike(String value) {
            addCriterion("leader_phone not like", value, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneIn(List<String> values) {
            addCriterion("leader_phone in", values, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotIn(List<String> values) {
            addCriterion("leader_phone not in", values, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneBetween(String value1, String value2) {
            addCriterion("leader_phone between", value1, value2, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andLeaderPhoneNotBetween(String value1, String value2) {
            addCriterion("leader_phone not between", value1, value2, "leaderPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNull() {
            addCriterion("fixed_phone is null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIsNotNull() {
            addCriterion("fixed_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneEqualTo(String value) {
            addCriterion("fixed_phone =", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotEqualTo(String value) {
            addCriterion("fixed_phone <>", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThan(String value) {
            addCriterion("fixed_phone >", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_phone >=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThan(String value) {
            addCriterion("fixed_phone <", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLessThanOrEqualTo(String value) {
            addCriterion("fixed_phone <=", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneLike(String value) {
            addCriterion("fixed_phone like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotLike(String value) {
            addCriterion("fixed_phone not like", value, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneIn(List<String> values) {
            addCriterion("fixed_phone in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotIn(List<String> values) {
            addCriterion("fixed_phone not in", values, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneBetween(String value1, String value2) {
            addCriterion("fixed_phone between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andFixedPhoneNotBetween(String value1, String value2) {
            addCriterion("fixed_phone not between", value1, value2, "fixedPhone");
            return (Criteria) this;
        }

        public Criteria andCustomIdIsNull() {
            addCriterion("custom_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomIdIsNotNull() {
            addCriterion("custom_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomIdEqualTo(String value) {
            addCriterion("custom_id =", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotEqualTo(String value) {
            addCriterion("custom_id <>", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThan(String value) {
            addCriterion("custom_id >", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdGreaterThanOrEqualTo(String value) {
            addCriterion("custom_id >=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThan(String value) {
            addCriterion("custom_id <", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLessThanOrEqualTo(String value) {
            addCriterion("custom_id <=", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdLike(String value) {
            addCriterion("custom_id like", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotLike(String value) {
            addCriterion("custom_id not like", value, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdIn(List<String> values) {
            addCriterion("custom_id in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotIn(List<String> values) {
            addCriterion("custom_id not in", values, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdBetween(String value1, String value2) {
            addCriterion("custom_id between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andCustomIdNotBetween(String value1, String value2) {
            addCriterion("custom_id not between", value1, value2, "customId");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIsNull() {
            addCriterion("operator_phone is null");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIsNotNull() {
            addCriterion("operator_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneEqualTo(String value) {
            addCriterion("operator_phone =", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotEqualTo(String value) {
            addCriterion("operator_phone <>", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneGreaterThan(String value) {
            addCriterion("operator_phone >", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("operator_phone >=", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLessThan(String value) {
            addCriterion("operator_phone <", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLessThanOrEqualTo(String value) {
            addCriterion("operator_phone <=", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneLike(String value) {
            addCriterion("operator_phone like", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotLike(String value) {
            addCriterion("operator_phone not like", value, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneIn(List<String> values) {
            addCriterion("operator_phone in", values, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotIn(List<String> values) {
            addCriterion("operator_phone not in", values, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneBetween(String value1, String value2) {
            addCriterion("operator_phone between", value1, value2, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andOperatorPhoneNotBetween(String value1, String value2) {
            addCriterion("operator_phone not between", value1, value2, "operatorPhone");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNull() {
            addCriterion("created_user is null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIsNotNull() {
            addCriterion("created_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedUserEqualTo(String value) {
            addCriterion("created_user =", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotEqualTo(String value) {
            addCriterion("created_user <>", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThan(String value) {
            addCriterion("created_user >", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserGreaterThanOrEqualTo(String value) {
            addCriterion("created_user >=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThan(String value) {
            addCriterion("created_user <", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLessThanOrEqualTo(String value) {
            addCriterion("created_user <=", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserLike(String value) {
            addCriterion("created_user like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotLike(String value) {
            addCriterion("created_user not like", value, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserIn(List<String> values) {
            addCriterion("created_user in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotIn(List<String> values) {
            addCriterion("created_user not in", values, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserBetween(String value1, String value2) {
            addCriterion("created_user between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andCreatedUserNotBetween(String value1, String value2) {
            addCriterion("created_user not between", value1, value2, "createdUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIsNull() {
            addCriterion("updated_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIsNotNull() {
            addCriterion("updated_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserEqualTo(String value) {
            addCriterion("updated_user =", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserNotEqualTo(String value) {
            addCriterion("updated_user <>", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserGreaterThan(String value) {
            addCriterion("updated_user >", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserGreaterThanOrEqualTo(String value) {
            addCriterion("updated_user >=", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserLessThan(String value) {
            addCriterion("updated_user <", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserLessThanOrEqualTo(String value) {
            addCriterion("updated_user <=", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserLike(String value) {
            addCriterion("updated_user like", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserNotLike(String value) {
            addCriterion("updated_user not like", value, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserIn(List<String> values) {
            addCriterion("updated_user in", values, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserNotIn(List<String> values) {
            addCriterion("updated_user not in", values, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserBetween(String value1, String value2) {
            addCriterion("updated_user between", value1, value2, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedUserNotBetween(String value1, String value2) {
            addCriterion("updated_user not between", value1, value2, "updatedUser");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNull() {
            addCriterion("updated_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIsNotNull() {
            addCriterion("updated_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateEqualTo(Date value) {
            addCriterion("updated_date =", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotEqualTo(Date value) {
            addCriterion("updated_date <>", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThan(Date value) {
            addCriterion("updated_date >", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_date >=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThan(Date value) {
            addCriterion("updated_date <", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
            addCriterion("updated_date <=", value, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateIn(List<Date> values) {
            addCriterion("updated_date in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotIn(List<Date> values) {
            addCriterion("updated_date not in", values, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateBetween(Date value1, Date value2) {
            addCriterion("updated_date between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
            addCriterion("updated_date not between", value1, value2, "updatedDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeIsNull() {
            addCriterion("device_install_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeIsNotNull() {
            addCriterion("device_install_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeEqualTo(String value) {
            addCriterion("device_install_type =", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeNotEqualTo(String value) {
            addCriterion("device_install_type <>", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeGreaterThan(String value) {
            addCriterion("device_install_type >", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_install_type >=", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeLessThan(String value) {
            addCriterion("device_install_type <", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeLessThanOrEqualTo(String value) {
            addCriterion("device_install_type <=", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeLike(String value) {
            addCriterion("device_install_type like", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeNotLike(String value) {
            addCriterion("device_install_type not like", value, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeIn(List<String> values) {
            addCriterion("device_install_type in", values, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeNotIn(List<String> values) {
            addCriterion("device_install_type not in", values, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeBetween(String value1, String value2) {
            addCriterion("device_install_type between", value1, value2, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andDeviceInstallTypeNotBetween(String value1, String value2) {
            addCriterion("device_install_type not between", value1, value2, "deviceInstallType");
            return (Criteria) this;
        }

        public Criteria andSellerIsNull() {
            addCriterion("seller is null");
            return (Criteria) this;
        }

        public Criteria andSellerIsNotNull() {
            addCriterion("seller is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEqualTo(String value) {
            addCriterion("seller =", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotEqualTo(String value) {
            addCriterion("seller <>", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThan(String value) {
            addCriterion("seller >", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThanOrEqualTo(String value) {
            addCriterion("seller >=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThan(String value) {
            addCriterion("seller <", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThanOrEqualTo(String value) {
            addCriterion("seller <=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLike(String value) {
            addCriterion("seller like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotLike(String value) {
            addCriterion("seller not like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerIn(List<String> values) {
            addCriterion("seller in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotIn(List<String> values) {
            addCriterion("seller not in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerBetween(String value1, String value2) {
            addCriterion("seller between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotBetween(String value1, String value2) {
            addCriterion("seller not between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andServerIsNull() {
            addCriterion("server is null");
            return (Criteria) this;
        }

        public Criteria andServerIsNotNull() {
            addCriterion("server is not null");
            return (Criteria) this;
        }

        public Criteria andServerEqualTo(String value) {
            addCriterion("server =", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotEqualTo(String value) {
            addCriterion("server <>", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThan(String value) {
            addCriterion("server >", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThanOrEqualTo(String value) {
            addCriterion("server >=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThan(String value) {
            addCriterion("server <", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThanOrEqualTo(String value) {
            addCriterion("server <=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLike(String value) {
            addCriterion("server like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotLike(String value) {
            addCriterion("server not like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerIn(List<String> values) {
            addCriterion("server in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotIn(List<String> values) {
            addCriterion("server not in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerBetween(String value1, String value2) {
            addCriterion("server between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotBetween(String value1, String value2) {
            addCriterion("server not between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIsNull() {
            addCriterion("install_time is null");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIsNotNull() {
            addCriterion("install_time is not null");
            return (Criteria) this;
        }

        public Criteria andInstallTimeEqualTo(Date value) {
            addCriterion("install_time =", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotEqualTo(Date value) {
            addCriterion("install_time <>", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeGreaterThan(Date value) {
            addCriterion("install_time >", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("install_time >=", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeLessThan(Date value) {
            addCriterion("install_time <", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeLessThanOrEqualTo(Date value) {
            addCriterion("install_time <=", value, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeIn(List<Date> values) {
            addCriterion("install_time in", values, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotIn(List<Date> values) {
            addCriterion("install_time not in", values, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeBetween(Date value1, Date value2) {
            addCriterion("install_time between", value1, value2, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallTimeNotBetween(Date value1, Date value2) {
            addCriterion("install_time not between", value1, value2, "installTime");
            return (Criteria) this;
        }

        public Criteria andInstallerIsNull() {
            addCriterion("installer is null");
            return (Criteria) this;
        }

        public Criteria andInstallerIsNotNull() {
            addCriterion("installer is not null");
            return (Criteria) this;
        }

        public Criteria andInstallerEqualTo(String value) {
            addCriterion("installer =", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerNotEqualTo(String value) {
            addCriterion("installer <>", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerGreaterThan(String value) {
            addCriterion("installer >", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerGreaterThanOrEqualTo(String value) {
            addCriterion("installer >=", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerLessThan(String value) {
            addCriterion("installer <", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerLessThanOrEqualTo(String value) {
            addCriterion("installer <=", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerLike(String value) {
            addCriterion("installer like", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerNotLike(String value) {
            addCriterion("installer not like", value, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerIn(List<String> values) {
            addCriterion("installer in", values, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerNotIn(List<String> values) {
            addCriterion("installer not in", values, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerBetween(String value1, String value2) {
            addCriterion("installer between", value1, value2, "installer");
            return (Criteria) this;
        }

        public Criteria andInstallerNotBetween(String value1, String value2) {
            addCriterion("installer not between", value1, value2, "installer");
            return (Criteria) this;
        }

        public Criteria andDeviceStateIsNull() {
            addCriterion("device_state is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStateIsNotNull() {
            addCriterion("device_state is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStateEqualTo(String value) {
            addCriterion("device_state =", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateNotEqualTo(String value) {
            addCriterion("device_state <>", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateGreaterThan(String value) {
            addCriterion("device_state >", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateGreaterThanOrEqualTo(String value) {
            addCriterion("device_state >=", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateLessThan(String value) {
            addCriterion("device_state <", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateLessThanOrEqualTo(String value) {
            addCriterion("device_state <=", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateLike(String value) {
            addCriterion("device_state like", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateNotLike(String value) {
            addCriterion("device_state not like", value, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateIn(List<String> values) {
            addCriterion("device_state in", values, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateNotIn(List<String> values) {
            addCriterion("device_state not in", values, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateBetween(String value1, String value2) {
            addCriterion("device_state between", value1, value2, "deviceState");
            return (Criteria) this;
        }

        public Criteria andDeviceStateNotBetween(String value1, String value2) {
            addCriterion("device_state not between", value1, value2, "deviceState");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkIsNull() {
            addCriterion("project_remark is null");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkIsNotNull() {
            addCriterion("project_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkEqualTo(String value) {
            addCriterion("project_remark =", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkNotEqualTo(String value) {
            addCriterion("project_remark <>", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkGreaterThan(String value) {
            addCriterion("project_remark >", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("project_remark >=", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkLessThan(String value) {
            addCriterion("project_remark <", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkLessThanOrEqualTo(String value) {
            addCriterion("project_remark <=", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkLike(String value) {
            addCriterion("project_remark like", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkNotLike(String value) {
            addCriterion("project_remark not like", value, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkIn(List<String> values) {
            addCriterion("project_remark in", values, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkNotIn(List<String> values) {
            addCriterion("project_remark not in", values, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkBetween(String value1, String value2) {
            addCriterion("project_remark between", value1, value2, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andProjectRemarkNotBetween(String value1, String value2) {
            addCriterion("project_remark not between", value1, value2, "projectRemark");
            return (Criteria) this;
        }

        public Criteria andCompetitorIsNull() {
            addCriterion("competitor is null");
            return (Criteria) this;
        }

        public Criteria andCompetitorIsNotNull() {
            addCriterion("competitor is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitorEqualTo(String value) {
            addCriterion("competitor =", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotEqualTo(String value) {
            addCriterion("competitor <>", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorGreaterThan(String value) {
            addCriterion("competitor >", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorGreaterThanOrEqualTo(String value) {
            addCriterion("competitor >=", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLessThan(String value) {
            addCriterion("competitor <", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLessThanOrEqualTo(String value) {
            addCriterion("competitor <=", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorLike(String value) {
            addCriterion("competitor like", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotLike(String value) {
            addCriterion("competitor not like", value, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorIn(List<String> values) {
            addCriterion("competitor in", values, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotIn(List<String> values) {
            addCriterion("competitor not in", values, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorBetween(String value1, String value2) {
            addCriterion("competitor between", value1, value2, "competitor");
            return (Criteria) this;
        }

        public Criteria andCompetitorNotBetween(String value1, String value2) {
            addCriterion("competitor not between", value1, value2, "competitor");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}