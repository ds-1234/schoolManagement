package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.NoticeEntity;

public interface NoticeService {

	List<NoticeEntity> getList();

	NoticeEntity save(NoticeEntity notice);

	NoticeEntity getNotice(Long id);

}
