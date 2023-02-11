package com.example.demo.domain;


import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.example.demo.data.graph.AbstractGraphNodeEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Radhika Mendhe
 *
 */
@JsonInclude(Include.NON_NULL)
public class Trade extends AbstractGraphNodeEntity implements ITrade {

    private String tradeName;

    private String tradeHash;

    private String tradeRgb;

    private String projectGuid;

    private String textColor;

    private long createdAt;

    private long updatedAt;

    @Relationship(type = "TRADE_OF", direction = Direction.OUTGOING)
    private Set<Activity> tradeActivity;

    @Relationship(type = "TRADE_OWNER_OF", direction = Direction.INCOMING)
    private Actor tradeOwner;

    private Integer srNumber;

    public Trade() {

        super();
        this.tradeActivity = new HashSet<>();
    }

    public String getTradeName() {

        return tradeName;
    }

    public void setTradeName(String tradeName) {

        this.tradeName = tradeName;
    }

    public String getTradeHash() {

        return tradeHash;
    }

    public void setTradeHash(String tradeHash) {

        this.tradeHash = tradeHash;
    }

    public String getTradeRgb() {

        return tradeRgb;
    }

    public void setTradeRgb(String tradeRgb) {

        this.tradeRgb = tradeRgb;
    }

    public long getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(long createdAt) {

        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {

        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {

        this.updatedAt = updatedAt;
    }

    public Set<Activity> getTradeActivity() {

        return tradeActivity;
    }

    public void setTradeActivity(Set<Activity> tradeActivity) {

        this.tradeActivity = tradeActivity;
    }

    @Override
    public String getProjectGuid() {

        return projectGuid;
    }

    @Override
    public void setProjectGuid(String projectGuid) {

        this.projectGuid = projectGuid;
    }

    public void addTradeActivity(Activity activity) {

        activity.setActivityTrade(this);
        tradeActivity.add(activity);
    }

    public void removeTradeActivity(Activity activity) {

        activity.setTradeGuid(null);
         activity.setActivityTrade(null);
        tradeActivity.remove(activity);
    }

    public void removeAllTradeActivity() {

        tradeActivity.forEach(act -> act.setTradeGuid(null));
        tradeActivity.clear();
    }
    
    public void addActivity(Activity activity) {

        activity.setTradeGuid(this.getGuid());
        this.tradeActivity.add(activity);
    }

    public Actor getTradeOwner() {

        return tradeOwner;
    }

    public void setTradeOwner(Actor tradeOwner) {

        this.tradeOwner = tradeOwner;
    }

    public String getTextColor() {

        return textColor;
    }

    public void setTextColor(String textColor) {

        this.textColor = textColor;
    }

    public Integer getSrNumber() {

        return srNumber;
    }

    public void setSrNumber(Integer srNumber) {

        this.srNumber = srNumber;
    }

}
