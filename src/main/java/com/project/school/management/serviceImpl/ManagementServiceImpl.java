package com.project.school.management.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.school.management.entity.EventEntity;
import com.project.school.management.entity.HolidayEntity;
import com.project.school.management.entity.MasterHoliday;
import com.project.school.management.entity.MasterLibrary;
import com.project.school.management.entity.MasterSports;
import com.project.school.management.entity.TransportEntity;
import com.project.school.management.exception.DataNotExist;
import com.project.school.management.exception.FieldAlreadyExist;
import com.project.school.management.exception.InvalidRequestException;
import com.project.school.management.repository.EventRepository;
import com.project.school.management.repository.HolidayRepository;
import com.project.school.management.repository.MasterHolidayRepository;
import com.project.school.management.repository.MasterLibraryRepository;
import com.project.school.management.repository.MasterSportsRepository;
import com.project.school.management.repository.TransportRepository;
import com.project.school.management.response.HolidayResponse;
import com.project.school.management.response.ResponseHandler;
import com.project.school.management.service.ManagementService;
import com.project.school.management.utility.Utils;

@Service
public class ManagementServiceImpl implements ManagementService{
	
	private static final Logger log = LoggerFactory.getLogger(ManagementServiceImpl.class);
	
	@Autowired
	private HolidayRepository holidayRepository;
	
	@Autowired
	private MasterHolidayRepository masterHolidayRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MasterLibraryRepository masterLibraryRepository;
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private MasterSportsRepository masterSportsRepository;
	
	@Autowired
	private TransportRepository transportRepository;

	@Override
	public ResponseEntity<Object> saveHoliday(HolidayEntity holidayEntity) throws IOException {
		log.info("++++inside save holiday method+++");
		String holidayId = utils.generateUniqueId(holidayEntity.getHolidayName());
		String str = "HL" + holidayId;
		holidayEntity.setHolidayId(str);
		String camelName = WordUtils.capitalizeFully(holidayEntity.getHolidayName());
		holidayEntity.setHolidayName(camelName);
		holidayEntity.setStatus(true);
		holidayRepository.save(holidayEntity);
		log.info("++++Holiday added successfully+++");
		return ResponseHandler.generateResponse("SUCCESS:Holiday added successfully", HttpStatus.OK, "", holidayEntity);
	}

	@Override
	public ResponseEntity<Object> getHoliday() throws IOException {
		log.info("++++inside get holiday method+++");
		List<HolidayEntity> holiday = holidayRepository.findByStatus(true);
		if(holiday==null) {
			log.error("++++data not available +++");
			throw new DataNotExist("Data not available");
		}
		List<HolidayResponse> list = new ArrayList<>();
		log.info("++++added data in for loop from list+++");
		for(HolidayEntity he: holiday) {
			HolidayResponse response = new HolidayResponse();
			MasterHoliday masterHoliday = masterHolidayRepository.findById(he.getHolidayType()).get();
			response.setHolidayType(masterHoliday.getMasterHolidayName());
			response.setHolidayId(he.getHolidayId());
			response.setHolidayName(he.getHolidayName());
			response.setStartDate(he.getStartDate());
			response.setEndDate(he.getEndDate());
			
			list.add(response);
		}
		log.info("++++Holiday list generated+++");
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", list);
	}

	@Override
	public ResponseEntity<Object> saveEvent(EventEntity eventEntity) throws IOException {
		log.info("++++inside save event method+++");
		String camelName = WordUtils.capitalizeFully(eventEntity.getEventName());
		eventEntity.setEventName(camelName);
		log.info("++++call generateUniqueId function+++");
		String eventId = utils.generateUniqueId(eventEntity.getEventName());
		String str = "EI" + eventId;
		eventEntity.setEventId(str);
		
		eventEntity.setStatus(true);
		eventRepository.save(eventEntity);
		log.info("++++Event api save successfully+++");
		return ResponseHandler.generateResponse("SUCCESS:Event added successfully", HttpStatus.OK, "", eventEntity);
	}

	@Override
	public ResponseEntity<Object> addBookInLibrary(MasterLibrary masterLibrary) throws IOException {
		log.info("++++Inside add book in master library method+++");
		String camelName = WordUtils.capitalizeFully(masterLibrary.getBookName());
		MasterLibrary book = masterLibraryRepository.findByBookName(camelName);
		System.out.println("book: "+book);
		if(book!=null) {
			log.error("+++Name of book already exist+++");
			throw new FieldAlreadyExist("Book already exist");
		}
		
		masterLibrary.setBookName(camelName);
		log.info("++++call generateUniqueId function inside book library+++");
		String bookId = utils.generateUniqueId(masterLibrary.getBookName());
		String str = "LB" + bookId;
		masterLibrary.setBookId(str);
		
		masterLibrary.setStatus(true);
		masterLibraryRepository.save(masterLibrary);
		log.info("++++Master Libarary  api save successfully+++");
		return ResponseHandler.generateResponse("SUCCESS:Book added successfully", HttpStatus.OK, "", masterLibrary);
	}

	@Override
	public ResponseEntity<Object> getBookList() throws IOException {
		log.info("++++inside get book list method+++");
		List<MasterLibrary> librList = masterLibraryRepository.findByStatus(true);
		log.info("++++library list generated+++");
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", librList);
	}

	@Override
	public ResponseEntity<Object> saveSports(MasterSports masterSportsRequest) throws IOException {
		log.info("++++inside save sports method+++");
		String camelName = WordUtils.capitalizeFully(masterSportsRequest.getSportsName());
		MasterSports sports = masterSportsRepository.findBySportsName(camelName);
		if(sports !=null) {
			log.error("+++Name of sports already exist+++");
			throw new FieldAlreadyExist("Sports Already Exist");
		}
		log.info("++++call generateUniqueId function inside master sports+++");
		String sportsId = utils.generateUniqueId(masterSportsRequest.getSportsName());
		String str = "SP" + sportsId;
		masterSportsRequest.setSportsId(str);
		masterSportsRequest.setSportsName(camelName);
		
		String coachCamelName = WordUtils.capitalizeFully(masterSportsRequest.getCoachName());
		masterSportsRequest.setCoachName(coachCamelName);
		
		LocalDateTime now = LocalDateTime.now();
		Date createDate = java.sql.Timestamp.valueOf(now);
		masterSportsRequest.setCreatedOnDateTime(createDate);
		
		masterSportsRequest.setStatus(true);
		masterSportsRepository.save(masterSportsRequest);
		log.info("++++Master Sports  api save successfully+++");
		return ResponseHandler.generateResponse("SUCCESS:Sports added successfully", HttpStatus.OK, "", masterSportsRequest);
	}

	@Override
	public ResponseEntity<Object> getSportsList() throws IOException {
		log.info("++++inside get sports list method+++");
		List<MasterSports> masterSportsList = masterSportsRepository.findByStatus(true);
		if(masterSportsList==null) {
			log.error("++++invalid request+++");
			throw new DataNotExist("There is no active sports available");
		}
		log.info("++++library list generated+++");
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", masterSportsList);
	}

	@Override
	public ResponseEntity<Object> getSportsById(String sportsId) {
		log.info("++++inside get sports by id method+++");
		if(sportsId==null) {
			log.error("++++invalid request+++");
			throw new InvalidRequestException("Invalid Request");
		}
		Optional<MasterSports> mSports =masterSportsRepository.findById(sportsId);
		MasterSports dbSport = mSports.get();
		log.info("++++sports generated by id+++");
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", dbSport);
	}

	@Override
	public ResponseEntity<Object> updateSports(MasterSports updateSportsRequest) throws IOException {
		log.info("++++inside updateSports method+++");
		if(updateSportsRequest.getSportsId()==null) {
			log.error("++++sportId not given as request+++");
			throw new InvalidRequestException("Invalid Request");
		}
		MasterSports maSports = masterSportsRepository.findBySportId(updateSportsRequest.getSportsId());
		if(maSports!=null) {
			log.info("******  call copyNonNullProperties function******");
			//utils.copyNonNullProperties(updateSportsRequest, maSports);
			maSports.setSportsName(WordUtils.capitalizeFully(updateSportsRequest.getSportsName()));
			maSports.setCoachName(WordUtils.capitalizeFully(updateSportsRequest.getCoachName()));
			maSports.setStartedYear(updateSportsRequest.getStartedYear());
			LocalDateTime now = LocalDateTime.now();
			Date updateDate = java.sql.Timestamp.valueOf(now);
			maSports.setUpdatedOnDateTime(updateDate);
			masterSportsRepository.save(maSports);
		}
		return ResponseHandler.generateResponse("SUCCESS", HttpStatus.OK, "", maSports);
	}

	@Override
	public ResponseEntity<Object> deleteSports(String sportsId) throws IOException {
		log.info("++++inside deleteSports method+++");
		if(sportsId==null) {
			log.error("++++sportId not given as request+++");
			throw new InvalidRequestException("Invalid Request");
		}
		Optional<MasterSports> maSports = masterSportsRepository.findById(sportsId);
		MasterSports dbSports=  maSports.get();
		if(dbSports==null) {
			log.error("++++data not available by sportsid+++");
			throw new DataNotExist("Data not present");
		}
		if(dbSports.isStatus()==true) {
			dbSports.setStatus(false);
		}
		masterSportsRepository.save(dbSports);
		log.info("++++sports deleted successfully+++");
		return ResponseHandler.generateResponse("SUCCESS: Data deleted", HttpStatus.OK, "", "");
	}

	@Override
	public ResponseEntity<Object> saveTransport(TransportEntity transportEntity) throws IOException {
		log.info("++++inside save transport method+++");
		if(transportEntity.getVehicleNumber()==null) {
			log.error("++++vehicle number should not be empty+++");
			throw new InvalidRequestException("Invalid Request");
		}
		if(transportRepository.findById(transportEntity.getVehicleNumber().toUpperCase()).isEmpty()) {
			transportEntity.setLicenseNumber(transportEntity.getLicenseNumber().toUpperCase());
			transportEntity.setVehicleNumber(transportEntity.getVehicleNumber().toUpperCase());
			transportEntity.setDriverName(WordUtils.capitalizeFully(transportEntity.getDriverName()));
			
			LocalDate now = LocalDate.now();
			Date date = java.sql.Date.valueOf(now);
			transportEntity.setCreatedOnDateTime(date);
			
			transportEntity.setStatus(true);
			transportRepository.save(transportEntity);
			log.info("++++transport api successfully saved+++");
			return ResponseHandler.generateResponse("SUCCESS: Data added", HttpStatus.OK, "", transportEntity);
		}
		return ResponseHandler.generateResponse("NOT SUCCESS: Data not added", HttpStatus.OK, "Vehicle number already exist", "");
	}


}
