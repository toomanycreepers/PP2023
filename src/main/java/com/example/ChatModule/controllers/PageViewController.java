package com.example.ChatModule.controllers;

import com.example.ChatModule.DTOs.DocumentLinkDTO;
import com.example.ChatModule.services.DocumentService;
import com.example.ChatModule.services.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
public class PageViewController {
    @Autowired
    private GraduateService gradService;
    @Autowired
    private DocumentService docService;
    @GetMapping("/sign")
    @ResponseBody
    public ModelAndView getSignPage() throws IOException {
        ModelAndView model = new ModelAndView("reg_auth");
        model.addObject("authToken", SecurityContextHolder.getContext().getAuthentication());
        return model;
    }
    @GetMapping("/grad_lk")
    @ResponseBody
    public ModelAndView getGradLkPage() throws IOException {
        ModelAndView model = new ModelAndView("grad_lk");

        Authentication userDetails = (SecurityContextHolder.getContext().getAuthentication());
        long gradId = gradService.getGradDtoByMail(userDetails.getName()).getId();
        List<DocumentLinkDTO> docs = docService.getDocumentsByGraduate(gradId);

        model.addObject("gradDocLinks", docService.getDocumentsByGraduate(gradId));
        model.addObject("grad", gradService.getGradDtoByMail(userDetails.getName()));

        return model;
    }
}
