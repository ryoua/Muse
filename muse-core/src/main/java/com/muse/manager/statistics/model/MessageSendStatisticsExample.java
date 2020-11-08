package com.muse.manager.statistics.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
** @Author: RyouA
** @Date: 2020/11/8
**/
public class MessageSendStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageSendStatisticsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMsidIsNull() {
            addCriterion("msid is null");
            return (Criteria) this;
        }

        public Criteria andMsidIsNotNull() {
            addCriterion("msid is not null");
            return (Criteria) this;
        }

        public Criteria andMsidEqualTo(Long value) {
            addCriterion("msid =", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotEqualTo(Long value) {
            addCriterion("msid <>", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidGreaterThan(Long value) {
            addCriterion("msid >", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidGreaterThanOrEqualTo(Long value) {
            addCriterion("msid >=", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidLessThan(Long value) {
            addCriterion("msid <", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidLessThanOrEqualTo(Long value) {
            addCriterion("msid <=", value, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidIn(List<Long> values) {
            addCriterion("msid in", values, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotIn(List<Long> values) {
            addCriterion("msid not in", values, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidBetween(Long value1, Long value2) {
            addCriterion("msid between", value1, value2, "msid");
            return (Criteria) this;
        }

        public Criteria andMsidNotBetween(Long value1, Long value2) {
            addCriterion("msid not between", value1, value2, "msid");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeIsNull() {
            addCriterion("receiver_size is null");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeIsNotNull() {
            addCriterion("receiver_size is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeEqualTo(Long value) {
            addCriterion("receiver_size =", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeNotEqualTo(Long value) {
            addCriterion("receiver_size <>", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeGreaterThan(Long value) {
            addCriterion("receiver_size >", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_size >=", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeLessThan(Long value) {
            addCriterion("receiver_size <", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeLessThanOrEqualTo(Long value) {
            addCriterion("receiver_size <=", value, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeIn(List<Long> values) {
            addCriterion("receiver_size in", values, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeNotIn(List<Long> values) {
            addCriterion("receiver_size not in", values, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeBetween(Long value1, Long value2) {
            addCriterion("receiver_size between", value1, value2, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSizeNotBetween(Long value1, Long value2) {
            addCriterion("receiver_size not between", value1, value2, "receiverSize");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessIsNull() {
            addCriterion("receiver_success is null");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessIsNotNull() {
            addCriterion("receiver_success is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessEqualTo(Long value) {
            addCriterion("receiver_success =", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessNotEqualTo(Long value) {
            addCriterion("receiver_success <>", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessGreaterThan(Long value) {
            addCriterion("receiver_success >", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_success >=", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessLessThan(Long value) {
            addCriterion("receiver_success <", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessLessThanOrEqualTo(Long value) {
            addCriterion("receiver_success <=", value, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessIn(List<Long> values) {
            addCriterion("receiver_success in", values, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessNotIn(List<Long> values) {
            addCriterion("receiver_success not in", values, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessBetween(Long value1, Long value2) {
            addCriterion("receiver_success between", value1, value2, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverSuccessNotBetween(Long value1, Long value2) {
            addCriterion("receiver_success not between", value1, value2, "receiverSuccess");
            return (Criteria) this;
        }

        public Criteria andReceiverFailIsNull() {
            addCriterion("receiver_fail is null");
            return (Criteria) this;
        }

        public Criteria andReceiverFailIsNotNull() {
            addCriterion("receiver_fail is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverFailEqualTo(Long value) {
            addCriterion("receiver_fail =", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailNotEqualTo(Long value) {
            addCriterion("receiver_fail <>", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailGreaterThan(Long value) {
            addCriterion("receiver_fail >", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver_fail >=", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailLessThan(Long value) {
            addCriterion("receiver_fail <", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailLessThanOrEqualTo(Long value) {
            addCriterion("receiver_fail <=", value, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailIn(List<Long> values) {
            addCriterion("receiver_fail in", values, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailNotIn(List<Long> values) {
            addCriterion("receiver_fail not in", values, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailBetween(Long value1, Long value2) {
            addCriterion("receiver_fail between", value1, value2, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andReceiverFailNotBetween(Long value1, Long value2) {
            addCriterion("receiver_fail not between", value1, value2, "receiverFail");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("`valid` is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("`valid` is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Byte value) {
            addCriterion("`valid` =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Byte value) {
            addCriterion("`valid` <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Byte value) {
            addCriterion("`valid` >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Byte value) {
            addCriterion("`valid` >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Byte value) {
            addCriterion("`valid` <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Byte value) {
            addCriterion("`valid` <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Byte> values) {
            addCriterion("`valid` in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Byte> values) {
            addCriterion("`valid` not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Byte value1, Byte value2) {
            addCriterion("`valid` between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Byte value1, Byte value2) {
            addCriterion("`valid` not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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