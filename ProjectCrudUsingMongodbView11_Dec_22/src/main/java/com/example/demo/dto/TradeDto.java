package com.example.demo.dto;
//import javax.validation.constraints.NotEmpty;


/**
 * 
 * @author Radhika Mendhe
 *
 */
public class TradeDto extends JsogDtoBase {

    //@NotEmpty(message = "Trade Name is mandatory")
    private String tradeName;

   // @NotEmpty(message = "tradeHash is mandatory")
    private String tradeHash;

    private String tradeRgb;

    //@NotEmpty(message = "projectGuid is mandatory")
    private String projectGuid;

    private String ownerGuid;

  //  @NotEmpty(message = "Text color is mandatory")
    private String textColor;

    private Integer srNumber;

    public TradeDto() {

    }

    public TradeDto(String guid, String tradeName, String tradeHash, String tradeRgb,
            String projectGuid, String ownerGuid, String textColor, Integer srNumber) {

        this.guid = guid;
        this.tradeName = tradeName;
        this.tradeHash = tradeHash;
        this.tradeRgb = tradeRgb;
        this.projectGuid = projectGuid;
        this.ownerGuid = ownerGuid;
        this.textColor = textColor;
        this.srNumber = srNumber;
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

    public String getProjectGuid() {

        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {

        this.projectGuid = projectGuid;
    }

    public String getOwnerGuid() {

        return ownerGuid;
    }

    public void setOwnerGuid(String ownerGuid) {

        this.ownerGuid = ownerGuid;
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
