package com.skxd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkxdTemplateInputExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkxdTemplateInputExample() {
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

        public Criteria andInputTypeIsNull() {
            addCriterion("input_type is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("input_type is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(String value) {
            addCriterion("input_type =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(String value) {
            addCriterion("input_type <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(String value) {
            addCriterion("input_type >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(String value) {
            addCriterion("input_type >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(String value) {
            addCriterion("input_type <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(String value) {
            addCriterion("input_type <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLike(String value) {
            addCriterion("input_type like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotLike(String value) {
            addCriterion("input_type not like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<String> values) {
            addCriterion("input_type in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<String> values) {
            addCriterion("input_type not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(String value1, String value2) {
            addCriterion("input_type between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(String value1, String value2) {
            addCriterion("input_type not between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputNameIsNull() {
            addCriterion("input_name is null");
            return (Criteria) this;
        }

        public Criteria andInputNameIsNotNull() {
            addCriterion("input_name is not null");
            return (Criteria) this;
        }

        public Criteria andInputNameEqualTo(String value) {
            addCriterion("input_name =", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameNotEqualTo(String value) {
            addCriterion("input_name <>", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameGreaterThan(String value) {
            addCriterion("input_name >", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameGreaterThanOrEqualTo(String value) {
            addCriterion("input_name >=", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameLessThan(String value) {
            addCriterion("input_name <", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameLessThanOrEqualTo(String value) {
            addCriterion("input_name <=", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameLike(String value) {
            addCriterion("input_name like", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameNotLike(String value) {
            addCriterion("input_name not like", value, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameIn(List<String> values) {
            addCriterion("input_name in", values, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameNotIn(List<String> values) {
            addCriterion("input_name not in", values, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameBetween(String value1, String value2) {
            addCriterion("input_name between", value1, value2, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputNameNotBetween(String value1, String value2) {
            addCriterion("input_name not between", value1, value2, "inputName");
            return (Criteria) this;
        }

        public Criteria andInputContentIsNull() {
            addCriterion("input_content is null");
            return (Criteria) this;
        }

        public Criteria andInputContentIsNotNull() {
            addCriterion("input_content is not null");
            return (Criteria) this;
        }

        public Criteria andInputContentEqualTo(String value) {
            addCriterion("input_content =", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentNotEqualTo(String value) {
            addCriterion("input_content <>", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentGreaterThan(String value) {
            addCriterion("input_content >", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentGreaterThanOrEqualTo(String value) {
            addCriterion("input_content >=", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentLessThan(String value) {
            addCriterion("input_content <", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentLessThanOrEqualTo(String value) {
            addCriterion("input_content <=", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentLike(String value) {
            addCriterion("input_content like", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentNotLike(String value) {
            addCriterion("input_content not like", value, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentIn(List<String> values) {
            addCriterion("input_content in", values, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentNotIn(List<String> values) {
            addCriterion("input_content not in", values, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentBetween(String value1, String value2) {
            addCriterion("input_content between", value1, value2, "inputContent");
            return (Criteria) this;
        }

        public Criteria andInputContentNotBetween(String value1, String value2) {
            addCriterion("input_content not between", value1, value2, "inputContent");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIsNull() {
            addCriterion("static_type is null");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIsNotNull() {
            addCriterion("static_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaticTypeEqualTo(String value) {
            addCriterion("static_type =", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotEqualTo(String value) {
            addCriterion("static_type <>", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeGreaterThan(String value) {
            addCriterion("static_type >", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeGreaterThanOrEqualTo(String value) {
            addCriterion("static_type >=", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeLessThan(String value) {
            addCriterion("static_type <", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeLessThanOrEqualTo(String value) {
            addCriterion("static_type <=", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeLike(String value) {
            addCriterion("static_type like", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotLike(String value) {
            addCriterion("static_type not like", value, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeIn(List<String> values) {
            addCriterion("static_type in", values, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotIn(List<String> values) {
            addCriterion("static_type not in", values, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeBetween(String value1, String value2) {
            addCriterion("static_type between", value1, value2, "staticType");
            return (Criteria) this;
        }

        public Criteria andStaticTypeNotBetween(String value1, String value2) {
            addCriterion("static_type not between", value1, value2, "staticType");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIsNull() {
            addCriterion("dictionary_id is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIsNotNull() {
            addCriterion("dictionary_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdEqualTo(String value) {
            addCriterion("dictionary_id =", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotEqualTo(String value) {
            addCriterion("dictionary_id <>", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThan(String value) {
            addCriterion("dictionary_id >", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("dictionary_id >=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThan(String value) {
            addCriterion("dictionary_id <", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLessThanOrEqualTo(String value) {
            addCriterion("dictionary_id <=", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdLike(String value) {
            addCriterion("dictionary_id like", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotLike(String value) {
            addCriterion("dictionary_id not like", value, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdIn(List<String> values) {
            addCriterion("dictionary_id in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotIn(List<String> values) {
            addCriterion("dictionary_id not in", values, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdBetween(String value1, String value2) {
            addCriterion("dictionary_id between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andDictionaryIdNotBetween(String value1, String value2) {
            addCriterion("dictionary_id not between", value1, value2, "dictionaryId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andIsStaticsIsNull() {
            addCriterion("is_statics is null");
            return (Criteria) this;
        }

        public Criteria andIsStaticsIsNotNull() {
            addCriterion("is_statics is not null");
            return (Criteria) this;
        }

        public Criteria andIsStaticsEqualTo(Integer value) {
            addCriterion("is_statics =", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsNotEqualTo(Integer value) {
            addCriterion("is_statics <>", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsGreaterThan(Integer value) {
            addCriterion("is_statics >", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_statics >=", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsLessThan(Integer value) {
            addCriterion("is_statics <", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsLessThanOrEqualTo(Integer value) {
            addCriterion("is_statics <=", value, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsIn(List<Integer> values) {
            addCriterion("is_statics in", values, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsNotIn(List<Integer> values) {
            addCriterion("is_statics not in", values, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsBetween(Integer value1, Integer value2) {
            addCriterion("is_statics between", value1, value2, "isStatics");
            return (Criteria) this;
        }

        public Criteria andIsStaticsNotBetween(Integer value1, Integer value2) {
            addCriterion("is_statics not between", value1, value2, "isStatics");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(String value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(String value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(String value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(String value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(String value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(String value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLike(String value) {
            addCriterion("step_id like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotLike(String value) {
            addCriterion("step_id not like", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<String> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<String> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(String value1, String value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(String value1, String value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andNextIsNull() {
            addCriterion("next is null");
            return (Criteria) this;
        }

        public Criteria andNextIsNotNull() {
            addCriterion("next is not null");
            return (Criteria) this;
        }

        public Criteria andNextEqualTo(String value) {
            addCriterion("next =", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextNotEqualTo(String value) {
            addCriterion("next <>", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextGreaterThan(String value) {
            addCriterion("next >", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextGreaterThanOrEqualTo(String value) {
            addCriterion("next >=", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextLessThan(String value) {
            addCriterion("next <", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextLessThanOrEqualTo(String value) {
            addCriterion("next <=", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextLike(String value) {
            addCriterion("next like", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextNotLike(String value) {
            addCriterion("next not like", value, "next");
            return (Criteria) this;
        }

        public Criteria andNextIn(List<String> values) {
            addCriterion("next in", values, "next");
            return (Criteria) this;
        }

        public Criteria andNextNotIn(List<String> values) {
            addCriterion("next not in", values, "next");
            return (Criteria) this;
        }

        public Criteria andNextBetween(String value1, String value2) {
            addCriterion("next between", value1, value2, "next");
            return (Criteria) this;
        }

        public Criteria andNextNotBetween(String value1, String value2) {
            addCriterion("next not between", value1, value2, "next");
            return (Criteria) this;
        }

        public Criteria andPreIsNull() {
            addCriterion("pre is null");
            return (Criteria) this;
        }

        public Criteria andPreIsNotNull() {
            addCriterion("pre is not null");
            return (Criteria) this;
        }

        public Criteria andPreEqualTo(String value) {
            addCriterion("pre =", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotEqualTo(String value) {
            addCriterion("pre <>", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThan(String value) {
            addCriterion("pre >", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThanOrEqualTo(String value) {
            addCriterion("pre >=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThan(String value) {
            addCriterion("pre <", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThanOrEqualTo(String value) {
            addCriterion("pre <=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLike(String value) {
            addCriterion("pre like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotLike(String value) {
            addCriterion("pre not like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreIn(List<String> values) {
            addCriterion("pre in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotIn(List<String> values) {
            addCriterion("pre not in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreBetween(String value1, String value2) {
            addCriterion("pre between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotBetween(String value1, String value2) {
            addCriterion("pre not between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNull() {
            addCriterion("is_required is null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNotNull() {
            addCriterion("is_required is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredEqualTo(Byte value) {
            addCriterion("is_required =", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotEqualTo(Byte value) {
            addCriterion("is_required <>", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThan(Byte value) {
            addCriterion("is_required >", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_required >=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThan(Byte value) {
            addCriterion("is_required <", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThanOrEqualTo(Byte value) {
            addCriterion("is_required <=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIn(List<Byte> values) {
            addCriterion("is_required in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotIn(List<Byte> values) {
            addCriterion("is_required not in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredBetween(Byte value1, Byte value2) {
            addCriterion("is_required between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotBetween(Byte value1, Byte value2) {
            addCriterion("is_required not between", value1, value2, "isRequired");
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