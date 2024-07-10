package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpLoggerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IpLoggerController.class);

    @GetMapping("/log-ip")
    public String logIp(HttpServletRequest request, @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor) {
        String ipAddress = xForwardedFor != null ? xForwardedFor : request.getRemoteAddr();
        LOGGER.info("Request received from IP: {}", ipAddress);
        return "IP logged: " + ipAddress;
    }
}
