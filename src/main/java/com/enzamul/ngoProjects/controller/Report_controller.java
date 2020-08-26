/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enzamul.ngoProjects.controller;

import com.enzamul.ngoProjects.dto.ReportSarvice;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * sidebar page ta k
 * @author MD ENZAMUL HOQ
 */
@Controller
public class Report_controller {

    @Autowired
    ReportSarvice report_Sarvice;

    @GetMapping("/report")
    public String report() throws Exception {
        return "jasper_report/report_view";
    }
    @GetMapping("/pdf")
    public void data(HttpServletResponse response) throws Exception {
        JasperPrint report = this.report_Sarvice.getReport();
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(report, out);
    }
}
