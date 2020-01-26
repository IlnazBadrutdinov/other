package ru.akbars.integro.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SingleFormatMapper {
	
	@Select("select cre_id_seq.nextval from dual")
	Long nextCreId();
	
	void callOrclProcedure(
		@Param("creId") Long creId, 
		@Param("rtdmId") Long rtdmId, 
		@Param("applicantId") String applicantId, 
		@Param("integroMethod") String integroMethod
	);

}