package com.shinoaki.afdian.model.response.sponsor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shinoaki.afdian.model.response.Plans;
import com.shinoaki.afdian.model.response.UserInfo;
import lombok.Data;

import java.util.List;

@Data
public class SponsorList {
    /**
     * []数组类型，具体节点为多个赞助方案。
     */
    @JsonProperty("sponsor_plans")
    private List<Plans> sponsorPlans;
    /**
     * 当前赞助方案，如果节点仅有 name:""，不包含其它内容时，表示无方案
     */
    @JsonProperty("current_plan")
    private List<Plans> currentPlan;
    /**
     * 累计赞助金额，此处为折扣前金额。如有兑换码，则此处为虚拟金额，回比实际提现的多
     */
    @JsonProperty("all_sum_amount")
    private String allSumAmount;
    /**
     * 秒级时间戳，表示成为赞助者的时间，即首次赞助时间
     */
    @JsonProperty("first_pay_time")
    private long firstPayTime;
    /**
     * 秒级时间戳，最近一次赞助时间
     */
    @JsonProperty("last_pay_time")
    private long lastPayTime;
    /**
     * 用户属性
     */
    @JsonProperty("user")
    private UserInfo user;
}
