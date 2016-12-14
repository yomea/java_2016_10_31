package com.sorm.po;

import java.sql.*;
import java.util.*;

public class Act_evt_log {

	private String PROC_INST_ID_;
	private Integer IS_PROCESSED_;
	private java.sql.Timestamp LOCK_TIME_;
	private String PROC_DEF_ID_;
	private String USER_ID_;
	private null DATA_;
	private String EXECUTION_ID_;
	private String TYPE_;
	private Long LOG_NR_;
	private String TASK_ID_;
	private java.sql.Timestamp TIME_STAMP_;
	private String LOCK_OWNER_;


	public String getPROC_INST_ID_(){
		return PROC_INST_ID_;
	}
	public Integer getIS_PROCESSED_(){
		return IS_PROCESSED_;
	}
	public java.sql.Timestamp getLOCK_TIME_(){
		return LOCK_TIME_;
	}
	public String getPROC_DEF_ID_(){
		return PROC_DEF_ID_;
	}
	public String getUSER_ID_(){
		return USER_ID_;
	}
	public null getDATA_(){
		return DATA_;
	}
	public String getEXECUTION_ID_(){
		return EXECUTION_ID_;
	}
	public String getTYPE_(){
		return TYPE_;
	}
	public Long getLOG_NR_(){
		return LOG_NR_;
	}
	public String getTASK_ID_(){
		return TASK_ID_;
	}
	public java.sql.Timestamp getTIME_STAMP_(){
		return TIME_STAMP_;
	}
	public String getLOCK_OWNER_(){
		return LOCK_OWNER_;
	}
	public void setPROC_INST_ID_(String PROC_INST_ID_){
		this.PROC_INST_ID_=PROC_INST_ID_;
	}
	public void setIS_PROCESSED_(Integer IS_PROCESSED_){
		this.IS_PROCESSED_=IS_PROCESSED_;
	}
	public void setLOCK_TIME_(java.sql.Timestamp LOCK_TIME_){
		this.LOCK_TIME_=LOCK_TIME_;
	}
	public void setPROC_DEF_ID_(String PROC_DEF_ID_){
		this.PROC_DEF_ID_=PROC_DEF_ID_;
	}
	public void setUSER_ID_(String USER_ID_){
		this.USER_ID_=USER_ID_;
	}
	public void setDATA_(null DATA_){
		this.DATA_=DATA_;
	}
	public void setEXECUTION_ID_(String EXECUTION_ID_){
		this.EXECUTION_ID_=EXECUTION_ID_;
	}
	public void setTYPE_(String TYPE_){
		this.TYPE_=TYPE_;
	}
	public void setLOG_NR_(Long LOG_NR_){
		this.LOG_NR_=LOG_NR_;
	}
	public void setTASK_ID_(String TASK_ID_){
		this.TASK_ID_=TASK_ID_;
	}
	public void setTIME_STAMP_(java.sql.Timestamp TIME_STAMP_){
		this.TIME_STAMP_=TIME_STAMP_;
	}
	public void setLOCK_OWNER_(String LOCK_OWNER_){
		this.LOCK_OWNER_=LOCK_OWNER_;
	}
}
