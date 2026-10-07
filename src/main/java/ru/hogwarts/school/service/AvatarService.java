package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.repository.AvatarRepository;

@Service
public class AvatarService {

    private static final Logger logger = LoggerFactory.getLogger(AvatarService.class);

    private final AvatarRepository avatarRepository;

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public Page<Avatar> getAvatarsPage(int page, int size) {

        logger.debug("Invoked getAvatarsPage with page={}, size={}", page, size);
        logger.info("Fetching avatars page: page={}, size={}", page, size);

        if (page < 0 || size <= 0) {
            logger.warn("Invalid pagination parameters: page={}, size={}. Using defaults.", page, size);
            page = 0;
            size = 10;
        }

        Page<Avatar> avatars = avatarRepository.findAll(PageRequest.of(page, size));
        logger.debug("Fetched {} avatars for page={}", avatars.getTotalElements(), page);
        return avatars;

    }
}

