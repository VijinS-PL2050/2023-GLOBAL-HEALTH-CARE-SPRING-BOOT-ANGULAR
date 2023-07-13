package com.global.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.app.entity.TestReport;
import com.global.app.repo.IReportRepo;
@Service
public class ReportServiceImplementation implements IReportService {

	@Autowired
	private IReportRepo reportrepo;


	@Override
	public TestReport getReport(Integer tpId) {
		System.out.println("ooooo");
		return reportrepo.getreport(tpId);

  	}


	@Override
	public List<TestReport> getTestReportForPatient(Integer pId) {
		// TODO Auto-generated method stub
		return reportrepo.getTestReportForPatient(pId);
	}
}
