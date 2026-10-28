package pl.bsjhx.katas.designpatterns.bridge;

import pl.bsjhx.katas.designpatterns.bridge.abstraction.AuditReport;
import pl.bsjhx.katas.designpatterns.bridge.abstraction.Report;
import pl.bsjhx.katas.designpatterns.bridge.abstraction.SalesReport;
import pl.bsjhx.katas.designpatterns.bridge.implementation.HtmlFormatter;
import pl.bsjhx.katas.designpatterns.bridge.implementation.PdfFormatter;

public class Bridge {

    public static void main(String[] args) {
        Report report = new AuditReport(new PdfFormatter());
        System.out.println(report.generate(50));

        report = new AuditReport(new HtmlFormatter());
        System.out.println(report.generate(50));

        report = new SalesReport(new PdfFormatter());
        System.out.println(report.generate(1000000));

        report = new SalesReport(new HtmlFormatter());
        System.out.println(report.generate(1000000));
    }
}
