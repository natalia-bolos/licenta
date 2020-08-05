package com.app.services;

import com.app.entities.PostAttachment;
import com.app.repositories.PostAttachmentRepository;
import com.app.security.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostAttachmentService {

    private final PostAttachmentRepository postAttachmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(PostAttachmentService.class);

    public PostAttachmentService(PostAttachmentRepository postAttachmentRepository) {
        this.postAttachmentRepository = postAttachmentRepository;
    }

    public PostAttachment storeFile(MultipartFile file, int postId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                logger.debug("Sorry! Filename contains invalid path sequence " + fileName);
            }

            PostAttachment dbFile = new PostAttachment(postId, fileName, file.getContentType(), file.getBytes());

            return postAttachmentRepository.save(dbFile);
        } catch (IOException ex) {
            logger.debug("Could not store file " + fileName + ". Please try again!");
        }
        return null;
    }

    public PostAttachment getFile(int attachmentId) {
        return postAttachmentRepository.findById(attachmentId).get();
    }

    public List<PostAttachment> getFiles(int postId) {
        return postAttachmentRepository.findByPostId(postId);
    }

}
