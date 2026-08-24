package com.yatharth.smart_road.service;

import com.yatharth.smart_road.entity.Pothole;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    @Value("${smartroad.alert.email.recipient:admin@smartroad.in}")
    private String alertRecipientEmail;

    @Value("${spring.mail.username:smartroad.alerts@gmail.com}")
    private String fromEmail;

    public void sendPotholeNotification(Pothole pothole) {
        System.out.println("📬 EMAIL ALERT TRIGGERED for Pothole on: " + pothole.getRoadName());

        try {
            if (mailSender == null) {
                System.out.println("⚠️ JavaMailSender not configured. Email logged to console.");
                return;
            }

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom(fromEmail);
            helper.setTo(alertRecipientEmail);
            helper.setSubject("🚨 CRITICAL ALERT: New Pothole Hazard Reported on " + pothole.getRoadName());

            String htmlContent = "<html><body style='font-family: Arial, sans-serif; color: #1e293b; line-height: 1.6;'>"
                    + "<div style='max-width: 600px; margin: 0 auto; border: 1px solid #cbd5e1; border-radius: 16px; padding: 24px; background: #ffffff;'>"
                    + "<h2 style='color: #e11d48; margin-top: 0;'>🚨 New Road Hazard Alert</h2>"
                    + "<p style='font-size: 14px;'>A new pothole report has been submitted to the SmartRouteX AI Telemetry System.</p>"
                    + "<table style='width: 100%; border-collapse: collapse; margin: 20px 0;'>"
                    + "<tr><td style='padding: 8px; font-weight: bold; border-bottom: 1px solid #e2e8f0;'>Corridor Location:</td><td style='padding: 8px; border-bottom: 1px solid #e2e8f0;'>" + pothole.getRoadName() + "</td></tr>"
                    + "<tr><td style='padding: 8px; font-weight: bold; border-bottom: 1px solid #e2e8f0;'>Severity Rating:</td><td style='padding: 8px; border-bottom: 1px solid #e2e8f0; color: #e11d48; font-weight: bold;'>" + pothole.getSeverity() + "</td></tr>"
                    + "<tr><td style='padding: 8px; font-weight: bold; border-bottom: 1px solid #e2e8f0;'>Estimated Depth:</td><td style='padding: 8px; border-bottom: 1px solid #e2e8f0;'>" + (pothole.getDepth() != null ? pothole.getDepth() : "N/A") + "</td></tr>"
                    + "<tr><td style='padding: 8px; font-weight: bold; border-bottom: 1px solid #e2e8f0;'>GPS Coordinates:</td><td style='padding: 8px; border-bottom: 1px solid #e2e8f0; font-family: monospace;'>" + pothole.getLatitude() + ", " + pothole.getLongitude() + "</td></tr>"
                    + "<tr><td style='padding: 8px; font-weight: bold; border-bottom: 1px solid #e2e8f0;'>Reported At:</td><td style='padding: 8px; border-bottom: 1px solid #e2e8f0;'>" + (pothole.getReportedAt() != null ? pothole.getReportedAt() : "Just now") + "</td></tr>"
                    + "</table>"
                    + (pothole.getImageUrl() != null && !pothole.getImageUrl().isEmpty()
                        ? "<p><strong>Photo Evidence:</strong><br/><img src='" + pothole.getImageUrl() + "' style='max-width: 100%; border-radius: 12px; border: 1px solid #cbd5e1; margin-top: 8px;' /></p>"
                        : "")
                    + "<hr style='border: none; border-top: 1px solid #e2e8f0; margin-top: 24px;' />"
                    + "<p style='font-size: 11px; color: #64748b;'>SmartRouteX — Municipal Dispatch Unit</p>"
                    + "</div></body></html>";

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
            System.out.println("✅ Email alert sent successfully to: " + alertRecipientEmail);
        } catch (Exception e) {
            System.out.println("⚠️ Could not send SMTP email notification (Log captured): " + e.getMessage());
        }
    }
}
