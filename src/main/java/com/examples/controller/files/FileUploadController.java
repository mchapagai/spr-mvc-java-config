package com.examples.controller.files;

import com.examples.model.files.FileBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {

    private static final String FILE_UPLOAD_VIEW = "files/file_upload_form";
    private static final String FILE_UPLOAD_VIEW_RESULT = "files/file_save_form";

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String displayUploadForm() {
        return FILE_UPLOAD_VIEW;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUploadFile(@ModelAttribute("fileBean") FileBean fileBean, Model model) {

        List<MultipartFile> files = fileBean.getFiles();

        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                // Handle file content - multipartFile.getInputStream()
            }
        }

        model.addAttribute("files", fileNames);
        return FILE_UPLOAD_VIEW_RESULT;
    }

}