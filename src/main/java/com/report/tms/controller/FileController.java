package com.report.tms.controller;

import com.report.tms.model.Sub_Form;
import com.report.tms.service.UploadFileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/file")
@Tag(name="FileUploadAndDownload APIs", description = "download and upload test report")
public class FileController {
    @Autowired
    public UploadFileService uploadFileService;

    //--- UPLOAD FILE PASS
    @PostMapping("/upload")
    public ResponseEntity<?> fileUpload(@RequestParam("file")MultipartFile file){
        try {
            Sub_Form savedFormFile = uploadFileService.store(file);
            return ResponseEntity.ok("file uploaded successful" + savedFormFile.getId() + "" + savedFormFile.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("could not upload file");
        }
    }
    @GetMapping("/download/id")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id){
        Optional<Sub_Form> down = uploadFileService.getFileId(id);
        if (down.isPresent()){
            Sub_Form sub = down.get();
            return ResponseEntity.ok().header(HttpHeaders
                            .CONTENT_DISPOSITION,"attachment; filename=\""+ sub.getTitle()+"\"")
                    .contentType(MediaType.parseMediaType(sub.filetype))
                    .body(sub.getFileSize());


        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
}
