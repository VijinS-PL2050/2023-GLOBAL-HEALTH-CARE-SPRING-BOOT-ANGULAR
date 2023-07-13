package com.global.app.service;

import java.util.List;

import com.global.app.entity.MedicinePrescription;
import com.global.app.entity.TestPrescription;
import com.global.app.entity.TestReport;

public interface IReportService {

	public TestReport getReport(Integer tpId);

	public List<TestReport> getTestReportForPatient(Integer pId);

}
