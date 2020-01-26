package ru.akbars.integro.creapp;

public class RequestData {
	protected String integroMethod;
	protected Long rtdmId;
	protected String applicantId;
	protected String uidList;
	public String getIntegroMethod() {
		return integroMethod;
	}
	public void setIntegroMethod(String integroMethod) {
		this.integroMethod = integroMethod;
	}
	public Long getRtdmId() {
		return rtdmId;
	}
	public void setRtdmId(Long rtdmId) {
		this.rtdmId = rtdmId;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getUidList() {
		return uidList;
	}
	public void setUidList(String uidList) {
		this.uidList = uidList;
	}
	
	
}
