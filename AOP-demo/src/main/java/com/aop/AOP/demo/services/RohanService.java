package com.aop.AOP.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RohanService {
    public String geBooks() {
        log.info("Info for you");
        log.trace("This is a trace");
        log.debug("This is a debut");
        log.warn("Warning for you");
        log.error("OOPs! Error occured");
        return "This is a book";
    }
}
