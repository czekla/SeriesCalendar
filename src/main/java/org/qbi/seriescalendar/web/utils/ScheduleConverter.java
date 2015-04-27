/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.model.Series;
import org.qbi.seriescalendar.web.model.xml.Schedule;
import org.qbi.seriescalendar.web.model.xml.ScheduleDay;

/**
 *
 * @author Qbi
 */
public class ScheduleConverter {

	final static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ScheduleConverter.class);
	
	private final static String BEGIN = "BEGIN:VEVENT";
	private final static String TIME = "DTSTART";
	private final static String TITLE = "CATEGORIES";
	private final static String END = "END:VEVENT";

	public static StreamedContent convertToXml(List<Day> daysOfWeek) {

		try {
			File outFile = File.createTempFile("tempfile", ".tmp");
			Schedule schedule = new Schedule();
			List<ScheduleDay> dayList = new ArrayList<>();
			for (Day day : daysOfWeek) {
				ScheduleDay sDay = new ScheduleDay();
				sDay.setName(day.getDay());
				List<String> titles = new ArrayList<>();
				for (Series series : day.getSeriesList()) {
					titles.add(series.getTitle());
				}
				sDay.setTitle(titles);
				dayList.add(sDay);
			}
			schedule.setDay(dayList);

			JAXBContext jAXBContext = JAXBContext.newInstance(Schedule.class);

			Marshaller marshaller = jAXBContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(schedule, outFile);
			// marshaller.marshal(schedule, System.out);

			InputStream stream = new FileInputStream(outFile);
			StreamedContent file = new DefaultStreamedContent(stream,
					"application/xml", "schedule.xml");
			return file;

		} catch (JAXBException ex) {
			Logger.getLogger(ScheduleConverter.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ScheduleConverter.class.getName()).log(
					Level.SEVERE, null, ex);
		}

		return null;
	}

	public static List<Day> convertToListFromXML(UploadedFile file) {

		try {
			JAXBContext jAXBContext = JAXBContext.newInstance(Schedule.class);

			Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
			Schedule schedule = (Schedule) unmarshaller.unmarshal(file
					.getInputstream());

			List<Day> days = new ArrayList<>();

			for (ScheduleDay sDay : schedule.getDay()) {

				String day = sDay.getName();

				List<Series> seriesList = new ArrayList<>();
				for (String s : sDay.getTitle()) {
					seriesList.add(new Series(day, s));
				}

				days.add(new Day(day, seriesList));
			}

			return days;

		} catch (JAXBException ex) {
			Logger.getLogger(ScheduleConverter.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ScheduleConverter.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return null;
	}

	public static List<Day> convertToListFromICS(UploadedFile file) {

		try {
			File tempFile = File.createTempFile("temp-ics", ".tmp");
			OutputStream outputStream = new FileOutputStream(tempFile);
			IOUtils.copy(file.getInputstream(), outputStream);
			try (BufferedReader br = new BufferedReader(
					new FileReader(tempFile))) {

				String line;

				List<Day> days = new ArrayList<>();
				
				days.add(new Day(getDayOfWeekString(2)));
				days.add(new Day(getDayOfWeekString(3)));
				days.add(new Day(getDayOfWeekString(4)));
				days.add(new Day(getDayOfWeekString(5)));
				days.add(new Day(getDayOfWeekString(6)));
				days.add(new Day(getDayOfWeekString(7)));
				days.add(new Day(getDayOfWeekString(1)));
				
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat();
				format.applyPattern("yyyymmddHHMMss");
				
				
				while ((line = br.readLine()) != null) {
					if (line.startsWith(BEGIN)){
						System.out.println(line);
						String day = "";
						String title = "";
						while ((line = br.readLine()) != null) {
							
							if (line.startsWith(TIME)){
								System.out.println(line);
								String timeString = line.replaceAll(TIME+":", "").replaceAll("T", "");
								cal.setTime(format.parse(timeString));
								int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
								day = getDayOfWeekString(day_of_week);
								System.out.println(day);
							}
							if (line.startsWith(TITLE)){
								System.out.println(line);
								title = line.replaceAll(TITLE+": ", "").replaceAll(" Episodes, TV Shows", "");
								System.out.println(title);
							}
							if (line.startsWith(END)){
								System.out.println(line);
								break;
							}
						}
						
						
						for (Day dayWeek : days) {
							if (dayWeek.isThatDay(day)){
								dayWeek.getSeriesList().add(new Series(day, title));
								break;
							}
						}

					}
				}

				return days;

			} catch (IOException e) {
				logger.debug(e);
			} catch (ParseException e) {
				logger.debug(e);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
	
	private static String getDayOfWeekString(int day){
		switch (day) {
		case Calendar.MONDAY:
			return "Monday";
		case Calendar.TUESDAY:
			return "Tuesday";
		case Calendar.WEDNESDAY:
			return "Wednesday";
		case Calendar.THURSDAY:
			return "Thursday";
		case Calendar.FRIDAY:
			return "Friday";
		case Calendar.SATURDAY:
			return "Saturday";
		case Calendar.SUNDAY:
			return "Sunday";
		default:
			return "";
		}
	}
	
	
}
