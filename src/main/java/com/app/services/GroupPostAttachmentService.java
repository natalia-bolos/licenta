package com.app.services;

import com.app.entities.GroupPostAttachment;
import com.app.entities.PostAttachment;
import com.app.repositories.GroupPostAttachmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class GroupPostAttachmentService {

    private final GroupPostAttachmentRepository postAttachmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(GroupPostAttachmentService.class);

    public GroupPostAttachmentService(GroupPostAttachmentRepository postAttachmentRepository) {
        this.postAttachmentRepository = postAttachmentRepository;
    }

    public GroupPostAttachment storeFile(MultipartFile file, int postId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                logger.debug("Sorry! Filename contains invalid path sequence " + fileName);
            }

            GroupPostAttachment dbFile = new GroupPostAttachment(postId, fileName, file.getContentType(), file.getBytes());

            return postAttachmentRepository.save(dbFile);
        } catch (IOException ex) {
            logger.debug("Could not store file " + fileName + ". Please try again!");
        }
        return null;
    }

    public GroupPostAttachment getFile(int attachmentId) {
        return postAttachmentRepository.findById(attachmentId).get();
    }

    public List<GroupPostAttachment> getFiles(int postId) {
        return postAttachmentRepository.findByPostId(postId);
    }
}
