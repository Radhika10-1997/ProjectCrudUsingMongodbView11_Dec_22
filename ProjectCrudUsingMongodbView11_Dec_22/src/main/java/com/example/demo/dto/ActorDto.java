package com.example.demo.dto;

public class ActorDto extends JsogDtoBase {

    //@NotEmpty(message = "Name is mandatory")
    private String name;

    private String orgGuid;

    private String orgName;
    
    private String profile;

    public String getOrgName() {

        return orgName;
    }

    public void setOrgName(String orgName) {

        this.orgName = orgName;
    }

    public String getName() {

        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getOrgGuid() {

        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {

        this.orgGuid = orgGuid;
    }

   
    public String toString() {

        return "ActorDto [name=" + name + ", orgGuid=" + orgGuid + "]";
    }

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
