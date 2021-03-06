package com.skxd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkxdUserPowerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public SkxdUserPowerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProvinceNoIsNull() {
            addCriterion("province_no is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNoIsNotNull() {
            addCriterion("province_no is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNoEqualTo(String value) {
            addCriterion("province_no =", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoNotEqualTo(String value) {
            addCriterion("province_no <>", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoGreaterThan(String value) {
            addCriterion("province_no >", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoGreaterThanOrEqualTo(String value) {
            addCriterion("province_no >=", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoLessThan(String value) {
            addCriterion("province_no <", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoLessThanOrEqualTo(String value) {
            addCriterion("province_no <=", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoLike(String value) {
            addCriterion("province_no like", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoNotLike(String value) {
            addCriterion("province_no not like", value, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoIn(List<String> values) {
            addCriterion("province_no in", values, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoNotIn(List<String> values) {
            addCriterion("province_no not in", values, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoBetween(String value1, String value2) {
            addCriterion("province_no between", value1, value2, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNoNotBetween(String value1, String value2) {
            addCriterion("province_no not between", value1, value2, "provinceNo");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesIsNull() {
            addCriterion("province_names is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesIsNotNull() {
            addCriterion("province_names is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesEqualTo(String value) {
            addCriterion("province_names =", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesNotEqualTo(String value) {
            addCriterion("province_names <>", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesGreaterThan(String value) {
            addCriterion("province_names >", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesGreaterThanOrEqualTo(String value) {
            addCriterion("province_names >=", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesLessThan(String value) {
            addCriterion("province_names <", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesLessThanOrEqualTo(String value) {
            addCriterion("province_names <=", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesLike(String value) {
            addCriterion("province_names like", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesNotLike(String value) {
            addCriterion("province_names not like", value, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesIn(List<String> values) {
            addCriterion("province_names in", values, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesNotIn(List<String> values) {
            addCriterion("province_names not in", values, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesBetween(String value1, String value2) {
            addCriterion("province_names between", value1, value2, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andProvinceNamesNotBetween(String value1, String value2) {
            addCriterion("province_names not between", value1, value2, "provinceNames");
            return (Criteria) this;
        }

        public Criteria andCityNoIsNull() {
            addCriterion("city_no is null");
            return (Criteria) this;
        }

        public Criteria andCityNoIsNotNull() {
            addCriterion("city_no is not null");
            return (Criteria) this;
        }

        public Criteria andCityNoEqualTo(String value) {
            addCriterion("city_no =", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotEqualTo(String value) {
            addCriterion("city_no <>", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoGreaterThan(String value) {
            addCriterion("city_no >", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoGreaterThanOrEqualTo(String value) {
            addCriterion("city_no >=", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLessThan(String value) {
            addCriterion("city_no <", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLessThanOrEqualTo(String value) {
            addCriterion("city_no <=", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLike(String value) {
            addCriterion("city_no like", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotLike(String value) {
            addCriterion("city_no not like", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoIn(List<String> values) {
            addCriterion("city_no in", values, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotIn(List<String> values) {
            addCriterion("city_no not in", values, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoBetween(String value1, String value2) {
            addCriterion("city_no between", value1, value2, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotBetween(String value1, String value2) {
            addCriterion("city_no not between", value1, value2, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNamesIsNull() {
            addCriterion("city_names is null");
            return (Criteria) this;
        }

        public Criteria andCityNamesIsNotNull() {
            addCriterion("city_names is not null");
            return (Criteria) this;
        }

        public Criteria andCityNamesEqualTo(String value) {
            addCriterion("city_names =", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotEqualTo(String value) {
            addCriterion("city_names <>", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesGreaterThan(String value) {
            addCriterion("city_names >", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesGreaterThanOrEqualTo(String value) {
            addCriterion("city_names >=", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLessThan(String value) {
            addCriterion("city_names <", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLessThanOrEqualTo(String value) {
            addCriterion("city_names <=", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLike(String value) {
            addCriterion("city_names like", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotLike(String value) {
            addCriterion("city_names not like", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesIn(List<String> values) {
            addCriterion("city_names in", values, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotIn(List<String> values) {
            addCriterion("city_names not in", values, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesBetween(String value1, String value2) {
            addCriterion("city_names between", value1, value2, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotBetween(String value1, String value2) {
            addCriterion("city_names not between", value1, value2, "cityNames");
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

        public Criteria andCustomNamesIsNull() {
            addCriterion("custom_names is null");
            return (Criteria) this;
        }

        public Criteria andCustomNamesIsNotNull() {
            addCriterion("custom_names is not null");
            return (Criteria) this;
        }

        public Criteria andCustomNamesEqualTo(String value) {
            addCriterion("custom_names =", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesNotEqualTo(String value) {
            addCriterion("custom_names <>", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesGreaterThan(String value) {
            addCriterion("custom_names >", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesGreaterThanOrEqualTo(String value) {
            addCriterion("custom_names >=", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesLessThan(String value) {
            addCriterion("custom_names <", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesLessThanOrEqualTo(String value) {
            addCriterion("custom_names <=", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesLike(String value) {
            addCriterion("custom_names like", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesNotLike(String value) {
            addCriterion("custom_names not like", value, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesIn(List<String> values) {
            addCriterion("custom_names in", values, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesNotIn(List<String> values) {
            addCriterion("custom_names not in", values, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesBetween(String value1, String value2) {
            addCriterion("custom_names between", value1, value2, "customNames");
            return (Criteria) this;
        }

        public Criteria andCustomNamesNotBetween(String value1, String value2) {
            addCriterion("custom_names not between", value1, value2, "customNames");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesIsNull() {
            addCriterion("device_names is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesIsNotNull() {
            addCriterion("device_names is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesEqualTo(String value) {
            addCriterion("device_names =", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesNotEqualTo(String value) {
            addCriterion("device_names <>", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesGreaterThan(String value) {
            addCriterion("device_names >", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesGreaterThanOrEqualTo(String value) {
            addCriterion("device_names >=", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesLessThan(String value) {
            addCriterion("device_names <", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesLessThanOrEqualTo(String value) {
            addCriterion("device_names <=", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesLike(String value) {
            addCriterion("device_names like", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesNotLike(String value) {
            addCriterion("device_names not like", value, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesIn(List<String> values) {
            addCriterion("device_names in", values, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesNotIn(List<String> values) {
            addCriterion("device_names not in", values, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesBetween(String value1, String value2) {
            addCriterion("device_names between", value1, value2, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andDeviceNamesNotBetween(String value1, String value2) {
            addCriterion("device_names not between", value1, value2, "deviceNames");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table skxd_user_power
     *
     * @mbggenerated do_not_delete_during_merge Mon May 16 22:35:17 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table skxd_user_power
     *
     * @mbggenerated Mon May 16 22:35:17 CST 2016
     */
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