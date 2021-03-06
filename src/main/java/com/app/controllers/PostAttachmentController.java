package com.app.controllers;

import com.app.entities.GroupPostAttachment;
import com.app.services.GroupPostAttachmentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class PostAttachmentController {

    private final GroupPostAttachmentService groupPostAttachmentService;

    public PostAttachmentController(GroupPostAttachmentService groupPostAttachmentService) {
        this.groupPostAttachmentService = groupPostAttachmentService;
    }

//    @PostMapping("/uploadFile/post/{id}")
//    public ResponseEntity uploadAttachment(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
//        return ResponseEntity.ok().body(postAttachmentService.storeFile(file, id));
//    }

    @PostMapping("/uploadFile/post/group/{id}")
    public ResponseEntity uploadGroupAttachment(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
        return ResponseEntity.ok().body(groupPostAttachmentService.storeFile(file, id));
    }

//    @PostMapping("/uploadMultipleFiles/post/{id}")
//    public void uploadMultipleAttachments(@RequestParam("files") MultipartFile[] files, @PathVariable Integer id) {
//        for (MultipartFile file : files) {
//            postAttachmentService.storeFile(file, id);
//        }
//    }


//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) {
//
//        PostAttachment dbFile = postAttachmentService.getFile(fileId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFile.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getName() + "\"")
//                .body(new ByteArrayResource(dbFile.getFile()));
//    }



    @GetMapping("/downloadFile/group/{fileId}")
    public ResponseEntity<Resource> downloadGroupFile(@PathVariable Integer fileId) {

        GroupPostAttachment dbFile = groupPostAttachmentService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getType()))
                .contentLength(dbFile.getFile().length)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getName())
                .body(new ByteArrayResource(dbFile.getFile()));
    }

//    @GetMapping("/downloadFile/post/{postId}")
//    public ResponseEntity<Resource> downloadFilesOfPost(@PathVariable Integer postId) throws IOException {
//
//        List<PostAttachment> dbFiles = postAttachmentService.getFiles(postId);
//        String name = "";
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        for (PostAttachment attachment : dbFiles) {
//            name = name + attachment.getName();
//            bos.write(attachment.getFile());
//        }
//        byte[] bytes = bos.toByteArray();
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(dbFiles.get(0).getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "name" + "\"")
//                .body(new ByteArrayResource(bytes));
//    }

    @GetMapping("/downloadFile/post/group/{postId}")
    public ResponseEntity<Resource> downloadFilesOfGroupPost(@PathVariable Integer postId) throws IOException {

        List<GroupPostAttachment> dbFiles = groupPostAttachmentService.getFiles(postId);
        String name = "";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for (GroupPostAttachment attachment : dbFiles) {
            name = name + attachment.getName();
            bos.write(attachment.getFile());
        }
        byte[] bytes = bos.toByteArray();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFiles.get(0).getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "name" + "\"")
                .body(new ByteArrayResource(bytes));
    }


}
