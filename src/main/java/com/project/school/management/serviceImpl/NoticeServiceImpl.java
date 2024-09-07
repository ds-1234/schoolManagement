package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.NoticeEntity;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.NoticeRepository;
import com.project.school.management.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public List<NoticeEntity> getList() {
		return this.noticeRepository.findAll();
	}

	@Override
	public NoticeEntity save(NoticeEntity notice) {
		String noticeId = generateNoticeId(notice);
		notice.setNoticeId(noticeId);
		return this.noticeRepository.save(notice);
	}

	private String generateNoticeId(NoticeEntity notice) {
		Random random = new Random();
		int randomNumber = 100 + random.nextInt(900);
		String noticeId = "NOT" + randomNumber;
		return noticeId;
	}

	@Override
	public NoticeEntity getNotice(Long id) {
		Optional<NoticeEntity> dbdata = this.noticeRepository.findById(id);
		if(dbdata.isPresent()) {
			return dbdata.get();
		}
		throw new NotExist();
	}

}
