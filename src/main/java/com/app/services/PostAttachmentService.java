package com.app.services;

import com.app.entities.PostAttachment;
import com.app.repositories.PostAttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostAttachmentService {

    private final PostAttachmentRepository postAttachmentRepository;

    public PostAttachmentService(PostAttachmentRepository postAttachmentRepository) {
        this.postAttachmentRepository = postAttachmentRepository;
    }

    public PostAttachment storeFile(MultipartFile file, int postId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
            }

            PostAttachment dbFile = new PostAttachment(postId, fileName, file.getContentType(), file.getBytes());

            return postAttachmentRepository.save(dbFile);
        } catch (IOException ex) {
            System.out.println("Could not store file " + fileName + ". Please try again!");
        }
        return null;
    }

    public PostAttachment getFile(int attachmentId){
        return postAttachmentRepository.findById(attachmentId).get();
    }

    public List<PostAttachment> getFiles(int postId){
        return postAttachmentRepository.findByPostId(postId);
    }

}
