/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enzamul.ngoProjects.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 
 * @author MD ENZAMUL HOQ
 */
@Service
public class ReportSarvice {

    @Autowired
    ResourceLoader resourceLoader;

    public JasperPrint getReport() throws Exception {
        Map<String, Object> params = new HashMap();
        String path, pathString;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngosystem", "root", "")) {
            pathString = "classpath:/static/report/NgoSummary.jasper";
            path = resourceLoader.getResource(pathString).getURI().getPath();
            return JasperFillManager.fillReport(path, params, connection);
        }
    }
}
