package ru.akbars.integro.creapp;

import java.net.InetAddress;
import javax.jws.WebService;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import ru.akbars.integro.dao.SingleFormatMapper;

@WebService(targetNamespace = "http://creapp.integro.akbars.ru/", endpointInterface = "ru.akbars.integro.creapp.SASCreditRegistryPort", portName = "SASCreditRegistryPortImplPort", serviceName = "SASCreditRegistryPortImplService")
public class SASCreditRegistryPortImpl implements SASCreditRegistryPort {

	public static final Logger log = Logger.getLogger(SASCreditRegistryPortImpl.class);
	private String iHostName;

	public SASCreditRegistryPortImpl() {
		log.info("Mosk SASCreditRegistryPortImpl statring ...");
		try {
			iHostName = InetAddress.getLocalHost().getHostName();
		} catch (Exception e1) {
			e1.printStackTrace();
			iHostName = "localhost";
		}
	}

	@Override
	public ResponseData executeRequest(RequestData requestData) {
		
		Long creId = null;
		SqlSession sqlSession = null;
		ru.akbars.integro.dao.SingleFormatMapper sfMapper = null;
		ResponseData resp = new ResponseData();

		System.out.println("MoskCRE - start");

		try {
			
			sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			sfMapper = sqlSession.getMapper(SingleFormatMapper.class);
			
			creId = sfMapper.nextCreId();
			System.out.println("creId: " + creId);
	
			Long rtdmId = requestData.getRtdmId();
			System.out.println("rtdmId: " + rtdmId);
			
			String applicantId = requestData.getApplicantId();
			System.out.println("applicantId: " + applicantId);
			
			String integroMethod = requestData.getIntegroMethod();
			System.out.println("integroMethod: " + integroMethod);
			
			sfMapper.callOrclProcedure(creId, rtdmId, applicantId, integroMethod);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.commit();
			}
		}
		
		System.out.println("MoskCRE - end");
		
		resp.setStatus(0);
		resp.setCreId(creId);
		return resp;

	}
}
