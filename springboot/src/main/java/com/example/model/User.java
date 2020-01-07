package com.example.model;

import java.util.Date;

public class User {
    private String CId;
    private String CLoginId;
    private String CPassword;
    private String CUserName;
    private String CComId;
    private String CDeptId;
    private String CEmail;
    private String CTel;
    private Integer NSfyx;
    private Integer NXssx;
    private Date DCjsj;
    private Date DXgsj;
    private String CCjr;
    private String CXgr;
    private Integer NType;
    
    

    public Integer getNType() {
		return NType;
	}

	public void setNType(Integer nType) {
		NType = nType;
	}

	public String getCUserName() {
		return CUserName;
	}

	public void setCUserName(String cUserName) {
		CUserName = cUserName;
	}

	public Integer getNSfyx() {
		return NSfyx;
	}

	public void setNSfyx(Integer nSfyx) {
		NSfyx = nSfyx;
	}

	public Integer getNXssx() {
		return NXssx;
	}

	public void setNXssx(Integer nXssx) {
		NXssx = nXssx;
	}

	public Date getDCjsj() {
		return DCjsj;
	}

	public void setDCjsj(Date dCjsj) {
		DCjsj = dCjsj;
	}

	public Date getDXgsj() {
		return DXgsj;
	}

	public void setDXgsj(Date dXgsj) {
		DXgsj = dXgsj;
	}

	public String getCXgr() {
		return CXgr;
	}

	public void setCXgr(String cXgr) {
		CXgr = cXgr;
	}

	public String getCCjr() {
        return CCjr;
    }

    public void setCCjr(String CCjr) {
        this.CCjr = CCjr;
    }

    public String getCComId() {
        return CComId;
    }

    public void setCComId(String CComId) {
        this.CComId = CComId;
    }

    public String getCDeptId() {
        return CDeptId;
    }

    public void setCDeptId(String CDeptId) {
        this.CDeptId = CDeptId;
    }

    public String getCEmail() {
        return CEmail;
    }

    public void setCEmail(String CEmail) {
        this.CEmail = CEmail;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCLoginId() {
        return CLoginId;
    }

    public void setCLoginId(String CLoginId) {
        this.CLoginId = CLoginId;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    public String getCTel() {
        return CTel;
    }

    public void setCTel(String CTel) {
        this.CTel = CTel;
    }
}
